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
     * Armazena uma expressão regular válida para o tipo de dado Double.
     */
    private static final RE validFormat = loadFormat();

    /**
     * Método loadFormat. Cria uma expressão regular válida para o tipo de dado
     * Double.
     * 
     * @return RE - Expressão regular válida.
     */
    private static RE loadFormat() {
        try {
            return new RE("^(9+|(9\\([0-9]+\\)))(v9+)?$");
        } catch (Exception exc) {
            throw new WrappingException(exc);
        }
    }

    /**
     * Construtor padrão. Define um formato válido de acordo com a expressão
     * regular.
     * 
     * @param format
     */
    public DoubleValue(String format) {
        super(format);
    }

    /**
     * Método formatOn. Formata o objeto value num tipo de dado Double.
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
     * Método convert. Converte o tipo de dado Double num tipo de dado Double do
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
     * Método getValidFormat. Retorna o formato válido do tipo de dado Double.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#getValidFormat()
     * @return RE - Expressão Regular.
     */
    public RE getValidFormat() {
        return validFormat;
    }

    /**
     * Método getIntegerAmount.
     * 
     * @param value
     * @return long
     */
    private long getIntegerAmount(Double value) {
        return (long) Math.floor(value.doubleValue());
    }

    /**
     * Método getDecimalAmount.
     * 
     * @param value
     * @return long
     */
    private long getDecimalAmount(Double value) {
        return (long) (Math.floor(value.doubleValue() * 100) - (Math.floor(value.doubleValue()) * 100));
    }
}