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
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteInformeTarifasBean extends SigcbBean {

    /**
     * Este campo foi renomeado de "codigoAgrupamentoServiço" para
     * "codigoAgrupamentoServico" devido a problemas de deploy no UNIX. David
     * Lopes P561913 23/01/2007
     */

    private java.lang.String codigoAgrupamentoServico;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoClienteCOCLI;

    private java.lang.Long codigoServico;

    private java.lang.Long codigoUnidadePVVinc;

    private java.lang.String descricaoCriticas;

    private java.lang.String descricaoServico;

    private java.lang.String nsuTransacao;

    private java.lang.Long percentualCalculado;

    private java.lang.Long percentualOriginal;

    private java.lang.String tipoAcao;

    private java.lang.String tipoConsulta;

    private br.com.politec.sao.util.Money valorCalculado;

    private br.com.politec.sao.util.Money valorOriginal;

    public CedenteInformeTarifasBean() {
        this.codigoAgrupamentoServico = null;
        this.codigoCedente = null;
        this.codigoClienteCOCLI = null;
        this.codigoServico = null;
        this.codigoUnidadePVVinc = null;
        this.descricaoCriticas = null;
        this.descricaoServico = null;
        this.nsuTransacao = null;
        this.percentualCalculado = null;
        this.percentualOriginal = null;
        this.tipoAcao = null;
        this.tipoConsulta = null;
        this.valorCalculado = null;
        this.valorOriginal = null;
    }

    public String getApplicationName() {
        return "CedenteInformeTarifasBean";
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

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public java.lang.Long getPercentualCalculado() {
        return this.percentualCalculado;
    }

    public void setPercentualCalculado(java.lang.Long percentualCalculado) {
        this.percentualCalculado = percentualCalculado;
    }

    public java.lang.Long getPercentualOriginal() {
        return this.percentualOriginal;
    }

    public void setPercentualOriginal(java.lang.Long percentualOriginal) {
        this.percentualOriginal = percentualOriginal;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
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
            CedenteInformeTarifasBean other = (CedenteInformeTarifasBean) obj;
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
                     && equals(getDescricaoCriticas(),
                             other.getDescricaoCriticas());
            result = result
                     && equals(getDescricaoServico(),
                             other.getDescricaoServico());
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result
                     && equals(getPercentualCalculado(),
                             other.getPercentualCalculado());
            result = result
                     && equals(getPercentualOriginal(),
                             other.getPercentualOriginal());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
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
        properties.add(new Property("descricaoCriticas",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricaoServico",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("percentualCalculado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("percentualOriginal",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
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
                "CedenteInformeTarifasBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("descricaoCriticas", new StringValue("X(200)"));
        Mainframe.put("valorCalculado", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("codigoServico", new LongValue("9(03)"));
        Mainframe.put("percentualOriginal", new LongValue("9(05)"));
        Mainframe.put("codigoUnidadePVVinc", new LongValue("9(04)"));
        Mainframe.put("codigoAgrupamentoServico", new StringValue("X(03)"));
        Mainframe.put("percentualCalculado", new LongValue("9(05)"));
        Mainframe.put("tipoConsulta", new StringValue("X(01)"));
        Mainframe.put("descricaoServico", new StringValue("X(40)"));
        Mainframe.put("valorOriginal", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("codigoClienteCOCLI", new LongValue("9(13)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
