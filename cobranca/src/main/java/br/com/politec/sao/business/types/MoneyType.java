package br.com.politec.sao.business.types;

import java.io.IOException;

import br.com.politec.sao.business.Type;
import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa um tipo monet�rio para a framework. Esta classe esta
 * customizada para o padr�o monet�rio brasileiro atual, sendo R$ o s�mbolo e
 * "," o separador de centavos.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class MoneyType extends Type {
    /**
     * Instancia do tipo para maior performance na obtencao de novas instancias
     * do tipo.
     */
    private static final MoneyType instance = new MoneyType();

    /**
     * Constrututor default do objeto.
     */
    private MoneyType() {
    }

    /**
     * M�todo create. Retorna uma nova instancia do tipo.
     * 
     * @return Nova instancia do tipo.
     */
    public static MoneyType create() {
        return instance;
    }

    /**
     * M�todo getName.
     * 
     * @see br.com.politec.sao.business.Type#getName() Retorna o nome do tipo em
     *      forma de String.
     * @return <code>"Money"</code>
     */
    public String getName() {
        return "Money";
    }

    /**
     * M�todo isValid.
     * 
     * @see br.com.politec.sao.business.Type#isValid(java.lang.Object) Verifica
     *      se o objeto passado como par�metro � um tipo v�lido para Money.
     * @param value
     *            Objeto para verifica��o.
     * @return Resultado da verifica��o.
     */
    public boolean isValid(Object value) {
        boolean result = false;
        if (value instanceof Money) {
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
     *      Retorna uma nova instancia de Money a partir do objeto passado como
     *      par�metro.
     * @param value
     *            Objeto para cria��o do tipo Money.
     * @return Instancia do tipo baseada nos valores do objeto passado como
     *         parametro.
     */
    public Object newInstance(Object value) {
        Assertions.requires(isValid(value));
        Money result = null;
        if (value instanceof Money) {
            result = (Money) value;
        } else if (value instanceof String) {
            result = parse((String) value);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * M�todo parse. Converte uma String em qualquer formato de moeda corrente,
     * num tipo Money.
     * 
     * @param value
     *            String em formato de moeda estrangeira, exemplo "US$ 1.00"
     * @return Instancia de Money criada a partir da String.
     */
    private Money parse(String value) {
        final Currency symbol = Currency.get("R$");
        String number = value.substring(value.indexOf("$") + 2);
        number = clean(number);
        return new Money(number.replace(',', '.'), symbol);
    }

    /**
     * M�todo clean. Remove da String passada como par�metro os separadores de
     * milhar '.'
     * 
     * @param number
     *            String para tratamento.
     * @return String sem os separadores de milhar.
     */
    private String clean(String number) {
        String result = "";
        for (int i = 0; i < number.length(); i++)
            if (number.charAt(i) != '.')
                result = result + number.charAt(i);

        return result;
    }

    /**
     * M�todo getTypeRealName.
     * 
     * @see br.com.politec.sao.business.Type#getTypeRealName() Retorna o nome
     *      real java, do tipo.
     * @return <code>"br.com.politec.sao.util.Money"</code>
     */
    public String getTypeRealName() {
        return "br.com.politec.sao.util.Money";
    }

    /**
     * M�todo formatOn.
     * 
     * @see br.com.politec.sao.business.Type#formatOn(br.com.politec.sao.util.Appender,
     *      java.lang.Object)
     * @param out
     *            Buffer que receber� a literal do tipo.
     * @param value
     *            Objeto para cri��o de um tipo Money.
     * @throws IOException
     *             Caso ocorra algum erro trat�vel durante a opera��o de
     *             concatena��o.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(value != null);
        final Money money = (Money) newInstance(value);
        out.append(money.toString());
    }
}