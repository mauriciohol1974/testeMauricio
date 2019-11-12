//Bean alterado manualmente - Cuidado ao gerar
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

public class LiquidacoesRejeitadaBean extends SigcbBean {
    private java.lang.Long codigoCedenteCorrigido;

    private java.lang.Long codigoCedenteOriginal;

    private java.lang.Long codigoErro;

    private java.lang.Long codigoUnidadePV;

    private java.util.Date dataInicial;

    private java.util.Date dataMovimento;

    private java.util.Date dataReferencia;

    private java.util.Date dataSituacaoAnterior;

    private java.lang.String descricaoTipoCarteira;

    private java.lang.Long meioLiquidacao;

    private java.lang.String meioLiquidacaoDescricao;

    private java.lang.String mensagemErro;

    private java.lang.Long nossoNumeroCorrigido;

    private java.lang.Long nossoNumeroOriginal;

    private java.lang.Long numeroBanco;

    private java.lang.Long numeroLote;

    private java.lang.Long numeroLoteCorreto;

    private java.lang.Long numeroLoterico;

    private java.lang.Long numeroSequencia;

    private java.lang.String radioAcao;

    private java.lang.Long registro;

    private java.lang.Long sequenciaLote;

    private java.lang.Long situacaoAnterior;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoCarteira;

    private java.lang.Long tipoOpcao;

    private java.lang.String tipoOpcaoDescricao;

    private java.lang.Long tipoSolicitacao;

    private java.lang.String usuario;

    private br.com.politec.sao.util.Money valorCorrigido;

    private br.com.politec.sao.util.Money valorOriginal;

    private br.com.politec.sao.util.Money valorRecebido;
    
    private String parcela;

    public LiquidacoesRejeitadaBean() {
        this.codigoCedenteCorrigido = null;
        this.codigoCedenteOriginal = null;
        this.codigoErro = null;
        this.codigoUnidadePV = null;
        this.dataInicial = null;
        this.dataMovimento = null;
        this.dataReferencia = null;
        this.dataSituacaoAnterior = null;
        this.descricaoTipoCarteira = null;
        this.meioLiquidacao = null;
        this.meioLiquidacaoDescricao = null;
        this.mensagemErro = null;
        this.nossoNumeroCorrigido = null;
        this.nossoNumeroOriginal = null;
        this.numeroBanco = null;
        this.numeroLote = null;
        this.numeroLoteCorreto = null;
        this.numeroLoterico = null;
        this.numeroSequencia = null;
        this.radioAcao = null;
        this.registro = null;
        this.sequenciaLote = null;
        this.situacaoAnterior = null;
        this.tipoAcao = null;
        this.tipoCarteira = null;
        this.tipoOpcao = null;
        this.tipoOpcaoDescricao = null;
        this.tipoSolicitacao = null;
        this.usuario = null;
        this.valorCorrigido = null;
        this.valorOriginal = null;
        this.valorRecebido = null;
        this.parcela = null;
    }

    public String getApplicationName() {
        return "LiquidacoesRejeitadaBean";
    }

    public java.lang.Long getCodigoCedenteCorrigido() {
        return this.codigoCedenteCorrigido;
    }

    public void setCodigoCedenteCorrigido(java.lang.Long codigoCedenteCorrigido) {
        this.codigoCedenteCorrigido = codigoCedenteCorrigido;
    }

    public java.lang.Long getCodigoCedenteOriginal() {
        return this.codigoCedenteOriginal;
    }

    public void setCodigoCedenteOriginal(java.lang.Long codigoCedenteOriginal) {
        this.codigoCedenteOriginal = codigoCedenteOriginal;
    }

    public java.lang.Long getCodigoErro() {
        return this.codigoErro;
    }

    public void setCodigoErro(java.lang.Long codigoErro) {
        this.codigoErro = codigoErro;
    }

    public java.lang.Long getCodigoUnidadePV() {
        return this.codigoUnidadePV;
    }

    public void setCodigoUnidadePV(java.lang.Long codigoUnidadePV) {
        this.codigoUnidadePV = codigoUnidadePV;
    }

    public java.util.Date getDataInicial() {
        return this.dataInicial;
    }

    public void setDataInicial(java.util.Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public java.util.Date getDataMovimento() {
        return this.dataMovimento;
    }

    public void setDataMovimento(java.util.Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public java.util.Date getDataReferencia() {
        return this.dataReferencia;
    }

    public void setDataReferencia(java.util.Date dataReferencia) {
        this.dataReferencia = dataReferencia;
    }

    public java.util.Date getDataSituacaoAnterior() {
        return this.dataSituacaoAnterior;
    }

    public void setDataSituacaoAnterior(java.util.Date dataSituacaoAnterior) {
        this.dataSituacaoAnterior = dataSituacaoAnterior;
    }

    public java.lang.String getDescricaoTipoCarteira() {
        return this.descricaoTipoCarteira;
    }

    public void setDescricaoTipoCarteira(java.lang.String descricaoTipoCarteira) {
        this.descricaoTipoCarteira = descricaoTipoCarteira;
    }

    public java.lang.Long getMeioLiquidacao() {
        return this.meioLiquidacao;
    }

    public void setMeioLiquidacao(java.lang.Long meioLiquidacao) {
        this.meioLiquidacao = meioLiquidacao;
    }

    public java.lang.String getMeioLiquidacaoDescricao() {
        return this.meioLiquidacaoDescricao;
    }

    public void setMeioLiquidacaoDescricao(java.lang.String meioLiquidacaoDescricao) {
        this.meioLiquidacaoDescricao = meioLiquidacaoDescricao;
    }

    public java.lang.String getMensagemErro() {
        return this.mensagemErro;
    }

    public void setMensagemErro(java.lang.String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public java.lang.Long getNossoNumeroCorrigido() {
        return this.nossoNumeroCorrigido;
    }

    public void setNossoNumeroCorrigido(java.lang.Long nossoNumeroCorrigido) {
        this.nossoNumeroCorrigido = nossoNumeroCorrigido;
    }

    public java.lang.Long getNossoNumeroOriginal() {
        return this.nossoNumeroOriginal;
    }

    public void setNossoNumeroOriginal(java.lang.Long nossoNumeroOriginal) {
        this.nossoNumeroOriginal = nossoNumeroOriginal;
    }

    public java.lang.Long getNumeroBanco() {
        return this.numeroBanco;
    }

    public void setNumeroBanco(java.lang.Long numeroBanco) {
        this.numeroBanco = numeroBanco;
    }

    public java.lang.Long getNumeroLote() {
        return this.numeroLote;
    }

    public void setNumeroLote(java.lang.Long numeroLote) {
        this.numeroLote = numeroLote;
    }

    public java.lang.Long getNumeroLoteCorreto() {
        return this.numeroLoteCorreto;
    }

    public void setNumeroLoteCorreto(java.lang.Long numeroLoteCorreto) {
        this.numeroLoteCorreto = numeroLoteCorreto;
    }

    public java.lang.Long getNumeroLoterico() {
        return this.numeroLoterico;
    }

    public void setNumeroLoterico(java.lang.Long numeroLoterico) {
        this.numeroLoterico = numeroLoterico;
    }

    public java.lang.Long getNumeroSequencia() {
        return this.numeroSequencia;
    }

    public void setNumeroSequencia(java.lang.Long numeroSequencia) {
        this.numeroSequencia = numeroSequencia;
    }

    public java.lang.String getRadioAcao() {
        return this.radioAcao;
    }

    public void setRadioAcao(java.lang.String radioAcao) {
        this.radioAcao = radioAcao;
    }

    public java.lang.Long getRegistro() {
        return this.registro;
    }

    public void setRegistro(java.lang.Long registro) {
        this.registro = registro;
    }

    public java.lang.Long getSequenciaLote() {
        return this.sequenciaLote;
    }

    public void setSequenciaLote(java.lang.Long sequenciaLote) {
        this.sequenciaLote = sequenciaLote;
    }

    public java.lang.Long getSituacaoAnterior() {
        return this.situacaoAnterior;
    }

    public void setSituacaoAnterior(java.lang.Long situacaoAnterior) {
        this.situacaoAnterior = situacaoAnterior;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoCarteira() {
        return this.tipoCarteira;
    }

    public void setTipoCarteira(java.lang.Long tipoCarteira) {
        this.tipoCarteira = tipoCarteira;
    }

    public java.lang.Long getTipoOpcao() {
        return this.tipoOpcao;
    }

    public void setTipoOpcao(java.lang.Long tipoOpcao) {
        this.tipoOpcao = tipoOpcao;
    }

    public java.lang.String getTipoOpcaoDescricao() {
        return this.tipoOpcaoDescricao;
    }

    public void setTipoOpcaoDescricao(java.lang.String tipoOpcaoDescricao) {
        this.tipoOpcaoDescricao = tipoOpcaoDescricao;
    }

    public java.lang.Long getTipoSolicitacao() {
        return this.tipoSolicitacao;
    }

    public void setTipoSolicitacao(java.lang.Long tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }

    public java.lang.String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    public br.com.politec.sao.util.Money getValorCorrigido() {
        return this.valorCorrigido;
    }

    public void setValorCorrigido(br.com.politec.sao.util.Money valorCorrigido) {
        this.valorCorrigido = valorCorrigido;
    }

    public br.com.politec.sao.util.Money getValorOriginal() {
        return this.valorOriginal;
    }

    public void setValorOriginal(br.com.politec.sao.util.Money valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public br.com.politec.sao.util.Money getValorRecebido() {
        return this.valorRecebido;
    }

    public void setValorRecebido(br.com.politec.sao.util.Money valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    // Inicio das alterações
    public java.lang.String getDataInicialFormatada() {
        if (this.dataInicial != null) {
            return Formatador.formatarData(this.dataInicial);
        } else {
            return "";
        }
    }

    public java.lang.String getDataMovimentoFormatada() {
        if (this.dataMovimento != null) {
            return Formatador.formatarData(this.dataMovimento);
        }
        return "";
    }

    public java.lang.String getDataReferenciaFormatada() {
        if (this.dataReferencia != null) {
            return Formatador.formatarData(this.dataReferencia);
        } else {
            return "";
        }
    }

    public java.lang.String getDataSituacaoAnteriorFormatada() {
        if (this.dataSituacaoAnterior != null) {
            return Formatador.formatarData(this.dataSituacaoAnterior);
        }
        return "";
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteOriginalFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedenteOriginal);
        return codigoCedenteFormatado;
    }

    public java.lang.String getCodigoCedenteCorrigidoFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedenteCorrigido);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getNossoNumeroFormatado-----------------------
    // EAM - 12/09 - Alterado NN de 17 p/ 18
    public java.lang.String getNossoNumeroOriginalFormatado() {
        String nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumeroOriginal,
                18);
        return nossoNumeroFormatado;
    }

    public java.lang.String getNossoNumeroCorrigidoFormatado() {
        String nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumeroCorrigido,
                18);
        return nossoNumeroFormatado;
    }

    // fim-------------getNossoNumeroFormatado-----------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadePVFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePV);
        return codigoUnidadeFormatado;
    }
    
    

    // fim-------------getCodigoUnidadeFormatado---------------------

    // Fim das alterações

    public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            LiquidacoesRejeitadaBean other = (LiquidacoesRejeitadaBean) obj;
            result = result
                     && equals(getCodigoCedenteCorrigido(),
                             other.getCodigoCedenteCorrigido());
            result = result
                     && equals(getCodigoCedenteOriginal(),
                             other.getCodigoCedenteOriginal());
            result = result && equals(getCodigoErro(), other.getCodigoErro());
            result = result
                     && equals(getCodigoUnidadePV(), other.getCodigoUnidadePV());
            result = result && equals(getDataInicial(), other.getDataInicial());
            result = result
                     && equals(getDataMovimento(), other.getDataMovimento());
            result = result
                     && equals(getDataReferencia(), other.getDataReferencia());
            result = result
                     && equals(getDataSituacaoAnterior(),
                             other.getDataSituacaoAnterior());
            result = result
                     && equals(getDescricaoTipoCarteira(),
                             other.getDescricaoTipoCarteira());
            result = result
                     && equals(getMeioLiquidacao(), other.getMeioLiquidacao());
            result = result
                     && equals(getMeioLiquidacaoDescricao(),
                             other.getMeioLiquidacaoDescricao());
            result = result
                     && equals(getMensagemErro(), other.getMensagemErro());
            result = result
                     && equals(getNossoNumeroCorrigido(),
                             other.getNossoNumeroCorrigido());
            result = result
                     && equals(getNossoNumeroOriginal(),
                             other.getNossoNumeroOriginal());
            result = result && equals(getNumeroBanco(), other.getNumeroBanco());
            result = result && equals(getNumeroLote(), other.getNumeroLote());
            result = result
                     && equals(getNumeroLoteCorreto(),
                             other.getNumeroLoteCorreto());
            result = result
                     && equals(getNumeroLoterico(), other.getNumeroLoterico());
            result = result
                     && equals(getNumeroSequencia(), other.getNumeroSequencia());
            result = result && equals(getRadioAcao(), other.getRadioAcao());
            result = result && equals(getRegistro(), other.getRegistro());
            result = result
                     && equals(getSequenciaLote(), other.getSequenciaLote());
            result = result
                     && equals(getSituacaoAnterior(),
                             other.getSituacaoAnterior());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoCarteira(), other.getTipoCarteira());
            result = result && equals(getTipoOpcao(), other.getTipoOpcao());
            result = result
                     && equals(getTipoOpcaoDescricao(),
                             other.getTipoOpcaoDescricao());
            result = result
                     && equals(getTipoSolicitacao(), other.getTipoSolicitacao());
            result = result && equals(getUsuario(), other.getUsuario());
            result = result
                     && equals(getValorCorrigido(), other.getValorCorrigido());
            result = result
                     && equals(getValorOriginal(), other.getValorOriginal());
            result = result
                     && equals(getValorRecebido(), other.getValorRecebido());
            result = result  && equals(getParcela(), other.getParcela());
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
        properties.add(new Property("codigoCedenteCorrigido",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedenteOriginal",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoErro",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dataInicial",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataMovimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataReferencia",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataSituacaoAnterior",
                DateType.create(),
                false,
                true));
        properties.add(new Property("descricaoTipoCarteira",
                StringType.create(),
                false,
                true));
        properties.add(new Property("meioLiquidacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioLiquidacaoDescricao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("mensagemErro",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nossoNumeroCorrigido",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nossoNumeroOriginal",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroBanco",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroLote",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroLoteCorreto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroLoterico",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroSequencia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("radioAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("registro", LongType.create(), false, true));
        properties.add(new Property("sequenciaLote",
                LongType.create(),
                false,
                true));
        properties.add(new Property("situacaoAnterior",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoCarteira",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoOpcao", LongType.create(), false, true));
        properties.add(new Property("tipoOpcaoDescricao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("parcela",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoSolicitacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("usuario", StringType.create(), false, true));
        properties.add(new Property("valorCorrigido",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorOriginal",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorRecebido",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "LiquidacoesRejeitadaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedenteOriginal", new LongValue("9(07)"));
        Mainframe.put("dataSituacaoAnterior", new DateValue("dd.MM.yyyy"));
        Mainframe.put("numeroLoteCorreto", new LongValue("9(09)"));
        Mainframe.put("descricaoTipoCarteira", new StringValue("X(40)"));
        Mainframe.put("numeroSequencia", new LongValue("9(09)"));
        Mainframe.put("tipoOpcaoDescricao", new StringValue("X(40)"));
        Mainframe.put("codigoUnidadePV", new LongValue("9(04)"));
        Mainframe.put("meioLiquidacaoDescricao", new StringValue("X(40)"));
        Mainframe.put("dataInicial", new DateValue("dd.MM.yyyy"));
        Mainframe.put("meioLiquidacao", new LongValue("9(02)"));
        Mainframe.put("valorOriginal", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("numeroLoterico", new LongValue("9(08)"));
        Mainframe.put("codigoErro", new LongValue("9(5)"));
        Mainframe.put("nossoNumeroCorrigido", new LongValue("9(18)"));
        Mainframe.put("nossoNumeroOriginal", new LongValue("9(18)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("registro", new LongValue("9(18)"));
        Mainframe.put("situacaoAnterior", new LongValue("9(01)"));
        Mainframe.put("valorCorrigido", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("usuario", new StringValue("X(08)"));
        Mainframe.put("mensagemErro", new StringValue("X(80)"));
        Mainframe.put("sequenciaLote", new LongValue("9(09)"));
        Mainframe.put("dataReferencia", new DateValue("dd.MM.yyyy"));
        Mainframe.put("numeroLote", new LongValue("9(09)"));
        Mainframe.put("tipoSolicitacao", new LongValue("9(02)"));
        Mainframe.put("radioAcao", new StringValue("X(40)"));
        Mainframe.put("codigoCedenteCorrigido", new LongValue("9(07)"));
        Mainframe.put("dataMovimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valorRecebido", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("tipoCarteira", new LongValue("9(02)"));
        Mainframe.put("numeroBanco", new LongValue("9(04)"));
        Mainframe.put("tipoOpcao", new LongValue("9(02)"));
        Mainframe.put("parcela", new StringValue("X(07)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
