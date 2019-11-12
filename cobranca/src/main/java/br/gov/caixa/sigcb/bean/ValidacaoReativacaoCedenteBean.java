package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

public class ValidacaoReativacaoCedenteBean extends SigcbBean {
    private java.lang.String nsuTransacao;

    private java.lang.String codigoUsuario;

    private java.lang.String descricao;

    private java.lang.Long cpfCnpjCedente;

    public ValidacaoReativacaoCedenteBean() {
        this.nsuTransacao = null;
        this.codigoUsuario = null;
        this.descricao = null;
        this.cpfCnpjCedente = null;
    }

    public String getApplicationName() {
        return "ValidacaoReativacaoCedenteBean";
    }

    public java.lang.String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.Long getCpfCnpjCedente() {
        return cpfCnpjCedente;
    }

    public void setCpfCnpjCedente(java.lang.Long cpfCnpjCedente) {
        this.cpfCnpjCedente = cpfCnpjCedente;
    }

    public java.lang.String getDescricao() {
        return descricao;
    }

    public void setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
    }

    public java.lang.String getNsuTransacao() {
        return nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ValidacaoReativacaoCedenteBean other = (ValidacaoReativacaoCedenteBean) obj;
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result
                     && equals(getCpfCnpjCedente(), other.getCpfCnpjCedente());
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
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpjCedente",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ValidacaoReativacaoCedenteBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("descricao", new StringValue("X(200)"));
        Mainframe.put("cpfCnpjCedente", new LongValue("9(14)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
