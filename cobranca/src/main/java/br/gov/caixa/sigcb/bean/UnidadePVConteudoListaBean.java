package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class UnidadePVConteudoListaBean extends SigcbBean {
    private java.lang.Long codigoUnidadeEN;

    private java.lang.Long codigoUnidadePV;

    private java.lang.String nomeUnidadeEN;

    private java.lang.String nomeUnidadePV;

    public UnidadePVConteudoListaBean() {
        this.codigoUnidadeEN = null;
        this.codigoUnidadePV = null;
        this.nomeUnidadeEN = null;
        this.nomeUnidadePV = null;
    }

    public String getApplicationName() {
        return "UnidadePVConteudoListaBean";
    }

    public java.lang.Long getCodigoUnidadeEN() {
        return this.codigoUnidadeEN;
    }

    public void setCodigoUnidadeEN(java.lang.Long codigoUnidadeEN) {
        this.codigoUnidadeEN = codigoUnidadeEN;
    }

    public java.lang.Long getCodigoUnidadePV() {
        return this.codigoUnidadePV;
    }

    public void setCodigoUnidadePV(java.lang.Long codigoUnidadePV) {
        this.codigoUnidadePV = codigoUnidadePV;
    }

    public java.lang.String getNomeUnidadeEN() {
        return this.nomeUnidadeEN;
    }

    public void setNomeUnidadeEN(java.lang.String nomeUnidadeEN) {
        this.nomeUnidadeEN = nomeUnidadeEN;
    }

    public java.lang.String getNomeUnidadePV() {
        return this.nomeUnidadePV;
    }

    public void setNomeUnidadePV(java.lang.String nomeUnidadePV) {
        this.nomeUnidadePV = nomeUnidadePV;
    }

    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadeENFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadeEN);
        return codigoUnidadeFormatado;
    }

    public java.lang.String getCodigoUnidadePVFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePV);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            UnidadePVConteudoListaBean other = (UnidadePVConteudoListaBean) obj;
            result = result
                     && equals(getCodigoUnidadeEN(), other.getCodigoUnidadeEN());
            result = result
                     && equals(getCodigoUnidadePV(), other.getCodigoUnidadePV());
            result = result
                     && equals(getNomeUnidadeEN(), other.getNomeUnidadeEN());
            result = result
                     && equals(getNomeUnidadePV(), other.getNomeUnidadePV());
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
        properties.add(new Property("codigoUnidadeEN",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadeEN",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadePV",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "UnidadePVConteudoListaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoUnidadeEN", new LongValue("9(04)"));
        Mainframe.put("codigoUnidadePV", new LongValue("9(04)"));
        Mainframe.put("nomeUnidadeEN", new StringValue("X(40)"));
        Mainframe.put("nomeUnidadePV", new StringValue("X(40)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
