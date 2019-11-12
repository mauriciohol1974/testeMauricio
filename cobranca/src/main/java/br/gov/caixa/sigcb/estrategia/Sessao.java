package br.gov.caixa.sigcb.estrategia;

import br.gov.caixa.sigcb.bean.UsuLogadoBean;

public class Sessao {
	private static Sessao sessao;
	private UsuLogadoBean usuarios;
	private Sessao(){}
	public static synchronized Sessao getInstancia(UsuLogadoBean user) {
		sessao = new Sessao();
		sessao.setUsuarios(user);;
		return sessao;
	}
	
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	public UsuLogadoBean getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(UsuLogadoBean usuarios) {
		this.usuarios = usuarios;
	}
	public static Sessao getSessao() {
		return sessao;
	}
	public static void setSessao(Sessao sessao) {
		Sessao.sessao = sessao;
	}
	
	
	
	
	
}