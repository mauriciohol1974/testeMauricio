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

public class TarifaSimulacaoEnvio extends SigcbBean {
   
    private Long nuSimulacao;
	
	private Long coTarifa;

    private br.com.politec.sao.util.Money vrTarifa;

    private br.com.politec.sao.util.Money percTarifa;

 
    public TarifaSimulacaoEnvio() {
        this.nuSimulacao=null;
    	this.coTarifa = null;
        this.vrTarifa = null;
        this.percTarifa = null;
      
    }

    public String getApplicationName() {
        return "TarifaSimulacaoEnvio";
    }

  
	
	public Long getNuSimulacao() {
		return nuSimulacao;
	}

	public void setNuSimulacao(Long nuSimulacao) {
		this.nuSimulacao = nuSimulacao;
	}

	public Long getCoTarifa() {
		return coTarifa;
	}

	public void setCoTarifa(Long coTarifa) {
		this.coTarifa = coTarifa;
	}

	public br.com.politec.sao.util.Money getVrTarifa() {
		return vrTarifa;
	}

	public void setVrTarifa(br.com.politec.sao.util.Money vrTarifa) {
		this.vrTarifa = vrTarifa;
	}

	public br.com.politec.sao.util.Money getPercTarifa() {
		return percTarifa;
	}

	public void setPercTarifa(br.com.politec.sao.util.Money percTarifa) {
		this.percTarifa = percTarifa;
	}

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            TarifaSimulacaoEnvio other = (TarifaSimulacaoEnvio) obj;
            result = result && equals(getNuSimulacao(), other.getNuSimulacao());
            result = result && equals(getCoTarifa(), other.getCoTarifa());
            result = result && equals(getVrTarifa(), other.getVrTarifa());
            result = result && equals(getPercTarifa(), other.getPercTarifa());
        
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
        properties.add(new Property("percTarifa", MoneyType.create(), false, true));
        properties.add(new Property("vrTarifa", MoneyType.create(), false, true));
        properties.add(new Property("coTarifa", LongType.create(), false, true));
        properties.add(new Property("nuSimulacao", LongType.create(), false, true));
     
        Layout result = new Layout(properties, "TarifaSimulacaoEnvio", "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("vrTarifa", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("percTarifa", new MoneyValue("R$ 9(03)v99"));
        Mainframe.put("coTarifa", new LongValue("9(04)"));
        Mainframe.put("nuSimulacao", new LongValue("9(20)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
