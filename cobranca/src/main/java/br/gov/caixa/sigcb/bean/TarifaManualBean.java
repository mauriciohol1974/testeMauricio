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

public class TarifaManualBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.String codigoUsuario;

    private java.util.Date dataDebito;

    private java.util.Date dataSolicitacao;

    private java.lang.String horaSolicitacao;

    private java.lang.String justificativa;

    private java.lang.Long registro;
    
    private java.lang.Long tipoTarifa;
    
    private java.lang.String descricaoTarifa;

    private br.com.politec.sao.util.Money valorTarifa;
    
    public TarifaManualBean() {
        this.codigoCedente = null;
        this.codigoUsuario = null;
        this.dataDebito = null;
        this.dataSolicitacao = null;
        this.horaSolicitacao = null;
        this.justificativa = null;
        this.registro = null;
        this.valorTarifa = null;
        this.tipoTarifa = null;
        this.descricaoTarifa = null;
    }

    public String getApplicationName() {
        return "TarifaManualBean";
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

    public java.util.Date getDataDebito() {
        return this.dataDebito;
    }

    public void setDataDebito(java.util.Date dataDebito) {
        this.dataDebito = dataDebito;
    }

    public java.util.Date getDataSolicitacao() {
        return this.dataSolicitacao;
    }

    public void setDataSolicitacao(java.util.Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public java.lang.String getHoraSolicitacao() {
        return this.horaSolicitacao;
    }

    public void setHoraSolicitacao(java.lang.String horaSolicitacao) {
        this.horaSolicitacao = horaSolicitacao;
    }

    public java.lang.String getJustificativa() {
        return this.justificativa;
    }

    public void setJustificativa(java.lang.String justificativa) {
        this.justificativa = justificativa;
    }

    public java.lang.Long getRegistro() {
        return this.registro;
    }

    public void setRegistro(java.lang.Long registro) {
        this.registro = registro;
    }
    
    public java.lang.Long getTipoTarifa() {
    	return this.tipoTarifa;
    }
    
    public void setTipoTarifa(java.lang.Long tipoTarifa) {
    	this.tipoTarifa = tipoTarifa;
    }
    
    public java.lang.String getDescricaoTarifa() {
    	return this.descricaoTarifa;
    }
    
    public void setDescricaoTarifa(java.lang.String descricaoTarifa) {
    	this.descricaoTarifa = descricaoTarifa;
    }

    public br.com.politec.sao.util.Money getValorTarifa() {
        return this.valorTarifa;
    }

    public void setValorTarifa(br.com.politec.sao.util.Money valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    // daqui
    public java.lang.String getDataDebitoFormatada() {
        if (this.dataDebito != null) {
            return Formatador.formatarData(this.dataDebito);
        } else {
            return "";
        }
    }

    public java.lang.String getDataSolicitacaoFormatada() {
        if (this.dataSolicitacao != null) {
            return Formatador.formatarData(this.dataSolicitacao);
        } else {
            return "";
        }
    }

    public java.lang.String getJustificativaFormatada() {
        if (this.justificativa != null) {
            return Formatador.formatarTextoComBarraEne(this.justificativa, 50);
        } else {
            return "";
        }
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // atedaqui

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            TarifaManualBean other = (TarifaManualBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getDataDebito(), other.getDataDebito());
            result = result
                     && equals(getDataSolicitacao(), other.getDataSolicitacao());
            result = result
                     && equals(getHoraSolicitacao(), other.getHoraSolicitacao());
            result = result
                     && equals(getJustificativa(), other.getJustificativa());
            result = result && equals(getRegistro(), other.getRegistro());
            result = result && equals(getValorTarifa(), other.getValorTarifa());
            result = result && equals(getTipoTarifa(), other.getTipoTarifa());
            result = result && equals(getDescricaoTarifa(), other.getDescricaoTarifa());
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
        properties.add(new Property("dataDebito",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataSolicitacao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("horaSolicitacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("justificativa",
                StringType.create(),
                false,
                true));
        properties.add(new Property("registro", LongType.create(), false, true));
        properties.add(new Property("tipoTarifa", LongType.create(), false, true));
        properties.add(new Property("descricaoTarifa", StringType.create(), false, true));
        properties.add(new Property("valorTarifa",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "TarifaManualBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("registro", new LongValue("9(04)"));
        Mainframe.put("tipoTarifa", new LongValue("9(02)"));
        Mainframe.put("descricaoSituacao", new StringValue("X(40)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("valorTarifa", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("dataDebito", new DateValue("dd.MM.yyyy"));
        Mainframe.put("justificativa", new StringValue("X(100)"));
        Mainframe.put("horaSolicitacao", new StringValue("X(08)"));
        Mainframe.put("dataSolicitacao", new DateValue("dd.MM.yyyy"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
