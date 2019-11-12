package br.com.politec.sao.business.types;

import java.io.IOException;

import br.com.politec.sao.business.Type;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa um tipo Double para framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class DoubleType extends Type {
    /**
     * Instancia do tipo para maior performance na obtencao de novas instancias
     * do tipo.
     */
    private static final DoubleType instance = new DoubleType();

    /**
     * Constrututor default do objeto.
     */
    private DoubleType() {
    }

    /**
     * M�todo create. Retorna uma nova instancia do tipo.
     * 
     * @return Nova instancia do tipo.
     */
    public static DoubleType create() {
        return instance;
    }

    /**
     * M�todo getName.
     * 
     * @see br.com.politec.sao.business.Type#getName() Retorna o nome do tipo em
     *      forma de String.
     * @return <code>"Double"</code>
     */
    public String getName() {
        return "Double";
    }

    /**
     * M�todo isValid.
     * 
     * @see br.com.politec.sao.business.Type#isValid(java.lang.Object) Verifica
     *      se o objeto passado como par�metro � um tipo v�lido para Double.
     * @param value
     *            Objeto para verifica��o.
     * @return Resultado da verifica��o.
     */
    public boolean isValid(Object value) {
        boolean result = false;
        if (value instanceof Number) {
            result = true;
        } else if (value instanceof String) {
            try {
                parse((String) value);
                result = true;
            } catch (Exception exc) {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }

    /**
     * M�todo newInstance.
     * 
     * @see br.com.politec.sao.business.Type#newInstance(java.lang.Object)
     *      Retorna uma nova instancia de Double a partir do objeto passado como
     *      par�metro.
     * @param value
     *            Objeto para cria��o do tipo Double.
     * @return Instancia do tipo baseada nos valores do objeto passado como
     *         parametro.
     */
    public Object newInstance(Object value) {
        Assertions.requires(isValid(value));
        Double result = null;
        if (value instanceof Double) {
            result = (Double) value;
        } else if (value instanceof Number) {
            result = new Double(((Number) value).doubleValue());
        } else if (value instanceof String) {
            result = parse((String) value);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * M�todo modulus. Representa��o em um n�mero decimal do valor de um tipo
     * Double em qualquer base de c�lculo.
     * 
     * @param value
     *            Valor Double.
     * @param base
     *            Base em que o valor esta sendo representado.
     * @param decimalMagnitude
     *            N�mero de casas decimais omitidas.
     * @return N�mero calculado.
     */
    public Double modulus(Double value, long base, long decimalMagnitude) {
        final long result = (long) ((value.doubleValue() % base) * decimalMagnitude);
        return new Double((double) result / (double) decimalMagnitude);
    }

    /**
     * M�todo parse. Substitui os caracteres ',' por '.'
     * 
     * @param value
     *            Valor para substitui��o.
     * @return String reformatada.
     */
    private Double parse(String value) {
        return Double.valueOf(value.replace(',', '.'));
    }

    /**
     * M�todo getTypeRealName.
     * 
     * @see br.com.politec.sao.business.Type#getTypeRealName() Retorna o nome
     *      real java, do tipo.
     * @return <code>"java.lang.Double"</code>
     */
    public String getTypeRealName() {
        return "java.lang.Double";
    }

    /**
     * M�todo formatOn.
     * 
     * @see br.com.politec.sao.business.Type#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     *            Buffer que receber� a literal do tipo.
     * @param value
     *            Objeto para cri��o de um tipo Double.
     * @throws IOException
     *             Caso ocorra algum erro trat�vel durante a opera��o de
     *             concatena��o.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(value != null);
        Assertions.requires(isValid(value));
        final Double aValue = (Double) newInstance(value);
        appendFormatted(out, aValue.toString());
    }

    /**
     * M�todo appendFormatted. Idem
     * 
     * @see #formatOn(Appender, Object), por�m com a substitui��o de car�cteres
     *      de
     * @see #parse(String)
     * @param out
     *            Buffer que receber� a literal do tipo.
     * @param value
     *            Objeto para cri��o de um tipo Long.
     * @throws IOException
     *             Caso ocorra algum erro trat�vel durante a opera��o de
     *             concatena��o.
     */
    private void appendFormatted(Appender out, String value) throws IOException {
        out.append(value.replace('.', ','));
    }
}