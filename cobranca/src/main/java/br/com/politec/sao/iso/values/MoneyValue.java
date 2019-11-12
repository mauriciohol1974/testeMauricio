package br.com.politec.sao.iso.values;

import java.io.IOException;

import org.apache.regexp.RE;

import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Esta classe representa o tipo de dado Money utilizado no ambiente CICS.
 * Fornece suporte ao tipo de dado no envio e recebimento de mensagens ISO.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class MoneyValue extends DecimalValue {
    /**
     * Armazena uma express�o regular v�lida para o tipo de dado Money.
     */
    private static final RE validFormat = loadFormat();

    /**
     * M�todo loadFormat. Cria uma express�o regular v�lida para o tipo de dado
     * Money.
     * 
     * @return RE - Express�o regular v�lida.
     */
    private static RE loadFormat() {
        try {
            return new RE("^([A-Z]+\\$) (9+|(9\\([0-9]+\\)))(v9+)?$");
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
    public MoneyValue(String format) {
        super(format);
    }

    /**
     * M�todo formatOn. Formata o objeto value num tipo de dado Money.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     * @param value
     * @throws IOException
     */
    public void formatOn(Appender out, Object value) throws IOException {
        final Money amount = (Money) value;
        out.append(amount.getIntegerAmount(), getIntegerLength());
        out.append(amount.getDecimalAmount(), getDecimalLength());
    }

    /**
     * M�todo convert. Converte o tipo de dado Money num tipo de dado Money do
     * ambiente Windows.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#convert(java.lang.String)
     * @param value
     * @return Object - Tipo de dado Money.
     */
    public Object convert(String value) {
        return new Money(putComma(value), Currency.get("R$"));
    }

    /**
     * M�todo getValidFormat. Retorna o formato v�lido do tipo de dado Money.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#getValidFormat()
     * @return RE - Express�o Regular.
     */
    public RE getValidFormat() {
        return validFormat;
    }
}