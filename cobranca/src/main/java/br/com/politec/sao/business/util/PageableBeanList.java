package br.com.politec.sao.business.util;

import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Pageable;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que implementa uma lista "paginavel" de Objetos. Alguns projetos
 * apresentam caracteristicas de pagina��o em listas de consulta, e este objeto
 * fornece o suporte para a pagina��o destas listas.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class PageableBeanList extends Pageable {
    /**
     * Lista de objetos a ser paginada.
     */
    private final BeanList beans;

    /**
     * Construtor default do objeto.
     * 
     * @param list
     *            Lista de beans a ser paginada.
     */
    public PageableBeanList(BeanList list) {
        Assertions.requires(list != null, "Null list");
        this.beans = list;
    }

    /**
     * M�todo get.
     * 
     * @see br.com.politec.sao.util.Pageable#get(int) Retornar o objeto
     *      identificado pelo �nidice passado como par�metro.
     * @param index
     *            �ndice do objeto desejado.
     * @return Objeto obtido.
     */
    public Object get(int index) {
        Assertions.requires((index >= 0) && (size() > index), "Invalid index");
        return this.beans.get(index);
    }

    /**
     * M�todo size. Retorna o tamanho da lista de objetos.
     * 
     * @see br.com.politec.sao.util.Pageable#size()
     * @return Tamanho da lista de objetos.
     */
    public int size() {
        return this.beans.size();
    }
}