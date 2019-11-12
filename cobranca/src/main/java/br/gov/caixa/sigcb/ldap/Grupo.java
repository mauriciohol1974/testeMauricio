package br.gov.caixa.sigcb.ldap;

import java.io.Serializable;

public class Grupo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String cn;
	
	
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
}