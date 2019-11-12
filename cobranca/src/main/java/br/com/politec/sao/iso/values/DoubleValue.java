package br.com.politec.sao.iso.values;

import java.io.IOException;

import org.apache.regexp.RE;

import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Esta classe representa o tipo de dado Double utilizado no ambiente CICS.
 * Fornece suporte ao tipo de dado no envio e recebimento de mensagens ISO.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class DoubleValue extends DecimalValue {
    /**
     * Armazena uma express�o regular v�lida para o tipo de dado Double.
     */
    private static final RE validFormat = loadFormat();

    /**
     * M�todo loadFormat. Cria uma express�o regular v�lida para o tipo de dado
     * Double.
     * 
     * @return RE - Express�o regular v�lida.
     */
    private static RE loadFormat() {
        try {
            return new RE("^(9+|(9\\([0-9]+\\)))(v9+)?$");
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
    public DoubleValue(String format) {
        super(format);
    }

    /**
     * M�todo formatOn. Formata o objeto value num tipo de dado Double.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     * @param value
     * @throws IOException
     */
    public void formatOn(Appender out, Object value) throws IOException {
        final Double amount = (Double) value;
        out.append(getIntegerAmount(amount), getIntegerLength());
        out.append(getDecimalAmount(amount), getDecimalLength());
    }

    /**
     * M�todo convert. Converte o tipo de dado Double num tipo de dado Double do
     * ambiente Windows.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#convert(java.lang.String)
     * @param value
     * @return Object - Tipo de dado Double.
     */
    public Object convert(String value) {
        return Double.valueOf(putComma(value));
    }

    /**
     * M�todo getValidFormat. Retorna o formato v�lido do tipo de dado Double.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#getValidFormat()
     * @return RE - Express�o Regular.
     */
    public RE getValidFormat() {
        return validFormat;
    }

    /**
     * M�todo getIntegerAmount.
     * 
     * @param value
     * @return long
     */
    private long getIntegerAmount(Double value) {
        return (long) Math.floor(value.doubleValue());
    }

    /**
     * M�todo getDecimalAmount.
     * 
     * @param value
     * @return long
     */
    private long getDecimalAmount(Double value) {
        return (long) (Math.floor(value.doubleValue() * 100) - (Math.floor(value.doubleValue()) * 100));
    }
}