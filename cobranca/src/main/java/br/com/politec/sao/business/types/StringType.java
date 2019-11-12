package br.com.politec.sao.business.types;

import java.io.IOException;

import br.com.politec.sao.business.Type;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Tipo que representa uma String para a estrutura mantida pela framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class StringType extends Type {
    /**
     * Instancia mantida para performance em instanciações do mesmo tipo.
     */
    private static final StringType instance = new StringType();

    /**
     * Construtor default do objeto.
     */
    private StringType() {
    }

    /**
     * Método create. Método de criação de uma nova instancia do tipo String.
     * 
     * @return Nova instancia do tipo.
     */
    public static StringType create() {
        return instance;
    }

    /**
     * Método getName.
     * 
     * @see br.com.politec.sao.business.Type#getName() Retorna o nome do tipo.
     * @return <code>"String"</code>
     */
    public String getName() {
        return "String";
    }

    /**
     * Método isValid.
     * 
     * @see br.com.politec.sao.business.Type#isValid(java.lang.Object) Verifica
     *      se o tipo passado como parâmetro é um tipo válido para String.
     * @param value
     *            Objeto para verificação.
     * @return Resultado da verificação.
     */
    public boolean isValid(Object value) {
        return (value instanceof String)
               || (value instanceof StringBuffer)
               || (value instanceof char[]);
    }

    /**
     * Método newInstance.
     * 
     * @see br.com.politec.sao.business.Type#newInstance(java.lang.Object)
     *      Criação de uma nova instancia de String a partir do objeto passado
     *      como parâmetro.
     * @param value
     *            Objeto para criação da nova instancia do tipo.
     * @return Nova instancia de String.
     */
    public Object newInstance(Object value) {
        Assertions.requires(isValid(value));
        // GMG: transformar todo tipo de dado String em maiuscula
        // return String.valueOf(value);
        return (String.valueOf(value)).toUpperCase();
    }

    /**
     * Método getTypeRealName.
     * 
     * @see br.com.politec.sao.business.Type#getTypeRealName() String com o path
     *      java real do tipo tratado.
     * @return <code>"java.lang.String"</code>
     */
    public String getTypeRealName() {
        return "java.lang.String";
    }

    /**
     * Método formatOn.
     * 
     * @see br.com.politec.sao.business.Type#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     *            Buffer que receberá a literal do tipo.
     * @param value
     *            Objeto para crição de um tipo String.
     * @throws IOException
     *             Caso ocorra algum erro tratável durante a operação de
     *             concatenação.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(isValid(value));
        final String text = (String) newInstance(value);
        out.append(text);
    }
}