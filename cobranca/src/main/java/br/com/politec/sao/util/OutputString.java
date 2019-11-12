package br.com.politec.sao.util;

import java.io.IOException;
import java.io.OutputStream;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Implementação de um <code>OutputStream</code> que armazena o que for
 * escrito nele internamente e permite obter posteriormente os dados como uma
 * <code>String</code>. Respeita o contrato de <code>OutputStream</code> no
 * que diz respeito ao fechamento do fluxo de saída.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class OutputString extends OutputStream {
    /**
     * Constrói um novo fluxo de saída com o tamanho inicial do <i>buffer</i>
     * interno definido.
     * 
     * @param initialSize
     *            tamanho inicial do <i>buffer</i> interno definido
     */
    public OutputString(int initialSize) {
        this.out = new StringBuffer(initialSize);
    }

    /**
     * Constrói um novo fluxo de saída.
     */
    public OutputString() {
        this.out = new StringBuffer();
    }

    /**
     * Armazena o byte <i>b</i> escrito internamente.
     * 
     * @param b
     *            byte a ser escrito
     * @throws IOException
     *             caso o fluxo de saída esteja fechado
     */
    public void write(int b) throws IOException {
        if (this.closed) {
            throw new IOException("OutputStream is closed");
        }
        this.out.append((byte) b);
    }

    /**
     * Armazena os <i>bytes</i> escritos internamente.
     * 
     * @param bytes
     *            <code>array</code> que contém os dados a serem escritos
     * @throws IOException
     *             caso o fluxo de saída esteja fechado
     */
    public void write(byte[] bytes) throws IOException {
        if (this.closed) {
            throw new IOException("OutputStream is closed");
        }
        this.out.append(new String(bytes));
    }

    /**
     * Armazena os <i>bytes</i> escritos internamente, que estejam entre
     * <i>offset</i> e <i>offset + length</i>.
     * 
     * @param bytes
     *            <code>array</code> que contém os dados a serem escritos
     * @param offset
     *            posição inicial a ser lida do <code>array</code>
     * @param length
     *            quantidade de bytes a serem lidos do <code>array</code>
     * @throws IndexOutOfBoundsException
     *             caso <i>offset</i> ou <i>length</i> sejam inválidos
     * @throws IOException
     *             caso o fluxo de saída esteja fechado
     */
    public void write(byte[] bytes, int offset, int length) throws IOException {
        if (this.closed) {
            throw new IOException("OutputStream is closed");
        }
        this.out.append(new String(bytes, offset, length));
    }

    /**
     * Não faz nada.
     */
    public void flush() {
    }

    /**
     * Fecha esse fluxo de saída, impedindo que outros utilizem-no após isso.
     */
    public void close() {
        this.closed = true;
    }

    /**
     * Retorna o conteúdo do escrito nesta instância como uma
     * <code>String</code>.
     * 
     * @return <code>String</code> que contém todo o conteúdo escrito
     */
    public String toString() {
        return this.out.toString();
    }

    /** Controla o fechamento desta instância. */
    private boolean closed = false;

    /** <i>Buffer</i> interno usado para armazenar os dados escritos. */
    private final StringBuffer out;
}
