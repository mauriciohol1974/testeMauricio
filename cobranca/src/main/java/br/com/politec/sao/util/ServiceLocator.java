package br.com.politec.sao.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJBHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Classe de implementacao do pattern Service Locator, é utilizada para
 * encapsulamento do lookup jndi de EjbHomes e envs
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>26/09/2003</DD>
 * </DL>
 * 
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br
 */

public class ServiceLocator {

    /**
     * contexto inicial da aplicacao
     */
    private InitialContext context = null;

    /**
     * Cache de servicos obtidos via lookup jndi
     */
    private Map services = null;

    /**
     * Instancia unica do service locator
     */
    private static ServiceLocator instance = null;

    static {
        try {
            instance = new ServiceLocator();
        } catch (WrappingException se) {
            if (LogUtilSigcb.isErrorEnabled())
                LogUtilSigcb.error("ServiceLocator: Erro ao tentar criar instancia ServiceLocator.",
                        se);
        }
    }

    /**
     * Construtor privado, impossibilita instanciacao direta
     */
    private ServiceLocator() throws WrappingException {
        try {
            context = new InitialContext();
            services = Collections.synchronizedMap(new HashMap());
            ;
        } catch (NamingException ne) {
            throw new WrappingException(ne);
        } catch (Exception e) {
            throw new WrappingException(e);
        }
    }

    /**
     * Obtem instacia unica do service locator
     * 
     * @return instancia unica do service locator
     */
    public static ServiceLocator getInstance() {
        return instance;
    }

    /**
     * Metodo para obter a interface Ejb dos dados passados como parametro.
     * 
     * @param jndiName:
     *            String contendo o nome a ser utilizado na localizacao jndi
     * @param className:
     *            Classe que implementa a interface Home do EJB desejado
     * @return o EJBHome correspondente ao jndiName
     */
    public EJBHome getEjbHome(String jndiName, Class className)
            throws WrappingException {
        EJBHome home = null;
        try {
            if (services.containsKey(jndiName)) {
                home = (EJBHome) services.get(jndiName);
            } else {
                Object result = context.lookup(jndiName);
                home = (EJBHome) PortableRemoteObject.narrow(result, className);
                services.put(jndiName, home);
            }
        } catch (NamingException ne) {
            throw new WrappingException(ne);
        } catch (Exception e) {
            throw new WrappingException(e);
        }
        return home;
    }

    /**
     * Metodo para obter a string correspondente ao nome "env"
     * 
     * @param envName:
     *            nome da variavel env
     * @return o String correspondente ao envName
     */
    public String getString(String envName) throws WrappingException {
        String env = null;
        try {
            if (services.containsKey(envName)) {
                env = (String) services.get(envName);
            } else {
                env = (String) context.lookup(envName);
            }
        } catch (NamingException ne) {
            throw new WrappingException(ne);
        } catch (Exception e) {
            throw new WrappingException(e);
        }
        return env;
    }
}