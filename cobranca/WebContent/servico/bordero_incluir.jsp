<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bordero_incluir.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 02/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteBloquetosBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BorderoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>


<%
	BorderoBean borderoBean = (session.getAttribute(BorderoEstrategia.DATA_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(BorderoEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN));
	CedenteGeralBean cedGeralBean = (session.getAttribute(BorderoEstrategia.CEDENTE_GERAL_BEAN)==null?new CedenteGeralBean():(CedenteGeralBean)session.getAttribute(BorderoEstrategia.CEDENTE_GERAL_BEAN));
	CedenteBloquetosBean cedBloqBean = (session.getAttribute(BorderoEstrategia.CEDENTE_BLOQUETO_BEAN)==null?new CedenteBloquetosBean():(CedenteBloquetosBean)session.getAttribute(BorderoEstrategia.CEDENTE_BLOQUETO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia='<%=BorderoEstrategia.STRATEGY_INCLUIR_FINALIZAR%>' fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Incluir Borderô"/>    
		<input type="hidden" name="codigoCedente" value='<%=borderoBean.getCodigoCedente()%>'>
		<input type="hidden" name="registrarSR"  />
		<input type="hidden" name="somenteProtesto" />
		<input type="hidden" name="modalidadeTitulo">
		<input type="hidden" name="dataMovimento" value='<%=borderoBean.getDataMovimentoFormatada().toString()%>'>
		<input type="hidden" name="vinculacaoPV" value='<%=borderoBean.getVinculacaoPV()%>'>
		<input type="hidden" name="moeda">
		<input type="hidden" name="protestoAutomatico">
		<input type="hidden" name="prazoProtDevol">
		<input type="hidden" name="emissaoBloqueto">
		<input type="hidden" name="situacao" value="1">

		<!--EAM - 03/05/05 - SISOT 64(Gestor)-->		
		<input type="hidden" name="aceite">
  	<input type="hidden" name="endosso">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
	            <td class="textoValor" nowrap width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
              <td class="textoTitulo" width="17%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Borderô:
                <hr>
              </td>
            </tr>

 						<tr>
 							<td colspan ="4">         
		            <s:Outline name="Bordero" title="Borderô" imagePath="<%=Paths.getImagePath()%>" type="outline">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                           <td class="textoTitulo" width="17%">Registrar Título Sem Registro: </td>
                           <td class="textoValor" width="26%"><s:ComboSimNao name="registrarSRcombo" selectedValue='<%=borderoBean.getRegistrarSR().trim().equals("")?"N":borderoBean.getRegistrarSR()%>' onChange="javascript: configuraregistroSR(this);"/></td>                           
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Somente para Protesto: </td>
                      <td class="textoValor" width="26%">
                        
                        <s:ComboSimNao name="somenteProtestoCombo" selectedValue='<%=borderoBean.getSomenteProtesto().trim().equals("")?"N":borderoBean.getSomenteProtesto()%>' onChange="javascript: configuraCampoDependente(this);"/>                       
                       <td class="textoTitulo" width="17%">Modalidade Titulo: </td>
                      <td class="textoValor" width="26%">
                        <s:ComboModalidadeTitulo name="modalidadeTituloCombo" selectedValue='<%=borderoBean.getModalidadeTitulo().equals( new Long(0))?cedGeralBean.getModalidadeTitulo().toString():borderoBean.getModalidadeTitulo().toString()%>'
                        		onChange="javascript: configuraCampoDependente(this);"/>
                      </td>
					</tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Data do Movimento: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getDataMovimentoFormatada()%></td>
          
                      <td class="textoTitulo" width="17%">PV de Vinculação: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getVinculacaoPVFormatado()%></td>
                    </tr>

                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Quantidade: </td>
				              <td class="textoValor" width="26%" nowrap> 
													<p:InputNumerico name="quantidade" maxlength="2" size="2" 
                						CLASS="inputtext" 
                						value='<%=borderoBean.getQuantidade().equals( new Long(0))?"":borderoBean.getQuantidade().toString()%>'
                						onFocus="javascript: prevFocus(this);"
														onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.valor);"/>        				       
                      </td>

                      <td nowrap class="textoTitulo" width="17%">Valor: </td>
				              <td class="textoValor" width="26%" nowrap> 
        				        <p:InputCurrency name="valor" maxlength="17" size="29" 
                						CLASS="inputtext"
                						value='<%=borderoBean.getValor().toString().equals("R$ 0,00")?"":borderoBean.getValor().toString()%>' 
                						onFocus="javascript: prevFocus(this);"
														onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.endossoCombo);"/> 
                      </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Endosso: </td>
                      <td class="textoValor" width="26%">
         									<s:ComboSimNao name="endossoCombo" selectedValue='<%=borderoBean.getEndosso().trim().equals("")?"N":borderoBean.getEndosso()%>'/> 
                      </td>

                      <td class="textoTitulo" width="17%">Espécie de Título: </td>
                      <td class="textoValor" width="26%">
                       	<s:ComboEspecieTitulo name="especieTitulo" selectedValue='<%=borderoBean.getEspecieTitulo().equals(new Long(0))?"-1":borderoBean.getEspecieTitulo().toString()%>' branco="true"/>
                      </td>
                    </tr>
                    
                    <tr>
                      <td class="textoTitulo" width="17%">Aceite: </td>
                      <td class="textoValor" width="26%">
                        <s:ComboAceite name="aceiteCombo" selectedValue='<%=borderoBean.getAceite().trim().equals("")?"-1":borderoBean.getAceite()%>' branco="true" filtroBordero="true"/>
                      </td>

                      <td class="textoTitulo" width="17%">Moeda: </td>
                      <td class="textoValor" width="26%">
												<s:ComboMoeda name="moedaCombo" selectedValue='<%=borderoBean.getMoeda().equals(new Long(0))?"9":borderoBean.getMoeda().toString()%>' disabled="true"/>
											</td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Protesto Automático: </td>
				              <td width="26%" nowrap> 
													<s:ComboSimNao name="protestoAutomaticoCombo" selectedValue='<%=borderoBean.getProtestoAutomatico().trim().equals("")?cedGeralBean.getProtestoAutomatico():borderoBean.getProtestoAutomatico()%>'/>                       
                      </td>
                      <%//EAM - Obter o Prazo de Protesto do cedente quando Protesto Automático = Sim
                      	//Obter o Prazo de Devolucao do cedente quando Protesto Automático = Nao
                      	Long prazo = new Long (0);
                      	if (cedGeralBean.getProtestoAutomatico().trim().equals("S")){
                      		prazo = cedGeralBean.getPrazoProtesto();
                      	}else if (cedGeralBean.getProtestoAutomatico().trim().equals("N")){
                      		prazo = cedGeralBean.getPrazoDevolucao();
                      	}
                      %>
                      
                      <td nowrap class="textoTitulo" width="17%">Prazo de Protesto/Devolução: </td>
				              <td width="26%" nowrap> 
        				        <p:InputNumerico name="prazoProtDevolInput" maxlength="3" size="3" 
                						CLASS="inputtext" 
                						value='<%=borderoBean.getPrazoProtDevol().equals(new Long(0))?prazo.toString():borderoBean.getPrazoProtDevol().toString()%>'                 						
                						onFocus="javascript: prevFocus(this);"
														onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.envioBloqueto);"/> 
                      </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Emissão Boleto: </td>
                      <td class="textoValor" width="26%">
													<s:ComboEmissaoBloqueto name="emissaoBloquetoCombo" selectedValue='<%=borderoBean.getEmissaoBloqueto().equals(new Long(0))?cedBloqBean.getEmissaoBloquetos().toString():borderoBean.getEmissaoBloqueto().toString()%>'
                 						onChange="javascript: configuraCampoDependente(this);" />         
                      </td>
                      <td class="textoTitulo" width="17%">Envio do Boleto: </td>
                      <td class="textoValor" width="26%">
                        	<s:ComboEnvioBloqueto name="envioBloqueto" selectedValue='<%=borderoBean.getEnvioBloqueto().equals(new Long(0))?cedBloqBean.getEnvioBloqueto().toString():borderoBean.getEnvioBloqueto().toString()%>' branco="true"/>
                      </td>
                    </tr>
                                       
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                  </table>
                </s:Outline>	
							</td>
            </tr>
 						<tr>
 							<td colspan ="4">         
		            <s:Outline name="Complementar" title="Dados Complementares" imagePath="<%=Paths.getImagePath()%>" type="outline">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="4">
			                  <table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
												  <tr class="headerLista">
												    <td nowrap width="17%" align="center">&nbsp;</td>
				 								    <td nowrap width="26%" align="left">Percentual</td>
												    <td nowrap width="17%" align="center">&nbsp;</td>
				 								    <td nowrap width="26%" align="left">Dias </td>
												  </tr>
								<tr class="line0">
								

								
			                      <td class="textoTitulo" width="17%" align="left">Desconto 1: </td>
			                      <td class="textoValor" width="26%" align="left">
			        				        <p:InputPercentual name="percentualDesconto1" maxlength="5" size="9" 
			                						CLASS="inputtext"
 				               						value ='<%=borderoBean.getPercentualDesconto1().toString().equals("0,00 %")?"":borderoBean.getPercentualDesconto1().toString()%>'
 				               						onFocus="javascript: prevFocus(this);configuraCampoDependente(this);"
																	onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.prazoLimite1Dia);"
																	onBlur="javascript: configuraCampoDependente(this);"/>  
														</td>
			                      <td class="textoTitulo" width="17%" align="left">Prazo Limite 1: </td>
			                      <td class="textoValor" width="26%" align="left">
			        				        <p:InputNumerico name="prazoLimite1Dia" maxlength="3" size="3"
			                						CLASS="inputtext" 
 				               						value ='<%=borderoBean.getPrazoLimite1Dia().toString()%>'			                									                						
 				               						onFocus="javascript: prevFocus(this);configuraCampoDependente(this);"
																	onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.percentualDesconto2);"
																	onBlur="javascript: configuraCampoDependente(this);"/>
														</td>
													</tr> 
												  <tr class="line2">
			                      <td class="textoTitulo" width="17%" align="left">Desconto 2: </td>																	                      			                      
			                      <td class="textoValor" width="26%" align="left">
			        				        <p:InputPercentual name="percentualDesconto2" maxlength="5" size="9"
			                						CLASS="inputtext" 
 				               						value ='<%=borderoBean.getPercentualDesconto2().toString().equals("0,00 %")?"":borderoBean.getPercentualDesconto2().toString()%>'
 				               						onFocus="javascript: prevFocus(this);configuraCampoDependente(this);"
																	onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.prazoLimite2Dia);"
																	onBlur="javascript: configuraCampoDependente(this);"/>
														</td>
 			                      <td class="textoTitulo" width="17%" align="left">Prazo Limite 2: </td>
			                      <td class="textoValor" width="26%" align="left">
			        				        <p:InputNumerico name="prazoLimite2Dia" maxlength="3" size="3"
			                						CLASS="inputtext" 
 				               						value ='<%=borderoBean.getPrazoLimite2Dia().toString()%>'			                									                						
 				               						onFocus="javascript: prevFocus(this);configuraCampoDependente(this);"
																	onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.percentualDesconto3);"
																	onBlur="javascript: configuraCampoDependente(this);"/>																	
														</td>
													</tr>
												  <tr class="line0">
			                      <td class="textoTitulo" width="17%" align="left">Desconto 3: </td>
			                      <td class="textoValor" width="26%" align="left">
			        				        <p:InputPercentual name="percentualDesconto3" maxlength="5" size="9"
			                						CLASS="inputtext" 
 				               						value ='<%=borderoBean.getPercentualDesconto3().toString().equals("0,00 %")?"":borderoBean.getPercentualDesconto3().toString()%>'
 				               						onFocus="javascript: prevFocus(this);configuraCampoDependente(this);"
																	onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.prazoLimite3Dia);"
																	onBlur="javascript: configuraCampoDependente(this);"/>																	
														</td>
 			                      <td class="textoTitulo" width="17%" align="left">Prazo Limite 3: </td>
			                      <td class="textoValor" width="26%" align="left">
			        				        <p:InputNumerico name="prazoLimite3Dia" maxlength="3" size="3"
			                						CLASS="inputtext" 
 				               						value ='<%=borderoBean.getPrazoLimite3Dia().toString()%>'			                									                						
 				               						onFocus="javascript: prevFocus(this);configuraCampoDependente(this);"
																	onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.multaPercentual);"
																	onBlur="javascript: configuraCampoDependente(this);"/>																	
														</td>
													</tr>
												  <tr class="line2">
			                      <td class="textoTitulo" width="17%" align="left">Multa: </td>
			                      <td class="textoValor" width="26%" align="left">
			        				        <p:InputPercentual name="multaPercentual" maxlength="5" size="9"
			                						CLASS="inputtext" 
 				               						value ='<%=borderoBean.getMultaPercentual().toString().equals("0,00 %")?cedGeralBean.getMulta().toString():borderoBean.getMultaPercentual().toString()%>'			       
 				               						onFocus="javascript: prevFocus(this);configuraCampoDependente(this);"
																	onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.prazoMultaDias);"
																	onBlur="javascript: configuraCampoDependente(this);"/>																	
														</td>
			                      <td class="textoTitulo" width="17%" align="left">Prazo para Multa: </td>
			                      <td class="textoValor" width="26%" align="left">
			        				        <p:InputNumerico name="prazoMultaDias" maxlength="3" size="3"
			                						CLASS="inputtext" 
 				               						value ='<%=borderoBean.getPrazoMultaDias().equals(new Long(0))?cedGeralBean.getPrazoMulta().toString():borderoBean.getPrazoMultaDias().toString()%>'			                									                						
 				               						onFocus="javascript: prevFocus(this);configuraCampoDependente(this);"
																	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.editaMsgFichaCompensacao);"
																	onBlur="javascript: configuraCampoDependente(this);"/>																	
														</td>
													</tr>
													
					<tr>
                      <td class="textoTitulo" width="17%">Tipo de Juros: </td>
				      <td width="26%" nowrap> 

										<select name="tipoJurosDia" ><option value="2" >2-Percentual ao dia (dias corridos)</option>
													<option value="3" selected="selected">3-Percentual ao mês (dias corridos)</option>
													<option value="4" >4-Percentual ao ano (dias corridos)</option>
													<option value="5" >5-Isento</option>
													<option value="7" >7-Percentual ao dia (dias úteis)</option>
													<option value="8" >8-Percentual ao mês (dias úteis)</option>
													<option value="9" >9-Percentual ao ano (dias úteis)</option>
										</select>                
                      </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Juros: </td>
                      <td class="textoValor" width="26%">
        				        <p:InputPercentual name="percentualJurosDia" maxlength="5" size="9" 
                						CLASS="inputtext" 
 				               			value ='<%=borderoBean.getPercentualJurosDia().toString().equals("0,00 %")?cedGeralBean.getPercentualJurosDia().toString():borderoBean.getPercentualJurosDia().toString()%>'
                						onFocus="javascript: prevFocus(this);"												
										onBlur="javascript: limpaPercentualZero(this);"/>  	
                      </td>
                      </tr>
												</table>
											</td>
										</tr>
										
										
			
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
    									<td colspan="4">
			              		<table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                      		<tr>
			                      <td class="textoTitulo" width="20%">Mensagem Ficha de Compensação: </td>
			                      <td class="textoValor" width="80%" colspan="3">
	                         		<textarea name="msgFichaCompensacao" cols="40" rows="2" readonly><%=borderoBean.getMsgFichaCompensacao()%></textarea>
															<s:Button name="editaMsgFichaCompensacao" value="Editar"  action="javascript:editaMensagem(msgFichaCompensacao, 40, 14, 23, 2);" />
			                      </td>
													</tr>
                    		</table>
                    	</td>
                    </tr>		
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
									</table>
                </s:Outline>
							</td>
						</tr>

            <tr> 
	            <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
	            <td align="right" colspan="4">
  	            <p align="center"> 
 		            	<s:Button name="Confirmar" action="javascript:formSubmit()"/>
		            	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
                </p>
              </td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    <script>
			function inicia() {
					configuraCampoDependente(document.frmMain.somenteProtestoCombo);

					<%//EAM - 03/05/05 - SISOT 64(Gestor)%>
					configuraCampoDependente(document.frmMain.modalidadeTituloCombo);

					configuraCampoDependente(document.frmMain.emissaoBloquetoCombo);
					configuraCampoDependente(document.frmMain.tipoJurosDia);
					configuraCampoDependente(document.frmMain.percentualDesconto1);
					configuraCampoDependente(document.frmMain.percentualDesconto2);
					configuraCampoDependente(document.frmMain.percentualDesconto3);
					configuraCampoDependente(document.frmMain.multaPercentual);
					configuraCampoDependente(document.frmMain.registrarSRcombo);
			}
	    
	    function formSubmit() {
				document.frmMain.modalidadeTitulo.value = document.frmMain.modalidadeTituloCombo.value;
				document.frmMain.moeda.value = document.frmMain.moedaCombo.value;
				document.frmMain.protestoAutomatico.value = document.frmMain.protestoAutomaticoCombo.value;
				document.frmMain.prazoProtDevol.value = document.frmMain.prazoProtDevolInput.value;
				document.frmMain.emissaoBloqueto.value = document.frmMain.emissaoBloquetoCombo.value;
				document.frmMain.somenteProtesto.value = document.frmMain.somenteProtestoCombo.value;
				document.frmMain.registrarSR.value = document.frmMain.registrarSRcombo.value;
				
  	    		<%//EAM - 03/05/05 - SISOT 64(Gestor)%>
				document.frmMain.endosso.value = document.frmMain.endossoCombo.value;
				document.frmMain.aceite.value = document.frmMain.aceiteCombo.value;
 
        if (validaSubmit()) {
	    		if (confirm(conf("100", "Borderô"))) {
		        document.frmMain.submit();
		      }
        }
	    }

	    function formSubmit_Voltar() {
    		if (confirm(conf("103"))) {
           document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_INCLUIR_FILTRO%>';
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
        }
      }  

			function foco(evento, campo1, campo2){
					habilitaCampoDependente(campo1,campo2);				
 					nextFocus(evento, campo1, campo2);
			}
			
			
			function configuraregistroSR(campo){
				if(campo == document.frmMain.registrarSRcombo){
					if(document.frmMain.registrarSRcombo.value == 'S'){
						
						document.frmMain.somenteProtestoCombo.value="N";
						document.frmMain.modalidadeTituloCombo.value="1";
						document.frmMain.endossoCombo.value="N";
						document.frmMain.aceiteCombo.value="2";
						document.frmMain.emissaoBloquetoCombo.value="1";
						document.frmMain.envioBloqueto.value="-1";
						
						document.frmMain.somenteProtestoCombo.disabled=true;
						document.frmMain.modalidadeTituloCombo.disabled=true;
						document.frmMain.endossoCombo.disabled=true;
						document.frmMain.aceiteCombo.disabled=true;
						document.frmMain.emissaoBloquetoCombo.disabled=true;
						document.frmMain.envioBloqueto.disabled=true;
						document.frmMain.prazoProtDevolInput.disabled=false;
						
					}else{
						
						document.frmMain.modalidadeTituloCombo.value="1";
						
						document.frmMain.somenteProtestoCombo.disabled=false;
						document.frmMain.modalidadeTituloCombo.disabled=false;
						document.frmMain.endossoCombo.disabled=false;
						document.frmMain.aceiteCombo.disabled=false;
						document.frmMain.emissaoBloquetoCombo.disabled=false;
						document.frmMain.envioBloqueto.disabled=true;
					}
				}
			}
			

			function configuraCampoDependente(campo){
				if(campo == document.frmMain.somenteProtestoCombo){
					if(document.frmMain.somenteProtestoCombo.value == 'S'){
							document.frmMain.registrarSRcombo.value="N";
							document.frmMain.registrarSRcombo.disabled=true;
							document.frmMain.prazoProtDevolInput.value='2';
							document.frmMain.prazoProtDevolInput.disabled=false;
							document.frmMain.emissaoBloquetoCombo.value='2';
							document.frmMain.emissaoBloquetoCombo.disabled=true;
							document.frmMain.modalidadeTituloCombo.value='1';
							document.frmMain.modalidadeTituloCombo.disabled=true;							
							document.frmMain.protestoAutomaticoCombo.value='S';
							document.frmMain.protestoAutomaticoCombo.disabled=true;
							document.frmMain.envioBloqueto.value='1';
							document.frmMain.envioBloqueto.disabled=true;																
							document.frmMain.percentualDesconto1.disabled=true;
							document.frmMain.percentualDesconto2.disabled=true;
							document.frmMain.percentualDesconto3.disabled=true;
							document.frmMain.multaPercentual.disabled=true;
							document.frmMain.percentualDesconto1.value='';
							document.frmMain.percentualDesconto2.value='';
							document.frmMain.percentualDesconto3.value='';
							document.frmMain.multaPercentual.value='';
							document.frmMain.prazoLimite1Dia.disabled=true;
							document.frmMain.prazoLimite2Dia.disabled=true;
							document.frmMain.prazoLimite3Dia.disabled=true;						
							document.frmMain.prazoMultaDias.disabled=true;
							document.frmMain.prazoLimite1Dia.value='';
							document.frmMain.prazoLimite2Dia.value='';
							document.frmMain.prazoLimite3Dia.value='';
							document.frmMain.prazoMultaDias.value='';																												
					}else{
							document.frmMain.prazoProtDevolInput.disabled=false;	
							document.frmMain.emissaoBloquetoCombo.disabled=false;
							document.frmMain.modalidadeTituloCombo.disabled=false;		
							document.frmMain.protestoAutomaticoCombo.disabled=false;
              				document.frmMain.percentualDesconto1.disabled=false;							
 							document.frmMain.multaPercentual.disabled=false;
 							document.frmMain.registrarSRcombo.disabled=false;
 							
                            //document.frmMain.emissaoBloquetoCombo.value='2';
							//document.frmMain.emissaoBloquetoCombo.disabled=true;
							if(document.frmMain.somenteProtestoCombo.value == 'N' &&	window.event.type == "change"){
								document.frmMain.prazoProtDevolInput.value='';
							}		
							configuraCampoDependente(document.frmMain.emissaoBloquetoCombo);
					}

					<%//EAM - 03/05/05 - SISOT 64(Gestor)%>					
					configuraCampoDependente(document.frmMain.modalidadeTituloCombo);	

				}//fim campo somenteProtesto
				
				<%//EAM - 03/05/05 - SISOT 64(Gestor)%>
				if(campo == document.frmMain.modalidadeTituloCombo){
					if(document.frmMain.somenteProtestoCombo.value != 'S'){
						if(document.frmMain.modalidadeTituloCombo.value == 2){ //2 - Sem registro
							document.frmMain.endossoCombo.value = 'N';
							document.frmMain.endossoCombo.disabled = true;
							document.frmMain.aceiteCombo.value = '2';//2 - Sem aceite	
							document.frmMain.aceiteCombo.disabled = true;
							document.frmMain.protestoAutomaticoCombo.value = 'N';
							document.frmMain.protestoAutomaticoCombo.disabled = true;
							document.frmMain.prazoProtDevolInput.value = ''; 
							document.frmMain.prazoProtDevolInput.disabled = true;
							document.frmMain.emissaoBloquetoCombo.value = '2';//2 -  Caixa
							document.frmMain.emissaoBloquetoCombo.disabled = true;
						}
						else if (document.frmMain.modalidadeTituloCombo.value == 3){ //3 - Caucionada)
							document.frmMain.endossoCombo.disabled = false;
							document.frmMain.aceiteCombo.disabled = false;
							document.frmMain.protestoAutomaticoCombo.disabled = false;
							document.frmMain.prazoProtDevolInput.disabled = false;
							document.frmMain.emissaoBloquetoCombo.value = '2';//2 -  Caixa
							document.frmMain.emissaoBloquetoCombo.disabled = true;
						}
						else{
							document.frmMain.endossoCombo.disabled = false;
							document.frmMain.aceiteCombo.disabled = false;
							document.frmMain.protestoAutomaticoCombo.disabled = false;
							document.frmMain.prazoProtDevolInput.disabled = false;
							document.frmMain.emissaoBloquetoCombo.disabled = false;
						}
						configuraCampoDependente(document.frmMain.emissaoBloquetoCombo);
					}
				}
				
					if (document.frmMain.somenteProtestoCombo.value == 'S' && document.frmMain.modalidadeTituloCombo.value != 2){
						document.frmMain.endossoCombo.disabled = false;
						document.frmMain.aceiteCombo.disabled = false;
					}


				if(campo == document.frmMain.emissaoBloquetoCombo){
					if(document.frmMain.emissaoBloquetoCombo.value == 1){
							document.frmMain.envioBloqueto.value='-1';
							document.frmMain.envioBloqueto.disabled=true;
					}
					else{
							document.frmMain.envioBloqueto.disabled=false;					
					}
				
				}//fim campo emissaoBloquetoCombo				
			
				/*
				if(campo == document.frmMain.tipoJurosDia){
					if(document.frmMain.tipoJurosDia.value == 0){
							document.frmMain.percentualJurosDia.value='';
							document.frmMain.percentualJurosDia.disabled=true;
					}
					else{
							document.frmMain.percentualJurosDia.disabled=false;					
					}
				
				}
				*///fim campo percentualJurosDia


				if(campo == document.frmMain.percentualDesconto1){
					//necessário para poder aproveitar a função desabilitaCampoDependente visto que os campos de valor e datas foram removidos.
					campo2 = campo;
					habilitaCampoDependente(campo,document.frmMain.prazoLimite1Dia);
					habilitaCampoDependente(campo,document.frmMain.percentualDesconto2);
					desabilitaCampoDependente(campo, campo2, document.frmMain.prazoLimite1Dia);
					desabilitaCampoDependente(campo, campo2, document.frmMain.percentualDesconto2);
					desabilitaCampoDependente(campo, campo2, document.frmMain.prazoLimite2Dia);
					desabilitaCampoDependente(campo, campo2, document.frmMain.percentualDesconto3);
					desabilitaCampoDependente(campo, campo2, document.frmMain.prazoLimite3Dia);

				}//fim campo percentualDesconto1

				if(campo == document.frmMain.percentualDesconto2){
					campo2 = campo;
					habilitaCampoDependente(campo,document.frmMain.prazoLimite2Dia);
					habilitaCampoDependente(campo,document.frmMain.percentualDesconto3);
					desabilitaCampoDependente(campo, campo2, document.frmMain.prazoLimite2Dia);
					desabilitaCampoDependente(campo, campo2, document.frmMain.percentualDesconto3);
					desabilitaCampoDependente(campo, campo2, document.frmMain.prazoLimite3Dia);

				}//fim campo percentualDesconto2

				if(campo == document.frmMain.percentualDesconto3){
					campo2 = campo;
					habilitaCampoDependente(campo,document.frmMain.prazoLimite3Dia);
					desabilitaCampoDependente(campo, campo2, document.frmMain.prazoLimite3Dia);

				}//fim campo percentualDesconto3

				if(campo == document.frmMain.multaPercentual){
					campo2 = campo;
					habilitaCampoDependente(campo,document.frmMain.prazoMultaDias);
					desabilitaCampoDependente(campo, campo2, document.frmMain.prazoMultaDias);

				}//fim campo multaPercentual
			}
			
			
			function validaSubmit() {

		    if(!validaComboObrigatorio(document.frmMain.modalidadeTitulo, 'Modalidade Titulo')){
				  return false;
		    }
		    if(!validaCampoObrigatorio(document.frmMain.quantidade, 'Quantidade')){
				  return false;
		    }
		    //if(!validaCampoObrigatorio(document.frmMain.valor, 'Valor')){
			//	  return false;
		    //}
		    if(!validaComboObrigatorio(document.frmMain.endossoCombo, 'Endosso')){
				  return false;
		    }
		    if(!validaComboObrigatorio(document.frmMain.especieTitulo, 'Espécie de Titulo')){
				  return false;
		    }
		    if(!validaComboObrigatorio(document.frmMain.aceiteCombo, 'Aceite')){
				  return false;
		    }		    
 		    if(!validaComboObrigatorio(document.frmMain.moeda, 'Moeda')){
				  return false;
		    }
		    if(!validaComboObrigatorio(document.frmMain.protestoAutomatico, 'Protesto Automático')){
				  return false;
		    }		    

 				<%//EAM - 03/05/05 - SISOT 64(Gestor)%>
				if(document.frmMain.modalidadeTitulo.value != 2){
			    if(!validaCampoObrigatorio(document.frmMain.prazoProtDevolInput, 'Prazo de Protesto/Devolução')){
					  return false;
			    }		    
				}
		    
		    if(!validaComboObrigatorio(document.frmMain.emissaoBloqueto, 'Emissao de Boleto')){
				  return false;
		    }		    
				if(document.frmMain.emissaoBloqueto.value != 1){

					    if(!validaComboObrigatorio(document.frmMain.envioBloqueto, 'Envio de Boleto')){
							  return false;
					    }
						

			  }
		    if(!validaComboObrigatorio(document.frmMain.tipoJurosDia, 'Tipo Juros Dia')){
				  return false;
		    }

				// if(!validaValorZero(document.frmMain.valor, 'Valor')){
				//  return false;				
				// }
				
		    if(!validaIntervalo(document.frmMain.quantidade, 'Quantidade', '1', '25')){
				  return false;
		    }		    	
		    <%//EAM - 03/05/05 - SISOT 64(Gestor)%>
				if(document.frmMain.modalidadeTitulo.value != 2){
			    if (document.frmMain.somenteProtestoCombo.value == "N"){
				    if(document.frmMain.protestoAutomatico.value == "S"){
				    	if(!validaIntervalo(document.frmMain.prazoProtDevolInput, 'Prazo de Protesto/Devolução', '2', '90')){
						  	return false;
				    	}		    	
				    }
				    if(document.frmMain.protestoAutomatico.value == "N"){
				    	if(!validaIntervalo(document.frmMain.prazoProtDevolInput, 'Prazo de Protesto/Devolução', '0', '999')){
						  	return false;
				    	}		    	
				    }
			    }
			  }
			  <%//EAM - 25/08 - SISOT 135/139 - INI%>
				if(document.frmMain.envioBloqueto.value == '3'){
				  if(document.frmMain.modalidadeTituloCombo.value == '2'){
						emiteMensagemCombo(document.frmMain.modalidadeTituloCombo, document.frmMain.envioBloqueto, 'Modalidade Titulo', 'Envio do Boleto' );
						return false;
					}			  
				  if(document.frmMain.protestoAutomaticoCombo.value == 'S'){
						emiteMensagemCombo(document.frmMain.protestoAutomaticoCombo, document.frmMain.envioBloqueto, 'Protesto Automático', 'Envio do Boleto' );
						return false;
					}			  
			  }
			  <%//EAM - 25/08 - SISOT 139 - FIM%>	
			  /*
		   	if(document.frmMain.tipoJurosDia.value == 0){
					if(trim(document.frmMain.percentualJurosDia.value) != ''){
						if(!validaPercentualZero(document.frmMain.percentualJurosDia, 'Percentual Juros')){
					  	return false;				
						}
					}
			  }
			  */
		   	if(document.frmMain.percentualDesconto1.value != ''){
		   		if(!validaPercentualZero(document.frmMain.percentualDesconto1, 'Desconto 1')){
					  return false;				
					}
		   		if(!validaPercentualCem(document.frmMain.percentualDesconto1, 'Desconto 1')){
					  return false;				
					}
		   		if(!validaCampoObrigatorio(document.frmMain.prazoLimite1Dia,'Prazo Limite 1')){
		   			return false;
		   		}
		   	}	   	
		   	if(document.frmMain.percentualDesconto2.value != ''){
		   		if(!validaPercentualZero(document.frmMain.percentualDesconto2, 'Desconto 2')){
					  return false;				
					}
		   		if(!validaPercentualCem(document.frmMain.percentualDesconto2, 'Desconto 2')){
					  return false;				
					}
		   		if(!validaCampoObrigatorio(document.frmMain.prazoLimite2Dia, 'Prazo Limite 2')){
		   			return false;
		   		}
					if(!comparaPercentual(document.frmMain.percentualDesconto1, document.frmMain.percentualDesconto2, ">")){
						msg('007','Desconto 2', 'Desconto 1');
						return false;
					}
					if(!comparaNumero(document.frmMain.prazoLimite1Dia, document.frmMain.prazoLimite2Dia, ">")){
						msg('007','Prazo Limite 2', 'Prazo Limite 1');
						return false;
					}
		
		   	}	   	
		   	if(document.frmMain.percentualDesconto3.value != ''){
		   		if(!validaPercentualZero(document.frmMain.percentualDesconto3, 'Desconto 3')){
					  return false;				
					}
		   		if(!validaPercentualCem(document.frmMain.percentualDesconto3, 'Desconto 3')){
					  return false;				
					}
		   		if(!validaCampoObrigatorio(document.frmMain.prazoLimite3Dia,'Prazo Limite 3')){
		   			return false;
		   		}
					if(!comparaNumero(document.frmMain.prazoLimite2Dia, document.frmMain.prazoLimite3Dia, ">")){
						msg('007','Prazo Limite 3', 'Prazo Limite 2');
						return false;
					}
					if(!comparaPercentual(document.frmMain.percentualDesconto2, document.frmMain.percentualDesconto3, ">")){
						msg('007','Desconto 3', 'Desconto 2');
						return false;
					}
				}	   			    
		   	if(document.frmMain.multaPercentual.value != ''){
		   		if(!validaPercentualZero(document.frmMain.multaPercentual, 'Multa')){
					  return false;				
					}
		   		if(!validaCampoObrigatorio(document.frmMain.prazoMultaDias,'Prazo para Multa')){
		   			return false;
		   		}
		   		if(!validaMenorIgual(document.frmMain.prazoMultaDias, 'Prazo para Multa', 0)){
					  return false;				
					}
		   			if(document.frmMain.modalidadeTituloCombo.value!='2'){
						if(document.frmMain.prazoMultaDias != ''){
							if(parseInt(document.frmMain.prazoMultaDias.value) > parseInt(document.frmMain.prazoProtDevolInput.value)){
								msg('007'	, 'Prazo para Multa', 'Prazo de Protesto/Devolução');
						  	return false;				
							}
						}	   	
		   				
		   			}
		   	}	   			    
		    return true;
		  }			
	    
	    //Inicio Implementação TextArea
	    function editaMensagem( campo, colunas, altura, largura, linhas) {
	    	var linhas = linhas;
	    	var obj = campo;
				var resposta = showModalDialog('<%=Paths.getRootForDynamicContent()%>/jump/edita_mensagem.jsp?linhas='+linhas+'&colunas='+colunas, obj.value, "dialogHeight:"+altura+"; dialogWidth:"+largura+"; center: yes; help:no; resizable:yes; scroll:yes; status:no");
				if (resposta != null) {
					obj.value = resposta;
				}
	    }
			<%//EAM - 25/08 - SISOT 135/139 - INI%>
			function emiteMensagemCombo(campo1, campo2, nomeCampo1, nomeCampo2 ){
				<%//Obter a descrição dos itens selecionados %>
				var campo1Desc = campo1.options[campo1.selectedIndex].text;
				var campo2Desc = campo2.options[campo2.selectedIndex].text;
				msg('065', nomeCampo1, campo1Desc, campo2Desc, false, nomeCampo2);
		  }
		  <%//EAM - 25/08 - SISOT 135 - FIM%>						
    </script>
  </s:FormStrategy>
</p:Document>
</html>