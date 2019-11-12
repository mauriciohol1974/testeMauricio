package br.com.politec.sao.business.reflection;

import java.lang.reflect.Method;

import br.com.politec.sao.business.Property;
import br.com.politec.sao.util.Utils;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Fornece acesso reflexivo as propriedades e demais caracter�sticas dos beans e
 * propriedades mantidos pela framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class BeanReflex {
    /**
     * M�todo getBeanName. Retorna o nome do objeto manipulado.
     * 
     * @return Nome do objeto manipulado.
     */
    public final String getBeanName() {
        return Utils.getSingleClassName(getClass().getName());
    }

    /**
     * M�todo getPropertyValue. Retorna o valor da propriedade identificada como
     * par�metro.
     * 
     * @param name
     *            Nome da propriedade cujo valor � solicitado.
     * @return Valor da propriedade solicitada.
     */
    public final Object getPropertyValue(String name) {
        final Method propertyGetter = findMethod(ReflexUtils.getGetterName(name),
                new Class[] {});
        return invoke(propertyGetter, new Object[] {});
    }

    /**
     * M�todo setPropertyValue. Atribui o valor passado como par�metro a
     * propriedade passada como par�metro, tamb�m.
     * 
     * @param property
     *            Propriedade que receber� o valor passado como par�metro.
     * @param value
     *            Valor para atribui��o.
     */
    public final void setPropertyValue(Property property, Object value) {
        final Method propertySetter = findMethod(ReflexUtils.getSetterName(property.getName()),
                new Class[] { property.getPropertyClass() });
        invoke(propertySetter, new Object[] { value });
    }

    /**
     * M�todo invoke. Permite invocar um m�todo com uma lista de par�metros.
     * 
     * @param method
     *            M�todo a ser invocado.
     * @param parameters
     *            Lista de par�metros para o m�todo.
     * @return Resultado do m�todo invocado.
     */
    private Object invoke(Method method, Object[] parameters) {
        return ReflexUtils.invoke(this, method, parameters);
    }

    /**
     * M�todo findMethod. Permite localizar um m�todo cuja assinatura seja
     * compat�vel com os par�metros.
     * 
     * @param methodName
     *            Nome do m�todo.
     * @param parameterTypes
     *            Par�metros para execu��o do m�todo.
     * @return M�todo localizado.
     */
    private Method findMethod(String methodName, Class[] parameterTypes) {
        return ReflexUtils.findMethod(this, methodName, parameterTypes);
    }
}