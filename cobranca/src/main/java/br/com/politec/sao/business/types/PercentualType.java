package br.com.politec.sao.business.types;

import java.io.IOException;

import br.com.politec.sao.business.Type;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Percentual;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe que representa um tipo percentual no formato do tipo "1,00 %"
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class PercentualType extends Type {

    /**
     * Instancia do tipo para maior performance na obtencao de novas instancias
     * do tipo.
     */
    private static final PercentualType instance = new PercentualType();

    /**
     * Método create. Retorna uma nova instancia do tipo.
     * 
     * @return Nova instancia do tipo.
     */
    public static PercentualType create() {
        return instance;
    }

    /**
     * Método isValid.
     * 
     * @see br.com.politec.sao.business.Type#isValid(java.lang.Object) Verifica
     *      se o objeto passado como parâmetro é um tipo válido para Percentual.
     * @param value
     *            Objeto para verificação.
     * @return Resultado da verificação.
     */
    public boolean isValid(Object value) {
        boolean result = false;
        if (value instanceof Percentual) {
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
     *      Retorna uma nova instancia de Percentual a partir do objeto passado
     *      como parâmetro.
     * @param value
     *            Objeto para criação do tipo Percentual.
     * @return Instancia do tipo baseada nos valores do objeto passado como
     *         parametro.
     */
    public Object newInstance(Object value) {
        Assertions.requires(isValid(value));
        Percentual result = null;
        if (value instanceof Percentual) {
            result = (Percentual) value;
        } else if (value instanceof String) {
            result = parse((String) value);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Método getTypeRealName.
     * 
     * @see br.com.politec.sao.business.Type#getTypeRealName() Retorna o nome
     *      real java, do tipo.
     * @return <code>"br.com.politec.sao.util.Percentual"</code>
     */
    public String getTypeRealName() {
        return "br.com.politec.sao.util.Percentual";
    }

    /**
     * Método getName.
     * 
     * @see br.com.politec.sao.business.Type#getName() Retorna o nome do tipo em
     *      forma de String.
     * @return <code>"Percentual"</code>
     */
    public String getName() {
        return "Percentual";
    }

    /**
     * Método formatOn.
     * 
     * @see br.com.politec.sao.business.Type#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     *            Buffer que receberá a literal do tipo.
     * @param value
     *            Objeto para crição de um tipo Percentual.
     * @throws IOException
     *             Caso ocorra algum erro tratável durante a operação de
     *             concatenação.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(value != null);
        final Percentual percentual = (Percentual) newInstance(value);
        out.append(percentual.toString());
    }

    /**
     * Método parse. Converte uma String formatada como percentual, num tipo
     * Percentual.
     * 
     * @param value
     *            String em formato de percentual, exemplo "1,00 %"
     * @return Instancia de Money criada a partir da String.
     */
    private Percentual parse(String value) {
        if (value == null || value.trim().equals("")) {
            return new Percentual(0);
        } else {
            String number = value.substring(0, value.indexOf(" "));
            return new Percentual(number.replace(',', '.'));
        }
    }

}
