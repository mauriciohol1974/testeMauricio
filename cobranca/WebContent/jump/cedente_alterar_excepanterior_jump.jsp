<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	boolean sessAtiva = false;
	sessAtiva = session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN) == null? false : true;
%>

<html>
<s:HeaderPopup/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="cedente.CedenteAlterarExcepAntIniciar" fluxo="normal">

		<input type="hidden" name="numeroPendenciaVigente">
		<input type="hidden" name="numeroReiteracaoVigente">
		<input type="hidden" name="justificativa">

		<script>
			function inicia() {
				<%=!sessAtiva?"msg('018');window.close()":"formSubmit()"%>
			}
			function formSubmit() {
				document.frmMain.numeroPendenciaVigente.value=opener.frmMain.numeroPendenciaVigente.value;
				document.frmMain.numeroReiteracaoVigente.value=opener.frmMain.numeroReiteracaoVigente.value;
				document.frmMain.justificativa.value=opener.frmMain.justificativa.value;				
				document.frmMain.submit();
			}
	  </script>
  </s:FormStrategy>
</p:Document>
</html>
