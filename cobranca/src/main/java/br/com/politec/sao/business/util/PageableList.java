package br.com.politec.sao.business.util;

import java.util.List;

import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Pageable;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Objeto de paginação genérico. Fornece suporte a paginação de objetos, para
 * qualquer fim.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class PageableList extends Pageable {
    /**
     * Lista de objetos a ser paginada.
     */
    private final List list;

    /**
     * Construtor default do objeto.
     * 
     * @param list
     *            Lista de objetos a ser paginada.
     */
    public PageableList(List list) {
        Assertions.requires(list != null, "Null list");
        this.list = list;
    }

    /**
     * Método get.
     * 
     * @see br.com.politec.sao.util.Pageable#get(int) Retorna o objeto
     *      representado pelo ínidice fornecido como parâmetro.
     * @param index
     *            Índice do objeto desejado.
     * @return Objeto referenciado pelo índice.
     */
    public Object get(int index) {
        Assertions.requires((index >= 0) && (size() > index), "Invalid index");
        return this.list.get(index);
    }

    /**
     * Método size.
     * 
     * @see br.com.politec.sao.util.Pageable#size() Retorna o tamanho da lista
     *      de objetos mantida para paginação.
     * @return Tamanho da lista de objetos a ser paginada.
     */
    public int size() {
        return this.list.size();
    }
}