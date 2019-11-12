
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.CepBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.ConsultaCEPEstrategia"%>

<%
	
CepBean cep = (session.getAttribute(ConsultaCEPEstrategia.FILTRO_BEAN)==null?new CepBean():(CepBean)session.getAttribute(ConsultaCEPEstrategia.FILTRO_BEAN));	

	//Long filtroSelecao = tituloBean.getFiltroSelecao()==null?new Long(1):tituloBean.getFiltroSelecao();
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ConsultaCEPEstrategia.STRATEGY_CONSULTAR%>"  
		fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Consultar/Validar CEP >> Filtro"/>

		
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
               <td class="textoTitulo" width="17%">CEP: </td>
               <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" 
              	 name="cep" size="8" maxlength="8"
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
	    	 var form = document.frmMain;
   			 if(!validaCampoObrigatorio(form.cep, 'CEP')) {
   				return false;
   			 }else{
   				document.frmMain.submit();	 
   			 }

   	    	
		}
	    

			
    </script>
  </s:FormStrategy>
</p:Document></html>
