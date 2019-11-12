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
import br.gov.caixa.sigcb.util.Formatador;

public class ProtestoTituloBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidadePv;
    
    private java.lang.String codigoUsuario;
    
    private java.lang.String nomeGrupo;

    private java.lang.Long cpfCnpj;

    private java.util.Date data;

    private java.util.Date dataEnvioProtesto;

    private java.util.Date dataProtocolo;

    private java.lang.Long diaProtesto;
    
    private java.util.Date dataSolicitacao;

    private java.lang.String especieTitulo;

    private java.lang.String modalidade;

    private java.lang.String nomeDevedor;

    private java.lang.String nomeUnidadePv;
    
    private java.lang.Long nossoNumero;

    private java.lang.Long numeroCartorio;
    
    private java.lang.Long totalRegistros;

    private java.lang.String protocolo;

    private java.lang.Long quantidadeTotalTitulo;
    
    private java.lang.Boolean selecaoCheck;
    
    private java.lang.Long selecaoRadio;

    private java.lang.String seuNumero;
    
    private java.lang.String strRecordset;

    private java.lang.Long tipoConsulta;
    
    private java.lang.Long opcao;

    private java.lang.Long tipoPessoa;
    
    private java.lang.Long pvCobrador;

    private br.com.politec.sao.util.Money valorCusta;
    
    private br.com.politec.sao.util.Money valorTitulo;

    private br.com.politec.sao.util.Money valorTotalTitulo;
    
    private java.lang.Long filtroSelecao;
    
    private String parcela;
    

    public ProtestoTituloBean() {
        this.codigoCedente = null;
        this.codigoUnidadePv = null;
        this.codigoUsuario = null;
        this.nomeGrupo = null;
        this.cpfCnpj = null;
        this.data = null;
        this.dataSolicitacao = null;
        this.dataEnvioProtesto = null;
        this.dataProtocolo = null;
        this.diaProtesto = null;
        this.especieTitulo = null;
        this.modalidade = null;
        this.nomeDevedor = null;
        this.nomeUnidadePv = null;
        this.nossoNumero = null;
        this.numeroCartorio = null;
        this.totalRegistros = null;
        this.protocolo = null;
        this.quantidadeTotalTitulo = null;
        this.selecaoCheck = null;
        this.selecaoRadio = null;
        this.strRecordset = null;
        this.seuNumero = null;
        this.tipoConsulta = null;
        this.opcao = null;
        this.tipoPessoa = null;
        this.pvCobrador = null;
        this.valorCusta = null;
        this.valorTitulo = null;
        this.valorTotalTitulo = null;
        this.filtroSelecao = null;
        this.parcela=null;
    }

    public String getApplicationName() {
        return "ProtestoTituloBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoUnidadePv() {
        return this.codigoUnidadePv;
    }

    public void setCodigoUnidadePv(java.lang.Long codigoUnidadePv) {
        this.codigoUnidadePv = codigoUnidadePv;
    }
    
    public java.lang.String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(java.lang.String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	public java.lang.String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(java.lang.String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.util.Date getData() {
        return this.data;
    }

    public void setData(java.util.Date data) {
        this.data = data;
    }
    
    public java.util.Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(java.util.Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public java.util.Date getDataEnvioProtesto() {
        return this.dataEnvioProtesto;
    }

    public void setDataEnvioProtesto(java.util.Date dataEnvioProtesto) {
        this.dataEnvioProtesto = dataEnvioProtesto;
    }

    public java.util.Date getDataProtocolo() {
        return this.dataProtocolo;
    }

    public void setDataProtocolo(java.util.Date dataProtocolo) {
        this.dataProtocolo = dataProtocolo;
    }

    public java.lang.Long getDiaProtesto() {
        return this.diaProtesto;
    }

    public void setDiaProtesto(java.lang.Long diaProtesto) {
        this.diaProtesto = diaProtesto;
    }

    public java.lang.String getEspecieTitulo() {
        return this.especieTitulo;
    }

    public void setEspecieTitulo(java.lang.String especieTitulo) {
        this.especieTitulo = especieTitulo;
    }

	public java.lang.String getModalidade() {
        return this.modalidade;
    }

    public void setModalidade(java.lang.String modalidade) {
        this.modalidade = modalidade;
    }

    public java.lang.String getNomeDevedor() {
        return this.nomeDevedor;
    }

    public void setNomeDevedor(java.lang.String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }

    public java.lang.String getNomeUnidadePv() {
        return this.nomeUnidadePv;
    }

    public void setNomeUnidadePv(java.lang.String nomeUnidadePv) {
        this.nomeUnidadePv = nomeUnidadePv;
    }
    
	public java.lang.Long getNossoNumero() {
        return this.nossoNumero;
    }

    public void setNossoNumero(java.lang.Long nossoNumero) {
        this.nossoNumero = nossoNumero;
    }
    
	public java.lang.Long getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(java.lang.Long totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	public java.lang.Long getNumeroCartorio() {
        return this.numeroCartorio;
    }

    public void setNumeroCartorio(java.lang.Long numeroCartorio) {
        this.numeroCartorio = numeroCartorio;
    }

    public java.lang.String getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(java.lang.String protocolo) {
        this.protocolo = protocolo;
    }

    public java.lang.Long getQuantidadeTotalTitulo() {
        return this.quantidadeTotalTitulo;
    }

    public void setQuantidadeTotalTitulo(java.lang.Long quantidadeTotalTitulo) {
        this.quantidadeTotalTitulo = quantidadeTotalTitulo;
    }
    
	public java.lang.Boolean getSelecaoCheck() {
		return selecaoCheck;
	}

	public void setSelecaoCheck(java.lang.Boolean selecaoCheck) {
		this.selecaoCheck = selecaoCheck;
	}

	public java.lang.Long getSelecaoRadio() {
        return this.selecaoRadio;
    }

    public void setSelecaoRadio(java.lang.Long selecaoRadio) {
        this.selecaoRadio = selecaoRadio;
    }
    
    public java.lang.String getSeuNumero() {
        return this.seuNumero;
    }

    public void setSeuNumero(java.lang.String seuNumero) {
        this.seuNumero = seuNumero;
    }
    
    public java.lang.String getStrRecordset() {
        return this.strRecordset;
    }

    public void setStrRecordset(java.lang.String strRecordset) {
        this.strRecordset = strRecordset;
    }

    public java.lang.Long getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.Long tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
    public java.lang.Long getOpcao() {
		return opcao;
	}

	public void setOpcao(java.lang.Long opcao) {
		this.opcao = opcao;
	}

	public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
    
    public java.lang.Long getPvCobrador() {
		return pvCobrador;
	}

	public void setPvCobrador(java.lang.Long pvCobrador) {
		this.pvCobrador = pvCobrador;
	}
	
	public br.com.politec.sao.util.Money getValorCusta() {
        return this.valorCusta;
    }

    public void setValorCusta(br.com.politec.sao.util.Money valorCusta) {
        this.valorCusta = valorCusta;
    }

	public br.com.politec.sao.util.Money getValorTitulo() {
        return this.valorTitulo;
    }

    public void setValorTitulo(br.com.politec.sao.util.Money valorTitulo) {
        this.valorTitulo = valorTitulo;
    }

    public br.com.politec.sao.util.Money getValorTotalTitulo() {
        return this.valorTotalTitulo;
    }

    public void setValorTotalTitulo(br.com.politec.sao.util.Money valorTotalTitulo) {
        this.valorTotalTitulo = valorTotalTitulo;
    }
    
	public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	// Inicio das alterações
    public java.lang.String getCpfCnpjFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoa().equals(new Long(1))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                    .toString(), 11);
        } else if (this.getTipoPessoa().equals(new Long(2))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                    .toString(), 14);
        }
        cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        return cpfCnpjTexto;
    }

    public java.lang.String getDataFormatada() {
        if (this.data != null) {
            return Formatador.formatarData(this.data);
        } else {
            return "";
        }
    }
    
    public java.lang.String getDataSolicitacaoFormatada() {
        if (this.dataSolicitacao != null) {
            return Formatador.formatarData(this.dataSolicitacao);
        } else {
            return "";
        }
    }

    public java.lang.String getDataProtocoloFormatada() {
        if (this.dataProtocolo != null) {
            return Formatador.formatarData(this.dataProtocolo);
        } else {
            return "";
        }
    }

    public java.lang.String getDataEnvioProtestoFormatada() {
        if (this.dataEnvioProtesto != null) {
            return Formatador.formatarData(this.dataEnvioProtesto);
        } else {
            return "";
        }
    }

    public java.lang.String getTipoConsultaTexto() {
        String strRetorno = "";
        if (this.tipoConsulta != null) {
            switch (this.tipoConsulta.intValue()) {
            case 1:
                strRetorno = "TITULOS A SEREM ENVIADOS AO CARTORIO";
                break;
            case 2:
                strRetorno = "TITULOS ENVIADOS AO CARTORIO";
                break;
            case 3:
                strRetorno = "TITULOS COM ENVIO SUSPENSO";
                break;
            case 4:
                if (this.diaProtesto != null) {
                    if (this.diaProtesto.equals(new Long(1))) {
                        strRetorno = "TITULOS ENVIADOS COM MAIS DE "
                                     + this.diaProtesto
                                     + " DIA";
                    } else {
                        strRetorno = "TITULOS ENVIADOS COM MAIS DE "
                                     + this.diaProtesto
                                     + " DIAS";
                    }
                }
                break;
            default:
                break;
            }

        }
        return strRetorno;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getNossoNumeroFormatado-----------------------
    public java.lang.String getNossoNumeroFormatado() {
        String nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumero);
        return nossoNumeroFormatado;
    }
    // fim-------------getNossoNumeroFormatado-----------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadePvFormatado() {
        String codigoUnidadePvFormatado = Formatador.formatarUnidade(this.codigoUnidadePv);
        return codigoUnidadePvFormatado;
    }
    
    //  fim-------------getNossoNumeroFormatado-----------------------
    // ini-------------getCodigoPvCobradorFormatado-------------------
    public java.lang.String getPvCobradorFormatado() {
        String pvCobradorFormatado = Formatador.formatarUnidade(this.pvCobrador);
        return pvCobradorFormatado;
    }

    // fim-------------getPvCobradorFormatado---------------------
    
    // Termino das alterações
    
    public java.lang.Long getFiltroSelecao() {
        return this.filtroSelecao;
    }

    public void setFiltroSelecao(java.lang.Long selecaoFiltro) {
        this.filtroSelecao = selecaoFiltro;
    }


    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ProtestoTituloBean other = (ProtestoTituloBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidadePv(), other.getCodigoUnidadePv());
            result = result
            		 && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
   		 			 && equals(getNomeGrupo(), other.getNomeGrupo());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getData(), other.getData());
            result = result && equals(getDataSolicitacao(), other.getDataSolicitacao());
            result = result
                     && equals(getDataEnvioProtesto(),
                             other.getDataEnvioProtesto());
            result = result
                     && equals(getDataProtocolo(), other.getDataProtocolo());
            result = result && equals(getDiaProtesto(), other.getDiaProtesto());
            result = result
                     && equals(getEspecieTitulo(), other.getEspecieTitulo());
            result = result && equals(getModalidade(), other.getModalidade());
            result = result && equals(getNomeDevedor(), other.getNomeDevedor());
            result = result
                     && equals(getNomeUnidadePv(), other.getNomeUnidadePv());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result
                     && equals(getNumeroCartorio(), other.getNumeroCartorio());
            result = result
            		 && equals(getTotalRegistros(), other.getTotalRegistros());
            result = result && equals(getProtocolo(), other.getProtocolo());
            result = result
                     && equals(getQuantidadeTotalTitulo(),
                             other.getQuantidadeTotalTitulo());
            result = result
            		 && equals(getSelecaoCheck(), other.getSelecaoCheck());
            result = result
                     && equals(getSelecaoRadio(), other.getSelecaoRadio());
            result = result && equals(getSeuNumero(), other.getSeuNumero());
            result = result
            		 && equals(getStrRecordset(), other.getStrRecordset());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result
            		 && equals(getOpcao(), other.getOpcao());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result && equals(getPvCobrador(), other.getPvCobrador());
            result = result && equals(getValorCusta(), other.getValorCusta());
            result = result && equals(getValorTitulo(), other.getValorTitulo());
            result = result && equals(getValorTotalTitulo(), other.getValorTotalTitulo());
            
            result = result && equals(getFiltroSelecao(),other.getFiltroSelecao());
            result = result && equals(getParcela(),other.getParcela());

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
        properties.add(new Property("codigoUnidadePv",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeGrupo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("data", DateType.create(), false, true));
        properties.add(new Property("dataSolicitacao", DateType.create(), false, true));
        properties.add(new Property("dataEnvioProtesto",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataProtocolo",
                DateType.create(),
                false,
                true));
        properties.add(new Property("diaProtesto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("especieTitulo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("parcela",
                StringType.create(),
                false,
                true));
        properties.add(new Property("modalidade",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeDevedor",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadePv",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nossoNumero",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCartorio",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalRegistros",
                LongType.create(),
                false,
                true));
        properties.add(new Property("protocolo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("quantidadeTotalTitulo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("selecaoRadio",
                LongType.create(),
                false,
                true));
        properties.add(new Property("seuNumero",
                StringType.create(),
                false,
                true));
        properties.add(new Property("strRecordset",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("opcao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("pvCobrador",
                LongType.create(),
                false,
                true));
        properties.add(new Property("valorCusta",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTitulo",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTotalTitulo",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("filtroSelecao",
                LongType.create(),
                false,
                true));

        Layout result = new Layout(properties,
                "ProtestoTituloBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("valorCusta", new MoneyValue("R$ 9(05)v99"));
        Mainframe.put("valorTotalTitulo", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("valorTitulo", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        Mainframe.put("especieTitulo", new StringValue("X(03)"));
        Mainframe.put("numeroCartorio", new LongValue("9(08)"));
        Mainframe.put("totalRegistros", new LongValue("9(06)"));
        Mainframe.put("quantidadeTotalTitulo", new LongValue("9(10)"));
        Mainframe.put("selecaoRadio", new LongValue("9(01)"));
        Mainframe.put("diaProtesto", new LongValue("9(03)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("opcao", new LongValue("9(01)"));
        Mainframe.put("codigoUnidadePv", new LongValue("9(04)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("nomeGrupo", new StringValue("X(06)"));
        Mainframe.put("modalidade", new StringValue("X(02)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("dataEnvioProtesto", new DateValue("dd.MM.yyyy"));
        Mainframe.put("seuNumero", new StringValue("X(15)"));
        Mainframe.put("strRecordset", new StringValue("X(750)"));
        Mainframe.put("nomeDevedor", new StringValue("X(40)"));
        Mainframe.put("dataProtocolo", new DateValue("dd.MM.yyyy"));
        Mainframe.put("nomeUnidadePv", new StringValue("X(40)"));
        Mainframe.put("protocolo", new StringValue("X(10)"));
        Mainframe.put("parcela", new StringValue("X(07)"));
        Mainframe.put("pvCobrador", new LongValue("9(04)"));
        Mainframe.put("data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataSolicitacao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("filtroSelecao", new LongValue("9(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
