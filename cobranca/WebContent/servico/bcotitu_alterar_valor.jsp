
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
	
%>

<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=BcoTituEstrategia.STRATEGY_ALTERAR_VALOR_FINALIZAR%>" fluxo="normal">
		<s:Menu />
		<s:Titulo name="<%=BcoTituEstrategia.PAGE_TITLE_ALTERAR%>" />

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
						<td colspan="4" class="textoTitulo">Alterar Título:
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
								    <td class="textoTitulo" width="17%">Valor do Título:</td>
									<td><p:InputCurrency name="princiValorTitulo" maxlength="17" size="29" 
                						CLASS="inputtext" value='<%=tituloBean.getPrinciValorTitulo().toString()%>' 
                						onFocus="javascript: prevFocus(this);" onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiDataVencimento);"/> 
										</td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Número Documento:</td>
									<td class="textoValor" width="26%" nowrap><%=tituloBean.getPrinciNumeroDocumento()%></td>
									<td class="textoTitulo" width="17%">Data de Vencimento:</td>
									<td class="textoValor" width="26%" nowrap><p:InputDate
										name="princiDataVencimento"
										value="<%=tituloBean.getPrinciDataVencimentoFormatada()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiAceiteCombo)" />
									</td>
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
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Autoriza Pagamento Parcial/Divergente:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getIcAutPagto()%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Tipo de Pagamento:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getIcTipoPagamento()%></td>
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
									<td class="textoTitulo" width="17%">Valor Máximo de Pagamento:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getVrMaximoPgto()%></td>
									<td class="textoTitulo" width="17%">Qtde. Pagamentos Efetuados:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getQtPgtoEfetuado()%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Valor Mínimo de Pagamento:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getVrMinPgto()%></td>
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
									<td class="textoTitulo" width="17%">Tipo Juros Mes:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getCompleTipoJurosMesFormatada()%></td>
									<td class="textoTitulo" width="17%">Percentual Juros Mes:
									</td>
									<td class="textoValor" width="26%"><%=tituloBean.getComplePercenJurosMes()
										.toString().equals("0,00 %") ? ""
								: tituloBean.getComplePercenJurosMes()
										.toString()%></td>
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
						<p align="center">
							<s:Button name="Alterar"	action="javascript:formSubmit_Alterar();"	userGroup="<%=usuarioBean.getNomeGrupo()%>"	internalAction="servico.bancotitulos.alterar" /> 
							<s:Button name="Voltar" action="javascript:formSubmit_Voltar();" /></p>
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


        		document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_ALTERAR_VALOR_FINALIZAR%>";
       			document.frmMain.submit();
      		}
	
			function formSubmit_Voltar() {
		    document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_MANTER_FILTRO%>";
		    document.frmMain.fluxo.value = "voltar";
		    document.frmMain.submit();
		  }
		</script>
	</s:FormStrategy>
</p:Document>
</html>
