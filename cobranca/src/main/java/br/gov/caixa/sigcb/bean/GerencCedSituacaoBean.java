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

public class GerencCedSituacaoBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidade;

    private java.util.Date data;

    private java.lang.String descricao;

    private java.lang.String mesAno;

    private java.lang.String nomeUnidade;

    private java.lang.Long qtdComMovto;

    private java.lang.Long qtdSemMovto;

    private java.lang.Long qtdTotal;

    private java.lang.Long tipoAssunto;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoData;

    private java.lang.Long totalComMovto;

    private java.lang.Long totalGeral;

    private java.lang.Long totalSemMovto;

    public GerencCedSituacaoBean() {
        this.codigoCedente = null;
        this.codigoUnidade = null;
        this.data = null;
        this.descricao = null;
        this.mesAno = null;
        this.nomeUnidade = null;
        this.qtdComMovto = null;
        this.qtdSemMovto = null;
        this.qtdTotal = null;
        this.tipoAssunto = null;
        this.tipoConsulta = null;
        this.tipoData = null;
        this.totalComMovto = null;
        this.totalGeral = null;
        this.totalSemMovto = null;
    }

    public String getApplicationName() {
        return "GerencCedSituacaoBean";
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

    public java.lang.Long getQtdComMovto() {
        return this.qtdComMovto;
    }

    public void setQtdComMovto(java.lang.Long qtdComMovto) {
        this.qtdComMovto = qtdComMovto;
    }

    public java.lang.Long getQtdSemMovto() {
        return this.qtdSemMovto;
    }

    public void setQtdSemMovto(java.lang.Long qtdSemMovto) {
        this.qtdSemMovto = qtdSemMovto;
    }

    public java.lang.Long getQtdTotal() {
        return this.qtdTotal;
    }

    public void setQtdTotal(java.lang.Long qtdTotal) {
        this.qtdTotal = qtdTotal;
    }

    public java.lang.Long getTipoAssunto() {
        return this.tipoAssunto;
    }

    public void setTipoAssunto(java.lang.Long tipoAssunto) {
        this.tipoAssunto = tipoAssunto;
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

    public java.lang.Long getTotalComMovto() {
        return this.totalComMovto;
    }

    public void setTotalComMovto(java.lang.Long totalComMovto) {
        this.totalComMovto = totalComMovto;
    }

    public java.lang.Long getTotalGeral() {
        return this.totalGeral;
    }

    public void setTotalGeral(java.lang.Long totalGeral) {
        this.totalGeral = totalGeral;
    }

    public java.lang.Long getTotalSemMovto() {
        return this.totalSemMovto;
    }

    public void setTotalSemMovto(java.lang.Long totalSemMovto) {
        this.totalSemMovto = totalSemMovto;
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
            GerencCedSituacaoBean other = (GerencCedSituacaoBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidade(), other.getCodigoUnidade());
            result = result && equals(getData(), other.getData());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result && equals(getMesAno(), other.getMesAno());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result && equals(getQtdComMovto(), other.getQtdComMovto());
            result = result && equals(getQtdSemMovto(), other.getQtdSemMovto());
            result = result && equals(getQtdTotal(), other.getQtdTotal());
            result = result && equals(getTipoAssunto(), other.getTipoAssunto());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoData(), other.getTipoData());
            result = result
                     && equals(getTotalComMovto(), other.getTotalComMovto());
            result = result && equals(getTotalGeral(), other.getTotalGeral());
            result = result
                     && equals(getTotalSemMovto(), other.getTotalSemMovto());
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
        properties.add(new Property("qtdComMovto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdSemMovto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdTotal", LongType.create(), false, true));
        properties.add(new Property("tipoAssunto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoData", LongType.create(), false, true));
        properties.add(new Property("totalComMovto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalGeral",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalSemMovto",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "GerencCedSituacaoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("tipoAssunto", new LongValue("9(01)"));
        Mainframe.put("codigoUnidade", new LongValue("9(04)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("totalComMovto", new LongValue("9(08)"));
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("totalGeral", new LongValue("9(08)"));
        Mainframe.put("data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("qtdSemMovto", new LongValue("9(08)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("mesAno", new StringValue("X(07)"));
        Mainframe.put("tipoData", new LongValue("9(01)"));
        Mainframe.put("qtdComMovto", new LongValue("9(08)"));
        Mainframe.put("qtdTotal", new LongValue("9(08)"));
        Mainframe.put("totalSemMovto", new LongValue("9(08)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
