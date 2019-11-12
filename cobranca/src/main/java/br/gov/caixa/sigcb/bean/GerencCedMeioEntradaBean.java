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

public class GerencCedMeioEntradaBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidade;

    private java.util.Date data;

    private java.lang.String descricao;

    private java.lang.String mesAno;

    private java.lang.String nomeUnidade;

    private java.lang.Long qtdRegComMovto;

    private java.lang.Long qtdRegSemMovto;

    private java.lang.Long qtdSRegComMovto;

    private java.lang.Long qtdSRegSemMovto;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoData;

    private java.lang.Long totalQtdRegComMovto;

    private java.lang.Long totalQtdRegSemMovto;

    private java.lang.Long totalQtdSRegComMovto;

    private java.lang.Long totalQtdSRegSemMovto;

    public GerencCedMeioEntradaBean() {
        this.codigoCedente = null;
        this.codigoUnidade = null;
        this.data = null;
        this.descricao = null;
        this.mesAno = null;
        this.nomeUnidade = null;
        this.qtdRegComMovto = null;
        this.qtdRegSemMovto = null;
        this.qtdSRegComMovto = null;
        this.qtdSRegSemMovto = null;
        this.tipoConsulta = null;
        this.tipoData = null;
        this.totalQtdRegComMovto = null;
        this.totalQtdRegSemMovto = null;
        this.totalQtdSRegComMovto = null;
        this.totalQtdSRegSemMovto = null;
    }

    public String getApplicationName() {
        return "GerencCedMeioEntradaBean";
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

    public java.lang.Long getQtdRegComMovto() {
        return this.qtdRegComMovto;
    }

    public void setQtdRegComMovto(java.lang.Long qtdRegComMovto) {
        this.qtdRegComMovto = qtdRegComMovto;
    }

    public java.lang.Long getQtdRegSemMovto() {
        return this.qtdRegSemMovto;
    }

    public void setQtdRegSemMovto(java.lang.Long qtdRegSemMovto) {
        this.qtdRegSemMovto = qtdRegSemMovto;
    }

    public java.lang.Long getQtdSRegComMovto() {
        return this.qtdSRegComMovto;
    }

    public void setQtdSRegComMovto(java.lang.Long qtdSRegComMovto) {
        this.qtdSRegComMovto = qtdSRegComMovto;
    }

    public java.lang.Long getQtdSRegSemMovto() {
        return this.qtdSRegSemMovto;
    }

    public void setQtdSRegSemMovto(java.lang.Long qtdSRegSemMovto) {
        this.qtdSRegSemMovto = qtdSRegSemMovto;
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

    public java.lang.Long getTotalQtdRegComMovto() {
        return this.totalQtdRegComMovto;
    }

    public void setTotalQtdRegComMovto(java.lang.Long totalQtdRegComMovto) {
        this.totalQtdRegComMovto = totalQtdRegComMovto;
    }

    public java.lang.Long getTotalQtdRegSemMovto() {
        return this.totalQtdRegSemMovto;
    }

    public void setTotalQtdRegSemMovto(java.lang.Long totalQtdRegSemMovto) {
        this.totalQtdRegSemMovto = totalQtdRegSemMovto;
    }

    public java.lang.Long getTotalQtdSRegComMovto() {
        return this.totalQtdSRegComMovto;
    }

    public void setTotalQtdSRegComMovto(java.lang.Long totalQtdSRegComMovto) {
        this.totalQtdSRegComMovto = totalQtdSRegComMovto;
    }

    public java.lang.Long getTotalQtdSRegSemMovto() {
        return this.totalQtdSRegSemMovto;
    }

    public void setTotalQtdSRegSemMovto(java.lang.Long totalQtdSRegSemMovto) {
        this.totalQtdSRegSemMovto = totalQtdSRegSemMovto;
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
            GerencCedMeioEntradaBean other = (GerencCedMeioEntradaBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidade(), other.getCodigoUnidade());
            result = result && equals(getData(), other.getData());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result && equals(getMesAno(), other.getMesAno());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result
                     && equals(getQtdRegComMovto(), other.getQtdRegComMovto());
            result = result
                     && equals(getQtdRegSemMovto(), other.getQtdRegSemMovto());
            result = result
                     && equals(getQtdSRegComMovto(), other.getQtdSRegComMovto());
            result = result
                     && equals(getQtdSRegSemMovto(), other.getQtdSRegSemMovto());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoData(), other.getTipoData());
            result = result
                     && equals(getTotalQtdRegComMovto(),
                             other.getTotalQtdRegComMovto());
            result = result
                     && equals(getTotalQtdRegSemMovto(),
                             other.getTotalQtdRegSemMovto());
            result = result
                     && equals(getTotalQtdSRegComMovto(),
                             other.getTotalQtdSRegComMovto());
            result = result
                     && equals(getTotalQtdSRegSemMovto(),
                             other.getTotalQtdSRegSemMovto());
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
        properties.add(new Property("qtdRegComMovto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdRegSemMovto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdSRegComMovto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdSRegSemMovto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoData", LongType.create(), false, true));
        properties.add(new Property("totalQtdRegComMovto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalQtdRegSemMovto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalQtdSRegComMovto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalQtdSRegSemMovto",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "GerencCedMeioEntradaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("qtdRegSemMovto", new LongValue("9(08)"));
        Mainframe.put("totalQtdSRegComMovto", new LongValue("9(08)"));
        Mainframe.put("codigoUnidade", new LongValue("9(04)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("qtdRegComMovto", new LongValue("9(08)"));
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("qtdSRegSemMovto", new LongValue("9(08)"));
        Mainframe.put("totalQtdRegSemMovto", new LongValue("9(08)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("mesAno", new StringValue("X(07)"));
        Mainframe.put("tipoData", new LongValue("9(01)"));
        Mainframe.put("qtdSRegComMovto", new LongValue("9(08)"));
        Mainframe.put("totalQtdSRegSemMovto", new LongValue("9(08)"));
        Mainframe.put("totalQtdRegComMovto", new LongValue("9(08)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
