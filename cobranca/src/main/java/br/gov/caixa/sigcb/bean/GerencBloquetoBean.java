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

public class GerencBloquetoBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidade;

    private java.util.Date data;

    private java.lang.String descricao;

    private java.lang.String mesAno;

    private java.lang.String nomeUnidade;

    private java.lang.Long qtdRegistrada;

    private java.lang.Long qtdSemRegistro;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoData;

    private java.lang.Long totalRegistrada;

    private java.lang.Long totalSemRegistro;

    public GerencBloquetoBean() {
        this.codigoCedente = null;
        this.codigoUnidade = null;
        this.data = null;
        this.descricao = null;
        this.mesAno = null;
        this.nomeUnidade = null;
        this.qtdRegistrada = null;
        this.qtdSemRegistro = null;
        this.tipoConsulta = null;
        this.tipoData = null;
        this.totalRegistrada = null;
        this.totalSemRegistro = null;
    }

    public String getApplicationName() {
        return "GerencBloquetoBean";
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

    public java.lang.Long getQtdRegistrada() {
        return this.qtdRegistrada;
    }

    public void setQtdRegistrada(java.lang.Long qtdRegistrada) {
        this.qtdRegistrada = qtdRegistrada;
    }

    public java.lang.Long getQtdSemRegistro() {
        return this.qtdSemRegistro;
    }

    public void setQtdSemRegistro(java.lang.Long qtdSemRegistro) {
        this.qtdSemRegistro = qtdSemRegistro;
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

    public java.lang.Long getTotalRegistrada() {
        return this.totalRegistrada;
    }

    public void setTotalRegistrada(java.lang.Long totalRegistrada) {
        this.totalRegistrada = totalRegistrada;
    }

    public java.lang.Long getTotalSemRegistro() {
        return this.totalSemRegistro;
    }

    public void setTotalSemRegistro(java.lang.Long totalSemRegistro) {
        this.totalSemRegistro = totalSemRegistro;
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
            GerencBloquetoBean other = (GerencBloquetoBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidade(), other.getCodigoUnidade());
            result = result && equals(getData(), other.getData());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result && equals(getMesAno(), other.getMesAno());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result
                     && equals(getQtdRegistrada(), other.getQtdRegistrada());
            result = result
                     && equals(getQtdSemRegistro(), other.getQtdSemRegistro());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoData(), other.getTipoData());
            result = result
                     && equals(getTotalRegistrada(), other.getTotalRegistrada());
            result = result
                     && equals(getTotalSemRegistro(),
                             other.getTotalSemRegistro());
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
        properties.add(new Property("qtdRegistrada",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdSemRegistro",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoData", LongType.create(), false, true));
        properties.add(new Property("totalRegistrada",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalSemRegistro",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "GerencBloquetoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoUnidade", new LongValue("9(04)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("qtdSemRegistro", new LongValue("9(08)"));
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("totalRegistrada", new LongValue("9(08)"));
        Mainframe.put("mesAno", new StringValue("X(07)"));
        Mainframe.put("tipoData", new LongValue("9(01)"));
        Mainframe.put("qtdRegistrada", new LongValue("9(08)"));
        Mainframe.put("totalSemRegistro", new LongValue("9(08)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
