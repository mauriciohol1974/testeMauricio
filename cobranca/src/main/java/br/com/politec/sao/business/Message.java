package br.com.politec.sao.business;

import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.StringUtils;
import br.com.politec.sao.util.Utils;
import br.com.politec.sao.util.ValueObject;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que representa uma mensagem na estrutura de troca de dados na
 * Framework. Uma menssagem � utilizada para trafego de dados entre os diversos
 * formatos de layout suportados, como ISO, e SQL.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class Message extends ValueObject implements Comparable {
    /**
     * Nome dados ao objeto de mensagem.
     */
    private final String name;

    /**
     * Campos que fazem parte da mensagem.
     */
    protected final String[] fields;

    /**
     * Construtor default do objeto.
     * 
     * @param name
     *            Nome do objeto de mensagem.
     * @param fields
     *            Lista de campos que ser�o trafegados pela mensagem.
     */
    public Message(String name,
            String[] fields) {
        Assertions.requires(name != null);
        Assertions.requires(fields != null);
        this.name = name;
        this.fields = (String[]) Utils.duplicateArray(fields);
    }

    /**
     * M�todo getFields. Retorna a lista de campos que ser�o trafegados pelo
     * objeto.
     * 
     * @return Lista de campos.
     */
    public String[] getFields() {
        return (String[]) Utils.duplicateArray(this.fields);
    }

    /**
     * M�todo getFieldCount. Retorna a quantidade de campos que ser�o trafegados
     * pela mensagem.
     * 
     * @return Quantidade de campos mantidos pelo objeto.
     */
    public int getFieldCount() {
        return this.fields.length;
    }

    /**
     * M�todo getName. Retorna o nome do objeto de mensagem.
     * 
     * @return Nome do objeto de mensagem.
     */
    public String getName() {
    	if (this.name.substring(0, 4).equals("XX63")){
    		return "BG63" + SigcbEstrategia.COD_USUARIO.toUpperCase();
    	}
    	if (this.name.length()<=4){
    		return this.name + SigcbEstrategia.COD_USUARIO.toUpperCase();
    	}
        return this.name;
    }
    
  

    /**
     * M�todo toString. Serializa��o pr�pria do objeto.
     * 
     * @see java.lang.Object#toString()
     * @return Objeto serializado.
     */
    public String toString() {
        final StringBuffer result = new StringBuffer();
        result.append(getName()).append("(");
        result.append(StringUtils.join(this.fields, ", ")).append(")");
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
            final Message other = (Message) obj;
            return equals(getName(), other.getName())
                   && equals(this.fields, other.fields);
        } else {
            return false;
        }
    }

    /**
     * M�todo compareTo. Compara o conte�do do objeto com outro passado como
     * par�metro.
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * @param obj
     *            Objeto para compara��o de conte�do.
     * @return Resultado da compara��o.
     */
    public int compareTo(Object obj) {
        if (super.equals(obj)) {
            final Message other = (Message) obj;
            return getName().compareTo(other.getName());
        } else {
            return +1;
        }
    }

    /**
     * M�todo hashCode.
     * 
     * @see java.lang.Object#hashCode()
     * @return Hashcode do objeto.
     */
    public int hashCode() {
        return getName().hashCode();
    }
}