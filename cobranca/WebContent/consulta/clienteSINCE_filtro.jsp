<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>


<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ClienteSINCEEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ClienteSINCEBean "%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	ClienteSINCEBean clienteSINCE = (session.getAttribute(ClienteSINCEEstrategia.BEAN_FILTRO)==null? new ClienteSINCEBean():(ClienteSINCEBean)session.getAttribute(ClienteSINCEEstrategia.BEAN_FILTRO));
																			
	
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=ClienteSINCEEstrategia.STRATEGY_FILTRO%>" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=ClienteSINCEEstrategia.PAGE_TITLE_FILTRO%>"/>

		<input type="hidden" name="tpconsulta" 	value="1">
		<input type="hidden" name="codcedente" 	value="">
		<input type="hidden" name="codsince" 	value="">
		<input type="hidden" name="codPV" 	    value="">
		<input type="hidden" name="codSR" 	    value="">
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Filtro:
                <hr>
              </td>
            </tr>


						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rdConsulta" onclick="javascript:habilitaDigitacao();">
              </td>
              <td class="textoTitulo" width="17%">Caixa </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
						</tr>
						
												<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rdConsulta" onclick="javascript:habilitaDigitacao();">
              </td>
              <td class="textoTitulo" width="17%">PV </td>
              <td class="textoValor" width="26%"><p:InputNumerico name="codigoPV" disabled="true" maxlength="4" size="5" CLASS="inputtext" value=""/></td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
						</tr>
						
												<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rdConsulta" onclick="javascript:habilitaDigitacao();">
              </td>
              <td class="textoTitulo" width="17%">SR </td>
              <td class="textoValor" width="26%"><p:InputNumerico name="codigoSR" disabled="true" maxlength="4" size="5" CLASS="inputtext" value=""/></td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
						</tr>
						

            <tr> 
              <td class="textoTitulo" width="2%">&nbsp;</td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
            </tr>

			<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rdConsulta" onclick="javascript:habilitaDigitacao();">
              </td>
              <td class="textoTitulo" width="17%">Código Cedente: </td>
              <td class="textoValor" width="26%"> 
                <p:InputNumerico name="codigoCedente" disabled="true" maxlength="7" size="7" CLASS="inputtext" value=""/>
              </td>
             	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
						</tr>
						
			<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rdConsulta" onclick="javascript:habilitaDigitacao();">
              </td>
              <td class="textoTitulo" width="17%">Código SINCE: </td>
              <td class="textoValor" width="26%"> 
                <p:InputNumerico name="codigoSINCE" disabled="true" maxlength="9" size="11" CLASS="inputtext" value=""/>
              </td>
             	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
						</tr>


            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>


            <tr>
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="5">
                <p align="center"> 
                	<s:Button name="Ok" action="javascript:formSubmit();"/>
                </p>
              </td>
            </tr>
          </table>
        </TD>
      </tr>
    </table>
     <script>

    
			function formSubmit(){

				

				    document.frmMain.codcedente.value = document.frmMain.codigoCedente.value ;
				    document.frmMain.codsince.value = document.frmMain.codigoSINCE.value ; 
				    document.frmMain.codPV.value = document.frmMain.codigoPV.value ;
				    document.frmMain.codSR.value = document.frmMain.codigoSR.value ;

				   
					document.frmMain.submit();
				
			}
			
			
			function habilitaDigitacao(){
				if (document.frmMain.rdConsulta[0].checked){
				    

				    document.frmMain.codigoCedente.value = "";
					document.frmMain.codigoSINCE.value = "" ;
					document.frmMain.codigoPV.value = "" ;
				    document.frmMain.codigoSR.value = "" ;

					document.frmMain.codigoPV.disabled = true;
					document.frmMain.codigoSR.disabled = true;
					document.frmMain.codigoCedente.disabled = true;
					document.frmMain.codigoSINCE.disabled = true;

					document.frmMain.tpconsulta.value = 1;
				} else if(document.frmMain.rdConsulta[1].checked){
				

					document.frmMain.codigoCedente.value = "";
					document.frmMain.codigoSINCE.value = "" ;
					document.frmMain.codigoPV.value = "" ;
					document.frmMain.codigoSR.value = "" ;

					document.frmMain.codigoPV.disabled = false;
					document.frmMain.codigoSR.disabled = true;
					document.frmMain.codigoCedente.disabled = true;
					document.frmMain.codigoSINCE.disabled = true;

					document.frmMain.tpconsulta.value = 2;
				} else if(document.frmMain.rdConsulta[2].checked){
				
					document.frmMain.codigoCedente.value = "";
					document.frmMain.codigoSINCE.value = "" ;
					document.frmMain.codigoPV.value = "" ;
					document.frmMain.codigoSR.value = "" ;

					document.frmMain.codigoPV.disabled = true;
					document.frmMain.codigoSR.disabled = false;
					document.frmMain.codigoCedente.disabled = true;
					document.frmMain.codigoSINCE.disabled = true;
					document.frmMain.tpconsulta.value = 3;
				} else if(document.frmMain.rdConsulta[3].checked){
				
					document.frmMain.codigoCedente.value = "";
					document.frmMain.codigoSINCE.value = "" ;
					document.frmMain.codigoPV.value = "" ;
					document.frmMain.codigoSR.value = "" ;

					document.frmMain.codigoPV.disabled = true;
					document.frmMain.codigoSR.disabled = true;
					document.frmMain.codigoCedente.disabled = false;
					document.frmMain.codigoSINCE.disabled = true;
					document.frmMain.tpconsulta.value = 4;
				} else if(document.frmMain.rdConsulta[4].checked){
				
					document.frmMain.codigoCedente.value = "";
					document.frmMain.codigoSINCE.value = "" ;
					document.frmMain.codigoPV.value = "" ;
					document.frmMain.codigoSR.value = "" ;

					document.frmMain.codigoPV.disabled = true;
					document.frmMain.codigoSR.disabled = true;
					document.frmMain.codigoCedente.disabled = true;
					document.frmMain.codigoSINCE.disabled = false;
					document.frmMain.tpconsulta.value = 5;
				}

			}

			
				
			
			
    </script>
 		</s:FormStrategy>
	</p:Document>
</html>