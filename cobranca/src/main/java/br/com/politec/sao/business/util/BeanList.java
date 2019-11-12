package br.com.politec.sao.business.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.Layout;
import br.com.politec.sao.util.Assertions;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Possibilita a criação de uma lista de objetos do tipo
 * 
 * @see br.com.politec.sao.business.BusinessObject para ser manipulada na
 *      framework.
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class BeanList implements Serializable {
    /**
     * Instancia do formato de layout dos objetos mantidos na lista.
     * 
     * @see Layout
     */
    private final Layout layout;

    /**
     * Lista real dos itens mantidos.
     */
    private final List items;

    /**
     * Construtor do objeto que recebe o formato do layout para inicialização.
     * 
     * @param layout
     */
    public BeanList(Layout layout) {
        Assertions.requires(layout != null);
        this.items = new ArrayList();
        this.layout = layout;
    }

    /**
     * Método getLayout. Retorna o layout suportado pela lista.
     * 
     * @return Layout suportado pela lista.
     */
    public Layout getLayout() {
        return this.layout;
    }

    /**
     * Método accepts. Verifica se o objeto passado como parâmetro tem o layout
     * compativel com o determinado para lista.
     * 
     * @param bean
     *            Objeto para verificação.
     * @return Resultado da verificação.
     */
    public boolean accepts(BusinessObject bean) {
        return getLayout().equals(bean.getLayout());
    }

    /**
     * Método size. Retorna o tamanho da lista.
     * 
     * @return Tamanho da lista de objetos.
     */
    public int size() {
        return this.items.size();
    }

    /**
     * Método isEmpty. Verifica se a lista esta vazia.
     * 
     * @return Resultado da verificação.
     */
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    /**
     * Método contains. Verifica se o item passado como parâmetro esta na lista.
     * 
     * @param bean
     *            Objeto para verificação.
     * @return Resultado da pesquisa.
     */
    public boolean contains(BusinessObject bean) {
        return this.items.contains(bean);
    }

    /**
     * Método iterator. Retorna um iterador a partir da lista.
     * 
     * @return Iterador a partir da lista.
     */
    public Iterator iterator() {
        return this.items.iterator();
    }

    /**
     * Método toArray. Converte a lista em um array de objetos.
     * 
     * @return Array de objetos.
     */
    public Object[] toArray() {
        return this.items.toArray();
    }

    /**
     * Método toArray. Converte a lista em um array de
     * 
     * @see BusinessObject.
     * @param Array
     *            para construção do retorno.
     * @return Array de objetos.
     */
    public BusinessObject[] toArray(BusinessObject[] array) {
        return (BusinessObject[]) this.items.toArray(array);
    }

    /**
     * Método add. Adiciona um item a lista.
     * 
     * @param bean
     *            Item a ser adicionado.
     * @return Resultado da adição.
     */
    public boolean add(BusinessObject bean) {
        return this.items.add(bean);
    }

    /**
     * Método remove. Remove um item da lista.
     * 
     * @param bean
     *            Item a ser removido.
     * @return Resultado da remoção.
     */
    public boolean remove(BusinessObject bean) {
        return this.items.remove(bean);
    }

    /**
     * Método clear. Limpa a lista de objetos.
     */
    public void clear() {
        this.items.clear();
    }

    /**
     * Método get. Obtem o item da lista identificado pelo ínidice passado como
     * parâmetro
     * 
     * @param index
     *            Índice para obtenção do item.
     * @return Objeto referenciado pelo índice na lista.
     */
    public BusinessObject get(int index) {
        return (BusinessObject) this.items.get(index);
    }

    /**
     * Método set. Adiciona um item na lista posicionando-o no índice
     * parametrizado.
     * 
     * @param index
     *            Índice para adição do item.
     * @param bean
     *            Item a ser adicionado.
     * @return Objeto adicionado.
     */
    public BusinessObject set(int index, BusinessObject bean) {
        return (BusinessObject) this.items.set(index, bean);
    }

    /**
     * Método add. Adiciona um item na lista posicionando-o no índice
     * parametrizado.
     * 
     * @param index
     *            Índice para adição do item.
     * @param bean
     *            Item a ser adicionado.
     */
    public void add(int index, BusinessObject bean) {
        this.items.add(index, bean);
    }

    /**
     * Método remove. Remove da lista o item referenciado pelo ínidice.
     * 
     * @param index
     *            Índice para remoção do item.
     * @return Item removido.
     */
    public BusinessObject remove(int index) {
        return (BusinessObject) this.items.remove(index);
    }

    /**
     * Método indexOf. Retorna o índice do objeto passado como parâmetro.
     * 
     * @param bean
     *            Objeto para obtenção do ínidice.
     * @return Índice do objeto.
     */
    public int indexOf(BusinessObject bean) {
        return this.items.indexOf(bean);
    }

    /**
     * Método lastIndexOf. Retorna o índice da última referência ao objeto
     * passado como parâmetro.
     * 
     * @param bean
     *            Objeto para pesquisa.
     * @return Ínidice encontrado.
     */
    public int lastIndexOf(BusinessObject bean) {
        return this.items.lastIndexOf(bean);
    }
}