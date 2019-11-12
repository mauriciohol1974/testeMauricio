<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: perinte_sucesso.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 05/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.PerInteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.PerfilInternetBean"%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(PerInteEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setStrategyErrorReturn(msgBean.getStrategyErrorReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(PerInteEstrategia.MSG_BEAN);
	}
	msgBean.setMsgError(request.getAttribute("msgError")==null?(String)request.getAttribute("javax.servlet.error.message"):(String) request.getAttribute("msgError"));
	PerfilInternetBean perfilInternetBean = (session.getAttribute(PerInteEstrategia.FILTRO_BEAN)==null?new PerfilInternetBean():(PerfilInternetBean)session.getAttribute(PerInteEstrategia.FILTRO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
	estrategia="<%=msgBean.getStrategySucessReturn()%>" fluxo="voltar">
	<s:Menu/>
	<s:Titulo name="<%=msgBean.getTitlePage()%>"/>    
	
	<input type="hidden" name = "consultaUnidade" value="">
	
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="center"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 align="center">
            <tr>
              <td class="textoTitulo" width="17%">Perfil: </td>
              <td class="textoValor" width="26%"><%=perfilInternetBean.getCodigoPerfil()%></td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
          </table>
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 align="center">
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">
                <hr>
              </td>
            </tr>
	          <tr> 
	            <td colspan="4" align="center">
	            	<h3 style= "TEXT-ALIGN:center"><%=msgBean.getMsgSucess()%></h3>
	            </td>
	          </tr>
            <tr>
              <td colspan="2">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="2">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">
                <p align="center"> 
                  <s:Button name="Ok" action="javascript:formSubmit()"/>
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
	        	document.frmMain.fluxo.value = "voltar";
  		       	document.frmMain.submit();
	        }
	    }
		function validaSubmit() {
		    return true;
		}			
    </script>
  </s:FormStrategy>
</p:Document>
</html> 