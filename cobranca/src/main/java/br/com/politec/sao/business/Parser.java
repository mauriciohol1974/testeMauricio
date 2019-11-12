package br.com.politec.sao.business;

import java.io.Serializable;

import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Utils;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que inicia a implementação da hierarquia de parsers para a Framework.
 * Um parser é o objeto que pode transformar uma estrutura de dados em outra,
 * como por exemplo, um pacote ISO8583 em um objeto. Toda a estrutura de parsers
 * de formatos suportados pela framework se iniciam nesta classe.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class Parser implements Serializable {
    /**
     * Instancia de um objeto que será tratado pelo parser de dados.
     * Implementação do padrão prototype, que garante maior velocidade na
     * execução do parser.
     */
    private final BusinessObject prototype;

    /**
     * Lista dos campos que serão considerados no parsing da estrutura de dados.
     */
    protected final String[] fields;

    /**
     * Construtor default do objeto de parser.
     * 
     * @param prototype
     *            Objeto que será gerado no processo de parsing.
     * @param fields
     *            Lista dos campos que serão "parseados" da estrtutura de dados.
     */
    public Parser(BusinessObject prototype,
            String[] fields) {
        Assertions.requires(prototype != null);
        Assertions.requires(fields != null);
        this.prototype = prototype;
        this.fields = (String[]) Utils.duplicateArray(fields);
    }

    /**
     * Método getPrototype. Retorna o objeto mantido na instância após o
     * parsing.
     * 
     * @return Objeto "parseado".
     */
    public BusinessObject getPrototype() {
        return this.prototype;
    }
}