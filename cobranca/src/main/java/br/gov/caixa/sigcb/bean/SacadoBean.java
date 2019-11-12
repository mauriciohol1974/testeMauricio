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
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.util.Formatador;

public class SacadoBean extends SigcbBean {
    private java.lang.String bairroSacado;

    private java.lang.Long cepSacado;

    private java.lang.Long codigoBancoSacado;

    private java.lang.Long codigoCedente;

    private java.lang.String codigoSacado;

    private java.lang.String complementoSacado;

    private java.lang.Long cpfCnpjResponsavel;

    private java.lang.Long cpfCnpjSacado;

    private java.lang.String emailSacado;

    private java.lang.String enderecoSacado;

    private java.lang.Long envioBloqueto;

    private java.lang.String envioBloquetoTexto;

    private java.lang.Long meioEntrada;

    private java.lang.Long moeda;

    private java.lang.String municipioSacado;

    private java.lang.Long navegacao;

    private java.lang.String nomeBancoSacado;

    private java.lang.String nomeResponsavel;

    private java.lang.String nomeSacado;

    private java.lang.String numeroEnderecoSacado;

    private java.lang.Long registro;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoPessoaResponsavel;

    private java.lang.Long tipoPessoaSacado;

    private java.lang.String ufSacado;

    private br.com.politec.sao.util.Money valorTitulo;

    private java.lang.String codigoUsuario;
    
    private String tipoSMS;
    
    private String celularSMS;
    
    private String dddSMS;
    
    public SacadoBean() {
        this.bairroSacado = null;
        this.cepSacado = null;
        this.codigoBancoSacado = null;
        this.codigoCedente = null;
        this.codigoSacado = null;
        this.complementoSacado = null;
        this.cpfCnpjResponsavel = null;
        this.cpfCnpjSacado = null;
        this.emailSacado = null;
        this.enderecoSacado = null;
        this.envioBloqueto = null;
        this.envioBloquetoTexto = null;
        this.meioEntrada = null;
        this.moeda = null;
        this.municipioSacado = null;
        this.navegacao = null;
        this.nomeBancoSacado = null;
        this.nomeResponsavel = null;
        this.nomeSacado = null;
        this.numeroEnderecoSacado = null;
        this.registro = null;
        this.tipoAcao = null;
        this.tipoPessoaResponsavel = null;
        this.tipoPessoaSacado = null;
        this.ufSacado = null;
        this.valorTitulo = null;
        this.codigoUsuario = null;
        this.tipoSMS=null;
        this.celularSMS=null;
        this.dddSMS=null;
    }

    public String getApplicationName() {
        return "SacadoBean";
    }

    public java.lang.String getBairroSacado() {
        return this.bairroSacado;
    }

    public void setBairroSacado(java.lang.String bairroSacado) {
        this.bairroSacado = bairroSacado;
    }

    // ------------------------CepSacado----------------------------
    public java.lang.Long getCepSacado() {
        return this.cepSacado;
    }

    public String getCepSacadoFormatado() {
        String cepTexto = "";
        cepTexto = Formatador.formatarCep(this.getCepSacado().toString());
        return cepTexto;
    }

    public void setCepSacado(java.lang.Long cepSacado) {
        this.cepSacado = cepSacado;
    }

    // -------------------------------------------------------------
    public java.lang.Long getCodigoBancoSacado() {
        return this.codigoBancoSacado;
    }

    public void setCodigoBancoSacado(java.lang.Long codigoBancoSacado) {
        this.codigoBancoSacado = codigoBancoSacado;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.String getCodigoSacado() {
        return this.codigoSacado;
    }

    public void setCodigoSacado(java.lang.String codigoSacado) {
        this.codigoSacado = codigoSacado;
    }

    public java.lang.String getComplementoSacado() {
        return this.complementoSacado;
    }

    public void setComplementoSacado(java.lang.String complementoSacado) {
        this.complementoSacado = complementoSacado;
    }
    
    

    public String getTipoSMS() {
		return tipoSMS;
	}

	public void setTipoSMS(String tipoSMS) {
		this.tipoSMS = tipoSMS;
	}

	

	public String getCelularSMS() {
		return celularSMS;
	}

	public void setCelularSMS(String celularSMS) {
		this.celularSMS = celularSMS;
	}

	public String getDddSMS() {
		return dddSMS;
	}

	public void setDddSMS(String dddSMS) {
		this.dddSMS = dddSMS;
	}

	// ------------------------CpfCnpjResponsavel-----------------------
    public java.lang.Long getCpfCnpjResponsavel() {
        return this.cpfCnpjResponsavel;
    }

    public java.lang.String getCpfCnpjResponsavelFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoaResponsavel().equals(new Long(1))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjResponsavel()
                    .toString(),
                    11);
        } else if (this.getTipoPessoaResponsavel().equals(new Long(2))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjResponsavel()
                    .toString(),
                    14);
        }
        cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        return cpfCnpjTexto;
    }

    public void setCpfCnpjResponsavel(java.lang.Long cpfCnpjResponsavel) {
        this.cpfCnpjResponsavel = cpfCnpjResponsavel;
    }

    // ------------------------CpfCnpjSacado----------------------------
    public java.lang.Long getCpfCnpjSacado() {
        return this.cpfCnpjSacado;
    }

    public java.lang.String getCpfCnpjSacadoFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoaSacado().equals(new Long(1))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjSacado()
                    .toString(), 11);
        } else if (this.getTipoPessoaSacado().equals(new Long(2))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjSacado()
                    .toString(), 14);
        }
        cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        return cpfCnpjTexto;
    }

    public void setCpfCnpjSacado(java.lang.Long cpfCnpjSacado) {
        this.cpfCnpjSacado = cpfCnpjSacado;
    }

    // -----------------------------------------------------------------
    public java.lang.String getEmailSacado() {
        return this.emailSacado;
    }

    public void setEmailSacado(java.lang.String emailSacado) {
        this.emailSacado = emailSacado;
    }

    public java.lang.String getEnderecoSacado() {
        return this.enderecoSacado;
    }

    public void setEnderecoSacado(java.lang.String enderecoSacado) {
        this.enderecoSacado = enderecoSacado;
    }

    public java.lang.Long getEnvioBloqueto() {
        return this.envioBloqueto;
    }

    public void setEnvioBloqueto(java.lang.Long envioBloqueto) {
        this.envioBloqueto = envioBloqueto;
    }

    public java.lang.String getEnvioBloquetoTexto() {
        return this.envioBloquetoTexto;
    }

    public void setEnvioBloquetoTexto(java.lang.String envioBloquetoTexto) {
        this.envioBloquetoTexto = envioBloquetoTexto;
    }

    public java.lang.Long getMeioEntrada() {
        return this.meioEntrada;
    }

    public void setMeioEntrada(java.lang.Long meioEntrada) {
        this.meioEntrada = meioEntrada;
    }

    // ------------------------Moeda---------------------------------------
    public java.lang.Long getMoeda() {
        return this.moeda;
    }

    public java.lang.String getMoedaTexto() {
        String moedaTexto = "";

        switch (getMoeda().intValue()) {
        case 9:
            moedaTexto = "REAL";
            break;
        }
        return moedaTexto;
    }

    public void setMoeda(java.lang.Long moeda) {
        this.moeda = moeda;
    }

    // --------------------------------------------------------------------
    public java.lang.String getMunicipioSacado() {
        return this.municipioSacado;
    }

    public void setMunicipioSacado(java.lang.String municipioSacado) {
        this.municipioSacado = municipioSacado;
    }

    public java.lang.Long getNavegacao() {
        return this.navegacao;
    }

    public void setNavegacao(java.lang.Long navegacao) {
        this.navegacao = navegacao;
    }

    public java.lang.String getNomeBancoSacado() {
        return this.nomeBancoSacado;
    }

    public void setNomeBancoSacado(java.lang.String nomeBancoSacado) {
        this.nomeBancoSacado = nomeBancoSacado;
    }

    public java.lang.String getNomeResponsavel() {
        return this.nomeResponsavel;
    }

    public void setNomeResponsavel(java.lang.String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public java.lang.String getNomeSacado() {
        return this.nomeSacado;
    }

    public void setNomeSacado(java.lang.String nomeSacado) {
        this.nomeSacado = nomeSacado;
    }

    public java.lang.String getNumeroEnderecoSacado() {
        return this.numeroEnderecoSacado;
    }

    public void setNumeroEnderecoSacado(java.lang.String numeroEnderecoSacado) {
        this.numeroEnderecoSacado = numeroEnderecoSacado;
    }

    public java.lang.Long getRegistro() {
        return this.registro;
    }

    public void setRegistro(java.lang.Long registro) {
        this.registro = registro;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    // ------------------------TipoPessoaResponsavel----------------------------
    public java.lang.Long getTipoPessoaResponsavel() {
        return this.tipoPessoaResponsavel;
    }

    public java.lang.String getTipoPessoaResponsavelTexto() {
        String tipoPessoaTexto = "";

        if (this.getTipoPessoaResponsavel().equals(new Long(1))) {
            tipoPessoaTexto = "FISICA";
        } else if (this.getTipoPessoaResponsavel().equals(new Long(2))) {
            tipoPessoaTexto = "JURIDICA";
        } else {
            tipoPessoaTexto = "";
        }
        return tipoPessoaTexto;
    }

    public void setTipoPessoaResponsavel(java.lang.Long tipoPessoaResponsavel) {
        this.tipoPessoaResponsavel = tipoPessoaResponsavel;
    }

    // ------------------------TipoPessoaSacado----------------------------
    public java.lang.Long getTipoPessoaSacado() {
        return this.tipoPessoaSacado;
    }

    public java.lang.String getTipoPessoaSacadoTexto() {
        String tipoPessoaTexto = "";

        if (this.getTipoPessoaSacado().equals(new Long(1))) {
            tipoPessoaTexto = "FISICA";
        } else if (this.getTipoPessoaSacado().equals(new Long(2))) {
            tipoPessoaTexto = "JURIDICA";
        } else {
            tipoPessoaTexto = "";
        }
        return tipoPessoaTexto;
    }

    public void setTipoPessoaSacado(java.lang.Long tipoPessoaSacado) {
        this.tipoPessoaSacado = tipoPessoaSacado;
    }

    // --------------------------------------------------------------------
    public java.lang.String getUfSacado() {
        return this.ufSacado;
    }

    public void setUfSacado(java.lang.String ufSacado) {
        this.ufSacado = ufSacado;
    }

    public br.com.politec.sao.util.Money getValorTitulo() {
        return this.valorTitulo;
    }

    public void setValorTitulo(br.com.politec.sao.util.Money valorTitulo) {
        this.valorTitulo = valorTitulo;
    }
    
    public java.lang.String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(java.lang.String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
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
            SacadoBean other = (SacadoBean) obj;
            result = result
                     && equals(getBairroSacado(), other.getBairroSacado());
            result = result && equals(getCepSacado(), other.getCepSacado());
            result = result
                     && equals(getCodigoBancoSacado(),
                             other.getCodigoBancoSacado());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoSacado(), other.getCodigoSacado());
            result = result
                     && equals(getComplementoSacado(),
                             other.getComplementoSacado());
            result = result
                     && equals(getCpfCnpjResponsavel(),
                             other.getCpfCnpjResponsavel());
            result = result
                     && equals(getCpfCnpjSacado(), other.getCpfCnpjSacado());
            result = result && equals(getEmailSacado(), other.getEmailSacado());
            result = result
                     && equals(getEnderecoSacado(), other.getEnderecoSacado());
            result = result
                     && equals(getEnvioBloqueto(), other.getEnvioBloqueto());
            result = result
                     && equals(getEnvioBloquetoTexto(),
                             other.getEnvioBloquetoTexto());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result && equals(getMoeda(), other.getMoeda());
            result = result
                     && equals(getMunicipioSacado(), other.getMunicipioSacado());
            result = result && equals(getNavegacao(), other.getNavegacao());
            result = result
                     && equals(getNomeBancoSacado(), other.getNomeBancoSacado());
            result = result
                     && equals(getNomeResponsavel(), other.getNomeResponsavel());
            result = result && equals(getNomeSacado(), other.getNomeSacado());
            result = result
                     && equals(getNumeroEnderecoSacado(),
                             other.getNumeroEnderecoSacado());
            result = result && equals(getRegistro(), other.getRegistro());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoPessoaResponsavel(),
                             other.getTipoPessoaResponsavel());
            result = result
                     && equals(getTipoPessoaSacado(),
                             other.getTipoPessoaSacado());
            result = result && equals(getUfSacado(), other.getUfSacado());
            result = result && equals(getValorTitulo(), other.getValorTitulo());
            result = result && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getTipoSMS(), other.getTipoSMS());
            result = result && equals(getCelularSMS(), other.getCelularSMS());
            result = result && equals(getDddSMS(), other.getDddSMS());
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
        properties.add(new Property("bairroSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cepSacado", LongType.create(), false, true));
        properties.add(new Property("codigoBancoSacado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("complementoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpjResponsavel",
                LongType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpjSacado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("emailSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("enderecoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("envioBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("envioBloquetoTexto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("meioEntrada",
                LongType.create(),
                false,
                true));
        properties.add(new Property("moeda", LongType.create(), false, true));
        properties.add(new Property("municipioSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("navegacao", LongType.create(), false, true));
        properties.add(new Property("nomeBancoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeResponsavel",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroEnderecoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("registro", LongType.create(), false, true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoaResponsavel",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoaSacado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("ufSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("valorTitulo",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoSMS",
                StringType.create(),
                false,
                true));
        properties.add(new Property("celularSMS",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("dddSMS",
        		StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "SacadoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("valorTitulo", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("emailSacado", new StringValue("X(50)"));
        Mainframe.put("cepSacado", new LongValue("9(08)"));
        Mainframe.put("nomeBancoSacado", new StringValue("X(20)"));
        Mainframe.put("nomeSacado", new StringValue("X(40)"));
        Mainframe.put("numeroEnderecoSacado", new StringValue("X(15)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("navegacao", new LongValue("9(01)"));
        Mainframe.put("codigoSacado", new StringValue("X(15)"));
        Mainframe.put("nomeResponsavel", new StringValue("X(40)"));
        Mainframe.put("registro", new LongValue("9(04)"));
        Mainframe.put("moeda", new LongValue("9(03)"));
        Mainframe.put("bairroSacado", new StringValue("X(25)"));
        Mainframe.put("codigoBancoSacado", new LongValue("9(03)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("ufSacado", new StringValue("X(02)"));
        Mainframe.put("municipioSacado", new StringValue("X(35)"));
        Mainframe.put("cpfCnpjSacado", new LongValue("9(14)"));
        Mainframe.put("enderecoSacado", new StringValue("X(40)"));
        Mainframe.put("tipoPessoaResponsavel", new LongValue("9(01)"));
        Mainframe.put("meioEntrada", new LongValue("9(02)"));
        Mainframe.put("tipoPessoaSacado", new LongValue("9(01)"));
        Mainframe.put("envioBloqueto", new LongValue("9(02)"));
        Mainframe.put("cpfCnpjResponsavel", new LongValue("9(14)"));
        Mainframe.put("complementoSacado", new StringValue("X(25)"));
        Mainframe.put("envioBloquetoTexto", new StringValue("X(40)"));
        Mainframe.put("codigoUsuario", new StringValue("X(8)"));
        Mainframe.put("tipoSMS", new StringValue("X(1)"));
        Mainframe.put("dddSMS", new StringValue("X(02)"));
        Mainframe.put("celularSMS", new StringValue("X(09)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
