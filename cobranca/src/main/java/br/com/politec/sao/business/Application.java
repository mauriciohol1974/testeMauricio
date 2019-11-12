package br.com.politec.sao.business;

import java.util.HashMap;
import java.util.Map;

import br.com.politec.sao.util.Assertions;
import br.com.politec.sao.util.WrappingException;

/**
 * <B>Projeto: Framework Politec Generic Beans</B><BR>
 * Representa um sistema declarado na cria��o dos objetos de dados para
 * tratamento pela framework.
 * 
 * @author Daniel Yukio Yokomiso - Politec Informatica
 * @version release 1.3
 */
public class Application {
    /**
     * Mant�m uma cole��o de objetos do tipo Application.
     */
    private static final Map instances = new HashMap();

    /**
     * Nome da aplica��o, definido do XML para gera��o dos <code>beans</code>.
     */
    private final String name;

    /**
     * Nome do banco de dados utilizado pela aplica��o, caso esta aplica��o
     * mantenha bases de dados em ambiente de baixa plataforma.
     */
    private DataBase dataBase;

    /**
     * Construtor privado para evitar a instancia��o da classe.
     * 
     * @param name
     *            Nome da aplica��o que est� sendo tratada.
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
     * atrav�s do acinamento de um m�todo est�tico. As inst�ncias s�o mantidas
     * na cole��o, e caso n�o exista uma dispon�vel o m�todo a cria e a adiciona
     * a lista.
     * 
     * @param applicationName
     *            Nome da aplica��o representada pelo objeto.
     * @return Application Inst�ncia que representa a aplica��o.
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
     * Method getDataBase. Retorna a informa��o sobre o banco de dados utilizado
     * pela aplica��o.
     * 
     * @return DataBase Nome da instancia do banco de dados.
     */
    public DataBase getDataBase() {
        return this.dataBase;
    }

    /**
     * Method setDataBase. Atribui a informa��o sobre o banco de dados utilizado
     * pela aplica��o.
     * 
     * @param dataBase
     *            Nome da instancia do banco de dados.
     */
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}