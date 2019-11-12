<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - 21 de Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: sigcb_login.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
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
	<s:FormStrategy name="frmMain" action="j_security_check"
		estrategia="login.AutenticacaoUsuario" fluxo="normal" method="POST">
    <table width="768px" border="0">
      <tr>
        <td>
          <img border="0" src="<%=Paths.getImagePath()%>/caixa_logo.gif" width="283" height="203" >
        </td>
        <td width='60%'>
          <table border=0 width='100%'>
            <tr>
       		 <td colspan=2 >
       		 	#CONFIDENCIAL 05
       		 </td>
          	</tr>
            <tr>
              <td colspan=2 >
                <h2>Login</h2>
                <hr>
              </td>
            </tr>
            <tr>
              <td colspan=2>
                <p>&nbsp;</p>
              </td>
            </tr>
            <tr>
              <th class="textoTitulo">Usuário</th>
               <td width="85%">
                <p:InputAlfanumerico name="j_username" maxlength="8" size="10"
	                onFocus="javascript: prevFocus(this);"
	                onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.j_password);"/>
              </td>
            </tr>
            <tr>
              <th class="textoTitulo"> Senha </th>
              <td>
				<input type="password" name="j_password" maxlength="8" size="10"
					onFocus="javascript: prevFocus(this);"
	                onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);">
              </td>
            </tr>
            <tr>
              <td COLSPAN=2>&nbsp; </td>
            </tr>
            <tr>
              <td COLSPAN=2 valign='middle'>
                <p align="left">
                	<s:Button name="Ok" action="javascript:formSubmit()"/>
                	<s:Button name="Alterar Senha" action="javascript:formAlterarSenha()"/>
                </p>
              </td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
      	<td>&nbsp;</td>
      </tr>
      <tr align="center">
      	<td colspan="2"><marquee>Versão: 64.1.0.0 - 7 Digitos ***</marquee><td>
      </tr>
       <tr>
      	<td colspan="2">&nbsp;</td>
      </tr>
      <tr>
      	<td colspan="2" class="textoDestaqueTitulo" valign="center" align="middle">
      	Atenção!Esta aplicação deve ser acessada utilizando o Internet Explorer. Obrigado!
      	</td>
      </tr>
    </table>
	</s:FormStrategy>
	<script language="JavaScript">
	    function inicia() {
	        setFirstFieldFocus();
	    }
	    function formSubmit() {
        if (validaSubmit()) {
			   	//document.frmMain.ias_auth_url_pattern.value = "/SigcbLogin";
	        document.frmMain.submit();
        }
			}
			function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.j_username, 'Usuário')){
				  return false;
		    }
		    if(!validaCampoObrigatorio(document.frmMain.j_password, 'Senha')) {
				  return false;
		    }
		    return true;
		  }
			function formAlterarSenha() {
			  //top.window.location.replace('http://sisus.caixa')
				var valorAltura = 500;
				var valorLargura = 795;
				var valorTopo = (screen.height - valorAltura) /2;
				var valorEsquerda = (screen.width - valorLargura) /2;
		    window.open('http://sisus.caixa',
		    						'sisus',
		    						'width=' +valorLargura+ ', height=' +valorAltura+ ', top=' +valorTopo+ ', left=' +valorEsquerda+ ', menubar=no, scrollbars=no');
			}
	</script>
</p:Document>
</html>