<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>


<%
	String descCriticas = "";
	if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
		descCriticas = (String) request.getAttribute(CedenteEstrategia.DESC_CRITICAS);
	} 
%>

<% 
	CedenteGeralBean filtroBean = (session.getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN)==null
	                              ? new CedenteGeralBean()
	                              : (CedenteGeralBean) session.getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN));

	CedenteCabecaBean cabecaBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
	                               ? new CedenteCabecaBean()
	                               : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

	CedentePrincipalBean principalBean = (session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN)==null
	                                     ? new CedentePrincipalBean()
	                                     : (CedentePrincipalBean) session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN));

	int guiaAberta = principalBean.getGuiaAberta() == null ? CedenteEstrategia.GUIA_NENHUMA : principalBean.getGuiaAberta().intValue();
	int guiaEmCadastramento = principalBean.getGuiaEmCadastramento() == 0 ? CedenteEstrategia.GUIA_GERAL : principalBean.getGuiaEmCadastramento();
	int ultimaGuiaCadastrada = principalBean.getUltimaGuiaCadastrada() == null ? CedenteEstrategia.GUIA_NENHUMA : principalBean.getUltimaGuiaCadastrada().intValue();
	int guiaInclusao = principalBean.getUltimaGuiaCadastrada() == null ? CedenteEstrategia.GUIA_NENHUMA + 1 : principalBean.getUltimaGuiaCadastrada().intValue() + 1;
	String situacaoGuia = principalBean.getSituacaoGuia() == null ? CedenteEstrategia.CONSULTA : principalBean.getSituacaoGuia();
	String tipoCobranca = principalBean.getTipoCobranca() == null ? ""+CedenteEstrategia.COBRANCA_CONVENCIONAL : ""+principalBean.getTipoCobranca();
	String cedenteCentralizador = principalBean.getCedenteCentralizador() == null ? "0" : ""+principalBean.getCedenteCentralizador();
	int cedenteEletronicoCadastrado = principalBean.getCedenteEletronicoCadastrado() == null ? 0 : principalBean.getCedenteEletronicoCadastrado().intValue();
%>

<%
	int numeroContas = 0;
	if (request.getParameter("selectNumeroContas") != null) {
		numeroContas = Integer.parseInt(request.getParameter("selectNumeroContas"));
	} else if (request.getAttribute("selectNumeroContas") != null) {
		numeroContas = Integer.parseInt((String) request.getAttribute("selectNumeroContas"));
	}

	String selectContasRateio = "N";
	if (request.getParameter("selectContasRateio") != null) {
		selectContasRateio = request.getParameter("selectContasRateio");
	} else 	if (request.getAttribute("selectContasRateio") != null) {
		selectContasRateio = (String) request.getAttribute("selectContasRateio");
	}

	String[] contaRateioUnidade = { "", "", ""};
	if (request.getAttribute("contaRateioUnidade") != null) {
		contaRateioUnidade = (String[]) request.getAttribute("contaRateioUnidade");
	}	else if (request.getParameterValues("contaRateioUnidade") != null) {
		contaRateioUnidade = request.getParameterValues("contaRateioUnidade");
	}
	
	String[] contaRateioOperacao = { "", "", ""};
	if (request.getParameterValues("contaRateioOperacao") != null) {
		contaRateioOperacao = request.getParameterValues("contaRateioOperacao");
	} else if (request.getAttribute("contaRateioOperacao") != null) {
		contaRateioOperacao = (String[]) request.getAttribute("contaRateioOperacao");
	}
	
	String[] contaRateioConta = { "", "", ""};
	if (request.getAttribute("contaRateioConta") != null) {
		contaRateioConta = (String[]) request.getAttribute("contaRateioConta");
	} else if (request.getParameterValues("contaRateioConta") != null) {
		contaRateioConta = request.getParameterValues("contaRateioConta");
	}
	
	String[] contaRateioDV = { "", "", ""};
	if (request.getAttribute("contaRateioDV") != null) {
		contaRateioDV = (String[]) request.getAttribute("contaRateioDV");
	} else if (request.getParameterValues("contaRateioDV") != null) {
		contaRateioDV = request.getParameterValues("contaRateioDV");
	}

	String[] valorRateio = { "", "", ""};
	if (request.getAttribute("valorRateio") != null) {
		valorRateio = (String[]) request.getAttribute("valorRateio");
	} else if (request.getParameterValues("valorRateio") != null) {
		valorRateio = request.getParameterValues("valorRateio");
	}

	String[] txtPercCredito = { "", "", ""};
	if (request.getAttribute("txtPercCredito") != null) {
		txtPercCredito = (String[]) request.getAttribute("txtPercCredito");
	} else if (request.getParameterValues("txtPercCredito") != null) {
		txtPercCredito = request.getParameterValues("txtPercCredito");
	}

	String[] txtPercDebito = { "", "", ""};
	if (request.getAttribute("txtPercDebito") != null) {
		txtPercDebito = (String[]) request.getAttribute("txtPercDebito");
	} else if (request.getParameterValues("txtPercDebito") != null) {
		txtPercDebito = request.getParameterValues("txtPercDebito");
	}

	String[] contaCpfCnpj = new String[0];
	if (request.getAttribute("contaCpfCnpj") != null) {
		contaCpfCnpj = (String[]) request.getAttribute("contaCpfCnpj");
	} else if (request.getParameterValues("contaCpfCnpj") != null) {
		contaCpfCnpj = request.getParameterValues("contaCpfCnpj");
	}

	String[] contaTitular = new String[0];
	if (request.getAttribute("contaTitular") != null) {
		contaTitular = (String[]) request.getAttribute("contaTitular");
	} else if (request.getParameterValues("contaTitular") != null) {
		contaTitular = request.getParameterValues("contaTitular");
	}


	CedenteGeralBean geralBean = (CedenteGeralBean) session.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN);
	int modalidadeTitulo = 0;
	if (geralBean.getModalidadeTitulo() != null) {
		modalidadeTitulo = geralBean.getModalidadeTitulo().intValue();
	}
	
	String clienteSINCE = "";
	//Manter como tipo String para entrada na taglib
	String isCadastrarContasRateioDisabled = "false";    
	if (geralBean.getClienteSINCE() != null) {
		clienteSINCE = geralBean.getClienteSINCE();
        if ("S".equals(clienteSINCE)) {
            isCadastrarContasRateioDisabled = "true";
        }
        else {
            isCadastrarContasRateioDisabled = "false";
        }
	}
	
%>

<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteIncluirGuiaControle" fluxo="normal">
   		<s:Menu/>
   		<s:Titulo name="Incluir Cedente"/>

			<input type="hidden" name="guiaAberta" value="<%= guiaAberta %>">
			<input type="hidden" name="ultimaGuiaCadastrada" value="<%= ultimaGuiaCadastrada %>">
			<input type="hidden" name="situacaoGuia" value="<%= situacaoGuia %>">
			<input type="hidden" name="tipoCobranca" value="<%= tipoCobranca %>">
			<input type="hidden" name="cedenteCentralizador" value="<%= cedenteCentralizador %>">			
			<input type="hidden" name="cedenteEletronicoCadastrado" value="<%= cedenteEletronicoCadastrado %>">
			
			<input type="hidden" name="codigoClienteCOCLI" value="<%= cabecaBean.getCodigoClienteCOCLI() %>">
			<input type="hidden" name="codigoUnidadePVVinc" value="<%= filtroBean.getCodigoUnidadePVVinc()  %>">
			<input type="hidden" name="tipoAcao">

			<input type="hidden" name="cpfCnpj" value="<%= cabecaBean.getCpfCnpj() %>">
			<input type="hidden" name="tipoPessoa" value="<%= cabecaBean.getTipoPessoa() %>">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

						<%-- *********** CABECALHO CEDENTE ****************** --%>
            <%@include file="cedente_cabecalho.jsp" %>
            
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Incluir Guias:
                <hr>
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#GeralParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_GERAL%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Gerali"></a>
                <a name="GeralParent">Geral</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_GERAL) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* GERAL ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#FloatParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_FLOAT%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Floati"></a>
                <a name="FloatParent">Float</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_FLOAT) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* FLOAT ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#ContasParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CONTAS%>);"><img src="<%=Paths.getImagePath()%>/outlineminus.gif" width="11" height="11" name="outlineplus" id="Contasi"></a>
                <a name="contasParent">Contas Déb. Créd. e Rateio</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_CONTAS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* CONTAS ************************************** -->

								<div class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr>
                      <td colspan="4" class="textoDestaqueTitulo">Guia: Contas Débito/Crédito</td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                    <tr>
                      <td class="textoTitulo" width="17%">Conta Crédito: </td>
				              <td width="26%" nowrap> 
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioUnidade" size="4" maxlength="4" value="<%= contaRateioUnidade[0] %>"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.contaRateioOperacao[0]);"/>
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioOperacao" size="3" maxlength="3" value="<%= contaRateioOperacao[0] %>"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.contaRateioConta[0]);"/>
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioConta" size="10" maxlength="8" value="<%= contaRateioConta[0] %>"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.contaRateioDV[0]);"/>
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioDV" size="1" maxlength="1" value="<%= contaRateioDV[0] %>" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.contaRateioUnidade[1]);"/>
				              </td>
                      <td class="textoTitulo" width="17%">Perc. Participação:</td>
                      <td width="26%">
                      	<input type="hidden" name="valorRateio">
                      	<input type="hidden" name="txtPercDebito">
                      	<p:InputPercentual CLASS="inputtext" name="txtPercCredito" size="9" maxlength="3" disabled="true" />
                      </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Conta Débito: </td>
				              <td width="26%" nowrap> 
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioUnidade" size="4" maxlength="4" value="<%= contaRateioUnidade[1] %>"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.contaRateioOperacao[1]);"/>
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioOperacao" size="3" maxlength="3" value="<%= contaRateioOperacao[1] %>"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.contaRateioConta[1]);"/>
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioConta" size="10" maxlength="8" value="<%= contaRateioConta[1] %>"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.contaRateioDV[1]);"/>
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioDV" size="1" maxlength="1" value="<%= contaRateioDV[1] %>"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.contaRateioUnidade[2]);"/>
				              </td>
                      <td class="textoTitulo" width="17%">Perc. Participação:</td>
                      <td width="26%">
                      	<input type="hidden" name="valorRateio">
                      	<input type="hidden" name="txtPercCredito">
                      	<p:InputPercentual CLASS="inputtext" name="txtPercDebito" size="9" maxlength="3" disabled="true" />
                      </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Conta Caução: </td>
				              <td width="26%" nowrap> 
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioUnidade" size="4" maxlength="4" value="<%= contaRateioUnidade[2] %>"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.contaRateioOperacao[2]);"/>
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioOperacao" size="3" maxlength="3" value="<%= contaRateioOperacao[2] %>"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.contaRateioConta[2]);"/>
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioConta" size="10" maxlength="8" value="<%= contaRateioConta[2] %>"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.contaRateioDV[2]);"/>
        				        <p:InputNumerico CLASS="inputtext" name="contaRateioDV" size="1" maxlength="1" value="<%= contaRateioDV[2] %>"
				                	onFocus="javascript: prevFocus(this);"/>
				              </td>
                      <td class="textoTitulo" width="26%">&nbsp;</td>
                      <td class="textoTitulo" width="26%">
                      	<input type="hidden" name="valorRateio">
                      	<input type="hidden" name="txtPercCredito">
                      	<input type="hidden" name="txtPercDebito">                      	
                      </td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Cadastrar Contas de Rateio: </td>
                      <td class="textoValor" width="26%">
                        <s:ComboSimNao name="selectContasRateio" selectedValue="<%= selectContasRateio %>" onChange="javascript:checaComboContasRateio();" disabled="<%= isCadastrarContasRateioDisabled %>" />
                      </td>
		                	<td nowrap class="textoTitulo" width="17%">
		                   	No. de Contas de Rateio: 
		                  </td>
		                  <td class="textoValor" width="26%">
			      				      <select name="selectNumeroContas">
<%
	for (int i = 1; i < 100; i++) {
		String selected = "";
		if (numeroContas == i) {
			selected = "selected";
		}
%>			      				      
														<option value="<%= i %>" <%= selected %>> <%= i %>
<% } %>
													</select>&nbsp;
		                  	  <s:Button name="mostrarContaRateio" value="Mostrar C. Rateio" action="showContasRateio();" />
			      				  </td>
										</tr>
                    
                    <tr>
                    	<td colspan="4">
		                    <div id="contasRateio" style="display:block">
	                    	<table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
		                    <tr>
		                      <td colspan="4">&nbsp;</td>
		                    </tr>
		
												<tr>
													<td colspan="4">
														<table class="box" width="100%" border="0" cellspacing="3" cellpadding="0" height=14 valign="middle" align="center">
					                    <tr class="headerLista">
					                      <td align="center" class="textoTitulo" width="3%">&nbsp;</td>
					                      <td align="left" class="textoTitulo" width="25%">Conta</td>
					                      <td align="left" class="textoTitulo" width="1%">&nbsp;</td>
					                      <td align="left" class="textoTitulo" width="12%">Perc. Crédito</td>
					                      <td align="left" class="textoTitulo" width="1%">&nbsp;</td>
					                      <td align="left" class="textoTitulo" width="20%">Valor Crédito</td>
					                      <td align="left" class="textoTitulo" width="1%">&nbsp;</td>
					                      <td align="left" class="textoTitulo" width="12%">Perc. Débito</td>
					                      <td align="left" class="textoTitulo" width="1%">&nbsp;</td>
					                      <td align="left" class="textoTitulo" width="15%">CPF/CNPJ</td>
					                      <td align="left" class="textoTitulo" width="20%">Titular</td>
					                      <td align="left" class="textoTitulo" width="3%">&nbsp;</td>
					                    </tr>
					                    
<%
	for (int j = 1; j <= numeroContas; j++) {
		String mudaPercentualCredito = "javascript:mudaPercentualCredito(" + (j+2) + ");";
		String mudaValorCredito = "javascript:mudaValorCredito(" + (j+2) + ");";
%>
					                    <tr <%= ( ((j+1)%2) == 0 ) ? "class='line0'" : "class='line2'" %>>
					                      <td align="center" class="textoTitulo" width="5%"><%= j %>.</td>
									              <td align="left" width="25%" nowrap>
					        				        <p:InputNumerico CLASS="inputtext" name="contaRateioUnidade" size="4" maxlength="4"
																		value="<%=((j+2) < contaRateioUnidade.length) ? contaRateioUnidade[j+2] : \"\" %>"
									                	onFocus="javascript: prevFocus(this);"
																		onKeyUp="<%= \"javascript:nextFocus(event.keyCode, this, document.frmMain.contaRateioOperacao[\" + (j+2) + \"]);\" %>" />

					        				        <p:InputNumerico CLASS="inputtext" name="contaRateioOperacao" size="3" maxlength="3"
					        				         value="<%=((j+2) < contaRateioOperacao.length) ? contaRateioOperacao[j+2] : \"\" %>"
									                	onFocus="javascript: prevFocus(this);"
																		onKeyUp="<%= \"javascript:nextFocus(event.keyCode, this, document.frmMain.contaRateioConta[\" + (j+2) + \"]);\" %>" />

					        				        <p:InputNumerico CLASS="inputtext" name="contaRateioConta" size="10" maxlength="8"
					        				         value="<%=((j+2) < contaRateioConta.length) ? contaRateioConta[j+2] : \"\" %>"
									                	onFocus="javascript: prevFocus(this);"
																		onKeyUp="<%= \"javascript:nextFocus(event.keyCode, this, document.frmMain.contaRateioDV[\" + (j+2) + \"]);\" %>" />

					        				        <p:InputNumerico CLASS="inputtext" name="contaRateioDV" size="1" maxlength="1"
					        				         value="<%=((j+2) < contaRateioDV.length) ? contaRateioDV[j+2] : \"\" %>"
									                	onFocus="javascript: prevFocus(this);" />

									              </td>
									              <td align="left" class="textoValor" width="1%">&nbsp;</td>
									              <td align="left" width="12%" nowrap>
						      				        <p:InputPercentual CLASS="inputtext" name="txtPercCredito" size="9" maxlength="5"
						      				        onBlur="<%= mudaPercentualCredito %>"
						      				        onFocus="<%= mudaPercentualCredito %>"
					        				        value="<%=((j+2) < txtPercCredito.length) ? txtPercCredito[j+2] : \"\" %>" />
					        				      </td>
						      				      <td align="left" class="textoValor" width="1%">&nbsp;</td>
									              <td align="left" width="20%" nowrap>
						      				        <p:InputCurrency CLASS="inputtext" name="valorRateio" size="25" maxlength="15"
						      				        onBlur="<%= mudaValorCredito %>"
						      				        onFocus="<%= mudaValorCredito %>"
					        				        value="<%=((j+2) < valorRateio.length) ? valorRateio[j+2] : \"\" %>" />
						      				      </td>
						      				      <td align="left" class="textoValor" width="1%">&nbsp;</td>
									              <td align="left" width="12%" nowrap> 
						      				        <p:InputPercentual CLASS="inputtext" name="txtPercDebito" size="9" maxlength="5"
					        				        value="<%=((j+2) < txtPercDebito.length) ? txtPercDebito[j+2] : \"\" %>"
					        				        onBlur="limpaPercentualRateioDebito(this);" />
						      				      </td>
									              <td align="left" class="textoValor" width="1%">
									              	&nbsp;
									              </td>
									              <td class="textoValor" align="left" width="15%" nowrap>
									              	<div id="<%= "divCpfRateio" + (j+2) %>"></div>
									              	<input type="hidden" name="contaCpfCnpj"
                                   value="<%=((j-1) < contaCpfCnpj.length) ? Util.toStr(contaCpfCnpj[j-1]) : new String() %>">
									              </td>
									              <td class="textoValor" align="left" width="20%" nowrap>
									              	<div id="<%= "divTitularRateio" + (j+2) %>"></div>
									              	<input type="hidden" name="contaTitular"
                                   value="<%=((j-1) < contaTitular.length) ? contaTitular[j-1] : new String() %>">
									              </td>
						      				      <td align="left" class="textoValor" width="3%">&nbsp;</td>
					                    </tr>
<%
	}
%>

						      				    <tr> 
        					              <td colspan="12">&nbsp;</td>
				          	          </tr>
						      				    <tr>  	
						      				      <td align="right" colspan="12">
						      				      	<p align="center">
																		<s:Button name="buttonAtualizarGuia" value="Recalcular" action="javascript:atualizarGuia();" />
																	</p>
																</td>
					                    </tr>
															<tr>
					                      <td colspan="12">&nbsp;</td>
					                    </tr>
					                  </table>
					                </td>
					              </tr>
										   </table>
										 	</div>
										 </td>
										</tr>									
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td align="right" colspan="4">
                        <p align="center"> 
                          <s:Button name="Confirmar" action="javascript:formSubmit_Contas();" />
                          <s:Button name="Cancelar" action="javascript:fecharGuias()" />
                        </p>
                      </td>
                    </tr>

                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                  </table>
								</div>

              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#CedenteParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CEDENTE_ELETRONICO%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Cedentei"></a>
                <a name="CedenteParent">Cedente Eletrônico</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_CEDENTE_ELETRONICO) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* CEDENTE ELETRONICO ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#BloquetosParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_BLOQUETOS%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Bloquetosi"></a>
                <a name="BloquetosParent">Boletos</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_BLOQUETOS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* BLOQUETOS ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#MensagemParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_MENSAGENS%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Mensagemi"></a>
                <a name="MensagemParent">Mensagens para Boletos</a>                
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_MENSAGENS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* MENSAGEM ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#TarifasParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_TARIFAS%>);">
                	 <img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Tarifasi"></a>
                <a name="TarifasParent">Tarifas</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_TARIFAS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* TARIFAS ************************************** -->
              </td>
            </tr>
            <tr>
              <td class="textoTitulo">
                <a href="#ParametroParent" onclick="javascript:trocaGuia(10);">
                	 <img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Tarifasi"></a>
                <a name="TarifasParent">Parâmetros</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_PARAMETROS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* Parametros ************************************** -->
              </td>
            </tr>	
            <tr>
              <td class="textoTitulo">
                <a href="#PermissaoParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_PERMISSAO%>);">
                	 <img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Permissaoi"></a>
                <a name="PermissaoParent">Permissão</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_PERMISSAO) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
					<!-- ************************************************* Permissão ************************************** -->
              </td>			     
            <tr>
              <td class="textoTitulo">
                <a href="#ConclusaoParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CONCLUSAO%>);">
                	 <img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Conclusaoi"></a>
                <a name="ConclusaoParent">Conclusão</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_CONCLUSAO) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* CONCLUSAO ************************************** -->
              </td>
            </tr>
            <tr> 
            	<td colspan="4">&nbsp;</td>
            </tr>
            <tr>
             <td align="right" colspan="4">
	               <p align="center"> 
                  <s:Button name="Voltar_Principal" value="Voltar" action="javascript:formSubmit_Voltar();"/>
                  <s:Button name="Cancelar_Principal" value="Cancelar Cadastro" action="javascript:formSubmit_Cancelar();"/>
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
	    function inicia(){
	    	mudaComboContasRateio();
	    
	    	if (<%= numeroContas %> == 0) {
				  eval("contasRateio").style.display="none";
	    	}
	    	
	    	calculaPercentualCredito();
	    	calculaPercentualDebito();

				for (var i = 3; i < document.frmMain.contaRateioUnidade.length; i++) {
					mudaPercentualCredito(i);
					mudaValorCredito(i);
					carregaCpfTitular(i);
				}
				
<%
	// caso retornou da estrategia com criticas
	if (!descCriticas.equals("")) {
%>
				alert("<%= descCriticas %>");
<%
	}
%>
	    }

			function formSubmit() {
				formSubmit_Contas();
			}

			function formSubmit_Cancelar() {
        var confirma = confirm(conf('105'));
      
        if (confirma) {
          document.frmMain.estrategia.value="cedente.CedenteIncluirCancelar";
          document.frmMain.submit();
        }
			}

	    function formSubmit_Voltar() {
        var confirma = confirm(conf('104'));
      
        if (confirma) {
          document.frmMain.estrategia.value="cedente.CedenteIncluirIniciar";
          document.frmMain.submit();
        }
	    }
	    
	    function trocaGuia( guia ) {
	    	var guiaInclusao = <%= guiaInclusao %>;
	    	var guiaEmCadastramento = <%= guiaEmCadastramento %>;
	    
	    	if (guia == <%= guiaAberta %>) {
	    		fecharGuias();
	    		return;
	    	}

	    	if (guia == <%= CedenteEstrategia.GUIA_CEDENTE_ELETRONICO %>
	    				&& <%= principalBean.naoPodeCedenteEletronico() %>) {
	    			return;
	    	}
	    
        if (guia == guiaInclusao && guiaInclusao == guiaEmCadastramento) {
		    	if (!confirm(conf("106"))) {
		    		return;
		    	}
        
	    		document.frmMain.situacaoGuia.value = "<%= CedenteEstrategia.INCLUSAO %>";
		    	document.frmMain.guiaAberta.value = guia;
		    	document.frmMain.submit();
		    } else if (guia < guiaInclusao) {
		    	if (!confirm(conf("106"))) {
		    		return;
		    	}
		    
	    		document.frmMain.situacaoGuia.value = "<%= CedenteEstrategia.ALTERACAO_EM_INCLUSAO %>";
		    	document.frmMain.guiaAberta.value = guia;
		    	document.frmMain.submit();
		    }
	    }
	    
	    function fecharGuias() {
		    	document.frmMain.guiaAberta.value = <%= CedenteEstrategia.GUIA_NENHUMA %>;
		    	document.frmMain.submit();
	    }

	   	function showContasRateio() {
	   		if (document.frmMain.selectNumeroContas.value != <%= numeroContas %>) {
					document.frmMain.action="<%=Paths.getRootForDynamicContent()%>/cedente/cedente_incluir_guiacontas.jsp";
		   		// habilitaCampos();
			   	habilitaContasRateioValidas();
					document.frmMain.submit();
				}
	   	}

			function formSubmit_Contas() {
            
           var linhaErro = verificaPercDebitoTemPercCreditoOuValorRateioVazio();
           if(linhaErro > 0){
                msg("071",'',linhaErro,'','','');
                return false;
            }
            
    		if (validaSubmit_Contas()) {
					//EAM - Validação para não aceitar percentual superior a 100% nas contas de rateio
					if (document.frmMain.selectContasRateio.value == 'S'){
	 	    		if(!calculaPercentualCredito()){
	 	    			return false;
	 	    		}
	    	    if (!calculaPercentualDebito()){
	    	    	return false;
	    	    }
	    	  }
		  		var confirma = confirm(conf('107'));
		  		
  	    	if (confirma) {
			    	document.frmMain.estrategia.value="cedente.CedenteIncluirGuiaContasFinalizar";
			    	document.frmMain.tipoAcao.value=document.frmMain.situacaoGuia.value;

			    	habilitaCampos();
			    	document.frmMain.submit();
			    }
		    }
			}
			
			function validaSubmit_Contas() {
	    	var camposObrigatorios = new Array(8);
			camposObrigatorios[0] = new Array( "contaRateioUnidade[0]", "Conta Crédito" );
	    	camposObrigatorios[1] = new Array( "contaRateioOperacao[0]", "Conta Crédito" );
	    	camposObrigatorios[2] = new Array( "contaRateioConta[0]", "Conta Crédito" );
	    	camposObrigatorios[3] = new Array( "contaRateioDV[0]", "Conta Crédito" );
			camposObrigatorios[4] = new Array( "contaRateioUnidade[1]", "Conta Débito" );
	    	camposObrigatorios[5] = new Array( "contaRateioOperacao[1]", "Conta Débito" );
	    	camposObrigatorios[6] = new Array( "contaRateioConta[1]", "Conta Débito" );	    	
	    	camposObrigatorios[7] = new Array( "contaRateioDV[1]", "Conta Débito" );
	    	
	    	if (!validaArrayCamposObrigatorios(camposObrigatorios)) {
	    		return false;
	    	}
	    	
	    	if (<%= modalidadeTitulo %> == 3) { // 3 - Cobranca Caucionada
					if (!validaCampoObrigatorio(document.frmMain.contaRateioUnidade[2], 'Conta Caução')) {
						return false;
					}
					if (!validaCampoObrigatorio(document.frmMain.contaRateioOperacao[2], 'Conta Caução')) {
						return false;
					}
					if (!validaCampoObrigatorio(document.frmMain.contaRateioConta[2], 'Conta Caução')) {
						return false;
					}
					if (!validaCampoObrigatorio(document.frmMain.contaRateioDV[2], 'Conta Caução')) {
						return false;
					}
	    	}
	    	
	    	if (!validaContasRateio()) {
	    		return false;
	    	}
	    	return true;
			}

			function validaContasRateio() {
	    	// Campos de contas
	    	for (var i = 3; i < document.frmMain.contaRateioUnidade.length; i++) {
	    		var unidade = document.frmMain.contaRateioUnidade[i].value;
	    		var operacao = document.frmMain.contaRateioOperacao[i].value;
	    		var rateioConta = document.frmMain.contaRateioConta[i].value;
	    		var dv = document.frmMain.contaRateioDV[i].value;
	    		
	    		var conta = unidade + operacao + rateioConta + dv;
	    		
	    		if (trim(conta) != '') { // se um deles foi preenchido
						if (!validaCampoObrigatorio(document.frmMain.contaRateioUnidade[i], 'Conta Rateio ' + (i-2))) {
							return false;
						}
						if (!validaCampoObrigatorio(document.frmMain.contaRateioOperacao[i], 'Conta Rateio ' + (i-2))) {
							return false;
						}
						if (!validaCampoObrigatorio(document.frmMain.contaRateioConta[i], 'Conta Rateio ' + (i-2))) {
							return false;
						}
						if (!validaCampoObrigatorio(document.frmMain.contaRateioDV[i], 'Conta Rateio ' + (i-2))) {
							return false;
						}
						if (isContaJaDigitada(i)) {
							document.frmMain.contaRateioUnidade[i].focus();
							return false;
						}
	    		}
	    		
	    		var credito = document.frmMain.txtPercCredito[i].value + document.frmMain.valorRateio[i].value;
	    		if (trim(conta) != '' &&
	    		    (trim(credito) == '' || trim(credito) == '0,00 %' || trim(credito) == 'R$ 0,00' || trim(credito) == '0,00 %R$ 0,00') &&
	    		    (trim(document.frmMain.txtPercDebito[i].value) == '' || trim(document.frmMain.txtPercDebito[i].value) == '0,00 %')) {
						if (!validaCampoObrigatorio(document.frmMain.txtPercCredito[i], 'Percentual ou Valor')) {
							return false;
						}
					}
	    	}
				<%//EAM 27/10/05 - INI%>
	    	if(!calculaPercentualCredito() || !calculaPercentualDebito())
	    		return false;
	    	<%//EAM 27/10/05 - FIM%>

	    	return true;
			}
			
			// verifica se a conta do indiceConta ja foi digitada
			// nao pode haver duas contas iguais
			function isContaJaDigitada( indiceConta ) {
    		var unidade = document.frmMain.contaRateioUnidade[indiceConta].value;
    		var operacao = document.frmMain.contaRateioOperacao[indiceConta].value;
    		var rateioConta = document.frmMain.contaRateioConta[indiceConta].value;
    		var dv = document.frmMain.contaRateioDV[indiceConta].value;
    		
    		var conta = ""+new Number(unidade) + new Number(operacao) + new Number(rateioConta) + new Number(dv);

				for (var j = 0; j < indiceConta; j++) {
	    		var outraUnidade = document.frmMain.contaRateioUnidade[j].value;
	    		var outraOperacao = document.frmMain.contaRateioOperacao[j].value;
	    		var outraRateioConta = document.frmMain.contaRateioConta[j].value;
	    		var outraDv = document.frmMain.contaRateioDV[j].value;
	    		
	    		if (!isContaPreenchida(outraUnidade, outraOperacao, outraRateioConta, outraDv)) {
	    			continue;
	    		}

	    		var outraConta = ""+new Number(outraUnidade) + new Number(outraOperacao) + new Number(outraRateioConta) + new Number(outraDv);
	    		
	    		if (conta == outraConta) {
						if (j < 3) { // j < 3 - conta principal
							msg("039");
						} else {
							msg("037");
						}
	    			return true;
	    		}
				}

				return false;
			}
			
			function isContaPreenchida(unidade, operacao, rateioConta, dv) {
				if (trim(unidade) != '' && trim(operacao) != '' && trim(rateioConta) != '' && trim(dv) != '') {
					return true;
				}
				return false;
			}
			
			function mudaPercentualCredito(indice) {
                var campo = document.frmMain.txtPercCredito[indice];
                limpaPercentualRateioCredito(campo);

            	var percentualVazio = true;
                for (var i = 3; i < document.frmMain.txtPercCredito.length; i++) {
	                var campo1 = document.frmMain.txtPercCredito[i];
					percentualVazio = percentualVazio && (campo1.value == '')
                }
                for (var i = 3; i < document.frmMain.valorRateio.length; i++) {
	                var campo2 = document.frmMain.valorRateio[i];
                    campo2.disabled = (window.event.type != 'focus') && (!percentualVazio);
                }
			}

			function mudaValorCredito(indice) {
                var campo = document.frmMain.valorRateio[indice];
                limpaValorRateioCredito(campo);

            	var valorVazio = true;
                for (var i = 3; i < document.frmMain.valorRateio.length; i++) {
	                var campo1 = document.frmMain.valorRateio[i];
					valorVazio = valorVazio && (campo1.value == '')
                }
                for (var i = 3; i < document.frmMain.txtPercCredito.length; i++) {
	                var campo2 = document.frmMain.txtPercCredito[i];
                    campo2.disabled = (window.event.type != 'focus') && (!valorVazio);
                }
			}

			function mudaComboContasRateio() {
				if (document.frmMain.selectContasRateio.value == "S") {
					habilitaContasRateio();
				
					if (<%= numeroContas %> > 0) {
						eval("contasRateio").style.display="block";
					}
				
					document.frmMain.mostrarContaRateio.disabled = false;
					document.frmMain.selectNumeroContas.disabled = false;
				} else {
					eval("contasRateio").style.display="none";
					
					document.frmMain.mostrarContaRateio.disabled = true;
					document.frmMain.selectNumeroContas.disabled = true;
					
					// Limpa campos
					limpaContasRateio();
					
					// Percentuais de Credito e Debito voltam a 100%
					document.frmMain.txtPercCredito[0].value = 10000;
					formataPercentual(document.frmMain.txtPercCredito[0]);

					document.frmMain.txtPercDebito[1].value = 10000;
					formataPercentual(document.frmMain.txtPercDebito[1]);
				}
			}
			
			// pede confirmacao para descartar contas
			function checaComboContasRateio() {
				if (document.frmMain.selectContasRateio.value == "N" && "<%= selectContasRateio %>" == "S") {
					var confirma = confirm(conf("151"));
					
					if (!confirma) {
						document.frmMain.selectContasRateio.value = "S";
						return;
					}
				}
				
				mudaComboContasRateio();
			}
			
			function atualizarGuia() {
   			if (validaContasRateio()) {
			    document.frmMain.estrategia.value="cedente.CedenteIncluirGuiaContasFinalizar";
					document.frmMain.tipoAcao.value = "G"; // G - Atualizar Guia
			   	habilitaCampos();
					document.frmMain.submit();
				}
			}
			
			function calculaPercentualCredito() {
				// se contas rateio = N, nao precisa calcular
				if (document.frmMain.selectContasRateio.value == "N") {
					return true;
				}
			
				var percentualCredito = 10000; // 100,00 %
				var somaPercentual = 0;
				
				for (var i = 3; i < document.frmMain.contaRateioUnidade.length; i++) {
					var perc = document.frmMain.txtPercCredito[i].value;

					// desformata valor
					perc = replaceAll(perc, ',', '');
					perc = replaceAll(perc, '%', '');
					perc = trim(perc);
					
					if (perc != '' && perc != '0') {
						somaPercentual -= perc;
					}
					
					// se preencheu algum valor, o campo fica em branco
					if (trim(document.frmMain.valorRateio[i].value) != '' &&
							trim(document.frmMain.valorRateio[i].value) != 'R$ 0,00') {
						document.frmMain.txtPercCredito[0].value = '';
						<%//EAM 27/10/05 - INI%>
						var temValor = true;
						//return true;
						<%//EAM 27/10/05 - FIM%>
					}
				}
				somaPercentual = somaPercentual * -1;

				if (somaPercentual >= 10000) {//EAM - Soma não pode ser maior ou = 100
					//alert('Soma dos Percentuais Crédito ultrapassa 100%');
					msg('063','','Crédito','100%');
					document.frmMain.txtPercCredito[0].value = '';
					return false;
				}
				<%//EAM 27/10/05 - INI%>
				if(!temValor){
					document.frmMain.txtPercCredito[0].value = percentualCredito - somaPercentual;
					formataPercentual(document.frmMain.txtPercCredito[0]);
				}
				<%//EAM 27/10/05 - FIM%>
				return true;
			}
			
			function calculaPercentualDebito() {
				// se contas rateio = N, nao precisa calcular
				if (document.frmMain.selectContasRateio.value == "N") {
					return true;
				}

				var percentualDebito = 10000; // 100,00 %
				var somaPercentual = 0;
				
				for (var i = 3; i < document.frmMain.contaRateioUnidade.length; i++) {
					var perc = document.frmMain.txtPercDebito[i].value;

					// desformata valor
					perc = replaceAll(perc, ',', '');
					perc = replaceAll(perc, '%', '');
					perc = trim(perc);
					
					if (perc != '' && perc != '0') {
						somaPercentual -= perc;
					}
				}
				somaPercentual = somaPercentual * -1;
				
				//alert(somaPercentual);
				
				if (somaPercentual >= 10000) {//EAM - Soma não pode ser maior ou = 100
					//alert('Soma dos Percentuais Débito ultrapassa 100%');
					msg('063','','Débito','100%');
					document.frmMain.txtPercDebito[1].value = '';
					return false;
				}
				
				document.frmMain.txtPercDebito[1].value = percentualDebito - somaPercentual;
				formataPercentual(document.frmMain.txtPercDebito[1]);
				return true;
			}

			function limpaContasRateio() {
				for (var i = 3; i < document.frmMain.contaRateioUnidade.length; i++) {
					document.frmMain.contaRateioUnidade[i].value = '';
					document.frmMain.contaRateioOperacao[i].value = '';
    			document.frmMain.contaRateioConta[i].value = '';
    			document.frmMain.contaRateioDV[i].value = '';
    			document.frmMain.txtPercCredito[i].value = '';
    			document.frmMain.txtPercDebito[i].value = '';
    			document.frmMain.valorRateio[i].value = '';
    			limpaCpfTitular(i);
    		}
			}

			function desabilitaContasRateio() {
				for (var i = 3; i < document.frmMain.contaRateioUnidade.length; i++) {
					document.frmMain.contaRateioUnidade[i].disabled = true;
					document.frmMain.contaRateioOperacao[i].disabled = true;
    			document.frmMain.contaRateioConta[i].disabled = true;
    			document.frmMain.contaRateioDV[i].disabled = true;
    			document.frmMain.txtPercCredito[i].disabled = true;
    			document.frmMain.txtPercDebito[i].disabled = true;
    			document.frmMain.valorRateio[i].disabled = true;
				}
			}
			
			// indiceContaRateio - (contas rateio comeca do 3)
			function limpaCpfTitular( indiceContaRateio ) {
				var divCpf = document.getElementById("divCpfRateio" + indiceContaRateio);
				divCpf.innerHTML = "";
				if (document.frmMain.contaCpfCnpj[indiceContaRateio - 3] != null) {
					document.frmMain.contaCpfCnpj[indiceContaRateio - 3].value = "";
					document.frmMain.contaCpfCnpj[indiceContaRateio - 3].disabled = true;
				} else {
					document.frmMain.contaCpfCnpj.value = "";
					document.frmMain.contaCpfCnpj.disabled = true;
				}
				
				var divTitular = document.getElementById("divTitularRateio" + indiceContaRateio);
				divTitular.innerHTML = "";
				if (document.frmMain.contaTitular[indiceContaRateio - 3] != null) {
					document.frmMain.contaTitular[indiceContaRateio - 3].value = "";
					document.frmMain.contaTitular[indiceContaRateio - 3].disabled = true;
				} else {
					document.frmMain.contaTitular.value = "";
					document.frmMain.contaTitular.disabled = true;
				}
			}

			function carregaCpfTitular( indiceContaRateio ) {
				var divCpf = document.getElementById("divCpfRateio" + indiceContaRateio);
				if (document.frmMain.contaCpfCnpj[indiceContaRateio - 3] != null) {
					divCpf.innerHTML = document.frmMain.contaCpfCnpj[indiceContaRateio - 3].value;
				} else {
					divCpf.innerHTML = document.frmMain.contaCpfCnpj.value;
				}

				var divTitular = document.getElementById("divTitularRateio" + indiceContaRateio);
				if (document.frmMain.contaTitular[indiceContaRateio - 3] != null) {
					divTitular.innerHTML = document.frmMain.contaTitular[indiceContaRateio - 3].value;
				} else {
					divTitular.innerHTML = document.frmMain.contaTitular.value;
				}
			}

			function habilitaContasRateio() {
				for (var i = 3; i < document.frmMain.contaRateioUnidade.length; i++) {
					document.frmMain.contaRateioUnidade[i].disabled = false;
					document.frmMain.contaRateioOperacao[i].disabled = false;
    			document.frmMain.contaRateioConta[i].disabled = false;
    			document.frmMain.contaRateioDV[i].disabled = false;
    			document.frmMain.txtPercCredito[i].disabled = false;
    			document.frmMain.txtPercDebito[i].disabled = false;
    			document.frmMain.valorRateio[i].disabled = false;
				}
			}

			function habilitaContasRateioValidas() {
				for (var i = 3; i < document.frmMain.contaRateioUnidade.length; i++) {
					if (trim(document.frmMain.contaRateioUnidade[i].value) == '') {
						document.frmMain.contaRateioUnidade[i].disabled = true;
						document.frmMain.contaRateioOperacao[i].disabled = true;
	    			document.frmMain.contaRateioConta[i].disabled = true;
	    			document.frmMain.contaRateioDV[i].disabled = true;
	    			document.frmMain.txtPercCredito[i].disabled = true;
	    			document.frmMain.txtPercDebito[i].disabled = true;
	    			document.frmMain.valorRateio[i].disabled = true;
	    			limpaCpfTitular(i);
	    		} else {
						document.frmMain.contaRateioUnidade[i].disabled = false;
						document.frmMain.contaRateioOperacao[i].disabled = false;
	    			document.frmMain.contaRateioConta[i].disabled = false;
	    			document.frmMain.contaRateioDV[i].disabled = false;
	    			document.frmMain.txtPercCredito[i].disabled = false;
	    			document.frmMain.txtPercDebito[i].disabled = false;
	    			document.frmMain.valorRateio[i].disabled = false;
	    		}
				}
				
				// eh sempre valido
				document.frmMain.txtPercCredito[0].disabled = false;
				document.frmMain.txtPercDebito[1].disabled = false;
			}
			
			function habilitaCampos() {
				// se contas rateio habilitado, habilita todos
				// senao soh os campos percentuais e desabilita contas rateio
				if (document.frmMain.selectContasRateio.value == "S") {
					for (var i = 0; i < document.frmMain.elements.length; i++) {
						document.frmMain.elements[i].disabled = false;
					}
				} else {
					document.frmMain.txtPercCredito[0].disabled = false;
					document.frmMain.txtPercDebito[1].disabled = false;
					desabilitaContasRateio();
				}
			}
			
			function limpaPercentualRateioDebito(field) {
				if (desformataPercentual(field.value) == 0) {
					field.value = '';
				}
			}
			function limpaPercentualRateioCredito(field) {
				if (desformataPercentual(field.value) == 0) {
					field.value = '';
				}
			}
			function limpaValorRateioCredito(field) {
				if (desformataMoney(field.value) == 0) {
					field.value = '';
				}
			}
            
            <%-- Esta função verifica a seguinte regra: Se uma célula de Perc. Débito
                estiver preenchida, então pelo menos uma de Valor Crédito ou de 
                Perc. Crédito também deve estar preenchida.
                Esta função retorna 0 caso não haja erro, ou um número maior que 0 
                indicando a linha que ocorreu o erro.--%>
            
            function verificaPercDebitoTemPercCreditoOuValorRateioVazio(){
                var selectContasRateio = document.getElementsByName('selectContasRateio')[0];
                if(selectContasRateio.getAttribute('value') == 'S'){
                    var txtPercDebitoColuna  = document.getElementsByName('txtPercDebito');//Perc. Débito
                    var valorRateioColuna    = document.getElementsByName('valorRateio');//Valor Crédito
                    var txtPercCreditoColuna = document.getElementsByName('txtPercCredito');//Perc. Crédito
                    for (var i = 3; i < txtPercDebitoColuna.length; i++) {
                        if(txtPercDebitoColuna[i].value != ''){
                            if(valorRateioColuna[i].value == '' && txtPercCreditoColuna[i].value == ''){
                                return (i-2);
                            }
                        }
                    }                    
                }
                return 0;
            }
    </script>

   	</s:FormStrategy>
  </p:Document>
</html>
                  