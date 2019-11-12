package br.com.politec.sao.util;

import java.io.StringWriter;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * <code>Appender</code> especializado que utiliza um
 * <code>StringWriter</code> como saída de dados. A qualquer momento pode-se
 * solicitar á esse objeto os dados que foram escritos desde a sua criação, e
 * eles serão retornados como uma <code>String</code>.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version 1.3
 * @see Appender
 * @see Appendable
 */
public class StringAppender extends Appender {
    /**
     * Referência ao <code>StringWriter</code> para poder obter os dados dele
     * e manipulá-lo.
     */
    private final StringWriter out;

    /**
     * Contrutor mais otimizado, onde o cliente informa qual é o tamanho que ele
     * espera que seja utilizado, em número de caracteres para escrever tudo que
     * ele deseja.
     * 
     * @param size
     *            quantidade de caracteres que o cliente espera utilizar
     */
    public StringAppender(int size) {
        this(new StringWriter(size));
    }

    /**
     * Contrutor menos otimizado. A capacidade inicial do
     * <code>StringWriter</code> interno é inicializada em 16.
     */
    public StringAppender() {
        this(16);
    }

    /**
     * Contrutor interno que repassa o <code>StringWriter</code> ao construtor
     * da super-classe.
     * 
     * @param out
     *            <code>StringWriter</code> a ser utilizado
     */
    private StringAppender(StringWriter out) {
        super(out);
        this.out = out;
    }

    /**
     * Retorna tudo que foi escrito no até agora através deste objeto como um
     * <code>String</code>.
     * 
     * @return tudo que foi escrito até agora através deste objeto
     */
    public String getText() {
        return this.out.getBuffer().toString();
    }

    /**
     * Retorna o tamanho de tudo que foi escrito até agora através deste objeto.
     * 
     * @return o tamanho de tudo que foi escrito até agora através deste objeto
     */
    public int size() {
        return this.out.getBuffer().length();
    }

    /**
     * Limpa tudo que foi escrito até agora.
     */
    public void clear() {
        this.out.getBuffer().setLength(0);
    }

    /**
     * Limpa tudo que foi escrito até agora, e deixa uma capacidade de
     * armazenamento esperada de <i>tamanho</i>.
     * 
     * @param size
     *            quantidade de caracteres que o cliente espera utilizar
     * @requires size >= 0 : "Tamanho não deve ser negativo"
     */
    public void clearLeaving(int size) {
        Assertions.requires(size >= 0, "Tamanho não deve ser negativo");
        this.out.getBuffer().setLength(size);
        this.out.getBuffer().delete(0, size);
    }
}