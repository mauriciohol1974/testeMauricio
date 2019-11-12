// !!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!

package br.gov.caixa.sigcb.bean;

import java.text.DecimalFormat;

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
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.estrategia.dda.DdaGeraisEstrategia;
import br.gov.caixa.sigcb.estrategia.dda.DdaReimpBloquetoEstrategia;
import br.gov.caixa.sigcb.util.Formatador;

/**
 * Projeto: SIGCB Componente responsável pelo controle da funcionalidade
 * CONSULTAS GERAIS DO DDA Criada em: 01/10/2009
 * 
 * @author Glauber Gallego - glauber.gallego@probank.com.br
 */
public class DdaGeraisBean extends SigcbBean {

	/* ////////////////////////////////////////////////////// */

	// -------------------------------- FILTRO
	private java.lang.String tipoPessoaSacado;

	private java.lang.Long cpfCnpjSacado;

	private java.lang.Long tipoDataFiltro;

	private java.lang.Long tipoDataFiltroForm;

	private java.lang.String mesAnoFiltro;

	private java.util.Date dataFiltro;

	private java.lang.Long tipoConsulta;

	private java.lang.Long tipoConsultaForm;

	// -------------------------------- LISTA QTDE/VALOR CONSOLIDADO POR
	// CPF/CNPJ

	private java.lang.Long quantidadePorCpfCnpj;

	private br.com.politec.sao.util.Money valorPorCpfCnpj;

	private java.util.Date dataMovimento;

	// -------------------------------- LISTA TITULOS CIP

	private java.lang.String numeroControleRequisicao;

	private java.lang.Long numeroIdentificacaoDda;

	private java.util.Date dataVencimento;

	private java.util.Date dataPagamento;

	private br.com.politec.sao.util.Money valorTitulo;

	private java.lang.Long quantidadeAceite;

	private br.com.politec.sao.util.Money valorAceite;

	private java.lang.Long quantidadeNaoAceite;

	private br.com.politec.sao.util.Money valorNaoAceite;

	private java.lang.String aceite;

	// -------------------------------- DETALHE TITULO

	private java.lang.Long tipoBloquetoDda;

	private java.lang.Long codigoBancoCedente;

	private java.lang.String nomeBancoCedente;

	private java.lang.Long agenciaCedente;

	private java.lang.String tipoPessoaCedente;

	private java.lang.Long cpfCnpjCedente;

	private java.lang.String codigoCedente;

	private java.lang.String nomeCedente;

	private java.lang.String enderecoCedente;

	private java.lang.String municipioCedente;

	private java.lang.String ufCedente;

	private java.lang.Long cepCedente;

	private java.lang.String nomeSacado;

	private java.lang.String enderecoSacado;

	private java.lang.String municipioSacado;

	private java.lang.String ufSacado;

	private java.lang.Long cepSacado;

	private java.lang.String tipoPessoaSacador;

	private java.lang.Long cpfCnpjSacador;

	private java.lang.String nomeSacador;

	private java.lang.String tipoPessoaTerceiro;

	private java.lang.Long cpfCnpjTerceiro;

	private java.util.Date dataDocumento;

	private java.util.Date dataProcessamento;

	private java.lang.String nossoNumero;

	private java.lang.String numeroDocumento;

	private java.lang.String codigoTipoEspecie;

	private java.lang.String descricaoTipoEspecie;

	private java.lang.String codigoTipoCarteira;

	private java.lang.String descricaoTipoCarteira;

	private java.lang.String descricaoTipoAceite;

	private br.com.politec.sao.util.Money valorAbatimento;

	private java.util.Date dataJuros;

	private java.lang.Long tipoJuros;

	private br.com.politec.sao.util.Money valorJuros;

	private java.lang.Long percentualJuros;

	private java.util.Date dataMulta;

	private br.com.politec.sao.util.Money valorMulta;

	private java.lang.Long percentualMulta;

	private java.lang.String descricaoGrupoDesconto;

	private java.util.Date dataDesconto;

	private java.lang.String tipoDesconto;

	private br.com.politec.sao.util.Money valorDesconto;

	private java.lang.Long percentualDesconto;

	private java.lang.String codigoMoeda;

	private java.lang.String nomeMoeda;

	private java.lang.String descricaoMoeda;

	private java.lang.String indicadorTituloNegociado;

	private java.lang.String indicadorInformacaoAdicional;

	private java.lang.String codigoBarrasFormatado;

	private java.lang.String codigoBarrasNumerico;

	/* ////////////////////////////////////////////////////// */

	public DdaGeraisBean() {
		this.tipoPessoaSacado = null;
		this.cpfCnpjSacado = null;
		this.tipoDataFiltro = null;
		this.tipoDataFiltroForm = null;
		this.mesAnoFiltro = null;
		this.dataFiltro = null;
		this.tipoConsulta = null;
		this.tipoConsultaForm = null;
		this.quantidadePorCpfCnpj = null;
		this.valorPorCpfCnpj = null;
		this.dataMovimento = null;
		this.numeroControleRequisicao = null;
		this.numeroIdentificacaoDda = null;
		this.dataVencimento = null;
		this.dataPagamento = null;
		this.valorTitulo = null;
		this.quantidadeAceite = null;
		this.valorAceite = null;
		this.quantidadeNaoAceite = null;
		this.valorNaoAceite = null;
		this.aceite = null;
		this.tipoBloquetoDda = null;
		this.codigoBancoCedente = null;
		this.nomeBancoCedente = null;
		this.agenciaCedente = null;
		this.tipoPessoaCedente = null;
		this.cpfCnpjCedente = null;
		this.codigoCedente = null;
		this.nomeCedente = null;
		this.enderecoCedente = null;
		this.municipioCedente = null;
		this.ufCedente = null;
		this.cepCedente = null;
		this.nomeSacado = null;
		this.enderecoSacado = null;
		this.municipioSacado = null;
		this.ufSacado = null;
		this.cepSacado = null;
		this.tipoPessoaSacador = null;
		this.cpfCnpjSacador = null;
		this.nomeSacador = null;
		this.tipoPessoaTerceiro = null;
		this.cpfCnpjTerceiro = null;
		this.dataDocumento = null;
		this.dataProcessamento = null;
		this.nossoNumero = null;
		this.numeroDocumento = null;
		this.codigoTipoEspecie = null;
		this.descricaoTipoEspecie = null;
		this.codigoTipoCarteira = null;
		this.descricaoTipoCarteira = null;
		this.descricaoTipoAceite = null;
		this.valorAbatimento = null;
		this.dataJuros = null;
		this.tipoJuros = null;
		this.valorJuros = null;
		this.percentualJuros = null;
		this.dataMulta = null;
		this.valorMulta = null;
		this.percentualMulta = null;
		this.descricaoGrupoDesconto = null;
		this.dataDesconto = null;
		this.tipoDesconto = null;
		this.valorDesconto = null;
		this.percentualDesconto = null;
		this.codigoMoeda = null;
		this.nomeMoeda = null;
		this.descricaoMoeda = null;
		this.indicadorTituloNegociado = null;
		this.indicadorInformacaoAdicional = null;
		this.codigoBarrasFormatado = null;
		this.codigoBarrasNumerico = null;
	}

	/* ////////////////////////////////////////////////////// */

	public String getApplicationName() {
		return "DdaGeraisFiltroBean";
	}

	/* ////////////////////////////////////////////////////// */

	public java.lang.String getTipoPessoaSacado() {
		return this.tipoPessoaSacado;
	}

	public void setTipoPessoaSacado(java.lang.String tipoPessoaSacado) {
		this.tipoPessoaSacado = tipoPessoaSacado;
	}

	public java.lang.Long getCpfCnpjSacado() {
		return this.cpfCnpjSacado;
	}

	public void setCpfCnpjSacado(java.lang.Long cpfCnpjSacado) {
		this.cpfCnpjSacado = cpfCnpjSacado;
	}

	public java.lang.Long getTipoDataFiltro() {
		return this.tipoDataFiltro;
	}

	public void setTipoDataFiltro(java.lang.Long tipoDataFiltro) {
		this.tipoDataFiltro = tipoDataFiltro;
	}

	public java.lang.Long getTipoDataFiltroForm() {
		return this.tipoDataFiltroForm;
	}

	public void setTipoDataFiltroForm(java.lang.Long tipoDataFiltroForm) {
		this.tipoDataFiltroForm = tipoDataFiltroForm;
	}

	public java.lang.String getMesAnoFiltro() {
		return this.mesAnoFiltro;
	}

	public void setMesAnoFiltro(java.lang.String mesAnoFiltro) {
		this.mesAnoFiltro = mesAnoFiltro;
	}

	public java.util.Date getDataFiltro() {
		return this.dataFiltro;
	}

	public void setDataFiltro(java.util.Date dataFiltro) {
		this.dataFiltro = dataFiltro;
	}

	public java.lang.Long getTipoConsulta() {
		return this.tipoConsulta;
	}

	public void setTipoConsulta(java.lang.Long tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public java.lang.Long getTipoConsultaForm() {
		return this.tipoConsultaForm;
	}

	public void setTipoConsultaForm(java.lang.Long tipoConsultaForm) {
		this.tipoConsultaForm = tipoConsultaForm;
	}

	public java.lang.Long getQuantidadePorCpfCnpj() {
		return quantidadePorCpfCnpj;
	}

	public void setQuantidadePorCpfCnpj(java.lang.Long quantidadePorCpfCnpj) {
		this.quantidadePorCpfCnpj = quantidadePorCpfCnpj;
	}

	public br.com.politec.sao.util.Money getValorPorCpfCnpj() {
		return valorPorCpfCnpj;
	}

	public void setValorPorCpfCnpj(br.com.politec.sao.util.Money valorPorCpfCnpj) {
		this.valorPorCpfCnpj = valorPorCpfCnpj;
	}

	public java.util.Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(java.util.Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public java.lang.String getNumeroControleRequisicao() {
		return numeroControleRequisicao;
	}

	public void setNumeroControleRequisicao(
			java.lang.String numeroControleRequisicao) {
		this.numeroControleRequisicao = numeroControleRequisicao;
	}

	public java.lang.Long getNumeroIdentificacaoDda() {
		return numeroIdentificacaoDda;
	}

	public void setNumeroIdentificacaoDda(java.lang.Long numeroIdentificacaoDda) {
		this.numeroIdentificacaoDda = numeroIdentificacaoDda;
	}

	public java.util.Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(java.util.Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public java.util.Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(java.util.Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public br.com.politec.sao.util.Money getValorTitulo() {
		return valorTitulo;
	}

	public void setValorTitulo(br.com.politec.sao.util.Money valorTitulo) {
		this.valorTitulo = valorTitulo;
	}

	public java.lang.Long getQuantidadeAceite() {
		return quantidadeAceite;
	}

	public void setQuantidadeAceite(java.lang.Long quantidadeAceite) {
		this.quantidadeAceite = quantidadeAceite;
	}

	public br.com.politec.sao.util.Money getValorAceite() {
		return valorAceite;
	}

	public void setValorAceite(br.com.politec.sao.util.Money valorAceite) {
		this.valorAceite = valorAceite;
	}

	public java.lang.Long getQuantidadeNaoAceite() {
		return quantidadeNaoAceite;
	}

	public void setQuantidadeNaoAceite(java.lang.Long quantidadeNaoAceite) {
		this.quantidadeNaoAceite = quantidadeNaoAceite;
	}

	public br.com.politec.sao.util.Money getValorNaoAceite() {
		return valorNaoAceite;
	}

	public void setValorNaoAceite(br.com.politec.sao.util.Money valorNaoAceite) {
		this.valorNaoAceite = valorNaoAceite;
	}

	public java.lang.String getAceite() {
		return aceite;
	}

	public void setAceite(java.lang.String aceite) {
		this.aceite = aceite;
	}

	public java.lang.Long getTipoBloquetoDda() {
		return this.tipoBloquetoDda;
	}

	public void setTipoBloquetoDda(java.lang.Long tipoBloquetoDda) {
		this.tipoBloquetoDda = tipoBloquetoDda;
	}

	public java.lang.Long getCodigoBancoCedente() {
		return codigoBancoCedente;
	}

	public void setCodigoBancoCedente(java.lang.Long codigoBancoCedente) {
		this.codigoBancoCedente = codigoBancoCedente;
	}

	public java.lang.String getNomeBancoCedente() {
		return nomeBancoCedente;
	}

	public void setNomeBancoCedente(java.lang.String nomeBancoCedente) {
		this.nomeBancoCedente = nomeBancoCedente;
	}

	public java.lang.Long getAgenciaCedente() {
		return agenciaCedente;
	}

	public void setAgenciaCedente(java.lang.Long agenciaCedente) {
		this.agenciaCedente = agenciaCedente;
	}

	public java.lang.String getTipoPessoaCedente() {
		return tipoPessoaCedente;
	}

	public void setTipoPessoaCedente(java.lang.String tipoPessoaCedente) {
		this.tipoPessoaCedente = tipoPessoaCedente;
	}

	public java.lang.Long getCpfCnpjCedente() {
		return cpfCnpjCedente;
	}

	public void setCpfCnpjCedente(java.lang.Long cpfCnpjCedente) {
		this.cpfCnpjCedente = cpfCnpjCedente;
	}

	public java.lang.String getCodigoCedente() {
		return codigoCedente;
	}

	public void setCodigoCedente(java.lang.String codigoCedente) {
		this.codigoCedente = codigoCedente;
	}

	public java.lang.String getNomeCedente() {
		return nomeCedente;
	}

	public void setNomeCedente(java.lang.String nomeCedente) {
		this.nomeCedente = nomeCedente;
	}

	public java.lang.String getEnderecoCedente() {
		return enderecoCedente;
	}

	public void setEnderecoCedente(java.lang.String enderecoCedente) {
		this.enderecoCedente = enderecoCedente;
	}

	public java.lang.String getMunicipioCedente() {
		return municipioCedente;
	}

	public void setMunicipioCedente(java.lang.String municipioCedente) {
		this.municipioCedente = municipioCedente;
	}

	public java.lang.String getUfCedente() {
		return ufCedente;
	}

	public void setUfCedente(java.lang.String ufCedente) {
		this.ufCedente = ufCedente;
	}

	public java.lang.Long getCepCedente() {
		return cepCedente;
	}

	public void setCepCedente(java.lang.Long cepCedente) {
		this.cepCedente = cepCedente;
	}

	public java.lang.String getNomeSacado() {
		return nomeSacado;
	}

	public void setNomeSacado(java.lang.String nomeSacado) {
		this.nomeSacado = nomeSacado;
	}

	public java.lang.String getEnderecoSacado() {
		return enderecoSacado;
	}

	public void setEnderecoSacado(java.lang.String enderecoSacado) {
		this.enderecoSacado = enderecoSacado;
	}

	public java.lang.String getMunicipioSacado() {
		return municipioSacado;
	}

	public void setMunicipioSacado(java.lang.String municipioSacado) {
		this.municipioSacado = municipioSacado;
	}

	public java.lang.String getUfSacado() {
		return ufSacado;
	}

	public void setUfSacado(java.lang.String ufSacado) {
		this.ufSacado = ufSacado;
	}

	public java.lang.Long getCepSacado() {
		return cepSacado;
	}

	public void setCepSacado(java.lang.Long cepSacado) {
		this.cepSacado = cepSacado;
	}

	public java.lang.String getTipoPessoaSacador() {
		return this.tipoPessoaSacador;
	}

	public void setTipoPessoaSacador(java.lang.String tipoPessoaSacador) {
		this.tipoPessoaSacador = tipoPessoaSacador;
	}

	public java.lang.Long getCpfCnpjSacador() {
		return this.cpfCnpjSacador;
	}

	public void setCpfCnpjSacador(java.lang.Long cpfCnpjSacador) {
		this.cpfCnpjSacador = cpfCnpjSacador;
	}

	public java.lang.String getNomeSacador() {
		return nomeSacador;
	}

	public void setNomeSacador(java.lang.String nomeSacador) {
		this.nomeSacador = nomeSacador;
	}

	public java.lang.String getTipoPessoaTerceiro() {
		return this.tipoPessoaTerceiro;
	}

	public void setTipoPessoaTerceiro(java.lang.String tipoPessoaTerceiro) {
		this.tipoPessoaTerceiro = tipoPessoaTerceiro;
	}

	public java.lang.Long getCpfCnpjTerceiro() {
		return cpfCnpjTerceiro;
	}

	public void setCpfCnpjTerceiro(java.lang.Long cpfCnpjTerceiro) {
		this.cpfCnpjTerceiro = cpfCnpjTerceiro;
	}

	public java.util.Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(java.util.Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public java.util.Date getDataProcessamento() {
		return dataProcessamento;
	}

	public void setDataProcessamento(java.util.Date dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}

	public java.lang.String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(java.lang.String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public java.lang.String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(java.lang.String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public java.lang.String getCodigoTipoEspecie() {
		return codigoTipoEspecie;
	}

	public void setCodigoTipoEspecie(java.lang.String codigoTipoEspecie) {
		this.codigoTipoEspecie = codigoTipoEspecie;
	}

	public java.lang.String getDescricaoTipoEspecie() {
		return descricaoTipoEspecie;
	}

	public void setDescricaoTipoEspecie(java.lang.String descricaoTipoEspecie) {
		this.descricaoTipoEspecie = descricaoTipoEspecie;
	}

	public java.lang.String getCodigoTipoCarteira() {
		return codigoTipoCarteira;
	}

	public void setCodigoTipoCarteira(java.lang.String codigoTipoCarteira) {
		this.codigoTipoCarteira = codigoTipoCarteira;
	}

	public java.lang.String getDescricaoTipoCarteira() {
		return descricaoTipoCarteira;
	}

	public void setDescricaoTipoCarteira(java.lang.String descricaoTipoCarteira) {
		this.descricaoTipoCarteira = descricaoTipoCarteira;
	}

	public java.lang.String getDescricaoTipoAceite() {
		return descricaoTipoAceite;
	}

	public void setDescricaoTipoAceite(java.lang.String descricaoTipoAceite) {
		this.descricaoTipoAceite = descricaoTipoAceite;
	}

	public br.com.politec.sao.util.Money getValorAbatimento() {
		return valorAbatimento;
	}

	public void setValorAbatimento(br.com.politec.sao.util.Money valorAbatimento) {
		this.valorAbatimento = valorAbatimento;
	}

	public java.util.Date getDataJuros() {
		return dataJuros;
	}

	public void setDataJuros(java.util.Date dataJuros) {
		this.dataJuros = dataJuros;
	}

	public java.lang.Long getTipoJuros() {
		return tipoJuros;
	}

	public void setTipoJuros(java.lang.Long tipoJuros) {
		this.tipoJuros = tipoJuros;
	}

	public br.com.politec.sao.util.Money getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(br.com.politec.sao.util.Money valorJuros) {
		this.valorJuros = valorJuros;
	}

	public java.lang.Long getPercentualJuros() {
		return percentualJuros;
	}

	public void setPercentualJuros(java.lang.Long percentualJuros) {
		this.percentualJuros = percentualJuros;
	}

	public java.util.Date getDataMulta() {
		return dataMulta;
	}

	public void setDataMulta(java.util.Date dataMulta) {
		this.dataMulta = dataMulta;
	}

	public br.com.politec.sao.util.Money getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(br.com.politec.sao.util.Money valorMulta) {
		this.valorMulta = valorMulta;
	}

	public java.lang.Long getPercentualMulta() {
		return percentualMulta;
	}

	public void setPercentualMulta(java.lang.Long percentualMulta) {
		this.percentualMulta = percentualMulta;
	}

	public java.lang.String getDescricaoGrupoDesconto() {
		return descricaoGrupoDesconto;
	}

	public void setDescricaoGrupoDesconto(
			java.lang.String descricaoGrupoDesconto) {
		this.descricaoGrupoDesconto = descricaoGrupoDesconto;
	}

	public java.util.Date getDataDesconto() {
		return dataDesconto;
	}

	public void setDataDesconto(java.util.Date dataDesconto) {
		this.dataDesconto = dataDesconto;
	}

	public java.lang.String getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(java.lang.String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public br.com.politec.sao.util.Money getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(br.com.politec.sao.util.Money valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public java.lang.Long getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(java.lang.Long percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public java.lang.String getCodigoMoeda() {
		return codigoMoeda;
	}

	public void setCodigoMoeda(java.lang.String codigoMoeda) {
		this.codigoMoeda = codigoMoeda;
	}

	public java.lang.String getNomeMoeda() {
		return nomeMoeda;
	}

	public void setNomeMoeda(java.lang.String nomeMoeda) {
		this.nomeMoeda = nomeMoeda;
	}

	public java.lang.String getDescricaoMoeda() {
		return descricaoMoeda;
	}

	public void setDescricaoMoeda(java.lang.String descricaoMoeda) {
		this.descricaoMoeda = descricaoMoeda;
	}

	public java.lang.String getIndicadorTituloNegociado() {
		return indicadorTituloNegociado;
	}

	public void setIndicadorTituloNegociado(
			java.lang.String indicadorTituloNegociado) {
		this.indicadorTituloNegociado = indicadorTituloNegociado;
	}

	public java.lang.String getIndicadorInformacaoAdicional() {
		return indicadorInformacaoAdicional;
	}

	public void setIndicadorInformacaoAdicional(
			java.lang.String indicadorInformacaoAdicional) {
		this.indicadorInformacaoAdicional = indicadorInformacaoAdicional;
	}

	public java.lang.String getCodigoBarrasFormatado() {
		return codigoBarrasFormatado;
	}

	public void setCodigoBarrasFormatado(java.lang.String codigoBarrasFormatado) {
		this.codigoBarrasFormatado = codigoBarrasFormatado;
	}

	public java.lang.String getCodigoBarrasNumerico() {
		return codigoBarrasNumerico;
	}

	public void setCodigoBarrasNumerico(java.lang.String codigoBarrasNumerico) {
		this.codigoBarrasNumerico = codigoBarrasNumerico;
	}

	/* ////////////////////////////////////////////////////// */

	// -------------------------------- DATAS
	public String getDataFiltroFormatada() {
		String strRetorno = "";
		if (this.tipoDataFiltro != null) {
			if (this.tipoDataFiltro.equals(new Long(2))) {
				if (this.dataFiltro != null) {
					strRetorno = Formatador.formatarData(this.dataFiltro);
				}
			} else if (this.tipoDataFiltro.equals(new Long(1))) {
				if (this.mesAnoFiltro != null) {
					strRetorno = mesAnoFiltro.replace('.', '/');
				}
			}
		}
		return strRetorno;
	}

	public String getDataVencimentoFormatada() {
		return Formatador.formatarData(this.dataVencimento);
	}

	public String getDataPagamentoFormatada() {
		return Formatador.formatarData(this.dataPagamento);
	}

	public String getDataMovimentoFormatada() {
		return Formatador.formatarData(this.dataMovimento);
	}

	public String getDataDocumentoFormatada() {
		return Formatador.formatarData(this.dataDocumento);
	}

	public String getDataProcessamentoFormatada() {
		return Formatador.formatarData(this.dataProcessamento);
	}

	public String getDataJurosFormatada() {
		return Formatador.formatarData(this.dataJuros);
	}

	public String getDataMultaFormatada() {
		return Formatador.formatarData(this.dataMulta);
	}

	public String getDataDescontoFormatada() {
		return Formatador.formatarData(this.dataDesconto);
	}

	// -------------------------------- TipoBloqueto

	public java.lang.String getTipoBloquetoDdaTexto() {
		if (this.tipoBloquetoDda != null) {
			String[] strConsulta = new String[] {
					DdaReimpBloquetoEstrategia.MENSAGEM_TODOS, // 1
					DdaReimpBloquetoEstrategia.MENSAGEM_CAIXACOBREGISTRADO, // 2
					DdaReimpBloquetoEstrategia.MENSAGEM_CAIXAGCBREGISTRADO, // 3
					DdaReimpBloquetoEstrategia.MENSAGEM_CAIXACOBSEMREGISTRO, // 4
					DdaReimpBloquetoEstrategia.MENSAGEM_CAIXAGCBSEMREGISTRO, // 5
					DdaReimpBloquetoEstrategia.MENSAGEM_OUTROS, // 6
			};
			return strConsulta[this.tipoBloquetoDda.intValue() == 0 ? 0
					: this.tipoBloquetoDda.intValue() - 1];
		}
		return "";
	}

	// -------------------------------- TipoConsulta

	public java.lang.String getTipoConsultaTexto() {
		if (this.tipoConsulta != null) {
			String[] strConsulta = new String[] {
					DdaGeraisEstrategia.MENSAGEM_TITULOSENVIADOS, // 0
					DdaGeraisEstrategia.MENSAGEM_TITULOSPAGOS, // 1
					DdaGeraisEstrategia.MENSAGEM_ACEITEALEGACAO, // 2
					DdaGeraisEstrategia.MENSAGEM_TITULOSVENCIDOS, // 3
					DdaGeraisEstrategia.MENSAGEM_QUARENTENA, // 4
					DdaGeraisEstrategia.MENSAGEM_TITULOSSACADOEXCLUIDO, // 5
			};
			return strConsulta[this.tipoConsulta.intValue()];
		}
		return "";
	}

	// -------------------------------- TipoData

	public String getTipoDataFiltroTexto() {
		String strRetorno = "";
		if (this.tipoDataFiltro != null) {
			if (this.tipoDataFiltro.equals(new Long(2))) {
				strRetorno = "DATA";
			} else if (this.tipoDataFiltro.equals(new Long(1))) {
				strRetorno = "MES/ANO";
			}
		}
		return strRetorno;
	}

	// -------------------------------- TipoPessoa

	public java.lang.String getTipoPessoaCedenteTexto() {
		String tipoPessoaCedenteTexto = "";

		if (this.getTipoPessoaCedente() != null) {
			if (this.getTipoPessoaCedente().equals("F")) {
				tipoPessoaCedenteTexto = "FISICA";
			} else if (this.getTipoPessoaCedente().equals("J")) {
				tipoPessoaCedenteTexto = "JURIDICA";
			} else {
				tipoPessoaCedenteTexto = "";
			}
		}

		return tipoPessoaCedenteTexto;
	}

	public java.lang.String getTipoPessoaSacadoTexto() {
		String tipoPessoaSacadoTexto = "";

		if (this.getTipoPessoaSacado() != null) {
			if (this.getTipoPessoaSacado().equals("F")) {
				tipoPessoaSacadoTexto = "FISICA";
			} else if (this.getTipoPessoaSacado().equals("J")) {
				tipoPessoaSacadoTexto = "JURIDICA";
			} else {
				tipoPessoaSacadoTexto = "";
			}
		}

		return tipoPessoaSacadoTexto;
	}

	public java.lang.String getTipoPessoaSacadorTexto() {
		String tipoPessoaSacadorTexto = "";

		if (this.getTipoPessoaSacador() != null) {
			if (this.getTipoPessoaSacador().equals("F")) {
				tipoPessoaSacadorTexto = "FISICA";
			} else if (this.getTipoPessoaSacador().equals("J")) {
				tipoPessoaSacadorTexto = "JURIDICA";
			} else {
				tipoPessoaSacadorTexto = "";
			}
		}

		return tipoPessoaSacadorTexto;
	}

	public java.lang.String getTipoPessoaTerceiroTexto() {
		String tipoPessoaTerceiroTexto = "";

		if (this.getTipoPessoaTerceiro() != null) {
			if (this.getTipoPessoaTerceiro().equals("F")) {
				tipoPessoaTerceiroTexto = "FISICA";
			} else if (this.getTipoPessoaTerceiro().equals("J")) {
				tipoPessoaTerceiroTexto = "JURIDICA";
			} else {
				tipoPessoaTerceiroTexto = "";
			}
		}

		return tipoPessoaTerceiroTexto;
	}

	// -------------------------------- CpfCnpj

	public java.lang.String getCpfCnpjCedenteFormatado() {
		String cpfCnpjCedenteTexto = "";
		if (this.tipoPessoaCedente != null && this.cpfCnpjCedente != null) {
			if (this.getTipoPessoaCedente().equals("F")) {
				cpfCnpjCedenteTexto = Formatacao.formataNumerico(this
						.getCpfCnpjCedente().toString(), 11);
			} else if (this.getTipoPessoaCedente().equals("J")) {
				cpfCnpjCedenteTexto = Formatacao.formataNumerico(this
						.getCpfCnpjCedente().toString(), 14);
			}
			cpfCnpjCedenteTexto = Formatacao
					.formataCPFCNPJ(cpfCnpjCedenteTexto);
		}
		return cpfCnpjCedenteTexto;
	}

	public java.lang.String getCpfCnpjSacadoFormatado() {
		String cpfCnpjSacadoTexto = "";
		if (this.tipoPessoaSacado != null && this.cpfCnpjSacado != null) {
			if (this.getTipoPessoaSacado().equals("F")) {
				cpfCnpjSacadoTexto = Formatacao.formataNumerico(this
						.getCpfCnpjSacado().toString(), 11);
			} else if (this.getTipoPessoaSacado().equals("J")) {
				cpfCnpjSacadoTexto = Formatacao.formataNumerico(this
						.getCpfCnpjSacado().toString(), 14);
			}
			cpfCnpjSacadoTexto = Formatacao.formataCPFCNPJ(cpfCnpjSacadoTexto);
		}
		return cpfCnpjSacadoTexto;
	}

	public java.lang.String getCpfCnpjTerceiroFormatado() {
		String cpfCnpjTerceiroTexto = "";
		if (this.tipoPessoaTerceiro != null && this.cpfCnpjTerceiro != null) {
			if (this.getTipoPessoaTerceiro().equals("F")) {
				cpfCnpjTerceiroTexto = Formatacao.formataNumerico(this
						.getCpfCnpjTerceiro().toString(), 11);
			} else if (this.getTipoPessoaTerceiro().equals("J")) {
				cpfCnpjTerceiroTexto = Formatacao.formataNumerico(this
						.getCpfCnpjTerceiro().toString(), 14);
			}
			cpfCnpjTerceiroTexto = Formatacao
					.formataCPFCNPJ(cpfCnpjTerceiroTexto);
		}
		return cpfCnpjTerceiroTexto;
	}

	// -------------------------------- Percentuais formatados (03)v99999
	// (000,00000)

	public java.lang.String getPercentualJurosFormatado() {
		String percentualJurosTexto = "";
		if (this.percentualJuros != null && this.percentualJuros != 0) {
			DecimalFormat df = new DecimalFormat("##000000");
			percentualJurosTexto = df.format(this.percentualJuros);
		} else {
			percentualJurosTexto = "000000";
		}
		percentualJurosTexto = Formatacao.colocaVirgula(percentualJurosTexto,
				',', 5);
		return percentualJurosTexto;
	}

	public java.lang.String getPercentualMultaFormatado() {
		String percentualMultaTexto = "";
		if (this.percentualMulta != null && this.percentualMulta != 0) {
			DecimalFormat df = new DecimalFormat("##000000");
			percentualMultaTexto = df.format(this.percentualMulta);
		} else {
			percentualMultaTexto = "000000";
		}
		percentualMultaTexto = Formatacao.colocaVirgula(percentualMultaTexto,
				',', 5);
		return percentualMultaTexto;
	}

	public java.lang.String getPercentualDescontoFormatado() {
		String percentualDescontoTexto = "";
		if (this.percentualDesconto != null && this.percentualDesconto != 0) {
			DecimalFormat df = new DecimalFormat("##000000");
			percentualDescontoTexto = df.format(this.percentualDesconto);
		} else {
			percentualDescontoTexto = "000000";
		}
		percentualDescontoTexto = Formatacao.colocaVirgula(
				percentualDescontoTexto, ',', 5);
		return percentualDescontoTexto;
	}

	// -------------------------------- CEP

	public String getCepCedenteFormatado() {
		return Formatador.formatarCep(this.cepCedente == null ? ""
				: this.cepCedente.toString());
	}

	public String getCepSacadoFormatado() {
		return Formatador.formatarCep(this.cepSacado == null ? ""
				: this.cepSacado.toString());
	}

	// -------------------------------- Nosso Numero

	public String getNossoNumeroFormatado() {
		if (this.tipoBloquetoDda != null && this.nossoNumero != null) {
			if (this.tipoBloquetoDda.equals(2L)
					|| this.tipoBloquetoDda.equals(4L)) {
				if (this.nossoNumero.trim().length() == 11) {
					return this.nossoNumero.substring(0, 10)
							+ " - "
							+ this.nossoNumero.substring(10, this.nossoNumero
									.length());
				} else if (this.nossoNumero.trim().length() >= 16) {
					return this.nossoNumero.substring(0, 15)
							+ " - "
							+ this.nossoNumero.substring(15, this.nossoNumero
									.length());
				}
			} else if (this.tipoBloquetoDda.equals(3L)
					|| this.tipoBloquetoDda.equals(5L)) {
				if (this.nossoNumero.trim().length() >= 18) {
					return this.nossoNumero.substring(0, 17)
							+ " - "
							+ this.nossoNumero.substring(17, this.nossoNumero
									.length());
				}
			}
		}
		return this.nossoNumero;
	}

	// -------------------------------- Codigo Cedente

	public String getCodigoCedenteFormatado() {
		if (this.tipoBloquetoDda != null && this.codigoCedente != null) {
			if (this.tipoBloquetoDda.equals(2L)
					|| this.tipoBloquetoDda.equals(4L)) {
				if (this.codigoCedente.trim().length() >= 16) {
					return this.codigoCedente.trim().substring(0, 4)
					+ "."
					+ this.codigoCedente.trim().substring(4, 7)
					+ "."
					+ this.codigoCedente.trim().substring(7, 15)
					+ " - "
					+ this.codigoCedente.trim().substring(15, this.codigoCedente
							.trim().length());
				}
			} else if (this.tipoBloquetoDda.equals(3L)
					|| this.tipoBloquetoDda.equals(5L)) {
				if (this.codigoCedente.trim().length() >= 7) {
					return this.codigoCedente.trim().substring(0, 4)
					+ "."
					+ this.codigoCedente.trim().substring(4, this.codigoCedente.trim().length());
				}
			}
		}
		return this.codigoCedente;
	}

	// --------------------------------

	public int hashCode() {
		int result = 0;
		return result;
	}

	private static final Layout layout = initLayout();

	private static Layout initLayout() {
		java.util.TreeSet properties = new java.util.TreeSet();
		properties.add(new Property("tipoPessoaSacado", StringType.create(),
				false, true));
		properties.add(new Property("cpfCnpjSacado", LongType.create(), false,
				true));
		properties.add(new Property("tipoDataFiltro", LongType.create(), false,
				true));
		properties.add(new Property("tipoDataFiltroForm", LongType.create(),
				false, true));
		properties.add(new Property("mesAnoFiltro", StringType.create(), false,
				true));
		properties.add(new Property("dataFiltro", DateType.create(), false,
				true));
		properties.add(new Property("tipoConsulta", LongType.create(), false,
				true));
		properties.add(new Property("tipoConsultaForm", LongType.create(),
				false, true));
		properties.add(new Property("quantidadePorCpfCnpj", LongType.create(),
				false, true));
		properties.add(new Property("valorPorCpfCnpj", MoneyType.create(),
				false, true));
		properties.add(new Property("dataMovimento", DateType.create(), false,
				true));
		properties.add(new Property("numeroControleRequisicao", StringType
				.create(), false, true));
		properties.add(new Property("numeroIdentificacaoDda",
				LongType.create(), false, true));
		properties.add(new Property("dataVencimento", DateType.create(), false,
				true));
		properties.add(new Property("dataPagamento", DateType.create(), false,
				true));
		properties.add(new Property("valorTitulo", MoneyType.create(), false,
				true));
		properties.add(new Property("quantidadeAceite", LongType.create(),
				false, true));
		properties.add(new Property("valorAceite", MoneyType.create(), false,
				true));
		properties.add(new Property("quantidadeNaoAceite", LongType.create(),
				false, true));
		properties.add(new Property("valorNaoAceite", MoneyType.create(),
				false, true));
		properties
				.add(new Property("aceite", StringType.create(), false, true));
		properties.add(new Property("tipoBloquetoDda", LongType.create(),
				false, true));
		properties.add(new Property("codigoBancoCedente", LongType.create(),
				false, true));
		properties.add(new Property("nomeBancoCedente", StringType.create(),
				false, true));
		properties.add(new Property("agenciaCedente", LongType.create(), false,
				true));
		properties.add(new Property("tipoPessoaCedente", StringType.create(),
				false, true));
		properties.add(new Property("cpfCnpjCedente", LongType.create(), false,
				true));
		properties.add(new Property("codigoCedente", StringType.create(),
				false, true));
		properties.add(new Property("nomeCedente", StringType.create(), false,
				true));
		properties.add(new Property("enderecoCedente", StringType.create(),
				false, true));
		properties.add(new Property("municipioCedente", StringType.create(),
				false, true));
		properties.add(new Property("ufCedente", StringType.create(), false,
				true));
		properties.add(new Property("cepCedente", LongType.create(), false,
				true));
		properties.add(new Property("nomeSacado", StringType.create(), false,
				true));
		properties.add(new Property("enderecoSacado", StringType.create(),
				false, true));
		properties.add(new Property("municipioSacado", StringType.create(),
				false, true));
		properties.add(new Property("ufSacado", StringType.create(), false,
				true));
		properties
				.add(new Property("cepSacado", LongType.create(), false, true));
		properties.add(new Property("tipoPessoaSacador", StringType.create(),
				false, true));
		properties.add(new Property("cpfCnpjSacador", LongType.create(), false,
				true));
		properties.add(new Property("nomeSacador", StringType.create(), false,
				true));
		properties.add(new Property("tipoPessoaTerceiro", StringType.create(),
				false, true));
		properties.add(new Property("cpfCnpjTerceiro", LongType.create(),
				false, true));
		properties.add(new Property("dataDocumento", DateType.create(), false,
				true));
		properties.add(new Property("dataProcessamento", DateType.create(),
				false, true));
		properties.add(new Property("nossoNumero", StringType.create(), false,
				true));
		properties.add(new Property("numeroDocumento", StringType.create(),
				false, true));
		properties.add(new Property("codigoTipoEspecie", StringType.create(),
				false, true));
		properties.add(new Property("descricaoTipoEspecie",
				StringType.create(), false, true));
		properties.add(new Property("codigoTipoCarteira", StringType.create(),
				false, true));
		properties.add(new Property("descricaoTipoCarteira", StringType
				.create(), false, true));
		properties.add(new Property("descricaoTipoAceite", StringType.create(),
				false, true));
		properties.add(new Property("valorAbatimento", MoneyType.create(),
				false, true));
		properties
				.add(new Property("dataJuros", DateType.create(), false, true));
		properties
				.add(new Property("tipoJuros", LongType.create(), false, true));
		properties.add(new Property("valorJuros", MoneyType.create(), false,
				true));
		properties.add(new Property("percentualJuros", LongType.create(),
				false, true));
		properties
				.add(new Property("dataMulta", DateType.create(), false, true));
		properties.add(new Property("valorMulta", MoneyType.create(), false,
				true));
		properties.add(new Property("percentualMulta", LongType.create(),
				false, true));
		properties.add(new Property("descricaoGrupoDesconto", StringType
				.create(), false, true));
		properties.add(new Property("dataDesconto", DateType.create(), false,
				true));
		properties.add(new Property("tipoDesconto", StringType.create(), false,
				true));
		properties.add(new Property("valorDesconto", MoneyType.create(), false,
				true));
		properties.add(new Property("percentualDesconto", LongType.create(),
				false, true));
		properties.add(new Property("codigoMoeda", StringType.create(), false,
				true));
		properties.add(new Property("nomeMoeda", StringType.create(), false,
				true));
		properties.add(new Property("descricaoMoeda", StringType.create(),
				false, true));
		properties.add(new Property("indicadorTituloNegociado", StringType
				.create(), false, true));
		properties.add(new Property("indicadorInformacaoAdicional", StringType
				.create(), false, true));
		properties.add(new Property("codigoBarrasFormatado", StringType
				.create(), false, true));
		properties.add(new Property("codigoBarrasNumerico",
				StringType.create(), false, true));

		Layout result = new Layout(properties, "DdaGeraisFiltroBean",
				"br.gov.caixa.sigcb.bean");
		MainframeExtension Mainframe = new MainframeExtension();
		Mainframe.put("tipoPessoaSacado", new StringValue("X(01)"));
		Mainframe.put("cpfCnpjSacado", new LongValue("9(14)"));
		Mainframe.put("tipoDataFiltro", new LongValue("9(01)"));
		Mainframe.put("tipoDataFiltroForm", new LongValue("9(01)"));
		Mainframe.put("mesAnoFiltro", new StringValue("X(07)"));
		Mainframe.put("dataFiltro", new DateValue("dd.MM.yyyy"));
		Mainframe.put("tipoConsulta", new LongValue("9(02)"));
		Mainframe.put("tipoConsultaForm", new LongValue("9(02)"));
		Mainframe.put("quantidadePorCpfCnpj", new LongValue("9(11)"));
		Mainframe.put("valorPorCpfCnpj", new MoneyValue("R$ 9(13)v99"));
		Mainframe.put("dataMovimento", new DateValue("dd.MM.yyyy"));
		Mainframe.put("numeroControleRequisicao", new StringValue("X(20)"));
		Mainframe.put("numeroIdentificacaoDda", new LongValue("9(17)"));
		Mainframe.put("dataVencimento", new DateValue("dd.MM.yyyy"));
		Mainframe.put("dataPagamento", new DateValue("dd.MM.yyyy"));
		Mainframe.put("valorTitulo", new MoneyValue("R$ 9(15)v99"));
		Mainframe.put("quantidadeAceite", new LongValue("9(11)"));
		Mainframe.put("valorAceite", new MoneyValue("R$ 9(13)v99"));
		Mainframe.put("quantidadeNaoAceite", new LongValue("9(11)"));
		Mainframe.put("valorNaoAceite", new MoneyValue("R$ 9(13)v99"));
		Mainframe.put("aceite", new StringValue("X(01)"));
		Mainframe.put("tipoBloquetoDda", new LongValue("9(01)"));
		Mainframe.put("codigoBancoCedente", new LongValue("9(03)"));
		Mainframe.put("nomeBancoCedente", new StringValue("X(40)"));
		Mainframe.put("agenciaCedente", new LongValue("9(04)"));
		Mainframe.put("tipoPessoaCedente", new StringValue("X(01)"));
		Mainframe.put("cpfCnpjCedente", new LongValue("9(14)"));
		Mainframe.put("codigoCedente", new StringValue("X(20)"));
		Mainframe.put("nomeCedente", new StringValue("X(40)"));
		Mainframe.put("enderecoCedente", new StringValue("X(80)"));
		Mainframe.put("municipioCedente", new StringValue("X(35)"));
		Mainframe.put("ufCedente", new StringValue("X(02)"));
		Mainframe.put("cepCedente", new LongValue("9(08)"));
		Mainframe.put("nomeSacado", new StringValue("X(40)"));
		Mainframe.put("enderecoSacado", new StringValue("X(80)"));
		Mainframe.put("municipioSacado", new StringValue("X(35)"));
		Mainframe.put("ufSacado", new StringValue("X(02)"));
		Mainframe.put("cepSacado", new LongValue("9(08)"));
		Mainframe.put("tipoPessoaSacador", new StringValue("X(01)"));
		Mainframe.put("cpfCnpjSacador", new LongValue("9(14)"));
		Mainframe.put("nomeSacador", new StringValue("X(40)"));
		Mainframe.put("tipoPessoaTerceiro", new StringValue("X(01)"));
		Mainframe.put("cpfCnpjTerceiro", new LongValue("9(14)"));
		Mainframe.put("dataDocumento", new DateValue("dd.MM.yyyy"));
		Mainframe.put("dataProcessamento", new DateValue("dd.MM.yyyy"));
		Mainframe.put("nossoNumero", new StringValue("X(20)"));
		Mainframe.put("numeroDocumento", new StringValue("X(15)"));
		Mainframe.put("codigoTipoEspecie", new StringValue("X(04)"));
		Mainframe.put("descricaoTipoEspecie", new StringValue("X(40)"));
		Mainframe.put("codigoTipoCarteira", new StringValue("X(2)"));
		Mainframe.put("descricaoTipoCarteira", new StringValue("X(40)"));
		Mainframe.put("descricaoTipoAceite", new StringValue("X(1)"));
		Mainframe.put("valorAbatimento", new MoneyValue("R$ 9(13)v99"));
		Mainframe.put("dataJuros", new DateValue("dd.MM.yyyy"));
		Mainframe.put("tipoJuros", new LongValue("9(01)"));
		Mainframe.put("valorJuros", new MoneyValue("R$ 9(13)v99"));
		Mainframe.put("percentualJuros", new LongValue("9(08)"));
		Mainframe.put("dataMulta", new DateValue("dd.MM.yyyy"));
		Mainframe.put("valorMulta", new MoneyValue("R$ 9(13)v99"));
		Mainframe.put("percentualMulta", new LongValue("9(08)"));
		Mainframe.put("descricaoGrupoDesconto", new StringValue("X(100)"));
		Mainframe.put("dataDesconto", new DateValue("dd.MM.yyyy"));
		Mainframe.put("tipoDesconto", new StringValue("X(02)"));
		Mainframe.put("valorDesconto", new MoneyValue("R$ 9(13)v99"));
		Mainframe.put("percentualDesconto", new LongValue("9(08)"));
		Mainframe.put("codigoMoeda", new StringValue("X(02)"));
		Mainframe.put("nomeMoeda", new StringValue("X(06)"));
		Mainframe.put("descricaoMoeda", new StringValue("X(15)"));
		Mainframe.put("indicadorTituloNegociado", new StringValue("X(01)"));
		Mainframe.put("indicadorInformacaoAdicional", new StringValue("X(01)"));
		Mainframe.put("codigoBarrasFormatado", new StringValue("X(54)"));
		Mainframe.put("codigoBarrasNumerico", new StringValue("X(44)"));
		result.addExtension(Mainframe);
		return result;
	}

	public Layout getLayout() {
		return layout;
	}

}
