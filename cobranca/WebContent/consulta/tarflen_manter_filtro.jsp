<script language="javascript">
	history.go(+1);
</script>

<%
	 /***********************************************
	 *Politec - Filial São Paulo
	 *Fabrica de Projetos - Junho de 2004
	 *Projeto CAIXA - SIGCB
	 *Componente: tarflen_manter_filtro.jsp - Java Server Pages
	 *Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
	 *Ultima Atualização: 04/11/2004 - v1
	 ************************************************/
%>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page
	import="br.gov.caixa.sigcb.estrategia.consulta.TarFlEnEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.ConGerTarifaFloatENBean"%>

<%
			ConGerTarifaFloatENBean filtroBean = (session
			.getAttribute(TarFlEnEstrategia.BEAN_FILTRO) == null ? new ConGerTarifaFloatENBean()
			: (ConGerTarifaFloatENBean) session
			.getAttribute(TarFlEnEstrategia.BEAN_FILTRO));
%>

<s:Header />
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="consulta.TarFlEnManterFiltro" fluxo="normal">
		<s:Menu />
		<s:Titulo name="Consultar Tarifas Por Float e SR" />
		<!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->

		<table width="777" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="53" valign="middle" align="center">
					<tr>
						<td class="textoTitulo" width="17%">Unidade SR:</td>
						<!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
						<td class="textoValor" width="26%"><p:InputNumerico
							name="codigoUnidadeEn" maxlength="4" size="5" CLASS="inputtext"
							value='<%=filtroBean.getCodigoUnidadeEn().equals(new Long(0))?"":filtroBean.getCodigoUnidadeEn().toString()%>'
							onFocus="javascript: prevFocus(this);"
							onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);" />
						</td>
						<td width="17%">&nbsp;</td>
						<td width="26%">&nbsp;</td>
					</tr>

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4">
						<p align="center"><s:Button name="Ok"
							action="javascript:formSubmit()" /></p>
						</td>
					</tr>
				</table>
				</TD>
			</tr>
		</table>

		<script>
		function inicia(){
			setFirstFieldFocus();
		}
		
		function formSubmit() {
			if (validaSubmit()) {
				document.frmMain.submit();
			}
		}
		
		function validaSubmit(){
			if (!validaCampoObrigatorio(document.frmMain.codigoUnidadeEn,'Unidade SR')) {
				return false;
			}
			return true;
		}
	</script>
	</s:FormStrategy>
</p:Document>
