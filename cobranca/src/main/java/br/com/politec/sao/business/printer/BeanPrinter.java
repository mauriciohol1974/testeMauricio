package br.com.politec.sao.business.printer;

import br.com.politec.sao.business.BeanVisitor;
import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.IterativeProcess;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe utilizada para obter a partir de um objeto, outro com os mesmos
 * valores de atributos.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class BeanPrinter extends IterativeProcess implements
        BeanVisitor {
    /**
     * Objeto que ser� visitado para obten��o dos dados.
     */
    private transient BusinessObject bean;

    /**
     * M�todo visit.
     * 
     * @see br.com.politec.sao.business.BeanVisitor#visit(br.com.politec.sao.business.BusinessObject)
     *      M�todo que inicializa o processo de obten��o dos dados.
     * @param bean
     *            Objeto para ser visitado.
     */
    public synchronized void visit(BusinessObject bean) {
        Assertions.requires(bean != null);
        this.bean = bean;
        iterateOver(bean.getLayout().properties());
        this.bean = null;
    }

    /**
     * M�todo getTransientBean. Retorna a instancia do objeto encapsulado.
     * 
     * @return Objeto encapsulado, que receber� os dados do objeto visitado.
     */
    protected final BusinessObject getTransientBean() {
        return this.bean;
    }

    /**
     * M�todo getText. Retornar� a representa��o textual do objeto criado.
     * 
     * @return Representa��o textual do objeto.
     */
    public abstract String getText();
}