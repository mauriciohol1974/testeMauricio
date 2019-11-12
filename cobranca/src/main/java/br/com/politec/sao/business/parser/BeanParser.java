package br.com.politec.sao.business.parser;

import java.util.Iterator;

import br.com.politec.sao.business.BeanVisitor;
import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.util.Assertions;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa o parser de um objeto do tipo
 * 
 * @see br.com.politec.sao.business.BusinessObject
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class BeanParser implements BeanVisitor {
    /**
     * Método visit.
     * 
     * @see br.com.politec.sao.business.BeanVisitor#visit(br.com.politec.sao.business.BusinessObject)
     *      Método que realiza a "visitação", pattern <code>visitor</code>,
     *      do bean e realiza a atribuição de propriedades ao objeto passado
     *      como parâmetro.
     * @param bean
     *            Objeto que será mapeado e visitado para atribuição dos valores
     *            de propriedades.
     */
    public synchronized void visit(BusinessObject bean) {
        Property property;
        Object value;
        Assertions.requires(bean != null);
        for (final Iterator i = bean.getLayout().properties(); i.hasNext();) {
            property = (Property) i.next();
            value = get(property);
            checkValue(bean, property, value);
            bean.setPropertyValue(property, property.convert(value));
        }
    }

    /**
     * Método checkValue. Verifica se o valor passado como parâmetro pode ser
     * convertido em uma propriedade e atribuida ao bean, também passados como
     * parâmetro.
     * 
     * @param bean
     *            Objeto que irá receber o atributo caso este seja válido.
     * @param property
     *            Instância do tipo de propriedade desejada.
     * @param value
     *            Valor que será checado.
     */
    private void checkValue(BusinessObject bean, Property property, Object value) {
        final StringBuffer message = new StringBuffer();
        message.append("Property [").append(property.getSignature());
        message.append("] does not accept  [");
        appendValue(value, message);
        message.append("] in Bean [").append(bean.getBeanName()).append("]!");
        Assertions.check(property.accepts(value), message.toString());
    }

    /**
     * Método appendValue. Concatena no buffer passado como parâmetro o valor e
     * o nome da propriedade, também passada como parâmetro.
     * 
     * @param value
     *            Propriedade para obtenção de valor e nome.
     * @param message
     *            Buffer de mensagem.
     */
    private void appendValue(Object value, StringBuffer message) {
        message.append(value);
        message.append(": ");
        message.append((value != null) ? value.getClass().getName() : "null");
    }

    /**
     * Método get. Retorna o valor da propriedade passada como parâmetro.
     * 
     * @param property
     *            Propriedade passada como parâmetro.
     * @return Objeto com o valor da propriedade.
     */
    protected abstract Object get(Property property);
}