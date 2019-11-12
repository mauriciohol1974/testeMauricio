<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConclusaoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConteudoListaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
            String descCriticas = "";
            if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
                descCriticas = (String) request.getAttribute(CedenteEstrategia.DESC_CRITICAS);
            }
%>

<%
                    CedenteCabecaBean cabecaBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN) == null
                    ? new CedenteCabecaBean()
                    : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

            CedentePrincipalBean principalBean = (session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN) == null
                    ? new CedentePrincipalBean()
                    : (CedentePrincipalBean) session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN));

            CedenteConteudoListaBean filtroBean = (session.getAttribute(CedenteEstrategia.ALTERAR_FILTRO_BEAN) == null
                    ? new CedenteConteudoListaBean()
                    : (CedenteConteudoListaBean) session.getAttribute(CedenteEstrategia.ALTERAR_FILTRO_BEAN));

            String nsuTransacao = filtroBean.getNsuTransacao();

            int guiaAberta = principalBean.getGuiaAberta() == null
                    ? CedenteEstrategia.GUIA_NENHUMA
                    : principalBean.getGuiaAberta().intValue();
            String tipoCobranca = principalBean.getTipoCobranca() == null
                    ? "" + CedenteEstrategia.COBRANCA_CONVENCIONAL
                    : "" + principalBean.getTipoCobranca();
            String cedenteCentralizador = principalBean.getCedenteCentralizador() == null
                    ? "0"
                    : "" + principalBean.getCedenteCentralizador();

            String codigoCedente = "";
            if (filtroBean.getCodigoCedente() != null) {
                codigoCedente = "" + filtroBean.getCodigoCedente();
            }
%>

<%
                    CedenteGeralBean geralBean = (session.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN) == null
                    ? new CedenteGeralBean()
                    : (CedenteGeralBean) session.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN));

            CedenteConclusaoBean conclusaoBean = (request.getAttribute(CedenteEstrategia.CEDENTE_CONCLUSAO_BEAN) == null
                    ? new CedenteConclusaoBean()
                    : (CedenteConclusaoBean) request.getAttribute(CedenteEstrategia.CEDENTE_CONCLUSAO_BEAN));

            String codigoUnidadeEN = "" + conclusaoBean.getCodigoUnidadeEN();
            String codigoUnidadeENFormatado = conclusaoBean.getCodigoUnidadeENFormatado();
            String dataInclusao = "" + conclusaoBean.getDataInclusaoFormatada();
            String dataUltimaAlteracao = ""
                                         + conclusaoBean.getDataUltimaAlteracaoFormatada();
            String responsavelAlteracao = ""
                                          + conclusaoBean.getResponsavelAlteracao();

            InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean) session.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="cedente.CedenteAlterarGuiaControle" fluxo="normal">
		<s:Menu />
		<s:Titulo name="Manter Cedente >> Alterar" />

		<input type="hidden" name="guiaAberta" value="<%= guiaAberta %>">
		<input type="hidden" name="tipoCobranca" value="<%= tipoCobranca %>">
		<input type="hidden" name="cedenteCentralizador"
			value="<%= cedenteCentralizador %>">

		<input type="hidden" name="nsuTransacao" value="<%= nsuTransacao %>">
		<input type="hidden" name="codigoCedente" value="<%= codigoCedente %>">

		<input type="hidden" name="cpfCnpj"
			value="<%= cabecaBean.getCpfCnpj() %>">
		<input type="hidden" name="nomeCedente"
			value="<%= cabecaBean.getNomeFantasia() %>">
		<input type="hidden" name="idEndereco"
			value="<%= cabecaBean.getIdEndereco() %>">
		<input type="hidden" name="codigoUnidadeEN"
			value="<%= codigoUnidadeEN %>">
		<input type="hidden" name="dataInclusao" value="<%= dataInclusao %>">
		<input type="hidden" name="dataUltimaAlteracao"
			value="<%= dataUltimaAlteracao %>">
		<input type="hidden" name="responsavelAlteracao"
			value="<%= responsavelAlteracao %>">

		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height=53 valign="middle" align="center">

					<%-- *********** CABECALHO CEDENTE ****************** --%>
					<%@include file="cedente_cabecalho.jsp"%>

					<tr valign="top">
						<td colspan="5" class="textoTitulo">Manter Guias:
						<hr>
						</td>
					</tr>
					<!-- Os usuários do grupo GCBATE só podem acessar a Guia de Ced Eletronico e Confirmar. -->
					<%
					if (!usuarioLDAPBean.getNomeGrupo().equals("GCBATE")) {
					%>
					<tr>
						<td class="textoTitulo"><a href="#GeralParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_GERAL%>);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Gerali"></a> <a
							name="GeralParent">Geral</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* GERAL ************************************** -->
						</td>
					</tr>
					<tr>
						<td class="textoTitulo"><a href="#FloatParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_FLOAT%>);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Floati"></a> <a
							name="FloatParent">Float</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* FLOAT ************************************** -->
						</td>
					</tr>
					<tr>
						<td class="textoTitulo"><a href="#ContasParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CONTAS%>);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Contasi"></a> <a
							name="contasParent">Contas Déb. Créd. e Rateio</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* CONTAS ************************************** -->
						</td>
					</tr>
					<%
					}
					%>
					<tr>
						<td class="textoTitulo"><a href="#CedenteParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CEDENTE_ELETRONICO%>);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Cedentei"></a> <a
							name="CedenteParent">Cedente Eletrônico</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* CEDENTE ELETRONICO ************************************** -->
						</td>
					</tr>
					<%
					if (!usuarioLDAPBean.getNomeGrupo().equals("GCBATE")) {
					%>
					<tr>
						<td class="textoTitulo"><a href="#BloquetosParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_BLOQUETOS%>);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Bloquetosi"></a> <a
							name="BloquetosParent">Boletos</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* BLOQUETOS ************************************** -->
						</td>
					</tr>

					<tr>
						<td class="textoTitulo"><a href="#MensagemParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_MENSAGENS%>);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Mensagemi"></a> <a
							name="MensagemParent">Mensagens para Boletos</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* MENSAGEM ************************************** -->
						</td>
					</tr>

					<tr>
						<td class="textoTitulo"><a href="#TarifasParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_TARIFAS%>);">
						<img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Tarifasi"></a> <a
							name="TarifasParent">Tarifas</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* TARIFAS ************************************** -->
						</td>
					</tr>
					<%
					}
					%>
					<tr>
						<td class="textoTitulo"><a href="#ParametrosParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_PARAMETROS%>);"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Mensagemi"></a> <a
							name="MensagemParent">Parâmetros</a></td>
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
							name="PermissaoParent">Permissão Final</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* Permissão  ************************************** -->
						</td>
					</tr>							
					<tr>
						<td class="textoTitulo"><a href="#ConclusaoParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CONCLUSAO%>);">
						<img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Conclusaoi"></a> <a
							name="ConclusaoParent">Conclusão</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					
					<tr>
						<td colspan="4"><!-- ************************************************* CONCLUSAO ************************************** -->
						<div class="group">

						<table width="95%" border="0" cellspacing="0" cellpadding="0"
							height=14 valign="middle" align="center">
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="4" class="textoDestaqueTitulo">Guia: Conclusão
								do Cadastramento</td>
							</tr>
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>
							<tr>
								<td class="textoTitulo" width="17%">SR:</td>
								<!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
								<td class="textoValor" width="26%"><%=codigoUnidadeENFormatado%></td>

								<td class="textoTitulo" width="17%">Data de Inclusão:</td>
								<td class="textoValor" width="26%"><%=dataInclusao%></td>
							</tr>
							<tr>
								<td class="textoTitulo" width="17%">Data Última Alteração:
								</td>
								<td class="textoValor" width="26%"><%=dataUltimaAlteracao%></td>
								<td class="textoTitulo" width="17%">Responsável Alteração:
								</td>
								<td class="textoValor" width="26%"><%=responsavelAlteracao%></td>
							</tr>
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>
							<tr>
								<td align="right" colspan="4">
								<p align="center"><s:Button name="Confirmar"
									value="Confirmar" action="javascript:formSubmit_Conclusao();"
									userGroup="<%=usuarioLDAPBean.getNomeGrupo()%>"
									internalAction="cedente.cadastro.manter.alterar" /> <s:Button
									name="Cancelar" value="Cancelar"
									action="javascript:fecharGuias();"
									userGroup="<%=usuarioLDAPBean.getNomeGrupo()%>"
									internalAction="cedente.cadastro.manter.alterar" /></p>
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
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td align="right" colspan="4">
						<p align="center"><s:Button name="Voltar_Principal"
							value="Voltar" action="javascript:formSubmit_Voltar();" /> <s:Button
							name="Cancelar_Principal" value="Cancelar Alteração"
							action="javascript:formSubmit_Cancelar();" /></p>
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
	    
	    function formSubmit_Conclusao() {
	    	document.frmMain.estrategia.value="cedente.CedenteAlterarGuiaConcFinalizar";
	    	document.frmMain.submit();
	    }
	    
    </script>

	</s:FormStrategy>
</p:Document>
</html>
