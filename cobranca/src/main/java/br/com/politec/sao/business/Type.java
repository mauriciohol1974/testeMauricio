package br.com.politec.sao.business;

import java.io.IOException;

import br.com.politec.sao.util.Appender;
import br.com.politec.sao.util.ValueObject;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Classe que inicia a hierarquia de tipos válidos de propriedades na Framework.
 * As classe de tipos suportados pela framework apresentam caracteristicas
 * especiais de comportamento que possibilitam a transição dos dados entre os
 * vários formatos suportados.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class Type extends ValueObject {
    /**
     * Método isValid. Verifica se o objeto passado como parâmetro é válido.
     * Deverá ser implementado nas sub-classes de acordo com as caracteristicas
     * de cada tipo.
     * 
     * @param value
     *            Objeto passado para verificação.
     * @return Resultado da verificação.
     */
    public abstract boolean isValid(Object value);

    /**
     * Método newInstance. Retorna uma nova instância do tipo construída a
     * partir do objeto passado como parâmetro. Deverá ser implementado nas
     * sub-classes de acordo com as caracteristicas de cada tipo.
     * 
     * @param value
     *            Objeto com os valores para instanciação do tipo.
     * @return Objeto instanciado.
     */
    public abstract Object newInstance(Object value);

    /**
     * Método getTypeRealName. Retorna o nome da classe de tipo que está sendo
     * referênciada. Deverá ser implementado nas sub-classes de acordo com as
     * caracteristicas de cada tipo.
     * 
     * @return Nome da classe.
     */
    public abstract String getTypeRealName();

    /**
     * Método getName. Retorna o nome "mapeado" do tipo que está sendo tratado.
     * Deverá ser implementado nas sub-classes de acordo com as caracteristicas
     * de cada tipo.
     * 
     * @return Nome do tipo.
     */
    public abstract String getName();

    /**
     * Método formatOn. Formata a propriedade e adiciona o resultado ao
     * 
     * @see Appender passado como parâmetro. Deverá ser implementado nas
     *      sub-classes de acordo com as caracteristicas de cada tipo.
     * @param out
     *            Appender para concatenção do valor formatado.
     * @param value
     *            Objeto com o valor de propriedade para concatenação.
     * @throws IOException
     *             Caso ocorra algum erro tratável.
     */
    public abstract void formatOn(Appender out, Object value)
            throws IOException;

    /**
     * Método toString. Serializa o objeto segundo regras próprias.
     * 
     * @see java.lang.Object#toString()
     * @return Objeto serializado.
     */
    public String toString() {
        return getName();
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
            final Type other = (Type) obj;
            return equals(getTypeRealName(), other.getTypeRealName());
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
        return getTypeRealName().hashCode();
    }
}