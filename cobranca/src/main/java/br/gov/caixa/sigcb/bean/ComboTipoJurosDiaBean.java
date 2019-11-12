package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

public class ComboTipoJurosDiaBean extends SigcbBean {
    private java.lang.Long codigo;

    private java.lang.String descricao;

    public ComboTipoJurosDiaBean() {
        this.codigo = null;
        this.descricao = null;
    }

    public String getApplicationName() {
        return "ComboTipoJurosDiaBean";
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

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ComboTipoJurosDiaBean other = (ComboTipoJurosDiaBean) obj;
            result = result && equals(getCodigo(), other.getCodigo());
            result = result && equals(getDescricao(), other.getDescricao());
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
        Layout result = new Layout(properties,
                "ComboTipoJurosDiaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("codigo", new LongValue("9(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
