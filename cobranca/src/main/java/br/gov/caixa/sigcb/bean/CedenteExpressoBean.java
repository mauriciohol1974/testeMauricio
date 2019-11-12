package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteExpressoBean extends SigcbBean {

	private java.lang.Long registro;

	private java.lang.Long codCedente;
    private java.lang.String tipoAcao;
    
    private String tpAcao;
    private String tpPessoa;
    private Long cpfCnpj;
    private Long nuPv   ;
    private Long nuCOCLI;
    private Long tipoCobranca;         
    private Long agContaCred;        
    private  Long opContaCred;        
    private Long nuContaCred;        
    private Long dvContaCred ;       
    private Long agContaDeb  ;       
    private Long opContaDeb  ;       
    private Long nuContaDeb  ;       
    private Long dvContaDeb  ;       
    private Long tpAplicativo;       
    private Long icPadrao;         
    private String icAmbiente; 
    private Long tpTransmissao;       
    private Long van;         
    private Long codConnect;
    private Long codInternet;
    private String ipConexao;
    
    private String noCedente;
    private Long idEndereco;
    private String noLogradouro;
    private String nuLocal;
    private String noComplemento;
    private String noRazaoSocial;
    private String noBairro;
    private String noMunicipio;
    private Long nuCep;
    private String sgUF;
    
        
    
    //------Campos de descricao Guia Geral
    
    private Long tpCobranca;
    private String proAut;
    private String pzProt;
    private String pzDev;
    private String extTit;
    private String desExt;
    private String descrExt;
    private String extDebCred;
    private String desDebCred;
    private String descrExtDeb;
    private String invMen;
    private String tipJur;
    private String descrTipJur;
    private String perJur;
    private String perMulta;
    private String pzMulta;
    private String recCheque;
    private String bcoSac;
    private String modTit;
    private String cliSin;
    private String girCaixa;
    private String excAut;
    private String natureza;
    private String deNatureza;
    private String ramo;
    private String deRamo;
    private String setor;
    private String deSetor;
    private String porte;
    private String dePorte;
    private String filler;
    private String bcoCor;
    private String pvVinc;
    private String enVinc;
    private String cedCent;
    private String sitCed;
    private String icCobSemBlq;
    private String nuRede;
    private String tpAtividade;
    private String iof;
    private String valorDif;
    private String cocliSince;
    private String cedMasterPec;
    private String cedVincPec;
    private String dataVincPec;
    private String pvVincAnt;
    private String dtAltPvVinc;
    
    //Guia Contas
    
    private String tpConta;
    private String unConta;
    private String opConta;
    private String nuConta;
    private String dvConta;
    private String pcRateio;
    private String vrRateio;
    private String tpContadeb;
    private String unContadeb;
    private String opContadeb;
    private String nuContadeb;
    private String dvContadeb;
    private String pcRateiodeb;
    private String vrRateiodeb;
    
    // Guia Eletronico
    
    private String icAmbienteEle;
    private String tpAplicacao;
    private String dscAplicativo;
    private String coVrsApl;
    private String tpTran;
    private String dscTran;
    private String icPadraoEle;
    private String sit;
    private String icAtrVan;
    private String vanE;
    private String dscVan;
    private String icJunRet;
    private String cedJunc;
    private String icRej;
    private String icNot;
    private String coApe;
    private String icArqDup;
    private String coCxPostal;
    private String coApeDupl;
    private String coDsn;
    private String coDsnDup;
    private String nuUltRem;
    private String agrupEsc;
    private String dscAgrup;
    private String nuUltRet;
    private String dtCargaIni;
    private String connect;
    private String deConnect;
    private String situacao;
    private String internet;
    private String deInternet;
    private String icReto;
    private String nuUltReto;
    
    //---Guia Boletos
    
    private String tpEmisBloq;
    private String deEmisBloq;
    private String tpEntregaBloq;
    private String deEntregaBloq;
    private String tpEntregaSac;
    private String deEntregaSac;
    private String icAvisoVenc;
    private String icAvisoProt;
    private String vrMinAvis;
    private String qtdDiasProt;
    private String avisDisBloq1;
    private String avisDisBloq2;
    private String avisDisBloq3;
    private String avisVenc1;
    private String avisVenc2;
    private String avisVenc3;
    private String imprimeDDA;
    private String icEnvioSms;
    private String prazoSms1;
    private String prazoSms2;
    private String prazoSms3;
    
    //-----Tarifas
    
    private String tipoPeriodo;
    private String dePeriodo;
    private String ddDebito;
    private String icFormaCalculo;
    
    //-----Parametros
    
    private String tpCalc;
    private String autVrCob;
    private String garOpcrd;
    private String bolExpresso;
    private String limValor;
    private String creOnline;
    private String icClienteExterno;
    private String icFimDfrd;
    private String nuEvtContabil;
    private String icUndCrdo;
    private String icrateioTit;
    private String icCedGarantia;
    private String nuOpGarantia;
    private String nuContratoGarantia;
    private String icBaixaGar;
    private String icMrcGar;
    private String icDsmGar;
    private String icContaGar;
    private String nuUnidadeGar;
    private String nuOpGar;
    private String nuContagar;
    private String nuDvGar;
    private String icLncContabil;
    private String nuEventoContabil;
    private String icBolProposta;
    private String icCmdDebito;
    private String icCriticaCep;
    
    
    //Campos novos
    
    private String  icRemOnline;
    private String  icServicoWeb;
    private String  qtdeBoleto;
    private String vrMinimo;
    private String vrMaximo;
    private String tpBeneficiario;
    private String cdEntidadeSindical;
    private String nuEventoContabilDebito;
    private String icAutorizaPgto;
    private String icCalcIndice;
    private String sgIndiceEspecial;
    private String icAplIndiceEspecial;
    

    
    
    public CedenteExpressoBean() {
        this.registro = null;
        this.codCedente = null;
        this.tipoAcao = null;
        this.tpAcao = null;
        this.tpPessoa= null;
        this.cpfCnpj= null;
        this.nuPv= null;
        this.nuCOCLI= null;
        this.tipoCobranca= null;         
        this.agContaCred= null;        
        this.opContaCred= null;        
        this.nuContaCred= null;        
        this.dvContaCred= null;       
        this.agContaDeb= null;       
        this.opContaDeb= null;       
        this.nuContaDeb= null;       
        this.dvContaDeb= null;       
        this.tpAplicativo= null;       
        this.icPadrao= null;         
        this.icAmbiente= null;
        this.tpTransmissao=null;       
        this.van=null;         
        this.codConnect=null;
        this.codInternet=null;
        this.ipConexao=null;
        this.noCedente=null;
        this.idEndereco=null;
        this.noLogradouro=null;
        this.nuLocal=null;
        this.noComplemento=null;
        this.noBairro=null;
        this.noMunicipio=null;
        this.nuCep=null;
        this.sgUF=null;
        this.noRazaoSocial=null;
        
        
        
      //------Campos de descricao Guia Geral
        
        this.tpCobranca=null;
       this.proAut=null;
       this.pzProt=null;
       this.pzDev=null;
       this.extTit=null;
       this.desExt=null;
       this.descrExt=null;
       this.extDebCred=null;
       this.desDebCred=null;
       this.descrExtDeb=null;
       this.invMen=null;
       this.tipJur=null;
       this.descrTipJur=null;
       this.perJur=null;
       this.perMulta=null;
       this.pzMulta=null;
       this.recCheque=null;
       this.bcoSac=null;
       this.modTit=null;
       this.cliSin=null;
       this.girCaixa=null;
       this.excAut=null;
       this.natureza=null;
       this.deNatureza=null;
       this.ramo=null;
       this.deRamo=null;
       this.setor=null;
       this.deSetor=null;
       this.porte=null;
       this.dePorte=null;
       this.filler=null;
       this.bcoCor=null;
       this.pvVinc=null;
       this.enVinc=null;
       this.cedCent=null;
       this.sitCed=null;
       this.icCobSemBlq=null;
       this.nuRede=null;
       this.tpAtividade=null;
       this.iof=null;
       this.valorDif=null;
       this.cocliSince=null;
       this.cedMasterPec=null;
       this.cedVincPec=null;
       this.dataVincPec=null;
       this.pvVincAnt=null;
       this.dtAltPvVinc=null;
       
       //Guia Contas
       
       this.tpConta=null;
       this.unConta=null;
       this.opConta=null;
       this.nuConta=null;
       this.dvConta=null;
       this.pcRateio=null;
       this.vrRateio=null;
       this.tpContadeb=null;
       this.unContadeb=null;
       this.opContadeb=null;
       this.nuContadeb=null;
       this.dvContadeb=null;
       this.pcRateiodeb=null;
       this.vrRateiodeb=null;
       
       // Guia Eletronico
       
      this.icAmbienteEle=null;
      this.tpAplicacao=null;
      this.dscAplicativo=null;
      this.coVrsApl=null;
      this.tpTran=null;
      this.dscTran=null;
      this.icPadraoEle=null;
      this.sit=null;
      this.icAtrVan=null;
      this.vanE=null;
      this.dscVan=null;
      this.icJunRet=null;
      this.cedJunc=null;
      this.icRej=null;
      this.icNot=null;
      this.coApe=null;
      this.icArqDup=null;
      this.coCxPostal=null;
      this.coApeDupl=null;
      this.coDsn=null;
      this.coDsnDup=null;
      this.nuUltRem=null;
      this.agrupEsc=null;
      this.dscAgrup=null;
      this.nuUltRet=null;
      this.dtCargaIni=null;
      this.connect=null;
      this.deConnect=null;
      this.situacao=null;
      this.internet=null;
      this.deInternet=null;
      this.icReto=null;
      this.nuUltReto=null;
      
      //---Guia Boletos
      
     this.tpEmisBloq=null;
     this.deEmisBloq=null;
     this.tpEntregaBloq=null;
     this.deEntregaBloq=null;
     this.tpEntregaSac=null;
     this.deEntregaSac=null;
     this.icAvisoVenc=null;
     this.icAvisoProt=null;
     this.vrMinAvis=null;
     this.qtdDiasProt=null;
     this.avisDisBloq1=null;
     this.avisDisBloq2=null;
     this.avisDisBloq3=null;
     this.avisVenc1=null;
     this.avisVenc2=null;
     this.avisVenc3=null;
     this.imprimeDDA=null;
     this.icEnvioSms=null;
     this.prazoSms1=null;
     this.prazoSms2=null;
     this.prazoSms3=null;
     
     //-----Tarifas
     
    this.tipoPeriodo=null;
    this.dePeriodo=null;
    this.ddDebito=null;
    this.icFormaCalculo=null;
     
     //-----Parametros
     
    this.tpCalc=null;
    this.autVrCob=null;
    this.garOpcrd=null;
    this.bolExpresso=null;
    this.limValor=null;
    this.creOnline=null;
    this.icClienteExterno=null;
    this.icFimDfrd=null;
    this.nuEvtContabil=null;
    this.icUndCrdo=null;
    this.icrateioTit=null;
    this.icCedGarantia=null;
    this.nuOpGarantia=null;
    this.nuContratoGarantia=null;
    this.icBaixaGar=null;
    this.icMrcGar=null;
    this.icDsmGar=null;
    this.icContaGar=null;
    this.nuUnidadeGar=null;
    this.nuOpGar=null;
    this.nuContagar=null;
    this.nuDvGar=null;
    this.icLncContabil=null;
    this.nuEventoContabil=null;
    this.icBolProposta=null;
    this.icCmdDebito=null;
    this.icCriticaCep=null;
     
     
     //campos novos
      
	this.icRemOnline=null;
	this.icServicoWeb=null;
	this.qtdeBoleto=null;
	this.vrMinimo=null;
	this.vrMaximo=null;
	this.tpBeneficiario=null;
	this.cdEntidadeSindical=null;
	this.nuEventoContabilDebito=null;
	this.icAutorizaPgto=null;
	this.icCalcIndice=null;
	this.sgIndiceEspecial=null;
	this.icAplIndiceEspecial=null;

    }

    public String getApplicationName() {
        return "CedenteExpressoBean";
    }


    public String getIcRemOnline() {
		return icRemOnline;
	}

	public void setIcRemOnline(String icRemOnline) {
		this.icRemOnline = icRemOnline;
	}

	public String getIcServicoWeb() {
		return icServicoWeb;
	}

	public void setIcServicoWeb(String icServicoWeb) {
		this.icServicoWeb = icServicoWeb;
	}

	public String getQtdeBoleto() {
		return qtdeBoleto;
	}

	public void setQtdeBoleto(String qtdeBoleto) {
		this.qtdeBoleto = qtdeBoleto;
	}

	public String getVrMinimo() {
		return vrMinimo;
	}

	public void setVrMinimo(String vrMinimo) {
		this.vrMinimo = vrMinimo;
	}

	public String getVrMaximo() {
		return vrMaximo;
	}

	public void setVrMaximo(String vrMaximo) {
		this.vrMaximo = vrMaximo;
	}

	public String getTpBeneficiario() {
		return tpBeneficiario;
	}

	public void setTpBeneficiario(String tpBeneficiario) {
		this.tpBeneficiario = tpBeneficiario;
	}

	public String getCdEntidadeSindical() {
		return cdEntidadeSindical;
	}

	public void setCdEntidadeSindical(String cdEntidadeSindical) {
		this.cdEntidadeSindical = cdEntidadeSindical;
	}

	public String getNuEventoContabilDebito() {
		return nuEventoContabilDebito;
	}

	public void setNuEventoContabilDebito(String nuEventoContabilDebito) {
		this.nuEventoContabilDebito = nuEventoContabilDebito;
	}

	public String getIcAutorizaPgto() {
		return icAutorizaPgto;
	}

	public void setIcAutorizaPgto(String icAutorizaPgto) {
		this.icAutorizaPgto = icAutorizaPgto;
	}

	public String getIcCalcIndice() {
		return icCalcIndice;
	}

	public void setIcCalcIndice(String icCalcIndice) {
		this.icCalcIndice = icCalcIndice;
	}

	public String getSgIndiceEspecial() {
		return sgIndiceEspecial;
	}

	public void setSgIndiceEspecial(String sgIndiceEspecial) {
		this.sgIndiceEspecial = sgIndiceEspecial;
	}

	public String getIcAplIndiceEspecial() {
		return icAplIndiceEspecial;
	}

	public void setIcAplIndiceEspecial(String icAplIndiceEspecial) {
		this.icAplIndiceEspecial = icAplIndiceEspecial;
	}

	public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codCedente);
        return codigoCedenteFormatado;
    }
    
    
    public String getNoCedente() {
		return noCedente;
	}

	public void setNoCedente(String noCedente) {
		this.noCedente = noCedente;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getNoLogradouro() {
		return noLogradouro;
	}

	public void setNoLogradouro(String noLogradouro) {
		this.noLogradouro = noLogradouro;
	}



	public String getNuLocal() {
		return nuLocal;
	}

	public void setNuLocal(String nuLocal) {
		this.nuLocal = nuLocal;
	}

	public String getNoComplemento() {
		return noComplemento;
	}

	public void setNoComplemento(String noComplemento) {
		this.noComplemento = noComplemento;
	}

	public String getNoBairro() {
		return noBairro;
	}

	public void setNoBairro(String noBairro) {
		this.noBairro = noBairro;
	}

	public String getNoMunicipio() {
		return noMunicipio;
	}

	public void setNoMunicipio(String noMunicipio) {
		this.noMunicipio = noMunicipio;
	}

	public Long getNuCep() {
		return nuCep;
	}

	public void setNuCep(Long nuCep) {
		this.nuCep = nuCep;
	}

	public String getSgUF() {
		return sgUF;
	}

	public void setSgUF(String sgUF) {
		this.sgUF = sgUF;
	}

	public String getIcArqDup() {
		return icArqDup;
	}

	public void setIcArqDup(String icArqDup) {
		this.icArqDup = icArqDup;
	}

	public String getCoDsnDup() {
		return coDsnDup;
	}

	public void setCoDsnDup(String coDsnDup) {
		this.coDsnDup = coDsnDup;
	}

	public String getIpConexao() {
		return ipConexao;
	}

	public void setIpConexao(String ipConexao) {
		this.ipConexao = ipConexao;
	}

	public java.lang.Long getRegistro() {
        return this.registro;
    }

    public void setRegistro(java.lang.Long registro) {
        this.registro = registro;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }
    
    

    public Long getTpTransmissao() {
		return tpTransmissao;
	}

	public void setTpTransmissao(Long tpTransmissao) {
		this.tpTransmissao = tpTransmissao;
	}

	public Long getVan() {
		return van;
	}

	public void setVan(Long van) {
		this.van = van;
	}

	
	public Long getTipoCobranca() {
		return tipoCobranca;
	}

	public void setTipoCobranca(Long tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}

	public Long getCodConnect() {
		return codConnect;
	}

	public void setCodConnect(Long codConnect) {
		this.codConnect = codConnect;
	}

	public Long getCodInternet() {
		return codInternet;
	}

	public java.lang.Long getCodCedente() {
		return codCedente;
	}

	public void setCodCedente(java.lang.Long codCedente) {
		this.codCedente = codCedente;
	}

	public void setCodInternet(Long codInternet) {
		this.codInternet = codInternet;
	}

	public String getTpAcao() {
		return tpAcao;
	}

	public void setTpAcao(String tpAcao) {
		this.tpAcao = tpAcao;
	}

	public String getTpPessoa() {
		return tpPessoa;
	}

	public void setTpPessoa(String tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	public Long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(Long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Long getNuPv() {
		return nuPv;
	}

	public void setNuPv(Long nuPv) {
		this.nuPv = nuPv;
	}

	public Long getNuCOCLI() {
		return nuCOCLI;
	}

	public void setNuCOCLI(Long nuCOCLI) {
		this.nuCOCLI = nuCOCLI;
	}

	public Long getAgContaCred() {
		return agContaCred;
	}

	public void setAgContaCred(Long agContaCred) {
		this.agContaCred = agContaCred;
	}

	public Long getOpContaCred() {
		return opContaCred;
	}

	public void setOpContaCred(Long opContaCred) {
		this.opContaCred = opContaCred;
	}

	public Long getNuContaCred() {
		return nuContaCred;
	}

	public void setNuContaCred(Long nuContaCred) {
		this.nuContaCred = nuContaCred;
	}

	public Long getDvContaCred() {
		return dvContaCred;
	}

	public void setDvContaCred(Long dvContaCred) {
		this.dvContaCred = dvContaCred;
	}

	public Long getAgContaDeb() {
		return agContaDeb;
	}

	public void setAgContaDeb(Long agContaDeb) {
		this.agContaDeb = agContaDeb;
	}

	public Long getOpContaDeb() {
		return opContaDeb;
	}

	public void setOpContaDeb(Long opContaDeb) {
		this.opContaDeb = opContaDeb;
	}

	public Long getNuContaDeb() {
		return nuContaDeb;
	}

	public void setNuContaDeb(Long nuContaDeb) {
		this.nuContaDeb = nuContaDeb;
	}

	public Long getDvContaDeb() {
		return dvContaDeb;
	}

	public void setDvContaDeb(Long dvContaDeb) {
		this.dvContaDeb = dvContaDeb;
	}
	
	


	public String getTpAplicacao() {
		return tpAplicacao;
	}

	public void setTpAplicacao(String tpAplicacao) {
		this.tpAplicacao = tpAplicacao;
	}

	public String getTpContadeb() {
		return tpContadeb;
	}

	public void setTpContadeb(String tpContadeb) {
		this.tpContadeb = tpContadeb;
	}

	public String getUnContadeb() {
		return unContadeb;
	}

	public void setUnContadeb(String unContadeb) {
		this.unContadeb = unContadeb;
	}

	public String getOpContadeb() {
		return opContadeb;
	}

	public void setOpContadeb(String opContadeb) {
		this.opContadeb = opContadeb;
	}

	public String getNuContadeb() {
		return nuContadeb;
	}

	public void setNuContadeb(String nuContadeb) {
		this.nuContadeb = nuContadeb;
	}

	public String getDvContadeb() {
		return dvContadeb;
	}

	public void setDvContadeb(String dvContadeb) {
		this.dvContadeb = dvContadeb;
	}

	public String getPcRateiodeb() {
		return pcRateiodeb;
	}

	public void setPcRateiodeb(String pcRateiodeb) {
		this.pcRateiodeb = pcRateiodeb;
	}

	public String getVrRateiodeb() {
		return vrRateiodeb;
	}

	public void setVrRateiodeb(String vrRateiodeb) {
		this.vrRateiodeb = vrRateiodeb;
	}

	public Long getTpAplicativo() {
		return tpAplicativo;
	}

	public void setTpAplicativo(Long tpAplicativo) {
		this.tpAplicativo = tpAplicativo;
	}

	public Long getIcPadrao() {
		return icPadrao;
	}

	public void setIcPadrao(Long icPadrao) {
		this.icPadrao = icPadrao;
	}


	public String getIcAmbiente() {
		return icAmbiente;
	}

	public void setIcAmbiente(String icAmbiente) {
		this.icAmbiente = icAmbiente;
	}

	public Long getTpCobranca() {
		return tpCobranca;
	}

	public void setTpCobranca(Long tpCobranca) {
		this.tpCobranca = tpCobranca;
	}

	public String getProAut() {
		return proAut;
	}

	public void setProAut(String proAut) {
		this.proAut = proAut;
	}

	public String getPzProt() {
		return pzProt;
	}

	public void setPzProt(String pzProt) {
		this.pzProt = pzProt;
	}

	public String getPzDev() {
		return pzDev;
	}

	public void setPzDev(String pzDev) {
		this.pzDev = pzDev;
	}

	public String getExtTit() {
		return extTit;
	}

	public void setExtTit(String extTit) {
		this.extTit = extTit;
	}

	public String getDesExt() {
		return desExt;
	}

	public void setDesExt(String desExt) {
		this.desExt = desExt;
	}

	public String getDescrExt() {
		return descrExt;
	}

	public void setDescrExt(String descrExt) {
		this.descrExt = descrExt;
	}

	public String getExtDebCred() {
		return extDebCred;
	}
	

	public String getVanE() {
		return vanE;
	}

	public void setVanE(String vanE) {
		this.vanE = vanE;
	}

	public void setExtDebCred(String extDebCred) {
		this.extDebCred = extDebCred;
	}

	public String getDesDebCred() {
		return desDebCred;
	}

	public void setDesDebCred(String desDebCred) {
		this.desDebCred = desDebCred;
	}

	public String getDescrExtDeb() {
		return descrExtDeb;
	}

	public void setDescrExtDeb(String descrExtDeb) {
		this.descrExtDeb = descrExtDeb;
	}

	public String getInvMen() {
		return invMen;
	}

	public void setInvMen(String invMen) {
		this.invMen = invMen;
	}

	public String getTipJur() {
		return tipJur;
	}

	public void setTipJur(String tipJur) {
		this.tipJur = tipJur;
	}
	
	

	public String getNoRazaoSocial() {
		return noRazaoSocial;
	}

	public void setNoRazaoSocial(String noRazaoSocial) {
		this.noRazaoSocial = noRazaoSocial;
	}

	public String getDescrTipJur() {
		return descrTipJur;
	}

	public void setDescrTipJur(String descrTipJur) {
		this.descrTipJur = descrTipJur;
	}

	public String getPerJur() {
		return perJur;
	}

	public void setPerJur(String perJur) {
		this.perJur = perJur;
	}

	public String getPerMulta() {
		return perMulta;
	}

	public void setPerMulta(String perMulta) {
		this.perMulta = perMulta;
	}

	public String getPzMulta() {
		return pzMulta;
	}

	public void setPzMulta(String pzMulta) {
		this.pzMulta = pzMulta;
	}

	public String getRecCheque() {
		return recCheque;
	}

	public void setRecCheque(String recCheque) {
		this.recCheque = recCheque;
	}

	public String getBcoSac() {
		return bcoSac;
	}

	public void setBcoSac(String bcoSac) {
		this.bcoSac = bcoSac;
	}

	public String getModTit() {
		return modTit;
	}

	public void setModTit(String modTit) {
		this.modTit = modTit;
	}

	public String getCliSin() {
		return cliSin;
	}

	public void setCliSin(String cliSin) {
		this.cliSin = cliSin;
	}

	public String getGirCaixa() {
		return girCaixa;
	}

	public void setGirCaixa(String girCaixa) {
		this.girCaixa = girCaixa;
	}

	public String getExcAut() {
		return excAut;
	}

	public void setExcAut(String excAut) {
		this.excAut = excAut;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public String getDeNatureza() {
		return deNatureza;
	}

	public void setDeNatureza(String deNatureza) {
		this.deNatureza = deNatureza;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getDeRamo() {
		return deRamo;
	}

	public void setDeRamo(String deRamo) {
		this.deRamo = deRamo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getDeSetor() {
		return deSetor;
	}

	public void setDeSetor(String deSetor) {
		this.deSetor = deSetor;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getDePorte() {
		return dePorte;
	}

	public void setDePorte(String dePorte) {
		this.dePorte = dePorte;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	public String getBcoCor() {
		return bcoCor;
	}

	public void setBcoCor(String bcoCor) {
		this.bcoCor = bcoCor;
	}

	public String getPvVinc() {
		return pvVinc;
	}

	public void setPvVinc(String pvVinc) {
		this.pvVinc = pvVinc;
	}

	public String getEnVinc() {
		return enVinc;
	}

	public void setEnVinc(String enVinc) {
		this.enVinc = enVinc;
	}

	public String getCedCent() {
		return cedCent;
	}

	public void setCedCent(String cedCent) {
		this.cedCent = cedCent;
	}

	public String getSitCed() {
		return sitCed;
	}

	public void setSitCed(String sitCed) {
		this.sitCed = sitCed;
	}

	public String getIcCobSemBlq() {
		return icCobSemBlq;
	}

	public void setIcCobSemBlq(String icCobSemBlq) {
		this.icCobSemBlq = icCobSemBlq;
	}

	public String getNuRede() {
		return nuRede;
	}

	public void setNuRede(String nuRede) {
		this.nuRede = nuRede;
	}

	public String getTpAtividade() {
		return tpAtividade;
	}

	public void setTpAtividade(String tpAtividade) {
		this.tpAtividade = tpAtividade;
	}

	public String getIof() {
		return iof;
	}

	public void setIof(String iof) {
		this.iof = iof;
	}

	public String getValorDif() {
		return valorDif;
	}

	public void setValorDif(String valorDif) {
		this.valorDif = valorDif;
	}

	public String getCocliSince() {
		return cocliSince;
	}

	public void setCocliSince(String cocliSince) {
		this.cocliSince = cocliSince;
	}

	public String getCedMasterPec() {
		return cedMasterPec;
	}

	public void setCedMasterPec(String cedMasterPec) {
		this.cedMasterPec = cedMasterPec;
	}

	public String getCedVincPec() {
		return cedVincPec;
	}

	public void setCedVincPec(String cedVincPec) {
		this.cedVincPec = cedVincPec;
	}

	public String getDataVincPec() {
		return dataVincPec;
	}

	public void setDataVincPec(String dataVincPec) {
		this.dataVincPec = dataVincPec;
	}

	public String getPvVincAnt() {
		return pvVincAnt;
	}

	public void setPvVincAnt(String pvVincAnt) {
		this.pvVincAnt = pvVincAnt;
	}

	public String getDtAltPvVinc() {
		return dtAltPvVinc;
	}

	public void setDtAltPvVinc(String dtAltPvVinc) {
		this.dtAltPvVinc = dtAltPvVinc;
	}

	public String getTpConta() {
		return tpConta;
	}

	public void setTpConta(String tpConta) {
		this.tpConta = tpConta;
	}

	public String getUnConta() {
		return unConta;
	}

	public void setUnConta(String unConta) {
		this.unConta = unConta;
	}

	public String getOpConta() {
		return opConta;
	}

	public void setOpConta(String opConta) {
		this.opConta = opConta;
	}

	public String getNuConta() {
		return nuConta;
	}

	public void setNuConta(String nuConta) {
		this.nuConta = nuConta;
	}

	public String getDvConta() {
		return dvConta;
	}

	public void setDvConta(String dvConta) {
		this.dvConta = dvConta;
	}

	public String getPcRateio() {
		return pcRateio;
	}

	public void setPcRateio(String pcRateio) {
		this.pcRateio = pcRateio;
	}

	public String getVrRateio() {
		return vrRateio;
	}

	public void setVrRateio(String vrRateio) {
		this.vrRateio = vrRateio;
	}

	public String getIcAmbienteEle() {
		return icAmbienteEle;
	}

	public void setIcAmbienteEle(String icAmbienteEle) {
		this.icAmbienteEle = icAmbienteEle;
	}

	public String getDscAplicativo() {
		return dscAplicativo;
	}

	public void setDscAplicativo(String dscAplicativo) {
		this.dscAplicativo = dscAplicativo;
	}

	public String getCoVrsApl() {
		return coVrsApl;
	}

	public void setCoVrsApl(String coVrsApl) {
		this.coVrsApl = coVrsApl;
	}

	public String getTpTran() {
		return tpTran;
	}

	public void setTpTran(String tpTran) {
		this.tpTran = tpTran;
	}

	public String getDscTran() {
		return dscTran;
	}

	public void setDscTran(String dscTran) {
		this.dscTran = dscTran;
	}

	public String getIcPadraoEle() {
		return icPadraoEle;
	}

	public void setIcPadraoEle(String icPadraoEle) {
		this.icPadraoEle = icPadraoEle;
	}

	public String getSit() {
		return sit;
	}

	public void setSit(String sit) {
		this.sit = sit;
	}

	public String getIcAtrVan() {
		return icAtrVan;
	}

	public void setIcAtrVan(String icAtrVan) {
		this.icAtrVan = icAtrVan;
	}

	public String getDscVan() {
		return dscVan;
	}

	public void setDscVan(String dscVan) {
		this.dscVan = dscVan;
	}

	public String getIcJunRet() {
		return icJunRet;
	}

	public void setIcJunRet(String icJunRet) {
		this.icJunRet = icJunRet;
	}

	public String getCedJunc() {
		return cedJunc;
	}

	public void setCedJunc(String cedJunc) {
		this.cedJunc = cedJunc;
	}

	public String getIcRej() {
		return icRej;
	}

	public void setIcRej(String icRej) {
		this.icRej = icRej;
	}

	public String getIcNot() {
		return icNot;
	}

	public void setIcNot(String icNot) {
		this.icNot = icNot;
	}

	public String getCoApe() {
		return coApe;
	}

	public void setCoApe(String coApe) {
		this.coApe = coApe;
	}

	public String getCoDsn() {
		return coDsn;
	}

	public void setCoDsn(String coDsn) {
		this.coDsn = coDsn;
	}

	public String getNuUltRem() {
		return nuUltRem;
	}

	public void setNuUltRem(String nuUltRem) {
		this.nuUltRem = nuUltRem;
	}

	public String getAgrupEsc() {
		return agrupEsc;
	}

	public void setAgrupEsc(String agrupEsc) {
		this.agrupEsc = agrupEsc;
	}

	public String getDscAgrup() {
		return dscAgrup;
	}

	public void setDscAgrup(String dscAgrup) {
		this.dscAgrup = dscAgrup;
	}

	public String getNuUltRet() {
		return nuUltRet;
	}

	public void setNuUltRet(String nuUltRet) {
		this.nuUltRet = nuUltRet;
	}

	public String getDtCargaIni() {
		return dtCargaIni;
	}

	public void setDtCargaIni(String dtCargaIni) {
		this.dtCargaIni = dtCargaIni;
	}

	public String getConnect() {
		return connect;
	}

	public void setConnect(String connect) {
		this.connect = connect;
	}

	public String getDeConnect() {
		return deConnect;
	}

	public void setDeConnect(String deConnect) {
		this.deConnect = deConnect;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getDeInternet() {
		return deInternet;
	}

	public void setDeInternet(String deInternet) {
		this.deInternet = deInternet;
	}

	public String getIcReto() {
		return icReto;
	}

	public void setIcReto(String icReto) {
		this.icReto = icReto;
	}

	public String getNuUltReto() {
		return nuUltReto;
	}

	public void setNuUltReto(String nuUltReto) {
		this.nuUltReto = nuUltReto;
	}

	public String getTpEmisBloq() {
		return tpEmisBloq;
	}

	public void setTpEmisBloq(String tpEmisBloq) {
		this.tpEmisBloq = tpEmisBloq;
	}

	public String getDeEmisBloq() {
		return deEmisBloq;
	}

	public void setDeEmisBloq(String deEmisBloq) {
		this.deEmisBloq = deEmisBloq;
	}

	public String getTpEntregaBloq() {
		return tpEntregaBloq;
	}

	public void setTpEntregaBloq(String tpEntregaBloq) {
		this.tpEntregaBloq = tpEntregaBloq;
	}

	public String getDeEntregaBloq() {
		return deEntregaBloq;
	}

	public void setDeEntregaBloq(String deEntregaBloq) {
		this.deEntregaBloq = deEntregaBloq;
	}

	public String getTpEntregaSac() {
		return tpEntregaSac;
	}

	public void setTpEntregaSac(String tpEntregaSac) {
		this.tpEntregaSac = tpEntregaSac;
	}

	public String getDeEntregaSac() {
		return deEntregaSac;
	}

	public void setDeEntregaSac(String deEntregaSac) {
		this.deEntregaSac = deEntregaSac;
	}

	public String getIcAvisoVenc() {
		return icAvisoVenc;
	}

	public void setIcAvisoVenc(String icAvisoVenc) {
		this.icAvisoVenc = icAvisoVenc;
	}

	public String getIcAvisoProt() {
		return icAvisoProt;
	}

	public void setIcAvisoProt(String icAvisoProt) {
		this.icAvisoProt = icAvisoProt;
	}

	public String getVrMinAvis() {
		return vrMinAvis;
	}

	public void setVrMinAvis(String vrMinAvis) {
		this.vrMinAvis = vrMinAvis;
	}

	public String getQtdDiasProt() {
		return qtdDiasProt;
	}

	public void setQtdDiasProt(String qtdDiasProt) {
		this.qtdDiasProt = qtdDiasProt;
	}

	public String getAvisDisBloq1() {
		return avisDisBloq1;
	}

	public void setAvisDisBloq1(String avisDisBloq1) {
		this.avisDisBloq1 = avisDisBloq1;
	}

	public String getAvisDisBloq2() {
		return avisDisBloq2;
	}

	public void setAvisDisBloq2(String avisDisBloq2) {
		this.avisDisBloq2 = avisDisBloq2;
	}

	public String getAvisDisBloq3() {
		return avisDisBloq3;
	}

	public void setAvisDisBloq3(String avisDisBloq3) {
		this.avisDisBloq3 = avisDisBloq3;
	}

	public String getAvisVenc1() {
		return avisVenc1;
	}

	public void setAvisVenc1(String avisVenc1) {
		this.avisVenc1 = avisVenc1;
	}

	public String getAvisVenc2() {
		return avisVenc2;
	}

	public void setAvisVenc2(String avisVenc2) {
		this.avisVenc2 = avisVenc2;
	}

	public String getAvisVenc3() {
		return avisVenc3;
	}

	public void setAvisVenc3(String avisVenc3) {
		this.avisVenc3 = avisVenc3;
	}

	public String getImprimeDDA() {
		return imprimeDDA;
	}

	public void setImprimeDDA(String imprimeDDA) {
		this.imprimeDDA = imprimeDDA;
	}

	public String getIcEnvioSms() {
		return icEnvioSms;
	}

	public void setIcEnvioSms(String icEnvioSms) {
		this.icEnvioSms = icEnvioSms;
	}

	public String getPrazoSms1() {
		return prazoSms1;
	}

	public void setPrazoSms1(String prazoSms1) {
		this.prazoSms1 = prazoSms1;
	}

	public String getPrazoSms2() {
		return prazoSms2;
	}

	public void setPrazoSms2(String prazoSms2) {
		this.prazoSms2 = prazoSms2;
	}

	public String getPrazoSms3() {
		return prazoSms3;
	}

	public void setPrazoSms3(String prazoSms3) {
		this.prazoSms3 = prazoSms3;
	}

	public String getTipoPeriodo() {
		return tipoPeriodo;
	}

	public void setTipoPeriodo(String tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}

	public String getDePeriodo() {
		return dePeriodo;
	}

	public void setDePeriodo(String dePeriodo) {
		this.dePeriodo = dePeriodo;
	}

	public String getDdDebito() {
		return ddDebito;
	}

	public void setDdDebito(String ddDebito) {
		this.ddDebito = ddDebito;
	}

	public String getIcFormaCalculo() {
		return icFormaCalculo;
	}

	public void setIcFormaCalculo(String icFormaCalculo) {
		this.icFormaCalculo = icFormaCalculo;
	}

	public String getTpCalc() {
		return tpCalc;
	}

	public void setTpCalc(String tpCalc) {
		this.tpCalc = tpCalc;
	}

	public String getAutVrCob() {
		return autVrCob;
	}

	public void setAutVrCob(String autVrCob) {
		this.autVrCob = autVrCob;
	}

	public String getGarOpcrd() {
		return garOpcrd;
	}

	public void setGarOpcrd(String garOpcrd) {
		this.garOpcrd = garOpcrd;
	}

	public String getBolExpresso() {
		return bolExpresso;
	}

	public void setBolExpresso(String bolExpresso) {
		this.bolExpresso = bolExpresso;
	}

	public String getLimValor() {
		return limValor;
	}

	public void setLimValor(String limValor) {
		this.limValor = limValor;
	}

	public String getCreOnline() {
		return creOnline;
	}

	public void setCreOnline(String creOnline) {
		this.creOnline = creOnline;
	}

	public String getIcClienteExterno() {
		return icClienteExterno;
	}

	public void setIcClienteExterno(String icClienteExterno) {
		this.icClienteExterno = icClienteExterno;
	}

	public String getIcFimDfrd() {
		return icFimDfrd;
	}

	public void setIcFimDfrd(String icFimDfrd) {
		this.icFimDfrd = icFimDfrd;
	}

	public String getNuEvtContabil() {
		return nuEvtContabil;
	}

	public void setNuEvtContabil(String nuEvtContabil) {
		this.nuEvtContabil = nuEvtContabil;
	}

	public String getIcUndCrdo() {
		return icUndCrdo;
	}

	public void setIcUndCrdo(String icUndCrdo) {
		this.icUndCrdo = icUndCrdo;
	}

	public String getIcrateioTit() {
		return icrateioTit;
	}

	public void setIcrateioTit(String icrateioTit) {
		this.icrateioTit = icrateioTit;
	}

	public String getIcCedGarantia() {
		return icCedGarantia;
	}

	public void setIcCedGarantia(String icCedGarantia) {
		this.icCedGarantia = icCedGarantia;
	}

	public String getNuOpGarantia() {
		return nuOpGarantia;
	}

	public void setNuOpGarantia(String nuOpGarantia) {
		this.nuOpGarantia = nuOpGarantia;
	}

	public String getNuContratoGarantia() {
		return nuContratoGarantia;
	}

	public void setNuContratoGarantia(String nuContratoGarantia) {
		this.nuContratoGarantia = nuContratoGarantia;
	}

	public String getIcBaixaGar() {
		return icBaixaGar;
	}

	public void setIcBaixaGar(String icBaixaGar) {
		this.icBaixaGar = icBaixaGar;
	}

	public String getIcMrcGar() {
		return icMrcGar;
	}

	public void setIcMrcGar(String icMrcGar) {
		this.icMrcGar = icMrcGar;
	}

	public String getIcDsmGar() {
		return icDsmGar;
	}

	public void setIcDsmGar(String icDsmGar) {
		this.icDsmGar = icDsmGar;
	}

	public String getIcContaGar() {
		return icContaGar;
	}

	public void setIcContaGar(String icContaGar) {
		this.icContaGar = icContaGar;
	}

	public String getNuUnidadeGar() {
		return nuUnidadeGar;
	}

	public void setNuUnidadeGar(String nuUnidadeGar) {
		this.nuUnidadeGar = nuUnidadeGar;
	}

	public String getNuOpGar() {
		return nuOpGar;
	}

	public void setNuOpGar(String nuOpGar) {
		this.nuOpGar = nuOpGar;
	}

	public String getNuContagar() {
		return nuContagar;
	}

	public void setNuContagar(String nuContagar) {
		this.nuContagar = nuContagar;
	}

	public String getNuDvGar() {
		return nuDvGar;
	}

	public void setNuDvGar(String nuDvGar) {
		this.nuDvGar = nuDvGar;
	}

	public String getIcLncContabil() {
		return icLncContabil;
	}

	public void setIcLncContabil(String icLncContabil) {
		this.icLncContabil = icLncContabil;
	}

	public String getNuEventoContabil() {
		return nuEventoContabil;
	}

	public void setNuEventoContabil(String nuEventoContabil) {
		this.nuEventoContabil = nuEventoContabil;
	}

	public String getIcBolProposta() {
		return icBolProposta;
	}

	public void setIcBolProposta(String icBolProposta) {
		this.icBolProposta = icBolProposta;
	}

	public String getIcCmdDebito() {
		return icCmdDebito;
	}

	public void setIcCmdDebito(String icCmdDebito) {
		this.icCmdDebito = icCmdDebito;
	}

	public String getIcCriticaCep() {
		return icCriticaCep;
	}

	public void setIcCriticaCep(String icCriticaCep) {
		this.icCriticaCep = icCriticaCep;
	}
	
	

	public String getCoCxPostal() {
		return coCxPostal;
	}

	public void setCoCxPostal(String coCxPostal) {
		this.coCxPostal = coCxPostal;
	}

	public String getCoApeDupl() {
		return coApeDupl;
	}

	public void setCoApeDupl(String coApeDupl) {
		this.coApeDupl = coApeDupl;
	}

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedenteExpressoBean other = (CedenteExpressoBean) obj;
            result = result && equals(getRegistro(), other.getRegistro());
            result = result && equals(getCodCedente(), other.getCodCedente());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result && equals(getTpAcao(), other.getTpAcao());
            result = result && equals(getTpPessoa(), other.getTpPessoa());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getNuPv(), other.getNuPv());
            result = result && equals(getNuCOCLI(), other.getNuCOCLI());
            result = result && equals(getTipoCobranca(), other.getTipoCobranca());
            result = result && equals(getAgContaCred(), other.getAgContaCred());
            result = result && equals(getOpContaCred(), other.getOpContaCred());
            result = result && equals(getNuContaCred(), other.getNuContaCred());
            result = result && equals(getDvContaCred(), other.getDvContaCred());
            result = result && equals(getAgContaDeb(), other.getAgContaDeb());
            result = result && equals(getOpContaDeb(), other.getAgContaDeb());
            result = result && equals(getNuContaDeb(), other.getNuContaDeb());
            result = result && equals(getDvContaDeb(), other.getDvContaDeb());
            result = result && equals(getTpAplicativo(), other.getTpAplicativo());
            result = result && equals(getIcPadrao(), other.getIcPadrao());
            result = result && equals(getIcAmbiente(), other.getIcAmbiente());
            result = result && equals(getTpTransmissao(), other.getTpTransmissao());
            result = result && equals(getVan(), other.getVan());
            result = result && equals(getCodConnect(), other.getCodConnect());
            result = result && equals(getCodInternet(), other.getCodInternet());
            result = result && equals(getIpConexao(), other.getIpConexao());
            result = result && equals(getTpCobranca(), other.getTpCobranca());
            result = result && equals(getProAut(), other.getProAut());
            result = result && equals(getPzProt(), other.getPzProt());
            result = result && equals(getPzDev(), other.getPzDev());
            result = result && equals(getExtTit(), other.getExtTit());
            result = result && equals(getDesExt(), other.getDesExt());
            result = result && equals(getDescrExt(), other.getDescrExt());
            result = result && equals(getExtDebCred(), other.getExtDebCred());
            result = result && equals(getDesDebCred(), other.getDesDebCred());
            result = result && equals(getDescrExtDeb(), other.getDescrExtDeb());
            result = result && equals(getInvMen(), other.getInvMen());
            result = result && equals(getTipJur(), other.getTipJur());
            result = result && equals(getDescrTipJur(), other.getDescrTipJur());
            result = result && equals(getPerJur(), other.getPerJur());
            result = result && equals(getPerMulta(), other.getPerMulta());
            result = result && equals(getPzMulta(), other.getPzMulta());
            result = result && equals(getRecCheque(), other.getRecCheque());
            result = result && equals(getBcoSac(), other.getBcoSac());
            result = result && equals(getModTit(), other.getModTit());
            result = result && equals(getCliSin(), other.getCliSin());
            result = result && equals(getGirCaixa(), other.getGirCaixa());
            result = result && equals(getExcAut(), other.getExcAut());
            result = result && equals(getNatureza(), other.getNatureza());
            result = result && equals(getDeNatureza(), other.getDeNatureza());            
            result = result && equals(getRamo(), other.getRamo());
            result = result && equals(getDeRamo(), other.getDeRamo());
            result = result && equals(getSetor(), other.getSetor());
            result = result && equals(getDeSetor(), other.getDeSetor());            
            result = result && equals(getPorte(), other.getDePorte());
            result = result && equals(getFiller(), other.getFiller());
            result = result && equals(getBcoCor(), other.getBcoCor());
            result = result && equals(getPvVinc(), other.getPvVinc());
            result = result && equals(getEnVinc(), other.getEnVinc());
            result = result && equals(getCedCent(), other.getCedCent());
            result = result && equals(getSitCed(), other.getSitCed());
            result = result && equals(getIcCobSemBlq(), other.getIcCobSemBlq());
            result = result && equals(getNuRede(), other.getNuRede());
            result = result && equals(getTpAtividade(), other.getTpAtividade());
            result = result && equals(getIof(), other.getIof());
            result = result && equals(getValorDif(), other.getValorDif());
            result = result && equals(getCocliSince(), other.getCocliSince());
            result = result && equals(getCedMasterPec(), other.getCedMasterPec());
            result = result && equals(getCedVincPec(), other.getCedVincPec());
            result = result && equals(getDataVincPec(), other.getDataVincPec());
            result = result && equals(getPvVincAnt(), other.getPvVincAnt());
            result = result && equals(getDtAltPvVinc(), other.getDtAltPvVinc());
            result = result && equals(getNoRazaoSocial(), other.getNoRazaoSocial());
            
            //Guia Contas
            
           result = result && equals(getTpConta(),other.getTpConta());
           result = result && equals(getUnConta(),other.getUnConta());
           result = result && equals(getOpConta(),other.getOpConta());
           result = result && equals(getNuConta(),other.getNuConta());
           result = result && equals(getDvConta(),other.getDvConta());
           result = result && equals(getPcRateio(),other.getPcRateio());
           result = result && equals(getVrRateio(),other.getVrRateio());
           result = result && equals(getTpContadeb(),other.getTpContadeb());
           result = result && equals(getUnContadeb(),other.getUnContadeb());
           result = result && equals(getOpContadeb(),other.getOpContadeb());
           result = result && equals(getNuContadeb(),other.getNuContadeb());
           result = result && equals(getDvContadeb(),other.getDvContadeb());
           result = result && equals(getPcRateiodeb(),other.getPcRateiodeb());
           result = result && equals(getVrRateiodeb(),other.getVrRateiodeb());
            
            // Guia Eletronico
            
           result = result && equals(getIcAmbienteEle(),other.getIcAmbienteEle());
           result = result && equals(getTpAplicacao(),other.getTpAplicacao());
           result = result && equals(getDscAplicativo(),other.getDscAplicativo());
           result = result && equals(getCoVrsApl(),other.getCoVrsApl());
           result = result && equals(getTpTran(),other.getTpTran());
           result = result && equals(getDscTran(),other.getDscTran());
           result = result && equals(getIcPadraoEle(),other.getIcPadraoEle());
           result = result && equals(getSit(),other.getSit());
           result = result && equals(getIcAtrVan(),other.getIcAtrVan());
           result = result && equals(getVanE(),other.getVanE());
           result = result && equals(getDscVan(),other.getDscVan());
           result = result && equals(getIcJunRet(),other.getIcJunRet());
           result = result && equals(getCedJunc(),other.getCedJunc());
           result = result && equals(getIcRej(),other.getIcRej());
           result = result && equals(getIcNot(),other.getIcNot());
           result = result && equals(getCoApe(),other.getCoApe());
           result = result && equals(getIcArqDup(),other.getIcArqDup());
           result = result && equals(getCoCxPostal(),other.getCoCxPostal());
           result = result && equals(getCoApeDupl(),other.getCoApeDupl());
           result = result && equals(getCoDsn(),other.getCoDsn());
           result = result && equals(getCoDsnDup(),other.getCoDsnDup());
           result = result && equals(getNuUltRem(),other.getNuUltRem());
           result = result && equals(getAgrupEsc(),other.getAgrupEsc());
           result = result && equals(getDscAgrup(),other.getDscAgrup());
           result = result && equals(getNuUltRet(),other.getNuUltRet());
           result = result && equals(getDtCargaIni(),other.getDtCargaIni());
           result = result && equals(getConnect(),other.getConnect());
           result = result && equals(getDeConnect(),other.getDeConnect());
           result = result && equals(getSituacao(),other.getSituacao());
           result = result && equals(getInternet(),other.getInternet());
           result = result && equals(getDeInternet(),other.getDeInternet());
           result = result && equals(getNuUltReto(),other.getNuUltReto());
           result = result && equals(getTpEmisBloq(),other.getTpEmisBloq());
           result = result && equals(getDeEmisBloq(),other.getDeEmisBloq());
           result = result && equals(getTpEntregaBloq(),other.getTpEntregaBloq());
           result = result && equals(getDeEntregaBloq(),other.getDeEntregaBloq());
           result = result && equals(getTpEntregaSac(),other.getTpEntregaSac());
           result = result && equals(getDeEntregaSac(),other.getDeEntregaSac());
           result = result && equals(getIcAvisoVenc(),other.getIcAvisoVenc());
           result = result && equals(getIcAvisoProt(),other.getIcAvisoProt());
           result = result && equals(getVrMinAvis(),other.getVrMinAvis());
           result = result && equals(getQtdDiasProt(),other.getQtdDiasProt());
           result = result && equals(getAvisDisBloq1(),other.getAvisDisBloq1());
           result = result && equals(getAvisDisBloq2(),other.getAvisDisBloq2());
           result = result && equals(getAvisDisBloq3(),other.getAvisDisBloq3());
           result = result && equals(getAvisVenc1(),other.getAvisVenc1());
           result = result && equals(getAvisVenc2(),other.getAvisVenc2());
           result = result && equals(getAvisVenc3(),other.getAvisVenc3());
           result = result && equals(getImprimeDDA(),other.getImprimeDDA());
           result = result && equals(getIcEnvioSms(),other.getIcEnvioSms());
           result = result && equals(getPrazoSms1(),other.getPrazoSms1());
           result = result && equals(getPrazoSms2(),other.getPrazoSms2());
           result = result && equals(getPrazoSms3(),other.getPrazoSms3());
           
           
           // Guia Tarifas
           
           result = result && equals(getTipoPeriodo(),other.getTipoPeriodo());
           result = result && equals(getDePeriodo(),other.getDePeriodo());
           result = result && equals(getDdDebito(),other.getDdDebito());
           result = result && equals(getIcFormaCalculo(),other.getIcFormaCalculo());
           
           
           // Guia Parâmetros
           result = result && equals(getTpCalc(),other.getTpCalc());
           result = result && equals(getAutVrCob(),other.getAutVrCob());
           result = result && equals(getGarOpcrd(),other.getGarOpcrd());
           result = result && equals(getBolExpresso(),other.getBolExpresso());
           result = result && equals(getLimValor(),other.getLimValor());
           result = result && equals(getCreOnline(),other.getCreOnline());
           result = result && equals(getIcClienteExterno(),other.getIcClienteExterno());
           result = result && equals(getIcFimDfrd(),other.getIcFimDfrd());
           result = result && equals(getNuEvtContabil(),other.getNuEvtContabil());
           result = result && equals(getIcUndCrdo(),other.getIcUndCrdo());
           result = result && equals(getIcrateioTit(),other.getIcrateioTit());
           result = result && equals(getIcCedGarantia(),other.getIcCedGarantia());
           result = result && equals(getNuOpGarantia(),other.getNuOpGarantia());
           result = result && equals(getNuContratoGarantia(),other.getNuContratoGarantia());
           result = result && equals(getIcBaixaGar(),other.getIcBaixaGar());
           result = result && equals(getIcMrcGar(),other.getIcMrcGar());
           result = result && equals(getIcDsmGar(),other.getIcDsmGar());
           result = result && equals(getIcContaGar(),other.getIcContaGar());
           result = result && equals(getNuUnidadeGar(),other.getNuUnidadeGar());
           result = result && equals(getNuOpGar(),other.getNuOpGar());
           result = result && equals(getNuContagar(),other.getNuContagar());
           result = result && equals(getNuDvGar(),other.getNuDvGar());
           result = result && equals(getIcLncContabil(),other.getIcLncContabil());
           result = result && equals(getNuEventoContabil(),other.getNuEventoContabil());
           result = result && equals(getIcBolProposta(),other.getIcBolProposta());
           result = result && equals(getIcCmdDebito(),other.getIcCmdDebito());
           result = result && equals(getIcCriticaCep(),other.getIcCriticaCep());
           
           result = result && equals(getNoCedente(),other.getNoCedente());
           result = result && equals(getIdEndereco(),other.getIdEndereco());
           result = result && equals(getNoLogradouro(),other.getNoLogradouro());
           result = result && equals(getNuLocal(),other.getNuLocal());
           result = result && equals(getNoComplemento(),other.getNoComplemento());
           result = result && equals(getNoBairro(),other.getNoBairro());
           result = result && equals(getNoMunicipio(),other.getNoMunicipio());
           result = result && equals(getNuCep(),other.getNuCep());
           result = result && equals(getSgUF(),other.getSgUF());
           
           //Campos Novos

           result = result && equals(getIcRemOnline(),other.getIcRemOnline());
           result = result && equals(getIcServicoWeb(),other.getIcServicoWeb());
           result = result && equals(getQtdeBoleto(),other.getQtdeBoleto());
           result = result && equals(getVrMinimo(),other.getVrMinimo());
           result = result && equals(getVrMaximo(),other.getVrMaximo());
           result = result && equals(getTpBeneficiario(),other.getTpBeneficiario());
           result = result && equals(getCdEntidadeSindical(),other.getCdEntidadeSindical());
           result = result && equals(getNuEventoContabilDebito(),other.getNuEventoContabilDebito());
           result = result && equals(getIcAutorizaPgto(),other.getIcAutorizaPgto());
           result = result && equals(getIcCalcIndice(),other.getIcCalcIndice());
           result = result && equals(getSgIndiceEspecial(),other.getSgIndiceEspecial());
           result = result && equals(getIcAplIndiceEspecial(),other.getIcAplIndiceEspecial());
        
           
          
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
        properties.add(new Property("registro", LongType.create(), false, true));
        properties.add(new Property("codCedente", LongType.create(), false, true));
        properties.add(new Property("tipoAcao", StringType.create(), false, true));
        properties.add(new Property("tpAcao", StringType.create(), false, true));
        properties.add(new Property("ipConexao", StringType.create(), false, true));
        properties.add(new Property("tpPessoa", StringType.create(), false, true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("nuPv", LongType.create(), false, true));
        properties.add(new Property("nuCOCLI", LongType.create(), false, true));
        properties.add(new Property("tipoCobranca", LongType.create(), false, true));
        properties.add(new Property("agContaCred", LongType.create(), false, true));
        properties.add(new Property("opContaCred", LongType.create(), false, true));
        properties.add(new Property("nuContaCred", LongType.create(), false, true));
        properties.add(new Property("dvContaCred", LongType.create(), false, true));
        properties.add(new Property("agContaDeb", LongType.create(), false, true));
        properties.add(new Property("opContaDeb", LongType.create(), false, true));
        properties.add(new Property("nuContaDeb", LongType.create(), false, true));
        properties.add(new Property("dvContaDeb", LongType.create(), false, true));
        properties.add(new Property("tpAplicativo", LongType.create(), false, true));
        properties.add(new Property("icPadrao", LongType.create(), false, true));
        properties.add(new Property("icAmbiente", StringType.create(), false, true));
        properties.add(new Property("tpTransmissao", LongType.create(), false, true));
        properties.add(new Property("van", LongType.create(), false, true));
        properties.add(new Property("codConnect", LongType.create(), false, true));
        properties.add(new Property("codInternet", LongType.create(), false, true));
        
        //Guia Geral
        
        properties.add(new Property("tpCobranca", LongType.create(), false, true));
        properties.add(new Property("proAut", StringType.create(), false, true));
        properties.add(new Property("pzProt", StringType.create(), false, true));
        properties.add(new Property("pzDev", StringType.create(), false, true));
        properties.add(new Property("extTit", StringType.create(), false, true));
        properties.add(new Property("desExt", StringType.create(), false, true));
	    properties.add(new Property("descrExt", StringType.create(), false, true));
	    properties.add(new Property("extDebCred", StringType.create(), false, true));
	    properties.add(new Property("desDebCred", StringType.create(), false, true));
	    properties.add(new Property("descrExtDeb", StringType.create(), false, true));
	    properties.add(new Property("invMen", StringType.create(), false, true));
	    properties.add(new Property("tipJur", StringType.create(), false, true));
	    properties.add(new Property("descrTipJur", StringType.create(), false, true));
	    properties.add(new Property("perJur", StringType.create(), false, true));
	    properties.add(new Property("perMulta", StringType.create(), false, true));
	    properties.add(new Property("pzMulta", StringType.create(), false, true));
	    properties.add(new Property("recCheque", StringType.create(), false, true));
	    properties.add(new Property("bcoSac", StringType.create(), false, true));
	    properties.add(new Property("modTit", StringType.create(), false, true));
	    properties.add(new Property("cliSin", StringType.create(), false, true));
	    properties.add(new Property("girCaixa", StringType.create(), false, true));
	    properties.add(new Property("excAut", StringType.create(), false, true));
	    properties.add(new Property("natureza", StringType.create(), false, true));
	    properties.add(new Property("deNatureza", StringType.create(), false, true));
	    properties.add(new Property("ramo", StringType.create(), false, true));
	    properties.add(new Property("deRamo", StringType.create(), false, true));
	    properties.add(new Property("setor", StringType.create(), false, true));
	    properties.add(new Property("deSetor", StringType.create(), false, true));
	    properties.add(new Property("porte", StringType.create(), false, true));
	    properties.add(new Property("dePorte", StringType.create(), false, true));
	    properties.add(new Property("filler", StringType.create(), false, true));
	    properties.add(new Property("bcoCor", StringType.create(), false, true));
	    properties.add(new Property("pvVinc", StringType.create(), false, true));
	    properties.add(new Property("enVinc", StringType.create(), false, true));
	    properties.add(new Property("cedCent", StringType.create(), false, true));
	    properties.add(new Property("sitCed", StringType.create(), false, true));
	    properties.add(new Property("icCobSemBlq", StringType.create(), false, true));
	    properties.add(new Property("nuRede", StringType.create(), false, true));
	    properties.add(new Property("tpAtividade", StringType.create(), false, true));
	    properties.add(new Property("iof", StringType.create(), false, true));
	    properties.add(new Property("valorDif", StringType.create(), false, true));
	    properties.add(new Property("cocliSince", StringType.create(), false, true));
	    properties.add(new Property("cedMasterPec", StringType.create(), false, true));
	    properties.add(new Property("cedVincPec", StringType.create(), false, true));
	    properties.add(new Property("dataVincPec", StringType.create(), false, true));
	    properties.add(new Property("pvVincAnt", StringType.create(), false, true));
	    properties.add(new Property("dtAltPvVinc", StringType.create(), false, true));
	    
	    properties.add(new Property("noRazaoSocial", StringType.create(), false, true));
	    
	    
	    // Guia contas
	    
	    properties.add(new Property("tpConta", StringType.create(), false, true));
	    properties.add(new Property("unConta", StringType.create(), false, true));
	    properties.add(new Property("opConta", StringType.create(), false, true));
	    properties.add(new Property("nuConta", StringType.create(), false, true));
	    properties.add(new Property("dvConta", StringType.create(), false, true));
	    properties.add(new Property("pcRateio", StringType.create(), false, true));
	    properties.add(new Property("vrRateio", StringType.create(), false, true));
	    
	    properties.add(new Property("tpContadeb", StringType.create(), false, true));
	    properties.add(new Property("unContadeb", StringType.create(), false, true));
	    properties.add(new Property("opContadeb", StringType.create(), false, true));
	    properties.add(new Property("nuContadeb", StringType.create(), false, true));
	    properties.add(new Property("dvContadeb", StringType.create(), false, true));
	    properties.add(new Property("pcRateiodeb", StringType.create(), false, true));
	    properties.add(new Property("vrRateiodeb", StringType.create(), false, true));
	    
	    //Guia Eletronico
	    
	    properties.add(new Property("icAmbienteEle", StringType.create(), false, true));
	    properties.add(new Property("tpAplicacao", StringType.create(), false, true));
	    properties.add(new Property("dscAplicativo", StringType.create(), false, true));
	    properties.add(new Property("coVrsApl", StringType.create(), false, true));
	    properties.add(new Property("tpTran", StringType.create(), false, true));
	    properties.add(new Property("dscTran", StringType.create(), false, true));
	    properties.add(new Property("icPadraoEle", StringType.create(), false, true));
	    properties.add(new Property("sit", StringType.create(), false, true));
	    properties.add(new Property("icAtrVan", StringType.create(), false, true));
	    properties.add(new Property("vanE", StringType.create(), false, true));
	    properties.add(new Property("dscVan", StringType.create(), false, true));
	    properties.add(new Property("icJunRet", StringType.create(), false, true));
	    properties.add(new Property("cedJunc", StringType.create(), false, true));
	    properties.add(new Property("icRej", StringType.create(), false, true));
	    properties.add(new Property("icNot", StringType.create(), false, true));
	    properties.add(new Property("coApe", StringType.create(), false, true));
	    properties.add(new Property("icArqDup", StringType.create(), false, true));
	    properties.add(new Property("coCxPostal", StringType.create(), false, true));
	    properties.add(new Property("coApeDupl", StringType.create(), false, true));
	    properties.add(new Property("coDsn", StringType.create(), false, true));
	    properties.add(new Property("coDsnDup", StringType.create(), false, true));
	    properties.add(new Property("nuUltRem", StringType.create(), false, true));
	    properties.add(new Property("agrupEsc", StringType.create(), false, true));
	    properties.add(new Property("dscAgrup", StringType.create(), false, true));
	    properties.add(new Property("nuUltRet", StringType.create(), false, true));
	    properties.add(new Property("dtCargaIni", StringType.create(), false, true));
	    properties.add(new Property("connect", StringType.create(), false, true));
	    properties.add(new Property("deConnect", StringType.create(), false, true));
	    properties.add(new Property("situacao", StringType.create(), false, true));
	    properties.add(new Property("internet", StringType.create(), false, true));
	    properties.add(new Property("deInternet", StringType.create(), false, true));
	    properties.add(new Property("icReto", StringType.create(), false, true));
	    properties.add(new Property("nuUltReto", StringType.create(), false, true));
	    
	    //---Guia Boletos
	    
	    properties.add(new Property("tpEmisBloq", StringType.create(), false, true));
	    properties.add(new Property("deEmisBloq", StringType.create(), false, true));
	    properties.add(new Property("tpEntregaBloq", StringType.create(), false, true));
	    properties.add(new Property("deEntregaBloq", StringType.create(), false, true));
	    properties.add(new Property("tpEntregaSac", StringType.create(), false, true));
	    properties.add(new Property("deEntregaSac", StringType.create(), false, true));
	    properties.add(new Property("icAvisoVenc", StringType.create(), false, true));
	    properties.add(new Property("icAvisoProt", StringType.create(), false, true));
	    properties.add(new Property("vrMinAvis", StringType.create(), false, true));
	    properties.add(new Property("qtdDiasProt", StringType.create(), false, true));
	    properties.add(new Property("avisDisBloq1", StringType.create(), false, true));
	    properties.add(new Property("avisDisBloq2", StringType.create(), false, true));
	    properties.add(new Property("avisDisBloq3", StringType.create(), false, true));
	    properties.add(new Property("avisVenc1", StringType.create(), false, true));
	    properties.add(new Property("avisVenc2", StringType.create(), false, true));
	    properties.add(new Property("avisVenc3", StringType.create(), false, true));
	    properties.add(new Property("imprimeDDA", StringType.create(), false, true));
	    properties.add(new Property("icEnvioSms", StringType.create(), false, true));
	    properties.add(new Property("prazoSms1", StringType.create(), false, true));
	    properties.add(new Property("prazoSms2", StringType.create(), false, true));
	    properties.add(new Property("prazoSms3", StringType.create(), false, true));
	    
	    //Guia Tarifas
	    properties.add(new Property("tipoPeriodo", StringType.create(), false, true));
	    properties.add(new Property("dePeriodo", StringType.create(), false, true));
	    properties.add(new Property("ddDebito", StringType.create(), false, true));
	    properties.add(new Property("icFormaCalculo", StringType.create(), false, true));
	    
	    //Guia Parametros
	    properties.add(new Property("tpCalc", StringType.create(), false, true));
	    properties.add(new Property("autVrCob", StringType.create(), false, true));
	    properties.add(new Property("garOpcrd", StringType.create(), false, true));
	    properties.add(new Property("bolExpresso", StringType.create(), false, true));
	    properties.add(new Property("limValor", StringType.create(), false, true));
	    properties.add(new Property("creOnline", StringType.create(), false, true));
	    properties.add(new Property("icClienteExterno", StringType.create(), false, true));
	    properties.add(new Property("icFimDfrd", StringType.create(), false, true));
	    properties.add(new Property("nuEvtContabil", StringType.create(), false, true));
	    properties.add(new Property("icUndCrdo", StringType.create(), false, true));
	    properties.add(new Property("icrateioTit", StringType.create(), false, true));
	    properties.add(new Property("icCedGarantia", StringType.create(), false, true));
	    properties.add(new Property("nuOpGarantia", StringType.create(), false, true));
	    properties.add(new Property("nuContratoGarantia", StringType.create(), false, true));
	    properties.add(new Property("icBaixaGar", StringType.create(), false, true));
	    properties.add(new Property("icMrcGar", StringType.create(), false, true));
	    properties.add(new Property("icDsmGar", StringType.create(), false, true));
	    properties.add(new Property("icContaGar", StringType.create(), false, true));
	    properties.add(new Property("nuUnidadeGar", StringType.create(), false, true));
	    properties.add(new Property("nuOpGar", StringType.create(), false, true));
	    properties.add(new Property("nuContagar", StringType.create(), false, true));
	    properties.add(new Property("nuDvGar", StringType.create(), false, true));
	    properties.add(new Property("icLncContabil", StringType.create(), false, true));
	    properties.add(new Property("nuEventoContabil", StringType.create(), false, true));
	    properties.add(new Property("icBolProposta", StringType.create(), false, true));
	    properties.add(new Property("icCmdDebito", StringType.create(), false, true));
	    properties.add(new Property("icCriticaCep", StringType.create(), false, true));
	    
	    
	    properties.add(new Property("noCedente", StringType.create(), false, true));
	    properties.add(new Property("idEndereco", LongType.create(), false, true));
	    properties.add(new Property("noLogradouro", StringType.create(), false, true));
	    properties.add(new Property("nuLocal", StringType.create(), false, true));
	    properties.add(new Property("noComplemento", StringType.create(), false, true));
	    properties.add(new Property("noBairro", StringType.create(), false, true));
	    properties.add(new Property("noMunicipio", StringType.create(), false, true));
	    properties.add(new Property("nuCep", LongType.create(), false, true));
	    properties.add(new Property("sgUF", StringType.create(), false, true));
	  
	    
	    //Campo novos
	    
        
      
        
        properties.add(new Property("icRemOnline", StringType.create(), false, true));
        properties.add(new Property("icServicoWeb", StringType.create(), false, true));
        properties.add(new Property("qtdeBoleto", StringType.create(), false, true));
        properties.add(new Property("vrMinimo", StringType.create(), false, true));
        properties.add(new Property("vrMaximo", StringType.create(), false, true));
        properties.add(new Property("tpBeneficiario", StringType.create(), false, true));
        properties.add(new Property("cdEntidadeSindical", StringType.create(), false, true));
        properties.add(new Property("nuEventoContabilDebito", StringType.create(), false, true));
        properties.add(new Property("icAutorizaPgto", StringType.create(), false, true));
        properties.add(new Property("icCalcIndice", StringType.create(), false, true));
        properties.add(new Property("sgIndiceEspecial", StringType.create(), false, true));
        properties.add(new Property("icAplIndiceEspecial", StringType.create(), false, true));
        
	    
	    Layout result = new Layout(properties, "CedenteExpressoBean","br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("registro", new LongValue("9(04)"));
        Mainframe.put("codCedente", new LongValue("9(07)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("tpPessoa", new StringValue("X(01)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("nuPv", new LongValue("9(04)"));
        Mainframe.put("nuCOCLI", new LongValue("9(13)"));
        Mainframe.put("tipoCobranca", new LongValue("9(01)"));
        Mainframe.put("agContaCred", new LongValue("9(04)"));
        Mainframe.put("opContaCred", new LongValue("9(03)"));
        Mainframe.put("nuContaCred", new LongValue("9(08)"));
        Mainframe.put("dvContaCred", new LongValue("9(01)"));
        Mainframe.put("agContaDeb", new LongValue("9(04)"));
        Mainframe.put("opContaDeb", new LongValue("9(03)"));
        Mainframe.put("nuContaDeb", new LongValue("9(08)"));
        Mainframe.put("dvContaDeb", new LongValue("9(01)"));
        Mainframe.put("tpAplicativo", new LongValue("9(02)"));
        Mainframe.put("icPadrao", new LongValue("9(01)"));
        Mainframe.put("icAmbiente", new StringValue("X(01)"));
        Mainframe.put("tpTransmissao", new LongValue("9(02)"));
        Mainframe.put("van", new LongValue("9(02)"));
        Mainframe.put("codConnect", new LongValue("9(02)"));
        Mainframe.put("codInternet", new LongValue("9(02)"));
        Mainframe.put("ipConexao", new StringValue("X(15)"));
        Mainframe.put("noCedente", new StringValue("X(40)"));
        Mainframe.put("noRazaoSocial", new StringValue("X(40)"));
        Mainframe.put("idEndereco", new LongValue("9(4)"));
        Mainframe.put("noLogradouro", new StringValue("X(50)"));
        Mainframe.put("nuLocal", new StringValue("X(7)"));
        Mainframe.put("noComplemento", new StringValue("X(15)"));
        Mainframe.put("noBairro", new StringValue("X(40)"));
        Mainframe.put("noMunicipio", new StringValue("X(35)"));
        Mainframe.put("nuCep", new LongValue("9(8)"));
        Mainframe.put("sgUF", new StringValue("X(2)"));
        
        //-----------Guia Geral
        Mainframe.put("tpCobranca", new LongValue("9(1)"));
        Mainframe.put("proAut", new StringValue("X(1)"));
        Mainframe.put("pzProt", new StringValue("X(3)"));
        Mainframe.put("pzDev", new StringValue("X(3)"));
        Mainframe.put("extTit", new StringValue("X(1)"));
        Mainframe.put("desExt", new StringValue("X(2)"));
	    Mainframe.put("descrExt", new StringValue("X(20)"));
	    Mainframe.put("extDebCred", new StringValue("X(1)"));
	    Mainframe.put("desDebCred", new StringValue("X(2)"));
	    Mainframe.put("descrExtDeb", new StringValue("X(20)"));
	    Mainframe.put("invMen", new StringValue("X(1)"));
	    Mainframe.put("tipJur", new StringValue("X(1)"));
	    Mainframe.put("descrTipJur", new StringValue("X(20)"));
	    Mainframe.put("perJur", new StringValue("X(5)"));
	    Mainframe.put("perMulta", new StringValue("X(5)"));
	    Mainframe.put("pzMulta", new StringValue("X(3)"));
	    Mainframe.put("recCheque", new StringValue("X(1)"));
	    Mainframe.put("bcoSac", new StringValue("X(1)"));
	    Mainframe.put("modTit", new StringValue("X(1)"));
	    Mainframe.put("cliSin", new StringValue("X(1)"));
	    Mainframe.put("girCaixa", new StringValue("X(1)"));
	    Mainframe.put("excAut", new StringValue("X(1)"));
	    Mainframe.put("natureza", new StringValue("X(2)"));
	    Mainframe.put("deNatureza", new StringValue("X(30)"));
	    Mainframe.put("ramo", new StringValue("X(4)"));
	    Mainframe.put("deRamo", new StringValue("X(40)"));
	    Mainframe.put("setor", new StringValue("X(2)"));
	    Mainframe.put("deSetor", new StringValue("X(40)"));
	    Mainframe.put("porte", new StringValue("X(2)"));
	    Mainframe.put("dePorte", new StringValue("X(40)"));
	    Mainframe.put("filler", new StringValue("X(1)"));
	    Mainframe.put("bcoCor", new StringValue("X(1)"));
	    Mainframe.put("pvVinc", new StringValue("X(4)"));
	    Mainframe.put("enVinc", new StringValue("X(4)"));
	    Mainframe.put("cedCent", new StringValue("X(7)"));
	    Mainframe.put("sitCed", new StringValue("X(1)"));
	    Mainframe.put("icCobSemBlq", new StringValue("X(1)"));
	    Mainframe.put("nuRede", new StringValue("X(4)"));
	    Mainframe.put("tpAtividade", new StringValue("X(1)"));
	    Mainframe.put("iof", new StringValue("X(1)"));
	    Mainframe.put("valorDif", new StringValue("X(1)"));
	    Mainframe.put("cocliSince", new StringValue("X(9)"));
	    Mainframe.put("cedMasterPec", new StringValue("X(1)"));
	    Mainframe.put("cedVincPec", new StringValue("X(7)"));
	    Mainframe.put("dataVincPec", new StringValue("X(10)"));
	    Mainframe.put("pvVincAnt", new StringValue("X(4)"));
	    Mainframe.put("dtAltPvVinc", new StringValue("X(10)"));
	    
	    // Guia Contas
	    
	    Mainframe.put("tpConta", new StringValue("X(1)"));
	    Mainframe.put("unConta", new StringValue("X(4)"));
	    Mainframe.put("opConta", new StringValue("X(3)"));
	    Mainframe.put("nuConta", new StringValue("X(8)"));
	    Mainframe.put("dvConta", new StringValue("X(1)"));
	    Mainframe.put("pcRateio", new StringValue("X(5)"));
	    Mainframe.put("vrRateio", new StringValue("X(15)"));
	    Mainframe.put("tpContadeb", new StringValue("X(1)"));
	    Mainframe.put("unContadeb", new StringValue("X(4)"));
	    Mainframe.put("opContadeb", new StringValue("X(3)"));
	    Mainframe.put("nuContadeb", new StringValue("X(8)"));
	    Mainframe.put("dvContadeb", new StringValue("X(1)"));
	    Mainframe.put("pcRateiodeb", new StringValue("X(5)"));
	    Mainframe.put("vrRateiodeb", new StringValue("X(15)"));
	    
	    //Guia Eletronico
	    
	    
	    Mainframe.put("icAmbienteEle",new StringValue("X(1)"));
	    Mainframe.put("tpAplicacao",new StringValue("X(2)"));
	    Mainframe.put("dscAplicativo", new StringValue("X(20)"));
	    Mainframe.put("coVrsApl",new StringValue("X(6)"));
	    Mainframe.put("tpTran",new StringValue("X(3)"));
	    Mainframe.put("dscTran", new StringValue("X(20)"));
	    Mainframe.put("icPadraoEle", new StringValue("X(1)"));
	    Mainframe.put("sit", new StringValue("X(1)"));
	    Mainframe.put("icAtrVan",new StringValue("X(1)"));
	    Mainframe.put("vanE",new StringValue("X(2)"));
	    Mainframe.put("dscVan",new StringValue("X(20)"));
	    Mainframe.put("icJunRet", new StringValue("X(1)"));
	    Mainframe.put("cedJunc", new StringValue("X(7)"));
	    Mainframe.put("icRej",new StringValue("X(1)"));
	    Mainframe.put("icNot", new StringValue("X(1)"));
	    Mainframe.put("coApe", new StringValue("X(6)"));
	    Mainframe.put("coDsn", new StringValue("X(30)"));
	    Mainframe.put("icArqDup",new StringValue("X(1)"));
	    Mainframe.put("coCxPostal",new StringValue("X(5)"));
	    Mainframe.put("coApeDupl", new StringValue("X(6)"));
	    Mainframe.put("coDsnDup", new StringValue("X(30)"));
	    Mainframe.put("nuUltRem", new StringValue("X(8)"));
	    Mainframe.put("agrupEsc", new StringValue("X(6)"));
	    Mainframe.put("dscAgrup", new StringValue("X(20)"));
	    Mainframe.put("nuUltRet", new StringValue("X(8)"));
	    Mainframe.put("dtCargaIni", new StringValue("X(10)"));
	    Mainframe.put("connect", new StringValue("X(2)"));
	    Mainframe.put("deConnect", new StringValue("X(20)"));
	    Mainframe.put("situacao", new StringValue("X(20)"));
	    Mainframe.put("internet", new StringValue("X(2)"));
	    Mainframe.put("deInternet", new StringValue("X(20)"));
	    Mainframe.put("icReto", new StringValue("X(1)"));
	    Mainframe.put("nuUltReto", new StringValue("X(8)"));
	    
	    //---Guia Boletos
	    
	    Mainframe.put("tpEmisBloq", new StringValue("X(2)"));
	    Mainframe.put("deEmisBloq", new StringValue("X(20)"));
	    Mainframe.put("tpEntregaBloq", new StringValue("X(2)"));
	    Mainframe.put("deEntregaBloq", new StringValue("X(20)"));
	    Mainframe.put("tpEntregaSac", new StringValue("X(2)"));
	    Mainframe.put("deEntregaSac", new StringValue("X(20)"));
	    Mainframe.put("icAvisoVenc", new StringValue("X(1)"));
	    Mainframe.put("icAvisoProt", new StringValue("X(1)"));
	    Mainframe.put("vrMinAvis", new StringValue("X(15)"));
	    Mainframe.put("qtdDiasProt", new StringValue("X(3)"));
	    Mainframe.put("avisDisBloq1", new StringValue("X(3)"));
	    Mainframe.put("avisDisBloq2", new StringValue("X(3)"));
	    Mainframe.put("avisDisBloq3", new StringValue("X(3)"));
	    Mainframe.put("avisVenc1", new StringValue("X(3)"));
	    Mainframe.put("avisVenc2", new StringValue("X(3)"));
	    Mainframe.put("avisVenc3", new StringValue("X(3)"));
	    Mainframe.put("imprimeDDA", new StringValue("X(1)"));
	    Mainframe.put("icEnvioSms", new StringValue("X(1)"));
	    Mainframe.put("prazoSms1", new StringValue("X(3)"));
	    Mainframe.put("prazoSms2", new StringValue("X(3)"));
	    Mainframe.put("prazoSms3", new StringValue("X(3)"));
	    
	    // Guia tarifa
	    Mainframe.put("tipoPeriodo", new StringValue("X(1)"));
	    Mainframe.put("dePeriodo", new StringValue("X(20)"));
	    Mainframe.put("ddDebito", new StringValue("X(2)"));
	    Mainframe.put("icFormaCalculo", new StringValue("X(1)"));
	    
	    //Guia Parâmetro
	    Mainframe.put("tpCalc", new StringValue("X(2)"));
	    Mainframe.put("autVrCob", new StringValue("X(1)"));
	    Mainframe.put("garOpcrd", new StringValue("X(1)"));
	    Mainframe.put("bolExpresso", new StringValue("X(1)"));
	    Mainframe.put("limValor", new StringValue("X(1)"));
	    Mainframe.put("creOnline", new StringValue("X(1)"));
	    Mainframe.put("icClienteExterno", new StringValue("X(1)"));
	    Mainframe.put("icFimDfrd", new StringValue("X(1)"));
	    Mainframe.put("nuEvtContabil", new StringValue("X(6)"));
	    Mainframe.put("icUndCrdo", new StringValue("X(1)"));
	    Mainframe.put("icrateioTit", new StringValue("X(1)"));
	    Mainframe.put("icCedGarantia", new StringValue("X(1)"));
	    Mainframe.put("nuOpGarantia", new StringValue("X(4)"));
	    Mainframe.put("nuContratoGarantia", new StringValue("X(40)"));
	    Mainframe.put("icBaixaGar", new StringValue("X(1)"));
	    Mainframe.put("icMrcGar", new StringValue("X(1)"));
	    Mainframe.put("icDsmGar", new StringValue("X(1)"));
	    Mainframe.put("icContaGar", new StringValue("X(1)"));
	    Mainframe.put("nuUnidadeGar", new StringValue("X(4)"));
	    Mainframe.put("nuOpGar", new StringValue("X(4)"));
	    Mainframe.put("nuContagar", new StringValue("X(12)"));
	    Mainframe.put("nuDvGar", new StringValue("X(1)"));
	    Mainframe.put("icLncContabil", new StringValue("X(1)"));
	    Mainframe.put("nuEventoContabil", new StringValue("X(6)"));
	    Mainframe.put("icBolProposta", new StringValue("X(1)"));
	    Mainframe.put("icCmdDebito", new StringValue("X(1)"));
	    Mainframe.put("icCriticaCep", new StringValue("X(1)"));
	    //Campos novos

        
        Mainframe.put("icRemOnline", new StringValue("X(1)"));
	    Mainframe.put("icServicoWeb", new StringValue("X(1)"));
        Mainframe.put("qtdeBoleto", new StringValue("X(3)"));
	    Mainframe.put("vrMinimo", new StringValue("X(13)"));    
        Mainframe.put("vrMaximo", new StringValue("X(13)"));
	    Mainframe.put("tpBeneficiario", new StringValue("X(2)"));
        Mainframe.put("cdEntidadeSindical", new StringValue("X(6)"));
	    Mainframe.put("nuEventoContabilDebito", new StringValue("X(6)"));
        Mainframe.put("icAutorizaPgto", new StringValue("X(1)"));
	    Mainframe.put("icCalcIndice", new StringValue("X(1)"));
        Mainframe.put("sgIndiceEspecial", new StringValue("X(15)"));
	    Mainframe.put("icAplIndiceEspecial", new StringValue("X(2)"));
	       
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
    
    public static void main(String[] args) {
    }
}
