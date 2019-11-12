//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteEletronicoBean extends SigcbBean {
    private java.lang.Long agrupamento;

    private java.lang.String agrupamentoDesc;

    private java.lang.String apelido;

    private java.lang.String apelidoCopia;

    private java.lang.Long aplicativo;

    private java.lang.String aplicativoDesc;

    private java.lang.String arquivoRetorno;

    private java.lang.String arquivoRetornoCopia;

    private java.lang.Long atribuicaoVan;

    private java.lang.String atribuicaoVanDesc;

    private java.lang.String cadastrado;

    private java.lang.Long caixaPostal;

    private java.lang.Long cedenteJuncao;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoClienteCOCLI;

    private java.lang.Long codigoUnidadePVVinc;

    private java.lang.String copiaArquivoRetorno;

    private java.lang.String descricaoCriticas;

    private java.lang.String juncaoArquivoRetorno;

    private java.lang.String nsuTransacao;

    private java.lang.Long numeroProximaRemessa;

    private java.lang.Long numeroUltimoRetorno;

    private java.lang.Long padraoArquivo;

    private java.lang.String padraoArquivoDesc;

    private java.lang.Long perfilRejeicao;

    private java.lang.String perfilRejeicaoDesc;

    private java.lang.String preCritica;

    private java.lang.Long situacao;

    private java.lang.String solicitacaoEnvio;

    private java.lang.String strRecordset;

    private java.lang.String tipoAcao;

    private java.lang.String tipoConsulta;

    private java.lang.Long tipoTransmissao;

    private java.lang.String tipoTransmissaoDesc;

    private java.lang.Long van;

    private java.lang.String vanDesc;

    private java.lang.String versao;
    
    private String dataEnvioReenvio;
    
    private String codConnect;
    
    private String descConnect;
    
    private String situacaoVAN;
    
    private String tipoUsuario;
    
    private String codInternet;
    
    private String descInternet;
    
    private String retOnline;
    
    private String remOnline;
    
    private Long numUltRetOnline;
    
    private String webservice;

    public CedenteEletronicoBean() {
        this.agrupamento = null;
        this.agrupamentoDesc = null;
        this.apelido = null;
        this.apelidoCopia = null;
        this.aplicativo = null;
        this.aplicativoDesc = null;
        this.arquivoRetorno = null;
        this.arquivoRetornoCopia = null;
        this.atribuicaoVan = null;
        this.atribuicaoVanDesc = null;
        this.cadastrado = null;
        this.caixaPostal = null;
        this.cedenteJuncao = null;
        this.codigoCedente = null;
        this.codigoClienteCOCLI = null;
        this.codigoUnidadePVVinc = null;
        this.copiaArquivoRetorno = null;
        this.descricaoCriticas = null;
        this.juncaoArquivoRetorno = null;
        this.nsuTransacao = null;
        this.numeroProximaRemessa = null;
        this.numeroUltimoRetorno = null;
        this.padraoArquivo = null;
        this.padraoArquivoDesc = null;
        this.perfilRejeicao = null;
        this.perfilRejeicaoDesc = null;
        this.preCritica = null;
        this.situacao = null;
        this.solicitacaoEnvio = null;
        this.strRecordset = null;
        this.tipoAcao = null;
        this.tipoConsulta = null;
        this.tipoTransmissao = null;
        this.tipoTransmissaoDesc = null;
        this.van = null;
        this.vanDesc = null;
        this.versao = null;
        this.dataEnvioReenvio = null;
        this.codConnect=null;
        this.descConnect=null;
        this.situacaoVAN=null;
        this.tipoUsuario=null;
        this.codInternet=null;
        this.descInternet=null;
        this.retOnline = null;
        this.numUltRetOnline = null;
        this.remOnline=null;
    }

    public String getApplicationName() {
        return "CedenteEletronicoBean";
    }
    
    

    public String getWebservice() {
		return webservice;
	}

	public void setWebservice(String webservice) {
		this.webservice = webservice;
	}

	public String getRemOnline() {
		return remOnline;
	}

	public void setRemOnline(String remOnline) {
		this.remOnline = remOnline;
	}

	public java.lang.Long getAgrupamento() {
        return this.agrupamento;
    }

    public void setAgrupamento(java.lang.Long agrupamento) {
        this.agrupamento = agrupamento;
    }

    public java.lang.String getAgrupamentoDesc() {
        return this.agrupamentoDesc;
    }

    public void setAgrupamentoDesc(java.lang.String agrupamentoDesc) {
        this.agrupamentoDesc = agrupamentoDesc;
    }

    public java.lang.String getApelido() {
        return this.apelido;
    }

    public void setApelido(java.lang.String apelido) {
        this.apelido = apelido;
    }

    public java.lang.String getApelidoCopia() {
        return this.apelidoCopia;
    }

    public void setApelidoCopia(java.lang.String apelidoCopia) {
        this.apelidoCopia = apelidoCopia;
    }

    public java.lang.Long getAplicativo() {
        return this.aplicativo;
    }

    public void setAplicativo(java.lang.Long aplicativo) {
        this.aplicativo = aplicativo;
    }

    public java.lang.String getAplicativoDesc() {
        return this.aplicativoDesc;
    }

    public void setAplicativoDesc(java.lang.String aplicativoDesc) {
        this.aplicativoDesc = aplicativoDesc;
    }

    public java.lang.String getArquivoRetorno() {
        return this.arquivoRetorno;
    }

    public void setArquivoRetorno(java.lang.String arquivoRetorno) {
        this.arquivoRetorno = arquivoRetorno;
    }

    public java.lang.String getArquivoRetornoCopia() {
        return this.arquivoRetornoCopia;
    }

    public void setArquivoRetornoCopia(java.lang.String arquivoRetornoCopia) {
        this.arquivoRetornoCopia = arquivoRetornoCopia;
    }

    public java.lang.Long getAtribuicaoVan() {
        return this.atribuicaoVan;
    }

    public void setAtribuicaoVan(java.lang.Long atribuicaoVan) {
        this.atribuicaoVan = atribuicaoVan;
    }

    public java.lang.String getAtribuicaoVanDesc() {
        return this.atribuicaoVanDesc;
    }

    public void setAtribuicaoVanDesc(java.lang.String atribuicaoVanDesc) {
        this.atribuicaoVanDesc = atribuicaoVanDesc;
    }

    public java.lang.String getCadastrado() {
        return this.cadastrado;
    }

    public void setCadastrado(java.lang.String cadastrado) {
        this.cadastrado = cadastrado;
    }

    public java.lang.Long getCaixaPostal() {
        return this.caixaPostal;
    }

    public void setCaixaPostal(java.lang.Long caixaPostal) {
        this.caixaPostal = caixaPostal;
    }

    public java.lang.Long getCedenteJuncao() {
        return this.cedenteJuncao;
    }

    public void setCedenteJuncao(java.lang.Long cedenteJuncao) {
        this.cedenteJuncao = cedenteJuncao;
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

    public java.lang.String getCopiaArquivoRetorno() {
        return this.copiaArquivoRetorno;
    }

    public void setCopiaArquivoRetorno(java.lang.String copiaArquivoRetorno) {
        this.copiaArquivoRetorno = copiaArquivoRetorno;
    }

    public java.lang.String getDescricaoCriticas() {
        return this.descricaoCriticas;
    }

    public void setDescricaoCriticas(java.lang.String descricaoCriticas) {
        this.descricaoCriticas = descricaoCriticas;
    }

    public java.lang.String getJuncaoArquivoRetorno() {
        return this.juncaoArquivoRetorno;
    }

    public void setJuncaoArquivoRetorno(java.lang.String juncaoArquivoRetorno) {
        this.juncaoArquivoRetorno = juncaoArquivoRetorno;
    }

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public java.lang.Long getNumeroProximaRemessa() {
        return this.numeroProximaRemessa;
    }

    public void setNumeroProximaRemessa(java.lang.Long numeroProximaRemessa) {
        this.numeroProximaRemessa = numeroProximaRemessa;
    }

    public java.lang.Long getNumeroUltimoRetorno() {
        return this.numeroUltimoRetorno;
    }

    public void setNumeroUltimoRetorno(java.lang.Long numeroUltimoRetorno) {
        this.numeroUltimoRetorno = numeroUltimoRetorno;
    }

    public java.lang.Long getPadraoArquivo() {
        return this.padraoArquivo;
    }

    public void setPadraoArquivo(java.lang.Long padraoArquivo) {
        this.padraoArquivo = padraoArquivo;
    }

    public java.lang.String getPadraoArquivoDesc() {
        return this.padraoArquivoDesc;
    }

    public void setPadraoArquivoDesc(java.lang.String padraoArquivoDesc) {
        this.padraoArquivoDesc = padraoArquivoDesc;
    }

    public java.lang.Long getPerfilRejeicao() {
        return this.perfilRejeicao;
    }

    public void setPerfilRejeicao(java.lang.Long perfilRejeicao) {
        this.perfilRejeicao = perfilRejeicao;
    }

    public java.lang.String getPerfilRejeicaoDesc() {
        return this.perfilRejeicaoDesc;
    }

    public void setPerfilRejeicaoDesc(java.lang.String perfilRejeicaoDesc) {
        this.perfilRejeicaoDesc = perfilRejeicaoDesc;
    }

    public java.lang.String getPreCritica() {
        return this.preCritica;
    }

    public void setPreCritica(java.lang.String preCritica) {
        this.preCritica = preCritica;
    }

    public java.lang.Long getSituacao() {
        return this.situacao;
    }

    public void setSituacao(java.lang.Long situacao) {
        this.situacao = situacao;
    }

    public java.lang.String getSolicitacaoEnvio() {
        return this.solicitacaoEnvio;
    }

    public void setSolicitacaoEnvio(java.lang.String solicitacaoEnvio) {
        this.solicitacaoEnvio = solicitacaoEnvio;
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

    public java.lang.String getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public java.lang.Long getTipoTransmissao() {
        return this.tipoTransmissao;
    }

    public void setTipoTransmissao(java.lang.Long tipoTransmissao) {
        this.tipoTransmissao = tipoTransmissao;
    }

    public java.lang.String getTipoTransmissaoDesc() {
        return this.tipoTransmissaoDesc;
    }

    public void setTipoTransmissaoDesc(java.lang.String tipoTransmissaoDesc) {
        this.tipoTransmissaoDesc = tipoTransmissaoDesc;
    }

    public java.lang.Long getVan() {
        return this.van;
    }

    public void setVan(java.lang.Long van) {
        this.van = van;
    }

    public java.lang.String getVanDesc() {
        return this.vanDesc;
    }

    public void setVanDesc(java.lang.String vanDesc) {
        this.vanDesc = vanDesc;
    }

    public java.lang.String getVersao() {
        return this.versao;
    }

    public void setVersao(java.lang.String versao) {
        this.versao = versao;
    }

    public String getDataEnvioReenvio() {
		return dataEnvioReenvio;
	}

	public void setDataEnvioReenvio(String dataEnvioReenvio) {
		this.dataEnvioReenvio = dataEnvioReenvio;
	}
	
	

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getSituacaoVAN() {
		return situacaoVAN;
	}

	public void setSituacaoVAN(String situacaoVAN) {
		this.situacaoVAN = situacaoVAN;
	}

	
	public String getCodInternet() {
		return codInternet;
	}

	public void setCodInternet(String codInternet) {
		this.codInternet = codInternet;
	}

	public String getRetOnline() {
		return retOnline;
	}

	public void setRetOnline(String retOnline) {
		this.retOnline = retOnline;
	}

	
	

	public String getDescInternet() {
		return descInternet;
	}

	public void setDescInternet(String descInternet) {
		this.descInternet = descInternet;
	}

	public Long getNumUltRetOnline() {
		return numUltRetOnline;
	}

	public void setNumUltRetOnline(Long numUltRetOnline) {
		this.numUltRetOnline = numUltRetOnline;
	}

	// ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    public java.lang.String getCodigoCedenteJuncaoFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.cedenteJuncao);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedenteEletronicoBean other = (CedenteEletronicoBean) obj;
            result = result && equals(getAgrupamento(), other.getAgrupamento());
            result = result
                     && equals(getAgrupamentoDesc(), other.getAgrupamentoDesc());
            result = result && equals(getApelido(), other.getApelido());
            result = result
                     && equals(getApelidoCopia(), other.getApelidoCopia());
            result = result && equals(getAplicativo(), other.getAplicativo());
            result = result
                     && equals(getAplicativoDesc(), other.getAplicativoDesc());
            result = result
                     && equals(getArquivoRetorno(), other.getArquivoRetorno());
            result = result
                     && equals(getArquivoRetornoCopia(),
                             other.getArquivoRetornoCopia());
            result = result
                     && equals(getAtribuicaoVan(), other.getAtribuicaoVan());
            result = result
                     && equals(getAtribuicaoVanDesc(),
                             other.getAtribuicaoVanDesc());
            result = result && equals(getCadastrado(), other.getCadastrado());
            result = result && equals(getCaixaPostal(), other.getCaixaPostal());
            result = result
                     && equals(getCedenteJuncao(), other.getCedenteJuncao());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoClienteCOCLI(),
                             other.getCodigoClienteCOCLI());
            result = result
                     && equals(getCodigoUnidadePVVinc(),
                             other.getCodigoUnidadePVVinc());
            result = result
                     && equals(getCopiaArquivoRetorno(),
                             other.getCopiaArquivoRetorno());
            result = result
                     && equals(getDescricaoCriticas(),
                             other.getDescricaoCriticas());
            result = result
                     && equals(getJuncaoArquivoRetorno(),
                             other.getJuncaoArquivoRetorno());
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result
                     && equals(getNumeroProximaRemessa(),
                             other.getNumeroProximaRemessa());
            result = result
                     && equals(getNumeroUltimoRetorno(),
                             other.getNumeroUltimoRetorno());
            result = result
                     && equals(getPadraoArquivo(), other.getPadraoArquivo());
            result = result
                     && equals(getPadraoArquivoDesc(),
                             other.getPadraoArquivoDesc());
            result = result
                     && equals(getPerfilRejeicao(), other.getPerfilRejeicao());
            result = result
                     && equals(getPerfilRejeicaoDesc(),
                             other.getPerfilRejeicaoDesc());
            result = result && equals(getPreCritica(), other.getPreCritica());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result
                     && equals(getSolicitacaoEnvio(),
                             other.getSolicitacaoEnvio());
            result = result
                     && equals(getStrRecordset(), other.getStrRecordset());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result
                     && equals(getTipoTransmissao(), other.getTipoTransmissao());
            result = result
                     && equals(getTipoTransmissaoDesc(),
                             other.getTipoTransmissaoDesc());
            result = result && equals(getVan(), other.getVan());
            result = result && equals(getVanDesc(), other.getVanDesc());
            result = result && equals(getVersao(), other.getVersao());
            result = result && equals(getDataEnvioReenvio(), other.getDataEnvioReenvio());
            result = result && equals(getCodConnect(), other.getCodConnect());
            result = result && equals(getDescConnect(), other.getDescConnect());
            result = result && equals(getSituacaoVAN(), other.getSituacaoVAN());
            result = result && equals(getTipoUsuario(), other.getTipoUsuario());
            result = result && equals(getCodInternet(), other.getCodInternet());
            result = result && equals(getNumUltRetOnline(), other.getNumUltRetOnline());
            result = result && equals(getRetOnline(), other.getRetOnline());
            result = result && equals(getDescInternet(), other.getDescInternet());
            result = result && equals(getRemOnline(), other.getRemOnline());
            result = result && equals(getWebservice(), other.getWebservice());
            
            
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
        properties.add(new Property("agrupamento",
                LongType.create(),
                false,
                true));
        properties.add(new Property("agrupamentoDesc",
                StringType.create(),
                false,
                true));
        properties.add(new Property("apelido", StringType.create(), false, true));
        properties.add(new Property("apelidoCopia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("aplicativo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("aplicativoDesc",
                StringType.create(),
                false,
                true));
        properties.add(new Property("arquivoRetorno",
                StringType.create(),
                false,
                true));
        properties.add(new Property("arquivoRetornoCopia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("atribuicaoVan",
                LongType.create(),
                false,
                true));
        properties.add(new Property("atribuicaoVanDesc",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cadastrado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("caixaPostal",
                LongType.create(),
                false,
                true));
        properties.add(new Property("cedenteJuncao",
                LongType.create(),
                false,
                true));
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
        properties.add(new Property("copiaArquivoRetorno",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricaoCriticas",
                StringType.create(),
                false,
                true));
        properties.add(new Property("juncaoArquivoRetorno",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroProximaRemessa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroUltimoRetorno",
                LongType.create(),
                false,
                true));
        properties.add(new Property("padraoArquivo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("padraoArquivoDesc",
                StringType.create(),
                false,
                true));
        properties.add(new Property("perfilRejeicao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("perfilRejeicaoDesc",
                StringType.create(),
                false,
                true));
        properties.add(new Property("preCritica",
                StringType.create(),
                false,
                true));
        properties.add(new Property("situacao", LongType.create(), false, true));
        properties.add(new Property("solicitacaoEnvio",
                StringType.create(),
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
        properties.add(new Property("tipoConsulta",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoTransmissao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoTransmissaoDesc",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codInternet",
                StringType.create(),
                false,
                true));
        properties.add(new Property("retOnline",
                StringType.create(),
                false,
                true));
        properties.add(new Property("remOnline",
                StringType.create(),
                false,
                true));
        properties.add(new Property("webservice",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numUltRetOnline", LongType.create(), false, true));
        properties.add(new Property("van", LongType.create(), false, true));
        properties.add(new Property("vanDesc", StringType.create(), false, true));
        properties.add(new Property("versao", StringType.create(), false, true));
        properties.add(new Property("dataEnvioReenvio", StringType.create(), false, true));
        properties.add(new Property("codConnect", StringType.create(), false, true));
        properties.add(new Property("descConnect", StringType.create(), false, true));
        properties.add(new Property("situacaoVAN", StringType.create(), false, true));
        properties.add(new Property("tipoUsuario", StringType.create(), false, true));
        properties.add(new Property("descInternet", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "CedenteEletronicoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("agrupamento", new LongValue("9(06)"));
        Mainframe.put("agrupamentoDesc", new StringValue("X(40)"));
        Mainframe.put("apelido", new StringValue("X(06)"));
        Mainframe.put("apelidoCopia", new StringValue("X(06)"));
        Mainframe.put("aplicativo", new LongValue("9(02)"));
        Mainframe.put("aplicativoDesc", new StringValue("X(40)"));
        Mainframe.put("arquivoRetorno", new StringValue("X(30)"));
        Mainframe.put("arquivoRetornoCopia", new StringValue("X(30)"));
        Mainframe.put("atribuicaoVan", new LongValue("9(01)"));
        Mainframe.put("atribuicaoVanDesc", new StringValue("X(40)"));
        Mainframe.put("cadastrado", new StringValue("X(1)"));
        Mainframe.put("caixaPostal", new LongValue("9(05)"));
        Mainframe.put("cedenteJuncao", new LongValue("9(07)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("codigoClienteCOCLI", new LongValue("9(13)"));
        Mainframe.put("codigoUnidadePVVinc", new LongValue("9(04)"));
        Mainframe.put("copiaArquivoRetorno", new StringValue("X(01)"));
        Mainframe.put("descricaoCriticas", new StringValue("X(200)"));
        Mainframe.put("juncaoArquivoRetorno", new StringValue("X(01)"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("numeroProximaRemessa", new LongValue("9(08)"));
        Mainframe.put("numeroUltimoRetorno", new LongValue("9(08)"));
        Mainframe.put("padraoArquivo", new LongValue("9(01)"));
        Mainframe.put("padraoArquivoDesc", new StringValue("X(40)"));
        Mainframe.put("perfilRejeicao", new LongValue("9(01)"));
        Mainframe.put("perfilRejeicaoDesc", new StringValue("X(40)"));
        Mainframe.put("preCritica", new StringValue("X(01)"));
        Mainframe.put("situacao", new LongValue("9(01)"));
        Mainframe.put("solicitacaoEnvio", new StringValue("X(1)"));
        Mainframe.put("strRecordset", new StringValue("X(364)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("tipoConsulta", new StringValue("X(01)"));
        Mainframe.put("tipoTransmissao", new LongValue("9(03)"));
        Mainframe.put("tipoTransmissaoDesc", new StringValue("X(40)"));
        Mainframe.put("van", new LongValue("9(02)"));
        Mainframe.put("vanDesc", new StringValue("X(40)"));
        Mainframe.put("versao", new StringValue("X(06)"));
        Mainframe.put("dataEnvioReenvio", new StringValue("X(10)"));
        Mainframe.put("codConnect", new StringValue("X(02)"));
        Mainframe.put("descConnect", new StringValue("X(40)"));
        Mainframe.put("situacaoVAN", new StringValue("X(20)"));
        Mainframe.put("tipoUsuario", new StringValue("X(01)"));
        
        Mainframe.put("codInternet", new StringValue("X(02)"));
        Mainframe.put("descInternet", new StringValue("X(40)"));
        Mainframe.put("retOnline", new StringValue("X(01)"));
        Mainframe.put("remOnline", new StringValue("X(01)"));
        Mainframe.put("webservice", new StringValue("X(01)"));
        Mainframe.put("numUltRetOnline", new LongValue("9(08)"));
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }

	public String getCodConnect() {
		return codConnect;
	}

	public void setCodConnect(String codConnect) {
		this.codConnect = codConnect;
	}

	public String getDescConnect() {
		return descConnect;
	}

	public void setDescConnect(String descConnect) {
		this.descConnect = descConnect;
	}
    
    
    
    
}
