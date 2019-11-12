package br.com.politec.sao.http;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import br.com.politec.sao.util.IteratorAdapter;
import br.com.politec.sao.util.StringUtils;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que possibilita a obten��o de uma lista de par�metros contidos num
 * request. Permite a listagem dos nomes dos par�metros e dos valores
 * serializados dos mesmos.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class RequestParameters extends EntrySet {
    /**
     * Objeto de requisi��o http encapsulado.
     */
    private final HttpServletRequest request;

    /**
     * Construtor default do objeto.
     * 
     * @param request
     *            Requisi��o http que cont�m os par�metros.
     */
    public RequestParameters(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * M�todo names.
     * 
     * @see br.com.politec.sao.http.EntrySet#names() Fornece uma lista dos nomes
     *      dos atributos contidos na requisi��o http.
     * @return Lista com os nomes de atributos presentes na requisi��o http.
     */
    public Iterator names() {
        return new IteratorAdapter(this.request.getParameterNames());
    }

    /**
     * M�todo value.
     * 
     * @see br.com.politec.sao.http.EntrySet#value(java.lang.String) Retorna o
     *      valor em forma de String do valor referenciado pelo nome de
     *      vari�vel. Para valores simples � retornado apenas o valor, para
     *      valores m�ltiplos estes ser�o separados por ','.
     * @param name
     *            Nome do par�metro solicitado.
     * @return String formatada de acordo com o tipo de par�metro.
     */
    public String value(String name) {
        String result = "";
        if (hasMultipleValues(name)) {
            result = StringUtils.join(request.getParameterValues(name), ", ");
        } else {
            result = request.getParameter(name);
        }
        return result;
    }

    /**
     * M�todo hasMultipleValues. Verifica se o par�metro identificado pelo nome
     * passado como atributo tem valora��o simples ou multipla.
     * 
     * @param name
     *            Identifica��o do par�metro.
     * @return Resultado da verifica��o.
     */
    private boolean hasMultipleValues(String name) {
        return this.request.getParameterValues(name) != null;
    }

    /**
     * M�todo title. Retorna a identifica��o da classe para fins de log.
     * 
     * @see br.com.politec.sao.http.EntrySet#title()
     * @return <code>"Request Parameters"</code>
     */
    public String title() {
        return "Request Parameters";
    }
}