package br.gov.caixa.sigcb.ldap;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;



import org.apache.commons.beanutils.BeanUtils;



public class LdapUtil {

	public static void setProperty(Object bean, String beanProperty, 
			Attributes attributes, String ldapProperty) throws NamingException {
		
		// Atributo no LDAP
		Attribute attribute = attributes.get(ldapProperty);

		if (attribute != null) {
			// valor do atributo no LDAP
			Object value = attribute.get();
			try {
				BeanUtils.setProperty(bean, beanProperty, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}