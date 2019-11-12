package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteManterFiltroBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidade;

    private java.lang.Long cpfCnpj;

    private java.lang.Long radioTipoConsulta;

    private java.lang.Long radioTipoConsultaAnterior;

    private java.lang.String situacao;

    private java.lang.Long tipoPessoa;

    private java.lang.Long tipoUnidade;
    
    private String retornoPEC;

    public CedenteManterFiltroBean() {
        this.codigoCedente = null;
        this.codigoUnidade = null;
        this.cpfCnpj = null;
        this.radioTipoConsulta = null;
        this.radioTipoConsultaAnterior = null;
        this.situacao = null;
        this.tipoPessoa = null;
        this.tipoUnidade = null;
        this.retornoPEC=null;
    }

    public String getApplicationName() {
        return "CedenteManterFiltroBean";
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

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.lang.Long getRadioTipoConsulta() {
        return this.radioTipoConsulta;
    }

    public void setRadioTipoConsulta(java.lang.Long radioTipoConsulta) {
        this.radioTipoConsulta = radioTipoConsulta;
    }

    public java.lang.Long getRadioTipoConsultaAnterior() {
        return this.radioTipoConsultaAnterior;
    }

    public void setRadioTipoConsultaAnterior(java.lang.Long radioTipoConsultaAnterior) {
        this.radioTipoConsultaAnterior = radioTipoConsultaAnterior;
    }

    public java.lang.String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(java.lang.String situacao) {
        this.situacao = situacao;
    }

    public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public java.lang.Long getTipoUnidade() {
        return this.tipoUnidade;
    }

    public void setTipoUnidade(java.lang.Long tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }
    
    

    public String getRetornoPEC() {
		return retornoPEC;
	}

	public void setRetornoPEC(String retornoPEC) {
		this.retornoPEC = retornoPEC;
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
            CedenteManterFiltroBean other = (CedenteManterFiltroBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidade(), other.getCodigoUnidade());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result
                     && equals(getRadioTipoConsulta(),
                             other.getRadioTipoConsulta());
            result = result
                     && equals(getRadioTipoConsultaAnterior(),
                             other.getRadioTipoConsultaAnterior());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result && equals(getTipoUnidade(), other.getTipoUnidade());
            result = result && equals(getRetornoPEC(), other.getRetornoPEC());
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
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("radioTipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("radioTipoConsultaAnterior",
                LongType.create(),
                false,
                true));
        properties.add(new Property("situacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("retornoPEC",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoUnidade",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedenteManterFiltroBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("radioTipoConsulta", new LongValue("9(01)"));
        Mainframe.put("situacao", new StringValue("X(01)"));
        Mainframe.put("radioTipoConsultaAnterior", new LongValue("9(01)"));
        Mainframe.put("codigoUnidade", new LongValue("9(04)"));
        Mainframe.put("tipoUnidade", new LongValue("9(01)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
