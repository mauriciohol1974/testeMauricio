package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ClienteInternetBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

public class CliInteAlterarRelFinalizar extends CliInteEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        ClienteInternetBean clienteInternetBean = iniciarProcessRequest(request,
                DATA_BEAN);

        // Verifica se o novo cliente internet existe
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        clienteInternetBean.setTipoAcao("V");
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_VALIDAR_USU + usuarioBean.getCodigoUsuario().toUpperCase();
        
        BeanList validarList = handler.executeSimpleTransactionQuery(clienteInternetBean,	transUser);
        ClienteInternetBean clienteInternetVBean = (ClienteInternetBean) validarList.get(0);

        if (clienteInternetVBean.getUsuarioExistente().equals("N"))
            return PAGE_ALTINC_USU;

        clienteInternetBean.setTipoAcao("R");
         transUser = TRANSACAO_INCLUIR_ALTERAR_REL + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList detalheList = handler.executeSimpleTransactionQuery(clienteInternetBean,
        		transUser);
        clienteInternetBean = (ClienteInternetBean) detalheList.get(0);

        return PAGE_SUCESSO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_ALTERAR_REL);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setTitlePage(PAGE_TITLE_ALTERAR_REL);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
