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
     * Constrói um novo <code>DebugStream</code> com a saída real e o objeto
     * de registro associados.
     * 
     * @param out
     *            saída real dos dados
     * @param registro
     *            objeto de escrita auxiliar
     * @requires out != null : "Saída deve existir"
     * @requires registro != null : "Registro deve existir"
     */
    public DebugOutputStream(OutputStream out,
            Appender registro) {
        Assertions.requires(out != null, "Saída deve existir");
        Assertions.requires(registro != null, "Registro deve existir");
        this.out = out;
        this.registro = registro;
    }

    /**
     * Escreve um <code>byte</code> na saída de dados real e registra esse
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
     *            <code>array</code> de <code>byte</code>s à ser escrito
     * @throws IOException
     *             caso ocorra um erro durante a escrita dos dados
     */
    public void write(byte[] bytes) throws IOException {
        this.registro.write(bytes);
        this.out.write(bytes);
    }

    /**
     * Escreve <i>length</i> bytes do <code>array</code> <code>bytes</code>
     * á partir da posição <i>offset</i>.
     * 
     * @param bytes
     *            <code>array</code> de <code>byte</code>s à ser escrito
     * @param offset
     *            posição inicial do <code>array</code>
     * @param length
     *            número de bytes à ser escrito
     */
    public void write(byte[] bytes, int offset, int length) throws IOException {
        this.registro.write(bytes, offset, length);
        this.out.write(bytes, offset, length);
    }

    /**
     * Força o canal de saída interno e o registro efetuarem um <i>flush</i>.
     * 
     * @throws IOException
     *             caso ocorra um erro durante o <i>flush</i>
     */
    public void flush() throws IOException {
        this.out.flush();
        LogUtilSigcb.info("[" + this.registro.toString() + "]");
    }

    /**
     * Canal de saída decorado.
     */
    private final OutputStream out;

    /**
     * Objeto de escrita auxiliar.
     */
    private final Appender registro;
}