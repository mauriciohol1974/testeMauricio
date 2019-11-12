package br.com.politec.sao.util;

import java.io.IOException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Interface padrão de qualquer objeto que saiba se escrever em um
 * <code>Appender</code>.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 * @see Appender
 * @see StringAppender
 */
public interface Appendable {
    /**
     * Método appendTo. Escreve o objeto que implementa o método num
     * <code>Appender</code>. Caso durante o processa de escrita ocorra um
     * erro, ele poderá ser repassado ao cliente.
     * 
     * @param appender
     *            appender no qual o objeto deve se escrever
     * @throws IOException
     *             caso ocorra algum erro na saída dos dados
     */
    public void appendTo(Appender appender) throws IOException;
}
