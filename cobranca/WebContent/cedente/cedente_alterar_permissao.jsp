<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConteudoListaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedConsultaPermissaoBean"%>
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

            InformacoesUsuarioBean usuarioLDAP = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
            
            CedConsultaPermissaoBean permissaoBean = (CedConsultaPermissaoBean) request.getAttribute(CedenteEstrategia.CEDENTE_PERMISSAO_BEAN);
            
            String situINT = permissaoBean.getDE_STCO_INTERNA().trim();
            String dataINT = permissaoBean.getDT_STCO_INTERNA();
            String horaINT = permissaoBean.getHH_STCO_INTERNA();
            String usuarioINT = permissaoBean.getCO_USRO_INTERNA();
            String descricaoINT = permissaoBean.getDE_HIST_INTERNA();

            String situCIP = permissaoBean.getDE_STCO_CIP().trim();
			String dataCIP =  permissaoBean.getDT_STCO_CIP();
			String horaCIP =  permissaoBean.getHH_STCO_CIP();
			String usuarioCIP = permissaoBean.getCO_USRO_CIP();
			String descricaoCIP = permissaoBean.getDE_HIST_CIP();
			
			String situACATAR = permissaoBean.getDE_ACAT_CIP().trim();
			String dataACATAR = permissaoBean.getDT_ACAT_CIP();
			String horaACATAR = permissaoBean.getHH_ACAT_CIP();

			
			String situFINAL = permissaoBean.getDE_STCO_FINAL().trim();
			String dataFINAL = permissaoBean.getDT_STCO_FINAL();
			String horaFINAL = permissaoBean.getHH_STCO_FINAL();
			String usuarioFINAL = permissaoBean.getCO_USRO_FINAL();
			String descricaoFINAL = permissaoBean.getDE_HIST_FINAL();
			
			request.setAttribute(CedenteEstrategia.CEDENTE_PERMISSAO_BEAN,permissaoBean);
			
            
            
            
%>

<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"	estrategia="cedente.CedenteAlterarGuiaControle" fluxo="normal">
		<s:Menu />
		<s:Titulo name="Manter Cedente >> Alterar" />
		<input type="hidden" name="guiaAberta" value="<%= guiaAberta %>">
		<input type="hidden" name="tipoCobranca" value="<%= tipoCobranca %>">
		<input type="hidden" name="cedenteCentralizador"
			value="<%= cedenteCentralizador %>">
		<input type="hidden" name="nsuTransacao" value="<%= nsuTransacao %>">
		<input type="hidden" name="codigoCedente" value="<%= codigoCedente %>">
		<input type="hidden" name="situacaoEletronico"
			value="<%=filtroBean.getSituacao()%>" />
			
		<input type="hidden" name="acatarInterna" value="N">			
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
					<%
					if (!usuarioLDAP.getNomeGrupo().equals("GCBATE")) {
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
					}
					%>
					<%
					if (usuarioLDAP.getNomeGrupo().equals("GCBATE")) {
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
					}
					%>
					<%
					if (!usuarioLDAP.getNomeGrupo().equals("GCBATE")) {
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
		              
		              <td class="textoTitulo">
		                <a href="#PermissaoParent" onclick="javascript:trocaGuia(11);">
		                	 <img src="<%=Paths.getImagePath()%>/outlineminus.gif" width="11" height="11" name="outlineplus" id="Permissaoi"></a>
		                <a name="TarifasParent">Permissão Final</a>
		              </td>
		              <td colspan="3" class="textoValor">
		                &nbsp;
		              </td>
		            </tr>
					<tr>
						<td colspan="4" class="textoValor">
						<div class="group">
						<table cellpadding="0" width="720" >
	                    <tr> 
	                      <td colspan="8" class="textoDestaqueTitulo">Guia: Permissão Final</td>
	                    </tr>
	                    <tr> 
	                      <td colspan="8">
	                      <table border="1" widt="720">
	                      	<tr><td>
		                       	<table border="0" width="720">
			                      	<tr>
			                      		 <td class="textoDestaqueTitulo" colspan="5">
			                      		 Situação Interna
			                      		 </td>
			                      	</tr>
			                      	
			                      	<tr>
			                      		 <td class="textoTitulo">
			                      		 Situação
			                      		 </td>
			                      		 <td class="textoTitulo">
			                      		 	<select id="situacaoINT" name="situacaoINT" CLASS="inputtext">
			                      		 		<option <%=situINT.equals("APTO") ? "selected='selected'" : ""%> value="A">APTO</option>
			                      		 		<option <%=situINT.equals("EM ANALISE") ? "selected='selected'" : ""%> value="E">EM ANÁLISE</option>
			                      		 		<option <%=situINT.equals("INAPTO") ? "selected='selected'" : ""%>value="I">INAPTO</option>
			                      		 	</select>
			                      		 </td>
			                      		 <td class="textoTitulo">
			                      		 	Data
			                      		 </td>
			                      		 <td class="textoTitulo">
			                      		 	<input type="text" id="dataInterna" size="12" value="<%=dataINT %>"  CLASS="inputtext" readonly>
			                      		 </td>
			                      		 <td class="textoTitulo" >
			                      		 	Hora
			                      		 </td>
			                      		 <td class="textoTitulo" >
			                      		 	<input type="text" id="horaInterna" size="08" value="<%=horaINT %>"  CLASS="inputtext" readonly>
			                      		 </td>
			                      		 <td class="textoTitulo" >
			                      		 	Usuário
			                      		 </td>
			                      		 <td class="textoTitulo">
			                      		 	<input type="text" id="usuarioInterna" size="08" value="<%=usuarioINT %>"  CLASS="inputtext" readonly>
			                      		 </td>
			                      	</tr>
			                      	<tr >
			                      		 <td class="textoTitulo">
			                      		 Descrição
			                      		 </td>
			                      		 <td class="textoTitulo"  colspan="7">
			                      		 	<input type="text" id="descr1Int" name="descr1Int" size="130" maxlength="100" value="<%=descricaoINT.substring(0, 100).trim()%>"  CLASS="inputtext">
			                      		 </td>
			                      	</tr>
			                      	<tr >
			                      		 <td class="textoTitulo" >
			                      		 	&nbsp;
			                      		 </td>
			                      		 <td class="textoTitulo" colspan="7">
			                      		 	<input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoINT.substring(100, 200).trim()%>"size="130"  CLASS="inputtext">
			                      		 </td>
			                      	<tr>
			                      		<td>&nbsp;</td>
			                      	</tr>
			                      	
			                      	<tr>
			                      		<td colspan="8" align="center">
			                      		<%
					     					if (usuarioLDAP.getNomeGrupo().equalsIgnoreCase("GCBADM")){
					  					%>
			                      			<s:Button name="acatarSituacao" value="Acatar Sit. Interna" action="javascript:acatar();"/>
			                      		<%}else{ %>
			                      			<s:Button name="acatarSituacao" value="Acatar Sit. Interna" disabled="true" action="javascript:acatar();"/>
			                      		<%} %>
			                      		</td>
			                      	</tr>
			                      	
			                        <tr>
			                      		<td>&nbsp;</td>
			                      	</tr>
			            		</table>
			            		</td></tr>
		            		</table>
						</td>
						</tr>
					<tr> 
                      <td colspan="6">
                      	<table border="1">
                      		<tr>
                      		<td colspan="8">
                      	
	                       	<table  border="0" cellpadding="0" width="720" >
	                       		<tr >
		                      		 <td class="textoDestaqueTitulo" colspan="7">
		                      		 Situação CIP
		                      		 </td>
		                      	</tr>
		                      	<tr>
		                      	
		                      		 <td class="textoTitulo" >
		                      		 Situação
		                      		 </td>
		                      		 <td class="textoTitulo">
		                      		 	<input type="text" id="situacaoCIP" size="12" value="<%=situCIP %>"  CLASS="inputtext" readonly>
		                      		 </td>
		                      		 <td class="textoTitulo" align="right" >
		                      		 	Data
		                      		 </td>
		                      		 <td class="textoTitulo" >
		                      		 	<input type="text" id="dataCIP" size="12" value="<%=dataCIP %>"   CLASS="inputtext" readonly>
		                      		 </td>
		                      		 <td class="textoTitulo" align="right"  >
		                      		 	Hora
		                      		 </td>
		                      		 <td class="textoTitulo" >
		                      		 	<input type="text" id="horaCIP" size="08" value="<%=horaCIP %>"  CLASS="inputtext" readonly>
		                      		 </td>
		                      	</tr>
		                      	<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 Descrição
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(0, 100).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                     		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(100, 200).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(200, 300).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(300, 400).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(400, 500).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(500, 600).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(600, 700).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(700, 800).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(800, 900).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(900, 999).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr>
		                      		 <td class="textoTitulo" colspan="2">
		                      		 Acatar Situação CIP
		                      		 <%
					     					if (usuarioLDAP.getNomeGrupo().equalsIgnoreCase("GCBADM")){
					  					%>
		                      		 	<select id="situacaoAcatar" name="situacaoAcatar" CLASS="inputtext">
		                      		 	<%}else{ %>
		                      		 	<select id="situacaoAcatar2" name="situacaoAcatar2" disabled="true"  CLASS="inputtext">
		                      		 	<%} %>
		                      		 		<option <%=situACATAR.equals("SIM") ? "selected='selected'" : ""%> value="S">SIM</option>
		                      		 		<option <%=situACATAR.equals("NAO") ? "selected='selected'" : ""%>value="N">NÃO</option>
		                      		 			<input type="hidden" name="situacaoAcatar" value="<%=situACATAR.equals("SIM") ? "S" : "N"%>">
		                      		 	</select>
		                      		 </td>
		                      		 <td class="textoTitulo" >
		                      		 	Data
		                      		 	<input type="text" id="dataAcatar" size="12" value="<%=dataACATAR %>"  CLASS="inputtext" readonly>
		                      		 </td>
		                      		 <td class="textoTitulo">
		                      		 	Hora
		                      		 	<input type="text" id="horaAcatar" size="08" value="<%=horaACATAR %>"  CLASS="inputtext" readonly>
		                      		 </td>
		                      		 <td class="textoTitulo">
		                      		 	Usuário
		                      		 	<input type="text" id="usuarioAcatar" size="08" value="<%=usuarioCIP %>"  CLASS="inputtext" readonly>
		                      		 </td>
		                      	</tr>
		                      	<tr>
			                      		<td>&nbsp;</td>
			                      	</tr>
	                      	</table>
                      	</td>
                      	</tr>
                      	</table>
                      </td>
                    </tr>
                    <tr> 
                      <td colspan="4">
                      	<table border="1">
                      	<tr><td colspan="8">
                       	<table  border="0" cellpadding="0" width="720" >
                       		<tr >
	                      		 <td class="textoDestaqueTitulo" colspan="5">
	                      		 Situação Final
	                      		 </td>
	                      	</tr>
	                      	<tr >
	                      	
	                      		 <td class="textoTitulo" >
	                      		 Situação
	                      		 </td>
	                      		 <td class="textoTitulo">
	                      		 	<input type="text" id="situacaoFINAL" size="12" value="<%=situFINAL %>"  CLASS="inputtext" readonly>
	                      		 </td>
	                      		 <td class="textoTitulo" >
	                      		 	Data
	                      		 </td>
	                      		 <td class="textoTitulo" >
	                      		 	<input type="text" id="dataFINAL" size="12" value="<%=dataFINAL %>"  CLASS="inputtext" readonly>
	                      		 </td>
	                      		 <td class="textoTitulo" >
	                      		 	Hora
	                      		 </td>
	                      		 <td class="textoTitulo">
	                      		 	<input type="text" id="horaFINAL" size="08" value="<%=horaFINAL %>"  CLASS="inputtext" readonly>
	                      		 </td>
	                      		 <td class="textoTitulo">
	                      		 	Usuario
	                      		 </td>
	                      		 <td class="textoTitulo">
	                      		 	<input type="text" id="usuarioFINAL" size="08" value="<%=usuarioFINAL %>"  CLASS="inputtext" readonly>
	                      		 </td>
	                      	</tr>
	                      	<tr >
	                      		 <td class="textoTitulo">
	                      		 Descrição
	                      		 </td>
	                      		 <td class="textoTitulo" colspan="7">
	                      		 	<input type="text" id="descricaoFINAL" size="130" CLASS="inputtext" value="<%=descricaoFINAL %>" readonly>
	                      		 </td>
	                      	</tr>
	                      	<tr>
			                      		<td>&nbsp;</td>
			                      	</tr>
	                    </table>
	                    </td>
	                    </tr>
	                    </table>
	                    </td>
	                    </tr>
	                    <tr>
	                    	<td colspan=8" align="center">
			                    <table border="0">
			                    	<tr>
			                    		<td  align= "center" colspan="10">
			                    			<s:Button name="confirmar" value="Confirmar" action="javascript:Confirmar();"/>
			                    			&nbsp;&nbsp;
			                    			<s:Button name="cancelar" value="Cancelar" action="javascript:fecharGuias();"/>
			                    		</td>
			                    	</tr>
			                    </table>
	                    	</td>
	                    </tr>
	                    </table>
	                    </div>
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

					<%
					                    //EAM - Mensagem de alerta se o cedente foi alterado
					                    String lembreteConclusao = "";
					                    if (session.getAttribute(CedenteEstrategia.ALTERACAO_GUIA_CAMPO) != null) {
					                        lembreteConclusao = (String) session.getAttribute(CedenteEstrategia.ALTERACAO_GUIA_CAMPO);
					                    }
					%>
					<%
					if (!lembreteConclusao.trim().equals("")) {
					%>
					<tr>
						<td colspan="4">
						<h3 style="TEXT-ALIGN:center"><%=lembreteConclusao%></h3>
						</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<%
						}
						%>
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
	    
	    	document.frmMain.guiaAberta.value = guia;
	    	document.frmMain.submit();
	    }
	    
	    function fecharGuias() {
	    	if (!confirm(conf("128"))) {
	    		return;
	    	}
		    	document.frmMain.guiaAberta.value = <%= CedenteEstrategia.GUIA_NENHUMA %>;
		    	document.frmMain.submit();
	    }
	    
	    
	    function acatar(){
	    	  document.frmMain.acatarInterna.value="S";
	    	  
	          document.frmMain.estrategia.value="cedente.CedenteAcatarFinalizar";
	          document.frmMain.submit();
	    }
	    
	    function Confirmar(){
	    	  document.frmMain.acatarInterna.value="N";
	    	  
	          document.frmMain.estrategia.value="cedente.CedenteAcatarFinalizar";
	          document.frmMain.submit();
	    }
	    
	    
    </script>

	</s:FormStrategy>
</p:Document>
</html>
