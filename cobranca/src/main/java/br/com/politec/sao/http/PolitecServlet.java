package br.com.politec.sao.http;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.ejb.session.MainframeException;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que inicia a hierarquia de servlets para sistemas baseados na
 * framework Politec. Esta classe fornece o suporte necess�rio para tratamento
 * de exce��es e parsing necess�rios para o funcionamento correto da framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br alteracoes interface
 *         de handleException: inclusao do param action, para que a excecao
 *         possua referencia da acao que executou o erro.
 * @version release 1.3.1
 */
public abstract class PolitecServlet extends HttpServlet {

    /**
     * Construtor default do objeto.
     */
    public PolitecServlet() {
        super();
    }

    /**
     * M�todo init.
     * 
     * @see javax.servlet.GenericServlet#init() Implementa��o padr�o atendendo a
     *      expecifica��o J2EE da api de servlets. Este m�todo chama diretamente
     *      o m�todo
     * @see #initialize() que pode ser re-escrito pela aplica��o fim atrav�s de
     *      heran�a simples.
     * @throws ServletException
     *             Caso ocorra algum erro durante o processo de inicializa��o da
     *             servlet.
     */
    public final void init() throws ServletException {
        try {
            super.init();
            initialize();
        } catch (Exception exc) {
            LogUtilSigcb.error("PolitecServlet.init:" + exc.getMessage(), exc);
            throw new ServletException(exc);
        }
    }

    /**
     * M�todo init.
     * 
     * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig) Identico ao
     *      m�todo
     * @see #init(), por�m com a possibilidade de manipula��o de entradas de
     *      ambiente. As vari�veis de ambiente para servlet podem ser obtidas
     *      atrav�s do objeto recebido como par�metro. O m�todo que pode ser
     *      re-escrito tamb�m muda, sendo o
     * @see #initialize(ServletConfig) o chamado.
     * @param config
     *            Objeto que ir� encapsular as configura��es de inicializa��o do
     *            servlet.
     * @throws ServletException
     *             Caso ocorra algum erro durante o processo de inicializa��o da
     *             servlet.
     */
    public final void init(ServletConfig config) throws ServletException {
        try {
            super.init(config);
            initialize(config);
        } catch (Exception exc) {
            LogUtilSigcb.error("PolitecServlet.init:" + exc.getMessage(), exc);
            throw new ServletException(exc);
        }
    }

    /**
     * Utilize esse m�todo para efetuar opera��es de inicializa��o no Servlet.
     * 
     * @throws Exception
     *             caso qualquer problema aconte�a
     */
    protected void initialize() throws Exception {
    }

    /**
     * Utilize esse m�todo para efetuar opera��es de inicializa��o no Servlet,
     * utilizando par�metros de ambiente.
     * 
     * @param config
     *            Objeto de configura��es do Servlet
     * @throws Exception
     *             Caso ocorra algum erro durante o processo de inicializa��o da
     *             servlet.
     */
    protected void initialize(ServletConfig config) throws Exception {
    }

    /**
     * M�todo getRealPath. Retorna o path real da servlet, permitindo assim
     * acessos a disco de forma mais organizada sem a utiliza��o de caminhos
     * absolutos para tal.
     * 
     * @param resource
     *            Nome dado a servlet, em momento de deployment.
     * @return Path absoluto do objeto.
     */
    protected final String getRealPath(String resource) {
        return getServletContext().getRealPath(resource);
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
     * @throws ServletException
     */
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException {

        String action = request.getParameter(getActionParameterName());
        String method = request.getMethod();

        boolean anyErrors = false;
        try {
            if (accepts(method)) {
                doAction(action, request, response);
            } else {
                throw new WrappingException(new Exception("M�todo inv�lido - "
                                                          + request.getMethod()));
            }
        } catch (MainframeException w) {
            if (w.getMessage().startsWith("Timeout"))
                handleException(w, request, response, action, "Error");
            else
                handleException(w, request, response, action, "Message");
        } catch (WrappingException exc) {
            handleException(exc, request, response, action, "Message");
        } catch (Exception exc) {
            handleException(exc, request, response, action, "Error");
        } catch (Error exc) {
            LogUtilSigcb.fatal("PolitecServlet.service:" + exc.getMessage(),
                    exc);
        }
        if (anyErrors) {
            redirectToErrorPage(response);
        }
    }

    /**
     * M�todo redirectToErrorPage. Direciona a resposta para a p�gina de erro
     * default informada para o sistema.
     * 
     * @param response
     *            Objeto de requisi��o que ir� permitir o direcionamento.
     * @throws ServletException
     */
    private void redirectToErrorPage(HttpServletResponse response)
            throws ServletException {
        try {
            response.sendRedirect(getDefaultHTMLErrorPageName() + ".jsp");
        } catch (IOException exc) {
            LogUtilSigcb.error("PolitecServlet.redirectToErrorPage:"
                               + exc.getMessage(), exc);
            throw new ServletException(exc);
        }
    }

    /**
     * M�todo getNonEmptyParameter. M�todo que retorna um valor default caso o
     * par�metro pesquisado n�o exista no request.
     * 
     * @param request
     *            Objeto request.
     * @param parameter
     *            Chave do parametro para pesquisa.
     * @param defaultValue
     *            Valor default para o parametro.
     * @return Valor do parametro pesquisado, ou o valor default.
     */
    protected String getNonEmptyParameter(HttpServletRequest request,
            String parameter,
            String defaultValue) {
        final String value = request.getParameter(parameter);
        return ((value == null) || value.equals("")) ? defaultValue : value;
    }

    /**
     * M�todo forward. Executa o direcionamento das respostas de requisi��es
     * para �s p�ginas jsp. Recebe os parametros e executa o seguinte
     * procedimento: <code>getServletContext()
     * .getRequestDispatcher(pageToForward).forward(request,
     * response)</code>
     * 
     * @param pageToForward
     *            P�gina JSP que receber� a resposta.
     * @param request
     *            Objeto de request associado a requisi��o.
     * @param response
     *            Objeto de response associado a requisi��o.
     */
    protected void forward(String pageToForward,
            HttpServletRequest request,
            HttpServletResponse response) {
        try {
            final ServletContext context = getServletContext();
            final RequestDispatcher dispatcher = context.getRequestDispatcher(getPath(pageToForward)
                                                                              + ".jsp");

            dispatcher.forward(request, response);
        } catch (ServletException exc) {
            throw new WrappingException(exc);
        } catch (IOException exc) {
            throw new WrappingException(exc);
        } catch (Exception exc) {
            throw new WrappingException(exc);
        }

    }

    /**
     * M�todo getPath. Retorna o path passado como par�metro com a adi��o do
     * caracter '/'.
     * 
     * @param pageToForward
     *            Path da p�gina que ir� apresentar o resultado.
     * @return Path composto para redirecionamento.
     */
    private String getPath(String pageToForward) {
        if (pageToForward.startsWith("/")) {
            return pageToForward;
        } else {
            return "/" + pageToForward;
        }
    }

    /**
     * M�todo doAction. Deve ser implementado pelas classes que ir�o compor a
     * estrutura de controle do sistema. Nesta m�todo estara encapsulada a
     * solu��o de controle adotada por cada sistema, realizando fisicamente as
     * solicitia��es de cada cliente.
     * 
     * @param action
     *            Define a a��o passada pelo usu�rio atrav�s da requisi��o http.
     * @param request
     *            Objeto associado a requis�o http do cliente, que armazena os
     *            atributos e par�metros da solicita��o.
     * @param response
     *            Objeto que encapsula a estrtura de resposta padr�o da
     *            plataforma J2EE, normalmente n�o utilizada.
     * @throws Exception
     *             Propaga��o de exce��es padr�o, para tratamento pela
     *             framework.
     */
    protected abstract void doAction(String action,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception;

    /**
     * M�todo getActionParameterName. Deve retornar o nome que identificar� o
     * par�metro de a��o enviado pelo usu�rio. Esta defini��o cabe a cada
     * projeto.
     * 
     * @return ID do par�metro de a��o.
     */
    protected abstract String getActionParameterName();

    /**
     * M�todo getDefaultHTMLErrorPageName. P�gina para tratamento default de
     * erros. Ser� acionada a crit�rio da equipe de projeto, ou em erros n�o
     * previstos na modelagem.
     * 
     * @return Path da p�gina de erro default para o sistema.
     */
    protected abstract String getDefaultHTMLErrorPageName();

    /**
     * M�todo handleException. Determina o modo de tratamento de erros do
     * sistema. Este m�todo � acionado toda vez que uma exce��o � propagada at�
     * a �ltima camada de chamada da framework.
     * 
     * @param exc
     *            Exce��o propagada.
     * @param request
     *            Objeto que encapsula a requisi��o http do usu�rio.
     * @param response
     *            Objeto que encapsula a estrtura de resposta padr�o da
     *            plataforma J2EE, normalmente n�o utilizada.
     * @param action
     *            Define a a��o passada pelo usu�rio atrav�s da requisi��o http.
     * @param typeMessage
     *            Tipo de Mensagem de Erro: Message ou Error.
     */
    protected abstract void handleException(Exception exc,
            HttpServletRequest request,
            HttpServletResponse response,
            String action,
            String typeMessage);

    /**
     * M�todo accepts. Determina quais os m�todos de solicita��es http s�o
     * suportadas pelo sistema. Normalmente � liberado apenas o uso de
     * requisi��es do tipo <code>POST</code>.
     * 
     * @param method
     *            M�todo utilizado para envio do request.
     * @return Indicador de aceita��o ou n�o da requisi��o baseada no m�todo de
     *         envio.
     */
    protected abstract boolean accepts(String method);

}