package br.com.politec.sao.business;

import java.util.HashMap;
import java.util.Map;

import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Representa um sistema declarado na criação dos objetos de dados para
 * tratamento pela framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class Application {
    /**
     * Mantém uma coleção de objetos do tipo Application.
     */
    private static final Map instances = new HashMap();

    /**
     * Nome da aplicação, definido do XML para geração dos <code>beans</code>.
     */
    private final String name;

    /**
     * Nome do banco de dados utilizado pela aplicação, caso esta aplicação
     * mantenha bases de dados em ambiente de baixa plataforma.
     */
    private DataBase dataBase;

    /**
     * Construtor privado para evitar a instanciação da classe.
     * 
     * @param name
     *            Nome da aplicação que está sendo tratada.
     */
    private Application(String name) {
        Assertions.requires(name != null);
        try {
            this.name = name;
            this.dataBase = null;
        } catch (Exception exc) {
            throw new WrappingException(exc);
        }
    }

    /**
     * Method getInstance. Obtem um instancia de <code>Application</code>
     * através do acinamento de um método estático. As instâncias são mantidas
     * na coleção, e caso não exista uma disponível o método a cria e a adiciona
     * a lista.
     * 
     * @param applicationName
     *            Nome da aplicação representada pelo objeto.
     * @return Application Instância que representa a aplicação.
     */
    public synchronized static Application getInstance(String applicationName) {
        Assertions.requires(applicationName != null,
                "Application name must exist!");
        if (instances.get(applicationName) == null) {
            instances.put(applicationName, new Application(applicationName));
        }
        return (Application) instances.get(applicationName);
    }

    /**
     * Method getDataBase. Retorna a informação sobre o banco de dados utilizado
     * pela aplicação.
     * 
     * @return DataBase Nome da instancia do banco de dados.
     */
    public DataBase getDataBase() {
        return this.dataBase;
    }

    /**
     * Method setDataBase. Atribui a informação sobre o banco de dados utilizado
     * pela aplicação.
     * 
     * @param dataBase
     *            Nome da instancia do banco de dados.
     */
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}