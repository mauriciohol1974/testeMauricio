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

<%
            String descCriticas = "";
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

<%
                    CedenteEletronicoBean testeBean = (request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN) == null
                    ? new CedenteEletronicoBean()
                    : (CedenteEletronicoBean) request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN));

            // Inicializando valores dos campos
            String juncaoArquivoRetorno = Util.toStr(
                    testeBean.getJuncaoArquivoRetorno(),
                    "N");
            String preCritica = Util.toStr(testeBean.getPreCritica(), "S");
            String copiaArquivoRetorno = Util.toStr(
                    testeBean.getCopiaArquivoRetorno(),
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
            String numeroProximaRemessa = Util.toStr(
                    testeBean.getNumeroProximaRemessa(),
                    "1"); // Padrao 1
            String numeroUltimoRetorno = Util.toStr(
                    testeBean.getNumeroUltimoRetorno(),
                    "0"); // EAM - 14/10/05 Novo Padrao 0
            String padraoArquivo = Util.toStr(testeBean.getPadraoArquivo(), "1"); // Padrao 1 - CNAB 240
            String perfilRejeicao = Util.toStr(
                    testeBean.getPerfilRejeicao(),
                    "1"); // Padrao 1 - Total
            String tipoTransmissao = Util.toStr(
                    testeBean.getTipoTransmissao(),
                    "1"); // Padrao 1 - EDI/VAN
            String van = Util.toStr(testeBean.getVan(), "99"); // Padrao 99 - Brancos
            
            String connect = Util.toStr(testeBean.getCodConnect(), "99"); // Padrao 99 - Brancos
            
            String versao = Util.toStr(testeBean.getVersao());
            
            String dataEnvioReenvio = Util.toStr(testeBean.getDataEnvioReenvio());
            
            
        	String cmbInternetTeste			= Util.toStr(testeBean.getCodInternet(),"99");
        	String retOnlineTeste			= Util.toStr(testeBean.getRetOnline(),"N");
        	String remOnlineTeste			= Util.toStr(testeBean.getRemOnline(),"N");
        	String numUltRetOnlineTeste      = Util.toStr(testeBean.getNumUltRetOnline(),"0");
            
        	String webserviceTeste			= Util.toStr(testeBean.getWebservice(),"N");

            String cadastrado = testeBean.getCadastrado() != null
                    ? testeBean.getCadastrado()
                    : "";
            //	String descCadastrado = "Cedente	Eletrônico - Teste: Não Cadastrado";
            //	if ("S".equals(cadastrado)) {
            //		descCadastrado = "Cedente	Eletrônico - Teste: Cadastrado";
            //	}
%>

<%
                    CedenteEletronicoBean producaoBean = (request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_PRODUCAO_BEAN) == null
                    ? new CedenteEletronicoBean()
                    : (CedenteEletronicoBean) request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_PRODUCAO_BEAN));

            // Inicializando valores dos campos
            String juncaoArquivoRetornoProducao = Util.toStr(
                    producaoBean.getJuncaoArquivoRetorno(),
                    "N");
            String preCriticaProducao = Util.toStr(
                    producaoBean.getPreCritica(),
                    "S");
            String copiaArquivoRetornoProducao = Util.toStr(
                    producaoBean.getCopiaArquivoRetorno(),
                    "N");
            String agrupamentoProducao = Util.toStr(
                    producaoBean.getAgrupamento(),
                    "99"); // Padrao 99 - Brancos
            String apelidoProducao = Util.toStr(producaoBean.getApelido());
            String apelidoCopiaProducao = Util.toStr(producaoBean.getApelidoCopia());
            String aplicativoProducao = Util.toStr(
                    producaoBean.getAplicativo(),
                    "1"); // Padrao 1- Caixa
            String arquivoRetornoProducao = Util.toStr(producaoBean.getArquivoRetorno());
            String arquivoRetornoCopiaProducao = Util.toStr(producaoBean.getArquivoRetornoCopia());
            String atribuicaoVanProducao = Util.toStr(
                    producaoBean.getAtribuicaoVan(),
                    "1"); // Padrao 1 - Cedente
            String caixaPostalProducao = Util.toStr(producaoBean.getCaixaPostal());
            String cedenteJuncaoProducao = Util.toStr(producaoBean.getCedenteJuncao());
            String numeroProximaRemessaProducao = Util.toStr(
                    producaoBean.getNumeroProximaRemessa(),
                    "1"); // Padrao 1
            String numeroUltimoRetornoProducao = Util.toStr(
                    producaoBean.getNumeroUltimoRetorno(),
                    "0"); // EAM - 14/10/05 Novo Padrao 0
            String padraoArquivoProducao = Util.toStr(
                    producaoBean.getPadraoArquivo(),
                    "1"); // Padrao 1 - CNAB 240
            String padraoArqTeste = padraoArquivoProducao;
            String perfilRejeicaoProducao = Util.toStr(
                    producaoBean.getPerfilRejeicao(),
                    "1"); // Padrao 1 - Total
            String tipoTransmissaoProducao = Util.toStr(
                    producaoBean.getTipoTransmissao(),
                    "1"); // Padrao 1 - EDI/VAN
            String vanProducao = Util.toStr(producaoBean.getVan(), "99"); // Padrao 99 - Brancos
           
            String vanConnectProducao = Util.toStr(producaoBean.getCodConnect(), "99"); // Padrao 99 - Brancos
            
            String versaoProducao = Util.toStr(producaoBean.getVersao());
            
            String dataEnvioReenvioProducao = Util.toStr(producaoBean.getDataEnvioReenvio());
            
            
        	String cmbInternet			= Util.toStr(producaoBean.getCodInternet(),"99");
        	String retOnline			= Util.toStr(producaoBean.getRetOnline(),"N");
        	String remOnline			= Util.toStr(producaoBean.getRemOnline(),"N");
        	String numUltRetOnline      = Util.toStr(producaoBean.getNumUltRetOnline(),"0");
        	String webserviceProducao   = Util.toStr(producaoBean.getWebservice(),"N");
        	
        	
        	
        	
            
           

            String cadastradoProducao = producaoBean.getCadastrado() != null
                    ? producaoBean.getCadastrado()
                    : "";
            //	String descCadastradoProducao = "Não Cadastrado";
            //	if ("S".equals(cadastradoProducao)) {
            //		descCadastradoProducao = "Cadastrado";
            //	}
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
            
            String tipoUser = usuarioBean.getNomeGrupo();
            

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
		<input type="hidden" name="padraoArqTeste" value="<%= padraoArqTeste %>">
		<input type="hidden" name="padraoArqPro" value="<%= padraoArquivoProducao %>">
		<input type="hidden" name="usuarioTeste" value="<%= usuarioBean.getNomeGrupo() %>">


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

					<tr>
						<td class="textoTitulo"><a href="#CedenteParent"
							onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CEDENTE_ELETRONICO%>);"><img
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

							<%
							if ("S".equals(cadastradoProducao)) {
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
											name="aplicativoProducao"
											selectedValue="<%= aplicativoProducao %>"  />
										- <p:InputAlfanumerico CLASS="inputtext" name="versaoProducao"
											value="<%= versaoProducao %>" size="4" maxlength="5" value=""
											 /></td>
											
										<%
										if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
										%>
										<td class="textoTitulo" width="17%">Tipo de Transmissão:
										</td>
										<td class="textoValor" width="26%"><s:ComboTipoTransmissao
											name="tipoTransmissaoProducao" disabled="true"
											selectedValue="<%= tipoTransmissaoProducao %>"
											onChange="javascript:mudaComboTipoTransmissaoProducao();"
											disabled="false" /></td>	
										<%
										}else{
										%>
										<td class="textoTitulo" width="17%">Tipo de Transmissão:
										</td>
										<td class="textoValor" width="26%"><s:ComboTipoTransmissao
											name="tipoTransmissaoProducao" disabled="true"
											selectedValue="<%= tipoTransmissaoProducao %>"
											onChange="javascript:mudaComboTipoTransmissaoProducaoPV();"
											disabled="false" /></td>
										<%	
										}
										%>
										
										</tr>

									<tr>
										<td class="textoTitulo" width="17%">Padrão de Arquivo:</td>
										<td class="textoValor" width="26%"><s:ComboPadraoArquivo
											name="padraoArquivoProducao"
											onChange="javascript:mudaPadraoArquivoProducao();"
											selectedValue="<%= padraoArquivoProducao %>" /></td>
										<td class="textoTitulo" width="17%">Agrupamento:</td>
										<td class="textoValor" width="26%"><s:ComboTipoAgrupamento
											name="agrupamentoProducao"
											selectedValue="<%= agrupamentoProducao %>" branco="true"
											brancoValue="99" /></td>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Atribuição de VAN:</td>
										<td class="textoValor" width="26%"><s:ComboAtribuicaoVan
											name="atribuicaoVanProducao"
											onChange="javascript:mudaVanProducao()" 
											selectedValue="<%= atribuicaoVanProducao %>" disabled="false" />
										</td>
										<td class="textoTitulo" width="17%">VAN:</td>
										<td class="comboVan" width="26%"><s:ComboVan
											name="vanProducao" branco="true"
											selectedValue="<%= vanProducao %>" brancoValue="99"
											disabled="false" /></td>
									</tr>

									<tr>
									
										<td class="textoTitulo" width="17%"></td>
										<td class="textoValor" width="26%"></td>
										<td class="textoTitulo" width="17%">Connect:</td>
										<td class="textoValor" width="26%"><s:ComboConnect
											name="codConnectProducao" branco="true"
											selectedValue="<%= vanConnectProducao %>" brancoValue="99"	/>
										</td>
									
									</tr>
									

									
									<tr>
									
										<td class="textoTitulo" width="17%"></td>
										<td class="textoValor" width="26%"></td>
									
										<td class="textoTitulo" width="17%">Internet</td>
										<td class="textoValor" width="26%"><s:ComboInternet
											name="codInternetProducao" branco="true"
											selectedValue="<%= cmbInternet %>" brancoValue="99"	/>
										</td>
									</tr>									
									
									<tr>
										<td class="textoTitulo" width="17%">Junção Arquivo
										Retorno:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="juncaoArquivoRetornoProducao"
											selectedValue="<%= juncaoArquivoRetornoProducao %>"
											onChange="javascript:mudaComboJuncaoArquivoProducao();" /></td>
										<td class="textoTitulo" width="17%">Cedente Junção:</td>
										<td width="26%" nowrap><p:InputNumerico CLASS="inputtext"
											name="cedenteJuncaoProducao"
											value="<%= cedenteJuncaoProducao %>" size="8" maxlength="7"
											onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.perfilRejeicaoProducao);" />
										</td>
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Perfil Rejeição:</td>
										<td class="textoValor" width="26%"><s:ComboPerfilRejeicao
											name="perfilRejeicaoProducao"
											selectedValue="<%= perfilRejeicaoProducao %>" /></td>
										<td class="textoTitulo" width="17%">Pré-Crítica:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="preCriticaProducao"
											selectedValue="<%= preCriticaProducao %>" /></td>
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Apelido:</td>
										<td width="26%" nowrap><p:InputAlfanumerico
											CLASS="inputtext" name="apelidoProducao"
											value="<%= apelidoProducao %>" size="9" maxlength="6"
											disabled="true" /></td>
										<td class="textoTitulo" width="17%">Arquivo de Retorno:</td>
										<td width="26%" nowrap><p:InputAlfanumerico
											CLASS="inputtext" name="arquivoRetornoProducao"
											value="<%= arquivoRetornoProducao %>" size="40"
											maxlength="30" disabled="true" /></td>
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Cópia Arquivo
										Retorno:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="copiaArquivoRetornoProducao"
											selectedValue="<%= copiaArquivoRetornoProducao %>"
											onChange="javascript:mudaComboCopiaArquivoRetornoProducao();" />
										</td>
										<td class="textoTitulo" width="17%">Caixa Postal:</td>
										<td class="textoValor" width="26%"><p:InputNumerico
											CLASS="inputtext" name="caixaPostalProducao"
											value="<%= caixaPostalProducao %>" size="8" maxlength="5"
											onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);" />
										</td>
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Apelido (Cópia):</td>
										<td width="26%" nowrap><p:InputAlfanumerico
											CLASS="inputtext" name="apelidoCopiaProducao"
											value="<%= apelidoCopiaProducao %>" size="9" maxlength="6"
											disabled="true" onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);" />
										</td>
										<td class="textoTitulo" width="17%">Arquivo de Retorno
										(Cópia):</td>
										<td width="26%" nowrap><p:InputAlfanumerico
											CLASS="inputtext" name="arquivoRetornoCopiaProducao"
											value="<%= arquivoRetornoCopiaProducao %>" size="40"
											maxlength="30" disabled="true" /></td>
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Número Próxima
										Remessa:</td>
										<td class="textoValor" width="26%"><s:InputNumericoSigcb
											CLASS="inputtext"
											name="numeroProximaRemessaProducao"
											value="<%= numeroProximaRemessaProducao %>" 
											size="5"
											maxlength="5"
											userGroup="<%=usuarioBean.getNomeGrupo()%>"
											internalAction="cedente.cadastro.manter.editar" /></td>
										<td class="textoTitulo" width="17%">Número Último
										Retorno:</td>
										<td class="textoValor" width="26%"><s:InputNumericoSigcb
											CLASS="inputtext"
											name="numeroUltimoRetornoProducao"
											value="<%= numeroUltimoRetornoProducao %>" 
											size="5"
											maxlength="5"
											userGroup="<%=usuarioBean.getNomeGrupo()%>"
											internalAction="cedente.cadastro.manter.editar" /></td>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Data Envio/Reenvio Carga Inicial:</td>
										<td class="textoValor" width="26%"><%=dataEnvioReenvioProducao%>
										</td>
										
									</tr>
									
									<tr>
										<td class="textoTitulo" width="17%">Retorno On Line:</td>
										<%
										if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
										%>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="retOnlineProducao" disabled="false"
											selectedValue="<%= retOnline %>" onChange="javascript:mudaComboInternetProducao();"/>
										 </td>	
										<%
										}else{
										%>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="retOnlineProducao" disabled="true"
											selectedValue="<%= retOnline %>" />
										 </td>	
										<%	
										}
										%>
										</td>
										<td class="textoTitulo" width="17%">Num. Ult. Retorno On line</td>
										<%
										if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")) {
										%>
										<td class="textoValor" width="26%"><p:InputNumerico
											CLASS="inputtext" name="numUltRetOnlineProducao" disabled="False"
											value="<%= numUltRetOnline %>" size="8" maxlength="5"
											onFocus="javascript: prevFocus(this);"
											 />
										</td>	
										<%
										}else{
										%>
										<td class="textoValor" width="26%"><p:InputNumerico
											CLASS="inputtext" name="numUltRetOnlineProducao" disabled="true"
											value="<%= numUltRetOnline %>" size="8" maxlength="5"
											onFocus="javascript: prevFocus(this);"
											/>
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
												name="remOnlineProducao" disabled="false"
												selectedValue="<%= remOnline %>"/>
								 				</td>	
										<%
										}else{
										%>
											
												<td class="textoValor" width="26%"><s:ComboSimNao
												name="remOnlineProducao" disabled="true"
												selectedValue="<%= remOnline %>" />
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
											name="webserviceProducao" disabled="false"
											selectedValue="<%= webserviceProducao %>"/>
										 </td>	
										<%
										}else{
										%>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="webserviceProducao" disabled="true"
											selectedValue="<%= webserviceProducao %>" />
										 </td>	
										<%	
										}
										%>
										</td>
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
		                    </tr>
-->

								</table>
							</s:Outline>
							<%
							                    }
											   // MAH - STEFANINI - CONNECT
							                   // if ((("S".equals(cadastrado)) || (!"S".equals(cadastradoProducao))) && ((!van.equals(vanProducao)) || ("T".equals(cadastrado)))) {
							                    	
							                        if ((("S".equals(cadastrado)) || (!"S".equals(cadastradoProducao)))									                        ) {
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
											name="aplicativo" selectedValue="<%= aplicativo %>" /> - <p:InputAlfanumerico
											CLASS="inputtext" name="versao" value="<%= versao %>"
											size="4" maxlength="5" value="" disabled="true" /></td>
											
										<%
										if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
										%>
										<td class="textoTitulo" width="17%">Tipo de Transmissão:
										</td>
										<td class="textoValor" width="26%"><s:ComboTipoTransmissao
											name="tipoTransmissao" selectedValue="<%= tipoTransmissao %>"
											onChange="javascript:mudaComboTipoTransmissao();" /></td>
										<%
										}else{
										%>
										<td class="textoTitulo" width="17%">Tipo de Transmissão:
										</td>
										<td class="textoValor" width="26%"><s:ComboTipoTransmissao
											name="tipoTransmissao" selectedValue="<%= tipoTransmissao %>"
											onChange="javascript:mudaComboTipoTransmissaoPV()" disabled="false" /></td>
										<%	
										}
										%>		
											
										
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Padrão de Arquivo:</td>
										<td class="textoValor" width="26%"><s:ComboPadraoArquivo
											name="padraoArquivo" selectedValue="<%= padraoArquivo %>" />
										</td>
										<td class="textoTitulo" width="17%">Agrupamento:</td>
										<td class="textoValor" width="26%"><s:ComboTipoAgrupamento
											name="agrupamento" selectedValue="<%= agrupamento %>"
											branco="true" brancoValue="99" /></td>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Atribuição de VAN:</td>
										<td class="textoValor" width="26%"><s:ComboAtribuicaoVan
											onChange="javascript:mudaVan()" 
											name="atribuicaoVan" selectedValue="<%= atribuicaoVan %>" />
										</td>
										<td class="textoTitulo" width="17%">VAN:</td>
										<td class="comboVan" width="26%"><s:ComboVan name="van"
											branco="true" selectedValue="<%= van %>" brancoValue="99" />
										</td>
									</tr>
									
									<tr>
										
										<td class="textoTitulo" width="17%"></td>
										<td class="textoValor" width="26%"></td>
										<td class="textoTitulo" width="17%">Connect:</td>
										<td class="textoValor" width="26%"><s:ComboConnect name="codConnect"
											branco="true" selectedValue="<%= connect %>" brancoValue="99" />
										</td>
										
									</tr>
									
									<tr>
										
										<td class="textoTitulo" width="17%"></td>
										<td class="textoValor" width="26%"></td>
										<td class="textoTitulo" width="17%">Internet</td>
										<td class="textoValor" width="26%"><s:ComboInternet
											name="codInternet" branco="true"
											selectedValue="<%= cmbInternetTeste %>" brancoValue="99"	/>
										</td>
									</tr>


									<tr>
										<td class="textoTitulo" width="17%">Junção Arquivo
										Retorno:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="juncaoArquivoRetorno"
											selectedValue="<%= juncaoArquivoRetorno %>"
											onChange="javascript:mudaComboJuncaoArquivo();" /></td>
										<td class="textoTitulo" width="17%">Cedente Junção:</td>
										<td width="26%" nowrap><p:InputNumerico CLASS="inputtext"
											name="cedenteJuncao" value="<%= cedenteJuncao %>" size="8"
											maxlength="7" onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.perfilRejeicao);" />
										</td>
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Perfil Rejeição:</td>
										<td class="textoValor" width="26%"><s:ComboPerfilRejeicao
											name="perfilRejeicao" selectedValue="<%= perfilRejeicao %>" />
										</td>
										<td class="textoTitulo" width="17%">Pré-Crítica:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="preCritica" selectedValue="<%= preCritica %>" /></td>
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Apelido:</td>
										<td width="26%" nowrap><p:InputAlfanumerico
											CLASS="inputtext" name="apelido" value="<%= apelido %>"
											size="9" maxlength="6" disabled="true" /></td>
										<td class="textoTitulo" width="17%">Arquivo de Retorno:</td>
										<td width="26%" nowrap><p:InputAlfanumerico
											CLASS="inputtext" name="arquivoRetorno"
											value="<%= arquivoRetorno %>" size="40" maxlength="30"
											disabled="true" /></td>
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Cópia Arquivo
										Retorno:</td>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="copiaArquivoRetorno"
											selectedValue="<%= copiaArquivoRetorno %>"
											onChange="javascript:mudaComboCopiaArquivoRetorno();" /></td>
										<td class="textoTitulo" width="17%">Caixa Postal:</td>
										<td class="textoValor" width="26%"><p:InputNumerico
											CLASS="inputtext" name="caixaPostal"
											value="<%= caixaPostal %>" size="8" maxlength="5"
											onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);" />
										</td>
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Apelido (Cópia):</td>
										<td width="26%" nowrap><p:InputAlfanumerico
											CLASS="inputtext" name="apelidoCopia"
											value="<%= apelidoCopia %>" size="9" maxlength="6"
											disabled="true" onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);" />
										</td>
										<td class="textoTitulo" width="17%">Arquivo de Retorno
										(Cópia):</td>
										<td width="26%" nowrap><p:InputAlfanumerico
											CLASS="inputtext" name="arquivoRetornoCopia"
											value="<%= arquivoRetornoCopia %>" size="40" maxlength="30"
											disabled="true" /></td>
									</tr>

									<tr>
										<td class="textoTitulo" width="17%">Número Próxima
										Remessa:</td>
										<td class="textoValor" width="26%"><s:InputNumericoSigcb
											CLASS="inputtext" 
											name="numeroProximaRemessa"
											value="<%= numeroProximaRemessa %>" 
											size="5" 
											maxlength="5"
											userGroup="<%=usuarioBean.getNomeGrupo()%>"
											internalAction="cedente.cadastro.manter.editar" />
										</td>
										<td class="textoTitulo" width="17%">Número Último
										Retorno:</td>
										<td class="textoValor" width="26%"><s:InputNumericoSigcb
											CLASS="inputtext" 
											name="numeroUltimoRetorno"
											value="<%= numeroUltimoRetorno %>" 
											size="5" 
											maxlength="5" 
											userGroup="<%=usuarioBean.getNomeGrupo()%>"
											internalAction="cedente.cadastro.manter.editar" />
										</td>
									</tr>
									<tr>
										<td class="textoTitulo" width="17%">Data Envio/Reenvio Carga Inicial:</td>
										<td class="textoValor" width="26%"><%=dataEnvioReenvio%>
										</td>
									</tr>
									
									
									<tr>
										<td class="textoTitulo" width="17%">Retorno On Line:</td>
										<%
										if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
										%>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="retOnline" disabled="false"
											selectedValue="<%= retOnlineTeste %>" 
											onChange="javascript:mudaComboInternet();"/>
										 </td>	
										<%
										}else{
										%>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="retOnline" disabled="true"
											selectedValue="<%= retOnlineTeste %>" />
										 </td>	
										<%	
										}
										%>
										</td>
										<td class="textoTitulo" width="17%">Num. Ult. Retorno On line</td>
										<%
										if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM") || usuarioBean.getNomeGrupo().substring(0,6).equalsIgnoreCase("GCBOPE")) {
										%>
										<td class="textoValor" width="26%"><p:InputNumerico
											CLASS="inputtext" name="numUltRetOnline" disabled="False"
											value="<%= numUltRetOnlineTeste %>" size="8" maxlength="5"
											onFocus="javascript: prevFocus(this);"
											 />
										</td>	
										<%
										}else{
										%>
										<td class="textoValor" width="26%"><p:InputNumerico
											CLASS="inputtext" name="numUltRetOnline" disabled="true"
											value="<%= numUltRetOnlineTeste %>" size="8" maxlength="5"
											onFocus="javascript: prevFocus(this);"
											/>
										</td>	
										<%	
										}
										%>
									</tr>
									
									<tr>
										<td class="textoTitulo" width="17%">Remessa On Line:</td>
										<%
										if (usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBADM") || usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBSRE") || usuarioBean.getNomeGrupo().equalsIgnoreCase("GCBSRE1")){
										%>
											<td class="textoValor" width="26%"><s:ComboSimNao
												name="remOnline" disabled="false"
												selectedValue="<%= remOnlineTeste %>" 
												/>
											 </td>	
										<%
										}else{
										%>
											<td class="textoValor" width="26%"><s:ComboSimNao
											name="remOnline" disabled="true"
											selectedValue="<%= remOnlineTeste %>" />
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
											selectedValue="<%= webserviceTeste %>" 
											/>
										 </td>	
										<%
										}else{
										%>
										<td class="textoValor" width="26%"><s:ComboSimNao
											name="webservice" disabled="true"
											selectedValue="<%= webserviceTeste %>" />
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
										<p align="center"><s:Button name="buttonEnviarProd"
											value="Enviar p/ Produção"
											action="javascript:formSubmit_EnviarProducao();"/></p>
										</td>
									</tr>

									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>

								</table>
							</s:Outline>
							<%
							}
							%>

							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>

							<tr>
								<td align="right" colspan="4">
								<p align="center">
								
								<s:Button name="Confirmar"	action="javascript:formSubmit_Cedente();"	userGroup="<%=usuarioBean.getNomeGrupo()%>"	internalAction="cedente.cadastro.manter.alterar" />
								<s:Button name="Envio" value="Envio Carga Inicial" action="javascript: formCarga();"	userGroup="<%=usuarioBean.getNomeGrupo()%>"	internalAction="cedente.cadastro.manter.alterar" />
								<s:Button name="Cancelar" action="javascript:fecharGuias()"	userGroup="<%=usuarioBean.getNomeGrupo()%>"	internalAction="cedente.cadastro.manter.alterar" /></p>
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
						<p align="center"><s:Button name="Voltar_Principal"	value="Voltar" action="javascript:formSubmit_Voltar();" /> <s:Button
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
	    	iniciaBotaoEnvio();
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
	    }
	    
	    function iniciaTeste() {
	    	//if (document.frmMain.cadastrado.value != 'S') {
	    	//	desabilitarOutlineTeste();
	    	//} else {
		    	mudaComboTipoTransmissao();
		    	mudaComboJuncaoArquivo();
		    	mudaComboCopiaArquivoRetorno();
	    		
		    	if (document.frmMain.atribuicaoVan.value==2){ // CAIXA bloquear os campos de tipo de transmissão e van
		    		document.frmMain.tipoTransmissao.disabled="true";
		    		document.frmMain.van.disabled="true";
		    	}
		    	mudaComboInternet();

	    	//}
	    }
	    
	    function iniciaProducao() {
	    	mudaComboTipoTransmissaoProducao();
	    	mudaComboJuncaoArquivoProducao();
	    	mudaComboCopiaArquivoRetornoProducao();
	    	
	    	if (document.frmMain.atribuicaoVanProducao.value==2){ // CAIXA bloquear os campos de tipo de transmissão e van
	    		document.frmMain.tipoTransmissaoProducao.disabled="true";
	    		document.frmMain.vanProducao.disabled="true";
	    	}
	    	mudaComboInternetProducao();
	    		    	
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
	    
	    
	    function formCarga(){
	    	if (document.frmMain.padraoArquivoProducao.value=="1"){
	    		formSubmit_Cedente()
	    	}else{
	    		alert("Não é permitido o envio de carga inicial para o padrão de arquivo selecionado!")
	    	}
	    		
	    	
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
		    	
    	  	    habilitaCampos();
		    	
    	  	    if (document.frmMain.padraoArqTeste.value!=document.frmMain.padraoArqPro.value){
		    		alert("Informamos que um novo cedente eletrônico foi estabelecido em modo TESTE. Destacamos que, para a efetiva geração e tratamento de arquivos no novo padrão, este deve ser enviado para modo PRODUÇÃO, a partir da Guia 'Cedente eletrônico', botão 'Enviar p/ produção'.")
		    	}
		    	
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
	    	}else if (document.frmMain.tipoTransmissao.value == 3){

	    		if (document.frmMain.codConnect.value==99 || document.frmMain.codConnect.value=="99") {
	    			alert ("Connect TESTE deve ser selecionado");
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
	    	
			if (document.frmMain. cadastradoProducao=="S"){   	
		    	if (document.frmMain.vanProducao == null) {
		    		return true;
		    	}
		    
		    	if (document.frmMain.tipoTransmissaoProducao.value == 1) { // 1 - EDI/VAN
		    		
		    		if (!validaComboObrigatorio(document.frmMain.vanProducao, 'VAN', 99, true)) {
		    			abreOutlineProducao();
		    			msgEletron('001', document.frmMain.vanProducao, 'VAN');
		    			return false;
		    		}
		    	} else if (document.frmMain.tipoTransmissaoProducao.value == 3){
	
		    		if (document.frmMain.codConnectProducao.value==99 || document.frmMain.codConnectProducao.value=="99") {
		    			alert ("Connect PRODUÇÃO deve ser selecionado");
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
			}
	    	return true;
	    }


			function mudouCamposProducao() {
				if (document.frmMain.vanProducao == null) {
					return false;
				}
				
				if (document.frmMain.vanProducao.value != '<%= vanProducao %>') {
					return true;
				}
				
				
				if (document.frmMain.padraoArquivoProducao.value != '<%= padraoArquivoProducao%>'){
					return true;
				}
				
				<%-- SISOL 290123 Set/2008 Criar Guia Cedente Eletrônico Teste apenas quando for alterado o campo VAN da Guia Produção 

				if (document.frmMain.aplicativoProducao.value != '<%= aplicativoProducao %>') {
					return true;
				}

				if (document.frmMain.tipoTransmissaoProducao.value != '<%= tipoTransmissaoProducao %>') {
					return true;
				}
				
				--%>
				
				return false;
			}
	    
	    // Teste nao pode ter VAN igual
	    function validaComparacaoTesteProducao() {
	    	if (document.frmMain.cadastrado.value == "S" &&
	    			document.frmMain.cadastradoProducao.value == "S")
	    	{
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
	    		document.frmMain.codConnect.value = 99;
	    		document.frmMain.codConnect.disabled = true;
	    		
	    		document.frmMain.codInternet.disabled = false;
	    		document.frmMain.codInternet.value = 99;
	    		document.frmMain.codInternet.disabled = true;

	    	} else if (document.frmMain.tipoTransmissao.value == "3") {
	    		document.frmMain.van.value = 99;
	    		document.frmMain.van.disabled = true;
	    		//document.frmMain.codConnect.value = 99;
	    		if (document.frmMain.usuarioTeste.value=="GCBADM"){
	    			document.frmMain.codConnect.disabled = false;
	    		}else{
	    			document.frmMain.codConnect.disabled = true;
	    		}
	    		document.frmMain.codInternet.disabled = false;
	    		document.frmMain.codInternet.value = 99;
	    		document.frmMain.codInternet.disabled = true;
	    		
	    	}else if (document.frmMain.tipoTransmissao.value == "5"){ // Internet
	    		
	    		document.frmMain.codInternet.value = 99;
	    		document.frmMain.codInternet.disabled = true;
	    		document.frmMain.van.value = 99;
	    		document.frmMain.van.disabled = true;
	    		document.frmMain.codConnect.value = 99;
	    		document.frmMain.codConnect.disabled = true;
    			document.frmMain.codInternet.value = <%=cmbInternetTeste%>;
    			document.frmMain.codInternet.disabled = false;

	    		
	    	} else {
	    		document.frmMain.van.value = 99;
	    		document.frmMain.van.disabled = true;
	    		document.frmMain.codConnect.value = 99;
	    		document.frmMain.codConnect.disabled = true;
	    		document.frmMain.codInternet.disabled = false;
	    		document.frmMain.codInternet.value = 99;
	    		document.frmMain.codInternet.disabled = true;
	    		
	    	}
	    }
	    
	    
	    function mudaComboTipoTransmissaoPV() {
	    	if (document.frmMain.tipoTransmissao.value == "1") { // 1 - EDI/VAN
	    		document.frmMain.van.disabled = false;
	    		document.frmMain.codConnect.value = 99;
	    		document.frmMain.codConnect.disabled = true;
    			document.frmMain.codInternet.value = 99;
    			document.frmMain.codInternet.disabled = true;

	    	} else if (document.frmMain.tipoTransmissao.value == "3") {
	    		alert("Connect não é permitido para este perfil!");
	    		document.frmMain.tipoTransmissao.value = "1";
	    		document.frmMain.vanProducao.disabled = false;
	    		document.frmMain.codConnectProducao.value = 99;
	    		document.frmMain.codConnectProducao.disabled = true;
    			document.frmMain.codInternet.value = 99;
    			document.frmMain.codInternet.disabled = true;
    			
	    	} else if (document.frmMain.tipoTransmissao.value == "5"){

	    		document.frmMain.van.value = 99;
	    		document.frmMain.van.disabled = true;
	    		document.frmMain.codConnect.value = 99;
	    		document.frmMain.codConnect.disabled = true;
    			document.frmMain.codInternet.value = <%=cmbInternetTeste%>;
    			document.frmMain.codInternet.disabled = false;
    			
	    	} else {
	    		document.frmMain.van.value = 99;
	    		document.frmMain.van.disabled = true;
	    		document.frmMain.codConnect.value = 99;
	    		document.frmMain.codConnect.disabled = true;
    			document.frmMain.codInternet.value = 99;
    			document.frmMain.codInternet.disabled = true;
	    	}
	    }


	    

	    function mudaComboTipoTransmissaoProducao() {
	    	
	    	if (document.frmMain.tipoTransmissaoProducao.value == "1") { // 1 - EDI/VAN
	    		document.frmMain.vanProducao.disabled = false;
	    		document.frmMain.codConnectProducao.value = 99;
	    		document.frmMain.codConnectProducao.disabled = true;
	    		
	    		document.frmMain.codInternetProducao.disabled = false;
	    		document.frmMain.codInternetProducao.value = 99;
	    		document.frmMain.codInternetProducao.disabled = true;

	    		
	    	} else if (document.frmMain.tipoTransmissaoProducao.value == "3"){ // Connect
	    		document.frmMain.vanProducao.value = 99;
	    		document.frmMain.vanProducao.disabled = true;
	    		//document.frmMain.codConnectProducao.value = 99;
	    		if (document.frmMain.usuarioTeste.value=="GCBADM"){
	    			document.frmMain.codConnectProducao.disabled = false;
	    		}else{
	    			document.frmMain.codConnectProducao.disabled = true;
	    		}
	    		
	    		document.frmMain.codInternetProducao.disabled = false;
	    		document.frmMain.codInternetProducao.value = 99;
	    		document.frmMain.codInternetProducao.disabled = true;

	    	}else if (document.frmMain.tipoTransmissaoProducao.value == "5"){ // Internet

	    		document.frmMain.vanProducao.value = 99;
	    		document.frmMain.vanProducao.disabled = true;
	    		document.frmMain.codConnectProducao.value = 99;
	    		document.frmMain.codConnectProducao.disabled = true;
	    		document.frmMain.codInternetProducao.value = <%= cmbInternet%>;
		    	document.frmMain.codInternetProducao.disabled = false;
		    				    		
	    	} else {
	    		document.frmMain.vanProducao.value = 99;
	    		document.frmMain.vanProducao.disabled = true;
	    		document.frmMain.codConnectProducao.value = 99;
	    		document.frmMain.codConnectProducao.disabled = true;
	    		
	    		
	    		document.frmMain.codInternetProducao.disabled = false;
	    		document.frmMain.codInternetProducao.value = 99;
	    		document.frmMain.codInternetProducao.disabled = true;

	    	
	    	}
	    }
	    

	    function mudaComboTipoTransmissaoProducaoPV() {
	    	if (document.frmMain.tipoTransmissaoProducao.value == "1") { // 1 - EDI/VAN
	    		document.frmMain.vanProducao.disabled = false;
	    		document.frmMain.codConnectProducao.value = 99;
	    		document.frmMain.codConnectProducao.disabled = true;
	    		document.frmMain.codInternetProducao.value = 99;
	    		document.frmMain.codInternetProducao.disabled = true;
	    	} else if (document.frmMain.tipoTransmissaoProducao.value == "3"){ // Connect
	    		alert("Connect não é permitido para este perfil!");
	    		document.frmMain.tipoTransmissaoProducao.value = "1";
	    		document.frmMain.vanProducao.disabled = false;	
	    		document.frmMain.codConnectProducao.value = 99;
	    		document.frmMain.codConnectProducao.disabled = true;
	    		document.frmMain.codInternetProducao.value = 99;
	    		document.frmMain.codInternetProducao.disabled = true;
	    	} else if (document.frmMain.tipoTransmissaoProducao.value == "5"){ // Internet
	    		document.frmMain.vanProducao.value = 99;
	    		document.frmMain.vanProducao.disabled = true;
	    		document.frmMain.codConnectProducao.value = 99;
	    		document.frmMain.codConnectProducao.disabled = true;
	    		document.frmMain.codInternetProducao.value = 99;
	    		document.frmMain.codInternetProducao.disabled = false;
	    	} else {
	    		document.frmMain.vanProducao.value = 99;
	    		document.frmMain.vanProducao.disabled = true;
	    		document.frmMain.codConnectProducao.value = 99;
	    		document.frmMain.codConnectProducao.disabled = true;
	    		document.frmMain.codInternetProducao.value = 99;
	    		document.frmMain.codInternetProducao.disabled = true;
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
	    		
	    		<%//EAM1508	    		%>
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
		    	habilitaCampos();
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
			
			
			function mudaVanProducao(){
				if(document.frmMain.atribuicaoVanProducao.value==2){
					document.frmMain.tipoTransmissaoProducao.selectedIndex=0;
					sorteiaVanProducao();
					document.frmMain.tipoTransmissaoProducao.disabled=true;
					document.frmMain.vanProducao.disabled=true; 
				}else{
					document.frmMain.tipoTransmissaoProducao.disabled=false;
					document.frmMain.vanProducao.disabled=false;
				}
			}
			

			function mudaVan(){
				
				
				if(document.frmMain.atribuicaoVan.value==2){
					document.frmMain.tipoTransmissao.selectedIndex=0;
					sorteiaVan();
					document.frmMain.tipoTransmissao.disabled=true;
					document.frmMain.van.disabled=true; 
					
				}else{
					document.frmMain.tipoTransmissao.disabled=false;
					document.frmMain.van.disabled=false;
					
				}

			}
				 
			
		    function sorteiaVanProducao(){
		    	
		    	var qtde = document.frmMain.vanProducao.length;
				var posicao = Math.floor((Math.random() * qtde) + 1);
				document.frmMain.vanProducao.selectedIndex=posicao;
				//var valorTipo = document.frmMain.vanProducao.selectedIndex.text;
				var valorTipo = document.getElementById('vanProducao').options[document.getElementById('vanProducao').selectedIndex].innerText;
				var posicaoini = valorTipo.length - 1;
				var posicaoFim = valorTipo.length ;
				var valorStr = valorTipo.substring(posicaoini, posicaoFim);

				///Somente em caso de 2 ou 1
				
				if (valorStr=="4"){
					sorteiaVanProducao();
				}else if (valorStr=="3"){
					sorteiaVanProducao();
				}
				/////Verifica gestor
				if (document.frmMain.usuarioTeste.value!="GCBADM"){
					if (valorStr=="2"){
						sorteiaVanProducao();
					}
				}
				
								
		    }
		    
		    function sorteiaVan(){
		    	var qtde = document.frmMain.van.length;
				var posicao = Math.floor((Math.random() * qtde) + 1);
				document.frmMain.van.selectedIndex=posicao;
				//var valorTipo = document.frmMain.van.selectedIndex.text;
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
				if (document.frmMain.usuarioTeste.value!="GCBADM"){
					if (valorStr=="2"){
						sorteiaVan();
					}
				}
										
		    }
		    
		    function mudaPadraoArquivoProducao(){
		    	document.frmMain.padraoArqPro.value = document.frmMain.padraoArquivoProducao.value;
		    
		    }
		    
		    function iniciaBotaoEnvio(){
		    	if (document.frmMain.padraoArquivoProducao.value=="1"){
		    		document.frmMain.Envio.disabled=false;
		    	}else{
		    		document.frmMain.Envio.disabled=true;
		    	}	
		    
		    }
		    
		    function mudaComboInternetProducao(){

		    	if (document.frmMain.retOnlineProducao.value=="S"){
		    		document.frmMain.numUltRetOnlineProducao.disabled=false
		    	}else{
		    		document.frmMain.numUltRetOnlineProducao.disabled=true;
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
