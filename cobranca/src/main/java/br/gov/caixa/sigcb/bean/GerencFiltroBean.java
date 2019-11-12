//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
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

public class GerencFiltroBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidade;

    private java.lang.String codigoUsuario;

    private java.lang.Long consolidado;

    private java.lang.Long cpfCnpj;

    private java.util.Date data;

    private java.lang.String mesAno;

    private java.lang.Long navegacao;

    private java.lang.String nomeCedente;

    private java.lang.String nomeUnidade;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoData;

    private java.lang.Long tipoPessoa;

    private java.lang.Long tipoRelatorio;

    private java.lang.Long tipoTitulo;

    private java.lang.Long tpConsulta;

    private java.lang.Long tpFiltro;

    private java.lang.Long tpPeriodo;

    public GerencFiltroBean() {
        this.codigoCedente = null;
        this.codigoUnidade = null;
        this.codigoUsuario = null;
        this.consolidado = null;
        this.cpfCnpj = null;
        this.data = null;
        this.mesAno = null;
        this.navegacao = null;
        this.nomeCedente = null;
        this.nomeUnidade = null;
        this.tipoConsulta = null;
        this.tipoData = null;
        this.tipoPessoa = null;
        this.tipoRelatorio = null;
        this.tipoTitulo = null;
        this.tpConsulta = null;
        this.tpFiltro = null;
        this.tpPeriodo = null;
    }

    public String getApplicationName() {
        return "GerencFiltroBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoUnidade() {
        return this.codigoUnidade;
    }

    public void setCodigoUnidade(java.lang.Long codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.Long getConsolidado() {
        return this.consolidado;
    }

    public void setConsolidado(java.lang.Long consolidado) {
        this.consolidado = consolidado;
    }

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.util.Date getData() {
        return this.data;
    }

    public void setData(java.util.Date data) {
        this.data = data;
    }

    public java.lang.String getMesAno() {
        return this.mesAno;
    }

    public void setMesAno(java.lang.String mesAno) {
        this.mesAno = mesAno;
    }

    public java.lang.Long getNavegacao() {
        return this.navegacao;
    }

    public void setNavegacao(java.lang.Long navegacao) {
        this.navegacao = navegacao;
    }

    public java.lang.String getNomeCedente() {
        return this.nomeCedente;
    }

    public void setNomeCedente(java.lang.String nomeCedente) {
        this.nomeCedente = nomeCedente;
    }

    public java.lang.String getNomeUnidade() {
        return this.nomeUnidade;
    }

    public void setNomeUnidade(java.lang.String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public java.lang.Long getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.Long tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public java.lang.Long getTipoData() {
        return this.tipoData;
    }

    public void setTipoData(java.lang.Long tipoData) {
        this.tipoData = tipoData;
    }

    public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public java.lang.Long getTipoRelatorio() {
        return this.tipoRelatorio;
    }

    public void setTipoRelatorio(java.lang.Long tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }

    public java.lang.Long getTipoTitulo() {
        return this.tipoTitulo;
    }

    public void setTipoTitulo(java.lang.Long tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }

    public java.lang.Long getTpConsulta() {
        return this.tpConsulta;
    }

    public void setTpConsulta(java.lang.Long tpConsulta) {
        this.tpConsulta = tpConsulta;
    }

    public java.lang.Long getTpFiltro() {
        return this.tpFiltro;
    }

    public void setTpFiltro(java.lang.Long tpFiltro) {
        this.tpFiltro = tpFiltro;
    }

    public java.lang.Long getTpPeriodo() {
        return this.tpPeriodo;
    }

    public void setTpPeriodo(java.lang.Long tpPeriodo) {
        this.tpPeriodo = tpPeriodo;
    }

    /* ////////////////////////////////////////////////////// */
    public String getDataFormatada() {
        String strRetorno = "";
        if (this.tipoData != null) {
            if (this.tipoData.equals(new Long(2))) {
                if (this.data != null) {
                    strRetorno = Formatador.formatarData(this.data);
                }
            } else if (this.tipoData.equals(new Long(1))) {
                if (this.mesAno != null) {
                    strRetorno = mesAno.replace('.', '/');
                }
            }
        }
        return strRetorno;
    }

    public String getTipoDataTexto() {
        String strRetorno = "";
        if (this.tipoData != null) {
            if (this.tipoData.equals(new Long(2))) {
                strRetorno = "DATA";
            } else if (this.tipoData.equals(new Long(1))) {
                strRetorno = "MES/ANO";
            }
        }
        return strRetorno;
    }

    public String getTipoConsultaTexto() {
        String strRetorno = "";

        if (this.navegacao != null) {
            switch (this.navegacao.intValue()) {
            case 1:
                strRetorno = "CEDENTE";
                break;
            case 2:
                strRetorno = "UNIDADE PV";
                break;
            case 3:
                strRetorno = "UNIDADE SR";/*
                                             * AL 18/12/06 - Alteração de EN p/
                                             * SR - Capuano
                                             */
                break;
            case 4:
                strRetorno = "CAIXA";
                break;
            default:
                break;
            }
        }
        return strRetorno;
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

    public java.lang.String getCpfCnpjFormatado() {
        String cpfCnpjTexto = "";
        if (this.tipoPessoa != null && this.cpfCnpj != null) {
            if (this.getTipoPessoa().equals(new Long(1))) {
                cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                        .toString(), 11);
            } else if (this.getTipoPessoa().equals(new Long(2))) {
                cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                        .toString(), 14);
            }
            cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        }
        return cpfCnpjTexto;
    }

    public java.lang.String getTpFiltroTexto() {
        String strRetorno = "";
        String[] strConsulta = null;

        strConsulta = new String[] {
                                    "BLOQUETOS LASER PADRAO CAIXA", // 0
                                    "BLOQUETOS PRE-IMPRESSOS", // 1
                                    "CARNES LASER PADRAO CAIXA", // 2
                                    "BLOQUETOS PERSONALIZADOS", // 3
                                    "CEDENTES PADROES CNAB 240 E 400", // 4
                                    "CEDENTES POR MEIO ENTRADA", // 5
                                    "CEDENTES POR SITUACAO TESTE / PRODUCAO E MOVIMENTO", // 6
                                    "MOVIMENTO POR TIPO DE VAN", // 7
                                    "POSICAO POR PV / SR RECEBEDOR",// DLMT
                                                                    // 22/03/2007
                                                                    // -
                                                                    // Alteração
                                                                    // de EN
                                                                    // para SR
                                                                    // // 8
                                    "POSICAO POR PV / SR VINCULACAO",// DLMT
                                                                        // 22/03/2007
                                                                        // -
                                                                        // Alteração
                                                                        // de EN
                                                                        // para
                                                                        // SR //
                                                                        // 9
                                    "MOVIMENTACAO DE TITULOS", // 10
                                    "MOVIMENTACAO DE TITULOS / TARIFAS / FLOAT", // 11
                                    "POSICAO DE TITULOS EM CARTEIRA POR SERVICO", // 12
                                    "TITULOS INCLUIDOS", // 13
                                    "TITULOS INCLUIDOS / LIQUIDADOS POR TIPO DE COBRANCA", // 14
                                    "TITULOS LIQUIDADOS COM FLOAT = 0", // 15
                                    "TITULOS LIQUIDADOS POR SERVICOS / MEIO DE LIQUIDACAO", // 16
                                    "TITULOS LIQUIDADOS COM RETENÇÃO IOF", // 17
                                    "EMISSAO E POSTAGEM DE BLOQUETOS / EXTRATOS", // 18
                                    "LIQUIDACAO POR SERVICOS / MEIO LIQUIDACAO", // 19
                                    "PROTESTO DE TITULOS", // 20
                                    "SERVICOS DIVERSOS", // 21
                                    "TOTAL DE TARIFAS", // 22
                                    "TITULOS INCLUIDOS - DETALHE" // 23
        };

        if (this.tpFiltro != null) {
            int numConsulta = this.tpFiltro.intValue();
            strRetorno = strConsulta[numConsulta];
        }
        return strRetorno;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadeFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidade);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    /* ////////////////////////////////////////////////////// */

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            GerencFiltroBean other = (GerencFiltroBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidade(), other.getCodigoUnidade());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getConsolidado(), other.getConsolidado());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getData(), other.getData());
            result = result && equals(getMesAno(), other.getMesAno());
            result = result && equals(getNavegacao(), other.getNavegacao());
            result = result && equals(getNomeCedente(), other.getNomeCedente());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoData(), other.getTipoData());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result
                     && equals(getTipoRelatorio(), other.getTipoRelatorio());
            result = result && equals(getTipoTitulo(), other.getTipoTitulo());
            result = result && equals(getTpConsulta(), other.getTpConsulta());
            result = result && equals(getTpFiltro(), other.getTpFiltro());
            result = result && equals(getTpPeriodo(), other.getTpPeriodo());
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
        properties.add(new Property("codigoUnidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("consolidado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("data", DateType.create(), false, true));
        properties.add(new Property("mesAno", StringType.create(), false, true));
        properties.add(new Property("navegacao", LongType.create(), false, true));
        properties.add(new Property("nomeCedente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidade",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoData", LongType.create(), false, true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoRelatorio",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoTitulo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tpConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tpFiltro", LongType.create(), false, true));
        properties.add(new Property("tpPeriodo", LongType.create(), false, true));
        Layout result = new Layout(properties,
                "GerencFiltroBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("codigoUnidade", new LongValue("9(04)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("consolidado", new LongValue("9(01)"));
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("tpConsulta", new LongValue("9(02)"));
        Mainframe.put("nomeCedente", new StringValue("X(40)"));
        Mainframe.put("data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("tipoTitulo", new LongValue("9(01)"));
        Mainframe.put("tpPeriodo", new LongValue("9(01)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("mesAno", new StringValue("X(07)"));
        Mainframe.put("tipoData", new LongValue("9(01)"));
        Mainframe.put("tpFiltro", new LongValue("9(01)"));
        Mainframe.put("navegacao", new LongValue("9(01)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("tipoRelatorio", new LongValue("9(02)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
