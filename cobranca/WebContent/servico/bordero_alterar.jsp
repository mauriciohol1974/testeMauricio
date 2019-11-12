<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bordero_alterar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 22/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoTituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BorderoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>


<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(BorderoEstrategia.USUARIOLDAP_BEAN);
	BorderoBean borderoBean = (session.getAttribute(BorderoEstrategia.DATA_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(BorderoEstrategia.DATA_BEAN));
	BorderoTituloBean borderoInfoBean = (session.getAttribute(TituloEstrategia.BORDERO_INFO_BEAN)==null?new BorderoTituloBean():(BorderoTituloBean)session.getAttribute(TituloEstrategia.BORDERO_INFO_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia='<%=BorderoEstrategia.STRATEGY_ALTERAR_FINALIZAR%>' fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Manter Borderô >> Alterar"/>    
		<input type="hidden" name="codigoCedente" value='<%=borderoBean.getCodigoCedente()%>'>
		<input type="hidden" name="codigoBordero" value='<%=borderoBean.getCodigoBordero()%>'>
		<input type="hidden" name="registrarSR" value='<%=borderoBean.getRegistrarSR()%>'>
		<input type="hidden" name="somenteProtesto" value='<%=borderoBean.getSomenteProtesto()%>'>
		<input type="hidden" name="modalidadeTitulo">
		<input type="hidden" name="dataMovimento" value='<%=borderoBean.getDataMovimentoFormatada().toString()%>'>
		<input type="hidden" name="vinculacaoPV" value='<%=borderoBean.getVinculacaoPV()%>'>
		<input type="hidden" name="endosso">
		<input type="hidden" name="especieTitulo">
		<input type="hidden" name="aceite">
		<input type="hidden" name="moeda">
		<input type="hidden" name="protestoAutomatico">
		<input type="hidden" name="prazoProtDevol" value='<%=borderoBean.getPrazoProtDevol().toString()%>'>
		<input type="hidden" name="emissaoBloqueto" value='<%=borderoBean.getEmissaoBloqueto().toString()%>'>
		<input type="hidden" name="envioBloqueto" value= '<%=borderoBean.getEnvioBloqueto().toString()%>'>
		
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
  
              <td class="textoTitulo" width="17%">Borderô: </td>
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoBordero().equals( new Long(0))?"":borderoBean.getCodigoBordero().toString()%></td>

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
                           <td class="textoValor" width="26%"><s:ComboSimNao name="registrarSRcombo" selectedValue='<%=borderoBean.getRegistrarSR().trim().equals("")?"N":borderoBean.getRegistrarSR()%>' disabled="true"/></td>                           
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Somente para Protesto: </td>
                      <td class="textoValor" width="26%">
                      <%if (borderoBean.getSomenteProtesto().equalsIgnoreCase("S")){ %>
                      	SIM
                      <%}else{ %>
                        NÃO
                      <%} %>
                        <input type="hidden" name="somenteProtestoCombo" value="'<%=borderoBean.getSomenteProtesto()%>" />
                   
                       <td class="textoTitulo" width="17%">Modalidade Titulo: </td>
                      <td class="textoValor" width="26%">
                        <s:ComboModalidadeTitulo name="modalidadeTituloCombo" selectedValue='<%=borderoBean.getModalidadeTitulo().toString()%>'
                 						disabled='<%=borderoInfoBean.getTitulosIncluidos().equals(new Long(0))?"false":"true"%>'
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
                						value='<%=borderoBean.getQuantidade().toString()%>'
                						onFocus="javascript: prevFocus(this);"
														onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.valor);"/>        				       
                      </td>

                      <td nowrap class="textoTitulo" width="17%">Valor: </td>
				              <td class="textoValor" width="26%" nowrap> 
        				        <p:InputCurrency name="valor" maxlength="17" size="29" 
                						CLASS="inputtext"
                						value='<%=borderoBean.getValor().toString()%>' 
                						onFocus="javascript: prevFocus(this);"
														onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.endossoCombo);"/> 
                      </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Endosso: </td>
                      <td class="textoValor" width="26%">
         									<s:ComboSimNao name="endossoCombo" selectedValue='<%=borderoBean.getEndosso()%>'
         										disabled='<%=borderoInfoBean.getTitulosIncluidos().equals(new Long(0))?"false":"true"%>'
         									/> 
                      </td>

                      <td class="textoTitulo" width="17%">Espécie de Título: </td>
                      <td class="textoValor" width="26%">
                       	<s:ComboEspecieTitulo name="especieTituloCombo" selectedValue='<%=borderoBean.getEspecieTitulo().toString()%>' branco="true"
                       		disabled='<%=borderoInfoBean.getTitulosIncluidos().equals(new Long(0))?"false":"true"%>'
                       	/>
                      </td>
                    </tr>
                    
                    <tr>
                      <td class="textoTitulo" width="17%">Aceite: </td>
                      <td class="textoValor" width="26%">
                        <s:ComboAceite name="aceiteCombo" selectedValue='<%=borderoBean.getAceite()%>' branco="true" filtroBordero="true"
                        	disabled='<%=borderoInfoBean.getTitulosIncluidos().equals(new Long(0))?"false":"true"%>'
                        />
                      </td>

                      <td class="textoTitulo" width="17%">Moeda: </td>
                      <td class="textoValor" width="26%">
												<s:ComboMoeda name="moedaCombo" selectedValue='<%=borderoBean.getMoeda().toString()%>' disabled="true"/>
											</td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Protesto Automático: </td>
				              <td width="26%" nowrap> 
													<s:ComboSimNao name="protestoAutomaticoCombo" selectedValue='<%=borderoBean.getProtestoAutomatico()%>'
														disabled='<%=borderoInfoBean.getTitulosIncluidos().equals(new Long(0))?"false":"true"%>'
													/>                       
                      </td>
                      <td nowrap class="textoTitulo" width="17%">Prazo de Protesto/Devolução: </td>
				              <td class="textoValor" width="26%" nowrap> <%=borderoBean.getPrazoProtDevol().toString()%>
        				        
                      </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Emissão Boleto: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getEmissaoBloquetoTexto()%>
													      
                      </td>
                      <td class="textoTitulo" width="17%">Envio do Boleto: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getEnvioBloquetoTexto()%>
  
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
 				               						value ='<%=borderoBean.getMultaPercentual().toString().equals("0,00 %")?"":borderoBean.getMultaPercentual().toString()%>'			       
 				               						onFocus="javascript: prevFocus(this);configuraCampoDependente(this);"
																	onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.prazoMultaDias);"
																	onBlur="javascript: configuraCampoDependente(this);"/>																	
														</td>
			                      <td class="textoTitulo" width="17%" align="left">Prazo para Multa: </td>
			                      <td class="textoValor" width="26%" align="left">
			        				        <p:InputNumerico name="prazoMultaDias" maxlength="3" size="3"
			                						CLASS="inputtext" 
 				               						value ='<%=borderoBean.getPrazoMultaDias().equals(new Long(0))?"":borderoBean.getPrazoMultaDias().toString()%>'			                									                						
 				               						onFocus="javascript: prevFocus(this);configuraCampoDependente(this);"
																	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.editaMsgFichaCompensacao);"
																	onBlur="javascript: configuraCampoDependente(this);"/>																	
														</td>
													</tr>
													
													
					<tr>
                      <td class="textoTitulo" width="17%">Tipo de Juros: </td>
				              <td width="26%" nowrap> 
										
										<select name="tipoJurosDia" >
													<option value="2" <%=borderoBean.getTipoJurosDia().toString().equals("2") ? "selected='selected'" : "" %>  >2-Percentual ao dia (dias corridos)</option>
													<option value="3" <%=borderoBean.getTipoJurosDia().toString().equals("3") ? "selected='selected'" : "" %>>3-Percentual ao mês (dias corridos)</option>
													<option value="4" <%=borderoBean.getTipoJurosDia().toString().equals("4") ? "selected='selected'" : "" %>>4-Percentual ao ano (dias corridos)</option>
													<option value="5" <%=borderoBean.getTipoJurosDia().toString().equals("5") ? "selected='selected'" : "" %>>5-Isento</option>
													<option value="7" <%=borderoBean.getTipoJurosDia().toString().equals("7") ? "selected='selected'" : "" %>>7-Percentual ao dia (dias úteis)</option>
													<option value="8" <%=borderoBean.getTipoJurosDia().toString().equals("8") ? "selected='selected'" : "" %>>8-Percentual ao mês (dias úteis)</option>
													<option value="9" <%=borderoBean.getTipoJurosDia().toString().equals("9") ? "selected='selected'" : "" %>>9-Percentual ao ano (dias úteis)</option>
										</select>           					
                        						                     
                      </td>
                     </tr>
                     <tr>
                      <td class="textoTitulo" width="17%">Percentual Juros : </td>
                      <td class="textoValor" width="26%">
        				        <p:InputPercentual name="percentualJurosDia" maxlength="5" size="9" 
                						CLASS="inputtext" 
 				               			value ='<%=borderoBean.getPercentualJurosDia().toString().equals("0,00 %")?"":borderoBean.getPercentualJurosDia().toString()%>'
                						onFocus="javascript: prevFocus(this);"
														onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.percentualDesconto1);"
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
 		            	<s:Button name="Confirmar" action="javascript:formSubmit()" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.alterar"/>
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
					
					
					<%//EAM - 03/05/05 - SISOT 64(Gestor)%>
					configuraCampoDependente(document.frmMain.modalidadeTituloCombo);

										
					configuraCampoDependente(document.frmMain.tipoJurosDia);
					configuraCampoDependente(document.frmMain.percentualDesconto1);
					configuraCampoDependente(document.frmMain.percentualDesconto2);
					configuraCampoDependente(document.frmMain.percentualDesconto3);
					configuraCampoDependente(document.frmMain.multaPercentual);
			}
	    
	    function formSubmit() {
				
				document.frmMain.modalidadeTitulo.value = document.frmMain.modalidadeTituloCombo.value;
				document.frmMain.moeda.value = document.frmMain.moedaCombo.value;
				document.frmMain.endosso.value = document.frmMain.endossoCombo.value;
				document.frmMain.especieTitulo.value = document.frmMain.especieTituloCombo.value;
				document.frmMain.aceite.value = document.frmMain.aceiteCombo.value;
				document.frmMain.protestoAutomatico.value = document.frmMain.protestoAutomaticoCombo.value;
				
				
				<%//EAM - 03/05/05 - SISOT 64(Gestor)%>
				document.frmMain.endosso.value = document.frmMain.endossoCombo.value;
				document.frmMain.aceite.value = document.frmMain.aceiteCombo.value;


        if (validaSubmit()) {
	    		if (confirm(conf("101", "Borderô"))) {
		        document.frmMain.submit();
		      }
        }
	    }

	    function formSubmit_Voltar() {
    		if (confirm(conf("103"))) {
           document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_MANTER_LISTAR%>';
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
        }
      }  

			function foco(evento, campo1, campo2){
					habilitaCampoDependente(campo1,campo2);				
 					nextFocus(evento, campo1, campo2);
			}

			function configuraCampoDependente(campo){

				
			
				
				if(campo == document.frmMain.tipoJurosDia){
					if(document.frmMain.tipoJurosDia.value == 0){
							document.frmMain.percentualJurosDia.value='';
							document.frmMain.percentualJurosDia.disabled=true;
					}
					else{
							document.frmMain.percentualJurosDia.disabled=false;					
					}
				
				}//fim campo percentualJurosDia

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
				
				
				if(campo == document.frmMain.modalidadeTituloCombo){
					if(document.frmMain.somenteProtesto.value != 'S'){
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
			}
			
			
			function validaSubmit() {
		  
		    if(!validaCampoObrigatorio(document.frmMain.valor, 'Valor')){
				  return false;
		    }
		   
		    if(!validaComboObrigatorio(document.frmMain.tipoJurosDia, 'Tipo Juros Dia')){
				  return false;
		    }

				//if(!validaValorZero(document.frmMain.valor, 'Valor')){
				//  return false;				
				//}    
	    
		    if(!validaIntervalo(document.frmMain.quantidade, 'Quantidade', '1', '25')){
				  return false;
		    }		    	
		    <%//EAM - 03/05/05 - SISOT 64(Gestor)%>
				if(document.frmMain.modalidadeTitulo.value != 2){		    
			    if (document.frmMain.somenteProtesto.value == "N"){
				    if(document.frmMain.protestoAutomatico.value == "S"){
				    	if(!validaIntervalo(document.frmMain.prazoProtDevol, 'Prazo de Protesto/Devolução', '2', '90')){
						  	return false;
				    	}		    	
				    }
				    if(document.frmMain.protestoAutomatico.value == "N"){
				    	if(!validaIntervalo(document.frmMain.prazoProtDevol, 'Prazo de Protesto/Devolução', '0', '999')){
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
		   	if(document.frmMain.tipoJurosDia.value == 0){
					if(trim(document.frmMain.percentualJurosDia.value) != ''){
						if(!validaPercentualZero(document.frmMain.percentualJurosDia, 'Percentual Juros ')){
					  	return false;				
						}
					}
			  }
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
						if(parseInt(document.frmMain.prazoMultaDias.value) > parseInt(document.frmMain.prazoProtDevol.value)){
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