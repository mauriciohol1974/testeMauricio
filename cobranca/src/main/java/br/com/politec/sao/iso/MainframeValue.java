package br.com.politec.sao.iso;

import java.io.IOException;

import org.apache.regexp.RE;

import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa o inicio da hierarquia de tipos suportados baseados em
 * pacotes ISO8583 pela framework. Fornece a implementação mínima para que se
 * possa realizar o parsing de objetos a partir de Strings em formato ISO8583,
 * ambiente CICS. E também fornece o suporte a composição de Strings com a
 * padronização necessária para transmissão via SIROT CAIXA.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class MainframeValue {
    /**
     * String para tratamento e composição de objeto de tipo correspondente.
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
     * Método isValidFormat. Verifica se o formato de String passado como
     * parâmetro é válido. Utiliza expressões regulares para cada tipo.
     * 
     * @param format
     *            String para parsing.
     * @return Resultado da verificação.
     */
    public boolean isValidFormat(String format) {
        return (format != null) && getValidFormat().match(format);
    }

    /**
     * Método getFormat. Retorna a String que esta sendo tratada.
     * 
     * @return String que esta sendo tratada.
     */
    public String getFormat() {
        return this.format;
    }

    /**
     * Método getValidFormat. Deve ser implementada pelos tipos físicos. Retorna
     * a expressão regular correspondente a máscara de dados aceita para o tipo
     * específico.
     * 
     * @return Expressão regular correspondente a máscara de dados aceita para o
     *         tipo específico.
     */
    public abstract RE getValidFormat();

    /**
     * Método formatOn. Acrescenta ao stremming passado como parâmetro a String
     * no formato ISO8583 relativa ao objeto também passado como parâmetro. Deve
     * ser implementado por cada tipo específico.
     * 
     * @param out
     *            Buffer de dados para acumulação dos dados formatados.
     * @param value
     *            Objeto que armazena as informações para formatação.
     * @throws IOException
     *             Caso ocorra algum erro tratável durante a composição do
     *             stremming.
     */
    public abstract void formatOn(Appender out, Object value)
            throws IOException;

    /**
     * Método getLength. Retorna o tamanho máximo da máscara de dados aceita
     * pelo tipo. Deve ser implementado por cada tipo específico.
     * 
     * @return O tamanho máximo da máscara de dados aceita pelo tipo.
     */
    public abstract int getLength();

    /**
     * Método convert. Converte a String passada como parâmetro no tipo
     * correspondente. Deve ser implementado por cada tipo específico,
     * respeitando as regras de parsing para cada objeto.
     * 
     * @param value
     *            String que contém os dados para composição do novo objeto.
     * @return Instancia do novo objeto, criado a partir da String.
     */
    public abstract Object convert(String value);

    /**
     * Método getBasicLength. Retorna o tamanho declarado para o tipo na
     * definição dos beans.
     * 
     * @return o tamanho declarado para o tipo na definição dos beans.
     * @throws NumberFormatException
     *             Caso a declaração esteja incorreta.
     */
    protected int getBasicLength() throws NumberFormatException {
        final int before = getFormat().indexOf('(') + 1;
        final int after = getFormat().indexOf(')');
        return Integer.parseInt(getFormat().substring(before, after));
    }
}