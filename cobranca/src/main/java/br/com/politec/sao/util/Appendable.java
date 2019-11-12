package br.com.politec.sao.util;

import java.io.IOException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Interface padr�o de qualquer objeto que saiba se escrever em um
 * <code>Appender</code>.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 * @see Appender
 * @see StringAppender
 */
public interface Appendable {
    /**
     * M�todo appendTo. Escreve o objeto que implementa o m�todo num
     * <code>Appender</code>. Caso durante o processa de escrita ocorra um
     * erro, ele poder� ser repassado ao cliente.
     * 
     * @param appender
     *            appender no qual o objeto deve se escrever
     * @throws IOException
     *             caso ocorra algum erro na sa�da dos dados
     */
    public void appendTo(Appender appender) throws IOException;
}
