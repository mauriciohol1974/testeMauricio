<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteMensagensBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteEletronicoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%CedenteEletronicoBean testeBean = (request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN) == null
                    ? new CedenteEletronicoBean()
                    : (CedenteEletronicoBean) request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_TESTE_BEAN));

            // Inicializando valores dos campos
            String juncaoArquivoRetorno = "";
            if (testeBean.getJuncaoArquivoRetorno() != null) {
                juncaoArquivoRetorno = testeBean.getJuncaoArquivoRetorno();
            }
            String preCritica = "";
            if (testeBean.getPreCritica() != null) {
                preCritica = testeBean.getPreCritica();
            }
            String copiaArquivoRetorno = "";
            if (testeBean.getCopiaArquivoRetorno() != null) {
                copiaArquivoRetorno = testeBean.getCopiaArquivoRetorno();
            }
            String agrupamento = "";
            if (testeBean.getAgrupamentoDesc() != null) {
                agrupamento = "" + testeBean.getAgrupamentoDesc();
            }
            String apelido = "";
            if (testeBean.getApelido() != null) {
                apelido = testeBean.getApelido();
            }
            String apelidoCopia = "";
            if (testeBean.getApelidoCopia() != null) {
                apelidoCopia = testeBean.getApelidoCopia();
            }
            String aplicativo = "";
            if (testeBean.getAplicativoDesc() != null) {
                aplicativo = testeBean.getAplicativoDesc();
            }
            String arquivoRetorno = "";
            if (testeBean.getArquivoRetorno() != null) {
                arquivoRetorno = testeBean.getArquivoRetorno();
            }
            String arquivoRetornoCopia = "";
            if (testeBean.getArquivoRetornoCopia() != null) {
                arquivoRetornoCopia = testeBean.getArquivoRetornoCopia();
            }
            String atribuicaoVan = "";
            if (testeBean.getAtribuicaoVanDesc() != null) {
                atribuicaoVan = testeBean.getAtribuicaoVanDesc();
            }
            String numeroProximaRemessa = "1"; // Padrao 1
            if (testeBean.getNumeroProximaRemessa() != null) {
                numeroProximaRemessa = "" + testeBean.getNumeroProximaRemessa();
            }
            String numeroUltimoRetorno = "0"; // EAM - 14/10/05 Novo Padrao 0
            if (testeBean.getNumeroUltimoRetorno() != null) {
                numeroUltimoRetorno = "" + testeBean.getNumeroUltimoRetorno();
            }
            String padraoArquivo = "";
            if (testeBean.getPadraoArquivoDesc() != null) {
                padraoArquivo = "" + testeBean.getPadraoArquivoDesc();
            }
            String perfilRejeicao = "";
            if (testeBean.getPerfilRejeicaoDesc() != null) {
                perfilRejeicao = "" + testeBean.getPerfilRejeicaoDesc();
            }
            String tipoTransmissao = "";
            if (testeBean.getTipoTransmissaoDesc() != null) {
                tipoTransmissao = "" + testeBean.getTipoTransmissaoDesc();
            }
            String van = "";
            if (testeBean.getVanDesc() != null) {
                van = "" + testeBean.getVanDesc();
            }
            String versao = "";
            if (testeBean.getVersao() != null
                && !testeBean.getVersao().equals("")) {
                versao = " - " + testeBean.getVersao();
            }
            String dataEnvioReenvio = "";
            if (testeBean.getDataEnvioReenvio() != null
                && !testeBean.getDataEnvioReenvio().equals("")) {
            	dataEnvioReenvio = ""+ testeBean.getDataEnvioReenvio();
            }
            String descConnect = "";
            if (testeBean.getDescConnect()!=null && !testeBean.getDescConnect().equals("")){
            	descConnect = "" + testeBean.getDescConnect();
            }
            

            String cedenteJuncao = testeBean.getCodigoCedenteJuncaoFormatado();
            String caixaPostal = Util.toStr(testeBean.getCaixaPostal());
            
        	String cmbInternetTeste			= Util.toStr(testeBean.getDescInternet());
        	String retOnlineTeste			= Util.toStr(testeBean.getRetOnline());
        	String remOnlineTeste			= Util.toStr(testeBean.getRemOnline());
        	String numUltRetOnlineTeste      = Util.toStr(testeBean.getNumUltRetOnline(),"0");
        	String webserviceTeste			= Util.toStr(testeBean.getWebservice());
        	
        	if (webserviceTeste.equalsIgnoreCase("S")){
        		webserviceTeste="SIM";
        	}else{
        		webserviceTeste="NÃO";
        	}
            
        	if (retOnlineTeste.equalsIgnoreCase("S")){
        		retOnlineTeste="SIM";
        	}else{
        		retOnlineTeste="NÃO";
        	}
        	
        	if (remOnlineTeste.equalsIgnoreCase("S")){
        		remOnlineTeste="SIM";
        	}else{
        		remOnlineTeste="NÃO";
        	}
        	
            String cadastradoTeste = testeBean.getCadastrado() != null
                    ? testeBean.getCadastrado()
                    : "";

            %>

<%CedenteEletronicoBean producaoBean = (request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_PRODUCAO_BEAN) == null
                    ? new CedenteEletronicoBean()
                    : (CedenteEletronicoBean) request.getAttribute(CedenteEstrategia.CEDENTE_ELETRONICO_PRODUCAO_BEAN));

            // Inicializando valores dos campos
            String juncaoArquivoRetornoProducao = "";
            if (producaoBean.getJuncaoArquivoRetorno() != null) {
                juncaoArquivoRetornoProducao = producaoBean.getJuncaoArquivoRetorno();
            }
            String preCriticaProducao = "";
            if (producaoBean.getPreCritica() != null) {
                preCriticaProducao = producaoBean.getPreCritica();
            }
            String copiaArquivoRetornoProducao = "";
            if (producaoBean.getCopiaArquivoRetorno() != null) {
                copiaArquivoRetornoProducao = producaoBean.getCopiaArquivoRetorno();
            }
            String agrupamentoProducao = "";
            if (producaoBean.getAgrupamentoDesc() != null) {
                agrupamentoProducao = producaoBean.getAgrupamentoDesc();
            }
            String apelidoProducao = "";
            if (producaoBean.getApelido() != null) {
                apelidoProducao = producaoBean.getApelido();
            }
            String apelidoCopiaProducao = "";
            if (producaoBean.getApelidoCopia() != null) {
                apelidoCopiaProducao = producaoBean.getApelidoCopia();
            }
            String aplicativoProducao = "";
            if (producaoBean.getAplicativoDesc() != null) {
                aplicativoProducao = producaoBean.getAplicativoDesc();
            }
            String arquivoRetornoProducao = "";
            if (producaoBean.getArquivoRetorno() != null) {
                arquivoRetornoProducao = producaoBean.getArquivoRetorno();
            }
            String arquivoRetornoCopiaProducao = "";
            if (producaoBean.getArquivoRetornoCopia() != null) {
                arquivoRetornoCopiaProducao = producaoBean.getArquivoRetornoCopia();
            }
            String atribuicaoVanProducao = "";
            if (producaoBean.getAtribuicaoVanDesc() != null) {
                atribuicaoVanProducao = producaoBean.getAtribuicaoVanDesc();
            }
            String numeroProximaRemessaProducao = "1"; // Padrao 1
            if (producaoBean.getNumeroProximaRemessa() != null) {
                numeroProximaRemessaProducao = ""
                                               + producaoBean.getNumeroProximaRemessa();
            }
            String numeroUltimoRetornoProducao = "0"; // EAM - 14/10/05 Novo Padrao 0
            if (producaoBean.getNumeroUltimoRetorno() != null) {
                numeroUltimoRetornoProducao = ""
                                              + producaoBean.getNumeroUltimoRetorno();
            }
            String padraoArquivoProducao = "";
            if (producaoBean.getPadraoArquivoDesc() != null) {
                padraoArquivoProducao = producaoBean.getPadraoArquivoDesc();
            }
            String perfilRejeicaoProducao = "";
            if (producaoBean.getPerfilRejeicaoDesc() != null) {
                perfilRejeicaoProducao = producaoBean.getPerfilRejeicaoDesc();
            }
            String tipoTransmissaoProducao = "";
            if (producaoBean.getTipoTransmissaoDesc() != null) {
                tipoTransmissaoProducao = producaoBean.getTipoTransmissaoDesc();
            }
            String vanProducao = "";
            if (producaoBean.getVanDesc() != null) {
                vanProducao = producaoBean.getVanDesc();
            }
            String versaoProducao = "";
            if (producaoBean.getVersao() != null
                && !producaoBean.getVersao().equals("")) {
                versaoProducao = " - " + producaoBean.getVersao();
            }
            
            String dataEnvioReenvioProducao = "";
            if (producaoBean.getDataEnvioReenvio() != null
                && !producaoBean.getDataEnvioReenvio().equals("")) {
            	dataEnvioReenvioProducao = "" + producaoBean.getDataEnvioReenvio();
            }
            
            String descConnectProducao = "";
            if (producaoBean.getDescConnect()!=null && !producaoBean.getDescConnect().equals("")){
            	descConnectProducao = "" + producaoBean.getDescConnect();
            }

           
            
            String cedenteJuncaoProducao = producaoBean.getCodigoCedenteJuncaoFormatado();
            String caixaPostalProducao = Util.toStr(producaoBean.getCaixaPostal());
            
            
        	String cmbInternet			= Util.toStr(producaoBean.getDescInternet());
        	String retOnline			= Util.toStr(producaoBean.getRetOnline());
        	String remOnline			= Util.toStr(producaoBean.getRemOnline());
        	String numUltRetOnline      = Util.toStr(producaoBean.getNumUltRetOnline(),"0");
        	String webserviceProducao	= Util.toStr(producaoBean.getWebservice());
        	
        	if (webserviceProducao.equalsIgnoreCase("S")){
        		webserviceProducao="SIM";
        	}else{
        		webserviceProducao="NÃO";
        	}
        	
        	if (retOnline.equalsIgnoreCase("S")){
        		retOnline="SIM";
        	}else{
        		retOnline="NÃO";
        	}
        	
        	if (remOnline.equalsIgnoreCase("S")){
        		remOnline="SIM";
        	}else{
        		remOnline="NÃO";
        	}
        	
        	
            
            String cadastradoProducao = producaoBean.getCadastrado() != null
                    ? producaoBean.getCadastrado()
                    : "";

            %>
<div class="group">
<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14
	valign="middle" align="center">
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td class="textoDestaqueTitulo">Guia: Cedente Eletrônico</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
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
				<td class="textoValor" width="26%"><%=aplicativoProducao%><%=versaoProducao%>
				</td>
				<td class="textoTitulo" width="17%">Tipo de Transmissão:</td>
				<td class="textoValor" width="26%"><%=tipoTransmissaoProducao%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Padrão de Arquivo:</td>
				<td class="textoValor" width="26%"><%=padraoArquivoProducao%></td>
				<td class="textoTitulo" width="17%">Agrupamento:</td>
				<td class="textoValor" width="26%"><%=agrupamentoProducao%></td>
			</tr>
			<tr>
				<td class="textoTitulo" width="17%">Atribuição de VAN:</td>
				<td class="textoValor" width="26%"><%=atribuicaoVanProducao%></td>
				<td class="textoTitulo" width="17%">VAN:</td>
				<td class="textoValor" width="26%"><%=vanProducao%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">&nbsp;</td>
				<td class="textoValor" width="26%">&nbsp;</td>
				<td class="textoTitulo" width="17%">Connect:</td>
				<td class="textoValor" width="26%"><%=descConnectProducao%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">&nbsp;</td>
				<td class="textoValor" width="26%">&nbsp;</td>
				<td class="textoTitulo" width="17%">Internet</td>
				<td class="textoValor" width="26%">
					<%= cmbInternet %>
				</td>
			</tr>


			<tr>
				<td class="textoTitulo" width="17%">Junção Arquivo Retorno:</td>
				<td class="textoValor" width="26%"><%=juncaoArquivoRetornoProducao%>
				</td>
				<td class="textoTitulo" width="17%">Cedente Junção:</td>
				<td class="textoValor" width="26%" nowrap><%=cedenteJuncaoProducao%>
				</td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Perfil Rejeição:</td>
				<td class="textoValor" width="26%"><%=perfilRejeicaoProducao%></td>
				<td class="textoTitulo" width="17%">Pré-Crítica:</td>
				<td class="textoValor" width="26%"><%=preCriticaProducao%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Apelido:</td>
				<td class="textoValor" width="26%" nowrap><%=apelidoProducao%></td>
				<td class="textoTitulo" width="17%">Arquivo de Retorno:</td>
				<td class="textoValor" width="26%" nowrap><%=arquivoRetornoProducao%>
				</td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Cópia Arquivo Retorno:</td>
				<td class="textoValor" width="26%"><%=copiaArquivoRetornoProducao%>
				</td>
				<td class="textoTitulo" width="17%">Caixa Postal:</td>
				<td class="textoValor" width="26%"><%=caixaPostalProducao%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Apelido (Cópia):</td>
				<td class="textoValor" width="26%" nowrap><%=apelidoCopiaProducao%>
				</td>
				<td class="textoTitulo" width="17%">Arquivo de Retorno (Cópia):</td>
				<td class="textoValor" width="26%" nowrap><%=arquivoRetornoCopiaProducao%>
				</td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Número Próxima Remessa:</td>
				<td class="textoValor" width="26%"><%=numeroProximaRemessaProducao%>
				</td>
				<td class="textoTitulo" width="17%">Número Último Retorno:</td>
				<td class="textoValor" width="26%"><%=numeroUltimoRetornoProducao%>
				</td>
			</tr>
			
			<tr>
				<td class="textoTitulo" width="17%">Data Envio/Reenvio Carga Inicial:</td>
				<td class="textoValor" width="26%"><%=dataEnvioReenvioProducao%></td>
				
			</tr>
			
			<tr>
				<td class="textoTitulo" width="17%">Situação da VAN/Connect:</td>
				<td class="textoValor" width="26%"><%= producaoBean.getSituacaoVAN()%></td>
				
			</tr>
			
			<tr>
				<td class="textoTitulo" width="17%">Retorno On Line:</td>
				
				<td class="textoValor" width="26%"><%= retOnline %></td>	
				
				
				<td class="textoTitulo" width="17%">Num. Ult. Retorno On line</td>
				<td class="textoValor" width="26%">
					<%= numUltRetOnline %>
				</td>
					
				
			</tr>
			
			<tr>
				<td class="textoTitulo" width="17%">Remessa On Line:</td>
				
				<td class="textoValor" width="26%"><%= remOnline %></td>	
				
				<td class="textoTitulo" width="17%">Webservice:</td>
				
				<td class="textoValor" width="26%"><%= webserviceProducao %></td>	
			</tr>

			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>

		</table>
	</s:Outline>

	<%}

            if ("S".equals(cadastradoTeste)) {
%>

	<s:Outline name="CedenteTesteParent" title="Cedente	Eletrônico - Teste"
		imagePath="<%=Paths.getImagePath()%>" type="twist">
		<table width="95%" border="0" cellspacing="0" cellpadding="0"
			height=14 valign="middle" align="center">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="17%">Aplicativo:</td>
				<td class="textoValor" width="26%"><%=aplicativo%><%=versao%></td>
				<td class="textoTitulo" width="17%">Tipo de Transmissão:</td>
				<td class="textoValor" width="26%"><%=tipoTransmissao%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Padrão de Arquivo:</td>
				<td class="textoValor" width="26%"><%=padraoArquivo%></td>
				<td class="textoTitulo" width="17%">Agrupamento:</td>
				<td class="textoValor" width="26%"><%=agrupamento%></td>
			</tr>
			<tr>
				<td class="textoTitulo" width="17%">Atribuição de VAN:</td>
				<td class="textoValor" width="26%"><%=atribuicaoVan%></td>
				<td class="textoTitulo" width="17%">VAN:</td>
				<td class="textoValor" width="26%"><%=van%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Junção Arquivo Retorno:</td>
				<td class="textoValor" width="26%"><%=juncaoArquivoRetorno%></td>
				<td class="textoTitulo" width="17%">Cedente Junção:</td>
				<td class="textoValor" width="26%" nowrap><%=cedenteJuncao%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Perfil Rejeição:</td>
				<td class="textoValor" width="26%"><%=perfilRejeicao%></td>
				<td class="textoTitulo" width="17%">Pré-Crítica:</td>
				<td class="textoValor" width="26%"><%=preCritica%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Apelido:</td>
				<td class="textoValor" width="26%" nowrap><%=apelido%></td>
				<td class="textoTitulo" width="17%">Arquivo de Retorno:</td>
				<td class="textoValor" width="26%" nowrap><%=arquivoRetorno%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Cópia Arquivo Retorno:</td>
				<td class="textoValor" width="26%"><%=copiaArquivoRetorno%></td>
				<td class="textoTitulo" width="17%">Caixa Postal:</td>
				<td class="textoValor" width="26%"><%=caixaPostal%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Apelido (Cópia):</td>
				<td class="textoValor" width="26%" nowrap><%=apelidoCopia%></td>
				<td class="textoTitulo" width="17%">Arquivo de Retorno (Cópia):</td>
				<td class="textoValor" width="26%" nowrap><%=arquivoRetornoCopia%></td>
			</tr>

			<tr>
				<td class="textoTitulo" width="17%">Número Próxima Remessa:</td>
				<td class="textoValor" width="26%"><%=numeroProximaRemessa%></td>
				<td class="textoTitulo" width="17%">Número Último Retorno:</td>
				<td class="textoValor" width="26%"><%=numeroUltimoRetorno%></td>
			</tr>
			<tr>
				<td class="textoTitulo" width="17%">Data Envio/Reenvio Carga Inicial:</td>
				<td class="textoValor" width="26%"><%=dataEnvioReenvio%></td>
				<td class="textoTitulo" width="17%">Connect:</td>
				<td class="textoValor" width="26%"><%=descConnect%></td>
				
			</tr>
			<tr>
				<td class="textoTitulo" width="17%">Situação da VAN/Connect:</td>
				<td class="textoValor" width="26%"><%=testeBean.getSituacaoVAN()%></td>
				<td class="textoTitulo" width="17%">Internet</td>
				<td class="textoValor" width="26%">
					<%= cmbInternetTeste %>
				</td>
			</tr>
			
			<tr>
				<td class="textoTitulo" width="17%">Retorno On Line:</td>
				
				<td class="textoValor" width="26%"><%= retOnlineTeste %>
				
				
				<td class="textoTitulo" width="17%">Num. Ult. Retorno On line</td>
				<td class="textoValor" width="26%">
					<%= numUltRetOnlineTeste %>
				</td>
					
				
			</tr>
			
			<tr>
				<td class="textoTitulo" width="17%">Remessa On Line:</td>
				
				<td class="textoValor" width="26%"><%= remOnlineTeste %>
				<td class="textoTitulo" width="17%">Webservice:</td>
				
				<td class="textoValor" width="26%"><%= webserviceTeste %>
			</tr>

			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>

		</table>

	</s:Outline>

	<%}

            if (!("S".equals(cadastradoTeste))
                && !("S".equals(cadastradoProducao))) {

            %>
	<tr>
		<td colspan="4" class="textoValor">Não Cadastrado</td>
	</tr>
	<%}

        %>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

</table>
<div>