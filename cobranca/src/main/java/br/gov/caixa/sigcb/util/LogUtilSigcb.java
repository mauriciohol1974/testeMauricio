package br.gov.caixa.sigcb.util;

import java.io.Serializable;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Classe wrapper respons�vel por encapsular os acessos ao o lo4j. Como uma
 * classe de encapsulamento, torna o lo4j transparente para a aplicacao,
 * permitindo realizar log, para registro de opera��es e erros atravez de uma
 * interface simples. Atualmente, a classe suporta cinco n�veis distintos de
 * log:
 * <ul>
 * <li>Debug (N�vel 5): Lan�a para o log todo e qualquer registro, independente
 * de criticidade</li>
 * <li>Info (N�vel 4): Lan�a para o log registros de critidade m�dia, n�o
 * registrando entradas para debug</li>
 * <li>Warn (N�vel 3): Lan�a para o log apenas registros de erros ...</li>
 * <li>Error (N�vel 2): Lan�a para o log apenas registros de erros ...</li>
 * <li>Fatal (N�vel 1): Lan�a para o log apenas registros de erros fatais, que
 * n�o deveriam ocorrer e impedem o funcionamento do sistema</li>
 * </ul>
 * De forma similar, o lan�amento de um novo registro deve ser feito por um
 * m�todo correspondente ao n�vel do registro sendo lan�ado em log. S� ser�o
 * gravados para o log os registros de n�vel igual ou inferior ao n�vel
 * escolhido para a opera��o do log. Isso permite habilitar ou desabilitar um
 * n�vel de registro de log, sem a necessidade de remover as cl�usulas em c�digo
 * correspondentes ao mesmo, apenas inibindo ou n�o seu lan�amento. Quando
 * colocado em produ��o, aconselha-se que o n�vel de log seja mantido em
 * "Fatal", registrando apenas ocorr�ncias cr�ticas e incomuns.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br - Data:30/08/2004
 */
public class LogUtilSigcb implements Serializable {
	private static final long serialVersionUID = -1562204615416562524L;
	private static final Logger log = Logger.getLogger(br.gov.caixa.sigcb.util.LogUtilSigcb.class);

    /**
     * Lan�a um registro de n�vel DEBUG no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void debug(String message) {
        log.debug(message);
    }

    /**
     * Lan�a um registro de n�vel DEBUG no log do sistema.
     * 
     * @param String
     *            mensagem
     * @param Throwable
     */
    public static void debug(String message, Throwable t) {
        log.debug(message, t);
    }

    /**
     * Lan�a um registro de n�vel INFO no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void info(String message) {
        log.info(message);
    }

    /**
     * Lan�a um registro de n�vel INFO no log do sistema.
     * 
     * @param String
     *            mensagem
     * @param Throwable
     */
    public static void info(String message, Throwable t) {
        log.info(message, t);
    }

    /**
     * Lan�a um registro de n�vel WARN no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void warn(String message) {
        log.warn(message);
    }

    /**
     * Lan�a um registro de n�vel WARN no log do sistema.
     * 
     * @param String
     *            mensagem
     * @param Throwable
     */
    public static void warn(String message, Throwable t) {
        log.warn(message, t);
    }

    /**
     * Lan�a um registro de n�vel ERROR no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void error(String message) {
        log.error(message);
    }

    /**
     * Lan�a um registro de n�vel ERROR no log do sistema.
     * 
     * @param String
     *            mensagem
     * @param Throwable
     */
    public static void error(String message, Throwable t) {
        log.error(message, t);
    }

    /**
     * Lan�a um registro de n�vel FATAL no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void fatal(String message) {
        log.fatal(message);
    }

    /**
     * Lan�a um registro de n�vel DEBUG no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void print(String msg) {
        log.debug(msg);
    }

    /**
     * Lan�a um registro de n�vel ERROR no log do sistema.
     * 
     * @param String
     *            mensagem
     * @param Throwable
     */
    public static void print(String msg, Throwable t) {
        log.error(msg, t);
    }

    /**
     * Lan�a um registro de n�vel ERROR no log do sistema.
     * 
     * @param String
     *            mensagem
     * @param Throwable
     */
    public static void fatal(String message, Throwable t) {
        log.fatal(message, t);
    }

    public static boolean isDebugEnabled() {
        return (log.isDebugEnabled());
    }

    public static boolean isInfoEnabled() {
        return (log.isInfoEnabled());
    }

    public static boolean isWarnEnabled() {
        return (log.isEnabledFor(Level.WARN));
    }

    public static boolean isErrorEnabled() {
        return (log.isEnabledFor(Level.ERROR));
    }

    public static boolean isFatalEnabled() {
        return (log.isEnabledFor(Level.FATAL));
    }
}
