
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.PrivilegioUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<% 
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute("usuarioLdap");

	CedenteGeralBean cedBean = (CedenteGeralBean)session.getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN);
	
	String tipoCobranca = Util.toStr(CedenteEstrategia.COBRANCA_CONVENCIONAL); // Padrao 2 - Convencional


%>

<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteIncluirExpressoExecutar" fluxo="normal">   	          				
   		<s:Menu/>
   		<s:Titulo name="Incluir Cedente Expresso"/>
		<input type="hidden" name="nuCOCLI" value="<%=cedBean.getCodigoClienteCOCLI()%>"/>
		<input type="hidden" name="van" value="20"/>
		<input type="hidden" name="codConnect" value="99"/>
		<input type="hidden" name="codInternet" value="99"/>
		
	    <table width="777" border="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
	          
	          	<tr>
		            <td class="textoDestaqueTitulo" width="17%">Guia Geral</td>
	            </tr>
	            
	            <tr>
		            <td class="textoTitulo" width="17%">Tipo de Cobrança:</td>
					<td class="textoValor" width="26%">
					    <select name="tipoCobranca" 	onChange="javascript:liberaGuiaEletronica();" >
						  <option value="1">Eletrônica</option>
						  <option value="2">Convencional</option>
						</select>
					</td>
					<td class="textoTitulo" width="17%">Pv de Vinculação:</td>
					<td class="textoValor" width="26%"><p:InputNumerico	CLASS="inputtext" name="nuPv" value="<%=Util.toStr(cedBean.getCodigoUnidadePVVinc()) %>" size="5" maxlength="4" readonly="true" /></td>
				</tr>
				
	            <tr> 
	              <td colspan="4">&nbsp;</td>
	            </tr>
	            
	            <tr>
		            <td class="textoDestaqueTitulo" width="17%">Guia Contas Débito/Crédito</td>
	            </tr>
	            <tr>
                      	<td class="textoTitulo" width="17%">Conta Crédito: </td>
				              <td width="26%" nowrap> 
        				        <p:InputNumerico CLASS="inputtext" name="agContaCred" size="4" maxlength="4" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.opContaCred);"/>
        				        <p:InputNumerico CLASS="inputtext" name="opContaCred" size="3" maxlength="3" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nuContaCred);"/>
        				        <p:InputNumerico CLASS="inputtext" name="nuContaCred" size="10" maxlength="8" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dvContaCred);"/>
        				        <p:InputNumerico CLASS="inputtext" name="dvContaCred" size="1" maxlength="1" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.agContaDeb);"/>
				              </td>
				</tr>
				
				<tr>
                     	 <td class="textoTitulo" width="17%">Conta Débito: </td>
				              <td width="26%" nowrap> 
        				        <p:InputNumerico CLASS="inputtext" name="agContaDeb" size="4" maxlength="4" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.opContaDeb);"/>
        				        <p:InputNumerico CLASS="inputtext" name="opContaDeb" size="3" maxlength="3" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nuContaDeb);"/>
        				        <p:InputNumerico CLASS="inputtext" name="nuContaDeb" size="10" maxlength="8" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dvContaDeb);"/>
        				        <p:InputNumerico CLASS="inputtext" name="dvContaDeb" size="1" maxlength="1" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.tipoAplicativo);"/>
				              </td>
				</tr>
				
					            
	            <tr> 
	              <td colspan="4">&nbsp;</td>
	            </tr>
	            
	            <tr>
		            <td class="textoDestaqueTitulo" width="17%">Guia Beneficiário Eletrônico</td>
	            </tr>
	             <tr>
                      <td class="textoTitulo" width="17%">Aplicativo: </td>
                      <td class="textoValor" width="26%">
                       	 <s:ComboTipoAplicativo name="tpAplicativo" selectedValue="4"/>
                      </td>
                      <td class="textoTitulo" width="17%">Padrão de Arquivo: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboPadraoArquivo name="icPadrao" />
                      </td> 
				 </tr>
				 
				 <tr>
				 	<td class="textoTitulo" width="17%">Modo de Transmissão: </td>
                      <td class="textoValor" width="26%">
                      	<select name="icAmbiente">
						  <option value="T">TESTE</option>
						  <option value="P">PRODUÇÃO</option>
						</select>
                      </td>
				 </tr>

	             <tr>
	             		  <td class="textoTitulo" width="17%">Tipo de Transmissão: </td>
	              	 
	                      <td class="textoValor" width="26%">
	                        <!-- <s:ComboTipoTransmissao name="tpTransmissao"  selectedValue="5" onChange="javascript:mudaComboTipoTransmissao();" />-->
	                        <select name="tpTransmissao"  onChange="javascript:mudaComboTipoTransmissao();">
						  		<option value="4">E-COBRANCA</option>
						  		<option value="5" selected="selected">INTERNET</option>
							</select>
	                      </td>
	                      
                  
	                 
				 </tr>
				 
				
	            
	            <tr>
	              <td colspan="4">&nbsp;</td>
	            </tr>
	            <tr> 
	              <td colspan="4">
	                <p align="center"> 
						<s:Button name="Ok" action="javascript:formSubmit()"/>
						<s:Button name="Cancelar" action="javascript:cancelar()"/>
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
				liberaGuiaEletronica();
				//document.frmMain.van.disabled = true;
			}
					
			function formSubmit(){
				document.frmMain.submit();
			}
			
			function cancelar(){
				document.frmMain.estrategia.value="cedente.CedenteIncluirIniciar";
				document.frmMain.submit();
			}
			
			function liberaGuiaEletronica(){
				if (document.frmMain.tipoCobranca.value=="1"){
					document.frmMain.tpAplicativo.disabled = false;
					document.frmMain.icPadrao.disabled = false;
					document.frmMain.icAmbiente.disabled = false;
					document.frmMain.tpTransmissao.disabled = false;
					document.frmMain.van.disabled = false;
					document.frmMain.codConnect.disabled = false;
					document.frmMain.codInternet.disabled = false;
					mudaComboTipoTransmissao();
					document.frmMain.codInternet.value=20;
				}else{
					document.frmMain.tpAplicativo.disabled = true;
					document.frmMain.icPadrao.disabled = true;
					document.frmMain.icAmbiente.disabled = true;
					document.frmMain.tpTransmissao.disabled = true;
					document.frmMain.van.disabled = true;
					document.frmMain.codConnect.disabled = true;
					document.frmMain.codInternet.disabled = true;
					
					
				}
			}
			
		    function mudaComboTipoTransmissao() {
		    	
		    	if (document.frmMain.tpTransmissao.value == "1") { // 1 - EDI/VAN
		    		
		    		document.frmMain.van.disabled = false;
		    		document.frmMain.codConnect.value=99;
		    		document.frmMain.codConnect.disabled = true
		    		document.frmMain.codInternet.value=99;
		    		document.frmMain.codInternet.disabled = true;
		    	} else if(document.frmMain.tpTransmissao.value == "3") {
		    		
		    		document.frmMain.van.value = 99;
		    		document.frmMain.van.disabled = true;
		    		document.frmMain.codConnect.value=99;
		    		document.frmMain.codConnect.disabled = false;
		    		document.frmMain.codInternet.value=99;
		    		document.frmMain.codInternet.disabled = true;
		    	} else if(document.frmMain.tpTransmissao.value == "5") {
		    		
		    		document.frmMain.van.value = 99;
		    		document.frmMain.van.disabled = true;
		    		document.frmMain.codConnect.value=99;
		    		document.frmMain.codConnect.disabled = true;
		    		document.frmMain.codInternet.value=20;
		    		document.frmMain.codInternet.disabled = false;
		    		
		    	}else {
		    		document.frmMain.van.value = 99;
		    		document.frmMain.van.disabled = true;
		    		document.frmMain.codConnect.value = 99;
		    		document.frmMain.codConnect.disabled = true;
		    		document.frmMain.codInternet.value=99;
		    		document.frmMain.codInternet.disabled = true;
		    	}
		    }
		    
		    
		    function mudaComboTipoTransmissaoPV() {
		    	
		    	if (document.frmMain.tpTransmissao.value == "1") { // 1 - EDI/VAN
		    		
		    		document.frmMain.van.disabled = false;
		    		document.frmMain.codConnect.value=99;
		    		document.frmMain.codConnect.disabled = true
	    			document.frmMain.codInternet.value = 99;
	    			document.frmMain.codInternet.disabled = true;
	    			
		    	} else if(document.frmMain.tpTransmissao.value == "3") {
		    		alert("Connect não é permitido para este perfil!");
		    		document.frmMain.tpTransmissao.value = "1";
		    		document.frmMain.codConnect.value=99;
		    		document.frmMain.codConnect.disabled = true
	    			document.frmMain.codInternet.value = 99;
	    			document.frmMain.codInternet.disabled = true;
		    		
		    	} else if(document.frmMain.tpTransmissao.value == "5") {
			    		
			    		document.frmMain.van.value = 99;
			    		document.frmMain.van.disabled = true;
			    		document.frmMain.codConnect.value=99;
			    		document.frmMain.codConnect.disabled = true;
			    		document.frmMain.codInternet.value=20;
			    		document.frmMain.codInternet.disabled = false;	
		    	}else {
		    		document.frmMain.van.value = 99;
		    		document.frmMain.van.disabled = true;
		    		document.frmMain.codConnect.value = 99;
		    		document.frmMain.codConnect.disabled = true;
	    			document.frmMain.codInternet.value = 99;
	    			document.frmMain.codInternet.disabled = true;
		    	}
		    }
			

			</script>
			
		</s:FormStrategy>
	</p:Document>
</html>
