<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: procurar_cep_jump.jsp - Java Server Pages
*Autor: Glauber M. Gallego ggallego@sao.politec.com.br
*Ultima Atualização: 29/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.comum.ProcurarCepEstrategia"%>
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
		estrategia="<%=ProcurarCepEstrategia.STRATEGY_CONSULTAR%>" fluxo="normal">
    <input type="hidden" name="cep" value ="">
		<script>
			function inicia() {
				<%=!sessAtiva?"msg('018');window.close()":"formSubmit()"%>
			}
			function formSubmit() {
				document.frmMain.cep.value = opener.frmMain.cep.value;
				document.frmMain.submit();
			}
	  </script>
  </s:FormStrategy>
</p:Document>
</html>