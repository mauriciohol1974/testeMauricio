<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: sigcb_expsession.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 02/02/2005
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
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
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
          <p align="center">
						<table width="70%" height="90" border="1" cellspacing="0" cellpadding="0" align="center" valign="middle" bordercolordark="#cccccc" bordercolorlight="#ffffff">
							<tr>
								<td colspan="2" valign="center" align="middle">
									<img src="<%=Paths.getImagePath()%>/caixa_nome.gif">
								</td>
							</tr>
							<tr bgcolor="#f5f5f5">
								<td width="10%" valign="center" align="middle">
									<img src="<%=Paths.getImagePath()%>/msgErro.gif">
								</td>
								<td class="textoDestaqueTitulo" valign="center" align="middle">
									Desculpe, não foi possível acessar o sistema neste momento, 
									favor efetuar login novamente.
								</td>
							</tr>
						</table>
					</p>
        </td>
      </tr>
			<tr>
				<td>&nbsp;</td>	
			</tr>
			<tr>
				<td>&nbsp;</td>	
			</tr>
			<tr>
				<td>
					<table align="center">
		        <tr> 
			        <td>
		  	        <p align="center">
			  	        <s:Button name="Ok" action="javascript:formSubmit()"/>
		            </p>
		          </td>
		        </tr>
					</table>
				</td>
			</tr>
    </table>
    
    <script language="javascript">
			function inicia() {
				setFirstFieldFocus();
			}			
			function formSubmit() {
				window.top.location.replace("<%=Paths.getRootForStaticContent()%>");
			}
    </script>
    
	</s:FormStrategy>
</p:Document>
</html>