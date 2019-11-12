package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.PercentualType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.PercentualValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Percentual;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteTarifasBean extends SigcbBean {
    private java.lang.String codigoAgrupamentoServico;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoClienteCOCLI;

    private java.lang.Long codigoServico;

    private java.lang.Long codigoUnidadePVVinc;

    private java.lang.String descFormaCalculo;

    private java.lang.String descricaoAgrupamentoServico;

    private java.lang.String descricaoCriticas;

    private java.lang.String descricaoServico;

    private java.lang.Long diaDebito;

    private java.lang.Long formaCalculo;

    private java.lang.String nsuTransacao;

    private java.lang.Long numeroPacote;

    private java.lang.Long numeroTotalPacotes;

    private Percentual percentualCalculado;

    private Percentual percentualOriginal;

    private java.lang.String periodicidadeTarifa;

    private java.lang.String periodicidadeTarifaDesc;

    private java.lang.String situacaoGuia;

    private java.lang.String strRecordset;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoConclusao;

    private java.lang.String tipoConsulta;

    private br.com.politec.sao.util.Money valorCalculado;

    private br.com.politec.sao.util.Money valorOriginal;

    public CedenteTarifasBean() {
        this.codigoAgrupamentoServico = null;
        this.codigoCedente = null;
        this.codigoClienteCOCLI = null;
        this.codigoServico = null;
        this.codigoUnidadePVVinc = null;
        this.descFormaCalculo = null;
        this.descricaoAgrupamentoServico = null;
        this.descricaoCriticas = null;
        this.descricaoServico = null;
        this.diaDebito = null;
        this.formaCalculo = null;
        this.nsuTransacao = null;
        this.numeroPacote = null;
        this.numeroTotalPacotes = null;
        this.percentualCalculado = null;
        this.percentualOriginal = null;
        this.periodicidadeTarifa = null;
        this.situacaoGuia = null;
        this.strRecordset = null;
        this.tipoAcao = null;
        this.tipoConclusao = null;
        this.tipoConsulta = null;
        this.valorCalculado = null;
        this.valorOriginal = null;
    }

    public String getApplicationName() {
        return "CedenteTarifasBean";
    }

    public java.lang.String getCodigoAgrupamentoServico() {
        return this.codigoAgrupamentoServico;
    }

    public void setCodigoAgrupamentoServico(java.lang.String codigoAgrupamentoServico) {
        this.codigoAgrupamentoServico = codigoAgrupamentoServico;
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

    public java.lang.Long getCodigoServico() {
        return this.codigoServico;
    }

    public void setCodigoServico(java.lang.Long codigoServico) {
        this.codigoServico = codigoServico;
    }

    public java.lang.Long getCodigoUnidadePVVinc() {
        return this.codigoUnidadePVVinc;
    }

    public void setCodigoUnidadePVVinc(java.lang.Long codigoUnidadePVVinc) {
        this.codigoUnidadePVVinc = codigoUnidadePVVinc;
    }

    public java.lang.String getDescFormaCalculo() {
        return this.descFormaCalculo;
    }

    public void setDescFormaCalculo(java.lang.String descFormaCalculo) {
        this.descFormaCalculo = descFormaCalculo;
    }

    public java.lang.String getDescricaoAgrupamentoServico() {
        return this.descricaoAgrupamentoServico;
    }

    public void setDescricaoAgrupamentoServico(java.lang.String descricaoAgrupamentoServico) {
        this.descricaoAgrupamentoServico = descricaoAgrupamentoServico;
    }

    public java.lang.String getDescricaoCriticas() {
        return this.descricaoCriticas;
    }

    public void setDescricaoCriticas(java.lang.String descricaoCriticas) {
        this.descricaoCriticas = descricaoCriticas;
    }

    public java.lang.String getDescricaoServico() {
        return this.descricaoServico;
    }

    public void setDescricaoServico(java.lang.String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public java.lang.Long getDiaDebito() {
        return this.diaDebito;
    }

    public void setDiaDebito(java.lang.Long diaDebito) {
        this.diaDebito = diaDebito;
    }

    public java.lang.Long getFormaCalculo() {
        return this.formaCalculo;
    }

    public void setFormaCalculo(java.lang.Long formaCalculo) {
        this.formaCalculo = formaCalculo;
    }

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
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

    public Percentual getPercentualCalculado() {
        return this.percentualCalculado;
    }

    public void setPercentualCalculado(Percentual percentualCalculado) {
        this.percentualCalculado = percentualCalculado;
    }

    public Percentual getPercentualOriginal() {
        return this.percentualOriginal;
    }

    public void setPercentualOriginal(Percentual percentualOriginal) {
        this.percentualOriginal = percentualOriginal;
    }

    public java.lang.String getPeriodicidadeTarifa() {
        return this.periodicidadeTarifa;
    }

    public void setPeriodicidadeTarifa(java.lang.String periodicidadeTarifa) {
        this.periodicidadeTarifa = periodicidadeTarifa;
    }

    public java.lang.String getPeriodicidadeTarifaDesc() {
        return this.periodicidadeTarifaDesc;
    }

    public void setPeriodicidadeTarifaDesc(java.lang.String periodicidadeTarifaDesc) {
        this.periodicidadeTarifaDesc = periodicidadeTarifaDesc;
    }

    public java.lang.String getSituacaoGuia() {
        return this.situacaoGuia;
    }

    public void setSituacaoGuia(java.lang.String situacaoGuia) {
        this.situacaoGuia = situacaoGuia;
    }

    public java.lang.String getStrRecordset() {
        return this.strRecordset;
    }

    public void setStrRecordset(java.lang.String strRecordset) {
        this.strRecordset = strRecordset;
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

    public br.com.politec.sao.util.Money getValorCalculado() {
        return this.valorCalculado;
    }

    public void setValorCalculado(br.com.politec.sao.util.Money valorCalculado) {
        this.valorCalculado = valorCalculado;
    }

    public br.com.politec.sao.util.Money getValorOriginal() {
        return this.valorOriginal;
    }

    public void setValorOriginal(br.com.politec.sao.util.Money valorOriginal) {
        this.valorOriginal = valorOriginal;
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
            CedenteTarifasBean other = (CedenteTarifasBean) obj;
            result = result
                     && equals(getCodigoAgrupamentoServico(),
                             other.getCodigoAgrupamentoServico());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoClienteCOCLI(),
                             other.getCodigoClienteCOCLI());
            result = result
                     && equals(getCodigoServico(), other.getCodigoServico());
            result = result
                     && equals(getCodigoUnidadePVVinc(),
                             other.getCodigoUnidadePVVinc());
            result = result
                     && equals(getDescFormaCalculo(),
                             other.getDescFormaCalculo());
            result = result
                     && equals(getDescricaoAgrupamentoServico(),
                             other.getDescricaoAgrupamentoServico());
            result = result
                     && equals(getDescricaoCriticas(),
                             other.getDescricaoCriticas());
            result = result
                     && equals(getDescricaoServico(),
                             other.getDescricaoServico());
            result = result && equals(getDiaDebito(), other.getDiaDebito());
            result = result
                     && equals(getFormaCalculo(), other.getFormaCalculo());
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result
                     && equals(getNumeroPacote(), other.getNumeroPacote());
            result = result
                     && equals(getNumeroTotalPacotes(),
                             other.getNumeroTotalPacotes());
            result = result
                     && equals(getPercentualCalculado(),
                             other.getPercentualCalculado());
            result = result
                     && equals(getPercentualOriginal(),
                             other.getPercentualOriginal());
            result = result
                     && equals(getPeriodicidadeTarifa(),
                             other.getPeriodicidadeTarifa());
            result = result
                     && equals(getPeriodicidadeTarifaDesc(),
                             other.getPeriodicidadeTarifa());
            result = result
                     && equals(getSituacaoGuia(), other.getSituacaoGuia());
            result = result
                     && equals(getStrRecordset(), other.getStrRecordset());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoConclusao(), other.getTipoConclusao());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result
                     && equals(getValorCalculado(), other.getValorCalculado());
            result = result
                     && equals(getValorOriginal(), other.getValorOriginal());
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
        properties.add(new Property("codigoAgrupamentoServico",
                StringType.create(),
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
        properties.add(new Property("codigoServico",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePVVinc",
                LongType.create(),
                false,
                true));
        properties.add(new Property("descFormaCalculo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricaoAgrupamentoServico",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricaoCriticas",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricaoServico",
                StringType.create(),
                false,
                true));
        properties.add(new Property("diaDebito", LongType.create(), false, true));
        properties.add(new Property("formaCalculo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nsuTransacao",
                StringType.create(),
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
        properties.add(new Property("percentualCalculado",
                PercentualType.create(),
                false,
                true));
        properties.add(new Property("percentualOriginal",
                PercentualType.create(),
                false,
                true));
        properties.add(new Property("periodicidadeTarifa",
                StringType.create(),
                false,
                true));
        properties.add(new Property("periodicidadeTarifaDesc",
                StringType.create(),
                false,
                true));
        properties.add(new Property("situacaoGuia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("strRecordset",
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
        properties.add(new Property("valorCalculado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorOriginal",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedenteTarifasBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoAgrupamentoServico", new StringValue("X(03)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("codigoClienteCOCLI", new LongValue("9(13)"));
        Mainframe.put("codigoServico", new LongValue("9(03)"));
        Mainframe.put("codigoUnidadePVVinc", new LongValue("9(04)"));
        Mainframe.put("descFormaCalculo", new StringValue("X(40)"));
        Mainframe.put("descricaoAgrupamentoServico", new StringValue("X(40)"));
        Mainframe.put("descricaoCriticas", new StringValue("X(200)"));
        Mainframe.put("descricaoServico", new StringValue("X(40)"));
        Mainframe.put("diaDebito", new LongValue("9(02)"));
        Mainframe.put("formaCalculo", new LongValue("9(01)"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("numeroPacote", new LongValue("9(03)"));
        Mainframe.put("numeroTotalPacotes", new LongValue("9(03)"));
        Mainframe.put("percentualCalculado", new PercentualValue("9(07)"));
        Mainframe.put("percentualOriginal", new PercentualValue("9(07)"));
        Mainframe.put("periodicidadeTarifa", new StringValue("X(01)"));
        Mainframe.put("periodicidadeTarifaDesc", new StringValue("X(40)"));
        Mainframe.put("situacaoGuia", new StringValue("X(01)"));
        Mainframe.put("strRecordset", new StringValue("X(913)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("tipoConclusao", new LongValue("9(02)"));
        Mainframe.put("tipoConsulta", new StringValue("X(01)"));
        Mainframe.put("valorCalculado", new MoneyValue("R$ 9(11)v99"));
        Mainframe.put("valorOriginal", new MoneyValue("R$ 9(11)v99"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
