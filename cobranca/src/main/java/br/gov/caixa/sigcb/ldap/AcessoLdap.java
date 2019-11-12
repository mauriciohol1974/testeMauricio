package br.gov.caixa.sigcb.ldap;

/**
 *
 * Mapeamento da estrutura hierarquica no LDAP da Caixa:
 *
 * o=caixa
 * |
 * +-- ou=Groups
 * |   |
 * |   +-- cn= < sistema-1 >
 * |   |   |
 * |   |   +-- cn= < grupo-1a >
 * |   |   |
 * |   |   +-- cn= < grupo-1b >
 * |   |
 * |   +-- cn= < sistema-2 >
 * |       |
 * |       +-- cn= < grupo-2a >
 * |
 * +-- ou=People
 *     |
 *     +-- uid= < user-1 >
 *     |
 *     +-- uid= < user-2 >
 *     |
 *     +-- uid= < user-3 >
 *
 * 
 * 
 * Configuração do login-config.xml (JBoss):
 * 
 * 	<application-policy name="realmOpenLdap"> 
 *		<authentication> 
 *			<login-module code="org.jboss.security.auth.spi.LdapLoginModule" flag="required"> 
 *				<module-option name="java.naming.factory.initial">com.sun.jndi.ldap.LdapCtxFactory</module-option> 
 *				<module-option name="java.naming.provider.url">ldap://192.168.91.128:389</module-option> 
 *				<module-option name="java.naming.security.authentication">simple</module-option> 
 *				<module-option name="principalDNSuffix">,ou=people,o=caixa</module-option> 
 *				<module-option name="principalDNPrefix">uid=</module-option> 
 *				<module-option name="rolesCtxDN">cn=SIWIN,ou=Groups,o=caixa</module-option> 
 *				<module-option name="roleAttributeID">cn</module-option> 
 *				<module-option name="roleAttributeIsDN">false</module-option>
 *				<module-option name="uidAttributeID">uniqueMember</module-option> 
 *				<module-option name="matchOnUserDN">true</module-option>  
 *			</login-module> 
 *		</authentication>
 *	</application-policy>
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.apache.log4j.Logger;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.pool.factory.PoolingContextSource;


public class AcessoLdap {

	public static int ANONYMOUS_USER = 1;
	public static int CURRENT_USER = 2;
	public static int ADMIN_USER = 3;
	public static int CONSULTA_PERFIL = 1;
	public static int CONSULTA_GRUPOS = 0;

	
	private static Logger log = Logger.getLogger(AcessoLdap.class);
	
	private String objectclass = "cefusuario";
	private LdapTemplate ldapTemplate;

	
	public AcessoLdap() {
		// carrega as propriedades
		Properties properties = new Properties();
		/*try {
			properties.load(getResourceAsStream(this, "br/gov/caixa/sivba/ldap/ldap.properties"));
			if (log.isInfoEnabled()) {
				for (Entry<Object, Object> entry : properties.entrySet()) {
					log.info(entry.getKey() + "=[" + entry.getValue() + "]");
				}
			}
		} catch (IOException e) {
			log.fatal(e);
		}*/

		LdapContextSource contextSource = new LdapContextSource();
		contextSource.setUrl("ldap://ldap.01:489");
		contextSource.setBase("o=caixa");

		log.info("Consulta utilizando usuario anônimo");
			// acesso de leitura para usuario anonimo
			contextSource.setAnonymousReadOnly(true);
	
		// pool de conexoes
		PoolingContextSource poolingContextSource = new PoolingContextSource();
		poolingContextSource.setContextSource(contextSource);

		// conecta
        try {
        	contextSource.afterPropertiesSet();
        } catch (Exception e) {
            log.fatal("Erro ao conectar", e);
        }

		ldapTemplate = new LdapTemplate(poolingContextSource);
	}

	@SuppressWarnings("unchecked")
	public Perfil consultarPerfil(String username) {
		try{
			Perfil perfil = getPerfil(username);
			Grupo grupo = getGrupo(username);
			perfil.setGrupo(grupo.getCn());
			return perfil;
		}catch (Exception e){
			return null;
		}
		

	}

	public Perfil getPerfil(String username) {
		try{
		//username = "c897002";	
		log.info("---- inicio pesquisa perfil  ----");
		String filterUser = "(&(objectclass=" + objectclass + ")(uid="+ username + "))";
		
		List list = ldapTemplate.search("ou=People", filterUser.toString(),2,
				          
							new String[] { "no-usuario","co-usuario","co-unidade" },
				new AttributesMapper() {
					public Object mapFromAttributes(Attributes attrs)
							throws NamingException {
						log.info(attrs);
						Perfil p = new Perfil();
						
						String nome = (String)attrs.get("no-usuario").get()==null?"":(String)attrs.get("no-usuario").get();
						String codigo = (String) attrs.get("co-usuario").get()==null?"":(String) attrs.get("co-usuario").get();
						String unidade = (String) attrs.get("co-unidade").get()==null?"":(String) attrs.get("co-unidade").get();
			
						
						p.setNoUsuario(nome);
						p.setCoUsuario(codigo);
						p.setNuUnidade(unidade);

						return p;
					}
				});
		log.info("---- fim pesquisa perfil  ----");
		return (list != null && list.size() > 0) ? (Perfil) list.get(0) : null;
		}catch (Exception e){
			return null;
		}
		
	}

	// Consulta grupo de um determinado usuário
	public Grupo getGrupo(String username) {
		//username = "c897002";
		String cnStr = "";
		log.info("---- inicio pesquisa por grupo ----");
		
		String filterUser = "(&(uniquemember=uid=" + username+ ",ou=People,o=caixa)" + "(objectclass=groupofuniquenames))";
		
		log.info(filterUser);
		
		List list = ldapTemplate.search("cn=sigcb,ou=Groups", filterUser, 1,new String[] { "cn" }, new GrupoAttributeMapper() {
			
					public Object mapFromAttributes(Attributes  attrs) throws NamingException {
						
						log.info(attrs);
						
						String group = (String) attrs.get("cn").get();
						
						log.info(group);
						
						Grupo grupo = new Grupo();
						
						grupo.setCn(group);
						
						return grupo;
					}
				});
		log.info("---- fim pesquisa por grupo ----");
		if (list != null && list.size() > 0){
			for (int i=0;i<list.size();i++){
				Grupo grupo = new Grupo();
				grupo = (Grupo) list.get(i);
				log.info(grupo.getCn());
			}
			
			log.info("RET GRUPO:"+ (Grupo) list.get(0));
			return (Grupo) list.get(0);
		}else{
			log.info("Lista Vazia");
			return null;
		}
		
		
	}
	
	
	public static final InputStream getResourceAsStream(Object caller, String file) {
		InputStream stream = null;
		
		if (caller != null) {
			stream = caller.getClass().getClassLoader().getResourceAsStream(file);
		}

		if (stream == null) {
			stream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(file);
		}

		if (stream == null) {
			try {
				stream = new FileInputStream(file);
			} catch (FileNotFoundException e) {

			}
		}

		if (stream == null) {
			try {
				stream = new FileInputStream(new File(file));
			} catch (FileNotFoundException e) {
				log.fatal("Arquivo nao encontrado: " + file, e);
			}
		}

		return stream;
	}	
}