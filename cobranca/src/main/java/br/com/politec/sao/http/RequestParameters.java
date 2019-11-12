package br.com.politec.sao.http;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import br.com.politec.sao.util.IteratorAdapter;
import br.com.politec.sao.util.StringUtils;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que possibilita a obtenção de uma lista de parâmetros contidos num
 * request. Permite a listagem dos nomes dos parâmetros e dos valores
 * serializados dos mesmos.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class RequestParameters extends EntrySet {
    /**
     * Objeto de requisição http encapsulado.
     */
    private final HttpServletRequest request;

    /**
     * Construtor default do objeto.
     * 
     * @param request
     *            Requisição http que contém os parâmetros.
     */
    public RequestParameters(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Método names.
     * 
     * @see br.com.politec.sao.http.EntrySet#names() Fornece uma lista dos nomes
     *      dos atributos contidos na requisição http.
     * @return Lista com os nomes de atributos presentes na requisição http.
     */
    public Iterator names() {
        return new IteratorAdapter(this.request.getParameterNames());
    }

    /**
     * Método value.
     * 
     * @see br.com.politec.sao.http.EntrySet#value(java.lang.String) Retorna o
     *      valor em forma de String do valor referenciado pelo nome de
     *      variável. Para valores simples é retornado apenas o valor, para
     *      valores múltiplos estes serão separados por ','.
     * @param name
     *            Nome do parâmetro solicitado.
     * @return String formatada de acordo com o tipo de parâmetro.
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
     * Método hasMultipleValues. Verifica se o parâmetro identificado pelo nome
     * passado como atributo tem valoração simples ou multipla.
     * 
     * @param name
     *            Identificação do parâmetro.
     * @return Resultado da verificação.
     */
    private boolean hasMultipleValues(String name) {
        return this.request.getParameterValues(name) != null;
    }

    /**
     * Método title. Retorna a identificação da classe para fins de log.
     * 
     * @see br.com.politec.sao.http.EntrySet#title()
     * @return <code>"Request Parameters"</code>
     */
    public String title() {
        return "Request Parameters";
    }
}