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
 * framework Politec. Esta classe fornece o suporte necessário para tratamento
 * de exceções e parsing necessários para o funcionamento correto da framework.
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
     * Método init.
     * 
     * @see javax.servlet.GenericServlet#init() Implementação padrão atendendo a
     *      expecificação J2EE da api de servlets. Este método chama diretamente
     *      o método
     * @see #initialize() que pode ser re-escrito pela aplicação fim através de
     *      herança simples.
     * @throws ServletException
     *             Caso ocorra algum erro durante o processo de inicialização da
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
     * Método init.
     * 
     * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig) Identico ao
     *      método
     * @see #init(), porém com a possibilidade de manipulação de entradas de
     *      ambiente. As variáveis de ambiente para servlet podem ser obtidas
     *      através do objeto recebido como parâmetro. O método que pode ser
     *      re-escrito também muda, sendo o
     * @see #initialize(ServletConfig) o chamado.
     * @param config
     *            Objeto que irá encapsular as configurações de inicialização do
     *            servlet.
     * @throws ServletException
     *             Caso ocorra algum erro durante o processo de inicialização da
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
     * Utilize esse método para efetuar operações de inicialização no Servlet.
     * 
     * @throws Exception
     *             caso qualquer problema aconteça
     */
    protected void initialize() throws Exception {
    }

    /**
     * Utilize esse método para efetuar operações de inicialização no Servlet,
     * utilizando parâmetros de ambiente.
     * 
     * @param config
     *            Objeto de configurações do Servlet
     * @throws Exception
     *             Caso ocorra algum erro durante o processo de inicialização da
     *             servlet.
     */
    protected void initialize(ServletConfig config) throws Exception {
    }

    /**
     * Método getRealPath. Retorna o path real da servlet, permitindo assim
     * acessos a disco de forma mais organizada sem a utilização de caminhos
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
                throw new WrappingException(new Exception("Método inválido - "
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
     * Método redirectToErrorPage. Direciona a resposta para a página de erro
     * default informada para o sistema.
     * 
     * @param response
     *            Objeto de requisição que irá permitir o direcionamento.
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
     * Método getNonEmptyParameter. Método que retorna um valor default caso o
     * parâmetro pesquisado não exista no request.
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
     * Método forward. Executa o direcionamento das respostas de requisições
     * para às páginas jsp. Recebe os parametros e executa o seguinte
     * procedimento: <code>getServletContext()
     * .getRequestDispatcher(pageToForward).forward(request,
     * response)</code>
     * 
     * @param pageToForward
     *            Página JSP que receberá a resposta.
     * @param request
     *            Objeto de request associado a requisição.
     * @param response
     *            Objeto de response associado a requisição.
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
     * Método getPath. Retorna o path passado como parâmetro com a adição do
     * caracter '/'.
     * 
     * @param pageToForward
     *            Path da página que irá apresentar o resultado.
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
     * Método doAction. Deve ser implementado pelas classes que irão compor a
     * estrutura de controle do sistema. Nesta método estara encapsulada a
     * solução de controle adotada por cada sistema, realizando fisicamente as
     * solicitiações de cada cliente.
     * 
     * @param action
     *            Define a ação passada pelo usuário através da requisição http.
     * @param request
     *            Objeto associado a requisão http do cliente, que armazena os
     *            atributos e parâmetros da solicitação.
     * @param response
     *            Objeto que encapsula a estrtura de resposta padrão da
     *            plataforma J2EE, normalmente não utilizada.
     * @throws Exception
     *             Propagação de exceções padrão, para tratamento pela
     *             framework.
     */
    protected abstract void doAction(String action,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception;

    /**
     * Método getActionParameterName. Deve retornar o nome que identificará o
     * parâmetro de ação enviado pelo usuário. Esta definição cabe a cada
     * projeto.
     * 
     * @return ID do parâmetro de ação.
     */
    protected abstract String getActionParameterName();

    /**
     * Método getDefaultHTMLErrorPageName. Página para tratamento default de
     * erros. Será acionada a critério da equipe de projeto, ou em erros não
     * previstos na modelagem.
     * 
     * @return Path da página de erro default para o sistema.
     */
    protected abstract String getDefaultHTMLErrorPageName();

    /**
     * Método handleException. Determina o modo de tratamento de erros do
     * sistema. Este método é acionado toda vez que uma exceção é propagada até
     * a última camada de chamada da framework.
     * 
     * @param exc
     *            Exceção propagada.
     * @param request
     *            Objeto que encapsula a requisição http do usuário.
     * @param response
     *            Objeto que encapsula a estrtura de resposta padrão da
     *            plataforma J2EE, normalmente não utilizada.
     * @param action
     *            Define a ação passada pelo usuário através da requisição http.
     * @param typeMessage
     *            Tipo de Mensagem de Erro: Message ou Error.
     */
    protected abstract void handleException(Exception exc,
            HttpServletRequest request,
            HttpServletResponse response,
            String action,
            String typeMessage);

    /**
     * Método accepts. Determina quais os métodos de solicitações http são
     * suportadas pelo sistema. Normalmente é liberado apenas o uso de
     * requisições do tipo <code>POST</code>.
     * 
     * @param method
     *            Método utilizado para envio do request.
     * @return Indicador de aceitação ou não da requisição baseada no método de
     *         envio.
     */
    protected abstract boolean accepts(String method);

}