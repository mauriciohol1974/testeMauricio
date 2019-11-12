//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
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
import br.com.politec.sao.iso.values.PercentualValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class GerencTituloBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidade;

    private java.util.Date data;

    private java.lang.String descricao;

    private java.lang.String mesAno;

    private java.lang.String nomeUnidade;

    private br.com.politec.sao.util.Percentual percentualTarifa;

    private br.com.politec.sao.util.Money preco;

    private java.lang.Long qtd;

    private java.lang.Long qtdSemReg;

    private br.com.politec.sao.util.Money resultado;

    private br.com.politec.sao.util.Money tarifa;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoData;

    private java.lang.Long tipoTitulo;

    private br.com.politec.sao.util.Money totalPreco;

    private java.lang.Long totalQtd;

    private java.lang.Long totalQtdSemReg;

    private br.com.politec.sao.util.Money totalResultado;

    private br.com.politec.sao.util.Money totalTarifa;

    private br.com.politec.sao.util.Money totalValor;

    private br.com.politec.sao.util.Money totalValorSemReg;

    private br.com.politec.sao.util.Money valor;

    private br.com.politec.sao.util.Money valorSemReg;
    
    private br.com.politec.sao.util.Money valorRecebido;
    
    private br.com.politec.sao.util.Money valorLiquido;
    
    private br.com.politec.sao.util.Money valorIOFRetido;
    
    private br.com.politec.sao.util.Money totalValorRecebido;
    
    private br.com.politec.sao.util.Money totalValorLiquido;
    
    private br.com.politec.sao.util.Money totalValorIOFRetido;

    public GerencTituloBean() {
        this.codigoCedente = null;
        this.codigoUnidade = null;
        this.data = null;
        this.descricao = null;
        this.mesAno = null;
        this.nomeUnidade = null;
        this.percentualTarifa = null;
        this.preco = null;
        this.qtd = null;
        this.qtdSemReg = null;
        this.resultado = null;
        this.tarifa = null;
        this.tipoConsulta = null;
        this.tipoData = null;
        this.tipoTitulo = null;
        this.totalPreco = null;
        this.totalQtd = null;
        this.totalQtdSemReg = null;
        this.totalResultado = null;
        this.totalTarifa = null;
        this.totalValor = null;
        this.totalValorSemReg = null;
        this.valor = null;
        this.valorSemReg = null;
        this.valorRecebido = null;
        this.valorLiquido = null;
        this.valorIOFRetido = null;
        this.totalValorRecebido = null;
        this.totalValorLiquido = null;
        this.totalValorIOFRetido = null;
        
    }

    public String getApplicationName() {
        return "GerencTituloBean";
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

    public br.com.politec.sao.util.Percentual getPercentualTarifa() {
        return this.percentualTarifa;
    }

    public void setPercentualTarifa(br.com.politec.sao.util.Percentual percentualTarifa) {
        this.percentualTarifa = percentualTarifa;
    }

    public br.com.politec.sao.util.Money getPreco() {
        return this.preco;
    }

    public void setPreco(br.com.politec.sao.util.Money preco) {
        this.preco = preco;
    }

    public java.lang.Long getQtd() {
        return this.qtd;
    }

    public void setQtd(java.lang.Long qtd) {
        this.qtd = qtd;
    }

    public java.lang.Long getQtdSemReg() {
        return this.qtdSemReg;
    }

    public void setQtdSemReg(java.lang.Long qtdSemReg) {
        this.qtdSemReg = qtdSemReg;
    }

    public br.com.politec.sao.util.Money getResultado() {
        return this.resultado;
    }

    public void setResultado(br.com.politec.sao.util.Money resultado) {
        this.resultado = resultado;
    }

    public br.com.politec.sao.util.Money getTarifa() {
        return this.tarifa;
    }

    public void setTarifa(br.com.politec.sao.util.Money tarifa) {
        this.tarifa = tarifa;
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

    public java.lang.Long getTipoTitulo() {
        return this.tipoTitulo;
    }

    public void setTipoTitulo(java.lang.Long tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }

    public br.com.politec.sao.util.Money getTotalPreco() {
        return this.totalPreco;
    }

    public void setTotalPreco(br.com.politec.sao.util.Money totalPreco) {
        this.totalPreco = totalPreco;
    }

    public java.lang.Long getTotalQtd() {
        return this.totalQtd;
    }

    public void setTotalQtd(java.lang.Long totalQtd) {
        this.totalQtd = totalQtd;
    }

    public java.lang.Long getTotalQtdSemReg() {
        return this.totalQtdSemReg;
    }

    public void setTotalQtdSemReg(java.lang.Long totalQtdSemReg) {
        this.totalQtdSemReg = totalQtdSemReg;
    }

    public br.com.politec.sao.util.Money getTotalResultado() {
        return this.totalResultado;
    }

    public void setTotalResultado(br.com.politec.sao.util.Money totalResultado) {
        this.totalResultado = totalResultado;
    }

    public br.com.politec.sao.util.Money getTotalTarifa() {
        return this.totalTarifa;
    }

    public void setTotalTarifa(br.com.politec.sao.util.Money totalTarifa) {
        this.totalTarifa = totalTarifa;
    }

    public br.com.politec.sao.util.Money getTotalValor() {
        return this.totalValor;
    }

    public void setTotalValor(br.com.politec.sao.util.Money totalValor) {
        this.totalValor = totalValor;
    }

    public br.com.politec.sao.util.Money getTotalValorSemReg() {
        return this.totalValorSemReg;
    }

    public void setTotalValorSemReg(br.com.politec.sao.util.Money totalValorSemReg) {
        this.totalValorSemReg = totalValorSemReg;
    }

    public br.com.politec.sao.util.Money getValor() {
        return this.valor;
    }

    public void setValor(br.com.politec.sao.util.Money valor) {
        this.valor = valor;
    }

    public br.com.politec.sao.util.Money getValorSemReg() {
        return this.valorSemReg;
    }

    public void setValorSemReg(br.com.politec.sao.util.Money valorSemReg) {
        this.valorSemReg = valorSemReg;
    }
    
    public br.com.politec.sao.util.Money getValorRecebido() {
        return this.valorRecebido;
    }

    public void setValorRecebido(br.com.politec.sao.util.Money valorRecebido) {
        this.valorRecebido = valorRecebido;
    }
    
    public br.com.politec.sao.util.Money getValorLiquido() {
        return this.valorLiquido;
    }

    public void setValorLiquido(br.com.politec.sao.util.Money valorLiquido) {
        this.valorLiquido = valorLiquido;
    }
    
    public br.com.politec.sao.util.Money getValorIOFRetido() {
        return this.valorIOFRetido;
    }

    public void setValorIOFRetido(br.com.politec.sao.util.Money valorIOFRetido) {
        this.valorIOFRetido = valorIOFRetido;
    }
    
    public br.com.politec.sao.util.Money getTotalValorRecebido() {
        return this.totalValorRecebido;
    }

    public void setTotalValorRecebido(br.com.politec.sao.util.Money totalValorRecebido) {
        this.totalValorRecebido = totalValorRecebido;
    }
    
    public br.com.politec.sao.util.Money getTotalValorLiquido() {
        return this.totalValorLiquido;
    }

    public void setTotalValorLiquido(br.com.politec.sao.util.Money totalValorLiquido) {
        this.totalValorLiquido = totalValorLiquido;
    }
    
    public br.com.politec.sao.util.Money getTotalValorIOFRetido() {
        return this.totalValorIOFRetido;
    }

    public void setTotalValorIOFRetido(br.com.politec.sao.util.Money totalValorIOFRetido) {
        this.totalValorIOFRetido = totalValorIOFRetido;
    }
  

    // INICIO DAS ALTERAÇÕES
    public String getTipoTituloTexto() {
        String strRetorno = "";
        String[] strTipoTitulo = null;
        strTipoTitulo = new String[] {
                                      "",
                                      "Vencidos",
                                      "A vencer até 7 dias",
                                      "A vencer de 8 a 30 dias",
                                      "A vencer de 31 a 60 dias",
                                      "A vencer de 61 a 90 dias",
                                      "A vencer +90 dias",
                                      "Total", };

        if (this.tipoTitulo != null) {
            int tipo = this.tipoTitulo.intValue();
            strRetorno = strTipoTitulo[tipo];
        }

        return strRetorno;

    }

    public String getTipoTituloTexto2() {
        String strRetorno = "";
        String[] strTipoTitulo = null;
        strTipoTitulo = new String[] { " ", "Vencidos", // 1
                                      "Titulos Incluídos até 7 dias", // 2
                                      "Titulos Incluídos de 8 a 30 dias", // 3
                                      "Titulos Incluídos de 31 a 60 dias",// 4
                                      "Titulos Incluídos de 61 a 90 dias",// 5
                                      "A vencer +90 dias" // 6
        // "Total"
        };

        if (this.tipoTitulo != null) {
            int tipo = this.tipoTitulo.intValue();
            strRetorno = strTipoTitulo[tipo];
        }

        return strRetorno;

    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // TÉRMINO DAS ALTERAÇÕES

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            GerencTituloBean other = (GerencTituloBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidade(), other.getCodigoUnidade());
            result = result && equals(getData(), other.getData());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result && equals(getMesAno(), other.getMesAno());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result
                     && equals(getPercentualTarifa(),
                             other.getPercentualTarifa());
            result = result && equals(getPreco(), other.getPreco());
            result = result && equals(getQtd(), other.getQtd());
            result = result && equals(getQtdSemReg(), other.getQtdSemReg());
            result = result && equals(getResultado(), other.getResultado());
            result = result && equals(getTarifa(), other.getTarifa());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoData(), other.getTipoData());
            result = result && equals(getTipoTitulo(), other.getTipoTitulo());
            result = result && equals(getTotalPreco(), other.getTotalPreco());
            result = result && equals(getTotalQtd(), other.getTotalQtd());
            result = result
                     && equals(getTotalQtdSemReg(), other.getTotalQtdSemReg());
            result = result
                     && equals(getTotalResultado(), other.getTotalResultado());
            result = result && equals(getTotalTarifa(), other.getTotalTarifa());
            result = result && equals(getTotalValor(), other.getTotalValor());
            result = result
                     && equals(getTotalValorSemReg(),
                             other.getTotalValorSemReg());
            result = result && equals(getValor(), other.getValor());
            result = result && equals(getValorSemReg(), other.getValorSemReg());
            result = result && equals(getValorRecebido(), other.getValorRecebido());
            result = result && equals(getValorLiquido(), other.getValorLiquido());
            result = result && equals(getValorIOFRetido(), other.getValorIOFRetido());
            result = result && equals(getTotalValorRecebido(), other.getTotalValorRecebido());
            result = result && equals(getTotalValorLiquido(), other.getTotalValorLiquido());
            result = result && equals(getTotalValorIOFRetido(), other.getTotalValorIOFRetido());
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
        properties.add(new Property("percentualTarifa",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("preco", MoneyType.create(), false, true));
        properties.add(new Property("qtd", LongType.create(), false, true));
        properties.add(new Property("qtdSemReg", LongType.create(), false, true));
        properties.add(new Property("resultado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("tarifa", MoneyType.create(), false, true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoData", LongType.create(), false, true));
        properties.add(new Property("tipoTitulo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalPreco",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalQtd", LongType.create(), false, true));
        properties.add(new Property("totalQtdSemReg",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalResultado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalTarifa",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalValorSemReg",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valor", MoneyType.create(), false, true));
        properties.add(new Property("valorSemReg",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorRecebido",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorLiquido",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorIOFRetido",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalValorRecebido",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalValorLiquido",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalValorIOFRetido",
                MoneyType.create(),
                false,
                true));
              
        Layout result = new Layout(properties,
                "GerencTituloBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("totalValorSemReg", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("tipoTitulo", new LongValue("9(01)"));
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("totalQtd", new LongValue("9(08)"));
        Mainframe.put("totalTarifa", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("preco", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalResultado", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("valor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("qtdSemReg", new LongValue("9(08)"));
        Mainframe.put("tipoData", new LongValue("9(01)"));
        Mainframe.put("codigoUnidade", new LongValue("9(04)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("totalPreco", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("tarifa", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalQtdSemReg", new LongValue("9(08)"));
        Mainframe.put("mesAno", new StringValue("X(07)"));
        Mainframe.put("qtd", new LongValue("9(08)"));
        Mainframe.put("totalValor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("percentualTarifa", new PercentualValue("9(05)"));
        Mainframe.put("valorSemReg", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("resultado", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valorRecebido", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("valorLiquido", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("valorIOFRetido", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalValorRecebido", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalValorLiquido", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalValorIOFRetido", new MoneyValue("R$ 9(15)v99"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
