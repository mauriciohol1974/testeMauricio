<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConteudoListaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.PrivilegioUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%String descCriticas = "";
			if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
				descCriticas = (String) request
						.getAttribute(CedenteEstrategia.DESC_CRITICAS);
			}

			%>

<%CedenteCabecaBean cabecaBean = (session
					.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN) == null ? new CedenteCabecaBean()
					: (CedenteCabecaBean) session
							.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

			CedentePrincipalBean principalBean = (session
					.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN) == null ? new CedentePrincipalBean()
					: (CedentePrincipalBean) session
							.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN));

			CedenteConteudoListaBean filtroBean = (session
					.getAttribute(CedenteEstrategia.ALTERAR_FILTRO_BEAN) == null ? new CedenteConteudoListaBean()
					: (CedenteConteudoListaBean) session
							.getAttribute(CedenteEstrategia.ALTERAR_FILTRO_BEAN));

			String nsuTransacao = filtroBean.getNsuTransacao();

			String situacaoGuia = principalBean.getSituacaoGuia() == null ? CedenteEstrategia.CONSULTA
					: principalBean.getSituacaoGuia();
			int guiaAberta = principalBean.getGuiaAberta() == null ? CedenteEstrategia.GUIA_NENHUMA
					: principalBean.getGuiaAberta().intValue();

			String codigoCedente = "";
			if (filtroBean.getCodigoCedente() != null) {
				codigoCedente = "" + filtroBean.getCodigoCedente();
			}

			%>

<%PrivilegioUsuarioBean usuarioBean = (session
					.getAttribute(CedenteEstrategia.PRIVILEGIO_BEAN) == null ? new PrivilegioUsuarioBean()
					: (PrivilegioUsuarioBean) session
							.getAttribute(CedenteEstrategia.PRIVILEGIO_BEAN));

			String clienteExternoDisabled = usuarioBean.ehGestor() ? "false"
					: "true";

			%>


<%CedenteGeralBean geralBean = (session
					.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN) == null ? new CedenteGeralBean()
					: (CedenteGeralBean) session
							.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN));

			// Variaveis usadas para exibicao no caso de alteracao
			String tipoCobranca = Util.toStr(geralBean.getTipoCobranca(), ""
					+ CedenteEstrategia.COBRANCA_CONVENCIONAL); // Padrao 2 - Convencional
			String protestoAutomatico = Util.toStr(geralBean.getProtestoAutomatico(), "N"); // Padrao N
			String prazoProtesto = Util.toStr(geralBean.getPrazoProtesto());
			String prazoDevolucao = Util.toStr(geralBean.getPrazoDevolucao());
			String extratoMovTit = Util
					.toStr(geralBean.getExtratoMovTit(), "N"); // Padrao N
			String destinoExtMov = Util.toStr(geralBean.getDestinoExtMov(),
					"99"); // Padrao 99 - Brancos
			String extratoMovDebtCredt = Util.toStr(geralBean
					.getExtratoMovDebtCredt(), "N"); // Padrao N
			String destinoExtMovDebtCredt = Util.toStr(geralBean	.getDestinoExtMovDebtCredt(), "99"); // Padrao 99 - Brancos
			String inventarioMes = Util
					.toStr(geralBean.getInventarioMes(), "N"); // Padrao N

			String tipoJurosDia = geralBean.getTipoJurosDia() != null ? ""
					+ geralBean.getTipoJurosDia() : "1"; // Padrao 1 - Juros Banco

			String percentualJurosDia = Util.toStr(geralBean
					.getPercentualJurosDia());
			String recebimentoCheque = Util.toStr(geralBean
					.getRecebimentoCheque(), "S"); // Padrao S
			String multa = Util.toStr(geralBean.getMulta());
			String prazoMulta = Util.toStr(geralBean.getPrazoMulta());
			String clienteExterno = Util.toStr(geralBean.getClienteExterno(),
					"S"); // Padrao S
			String clienteGiroCaixa = Util.toStr(geralBean
					.getClienteGiroCaixa(), "3"); // Padrao 3 - Nao utiliza girocaixa
			String setor = Util.toStr(geralBean.getSetor(), "99"); // Padrao 99 - Brancos
			String porte = Util.toStr(geralBean.getPorte(), "0"); // Padrao 0 - Brancos (99 ja utilizado)
			String natureza = Util.toStr(geralBean.getNatureza(), "0"); // Padrao 0 - Brancos (99 ja utilizado)
			String ramoAtividade = Util.toStr(geralBean.getRamoAtividade(),
					"99"); // Padrao 99 - Brancos
			String exclusaoAutomatica = Util.toStr(geralBean
					.getExclusaoAutomatica(), "S"); // Padrao S
			String modalidadeTitulo = Util.toStr(geralBean
					.getModalidadeTitulo(), "1"); // Padrao 1 - Registrado
			String codigoUnidadePVVinc = Util.toStr(geralBean
					.getCodigoUnidadePVVinc());
			String codCedenteCentraliz = Util.toStr(geralBean
					.getCodCedenteCentraliz());
			String bancoCorrespondente = Util.toStr(geralBean
					.getBancoCorrespondente(), "N");
			String cobrancaSemBloqueto = Util.toStr(geralBean
					.getCobrancaSemBloqueto(), "1"); // Padrao N
			String codRedeTransmissao = Util.toStr(geralBean
					.getCodRedeTransmissao());
			String atividade = Util.toStr(geralBean
					.getAtividade(), "9"); // Padrao 9 - Brancos
					
			//String cedSemRegistro = Util.toStr(geralBean.getCedSemRegistro(), "N");
			String retencaoIOF = Util.toStr(geralBean.getRetencaoIOF(), "N"); // Padrao N		
			String valorDiferenciado = Util.toStr(geralBean.getValorDiferenciado(),	"S"); // Padrao S
			String bancoSacados = "NAO"; // Padrao NAO
			
			if ("S".equals(geralBean.getBancoSacados())) {
				bancoSacados = "SIM";
			}

			String clienteSINCE = "N"; // Padrao N
			if ("S".equals(geralBean.getClienteSINCE())) {
				clienteSINCE = "S";
			}

			String situacao = "ATIVO"; // Padrao ATIVO
			if ("I".equals(geralBean.getSituacao())) {
				situacao = "INATIVO";
			}
			
			if ("S".equals(geralBean.getValorDiferenciado())){
				valorDiferenciado = "SIM";
			}
			
			
			String cedentePEC = geralBean.getCedentePEC();
			
			String cedenteVinculo = Util.toStr(geralBean.getCedenteVinculo());

			String dataPEC = geralBean.getDataPEC();
			
			String dtAltPvVinc = geralBean.getDtAltPvVinc();
			
			String pvAltVinc = Util.toStr(geralBean.getPvVincAnt(),"0");
			
			if (pvAltVinc.equalsIgnoreCase("0000")){
				pvAltVinc="";
			}
			
			String codigoSINCE = Util.toStr(geralBean.getCodigoSINCE(), "0"); 

			InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean) session
					.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
			
			String grupoUsuario = usuarioLDAPBean.getNomeGrupo();
			
			// SISOL 308303 JAN/2009  Não é permitido Conta Garantida para cliente com Conta de Rateio
			// O atributo selectContasRateio é obtido da Guia Contas quando Cadastrar Conta de Rateio = N
            String selectContasRateio = "N";
	        if (request.getParameter("selectContasRateio") != null) {
		        selectContasRateio = request.getParameter("selectContasRateio");
	        } else 	if (request.getAttribute("selectContasRateio") != null) {
		        selectContasRateio = (String) request.getAttribute("selectContasRateio");
	        }

	        
			%>

<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="cedente.CedenteAlterarGuiaControle" fluxo="normal">
		<s:Menu />
		<s:Titulo name="Manter Cedente >> Alterar" />

		<input type="hidden" name="guiaAberta" value="<%= guiaAberta %>">
		<input type="hidden" name="tipoCobranca" value="<%= tipoCobranca %>">
		<input type="hidden" name="cedenteCentralizador"
			value="<%= codCedenteCentraliz %>">

		<input type="hidden" name="nsuTransacao" value="<%= nsuTransacao %>">
		<input type="hidden" name="codigoCedente" value="<%= codigoCedente %>">
		<input type="hidden" name="codigoSINCE" value="<%= codigoSINCE %>">
		<input type="hidden" name="bancoSacados"
			value="<%= geralBean.getBancoSacados()==null?"N":geralBean.getBancoSacados() %>">

		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height=53 valign="middle" align="center">

					<%-- *********** CABECALHO CEDENTE ****************** --%>
					<%@include file="cedente_cabecalho.jsp"%>

					<tr valign="top">
						<td colspan="5" class="textoTitulo">Manter Guias:
						<hr>
						</td>
					</tr>

					<tr>
						<td class="textoTitulo"><a href="#GeralParent"
							onclick="javascript:trocaGuia(1);"><img
							src="<%=Paths.getImagePath()%>/outlineminus.gif" width="11"
							height="11" name="outlineplus" id="Gerali"></a> <a
							name="GeralParent">Geral</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* GERAL ************************************** -->

						<div class="group">
						<table width="95%" border="0" cellspacing="0" cellpadding="0"
							height=14 valign="middle" align="center">
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>


							<tr>
								<td colspan="4" class="textoDestaqueTitulo">Guia: Geral</td>
							</tr>
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>

							<tr>
								<td class="textoTitulo" width="17%">Tipo de Cobrança:</td>
								<td class="textoValor" width="26%"><s:ComboTipoCobranca
									name="txtTipoCobranca" selectedValue="<%= tipoCobranca %>"
									onChange="javascript:trocaComboTipoCobranca();" /></td>
								<td class="textoTitulo" width="17%">Protesto Automático:</td>
								<td class="textoValor" width="26%"><s:ComboSimNao
									name="protestoAutomatico"
									selectedValue="<%= protestoAutomatico %>" /></td>
							</tr>

							<tr>
								<td nowrap class="textoTitulo" width="17%">Prazo Protesto:</td>
								<td class="textoValor" width="26%" nowrap><p:InputNumerico
									CLASS="inputtext" name="prazoProtesto"
									value="<%= prazoProtesto %>" size="3" maxlength="3"
									onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.prazoDevolucao);" />
								</td>
								<td nowrap class="textoTitulo" width="17%">Prazo Devolução:</td>
								<td class="textoValor" width="26%" nowrap><p:InputNumerico
									CLASS="inputtext" name="prazoDevolucao"
									value="<%= prazoDevolucao %>" size="3" maxlength="3"
									onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.extratoMovTit);" />
								</td>
							</tr>

							<tr>
								<td nowrap class="textoTitulo" width="17%">Extrato Mov. Títulos:
								</td>
								<td class="textoValor" width="26%"><s:ComboSimNao
									name="extratoMovTit" selectedValue="<%= extratoMovTit %>"
									onChange="javascript:trocaComboExtratoMovTit();" /></td>
								<td nowrap class="textoTitulo" width="17%">Destino Extrato Mov.:
								</td>
								<td class="textoValor" width="26%"><!-- Codigo: 2 - Extrato -->
								<s:ComboEnvioBloqueto name="destinoExtMov" branco="true"
									brancoValue="99" codigo="2" extrato="true"
									selectedValue="<%= destinoExtMov %>" /></td>
							</tr>

							<tr>
								<td nowrap class="textoTitulo" width="17%">Extrato Mov.
								Déb./Créd.:</td>
								<td class="textoValor" width="26%"><s:ComboSimNao
									name="extratoMovDebtCredt"
									selectedValue="<%= extratoMovDebtCredt %>"
									onChange="javascript:trocaComboExtratoMovDebtCredt();" /></td>
								<td nowrap class="textoTitulo" width="17%">Destino Extrato
								Déb./Créd.:</td>
								<td class="textoValor" width="26%"><!-- Codigo: 2 - Extrato -->
								<s:ComboEnvioBloqueto name="destinoExtMovDebtCredt"
									branco="true" brancoValue="99" codigo="2" extrato="true"
									selectedValue="<%= destinoExtMovDebtCredt %>" /></td>
							</tr>

							<tr>
								<td class="textoTitulo" width="17%">Inventário Mês:</td>
								<td class="textoValor" width="26%"><s:ComboSimNao
									name="inventarioMes" selectedValue="<%= inventarioMes %>" /></td>
								<td class="textoTitulo" width="17%">Tipo de Juros Dia:</td>
								<td class="textoValor" width="26%"><s:ComboTipoJurosDia
									name="tipoJurosDia" selectedValue="<%= tipoJurosDia %>"
									onChange="javascript:trocaComboTipoJurosMes();" /></td>
							</tr>

							<tr>
								<td class="textoTitulo" width="17%">Percentual Juros Mês:</td>
								<td width="26%" nowrap><p:InputPercentual CLASS="inputtext"
									name="percentualJurosDia" value="<%= percentualJurosDia %>"
									size="9" maxlength="5" onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.recebimentoCheque);" />
								</td>
								<td class="textoTitulo" width="17%">Recebimento em Cheque:</td>
								<td class="textoValor" width="26%">
									<%--
									SIM <input type="hidden" name="recebimentoCheque" value="S" />
									 --%>
									<s:ComboSimNao name="recebimentoCheque" selectedValue="<%= recebimentoCheque %>" />
								</td>
							</tr>

							<tr>
								<td class="textoTitulo" width="17%">Percentual Multa:</td>
								<td width="26%" nowrap><p:InputPercentual CLASS="inputtext"
									name="multa" value="<%= multa %>" size="9" maxlength="5"
									onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.prazoMulta);" />
								</td>
								<td class="textoTitulo" width="17%">Prazo para Multa:</td>
								<td width="26%" nowrap><p:InputNumerico CLASS="inputtext"
									name="prazoMulta" value="<%= prazoMulta %>" size="3"
									maxlength="3" onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.clienteExterno);" />
								</td>
							</tr>

							<tr>
								<td class="textoTitulo" width="17%">Banco de Sacados:</td>
								<td class="textoValor" width="26%"><%=bancoSacados%></td>
								<td class="textoTitulo" width="17%">Cliente Conta Garantida:</td>
								<td class="textoValor" width="26%"><s:ComboSimNao
									name="clienteSINCE"
									selectedValue="<%= clienteSINCE %>" /></td>
							</tr>

							<tr>
								<td class="textoTitulo" width="17%">&nbsp;</td>
								<td class="textoValor" width="26%">&nbsp;
								<input type="hidden"name="clienteExterno" value="S" /> <!-- item1.5 SISOL 188627 <s:ComboSimNao name="clienteExterno" selectedValue="<%= clienteExterno %>" onChange="javascript:verificaTipoPessoa();" disabled="<%= clienteExternoDisabled %>" />-->
								</td>
								<td class="textoTitulo" width="17%">Cliente GiroCaixa:</td>
								<td class="textoValor" width="26%">NAO UTILIZA GIROCAIXA <input
									type="hidden" name="clienteGiroCaixa"
									value="<%= clienteGiroCaixa %>" /> <!--<s:ComboGiroCaixa name="clienteGiroCaixa" selectedValue="<%= clienteGiroCaixa %>" onChange="javascript:trocaComboGiroCaixa();"/>-->
								</td>
							</tr>

							<tr>
								<td class="textoTitulo" width="17%">Setor:</td>
								<td class="textoValor" width="26%"><s:ComboSetor name="setor"
									selectedValue="<%= setor %>" branco="true" brancoValue="99" />
								</td>
								<td class="textoTitulo" width="17%">Porte:</td>
								<td class="textoValor" width="26%"><s:ComboPorte name="porte"
									selectedValue="<%= porte %>" branco="true" brancoValue="0" />
								</td>
							</tr>

							<tr>
								<td class="textoTitulo" width="17%">Natureza:</td>
								<td class="textoValor" width="26%"><s:ComboNatureza
									name="natureza" selectedValue="<%= natureza %>" branco="true"
									brancoValue="0" onChange="javascript:trocaComboNatureza();" />
								</td>
								<td class="textoTitulo" width="17%">Ramo de Atividade:</td>
								<td class="textoValor" width="26%"><select name="ramoAtividade">
									<option value="99"></option>
								</select></td>
							</tr>
							
							<tr>
								<td class="textoTitulo" width="17%">Tipo de Atividade:</td>
								<td class="textoValor" width="26%"><s:ComboAtividade
									name="atividade" selectedValue="<%= atividade %>" branco="true"
									brancoValue="9" />
								</td>
								<td class="textoTitulo" width="17%">Retenção IOF:</td>
								<td class="textoValor" width="26%"><s:ComboSimNao
									name="retencaoIOF" selectedValue="<%= retencaoIOF %>" />
								</td>	
							</tr>

							<tr>
								<td class="textoTitulo" width="17%">Exclusão Automática:</td>
								<td class="textoValor" width="26%"><s:ComboSimNao
									name="exclusaoAutomatica"
									selectedValue="<%= exclusaoAutomatica %>" /></td>
																		
								<td class="textoTitulo" width="17%">Modalidade de Título:</td>
								<td class="textoValor" width="26%"><s:ComboModalidadeTitulo
									name="modalidadeTitulo" selectedValue="<%= modalidadeTitulo %>" />
								</td>
								
							</tr>

							<tr>
								<td class="textoTitulo" width="17%">Pv de Vinculação:</td>
								<td class="textoValor" width="26%"><p:InputNumerico
									CLASS="inputtext" name="codigoUnidadePVVinc"
									value="<%= codigoUnidadePVVinc %>" size="5" maxlength="4" /></td>
								<td class="textoTitulo" width="17%">Cedente Centralizador:</td>
								<td class="textoValor" width="26%"><p:InputNumerico
									CLASS="inputtext" name="codCedenteCentraliz"
									value="<%= codCedenteCentraliz %>" size="8" maxlength="7"
									onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);" />
								</td>
							</tr>
							
							
							<tr>
								<td class="textoTitulo" width="17%">Pv de Vinculação Anterior:</td>
								<td class="textoValor" width="26%"><p:InputNumerico
									CLASS="inputtext" name="pvVincAnt"
									value="<%=pvAltVinc  %>" size="5" maxlength="4" disabled="true" /></td>
								<td class="textoTitulo" width="17%">Data Alteração Pv Vinculação:</td>
								<td class="textoValor" width="26%"><p:InputAlfanumerico
									CLASS="inputtext" name="dtAltPvVinc"
									value="<%=dtAltPvVinc  %>" size="12" maxlength="10" disabled="true"
									onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);" />
								</td>
							</tr>
							
							

							<tr>
								<td class="textoTitulo" width="17%">Banco Correspondente:</td>
								<td class="textoValor" width="26%"><s:ComboSimNao name="bancoCorrespondente"  selectedValue="<%= bancoCorrespondente %>" /></td>
								<td class="textoTitulo" width="17%">Cobrança S/ Boleto - PEC:</td>
								<td class="textoValor" width="26%">
								<% if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")) {%>
									<s:ComboCobracaSimNao
									name="cobrancaSemBloqueto"
									selectedValue="<%= cobrancaSemBloqueto %>"
									onChange="javascript:trocaComboBloqueto();" disabled="false" />
								<%}else{ %>
									<s:ComboCobracaSimNao
									name="cobrancaSemBloqueto"
									selectedValue="<%= cobrancaSemBloqueto %>"
									onChange="javascript:trocaComboBloqueto();" disabled="true" />
								
								<%}%>
								
								
								
								
							</tr>

							<tr>
								<td class="textoTitulo" width="17%">Situação do Cedente:</td>
								<td class="textoValor" width="26%"><%=situacao%></td>
								<td class="textoTitulo" width="17%">Valor Atualizado:</td>
								<td class="textoValor" width="26%"><s:ComboSimNao
									name="valorDiferenciado" selectedValue="<%= valorDiferenciado %>" />
								</td>
								
							</tr>
								<td class="textoTitulo" width="17%">Cod. Rede Transmissão</td>
								<td class="textoValor" width="26%"><p:InputNumerico
									CLASS="inputtext" name="codRedeTransmissao"
									value="<%= codRedeTransmissao %>" size="4" maxlength="4"
									onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codRedeTransmissao);" /></td>
                               
								</td>						
							</tr>
							
							<tr>
							<%if (!codigoSINCE.equals("0")) { %>									
								<td class="textoTitulo" width="17%">Código SINCE:</td>
								
								<td class="textoValor" width="26%"><%= codigoSINCE %>
								</td>		
								<%} %>
							</tr>
							
							<tr>
							
								<td class="textoTitulo" width="17%">Cedente Master PEC</td>
								<% if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")) {%>
									<td class="textoValor" width="26%"><s:ComboSimNao	name="cedentePEC" selectedValue="<%= cedentePEC %>" onChange="javascript: trocaPEC();" disabled="false"/></td>
								<%} else { %>
									<td class="textoValor" width="26%"><s:ComboSimNao	name="cedentePEC" selectedValue="<%= cedentePEC %>" onChange="javascript: trocaPEC();" disabled="true"/></td>
								<%} %>
								<td class="textoTitulo" width="17%">Cedente Vínculo PEC</td>
								<td class="textoValor" width="26%"><p:InputNumerico	CLASS="inputtext" name="cedenteVinculo"	value="<%= cedenteVinculo %>" size="8" maxlength="7"
									onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codRedeTransmissao);" /></td>
							</tr>	
					
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>

							<tr>
								<td align="right" colspan="4">
								<p align="center"><s:Button name="Confirmar"
									action="javascript:formSubmit_Geral();"
									userGroup="<%=usuarioLDAPBean.getNomeGrupo()%>"
									internalAction="cedente.cadastro.manter.alterar" /> <s:Button
									name="Cancelar" action="javascript:fecharGuias();"
									userGroup="<%=usuarioLDAPBean.getNomeGrupo()%>"
									internalAction="cedente.cadastro.manter.alterar" /></p>
								</td>
							</tr>
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>
						</table>
						</div>
						</td>
					</tr>
					<tr>
						<td class="textoTitulo"><a href="#FloatParent"
							onclick="javascript:trocaGuia(2);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Floati"></a> <a
							name="FloatParent">Float</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* FLOAT ************************************** -->
						</td>
					</tr>
					<tr>
						<td class="textoTitulo"><a href="#ContasParent"
							onclick="javascript:trocaGuia(3);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Contasi"></a> <a
							name="contasParent">Contas Déb. Créd. e Rateio</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* CONTAS ************************************** -->
						</td>
					</tr>

					<tr>
						<td class="textoTitulo"><a href="#CedenteParent"
							onclick="javascript:trocaGuia(4);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Cedentei"></a> <a
							name="CedenteParent">Cedente Eletrônico</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* CEDENTE ELETRONICO ************************************** -->
						</td>
					</tr>
					<tr>
						<td class="textoTitulo"><a href="#BloquetosParent"
							onclick="javascript:trocaGuia(5);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Bloquetosi"></a> <a
							name="BloquetosParent">Boletos</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* BLOQUETOS ************************************** -->
						</td>
					</tr>

					<tr>
						<td class="textoTitulo"><a href="#MensagemParent"
							onclick="javascript:trocaGuia(6);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Mensagemi"></a> <a
							name="MensagemParent">Mensagens para Boletos</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* MENSAGEM ************************************** -->
						</td>
					</tr>

					<tr>
						<td class="textoTitulo"><a href="#TarifasParent"
							onclick="javascript:trocaGuia(7);"> <img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Tarifasi"></a> <a
							name="TarifasParent">Tarifas</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* TARIFAS ************************************** -->
						</td>
					</tr>
					<tr>
						<td class="textoTitulo"><a href="#ParametrosParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_PARAMETROS%>);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Mensagemi"></a> <a
							name="MensagemParent">Parâmetros</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>	
					<tr>
						<td colspan="4"><!-- ************************************************* PARAMETROS  ************************************** -->
						</td>
					</tr>
					<tr>
						<td class="textoTitulo"><a href="#PermissaoParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_PERMISSAO%>);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Permissaoi"></a> <a
							name="PermissaoParent">Permissão Final</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* Permissão  ************************************** -->
						</td>
					</tr>		
					<tr>
						<td class="textoTitulo"><a href="#ConclusaoParent"
							onclick="javascript:trocaGuia(8);"> <img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Conclusaoi"></a> <a
							name="ConclusaoParent">Conclusão</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* CONCLUSAO ************************************** -->
						</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td align="right" colspan="4">
						<p align="center"><s:Button name="Voltar_Principal" value="Voltar"
							action="javascript:formSubmit_Voltar();" /> <s:Button
							name="Cancelar_Principal" value="Cancelar Alteração"
							action="javascript:formSubmit_Cancelar();" /></p>
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
			var naturezasRamos = new Array();
			var naturezasOriginal = new Array();
			var setorOriginal = new Array();
			
			
			<s:ComboRamoAtividadeJavaScript />
			

	    function inicia(){
		    	
				// Salva os option originais de natureza
				for (var i = 0; i < document.frmMain.natureza.options.length; i++) {
					naturezasOriginal[i] = document.frmMain.natureza.options[i];
				}
				
				// Salva os option originais de setor
				for (var i = 0; i < document.frmMain.setor.options.length; i++) {
					setorOriginal[i] = document.frmMain.setor.options[i];
				}

				trocaPEC();
				
				verificaTipoPessoa();

				trocaComboTipoCobranca();
				
				trocaComboExtratoMovTit();

				trocaComboExtratoMovDebtCredt();

				trocaComboTipoJurosMes();

				// Carrega o combo de Ramo Atividade de acordo com a Natureza
				trocaComboNatureza();
				
				trocaComboAtividade();
				
				// Aplica regras do combo giro caixa
				trocaComboGiroCaixa();

				document.frmMain.ramoAtividade.value = "<%= ramoAtividade %>";
				
				document.frmMain.atividade.value = "<%= atividade %>";
				
				bloquearCodRedeTrans();

				<%
					// caso retornou da estrategia com criticas
					if (!descCriticas.equals("")) {
				%>
								alert("<%= descCriticas %>");
				<%
					}
				%>

				// se pessoa tipo 2 (Juridico) habilitar combo Retenção de IOF
	    		if (<%= cabecaBean.getTipoPessoa() %> == 2) { // 2 - JURIDICA
	    			//document.frmMain.retencaoIOF.value = "N";
	    			document.frmMain.retencaoIOF.disabled = false;
	    		} else { // Se for Pessoa Fisica a combo fica desabilitada com Valor Nao
	    			document.frmMain.retencaoIOF.value = "N";
	    			document.frmMain.retencaoIOF.disabled = true;	    			
	    			document.frmMain.atividade.value = "9";
	    			document.frmMain.atividade.disabled = true;	    			
	    		}	
		}
		
		function bloquearCodRedeTrans() {
			// faz a validação para carregar pela primeira vez o campo desabilitado.
			if(document.frmMain.cobrancaSemBloqueto.value != '3') {
				document.frmMain.codRedeTransmissao.disabled = true;
			}
		}

		function formSubmit_Cancelar() {
        	var confirma = confirm(conf('126'));
		
			if (confirma) {
				document.frmMain.estrategia.value="cedente.CedenteAlterarCancelar";
				document.frmMain.submit();
			}
		}

	    function formSubmit_Voltar() {
        	var confirma = confirm(conf('161'));
      
	        if (confirma) {
	        	document.frmMain.fluxo.value = "voltar";
	          document.frmMain.estrategia.value="cedente.CedenteManterFiltro";
	          document.frmMain.submit();
	        }
	    }
	    
	    function trocaGuia( guia ) {
	    	if (!confirm(conf("128"))) {
	    		return;
	    	}
	    
	    	if (guia == <%= guiaAberta %>) {
	    		fecharGuias();
	    		return;
	    	}

		   	//if (guia == <%= CedenteEstrategia.GUIA_CEDENTE_ELETRONICO %>
	    	//			&& document.frmMain.tipoCobranca.value == <%= ""+CedenteEstrategia.COBRANCA_CONVENCIONAL %>) {
	    	//		return;
	    	//}
	    
	    	document.frmMain.guiaAberta.value = guia;
	    	document.frmMain.submit();
	    }
	    
	    function fecharGuias() {
		    	document.frmMain.guiaAberta.value = <%= CedenteEstrategia.GUIA_NENHUMA %>;
		    	document.frmMain.submit();
	    }
	    
	    function formSubmit() {
	    	formSubmit_Geral();
	    }
	    
	    function formSubmit_Geral() {
	    	if (validaSubmit_Geral() && validaValores_Geral() && validaCamposDependentes_Geral()) {
	    		var confirma = confirm(conf('127'));
	    	
		    	if (confirma) {
			    	document.frmMain.estrategia.value="cedente.CedenteAlterarGuiaGeralFinalizar";
			    	habilitaCampos();
			    	// passa o tipo cobranca escolhido para o hidden
			    	document.frmMain.tipoCobranca.value = document.frmMain.txtTipoCobranca.value;
			    	document.frmMain.submit();
			    }
		   	}
	    }
	    
	    // Valida campos obrigatorios
	    function validaSubmit_Geral() {
	    	var camposObrigatorios = new Array(3);
	    	// array com nome campo, descricao
	    	camposObrigatorios[0] = new Array( "prazoProtesto", "Prazo Protesto" );
	    	camposObrigatorios[1] = new Array( "prazoDevolucao", "Prazo Devolução" );
	    	camposObrigatorios[2] = new Array( "codigoUnidadePVVinc", "Pv de Vinculação" );
	    	
	    	return validaArrayCamposObrigatorios(camposObrigatorios);
	    }
	    
	    // Valida valores corretos
	    function validaValores_Geral() {

			if ((document.frmMain.tipoCobranca.value != 3) &&
				(document.frmMain.txtTipoCobranca.value == 3)){
				alert('Não é possível alterar o tipo de cobrança de um cedente para ELETRÔNICA SINCO');
				return false;
			}

	    	// Prazo Protesto entre 2 e 90
	    	if (trim(document.frmMain.prazoProtesto.value) != "") {
				if (document.frmMain.prazoProtesto.value < 2 || document.frmMain.prazoProtesto.value > 90) {
				  msg('005', 'Prazo Protesto', 2, 90);
				  document.frmMain.prazoProtesto.focus();
	        	return false;
				}
			}
				
			// Prazo Devolucao entre 5 e 120
			if (trim(document.frmMain.prazoDevolucao.value) != "") {
				if (document.frmMain.prazoDevolucao.value < 5 ||
				    document.frmMain.prazoDevolucao.value > 120) {
				  msg('005', 'Prazo Devolução', 5, 120);
				  document.frmMain.prazoDevolucao.focus();
	        	return false;
				}
			}
    		
    		// Cedente Centralizador maior que 0
    		if (!validaMenorIgual(document.frmMain.codCedenteCentraliz, 'Cedente Centralizador', 0)) {
    			return false;
    		}

    		// Banco Correspondente maior que 0
    		if (!validaMenorIgual(document.frmMain.bancoCorrespondente, 'Banco Correspondente', 0)) {
    			return false;
    		}

    		// Banco Correspondente diferente de 104 (Caixa Economica Federal)
    		if (trim(document.frmMain.bancoCorrespondente.value) == '104') {
    			msg("050");
    			return false;
    		}
            
                      
           //if(!verificaOpcoesDisponiveisCombosExtrato('extratoMovTit')){
           // msg("069");
           // return false;
           //}
           
           //if(!verificaOpcoesDisponiveisCombosExtrato('extratoMovDebtCredt')){
           // msg("070");
           // return false;
           //}
           
			if(!validaTipoJurosDia()){
				msg("068");
				return false;
			}

			return true;
	    }
	    
	    // Campos que sao obrigatorios dependendo do valor de outro campo
	    function validaCamposDependentes_Geral() {

	    	if (document.frmMain.extratoMovTit.value == 'S') {
				if (!validaComboObrigatorio(document.frmMain.destinoExtMov, 'Destino Extrato Mov.', 99)) {
					return false;
				}
	    	}
	    	
	    	if (document.frmMain.extratoMovDebtCredt.value == 'S') {
				if (document.frmMain.extratoMovTit.value == 'N') {
					msg('027');
					document.frmMain.extratoMovDebtCredt.focus();
					return false;
				}
				if (!validaComboObrigatorio(document.frmMain.destinoExtMovDebtCredt, 'Destino Extrato Déb./Créd', 99)) {
					return false;
				}
	    	}
	    	
	    	if (document.frmMain.tipoJurosDia.value == 2) { // 2 - Juros Cedente
				if (!validaCampoPercentualObrigatorio(document.frmMain.percentualJurosDia, 'Percentual Juros Mês')) {
					return false;
				}
	    	}
	    	
	    	// Percentual Multa deve ser diferente de zero quando o Prazo Multa estiver preenchido
	    	if (trim(document.frmMain.prazoMulta.value) != "") {
	    		if (!validaCampoPercentualObrigatorio(document.frmMain.multa, 'Percentual Multa')) {
	    			return false;
	    		}
	    	}

	    	// Prazo Multa deve ser diferente de zero quando o Percentual Multa estiver preenchido
	    	if (trim(document.frmMain.multa.value) != "" && desformataPercentual(document.frmMain.multa.value) != 0) {
	    		if (!validaCampoObrigatorio(document.frmMain.prazoMulta, 'Prazo para Multa')) {
	    			return false;
	    		}
	    		if (!validaMenorIgual(document.frmMain.prazoMulta, 'Prazo para Multa', 0)) {
    				return false;
    			}
	    	}
	    	
	    	//EAM - Validar consistencia entre Tipo de Cobrança e Cliente GiroCaixa
	    	if(document.frmMain.txtTipoCobranca.value == 1){ // Eletrônica
		    	if(document.frmMain.clienteGiroCaixa.value == 2){ // Convencional
		    		msg('062','','Eletrônica','Convencional');
		    		return false;
		    	}
	    	}else{
		    	if(document.frmMain.clienteGiroCaixa.value == 1){ // Eletrônico
		    		msg('062','','Convencional','Eletrônica');
		    		return false;
		    	}
	    	}

	    	if (document.frmMain.clienteGiroCaixa.value != 3) { // 3 - Nao Utiliza Girocaixa
					// Setor, Porte, Natureza, Ramo de Atividade sao obrigatorios
		    	if (!validaComboObrigatorio(document.frmMain.setor, "Setor", '99')) {
		    		return false;
		    	}
		    	if (!validaComboObrigatorio(document.frmMain.porte, "Porte", '0')) {
		    		return false;
		    	}
		    	if (!validaComboObrigatorio(document.frmMain.natureza, "Natureza", '0')) {
		    		return false;
		    	}
		    	if (!validaComboObrigatorio(document.frmMain.ramoAtividade, "Ramo de Atividade", '99')) {
		    		return false;
		    	}
	    	}
	    	
	    	// Valida o campo Cobranca sem Bloqueto
			if(document.frmMain.cobrancaSemBloqueto.value == '3'
				&& document.frmMain.codRedeTransmissao.value == '') {
				if (!validaComboObrigatorio(document.frmMain.codRedeTransmissao, 'Cod. Rede Transmissão.')) {
	    			return false;
	    		}
			}
			
			//SISOL 308303 JAN/2009 - Valida campo Conta Garantida da Guia Geral e campo Cadastrar Contas de Rateio da Guia Contas
            if(document.frmMain.clienteSINCE.value == "S"){
            	var selContasRateio = "<%= selectContasRateio %>";
		    	if( selContasRateio == "S"){ 
		    		alert("Não é permitido Conta Garantida para cliente com Conta de Rateio");
                    document.frmMain.clienteSINCE.focus();
		    		return false;
		    	}
	    	}
	    	
	    	return true;
	    }
	    
	    function desabilitaAtividade() {
    		document.frmMain.clienteGiroCaixa.value = '3'; // 3 - Nao Utiliza GiroCaixa
    		document.frmMain.clienteGiroCaixa.disabled = true;
    		
				trocaComboGiroCaixa();    		

    		document.frmMain.setor.value = 99;
    		document.frmMain.setor.disabled = true;

    		document.frmMain.porte.value = 0;
    		document.frmMain.porte.disabled = true;

    		// Branco do natureza eh 0, 99 ja eh utilizado
    		document.frmMain.natureza.value = 0;
    		document.frmMain.natureza.disabled = true;

    		trocaComboNatureza();

    		document.frmMain.ramoAtividade.value = 99;
    		document.frmMain.ramoAtividade.disabled = true;
	    }
	    
	    function habilitaAtividade() {
    		document.frmMain.setor.disabled = false;
    		document.frmMain.porte.disabled = false;
    		document.frmMain.natureza.disabled = false;
    		document.frmMain.ramoAtividade.disabled = false;
    		document.frmMain.clienteGiroCaixa.disabled = false;
	    }
	    
	    function verificaTipoPessoa() {
	    	// se pessoa Fisica soh pode ser cliente externo
	    	if (<%= cabecaBean.getTipoPessoa() %> == 1) { // 1 - FISICA
	    		document.frmMain.clienteExterno.value = "S";
	    		document.frmMain.clienteExterno.disabled = true;
	    		desabilitaAtividade();
	    	} else { // 2 - JURIDICA
	    		if (document.frmMain.clienteExterno.value == "S") { // Cliente Externo
	    			habilitaAtividade();
	    		} else { // Cliente Interno
		    		desabilitaAtividade();
	    		}
	    	}
	    }

	    // se tipo cobranca convencional nao pode cedente centralizador

        function trocaComboTipoCobranca() {
 
   			if ((document.frmMain.txtTipoCobranca.value == <%= CedenteEstrategia.COBRANCA_CONVENCIONAL %>) 
	  		||(document.frmMain.txtTipoCobranca.value == <%= CedenteEstrategia.COBRANCA_ELEITORAL_CONVENCIONAL %>)){
	    		document.frmMain.codCedenteCentraliz.value = "";
	    		document.frmMain.codCedenteCentraliz.disabled = true;
			} else {
	    		document.frmMain.codCedenteCentraliz.disabled = false;
	    	}
	    	//Ade - Eleitoral - 16/04/2010
	    	setDefaultExtratoMovTitComTipoCobranca();
			trocaComboExtratoMovTit();
           //setDefaultExtratoMovTitComTipoCobranca(); 
  		}
	   
	   
	    
			
			//Caso o campo Cliente GiroCaixa seja Eletrônica ou Convencional
			//apresentar no combo apenas as opções:
			//01 - Comercial
			//02 - Industrial
			//03 - Serviços Diversos
			//04 - Serviços Turismo
			function trocaComboGiroCaixa() {
				var tamanho = document.frmMain.natureza.options.length;
				var tamanho2 = document.frmMain.setor.options.length;
				
				if (document.frmMain.clienteGiroCaixa.value == 1 || document.frmMain.clienteGiroCaixa.value == 2) { // 1 - Eletronica ou 2 - Convencional
					// Troca A Natureza
					// Remove os maiores que 04 (tem o branco)
		    	for (var i = tamanho - 1; i > 4  ; i--) {
		    		document.frmMain.natureza.remove(i);
		    	}

		    	// Troca Setor
					// Remove os maiores que 01 (tem o branco)
		    	for (var i = tamanho2 - 1; i > 1  ; i--) {
		    		document.frmMain.setor.remove(i);
		    	}
				} else {
					// Troca A Natureza
					// Remove todos
		    	for (var i = tamanho - 1; i >= 0  ; i--) {
		    		document.frmMain.natureza.remove(i);
		    	}

		    	// Volta os originais
		    	for (var i = 0; i < naturezasOriginal.length; i++) {
						document.frmMain.natureza.add(naturezasOriginal[i]);
		    	}
		    	
		    	// Troca Setor
					// Remove todos
		    	for (var i = tamanho2 - 1; i >= 0  ; i--) {
		    		document.frmMain.setor.remove(i);
		    	}

		    	// Volta os originais
		    	for (var i = 0; i < setorOriginal.length; i++) {
						document.frmMain.setor.add(setorOriginal[i]);
		    	}
				}
			}

	    function trocaComboNatureza() {
	    	var options = new Array();
	    	var tamanho = document.frmMain.ramoAtividade.options.length;
	    	
	    	for (var i = tamanho - 1; i >= 0; i--) {
	    		document.frmMain.ramoAtividade.remove(i);
	    	}
	    	
				document.frmMain.ramoAtividade.add(new Option(" ", "99")); // Branco
	    	for (var j = 0; j < naturezasRamos.length; j++) {
	    		if (naturezasRamos[j][0] == document.frmMain.natureza.value) {
		    		document.frmMain.ramoAtividade.add(new Option(naturezasRamos[j][2], naturezasRamos[j][1]));
	    		}
	    	}
	    }
	    
	    function trocaComboAtividade(){
	    //fazer a funcao - adelaine - 30/12/2010
	    }

			function trocaComboExtratoMovTit() {
				if (document.frmMain.extratoMovTit.value == "S") {
					document.frmMain.destinoExtMov.disabled = false;
				} else {
					document.frmMain.destinoExtMov.value = 99;
					document.frmMain.destinoExtMov.disabled = true;
				}
			}
			
			function trocaComboExtratoMovDebtCredt() {
				if (document.frmMain.extratoMovDebtCredt.value == "S") {
					document.frmMain.destinoExtMovDebtCredt.disabled = false;
				} else {
					document.frmMain.destinoExtMovDebtCredt.value = 99;
					document.frmMain.destinoExtMovDebtCredt.disabled = true;
				}
			}

			function trocaComboTipoJurosMes() {
				if (document.frmMain.tipoJurosDia.value == 2) { // 2 - Juros Cedente
					document.frmMain.percentualJurosDia.disabled = false;
				} else {
					document.frmMain.percentualJurosDia.disabled = true;
					document.frmMain.percentualJurosDia.value = '';
				}
			}

			function habilitaCampos() {
				for (var i = 0; i < document.frmMain.elements.length; i++) {
					document.frmMain.elements[i].disabled = false;
				}
			}

           //Esta função não permite que quando o tipo de Cobrança for eletronica, os campos de Extrato sejam salvos com valor "sim"
          //Porém esta função foi desabilitada. Está aqui para caso seja necessário novamente
           function verificaOpcoesDisponiveisCombosExtrato(nomeComboExtrato){
                var txtTipoCobrancaCombo = document.getElementsByName('txtTipoCobranca')[0];
                var valorSelecionadoTipoCobranca = txtTipoCobrancaCombo.getAttribute('value');
                //Se Tipo Cobrança for 'Eletrônica' ou 'Eleitoral Eletronica'
                if((valorSelecionadoTipoCobranca == '1')||(valorSelecionadoTipoCobranca == '5')){
                        var comboExtrato = document.getElementsByName(nomeComboExtrato)[0];
                        var valorComboExtrato = comboExtrato.getAttribute('value');
                        //Se opção for 'SIM' não pode   
                        if(valorComboExtrato == 'S'){
                            comboExtrato.focus();
                            return false;
                        }                        
                }
                return true;
           }
           
           //Item 1.2 SISOL 188627
           function validaTipoJurosDia(){
                var tipoJurosDia = document.getElementsByName('tipoJurosDia')[0];
                var valorTipoJurosDia = tipoJurosDia.getAttribute('value');
                //Se for Juros Caixa
                if(valorTipoJurosDia == '1'){
                    var txtTipoCobrancaCombo = document.getElementsByName('txtTipoCobranca')[0];
                    var valorSelecionadoTipoCobranca = txtTipoCobrancaCombo.getAttribute('value');
                    //Se for Eletronica ou Convencional - Não pode
                    if(valorSelecionadoTipoCobranca == '1' || valorSelecionadoTipoCobranca == '2' || valorSelecionadoTipoCobranca == '4' || valorSelecionadoTipoCobranca == '5'){
                        tipoJurosDia.focus();
                        return false;
                    }
                }
                return true;
           }
           
           
        //REFERENTE A REEDIÇÂO DO ITEM 1.7 da SISOL 188627
        //INCLUSAO DO TIPO DE COBRANÇA ELEITORAL   
        function setDefaultExtratoMovTitComTipoCobranca(){
            var txtTipoCobrancaCombo = document.getElementsByName('txtTipoCobranca')[0];
            var valorSelecionadoTipoCobranca = txtTipoCobrancaCombo.getAttribute('value');
            var extratoMovTitCombo = document.getElementsByName('extratoMovTit')[0];
            var valorExtratoMovTit = extratoMovTitCombo.getAttribute('value');
            //Se Convencional
            if(valorSelecionadoTipoCobranca == '2' || valorSelecionadoTipoCobranca == '4'){
                extratoMovTitCombo.setAttribute('value','S');
            }
            //Se for Eletronica 
            else if(valorSelecionadoTipoCobranca == '1' || valorSelecionadoTipoCobranca == '5'){
                extratoMovTitCombo.setAttribute('value','N');
            }
         }
        
        function trocaComboBloqueto() {
        	if (document.frmMain.cobrancaSemBloqueto.value != '3') {
	    		document.frmMain.codRedeTransmissao.value = "";
	    		document.frmMain.codRedeTransmissao.disabled = true;
	    	} else {
	    		document.frmMain.codRedeTransmissao.disabled = false;
	    	}
        }
        
		function trocaPEC(){
			if (document.frmMain.cedentePEC.value=='S') {
				document.frmMain.cedenteVinculo.value="";
				document.frmMain.cedenteVinculo.disabled=true
			}else{
				document.frmMain.cedenteVinculo.disabled=false
			}
		}
    </script>

	</s:FormStrategy>
</p:Document>
</html>