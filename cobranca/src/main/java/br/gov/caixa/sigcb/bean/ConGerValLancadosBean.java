package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.DateType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.DateValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.gov.caixa.sigcb.util.Formatador;

public class ConGerValLancadosBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long conta;

    private java.util.Date dataLancamento;

    private java.lang.Long operacao;

    private java.lang.Long unidadeVinculacao;

    private br.com.politec.sao.util.Money valorCredito;

    private br.com.politec.sao.util.Money valorDebito;

    public ConGerValLancadosBean() {
        this.codigoCedente = null;
        this.conta = null;
        this.dataLancamento = null;
        this.operacao = null;
        this.unidadeVinculacao = null;
        this.valorCredito = null;
        this.valorDebito = null;
    }

    public String getApplicationName() {
        return "ConGerVlrLancadosBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getConta() {
        return this.conta;
    }

    public void setConta(java.lang.Long conta) {
        this.conta = conta;
    }

    public java.util.Date getDataLancamento() {
        return this.dataLancamento;
    }

    /*--------------------inserido-Manualmente--------------------------------- */
    public java.lang.String getDataLancamentoFormatada() {
        if (this.dataLancamento != null) {
            return Formatador.formatarData(this.dataLancamento);
        } else {
            return "";
        }
    }

    /*-------------------------------------------------------------------------- */

    public void setDataLancamento(java.util.Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public java.lang.Long getOperacao() {
        return this.operacao;
    }

    public void setOperacao(java.lang.Long operacao) {
        this.operacao = operacao;
    }

    public java.lang.Long getUnidadeVinculacao() {
        return this.unidadeVinculacao;
    }

    public void setUnidadeVinculacao(java.lang.Long unidadeVinculacao) {
        this.unidadeVinculacao = unidadeVinculacao;
    }

    public br.com.politec.sao.util.Money getValorCredito() {
        return this.valorCredito;
    }

    public void setValorCredito(br.com.politec.sao.util.Money valorCredito) {
        this.valorCredito = valorCredito;
    }

    public br.com.politec.sao.util.Money getValorDebito() {
        return this.valorDebito;
    }

    public void setValorDebito(br.com.politec.sao.util.Money valorDebito) {
        this.valorDebito = valorDebito;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------

    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getUnidadeVinculacaoFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.unidadeVinculacao);
        return codigoUnidadeFormatado;
    }

    public java.lang.String getOperacaoFormatado() {
        String operacaoFormatado = Formatador.formatarOperacao(this.operacao.toString());
        return operacaoFormatado;
    }

    public java.lang.String getContaFormatado() {
        String contaFormatado = Formatador.formatarConta(this.conta.toString());
        return contaFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ConGerValLancadosBean other = (ConGerValLancadosBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getConta(), other.getConta());
            result = result
                     && equals(getDataLancamento(), other.getDataLancamento());
            result = result && equals(getOperacao(), other.getOperacao());
            result = result
                     && equals(getUnidadeVinculacao(),
                             other.getUnidadeVinculacao());
            result = result
                     && equals(getValorCredito(), other.getValorCredito());
            result = result && equals(getValorDebito(), other.getValorDebito());
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
        properties.add(new Property("conta", LongType.create(), false, true));
        properties.add(new Property("dataLancamento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("operacao", LongType.create(), false, true));
        properties.add(new Property("unidadeVinculacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("valorCredito",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorDebito",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ConGerVlrLancadosBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("operacao", new LongValue("9(03)"));
        Mainframe.put("dataLancamento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valorCredito", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("unidadeVinculacao", new LongValue("9(04)"));
        Mainframe.put("valorDebito", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("conta", new LongValue("9(08)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
