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
     * Objeto que será visitado para obtenção dos dados.
     */
    private transient BusinessObject bean;

    /**
     * Método visit.
     * 
     * @see br.com.politec.sao.business.BeanVisitor#visit(br.com.politec.sao.business.BusinessObject)
     *      Método que inicializa o processo de obtenção dos dados.
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
     * Método getTransientBean. Retorna a instancia do objeto encapsulado.
     * 
     * @return Objeto encapsulado, que receberá os dados do objeto visitado.
     */
    protected final BusinessObject getTransientBean() {
        return this.bean;
    }

    /**
     * Método getText. Retornará a representação textual do objeto criado.
     * 
     * @return Representação textual do objeto.
     */
    public abstract String getText();
}