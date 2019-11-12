package br.com.politec.sao.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.ConstrainedIterator;
import br.com.politec.sao.util.Constraint;
import br.com.politec.sao.util.Utils;
import br.com.politec.sao.util.ValueObject;
import br.com.politec.sao.util.WrappingException;
import electric.xml.Element;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que define a estrutura de layout do objeto de dados tratado pela
 * framework. Esta classe representa ap�s a gera��o autom�tica do c�digo, as
 * declara��es realizadas no arquivo XML utilizado pela framework para gera��o.
 * Estas informa��es s�o utilizadas pelos parsers e pelo objeto de dados para as
 * diversas convers�es de tipo e mascara de dados suportadas pela framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class Layout extends ValueObject implements Comparable {
    /**
     * Verifica��o for�ada para certificar-se de que os tipos tratados fazem
     * parte do classpath da aplica��o.
     */
    static {
        try {
            Class.forName("br.com.politec.sao.business.types.DateType");
            Class.forName("br.com.politec.sao.business.types.DoubleType");
            Class.forName("br.com.politec.sao.business.types.IntegerType");
            Class.forName("br.com.politec.sao.business.types.LongType");
            Class.forName("br.com.politec.sao.business.types.MoneyType");
            Class.forName("br.com.politec.sao.business.types.PercentualType");
            Class.forName("br.com.politec.sao.business.types.StringType");
            Class.forName("br.com.politec.sao.business.types.TimeType");
        } catch (ClassNotFoundException exc) {
            throw new WrappingException(exc);
        }
    }

    /**
     * Lista dos tipos de extens�es suportadas pela Framework.
     */
    private final Map extensions;

    /**
     * Lista dos tipos(propriedades) suportados pela Framework.
     */
    private final Set properties;

    /**
     * Lista dos tipos de filtros suportados pela Framework.
     */
    private final List filters;

    /**
     * Nome do layout que est� sendo tratado.
     */
    private final String qualifiedName;

    /**
     * HashCode do objeto.
     */
    private transient int hashCode = -1;

    /**
     * Construtor do tipo layout.
     * 
     * @param qualifiedName
     *            Identifica o objeto com um nome espec�fico passado como
     *            par�metro.
     */
    private Layout(String qualifiedName) {
        Assertions.requires(isValidName(qualifiedName), "Invalid name ["
                                                        + qualifiedName
                                                        + "]!");
        this.qualifiedName = qualifiedName;
        this.properties = new TreeSet();
        this.filters = new ArrayList();
        this.extensions = new HashMap();
    }

    /**
     * Construtor do tipo layout. Recebe alguns parametros para inicializa��o.
     * 
     * @param properties
     *            Lista das proriedades suportadas pelo objeto.
     * @param name
     *            Nome que identificar� o objeto.
     * @param packageName
     *            Nome do pacote para utiliza��o no parser.
     */
    public Layout(TreeSet properties,
            String name,
            String packageName) {
        this(packageName + "." + name);
        Assertions.requires(properties != null);
        for (final Iterator i = properties.iterator(); i.hasNext();) {
            addProperty(((Property) i.next()));
        }
    }

    /**
     * M�todo addExtension. Determina o tipo de extens�o aceito pelo objeto de
     * layout.
     * 
     * @param extension
     *            Extens�o aceita.
     */
    public void addExtension(Extension extension) {
        Assertions.requires(extension != null);
        this.extensions.put(extension.getType(), extension);
    }

    /**
     * M�todo getAttributeValue. Retorna o valor de um atributo no formato
     * String.
     * 
     * @param source
     *            Elemento que contem o valor do atributo.
     * @param name
     *            Nome do atributo.
     * @param defaultValue
     *            Valor default do atributo.
     * @return Valor do atributo.
     */
    protected String getAttributeValue(Element source,
            String name,
            String defaultValue) {
        if (source.getAttribute(name) != null) {
            return source.getAttribute(name).getValue();
        } else {
            return defaultValue;
        }
    }

    /**
     * M�todo getName. Retorna o nome do objeto de layout que est� sendo
     * manipulado.
     * 
     * @return Nome do objeto de layout.
     */
    public String getName() {
        return Utils.getSingleClassName(getQualifiedName());
    }

    /**
     * M�todo getPackageName. Retorna o nome do pacote que est� sendo manipulado
     * pelo objeto de layout.
     * 
     * @return Nome do pacote que est� sendo manipulado.
     */
    public String getPackageName() {
        return Utils.getPackageName(getQualifiedName());
    }

    /**
     * M�todo getQualifiedName. Retorna o nome do objeto de layout que est�
     * sendo manipulado.
     * 
     * @return Nome do objeto de layout.
     */
    public String getQualifiedName() {
        return this.qualifiedName;
    }

    /**
     * M�todo isValidName. Verifica se o nome passado como par�metro � um nome
     * v�lido.
     * 
     * @param name
     *            Nome a ser verificado.
     * @return Valida��o do nome.
     */
    public boolean isValidName(String name) {
        return ((name != null) && (name.length() > 0) && (name.indexOf(' ') == -1));
    }

    /**
     * M�todo getExtension. Retorna o tipo de extens�o tratada pelo objeto de
     * layout para um determinado tipo.
     * 
     * @param type
     *            Tipo para verifica��o.
     * @return Objeto de extens�o identificado no tipo.
     */
    public Extension getExtension(String type) {
        return (Extension) this.extensions.get(type);
    }

    /**
     * M�todo has. Verifica se a propriedade identificada pelo nome consta do
     * layout.
     * 
     * @param name
     *            Nome para verifica��o.
     * @return Verifica��o da exist�ncia do nome.
     */
    public boolean has(String name) {
        return get(name) != null;
    }

    /**
     * M�todo getPropertyCount. Retorna o n�mero de propriedades suportadas pelo
     * layout.
     * 
     * @return N�mero de propriedades suportadas pelo layout.
     */
    public int getPropertyCount() {
        return this.properties.size();
    }

    /**
     * M�todo get. Retorna a propriedade identificada pelo nome passado como
     * par�metro.
     * 
     * @param name
     *            Nome da propriedade para verifica��o.
     * @return Propriedade identificada pelo nome.
     */
    public Property get(String name) {
        Assertions.requires(name != null);
        for (final Iterator i = properties(); i.hasNext();) {
            final Property property = (Property) i.next();
            if (property.getName().equals(name)) {
                return property;
            }
        }
        return null;
    }

    /**
     * M�todo extensions. Retorna um iterador contendo todas as extens�es
     * aceitas pelo layout.
     * 
     * @return Iterador contendo todas as extens�es aceitas pelo layout.
     */
    public Iterator extensions() {
        return this.extensions.values().iterator();
    }

    /**
     * M�todo filters. Retorna um iterador contendo todos os filtros aceitos
     * pelo layout.
     * 
     * @return Iterador contendo todos os filtros aceitos pelo layout.
     */
    public Iterator filters() {
        return this.filters.iterator();
    }

    /**
     * M�todo properties. Retorna um iterador contendo todos os tipos de
     * proriedades aceitos pelo layout.
     * 
     * @return Iterador contendo todos os tipos de proriedades aceitos pelo
     *         layout.
     */
    public Iterator properties() {
        return this.properties.iterator();
    }

    /**
     * M�todo immutableProperties. Retorna um iterador contendo todos os tipos
     * imut�veis de proriedades aceitos pelo layout.
     * 
     * @return Iterador contendo todos os tipos imut�veis de proriedades aceitos
     *         pelo layout.
     */
    public Iterator immutableProperties() {
        return new ConstrainedIterator(properties(), new Constraint() {
            public boolean constrains(Object obj) {
                return ((Property) obj).isImmutable();
            }
        });
    }

    /**
     * M�todo mutableProperties. Retorna um iterador contendo todos os tipos
     * mut�veis de proriedades aceitos pelo layout.
     * 
     * @return Iterador contendo todos os tipos mut�veis de proriedades aceitos
     *         pelo layout.
     */
    public Iterator mutableProperties() {
        return new ConstrainedIterator(properties(), new Constraint() {
            public boolean constrains(Object obj) {
                return !((Property) obj).isImmutable();
            }
        });
    }

    /**
     * M�todo toString. Serializa o objeto de layout.
     * 
     * @see java.lang.Object#toString()
     * @return Objeto serializado.
     */
    public String toString() {
        final StringBuffer result = new StringBuffer();
        result.append("name => ").append(getName());
        result.append(", packageName => ").append(this.getPackageName());
        result.append(", qualifiedName => ").append(this.getQualifiedName());
        result.append(", properties => {");
        for (final Iterator i = properties(); i.hasNext();) {
            final Property property = (Property) i.next();
            result.append(property);
            result.append(", ");
        }
        result.append("}");
        return result.toString();
    }

    /**
     * M�todo equals. Compara outro objeto com si.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     * @param obj
     *            Objeto para compara��o.
     * @return Compara��o.
     */
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            final Layout other = (Layout) obj;
            if (!equals(getPropertyCount(), other.getPropertyCount())
                || !equals(getQualifiedName(), other.getQualifiedName())) {
                return false;
            }
            return hasEqualsProperties(other);
        } else {
            return false;
        }
    }

    /**
     * M�todo hasEqualsProperties. Compara as suas propriedades com as
     * propriedades mantidas em outro objeto de layout passado como par�metro.
     * 
     * @param other
     *            Objeto para compara��o.
     * @return Resultado da compara��o.
     */
    private boolean hasEqualsProperties(Layout other) {
        for (final Iterator i = properties(); i.hasNext();) {
            final Property property = (Property) i.next();
            final Property otherProperty = other.get(property.getName());
            if (!equals(property, otherProperty)) {
                return false;
            }
        }
        return true;
    }

    /**
     * M�todo compareTo. Compara o conte�do do objeto de layout com o conte�do
     * do obejto passado como par�metro.
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * @param obj
     *            Objeto para compara��o.
     * @return Resultado da compara��o.
     */
    public int compareTo(Object obj) {
        int result = 0;
        if (super.equals(obj)) {
            final Layout other = (Layout) obj;
            result = getQualifiedName().compareTo(other.getQualifiedName());
        } else {
            result = +1;
        }
        return result;
    }

    /**
     * M�todo hashCode.
     * 
     * @see java.lang.Object#hashCode()
     * @return HashCode do objeto.
     */
    public int hashCode() {
        if (this.hashCode == -1) {
            synchronized (this) {
                if (this.hashCode == -1) {
                    this.hashCode = this.hashCode ^ getPackageName().hashCode();
                    for (final Iterator i = properties(); i.hasNext();) {
                        final Property property = (Property) i.next();
                        this.hashCode = this.hashCode ^ property.hashCode();
                    }
                }
            }
        }
        return this.hashCode;
    }

    /**
     * M�todo addProperty. Adiciona uma propriedade a lista de propriedades
     * suportadas pelo objeto de layout.
     * 
     * @param property
     *            Propriedade para adi��o.
     */
    private void addProperty(Property property) {
        Assertions.requires(!has(property.getName()),
                "Layout ["
                        + getName()
                        + "] already has property ["
                        + property
                        + "]!");
        this.properties.add(property);
    }
}