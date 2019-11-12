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
     * Construtor padr�o. Define um formato v�lido de acordo com a express�o
     * regular.
     * 
     * @param format
     */
    public DecimalValue(String format) {
        super(format);
    }

    /**
     * M�todo getLength. Retorna o tamanho do tipo de dado Decimal.
     * 
     * @see br.com.politec.sao.iso.MainframeValue#getLength()
     * @return int
     */
    public int getLength() {
        return getIntegerLength() + getDecimalLength();
    }

    /**
     * M�todo getDecimalLength. Retorna o n�mero de casas decimais do tipo de
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
     * M�todo getIntegerLength. Retorna o n�mero de d�gitos da parte inteira de
     * um tipo de dado Decimal.
     * 
     * @return int
     */
    protected int getIntegerLength() {
        return getBasicLength();
    }

    /**
     * M�todo putComma. Insere o caractere separador decimal (.) num n�mero
     * decimal.
     * 
     * @param number
     * @return String - N�mero decimal
     */
    protected String putComma(String number) {
        StringBuffer result = new StringBuffer(number.length() + 1);
        result.append(number.substring(0, number.length() - getDecimalLength()));
        result.append(".");
        result.append(number.substring(number.length() - getDecimalLength()));
        return result.toString();
    }
}