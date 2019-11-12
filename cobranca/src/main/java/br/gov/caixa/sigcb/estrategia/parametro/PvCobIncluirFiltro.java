package br.gov.caixa.sigcb.estrategia.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PvCobradorBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Estratégia de valida a
 * inclusão um codigo de um pv cobrador e prepara os dados para a tela de
 * inclusao
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>24/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class PvCobIncluirFiltro extends PvCobEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);
        PvCobradorBean pvCobBean = new PvCobradorBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            pvCobBean = (PvCobradorBean) pvCobBean.getRequestBean(request);

        } else {
            pvCobBean = (PvCobradorBean) pvCobBean.getSessionBean(request,
                    DATA_BEAN);
        }

       // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        pvCobBean.setTipoAcao("V"); // setando o bean para que a transação faça
                                    // uam validadção
        request.getSession().setAttribute(DATA_BEAN, pvCobBean);
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_VALIDAR_EXCLUIR + usuarioBean.getCodigoUsuario().toUpperCase();
        /* BGL0 */handler.executeSimpleTransactionVoid(pvCobBean,
        		transUser);
         transUser = TRANSACAO_CONS_UNIDADE + usuarioBean.getCodigoUsuario().toUpperCase();
        /* BGM1 */BeanList unidadeBeanList = (BeanList) handler.executeSimpleTransactionQuery(pvCobBean,
        		transUser);

        pvCobBean.setCodigoVAN(new Long(1)); // incluindo no bean a VAN
                                                // "EMBRATEL"
        pvCobBean.setNomeUnidadePV(((PvCobradorBean) unidadeBeanList.get(0)).getNomeUnidadePV());
        pvCobBean.setEmailUnidadePV(((PvCobradorBean) unidadeBeanList.get(0)).getEmailUnidadePV());
        pvCobBean.setEndereco(((PvCobradorBean) unidadeBeanList.get(0)).getEndereco());
        
        pvCobBean.setNomeUnidadeCentral(((PvCobradorBean) unidadeBeanList.get(0)).getNomeUnidadeCentral());
        pvCobBean.setEmailUnidadeCentral(((PvCobradorBean) unidadeBeanList.get(0)).getEmailUnidadeCentral());
        pvCobBean.setEnderecoCentral(((PvCobradorBean) unidadeBeanList.get(0)).getEnderecoCentral());

        request.getSession().setAttribute(DATA_BEAN, pvCobBean);

        return PAGE_INCLUIR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) { /*
                                                                         * rever
                                                                         * dados
                                                                         * do
                                                                         * bean
                                                                         * de
                                                                         * Erro
                                                                         * Sucesso
                                                                         */
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }

}
