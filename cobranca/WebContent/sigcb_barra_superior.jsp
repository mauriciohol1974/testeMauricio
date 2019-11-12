<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: sigcb_barra_superior.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 21/06/2004
************************************************/
%>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page session="false"%>

<HTML>
	<s:Header/>
  <BODY>
	<table width="780" cellspacing="0" cellpadding="0">
	  <tbody>
	    <tr>
	      <td width="158px" align="right" valign="top" background="<%=Paths.getImagePath()%>/bordaBarra.gif"></td>
	      <td background="<%=Paths.getImagePath()%>/barra.gif">
	        <H1>SIGCB - Sistema Gestão de Cobrança Bancária&nbsp;&nbsp;&nbsp;</H1>
	      </td>
	    </tr>
	  </tbody>
	</table>
  </BODY>
</HTML>
