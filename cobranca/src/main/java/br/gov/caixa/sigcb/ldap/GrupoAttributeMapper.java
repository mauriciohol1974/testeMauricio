package br.gov.caixa.sigcb.ldap;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;


public class GrupoAttributeMapper implements AttributesMapper {

	public Object mapFromAttributes(Attributes attributes)
			throws NamingException {

		Grupo grupo = new Grupo();

  		LdapUtil.setProperty(grupo, "cn", attributes, "cn");
//	    LdapUtil.setProperty(grupo, "givenName", attributes, "givenname");
//		LdapUtil.setProperty(grupo, "objectClass", attributes, "objectclass");
//		LdapUtil.setProperty(grupo, "sn", attributes, "sn");
//		LdapUtil.setProperty(grupo, "dn", attributes, "dn");
//		LdapUtil.setProperty(grupo, "creatorsName", attributes, "creatorsname");
//		LdapUtil.setProperty(grupo, "createTimestamp", attributes, "createtimestamp");
//		LdapUtil.setProperty(grupo, "modifiersName", attributes, "modifiersname");
//		LdapUtil.setProperty(grupo, "modifyTimestamp", attributes, "modifytimestamp");	


		return grupo;
	}
}