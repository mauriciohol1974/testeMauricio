package br.com.politec.sao.business.types;

import java.io.IOException;

import br.com.politec.sao.business.Type;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Time;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Representa um atributo de tempo, tratado pela framework. � capaz de armazenar
 * um n�mero que representa uma quantidade de horas e minutos, limitado ao
 * m�ximo de 24horas.
 * 
 * @author Marcelo Luchesi - mluchesi@sao.politec.com.br
 * @version release 1.3
 */
public class TimeType extends Type {
    /**
     * Inst�ncia do tipo, mantida para melhorar a performance na cria��o de
     * objetos deste tipo.
     */
    private static final TimeType instance = new TimeType();

    /**
     * Construtor default do objeto.
     */
    private TimeType() {
    }

    /**
     * M�todo create. Retorna a inst�ncia pr�-instanciada do objeto.
     * 
     * @return Nova instancia do tipo.
     */
    public static TimeType create() {
        return instance;
    }

    /**
     * M�todo isValid.
     * 
     * @see br.com.politec.sao.business.Type#isValid(java.lang.Object) Verifica
     *      se o objeto passado como par�metro � v�lido para o tipo Time.
     * @param value
     *            Objeto para verifica��o.
     * @return Resultado da verifica��o.
     */
    public boolean isValid(Object value) {
        boolean result = false;
        if (value == null) {
            result = false;
        } else if (value instanceof Time) {
            result = true;
        } else if (value instanceof String) {
            result = Time.isValid((String) value);
        } else if (value instanceof Number) {
            result = Time.isValid(((Number) value).intValue());
        } else {
            result = false;
        }
        return result;
    }

    /**
     * M�todo newInstance.
     * 
     * @see br.com.politec.sao.business.Type#newInstance(java.lang.Object)
     *      Instancia um objeto do tipo, a partir do objeto passado como
     *      par�metro.
     * @param value
     *            Objeto para cria��o da inst�ncia de Time.
     * @return Instancia do objeto tipo Time criado.
     */
    public Object newInstance(Object value) {
        Assertions.requires(isValid(value), "Invalid value [" + value + "]!");
        Time result = null;
        if (value instanceof Time) {
            result = (Time) value;
        } else if (value instanceof String) {
            result = new Time((String) value);
        } else if (value instanceof Number) {
            result = new Time(((Number) value).intValue());
        } else {
            result = null;
        }
        return result;
    }

    /**
     * M�todo getTypeRealName.
     * 
     * @see br.com.politec.sao.business.Type#getTypeRealName() String com o nome
     *      completo da classe Java.
     * @return <code>"br.com.politec.sao.util.Time"</code>
     */
    public String getTypeRealName() {
        return "br.com.politec.sao.util.Time";
    }

    /**
     * M�todo getName.
     * 
     * @see br.com.politec.sao.business.Type#getName() String com o nome do
     *      tipo.
     * @return <code>"Time"</code>
     */
    public String getName() {
        return "Time";
    }

    /**
     * M�todo formatOn.
     * 
     * @see br.com.politec.sao.business.Type#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     *            Buffer que receber� a literal do tipo.
     * @param value
     *            Objeto para cri��o de um tipo Time.
     * @throws IOException
     *             Caso ocorra algum erro trat�vel durante a opera��o de
     *             concatena��o.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(value != null);
        final Time time = (Time) newInstance(value);
        time.appendTo(out);
    }
}