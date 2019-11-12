//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CedBcoSBean extends SigcbBean {
    private java.lang.Long codigoBancoSacado;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidadePV;

    private java.lang.String dataInclusao;

    private java.lang.String nomeBancoSacado;

    private java.lang.String nomeFantasia;

    private java.lang.String nomeUnidadePV;

    private java.lang.String usuario;

    public CedBcoSBean() {
        this.codigoBancoSacado = null;
        this.codigoCedente = null;
        this.codigoUnidadePV = null;
        this.dataInclusao = null;
        this.nomeBancoSacado = null;
        this.nomeFantasia = null;
        this.nomeUnidadePV = null;
        this.usuario = null;
    }

    public String getApplicationName() {
        return "CedBcoSBean";
    }

    public java.lang.Long getCodigoBancoSacado() {
        return this.codigoBancoSacado;
    }

    public void setCodigoBancoSacado(java.lang.Long codigoBancoSacado) {
        this.codigoBancoSacado = codigoBancoSacado;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoUnidadePV() {
        return this.codigoUnidadePV;
    }

    public void setCodigoUnidadePV(java.lang.Long codigoUnidadePV) {
        this.codigoUnidadePV = codigoUnidadePV;
    }

    public java.lang.String getDataInclusao() {
        return this.dataInclusao;
    }

    public void setDataInclusao(java.lang.String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public java.lang.String getNomeBancoSacado() {
        return this.nomeBancoSacado;
    }

    public void setNomeBancoSacado(java.lang.String nomeBancoSacado) {
        this.nomeBancoSacado = nomeBancoSacado;
    }

    public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public java.lang.String getNomeUnidadePV() {
        return this.nomeUnidadePV;
    }

    public void setNomeUnidadePV(java.lang.String nomeUnidadePV) {
        this.nomeUnidadePV = nomeUnidadePV;
    }

    public java.lang.String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    public java.lang.String getFormataData(String value) {
        if ((value != null) && (value.trim().length() == 10)) {
            return value.substring(0, 2)
                   + "/"
                   + value.substring(3, 5)
                   + "/"
                   + value.substring(6, 10);

        } else {
            return value;
        }
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadePVFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePV);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedBcoSBean other = (CedBcoSBean) obj;
            result = result
                     && equals(getCodigoBancoSacado(),
                             other.getCodigoBancoSacado());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidadePV(), other.getCodigoUnidadePV());
            result = result
                     && equals(getDataInclusao(), other.getDataInclusao());
            result = result
                     && equals(getNomeBancoSacado(), other.getNomeBancoSacado());
            result = result
                     && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result
                     && equals(getNomeUnidadePV(), other.getNomeUnidadePV());
            result = result && equals(getUsuario(), other.getUsuario());
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
        properties.add(new Property("codigoBancoSacado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dataInclusao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeBancoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeFantasia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadePV",
                StringType.create(),
                false,
                true));
        properties.add(new Property("usuario", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "CedBcoSBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("nomeBancoSacado", new StringValue("X(20)"));
        Mainframe.put("codigoUnidadePV", new LongValue("9(04)"));
        Mainframe.put("codigoBancoSacado", new LongValue("9(03)"));
        Mainframe.put("nomeFantasia", new StringValue("X(40)"));
        Mainframe.put("usuario", new StringValue("X(08)"));
        Mainframe.put("nomeUnidadePV", new StringValue("X(40)"));
        Mainframe.put("dataInclusao", new StringValue("X(10)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
