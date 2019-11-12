package br.com.politec.sao.business.types;

import java.io.IOException;

import br.com.politec.sao.business.Type;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Time;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Representa um atributo de tempo, tratado pela framework. É capaz de armazenar
 * um número que representa uma quantidade de horas e minutos, limitado ao
 * máximo de 24horas.
 * 
 * @author Marcelo Luchesi - mluchesi@sao.politec.com.br
 * @version release 1.3
 */
public class TimeType extends Type {
    /**
     * Instância do tipo, mantida para melhorar a performance na criação de
     * objetos deste tipo.
     */
    private static final TimeType instance = new TimeType();

    /**
     * Construtor default do objeto.
     */
    private TimeType() {
    }

    /**
     * Método create. Retorna a instância pré-instanciada do objeto.
     * 
     * @return Nova instancia do tipo.
     */
    public static TimeType create() {
        return instance;
    }

    /**
     * Método isValid.
     * 
     * @see br.com.politec.sao.business.Type#isValid(java.lang.Object) Verifica
     *      se o objeto passado como parâmetro é válido para o tipo Time.
     * @param value
     *            Objeto para verificação.
     * @return Resultado da verificação.
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
     * Método newInstance.
     * 
     * @see br.com.politec.sao.business.Type#newInstance(java.lang.Object)
     *      Instancia um objeto do tipo, a partir do objeto passado como
     *      parâmetro.
     * @param value
     *            Objeto para criação da instância de Time.
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
     * Método getTypeRealName.
     * 
     * @see br.com.politec.sao.business.Type#getTypeRealName() String com o nome
     *      completo da classe Java.
     * @return <code>"br.com.politec.sao.util.Time"</code>
     */
    public String getTypeRealName() {
        return "br.com.politec.sao.util.Time";
    }

    /**
     * Método getName.
     * 
     * @see br.com.politec.sao.business.Type#getName() String com o nome do
     *      tipo.
     * @return <code>"Time"</code>
     */
    public String getName() {
        return "Time";
    }

    /**
     * Método formatOn.
     * 
     * @see br.com.politec.sao.business.Type#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     *            Buffer que receberá a literal do tipo.
     * @param value
     *            Objeto para crição de um tipo Time.
     * @throws IOException
     *             Caso ocorra algum erro tratável durante a operação de
     *             concatenação.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(value != null);
        final Time time = (Time) newInstance(value);
        time.appendTo(out);
    }
}