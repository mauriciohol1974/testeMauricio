package br.gov.caixa.sigcb.ldap;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;


public class PerfilAttributeMapper implements AttributesMapper {

	public Object mapFromAttributes(Attributes attributes)
			throws NamingException {

		Perfil perfil = new Perfil();

  		LdapUtil.setProperty(perfil, "uid", attributes, "uid");
		LdapUtil.setProperty(perfil, "username", attributes, "uid");
		LdapUtil.setProperty(perfil, "noUsuario", attributes, "cn");
		LdapUtil.setProperty(perfil, "coCargo", attributes, "CO-CARGO");
		LdapUtil.setProperty(perfil, "noCargo", attributes, "NO-CARGO");
		LdapUtil.setProperty(perfil, "coFuncao", attributes, "NU-FUNCAO");
		LdapUtil.setProperty(perfil, "noFuncao", attributes, "NO-FUNCAO");
		LdapUtil.setProperty(perfil, "nuUnidade", attributes, "CO-UNIDADE");
		LdapUtil.setProperty(perfil, "noUnidade", attributes, "NO-UNIDADE");
		LdapUtil.setProperty(perfil, "nuCpf", attributes, "NU-CPF");
		LdapUtil.setProperty(perfil, "noEmpresa", attributes, "NO-EMPRESA");
		LdapUtil.setProperty(perfil, "nuCnpj", attributes, "NU-CNPJ");
		LdapUtil.setProperty(perfil, "nuUnidadeSub", attributes, "NU-UNIDADE-SUB");
		LdapUtil.setProperty(perfil, "noUsuario", attributes, "NO-USUARIO");
		LdapUtil.setProperty(perfil, "coUsuario", attributes, "CO-USUARIO");
		LdapUtil.setProperty(perfil, "description", attributes, "DESCRIPTION");
		LdapUtil.setProperty(perfil, "facSimileTelephoneNumber", attributes, "FACSIMILETELEPHONENUMBER");
		LdapUtil.setProperty(perfil, "mail", attributes, "MAIL");
		LdapUtil.setProperty(perfil, "mobile", attributes, "MOBILE");
		LdapUtil.setProperty(perfil, "pager", attributes, "PAGER");
		LdapUtil.setProperty(perfil, "physicalDeliveryOfficeName", attributes, "PHYSICALDELIVERYOFFICENAME");
		LdapUtil.setProperty(perfil, "postalCode", attributes, "POSTALCODE");
		LdapUtil.setProperty(perfil, "st", attributes, "ST");
		LdapUtil.setProperty(perfil, "street", attributes, "STREET");
		LdapUtil.setProperty(perfil, "telephoneNumber", attributes, "TELEPHONENUMBER");
		LdapUtil.setProperty(perfil, "title", attributes, "TITLE");
		LdapUtil.setProperty(perfil, "dtNascimento", attributes, "DT-NASCIMENTO");
		LdapUtil.setProperty(perfil, "nuLotacaoFisica", attributes, "NU-LOTACAOFISICA");
		LdapUtil.setProperty(perfil, "noLotacaoFisica", attributes, "NO-LOTACAOFISICA");
		LdapUtil.setProperty(perfil, "ufLotacaoFisica", attributes, "UF-LOTACAOFISICA");
		LdapUtil.setProperty(perfil, "sgUnidade", attributes, "sg-unidade");
		LdapUtil.setProperty(perfil, "sgLotacaoFisica", attributes, "sg-lotacaofisica");
		LdapUtil.setProperty(perfil, "nuTpUnidade", attributes, "nu-tp-unidade");
		LdapUtil.setProperty(perfil, "userPassword", attributes, "userpassword");
		LdapUtil.setProperty(perfil, "givenName", attributes, "givenname");
		LdapUtil.setProperty(perfil, "objectClass", attributes, "objectclass");
		LdapUtil.setProperty(perfil, "sn", attributes, "sn");
		LdapUtil.setProperty(perfil, "dn", attributes, "dn");
		LdapUtil.setProperty(perfil, "creatorsName", attributes, "creatorsname");
		LdapUtil.setProperty(perfil, "createTimestamp", attributes, "createtimestamp");
		LdapUtil.setProperty(perfil, "modifiersName", attributes, "modifiersname");
		LdapUtil.setProperty(perfil, "modifyTimestamp", attributes, "modifytimestamp");	

		return perfil;
	}
}