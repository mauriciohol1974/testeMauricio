package br.com.politec.sao.util;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe de encapsulamento de erros causados por falhas em operações de
 * assertion.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class AssertionError extends Error {
    /**
     * Constrói uma nova instância de <code>AssertionError</code>, contendo a
     * mensagem passada como parâmetro.
     * 
     * @param message
     */
    public AssertionError(String message) {
        super(message);
    }
}