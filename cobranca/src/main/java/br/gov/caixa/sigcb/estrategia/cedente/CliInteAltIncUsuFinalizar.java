package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.ClienteInternetBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.CryptoAdapter;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Incluir Usuario
 * Internet pela funcionalidade de Alteracao
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>13/12/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego
 */
public class CliInteAltIncUsuFinalizar extends CliInteEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        ClienteInternetBean clienteInternetBean = iniciarProcessRequest(request,
                DATA_BEAN);
        request.getSession().setAttribute(DATA_BEAN, clienteInternetBean);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // Transacao de Remocao de Relacionamento Usuatio Internet
        clienteInternetBean.setTipoAcao("E");
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR_REL + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionQuery(clienteInternetBean,transUser);
        // BeanList detalheList =
        // handler.executeSimpleTransactionQuery(clienteInternetBean,TRANSACAO_INCLUIR_ALTERAR_REL);
        // ClienteInternetBean clienteInternetRBean =
        // (ClienteInternetBean)detalheList.get(0);

        // Transacao de Inclusao de Usuario Internet
        clienteInternetBean.setTipoAcao("I");// Inclusão
         usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute("usuarioLdap");
        clienteInternetBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        String senha = (String) request.getParameter("senha");
       // clienteInternetBean.setSenha(new String(CryptoAdapter.getCryptoRanbbpwn(senha, "9620962096209620",  1)));
        // clienteInternetBean.setSenha(TPC.encriptar(senha,"9620962096209620",
        // 1));
        transUser = TRANSACAO_INCLUIR_ALTERAR_CLI + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(clienteInternetBean,
        		transUser); // Chama a Transacao

        // Nome da JSP a ser chamada
        return PAGE_SUCESSO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_ALTINC_USU);
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_LISTAR);
        msgBean.setStrategySucessReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setTitlePage(PAGE_TITLE_ALTINC_USU);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
