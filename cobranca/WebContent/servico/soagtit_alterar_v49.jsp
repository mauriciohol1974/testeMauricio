<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: soagtit_alterar.jsp - Java Server Pages
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
%>

<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=SolicitacaoAgendamentoEstrategia.STRATEGY_ALTERAR_FINALIZAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=SolicitacaoAgendamentoEstrategia.PAGE_TITLE_ALTERAR%>"/>    
 		<input type="hidden" name="moeda">
		<input type="hidden" name="codigoCedente" value='<%=solicitacaoBean.getCodigoCedente()%>'>
		<input type="hidden" name="codigoBancoSacado" value='<%=solicitacaoBean.getCodigoBancoSacado()%>'>
		<input type="hidden" name="registro">
		<input type="hidden" name="indicadorSolicitacao" value='<%=solicitacaoBean.getIndicadorSolicitacao()%>'>
		<input type="hidden" name="nomeBancoSacado" value='<%=solicitacaoBean.getNomeBancoSacado()%>'>
		<input type="hidden" name="dataSolicitacao" value='<%=solicitacaoBean.getDataSolicitacaoFormatada()%>'>
		<input type="hidden" name="endosso" >
		<%//EAM - 14/10/2005%>
		<input type="hidden" name="formaObtencaoBloqueto" >
		<input type="hidden" name="aceite" >
		<input type="hidden" name="protestoAutomatico" >
		
		
<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(7))){%>
		<input type="hidden" name="dataVencimento">
		<input type="hidden" name="dataDesconto1">
		<input type="hidden" name="dataDesconto2">
		<input type="hidden" name="dataDesconto3">		
		<input type="hidden" name="dataMulta">
<%}%>

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
              <td width="26%"> 
                 <%//EAM 14/10/2005 - Habilitado o campo para permitir sem registro.%>
                 <s:ComboSimNao name="registroCombo" onChange="javascript:configuraCampoDependente(this)" selectedValue='<%=solicitacaoBean.getRegistro().trim().equals("")?"S":solicitacaoBean.getRegistro()%>'/>                       
              </td>
              <td class="textoTitulo" width="17%">Espécie: </td>
              <td width="26%"> 
                	<s:ComboEspecieTitulo name="especie" selectedValue='<%=solicitacaoBean.getEspecie().equals(new Long(0))?"-1":solicitacaoBean.getEspecie().toString()%>' branco="true"/>              
              </td>
						</tr>
						 
						<tr>
              <td class="textoTitulo" width="17%">Forma Obtenção Valor Título: </td>
              <td width="26%"> 
								<s:ComboFormaObtencao name="formaObtencaoValor" selectedValue="1" 
									onChange="configuraCampoDependenteFOV(this)" 
									/> </td> <%//AL - 07/01/2009 - SISOL 250475 - Após habilitar o combo relacionado ao campo formaObtencaoValor, retirar o campo hidden / Em selectValue recolocar a lógica de volta selectedValue=  solicitacaoBean.getFormaObtencaoValor().equals(new Long(0))?"1":solicitacaoBean.getFormaObtencaoValor().toString()%>
              </td>	
              <td class="textoTitulo" width="17%">Valor: </td>
              <td width="26%"> 
				        <p:InputCurrency name="valorSolicitacao" maxlength="15" size="27" 
        						CLASS="inputtext"
        						value='<%=solicitacaoBean.getValorSolicitacao().toString().equals("R$ 0,00")?"":solicitacaoBean.getValorSolicitacao().toString()%>' 
        						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.formaObtencaoBloquetoCombo);"
										onBlur="configuraCampoDependente(this)"/> 
              </td>
						</tr>
			<tr>
              <td class="textoTitulo" width="17%" nowrap>Forma Obtenção Envio Boleto: </td>
              <td width="26%"> 
								<s:ComboFormaObtencao name="formaObtencaoBloquetoCombo" selectedValue='<%=solicitacaoBean.getFormaObtencaoBloqueto().equals(new Long(0))?"1":solicitacaoBean.getFormaObtencaoBloqueto().toString()%>'
									onChange="configuraCampoDependente(this)"/>
              </td>	
              <td class="textoTitulo" width="17%">Envio do Boleto: </td>
              <td width="26%">
               	<s:ComboEnvioBloqueto name="envioBloqueto" onChange="ConfiguraSMS()"  selectedValue='<%=solicitacaoBean.getEnvioBloqueto().equals(new Long(0))?"-1":solicitacaoBean.getEnvioBloqueto().toString()%>' branco="true"/>
              </td>
			 </tr>
			 
			 <tr>
			  <td class="textoTitulo" width="17%" nowrap>&nbsp;</td>
              		<td width="26%">&nbsp;</td>
              <td class="textoTitulo" width="17%" nowrap>Tipo de SMS: </td>
              		<td width="26%">
              			 <select size="1" name="tipoSMS" disabled="disabled">
              			 	<option <%=solicitacaoBean.getTipoSMS().equals("00") ? "selected='selected'" : ""%> value="00"></option>
							<option <%=solicitacaoBean.getTipoSMS().equals("01") ? "selected='selected'" : ""%> value="01">Informativa</option>
							<option <%=solicitacaoBean.getTipoSMS().equals("02") ? "selected='selected'" : ""%> value="02">Repr. Numérica</option>
							<option <%=solicitacaoBean.getTipoSMS().equals("03") ? "selected='selected'" : ""%> value="03">PEC</option>
						</select>   
                    </td>	
			 </tr>
			
						
						<tr>
              <td class="textoTitulo" width="17%">Endosso: </td>
              <td width="26%"> 
         				<s:ComboSimNao name="endossoCombo" selectedValue='<%=solicitacaoBean.getEndosso().trim().equals("")?"N":solicitacaoBean.getEndosso()%>'disabled='true'/> 
              </td>
              <td class="textoTitulo" width="17%">Aceite: </td>
              <td width="26%"> 
                <s:ComboAceite name="aceiteCombo" selectedValue='<%=solicitacaoBean.getAceite().trim().equals("")?"-1":solicitacaoBean.getAceite()%>' branco="true"/>
              </td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Protesto Automático: </td>
              <td width="26%"> 
								<s:ComboSimNao name="protestoAutomaticoCombo" disabled="true" selectedValue='N'/><%//EAM 14/10/2005 - =solicitacaoBean.getProtestoAutomatico().trim().equals("")?"N":solicitacaoBean.getProtestoAutomatico()%>                   
              </td>
              <td class="textoTitulo" width="17%">Prazo Protesto/Devolução: </td>
              <td width="26%"> 
				        <p:InputNumerico name="prazoProtestoDevolucao" maxlength="3" size="3" 
        						CLASS="inputtext" 
        						value='<%=solicitacaoBean.getPrazoProtestoDevolucao().equals(new Long(0))?"":solicitacaoBean.getPrazoProtestoDevolucao().toString()%>'                 						
        						onFocus="javascript: prevFocus(this);"
										onKeyUp='<%=solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))?"javascript: nextFocus(event.keyCode, this, document.frmMain.dataVencimento);":"javascript: nextFocus(event.keyCode, this, document.frmMain.tipoJuroDia);"%>'/> 
              </td>
						</tr>
						<tr>
							<td class="textoTitulo" width="17%">Moeda: </td>
              <td class="textoValor" width="26%"> 
								<s:ComboMoeda name="moedaCombo" selectedValue='<%=solicitacaoBean.getMoeda().equals(new Long(0))?"9":solicitacaoBean.getMoeda().toString()%>' disabled="true"/>
              </td>						
            <%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
							<td class="textoTitulo" width="17%">Data de Vencimento: </td>
              <td class="textoValor" width="26%"> 
  			        <p:InputDate name="dataVencimento" 
	 							value ='<%=solicitacaoBean.getDataVencimentoFormatada().equals("01/01/0001")?"":solicitacaoBean.getDataVencimentoFormatada()%>' CLASS="inputtext"
   							onFocus="javascript: prevFocus(this);"
								onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.tipoJuroDia);" 
								onBlur="configuraCampoDependente(this)"/> 
              </td>
						<%}else{%>
							<td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            <%}%>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr>
              <td class="textoTitulo" width="17%">Tipo Juros Dia:</td>
		          <td width="26%" nowrap> 
	               <s:ComboTipoJurosDia name="tipoJuroDia" selectedValue='<%=solicitacaoBean.getTipoJuroDia().equals(new Long(-999))?"-999":solicitacaoBean.getTipoJuroDia().toString()%>' branco="true" brancoValue="-999"
  	     						onChange="javascript: configuraCampoDependente(this);" />                       
              </td>
              <td class="textoTitulo" width="17%">Percentual Juros Mês: </td>
              <td class="textoValor" width="26%">
				        <p:InputPercentual name="percentualJuroMes" maxlength="5" size="9" 
  	   						CLASS="inputtext" 
 		         			value ='<%=solicitacaoBean.getPercentualJuroMes().toString().equals("0,00 %")?"":solicitacaoBean.getPercentualJuroMes().toString()%>'
									onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.percentualDesconto1);"
									onBlur="javascript: limpaPercentualZero(this);"/>  														
              </td>
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
                    <td class="textoTitulo" width="19%" align="left">Desconto 1: </td>
                    <td class="textoValor" width="8%" align="left">
      				        <p:InputPercentual name="percentualDesconto1" maxlength="5" size="9" 
              						CLASS="inputtext"
               						value ='<%=solicitacaoBean.getPercentualDesconto1().toString().equals("0,00 %")?"":solicitacaoBean.getPercentualDesconto1().toString()%>'
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.prazoDesconto1, document.frmMain.dataDesconto1);"
													onBlur="javascript: configuraCampoDependenteFOV(this);"/>
										</td>
										<td class="textoValor" width="24%" align="left">
      				        <p:InputCurrency name="valorDesconto1" maxlength="15" size="27" 
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getValorDesconto1().toString().equals("R$ 0,00")?"":solicitacaoBean.getValorDesconto1().toString()%>'			                						
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.prazoDesconto1, document.frmMain.dataDesconto1);"
													onBlur="javascript: configuraCampoDependenteFOV(this);" />
                    </td>
                    <td class="textoTitulo" width="17%" align="left">Prazo Limite 1: </td>
                    <td class="textoValor" width="8%" align="left">
      				        <p:InputNumerico name="prazoDesconto1" maxlength="3" size="3"
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getPrazoDesconto1().toString()%>'			                									                						
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp="javascript: focoValor(event.keyCode, this, document.frmMain.percentualDesconto2, document.frmMain.valorDesconto2);"
													onBlur="javascript: configuraCampoDependenteFOV(this);"/>
										</td>

										<td class="textoValor" width="18%" align="left">
											<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
	      				        <p:InputDate name="dataDesconto1" 
	              						CLASS="inputtext" 
	               						value ='<%=solicitacaoBean.getDataDesconto1Formatada().equals("")?"":solicitacaoBean.getDataDesconto1Formatada().toString()%>'
	              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
   													onKeyUp="javascript: focoValor(event.keyCode, this, document.frmMain.percentualDesconto2, document.frmMain.valorDesconto2);"
														onBlur="javascript: configuraCampoDependenteFOV(this);"/>
											<%}%>	
                    </td>
									</tr> 
								  <tr>
                    <td class="textoTitulo" width="19%" align="left">Desconto 2: </td>
                    <td class="textoValor" width="8%" align="left">
      				        <p:InputPercentual name="percentualDesconto2" maxlength="5" size="9"
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getPercentualDesconto2().toString().equals("0,00 %")?"":solicitacaoBean.getPercentualDesconto2().toString()%>'
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.prazoDesconto2, document.frmMain.dataDesconto2);"
													onBlur="javascript: configuraCampoDependenteFOV(this);"/>
										</td>
										<td class="textoValor" width="24%" align="left">
      				        <p:InputCurrency name="valorDesconto2" maxlength="15" size="27"
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getValorDesconto2().toString().equals("R$ 0,00")?"":solicitacaoBean.getValorDesconto2().toString()%>'			                						
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.prazoDesconto2, document.frmMain.dataDesconto2);"
													onBlur="javascript: configuraCampoDependenteFOV(this);"/>																	
                    </td>
                    <td class="textoTitulo" width="17%" align="left">Prazo Limite 2: </td>
                    <td class="textoValor" width="8%" align="left">
      				        <p:InputNumerico name="prazoDesconto2" maxlength="3" size="3"
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getPrazoDesconto2().toString()%>'			                									                						
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp="javascript: focoValor(event.keyCode, this, document.frmMain.percentualDesconto3, document.frmMain.valorDesconto3);"
													onBlur="javascript: configuraCampoDependenteFOV(this);"/>																	
										</td>
										<td class="textoValor" width="18%" align="left">
											<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
	      				        <p:InputDate name="dataDesconto2"
	              						CLASS="inputtext" 
	               						value ='<%=solicitacaoBean.getDataDesconto2Formatada().equals("")?"":solicitacaoBean.getDataDesconto2Formatada().toString()%>'
	              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
  													onKeyUp="javascript: focoValor(event.keyCode, this, document.frmMain.percentualDesconto3, document.frmMain.valorDesconto3);"
														onBlur="javascript: configuraCampoDependenteFOV(this);"/>																	
											<%}%>															
                    </td>
									</tr>
								  <tr>
                    <td class="textoTitulo" width="19%" align="left">Desconto 3: </td>
                    <td class="textoValor" width="8%" align="left">
      				        <p:InputPercentual name="percentualDesconto3" maxlength="5" size="9"
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getPercentualDesconto3().toString().equals("0,00 %")?"":solicitacaoBean.getPercentualDesconto3().toString()%>'
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.prazoDesconto3, document.frmMain.dataDesconto3);"
													onBlur="javascript: configuraCampoDependenteFOV(this);"/>																	
										</td>
										<td class="textoValor" width="24%" align="left">
      				        <p:InputCurrency name="valorDesconto3" maxlength="15" size="27"
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getValorDesconto3().toString().equals("R$ 0,00")?"":solicitacaoBean.getValorDesconto3().toString()%>'			                						
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.prazoDesconto3, document.frmMain.dataDesconto3);"
													onBlur="javascript: configuraCampoDependenteFOV(this);"/>																	
                    </td>
                    <td class="textoTitulo" width="17%" align="left">Prazo Limite 3: </td>
                    <td class="textoValor" width="8%" align="left">
      				        <p:InputNumerico name="prazoDesconto3" maxlength="3" size="3"
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getPrazoDesconto3().toString()%>'			                									                						
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.percentualMulta);"
													onBlur="javascript: configuraCampoDependenteFOV(this);"/>																	
										</td>
										<td class="textoValor" width="18%" align="left">
											<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
	      				        <p:InputDate name="dataDesconto3"
	              						CLASS="inputtext" 
	               						value ='<%=solicitacaoBean.getDataDesconto3Formatada().equals("")?"":solicitacaoBean.getDataDesconto3Formatada().toString()%>'
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
														onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.percentualMulta);"
														onBlur="javascript: configuraCampoDependenteFOV(this);"/>																	
											<%}%>															
                    </td>
									</tr>
								  <tr>
                    <td class="textoTitulo" width="19%" align="left">Multa: </td>
                    <td class="textoValor" width="8%" align="left">
      				        <p:InputPercentual name="percentualMulta" maxlength="5" size="9"
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getPercentualMulta().toString().equals("0,00 %")?"":solicitacaoBean.getPercentualMulta().toString()%>'			       
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.prazoMulta);"
													onBlur="javascript: configuraCampoDependenteFOV(this);"/>																	
										</td>
										<td class="textoValor" width="24%" align="left">
      				        <p:InputCurrency name="valorMulta" maxlength="15" size="27" 
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getValorMulta().toString().equals("R$ 0,00")?"":solicitacaoBean.getValorMulta().toString()%>'			                						
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.prazoMulta);"
													onBlur="javascript: configuraCampoDependenteFOV(this);"/>																	
                    </td>
                    <td class="textoTitulo" width="17%" align="left">Prazo para Multa: </td>
                    <td class="textoValor" width="8%" align="left">
      				        <p:InputNumerico name="prazoMulta" maxlength="3" size="3"
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getPrazoMulta().equals(new Long(0))?"":solicitacaoBean.getPrazoMulta().toString()%>'			                									                						
              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
													onKeyUp='<%=solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))?"javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);":"javascript: nextFocus(event.keyCode, this, document.frmMain.diaVencimento);"%>'
													onBlur="javascript: configuraCampoDependenteFOV(this);"/>																	
										</td>
										<td class="textoValor" width="18%" align="left">
											<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
	      				        <p:InputDate name="dataMulta"
	              						CLASS="inputtext" 
	               						value ='<%=solicitacaoBean.getDataMultaFormatada().equals("")?"":solicitacaoBean.getDataMultaFormatada().toString()%>'			                									                						
	              						onFocus="javascript: prevFocus(this);configuraCampoDependenteFOV(this);"
														onKeyUp='<%=solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))?"javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);":"javascript: nextFocus(event.keyCode, this, document.frmMain.diaVencimento);"%>'
														onBlur="javascript: configuraCampoDependenteFOV(this);"/>																	
											<%}%>															
                    </td>
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
				              <td class="textoValor" width="26%"> 
				                <p:InputNumerico name="diaVencimento" maxlength="2" size="2"
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getDiaVencimento().equals(new Long(0))?"":solicitacaoBean.getDiaVencimento().toString()%>'			                									                						
              						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.formaVencimento);" 
													onBlur="javascript: configuraCampoDependente(this)"/>																	
										</td>
				              </td>
				              <td class="textoTitulo" width="17%">Forma de Vencimento: </td>
				              <td class="textoValor" width="26%">
												<s:ComboFormaVencimento name="formaVencimento" selectedValue='<%=solicitacaoBean.getFormaVencimento().equals(new Long(0))?"1":solicitacaoBean.getFormaVencimento().toString()%>'/>
				              </td>
										</tr>
				
										<tr>
				              <td class="textoTitulo" width="17%">Dia de Emissão Boleto: </td>
				              <td class="textoValor" width="26%"> 
				                <p:InputNumerico name="diaEmissao" maxlength="2" size="2"
              						CLASS="inputtext" 
               						value ='<%=solicitacaoBean.getDiaEmissao().equals(new Long(0))?"":solicitacaoBean.getDiaEmissao().toString()%>'			                									                						
              						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.formaEmissao);"/> 													
				              </td>
				              <td class="textoTitulo" width="17%">Forma de Emissão Boleto: </td>
				              <td class="textoValor" width="26%"> 
												<s:ComboFormaEmissaoBloqueto name="formaEmissao" selectedValue='<%=solicitacaoBean.getFormaEmissao().equals(new Long(0))?"1":solicitacaoBean.getFormaEmissao().toString()%>'/>
				              </td>
										</tr>
										
										<tr>
				              <td class="textoTitulo" width="17%">Agendamento Permanente: </td>
				              <td class="textoValor" width="26%"> 
         								<s:ComboSimNao name="agendamentoPermanente" selectedValue='<%=solicitacaoBean.getAgendamentoPermanente().trim().equals("")?"N":solicitacaoBean.getAgendamentoPermanente()%>'/> 
				              </td>
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
 		            	<s:Button name="Confirmar" action="javascript:formSubmit()" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersolic.alterar"/>
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
	    function inicia(){
					<%//EAM 14/10/2005 - INI%>
					configuraCampoDependente(document.frmMain.registroCombo);
					<%//EAM 14/10/2005 - FIM%>
					configuraCampoDependente(document.frmMain.formaObtencaoValor);
					configuraCampoDependente(document.frmMain.formaObtencaoBloquetoCombo);
					configuraCampoDependente(document.frmMain.tipoJuroDia);
					configuraCampoDependente(document.frmMain.percentualDesconto1);
					configuraCampoDependente(document.frmMain.valorDesconto1);
					configuraCampoDependente(document.frmMain.prazoDesconto1);
					configuraCampoDependente(document.frmMain.dataDesconto1);
					configuraCampoDependente(document.frmMain.percentualDesconto2);
					configuraCampoDependente(document.frmMain.valorDesconto2);
					configuraCampoDependente(document.frmMain.prazoDesconto2);
					configuraCampoDependente(document.frmMain.dataDesconto2);
					configuraCampoDependente(document.frmMain.percentualDesconto3);
					configuraCampoDependente(document.frmMain.valorDesconto3);
					configuraCampoDependente(document.frmMain.prazoDesconto3);
					configuraCampoDependente(document.frmMain.dataDesconto3);
					configuraCampoDependente(document.frmMain.percentualMulta);
					configuraCampoDependente(document.frmMain.valorMulta);
					configuraCampoDependente(document.frmMain.prazoMulta);
					configuraCampoDependente(document.frmMain.dataMulta);
					<%//EAM 14/10/2005 - INI%>
					verificaValorData();
					<%//EAM 14/10/2005 - FIM%>
					ConfiguraSMS();
	    }
	    //Verifica qual deve ser o proximo campo a colocar o foco
	    function focoValor(evento, campoAtual, campo1, campo2){
					if(trim(document.frmMain.percentualDesconto1.value) != ''){
					  habilitaCampoDependente(campoAtual,campo1);			
	 					nextFocus(evento, campoAtual, campo1);
	 				}
	 				else if(trim(document.frmMain.valorDesconto1.value) != ''){
					  habilitaCampoDependente(campoAtual,campo2);			
	 					nextFocus(evento, campoAtual, campo2);
	 				}
			}
	    function foco(evento, campo1, campo2){
					habilitaCampoDependente(campo1,campo2);				
 					nextFocus(evento, campo1, campo2);
			}
	    function focoPrazo(evento, campoAtual, campo1, campo2){
					if(trim(document.frmMain.prazoDesconto1.value) != ''){
					  habilitaCampoDependente(campoAtual,campo1);		
	 					nextFocus(evento, campoAtual, campo1);
	 				}
	 				else if(trim(document.frmMain.dataDesconto1.value) != ''){
					  habilitaCampoDependente(campoAtual,campo2);	
	 					nextFocus(evento, campoAtual, campo2);
	 				}
	 				else if (trim(document.frmMain.prazoDesconto1.value) == '' && trim(document.frmMain.dataDesconto1.value) == ''){
	 					habilitaCampoDependente(campoAtual,campo1);	
	 					nextFocus(evento, campoAtual, campo1);
	 				}
			}

	    function formSubmit() {
	    	alert("Entrou no submit");
	        if (validaSubmit()) {
		    		if (confirm(<%=solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))?"conf('144','Solicitação de Emissão de Títulos')":"conf('101','Agendamento de Emissão de Títulos')"%>)){
			        document.frmMain.registro.value = document.frmMain.registroCombo.value;
			        document.frmMain.moeda.value = document.frmMain.moedaCombo.value;
			        document.frmMain.endosso.value = document.frmMain.endossoCombo.value;
			        <%//EAM - 14/10/2005 - ini%>
			        document.frmMain.aceite.value = document.frmMain.aceiteCombo.value;
			        document.frmMain.formaObtencaoBloqueto.value = document.frmMain.formaObtencaoBloquetoCombo.value;
			        document.frmMain.protestoAutomatico.value = document.frmMain.protestoAutomaticoCombo.value;
			        <%//EAM - 14/10/2005 - fim%>
			        document.frmMain.submit();
			      }
	        }
	    }
	    function formSubmit_Voltar() {
    		if (confirm(conf("103"))) {
           document.frmMain.estrategia.value = "<%=SolicitacaoAgendamentoEstrategia.STRATEGY_MANTER_FILTRO%>";
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
        }
      }

	    function validaSubmit(){
	    	var camposObrigatorios = new Array(17);
  			camposObrigatorios[0] = new Array( 'registroCombo', 'Registro' );
	    	camposObrigatorios[1] = new Array( 'especie', 'Espécie' );
	    	camposObrigatorios[2] = new Array( "formaObtencaoValor", "Forma Obtenção Valor Título" );
	    	if(document.frmMain.formaObtencaoValor.value==1){
		    	<%//EAM - 14/10/2005%>
		    	if(document.frmMain.registroCombo.value == 'S'){
		    	  camposObrigatorios[3] = new Array( "valorSolicitacao", "Valor" );
					}  
	    	}
	    	camposObrigatorios[4] = new Array( "formaObtencaoBloquetoCombo", "Forma Obtenção Envio Bloqueto" );
  			if(document.frmMain.formaObtencaoBloquetoCombo.value==1){
  			  camposObrigatorios[5] = new Array( 'envioBloqueto', 'Envio do Boleto' );
	    	}
	    	camposObrigatorios[6] = new Array( "endossoCombo", "Endosso" );
	    	camposObrigatorios[7] = new Array( "aceiteCombo", "Aceite" );
	    	camposObrigatorios[8] = new Array( "protestoAutomaticoCombo", "Protesto Automático" );
	    	
	    	<%//EAM - 14/10/2005%>
	    	if(document.frmMain.registroCombo.value == 'S'){
		    	camposObrigatorios[9] = new Array( "prazoProtestoDevolucao", "Prazo Protesto/Devolução" );
				}  
				  	
	    	camposObrigatorios[10] = new Array( "moedaCombo", "Moeda" );
	    	<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
	    	  <%//EAM - 14/10/2005%>
		    	if(document.frmMain.registroCombo.value == 'S'){
	    	  	camposObrigatorios[11] = new Array( "dataVencimento", "Data de Vencimento" );
	    	  }
	    	<%}
	    		if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(7))){%>
	    	  <%//EAM - 14/10/2005%>
		    	if(document.frmMain.registroCombo.value == 'S'){
			      camposObrigatorios[13] = new Array( "diaVencimento", "Dia de Vencimento" );  
	    	  }
		      camposObrigatorios[14] = new Array( "formaVencimento", "Forma de Vencimento" );  
		      camposObrigatorios[15] = new Array( "diaEmissao", "Dia de Emissão Boleto" );  
		      camposObrigatorios[16] = new Array( "formaEmissao", "Forma de Emissão Boleto" );  
		      camposObrigatorios[17] = new Array( "agendamentoPermanente", "Agendamento Permanente" );  
		    <%}%>
		    
		    if(!validaArrayCamposObrigatorios(camposObrigatorios)){
		      return false;
		    }
	    	if(!validaComboObrigatorio(document.frmMain.tipoJuroDia, 'Tipo Juros Dia','-999')){
			  	return false;
				}
			  <%//EAM - 31/08 - SISOT 139 - INI%>
				if(document.frmMain.envioBloqueto.value == '3'){
				  <%//EAM 14/10/2005 - Ini%>
				  if(document.frmMain.registroCombo.value == 'N'){
						emiteMensagemCombo(document.frmMain.registroCombo, document.frmMain.envioBloqueto, 'Registro', 'Envio do Boleto' );
						return false;
					}						  
				  <%//EAM 14/10/2005 - Fim%>
				  				  
				  if(document.frmMain.protestoAutomaticoCombo.value == 'S'){
						emiteMensagemCombo(document.frmMain.protestoAutomaticoCombo, document.frmMain.envioBloqueto, 'Protesto Automático', 'Envio do Boleto' );
						return false;
					}			  
			  }
			  <%//EAM - 31/08 - SISOT 139 - FIM%>		
	    	<%//EAM 14/10/2005 - Ini%>
	    	if(document.frmMain.registroCombo.value == 'S' && document.frmMain.formaObtencaoValor.value == "1") {
		    	if(!validaValorZero(document.frmMain.valorSolicitacao, 'Valor')){
					  return false;				
					}
	    	}
	    	<%//EAM 14/10/2005 - Fim%>	    	

	    	if(document.frmMain.protestoAutomaticoCombo.value == "S"){
			  	if(!validaIntervalo(document.frmMain.prazoProtestoDevolucao, 'Prazo de Protesto/Devolução', '2', '90')){
						return false;
			    }		    	
			  }
			  if(document.frmMain.protestoAutomaticoCombo.value == "N"){
			  	if(!validaIntervalo(document.frmMain.prazoProtestoDevolucao, 'Prazo de Protesto/Devolução', '0', '999')){
						return false;
			    }		    	
			  }
		   	if(document.frmMain.tipoJuroDia.value == 2){
					if(trim(document.frmMain.percentualJuroMes.value) != ''){
						if(!validaPercentualZero(document.frmMain.percentualJuroMes, 'Percentual Juros Mês')){
					  	return false;				
						}
					}
			  }
				
				//Desconto 1				
				if(document.frmMain.percentualDesconto1.value != ''){
					if(!validaPercentualZero(document.frmMain.percentualDesconto1, 'Desconto 1')){
					  return false;				
					}
					if(!validaPercentualCem(document.frmMain.percentualDesconto1, 'Desconto 1')){
					  return false;				
					}
				}
				if(document.frmMain.valorDesconto1.value !=''){
					if(!validaValorZero(document.frmMain.valorDesconto1, 'Desconto 1')){
						return false;
					}
				}
		   	if(document.frmMain.percentualDesconto1.value != '' || document.frmMain.valorDesconto1.value != ''){
		   		if(!validaCampoObrigatorioAlternado(document.frmMain.prazoDesconto1,
		   																				document.frmMain.dataDesconto1,'Prazo Limite 1', '010')){
		   			return false;
		   		}
		   	}	   	

				//Desconto 2
				if(document.frmMain.percentualDesconto2.value != ''){
					if(!validaPercentualZero(document.frmMain.percentualDesconto2, 'Desconto 2')){
					  return false;				
					}
					if(!validaPercentualCem(document.frmMain.percentualDesconto2, 'Desconto 2')){
					  return false;				
					}
					if(!comparaPercentual(document.frmMain.percentualDesconto1, document.frmMain.percentualDesconto2, ">")){
						msg('007','Desconto 2', 'Desconto 1');
						return false;
					}
				}
				if(document.frmMain.valorDesconto2.value !=''){
					if(!validaValorZero(document.frmMain.valorDesconto2, 'Desconto 2')){
						return false;
					}
					if(!comparaValor(document.frmMain.valorDesconto1, document.frmMain.valorDesconto2, ">")){
						msg('007','Desconto 2', 'Desconto 1');
						return false;
					}

				}
		   	if(document.frmMain.percentualDesconto2.value != '' || document.frmMain.valorDesconto2.value != ''){
		   		if(!validaCampoObrigatorioAlternado(document.frmMain.prazoDesconto2,
		   																				document.frmMain.dataDesconto2,'Prazo Limite 2', '010')){
		   			return false;
		   		}
		   	}	   	
				if(document.frmMain.prazoDesconto2.value != ''){
					if(!comparaNumero(document.frmMain.prazoDesconto1, document.frmMain.prazoDesconto2, ">")){
						msg('007','Prazo Limite 2', 'Prazo Limite 1');
						return false;
					}
				}
				if(document.frmMain.dataDesconto2.value != ''){
					if(!compararDatas(document.frmMain.dataDesconto1.value, document.frmMain.dataDesconto2.value, "<")){
						msg('006','Prazo Limite 2', 'Prazo Limite 1');
						return false;
					}
				}				
				//Desconto 3
				if(document.frmMain.percentualDesconto3.value != ''){
					if(!validaPercentualZero(document.frmMain.percentualDesconto3, 'Desconto 3')){
					  return false;				
					}
					if(!validaPercentualCem(document.frmMain.percentualDesconto3, 'Desconto 3')){
					  return false;				
					}
					if(!comparaPercentual(document.frmMain.percentualDesconto2, document.frmMain.percentualDesconto3, ">")){
						msg('007','Desconto 3', 'Desconto 2');
						return false;
					}
				}
				if(document.frmMain.valorDesconto3.value !=''){
					if(!validaValorZero(document.frmMain.valorDesconto3, 'Desconto 3')){
						return false;
					}
					if(!comparaValor(document.frmMain.valorDesconto2, document.frmMain.valorDesconto3, ">")){
						msg('007','Desconto 3', 'Desconto 2');
						return false;
					}

				}
		   	if(document.frmMain.percentualDesconto3.value != '' || document.frmMain.valorDesconto3.value != ''){
		   		if(!validaCampoObrigatorioAlternado(document.frmMain.prazoDesconto3,
		   																				document.frmMain.dataDesconto3,'Prazo Limite 3', '010')){
		   			return false;
		   		}
		   	}	   			    
				if(document.frmMain.prazoDesconto3.value != ''){
					if(!comparaNumero(document.frmMain.prazoDesconto2, document.frmMain.prazoDesconto3, ">")){
						msg('007','Prazo Limite 3', 'Prazo Limite 2');
						return false;
					}
				}
				if(document.frmMain.dataDesconto3.value != ''){
					if(!compararDatas(document.frmMain.dataDesconto2.value, document.frmMain.dataDesconto3.value, "<")){
						msg('006','Prazo Limite 3', 'Prazo Limite 2');
						return false;
					}
				}	
				//Multa
				if(document.frmMain.percentualMulta.value != ''){
					if(!validaPercentualZero(document.frmMain.percentualMulta, 'Multa')){
					  return false;				
					}
				}
				if(document.frmMain.valorMulta.value !=''){
					if(!validaValorZero(document.frmMain.valorMulta, 'Multa')){
						return false;
					}
				}
		   	if(document.frmMain.percentualMulta.value != '' || document.frmMain.valorMulta.value != ''){
		   		if(!validaCampoObrigatorioAlternado(document.frmMain.prazoMulta,
		   																				document.frmMain.dataMulta,'Prazo para Multa', '010')){
		   			return false;
		   		}
		   		if(!validaMenorIgual(document.frmMain.prazoMulta, 'Prazo para Multa', 0)){
						  return false;				
					}			
		   	}	   			    

		    if (trim(document.frmMain.dataVencimento.value) != ""){ 
		       if(!validaData(document.frmMain.dataVencimento)) {
				    	msg('014','Data de Vencimento');
				    	return false;
				   }
		    }
		    if (trim(document.frmMain.dataDesconto1.value) != ""){ 
		       if(!validaData(document.frmMain.dataDesconto1)) {
				    	msg('014','Prazo Limite 1');
				    	return false;
				   }
		    }
		    if (trim(document.frmMain.dataDesconto2.value) != ""){ 
		       if(!validaData(document.frmMain.dataDesconto2)) {
				    	msg('014','Prazo Limite 2');
				    	return false;
				   }
		    }
		    if (trim(document.frmMain.dataDesconto3.value) != ""){ 
		       if(!validaData(document.frmMain.dataDesconto3)) {
				    	msg('014','Prazo Limite 3');
				    	return false;
				   }
		    }
				if (trim(document.frmMain.dataMulta.value) != ""){ 
	      	if(!validaData(document.frmMain.dataMulta)) {
		    		msg('014','Multa');
				    return false;
				  }
				  if(!compararDatas(document.frmMain.dataMulta.value,document.frmMain.dataVencimento.value,">")){
		    		msg("006", "Data Multa", "Data de Vencimento")
		    		return false;
		    	}
		    }
	    	<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(7))){%>
				if (trim(document.frmMain.diaVencimento.value) != ""){ 
		    	if(!validaIntervalo(document.frmMain.diaVencimento, 'Dia de Vencimento', '1', '31')){
				  	return false;
	        }
		    }
				if (trim(document.frmMain.diaVencimento.value) != ""){ 
		    	if(!validaIntervalo(document.frmMain.diaEmissao, 'Dia de Emissão Boleto', '1', '31')){
				  	return false;
	        }
		    }
				if (trim(document.frmMain.diaVencimento.value) != "" && trim(document.frmMain.diaVencimento.value) != ""){ 
					return valida_vencto();
				}		    
				<%}%>


	    	return true;
	    }

			//Configura os campos dependentes de acordo com a Forma de Obtenção de Valor(FOV)
			function configuraCampoDependenteFOV(campo){
				if(document.frmMain.formaObtencaoValor.value == "1"){ // 1 - Informado p/ usuario
					configuraCampoDependente(campo);
					<%//EAM 14/10/2005 - INI%>
					verificaValorData();
					<%//EAM 14/10/2005 - FIM%>
				}
				else if(document.frmMain.formaObtencaoValor.value == "2"){ // 2 -Banco de sacados
					configuraCampoDependente(document.frmMain.formaObtencaoValor);
					document.frmMain.percentualDesconto1.disabled = false;
				  document.frmMain.valorDesconto1.disabled = true;
				  document.frmMain.valorDesconto2.disabled = true;
				  document.frmMain.valorDesconto3.disabled = true;
				  document.frmMain.valorMulta.disabled = true;
				  document.frmMain.valorDesconto1.value = '';
				  document.frmMain.valorDesconto2.value = '';
				  document.frmMain.valorDesconto3.value = '';
				  document.frmMain.valorMulta.value = '';
					configuraCampoDependente(document.frmMain.percentualDesconto1);
					configuraCampoDependente(document.frmMain.valorDesconto1);
					configuraCampoDependente(document.frmMain.prazoDesconto1);
					configuraCampoDependente(document.frmMain.dataDesconto1);
					configuraCampoDependente(document.frmMain.percentualDesconto2);
					configuraCampoDependente(document.frmMain.valorDesconto2);
					configuraCampoDependente(document.frmMain.prazoDesconto2);
					configuraCampoDependente(document.frmMain.dataDesconto2);
					configuraCampoDependente(document.frmMain.percentualDesconto3);
					configuraCampoDependente(document.frmMain.valorDesconto3);
					configuraCampoDependente(document.frmMain.prazoDesconto3);
					configuraCampoDependente(document.frmMain.dataDesconto3);
					configuraCampoDependente(document.frmMain.percentualMulta);
					configuraCampoDependente(document.frmMain.valorMulta);
					configuraCampoDependente(document.frmMain.prazoMulta);
					configuraCampoDependente(document.frmMain.dataMulta);		
					<%//EAM 14/10/2005 - INI%>
					verificaValorData();
					<%//EAM 14/10/2005 - FIM%>
				}
			}    	
    	
    	function configuraCampoDependente(campo){
				
				if(campo == document.frmMain.registroCombo){
						if(campo.value == "S"){
							//document.frmMain.formaObtencaoBloquetoCombo.disabled = false;
	  		  	 	configuraCampoDependente(document.frmMain.formaObtencaoBloquetoCombo);
		    			document.frmMain.aceiteCombo.disabled = false;
							document.frmMain.prazoProtestoDevolucao.disabled = false;
							verificaValorData();
						}else if (campo.value = "N"){
							//document.frmMain.formaObtencaoBloquetoCombo.value = '1'; // Informado pelo usuario
							//document.frmMain.formaObtencaoBloquetoCombo.disabled = true;
	  		  	 	configuraCampoDependente(document.frmMain.formaObtencaoBloquetoCombo);
							document.frmMain.endossoCombo.value = 'N';
							document.frmMain.endossoCombo.disabled = true;
							document.frmMain.aceiteCombo.value = '2';//2 - Sem aceite	
							document.frmMain.aceiteCombo.disabled = true;
							document.frmMain.prazoProtestoDevolucao.value = '';
							document.frmMain.prazoProtestoDevolucao.disabled = true;																					

							verificaValorData();

							
						}
				
				}//fim campo Registro
				<%//EAM 14/10/2005 - Fim%>
				if(campo == document.frmMain.formaObtencaoValor){
						if(campo.value == 1){  //1 - Informado p/ usuario
						  if(window.event.type=="change"){
							  document.frmMain.valorSolicitacao.disabled = false;
							  document.frmMain.valorSolicitacao.value = "";
								document.frmMain.percentualDesconto1.disabled = false;
							  document.frmMain.valorDesconto1.disabled = false;
							  document.frmMain.percentualMulta.disabled = false; 							  
 							  document.frmMain.valorMulta.disabled = false;
							}
						}
						else if (campo.value == 2){ //2 - Banco de sacados
						  document.frmMain.valorSolicitacao.disabled = true;
						  document.frmMain.valorSolicitacao.value = "R$ 0,00";
							document.frmMain.percentualDesconto1.disabled = false;
						  document.frmMain.percentualMulta.disabled = false;						  
						  document.frmMain.valorDesconto1.disabled = true;
						  document.frmMain.valorDesconto2.disabled = true;
						  document.frmMain.valorDesconto3.disabled = true;
						  document.frmMain.valorMulta.disabled = true;
						  document.frmMain.valorDesconto1.value = '';
						  document.frmMain.valorDesconto2.value = '';
						  document.frmMain.valorDesconto3.value = '';
						  document.frmMain.valorMulta.value = '';

					  }
				}//fim campo formaObtencaoValor
				
			if (campo == document.frmMain.formaObtencaoBloquetoCombo) {
			
				
		      if(campo.value == 1){//Informado p/ usuario
			    	  document.frmMain.envioBloqueto.disabled = false;
			    	  document.frmMain.envioBloqueto.value = -1;
		      } else if (campo.value == 2){//Banco de sacados
	    	 	document.frmMain.envioBloqueto.disabled = true;
		    	document.frmMain.envioBloqueto.value = -1;
		      }
				*/
	    	}//fim campo formaObtencaoBloquetoCombo

				<%//EAM 14/10/2005 - Inicio%>
				if(campo == document.frmMain.valorSolicitacao){
					verificaValorData();
				}//fim campo Valor
				if(campo == document.frmMain.dataVencimento){
					verificaValorData();
				}//fim campo Data
				if(campo == document.frmMain.diaVencimento){
					verificaValorData();
				}//fim campo Dia Vencimento
				<%//EAM 14/10/2005 - Fim%>
	    	
	    	if(campo == document.frmMain.tipoJuroDia){
					if(campo.value != 2){
							document.frmMain.percentualJuroMes.value='';
							document.frmMain.percentualJuroMes.disabled=true;
					}
					else{
						document.frmMain.percentualJuroMes.disabled=false;	
					}
				
				}//fim campo percentualJurosDia

//Inicio grid

				if(campo == document.frmMain.percentualDesconto1){
					
					campo2 = document.frmMain.valorDesconto1;
					
					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, campo2);
					}
					else{
						habilitaCampoAlternado(campo, campo2);
						if(trim(document.frmMain.dataDesconto1.value)==''){
							habilitaCampoDependente(campo,document.frmMain.prazoDesconto1);
						}
						if(document.frmMain.indicadorSolicitacao.value == 6){
							if(trim(document.frmMain.prazoDesconto1.value)==''){							
								habilitaCampoDependente(campo,document.frmMain.dataDesconto1);
							}
						}
						habilitaCampoDependente(campo,document.frmMain.percentualDesconto2);
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto1);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto1);
						desabilitaCampoDependente(campo, campo, document.frmMain.percentualDesconto2);
						desabilitaCampoDependente(campo2, campo2, document.frmMain.valorDesconto2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.percentualDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.valorDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto3);															
					}
				}//fim campo percentualDesconto1

				if(campo == document.frmMain.valorDesconto1 ){
					
					campo2 = document.frmMain.percentualDesconto1;

					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, campo2);
					}
					else{
						if(trim(document.frmMain.dataDesconto1.value)==''){						
							habilitaCampoDependente(campo,document.frmMain.prazoDesconto1);
						}
						if(document.frmMain.indicadorSolicitacao.value == 6){
							if(trim(document.frmMain.prazoDesconto1.value)==''){													
								habilitaCampoDependente(campo,document.frmMain.dataDesconto1);
							}
						}
						habilitaCampoDependente(campo,document.frmMain.valorDesconto2);						
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto1);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto1);
						desabilitaCampoDependente(campo2, campo2, document.frmMain.percentualDesconto2);
						desabilitaCampoDependente(campo, campo, document.frmMain.valorDesconto2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto2);			
						desabilitaCampoDependente(campo, campo2, document.frmMain.percentualDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.valorDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto3);																		
					}
				}//fim campo valorDesconto1			

				if(campo == document.frmMain.prazoDesconto1 ){
					if(window.event.type == "focus"){
						if(document.frmMain.indicadorSolicitacao.value == 6){
							habilitaCampoAlternado(campo, document.frmMain.dataDesconto1);
						}
					}
					else{
  					habilitaCampoDependente2(document.frmMain.valorDesconto2, document.frmMain.percentualDesconto2, document.frmMain.prazoDesconto2);
   					habilitaCampoDependente2(document.frmMain.valorDesconto3, document.frmMain.percentualDesconto3, document.frmMain.prazoDesconto3); 					
						desabilitaCampoAlternado(campo, document.frmMain.dataDesconto1);
						desabilitaCampoDependente(campo, campo, document.frmMain.prazoDesconto2);
						desabilitaCampoDependente(campo, campo, document.frmMain.prazoDesconto3);
					}
				}//fim campo prazoDesconto1						

				if(campo == document.frmMain.dataDesconto1 ){
					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, document.frmMain.prazoDesconto1);
					}
					else{
  					habilitaCampoDependente2(document.frmMain.valorDesconto2, document.frmMain.percentualDesconto2, document.frmMain.dataDesconto2);
   					habilitaCampoDependente2(document.frmMain.valorDesconto3, document.frmMain.percentualDesconto3, document.frmMain.dataDesconto3);
						desabilitaCampoAlternado(campo, document.frmMain.prazoDesconto1);
						desabilitaCampoDependente(campo, campo, document.frmMain.dataDesconto2);
  					desabilitaCampoDependente(campo, campo, document.frmMain.dataDesconto3);		
					}
				}//fim campo dataDesconto1						

				if(campo == document.frmMain.percentualDesconto2){

					campo2 = document.frmMain.valorDesconto2;
					
					if(window.event.type != "focus"){
						habilitaCampoDependente(campo,document.frmMain.prazoDesconto2);
						if(document.frmMain.indicadorSolicitacao.value == 6){
							habilitaCampoDependente(campo,document.frmMain.dataDesconto2);
						}					
						desabilitaCampoAlternado(document.frmMain.dataDesconto1, document.frmMain.prazoDesconto2);
						desabilitaCampoAlternado(document.frmMain.dataDesconto1, document.frmMain.prazoDesconto3);						
						desabilitaCampoAlternado(document.frmMain.prazoDesconto1, document.frmMain.dataDesconto2);
  					desabilitaCampoAlternado(document.frmMain.prazoDesconto1, document.frmMain.dataDesconto3);
						habilitaCampoDependente(campo,document.frmMain.percentualDesconto3);
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto2);
						desabilitaCampoDependente(campo, campo, document.frmMain.percentualDesconto3);
						desabilitaCampoDependente(campo2, campo2, document.frmMain.valorDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto3);						
					}
				}//fim campo percentualDesconto2

				if(campo == document.frmMain.valorDesconto2 ){

					campo2 = document.frmMain.percentualDesconto2;
						
					if(window.event.type != "focus"){
						habilitaCampoDependente(campo,document.frmMain.prazoDesconto2);
						if(document.frmMain.indicadorSolicitacao.value == 6){						
							habilitaCampoDependente(campo,document.frmMain.dataDesconto2);
						}
						desabilitaCampoAlternado(document.frmMain.dataDesconto1, document.frmMain.prazoDesconto2);
						desabilitaCampoAlternado(document.frmMain.dataDesconto1, document.frmMain.prazoDesconto3);						
						desabilitaCampoAlternado(document.frmMain.prazoDesconto1, document.frmMain.dataDesconto2);
						desabilitaCampoAlternado(document.frmMain.prazoDesconto1, document.frmMain.dataDesconto3);
						habilitaCampoDependente(campo,document.frmMain.valorDesconto3);						
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto2);
						desabilitaCampoDependente(campo2, campo2, document.frmMain.percentualDesconto3);
						desabilitaCampoDependente(campo, campo, document.frmMain.valorDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto3);														
					}
				}//fim campo valorDesconto2			

				if(campo == document.frmMain.prazoDesconto2 ){
					if(window.event.type != "focus"){
   					habilitaCampoDependente2(document.frmMain.valorDesconto3, document.frmMain.percentualDesconto3, document.frmMain.prazoDesconto3); 	
						desabilitaCampoAlternado(campo, document.frmMain.dataDesconto2);
						desabilitaCampoDependente(campo, campo, document.frmMain.prazoDesconto3);				
					}
				}//fim campo prazoDesconto2						
			
				if(campo == document.frmMain.dataDesconto2 ){
					if(window.event.type != "focus"){
   					habilitaCampoDependente2(document.frmMain.valorDesconto3, document.frmMain.percentualDesconto3, document.frmMain.dataDesconto3);  										
						desabilitaCampoAlternado(campo, document.frmMain.prazoDesconto2);
  					desabilitaCampoDependente(campo, campo, document.frmMain.dataDesconto3);		
					}
				}//fim campo dataDesconto2						

				if(campo == document.frmMain.percentualDesconto3){

					campo2 = document.frmMain.valorDesconto3;
					
					if(window.event.type != "focus"){
						habilitaCampoDependente(campo,document.frmMain.prazoDesconto3);
						if(document.frmMain.indicadorSolicitacao.value == 6){
							habilitaCampoDependente(campo,document.frmMain.dataDesconto3);
						}
						desabilitaCampoAlternado(document.frmMain.dataDesconto1, document.frmMain.prazoDesconto3);						
						desabilitaCampoAlternado(document.frmMain.prazoDesconto1, document.frmMain.dataDesconto3);
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto3);
					}
				}//fim campo percentualDesconto3

				if(campo == document.frmMain.valorDesconto3 ){

					campo2 = document.frmMain.percentualDesconto3;

					if(window.event.type != "focus"){
						habilitaCampoDependente(campo,document.frmMain.prazoDesconto3);
						if(document.frmMain.indicadorSolicitacao.value == 6){
							habilitaCampoDependente(campo,document.frmMain.dataDesconto3);
						}						
						desabilitaCampoAlternado(document.frmMain.dataDesconto1, document.frmMain.prazoDesconto3);						
						desabilitaCampoAlternado(document.frmMain.prazoDesconto1, document.frmMain.dataDesconto3);
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoDesconto3);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataDesconto3);
					}
				}//fim campo valorDesconto3		
		
				if(campo == document.frmMain.prazoDesconto3 ){
					if(window.event.type != "focus"){
						desabilitaCampoAlternado(campo, document.frmMain.dataDesconto3);
					}
				}//fim campo prazoDesconto3						

				if(campo == document.frmMain.dataDesconto3 ){
					if(window.event.type != "focus"){
						desabilitaCampoAlternado(campo, document.frmMain.prazoDesconto3);
					}
				}//fim campo dataDesconto3						

				if(campo == document.frmMain.percentualMulta){

					campo2 = document.frmMain.valorMulta;

					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, campo2);
					}
					else{
						habilitaCampoDependente(campo,document.frmMain.prazoMulta);
						if(document.frmMain.indicadorSolicitacao.value == 6){
							habilitaCampoDependente(campo,document.frmMain.dataMulta);
						}
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoMulta);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataMulta);
					}
				}//fim campo percentualMulta

				if(campo == document.frmMain.valorMulta ){

					campo2 = document.frmMain.percentualMulta;

					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, campo2);
					}
					else{
						habilitaCampoDependente(campo,document.frmMain.prazoMulta);
						if(document.frmMain.indicadorSolicitacao.value == 6){
							habilitaCampoDependente(campo,document.frmMain.dataMulta);
						}
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.prazoMulta);
						desabilitaCampoDependente(campo, campo2, document.frmMain.dataMulta);
					}
				}//fim campo valorMulta		

				if(campo == document.frmMain.prazoMulta ){
					if(window.event.type == "focus"){
						if(document.frmMain.indicadorSolicitacao.value == 6){
							habilitaCampoAlternado(campo, document.frmMain.dataMulta);
						}
					}
					else{
						desabilitaCampoAlternado(campo, document.frmMain.dataMulta);
					}
				}//fim campo prazoMulta						
			
				if(campo == document.frmMain.dataMulta ){
					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, document.frmMain.prazoMulta);
					}
					else{
						desabilitaCampoAlternado(campo, document.frmMain.prazoMulta);
					}
				}//fim campo dataMulta						
	    
	    }
 		function valida_vencto() {
			if (verifica_dia_no_intervalo(document.frmMain.diaEmissao.value, 11, document.frmMain.diaVencimento.value)) {
				msg ("047");
				return false ; // NOk
			} else {
				return true; // OK
			}
		}	    
			<%//EAM - 31/08 - SISOT 139 - INI%>
			function emiteMensagemCombo(campo1, campo2, nomeCampo1, nomeCampo2 ){
				<%//Obter a descrição dos itens selecionados %>
				var campo1Desc = campo1.options[campo1.selectedIndex].text;
				var campo2Desc = campo2.options[campo2.selectedIndex].text;
				msg('065', nomeCampo1, campo1Desc, campo2Desc, false, nomeCampo2);
		  }
		  <%//EAM - 31/08 - SISOT 139 - FIM%>				    

			<%//EAM - 14/10/2005 - INI%>
			<%//Passar sempre o valor no campo1 e a data/dia no campo2%>
			function desabilitaGrid(campo1, campo2){
				if(campo1 == '0' || campo2 == '' ){
					document.frmMain.percentualDesconto1.value='';
					document.frmMain.percentualDesconto2.value='';
					document.frmMain.percentualDesconto3.value='';
					document.frmMain.percentualMulta.value='';
					document.frmMain.valorDesconto1.value='';
					document.frmMain.valorDesconto2.value='';					
					document.frmMain.valorDesconto3.value='';
					document.frmMain.valorMulta.value='';
					document.frmMain.prazoDesconto1.value='';
					document.frmMain.prazoDesconto2.value='';
					document.frmMain.prazoDesconto3.value='';
					document.frmMain.prazoMulta.value='';
					document.frmMain.dataDesconto1.value='';
					document.frmMain.dataDesconto2.value='';
					document.frmMain.dataDesconto3.value='';
					document.frmMain.dataMulta.value='';
					document.frmMain.percentualDesconto1.disabled=true;
					document.frmMain.percentualDesconto2.disabled=true;
					document.frmMain.percentualDesconto3.disabled=true;
					document.frmMain.percentualMulta.disabled=true;
					document.frmMain.valorDesconto1.disabled=true;
					document.frmMain.valorDesconto2.disabled=true;
					document.frmMain.valorDesconto3.disabled=true;
					document.frmMain.valorMulta.disabled=true;
					document.frmMain.prazoDesconto1.disabled=true;
					document.frmMain.prazoDesconto2.disabled=true;
					document.frmMain.prazoDesconto3.disabled=true;
					document.frmMain.prazoMulta.disabled=true;
					document.frmMain.dataDesconto1.disabled=true;
					document.frmMain.dataDesconto2.disabled=true;
					document.frmMain.dataDesconto3.disabled=true;
					document.frmMain.dataMulta.disabled=true;
				}	else{
					if (document.frmMain.valorDesconto1.value == '')
						document.frmMain.percentualDesconto1.disabled=false;
					if (document.frmMain.percentualDesconto1.value == '')
						document.frmMain.valorDesconto1.disabled=false;
					if (document.frmMain.valorMulta.value == '')
						document.frmMain.percentualMulta.disabled=false;
					if (document.frmMain.percentualMulta.value == '')
						document.frmMain.valorMulta.disabled=false;
				}
			}
			
			function verificaValorData(){
			 	var campo =  new Number(desformataMoney(document.frmMain.valorSolicitacao.value));
				var campo1 = parseInt(campo);
			 	<%if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(6))){%>
			 	var campo2 = document.frmMain.dataVencimento.value;
			 	<%}else if (solicitacaoBean.getIndicadorSolicitacao().equals(new Long(7))){%>
			 	var campo2 = document.frmMain.diaVencimento.value;
		 		<%}%>
			 	if(document.frmMain.registroCombo.value == 'N'){
		   		if(document.frmMain.formaObtencaoValor.value==1){//Informado pelo usuario
						desabilitaGrid(campo1,campo2);										
					}else{<%//Se Forma de Obtenção de Valor for "Banco de Sacados, verificar apenas a Data/Dia"%>
						desabilitaGrid(-1,campo2);										
					}
				}else{<%//Se Registro for "Sim", não desabilita%>
					desabilitaGrid(-1,-1);										
				}
			}
			
			
			function ConfiguraSMS(){
				if (document.frmMain.envioBloqueto.value=="5" || document.frmMain.envioBloqueto.value=="7" ){
					document.frmMain.tipoSMS.disabled = false;
				}else{
					document.frmMain.tipoSMS.disabled = true;
					document.frmMain.tipoSMS.value="00";
				}
				
				
				
			}
			<%//EAM - 14/10/2005 - FIM%>	
    </script>

  </s:FormStrategy>
</p:Document>
</html>