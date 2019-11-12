package br.com.politec.sao.business.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.politec.sao.business.Property;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe com as funções básicas de reflexão, utilizada pela classe
 * 
 * @see br.com.politec.sao.business.reflection.BeanReflex
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class ReflexUtils {
    /**
     * Método invoke. Permite invocar um método determinado pelos parâmetros.
     * 
     * @param supplier
     *            Objeto alvo para execução do método.
     * @param method
     *            Método a ser executado.
     * @param parameters
     *            Parâmetros do método a ser executado.
     * @return Resultado da execução.
     */
    public static final Object invoke(Object supplier,
            Method method,
            Object[] parameters) {
        try {
            return method.invoke(supplier, parameters);
        } catch (IllegalAccessException exc) {
            LogUtilSigcb.error("ReflexUtils.invoke:" + exc.getMessage(), exc);
            throw new WrappingException(exc);
        } catch (InvocationTargetException exc) {
            LogUtilSigcb.error("ReflexUtils.invoke:" + exc.getMessage(), exc);
            throw new WrappingException(exc);
        }
    }

    /**
     * Método findMethod. Permite a localização de um método determinado pelos
     * parâmetros.
     * 
     * @param supplier
     *            Objeto para pesquisa do método.
     * @param methodName
     *            Método a ser localizado.
     * @param parameterTypes
     *            Parâmetros aceitos pelo método para pesquisa.
     * @return Objeto que reresenta o método localizado.
     */
    public static final Method findMethod(Object supplier,
            String methodName,
            Class[] parameterTypes) {
        Method result = null;
        while (result == null) {
            try {
                result = supplier.getClass().getMethod(methodName,
                        parameterTypes);
            } catch (NoSuchMethodException exc) {
                if (parameterTypes.length > 0) {
                    parameterTypes[0] = parameterTypes[0].getSuperclass();
                    if (parameterTypes[0] == null) {
                        throw new WrappingException(exc);
                    }
                } else {
                    throw new WrappingException(exc);
                }
            }
        }
        return result;
    }

    /**
     * Método hasPropertyGetter. Permite verificar se a propriedade possui
     * método de acesso para atribuição de valores.
     * 
     * @param supplier
     *            Objeto para pesquisa da existência do método.
     * @param property
     *            Propriedade para verificação.
     * @return Resultado da pesquisa.
     */
    public static final boolean hasPropertyGetter(Object supplier,
            Property property) {
        boolean result = false;
        try {
            result = supplier.getClass()
                    .getMethod(getGetterName(property.getName()),
                            new Class[] {}) != null;
        } catch (NoSuchMethodException exc) {
            result = false;
        }
        return result;
    }

    /**
     * Método hasPropertySetter. Permite verificar se a propriedade possui
     * método de acesso para obtenção de valor.
     * 
     * @param supplier
     *            Objeto para pesquisa da existência do método.
     * @param property
     *            Propriedade para verificação.
     * @return Resultado da pesquisa.
     */
    public static final boolean hasPropertySetter(Object supplier,
            Property property) {
        boolean result = false;
        try {
            result = supplier.getClass()
                    .getMethod(getSetterName(property.getName()),
                            new Class[] { property.getPropertyClass() }) != null;
        } catch (NoSuchMethodException exc) {
            result = false;
        }
        return result;
    }

    /**
     * Método getPropertyValue. Obtem o valor da propriedade identificada pelo
     * parâmetro.
     * 
     * @param supplier
     *            Objeto que mantém a propriedade.
     * @param property
     *            Propriedade para obtenção do valor.
     * @return Valor da propriedade.
     */
    public static final Object getPropertyValue(Object supplier,
            Property property) {
        Object result = null;
        if (hasPropertyGetter(supplier, property)) {
            final Method propertyGetter = findMethod(supplier,
                    getGetterName(property.getName()),
                    new Class[] {});
            result = invoke(supplier, propertyGetter, new Object[] {});
        }
        return result;
    }

    /**
     * Método setPropertyValue. Atribui a propriedade identificada como
     * parâmetro, o valor passado como parâmetro.
     * 
     * @param supplier
     *            Objeto que mantém a propriedade.
     * @param property
     *            Propriedade para atribuição.
     * @param propertyValue
     *            Valor a ser atribuido.
     */
    public static final void setPropertyValue(Object supplier,
            Property property,
            Object propertyValue) {
        final Method propertySetter = findMethod(supplier,
                getSetterName(property.getName()),
                new Class[] { property.getPropertyClass() });
        invoke(supplier, propertySetter, new Object[] { propertyValue });
    }

    /**
     * Método getGetterName. Retorna o nome do método de atribuição de valor a
     * propriedade passada como parâmetro.
     * 
     * @param propertyName
     *            Nome da propriedade.
     * @return Nome do método de atribuição de valor.
     */
    public static final String getGetterName(String propertyName) {
        Assertions.requires(propertyName != null);
        Assertions.requires(propertyName.length() > 0, "Invalid property name!");
        return composePropertyName("get", propertyName);
    }

    /**
     * Método getSetterName. Retorna o nome do método de recuperação de valor da
     * propriedade passada como parâmetro.
     * 
     * @param propertyName
     *            Nome da propriedade.
     * @return Nome do método de recuperação de valor.
     */
    public static final String getSetterName(String propertyName) {
        Assertions.requires(propertyName != null);
        Assertions.requires(propertyName.length() > 0, "Invalid property name!");
        return composePropertyName("set", propertyName);
    }

    /**
     * Método composePropertyName. Compõe as assinaturas dos métodos de acesso e
     * atribuição de valores de atributos.
     * 
     * @param prefix
     *            Prefixo de assinatura de método.
     * @param propertyName
     *            Nome da propriedade.
     * @return Composição do nome do método.
     */
    public static final String composePropertyName(String prefix,
            String propertyName) {
        final StringBuffer result = new StringBuffer(3 + propertyName.length());
        result.append(prefix);
        result.append(Character.toUpperCase(propertyName.charAt(0)));
        result.append(propertyName.substring(1));
        return result.toString();
    }
}
