package br.com.politec.sao.util;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe de encapsulamento de erros causados por falhas em opera��es de
 * assertion.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class AssertionError extends Error {
    /**
     * Constr�i uma nova inst�ncia de <code>AssertionError</code>, contendo a
     * mensagem passada como par�metro.
     * 
     * @param message
     */
    public AssertionError(String message) {
        super(message);
    }
}