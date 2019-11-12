package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.DateType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.DateValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class GerencValTarifaBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidade;

    private java.util.Date data;

    private java.lang.String descricao;

    private java.lang.String mesAno;

    private java.lang.String nomeUnidade;

    private java.lang.Long qtd;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoData;

    private java.lang.Long tipoEmissao;

    private java.lang.Long totalQtd;

    private br.com.politec.sao.util.Money totalValorCusto;

    private br.com.politec.sao.util.Money totalValorEfetivado;

    private br.com.politec.sao.util.Money totalValorEsperado;

    private br.com.politec.sao.util.Money valorCusto;

    private br.com.politec.sao.util.Money valorEfetivado;

    private br.com.politec.sao.util.Money valorEsperado;

    public GerencValTarifaBean() {
        this.codigoCedente = null;
        this.codigoUnidade = null;
        this.data = null;
        this.descricao = null;
        this.mesAno = null;
        this.nomeUnidade = null;
        this.qtd = null;
        this.tipoConsulta = null;
        this.tipoData = null;
        this.tipoEmissao = null;
        this.totalQtd = null;
        this.totalValorCusto = null;
        this.totalValorEfetivado = null;
        this.totalValorEsperado = null;
        this.valorCusto = null;
        this.valorEfetivado = null;
        this.valorEsperado = null;
    }

    public String getApplicationName() {
        return "GerencValTarifaBean";
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

    public java.lang.Long getQtd() {
        return this.qtd;
    }

    public void setQtd(java.lang.Long qtd) {
        this.qtd = qtd;
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

    public java.lang.Long getTipoEmissao() {
        return this.tipoEmissao;
    }

    public void setTipoEmissao(java.lang.Long tipoEmissao) {
        this.tipoEmissao = tipoEmissao;
    }

    public java.lang.Long getTotalQtd() {
        return this.totalQtd;
    }

    public void setTotalQtd(java.lang.Long totalQtd) {
        this.totalQtd = totalQtd;
    }

    public br.com.politec.sao.util.Money getTotalValorCusto() {
        return this.totalValorCusto;
    }

    public void setTotalValorCusto(br.com.politec.sao.util.Money totalValorCusto) {
        this.totalValorCusto = totalValorCusto;
    }

    public br.com.politec.sao.util.Money getTotalValorEfetivado() {
        return this.totalValorEfetivado;
    }

    public void setTotalValorEfetivado(br.com.politec.sao.util.Money totalValorEfetivado) {
        this.totalValorEfetivado = totalValorEfetivado;
    }

    public br.com.politec.sao.util.Money getTotalValorEsperado() {
        return this.totalValorEsperado;
    }

    public void setTotalValorEsperado(br.com.politec.sao.util.Money totalValorEsperado) {
        this.totalValorEsperado = totalValorEsperado;
    }

    public br.com.politec.sao.util.Money getValorCusto() {
        return this.valorCusto;
    }

    public void setValorCusto(br.com.politec.sao.util.Money valorCusto) {
        this.valorCusto = valorCusto;
    }

    public br.com.politec.sao.util.Money getValorEfetivado() {
        return this.valorEfetivado;
    }

    public void setValorEfetivado(br.com.politec.sao.util.Money valorEfetivado) {
        this.valorEfetivado = valorEfetivado;
    }

    public br.com.politec.sao.util.Money getValorEsperado() {
        return this.valorEsperado;
    }

    public void setValorEsperado(br.com.politec.sao.util.Money valorEsperado) {
        this.valorEsperado = valorEsperado;
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
            GerencValTarifaBean other = (GerencValTarifaBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidade(), other.getCodigoUnidade());
            result = result && equals(getData(), other.getData());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result && equals(getMesAno(), other.getMesAno());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result && equals(getQtd(), other.getQtd());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoData(), other.getTipoData());
            result = result && equals(getTipoEmissao(), other.getTipoEmissao());
            result = result && equals(getTotalQtd(), other.getTotalQtd());
            result = result
                     && equals(getTotalValorCusto(), other.getTotalValorCusto());
            result = result
                     && equals(getTotalValorEfetivado(),
                             other.getTotalValorEfetivado());
            result = result
                     && equals(getTotalValorEsperado(),
                             other.getTotalValorEsperado());
            result = result && equals(getValorCusto(), other.getValorCusto());
            result = result
                     && equals(getValorEfetivado(), other.getValorEfetivado());
            result = result
                     && equals(getValorEsperado(), other.getValorEsperado());
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
        properties.add(new Property("qtd", LongType.create(), false, true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoData", LongType.create(), false, true));
        properties.add(new Property("tipoEmissao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalQtd", LongType.create(), false, true));
        properties.add(new Property("totalValorCusto",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalValorEfetivado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalValorEsperado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorCusto",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorEfetivado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorEsperado",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "GerencValTarifaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("valorEsperado", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("codigoUnidade", new LongValue("9(04)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("totalQtd", new LongValue("9(08)"));
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("totalValorEsperado", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("tipoEmissao", new LongValue("9(01)"));
        Mainframe.put("totalValorEfetivado", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("valorCusto", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("mesAno", new StringValue("X(07)"));
        Mainframe.put("tipoData", new LongValue("9(01)"));
        Mainframe.put("qtd", new LongValue("9(08)"));
        Mainframe.put("valorEfetivado", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalValorCusto", new MoneyValue("R$ 9(15)v99"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
