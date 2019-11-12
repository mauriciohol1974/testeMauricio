package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

public class ComboEspecieTituloBean extends SigcbBean {
    private java.lang.Long codigo;

    private java.lang.String descricao;

    private java.lang.String minemonico;

    public ComboEspecieTituloBean() {
        this.codigo = null;
        this.descricao = null;
        this.minemonico = null;
    }

    public String getApplicationName() {
        return "ComboEspecieTituloBean";
    }

    public java.lang.Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(java.lang.Long codigo) {
        this.codigo = codigo;
    }

    public java.lang.String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
    }

    public java.lang.String getMinemonico() {
        return this.minemonico;
    }

    public void setMinemonico(java.lang.String minemonico) {
        this.minemonico = minemonico;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ComboEspecieTituloBean other = (ComboEspecieTituloBean) obj;
            result = result && equals(getCodigo(), other.getCodigo());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result && equals(getMinemonico(), other.getMinemonico());
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
        properties.add(new Property("codigo", LongType.create(), false, true));
        properties.add(new Property("descricao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("minemonico",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ComboEspecieTituloBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("minemonico", new StringValue("X(03)"));
        Mainframe.put("codigo", new LongValue("9(02)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
