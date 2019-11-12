<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: perinte_alterar.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 08/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.PerfilInternetBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.PerInteEstrategia"%>

<%
	PerfilInternetBean perfilInternetBean = (session.getAttribute(PerInteEstrategia.DATA_BEAN)==null?new PerfilInternetBean():(PerfilInternetBean)session.getAttribute(PerInteEstrategia.DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=PerInteEstrategia.STRATEGY_ALTERAR_FINALIZAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=PerInteEstrategia.PAGE_TITLE_ALTERAR%>"/>
		
		<input type="hidden" name = "codigoPerfil" value="<%=perfilInternetBean.getCodigoPerfil()%>">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 align="center">
            <tr>
              <td class="textoTitulo" width="17%">Perfil: </td>
              <td class="textoValor" width="26%"><%=perfilInternetBean.getCodigoPerfil()%></td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Alterar Perfil Internet
                <hr>
              </td>
            </tr>
            
            <tr>
				<td class="textoTitulo" width="17%">Descrição: </td>
				<td class="textoValor" nowrap width="26%"> 
                <p:InputAlfanumerico name="descricaoPerfil" maxlength="80" size="40" 
                	value="<%=perfilInternetBean.getDescricaoPerfil()%>" CLASS="inputtext"
                	onFocus="javascript: prevFocus(this);"
					onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.servicoPerfil);"/>
				</td>
				<td class="textoTitulo" width="17%">Serviço:</td>
				<td class="textoTitulo" width="26%">
                <p:InputAlfanumerico name="servicoPerfil" maxlength="1" size="4" 
                	value="<%=perfilInternetBean.getServicoPerfil()%>" CLASS="inputtext"
                	onFocus="javascript: prevFocus(this);"
					onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>				
				</td>
			</tr>
			<tr> 
				<td colspan="4">&nbsp;</td>
			</tr>
            <tr>
	            <td align="right" colspan="4">
		        	<p align="center">
		            	<s:Button name="Confirmar" action="javascript:formSubmit()"/>
		            	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
	              </p>
	            </td>
	          </tr>
 	          <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>
	        </table>
        </td>
      </tr>
    </table>
    <script>
		function inicia() {
			setFirstFieldFocus();
		}
	    function formSubmit() {
	        if (validaSubmit()) {
		    	if (confirm(conf("101", "Perfil Internet"))) {
			    document.frmMain.submit();
			    }
	        }
	    }
		function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.descricaoPerfil, 'Descrição Perfil')){
				  return false;
		    }
		    if(!validaCampoObrigatorio(document.frmMain.servicoPerfil, 'Serviço Perfil')){
				  return false;
		    }		    
		    return true;
		}
	    function formSubmit_Voltar() {
    		if (confirm(conf("103"))) {
	           document.frmMain.estrategia.value = "<%=PerInteEstrategia.STRATEGY_MANTER_LISTAR%>";
	           document.frmMain.fluxo.value = "voltar";
	           document.frmMain.submit();
	        }
      	}  
    </script>
  </s:FormStrategy>
</p:Document>
</html>