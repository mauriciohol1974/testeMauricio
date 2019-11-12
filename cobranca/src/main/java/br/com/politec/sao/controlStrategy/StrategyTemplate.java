package br.com.politec.sao.controlStrategy;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <B> Projeto : Extens�o Framework Politec Generic Beans </B> <BR>
 * Classe que define a interface dos objetos de strat�gia. Esta classe segundo o
 * padr�o Strategy � definida como o componente Strategy que tem a interface
 * padr�o dos algoritmos de estrat�gias concretas poss�veis. � atrav�s desta
 * classe que o Contexto
 * 
 * @see ControlServlet, ir� efetuar as chamadas para execu��o das estrat�gias
 *      concretas.
 * @author Alex Staudt Takaoka - atakaoka@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br Apesar de diverso do
 *         padrao strategy do GOF, que possui referecia apenas a process() foi
 *         implementado o metodo getCustomizedHTMLMessagePageName(), que
 *         permitira a servlet obter paginas customizadas de erro, ao invez das
 *         comuns getDefaultHTMLErrorPageName()).
 * @version release 1.3.1
 */
public abstract class StrategyTemplate implements Serializable {
    /**
     * M�todo processRequest. M�todo para processamento da chamada http efetuada
     * pelo cliente. Dever� ser implementado pelas estrat�gias f�sicas, que
     * realizar�o as solicita��es do cliente.
     * 
     * @param request
     *            Objeto associado a chamada http.
     * @param response
     *            Objeto associado a chamada http.
     * @return String URL de destino ap�s o processamento do request.
     * @throws Exception
     *             para que a framework do projeto trate os erros aplic�veis.
     */
    public abstract String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception;

    /**
     * metodo abstrato para obter a pagina customizada de erro deve ser
     * implementada pelas estrategias concretas
     * 
     * @return String - pagina de erro customizada
     */
    public abstract String getCustomizedHTMLMessagePageName();
}