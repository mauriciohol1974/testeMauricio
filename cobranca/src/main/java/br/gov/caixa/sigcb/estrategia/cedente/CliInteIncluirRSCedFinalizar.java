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
 * Componente responsável pelo controle da funcionalidade Cliente Internet
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/11/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego
 */
public class CliInteIncluirRSCedFinalizar extends CliInteEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        ClienteInternetBean clienteInternetBean = iniciarProcessRequest(request,
                FILTRO_BEAN);

        // Obtem dados do bit62 criados pela estrategia anterior
        ClienteInternetBean clienteInternetDBean = (ClienteInternetBean) clienteInternetBean.getSessionBean(request,
                DATA_BEAN);
        clienteInternetBean.setBit62(clienteInternetDBean.getBit62());

        // Retem informacoes no ambiente
        request.getSession().setAttribute(DATA_BEAN, clienteInternetBean);

        // Obtem o primeiro cedente do bit62 para realizar processo de inclusao
        // de usuario
        String tmpBit62 = clienteInternetBean.getBit62();
        String cedente = tmpBit62.substring(0, 6);

        clienteInternetBean.setCodigoCedente(new Long(cedente));
        clienteInternetBean.setTipoAcao("I");// Inclusão
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        clienteInternetBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        String senha = (String) request.getParameter("senha");

       // clienteInternetBean.setSenha(new String(CryptoAdapter.getCryptoRanbbpwn(senha,   "9620962096209620",    1)));

        // Chamada ao Mainframe para inclusao
        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
         usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_INCLUIR_ALTERAR_CLI + usuarioBean.getCodigoUsuario().toUpperCase();
        
        handler.executeSimpleTransactionVoid(clienteInternetBean,
        		transUser); // Chama a Transacao

        // Retira o primeiro cedente da lista e preenche com zeros o final da
        // string
        clienteInternetBean.setBit62(tmpBit62.substring(6) + "000000");

        // Insere relacao cedente X clienteInternet.
         transUser = TRANSACAO_INCLUIR_RS_REL + usuarioBean.getCodigoUsuario().toUpperCase();
        handler.executeSimpleTransactionVoid(clienteInternetBean,
        		transUser);

        return PAGE_SUCESSO_RS;
    }

    // Define tela customizada de erro
    public String getCustomizedHTMLMessagePageName() {
        return PAGE_ERRO_RS;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess(SUCESSO_INCLUIR_REL);
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_FILTRO);
        msgBean.setStrategySucessReturn(STRATEGY_INCLUIR_INICIAR);
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}