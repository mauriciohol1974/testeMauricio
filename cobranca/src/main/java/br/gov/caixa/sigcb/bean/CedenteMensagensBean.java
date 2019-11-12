package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteMensagensBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoClienteCOCLI;

    private java.lang.Long codigoUnidadePVVinc;

    private java.lang.String descricaoCriticas;

    private java.lang.Long localImpressao;

    private java.lang.String mensagem;

    private java.lang.String nsuTransacao;

    private java.lang.Long numeroLinhaMensagem;

    private java.lang.Long numeroPacote;

    private java.lang.Long numeroTotalPacotes;

    private java.lang.String strRecordset;

    private java.lang.String textAreaFichaCompensacaoBlqPadrao;

    private java.lang.String textAreaFichaCompensacaoBlqPersonalizado;

    private java.lang.String textAreaFichaCompensacaoBlqPreImpresso;

    private java.lang.String textAreaReciboSacadoABlqPersonalizado;

    private java.lang.String textAreaReciboSacadoBBlqPersonalizado;

    private java.lang.String textAreaReciboSacadoBancoCorresp;
    
    private java.lang.String textAreaReciboDDAImpresso;

    private java.lang.String textAreaReciboSacadoBlqPadrao;

    private java.lang.String textAreaReciboSacadoBlqPersonalizado;

    private java.lang.String textAreaReciboSacadoBlqPreImpresso;

    private java.lang.String textAreaVersoBloquetoBlqPadrao;

    private java.lang.String textAreaVersoBloquetoBlqPersonalizado;

    private java.lang.String textAreaVersoBloquetoBlqPreImpresso;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoConclusao;

    private java.lang.String tipoConsulta;

    public CedenteMensagensBean() {
        this.codigoCedente = null;
        this.codigoClienteCOCLI = null;
        this.codigoUnidadePVVinc = null;
        this.descricaoCriticas = null;
        this.localImpressao = null;
        this.mensagem = null;
        this.nsuTransacao = null;
        this.numeroLinhaMensagem = null;
        this.numeroPacote = null;
        this.numeroTotalPacotes = null;
        this.strRecordset = null;
        this.textAreaFichaCompensacaoBlqPadrao = null;
        this.textAreaFichaCompensacaoBlqPersonalizado = null;
        this.textAreaFichaCompensacaoBlqPreImpresso = null;
        this.textAreaReciboSacadoABlqPersonalizado = null;
        this.textAreaReciboSacadoBBlqPersonalizado = null;
        this.textAreaReciboSacadoBancoCorresp = null;
        this.textAreaReciboDDAImpresso = null;
        this.textAreaReciboSacadoBlqPadrao = null;
        this.textAreaReciboSacadoBlqPersonalizado = null;
        this.textAreaReciboSacadoBlqPreImpresso = null;
        this.textAreaVersoBloquetoBlqPadrao = null;
        this.textAreaVersoBloquetoBlqPersonalizado = null;
        this.textAreaVersoBloquetoBlqPreImpresso = null;
        this.tipoAcao = null;
        this.tipoConclusao = null;
        this.tipoConsulta = null;
    }

    public String getApplicationName() {
        return "CedenteMensagensBean";
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

    public java.lang.String getDescricaoCriticas() {
        return this.descricaoCriticas;
    }

    public void setDescricaoCriticas(java.lang.String descricaoCriticas) {
        this.descricaoCriticas = descricaoCriticas;
    }

    public java.lang.Long getLocalImpressao() {
        return this.localImpressao;
    }

    public void setLocalImpressao(java.lang.Long localImpressao) {
        this.localImpressao = localImpressao;
    }

    public java.lang.String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(java.lang.String mensagem) {
        this.mensagem = mensagem;
    }

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public java.lang.Long getNumeroLinhaMensagem() {
        return this.numeroLinhaMensagem;
    }

    public void setNumeroLinhaMensagem(java.lang.Long numeroLinhaMensagem) {
        this.numeroLinhaMensagem = numeroLinhaMensagem;
    }

    public java.lang.Long getNumeroPacote() {
        return this.numeroPacote;
    }

    public void setNumeroPacote(java.lang.Long numeroPacote) {
        this.numeroPacote = numeroPacote;
    }

    public java.lang.Long getNumeroTotalPacotes() {
        return this.numeroTotalPacotes;
    }

    public void setNumeroTotalPacotes(java.lang.Long numeroTotalPacotes) {
        this.numeroTotalPacotes = numeroTotalPacotes;
    }

    public java.lang.String getStrRecordset() {
        return this.strRecordset;
    }

    public void setStrRecordset(java.lang.String strRecordset) {
        this.strRecordset = strRecordset;
    }

    public java.lang.String getTextAreaFichaCompensacaoBlqPadrao() {
        return this.textAreaFichaCompensacaoBlqPadrao;
    }

    public void setTextAreaFichaCompensacaoBlqPadrao(java.lang.String textAreaFichaCompensacaoBlqPadrao) {
        this.textAreaFichaCompensacaoBlqPadrao = textAreaFichaCompensacaoBlqPadrao;
    }

    public java.lang.String getTextAreaFichaCompensacaoBlqPersonalizado() {
        return this.textAreaFichaCompensacaoBlqPersonalizado;
    }

    public void setTextAreaFichaCompensacaoBlqPersonalizado(java.lang.String textAreaFichaCompensacaoBlqPersonalizado) {
        this.textAreaFichaCompensacaoBlqPersonalizado = textAreaFichaCompensacaoBlqPersonalizado;
    }

    public java.lang.String getTextAreaFichaCompensacaoBlqPreImpresso() {
        return this.textAreaFichaCompensacaoBlqPreImpresso;
    }

    public void setTextAreaFichaCompensacaoBlqPreImpresso(java.lang.String textAreaFichaCompensacaoBlqPreImpresso) {
        this.textAreaFichaCompensacaoBlqPreImpresso = textAreaFichaCompensacaoBlqPreImpresso;
    }

    public java.lang.String getTextAreaReciboSacadoABlqPersonalizado() {
        return this.textAreaReciboSacadoABlqPersonalizado;
    }

    public void setTextAreaReciboSacadoABlqPersonalizado(java.lang.String textAreaReciboSacadoABlqPersonalizado) {
        this.textAreaReciboSacadoABlqPersonalizado = textAreaReciboSacadoABlqPersonalizado;
    }

    public java.lang.String getTextAreaReciboSacadoBBlqPersonalizado() {
        return this.textAreaReciboSacadoBBlqPersonalizado;
    }

    public void setTextAreaReciboSacadoBBlqPersonalizado(java.lang.String textAreaReciboSacadoBBlqPersonalizado) {
        this.textAreaReciboSacadoBBlqPersonalizado = textAreaReciboSacadoBBlqPersonalizado;
    }

    public java.lang.String getTextAreaReciboSacadoBancoCorresp() {
        return this.textAreaReciboSacadoBancoCorresp;
    }

    public void setTextAreaReciboSacadoBancoCorresp(java.lang.String textAreaReciboSacadoBancoCorresp) {
        this.textAreaReciboSacadoBancoCorresp = textAreaReciboSacadoBancoCorresp;
    }
    
    public java.lang.String getTextAreaReciboDDAImpresso() {
    	return this.textAreaReciboDDAImpresso;
    }
    
    public void setTextAreaReciboDDAImpresso(java.lang.String textAreaReciboDDAImpresso) {
    	this.textAreaReciboDDAImpresso = textAreaReciboDDAImpresso;
    }

    public java.lang.String getTextAreaReciboSacadoBlqPadrao() {
        return this.textAreaReciboSacadoBlqPadrao;
    }

    public void setTextAreaReciboSacadoBlqPadrao(java.lang.String textAreaReciboSacadoBlqPadrao) {
        this.textAreaReciboSacadoBlqPadrao = textAreaReciboSacadoBlqPadrao;
    }

    public java.lang.String getTextAreaReciboSacadoBlqPersonalizado() {
        return this.textAreaReciboSacadoBlqPersonalizado;
    }

    public void setTextAreaReciboSacadoBlqPersonalizado(java.lang.String textAreaReciboSacadoBlqPersonalizado) {
        this.textAreaReciboSacadoBlqPersonalizado = textAreaReciboSacadoBlqPersonalizado;
    }

    public java.lang.String getTextAreaReciboSacadoBlqPreImpresso() {
        return this.textAreaReciboSacadoBlqPreImpresso;
    }

    public void setTextAreaReciboSacadoBlqPreImpresso(java.lang.String textAreaReciboSacadoBlqPreImpresso) {
        this.textAreaReciboSacadoBlqPreImpresso = textAreaReciboSacadoBlqPreImpresso;
    }

    public java.lang.String getTextAreaVersoBloquetoBlqPadrao() {
        return this.textAreaVersoBloquetoBlqPadrao;
    }

    public void setTextAreaVersoBloquetoBlqPadrao(java.lang.String textAreaVersoBloquetoBlqPadrao) {
        this.textAreaVersoBloquetoBlqPadrao = textAreaVersoBloquetoBlqPadrao;
    }

    public java.lang.String getTextAreaVersoBloquetoBlqPersonalizado() {
        return this.textAreaVersoBloquetoBlqPersonalizado;
    }

    public void setTextAreaVersoBloquetoBlqPersonalizado(java.lang.String textAreaVersoBloquetoBlqPersonalizado) {
        this.textAreaVersoBloquetoBlqPersonalizado = textAreaVersoBloquetoBlqPersonalizado;
    }

    public java.lang.String getTextAreaVersoBloquetoBlqPreImpresso() {
        return this.textAreaVersoBloquetoBlqPreImpresso;
    }

    public void setTextAreaVersoBloquetoBlqPreImpresso(java.lang.String textAreaVersoBloquetoBlqPreImpresso) {
        this.textAreaVersoBloquetoBlqPreImpresso = textAreaVersoBloquetoBlqPreImpresso;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoConclusao() {
        return this.tipoConclusao;
    }

    public void setTipoConclusao(java.lang.Long tipoConclusao) {
        this.tipoConclusao = tipoConclusao;
    }

    public java.lang.String getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
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
            CedenteMensagensBean other = (CedenteMensagensBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoClienteCOCLI(),
                             other.getCodigoClienteCOCLI());
            result = result
                     && equals(getCodigoUnidadePVVinc(),
                             other.getCodigoUnidadePVVinc());
            result = result
                     && equals(getDescricaoCriticas(),
                             other.getDescricaoCriticas());
            result = result
                     && equals(getLocalImpressao(), other.getLocalImpressao());
            result = result && equals(getMensagem(), other.getMensagem());
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result
                     && equals(getNumeroLinhaMensagem(),
                             other.getNumeroLinhaMensagem());
            result = result
                     && equals(getNumeroPacote(), other.getNumeroPacote());
            result = result
                     && equals(getNumeroTotalPacotes(),
                             other.getNumeroTotalPacotes());
            result = result
                     && equals(getStrRecordset(), other.getStrRecordset());
            result = result
                     && equals(getTextAreaFichaCompensacaoBlqPadrao(),
                             other.getTextAreaFichaCompensacaoBlqPadrao());
            result = result
                     && equals(getTextAreaFichaCompensacaoBlqPersonalizado(),
                             other.getTextAreaFichaCompensacaoBlqPersonalizado());
            result = result
                     && equals(getTextAreaFichaCompensacaoBlqPreImpresso(),
                             other.getTextAreaFichaCompensacaoBlqPreImpresso());
            result = result
                     && equals(getTextAreaReciboSacadoABlqPersonalizado(),
                             other.getTextAreaReciboSacadoABlqPersonalizado());
            result = result
                     && equals(getTextAreaReciboSacadoBBlqPersonalizado(),
                             other.getTextAreaReciboSacadoBBlqPersonalizado());
            result = result
                     && equals(getTextAreaReciboSacadoBancoCorresp(),
                             other.getTextAreaReciboSacadoBancoCorresp());
            result = result
            		 && equals(getTextAreaReciboDDAImpresso(),
            				 other.getTextAreaReciboDDAImpresso());
            result = result
                     && equals(getTextAreaReciboSacadoBlqPadrao(),
                             other.getTextAreaReciboSacadoBlqPadrao());
            result = result
                     && equals(getTextAreaReciboSacadoBlqPersonalizado(),
                             other.getTextAreaReciboSacadoBlqPersonalizado());
            result = result
                     && equals(getTextAreaReciboSacadoBlqPreImpresso(),
                             other.getTextAreaReciboSacadoBlqPreImpresso());
            result = result
                     && equals(getTextAreaVersoBloquetoBlqPadrao(),
                             other.getTextAreaVersoBloquetoBlqPadrao());
            result = result
                     && equals(getTextAreaVersoBloquetoBlqPersonalizado(),
                             other.getTextAreaVersoBloquetoBlqPersonalizado());
            result = result
                     && equals(getTextAreaVersoBloquetoBlqPreImpresso(),
                             other.getTextAreaVersoBloquetoBlqPreImpresso());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoConclusao(), other.getTipoConclusao());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
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
        properties.add(new Property("codigoClienteCOCLI",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePVVinc",
                LongType.create(),
                false,
                true));
        properties.add(new Property("descricaoCriticas",
                StringType.create(),
                false,
                true));
        properties.add(new Property("localImpressao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("mensagem",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroLinhaMensagem",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroPacote",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroTotalPacotes",
                LongType.create(),
                false,
                true));
        properties.add(new Property("strRecordset",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaFichaCompensacaoBlqPadrao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaFichaCompensacaoBlqPersonalizado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaFichaCompensacaoBlqPreImpresso",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaReciboSacadoABlqPersonalizado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaReciboSacadoBBlqPersonalizado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaReciboSacadoBancoCorresp",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaReciboDDAImpresso",
        		StringType.create(),
        		false,
        		true));
        properties.add(new Property("textAreaReciboSacadoBlqPadrao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaReciboSacadoBlqPersonalizado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaReciboSacadoBlqPreImpresso",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaVersoBloquetoBlqPadrao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaVersoBloquetoBlqPersonalizado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textAreaVersoBloquetoBlqPreImpresso",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoConclusao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedenteMensagensBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("numeroTotalPacotes", new LongValue("9(03)"));
        Mainframe.put("numeroLinhaMensagem", new LongValue("9(02)"));
        Mainframe.put("textAreaReciboSacadoBlqPersonalizado",
                new StringValue("X(320)"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("textAreaVersoBloquetoBlqPersonalizado",
                new StringValue("X(2250)"));
        Mainframe.put("textAreaVersoBloquetoBlqPadrao",
                new StringValue("X(2250)"));
        Mainframe.put("textAreaReciboSacadoBancoCorresp",
                new StringValue("X(40)"));
        Mainframe.put("textAreaReciboDDAImpresso",
        		new StringValue("X(40)"));
        // Mainframe.put("textAreaReciboSacadoBBlqPersonalizado", new
        // StringValue("X(320)"));
        Mainframe.put("textAreaReciboSacadoBBlqPersonalizado",
                new StringValue("X(700)"));
        Mainframe.put("descricaoCriticas", new StringValue("X(200)"));
        Mainframe.put("mensagem", new StringValue("X(80)"));
        Mainframe.put("textAreaFichaCompensacaoBlqPadrao",
                new StringValue("X(80)"));
        Mainframe.put("textAreaVersoBloquetoBlqPreImpresso",
                new StringValue("X(80)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("tipoConsulta", new StringValue("X(01)"));
        Mainframe.put("textAreaFichaCompensacaoBlqPersonalizado",
                new StringValue("X(80)"));
        Mainframe.put("codigoClienteCOCLI", new LongValue("9(13)"));
        // Mainframe.put("textAreaReciboSacadoABlqPersonalizado", new
        // StringValue("X(320)"));
        Mainframe.put("textAreaReciboSacadoABlqPersonalizado",
                new StringValue("X(675)"));
        Mainframe.put("numeroPacote", new LongValue("9(03)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("localImpressao", new LongValue("9(02)"));
        Mainframe.put("textAreaReciboSacadoBlqPreImpresso",
                new StringValue("X(320)"));
        Mainframe.put("strRecordset", new StringValue("X(902)"));
        Mainframe.put("codigoUnidadePVVinc", new LongValue("9(04)"));
        Mainframe.put("textAreaReciboSacadoBlqPadrao",
                new StringValue("X(320)"));
        Mainframe.put("tipoConclusao", new LongValue("9(02)"));
        Mainframe.put("textAreaFichaCompensacaoBlqPreImpresso",
                new StringValue("X(80)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
