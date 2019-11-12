package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.gov.caixa.sigcb.util.Formatador;

public class SaldoCobrancaBean extends SigcbBean {
    private java.lang.Long baixasQtd;

    private java.lang.Long baixasQtdReg;

    private br.com.politec.sao.util.Money baixasVlr;

    private br.com.politec.sao.util.Money baixasVlrReg;

    private java.lang.Long codigoCedente;

    private java.lang.Long entradasQtd;

    private java.lang.Long entradasQtdReg;

    private br.com.politec.sao.util.Money entradasVlr;

    private br.com.politec.sao.util.Money entradasVlrReg;

    private java.lang.Long liquidacoesQtd;

    private java.lang.Long liquidacoesQtdReg;

    private br.com.politec.sao.util.Money liquidacoesVlr;

    private br.com.politec.sao.util.Money liquidacoesVlrReg;

    private java.lang.Long saldoAnteriorQtd;

    private java.lang.Long saldoAnteriorQtdReg;

    private br.com.politec.sao.util.Money saldoAnteriorVlr;

    private br.com.politec.sao.util.Money saldoAnteriorVlrReg;

    private java.lang.Long saldoAtualQtd;

    private java.lang.Long saldoAtualQtdReg;

    private br.com.politec.sao.util.Money saldoAtualVlr;

    private br.com.politec.sao.util.Money saldoAtualVlrReg;

    private java.lang.Long vencidosQtd;

    private java.lang.Long vencidosQtdReg;

    private br.com.politec.sao.util.Money vencidosVlr;

    private br.com.politec.sao.util.Money vencidosVlrReg;

    public SaldoCobrancaBean() {
        this.baixasQtd = null;
        this.baixasQtdReg = null;
        this.baixasVlr = null;
        this.baixasVlrReg = null;
        this.codigoCedente = null;
        this.entradasQtd = null;
        this.entradasQtdReg = null;
        this.entradasVlr = null;
        this.entradasVlrReg = null;
        this.liquidacoesQtd = null;
        this.liquidacoesQtdReg = null;
        this.liquidacoesVlr = null;
        this.liquidacoesVlrReg = null;
        this.saldoAnteriorQtd = null;
        this.saldoAnteriorQtdReg = null;
        this.saldoAnteriorVlr = null;
        this.saldoAnteriorVlrReg = null;
        this.saldoAtualQtd = null;
        this.saldoAtualQtdReg = null;
        this.saldoAtualVlr = null;
        this.saldoAtualVlrReg = null;
        this.vencidosQtd = null;
        this.vencidosQtdReg = null;
        this.vencidosVlr = null;
        this.vencidosVlrReg = null;
    }

    public String getApplicationName() {
        return "SaldoCobrancaBean";
    }

    public java.lang.Long getBaixasQtd() {
        return this.baixasQtd;
    }

    public void setBaixasQtd(java.lang.Long baixasQtd) {
        this.baixasQtd = baixasQtd;
    }

    public java.lang.Long getBaixasQtdReg() {
        return this.baixasQtdReg;
    }

    public void setBaixasQtdReg(java.lang.Long baixasQtdReg) {
        this.baixasQtdReg = baixasQtdReg;
    }

    public br.com.politec.sao.util.Money getBaixasVlr() {
        return this.baixasVlr;
    }

    public void setBaixasVlr(br.com.politec.sao.util.Money baixasVlr) {
        this.baixasVlr = baixasVlr;
    }

    public br.com.politec.sao.util.Money getBaixasVlrReg() {
        return this.baixasVlrReg;
    }

    public void setBaixasVlrReg(br.com.politec.sao.util.Money baixasVlrReg) {
        this.baixasVlrReg = baixasVlrReg;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getEntradasQtd() {
        return this.entradasQtd;
    }

    public void setEntradasQtd(java.lang.Long entradasQtd) {
        this.entradasQtd = entradasQtd;
    }

    public java.lang.Long getEntradasQtdReg() {
        return this.entradasQtdReg;
    }

    public void setEntradasQtdReg(java.lang.Long entradasQtdReg) {
        this.entradasQtdReg = entradasQtdReg;
    }

    public br.com.politec.sao.util.Money getEntradasVlr() {
        return this.entradasVlr;
    }

    public void setEntradasVlr(br.com.politec.sao.util.Money entradasVlr) {
        this.entradasVlr = entradasVlr;
    }

    public br.com.politec.sao.util.Money getEntradasVlrReg() {
        return this.entradasVlrReg;
    }

    public void setEntradasVlrReg(br.com.politec.sao.util.Money entradasVlrReg) {
        this.entradasVlrReg = entradasVlrReg;
    }

    public java.lang.Long getLiquidacoesQtd() {
        return this.liquidacoesQtd;
    }

    public void setLiquidacoesQtd(java.lang.Long liquidacoesQtd) {
        this.liquidacoesQtd = liquidacoesQtd;
    }

    public java.lang.Long getLiquidacoesQtdReg() {
        return this.liquidacoesQtdReg;
    }

    public void setLiquidacoesQtdReg(java.lang.Long liquidacoesQtdReg) {
        this.liquidacoesQtdReg = liquidacoesQtdReg;
    }

    public br.com.politec.sao.util.Money getLiquidacoesVlr() {
        return this.liquidacoesVlr;
    }

    public void setLiquidacoesVlr(br.com.politec.sao.util.Money liquidacoesVlr) {
        this.liquidacoesVlr = liquidacoesVlr;
    }

    public br.com.politec.sao.util.Money getLiquidacoesVlrReg() {
        return this.liquidacoesVlrReg;
    }

    public void setLiquidacoesVlrReg(br.com.politec.sao.util.Money liquidacoesVlrReg) {
        this.liquidacoesVlrReg = liquidacoesVlrReg;
    }

    public java.lang.Long getSaldoAnteriorQtd() {
        return this.saldoAnteriorQtd;
    }

    public void setSaldoAnteriorQtd(java.lang.Long saldoAnteriorQtd) {
        this.saldoAnteriorQtd = saldoAnteriorQtd;
    }

    public java.lang.Long getSaldoAnteriorQtdReg() {
        return this.saldoAnteriorQtdReg;
    }

    public void setSaldoAnteriorQtdReg(java.lang.Long saldoAnteriorQtdReg) {
        this.saldoAnteriorQtdReg = saldoAnteriorQtdReg;
    }

    public br.com.politec.sao.util.Money getSaldoAnteriorVlr() {
        return this.saldoAnteriorVlr;
    }

    public void setSaldoAnteriorVlr(br.com.politec.sao.util.Money saldoAnteriorVlr) {
        this.saldoAnteriorVlr = saldoAnteriorVlr;
    }

    public br.com.politec.sao.util.Money getSaldoAnteriorVlrReg() {
        return this.saldoAnteriorVlrReg;
    }

    public void setSaldoAnteriorVlrReg(br.com.politec.sao.util.Money saldoAnteriorVlrReg) {
        this.saldoAnteriorVlrReg = saldoAnteriorVlrReg;
    }

    public java.lang.Long getSaldoAtualQtd() {
        return this.saldoAtualQtd;
    }

    public void setSaldoAtualQtd(java.lang.Long saldoAtualQtd) {
        this.saldoAtualQtd = saldoAtualQtd;
    }

    public java.lang.Long getSaldoAtualQtdReg() {
        return this.saldoAtualQtdReg;
    }

    public void setSaldoAtualQtdReg(java.lang.Long saldoAtualQtdReg) {
        this.saldoAtualQtdReg = saldoAtualQtdReg;
    }

    public br.com.politec.sao.util.Money getSaldoAtualVlr() {
        return this.saldoAtualVlr;
    }

    public void setSaldoAtualVlr(br.com.politec.sao.util.Money saldoAtualVlr) {
        this.saldoAtualVlr = saldoAtualVlr;
    }

    public br.com.politec.sao.util.Money getSaldoAtualVlrReg() {
        return this.saldoAtualVlrReg;
    }

    public void setSaldoAtualVlrReg(br.com.politec.sao.util.Money saldoAtualVlrReg) {
        this.saldoAtualVlrReg = saldoAtualVlrReg;
    }

    public java.lang.Long getVencidosQtd() {
        return this.vencidosQtd;
    }

    public void setVencidosQtd(java.lang.Long vencidosQtd) {
        this.vencidosQtd = vencidosQtd;
    }

    public java.lang.Long getVencidosQtdReg() {
        return this.vencidosQtdReg;
    }

    public void setVencidosQtdReg(java.lang.Long vencidosQtdReg) {
        this.vencidosQtdReg = vencidosQtdReg;
    }

    public br.com.politec.sao.util.Money getVencidosVlr() {
        return this.vencidosVlr;
    }

    public void setVencidosVlr(br.com.politec.sao.util.Money vencidosVlr) {
        this.vencidosVlr = vencidosVlr;
    }

    public br.com.politec.sao.util.Money getVencidosVlrReg() {
        return this.vencidosVlrReg;
    }

    public void setVencidosVlrReg(br.com.politec.sao.util.Money vencidosVlrReg) {
        this.vencidosVlrReg = vencidosVlrReg;
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
            SaldoCobrancaBean other = (SaldoCobrancaBean) obj;
            result = result && equals(getBaixasQtd(), other.getBaixasQtd());
            result = result
                     && equals(getBaixasQtdReg(), other.getBaixasQtdReg());
            result = result && equals(getBaixasVlr(), other.getBaixasVlr());
            result = result
                     && equals(getBaixasVlrReg(), other.getBaixasVlrReg());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getEntradasQtd(), other.getEntradasQtd());
            result = result
                     && equals(getEntradasQtdReg(), other.getEntradasQtdReg());
            result = result && equals(getEntradasVlr(), other.getEntradasVlr());
            result = result
                     && equals(getEntradasVlrReg(), other.getEntradasVlrReg());
            result = result
                     && equals(getLiquidacoesQtd(), other.getLiquidacoesQtd());
            result = result
                     && equals(getLiquidacoesQtdReg(),
                             other.getLiquidacoesQtdReg());
            result = result
                     && equals(getLiquidacoesVlr(), other.getLiquidacoesVlr());
            result = result
                     && equals(getLiquidacoesVlrReg(),
                             other.getLiquidacoesVlrReg());
            result = result
                     && equals(getSaldoAnteriorQtd(),
                             other.getSaldoAnteriorQtd());
            result = result
                     && equals(getSaldoAnteriorQtdReg(),
                             other.getSaldoAnteriorQtdReg());
            result = result
                     && equals(getSaldoAnteriorVlr(),
                             other.getSaldoAnteriorVlr());
            result = result
                     && equals(getSaldoAnteriorVlrReg(),
                             other.getSaldoAnteriorVlrReg());
            result = result
                     && equals(getSaldoAtualQtd(), other.getSaldoAtualQtd());
            result = result
                     && equals(getSaldoAtualQtdReg(),
                             other.getSaldoAtualQtdReg());
            result = result
                     && equals(getSaldoAtualVlr(), other.getSaldoAtualVlr());
            result = result
                     && equals(getSaldoAtualVlrReg(),
                             other.getSaldoAtualVlrReg());
            result = result && equals(getVencidosQtd(), other.getVencidosQtd());
            result = result
                     && equals(getVencidosQtdReg(), other.getVencidosQtdReg());
            result = result && equals(getVencidosVlr(), other.getVencidosVlr());
            result = result
                     && equals(getVencidosVlrReg(), other.getVencidosVlrReg());
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
        properties.add(new Property("baixasQtd", LongType.create(), false, true));
        properties.add(new Property("baixasQtdReg",
                LongType.create(),
                false,
                true));
        properties.add(new Property("baixasVlr",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("baixasVlrReg",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("entradasQtd",
                LongType.create(),
                false,
                true));
        properties.add(new Property("entradasQtdReg",
                LongType.create(),
                false,
                true));
        properties.add(new Property("entradasVlr",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("entradasVlrReg",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("liquidacoesQtd",
                LongType.create(),
                false,
                true));
        properties.add(new Property("liquidacoesQtdReg",
                LongType.create(),
                false,
                true));
        properties.add(new Property("liquidacoesVlr",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("liquidacoesVlrReg",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("saldoAnteriorQtd",
                LongType.create(),
                false,
                true));
        properties.add(new Property("saldoAnteriorQtdReg",
                LongType.create(),
                false,
                true));
        properties.add(new Property("saldoAnteriorVlr",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("saldoAnteriorVlrReg",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("saldoAtualQtd",
                LongType.create(),
                false,
                true));
        properties.add(new Property("saldoAtualQtdReg",
                LongType.create(),
                false,
                true));
        properties.add(new Property("saldoAtualVlr",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("saldoAtualVlrReg",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("vencidosQtd",
                LongType.create(),
                false,
                true));
        properties.add(new Property("vencidosQtdReg",
                LongType.create(),
                false,
                true));
        properties.add(new Property("vencidosVlr",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("vencidosVlrReg",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "SaldoCobrancaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("saldoAnteriorQtdReg", new LongValue("9(09)"));
        Mainframe.put("saldoAtualQtd", new LongValue("9(09)"));
        Mainframe.put("liquidacoesVlrReg", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("saldoAnteriorQtd", new LongValue("9(09)"));
        Mainframe.put("baixasQtd", new LongValue("9(09)"));
        Mainframe.put("vencidosVlr", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("vencidosVlrReg", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("entradasVlrReg", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("liquidacoesQtdReg", new LongValue("9(09)"));
        Mainframe.put("baixasVlrReg", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("vencidosQtd", new LongValue("9(09)"));
        Mainframe.put("vencidosQtdReg", new LongValue("9(09)"));
        Mainframe.put("entradasQtdReg", new LongValue("9(09)"));
        Mainframe.put("saldoAtualVlrReg", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("entradasVlr", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("baixasQtdReg", new LongValue("9(09)"));
        Mainframe.put("liquidacoesVlr", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("saldoAtualQtdReg", new LongValue("9(09)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("entradasQtd", new LongValue("9(09)"));
        Mainframe.put("saldoAtualVlr", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("saldoAnteriorVlr", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("saldoAnteriorVlrReg", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("liquidacoesQtd", new LongValue("9(09)"));
        Mainframe.put("baixasVlr", new MoneyValue("R$ 9(13)v99"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
