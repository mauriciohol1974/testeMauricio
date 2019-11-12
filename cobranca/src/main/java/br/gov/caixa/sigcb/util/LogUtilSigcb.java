package br.gov.caixa.sigcb.util;

import java.io.Serializable;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Classe wrapper responsável por encapsular os acessos ao o lo4j. Como uma
 * classe de encapsulamento, torna o lo4j transparente para a aplicacao,
 * permitindo realizar log, para registro de operações e erros atravez de uma
 * interface simples. Atualmente, a classe suporta cinco níveis distintos de
 * log:
 * <ul>
 * <li>Debug (Nível 5): Lança para o log todo e qualquer registro, independente
 * de criticidade</li>
 * <li>Info (Nível 4): Lança para o log registros de critidade média, não
 * registrando entradas para debug</li>
 * <li>Warn (Nível 3): Lança para o log apenas registros de erros ...</li>
 * <li>Error (Nível 2): Lança para o log apenas registros de erros ...</li>
 * <li>Fatal (Nível 1): Lança para o log apenas registros de erros fatais, que
 * não deveriam ocorrer e impedem o funcionamento do sistema</li>
 * </ul>
 * De forma similar, o lançamento de um novo registro deve ser feito por um
 * método correspondente ao nível do registro sendo lançado em log. Só serão
 * gravados para o log os registros de nível igual ou inferior ao nível
 * escolhido para a operação do log. Isso permite habilitar ou desabilitar um
 * nível de registro de log, sem a necessidade de remover as cláusulas em código
 * correspondentes ao mesmo, apenas inibindo ou não seu lançamento. Quando
 * colocado em produção, aconselha-se que o nível de log seja mantido em
 * "Fatal", registrando apenas ocorrências críticas e incomuns.
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br - Data:30/08/2004
 */
public class LogUtilSigcb implements Serializable {
	private static final long serialVersionUID = -1562204615416562524L;
	private static final Logger log = Logger.getLogger(br.gov.caixa.sigcb.util.LogUtilSigcb.class);

    /**
     * Lança um registro de nível DEBUG no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void debug(String message) {
        log.debug(message);
    }

    /**
     * Lança um registro de nível DEBUG no log do sistema.
     * 
     * @param String
     *            mensagem
     * @param Throwable
     */
    public static void debug(String message, Throwable t) {
        log.debug(message, t);
    }

    /**
     * Lança um registro de nível INFO no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void info(String message) {
        log.info(message);
    }

    /**
     * Lança um registro de nível INFO no log do sistema.
     * 
     * @param String
     *            mensagem
     * @param Throwable
     */
    public static void info(String message, Throwable t) {
        log.info(message, t);
    }

    /**
     * Lança um registro de nível WARN no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void warn(String message) {
        log.warn(message);
    }

    /**
     * Lança um registro de nível WARN no log do sistema.
     * 
     * @param String
     *            mensagem
     * @param Throwable
     */
    public static void warn(String message, Throwable t) {
        log.warn(message, t);
    }

    /**
     * Lança um registro de nível ERROR no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void error(String message) {
        log.error(message);
    }

    /**
     * Lança um registro de nível ERROR no log do sistema.
     * 
     * @param String
     *            mensagem
     * @param Throwable
     */
    public static void error(String message, Throwable t) {
        log.error(message, t);
    }

    /**
     * Lança um registro de nível FATAL no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void fatal(String message) {
        log.fatal(message);
    }

    /**
     * Lança um registro de nível DEBUG no log do sistema.
     * 
     * @param String
     *            mensagem
     */
    public static void print(String msg) {
        log.debug(msg);
    }

    /**
     * Lança um registro de nível ERROR no log do sistema.
     * 
     * @param String
     *            mensagem
     * @param Throwable
     */
    public static void print(String msg, Throwable t) {
        log.error(msg, t);
    }

    /**
     * Lança um registro de nível ERROR no log do sistema.
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
