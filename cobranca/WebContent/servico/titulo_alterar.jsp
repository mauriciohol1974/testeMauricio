<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: titulo_alterar.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 18/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoTituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.util.UtilDatas"%>

<%
	BorderoBean borderoBean = (session.getAttribute(TituloEstrategia.BORDERO_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(TituloEstrategia.BORDERO_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(TituloEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TituloEstrategia.CEDENTE_CABECALHO_BEAN));
	BorderoTituloBean tituloFixoBean = (session.getAttribute(TituloEstrategia.FIXO_BEAN)==null?new BorderoTituloBean():(BorderoTituloBean)session.getAttribute(TituloEstrategia.FIXO_BEAN));
	BorderoTituloBean borderoTituloBean = (session.getAttribute(TituloEstrategia.DATA_BEAN)==null?new BorderoTituloBean():(BorderoTituloBean)session.getAttribute(TituloEstrategia.DATA_BEAN));
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(TituloEstrategia.USUARIOLDAP_BEAN);
	
	String dddCelular =  String.valueOf(borderoTituloBean.getDddSMS()==null? "" :  borderoTituloBean.getDddSMS());
	String foneCelular = String.valueOf(borderoTituloBean.getCelularSMS()==null? "" : borderoTituloBean.getCelularSMS());
	
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TituloEstrategia.STRATEGY_ALTERAR_EFETIVAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TituloEstrategia.PAGE_TITLE_ALTERAR%>"/>
		<input type="hidden" name="valorTeste" value='R$ 0,00'>
 		<input type="hidden" name ="cep" value=''>
 		<input type="hidden" name ="endereco" value=''>
 		<input type="hidden" name ="bairro" value=''>
 		<input type="hidden" name ="municipio" value=''>
 		<input type="hidden" name ="uf" value=''>
 		
		<input type="hidden" name ="cepSacado" value=''>
		<input type="hidden" name ="dataVencimento" value=''>
		<input type="hidden" name ="cpfCnpjSacado" value=''>
		<input type="hidden" name ="cpfCnpjSacador" value=''>
		<input type="hidden" name ="cpfCnpjTemp" value=''>
		<input type="hidden" name ="dataTemp" value=''>
		
		<input type="hidden" name="codigoCedente" value='<%=borderoBean.getCodigoCedente()%>'>
		<input type="hidden" name="codigoBordero" value='<%=borderoBean.getCodigoBordero()%>'>
		<input type="hidden" name="registro" value="<%=borderoTituloBean.getRegistro()%>">
		<input type="hidden" name="numeroSequencial" value="<%=borderoTituloBean.getNumeroSequencial()%>">
		<input type="hidden" name="nossoNumero" value="<%=borderoTituloBean.getNossoNumero()%>">
 		<input type="hidden" name = "dataHoje" value="<%=UtilDatas.getToday()%>">

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
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoBordero()%></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Total de Títulos:</td>
              <td class="textoValor" width="26%"><%=tituloFixoBean.getTotalTitulos()%></td>
              <td class="textoTitulo" width="17%">Título Atual:</td>
              <td class="textoValor" width="26%"><%=borderoTituloBean.getNumeroSequencial()%></td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Alterar Título:
                <hr>
              </td>
            </tr>

						<tr>
              <td colspan="4">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Número Documento: </td>
				              <td class="textoValor" width="26%" nowrap> 
				                <p:InputAlfanumerico name="numeroDocumento" maxlength="11" size="20" 
				                	value="<%=borderoTituloBean.getNumeroDocumento()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataVencimentoInput);"/>
                      </td>
                      <td class="textoTitulo" width="17%">Nosso Número: </td>
				              <td class="textoValor" width="26%" nowrap> 
				                <p:InputNumerico name="nossoNumeroInput" maxlength="18" size="23"  
				                	value='<%=borderoTituloBean.getNossoNumero().equals(new Long(0))?"":borderoTituloBean.getNossoNumero().toString()%>'  
				                	disabled="true"
				                	CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataVencimentoInput);"/>
                      </td>
                    </tr>

                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data de Vencimento: </td>
				              <td class="textoValor" width="26%" nowrap> 
        				        <p:InputDate name="dataVencimentoInput" 
               						value ='<%=borderoTituloBean.getDataVencimentoFormatada()%>' CLASS="inputtext"
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataDocumento);"/> 
                      </td>
                      <td nowrap class="textoTitulo" width="17%">Data de Emissão: </td>
				              <td class="textoValor" width="26%" nowrap> 
        				        <p:InputDate name="dataDocumento" 
               						value ='<%=borderoTituloBean.getDataDocumentoFormatada()%>' CLASS="inputtext"
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.abatimento);" />
                      </td>
                    </tr>

                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Abatimento: </td>
				              <td width="26%" nowrap> 
        				        <p:InputCurrency name="abatimento" maxlength="15" size="27" 
               						value='<%=borderoTituloBean.getAbatimento().toString().equals("R$ 0,00")?"":borderoTituloBean.getAbatimento().toString()%>' 
               						CLASS="inputtext"
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.valorTitulo);"/> 
                      </td>
                      <td nowrap class="textoTitulo" width="17%">Valor do Título: </td>
				              <td class="textoValor" width="26%" nowrap> 
        				        <p:InputCurrency name="valorTitulo" maxlength="15" size="27" 
               						value='<%=borderoTituloBean.getValorTitulo().toString().equals("R$ 0,00")?"":borderoTituloBean.getValorTitulo().toString()%>' 
               						CLASS="inputtext"
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nomeSacado);"/> 
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Nome do Sacado: </td>
                      <td class="textoValor" width="26%">
				                <p:InputAlfanumerico name="nomeSacado" maxlength="40" size="30" 
				                	value="<%=borderoTituloBean.getNomeSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.emailSacado);"/>
                      </td>
                      <td class="textoTitulo" width="17%">e-mail do Sacado: </td>
                      <td class="textoValor" width="26%">
				                <p:InputEmail name="emailSacado" maxlength="50" size="30" 
				                	value="<%=borderoTituloBean.getEmailSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.tipoPessoaSacado);"/>
											</td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Tipo Pessoa Sacado: </td>
                      <td class="textoValor" width="26%">
                        <s:ComboTipoPessoa name="tipoPessoaSacado" selectedValue='<%=borderoTituloBean.getTipoPessoaSacado().equals(new Long(0))?"1":borderoTituloBean.getTipoPessoaSacado().toString()%>'
                         	onChange="javascript:limpaCpfCnpj(cpfCnpjSacadoInput);"
                        />
											</td>
                      <td nowrap class="textoTitulo" width="17%">CPF/CNPJ do Sacado: </td>
				              <td width="26%" nowrap> 
				              	<p:InputCpfCnpj name="cpfCnpjSacadoInput"
				              		value='<%=borderoTituloBean.getCpfCnpjSacadoFormatado()%>' CLASS="inputtext" 
				              		onBlur="javascript:formataCpfCnpj(this,tipoPessoaSacado);" 
				              		onFocus="javascript:unFormataCpfCnpj(this,tipoPessoaSacado);prevFocus(this);"
				              		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.cepInput);"/>
                      </td>
                    </tr>
                    
                    <tr>
                      <td class="textoTitulo" width="17%">CEP do Sacado: </td>
                      <td class="textoValor" width="26%">
				              	<p:InputCep name="cepInput"
				              		value='<%=borderoTituloBean.getCepSacado().equals(new Long(0))?"":borderoTituloBean.getCepSacadoFormatado()%>' CLASS="inputtext" 
				              		onFocus="prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Procurar);"/>
			                 	<s:Button name="Procurar" action="javascript: formSubmit_ProcurarCEP();"/>
                      </td>
                      <td class="textoTitulo" width="17%">UF do Sacado: </td>
                      <td class="textoValor" width="26%">
                        <s:ComboUf name="ufSacado" selectedValue='<%=borderoTituloBean.getUfSacado()%>' onChange='javascript:validaAlteracaoEndereco()'/>
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Endereço do Sacado: </td>
				              <td width="26%" nowrap> 
				                <p:InputAlfanumericoCep name="enderecoSacado" maxlength="40" size="30" 
				                	value="<%=borderoTituloBean.getEnderecoSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.numeroSacado);"/>
                      </td>
                      <td class="textoTitulo" width="17%">Número do Sacado: </td>
                      <td class="textoValor" width="26%">
				                <p:InputAlfanumerico name="numeroSacado" maxlength="15" size="18" 
				                	value="<%=borderoTituloBean.getNumeroSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.complSacado);"/>
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Complemento do Sacado: </td>
				              <td width="26%" nowrap> 
				                <p:InputAlfanumerico name="complSacado" maxlength="25" size="30" 
				                	value="<%=borderoTituloBean.getComplSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.bairroSacado);"/>
                      </td>
                      <td class="textoTitulo" width="17%">Bairro do Sacado: </td>
                      <td class="textoValor" width="26%">
				                <p:InputAlfanumericoCep name="bairroSacado" maxlength="25" size="30" 
				                	value="<%=borderoTituloBean.getBairroSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.municipioSacado);"/>
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Município do Sacado: </td>
                      <td class="textoValor" width="26%">
				                <p:InputAlfanumericoCep name="municipioSacado" maxlength="35" size="30" 
				                	value="<%=borderoTituloBean.getMunicipioSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp='<%=tituloFixoBean.getEndosso().equals("S")?"javascript: nextFocus(event.keyCode, this, document.frmMain.nomeSacadorAvalista);":"javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"%>'/>
                      </td>
                      <td class="textoTitulo" width="17%">Nome Sacador/Avalista: </td>
                      <td class="textoValor" width="26%">
				                <p:InputAlfanumerico name="nomeSacadorAvalista" maxlength="40" size="30" 
				                	value="<%=borderoTituloBean.getNomeSacadorAvalista()%>" CLASS="inputtext"
				                	disabled='<%=tituloFixoBean.getEndosso().equals("S")?"false":"true"%>'
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.tipoPessoaSacador);"/>
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Tipo Pessoa Sacador: </td>
                      <td class="textoValor" width="26%">
	                    <%if(tituloFixoBean.getEndosso().equals("S")){%>
	                       <s:ComboTipoPessoa name="tipoPessoaSacador" selectedValue='<%=borderoTituloBean.getTipoPessoaSacador().toString()%>'
                        		onChange="javascript:limpaCpfCnpj(cpfCnpjSacadorInput);"
	                       />
											<%}
												else{%>
	                       <s:ComboTipoPessoa name="tipoPessoaSacador" disabled="true" branco="true" brancoValue="0" selectedValue='<%=borderoTituloBean.getTipoPessoaSacador().toString()%>' />
											<%}%>
                      </td>
                      <td nowrap class="textoTitulo" width="17%">CPF/CNPJ do Sacador: </td>
				              <td width="26%" nowrap> 
				              	<p:InputCpfCnpj name="cpfCnpjSacadorInput"
				              		value='<%=borderoTituloBean.getCpfCnpjSacadorFormatado()%>' CLASS="inputtext" 
				                	disabled='<%=tituloFixoBean.getEndosso().equals("S")?"false":"true"%>'
				              		onBlur="javascript:formataCpfCnpj(this,tipoPessoaSacador);" 
				              		onFocus="javascript:unFormataCpfCnpj(this,tipoPessoaSacador);prevFocus(this);"
				              		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>
                      </td>
										</tr>
										
					 <tr>
					  	<td nowrap class="textoTitulo" width="17%">DDD/Celular: </td>
					  	<td>
					  				<p:InputNumerico name="dddSMS" value="<%=dddCelular %>" maxlength="2" size="3"   
				                	CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);" onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.celularSMS);"/>
				                
									<p:InputNumerico name="celularSMS"  value="<%=foneCelular %>" maxlength="9" size="12"   
				                	CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.tipoSMS);"/>
				        </td>
					  	<td nowrap class="textoTitulo" width="17%">Tipo de SMS: </td>
					  	<td>
					  	 <select size="1" name="tipoSMS">
							<option <%=borderoTituloBean.getTipoSMS().equals("00") ? "selected='selected'" : ""%> value="00"></option>
							<option <%=borderoTituloBean.getTipoSMS().equals("01") ? "selected='selected'" : ""%> value="01">Informativa</option>
							<option <%=borderoTituloBean.getTipoSMS().equals("02") ? "selected='selected'" : ""%>value="02">Repr. Numérica</option>
							<option <%=borderoTituloBean.getTipoSMS().equals("03") ? "selected='selected'" : ""%>value="03">PEC</option>
						</select>
						</td>
					  </tr>					
										
										
					<tr>
                        <td nowrap class="textoTitulo" width="17%">IOF a ser Retido: </td>
				              <td width="26%" nowrap> 
        				        <p:InputCurrency name="retidoValorIOF" maxlength="15" size="27" 
               						value='<%=borderoTituloBean.getRetidoValorIOF().toString().equals("R$ 0,00")?"":borderoTituloBean.getRetidoValorIOF().toString()%>' 
               						CLASS="inputtext"
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/> 
                        </td>
                      
                     </td>
                      
                      <td nowrap class="textoTitulo" width="17%">Indicador Registro na CIP: </td>
                      <td width="26%" nowrap> 
                      <% if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){ %>
                      		<s:ComboSimNao name="indRegCip" selectedValue='<%=borderoTituloBean.getIndRegCip().trim().equals("")?"S":borderoTituloBean.getIndRegCip()%>' />
                      <%}else{ %>
                      		<s:ComboSimNao name="indRegCip" selectedValue='<%=borderoTituloBean.getIndRegCip().trim().equals("")?"S":borderoTituloBean.getIndRegCip()%>' disabled="true"/>
                      <%} %>
                      </td>
                    </tr>
                    
                    <tr>
                    	<td nowrap class="textoTitulo" width="17%">Autoriza Pagamento Parcial/Divergente: </td>
                      	<td width="26%" nowrap> 
                       		<s:ComboSimNao name="icParcial" selectedValue='<%=borderoTituloBean.getIcParcial().trim().equals("S")?"S":borderoTituloBean.getIcParcial()%>'  onChange="javascript: icParcialChange();"/>
                      	</td>
                    </tr>
                    
                    <tr>
                    		
                    	<td nowrap class="textoTitulo" width="17%">Tipo de Pagamento: </td>
					  	<td colspan="3">
					  	<div id="exibeCombo" style="display: none;">
						  	 <select size="1" name="tipoPgto" onChange="javascript: controlaTpPagamento(this);" style="width: 300px">
						  	 	<option <%=borderoTituloBean.getTipoPgto().equals("1") ? "selected='selected'" : ""%>value="1">Aceita qualquer valor </option>
								<option <%=borderoTituloBean.getTipoPgto().equals("2") ? "selected='selected'" : ""%>value="2">Aceita valores entre range mínimo e máximo      </option>
								<option <%=borderoTituloBean.getTipoPgto().equals("4") ? "selected='selected'" : ""%>value="4">Aceita valores considerando apenas o valor mínimo  </option>
							</select>
						</div>
						<div id="blockCombo" style="display: block;">
								  <input  style="width: 300px" size="60" type="text" value="3-Não aceita valor divergente" disabled="disabled" />
						</div>
						</td>
                    
                    </tr>
                    
                    
                    <tr>
                    	<td nowrap class="textoTitulo" width="17%">Valor Máximo Pagamento:  </td>
						<td class="textoValor" width="26%" nowrap> 
						  <p:InputCurrency name="valorMaxPgto" maxlength="15" size="27" 
							value='<%=borderoTituloBean.getValorMaxPgto().toString().equals("R$ 0,00")?"":borderoTituloBean.getValorMaxPgto().toString()%>' 
						  						CLASS="inputtext"
						  						onFocus="javascript: prevFocus(this);"
							onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nomeSacado);"/> 
						</td>
						
                      	
                    </tr>
                    
                    <tr>
                    	<td nowrap class="textoTitulo" width="17%">Valor Mínimo Pagamento:  </td>
						<td class="textoValor" width="26%" nowrap> 
						  <p:InputCurrency name="valorMinPgto" maxlength="15" size="27" 
							value='<%=borderoTituloBean.getValorMinPgto().toString().equals("R$ 0,00")?"":borderoTituloBean.getValorMinPgto().toString()%>' 
						  						CLASS="inputtext"
						  						onFocus="javascript: prevFocus(this);"
							onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nomeSacado);"/> 
						</td>
						<td nowrap class="textoTitulo" width="17%"> Qtde. Pagamentos Possíveis: </td>
                      	<td width="26%" nowrap> 
                       		<p:InputNumerico name="qtdePossivel" maxlength="3" size="3"
			                						CLASS="inputtext" 
 				               						value ='<%=borderoTituloBean.getQtdePossivel().toString()%>'			                									                						
 				               						onFocus="javascript: prevFocus(this);"	/>
                      	</td>
                      	
                    </tr>
                    
                    					
                  </table>
								</td>                  
            </tr>
            <tr> 
	            <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
	            <td align="right" colspan="4">
  	            <p align="center"> 
                 	<s:Button name="Confirmar" action="javascript: formSubmit();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.alterar"/>
                 	<s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
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
    <script language="javascript">
			function inicia() {
				setFirstFieldFocus();
				controlaTpPagamento();
				icParcialChange();
			}
	    function formSubmit() {

        if (validaSubmit()) {
	    		if (confirm(conf("101", "Título"))) {
		        document.frmMain.cepSacado.value = document.frmMain.cepInput.value;
		        unFormataCep(document.frmMain.cepSacado);
						document.frmMain.dataVencimento.value= substituiBarraPorPonto(document.frmMain.dataVencimentoInput.value);
						document.frmMain.cpfCnpjSacado.value= document.frmMain.cpfCnpjSacadoInput.value;
						unFormataCpfCnpj(document.frmMain.cpfCnpjSacado,document.frmMain.tipoPessoaSacado)
						document.frmMain.cpfCnpjSacador.value=document.frmMain.cpfCnpjSacadorInput.value;
						unFormataCpfCnpj(document.frmMain.cpfCnpjSacador,document.frmMain.tipoPessoaSacador) 
		        document.frmMain.submit();
		      }
        }
	    }
			function validaSubmit() {

	    	var camposObrigatorios = new Array(17);
  			<%=tituloFixoBean.getEmissaoBloqueto().equals(new Long(1))?"camposObrigatorios[0] = new Array( 'nossoNumero', 'Nosso Número' );":""%>
				camposObrigatorios[1] = new Array( 'dataVencimentoInput', 'Data de Vencimento' );
	    	camposObrigatorios[2] = new Array( "dataDocumento", "Data de Emissão" );
	    	camposObrigatorios[3] = new Array( "valorTitulo", "Valor do Título" );
	    	camposObrigatorios[4] = new Array( "nomeSacado", "Nome do Sacado" );
  			<%=tituloFixoBean.getEnvioBloqueto().equals(new Long(3))?"camposObrigatorios[5] = new Array( 'emailSacado', 'e-mail do Sacado' );":""%>
	    	camposObrigatorios[6] = new Array( "tipoPessoaSacado", "Tipo Pessoa Sacado" );
	    	camposObrigatorios[7] = new Array( "cpfCnpjSacadoInput", "CPF/CNPJ do Sacado" );
	    	camposObrigatorios[8] = new Array( "cepInput", "CEP do Sacado" );
	    	camposObrigatorios[9] = new Array( "ufSacado", "UF do Sacado" );
	    	camposObrigatorios[10] = new Array( "enderecoSacado", "Endereço do Sacado" );
	    	camposObrigatorios[11] = new Array( "numeroSacado", "Número do Sacado" );
	    	camposObrigatorios[12] = new Array( "bairroSacado", "Bairro do Sacado" );
	    	camposObrigatorios[13] = new Array( "municipioSacado", "Município do Sacado" );
  			<%=tituloFixoBean.getEndosso().equals("S")?"camposObrigatorios[14] = new Array( 'nomeSacadorAvalista', 'Nome Sacador/Avalista' );":""%>
  			<%=tituloFixoBean.getEndosso().equals("S")?"camposObrigatorios[15] = new Array( 'tipoPessoaSacador', 'Tipo Pessoa Sacador' );":""%>
  			<%=tituloFixoBean.getEndosso().equals("S")?"camposObrigatorios[16] = new Array( 'cpfCnpjSacadorInput', 'CPF/CNPJ do Sacador' );":""%>
 	    	camposObrigatorios[17] = new Array( "numeroDocumento", "Número Documento" );		    
		    
		    if(!validaArrayCamposObrigatorios(camposObrigatorios)){
		      return false;
		    }
        
        if (trim(document.frmMain.dataVencimentoInput.value) != ""){ 
		    	if(!validaDataEspecial(document.frmMain.dataVencimentoInput)) {
				  	msg('014','Data de Vencimento');
				    document.frmMain.dataVencimentoInput.focus();
				    return false;
				   }
		    }
        if (trim(document.frmMain.dataDocumento.value) != ""){ 
		    	if(!validaDataFoco(document.frmMain.dataDocumento)) {
				  	msg('014','Data de Emissão');
				    document.frmMain.dataDocumento.focus();
				    return false;
				   }
		    }		    
		    if(trim(document.frmMain.dataDocumento.value) != "" && validaData(document.frmMain.dataDocumento)){
		    	if(!compararDatas(document.frmMain.dataDocumento.value,document.frmMain.dataHoje.value,"<=")){
		    		msg("040", "Data de Emissão", document.frmMain.dataHoje.value)
		    		return false;
		    	}
		    }
				if(trim(document.frmMain.valorTitulo.value) != ""){
					//if(!validaValorZero(document.frmMain.valorTitulo, "Valor do Título")){
					//return false;
					//}
				}
				if(trim(document.frmMain.valorTitulo.value) != "" && trim(document.frmMain.abatimento.value) != ""){
					if (comparaValor(document.frmMain.abatimento, document.frmMain.valorTeste , ">")) {
						if(!comparaValor(document.frmMain.valorTitulo, document.frmMain.abatimento, ">")){
							msg('007','Abatimento', 'Valor do Título');
							return false;
						}
					}
				}
				if(document.frmMain.emailSacado.value != ''){
					if(validaEmail(document.frmMain.emailSacado.value)){
						msg("049");
						return false;
					}
				}						
				if(!validaDvCpfCnpj(document.frmMain.cpfCnpjSacadoInput,document.frmMain.tipoPessoaSacado)){
					msg('008','CPF/CNPJ do Sacado');
			    return false;
				}
		<%if (tituloFixoBean.getEndosso().equals("S")){%>
				if(!validaDvCpfCnpj(document.frmMain.cpfCnpjSacadorInput,document.frmMain.tipoPessoaSacador)){
					msg('008','CPF/CNPJ do Sacador');
			    return false;
				}
		<%}%>
        // Valida CPF/CNPJ sacado, sacador e cedente ser diferente um do outro.
				if (document.frmMain.cpfCnpjSacadoInput.value == document.frmMain.cpfCnpjSacadorInput.value) {
					msg('043');
					return false;
				}
				if (document.frmMain.cpfCnpjSacadoInput.value == '<%=cedCabBean.getCpfCnpjFormatado()%>') {
					msg('044');
					return false;
				}
				if (document.frmMain.cpfCnpjSacadorInput.value == '<%=cedCabBean.getCpfCnpjFormatado()%>') {
					msg('045');
					return false;
				}
				
        return true;
		  }
	    function formSubmit_Voltar() {
    		if (confirm(conf("103"))) {
           document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_MANTER_LISTAR%>";
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
        }
      }
    	
    	function validaDataFoco(objData){
	    	try{
					objTemp = document.frmMain.dataTemp
					objTemp.value='';
					objTemp.value= objData.value;
					unFormataData(objTemp);
				 	formataData(objTemp);
					
					if(objTemp.value != ''){
			  		return validaData(objTemp);
			  	}
	  	  }catch(erro){
	  	  	objData.focus()}
			}
			
			function validaDataEspecial(obj){
				if(obj.value != "88/88/8888" && obj.value != "99/99/9999"){
					return validaDataFoco(obj);
				}
				return true;
			}

			// Atencao: Para utilizar corretamente a tela/funcao de Pesquisa de Cep, é necessário:
			// - Possuir um form chamado frmMain
			// - No frmMain possuir os campos hidden: cep, endereco, bairro, municipio, uf
			// - Adaptar a funcao atualizar_endereco() para atualizar os campos de tela efetivos
			// - o form, os campos e a funcao sao referenciados pela tela de Pesquisa de Cep
	    function formSubmit_ProcurarCEP() {
		    if(validaCampoObrigatorio(document.frmMain.cepInput, 'Cep Sacado')){
					document.frmMain.cep.value = document.frmMain.cepInput.value;
					unFormataCep(document.frmMain.cep);

					var valorAltura = 180;
					var valorLargura = 450;
					var valorTopo = (screen.height - valorAltura) /2;
					var valorEsquerda = (screen.width - valorLargura) /2;
		    	var retorno = window.open('<%=Paths.getRootForDynamicContent()%>/jump/procurar_cep_jump.jsp', 
		    														'procurar_cep<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>', 
		    														'width=' +valorLargura+ ', height=' +valorAltura+ ', top=' +valorTopo+ ', left=' +valorEsquerda+ ', toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizable=0');
		    	retorno.focus();
		    }
	    } 
	    function atualizar_endereco() {
		  	//EAM - procurarCep = variavel global criada pela tag InputAlfanumericoCep
		  	procurarCep = true;		    
		    document.frmMain.enderecoSacado.value = document.frmMain.endereco.value;
		    document.frmMain.bairroSacado.value = document.frmMain.bairro.value;
		    document.frmMain.municipioSacado.value = document.frmMain.municipio.value;
		    document.frmMain.ufSacado.value = document.frmMain.uf.value;
 		    document.frmMain.numeroSacado.focus();
	    }
	    
	    
	    function controlaTpPagamento(){
	    	var formulario = document.frmMain;
	    	
	    	if (formulario.tipoPgto.value=="1"){
	    		
		    		formulario.valorMaxPgto.disabled=false;
		    		formulario.valorMinPgto.disabled=false;
		    		//formulario.valorMaxPgto.value="";
		    		//formulario.valorMinPgto.value="";	    			
	    		
	    	}else if (formulario.tipoPgto.value=="2"){
	    		formulario.valorMaxPgto.disabled=false;
	    		formulario.valorMinPgto.disabled=false;
	    	}else if (formulario.tipoPgto.value=="3"){
	    		formulario.valorMaxPgto.disabled=true;
	    		formulario.valorMinPgto.disabled=true;
	    		formulario.valorMaxPgto.value="";
	    		formulario.valorMinPgto.value="";
	    	}else if (formulario.tipoPgto.value=="4"){
	    		formulario.valorMaxPgto.disabled=true;
	    		formulario.valorMinPgto.disabled=false;
	    		formulario.valorMaxPgto.value="";
	    		
	    		
	    	}
	    }
	    
	    
	    function icParcialChange(){
	    	var formulario = document.frmMain;
	    		
	    		if (formulario.icParcial.value=="S"){
	    			formulario.qtdePossivel.disabled=false;
	    			formulario.tipoPgto.disabled=false;
	    			document.getElementById("blockCombo").style.display = "none";
	    			document.getElementById("exibeCombo").style.display = "block";
	    			controlaTpPagamento();
	    		}else{
	    			formulario.qtdePossivel.disabled=true;
	    			formulario.tipoPgto.disabled=true;
	    			formulario.qtdePossivel.value="";
		    		formulario.valorMaxPgto.disabled=true;
		    		formulario.valorMinPgto.disabled=true;
		    		formulario.valorMaxPgto.value="";
		    		formulario.valorMinPgto.value="";
		    		formulario.tipoPgto.value=="3"
		    		document.getElementById("blockCombo").style.display = "block";
	    			document.getElementById("exibeCombo").style.display = "none";
	    		}
	    		
	    		
	    	}
    </script>
  </s:FormStrategy>
</p:Document>
</html>