
<%
	 /***********************************************
	 *Politec - Filial São Paulo
	 *Fabrica de Projetos - Agosto de 2004
	 *Projeto CAIXA - SIGCB
	 *Componente: bcotitu_acao.jsp - Java Server Pages
	 *Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
	 *Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
	 *Ultima Atualização: 15/09/2004
	 ************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BcoTituEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.util.LogUtilSigcb"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.ContaCreditoBean"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
			InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session
			.getAttribute(BcoTituEstrategia.USUARIOLDAP_BEAN);
	CedenteCabecaBean cedCabBean = (session
			.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN) == null ? new CedenteCabecaBean()
			: (CedenteCabecaBean) session
			.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN));
	TituloBean tituloBean = (session
			.getAttribute(BcoTituEstrategia.DATA_BEAN) == null ? new TituloBean()
			: (TituloBean) session
			.getAttribute(BcoTituEstrategia.DATA_BEAN));

	SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
	String dataHoje = formato.format(Calendar.getInstance().getTime());
	String dataPrevisaoProtDev = formato.format(tituloBean.getAbatiDataPrevisaoProtDev());
	String dataDevolucao = formato.format(tituloBean
			.getPrinciDataVencimento());

	CedenteGeralBean cedGeralBean = (session
			.getAttribute(BcoTituEstrategia.CEDENTE_GERAL_BEAN) == null ? new CedenteGeralBean()
			: (CedenteGeralBean) session
			.getAttribute(BcoTituEstrategia.CEDENTE_GERAL_BEAN));
	
	String icRateio = tituloBean.getIcRateio();
%>

<%
	ArrayList listaTitulos = (ArrayList) session.getAttribute("listaContaCredito");
%>

<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=BcoTituEstrategia.STRATEGY_ACAO%>" fluxo="normal">
		<s:Menu />
		<s:Titulo name="<%=BcoTituEstrategia.PAGE_TITLE_ACAO%>" />

		<input type="hidden" name="filtroSelecao"
			value="<%=tituloBean.getFiltroSelecao()%>">
		<input type="hidden" name="filtroDescricaoSituacao"
			value="<%=tituloBean.getFiltroDescricaoSituacao()%>">
		<input type="hidden" name="filtroDescricaoClassificacao"
			value="<%=tituloBean.getFiltroDescricaoClassificacao()%>">
		<input type="hidden" name="filtroVoltarListarConsolidado"
			value="<%=tituloBean.getFiltroVoltarListarConsolidado()%>">
		<input type="hidden" name="filtroVoltarListarTitulo"
			value="<%=tituloBean.getFiltroVoltarListarTitulo()%>">
		<input type="hidden" name="filtroVoltarAcao" value="1">

		<input type="hidden" name="codigoCedente"
			value="<%=tituloBean.getCodigoCedente()%>">
		<input type="hidden" name="nossoNumero"
			value="<%=tituloBean.getNossoNumero()%>">
		<input type="hidden" name="situacao"
			value="<%=tituloBean.getSituacao()%>">
		<input type="hidden" name="classificacao"
			value="<%=tituloBean.getClassificacao()%>">

		<input type="hidden" name="princiValorTitulo"
			value="<%=tituloBean.getPrinciValorTitulo()%>">
		<input type="hidden" name="princiMeioEntrada"
			value="<%=tituloBean.getPrinciMeioEntrada()%>">
		<input type="hidden" name="princiDescricaoSituacao"
			value="<%=tituloBean.getPrinciDescricaoSituacao()%>">
		<input type="hidden" name="acoesHistorico"
			value="<%=tituloBean.getAcoesHistorico()%>">
		<input type="hidden" name="acoesServicoTitulo"
			value="<%=tituloBean.getAcoesServicoTitulo()%>">

		<input type="hidden" name="abatiCustasCartorarias"
			value="<%=tituloBean.getAbatiCustasCartorarias()%>">

		<input type="hidden" name="nomeGrupo"
			value="<%=usuarioBean.getNomeGrupo()%>">

		<input type="hidden" name="situacaoBloqSE"
			value="<%=tituloBean.getSituacaoBloqSE()%>">

		<input type="hidden" name="numIdDDA"
			value="<%=tituloBean.getNumIdDDA() %>">

		<input type="hidden" name="aceiteSE"
			value="<%=tituloBean.getAceiteSE() %>">

		<input type="hidden" name="nuIdentificacao" value="<%=tituloBean.getNuIdentificaCIP().toString() %>">
		<input type="hidden" name="paginaOrigem" value="TITULO">
		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height=53 valign="middle" align="center">
					<tr>
						<td class="textoTitulo" width="17%">Cedente:</td>
						<td class="textoValor" width="26%"><%=tituloBean.getCodigoCedenteFormatado()%></td>
						<td class="textoTitulo" width="17%">Nome Cedente:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Tipo de Pessoa:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
						<td class="textoTitulo" width="17%">CPF/CNPJ:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Código Cliente (COCLI):</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td>
						<td class="textoTitulo" width="17%">Nosso Número:</td>
						<td class="textoValor" width="26%"><%=tituloBean.getNossoNumeroFormatado()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Meio de Entrada:</td>
						<td class="textoValor" width="26%"><%=tituloBean.getPrinciMeioEntrada()%></td>
						<td class="textoTitulo" width="17%">Valor:</td>
						<td class="textoValor" width="26%"><%=tituloBean.getPrinciValorTitulo()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Situação:</td>
						<td class="textoValor" width="26%"><%=tituloBean.getPrinciDescricaoSituacao()%></td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
					</tr>

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="4" class="textoTitulo">Título:
						<hr>
						</td>
					</tr>

					<tr>
						<td colspan="4"><s:Outline name="Principais"
							title="Dados Principais" imagePath="<%=Paths.getImagePath()%>"
							type="outline">
							<table width="95%" border="0" cellspacing="0" cellpadding="0"
								height=14 valign="middle" align="center">
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Número Documento:</td>
									<td class="textoValor" width="26%" nowrap><%=tituloBean.getPrinciNumeroDocumento()%></td>
									<td class="textoTitulo" width="17%">Data de Vencimento:</td>
									<td class="textoValor" width="26%" nowrap><%=tituloBean.getPrinciDataVencimentoFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getPrinciDataVencimentoFormatada()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Moeda:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciMoedaTexto()%></td>
									<td class="textoTitulo" width="17%">Aceite:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciDescricaoAceite()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Protesto:</td>
									<td class="textoValor" width="26%"><%=tituloBean
												.getPrinciIndicadorProtTexto()%></td>
									<td class="textoTitulo" width="17%" nowrap>Prazo de
									Protesto/Devolução:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciPrazoProtDev()%></td>
								</tr>

								<tr>
									<td class="textoTitulo" width="17%">Endosso:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciEndossoTexto()%></td>
									<td class="textoTitulo" width="17%">Espécie de Título:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciDescricaoEspecie()%></td>
								</tr>


								<tr>
									<td class="textoTitulo" width="17%">Emissão Boleto:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getEmissaoBloquetoTexto()%></td>
									<td class="textoTitulo" width="17%">Envio Boleto:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getDescrEntrega()%></td>
								</tr>


								<tr>
									<td class="textoTitulo" width="17%">Nome do Sacado:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoNome()%></td>
									<td class="textoTitulo" width="17%">Tipo Pessoa Sacado:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoTipoPessoaTexto()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">CPF/CNPJ Sacado:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoCpfCnpjFormatado()%></td>
									<td class="textoTitulo" width="17%">CEP do Sacado:</td>
									<td class="textoValor" width="26%"><%=tituloBean
												.getPrinciSacadoCepFormatado()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">UF do Sacado:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoUf()%></td>
									<td class="textoTitulo" width="17%">Endereço do Sacado:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoLogradouro()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Numero do Sacado:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoNumero()%></td>
									<td class="textoTitulo" width="17%">Complemento do Sacado:
									</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoComplemento()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Bairro do Sacado:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoBairro()%></td>
									<td class="textoTitulo" width="17%">Município do Sacado:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoMunicipio()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">e-mail do Sacado:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoEmail()%></td>
									<td class="textoTitulo" width="17%">PV Cobrador:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getPrinciPvCobradorFormatado()%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">DDD/Celular:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getDddSMS()%>-<%=tituloBean.getCelularSMS()%></td>
									<td class="textoTitulo" width="17%">Tipo de SMS:</td>
									
									<td class="textoValor" width="26%"><%=tituloBean.getTipoSMS().equals("00") ? "" : ""%>
									<%=tituloBean.getTipoSMS().equals("01") ? "Informativa" : ""%>
									<%=tituloBean.getTipoSMS().equals("02") ? "Repr. Numerica" : ""%>
									<%=tituloBean.getTipoSMS().equals("03") ? "PEC" : ""%>
									</td>
								</tr>
								
								
								<tr>
									<td class="textoTitulo" width="17%">ST. Bloq. SE:</td>
									<td class="textoValor" width="26%" colspan="3"><%=tituloBean.getSituacaoBloqSE()%></td>
								</tr>
								<!-- 
								<tr>
									<td class="textoTitulo" width="17%">Aceite SE:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getAceiteSE()%></td>
									<td class="textoTitulo" width="17%">Número ID:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getNumIdDDA()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Alegação:</td>
									<td class="textoValor" colspan="3"><%=tituloBean.getAlegacaoSE().toString()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Tipo Calculo:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getTipoCalculo()%></td>
									<td class="textoTitulo" width="17%">Autorização:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getAutorizacao()%></td>
								</tr>


								<tr>
									<td class="textoTitulo" width="17%">Parcela:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getParcela()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Garantia de Crédito:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getIcGarantia()%></td>
									<td class="textoTitulo" width="17%">Data Marcação/Desmarcação como Garantia de Crédito:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getDtGarantia()%>&nbsp;&nbsp;<%=tituloBean.getCoUsuario()%></td>
								</tr>
								 -->
								 
								 
								<tr>
									<td class="textoTitulo" width="17%">Aceite SE:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getAceiteSE()%></td>
									<td class="textoTitulo" width="17%">Indicador Registro na CIP:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getIcRegistroCIP().equals("N") ? "NÃO" : "SIM"%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Indexador:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getSgIndexador()%></td>
									<td class="textoTitulo" width="17%">Número Identificação CIP:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getNuIdentificaCIP()%></td>
								</tr>
								
							
								
								<tr>
									<td class="textoTitulo" width="17%">Tipo Calculo:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getTipoCalculo()%></td>
									<td class="textoTitulo" width="17%">Número Referência CIP:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getNuRefereciaCIP()%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Parcela:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getParcela()%></td>
									<td class="textoTitulo" width="17%">Código Erro CIP:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getCoErroCIP()%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Autoriza Pagamento Parcial/Divergente:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getIcAutPagto().equals("N") ? "NÃO" : "SIM"%></td>
								
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Tipo de Pagamento:</td>
									<td class="textoValor" width="26%">
									<%=tituloBean.getIcTipoPagamento().equals("1") ? "1-Aceita qualquer valor " : ""%>
									<%=tituloBean.getIcTipoPagamento().equals("2") ? "2-Aceita valores entre range mínimo e máximo " : ""%>
									<%=tituloBean.getIcTipoPagamento().equals("3") ? "3-Não aceita valor divergente" : ""%>
									<%=tituloBean.getIcTipoPagamento().equals("4") ? "4-Aceita valores considerando apenas o valor mínimo " : ""%>
									
									</td>
								</tr>
								
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">&nbsp;</td>
									<td class="textoValor" width="26%">&nbsp;</td>
									<td class="textoTitulo" width="17%">Qtde. Pagamentos Possíveis:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getQtPgtoPossivel()%></td>
								</tr>
								
								<tr>
									<%if (tituloBean.getVrMaximoPgto().toString().equals("R$ 0,00")){ %>
									<td class="textoTitulo" width="17%">Valor Máximo de Pagamento:</td>
									<td class="textoValor" width="26%">&nbsp;-&nbsp;</td>
									<%}else { %>
									<td class="textoTitulo" width="17%">Valor Máximo de Pagamento:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getVrMaximoPgto()%></td>
									<%} %>
									<td class="textoTitulo" width="17%">Qtde. Pagamentos Efetuados:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getQtPgtoEfetuado()%></td>
								</tr>
								
								<tr>
									<%if (tituloBean.getVrMinPgto().toString().equals("R$ 0,00")){ %>
									<td class="textoTitulo" width="17%">Valor Mínimo de Pagamento:</td>
									<td class="textoValor" width="26%">&nbsp;-&nbsp;</td>
									<%}else{ %>
									<td class="textoTitulo" width="17%">Valor Mínimo de Pagamento:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getVrMinPgto()%></td>
									<%} %>
									<td class="textoTitulo" width="17%">Saldo do Título:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getVrSaldoTitulo()%></td>
								</tr>								

								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Garantia de Crédito: </td>
									<td class="textoValor" width="26%"><%=tituloBean.getIcGarantia()%></td>
									<td class="textoTitulo" width="17%">Data Marcação/Desmarcação como Garantia de Crédito:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getDtGarantia()%>&nbsp;&nbsp;<%=tituloBean.getCoUsuario()%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Data de Competência: </td>
									<td class="textoValor" width="26%"><%=tituloBean.getDtCompetencia()%></td>
									<%if (!tituloBean.getCpfCnpjPrt().equalsIgnoreCase("")){ %>
									<td class="textoTitulo" width="17%">CPF/CNPJ do Portador: </td>
									<td class="textoValor" width="26%"><%=tituloBean.getCpfCnpjFormatadoPrt()%></td>
									<%} %>
								</tr>
								<%if (tituloBean.getSnBaixa().equalsIgnoreCase("S")){ %>
								<tr>
									<td class="textoTitulo" width="17%">&nbsp;</td>
									<td class="textoValor" width="26%">&nbsp;</td>
									<td class="textoTitulo" width="17%">&nbsp;</td>
									<td class="textoValor" width="26%"><a href="javascript:listarBaixa()" alt="Clique aqui para consultar a lista de Baixa Efetiva">Listar Baixa Efetiva</a></td>
								</tr>
								<%} %>
									
									
								
																								 							
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
							</table>
						</s:Outline></td>
					</tr>

					<tr>
						<td colspan="4"><s:Outline name="Abatimento"
							title="Dados Encargos e Abatimentos"
							imagePath="<%=Paths.getImagePath()%>" type="outline">
							<table width="95%" border="0" cellspacing="0" cellpadding="0"
								height=14 valign="middle" align="center">
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="4" class="textoDestaqueTitulo">Datas e
									Valores</td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td class="textoTitulo" width="23%">Data de Emissão:</td>
									<td class="textoValor" width="20%"><%=tituloBean.getAbatiDataEmissaoFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getAbatiDataEmissaoFormatada()%></td>
									<td class="textoTitulo" width="20%">Data de Entrada:</td>
									<td class="textoValor" width="23%"><%=tituloBean.getAbatiDataEntradaFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getAbatiDataEntradaFormatada()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="23%">Previsão
									Protesto/Devolução:</td>
									<td class="textoValor" width="20%"><%=tituloBean
										.getAbatiDataPrevisaoProtDevFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getAbatiDataPrevisaoProtDevFormatada()%></td>
									<td class="textoTitulo" width="20%">Modalidade
									Título(Carteira):</td>
									<td class="textoValor" width="23%"><%=tituloBean.getAbatiModalidadeFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getAbatiModalidadeFormatada()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="23%">Abatimento:</td>
									<td class="textoValor" width="20%"><%=tituloBean.getAbatiAbatimento().toString()
										.equals("R$ 0,00") ? "" : tituloBean
								.getAbatiAbatimento().toString()%></td>
									<td class="textoTitulo" width="20%">Custas Cartorárias:</td>
									<td class="textoValor" width="23%"><%=tituloBean.getAbatiCustasCartorarias()
										.toString().equals("R$ 0,00") ? ""
								: tituloBean.getAbatiCustasCartorarias()
										.toString()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="23%">IOF a ser Retido:</td>
									<td class="textoValor" width="20%"><%=tituloBean.getAbatiRetidoValorIOF() %>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">IOF por dia de atraso:</td>
									<td class="textoValor" width="26%"><%= tituloBean.getIofAtrasoFormatado()%></td>								
									
									<td class="textoTitulo" width="17%">Juros por dia de atraso</td>
									<td class="textoValor" width="26%"><%=tituloBean.getJurosAtraso() %></td>
									 
								</tr>
								
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="4" class="textoDestaqueTitulo">Encargos e
									Abatimentos</td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="4">
									<table class="box" width="100%" border="0" cellspacing="3"
										cellpadding="0" height=14 valign="middle" align="center">
										<tr class="headerLista">
											<td align="left" class="textoDestaqueTitulo" width="20%">&nbsp;</td>
											<td align="left" class="textoDestaqueTitulo" width="20%">Prazo</td>
											<td align="center" class="textoDestaqueTitulo" width="20%">Data</td>
											<td align="right" class="textoDestaqueTitulo" width="20%">Percentual</td>
											<td align="right" class="textoDestaqueTitulo" width="20%">Valor</td>
										</tr>
										<tr class="line2">
											<td class="textoDestaqueTitulo" width="20%">Multa</td>
											<td class="textoValor" width="20%"><%=tituloBean.getAbatiMultaPrazo().equals(
										new Long(0)) ? "" : tituloBean
								.getAbatiMultaPrazo().toString()%></td>
											<td class="textoValor" align="center" width="20%"><%=tituloBean.getAbatiMultaDataFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getAbatiMultaDataFormatada()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiMultaPercen().toString()
										.equals("0,00 %") ? "" : tituloBean
								.getAbatiMultaPercen().toString()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiMultaValor().toString()
										.equals("R$ 0,00") ? "" : tituloBean
								.getAbatiMultaValor().toString()%></td>
										</tr>
										<tr>
											<td class="textoDestaqueTitulo" width="20%">Tipo de Juros:</td>
											<td class="textoValor" colspan="3">
											
												<%=tituloBean.getTipoJuros().equals("1") ?  "1-Valor (dias corridos) " : ""%>
												<%=tituloBean.getTipoJuros().equals("2") ?  "2-Percentual ao dia (dias corridos)" : ""%>
												<%=tituloBean.getTipoJuros().equals("3") ?  "3-Percentual ao mês (dias corridos)" : ""%>
												<%=tituloBean.getTipoJuros().equals("4") ?  "4-Percentual ao ano (dias corridos)" : ""%>
												<%=tituloBean.getTipoJuros().equals("5") ?  "5-Isento" : ""%>
												<%=tituloBean.getTipoJuros().equals("6") ?  "6-Valor (dia útil)" : ""%>
												<%=tituloBean.getTipoJuros().equals("7") ?  "7-Percentual ao dia (dias úteis)" : ""%>
												<%=tituloBean.getTipoJuros().equals("8") ?  "8-Percentual ao mês (dias úteis)" : ""%>
												<%=tituloBean.getTipoJuros().equals("9") ?  "9-Percentual ao ano (dias úteis) " : ""%>
											
												
											
											</td>
										</tr>
										<tr class="line0">
											<td class="textoDestaqueTitulo" width="20%">Juros</td>
											<td class="textoValor" width="20%">&nbsp;</td>
											<td class="textoValor" align="center" width="20%"><%=tituloBean.getAbatiJurosDataFormatada().equals("01/01/0001") ? "" : tituloBean.getAbatiJurosDataFormatada()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiJurosPercen().toString().equals("0,00 %") ? "" : tituloBean.getAbatiJurosPercen().toString()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiJurosValor().toString().equals("R$ 0,00") ? "" : tituloBean.getAbatiJurosValor().toString()%></td>
										</tr>
										<tr>
											<td class="textoDestaqueTitulo" width="20%">Tipo de Desconto:</td>
											<td class="textoValor" colspan="3">
											
												<%=tituloBean.getTipoDesconto().equals("0") ? "0-Isento" : ""%>
												<%=tituloBean.getTipoDesconto().equals("1") ? "1-Valor Fixo até a data informada" : ""%>
												<%=tituloBean.getTipoDesconto().equals("2") ? "2-Percentual até a data informada" : ""%>
												<%=tituloBean.getTipoDesconto().equals("3") ? "3-Valor por antecipação dia corrido" : ""%>
												<%=tituloBean.getTipoDesconto().equals("4") ? "4-Valor por antecipação dia útil" : ""%>
												<%=tituloBean.getTipoDesconto().equals("5") ? "5-Percentual por antecipação dia corrido" : ""%>
												<%=tituloBean.getTipoDesconto().equals("6") ? "6-Percentual por antecipação dia útil" : ""%>
											
											</td>
										</tr>
										<tr class="line2">
											<td class="textoDestaqueTitulo" width="20%">Desconto 1</td>
											<td class="textoValor" width="20%">
											<%
															if (!tituloBean.getAbatiDescontoUmPercen().toString()
															.equals("0,00 %")
															|| !tituloBean.getAbatiDescontoUmValor()
															.toString().equals("R$ 0,00")) {
											%> <%=tituloBean.getAbatiDescontoUmPrazo()
											.toString()%> <%
 }
 %>
											</td>
											<td class="textoValor" align="center" width="20%"><%=tituloBean.getAbatiDescontoUmDataFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getAbatiDescontoUmDataFormatada()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoUmPercen()
										.toString().equals("0,00 %") ? ""
								: tituloBean.getAbatiDescontoUmPercen()
										.toString()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoUmValor()
										.toString().equals("R$ 0,00") ? ""
								: tituloBean.getAbatiDescontoUmValor()
										.toString()%></td>
										</tr>
										<tr class="line2">
											<td class="textoDestaqueTitulo" width="20%">Desconto 2</td>
											<td class="textoValor" width="20%">
											<%
															if (!tituloBean.getAbatiDescontoDoisPercen().toString()
															.equals("0,00 %")
															|| !tituloBean.getAbatiDescontoDoisValor()
															.toString().equals("R$ 0,00")) {
											%> <%=tituloBean.getAbatiDescontoDoisPrazo()
											.toString()%> <%
 }
 %>
											</td>
											<td class="textoValor" align="center" width="20%"><%=tituloBean
										.getAbatiDescontoDoisDataFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getAbatiDescontoDoisDataFormatada()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoDoisPercen()
										.toString().equals("0,00 %") ? ""
								: tituloBean.getAbatiDescontoDoisPercen()
										.toString()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoDoisValor()
										.toString().equals("R$ 0,00") ? ""
								: tituloBean.getAbatiDescontoDoisValor()
										.toString()%></td>
										</tr>
										<tr class="line2">
											<td class="textoDestaqueTitulo" width="20%">Desconto 3</td>
											<td class="textoValor" width="20%">
											<%
															if (!tituloBean.getAbatiDescontoTresPercen().toString()
															.equals("0,00 %")
															|| !tituloBean.getAbatiDescontoTresValor()
															.toString().equals("R$ 0,00")) {
											%> <%=tituloBean.getAbatiDescontoTresPrazo()
											.toString()%> <%
 }
 %>
											</td>
											<td class="textoValor" align="center" width="20%"><%=tituloBean
										.getAbatiDescontoTresDataFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getAbatiDescontoTresDataFormatada()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoTresPercen()
										.toString().equals("0,00 %") ? ""
								: tituloBean.getAbatiDescontoTresPercen()
										.toString()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoTresValor()
										.toString().equals("R$ 0,00") ? ""
								: tituloBean.getAbatiDescontoTresValor()
										.toString()%></td>
										</tr>
									</table>
									</td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
							</table>
						</s:Outline></td>
					</tr>
					
					<%if (icRateio.equalsIgnoreCase("S")) { %>
					<tr>
							<td colspan="4">
							<s:Outline name="rateio" title="Dados Rateio" imagePath="<%=Paths.getImagePath()%>"	type="outline">
								<table width="95%" border="0" cellspacing="0" cellpadding="0"	height=14 valign="middle" align="center">
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
									
									<tr>
										<td colspan="4">
											<table>
											<tr>
												<td nowrap class="textoTitulo" width="10%" align="center">Banco</td>
												<td nowrap class="textoTitulo" width="10%" align="center">Conta</td>
												<td nowrap class="textoTitulo" width="10%" align="center">Perc. Previsto</td>
												<td nowrap class="textoTitulo" width="10%" align="center">Perc. Efetivo</td>
												<td nowrap class="textoTitulo" width="10%" align="center">Valor Previsto</td>
												<td nowrap class="textoTitulo" width="10%" align="center">Valor Efetivo</td>
												<td nowrap class="textoTitulo" width="10%" align="center">CPF/CNPJ</td>
												<td nowrap class="textoTitulo" width="30%" align="center">Titular</td>
											</tr>
											<%
											ContaCreditoBean occ = new ContaCreditoBean();
											for ( int i = 0; i < listaTitulos.size(); i++ ) {	
												occ = (ContaCreditoBean) listaTitulos.get(i);
											%>
										  	<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
										  	
										  		<td nowrap class="textoValor" width="10%" align="center"><%= occ.getBanco() %></td>
												<td nowrap class="textoValor" width="10%" align="center"><%= occ.getConta() %></td>
												<td nowrap class="textoValor" width="10%" align="right"><%= occ.getPercPrevisto() %></td>
												<td nowrap class="textoValor" width="10%" align="right"><%= occ.getPercEfetivo()%></td>
												<td nowrap class="textoValor" width="10%" align="right"><%= occ.getValorPrevisto() %></td>
												<td nowrap class="textoValor" width="10%" align="right"><%= occ.getValorEfetivo() %></td>
												<td nowrap class="textoValor" width="10%" align="right"><%= occ.getCpfCnpj() %></td>
												<td nowrap class="textoValor" width="30%" align="left"><%= occ.getTitular() %></td>
		 								    </tr>
		 								    <%} %>
	 								    	</table>
 								    	</td>
 								    </tr>
									
								</table>
							</s:Outline>
							</td>
					</tr>
					<%} %>

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>

					<tr valign="top">
						<td colspan="4" class="textoTitulo">Ações:
						<hr>
						</td>
					</tr>

					<tr>
						<td class="textoTitulo" width="17%">Data da Solicitação:</td>
						<td class="textoValor" width="26%"><%=Formatador.formatarData(Calendar.getInstance()
									.getTime())%></td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
					</tr>

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>

					<tr>
						<td colspan="4"><s:Outline name="Protestos" title="Protesto"
							imagePath="<%=Paths.getImagePath()%>" type="outline">
							<table width="95%" border="0" cellspacing="0" cellpadding="0"
								height=14 valign="middle" align="center">

								<tr>
									<td colspan="6">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="6" class="textoDestaqueTitulo">Ações:
									Protesto</td>
								</tr>
								<tr>
									<td colspan="6">&nbsp;</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoProtesto" value="1"
										onclick="javascript:preparaAcaoProtesto()" /></td>
									<td class="textoTitulo" width="30%">Envio ao Cartório</td>
									<td class="textoValor" width="15%">&nbsp;</td>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoProtesto" value="6"
										onclick="javascript:preparaAcaoProtesto()" /></td>
									<td class="textoTitulo" width="30%">Suspender Envio ao
									Cartório</td>
									<td class="textoValor" width="15%">&nbsp;</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoProtesto" value="2"
										onclick="javascript:preparaAcaoProtesto();" /></td>
									<td class="textoTitulo" width="30%">Sustação de Protesto</td>
									<td class="textoValor" width="15%">&nbsp;</td>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoProtesto" value="7"
										onclick="javascript:preparaAcaoProtesto();" /></td>
									<td class="textoTitulo" width="30%">Incluir Título na
									Remessa</td>
									<td class="textoValor" width="15%">&nbsp;</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoProtesto" value="3"
										onclick="javascript:preparaAcaoProtesto();" /></td>
									<td class="textoTitulo" width="30%">Estorno Envio/Sustação
									</td>
									<td class="textoValor" width="15%">&nbsp;</td>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoProtesto" value="8"
										onclick="javascript:preparaAcaoProtesto();" /></td>
									<td class="textoTitulo" width="30%">Baixa por Protesto</td>
									<td class="textoValor" width="15%">&nbsp;</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoProtesto" value="4"
										onclick="javascript:preparaAcaoProtesto();" /></td>
									<td class="textoTitulo" width="30%">Débito Custas
									Cartorárias - Pós Comando</td>
									<td class="textoValor" width="15%">&nbsp;</td>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoProtesto" value="9"
										onclick="javascript:preparaAcaoProtesto();" /></td>
									<td class="textoTitulo" width="30%">Liquidado em Cartório
									</td>
									<td class="textoValor" width="15%">&nbsp;</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoProtesto" value="5"
										onclick="javascript:preparaAcaoProtesto();" /></td>
									<td class="textoTitulo" width="30%">Impressão de 2a. via
									Ordem de Protesto</td>
									<td class="textoValor" width="15%">&nbsp;</td>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoProtesto" value="10"
										onclick="javascript:preparaAcaoProtesto();" /></td>
									<td class="textoTitulo" width="30%">Liquidado em Cartório
									Condicional</td>
									<td class="textoValor" width="15%">&nbsp;</td>
								</tr>

								<tr>
									<td colspan="6">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="6" class="textoDestaqueTitulo">Informações
									Adicionais</td>
								</tr>
								<tr>
									<td colspan="6">&nbsp;</td>
								</tr>

								<tr>
									<td colspan="6">
									<table width="100%" border="0" cellspacing="0" cellpadding="0"
										height=14 valign="middle" align="center">

										<tr>
											<td class="textoTitulo" width="17%">Valor Recebido:</td>
											<td class="textoValor" width="26%"><p:InputCurrency
												CLASS="inputtext" name="acoesValorRecebido"
												value="<%=tituloBean.getAcoesValorRecebido().toString()%>"
												size="25" maxlength="21" disabled="true"
												onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.acoesDespesasCartorarias);" />
											</td>
											<td class="textoTitulo" width="17%">Despesas
											Cartorárias:</td>
											<td class="textoValor" width="26%"><p:InputCurrency
												CLASS="inputtext" name="acoesDespesasCartorarias"
												value="<%=tituloBean.getAcoesDespesasCartorarias().toString()%>"
												size="28" maxlength="21" disabled="true"
												onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.editaHistorico);" />
											</td>
										</tr>

										<tr>
											<td class="textoTitulo" width="17%">Histórico:</td>
											<td class="textoValor" width="26%" colspan="3">
											<p align="justify"><textarea
												name="textAreaAcoesHistorico" cols="50" rows="2"
												class="textoValor" readonly><%=tituloBean.getAcoesHistoricoFormatada()%></textarea>
											<s:Button name="Editar"
												action="javascript: editaMensagem(document.frmMain.textAreaAcoesHistorico, 50, 14, 23, 2);"
												disabled="true" /></p>
											</td>
										</tr>

										<tr>
											<td colspan="4">&nbsp;</td>
										</tr>

									</table>
									</td>
								</tr>
								<tr>
									<td align="right" colspan="6">
									<p align="center"><s:Button name="AcoesProtesto_Ok"
										value="Ok" action="javascript:formSubmit_AcoesProtesto();"	/> 
										<s:Button name="Cancelar" action="javascript:collapseALL();" /></p>
									</td>
								</tr>

								<tr>
									<td colspan="6">&nbsp;</td>
								</tr>
							</table>
						</s:Outline></td>
					</tr>
					<!-- Os usuários do grupo GCBRET só poderão acessar a guia de Protesto 
						 para alterar e o restante para consulta.
					-->
					<%
					if (usuarioBean.getNomeGrupo().equals("GCBRET")) {
					%>
					<s:Outline name="Outros" title="Outros"
						imagePath="<%=Paths.getImagePath()%>" type="outline"
						disabled="true">
						<table width="95%" border="0" cellspacing="0" cellpadding="0"
							height=14 valign="middle" align="center">

							<tr>
								<td colspan="6">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="6" class="textoDestaqueTitulo">Ações: Outros</td>
							</tr>
							<tr>
								<td colspan="6">&nbsp;</td>
							</tr>

							<tr>
								<td class="textoTitulo" width="2%"><input type="radio"
									name="rdoOutros" value="11"
									onclick="javascript:preparaAcaoOutros();"></td>
								<td class="textoTitulo" width="30%">Baixa Manual -
								Devolução</td>
								<td class="textoValor" width="15%">&nbsp;</td>
								<td class="textoTitulo" width="2%"><input type="radio"
									name="rdoOutros" value="13"
									onclick="javascript:preparaAcaoOutros();"></td>
								<td class="textoTitulo" width="30%">Solicitação 2a. via
								Boleto</td>
								<td class="textoValor" width="15%">&nbsp;</td>
							</tr>

							<tr>
								<td class="textoTitulo" width="2%"><input type="radio"
									name="rdoOutros" value="12"
									onclick="javascript:preparaAcaoOutros();"></td>
								<td class="textoTitulo" width="30%">Baixa por Estorno</td>
								<td class="textoValor" width="15%">&nbsp;</td>
								<td class="textoTitulo" width="2%"><input type="radio"
									name="rdoOutros" value="14"
									onclick="javascript:preparaAcaoOutros();"></td>
								<td class="textoTitulo" width="30%">Reinclusão de Título</td>
								<td class="textoTitulo" width="15%">&nbsp;</td>
							</tr>

							<tr>
								<td class="textoTitulo" width="2%"><input type="radio"
									name="rdoOutros" value="20"
									onclick="javascript:preparaAcaoOutros();"></td>
								<td class="textoTitulo" width="30%">Reemissão e Postagem de	Boletos</td>
								<td class="textoValor" width="15%">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="6">&nbsp;</td>
							</tr>
							<tr>
								<td align="right" colspan="6">
								<p align="center"><s:Button name="AcoesOutros_Ok" value="Ok"
									action="javascript:formSubmit_AcoesOutros();"
									userGroup="<%=usuarioBean.getNomeGrupo()%>"
									internalAction="servico.bancotitulos.acoesoutros" /> <s:Button
									name="Cancelar" action="javascript:collapseALL();" /></p>
								</td>
							</tr>
							<tr>
								<td colspan="6">&nbsp;</td>
							</tr>

						</table>
					</s:Outline>
					<%
					} else {
					%>
					<tr>
						<td colspan="4"><s:Outline name="Outros" title="Outros"
							imagePath="<%=Paths.getImagePath()%>" type="outline">
							<table width="95%" border="0" cellspacing="0" cellpadding="0"
								height=14 valign="middle" align="center">

								<tr>
									<td colspan="6">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="6" class="textoDestaqueTitulo">Ações: Outros</td>
								</tr>
								<tr>
									<td colspan="6">&nbsp;</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoOutros" value="11"
										onclick="javascript:preparaAcaoOutros();"></td>
									<td class="textoTitulo" width="30%">Baixa Manual -
									Devolução</td>
									<td class="textoValor" width="15%">&nbsp;</td>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoOutros" value="13"
										onclick="javascript:preparaAcaoOutros();"></td>
									<td class="textoTitulo" width="30%">Solicitação 2a. via
									Boleto</td>
									<td class="textoValor" width="15%">&nbsp;</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoOutros" value="12"
										onclick="javascript:preparaAcaoOutros();"></td>
									<td class="textoTitulo" width="30%">Baixa por Estorno</td>
									<td class="textoValor" width="15%">&nbsp;</td>
									<td class="textoTitulo" width="2%"><input type="radio"
										name="rdoOutros" value="14"
										onclick="javascript:preparaAcaoOutros();"></td>
									<td class="textoTitulo" width="30%">Reinclusão de Título</td>
									<td class="textoTitulo" width="15%">&nbsp;</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="2%"><input type="radio"	name="rdoOutros" value="20" onclick="javascript:preparaAcaoOutros();"></td>
									<td class="textoTitulo" width="30%">Reemissão e Postagem	de Boletos</td>
									<td class="textoValor" width="15%">&nbsp;</td>
									<td class="textoValor" width="2%"><input type="radio"	name="rdoOutros" value="21" onclick="javascript:preparaAcaoOutros();"></td>
									<td class="textoTitulo" width="30%">Reenvio de SMS</td>
								</tr>
								<tr>
									<td colspan="6">&nbsp;</td>
								</tr>
								<tr>
									<td align="right" colspan="6">
									<p align="center"><s:Button name="AcoesOutros_Ok"
										value="Ok" action="javascript:formSubmit_AcoesOutros();"
										userGroup="<%=usuarioBean.getNomeGrupo()%>"
										internalAction="servico.bancotitulos.acoesoutros" /> <s:Button
										name="Cancelar" action="javascript:collapseALL();" /></p>
									</td>
								</tr>
								<tr>
									<td colspan="6">&nbsp;</td>
								</tr>

							</table>
						</s:Outline></td>
					</tr>
					<%
					}
					%>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td align="right" colspan="4">
						<p align="center"><s:Button name="Alterar"	action="javascript:formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancotitulos.alterar" /> 
						<s:Button name="Consultar" action="javascript:formSubmit_Consultar();" />	<s:Button name="Voltar" action="javascript:formSubmit_Voltar();" /></p>
						</td>
					</tr>
					
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>

				</table>
				</td>
			</tr>
		</table>
		<script language="javascript">
		function inicia() {
			inicializaCampos();
			setFirstFieldFocus();
		}
		
		function inicializaCampos() {
			/* solicitado para retirar - de acordo com a nova matriz de acesso 24/11/2010
			if (('<%=usuarioBean.getNomeGrupo()%>' == 'GCBOPE') &&
			 (<%=Integer.parseInt(usuarioBean.getCodigoUnidade())%>!=<%=cedGeralBean.getCodigoUnidadePVVinc()%>)){
			    document.frmMain.Alterar.disabled = true;
	     		desabilitaAcaoProtesto(01);	// Acao: Envio ao Cartório
	   			desabilitaAcaoProtesto(02);	// Acao: Sustação de Protesto
	   			desabilitaAcaoProtesto(03);	// Acao: Estorno Envio/Sustação 
	   			desabilitaAcaoProtesto(04);	// Acao: Débito Custas Cartorárias 
	   			desabilitaAcaoProtesto(05);	// Acao: Impressão de 2a. via Ordem de Protesto 
	    		desabilitaAcaoProtesto(06);	// Acao: Suspender Envio ao Cartório 
	    		desabilitaAcaoProtesto(07);	// Acao: Incluir Título na Remessa
	   			desabilitaAcaoProtesto(08);	// Acao: Baixa por Protesto 
	   			desabilitaAcaoProtesto(09);	// Acao: Liquidado em Cartório 
	   			desabilitaAcaoProtesto(10);	// Acao: Liquidado em Cartório Condicional 
	   			desabilitaAcaoOutros(11);	// Acao: Baixa Manual - Devolução
	   			desabilitaAcaoOutros(12);	// Acao: Baixa por Estorno
	   			desabilitaAcaoOutros(13);	// Acao: Solicitação 2a. via Bloqueto
	   			desabilitaAcaoOutros(14);	// Acao: Reinclusão de Título
	   			desabilitaAcaoOutros(20);	// Acao: Reemissão e Postagem de Bloquetos
			} else {
			*/
			    inicializaAcoesProtesto(<%=tituloBean.getPrinciSituacao()%>);
			    inicializaAcoesOutros(<%=tituloBean.getPrinciSituacao()%>);
			//}
			trataCampo_acoesValorRecebido(document.frmMain.acoesServicoTitulo.value);
			trataCampo_acoesDespesasCartorarias(document.frmMain.acoesServicoTitulo.value);
			trataCampo_acoesHistorico(document.frmMain.acoesServicoTitulo.value);
		}

		function inicializaAcoesProtesto(valorSituacao) {
			// Situacao: EM ABERTO
			if (valorSituacao == 1) {
     			<%=tituloBean.getPrinciIndicadorProt().equals("S")?"habilitaAcaoProtesto(01);":"desabilitaAcaoProtesto(01);"%>		// Acao: Envio ao Cartório
	   			desabilitaAcaoProtesto(02);		// Acao: Sustação de Protesto
	    		desabilitaAcaoProtesto(03);		// Acao: Estorno Envio/Sustação 
	    		desabilitaAcaoProtesto(04);		// Acao: Débito Custas Cartorárias 
	   			<%if (tituloBean.getPrinciIndicadorProt().equals("S")) { // Acao: Impressão de 2a. via Ordem de Protesto 
				//EAM0308 - Alterada esta condição pq a data de protesto está sendo enviada acrescida de 1 dia na BG66
				//if (Long.parseLong(dataPrevisaoProtDev) < Long.parseLong(dataHoje)) { //---> Data Envio Vencida?
					if (Long.parseLong(dataPrevisaoProtDev) <= Long.parseLong(dataHoje)) { //---> Data Envio Vencida?
							out.println("habilitaAcaoProtesto(05);");
	   				} else {
							out.println("desabilitaAcaoProtesto(05);");
	   				}
	   				} else {
							out.println("desabilitaAcaoProtesto(05);");
	   				}
	   			%>
		    		<%=tituloBean.getPrinciIndicadorProt().equals("S")?"habilitaAcaoProtesto(06);":"desabilitaAcaoProtesto(06);"%>		// Acao: Suspender Envio ao Cartório 
		    		<%=tituloBean.getPrinciIndicadorProt().equals("S")?"habilitaAcaoProtesto(07);":"desabilitaAcaoProtesto(07);"%>		// Acao: Incluir Título na Remessa
		   			desabilitaAcaoProtesto(08);		// Acao: Baixa por Protesto
		   			desabilitaAcaoProtesto(09);		// Acao: Liquidado em Cartório 
		   			desabilitaAcaoProtesto(10);		// Acao: Liquidado em Cartório Condicional 
	
					// Situacao: ENVIADO A CARTORIO
	     		} else if (valorSituacao == 7) {
		     		desabilitaAcaoProtesto(01);	// Acao: Envio ao Cartório
		   			habilitaAcaoProtesto(02);	// Acao: Sustação de Protesto
		   			habilitaAcaoProtesto(03);	// Acao: Estorno Envio/Sustação 
		   			habilitaAcaoProtesto(04);	// Acao: Débito Custas Cartorárias 
		   			habilitaAcaoProtesto(05);	// Acao: Impressão de 2a. via Ordem de Protesto 
		    		desabilitaAcaoProtesto(06);	// Acao: Suspender Envio ao Cartório 
					<%-- //SISOL 271327 Julho 2008 - Desabilita a opção de Incluir Título na Remessa p/ ENVIADO A CARTÓRIO --%>
		    		desabilitaAcaoProtesto(07);	// Acao: Incluir Título na Remessa
		   			habilitaAcaoProtesto(08);	// Acao: Baixa por Protesto 
		   			habilitaAcaoProtesto(09);	// Acao: Liquidado em Cartório 
		   			habilitaAcaoProtesto(10);	// Acao: Liquidado em Cartório Condicional 
	
					// SUSTADO CARTORIO
				} else if (valorSituacao == 8) {
		     		//EAM 22/04 - SISOT 35
		     		//desabilitaAcaoProtesto(01);	// Acao: Envio ao Cartório
		     		habilitaAcaoProtesto(01);	// Acao: Envio ao Cartório
	
		   			desabilitaAcaoProtesto(02);	// Acao: Sustação de Protesto
		   			habilitaAcaoProtesto(03);		// Acao: Estorno Envio/Sustação 
		   			habilitaAcaoProtesto(04);		// Acao: Débito Custas Cartorárias 
		   			habilitaAcaoProtesto(05);		// Acao: Impressão de 2a. via Ordem de Protesto 
		    		desabilitaAcaoProtesto(06);	// Acao: Suspender Envio ao Cartório 
	
		     		//EAM 22/04 - SISOT 35	    		
		    		//desabilitaAcaoProtesto(07);	// Acao: Incluir Título na Remessa
					  habilitaAcaoProtesto(07);	// Acao: Incluir Título na Remessa						   			
		   			desabilitaAcaoProtesto(08);	// Acao: Baixa por Protesto 
		   			desabilitaAcaoProtesto(09);	// Acao: Liquidado em Cartório 
		   			desabilitaAcaoProtesto(10);	// Acao: Liquidado em Cartório Condicional 

		   			//SOMENTE PARA PROTESTO
				} else if (valorSituacao==14){
					habilitaAcaoProtesto(01);	// Acao: Envio ao Cartório - OK
		   			desabilitaAcaoProtesto(02);	// Acao: Sustação de Protesto
		   			desabilitaAcaoProtesto(03);		// Acao: Estorno Envio/Sustação
		   			desabilitaAcaoProtesto(04);	// Acao: Débito Custas Cartorárias 
		   			habilitaAcaoProtesto(05);	// Acao: Impressão de 2a. via Ordem de Protesto  - OK
		   			habilitaAcaoProtesto(06);	// Acao: Suspender Envio ao Cartório  - OK
		   			habilitaAcaoProtesto(07);	// Acao: Incluir Título na Remessa - OK
		   			desabilitaAcaoProtesto(08);	// Acao: Baixa por Protesto 
		   			desabilitaAcaoProtesto(09);	// Acao: Liquidado em Cartório 
		   			desabilitaAcaoProtesto(10);	// Acao: Liquidado em Cartório Condici
		   			
			
				// TODAS AS OUTRAS SITUACOES
				
      		} else {
	     		desabilitaAcaoProtesto(01);	// Acao: Envio ao Cartório
	   			desabilitaAcaoProtesto(02);	// Acao: Sustação de Protesto
	   			desabilitaAcaoProtesto(03);	// Acao: Estorno Envio/Sustação 
	   			desabilitaAcaoProtesto(04);	// Acao: Débito Custas Cartorárias 
	   			desabilitaAcaoProtesto(05);	// Acao: Impressão de 2a. via Ordem de Protesto 
	    		desabilitaAcaoProtesto(06);	// Acao: Suspender Envio ao Cartório 
	    		desabilitaAcaoProtesto(07);	// Acao: Incluir Título na Remessa
	   			desabilitaAcaoProtesto(08);	// Acao: Baixa por Protesto 
	   			desabilitaAcaoProtesto(09);	// Acao: Liquidado em Cartório 
	   			desabilitaAcaoProtesto(10);	// Acao: Liquidado em Cartório Condicional 
			}
		}

		function inicializaAcoesOutros(valorSituacao) {     
			// Situacao: EM ABERTO
			if (valorSituacao == 1) { 
	 			habilitaAcaoOutros(11);		// Acao: Baixa Manual - Devolução
	 			habilitaAcaoOutros(12);		// Acao: Baixa por Estorno
	 			if ('<%= tituloBean.getNossoNumeroFormatado().substring(0,2)%>' == '15') {
	 				desabilitaAcaoOutros(13);		// Acao: Solicitação 2a. via Bloqueto
	 				desabilitaAcaoOutros(20);		// Acao: Reemissão e Postagem de Bloquetos
	 			}else{
		 			habilitaAcaoOutros(13);		// Acao: Solicitação 2a. via Bloqueto
		 			habilitaAcaoOutros(20);		// Acao: Reemissão e Postagem de Bloquetos
	 			}
	 			desabilitaAcaoOutros(14); 	// Acao: Reinclusão de Título
	   		
	   		// Situacao: LIQUIDADO PV
	   		} else if (valorSituacao == 2) {
	   			desabilitaAcaoOutros(11);	// Acao: Baixa Manual - Devolução
	   			desabilitaAcaoOutros(12);	// Acao: Baixa por Estorno
	   			desabilitaAcaoOutros(13);	// Acao: Solicitação 2a. via Bloqueto
	   			desabilitaAcaoOutros(20);	// Acao: Reemissão e Postagem de Bloquetos
	   			habilitaAcaoOutros(14);		// Acao: Reinclusão de Título

	   		// Situacao: LIQUIDADO CARTORIO
	   		} else if (valorSituacao == 3) {
	   			desabilitaAcaoOutros(11);	// Acao: Baixa Manual - Devolução
	   			desabilitaAcaoOutros(12);	// Acao: Baixa por Estorno
	   			desabilitaAcaoOutros(13);	// Acao: Solicitação 2a. via Bloqueto
	   			desabilitaAcaoOutros(20);	// Acao: Reemissão e Postagem de Bloquetos
	   			habilitaAcaoOutros(14);		// Acao: Reinclusão de Título

	   		// Situacao: BAIXA POR DEVOLUCAO
	   		} else if (valorSituacao == 5) {
	   			desabilitaAcaoOutros(11);	// Acao: Baixa Manual - Devolução
	   			desabilitaAcaoOutros(12);	// Acao: Baixa por Estorno
	   			desabilitaAcaoOutros(13);	// Acao: Solicitação 2a. via Bloqueto
	   			desabilitaAcaoOutros(20);	// Acao: Reemissão e Postagem de Bloquetos
	   			habilitaAcaoOutros(14);		// Acao: Reinclusão de Título

	   		// Situacao: BAIXA POR PROTESTO
	   		} else if (valorSituacao == 6) {
	   			desabilitaAcaoOutros(11);	// Acao: Baixa Manual - Devolução
	   			desabilitaAcaoOutros(12);	// Acao: Baixa por Estorno
	   			desabilitaAcaoOutros(13);	// Acao: Solicitação 2a. via Bloqueto
	   			desabilitaAcaoOutros(20);	// Acao: Reemissão e Postagem de Bloquetos
	   			habilitaAcaoOutros(14);		// Acao: Reinclusão de Título

	   		// Situacao: SUSTADO CARTORIO
	   		} else if (valorSituacao == 8) {
	   			habilitaAcaoOutros(11);		// Acao: Baixa Manual - Devolução
	   			desabilitaAcaoOutros(12);	// Acao: Baixa por Estorno
	   			desabilitaAcaoOutros(13);	// Acao: Solicitação 2a. via Bloqueto
	   			desabilitaAcaoOutros(14);	// Acao: Reinclusão de Título
	   			desabilitaAcaoOutros(20);	// Acao: Reemissão e Postagem de Bloquetos

		   		// Situacao: SOMENTE PARA PROTESTO
	   		} else if (valorSituacao == 14) {
	   			habilitaAcaoOutros(11);		// Acao: Baixa Manual - Devolução
	   			habilitaAcaoOutros(12);  	// Acao: Baixa por Estorno
	   			desabilitaAcaoOutros(13);	// Acao: Solicitação 2a. via Bloqueto
	   			desabilitaAcaoOutros(14);	// Acao: Reinclusão de Título
	   			desabilitaAcaoOutros(20);	// Acao: Reemissão e Postagem de Bloquetos	   			
				// TODAS AS OUTRAS SITUACOES
      		} else {
	   			desabilitaAcaoOutros(11);	// Acao: Baixa Manual - Devolução
	   			desabilitaAcaoOutros(12);	// Acao: Baixa por Estorno
	   			desabilitaAcaoOutros(13);	// Acao: Solicitação 2a. via Bloqueto
	   			desabilitaAcaoOutros(14);	// Acao: Reinclusão de Título
	   			desabilitaAcaoOutros(20);	// Acao: Reemissão e Postagem de Bloquetos
				}
			}

		function habilitaAcaoProtesto(valorAcao) {     
	      	for (var i=0; i < document.frmMain.rdoProtesto.length; i++) {
	      		if (document.frmMain.rdoProtesto[i].value == valorAcao) {
	      			document.frmMain.rdoProtesto[i].disabled = false;
	      			if (document.frmMain.acoesServicoTitulo.value == valorAcao)
	      				document.frmMain.rdoProtesto[i].checked = true;
							break;
	      		}
	      	}
      	}

		function desabilitaAcaoProtesto(valorAcao) {
	      	for (var i=0; i < document.frmMain.rdoProtesto.length; i++) {
	      		if (document.frmMain.rdoProtesto[i].value == valorAcao) {
	      			document.frmMain.rdoProtesto[i].disabled = true;
							break;
	      		}
	      	}
		}

		function habilitaAcaoOutros(valorAcao) {     
	      	for (var i=0; i < document.frmMain.rdoOutros.length; i++) {
	      		if (document.frmMain.rdoOutros[i].value == valorAcao) {
	      			document.frmMain.rdoOutros[i].disabled = false;
	      			if (document.frmMain.acoesServicoTitulo.value == valorAcao)
	      				document.frmMain.rdoOutros[i].checked = true;
							break;
	      		}
	      	}
		}

		function desabilitaAcaoOutros(valorAcao) {     
	      	for (var i=0; i < document.frmMain.rdoOutros.length; i++) {
	      		if (document.frmMain.rdoOutros[i].value == valorAcao) {
	      			document.frmMain.rdoOutros[i].disabled = true;
							break;
	      		}
	      	}
		}

		function formSubmit() {
		  	formSubmit_Consultar();
    	}

		function formSubmit_Consultar() {
	        document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_CONSULTAR%>";
	        document.frmMain.submit();
		}

		function formSubmit_Alterar() {
			
			
			
			<%  if(!tituloBean.getPrinciSituacao().equals(new Long(1))) {%> // EM ABERTO
			msg("042","","","");
			
			return false;
			<% } else {%>	
	        document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_ALTERAR%>";
	        document.frmMain.submit();
			
			<%}%>

		}

		function formSubmit_AcoesProtesto() {
			if (validaSubmit_AcoesProtesto()) {
			
				// 155 = 'Deseja realmente executar esta ação?'
				// 156 = 'Deseja realmente executar esta ação?\nAção sujeita a cobrança de tarifa.'
				var msg_conf=(acao_exige_tarifa(document.frmMain.acoesServicoTitulo.value)?"156":"155");

				// 157 = 'Deseja realmente executar esta ação?\nJá existe débito de custas para este título.'
				var msg_conf=(acao_permite_custascartorarias(document.frmMain.acoesServicoTitulo.value)&&
											valida_cobranca_custascartorarias()?"157":msg_conf);

		    if (confirm(conf(msg_conf))) {
			    <%if (tituloBean.getPrinciSituacao().equals(new Long(8))) {	// Situacao: Sustado Cartorio%>
				    	if (document.frmMain.acoesServicoTitulo.value == 3) {		// Acao: ESTORNO ENVIO/SUSTACAO
				    		document.frmMain.acoesServicoTitulo.value = 16;				// Acao: ESTORNO DE SUSTACAO
			    		}
			    <%}%>
				  	document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_ACAO%>";
				    document.frmMain.submit();
				}
			}
		}

		function validaSubmit_AcoesProtesto() {
		    if (!validaRadioButton(document.frmMain.rdoProtesto, '')) {
				  return false;
		    }
		
			if (acao_exige_valorrecebido(document.frmMain.acoesServicoTitulo.value) &&
					document.frmMain.acoesValorRecebido.disabled == false) {
				if (!validaCampoObrigatorio(document.frmMain.acoesValorRecebido, 'Valor Recebido')) {
					return false;
				}
				if (!validaValorZero(document.frmMain.acoesValorRecebido, 'Valor Recebido')) {
					return false;
				}
			}
			if (acao_exige_custascartorarias(document.frmMain.acoesServicoTitulo.value) &&
					document.frmMain.acoesDespesasCartorarias.disabled == false) {
				if (!validaCampoObrigatorio(document.frmMain.acoesDespesasCartorarias, 'Despesas Cartorárias')) {
					return false;
				}
				if (!validaValorZero(document.frmMain.acoesDespesasCartorarias, 'Despesas Cartorárias')) {
					return false;
				}
			}
				return true;
		}

		function acao_exige_tarifa(acao) {
			if (acao==1   ||  // Envio ao Cartório
					acao==2   ||  // Sustação de Protesto
					acao==8   ||  // Baixa por Protesto
					acao==9   ||  // Liquidado em Cartório
					acao==10  ||  // Liquidado em Cartório Condicional 
					acao==11  ||  // Baixa Manual - Devolução
					acao==13  ||  // Solicitação 2a. via Bloqueto
					acao==20 ){	  // Reemissão e Postagem de Bloquetos
				return true;
			}
				return false;
		}

		function acao_exige_valorrecebido(acao) {
			if (acao==9  ||  // Liquidado em Cartório 
				acao==10 ){  // Liquidado em Cartório Condicional 
	
				return true;
			}
				return false;
		}			

		function acao_permite_custascartorarias(acao) {
			if (acao==1  ||  // Envio ao Cartório
				acao==2  ||  // Sustação de Protesto
		    <%if (!tituloBean.getPrinciSituacao().equals(new Long(7))) {	// Situacao: Enviado a Cartorio%>
				acao==3  ||  // Estorno Envio/Sustação
			<%}%>
				//EAM - SISOT 171H - Habilitar o campo de Despesa Cartorária para acao ==8
				acao==8  ||  // Baixa por Protesto

				acao_exige_custascartorarias(acao)){
					return true;
				}
			return false;
		}

		function acao_exige_custascartorarias(acao) {
			if (acao==4 || // Débito Custas Cartorárias
				acao==19 ){ //Debito Custas/Despesas Cartorarias - Protesto Centralizado  
				return true;
			}
			return false;
		}			

		function valida_cobranca_custascartorarias() {
			if (document.frmMain.acoesDespesasCartorarias.disabled == false) {
				if(trim(document.frmMain.acoesDespesasCartorarias.value) != "" &&
					 trim(document.frmMain.acoesDespesasCartorarias.value) != "R$ 0,00" &&
					 trim(document.frmMain.abatiCustasCartorarias.value) != "" &&
					 trim(document.frmMain.abatiCustasCartorarias.value) != "R$ 0,00") {

					return true;
				}
			}

			return false;
		}

		function acao_permite_historico(acao) {
			if (acao==2  ||  //Acao: Sustação de Protesto 
				acao==3  ||  //Acao: Estorno Envio/Sustação 
			    acao==6  ||  //Acao: Suspender Envio ao Cartório 
			    acao==7  ){  //Acao: Incluir Título na Remessa

				return true;
			}
			return false;
		}			


		function formSubmit_AcoesOutros() {
			if (validaSubmit_AcoesOutros()) {
				// 155 = 'Deseja realmente executar esta ação?'
				// 156 = 'Deseja realmente executar esta ação?\nAção sujeita a cobrança de tarifa.'
				var msg_conf=(acao_exige_tarifa(document.frmMain.acoesServicoTitulo.value)?"156":"155");

			    if (confirm(conf(msg_conf))) {
			    <%if (tituloBean.getPrinciSituacao().equals(new Long(5)) ||	// Situacao: Baixa por Devolucao
		    			tituloBean.getPrinciSituacao().equals(new Long(6))) {	// Situacao: Baixa por Protesto%>
			    	if (document.frmMain.acoesServicoTitulo.value == 14) {	// Acao: Reinclusao de Titulo
			    		document.frmMain.acoesServicoTitulo.value = 15;				// Acao: Reinclusao de Baixa
			    	}
			    <%}%>
				  	document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_ACAO%>";
				    document.frmMain.submit();
				}
			}
		}

		function validaSubmit_AcoesOutros() {
			if(!validaRadioButton(document.frmMain.rdoOutros, '')){
				return false;
			}
		
			return true;
		}

		function formSubmit_Voltar() {
			document.frmMain.filtroVoltarAcao.value = '0';
			if ((document.frmMain.filtroVoltarListarTitulo.value == '1') ||
				(document.frmMain.filtroVoltarListarConsolidado.value == '1')) {
			     document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_MANTER_FILTRO%>";
			} else {
				document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_MANTER_INICIAR%>";
			}
				document.frmMain.fluxo.value = "voltar";
				document.frmMain.submit();
		}

		function preparaAcaoProtesto() {
			for (var i=0; i < document.frmMain.rdoProtesto.length; i++) {
	      		if (document.frmMain.rdoProtesto[i].checked) {
					trataCampo_acoesValorRecebido(document.frmMain.rdoProtesto[i].value);
					trataCampo_acoesDespesasCartorarias(document.frmMain.rdoProtesto[i].value);
					trataCampo_acoesHistorico(document.frmMain.rdoProtesto[i].value);
	
		   			document.frmMain.acoesServicoTitulo.value = document.frmMain.rdoProtesto[i].value;
					break;
				}
			}
		}

		function preparaAcaoOutros() {
			for (var i=0; i < document.frmMain.rdoOutros.length; i++) {
      			if (document.frmMain.rdoOutros[i].checked) {
					document.frmMain.acoesServicoTitulo.value = document.frmMain.rdoOutros[i].value;
					break;
				}
			}
		}

			function trataCampo_acoesValorRecebido(acao) {
				if (acao_exige_valorrecebido(acao)) {
					if(document.frmMain.acoesValorRecebido.value.indexOf('~') != -1 )
						document.frmMain.acoesValorRecebido.value="";
			    document.frmMain.acoesValorRecebido.disabled = false;
				} else {
			    document.frmMain.acoesValorRecebido.value="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
			    document.frmMain.acoesValorRecebido.disabled = true;
			  }
      }
			function trataCampo_acoesDespesasCartorarias(acao) {
				if (acao_permite_custascartorarias(acao)) {
					if(document.frmMain.acoesDespesasCartorarias.value.indexOf('~') != -1 )
						document.frmMain.acoesDespesasCartorarias.value="";
			    document.frmMain.acoesDespesasCartorarias.disabled = false;
				} else {
			    document.frmMain.acoesDespesasCartorarias.value="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
			    document.frmMain.acoesDespesasCartorarias.disabled = true;
			  }
      }
			function trataCampo_acoesHistorico(acao) {
				if (acao_permite_historico(acao)) {
			  	document.frmMain.Editar.disabled = false;
				} else {
					document.frmMain.acoesHistorico.value = "";
					document.frmMain.textAreaAcoesHistorico.value = "";
					document.frmMain.Editar.disabled = true;
			  }
      }
      
	    function editaMensagem( campo, colunas, altura, largura, linhas) {
			var resposta = showModalDialog('<%=Paths.getRootForDynamicContent()%>/jump/edita_mensagem.jsp?linhas='+linhas+'&colunas='+colunas, campo.value, "dialogHeight:"+altura+"; dialogWidth:"+largura+"; center: yes; help:no; resizable:yes; scroll:yes; status:no");
			if (resposta != null) {
				campo.value = resposta;
			}
			document.frmMain.acoesHistorico.value = removeBarraEne(campo.value, 50);
	    }
	    
	    
	    function submitBaixa() {
	    	document.frmMain.estrategia.value = "consulta.BaixaOperacionalManterDireto";
	    	document.frmMain.submit();
	    
	    }
	    
	    function listarBaixa(){
	    	document.frmMain.estrategia.value = "consulta.BaixaEfetivaManterFiltro";
	    	document.frmMain.submit();
	    }
		</script>
	</s:FormStrategy>
</p:Document>
</html>
