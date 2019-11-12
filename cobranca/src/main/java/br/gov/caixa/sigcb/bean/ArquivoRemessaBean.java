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

public class ArquivoRemessaBean extends SigcbBean {
    private java.lang.String apelidoCedente;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoErro;

    private java.lang.Long codigoUnidadePV;
    
    private java.lang.Long codigoUnidadeCentral;

    private java.lang.String codigoUsuario;

    private java.util.Date dataArquivo;

    private java.util.Date dataFinal;

    private java.util.Date dataInicial;

    private java.lang.String descricaoErro;

    private java.lang.String descricaoVAN;

    private java.lang.String horaArquivo;

    private java.lang.String nomeCedente;

    private java.lang.String nomeUnidadePV;

    private java.lang.Long numRegistroErro;

    private java.lang.Long numRemessaRetorno;

    private java.lang.Long numeroProxRemessa;

    private java.lang.Long numeroUltRetorno;

    private java.lang.String observacao;

    private java.lang.String opcaoConsulta;

    private java.lang.Long padrao;

    private java.lang.Long quantidadeRegistros;

    private java.lang.String situacao;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoArquivo;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoSolicitacao;
    
    private String dataEnvioReenvio;
    
    private String cpfCnpj;
    


    public ArquivoRemessaBean() {
        this.apelidoCedente = null;
        this.codigoCedente = null;
        this.codigoErro = null;
        this.codigoUnidadePV = null;
        this.codigoUnidadeCentral = null;
        this.codigoUsuario = null;
        this.dataArquivo = null;
        this.dataFinal = null;
        this.dataInicial = null;
        this.descricaoErro = null;
        this.descricaoVAN = null;
        this.horaArquivo = null;
        this.nomeCedente = null;
        this.nomeUnidadePV = null;
        this.numRegistroErro = null;
        this.numRemessaRetorno = null;
        this.numeroProxRemessa = null;
        this.numeroUltRetorno = null;
        this.observacao = null;
        this.opcaoConsulta = null;
        this.padrao = null;
        this.quantidadeRegistros = null;
        this.situacao = null;
        this.tipoAcao = null;
        this.tipoArquivo = null;
        this.tipoConsulta = null;
        this.tipoSolicitacao = null;
        this.dataEnvioReenvio = null;
        this.cpfCnpj = null;
       
    }

    public String getApplicationName() {
        return "ArquivoRemessaBean";
    }

    public java.lang.String getApelidoCedente() {
        return this.apelidoCedente;
    }

    public void setApelidoCedente(java.lang.String apelidoCedente) {
        this.apelidoCedente = apelidoCedente;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoErro() {
        return this.codigoErro;
    }

    public void setCodigoErro(java.lang.Long codigoErro) {
        this.codigoErro = codigoErro;
    }

    public java.lang.Long getCodigoUnidadePV() {
        return this.codigoUnidadePV;
    }

    public void setCodigoUnidadePV(java.lang.Long codigoUnidadePV) {
        this.codigoUnidadePV = codigoUnidadePV;
    }
    
    public java.lang.Long getCodigoUnidadeCentral() {
        return this.codigoUnidadeCentral;
    }

    public void setCodigoUnidadeCentral(java.lang.Long codigoUnidadeCentral) {
        this.codigoUnidadeCentral = codigoUnidadeCentral;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.util.Date getDataArquivo() {
        return this.dataArquivo;
    }

    public void setDataArquivo(java.util.Date dataArquivo) {
        this.dataArquivo = dataArquivo;
    }

    public java.util.Date getDataFinal() {
        return this.dataFinal;
    }

    public void setDataFinal(java.util.Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public java.util.Date getDataInicial() {
        return this.dataInicial;
    }

    public void setDataInicial(java.util.Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public java.lang.String getDescricaoErro() {
        return this.descricaoErro;
    }

    public void setDescricaoErro(java.lang.String descricaoErro) {
        this.descricaoErro = descricaoErro;
    }

    public java.lang.String getDescricaoVAN() {
        return this.descricaoVAN;
    }

    public void setDescricaoVAN(java.lang.String descricaoVAN) {
        this.descricaoVAN = descricaoVAN;
    }

    public java.lang.String getHoraArquivo() {
        return this.horaArquivo;
    }

    public void setHoraArquivo(java.lang.String horaArquivo) {
        this.horaArquivo = horaArquivo;
    }

    public java.lang.String getNomeCedente() {
        return this.nomeCedente;
    }

    public void setNomeCedente(java.lang.String nomeCedente) {
        this.nomeCedente = nomeCedente;
    }

    public java.lang.String getNomeUnidadePV() {
        return this.nomeUnidadePV;
    }

    public void setNomeUnidadePV(java.lang.String nomeUnidadePV) {
        this.nomeUnidadePV = nomeUnidadePV;
    }

    public java.lang.Long getNumRegistroErro() {
        return this.numRegistroErro;
    }

    public void setNumRegistroErro(java.lang.Long numRegistroErro) {
        this.numRegistroErro = numRegistroErro;
    }

    public java.lang.Long getNumRemessaRetorno() {
        return this.numRemessaRetorno;
    }

    public void setNumRemessaRetorno(java.lang.Long numRemessaRetorno) {
        this.numRemessaRetorno = numRemessaRetorno;
    }

    public java.lang.Long getNumeroProxRemessa() {
        return this.numeroProxRemessa;
    }

    public void setNumeroProxRemessa(java.lang.Long numeroProxRemessa) {
        this.numeroProxRemessa = numeroProxRemessa;
    }

    public java.lang.Long getNumeroUltRetorno() {
        return this.numeroUltRetorno;
    }

    public void setNumeroUltRetorno(java.lang.Long numeroUltRetorno) {
        this.numeroUltRetorno = numeroUltRetorno;
    }

    public java.lang.String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(java.lang.String observacao) {
        this.observacao = observacao;
    }

    public java.lang.String getOpcaoConsulta() {
        return this.opcaoConsulta;
    }

    public void setOpcaoConsulta(java.lang.String opcaoConsulta) {
        this.opcaoConsulta = opcaoConsulta;
    }

    public java.lang.Long getPadrao() {
        return this.padrao;
    }

    public void setPadrao(java.lang.Long padrao) {
        this.padrao = padrao;
    }

    public java.lang.Long getQuantidadeRegistros() {
        return this.quantidadeRegistros;
    }

    public void setQuantidadeRegistros(java.lang.Long quantidadeRegistros) {
        this.quantidadeRegistros = quantidadeRegistros;
    }

    public java.lang.String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(java.lang.String situacao) {
        this.situacao = situacao;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoArquivo() {
        return this.tipoArquivo;
    }

    public void setTipoArquivo(java.lang.Long tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public java.lang.Long getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.Long tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public java.lang.Long getTipoSolicitacao() {
        return this.tipoSolicitacao;
    }

    public void setTipoSolicitacao(java.lang.Long tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }



	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getDataEnvioReenvio() {
		return dataEnvioReenvio;
	}

	public void setDataEnvioReenvio(String dataEnvioReenvio) {
		this.dataEnvioReenvio = dataEnvioReenvio;
	}

	// ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadePVFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePV);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ArquivoRemessaBean other = (ArquivoRemessaBean) obj;
            result = result
                     && equals(getApelidoCedente(), other.getApelidoCedente());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getCodigoErro(), other.getCodigoErro());
            result = result
                     && equals(getCodigoUnidadePV(), other.getCodigoUnidadePV());
            result = result
            && equals(getCodigoUnidadeCentral(), other.getCodigoUnidadeCentral());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getDataArquivo(), other.getDataArquivo());
            result = result && equals(getDataFinal(), other.getDataFinal());
            result = result && equals(getDataInicial(), other.getDataInicial());
            result = result
                     && equals(getDescricaoErro(), other.getDescricaoErro());
            result = result
                     && equals(getDescricaoVAN(), other.getDescricaoVAN());
            result = result && equals(getHoraArquivo(), other.getHoraArquivo());
            result = result && equals(getNomeCedente(), other.getNomeCedente());
            result = result
                     && equals(getNomeUnidadePV(), other.getNomeUnidadePV());
            result = result
                     && equals(getNumRegistroErro(), other.getNumRegistroErro());
            result = result
                     && equals(getNumRemessaRetorno(),
                             other.getNumRemessaRetorno());
            result = result
                     && equals(getNumeroProxRemessa(),
                             other.getNumeroProxRemessa());
            result = result
                     && equals(getNumeroUltRetorno(),
                             other.getNumeroUltRetorno());
            result = result && equals(getObservacao(), other.getObservacao());
            result = result
                     && equals(getOpcaoConsulta(), other.getOpcaoConsulta());
            result = result && equals(getPadrao(), other.getPadrao());
            result = result
                     && equals(getQuantidadeRegistros(),
                             other.getQuantidadeRegistros());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result && equals(getTipoArquivo(), other.getTipoArquivo());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result
                     && equals(getTipoSolicitacao(), other.getTipoSolicitacao());
            result = result
                    && equals(getDataEnvioReenvio(), other.getDataEnvioReenvio());

            result = result  && equals(getCpfCnpj(), other.getCpfCnpj());
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
        properties.add(new Property("apelidoCedente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoErro",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadeCentral",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataArquivo",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataFinal", DateType.create(), false, true));
        properties.add(new Property("dataInicial",
                DateType.create(),
                false,
                true));
        properties.add(new Property("descricaoErro",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricaoVAN",
                StringType.create(),
                false,
                true));
        properties.add(new Property("horaArquivo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeCedente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadePV",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numRegistroErro",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numRemessaRetorno",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroProxRemessa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroUltRetorno",
                LongType.create(),
                false,
                true));
        properties.add(new Property("observacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("opcaoConsulta",
                StringType.create(),
                false,
                true));
        properties.add(new Property("padrao", LongType.create(), false, true));
        properties.add(new Property("quantidadeRegistros",
                LongType.create(),
                false,
                true));
        properties.add(new Property("situacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoArquivo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoSolicitacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dataEnvioReenvio",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("cpfCnpj",
                StringType.create(),
                false,
                true));

        Layout result = new Layout(properties,
                "ArquivoRemessaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("descricaoVAN", new StringValue("X(30)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("dataArquivo", new DateValue("dd.MM.yyyy"));
        Mainframe.put("observacao", new StringValue("X(40)"));
        Mainframe.put("padrao", new LongValue("9(01)"));
        Mainframe.put("codigoUnidadePV", new LongValue("9(04)"));
        Mainframe.put("codigoUnidadeCentral", new LongValue("9(04)"));
        Mainframe.put("dataInicial", new DateValue("dd.MM.yyyy"));
        Mainframe.put("nomeCedente", new StringValue("X(40)"));
        Mainframe.put("codigoErro", new LongValue("9(05)"));
        Mainframe.put("numRemessaRetorno", new LongValue("9(08)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("numRegistroErro", new LongValue("9(06)"));
        Mainframe.put("horaArquivo", new StringValue("X(08)"));
        Mainframe.put("nomeUnidadePV", new StringValue("X(40)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("descricaoErro", new StringValue("X(40)"));
        Mainframe.put("numeroProxRemessa", new LongValue("9(08)"));
        Mainframe.put("apelidoCedente", new StringValue("X(06)"));
        Mainframe.put("tipoSolicitacao", new LongValue("9(03)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("dataFinal", new DateValue("dd.MM.yyyy"));
        Mainframe.put("tipoArquivo", new LongValue("9(01)"));
        Mainframe.put("opcaoConsulta", new StringValue("X(40)"));
        Mainframe.put("quantidadeRegistros", new LongValue("9(06)"));
        Mainframe.put("numeroUltRetorno", new LongValue("9(08)"));
        Mainframe.put("situacao", new StringValue("X(01)"));
        Mainframe.put("dataEnvioReenvio", new StringValue("X(10)"));
        Mainframe.put("cpfCnpj", new StringValue("X(20)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
