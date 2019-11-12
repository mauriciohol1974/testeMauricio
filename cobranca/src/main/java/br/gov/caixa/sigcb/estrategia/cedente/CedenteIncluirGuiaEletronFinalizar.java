package br.gov.caixa.sigcb.estrategia.cedente;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.iso.MainframeExtension;
import br.gov.caixa.sigcb.bean.CedenteEletronicoBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.Util;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente - Guia
 * Cedente Eletronico
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>18/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirGuiaEletronFinalizar extends
        CedenteIncluirEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        CedenteEletronicoBean eletronBean = (CedenteEletronicoBean) (new CedenteEletronicoBean()).getRequestBean(request);
        CedenteEletronicoBean resposta = (CedenteEletronicoBean) (new CedenteEletronicoBean()).newBean();

        // seta novamente o bean para caso aconteca algum problema os dados nao
        // se perderem
        request.setAttribute(CEDENTE_ELETRONICO_TESTE_BEAN, eletronBean);

        InformacoesUsuarioBean usuarioLDAP = (InformacoesUsuarioBean) request.getSession().getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
        
        String tipoUsuario = "N";
        if (usuarioLDAP.getNomeGrupo().equalsIgnoreCase("GCBADM")){
        	tipoUsuario = "S";
        }
        
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        eletronBean.setSituacao(new Long(1)); // 1 - Teste
        eletronBean.setTipoUsuario(tipoUsuario);
        String strRecordset = this.montaRecordset(eletronBean);

        eletronBean.setSolicitacaoEnvio("");
        eletronBean.setStrRecordset(strRecordset);
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR_CEDENTE_ELETRONICO + usuarioBean.getCodigoUsuario().toUpperCase();

        BeanList blResposta = handler.executeSimpleTransactionQuery(eletronBean, transUser);

        // Verifica criticas
        if (blResposta.size() > 0) {
            resposta = (CedenteEletronicoBean) blResposta.get(0);
        }

        // se inclusao com sucesso avanca a guia em cadastramento
        // e nao houver criticas
        if (eletronBean.getTipoAcao().equals("I")
            && resposta.getDescricaoCriticas().trim().equals("")) {
            CedenteIncluirGuiaControle.avancaGuiaEmCadastramento(request);
            CedenteIncluirGuiaControle.setCedenteEletronicoCadastrado(request,
                    true);
        }

        return CedenteIncluirGuiaControle.proximaGuia(request,
                resposta.getDescricaoCriticas(),
                PAGE_INCLUIR_CEDENTE_ELETRONICO,
                PAGE_INCLUIR_PRINCIPAL);
    }

    // Monta o recordset de subida de acordo com os dados do bean
    private String montaRecordset(CedenteEletronicoBean eletronBean) {
        String recordset = "";

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
        int tamCaixaPostal = eletronExtension.get("caixaPostal").getLength();
        int tamApelidoCopia = eletronExtension.get("apelidoCopia").getLength();
        int tamArquivoRetornoCopia = eletronExtension.get("arquivoRetornoCopia")
                .getLength();
        int tamNumeroProximaRemessa = eletronExtension.get("numeroProximaRemessa")
                .getLength();
        int tamAgrupamento = eletronExtension.get("agrupamento").getLength();
        int tamNumeroUltimoRetorno = eletronExtension.get("numeroUltimoRetorno")
                .getLength();
        int tamDataEnvioReenvio = eletronExtension.get("dataEnvioReenvio").getLength();

        // Completando com zeros e espacos
        recordset += Util.zerosEsquerda(eletronBean.getAplicativo(),
                tamAplicativo);
        recordset += Util.completaEspacos(eletronBean.getVersao(), tamVersao);
        recordset += Util.zerosEsquerda(eletronBean.getTipoTransmissao(),
                tamTipoTransmissao);
        recordset += Util.zerosEsquerda(eletronBean.getPadraoArquivo(),
                tamPadraoArquivo);
        recordset += Util.zerosEsquerda(eletronBean.getSituacao(), tamSituacao);
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
        recordset += Util.completaEspacos(eletronBean.getApelido(), tamApelido);
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
        //recordset += Util.completaEspacos(eletronBean.getDataEnvioReenvio(),tamDataEnvioReenvio);
        
        if (eletronBean.getVan()==16){
        	Date data = new Date();  
    		SimpleDateFormat formatador = new SimpleDateFormat("dd.MM.yyyy");  
    		
    		formatador.format(data);
       	    recordset += Util.completaEspacos(formatador.format(data),10);	
        }else{
       	  recordset += Util.completaEspacos("01.01.2011",10);
        }
        recordset += Util.zerosEsquerda(Long.parseLong(eletronBean.getCodConnect()), 2);
        
        recordset += Util.zerosEsquerda(Long.parseLong(eletronBean.getCodInternet()), 2);  //--> Cod Internet
        recordset += eletronBean.getRetOnline();  //-->> Retorno On line Sim / Nao
        recordset += Util.zerosEsquerda(eletronBean.getNumUltRetOnline(), 8);   //--> Num. Retorno On Line
        recordset += eletronBean.getRemOnline();  //-->> Retorno On line Sim / Nao
        recordset += eletronBean.getWebservice();  //-->> WebService Sim / Nao
        StringBuffer sb = new StringBuffer(recordset);
        while (sb.length() < 249) {
            sb.append(" ");
        }
        
        

        return sb.toString();
    }

}
