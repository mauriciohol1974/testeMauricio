
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TitulosPropostaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TitulosPropostasEstrategia"%>


<%
	TitulosPropostaBean cedentePropostaBean = (session.getAttribute(TitulosPropostasEstrategia.FILTRO_BEAN)==null?new TitulosPropostaBean():(TitulosPropostaBean)session.getAttribute(TitulosPropostasEstrategia.FILTRO_BEAN));
	cedentePropostaBean.setCodigoCedente(session.getAttribute(TitulosPropostasEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(TitulosPropostasEstrategia.CEDENTE_ATUAL));
	
	InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean)session.getAttribute(TitulosPropostasEstrategia.USUARIOLDAP_BEAN);
	
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia='<%=TitulosPropostasEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
		<s:Menu/>
		<s:Titulo name='<%=TitulosPropostasEstrategia.PAGE_TITLE_FILTRO%>'/>
		<input type="hidden" name="voltar" value="">
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Cedente</td>
	             <td class="textoTitulo" width="26%">
              		<p:InputNumerico CLASS="inputtext" 
              	 	name="codigoCedente" size="7" maxlength="7"
					onFocus="javascript: prevFocus(this);"
					onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
              	  </td>
            </tr>
            <tr>
            	<td class="textoTitulo" width="17%">Situação da Adesão:</td>
            	<td class="textoTitulo" width="26%">
            		<select name='situacao' >
            			<option value='T' selected="selected">Todas</option>
            			<option value='S'>Sim</option>
            			<option value='N'>Não</option>
            			<option value='E'>Excluída </option>
            			
            		</select>
            		
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
  	    if(!validaCampoObrigatorio(document.frmMain.codigoCedente,'Cedente')){
			return false;
		}  
    	  
      		document.frmMain.submit();
      	
      }
      
      
    </script>
  </s:FormStrategy>
</p:Document>
</html>
