//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
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
import br.gov.caixa.sigcb.util.Formatador;

public class ImpressaoBloqBean extends SigcbBean {


    private java.lang.Long codigoCedente;
    
    private java.lang.Long nossoNumero;

    private String linhaDigitavel;

    private java.lang.String dataVencimento;

    private java.lang.String dataImpressao;

    private java.lang.String horaImpressao;

    private br.com.politec.sao.util.Money valorDocumento;

    private java.lang.String ipMaquina;
    
    private String sistema;
    
    private String codUsuario;
    
    private String codRetorno;
    
    private String msgRetorno;

    public ImpressaoBloqBean() {
        this.codigoCedente = null;
        this.linhaDigitavel=null;
        this.dataVencimento=null;
        this.dataImpressao=null;
        this.horaImpressao=null;
        this.valorDocumento=null;
        this.ipMaquina=null;
        this.codRetorno=null;
        this.msgRetorno=null;
        this.nossoNumero=null;
        this.sistema=null;
        this.codUsuario=null;
      
    }

    public String getApplicationName() {
        return "ImpressaoBloqBean";
    }

   
    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    
   
    public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public java.lang.String getFormataData(String value) {
        if ((value != null) && (value.trim().length() == 10)) {
            return value.substring(0, 2)
                   + "/"
                   + value.substring(3, 5)
                   + "/"
                   + value.substring(6, 10);

        } else {
            return value;
        }
    }
    
    

       public String getLinhaDigitavel() {
		return linhaDigitavel;
	}

	public void setLinhaDigitavel(String linhaDigitavel) {
		this.linhaDigitavel = linhaDigitavel;
	}

	public java.lang.String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(java.lang.String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public java.lang.String getDataImpressao() {
		return dataImpressao;
	}

	public void setDataImpressao(java.lang.String dataImpressao) {
		this.dataImpressao = dataImpressao;
	}

	public java.lang.String getHoraImpressao() {
		return horaImpressao;
	}

	public void setHoraImpressao(java.lang.String horaImpressao) {
		this.horaImpressao = horaImpressao;
	}



	public br.com.politec.sao.util.Money getValorDocumento() {
		return valorDocumento;
	}

	public void setValorDocumento(br.com.politec.sao.util.Money valorDocumento) {
		this.valorDocumento = valorDocumento;
	}

	public java.lang.String getIpMaquina() {
		return ipMaquina;
	}

	public void setIpMaquina(java.lang.String ipMaquina) {
		this.ipMaquina = ipMaquina;
	}
	

	public String getCodRetorno() {
		return codRetorno;
	}

	public void setCodRetorno(String codRetorno) {
		this.codRetorno = codRetorno;
	}

	public String getMsgRetorno() {
		return msgRetorno;
	}

	public void setMsgRetorno(String msgRetorno) {
		this.msgRetorno = msgRetorno;
	}
	
	

	public java.lang.Long getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(java.lang.Long nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ImpressaoBloqBean other = (ImpressaoBloqBean) obj;

            result = result && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getLinhaDigitavel(), other.getLinhaDigitavel());
            result = result && equals(getDataVencimento(), other.getDataVencimento());
            result = result && equals(getDataImpressao(), other.getDataImpressao());
            result = result && equals(getHoraImpressao(), other.getHoraImpressao());
            result = result && equals(getValorDocumento(), other.getValorDocumento());
            result = result && equals(getIpMaquina(), other.getIpMaquina());
            result = result && equals(getCodRetorno(), other.getCodRetorno());
            result = result && equals(getMsgRetorno(), other.getMsgRetorno());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result && equals(getSistema(), other.getSistema());
            result = result && equals(getCodUsuario(), other.getCodUsuario());
            
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

        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nossoNumero",
                LongType.create(),
                false,
                true));
        properties.add(new Property("linhaDigitavel",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataVencimento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataImpressao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("horaImpressao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("valorDocumento",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("ipMaquina",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codRetorno",
                StringType.create(),
                false,
                true));
        properties.add(new Property("msgRetorno",
                StringType.create(),
                false,
                true));
        properties.add(new Property("sistema",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codUsuario",
                StringType.create(),
                false,
                true));
     
        Layout result = new Layout(properties,
                "ImpressaoBloqBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        Mainframe.put("linhaDigitavel", new StringValue("X(47)"));
        Mainframe.put("dataVencimento", new StringValue("X(10)"));
        Mainframe.put("dataImpressao", new StringValue("X(10)"));
        Mainframe.put("horaImpressao", new StringValue("X(8)"));
        Mainframe.put("valorDocumento", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("ipMaquina", new StringValue("X(17)"));
        Mainframe.put("codRetorno", new StringValue("X(02)"));
        Mainframe.put("msgRetorno", new StringValue("X(250)"));
        Mainframe.put("sistema", new StringValue("X(1)"));
        Mainframe.put("codUsuario", new StringValue("X(08)"));
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
