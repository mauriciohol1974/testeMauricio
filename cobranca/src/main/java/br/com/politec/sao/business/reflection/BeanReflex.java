package br.com.politec.sao.business.reflection;

import java.lang.reflect.Method;

import br.com.politec.sao.business.Property;
import br.com.politec.sao.util.Utils;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Fornece acesso reflexivo as propriedades e demais características dos beans e
 * propriedades mantidos pela framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class BeanReflex {
    /**
     * Método getBeanName. Retorna o nome do objeto manipulado.
     * 
     * @return Nome do objeto manipulado.
     */
    public final String getBeanName() {
        return Utils.getSingleClassName(getClass().getName());
    }

    /**
     * Método getPropertyValue. Retorna o valor da propriedade identificada como
     * parâmetro.
     * 
     * @param name
     *            Nome da propriedade cujo valor é solicitado.
     * @return Valor da propriedade solicitada.
     */
    public final Object getPropertyValue(String name) {
        final Method propertyGetter = findMethod(ReflexUtils.getGetterName(name),
                new Class[] {});
        return invoke(propertyGetter, new Object[] {});
    }

    /**
     * Método setPropertyValue. Atribui o valor passado como parâmetro a
     * propriedade passada como parâmetro, também.
     * 
     * @param property
     *            Propriedade que receberá o valor passado como parâmetro.
     * @param value
     *            Valor para atribuição.
     */
    public final void setPropertyValue(Property property, Object value) {
        final Method propertySetter = findMethod(ReflexUtils.getSetterName(property.getName()),
                new Class[] { property.getPropertyClass() });
        invoke(propertySetter, new Object[] { value });
    }

    /**
     * Método invoke. Permite invocar um método com uma lista de parâmetros.
     * 
     * @param method
     *            Método a ser invocado.
     * @param parameters
     *            Lista de parâmetros para o método.
     * @return Resultado do método invocado.
     */
    private Object invoke(Method method, Object[] parameters) {
        return ReflexUtils.invoke(this, method, parameters);
    }

    /**
     * Método findMethod. Permite localizar um método cuja assinatura seja
     * compatível com os parâmetros.
     * 
     * @param methodName
     *            Nome do método.
     * @param parameterTypes
     *            Parâmetros para execução do método.
     * @return Método localizado.
     */
    private Method findMethod(String methodName, Class[] parameterTypes) {
        return ReflexUtils.findMethod(this, methodName, parameterTypes);
    }
}