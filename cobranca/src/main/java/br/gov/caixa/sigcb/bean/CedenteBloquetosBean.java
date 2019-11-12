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
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteBloquetosBean extends SigcbBean {
    private java.lang.Long avisoDisponibPrimeira;

    private java.lang.Long avisoDisponibSegunda;

    private java.lang.Long avisoDisponibTerceira;

    private java.lang.String avisoSacado;
    
    private java.lang.String impBloqDDA;

    private java.lang.Long avisoVencidoPrimeira;

    private java.lang.Long avisoVencidoSegunda;

    private java.lang.Long avisoVencidoTerceira;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoClienteCOCLI;

    private java.lang.Long codigoUnidadePVVinc;

    private java.lang.String descEmissaoBloquetos;

    private java.lang.String descEnvioAvisoSacado;

    private java.lang.String descEnvioBloqueto;

    private java.lang.String descricaoCriticas;

    private java.lang.Long emissaoBloquetos;

    private java.lang.Long envioAvisoSacado;

    private java.lang.Long envioBloqueto;

    private java.lang.String formasAvisoProtesto;

    private java.lang.String formasAvisoVencido;

    private java.lang.String nsuTransacao;

    private java.lang.Long qtdeDiasProtesto;

    private java.lang.String tipoAcao;

    private java.lang.String tipoConsulta;
    
    private String envioSMS;
    private java.lang.Long prazoSMS1;
    private java.lang.Long prazoSMS2;
    private java.lang.Long prazoSMS3;
    
    private Long qtdeBolMes;
    private Money valorMinULCCA;
    private Money valorMaxULCCA;
    

    private br.com.politec.sao.util.Money valorMinimoAviso;

    public CedenteBloquetosBean() {
        this.avisoDisponibPrimeira = null;
        this.avisoDisponibSegunda = null;
        this.avisoDisponibTerceira = null;
        this.avisoSacado = null;
        this.impBloqDDA = null;
        this.avisoVencidoPrimeira = null;
        this.avisoVencidoSegunda = null;
        this.avisoVencidoTerceira = null;
        this.codigoCedente = null;
        this.codigoClienteCOCLI = null;
        this.codigoUnidadePVVinc = null;
        this.descEmissaoBloquetos = null;
        this.descEnvioAvisoSacado = null;
        this.descEnvioBloqueto = null;
        this.descricaoCriticas = null;
        this.emissaoBloquetos = null;
        this.envioAvisoSacado = null;
        this.envioBloqueto = null;
        this.formasAvisoProtesto = null;
        this.formasAvisoVencido = null;
        this.nsuTransacao = null;
        this.qtdeDiasProtesto = null;
        this.tipoAcao = null;
        this.tipoConsulta = null;
        this.valorMinimoAviso = null;
        this.envioSMS = null;
        this.prazoSMS1 = null;
        this.prazoSMS2 = null;
        this.prazoSMS3 = null;
        this.qtdeBolMes=null;
        this.valorMinULCCA=null;
        this.valorMaxULCCA=null;
    }

    public String getApplicationName() {
        return "CedenteBloquetosBean";
    }

    public Long getQtdeBolMes() {
		return qtdeBolMes;
	}

	public void setQtdeBolMes(Long qtdeBolMes) {
		this.qtdeBolMes = qtdeBolMes;
	}

	public Money getValorMinULCCA() {
		return valorMinULCCA;
	}

	public void setValorMinULCCA(Money valorMinULCCA) {
		this.valorMinULCCA = valorMinULCCA;
	}

	public Money getValorMaxULCCA() {
		return valorMaxULCCA;
	}

	public void setValorMaxULCCA(Money valorMaxULCCA) {
		this.valorMaxULCCA = valorMaxULCCA;
	}

	public java.lang.Long getAvisoDisponibPrimeira() {
        return this.avisoDisponibPrimeira;
    }

    public void setAvisoDisponibPrimeira(java.lang.Long avisoDisponibPrimeira) {
        this.avisoDisponibPrimeira = avisoDisponibPrimeira;
    }

    public java.lang.Long getAvisoDisponibSegunda() {
        return this.avisoDisponibSegunda;
    }

    public void setAvisoDisponibSegunda(java.lang.Long avisoDisponibSegunda) {
        this.avisoDisponibSegunda = avisoDisponibSegunda;
    }

    public java.lang.Long getAvisoDisponibTerceira() {
        return this.avisoDisponibTerceira;
    }

    public void setAvisoDisponibTerceira(java.lang.Long avisoDisponibTerceira) {
        this.avisoDisponibTerceira = avisoDisponibTerceira;
    }

    public java.lang.String getAvisoSacado() {
        return this.avisoSacado;
    }

    public void setAvisoSacado(java.lang.String avisoSacado) {
        this.avisoSacado = avisoSacado;
    }
    
    public java.lang.String getImpBloqDDA() {
    	return this.impBloqDDA;
    }
    
    public void setImpBloqDDA(java.lang.String impBloqDDA) {
    	this.impBloqDDA = impBloqDDA;
    }

    public java.lang.Long getAvisoVencidoPrimeira() {
        return this.avisoVencidoPrimeira;
    }

    public void setAvisoVencidoPrimeira(java.lang.Long avisoVencidoPrimeira) {
        this.avisoVencidoPrimeira = avisoVencidoPrimeira;
    }

    public java.lang.Long getAvisoVencidoSegunda() {
        return this.avisoVencidoSegunda;
    }

    public void setAvisoVencidoSegunda(java.lang.Long avisoVencidoSegunda) {
        this.avisoVencidoSegunda = avisoVencidoSegunda;
    }

    public java.lang.Long getAvisoVencidoTerceira() {
        return this.avisoVencidoTerceira;
    }

    public void setAvisoVencidoTerceira(java.lang.Long avisoVencidoTerceira) {
        this.avisoVencidoTerceira = avisoVencidoTerceira;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoClienteCOCLI() {
        return this.codigoClienteCOCLI;
    }

    public void setCodigoClienteCOCLI(java.lang.Long codigoClienteCOCLI) {
        this.codigoClienteCOCLI = codigoClienteCOCLI;
    }

    public java.lang.Long getCodigoUnidadePVVinc() {
        return this.codigoUnidadePVVinc;
    }

    public void setCodigoUnidadePVVinc(java.lang.Long codigoUnidadePVVinc) {
        this.codigoUnidadePVVinc = codigoUnidadePVVinc;
    }

    public java.lang.String getDescEmissaoBloquetos() {
        return this.descEmissaoBloquetos;
    }

    public void setDescEmissaoBloquetos(java.lang.String descEmissaoBloquetos) {
        this.descEmissaoBloquetos = descEmissaoBloquetos;
    }

    public java.lang.String getDescEnvioAvisoSacado() {
        return this.descEnvioAvisoSacado;
    }

    public void setDescEnvioAvisoSacado(java.lang.String descEnvioAvisoSacado) {
        this.descEnvioAvisoSacado = descEnvioAvisoSacado;
    }

    public java.lang.String getDescEnvioBloqueto() {
        return this.descEnvioBloqueto;
    }

    public void setDescEnvioBloqueto(java.lang.String descEnvioBloqueto) {
        this.descEnvioBloqueto = descEnvioBloqueto;
    }

    public java.lang.String getDescricaoCriticas() {
        return this.descricaoCriticas;
    }

    public void setDescricaoCriticas(java.lang.String descricaoCriticas) {
        this.descricaoCriticas = descricaoCriticas;
    }

    public java.lang.Long getEmissaoBloquetos() {
        return this.emissaoBloquetos;
    }

    public void setEmissaoBloquetos(java.lang.Long emissaoBloquetos) {
        this.emissaoBloquetos = emissaoBloquetos;
    }

    public java.lang.Long getEnvioAvisoSacado() {
        return this.envioAvisoSacado;
    }

    public void setEnvioAvisoSacado(java.lang.Long envioAvisoSacado) {
        this.envioAvisoSacado = envioAvisoSacado;
    }

    public java.lang.Long getEnvioBloqueto() {
        return this.envioBloqueto;
    }

    public void setEnvioBloqueto(java.lang.Long envioBloqueto) {
        this.envioBloqueto = envioBloqueto;
    }

    public java.lang.String getFormasAvisoProtesto() {
        return this.formasAvisoProtesto;
    }

    public void setFormasAvisoProtesto(java.lang.String formasAvisoProtesto) {
        this.formasAvisoProtesto = formasAvisoProtesto;
    }

    public java.lang.String getFormasAvisoVencido() {
        return this.formasAvisoVencido;
    }

    public void setFormasAvisoVencido(java.lang.String formasAvisoVencido) {
        this.formasAvisoVencido = formasAvisoVencido;
    }

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public java.lang.Long getQtdeDiasProtesto() {
        return this.qtdeDiasProtesto;
    }

    public void setQtdeDiasProtesto(java.lang.Long qtdeDiasProtesto) {
        this.qtdeDiasProtesto = qtdeDiasProtesto;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.String getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public br.com.politec.sao.util.Money getValorMinimoAviso() {
        return this.valorMinimoAviso;
    }

    public void setValorMinimoAviso(br.com.politec.sao.util.Money valorMinimoAviso) {
        this.valorMinimoAviso = valorMinimoAviso;
    }
    
    

    public String getEnvioSMS() {
		return envioSMS;
	}

	public void setEnvioSMS(String envioSMS) {
		this.envioSMS = envioSMS;
	}

	public java.lang.Long getPrazoSMS1() {
		return prazoSMS1;
	}

	public void setPrazoSMS1(java.lang.Long prazoSMS1) {
		this.prazoSMS1 = prazoSMS1;
	}

	public java.lang.Long getPrazoSMS2() {
		return prazoSMS2;
	}

	public void setPrazoSMS2(java.lang.Long prazoSMS2) {
		this.prazoSMS2 = prazoSMS2;
	}

	public java.lang.Long getPrazoSMS3() {
		return prazoSMS3;
	}

	public void setPrazoSMS3(java.lang.Long prazoSMS3) {
		this.prazoSMS3 = prazoSMS3;
	}

	// ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedenteBloquetosBean other = (CedenteBloquetosBean) obj;
            result = result
                     && equals(getAvisoDisponibPrimeira(),
                             other.getAvisoDisponibPrimeira());
            result = result
                     && equals(getAvisoDisponibSegunda(),
                             other.getAvisoDisponibSegunda());
            result = result
                     && equals(getAvisoDisponibTerceira(),
                             other.getAvisoDisponibTerceira());
            result = result && equals(getAvisoSacado(), other.getAvisoSacado());
            result = result 
            		 && equals(getImpBloqDDA(), other.getImpBloqDDA());
            result = result
                     && equals(getAvisoVencidoPrimeira(),
                             other.getAvisoVencidoPrimeira());
            result = result
                     && equals(getAvisoVencidoSegunda(),
                             other.getAvisoVencidoSegunda());
            result = result
                     && equals(getAvisoVencidoTerceira(),
                             other.getAvisoVencidoTerceira());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoClienteCOCLI(),
                             other.getCodigoClienteCOCLI());
            result = result
                     && equals(getCodigoUnidadePVVinc(),
                             other.getCodigoUnidadePVVinc());
            result = result
                     && equals(getDescEmissaoBloquetos(),
                             other.getDescEmissaoBloquetos());
            result = result
                     && equals(getDescEnvioAvisoSacado(),
                             other.getDescEnvioAvisoSacado());
            result = result
                     && equals(getDescEnvioBloqueto(),
                             other.getDescEnvioBloqueto());
            result = result
                     && equals(getDescricaoCriticas(),
                             other.getDescricaoCriticas());
            result = result
                     && equals(getEmissaoBloquetos(),
                             other.getEmissaoBloquetos());
            result = result
                     && equals(getEnvioAvisoSacado(),
                             other.getEnvioAvisoSacado());
            result = result
                     && equals(getEnvioBloqueto(), other.getEnvioBloqueto());
            result = result
                     && equals(getFormasAvisoProtesto(),
                             other.getFormasAvisoProtesto());
            result = result
                     && equals(getFormasAvisoVencido(),
                             other.getFormasAvisoVencido());
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result
                     && equals(getQtdeDiasProtesto(),
                             other.getQtdeDiasProtesto());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result
                     && equals(getValorMinimoAviso(),
                             other.getValorMinimoAviso());
            result = result  && equals(getEnvioSMS(),  other.getEnvioSMS());
            result = result  && equals(getPrazoSMS1(),  other.getPrazoSMS1());
            result = result  && equals(getPrazoSMS2(),  other.getPrazoSMS2());
            result = result  && equals(getPrazoSMS3(),  other.getPrazoSMS3());
           
            result = result  && equals(getQtdeBolMes(),  other.getQtdeBolMes());
            result = result  && equals(getValorMinULCCA(),  other.getValorMinULCCA());
            result = result  && equals(getValorMaxULCCA(),  other.getValorMaxULCCA());
            
            
            
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
        properties.add(new Property("avisoDisponibPrimeira",
                LongType.create(),
                false,
                true));
        properties.add(new Property("avisoDisponibSegunda",
                LongType.create(),
                false,
                true));
        properties.add(new Property("avisoDisponibTerceira",
                LongType.create(),
                false,
                true));
        properties.add(new Property("avisoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("impBloqDDA", 
        		StringType.create(), 
        		false,
        		true));
        properties.add(new Property("avisoVencidoPrimeira",
                LongType.create(),
                false,
                true));
        properties.add(new Property("avisoVencidoSegunda",
                LongType.create(),
                false,
                true));
        properties.add(new Property("avisoVencidoTerceira",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoClienteCOCLI",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePVVinc",
                LongType.create(),
                false,
                true));
        properties.add(new Property("descEmissaoBloquetos",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descEnvioAvisoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descEnvioBloqueto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricaoCriticas",
                StringType.create(),
                false,
                true));
        properties.add(new Property("emissaoBloquetos",
                LongType.create(),
                false,
                true));
        properties.add(new Property("envioAvisoSacado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("envioBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("formasAvisoProtesto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("formasAvisoVencido",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("qtdeDiasProtesto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                StringType.create(),
                false,
                true));
        properties.add(new Property("valorMinimoAviso",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("envioSMS",
                StringType.create(),
                false,
                true));
        properties.add(new Property("prazoSMS1",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoSMS2",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoSMS3",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdeBolMes",
                LongType.create(),
                false,
                true));
        properties.add(new Property("valorMinULCCA",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorMaxULCCA",
                MoneyType.create(),
                false,
                true));
        
    

        Layout result = new Layout(properties,
                "CedenteBloquetosBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("avisoDisponibPrimeira", new LongValue("9(03)"));
        Mainframe.put("avisoDisponibSegunda", new LongValue("9(03)"));
        Mainframe.put("avisoDisponibTerceira", new LongValue("9(03)"));
        Mainframe.put("avisoSacado", new StringValue("X(01)"));
        Mainframe.put("impBloqDDA", new StringValue("X(01)"));
        Mainframe.put("avisoVencidoPrimeira", new LongValue("9(03)"));
        Mainframe.put("avisoVencidoSegunda", new LongValue("9(03)"));
        Mainframe.put("avisoVencidoTerceira", new LongValue("9(03)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("codigoClienteCOCLI", new LongValue("9(13)"));
        Mainframe.put("codigoUnidadePVVinc", new LongValue("9(04)"));
        Mainframe.put("descEmissaoBloquetos", new StringValue("X(40)"));
        Mainframe.put("descEnvioAvisoSacado", new StringValue("X(40)"));
        Mainframe.put("descEnvioBloqueto", new StringValue("X(40)"));
        Mainframe.put("descricaoCriticas", new StringValue("X(200)"));
        Mainframe.put("emissaoBloquetos", new LongValue("9(02)"));
        Mainframe.put("envioAvisoSacado", new LongValue("9(02)"));
        Mainframe.put("envioBloqueto", new LongValue("9(02)"));
        Mainframe.put("formasAvisoProtesto", new StringValue("X(01)"));
        Mainframe.put("formasAvisoVencido", new StringValue("X(01)"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("qtdeDiasProtesto", new LongValue("9(03)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("tipoConsulta", new StringValue("X(01)"));
        Mainframe.put("valorMinimoAviso", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("envioSMS", new StringValue("X(01)"));
        Mainframe.put("prazoSMS1", new LongValue("9(03)"));
        Mainframe.put("prazoSMS2", new LongValue("9(03)"));
        Mainframe.put("prazoSMS3", new LongValue("9(03)"));
        Mainframe.put("qtdeBolMes", new LongValue("9(03)"));
        Mainframe.put("valorMinULCCA", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorMaxULCCA", new MoneyValue("R$ 9(13)v99"));
        result.addExtension(Mainframe);
        return result;
        

    }

    public Layout getLayout() {
        return layout;
    }
}
