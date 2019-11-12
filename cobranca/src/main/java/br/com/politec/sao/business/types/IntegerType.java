package br.com.politec.sao.business.types;

import java.io.IOException;

import br.com.politec.sao.business.Type;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Utils;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa um tipo Integer para framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class IntegerType extends Type {
    /**
     * Instancia do tipo para maior performance na obtencao de novas instancias
     * do tipo.
     */
    private static final IntegerType instance = new IntegerType();

    /**
     * Constrututor default do objeto.
     */
    private IntegerType() {
    }

    /**
     * M�todo create. Retorna uma nova instancia do tipo.
     * 
     * @return Nova instancia do tipo.
     */
    public static IntegerType create() {
        return instance;
    }

    /**
     * M�todo getName.
     * 
     * @see br.com.politec.sao.business.Type#getName() Retorna o nome do tipo em
     *      forma de String.
     * @return <code>"Integer"</code>
     */
    public String getName() {
        return "Integer";
    }

    /**
     * M�todo isValid.
     * 
     * @see br.com.politec.sao.business.Type#isValid(java.lang.Object) Verifica
     *      se o objeto passado como par�metro � um tipo v�lido para Integer.
     * @param value
     *            Objeto para verifica��o.
     * @return Resultado da verifica��o.
     */
    public boolean isValid(Object value) {
        return ((value instanceof String) && Utils.hasOnlyDigits((String) value))
               || (value instanceof Integer)
               || (value instanceof Number);
    }

    /**
     * M�todo newInstance.
     * 
     * @see br.com.politec.sao.business.Type#newInstance(java.lang.Object)
     *      Retorna uma nova instancia de Integer a partir do objeto passado
     *      como par�metro.
     * @param value
     *            Objeto para cria��o do tipo Integer.
     * @return Instancia do tipo baseada nos valores do objeto passado como
     *         parametro.
     */
    public Object newInstance(Object value) {
        Assertions.requires(isValid(value));
        Integer result = null;
        if (value instanceof Integer) {
            result = (Integer) value;
        } else if (value instanceof String) {
            result = Integer.valueOf((String) value);
        } else if (value instanceof Number) {
            result = new Integer(((Number) value).intValue());
        } else {
            result = null;
        }
        return result;
    }

    /**
     * M�todo getTypeRealName.
     * 
     * @see br.com.politec.sao.business.Type#getTypeRealName() Retorna o nome
     *      real java, do tipo.
     * @return <code>"java.lang.Integer"</code>
     */
    public String getTypeRealName() {
        return "java.lang.Integer";
    }

    /**
     * M�todo formatOn.
     * 
     * @see br.com.politec.sao.business.Type#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     *            Buffer que receber� a literal do tipo.
     * @param value
     *            Objeto para cri��o de um tipo Integer.
     * @throws IOException
     *             Caso ocorra algum erro trat�vel durante a opera��o de
     *             concatena��o.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(isValid(value));
        final Integer integer = (Integer) newInstance(value);
        out.append(integer.intValue());
    }
}