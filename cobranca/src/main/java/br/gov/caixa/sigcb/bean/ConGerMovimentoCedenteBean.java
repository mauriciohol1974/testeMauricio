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
import br.gov.caixa.sigcb.util.Formatador;

public class ConGerMovimentoCedenteBean extends SigcbBean {

    private java.lang.Long codigoCanal;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoMovimento;

    private java.util.Date dataCredito;

    private java.util.Date dataEmissao;

    private java.util.Date dataMovimento;

    private java.util.Date dataPagamento;

    private java.util.Date dataVencimento;

    private java.lang.String descricaoMovimento;

    private java.lang.String nomeSacado;

    private java.lang.Long nossoNumero;

    private java.lang.Long periodo;

    private java.lang.Long qtdBloquetosAcumulado;

    private java.lang.Long qtdCreditoPeriodo;

    private java.lang.Long qtdDebitoPeriodo;

    private java.lang.Long quantidade;

    private java.lang.Long quantidadeBloqueto;

    private java.lang.String seuNumero;

    private java.lang.Long pagina;
    
    private java.lang.Long paginaFinal;

    private java.lang.Long totalRegistro;

    private br.com.politec.sao.util.Money tarifaUnitaria;

    private br.com.politec.sao.util.Money valorAbatimento;

    private br.com.politec.sao.util.Money valorCredito;

    private br.com.politec.sao.util.Money valorCreditoPeriodo;

    private br.com.politec.sao.util.Money valorDebitoPeriodo;

    private br.com.politec.sao.util.Money valorDesconto;

    private br.com.politec.sao.util.Money valorEncargos;

    private br.com.politec.sao.util.Money valorRecAcumulado;

    private br.com.politec.sao.util.Money valorRecebido;

    private br.com.politec.sao.util.Money valorTarUniAcumulado;

    private br.com.politec.sao.util.Money valorTarifa;

    private br.com.politec.sao.util.Money valorTarifaAcumulado;

    private br.com.politec.sao.util.Money valorTitulo;

    private br.com.politec.sao.util.Money valorTotalRecebido;

    private br.com.politec.sao.util.Money valorTotalTarifa;
    
    private br.com.politec.sao.util.Money valorIOF;
    
    private String feriadoLocal;
    
    private String parcela;
    
    private Long nuIdentCIP;
    
    private Long totalTitulos;

    public ConGerMovimentoCedenteBean() {
        this.codigoCanal = null;
        this.codigoCedente = null;
        this.codigoMovimento = null;
        this.dataCredito = null;
        this.dataEmissao = null;
        this.dataMovimento = null;
        this.dataPagamento = null;
        this.dataVencimento = null;
        this.descricaoMovimento = null;
        this.nomeSacado = null;
        this.nossoNumero = null;
        this.periodo = null;
        this.qtdBloquetosAcumulado = null;
        this.qtdCreditoPeriodo = null;
        this.qtdDebitoPeriodo = null;
        this.quantidade = null;
        this.quantidadeBloqueto = null;
        this.seuNumero = null;
        this.pagina = null;
        this.totalRegistro = null;
        this.tarifaUnitaria = null;
        this.valorAbatimento = null;
        this.valorCredito = null;
        this.valorCreditoPeriodo = null;
        this.valorDebitoPeriodo = null;
        this.valorDesconto = null;
        this.valorEncargos = null;
        this.valorRecAcumulado = null;
        this.valorRecebido = null;
        this.valorTarUniAcumulado = null;
        this.valorTarifa = null;
        this.valorTarifaAcumulado = null;
        this.valorTitulo = null;
        this.valorTotalRecebido = null;
        this.valorTotalTarifa = null;
        this.valorIOF = null;
        this.feriadoLocal=null;
        this.paginaFinal=null;
        this.parcela=null;
        this.nuIdentCIP=null;
        this.totalTitulos=null;
    }

    public String getApplicationName() {
        return "ConGerMovimentoCedenteBean";
    }

    
    public Long getTotalTitulos() {
		return totalTitulos;
	}

	public void setTotalTitulos(Long totalTitulos) {
		this.totalTitulos = totalTitulos;
	}

	public Long getNuIdentCIP() {
		return nuIdentCIP;
	}

	public void setNuIdentCIP(Long nuIdentCIP) {
		this.nuIdentCIP = nuIdentCIP;
	}

	public java.lang.Long getCodigoCanal() {
        return this.codigoCanal;
    }

    public void setCodigoCanal(java.lang.Long codigoCanal) {
        this.codigoCanal = codigoCanal;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoMovimento() {
        return this.codigoMovimento;
    }

    public void setCodigoMovimento(java.lang.Long codigoMovimento) {
        this.codigoMovimento = codigoMovimento;
    }

    public java.util.Date getDataCredito() {
        return this.dataCredito;
    }

    public void setDataCredito(java.util.Date dataCredito) {
        this.dataCredito = dataCredito;
    }

    public java.util.Date getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(java.util.Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public java.util.Date getDataMovimento() {
        return this.dataMovimento;
    }

    public void setDataMovimento(java.util.Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public java.util.Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(java.util.Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public java.util.Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(java.util.Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public java.lang.String getDescricaoMovimento() {
        return this.descricaoMovimento;
    }

    public void setDescricaoMovimento(java.lang.String descricaoMovimento) {
        this.descricaoMovimento = descricaoMovimento;
    }

    public java.lang.String getNomeSacado() {
        return this.nomeSacado;
    }

    public void setNomeSacado(java.lang.String nomeSacado) {
        this.nomeSacado = nomeSacado;
    }

    public java.lang.Long getNossoNumero() {
        return this.nossoNumero;
    }

    public void setNossoNumero(java.lang.Long nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public java.lang.Long getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(java.lang.Long periodo) {
        this.periodo = periodo;
    }

    public java.lang.Long getQtdBloquetosAcumulado() {
        return this.qtdBloquetosAcumulado;
    }

    public void setQtdBloquetosAcumulado(java.lang.Long qtdBloquetosAcumulado) {
        this.qtdBloquetosAcumulado = qtdBloquetosAcumulado;
    }

    public java.lang.Long getQtdCreditoPeriodo() {
        return this.qtdCreditoPeriodo;
    }

    public void setQtdCreditoPeriodo(java.lang.Long qtdCreditoPeriodo) {
        this.qtdCreditoPeriodo = qtdCreditoPeriodo;
    }

    public java.lang.Long getQtdDebitoPeriodo() {
        return this.qtdDebitoPeriodo;
    }

    public void setQtdDebitoPeriodo(java.lang.Long qtdDebitoPeriodo) {
        this.qtdDebitoPeriodo = qtdDebitoPeriodo;
    }

    public java.lang.Long getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(java.lang.Long quantidade) {
        this.quantidade = quantidade;
    }

    public java.lang.Long getQuantidadeBloqueto() {
        return this.quantidadeBloqueto;
    }

    public void setQuantidadeBloqueto(java.lang.Long quantidadeBloqueto) {
        this.quantidadeBloqueto = quantidadeBloqueto;
    }

    public java.lang.String getSeuNumero() {
        return this.seuNumero;
    }

    public void setSeuNumero(java.lang.String seuNumero) {
        this.seuNumero = seuNumero;
    }

    public br.com.politec.sao.util.Money getTarifaUnitaria() {
        return this.tarifaUnitaria;
    }

    public void setTarifaUnitaria(br.com.politec.sao.util.Money tarifaUnitaria) {
        this.tarifaUnitaria = tarifaUnitaria;
    }

    public br.com.politec.sao.util.Money getValorAbatimento() {
        return this.valorAbatimento;
    }

    public void setValorAbatimento(br.com.politec.sao.util.Money valorAbatimento) {
        this.valorAbatimento = valorAbatimento;
    }

    public br.com.politec.sao.util.Money getValorCredito() {
        return this.valorCredito;
    }

    public void setValorCredito(br.com.politec.sao.util.Money valorCredito) {
        this.valorCredito = valorCredito;
    }

    public br.com.politec.sao.util.Money getValorCreditoPeriodo() {
        return this.valorCreditoPeriodo;
    }

    public void setValorCreditoPeriodo(br.com.politec.sao.util.Money valorCreditoPeriodo) {
        this.valorCreditoPeriodo = valorCreditoPeriodo;
    }

    public br.com.politec.sao.util.Money getValorDebitoPeriodo() {
        return this.valorDebitoPeriodo;
    }

    public void setValorDebitoPeriodo(br.com.politec.sao.util.Money valorDebitoPeriodo) {
        this.valorDebitoPeriodo = valorDebitoPeriodo;
    }

    public br.com.politec.sao.util.Money getValorDesconto() {
        return this.valorDesconto;
    }

    public void setValorDesconto(br.com.politec.sao.util.Money valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public br.com.politec.sao.util.Money getValorEncargos() {
        return this.valorEncargos;
    }

    public void setValorEncargos(br.com.politec.sao.util.Money valorEncargos) {
        this.valorEncargos = valorEncargos;
    }

    public br.com.politec.sao.util.Money getValorRecAcumulado() {
        return this.valorRecAcumulado;
    }

    public void setValorRecAcumulado(br.com.politec.sao.util.Money valorRecAcumulado) {
        this.valorRecAcumulado = valorRecAcumulado;
    }

    public br.com.politec.sao.util.Money getValorRecebido() {
        return this.valorRecebido;
    }

    public void setValorRecebido(br.com.politec.sao.util.Money valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public br.com.politec.sao.util.Money getValorTarUniAcumulado() {
        return this.valorTarUniAcumulado;
    }

    public void setValorTarUniAcumulado(br.com.politec.sao.util.Money valorTarUniAcumulado) {
        this.valorTarUniAcumulado = valorTarUniAcumulado;
    }

    public br.com.politec.sao.util.Money getValorTarifa() {
        return this.valorTarifa;
    }

    public void setValorTarifa(br.com.politec.sao.util.Money valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    public br.com.politec.sao.util.Money getValorTarifaAcumulado() {
        return this.valorTarifaAcumulado;
    }

    public void setValorTarifaAcumulado(br.com.politec.sao.util.Money valorTarifaAcumulado) {
        this.valorTarifaAcumulado = valorTarifaAcumulado;
    }

    public br.com.politec.sao.util.Money getValorTitulo() {
        return this.valorTitulo;
    }

    public void setValorTitulo(br.com.politec.sao.util.Money valorTitulo) {
        this.valorTitulo = valorTitulo;
    }

    public br.com.politec.sao.util.Money getValorTotalRecebido() {
        return this.valorTotalRecebido;
    }

    public void setValorTotalRecebido(br.com.politec.sao.util.Money valorTotalRecebido) {
        this.valorTotalRecebido = valorTotalRecebido;
    }

    public br.com.politec.sao.util.Money getValorTotalTarifa() {
        return this.valorTotalTarifa;
    }

    public void setValorTotalTarifa(br.com.politec.sao.util.Money valorTotalTarifa) {
        this.valorTotalTarifa = valorTotalTarifa;
    }

    public Layout getLayout() {
        return layout;
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

    public void setTotalRegistro(java.lang.Long totalRegistro) {
        this.totalRegistro = totalRegistro;
    }

    
    
    public br.com.politec.sao.util.Money getValorIOF() {
		return valorIOF;
	}

	public void setValorIOF(br.com.politec.sao.util.Money valorIOF) {
		this.valorIOF = valorIOF;
	}
	
	

	public String getFeriadoLocal() {
		return feriadoLocal;
	}

	public void setFeriadoLocal(String feriadoLocal) {
		this.feriadoLocal = feriadoLocal;
	}

	/* dados alterados manualmente */
    public String getDataPagamentoFormatada() {
        if (this.dataPagamento != null) {
            return Formatador.formatarData(this.dataPagamento);
        } else {
            return "";
        }
    }

    public String getDataEmissaoFormatada() {
        if (this.dataEmissao != null) {
            return Formatador.formatarData(this.dataEmissao);
        } else {
            return "";
        }
    }

    public String getDataMovimentoFormatada() {
        if (this.dataMovimento != null) {
            return Formatador.formatarData(this.dataMovimento);
        } else {
            return "";
        }
    }

    public String getDataVencimentoFormatada() {
        if (this.dataVencimento != null) {
            return Formatador.formatarData(this.dataVencimento);
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
    
    

    public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public java.lang.Long getPaginaFinal() {
		return paginaFinal;
	}

	public void setPaginaFinal(java.lang.Long paginaFinal) {
		this.paginaFinal = paginaFinal;
	}

	public String getDescricaoCanal() {

        String retorno = "";

        if (this.codigoCanal != null) {
            switch (codigoCanal.intValue()) {
            case 5:
                retorno = "Caixa - Dinheiro";
                break;
            case 71:
                retorno = "Caixa - Cheque";
                break;
            case 4:
                retorno = "Lotérico - Dinheiro";
                break;
            case 72:
                retorno = "Lotérico - Cheque";
                break;
            case 6:
                retorno = "Compensação";
                break;
            case 7:
                retorno = "Auto-Atendimento";
                break;
            case 80:
                retorno = "Correspondente Bancário";
                break;
            case 73:
                retorno = "Internet Banking";
                break;
            case 81:
                retorno = "STR/TED";
                break;
            case 78:
                retorno = "Cartório Dinheiro";
                break;
            case 90:
                retorno = "Cartório Cheque";
                break;
            case 54:
                retorno = "Caixa - Dinheiro - PEC";
                break;
            case 56:
                retorno = "Caixa - Cheque - PEC";
                break;
            case 57:
                retorno = "Lotérico - Dinheiro - PEC";
                break;
            case 60:
                retorno = "Lotérico - Cheque - PEC";
                break;   
            case 102:
                retorno = "Mobile Pre-Pago";
                break;      
            default:
                retorno = "" + codigoCanal;
                break;
            }
        }
        return retorno;
    }

    public String getPeriodoFormatado() {
        String retorno = "";
        if (this.periodo != null) {
            switch (periodo.intValue()) {
            case 1:
                retorno = "30 DIAS";
                break;
            case 2:
                retorno = "60 DIAS";
                break;
            case 3:
                retorno = "90 DIAS";
                break;
            default:
                retorno = "";
                break;
            }
        }
        return retorno;
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

    /* fim */

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ConGerMovimentoCedenteBean other = (ConGerMovimentoCedenteBean) obj;
            result = result && equals(getCodigoCanal(), other.getCodigoCanal());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoMovimento(), other.getCodigoMovimento());
            result = result && equals(getDataCredito(), other.getDataCredito());
            result = result && equals(getDataEmissao(), other.getDataEmissao());
            result = result
                     && equals(getDataMovimento(), other.getDataMovimento());
            result = result && equals(getPagina(), other.getPagina());
            result = result
                     && equals(getDataPagamento(), other.getDataPagamento());
            result = result
                     && equals(getDataVencimento(), other.getDataVencimento());
            result = result
                     && equals(getDescricaoMovimento(),
                             other.getDescricaoMovimento());
            result = result && equals(getNomeSacado(), other.getNomeSacado());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result && equals(getPeriodo(), other.getPeriodo());
            result = result
                     && equals(getQtdBloquetosAcumulado(),
                             other.getQtdBloquetosAcumulado());
            result = result
                     && equals(getQtdCreditoPeriodo(),
                             other.getQtdCreditoPeriodo());
            result = result
                     && equals(getQtdDebitoPeriodo(),
                             other.getQtdDebitoPeriodo());
            result = result && equals(getQuantidade(), other.getQuantidade());
            result = result
                     && equals(getQuantidadeBloqueto(),
                             other.getQuantidadeBloqueto());
            result = result && equals(getSeuNumero(), other.getSeuNumero());
            result = result
                     && equals(getTotalRegistro(), other.getTotalRegistro());
            result = result
                     && equals(getTarifaUnitaria(), other.getTarifaUnitaria());
            result = result
                     && equals(getValorAbatimento(), other.getValorAbatimento());
            result = result
                     && equals(getValorCredito(), other.getValorCredito());
            result = result
                     && equals(getValorCreditoPeriodo(),
                             other.getValorCreditoPeriodo());
            result = result
                     && equals(getValorDebitoPeriodo(),
                             other.getValorDebitoPeriodo());
            result = result
                     && equals(getValorDesconto(), other.getValorDesconto());
            result = result
                     && equals(getValorEncargos(), other.getValorEncargos());
            result = result
                     && equals(getValorRecAcumulado(),
                             other.getValorRecAcumulado());
            result = result
                     && equals(getValorRecebido(), other.getValorRecebido());
            result = result
                     && equals(getValorTarUniAcumulado(),
                             other.getValorTarUniAcumulado());
            result = result && equals(getValorTarifa(), other.getValorTarifa());
            result = result
                     && equals(getValorTarifaAcumulado(),
                             other.getValorTarifaAcumulado());
            result = result && equals(getValorTitulo(), other.getValorTitulo());
            result = result
                     && equals(getValorTotalRecebido(),
                             other.getValorTotalRecebido());
            result = result
                     && equals(getValorTotalTarifa(),
                             other.getValorTotalTarifa());
            result = result   && equals(getValorIOF(), other.getValorIOF());
            result = result   && equals(getFeriadoLocal(), other.getFeriadoLocal());
            result = result   && equals(getPaginaFinal(), other.getPaginaFinal());
            result = result   && equals(getParcela(), other.getParcela());
            result = result   && equals(getNuIdentCIP(), other.getNuIdentCIP());
            result = result   && equals(getTotalTitulos(), other.getTotalTitulos());
            
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
        properties.add(new Property("codigoCanal",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoMovimento",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dataCredito",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataEmissao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataMovimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataPagamento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataVencimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("descricaoMovimento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nossoNumero",
                LongType.create(),
                false,
                true));
        properties.add(new Property("periodo", LongType.create(), false, true));
        properties.add(new Property("qtdBloquetosAcumulado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdCreditoPeriodo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdDebitoPeriodo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("quantidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("quantidadeBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("seuNumero",
                StringType.create(),
                false,
                true));
        properties.add(new Property("pagina", LongType.create(), false, true));
        properties.add(new Property("paginaFinal", LongType.create(), false, true));
        properties.add(new Property("totalRegistro",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tarifaUnitaria",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorAbatimento",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorCredito",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorCreditoPeriodo",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorDebitoPeriodo",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorDesconto",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorEncargos",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorRecAcumulado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorRecebido",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTarUniAcumulado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTarifa",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTarifaAcumulado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTitulo",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTotalRecebido",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTotalTarifa",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorIOF",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("feriadoLocal",
                StringType.create(),
                false,
                true));
        properties.add(new Property("parcela",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nuIdentCIP",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalTitulos",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ConGerMovimentoCedenteBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("valorRecAcumulado", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("qtdCreditoPeriodo", new LongValue("9(08)"));
        Mainframe.put("valorTotalRecebido", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorTitulo", new MoneyValue("R$ 9(11)v99"));
        Mainframe.put("periodo", new LongValue("9(01)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));// EAM 13/09 de
                                                                // 17 p/ 18
        Mainframe.put("valorDesconto", new MoneyValue("R$ 9(11)v99"));
        Mainframe.put("dataEmissao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("nomeSacado", new StringValue("X(40)"));
        Mainframe.put("valorDebitoPeriodo", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("descricaoMovimento", new StringValue("X(40)"));
        Mainframe.put("tarifaUnitaria", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("qtdBloquetosAcumulado", new LongValue("9(07)"));
        Mainframe.put("valorCredito", new MoneyValue("R$ 9(11)v99"));
        Mainframe.put("valorTotalTarifa", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorTarifa", new MoneyValue("R$ 9(11)v99"));
        Mainframe.put("valorTarUniAcumulado", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorTarifaAcumulado", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorEncargos", new MoneyValue("R$ 9(11)v99"));
        Mainframe.put("dataPagamento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("qtdDebitoPeriodo", new LongValue("9(08)"));
        Mainframe.put("dataCredito", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataMovimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valorRecebido", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("quantidade", new LongValue("9(08)"));
        Mainframe.put("codigoCanal", new LongValue("9(03)"));
        Mainframe.put("quantidadeBloqueto", new LongValue("9(07)"));
        Mainframe.put("seuNumero", new StringValue("X(15)"));
        Mainframe.put("valorAbatimento", new MoneyValue("R$ 9(11)v99"));
        Mainframe.put("dataVencimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("codigoMovimento", new LongValue("9(03)"));
        Mainframe.put("valorCreditoPeriodo", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("valorIOF", new MoneyValue("R$ 9(11)v99"));
        Mainframe.put("pagina", new LongValue("9(07)"));
        Mainframe.put("paginaFinal", new LongValue("9(07)"));
        Mainframe.put("totalRegistro", new LongValue("9(09)"));
        Mainframe.put("feriadoLocal", new StringValue("X(35)"));
        Mainframe.put("parcela", new StringValue("X(07)"));
        Mainframe.put("nuIdentCIP", new LongValue("9(19)"));
        Mainframe.put("totalTitulos", new LongValue("9(09)"));
        result.addExtension(Mainframe);
        return result;
    }
}
