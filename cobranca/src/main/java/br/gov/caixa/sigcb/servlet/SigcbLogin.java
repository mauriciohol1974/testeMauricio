package br.gov.caixa.sigcb.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Servlet de controle do sistema SIGCB. Esta classe é uma implementação direta
 * das classes ControlServlet (que provê o controle de estratégias de
 * processamento das requisições http) e de PolitecServlet, que define a
 * interface padrão de servlets para framework Generic Beans Politec.
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
     * Mantém os métodos de requisição http suportados pelo sistema. No momento
     * está habilitado somente requisições via GET para o sistema SIGCB.
     * 
     * @see br.com.politec.sao.http.PolitecServlet#accepts(String)
     */
    protected boolean accepts(String metodo) {
        return metodo.equalsIgnoreCase("GET")
               || metodo.equalsIgnoreCase("POST");
    }

    /**
     * Método service.
     * 
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse) Implementação padrão para
     *      que o fluxo de execução das requisições http do cliente possam ser
     *      atendidas dentro da estrutura da framework. O processo se inicia com
     *      a obtenção do parâmetro que identifica a ação desejada por parte do
     *      usuário. É feita a verificação para assegurar que a requisição foi
     *      feita através de um método suportado pela aplicação. Encerrando o
     *      processo a solicitação é direcionada para o método
     * @see #doAction(String, HttpServletRequest, HttpServletResponse) que deve
     *      ser implementado pelas aplicações.
     * @param request
     *            Objeto que encapsula as requisições http realizadas pelos
     *            usuários.
     * @param response
     *            Objeto que fornece meios de resposta para a requisição,
     *            normalmente não utilizado em desenvolvimento.
     */
    protected void service(HttpServletRequest request,
            HttpServletResponse response) {

        String action = "login.AutenticacaoUsuario";
        String method = request.getMethod();
        try {
            if (accepts(method)) {
                doAction(action, request, response);
            } else {
                throw new WrappingException(new Exception("Método inválido - "
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