<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteEletronicoBean"%>
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
	CedenteEletronicoBean eletronBean = (request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN)==null
	                                 ? new CedenteEletronicoBean()
	                                 : (CedenteEletronicoBean) request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN));

	// Inicializando valores dos campos
	String juncaoArquivoRetorno = Util.toStr(eletronBean.getJuncaoArquivoRetorno(), "N");
	String preCritica           = Util.toStr(eletronBean.getPreCritica(), "S");
	String copiaArquivoRetorno  = Util.toStr(eletronBean.getCopiaArquivoRetorno(), "N");
	String agrupamento          = Util.toStr(eletronBean.getAgrupamento(), "99"); // Padrao 99 - Brancos
	String apelido              = Util.toStr(eletronBean.getApelido());
	String apelidoCopia         = Util.toStr(eletronBean.getApelidoCopia());
	String aplicativo           = Util.toStr(eletronBean.getAplicativo(), "4"); //EAM - Novo Padrao 4- Cobranca Caixa
	String arquivoRetorno       = Util.toStr(eletronBean.getArquivoRetorno());
	String arquivoRetornoCopia  = Util.toStr(eletronBean.getArquivoRetornoCopia());
	String atribuicaoVan        = Util.toStr(eletronBean.getAtribuicaoVan(), "1"); // Padrao 1 - Cedente
	String caixaPostal          = Util.toStr(eletronBean.getCaixaPostal());
	String cedenteJuncao        = Util.toStr(eletronBean.getCedenteJuncao());
	String numeroProximaRemessa = Util.toStr(eletronBean.getNumeroProximaRemessa(), "1"); // Padrao 1
	String numeroUltimoRetorno  = Util.toStr(eletronBean.getNumeroUltimoRetorno(), "0"); // EAM - 06/10/05 Novo Padrao 0
	String padraoArquivo        = Util.toStr(eletronBean.getPadraoArquivo(), "1"); // Padrao 1 - CNAB 240
	String perfilRejeicao       = Util.toStr(eletronBean.getPerfilRejeicao(), "1"); // Padrao 1 - Total
	String tipoTransmissao      = Util.toStr(eletronBean.getTipoTransmissao(), "1"); // Padrao 1 - EDI/VAN
	String van                  = Util.toStr(eletronBean.getVan(), "99"); // Padrao 99 - Brancos
	String versao               = Util.toStr(eletronBean.getVersao());
	String dataEnvioReenvio     = Util.toStr(eletronBean.getDataEnvioReenvio());
	String codConnect           = Util.toStr(eletronBean.getCodConnect(),"99");
	
	String cmbInternet			= Util.toStr(eletronBean.getCodInternet(),"99");
	String retOnline			= Util.toStr(eletronBean.getRetOnline(),"N");
	String remOnline			= Util.toStr(eletronBean.getRemOnline(),"N");
	String numUltRetOnline      = Util.toStr(eletronBean.getNumUltRetOnline(),"0");
	String webservice   		= Util.toStr(eletronBean.getWebservice(),"N");
	
    InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute("usuarioLdap");
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
			
			<input type="hidden" name="tipoAcao" value="<%= (principalBean.isCedenteEletronicoCadastrado() == true) ? "S" : "I" %>">
			
			<input type="hidden" name="teste" value="<%= principalBean.isCedenteEletronicoCadastrado() %>">
			
			<input type="hidden" name="userTeste" value="<%= usuarioBean.getNomeGrupo() %>">

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
                <a href="#CedenteParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CEDENTE_ELETRONICO%>);"><img src="<%=Paths.getImagePath()%>/outlineminus.gif" width="11" height="11" name="outlineplus" id="Cedentei"></a>
                <a name="CedenteParent">Cedente Eletrônico</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_CEDENTE_ELETRONICO) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* CEDENTE ELETRONICO ************************************** -->

								<div class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                  
                    <tr> 
                      <td colspan="4" class="textoDestaqueTitulo">Guia: Cedente Eletrônico - Teste</td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                    <tr>
                      <td class="textoTitulo" width="17%">Aplicativo: </td>
                      <td class="textoValor" width="26%">
                        <s:ComboTipoAplicativo name="aplicativo" selectedValue="<%= aplicativo %>" /> - 
						<p:InputAlfanumerico CLASS="inputtext" name="versao" value="<%= versao %>" size="4" maxlength="5" value="" disabled="true" />
                      </td>
                      <td class="textoTitulo" width="17%">Tipo de Transmissão: </td>
                      <%
                      if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
                      %>
	                      <td class="textoValor" width="26%">
	                        <s:ComboTipoTransmissao name="tipoTransmissao" selectedValue="<%= tipoTransmissao %>" onChange="javascript:mudaComboTipoTransmissao();" />
	                      </td>
	                      
                      <%
                      }else{
                      %>
	                      <td class="textoValor" width="26%">
	                        <s:ComboTipoTransmissao name="tipoTransmissao" selectedValue="<%= tipoTransmissao %>" onChange="javascript:mudaComboTipoTransmissaoPV();" disabled="false"  />
	                      </td>
                      <%
                      
                      }
                      %>

                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Padrão de Arquivo: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboPadraoArquivo name="padraoArquivo" selectedValue="<%= padraoArquivo %>" />
                      </td>
                      <td class="textoTitulo" width="17%">Agrupamento: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboTipoAgrupamento name="agrupamento" selectedValue="<%= agrupamento %>" branco="true" brancoValue="99" />
                      </td>		
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Atribuição de VAN: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboAtribuicaoVan name="atribuicaoVan" 
                      	onChange="javascript:mudaVan()" 
                      	selectedValue="<%= atribuicaoVan %>" />
                      </td>
                      <td class="textoTitulo" width="17%">VAN: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboVan name="van" branco="true" selectedValue="<%= van %>" brancoValue="99" />
                      </td>
                    </tr>


					<tr>
						<td class="textoTitulo" width="17%"></td>
						<td class="textoValor" width="26%"></td>
						<td class="textoTitulo" width="17%">Connect:</td>
						<td class="textoValor" width="26%"><s:ComboConnect
							name="codConnect" branco="true"
							selectedValue="<%= codConnect %>" brancoValue="99"
							disabled="true" /></td>
					</tr>

                    <tr>
							<td class="textoTitulo" width="17%">&nbsp;</td>
							<td class="textoValor" width="26%">&nbsp;</td>
							<td class="textoTitulo" width="17%">Internet</td>
							<td class="textoValor" width="26%"><s:ComboInternet
								name="codInternet" branco="true"
								selectedValue="<%= cmbInternet %>" brancoValue="99"	/>
							</td>
					</tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Junção Arquivo Retorno: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboSimNao name="juncaoArquivoRetorno" selectedValue="<%= juncaoArquivoRetorno %>" onChange="javascript:mudaComboJuncaoArquivo();" />
                      </td>
                      <td class="textoTitulo" width="17%">Cedente Junção: </td>
				              <td width="26%" nowrap> 
        				        <p:InputNumerico CLASS="inputtext" name="cedenteJuncao" value="<%= cedenteJuncao %>" size="8" maxlength="7" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.perfilRejeicao);"/>
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Perfil Rejeição: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboPerfilRejeicao name="perfilRejeicao" selectedValue="<%= perfilRejeicao %>" />
                      </td>
                      <td class="textoTitulo" width="17%">Pré-Crítica: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboSimNao name="preCritica" selectedValue="<%= preCritica %>" />
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Apelido: </td>
				              <td width="26%" nowrap> 
        				        <p:InputAlfanumerico CLASS="inputtext" name="apelido" value="<%= apelido %>" size="9" maxlength="6" disabled="true" />
                      </td>
                      <td class="textoTitulo" width="17%">Arquivo de Retorno: </td>
				              <td width="26%" nowrap> 
        				        <p:InputAlfanumerico CLASS="inputtext" name="arquivoRetorno" value="<%= arquivoRetorno %>" size="40" maxlength="30" disabled="true" />
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Cópia Arquivo Retorno: </td>
                      <td class="textoValor" width="26%">
                      	<s:ComboSimNao name="copiaArquivoRetorno" selectedValue="<%= copiaArquivoRetorno %>" onChange="javascript:mudaComboCopiaArquivoRetorno();" />
                      </td>
                      <td class="textoTitulo" width="17%">Caixa Postal: </td>
                      <td class="textoValor" width="26%">
        				        <p:InputNumerico CLASS="inputtext" name="caixaPostal" value="<%= caixaPostal %>" size="8" maxlength="5" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Apelido (Cópia): </td>
				              <td width="26%" nowrap> 
        				        <p:InputAlfanumerico CLASS="inputtext" name="apelidoCopia" value="<%= apelidoCopia %>" size="9" maxlength="6" disabled="true" 
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>
                      </td>
                      <td class="textoTitulo" width="17%">Arquivo de Retorno (Cópia): </td>
				              <td width="26%" nowrap> 
        				        <p:InputAlfanumerico CLASS="inputtext" name="arquivoRetornoCopia" value="<%= arquivoRetornoCopia %>" size="40" maxlength="30" disabled="true" />
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Número Próxima Remessa: </td>
                      <td class="textoValor" width="26%">
        				        <p:InputNumerico disabled="true" CLASS="inputtext" name="numeroProximaRemessa" value="<%= numeroProximaRemessa %>" size="5" maxlength="5"/>
                      </td>
                      <td class="textoTitulo" width="17%">Número Último Retorno: </td>
                      <td class="textoValor" width="26%">
        				        <p:InputNumerico disabled="true" CLASS="inputtext" name="numeroUltimoRetorno" value="<%= numeroUltimoRetorno %>" size="5" maxlength="5" />
                      </td>
                    </tr>  
                    

                    
                    
	               	<tr>
						<td class="textoTitulo" width="17%">Retorno On Line:</td>
						<%
						if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM") ) {
						%>
						<td class="textoValor" width="26%"><s:ComboSimNao
							name="retOnline" disabled="false"
							selectedValue="<%=retOnline %>" onChange="javascript:mudaComboInternet();" />
						 </td>	
						<%
						}else{
						%>
						<td class="textoValor" width="26%"><s:ComboSimNao
							name="retOnline" disabled="true"
							selectedValue="<%=retOnline %>" />
						 </td>	
						<%	
						}
						%>
						</td>
						<td class="textoTitulo" width="17%">Num. Ult. Retorno On line</td>
						<%
						if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
						%>
						<td class="textoValor" width="26%">
							<p:InputNumerico disabled="false" CLASS="inputtext" name="numUltRetOnline" value="<%= numUltRetOnline %>" size="7" maxlength="6"/>
						</td>	
						<%
						}else{
						%>
						<td class="textoValor" width="26%">
							<p:InputNumerico disabled="true" CLASS="inputtext" name="numUltRetOnline" value="<%= numUltRetOnline %>" size="7" maxlength="6"/>
						</td>	
						<%	
						}
						%>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Remessa On Line:</td>
							<%
							if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
							%>
							<td class="textoValor" width="26%"><s:ComboSimNao
								name="remOnline" disabled="false"
								selectedValue="<%=remOnline %>" />
							 </td>	
							<%
							}else{
							%>
							<td class="textoValor" width="26%"><s:ComboSimNao
								name="remOnline" disabled="true"
								selectedValue="<%=remOnline %>" />
							 </td>	
							<%	
							}
							%>
						</td>
						<td class="textoTitulo" width="17%">Webservice:</td>
						<%
						if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
						%>
						<td class="textoValor" width="26%"><s:ComboSimNao
							name="webservice" disabled="false"
							selectedValue="<%= webservice %>" 
							/>
						 </td>	
						<%
						}else{
						%>
						<td class="textoValor" width="26%"><s:ComboSimNao
							name="webservice" disabled="true"
							selectedValue="<%= webservice %>" />
						 </td>	
						<%	
						}
						%>
						</td>
					</tr>
                    
                    
                    
                    
                    
                     
               
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr>
                      <td align="right" colspan="4">
                        <p align="center"> 
                          <s:Button name="Confirmar" action="javascript:formSubmit_Cedente();" />
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
	    	mudaComboTipoTransmissao();
	    	mudaComboJuncaoArquivo();
	    	mudaComboCopiaArquivoRetorno();
	    	mudaComboInternet();

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
	    
	    function fecharGuias() {
		    	document.frmMain.guiaAberta.value = <%= CedenteEstrategia.GUIA_NENHUMA %>;
		    	document.frmMain.submit();
	    }
	    
	    function formSubmit() {
	    	formSubmit_Cedente();
	    }
	    
	    function formSubmit_Cedente() {
	    	if (validaSubmit_Eletron()) {
		  		var confirma = confirm(conf('107'));
		  		
  	    	if (confirma) {
			    	document.frmMain.estrategia.value="cedente.CedenteIncluirGuiaEletronFinalizar";
			    	habilitaCampos();
			    	document.frmMain.submit();
			    }
		    }
	    }
	    
	    function validaSubmit_Eletron() {
	    	// Agrupamento nao eh mais obrigatorio
	    	//if (!validaComboObrigatorio(document.frmMain.agrupamento, 'Agrupamento', 99)) {
	    	//	return false;
	    	//}
	    	if (document.frmMain.tipoTransmissao.value == 1) { // 1 - EDI/VAN
	    		if (!validaComboObrigatorio(document.frmMain.van, 'VAN', 99)) {
	    			return false;
	    		}
	    	}else if (document.frmMain.tipoTransmissao.value == 3){
	    		if (document.frmMain.codConnect.value==99 || document.frmMain.codConnect.value=="99"){
	    			alert ("Connect deve ser selecionado");
	    			return false;
	    		}
	    	}
	    	if (document.frmMain.juncaoArquivoRetorno.value == "S") {
	    		if (!validaCampoObrigatorio(document.frmMain.cedenteJuncao, 'Cedente Junção')) {
	    			return false;
	    		}
	    		if (!validaMenorIgual(document.frmMain.cedenteJuncao, 'Cedente Junção', 0)) {
	    			return false;
	    		}
	    	}
	    	//if (!validaCampoObrigatorio(document.frmMain.apelido, 'Apelido')) {
	    	//	return false;
	    	//}
	    	//if (!validaCampoObrigatorio(document.frmMain.arquivoRetorno, 'Arquivo de Retorno')) {
	    	//	return false;
	    	//}
	    	
	    	<%//EAM2607 - Retirada a validação de apelido copia.
	    	//if (document.frmMain.copiaArquivoRetorno.value == "S") {
	    	//	if (!validaCampoObrigatorio(document.frmMain.apelidoCopia, 'Apelido (Cópia)')) {
	    	//		return false;
	    	//	}
	    	
	    		//if (!validaCampoObrigatorio(document.frmMain.arquivoRetornoCopia, 'Arquivo de Retorno (Cópia)')) {
	    		//	return false;
	    		//}
	    	//EAM2607}%>
	    	
	    	return true;
	    }
	    
	    
	   
	    
	    
	    function mudaComboTipoTransmissao() {
	    	
	    	if (document.frmMain.tipoTransmissao.value == "1") { // 1 - EDI/VAN
	    		
	    		document.frmMain.van.disabled = false;
	    		document.frmMain.codConnect.value=99;
	    		document.frmMain.codConnect.disabled = true
	    		document.frmMain.codInternet.value=99;
	    		document.frmMain.codInternet.disabled = true;
	    	} else if(document.frmMain.tipoTransmissao.value == "3") {
	    		
	    		document.frmMain.van.value = 99;
	    		document.frmMain.van.disabled = true;
	    		document.frmMain.codConnect.value=99;
	    		document.frmMain.codConnect.disabled = false;
	    		document.frmMain.codInternet.value=99;
	    		document.frmMain.codInternet.disabled = true;
	    	} else if(document.frmMain.tipoTransmissao.value == "5") {
	    		
	    		document.frmMain.van.value = 99;
	    		document.frmMain.van.disabled = true;
	    		document.frmMain.codConnect.value=99;
	    		document.frmMain.codConnect.disabled = true;
	    		document.frmMain.codInternet.value=99;
	    		document.frmMain.codInternet.disabled = false;
	    		
	    	}else {
	    		document.frmMain.van.value = 99;
	    		document.frmMain.van.disabled = true;
	    		document.frmMain.codConnect.value = 99;
	    		document.frmMain.codConnect.disabled = true;
	    		document.frmMain.codInternet.value=99;
	    		document.frmMain.codInternet.disabled = true;
	    	}
	    }
	    
	 
	    
	    function mudaComboTipoTransmissaoPV() {
	    	
	    	if (document.frmMain.tipoTransmissao.value == "1") { // 1 - EDI/VAN
	    		
	    		document.frmMain.van.disabled = false;
	    		document.frmMain.codConnect.value=99;
	    		document.frmMain.codConnect.disabled = true
    			document.frmMain.codInternet.value = 99;
    			document.frmMain.codInternet.disabled = true;
    			
	    	} else if(document.frmMain.tipoTransmissao.value == "3") {
	    		alert("Connect não é permitido para este perfil!");
	    		document.frmMain.tipoTransmissao.value = "1";
	    		document.frmMain.codConnect.value=99;
	    		document.frmMain.codConnect.disabled = true
    			document.frmMain.codInternet.value = 99;
    			document.frmMain.codInternet.disabled = true;
	    		
	    	} else if(document.frmMain.tipoTransmissao.value == "5") {
		    		
		    		document.frmMain.van.value = 99;
		    		document.frmMain.van.disabled = true;
		    		document.frmMain.codConnect.value=99;
		    		document.frmMain.codConnect.disabled = true;
		    		document.frmMain.codInternet.value=99;
		    		document.frmMain.codInternet.disabled = false;	
	    	}else {
	    		document.frmMain.van.value = 99;
	    		document.frmMain.van.disabled = true;
	    		document.frmMain.codConnect.value = 99;
	    		document.frmMain.codConnect.disabled = true;
    			document.frmMain.codInternet.value = 99;
    			document.frmMain.codInternet.disabled = true;
	    	}
	    }
	    
	    function mudaComboJuncaoArquivo() {
	    	if (document.frmMain.juncaoArquivoRetorno.value == "S") {
	    		document.frmMain.cedenteJuncao.disabled = false;
	    		<%//EAM0508%>
	    		document.frmMain.copiaArquivoRetorno.value = "N";
	    		document.frmMain.copiaArquivoRetorno.disabled = true;
	    		mudaComboCopiaArquivoRetorno();	    	
	    	
	    	} else {
	    		document.frmMain.cedenteJuncao.value = '';
	    		document.frmMain.cedenteJuncao.disabled = true;
	    		<%//EAM0508%>
	    		document.frmMain.copiaArquivoRetorno.disabled = false;
	    		mudaComboCopiaArquivoRetorno();	    		
	    		
	    	}
	    }
	    
	    function mudaComboCopiaArquivoRetorno() {
	    	if (document.frmMain.copiaArquivoRetorno.value == "S") {
	    		<%//EAM2607 - document.frmMain.apelidoCopia.disabled = false;
	    		// document.frmMain.arquivoRetornoCopia.disabled = false;
	    		
	    		//EAM1508%>
	    		document.frmMain.caixaPostal.disabled = true;
	    		document.frmMain.caixaPostal.value = '';

	    	} else {
	    		document.frmMain.apelidoCopia.value = '';
	    		<%//EAM2607 - document.frmMain.apelidoCopia.disabled = true;
	    		//EAM2607 - linha abaixo:retirado o comentario%>
	    		document.frmMain.arquivoRetornoCopia.value = '';
	    		// document.frmMain.arquivoRetornoCopia.disabled = true;
	    		
	    		<%//EAM1508	    		%>
	    		document.frmMain.caixaPostal.disabled = false;	    		
	    	}
	    }
	    
			function habilitaCampos() {
				for (var i = 0; i < document.frmMain.elements.length; i++) {
					document.frmMain.elements[i].disabled = false;
				}
			}
			
			

			function mudaVan(){
				
				
				if(document.frmMain.atribuicaoVan.value==2){
					document.frmMain.tipoTransmissao.selectedIndex=0;
					sorteiaVan();
					document.frmMain.tipoTransmissao.disabled=true;
					document.frmMain.van.disabled=true; 
					document.frmMain.codConnect.value=99;
		    		document.frmMain.codConnect.disabled = true;
					document.frmMain.codInternet.value = 99;
	    			document.frmMain.codInternet.disabled = true;
					
				}else{
					document.frmMain.tipoTransmissao.disabled=false;
					document.frmMain.van.disabled=false;
					
					
					
				}

			}
			
		    function sorteiaVan(){
		    	var qtde = document.frmMain.van.length;
				var posicao = Math.floor((Math.random() * qtde) + 1);
				document.frmMain.van.selectedIndex=posicao;
				//var valorTipo = document.frmMain.van.selectedIndex.text;
				if (posicao==0){
					posicao=1;
				}
				var valorTipo = document.getElementById('van').options[document.getElementById('van').selectedIndex].innerText;
				var posicaoini = valorTipo.length - 1;
				var posicaoFim = valorTipo.length ;
				var valorStr = valorTipo.substring(posicaoini, posicaoFim);

				///Somente em caso de 2 ou 1
				if (valorStr=="4"){
					sorteiaVan();
				}else if (valorStr=="3"){
					sorteiaVan();
				}
				/////caso seja usuario gestor
				if (document.frmMain.userTeste.value!="GCBADM"){
					if (valorStr=="2"){
						sorteiaVan();
					}
				}
				
			
										
		    }
		    
		    function mudaComboInternet(){
		    	if (document.frmMain.retOnline.value=="S"){
		    		document.frmMain.numUltRetOnline.disabled=false
		    	}else{
		    		document.frmMain.numUltRetOnline.disabled=true;
		    	}
		    }
		    
    </script>

   	</s:FormStrategy>
  </p:Document>
</html>
                  