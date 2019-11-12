<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: protegida.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 04/02/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page session="false"%>

<html>
<!DOCTYPE HTML
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<s:Header/>
<head>
</head>
<body>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbLogin" 
		estrategia="login.PaginaPrincipal" fluxo="normal">
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>&nbsp;</td>	
			</tr>
			<tr>
				<td>&nbsp;</td>	
			</tr>
			<tr>
				<td>&nbsp;</td>	
			</tr>
			<tr>
				<td>&nbsp;</td>	
			</tr>
      <tr>
        <td align="center">
 			<table width="70%" height="90" border="1" cellspacing="0" cellpadding="0" align="center" valign="middle" bordercolordark="#cccccc" bordercolorlight="#ffffff">
				<tr>
				
					<td colspan="2" valign="center" align="middle">
						<img src="<%=Paths.getImagePath()%>/caixa_nome.gif">
					</td>
				</tr>
				<tr>
					<td rowspan="3" width="10%" valign="center" align="middle">
						<img src="<%=Paths.getImagePath()%>/msgErro.gif">
					</td>
					<td rowspan="2"class="alertLogin" valign="center" align="middle">
						Atenção! Esta aplicação deve ser acessada via Internet Explorer.
					</td>
				</tr>
				<tr>

				</tr>
				<tr bgcolor="#f5f5f5">

					<td  class="textoDestaqueTitulo" valign="center" align="middle">
						Caso esteja utilizando o Internet Explorer aguarde, você será direcionado para a tela principal do sistema. Obrigado!
					</td>
				</tr>
			</table>
        </td>
      </tr>
			<tr>
				<td>&nbsp;</td>	
			</tr>
			<tr>
				<td>&nbsp;</td>	
			</tr>
    </table>
    
    <script language="javascript">
			function inicia() {
				document.frmMain.submit();
			}
    </script>
    
	</s:FormStrategy>
</p:Document>
</body>
</html>