package br.com.politec.sao.iso;

import java.io.IOException;

import org.apache.regexp.RE;

import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa o inicio da hierarquia de tipos suportados baseados em
 * pacotes ISO8583 pela framework. Fornece a implementa��o m�nima para que se
 * possa realizar o parsing de objetos a partir de Strings em formato ISO8583,
 * ambiente CICS. E tamb�m fornece o suporte a composi��o de Strings com a
 * padroniza��o necess�ria para transmiss�o via SIROT CAIXA.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class MainframeValue {
    /**
     * String para tratamento e composi��o de objeto de tipo correspondente.
     */
    private final String format;

    /**
     * Construtor default do objeto.
     * 
     * @param format
     *            String para parsing em objeto.
     */
    public MainframeValue(String format) {
        Assertions.requires(isValidFormat(format), "Invalid format ["
                                                   + format
                                                   + "]!");
        this.format = format;
    }

    /**
     * M�todo isValidFormat. Verifica se o formato de String passado como
     * par�metro � v�lido. Utiliza express�es regulares para cada tipo.
     * 
     * @param format
     *            String para parsing.
     * @return Resultado da verifica��o.
     */
    public boolean isValidFormat(String format) {
        return (format != null) && getValidFormat().match(format);
    }

    /**
     * M�todo getFormat. Retorna a String que esta sendo tratada.
     * 
     * @return String que esta sendo tratada.
     */
    public String getFormat() {
        return this.format;
    }

    /**
     * M�todo getValidFormat. Deve ser implementada pelos tipos f�sicos. Retorna
     * a express�o regular correspondente a m�scara de dados aceita para o tipo
     * espec�fico.
     * 
     * @return Express�o regular correspondente a m�scara de dados aceita para o
     *         tipo espec�fico.
     */
    public abstract RE getValidFormat();

    /**
     * M�todo formatOn. Acrescenta ao stremming passado como par�metro a String
     * no formato ISO8583 relativa ao objeto tamb�m passado como par�metro. Deve
     * ser implementado por cada tipo espec�fico.
     * 
     * @param out
     *            Buffer de dados para acumula��o dos dados formatados.
     * @param value
     *            Objeto que armazena as informa��es para formata��o.
     * @throws IOException
     *             Caso ocorra algum erro trat�vel durante a composi��o do
     *             stremming.
     */
    public abstract void formatOn(Appender out, Object value)
            throws IOException;

    /**
     * M�todo getLength. Retorna o tamanho m�ximo da m�scara de dados aceita
     * pelo tipo. Deve ser implementado por cada tipo espec�fico.
     * 
     * @return O tamanho m�ximo da m�scara de dados aceita pelo tipo.
     */
    public abstract int getLength();

    /**
     * M�todo convert. Converte a String passada como par�metro no tipo
     * correspondente. Deve ser implementado por cada tipo espec�fico,
     * respeitando as regras de parsing para cada objeto.
     * 
     * @param value
     *            String que cont�m os dados para composi��o do novo objeto.
     * @return Instancia do novo objeto, criado a partir da String.
     */
    public abstract Object convert(String value);

    /**
     * M�todo getBasicLength. Retorna o tamanho declarado para o tipo na
     * defini��o dos beans.
     * 
     * @return o tamanho declarado para o tipo na defini��o dos beans.
     * @throws NumberFormatException
     *             Caso a declara��o esteja incorreta.
     */
    protected int getBasicLength() throws NumberFormatException {
        final int before = getFormat().indexOf('(') + 1;
        final int after = getFormat().indexOf(')');
        return Integer.parseInt(getFormat().substring(before, after));
    }
}