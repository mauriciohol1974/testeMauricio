package br.com.politec.sao.business.types;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.politec.sao.business.Type;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa um tipo Date para framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class DateType extends Type {
    /**
     * Instancia do tipo para maior performance na obtencao de novas instancias
     * do tipo.
     */
    private static final DateType instance = new DateType();

    /**
     * Constrututor default do objeto.
     */
    private DateType() {
    }

    /**
     * M�todo create. Retorna uma nova instancia do tipo.
     * 
     * @return Nova instancia do tipo.
     */
    public static DateType create() {
        return instance;
    }

    /**
     * M�todo getName.
     * 
     * @see br.com.politec.sao.business.Type#getName() Retorna o nome do tipo em
     *      forma de String.
     * @return <code>"Date"</code>
     */
    public String getName() {
        return "Date";
    }

    /**
     * M�todo isValid.
     * 
     * @see br.com.politec.sao.business.Type#isValid(java.lang.Object) Verifica
     *      se o objeto passado como par�metro � um tipo v�lido para Date.
     * @param value
     *            Objeto para verifica��o.
     * @return Resultado da verifica��o.
     */
    public boolean isValid(Object value) {
        boolean result = false;
        if (value instanceof Date) {
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
     *      Retorna uma nova instancia de Date a partir do objeto passado como
     *      par�metro.
     * @param value
     *            Objeto para cria��o do tipo Date.
     * @return Instancia do tipo baseada nos valores do objeto passado como
     *         parametro.
     */
    public Object newInstance(Object value) {
        Assertions.requires(isValid(value));
        Date result = null;
        if (value instanceof Date) {
            result = (Date) value;
        } else if (value instanceof String) {
            if (!((String) value).trim().equals("")) {
                result = parse((String) value);
            } else {
                result = null;
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * M�todo parse. Retorna um tipo Date primitivo a partir da String passada
     * como par�metro.
     * 
     * @param value
     *            String que representa uma data.
     * @return Objeto Date criado a partir da String.
     */
    private Date parse(String value) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            // bug do horario de verao
            // a hora default eh 00:00, mas se for no dia da mudanca para
            // horario de verao, a hora atrasa 1 hora e o dia volta para o
            // anterior, por isso setando a hora para meio dia
            return sdf.parse(value + " 12:00");
        } catch (ParseException exc) {
            throw new WrappingException(exc);
        }
    }

    /**
     * M�todo getDateFormat. Retorna um
     * 
     * @see SimpleDateFormat padr�o para ser utilizado nos objetos do Date.
     * @return Formato de datas v�lido para o tipo, <code>"dd/MM/yyyy"</code>
     */
    private SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat("dd/MM/yyyy");
    }

    /**
     * M�todo getTypeRealName.
     * 
     * @see br.com.politec.sao.business.Type#getTypeRealName() Retorna o nome
     *      real java, do tipo.
     * @return <code>"java.util.Date"</code>
     */
    public String getTypeRealName() {
        return "java.util.Date";
    }

    /**
     * M�todo formatOn.
     * 
     * @see br.com.politec.sao.business.Type#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     *            Buffer que receber� a literal do tipo.
     * @param value
     *            Objeto para cri��o de um tipo Date.
     * @throws IOException
     *             Caso ocorra algum erro trat�vel durante a opera��o de
     *             concatena��o.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(value != null);
        Assertions.requires(isValid(value));
        final Date date = (Date) newInstance(value);
        out.append(getDateFormat().format(date));
    }
}