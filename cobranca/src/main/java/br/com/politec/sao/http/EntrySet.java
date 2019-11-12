package br.com.politec.sao.http;

import java.io.IOException;
import java.util.Iterator;

import br.com.politec.sao.util.Appender;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Compoõe stremmings de log baseados em composição de outros stremmings.
 * Normalmente utilzada em ambiente de desenvolvimento.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class EntrySet {
    /**
     * Construtor default do objeto.
     */
    public EntrySet() {
    }

    /**
     * Método title. Retorna o titulo default para o objeto.
     * 
     * @return String que irá representar o nome do objeto os dados por ele
     *         tratados.
     */
    public abstract String title();

    /**
     * Método names. Lista contendo os nomes dos objetos a serem adicionados ao
     * stremming.
     * 
     * @return Lista de nomes dos objetos.
     */
    public abstract Iterator names();

    /**
     * Método value. Valor atribuido ao objeto identificado pelo nome passado
     * como parâmetro.
     * 
     * @param name
     *            Nome do objeto para obtenção de seu valor.
     * @return Valor do objeto convertido em tipo String.
     */
    public abstract String value(String name);

    /**
     * Método printOn. Compõe o stremming principal do log, com informação de
     * título. Em seguida cada item é adicionado através do método
     * 
     * @see #printEntryOn(Appender, String).
     * @param out
     *            Stremming, cache, para acumulação das informações de log.
     * @throws IOException
     *             Caso ocorra algum erro durante a composição do stremming.
     */
    public void printOn(Appender out) throws IOException {
        final Iterator names = names();
        if (names.hasNext()) {
            out.append(title());
            out.append(": {");
            out.newLine();
            while (names.hasNext()) {
                printEntryOn(out, (String) names.next());
            }
            out.append("}");
            out.newLine();
        }
    }

    /**
     * Método printEntryOn. Compõe as informações individuais de cada objeto
     * constante da lista. Concatena o nome do objeto com seu valor, e o
     * adiciona ao stremming para log.
     * 
     * @param out
     *            Stremming de log.
     * @param name
     *            Nome do objeto.
     * @throws IOException
     *             Caso ocorra algum erro durante a composição do stremming.
     */
    private void printEntryOn(Appender out, String name) throws IOException {
        out.tab();
        out.append(name);
        out.append(" => ");
        out.append(value(name));
        out.append(";");
        out.newLine();
    }
}