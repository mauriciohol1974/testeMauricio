package br.com.politec.sao.iso.values;

import java.io.IOException;

import org.apache.regexp.RE;

import br.com.politec.sao.iso.MainframeValue;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Esta classe representa o tipo de dado Integer utilizado no ambiente CICS.
 * Fornece suporte ao tipo de dado no envio e recebimento de mensagens ISO.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class IntegerValue extends MainframeValue {
    /**
     * Armazena uma expressão regular válida para o tipo de dado Integer.
     */
    private static final RE validFormat = loadFormat();

    /**
     * Método loadFormat. Cria uma expressão regular válida para o tipo de dado
     * Integer.
     * 
     * @return RE - Expressão regular válida.
     */
    private static RE loadFormat() {
        try {
            return new RE("^((9+)|(9\\([0-9]+\\)))$");
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
    public IntegerValue(String format) {
        super(format);
    }

    /**
     * Método formatOn. Formata o objeto value num tipo de dado Integer.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     * @param value
     * @throws IOException
     */
    public void formatOn(Appender out, Object value) throws IOException {
        out.append(((Integer) value).intValue(), getLength());
    }

    /**
     * Método getLength. Retorna o tamanho do tipo de dado Integer.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#getLength()
     * @return int
     */
    public int getLength() {
        return getBasicLength();
    }

    /**
     * Método convert. Converte o tipo de dado Integer num tipo de dado Integer
     * do ambiente Windows.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#convert(java.lang.String)
     * @param value
     * @return Object - Tipo de dado Integer.
     */
    public Object convert(String value) {
        return Integer.valueOf(value);
    }

    /**
     * Método getValidFormat. Retorna o formato válido do tipo de dado Integer.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#getValidFormat()
     * @return RE - Expressão Regular.
     */
    public RE getValidFormat() {
        return validFormat;
    }
}