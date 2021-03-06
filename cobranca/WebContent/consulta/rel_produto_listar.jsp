
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ConsRelatorioEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.RelatorioBean "%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.List"%>

<%	RelatorioBean filtroBean = (session.getAttribute(ConsRelatorioEstrategia.FILTRO_BEAN) == null
 	? new RelatorioBean() : (RelatorioBean) session.getAttribute(ConsRelatorioEstrategia.FILTRO_BEAN));


            int paginaAtual = 0;
            PageHolder paginacao = (PageHolder) session.getAttribute(ConsRelatorioEstrategia.PAGINACAO_LIST);

            if (request.getParameter(ConsRelatorioEstrategia.PAGINACAO_PAGE) != null
                && !request.getParameter(ConsRelatorioEstrategia.PAGINACAO_PAGE)
                        .equals("")) {
                paginaAtual = Integer.parseInt((String) request.getParameter(ConsRelatorioEstrategia.PAGINACAO_PAGE));
            } else {
                paginaAtual = Integer.parseInt((String) request.getAttribute(ConsRelatorioEstrategia.PAGINACAO_PAGE));
            }
            List lista = paginacao.getPage(paginaAtual);

            %>

<s:Header />
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=ConsRelatorioEstrategia.STRATEGY_DETALHE_PRODUTO%>" fluxo="normal">
		<s:Menu />
		<s:Titulo name="<%=ConsRelatorioEstrategia.PAGE_TITLE_LISTAR_PRODUTO%>" />

		<input type="hidden" name="<%=ConsRelatorioEstrategia.PAGINACAO_PAGE%>"	value="">
		
		<input type="hidden" name="unidade"	value="">
		<input type="hidden" name="produto"	value="<%=filtroBean.getProduto()%>">
		<input type="hidden" name="data"	value="<%=filtroBean.getDataFormatada()%>">
		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="1" cellpadding="0"
					height=53 valign="middle" align="center">

				

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>

					<tr valign="top">
						<td colspan="5" class="textoTitulo">Consulta por Produto e Data de Movimento:
						<hr>
						</td>
					</tr>

					<tr>
						<td colspan="4">
						<table width="100%" border="0" cellspacing="3" cellpadding="0"
							align="center" valign="middle">
							<tr class="headerLista">
								<td width="5%" align="right" nowrap>&nbsp;</td>
								<td nowrap width="10%" align="right">&nbsp;Agencia&nbsp;</td>
								<td nowrap width="25%" align="right">&nbsp;Qtde. T�tulos Liq.&nbsp;</td>
								<td nowrap width="25%" align="left">&nbsp;Valor Total&nbsp;</td>
								

							</tr>
							<%RelatorioBean occ = new RelatorioBean();
                    for (int i = 0; i < lista.size(); i++) {
                        occ = (RelatorioBean) lista.get(i);

                        %>
							<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td width="5%" align="right" nowrap><input type="radio"
									name="rdo"
									onclick="javascript: clickRadio('<%=occ.getUnidade()%>')">
								</td>
								<td nowrap width="20%" align="right" nowrap>&nbsp;<%=occ.getUnidade()%>&nbsp;</td>
								<td nowrap width="30%" align="right" nowrap>&nbsp;<%=occ.getQtdeLiq()%>&nbsp;</td>
								<td nowrap width="30%" align="left" nowrap>&nbsp;<%=occ.getValorLiq()%>&nbsp;</td>
								

							</tr>

							<%}

                    %>
							<tr>
								<td colspan="6">&nbsp;</td>
							</tr>


							<tr>
								<td colspan="5">&nbsp;</td>
							</tr>
							<tr>
								<td align="right" colspan="6">
								<p align="center"><s:Button name="Ok" action="javascript:formSubmit()" /> 
									<s:Button name="Exportar"	action="javascript:arquivo()" /> 
									<s:Button name="Voltar"	action="javascript:formSubmit_Voltar()" /></p>
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

        document.frmMain.estrategia.value = "<%=ConsRelatorioEstrategia.STRATEGY_INICIAR_PRODUTO%>";  			
        document.frmMain.fluxo.value = "voltar";
       	document.frmMain.submit();
	    }
	    
	    function arquivo() {

	        document.frmMain.estrategia.value = "<%=ConsRelatorioEstrategia.STRATEGY_ARQUIVO_PRODUTO%>";  			
	       	document.frmMain.submit();
		}
	    
	    function formSubmit(){
	    	document.frmMain.estrategia.value =="<%=ConsRelatorioEstrategia.STRATEGY_DETALHE_PRODUTO%>" 
	    	document.frmMain.submit();

	    }
	    
	    function clickRadio(unidade) {
		  	document.frmMain.unidade.value = unidade;
		  	
     	}
     	

	    
    </script>
	</s:FormStrategy>
</p:Document>
</html>
