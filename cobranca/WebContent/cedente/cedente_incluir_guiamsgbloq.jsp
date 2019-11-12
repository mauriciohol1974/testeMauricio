<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteMensagensBean"%>
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
	CedenteMensagensBean mensagensBean = (request.getAttribute(CedenteEstrategia.CEDENTE_MENSAGENS_BEAN)==null
	                                     ? new CedenteMensagensBean()
	                                     : (CedenteMensagensBean) request.getAttribute(CedenteEstrategia.CEDENTE_MENSAGENS_BEAN));

	String textAreaReciboSacadoBlqPadrao = "";
	if (mensagensBean.getTextAreaReciboSacadoBlqPadrao() != null) {
		textAreaReciboSacadoBlqPadrao = mensagensBean.getTextAreaReciboSacadoBlqPadrao();
	}
	
	String textAreaVersoBloquetoBlqPadrao = "";
	if (mensagensBean.getTextAreaVersoBloquetoBlqPadrao() != null) {
		textAreaVersoBloquetoBlqPadrao = mensagensBean.getTextAreaVersoBloquetoBlqPadrao();
	}

	String textAreaFichaCompensacaoBlqPadrao = "";
	if (mensagensBean.getTextAreaFichaCompensacaoBlqPadrao() != null) {
		textAreaFichaCompensacaoBlqPadrao = mensagensBean.getTextAreaFichaCompensacaoBlqPadrao();
	}

	String textAreaReciboSacadoBlqPersonalizado = "";
	if (mensagensBean.getTextAreaReciboSacadoBlqPersonalizado() != null) {
		textAreaReciboSacadoBlqPersonalizado = mensagensBean.getTextAreaReciboSacadoBlqPersonalizado();
	}

	String textAreaVersoBloquetoBlqPersonalizado = "";
	if (mensagensBean.getTextAreaVersoBloquetoBlqPersonalizado() != null) {
		textAreaVersoBloquetoBlqPersonalizado = mensagensBean.getTextAreaVersoBloquetoBlqPersonalizado();
	}

	String textAreaFichaCompensacaoBlqPersonalizado = "";
	if (mensagensBean.getTextAreaFichaCompensacaoBlqPersonalizado() != null) {
		textAreaFichaCompensacaoBlqPersonalizado = mensagensBean.getTextAreaFichaCompensacaoBlqPersonalizado();
	}

	String textAreaReciboSacadoABlqPersonalizado = "";
	if (mensagensBean.getTextAreaReciboSacadoABlqPersonalizado() != null) {
		textAreaReciboSacadoABlqPersonalizado = mensagensBean.getTextAreaReciboSacadoABlqPersonalizado();
	}

	String textAreaReciboSacadoBBlqPersonalizado = "";
	if (mensagensBean.getTextAreaReciboSacadoBBlqPersonalizado() != null) {
		textAreaReciboSacadoBBlqPersonalizado = mensagensBean.getTextAreaReciboSacadoBBlqPersonalizado();
	}

	String textAreaReciboSacadoBlqPreImpresso = "";
	if (mensagensBean.getTextAreaReciboSacadoBlqPreImpresso() != null) {
		textAreaReciboSacadoBlqPreImpresso = mensagensBean.getTextAreaReciboSacadoBlqPreImpresso();
	}

	String textAreaFichaCompensacaoBlqPreImpresso = "";
	if (mensagensBean.getTextAreaFichaCompensacaoBlqPreImpresso() != null) {
		textAreaFichaCompensacaoBlqPreImpresso = mensagensBean.getTextAreaFichaCompensacaoBlqPreImpresso();
	}

	String textAreaReciboSacadoBancoCorresp = "";
	if (mensagensBean.getTextAreaReciboSacadoBancoCorresp() != null) {
		textAreaReciboSacadoBancoCorresp = mensagensBean.getTextAreaReciboSacadoBancoCorresp();
	}
	String textAreaReciboDDAImpresso = "";
	if (mensagensBean.getTextAreaReciboDDAImpresso() != null) {
		textAreaReciboDDAImpresso = mensagensBean.getTextAreaReciboDDAImpresso();
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
                <a href="#MensagemParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_MENSAGENS%>);"><img src="<%=Paths.getImagePath()%>/outlineminus.gif" width="11" height="11" name="outlineplus" id="Mensagemi"></a>
                <a name="MensagemParent">Mensagens para Boletos</a>                
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_MENSAGENS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* MENSAGEM ************************************** -->

								<div class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr> 
                      <td class="textoDestaqueTitulo">Guia: Mensagens para Boletos</td>
                    </tr>
                    <tr> 
                      <td>&nbsp;</td>
                    </tr>
				            
				            <s:Outline name="MensagemBlqPadraoParent" title="Mensagens para Boletos - Boleto Padrão" imagePath="<%=Paths.getImagePath()%>" type="twist">
			                  <table width="97%" border="0" cellspacing="1" cellpadding="1" height=14 valign="middle" align="center">
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%" colspan="2">Local de Impressão da Mensagem: </td>
			                      <td class="textoValor" width="60%" colspan="2">
			                      	<input type="checkbox" name="checkReciboSacadoBlqPadrao" onClick="javascript:desabilitaEdicao('ReciboSacadoBlqPadrao');">Recibo Sacado<br>
			                      	<input type="checkbox" name="checkVersoBloquetoBlqPadrao" onClick="javascript:desabilitaEdicao('VersoBloquetoBlqPadrao');">Verso Boleto<br>
			                      	<input type="checkbox" name="checkFichaCompensacaoBlqPadrao" onClick="javascript:desabilitaEdicao('FichaCompensacaoBlqPadrao');">Ficha de Compensação
			                      </td>
			                    </tr>
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%" align="top">Mensagem Recibo do Sacado: </td>
			                      <td class="textoValor" width="80%" colspan="3">
			                        <textarea name="textAreaReciboSacadoBlqPadrao" cols="40" rows="3" readonly></textarea>
			                        <s:Button name="editaMsgReciboSacadoBlqPadrao" value="Editar" disabled="true" action="javascript:editaMensagem(\"ReciboSacadoBlqPadrao\", 40, 23, 40);" />
			                      </td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%">Mensagem Verso Boleto: </td>
			                      <td class="textoValor" width="80%" colspan="3">
	                         		<textarea name="textAreaVersoBloquetoBlqPadrao" cols="75" rows="3" readonly></textarea>
															<s:Button name="editaMsgVersoBloquetoBlqPadrao" value="Editar" disabled="true" action="javascript:editaMensagem(\"VersoBloquetoBlqPadrao\", 75, 23, 40);" />
			                      </td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%">Mensagem Ficha Compensação: </td>
			                      <td class="textoValor" width="80%" colspan="3">
	                         		<textarea name="textAreaFichaCompensacaoBlqPadrao" cols="40" rows="2" readonly></textarea>
															<s:Button name="editaMsgFichaCompensacaoBlqPadrao" value="Editar" disabled="true" action="javascript:editaMensagem(\"FichaCompensacaoBlqPadrao\", 40, 23, 40);" />
			                      </td>
			                    </tr>
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
			                  </table>
										</s:Outline>

										<s:Outline name="MensagemBlqPersonalizadoParent" title="Mensagens para Boletos - Boleto Personalizado" imagePath="<%=Paths.getImagePath()%>" type="twist">
				                <table width="97%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%" colspan="2">Local de Impressão da Mensagem: </td>
			                      <td class="textoValor" width="30%">
			                      	<input type="checkbox" name="checkReciboSacadoBlqPersonalizado" onClick="javascript:desabilitaEdicao('ReciboSacadoBlqPersonalizado');">Recibo Sacado<br>
			                      	<input type="checkbox" name="checkVersoBloquetoBlqPersonalizado" onClick="javascript:desabilitaEdicao('VersoBloquetoBlqPersonalizado');">Verso Boleto<br>
			                      	<input type="checkbox" name="checkFichaCompensacaoBlqPersonalizado" onClick="javascript:desabilitaEdicao('FichaCompensacaoBlqPersonalizado');">Ficha de Compensação<br>
			                      </td>
			                      <td class="textoValor" width="30%" nowrap>
			                      	<input type="checkbox" name="checkReciboSacadoABlqPersonalizado" onClick="javascript:desabilitaEdicao('ReciboSacadoABlqPersonalizado');">Recibo do Sacado A (Somente p/ Mod 11)<br>
			                      	<input type="checkbox" name="checkReciboSacadoBBlqPersonalizado" onClick="javascript:desabilitaEdicao('ReciboSacadoBBlqPersonalizado');">Recibo do Sacado B (Somente p/ Mod 11)<br>
			                      </td>
			                    </tr>
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%">Mensagem Recibo do Sacado: </td>
			                      <td class="textoValor" width="80%" colspan="3">
			                         	<p align="justify">
			                         		<textarea name="textAreaReciboSacadoBlqPersonalizado" cols="40" rows="3" readonly></textarea>
			                         		<s:Button name="editaMsgReciboSacadoBlqPersonalizado" value="Editar" disabled="true" action="javascript:editaMensagem(\"ReciboSacadoBlqPersonalizado\", 40, 23, 40);" />
					                   	  </p>
			                      </td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%">Mensagem Verso Boleto: </td>
			                      <td class="textoValor" width="80%" colspan="3">
			                         	<p align="justify">
			                         		<textarea name="textAreaVersoBloquetoBlqPersonalizado" cols="75" rows = "3" readonly></textarea>
			                         		<s:Button name="editaMsgVersoBloquetoBlqPersonalizado" value="Editar" disabled="true" action="javascript:editaMensagem(\"VersoBloquetoBlqPersonalizado\", 75, 23, 40);" />
					                   	  </p>
			                      </td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%">Mensagem Ficha Compensação: </td>
			                      <td class="textoValor" width="80%" colspan="3">
			                         	<p align="justify">
			                         		<textarea name="textAreaFichaCompensacaoBlqPersonalizado" cols="40" rows = "2" readonly></textarea>
																	<s:Button name="editaMsgFichaCompensacaoBlqPersonalizado" value="Editar" disabled="true" action="javascript:editaMensagem(\"FichaCompensacaoBlqPersonalizado\", 40, 23, 40);" />
					                   	  </p>
			                      </td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%">Mensagem Recibo do Sacado A: </td>
			                      <td class="textoValor" width="80%" colspan="3">
			                         	<p align="justify">
			                         		<textarea name="textAreaReciboSacadoABlqPersonalizado" cols="40" rows = "3" readonly></textarea>
			                         		<s:Button name="editaMsgReciboSacadoABlqPersonalizado" value="Editar" disabled="true" action="javascript:editaMensagem(\"ReciboSacadoABlqPersonalizado\", 40, 23, 40);" />
					                   	  </p>
			                      </td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%">Mensagem Recibo do Sacado B: </td>
			                      <td class="textoValor" width="80%" colspan="3">
			                         	<p align="justify">
			                         		<textarea name="textAreaReciboSacadoBBlqPersonalizado" cols="40" rows = "3" readonly></textarea>
			                         		<s:Button name="editaMsgReciboSacadoBBlqPersonalizado" value="Editar" disabled="true" action="javascript:editaMensagem(\"ReciboSacadoBBlqPersonalizado\", 40, 23, 40);" />
					                   	  </p>
			                      </td>
			                    </tr>
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
				                </table>
				            </s:Outline>

				            <s:Outline name="MensagemBlqPreImpressoParent" title="Mensagens para Boletos - Boleto Pré-Impresso" imagePath="<%=Paths.getImagePath()%>" type="twist">
				                <table width="97%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%" colspan="2">Local de Impressão da Mensagem: </td>
			                      <td class="textoValor" width="60%" colspan="2">
			                      	<input type="checkbox" name="checkReciboSacadoBlqPreImpresso" onClick="javascript:desabilitaEdicao('ReciboSacadoBlqPreImpresso');">Recibo Sacado (A4)<br>
			                      	<input type="checkbox" name="checkFichaCompensacaoBlqPreImpresso" onClick="javascript:desabilitaEdicao('FichaCompensacaoBlqPreImpresso');">Ficha de Compensação (A4/Matricial)
			                      </td>
			                    </tr>
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%">Mensagem Recibo do Sacado (A4): </td>
			                      <td class="textoValor" width="80%" colspan="3">
			                         	<p align="justify">
			                         		<textarea name="textAreaReciboSacadoBlqPreImpresso" cols="40" rows="3" readonly></textarea>
																	<s:Button name="editaMsgReciboSacadoBlqPreImpresso" value="Editar" disabled="true" action="javascript:editaMensagem(\"ReciboSacadoBlqPreImpresso\", 40, 23, 40);" />
					                   	  </p>
			                      </td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%">Mensagem Ficha Compensação (A4/Matricial): </td>
			                      <td class="textoValor" width="80%" colspan="3">
			                         	<p align="justify">
			                         		<textarea name="textAreaFichaCompensacaoBlqPreImpresso" cols="40" rows = "2" readonly></textarea>
																	<s:Button name="editaMsgFichaCompensacaoBlqPreImpresso" value="Editar" disabled="true" action="javascript:editaMensagem(\"FichaCompensacaoBlqPreImpresso\", 40, 23, 40);" />
					                   	  </p>
			                      </td>
			                    </tr>
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
				                  </table>
				            </s:Outline>

				            <s:Outline name="MensagemBancoCorrespParent" title="Mensagem para Boletos - Banco Correspondente" imagePath="<%=Paths.getImagePath()%>" type="twist">
				                  <table width="97%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%">Mensagem: </td>
			                      <td class="textoValor" width="80%" colspan="3">
			                         	<p align="justify">
			                         		<textarea name="textAreaReciboSacadoBancoCorresp" cols="40" rows = "1" readonly></textarea>
																	<s:Button name="editaMsgReciboSacadoBancoCorresp" value="Editar" action="javascript:editaMensagem(\"ReciboSacadoBancoCorresp\", 40, 23, 40);" />
					                   	  </p>
			                      </td>
			                    </tr>
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
				                  </table>
				            </s:Outline>
				            
				            <s:Outline name="MensagemDDAImpressoParent" title="Mensagem para Boletos - DDA Impressão" imagePath="<%=Paths.getImagePath()%>" type="twist">
				                  <table width="97%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
			                    <tr>
			                      <td class="textoTitulo" width="20%">Mensagem: </td>
			                      <td class="textoValor" width="80%" colspan="3">
			                         	<p align="justify">
			                         		<textarea name="textAreaReciboDDAImpresso" cols="40" rows = "1" readonly></textarea>
																	<s:Button name="editaMsgReciboDDAImpresso" value="Editar" action="javascript:editaMensagem(\"ReciboDDAImpresso\", 40, 23, 40);" />
					                   	  </p>
			                      </td>
			                    </tr>
			                    <tr> 
			                      <td colspan="4">&nbsp;</td>
			                    </tr>
				                  </table>
				            </s:Outline>
				            

                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td align="right" colspan="4">
                        <p align="center"> 
                          <s:Button name="Confirmar" action="javascript:formSubmit_Mensagem();" />
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
    	// Numero de linhas para cada tipo impressao
    	var mensagensTamanho = new Array(11);
    	mensagensTamanho[0]  = new Array( "ReciboSacadoBlqPadrao", 4 );
    	mensagensTamanho[1]  = new Array( "VersoBloquetoBlqPadrao", 30 );
    	mensagensTamanho[2]  = new Array( "FichaCompensacaoBlqPadrao", 2 );
    	mensagensTamanho[3]  = new Array( "ReciboSacadoBlqPersonalizado", 4 );
    	mensagensTamanho[4]  = new Array( "VersoBloquetoBlqPersonalizado", 30 );
    	mensagensTamanho[5]  = new Array( "FichaCompensacaoBlqPersonalizado", 2 );
    	mensagensTamanho[6]  = new Array( "ReciboSacadoABlqPersonalizado", 15 );
    	mensagensTamanho[7]  = new Array( "ReciboSacadoBBlqPersonalizado", 10 ) ;
    	mensagensTamanho[8]  = new Array( "ReciboSacadoBlqPreImpresso", 4 );
    	mensagensTamanho[9] = new Array( "FichaCompensacaoBlqPreImpresso", 2 );
    	mensagensTamanho[10] = new Array( "ReciboSacadoBancoCorresp", 1 );
    	mensagensTamanho[11] = new Array( "ReciboDDAImpresso", 1 );
    
	    function inicia(){

<%
	// caso retornou da estrategia com criticas
	if (!descCriticas.equals("")) {
%>
				alert("<%= descCriticas %>");
<%
	} else {
%>
	    	if (document.frmMain.situacaoGuia.value == 'I') {
		    	initTextAreas();
	    	} else {
					document.frmMain.textAreaReciboSacadoBlqPadrao.value = '<%= textAreaReciboSacadoBlqPadrao %>';
					document.frmMain.textAreaVersoBloquetoBlqPadrao.value = '<%= textAreaVersoBloquetoBlqPadrao %>';
					document.frmMain.textAreaFichaCompensacaoBlqPadrao.value = '<%= textAreaFichaCompensacaoBlqPadrao %>';
					document.frmMain.textAreaReciboSacadoBlqPersonalizado.value = '<%= textAreaReciboSacadoBlqPersonalizado %>';
					document.frmMain.textAreaVersoBloquetoBlqPersonalizado.value = '<%= textAreaVersoBloquetoBlqPersonalizado %>';
					document.frmMain.textAreaFichaCompensacaoBlqPersonalizado.value = '<%= textAreaFichaCompensacaoBlqPersonalizado %>';
					document.frmMain.textAreaReciboSacadoABlqPersonalizado.value = '<%= textAreaReciboSacadoABlqPersonalizado %>';
					document.frmMain.textAreaReciboSacadoBBlqPersonalizado.value = '<%= textAreaReciboSacadoBBlqPersonalizado %>';
					document.frmMain.textAreaReciboSacadoBlqPreImpresso.value = '<%= textAreaReciboSacadoBlqPreImpresso %>';
					document.frmMain.textAreaFichaCompensacaoBlqPreImpresso.value = '<%= textAreaFichaCompensacaoBlqPreImpresso %>';
					document.frmMain.textAreaReciboSacadoBancoCorresp.value = '<%= textAreaReciboSacadoBancoCorresp %>';
					document.frmMain.textAreaReciboDDAImpresso.value = '<%= textAreaReciboDDAImpresso%>';

					if (!isTextAreaEmpty('ReciboSacadoBlqPadrao')) {
						document.frmMain.checkReciboSacadoBlqPadrao.checked = true;
					}
					if (!isTextAreaEmpty('VersoBloquetoBlqPadrao')) {
						document.frmMain.checkVersoBloquetoBlqPadrao.checked = true;
					}
					if (!isTextAreaEmpty('FichaCompensacaoBlqPadrao')) {
						document.frmMain.checkFichaCompensacaoBlqPadrao.checked = true;
					}
					if (!isTextAreaEmpty('ReciboSacadoBlqPersonalizado')) {
						document.frmMain.checkReciboSacadoBlqPersonalizado.checked = true;
					}
					if (!isTextAreaEmpty('VersoBloquetoBlqPersonalizado')) {
						document.frmMain.checkVersoBloquetoBlqPersonalizado.checked = true;
					}
					if (!isTextAreaEmpty('FichaCompensacaoBlqPersonalizado')) {
						document.frmMain.checkFichaCompensacaoBlqPersonalizado.checked = true;
					}
					if (!isTextAreaEmpty('ReciboSacadoABlqPersonalizado')) {
						document.frmMain.checkReciboSacadoABlqPersonalizado.checked = true;
					}
					if (!isTextAreaEmpty('ReciboSacadoBBlqPersonalizado')) {
						document.frmMain.checkReciboSacadoBBlqPersonalizado.checked = true;
					}
					if (!isTextAreaEmpty('ReciboSacadoBlqPreImpresso')) {
						document.frmMain.checkReciboSacadoBlqPreImpresso.checked = true;
					}
					if (!isTextAreaEmpty('FichaCompensacaoBlqPreImpresso')) {
						document.frmMain.checkFichaCompensacaoBlqPreImpresso.checked = true;
					}
	    	}
<%
	}
%>

	    	verificaCheckBoxes();
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
	    
	    function formSubmit_Mensagem() {
	    	if (validaSubmit_Mensagem()) {
	    		var confirma = confirm(conf('107'));
	    	
		    	if (confirma) {
			    	document.frmMain.estrategia.value="cedente.CedenteIncluirGuiaMsgBloqFinalizar";
			    	document.frmMain.tipoAcao.value=document.frmMain.situacaoGuia.value;
			    	document.frmMain.submit();
			    }
		   	}
	    }
	    
	    function validaSubmit_Mensagem() {
	    	return true;
	    }
	    
	    function editaMensagem( tipoImpressao, colunas, altura, largura ) {
	    	var linhas = retornaNumeroLinhas(tipoImpressao);
	    	var obj = eval('document.frmMain.textArea' + tipoImpressao);
				var resposta = showModalDialog('<%=Paths.getRootForDynamicContent()%>/jump/edita_mensagem.jsp?linhas='+linhas+'&colunas='+colunas, obj.value, "dialogHeight:"+altura+"; dialogWidth:"+largura+"; center: yes; help:no; resizable:yes; scroll:yes; status:no");
				if (resposta != null) {
					obj.value = resposta;
				}
	    }
	    
	    // Inicializa os textareas com \n
	    function initTextAreas() {
	     	for (var i = 0; i < mensagensTamanho.length; i++) {
		    	var txtArea = eval('document.frmMain.textArea' + mensagensTamanho[i][0]);
		    	txtArea.value = criaLinhas( mensagensTamanho[i][1] );
	    	}
	    }
	    
	    function verificaCheckBoxes() {
	    	// mensagensTamanho.length - 1, ultimo nao tem checkbox
	     	for (var i = 0; i < mensagensTamanho.length - 1; i++) {
		    	desabilitaEdicao( mensagensTamanho[i][0] );
		    }
	    }
	    
	    function criaLinhas( numeroLinhas ) {
	    	var linhas = "";
	    	for (var i = 0; i < numeroLinhas; i++) {
	    		linhas += '\n';
	    	}
	    	return linhas;
	    }
	    
	    function retornaNumeroLinhas( tipoImpressao ) {
	    	for (var i = 0; i < mensagensTamanho.length; i++) {
	    		if (mensagensTamanho[i][0] == tipoImpressao) {
	    			return mensagensTamanho[i][1];
	    		}
	    	}
	    	return 0;
	    }
	    
	    //
	    // tipoImpressao eh o nome do checkBox, textArea e botao sem o prefixo identificador (check, textArea, ...)
	    //
	    function desabilitaEdicao( tipoImpressao ) {
	    	var check = eval('document.frmMain.check' + tipoImpressao);
	    	var txtArea = eval('document.frmMain.textArea' + tipoImpressao);
	    	var botao = eval('document.frmMain.editaMsg' + tipoImpressao);
	    	
	    	if (check.checked) {
	    		botao.disabled = false;
	    	} else {
	    		botao.disabled = true;
	    		txtArea.value = criaLinhas( retornaNumeroLinhas( tipoImpressao ) );
	    	}
	    }
	    
	    function isTextAreaEmpty( tipoImpressao ) {
	    	var txtArea = eval('document.frmMain.textArea' + tipoImpressao);
	    	var texto = txtArea.value;
	    	
	    	for (var i = 0; i < texto.length; i++) {
	    		if (texto.charAt(i) != '\n' && texto.charAt(i) != '\r') {
	    			return false;
	    		}
	    	}
	    	
	    	return true;
	    }
    </script>

   	</s:FormStrategy>
  </p:Document>
</html>								