package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.IntegerType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.IntegerValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

public class CedenteRejeitadoSicliBean extends SigcbBean {

    private java.lang.Integer codigoPv;

    private java.lang.Integer numeroCedente;

    private java.lang.Long numeroCocli;

    private java.lang.String nomePv;

    private java.lang.Integer numeroRetornoSicli;

    private java.lang.String descricaoRetornoSicli;

    private java.lang.String nomeCedente;

    private java.lang.Integer dataInclusao;

    public CedenteRejeitadoSicliBean() {
        this.codigoPv = null;
        this.numeroCedente = null;
        this.numeroCocli = null;
        this.nomePv = null;
        this.numeroRetornoSicli = null;
        this.descricaoRetornoSicli = null;
        this.nomeCedente = null;
        this.dataInclusao = null;
    }

    public String getApplicationName() {
        return "CedenteRejeitadoSicliBean";
    }

    public Integer getCodigoPv() {
        return this.codigoPv;
    }

    public void setCodigoPv(Integer codigoPv) {
        this.codigoPv = codigoPv;
    }

    public java.lang.Integer getNumeroCedente() {
        return numeroCedente;
    }

    public void setNumeroCedente(java.lang.Integer numeroCedente) {
        this.numeroCedente = numeroCedente;
    }

    public java.lang.Long getNumeroCocli() {
        return numeroCocli;
    }

    public void setNumeroCocli(java.lang.Long numeroCocli) {
        this.numeroCocli = numeroCocli;
    }

    public java.lang.String getNomePv() {
        return nomePv;
    }

    public void setNomePv(java.lang.String nomePv) {
        this.nomePv = nomePv;
    }

    public java.lang.String getDescricaoRetornoSicli() {
        return descricaoRetornoSicli;
    }

    public void setDescricaoRetornoSicli(java.lang.String descricaoRetornoSicli) {
        this.descricaoRetornoSicli = descricaoRetornoSicli;
    }

    public java.lang.Integer getNumeroRetornoSicli() {
        return numeroRetornoSicli;
    }

    public void setNumeroRetornoSicli(java.lang.Integer numeroRetornoSicli) {
        this.numeroRetornoSicli = numeroRetornoSicli;
    }

    public java.lang.Integer getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(java.lang.Integer dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public java.lang.String getNomeCedente() {
        return nomeCedente;
    }

    public void setNomeCedente(java.lang.String nomeCedente) {
        this.nomeCedente = nomeCedente;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedenteRejeitadoSicliBean other = (CedenteRejeitadoSicliBean) obj;
            result = result && equals(getCodigoPv(), other.getCodigoPv());
            result = result
                     && equals(getNumeroCedente(), other.getNumeroCedente());
            result = result && equals(getNumeroCocli(), other.getNumeroCocli());
            result = result && equals(getNomePv(), other.getNomePv());
            result = result
                     && equals(getNumeroRetornoSicli(),
                             other.getNumeroRetornoSicli());
            result = result
                     && equals(getDescricaoRetornoSicli(),
                             other.getDescricaoRetornoSicli());
            result = result && equals(getNomeCedente(), other.getNomeCedente());
            result = result
                     && equals(getDataInclusao(), other.getDataInclusao());

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
        properties.add(new Property("codigoPv",
                IntegerType.create(),
                false,
                true));
        properties.add(new Property("numeroCedente",
                IntegerType.create(),
                false,
                true));
        properties.add(new Property("numeroCocli",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nomePv", StringType.create(), false, true));
        properties.add(new Property("descricaoRetornoSicli",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroRetornoSicli",
                IntegerType.create(),
                false,
                true));
        properties.add(new Property("nomeCedente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataInclusao",
                IntegerType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedenteRejeitadoSicliBean",
                "br.gov.caixa.sigcb.bean");

        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("numeroCocli", new LongValue("9(13)"));
        Mainframe.put("numeroCedente", new IntegerValue("9(06)"));
        Mainframe.put("codigoPv", new IntegerValue("9(04)"));
        Mainframe.put("nomePv", new StringValue("X(40)"));
        Mainframe.put("numeroRetornoSicli", new IntegerValue("9(03)"));
        Mainframe.put("descricaoRetornoSicli", new StringValue("X(40)"));
        Mainframe.put("nomeCedente", new StringValue("X(40)"));
        Mainframe.put("dataInclusao", new IntegerValue("9(08)"));

        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
