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
import br.gov.caixa.sigcb.util.Formatador;

public class LiquidacaoOnlineBean extends SigcbBean {
	
    private java.lang.String apelidoCedente;
    private java.lang.Long codigoCedente;
    private java.lang.Long codigoUnidadePV;
    private java.util.Date dataFinal;
    private java.util.Date dataInicial;
    private java.lang.String tipoAcao;
    
    private Long nossoNumero;
    private Long nossoNumeroLiq;
    private java.util.Date dataPagamento;
    private java.util.Date liquiDataPagamento;
    private br.com.politec.sao.util.Money vrPagamento;
    private br.com.politec.sao.util.Money liquiValorDocumento;
    private String meioPgto;
    private String meioEntrada;
    private String codMeioEntrada;
    
    
    

    public LiquidacaoOnlineBean() {
        this.apelidoCedente = null;
        this.codigoCedente = null;
        this.codigoUnidadePV = null;
        this.dataFinal = null;
        this.dataInicial = null;
        this.tipoAcao = null;
        this.nossoNumero=null;
        this.dataPagamento=null;
        this.vrPagamento=null;
        this.meioPgto=null;
        this.nossoNumeroLiq=null;
        this.liquiDataPagamento=null;
        this.liquiValorDocumento=null;
        this.meioEntrada=null;
        this.codMeioEntrada=null;
       
    }

   

	public String getCodMeioEntrada() {
		return codMeioEntrada;
	}



	public void setCodMeioEntrada(String codMeioEntrada) {
		this.codMeioEntrada = codMeioEntrada;
	}



	public java.util.Date getLiquiDataPagamento() {
		return liquiDataPagamento;
	}



	public void setLiquiDataPagamento(java.util.Date liquiDataPagamento) {
		this.liquiDataPagamento = liquiDataPagamento;
	}



	public br.com.politec.sao.util.Money getLiquiValorDocumento() {
		return liquiValorDocumento;
	}



	public void setLiquiValorDocumento(
			br.com.politec.sao.util.Money liquiValorDocumento) {
		this.liquiValorDocumento = liquiValorDocumento;
	}



	public String getMeioEntrada() {
		return meioEntrada;
	}



	public void setMeioEntrada(String meioEntrada) {
		this.meioEntrada = meioEntrada;
	}



	



	public Long getNossoNumero() {
		return nossoNumero;
	}



	public void setNossoNumero(Long nossoNumero) {
		this.nossoNumero = nossoNumero;
	}



	public Long getNossoNumeroLiq() {
		return nossoNumeroLiq;
	}



	public void setNossoNumeroLiq(Long nossoNumeroLiq) {
		this.nossoNumeroLiq = nossoNumeroLiq;
	}



	public java.util.Date getDataPagamento() {
		return dataPagamento;
	}



	public void setDataPagamento(java.util.Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}



	public br.com.politec.sao.util.Money getVrPagamento() {
		return vrPagamento;
	}



	public void setVrPagamento(br.com.politec.sao.util.Money vrPagamento) {
		this.vrPagamento = vrPagamento;
	}



	public String getMeioPgto() {
		return meioPgto;
	}



	public void setMeioPgto(String meioPgto) {
		this.meioPgto = meioPgto;
	}



	public java.lang.String getApelidoCedente() {
		return apelidoCedente;
	}



	public void setApelidoCedente(java.lang.String apelidoCedente) {
		this.apelidoCedente = apelidoCedente;
	}



	public java.lang.Long getCodigoCedente() {
		return codigoCedente;
	}



	public void setCodigoCedente(java.lang.Long codigoCedente) {
		this.codigoCedente = codigoCedente;
	}



	public java.lang.Long getCodigoUnidadePV() {
		return codigoUnidadePV;
	}



	public void setCodigoUnidadePV(java.lang.Long codigoUnidadePV) {
		this.codigoUnidadePV = codigoUnidadePV;
	}



	public java.util.Date getDataFinal() {
		return dataFinal;
	}



	public void setDataFinal(java.util.Date dataFinal) {
		this.dataFinal = dataFinal;
	}



	public java.util.Date getDataInicial() {
		return dataInicial;
	}



	public void setDataInicial(java.util.Date dataInicial) {
		this.dataInicial = dataInicial;
	}



	public java.lang.String getTipoAcao() {
		return tipoAcao;
	}



	public void setTipoAcao(java.lang.String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}



	// ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadePVFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePV);
        return codigoUnidadeFormatado;
    }
    
    public java.lang.String getDataInicialFormatada() {
        if (this.dataInicial != null)
            return Formatador.formatarData(this.dataInicial);
        return "";
    }
    
    public java.lang.String getDataFinalFormatada() {
        if (this.dataFinal != null)
            return Formatador.formatarData(this.dataFinal);
        return "";
    }
    
    public java.lang.String getDataPagamentolFormatada() {
        if (this.dataPagamento != null)
            return Formatador.formatarData(this.dataPagamento);
        return "";
    }
    

    // fim-------------getCodigoUnidadeFormatado---------------------

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            LiquidacaoOnlineBean other = (LiquidacaoOnlineBean) obj;
            result = result && equals(getApelidoCedente(), other.getApelidoCedente());
            result = result && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getCodigoUnidadePV(), other.getCodigoUnidadePV());
            result = result && equals(getDataFinal(), other.getDataFinal());
            result = result && equals(getDataInicial(), other.getDataInicial());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result && equals(getNossoNumeroLiq(), other.getNossoNumeroLiq());
            result = result && equals(getDataPagamento(), other.getDataPagamento());
            result = result && equals(getVrPagamento(), other.getVrPagamento());
            result = result && equals(getMeioPgto(), other.getMeioPgto());
            
            result = result && equals(getLiquiDataPagamento(), other.getLiquiDataPagamento());
            result = result && equals(getLiquiValorDocumento(), other.getLiquiValorDocumento());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result && equals(getCodMeioEntrada(), other.getCodMeioEntrada());
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
        properties.add(new Property("apelidoCedente", StringType.create(), false,  true));
        properties.add(new Property("codigoCedente", LongType.create(), false, true));
        properties.add(new Property("codigoUnidadePV", LongType.create(), false, true));
        properties.add(new Property("dataFinal", DateType.create(), false, true));
        properties.add(new Property("dataInicial", DateType.create(), false, true));
        properties.add(new Property("tipoAcao", StringType.create(),false,  true));
        
        properties.add(new Property("nossoNumero", LongType.create(),false,  true));
        properties.add(new Property("nossoNumeroLiq", LongType.create(),false,  true));
        properties.add(new Property("dataPagamento", DateType.create(),false,  true));
        properties.add(new Property("liquiDataPagamento", DateType.create(),false,  true));
        properties.add(new Property("vrPagamento", MoneyType.create(),false,  true));
        properties.add(new Property("liquiValorDocumento", MoneyType.create(),false,  true));
        properties.add(new Property("meioPgto", StringType.create(),false,  true));
        properties.add(new Property("meioEntrada", StringType.create(),false,  true));
        properties.add(new Property("codMeioEntrada", StringType.create(),false,  true));
        
        Layout result = new Layout(properties,"LiquidacaoOnlineBean", "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("apelidoCedente", new StringValue("X(06)"));
        Mainframe.put("codigoUnidadePV", new LongValue("9(04)"));
        Mainframe.put("dataInicial", new DateValue("dd/MM/yyyy"));
        Mainframe.put("dataFinal", new DateValue("dd/MM/yyyy"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        Mainframe.put("nossoNumeroLiq", new LongValue("9(18)"));
        Mainframe.put("dataPagamento", new DateValue("dd/MM/yyyy"));
        Mainframe.put("liquiDataPagamento", new DateValue("dd/MM/yyyy"));
        Mainframe.put("vrPagamento",new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("liquiValorDocumento",new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("meioPgto",new StringValue("X(20)"));
        Mainframe.put("meioEntrada",new StringValue("X(02)"));
        Mainframe.put("codMeioEntrada",new StringValue("X(02)"));
        
        
        
       
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }



	@Override
	public String getApplicationName() {
		// TODO Auto-generated method stub
		return null;
	}
}
