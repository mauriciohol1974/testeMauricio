package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteAlterarEnderecoSicliBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
//import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

public class CedenteAlterarEnderecoSicliFinalizar extends
        CedenteAlterarEnderecoSicliEstrategia {

    private static final long serialVersionUID = 6071185744747311402L;

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        // AOL - 06nov06
        CedenteAlterarEnderecoSicliBean bean = (CedenteAlterarEnderecoSicliBean) (new CedenteAlterarEnderecoSicliBean()).getRequestBean(request);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CEDENTE_ALTERAR_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(bean,transUser);
        // AOL - Fim

        return CedenteEstrategia.PAGE_ACAO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("Endereço do Cedente alterado com sucesso !");
        // msgBean.setStrategyErrorReturn(STRATEGY_ALTERAR_INICIAR);
        msgBean.setStrategyErrorReturn(STRATEGY_REDIRECT_ERROR);

        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_ALTERAR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
