package br.com.politec.sao.business.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.politec.sao.business.Property;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe com as fun��es b�sicas de reflex�o, utilizada pela classe
 * 
 * @see br.com.politec.sao.business.reflection.BeanReflex
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class ReflexUtils {
    /**
     * M�todo invoke. Permite invocar um m�todo determinado pelos par�metros.
     * 
     * @param supplier
     *            Objeto alvo para execu��o do m�todo.
     * @param method
     *            M�todo a ser executado.
     * @param parameters
     *            Par�metros do m�todo a ser executado.
     * @return Resultado da execu��o.
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
     * M�todo findMethod. Permite a localiza��o de um m�todo determinado pelos
     * par�metros.
     * 
     * @param supplier
     *            Objeto para pesquisa do m�todo.
     * @param methodName
     *            M�todo a ser localizado.
     * @param parameterTypes
     *            Par�metros aceitos pelo m�todo para pesquisa.
     * @return Objeto que reresenta o m�todo localizado.
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
     * M�todo hasPropertyGetter. Permite verificar se a propriedade possui
     * m�todo de acesso para atribui��o de valores.
     * 
     * @param supplier
     *            Objeto para pesquisa da exist�ncia do m�todo.
     * @param property
     *            Propriedade para verifica��o.
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
     * M�todo hasPropertySetter. Permite verificar se a propriedade possui
     * m�todo de acesso para obten��o de valor.
     * 
     * @param supplier
     *            Objeto para pesquisa da exist�ncia do m�todo.
     * @param property
     *            Propriedade para verifica��o.
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
     * M�todo getPropertyValue. Obtem o valor da propriedade identificada pelo
     * par�metro.
     * 
     * @param supplier
     *            Objeto que mant�m a propriedade.
     * @param property
     *            Propriedade para obten��o do valor.
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
     * M�todo setPropertyValue. Atribui a propriedade identificada como
     * par�metro, o valor passado como par�metro.
     * 
     * @param supplier
     *            Objeto que mant�m a propriedade.
     * @param property
     *            Propriedade para atribui��o.
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
     * M�todo getGetterName. Retorna o nome do m�todo de atribui��o de valor a
     * propriedade passada como par�metro.
     * 
     * @param propertyName
     *            Nome da propriedade.
     * @return Nome do m�todo de atribui��o de valor.
     */
    public static final String getGetterName(String propertyName) {
        Assertions.requires(propertyName != null);
        Assertions.requires(propertyName.length() > 0, "Invalid property name!");
        return composePropertyName("get", propertyName);
    }

    /**
     * M�todo getSetterName. Retorna o nome do m�todo de recupera��o de valor da
     * propriedade passada como par�metro.
     * 
     * @param propertyName
     *            Nome da propriedade.
     * @return Nome do m�todo de recupera��o de valor.
     */
    public static final String getSetterName(String propertyName) {
        Assertions.requires(propertyName != null);
        Assertions.requires(propertyName.length() > 0, "Invalid property name!");
        return composePropertyName("set", propertyName);
    }

    /**
     * M�todo composePropertyName. Comp�e as assinaturas dos m�todos de acesso e
     * atribui��o de valores de atributos.
     * 
     * @param prefix
     *            Prefixo de assinatura de m�todo.
     * @param propertyName
     *            Nome da propriedade.
     * @return Composi��o do nome do m�todo.
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
