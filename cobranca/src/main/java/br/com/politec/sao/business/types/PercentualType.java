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
     * M�todo create. Retorna uma nova instancia do tipo.
     * 
     * @return Nova instancia do tipo.
     */
    public static PercentualType create() {
        return instance;
    }

    /**
     * M�todo isValid.
     * 
     * @see br.com.politec.sao.business.Type#isValid(java.lang.Object) Verifica
     *      se o objeto passado como par�metro � um tipo v�lido para Percentual.
     * @param value
     *            Objeto para verifica��o.
     * @return Resultado da verifica��o.
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
     * M�todo newInstance.
     * 
     * @see br.com.politec.sao.business.Type#newInstance(java.lang.Object)
     *      Retorna uma nova instancia de Percentual a partir do objeto passado
     *      como par�metro.
     * @param value
     *            Objeto para cria��o do tipo Percentual.
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
     * M�todo getTypeRealName.
     * 
     * @see br.com.politec.sao.business.Type#getTypeRealName() Retorna o nome
     *      real java, do tipo.
     * @return <code>"br.com.politec.sao.util.Percentual"</code>
     */
    public String getTypeRealName() {
        return "br.com.politec.sao.util.Percentual";
    }

    /**
     * M�todo getName.
     * 
     * @see br.com.politec.sao.business.Type#getName() Retorna o nome do tipo em
     *      forma de String.
     * @return <code>"Percentual"</code>
     */
    public String getName() {
        return "Percentual";
    }

    /**
     * M�todo formatOn.
     * 
     * @see br.com.politec.sao.business.Type#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     *            Buffer que receber� a literal do tipo.
     * @param value
     *            Objeto para cri��o de um tipo Percentual.
     * @throws IOException
     *             Caso ocorra algum erro trat�vel durante a opera��o de
     *             concatena��o.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(value != null);
        final Percentual percentual = (Percentual) newInstance(value);
        out.append(percentual.toString());
    }

    /**
     * M�todo parse. Converte uma String formatada como percentual, num tipo
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
