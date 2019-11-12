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

public class CedenteConteudoListaBean extends SigcbBean {

    private java.lang.String COCLI;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidadePV;

    private java.lang.String codigoUsuario;

    private java.lang.Long cpfCnpj;

    private java.lang.String excepPendente;

    private java.lang.String nomeFantasia;

    private java.lang.String nomeUnidadePV;

    private java.lang.String nsuTransacao;

    private java.lang.String situacao;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoPessoa;

    public CedenteConteudoListaBean() {
        this.COCLI = null;
        this.codigoCedente = null;
        this.codigoUnidadePV = null;
        this.codigoUsuario = null;
        this.cpfCnpj = null;
        this.excepPendente = null;
        this.nomeFantasia = null;
        this.nomeUnidadePV = null;
        this.nsuTransacao = null;
        this.situacao = null;
        this.tipoConsulta = null;
        this.tipoPessoa = null;
    }

    public String getApplicationName() {
        return "CedenteConteudoListaBean";
    }

    public java.lang.String getCOCLI() {
        return this.COCLI;
    }

    public void setCOCLI(java.lang.String COCLI) {
        this.COCLI = COCLI;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoUnidadePV() {
        return this.codigoUnidadePV;
    }

    public void setCodigoUnidadePV(java.lang.Long codigoUnidadePV) {
        this.codigoUnidadePV = codigoUnidadePV;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public java.lang.String getCpfCnpjFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoa().equals(new Long(1))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                    .toString(), 11);
        } else if (this.getTipoPessoa().equals(new Long(2))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                    .toString(), 14);
        }
        cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        return cpfCnpjTexto;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.lang.String getExcepPendente() {
        return this.excepPendente;
    }

    public void setExcepPendente(java.lang.String excepPendente) {
        this.excepPendente = excepPendente;
    }

    public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public java.lang.String getNomeUnidadePV() {
        return this.nomeUnidadePV;
    }

    public void setNomeUnidadePV(java.lang.String nomeUnidadePV) {
        this.nomeUnidadePV = nomeUnidadePV;
    }

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public java.lang.String getSituacao() {
        return this.situacao;
    }

    public java.lang.String getSituacaoTexto() {
        if (this.situacao.equals("I")) {
            return "INATIVO";
        } else if (this.situacao.equals("A")) {
            return "ATIVO";
        }
        return "";
    }

    public void setSituacao(java.lang.String situacao) {
        this.situacao = situacao;
    }

    public java.lang.Long getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.Long tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public String getTipoPessoaTexto() {
        String strTipoPessoa = "";
        if (this.tipoPessoa != null) {
            if (this.tipoPessoa.intValue() == 1) {
                strTipoPessoa = "FISICA";
            } else {
                strTipoPessoa = "JURIDICA";
            }
        }
        return strTipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadePVFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePV);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedenteConteudoListaBean other = (CedenteConteudoListaBean) obj;
            result = result && equals(getCOCLI(), other.getCOCLI());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidadePV(), other.getCodigoUnidadePV());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result
                     && equals(getExcepPendente(), other.getExcepPendente());
            result = result
                     && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result
                     && equals(getNomeUnidadePV(), other.getNomeUnidadePV());
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
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
        properties.add(new Property("COCLI", StringType.create(), false, true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("excepPendente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeFantasia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadePV",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("situacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedenteConteudoListaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("codigoUnidadePV", new LongValue("9(04)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("excepPendente", new StringValue("X(01)"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("nomeFantasia", new StringValue("X(40)"));
        Mainframe.put("situacao", new StringValue("X(01)"));
        Mainframe.put("COCLI", new StringValue("X(13)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("nomeUnidadePV", new StringValue("X(40)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }

}
