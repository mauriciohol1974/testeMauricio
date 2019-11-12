package br.com.politec.sao.business;

import java.io.IOException;

import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.ValueObject;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que inicia a hierarquia de tipos v�lidos de propriedades na Framework.
 * As classe de tipos suportados pela framework apresentam caracteristicas
 * especiais de comportamento que possibilitam a transi��o dos dados entre os
 * v�rios formatos suportados.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class Type extends ValueObject {
    /**
     * M�todo isValid. Verifica se o objeto passado como par�metro � v�lido.
     * Dever� ser implementado nas sub-classes de acordo com as caracteristicas
     * de cada tipo.
     * 
     * @param value
     *            Objeto passado para verifica��o.
     * @return Resultado da verifica��o.
     */
    public abstract boolean isValid(Object value);

    /**
     * M�todo newInstance. Retorna uma nova inst�ncia do tipo constru�da a
     * partir do objeto passado como par�metro. Dever� ser implementado nas
     * sub-classes de acordo com as caracteristicas de cada tipo.
     * 
     * @param value
     *            Objeto com os valores para instancia��o do tipo.
     * @return Objeto instanciado.
     */
    public abstract Object newInstance(Object value);

    /**
     * M�todo getTypeRealName. Retorna o nome da classe de tipo que est� sendo
     * refer�nciada. Dever� ser implementado nas sub-classes de acordo com as
     * caracteristicas de cada tipo.
     * 
     * @return Nome da classe.
     */
    public abstract String getTypeRealName();

    /**
     * M�todo getName. Retorna o nome "mapeado" do tipo que est� sendo tratado.
     * Dever� ser implementado nas sub-classes de acordo com as caracteristicas
     * de cada tipo.
     * 
     * @return Nome do tipo.
     */
    public abstract String getName();

    /**
     * M�todo formatOn. Formata a propriedade e adiciona o resultado ao
     * 
     * @see Appender passado como par�metro. Dever� ser implementado nas
     *      sub-classes de acordo com as caracteristicas de cada tipo.
     * @param out
     *            Appender para concaten��o do valor formatado.
     * @param value
     *            Objeto com o valor de propriedade para concatena��o.
     * @throws IOException
     *             Caso ocorra algum erro trat�vel.
     */
    public abstract void formatOn(Appender out, Object value)
            throws IOException;

    /**
     * M�todo toString. Serializa o objeto segundo regras pr�prias.
     * 
     * @see java.lang.Object#toString()
     * @return Objeto serializado.
     */
    public String toString() {
        return getName();
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
            final Type other = (Type) obj;
            return equals(getTypeRealName(), other.getTypeRealName());
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
        return getTypeRealName().hashCode();
    }
}