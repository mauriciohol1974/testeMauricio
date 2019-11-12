package br.com.politec.sao.business.parser;

import br.com.politec.sao.business.BusinessObject;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.util.Assertions;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Parser dos objetos mantidos pela Framework. Implementa as caracter�sticas
 * essenciais para o parsing de objetos do tipo
 * 
 * @see br.com.politec.sao.business.BusinessObject
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class BusinessObjectParser extends BeanParser {
    /**
     * Objeto que ser� carregado com os dados de propriedades.
     */
    private final BusinessObject bean;

    /**
     * Construtor default do objeto.
     * 
     * @param bean
     *            Bean padr�o que ser� parseado pelo objeto.
     */
    public BusinessObjectParser(BusinessObject bean) {
        Assertions.requires(bean != null);
        this.bean = bean;
    }

    /**
     * M�todo get.
     * 
     * @see br.com.politec.sao.business.parser.BeanParser#get(br.com.politec.sao.business.Property)
     *      Retorna o valor da propriedade, mantida no bean, identificada pelo
     *      par�metro.
     * @param property
     *            Propriedade solicitada.
     * @return Valor da propriedade.
     */
    protected Object get(Property property) {
        Assertions.requires(property != null);
        return this.bean.getPropertyValue(property.getName());
    }
}