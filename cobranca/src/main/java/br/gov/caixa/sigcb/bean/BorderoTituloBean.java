//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

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
import br.gov.caixa.sigcb.util.LogUtilSigcb;

public class BorderoTituloBean extends SigcbBean {
    private br.com.politec.sao.util.Money abatimento;
    
    private br.com.politec.sao.util.Money retidoValorIOF;

    private java.lang.String bairroSacado;

    private java.lang.Long cepSacado;

    private java.lang.Long codigoBordero;

    private java.lang.Long codigoCedente;

    private java.lang.String codigoUsuario;

    private java.lang.String complSacado;

    private java.lang.Long cpfCnpjSacado;

    private java.lang.Long cpfCnpjSacador;

    private java.util.Date dataDocumento;

    private java.lang.String dataVencimento;

    private java.lang.String emailSacado;

    private java.lang.Long emissaoBloqueto;

    private java.lang.String enderecoSacado;

    private java.lang.String endosso;

    private java.lang.Long envioBloqueto;

    private java.lang.Long modalidadeTitulo;

    private java.lang.String municipioSacado;

    private java.lang.Long navegacao;

    private java.lang.String nomeSacado;

    private java.lang.String nomeSacadorAvalista;

    private java.lang.Long nossoNumero;

    private java.lang.String numeroDocumento;

    private java.lang.String numeroSacado;

    private java.lang.Long numeroSequencial;

    private java.lang.Long registro;

    private java.lang.Long situacao;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoPessoaSacado;

    private java.lang.Long tipoPessoaSacador;

    private java.lang.Long titulosIncluidos;

    private java.lang.Long totalTitulos;

    private java.lang.String ufSacado;
    
    private String somenteProtesto;
    
    private java.lang.Long dddSMS;
    
    private java.lang.Long celularSMS;
    
    private String tipoSMS;

    private br.com.politec.sao.util.Money valorTitulo;

    private br.com.politec.sao.util.Money valorTitulosIncluidos;

    private br.com.politec.sao.util.Money valorTotalBordero;
    
    
    private String indRegCip;
    private String tipoPgto;
    private Money valorMaxPgto;
    private String icParcial;
    private Money valorMinPgto;
    private Long qtdePossivel;

    public BorderoTituloBean() {
        this.abatimento = null;
        this.retidoValorIOF = null;
        this.bairroSacado = null;
        this.cepSacado = null;
        this.codigoBordero = null;
        this.codigoCedente = null;
        this.codigoUsuario = null;
        this.complSacado = null;
        this.cpfCnpjSacado = null;
        this.cpfCnpjSacador = null;
        this.dataDocumento = null;
        this.dataVencimento = null;
        this.emailSacado = null;
        this.emissaoBloqueto = null;
        this.enderecoSacado = null;
        this.endosso = null;
        this.envioBloqueto = null;
        this.modalidadeTitulo = null;
        this.municipioSacado = null;
        this.navegacao = null;
        this.nomeSacado = null;
        this.nomeSacadorAvalista = null;
        this.nossoNumero = null;
        this.numeroDocumento = null;
        this.numeroSacado = null;
        this.numeroSequencial = null;
        this.registro = null;
        this.situacao = null;
        this.tipoAcao = null;
        this.tipoPessoaSacado = null;
        this.tipoPessoaSacador = null;
        this.titulosIncluidos = null;
        this.totalTitulos = null;
        this.ufSacado = null;
        this.valorTitulo = null;
        this.valorTitulosIncluidos = null;
        this.valorTotalBordero = null;
        this.somenteProtesto = null;
        this.dddSMS=null;
        this.celularSMS=null;
        this.tipoSMS=null;
        
        this.indRegCip=null;
        this.tipoPgto=null;
        this.valorMaxPgto=null;
        this.icParcial=null;
        this.valorMinPgto=null;
        this.qtdePossivel=null;
        
        
        
    }
    
    

    public String getIndRegCip() {
		return indRegCip;
	}



	public void setIndRegCip(String indRegCip) {
		this.indRegCip = indRegCip;
	}



	public String getTipoPgto() {
		return tipoPgto;
	}



	public void setTipoPgto(String tipoPgto) {
		this.tipoPgto = tipoPgto;
	}



	public Money getValorMaxPgto() {
		return valorMaxPgto;
	}



	public void setValorMaxPgto(Money valorMaxPgto) {
		this.valorMaxPgto = valorMaxPgto;
	}



	public String getIcParcial() {
		return icParcial;
	}



	public void setIcParcial(String icParcial) {
		this.icParcial = icParcial;
	}



	public Money getValorMinPgto() {
		return valorMinPgto;
	}



	public void setValorMinPgto(Money valorMinPgto) {
		this.valorMinPgto = valorMinPgto;
	}



	public Long getQtdePossivel() {
		return qtdePossivel;
	}



	public void setQtdePossivel(Long qtdePossivel) {
		this.qtdePossivel = qtdePossivel;
	}



	public String getApplicationName() {
        return "BorderoTituloBean";
    }

    public br.com.politec.sao.util.Money getAbatimento() {
        return this.abatimento;
    }

    public void setAbatimento(br.com.politec.sao.util.Money abatimento) {
        this.abatimento = abatimento;
    }
    
    public br.com.politec.sao.util.Money getRetidoValorIOF() {
        return this.retidoValorIOF;
    }

    public void setRetidoValorIOF(br.com.politec.sao.util.Money retidoValorIOF) {
        this.retidoValorIOF = retidoValorIOF;
    }

 

	public java.lang.Long getDddSMS() {
		return dddSMS;
	}

	public void setDddSMS(java.lang.Long dddSMS) {
		this.dddSMS = dddSMS;
	}

	public java.lang.Long getCelularSMS() {
		return celularSMS;
	}

	public void setCelularSMS(java.lang.Long celularSMS) {
		this.celularSMS = celularSMS;
	}

	public String getTipoSMS() {
		return tipoSMS;
	}

	public void setTipoSMS(String tipoSMS) {
		this.tipoSMS = tipoSMS;
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
    public java.lang.Long getCodigoBordero() {
        return this.codigoBordero;
    }

    public void setCodigoBordero(java.lang.Long codigoBordero) {
        this.codigoBordero = codigoBordero;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.String getComplSacado() {
        return this.complSacado;
    }

    public void setComplSacado(java.lang.String complSacado) {
        this.complSacado = complSacado;
    }

    
    
    public String getSomenteProtesto() {
		return somenteProtesto;
	}

	public void setSomenteProtesto(String somenteProtesto) {
		this.somenteProtesto = somenteProtesto;
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

    // ------------------------CpfCnpjSacador----------------------------
    public java.lang.Long getCpfCnpjSacador() {
        return this.cpfCnpjSacador;
    }

    public java.lang.String getCpfCnpjSacadorFormatado() {
        String cpfCnpjTexto = "";
        LogUtilSigcb.debug("this.getCpfCnpjSacador()    -> "
                           + "'"
                           + this.getCpfCnpjSacador()
                           + "'");
        LogUtilSigcb.debug("this.getTipoPessoaSacador() -> "
                           + "'"
                           + this.getTipoPessoaSacador()
                           + "'");
        if (this.getCpfCnpjSacador() == null
            || this.getCpfCnpjSacador().equals(new Long(0))) {
            return "";
        }
        if (this.getTipoPessoaSacador().equals(new Long(1))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjSacador()
                    .toString(), 11);
        } else if (this.getTipoPessoaSacador().equals(new Long(2))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjSacador()
                    .toString(), 14);
        }
        cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        LogUtilSigcb.debug("getCpfCnpjSacadorFormatado -> "
                           + "'"
                           + cpfCnpjTexto
                           + "'");
        return cpfCnpjTexto;
    }

    public void setCpfCnpjSacador(java.lang.Long cpfCnpjSacador) {
        this.cpfCnpjSacador = cpfCnpjSacador;
    }

    // ------------------------DataDocumento----------------------------
    public java.util.Date getDataDocumento() {
        return this.dataDocumento;
    }

    public java.lang.String getDataDocumentoFormatada() {
        if (this.dataDocumento != null) {
            return Formatador.formatarData(this.dataDocumento);
        } else {
            return "";
        }
    }

    public void setDataDocumento(java.util.Date dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    // ------------------------DataVencimento----------------------------
    public java.lang.String getDataVencimento() {
        return this.dataVencimento;
    }

    public java.lang.String getDataVencimentoFormatada() {
        if (this.dataVencimento != null && this.dataVencimento.length() == 10) {
            return Formatacao.colocaBarrasData(Formatacao.removeBarrasData(this.dataVencimento));
        } else {
            return "";
        }
    }

    public void setDataVencimento(java.lang.String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    // --------------------------------------------------------------------
    public java.lang.String getEmailSacado() {
        return this.emailSacado;
    }

    public void setEmailSacado(java.lang.String emailSacado) {
        this.emailSacado = emailSacado;
    }

    public java.lang.Long getEmissaoBloqueto() {
        return this.emissaoBloqueto;
    }

    public void setEmissaoBloqueto(java.lang.Long emissaoBloqueto) {
        this.emissaoBloqueto = emissaoBloqueto;
    }

    public java.lang.String getEnderecoSacado() {
        return this.enderecoSacado;
    }

    public void setEnderecoSacado(java.lang.String enderecoSacado) {
        this.enderecoSacado = enderecoSacado;
    }

    public java.lang.String getEndosso() {
        return this.endosso;
    }

    public void setEndosso(java.lang.String endosso) {
        this.endosso = endosso;
    }

    public java.lang.Long getEnvioBloqueto() {
        return this.envioBloqueto;
    }

    public void setEnvioBloqueto(java.lang.Long envioBloqueto) {
        this.envioBloqueto = envioBloqueto;
    }

    public java.lang.Long getModalidadeTitulo() {
        return this.modalidadeTitulo;
    }

    public void setModalidadeTitulo(java.lang.Long modalidadeTitulo) {
        this.modalidadeTitulo = modalidadeTitulo;
    }

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

    public java.lang.String getNomeSacado() {
        return this.nomeSacado;
    }

    public void setNomeSacado(java.lang.String nomeSacado) {
        this.nomeSacado = nomeSacado;
    }

    public java.lang.String getNomeSacadorAvalista() {
        return this.nomeSacadorAvalista;
    }

    public void setNomeSacadorAvalista(java.lang.String nomeSacadorAvalista) {
        this.nomeSacadorAvalista = nomeSacadorAvalista;
    }

    public java.lang.Long getNossoNumero() {
        return this.nossoNumero;
    }

    public void setNossoNumero(java.lang.Long nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public java.lang.String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public void setNumeroDocumento(java.lang.String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public java.lang.String getNumeroSacado() {
        return this.numeroSacado;
    }

    public void setNumeroSacado(java.lang.String numeroSacado) {
        this.numeroSacado = numeroSacado;
    }

    public java.lang.Long getNumeroSequencial() {
        return this.numeroSequencial;
    }

    public void setNumeroSequencial(java.lang.Long numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    public java.lang.Long getRegistro() {
        return this.registro;
    }

    public void setRegistro(java.lang.Long registro) {
        this.registro = registro;
    }

    public java.lang.Long getSituacao() {
        return this.situacao;
    }

    public void setSituacao(java.lang.Long situacao) {
        this.situacao = situacao;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
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

    // ------------------------TipoPessoaSacador----------------------------
    public java.lang.Long getTipoPessoaSacador() {
        return this.tipoPessoaSacador;
    }

    public java.lang.String getTipoPessoaSacadorTexto() {
        String tipoPessoaTexto = "";

        if (this.getTipoPessoaSacador().equals(new Long(1))) {
            tipoPessoaTexto = "FISICA";
        } else if (this.getTipoPessoaSacador().equals(new Long(2))) {
            tipoPessoaTexto = "JURIDICA";
        } else {
            tipoPessoaTexto = "";
        }
        return tipoPessoaTexto;
    }

    public void setTipoPessoaSacador(java.lang.Long tipoPessoaSacador) {
        this.tipoPessoaSacador = tipoPessoaSacador;
    }

    // ---------------------------------------------------------------------
    public java.lang.Long getTitulosIncluidos() {
        return this.titulosIncluidos;
    }

    public void setTitulosIncluidos(java.lang.Long titulosIncluidos) {
        this.titulosIncluidos = titulosIncluidos;
    }

    public java.lang.Long getTotalTitulos() {
        return this.totalTitulos;
    }

    public void setTotalTitulos(java.lang.Long totalTitulos) {
        this.totalTitulos = totalTitulos;
    }

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

    public br.com.politec.sao.util.Money getValorTitulosIncluidos() {
        return this.valorTitulosIncluidos;
    }

    public void setValorTitulosIncluidos(br.com.politec.sao.util.Money valorTitulosIncluidos) {
        this.valorTitulosIncluidos = valorTitulosIncluidos;
    }

    public br.com.politec.sao.util.Money getValorTotalBordero() {
        return this.valorTotalBordero;
    }

    public void setValorTotalBordero(br.com.politec.sao.util.Money valorTotalBordero) {
        this.valorTotalBordero = valorTotalBordero;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getNossoNumeroFormatado-----------------------
    public java.lang.String getNossoNumeroFormatado() {
        String nossoNumeroFormatado = Formatador.formatarNossoNumero18(this.nossoNumero);
        return nossoNumeroFormatado;
    }

    // fim-------------getNossoNumeroFormatado-----------------------

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            BorderoTituloBean other = (BorderoTituloBean) obj;
            result = result && equals(getAbatimento(), other.getAbatimento());
            result = result && equals(getRetidoValorIOF(), other.getRetidoValorIOF());
            result = result
                     && equals(getBairroSacado(), other.getBairroSacado());
            result = result && equals(getCepSacado(), other.getCepSacado());
            result = result
                     && equals(getCodigoBordero(), other.getCodigoBordero());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getComplSacado(), other.getComplSacado());
            result = result
                     && equals(getCpfCnpjSacado(), other.getCpfCnpjSacado());
            result = result
                     && equals(getCpfCnpjSacador(), other.getCpfCnpjSacador());
            result = result
                     && equals(getDataDocumento(), other.getDataDocumento());
            result = result
                     && equals(getDataVencimento(), other.getDataVencimento());
            result = result && equals(getEmailSacado(), other.getEmailSacado());
            result = result
                     && equals(getEmissaoBloqueto(), other.getEmissaoBloqueto());
            result = result
                     && equals(getEnderecoSacado(), other.getEnderecoSacado());
            result = result && equals(getEndosso(), other.getEndosso());
            result = result
                     && equals(getEnvioBloqueto(), other.getEnvioBloqueto());
            result = result
                     && equals(getModalidadeTitulo(),
                             other.getModalidadeTitulo());
            result = result
                     && equals(getMunicipioSacado(), other.getMunicipioSacado());
            result = result && equals(getNavegacao(), other.getNavegacao());
            result = result && equals(getNomeSacado(), other.getNomeSacado());
            result = result
                     && equals(getNomeSacadorAvalista(),
                             other.getNomeSacadorAvalista());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result
                     && equals(getNumeroDocumento(), other.getNumeroDocumento());
            result = result
                     && equals(getNumeroSacado(), other.getNumeroSacado());
            result = result
                     && equals(getNumeroSequencial(),
                             other.getNumeroSequencial());
            result = result && equals(getRegistro(), other.getRegistro());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoPessoaSacado(),
                             other.getTipoPessoaSacado());
            result = result
                     && equals(getTipoPessoaSacador(),
                             other.getTipoPessoaSacador());
            result = result
                     && equals(getTitulosIncluidos(),
                             other.getTitulosIncluidos());
            result = result
                     && equals(getTotalTitulos(), other.getTotalTitulos());
            result = result && equals(getUfSacado(), other.getUfSacado());
            result = result && equals(getValorTitulo(), other.getValorTitulo());
            result = result && equals(getSomenteProtesto(), other.getSomenteProtesto());
            result = result && equals(getDddSMS(), other.getDddSMS());
            result = result && equals(getCelularSMS(), other.getCelularSMS());
            result = result && equals(getTipoSMS(), other.getTipoSMS());
            result = result
                     && equals(getValorTitulosIncluidos(),
                             other.getValorTitulosIncluidos());
            result = result
                     && equals(getValorTotalBordero(),
                             other.getValorTotalBordero());
            
            result = result && equals(getIndRegCip(), other.getIndRegCip());
            result = result && equals(getTipoPgto(), other.getTipoPgto());
            result = result && equals(getValorMaxPgto(), other.getValorMaxPgto());
            result = result && equals(getIcParcial(), other.getIcParcial());
            result = result && equals(getValorMinPgto(), other.getValorMinPgto());
            result = result && equals(getQtdePossivel(), other.getQtdePossivel());
            
            
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
        properties.add(new Property("abatimento",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("retidoValorIOF",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("bairroSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cepSacado", LongType.create(), false, true));
        properties.add(new Property("codigoBordero",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("complSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpjSacado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpjSacador",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dataDocumento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataVencimento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("emailSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("somenteProtesto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("emissaoBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("enderecoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("endosso", StringType.create(), false, true));
        properties.add(new Property("envioBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("modalidadeTitulo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("municipioSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("navegacao", LongType.create(), false, true));
        properties.add(new Property("nomeSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeSacadorAvalista",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nossoNumero",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroDocumento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroSequencial",
                LongType.create(),
                false,
                true));
        properties.add(new Property("registro", LongType.create(), false, true));
        properties.add(new Property("situacao", LongType.create(), false, true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoaSacado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoaSacador",
                LongType.create(),
                false,
                true));
        properties.add(new Property("titulosIncluidos",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalTitulos",
                LongType.create(),
                false,
                true));
        properties.add(new Property("ufSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dddSMS",
                LongType.create(),
                false,
                true));
        properties.add(new Property("celularSMS",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoSMS",
                StringType.create(),
                false,
                true));
        properties.add(new Property("valorTitulo",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTitulosIncluidos",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTotalBordero",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("indRegCip",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoPgto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("icParcial",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("valorMaxPgto",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorMinPgto",
                MoneyType.create(),
                false,
                true));
        
        properties.add(new Property("qtdePossivel",
                LongType.create(),
                false,
                true));

        
        
        Layout result = new Layout(properties,
                "BorderoTituloBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("numeroDocumento", new StringValue("X(15)"));
        Mainframe.put("numeroSequencial", new LongValue("9(02)"));
        Mainframe.put("valorTitulo", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("emailSacado", new StringValue("X(50)"));
        Mainframe.put("totalTitulos", new LongValue("9(02)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        Mainframe.put("cepSacado", new LongValue("9(08)"));
        Mainframe.put("nomeSacado", new StringValue("X(40)"));
        Mainframe.put("cpfCnpjSacador", new LongValue("9(14)"));
        Mainframe.put("nomeSacadorAvalista", new StringValue("X(40)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("navegacao", new LongValue("9(01)"));
        Mainframe.put("valorTotalBordero", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("registro", new LongValue("9(04)"));
        Mainframe.put("endosso", new StringValue("X(01)"));
        Mainframe.put("tipoPessoaSacador", new LongValue("9(01)"));
        Mainframe.put("bairroSacado", new StringValue("X(25)"));
        Mainframe.put("numeroSacado", new StringValue("X(15)"));
        Mainframe.put("valorTitulosIncluidos", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("codigoBordero", new LongValue("9(07)"));
        Mainframe.put("dataDocumento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("emissaoBloqueto", new LongValue("9(02)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("modalidadeTitulo", new LongValue("9(02)"));
        Mainframe.put("ufSacado", new StringValue("X(02)"));
        Mainframe.put("municipioSacado", new StringValue("X(35)"));
        Mainframe.put("cpfCnpjSacado", new LongValue("9(14)"));
        Mainframe.put("enderecoSacado", new StringValue("X(40)"));
        Mainframe.put("titulosIncluidos", new LongValue("9(02)"));
        Mainframe.put("complSacado", new StringValue("X(25)"));
        Mainframe.put("abatimento", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("tipoPessoaSacado", new LongValue("9(01)"));
        Mainframe.put("situacao", new LongValue("9(01)"));
        Mainframe.put("dataVencimento", new StringValue("X(10)"));
        Mainframe.put("envioBloqueto", new LongValue("9(02)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("somenteProtesto", new StringValue("X(01)"));
        Mainframe.put("tipoSMS", new StringValue("X(02)"));
        Mainframe.put("dddSMS", new LongValue("9(02)"));
        Mainframe.put("celularSMS", new LongValue("9(09)"));
        Mainframe.put("retidoValorIOF", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("indRegCip", new StringValue("X(01)"));
        Mainframe.put("tipoPgto", new StringValue("X(01)"));
        Mainframe.put("icParcial", new StringValue("X(01)"));
        Mainframe.put("valorMaxPgto", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorMinPgto", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("qtdePossivel", new LongValue("9(02)"));
        
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
