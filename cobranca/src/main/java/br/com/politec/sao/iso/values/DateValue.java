package br.com.politec.sao.iso.values;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.regexp.RE;

import br.com.politec.sao.iso.MainframeValue;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Esta classe representa o tipo de dado Date utilizado no ambiente CICS.
 * Fornece suporte ao tipo de dado no envio e recebimento de mensagens ISO.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class DateValue extends MainframeValue {
    /**
     * Armazena uma expressão regular válida para o tipo de dado Date.
     */
    private static final RE validFormat = loadFormat();

    /**
     * Método loadFormat. Cria uma expressão regular válida para o tipo de dado
     * Date.
     * 
     * @return RE - Expressão regular válida.
     */
    private static RE loadFormat() {
        try {
            return new RE("^dd(.)?MM(.)?yyyy$");
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
    public DateValue(String format) {
        super(format);
    }

    /**
     * Método formatOn. Formata o objeto value num tipo de dado Date.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     * @param value
     * @throws IOException
     */
    public void formatOn(Appender out, Object value) throws IOException {
        if (value != null) {
            out.append(getDateFormat().format((Date) value));
        } else {
            // preenche com espacos em branco
            for (int i = 0; i < getLength(); i++) {
                out.append(" ");
            }
        }
    }

    /**
     * Método getLength. Retorna o tamanho do tipo de dado Date.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#getLength()
     * @return int
     */
    public int getLength() {
        // Alterado para o caso de a data vir junto com os separadores
        // format = dd.MM.yyyy
        return this.getFormat().length();
    }

    /**
     * Método convert. Converte o tipo de dado Date num tipo de dado Date do
     * ambiente Windows.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#convert(java.lang.String)
     * @param value
     * @return Object - Tipo de dado Date.
     */
    public Object convert(String value) {
        try {
            if (value != null && !value.trim().equals("")) {
                SimpleDateFormat sdf = new SimpleDateFormat(getFormat()
                                                            + " HH:mm");
                // bug do horario de verao
                // a hora default eh 00:00, mas se for no dia da mudanca para
                // horario de verao, a hora atrasa 1 hora e o dia volta para o
                // anterior, por isso setando a hora para meio dia
                return sdf.parse(value + " 12:00");
            } else {
                return null;
            }
        } catch (ParseException exc) {
            throw new WrappingException(exc);
        }
    }

    /**
     * Método getValidFormat. Retorna o formato válido do tipo de dado Date.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#getValidFormat()
     * @return RE - Expressão Regular.
     */
    public RE getValidFormat() {
        return validFormat;
    }

    /**
     * Método getDateFormat. Retorna o tipo de dado Date formatado.
     * 
     * @return SimpleDateFormat - Tipo de dado Date formatado.
     */
    private SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat(getFormat());
    }
}