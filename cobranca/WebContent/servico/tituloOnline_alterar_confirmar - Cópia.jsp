

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloOnLineEstrategia"%>


<%
	TituloBean tituloBean = (session.getAttribute(TituloOnLineEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(TituloOnLineEstrategia.DATA_BEAN));	

%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=TituloOnLineEstrategia.STRATEGY_ALTERAR_CONFIRMAR%>' fluxo="normal">
				
	<s:Menu/>
		<s:Titulo name='<%=TituloOnLineEstrategia.PAGE_TITLE_MANTER_ALTERAR%>'/>
	<input type="hidden" name="tipoAcao" value="<%= tituloBean.getTipoAcao() %>" />
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%">
                		<p:InputNumerico name="codigoCedente" maxlength="7" size="7" 
	                	CLASS="inputtext" value='<%=tituloBean.getCodigoCedente().equals( new Long(0))?"":tituloBean.getCodigoCedente().toString()%>' 
	                	disabled="true"
	                	onFocus="javascript: prevFocus(this);"
						onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumero);"/>
              
              </td>
            </tr>
            <tr>
               	<td class="textoTitulo" width="17%">Nosso Número: </td>
				              <td class="textoValor" width="26%" nowrap> 
				              		<p:InputNumerico name="nossoNumeroLiq" maxlength="15" size="23"  
				                	value='<%=tituloBean.getNossoNumeroLiq().equals(new Long(0))?"":tituloBean.getNossoNumeroLiq().toString()%>'  
				                	CLASS="inputtext"
				                	disabled="true"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiDataVencimento);"/>
                </td>
                <td nowrap class="textoTitulo" width="17%">Data de Vencimento: </td>
				              <td class="textoValor" width="26%" nowrap> 
        				        <p:InputDate name="princiDataVencimento" 
        				        	value ='<%=tituloBean.getPrinciDataVencimentoFormatada()%>'
               						CLASS="inputtext"
               						disabled="true"
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.liquiValorDocumento);"/> 
                 </td>
            </tr>
            <tr>
             	<td nowrap class="textoTitulo" width="17%">Valor do Documento: </td>
				              <td class="textoValor" width="26%" nowrap> 
        				        <p:InputCurrency name="liquiValorDocumento" maxlength="15" size="27" 
               						value='<%=tituloBean.getLiquiValorDocumento().toString().equals("R$ 0,00")?"":tituloBean.getLiquiValorDocumento().toString()%>' 
               						CLASS="inputtext"
               						disabled="true"
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.fatorVencimento);"/> 
                 </td>
                 <td nowrap class="textoTitulo" width="17%">Fator de Vencimento: </td>
				 <td class="textoValor" width="26%" nowrap>
				 		<p:InputNumerico name="fatorVencimento" maxlength="6" size="7" 
	                	CLASS="inputtext" value='<%=tituloBean.getFatorVencimento().equals( new Long(0))?"":tituloBean.getFatorVencimento().toString()%>' 
	                	onFocus="javascript: prevFocus(this);"
	                	disabled="true"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumero);"/>
				 </td> 
            </tr>
            
            <tr>
            	   <td class="textoTitulo" width="17%">Meio de Entrada: </td>
                   <td class="textoValor" width="26%">
                    	<s:ComboMeioEntrada disabled="true" name="meio" selectedValue='<%=tituloBean.getMeio().equals(new Long(0))?"1":tituloBean.getMeio().toString()%>'/>
                   </td>
                   <td class="textoTitulo" width="17%">Forma de Pagamento: </td>
                   <td class="textoValor" width="26%">
                    	<s:ComboFormaPagamento  disabled="true"name="formaPagamento" selectedValue='<%=tituloBean.getFormaPagamento().equals(new Long(0))?"1":tituloBean.getFormaPagamento().toString()%>'/>
                   </td>
                   
            </tr>
           
			<tr>
				      <td nowrap class="textoTitulo" width="17%">Data do Pagamento: </td>
				      <td class="textoValor" width="26%" nowrap> 
        				       <p:InputDate name="liquiDataPagamento" 
        				       	value ='<%=tituloBean.getLiquiDataPagamentoFormatada()%>'
               					CLASS="inputtext"
               					disabled="true"
               					onFocus="javascript: prevFocus(this);"
								onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nsu);"/> 
								
 					  <td nowrap class="textoTitulo" width="17%">NSU: </td>
				      <td class="textoValor" width="26%" nowrap> 
        				       <p:InputNumerico name="nsu" maxlength="9" size="12" 
	                				CLASS="inputtext" value='<%=tituloBean.getNsu().equals(new Long(0))?"":tituloBean.getNsu().toString()%>' 
	                				disabled="true"
	                				onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.liquiValorLiquidoRecebido);"/>
					 </td>							
                
			
			</tr>
			
			<tr>
			
				      <td nowrap class="textoTitulo" width="17%">Valor Recebido: </td>
				      <td class="textoValor" width="26%" nowrap> 
        				        <p:InputCurrency name="liquiValorLiquidoRecebido" maxlength="15" size="27" 
               						value='<%=tituloBean.getLiquiValorLiquidoRecebido().toString().equals("R$ 0,00")?"":tituloBean.getLiquiValorLiquidoRecebido().toString()%>' 
               						CLASS="inputtext"
               						disabled="true"
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.fatorVencimento);"/> 
                 </td>
			</tr>  
			
			<tr>
			
				      <td nowrap class="textoTitulo" width="17%">Linha Digitável:</td>
				      <td class="textoValor" width="26%" nowrap colspan="3"> 
        				       	<p:InputAlfanumerico  name="codBarras1" maxlength="10" size="12"  
				                	value='<%=tituloBean.getCodBarras1().equals(new Long(0))?"":tituloBean.getCodBarras1().toString()%>'  
				                	CLASS="inputtext"
				                	disabled="true"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codBarras2);"
				                	onBlur="javascript:habilitaCamposCedente();"/>
        				       	<p:InputAlfanumerico  name="codBarras2" maxlength="11" size="13"  
				                	value='<%=tituloBean.getCodBarras2().equals(new Long(0))?"":tituloBean.getCodBarras2().toString()%>'  
				                	CLASS="inputtext"
				                	disabled="true"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codBarras3);"/>
        				       	<p:InputAlfanumerico  name="codBarras3" maxlength="11" size="13"  
				                	value='<%=tituloBean.getCodBarras3().equals(new Long(0))?"":tituloBean.getCodBarras3().toString()%>'  
				                	CLASS="inputtext"
				                	disabled="true"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codBarras4);"/>
        				       	<p:InputAlfanumerico  name="codBarras4" maxlength="1" size="2"  
				                	value='<%=tituloBean.getCodBarras4().equals(new Long(0))?"":tituloBean.getCodBarras4().toString()%>'  
				                	CLASS="inputtext"
				                	disabled="true"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codBarras5);"/>
        				       	<p:InputAlfanumerico  name="codBarras5" maxlength="14" size="17"  
				                	value='<%=tituloBean.getCodBarras5().equals(new Long(0))?"":tituloBean.getCodBarras5().toString()%>'  
				                	CLASS="inputtext"
				                	disabled="true"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.motivoID);"/>
				                	
				                	
                 </td>
			</tr> 
			
			<tr>
			       <td class="textoTitulo" width="17%">Motivo:</td>
                   <td class="textoValor" width="26%" colspan="3">
                    	<p:InputAlfanumerico CLASS="inputtext" name="motivo" value="<%=tituloBean.getMotivo()%>" disabled="true" maxlength="80" size="30"/>
                   </td>
			</tr>	
			
			<tr>
				 <td class="textoTitulo" width="17%">Observações:</td>
                   <td class="textoValor" width="26%" colspan="3">
                    <textarea name="observacoes" cols="51" rows="4" class="textoValor" readonly><%=tituloBean.getObservacoes()%></textarea>	
                   </td>
			
			</tr>	
			
			<tr>
				      <td nowrap class="textoTitulo" width="17%">Data Situação: </td>
				      <td class="textoValor" width="26%" nowrap> 
        				       <%=tituloBean.getDtGarantia()%> 
 					  <td nowrap class="textoTitulo" width="17%">Descrição Situação: </td>
				      <td class="textoValor" width="26%" nowrap> <%=tituloBean.getDescrSituacao()%>
					 </td>							
                
			
			</tr>
			
			<tr>
				      <td nowrap class="textoTitulo" width="17%">Usuário: </td>
				      <td class="textoValor" width="26%" nowrap> 
        				       <%=tituloBean.getCoUsuario()%> 
 					  <td nowrap class="textoTitulo" width="17%">Erro: </td>
				      <td class="textoValor" width="26%" nowrap> <%=tituloBean.getCoErro()%>&nbsp;<%=tituloBean.getDeErro() %>
					 </td>							
                
			
			</tr>	   	         
           
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr> 
              <td colspan="4" align="center"><h4>Confirma Alteração?</h4></td>
            </tr>
            
            <tr>
            	<td colspan="4" align="center">
            	  <s:Button name="Ok" action="javascript:formSubmit();"/>
                  <s:Button name="Cancelar" action="javascript:limpar();"/>
            	</td>
            </tr>
            
          </table>
          </td>
         </tr>
      		

          </table>

    <script>
    function inicia(){
				setFirstFieldFocus();
      }
      
		function formSubmit() {
			if(validaSubmit()){
		  	document.frmMain.submit();
			}
		}
			
			
			
			function limpar() {
				document.frmMain.fluxo.value = "voltar";
				document.frmMain.estrategia.value="servico.TituloOnLineAlterar"
			  	document.frmMain.submit();
  			}  
			
		function validaSubmit() {
			
			
		
			return true;
		}
		
    </script>
  </s:FormStrategy>
</p:Document>
</html>
