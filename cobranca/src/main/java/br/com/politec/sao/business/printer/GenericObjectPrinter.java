package br.com.politec.sao.business.printer;

import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.reflection.ReflexUtils;
import br.com.politec.sao.util.Assertions;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Fornece uma solução para se obter a partir de um objeto, outro com as mesmas
 * caracteristicas de atributos. Utilizado de forma genérica, para objetos com
 * estruturas contendo propriedades.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class GenericObjectPrinter extends BeanPrinter {
    /**
     * Objeto alvo da visitação para obtenção dos dados.
     */
    private final Object target;

    /**
     * Construtor default para o objeto.
     * 
     * @param target
     *            Objeto que será visitado para obtenção dos dados.
     */
    public GenericObjectPrinter(Object target) {
        Assertions.requires(target != null);
        this.target = target;
    }

    /**
     * Método doOnlyOne.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doOnlyOne(java.lang.Object)
     *      Realiza a obtenção apenas da primeira propriedade mantida pelo
     *      objeto e a atribui para o objeto alvo.
     * @param obj
     *            Objeto para obtenção do valor.
     */
    protected void doOnlyOne(Object obj) {
        final Property property = (Property) obj;
        if (ReflexUtils.hasPropertySetter(target, property)) {
            final Object value = getTransientBean().getPropertyValue(property.getName());
            if (value == null) {
                Assertions.check(property.isOptional(), "Property ["
                                                        + property
                                                        + "] has a null value!");
            }
            ReflexUtils.setPropertyValue(this.target, property, value);
        }
    }

    /**
     * Método doFirst.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doFirst(java.lang.Object)
     *      Realiza a obtenção do primeiro valor a ser clonado.
     * @param obj
     *            Objeto que contem o valor da propriedade.
     */
    protected void doFirst(Object obj) {
        doOnlyOne(obj);
    }

    /**
     * Método doEach.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doEach(java.lang.Object)
     *      Realiza a obtenção de cada valor de atributo do objeto para
     *      clonagem.
     * @param obj
     *            Objeto que contem os valores.
     */
    protected void doEach(Object obj) {
        doOnlyOne(obj);
    }

    /**
     * Método doLast.
     * 
     * @see br.com.politec.sao.util.IterativeProcess#doLast(java.lang.Object)
     *      Realiza a obtenção do último valor a ser clonado.
     * @param obj
     *            Objeto que contem o valor da propriedade.
     */
    protected void doLast(Object obj) {
        doOnlyOne(obj);
    }

    /**
     * Método getObject. Retorna o objeto clonado.
     * 
     * @return Objeto clonado.
     */
    public Object getObject() {
        return this.target;
    }

    /**
     * Método getText.
     * 
     * @see br.com.politec.sao.business.printer.BeanPrinter#getText() Retorna a
     *      representação textual do objeto clonado.
     * @return Representação textual do objeto clonado.
     */
    public String getText() {
        return this.target.toString();
    }
}