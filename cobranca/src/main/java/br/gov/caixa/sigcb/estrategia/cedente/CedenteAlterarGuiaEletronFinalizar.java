package br.gov.caixa.sigcb.estrategia.cedente;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.iso.MainframeExtension;
import br.gov.caixa.sigcb.bean.CedenteEletronicoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuia;
import br.gov.caixa.sigcb.regras.historicoGuias.HistoricoGuiaSimpleFactory;
import br.gov.caixa.sigcb.util.Util;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Alterar Cedente - Guia
 * Cedente Eletronico
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteAlterarGuiaEletronFinalizar extends
        CedenteAlterarEstrategia {

    private HistoricoGuia historicoGuiaCedenteEletronico;

    private HistoricoGuia historicoGuiaCedenteEletronicoAgrup;

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.historicoGuiaCedenteEletronico = HistoricoGuiaSimpleFactory.createHistoricoGuiaLogger(HistoricoGuia.GUIA_CEDENTE_ELETRONICO);
        this.historicoGuiaCedenteEletronicoAgrup = HistoricoGuiaSimpleFactory.createHistoricoGuiaLogger(HistoricoGuia.GUIA_CEDENTE_ELETRONICO_AGRUP);

        
        InformacoesUsuarioBean usuarioLDAP = (InformacoesUsuarioBean) request.getSession().getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);

        this.configMsgSucessoErro(request);
        String tipoUsuario = "N";
        if (usuarioLDAP.getNomeGrupo().equalsIgnoreCase("GCBADM")){
        	tipoUsuario = "S";
        }

        CedenteEletronicoBean testeBean = (CedenteEletronicoBean) (new CedenteEletronicoBean()).getRequestBean(request);
        CedenteEletronicoBean producaoBean = this.getRequestCedEletronProducaoBean(request);
        CedenteEletronicoBean resposta = (CedenteEletronicoBean) (new CedenteEletronicoBean()).newBean();

        // seta novamente o bean para caso aconteca algum problema os dados nao
        // se perderem
        request.setAttribute(CEDENTE_ELETRONICO_TESTE_BEAN, testeBean);
        request.setAttribute(CEDENTE_ELETRONICO_PRODUCAO_BEAN, producaoBean);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        testeBean.setSituacao(new Long(1)); // 1 - Teste
        testeBean.setTipoAcao(ALTERACAO);
        testeBean.setTipoUsuario(tipoUsuario);

        producaoBean.setSituacao(new Long(2)); // 2 - Producao
        producaoBean.setTipoAcao(ALTERACAO);
        producaoBean.setTipoUsuario(tipoUsuario);

        ArrayList alBeans = new ArrayList();

        // se foi de teste para producao, soh salva o de teste como de producao
        if (testeBean.getSolicitacaoEnvio().equals("S")) {
            // senao o de teste vira o de producao
            testeBean.setSituacao(new Long(2)); // 2 - Producao
            //testeBean.setNumeroUltimoRetorno(producaoBean.getNumeroUltimoRetorno()); 20090513
            //testeBean.setNumeroProximaRemessa(producaoBean.getNumeroProximaRemessa()); 20090513
            producaoBean.setNumeroUltimoRetorno(testeBean.getNumeroUltimoRetorno());
            producaoBean.setNumeroProximaRemessa(testeBean.getNumeroProximaRemessa());
            alBeans.add(testeBean);
            // se foi de producao para teste, soh salva o de producao como teste
        } else if (producaoBean.getSolicitacaoEnvio().equals("S")) {
            producaoBean.setSituacao(new Long(1)); // 1 - Teste
            alBeans.add(producaoBean);
        } else {

            if ("S".equals(producaoBean.getCadastrado())) {
                alBeans.add(producaoBean);
            }
            if (("S".equals(testeBean.getCadastrado()))
                || ("T".equals(testeBean.getCadastrado()))) {
                alBeans.add(testeBean);
            }

        }

        String strRecordset = this.montaRecordset(alBeans);

        testeBean.setStrRecordset(strRecordset);
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR_CEDENTE_ELETRONICO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList blResposta = handler.executeSimpleTransactionQuery(testeBean,transUser);

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteEletronicoBean) blResposta.get(0);
        } else {
            // Obtendo dados da guia geral para saber tipo de Cobranca
            // CedenteGeralBean geralBean = (CedenteGeralBean) (new
            // CedenteGeralBean()).getRequestBean(request);
            // CedenteGeralBean geralBeanTransacoesGuias = (CedenteGeralBean)
            // (new
            // CedenteGeralBean()).getSessionBean(request,CEDENTE_GERAL_BEAN_TRANSACOES_GUIAS
            // );
            // BeanList beanList =
            // this.historicoGuiaCedenteEletronico.logDadosGuia(geralBeanTransacoesGuias,
            // handler, TRANSACAO_FINALIZAR_ALTERACAO_PARTE_2);
            // request.getSession().setAttribute(LOG_CEDENTE_GUIAS_BEAN,
            // beanList.get(0));//A ser usado na BGH8 - Finalizazao Guia
            // Conclusao
            // this.historicoGuiaCedenteEletronicoAgrup.logDadosGuia(geralBeanTransacoesGuias,
            // handler, TRANSACAO_FINALIZAR_ALTERACAO_PARTE_2);

            LinkedList<HistoricoGuia> listaGuiasAlteradas = (LinkedList<HistoricoGuia>) request.getSession()
                    .getAttribute(LISTA_GUIAS_ALTERADAS);
            listaGuiasAlteradas.add(this.historicoGuiaCedenteEletronico);
            listaGuiasAlteradas.add(this.historicoGuiaCedenteEletronicoAgrup);
        }

        // Condição especial para usuários do CIATI
        // 28/02/2008
        if (usuarioLDAP.getNomeGrupo().equals("GCBATE")) {
            return CedenteAlterarGuiaControle.proximaGuia(request,
                    resposta.getDescricaoCriticas(),
                    PAGE_ALTERAR_CEDENTE_ELETRONICO_CIATI,
                    PAGE_ALTERAR_PRINCIPAL_CIATI);
        } else {
            return CedenteAlterarGuiaControle.proximaGuia(request,
                    resposta.getDescricaoCriticas(),
                    PAGE_ALTERAR_CEDENTE_ELETRONICO,
                    PAGE_ALTERAR_PRINCIPAL);
        }
    }

    /*
     * private CedenteEletronicoBean
     * getCedenteEletronicoProducao(HttpServletRequest request) throws Exception {
     * CedenteEletronicoBean producaoBean =
     * this.getRequestCedEletronProducaoBean(request);
     * producaoBean.setSituacao(new Long(2)); // 2 - Producao
     * producaoBean.setTipoAcao(ALTERACAO); return producaoBean; }
     */

    /**
     * O nome dos campos da tela sao diferentes dos atributos do bean para o
     * cedente eletronico em producao por isso nao eh possivel usar o
     * getRequestBean
     */
    private CedenteEletronicoBean getRequestCedEletronProducaoBean(HttpServletRequest request)
            throws Exception {
        CedenteEletronicoBean producaoBean = (CedenteEletronicoBean) new CedenteEletronicoBean().newBean();
        Enumeration enumerated = request.getParameterNames();

        Layout layout = producaoBean.getLayout();

        while (enumerated.hasMoreElements()) {
            String nomeCampo = (String) enumerated.nextElement();

            // Os campos de Cedente Eletronico em Producao tem o mesmo nome dos
            // atributos do bean
            // com "Producao" no final
            if (nomeCampo.endsWith("Producao")) {
                String beanAtributo = nomeCampo.substring(0, nomeCampo.indexOf("Producao"));
                Property property = layout.get(beanAtributo);
                String value = request.getParameter(nomeCampo);
                if (value != null && !value.equals("")) {
                    producaoBean.setPropertyValue(beanAtributo, property.convert(value));
                }
            }
        }

        (new CedenteEletronicoBean()).initBean(producaoBean);

        return producaoBean;
    }

    // Monta o recordset de subida de acordo com os dados dos beans do arraylist
    private String montaRecordset(ArrayList alEletronBean) {
        String recordset = "";

        for (int i = 0; i < alEletronBean.size(); i++) {
            CedenteEletronicoBean eletronBean = (CedenteEletronicoBean) alEletronBean.get(i);

            // tamanho dos campos
            Layout eletronLayout = eletronBean.getLayout();
            MainframeExtension eletronExtension = ((MainframeExtension) eletronLayout.getExtension("Mainframe"));

            int tamAplicativo = eletronExtension.get("aplicativo").getLength();
            int tamVersao = eletronExtension.get("versao").getLength();
            int tamTipoTransmissao = eletronExtension.get("tipoTransmissao")
                    .getLength();
            int tamSituacao = eletronExtension.get("situacao").getLength();
            int tamPadraoArquivo = eletronExtension.get("padraoArquivo")
                    .getLength();
            int tamAtribuicaoVan = eletronExtension.get("atribuicaoVan")
                    .getLength();
            int tamVan = eletronExtension.get("van").getLength();
            int tamJuncaoArquivoRetorno = eletronExtension.get("juncaoArquivoRetorno")
                    .getLength();
            int tamCedenteJuncao = eletronExtension.get("cedenteJuncao")
                    .getLength();
            int tamPerfilRejeicao = eletronExtension.get("perfilRejeicao")
                    .getLength();
            int tamPreCritica = eletronExtension.get("preCritica").getLength();
            int tamApelido = eletronExtension.get("apelido").getLength();
            int tamArquivoRetorno = eletronExtension.get("arquivoRetorno")
                    .getLength();
            int tamCopiaArquivoRetorno = eletronExtension.get("copiaArquivoRetorno")
                    .getLength();
            int tamCaixaPostal = eletronExtension.get("caixaPostal")
                    .getLength();
            int tamApelidoCopia = eletronExtension.get("apelidoCopia")
                    .getLength();
            int tamArquivoRetornoCopia = eletronExtension.get("arquivoRetornoCopia")
                    .getLength();
            int tamNumeroProximaRemessa = eletronExtension.get("numeroProximaRemessa")
                    .getLength();
            int tamAgrupamento = eletronExtension.get("agrupamento")
                    .getLength();
            int tamNumeroUltimoRetorno = eletronExtension.get("numeroUltimoRetorno")
                    .getLength();
           

            // Completando com zeros e espacos
            recordset += Util.zerosEsquerda(eletronBean.getAplicativo(),
                    tamAplicativo);
            recordset += Util.completaEspacos(eletronBean.getVersao(),
                    tamVersao);
            recordset += Util.zerosEsquerda(eletronBean.getTipoTransmissao(),
                    tamTipoTransmissao);
            recordset += Util.zerosEsquerda(eletronBean.getPadraoArquivo(),
                    tamPadraoArquivo);
            recordset += Util.zerosEsquerda(eletronBean.getSituacao(),
                    tamSituacao);
            recordset += Util.zerosEsquerda(eletronBean.getAtribuicaoVan(),
                    tamAtribuicaoVan);
            recordset += Util.zerosEsquerda(eletronBean.getVan(), tamVan);
            recordset += Util.completaEspacos(eletronBean.getJuncaoArquivoRetorno(),
                    tamJuncaoArquivoRetorno);
            recordset += Util.zerosEsquerda(eletronBean.getCedenteJuncao(),
                    tamCedenteJuncao);
            recordset += Util.zerosEsquerda(eletronBean.getPerfilRejeicao(),
                    tamPerfilRejeicao);
            recordset += Util.completaEspacos(eletronBean.getPreCritica(),
                    tamPreCritica);
            recordset += Util.completaEspacos(eletronBean.getApelido(),
                    tamApelido);
            recordset += Util.completaEspacos(eletronBean.getArquivoRetorno(),
                    tamArquivoRetorno);
            recordset += Util.completaEspacos(eletronBean.getCopiaArquivoRetorno(),
                    tamCopiaArquivoRetorno);
            recordset += Util.zerosEsquerda(eletronBean.getCaixaPostal(),
                    tamCaixaPostal);
            recordset += Util.completaEspacos(eletronBean.getApelidoCopia(),
                    tamApelidoCopia);
            recordset += Util.completaEspacos(eletronBean.getArquivoRetornoCopia(),
                    tamArquivoRetornoCopia);
            recordset += Util.zerosEsquerda(eletronBean.getNumeroProximaRemessa(),
                    tamNumeroProximaRemessa);
            recordset += Util.zerosEsquerda(eletronBean.getAgrupamento(),
                    tamAgrupamento);
            recordset += Util.zerosEsquerda(eletronBean.getNumeroUltimoRetorno(),
                    tamNumeroUltimoRetorno);
            //Incluído campo Dt. Envio/Reenvio
           
            if (eletronBean.getVan()==16){
            	Date data = new Date();  
        		SimpleDateFormat formatador = new SimpleDateFormat("dd.MM.yyyy");  
        		
        		formatador.format(data);
           	    recordset += Util.completaEspacos(formatador.format(data),10);
            	 	
            }else{
            	 recordset += Util.completaEspacos("01.01.2011",10);
            }
           
            recordset += Util.zerosEsquerda(Long.parseLong(eletronBean.getCodConnect()), 2);
            
            //Dados novos na BG10
            
            recordset += Util.zerosEsquerda(Long.parseLong(eletronBean.getCodInternet()), 2);  //--> Cod Internet
            recordset += eletronBean.getRetOnline();  //-->> Retorno On line Sim / Nao
            recordset += Util.zerosEsquerda(eletronBean.getNumUltRetOnline(), 8);   //--> Num. Retorno On Line
            recordset += eletronBean.getRemOnline();  //-->> Retorno On line Sim / Nao
            recordset += eletronBean.getWebservice();  //-->> WebService Sim / Nao
            
        }

        StringBuffer sb = new StringBuffer(recordset);
        while (sb.length() < 296) {
            sb.append(" ");
        }

        return sb.toString();
    }

}
