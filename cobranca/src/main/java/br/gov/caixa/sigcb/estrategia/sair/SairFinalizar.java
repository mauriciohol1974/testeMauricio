package br.gov.caixa.sigcb.estrategia.sair;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Sair.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>21/06/2004</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */
public class SairFinalizar extends SigcbEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        InformacoesUsuarioBean usuario = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        LogUtilSigcb.info("Usuario "
                          + usuario.getUsername()
                          + " efetuou logoff.");

        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();

        return "jump";
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
    }

    public String getCustomizedHTMLMessagePageName() {
        return "sigcb_erro";
    }
}