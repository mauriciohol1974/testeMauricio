package br.gov.caixa.sigcb.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Servlet de controle do sistema SIGCB. Esta classe � uma implementa��o direta
 * das classes ControlServlet (que prov� o controle de estrat�gias de
 * processamento das requisi��es http) e de PolitecServlet, que define a
 * interface padr�o de servlets para framework Generic Beans Politec.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/01/2003</DD>
 * </DL>
 * 
 * @author Alex Takaoka - atakaoka@sao.politec.com.br
 * @author Andrew Betencourt - abetencourt@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br - Data: 21/06/2004
 */
public class SigcbLogin extends SigcbControle {

    public SigcbLogin() {
        super();
    }

    /**
     * Mant�m os m�todos de requisi��o http suportados pelo sistema. No momento
     * est� habilitado somente requisi��es via GET para o sistema SIGCB.
     * 
     * @see br.com.politec.sao.http.PolitecServlet#accepts(String)
     */
    protected boolean accepts(String metodo) {
        return metodo.equalsIgnoreCase("GET")
               || metodo.equalsIgnoreCase("POST");
    }

    /**
     * M�todo service.
     * 
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse) Implementa��o padr�o para
     *      que o fluxo de execu��o das requisi��es http do cliente possam ser
     *      atendidas dentro da estrutura da framework. O processo se inicia com
     *      a obten��o do par�metro que identifica a a��o desejada por parte do
     *      usu�rio. � feita a verifica��o para assegurar que a requisi��o foi
     *      feita atrav�s de um m�todo suportado pela aplica��o. Encerrando o
     *      processo a solicita��o � direcionada para o m�todo
     * @see #doAction(String, HttpServletRequest, HttpServletResponse) que deve
     *      ser implementado pelas aplica��es.
     * @param request
     *            Objeto que encapsula as requisi��es http realizadas pelos
     *            usu�rios.
     * @param response
     *            Objeto que fornece meios de resposta para a requisi��o,
     *            normalmente n�o utilizado em desenvolvimento.
     */
    protected void service(HttpServletRequest request,
            HttpServletResponse response) {

        String action = "login.AutenticacaoUsuario";
        String method = request.getMethod();
        try {
            if (accepts(method)) {
                doAction(action, request, response);
            } else {
                throw new WrappingException(new Exception("M�todo inv�lido - "
                                                          + request.getMethod()));
            }
        } catch (WrappingException w) {
            try {
                handleException(w, request, response, action, "Message");
            } catch (Throwable err) {
                LogUtilSigcb.error("PolitecServlet.service:" + err.getMessage(),
                        err);
                redirectToErrorPage(response);
            }
        } catch (Exception exc) {
            try {
                handleException(exc, request, response, action, "Error");
            } catch (Throwable err) {
                LogUtilSigcb.error("PolitecServlet.service:" + err.getMessage(),
                        err);
                redirectToErrorPage(response);
            }
        } catch (Throwable exc) {
            LogUtilSigcb.error("PolitecServlet.init:" + exc.getMessage(), exc);
            redirectToErrorPage(response);
        }
    }

    private void redirectToErrorPage(HttpServletResponse response) {
        try {
            response.sendRedirect(getDefaultHTMLErrorPageName() + ".jsp");
        } catch (Exception exc) {
            LogUtilSigcb.error("PolitecServlet.redirectToErrorPage:"
                               + exc.getMessage(), exc);
            redirectToErrorPage(response);
        }
    }
}