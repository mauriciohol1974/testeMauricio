<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteFloatBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConteudoListaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.ArrayList"%>


<%
	String descCriticas = "";
	if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
		descCriticas = (String) request.getAttribute(CedenteEstrategia.DESC_CRITICAS);
	} 
%>

<% 
	CedenteCabecaBean cabecaBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
	                               ? new CedenteCabecaBean()
	                               : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

	CedentePrincipalBean principalBean = (session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN)==null
	                                     ? new CedentePrincipalBean()
	                                     : (CedentePrincipalBean) session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN));

	CedenteConteudoListaBean filtroBean = (session.getAttribute(CedenteEstrategia.ALTERAR_FILTRO_BEAN)==null
	                                      ? new CedenteConteudoListaBean()
	                                      : (CedenteConteudoListaBean) session.getAttribute(CedenteEstrategia.ALTERAR_FILTRO_BEAN));

	String nsuTransacao = filtroBean.getNsuTransacao();

	int guiaAberta = principalBean.getGuiaAberta() == null ? CedenteEstrategia.GUIA_NENHUMA : principalBean.getGuiaAberta().intValue();
	String tipoCobranca = principalBean.getTipoCobranca() == null ? ""+CedenteEstrategia.COBRANCA_CONVENCIONAL : ""+principalBean.getTipoCobranca();
	String cedenteCentralizador = principalBean.getCedenteCentralizador() == null ? "0" : ""+principalBean.getCedenteCentralizador();	

	String codigoCedente = "";
	if (filtroBean.getCodigoCedente() != null) {
		codigoCedente = "" + filtroBean.getCodigoCedente();
	}
%>


<%
	ArrayList listaFloatDefault = (ArrayList) session.getAttribute(CedenteEstrategia.FLOAT_LISTA_DEFAULT);
	ArrayList listaFloat = (ArrayList) session.getAttribute(CedenteEstrategia.FLOAT_LISTA);

	String[] arrayLabels = new String[10];
	arrayLabels[0] = "Caixa - Dinheiro";
	arrayLabels[1] = "Caixa - Cheque";
	arrayLabels[2] = "Lot�rico - Dinheiro";
	arrayLabels[3] = "Lot�rico - Cheque";
	arrayLabels[4] = "Compensa��o";
	arrayLabels[5] = "Auto-Atendimento";
	arrayLabels[6] = "Correspondente Banc�rio";
	arrayLabels[7] = "Internet Banking";
	arrayLabels[8] = "STR/TED";
	arrayLabels[9] = "Mobile Pre-Pago";
	
	String[] arrayFields = new String[10];
	arrayFields[0] = "floatCaixaDinheiro";
	arrayFields[1] = "floatCaixaCheque";
	arrayFields[2] = "floatLotericoDinheiro";
	arrayFields[3] = "floatLotericoCheque";
	arrayFields[4] = "floatCompensacao";
	arrayFields[5] = "floatAutoAtendimento";
	arrayFields[6] = "floatCorrespondenteBancario";
	arrayFields[7] = "floatInternetBanking";
	arrayFields[8] = "floatStrTed";
	arrayFields[9] = "floatMobile";

	String[] arrayDefaults = new String[10];
	if (listaFloatDefault != null) {
		for (int i = 0; i < listaFloatDefault.size(); i++) {
			CedenteFloatBean bean = (CedenteFloatBean) listaFloatDefault.get(i);
			int indice = bean.getMeioEntrada().intValue() - 4; // meios de entrada de 4 a 12
			arrayDefaults[indice] = "" + bean.getNumeroFloat();
		}
	} else {
		arrayDefaults[0] = "0";
		arrayDefaults[1] = "0";
		arrayDefaults[2] = "0";
		arrayDefaults[3] = "0";
		arrayDefaults[4] = "0";
		arrayDefaults[5] = "0";
		arrayDefaults[6] = "0";
		arrayDefaults[7] = "0";
		arrayDefaults[8] = "0";
		arrayDefaults[9] = "0";
	}

	String[] arrayFloats = new String[10];
	if (listaFloat != null) {
		for (int i = 0; i < listaFloat.size(); i++) {
			CedenteFloatBean bean = (CedenteFloatBean) listaFloat.get(i);
			int indice = bean.getMeioEntrada().intValue() - 4; // meios de entrada de 4 a 12
			arrayFloats[indice] = "" + bean.getNumeroFloat();
		}
	} else {
		arrayFloats[0] = arrayDefaults[0];
		arrayFloats[1] = arrayDefaults[1];
		arrayFloats[2] = arrayDefaults[2];
		arrayFloats[3] = arrayDefaults[3];
		arrayFloats[4] = arrayDefaults[4];
		arrayFloats[5] = arrayDefaults[5];
		arrayFloats[6] = arrayDefaults[6];
		arrayFloats[7] = arrayDefaults[7];
		arrayFloats[8] = arrayDefaults[8];
		arrayFloats[9] = arrayDefaults[9];
	}

	InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean)session.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
	
%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteAlterarGuiaControle" fluxo="normal">
   		<s:Menu/>
   		<s:Titulo name="Manter Cedente >> Alterar"/>

			<input type="hidden" name="guiaAberta" value="<%= guiaAberta %>">
			<input type="hidden" name="tipoCobranca" value="<%= tipoCobranca %>">
			<input type="hidden" name="cedenteCentralizador" value="<%= cedenteCentralizador %>">			
			
			<input type="hidden" name="nsuTransacao" value="<%= nsuTransacao %>">
			<input type="hidden" name="codigoCedente" value="<%= codigoCedente %>">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

						<%-- *********** CABECALHO CEDENTE ****************** --%>
            <%@include file="cedente_cabecalho.jsp" %>
            
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Manter Guias:
                <hr>
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#GeralParent" onclick="javascript:trocaGuia(1);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Gerali"></a>
                <a name="GeralParent">Geral</a>
              </td>
              <td colspan="3" class="textoValor">
                &nbsp;
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* GERAL ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#FloatParent" onclick="javascript:trocaGuia(2);"><img src="<%=Paths.getImagePath()%>/outlineminus.gif" width="11" height="11" name="outlineplus" id="Floati"></a>
                <a name="FloatParent">Float</a>
              </td>
              <td colspan="3" class="textoValor">
                &nbsp;
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* FLOAT ************************************** -->

								<div class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                  
                    <tr> 
                      <td colspan="4" class="textoDestaqueTitulo">Guia: Float</td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                    <tr>
                    	<td colspan="4">
		                  <table class="box" width="50%" border="0" cellspacing="2" cellpadding="0" height=14 valign="middle" align="center">
		                    <tr class="headerLista"> 
			                    <td width="1%" align="left" nowrap>&nbsp;</td>
													<td width="50%" align="left" nowrap>&nbsp;</td>
													<td width="20%" align="center" nowrap>Padr�o</td>
													<td width="20%" align="center" nowrap>Negociado</td>
			                    <td width="1%" align="left" nowrap>&nbsp;</td>
												</tr>

<%
	for (int i = 0; i < arrayLabels.length; i++) {
		// nextFocus
		String nextFocus = "javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);";
		if (i + 1 < arrayLabels.length) {
			nextFocus = "javascript: nextFocus(event.keyCode, this, " + arrayFields[i+1] + ");";
		}
%>
												<tr>
			                    <td width="1%" align="left" nowrap>&nbsp;</td>
		                      <td class="textoTitulo" width="50%" nowrap><%= arrayLabels[i] %>:</td>
		                      <td class="textoValor" width="20%" align="center" nowrap>
		                      	<%= arrayDefaults[i] %> 
		                      </td>
						              <td class="textoValor" width="20%" align="center" nowrap>
			      				        <p:InputNumerico CLASS="inputtext" name="<%= arrayFields[i] %>" value="<%= arrayFloats[i] %>" size="2" maxlength="2"
						                	onFocus="javascript: prevFocus(this);"
															onKeyUp="<%= nextFocus %>" />
			                    <td width="1%" align="left" nowrap>&nbsp;</td>
          							</tr>
<%
	}
%>

          						</table>
          						</td>
										</tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td align="right" colspan="4">
                        <p align="center"> 
                          <s:Button name="Confirmar" action="javascript:formSubmit_Float();" userGroup="<%=usuarioLDAPBean.getNomeGrupo()%>" internalAction="cedente.cadastro.manter.alterar"/>
                          <s:Button name="Cancelar" action="javascript:fecharGuias();" userGroup="<%=usuarioLDAPBean.getNomeGrupo()%>" internalAction="cedente.cadastro.manter.alterar"/>
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
                <a href="#ContasParent" onclick="javascript:trocaGuia(3);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Contasi"></a>
                <a name="contasParent">Contas D�b. Cr�d. e Rateio</a>
              </td>
              <td colspan="3" class="textoValor">
                &nbsp;
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
                <a name="CedenteParent">Cedente Eletr�nico</a>
              </td>
              <td colspan="3" class="textoValor">
                &nbsp;
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* CEDENTE ELETRONICO ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#BloquetosParent" onclick="javascript:trocaGuia(5);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Bloquetosi"></a>
                <a name="BloquetosParent">Boletos</a>
              </td>
              <td colspan="3" class="textoValor">
                &nbsp;
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* BLOQUETOS ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#MensagemParent" onclick="javascript:trocaGuia(6);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Mensagemi"></a>
                <a name="MensagemParent">Mensagens para Boletos</a>                
              </td>
              <td colspan="3" class="textoValor">
                &nbsp;
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
                &nbsp;
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* TARIFAS ************************************** -->
              </td>
            </tr>
					<tr>
						<td class="textoTitulo"><a href="#ParametrosParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_PARAMETROS%>);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Mensagemi"></a> <a
							name="MensagemParent">Par�metros</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>	
					<tr>
						<td colspan="4"><!-- ************************************************* PARAMETROS  ************************************** -->
						</td>
					</tr>		
					<tr>
						<td class="textoTitulo"><a href="#PermissaoParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_PERMISSAO%>);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Permissaoi"></a> <a
							name="PermissaoParent">Permiss�o Final</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* Permiss�o  ************************************** -->
						</td>
					</tr>			     
            <tr>
              <td class="textoTitulo">
                <a href="#ConclusaoParent" onclick="javascript:trocaGuia(8);">
                	 <img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Conclusaoi"></a>
                <a name="ConclusaoParent">Conclus�o</a>
              </td>
              <td colspan="3" class="textoValor">
                &nbsp;
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
                  <s:Button name="Cancelar_Principal" value="Cancelar Altera��o" action="javascript:formSubmit_Cancelar();"/>
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
        var confirma = confirm(conf('126'));
      
        if (confirma) {
          document.frmMain.estrategia.value="cedente.CedenteAlterarCancelar";
          document.frmMain.submit();
        }
			}

	    function formSubmit_Voltar() {
        var confirma = confirm(conf('161'));
      
        if (confirma) {
        	document.frmMain.fluxo.value = "voltar";
          document.frmMain.estrategia.value="cedente.CedenteManterFiltro";
          document.frmMain.submit();
        }
	    }
	    
	    function trocaGuia( guia ) {
	    	if (!confirm(conf("128"))) {
	    		return;
	    	}
	    
	    	if (guia == <%= guiaAberta %>) {
	    		fecharGuias();
	    		return;
	    	}

	    	//if (guia == <%= CedenteEstrategia.GUIA_CEDENTE_ELETRONICO %>
	    	//			&& document.frmMain.tipoCobranca.value == <%= ""+CedenteEstrategia.COBRANCA_CONVENCIONAL %>) {
	    	//		return;
	    	//}
	    
	    	document.frmMain.guiaAberta.value = guia;
	    	document.frmMain.submit();
	    }
	    
	    function fecharGuias() {
		    	document.frmMain.guiaAberta.value = <%= CedenteEstrategia.GUIA_NENHUMA %>;
		    	document.frmMain.submit();
	    }

			function formSubmit() {
				formSubmit_Float();
			}

	    function formSubmit_Float() {
	    	if (validaSubmit_Float()) {
	    		var confirma = confirm(conf('127'));
	    	
		    	if (confirma) {
			    	document.frmMain.estrategia.value="cedente.CedenteAlterarGuiaFloatFinalizar";
			    	document.frmMain.submit();
			    }
		    }
	    }

			function validaSubmit_Float() {
<%
	for (int i = 0; i < arrayFields.length; i++) {
%>
				if (!validaCampoObrigatorio(document.frmMain.<%=arrayFields[i]%>, 'Float <%=arrayLabels[i]%>')) {
					return false;
				}
				if (document.frmMain.<%=arrayFields[i]%>.value < 0 ||
				    document.frmMain.<%=arrayFields[i]%>.value > 99) {
				  msg('005', 'Float <%=arrayLabels[i]%>', 0, 99);
				  document.frmMain.<%=arrayFields[i]%>.focus();
          return false;
				}
<%
	}
%>
				return true;
			}

    </script>

   	</s:FormStrategy>
  </p:Document>
</html>                  