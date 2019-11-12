<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConteudoListaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>

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

            InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean) session.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);

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
		<input type="hidden" name="situacaoEletronico"
			value="<%=filtroBean.getSituacao()%>" />
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
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Cedentei"></a> <a
							name="CedenteParent">Cedente Eletrônico</a></td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><!-- ************************************************* CEDENTE ELETRONICO ************************************** -->
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
		
	    function inicia() {
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
    </script>

	</s:FormStrategy>
</p:Document>
</html>
