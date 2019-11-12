//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.DateType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.DateValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.util.Formatador;

public class TitulosPropostaBean extends SigcbBean {
    private java.lang.Long codigoCedente;
    private java.lang.String nomeFantasia;
    private java.lang.Long unidade;
    private String cpfCnpj;
    private java.lang.String situacao;
    private java.util.Date dtVencimento;
    private br.com.politec.sao.util.Money valorTitulo;
    private java.lang.Long pagina;
    private java.lang.Long totalRegistros;
    private java.lang.Long nossoNumero;
    private String descrSituacao;

    public TitulosPropostaBean() {
        this.codigoCedente = null;
        this.nomeFantasia = null;
        this.unidade = null;
        this.cpfCnpj = null;
        this.situacao = null;
        this.dtVencimento = null;
        this.valorTitulo = null;
        this.pagina = null;
        this.totalRegistros = null;
        this.nossoNumero = null;
        this.descrSituacao = null;
        
      
    }

    
    
    
    public String getApplicationName() {
        return "ConGerCedCenBean";
    }
    
    

    public String getDescrSituacao() {
		return descrSituacao;
	}




	public void setDescrSituacao(String descrSituacao) {
		this.descrSituacao = descrSituacao;
	}




	public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

      public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

  

	public java.lang.Long getUnidade() {
		return unidade;
	}

	public void setUnidade(java.lang.Long unidade) {
		this.unidade = unidade;
	}

	
	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	


	public java.lang.String getSituacao() {
		return situacao;
	}

	public void setSituacao(java.lang.String situacao) {
		this.situacao = situacao;
	}

	public java.util.Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(java.util.Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public br.com.politec.sao.util.Money getValorTitulo() {
		return valorTitulo;
	}

	public void setValorTitulo(br.com.politec.sao.util.Money valorTitulo) {
		this.valorTitulo = valorTitulo;
	}

	public java.lang.Long getPagina() {
		return pagina;
	}

	public void setPagina(java.lang.Long pagina) {
		this.pagina = pagina;
	}

	public java.lang.Long getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(java.lang.Long totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	public java.lang.Long getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(java.lang.Long nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	// ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    
    public java.lang.String getNossoNumeroFormatado() {
        String nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumero);
        return nossoNumeroFormatado;
    }
    
    public java.lang.String getDtVencimentoFormatada() {
        if (this.dtVencimento != null)
            return Formatador.formatarData(this.dtVencimento);
        return "";
    }
   


	// fim-------------getCodigoCedenteFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            TitulosPropostaBean other = (TitulosPropostaBean) obj;
            result = result && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result && equals(getUnidade(), other.getUnidade());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result && equals(getPagina(), other.getPagina());
            result = result && equals(getTotalRegistros(), other.getTotalRegistros());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result && equals(getValorTitulo(), other.getValorTitulo());
            result = result && equals(getDtVencimento(), other.getDtVencimento());
            result = result && equals(getDescrSituacao(), other.getDescrSituacao());
            
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
        properties.add(new Property("codigoCedente",LongType.create(), false, true));
        properties.add(new Property("nomeFantasia", StringType.create(),false, true));
        properties.add(new Property("cpfCnpj", StringType.create(), false, true));
        properties.add(new Property("nossoNumero",LongType.create(), false, true));
        properties.add(new Property("pagina",LongType.create(), false, true));
        properties.add(new Property("situacao", StringType.create(), false, true));
        properties.add(new Property("totalRegistros",LongType.create(), false, true));
        properties.add(new Property("dtVencimento", DateType.create(), false, true));
        properties.add(new Property("valorTitulo",  MoneyType.create(),  false, true));
        
        properties.add(new Property("descrSituacao", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "TitulosPropostaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        Mainframe.put("pagina", new LongValue("9(04)"));
        Mainframe.put("totalRegistros", new LongValue("9(06)"));
        Mainframe.put("nomeFantasia", new StringValue("X(30)"));
        Mainframe.put("situacao", new StringValue("X(01)"));
        Mainframe.put("descrSituacao", new StringValue("X(08)"));
        Mainframe.put("cpfCnpj", new StringValue("X(18)"));
        Mainframe.put("valorTitulo", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("dtVencimento", new DateValue("dd/MM/yyyy"));
        
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
