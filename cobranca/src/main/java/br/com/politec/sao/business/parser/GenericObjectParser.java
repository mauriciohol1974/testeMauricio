package br.com.politec.sao.business.parser;

import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.reflection.ReflexUtils;
import br.com.politec.sao.util.Assertions;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Parser simples para obtenção de valores de propriedades de um bean.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class GenericObjectParser extends BeanParser {
    /**
     * @see br.com.politec.sao.business.BusinessObject Bean contendo as
     *      prorpriedades.
     */
    private final Object bean;

    /**
     * Construtor default do objeto.
     * 
     * @param bean
     *            Bean para parsing.
     */
    public GenericObjectParser(Object bean) {
        Assertions.requires(bean != null);
        this.bean = bean;
    }

    /**
     * Método get.
     * 
     * @see br.com.politec.sao.business.parser.BeanParser#get(br.com.politec.sao.business.Property)
     *      Retorna o valor da prorpriedade mantida no bean, e identificada pelo
     *      parâmetro.
     * @param property
     *            Identificação da propriedade desejada.
     * @return Valor da propriedade desejada.
     */
    protected Object get(Property property) {
        Assertions.requires(property != null);
        return ReflexUtils.getPropertyValue(this.bean, property);
    }
}