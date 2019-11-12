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
	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="servico.SimuladorNegocialManterCNPJIniciar" fluxo="normal">
		<input type="hidden" name="cpfCnpj">
		<input type="hidden" name="icPessoa">
		<input type="hidden" name="nuSimulacao">
		<input type="hidden" name="nomeCedente">
		
		
		
		<script>
			function inicia() {
				<%=!sessAtiva?"msg('018');window.close()":"formSubmit()"%>
			}
			function formSubmit() {
				document.frmMain.cpfCnpj.value=opener.frmMain.cpfCnpj.value;
				document.frmMain.icPessoa.value=opener.frmMain.icPessoa.value;
				document.frmMain.nuSimulacao.value=opener.frmMain.nuSimulacao.value;
				document.frmMain.nomeCedente.value=opener.frmMain.nomeCedente.value;

				document.frmMain.submit();
			}
	  </script>
  </s:FormStrategy>
</p:Document>
</html>