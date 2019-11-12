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
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.jsp.ComboConsultaContabil;

public class ContabilBean extends SigcbBean {
    private java.lang.Long codigoUnidade;

    private br.com.politec.sao.util.Money compensacao;

    private br.com.politec.sao.util.Money credito;

    private java.util.Date data;

    private br.com.politec.sao.util.Money debito;

    private br.com.politec.sao.util.Money estorno;

    private br.com.politec.sao.util.Money liquidacao;

    private java.lang.Long navegacao;

    private java.lang.String nomeUnidade;

    private br.com.politec.sao.util.Money outroMeio;

    private java.lang.Long quantidadeLiquidacao;

    private br.com.politec.sao.util.Money repasse;

    private br.com.politec.sao.util.Money saldoAnterior;

    private br.com.politec.sao.util.Money saldoAtual;

    private java.lang.Long selecaoConsulta;

    private java.lang.Long selecaoRadio;

    private java.lang.Long selecaoRecocPv;

    private br.com.politec.sao.util.Money tarifaReceber;

    private java.lang.Long tipoConsulta;

    private br.com.politec.sao.util.Money totalBloquetoRejeitadoCompensacao;

    private br.com.politec.sao.util.Money totalBloquetoRejeitadoOutrosMeios;

    private br.com.politec.sao.util.Money totalCredito;

    private br.com.politec.sao.util.Money totalDebito;

    private br.com.politec.sao.util.Money totalEstorno;

    private br.com.politec.sao.util.Money totalLiquidacao;

    private java.lang.Long totalQuantidadeLiquidacao;

    private br.com.politec.sao.util.Money totalRepasse;

    private br.com.politec.sao.util.Money totalSaldoAnterior;

    private br.com.politec.sao.util.Money totalSaldoAtual;

    private br.com.politec.sao.util.Money totalTarifaReceber;

    private br.com.politec.sao.util.Money totalValorCreditar;

    private br.com.politec.sao.util.Money valorCreditar;

    public ContabilBean() {
        this.codigoUnidade = null;
        this.compensacao = null;
        this.credito = null;
        this.data = null;
        this.debito = null;
        this.estorno = null;
        this.liquidacao = null;
        this.navegacao = null;
        this.nomeUnidade = null;
        this.outroMeio = null;
        this.quantidadeLiquidacao = null;
        this.repasse = null;
        this.saldoAnterior = null;
        this.saldoAtual = null;
        this.selecaoConsulta = null;
        this.selecaoRadio = null;
        this.selecaoRecocPv = null;
        this.tarifaReceber = null;
        this.tipoConsulta = null;
        this.totalBloquetoRejeitadoCompensacao = null;
        this.totalBloquetoRejeitadoOutrosMeios = null;
        this.totalCredito = null;
        this.totalDebito = null;
        this.totalEstorno = null;
        this.totalLiquidacao = null;
        this.totalQuantidadeLiquidacao = null;
        this.totalRepasse = null;
        this.totalSaldoAnterior = null;
        this.totalSaldoAtual = null;
        this.totalTarifaReceber = null;
        this.totalValorCreditar = null;
        this.valorCreditar = null;
    }

    public String getApplicationName() {
        return "ContabilBean";
    }

    public java.lang.Long getCodigoUnidade() {
        return this.codigoUnidade;
    }

    public void setCodigoUnidade(java.lang.Long codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public br.com.politec.sao.util.Money getCompensacao() {
        return this.compensacao;
    }

    public void setCompensacao(br.com.politec.sao.util.Money compensacao) {
        this.compensacao = compensacao;
    }

    public br.com.politec.sao.util.Money getCredito() {
        return this.credito;
    }

    public void setCredito(br.com.politec.sao.util.Money credito) {
        this.credito = credito;
    }

    public java.util.Date getData() {
        return this.data;
    }

    public void setData(java.util.Date data) {
        this.data = data;
    }

    public br.com.politec.sao.util.Money getDebito() {
        return this.debito;
    }

    public void setDebito(br.com.politec.sao.util.Money debito) {
        this.debito = debito;
    }

    public br.com.politec.sao.util.Money getEstorno() {
        return this.estorno;
    }

    public void setEstorno(br.com.politec.sao.util.Money estorno) {
        this.estorno = estorno;
    }

    public br.com.politec.sao.util.Money getLiquidacao() {
        return this.liquidacao;
    }

    public void setLiquidacao(br.com.politec.sao.util.Money liquidacao) {
        this.liquidacao = liquidacao;
    }

    public java.lang.Long getNavegacao() {
        return this.navegacao;
    }

    public void setNavegacao(java.lang.Long navegacao) {
        this.navegacao = navegacao;
    }

    public java.lang.String getNomeUnidade() {
        return this.nomeUnidade;
    }

    public void setNomeUnidade(java.lang.String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public br.com.politec.sao.util.Money getOutroMeio() {
        return this.outroMeio;
    }

    public void setOutroMeio(br.com.politec.sao.util.Money outroMeio) {
        this.outroMeio = outroMeio;
    }

    public java.lang.Long getQuantidadeLiquidacao() {
        return this.quantidadeLiquidacao;
    }

    public void setQuantidadeLiquidacao(java.lang.Long quantidadeLiquidacao) {
        this.quantidadeLiquidacao = quantidadeLiquidacao;
    }

    public br.com.politec.sao.util.Money getRepasse() {
        return this.repasse;
    }

    public void setRepasse(br.com.politec.sao.util.Money repasse) {
        this.repasse = repasse;
    }

    public br.com.politec.sao.util.Money getSaldoAnterior() {
        return this.saldoAnterior;
    }

    public void setSaldoAnterior(br.com.politec.sao.util.Money saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public br.com.politec.sao.util.Money getSaldoAtual() {
        return this.saldoAtual;
    }

    public void setSaldoAtual(br.com.politec.sao.util.Money saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public java.lang.Long getSelecaoConsulta() {
        return this.selecaoConsulta;
    }

    public void setSelecaoConsulta(java.lang.Long selecaoConsulta) {
        this.selecaoConsulta = selecaoConsulta;
    }

    public java.lang.Long getSelecaoRadio() {
        return this.selecaoRadio;
    }

    public void setSelecaoRadio(java.lang.Long selecaoRadio) {
        this.selecaoRadio = selecaoRadio;
    }

    public java.lang.Long getSelecaoRecocPv() {
        return this.selecaoRecocPv;
    }

    public void setSelecaoRecocPv(java.lang.Long selecaoRecocPv) {
        this.selecaoRecocPv = selecaoRecocPv;
    }

    public br.com.politec.sao.util.Money getTarifaReceber() {
        return this.tarifaReceber;
    }

    public void setTarifaReceber(br.com.politec.sao.util.Money tarifaReceber) {
        this.tarifaReceber = tarifaReceber;
    }

    public java.lang.Long getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.Long tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public br.com.politec.sao.util.Money getTotalBloquetoRejeitadoCompensacao() {
        return this.totalBloquetoRejeitadoCompensacao;
    }

    public void setTotalBloquetoRejeitadoCompensacao(br.com.politec.sao.util.Money totalBloquetoRejeitadoCompensacao) {
        this.totalBloquetoRejeitadoCompensacao = totalBloquetoRejeitadoCompensacao;
    }

    public br.com.politec.sao.util.Money getTotalBloquetoRejeitadoOutrosMeios() {
        return this.totalBloquetoRejeitadoOutrosMeios;
    }

    public void setTotalBloquetoRejeitadoOutrosMeios(br.com.politec.sao.util.Money totalBloquetoRejeitadoOutrosMeios) {
        this.totalBloquetoRejeitadoOutrosMeios = totalBloquetoRejeitadoOutrosMeios;
    }

    public br.com.politec.sao.util.Money getTotalCredito() {
        return this.totalCredito;
    }

    public void setTotalCredito(br.com.politec.sao.util.Money totalCredito) {
        this.totalCredito = totalCredito;
    }

    public br.com.politec.sao.util.Money getTotalDebito() {
        return this.totalDebito;
    }

    public void setTotalDebito(br.com.politec.sao.util.Money totalDebito) {
        this.totalDebito = totalDebito;
    }

    public br.com.politec.sao.util.Money getTotalEstorno() {
        return this.totalEstorno;
    }

    public void setTotalEstorno(br.com.politec.sao.util.Money totalEstorno) {
        this.totalEstorno = totalEstorno;
    }

    public br.com.politec.sao.util.Money getTotalLiquidacao() {
        return this.totalLiquidacao;
    }

    public void setTotalLiquidacao(br.com.politec.sao.util.Money totalLiquidacao) {
        this.totalLiquidacao = totalLiquidacao;
    }

    public java.lang.Long getTotalQuantidadeLiquidacao() {
        return this.totalQuantidadeLiquidacao;
    }

    public void setTotalQuantidadeLiquidacao(java.lang.Long totalQuantidadeLiquidacao) {
        this.totalQuantidadeLiquidacao = totalQuantidadeLiquidacao;
    }

    public br.com.politec.sao.util.Money getTotalRepasse() {
        return this.totalRepasse;
    }

    public void setTotalRepasse(br.com.politec.sao.util.Money totalRepasse) {
        this.totalRepasse = totalRepasse;
    }

    public br.com.politec.sao.util.Money getTotalSaldoAnterior() {
        return this.totalSaldoAnterior;
    }

    public void setTotalSaldoAnterior(br.com.politec.sao.util.Money totalSaldoAnterior) {
        this.totalSaldoAnterior = totalSaldoAnterior;
    }

    public br.com.politec.sao.util.Money getTotalSaldoAtual() {
        return this.totalSaldoAtual;
    }

    public void setTotalSaldoAtual(br.com.politec.sao.util.Money totalSaldoAtual) {
        this.totalSaldoAtual = totalSaldoAtual;
    }

    public br.com.politec.sao.util.Money getTotalTarifaReceber() {
        return this.totalTarifaReceber;
    }

    public void setTotalTarifaReceber(br.com.politec.sao.util.Money totalTarifaReceber) {
        this.totalTarifaReceber = totalTarifaReceber;
    }

    public br.com.politec.sao.util.Money getTotalValorCreditar() {
        return this.totalValorCreditar;
    }

    public void setTotalValorCreditar(br.com.politec.sao.util.Money totalValorCreditar) {
        this.totalValorCreditar = totalValorCreditar;
    }

    public br.com.politec.sao.util.Money getValorCreditar() {
        return this.valorCreditar;
    }

    public void setValorCreditar(br.com.politec.sao.util.Money valorCreditar) {
        this.valorCreditar = valorCreditar;
    }

    // Inicio das alterações
    public java.lang.String getDataFormatada() {
        if (this.data != null) {
            return Formatador.formatarData(this.data);
        } else {
            return "";
        }
    }

    public java.lang.String getTipoConsultaTexto() {
        String strRetorno = "";
        if (this.selecaoConsulta != null) {
            strRetorno = new ComboConsultaContabil().getDescricao(this.selecaoConsulta)
                         + " - ";
        }
        if (this.navegacao != null) {
            switch (this.navegacao.intValue()) {
            case 1:
                strRetorno += "UNIDADE PV";
                break;
            case 2:
                strRetorno += "UNIDADE RSRET";
                break;
            case 3:
                strRetorno += "CAIXA";
                break;
            case 4:
                strRetorno += "CAIXA";
                break;
            default:
                break;
            }
        }
        return strRetorno;
    }

    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadeFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidade);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    // Termino das alterações
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ContabilBean other = (ContabilBean) obj;
            result = result
                     && equals(getCodigoUnidade(), other.getCodigoUnidade());
            result = result && equals(getCompensacao(), other.getCompensacao());
            result = result && equals(getCredito(), other.getCredito());
            result = result && equals(getData(), other.getData());
            result = result && equals(getDebito(), other.getDebito());
            result = result && equals(getEstorno(), other.getEstorno());
            result = result && equals(getLiquidacao(), other.getLiquidacao());
            result = result && equals(getNavegacao(), other.getNavegacao());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result && equals(getOutroMeio(), other.getOutroMeio());
            result = result
                     && equals(getQuantidadeLiquidacao(),
                             other.getQuantidadeLiquidacao());
            result = result && equals(getRepasse(), other.getRepasse());
            result = result
                     && equals(getSaldoAnterior(), other.getSaldoAnterior());
            result = result && equals(getSaldoAtual(), other.getSaldoAtual());
            result = result
                     && equals(getSelecaoConsulta(), other.getSelecaoConsulta());
            result = result
                     && equals(getSelecaoRadio(), other.getSelecaoRadio());
            result = result
                     && equals(getSelecaoRecocPv(), other.getSelecaoRecocPv());
            result = result
                     && equals(getTarifaReceber(), other.getTarifaReceber());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result
                     && equals(getTotalBloquetoRejeitadoCompensacao(),
                             other.getTotalBloquetoRejeitadoCompensacao());
            result = result
                     && equals(getTotalBloquetoRejeitadoOutrosMeios(),
                             other.getTotalBloquetoRejeitadoOutrosMeios());
            result = result
                     && equals(getTotalCredito(), other.getTotalCredito());
            result = result && equals(getTotalDebito(), other.getTotalDebito());
            result = result
                     && equals(getTotalEstorno(), other.getTotalEstorno());
            result = result
                     && equals(getTotalLiquidacao(), other.getTotalLiquidacao());
            result = result
                     && equals(getTotalQuantidadeLiquidacao(),
                             other.getTotalQuantidadeLiquidacao());
            result = result
                     && equals(getTotalRepasse(), other.getTotalRepasse());
            result = result
                     && equals(getTotalSaldoAnterior(),
                             other.getTotalSaldoAnterior());
            result = result
                     && equals(getTotalSaldoAtual(), other.getTotalSaldoAtual());
            result = result
                     && equals(getTotalTarifaReceber(),
                             other.getTotalTarifaReceber());
            result = result
                     && equals(getTotalValorCreditar(),
                             other.getTotalValorCreditar());
            result = result
                     && equals(getValorCreditar(), other.getValorCreditar());
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
        properties.add(new Property("codigoUnidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("compensacao",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("credito", MoneyType.create(), false, true));
        properties.add(new Property("data", DateType.create(), false, true));
        properties.add(new Property("debito", MoneyType.create(), false, true));
        properties.add(new Property("estorno", MoneyType.create(), false, true));
        properties.add(new Property("liquidacao",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("navegacao", LongType.create(), false, true));
        properties.add(new Property("nomeUnidade",
                StringType.create(),
                false,
                true));
        properties.add(new Property("outroMeio",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("quantidadeLiquidacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("repasse", MoneyType.create(), false, true));
        properties.add(new Property("saldoAnterior",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("saldoAtual",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("selecaoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("selecaoRadio",
                LongType.create(),
                false,
                true));
        properties.add(new Property("selecaoRecocPv",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tarifaReceber",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalBloquetoRejeitadoCompensacao",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalBloquetoRejeitadoOutrosMeios",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalCredito",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalDebito",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalEstorno",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalLiquidacao",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalQuantidadeLiquidacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalRepasse",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalSaldoAnterior",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalSaldoAtual",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalTarifaReceber",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalValorCreditar",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorCreditar",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ContabilBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("totalQuantidadeLiquidacao", new LongValue("9(10)"));
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("totalBloquetoRejeitadoOutrosMeios",
                new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("totalCredito", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("debito", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("quantidadeLiquidacao", new LongValue("9(08)"));
        Mainframe.put("selecaoRecocPv", new LongValue("9(01)"));
        Mainframe.put("totalRepasse", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("selecaoConsulta", new LongValue("9(01)"));
        Mainframe.put("selecaoRadio", new LongValue("9(01)"));
        Mainframe.put("navegacao", new LongValue("9(01)"));
        Mainframe.put("outroMeio", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("saldoAnterior", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("credito", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("totalSaldoAtual", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("totalBloquetoRejeitadoCompensacao",
                new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("codigoUnidade", new LongValue("9(04)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("saldoAtual", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("totalEstorno", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("repasse", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorCreditar", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("compensacao", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("totalDebito", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("totalValorCreditar", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("estorno", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("totalLiquidacao", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("tarifaReceber", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("totalTarifaReceber", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("liquidacao", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("totalSaldoAnterior", new MoneyValue("R$ 9(16)v99"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
