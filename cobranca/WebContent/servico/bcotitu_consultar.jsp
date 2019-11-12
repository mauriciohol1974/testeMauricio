
<%
	 /***********************************************
	 *Politec - Filial São Paulo
	 *Fabrica de Projetos - Agosto de 2004
	 *Projeto CAIXA - SIGCB
	 *Componente: bcotitu_consultar.jsp - Java Server Pages
	 *Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
	 *Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
	 *Ultima Atualização: 03/09/2004
	 ************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BcoTituEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>

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
	String dataPrevisaoProtDev = formato.format(tituloBean
			.getAbatiDataPrevisaoProtDev());
	String dataDevolucao = formato.format(tituloBean
			.getPrinciDataVencimento());
%>

<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=BcoTituEstrategia.STRATEGY_ACAO%>" fluxo="normal">
		<s:Menu />
		<s:Titulo name="<%=BcoTituEstrategia.PAGE_TITLE_CONSULTAR%>" />

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
		<input type="hidden" name="filtroVoltarAcao"
			value="<%=tituloBean.getFiltroVoltarAcao()%>">

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
						<td class="textoValor" width="26%"><%=tituloBean.getPrinciValorTitulo().toString()%></td>
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
						<td colspan="4" class="textoTitulo">Consultar Título:
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
										.equals("01/01/0001") ? "" : tituloBean.getPrinciDataVencimentoFormatada()%></td>
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
									<td class="textoValor" width="17%"><%=tituloBean.getPrinciPrazoProtDev()%></td>
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
									<td class="textoValor" width="26%"><%=tituloBean.getEnvioBloquetoTexto()%></td>
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
									<td class="textoValor" width="26%"><%=tituloBean.getTipoSMS()%></td>
								</tr>
								


								<tr>
									<td class="textoTitulo" width="17%">ST. Bloq. SE:</td>
									<td class="textoValor" width="83%" colspan="3"><%=tituloBean.getSituacaoBloqSE()%></td>
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
									<td class="textoValor" width="83%" colspan="3"><%=tituloBean.getAlegacaoSE().toString()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Tipo Calculo:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getTipoCalculo()%></td>
									<td class="textoTitulo" width="17%">Autorização:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getAutorizacao()%></td>
								</tr>
								 -->
								 
								 								 
								<tr>
									<td class="textoTitulo" width="17%">Aceite SE:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getAceiteSE()%></td>
									<td class="textoTitulo" width="17%">Indicador Registro na CIP:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getIcRegistroCIP()%></td>
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
									<td class="textoValor" width="26%"><%=tituloBean.getIcAutPagto()%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Tipo de Pagamento:</td>
									<td class="textoValor" width="26%"> <%=tituloBean.getIcTipoPagamento().equals("1") ? "1-Aceita qualquer valor" : ""%>
									 <%=tituloBean.getIcTipoPagamento().equals("2") ? "2-Aceita valores entre range mínimo e máximo" : ""%>
									 <%=tituloBean.getIcTipoPagamento().equals("3") ? "3-Não aceita valor divergente" : ""%>
									 <%=tituloBean.getIcTipoPagamento().equals("4") ? "4-Aceita valores considerando apenas o valor mínimo" : ""%>
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
								
								
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
							</table>
						</s:Outline></td>
					</tr>

					<tr>
						<td colspan="4"><s:Outline name="Complementar"
							title="Dados Complementares"
							imagePath="<%=Paths.getImagePath()%>" type="outline">
							<table width="95%" border="0" cellspacing="0" cellpadding="0"
								height=14 valign="middle" align="center">
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								
								<tr>
									<td nowrap class="textoTitulo" width="17%">Abatimento:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getCompleAbatimento().toString()
										.equals("R$ 0,00") ? "" : tituloBean
								.getCompleAbatimento().toString()%></td>
									<td class="textoTitulo" width="17%">Nome Sacador/Avalista:
									</td>
									<td class="textoValor" width="26%"><%=tituloBean.getCompleSacadorNome()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Tipo Pessoa Sacador:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getCompleSacadorTipoPessoaTexto()%></td>
									<td class="textoTitulo" width="17%">CPF/CNPJ do Sacador:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getCompleSacadorCpfCnpjFormatado()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">IOF a ser Retido:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getCompleRetidoValorIOF()%></td>								
									<td class="textoTitulo" width="17%">&nbsp;</td>
									<td class="textoValor" width="26%">&nbsp;</td>
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
									<td colspan="4">
									<table width="100%" border="0" cellspacing="0" cellpadding="0"
										height=14 valign="middle" align="center">
										<tr class="headerLista">
											<td nowrap width="17%" align="center">&nbsp;</td>
											<td nowrap width="8%" align="left">Percentual</td>
											<td nowrap width="18%" align="left">Valor</td>
											<td nowrap width="17%" align="center">&nbsp;</td>
											<td nowrap width="8%" align="left">Dias</td>
											<td nowrap width="18%" align="center">Data</td>
										</tr>
										<tr>
											<td class="textoTitulo" width="20%">Tipo de Desconto:</td>
											<td class="textoValor" width="20%">
											
											
												<%=tituloBean.getTipoDesconto().equals("0") ? "0-Isento" : ""%>
												<%=tituloBean.getTipoDesconto().equals("1") ? "1-Valor Fixo até a data informada" : ""%>
												<%=tituloBean.getTipoDesconto().equals("2") ? "2-Percentual até a data informada" : ""%>
												<%=tituloBean.getTipoDesconto().equals("3") ? "3-Valor por antecipação dia corrido" : ""%>
												<%=tituloBean.getTipoDesconto().equals("4") ? "4-Valor por antecipação dia útil" : "" %>
												<%=tituloBean.getTipoDesconto().equals("5") ? "5-Percentual por antecipação dia corrido" : ""%>
												<%=tituloBean.getTipoDesconto().equals("6") ? "6-Percentual por antecipação dia útil" : ""%>
											
					
											
											</td>
										</tr>
										<tr class="line0">
											<td class="textoTitulo" width="17%" align="left">Desconto
											1:</td>
											<td class="textoValor" align="left" width="26%"><%=tituloBean.getCompleDescontoUmPercen()
										.toString().equals("0,00 %") ? ""
								: tituloBean.getCompleDescontoUmPercen()
										.toString()%></td>
											<td class="textoValor" align="left" width="26%"><%=tituloBean.getCompleDescontoUmValor()
										.toString().equals("R$ 0,00") ? ""
								: tituloBean.getCompleDescontoUmValor()
										.toString()%></td>
											<td class="textoTitulo" width="17%" align="left">Prazo
											Limite 1:</td>
											<td class="textoValor" width="26%">
											<%
															if (!tituloBean.getCompleDescontoUmPercen().toString()
															.equals("0,00 %")
															|| !tituloBean.getCompleDescontoUmValor()
															.toString().equals("R$ 0,00")) {
											%>
											<%=tituloBean.getCompleDescontoUmPrazo()
											.toString()%> <%
 }
 %>
											</td>
											<td class="textoValor" align="center" width="26%"><%=tituloBean.getCompleDescontoUmDataFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getCompleDescontoUmDataFormatada()%></td>
										</tr>
										<tr class="line2">
											<td class="textoTitulo" width="17%" align="left">Desconto
											2:</td>
											<td class="textoValor" align="left" width="26%"><%=tituloBean.getCompleDescontoDoisPercen()
										.toString().equals("0,00 %") ? ""
								: tituloBean.getCompleDescontoDoisPercen()
										.toString()%></td>
											<td class="textoValor" align="left" width="26%"><%=tituloBean.getCompleDescontoDoisValor()
										.toString().equals("R$ 0,00") ? ""
								: tituloBean.getCompleDescontoDoisValor()
										.toString()%></td>
											<td class="textoTitulo" width="17%" align="left">Prazo
											Limite 2:</td>
											<td class="textoValor" width="26%">
											<%
															if (!tituloBean.getCompleDescontoDoisPercen()
															.toString().equals("0,00 %")
															|| !tituloBean.getCompleDescontoDoisValor()
															.toString().equals("R$ 0,00")) {
											%>
											<%=tituloBean.getCompleDescontoDoisPrazo()
											.toString()%> <%
 }
 %>
											</td>
											<td class="textoValor" align="center" width="26%"><%=tituloBean
										.getCompleDescontoDoisDataFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getCompleDescontoDoisDataFormatada()%></td>
										</tr>
										<tr class="line0">
											<td class="textoTitulo" width="17%" align="left">Desconto
											3:</td>

											<td class="textoValor" align="left" width="26%"><%=tituloBean.getCompleDescontoTresPercen()
										.toString().equals("0,00 %") ? ""
								: tituloBean.getCompleDescontoTresPercen()
										.toString()%></td>
											<td class="textoValor" align="left" width="26%"><%=tituloBean.getCompleDescontoTresValor()
										.toString().equals("R$ 0,00") ? ""
								: tituloBean.getCompleDescontoTresValor()
										.toString()%></td>
											<td class="textoTitulo" width="17%" align="left">Prazo
											Limite 3:</td>
											<td class="textoValor" width="26%">
											<%
															if (!tituloBean.getCompleDescontoTresPercen()
															.toString().equals("0,00 %")
															|| !tituloBean.getCompleDescontoTresValor()
															.toString().equals("R$ 0,00")) {
											%>
											<%=tituloBean.getCompleDescontoTresPrazo()
											.toString()%> <%
 }
 %>
											</td>
											<td class="textoValor" align="center" width="26%"><%=tituloBean
										.getCompleDescontoTresDataFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getCompleDescontoTresDataFormatada()%></td>
										</tr>
										<tr class="line2">
											<td class="textoTitulo" width="17%" align="left">Multa:
											</td>
											<td class="textoValor" align="left" width="26%"><%=tituloBean.getCompleMultaPercen().toString()
										.equals("0,00 %") ? "" : tituloBean
								.getCompleMultaPercen().toString()%></td>
											<td class="textoValor" align="left" width="26%"><%=tituloBean.getCompleMultaValor().toString()
										.equals("R$ 0,00") ? "" : tituloBean
								.getCompleMultaValor().toString()%></td>
											<td class="textoTitulo" width="17%" align="left">Prazo
											para Multa:</td>
											<td class="textoValor" width="26%"><%=tituloBean.getCompleMultaPrazo().equals(
										new Long(0)) ? "" : tituloBean
								.getCompleMultaPrazo().toString()%></td>
											<td class="textoValor" align="center" width="26%"><%=tituloBean.getCompleMultaDataFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getCompleMultaDataFormatada()%></td>
										</tr>
										
										<tr>
											<td class="textoTitulo" width="20%">Tipo de Juros:</td>
											<td class="textoValor" width="20%">
											
												<%=tituloBean.getTipoJuros().equals("1") ? "1-Valor (dias corridos) " : ""%>
												<%=tituloBean.getTipoJuros().equals("2") ? "2-Percentual ao dia (dias corridos)" : ""%>
												<%=tituloBean.getTipoJuros().equals("3") ? "3-Percentual ao mês (dias corridos)" : ""%>
												<%=tituloBean.getTipoJuros().equals("4") ? "4-Percentual ao ano (dias corridos)" : ""%>
												<%=tituloBean.getTipoJuros().equals("5") ? "5-Isento" : ""%>
												<%=tituloBean.getTipoJuros().equals("6") ? "6-Valor (dia útil)" : ""%>
												<%=tituloBean.getTipoJuros().equals("7") ? "7-Percentual ao dia (dias úteis)" : ""%>
												<%=tituloBean.getTipoJuros().equals("8") ? "8-Percentual ao mês (dias úteis)" : ""%>
												<%=tituloBean.getTipoJuros().equals("9") ? "9-Percentual ao ano (dias úteis) " : ""%>
											
											</td>
										</tr>
										<tr class="line0">
											<td class="textoDestaqueTitulo" width="20%">Juros</td>
											<td class="textoValor" width="20%" align="left"><%=tituloBean.getComplePercenJurosMes().toString().equals("0,00 %") ? ""	: tituloBean.getComplePercenJurosMes().toString()%></td>
											<td class="textoValor" align="left" width="20%"><%=tituloBean.getAbatiJurosValor().toString().equals("R$ 0,00") ? "" : tituloBean.getAbatiJurosValor().toString()%></td>
											<td class="textoValor" align="right" width="20%"></td>
											<td class="textoValor" align="right" width="20%"></td>
											<td class="textoValor" align="center" width="20%"><%=tituloBean.getAbatiJurosDataFormatada().equals("01/01/0001") ? "" : tituloBean.getAbatiJurosDataFormatada()%></td>
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

					<tr>
						<td colspan="4"><s:Outline name="Liquidacao"
							title="Dados Liquidação" imagePath="<%=Paths.getImagePath()%>"
							type="outline">
							<table width="95%" border="0" cellspacing="0" cellpadding="0"
								height=14 valign="middle" align="center">
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
									<td class="textoTitulo" width="17%">Data Baixa/Liquidação:
									</td>
									<td class="textoValor" width="26%"><%=tituloBean.getLiquiDataLiquidacaoFormatada()
										.equals("01/01/0001") ? "" : tituloBean.getLiquiDataLiquidacaoFormatada()%></td>
									<td class="textoTitulo" width="17%">Canal de Liquidação:</td>
									<td class="textoValor" width="26%"><%=(tituloBean.getLiquiCanalLiquidacao())%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Data de Pagamento:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getLiquiDataPagamentoFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getLiquiDataPagamentoFormatada()%></td>
									<td class="textoTitulo" width="17%">Float:</td>
									<td class="textoValor" width="26%"><%=(tituloBean.getLiquiDataLiquidacaoFormatada()
										.equals("01/01/0001") | tituloBean
										.getLiquiDataLiquidacaoFormatada()
										.equals("")) ? "" : tituloBean
								.getLiquiDiasFloat().toString()%></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Data de Crédito:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getLiquiDataCreditoFormatada().equals("01/01/0001") ? "" : tituloBean.getLiquiDataCreditoFormatada()%></td>
									<td class="textoTitulo" width="17%">Dispensa Encargos:</td>
									<td class="textoValor" width="26%"><%= tituloBean.getFeriadoLocal() %></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="4">
									<table class="box" width="75%" border="0" cellspacing="3"
										cellpadding="0" height=14 valign="middle" align="center">
										<tr class="headerLista">
											<td align="left" class="textoDestaqueTitulo">&nbsp;</td>
											<td align="left" class="textoDestaqueTitulo">Valores
											Lançados</td>
										</tr>
										<tr class="line0">
											<td class="textoDestaqueTitulo">Documento</td>
											<td class="textoValor"><%=tituloBean.getLiquiValorDocumento()
										.toString().equals("R$ 0,00") ? ""
								: tituloBean.getLiquiValorDocumento()
										.toString()%></td>
										</tr>
										<tr class="line2">
											<td class="textoDestaqueTitulo">Juros/Multa</td>
											<td class="textoValor"><%=tituloBean.getLiquiValorJurosMulta()
										.toString().equals("R$ 0,00") ? ""
								: tituloBean.getLiquiValorJurosMulta()
										.toString()%></td>
										</tr>
										<tr class="line0">
											<td class="textoDestaqueTitulo">Desconto</td>
											<td class="textoValor"><%=tituloBean.getLiquiValorDesconto().toString()
										.equals("R$ 0,00") ? "" : tituloBean
								.getLiquiValorDesconto().toString()%></td>
										</tr>
										<tr class="line2">
											<td class="textoDestaqueTitulo">Abatimento</td>
											<td class="textoValor"><%=tituloBean.getLiquiAbatimento().toString()
										.equals("R$ 0,00") ? "" : tituloBean
								.getLiquiAbatimento().toString()%></td>
										</tr>
										<tr class="line0">
											<td class="textoDestaqueTitulo">Liquido Recebido</td>
											<td class="textoValor"><%=tituloBean.getLiquiValorLiquidoRecebido()
										.toString().equals("R$ 0,00") ? ""
								: tituloBean.getLiquiValorLiquidoRecebido()
										.toString()%></td>
										</tr>
										<tr class="line0">
											<td class="textoDestaqueTitulo">IOF Retido</td>
											<td class="textoValor"><%=tituloBean.getRetidoValorIOF().toString()
										.equals("R$ 0,00") ? "" : tituloBean
								.getRetidoValorIOF().toString()%></td>
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
									<td class="textoValor" width="20%"><%=tituloBean.getAbatiRetidoValorIOF().toString().equals("R$ 0,00")?"":tituloBean.getAbatiRetidoValorIOF().toString()%>
									
									</td>
									<td class="textoTitulo" width="20%">&nbsp;</td>
									<td class="textoValor" width="23%">&nbsp;</td>
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
										<tr class="line0">
											<td class="textoDestaqueTitulo" width="20%">Juros</td>
											<td class="textoValor" width="20%">&nbsp;</td>
											<td class="textoValor" align="center" width="20%"><%=tituloBean.getAbatiJurosDataFormatada()
										.equals("01/01/0001") ? "" : tituloBean
								.getAbatiJurosDataFormatada()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiJurosPercen().toString()
										.equals("0,00 %") ? "" : tituloBean
								.getAbatiJurosPercen().toString()%></td>
											<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiJurosValor().toString()
										.equals("R$ 0,00") ? "" : tituloBean
								.getAbatiJurosValor().toString()%></td>
										</tr>
										<tr class="line2">
											<td class="textoDestaqueTitulo" width="20%">Desconto 1</td>
											<td class="textoValor" width="20%">
											<%
															if (!tituloBean.getAbatiDescontoUmPercen().toString()
															.equals("0,00 %")
															|| !tituloBean.getAbatiDescontoUmValor()
															.toString().equals("R$ 0,00")) {
											%>
											<%=tituloBean.getAbatiDescontoUmPrazo()
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
											%>
											<%=tituloBean.getAbatiDescontoDoisPrazo()
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
											%>
											<%=tituloBean.getAbatiDescontoTresPrazo()
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

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td align="right" colspan="4">
						<p align="center"><s:Button name="Alterar"
							action="javascript:formSubmit_Alterar();"
							userGroup="<%=usuarioBean.getNomeGrupo()%>"
							internalAction="servico.bancotitulos.alterar" /> <s:Button
							name="Voltar" action="javascript:formSubmit_Voltar();" /></p>
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
				document.frmMain.Voltar.focus();
			}
			
			function formSubmit() {
				if (validaSubmit()) {
					document.frmMain.submit();
				}
			}
		
			function formSubmit_Alterar() {

				
				<% if(!tituloBean.getPrinciSituacao().equals(new Long(1))) {%> // EM ABERTO
					msg("042","","","");
					
					return false;
				<% } else { %>
				
			        document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_ALTERAR%>";
			        document.frmMain.submit();
				
				<%}%>
				
      }
	
			function formSubmit_Voltar() {
		    document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_MANTER_FILTRO%>";
		    document.frmMain.fluxo.value = "normal";
		    document.frmMain.submit();
		  }
		</script>
	</s:FormStrategy>
</p:Document>
</html>
