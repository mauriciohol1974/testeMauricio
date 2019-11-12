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
 * @see br.com.politec.sao.business.BusinessObject , estrutura de dados padrão
 *      para encapsulamento de dados da framework.
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class Property extends ValueObject implements Comparable {
    /**
     * Definição do tipo de propriedade.
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
     * Método getName. Retorna o nome da propriedade.
     * 
     * @return Nome da propriedade.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método isValidName. Verifica se o nome passado como parâmetro é um nome
     * de propriedade válido.
     * 
     * @param name
     *            Nome para verificação.
     * @return Nome da propriedade.
     */
    public boolean isValidName(String name) {
        return ((name != null) && (name.length() > 0) && (name.indexOf(' ') == -1));
    }

    /**
     * Método accepts. Verifica se o valor passado como parâmetro pode ou não
     * ser aceito como valor da propriedade.
     * 
     * @param value
     *            Valor para verificação.
     * @return Resultado da verificação.
     */
    public boolean accepts(Object value) {
        if (isOptional() && (value == null)) {
            return true;
        } else {
            return getType().isValid(value);
        }
    }

    /**
     * Método convert. Converte o objeto passado como parâmetro num objeto do
     * tipo propriedade, caso seja possível.
     * 
     * @param value
     *            Objeto para conversão.
     * @return Nova instância de objeto.
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
     * Método getType. Retorna o tipo da propriedade.
     * 
     * @see br.com.politec.sao.business.Type
     * @return Tipo da propriedade.
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Método getPropertyClass. Retorna o tipo <code>Class</code> do objeto de
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
     * Método isImmutable. Verifica se a propriedade é imutável.
     * 
     * @return Verificação se a propriedade é imutável.
     */
    public boolean isImmutable() {
        return this.immutable;
    }

    /**
     * Método isOptional. Verifica se a propriedade é opcional.
     * 
     * @return Verificação se a propriedade é opcional.
     */
    public boolean isOptional() {
        return this.optional;
    }

    /**
     * Método getSignature. Retorna o nome da propriedade contacatenado com o
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
     * Método formatOn. Formata o nome e valor da propriedade para composição de
     * log no objeto de Appender passado como parâmetro.
     * 
     * @see Appender
     * @param out
     *            Appender para adição dos valores formatados.
     * @param value
     *            Valor para ser adicionado.
     * @throws IOException
     *             Caso ocorra algum erro tratável.
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
     * Método toString. Serializa o objeto segundo regras próprias.
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
     * Método equals. Compara o objeto com outro passado como parâmetro.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     * @param obj
     *            Objeto para comparação.
     * @return Resultado da comparação.
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
     * Método hashCode.
     * 
     * @see java.lang.Object#hashCode()
     * @return Hashcode do objeto.
     */
    public int hashCode() {
        return getName().hashCode() ^ getType().hashCode();
    }

    /**
     * Método compareTo. Compara o conteúdo do objeto de propriedade com o
     * passado como parâmetro.
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * @param obj
     *            Objeto com os dados para comparação.
     * @return Resultado da comparação.
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