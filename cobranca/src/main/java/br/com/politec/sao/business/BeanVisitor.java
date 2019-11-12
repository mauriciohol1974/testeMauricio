package br.com.politec.sao.business;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Interface padrão que deve ser implementada para criação das estruturas de
 * parser para os os objetos de dados tratados pela framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public interface BeanVisitor {
    /**
     * Method visit. Define a assinatura do método padrão para classe.
     * 
     * @param bean
     *            Instancia válida de um objeto de dados.
     */
    public void visit(BusinessObject bean);
}
