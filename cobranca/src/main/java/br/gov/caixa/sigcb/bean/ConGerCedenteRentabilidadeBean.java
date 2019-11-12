package br.gov.caixa.sigcb.bean;

import java.math.BigDecimal;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class ConGerCedenteRentabilidadeBean extends SigcbBean {
    private java.lang.Long classificacao;

    private java.lang.Long codigoCanal;

    private java.lang.Long codigoCedente;

    private java.lang.String codigoUsuario;

    private java.lang.Long faixaRentabilidade;

    private java.lang.String nomeFantasia;

    private java.lang.Long numeroResultado;

    private br.com.politec.sao.util.Money outrosCustos;

    private java.lang.Long periodo;

    private br.com.politec.sao.util.Money precoTransferencia;

    private java.lang.Long qtdAlteracaoesTitulos;

    private java.lang.Long qtdBaixaTitulos;

    private java.lang.Long qtdBloquetos;

    private java.lang.Long rentabilidade;

    private br.com.politec.sao.util.Money rentabilidadeMedia;

    private br.com.politec.sao.util.Money valor;

    private br.com.politec.sao.util.Money valorBrutoTarifas;

    private br.com.politec.sao.util.Money valorLiquido;

    private br.com.politec.sao.util.Money valorReferencia;

    private java.lang.String sinalRentabilidadeMedia;

    private java.lang.String sinalValorLiquido;

    public ConGerCedenteRentabilidadeBean() {
        this.classificacao = null;
        this.codigoCanal = null;
        this.codigoCedente = null;
        this.codigoUsuario = null;
        this.faixaRentabilidade = null;
        this.nomeFantasia = null;
        this.numeroResultado = null;
        this.outrosCustos = null;
        this.periodo = null;
        this.precoTransferencia = null;
        this.qtdAlteracaoesTitulos = null;
        this.qtdBaixaTitulos = null;
        this.qtdBloquetos = null;
        this.rentabilidade = null;
        this.rentabilidadeMedia = null;
        this.valor = null;
        this.valorBrutoTarifas = null;
        this.valorLiquido = null;
        this.valorReferencia = null;
        this.sinalRentabilidadeMedia = null;
        this.sinalValorLiquido = null;
    }

    public String getApplicationName() {
        return "ConGerCedenteRentabilidadeBean";
    }

    public java.lang.Long getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(java.lang.Long classificacao) {
        this.classificacao = classificacao;
    }

    public java.lang.Long getCodigoCanal() {
        return this.codigoCanal;
    }

    public void setCodigoCanal(java.lang.Long codigoCanal) {
        this.codigoCanal = codigoCanal;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.Long getFaixaRentabilidade() {
        return this.faixaRentabilidade;
    }

    public void setFaixaRentabilidade(java.lang.Long faixaRentabilidade) {
        this.faixaRentabilidade = faixaRentabilidade;
    }

    public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public java.lang.Long getNumeroResultado() {
        return this.numeroResultado;
    }

    public void setNumeroResultado(java.lang.Long numeroResultado) {
        this.numeroResultado = numeroResultado;
    }

    public br.com.politec.sao.util.Money getOutrosCustos() {
        return this.outrosCustos;
    }

    public void setOutrosCustos(br.com.politec.sao.util.Money outrosCustos) {
        this.outrosCustos = outrosCustos;
    }

    public java.lang.Long getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(java.lang.Long periodo) {
        this.periodo = periodo;
    }

    public br.com.politec.sao.util.Money getPrecoTransferencia() {
        return this.precoTransferencia;
    }

    public void setPrecoTransferencia(br.com.politec.sao.util.Money precoTransferencia) {
        this.precoTransferencia = precoTransferencia;
    }

    public java.lang.Long getQtdAlteracaoesTitulos() {
        return this.qtdAlteracaoesTitulos;
    }

    public void setQtdAlteracaoesTitulos(java.lang.Long qtdAlteracaoesTitulos) {
        this.qtdAlteracaoesTitulos = qtdAlteracaoesTitulos;
    }

    public java.lang.Long getQtdBaixaTitulos() {
        return this.qtdBaixaTitulos;
    }

    public void setQtdBaixaTitulos(java.lang.Long qtdBaixaTitulos) {
        this.qtdBaixaTitulos = qtdBaixaTitulos;
    }

    public java.lang.Long getQtdBloquetos() {
        return this.qtdBloquetos;
    }

    public void setQtdBloquetos(java.lang.Long qtdBloquetos) {
        this.qtdBloquetos = qtdBloquetos;
    }

    public java.lang.Long getRentabilidade() {
        return this.rentabilidade;
    }

    public void setRentabilidade(java.lang.Long rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public br.com.politec.sao.util.Money getValor() {
        return this.valor;
    }

    public void setValor(br.com.politec.sao.util.Money valor) {
        this.valor = valor;
    }

    public br.com.politec.sao.util.Money getValorBrutoTarifas() {
        return this.valorBrutoTarifas;
    }

    public void setValorBrutoTarifas(br.com.politec.sao.util.Money valorBrutoTarifas) {
        this.valorBrutoTarifas = valorBrutoTarifas;
    }

    public br.com.politec.sao.util.Money getValorLiquido() {
        return this.valorLiquido;
    }

    public void setValorLiquido(br.com.politec.sao.util.Money valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public br.com.politec.sao.util.Money getValorReferencia() {
        return this.valorReferencia;
    }

    public void setValorReferencia(br.com.politec.sao.util.Money valorReferencia) {
        this.valorReferencia = valorReferencia;
    }

    /* Alteração Manual */

    public br.com.politec.sao.util.Money getRentabilidadeMediaSigned() {
        BigDecimal factor = new BigDecimal(getSinalRentabilidadeMedia().equals("-")
                ? "-1"
                : "1");
        BigDecimal amount = rentabilidadeMedia.toBigDecimal().multiply(factor);
        return (new br.com.politec.sao.util.Money(amount.toString(),
                rentabilidadeMedia.getCurrency()));
    }

    public br.com.politec.sao.util.Money getValorLiquidoSigned() {
        BigDecimal factor = new BigDecimal(getSinalValorLiquido().equals("-")
                ? "-1"
                : "1");
        BigDecimal amount = valorLiquido.toBigDecimal().multiply(factor);
        return (new br.com.politec.sao.util.Money(amount.toString(),
                valorLiquido.getCurrency()));
    }

    public java.lang.String getSinalRentabilidadeMedia() {
        return this.sinalRentabilidadeMedia;
    }

    public void setSinalRentabilidadeMedia(java.lang.String sinalRentabilidadeMedia) {
        this.sinalRentabilidadeMedia = sinalRentabilidadeMedia;
    }

    public java.lang.String getSinalValorLiquido() {
        return this.sinalValorLiquido;
    }

    public void setSinalValorLiquido(java.lang.String sinalValorLiquido) {
        this.sinalValorLiquido = sinalValorLiquido;
    }

    public br.com.politec.sao.util.Money getRentabilidadeMedia() {
        return this.rentabilidadeMedia;
    }

    public void setRentabilidadeMedia(br.com.politec.sao.util.Money rentabilidadeMedia) {
        this.rentabilidadeMedia = rentabilidadeMedia;
    }

    public String getDescricaoCanal() {

        String retorno = "";

        if (this.codigoCanal != null) {
            switch (codigoCanal.intValue()) {
            case 5:
                retorno = "Caixa - Dinheiro";
                break;
            case 71:
                retorno = "Caixa - Cheque";
                break;
            case 4:
                retorno = "Lotérico - Dinheiro";
                break;
            case 72:
                retorno = "Lotérico - Cheque";
                break;
            case 6:
                retorno = "Compensação";
                break;
            case 7:
                retorno = "Auto-Atendimento";
                break;
            case 80:
                retorno = "Correspondente Bancário";
                break;
            case 73:
                retorno = "Internet Banking";
                break;
            case 81:
                retorno = "STR/TED";
                break;
            case 78:
                retorno = "Cartório Dinheiro";
                break;
            case 90:
                retorno = "Cartório Cheque";
                break;
            case 54:
                retorno = "Caixa - Dinheiro - PEC";
                break;
            case 56:
                retorno = "Caixa - Cheque - PEC";
                break;
            case 57:
                retorno = "Lotérico - Dinheiro - PEC";
                break;
            case 60:
                retorno = "Lotérico - Cheque - PEC";
                break;    
            default:
                retorno = "" + codigoCanal;
                break;
            }
        }
        return retorno;
    }

    public String getDescRentabilidade() {
        String retorno = "";
        if (this.rentabilidade != null) {
            switch (rentabilidade.intValue()) {
            case 1:
                retorno = "Mais Rentáveis";
                break;
            case 2:
                retorno = "Menos rentáveis";
                break;
            default:
                retorno = " " + rentabilidade;
                break;
            }

        }
        return retorno;
    }

    public String getDescFaixaRentabilidade() {

        String retorno = "";

        if (this.faixaRentabilidade != null) {
            switch (faixaRentabilidade.intValue()) {
            case 0:
                retorno = "Não Considerado";
                break;
            case 1:
                retorno = "Abaixo de " + valorReferencia;
                break;
            case 2:
                retorno = "Acima de " + valorReferencia;
                break;
            case 3:
                retorno = "Igual a " + valorReferencia;
                break;
            }

        }
        return retorno;
    }

    public String getDescPeriodo() {
        String retorno = "";

        if (this.periodo != null) {
            switch (periodo.intValue()) {
            case 1:
                retorno = "30 DIAS";
                break;
            case 2:
                retorno = "60 DIAS";
                break;
            case 3:
                retorno = "90 DIAS";
                break;
            default:
                retorno = " ";
                break;
            }
        }
        return retorno;
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
            ConGerCedenteRentabilidadeBean other = (ConGerCedenteRentabilidadeBean) obj;
            result = result
                     && equals(getClassificacao(), other.getClassificacao());
            result = result && equals(getCodigoCanal(), other.getCodigoCanal());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getFaixaRentabilidade(),
                             other.getFaixaRentabilidade());
            result = result
                     && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result
                     && equals(getNumeroResultado(), other.getNumeroResultado());
            result = result
                     && equals(getOutrosCustos(), other.getOutrosCustos());
            result = result && equals(getPeriodo(), other.getPeriodo());
            result = result
                     && equals(getPrecoTransferencia(),
                             other.getPrecoTransferencia());
            result = result
                     && equals(getQtdAlteracaoesTitulos(),
                             other.getQtdAlteracaoesTitulos());
            result = result
                     && equals(getQtdBaixaTitulos(), other.getQtdBaixaTitulos());
            result = result
                     && equals(getQtdBloquetos(), other.getQtdBloquetos());
            result = result
                     && equals(getRentabilidade(), other.getRentabilidade());
            result = result
                     && equals(getRentabilidadeMedia(),
                             other.getRentabilidadeMedia());
            result = result && equals(getValor(), other.getValor());
            result = result
                     && equals(getValorBrutoTarifas(),
                             other.getValorBrutoTarifas());
            result = result
                     && equals(getValorLiquido(), other.getValorLiquido());
            result = result
                     && equals(getValorReferencia(), other.getValorReferencia());
            result = result
                     && equals(getSinalRentabilidadeMedia(),
                             other.getSinalRentabilidadeMedia());
            result = result
                     && equals(getSinalValorLiquido(),
                             other.getSinalValorLiquido());
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
        properties.add(new Property("classificacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCanal",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("faixaRentabilidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nomeFantasia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroResultado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("outrosCustos",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("periodo", LongType.create(), false, true));
        properties.add(new Property("precoTransferencia",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("qtdAlteracaoesTitulos",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdBaixaTitulos",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qtdBloquetos",
                LongType.create(),
                false,
                true));
        properties.add(new Property("rentabilidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("rentabilidadeMedia",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valor", MoneyType.create(), false, true));
        properties.add(new Property("valorBrutoTarifas",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorLiquido",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorReferencia",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("sinalValorLiquido",
                StringType.create(),
                false,
                true));
        properties.add(new Property("sinalRentabilidadeMedia",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ConGerCedenteRentabilidadeBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("valorBrutoTarifas", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("qtdAlteracaoesTitulos", new LongValue("9(08)"));
        Mainframe.put("periodo", new LongValue("9(01)"));
        Mainframe.put("numeroResultado", new LongValue("9(02)"));
        Mainframe.put("nomeFantasia", new StringValue("X(40)"));
        Mainframe.put("valor", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("rentabilidadeMedia", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("qtdBaixaTitulos", new LongValue("9(08)"));
        Mainframe.put("qtdBloquetos", new LongValue("9(07)"));
        Mainframe.put("outrosCustos", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("valorReferencia", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("precoTransferencia", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorLiquido", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("classificacao", new LongValue("9(02)"));
        Mainframe.put("codigoCanal", new LongValue("9(03)"));
        Mainframe.put("rentabilidade", new LongValue("9(01)"));
        Mainframe.put("faixaRentabilidade", new LongValue("9(01)"));
        Mainframe.put("sinalValorLiquido", new StringValue("X(01)"));
        Mainframe.put("sinalRentabilidadeMedia", new StringValue("X(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
