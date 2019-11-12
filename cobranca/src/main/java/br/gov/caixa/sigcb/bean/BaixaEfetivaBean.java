//Bean alterado manualmente, cuidado ao gerar....

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

public class BaixaEfetivaBean extends SigcbBean {

    
    private Long nuIdentificacao;
    private Long nuIdentiBaixaOper;
    private String dtHoraBaixaOper;
    private Money vlrBaixaOper;
    private String tpBaixaOper;
    

    public BaixaEfetivaBean() {

        this.nuIdentificacao=null;
        this.nuIdentiBaixaOper=null;
        this.dtHoraBaixaOper=null;
        this.vlrBaixaOper=null;
        this.tpBaixaOper=null;
        
    }

    public Long getNuIdentificacao() {
		return nuIdentificacao;
	}

	public void setNuIdentificacao(Long nuIdentificacao) {
		this.nuIdentificacao = nuIdentificacao;
	}

	public Long getNuIdentiBaixaOper() {
		return nuIdentiBaixaOper;
	}

	public void setNuIdentiBaixaOper(Long nuIdentiBaixaOper) {
		this.nuIdentiBaixaOper = nuIdentiBaixaOper;
	}



	public String getDtHoraBaixaOper() {
		return dtHoraBaixaOper;
	}

	public void setDtHoraBaixaOper(String dtHoraBaixaOper) {
		this.dtHoraBaixaOper = dtHoraBaixaOper;
	}

	public Money getVlrBaixaOper() {
		return vlrBaixaOper;
	}

	public void setVlrBaixaOper(Money vlrBaixaOper) {
		this.vlrBaixaOper = vlrBaixaOper;
	}

	public String getTpBaixaOper() {
		return tpBaixaOper;
	}

	public void setTpBaixaOper(String tpBaixaOper) {
		this.tpBaixaOper = tpBaixaOper;
	}

	public String getApplicationName() {
        return "HistoricoCedenteBean";
    }

  

    // fim-------------getCodigoUnidadeFormatado---------------------
    // Término das customizações
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            BaixaEfetivaBean other = (BaixaEfetivaBean) obj;

            
            //Baixa
            result = result && equals(getNuIdentificacao(), other.getNuIdentificacao());
            result = result && equals(getNuIdentiBaixaOper(), other.getNuIdentiBaixaOper());
            result = result && equals(getDtHoraBaixaOper(), other.getDtHoraBaixaOper());
            result = result && equals(getVlrBaixaOper(), other.getVlrBaixaOper());
            result = result && equals(getTpBaixaOper(), other.getTpBaixaOper());
            
            
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
 
        properties.add(new Property("nuIdentificacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nuIdentiBaixaOper",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dtHoraBaixaOper",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("vlrBaixaOper",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("tpBaixaOper",
                StringType.create(),
                false,
                true));
        
        Layout result = new Layout(properties,
                "BaixaOperacionalBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();

        Mainframe.put("nuIdentificacao", new LongValue("9(19)"));
        Mainframe.put("nuIdentiBaixaOper", new LongValue("9(19)"));
        Mainframe.put("dtHoraBaixaOper", new StringValue("X(26)"));
        Mainframe.put("vlrBaixaOper", new MoneyValue("R$ 9(17)v99"));
        Mainframe.put("tpBaixaOper", new StringValue("X(1)"));
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
