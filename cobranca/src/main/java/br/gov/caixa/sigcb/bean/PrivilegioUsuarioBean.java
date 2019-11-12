package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

public class PrivilegioUsuarioBean extends SigcbBean {
    private java.lang.Long codUnidPVVinculacao;

    private java.lang.String codigoUsuario;

    private java.lang.String grupoFuncional;

    private java.lang.Long indicaGestor;

    public PrivilegioUsuarioBean() {
        this.codUnidPVVinculacao = null;
        this.codigoUsuario = null;
        this.grupoFuncional = null;
        this.indicaGestor = null;
    }

    public String getApplicationName() {
        return "PrivilegioUsuarioBean";
    }

    public java.lang.Long getCodUnidPVVinculacao() {
        return this.codUnidPVVinculacao;
    }

    public void setCodUnidPVVinculacao(java.lang.Long codUnidPVVinculacao) {
        this.codUnidPVVinculacao = codUnidPVVinculacao;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.String getGrupoFuncional() {
        return this.grupoFuncional;
    }

    public void setGrupoFuncional(java.lang.String grupoFuncional) {
        this.grupoFuncional = grupoFuncional;
    }

    public java.lang.Long getIndicaGestor() {
        return this.indicaGestor;
    }

    public void setIndicaGestor(java.lang.Long indicaGestor) {
        this.indicaGestor = indicaGestor;
    }

    public boolean ehGestor() {
        if ("GCBADM".equals(this.getGrupoFuncional())
            || "GSTAP".equals(this.getGrupoFuncional())) {
            return true;
        }
        return false;
    }

    public boolean ehEmpregadoPV() {
        if ("EMPPV".equals(this.getGrupoFuncional())
            || "GERPV".equals(this.getGrupoFuncional())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            PrivilegioUsuarioBean other = (PrivilegioUsuarioBean) obj;
            result = result
                     && equals(getCodUnidPVVinculacao(),
                             other.getCodUnidPVVinculacao());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getGrupoFuncional(), other.getGrupoFuncional());
            result = result
                     && equals(getIndicaGestor(), other.getIndicaGestor());
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
        properties.add(new Property("codUnidPVVinculacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("grupoFuncional",
                StringType.create(),
                false,
                true));
        properties.add(new Property("indicaGestor",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "PrivilegioUsuarioBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("indicaGestor", new LongValue("9(01)"));
        Mainframe.put("grupoFuncional", new StringValue("X(05)"));
        Mainframe.put("codUnidPVVinculacao", new LongValue("9(04)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
