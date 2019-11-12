package br.com.politec.sao.util;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe de implementação de <i>Assertions</i>, permitindo o uso de assertions
 * mesmo em versões de máquina virtual anteriores à 1.4, quando a plataforma
 * passou a suportar o uso de <i>assertions</i> em código.
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
     * um trecho de código que nunca deveria ser atingido, o foi.
     * 
     * @param String
     *            mensagem a ser passada no erro
     */
    public static final void unreacheable(String message) {
        throw new AssertionError(message);
    }

    /**
     * Retorna um <code>AssertionError</code> caso invocado, significando que
     * um trecho de código que nunca deveria ser atingido, o foi.
     */
    public static final void unreacheable() {
        throw new AssertionError("Reached a unreachable statement!");
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condição seja falsa.
     * 
     * @param boolean
     *            condição
     * @param String
     *            a mensagem a ser passada no erro
     */
    public static final void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condição seja falsa.
     * 
     * @param boolean
     *            condição sendo verificada
     * @param String
     *            a mensagem a ser passada no erro
     */
    public static final void ensures(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condição seja falsa.
     * 
     * @param boolean
     *            condição sendo verificada
     * @param String
     *            a mensagem a ser passada no erro
     */
    public static final void invariant(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condição seja falsa.
     * 
     * @param boolean
     *            condição sendo verificada
     * @param String
     *            a mensagem a ser passada no erro
     */
    public static final void requires(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condição seja falsa.
     * 
     * @param boolean
     *            condição
     */
    public static final void check(boolean condition) {
        Assertions.check(condition, "Check failed!");
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condição seja falsa.
     * 
     * @param boolean
     *            condição
     */
    public static final void ensures(boolean condition) {
        Assertions.ensures(condition, "Contract broken!");
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condição seja falsa.
     * 
     * @param boolean
     *            condição
     */
    public static final void invariant(boolean condition) {
        Assertions.invariant(condition, "Contract broken!");
    }

    /**
     * Retorna um <code>AssertionError</code> caso a condição seja falsa.
     * 
     * @param boolean
     *            condição
     */
    public static final void requires(boolean condition) {
        Assertions.requires(condition, "Contract broken!");
    }

    /**
     * A partir de uma premissa, retorna a conclusão caso a premissa seja
     * verdadeira, ou então, <i>true</i> caso a premissa seja falsa.
     * 
     * @return boolean
     * @param boolean
     *            premissa
     * @param boolean
     *            conclusão
     */
    public static final boolean implies(boolean premise, boolean conclusion) {
        return premise ? conclusion : true;
    }
}