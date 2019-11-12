package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.Util;

public class TarifaSimulaBean extends SigcbBean {
   
    private String coTarifa;

    private java.lang.String vrTarifa;

    private java.lang.String percTarifa;
    
    private br.com.politec.sao.util.Money valorPad;
    private br.com.politec.sao.util.Money percPad;
    private br.com.politec.sao.util.Money valorNeg;
    private br.com.politec.sao.util.Money percNeg;
    private br.com.politec.sao.util.Money valorAtu;
    private br.com.politec.sao.util.Money percAtu;
    
    private Long  	nu_simulacao;
    private Long 	coCedente;
    private String 	icPessoa;
    private Long  	cnpj;
    private Long 	cocli;
    private String 	passo;
    private Long  	unidadeAutorizador;
    private Long 	nuServico;
    private String deServico;

 
    public TarifaSimulaBean() {
        this.coTarifa = null;
        this.vrTarifa = null;
        this.percTarifa = null;
        this.nu_simulacao=null;
        this.coCedente=null;
        this.icPessoa=null;
        this.cnpj=null;
        this.cocli=null;
        this.passo=null;
        this.unidadeAutorizador=null;
        this.valorPad=null;
        this.percPad=null;
        this.valorNeg=null;
        this.percNeg=null;
        this.valorAtu=null;
        this.percAtu=null;
        this.nuServico=null;
        this.deServico=null;
        
      
    }

    public String getApplicationName() {
        return "TarifaSimulaBean";
    }

  
	public Long getNuServico() {
		return nuServico;
	}

	public void setNuServico(Long nuServico) {
		this.nuServico = nuServico;
	}

	public br.com.politec.sao.util.Money getValorPad() {
		return valorPad;
	}

	public void setValorPad(br.com.politec.sao.util.Money valorPad) {
		this.valorPad = valorPad;
	}

	public br.com.politec.sao.util.Money getPercPad() {
		return percPad;
	}

	public void setPercPad(br.com.politec.sao.util.Money percPad) {
		this.percPad = percPad;
	}

	public br.com.politec.sao.util.Money getValorNeg() {
		return valorNeg;
	}

	public void setValorNeg(br.com.politec.sao.util.Money valorNeg) {
		this.valorNeg = valorNeg;
	}

	public br.com.politec.sao.util.Money getPercNeg() {
		return percNeg;
	}

	public void setPercNeg(br.com.politec.sao.util.Money percNeg) {
		this.percNeg = percNeg;
	}

	public br.com.politec.sao.util.Money getValorAtu() {
		return valorAtu;
	}

	public void setValorAtu(br.com.politec.sao.util.Money valorAtu) {
		this.valorAtu = valorAtu;
	}

	public br.com.politec.sao.util.Money getPercAtu() {
		return percAtu;
	}

	public void setPercAtu(br.com.politec.sao.util.Money percAtu) {
		this.percAtu = percAtu;
	}

	public Long getNu_simulacao() {
		return nu_simulacao;
	}

	public void setNu_simulacao(Long nu_simulacao) {
		this.nu_simulacao = nu_simulacao;
	}

	public Long getCoCedente() {
		return coCedente;
	}

	public void setCoCedente(Long coCedente) {
		this.coCedente = coCedente;
	}

	public String getIcPessoa() {
		return icPessoa;
	}

	public void setIcPessoa(String icPessoa) {
		this.icPessoa = icPessoa;
	}



	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Long getCocli() {
		return cocli;
	}

	public void setCocli(Long cocli) {
		this.cocli = cocli;
	}

	public String getPasso() {
		return passo;
	}

	public void setPasso(String passo) {
		this.passo = passo;
	}

	public Long getUnidadeAutorizador() {
		return unidadeAutorizador;
	}

	public void setUnidadeAutorizador(Long unidadeAutorizador) {
		this.unidadeAutorizador = unidadeAutorizador;
	}

	public String getCoTarifa() {
		return coTarifa;
	}

	public void setCoTarifa(String coTarifa) {
		this.coTarifa = coTarifa;
	}

	public java.lang.String getVrTarifa() {
		return vrTarifa;
	}
	
	public  br.com.politec.sao.util.Money getVrTarifaFormatado(){
		
		Double valDouble = Double.parseDouble(this.vrTarifa);
		
		Money vrFormatado = new Money(valDouble.toString(),
                 2,
                 Currency.real());
		
		return vrFormatado;
	}

	public void setVrTarifa(java.lang.String vrTarifa) {
		this.vrTarifa = vrTarifa;
	}

	public  br.com.politec.sao.util.Money getPercTarifaFormatado(){
		
		Double valDouble = Double.parseDouble(this.percTarifa);
		
		Money vrFormatado = new Money(valDouble.toString(),
                 2,
                 Currency.real());
		
		return vrFormatado;
	}
	
	public java.lang.String getPercTarifa() {
		return percTarifa;
	}

	public void setPercTarifa(java.lang.String percTarifa) {
		this.percTarifa = percTarifa;
	}

	public String getDeServico() {
		return deServico;
	}

	public void setDeServico(String deServico) {
		this.deServico = deServico;
	}

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            TarifaSimulaBean other = (TarifaSimulaBean) obj;
            result = result && equals(getCoTarifa(), other.getCoTarifa());
            result = result && equals(getVrTarifa(), other.getVrTarifa());
            result = result && equals(getPercTarifa(), other.getPercTarifa());

            result = result && equals(getNu_simulacao(), other.getNu_simulacao());
            result = result && equals(getCoCedente(), other.getCoCedente());
            result = result && equals(getIcPessoa(), other.getIcPessoa());
            result = result && equals(getCnpj(), other.getCnpj());
            result = result && equals(getCocli(), other.getCocli());
            result = result && equals(getPasso(), other.getPasso());
            result = result && equals(getUnidadeAutorizador(), other.getUnidadeAutorizador());
            result = result && equals(getValorPad(), other.getValorPad());
            result = result && equals(getPercPad(), other.getPercPad());
            result = result && equals(getValorNeg(), other.getValorNeg());
            result = result && equals(getPercNeg(), other.getPercNeg());
            result = result && equals(getValorAtu(), other.getValorAtu());
            result = result && equals(getPercAtu(), other.getPercAtu());
            result = result && equals(getNuServico(), other.getNuServico());
            result = result && equals(getDeServico(), other.getDeServico());
           
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
        properties.add(new Property("deServico", StringType.create(), false, true));
        properties.add(new Property("cep", LongType.create(), false, true));
        
        properties.add(new Property("valorPad", MoneyType.create(), false, true));
        properties.add(new Property("percPad", MoneyType.create(), false, true));
        properties.add(new Property("valorNeg", MoneyType.create(), false, true));
        properties.add(new Property("percNeg", MoneyType.create(), false, true));
        properties.add(new Property("valorAtu", MoneyType.create(), false, true));
        properties.add(new Property("percAtu", MoneyType.create(), false, true));
        properties.add(new Property("nu_simulacao", MoneyType.create(), false, true));
        properties.add(new Property("nuServico", LongType.create(), false, true));
     
        Layout result = new Layout(properties, "TarifaSimulaBean", "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("deServico", new StringValue("X(40)"));
        Mainframe.put("municipio", new StringValue("X(35)"));
        Mainframe.put("uf", new StringValue("X(2)"));
        Mainframe.put("endereco", new StringValue("X(40)"));
      
        Mainframe.put("passo", new StringValue("X(1)"));
        Mainframe.put("nu_simulacao", new LongValue("9(20)"));
        Mainframe.put("icPessoa", new StringValue("X(1)"));
        Mainframe.put("cnpj", new LongValue("9(14)"));
        Mainframe.put("coCedente", new LongValue("9(07)"));
        Mainframe.put("cocli", new LongValue("9(13)"));
        Mainframe.put("unidadeAutorizador", new LongValue("9(04)"));
        Mainframe.put("nuServico", new LongValue("9(04)"));
        Mainframe.put("valorPad", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("percPad", new MoneyValue("R$ 9(3)v99"));
        Mainframe.put("valorNeg", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("percNeg", new MoneyValue("R$ 9(3)v99"));
        Mainframe.put("valorAtu", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("percAtu", new MoneyValue("R$ 9(3)v99"));
       
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
