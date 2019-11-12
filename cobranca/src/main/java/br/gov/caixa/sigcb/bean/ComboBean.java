package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

public class ComboBean extends SigcbBean {
    private java.lang.Long codigo;

    private java.lang.Long codigoLong;

    private java.lang.String codigoString;

    private java.lang.Long codigoTam3;

    private java.lang.Long codigoTam4;

    private java.lang.Long codigoTipo;

    private java.lang.String descricao;

    private java.lang.String minemonico;
    
    private String descrReduzida;

    public ComboBean() {
        this.codigo = null;
        this.codigoLong = null;
        this.codigoString = null;
        this.codigoTam3 = null;
        this.codigoTam4 = null;
        this.codigoTipo = null;
        this.descricao = null;
        this.minemonico = null;
        this.descrReduzida=null;
    }

    public String getDescrReduzida() {
		return descrReduzida;
	}

	public void setDescrReduzida(String descrReduzida) {
		this.descrReduzida = descrReduzida;
	}

	public String getApplicationName() {
        return "ComboBean";
    }

    public java.lang.Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(java.lang.Long codigo) {
        this.codigo = codigo;
    }

    public java.lang.Long getCodigoLong() {
        return this.codigoLong;
    }

    public void setCodigoLong(java.lang.Long codigoLong) {
        this.codigoLong = codigoLong;
    }

    public java.lang.String getCodigoString() {
        return this.codigoString;
    }

    public void setCodigoString(java.lang.String codigoString) {
        this.codigoString = codigoString;
    }

    public java.lang.Long getCodigoTam3() {
        return this.codigoTam3;
    }

    public void setCodigoTam3(java.lang.Long codigoTam3) {
        this.codigoTam3 = codigoTam3;
    }

    public java.lang.Long getCodigoTam4() {
        return this.codigoTam4;
    }

    public void setCodigoTam4(java.lang.Long codigoTam4) {
        this.codigoTam4 = codigoTam4;
    }

    public java.lang.Long getCodigoTipo() {
        return this.codigoTipo;
    }

    public void setCodigoTipo(java.lang.Long codigoTipo) {
        this.codigoTipo = codigoTipo;
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
            ComboBean other = (ComboBean) obj;
            result = result && equals(getCodigo(), other.getCodigo());
            result = result && equals(getCodigoLong(), other.getCodigoLong());
            result = result
                     && equals(getCodigoString(), other.getCodigoString());
            result = result && equals(getCodigoTam3(), other.getCodigoTam3());
            result = result && equals(getCodigoTam4(), other.getCodigoTam4());
            result = result && equals(getCodigoTipo(), other.getCodigoTipo());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result && equals(getMinemonico(), other.getMinemonico());
            result = result && equals(getDescrReduzida(), other.getDescrReduzida());
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
        properties.add(new Property("codigoLong",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoString",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoTam3",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoTam4",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoTipo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("descricao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("minemonico",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descrReduzida",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ComboBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("descrReduzida", new StringValue("X(15)"));
        Mainframe.put("codigoTam3", new LongValue("9(03)"));
        Mainframe.put("codigoTam4", new LongValue("9(04)"));
        Mainframe.put("minemonico", new StringValue("X(03)"));
        Mainframe.put("codigoTipo", new LongValue("9(02)"));
        Mainframe.put("codigoString", new StringValue("X(01)"));
        Mainframe.put("codigoLong", new LongValue("9(01)"));
        Mainframe.put("codigo", new LongValue("9(02)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
