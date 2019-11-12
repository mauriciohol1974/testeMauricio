package br.com.politec.sao.business;

import java.io.IOException;

import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.ValueObject;
import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa uma propriedade mantida num
 * 
 * @see br.com.politec.sao.business.BusinessObject , estrutura de dados padr�o
 *      para encapsulamento de dados da framework.
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class Property extends ValueObject implements Comparable {
    /**
     * Defini��o do tipo de propriedade.
     */
    private final Type type;

    /**
     * Indicador de imutabilidade do valor da propriedade.
     */
    private final boolean immutable;

    /**
     * Indicador de opcionalidade da propriedade.
     */
    private final boolean optional;

    /**
     * Nome da propriedade.
     */
    private final String name;

    /**
     * Construtor default do objeto de propriedade.
     * 
     * @param name
     *            Nome da propriedade.
     * @param type
     *            Tipo da propriedade.
     * @param immutable
     *            Inidicador de imutabilidade.
     * @param optional
     *            Indicador de opcionalidade.
     */
    public Property(String name,
            Type type,
            boolean immutable,
            boolean optional) {
        Assertions.requires(type != null);
        Assertions.requires(isValidName(name), "Invalid name [" + name + "]!");
        this.name = name;
        this.type = type;
        this.immutable = immutable;
        this.optional = optional;
    }

    /**
     * M�todo getName. Retorna o nome da propriedade.
     * 
     * @return Nome da propriedade.
     */
    public String getName() {
        return this.name;
    }

    /**
     * M�todo isValidName. Verifica se o nome passado como par�metro � um nome
     * de propriedade v�lido.
     * 
     * @param name
     *            Nome para verifica��o.
     * @return Nome da propriedade.
     */
    public boolean isValidName(String name) {
        return ((name != null) && (name.length() > 0) && (name.indexOf(' ') == -1));
    }

    /**
     * M�todo accepts. Verifica se o valor passado como par�metro pode ou n�o
     * ser aceito como valor da propriedade.
     * 
     * @param value
     *            Valor para verifica��o.
     * @return Resultado da verifica��o.
     */
    public boolean accepts(Object value) {
        if (isOptional() && (value == null)) {
            return true;
        } else {
            return getType().isValid(value);
        }
    }

    /**
     * M�todo convert. Converte o objeto passado como par�metro num objeto do
     * tipo propriedade, caso seja poss�vel.
     * 
     * @param value
     *            Objeto para convers�o.
     * @return Nova inst�ncia de objeto.
     */
    public Object convert(Object value) {
        Assertions.requires(accepts(value));
        if (isOptional() && (value == null)) {
            return null;
        } else {
            return getType().newInstance(value);
        }
    }

    /**
     * M�todo getType. Retorna o tipo da propriedade.
     * 
     * @see br.com.politec.sao.business.Type
     * @return Tipo da propriedade.
     */
    public Type getType() {
        return this.type;
    }

    /**
     * M�todo getPropertyClass. Retorna o tipo <code>Class</code> do objeto de
     * propriedade.
     * 
     * @see java.lang.Class
     * @return Tipo <code>Class</code> do objeto de propriedade.
     */
    public Class getPropertyClass() {
        try {
            return Class.forName(this.type.getTypeRealName());
        } catch (Exception exc) {
            throw new WrappingException(exc);
        }
    }

    /**
     * M�todo isImmutable. Verifica se a propriedade � imut�vel.
     * 
     * @return Verifica��o se a propriedade � imut�vel.
     */
    public boolean isImmutable() {
        return this.immutable;
    }

    /**
     * M�todo isOptional. Verifica se a propriedade � opcional.
     * 
     * @return Verifica��o se a propriedade � opcional.
     */
    public boolean isOptional() {
        return this.optional;
    }

    /**
     * M�todo getSignature. Retorna o nome da propriedade contacatenado com o
     * tipo da propriedade. <code>nome_propriedade: tipo_propriedade</code>
     * 
     * @return <code>nome_propriedade: tipo_propriedade</code>
     */
    public String getSignature() {
        final StringBuffer result = new StringBuffer();
        result.append(getName()).append(": ").append(getType());
        return result.toString();
    }

    /**
     * M�todo formatOn. Formata o nome e valor da propriedade para composi��o de
     * log no objeto de Appender passado como par�metro.
     * 
     * @see Appender
     * @param out
     *            Appender para adi��o dos valores formatados.
     * @param value
     *            Valor para ser adicionado.
     * @throws IOException
     *             Caso ocorra algum erro trat�vel.
     */
    public void formatOn(Appender out, Object value) throws IOException {
        Assertions.requires(out != null);
        Assertions.requires(accepts(value), getSignature()
                                            + " doesn't accept ["
                                            + value
                                            + "]!");
        if (!(isOptional() && (value == null))) {
            getType().formatOn(out, value);
        }
    }

    /**
     * M�todo toString. Serializa o objeto segundo regras pr�prias.
     * 
     * @see java.lang.Object#toString()
     * @return Objeto serializado.
     */
    public String toString() {
        final StringBuffer result = new StringBuffer();
        result.append("{");
        result.append("name => ").append(getName()).append(", ");
        result.append("type => ").append(getType()).append(", ");
        result.append("immutable => ").append(isImmutable()).append(", ");
        result.append("optional => ").append(isOptional());
        result.append("}");
        return result.toString();
    }

    /**
     * M�todo equals. Compara o objeto com outro passado como par�metro.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     * @param obj
     *            Objeto para compara��o.
     * @return Resultado da compara��o.
     */
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            final Property other = (Property) obj;
            return equals(isImmutable(), other.isImmutable())
                   && equals(isOptional(), other.isOptional())
                   && equals(getName(), other.getName())
                   && equals(getType(), other.getType());
        } else {
            return false;
        }
    }

    /**
     * M�todo hashCode.
     * 
     * @see java.lang.Object#hashCode()
     * @return Hashcode do objeto.
     */
    public int hashCode() {
        return getName().hashCode() ^ getType().hashCode();
    }

    /**
     * M�todo compareTo. Compara o conte�do do objeto de propriedade com o
     * passado como par�metro.
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * @param obj
     *            Objeto com os dados para compara��o.
     * @return Resultado da compara��o.
     */
    public int compareTo(Object obj) {
        if (super.equals(obj)) {
            final Property other = (Property) obj;
            return getName().compareTo(other.getName());
        } else {
            return +1;
        }
    }
}