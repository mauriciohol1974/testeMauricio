
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.MCExtraEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.ConGerMovimentoCedenteBean"%>

<%
String codCedente = (String)request.getAttribute("codigoCedente");
String dataExtrato = (String)request.getAttribute("dataEmissao");

String codCedente1 = (String)session.getAttribute("codigoCedente");
String dataExtrato1 = (String)session.getAttribute("dataEmissao");
%>

<html>
<s:HeaderPopup/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia='<%=MCExtraEstrategia.STRATEGY_IMPRIMIR%>' fluxo="normal">
    
    	<input type="hidden" name="pagina" />
		<input type="hidden" name="paginaFinal"  />
		<input type="hidden" name="codigoCedente"  />
		<input type="hidden" name="dataEmissao"  />
   
    <script>
		function inicia() {
				
				document.frmMain.codigoCedente.value=opener.frmMain.codigoCedente.value;
				document.frmMain.dataEmissao.value=opener.frmMain.dataEmissao.value;
				document.frmMain.pagina.value=opener.frmMain.pagina.value;
				document.frmMain.paginaFinal.value=opener.frmMain.paginaFinal.value;
				formSubmit();
		}
			
	    function formSubmit() {

			document.frmMain.submit();
				
	    }
    </script>
  </s:FormStrategy>
</p:Document>
</html>