package br.com.politec.sao.controlStrategy;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.http.PolitecServlet;
import br.com.politec.sao.util.Cache;
import br.com.politec.sao.util.Creation;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Extensão Framework Politec Generic Beans</B><BR>
 * Servlet de Controle para sistemas baseados no modelo MVC 2 indicado pela SUN,
 * e utilizando o suporte fornecido pela framework de componentes para projetos
 * J2EE da Politec Informática. Mantém o controle dos fluxos de processamento
 * definidos para o sistema, baseando-se no padrão de software orientado a
 * objetos Strategy. book: Design Patterns - Elements of Reusable
 * Object-Oriented Software Erich Gamma, Richard Helm, Ralph Johnson, John
 * Vlissides Criada em 30/08/2002 para o projeto SIAGA - CAIXA Atualizada em
 * 19/12/2002 para reutilização genérica. Atualizada em 25/08/2004 para reter a
 * ultima estrategia executada.
 * 
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @author Daniel Yukio Yokomiso
 * @author Marcelo Luchesi - mluchesi@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br - implementacao
 *         metodo getStrategy
 * @version release 1.3.1
 */
abstract public class ControlServlet extends PolitecServlet {

    /**
     * Cache de objetos de strategias. Os objetos de estratégia utlizados pela
     * servlet, e que encapsulam a sequencia de execução, serão mantidos em
     * cache para ganho de performance e otimização na utilziação do hardware.
     */
    private Cache strategies;

    /**
     * Construtor da classe, que define e cria um Cache de objetos de
     * estratégia. Os objetos são mantidos em uma estrutura de Map, onde o nome
     * da classe e o pacote são utilizados como key, associado ao objeto
     * instanciado. Ao ser solicitado ao cache um objeto, este verifica se
     * existe a instância, caso não exista uma nova é criada.
     * 
     * @see StrategyTemplate
     */
    public ControlServlet() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.politec.sao.http.PolitecServlet#initialize(javax.servlet.ServletConfig)
     */
    @Override
    protected void initialize(ServletConfig config) throws Exception {
        this.strategies = new Cache(new Creation() {

            public boolean updateIsNeeded(Object key, Object value) {
                return !strategies.containsKey(key);
            }

            public Object create(Object key) {
                try {
                    Class klass = Class.forName(getRootPackageStrategies()
                                                + "."
                                                + key);
                    return klass.newInstance();
                } catch (ClassNotFoundException exc) {
                    throw new WrappingException(new ClassNotFoundException("A estrategia especificada nao foi encontrada: "
                                                                           + getRootPackageStrategies()
                                                                           + "."
                                                                           + key));
                } catch (Exception exc) {
                    throw new WrappingException(exc);
                }
            }
        });
    }

    /**
     * Método getRootPackageStrategies. Deve ser implementado na Servlet do
     * sistema parametrizando a base raiz dos pacotes de estratégias da
     * aplicação. Exemplo : "br.com.politec.sistemaX.estrategias", sendo para as
     * acoes informado então o sub-pacote e o nome da classe,
     * "admSistema.LancaRegistro".
     * 
     * @return String com o literal da raiz dos pacotes.
     */
    protected abstract String getRootPackageStrategies();

    /**
     * Método getActionParameterName.
     * 
     * @see br.com.politec.sao.http.PolitecServlet#getActionParameterName()
     *      Retorna o identificador do parametro passado no request para
     *      processamento. É utilizado pela estrutura mantida pela framework de
     *      componentes da Politec Informatica, para acionamento do método
     *      doAction, cuja implementação é padronizada nesta classe.
     * @return Literal que irá identificar a ação, neste padrão
     *         <code>"estratégia"</code>.
     */
    protected String getActionParameterName() {
        return "estrategia";
    }

    /**
     * Método doAction.
     * 
     * @see br.com.politec.sao.http.PolitecServlet#doAction(String,
     *      HttpServletRequest, HttpServletResponse) Método acionado pela
     *      estrutura de framework ao recebimento de uma chamada para Servlet. A
     *      sequencia de execução do método doAction, é obter a estratégia
     *      identificada através do parâmetro acao e executar o método
     *      processRequest(); Em seguida direcionar a chamada para URL fornecida
     *      pelo objeto de estratégia.
     * @param strategy,
     *            Nome da stratégia a ser utilizada.
     * @param request,
     *            Objeto de request associado a chamada do browser.
     * @param response,
     *            Objeto de response associado a chamada do browser.
     * @throws Exception
     *             Permite a propagação de exceções que serão tratadas pela
     *             estrutura da framework de projeto.
     */
    protected void doAction(String strategy,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        StrategyTemplate estrategia = getStrategy(strategy);
        String pageForward = estrategia.processRequest(request, response);
        super.forward(pageForward, request, response);
    }

    /**
     * Metodo getStrategy Fornecer uma interface para implementacao de
     * subclasses de ControlServlet obterem a estrategia que esta sendo
     * executada/tratada.
     * 
     * @param strategy
     * @return StrategyTemplate
     */
    protected StrategyTemplate getStrategy(String strategy) {
        // TODO
        LogUtilSigcb.info(">>> protected StrategyTemplate getStrategy(String strategy)");
        try {
            return (StrategyTemplate) strategies.get(strategy);
        } finally {
            LogUtilSigcb.info("<<< protected StrategyTemplate getStrategy(String strategy)");
        }
    }

    protected boolean cacheContainsStrategy(String strategy) {
        return strategies.containsKey(strategy);
    }

}