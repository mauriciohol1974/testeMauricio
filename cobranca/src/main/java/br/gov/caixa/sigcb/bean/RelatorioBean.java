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
import br.gov.caixa.sigcb.util.Formatador;

public class RelatorioBean extends SigcbBean {

    private java.lang.Long produto;
    private Date data;
    private String opcao;
    private Long unidade;
    private Long cedente;
    private Long qtdeLiq;
    private br.com.politec.sao.util.Money valorLiq;
    private String tpPessoa;
    private String nuCpfCnpj;
    
    private String produto1;
    private String produto2;
    private String produto3;
    private String produto4;
 

    public RelatorioBean() {
        this.produto = null;
        this.data = null;
        this.opcao=null;
        this.unidade=null;
        this.cedente=null;
        this.qtdeLiq=null;
        this.valorLiq=null;
        this.tpPessoa=null;
        this.nuCpfCnpj=null;
        this.produto1=null;
        this.produto2=null;
        this.produto3=null;
        this.produto4=null;
    }

    public String getApplicationName() {
        return "RelatorioBean";
    }

    
   


	public String getProduto1() {
		return produto1;
	}

	public void setProduto1(String produto1) {
		this.produto1 = produto1;
	}

	public String getProduto2() {
		return produto2;
	}

	public void setProduto2(String produto2) {
		this.produto2 = produto2;
	}

	public String getProduto3() {
		return produto3;
	}

	public void setProduto3(String produto3) {
		this.produto3 = produto3;
	}

	public String getProduto4() {
		return produto4;
	}

	public void setProduto4(String produto4) {
		this.produto4 = produto4;
	}

	public String getTpPessoa() {
		return tpPessoa;
	}

	public void setTpPessoa(String tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	public String getNuCpfCnpj() {
		return nuCpfCnpj;
	}
	
	public String getCpfCpnjFormatado(){
		String ret = "";
		if (this.tpPessoa.equalsIgnoreCase("F")){
			ret = Formatacao.formataCNPJ(this.nuCpfCnpj);
		}else{
			ret = Formatacao.formataCPF(this.nuCpfCnpj.substring(3, 13));
		}
		
		return ret;
	}

	public void setNuCpfCnpj(String nuCpfCnpj) {
		this.nuCpfCnpj = nuCpfCnpj;
	}

	public Long getQtdeLiq() {
		return qtdeLiq;
	}

	public void setQtdeLiq(Long qtdeLiq) {
		this.qtdeLiq = qtdeLiq;
	}

	public br.com.politec.sao.util.Money getValorLiq() {
		return valorLiq;
	}

	public void setValorLiq(br.com.politec.sao.util.Money valorLiq) {
		this.valorLiq = valorLiq;
	}

	public Long getCedente() {
		return cedente;
	}

	public void setCedente(Long cedente) {
		this.cedente = cedente;
	}

	public Long getUnidade() {
		return unidade;
	}

	public void setUnidade(Long unidade) {
		this.unidade = unidade;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public java.lang.Long getProduto() {
		return produto;
	}

	public void setProduto(java.lang.Long produto) {
		this.produto = produto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
    public java.lang.String getDataFormatada() {
        if (this.data != null) {
            return Formatador.formatarData(this.data);
        } else {
            return "";
        }
    }

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            RelatorioBean other = (RelatorioBean) obj;
            result = result && equals(getProduto(), other.getProduto());
            result = result && equals(getData(), other.getData());
            result = result && equals(getOpcao(), other.getOpcao());
            result = result && equals(getUnidade(), other.getUnidade());
            result = result && equals(getCedente(), other.getCedente());
            result = result && equals(getValorLiq(), other.getValorLiq());
            result = result && equals(getQtdeLiq(), other.getQtdeLiq());
            result = result && equals(getTpPessoa(), other.getTpPessoa());
            result = result && equals(getNuCpfCnpj(), other.getNuCpfCnpj());
            
            result = result && equals(getProduto1(), other.getProduto1());
            result = result && equals(getProduto2(), other.getProduto2());
            result = result && equals(getProduto3(), other.getProduto3());
            result = result && equals(getProduto4(), other.getProduto4());
            
            
           
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
      
        properties.add(new Property("produto", LongType.create(), false, true));
        properties.add(new Property("data", DateType.create(), false, true));
        properties.add(new Property("unidade", LongType.create(), false, true));
        properties.add(new Property("cedente", LongType.create(), false, true));
        properties.add(new Property("qtdeLiq", LongType.create(), false, true));
        properties.add(new Property("valorLiq",MoneyType.create(),false,  true));
        properties.add(new Property("tpPessoa",  StringType.create(), false, true));
        properties.add(new Property("nuCpfCnpj", StringType.create(), false, true));
        
        properties.add(new Property("produto1", StringType.create(), false, true));

        properties.add(new Property("produto2", StringType.create(), false, true));

        properties.add(new Property("produto3", StringType.create(), false, true));

        properties.add(new Property("produto4", StringType.create(), false, true));

        
        Layout result = new Layout(properties, "RelatorioBean",  "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("produto", new LongValue("9(04)"));
        Mainframe.put("unidade", new LongValue("9(04)"));
        Mainframe.put("data",  new DateValue("dd.MM.yyyy"));
        Mainframe.put("cedente", new LongValue("9(07)"));
        Mainframe.put("qtdeLiq", new LongValue("9(09)"));
        Mainframe.put("valorLiq", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("tpPessoa", new StringValue("X(01)"));
        Mainframe.put("nuCpfCnpj", new StringValue("X(14)"));
        
        Mainframe.put("produto1", new StringValue("X(01)"));
        Mainframe.put("produto2", new StringValue("X(01)"));
        Mainframe.put("produto3", new StringValue("X(01)"));
        Mainframe.put("produto4", new StringValue("X(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
