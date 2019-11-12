<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteManterFiltroBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.login.AutenticacaoUsuario"%>

<%CedenteManterFiltroBean filtroBean = (session.getAttribute(CedenteEstrategia.MANTER_FILTRO_BEAN) == null
                    ? new CedenteManterFiltroBean()
                    : (CedenteManterFiltroBean) session.getAttribute(CedenteEstrategia.MANTER_FILTRO_BEAN));

            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
			CedenteGeralBean cedGeralBean = (session.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN)==null?new CedenteGeralBean():(CedenteGeralBean)session.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN));
%>


<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="cedente.CedenteIncluirGuiaControle" fluxo="normal">
		<s:Menu />
		<s:Titulo name="Manter Cedente >> Consulta Detalhada" />
		<input type="hidden" name="pagina" value="0">

		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height=53 valign="middle" align="center">

					<%-- *********** CABECALHO CEDENTE ****************** --%>
					<%@include file="cedente_cabecalho.jsp"%>

					<%Long codigoCedente = cedenteCabecalhoBean.getCodigoCedente();
                    if (codigoCedente == null) {
                        codigoCedente = filtroBean.getCodigoCedente();
                    }
                    String pagina = pageContext.getRequest().getParameter(
                            "pagina");
                    if ((pagina == null) || ("".equals(pagina))) {
                        pagina = "0";
                    }

                    %>

					<input type="hidden" name="codigoCedente"
						value="<%= codigoCedente %>">
					<input type="hidden" name="razaoSocial"
						value="<%= cedenteCabecalhoBean.getRazaoSocial() %>">
					<input type="hidden" name="codigoClienteCOCLI"
						value="<%= cedenteCabecalhoBean.getCodigoClienteCOCLI() %>">
					<input type="hidden" name="situacao"
						value="<%= cedenteCabecalhoBean.getSituacao() %>">

					<tr valign="top">
						<td colspan="5" class="textoTitulo">Consultar Guias:
						<hr>
						</td>
					</tr>

					<!-- ************************************************* GERAL ************************************** -->
					<tr>
						<td class="textoTitulo"><a onclick="javascript:trocaPagina('1');"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Gerali"></a> Geral</td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><%if ("1".equals(pagina)) {%> <%@include
							file="cedente_consultar_guiageral.jsp"%> <%}%></td>
					</tr>

					<!-- ************************************************* FLOAT ************************************** -->
					<tr>
						<td class="textoTitulo"><a onclick="javascript:trocaPagina('2');"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Floati"></a> Float</td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><%if ("2".equals(pagina)) {%> <%@include
							file="cedente_consultar_guiafloat.jsp"%> <%}%></td>
					</tr>

					<!-- ************************************************* CONTAS ************************************** -->
					<tr>
						<td class="textoTitulo"><a onclick="javascript:trocaPagina('3');"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Contasi"></a> Contas Déb.
						Créd. e Rateio</td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><%if ("3".equals(pagina)) {%> <%@include
							file="cedente_consultar_guiacontas.jsp"%> <%}%></td>
					</tr>

					<!-- ************************************************* CEDENTE ELETRONICO ************************************** -->
					<tr>
						<td class="textoTitulo"><a onclick="javascript:trocaPagina('4');"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="CedenteEletronicoi"></a>
						Cedente Eletrônico</td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><%if ("4".equals(pagina)) {%> <%@include
							file="cedente_consultar_guiaeletron.jsp"%> <%}%></td>
					</tr>

					<!-- ************************************************* BLOQUETOS ************************************** -->
					<tr>
						<td class="textoTitulo"><a onclick="javascript:trocaPagina('5');"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Bloquetosi"></a> Boleto</td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><%if ("5".equals(pagina)) {%> <%@include
							file="cedente_consultar_guiabloq.jsp"%> <%}%></td>
					</tr>

					<!-- ************************************************* MENSAGEM ************************************** -->
					<tr>
						<td class="textoTitulo"><a onclick="javascript:trocaPagina('6');"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Mensagemi"></a> Mensagens para
						Boletos</td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><%if ("6".equals(pagina)) {%> <%@include
							file="cedente_consultar_guiamsgbloq.jsp"%> <%}%></td>
					</tr>

					<!-- ************************************************* TARIFAS ************************************** -->
					<tr>
						<td class="textoTitulo"><a onclick="javascript:trocaPagina('7');"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Mensagemi"></a> Tarifas</td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><%if ("7".equals(pagina)) {%> <%@include
							file="cedente_consultar_guiatarifa.jsp"%> <%}%></td>
					</tr>


					<!-- ************************************************* Parâmetros ************************************** -->
					<tr>
						<td class="textoTitulo"><a onclick="javascript:trocaPagina('9');"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Mensagemi"></a> Parâmetros</td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><%if ("9".equals(pagina)) {%> <%@include
							file="cedente_consultar_guiaparametros.jsp"%> <%}%></td>
					</tr>
					
					<!-- ************************************************* Permissão ************************************** -->
					<tr>
						<td class="textoTitulo"><a onclick="javascript:trocaPagina('10');"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="10" name="outlineplus" id="Mensagemi"></a> Permissão Final</td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><%if ("10".equals(pagina)) {%> <%@include
							file="cedente_consultar_guiapermissao.jsp"%> <%}%></td>
					</tr>

					<!-- ************************************************* CONCLUSAO ************************************** -->
					<tr>
						<td class="textoTitulo"><a onclick="javascript:trocaPagina('8');"><img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Mensagemi"></a> Conclusão</td>
						<td colspan="3" class="textoValor">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4"><%if ("8".equals(pagina)) {%> <%@include
							file="cedente_consultar_guiaconc.jsp"%> <%}%></td>
					</tr>

					</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td align="right" colspan="4">
						<p align="center"><s:Button name="Alterar"
							action="javascript:formSubmit_Alterar();"
							userGroup="<%=usuarioBean.getNomeGrupo()%>"
							internalAction="cedente.cadastro.manter.alterar" /> <s:Button
							name="Excluir" action="javascript:formSubmit_Excluir();"
							userGroup="<%=usuarioBean.getNomeGrupo()%>"
							internalAction="cedente.cadastro.manter.excluir" /> <s:Button
							name="Voltar" action="javascript:formSubmit_Voltar();" /></p>
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
	    	if (document.frmMain.situacao.value == 'I') {
	    		document.frmMain.Excluir.disabled = true;
	    	}
			if (('<%=usuarioBean.getNomeGrupo()%>' == 'GCBOPE') &&
			    (<%=Integer.parseInt(usuarioBean.getCodigoUnidade())%>!=<%=cedGeralBean.getCodigoUnidadePVVinc()%>)){
	    		document.frmMain.Alterar.disabled = true;
			}
	    }

	    function formSubmit_Alterar() {
    	var confirma = true;
    	
    	if (document.frmMain.situacao.value == "I") {
    		confirma = confirm(conf('124', 'Cedente'));
    	}
    	
    	if (confirma) {
        	document.frmMain.estrategia.value="cedente.CedenteAlterarIniciar";
          document.frmMain.submit();
        }
	    }

	    function formSubmit_Voltar() {
	    	fecharJanelaTarifa();
	      document.frmMain.estrategia.value="cedente.CedenteManterFiltro";
	      document.frmMain.fluxo.value="voltar";
	      document.frmMain.submit();
	    }
	    
	    function formSubmit_Excluir() {
        var confirma = confirm(conf('102', 'Cedente'));
      
        if (confirma) {
        	fecharJanelaTarifa();
          document.frmMain.estrategia.value="cedente.CedenteExcluirFinalizar";
          document.frmMain.submit();
        }
	    }

	    function formSubmit_GrupoTarifas() {
				var valorAltura = 350;
				var valorLargura = 640;
				var valorTopo = (screen.height - valorAltura) /2;
				var valorEsquerda = (screen.width - valorLargura) /2;
	    
				janelaTarifa = window.open("<%=Paths.getRootForDynamicContent()%>/jump/cedente_consultar_tarifas_jump.jsp", "cedente_consultar_tarifas<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "height="+valorAltura+",width="+valorLargura+",top="+valorTopo+",left="+valorEsquerda+",toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=0");
				janelaTarifa.focus();
	    }

	    function fecharJanelaTarifa() {
	    	if (janelaTarifa != null && !janelaTarifa.closed) {
			   	janelaTarifa.close();
			  }
	    }
	    function trocaPagina(pagina){
	    	document.frmMain.estrategia.value='cedente.CedenteConsultarIniciar';
	    	document.frmMain.pagina.value=pagina;
	    	document.frmMain.submit();
	    }
    </script>

	</s:FormStrategy>
</p:Document>
</html>
