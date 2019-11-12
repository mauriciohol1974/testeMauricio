<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	boolean sessAtiva = false;
	sessAtiva = session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN) == null? false : true;
%>

<html>
<s:HeaderPopup/>

<p:Document>
	<% String action = "SigcbControle";%>
	<s:FormStrategy name="frmMain" action="<%=action%>"
		estrategia="cedente.CedenteConsultarTarifasIniciar" fluxo="normal">
		
		<input type="hidden" name="codigoCedente">
		<input type="hidden" name="codigoAgrupamentoServico">
		<input type="hidden" name="descricaoAgrupamentoServico">

		<script>
			function inicia() {
				<%=!sessAtiva?"msg('018');window.close()":"formSubmit()"%>
			}
			function formSubmit() {
				document.frmMain.codigoCedente.value=opener.frmMain.codigoCedente.value;
				document.frmMain.descricaoAgrupamentoServico.value=getDescricaoSelect(opener.frmMain.codigoAgrupamentoServico);
				document.frmMain.codigoAgrupamentoServico.value=opener.frmMain.codigoAgrupamentoServico.value;
				document.frmMain.submit();
			}
	  </script>
  </s:FormStrategy>
</p:Document>
</html>