package br.gov.caixa.sigcb.ldap;


public class LDAPConnector 
{
	
	public Perfil getUsuario( String user, String senha )
	{

		AcessoLdap acessoLdap = new AcessoLdap();
		Perfil perfil = acessoLdap.consultarPerfil(user);
			

		return perfil;

	}

}