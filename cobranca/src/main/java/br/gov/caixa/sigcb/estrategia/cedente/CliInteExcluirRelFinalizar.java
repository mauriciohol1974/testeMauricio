package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ClienteInternetBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

public class CliInteExcluirRelFinalizar extends CliInteEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        ClienteInternetBean clienteInternetBean = iniciarProcessRequest(request,
                DATA_BEAN);

        buscarCabecalho(request, clienteInternetBean);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();  MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        clienteInternetBean.setTipoAcao("E");
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR_REL + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList detalheList = handler.executeSimpleTransactionQuery(clienteInternetBean,
        		transUser);
        clienteInternetBean = (ClienteInternetBean) detalheList.get(0);

        return PAGE_SUCESSO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_EXCLUIR_REL);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setTitlePage(PAGE_TITLE_EXCLUIR_REL);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
