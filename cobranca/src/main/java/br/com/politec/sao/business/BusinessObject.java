package br.com.politec.sao.business;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Iterator;

import br.com.politec.sao.business.reflection.BeanReflex;
import br.com.politec.sao.business.reflection.ReflexUtils;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.com.politec.sao.util.Percentual;
import br.com.politec.sao.util.StringAppender;
import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Define a hierarquia de objetos de dados tratados pela framework. Os objetos
 * de dados (<code>beans</code>) gerados automáticamente pela framework,
 * herdam diretamente BusinessObject. Desta herança, caracterísiticas
 * importantes para utilização das estruturas de parsing da framework são
 * obtidas.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @author Andrew Betencourt - abetencourt@sao.politec.com.br - Complemento de
 *         inicialização de objetos Bussiness Object
 * @version release 1.3
 */
public abstract class BusinessObject extends BeanReflex implements Cloneable,
        Serializable {

    /**
     * Method getApplicationName. Retorna o nome da aplicação a qual o objeto
     * pertence.
     * 
     * @return String Nome da aplicação.
     */
    public abstract String getApplicationName();

    /**
     * Method getLayout. Retorna o objeto de layout da aplicação. Este objeto é
     * utilizado pelas estruturas de parsing da framework para as conversões
     * possíveis.
     * 
     * @return Layout Objeto que encapsula as informações de layout do objeto.
     */
    public abstract Layout getLayout();

    /**
     * Method getApplication. Retorna uma instancia do objeto que representa a
     * aplicação a qual o objeto esta atrelado.
     * 
     * @return Application Instancia que representa a aplicação.
     */
    public Application getApplication() {
        return Application.getInstance(getApplicationName());
    }

    /**
     * Method accept. Método padrão para aceitar a "visitação" de um outro
     * objeto. A estrutura de "visitação" é utilizada pelos parsers definidos na
     * framework. book: Design Patterns Elements of Reusable Object-Oriented
     * Software<br>
     * Erich Gama, Richard Helm, Ralph Johnson, John Vlissides<br>
     * ISBN 0-201-63361-2
     * 
     * @param visitor
     *            "Visitador" aceito pelo método.
     */
    public void accept(BeanVisitor visitor) {
        Assertions.requires(visitor != null);
        visitor.visit(this);
        initBean(this);
    }

    /**
     * Method getExtension. Retorna a definição da estrutura de layout utilizada
     * pelo objeto. Exemplos de extensões válidas são SQL e MAINFRAME.
     * 
     * @param type
     *            Definição da chave para busca do tipo de extensão desejada.
     * @return Extension Objeto que define as caracteristicas da extensão
     *         associada ao objeto.
     */
    public Extension getExtension(String type) {
        return getLayout().getExtension(type);
    }

    /**
     * Method getKey. Obtém a "chave única" para o objeto.
     * 
     * @return Key Chave única do objeto.
     */
    public Key getKey() {
        return Key.NULL;
    }

    /**
     * Method getFormattedValue. Retorna o valor da propriedade formatado de
     * acordo com a mascara definida no arquivo de criação XML, e posteriormente
     * mantida na estrutura de layout do objeto de dados.
     * 
     * @param propertyName
     *            Nome da propriedade para obtenção do valor.
     * @return String Valor da propriedade formatado.
     */
    public String getFormattedValue(String propertyName) {
        Assertions.requires(getLayout().has(propertyName));
        final StringAppender out = new StringAppender();
        final Property property = getLayout().get(propertyName);
        String result = "";
        try {
            property.formatOn(out, getPropertyValue(property.getName()));
            result = out.getText();
        } catch (IOException exc) {
            result = getPropertyValue(property.getName()).toString();
        }
        return result;
    }

    /**
     * Method setPropertyValue. Atribui a propriedade o valor informado como
     * parâmetro. Será realizada uma conversão do tipo Object para o tipo
     * definido para a propriedade.
     * 
     * @param name
     *            Nome da propriedade que receberá o valor.
     * @param value
     *            Valor a ser atribuido.
     */
    public void setPropertyValue(String name, Object value) {
        setPropertyValue(getLayout().get(name), value);
    }

    /**
     * @see java.lang.Object#toString() Converte o objeto para o tipo String,
     *      serializando todos os seus valores de atributos.
     * @return String Com os dados do objeto serializados.
     */
    public String toString() {
        final StringPrinter printer = new StringPrinter();
        printer.visit(this);
        return printer.getText();
    }

    /**
     * @see java.lang.Object#equals(Object) Método equals padrão para
     *      verificação de igualdade de objetos.
     * @param obj
     *            Objeto para comparação.
     * @return boolean True para instancias do mesmo tipo, ou false para
     *         instancias de tipos diferentes.
     */
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else if ((obj instanceof BusinessObject)
                   && getClass().equals(obj.getClass())) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * @see java.lang.Object#clone() Método para "clonagem" do objeto.
     * @return Nova instância, identica, do objeto original.
     */
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException exc) {
            throw new WrappingException(exc);
        }
    }

    /**
     * Method prototype. Obtém uma instância deste objeto.
     * 
     * @return BusinessObject Nova instância deste objeto.
     */
    public BusinessObject prototype() {
        try {
            return ((BusinessObject) getClass().newInstance());
        } catch (IllegalAccessException exc) {
            throw new WrappingException(exc);
        } catch (InstantiationException exc) {
            throw new WrappingException(exc);
        }
    }

    /**
     * Method isSimilar. Verifica se os dois objetos possuem a mesma estrutura
     * de layout e tem valores de propriedades iguais.
     * 
     * @param other
     *            Objeto para comparação.
     * @return boolean De acordo com as comparações descritas acima.
     */
    public boolean isSimilar(Object other) {
        if (!equals(other)) {
            for (final Iterator i = getLayout().properties(); i.hasNext();) {
                final Property property = (Property) i.next();
                if (!isPropertyEqual(other, property)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method hasSameInterface. Verifica se os dois objetos possuem a mesma
     * estrutura de layout.
     * 
     * @param other
     *            Objeto para comparação.
     * @return boolean De acordo com as comparações descritas acima.
     */
    public boolean hasSameInterface(Object other) {
        for (final Iterator i = getLayout().properties(); i.hasNext();) {
            final Property property = (Property) i.next();
            if (!property.isOptional()
                && !ReflexUtils.hasPropertyGetter(other, property)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method equals. Compara dois objetos passados como parâmetros, utilizando
     * o método equals.
     * 
     * @param first
     *            Primeiro objeto para comparação.
     * @param second
     *            Segundo objeto para comparação.
     * @return boolean Resultado da comparação.
     */
    protected boolean equals(Object first, Object second) {
        boolean result = false;
        if (first == second) {
            result = true;
        } else if ((first == null) || (second == null)) {
            result = false;
        } else {
            result = first.equals(second);
        }
        return result;
    }

    /**
     * Method isPropertyEqual. Verifica se o objeto passado como parâmetro tem
     * um valor de propriedade igual ao desta instancia.
     * 
     * @param other
     *            Objeto para obtenção do valor da propriedade para comparação.
     * @param property
     *            Propriedade a ser comparada.
     * @return boolean Resultado da comparação.
     */
    private boolean isPropertyEqual(Object other, Property property) {
        final Object value = ReflexUtils.getPropertyValue(other, property);
        return equals(getPropertyValue(property.getName()), value);
    }

    public void initBean(BusinessObject object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (object.getPropertyValue(fields[i].getName()) == null) {
                if (fields[i].getType()
                        .toString()
                        .equals("class java.lang.String")) {
                    object.setPropertyValue(fields[i].getName(), "");
                } else if (fields[i].getType()
                        .toString()
                        .equals("class java.lang.Integer")) {
                    object.setPropertyValue(fields[i].getName(),
                            new Integer("0"));
                } else if (fields[i].getType()
                        .toString()
                        .equals("class java.lang.Long")) {
                    object.setPropertyValue(fields[i].getName(), new Long("0"));
                } else if (fields[i].getType()
                        .toString()
                        .equals("class br.com.politec.sao.util.Money")) {
                    object.setPropertyValue(fields[i].getName(), new Money("0",
                            Currency.get("R$")));
                } else if (fields[i].getType()
                        .toString()
                        .equals("class br.com.politec.sao.util.Percentual")) {
                    object.setPropertyValue(fields[i].getName(),
                            new Percentual(0));
                }
            }
        }
    }
}