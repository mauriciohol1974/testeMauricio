package br.com.politec.sao.controlStrategy;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <B> Projeto : Extensão Framework Politec Generic Beans </B> <BR>
 * Classe que define a interface dos objetos de stratégia. Esta classe segundo o
 * padrão Strategy é definida como o componente Strategy que tem a interface
 * padrão dos algoritmos de estratégias concretas possíveis. É através desta
 * classe que o Contexto
 * 
 * @see ControlServlet, irá efetuar as chamadas para execução das estratégias
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
     * Método processRequest. Método para processamento da chamada http efetuada
     * pelo cliente. Deverá ser implementado pelas estratégias físicas, que
     * realizarão as solicitações do cliente.
     * 
     * @param request
     *            Objeto associado a chamada http.
     * @param response
     *            Objeto associado a chamada http.
     * @return String URL de destino após o processamento do request.
     * @throws Exception
     *             para que a framework do projeto trate os erros aplicáveis.
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