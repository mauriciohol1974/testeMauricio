<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: lantari_manter_filtro.jsp - Java Server Pages
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 08/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloOnLineEstrategia"%>


<%
	TituloBean tituloBean = (session.getAttribute(TituloOnLineEstrategia.FILTRO_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(TituloOnLineEstrategia.FILTRO_BEAN));	
	
	CedenteCabecaBean cedCabBean = (session.getAttribute(TituloOnLineEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TituloOnLineEstrategia.CEDENTE_CABECALHO_BEAN));
	
	if (tituloBean.getMotivo().equals("MOEDA INVALIDA")){
		tituloBean.setMotivo("1");
	}else if(tituloBean.getMotivo().equals("DIVERGENCIA NO VALOR RECEBIDO")){
		tituloBean.setMotivo("2");
	}else if(tituloBean.getMotivo().equals("RECEBIMENTO EFETUADO FORA DO PRAZO")){
		tituloBean.setMotivo("3");
	}else if(tituloBean.getMotivo().equals("APRESENTACAO INDEVIDA")){
		tituloBean.setMotivo("4");
	}else if(tituloBean.getMotivo().equals("REGISTRO INCONSITENTE")){
		tituloBean.setMotivo("5");
	}else if(tituloBean.getMotivo().equals("DEVOLUCAO DE CHEQUE PELA COMPENSACAO")){
		tituloBean.setMotivo("6");
	}else if(tituloBean.getMotivo().equals("DUPLICIDADE DE MOVIMENTO")){
		tituloBean.setMotivo("7");
	}else if(tituloBean.getMotivo().equals("ERRO OPERACIONAL")){
		tituloBean.setMotivo("8");
	}else if(tituloBean.getMotivo().equals("ESTORNO INDEVIDO")){
		tituloBean.setMotivo("9");
	}else if(tituloBean.getMotivo().equals("OUTROS")){
		tituloBean.setMotivo("10");		
	}else{
		tituloBean.setMotivo("1");
	}
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=TituloOnLineEstrategia.STRATEGY_MANTER_ACAO_INCLUIR_EXECUTAR%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='<%=TituloOnLineEstrategia.PAGE_TITLE_INCLUIR%>'/>
	
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%">
                		<p:InputNumerico name="codigoCedente" maxlength="7" size="7" 
	                	CLASS="inputtext" value='<%=tituloBean.getCodigoCedente().equals( new Long(0))?"":tituloBean.getCodigoCedente().toString()%>' 
	                	onFocus="javascript: prevFocus(this);"
						onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumero);"
						onBlur="javascript:habilitaCamposCedente();"/>
              
              </td>
            </tr>
            <tr>
               	<td class="textoTitulo" width="17%">Nosso Número: </td>
				              <td class="textoValor" width="26%" nowrap> 
				              		<p:InputNumerico name="nossoNumeroLiq" maxlength="18" size="23"  
				                	value='<%=tituloBean.getNossoNumeroLiq().equals(new Long(0))?"":tituloBean.getNossoNumeroLiq().toString()%>'  
				                	CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiDataVencimento);"/>
                </td>
                <td nowrap class="textoTitulo" width="17%">Data de Vencimento: </td>
				              <td class="textoValor" width="26%" nowrap> 
        				        <p:InputDate name="princiDataVencimento" 
        				        	value ='<%=tituloBean.getPrinciDataVencimentoFormatada()%>'
               						CLASS="inputtext"
               						onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.liquiValorDocumento);"
									onBlur="javascript:habilitaData();"/> 
                 </td>
            </tr>
            <tr>
             	<td nowrap class="textoTitulo" width="17%">Valor do Documento: </td>
				              <td class="textoValor" width="26%" nowrap> 
        				        <p:InputCurrency name="liquiValorDocumento" maxlength="15" size="27" 
               						value='<%=tituloBean.getLiquiValorDocumento().toString().equals("R$ 0,00")?"":tituloBean.getLiquiValorDocumento().toString()%>' 
               						CLASS="inputtext"
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.fatorVencimento);"/> 
                 </td>
                 <td nowrap class="textoTitulo" width="17%">Fator de Vencimento: </td>
				 <td class="textoValor" width="26%" nowrap>
				 		<p:InputNumerico name="fatorVencimento" maxlength="4" size="6" 
	                	CLASS="inputtext" value='<%=tituloBean.getFatorVencimento().equals(new Long(0))?"":tituloBean.getFatorVencimento().toString()%>' 
	                	onFocus="javascript: prevFocus(this);"
						onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumero);"
						onBlur="javascript:habilitaData();"/>
				 </td> 
            </tr>
            
            <tr>
            	   <td class="textoTitulo" width="17%">Meio de Entrada: </td>
                   <td class="textoValor" width="26%">
                    	<s:ComboMeioEntrada name="meio" selectedValue='<%=tituloBean.getMeio().equals(new Long(0))?"1":tituloBean.getMeio().toString()%>'
                    	/>
                   </td>
                   <td class="textoTitulo" width="17%">Forma de Pagamento: </td>
                   <td class="textoValor" width="26%">
                    	<s:ComboFormaPagamento name="formaPagamento" selectedValue='<%=tituloBean.getFormaPagamento().equals(new Long(0))?"1":tituloBean.getFormaPagamento().toString()%>'
                    	/>
                   </td>
                   
            </tr>
           
			<tr>
				      <td nowrap class="textoTitulo" width="17%">Data do pagamento: </td>
				      <td class="textoValor" width="26%" nowrap> 
        				       <p:InputDate name="liquiDataPagamento" 
        				       	value ='<%=tituloBean.getLiquiDataPagamentoFormatada()%>'
               					CLASS="inputtext"
               					onFocus="javascript: prevFocus(this);"
								onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nsu);"/> 
								
 					  <td nowrap class="textoTitulo" width="17%">NSU: </td>
				      <td class="textoValor" width="26%" nowrap> 
        				     <p:InputNumerico name="nsu" maxlength="9" size="12" 
	                	CLASS="inputtext" value='<%=tituloBean.getNsu().equals(new Long(0))?"":tituloBean.getNsu().toString()%>' 
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
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.fatorVencimento);"/> 
                 </td>
			</tr>  
			
			<tr>
			
				      <td nowrap class="textoTitulo" width="17%">Linha Digitável:</td>
				      <td class="textoValor" width="26%" nowrap colspan="3"> 
        				       	<p:InputAlfanumerico name="codBarras1" maxlength="10" size="12"  
				                	value='<%=tituloBean.getCodBarras1().equals(new Long(0))?"":tituloBean.getCodBarras1().toString()%>'  
				                	CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codBarras2);"
				                	onBlur="javascript:habilitaCamposCedente();"/>
        				       	<p:InputAlfanumerico name="codBarras2" maxlength="11" size="13"  
				                	value='<%=tituloBean.getCodBarras2().equals(new Long(0))?"":tituloBean.getCodBarras2().toString()%>'  
				                	CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codBarras3);"/>
        				       	<p:InputAlfanumerico name="codBarras3" maxlength="11" size="13"  
				                	value='<%=tituloBean.getCodBarras3().equals(new Long(0))?"":tituloBean.getCodBarras3().toString()%>'  
				                	CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codBarras4);"/>
        				       	<p:InputAlfanumerico name="codBarras4" maxlength="1" size="2"  
				                	value='<%=tituloBean.getCodBarras4().equals(new Long(0))?"":tituloBean.getCodBarras4().toString()%>'  
				                	CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codBarras5);"/>
        				       	<p:InputAlfanumerico name="codBarras5" maxlength="14" size="17"  
				                	value='<%=tituloBean.getCodBarras5().equals(new Long(0))?"":tituloBean.getCodBarras5().toString()%>'  
				                	CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.motivoID);"/>
				                	
				                	
				                	
                 </td>
                 
			</tr> 
			
			<tr>
			       <td class="textoTitulo" width="17%">Motivo:</td>
                   <td class="textoValor" width="26%" colspan="2">
                    	<s:ComboMotivo name="motivo" selectedValue='<%=tituloBean.getMotivo().equals(new Long(0))?"1":tituloBean.getMotivo().toString()%>'	/>
                   </td>
			</tr>	
			
			<tr>
				 <td class="textoTitulo" width="17%">Observações:</td>
                   <td class="textoValor" width="26%" colspan="3">
                    <textarea name="observacoes" cols="51" rows="4" class="textoValor" maxlength="200"><%=tituloBean.getObservacoes()%></textarea>	
                   </td>
			
			</tr>		         
           
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr>
            	<td colspan="4" align="center">
            	  <s:Button name="Ok" action="javascript:formSubmit();"/>
                  <s:Button name="Limpar" action="javascript:limpar();"/>
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
				document.frmMain.fluxo.value = "normal";
				document.frmMain.estrategia.value="<%= TituloOnLineEstrategia.STRATEGY_MANTER_INICIAR%>"
			  	document.frmMain.submit();
  			}  
			
		function validaSubmit() {
			
		
			
			if (document.frmMain.princiDataVencimento.value.length>0 && document.frmMain.fatorVencimento.value.length>0){
				alert("Informe Data de Vencimento ou Fator de Vencimento!");
				return false;
			}
			
				
		        if(!validaCampoObrigatorio(document.frmMain.liquiDataPagamento, 'Data de Pagamento')){
		        	return false;
		        } 
		        if (document.frmMain.princiDataVencimento.value.length>0){
		        	if (validarData(document.frmMain.princiDataVencimento.value) == false) {
						msg('014','Data de Vencimento');
						document.frmMain.dataInicial.focus();
						return false;
					}
		        }
				
				if (validarData(document.frmMain.liquiDataPagamento.value) == false) {
					msg('014','Data de Pagamento');
					document.frmMain.dataFinal.focus();					
					return false;
				}		
				
				return true;
        
		        	
		}
		
		function habilitaCamposCedente(){
			if (document.frmMain.codigoCedente.value.length>0){
				
				document.frmMain.codigoCedente.enabled ="true";
				document.frmMain.nossoNumeroLiq.enabled ="true";
				document.frmMain.princiDataVencimento.enabled ="true";
				document.frmMain.liquiValorDocumento.enabled ="true";
				document.frmMain.fatorVencimento.enabled ="true";
				document.frmMain.codBarras1.value ="";
				document.frmMain.codBarras2.value ="";
				document.frmMain.codBarras3.value ="";
				document.frmMain.codBarras4.value ="";
				document.frmMain.codBarras5.value ="";
				document.frmMain.codBarras1.disabled ="false";
				document.frmMain.codBarras2.disabled ="false";
				document.frmMain.codBarras3.disabled ="false";
				document.frmMain.codBarras4.disabled ="false";
				document.frmMain.codBarras5.disabled ="false";
			}else if (document.frmMain.codBarras1.value.length>0){
				document.frmMain.codigoCedente.value ="";
				document.frmMain.nossoNumeroLiq.value ="";
				document.frmMain.princiDataVencimento.value ="";
				document.frmMain.liquiValorDocumento.value ="";
				document.frmMain.fatorVencimento.value ="";
				document.frmMain.codigoCedente.disabled ="true";
				document.frmMain.nossoNumeroLiq.disabled ="true";
				document.frmMain.princiDataVencimento.disabled ="true";
				document.frmMain.liquiValorDocumento.disabled ="true";
				document.frmMain.fatorVencimento.disabled ="true";
				document.frmMain.codBarras1.enabled ="true";
				document.frmMain.codBarras2.enabled ="true";
				document.frmMain.codBarras3.enabled ="true";
				document.frmMain.codBarras4.enabled ="true";
				document.frmMain.codBarras5.enabled ="true";
			}
			
		}
		
		
		function habilitaData(){
			if (document.frmMain.princiDataVencimento.value.length>0){
				document.frmMain.princiDataVencimento.enabled ="false";
				document.frmMain.fatorVencimento.value="";
				document.frmMain.fatorVencimento.disabled ="true";
			}else if(document.frmMain.fatorVencimento.value.length>0){
				document.frmMain.princiDataVencimento.disabled ="true";
				document.frmMain.princiDataVencimento.value ="";
				document.frmMain.fatorVencimento.enabled ="true";
			}
			
		}
		
		
		
    </script>
  </s:FormStrategy>
</p:Document>
</html>
