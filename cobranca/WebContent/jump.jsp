<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: jump.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 06/12/2004
************************************************/
%>

<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page session="false"%>

<script language="JavaScript">
	window.top.location.replace("<%=Paths.getRootForStaticContent()%>");
</script>        
