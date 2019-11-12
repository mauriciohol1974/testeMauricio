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

public class GerencPrecoBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidade;

    private java.util.Date data;

    private java.lang.String descricao;

    private java.lang.String mesAno;

    private java.lang.String nomeUnidade;

    private br.com.politec.sao.util.Money preco;

    private br.com.politec.sao.util.Money precoTotal;

    private java.lang.Long qtd;

    private br.com.politec.sao.util.Money saldo;

    private br.com.politec.sao.util.Money tarifaInt;

    private br.com.politec.sao.util.Money tarifaNeg;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoData;

    private br.com.politec.sao.util.Money totalPreco;

    private br.com.politec.sao.util.Money totalPrecoTotal;

    private java.lang.Long totalQtd;

    private br.com.politec.sao.util.Money totalSaldo;

    private br.com.politec.sao.util.Money totalTarifaInt;

    private br.com.politec.sao.util.Money totalTarifaNeg;

    public GerencPrecoBean() {
        this.codigoCedente = null;
        this.codigoUnidade = null;
        this.data = null;
        this.descricao = null;
        this.mesAno = null;
        this.nomeUnidade = null;
        this.preco = null;
        this.precoTotal = null;
        this.qtd = null;
        this.saldo = null;
        this.tarifaInt = null;
        this.tarifaNeg = null;
        this.tipoConsulta = null;
        this.tipoData = null;
        this.totalPreco = null;
        this.totalPrecoTotal = null;
        this.totalQtd = null;
        this.totalSaldo = null;
        this.totalTarifaInt = null;
        this.totalTarifaNeg = null;
    }

    public String getApplicationName() {
        return "GerencPrecoBean";
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

    public br.com.politec.sao.util.Money getPreco() {
        return this.preco;
    }

    public void setPreco(br.com.politec.sao.util.Money preco) {
        this.preco = preco;
    }

    public br.com.politec.sao.util.Money getPrecoTotal() {
        return this.precoTotal;
    }

    public void setPrecoTotal(br.com.politec.sao.util.Money precoTotal) {
        this.precoTotal = precoTotal;
    }

    public java.lang.Long getQtd() {
        return this.qtd;
    }

    public void setQtd(java.lang.Long qtd) {
        this.qtd = qtd;
    }

    public br.com.politec.sao.util.Money getSaldo() {
        return this.saldo;
    }

    public void setSaldo(br.com.politec.sao.util.Money saldo) {
        this.saldo = saldo;
    }

    public br.com.politec.sao.util.Money getTarifaInt() {
        return this.tarifaInt;
    }

    public void setTarifaInt(br.com.politec.sao.util.Money tarifaInt) {
        this.tarifaInt = tarifaInt;
    }

    public br.com.politec.sao.util.Money getTarifaNeg() {
        return this.tarifaNeg;
    }

    public void setTarifaNeg(br.com.politec.sao.util.Money tarifaNeg) {
        this.tarifaNeg = tarifaNeg;
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

    public br.com.politec.sao.util.Money getTotalPreco() {
        return this.totalPreco;
    }

    public void setTotalPreco(br.com.politec.sao.util.Money totalPreco) {
        this.totalPreco = totalPreco;
    }

    public br.com.politec.sao.util.Money getTotalPrecoTotal() {
        return this.totalPrecoTotal;
    }

    public void setTotalPrecoTotal(br.com.politec.sao.util.Money totalPrecoTotal) {
        this.totalPrecoTotal = totalPrecoTotal;
    }

    public java.lang.Long getTotalQtd() {
        return this.totalQtd;
    }

    public void setTotalQtd(java.lang.Long totalQtd) {
        this.totalQtd = totalQtd;
    }

    public br.com.politec.sao.util.Money getTotalSaldo() {
        return this.totalSaldo;
    }

    public void setTotalSaldo(br.com.politec.sao.util.Money totalSaldo) {
        this.totalSaldo = totalSaldo;
    }

    public br.com.politec.sao.util.Money getTotalTarifaInt() {
        return this.totalTarifaInt;
    }

    public void setTotalTarifaInt(br.com.politec.sao.util.Money totalTarifaInt) {
        this.totalTarifaInt = totalTarifaInt;
    }

    public br.com.politec.sao.util.Money getTotalTarifaNeg() {
        return this.totalTarifaNeg;
    }

    public void setTotalTarifaNeg(br.com.politec.sao.util.Money totalTarifaNeg) {
        this.totalTarifaNeg = totalTarifaNeg;
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
            GerencPrecoBean other = (GerencPrecoBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidade(), other.getCodigoUnidade());
            result = result && equals(getData(), other.getData());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result && equals(getMesAno(), other.getMesAno());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result && equals(getPreco(), other.getPreco());
            result = result && equals(getPrecoTotal(), other.getPrecoTotal());
            result = result && equals(getQtd(), other.getQtd());
            result = result && equals(getSaldo(), other.getSaldo());
            result = result && equals(getTarifaInt(), other.getTarifaInt());
            result = result && equals(getTarifaNeg(), other.getTarifaNeg());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoData(), other.getTipoData());
            result = result && equals(getTotalPreco(), other.getTotalPreco());
            result = result
                     && equals(getTotalPrecoTotal(), other.getTotalPrecoTotal());
            result = result && equals(getTotalQtd(), other.getTotalQtd());
            result = result && equals(getTotalSaldo(), other.getTotalSaldo());
            result = result
                     && equals(getTotalTarifaInt(), other.getTotalTarifaInt());
            result = result
                     && equals(getTotalTarifaNeg(), other.getTotalTarifaNeg());
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
        properties.add(new Property("preco", MoneyType.create(), false, true));
        properties.add(new Property("precoTotal",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("qtd", LongType.create(), false, true));
        properties.add(new Property("saldo", MoneyType.create(), false, true));
        properties.add(new Property("tarifaInt",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("tarifaNeg",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoData", LongType.create(), false, true));
        properties.add(new Property("totalPreco",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalPrecoTotal",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalQtd", LongType.create(), false, true));
        properties.add(new Property("totalSaldo",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalTarifaInt",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalTarifaNeg",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "GerencPrecoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("totalQtd", new LongValue("9(08)"));
        Mainframe.put("preco", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalSaldo", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalPrecoTotal", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("precoTotal", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("tipoData", new LongValue("9(01)"));
        Mainframe.put("codigoUnidade", new LongValue("9(04)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("totalTarifaNeg", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalTarifaInt", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("totalPreco", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("saldo", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("mesAno", new StringValue("X(07)"));
        Mainframe.put("qtd", new LongValue("9(08)"));
        Mainframe.put("tarifaNeg", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("tarifaInt", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("data", new DateValue("dd.MM.yyyy"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
