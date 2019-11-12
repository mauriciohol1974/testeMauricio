<script language="javascript">
	history.go(+1);
</script>

<%
	 /***********************************************
	 *Politec - Filial São Paulo
	 *Fabrica de Projetos - Outubro de 2004
	 *Projeto CAIXA - SIGCB
	 *Componente: cedbcos_manter_filtro.jsp - Java Server Pages
	 *Autor: Andrew Betencourt - p911883@mail.caixa
	 *Ultima Atualização: 28/10/2004
	 ************************************************/
%>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page
	import="br.gov.caixa.sigcb.estrategia.consulta.CedRejeitadoSicliEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteRejeitadoSicliBean"%>
<%@page import="java.util.ArrayList"%>

<%
	ArrayList lista = (ArrayList) request.getAttribute("resultado");

	CedenteRejeitadoSicliBean cedenteRejeitadoBean = (CedenteRejeitadoSicliBean) session
			.getAttribute("CedenteRejeitadoSicliBean");
%>

<html>
<s:Header />
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia='<%=CedRejeitadoSicliEstrategia.STRATEGY_MANTER_LISTAR%>'
		fluxo="voltar">
		<s:Menu />
		<s:Titulo name='<%=CedRejeitadoSicliEstrategia.PAGE_TITLE_FILTRO%>' />
		<input type="hidden" name="codigoPv"
			value="<%=request.getParameter("codigoPv")%>">
		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="1" cellpadding="0"
					height=53 valign="middle" align="center">
					<tr>
						<td class="textoTitulo" width="17%">Unidade PV:</td>
						<td class="textoValor" width="26%"><%=request.getParameter("codigoPv")%></td>
						<td class="textoTitulo" width="17%">Nome Unidade:</td>
						<td class="textoValor" width="26%"><%=cedenteRejeitadoBean.getNomePv()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Cedente:</td>
						<td class="textoValor" width="26%"><%=request.getParameter("numeroCedente")%></td>
						<td class="textoTitulo" width="17%">Nome Cedente:</td>
						<td class="textoValor" width="26%"><%=request.getParameter("nomeCedente")%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Código Cliente (COCLI):</td>
						<td class="textoValor" width="26%"><%=request.getParameter("numeroCocli")%></td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Data da Inclusão:</td>
						<td class="textoValor" width="26%"><%=request.getParameter("dataInclusao")%></td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="4" class="textoTitulo">Retorno do SICLI
						<hr>
						</td>
					</tr>
					<tr>
						<td colspan="4">
						<table width="100%" border="0" cellspacing="3" cellpadding="0"
							align="center" valign="middle">
							<tr class="headerLista">
								<td nowrap width="10%" align="right">Código</td>
								<td nowrap width="89%" align="left">Mensagem</td>
							</tr>
							<%
										CedenteRejeitadoSicliBean bean = new CedenteRejeitadoSicliBean();
										for (int i = 0; i < lista.size(); i++) {
									bean = (CedenteRejeitadoSicliBean) lista.get(i);
							%>
							<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td width="10%" align="right"><%=bean.getNumeroRetornoSicli()%></td>
								<td width="89%" align="left"><%=bean.getDescricaoRetornoSicli()%></td>
							</tr>
							<%
							}
							%>
							<tr>
								<td colspan="6">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="6">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="6">&nbsp;</td>
							</tr>
							<tr>
								<td align="right" colspan="6">
								<p align="center"><input type="button" class="button"
									name="Voltar" value="Voltar"
									onclick="javascript:formSubmit_Voltar();"></p>
								</td>
							</tr>
							<tr>
								<td colspan="8">&nbsp;</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
	</s:FormStrategy>
</p:Document>

<script language="javascript">
	function inicia(){
		//loadMenus();
    }

    function formSubmit_Voltar() {
		document.frmMain.submit();
    }

</script>