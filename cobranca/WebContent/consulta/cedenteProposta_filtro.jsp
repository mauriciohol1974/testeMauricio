
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePropostaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.CedentePropostasEstrategia"%>


<%
	CedentePropostaBean cedentePropostaBean = (session.getAttribute(CedentePropostasEstrategia.FILTRO_BEAN)==null?new CedentePropostaBean():(CedentePropostaBean)session.getAttribute(CedentePropostasEstrategia.FILTRO_BEAN));
	cedentePropostaBean.setCodigoCedente(session.getAttribute(CedentePropostasEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(CedentePropostasEstrategia.CEDENTE_ATUAL));
	
	InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean)session.getAttribute(CedentePropostasEstrategia.USUARIOLDAP_BEAN);
	
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia='<%=CedentePropostasEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
		<s:Menu/>
		<s:Titulo name='<%=CedentePropostasEstrategia.PAGE_TITLE_FILTRO%>'/>
		<input type="hidden" name="voltar" value="">
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Tipo de Unidade: </td>
	              <td class="textoTitulo" width="26%">
	              	<s:ComboENPV name="TipoConsulta" selectedValue="2" />
	             	&nbsp;
              		<p:InputNumerico CLASS="inputtext" 
              	 	name="unidade" size="7" maxlength="7"
					onFocus="javascript: prevFocus(this);"
					onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
              	  </td>

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
    	  
    	    if(!validaCampoObrigatorio(document.frmMain.unidade,'Unidade')){
				return false;
			}    	  
      		document.frmMain.submit();
      	
      }
      
      
    </script>
  </s:FormStrategy>
</p:Document>
</html>
