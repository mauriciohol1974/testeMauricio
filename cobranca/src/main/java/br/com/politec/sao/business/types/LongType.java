package br.com.politec.sao.business.types;

import java.io.IOException;

import br.com.politec.sao.business.Type;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Utils;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa o tipo Long para framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class LongType extends Type {
    /**
     * Instancia do tipo para maior performance na obtencao de novas instancias
     * do tipo.
     */
    private static final LongType instance = new LongType();

    /**
     * Constrututor default do objeto.
     */
    private LongType() {
    }

    /**
     * M�todo create. Retorna uma nova instancia do tipo.
     * 
     * @return Nova instancia do tipo.
     */
    public static LongType create() {
        return instance;
    }

    /**
     * M�todo getName.
     * 
     * @see br.com.politec.sao.business.Type#getName() Retorna o nome do tipo em
     *      forma de String.
     * @return <code>"Long"</code>
     */
    public String getName() {
        return "Long";
    }

    /**
     * M�todo isValid.
     * 
     * @see br.com.politec.sao.business.Type#isValid(java.lang.Object) Verifica
     *      se o objeto passado como par�metro � um tipo v�lido para Long.
     * @param value
     *            Objeto para verifica��o.
     * @return Resultado da verifica��o.
     */
    public boolean isValid(Object value) {
        return ((value instanceof String) && Utils.hasOnlyDigits((String) value))
               || (value instanceof Long)
               || (value instanceof Number);
    }

    /**
     * M�todo newInstance.
     * 
     * @see br.com.politec.sao.business.Type#newInstance(java.lang.Object)
     *      Retorna uma nova instancia de Long a partir do objeto passado como
     *      par�metro.
     * @param value
     *            Objeto para cria��o do tipo Long.
     * @return Instancia do tipo baseada nos valores do objeto passado como
     *         parametro.
     */
    public Object newInstance(Object value) {
        Assertions.requires(isValid(value));
        Long result = null;
        if (value instanceof Long) {
            result = (Long) value;
        } else if (value instanceof String) {
            result = Long.valueOf((String) value);
        } else if (value instanceof Number) {
            result = new Long(((Number) value).longValue());
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
     * @return <code>"java.lang.Long"</code>
     */
    public String getTypeRealName() {
        return "java.lang.Long";
    }

    /**
     * M�todo formatOn.
     * 
     * @see br.com.politec.sao.business.Type#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     *            Buffer que receber� a literal do tipo.
     * @param value
     *            Objeto para cri��o de um tipo Long.
     * @throws IOException
     *             Caso ocorra algum erro trat�vel durante a opera��o de
     *             concatena��o.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(isValid(value));
        final Long integer = (Long) newInstance(value);
        out.append(integer.longValue());
    }
}