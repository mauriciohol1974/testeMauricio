//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.util.Formatador;

public class CedCentBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoCedenteCentral;

    private java.lang.Long cpfCnpjPessoa;

    private java.lang.String nomeFantasia;

    private java.lang.Long tipoPessoa;

    private java.lang.String usuario;

    public CedCentBean() {
        this.codigoCedente = null;
        this.codigoCedenteCentral = null;
        this.cpfCnpjPessoa = null;
        this.nomeFantasia = null;
        this.tipoPessoa = null;
        this.usuario = null;
    }

    public String getApplicationName() {
        return "ConGerCedCenBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoCedenteCentral() {
        return this.codigoCedenteCentral;
    }

    public void setCodigoCedenteCentral(java.lang.Long codigoCedenteCentral) {
        this.codigoCedenteCentral = codigoCedenteCentral;
    }

    public java.lang.Long getCpfCnpjPessoa() {
        return this.cpfCnpjPessoa;
    }

    public void setCpfCnpjPessoa(java.lang.Long cpfCnpjPessoa) {
        this.cpfCnpjPessoa = cpfCnpjPessoa;
    }

    public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public java.lang.String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    /*
     * Estes metodos não foi colocado pela framework, foi manual.
     */
    public java.lang.String getTipoPessoaTexto() {
        String tipoPessoaTexto = "";

        if (this.getTipoPessoa().equals(new Long(1))) {
            tipoPessoaTexto = "FISICA";
        } else if (this.getTipoPessoa().equals(new Long(2))) {
            tipoPessoaTexto = "JURIDICA";
        } else {
            tipoPessoaTexto = "";
        }
        return tipoPessoaTexto;
    }

    public java.lang.String getCpfCnpjFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoa().equals(new Long(1))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjPessoa()
                    .toString(), 11);
        } else if (this.getTipoPessoa().equals(new Long(2))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjPessoa()
                    .toString(), 14);
        }
        cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        return cpfCnpjTexto;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    public java.lang.String getCodigoCedenteCentralFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedenteCentral);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedCentBean other = (CedCentBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoCedenteCentral(),
                             other.getCodigoCedenteCentral());
            result = result
                     && equals(getCpfCnpjPessoa(), other.getCpfCnpjPessoa());
            result = result
                     && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result && equals(getUsuario(), other.getUsuario());
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
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedenteCentral",
                LongType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpjPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nomeFantasia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("usuario", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "ConGerCedCenBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("nomeFantasia", new StringValue("X(40)"));
        Mainframe.put("usuario", new StringValue("X(08)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("cpfCnpjPessoa", new LongValue("9(14)"));
        Mainframe.put("codigoCedenteCentral", new LongValue("9(07)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
