<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteBloquetosBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
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

	InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean)session.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);

	CedenteGeralBean filtroBean = (session.getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN)==null
	                              ? new CedenteGeralBean()
	                              : (CedenteGeralBean) session.getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN));

	CedenteCabecaBean cabecaBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
	                               ? new CedenteCabecaBean()
	                               : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

	CedentePrincipalBean principalBean = (session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN)==null
	                                     ? new CedentePrincipalBean()
	                                     : (CedentePrincipalBean) session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN));

	String situacaoGuia = principalBean.getSituacaoGuia() == null ? CedenteEstrategia.CONSULTA : principalBean.getSituacaoGuia();
	int guiaAberta = principalBean.getGuiaAberta() == null ? CedenteEstrategia.GUIA_NENHUMA : principalBean.getGuiaAberta().intValue();
	int guiaEmCadastramento = principalBean.getGuiaEmCadastramento() == 0 ? CedenteEstrategia.GUIA_GERAL : principalBean.getGuiaEmCadastramento();
	int guiaInclusao = principalBean.getUltimaGuiaCadastrada() == null ? CedenteEstrategia.GUIA_NENHUMA + 1 : principalBean.getUltimaGuiaCadastrada().intValue() + 1;
	int ultimaGuiaCadastrada = principalBean.getUltimaGuiaCadastrada() == null ? CedenteEstrategia.GUIA_NENHUMA : principalBean.getUltimaGuiaCadastrada().intValue();
	String tipoCobranca = principalBean.getTipoCobranca() == null ? ""+CedenteEstrategia.COBRANCA_CONVENCIONAL : ""+principalBean.getTipoCobranca();
	String cedenteCentralizador = principalBean.getCedenteCentralizador() == null ? "0" : ""+principalBean.getCedenteCentralizador();
	int cedenteEletronicoCadastrado = principalBean.getCedenteEletronicoCadastrado() == null ? 0 : principalBean.getCedenteEletronicoCadastrado().intValue();
%>

<%
	CedenteBloquetosBean bloqBean = (request.getAttribute(CedenteEstrategia.CEDENTE_BLOQUETOS_BEAN)==null
	                                ? new CedenteBloquetosBean()
	                                : (CedenteBloquetosBean)	request.getAttribute(CedenteEstrategia.CEDENTE_BLOQUETOS_BEAN));
	
	// Variaveis usadas para exibicao no caso de alteracao
	String emissaoBloquetos      = Util.toStr(bloqBean.getEmissaoBloquetos());	
	if (emissaoBloquetos.equalsIgnoreCase("99")){
		emissaoBloquetos = "2";
	}
	String envioBloqueto         = Util.toStr(bloqBean.getEnvioBloqueto(), "-1"); // Padrao -1 - Brancos
	String avisoSacado           = Util.toStr(bloqBean.getAvisoSacado(), "N"); // Padrao Nao
	String impBloqDDA			 = Util.toStr(bloqBean.getImpBloqDDA(), "N"); // Padrao Nao
	String envioSMS			     = Util.toStr(bloqBean.getEnvioSMS(), "N"); // Padrao Nao
	String envioAvisoSacado      = Util.toStr(bloqBean.getEnvioAvisoSacado(), "99"); // Padrao 99 - Brancos
	String formasAvisoVencido    = Util.toStr(bloqBean.getFormasAvisoVencido(), "N"); // Padrao Nao
	String formasAvisoProtesto   = Util.toStr(bloqBean.getFormasAvisoProtesto(), "N"); // Padrao Nao
	String qtdeDiasProtesto      = Util.toStr(bloqBean.getQtdeDiasProtesto());
	String avisoDisponibPrimeira = Util.toStr(bloqBean.getAvisoDisponibPrimeira(), "0"); // Padrao 0
	String avisoDisponibSegunda  = Util.toStr(bloqBean.getAvisoDisponibSegunda());
	String avisoVencidoSegunda   = Util.toStr(bloqBean.getAvisoVencidoSegunda());
	String avisoDisponibTerceira = Util.toStr(bloqBean.getAvisoDisponibTerceira());
	String avisoVencidoTerceira  = Util.toStr(bloqBean.getAvisoVencidoTerceira());
	
	String prazoSMS1			 = Util.toStr(bloqBean.getPrazoSMS1());
	String prazoSMS2			 = Util.toStr(bloqBean.getPrazoSMS2());
	String prazoSMS3			 = Util.toStr(bloqBean.getPrazoSMS3());

	// Se for 0 mostra
	String valorMinimoAviso      = bloqBean.getValorMinimoAviso()==null ? "" : ""+bloqBean.getValorMinimoAviso();
	String avisoVencidoPrimeira  = bloqBean.getAvisoVencidoPrimeira()==null ? "" : ""+bloqBean.getAvisoVencidoPrimeira();

	String checkFormasAvisoVencido = "";
	if (formasAvisoVencido.equals("S")) {
		checkFormasAvisoVencido = "checked";
	}
	
	String checkFormasAvisoProtesto = "";
	if (formasAvisoProtesto.equals("S")) {
		checkFormasAvisoProtesto = "checked";
	}
	
	System.out.println(bloqBean);
	
	String qtdeBolMes = Util.toStr(bloqBean.getQtdeBolMes());
	String valorMinULCCA =  bloqBean.getValorMinULCCA()==null ? "" : ""+bloqBean.getValorMinULCCA();
	String valorMaxULCCA = bloqBean.getValorMaxULCCA()==null ? "" : ""+bloqBean.getValorMaxULCCA();
	


	
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
  		<input type="hidden" name="envioBloqueto">
			

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
                <a href="#GeralParent" onclick="javascript:trocaGuia(1);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Gerali"></a>
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
                <a href="#FloatParent" onclick="javascript:trocaGuia(2);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Floati"></a>
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
                <a href="#ContasParent" onclick="javascript:trocaGuia(3);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Contasi"></a>
                <a name="contasParent">Contas Déb. Créd. e Rateio</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_CONTAS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* CONTAS ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#CedenteParent" onclick="javascript:trocaGuia(4);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Cedentei"></a>
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
                <a href="#BloquetosParent" onclick="javascript:trocaGuia(5);"><img src="<%=Paths.getImagePath()%>/outlineminus.gif" width="11" height="11" name="outlineminus" id="Bloquetosi"></a>
                <a name="BloquetosParent">Boletos</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_BLOQUETOS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">

								<!-- ************************************************* BLOQUETOS ************************************** -->
								<div class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr> 
                      <td colspan="4" class="textoDestaqueTitulo">Guia: Boletos</td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                    <tr>
                      <td class="textoTitulo" width="17%">Emissão de Boleto: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboEmissaoBloqueto name="emissaoBloquetos" selectedValue="<%= emissaoBloquetos  %>" onChange="javascript: configuraEnvioBloqueto();"/>
                      </td>
                      <td class="textoTitulo" width="17%">Envio do Boleto: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboEnvioBloqueto name="envioBloquetoCombo" selectedValue="<%= envioBloqueto  %>" onChange="javascript:trocaComboEnvioBloqueto();" branco="true"/>
                      </td>
                    </tr>
                    
                    <tr>
                      <td class="textoTitulo" width="17%">Aviso ao Sacado: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboSimNao name="avisoSacado" selectedValue="<%= avisoSacado %>" onChange="javascript:trocaComboAvisoSacado();" />
                      </td>
                      <td class="textoTitulo" width="17%">Envio do Aviso ao Sacado: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboEnvioBloqueto name="envioAvisoSacado" branco="true" brancoValue="99" selectedValue="<%= envioAvisoSacado %>" />
                      </td>
                    </tr>
                    
                    <tr>
                      <td class="textoTitulo" width="17%">Impressão em papel para SE: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboSimNao name="impBloqDDA" selectedValue="<%= impBloqDDA %>" />
                      </td>
                      <td class="textoTitulo" width="17%">Envio de SMS</td>
                      <td class="textoValor" width="26%"><s:ComboSimNao name="envioSMS" selectedValue="<%= envioSMS %>" /></td>
                    </tr>
                    
                    <%if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){ %>
                    	
                    	    <tr>
		                      <td class="textoTitulo" width="17%">Quantidade de Boletos por Mês para Beneficiário UL/CCA:</td>
		                      <td class="textoValor" width="26%"><p:InputNumerico CLASS="inputtext" name="qtdeBolMes" value="<%= qtdeBolMes %>" size="4" maxlength="3" /></td>
		                    </tr>
		                    
		                    <tr>
		                      <td class="textoTitulo" width="17%">Valor Mínimo para Beneficiário UL/CCA:</td>
		                      <td class="textoValor" width="26%"><p:InputCurrency CLASS="inputtext" name="valorMinULCCA" value="<%= valorMinULCCA %>" size="25" maxlength="15" /></td>
		                   
		                      <td class="textoTitulo" width="17%">Valor Máximo para Beneficiário UL/CCA:</td>
		                      <td class="textoValor" width="26%"><p:InputCurrency CLASS="inputtext" name="valorMaxULCCA" value="<%= valorMaxULCCA %>" size="25" maxlength="15"/></td>
		                    </tr>
                    <%} %>
                    
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                    <!-- REGRA: Os campos abaixo devem estar ocultos ou desabilitados 
                                e serao mostrados ao usuario apenas qdo da selecao 
                                especifica de campos que os habilitam (vide doc. gestor) -->
                    <tr>
                      <td class="textoTitulo" width="17%">Formas de Aviso: </td>
                      <td class="textoValor" width="26%">
                      	<input type="checkbox" name="formasAvisoVencido" value="S" onClick="javascript:trocaFormasAvisoVencido();" <%= checkFormasAvisoVencido %>>Vencido<br>
                      </td>
                      <td class="textoTitulo" width="17%">Valor Mínimo para Aviso: </td>
                      <td class="textoValor" width="26%">
        				        <p:InputCurrency CLASS="inputtext" name="valorMinimoAviso" value="<%= valorMinimoAviso %>" size="25" maxlength="15" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.avisoVencidoPrimeira);"/>
        				        <br>
                      </td>
										</tr>
                    <tr>
                      <td class="textoTitulo" width="17%">&nbsp;</td>
                      <td class="textoValor" width="26%">
                      	<input type="checkbox" name="formasAvisoProtesto" value="S" onClick="javascript:trocaFormasAvisoProtesto();" <%= checkFormasAvisoProtesto %>>Protesto
                      </td>
                      <td class="textoTitulo" width="17%">&nbsp;</td>
                      <td class="textoValor" width="26%">
        				        &nbsp;
                      </td>
                    </tr>

                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr>
	                    <td colspan="4">
							<table class="box" width="75%" border="0" cellspacing="3" cellpadding="0" height=53 valign="middle" align="center">
								<tr class="headerLista">
			                      <td align="left" class="textoDestaqueTitulo" width="1%">&nbsp;</td>
			                      <td align="left" class="textoDestaqueTitulo" width="20%">Quantidade de Emissões</td>
			                      <td align="left" class="textoDestaqueTitulo" width="20%">Envio Boleto E-mail</td>
			                      <td align="left" class="textoDestaqueTitulo" width="20%">Aviso Vencido</td>
			                      <td align="left" class="textoDestaqueTitulo" width="20%">Prazo SMS</td>
			                    </tr>
			                    <tr class="line2">
			                      <td class="textoValor" width="1%" align="center">&nbsp;</td> 
			                      <td class="textoValor" width="20%">1a. Emissão</td> 
			                      <td class="textoValor" width="20%"><input type="hidden" name="avisoDisponibPrimeira" value="<%= avisoDisponibPrimeira %>">   	0 dias        </td>
			                      <td class="textoValor" width="20%"><p:InputNumerico CLASS="inputtext" name="avisoVencidoPrimeira" value="<%= avisoVencidoPrimeira %>" size="3" maxlength="3" onBlur="javascript:trocaAvisoVencido(this);"  	onFocus="javascript: prevFocus(this);" onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.prazoSMS1);"/> dias   </td>
			                      <td class="textoValor" width="20%"><p:InputNumerico CLASS="inputtext" name="prazoSMS1" value="<%= prazoSMS1 %>" size="3" maxlength="3" onBlur="javascript:trocaAvisoVencido(this);"  	onFocus="javascript: prevFocus(this);" onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.avisoDisponibSegunda);"/> dias   </td> 
			                    </tr>
			                    <tr class="line2">
			                      <td class="textoValor" width="1%" align="center">&nbsp;</td> 
			                      <td class="textoValor" width="20%">2a. Emissão</td> 
			                      <td class="textoValor" width="20%">
			                      	<p:InputNumerico CLASS="inputtext" name="avisoDisponibSegunda" value="<%= avisoDisponibSegunda %>" size="3" maxlength="3" onBlur="javascript:trocaAvisoDisponib(this);" 
      					                	onFocus="javascript: prevFocus(this);"
																	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.avisoVencidoSegunda);"/> dias
			                      </td>
			                      <td class="textoValor" width="20%">
			                      	<p:InputNumerico CLASS="inputtext" name="avisoVencidoSegunda" value="<%= avisoVencidoSegunda %>" size="3" maxlength="3" onBlur="javascript:trocaAvisoVencido(this);" 
			                      	    onFocus="javascript: prevFocus(this);"
																	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.prazoSMS2);"/> dias
			                      </td>
								<td class="textoValor" width="20%"><p:InputNumerico CLASS="inputtext" name="prazoSMS2" value="<%= prazoSMS2 %>" size="3" maxlength="3" onBlur="javascript:trocaAvisoVencido(this);"  	onFocus="javascript: prevFocus(this);" onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.avisoDisponibTerceira);"/> dias   </td> 
			                    </tr>
			                    <tr class="line2">
			                      <td class="textoValor" width="1%" align="center">&nbsp;</td> 
			                      <td class="textoValor" width="20%">3a. Emissão</td> 
			                      <td class="textoValor" width="20%">
			                      	<p:InputNumerico CLASS="inputtext" name="avisoDisponibTerceira" value="<%= avisoDisponibTerceira %>" size="3" maxlength="3" 
			                      	    onFocus="javascript: prevFocus(this);"
																	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.avisoVencidoTerceira);"/> dias
			                      </td>
			                      <td class="textoValor" width="20%">
			                      	<p:InputNumerico CLASS="inputtext" name="avisoVencidoTerceira" value="<%= avisoVencidoTerceira %>" size="3" maxlength="3" 
			                      	    onFocus="javascript: prevFocus(this);"
																	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.prazoSMS3);"/> dias
			                      </td>
								  <td class="textoValor" width="20%"><p:InputNumerico CLASS="inputtext" name="prazoSMS3" value="<%= prazoSMS3 %>" size="3" maxlength="3" onBlur="javascript:trocaAvisoVencido(this);"  	onFocus="javascript: prevFocus(this);" onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/> dias   </td> 
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
                          <s:Button name="Confirmar" action="javascript:formSubmit_Bloquetos();" />
                          <s:Button name="Cancelar" action="javascript:fecharGuias();" />
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
                <a href="#MensagemParent" onclick="javascript:trocaGuia(6);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Mensagemi"></a>
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
                <a href="#TarifasParent" onclick="javascript:trocaGuia(7);">
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
                <a href="#ConclusaoParent" onclick="javascript:trocaGuia(8);">
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
	    	configuraEnvioBloqueto();
	    	trocaComboEnvioBloqueto();
	    	trocaComboAvisoSacado();
	    	trocaFormasAvisoProtesto();
	    	trocaFormasAvisoVencido();
	    	trocaAvisoVencido(document.frmMain.avisoVencidoPrimeira);
	    	trocaAvisoVencido(document.frmMain.avisoVencidoSegunda);    	
	    	trocaAvisoDisponib(document.frmMain.avisoDisponibSegunda);

<%
	// caso retornou da estrategia com criticas
	if (!descCriticas.equals("")) {
%>
				alert("<%= descCriticas %>");
<%
	}
%>
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

			function trocaFormasAvisoProtesto() {
				/*
				if (document.frmMain.formasAvisoProtesto.checked) {
					document.frmMain.qtdeDiasProtesto.disabled = false;
				} else {
					document.frmMain.qtdeDiasProtesto.value = "";
					document.frmMain.qtdeDiasProtesto.disabled = true;
				}
				*/
			}

			function trocaFormasAvisoVencido() {
				if (document.frmMain.formasAvisoVencido.checked) {
					document.frmMain.avisoVencidoPrimeira.disabled = false;
					document.frmMain.avisoVencidoSegunda.disabled = true;
					document.frmMain.avisoVencidoTerceira.disabled = true;
				} else {
					document.frmMain.avisoVencidoPrimeira.value = "";
					document.frmMain.avisoVencidoPrimeira.disabled = true;

					document.frmMain.avisoVencidoSegunda.value = "";
					document.frmMain.avisoVencidoSegunda.disabled = true;

					document.frmMain.avisoVencidoTerceira.value = "";
					document.frmMain.avisoVencidoTerceira.disabled = true;
				}
			}

			function trocaComboAvisoSacado() {
				if (document.frmMain.avisoSacado.value == "N") {
					document.frmMain.envioAvisoSacado.value = "99";
					document.frmMain.envioAvisoSacado.disabled = true;
					
					document.frmMain.formasAvisoVencido.checked = false;
					document.frmMain.formasAvisoVencido.disabled = true;
		    	trocaFormasAvisoVencido();

					document.frmMain.formasAvisoProtesto.checked = false;
					document.frmMain.formasAvisoProtesto.disabled = true;
		    	trocaFormasAvisoProtesto();

			  	document.frmMain.valorMinimoAviso.value = "";
			  	document.frmMain.valorMinimoAviso.disabled = true;
				} else {
					// Se nao havia um envioAvisoSacado, seta pra Correio
					if (<%= envioAvisoSacado %> == 99 || <%= envioAvisoSacado %> == 0) {
						document.frmMain.envioAvisoSacado.value = "1"; // 1 - Correio
					}
					document.frmMain.envioAvisoSacado.disabled = false;
					document.frmMain.formasAvisoVencido.disabled = false;
					document.frmMain.formasAvisoProtesto.disabled = false;
	      	document.frmMain.valorMinimoAviso.disabled = false;
				}
			}

			function trocaComboEnvioBloqueto() {
				if (document.frmMain.envioBloquetoCombo.value != 3) { // 3 - EMAIL
					document.frmMain.avisoDisponibSegunda.value = "";
					document.frmMain.avisoDisponibSegunda.disabled = true;

					document.frmMain.avisoDisponibTerceira.value = "";
					document.frmMain.avisoDisponibTerceira.disabled = true;
				} else {
					document.frmMain.avisoDisponibSegunda.disabled = false;
					document.frmMain.avisoDisponibTerceira.disabled = false;
				}
			}
			
			function trocaAvisoVencido(field) {
				if (field == document.frmMain.avisoVencidoPrimeira) {
					if (trim(field.value) == '') {
						document.frmMain.avisoVencidoSegunda.value = '';
						document.frmMain.avisoVencidoTerceira.value = '';
						document.frmMain.avisoVencidoSegunda.disabled = true;
						document.frmMain.avisoVencidoTerceira.disabled = true;
					} else {
						document.frmMain.avisoVencidoSegunda.disabled = false;
					}
				} else if (field == document.frmMain.avisoVencidoSegunda) {
					if (trim(field.value) == '') {
						document.frmMain.avisoVencidoTerceira.value = '';
						document.frmMain.avisoVencidoTerceira.disabled = true;
					} else {
						document.frmMain.avisoVencidoTerceira.disabled = false;
					}
				}
			}
			
			function trocaAvisoDisponib(field) {
				if (field == document.frmMain.avisoDisponibSegunda) {
					if (trim(field.value) == '') {
						document.frmMain.avisoDisponibTerceira.value = '';
						document.frmMain.avisoDisponibTerceira.disabled = true;
					} else {
						document.frmMain.avisoDisponibTerceira.disabled = false;
					}
				}
			}

	    function fecharGuias() {
	    	document.frmMain.guiaAberta.value = <%= CedenteEstrategia.GUIA_NENHUMA %>;
	    	document.frmMain.submit();
	    }
	    
	    function formSubmit() {
	    	formSubmit_Bloquetos();
	    }
	    
	    function formSubmit_Bloquetos() {
	    	if (validaSubmit_Bloquetos() && validaValores_Bloquetos()) {
	    		var confirma = confirm(conf('107'));
	    	
		    	if (confirma) {
			    	document.frmMain.estrategia.value="cedente.CedenteIncluirGuiaBloqFinalizar";
			    	document.frmMain.tipoAcao.value=document.frmMain.situacaoGuia.value;
						if(document.frmMain.envioBloquetoCombo.value != -1){
							document.frmMain.envioBloqueto.value = document.frmMain.envioBloquetoCombo.value;				
 						}			    	
			    	habilitaCampos();
			    	document.frmMain.submit();
			    }
		    }
	    }
	    
	    function validaSubmit_Bloquetos() {
				if(document.frmMain.emissaoBloquetos.value != 1){
			    if(!validaComboObrigatorio(document.frmMain.envioBloquetoCombo, 'Envio do Boleto')){
					  return false;
			    }
			  }						
				if (document.frmMain.avisoSacado.value == "S") {
					if (!validaComboObrigatorio(document.frmMain.envioAvisoSacado, 'Envio do Aviso ao Sacado', '99')) {
						return false;
					}

					if (!document.frmMain.formasAvisoVencido.checked &&
              !document.frmMain.formasAvisoProtesto.checked) {
						msg("020");
						document.frmMain.formasAvisoVencido.focus();
						return false;
					}

					if (!validaCampoObrigatorio(document.frmMain.valorMinimoAviso, 'Valor Mínimo para Aviso')) {
						return false;
					}

					if (document.frmMain.formasAvisoVencido.checked) {
						if (!validaCampoObrigatorio(document.frmMain.avisoVencidoPrimeira, 'Aviso Vencido – 1a. Emissão')) {
							return false;
						}
					}

					/*
					if (document.frmMain.formasAvisoProtesto.checked) {
						if (!validaCampoObrigatorio(document.frmMain.qtdeDiasProtesto, 'Qtde. Dias para Protesto')) {
							return false;
						}
					}
					*/
				}
				
				return true;
	    }

			function validaValores_Bloquetos() {
	    	// Qtde. Dias para Protesto entre 2 e 90
	    	/*
				if (trim(document.frmMain.qtdeDiasProtesto.value) != '') {
					if (document.frmMain.qtdeDiasProtesto.value < 2 ||
					    document.frmMain.qtdeDiasProtesto.value > 90) {
					  msg('005', 'Qtde. Dias para Protesto', 2, 90);
					  document.frmMain.qtdeDiasProtesto.focus();
	          return false;
					}
				}
				*/

	    	// Avisos disponib entre 0 e 120
				if (trim(document.frmMain.avisoDisponibSegunda.value) != '') {
					if (!validaIntervalo(document.frmMain.avisoDisponibSegunda, 'Boleto via e-mail – 2a. Emissão', 0, 120)) {
	          return false;
					}
				}
				if (trim(document.frmMain.avisoDisponibTerceira.value) != '') {
					if (!validaIntervalo(document.frmMain.avisoDisponibTerceira, 'Boleto via e-mail – 3a. Emissão', 0, 120)) {
	          return false;
					}
				}
				
	    	// Avisos vencido entre 0 e 120
				if (trim(document.frmMain.avisoVencidoPrimeira.value) != '') {
					if (!validaIntervalo(document.frmMain.avisoVencidoPrimeira, 'Aviso Vencido – 1a. Emissão', 0, 120)) {
	          return false;
					}
				}
				if (trim(document.frmMain.avisoVencidoSegunda.value) != '') {
					if (!validaIntervalo(document.frmMain.avisoVencidoSegunda, 'Aviso Vencido – 2a. Emissão', 0, 120)) {
	          return false;
					}
				}
				if (trim(document.frmMain.avisoVencidoTerceira.value) != '') {
					if (!validaIntervalo(document.frmMain.avisoVencidoTerceira, 'Aviso Vencido – 3a. Emissão', 0, 120)) {
	          return false;
					}
				}
				
				if (!validaDisponibOrdemCrescente()) {
					return false;
				}
				
				if (!validaVencidoOrdemCrescente()) {
					return false;
				}

				return true;
			}
			
			function validaDisponibOrdemCrescente() {
				if (trim(document.frmMain.avisoDisponibSegunda.value) != '') {
					if (new Number(document.frmMain.avisoDisponibSegunda.value) <= 0) {
						msg('006', 'Boleto via e-mail – 2a. Emissão', '1a. Emissão');
						document.frmMain.avisoDisponibSegunda.focus();
	          return false;
					}
				}

				if (trim(document.frmMain.avisoDisponibTerceira.value) != '') {
					if (new Number(document.frmMain.avisoDisponibTerceira.value) <= new Number(document.frmMain.avisoDisponibSegunda.value)) {
						msg('006', 'Boleto via e-mail – 3a. Emissão', '2a. Emissão');
						document.frmMain.avisoDisponibTerceira.focus();
	          return false;
					}
				}
				return true;
			}
			
			function validaVencidoOrdemCrescente() {
				if (trim(document.frmMain.avisoVencidoSegunda.value) != '') {
					if (new Number(document.frmMain.avisoVencidoSegunda.value) <= new Number(document.frmMain.avisoVencidoPrimeira.value)) {
						msg('006', 'Aviso Vencido – 2a. Emissão', '1a. Emissão');
						document.frmMain.avisoVencidoSegunda.focus();
	          return false;
					}
				}

				if (trim(document.frmMain.avisoVencidoTerceira.value) != '') {
					if (new Number(document.frmMain.avisoVencidoTerceira.value) <= new Number(document.frmMain.avisoVencidoSegunda.value)) {
						msg('006', 'Aviso Vencido – 3a. Emissão', '2a. Emissão');
						document.frmMain.avisoVencidoTerceira.focus();
	          return false;
					}
				}
				return true;
			}
			
			function habilitaCampos() {
				document.frmMain.envioAvisoSacado.disabled = false;
			}
    	function configuraEnvioBloqueto(){
    		if(document.frmMain.emissaoBloquetos.value == 1){
						document.frmMain.envioBloquetoCombo.value='-1';
						document.frmMain.envioBloquetoCombo.disabled=true;
				}
				else{
						document.frmMain.envioBloquetoCombo.disabled=false;					
				}
    		trocaComboEnvioBloqueto();
    	}			
			
    </script>

   	</s:FormStrategy>
  </p:Document>
</html>