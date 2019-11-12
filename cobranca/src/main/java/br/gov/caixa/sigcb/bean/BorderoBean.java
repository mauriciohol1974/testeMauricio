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

public class BorderoBean extends SigcbBean {
    private java.lang.String aceite;

    private java.lang.String aceiteTexto;

    private java.lang.Long codigoBordero;

    private java.lang.Long codigoCedente;

    private java.util.Date dataMovimento;

    private java.lang.String distrCredito;

    private java.lang.Long emissaoBloqueto;

    private java.lang.String emissaoBloquetoTexto;

    private java.lang.String endosso;

    private java.lang.Long envioBloqueto;

    private java.lang.String envioBloquetoTexto;

    private java.lang.Long especieTitulo;

    private java.lang.String especieTituloTexto;

    private java.lang.Long modalidadeTitulo;

    private java.lang.Long moeda;

    private java.lang.String msgFichaCompensacao;

    private java.lang.String msgFichaCompensacaoL1;

    private java.lang.String msgFichaCompensacaoL2;

    private br.com.politec.sao.util.Percentual multaPercentual;

    private br.com.politec.sao.util.Money multaValor;

    private java.lang.Long navegacao;

    private br.com.politec.sao.util.Percentual percentualDesconto1;

    private br.com.politec.sao.util.Percentual percentualDesconto2;

    private br.com.politec.sao.util.Percentual percentualDesconto3;

    private br.com.politec.sao.util.Percentual percentualJurosDia;

    private java.util.Date prazoLimite1Data;

    private java.lang.Long prazoLimite1Dia;

    private java.util.Date prazoLimite2Data;

    private java.lang.Long prazoLimite2Dia;

    private java.util.Date prazoLimite3Data;

    private java.lang.Long prazoLimite3Dia;

    private java.util.Date prazoMultaData;

    private java.lang.Long prazoMultaDias;

    private java.lang.Long prazoProtDevol;

    private java.lang.String protestoAutomatico;

    private java.lang.Long quantidade;

    private java.lang.Long registro;

    private java.lang.Long situacao;

    private java.lang.String somenteProtesto;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoJurosDia;

    private java.lang.String tipoJurosDiaTexto;

    private br.com.politec.sao.util.Money valor;

    private br.com.politec.sao.util.Money valorDesconto1;

    private br.com.politec.sao.util.Money valorDesconto2;

    private br.com.politec.sao.util.Money valorDesconto3;

    private java.lang.Long vinculacaoPV;
    
    private String registrarSR;
    
    private String tipoDesconto;

    public BorderoBean() {
        this.aceite = null;
        this.aceiteTexto = null;
        this.codigoBordero = null;
        this.codigoCedente = null;
        this.dataMovimento = null;
        this.distrCredito = null;
        this.emissaoBloqueto = null;
        this.emissaoBloquetoTexto = null;
        this.endosso = null;
        this.envioBloqueto = null;
        this.envioBloquetoTexto = null;
        this.especieTitulo = null;
        this.especieTituloTexto = null;
        this.modalidadeTitulo = null;
        this.moeda = null;
        this.msgFichaCompensacao = null;
        this.msgFichaCompensacaoL1 = null;
        this.msgFichaCompensacaoL2 = null;
        this.multaPercentual = null;
        this.multaValor = null;
        this.navegacao = null;
        this.percentualDesconto1 = null;
        this.percentualDesconto2 = null;
        this.percentualDesconto3 = null;
        this.percentualJurosDia = null;
        this.prazoLimite1Data = null;
        this.prazoLimite1Dia = null;
        this.prazoLimite2Data = null;
        this.prazoLimite2Dia = null;
        this.prazoLimite3Data = null;
        this.prazoLimite3Dia = null;
        this.prazoMultaData = null;
        this.prazoMultaDias = null;
        this.prazoProtDevol = null;
        this.protestoAutomatico = null;
        this.quantidade = null;
        this.registro = null;
        this.situacao = null;
        this.somenteProtesto = null;
        this.tipoAcao = null;
        this.tipoJurosDia = null;
        this.tipoJurosDiaTexto = null;
        this.valor = null;
        this.valorDesconto1 = null;
        this.valorDesconto2 = null;
        this.valorDesconto3 = null;
        this.vinculacaoPV = null;
        this.registrarSR = null;
        this.tipoDesconto=null;
    }
    
    

    public String getTipoDesconto() {
		return tipoDesconto;
	}



	public void setTipoDesconto(String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}



	public String getApplicationName() {
        return "BorderoBean";
    }
    

    public String getRegistrarSR() {
		return registrarSR;
	}

	public void setRegistrarSR(String registrarSR) {
		this.registrarSR = registrarSR;
	}

	public java.lang.String getAceite() {
        return this.aceite;
    }

    public void setAceite(java.lang.String aceite) {
        this.aceite = aceite;
    }

    public java.lang.String getAceiteTexto() {
        return this.aceiteTexto;
    }

    public void setAceiteTexto(java.lang.String aceiteTexto) {
        this.aceiteTexto = aceiteTexto;
    }

    public java.lang.Long getCodigoBordero() {
        return this.codigoBordero;
    }

    public void setCodigoBordero(java.lang.Long codigoBordero) {
        this.codigoBordero = codigoBordero;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    // ------------------------DataMovimento----------------------------
    public java.util.Date getDataMovimento() {
        return this.dataMovimento;
    }

    public java.lang.String getDataMovimentoFormatada() {
        if (this.dataMovimento != null) {
            return Formatador.formatarData(this.dataMovimento);
        } else {
            return "";
        }
    }

    public void setDataMovimento(java.util.Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public java.lang.String getDistrCredito() {
        return this.distrCredito;
    }

    public void setDistrCredito(java.lang.String distrCredito) {
        this.distrCredito = distrCredito;
    }

    public java.lang.Long getEmissaoBloqueto() {
        return this.emissaoBloqueto;
    }

    public void setEmissaoBloqueto(java.lang.Long emissaoBloqueto) {
        this.emissaoBloqueto = emissaoBloqueto;
    }

    public java.lang.String getEmissaoBloquetoTexto() {
        return this.emissaoBloquetoTexto;
    }

    public void setEmissaoBloquetoTexto(java.lang.String emissaoBloquetoTexto) {
        this.emissaoBloquetoTexto = emissaoBloquetoTexto;
    }

    public java.lang.String getEndosso() {
        return this.endosso;
    }

    public void setEndosso(java.lang.String endosso) {
        this.endosso = endosso;
    }

    public java.lang.Long getEnvioBloqueto() {
        return this.envioBloqueto;
    }

    public void setEnvioBloqueto(java.lang.Long envioBloqueto) {
        this.envioBloqueto = envioBloqueto;
    }

    public java.lang.String getEnvioBloquetoTexto() {
        return this.envioBloquetoTexto;
    }

    public void setEnvioBloquetoTexto(java.lang.String envioBloquetoTexto) {
        this.envioBloquetoTexto = envioBloquetoTexto;
    }

    public java.lang.Long getEspecieTitulo() {
        return this.especieTitulo;
    }

    public void setEspecieTitulo(java.lang.Long especieTitulo) {
        this.especieTitulo = especieTitulo;
    }

    public java.lang.String getEspecieTituloTexto() {
        return this.especieTituloTexto;
    }

    public void setEspecieTituloTexto(java.lang.String especieTituloTexto) {
        this.especieTituloTexto = especieTituloTexto;
    }

    public java.lang.Long getModalidadeTitulo() {
        return this.modalidadeTitulo;
    }

    public java.lang.String getModalidadeTituloTexto() {
        String modalidadeTituloTexto = "";

        switch (getModalidadeTitulo().intValue()) {
        case 1:
            modalidadeTituloTexto = "REGISTRADO";
            break;
        case 2:
            modalidadeTituloTexto = "SEM REGISTRO";
            break;
        case 3:
            modalidadeTituloTexto = "COBRANCA CAUCIONADA";
            break;
        }
        return modalidadeTituloTexto;
    }

    public void setModalidadeTitulo(java.lang.Long modalidadeTitulo) {
        this.modalidadeTitulo = modalidadeTitulo;
    }

    // ------------------------Moeda---------------------------------------
    public java.lang.Long getMoeda() {
        return this.moeda;
    }

    public java.lang.String getMoedaTexto() {
        String moedaTexto = "";

        switch (getMoeda().intValue()) {
        case 9:
            moedaTexto = "REAL";
            break;
        }
        return moedaTexto;
    }

    public void setMoeda(java.lang.Long moeda) {
        this.moeda = moeda;
    }

    // --------------------------------------------------------------------
    public java.lang.String getMsgFichaCompensacao() {
        return this.msgFichaCompensacao;
    }

    public void setMsgFichaCompensacao(java.lang.String msgFichaCompensacao) {
        this.msgFichaCompensacao = msgFichaCompensacao;
    }

    public java.lang.String getMsgFichaCompensacaoL1() {
        return this.msgFichaCompensacaoL1;
    }

    public void setMsgFichaCompensacaoL1(java.lang.String msgFichaCompensacaoL1) {
        this.msgFichaCompensacaoL1 = msgFichaCompensacaoL1;
    }

    public java.lang.String getMsgFichaCompensacaoL2() {
        return this.msgFichaCompensacaoL2;
    }

    public void setMsgFichaCompensacaoL2(java.lang.String msgFichaCompensacaoL2) {
        this.msgFichaCompensacaoL2 = msgFichaCompensacaoL2;
    }

    public br.com.politec.sao.util.Percentual getMultaPercentual() {
        return this.multaPercentual;
    }

    public void setMultaPercentual(br.com.politec.sao.util.Percentual multaPercentual) {
        this.multaPercentual = multaPercentual;
    }

    public br.com.politec.sao.util.Money getMultaValor() {
        return this.multaValor;
    }

    public void setMultaValor(br.com.politec.sao.util.Money multaValor) {
        this.multaValor = multaValor;
    }

    public java.lang.Long getNavegacao() {
        return this.navegacao;
    }

    public void setNavegacao(java.lang.Long navegacao) {
        this.navegacao = navegacao;
    }

    public br.com.politec.sao.util.Percentual getPercentualDesconto1() {
        return this.percentualDesconto1;
    }

    public void setPercentualDesconto1(br.com.politec.sao.util.Percentual percentualDesconto1) {
        this.percentualDesconto1 = percentualDesconto1;
    }

    public br.com.politec.sao.util.Percentual getPercentualDesconto2() {
        return this.percentualDesconto2;
    }

    public void setPercentualDesconto2(br.com.politec.sao.util.Percentual percentualDesconto2) {
        this.percentualDesconto2 = percentualDesconto2;
    }

    public br.com.politec.sao.util.Percentual getPercentualDesconto3() {
        return this.percentualDesconto3;
    }

    public void setPercentualDesconto3(br.com.politec.sao.util.Percentual percentualDesconto3) {
        this.percentualDesconto3 = percentualDesconto3;
    }

    public br.com.politec.sao.util.Percentual getPercentualJurosDia() {
        return this.percentualJurosDia;
    }

    public void setPercentualJurosDia(br.com.politec.sao.util.Percentual percentualJurosDia) {
        this.percentualJurosDia = percentualJurosDia;
    }

    // ------------------------PrazoLimite1Data----------------------------
    public java.util.Date getPrazoLimite1Data() {
        return this.prazoLimite1Data;
    }

    public java.lang.String getPrazoLimite1DataFormatada() {
        if (this.prazoLimite1Data != null) {
            return Formatador.formatarData(this.prazoLimite1Data);
        } else {
            return "";
        }
    }

    public void setPrazoLimite1Data(java.util.Date prazoLimite1Data) {
        this.prazoLimite1Data = prazoLimite1Data;
    }

    // --------------------------------------------------------------------
    public java.lang.Long getPrazoLimite1Dia() {
        return this.prazoLimite1Dia;
    }

    public void setPrazoLimite1Dia(java.lang.Long prazoLimite1Dia) {
        this.prazoLimite1Dia = prazoLimite1Dia;
    }

    // ------------------------PrazoLimite2Data----------------------------
    public java.util.Date getPrazoLimite2Data() {
        return this.prazoLimite2Data;
    }

    public java.lang.String getPrazoLimite2DataFormatada() {
        if (this.prazoLimite2Data != null) {
            return Formatador.formatarData(this.prazoLimite2Data);
        } else {
            return "";
        }
    }

    public void setPrazoLimite2Data(java.util.Date prazoLimite2Data) {
        this.prazoLimite2Data = prazoLimite2Data;
    }

    // --------------------------------------------------------------------
    public java.lang.Long getPrazoLimite2Dia() {
        return this.prazoLimite2Dia;
    }

    public void setPrazoLimite2Dia(java.lang.Long prazoLimite2Dia) {
        this.prazoLimite2Dia = prazoLimite2Dia;
    }

    // ------------------------PrazoLimite3Data----------------------------
    public java.util.Date getPrazoLimite3Data() {
        return this.prazoLimite3Data;
    }

    public java.lang.String getPrazoLimite3DataFormatada() {
        if (this.prazoLimite3Data != null) {
            return Formatador.formatarData(this.prazoLimite3Data);
        } else {
            return "";
        }
    }

    public void setPrazoLimite3Data(java.util.Date prazoLimite3Data) {
        this.prazoLimite3Data = prazoLimite3Data;
    }

    // --------------------------------------------------------------------
    public java.lang.Long getPrazoLimite3Dia() {
        return this.prazoLimite3Dia;
    }

    public void setPrazoLimite3Dia(java.lang.Long prazoLimite3Dia) {
        this.prazoLimite3Dia = prazoLimite3Dia;
    }

    // ------------------------PrazoMultaData----------------------------
    public java.util.Date getPrazoMultaData() {
        return this.prazoMultaData;
    }

    public java.lang.String getPrazoMultaDataFormatada() {
        if (this.prazoMultaData != null) {
            return Formatador.formatarData(this.prazoMultaData);
        } else {
            return "";
        }
    }

    public void setPrazoMultaData(java.util.Date prazoMultaData) {
        this.prazoMultaData = prazoMultaData;
    }

    // --------------------------------------------------------------------
    public java.lang.Long getPrazoMultaDias() {
        return this.prazoMultaDias;
    }

    public void setPrazoMultaDias(java.lang.Long prazoMultaDias) {
        this.prazoMultaDias = prazoMultaDias;
    }

    public java.lang.Long getPrazoProtDevol() {
        return this.prazoProtDevol;
    }

    public void setPrazoProtDevol(java.lang.Long prazoProtDevol) {
        this.prazoProtDevol = prazoProtDevol;
    }

    public java.lang.String getProtestoAutomatico() {
        return this.protestoAutomatico;
    }

    public void setProtestoAutomatico(java.lang.String protestoAutomatico) {
        this.protestoAutomatico = protestoAutomatico;
    }

    public java.lang.Long getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(java.lang.Long quantidade) {
        this.quantidade = quantidade;
    }

    public java.lang.Long getRegistro() {
        return this.registro;
    }

    public void setRegistro(java.lang.Long registro) {
        this.registro = registro;
    }

    // ------------------------Situacao----------------------------
    public java.lang.Long getSituacao() {
        return this.situacao;
    }

    public java.lang.String getSituacaoTexto() {
        String situacaoTexto = "";
        if (this.getSituacao().equals(new Long(1))) {
            situacaoTexto = "EM ABERTO";
        } else if (this.getSituacao().equals(new Long(2))) {
            situacaoTexto = "FINALIZADO";
        } else {
            situacaoTexto = "";
        }
        return situacaoTexto;
    }

    public void setSituacao(java.lang.Long situacao) {
        this.situacao = situacao;
    }

    // --------------------------------------------------------------------
    public java.lang.String getSomenteProtesto() {
        return this.somenteProtesto;
    }

    public void setSomenteProtesto(java.lang.String somenteProtesto) {
        this.somenteProtesto = somenteProtesto;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoJurosDia() {
        return this.tipoJurosDia;
    }

    public void setTipoJurosDia(java.lang.Long tipoJurosDia) {
        this.tipoJurosDia = tipoJurosDia;
    }

    public java.lang.String getTipoJurosDiaTexto() {
        return this.tipoJurosDiaTexto;
    }

    public void setTipoJurosDiaTexto(java.lang.String tipoJurosDiaTexto) {
        this.tipoJurosDiaTexto = tipoJurosDiaTexto;
    }

    public br.com.politec.sao.util.Money getValor() {
        return this.valor;
    }

    public void setValor(br.com.politec.sao.util.Money valor) {
        this.valor = valor;
    }

    public br.com.politec.sao.util.Money getValorDesconto1() {
        return this.valorDesconto1;
    }

    public void setValorDesconto1(br.com.politec.sao.util.Money valorDesconto1) {
        this.valorDesconto1 = valorDesconto1;
    }

    public br.com.politec.sao.util.Money getValorDesconto2() {
        return this.valorDesconto2;
    }

    public void setValorDesconto2(br.com.politec.sao.util.Money valorDesconto2) {
        this.valorDesconto2 = valorDesconto2;
    }

    public br.com.politec.sao.util.Money getValorDesconto3() {
        return this.valorDesconto3;
    }

    public void setValorDesconto3(br.com.politec.sao.util.Money valorDesconto3) {
        this.valorDesconto3 = valorDesconto3;
    }

    public java.lang.Long getVinculacaoPV() {
        return this.vinculacaoPV;
    }

    public void setVinculacaoPV(java.lang.Long vinculacaoPV) {
        this.vinculacaoPV = vinculacaoPV;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getVinculacaoPVFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.vinculacaoPV);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            BorderoBean other = (BorderoBean) obj;
            result = result && equals(getAceite(), other.getAceite());
            result = result && equals(getAceiteTexto(), other.getAceiteTexto());
            result = result
                     && equals(getCodigoBordero(), other.getCodigoBordero());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getDataMovimento(), other.getDataMovimento());
            result = result
                     && equals(getDistrCredito(), other.getDistrCredito());
            result = result
                     && equals(getEmissaoBloqueto(), other.getEmissaoBloqueto());
            result = result
                     && equals(getEmissaoBloquetoTexto(),
                             other.getEmissaoBloquetoTexto());
            result = result && equals(getEndosso(), other.getEndosso());
            result = result
                     && equals(getEnvioBloqueto(), other.getEnvioBloqueto());
            result = result
                     && equals(getEnvioBloquetoTexto(),
                             other.getEnvioBloquetoTexto());
            result = result
                     && equals(getEspecieTitulo(), other.getEspecieTitulo());
            result = result
                     && equals(getEspecieTituloTexto(),
                             other.getEspecieTituloTexto());
            result = result
                     && equals(getModalidadeTitulo(),
                             other.getModalidadeTitulo());
            result = result && equals(getMoeda(), other.getMoeda());
            result = result
                     && equals(getMsgFichaCompensacao(),
                             other.getMsgFichaCompensacao());
            result = result
                     && equals(getMsgFichaCompensacaoL1(),
                             other.getMsgFichaCompensacaoL1());
            result = result
                     && equals(getMsgFichaCompensacaoL2(),
                             other.getMsgFichaCompensacaoL2());
            result = result
                     && equals(getMultaPercentual(), other.getMultaPercentual());
            result = result && equals(getMultaValor(), other.getMultaValor());
            result = result && equals(getNavegacao(), other.getNavegacao());
            result = result
                     && equals(getPercentualDesconto1(),
                             other.getPercentualDesconto1());
            result = result
                     && equals(getPercentualDesconto2(),
                             other.getPercentualDesconto2());
            result = result
                     && equals(getPercentualDesconto3(),
                             other.getPercentualDesconto3());
            result = result
                     && equals(getPercentualJurosDia(),
                             other.getPercentualJurosDia());
            result = result
                     && equals(getPrazoLimite1Data(),
                             other.getPrazoLimite1Data());
            result = result
                     && equals(getPrazoLimite1Dia(), other.getPrazoLimite1Dia());
            result = result
                     && equals(getPrazoLimite2Data(),
                             other.getPrazoLimite2Data());
            result = result
                     && equals(getPrazoLimite2Dia(), other.getPrazoLimite2Dia());
            result = result
                     && equals(getPrazoLimite3Data(),
                             other.getPrazoLimite3Data());
            result = result
                     && equals(getPrazoLimite3Dia(), other.getPrazoLimite3Dia());
            result = result
                     && equals(getPrazoMultaData(), other.getPrazoMultaData());
            result = result
                     && equals(getPrazoMultaDias(), other.getPrazoMultaDias());
            result = result
                     && equals(getPrazoProtDevol(), other.getPrazoProtDevol());
            result = result
                     && equals(getProtestoAutomatico(),
                             other.getProtestoAutomatico());
            result = result && equals(getQuantidade(), other.getQuantidade());
            result = result && equals(getRegistro(), other.getRegistro());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result
                     && equals(getSomenteProtesto(), other.getSomenteProtesto());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoJurosDia(), other.getTipoJurosDia());
            result = result
                     && equals(getTipoJurosDiaTexto(),
                             other.getTipoJurosDiaTexto());
            result = result && equals(getValor(), other.getValor());
            result = result
                     && equals(getValorDesconto1(), other.getValorDesconto1());
            result = result
                     && equals(getValorDesconto2(), other.getValorDesconto2());
            result = result
                     && equals(getValorDesconto3(), other.getValorDesconto3());
            result = result
                     && equals(getVinculacaoPV(), other.getVinculacaoPV());
            
            result = result && equals(getRegistrarSR(), other.getRegistrarSR());
            result = result && equals(getTipoDesconto(), other.getTipoDesconto());
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
        properties.add(new Property("aceite", StringType.create(), false, true));
        properties.add(new Property("aceiteTexto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoBordero",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dataMovimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("distrCredito",
                StringType.create(),
                false,
                true));
        properties.add(new Property("emissaoBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("emissaoBloquetoTexto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("endosso", StringType.create(), false, true));
        properties.add(new Property("envioBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("envioBloquetoTexto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("especieTitulo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("especieTituloTexto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("modalidadeTitulo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("moeda", LongType.create(), false, true));
        properties.add(new Property("msgFichaCompensacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("msgFichaCompensacaoL1",
                StringType.create(),
                false,
                true));
        properties.add(new Property("msgFichaCompensacaoL2",
                StringType.create(),
                false,
                true));
        properties.add(new Property("multaPercentual",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("multaValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("navegacao", LongType.create(), false, true));
        properties.add(new Property("percentualDesconto1",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("percentualDesconto2",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("percentualDesconto3",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("percentualJurosDia",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("prazoLimite1Data",
                DateType.create(),
                false,
                true));
        properties.add(new Property("prazoLimite1Dia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoLimite2Data",
                DateType.create(),
                false,
                true));
        properties.add(new Property("prazoLimite2Dia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoLimite3Data",
                DateType.create(),
                false,
                true));
        properties.add(new Property("prazoLimite3Dia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoMultaData",
                DateType.create(),
                false,
                true));
        properties.add(new Property("prazoMultaDias",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoProtDevol",
                LongType.create(),
                false,
                true));
        properties.add(new Property("protestoAutomatico",
                StringType.create(),
                false,
                true));
        properties.add(new Property("quantidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("registro", LongType.create(), false, true));
        properties.add(new Property("situacao", LongType.create(), false, true));
        properties.add(new Property("somenteProtesto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoJurosDia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoJurosDiaTexto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("valor", MoneyType.create(), false, true));
        properties.add(new Property("valorDesconto1",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorDesconto2",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorDesconto3",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("vinculacaoPV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("registrarSR",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoDesconto",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "BorderoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("modalidadeTitulo", new LongValue("9(02)"));
        Mainframe.put("aceiteTexto", new StringValue("X(40)"));
        Mainframe.put("prazoLimite3Dia", new LongValue("9(03)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("distrCredito", new StringValue("X(01)"));
        Mainframe.put("prazoProtDevol", new LongValue("9(03)"));
        Mainframe.put("protestoAutomatico", new StringValue("X(01)"));
        Mainframe.put("endosso", new StringValue("X(01)"));
        Mainframe.put("navegacao", new LongValue("9(01)"));
        Mainframe.put("valorDesconto3", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorDesconto2", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorDesconto1", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("prazoLimite3Data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("prazoLimite1Dia", new LongValue("9(03)"));
        Mainframe.put("aceite", new StringValue("X(01)"));
        Mainframe.put("emissaoBloquetoTexto", new StringValue("X(40)"));
        Mainframe.put("moeda", new LongValue("9(02)"));
        Mainframe.put("quantidade", new LongValue("9(02)"));
        Mainframe.put("somenteProtesto", new StringValue("X(01)"));
        Mainframe.put("codigoBordero", new LongValue("9(07)"));
        Mainframe.put("tipoJurosDia", new LongValue("9(01)"));
        Mainframe.put("especieTitulo", new LongValue("9(02)"));
        Mainframe.put("prazoMultaData", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("emissaoBloqueto", new LongValue("9(02)"));
        Mainframe.put("prazoLimite2Data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("multaValor", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("situacao", new LongValue("9(01)"));
        Mainframe.put("prazoMultaDias", new LongValue("9(03)"));
        Mainframe.put("especieTituloTexto", new StringValue("X(40)"));
        Mainframe.put("multaPercentual", new PercentualValue("9(05)"));
        Mainframe.put("msgFichaCompensacaoL2", new StringValue("X(40)"));
        Mainframe.put("msgFichaCompensacaoL1", new StringValue("X(40)"));
        Mainframe.put("tipoJurosDiaTexto", new StringValue("X(40)"));
        Mainframe.put("prazoLimite2Dia", new LongValue("9(03)"));
        Mainframe.put("envioBloqueto", new LongValue("9(02)"));
        Mainframe.put("vinculacaoPV", new LongValue("9(04)"));
        Mainframe.put("envioBloquetoTexto", new StringValue("X(40)"));
        Mainframe.put("percentualDesconto3", new PercentualValue("9(05)"));
        Mainframe.put("percentualDesconto2", new PercentualValue("9(05)"));
        Mainframe.put("percentualJurosDia", new PercentualValue("9(05)"));
        Mainframe.put("percentualDesconto1", new PercentualValue("9(05)"));
        Mainframe.put("prazoLimite1Data", new DateValue("dd.MM.yyyy"));
        Mainframe.put("msgFichaCompensacao", new StringValue("X(80)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("registro", new LongValue("9(04)"));
        Mainframe.put("dataMovimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("registrarSR", new StringValue("X(01)"));
        Mainframe.put("tipoDesconto", new StringValue("X(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
