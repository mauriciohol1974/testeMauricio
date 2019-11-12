package br.com.politec.sao.iso.values;

import java.io.IOException;

import org.apache.regexp.RE;

import br.com.politec.sao.iso.MainframeValue;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Percentual;
import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Esta classe representa o tipo de dado Percentual utilizado no ambiente CICS.
 * Fornece suporte ao tipo de dado no envio e recebimento de mensagens ISO.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class PercentualValue extends MainframeValue {

    /**
     * Armazena uma expressão regular válida para o tipo de dado Percentual.
     */
    private static final RE validFormat = loadFormat();

    /**
     * @param format
     */
    public PercentualValue(String format) {
        super(format);
    }

    /**
     * Método loadFormat. Cria uma expressão regular válida para o tipo de dado
     * Percentual.
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

    public RE getValidFormat() {
        return validFormat;
    }

    public void formatOn(Appender out, Object value) throws IOException {
        final Percentual amount = (Percentual) value;
        if (amount != null) {
            out.appendNumber(amount.toValorSemPonto(), getLength());
        } else {
            out.append("00000");
        }
    }

    public Object convert(String value) {
        return new Percentual(putComma(value));
    }

    public int getDecimalLength() {
        return 2;
    }

    /**
     * Método putComma. Insere o caractere separador decimal (.) num número
     * decimal.
     * 
     * @param number
     * @return String - Número decimal
     */
    protected String putComma(String number) {
        StringBuffer result = new StringBuffer(number.length() + 1);
        result.append(number.substring(0, number.length() - getDecimalLength()));
        result.append(".");
        result.append(number.substring(number.length() - getDecimalLength()));
        return result.toString();
    }

    public int getLength() {
        return getBasicLength();
    }
}
