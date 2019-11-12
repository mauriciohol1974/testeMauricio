//Bean alterado manualmente, cuidado ao gerar....
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.DateType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.DateValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.util.Formatador;

public class GiroCaixaBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidadeEN;

    private java.lang.Long codigoUnidadePV;

    private java.lang.Long cpfCnpj;

    private java.util.Date dataAlteracao;

    private java.util.Date dataExclusao;

    private java.util.Date dataInclusao;

    private java.lang.String giroCaixaEstrutural;

    private java.lang.String matriculaConcessorUsuario;

    private java.lang.Long navegacao;

    private java.lang.String nomeAtividade;

    private java.lang.String nomeFantasia;

    private java.lang.String nomeUnidadeEN;

    private java.lang.String nomeUnidadePV;

    private java.lang.Long selecaoEnPV;

    private java.lang.Long selecaoRadio;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoPessoa;

    private java.lang.String usuario;

    public GiroCaixaBean() {
        this.codigoCedente = null;
        this.codigoUnidadeEN = null;
        this.codigoUnidadePV = null;
        this.cpfCnpj = null;
        this.dataAlteracao = null;
        this.dataExclusao = null;
        this.dataInclusao = null;
        this.giroCaixaEstrutural = null;
        this.matriculaConcessorUsuario = null;
        this.navegacao = null;
        this.nomeAtividade = null;
        this.nomeFantasia = null;
        this.nomeUnidadeEN = null;
        this.nomeUnidadePV = null;
        this.selecaoEnPV = null;
        this.selecaoRadio = null;
        this.tipoConsulta = null;
        this.tipoPessoa = null;
        this.usuario = null;
    }

    public String getApplicationName() {
        return "GiroCaixaBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoUnidadeEN() {
        return this.codigoUnidadeEN;
    }

    public void setCodigoUnidadeEN(java.lang.Long codigoUnidadeEN) {
        this.codigoUnidadeEN = codigoUnidadeEN;
    }

    public java.lang.Long getCodigoUnidadePV() {
        return this.codigoUnidadePV;
    }

    public void setCodigoUnidadePV(java.lang.Long codigoUnidadePV) {
        this.codigoUnidadePV = codigoUnidadePV;
    }

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.util.Date getDataAlteracao() {
        return this.dataAlteracao;
    }

    public void setDataAlteracao(java.util.Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public java.util.Date getDataExclusao() {
        return this.dataExclusao;
    }

    public void setDataExclusao(java.util.Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public java.util.Date getDataInclusao() {
        return this.dataInclusao;
    }

    public void setDataInclusao(java.util.Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public java.lang.String getGiroCaixaEstrutural() {
        return this.giroCaixaEstrutural;
    }

    public void setGiroCaixaEstrutural(java.lang.String giroCaixaEstrutural) {
        this.giroCaixaEstrutural = giroCaixaEstrutural;
    }

    public java.lang.String getMatriculaConcessorUsuario() {
        return this.matriculaConcessorUsuario;
    }

    public void setMatriculaConcessorUsuario(java.lang.String matriculaConcessorUsuario) {
        this.matriculaConcessorUsuario = matriculaConcessorUsuario;
    }

    public java.lang.Long getNavegacao() {
        return this.navegacao;
    }

    public void setNavegacao(java.lang.Long navegacao) {
        this.navegacao = navegacao;
    }

    public java.lang.String getNomeAtividade() {
        return this.nomeAtividade;
    }

    public void setNomeAtividade(java.lang.String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public java.lang.String getNomeUnidadeEN() {
        return this.nomeUnidadeEN;
    }

    public void setNomeUnidadeEN(java.lang.String nomeUnidadeEN) {
        this.nomeUnidadeEN = nomeUnidadeEN;
    }

    public java.lang.String getNomeUnidadePV() {
        return this.nomeUnidadePV;
    }

    public void setNomeUnidadePV(java.lang.String nomeUnidadePV) {
        this.nomeUnidadePV = nomeUnidadePV;
    }

    public java.lang.Long getSelecaoEnPV() {
        return this.selecaoEnPV;
    }

    public void setSelecaoEnPV(java.lang.Long selecaoEnPV) {
        this.selecaoEnPV = selecaoEnPV;
    }

    public java.lang.Long getSelecaoRadio() {
        return this.selecaoRadio;
    }

    public void setSelecaoRadio(java.lang.Long selecaoRadio) {
        this.selecaoRadio = selecaoRadio;
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

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public java.lang.String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    // Inicio das alterações
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

    public java.lang.String getTipoPessoaTexto() {
        String tipoPessoaTexto = "";

        if (this.getTipoPessoa() != null) {
            if (this.getTipoPessoa().equals(new Long(1))) {
                tipoPessoaTexto = "FISICA";
            } else if (this.getTipoPessoa().equals(new Long(2))) {
                tipoPessoaTexto = "JURIDICA";
            } else {
                tipoPessoaTexto = "";
            }
        }

        return tipoPessoaTexto;
    }

    public java.lang.String getDataAlteracaoFormatada() {
        if (this.dataAlteracao != null) {
            return Formatador.formatarData(this.dataAlteracao);
        } else {
            return "";
        }
    }

    public java.lang.String getDataExclusaoFormatada() {
        if (this.dataExclusao != null) {
            return Formatador.formatarData(this.dataExclusao);
        } else {
            return "";
        }
    }

    public java.lang.String getDataInclusaoFormatada() {
        if (this.dataInclusao != null) {
            return Formatador.formatarData(this.dataInclusao);
        } else {
            return "";
        }
    }

    // Método para obter o valor preenchido no filtro
    public java.lang.Long getEnPv() {
        Long codigoUnidade = new Long(0);
        if (this.selecaoEnPV != null) {
            if (this.selecaoEnPV.equals(new Long(1))) {// En
                codigoUnidade = this.codigoUnidadeEN;
            } else if (this.selecaoEnPV.equals(new Long(2))) {// Pv
                codigoUnidade = this.codigoUnidadePV;
            }
        }
        return codigoUnidade;
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

    public java.lang.String getCodigoUnidadeENFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadeEN);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    // Termino das alterações

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            GiroCaixaBean other = (GiroCaixaBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidadeEN(), other.getCodigoUnidadeEN());
            result = result
                     && equals(getCodigoUnidadePV(), other.getCodigoUnidadePV());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result
                     && equals(getDataAlteracao(), other.getDataAlteracao());
            result = result
                     && equals(getDataExclusao(), other.getDataExclusao());
            result = result
                     && equals(getDataInclusao(), other.getDataInclusao());
            result = result
                     && equals(getGiroCaixaEstrutural(),
                             other.getGiroCaixaEstrutural());
            result = result
                     && equals(getMatriculaConcessorUsuario(),
                             other.getMatriculaConcessorUsuario());
            result = result && equals(getNavegacao(), other.getNavegacao());
            result = result
                     && equals(getNomeAtividade(), other.getNomeAtividade());
            result = result
                     && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result
                     && equals(getNomeUnidadeEN(), other.getNomeUnidadeEN());
            result = result
                     && equals(getNomeUnidadePV(), other.getNomeUnidadePV());
            result = result && equals(getSelecaoEnPV(), other.getSelecaoEnPV());
            result = result
                     && equals(getSelecaoRadio(), other.getSelecaoRadio());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
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
        properties.add(new Property("codigoUnidadeEN",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("dataAlteracao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataExclusao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataInclusao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("giroCaixaEstrutural",
                StringType.create(),
                false,
                true));
        properties.add(new Property("matriculaConcessorUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("navegacao", LongType.create(), false, true));
        properties.add(new Property("nomeAtividade",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeFantasia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadeEN",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadePV",
                StringType.create(),
                false,
                true));
        properties.add(new Property("selecaoEnPV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("selecaoRadio",
                LongType.create(),
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
        properties.add(new Property("usuario", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "GiroCaixaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("nomeUnidadeEN", new StringValue("X(40)"));
        Mainframe.put("dataAlteracao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("giroCaixaEstrutural", new StringValue("X(01)"));
        Mainframe.put("dataExclusao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("selecaoEnPV", new LongValue("9(01)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("codigoUnidadePV", new LongValue("9(04)"));
        Mainframe.put("nomeFantasia", new StringValue("X(40)"));
        Mainframe.put("dataInclusao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("selecaoRadio", new LongValue("9(01)"));
        Mainframe.put("nomeAtividade", new StringValue("X(40)"));
        Mainframe.put("navegacao", new LongValue("9(01)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("nomeUnidadePV", new StringValue("X(40)"));
        Mainframe.put("usuario", new StringValue("X(08)"));
        Mainframe.put("codigoUnidadeEN", new LongValue("9(04)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("matriculaConcessorUsuario", new StringValue("X(08)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
