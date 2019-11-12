<%/**
 * <B>Projeto: SIGCB - DDA</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta >> DDA
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */

            %>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.DdaTituloDiaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page
	import="br.gov.caixa.sigcb.estrategia.consulta.DdaTitIncluidoEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.List"%>

<%DdaTituloDiaBean filtroBean = (session.getAttribute(DdaTitIncluidoEstrategia.FILTRO_BEAN) == null
                    ? new DdaTituloDiaBean()
                    : (DdaTituloDiaBean) session.getAttribute(DdaTitIncluidoEstrategia.FILTRO_BEAN));

            CedenteCabecaBean cedCabBean = (session.getAttribute(DdaTitIncluidoEstrategia.CABECALHO_BEAN) == null
                    ? new CedenteCabecaBean()
                    : (CedenteCabecaBean) session.getAttribute(DdaTitIncluidoEstrategia.CABECALHO_BEAN));
            int paginaAtual = 0;
            PageHolder paginacao = (PageHolder) session.getAttribute(DdaTitIncluidoEstrategia.PAGINACAO_LIST);

            if (request.getParameter(DdaTitIncluidoEstrategia.PAGINACAO_PAGE) != null
                && !request.getParameter(DdaTitIncluidoEstrategia.PAGINACAO_PAGE)
                        .equals("")) {
                paginaAtual = Integer.parseInt((String) request.getParameter(DdaTitIncluidoEstrategia.PAGINACAO_PAGE));
            } else {
                paginaAtual = Integer.parseInt((String) request.getAttribute(DdaTitIncluidoEstrategia.PAGINACAO_PAGE));
            }
            List lista = paginacao.getPage(paginaAtual);

            %>

<s:Header />
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="consulta.DdaTitAlteradoConsultar" fluxo="normal">
		<s:Menu />
		<s:Titulo name="DDA >> Consultar Títulos Alterados" />

		<input type="hidden" name="<%=DdaTitIncluidoEstrategia.PAGINACAO_PAGE%>"
			value="">
		<input type="hidden" name="codigoCedente"
			value="<%=cedCabBean.getCodigoCedente()%>">
		<input type="hidden" name="nossoNumero" value="">
		<input type="hidden" name="dataPagamento"
			value="<%=filtroBean.getDataPagamentoFormatada()%>">
		<input type="hidden" name="sequencialDia" value="">
		<input type="hidden" name="tpConsulta"
			value="<%=filtroBean.getTpConsulta() %>">

		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="1" cellpadding="0"
					height=53 valign="middle" align="center">

					<tr>
						<td class="textoTitulo" width="17%">Cedente:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
						<td class="textoTitulo" width="17%">Nome Cedente:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Tipo Pessoa:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
						<td class="textoTitulo" width="17%">CPF/CNPJ:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Código Cliente (COCLI):</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td>
						<td class="textoTitulo" width="17%">Data Pagamento:</td>
						<td class="textoValor" width="26%"><%=filtroBean.getDataPagamentoFormatada()%></td>
					</tr>

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>

					<tr valign="top">
						<td colspan="5" class="textoTitulo">Titulos:
						<hr>
						</td>
					</tr>

					<tr>
						<td colspan="4">
						<table width="100%" border="0" cellspacing="3" cellpadding="0"
							align="center" valign="middle">
							<tr class="headerLista">
								<td width="5%" align="right" nowrap>&nbsp;</td>
								<td nowrap width="20%" align="right">&nbsp;Nosso Número&nbsp;</td>
								<td nowrap width="30%" align="right">&nbsp;Valor Título&nbsp;</td>
								<td nowrap width="30%" align="left">&nbsp;Data Vencimento&nbsp;</td>
								<td nowrap width="10%" align="left">&nbsp;Nome Sacado&nbsp;</td>
								<td nowrap width="10%" align="left">Parcela</td>
							</tr>
							<%DdaTituloDiaBean occ = new DdaTituloDiaBean();
                    for (int i = 0; i < lista.size(); i++) {
                        occ = (DdaTituloDiaBean) lista.get(i);

                        %>
							<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td width="5%" align="right" nowrap><input type="radio"
									name="rdo"
									onclick="javascript: clickRadio('<%=occ.getNossoNumero()%>')";>
								</td>
								<td nowrap width="20%" align="right" nowrap>&nbsp;<%=occ.getNossoNumero()%>&nbsp;</td>
								<td nowrap width="30%" align="right" nowrap>&nbsp;<%=occ.getValorPagamento()%>&nbsp;</td>
								<td nowrap width="30%" align="left" nowrap>&nbsp;<%=occ.getDataPagamentoFormatada()%>&nbsp;</td>
								<td nowrap width="10%" align="left" nowrap>&nbsp;<%=occ.getNomeFantasia()%>&nbsp;</td>
								<td nowrap width="10%" align="left" nowrap>&nbsp;<%=occ.getParcela()%></td>
							</tr>

							<%}

                    %>
							<tr>
								<td colspan="6">&nbsp;</td>
							</tr>

							<tr>
								<td colspan="6" align="center"><%String pageName = DdaTitIncluidoEstrategia.PAGE_DDA_LISTA_CED_A;%>
								<!-- s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=pageName%>"/--><s:paginacao
									estrategia="consulta.DdaTitAlteradoManterFiltro" /></td>
							</tr>
							<tr>
								<td colspan="5">&nbsp;</td>
							</tr>
							<tr>
								<td align="right" colspan="6">
								<p align="center"><s:Button name="Ok"
									action="javascript:formSubmit()" /> <s:Button name="Voltar"
									action="javascript:formSubmit_Voltar()" /></p>
								</td>
							</tr>
							<tr>
								<td colspan="5">&nbsp;</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<script>
	    function inicia(){
		    setFirstFieldFocus();
	    }
	    function formSubmit_Voltar() {
  			<%// 23/08
  			//document.frmMain.estrategia.value = "consulta.TitLiqManterIniciar";%>
        document.frmMain.estrategia.value = "consulta.DdaTitAlteradoManterFiltro";  			
        document.frmMain.fluxo.value = "voltar";
       	document.frmMain.submit();
	    }
	    
	    function formSubmit(){
	    	if(validaSubmit()){
	    		document.frmMain.submit();
	    	}
	    }
	    
	    function clickRadio(nossoNumero) {
		  	document.frmMain.nossoNumero.value = nossoNumero;
		  	//document.frmMain.sequencialDia.value = sequencialDia;
     	}
     	
     	function validaSubmit(){
				<%if(paginacao.getCurrentPageSize() > 1){%>
			    if(!validaRadioButton(document.frmMain.rdo, '')){
					  return false;
			    }
				<%} else {%>
					if(! document.frmMain.rdo.checked){
						msg('003', '');
						return;
					}
				<%}%>
			    return true;
			}
	    
    </script>
	</s:FormStrategy>
</p:Document>
</html>
