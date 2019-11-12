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
import br.com.politec.sao.iso.values.PercentualValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class DdaTituloBean extends SigcbBean {
    private br.com.politec.sao.util.Percentual PercentualMulta;

    private java.lang.Long PvCobrador;

    private java.lang.Long PvRecebedor;

    private java.lang.String aceite;

    private java.lang.Long codigoCedente;

    private java.util.Date dataCredito;

    private java.util.Date dataDesconto1;

    private java.util.Date dataDesconto2;

    private java.util.Date dataDesconto3;

    private java.util.Date dataEmissao;

    private java.util.Date dataEntrada;

    private java.util.Date dataMulta;

    private java.util.Date dataPagamento;

    private java.util.Date dataProtesto;

    private java.util.Date dataSituacao;

    private java.util.Date dataVencimento;

    private java.lang.String descricaoModalidade;

    private java.lang.String especieTitulo;

    private java.lang.String meioEntrada;

    private java.lang.Long modalidade;

    private java.lang.String moeda;

    private java.lang.String nomeSacado;

    private java.lang.Long nossoNumero;

    private java.lang.String numeroDocumento;

    private java.lang.Long numeroLote;

    private br.com.politec.sao.util.Percentual percentualDesconto1;

    private br.com.politec.sao.util.Percentual percentualDesconto2;

    private br.com.politec.sao.util.Percentual percentualDesconto3;

    private br.com.politec.sao.util.Percentual percentualJurosDia;

    private java.lang.Long prazoDesconto1;

    private java.lang.Long prazoDesconto2;

    private java.lang.Long prazoDesconto3;

    private java.lang.Long prazoMulta;

    private java.lang.Long prazoProtesto;

    private java.lang.Long quantidadeMoeda;

    private java.lang.Long sequencialDia;

    private java.lang.String situacaoTitulo;

    private java.lang.Long tipoConsulta;

    private br.com.politec.sao.util.Money valorAbatimento;

    private br.com.politec.sao.util.Money valorCobrado;

    private br.com.politec.sao.util.Money valorDesconto1;

    private br.com.politec.sao.util.Money valorDesconto2;

    private br.com.politec.sao.util.Money valorDesconto3;

    private br.com.politec.sao.util.Money valorJuros;

    private br.com.politec.sao.util.Money valorMulta;

    private br.com.politec.sao.util.Money valorTitulo;
    
    private java.lang.Long numeroDDA;
    
    private String nuCIP;

    private String nuRefCIP;
    
    private String cpfCnpj;


    public DdaTituloBean() {
        this.PercentualMulta = null;
        this.PvCobrador = null;
        this.PvRecebedor = null;
        this.aceite = null;
        this.codigoCedente = null;
        this.dataCredito = null;
        this.dataDesconto1 = null;
        this.dataDesconto2 = null;
        this.dataDesconto3 = null;
        this.dataEmissao = null;
        this.dataEntrada = null;
        this.dataMulta = null;
        this.dataPagamento = null;
        this.dataProtesto = null;
        this.dataSituacao = null;
        this.dataVencimento = null;
        this.descricaoModalidade = null;
        this.especieTitulo = null;
        this.meioEntrada = null;
        this.modalidade = null;
        this.moeda = null;
        this.nomeSacado = null;
        this.nossoNumero = null;
        this.numeroDocumento = null;
        this.numeroLote = null;
        this.percentualDesconto1 = null;
        this.percentualDesconto2 = null;
        this.percentualDesconto3 = null;
        this.percentualJurosDia = null;
        this.prazoDesconto1 = null;
        this.prazoDesconto2 = null;
        this.prazoDesconto3 = null;
        this.prazoMulta = null;
        this.prazoProtesto = null;
        this.quantidadeMoeda = null;
        this.sequencialDia = null;
        this.situacaoTitulo = null;
        this.tipoConsulta = null;
        this.valorAbatimento = null;
        this.valorCobrado = null;
        this.valorDesconto1 = null;
        this.valorDesconto2 = null;
        this.valorDesconto3 = null;
        this.valorJuros = null;
        this.valorMulta = null;
        this.valorTitulo = null;
        this.numeroDDA = null;
        this.nuCIP=null;
        this.nuRefCIP=null;
        this.cpfCnpj=null;
    }

    public String getApplicationName() {
        return "DdaTituloBean";
    }

   

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNuCIP() {
		return nuCIP;
	}

	public void setNuCIP(String nuCIP) {
		this.nuCIP = nuCIP;
	}

	public String getNuRefCIP() {
		return nuRefCIP;
	}

	public void setNuRefCIP(String nuRefCIP) {
		this.nuRefCIP = nuRefCIP;
	}

	public br.com.politec.sao.util.Percentual getPercentualMulta() {
        return this.PercentualMulta;
    }

    public void setPercentualMulta(br.com.politec.sao.util.Percentual PercentualMulta) {
        this.PercentualMulta = PercentualMulta;
    }

    public java.lang.Long getPvCobrador() {
        return this.PvCobrador;
    }

    public void setPvCobrador(java.lang.Long PvCobrador) {
        this.PvCobrador = PvCobrador;
    }

    public java.lang.Long getPvRecebedor() {
        return this.PvRecebedor;
    }

    public void setPvRecebedor(java.lang.Long PvRecebedor) {
        this.PvRecebedor = PvRecebedor;
    }

    public java.lang.String getAceite() {
        return this.aceite;
    }

    public void setAceite(java.lang.String aceite) {
        this.aceite = aceite;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.util.Date getDataCredito() {
        return this.dataCredito;
    }

    public void setDataCredito(java.util.Date dataCredito) {
        this.dataCredito = dataCredito;
    }

    public java.util.Date getDataDesconto1() {
        return this.dataDesconto1;
    }

    public void setDataDesconto1(java.util.Date dataDesconto1) {
        this.dataDesconto1 = dataDesconto1;
    }

    public java.util.Date getDataDesconto2() {
        return this.dataDesconto2;
    }

    public void setDataDesconto2(java.util.Date dataDesconto2) {
        this.dataDesconto2 = dataDesconto2;
    }

    public java.util.Date getDataDesconto3() {
        return this.dataDesconto3;
    }

    public void setDataDesconto3(java.util.Date dataDesconto3) {
        this.dataDesconto3 = dataDesconto3;
    }

    public java.util.Date getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(java.util.Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public java.util.Date getDataEntrada() {
        return this.dataEntrada;
    }

    public void setDataEntrada(java.util.Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public java.util.Date getDataMulta() {
        return this.dataMulta;
    }

    public void setDataMulta(java.util.Date dataMulta) {
        this.dataMulta = dataMulta;
    }

    public java.util.Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(java.util.Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public java.util.Date getDataProtesto() {
        return this.dataProtesto;
    }

    public void setDataProtesto(java.util.Date dataProtesto) {
        this.dataProtesto = dataProtesto;
    }

    public java.util.Date getDataSituacao() {
        return this.dataSituacao;
    }

    public void setDataSituacao(java.util.Date dataSituacao) {
        this.dataSituacao = dataSituacao;
    }

    public java.util.Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(java.util.Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public java.lang.String getDescricaoModalidade() {
        return this.descricaoModalidade;
    }

    public void setDescricaoModalidade(java.lang.String descricaoModalidade) {
        this.descricaoModalidade = descricaoModalidade;
    }

    public java.lang.String getEspecieTitulo() {
        return this.especieTitulo;
    }

    public void setEspecieTitulo(java.lang.String especieTitulo) {
        this.especieTitulo = especieTitulo;
    }

    public java.lang.String getMeioEntrada() {
        return this.meioEntrada;
    }

    public void setMeioEntrada(java.lang.String meioEntrada) {
        this.meioEntrada = meioEntrada;
    }

    public java.lang.Long getModalidade() {
        return this.modalidade;
    }

    public void setModalidade(java.lang.Long modalidade) {
        this.modalidade = modalidade;
    }

    public java.lang.String getMoeda() {
        return this.moeda;
    }

    public void setMoeda(java.lang.String moeda) {
        this.moeda = moeda;
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

    public java.lang.String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public void setNumeroDocumento(java.lang.String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public java.lang.Long getNumeroLote() {
        return this.numeroLote;
    }

    public void setNumeroLote(java.lang.Long numeroLote) {
        this.numeroLote = numeroLote;
    }

    public br.com.politec.sao.util.Percentual getPercentualDesconto1() {
        return this.percentualDesconto1;
    }

    public void setPercentualDesconto1(br.com.politec.sao.util.Percentual percentualDesconto1) {
        this.percentualDesconto1 = percentualDesconto1;
    }

    public br.com.politec.sao.util.Percentual getPercentualDesconto2() {
        return this.percentualDesconto2;
    }

    public void setPercentualDesconto2(br.com.politec.sao.util.Percentual percentualDesconto2) {
        this.percentualDesconto2 = percentualDesconto2;
    }

    public br.com.politec.sao.util.Percentual getPercentualDesconto3() {
        return this.percentualDesconto3;
    }

    public void setPercentualDesconto3(br.com.politec.sao.util.Percentual percentualDesconto3) {
        this.percentualDesconto3 = percentualDesconto3;
    }

    public br.com.politec.sao.util.Percentual getPercentualJurosDia() {
        return this.percentualJurosDia;
    }

    public void setPercentualJurosDia(br.com.politec.sao.util.Percentual percentualJurosDia) {
        this.percentualJurosDia = percentualJurosDia;
    }

    public java.lang.Long getPrazoDesconto1() {
        return this.prazoDesconto1;
    }

    public void setPrazoDesconto1(java.lang.Long prazoDesconto1) {
        this.prazoDesconto1 = prazoDesconto1;
    }

    public java.lang.Long getPrazoDesconto2() {
        return this.prazoDesconto2;
    }

    public void setPrazoDesconto2(java.lang.Long prazoDesconto2) {
        this.prazoDesconto2 = prazoDesconto2;
    }

    public java.lang.Long getPrazoDesconto3() {
        return this.prazoDesconto3;
    }

    public void setPrazoDesconto3(java.lang.Long prazoDesconto3) {
        this.prazoDesconto3 = prazoDesconto3;
    }

    public java.lang.Long getPrazoMulta() {
        return this.prazoMulta;
    }

    public void setPrazoMulta(java.lang.Long prazoMulta) {
        this.prazoMulta = prazoMulta;
    }

    public java.lang.Long getPrazoProtesto() {
        return this.prazoProtesto;
    }

    public void setPrazoProtesto(java.lang.Long prazoProtesto) {
        this.prazoProtesto = prazoProtesto;
    }

    public java.lang.Long getQuantidadeMoeda() {
        return this.quantidadeMoeda;
    }

    public void setQuantidadeMoeda(java.lang.Long quantidadeMoeda) {
        this.quantidadeMoeda = quantidadeMoeda;
    }

    public java.lang.Long getSequencialDia() {
        return this.sequencialDia;
    }

    public void setSequencialDia(java.lang.Long sequencialDia) {
        this.sequencialDia = sequencialDia;
    }

    public java.lang.String getSituacaoTitulo() {
        return this.situacaoTitulo;
    }

    public void setSituacaoTitulo(java.lang.String situacaoTitulo) {
        this.situacaoTitulo = situacaoTitulo;
    }

    public java.lang.Long getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.Long tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public br.com.politec.sao.util.Money getValorAbatimento() {
        return this.valorAbatimento;
    }

    public void setValorAbatimento(br.com.politec.sao.util.Money valorAbatimento) {
        this.valorAbatimento = valorAbatimento;
    }

    public br.com.politec.sao.util.Money getValorCobrado() {
        return this.valorCobrado;
    }

    public void setValorCobrado(br.com.politec.sao.util.Money valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public br.com.politec.sao.util.Money getValorDesconto1() {
        return this.valorDesconto1;
    }

    public void setValorDesconto1(br.com.politec.sao.util.Money valorDesconto1) {
        this.valorDesconto1 = valorDesconto1;
    }

    public br.com.politec.sao.util.Money getValorDesconto2() {
        return this.valorDesconto2;
    }

    public void setValorDesconto2(br.com.politec.sao.util.Money valorDesconto2) {
        this.valorDesconto2 = valorDesconto2;
    }

    public br.com.politec.sao.util.Money getValorDesconto3() {
        return this.valorDesconto3;
    }

    public void setValorDesconto3(br.com.politec.sao.util.Money valorDesconto3) {
        this.valorDesconto3 = valorDesconto3;
    }

    public br.com.politec.sao.util.Money getValorJuros() {
        return this.valorJuros;
    }

    public void setValorJuros(br.com.politec.sao.util.Money valorJuros) {
        this.valorJuros = valorJuros;
    }

    public br.com.politec.sao.util.Money getValorMulta() {
        return this.valorMulta;
    }

    public void setValorMulta(br.com.politec.sao.util.Money valorMulta) {
        this.valorMulta = valorMulta;
    }

    public br.com.politec.sao.util.Money getValorTitulo() {
        return this.valorTitulo;
    }

    public void setValorTitulo(br.com.politec.sao.util.Money valorTitulo) {
        this.valorTitulo = valorTitulo;
    }

    /*------- INICIO DA ALTERAÇÃO --------------------------------------------------------*/

    public String getDataPagamentoFormatada() {
        if (this.dataPagamento != null) {
            return Formatador.formatarData(this.dataPagamento);
        } else {
            return "";
        }
    }

    public String getDataSituacaoFormatada() {
        if (this.dataSituacao != null) {
            return Formatador.formatarData(this.dataSituacao);
        } else {
            return "";
        }
    }

    public String getDataDesconto1Formatada() {
        if (this.dataDesconto1 != null) {
            return Formatador.formatarData(this.dataDesconto1);
        } else {
            return "";
        }
    }

    public String getDataDesconto2Formatada() {
        if (this.dataDesconto2 != null) {
            return Formatador.formatarData(this.dataDesconto2);
        } else {
            return "";
        }
    }

    public String getDataDesconto3Formatada() {
        if (this.dataDesconto3 != null) {
            return Formatador.formatarData(this.dataDesconto3);
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

    public String getDataEntradaFormatada() {
        if (this.dataEntrada != null) {
            return Formatador.formatarData(this.dataEntrada);
        } else {
            return "";
        }
    }

    public String getDataMultaFormatada() {
        if (this.dataMulta != null) {
            return Formatador.formatarData(this.dataMulta);
        } else {
            return "";
        }
    }

    public String getDataProtestoFormatada() {
        if (this.dataProtesto != null) {
            return Formatador.formatarData(this.dataProtesto);
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

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getNossoNumeroFormatado-----------------------
    // 12/09 - Alterado NN de 17 p/ 18
    public java.lang.String getNossoNumeroFormatado() {
        String nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumero,
                18);
        return nossoNumeroFormatado;
    }

    // fim-------------getNossoNumeroFormatado-----------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getPvCobradorFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.PvCobrador);
        return codigoUnidadeFormatado;
    }

    public java.lang.String getPvRecebedorFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.PvRecebedor);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------

    /*------- FIM DA ALTERAÇÃO ------------------------------------------------------------*/
    
    public java.lang.Long getNumeroDDA() {
        return this.numeroDDA;
    }

    public void setNumeroDDA(java.lang.Long numeroDDA) {
        this.numeroDDA = numeroDDA;
    }


    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            DdaTituloBean other = (DdaTituloBean) obj;
            result = result
                     && equals(getPercentualMulta(), other.getPercentualMulta());
            result = result && equals(getPvCobrador(), other.getPvCobrador());
            result = result && equals(getPvRecebedor(), other.getPvRecebedor());
            result = result && equals(getAceite(), other.getAceite());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getDataCredito(), other.getDataCredito());
            result = result
                     && equals(getDataDesconto1(), other.getDataDesconto1());
            result = result
                     && equals(getDataDesconto2(), other.getDataDesconto2());
            result = result
                     && equals(getDataDesconto3(), other.getDataDesconto3());
            result = result && equals(getDataEmissao(), other.getDataEmissao());
            result = result && equals(getDataEntrada(), other.getDataEntrada());
            result = result && equals(getDataMulta(), other.getDataMulta());
            result = result
                     && equals(getDataPagamento(), other.getDataPagamento());
            result = result
                     && equals(getDataProtesto(), other.getDataProtesto());
            result = result
                     && equals(getDataSituacao(), other.getDataSituacao());
            result = result
                     && equals(getDataVencimento(), other.getDataVencimento());
            result = result
                     && equals(getDescricaoModalidade(),
                             other.getDescricaoModalidade());
            result = result
                     && equals(getEspecieTitulo(), other.getEspecieTitulo());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result && equals(getModalidade(), other.getModalidade());
            result = result && equals(getMoeda(), other.getMoeda());
            result = result && equals(getNomeSacado(), other.getNomeSacado());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result
                     && equals(getNumeroDocumento(), other.getNumeroDocumento());
            result = result && equals(getNumeroLote(), other.getNumeroLote());
            result = result
                     && equals(getPercentualDesconto1(),
                             other.getPercentualDesconto1());
            result = result
                     && equals(getPercentualDesconto2(),
                             other.getPercentualDesconto2());
            result = result
                     && equals(getPercentualDesconto3(),
                             other.getPercentualDesconto3());
            result = result
                     && equals(getPercentualJurosDia(),
                             other.getPercentualJurosDia());
            result = result
                     && equals(getPrazoDesconto1(), other.getPrazoDesconto1());
            result = result
                     && equals(getPrazoDesconto2(), other.getPrazoDesconto2());
            result = result
                     && equals(getPrazoDesconto3(), other.getPrazoDesconto3());
            result = result && equals(getPrazoMulta(), other.getPrazoMulta());
            result = result
                     && equals(getPrazoProtesto(), other.getPrazoProtesto());
            result = result
                     && equals(getQuantidadeMoeda(), other.getQuantidadeMoeda());
            result = result
                     && equals(getSequencialDia(), other.getSequencialDia());
            result = result
                     && equals(getSituacaoTitulo(), other.getSituacaoTitulo());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result
                     && equals(getValorAbatimento(), other.getValorAbatimento());
            result = result
                     && equals(getValorCobrado(), other.getValorCobrado());
            result = result
                     && equals(getValorDesconto1(), other.getValorDesconto1());
            result = result
                     && equals(getValorDesconto2(), other.getValorDesconto2());
            result = result
                     && equals(getValorDesconto3(), other.getValorDesconto3());
            result = result && equals(getValorJuros(), other.getValorJuros());
            result = result && equals(getValorMulta(), other.getValorMulta());
            result = result && equals(getValorTitulo(), other.getValorTitulo());
            result = result && equals(getNumeroDDA(), other.getNumeroDDA());
            result = result && equals(getNuCIP(), other.getNuCIP());
            result = result && equals(getNuRefCIP(), other.getNuRefCIP());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
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
        properties.add(new Property("PercentualMulta",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("PvCobrador",
                LongType.create(),
                false,
                true));
        properties.add(new Property("PvRecebedor",
                LongType.create(),
                false,
                true));
        properties.add(new Property("aceite", StringType.create(), false, true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dataCredito",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataDesconto1",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataDesconto2",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataDesconto3",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataEmissao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataEntrada",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataMulta", DateType.create(), false, true));
        properties.add(new Property("dataPagamento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataProtesto",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataSituacao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataVencimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("descricaoModalidade",
                StringType.create(),
                false,
                true));
        properties.add(new Property("especieTitulo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("meioEntrada",
                StringType.create(),
                false,
                true));
        properties.add(new Property("modalidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("moeda", StringType.create(), false, true));
        properties.add(new Property("nomeSacado",
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
        properties.add(new Property("numeroLote",
                LongType.create(),
                false,
                true));
        properties.add(new Property("percentualDesconto1",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("percentualDesconto2",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("percentualDesconto3",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("percentualJurosDia",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("prazoDesconto1",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoDesconto2",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoDesconto3",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoMulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoProtesto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("quantidadeMoeda",
                LongType.create(),
                false,
                true));
        properties.add(new Property("sequencialDia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("situacaoTitulo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("valorAbatimento",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorCobrado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorDesconto1",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorDesconto2",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorDesconto3",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorJuros",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorMulta",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTitulo",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("numeroDDA",
                LongType.create(),
                false,
                true));
        
        properties.add(new Property("nuCIP",
        		  StringType.create(),
                false,
                true));
        properties.add(new Property("nuRefCIP",
        		  StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj",
      		  StringType.create(),
              false,
              true));
        
        Layout result = new Layout(properties,
                "DdaTituloBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("dataDesconto1", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataPagamento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("prazoDesconto3", new LongValue("9(02)"));
        Mainframe.put("dataCredito", new DateValue("dd.MM.yyyy"));
        Mainframe.put("prazoDesconto2", new LongValue("9(02)"));
        Mainframe.put("prazoDesconto1", new LongValue("9(02)"));
        Mainframe.put("meioEntrada", new StringValue("X(40)"));
        Mainframe.put("dataMulta", new DateValue("dd.MM.yyyy"));
        Mainframe.put("modalidade", new LongValue("9(03)"));
        Mainframe.put("prazoProtesto", new LongValue("9(02)"));
        Mainframe.put("valorDesconto3", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorDesconto2", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorDesconto1", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));// EAM 13/09 de
                                                                // 17 p/ 18
        Mainframe.put("PvRecebedor", new LongValue("9(04)"));
        Mainframe.put("aceite", new StringValue("X(40)"));
        Mainframe.put("sequencialDia", new LongValue("9(09)"));
        Mainframe.put("numeroLote", new LongValue("9(09)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("moeda", new StringValue("X(15)"));
        Mainframe.put("valorAbatimento", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("numeroDocumento", new StringValue("X(18)"));
        Mainframe.put("valorJuros", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("situacaoTitulo", new StringValue("X(40)"));
        Mainframe.put("especieTitulo", new StringValue("X(03)"));
        Mainframe.put("dataEmissao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataVencimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("prazoMulta", new LongValue("9(02)"));
        Mainframe.put("PvCobrador", new LongValue("9(04)"));
        Mainframe.put("descricaoModalidade", new StringValue("X(40)"));
        Mainframe.put("dataSituacao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("nomeSacado", new StringValue("X(40)"));
        Mainframe.put("percentualDesconto3", new PercentualValue("9(05)"));
        Mainframe.put("dataProtesto", new DateValue("dd.MM.yyyy"));
        Mainframe.put("percentualDesconto2", new PercentualValue("9(05)"));
        Mainframe.put("percentualJurosDia", new PercentualValue("9(05)"));
        Mainframe.put("percentualDesconto1", new PercentualValue("9(05)"));
        Mainframe.put("quantidadeMoeda", new LongValue("9(08)"));
        Mainframe.put("valorTitulo", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("dataEntrada", new DateValue("dd.MM.yyyy"));
        Mainframe.put("PercentualMulta", new PercentualValue("9(05)"));
        Mainframe.put("valorMulta", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("valorCobrado", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("dataDesconto3", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataDesconto2", new DateValue("dd.MM.yyyy"));
        Mainframe.put("numeroDDA", new LongValue("9(18)"));
        Mainframe.put("nuCIP",  new StringValue("X(19)"));
        Mainframe.put("nuRefCIP", new StringValue("X(19)"));
        Mainframe.put("cpfCnpj", new StringValue("X(20)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
