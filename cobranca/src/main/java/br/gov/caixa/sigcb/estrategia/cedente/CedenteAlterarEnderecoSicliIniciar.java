package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteAlterarEnderecoSicliBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

public class CedenteAlterarEnderecoSicliIniciar extends
        CedenteAlterarEnderecoSicliEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        CedenteAlterarEnderecoSicliBean bean = (CedenteAlterarEnderecoSicliBean) (new CedenteAlterarEnderecoSicliBean()).getRequestBean(request);
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CEDENTE_CONSULTA_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanList = handler.executeSimpleTransactionQuery(bean,     transUser);
        // LogUtilSigcb.info("beanList ->" + beanList.size());
        CedenteAlterarEnderecoSicliBean beanResultado = (CedenteAlterarEnderecoSicliBean) beanList.get(0);
        // LogUtilSigcb.info("CedenteAlterarEnderecoSicliBean ->" +
        // beanResultado);
        request.setAttribute("beanResultado", beanResultado);

        return PAGE_JSP_ALTERAR;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        // msgBean.setStrategyErrorReturn(STRATEGY_ALTERAR_INICIAR);
        msgBean.setStrategyErrorReturn(STRATEGY_REDIRECT_ERROR);

        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_ALTERAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
