//Bean Alterado Manualmente
//as modificacoes estao indicadas

package br.gov.caixa.sigcb.bean;

import java.util.Date;

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
import br.com.politec.sao.util.Formatacao;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.util.Formatador;

/**
 * @author mauricio.holanda
 *
 */
public class TituloBean extends SigcbBean {
    private br.com.politec.sao.util.Money abatiAbatimento;

    private br.com.politec.sao.util.Money abatiCustasCartorarias;

    private java.util.Date abatiDataEmissao;

    private java.util.Date abatiDataEntrada;

    private java.util.Date abatiDataPrevisaoProtDev;

    private java.util.Date abatiDescontoDoisData;

    // private java.lang.Long abatiDescontoDoisPercen;
    private br.com.politec.sao.util.Percentual abatiDescontoDoisPercen;

    private java.lang.Long abatiDescontoDoisPrazo;

    private br.com.politec.sao.util.Money abatiDescontoDoisValor;

    private java.util.Date abatiDescontoTresData;

    // private java.lang.Long abatiDescontoTresPercen;
    private br.com.politec.sao.util.Percentual abatiDescontoTresPercen;

    private java.lang.Long abatiDescontoTresPrazo;

    private br.com.politec.sao.util.Money abatiDescontoTresValor;

    private java.util.Date abatiDescontoUmData;

    // private java.lang.Long abatiDescontoUmPercen;
    private br.com.politec.sao.util.Percentual abatiDescontoUmPercen;

    private java.lang.Long abatiDescontoUmPrazo;

    private br.com.politec.sao.util.Money abatiDescontoUmValor;

    private java.util.Date abatiJurosData;

    // private java.lang.Long abatiJurosPercen;
    private br.com.politec.sao.util.Percentual abatiJurosPercen;

    private br.com.politec.sao.util.Money abatiJurosValor;

    private java.lang.String abatiModalidade;

    private java.util.Date abatiMultaData;

    // private java.lang.Long abatiMultaPercen;
    private br.com.politec.sao.util.Percentual abatiMultaPercen;

    private java.lang.Long abatiMultaPrazo;

    private br.com.politec.sao.util.Money abatiMultaValor;
    
    private br.com.politec.sao.util.Money acoesDespesasCartorarias;

    private java.lang.String acoesHistorico;
    
    private java.lang.String nomeGrupo;

    private java.lang.Long acoesServicoTitulo;

    private br.com.politec.sao.util.Money acoesValorRecebido;

    private java.lang.String bloqCodigoBarrasFormatado;

    private java.lang.String bloqCodigoBarrasNumerico;

    private java.lang.String bloqDescricaoMensagem;

    private java.lang.Long bloqTipoMensagem;

    private java.lang.Long bloqDigitoCtrlNossoNumero;

    private java.util.Date princiDataDocumento;

    private java.util.Date blqexpdummyDataProcessamento;

    private java.lang.String princiModalidade;

    private java.lang.Long princiPvVinculacao;

    private java.lang.Long classificacao;

    private java.lang.String cobrarTarifa;

    private java.lang.Long codigoCedente;
    
    private java.lang.Long codigoProtocolo;

    private java.lang.String codigoUsuario;

    private br.com.politec.sao.util.Money compleAbatimento;

    private java.util.Date compleDescontoDoisData;

    // private java.lang.Long compleDescontoDoisPercen;
    private br.com.politec.sao.util.Percentual compleDescontoDoisPercen;

    private java.lang.Long compleDescontoDoisPrazo;

    private br.com.politec.sao.util.Money compleDescontoDoisValor;

    private java.util.Date compleDescontoTresData;

    // private java.lang.Long compleDescontoTresPercen;
    private br.com.politec.sao.util.Percentual compleDescontoTresPercen;

    private java.lang.Long compleDescontoTresPrazo;

    private br.com.politec.sao.util.Money compleDescontoTresValor;

    private java.util.Date compleDescontoUmData;

    // private java.lang.Long compleDescontoUmPercen;
    private br.com.politec.sao.util.Percentual compleDescontoUmPercen;

    private java.lang.Long compleDescontoUmPrazo;

    private br.com.politec.sao.util.Money compleDescontoUmValor;

    private java.util.Date compleMultaData;

    // private java.lang.Long compleMultaPercen;
    private br.com.politec.sao.util.Percentual compleMultaPercen;

    private java.lang.Long compleMultaPrazo;

    private br.com.politec.sao.util.Money compleMultaValor;

    // private java.lang.Long complePercenJurosMes;
    private br.com.politec.sao.util.Percentual complePercenJurosMes;

    private java.lang.Long compleSacadorCpfCnpj;

    private java.lang.String compleSacadorNome;

    private java.lang.Long compleSacadorTipoPessoa;

    private java.lang.Long compleTipoJurosMes;
    
    private java.lang.String comunicacaoSacado;
    
    private java.util.Date dataProtocolo;
    
    private java.util.Date dataSolicitacao;

    private java.lang.Long filtroVoltarListarConsolidado;

    private java.lang.Long filtroVoltarListarTitulo;

    private java.lang.Long filtroVoltarAcao;

    private java.lang.String filtroDescricaoClassificacao;

    private java.lang.String filtroDescricaoSituacao;

    private br.com.politec.sao.util.Money liquiAbatimento;

    private java.lang.String liquiCanalLiquidacao;

    private java.util.Date liquiDataCredito;

    private java.util.Date liquiDataLiquidacao;

    private java.util.Date liquiDataPagamento;

    private java.lang.Long liquiDiasFloat;

    private br.com.politec.sao.util.Money liquiValorLiquidoRecebido;

    private br.com.politec.sao.util.Money liquiValorDesconto;

    private br.com.politec.sao.util.Money liquiValorDocumento;

    private br.com.politec.sao.util.Money liquiValorJurosMulta;
    
    private br.com.politec.sao.util.Money retidoValorIOF;

    private java.lang.Long meioEntrada;

    private java.lang.Long nossoNumero;
    
    private java.lang.Long nossoNumeroFim;
    
    private java.lang.Long numeroCartorio;

    private java.util.Date ordProtDataMovimento;

    private java.lang.String princiAceite;

    private java.util.Date princiDataVencimento;

    private java.lang.String princiDescricaoAceite;

    private java.lang.String princiDescricaoEspecie;

    private java.lang.String princiDescricaoPvCobrador;

    private java.lang.String princiDescricaoSituacao;

    private java.lang.String princiEndosso;

    private java.lang.Long princiEspecie;

    private java.lang.String princiIndicadorProt;

    private java.lang.String princiMeioEntrada;

    private java.lang.Long princiMoeda;

    private java.lang.String princiNumeroDocumento;

    private java.lang.Long princiPrazoProtDev;

    private java.lang.Long princiPvCobrador;

    private java.lang.String princiSacadoBairro;

    private java.lang.Long princiSacadoCep;

    private java.lang.String princiSacadoComplemento;

    private java.lang.Long princiSacadoCpfCnpj;

    private java.lang.String princiSacadoEmail;

    private java.lang.String princiSacadoLogradouro;

    private java.lang.String princiSacadoMunicipio;

    private java.lang.String princiSacadoNome;

    private java.lang.String princiSacadoNumero;

    private java.lang.Long princiSacadoTipoPessoa;

    private java.lang.String princiSacadoUf;

    private java.lang.String princiSiglaEspecie;

    private java.lang.Long princiSituacao;

    private br.com.politec.sao.util.Money princiValorTitulo;

    private java.lang.Long filtroSelecao;

    private java.lang.Long situacao;
    
    private java.lang.Long unidadeCobradora;
    
    private java.lang.Long pagina;

    // Item 6 SISOL 147829
    private java.lang.Long emissaoBloqueto;

    private java.lang.Long envioBloqueto;
    
    //DDA SIGCB
    
    private java.lang.String situacaoBloqSE;
    
    private java.lang.Long numIdDDA;
    
    private java.lang.Long aceiteSE;
    
    private java.lang.String alegacaoSE;
    
    //IOF
    private br.com.politec.sao.util.Money compleRetidoValorIOF;
    private br.com.politec.sao.util.Money abatiRetidoValorIOF;
  
    private String tipoCalculo;
    
    private String autorizacao;
    
    private String iofAtraso;
    
    private String iofAtraso61;
    
    private br.com.politec.sao.util.Money jurosAtraso;
    
    private br.com.politec.sao.util.Money jurosAtrasoMora;
    
    private String feriadoLocal;
    
    private String pvRecebedor;
    
    private String pvCobrador;
    
    private String dddSMS;
    
    private String celularSMS;
    
    private String tipoSMS;
    
    private String filler;
    
    private String descrEntrega;
    
    private String icRateio;
    
    /*
    03 S060-IC-GARANTIA-CRDTO          PIC  X(001).   ===> S ou N
    03 S060-DT-GARANTIA-CRDTO          PIC  X(010).   ===> DD.MM.AAAA
    03 S060-CO-USUARIO-GRNTA           PIC  X(008). 
	*/
    
    private String icGarantia;
    private String dtGarantia;
    private String coUsuario;
    
    private Date dataInicio;
    private Date dataFim;
    
    private Long fatorVencimento;
    private Long formaPagamento;
    private Long nsu;
    private String codBarras1;
    private String codBarras2;
    private String codBarras3;
    private String codBarras4;
    private String codBarras5;
    private String motivo;
    private String observacoes;
    
    private Long nossoNumeroLiq;
    
    private String tipoAcao;
    private Long meio;
    
    private String descrMeio;
    private String descrFormaPagamento;
    private String descrMotivo;
    private String descrSituacao;
    private String coErro;
    private String deErro;
    
 	private String parcela;

 	//----------Versao 61 
 	

 	private String icRegistroCIP;
 	private Long nuIdentificaCIP;
 	private Long nuRefereciaCIP;
 	private String sgIndexador;
 	private String icTipoPagamento;
 	private Money vrMaximoPgto;
 	private Money vrMinPgto;
 	private String icAutPagto;
 	private Long qtPgtoPossivel;
 	private Long qtPgtoEfetuado;
 	private Money vrSaldoTitulo;
 	
 	private String cmbEmissao;
 	private String cmbCarteira;
 	private Long nuBaixa;
 	
 	private String coErroCIP;
 	
 	private String dtCompetencia;
 	
 	private String  tipoDesconto;
 	private Money valorJuros;
 	private Date datajuros;
 	private String tipoJuros;
 	
 	private String tpPessoaPrt;
 	private String cpfCnpjPrt;

 	private Money vrDesAba;
 	private Money vrMltJur ;
 	private Money vrJuros  ;
 	private Money vrIof ;
 	private Money vrMulta  ;
 	private Money vrDesconto ;
 	private Money vrAbatimento ;
 	private Money vrCalculado ;
 	private Money vrCobrado ;
 	
 	private String snBaixa;
    
 	private String controle;
 	
 	private String fixo;
 	
 	
    public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public String getControle() {
		return controle;
	}

	public void setControle(String controle) {
		this.controle = controle;
	}

	public TituloBean() {
        this.abatiAbatimento = null;
        this.abatiCustasCartorarias = null;
        this.abatiDataEmissao = null;
        this.abatiDataEntrada = null;
        this.abatiDataPrevisaoProtDev = null;
        this.abatiDescontoDoisData = null;
        this.abatiDescontoDoisPercen = null;
        this.abatiDescontoDoisPrazo = null;
        this.abatiDescontoDoisValor = null;
        this.abatiDescontoTresData = null;
        this.abatiDescontoTresPercen = null;
        this.abatiDescontoTresPrazo = null;
        this.abatiDescontoTresValor = null;
        this.abatiDescontoUmData = null;
        this.abatiDescontoUmPercen = null;
        this.abatiDescontoUmPrazo = null;
        this.abatiDescontoUmValor = null;
        this.abatiJurosData = null;
        this.abatiJurosPercen = null;
        this.abatiJurosValor = null;
        this.abatiModalidade = null;
        this.abatiMultaData = null;
        this.abatiMultaPercen = null;
        this.abatiMultaPrazo = null;
        this.abatiMultaValor = null;
        this.acoesDespesasCartorarias = null;
        this.acoesHistorico = null;
        this.nomeGrupo = null;
        this.acoesServicoTitulo = null;
        this.acoesValorRecebido = null;
        this.bloqCodigoBarrasFormatado = null;
        this.bloqCodigoBarrasNumerico = null;
        this.bloqDescricaoMensagem = null;
        this.bloqTipoMensagem = null;
        this.bloqDigitoCtrlNossoNumero = null;
        this.princiDataDocumento = null;
        this.blqexpdummyDataProcessamento = null;
        this.princiModalidade = null;
        this.princiPvVinculacao = null;
        this.classificacao = null;
        this.cobrarTarifa = null;
        this.codigoCedente = null;
        this.codigoProtocolo = null;
        this.codigoUsuario = null;
        this.compleAbatimento = null;
        this.compleDescontoDoisData = null;
        this.compleDescontoDoisPercen = null;
        this.compleDescontoDoisPrazo = null;
        this.compleDescontoDoisValor = null;
        this.compleDescontoTresData = null;
        this.compleDescontoTresPercen = null;
        this.compleDescontoTresPrazo = null;
        this.compleDescontoTresValor = null;
        this.compleDescontoUmData = null;
        this.compleDescontoUmPercen = null;
        this.compleDescontoUmPrazo = null;
        this.compleDescontoUmValor = null;
        this.compleMultaData = null;
        this.compleMultaPercen = null;
        this.compleMultaPrazo = null;
        this.compleMultaValor = null;
        this.complePercenJurosMes = null;
        this.compleSacadorCpfCnpj = null;
        this.compleSacadorNome = null;
        this.compleSacadorTipoPessoa = null;
        this.compleTipoJurosMes = null;
        this.comunicacaoSacado = null;
        this.dataProtocolo = null;
        this.dataSolicitacao = null;
        this.filtroVoltarListarTitulo = null;
        this.filtroVoltarListarConsolidado = null;
        this.filtroVoltarAcao = null;
        this.filtroDescricaoClassificacao = null;
        this.filtroDescricaoSituacao = null;
        this.liquiAbatimento = null;
        this.liquiCanalLiquidacao = null;
        this.liquiDataCredito = null;
        this.liquiDataLiquidacao = null;
        this.liquiDataPagamento = null;
        this.liquiDiasFloat = null;
        this.liquiValorLiquidoRecebido = null;
        this.retidoValorIOF = null;
        this.liquiValorDesconto = null;
        this.liquiValorDocumento = null;
        this.liquiValorJurosMulta = null;
        this.meioEntrada = null;
        this.nossoNumero = null;
        this.numeroCartorio = null;
        this.ordProtDataMovimento = null;
        this.princiAceite = null;
        this.princiDataVencimento = null;
        this.princiDescricaoAceite = null;
        this.princiDescricaoEspecie = null;
        this.princiDescricaoPvCobrador = null;
        this.princiDescricaoSituacao = null;
        this.princiEndosso = null;
        this.princiEspecie = null;
        this.princiIndicadorProt = null;
        this.princiMeioEntrada = null;
        this.princiMoeda = null;
        this.princiNumeroDocumento = null;
        this.princiPrazoProtDev = null;
        this.princiPvCobrador = null;
        this.princiSacadoBairro = null;
        this.princiSacadoCep = null;
        this.princiSacadoComplemento = null;
        this.princiSacadoCpfCnpj = null;
        this.princiSacadoEmail = null;
        this.princiSacadoLogradouro = null;
        this.princiSacadoMunicipio = null;
        this.princiSacadoNome = null;
        this.princiSacadoNumero = null;
        this.princiSacadoTipoPessoa = null;
        this.princiSacadoUf = null;
        this.princiSiglaEspecie = null;
        this.princiSituacao = null;
        this.princiValorTitulo = null;
        this.filtroSelecao = null;
        this.situacao = null;
        this.unidadeCobradora = null;
        this.pagina = null;

        // Item 6 SISOL 147829
        this.emissaoBloqueto = null;
        this.envioBloqueto = null;
        
        //DDA SIGCB
        this.situacaoBloqSE = null;
        this.numIdDDA = null;
        this.aceiteSE = null;
        this.alegacaoSE = null;
        
        //IOF
        this.compleRetidoValorIOF = null;
        this.abatiRetidoValorIOF = null;
        
        this.tipoCalculo=null;
        this.autorizacao=null;
        
        //atraso
        this.iofAtraso=null;
        this.iofAtraso61=null;
        this.jurosAtraso=null;
        
        this.feriadoLocal=null;
        this.pvCobrador=null;
        this.pvRecebedor=null;
        
        //SMS
        this.dddSMS=null;
        this.celularSMS=null;
        this.tipoSMS=null;
        
        this.filler=null;
        
        this.descrEntrega = null;
        
        this.icRateio = null;
        
        this.nossoNumeroFim = null;
        
        this.icGarantia=null;
        this.dtGarantia=null;
        this.coUsuario=null;
        this.dataInicio=null;
        this.dataFim=null;
        this.fatorVencimento=null;
        this.formaPagamento=null;
        this.nsu=null;
        this.codBarras1=null;
        this.codBarras2=null;
        this.codBarras3=null;
        this.codBarras4=null;
        this.codBarras5=null;
        this.motivo = null;
        this.observacoes=null;
        this.nossoNumeroLiq=null;
        this.tipoAcao=null;
        this.meio = null;
        this.descrMeio=null;
        this.descrFormaPagamento=null;
        this.descrMotivo=null;
        this.descrSituacao=null;
        this.coErro=null;
        this.deErro=null;
		this.parcela=null;
		

	 	this.icRegistroCIP=null;
	 	this.nuIdentificaCIP=null;
	 	this.nuRefereciaCIP=null;
	 	this.sgIndexador=null;
	 	this.icTipoPagamento=null;
	 	this.vrMaximoPgto=null;
	 	this.vrMinPgto=null;
	 	this.icAutPagto=null;
	 	this.qtPgtoPossivel=null;
	 	this.qtPgtoEfetuado=null;
	 	this.vrSaldoTitulo=null;
	 	this.cmbEmissao=null;
	 	this.cmbCarteira=null;
	 	this.nuBaixa=null;
	 	this.coErroCIP=null;
	 	this.dtCompetencia=null;
	 	
		this.tipoDesconto=null;
	 	this.valorJuros=null;
	 	this.datajuros=null;
	 	this.tipoJuros=null;
	 	this.jurosAtrasoMora=null;
	 	
	 	this.tpPessoaPrt=null;
	 	this.cpfCnpjPrt=null;
	 	
	 	this.vrDesAba=null;
	 	this.vrMltJur=null;
	 	this.vrJuros=null;
	 	this.vrIof=null;
	 	this.vrMulta=null;
	 	this.vrDesconto=null;
	 	this.vrAbatimento=null;
	 	this.vrCalculado=null;
	 	this.vrCobrado=null;
	 	
	 	this.snBaixa=null;
	 	
	 	this.fixo=null;
    }

    public String getApplicationName() {
        return "TituloBean";
    }




	public String getSnBaixa() {
		return snBaixa;
	}

	public void setSnBaixa(String snBaixa) {
		this.snBaixa = snBaixa;
	}

	public Money getVrDesAba() {
		return vrDesAba;
	}

	public void setVrDesAba(Money vrDesAba) {
		this.vrDesAba = vrDesAba;
	}

	public Money getVrMltJur() {
		return vrMltJur;
	}

	public void setVrMltJur(Money vrMltJur) {
		this.vrMltJur = vrMltJur;
	}

	public Money getVrJuros() {
		return vrJuros;
	}

	public void setVrJuros(Money vrJuros) {
		this.vrJuros = vrJuros;
	}

	public Money getVrIof() {
		return vrIof;
	}

	public void setVrIof(Money vrIof) {
		this.vrIof = vrIof;
	}

	public Money getVrMulta() {
		return vrMulta;
	}

	public void setVrMulta(Money vrMulta) {
		this.vrMulta = vrMulta;
	}

	public Money getVrDesconto() {
		return vrDesconto;
	}

	public void setVrDesconto(Money vrDesconto) {
		this.vrDesconto = vrDesconto;
	}

	public Money getVrAbatimento() {
		return vrAbatimento;
	}

	public void setVrAbatimento(Money vrAbatimento) {
		this.vrAbatimento = vrAbatimento;
	}

	public Money getVrCalculado() {
		return vrCalculado;
	}

	public void setVrCalculado(Money vrCalculado) {
		this.vrCalculado = vrCalculado;
	}

	public Money getVrCobrado() {
		return vrCobrado;
	}

	public void setVrCobrado(Money vrCobrado) {
		this.vrCobrado = vrCobrado;
	}

	public String getTpPessoaPrt() {
		return tpPessoaPrt;
	}

	public void setTpPessoaPrt(String tpPessoaPrt) {
		this.tpPessoaPrt = tpPessoaPrt;
	}

	public String getCpfCnpjPrt() {
		return cpfCnpjPrt;
	}

	public void setCpfCnpjPrt(String cpfCnpjPrt) {
		this.cpfCnpjPrt = cpfCnpjPrt;
	}

	public br.com.politec.sao.util.Money getJurosAtrasoMora() {
		return jurosAtrasoMora;
	}

	public void setJurosAtrasoMora(br.com.politec.sao.util.Money jurosAtrasoMora) {
		this.jurosAtrasoMora = jurosAtrasoMora;
	}

	public String getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public Money getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(Money valorJuros) {
		this.valorJuros = valorJuros;
	}



	public Date getDatajuros() {
		return datajuros;
	}

	public void setDatajuros(Date datajuros) {
		this.datajuros = datajuros;
	}

	public String getTipoJuros() {
		return tipoJuros;
	}

	public void setTipoJuros(String tipoJuros) {
		this.tipoJuros = tipoJuros;
	}

	public String getDtCompetencia() {
		return dtCompetencia;
	}

	public void setDtCompetencia(String dtCompetencia) {
		this.dtCompetencia = dtCompetencia;
	}

	public String getCoErroCIP() {
		return coErroCIP;
	}

	public void setCoErroCIP(String coErroCIP) {
		this.coErroCIP = coErroCIP;
	}

	public String getCmbEmissao() {
		return cmbEmissao;
	}

	public void setCmbEmissao(String cmbEmissao) {
		this.cmbEmissao = cmbEmissao;
	}

	public String getCmbCarteira() {
		return cmbCarteira;
	}

	public void setCmbCarteira(String cmbCarteira) {
		this.cmbCarteira = cmbCarteira;
	}

	public String getIcRegistroCIP() {
		return icRegistroCIP;
	}

	public void setIcRegistroCIP(String icRegistroCIP) {
		this.icRegistroCIP = icRegistroCIP;
	}

	public Long getNuIdentificaCIP() {
		return nuIdentificaCIP;
	}

	public void setNuIdentificaCIP(Long nuIdentificaCIP) {
		this.nuIdentificaCIP = nuIdentificaCIP;
	}

	public Long getNuRefereciaCIP() {
		return nuRefereciaCIP;
	}

	public void setNuRefereciaCIP(Long nuRefereciaCIP) {
		this.nuRefereciaCIP = nuRefereciaCIP;
	}

	public String getSgIndexador() {
		return sgIndexador;
	}

	public void setSgIndexador(String sgIndexador) {
		this.sgIndexador = sgIndexador;
	}

	public String getIcTipoPagamento() {
		return icTipoPagamento;
	}

	public void setIcTipoPagamento(String icTipoPagamento) {
		this.icTipoPagamento = icTipoPagamento;
	}

	public Money getVrMaximoPgto() {
		return vrMaximoPgto;
	}

	public void setVrMaximoPgto(Money vrMaximoPgto) {
		this.vrMaximoPgto = vrMaximoPgto;
	}

	public Money getVrMinPgto() {
		return vrMinPgto;
	}

	public void setVrMinPgto(Money vrMinPgto) {
		this.vrMinPgto = vrMinPgto;
	}

	public String getIcAutPagto() {
		return icAutPagto;
	}

	public void setIcAutPagto(String icAutPagto) {
		this.icAutPagto = icAutPagto;
	}

	public Long getQtPgtoPossivel() {
		return qtPgtoPossivel;
	}

	public void setQtPgtoPossivel(Long qtPgtoPossivel) {
		this.qtPgtoPossivel = qtPgtoPossivel;
	}

	public Long getQtPgtoEfetuado() {
		return qtPgtoEfetuado;
	}

	public void setQtPgtoEfetuado(Long qtPgtoEfetuado) {
		this.qtPgtoEfetuado = qtPgtoEfetuado;
	}

	public Money getVrSaldoTitulo() {
		return vrSaldoTitulo;
	}

	public void setVrSaldoTitulo(Money vrSaldoTitulo) {
		this.vrSaldoTitulo = vrSaldoTitulo;
	}

	public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public String getDescrMeio() {
		return descrMeio;
	}

	public void setDescrMeio(String descrMeio) {
		this.descrMeio = descrMeio;
	}

	public String getDescrFormaPagamento() {
		return descrFormaPagamento;
	}

	public void setDescrFormaPagamento(String descrFormaPagamento) {
		this.descrFormaPagamento = descrFormaPagamento;
	}

	public String getDescrMotivo() {
		return descrMotivo;
	}

	public void setDescrMotivo(String descrMotivo) {
		this.descrMotivo = descrMotivo;
	}

	public String getDescrSituacao() {
		return descrSituacao;
	}

	public void setDescrSituacao(String descrSituacao) {
		this.descrSituacao = descrSituacao;
	}

	public String getCoErro() {
		return coErro;
	}

	public void setCoErro(String coErro) {
		this.coErro = coErro;
	}

	public String getDeErro() {
		return deErro;
	}

	public void setDeErro(String deErro) {
		this.deErro = deErro;
	}

	public Long getMeio() {
		return meio;
	}

	public void setMeio(Long meio) {
		this.meio = meio;
	}

	public String getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}



	

	public String getCodBarras1() {
		return codBarras1;
	}

	public String getCodBarras2() {
		return codBarras2;
	}

	public void setCodBarras2(String codBarras2) {
		this.codBarras2 = codBarras2;
	}

	public String getCodBarras3() {
		return codBarras3;
	}

	public void setCodBarras3(String codBarras3) {
		this.codBarras3 = codBarras3;
	}

	public String getCodBarras4() {
		return codBarras4;
	}

	public void setCodBarras4(String codBarras4) {
		this.codBarras4 = codBarras4;
	}

	public String getCodBarras5() {
		return codBarras5;
	}

	public void setCodBarras5(String codBarras5) {
		this.codBarras5 = codBarras5;
	}

	public void setCodBarras1(String codBarras1) {
		this.codBarras1 = codBarras1;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getDddSMS() {
		return dddSMS;
	}

	public void setDddSMS(String dddSMS) {
		this.dddSMS = dddSMS;
	}

	public String getCelularSMS() {
		return celularSMS;
	}

	public void setCelularSMS(String celularSMS) {
		this.celularSMS = celularSMS;
	}



	public Long getNossoNumeroLiq() {
		return nossoNumeroLiq;
	}

	public void setNossoNumeroLiq(Long nossoNumeroLiq) {
		this.nossoNumeroLiq = nossoNumeroLiq;
	}

	public String getTipoSMS() {
		return tipoSMS;
	}

	public void setTipoSMS(String tipoSMS) {
		this.tipoSMS = tipoSMS;
	}

	public String getPvRecebedor() {
		return pvRecebedor;
	}

	public void setPvRecebedor(String pvRecebedor) {
		this.pvRecebedor = pvRecebedor;
	}

	public String getPvCobrador() {
		return pvCobrador;
	}

	public void setPvCobrador(String pvCobrador) {
		this.pvCobrador = pvCobrador;
	}

	public br.com.politec.sao.util.Money getAbatiAbatimento() {
        return this.abatiAbatimento;
    }

    public void setAbatiAbatimento(br.com.politec.sao.util.Money abatiAbatimento) {
        this.abatiAbatimento = abatiAbatimento;
    }

    public br.com.politec.sao.util.Money getAbatiCustasCartorarias() {
        return this.abatiCustasCartorarias;
    }

    public void setAbatiCustasCartorarias(br.com.politec.sao.util.Money abatiCustasCartorarias) {
        this.abatiCustasCartorarias = abatiCustasCartorarias;
    }

    public java.util.Date getAbatiDataEmissao() {
        return this.abatiDataEmissao;
    }

    public void setAbatiDataEmissao(java.util.Date abatiDataEmissao) {
        this.abatiDataEmissao = abatiDataEmissao;
    }

    public java.util.Date getAbatiDataEntrada() {
        return this.abatiDataEntrada;
    }

    public void setAbatiDataEntrada(java.util.Date abatiDataEntrada) {
        this.abatiDataEntrada = abatiDataEntrada;
    }

    public java.util.Date getAbatiDataPrevisaoProtDev() {
        return this.abatiDataPrevisaoProtDev;
    }

    public void setAbatiDataPrevisaoProtDev(java.util.Date abatiDataPrevisaoProtDev) {
        this.abatiDataPrevisaoProtDev = abatiDataPrevisaoProtDev;
    }

    public java.util.Date getAbatiDescontoDoisData() {
        return this.abatiDescontoDoisData;
    }

    public void setAbatiDescontoDoisData(java.util.Date abatiDescontoDoisData) {
        this.abatiDescontoDoisData = abatiDescontoDoisData;
    }

    // public java.lang.Long getAbatiDescontoDoisPercen() {
    public br.com.politec.sao.util.Percentual getAbatiDescontoDoisPercen() {
        return this.abatiDescontoDoisPercen;
    }

    // public void setAbatiDescontoDoisPercen(java.lang.Long
    // abatiDescontoDoisPercen) {
    public void setAbatiDescontoDoisPercen(br.com.politec.sao.util.Percentual abatiDescontoDoisPercen) {
        this.abatiDescontoDoisPercen = abatiDescontoDoisPercen;
    }

    public java.lang.Long getAbatiDescontoDoisPrazo() {
        return this.abatiDescontoDoisPrazo;
    }

    public void setAbatiDescontoDoisPrazo(java.lang.Long abatiDescontoDoisPrazo) {
        this.abatiDescontoDoisPrazo = abatiDescontoDoisPrazo;
    }

    public br.com.politec.sao.util.Money getAbatiDescontoDoisValor() {
        return this.abatiDescontoDoisValor;
    }

    public void setAbatiDescontoDoisValor(br.com.politec.sao.util.Money abatiDescontoDoisValor) {
        this.abatiDescontoDoisValor = abatiDescontoDoisValor;
    }

    public java.util.Date getAbatiDescontoTresData() {
        return this.abatiDescontoTresData;
    }

    public void setAbatiDescontoTresData(java.util.Date abatiDescontoTresData) {
        this.abatiDescontoTresData = abatiDescontoTresData;
    }

    // public java.lang.Long getAbatiDescontoTresPercen() {
    public br.com.politec.sao.util.Percentual getAbatiDescontoTresPercen() {
        return this.abatiDescontoTresPercen;
    }

    // public void setAbatiDescontoTresPercen(java.lang.Long
    // abatiDescontoTresPercen) {
    public void setAbatiDescontoTresPercen(br.com.politec.sao.util.Percentual abatiDescontoTresPercen) {
        this.abatiDescontoTresPercen = abatiDescontoTresPercen;
    }

    public java.lang.Long getAbatiDescontoTresPrazo() {
        return this.abatiDescontoTresPrazo;
    }

    public void setAbatiDescontoTresPrazo(java.lang.Long abatiDescontoTresPrazo) {
        this.abatiDescontoTresPrazo = abatiDescontoTresPrazo;
    }

    public br.com.politec.sao.util.Money getAbatiDescontoTresValor() {
        return this.abatiDescontoTresValor;
    }

    public void setAbatiDescontoTresValor(br.com.politec.sao.util.Money abatiDescontoTresValor) {
        this.abatiDescontoTresValor = abatiDescontoTresValor;
    }

    public java.util.Date getAbatiDescontoUmData() {
        return this.abatiDescontoUmData;
    }

    public void setAbatiDescontoUmData(java.util.Date abatiDescontoUmData) {
        this.abatiDescontoUmData = abatiDescontoUmData;
    }

    // public java.lang.Long getAbatiDescontoUmPercen() {
    public br.com.politec.sao.util.Percentual getAbatiDescontoUmPercen() {
        return this.abatiDescontoUmPercen;
    }

    // public void setAbatiDescontoUmPercen(java.lang.Long
    // abatiDescontoUmPercen) {
    public void setAbatiDescontoUmPercen(br.com.politec.sao.util.Percentual abatiDescontoUmPercen) {
        this.abatiDescontoUmPercen = abatiDescontoUmPercen;
    }

    public java.lang.Long getAbatiDescontoUmPrazo() {
        return this.abatiDescontoUmPrazo;
    }

    public void setAbatiDescontoUmPrazo(java.lang.Long abatiDescontoUmPrazo) {
        this.abatiDescontoUmPrazo = abatiDescontoUmPrazo;
    }

    public br.com.politec.sao.util.Money getAbatiDescontoUmValor() {
        return this.abatiDescontoUmValor;
    }

    public void setAbatiDescontoUmValor(br.com.politec.sao.util.Money abatiDescontoUmValor) {
        this.abatiDescontoUmValor = abatiDescontoUmValor;
    }

    public java.util.Date getAbatiJurosData() {
        return this.abatiJurosData;
    }

    public void setAbatiJurosData(java.util.Date abatiJurosData) {
        this.abatiJurosData = abatiJurosData;
    }

    // public java.lang.Long getAbatiJurosPercen() {
    public br.com.politec.sao.util.Percentual getAbatiJurosPercen() {
        return this.abatiJurosPercen;
    }

    // public void setAbatiJurosPercen(java.lang.Long abatiJurosPercen) {
    public void setAbatiJurosPercen(br.com.politec.sao.util.Percentual abatiJurosPercen) {
        this.abatiJurosPercen = abatiJurosPercen;
    }

    public br.com.politec.sao.util.Money getAbatiJurosValor() {
        return this.abatiJurosValor;
    }

    public void setAbatiJurosValor(br.com.politec.sao.util.Money abatiJurosValor) {
        this.abatiJurosValor = abatiJurosValor;
    }

    public java.lang.String getAbatiModalidade() {
        return this.abatiModalidade;
    }

    public void setAbatiModalidade(java.lang.String abatiModalidade) {
        this.abatiModalidade = abatiModalidade;
    }

    public java.util.Date getAbatiMultaData() {
        return this.abatiMultaData;
    }

    public void setAbatiMultaData(java.util.Date abatiMultaData) {
        this.abatiMultaData = abatiMultaData;
    }

    // public java.lang.Long getAbatiMultaPercen() {
    public br.com.politec.sao.util.Percentual getAbatiMultaPercen() {
        return this.abatiMultaPercen;
    }

    // public void setAbatiMultaPercen(java.lang.Long abatiMultaPercen) {
    public void setAbatiMultaPercen(br.com.politec.sao.util.Percentual abatiMultaPercen) {
        this.abatiMultaPercen = abatiMultaPercen;
    }

    public java.lang.Long getAbatiMultaPrazo() {
        return this.abatiMultaPrazo;
    }

    public void setAbatiMultaPrazo(java.lang.Long abatiMultaPrazo) {
        this.abatiMultaPrazo = abatiMultaPrazo;
    }

    public br.com.politec.sao.util.Money getAbatiMultaValor() {
        return this.abatiMultaValor;
    }

    public void setAbatiMultaValor(br.com.politec.sao.util.Money abatiMultaValor) {
        this.abatiMultaValor = abatiMultaValor;
    }

    public br.com.politec.sao.util.Money getAcoesDespesasCartorarias() {
        return this.acoesDespesasCartorarias;
    }

    public void setAcoesDespesasCartorarias(br.com.politec.sao.util.Money acoesDespesasCartorarias) {
        this.acoesDespesasCartorarias = acoesDespesasCartorarias;
    }

    public java.lang.String getAcoesHistorico() {
        return this.acoesHistorico;
    }

    public void setAcoesHistorico(java.lang.String acoesHistorico) {
        this.acoesHistorico = acoesHistorico;
    }
    
    public java.lang.String getNomeGrupo() {
        return this.nomeGrupo;
    }

    public void setNomeGrupo(java.lang.String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public java.lang.Long getAcoesServicoTitulo() {
        return this.acoesServicoTitulo;
    }

    public void setAcoesServicoTitulo(java.lang.Long acoesServicoTitulo) {
        this.acoesServicoTitulo = acoesServicoTitulo;
    }

    public br.com.politec.sao.util.Money getAcoesValorRecebido() {
        return this.acoesValorRecebido;
    }

    public void setAcoesValorRecebido(br.com.politec.sao.util.Money acoesValorRecebido) {
        this.acoesValorRecebido = acoesValorRecebido;
    }

    public java.lang.String getBloqCodigoBarrasFormatado() {
        return this.bloqCodigoBarrasFormatado;
    }

    public void setBloqCodigoBarrasFormatado(java.lang.String bloqCodigoBarrasFormatado) {
        this.bloqCodigoBarrasFormatado = bloqCodigoBarrasFormatado;
    }

    public java.lang.String getBloqCodigoBarrasNumerico() {
        return this.bloqCodigoBarrasNumerico;
    }

    public void setBloqCodigoBarrasNumerico(java.lang.String bloqCodigoBarrasNumerico) {
        this.bloqCodigoBarrasNumerico = bloqCodigoBarrasNumerico;
    }

    public java.lang.String getBloqDescricaoMensagem() {
        return this.bloqDescricaoMensagem;
    }

    public void setBloqDescricaoMensagem(java.lang.String bloqDescricaoMensagem) {
        this.bloqDescricaoMensagem = bloqDescricaoMensagem;
    }

    public java.lang.Long getBloqTipoMensagem() {
        return this.bloqTipoMensagem;
    }

    public Long getNuBaixa() {
		return nuBaixa;
	}

	public void setNuBaixa(Long nuBaixa) {
		this.nuBaixa = nuBaixa;
	}

	public void setBloqTipoMensagem(java.lang.Long bloqTipoMensagem) {
        this.bloqTipoMensagem = bloqTipoMensagem;
    }

    public java.lang.Long getBloqDigitoCtrlNossoNumero() {
        return this.bloqDigitoCtrlNossoNumero;
    }

    public void setBloqDigitoCtrlNossoNumero(java.lang.Long bloqDigitoCtrlNossoNumero) {
        this.bloqDigitoCtrlNossoNumero = bloqDigitoCtrlNossoNumero;
    }

    public java.util.Date getPrinciDataDocumento() {
        return this.princiDataDocumento;
    }

    public void setPrinciDataDocumento(java.util.Date blqexpdummyDataDocumento) {
        this.princiDataDocumento = blqexpdummyDataDocumento;
    }

    public java.util.Date getBlqexpdummyDataProcessamento() {
        return this.blqexpdummyDataProcessamento;
    }

    public void setBlqexpdummyDataProcessamento(java.util.Date blqexpdummyDataProcessamento) {
        this.blqexpdummyDataProcessamento = blqexpdummyDataProcessamento;
    }

    public java.lang.String getPrinciModalidade() {
        return this.princiModalidade;
    }

    public void setPrinciModalidade(java.lang.String blqexpdummyModalidade) {
        this.princiModalidade = blqexpdummyModalidade;
    }

    public java.lang.Long getPrinciPvVinculacao() {
        return this.princiPvVinculacao;
    }

    public void setPrinciPvVinculacao(java.lang.Long blqexpdummyPvVinculacao) {
        this.princiPvVinculacao = blqexpdummyPvVinculacao;
    }

    public java.lang.Long getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(java.lang.Long classificacao) {
        this.classificacao = classificacao;
    }

    public java.lang.String getCobrarTarifa() {
        return this.cobrarTarifa;
    }

    public void setCobrarTarifa(java.lang.String cobrarTarifa) {
        this.cobrarTarifa = cobrarTarifa;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }
    
    public java.lang.Long getCodigoProtocolo() {
		return codigoProtocolo;
	}

	public void setCodigoProtocolo(java.lang.Long codigoProtocolo) {
		this.codigoProtocolo = codigoProtocolo;
	}

	public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public br.com.politec.sao.util.Money getCompleAbatimento() {
        return this.compleAbatimento;
    }

    public void setCompleAbatimento(br.com.politec.sao.util.Money compleAbatimento) {
        this.compleAbatimento = compleAbatimento;
    }

    public java.util.Date getCompleDescontoDoisData() {
        return this.compleDescontoDoisData;
    }

    public void setCompleDescontoDoisData(java.util.Date compleDescontoDoisData) {
        this.compleDescontoDoisData = compleDescontoDoisData;
    }

    // public java.lang.Long getCompleDescontoDoisPercen() {
    public br.com.politec.sao.util.Percentual getCompleDescontoDoisPercen() {
        return this.compleDescontoDoisPercen;
    }

    // public void setCompleDescontoDoisPercen(java.lang.Long
    // compleDescontoDoisPercen) {
    public void setCompleDescontoDoisPercen(br.com.politec.sao.util.Percentual compleDescontoDoisPercen) {
        this.compleDescontoDoisPercen = compleDescontoDoisPercen;
    }

    public java.lang.Long getCompleDescontoDoisPrazo() {
        return this.compleDescontoDoisPrazo;
    }

    public void setCompleDescontoDoisPrazo(java.lang.Long compleDescontoDoisPrazo) {
        this.compleDescontoDoisPrazo = compleDescontoDoisPrazo;
    }

    public br.com.politec.sao.util.Money getCompleDescontoDoisValor() {
        return this.compleDescontoDoisValor;
    }

    public void setCompleDescontoDoisValor(br.com.politec.sao.util.Money compleDescontoDoisValor) {
        this.compleDescontoDoisValor = compleDescontoDoisValor;
    }

    public java.util.Date getCompleDescontoTresData() {
        return this.compleDescontoTresData;
    }

    public void setCompleDescontoTresData(java.util.Date compleDescontoTresData) {
        this.compleDescontoTresData = compleDescontoTresData;
    }

    // public java.lang.Long getCompleDescontoTresPercen() {
    public br.com.politec.sao.util.Percentual getCompleDescontoTresPercen() {
        return this.compleDescontoTresPercen;
    }

    // public void setCompleDescontoTresPercen(java.lang.Long
    // compleDescontoTresPercen) {
    public void setCompleDescontoTresPercen(br.com.politec.sao.util.Percentual compleDescontoTresPercen) {
        this.compleDescontoTresPercen = compleDescontoTresPercen;
    }

    public java.lang.Long getCompleDescontoTresPrazo() {
        return this.compleDescontoTresPrazo;
    }

    public void setCompleDescontoTresPrazo(java.lang.Long compleDescontoTresPrazo) {
        this.compleDescontoTresPrazo = compleDescontoTresPrazo;
    }

    public br.com.politec.sao.util.Money getCompleDescontoTresValor() {
        return this.compleDescontoTresValor;
    }

    public void setCompleDescontoTresValor(br.com.politec.sao.util.Money compleDescontoTresValor) {
        this.compleDescontoTresValor = compleDescontoTresValor;
    }

    public java.util.Date getCompleDescontoUmData() {
        return this.compleDescontoUmData;
    }

    public void setCompleDescontoUmData(java.util.Date compleDescontoUmData) {
        this.compleDescontoUmData = compleDescontoUmData;
    }

    // public java.lang.Long getCompleDescontoUmPercen() {
    public br.com.politec.sao.util.Percentual getCompleDescontoUmPercen() {
        return this.compleDescontoUmPercen;
    }

    // public void setCompleDescontoUmPercen(java.lang.Long
    // compleDescontoUmPercen) {
    public void setCompleDescontoUmPercen(br.com.politec.sao.util.Percentual compleDescontoUmPercen) {
        this.compleDescontoUmPercen = compleDescontoUmPercen;
    }

    public java.lang.Long getCompleDescontoUmPrazo() {
        return this.compleDescontoUmPrazo;
    }

    public void setCompleDescontoUmPrazo(java.lang.Long compleDescontoUmPrazo) {
        this.compleDescontoUmPrazo = compleDescontoUmPrazo;
    }

    public br.com.politec.sao.util.Money getCompleDescontoUmValor() {
        return this.compleDescontoUmValor;
    }

    public void setCompleDescontoUmValor(br.com.politec.sao.util.Money compleDescontoUmValor) {
        this.compleDescontoUmValor = compleDescontoUmValor;
    }

    public java.util.Date getCompleMultaData() {
        return this.compleMultaData;
    }

    public void setCompleMultaData(java.util.Date compleMultaData) {
        this.compleMultaData = compleMultaData;
    }

    // public java.lang.Long getCompleMultaPercen() {
    public br.com.politec.sao.util.Percentual getCompleMultaPercen() {
        return this.compleMultaPercen;
    }

    // public void setCompleMultaPercen(java.lang.Long compleMultaPercen) {
    public void setCompleMultaPercen(br.com.politec.sao.util.Percentual compleMultaPercen) {
        this.compleMultaPercen = compleMultaPercen;
    }

    public java.lang.Long getCompleMultaPrazo() {
        return this.compleMultaPrazo;
    }

    public void setCompleMultaPrazo(java.lang.Long compleMultaPrazo) {
        this.compleMultaPrazo = compleMultaPrazo;
    }

    public br.com.politec.sao.util.Money getCompleMultaValor() {
        return this.compleMultaValor;
    }

    public void setCompleMultaValor(br.com.politec.sao.util.Money compleMultaValor) {
        this.compleMultaValor = compleMultaValor;
    }

    // public java.lang.Long getComplePercenJurosMes() {
    public br.com.politec.sao.util.Percentual getComplePercenJurosMes() {
        return this.complePercenJurosMes;
    }

    // public void setComplePercenJurosMes(java.lang.Long complePercenJurosMes)
    // {
    public void setComplePercenJurosMes(br.com.politec.sao.util.Percentual complePercenJurosMes) {
        this.complePercenJurosMes = complePercenJurosMes;
    }

    public java.lang.Long getCompleSacadorCpfCnpj() {
        return this.compleSacadorCpfCnpj;
    }

    public void setCompleSacadorCpfCnpj(java.lang.Long compleSacadorCpfCnpj) {
        this.compleSacadorCpfCnpj = compleSacadorCpfCnpj;
    }

    public java.lang.String getCompleSacadorNome() {
        return this.compleSacadorNome;
    }

    public void setCompleSacadorNome(java.lang.String compleSacadorNome) {
        this.compleSacadorNome = compleSacadorNome;
    }

    public java.lang.Long getCompleSacadorTipoPessoa() {
        return this.compleSacadorTipoPessoa;
    }

    public void setCompleSacadorTipoPessoa(java.lang.Long compleSacadorTipoPessoa) {
        this.compleSacadorTipoPessoa = compleSacadorTipoPessoa;
    }

    public java.lang.Long getCompleTipoJurosMes() {
        return this.compleTipoJurosMes;
    }

    public void setCompleTipoJurosMes(java.lang.Long compleTipoJurosMes) {
        this.compleTipoJurosMes = compleTipoJurosMes;
    }

    public java.lang.String getComunicacaoSacado() {
        return this.comunicacaoSacado;
    }

    public void setComunicacaoSacado(java.lang.String comunicacaoSacado) {
        this.comunicacaoSacado = comunicacaoSacado;
    }
    
    public java.util.Date getDataProtocolo() {
		return dataProtocolo;
	}

	public void setDataProtocolo(java.util.Date dataProtocolo) {
		this.dataProtocolo = dataProtocolo;
	}
	
	public java.util.Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(java.util.Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public java.lang.Long getFiltroVoltarListarTitulo() {
        return this.filtroVoltarListarTitulo;
    }

    public void setFiltroVoltarListarTitulo(java.lang.Long filtroVoltarListarTitulo) {
        this.filtroVoltarListarTitulo = filtroVoltarListarTitulo;
    }

    public java.lang.Long getFiltroVoltarListarConsolidado() {
        return this.filtroVoltarListarConsolidado;
    }

    public void setFiltroVoltarListarConsolidado(java.lang.Long filtroVoltarListarConsolidado) {
        this.filtroVoltarListarConsolidado = filtroVoltarListarConsolidado;
    }

    public java.lang.Long getFiltroVoltarAcao() {
        return this.filtroVoltarAcao;
    }

    public void setFiltroVoltarAcao(java.lang.Long filtroVoltarAcao) {
        this.filtroVoltarAcao = filtroVoltarAcao;
    }

    public java.lang.String getFiltroDescricaoClassificacao() {
        return this.filtroDescricaoClassificacao;
    }

    public void setFiltroDescricaoClassificacao(java.lang.String descricaoClassificacao) {
        this.filtroDescricaoClassificacao = descricaoClassificacao;
    }

    public java.lang.String getFiltroDescricaoSituacao() {
        return this.filtroDescricaoSituacao;
    }

    public void setFiltroDescricaoSituacao(java.lang.String descricaoSituacao) {
        this.filtroDescricaoSituacao = descricaoSituacao;
    }

    public br.com.politec.sao.util.Money getLiquiAbatimento() {
        return this.liquiAbatimento;
    }

    public void setLiquiAbatimento(br.com.politec.sao.util.Money liquiAbatimento) {
        this.liquiAbatimento = liquiAbatimento;
    }

    public java.lang.String getLiquiCanalLiquidacao() {
        return this.liquiCanalLiquidacao;
    }

    public void setLiquiCanalLiquidacao(java.lang.String liquiCanalLiquidacao) {
        this.liquiCanalLiquidacao = liquiCanalLiquidacao;
    }

    public java.util.Date getLiquiDataCredito() {
        return this.liquiDataCredito;
    }

    public void setLiquiDataCredito(java.util.Date liquiDataCredito) {
        this.liquiDataCredito = liquiDataCredito;
    }

    public java.util.Date getLiquiDataLiquidacao() {
        return this.liquiDataLiquidacao;
    }

    public void setLiquiDataLiquidacao(java.util.Date liquiDataLiquidacao) {
        this.liquiDataLiquidacao = liquiDataLiquidacao;
    }

    public java.util.Date getLiquiDataPagamento() {
        return this.liquiDataPagamento;
    }

    public void setLiquiDataPagamento(java.util.Date liquiDataPagamento) {
        this.liquiDataPagamento = liquiDataPagamento;
    }

    public java.lang.Long getLiquiDiasFloat() {
        return this.liquiDiasFloat;
    }

    public void setLiquiDiasFloat(java.lang.Long liquiDiasFloat) {
        this.liquiDiasFloat = liquiDiasFloat;
    }

    public br.com.politec.sao.util.Money getLiquiValorLiquidoRecebido() {
        return this.liquiValorLiquidoRecebido;
    }

    public void setLiquiValorLiquidoRecebido(br.com.politec.sao.util.Money liquiValorLiquidoRecebido) {
        this.liquiValorLiquidoRecebido = liquiValorLiquidoRecebido;
    }
    
    public br.com.politec.sao.util.Money getRetidoValorIOF() {
        return this.retidoValorIOF;
    }

    public void setRetidoValorIOF(br.com.politec.sao.util.Money retidoValorIOF) {
        this.retidoValorIOF = retidoValorIOF;
    }

    public br.com.politec.sao.util.Money getLiquiValorDesconto() {
        return this.liquiValorDesconto;
    }

    public void setLiquiValorDesconto(br.com.politec.sao.util.Money liquiValorDesconto) {
        this.liquiValorDesconto = liquiValorDesconto;
    }

    public br.com.politec.sao.util.Money getLiquiValorDocumento() {
        return this.liquiValorDocumento;
    }

    public void setLiquiValorDocumento(br.com.politec.sao.util.Money liquiValorDocumento) {
        this.liquiValorDocumento = liquiValorDocumento;
    }

    public br.com.politec.sao.util.Money getLiquiValorJurosMulta() {
        return this.liquiValorJurosMulta;
    }

    public void setLiquiValorJurosMulta(br.com.politec.sao.util.Money liquiValorJurosMulta) {
        this.liquiValorJurosMulta = liquiValorJurosMulta;
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
    
    public java.lang.Long getNumeroCartorio() {
		return numeroCartorio;
	}

	public void setNumeroCartorio(java.lang.Long numeroCartorio) {
		this.numeroCartorio = numeroCartorio;
	}

	public java.util.Date getOrdProtDataMovimento() {
        return this.ordProtDataMovimento;
    }

    public void setOrdProtDataMovimento(java.util.Date ordProtDataMovimento) {
        this.ordProtDataMovimento = ordProtDataMovimento;
    }

    public java.lang.String getPrinciAceite() {
        return this.princiAceite;
    }

    public void setPrinciAceite(java.lang.String princiAceite) {
        this.princiAceite = princiAceite;
    }

    public java.util.Date getPrinciDataVencimento() {
        return this.princiDataVencimento;
    }

    public void setPrinciDataVencimento(java.util.Date princiDataVencimento) {
        this.princiDataVencimento = princiDataVencimento;
    }

    public java.lang.String getPrinciDescricaoEspecie() {
        return this.princiDescricaoEspecie;
    }

    public java.lang.String getPrinciDescricaoAceite() {
        return this.princiDescricaoAceite;
    }

    public void setPrinciDescricaoAceite(java.lang.String princiDescricaoAceite) {
        this.princiDescricaoAceite = princiDescricaoAceite;
    }

    public void setPrinciDescricaoEspecie(java.lang.String princiDescricaoEspecie) {
        this.princiDescricaoEspecie = princiDescricaoEspecie;
    }

    public java.lang.String getPrinciDescricaoPvCobrador() {
        return this.princiDescricaoPvCobrador;
    }

    public void setPrinciDescricaoPvCobrador(java.lang.String princiDescricaoPvCobrador) {
        this.princiDescricaoPvCobrador = princiDescricaoPvCobrador;
    }

    public java.lang.String getPrinciDescricaoSituacao() {
        return this.princiDescricaoSituacao;
    }

    public void setPrinciDescricaoSituacao(java.lang.String princiDescricaoSituacao) {
        this.princiDescricaoSituacao = princiDescricaoSituacao;
    }

    public java.lang.String getPrinciEndosso() {
        return this.princiEndosso;
    }

    public void setPrinciEndosso(java.lang.String princiEndosso) {
        this.princiEndosso = princiEndosso;
    }

    public java.lang.Long getPrinciEspecie() {
        return this.princiEspecie;
    }

    public void setPrinciEspecie(java.lang.Long princiEspecie) {
        this.princiEspecie = princiEspecie;
    }

    public java.lang.String getPrinciIndicadorProt() {
        return this.princiIndicadorProt;
    }

    public void setPrinciIndicadorProt(java.lang.String princiIndicadorProt) {
        this.princiIndicadorProt = princiIndicadorProt;
    }

    public java.lang.String getPrinciMeioEntrada() {
        return this.princiMeioEntrada;
    }

    public void setPrinciMeioEntrada(java.lang.String princiMeioEntrada) {
        this.princiMeioEntrada = princiMeioEntrada;
    }

    public java.lang.Long getPrinciMoeda() {
        return this.princiMoeda;
    }

    public void setPrinciMoeda(java.lang.Long princiMoeda) {
        this.princiMoeda = princiMoeda;
    }

    public java.lang.String getPrinciNumeroDocumento() {
        return this.princiNumeroDocumento;
    }

    public void setPrinciNumeroDocumento(java.lang.String princiNumeroDocumento) {
        this.princiNumeroDocumento = princiNumeroDocumento;
    }

    public java.lang.Long getPrinciPrazoProtDev() {
        return this.princiPrazoProtDev;
    }

    public void setPrinciPrazoProtDev(java.lang.Long princiPrazoProtDev) {
        this.princiPrazoProtDev = princiPrazoProtDev;
    }

    public java.lang.Long getPrinciPvCobrador() {
        return this.princiPvCobrador;
    }

    public void setPrinciPvCobrador(java.lang.Long princiPvCobrador) {
        this.princiPvCobrador = princiPvCobrador;
    }

    public java.lang.String getPrinciSacadoBairro() {
        return this.princiSacadoBairro;
    }

    public void setPrinciSacadoBairro(java.lang.String princiSacadoBairro) {
        this.princiSacadoBairro = princiSacadoBairro;
    }

    public java.lang.Long getPrinciSacadoCep() {
        return this.princiSacadoCep;
    }

    public void setPrinciSacadoCep(java.lang.Long princiSacadoCep) {
        this.princiSacadoCep = princiSacadoCep;
    }

    public java.lang.String getPrinciSacadoComplemento() {
        return this.princiSacadoComplemento;
    }

    public void setPrinciSacadoComplemento(java.lang.String princiSacadoComplemento) {
        this.princiSacadoComplemento = princiSacadoComplemento;
    }

    public java.lang.Long getPrinciSacadoCpfCnpj() {
        return this.princiSacadoCpfCnpj;
    }

    public void setPrinciSacadoCpfCnpj(java.lang.Long princiSacadoCpfCnpj) {
        this.princiSacadoCpfCnpj = princiSacadoCpfCnpj;
    }

    public java.lang.String getPrinciSacadoEmail() {
        return this.princiSacadoEmail;
    }

    public void setPrinciSacadoEmail(java.lang.String princiSacadoEmail) {
        this.princiSacadoEmail = princiSacadoEmail;
    }

    public java.lang.String getPrinciSacadoLogradouro() {
        return this.princiSacadoLogradouro;
    }

    public void setPrinciSacadoLogradouro(java.lang.String princiSacadoLogradouro) {
        this.princiSacadoLogradouro = princiSacadoLogradouro;
    }

    public java.lang.String getPrinciSacadoMunicipio() {
        return this.princiSacadoMunicipio;
    }

    public void setPrinciSacadoMunicipio(java.lang.String princiSacadoMunicipio) {
        this.princiSacadoMunicipio = princiSacadoMunicipio;
    }

    public java.lang.String getPrinciSacadoNome() {
        return this.princiSacadoNome;
    }

    public void setPrinciSacadoNome(java.lang.String princiSacadoNome) {
        this.princiSacadoNome = princiSacadoNome;
    }

    public java.lang.String getPrinciSacadoNumero() {
        return this.princiSacadoNumero;
    }

    public void setPrinciSacadoNumero(java.lang.String princiSacadoNumero) {
        this.princiSacadoNumero = princiSacadoNumero;
    }

    public java.lang.Long getPrinciSacadoTipoPessoa() {
        return this.princiSacadoTipoPessoa;
    }

    public void setPrinciSacadoTipoPessoa(java.lang.Long princiSacadoTipoPessoa) {
        this.princiSacadoTipoPessoa = princiSacadoTipoPessoa;
    }

    public java.lang.String getPrinciSacadoUf() {
        return this.princiSacadoUf;
    }

    public void setPrinciSacadoUf(java.lang.String princiSacadoUf) {
        this.princiSacadoUf = princiSacadoUf;
    }

    public java.lang.String getPrinciSiglaEspecie() {
        return this.princiSiglaEspecie;
    }

    public void setPrinciSiglaEspecie(java.lang.String princiSiglaEspecie) {
        this.princiSiglaEspecie = princiSiglaEspecie;
    }

    public java.lang.Long getPrinciSituacao() {
        return this.princiSituacao;
    }

    public void setPrinciSituacao(java.lang.Long princiSituacao) {
        this.princiSituacao = princiSituacao;
    }

    public br.com.politec.sao.util.Money getPrinciValorTitulo() {
        return this.princiValorTitulo;
    }

    public void setPrinciValorTitulo(br.com.politec.sao.util.Money princiValorTitulo) {
        this.princiValorTitulo = princiValorTitulo;
    }

    public java.lang.Long getFiltroSelecao() {
        return this.filtroSelecao;
    }

    public void setFiltroSelecao(java.lang.Long selecaoFiltro) {
        this.filtroSelecao = selecaoFiltro;
    }

    public java.lang.Long getSituacao() {
        return this.situacao;
    }

    public void setSituacao(java.lang.Long situacao) {
        this.situacao = situacao;
    }

    public java.lang.Long getPagina() {
        return this.pagina;
    }

    public void setPagina(java.lang.Long pagina) {
        this.pagina = pagina;
    }
    
    // Item 6 SISOL 147829
    public java.lang.Long getEmissaoBloqueto() {
        return emissaoBloqueto;
    }

    public void setEmissaoBloqueto(java.lang.Long emissaoBloqueto) {
        this.emissaoBloqueto = emissaoBloqueto;
    }

    public java.lang.Long getEnvioBloqueto() {
        return envioBloqueto;
    }

    public void setEnvioBloqueto(java.lang.Long envioBloqueto) {
        this.envioBloqueto = envioBloqueto;
    }
    
    // ----- daqui

    public java.lang.Long getUnidadeCobradora() {
		return unidadeCobradora;
	}

	public void setUnidadeCobradora(java.lang.Long unidadeCobradora) {
		this.unidadeCobradora = unidadeCobradora;
	}
	
	//DDA SIGCB
	public java.lang.String getSituacaoBloqSE() {
		return situacaoBloqSE;
	}
	
	public void setSituacaoBloqSE(String situacaoBloqSE) {
		this.situacaoBloqSE = situacaoBloqSE;
	}
	
	public java.lang.Long getNumIdDDA() {
		return numIdDDA;
	}
	
	public void setNumIdDDA(Long numIdDDA) {
		this.numIdDDA = numIdDDA;
	}
	
	public java.lang.Long getAceiteSE() {
		return aceiteSE;
	}
	
	public void setAceiteSE(Long aceiteSE) {
		this.aceiteSE = aceiteSE;
	}
	
	public java.lang.String getAlegacaoSE() {
		return alegacaoSE;
	}
	
	public void setAlegacaoSE(String alegacaoSE) {
		this.alegacaoSE = alegacaoSE;
	}
	
	

	public String getTipoCalculo() {
		return tipoCalculo;
	}

	public void setTipoCalculo(String tipoCalculo) {
		this.tipoCalculo = tipoCalculo;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	
	
	


	public java.lang.Long getNossoNumeroFim() {
		return nossoNumeroFim;
	}

	public void setNossoNumeroFim(java.lang.Long nossoNumeroFim) {
		this.nossoNumeroFim = nossoNumeroFim;
	}

	public br.com.politec.sao.util.Money getJurosAtraso() {
		return jurosAtraso;
	}

	public void setJurosAtraso(br.com.politec.sao.util.Money jurosAtraso) {
		this.jurosAtraso = jurosAtraso;
	}

	public java.lang.String getPrinciSiglaAceite() {
        if ((this.princiSacadoUf.equals("SP"))
            || (this.princiSacadoUf.equals("DF"))) {
            if ((this.princiAceite.equals("1"))
                || (this.princiAceite.equals("4")))
                return ("A");
            if ((this.princiAceite.equals("2"))
                || (this.princiAceite.equals("3")))
                return ("D");
            if (this.princiAceite.equals("5"))
                return ("T");
            if (this.princiAceite.equals("6"))
                return ("R");
        } else {
            if (this.princiAceite.equals("1"))
                return ("S");
            if (this.princiAceite.equals("2"))
                return ("N");
        }
        return ("");
    }

    public java.lang.String getPrinciSiglaAceiteSimNao() {
        if (this.princiAceite.equals("1"))
            return ("S");
        else
            return ("N");
    }

    public java.lang.String getPrinciDataDocumentoFormatada() {
        if (this.princiDataDocumento != null)
            return Formatador.formatarData(this.princiDataDocumento);
        return "";
    }

    public java.lang.String getLiquiDataLiquidacaoFormatada() {
        if (this.liquiDataLiquidacao != null)
            return Formatador.formatarData(this.liquiDataLiquidacao);
        return "";
    }

    public java.lang.String getLiquiDataPagamentoFormatada() {
        if (this.liquiDataPagamento != null)
            return Formatador.formatarData(this.liquiDataPagamento);
        return "";
    }

    public java.lang.String getLiquiDataCreditoFormatada() {
        if (this.liquiDataCredito != null)
            return Formatador.formatarData(this.liquiDataCredito);
        return "";
    }

    public java.lang.String getCompleDescontoUmDataFormatada() {
        if (this.compleDescontoUmData != null)
            return Formatador.formatarData(this.compleDescontoUmData);
        return "";
    }
    
    public java.lang.String getDataJurosFormatada() {
        if (this.datajuros != null)
            return Formatador.formatarData(this.datajuros);
        return "";
    }

    public java.lang.String getCompleDescontoDoisDataFormatada() {
        if (this.compleDescontoDoisData != null)
            return Formatador.formatarData(this.compleDescontoDoisData);
        return "";
    }

    public java.lang.String getCompleDescontoTresDataFormatada() {
        if (this.compleDescontoTresData != null)
            return Formatador.formatarData(this.compleDescontoTresData);
        return "";
    }

    public java.lang.String getCompleMultaDataFormatada() {
        if (this.compleMultaData != null)
            return Formatador.formatarData(this.compleMultaData);
        return "";
    }
    
    public java.lang.String getDataProtocoloFormatada() {
        if (this.dataProtocolo != null)
            return Formatador.formatarData(this.dataProtocolo);
        return "";
    }
    
    public java.lang.String getDataSolicitacaoFormatada() {
        if (this.dataSolicitacao != null) {
            return Formatador.formatarData(this.dataSolicitacao);
        } else {
            return "";
        }
    }

    public java.lang.String getPrinciDataVencimentoFormatada() {
        if (this.princiDataVencimento != null)
            return Formatador.formatarData(this.princiDataVencimento);
        return "";
    }

    public java.lang.String getAbatiDataEmissaoFormatada() {
        if (this.abatiDataEmissao != null)
            return Formatador.formatarData(this.abatiDataEmissao);
        return "";
    }

    public java.lang.String getAbatiDataEntradaFormatada() {
        if (this.abatiDataEntrada != null)
            return Formatador.formatarData(this.abatiDataEntrada);
        return "";
    }

    public java.lang.String getAbatiMultaDataFormatada() {
        if (this.abatiMultaData != null)
            return Formatador.formatarData(this.abatiMultaData);
        return "";
    }

    public java.lang.String getAbatiJurosDataFormatada() {
        if (this.abatiJurosData != null)
            return Formatador.formatarData(this.abatiJurosData);
        return "";
    }

    public java.lang.String getAbatiDescontoUmDataFormatada() {
        if (this.abatiDescontoUmData != null)
            return Formatador.formatarData(this.abatiDescontoUmData);
        return "";
    }

    public java.lang.String getAbatiDescontoDoisDataFormatada() {
        if (this.abatiDescontoDoisData != null)
            return Formatador.formatarData(this.abatiDescontoDoisData);
        return "";
    }

    public java.lang.String getAbatiDescontoTresDataFormatada() {
        if (this.abatiDescontoTresData != null)
            return Formatador.formatarData(this.abatiDescontoTresData);
        return "";
    }

    public java.lang.String getAbatiDataPrevisaoProtDevFormatada() {
        if (this.abatiDataPrevisaoProtDev != null)
            return Formatador.formatarData(this.abatiDataPrevisaoProtDev);
        return "";
    }

    public java.lang.String getCompleTipoJurosMesFormatada() {
        if (this.compleTipoJurosMes.equals(new Long(0)))
            return ("SEM JUROS");
        if (this.compleTipoJurosMes.equals(new Long(1)))
            return ("JUROS CAIXA");
        if (this.compleTipoJurosMes.equals(new Long(2)))
            return ("JUROS CEDENTE");
        return "";
    }

    public java.lang.String getAbatiModalidadeFormatada() {
        if (this.abatiModalidade.equals("01"))
            return ("REGISTRADA");
        if (this.abatiModalidade.equals("03"))
            return ("REGISTRADA CAUCIONADA");
        if (this.abatiModalidade.equals("04"))
            return ("REGISTRADA DESCONTADA");
        return "";
    }

    public java.lang.String getPrinciMoedaTexto() {
        if (this.princiMoeda.equals(new Long(9)))
            return "REAL";
        return "";
    }

    public java.lang.String getPrinciMoedaSimbolo() {
        if (this.princiMoeda.equals(new Long(9)))
            return "R$";
        return "";
    }

    public java.lang.String getPrinciIndicadorProtTexto() {
        if (this.princiIndicadorProt != null)
            return Formatador.formatarSN(this.princiIndicadorProt);
        return "";
    }

    public java.lang.String getPrinciEndossoTexto() {
        if (this.princiEndosso != null)
            return Formatador.formatarSN(this.princiEndosso);
        return "";
    }

    public java.lang.String getPrinciSacadoTipoPessoaTexto() {
        if (this.princiSacadoTipoPessoa != null)
            return Formatador.formatarTipoPessoa(this.princiSacadoTipoPessoa);
        return "";
    }

    public java.lang.String getCompleSacadorTipoPessoaTexto() {
        if (this.compleSacadorTipoPessoa != null)
            return Formatador.formatarTipoPessoa(this.compleSacadorTipoPessoa);
        return "";
    }

    public String getPrinciSacadoCepFormatado() {
        return Formatador.formatarCep(this.princiSacadoCep.toString());
    }

    public java.lang.String getAcoesHistoricoFormatada() {
        if (this.acoesHistorico != null) {
            return Formatador.formatarTextoComBarraEne(this.acoesHistorico, 50);
        } else {
            return "";
        }
    }

    
    
    public String getDescrEntrega() {
		return descrEntrega;
	}

	public void setDescrEntrega(String descrEntrega) {
		this.descrEntrega = descrEntrega;
	}

	public String getIofAtraso61() {
		return iofAtraso61;
	}

	public void setIofAtraso61(String iofAtraso61) {
		this.iofAtraso61 = iofAtraso61;
	}

	public String getIofAtraso() {
		return iofAtraso;
	}

	public void setIofAtraso(String iofAtraso) {
		this.iofAtraso = iofAtraso;
	}
	
	
	
	public String getIcRateio() {
		return icRateio;
	}

	public void setIcRateio(String icRateio) {
		this.icRateio = icRateio;
	}

	public String getIofAtrasoFormatado(){
		String ret = "R$ ";
		if (this.getIofAtraso()!=null){
			int inteiro = Integer.parseInt(this.getIofAtraso().substring(0, 9));
			String decimal = this.getIofAtraso().substring(9, 15);
			ret = ret + inteiro + "," + decimal;
		}
		return ret;
	}

	public java.lang.String getPrinciSacadoCpfCnpjFormatado() {
        if (this.princiSacadoTipoPessoa != null) {
            String cpfcnpj = "";
            if (this.princiSacadoTipoPessoa.equals(new Long(1)))
                cpfcnpj = Formatacao.formataNumerico(this.princiSacadoCpfCnpj.toString(),
                        11);
            else if (this.princiSacadoTipoPessoa.equals(new Long(2)))
                cpfcnpj = Formatacao.formataNumerico(this.princiSacadoCpfCnpj.toString(),
                        14);
            return (Formatacao.formataCPFCNPJ(cpfcnpj));
        }
        return "";
    }

    public java.lang.String getCompleSacadorCpfCnpjFormatado() {
        if (this.compleSacadorTipoPessoa != null) {
            String cpfcnpj = "";
            if (this.compleSacadorTipoPessoa.equals(new Long(1)))
                cpfcnpj = Formatacao.formataNumerico(this.compleSacadorCpfCnpj.toString(),
                        11);
            else if (this.compleSacadorTipoPessoa.equals(new Long(2)))
                cpfcnpj = Formatacao.formataNumerico(this.compleSacadorCpfCnpj.toString(),
                        14);
            return (Formatacao.formataCPFCNPJ(cpfcnpj));
        }
        return "";
    }
    
    


	public java.lang.String getCpfCnpjFormatadoPrt() {
        if (this.cpfCnpjPrt != null) {
            String cpfcnpj = "";
            if (this.tpPessoaPrt.equals("1")) {
                cpfcnpj = Formatacao.formataNumerico(this.cpfCnpjPrt,  11);
            } else if (this.tpPessoaPrt.equals("2")) {
                cpfcnpj = Formatacao.formataNumerico(this.cpfCnpjPrt,  14);
            }
            return (Formatacao.formataCPFCNPJ(cpfcnpj));
        }
        return "";
    }



	public String getFeriadoLocal() {
		return feriadoLocal;
	}

	public void setFeriadoLocal(String feriadoLocal) {
		this.feriadoLocal = feriadoLocal;
	}

	public java.lang.String getAcoesServicoTituloTexto() {
        if (this.acoesServicoTitulo != null) {
            if (this.acoesServicoTitulo.equals(new Long(1)))
                return ("Envio ao Cartório");
            if (this.acoesServicoTitulo.equals(new Long(2)))
                return ("Sustação de Protesto");
            if (this.acoesServicoTitulo.equals(new Long(3)))
                return ("Estorno Envio/Sustação");
            if (this.acoesServicoTitulo.equals(new Long(4)))
                return ("Débito Custas Cartorárias - Pós Comando");
            if (this.acoesServicoTitulo.equals(new Long(5)))
                return ("Impressão de 2. via Ordem de Protesto");
            if (this.acoesServicoTitulo.equals(new Long(6)))
                return ("Suspender Envio ao Cartório");
            if (this.acoesServicoTitulo.equals(new Long(7)))
                return ("Incluir Título na Remessa");
            if (this.acoesServicoTitulo.equals(new Long(8)))
                return ("Baixa por Protesto");
            if (this.acoesServicoTitulo.equals(new Long(9)))
                return ("Liquidado em Cartório");
            if (this.acoesServicoTitulo.equals(new Long(10)))
                return ("Liquidado em Cartório Condicional");
            if (this.acoesServicoTitulo.equals(new Long(11)))
                return ("Baixa Manual");
            if (this.acoesServicoTitulo.equals(new Long(12)))
                return ("Baixa por Estorno");
            if (this.acoesServicoTitulo.equals(new Long(13)))
                return ("Solicitação de 2. via de Bloqueto");
            if (this.acoesServicoTitulo.equals(new Long(14)))
                // return("Reinclusão de Título");//EAM 06/09/05
                return ("Reinclusão de Título Liquidado");// EAM 06/09/05
            if (this.acoesServicoTitulo.equals(new Long(15)))
                // return("Reinclusão de Baixa");//EAM 06/09/05
                return ("Reinclusão de Título Baixado");// EAM 06/09/05
            if (this.acoesServicoTitulo.equals(new Long(16)))
                return ("Estorno de Sustação");
            if (this.acoesServicoTitulo.equals(new Long(17)))
                return ("Estorno de Envio ao Cartório com Custa Cartorária");
            if (this.acoesServicoTitulo.equals(new Long(18)))
                return ("Alteração de Título");
            if (this.acoesServicoTitulo.equals(new Long(19)))
                return ("Débito Custas/Despesas Cartorárias - Protesto Centralizado");
            if (this.acoesServicoTitulo.equals(new Long(20)))
                return ("Reemissão e Postagem de Bloquetos");
        }
        return "";
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getNossoNumeroFormatado-----------------------
    public java.lang.String getNossoNumeroFormatado() {
    	String NN = this.nossoNumero.toString();
    	String nossoNumeroFormatado="";		
    	if (NN.length()==18){
    		nossoNumeroFormatado = Formatador.formatarNossoNumero18(this.nossoNumero);
    	}else{
    		nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumero);
    	}
    	

        return nossoNumeroFormatado;
    }

    // fim-------------getNossoNumeroFormatado-----------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getPrinciPvVinculacaoFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.princiPvVinculacao);
        return codigoUnidadeFormatado;
    }

    public java.lang.String getPrinciPvCobradorFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.princiPvCobrador);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    
    public java.lang.String getUnidadeCobradoraFormatada() {
        String unidadeCobradoraFormatada = Formatador.formatarUnidade(this.unidadeCobradora);
        return unidadeCobradoraFormatada;
    }

    public java.lang.String getOrdProtDataMovimentoFormatada() {
        if (this.ordProtDataMovimento != null)
            return Formatador.formatarData(this.ordProtDataMovimento);
        return "";
    }

    // Métodos para imprimir os dois primeiros catacteres do nosso número
    public java.lang.String getNossoNumeroCcFormatado() {
        String cc = this.getNossoNumeroFormatado();
        if (cc.length() > 2) {
            cc = cc.substring(0, 2);
        }
        return cc;
    }

    // Métodos para imprimir os quinze caracteres restantes nosso número
    public java.lang.String getNossoNumeroQuinzeFormatado() {
        String cc = this.getNossoNumeroFormatado();
        if (cc.length() > 2) {
            cc = cc.substring(2, cc.length());
        }
        return cc;
    }

    public String getEmissaoBloquetoTexto() {
        String emissaoBloquetoTexto[] = { "CEDENTE", // pos 0
                                         "CAIXA" // pos 1
        };
        // 01CEDENTE
        // 02CAIXA
        return emissaoBloquetoTexto[this.getEmissaoBloqueto().intValue() - 1];
    }

    public String getEnvioBloquetoTexto() {
        /*
         * 01 CORREIO 02 AGENCIA 03 E-MAIL 04 MALOTE 05 TESTE
         */
        String envioBloquetoTexto[] = {
                                       "",
                                       "CORREIO",
                                       "AGENCIA",
                                       "E-MAIL",
                                       "MALOTE",
                                       "TESTE" };

        return envioBloquetoTexto[this.getEnvioBloqueto().intValue()];
    }
    
    

    public Long getFatorVencimento() {
		return fatorVencimento;
	}

	public void setFatorVencimento(Long fatorVencimento) {
		this.fatorVencimento = fatorVencimento;
	}

	public Long getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Long formaPagamento) {
		this.formaPagamento = formaPagamento;
	}



	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public br.com.politec.sao.util.Money getCompleRetidoValorIOF() {
        return this.compleRetidoValorIOF;
    }

    public void setCompleRetidoValorIOF(br.com.politec.sao.util.Money compleRetidoValorIOF) {
        this.compleRetidoValorIOF = compleRetidoValorIOF;
    }
    
    public br.com.politec.sao.util.Money getAbatiRetidoValorIOF() {
        return this.abatiRetidoValorIOF;
    }

    public void setAbatiRetidoValorIOF(br.com.politec.sao.util.Money abatiRetidoValorIOF) {
        this.abatiRetidoValorIOF = abatiRetidoValorIOF;
    }
    
    

    public String getIcGarantia() {
		return icGarantia;
	}

	public void setIcGarantia(String icGarantia) {
		this.icGarantia = icGarantia;
	}

	public String getDtGarantia() {
		return dtGarantia;
	}

	public void setDtGarantia(String dtGarantia) {
		this.dtGarantia = dtGarantia;
	}

	public String getCoUsuario() {
		return coUsuario;
	}

	public void setCoUsuario(String coUsuario) {
		this.coUsuario = coUsuario;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	


	public Long getNsu() {
		return nsu;
	}

	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            TituloBean other = (TituloBean) obj;
            result = result
                     && equals(getAbatiAbatimento(), other.getAbatiAbatimento());
            result = result
                     && equals(getAbatiCustasCartorarias(),
                             other.getAbatiCustasCartorarias());
            result = result
                     && equals(getAbatiDataEmissao(),
                             other.getAbatiDataEmissao());
            result = result
                     && equals(getAbatiDataEntrada(),
                             other.getAbatiDataEntrada());
            result = result
                     && equals(getAbatiDataPrevisaoProtDev(),
                             other.getAbatiDataPrevisaoProtDev());
            result = result
                     && equals(getAbatiDescontoDoisData(),
                             other.getAbatiDescontoDoisData());
            result = result
                     && equals(getAbatiDescontoDoisPercen(),
                             other.getAbatiDescontoDoisPercen());
            result = result
                     && equals(getAbatiDescontoDoisPrazo(),
                             other.getAbatiDescontoDoisPrazo());
            result = result
                     && equals(getAbatiDescontoDoisValor(),
                             other.getAbatiDescontoDoisValor());
            result = result
                     && equals(getAbatiDescontoTresData(),
                             other.getAbatiDescontoTresData());
            result = result
                     && equals(getAbatiDescontoTresPercen(),
                             other.getAbatiDescontoTresPercen());
            result = result
                     && equals(getAbatiDescontoTresPrazo(),
                             other.getAbatiDescontoTresPrazo());
            result = result
                     && equals(getAbatiDescontoTresValor(),
                             other.getAbatiDescontoTresValor());
            result = result
                     && equals(getAbatiDescontoUmData(),
                             other.getAbatiDescontoUmData());
            result = result
                     && equals(getAbatiDescontoUmPercen(),
                             other.getAbatiDescontoUmPercen());
            result = result
                     && equals(getAbatiDescontoUmPrazo(),
                             other.getAbatiDescontoUmPrazo());
            result = result
                     && equals(getAbatiDescontoUmValor(),
                             other.getAbatiDescontoUmValor());
            result = result
                     && equals(getAbatiJurosData(), other.getAbatiJurosData());
            result = result
                     && equals(getAbatiJurosPercen(),
                             other.getAbatiJurosPercen());
            result = result
                     && equals(getAbatiJurosValor(), other.getAbatiJurosValor());
            result = result
                     && equals(getAbatiModalidade(), other.getAbatiModalidade());
            result = result
                     && equals(getAbatiMultaData(), other.getAbatiMultaData());
            result = result
                     && equals(getAbatiMultaPercen(),
                             other.getAbatiMultaPercen());
            result = result
                     && equals(getAbatiMultaPrazo(), other.getAbatiMultaPrazo());
            result = result
                     && equals(getAbatiMultaValor(), other.getAbatiMultaValor());
            result = result
                     && equals(getAcoesDespesasCartorarias(),
                             other.getAcoesDespesasCartorarias());
            result = result
                     && equals(getAcoesHistorico(), other.getAcoesHistorico());
            result = result
            		&& equals(getNomeGrupo(), other.getNomeGrupo());
            result = result
                     && equals(getAcoesServicoTitulo(),
                             other.getAcoesServicoTitulo());
            result = result
                     && equals(getAcoesValorRecebido(),
                             other.getAcoesValorRecebido());
            result = result
                     && equals(getBloqCodigoBarrasFormatado(),
                             other.getBloqCodigoBarrasFormatado());
            result = result
                     && equals(getBloqCodigoBarrasNumerico(),
                             other.getBloqCodigoBarrasNumerico());
            result = result
                     && equals(getBloqDescricaoMensagem(),
                             other.getBloqDescricaoMensagem());
            result = result
                     && equals(getBloqTipoMensagem(),
                             other.getBloqTipoMensagem());
            result = result
                     && equals(getBloqDigitoCtrlNossoNumero(),
                             other.getBloqDigitoCtrlNossoNumero());
            result = result
                     && equals(getPrinciDataDocumento(),
                             other.getPrinciDataDocumento());
            result = result
                     && equals(getBlqexpdummyDataProcessamento(),
                             other.getBlqexpdummyDataProcessamento());
            result = result
                     && equals(getPrinciModalidade(),
                             other.getPrinciModalidade());
            result = result
                     && equals(getPrinciPvVinculacao(),
                             other.getPrinciPvVinculacao());
            result = result
                     && equals(getClassificacao(), other.getClassificacao());
            result = result
                     && equals(getCobrarTarifa(), other.getCobrarTarifa());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
            		 && equals(getCodigoProtocolo(), other.getCodigoProtocolo());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getCompleAbatimento(),
                             other.getCompleAbatimento());
            result = result
                     && equals(getCompleDescontoDoisData(),
                             other.getCompleDescontoDoisData());
            result = result
                     && equals(getCompleDescontoDoisPercen(),
                             other.getCompleDescontoDoisPercen());
            result = result
                     && equals(getCompleDescontoDoisPrazo(),
                             other.getCompleDescontoDoisPrazo());
            result = result
                     && equals(getCompleDescontoDoisValor(),
                             other.getCompleDescontoDoisValor());
            result = result
                     && equals(getCompleDescontoTresData(),
                             other.getCompleDescontoTresData());
            result = result
                     && equals(getCompleDescontoTresPercen(),
                             other.getCompleDescontoTresPercen());
            result = result
                     && equals(getCompleDescontoTresPrazo(),
                             other.getCompleDescontoTresPrazo());
            result = result
                     && equals(getCompleDescontoTresValor(),
                             other.getCompleDescontoTresValor());
            result = result
                     && equals(getCompleDescontoUmData(),
                             other.getCompleDescontoUmData());
            result = result
                     && equals(getCompleDescontoUmPercen(),
                             other.getCompleDescontoUmPercen());
            result = result
                     && equals(getCompleDescontoUmPrazo(),
                             other.getCompleDescontoUmPrazo());
            result = result
                     && equals(getCompleDescontoUmValor(),
                             other.getCompleDescontoUmValor());
            result = result
                     && equals(getCompleMultaData(), other.getCompleMultaData());
            result = result
                     && equals(getCompleMultaPercen(),
                             other.getCompleMultaPercen());
            result = result
                     && equals(getCompleMultaPrazo(),
                             other.getCompleMultaPrazo());
            result = result
                     && equals(getCompleMultaValor(),
                             other.getCompleMultaValor());
            result = result
                     && equals(getComplePercenJurosMes(),
                             other.getComplePercenJurosMes());
            result = result
                     && equals(getCompleSacadorCpfCnpj(),
                             other.getCompleSacadorCpfCnpj());
            result = result
                     && equals(getCompleSacadorNome(),
                             other.getCompleSacadorNome());
            result = result
                     && equals(getCompleSacadorTipoPessoa(),
                             other.getCompleSacadorTipoPessoa());
            result = result
                     && equals(getCompleTipoJurosMes(),
                             other.getCompleTipoJurosMes());
            result = result
                     && equals(getComunicacaoSacado(),
                             other.getComunicacaoSacado());
            result = result
            		 && equals(getDataProtocolo(),
            				 other.getDataProtocolo());
            result = result 
            		 && equals(getDataSolicitacao(), 
            				 other.getDataSolicitacao());
            result = result
                     && equals(getFiltroVoltarListarTitulo(),
                             other.getFiltroVoltarListarTitulo());
            result = result
                     && equals(getFiltroVoltarListarConsolidado(),
                             other.getFiltroVoltarListarConsolidado());
            result = result
                     && equals(getFiltroVoltarAcao(),
                             other.getFiltroVoltarAcao());
            result = result
                     && equals(getFiltroDescricaoClassificacao(),
                             other.getFiltroDescricaoClassificacao());
            result = result
                     && equals(getFiltroDescricaoSituacao(),
                             other.getFiltroDescricaoSituacao());
            result = result
                     && equals(getLiquiAbatimento(), other.getLiquiAbatimento());
            result = result
                     && equals(getLiquiCanalLiquidacao(),
                             other.getLiquiCanalLiquidacao());
            result = result
                     && equals(getLiquiDataCredito(),
                             other.getLiquiDataCredito());
            result = result
                     && equals(getLiquiDataLiquidacao(),
                             other.getLiquiDataLiquidacao());
            result = result
                     && equals(getLiquiDataPagamento(),
                             other.getLiquiDataPagamento());
            result = result
                     && equals(getLiquiDiasFloat(), other.getLiquiDiasFloat());
            result = result
                     && equals(getLiquiValorLiquidoRecebido(),
                             other.getLiquiValorLiquidoRecebido());
            result = result
            		&& equals(getRetidoValorIOF(),
            				other.getRetidoValorIOF());
            
            result = result
                     && equals(getLiquiValorDesconto(),
                             other.getLiquiValorDesconto());
            result = result
                     && equals(getLiquiValorDocumento(),
                             other.getLiquiValorDocumento());
            result = result
                     && equals(getLiquiValorJurosMulta(),
                             other.getLiquiValorJurosMulta());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result && equals(getNumeroCartorio(), other.getNumeroCartorio());
            result = result
                     && equals(getOrdProtDataMovimento(),
                             other.getOrdProtDataMovimento());
            result = result
                     && equals(getPrinciAceite(), other.getPrinciAceite());
            result = result
                     && equals(getPrinciDataVencimento(),
                             other.getPrinciDataVencimento());
            result = result
                     && equals(getPrinciDescricaoAceite(),
                             other.getPrinciDescricaoAceite());
            result = result
                     && equals(getPrinciDescricaoEspecie(),
                             other.getPrinciDescricaoEspecie());
            result = result
                     && equals(getPrinciDescricaoPvCobrador(),
                             other.getPrinciDescricaoPvCobrador());
            result = result
                     && equals(getPrinciDescricaoSituacao(),
                             other.getPrinciDescricaoSituacao());
            result = result
                     && equals(getPrinciEndosso(), other.getPrinciEndosso());
            result = result
                     && equals(getPrinciEspecie(), other.getPrinciEspecie());
            result = result
                     && equals(getPrinciIndicadorProt(),
                             other.getPrinciIndicadorProt());
            result = result
                     && equals(getPrinciMeioEntrada(),
                             other.getPrinciMeioEntrada());
            result = result && equals(getPrinciMoeda(), other.getPrinciMoeda());
            result = result
                     && equals(getPrinciNumeroDocumento(),
                             other.getPrinciNumeroDocumento());
            result = result
                     && equals(getPrinciPrazoProtDev(),
                             other.getPrinciPrazoProtDev());
            result = result
                     && equals(getPrinciPvCobrador(),
                             other.getPrinciPvCobrador());
            result = result
                     && equals(getPrinciSacadoBairro(),
                             other.getPrinciSacadoBairro());
            result = result
                     && equals(getPrinciSacadoCep(), other.getPrinciSacadoCep());
            result = result
                     && equals(getPrinciSacadoComplemento(),
                             other.getPrinciSacadoComplemento());
            result = result
                     && equals(getPrinciSacadoCpfCnpj(),
                             other.getPrinciSacadoCpfCnpj());
            result = result
                     && equals(getPrinciSacadoEmail(),
                             other.getPrinciSacadoEmail());
            result = result
                     && equals(getPrinciSacadoLogradouro(),
                             other.getPrinciSacadoLogradouro());
            result = result
                     && equals(getPrinciSacadoMunicipio(),
                             other.getPrinciSacadoMunicipio());
            result = result
                     && equals(getPrinciSacadoNome(),
                             other.getPrinciSacadoNome());
            result = result
                     && equals(getPrinciSacadoNumero(),
                             other.getPrinciSacadoNumero());
            result = result
                     && equals(getPrinciSacadoTipoPessoa(),
                             other.getPrinciSacadoTipoPessoa());
            result = result
                     && equals(getPrinciSacadoUf(), other.getPrinciSacadoUf());
            result = result
                     && equals(getPrinciSiglaEspecie(),
                             other.getPrinciSiglaEspecie());
            result = result
                     && equals(getPrinciSituacao(), other.getPrinciSituacao());
            result = result
                     && equals(getPrinciValorTitulo(),
                             other.getPrinciValorTitulo());
            result = result
                     && equals(getFiltroSelecao(), other.getFiltroSelecao());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result && equals(getUnidadeCobradora(), other.getUnidadeCobradora());
            result = result && equals(getPagina(), other.getPagina());

            // Item 4 SISOL 147829

            result = result
                     && equals(this.getEmissaoBloqueto(),
                             other.getEmissaoBloqueto());
            result = result
                     && equals(this.getEnvioBloqueto(),
                             other.getEnvioBloqueto());
            
            // DDA SIGCB
            
            result = result 
            		 && equals(this.getSituacaoBloqSE(),
            				 other.getSituacaoBloqSE());
            result = result 
            		 && equals(this.getNumIdDDA(),
            				 other.getNumIdDDA());
            result = result
            		 && equals(this.getAceiteSE(),
            				 other.getAceiteSE());
            result = result
   		 			&& equals(this.getAlegacaoSE(),
   		 					other.getAlegacaoSE());
            
            
            //IOF
            result = result
            		&& equals(getCompleRetidoValorIOF(),
            				other.getCompleRetidoValorIOF());
            result = result
            		&& equals(getAbatiRetidoValorIOF(),
            				other.getAbatiRetidoValorIOF());
   
            result = result && equals(getTipoCalculo(),other.getTipoCalculo());
            result = result && equals(getAutorizacao(), other.getAutorizacao());
            result = result && equals(getIofAtraso(), other.getIofAtraso());
            result = result && equals(getIofAtraso61(), other.getIofAtraso61());
            result = result && equals(getJurosAtraso(), other.getJurosAtraso());
            result = result && equals(getFeriadoLocal(), other.getFeriadoLocal());
            result = result && equals(getPvCobrador(), other.getPvCobrador());
            result = result && equals(getPvRecebedor(), other.getPvRecebedor());
            
            result = result && equals(getDddSMS(), other.getDddSMS());
            result = result && equals(getCelularSMS(), other.getCelularSMS());
            result = result && equals(getTipoSMS(), other.getTipoSMS());
            result = result && equals(getFiller(), other.getFiller());
            result = result && equals(getDescrEntrega(), other.getDescrEntrega());
            result = result && equals(getIcRateio(), other.getIcRateio());
            result = result && equals(getNossoNumeroFim(), other.getNossoNumeroFim());
            result = result && equals(getIcGarantia(), other.getIcGarantia());
            result = result && equals(getDtGarantia(), other.getDtGarantia());
            result = result && equals(getCoUsuario(), other.getCoUsuario());
            result = result && equals(getDataInicio(),other.getDataFim());
            result = result && equals(getFatorVencimento(),other.getFatorVencimento());
            result = result && equals(getFormaPagamento(),other.getFormaPagamento());
            result = result && equals(getNsu(),other.getNsu());
            result = result && equals(getCodBarras1(),other.getCodBarras1());
            result = result && equals(getCodBarras2(),other.getCodBarras2());
            result = result && equals(getCodBarras3(),other.getCodBarras3());
            result = result && equals(getCodBarras4(),other.getCodBarras4());
            result = result && equals(getCodBarras5(),other.getCodBarras5());
            result = result && equals(getMotivo(),other.getMotivo());
            result = result && equals(getObservacoes(),other.getObservacoes());
            result = result && equals(getNossoNumeroLiq(),other.getNossoNumeroLiq());
            result = result && equals(getTipoAcao(),other.getTipoAcao());
            result = result && equals(getMeio(),other.getMeio());
            result = result && equals(getDescrMeio(),other.getDescrMeio());
            result = result && equals(getDescrFormaPagamento(),other.getDescrFormaPagamento());
            result = result && equals(getDescrMotivo(),other.getDescrMotivo());
            result = result && equals(getDescrSituacao(),other.getDescrSituacao());
            result = result && equals(getCoErro(),other.getCoErro());
            result = result && equals(getDeErro(),other.getDeErro());
			result = result && equals(getParcela(),other.getParcela());
			
		 	//----------Versao 61 
		 	

		 	
		 	result = result && equals(getIcRegistroCIP(),other.getIcRegistroCIP());
		 	result = result && equals(getNuIdentificaCIP(),other.getNuIdentificaCIP());
		 	result = result && equals(getNuRefereciaCIP(),other.getNuRefereciaCIP());
		 	result = result && equals(getSgIndexador(),other.getSgIndexador());
		 	result = result && equals(getIcTipoPagamento(),other.getIcTipoPagamento());
		 	result = result && equals(getVrMaximoPgto(),other.getVrMaximoPgto());
		 	result = result && equals(getVrMinPgto(),other.getVrMinPgto());
		 	result = result && equals(getIcAutPagto(),other.getIcAutPagto());
		 	result = result && equals(getQtPgtoPossivel(),other.getQtPgtoPossivel());
		 	result = result && equals(getQtPgtoEfetuado(),other.getQtPgtoEfetuado());
		 	result = result && equals(getVrSaldoTitulo(),other.getVrSaldoTitulo());
		 	
		 	result = result && equals(getCmbEmissao(),other.getCmbEmissao());
		 	result = result && equals(getCmbCarteira(),other.getCmbCarteira());
		 	result = result && equals(getNuBaixa(),other.getNuBaixa());
		 	result = result && equals(getCoErroCIP(),other.getCoErroCIP());
		 	result = result && equals(getDtCompetencia(),other.getDtCompetencia());
		 	
		 	result = result && equals(getTipoDesconto(),other.getTipoDesconto());
		 	result = result && equals(getValorJuros(),other.getValorJuros());
		 	result = result && equals(getDatajuros(),other.getDatajuros());
		 	result = result && equals(getTipoJuros(),other.getTipoJuros());
		 	result = result && equals(getJurosAtrasoMora(),other.getJurosAtrasoMora());
		 	result = result && equals(getTpPessoaPrt(),other.getTpPessoaPrt());
		 	result = result && equals(getCpfCnpjPrt(),other.getCpfCnpjPrt());
		 	result = result && equals(getVrDesAba(), other.getVrDesAba());
		 	result = result && equals(getVrMltJur(), other.getVrMltJur());
		 	result = result && equals(getVrJuros(), other.getVrJuros());
		 	result = result && equals(getVrIof(), other.getVrIof());
		 	result = result && equals(getVrMulta(), other.getVrMulta());
		 	result = result && equals(getVrDesconto(), other.getVrDesconto());
		 	result = result && equals(getVrAbatimento(), other.getVrAbatimento());
		 	result = result && equals(getVrCalculado(), other.getVrCalculado());
		 	result = result && equals(getVrCobrado(), other.getVrCobrado());
		 	result = result && equals(getSnBaixa(), other.getSnBaixa());
		 	
		 	result = result && equals(getFixo(), other.getFixo());

		 	
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
        properties.add(new Property("abatiAbatimento",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("abatiCustasCartorarias",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("abatiDataEmissao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("abatiDataEntrada",
                DateType.create(),
                false,
                true));
        properties.add(new Property("abatiDataPrevisaoProtDev",
                DateType.create(),
                false,
                true));
        properties.add(new Property("abatiDescontoDoisData",
                DateType.create(),
                false,
                true));
        // properties.add(new Property("abatiDescontoDoisPercen",
        // LongType.create(), false, true));
        properties.add(new Property("abatiDescontoDoisPercen",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("abatiDescontoDoisPrazo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("abatiDescontoDoisValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("abatiDescontoTresData",
                DateType.create(),
                false,
                true));
        // properties.add(new Property("abatiDescontoTresPercen",
        // LongType.create(), false, true));
        properties.add(new Property("abatiDescontoTresPercen",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("abatiDescontoTresPrazo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("abatiDescontoTresValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("abatiDescontoUmData",
                DateType.create(),
                false,
                true));
        // properties.add(new Property("abatiDescontoUmPercen",
        // LongType.create(), false, true));
        properties.add(new Property("abatiDescontoUmPercen",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("abatiDescontoUmPrazo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("abatiDescontoUmValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("abatiJurosData",
                DateType.create(),
                false,
                true));
        // properties.add(new Property("abatiJurosPercen", LongType.create(),
        // false, true));
        properties.add(new Property("abatiJurosPercen",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("abatiJurosValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("abatiModalidade",
                StringType.create(),
                false,
                true));
        properties.add(new Property("abatiMultaData",
                DateType.create(),
                false,
                true));
        // properties.add(new Property("abatiMultaPercen", LongType.create(),
        // false, true));
        properties.add(new Property("abatiMultaPercen",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("abatiMultaPrazo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("abatiMultaValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("acoesDespesasCartorarias",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("acoesHistorico",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeGrupo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("acoesServicoTitulo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("acoesValorRecebido",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("bloqCodigoBarrasFormatado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("bloqCodigoBarrasNumerico",
                StringType.create(),
                false,
                true));
        properties.add(new Property("bloqDescricaoMensagem",
                StringType.create(),
                false,
                true));
        properties.add(new Property("bloqTipoMensagem",
                LongType.create(),
                false,
                true));
        properties.add(new Property("bloqDigitoCtrlNossoNumero",
                LongType.create(),
                false,
                true));
        properties.add(new Property("princiDataDocumento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("blqexpdummyDataProcessamento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("princiModalidade",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiPvVinculacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("classificacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("cobrarTarifa",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoProtocolo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("compleAbatimento",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("compleDescontoDoisData",
                DateType.create(),
                false,
                true));
        // properties.add(new Property("compleDescontoDoisPercen",
        // LongType.create(), false, true));
        properties.add(new Property("compleDescontoDoisPercen",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("compleDescontoDoisPrazo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("compleDescontoDoisValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("compleDescontoTresData",
                DateType.create(),
                false,
                true));
        // properties.add(new Property("compleDescontoTresPercen",
        // LongType.create(), false, true));
        properties.add(new Property("compleDescontoTresPercen",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("compleDescontoTresPrazo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("compleDescontoTresValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("compleDescontoUmData",
                DateType.create(),
                false,
                true));
        // properties.add(new Property("compleDescontoUmPercen",
        // LongType.create(), false, true));
        properties.add(new Property("compleDescontoUmPercen",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("compleDescontoUmPrazo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("compleDescontoUmValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("compleMultaData",
                DateType.create(),
                false,
                true));
        // properties.add(new Property("compleMultaPercen", LongType.create(),
        // false, true));
        properties.add(new Property("compleMultaPercen",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("compleMultaPrazo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("compleMultaValor",
                MoneyType.create(),
                false,
                true));
        // properties.add(new Property("complePercenJurosMes",
        // LongType.create(), false, true));
        properties.add(new Property("complePercenJurosMes",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("compleSacadorCpfCnpj",
                LongType.create(),
                false,
                true));
        properties.add(new Property("compleSacadorNome",
                StringType.create(),
                false,
                true));
        properties.add(new Property("compleSacadorTipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("compleTipoJurosMes",
                LongType.create(),
                false,
                true));
        properties.add(new Property("comunicacaoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataProtocolo",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataSolicitacao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("filtroVoltarListarTitulo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("filtroVoltarListarConsolidado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("filtroVoltarAcao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("filtroDescricaoClassificacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("filtroDescricaoSituacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("liquiAbatimento",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("liquiCanalLiquidacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("liquiDataCredito",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataInicio",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataFim",
                DateType.create(),
                false,
                true));
        properties.add(new Property("liquiDataLiquidacao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("liquiDataPagamento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("liquiDiasFloat",
                LongType.create(),
                false,
                true));
        properties.add(new Property("liquiValorLiquidoRecebido",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("retidoValorIOF",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("liquiValorDesconto",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("liquiValorDocumento",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("liquiValorJurosMulta",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("meioEntrada",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nossoNumero",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nossoNumeroFim",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCartorio",
                LongType.create(),
                false,
                true));
        properties.add(new Property("ordProtDataMovimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("princiAceite",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiDataVencimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("princiDescricaoAceite",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiDescricaoEspecie",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiDescricaoPvCobrador",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiDescricaoSituacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiEndosso",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiEspecie",
                LongType.create(),
                false,
                true));
        properties.add(new Property("princiIndicadorProt",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiMeioEntrada",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiMoeda",
                LongType.create(),
                false,
                true));
        properties.add(new Property("princiNumeroDocumento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiPrazoProtDev",
                LongType.create(),
                false,
                true));
        properties.add(new Property("princiPvCobrador",
                LongType.create(),
                false,
                true));
        properties.add(new Property("princiSacadoBairro",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiSacadoCep",
                LongType.create(),
                false,
                true));
        properties.add(new Property("princiSacadoComplemento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiSacadoCpfCnpj",
                LongType.create(),
                false,
                true));
        properties.add(new Property("princiSacadoEmail",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiSacadoLogradouro",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiSacadoMunicipio",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiSacadoNome",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiSacadoNumero",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiSacadoTipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("princiSacadoUf",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiSiglaEspecie",
                StringType.create(),
                false,
                true));
        properties.add(new Property("princiSituacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("princiValorTitulo",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("filtroSelecao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nossoNumeroLiq",
                LongType.create(),
                false,
                true));
        properties.add(new Property("situacao", LongType.create(), false, true));
        
        properties.add(new Property("pagina", LongType.create(), false, true));

        // Item 4 SISOL 147829 EXTOU
        properties.add(new Property("emissaoBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("envioBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("unidadeCobradora",
                LongType.create(),
                false,
                true));
        
        properties.add(new Property("codBarras1",
        		 StringType.create(),
                false,
                true));
        
        properties.add(new Property("codBarras2",
        		 StringType.create(),
                false,
                true));
        properties.add(new Property("codBarras3",
        		 StringType.create(),
                false,
                true));
        properties.add(new Property("codBarras4",
        		 StringType.create(),
                false,
                true));
        properties.add(new Property("codBarras5",
        		 StringType.create(),
                false,
                true));
        
        properties.add(new Property("nossoNumeroLiq",
                LongType.create(),
                false,
                true));

        
        //DDA SIGCB
        properties.add(new Property("situacaoBloqSE",
        		StringType.create(),
        		false,
        		true));
        properties.add(new Property("numIdDDA",
        		LongType.create(),
        		false, 
        		true));
        properties.add(new Property("aceiteSE",
        		LongType.create(),
        		false,
        		true));
        properties.add(new Property("alegacaoSE",
        		StringType.create(),
        		false,
        		true));
        
        //IOF
        properties.add(new Property("compleRetidoValorIOF",
                MoneyType.create(),
                false,
                true));
        
        properties.add(new Property("abatiRetidoValorIOF",
                MoneyType.create(),
                false,
                true));
        
        properties.add(new Property("tipoCalculo",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("autorizacao",
                StringType.create(),
                false,
                true));

        properties.add(new Property("iofAtraso",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("iofAtraso61",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("jurosAtraso",
        		 MoneyType.create(),
                false,
                true));
        
        properties.add(new Property("jurosAtrasoMora",
       		 MoneyType.create(),
               false,
               true));
        
        properties.add(new Property("feriadoLocal",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("pvRecebedor",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("pvCobrador",
                StringType.create(),
                false,
                true));
 		properties.add(new Property("parcela",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dddSMS",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("celularSMS",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("filler",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("tipoSMS",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descrEntrega",
                StringType.create(),
                false,
                true));
        properties.add(new Property("icRateio",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("icGarantia",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("dtGarantia",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("coUsuario",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("nsu",
        		LongType.create(),
                false,
                true));
        
        
        properties.add(new Property("observacoes",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("fatorVencimento",
        		LongType.create(),
                false,
                true));
        
        properties.add(new Property("formaPagamento",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("meio",
        		LongType.create(),
                false,
                true));
        
        properties.add(new Property("motivo",
        		StringType.create(),
                false,
                true));

        properties.add(new Property("descrMeio",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("descrFormaPagamento",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("descrMotivo",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("descrSituacao",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("coErro",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("deErro",
        		StringType.create(),
                false,
                true));
        

	 	
        properties.add(new Property("icRegistroCIP",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("nuIdentificaCIP",
        		LongType.create(),
                false,
                true));
        
        properties.add(new Property("nuRefereciaCIP",
        		LongType.create(),
                false,
                true));
        
        properties.add(new Property("sgIndexador",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("icTipoPagamento",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("vrMaximoPgto",
                MoneyType.create(),
                false,
                true));
        
        properties.add(new Property("vrMinPgto",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("icAutPagto",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("cmbEmissao",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("cmbCarteira",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("qtPgtoPossivel",
        		LongType.create(),
                false,
                true));
        
        properties.add(new Property("qtPgtoEfetuado",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("vrSaldoTitulo",
                MoneyType.create(),
                false,
                true));
        
        properties.add(new Property("nuBaixa",
        		LongType.create(),
                false,
                true));
        
        properties.add(new Property("coErroCIP",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("dtCompetencia",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("tipoDesconto",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("valorJuros",
        		MoneyType.create(),
                false,
                true));
        
        properties.add(new Property("datajuros",
        		DateType.create(),
                false,
                true));
        
        properties.add(new Property("tipoJuros",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("tpPessoaPrt",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("cpfCnpjPrt",
        		StringType.create(),
                false,
                true));
        
        properties.add(new Property("snBaixa",
                StringType.create(),
                false,
                true));
        
        
        properties.add(new Property("fixo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("vrDesAba",MoneyType.create(),false,  true));
        properties.add(new Property("vrMltJur",MoneyType.create(),false,  true));
        properties.add(new Property("vrJuros",MoneyType.create(),false,  true));
        properties.add(new Property("vrIof",MoneyType.create(),false,  true));
        properties.add(new Property("vrMulta",MoneyType.create(),false,  true));
        properties.add(new Property("vrDesconto",MoneyType.create(),false,  true));
        properties.add(new Property("vrAbatimento",MoneyType.create(),false,  true));
        properties.add(new Property("vrCalculado",MoneyType.create(),false,  true));
        properties.add(new Property("vrCobrado",MoneyType.create(),false,  true));
        

        
        Layout result = new Layout(properties,
                "TituloBean",
                "br.gov.caixa.sigcb.bean");

        MainframeExtension Mainframe = new MainframeExtension();
        // Mainframe.put("abatiJurosPercen", new LongValue("9(05)"));
        Mainframe.put("abatiJurosPercen", new PercentualValue("9(05)"));
        Mainframe.put("abatiAbatimento", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("princiSacadoCep", new LongValue("9(08)"));
        Mainframe.put("princiSiglaEspecie", new StringValue("X(03)"));
        Mainframe.put("abatiDescontoDoisData", new DateValue("dd.MM.yyyy"));
        Mainframe.put("liquiValorDocumento", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("princiDataDocumento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("blqexpdummyDataProcessamento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("situacao", new LongValue("9(02)"));
        Mainframe.put("liquiValorDesconto", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("cobrarTarifa", new StringValue("X(01)"));
        Mainframe.put("abatiDescontoUmData", new DateValue("dd.MM.yyyy"));
        Mainframe.put("princiEspecie", new LongValue("9(02)"));
        Mainframe.put("compleDescontoTresData", new DateValue("dd.MM.yyyy"));
        Mainframe.put("abatiJurosValor", new MoneyValue("R$ 9(13)v99"));
        // Mainframe.put("complePercenJurosMes", new LongValue("9(05)"));
        Mainframe.put("complePercenJurosMes", new PercentualValue("9(05)"));
        Mainframe.put("acoesServicoTitulo", new LongValue("9(02)"));
        Mainframe.put("compleDescontoUmData", new DateValue("dd.MM.yyyy"));
        Mainframe.put("princiSacadoEmail", new StringValue("X(50)"));
        Mainframe.put("princiMoeda", new LongValue("9(03)"));
        Mainframe.put("abatiMultaValor", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("princiModalidade", new StringValue("X(02)"));
        Mainframe.put("princiSacadoCpfCnpj", new LongValue("9(14)"));
        Mainframe.put("liquiAbatimento", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("princiSacadoLogradouro", new StringValue("X(40)"));
        Mainframe.put("acoesDespesasCartorarias", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("bloqCodigoBarrasNumerico", new StringValue("X(44)"));
        Mainframe.put("bloqDigitoCtrlNossoNumero", new LongValue("9(01)"));
        Mainframe.put("liquiDiasFloat", new LongValue("9(02)"));
        Mainframe.put("princiNumeroDocumento", new StringValue("X(15)"));
        Mainframe.put("princiPvCobrador", new LongValue("9(04)"));
        Mainframe.put("princiSacadoTipoPessoa", new LongValue("9(01)"));
        Mainframe.put("comunicacaoSacado", new StringValue("X(01)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("codigoProtocolo", new LongValue("9(10)"));
        Mainframe.put("ordProtDataMovimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("abatiDescontoTresData", new DateValue("dd.MM.yyyy"));
        Mainframe.put("abatiMultaPrazo", new LongValue("9(03)"));
        Mainframe.put("acoesHistorico", new StringValue("X(100)"));
        Mainframe.put("nomeGrupo", new StringValue("X(06)"));
        // Mainframe.put("compleDescontoTresPercen", new LongValue("9(05)"));
        Mainframe.put("compleDescontoTresPercen", new PercentualValue("9(05)"));
        Mainframe.put("classificacao", new LongValue("9(02)"));
        Mainframe.put("compleAbatimento", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("abatiCustasCartorarias", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("abatiDataPrevisaoProtDev", new DateValue("dd.MM.yyyy"));
        Mainframe.put("abatiDescontoUmValor", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("abatiDescontoTresValor", new MoneyValue("R$ 9(13)v99"));
        // Mainframe.put("compleDescontoDoisPercen", new LongValue("9(05)"));
        Mainframe.put("compleDescontoDoisPercen", new PercentualValue("9(05)"));
        Mainframe.put("liquiValorJurosMulta", new MoneyValue("R$ 9(13)v99"));
        // Mainframe.put("compleDescontoUmPercen", new LongValue("9(05)"));
        Mainframe.put("compleDescontoUmPercen", new PercentualValue("9(05)"));
        Mainframe.put("abatiModalidade", new StringValue("X(02)"));
        Mainframe.put("bloqTipoMensagem", new LongValue("9(01)"));
        Mainframe.put("compleDescontoTresValor", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("compleTipoJurosMes", new LongValue("9(01)"));
        Mainframe.put("dataProtocolo", new DateValue("dd.MM.yyyy"));
        Mainframe.put("abatiMultaData", new DateValue("dd.MM.yyyy"));
        Mainframe.put("compleDescontoUmValor", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("princiDescricaoEspecie", new StringValue("X(40)"));
        Mainframe.put("princiSacadoNumero", new StringValue("X(15)"));
        Mainframe.put("compleMultaData", new DateValue("dd.MM.yyyy"));
        Mainframe.put("bloqCodigoBarrasFormatado", new StringValue("X(56)"));
        Mainframe.put("princiSituacao", new LongValue("9(02)"));
        Mainframe.put("abatiDescontoUmPrazo", new LongValue("9(03)"));
        Mainframe.put("abatiDescontoTresPrazo", new LongValue("9(03)"));
        Mainframe.put("compleSacadorCpfCnpj", new LongValue("9(14)"));
        Mainframe.put("princiDescricaoAceite", new StringValue("X(40)"));
        Mainframe.put("filtroVoltarListarTitulo", new LongValue("9(01)"));
        Mainframe.put("filtroVoltarAcao", new LongValue("9(01)"));
        Mainframe.put("filtroDescricaoSituacao", new StringValue("X(40)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        Mainframe.put("nossoNumeroFim", new LongValue("9(18)"));
        Mainframe.put("numeroCartorio", new LongValue("9(08)"));
        Mainframe.put("compleDescontoTresPrazo", new LongValue("9(03)"));
        Mainframe.put("abatiDataEmissao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("meioEntrada", new LongValue("9(01)"));
        Mainframe.put("liquiDataCredito", new DateValue("dd.MM.yyyy"));
        Mainframe.put("liquiCanalLiquidacao", new StringValue("X(40)"));
        Mainframe.put("princiSacadoComplemento", new StringValue("X(25)"));
        Mainframe.put("liquiDataPagamento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("compleDescontoUmPrazo", new LongValue("9(03)"));
        // Mainframe.put("abatiDescontoUmPercen", new LongValue("9(05)"));
        Mainframe.put("abatiDescontoUmPercen", new PercentualValue("9(05)"));
        Mainframe.put("princiSacadoMunicipio", new StringValue("X(35)"));
        Mainframe.put("princiValorTitulo", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("princiEndosso", new StringValue("X(01)"));
        Mainframe.put("filtroDescricaoClassificacao", new StringValue("X(40)"));
        Mainframe.put("liquiDataLiquidacao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("princiMeioEntrada", new StringValue("X(40)"));
        Mainframe.put("compleMultaValor", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("acoesValorRecebido", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("compleSacadorTipoPessoa", new LongValue("9(01)"));
        Mainframe.put("abatiDescontoDoisValor", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("compleSacadorNome", new StringValue("X(40)"));
        Mainframe.put("princiPrazoProtDev", new LongValue("9(03)"));
        Mainframe.put("princiDataVencimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("princiDescricaoPvCobrador", new StringValue("X(40)"));
        Mainframe.put("princiIndicadorProt", new StringValue("X(01)"));
        Mainframe.put("compleDescontoDoisValor", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("abatiDataEntrada", new DateValue("dd.MM.yyyy"));
        Mainframe.put("abatiJurosData", new DateValue("dd.MM.yyyy"));
        // Mainframe.put("compleMultaPercen", new LongValue("9(05)"));
        Mainframe.put("compleMultaPercen", new PercentualValue("9(05)"));
        Mainframe.put("princiSacadoUf", new StringValue("X(02)"));
        Mainframe.put("princiDescricaoSituacao", new StringValue("X(40)"));
        Mainframe.put("compleMultaPrazo", new LongValue("9(03)"));
        Mainframe.put("princiAceite", new StringValue("X(01)"));
        Mainframe.put("princiSacadoBairro", new StringValue("X(25)"));
        Mainframe.put("princiSacadoNome", new StringValue("X(40)"));
        Mainframe.put("abatiDescontoDoisPrazo", new LongValue("9(03)"));
        // Mainframe.put("abatiDescontoTresPercen", new LongValue("9(05)"));
        Mainframe.put("abatiDescontoTresPercen", new PercentualValue("9(05)"));
        Mainframe.put("compleDescontoDoisData", new DateValue("dd.MM.yyyy"));
        // Mainframe.put("abatiMultaPercen", new LongValue("9(05)"));
        Mainframe.put("abatiMultaPercen", new PercentualValue("9(05)"));
        Mainframe.put("filtroSelecao", new LongValue("9(01)"));
        Mainframe.put("princiPvVinculacao", new LongValue("9(04)"));
        // Mainframe.put("abatiDescontoDoisPercen", new LongValue("9(05)"));
        Mainframe.put("abatiDescontoDoisPercen", new PercentualValue("9(05)"));
        Mainframe.put("bloqDescricaoMensagem", new StringValue("X(80)"));
        Mainframe.put("compleDescontoDoisPrazo", new LongValue("9(03)"));
        Mainframe.put("liquiValorLiquidoRecebido", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("unidadeCobradora", new LongValue("9(04)"));
        Mainframe.put("pagina", new LongValue("9(08)"));
        Mainframe.put("dataSolicitacao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("retidoValorIOF", new MoneyValue("R$ 9(13)v99"));

        // Item 4 SISOL 147829
        Mainframe.put("emissaoBloqueto", new LongValue("9(03)"));
        Mainframe.put("envioBloqueto", new LongValue("9(02)"));
        
        //DDA SIGCB
        Mainframe.put("situacaoBloqSE", new StringValue("X(40)"));
        Mainframe.put("numIdDDA", new LongValue("9(17)"));
        Mainframe.put("aceiteSE", new LongValue("9(02)"));
        Mainframe.put("alegacaoSE", new StringValue("X(40)"));
        
        //IOF
        Mainframe.put("compleRetidoValorIOF", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("abatiRetidoValorIOF", new MoneyValue("R$ 9(13)v99"));
    
        Mainframe.put("tipoCalculo", new StringValue("X(15)"));
        Mainframe.put("autorizacao", new StringValue("X(01)"));
        
        Mainframe.put("iofAtraso", new StringValue("X(15)"));
        Mainframe.put("iofAtraso61", new StringValue("X(15)"));
        Mainframe.put("jurosAtraso",new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("jurosAtrasoMora",new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("feriadoLocal", new StringValue("X(35)"));
        Mainframe.put("pvRecebedor", new StringValue("X(4)"));
        Mainframe.put("pvCobrador", new StringValue("X(4)"));
        Mainframe.put("filler", new StringValue("X(30)"));
        Mainframe.put("dddSMS", new StringValue("X(02)"));
        Mainframe.put("celularSMS", new StringValue("X(09)"));
        Mainframe.put("tipoSMS", new StringValue("X(2)"));
        Mainframe.put("descrEntrega", new StringValue("X(20)"));
        Mainframe.put("icRateio", new StringValue("X(01)"));
        Mainframe.put("icGarantia", new StringValue("X(01)"));
        Mainframe.put("dtGarantia", new StringValue("X(10)"));
        Mainframe.put("coUsuario", new StringValue("X(08)"));
        
        Mainframe.put("nossoNumeroLiq", new LongValue("9(18)"));
        Mainframe.put("nsu", new LongValue("9(09)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("observacoes", new StringValue("X(200)"));
        Mainframe.put("fatorVencimento", new LongValue("9(04)"));
        Mainframe.put("formaPagamento", new LongValue("9(01)"));
        Mainframe.put("motivo", new StringValue("X(80)")); 
        Mainframe.put("codBarras1", new StringValue("X(10)"));
        Mainframe.put("codBarras2", new StringValue("X(11)"));
        Mainframe.put("codBarras3", new StringValue("X(11)"));
        Mainframe.put("codBarras4", new StringValue("X(1)"));
        Mainframe.put("codBarras5", new StringValue("X(14)"));
        Mainframe.put("meio", new LongValue("9(02)"));
        Mainframe.put("dataInicio", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataFim", new DateValue("dd.MM.yyyy"));
        Mainframe.put("descrMeio", new StringValue("X(40)"));
        Mainframe.put("descrFormaPagamento", new StringValue("X(8)"));
        Mainframe.put("descrMotivo", new StringValue("X(80)"));
        Mainframe.put("descrSituacao", new StringValue("X(10)"));
        Mainframe.put("coErro", new StringValue("X(4)"));
        Mainframe.put("deErro", new StringValue("X(80)"));
 		Mainframe.put("parcela", new StringValue("X(07)"));
 		
 		//--Versão 61

	 	
	 	Mainframe.put("icRegistroCIP", new StringValue("X(01)"));
	 	Mainframe.put("nuIdentificaCIP", new LongValue("9(19)"));
	 	Mainframe.put("nuRefereciaCIP", new LongValue("9(19)"));
	 	Mainframe.put("sgIndexador", new StringValue("X(15)"));
	 	Mainframe.put("icTipoPagamento", new StringValue("X(01)"));
	 	Mainframe.put("vrMaximoPgto", new MoneyValue("R$ 9(13)v99"));
	 	Mainframe.put("vrMinPgto", new MoneyValue("R$ 9(13)v99"));
	 	Mainframe.put("icAutPagto", new StringValue("X(01)"));
	 	Mainframe.put("qtPgtoPossivel", new LongValue("9(02)"));
	 	Mainframe.put("qtPgtoEfetuado", new LongValue("9(02)"));
	 	Mainframe.put("vrSaldoTitulo", new MoneyValue("R$ 9(13)v99"));
	 	
	 	Mainframe.put("cmbEmissao", new StringValue("X(02)"));
	 	Mainframe.put("cmbCarteira", new StringValue("X(02)"));
	 	Mainframe.put("nuBaixa", new LongValue("9(19)"));
	 	Mainframe.put("coErroCIP", new StringValue("X(08)"));
	 	Mainframe.put("dtCompetencia", new StringValue("X(10)"));
	 	
	 	
	 	Mainframe.put("datajuros", new DateValue("dd.MM.yyyy"));
	    Mainframe.put("valorJuros", new MoneyValue("R$ 9(13)v99"));
	    Mainframe.put("tipoJuros", new StringValue("X(1)"));
	 	Mainframe.put("tipoDesconto", new StringValue("X(1)"));
		Mainframe.put("tpPessoaPrt", new StringValue("X(1)"));
	 	Mainframe.put("cpfCnpjPrt", new StringValue("X(14)"));
	 	Mainframe.put("snBaixa", new StringValue("X(1)"));
	 	
	 	Mainframe.put("vrDesAba", new MoneyValue("R$ 9(13)v99"));
	 	Mainframe.put("vrMltJur", new MoneyValue("R$ 9(13)v99"));
	 	Mainframe.put("vrJuros", new MoneyValue("R$ 9(13)v99"));
	 	Mainframe.put("vrIof", new MoneyValue("R$ 9(13)v99"));
	 	Mainframe.put("vrMulta", new MoneyValue("R$ 9(13)v99"));
	 	Mainframe.put("vrDesconto", new MoneyValue("R$ 9(13)v99"));
	 	Mainframe.put("vrAbatimento", new MoneyValue("R$ 9(13)v99"));
	 	Mainframe.put("vrCalculado", new MoneyValue("R$ 9(13)v99"));
	 	Mainframe.put("vrCobrado", new MoneyValue("R$ 9(13)v99"));
	 	
		Mainframe.put("fixo", new StringValue("X(10)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
