package br.gov.caixa.sigcb.bean;

import java.util.Date;

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
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.util.Formatador;

public class IndiceBean extends SigcbBean {
	
	private java.lang.Long passo;
	
	private java.lang.String sigla;
	
	private java.lang.Long nuIndice;
	
	private java.lang.String noIndice;
	
	private java.lang.String noUnidade;
	
	private java.lang.String coPrdce;
	
	private java.lang.String icStco;
	
	private java.lang.String deStco;
	
	private java.lang.String coUserInc;
	
	private java.lang.String tsInc;
	
	private java.lang.String coUserAlt;
	
	private java.lang.String tsAlt;
	
    private Date dataInicio;
    private Date dataFim;
    private Date dataIndice;
    
    private String valor;
	
	
	
	public IndiceBean() {
		
		this.passo=null;
		this.sigla=null;
		this.nuIndice=null;
		this.noIndice=null;
		this.noUnidade=null;
		this.coPrdce=null;
		this.icStco=null;
		this.deStco=null;
		this.coUserInc=null;
		this.tsInc=null;
		this.coUserAlt=null;
		this.tsAlt=null;
		this.dataFim=null;
		this.dataInicio=null;
		
		this.dataIndice=null;
		this.valor=null;
		
		
	}
	


	public Date getDataIndice() {
		return dataIndice;
	}
	
    public java.lang.String getDataIndiceFormatada() {
        if (this.dataIndice != null)
            return Formatador.formatarData(this.dataIndice);
        return "";
    }



	public void setDataIndice(Date dataIndice) {
		this.dataIndice = dataIndice;
	}









	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}


	


	public Date getDataInicio() {
		return dataInicio;
	}



	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}



	public Date getDataFim() {
		return dataFim;
	}



	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}



	public java.lang.Long getPasso() {
		return passo;
	}



	public void setPasso(java.lang.Long passo) {
		this.passo = passo;
	}



	public java.lang.String getSigla() {
		return sigla;
	}



	public void setSigla(java.lang.String sigla) {
		this.sigla = sigla;
	}



	public java.lang.Long getNuIndice() {
		return nuIndice;
	}



	public void setNuIndice(java.lang.Long nuIndice) {
		this.nuIndice = nuIndice;
	}



	public java.lang.String getNoIndice() {
		return noIndice;
	}



	public void setNoIndice(java.lang.String noIndice) {
		this.noIndice = noIndice;
	}



	public java.lang.String getNoUnidade() {
		return noUnidade;
	}



	public void setNoUnidade(java.lang.String noUnidade) {
		this.noUnidade = noUnidade;
	}



	public java.lang.String getCoPrdce() {
		return coPrdce;
	}



	public void setCoPrdce(java.lang.String coPrdce) {
		this.coPrdce = coPrdce;
	}


	public java.lang.String getIcStco() {
		return icStco;
	}



	public void setIcStco(java.lang.String icStco) {
		this.icStco = icStco;
	}



	public java.lang.String getCoUserInc() {
		return coUserInc;
	}



	public void setCoUserInc(java.lang.String coUserInc) {
		this.coUserInc = coUserInc;
	}



	public java.lang.String getTsInc() {
		return tsInc;
	}



	public void setTsInc(java.lang.String tsInc) {
		this.tsInc = tsInc;
	}



	public java.lang.String getCoUserAlt() {
		return coUserAlt;
	}



	public void setCoUserAlt(java.lang.String coUserAlt) {
		this.coUserAlt = coUserAlt;
	}



	public java.lang.String getTsAlt() {
		return tsAlt;
	}



	public void setTsAlt(java.lang.String tsAlt) {
		this.tsAlt = tsAlt;
	}



	public java.lang.String getDeStco() {
		return deStco;
	}



	public void setDeStco(java.lang.String deStco) {
		this.deStco = deStco;
	}



	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            IndiceBean other = (IndiceBean) obj;
            result = result && equals(getPasso(), other.getPasso());
            result = result && equals(getSigla(), other.getSigla());
            result = result && equals(getNuIndice(), other.getNuIndice());
            result = result && equals(getNoIndice(), other.getNoIndice());
            result = result && equals(getNoUnidade(), other.getNoUnidade());
            result = result && equals(getCoPrdce(), other.getCoPrdce());
            result = result && equals(getIcStco(), other.getIcStco());
            result = result && equals(getDeStco(), other.getDeStco());
            result = result && equals(getCoUserInc(), other.getCoUserInc());
            result = result && equals(getTsInc(), other.getTsInc());
            result = result && equals(getCoUserAlt(), other.getCoUserAlt());
            result = result && equals(getTsAlt(), other.getTsAlt());
            result = result && equals(getDataIndice(), other.getDataIndice());
            result = result && equals(getValor(), other.getValor());
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
        properties.add(new Property("passo", LongType.create(), false, true));
        properties.add(new Property("sigla", StringType.create(), false, true));
        properties.add(new Property("nuIndice", LongType.create(), false, true));
        properties.add(new Property("noIndice", StringType.create(), false, true));
        properties.add(new Property("noUnidade", StringType.create(), false, true));
        properties.add(new Property("coPrdce", StringType.create(), false, true));
        properties.add(new Property("icStco", StringType.create(), false, true));
        properties.add(new Property("deStco", StringType.create(), false, true));
        properties.add(new Property("coUserInc", StringType.create(), false, true));
        properties.add(new Property("tsInc", StringType.create(), false, true));
        properties.add(new Property("coUserAlt", StringType.create(), false, true));
        properties.add(new Property("tsAlt", StringType.create(), false, true));
        
        
        
        
        properties.add(new Property("dataInicio",  DateType.create(), false, true));
        properties.add(new Property("dataFim",  DateType.create(), false, true));
        properties.add(new Property("dataIndice",  DateType.create(), false, true));
        properties.add(new Property("valor",   StringType.create(), false, true));
        
        Layout result = new Layout(properties,
                "IndiceBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("passo", new LongValue("9(2)"));
        Mainframe.put("sigla", new StringValue("X(15)"));
        Mainframe.put("nuIndice", new LongValue("9(13)"));
        Mainframe.put("noIndice", new StringValue("X(100)"));
        Mainframe.put("noUnidade", new StringValue("X(15)"));
        Mainframe.put("coPrdce", new StringValue("X(5)"));
        Mainframe.put("icStco", new StringValue("X(1)"));
        Mainframe.put("deStco", new StringValue("X(7)"));
        Mainframe.put("coUserInc", new StringValue("X(8)"));
        Mainframe.put("tsInc", new StringValue("X(26)"));
        Mainframe.put("coUserAlt", new StringValue("X(8)"));
        Mainframe.put("tsAlt", new StringValue("X(26)"));
        Mainframe.put("dataInicio", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataFim", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataIndice", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valor", new StringValue("X(14)"));
        
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