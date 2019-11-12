package br.gov.caixa.sigcb.ldap;

import java.io.Serializable;

public class Perfil implements Serializable {

	private static final long serialVersionUID = 7759502419540492455L;
	
	
	private String noUsuario;
	private String coUsuario;
	private String nuUnidade;
	private String noLotacaoFisica;
	private String grupo;
	
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getNoUsuario() {
		return noUsuario;
	}
	public void setNoUsuario(String noUsuario) {
		this.noUsuario = noUsuario;
	}
	public String getCoUsuario() {
		return coUsuario;
	}
	public void setCoUsuario(String coUsuario) {
		this.coUsuario = coUsuario;
	}
	public String getNuUnidade() {
		return nuUnidade;
	}
	public void setNuUnidade(String nuUnidade) {
		this.nuUnidade = nuUnidade;
	}
	public String getNoLotacaoFisica() {
		return noLotacaoFisica;
	}
	public void setNoLotacaoFisica(String noLotacaoFisica) {
		this.noLotacaoFisica = noLotacaoFisica;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
}