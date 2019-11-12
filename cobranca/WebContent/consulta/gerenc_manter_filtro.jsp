<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: gerenc_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 16/11/2004 - v1
************************************************/
%>

<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GerencEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.GerencFiltroBean "%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	GerencFiltroBean filtroBean = (session.getAttribute(GerencEstrategia.BEAN_FILTRO)==null? new GerencFiltroBean()
																			:(GerencFiltroBean)session.getAttribute(GerencEstrategia.BEAN_FILTRO));
																			
	filtroBean.setCodigoCedente(session.getAttribute(GerencEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(GerencEstrategia.CEDENTE_ATUAL));
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=GerencEstrategia.STRATEGY_FILTRO%>" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=GerencEstrategia.PAGE_TITLE_FILTRO%>"/>

		<input type="hidden" name="tpFiltro" 			value="">
		<input type="hidden" name="tpPeriodo" 		value=""><%/*armazena valores selecionados no radio de periodo*/%>
		<input type="hidden" name="tpConsulta" 		value=""><%/*armazena valores selecionados no radio de consulta*/%>
		<input type="hidden" name="tipoConsulta" 	value="">
		<input type="hidden" name="tipoRelatorio"	value=""><%/*armazena valores exclusivos para o mainframe relativos aos relatorios gerencias*/%>
		<input type="hidden" name="tipoData" 			value="">
		<input type="hidden" name="consolidado" 	value="">
		<input type="hidden" name="mesAno" 				value="">
		<input type="hidden" name="navegacao"			value="">

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
                <input type="radio" name="rdConsulta" onclick="javascript:habilitaDigitação();radioNextFocus(document.frmMain.codigoCedente);">
              </td>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"> 
                <p:InputNumerico name="codigoCedente" disabled="true" maxlength="7" size="7" CLASS="inputtext" value=""/>
              </td>
             	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rdConsulta" onclick="javascript:habilitaDigitação();radioNextFocus(document.frmMain.codigoUnidade);">
              </td>
              <td class="textoTitulo" width="17%">Unidade: </td>
              <td class="textoValor" width="26%">
                <s:ComboENPV name="comboEnPv" disabled="true" selectedValue='2'/>
                <p:InputNumerico name="codigoUnidade" disabled="true" size="5" maxlength="4" CLASS="inputtext"/>
							</td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rdConsulta" onclick="javascript:habilitaDigitação();">
              </td>
              <td class="textoTitulo" width="17%">Caixa </td>
              <td class="textoValor" width="26%">&nbsp;</td>
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
                <input type="radio" name="rdPeriodo" onclick="javascript:habilitaDigitação();radioNextFocus(document.frmMain.mesAnoInput);">
              </td>
              <td class="textoTitulo" width="17%">Mes/Ano: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico name="mesAnoInput" disabled="true" size="8" maxlength="6" CLASS="inputtext" 
              				onBlur="javascript:formataMesAno(this);"
              				onFocus="javascript:unFormataMesAno(this);"/>
              </td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
						</tr>
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rdPeriodo" onclick="javascript:habilitaDigitação();radioNextFocus(document.frmMain.data);">
              </td>
              <td class="textoTitulo" width="17%">Data: </td>
              <td class="textoValor" width="26%">
              	<p:InputDate name="data" CLASS="inputtext" disabled="true"/>
              </td>
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
								<input type="checkbox" name="ckConsolidado" checked>
							</td>
            	<td class="textoTitulo" width="17%">Consolidado</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Consultas:
                <hr>
              </td>
            </tr>
            
            <tr>
              <td colspan="5">
	              <table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">    
	              <%/*Guia: bloqueto por servicos /////////////////////////////////////////////////////// */%>
	              	<tr>	              
	              		<td>
				             	<s:Outline name="blocServ" title="Boletos por Serviços" imagePath="<%=Paths.getImagePath()%>" type="outline">          
		                  	<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
		                    	<tr> 
		                     		<td colspan="6">&nbsp;</td>
		                    	</tr>
						            	<tr> 
						              	<td class="textoTitulo" width="2%">
						                	<input type="radio" name="rdFiltro" >
						              	</td>
						              	<td class="textoTitulo" width="30%">Boletos Laser padrão Caixa</td>
						              	<td class="textoValor" width="5%">&nbsp;</td>
						              	<td class="textoTitulo"
						              	 width="2%">
						              	  <input type="radio" name="rdFiltro" >
						              	</td>
						              	<td class="textoTitulo" width="30%">Boletos Pré-Impressos</td>
						              	<td class="textoValor" width="5%">&nbsp;</td>
													</tr>
						            	<tr> 
						              	<td class="textoTitulo" width="2%">
						                	<input type="radio" name="rdFiltro" >
						              	</td>
						              	<td class="textoTitulo" width="30%">Carnês Laser padrão Caixa</td>
						              	<td class="textoValor" width="5%">&nbsp;</td>
						              	<td class="textoTitulo" width="2%">
															<input type="radio" name="rdFiltro" >
														</td>
						              	<td class="textoTitulo" width="30%">Boletos Personalizados</td>
						              	<td class="textoValor" width="5%">&nbsp;</td>
													</tr>
						            	<tr> 
		                      	<td colspan="6">&nbsp;</td>
		                    	</tr>
	                  		</table>
								  		</s:Outline>
								 		</td>
									</tr>	
					      <%/*Guia: cedente eletronico ////////////////////////////////////////////////////////// */%>                  
	        	    	<tr>
	              		<td>
				             	<s:Outline name="cedenteEletronico" title="Cedente Eletrônico" imagePath="<%=Paths.getImagePath()%>" type="outline">          
		                  	<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
		                    	<tr> 
		                      	<td colspan="6">&nbsp;</td>
		                    	</tr>
						            	<tr> 
						              	<td class="textoTitulo" width="2%">
						                	<input type="radio" name="rdFiltro" >
						              	</td>
						              	<td class="textoTitulo" width="30%">Cedentes padrões CNAB 240 e 400</td>
						              	<td class="textoValor" width="5%">&nbsp;</td>
						              	<td class="textoTitulo" width="2%">
						                	<input type="radio" name="rdFiltro" >
						              	</td>
						              	<td class="textoTitulo" width="30%">Cedentes por Meio Entrada</td>
						              	<td class="textoValor" width="5%">&nbsp;</td>
													</tr>
						            	<tr> 
						              	<td class="textoTitulo" width="2%">
						                	<input type="radio" name="rdFiltro" >
						              	</td>
						              	<td class="textoTitulo" width="30%">Cedentes por Situação Teste/Produção e Movimento</td>
						              	<td class="textoValor" width="5%">&nbsp;</td>
						              	<td class="textoTitulo" width="2%">
						                	<input type="radio" name="rdFiltro" >
						              	</td>
						              	<td class="textoTitulo" width="30%">Movimento por tipo de Van</td>
						              	<td class="textoValor" width="5%">&nbsp;</td>
													</tr>
						            	<tr> 
		                      	<td colspan="6">&nbsp;</td>
		                    	</tr>
		                 		</table>
								  		</s:Outline>
								 		</td>
									</tr>
								<%/*Guia: preco de transferencia e tarifas liquidação ///////////////////////////////// */%>                  
            			<tr>
	              		<td>
				             	<s:Outline name="precoTransfTarLiq" title="Preço de Transferencia e Tarifas Liquidação" imagePath="<%=Paths.getImagePath()%>" type="outline">          
		                  	<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
		                    	<tr> 
		                      	<td colspan="6">&nbsp;</td>
		                    	</tr>
							            <tr> 
							              <td class="textoTitulo" width="2%">
							                <input type="radio" name="rdFiltro" >
							              </td>
							              <td class="textoTitulo" width="30%">Posição por PV/SR Recebedor</td><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
							              <td class="textoValor" width="5%">&nbsp;</td>
							              <td class="textoTitulo" width="2%">
							                <input type="radio" name="rdFiltro" >
							              </td>
							              <td class="textoTitulo" width="30%">Posição por PV/SR Vinculação</td><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
							              <td class="textoValor" width="5%">&nbsp;</td>
													</tr>
							            <tr> 
			                      <td colspan="6">&nbsp;</td>
			                    </tr>
                  			</table>
                  			</s:Outline>
								 			</td>
										</tr>
									<%/*Guia: Titulos por quantidade e valor ////////////////////////////////////////////// */%>                  
										<tr>
		              		<td>
					             	<s:Outline name="titulosQtdValor" title="Títulos por Quantidade e valor" imagePath="<%=Paths.getImagePath()%>" type="outline">          
			                  	<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
			                    	<tr> 
			                      	<td colspan="6">&nbsp;</td>
			                    	</tr>
								            <tr> 
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Movimentação de Títulos</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Movimentação de Títulos/Tarifas/Float</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
														</tr>
								            <tr> 
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Posição de Títulos em Carteira por Serviço</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Títulos Incluídos</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
														</tr>
								            <tr> 
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Títulos Incluídos/Liquidados por Tipo de Cobrança</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Títulos Liquidados com Float = 0</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
														</tr>
								            <tr> 
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Títulos Liquidados por Serviços/Meio de Liquidação</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
								              <td class="textoTitulo" width="2%">
								              	<input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Títulos Liquidados com Retenção de IOF</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
											</tr>
								            <tr> 
				                      <td colspan="6">&nbsp;</td>
				                    </tr>
				                  </table>
                  			</s:Outline>
								 			</td>
										</tr>
									<%/*Guia: valores de tarifa /////////////////////////////////////////////////////////// */%>                  
										<tr>
		              		<td>
					             	<s:Outline name="valoresTarifa" title="Valores de Tarifas" imagePath="<%=Paths.getImagePath()%>" type="outline">          
			                  	<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
			                    	<tr> 
			                      	<td colspan="6">&nbsp;</td>
			                    	</tr>         
								            <tr> 
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Emissão e Postagem de Boletos / Extratos</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Liquidação por Serviços / Meio Liquidação</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
														</tr>
								            <tr> 
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Protesto de Títulos</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Serviços diversos</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
														</tr>
								            <tr> 
								              <td class="textoTitulo" width="2%">
								                <input type="radio" name="rdFiltro" >
								              </td>
								              <td class="textoTitulo" width="30%">Total de Tarifas / Custo</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
								              <td class="textoTitulo" width="2%">&nbsp;</td>
								              <td class="textoTitulo" width="30%">&nbsp;</td>
								              <td class="textoValor" width="5%">&nbsp;</td>
														</tr>
								            <tr> 
				                      <td colspan="6">&nbsp;</td>
				                    </tr>
				                  </table>
				                 </s:Outline>
								 			</td>
										</tr>
									<%/*fim guias ///////////////////////////////////////////////////////////////////////// */%>
	              </table>
	          	</td>
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
      function inicia(){
				setFirstFieldFocus();
				
			<%/*obtendo histórico de volta para os radios*/%>				
				document.frmMain.rdPeriodo[<%=filtroBean.getTpPeriodo()%>].checked = true;
				document.frmMain.rdConsulta[<%=filtroBean.getTpConsulta()%>].checked = true;
				document.frmMain.rdFiltro[<%=filtroBean.getTpFiltro()%>].checked = true;

			<%/*carrega valores nos campos habilitados*/%>
				carregaCampos();
				
			<%/*checando o Check button ckConsolidado*/
			if(filtroBean.getConsolidado().equals(new Long(1))){%>
				document.frmMain.ckConsolidado.checked = true;
			<%}else{%>
				document.frmMain.ckConsolidado.checked = false;
			<%}%>				
				
      }
    
			function formSubmit(){
				if(validaSubmit()){
					document.frmMain.mesAno.value = document.frmMain.mesAnoInput.value.replace('/','.')
					document.frmMain.submit();
				}
			}
			
			function validaSubmit(){
				if(!validardConsulta()){
					return false;
				}
				
				if(!validaRdPeriodo()){
					return false;
				}
				
				if(!validardFiltro()){ 
					return false;
				}
				
				if(!validaInconsistencia()){
					return false;
				}
				
				return true;
			}
			
			function validaInconsistencia(){
				<%/*Valida a inconsistencia de alguns relatórios, por exemplo Relatório de 
				  "Posição por PV/SR Recebedor" por cedente */%>
				if(document.frmMain.rdConsulta[0].checked){
					if(document.frmMain.rdFiltro[8].checked 
					|| document.frmMain.rdFiltro[4].checked 
					|| document.frmMain.rdFiltro[6].checked){
						msg('060', '', '','','');
						return false;
					}
				}
				return true;
			}
			
			function consolida(){
				if(document.frmMain.ckConsolidado.checked){	
						document.frmMain.consolidado.value = '<%=GerencEstrategia.CONSOLIDADO_SIM%>'; 
					}else{
						document.frmMain.consolidado.value = '<%=GerencEstrategia.CONSOLIDADO_NAO%>'; 
					}
				return;
			}
			
			function validardConsulta(){
				if(document.frmMain.rdConsulta[0].checked){
					if(validaCampoObrigatorio(document.frmMain.codigoCedente, 'Código Cedente')){
						document.frmMain.tipoConsulta.value = '<%=GerencEstrategia.TIPO_CONSULTA_CEDENTE%>';
						document.frmMain.navegacao.value = '<%=GerencEstrategia.NAVEGACAO_CEDENTE%>';
						document.frmMain.tpConsulta.value = "0";
<%           /*o relatório selecionado pelo codigo de cedente sempre será consolidado 
						 por isso o campo hidden sera marcado como 1. */                        %>
						document.frmMain.consolidado.value = '<%=GerencEstrategia.CONSOLIDADO_SIM%>'; 
						return true;
					}
				}else if(document.frmMain.rdConsulta[1].checked){
					if(validaCampoObrigatorio(document.frmMain.codigoUnidade, 'Código da unidade')){
<%           /*verificando qual tipo de unidade*/                                   %>
						
						if(document.frmMain.comboEnPv.value == 1){<%/*EN*/%>
							document.frmMain.tipoConsulta.value = '<%=GerencEstrategia.TIPO_CONSULTA_EN%>';
							document.frmMain.navegacao.value = '<%=GerencEstrategia.NAVEGACAO_EN%>';

						}else if(document.frmMain.comboEnPv.value == 2){<%/*PV*/%>
							document.frmMain.tipoConsulta.value = '<%=GerencEstrategia.TIPO_CONSULTA_PV%>';
							document.frmMain.navegacao.value = '<%=GerencEstrategia.NAVEGACAO_PV%>';
						}
						
						document.frmMain.tpConsulta.value = "1";
						consolida();
						return true;
					}
				}else	if(document.frmMain.rdConsulta[2].checked){
					document.frmMain.tipoConsulta.value = '<%=GerencEstrategia.TIPO_CONSULTA_CAIXA%>';
					document.frmMain.navegacao.value = <%=GerencEstrategia.NAVEGACAO_CAIXA%>;					
					document.frmMain.tpConsulta.value = "2";
					consolida();
					return true;
				}else{
					msg('003','tipo de filtro','','','');
				}
				return false;
			}
			
			function validaRdPeriodo(){
				if(document.frmMain.rdPeriodo[0].checked){
					if(validaCampoObrigatorio(document.frmMain.mesAnoInput, 'Mês/Ano')){
						if(validaMesAno(document.frmMain.mesAnoInput)){
							document.frmMain.tpPeriodo.value = "0";
							document.frmMain.tipoData.value = "1";						
							return true;
						}
					}
				}else	if(document.frmMain.rdPeriodo[1].checked){
					if(validaCampoObrigatorio(document.frmMain.data, 'Data')){
						if (validaData(document.frmMain.data,'')){
							document.frmMain.tpPeriodo.value = "1";
							document.frmMain.tipoData.value = "2";												
							return true;
			    	}else{
			    		alert("Data invalida.");
			    	}
					}
				}else{
					msg('003','periodo de relatório','','','');
				}
				return false;		    
			}
			
			function validardFiltro(){
				for (var i=0; i< document.frmMain.rdFiltro.length ; i++) {
	    		if (document.frmMain.rdFiltro[i].checked) {
	    			switch (i) {
		<!--//  Impressão de Bloquetos por Serviços  					//-->
	    			case 00:	
	    				document.frmMain.tpFiltro.value = "0";  
	    				document.frmMain.tipoRelatorio.value = "34";  
	    				break;
	    				
	    			case 01:	
	    				document.frmMain.tpFiltro.value = "1";  
 	    				document.frmMain.tipoRelatorio.value = "15";  
	    				break;
	    				
	    			case 02:	
	    				document.frmMain.tpFiltro.value = "2";  
	    				document.frmMain.tipoRelatorio.value = "17";  
	    				break;
	    				
	    			case 03:	
	    				document.frmMain.tpFiltro.value = "3";  
	    				document.frmMain.tipoRelatorio.value = "16";
	    				break;
	        			
		<!--//  Quantidade de Registros/Cedentes Eletrônicos  //-->
	    			case 04:	
	    				document.frmMain.tpFiltro.value = "4";
	    				document.frmMain.tipoRelatorio.value = "23";  
	    				break;
	    				
	    			case 05:	
	    				document.frmMain.tpFiltro.value = "5";  
	    				document.frmMain.tipoRelatorio.value = "20";
	    				break;
	    				
	    			case 06:	
	    				document.frmMain.tpFiltro.value = "6";  
	    				document.frmMain.tipoRelatorio.value = "22";
	    				break;
	    				
	    			case 07:	
	    				document.frmMain.tpFiltro.value = "7";  
	    				document.frmMain.tipoRelatorio.value = "18";
	    				break;
	
	  <!--//  Preço de Transferência e Tarifas Liquidação 	//-->
	    			case 08:	
	    				document.frmMain.tpFiltro.value = "8";  
	    				document.frmMain.tipoRelatorio.value = "31";
	    				break;
	    				
	    			case 09:	
	    				document.frmMain.tpFiltro.value = "9"; 	
	    				document.frmMain.tipoRelatorio.value = "32";
	    				break;
	
	  <!--//  Quantidade/Valor de Títulos                   //-->  
	    			case 10:	
	    				document.frmMain.tpFiltro.value = "10"; 
	    				document.frmMain.tipoRelatorio.value = "01";
	    				break;
	    			
	    			case 11:	
	    				document.frmMain.tpFiltro.value = "11";	
	    				document.frmMain.tipoRelatorio.value = "37";
	    				break;
	    				
	    			case 12:	
	    				document.frmMain.tpFiltro.value = "12"; 
	    				document.frmMain.tipoRelatorio.value = "09";
	    				break;
	    				
	    			case 13:	
	    				document.frmMain.tpFiltro.value = "13"; 
	    				document.frmMain.tipoRelatorio.value = "02";
	    				break;
	    				
	    			case 14:	
	    				document.frmMain.tpFiltro.value = "14"; 
	    				document.frmMain.tipoRelatorio.value = "07";
	    				break;
	    				
	    			case 15:	
	    				document.frmMain.tpFiltro.value = "15"; 
	    				document.frmMain.tipoRelatorio.value = "14";
	    				break;
	    				
	    			case 16:	
	    				document.frmMain.tpFiltro.value = "16"; 
	    				document.frmMain.tipoRelatorio.value = "05";
	    				break;
	    			
	    			case 17:	
	    				document.frmMain.tpFiltro.value = "17"; 
	    				document.frmMain.tipoRelatorio.value = "11";
	    				break;
	
	  <!--//  Posição de Valores de Tarifas									//-->

	    			case 18:	
	    				document.frmMain.tpFiltro.value = "18"; 
	    				document.frmMain.tipoRelatorio.value = "25";
	    				break;
	    				
	    			case 19:	
	    				document.frmMain.tpFiltro.value = "19"; 
	    				document.frmMain.tipoRelatorio.value = "26";
	    				break;
	    				
	    			case 20:	
	    				document.frmMain.tpFiltro.value = "20"; 
	    				document.frmMain.tipoRelatorio.value = "35";
	    				break;
	    				
	    			case 21:	
	    				document.frmMain.tpFiltro.value = "21";	
	    				document.frmMain.tipoRelatorio.value = "36";
	    				break;
	    				
	    			case 22: 	
	    				document.frmMain.tpFiltro.value = "22"; 
	    				document.frmMain.tipoRelatorio.value = "30";
	    				break;
	        	}
	        }
	    	}

	    	if(document.frmMain.tpFiltro.value == ""){
	    		msg('003','tipo de consulta','','','');
	    		return false;
	    	}else{
	    		return true;			
	    	}
			}
			
			function validaMesAno(obj){
				objTemp = new Object("value");
				objTemp.value = "01/"+ obj.value; 
				if (!validaData(objTemp,'')){
					msg('029',obj.value+' (Mês/Ano)','','','');
					obj.focus();
					return false;
				}
				return true;
			}
			
			function carregaCampos(){
				
				<!--//filtro  -->
				
				if (document.frmMain.rdConsulta[0].checked){
										
					document.frmMain.codigoCedente.disabled = false;
					document.frmMain.codigoUnidade.disabled = true;
					document.frmMain.comboEnPv.disabled 		= true;
					document.frmMain.codigoUnidade.value 		= "";	
					
					<%/*carregando dados*/%>	
					if (document.frmMain.codigoCedente.value == ""){			
						document.frmMain.codigoCedente.value	 = "<%=filtroBean.getCodigoCedente().equals( new Long(0))?"":filtroBean.getCodigoCedente().toString()%>";
					}
	
				} else if(document.frmMain.rdConsulta[1].checked){
			
					document.frmMain.codigoCedente.disabled = true;
					document.frmMain.codigoUnidade.disabled = false;
					document.frmMain.comboEnPv.disabled 		= false;							
					document.frmMain.codigoCedente.value 		= "";
					
					<%/*carregando dados*/%>	
					
					if (<%=filtroBean.getTipoConsulta().equals(GerencEstrategia.TIPO_CONSULTA_PV)%>){
						document.frmMain.comboEnPv.value 				= 2;//PV							
					}else if (<%=filtroBean.getTipoConsulta().equals(GerencEstrategia.TIPO_CONSULTA_EN)%>) {
						document.frmMain.comboEnPv.value 				= 1;//EN							
					}
					if(document.frmMain.codigoUnidade.value == ""){			
						document.frmMain.codigoUnidade.value	= "<%=filtroBean.getCodigoUnidade().equals( new Long(0))?"":filtroBean.getCodigoUnidade().toString()%>";
					}
					
				} else if(document.frmMain.rdConsulta[2].checked){
			
					document.frmMain.codigoCedente.disabled = true;
					document.frmMain.codigoUnidade.disabled = true;
					document.frmMain.comboEnPv.disabled 		= true;							
					document.frmMain.codigoUnidade.value 		= "";										
					document.frmMain.codigoCedente.value 		= "";
				}
				
				//periodo 
				
				if (document.frmMain.rdPeriodo[0].checked){
					
					document.frmMain.data.disabled				= true;
					document.frmMain.mesAnoInput.disabled = false;
					document.frmMain.data.value 					= "";
					
					<%/*carregando dados*/%>	
					if (document.frmMain.mesAnoInput.value == ""){
					<%if (filtroBean.getDataFormatada().length() == 7){%>			
						document.frmMain.mesAnoInput.value	 = "<%=filtroBean.getDataFormatada()%>";
					<%}%>
					}
					
				} else if(document.frmMain.rdPeriodo[1].checked){
						
					document.frmMain.data.disabled				= false;
					document.frmMain.mesAnoInput.disabled = true;
					document.frmMain.mesAnoInput.value 		= "";
					
					<%/*carregando dados*/%>				
					if (document.frmMain.data.value == ""){
					<%if (filtroBean.getDataFormatada().length() == 10){%>			
						document.frmMain.data.value		= "<%=filtroBean.getDataFormatada()%>";
					<%}%>
					}
				}	
			
			}
			
			function habilitaDigitação(){
				
				<!--//filtro  -->
				
				if (document.frmMain.rdConsulta[0].checked){
					document.frmMain.codigoCedente.disabled = false;
					document.frmMain.codigoUnidade.disabled = true;
					document.frmMain.comboEnPv.disabled 		= true;
					document.frmMain.codigoUnidade.value 		= "";	
				} else if(document.frmMain.rdConsulta[1].checked){
					document.frmMain.codigoCedente.disabled = true;
					document.frmMain.codigoUnidade.disabled = false;
					document.frmMain.comboEnPv.disabled 		= false;							
					document.frmMain.codigoCedente.value 		= "";
				} else if(document.frmMain.rdConsulta[2].checked){
					document.frmMain.codigoCedente.disabled = true;
					document.frmMain.codigoUnidade.disabled = true;
					document.frmMain.comboEnPv.disabled 		= true;							
					document.frmMain.codigoUnidade.value 		= "";										
					document.frmMain.codigoCedente.value 		= "";
				}
				
				//periodo 
				
				if (document.frmMain.rdPeriodo[0].checked){
					document.frmMain.data.disabled				= true;
					document.frmMain.mesAnoInput.disabled = false;
					document.frmMain.data.value 					= "";
				} else if(document.frmMain.rdPeriodo[1].checked){
					document.frmMain.data.disabled				= false;
					document.frmMain.mesAnoInput.disabled = true;
					document.frmMain.mesAnoInput.value 		= "";
				}	
			
			}
			
			function formataMesAno(obj){				
				strMesAno = obj.value;	
				strMes = strMesAno.substr(0,2);
				strAno = strMesAno.substr(2);
				
				if (strMesAno.length == 4) {
			   	if (strAno > '70') {
     				strAno = '19' + strAno;
   				} else {
     				strAno = '20' + strAno;
   				}
				}
				
				if(strMesAno.length > 0){
					obj.value = strMes+"/"+strAno;
				}
				return;
			}
			
			function unFormataMesAno(obj){
				strMesAno = obj.value;
				obj.value = strMesAno.replace('/','');
			}
			
			
    </script>
 		</s:FormStrategy>
	</p:Document>
</html>