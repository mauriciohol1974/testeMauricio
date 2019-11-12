package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

public class LogCedenteGuiasBean extends SigcbBean {

    private java.lang.Long opcao;

    private java.lang.String nsuTransacao;

    private java.lang.String codigoUsuario;

    private java.lang.Long codigoCedente;

    private java.lang.String apelido;

    public LogCedenteGuiasBean() {
        this.opcao = null;
        this.nsuTransacao = null;
        this.codigoCedente = null;
        this.codigoUsuario = null;
        this.apelido = null;
    }

    @Override
    public String getApplicationName() {
        return "LogCedenteGuiasBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public java.lang.Long getOpcao() {
        return this.opcao;
    }

    public void setOpcao(java.lang.Long opcao) {
        this.opcao = opcao;
    }

    public java.lang.String getApelido() {
        return this.apelido;
    }

    public void setApelido(java.lang.String apelido) {
        this.apelido = apelido;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            LogCedenteGuiasBean other = (LogCedenteGuiasBean) obj;
            result = result && equals(this.getOpcao(), other.getOpcao());
            result = result
                     && equals(this.getCodigoCedente(),
                             other.getCodigoCedente());
            result = result
                     && equals(this.getCodigoUsuario(),
                             other.getCodigoUsuario());
            result = result
                     && equals(this.getNsuTransacao(), other.getNsuTransacao());
            result = result && equals(this.getApelido(), other.getApelido());
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
        properties.add(new Property("opcao", LongType.create(), false, true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("apelido", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "LogCedenteGuiasBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("opcao", new LongValue("9(01)"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("codigoUsuario", new StringValue("X(07)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("apelido", new StringValue("X(06)"));
        result.addExtension(Mainframe);
        return result;
    }

    @Override
    public Layout getLayout() {
        return layout;
    }
}
