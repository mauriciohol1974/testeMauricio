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

public class GerencTotalTarifaBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidade;

    private java.util.Date data;

    private java.lang.String descricao;

    private java.lang.String mesAno;

    private java.lang.String nomeUnidade;

    private java.lang.Long qtdExterno;

    private java.lang.Long qtdInterno;

    private java.lang.Long qtdTotal;

    private br.com.politec.sao.util.Money resValExterno;

    private br.com.politec.sao.util.Money resValInterno;

    private br.com.politec.sao.util.Money resValTotal;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoData;

    private java.lang.Long tipoServico;

    private br.com.politec.sao.util.Money valorExterno;

    private br.com.politec.sao.util.Money valorInterno;

    private br.com.politec.sao.util.Money valorTotal;

    public GerencTotalTarifaBean() {
        this.codigoCedente = null;
        this.codigoUnidade = null;
        this.data = null;
        this.descricao = null;
        this.mesAno = null;
        this.nomeUnidade = null;
        this.qtdExterno = null;
        this.qtdInterno = null;
        this.qtdTotal = null;
        this.resValExterno = null;
        this.resValInterno = null;
        this.resValTotal = null;
        this.tipoConsulta = null;
        this.tipoData = null;
        this.tipoServico = null;
        this.valorExterno = null;
        this.valorInterno = null;
        this.valorTotal = null;
    }

    public String getApplicationName() {
        return "GerencTotalTarifaBean";
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

    public java.lang.Long getQtdExterno() {
        return this.qtdExterno;
    }

    public void setQtdExterno(java.lang.Long qtdExterno) {
        this.qtdExterno = qtdExterno;
    }

    public java.lang.Long getQtdInterno() {
        return this.qtdInterno;
    }

    public void setQtdInterno(java.lang.Long qtdInterno) {
        this.qtdInterno = qtdInterno;
    }

    public java.lang.Long getQtdTotal() {
        return this.qtdTotal;
    }

    public void setQtdTotal(java.lang.Long qtdTotal) {
        this.qtdTotal = qtdTotal;
    }

    public br.com.politec.sao.util.Money getResValExterno() {
        return this.resValExterno;
    }

    public void setResValExterno(br.com.politec.sao.util.Money resValExterno) {
        this.resValExterno = resValExterno;
    }

    public br.com.politec.sao.util.Money getResValInterno() {
        return this.resValInterno;
    }

    public void setResValInterno(br.com.politec.sao.util.Money resValInterno) {
        this.resValInterno = resValInterno;
    }

    public br.com.politec.sao.util.Money getResValTotal() {
        return this.resValTotal;
    }

    public void setResValTotal(br.com.politec.sao.util.Money resValTotal) {
        this.resValTotal = resValTotal;
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

    public java.lang.Long getTipoServico() {
        return this.tipoServico;
    }

    public void setTipoServico(java.lang.Long tipoServico) {
        this.tipoServico = tipoServico;
    }

    public br.com.politec.sao.util.Money getValorExterno() {
        return this.valorExterno;
    }

    public void setValorExterno(br.com.politec.sao.util.Money valorExterno) {
        this.valorExterno = valorExterno;
    }

    public br.com.politec.sao.util.Money getValorInterno() {
        return this.valorInterno;
    }

    public void setValorInterno(br.com.politec.sao.util.Money valorInterno) {
        this.valorInterno = valorInterno;
    }

    public br.com.politec.sao.util.Money getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(br.com.politec.sao.util.Money valorTotal) {
        this.valorTotal = valorTotal;
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
            GerencTotalTarifaBean other = (GerencTotalTarifaBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidade(), other.getCodigoUnidade());
            result = result && equals(getData(), other.getData());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result && equals(getMesAno(), other.getMesAno());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result && equals(getQtdExterno(), other.getQtdExterno());
            result = result && equals(getQtdInterno(), other.getQtdInterno());
            result = result && equals(getQtdTotal(), other.getQtdTotal());
            result = result
                     && equals(getResValExterno(), other.getResValExterno());
            result = result
                     && equals(getResValInterno(), other.getResValInterno());
            result = result && equals(getResValTotal(), other.getResValTotal());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoData(), other.getTipoData());
            result = result && equals(getTipoServico(), other.getTipoServico());
            result = result
                     && equals(getValorExterno(), other.getValorExterno());
            result = result
                     && equals(getValorInterno(), other.getValorInterno());
            result = result && equals(getValorTotal(), other.getValorTotal());
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
        properties.add(new Property("qtdExterno",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdInterno",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdTotal", LongType.create(), false, true));
        properties.add(new Property("resValExterno",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("resValInterno",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("resValTotal",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoData", LongType.create(), false, true));
        properties.add(new Property("tipoServico",
                LongType.create(),
                false,
                true));
        properties.add(new Property("valorExterno",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorInterno",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTotal",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "GerencTotalTarifaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("qtdExterno", new LongValue("9(08)"));
        Mainframe.put("qtdInterno", new LongValue("9(08)"));
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("resValTotal", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("resValExterno", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("tipoData", new LongValue("9(01)"));
        Mainframe.put("codigoUnidade", new LongValue("9(04)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("tipoServico", new LongValue("9(01)"));
        Mainframe.put("mesAno", new StringValue("X(07)"));
        Mainframe.put("qtdTotal", new LongValue("9(08)"));
        Mainframe.put("resValInterno", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("valorTotal", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valorExterno", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("valorInterno", new MoneyValue("R$ 9(15)v99"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
