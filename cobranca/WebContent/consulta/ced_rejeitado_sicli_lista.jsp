<script language="javascript">
	history.go(+1);
</script>

<%
	 /***********************************************
	 *Politec - Filial São Paulo
	 *Fabrica de Projetos - Outubro de 2004
	 *Projeto CAIXA - SIGCB
	 *Componente: cedbcos_manter_filtro.jsp - Java Server Pages
	 *Autor: Andrew Betencourt - p911883@mail.caixa
	 *Ultima Atualização: 28/10/2004
	 ************************************************/
%>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.CedRejeitadoSicliEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteRejeitadoSicliBean"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session
			.getAttribute(CedRejeitadoSicliEstrategia.PAGINACAO_LIST);
	if (request
			.getParameter(CedRejeitadoSicliEstrategia.PAGINACAO_PAGE) != null
			&& !request.getParameter(
			CedRejeitadoSicliEstrategia.PAGINACAO_PAGE).equals(
			"")) {
		paginaAtual = Integer
		.parseInt((String) request
				.getParameter(CedRejeitadoSicliEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer
		.parseInt((String) request
				.getAttribute(CedRejeitadoSicliEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPageCount() == 0 ? new LinkedList()
			: paginacao.getPage(paginaAtual);

	CedenteRejeitadoSicliBean cedenteRejeitadoBean = (CedenteRejeitadoSicliBean) session
			.getAttribute("CedenteRejeitadoSicliBean");
%>


<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia='<%=CedRejeitadoSicliEstrategia.STRATEGY_MANTER_RETORNO%>'
		fluxo="voltar">
		<s:Menu />
		<s:Titulo name='<%=CedRejeitadoSicliEstrategia.PAGE_TITLE_FILTRO%>' />
		<input type="hidden" name="codigoPv"
			value="<%=request.getParameter("codigoPv")%>">
		<input type="hidden" name="numeroCocli">
		<input type="hidden" name="nomeCedente">
		<input type="hidden" name="dataInclusao">
		<input type="hidden"
			name="<%=CedRejeitadoSicliEstrategia.PAGINACAO_PAGE%>" value="">
		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="1" cellpadding="0"
					height=53 valign="middle" align="center">

					<tr>
						<td class="textoTitulo" width="80">PV Vinculado</td>
						<td class="textoValor"><%=request.getParameter("codigoPv") + " - "
							+ cedenteRejeitadoBean.getNomePv()%></td>
					</tr>

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="5" class="textoTitulo">Consulta:
						<hr>
						</td>
					</tr>

					<tr>
						<td colspan="4">
						<table width="100%" border="0" cellspacing="3" cellpadding="0"
							align="center" valign="middle">
							<tr class="headerLista">
								<td nowrap width="2%" align="center">&nbsp;</td>
								<td nowrap width="20%" align="left">Cedente</td>
								<td nowrap align="left">Nome Cedente</td>
								<td nowrap width="18%" align="left">Código do
								Cliente(COCLI)</td>
								<td nowrap width="18%" align="left">Data Inclusão</td>
							</tr>
							<%
										SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
										SimpleDateFormat dateFormat = new SimpleDateFormat(
										"dd/MM/yyyy");
										CedenteRejeitadoSicliBean bean = new CedenteRejeitadoSicliBean();
										for (int i = 0; i < lista.size(); i++) {
									bean = (CedenteRejeitadoSicliBean) lista.get(i);
									//String dataInclusao = dateFormat.format(sd.parse(bean.getDataInclusao()));
									String dataInclusao = dateFormat.format(sd.parse(bean
											.getDataInclusao().toString()));
							%>
							<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td width="1%" align="center"><input type="radio"
									name="numeroCedente" value="<%=bean.getNumeroCedente()%>"
									cocli="<%=bean.getNumeroCocli()%>"
									nomeCedente="<%=bean.getNomeCedente()%>"
									dataInclusao="<%=bean.getDataInclusao()%>"
									onclick="escolheCedente(this)"></td>
								<td width="20%" align="left"><%=bean.getNumeroCedente()%></td>
								<td width="20%" align="left"><%=bean.getNomeCedente()%></td>
								<td width="10%" align="left"><%=bean.getNumeroCocli()%></td>
								<td width="10%" align="left"><%=dataInclusao%></td>
							</tr>
							<%
							}
							%>

							<tr>
								<td colspan="7">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="7" align="center"><s:ButtonPaginar
									pageNumber="<%=paginacao.getPageNumber()%>"
									numberOfPages="<%=paginacao.getPageCount()%>"
									pageName="<%=CedRejeitadoSicliEstrategia.PAGE_JSP_LISTAR%>" />
								</td>
							</tr>
							<tr>
								<td colspan="7">&nbsp;</td>
							</tr>
							<tr>
								<td align="right" colspan="7">
								<p align="center"><input type="button" class="button"
									name="Ok" value="Ok" onclick="javascript:formSubmit_OK();">
								<input type="button" class="button" name="Voltar" value="Voltar"
									onclick="javascript:formSubmit_Voltar();"></p>
								</td>
							</tr>
							<tr>
								<td colspan="8">&nbsp;</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
	</s:FormStrategy>
</p:Document>
</html>
<script language="javascript">
    function inicia(){
        //loadMenus();
        document.frmMain.numeroCocli.value = "";
    }

    function escolheCedente(campo) {
    	document.frmMain.numeroCocli.value = campo.cocli;
    	document.frmMain.nomeCedente.value = campo.nomeCedente;
    	document.frmMain.dataInclusao.value = campo.dataInclusao;
    }
    
    function formSubmit_Voltar() {
		document.frmMain.estrategia.value = "<%=CedRejeitadoSicliEstrategia.STRATEGY_MANTER_FILTRO%>";
		document.frmMain.submit();
    }
 
 	    function formSubmit_OK() {
 	    	if(document.frmMain.numeroCocli.value == "") {
 	    		alert("Favor selecionar um Cedente!");
 	    		return;
 	    	}
       	document.frmMain.submit();
    }
    function validaInserir(){
        return true;
    }
</script>
