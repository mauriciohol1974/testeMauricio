package br.com.politec.sao.http;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import br.com.politec.sao.util.IteratorAdapter;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Fornece suporte para listar os atributos contidos em uma requisi��o http. Os
 * atributos de uma requisi��o http, encapsulada em objeto de request, podem ser
 * listados tanto em nomes quanto em valoresserializados atrav�s desta classe.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class RequestAttributes extends EntrySet {
    /**
     * Encapsulamento da requisi��o http.
     */
    private final HttpServletRequest request;

    /**
     * Construtor default do objeto.
     * 
     * @param request
     */
    public RequestAttributes(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * M�todo names.
     * 
     * @see br.com.politec.sao.http.EntrySet#names() Lista os nomes de atributos
     *      presentes na requisi��o http.
     * @return Lista com os nomes de atributos presentes na requisi��o http.
     */
    public Iterator names() {
        return new IteratorAdapter(this.request.getAttributeNames());
    }

    /**
     * M�todo value.
     * 
     * @see br.com.politec.sao.http.EntrySet#value(java.lang.String) Lista o
     *      valor representado na requisi��o http pelo nome passado como
     *      par�metro.
     * @param name
     *            Nome do atributo desejado.
     * @return Valor serializado do objeto localizado.
     */
    public String value(String name) {
        return this.request.getAttribute(name).toString();
    }

    /**
     * M�todo title. Fornece a identifica��o da classe para fins de log.
     * 
     * @see br.com.politec.sao.http.EntrySet#title()
     * @return <code>"Request Attributes"</code>
     */
    public String title() {
        return "Request Attributes";
    }
}