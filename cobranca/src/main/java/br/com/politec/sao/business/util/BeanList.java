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
 * Possibilita a cria��o de uma lista de objetos do tipo
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
     * Construtor do objeto que recebe o formato do layout para inicializa��o.
     * 
     * @param layout
     */
    public BeanList(Layout layout) {
        Assertions.requires(layout != null);
        this.items = new ArrayList();
        this.layout = layout;
    }

    /**
     * M�todo getLayout. Retorna o layout suportado pela lista.
     * 
     * @return Layout suportado pela lista.
     */
    public Layout getLayout() {
        return this.layout;
    }

    /**
     * M�todo accepts. Verifica se o objeto passado como par�metro tem o layout
     * compativel com o determinado para lista.
     * 
     * @param bean
     *            Objeto para verifica��o.
     * @return Resultado da verifica��o.
     */
    public boolean accepts(BusinessObject bean) {
        return getLayout().equals(bean.getLayout());
    }

    /**
     * M�todo size. Retorna o tamanho da lista.
     * 
     * @return Tamanho da lista de objetos.
     */
    public int size() {
        return this.items.size();
    }

    /**
     * M�todo isEmpty. Verifica se a lista esta vazia.
     * 
     * @return Resultado da verifica��o.
     */
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    /**
     * M�todo contains. Verifica se o item passado como par�metro esta na lista.
     * 
     * @param bean
     *            Objeto para verifica��o.
     * @return Resultado da pesquisa.
     */
    public boolean contains(BusinessObject bean) {
        return this.items.contains(bean);
    }

    /**
     * M�todo iterator. Retorna um iterador a partir da lista.
     * 
     * @return Iterador a partir da lista.
     */
    public Iterator iterator() {
        return this.items.iterator();
    }

    /**
     * M�todo toArray. Converte a lista em um array de objetos.
     * 
     * @return Array de objetos.
     */
    public Object[] toArray() {
        return this.items.toArray();
    }

    /**
     * M�todo toArray. Converte a lista em um array de
     * 
     * @see BusinessObject.
     * @param Array
     *            para constru��o do retorno.
     * @return Array de objetos.
     */
    public BusinessObject[] toArray(BusinessObject[] array) {
        return (BusinessObject[]) this.items.toArray(array);
    }

    /**
     * M�todo add. Adiciona um item a lista.
     * 
     * @param bean
     *            Item a ser adicionado.
     * @return Resultado da adi��o.
     */
    public boolean add(BusinessObject bean) {
        return this.items.add(bean);
    }

    /**
     * M�todo remove. Remove um item da lista.
     * 
     * @param bean
     *            Item a ser removido.
     * @return Resultado da remo��o.
     */
    public boolean remove(BusinessObject bean) {
        return this.items.remove(bean);
    }

    /**
     * M�todo clear. Limpa a lista de objetos.
     */
    public void clear() {
        this.items.clear();
    }

    /**
     * M�todo get. Obtem o item da lista identificado pelo �nidice passado como
     * par�metro
     * 
     * @param index
     *            �ndice para obten��o do item.
     * @return Objeto referenciado pelo �ndice na lista.
     */
    public BusinessObject get(int index) {
        return (BusinessObject) this.items.get(index);
    }

    /**
     * M�todo set. Adiciona um item na lista posicionando-o no �ndice
     * parametrizado.
     * 
     * @param index
     *            �ndice para adi��o do item.
     * @param bean
     *            Item a ser adicionado.
     * @return Objeto adicionado.
     */
    public BusinessObject set(int index, BusinessObject bean) {
        return (BusinessObject) this.items.set(index, bean);
    }

    /**
     * M�todo add. Adiciona um item na lista posicionando-o no �ndice
     * parametrizado.
     * 
     * @param index
     *            �ndice para adi��o do item.
     * @param bean
     *            Item a ser adicionado.
     */
    public void add(int index, BusinessObject bean) {
        this.items.add(index, bean);
    }

    /**
     * M�todo remove. Remove da lista o item referenciado pelo �nidice.
     * 
     * @param index
     *            �ndice para remo��o do item.
     * @return Item removido.
     */
    public BusinessObject remove(int index) {
        return (BusinessObject) this.items.remove(index);
    }

    /**
     * M�todo indexOf. Retorna o �ndice do objeto passado como par�metro.
     * 
     * @param bean
     *            Objeto para obten��o do �nidice.
     * @return �ndice do objeto.
     */
    public int indexOf(BusinessObject bean) {
        return this.items.indexOf(bean);
    }

    /**
     * M�todo lastIndexOf. Retorna o �ndice da �ltima refer�ncia ao objeto
     * passado como par�metro.
     * 
     * @param bean
     *            Objeto para pesquisa.
     * @return �nidice encontrado.
     */
    public int lastIndexOf(BusinessObject bean) {
        return this.items.lastIndexOf(bean);
    }
}