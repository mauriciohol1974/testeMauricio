package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CepBean extends SigcbBean {
    private java.lang.String bairro;

    private java.lang.Long cep;

    private java.lang.String endereco;

    private java.lang.String municipio;

    private java.lang.String uf;

    public CepBean() {
        this.bairro = null;
        this.cep = null;
        this.endereco = null;
        this.municipio = null;
        this.uf = null;
    }

    public String getApplicationName() {
        return "CepBean";
    }

    public java.lang.String getBairro() {
        return this.bairro;
    }

    public void setBairro(java.lang.String bairro) {
        this.bairro = bairro;
    }

    public java.lang.Long getCep() {
        return this.cep;
    }

    public java.lang.String getCepFormatado() {
        return Formatador.formatarCep(this.getCep().toString());
    }

    public void setCep(java.lang.Long cep) {
        this.cep = cep;
    }

    public java.lang.String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(java.lang.String endereco) {
        this.endereco = endereco;
    }

    public java.lang.String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(java.lang.String municipio) {
        this.municipio = municipio;
    }

    public java.lang.String getUf() {
        return this.uf;
    }

    public void setUf(java.lang.String uf) {
        this.uf = uf;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CepBean other = (CepBean) obj;
            result = result && equals(getBairro(), other.getBairro());
            result = result && equals(getCep(), other.getCep());
            result = result && equals(getEndereco(), other.getEndereco());
            result = result && equals(getMunicipio(), other.getMunicipio());
            result = result && equals(getUf(), other.getUf());
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
        properties.add(new Property("bairro", StringType.create(), false, true));
        properties.add(new Property("cep", LongType.create(), false, true));
        properties.add(new Property("endereco",
                StringType.create(),
                false,
                true));
        properties.add(new Property("municipio",
                StringType.create(),
                false,
                true));
        properties.add(new Property("uf", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "CepBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("cep", new LongValue("9(08)"));
        Mainframe.put("bairro", new StringValue("X(25)"));
        Mainframe.put("municipio", new StringValue("X(35)"));
        Mainframe.put("uf", new StringValue("X(2)"));
        Mainframe.put("endereco", new StringValue("X(40)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
