//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
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

public class BloquetoBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.String codigoUsuario;

    private java.util.Date dataEnvioGrafica;

    private java.util.Date dataLiberImpr;

    private java.util.Date dataMovimento;

    private java.lang.Long envioBloqueto;

    private java.lang.String grafica;

    private java.lang.Long meioEntrada;

    private java.lang.Long nossoNumero;

    private java.lang.Long numeroPedido;

    private java.lang.Long quantidade;

    private java.lang.Long situacaoSolicitacao;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoBloqueto;

    public BloquetoBean() {
        this.codigoCedente = null;
        this.codigoUsuario = null;
        this.dataEnvioGrafica = null;
        this.dataLiberImpr = null;
        this.dataMovimento = null;
        this.envioBloqueto = null;
        this.grafica = null;
        this.meioEntrada = null;
        this.nossoNumero = null;
        this.numeroPedido = null;
        this.quantidade = null;
        this.situacaoSolicitacao = null;
        this.tipoAcao = null;
        this.tipoBloqueto = null;
    }

    public String getApplicationName() {
        return "BloquetoBean";
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

    public java.util.Date getDataEnvioGrafica() {
        return this.dataEnvioGrafica;
    }

    public void setDataEnvioGrafica(java.util.Date dataEnvioGrafica) {
        this.dataEnvioGrafica = dataEnvioGrafica;
    }

    public java.util.Date getDataLiberImpr() {
        return this.dataLiberImpr;
    }

    public void setDataLiberImpr(java.util.Date dataLiberImpr) {
        this.dataLiberImpr = dataLiberImpr;
    }

    public java.util.Date getDataMovimento() {
        return this.dataMovimento;
    }

    public void setDataMovimento(java.util.Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public java.lang.Long getEnvioBloqueto() {
        return this.envioBloqueto;
    }

    public void setEnvioBloqueto(java.lang.Long envioBloqueto) {
        this.envioBloqueto = envioBloqueto;
    }

    public java.lang.String getGrafica() {
        return this.grafica;
    }

    public void setGrafica(java.lang.String grafica) {
        this.grafica = grafica;
    }

    public java.lang.Long getMeioEntrada() {
        return this.meioEntrada;
    }

    public void setMeioEntrada(java.lang.Long meioEntrada) {
        this.meioEntrada = meioEntrada;
    }

    public java.lang.Long getNossoNumero() {
        return this.nossoNumero;
    }

    public void setNossoNumero(java.lang.Long nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public java.lang.Long getNumeroPedido() {
        return this.numeroPedido;
    }

    public void setNumeroPedido(java.lang.Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public java.lang.Long getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(java.lang.Long quantidade) {
        this.quantidade = quantidade;
    }

    public java.lang.Long getSituacaoSolicitacao() {
        return this.situacaoSolicitacao;
    }

    public void setSituacaoSolicitacao(java.lang.Long situacaoSolicitacao) {
        this.situacaoSolicitacao = situacaoSolicitacao;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoBloqueto() {
        return this.tipoBloqueto;
    }

    public void setTipoBloqueto(java.lang.Long tipoBloqueto) {
        this.tipoBloqueto = tipoBloqueto;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getNossoNumeroFormatado-----------------------
    public java.lang.String getNossoNumeroFormatado() {
        String nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumero);
        return nossoNumeroFormatado;
    }

    // fim-------------getNossoNumeroFormatado-----------------------

    // Métodos para imprimir os quinze caracteres restantes nosso número
    public java.lang.String getNossoNumeroQuinzeFormatado() {
        String nn = this.getNossoNumeroFormatado();
        if (nn.length() > 2) {
            nn = nn.substring(2, nn.length());
        }
        return nn;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            BloquetoBean other = (BloquetoBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getDataEnvioGrafica(),
                             other.getDataEnvioGrafica());
            result = result
                     && equals(getDataLiberImpr(), other.getDataLiberImpr());
            result = result
                     && equals(getDataMovimento(), other.getDataMovimento());
            result = result
                     && equals(getEnvioBloqueto(), other.getEnvioBloqueto());
            result = result && equals(getGrafica(), other.getGrafica());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result
                     && equals(getNumeroPedido(), other.getNumeroPedido());
            result = result && equals(getQuantidade(), other.getQuantidade());
            result = result
                     && equals(getSituacaoSolicitacao(),
                             other.getSituacaoSolicitacao());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoBloqueto(), other.getTipoBloqueto());
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
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataEnvioGrafica",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataLiberImpr",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataMovimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("envioBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("grafica", StringType.create(), false, true));
        properties.add(new Property("meioEntrada",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nossoNumero",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroPedido",
                LongType.create(),
                false,
                true));
        properties.add(new Property("quantidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("situacaoSolicitacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoBloqueto",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "BloquetoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("grafica", new StringValue("X(40)"));
        Mainframe.put("dataMovimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("situacaoSolicitacao", new LongValue("9(01)"));
        Mainframe.put("quantidade", new LongValue("9(08)"));
        Mainframe.put("envioBloqueto", new LongValue("9(01)"));
        Mainframe.put("tipoBloqueto", new LongValue("9(01)"));
        Mainframe.put("dataLiberImpr", new DateValue("dd.MM.yyyy"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("numeroPedido", new LongValue("9(10)"));
        Mainframe.put("dataEnvioGrafica", new DateValue("dd.MM.yyyy"));
        Mainframe.put("meioEntrada", new LongValue("9(02)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
