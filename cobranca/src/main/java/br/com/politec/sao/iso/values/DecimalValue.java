package br.com.politec.sao.iso.values;

import br.com.politec.sao.iso.MainframeValue;
import br.com.politec.sao.util.StringUtils;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Esta classe representa o tipo de dado Decimal utilizado no ambiente CICS.
 * Fornece suporte ao tipo de dado no envio e recebimento de mensagens ISO.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class DecimalValue extends MainframeValue {
    /**
     * Construtor padrão. Define um formato válido de acordo com a expressão
     * regular.
     * 
     * @param format
     */
    public DecimalValue(String format) {
        super(format);
    }

    /**
     * Método getLength. Retorna o tamanho do tipo de dado Decimal.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#getLength()
     * @return int
     */
    public int getLength() {
        return getIntegerLength() + getDecimalLength();
    }

    /**
     * Método getDecimalLength. Retorna o número de casas decimais do tipo de
     * dado Decimal.
     * 
     * @return int
     */
    protected int getDecimalLength() {
        int commaIndex = getFormat().indexOf("v");
        int result = 0;
        if (commaIndex != -1) {
            result = StringUtils.countOf("9",
                    getFormat().substring(commaIndex + 1));
        }
        return result;
    }

    /**
     * Método getIntegerLength. Retorna o número de dígitos da parte inteira de
     * um tipo de dado Decimal.
     * 
     * @return int
     */
    protected int getIntegerLength() {
        return getBasicLength();
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
}