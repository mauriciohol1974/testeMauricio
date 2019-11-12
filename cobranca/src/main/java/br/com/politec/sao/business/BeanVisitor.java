package br.com.politec.sao.business;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Interface padr�o que deve ser implementada para cria��o das estruturas de
 * parser para os os objetos de dados tratados pela framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public interface BeanVisitor {
    /**
     * Method visit. Define a assinatura do m�todo padr�o para classe.
     * 
     * @param bean
     *            Instancia v�lida de um objeto de dados.
     */
    public void visit(BusinessObject bean);
}
