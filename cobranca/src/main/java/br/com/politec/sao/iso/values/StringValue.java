package br.com.politec.sao.iso.values;

import java.io.IOException;

import org.apache.regexp.RE;

import br.com.politec.sao.iso.MainframeValue;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Utils;
import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Esta classe representa o tipo de dado String utilizado no ambiente CICS.
 * Fornece suporte ao tipo de dado no envio e recebimento de mensagens ISO.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class StringValue extends MainframeValue {
    /**
     * Armazena uma express�o regular v�lida para o tipo de dado String.
     */
    private static final RE validFormat = loadFormat();

    /**
     * M�todo loadFormat. Cria uma express�o regular v�lida para o tipo de dado
     * String.
     * 
     * @return RE - Express�o regular v�lida.
     */
    private static RE loadFormat() {
        try {
            return new RE("^((X+)|(X\\([0-9]+\\)))$");
        } catch (Exception exc) {
            throw new WrappingException(exc);
        }
    }

    /**
     * Construtor padr�o. Define um formato v�lido de acordo com a express�o
     * regular.
     * 
     * @param format
     */
    public StringValue(String format) {
        super(format);
    }

    /**
     * M�todo formatOn. Formata o objeto value num tipo de dado String.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     * @param value
     * @throws IOException
     */
    public void formatOn(Appender out, Object value) throws IOException {
        out.append((String) value, getLength());
    }

    /**
     * M�todo getLength. Retorna o tamanho do tipo de dado String.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#getLength()
     * @return int
     */
    public int getLength() {
        return getBasicLength();
    }

    /**
     * M�todo convert. Converte o tipo de dado String num tipo de dado String do
     * ambiente Windows.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#convert(java.lang.String)
     * @param value
     * @return Object - Tipo de dado String.
     */
    public Object convert(String value) {
        // GMG: remover apenas espacos em branco do fim do valor.
        // return value.trim();
        return Utils.rtrim(value);
    }

    /**
     * M�todo getValidFormat. Retorna o formato v�lido do tipo de dado String.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#getValidFormat()
     * @return RE - Express�o Regular.
     */
    public RE getValidFormat() {
        return validFormat;
    }
}