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

public class DetalheBaixaOperBean extends SigcbBean {

	private Long nuIdentificacao;
	private Long nuIdentBaixa;
	private Long cobeneficiario;
	private Long nossonumero;
	private String dthrbxoper;
	private String ispbparticpt;
	private String coparticipt;
	private String tppessoa;
	private Long cpfcnpjportdr;
	private String dtprocbxoper;
	private Money vlbxoper;
	private String cobarras;
	private String canalpgto;
	private String meiopgto;
	private String iccontigencia;
	private String tpbxoper;
	private Long nureferatual;
	private Long nuidentbxoper;
	private Long nuseqbxoper;
	private String nucontroledda;
	private Long nucontroleddaEfetivo;
	private String dthrdda;
	private String dtmovimento;
	private String dthrsitbxoper;
	private String sitbxoper;
	private Long qtpgtoparcial;
	private Money vlsaldottl;
	private String sittitpagto;
	private String sitcancbxoper;
	private String dthrcancbxoper;
	private String sittitulo;
	
	private String tpPessoaPort;
	private String cpfCnpjPortador;
	private String coPagtoTitulo;
	
	
	
	
	
   

    public DetalheBaixaOperBean() {
    	this.nuIdentificacao=null;
    	this.nuIdentBaixa=null;
    	this.cobeneficiario=null;
    	this.nossonumero=null;
    	this.dthrbxoper=null;
    	this.ispbparticpt=null;
    	this.coparticipt=null;
    	this.tppessoa=null;
    	this.cpfcnpjportdr=null;
    	this.dtprocbxoper=null;
    	this.vlbxoper=null;
    	this.cobarras=null;
    	this.canalpgto=null;
    	this.meiopgto=null;
    	this.iccontigencia=null;
    	this.tpbxoper=null;
    	this.nureferatual=null;
    	this.nuidentbxoper=null;
    	this.nuseqbxoper=null;
    	this.nucontroledda=null;
    	this.dthrdda=null;
    	this.dtmovimento=null;
    	this.sitbxoper=null;
    	this.dthrsitbxoper=null;
    	this.qtpgtoparcial=null;
    	this.vlsaldottl=null;
    	this.sittitpagto=null;
    	this.sitcancbxoper=null;
    	this.dthrcancbxoper=null;
    	this.sittitulo = null;
    	this.nucontroleddaEfetivo=null;
    	this.tpPessoaPort=null;
    	this.cpfCnpjPortador=null;
    	this.coPagtoTitulo=null;
        
    }


    public String getApplicationName() {
        return "DetalheBaixaOperBean";
    }

    
    public String getSitbxoper() {
		return sitbxoper;
	}





	public String getTpPessoaPort() {
		return tpPessoaPort;
	}


	public void setTpPessoaPort(String tpPessoaPort) {
		this.tpPessoaPort = tpPessoaPort;
	}


	public String getCpfCnpjPortador() {
		return cpfCnpjPortador;
	}


	public void setCpfCnpjPortador(String cpfCnpjPortador) {
		this.cpfCnpjPortador = cpfCnpjPortador;
	}


	public String getCoPagtoTitulo() {
		return coPagtoTitulo;
	}


	public void setCoPagtoTitulo(String coPagtoTitulo) {
		this.coPagtoTitulo = coPagtoTitulo;
	}


	public Long getNucontroleddaEfetivo() {
		return nucontroleddaEfetivo;
	}


	public void setNucontroleddaEfetivo(Long nucontroleddaEfetivo) {
		this.nucontroleddaEfetivo = nucontroleddaEfetivo;
	}


	public String getSittitulo() {
		return sittitulo;
	}


	public void setSittitulo(String sittitulo) {
		this.sittitulo = sittitulo;
	}


	public void setSitbxoper(String sitbxoper) {
		this.sitbxoper = sitbxoper;
	}




	public Long getNuIdentificacao() {
		return nuIdentificacao;
	}




	public void setNuIdentificacao(Long nuIdentificacao) {
		this.nuIdentificacao = nuIdentificacao;
	}




	public Long getNuIdentBaixa() {
		return nuIdentBaixa;
	}




	public void setNuIdentBaixa(Long nuIdentBaixa) {
		this.nuIdentBaixa = nuIdentBaixa;
	}




	public Long getCobeneficiario() {
		return cobeneficiario;
	}




	public void setCobeneficiario(Long cobeneficiario) {
		this.cobeneficiario = cobeneficiario;
	}




	public Long getNossonumero() {
		return nossonumero;
	}




	public void setNossonumero(Long nossonumero) {
		this.nossonumero = nossonumero;
	}




	public String getDthrbxoper() {
		return dthrbxoper;
	}




	public void setDthrbxoper(String dthrbxoper) {
		this.dthrbxoper = dthrbxoper;
	}




	public String getIspbparticpt() {
		return ispbparticpt;
	}




	public void setIspbparticpt(String ispbparticpt) {
		this.ispbparticpt = ispbparticpt;
	}




	public String getCoparticipt() {
		return coparticipt;
	}




	public void setCoparticipt(String coparticipt) {
		this.coparticipt = coparticipt;
	}




	public String getTppessoa() {
		return tppessoa;
	}




	public void setTppessoa(String tppessoa) {
		this.tppessoa = tppessoa;
	}




	public Long getCpfcnpjportdr() {
		return cpfcnpjportdr;
	}




	public void setCpfcnpjportdr(Long cpfcnpjportdr) {
		this.cpfcnpjportdr = cpfcnpjportdr;
	}




	public String getDtprocbxoper() {
		return dtprocbxoper;
	}




	public void setDtprocbxoper(String dtprocbxoper) {
		this.dtprocbxoper = dtprocbxoper;
	}




	public Money getVlbxoper() {
		return vlbxoper;
	}




	public void setVlbxoper(Money vlbxoper) {
		this.vlbxoper = vlbxoper;
	}




	public String getCobarras() {
		return cobarras;
	}




	public void setCobarras(String cobarras) {
		this.cobarras = cobarras;
	}




	public String getCanalpgto() {
		return canalpgto;
	}




	public void setCanalpgto(String canalpgto) {
		this.canalpgto = canalpgto;
	}




	public String getMeiopgto() {
		return meiopgto;
	}




	public void setMeiopgto(String meiopgto) {
		this.meiopgto = meiopgto;
	}




	public String getIccontigencia() {
		return iccontigencia;
	}




	public void setIccontigencia(String iccontigencia) {
		this.iccontigencia = iccontigencia;
	}




	public String getTpbxoper() {
		return tpbxoper;
	}




	public void setTpbxoper(String tpbxoper) {
		this.tpbxoper = tpbxoper;
	}




	public Long getNureferatual() {
		return nureferatual;
	}




	public void setNureferatual(Long nureferatual) {
		this.nureferatual = nureferatual;
	}




	public Long getNuidentbxoper() {
		return nuidentbxoper;
	}




	public void setNuidentbxoper(Long nuidentbxoper) {
		this.nuidentbxoper = nuidentbxoper;
	}




	public Long getNuseqbxoper() {
		return nuseqbxoper;
	}




	public void setNuseqbxoper(Long nuseqbxoper) {
		this.nuseqbxoper = nuseqbxoper;
	}








	public String getNucontroledda() {
		return nucontroledda;
	}


	public void setNucontroledda(String nucontroledda) {
		this.nucontroledda = nucontroledda;
	}


	public String getDthrdda() {
		return dthrdda;
	}




	public void setDthrdda(String dthrdda) {
		this.dthrdda = dthrdda;
	}




	public String getDtmovimento() {
		return dtmovimento;
	}




	public void setDtmovimento(String dtmovimento) {
		this.dtmovimento = dtmovimento;
	}




	public String getDthrsitbxoper() {
		return dthrsitbxoper;
	}




	public void setDthrsitbxoper(String dthrsitbxoper) {
		this.dthrsitbxoper = dthrsitbxoper;
	}




	public Long getQtpgtoparcial() {
		return qtpgtoparcial;
	}




	public void setQtpgtoparcial(Long qtpgtoparcial) {
		this.qtpgtoparcial = qtpgtoparcial;
	}




	public Money getVlsaldottl() {
		return vlsaldottl;
	}




	public void setVlsaldottl(Money vlsaldottl) {
		this.vlsaldottl = vlsaldottl;
	}




	public String getSittitpagto() {
		return sittitpagto;
	}




	public void setSittitpagto(String sittitpagto) {
		this.sittitpagto = sittitpagto;
	}




	public String getSitcancbxoper() {
		return sitcancbxoper;
	}




	public void setSitcancbxoper(String sitcancbxoper) {
		this.sitcancbxoper = sitcancbxoper;
	}




	public String getDthrcancbxoper() {
		return dthrcancbxoper;
	}




	public void setDthrcancbxoper(String dthrcancbxoper) {
		this.dthrcancbxoper = dthrcancbxoper;
	}




	



	// fim-------------getCodigoUnidadeFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            
            DetalheBaixaOperBean other = (DetalheBaixaOperBean) obj;
            result = result && equals(getNuIdentificacao(),other.getNuIdentificacao());
            result = result && equals(getNuIdentBaixa(),other.getNuIdentBaixa());
            result = result && equals(getCobeneficiario(),other.getCobeneficiario());
            result = result && equals(getNossonumero(),other.getNossonumero());
            result = result && equals(getDthrbxoper(),other.getDthrbxoper());
            result = result && equals(getIspbparticpt(),other.getIspbparticpt());
            result = result && equals(getCoparticipt(),other.getCoparticipt());
            result = result && equals(getTppessoa(),other.getTppessoa());
            result = result && equals(getCpfcnpjportdr(),other.getCpfcnpjportdr());
            result = result && equals(getDtprocbxoper(),other.getDtprocbxoper());
            result = result && equals(getVlbxoper(),other.getVlbxoper());
            result = result && equals(getCobarras(),other.getCobarras());
            result = result && equals(getCanalpgto(),other.getCanalpgto());
            result = result && equals(getMeiopgto(),other.getMeiopgto());
            result = result && equals(getIccontigencia(),other.getIccontigencia());
            result = result && equals(getTpbxoper(),other.getTpbxoper());
            result = result && equals(getNureferatual(),other.getNureferatual());
            result = result && equals(getNuidentbxoper(),other.getNuidentbxoper());
            result = result && equals(getNuseqbxoper(),other.getNuseqbxoper());
            result = result && equals(getNucontroledda(),other.getNucontroledda());
            result = result && equals(getDthrdda(),other.getDthrdda());
            result = result && equals(getDtmovimento(),other.getDtmovimento());
            result = result && equals(getSitbxoper(),other.getSitbxoper());
            result = result && equals(getDthrsitbxoper(),other.getDthrsitbxoper());
            result = result && equals(getQtpgtoparcial(),other.getQtpgtoparcial());
            result = result && equals(getVlsaldottl(),other.getVlsaldottl());
            result = result && equals(getSittitpagto(),other.getSittitpagto());
            result = result && equals(getSitcancbxoper(),other.getSitcancbxoper());
            result = result && equals(getDthrcancbxoper(),other.getDthrcancbxoper());
            result = result && equals(getSittitulo(),other.getSittitulo());
            result = result && equals(getNucontroleddaEfetivo(),other.getNucontroleddaEfetivo());
            result = result && equals(getTpPessoaPort(),other.getTpPessoaPort());
            result = result && equals(getCpfCnpjPortador(),other.getCpfCnpjPortador());
            result = result && equals(getCoPagtoTitulo(),other.getCoPagtoTitulo());
            
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
        properties.add(new Property("nuIdentificacao",LongType.create(), false,  true));
        properties.add(new Property("nuIdentBaixa",LongType.create(), false,  true));
        properties.add(new Property("cobeneficiario",LongType.create(), false,  true));
        properties.add(new Property("nossonumero",LongType.create(), false,  true));
        properties.add(new Property("dthrbxoper",StringType.create(), false,  true));
        properties.add(new Property("ispbparticpt",StringType.create(), false,  true));
        properties.add(new Property("coparticipt",StringType.create(), false,  true));
        properties.add(new Property("tppessoa",StringType.create(), false,  true));
        properties.add(new Property("cpfcnpjportdr",LongType.create(), false,  true));
        properties.add(new Property("dtprocbxoper",StringType.create(), false,  true));
        properties.add(new Property("vlbxoper",MoneyType.create(), false,  true));
        properties.add(new Property("cobarras",StringType.create(), false,  true));
        properties.add(new Property("canalpgto",StringType.create(), false,  true));
        properties.add(new Property("meiopgto",StringType.create(), false,  true));
        properties.add(new Property("iccontigencia",StringType.create(), false,  true));
        properties.add(new Property("tpbxoper",StringType.create(), false,  true));
        properties.add(new Property("nureferatual",LongType.create(), false,  true));
        properties.add(new Property("nuidentbxoper",LongType.create(), false,  true));
        properties.add(new Property("nuseqbxoper",LongType.create(), false,  true));
        properties.add(new Property("nucontroledda",StringType.create(), false,  true));
        properties.add(new Property("nucontroleddaEfetivo",LongType.create(), false,  true));
        properties.add(new Property("dthrdda",StringType.create(), false,  true));
        properties.add(new Property("dtmovimento",StringType.create(), false,  true));
        properties.add(new Property("sitbxoper",StringType.create(), false,  true));
        properties.add(new Property("dthrsitbxoper",StringType.create(), false,  true));
        properties.add(new Property("qtpgtoparcial",LongType.create(), false,  true));
        properties.add(new Property("vlsaldottl",MoneyType.create(), false,  true));
        properties.add(new Property("sittitpagto",StringType.create(), false,  true));
        properties.add(new Property("sitcancbxoper",StringType.create(), false,  true));
        properties.add(new Property("dthrcancbxoper",StringType.create(), false,  true));
        properties.add(new Property("sittitulo",StringType.create(), false,  true));

        
        properties.add(new Property("tpPessoaPort",StringType.create(), false,  true));
        properties.add(new Property("cpfCnpjPortador",StringType.create(), false,  true));
        properties.add(new Property("coPagtoTitulo",StringType.create(), false,  true));
        
        Layout result = new Layout(properties, "DetalheBaixaOperBeanSBean", "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("nuIdentificacao", new LongValue("9(19)"));
        Mainframe.put("nuIdentBaixa", new LongValue("9(19)"));
        
        Mainframe.put("cobeneficiario", new LongValue("9(15)"));
        Mainframe.put("nossonumero", new LongValue("9(18)"));
        Mainframe.put("dthrbxoper", new StringValue("X(26)"));
        Mainframe.put("ispbparticpt", new StringValue("X(8)"));
        Mainframe.put("coparticipt", new StringValue("X(3)"));
        Mainframe.put("tppessoa", new StringValue("X(10)"));
        Mainframe.put("cpfcnpjportdr", new LongValue("9(14)"));
        Mainframe.put("dtprocbxoper", new StringValue("X(10)"));
        Mainframe.put("vlbxoper", new MoneyValue("R$ 9(17)v99"));
        Mainframe.put("cobarras", new StringValue("X(44)"));
        Mainframe.put("canalpgto", new StringValue("X(50)"));
        Mainframe.put("meiopgto", new StringValue("X(50)"));
        Mainframe.put("iccontigencia", new StringValue("X(1)"));
        Mainframe.put("tpbxoper", new StringValue("X(120)"));
        Mainframe.put("nureferatual", new LongValue("9(19)"));
        Mainframe.put("nuidentbxoper", new LongValue("9(19)"));
        Mainframe.put("nuseqbxoper", new LongValue("9(19)"));
        Mainframe.put("nucontroledda", new StringValue("X(20)"));
        Mainframe.put("nucontroleddaEfetivo", new LongValue("9(19)"));
        Mainframe.put("dthrdda", new StringValue("X(26)"));
        Mainframe.put("dtmovimento", new StringValue("X(10)"));
        Mainframe.put("sitbxoper", new StringValue("X(120)"));
        Mainframe.put("dthrsitbxoper", new StringValue("X(26)"));
        Mainframe.put("qtpgtoparcial", new LongValue("9(4)"));
        Mainframe.put("vlsaldottl", new MoneyValue("R$ 9(17)v99"));
        Mainframe.put("sittitpagto", new StringValue("X(120)"));
        Mainframe.put("sitcancbxoper", new StringValue("X(20)"));
        Mainframe.put("dthrcancbxoper", new StringValue("X(26)"));        
        Mainframe.put("sittitulo", new StringValue("X(120)"));
       
    	 Mainframe.put("tpPessoaPort", new StringValue("X(10)"));
    	 Mainframe.put("cpfCnpjPortador", new StringValue("X(14)"));
    	 Mainframe.put("coPagtoTitulo", new StringValue("X(50)"));
    	
    	
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }


}
