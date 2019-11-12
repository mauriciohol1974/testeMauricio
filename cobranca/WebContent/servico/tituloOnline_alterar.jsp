<%
 /***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: lantari_manter_filtro.jsp - Java Server Pages
*Author Eduardo A. Mor�s - emoras@sao.politec.com.br 
*Ultima Atualiza��o: 08/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.LiquidacaoOnlineBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloOnLineEstrategia"%>


<%
	TituloBean tituloBean = (session.getAttribute(TituloOnLineEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(TituloOnLineEstrategia.DATA_BEAN));	
	
	CedenteCabecaBean cedCabBean = (session.getAttribute(TituloOnLineEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TituloOnLineEstrategia.CEDENTE_CABECALHO_BEAN));
	
	LiquidacaoOnlineBean liquidacaoOnline = (session.getAttribute(TituloOnLineEstrategia.FILTRO_BEAN)==null? new LiquidacaoOnlineBean():(LiquidacaoOnlineBean)session.getAttribute(TituloOnLineEstrategia.FILTRO_BEAN));
	
	if (tituloBean.getDescrFormaPagamento().equals("CHEQUE")){
		tituloBean.setFormaPagamento(2l);
	}else{
		tituloBean.setFormaPagamento(1L);
	}
	
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
	}else {
			tituloBean.setMotivo("10");		
	}
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=TituloOnLineEstrategia.STRATEGY_MANTER_ACAO_ALTERAR_EXECUTAR%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='<%=TituloOnLineEstrategia.PAGE_TITLE_MANTER_ALTERAR%>'/>
	<input type="hidden" id="motivo" value""/>
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
	                	disabled="true"
						onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumero);"
						onBlur="javascript:habilitaCamposCedente();"/>
                          
              </td>
            </tr>
            <tr>
               	<td class="textoTitulo" width="17%">Nosso N�mero: </td>
				<td class="textoValor" width="26%" nowrap>
									<p:InputNumerico name="nossoNumeroLiq" maxlength="18" size="23"  
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
               						onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.fatorVencimento);"/> 
                </td>
                <td nowrap class="textoTitulo" width="17%">Fator de Vencimento: </td>
				<td class="textoValor" width="26%" nowrap>
						<p:InputNumerico name="fatorVencimento" maxlength="6" size="7" 
	                	CLASS="inputtext" value='<%=tituloBean.getFatorVencimento().equals( new Long(0))?"":tituloBean.getFatorVencimento().toString()%>' 
	                	onFocus="javascript: prevFocus(this);"
						onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumero);"/>
				 </td> 
            </tr>
            
            <tr>
            	   <td class="textoTitulo" width="17%">Meio de Entrada: </td>
                    <td class="textoValor" width="26%">
                    	<s:ComboMeioEntrada disabled="true" name="meio" selectedValue='<%=tituloBean.getMeio().equals(new Long(0))?"1":tituloBean.getMeio().toString()%>'
                    	/>
                   </td>
                   <td class="textoTitulo" width="17%">Forma de Pagamento: </td>
                   <td class="textoValor" width="26%">
                   <s:ComboFormaPagamento name="formaPagamento" selectedValue='<%=tituloBean.getFormaPagamento().equals(new Long(0))?"1":tituloBean.getFormaPagamento().toString()%>'/>
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
				      <td class="textoValor" width="26%" nowrap> <p:InputNumerico name="nsu" maxlength="9" size="12" 
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
               						disabled="true"
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.fatorVencimento);"/> 
                 </td>
			</tr>  
			
			<tr>
			
				      <td nowrap class="textoTitulo" width="17%">Linha Digit�vel:</td>
				      <td class="textoValor" width="26%" nowrap colspan="3"><%=tituloBean.getCodBarras1()%>&nbsp;
        				       	<%=tituloBean.getCodBarras2()%>&nbsp;
        				       	<%=tituloBean.getCodBarras3()%>&nbsp;
        				       	<%=tituloBean.getCodBarras4()%>&nbsp;
        				       	<%=tituloBean.getCodBarras5()%>&nbsp;
                 	  </td>
                 
			</tr> 
			
			<tr>
			       <td class="textoTitulo" width="17%">Motivo:</td>
                   <td class="textoValor" width="26%" colspan="2"><s:ComboMotivo name="motivo" selectedValue='<%=tituloBean.getMotivo().equals(new Long(0))?"1":tituloBean.getMotivo().toString()%>'
                    	/>
                   </td>
			</tr>	
			
			<tr>
				 <td class="textoTitulo" width="17%">Observa��es:</td>
                   <td class="textoValor" width="26%" colspan="3">
                    <textarea name="observacoes" cols="51" rows="4" class="textoValor"><%=tituloBean.getObservacoes()%></textarea>	
                   </td>
			
			</tr>	
			
			<tr>
				      <td nowrap class="textoTitulo" width="17%">Data Situa��o: </td>
				      <td class="textoValor" width="26%" nowrap> 
        				       <%=tituloBean.getDtGarantia()%> 
 					  <td nowrap class="textoTitulo" width="17%">Descri��o Situa��o: </td>
				      <td class="textoValor" width="26%" nowrap> <%=tituloBean.getDescrSituacao()%>
					 </td>							
                
			
			</tr>
			
			<tr>
				      <td nowrap class="textoTitulo" width="17%">Usu�rio: </td>
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
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr>
            	<td colspan="4" align="center">
            	  <s:Button name="OK" action="javascript:executar();"/>
            	  <s:Button name="Voltar" action="javascript:voltar();"/>
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

		
		function voltar() {
			
			document.frmMain.fluxo.value = "voltar";
			document.frmMain.estrategia.value="<%= TituloOnLineEstrategia.STRATEGY_MANTER_LISTAR%>"
		  	document.frmMain.submit();
			
		}
		
		function executar() {
			
			if (document.frmMain.princiDataVencimento.value.length>0){
				 if (validarData(document.frmMain.princiDataVencimento.value) == false) {
						msg('014','Data de Vencimento');
						document.frmMain.dataInicial.focus();
						return false;
					}
				
			}
		        
				document.frmMain.estrategia.value="<%= TituloOnLineEstrategia.STRATEGY_MANTER_ACAO_ALTERAR_EXECUTAR%>"
				document.frmMain.submit();
			
			
			
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
    