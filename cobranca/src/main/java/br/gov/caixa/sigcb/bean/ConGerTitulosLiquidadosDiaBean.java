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

public class ConGerTitulosLiquidadosDiaBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.String codigoUsuario;

    private java.lang.Long cpfCnpj;

    private java.util.Date dataCredito;

    private java.util.Date dataPagamento;

    private java.lang.Long formaLiquidacao;

    private java.lang.String meioLiquidacao;

    private java.lang.String nomeFantasia;

    private java.lang.String nomeUnidade;

    private java.lang.Long nossoNumero;

    private java.lang.Long sequencialDia;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoPessoa;

    private java.lang.Long tpConsulta;

    private java.lang.Long unidadeVinculacao;

    private br.com.politec.sao.util.Money valorPagamento;

    private java.lang.Long pagina;

    private java.lang.Long totalRegistro;
    
    private java.lang.Long nossoNumeroLista;
    
    private java.util.Date dataPagamentoLista;
    
    private java.util.Date dataInicio;
    
    private java.util.Date dataFim;
    
	private String parcela;

    public ConGerTitulosLiquidadosDiaBean() {
        this.codigoCedente = null;
        this.codigoUsuario = null;
        this.cpfCnpj = null;
        this.dataCredito = null;
        this.dataPagamento = null;
        this.formaLiquidacao = null;
        this.meioLiquidacao = null;
        this.nomeFantasia = null;
        this.nomeUnidade = null;
        this.nossoNumero = null;
        this.sequencialDia = null;
        this.tipoConsulta = null;
        this.tipoPessoa = null;
        this.tpConsulta = null;
        this.unidadeVinculacao = null;
        this.valorPagamento = null;
        this.nossoNumeroLista = null;
        this.dataPagamentoLista = null;
        this.dataInicio = null;
        this.dataFim = null;
		this.parcela = null;
    }

    public String getApplicationName() {
        return "ConGerTitulosLiquidadosDiaBean";
    }
    
    

    public java.util.Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(java.util.Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public java.util.Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(java.util.Date dataFim) {
		this.dataFim = dataFim;
	}

	public java.lang.Long getNossoNumeroLista() {
		return nossoNumeroLista;
	}

	public void setNossoNumeroLista(java.lang.Long nossoNumeroLista) {
		this.nossoNumeroLista = nossoNumeroLista;
	}

	public java.util.Date getDataPagamentoLista() {
		return dataPagamentoLista;
	}

	public void setDataPagamentoLista(java.util.Date dataPagamentoLista) {
		this.dataPagamentoLista = dataPagamentoLista;
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

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.util.Date getDataCredito() {
        return this.dataCredito;
    }

    public void setDataCredito(java.util.Date dataCredito) {
        this.dataCredito = dataCredito;
    }

    public java.util.Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(java.util.Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public java.lang.Long getFormaLiquidacao() {
        return this.formaLiquidacao;
    }

    public void setFormaLiquidacao(java.lang.Long formaLiquidacao) {
        this.formaLiquidacao = formaLiquidacao;
    }

    public java.lang.String getMeioLiquidacao() {
        return this.meioLiquidacao;
    }

    public void setMeioLiquidacao(java.lang.String meioLiquidacao) {
        this.meioLiquidacao = meioLiquidacao;
    }

    public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public java.lang.String getNomeUnidade() {
        return this.nomeUnidade;
    }

    public void setNomeUnidade(java.lang.String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public java.lang.Long getNossoNumero() {
        return this.nossoNumero;
    }

    public void setNossoNumero(java.lang.Long nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public java.lang.Long getSequencialDia() {
        return this.sequencialDia;
    }

    public void setSequencialDia(java.lang.Long sequencialDia) {
        this.sequencialDia = sequencialDia;
    }

    public java.lang.Long getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.Long tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public java.lang.Long getTpConsulta() {
        return this.tpConsulta;
    }

    public void setTpConsulta(java.lang.Long tpConsulta) {
        this.tpConsulta = tpConsulta;
    }

    public java.lang.Long getUnidadeVinculacao() {
        return this.unidadeVinculacao;
    }

    public void setUnidadeVinculacao(java.lang.Long unidadeVinculacao) {
        this.unidadeVinculacao = unidadeVinculacao;
    }

    public br.com.politec.sao.util.Money getValorPagamento() {
        return this.valorPagamento;
    }

    public void setValorPagamento(br.com.politec.sao.util.Money valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public java.lang.Long getPagina() {
        return pagina;
    }

    public void setPagina(java.lang.Long pagina) {
        this.pagina = pagina;
    }

    public java.lang.Long getTotalRegistro() {
        return totalRegistro;
    }
 	public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

    public void setTotalRegistro(java.lang.Long totalRegistro) {
        this.totalRegistro = totalRegistro;
    }

    public String getDataPagamentoFormatada() {
        if (this.dataPagamento != null) {
            return Formatador.formatarData(this.dataPagamento);
        } else {
            return "";
        }
    }
    
    public String getDataInicioFormatada() {
        if (this.dataInicio != null) {
            return Formatador.formatarData(this.dataInicio);
        } else {
            return "";
        }
    }
    
    public String getDataFimFormatada() {
        if (this.dataFim != null) {
            return Formatador.formatarData(this.dataFim);
        } else {
            return "";
        }
    }

    public String getDataCreditoFormatada() {
        if (this.dataCredito != null) {
            return Formatador.formatarData(this.dataCredito);
        } else {
            return "";
        }
    }
    
    
    public String getDataPagamentoListaFormatada() {
        if (this.dataPagamentoLista != null) {
            return Formatador.formatarData(this.dataPagamentoLista);
        } else {
            return "";
        }
    }

    public String getFormaLiquidacaoFormatada() {
        String retorno = "";

        if (this.formaLiquidacao != null) {
            switch (this.formaLiquidacao.intValue()) {
            case 1:
                retorno = "ESPECIE";
                break;
            case 2:
                retorno = "CHEQUE";
                break;
            case 3:
                retorno = "AMBOS";
                break;
            case 4:
                retorno = "DEBITO EM CONTA";
                break;
            case 5:
                retorno = "CARTAO CREDITO";
                break;
            }
        }
        return retorno;
    }

    public java.lang.String getDescTipoPessoa() {

        String retorno = "";

        if (this.tipoPessoa != null) {
            switch (this.tipoPessoa.intValue()) {
            case 1:
                retorno = "FISICA";
                break;

            case 2:
                retorno = "JURIDICA";
                break;

            default:
                retorno = this.tipoPessoa.toString();
                break;
            }
        }
        return retorno;
    }

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

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getNossoNumeroFormatado-----------------------
    // EAM - 12/09 - Alterado NN de 17 p/ 18
    public java.lang.String getNossoNumeroFormatado() {
        String nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumero,
                18);
        return nossoNumeroFormatado;
    }

    // fim-------------getNossoNumeroFormatado-----------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getUnidadeVinculacaoFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.unidadeVinculacao);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ConGerTitulosLiquidadosDiaBean other = (ConGerTitulosLiquidadosDiaBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getDataCredito(), other.getDataCredito());
            result = result
                     && equals(getDataPagamento(), other.getDataPagamento());
            result = result
                     && equals(getFormaLiquidacao(), other.getFormaLiquidacao());
            result = result
                     && equals(getMeioLiquidacao(), other.getMeioLiquidacao());
            result = result
                     && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result && equals(getPagina(), other.getPagina());
            result = result
                     && equals(getTotalRegistro(), other.getTotalRegistro());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result
                     && equals(getSequencialDia(), other.getSequencialDia());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result && equals(getTpConsulta(), other.getTpConsulta());
            result = result
                     && equals(getUnidadeVinculacao(),
                             other.getUnidadeVinculacao());
            result = result
                     && equals(getValorPagamento(), other.getValorPagamento());
            result = result && equals(getNossoNumero(),other.getNossoNumero());
            
            result = result && equals(getNossoNumeroLista(),other.getNossoNumeroLista());
            result = result && equals(getDataPagamentoLista(), other.getDataPagamentoLista());
            result = result && equals(getDataInicio(), other.getDataInicio());
            result = result && equals(getDataFim(), other.getDataFim());
			 result = result && equals(getParcela(), other.getParcela());            
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
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("dataCredito",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataPagamento",
                DateType.create(),
                false,
                true));
        
        properties.add(new Property("dataPagamentoLista",
                DateType.create(),
                false,
                true));
        properties.add(new Property("formaLiquidacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioLiquidacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeFantasia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidade",
                StringType.create(),
                false,
                true));
 		properties.add(new Property("parcela",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nossoNumero",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nossoNumeroLista",
                LongType.create(),
                false,
                true));
        properties.add(new Property("sequencialDia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tpConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("unidadeVinculacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("valorPagamento",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("pagina", LongType.create(), false, true));
        properties.add(new Property("totalRegistro",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dataInicio",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataFim",
                DateType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ConGerTitulosLiquidadosDiaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("sequencialDia", new LongValue("9(09)"));
        Mainframe.put("formaLiquidacao", new LongValue("9(01)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("valorPagamento", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("unidadeVinculacao", new LongValue("9(04)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("meioLiquidacao", new StringValue("X(40)"));
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("tpConsulta", new LongValue("9(01)"));
        Mainframe.put("dataPagamento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataPagamentoLista", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataCredito", new DateValue("dd.MM.yyyy"));
        Mainframe.put("nomeFantasia", new StringValue("X(40)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
		Mainframe.put("parcela", new StringValue("X(07)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));// EAM 13/09 de
        Mainframe.put("nossoNumeroLista", new LongValue("9(18)"));                                                        // 17 p/ 18
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("pagina", new LongValue("9(04)"));
        Mainframe.put("totalRegistro", new LongValue("9(06)"));
        Mainframe.put("dataInicio", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataFim", new DateValue("dd.MM.yyyy"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
