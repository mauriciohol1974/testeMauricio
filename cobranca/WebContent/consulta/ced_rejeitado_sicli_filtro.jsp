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

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.CedRejeitadoSicliEstrategia"%>

<%
	String pv = "";
	if (request.getParameter("codigoPv") != null) {
		pv = request.getParameter("codigoPv");
	}
%>
<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia='<%=CedRejeitadoSicliEstrategia.STRATEGY_MANTER_LISTAR%>'
		fluxo="normal">
		<s:Menu />
		<s:Titulo name='<%=CedRejeitadoSicliEstrategia.PAGE_TITLE_FILTRO%>' />

		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="1" cellpadding="0"
					height=53 valign="middle" align="center">
					<tr>
						<td class="textoTitulo" width="80">PV Vinculado</td>
						<td class="textoValor"><p:InputNumerico CLASS="inputtext"
							name="codigoPv" size="6" maxlength="4" value="<%=pv%>"
							onFocus="javascript: prevFocus(this);" /></td>
					</tr>
					<tr>
						<td align="right" colspan="7">
						<p align="center"><input type="button" class="button"
							name="Ok" value="Ok" onclick="javascript:formSubmit_OK();">
						</p>
						</td>
					</tr>
					<tr>
						<td colspan="8">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
	</s:FormStrategy>
</p:Document>
</html>
<script language="javascript">
    function inicia(){
        //loadMenus();
    }
	
	function formSubmit_OK() {
		if(!validaCampoObrigatorio(document.frmMain.codigoPv,"PV Vinculado")) {
			return false;
		}
        document.frmMain.submit();
	}
	
	function validaInserir(){
		return true;
	}
</script>
