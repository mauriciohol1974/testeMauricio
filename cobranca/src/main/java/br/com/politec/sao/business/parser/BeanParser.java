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
     * M�todo visit.
     * 
     * @see br.com.politec.sao.business.BeanVisitor#visit(br.com.politec.sao.business.BusinessObject)
     *      M�todo que realiza a "visita��o", pattern <code>visitor</code>,
     *      do bean e realiza a atribui��o de propriedades ao objeto passado
     *      como par�metro.
     * @param bean
     *            Objeto que ser� mapeado e visitado para atribui��o dos valores
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
     * M�todo checkValue. Verifica se o valor passado como par�metro pode ser
     * convertido em uma propriedade e atribuida ao bean, tamb�m passados como
     * par�metro.
     * 
     * @param bean
     *            Objeto que ir� receber o atributo caso este seja v�lido.
     * @param property
     *            Inst�ncia do tipo de propriedade desejada.
     * @param value
     *            Valor que ser� checado.
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
     * M�todo appendValue. Concatena no buffer passado como par�metro o valor e
     * o nome da propriedade, tamb�m passada como par�metro.
     * 
     * @param value
     *            Propriedade para obten��o de valor e nome.
     * @param message
     *            Buffer de mensagem.
     */
    private void appendValue(Object value, StringBuffer message) {
        message.append(value);
        message.append(": ");
        message.append((value != null) ? value.getClass().getName() : "null");
    }

    /**
     * M�todo get. Retorna o valor da propriedade passada como par�metro.
     * 
     * @param property
     *            Propriedade passada como par�metro.
     * @return Objeto com o valor da propriedade.
     */
    protected abstract Object get(Property property);
}