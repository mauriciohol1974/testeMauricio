package br.com.politec.sao.business;

import java.io.Serializable;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa um resultado de transa��o realizada na framework. Esta
 * classe inicia a estrutura de classes de resultado mantidas pela framework,
 * capazes de realizar o parsing, atrav�s de parsers, das estruturas de dados em
 * objetos.
 * 
 * @see br.com.politec.sao.iso.ISOResult
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class Result implements Serializable {
    /**
     * Inst�ncia do parser utilizado no processo de convers�o dos dados em
     * objetos.
     */
    private final Parser parser;

    /**
     * Construtor default para o objeto de resultado.
     * 
     * @param prototype
     *            Objeto que ser� obtido ap�s o parsing dos dados.
     * @param fields
     *            Campos contidos na resposta para parsing.
     */
    public Result(BusinessObject prototype,
            String[] fields) {
        this.parser = getParser(prototype, fields);
    }

    /**
     * M�todo getParser. Retorna o parser correspondente a convers�o mantida na
     * estrutura de resposta do objeto.
     * 
     * @return Instancia do parser.
     */
    public Parser getParser() {
        return this.parser;
    }

    /**
     * M�todo getPrototype. Retorna a inst�ncia do objeto mantido pelo objeto de
     * resposta para parsing.
     * 
     * @return Instancia do objeto a ser parseado.
     */
    public BusinessObject getPrototype() {
        return getParser().getPrototype();
    }

    /**
     * M�todo getParser. M�todo abstrato, que ir� definir os tipos de dados que
     * ser�o tratados pelos objetos de resposta concretos que herdar�o as
     * caracter�sticas desta classe.
     * 
     * @param prototype
     *            Objeto a ser parseado dos dados de resposta.
     * @param fields
     *            Campos contidos na resposta.
     * @return Instancia do parser adequado para convers�o.
     */
    protected abstract Parser getParser(BusinessObject prototype,
            String[] fields);
}