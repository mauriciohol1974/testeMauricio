package br.com.politec.sao.util;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe de implementa��o de <i>Assertions</i>, permitindo o uso de assertions
 * mesmo em vers�es de m�quina virtual anteriores � 1.4, quando a plataforma
 * passou a suportar o uso de <i>assertions</i> em c�digo.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public final class Assertions {
    /**
     * Construtor default.
     */
    private Assertions() {
    }

    /**
     * Retorna um <code>AssertionError</code> caso invocado, significando que
     * um trecho de c�digo que nunca deveria ser atingido, o foi.
     * 
     * @param String
     *            mensagem a ser passada no erro
     */
    public static final void unreacheable(String message) {
        throw new AssertionError(message);
    }

    /**
     * Retorna um <code>AssertionError</code> caso invocado, significando que
     * um trecho de c�digo que nunca deveria ser atingido, o foi.
     */
    public static final void unreacheable() {
        throw new AssertionError("Reached a unreachable statement!");
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condi��o seja falsa.
     * 
     * @param boolean
     *            condi��o
     * @param String
     *            a mensagem a ser passada no erro
     */
    public static final void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condi��o seja falsa.
     * 
     * @param boolean
     *            condi��o sendo verificada
     * @param String
     *            a mensagem a ser passada no erro
     */
    public static final void ensures(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condi��o seja falsa.
     * 
     * @param boolean
     *            condi��o sendo verificada
     * @param String
     *            a mensagem a ser passada no erro
     */
    public static final void invariant(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condi��o seja falsa.
     * 
     * @param boolean
     *            condi��o sendo verificada
     * @param String
     *            a mensagem a ser passada no erro
     */
    public static final void requires(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condi��o seja falsa.
     * 
     * @param boolean
     *            condi��o
     */
    public static final void check(boolean condition) {
        Assertions.check(condition, "Check failed!");
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condi��o seja falsa.
     * 
     * @param boolean
     *            condi��o
     */
    public static final void ensures(boolean condition) {
        Assertions.ensures(condition, "Contract broken!");
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condi��o seja falsa.
     * 
     * @param boolean
     *            condi��o
     */
    public static final void invariant(boolean condition) {
        Assertions.invariant(condition, "Contract broken!");
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condi��o seja falsa.
     * 
     * @param boolean
     *            condi��o
     */
    public static final void requires(boolean condition) {
        Assertions.requires(condition, "Contract broken!");
    }

    /**
     * A partir de uma premissa, retorna a conclus�o caso a premissa seja
     * verdadeira, ou ent�o, <i>true</i> caso a premissa seja falsa.
     * 
     * @return boolean
     * @param boolean
     *            premissa
     * @param boolean
     *            conclus�o
     */
    public static final boolean implies(boolean premise, boolean conclusion) {
        return premise ? conclusion : true;
    }
}