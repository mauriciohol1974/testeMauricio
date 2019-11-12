package br.com.politec.sao.business;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Define um filtro, utilizado pela framework no sub-set que trata de itera��es
 * no modelo CRUD de fun��es com dados. Uma aplica��o trivial utilizando apenas
 * as quatro opera��es b�sicas com banco de dados e estruturas simples de dados,
 * s�o tratadas pela framework de modo bastante gen�rico. Uma solicita��o de
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