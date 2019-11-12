package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

public class AgrupamentoBean extends SigcbBean {
    private java.lang.String codigoAgrupamento;

    private java.lang.String codigoUsuario;

    private java.lang.String descricaoAgrupamento;

    private java.lang.Long registro;

    private java.lang.String tipoAcao;

    public AgrupamentoBean() {
        this.codigoAgrupamento = null;
        this.codigoUsuario = null;
        this.descricaoAgrupamento = null;
        this.registro = null;
        this.tipoAcao = null;
    }

    public String getApplicationName() {
        return "AgrupamentoBean";
    }

    public java.lang.String getCodigoAgrupamento() {
        return this.codigoAgrupamento;
    }

    public void setCodigoAgrupamento(java.lang.String codigoAgrupamento) {
        this.codigoAgrupamento = codigoAgrupamento;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.String getDescricaoAgrupamento() {
        return this.descricaoAgrupamento;
    }

    public void setDescricaoAgrupamento(java.lang.String descricaoAgrupamento) {
        this.descricaoAgrupamento = descricaoAgrupamento;
    }

    public java.lang.Long getRegistro() {
        return this.registro;
    }

    public void setRegistro(java.lang.Long registro) {
        this.registro = registro;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            AgrupamentoBean other = (AgrupamentoBean) obj;
            result = result
                     && equals(getCodigoAgrupamento(),
                             other.getCodigoAgrupamento());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getDescricaoAgrupamento(),
                             other.getDescricaoAgrupamento());
            result = result && equals(getRegistro(), other.getRegistro());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
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
        properties.add(new Property("codigoAgrupamento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricaoAgrupamento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("registro", LongType.create(), false, true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "AgrupamentoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("registro", new LongValue("9(04)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("descricaoAgrupamento", new StringValue("X(40)"));
        Mainframe.put("codigoAgrupamento", new StringValue("X(03)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
