<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: soagtit_consultar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 20/10/2005
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.SolicitacaoAgendamentoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.SolicitacaoAgendamentoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SolicitacaoAgendamentoEstrategia.USUARIOLDAP_BEAN);
	SolicitacaoAgendamentoBean solicitacaoBean = (session.getAttribute(SolicitacaoAgendamentoEstrategia.DATA_BEAN)==null?new SolicitacaoAgendamentoBean():(SolicitacaoAgendamentoBean)session.getAttribute(SolicitacaoAgendamentoEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(SolicitacaoAgendamentoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(SolicitacaoAgendamentoEstrategia.CEDENTE_CABECALHO_BEAN));
	
	String strtipoSMS = "";
	if (solicitacaoBean.getTipoSMS().equalsIgnoreCase("01")){
		strtipoSMS = "Informativa";
	}else if (solicitacaoBean.getTipoSMS().equalsIgnoreCase("02")){
		strtipoSMS = "Representação Numérica";
	}else if (solicitacaoBean.getTipoSMS().equalsIgnoreCase("03")){
		strtipoSMS = "PEC";
	}else {
		strtipoSMS = "";
	}
%>

<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=SolicitacaoAgendamentoEstrategia.STRATEGY_ALTERAR_INICIAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=SolicitacaoAgendamentoEstrategia.PAGE_TITLE_CONSULTAR%>"/>    
 		<input type="hidden" name="moeda">
		<input type="hidden" name="codigoCedente" value='<%=solicitacaoBean.getCodigoCedente()%>'>
		<input type="hidden" name="codigoBancoSacado" value='<%=solicitacaoBean.getCodigoBancoSacado()%>'>
		<input type="hidden" name="registro">
		<input type="hidden" name="indicadorSolicitacao" value='<%=solicitacaoBean.getIndicadorSolicitacao()%>'>
		<input type="hidden" name="nomeBancoSacado" value='<%=solicitacaoBean.getNomeBancoSacado()%>'>
		<input type="hidden" name="dataSolicitacao" value='<%=solicitacaoBean.getDataSolicitacaoFormatada()%>'>

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
  	          <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
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
               <td class="textoTitulo" width="17%">Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getCodigoBancoSacado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Nome Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getNomeBancoSacado()%></td> 
              <td class="textoTitulo" width="17%">Tipo de Requisição: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getIndicadorSolicitacaoTexto()%></td> 
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo"><%=solicitacaoBean.getIndicadorSolicitacaoTextoInfinitivo()%> Emissão de Títulos:
                <hr>
              </td>
            </tr>
            
						<tr>
              <td class="textoTitulo" width="17%">Registro: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getRegistro().trim().equals("S")?"SIM":"NAO"%></td>
              <td class="textoTitulo" width="17%">Espécie: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getEspecieTexto()%></td>
						</tr>
						 
						<tr>
              <td class="textoTitulo" width="17%">Forma Obtenção Valor Título: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getFormaObtencaoValorTexto()%></td>	
              <td class="textoTitulo" width="17%">Valor: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getValorSolicitacao().toString().equals("R$ 0,00")?"":solicitacaoBean.getValorSolicitacao().toString()%></td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%" nowrap >Forma Obtenção Envio Boleto: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getFormaObtencaoBloquetoTexto()%></td>	
              <td class="textoTitulo" width="17%">Envio do Boleto: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getEnvioBloquetoTexto()%></td>
						</tr>
						
			<tr>
			  <td class="textoTitulo" width="17%" nowrap>&nbsp;</td>
              		<td width="26%">&nbsp;</td>
              <td class="textoTitulo" width="17%" nowrap>Tipo de SMS: </td>
              		<td width="26%"><%=strtipoSMS %></td>	
			 </tr>
						
						<tr>
              <td class="textoTitulo" width="17%">Endosso: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getEndosso().trim().equals("S")?"SIM":"NAO"%></td>
              <td class="textoTitulo" width="17%">Aceite: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getAceiteTexto()%></td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Protesto Automático: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getProtestoAutomatico().trim().equals("S")?"SIM":"NAO"%></td>
              <td class="textoTitulo" width="17%">Prazo Protesto/Devolução: </td>
              <%String prazoProtDev = "";
              if(solicitacaoBean.getRegistro().trim().equals("S")){
	              prazoProtDev =solicitacaoBean.getPrazoProtestoDevolucao().toString();
              }
              %>
              <td class="textoValor" width="26%"><%=prazoProtDev%></td>
						</tr>
						<tr>
							<td class="textoTitulo" width="17%">Moeda: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getMoedaTexto()%></td>						
            <%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
							<td class="textoTitulo" width="17%">Data de Vencimento: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getDataVencimentoFormatada().equals("01/01/0001")?"":solicitacaoBean.getDataVencimentoFormatada()%></td>
						<%}else{%>
							<td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            <%}%>
            </tr>
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
		 					      <td nowrap width="8%" align="left">Percentual</td>
								    <td nowrap width="18%" align="left">Valor</td>
								    <td nowrap width="17%" align="center">&nbsp;</td>
		 						    <td nowrap width="8%" align="left">Dias </td>
		 						    <td nowrap width="18%" align="left">
 											<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
 												Data
											<%}%>
										</td>
								  </tr>
								  
								  <tr>
										
										<td nowrap width="17%" class="textoTitulo">Tipo de Desconto:</td>
											<td>
											<select name="tipoDesconto" disabled="disabled">
													<option value="0" <%=solicitacaoBean.getTipoDesconto().equals("0") ? "selected='selected'" : ""%>>0-Isento</option>
												<option value="1" <%=solicitacaoBean.getTipoDesconto().equals("1") ? "selected='selected'" : ""%>>1-Valor Fixo até a data informada</option>
												<option value="2" <%=solicitacaoBean.getTipoDesconto().equals("2") ? "selected='selected'" : ""%>>2-Percentual até a data informada</option>
												<option value="3" <%=solicitacaoBean.getTipoDesconto().equals("3") ? "selected='selected'" : ""%>>3-Valor por antecipação dia corrido</option>
												<option value="4" <%=solicitacaoBean.getTipoDesconto().equals("4") ? "selected='selected'" : ""%>>4-Valor por antecipação dia útil</option>
												<option value="5" <%=solicitacaoBean.getTipoDesconto().equals("5") ? "selected='selected'" : ""%>>5-Percentual por antecipação dia corrido</option>
												<option value="6" <%=solicitacaoBean.getTipoDesconto().equals("6") ? "selected='selected'" : ""%>>6-Percentual por antecipação dia útil</option>
												
											</select>
											</td>	
								  </tr>
								  
								  <tr>
                    <td class="textoTitulo" width="19%" align="left">Desconto 1: </td>
                    <td class="textoValor" width="8%" align="left"><%=solicitacaoBean.getPercentualDesconto1().toString().equals("0,00 %")?"":solicitacaoBean.getPercentualDesconto1().toString()%></td>
										<td class="textoValor" width="24%" align="left"><%=solicitacaoBean.getValorDesconto1().toString().equals("R$ 0,00")?"":solicitacaoBean.getValorDesconto1().toString()%></td>
                    <td class="textoTitulo" width="17%" align="left">Prazo Limite 1: </td>
                    <td class="textoValor" width="8%" align="left">
	                    <%if(!solicitacaoBean.getPercentualDesconto1().toString().equals("0,00 %") || !solicitacaoBean.getValorDesconto1().toString().equals("R$ 0,00")){%>                                        
  		                  <%=solicitacaoBean.getPrazoDesconto1().toString()%>
                    	<%}%>
	                  </td>
										<td class="textoValor" width="18%" align="left">
											<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
												<%=solicitacaoBean.getDataDesconto1Formatada()%>
											<%}%>	
                    </td>
									</tr> 
								  <tr>
                    <td class="textoTitulo" width="19%" align="left">Desconto 2: </td>
                    <td class="textoValor" width="8%" align="left"><%=solicitacaoBean.getPercentualDesconto2().toString().equals("0,00 %")?"":solicitacaoBean.getPercentualDesconto2().toString()%></td>
										<td class="textoValor" width="24%" align="left"><%=solicitacaoBean.getValorDesconto2().toString().equals("R$ 0,00")?"":solicitacaoBean.getValorDesconto2().toString()%></td>
                    <td class="textoTitulo" width="17%" align="left">Prazo Limite 2: </td>
                    <td class="textoValor" width="8%" align="left">
                   	 <%if(!solicitacaoBean.getPercentualDesconto2().toString().equals("0,00 %") || !solicitacaoBean.getValorDesconto2().toString().equals("R$ 0,00")){%>
                     		<%=solicitacaoBean.getPrazoDesconto2().toString()%>
                   	 <%}%>
                    </td>
										<td class="textoValor" width="18%" align="left">
											<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
	      				        <%=solicitacaoBean.getDataDesconto2Formatada()%>
											<%}%>															
                    </td>
									</tr>
								  <tr>
                    <td class="textoTitulo" width="19%" align="left">Desconto 3: </td>
                    <td class="textoValor" width="8%" align="left"><%=solicitacaoBean.getPercentualDesconto3().toString().equals("0,00 %")?"":solicitacaoBean.getPercentualDesconto3().toString()%></td>
										<td class="textoValor" width="24%" align="left"><%=solicitacaoBean.getValorDesconto3().toString().equals("R$ 0,00")?"":solicitacaoBean.getValorDesconto3().toString()%></td>
                    <td class="textoTitulo" width="17%" align="left">Prazo Limite 3: </td>
                    <td class="textoValor" width="8%" align="left">
	                    <%if(!solicitacaoBean.getPercentualDesconto3().toString().equals("0,00 %") || !solicitacaoBean.getValorDesconto3().toString().equals("R$ 0,00")){%>                    
  		                  <%=solicitacaoBean.getPrazoDesconto3().toString()%>
	                    <%}%>
                    </td>
										<td class="textoValor" width="18%" align="left">
											<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
	      				        <%=solicitacaoBean.getDataDesconto3Formatada()%>										
											<%}%>															
                    </td>
									</tr>
								  <tr>
                    <td class="textoTitulo" width="19%" align="left">Multa: </td>
                    <td class="textoValor" width="8%" align="left"><%=solicitacaoBean.getPercentualMulta().toString().equals("0,00 %")?"":solicitacaoBean.getPercentualMulta().toString()%></td>
										<td class="textoValor" width="24%" align="left"><%=solicitacaoBean.getValorMulta().toString().equals("R$ 0,00")?"":solicitacaoBean.getValorMulta().toString()%></td>
                    <td class="textoTitulo" width="17%" align="left">Prazo para Multa: </td>
                    <td class="textoValor" width="8%" align="left"><%=solicitacaoBean.getPrazoMulta().equals(new Long(0))?"":solicitacaoBean.getPrazoMulta().toString()%></td>
										<td class="textoValor" width="18%" align="left">
											<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
	      				        <%=solicitacaoBean.getDataMultaFormatada().equals("")?"":solicitacaoBean.getDataMultaFormatada().toString()%>
											<%}%>															
                    </td>
									</tr>
	            	
	            	
	            		<tr>
									<td class="textoTitulo" width="17%" >Tipo de Juros :</td>
									<td width="26%" nowrap colspan="3">
										
										<select name="tipoJuroDia" disabled="disabled">
												<option value="1" <%=solicitacaoBean.getTipoJuroDia().toString().equals("1") ? "selected='selected'" : "" %>>1-Valor (dias corridos)</option>
												<option value="2" <%=solicitacaoBean.getTipoJuroDia().toString().equals("2") ? "selected='selected'" : "" %>>2-Percentual ao dia (dias corridos)</option>
												<option value="3" <%=solicitacaoBean.getTipoJuroDia().toString().equals("3") ? "selected='selected'" : "" %>>3-Percentual ao mês (dias corridos)</option>
												<option value="4" <%=solicitacaoBean.getTipoJuroDia().toString().equals("4") ? "selected='selected'" : "" %>>4-Percentual ao ano (dias corridos)</option>
												<option value="5" <%=solicitacaoBean.getTipoJuroDia().toString().equals("5") ? "selected='selected'" : "" %>>5-Isento</option>
												<option value="6" <%=solicitacaoBean.getTipoJuroDia().toString().equals("6") ? "selected='selected'" : "" %>>6-Valor (dia útil)</option>
												<option value="7" <%=solicitacaoBean.getTipoJuroDia().toString().equals("7") ? "selected='selected'" : "" %>>7-Percentual ao dia (dias úteis)</option>
												<option value="8" <%=solicitacaoBean.getTipoJuroDia().toString().equals("8") ? "selected='selected'" : "" %>>8-Percentual ao mês (dias úteis)</option>
												<option value="9" <%=solicitacaoBean.getTipoJuroDia().toString().equals("9") ? "selected='selected'" : "" %>>9-Percentual ao ano (dias úteis)</option>
											
										</select>
										
									</td>
						</tr>
						<tr>
									
									<td class="textoTitulo" width="17%">Percentual Juros:</td>
									<td class="textoValor" width="26%"><%=solicitacaoBean.getPercentualJuroMes().toString().equals("0,00 %")?"":solicitacaoBean.getPercentualJuroMes().toString()%></td>
									<td class="textoValor" width="24%" align="left"><%=solicitacaoBean.getValorJuros().toString().equals("R$ 0,00")?"":solicitacaoBean.getValorJuros().toString()%></td>
									<td class="textoTitulo">
									<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(7))) {%>
										Prazo para Juros:
									<%} %>
									</td>
									<td class="textoValor"> <%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(7))){%>
									<%=solicitacaoBean.getPrazoJuros().toString()%>
									<%} %>
									</td>
									<td class="textoValor" width="18%" align="left">
									<%if (!solicitacaoBean.getIndicadorSolicitacao().equals(new Long(7))){%>
									<%=solicitacaoBean.getDataJurosFormatada().equals("")?"":solicitacaoBean.getDataJurosFormatada().toString()%>
									<%} %></td>
						</tr>
	            	
	            	</table>
              </td>
            </tr>
				    <tr> 
					     <td colspan="6">&nbsp;</td>
					  </tr>
            <%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(7))){%>
            <tr>
              <td colspan="6">
                <div id="Agendar" class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="6">&nbsp;</td>
                    </tr>
										<tr>
				              <td class="textoTitulo" width="17%">Dia de Vencimento: </td>
				              <td class="textoValor" width="26%"><%=solicitacaoBean.getDiaVencimento().equals(new Long(0))?"":solicitacaoBean.getDiaVencimento().toString()%></td>
				              </td>
				              <td class="textoTitulo" width="17%">Forma de Vencimento: </td>
				              <td class="textoValor" width="26%"><%=solicitacaoBean.getFormaVencimentoTexto()%></td>
										</tr>
				
										<tr>
				              <td class="textoTitulo" width="17%">Dia de Emissão Boleto: </td>
				              <td class="textoValor" width="26%"><%=solicitacaoBean.getDiaEmissao().equals(new Long(0))?"":solicitacaoBean.getDiaEmissao().toString()%></td>
				              <td class="textoTitulo" width="17%">Forma de Emissão Boleto: </td>
				              <td class="textoValor" width="26%"><%=solicitacaoBean.getFormaEmissaoTexto()%></td>
										</tr>
										
										<tr>
				              <td class="textoTitulo" width="17%">Agendamento Permanente: </td>
				              <td class="textoValor" width="26%"><%=solicitacaoBean.getAgendamentoPermanente().trim().equals("S")?"SIM":"NAO"%></td>
				              <td class="textoTitulo" width="17%">&nbsp;</td>
				              <td class="textoValor" width="26%">&nbsp;</td>
										</tr>

				            <tr> 
					            <td colspan="6">&nbsp;</td>
					          </tr>
					        </table>

					      </div>
					    </td>
					  </tr>
						<%}%>
				    <tr> 
					  	<td colspan="6">&nbsp;</td>
					  </tr>
					  
            <tr>
	            <td align="right" colspan="6">
		            <p align="center"> 
 		            	<s:Button name="Alterar" action="javascript:formSubmit()" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersolic.alterar"/>
		            	<s:Button name="Excluir" action="javascript:formSubmit_Excluir()" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersolic.excluir"/>
		            	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
	              </p>
	            </td>
	          </tr>
            <tr> 
              <td colspan="6">&nbsp;</td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    <script language="javascript">
	    function inicia() {
			}
	    function formSubmit() {
	        document.frmMain.submit();
	    }

	    function formSubmit_Excluir() {
				if(document.frmMain.indicadorSolicitacao.value == 6){
					if (confirm(conf("145", "Solicitação de Emissão de Títulos"))) {	
		   			document.frmMain.estrategia.value = "<%=SolicitacaoAgendamentoEstrategia.STRATEGY_EXCLUIR%>";
    	   		document.frmMain.submit();
      		}   
	      }
				else if(document.frmMain.indicadorSolicitacao.value == 7){
					if (confirm(conf("102", "Agendamento de Emissão de Títulos"))) {	
		   			document.frmMain.estrategia.value = "<%=SolicitacaoAgendamentoEstrategia.STRATEGY_EXCLUIR%>";    
      	 		document.frmMain.submit();
      		}   
	      }
	    }	    
	    function formSubmit_Voltar() {
	    	document.frmMain.estrategia.value = "<%=SolicitacaoAgendamentoEstrategia.STRATEGY_MANTER_FILTRO%>";
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
      }
    </script>
  </s:FormStrategy>
</p:Document>
</html>