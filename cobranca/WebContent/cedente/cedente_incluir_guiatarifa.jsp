<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteTarifasBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

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
	int guiaInclusao = principalBean.getUltimaGuiaCadastrada() == null ? CedenteEstrategia.GUIA_NENHUMA + 1 : principalBean.getUltimaGuiaCadastrada().intValue() + 1;
	int ultimaGuiaCadastrada = principalBean.getUltimaGuiaCadastrada() == null ? CedenteEstrategia.GUIA_NENHUMA : principalBean.getUltimaGuiaCadastrada().intValue();
	String situacaoGuia = principalBean.getSituacaoGuia() == null ? CedenteEstrategia.CONSULTA : principalBean.getSituacaoGuia();
	String tipoCobranca = principalBean.getTipoCobranca() == null ? ""+CedenteEstrategia.COBRANCA_CONVENCIONAL : ""+principalBean.getTipoCobranca();
	String cedenteCentralizador = principalBean.getCedenteCentralizador() == null ? "0" : ""+principalBean.getCedenteCentralizador();
	int cedenteEletronicoCadastrado = principalBean.getCedenteEletronicoCadastrado() == null ? 0 : principalBean.getCedenteEletronicoCadastrado().intValue();
%>

<%
	CedenteTarifasBean tarifasBean = (request.getAttribute(CedenteEstrategia.CEDENTE_TARIFAS_BEAN)==null
	                                 ? new CedenteTarifasBean()
	                                 : (CedenteTarifasBean)	request.getAttribute(CedenteEstrategia.CEDENTE_TARIFAS_BEAN));

	String periodicidadeTarifa = "D"; // Padrao D - Diario
	if (tarifasBean.getPeriodicidadeTarifa() != null) {
		periodicidadeTarifa = tarifasBean.getPeriodicidadeTarifa();
	}
	String formaCalculo = "2"; // EAM Novo Padrao 2 - Valor
	if (tarifasBean.getFormaCalculo() != null) {
		formaCalculo = ""+tarifasBean.getFormaCalculo();
	}
	String diaDebito = "";
	if (tarifasBean.getDiaDebito() != null) {
		diaDebito = ""+tarifasBean.getDiaDebito();
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
			<input type="hidden" name="tipoImportacao" value ="I">
			<input type="hidden" name="nsuTransacao" value="">

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
                <a href="#ContasParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CONTAS%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Contasi"></a>
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
                	 <img src="<%=Paths.getImagePath()%>/outlineminus.gif" width="11" height="11" name="outline" id="Tarifasi"></a>
                <a name="TarifasParent">Tarifas</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_TARIFAS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* TARIFAS ************************************** -->

								<div class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr> 
                      <td colspan="4" class="textoDestaqueTitulo">Guia: Tarifas</td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

										<tr>
                      <td class="textoTitulo" width="17%">Periodicidade da Tarifa:</td>
                      <td class="textoValor" width="26%">
                      	<s:ComboPeriodicidadeTarifas name="periodicidadeTarifa" selectedValue="<%= periodicidadeTarifa %>" onChange="javascript:mudaComboPeriodicidadeTarifa();" />
                      </td>
                      <td class="textoTitulo" width="17%">Dia do Débito:</td>
                      <td class="textoValor" width="26%">
        				        <p:InputNumerico CLASS="inputtext" name="diaDebito" value="<%= diaDebito %>" size="2" maxlength="2" 
			                      	    onFocus="javascript: prevFocus(this);"
																	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.formaCalculo);"/>
                      </td>
                    </tr>

										<tr>
                      <td class="textoTitulo" width="17%">Tipo de Negociação:</td>
                      <td class="textoValor" width="26%">VALOR
                        <input type="hidden" name="formaCalculo" value="2"/>
                      	<!--<s:ComboFormaCalculo name="formaCalculo" selectedValue="<%= formaCalculo %>" />-->
                      </td>
                      <td class="textoTitulo" width="17%">&nbsp;</td>
                      <td class="textoValor" width="26%">&nbsp;</td>
                    </tr>

                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr>
	                    <td colspan="4">
												<table class="box" width="35%" border="0" cellspacing="3" cellpadding="0" height=53 valign="middle" align="center">
													<tr class="headerLista">
			                      <td class="textoTitulo" colspan="4" width="17%">Informar Tarifas: </td>
													</tr>
													<tr>
			                      <td class="textoTitulo" width="1%">&nbsp;</td>
			                      <td class="textoTitulo" width="17%">Grupo: </td>
			                      <td class="textoValor" width="26%">
			                      	<s:ComboGrupo name="codigoAgrupamentoServico" />
			                      </td>
			                      <td class="textoTitulo" width="1%">&nbsp;</td>
													</tr>
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
													<tr>
			                      <td align="right" colspan="4">
			                      	<p align="center">
				                      	<s:Button name="Informar" action="javascript:formSubmit_GrupoTarifas();" />
				                      </p>
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
                          <s:Button name="Importar Simulador" action="javascript:ImportarSISNG();" />
                          <s:Button name="Confirmar" value="Confirmar" action="javascript:formSubmit_Tarifas();" />
                          <s:Button name="Cancelar" value="Cancelar" action="javascript:fecharGuias();" />
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
	    var janelaTarifa = null;
    
	    function inicia(){
	    	mudaComboPeriodicidadeTarifa();

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
	    		fecharJanelaTarifa();

          document.frmMain.estrategia.value="cedente.CedenteIncluirCancelar";
          document.frmMain.submit();
        }
			}

	    function formSubmit_Voltar() {
	      var confirma = confirm(conf('104'));
      
        if (confirma) {
        	fecharJanelaTarifa();
        
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
	    
				// fecha janela de tarifa se estiver aberta
				if (janelaTarifa != null && !janelaTarifa.closed) {
					if (confirm(conf('142'))) {
						fecharJanelaTarifa();
					} else {
						return;
					}
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
				// fecha janela de tarifa se estiver aberta
				if (janelaTarifa != null && !janelaTarifa.closed) {
					if (confirm(conf('142'))) {
						fecharJanelaTarifa();
					} else {
						return;
					}
	    	}
	    
	    	document.frmMain.guiaAberta.value = <%= CedenteEstrategia.GUIA_NENHUMA %>;
	    	document.frmMain.submit();
	    }
	    
	    function formSubmit() {
	    	formSubmit_Tarifas();
	    }
	    
	    function formSubmit_Tarifas() {
				// fecha janela de tarifa se estiver aberta
				if (janelaTarifa != null && !janelaTarifa.closed) {
					if (confirm(conf('142'))) {
						fecharJanelaTarifa();
					} else {
						return;
					}
	    	}

	    	if (validaSubmit_Tarifas()) {
	    		var confirma = confirm(conf('107'));
	    	
		    	if (confirma) {
			    	document.frmMain.estrategia.value="cedente.CedenteIncluirGuiaTarifaFinalizar";
			    	document.frmMain.tipoAcao.value=document.frmMain.situacaoGuia.value;
			    	document.frmMain.submit();
			    }
		   	}
	    }

	    function formSubmit_GrupoTarifas() {
				var valorAltura = 350;
				var valorLargura = 640;
				var valorTopo = (screen.height - valorAltura) /2;
				var valorEsquerda = (screen.width - valorLargura) /2;
	    
				janelaTarifa = window.open("<%=Paths.getRootForDynamicContent()%>/jump/cedente_incluir_tarifas_jump.jsp", "cedente_incluir_tarifas<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "height="+valorAltura+",width="+valorLargura+",top="+valorTopo+",left="+valorEsquerda+",toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=0");
				janelaTarifa.focus();
	    }
	    
	    
	    function ImportarSISNG() {
			var valorAltura = 550;
			var valorLargura = 700;
			var valorTopo = (screen.height - valorAltura) /2;
			var valorEsquerda = (screen.width - valorLargura) /2;
    
			janelaTarifa = window.open("<%=Paths.getRootForDynamicContent()%>/jump/cedente_importar_tarifas_jump.jsp", "cedente_importar_tarifas<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "height="+valorAltura+",width="+valorLargura+",top="+valorTopo+",left="+valorEsquerda+",toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=0");
			janelaTarifa.focus();
	    	document.frmMain.submit();
    	}
	    
	    function fecharJanelaTarifa() {
	    	if (janelaTarifa != null && !janelaTarifa.closed) {
			   	janelaTarifa.close();
			  }
	    }
	    
	    function validaSubmit_Tarifas() {
	    	if (document.frmMain.periodicidadeTarifa.value == 'M') {
	    		if (!validaCampoObrigatorio(document.frmMain.diaDebito, 'Dia do Débito')) {
	    			return false;
	    		}
	    		
		    	// Dia Debito entre 1 e 31
					if (document.frmMain.diaDebito.value < 1 ||
					    document.frmMain.diaDebito.value > 31) {
					  msg('005', 'Dia do Débito', 1, 31);
					  document.frmMain.diaDebito.focus();
	          return false;
					}
	    	}
	    	return true;
	    }
	    
	    function mudaComboPeriodicidadeTarifa() {
	    	if (document.frmMain.periodicidadeTarifa.value == 'M') {
	    		document.frmMain.diaDebito.disabled = false;
	    	} else {
	    		document.frmMain.diaDebito.value = '';
	    		document.frmMain.diaDebito.disabled = true;
	    	}
	    }
    </script>

   	</s:FormStrategy>
  </p:Document>
</html>
