package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

public class PerfilInternetBean extends SigcbBean {
    private java.lang.Long codigoPerfil;

    private java.lang.String codigoUsuario;

    private java.lang.String descricaoPerfil;

    private java.lang.Long meioEntrada;

    private java.lang.String servicoPerfil;

    private java.lang.String tipoAcao;

    public PerfilInternetBean() {
        this.codigoPerfil = null;
        this.codigoUsuario = null;
        this.descricaoPerfil = null;
        this.meioEntrada = null;
        this.servicoPerfil = null;
        this.tipoAcao = null;
    }

    public String getApplicationName() {
        return "PerfilInternetBean";
    }

    public java.lang.Long getCodigoPerfil() {
        return this.codigoPerfil;
    }

    public void setCodigoPerfil(java.lang.Long codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.String getDescricaoPerfil() {
        return this.descricaoPerfil;
    }

    public void setDescricaoPerfil(java.lang.String descricaoPerfil) {
        this.descricaoPerfil = descricaoPerfil;
    }

    public java.lang.Long getMeioEntrada() {
        return this.meioEntrada;
    }

    public void setMeioEntrada(java.lang.Long meioEntrada) {
        this.meioEntrada = meioEntrada;
    }

    public java.lang.String getServicoPerfil() {
        return this.servicoPerfil;
    }

    public void setServicoPerfil(java.lang.String servicoPerfil) {
        this.servicoPerfil = servicoPerfil;
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
            PerfilInternetBean other = (PerfilInternetBean) obj;
            result = result
                     && equals(getCodigoPerfil(), other.getCodigoPerfil());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getDescricaoPerfil(), other.getDescricaoPerfil());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result
                     && equals(getServicoPerfil(), other.getServicoPerfil());
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
        properties.add(new Property("codigoPerfil",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricaoPerfil",
                StringType.create(),
                false,
                true));
        properties.add(new Property("meioEntrada",
                LongType.create(),
                false,
                true));
        properties.add(new Property("servicoPerfil",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "PerfilInternetBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("servicoPerfil", new StringValue("X(01)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("meioEntrada", new LongValue("9(02)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("codigoPerfil", new LongValue("9(03)"));
        Mainframe.put("descricaoPerfil", new StringValue("X(80)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
