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

public class TitulosPropostaDetalheBean extends SigcbBean {
   
	private java.lang.Long nossoNumero;
	private java.lang.Long codigoCedente;
	private java.lang.String situacao;
	private java.lang.Long pagina;
	private java.lang.String descrSituacao;
	private java.lang.Long numPagina;
	private java.lang.Long numPaginaPagador;
	private java.util.Date dataSituacao;
	private br.com.politec.sao.util.Money valorTitulo;
	private java.lang.String nomeSacado;
	private String cpfCnpj;
	private java.util.Date dtVencimento;
	private String numDocumento;

  

    public TitulosPropostaDetalheBean() {
        this.codigoCedente = null;
        this.cpfCnpj = null;
        this.situacao = null;
        this.dtVencimento = null;
        this.valorTitulo = null;
        this.pagina = null;
        this.nossoNumero = null;
    	this.descrSituacao= null;
    	this.numPagina = null;
    	this.numPaginaPagador=null;
    	this.dataSituacao=null;
    	this.nomeSacado=null;  
    	this.numDocumento=null;
    }

    public String getApplicationName() {
        return "ConGerCedCenBean";
    }

    public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
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

	

	public java.lang.Long getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(java.lang.Long nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public java.lang.String getDescrSituacao() {
		return descrSituacao;
	}

	public void setDescrSituacao(java.lang.String descrSituacao) {
		this.descrSituacao = descrSituacao;
	}

	public java.lang.Long getNumPagina() {
		return numPagina;
	}

	public void setNumPagina(java.lang.Long numPagina) {
		this.numPagina = numPagina;
	}

	public java.lang.Long getNumPaginaPagador() {
		return numPaginaPagador;
	}

	public void setNumPaginaPagador(java.lang.Long numPaginaPagador) {
		this.numPaginaPagador = numPaginaPagador;
	}

	public java.util.Date getDataSituacao() {
		return dataSituacao;
	}
	
	public String getDataSituacaoFormatada(){
	 if (this.dataSituacao != null)
         return Formatador.formatarData(this.dataSituacao);
	 return "";
	}

	public void setDataSituacao(java.util.Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public java.lang.String getNomeSacado() {
		return nomeSacado;
	}

	public void setNomeSacado(java.lang.String nomeSacado) {
		this.nomeSacado = nomeSacado;
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
            TitulosPropostaDetalheBean other = (TitulosPropostaDetalheBean) obj;
            result = result && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result && equals(getPagina(), other.getPagina());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result && equals(getValorTitulo(), other.getValorTitulo());
            result = result && equals(getDtVencimento(), other.getDtVencimento());
            result = result && equals(getDescrSituacao(), other.getDescrSituacao());
            result = result && equals(getNumPagina(), other.getNumPagina());
            result = result && equals(getNumPaginaPagador(), other.getNumPaginaPagador());
            result = result && equals(getDataSituacao(), other.getDataSituacao());        
            result = result && equals(getNomeSacado(), other.getNomeSacado());
            result = result && equals(getNumDocumento(), other.getNumDocumento());
            
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
        properties.add(new Property("nomeSacado", StringType.create(),false, true));
        properties.add(new Property("cpfCnpj", StringType.create(), false, true));
        
        properties.add(new Property("nossoNumero",LongType.create(), false, true));
        properties.add(new Property("pagina",LongType.create(), false, true));
        properties.add(new Property("situacao", StringType.create(), false, true));
        properties.add(new Property("numDocumento", StringType.create(), false, true));
        
        properties.add(new Property("dtVencimento", DateType.create(), false, true));
        properties.add(new Property("valorTitulo",  MoneyType.create(),  false, true));
        properties.add(new Property("descrSituacao", StringType.create(), false, true));
        
        properties.add(new Property("numPagina",LongType.create(), false, true));
        properties.add(new Property("numPaginaPagador",LongType.create(), false, true));
        properties.add(new Property("dataSituacao", DateType.create(), false, true));
        
        Layout result = new Layout(properties,
                "TitulosPropostaDetalheBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        Mainframe.put("pagina", new LongValue("9(04)"));
        
        Mainframe.put("nomeSacado", new StringValue("X(40)"));
        Mainframe.put("situacao", new StringValue("X(01)"));
        Mainframe.put("descrSituacao", new StringValue("X(08)"));
        Mainframe.put("numDocumento", new StringValue("X(15)"));
        Mainframe.put("numPagina", new LongValue("9(04)"));
        Mainframe.put("numPaginaPagador", new LongValue("9(15)"));
        Mainframe.put("dataSituacao", new DateValue("dd/MM/yyyy"));
        
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
