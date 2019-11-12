<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteEletronicoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConteudoListaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>

<%String descCriticas = "";
            if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
                descCriticas = (String) request.getAttribute(CedenteEstrategia.DESC_CRITICAS);
            }
%>


<%
            CedenteGeralBean cedenteGeralBean = (CedenteGeralBean) request.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN);

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

<%CedenteEletronicoBean testeBean = (request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN) == null
                    ? new CedenteEletronicoBean()
                    : (CedenteEletronicoBean) request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN));

            // Inicializando valores dos campos
            String juncaoArquivoRetorno = Util.toStr(testeBean.getJuncaoArquivoRetorno(),
                    "N");
            String preCritica = Util.toStr(testeBean.getPreCritica(), "S");
            String copiaArquivoRetorno = Util.toStr(testeBean.getCopiaArquivoRetorno(),
                    "N");
            String agrupamento = Util.toStr(testeBean.getAgrupamento(), "99"); // Padrao 99 - Brancos
            String apelido = Util.toStr(testeBean.getApelido());
            String apelidoCopia = Util.toStr(testeBean.getApelidoCopia());
            String aplicativo = Util.toStr(testeBean.getAplicativo(), "1"); // Padrao 1- Caixa
            String arquivoRetorno = Util.toStr(testeBean.getArquivoRetorno());
            String arquivoRetornoCopia = Util.toStr(testeBean.getArquivoRetornoCopia());
            String atribuicaoVan = Util.toStr(testeBean.getAtribuicaoVan(), "1"); // Padrao 1 - Cedente
            String caixaPostal = Util.toStr(testeBean.getCaixaPostal());
            String cedenteJuncao = Util.toStr(testeBean.getCedenteJuncao());
            String numeroProximaRemessa = Util.toStr(testeBean.getNumeroProximaRemessa(),
                    "1"); // Padrao 1
            String numeroUltimoRetorno = Util.toStr(testeBean.getNumeroUltimoRetorno(),
                    "0"); // EAM - 14/10/05 Novo Padrao 0
            String padraoArquivo = Util.toStr(testeBean.getPadraoArquivo(), "1"); // Padrao 1 - CNAB 240
            String perfilRejeicao = Util.toStr(testeBean.getPerfilRejeicao(),
                    "1"); // Padrao 1 - Total
            String tipoTransmissao = Util.toStr(testeBean.getTipoTransmissao(),
                    "1"); // Padrao 1 - EDI/VAN
            String van = Util.toStr(testeBean.getVan(), "99"); // Padrao 99 - Brancos
            String versao = Util.toStr(testeBean.getVersao());

            String cadastrado = testeBean.getCadastrado() != null
                    ? testeBean.getCadastrado()
                    : "";
            //	String descCadastrado = "Cedente	Eletrônico - Teste: Não Cadastrado";
            //	if ("S".equals(cadastrado)) {
            //		descCadastrado = "Cedente	Eletrônico - Teste: Cadastrado";
            //	}

            %>

<%CedenteEletronicoBean producaoBean = (request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_PRODUCAO_BEAN) == null
                    ? new CedenteEletronicoBean()
                    : (CedenteEletronicoBean) request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_PRODUCAO_BEAN));

            // Inicializando valores dos campos
            String juncaoArquivoRetornoProducao = Util.toStr(producaoBean.getJuncaoArquivoRetorno(),
                    "N");
            String preCriticaProducao = Util.toStr(producaoBean.getPreCritica(),
                    "S");
            String copiaArquivoRetornoProducao = Util.toStr(producaoBean.getCopiaArquivoRetorno(),
                    "N");
            String agrupamentoProducao = Util.toStr(producaoBean.getAgrupamento(),
                    "99"); // Padrao 99 - Brancos
            String apelidoProducao = Util.toStr(producaoBean.getApelido());
            String apelidoCopiaProducao = Util.toStr(producaoBean.getApelidoCopia());
            String aplicativoProducao = Util.toStr(producaoBean.getAplicativo(),
                    "1"); // Padrao 1- Caixa
            String arquivoRetornoProducao = Util.toStr(producaoBean.getArquivoRetorno());
            String arquivoRetornoCopiaProducao = Util.toStr(producaoBean.getArquivoRetornoCopia());
            String atribuicaoVanProducao = Util.toStr(producaoBean.getAtribuicaoVan(),
                    "1"); // Padrao 1 - Cedente
            String caixaPostalProducao = Util.toStr(producaoBean.getCaixaPostal());
            String cedenteJuncaoProducao = Util.toStr(producaoBean.getCedenteJuncao());
            String numeroProximaRemessaProducao = Util.toStr(producaoBean.getNumeroProximaRemessa(),
                    "1"); // Padrao 1
            String numeroUltimoRetornoProducao = Util.toStr(producaoBean.getNumeroUltimoRetorno(),
                    "0"); // EAM - 14/10/05 Novo Padrao 0
            String padraoArquivoProducao = Util.toStr(producaoBean.getPadraoArquivo(),
                    "1"); // Padrao 1 - CNAB 240
            String perfilRejeicaoProducao = Util.toStr(producaoBean.getPerfilRejeicao(),
                    "1"); // Padrao 1 - Total
            String tipoTransmissaoProducao = Util.toStr(producaoBean.getTipoTransmissao(),
                    "1"); // Padrao 1 - EDI/VAN
            String vanProducao = Util.toStr(producaoBean.getVan(), "99"); // Padrao 99 - Brancos
            String versaoProducao = Util.toStr(producaoBean.getVersao());

            String cadastradoProducao = producaoBean.getCadastrado() != null
                    ? producaoBean.getCadastrado()
                    : "";
            /*
             String descCadastradoProducao = "Não Cadastrado";
             if ("S".equals(cadastradoProducao)) {
             descCadastradoProducao = "Cadastrado";
             }
             */
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
%>


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
		<input type="hidden" name="solicitacaoEnvio">
		<input type="hidden" name="solicitacaoEnvioProducao">
		<input type="hidden" name="cadastrado" value="<%= cadastrado %>">
		<input type="hidden" name="cadastradoProducao"
			value="<%= cadastradoProducao %>">

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
					<tr>
						<td class="textoTitulo"><a href="#CedenteParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CEDENTE_ELETRONICO_CIATI%>);"><img
							src="<%=Paths.getImagePath()%>/outlineminus.gif" width="11"
							height="11" name="outlineplus" id="Cedentei"></a> <a
							name="CedenteParent">Cedente Eletrônico</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* CEDENTE ELETRONICO ************************************** -->
						<div class="group">
						<table width="95%" border="0" cellspacing="0" cellpadding="0"
							height=14 valign="middle" align="center">
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="4" class="textoDestaqueTitulo">Guia: Cedente
								Eletrônico</td>
							</tr>
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>
							<%if ("S".equals(cadastradoProducao)) {

                        %>
							<s:Outline name="CedenteProdParent"
								title="Cedente	Eletrônico - Produção"
								imagePath="<%=Paths.getImagePath()%>" type="twist">
								<table width="95%" border="0" cellspacing="0" cellpadding="0"
									height=14 valign="middle" align="center">
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Aplicativo:</td>
										<td class="textoValor" width="26%"><s:ComboTipoAplicativo
											name="aplicativoProducao_view" disabled="true"
											selectedValue="<%= aplicativoProducao %>" /> - <p:InputAlfanumerico
											CLASS="inputtext" name="versaoProducao_view" disabled="true"
											value="<%= versaoProducao %>" size="4" maxlength="5" value="" /></td>
										<input type="hidden" name="aplicativoProducao" value="<%= aplicativoProducao %>"/>
										<input type="hidden" name="versaoProducao" value="<%= versaoProducao %>"/>
										<td class="textoTitulo" width="17%">Tipo de Transmissão:</td>
										<td class="textoValor" width="26%"><s:ComboTipoTransmissao
											name="tipoTransmissaoProducao_view" disabled="true"
											selectedValue="<%= tipoTransmissaoProducao %>" /></td>
										<input type="hidden" name="tipoTransmissaoProducao" value="<%= tipoTransmissaoProducao %>"/>
										<!--onChange="javascript:mudaComboTipoTransmissaoProducao();"-->
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Padrão de Arquivo:</td>
										<td class="textoValor" width="26%"><s:ComboPadraoArquivo
											name="padraoArquivoProducao_view" disabled="true"
											selectedValue="<%= padraoArquivoProducao %>" /></td>
										<input type="hidden" name="padraoArquivoProducao" value="<%= padraoArquivoProducao %>"/>
										<td class="textoTitulo" width="17%">Agrupamento:</td>
										<td class="textoValor" width="26%"><s:ComboTipoAgrupamento
											name="agrupamentoProducao_view" disabled="true"
											selectedValue="<%= agrupamentoProducao %>" branco="true"
											brancoValue="99" /></td>
										<input type="hidden" name="agrupamentoProducao" value="<%= agrupamentoProducao %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Atribuição de VAN:</td>
										<td class="textoValor" width="26%"><s:ComboAtribuicaoVan
											name="atribuicaoVanProducao_view" disabled="true"
											selectedValue="<%= atribuicaoVanProducao %>" /></td>
										<input type="hidden" name="atribuicaoVanProducao" value="<%= atribuicaoVanProducao %>"/>
										<td class="textoTitulo" width="17%">VAN:</td>
										<td class="textoValor" width="26%"><s:ComboVan
											name="vanProducao_view" branco="true" disabled="true"
											selectedValue="<%= vanProducao %>" brancoValue="99" /></td>
										<input type="hidden" name="vanProducao" value="<%= vanProducao %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Junção Arquivo Retorno:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="juncaoArquivoRetornoProducao_view" disabled="true"
											selectedValue="<%= juncaoArquivoRetornoProducao %>"
											onChange="javascript:mudaComboJuncaoArquivoProducao();" /></td>
										<input type="hidden" name="juncaoArquivoRetornoProducao" value="<%= juncaoArquivoRetornoProducao %>"/>
										<td class="textoTitulo" width="17%">Cedente Junção:</td>
										<td width="26%"><p:InputNumerico CLASS="inputtext"
											name="cedenteJuncaoProducao_view" disabled="true"
											value="<%= cedenteJuncaoProducao %>" size="8" maxlength="7"
											onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.perfilRejeicaoProducao);" />
										<input type="hidden" name="cedenteJuncaoProducao" value="<%= cedenteJuncaoProducao %>"/>
										</td>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Perfil Rejeição:</td>
										<td class="textoValor" width="26%"><s:ComboPerfilRejeicao
											name="perfilRejeicaoProducao_view" disabled="true"
											selectedValue="<%= perfilRejeicaoProducao %>" /></td>
										<input type="hidden" name="perfilRejeicaoProducao" value="<%= perfilRejeicaoProducao %>"/>
										<td class="textoTitulo" width="17%">Pré-Crítica:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="preCriticaProducao_view" disabled="true"
											selectedValue="<%= preCriticaProducao %>" /></td>
										<input type="hidden" name="preCriticaProducao" value="<%= preCriticaProducao %>"/>
									</tr>






									<tr>
										<td class="textoTitulo" width="17%">Apelido:</td>
										<td width="26%"><p:InputAlfanumerico CLASS="inputtext"
											name="apelidoProducao_view" disabled="true"
											value="<%= apelidoProducao %>" size="9" maxlength="6" /></td>
										<input type="hidden" name="apelidoProducao" value="<%= apelidoProducao %>"/>
										<td class="textoTitulo" width="17%">Arquivo de Retorno:</td>
										<td width="26%"><p:InputAlfanumerico CLASS="inputtext"
											name="arquivoRetornoProducao_view" disabled="true"
											value="<%= arquivoRetornoProducao %>" size="40"
											maxlength="30" /></td>
										<input type="hidden" name="arquivoRetornoProducao" value="<%= arquivoRetornoProducao %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Cópia Arquivo Retorno:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="copiaArquivoRetornoProducao_view" disabled="true"
											selectedValue="<%= copiaArquivoRetornoProducao %>"
											onChange="javascript:mudaComboCopiaArquivoRetornoProducao();" />
										</td>
										<input type="hidden" name="copiaArquivoRetornoProducao" value="<%= copiaArquivoRetornoProducao %>"/>
										<td class="textoTitulo" width="17%">Caixa Postal:</td>
										<td class="textoValor" width="26%"><p:InputNumerico
											CLASS="inputtext" name="caixaPostalProducao_view" disabled="true"
											value="<%= caixaPostalProducao %>" size="8" maxlength="5"
											onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);" />
										</td>
										<input type="hidden" name="caixaPostalProducao" value="<%= caixaPostalProducao %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Apelido (Cópia):</td>
										<td width="26%"><p:InputAlfanumerico CLASS="inputtext"
											name="apelidoCopiaProducao"
											value="<%= apelidoCopiaProducao %>" size="9" maxlength="6"
											disabled="true" onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);" />
										</td>
										<input type="hidden" name="apelidoCopiaProducao" value="<%= apelidoCopiaProducao %>"/>
										<td class="textoTitulo" width="17%">Arquivo de Retorno
										(Cópia):</td>
										<td width="26%"><p:InputAlfanumerico disabled="true"
											CLASS="inputtext" name="arquivoRetornoCopiaProducao"
											value="<%= arquivoRetornoCopiaProducao %>" size="40"
											maxlength="30" /></td>
										<input type="hidden" name="arquivoRetornoCopiaProducao" value="<%= arquivoRetornoCopiaProducao %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Número Próxima Remessa:</td>
										<td class="textoValor" width="26%"><p:InputNumerico
											disabled="true" CLASS="inputtext"
											name="numeroProximaRemessaProducao"
											value="<%= numeroProximaRemessaProducao %>" size="5"
											maxlength="5" /></td>
										<input type="hidden" name="numeroProximaRemessaProducao" value="<%= numeroProximaRemessaProducao %>"/>
										<td class="textoTitulo" width="17%">Número Último Retorno:</td>
										<td class="textoValor" width="26%"><p:InputNumerico
											disabled="true" CLASS="inputtext"
											name="numeroUltimoRetornoProducao"
											value="<%= numeroUltimoRetornoProducao %>" size="5"
											maxlength="5" /></td>
										<input type="hidden" name="numeroUltimoRetornoProducao" value="<%= numeroUltimoRetornoProducao %>"/>
									</tr>
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>

									<!--                  
		                    <tr>
		                      <td align="right" colspan="4">
		                        <p align="center"> 
		                          <s:Button name="buttonEnviarTeste" value="Enviar p/ Teste" action="javascript:formSubmit_EnviarTeste();" />
		                        </p>
		                      </td>
		                    </tr>
		
		                    <tr> 
		                      <td colspan="4">&nbsp;</td>
		                    </tr>-->
								</table>
							</s:Outline>
							<%}
                    if ((("S".equals(cadastrado)) || (!"S".equals(cadastradoProducao)))
                        && ((!van.equals(vanProducao)) || ("T".equals(cadastrado)))) {

                        %>

							<s:Outline name="CedenteTesteParent"
								title="Cedente Eletrônico - Teste"
								imagePath="<%=Paths.getImagePath()%>" type="twist">
								<table width="95%" border="0" cellspacing="0" cellpadding="0"
									height=14 valign="middle" align="center">
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Aplicativo:</td>
										<td class="textoValor" width="26%"><s:ComboTipoAplicativo
											name="aplicativo_view" selectedValue="<%= aplicativo %>" /> - <p:InputAlfanumerico
											CLASS="inputtext" name="versao_view" value="<%= versao %>"
											size="4" maxlength="5" value="" disabled="true" /></td>
										<input type="hidden" name="aplicativo" value="<%= aplicativo %>"/>
										<input type="hidden" name="versao" value="<%= versao %>"/>
										<td class="textoTitulo" width="17%">Tipo de Transmissão:</td>
										<td class="textoValor" width="26%"><s:ComboTipoTransmissao
											name="tipoTransmissao_view" disabled="true"
											selectedValue="<%= tipoTransmissao %>" /></td>
										<!--onChange="javascript:mudaComboTipoTransmissao();"-->
										<input type="hidden" name="tipoTransmissao" value="<%= tipoTransmissao %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Padrão de Arquivo:</td>
										<td class="textoValor" width="26%"><s:ComboPadraoArquivo
											name="padraoArquivo_view" disabled="true"
											selectedValue="<%= padraoArquivo %>" /></td>
										<input type="hidden" name="padraoArquivo" value="<%= padraoArquivo %>"/>
										<td class="textoTitulo" width="17%">Agrupamento:</td>
										<td class="textoValor" width="26%"><s:ComboTipoAgrupamento
											name="agrupamento_view" disabled="true"
											selectedValue="<%= agrupamento %>" branco="true"
											brancoValue="99" /></td>
										<input type="hidden" name="agrupamento" value="<%= agrupamento %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Atribuição de VAN:</td>
										<td class="textoValor" width="26%"><s:ComboAtribuicaoVan
											name="atribuicaoVan_view" disabled="true"
											selectedValue="<%= atribuicaoVan %>" /></td>
										<input type="hidden" name="atribuicaoVan" value="<%= atribuicaoVan %>"/>
										<td class="textoTitulo" width="17%">VAN:</td>
										<td class="textoValor" width="26%"><s:ComboVan name="van_view"
											disabled="true" branco="true" selectedValue="<%= van %>"
											brancoValue="99" /></td>
										<input type="hidden" name="van" value="<%= van %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Junção Arquivo Retorno:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="juncaoArquivoRetorno_view" disabled="true"
											selectedValue="<%= juncaoArquivoRetorno %>" /></td>
										<input type="hidden" name="juncaoArquivoRetorno" value="<%= juncaoArquivoRetorno %>"/>
										<td class="textoTitulo" width="17%">Cedente Junção:</td>
										<td width="26%"><p:InputNumerico CLASS="inputtext"
											name="cedenteJuncao_view" disabled="true"
											value="<%= cedenteJuncao %>" size="8" maxlength="7"
											onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.perfilRejeicao);" />
										</td>
										<input type="hidden" name="cedenteJuncao" value="<%= cedenteJuncao %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Perfil Rejeição:</td>
										<td class="textoValor" width="26%"><s:ComboPerfilRejeicao
											name="perfilRejeicao_view" disabled="true"
											selectedValue="<%= perfilRejeicao %>" /></td>
										<input type="hidden" name="perfilRejeicao" value="<%= perfilRejeicao %>"/>
										<td class="textoTitulo" width="17%">Pré-Crítica:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="preCritica_view" disabled="true"
											selectedValue="<%= preCritica %>" /></td>
										<input type="hidden" name="preCritica" value="<%= preCritica %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Apelido:</td>
										<td width="26%" nowrap><p:InputAlfanumerico CLASS="inputtext"
											name="apelido" value="<%= apelido %>" size="9" maxlength="6"
											disabled="true" /></td>
										<input type="hidden" name="apelido" value="<%= apelido %>"/>
										<td class="textoTitulo" width="17%">Arquivo de Retorno:</td>
										<td width="26%" nowrap><p:InputAlfanumerico CLASS="inputtext"
											name="arquivoRetorno_view" value="<%= arquivoRetorno %>" size="40"
											maxlength="30" disabled="true" /></td>
										<input type="hidden" name="arquivoRetorno" value="<%= arquivoRetorno %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Cópia Arquivo Retorno:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="copiaArquivoRetorno_view" disabled="true"
											selectedValue="<%= copiaArquivoRetorno %>" /></td>
										<input type="hidden" name="copiaArquivoRetorno" value="<%= copiaArquivoRetorno %>"/>
										<td class="textoTitulo" width="17%">Caixa Postal:</td>
										<td class="textoValor" width="26%"><p:InputNumerico
											CLASS="inputtext" name="caixaPostal_view" disabled="true"
											value="<%= caixaPostal %>" size="8" maxlength="5"
											onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);" />
										</td>
										<input type="hidden" name="caixaPostal" value="<%= caixaPostal %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Apelido (Cópia):</td>
										<td width="26%"><p:InputAlfanumerico CLASS="inputtext"
											name="apelidoCopia_view" value="<%= apelidoCopia %>" size="9"
											maxlength="6" disabled="true"
											onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);" />
										</td>
										<input type="hidden" name="apelidoCopia" value="<%= apelidoCopia %>"/>
										<td class="textoTitulo" width="17%">Arquivo de Retorno
										(Cópia):</td>
										<td width="26%"><p:InputAlfanumerico CLASS="inputtext"
											name="arquivoRetornoCopia_view" value="<%= arquivoRetornoCopia %>"
											size="40" maxlength="30" disabled="true" /></td>
										<input type="hidden" name="arquivoRetornoCopia" value="<%= arquivoRetornoCopia %>"/>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Número Próxima Remessa:</td>
										<td class="textoValor" width="26%"><p:InputNumerico
											disabled="true" CLASS="inputtext" name="numeroProximaRemessa_view"
											value="<%= numeroProximaRemessa %>" size="5" maxlength="5" />
										<input type="hidden" name="numeroProximaRemessa" value="<%= numeroProximaRemessa %>"/>
										</td>
										<td class="textoTitulo" width="17%">Número Último Retorno:</td>
										<td class="textoValor" width="26%"><p:InputNumerico
											disabled="true" CLASS="inputtext" name="numeroUltimoRetorno_view"
											value="<%= numeroUltimoRetorno %>" size="5" maxlength="5" />
										<input type="hidden" name="numeroUltimoRetorno" value="<%= numeroUltimoRetorno %>"/>
										</td>
									</tr>
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>

									<tr>
										<td align="right" colspan="4">
										<p align="center"><s:Button name="buttonEnviarProd"
											value="Enviar p/ Produção"
											action="javascript:formSubmit_EnviarProducao();"
											userGroup="<%=usuarioBean.getNomeGrupo()%>"
											internalAction="cedente.cadastro.manter.enviarProducao" /></p>
										</td>
									</tr>
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
								</table>
							</s:Outline>
							<%} else {%>
							<script>
							  document.frmMain.cadastrado.value = 'N';
							</script>
							<%}%>
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>
							<tr>
								<td align="right" colspan="4">
								<p align="center"><s:Button name="Confirmar"
									action="javascript:formSubmit_Cedente();"
									userGroup="<%=usuarioBean.getNomeGrupo()%>"
									internalAction="cedente.cadastro.manter.alterar" /> <s:Button
									name="Cancelar" action="javascript:fecharGuias()"
									userGroup="<%=usuarioBean.getNomeGrupo()%>"
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
						</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td align="right" colspan="4">
						<p align="center"><s:Button name="Voltar_Principal" value="Voltar"
							action="javascript:formSubmit_Voltar();" /> <s:Button
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
	    function inicia() {
	    	if (document.frmMain.cadastrado.value == "S") {
		    	iniciaTeste();
		    }
	    	
	    	if (document.frmMain.cadastradoProducao.value == "S") {
		    	iniciaProducao();
		    }
		    <%//EAM - 20/05%>
		    if (document.frmMain.cadastrado.value == "N" && 
		    		document.frmMain.cadastradoProducao.value == "N"){
		    		iniciaTeste();
		    }
			<%
				// caso retornou da estrategia com criticas
				if (!descCriticas.equals("")) {
			%>
				abreOutlineProducao();
				abreOutlineTeste();
				alert("<%= descCriticas %>");
			<%
				}
			%>
			desabilitaCampos();
	    }

	    function iniciaTeste() {
	    	//if (document.frmMain.cadastrado.value != 'S') {
	    	//	desabilitarOutlineTeste();
	    	//} else {
		    	//mudaComboTipoTransmissao();
		    	//mudaComboJuncaoArquivo();
		    	//mudaComboCopiaArquivoRetorno();
	    	//}
	    }

	    function iniciaProducao() {
	    	mudaComboTipoTransmissaoProducao();
	    	mudaComboJuncaoArquivoProducao();
	    	mudaComboCopiaArquivoRetornoProducao();
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
	    	formSubmit_Cedente();
	    }

	    function formSubmit_Cedente() {
	    	if (!validaSubmit_Eletron()) {
	    		return;
	    	}
	    	if (!validaSubmit_EletronProducao()) {
	    		return;
	    	}

	  		var confirma = confirm(conf("127"));
 	    	if (confirma) {
 	    		if (mudouCamposProducao()) {
 	    			document.frmMain.solicitacaoEnvioProducao.value = "S";
 	    		} else {
 	    			document.frmMain.solicitacaoEnvioProducao.value = "N";
 	    		}
    	  		document.frmMain.estrategia.value="cedente.CedenteAlterarGuiaEletronFinalizar";
		    	//habilitaCampos();
		    	document.frmMain.submit();
		    }
	    }

	    function validaSubmit_Eletron() {
	    	// se nao existe a guia de cedente teste nao precisa validar
	    	if (document.frmMain.van == null) {
	    		return true;
	    	}

	    	if (document.frmMain.tipoTransmissao.value == 1) { // 1 - EDI/VAN
	    		if (!validaComboObrigatorio(document.frmMain.van, 'VAN', 99, true)) {
	    			abreOutlineTeste();
	    			msgEletron('001', document.frmMain.van, 'VAN');
	    			return false;
	    		}
	    	}

	    	if (document.frmMain.juncaoArquivoRetorno.value == "S") {
	    		if (!validaCampoObrigatorio(document.frmMain.cedenteJuncao, 'Cedente Junção', true)) {
	    			abreOutlineTeste();
	    			msgEletron('001', document.frmMain.cedenteJuncao, 'Cedente Junção');
	    			return false;
	    		}
	    		if (!validaMenorIgual(document.frmMain.cedenteJuncao, 'Cedente Junção', 0, true)) {
	    			abreOutlineTeste();
	    			msgEletron('006', document.frmMain.cedenteJuncao, 'Cedente Junção', 0);
	    			return false;
	    		}
	    		if (document.frmMain.cedenteJuncao.value == "<%= codigoCedente %>") {
	    			abreOutlineTeste();
	    			msgEletron('051', document.frmMain.cedenteJuncao);
	    			return false;
	    		}
	    	}
        <%//EAM2607 - Retirada a validação de apelido copia.
	    	//if (document.frmMain.copiaArquivoRetorno.value == "S") {
	    	//	if (!validaCampoObrigatorio(document.frmMain.apelidoCopia, 'Apelido (Cópia)', true)) {
	    	//		abreOutlineTeste();
	    	//		msgEletron('001', document.frmMain.apelidoCopia, 'Apelido (Cópia)');
	    	//		return false;
	    	//	}
	    	//}%>

	    	return true;
	    }

	    function validaSubmit_EletronProducao() {
	    	// se nao existe a guia de cedente producao nao precisa validar
	    	if (document.frmMain.vanProducao == null) {
	    		return true;
	    	}

	    	if (document.frmMain.tipoTransmissaoProducao.value == 1) { // 1 - EDI/VAN
	    		if (!validaComboObrigatorio(document.frmMain.vanProducao, 'VAN', 99, true)) {
	    			abreOutlineProducao();
	    			msgEletron('001', document.frmMain.vanProducao, 'VAN');
	    			return false;
	    		}
	    	}

	    	if (document.frmMain.juncaoArquivoRetornoProducao.value == "S") {
	    		if (!validaCampoObrigatorio(document.frmMain.cedenteJuncaoProducao, 'Cedente Junção', true)) {
	    			abreOutlineProducao();
	    			msgEletron('001', document.frmMain.cedenteJuncaoProducao, 'Cedente Junção');
	    			return false;
	    		}
	    		if (!validaMenorIgual(document.frmMain.cedenteJuncaoProducao, 'Cedente Junção', 0, true)) {
	    			abreOutlineProducao();
	    			msgEletron('006', document.frmMain.cedenteJuncaoProducao, 'Cedente Junção', 0);
	    			return false;
	    		}
	    		if (document.frmMain.cedenteJuncaoProducao.value == "<%= codigoCedente %>") {
	    			abreOutlineProducao();
	    			msgEletron('051', document.frmMain.cedenteJuncaoProducao);
	    			return false;
	    		}
	    	}
        <%//EAM2607 - Retirada a validação de apelido copia.
	    	//if (document.frmMain.copiaArquivoRetornoProducao.value == "S") {
	    	//	if (!validaCampoObrigatorio(document.frmMain.apelidoCopiaProducao, 'Apelido (Cópia)', true)) {
	    	//		abreOutlineProducao();
	    	//		msgEletron('001', document.frmMain.apelidoCopiaProducao, 'Apelido (Cópia)');
	    	//		return false;
	    	//	}
	    	//}%>
	    	return true;
	    }

		function mudouCamposProducao() {
			if (document.frmMain.vanProducao == null) {
				return false;
			}
			if (document.frmMain.vanProducao.value != '<%= vanProducao %>') {
				return true;
			}
			if (document.frmMain.aplicativoProducao.value != '<%= aplicativoProducao %>') {
				return true;
			}
			if (document.frmMain.tipoTransmissaoProducao.value != '<%= tipoTransmissaoProducao %>') {
				return true;
			}
			return false;
		}

	    // Teste nao pode ter VAN igual
	    function validaComparacaoTesteProducao() {
	    	if (document.frmMain.cadastrado.value == "S" &&
	    			document.frmMain.cadastradoProducao.value == "S") {
		    	if (document.frmMain.van.value == document.frmMain.vanProducao.value) {
		    		msg("048");
		    		return false;
		    	}
		    }
	    	return true;
	    }

	    function mudaComboTipoTransmissao() {
	    	if (document.frmMain.tipoTransmissao.value == "1") { // 1 - EDI/VAN
	    		document.frmMain.van.disabled = false;
	    	} else {
	    		document.frmMain.van.value = 99;
	    		document.frmMain.van.disabled = true;
	    	}
	    }

	    function mudaComboTipoTransmissaoProducao() {
	    	if (document.frmMain.tipoTransmissaoProducao.value == "1") { // 1 - EDI/VAN
	    		document.frmMain.vanProducao.disabled = false;
	    	} else {
	    		document.frmMain.vanProducao.value = 99;
	    		document.frmMain.vanProducao.disabled = true;
	    	}
	    }

	    function mudaComboJuncaoArquivo() {
	    	if (document.frmMain.juncaoArquivoRetorno.value == "S") {
	    		document.frmMain.cedenteJuncao.disabled = false;
	    		<%//EAM0508%>
	    		document.frmMain.copiaArquivoRetorno.value = "N";
	    		document.frmMain.copiaArquivoRetorno.disabled = true;
	    		//mudaComboCopiaArquivoRetorno();
	    	} else {
	    		document.frmMain.cedenteJuncao.value = '';
	    		document.frmMain.cedenteJuncao.disabled = true;
	    		<%//EAM0508%>
	    		document.frmMain.copiaArquivoRetorno.disabled = false;
	    		//mudaComboCopiaArquivoRetorno();
	    	}
	    }

	    function mudaComboJuncaoArquivoProducao() {
	    	if (document.frmMain.juncaoArquivoRetornoProducao.value == "S") {
	    		document.frmMain.cedenteJuncaoProducao.disabled = false;
	    		<%//EAM0508%>
	    		document.frmMain.copiaArquivoRetornoProducao.value = "N";
	    		document.frmMain.copiaArquivoRetornoProducao.disabled = true;	
	    		mudaComboCopiaArquivoRetornoProducao();
	    	} else {
	    		document.frmMain.cedenteJuncaoProducao.value = '';
	    		document.frmMain.cedenteJuncaoProducao.disabled = true;
	    		<%//EAM0508%>
	    		document.frmMain.copiaArquivoRetornoProducao.disabled = false;	    		
	    		mudaComboCopiaArquivoRetornoProducao();
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
	    		<%//EAM2607 - document.frmMain.apelidoCopia.disabled = true;%>
	    		document.frmMain.arquivoRetornoCopia.value = '';
	    		// document.frmMain.arquivoRetornoCopia.disabled = true;
	    		<%//EAM1508	    		%>
	    		document.frmMain.caixaPostal.disabled = false;	    		    		
	    	}
	    }

	    function mudaComboCopiaArquivoRetornoProducao() {
	    	if (document.frmMain.copiaArquivoRetornoProducao.value == "S") {
	    		<%//EAM2607 - document.frmMain.apelidoCopiaProducao.disabled = false;
	    		// document.frmMain.arquivoRetornoCopiaProducao.disabled = false;
	    		//EAM1508%>
	    		document.frmMain.caixaPostalProducao.disabled = true;
	    		document.frmMain.caixaPostalProducao.value = '';
	    	} else {
	    		document.frmMain.apelidoCopiaProducao.value = '';
	    		<%//EAM2607 - document.frmMain.apelidoCopiaProducao.disabled = true;%>

	    		document.frmMain.arquivoRetornoCopiaProducao.value = '';
	    		// document.frmMain.arquivoRetornoCopiaProducao.disabled = true;

	    		<%//EAM1508	%>
	    		document.frmMain.caixaPostalProducao.disabled = false;	    	
	    	}
	    }

		function habilitaCampos() {
			for (var i = 0; i < document.frmMain.elements.length; i++) {
				document.frmMain.elements[i].disabled = false;
			}
		}

		function formSubmit_EnviarTeste() {
			habilitarOutlines();
			copiaProducaoParaTeste();
			document.frmMain.buttonEnviarProd.disabled = true;
		}

		function formSubmit_EnviarProducao() {
			if (!validaSubmit_Eletron()) {
    			return;
			}

	    	if (!validaSubmit_EletronProducao()) {
	    		return;
	    	}

	  		var confirma = confirm(conf("158"));
		    	if (confirma) {
					document.frmMain.solicitacaoEnvio.value = "S";
					document.frmMain.solicitacaoEnvioProducao.value = "N";
		   	  		document.frmMain.estrategia.value="cedente.CedenteAlterarGuiaEletronFinalizar";
			    	//habilitaCampos();
			    	document.frmMain.submit();
		    }
		}

		function copiaProducaoParaTeste() {
			for (var i = 0; i < document.frmMain.elements.length; i++) {
				var objProducao = document.frmMain.elements[i];
				var indiceStrProducao = objProducao.name.search('Producao');
				if (indiceStrProducao != -1) {
					var nameTeste = objProducao.name.substring(0, indiceStrProducao);
					//alert(nameTeste);
					var objTeste = eval('document.frmMain.' + nameTeste);
					objTeste.value = objProducao.value;
				}
			}
		}

		function copiaTesteParaProducao() {
			for (var i = 0; i < document.frmMain.elements.length; i++) {
				var objProducao = document.frmMain.elements[i];
				var indiceStrProducao = objProducao.name.search('Producao');
				if (indiceStrProducao != -1) {
					var nameTeste = objProducao.name.substring(0, indiceStrProducao);
					//alert(nameTeste);
					var objTeste = eval('document.frmMain.' + nameTeste);
					objProducao.value = objTeste.value;
				}
			}
		}

		function desabilitaCamposProducao() {
			for (var i = 0; i < document.frmMain.elements.length; i++) {
				var objProducao = document.frmMain.elements[i];
				var indiceStrProducao = objProducao.name.search('Producao');
				if (indiceStrProducao != -1) {
					objProducao.disabled = true;
				}
			}
		}

		function abreOutlineTeste() {
			if (!isOutlineTesteOpen()) {
   			var whichEl = document.getElementById('CedenteTesteParentChild');
				whichEl.style.display = 'block';
				var imgElement = document.getElementById('CedenteTesteParenti');
				imgElement.src = getImageTwistDown();	//twist

				//olType = 'twist';
				//switchIt('CedenteTesteParent');
				//olType = 'outline';
			}
		}

		function abreOutlineProducao() {
    		if (!isOutlineProducaoOpen()) {
    			var whichEl = document.getElementById('CedenteProdParentChild');
					whichEl.style.display = 'block';
					var imgElement = document.getElementById('CedenteProdParenti');
					imgElement.src = getImageTwistDown();	//twist

					//olType = 'twist';
					//switchIt('CedenteProdParent');
					//olType = 'outline';
			}
		}

		function desabilitarOutlineTeste() {
			//olDisabledOutline = 'CedenteTesteParent';
			disableOutline('CedenteTesteParent');
		}

		function desabilitarOutlineProducao() {
			//olDisabledOutline = 'CedenteProdParent';
			disableOutline('CedenteProdParent');
		}

		function habilitarOutlines() {
			//olDisabledOutline = '';
			enableOutline('CedenteProdParent');
			enableOutline('CedenteTesteParent');
		}

		function isOutlineTesteOpen() {
	    	// se nao existe a guia retorna
	    	if (document.frmMain.van == null) {
	    		return true;
	    	}

			if (getState('CedenteTesteParent') == 'none') {
				return false;
			} else {
				return true;
			}
		}

		function isOutlineProducaoOpen() {
	    	// se nao existe a guia retorna
	    	if (document.frmMain.vanProducao == null) {
	    		return true;
	    	}

			if (getState('CedenteProdParent') == 'none') {
				return false;
			} else {
				return true;
			}
		}

		function msgEletron(codigoMsg, campo, nome, valor1) {
			msg(codigoMsg, nome, valor1);
			if(!campo.disabled) {
				try{
					campo.focus();
					campo.select();
				}catch(exp){}
			}
		}
		// alterar para caso aparece os dois ! tem que desabilitar mesmo assim 
		function desabilitaCampos() {
			if (document.frmMain.cadastradoProducao.value == "S" 
				&& document.frmMain.cadastrado.value == "S") {
			
				document.frmMain.aplicativoProducao_view.disabled = true;
				document.frmMain.tipoTransmissaoProducao_view.disabled = true;
				document.frmMain.padraoArquivoProducao_view.disabled = true;
				document.frmMain.agrupamentoProducao_view.disabled = true;
				document.frmMain.atribuicaoVanProducao_view.disabled = true;
				document.frmMain.vanProducao_view.disabled = true;
				document.frmMain.juncaoArquivoRetornoProducao_view.disabled = true;
				document.frmMain.perfilRejeicaoProducao_view.disabled = true;
				document.frmMain.preCriticaProducao_view.disabled = true;
				document.frmMain.copiaArquivoRetornoProducao_view.disabled = true;
				document.frmMain.caixaPostalProducao_view.disabled = true;
				document.frmMain.aplicativo_view.disabled = true;
				document.frmMain.tipoTransmissao_view.disabled = true;
				document.frmMain.padraoArquivo_view.disabled = true;
				document.frmMain.agrupamento_view.disabled = true;
				document.frmMain.atribuicaoVan_view.disabled = true;
				document.frmMain.van_view.disabled = true;
				document.frmMain.juncaoArquivoRetorno_view.disabled = true;
				document.frmMain.perfilRejeicao_view.disabled = true;
				document.frmMain.preCritica_view.disabled = true;
				document.frmMain.copiaArquivoRetorno_view.disabled = true;
				document.frmMain.caixaPostal_view.disabled = true;
			} else if(document.frmMain.cadastradoProducao.value == "S") {
				document.frmMain.aplicativoProducao_view.disabled = true;
				document.frmMain.tipoTransmissaoProducao_view.disabled = true;
				document.frmMain.padraoArquivoProducao_view.disabled = true;
				document.frmMain.agrupamentoProducao_view.disabled = true;
				document.frmMain.atribuicaoVanProducao_view.disabled = true;
				document.frmMain.vanProducao_view.disabled = true;
				document.frmMain.juncaoArquivoRetornoProducao_view.disabled = true;
				document.frmMain.perfilRejeicaoProducao_view.disabled = true;
				document.frmMain.preCriticaProducao_view.disabled = true;
				document.frmMain.copiaArquivoRetornoProducao_view.disabled = true;
				document.frmMain.caixaPostalProducao_view.disabled = true;
			} else {
				document.frmMain.aplicativo_view.disabled = true;
				document.frmMain.tipoTransmissao_view.disabled = true;
				document.frmMain.padraoArquivo_view.disabled = true;
				document.frmMain.agrupamento_view.disabled = true;
				document.frmMain.atribuicaoVan_view.disabled = true;
				document.frmMain.van_view.disabled = true;
				document.frmMain.juncaoArquivoRetorno_view.disabled = true;
				document.frmMain.perfilRejeicao_view.disabled = true;
				document.frmMain.preCritica_view.disabled = true;
				document.frmMain.copiaArquivoRetorno_view.disabled = true;
				document.frmMain.caixaPostal_view.disabled = true;
			}
	    }

    </script>

	</s:FormStrategy>
</p:Document>
</html>
