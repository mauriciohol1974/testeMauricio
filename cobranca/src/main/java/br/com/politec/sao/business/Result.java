package br.com.politec.sao.business;

import java.io.Serializable;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa um resultado de transação realizada na framework. Esta
 * classe inicia a estrutura de classes de resultado mantidas pela framework,
 * capazes de realizar o parsing, através de parsers, das estruturas de dados em
 * objetos.
 * 
 * @see br.com.politec.sao.iso.ISOResult
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class Result implements Serializable {
    /**
     * Instância do parser utilizado no processo de conversão dos dados em
     * objetos.
     */
    private final Parser parser;

    /**
     * Construtor default para o objeto de resultado.
     * 
     * @param prototype
     *            Objeto que será obtido após o parsing dos dados.
     * @param fields
     *            Campos contidos na resposta para parsing.
     */
    public Result(BusinessObject prototype,
            String[] fields) {
        this.parser = getParser(prototype, fields);
    }

    /**
     * Método getParser. Retorna o parser correspondente a conversão mantida na
     * estrutura de resposta do objeto.
     * 
     * @return Instancia do parser.
     */
    public Parser getParser() {
        return this.parser;
    }

    /**
     * Método getPrototype. Retorna a instância do objeto mantido pelo objeto de
     * resposta para parsing.
     * 
     * @return Instancia do objeto a ser parseado.
     */
    public BusinessObject getPrototype() {
        return getParser().getPrototype();
    }

    /**
     * Método getParser. Método abstrato, que irá definir os tipos de dados que
     * serão tratados pelos objetos de resposta concretos que herdarão as
     * características desta classe.
     * 
     * @param prototype
     *            Objeto a ser parseado dos dados de resposta.
     * @param fields
     *            Campos contidos na resposta.
     * @return Instancia do parser adequado para conversão.
     */
    protected abstract Parser getParser(BusinessObject prototype,
            String[] fields);
}