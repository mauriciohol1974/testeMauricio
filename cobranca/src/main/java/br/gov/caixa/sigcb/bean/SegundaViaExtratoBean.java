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

public class SegundaViaExtratoBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.util.Date dataFim;

    private java.util.Date dataFimDisponivel;

    private java.util.Date dataInicio;

    private java.util.Date dataInicioDisponivel;

    private java.util.Date dataSolicitacao;

    private java.lang.Long entrega;

    private java.lang.Long meioEntrada;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoExtrato;

    private java.lang.String usuario;

    public SegundaViaExtratoBean() {
        this.codigoCedente = null;
        this.dataFim = null;
        this.dataFimDisponivel = null;
        this.dataInicio = null;
        this.dataInicioDisponivel = null;
        this.dataSolicitacao = null;
        this.entrega = null;
        this.meioEntrada = null;
        this.tipoAcao = null;
        this.tipoExtrato = null;
        this.usuario = null;
    }

    public String getApplicationName() {
        return "SegundaViaExtratoBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.util.Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(java.util.Date dataFim) {
        this.dataFim = dataFim;
    }

    public java.util.Date getDataFimDisponivel() {
        return this.dataFimDisponivel;
    }

    public void setDataFimDisponivel(java.util.Date dataFimDisponivel) {
        this.dataFimDisponivel = dataFimDisponivel;
    }

    public java.util.Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(java.util.Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public java.util.Date getDataInicioDisponivel() {
        return this.dataInicioDisponivel;
    }

    public void setDataInicioDisponivel(java.util.Date dataInicioDisponivel) {
        this.dataInicioDisponivel = dataInicioDisponivel;
    }

    public java.util.Date getDataSolicitacao() {
        return this.dataSolicitacao;
    }

    public void setDataSolicitacao(java.util.Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public java.lang.Long getEntrega() {
        return this.entrega;
    }

    public void setEntrega(java.lang.Long entrega) {
        this.entrega = entrega;
    }

    public java.lang.Long getMeioEntrada() {
        return this.meioEntrada;
    }

    public void setMeioEntrada(java.lang.Long meioEntrada) {
        this.meioEntrada = meioEntrada;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoExtrato() {
        return this.tipoExtrato;
    }

    public void setTipoExtrato(java.lang.Long tipoExtrato) {
        this.tipoExtrato = tipoExtrato;
    }

    public java.lang.String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
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
            SegundaViaExtratoBean other = (SegundaViaExtratoBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getDataFim(), other.getDataFim());
            result = result
                     && equals(getDataFimDisponivel(),
                             other.getDataFimDisponivel());
            result = result && equals(getDataInicio(), other.getDataInicio());
            result = result
                     && equals(getDataInicioDisponivel(),
                             other.getDataInicioDisponivel());
            result = result
                     && equals(getDataSolicitacao(), other.getDataSolicitacao());
            result = result && equals(getEntrega(), other.getEntrega());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result && equals(getTipoExtrato(), other.getTipoExtrato());
            result = result && equals(getUsuario(), other.getUsuario());
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
        properties.add(new Property("dataFim", DateType.create(), false, true));
        properties.add(new Property("dataFimDisponivel",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataInicio",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataInicioDisponivel",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataSolicitacao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("entrega", LongType.create(), false, true));
        properties.add(new Property("meioEntrada",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoExtrato",
                LongType.create(),
                false,
                true));
        properties.add(new Property("usuario", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "SegundaViaExtratoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("dataSolicitacao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("dataInicio", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataFim", new DateValue("dd.MM.yyyy"));
        Mainframe.put("usuario", new StringValue("X(08)"));
        Mainframe.put("dataInicioDisponivel", new DateValue("dd.MM.yyyy"));
        Mainframe.put("tipoExtrato", new LongValue("9(03)"));
        Mainframe.put("entrega", new LongValue("9(02)"));
        Mainframe.put("dataFimDisponivel", new DateValue("dd.MM.yyyy"));
        Mainframe.put("meioEntrada", new LongValue("9(02)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
