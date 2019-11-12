package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

public class CedenteDesfazerAleracaoGuiasBean extends SigcbBean {

    private java.lang.String nsuTransacao;

    private java.lang.String codigoUsuario;

    private java.lang.Long numeroPendencia;

    private java.lang.String opcao;

    public CedenteDesfazerAleracaoGuiasBean() {
        this.nsuTransacao = null;
        this.codigoUsuario = null;
        this.numeroPendencia = null;
        this.opcao = null;
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

    public java.lang.Long getNumeroPendencia() {
        return this.numeroPendencia;
    }

    public void setNumeroPendencia(java.lang.Long numeroPendencia) {
        this.numeroPendencia = numeroPendencia;
    }

    public java.lang.String getOpcao() {
        return this.opcao;
    }

    public void setOpcao(java.lang.String opcao) {
        this.opcao = opcao;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedenteDesfazerAleracaoGuiasBean other = (CedenteDesfazerAleracaoGuiasBean) obj;
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result
                     && equals(getNumeroPendencia(), other.getNumeroPendencia());
            result = result && equals(getOpcao(), other.getOpcao());
            return result;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = 0;
        return result;
    }

    @Override
    public String getApplicationName() {
        return "CedenteDesfazerAleracaoGuiasBean";
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
        properties.add(new Property("numeroPendencia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("opcao", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "CedenteConclusaoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("codigoUsuario", new StringValue("X(07)"));
        Mainframe.put("numeroPendencia", new LongValue("9(07)"));
        Mainframe.put("opcao", new StringValue("X(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    @Override
    public Layout getLayout() {
        return layout;
    }
}