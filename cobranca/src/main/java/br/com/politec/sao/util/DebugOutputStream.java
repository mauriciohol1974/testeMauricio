package br.com.politec.sao.util;

import java.io.IOException;
import java.io.OutputStream;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * <i>Decorator</i> que registra os dados em um <code>OutputStream</code> e
 * no objeto de escrita auxiliar informado.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 * @see Appender
 */
public class DebugOutputStream extends OutputStream {
    /**
     * Constr�i um novo <code>DebugStream</code> com a sa�da real e o objeto
     * de registro associados.
     * 
     * @param out
     *            sa�da real dos dados
     * @param registro
     *            objeto de escrita auxiliar
     * @requires out != null : "Sa�da deve existir"
     * @requires registro != null : "Registro deve existir"
     */
    public DebugOutputStream(OutputStream out,
            Appender registro) {
        Assertions.requires(out != null, "Sa�da deve existir");
        Assertions.requires(registro != null, "Registro deve existir");
        this.out = out;
        this.registro = registro;
    }

    /**
     * Escreve um <code>byte</code> na sa�da de dados real e registra esse
     * dado.
     * 
     * @param b
     *            <code>byte</code> que deve sr escrito
     * @throws IOException
     *             caso ocorra um erro durante a escrita dos dados
     */
    public void write(int b) throws IOException {
        this.registro.write(b);
        this.out.write(b);
    }

    /**
     * Escreve um <code>array</code> de <code>byte</code>s.
     * 
     * @param bytes
     *            <code>array</code> de <code>byte</code>s � ser escrito
     * @throws IOException
     *             caso ocorra um erro durante a escrita dos dados
     */
    public void write(byte[] bytes) throws IOException {
        this.registro.write(bytes);
        this.out.write(bytes);
    }

    /**
     * Escreve <i>length</i> bytes do <code>array</code> <code>bytes</code>
     * � partir da posi��o <i>offset</i>.
     * 
     * @param bytes
     *            <code>array</code> de <code>byte</code>s � ser escrito
     * @param offset
     *            posi��o inicial do <code>array</code>
     * @param length
     *            n�mero de bytes � ser escrito
     */
    public void write(byte[] bytes, int offset, int length) throws IOException {
        this.registro.write(bytes, offset, length);
        this.out.write(bytes, offset, length);
    }

    /**
     * For�a o canal de sa�da interno e o registro efetuarem um <i>flush</i>.
     * 
     * @throws IOException
     *             caso ocorra um erro durante o <i>flush</i>
     */
    public void flush() throws IOException {
        this.out.flush();
        LogUtilSigcb.info("[" + this.registro.toString() + "]");
    }

    /**
     * Canal de sa�da decorado.
     */
    private final OutputStream out;

    /**
     * Objeto de escrita auxiliar.
     */
    private final Appender registro;
}