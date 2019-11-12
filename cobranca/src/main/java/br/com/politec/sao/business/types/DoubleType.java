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
     * Método create. Retorna uma nova instancia do tipo.
     * 
     * @return Nova instancia do tipo.
     */
    public static DoubleType create() {
        return instance;
    }

    /**
     * Método getName.
     * 
     * @see br.com.politec.sao.business.Type#getName() Retorna o nome do tipo em
     *      forma de String.
     * @return <code>"Double"</code>
     */
    public String getName() {
        return "Double";
    }

    /**
     * Método isValid.
     * 
     * @see br.com.politec.sao.business.Type#isValid(java.lang.Object) Verifica
     *      se o objeto passado como parâmetro é um tipo válido para Double.
     * @param value
     *            Objeto para verificação.
     * @return Resultado da verificação.
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
     * Método newInstance.
     * 
     * @see br.com.politec.sao.business.Type#newInstance(java.lang.Object)
     *      Retorna uma nova instancia de Double a partir do objeto passado como
     *      parâmetro.
     * @param value
     *            Objeto para criação do tipo Double.
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
     * Método modulus. Representação em um número decimal do valor de um tipo
     * Double em qualquer base de cálculo.
     * 
     * @param value
     *            Valor Double.
     * @param base
     *            Base em que o valor esta sendo representado.
     * @param decimalMagnitude
     *            Número de casas decimais omitidas.
     * @return Número calculado.
     */
    public Double modulus(Double value, long base, long decimalMagnitude) {
        final long result = (long) ((value.doubleValue() % base) * decimalMagnitude);
        return new Double((double) result / (double) decimalMagnitude);
    }

    /**
     * Método parse. Substitui os caracteres ',' por '.'
     * 
     * @param value
     *            Valor para substituição.
     * @return String reformatada.
     */
    private Double parse(String value) {
        return Double.valueOf(value.replace(',', '.'));
    }

    /**
     * Método getTypeRealName.
     * 
     * @see br.com.politec.sao.business.Type#getTypeRealName() Retorna o nome
     *      real java, do tipo.
     * @return <code>"java.lang.Double"</code>
     */
    public String getTypeRealName() {
        return "java.lang.Double";
    }

    /**
     * Método formatOn.
     * 
     * @see br.com.politec.sao.business.Type#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     *            Buffer que receberá a literal do tipo.
     * @param value
     *            Objeto para crição de um tipo Double.
     * @throws IOException
     *             Caso ocorra algum erro tratável durante a operação de
     *             concatenação.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(value != null);
        Assertions.requires(isValid(value));
        final Double aValue = (Double) newInstance(value);
        appendFormatted(out, aValue.toString());
    }

    /**
     * Método appendFormatted. Idem
     * 
     * @see #formatOn(Appender, Object), porém com a substituição de carácteres
     *      de
     * @see #parse(String)
     * @param out
     *            Buffer que receberá a literal do tipo.
     * @param value
     *            Objeto para crição de um tipo Long.
     * @throws IOException
     *             Caso ocorra algum erro tratável durante a operação de
     *             concatenação.
     */
    private void appendFormatted(Appender out, String value) throws IOException {
        out.append(value.replace('.', ','));
    }
}