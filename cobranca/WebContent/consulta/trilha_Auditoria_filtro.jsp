

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TrilhaAuditoriaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TrilhaAuditoriaEstrategia"%>

<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(TrilhaAuditoriaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TrilhaAuditoriaEstrategia.CEDENTE_CABECALHO_BEAN));
TrilhaAuditoriaBean liquidacaoOnline = (session.getAttribute(TrilhaAuditoriaEstrategia.FILTRO_BEAN)==null?new TrilhaAuditoriaBean():(TrilhaAuditoriaBean)session.getAttribute(TrilhaAuditoriaEstrategia.FILTRO_BEAN));	

	//Long filtroSelecao = tituloBean.getFiltroSelecao()==null?new Long(1):tituloBean.getFiltroSelecao();
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TrilhaAuditoriaEstrategia.STRATEGY_LISTAR%>"  
		fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TrilhaAuditoriaEstrategia.PAGE_TITLE_MANTER_FILTRO%>"/>

		<input type="hidden" name = "nossoNumero" value="0">
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
               <td class="textoTitulo" width="17%">Cedente: </td>
               <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" 
              	 name="codigoCedente" size="7" maxlength="7"
 				 value='<%=liquidacaoOnline.getCodigoCedente().equals(new Long(0))?"":liquidacaoOnline.getCodigoCedente().toString()%>'
        		 onFocus="javascript: prevFocus(this);"/> 
				</td>
				<td class="textoTitulo" width="17%">&nbsp;</td>
               <td class="textoValor" width="26%">&nbsp;</td>

			</tr>
			
			
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			
	          <tr>
	            <td align="right" colspan="4">
	              <p align="center"> 
 		            	<s:Button name="Ok" action="javascript:formSubmit()"/>
	              </p>
	            </td>
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

   	    	document.frmMain.submit();
		}
	    

			
    </script>
  </s:FormStrategy>
</p:Document></html>
