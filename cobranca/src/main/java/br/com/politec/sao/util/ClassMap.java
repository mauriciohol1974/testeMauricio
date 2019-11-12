package br.com.politec.sao.util;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * ClassLoader simples, utilizado como classe de suporte à criação de novas
 * instâncias por reflexão.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class ClassMap {
    private final Map classes;

    /**
     * Construtor default.
     */
    public ClassMap() {
        this.classes = new TreeMap();
    }

    /**
     * Retorna uma nova instância da classe cujo nome é passado como parâmetro.
     * 
     * @return Object
     * @param String
     *            contendo o nome completo da classe a ser instanciada
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public synchronized Object newInstance(String className)
            throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        Assertions.requires(className != null);
        return forName(className).newInstance();
    }

    /**
     * Retorna uma instância da classe <code>Class</code> representando a
     * classe cujo nome é passado como parâmetro.
     * 
     * @return Class
     * @param String
     *            contendo o nome completo da classe a ser instanciada
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public synchronized Class forName(String className)
            throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        Assertions.requires(className != null);
        if (!this.classes.containsKey(className)) {
            this.classes.put(className, Class.forName(className));
        }
        return (Class) this.classes.get(className);
    }

    /**
     * Retorna uma instância de <code>Iterator</code> para todas as instâncias
     * de todas as classes armazenadas internamente.
     * 
     * @return Iterator
     */
    public synchronized Iterator classes() {
        return this.classes.values().iterator();
    }

    /**
     * Retorna o resultado da checagem se uma classe, cujo nome é informado
     * através do parâmetro, existe dentro do mapa de classes.
     * 
     * @return boolean
     * @param String
     */
    public synchronized boolean exists(String className) {
        Assertions.requires(className != null);
        boolean result = true;
        if (!this.classes.containsKey(className)) {
            try {
                this.classes.put(className, Class.forName(className));
                result = true;
            } catch (Exception exc) {
                result = false;
            }
        }
        return result;
    }
}