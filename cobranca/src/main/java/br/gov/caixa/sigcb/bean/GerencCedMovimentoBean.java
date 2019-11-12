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
import br.gov.caixa.sigcb.util.Formatador;

public class GerencCedMovimentoBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidade;

    private java.util.Date data;

    private java.lang.String descricao;

    private java.lang.String mesAno;

    private java.lang.String nomeUnidade;

    private java.lang.Long qtdRemessa;

    private java.lang.Long qtdRemessaRetorno;

    private java.lang.Long qtdRetorno;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoData;

    private java.lang.Long totalRemessa;

    private java.lang.Long totalRemessaRetorno;

    private java.lang.Long totalRetorno;

    public GerencCedMovimentoBean() {
        this.codigoCedente = null;
        this.codigoUnidade = null;
        this.data = null;
        this.descricao = null;
        this.mesAno = null;
        this.nomeUnidade = null;
        this.qtdRemessa = null;
        this.qtdRemessaRetorno = null;
        this.qtdRetorno = null;
        this.tipoConsulta = null;
        this.tipoData = null;
        this.totalRemessa = null;
        this.totalRemessaRetorno = null;
        this.totalRetorno = null;
    }

    public String getApplicationName() {
        return "GerencCedMovimentoBean";
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

    public java.util.Date getData() {
        return this.data;
    }

    public void setData(java.util.Date data) {
        this.data = data;
    }

    public java.lang.String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
    }

    public java.lang.String getMesAno() {
        return this.mesAno;
    }

    public void setMesAno(java.lang.String mesAno) {
        this.mesAno = mesAno;
    }

    public java.lang.String getNomeUnidade() {
        return this.nomeUnidade;
    }

    public void setNomeUnidade(java.lang.String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public java.lang.Long getQtdRemessa() {
        return this.qtdRemessa;
    }

    public void setQtdRemessa(java.lang.Long qtdRemessa) {
        this.qtdRemessa = qtdRemessa;
    }

    public java.lang.Long getQtdRemessaRetorno() {
        return this.qtdRemessaRetorno;
    }

    public void setQtdRemessaRetorno(java.lang.Long qtdRemessaRetorno) {
        this.qtdRemessaRetorno = qtdRemessaRetorno;
    }

    public java.lang.Long getQtdRetorno() {
        return this.qtdRetorno;
    }

    public void setQtdRetorno(java.lang.Long qtdRetorno) {
        this.qtdRetorno = qtdRetorno;
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

    public java.lang.Long getTotalRemessa() {
        return this.totalRemessa;
    }

    public void setTotalRemessa(java.lang.Long totalRemessa) {
        this.totalRemessa = totalRemessa;
    }

    public java.lang.Long getTotalRemessaRetorno() {
        return this.totalRemessaRetorno;
    }

    public void setTotalRemessaRetorno(java.lang.Long totalRemessaRetorno) {
        this.totalRemessaRetorno = totalRemessaRetorno;
    }

    public java.lang.Long getTotalRetorno() {
        return this.totalRetorno;
    }

    public void setTotalRetorno(java.lang.Long totalRetorno) {
        this.totalRetorno = totalRetorno;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            GerencCedMovimentoBean other = (GerencCedMovimentoBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidade(), other.getCodigoUnidade());
            result = result && equals(getData(), other.getData());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result && equals(getMesAno(), other.getMesAno());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result && equals(getQtdRemessa(), other.getQtdRemessa());
            result = result
                     && equals(getQtdRemessaRetorno(),
                             other.getQtdRemessaRetorno());
            result = result && equals(getQtdRetorno(), other.getQtdRetorno());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoData(), other.getTipoData());
            result = result
                     && equals(getTotalRemessa(), other.getTotalRemessa());
            result = result
                     && equals(getTotalRemessaRetorno(),
                             other.getTotalRemessaRetorno());
            result = result
                     && equals(getTotalRetorno(), other.getTotalRetorno());
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
        properties.add(new Property("data", DateType.create(), false, true));
        properties.add(new Property("descricao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("mesAno", StringType.create(), false, true));
        properties.add(new Property("nomeUnidade",
                StringType.create(),
                false,
                true));
        properties.add(new Property("qtdRemessa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdRemessaRetorno",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdRetorno",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoData", LongType.create(), false, true));
        properties.add(new Property("totalRemessa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalRemessaRetorno",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalRetorno",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "GerencCedMovimentoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("qtdRemessa", new LongValue("9(08)"));
        Mainframe.put("codigoUnidade", new LongValue("9(04)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("totalRemessa", new LongValue("9(08)"));
        Mainframe.put("totalRemessaRetorno", new LongValue("9(08)"));
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("mesAno", new StringValue("X(07)"));
        Mainframe.put("tipoData", new LongValue("9(01)"));
        Mainframe.put("qtdRetorno", new LongValue("9(08)"));
        Mainframe.put("qtdRemessaRetorno", new LongValue("9(08)"));
        Mainframe.put("totalRetorno", new LongValue("9(08)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
