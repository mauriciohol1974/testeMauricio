package br.com.politec.sao.business;

import br.com.politec.sao.util.ValueObject;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Define uma estrutura de chave única valorada para um objeto.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public abstract class Key extends ValueObject implements Comparable {
    /**
     * Variável para obtenção de uma chave nula.
     */
    public static final Key NULL = new Key.Null();

    /**
     * @see java.lang.Object#hashCode()
     */
    public abstract int hashCode();

    /**
     * Method getFields. Retorna os campos que fazem parte da chave.
     * 
     * @return String[] Coleção de campos que compõe a chave.
     */
    public abstract String[] getFields();

    /**
     * @see java.lang.Comparable#compareTo(Object) Compara o parâmetro com a
     *      instância.
     * @return int <code>0</code> se a instância for a mesma ou conter valores
     *         iguais ou <code>+1</code> se for diferente.
     */
    public int compareTo(Object obj) {
        if (this == obj) {
            return 0;
        } else if ((obj instanceof Key) && getClass().equals(obj.getClass())) {
            return 0;
        } else {
            return +1;
        }
    }

    /**
     * <B>Projeto: Framework Politec Generic Beans</B><BR>
     * Innerclass que representa a estrutura de uma chave nula.
     * 
     * @author Daniel Yukio Yokomiso - Politec Informatica
     * @version release 1.3
     */
    private static class Null extends Key {
        /**
         * @see java.lang.Object#hashCode()
         * @return int Hard coded <code>0</code>
         */
        public int hashCode() {
            return 0;
        }

        /**
         * @see java.lang.Object#toString()
         * @return String Hard coded <code>"NULL"</code>
         */
        public String toString() {
            return "NULL";
        }

        /**
         * @see br.com.politec.sao.business.Key#getFields()
         * @return String Hard coded <code>String[0]</code>
         */
        public String[] getFields() {
            return new String[0];
        }
    }
}