<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Agosto de 2004
*Projeto CAIXA - SIGCB
*Componente: sigcb_logo.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 23/08/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<html>
<s:Header/>

<p:Document>

	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="login.PaginaPrincipal" 
		fluxo="normal" saibamais="init/home.html">

		<s:Menu/>

    <br>
    <br>
    <br>
    <br>
    <br>
 
    <table width="777">
      <tr>
        <td align="center">
          <p align="center"><img border="0" src="<%=Paths.getImagePath()%>/caixa_sigcb.gif"></p>
        </td>
      </tr>
    </table>
    <script language="javascript">
			function formSubmit() {
			}
			function inicia() {
			}			
    </script>
  </s:FormStrategy>
</p:Document>
</html>