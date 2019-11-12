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

public class ContaCreditoBean extends SigcbBean {
  
    private Long cedente;
    private Long nossoNumero;
	private String conta;
    private String percPrevisto;
    private String percEfetivo;
    private String valorPrevisto;
    private String valorEfetivo;
    private String cpfCnpj;
    private String titular;
    private String banco;

    
    
    
    public ContaCreditoBean() {
        this.conta=null;
        this.percEfetivo=null;
        this.percEfetivo=null;
        this.valorPrevisto=null;
        this.valorEfetivo=null;
        this.cpfCnpj=null;
        this.titular=null;
        this.cedente=null;
        this.nossoNumero=null;
        this.banco = null;
    }
    
    
    
	public String getConta() {
		return conta;
	}



	public void setConta(String conta) {
		this.conta = conta;
	}



	public String getPercPrevisto() {
		return percPrevisto;
	}



	public void setPercPrevisto(String percPrevisto) {
		this.percPrevisto = percPrevisto;
	}



	public String getPercEfetivo() {
		return percEfetivo;
	}



	public void setPercEfetivo(String percEfetivo) {
		this.percEfetivo = percEfetivo;
	}



	public String getValorPrevisto() {
		return valorPrevisto;
	}



	public void setValorPrevisto(String valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}



	public String getValorEfetivo() {
		return valorEfetivo;
	}



	public void setValorEfetivo(String valorEfetivo) {
		this.valorEfetivo = valorEfetivo;
	}



	public String getCpfCnpj() {
		return cpfCnpj;
	}



	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}



	public String getTitular() {
		return titular;
	}



	public void setTitular(String titular) {
		this.titular = titular;
	}







	public Long getCedente() {
		return cedente;
	}



	public void setCedente(Long cedente) {
		this.cedente = cedente;
	}



	public Long getNossoNumero() {
		return nossoNumero;
	}



	public void setNossoNumero(Long nossoNumero) {
		this.nossoNumero = nossoNumero;
	}



	public String getBanco() {
		return banco;
	}



	public void setBanco(String banco) {
		this.banco = banco;
	}



	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ContaCreditoBean other = (ContaCreditoBean) obj;
            result = result  && equals(getConta(), other.getConta());
            result = result  && equals(getPercPrevisto(), other.getPercPrevisto());
            result = result  && equals(getPercEfetivo(), other.getPercEfetivo());
            result = result  && equals(getValorPrevisto(),other.getValorPrevisto());
            result = result  && equals(getValorEfetivo(),other.getValorEfetivo());
            result = result  && equals(getCpfCnpj(),other.getCpfCnpj());
            result = result  && equals(getTitular(),other.getTitular());
            result = result  && equals(getCedente(),other.getCedente());
            result = result  && equals(getNossoNumero(),other.getNossoNumero());
            result = result  && equals(getBanco(),other.getBanco());
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
        

        properties.add(new Property("conta", StringType.create(), false, true));
        properties.add(new Property("percPrevisto", StringType.create(), false, true));
        properties.add(new Property("percEfetivo", StringType.create(), false, true));
        properties.add(new Property("valorPrevisto", StringType.create(), false, true));
        properties.add(new Property("valorEfetivo", StringType.create(), false, true));
        properties.add(new Property("cpfCnpj", StringType.create(), false, true));
        properties.add(new Property("titular", StringType.create(), false, true));
        properties.add(new Property("cedente", StringType.create(), false, true));
        properties.add(new Property("nossoNumero", StringType.create(), false, true));
        properties.add(new Property("banco", StringType.create(), false, true));
        
        
        Layout result = new Layout(properties,"ContaCreditoBean", "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();

        Mainframe.put("conta", new StringValue("X(23)"));
        Mainframe.put("percPrevisto", new StringValue("X(06)"));
        Mainframe.put("percEfetivo", new StringValue("X(06)"));
        Mainframe.put("valorPrevisto", new StringValue("X(10)"));
        Mainframe.put("valorEfetivo", new StringValue("X(10)"));
        Mainframe.put("cpfCnpj", new StringValue("X(20)"));
        Mainframe.put("titular", new StringValue("X(40)"));
        Mainframe.put("cedente", new LongValue("9(07)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        Mainframe.put("banco", new StringValue("X(03)"));
        
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