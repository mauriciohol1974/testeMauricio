package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.DoubleType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.DoubleValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.PercentualValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class ConGerTarifaFloatENBean extends SigcbBean {
    private java.lang.Long codigoUnidadeEn;

    private java.lang.Long codigoUnidadePv;

    // private java.lang.Long floatMedio;
    private java.lang.Double floatMedio;

    private br.com.politec.sao.util.Percentual indiceTarifa;

    private java.lang.String nomeUnidadeEn;

    private java.lang.Long quantidade;

    // private java.lang.Long totalFloatMedio;
    private java.lang.Double totalFloatMedio;

    private br.com.politec.sao.util.Money totalGeralTarifa;

    private br.com.politec.sao.util.Percentual totalIndiceTarifa;

    private java.lang.Long totalQuantidade;

    private br.com.politec.sao.util.Money totalTarifas;

    private br.com.politec.sao.util.Money totalValorMedio;

    private br.com.politec.sao.util.Money valorMedio;

    public ConGerTarifaFloatENBean() {
        this.codigoUnidadeEn = null;
        this.codigoUnidadePv = null;
        this.floatMedio = null;
        this.indiceTarifa = null;
        this.nomeUnidadeEn = null;
        this.quantidade = null;
        this.totalFloatMedio = null;
        this.totalGeralTarifa = null;
        this.totalIndiceTarifa = null;
        this.totalQuantidade = null;
        this.totalTarifas = null;
        this.totalValorMedio = null;
        this.valorMedio = null;
    }

    public String getApplicationName() {
        return "ConGerTarifaFloatENBean";
    }

    public java.lang.Long getCodigoUnidadeEn() {
        return this.codigoUnidadeEn;
    }

    public void setCodigoUnidadeEn(java.lang.Long codigoUnidadeEn) {
        this.codigoUnidadeEn = codigoUnidadeEn;
    }

    public java.lang.Long getCodigoUnidadePv() {
        return this.codigoUnidadePv;
    }

    public void setCodigoUnidadePv(java.lang.Long codigoUnidadePv) {
        this.codigoUnidadePv = codigoUnidadePv;
    }

    public java.lang.Double getFloatMedio() {
        return this.floatMedio;
    }

    public void setFloatMedio(java.lang.Double floatMedio) {
        this.floatMedio = floatMedio;
    }

    public br.com.politec.sao.util.Percentual getIndiceTarifa() {
        return this.indiceTarifa;
    }

    public void setIndiceTarifa(br.com.politec.sao.util.Percentual indiceTarifa) {
        this.indiceTarifa = indiceTarifa;
    }

    public java.lang.String getNomeUnidadeEn() {
        return this.nomeUnidadeEn;
    }

    public void setNomeUnidadeEn(java.lang.String nomeUnidadeEn) {
        this.nomeUnidadeEn = nomeUnidadeEn;
    }

    public java.lang.Long getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(java.lang.Long quantidade) {
        this.quantidade = quantidade;
    }

    public java.lang.Double getTotalFloatMedio() {
        return this.totalFloatMedio;
    }

    public void setTotalFloatMedio(java.lang.Double totalFloatMedio) {
        this.totalFloatMedio = totalFloatMedio;
    }

    public br.com.politec.sao.util.Money getTotalGeralTarifa() {
        return this.totalGeralTarifa;
    }

    public void setTotalGeralTarifa(br.com.politec.sao.util.Money totalGeralTarifa) {
        this.totalGeralTarifa = totalGeralTarifa;
    }

    public br.com.politec.sao.util.Percentual getTotalIndiceTarifa() {
        return this.totalIndiceTarifa;
    }

    public void setTotalIndiceTarifa(br.com.politec.sao.util.Percentual totalIndiceTarifa) {
        this.totalIndiceTarifa = totalIndiceTarifa;
    }

    public java.lang.Long getTotalQuantidade() {
        return this.totalQuantidade;
    }

    public void setTotalQuantidade(java.lang.Long totalQuantidade) {
        this.totalQuantidade = totalQuantidade;
    }

    public br.com.politec.sao.util.Money getTotalTarifas() {
        return this.totalTarifas;
    }

    public void setTotalTarifas(br.com.politec.sao.util.Money totalTarifas) {
        this.totalTarifas = totalTarifas;
    }

    public br.com.politec.sao.util.Money getTotalValorMedio() {
        return this.totalValorMedio;
    }

    public void setTotalValorMedio(br.com.politec.sao.util.Money totalValorMedio) {
        this.totalValorMedio = totalValorMedio;
    }

    public br.com.politec.sao.util.Money getValorMedio() {
        return this.valorMedio;
    }

    public void setValorMedio(br.com.politec.sao.util.Money valorMedio) {
        this.valorMedio = valorMedio;
    }

    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadePvFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePv);
        return codigoUnidadeFormatado;
    }

    public java.lang.String getCodigoUnidadeEnFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadeEn);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ConGerTarifaFloatENBean other = (ConGerTarifaFloatENBean) obj;
            result = result
                     && equals(getCodigoUnidadeEn(), other.getCodigoUnidadeEn());
            result = result
                     && equals(getCodigoUnidadePv(), other.getCodigoUnidadePv());
            result = result && equals(getFloatMedio(), other.getFloatMedio());
            result = result
                     && equals(getIndiceTarifa(), other.getIndiceTarifa());
            result = result
                     && equals(getNomeUnidadeEn(), other.getNomeUnidadeEn());
            result = result && equals(getQuantidade(), other.getQuantidade());
            result = result
                     && equals(getTotalFloatMedio(), other.getTotalFloatMedio());
            result = result
                     && equals(getTotalGeralTarifa(),
                             other.getTotalGeralTarifa());
            result = result
                     && equals(getTotalIndiceTarifa(),
                             other.getTotalIndiceTarifa());
            result = result
                     && equals(getTotalQuantidade(), other.getTotalQuantidade());
            result = result
                     && equals(getTotalTarifas(), other.getTotalTarifas());
            result = result
                     && equals(getTotalValorMedio(), other.getTotalValorMedio());
            result = result && equals(getValorMedio(), other.getValorMedio());
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
        properties.add(new Property("codigoUnidadeEn",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePv",
                LongType.create(),
                false,
                true));

        // properties.add(new Property("floatMedio", LongType.create(), false,
        // true));
        properties.add(new Property("floatMedio",
                DoubleType.create(),
                false,
                true));

        properties.add(new Property("indiceTarifa",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadeEn",
                StringType.create(),
                false,
                true));
        properties.add(new Property("quantidade",
                LongType.create(),
                false,
                true));

        // properties.add(new Property("totalFloatMedio", LongType.create(),
        // false, true));
        properties.add(new Property("totalFloatMedio",
                DoubleType.create(),
                false,
                true));

        properties.add(new Property("totalGeralTarifa",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalIndiceTarifa",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("totalQuantidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalTarifas",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalValorMedio",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorMedio",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ConGerTarifaFloatENBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("nomeUnidadeEn", new StringValue("X(40)"));
        Mainframe.put("totalQuantidade", new LongValue("9(09)"));
        Mainframe.put("indiceTarifa", new PercentualValue("9(07)"));

        // Mainframe.put("floatMedio", new LongValue("9(07)"));
        Mainframe.put("floatMedio", new DoubleValue("9(05)v99"));

        Mainframe.put("totalTarifas", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("quantidade", new LongValue("9(09)"));
        Mainframe.put("codigoUnidadePv", new LongValue("9(04)"));
        Mainframe.put("valorMedio", new MoneyValue("R$ 9(15)v99"));

        // Mainframe.put("totalFloatMedio", new LongValue("9(07)"));
        Mainframe.put("totalFloatMedio", new DoubleValue("9(05)v99"));

        Mainframe.put("codigoUnidadeEn", new LongValue("9(04)"));
        Mainframe.put("totalIndiceTarifa", new PercentualValue("9(07)"));
        Mainframe.put("totalValorMedio", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalGeralTarifa", new MoneyValue("R$ 9(15)v99"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
