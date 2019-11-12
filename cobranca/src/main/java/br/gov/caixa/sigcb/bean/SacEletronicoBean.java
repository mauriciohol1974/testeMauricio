package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.util.Formatador;

public class SacEletronicoBean extends SigcbBean {
	private java.lang.String tipoAcao;
	
	private java.lang.String tipoPessoa;
	
	private java.lang.Long cpfCnpj;
	
	private java.lang.String tipoPessoaAgreg;
	
	private java.lang.Long cpfCnpjAgreg;
	
	private java.lang.String tipoAutoriza;
	
	private java.lang.String usuario;
	
	private java.lang.String codMaquina;
	
	private java.lang.Long codCanal;
	
	private java.lang.Long codRetorno;
	
	private java.lang.Long codDb2;
	
	private java.lang.Long codCics;
	
	private java.lang.String msgRetorno;
	
	private java.lang.Long qtdAgregado;
	
	public SacEletronicoBean() {
		this.codCanal = null;
		this.codCics = null;
		this.codDb2 = null;
		this.codMaquina = null;
		this.codRetorno = null;
		this.cpfCnpj = null;
		this.cpfCnpjAgreg = null;
		this.msgRetorno = null;
		this.tipoAcao = null;
		this.tipoAutoriza = null;
		this.tipoPessoa = null;
		this.tipoPessoaAgreg = null;
		this.usuario = null;
		this.qtdAgregado = null;
		
	}
	
	public String getApplicationName() {
        return "SacEletronicoBean";
    }

	public java.lang.Long getCodCanal() {
		return codCanal;
	}

	public void setCodCanal(java.lang.Long codCanal) {
		this.codCanal = codCanal;
	}

	public java.lang.Long getCodCics() {
		return codCics;
	}

	public void setCodCics(java.lang.Long codCics) {
		this.codCics = codCics;
	}

	public java.lang.Long getCodDb2() {
		return codDb2;
	}

	public void setCodDb2(java.lang.Long codDb2) {
		this.codDb2 = codDb2;
	}

	public java.lang.String getCodMaquina() {
		return codMaquina;
	}

	public void setCodMaquina(java.lang.String codMaquina) {
		this.codMaquina = codMaquina;
	}

	public java.lang.Long getCodRetorno() {
		return codRetorno;
	}

	public void setCodRetorno(java.lang.Long codRetorno) {
		this.codRetorno = codRetorno;
	}

//	 ------------------------formata CpfCnpj----------------------------
	public java.lang.Long getCpfCnpj() {
		return this.cpfCnpj;
	}
	
	public java.lang.String getCpfCnpjFormatado() {
		String cpfCnpjTexto = "";
		if (this.getTipoPessoa().equals("F")) {
			cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj().toString(), 11);
		} else if (this.getTipoPessoa().equals("J")) {
			cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj().toString(), 14);
		}
		cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
		return cpfCnpjTexto;
	}

	public void setCpfCnpj(java.lang.Long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
//	 -----------------------------------------------------------------
	
//	 ------------------------formata CpfCnpjAgregado----------------------------
	public java.lang.Long getCpfCnpjAgreg() {
		return cpfCnpjAgreg;
	}
	
	public java.lang.String getCpfCnpjAgregFormatado () {
		String cpfCnpjAgregTexto = "";
		if (this.getTipoPessoaAgreg().equals("F")) {
			cpfCnpjAgregTexto = Formatacao.formataNumerico(this.getCpfCnpjAgreg().toString(), 11);
		} else if (this.getTipoPessoaAgreg().equals("J")) {
			cpfCnpjAgregTexto = Formatacao.formataNumerico(this.getCpfCnpjAgreg().toString(), 14);
		}
		cpfCnpjAgregTexto = Formatacao.formataCPFCNPJ(cpfCnpjAgregTexto);
		return cpfCnpjAgregTexto;
	}

	public void setCpfCnpjAgreg(java.lang.Long cpfCnpjAgreg) {
		this.cpfCnpjAgreg = cpfCnpjAgreg;
	}
//	 ------------------------formata CpfCnpjAgregado----------------------------
	
	public java.lang.String getMsgRetorno() {
		return msgRetorno;
	}

	public void setMsgRetorno(java.lang.String msgRetorno) {
		this.msgRetorno = msgRetorno;
	}

	public java.lang.String getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(java.lang.String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	public java.lang.String getTipoAutoriza() {
		return tipoAutoriza;
	}

	public void setTipoAutoriza(java.lang.String tipoAutoriza) {
		this.tipoAutoriza = tipoAutoriza;
	}

	public java.lang.String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(java.lang.String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public java.lang.String getTipoPessoaAgreg() {
		return tipoPessoaAgreg;
	}

	public void setTipoPessoaAgreg(java.lang.String tipoPessoaAgreg) {
		this.tipoPessoaAgreg = tipoPessoaAgreg;
	}
	
	//----------------formata tipo pessoa-------------------
	
	public java.lang.String getTipoPessoaTexto() {
        String tipoPessoaTexto = "";

        if (this.getTipoPessoa() != null) {
            if (this.getTipoPessoa().equals("F")) {
                tipoPessoaTexto = "FISICA";
            } else if (this.getTipoPessoa().equals("J")) {
                tipoPessoaTexto = "JURIDICA";
            } else {
                tipoPessoaTexto = "";
            }
        }

        return tipoPessoaTexto;
    }
	
	public java.lang.String getTipoPessoaAgregTexto() {
        String tipoPessoaAgregTexto = "";

        if (this.getTipoPessoaAgreg() != null) {
            if (this.getTipoPessoaAgreg().equals("F")) {
                tipoPessoaAgregTexto = "FISICA";
            } else if (this.getTipoPessoaAgreg().equals("J")) {
                tipoPessoaAgregTexto = "JURIDICA";
            } else {
                tipoPessoaAgregTexto = "";
            }
        }

        return tipoPessoaAgregTexto;
    }
	
	//------------------------------------------------------

	public java.lang.String getUsuario() {
		return usuario;
	}

	public void setUsuario(java.lang.String usuario) {
		this.usuario = usuario;
	}
	
	public java.lang.Long getQtdAgregado() {
		return qtdAgregado;
	}
	
	public void setQtdAgregado(java.lang.Long qtdAgregado) {
		this.qtdAgregado = qtdAgregado;
	}
	
	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            SacEletronicoBean other = (SacEletronicoBean) obj;
            result = result && equals(getCodCanal(), other.getCodCanal());
            result = result && equals(getCodCics(), other.getCodCics());
            result = result && equals(getCodDb2(), other.getCodDb2());
            result = result && equals(getCodMaquina(), other.getCodMaquina());
            result = result && equals(getCodRetorno(), other.getCodRetorno());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getCpfCnpjAgreg(), other.getCpfCnpjAgreg());
            result = result && equals(getMsgRetorno(), other.getMsgRetorno());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result && equals(getTipoAutoriza(), other.getTipoAutoriza());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result && equals(getTipoPessoaAgreg(), other.getTipoPessoaAgreg());
            result = result && equals(getUsuario(), other.getUsuario());
            result = result && equals(getQtdAgregado(), other.getQtdAgregado());
            return result;
        } else {
            return false;
        }
    }
	
	public int hashCode() {
        int result = 0;
        return result;
    }
	
	private static final Layout layout = initLayout();
	
	private static Layout initLayout() {
        java.util.TreeSet properties = new java.util.TreeSet();
        properties.add(new Property("codCanal", LongType.create(), false, true));
        properties.add(new Property("codCics", LongType.create(), false, true));
        properties.add(new Property("codDb2", LongType.create(), false, true));
        properties.add(new Property("codMaquina", StringType.create(), false, true));
        properties.add(new Property("codRetorno", LongType.create(), false, true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("cpfCnpjAgreg", LongType.create(), false, true));
        properties.add(new Property("msgRetorno", StringType.create(), false, true));
        properties.add(new Property("tipoAcao", StringType.create(), false, true));
        properties.add(new Property("tipoAutoriza", StringType.create(), false, true));
        properties.add(new Property("tipoPessoa", StringType.create(), false, true));
        properties.add(new Property("tipoPessoaAgreg", StringType.create(), false, true));
        properties.add(new Property("usuario", StringType.create(), false, true));
        properties.add(new Property("qtdAgregado", LongType.create(), false, true));
        Layout result = new Layout(properties,
                "SacEletronicoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("tipoPessoa", new StringValue("X(01)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("tipoPessoaAgreg", new StringValue("X(01)"));
        Mainframe.put("cpfCnpjAgreg", new LongValue("9(14)"));
        Mainframe.put("tipoAutoriza", new StringValue("X(01)"));
        Mainframe.put("usuario", new StringValue("X(08)"));
        Mainframe.put("codMaquina", new StringValue("X(10)"));
        Mainframe.put("codCanal", new LongValue("9(04)"));
        Mainframe.put("codRetorno", new LongValue("9(02)"));
        Mainframe.put("codDb2", new LongValue("9(04)"));
        Mainframe.put("codCics", new LongValue("9(04)"));
        Mainframe.put("msgRetorno", new StringValue("X(200)"));
        Mainframe.put("qtdAgregado", new LongValue("9(03)"));
        result.addExtension(Mainframe);
        return result;
       
	}
	public Layout getLayout() {
        return layout;
    }
}