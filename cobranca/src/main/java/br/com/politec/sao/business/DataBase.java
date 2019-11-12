package br.com.politec.sao.business;

import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.ValueObject;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Define um conjunto de dados que representa o mínimo para uma conexão com
 * banco de dados relacional através de <code>JDBC</code> ou
 * <code>DataSource</code>.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class DataBase extends ValueObject {
    /**
     * Nome do usuário para conexão com o banco de dados.
     */
    private final String user;

    /**
     * Senha do usuário para conexão com o banco de dados.
     */
    private final String password;

    /**
     * JNDI para obtenção da conexão com o banco de dados.
     */
    private final String jndiName;

    /**
     * Method DataBase. Construtor default do objeto.
     * 
     * @param user
     *            Usuário de conexão.
     * @param password
     *            Senha de conexão.
     * @param jndiName
     *            JNDI para obtenção da conexão.
     */
    public DataBase(String user,
            String password,
            String jndiName) {
        Assertions.requires(user != null);
        Assertions.requires(password != null);
        Assertions.requires(jndiName != null);
        this.user = user;
        this.password = password;
        this.jndiName = jndiName;
    }

    /**
     * Metodo getUser. Retorna o usuário para conexão com o banco de dados.
     * 
     * @return String Usuário para conexão com o bando de dados.
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Metodo getPassword. Retorna a senha para conexão com o banco de dados.
     * 
     * @return String Senha para conexão com o banco de dados.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Metodo getJndiName. Retorna o JNDI para obtenção da conexão junto ao
     * servidor de aplicações.
     * 
     * @return String Nome JNDI da conexão mantida pelo servidor de aplicações.
     */
    public String getJndiName() {
        return this.jndiName;
    }

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            final DataBase other = (DataBase) obj;
            return equals(getUser(), other.getUser())
                   && equals(getPassword(), other.getPassword())
                   && equals(getJndiName(), other.getJndiName());
        } else {
            return false;
        }
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        int result = 0;
        result ^= getUser().hashCode();
        result ^= getPassword().hashCode();
        result ^= getJndiName().hashCode();
        return result;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        final StringBuffer result = new StringBuffer();
        result.append("{");
        result.append("user => ").append(getUser()).append(", ");
        result.append("password => ").append(getPassword()).append(", ");
        result.append("jndiName => ").append(getJndiName()).append(", ");
        result.append("}");
        return result.toString();
    }
}