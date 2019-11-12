/*
 * Created on 11/08/2004
 *
 */
package br.gov.caixa.sigcb.sirot.transaction;

import java.lang.reflect.Method;

import javax.ejb.EJBHome;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.rmi.PortableRemoteObject;

import org.apache.log4j.Logger;

/**
 * Classe para localizacao de objetos no ambiente JNDI do 
 * servidor de aplicacao.
 * @author Fabio Rafael da Rosa
 */
public class ServiceLocator {
	
	/**
	 * Localizar um objeto do tipo DataSource
	 */
	public static final int DS = 1;

	/**
	 * Localizar um objeto do tipo EJB
	 */
	public static final int EJB = 2;

	/**
	 * Objeto do Contexto de pesquisa inicial.
	 */
	private static InitialContext context = null;
	
	/**
	 * Logger da classe.
	 */
	
	private static Logger logger = Logger.getLogger(ServiceLocator.class);
	/**
	 * Esse metodo retorna um Objeto localizado no ambiente JNDI a partir
	 * do nome fornecido.
	 * @param objName Caminho jdni para o objeto
	 * @param objClass Classe do objeto para o <i>narrow</i>
	 * @return
	 * @throws Exception
	 */
	public static synchronized Object locate(String name, int tipo) throws Exception {

		if (context == null)
			context = new InitialContext();
		
		Object obj = null;
		
		switch (tipo) {
			case DS:
				
				obj = context.lookup(name);
				return obj;
				
			case EJB:
				
				try {
					logger.info("Fazer o lookup:" + name);
					obj = context.lookup(name);
					logger.info("Após o lookup:" + name);
				}catch(NameNotFoundException nameEx){
					try {
						obj = context.lookup(name);
					}catch(NameNotFoundException nameEx2){
						logger.error(nameEx2.getLocalizedMessage());
						System.out.println(nameEx2.getLocalizedMessage());
						throw new Exception("Componente " + name + " nao encontrado!" + nameEx + "-" + nameEx2 );
					}
					
				}
				
				
				return obj;
				
			default:
				throw new Exception("Tipo de objeto desconhecido!");
		}
	}
}