package br.com.politec.sao.business;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Define um filtro, utilizado pela framework no sub-set que trata de iterações
 * no modelo CRUD de funções com dados. Uma aplicação trivial utilizando apenas
 * as quatro operações básicas com banco de dados e estruturas simples de dados,
 * são tratadas pela framework de modo bastante genérico. Uma solicitação de
 * select com resultado de lista, por exemplo, pode ser realizada passando como
 * objeto para pesquisa um Filter, definido por este objeto.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class Filter extends Message {
    /**
     * @see br.com.politec.sao.business.Message#Message(String, String[])
     */
    public Filter(String name,
            String[] columns) {
        super(name, columns);
    }
}