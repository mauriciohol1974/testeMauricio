package br.com.politec.sao.http;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import br.com.politec.sao.util.IteratorAdapter;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Permite obter uma lista dos objetos mantidos para a requisição. Fornece
 * suporte a listagem de nomes e serialização de valores.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class SessionAttributes extends EntrySet {
    /**
     * Mantém o objeto que identifica alvo da pesquisa.
     */
    private final HttpSession session;

    /**
     * Construtor default do objeto.
     * 
     * @param session
     *            Objeto de seesão que será mantido na variável global.
     */
    public SessionAttributes(HttpSession session) {
        this.session = session;
    }

    /**
     * Método names.
     * 
     * @see br.com.politec.sao.http.EntrySet#names() Lista os nomes de atributos
     *      identificada pelo objeto.
     * @return Lista dos nomes de atributos.
     */
    public Iterator names() {
        return new IteratorAdapter(this.session.getAttributeNames());
    }

    /**
     * Método value.
     * 
     * @see br.com.politec.sao.http.EntrySet#value(java.lang.String) Lista o
     *      valor
     * @see Object#toString() do atributo identificado pelo nome passado como
     *      parâmetro.
     * @param name
     *            Nome do objeto como atributo.
     * @return
     * @see Object#toString() do objeto localizado.
     */
    public String value(String name) {
        return this.session.getAttribute(name).toString();
    }

    /**
     * Método title.
     * 
     * @see br.com.politec.sao.http.EntrySet#title() Retorna um idetificador da
     *      classe, para fins de log.
     * @return <code>"Session Attributes"</code>
     */
    public String title() {
        return "Session Attributes";
    }
}