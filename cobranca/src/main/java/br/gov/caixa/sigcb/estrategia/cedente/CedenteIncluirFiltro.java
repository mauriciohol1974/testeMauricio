package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteEletronicoBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedentePrincipalBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Cedente >>
 * Filtro
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>11/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteIncluirFiltro extends CedenteEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        this.configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        // Se fluxo normal chama transacoes
        // senao nao faz nada, os beans ja devem existir no ambiente
        CedenteGeralBean beanFiltro = new CedenteGeralBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            beanFiltro = (CedenteGeralBean) beanFiltro.getRequestBean(request);

            // seta o bean do filtro no ambiente
            request.getSession().setAttribute(INCLUIR_FILTRO_BEAN, beanFiltro);

            // Obtendo informacao para continuar cadastro de cedente
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_SITUACAO_CADASTRO + usuarioBean.getCodigoUsuario().toUpperCase();
            // verificando guia em cadastramento
            BeanList respostaList = handler.executeSimpleTransactionQuery(beanFiltro,transUser);
            CedenteGeralBean respostaBean = (CedenteGeralBean) respostaList.get(0);

            // criando bean de controle de guias
            CedentePrincipalBean principalBean = (CedentePrincipalBean) (new CedentePrincipalBean()).newBean();
            principalBean.setUltimaGuiaCadastrada(respostaBean.getUltimaGuiaCadastrada());

            // verificando se pode cadastrar cedente eletronico
            /*
             * int guiaInclusao =
             * principalBean.getUltimaGuiaCadastrada().intValue() + 1; if
             * (guiaInclusao > CedenteEstrategia.GUIA_GERAL) { CedenteGeralBean
             * geralBean = (new
             * CedenteIncluirGuiaControle()).guiaGeralIniciar(CedenteEstrategia.ALTERACAO_EM_INCLUSAO,
             * request);
             * principalBean.setTipoCobranca(geralBean.getTipoCobranca()); } if
             * (guiaInclusao == CedenteEstrategia.GUIA_CEDENTE_ELETRONICO &&
             * CedenteEstrategia.COBRANCA_CONVENCIONAL.equals(principalBean.getTipoCobranca())) {
             * principalBean.setUltimaGuiaCadastrada(new
             * Integer(principalBean.getUltimaGuiaCadastrada().intValue() + 1)); }
             */

            this.ajustaGuiasCedenteEletronico(request,
                    principalBean,
                    beanFiltro);

            request.getSession().setAttribute(CEDENTE_PRINCIPAL_BEAN,
                    principalBean);

            // Obtendo dados de cabecalho
            CedenteCabecaBean cedenteCabecaBean = (CedenteCabecaBean) (new CedenteCabecaBean()).newBean();
            cedenteCabecaBean.setTipoConsulta(new Long(2)); // 2 - Consulta Por

            cedenteCabecaBean.setCodigoCedente(new Long(0));
            cedenteCabecaBean.setCodigoClienteCOCLI(beanFiltro.getCodigoClienteCOCLI());
            cedenteCabecaBean.setCodigoUsuario(this.getCodigoUsuario(request));
            cedenteCabecaBean.setOrigemConsulta(new Long(1)); // 1 - Intranet
            
            transUser = TRANSACAO_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
            respostaList = handler.executeSimpleTransactionQuery(cedenteCabecaBean,
            		transUser);
            cedenteCabecaBean = (CedenteCabecaBean) respostaList.get(0);

            // seta o bean de cabecalho
            request.getSession().setAttribute(CEDENTE_CABECA_BEAN,
                    cedenteCabecaBean);

            this.limpaBeans(request);
        }
        
        LogUtilSigcb.info("Chamou a página:" + PAGE_INCLUIR_PRINCIPAL);

        return PAGE_INCLUIR_PRINCIPAL;
    }

    // Limpa beans da pagina de inclusao
    private void limpaBeans(HttpServletRequest request) {
        request.getSession().setAttribute(CEDENTE_GERAL_BEAN, null);
        request.getSession().setAttribute(FLOAT_LISTA_DEFAULT, null);
        request.getSession().setAttribute(FLOAT_LISTA, null);
    }

    /**
     * Ajusta as guias de acordo com o estado do Cedente Eletronico
     */
    private void ajustaGuiasCedenteEletronico(HttpServletRequest request,
            CedentePrincipalBean principalBean,
            CedenteGeralBean beanFiltro) throws Exception {
        // verificando se pode cadastrar cedente eletronico
        int guiaInclusao = principalBean.getUltimaGuiaCadastrada().intValue() + 1;

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        if (guiaInclusao > CedenteEstrategia.GUIA_GERAL) {
            CedenteGeralBean geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
            geralBean.setTipoConsulta("I"); // I - dados temporarios p/ inclusao
            geralBean.setCodigoClienteCOCLI(beanFiltro.getCodigoClienteCOCLI());
            geralBean.setCodigoUnidadePVVinc(beanFiltro.getCodigoUnidadePVVinc());

            // BG03
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_CONSULTAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
            BeanList beanListGeral = handler.executeSimpleTransactionQuery(geralBean,transUser);

            geralBean = (CedenteGeralBean) beanListGeral.get(0);

            principalBean.setTipoCobranca(geralBean.getTipoCobranca());
            principalBean.setCedenteCentralizador(geralBean.getCodCedenteCentraliz());
        }

        if (guiaInclusao >= CedenteEstrategia.GUIA_CEDENTE_ELETRONICO) {
            CedenteEletronicoBean eletronBean = (CedenteEletronicoBean) new CedenteEletronicoBean().newBean();
            eletronBean.setTipoAcao("I"); // I - Tabela inclusao
            eletronBean.setCodigoClienteCOCLI(beanFiltro.getCodigoClienteCOCLI());
            eletronBean.setCodigoUnidadePVVinc(beanFiltro.getCodigoUnidadePVVinc());
            eletronBean.setSituacao(new Long(1)); // 1 - Teste
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
            String transUser = TRANSACAO_SITUACAO_CEDENTE_ELETRONICO + usuarioBean.getCodigoUsuario().toUpperCase();
           
            BeanList blResposta = handler.executeSimpleTransactionQuery(eletronBean,
            		transUser);
            eletronBean = (CedenteEletronicoBean) blResposta.get(0);

            if ("S".equals(eletronBean.getCadastrado())) {
                principalBean.setCedenteEletronicoCadastrado(new Integer(1));
            } else {
                principalBean.setCedenteEletronicoCadastrado(new Integer(0));
            }
        }
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_INCLUIR_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
