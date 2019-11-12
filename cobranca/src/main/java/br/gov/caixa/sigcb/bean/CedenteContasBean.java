//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.PercentualType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.PercentualValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Percentual;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteContasBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoClienteCOCLI;

    private java.lang.Long codigoUnidadePVVinc;

    private java.lang.String codigoUsuario;

    private java.lang.Long contaRateioConta;

    private java.lang.Long contaRateioDV;

    private java.lang.Long contaRateioOperacao;

    private java.lang.Long contaRateioUnidade;

    private java.lang.Long cpfCnpj;

    private java.lang.String descricaoCriticas;

    private java.lang.String nsuTransacao;

    private java.lang.Long numeroPacote;

    private java.lang.Long numeroTotalPacotes;

    private Percentual percentualRateio;

    private java.lang.String strRecordset;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoConclusao;

    private java.lang.String tipoConsulta;

    private java.lang.Long tipoConta;

    private java.lang.Long tipoPessoa;

    private java.lang.String titular;

    private br.com.politec.sao.util.Money valorRateio;

    public CedenteContasBean() {
        this.codigoCedente = null;
        this.codigoClienteCOCLI = null;
        this.codigoUnidadePVVinc = null;
        this.codigoUsuario = null;
        this.contaRateioConta = null;
        this.contaRateioDV = null;
        this.contaRateioOperacao = null;
        this.contaRateioUnidade = null;
        this.cpfCnpj = null;
        this.descricaoCriticas = null;
        this.nsuTransacao = null;
        this.numeroPacote = null;
        this.numeroTotalPacotes = null;
        this.percentualRateio = null;
        this.strRecordset = null;
        this.tipoAcao = null;
        this.tipoConclusao = null;
        this.tipoConsulta = null;
        this.tipoConta = null;
        this.tipoPessoa = null;
        this.titular = null;
        this.valorRateio = null;
    }

    public String getApplicationName() {
        return "CedenteContasBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoClienteCOCLI() {
        return this.codigoClienteCOCLI;
    }

    public void setCodigoClienteCOCLI(java.lang.Long codigoClienteCOCLI) {
        this.codigoClienteCOCLI = codigoClienteCOCLI;
    }

    public java.lang.Long getCodigoUnidadePVVinc() {
        return this.codigoUnidadePVVinc;
    }

    public void setCodigoUnidadePVVinc(java.lang.Long codigoUnidadePVVinc) {
        this.codigoUnidadePVVinc = codigoUnidadePVVinc;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.Long getContaRateioConta() {
        return this.contaRateioConta;
    }

    public void setContaRateioConta(java.lang.Long contaRateioConta) {
        this.contaRateioConta = contaRateioConta;
    }

    public java.lang.Long getContaRateioDV() {
        return this.contaRateioDV;
    }

    public void setContaRateioDV(java.lang.Long contaRateioDV) {
        this.contaRateioDV = contaRateioDV;
    }

    public java.lang.Long getContaRateioOperacao() {
        return this.contaRateioOperacao;
    }

    public void setContaRateioOperacao(java.lang.Long contaRateioOperacao) {
        this.contaRateioOperacao = contaRateioOperacao;
    }

    public java.lang.Long getContaRateioUnidade() {
        return this.contaRateioUnidade;
    }

    public void setContaRateioUnidade(java.lang.Long contaRateioUnidade) {
        this.contaRateioUnidade = contaRateioUnidade;
    }

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.lang.String getDescricaoCriticas() {
        return this.descricaoCriticas;
    }

    public void setDescricaoCriticas(java.lang.String descricaoCriticas) {
        this.descricaoCriticas = descricaoCriticas;
    }

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public java.lang.Long getNumeroPacote() {
        return this.numeroPacote;
    }

    public void setNumeroPacote(java.lang.Long numeroPacote) {
        this.numeroPacote = numeroPacote;
    }

    public java.lang.Long getNumeroTotalPacotes() {
        return this.numeroTotalPacotes;
    }

    public void setNumeroTotalPacotes(java.lang.Long numeroTotalPacotes) {
        this.numeroTotalPacotes = numeroTotalPacotes;
    }

    public Percentual getPercentualRateio() {
        return this.percentualRateio;
    }

    public void setPercentualRateio(Percentual percentualRateio) {
        this.percentualRateio = percentualRateio;
    }

    public java.lang.String getStrRecordset() {
        return this.strRecordset;
    }

    public void setStrRecordset(java.lang.String strRecordset) {
        this.strRecordset = strRecordset;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoConclusao() {
        return this.tipoConclusao;
    }

    public void setTipoConclusao(java.lang.Long tipoConclusao) {
        this.tipoConclusao = tipoConclusao;
    }

    public java.lang.String getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public java.lang.Long getTipoConta() {
        return this.tipoConta;
    }

    public void setTipoConta(java.lang.Long tipoConta) {
        this.tipoConta = tipoConta;
    }

    public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public java.lang.String getTitular() {
        return this.titular;
    }

    public void setTitular(java.lang.String titular) {
        this.titular = titular;
    }

    public br.com.politec.sao.util.Money getValorRateio() {
        return this.valorRateio;
    }

    public void setValorRateio(br.com.politec.sao.util.Money valorRateio) {
        this.valorRateio = valorRateio;
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
            CedenteContasBean other = (CedenteContasBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoClienteCOCLI(),
                             other.getCodigoClienteCOCLI());
            result = result
                     && equals(getCodigoUnidadePVVinc(),
                             other.getCodigoUnidadePVVinc());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getContaRateioConta(),
                             other.getContaRateioConta());
            result = result
                     && equals(getContaRateioDV(), other.getContaRateioDV());
            result = result
                     && equals(getContaRateioOperacao(),
                             other.getContaRateioOperacao());
            result = result
                     && equals(getContaRateioUnidade(),
                             other.getContaRateioUnidade());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result
                     && equals(getDescricaoCriticas(),
                             other.getDescricaoCriticas());
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result
                     && equals(getNumeroPacote(), other.getNumeroPacote());
            result = result
                     && equals(getNumeroTotalPacotes(),
                             other.getNumeroTotalPacotes());
            result = result
                     && equals(getPercentualRateio(),
                             other.getPercentualRateio());
            result = result
                     && equals(getStrRecordset(), other.getStrRecordset());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoConclusao(), other.getTipoConclusao());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoConta(), other.getTipoConta());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result && equals(getTitular(), other.getTitular());
            result = result && equals(getValorRateio(), other.getValorRateio());
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
        properties.add(new Property("codigoClienteCOCLI",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePVVinc",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("contaRateioConta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("contaRateioDV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("contaRateioOperacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("contaRateioUnidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("descricaoCriticas",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroPacote",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroTotalPacotes",
                LongType.create(),
                false,
                true));
        properties.add(new Property("percentualRateio",
                PercentualType.create(),
                false,
                true));
        properties.add(new Property("strRecordset",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoConclusao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoConta", LongType.create(), false, true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("titular", StringType.create(), false, true));
        properties.add(new Property("valorRateio",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedenteContasBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("numeroTotalPacotes", new LongValue("9(03)"));
        Mainframe.put("codigoUsuario", new StringValue("X(07)"));
        Mainframe.put("valorRateio", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("tipoConta", new LongValue("9(01)"));
        Mainframe.put("descricaoCriticas", new StringValue("X(200)"));
        Mainframe.put("contaRateioDV", new LongValue("9(01)"));
        Mainframe.put("percentualRateio", new PercentualValue("9(5)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("tipoConsulta", new StringValue("X(01)"));
        Mainframe.put("contaRateioConta", new LongValue("9(08)"));
        Mainframe.put("codigoClienteCOCLI", new LongValue("9(13)"));
        Mainframe.put("titular", new StringValue("X(40)"));
        Mainframe.put("numeroPacote", new LongValue("9(03)"));
        Mainframe.put("contaRateioOperacao", new LongValue("9(03)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("contaRateioUnidade", new LongValue("9(04)"));
        Mainframe.put("strRecordset", new StringValue("X(888)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("codigoUnidadePVVinc", new LongValue("9(04)"));
        Mainframe.put("tipoConclusao", new LongValue("9(02)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
