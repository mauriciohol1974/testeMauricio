
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePECBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.CedenteMasterPECEstrategia"%>


<%
	CedentePECBean cedentePECBean = (session.getAttribute(CedenteMasterPECEstrategia.FILTRO_BEAN)==null?new CedentePECBean():(CedentePECBean)session.getAttribute(CedenteMasterPECEstrategia.FILTRO_BEAN));
	cedentePECBean.setCodigoCedente(session.getAttribute(CedenteMasterPECEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(CedenteMasterPECEstrategia.CEDENTE_ATUAL));
	
	InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean)session.getAttribute(CedenteMasterPECEstrategia.USUARIOLDAP_BEAN);
	
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia='<%=CedenteMasterPECEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
		<s:Menu/>
		<s:Titulo name='<%=CedenteMasterPECEstrategia.PAGE_TITLE_FILTRO%>'/>
		<input type="hidden" name="voltar" value="">
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Cedente Master PEC: </td>
              <td width="26%"> 
              	<p:InputNumerico CLASS="inputtext" 
              	 name="codigoCedente" size="7" maxlength="7"
 								 value='<%=cedentePECBean.getCodigoCedente().equals(new Long(0))?"":cedentePECBean.getCodigoCedente().toString()%>'
								onFocus="javascript: prevFocus(this);"
								onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">
                <p align="center"> 
                	<s:Button name="Ok" action="javascript:formSubmit()"/>
                </p>
              </td>
            </tr>
          </table>
        </TD>
      </tr>
    </table>
    <script>
      function inicia() {
				setFirstFieldFocus();      
      }
      
      function formSubmit() {
    	    if (document.frmMain.codigoCedente.value==""){
    	    	document.frmMain.voltar.value = "L";	
    	    }else{
    	    	document.frmMain.voltar.value = "M";
    	    }
      		document.frmMain.submit();
      	
      }
      
			function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.codigoCedente, "Cedente")) {
				  return false;
		    }
				return true;
			}      
      
    </script>
  </s:FormStrategy>
</p:Document>
</html>
