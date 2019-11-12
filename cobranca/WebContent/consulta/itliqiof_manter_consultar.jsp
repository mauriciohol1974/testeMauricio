<%/***********************************************
*Probank
*Projeto CAIXA - SIGCB
*Componente: titliqiof_erro.jsp - Java Server Pages
*Autor: Adelaine Rondon - adelaine.rondon@probank.com.br
*Ultima Atualização: 11/01/2011
************************************************/

            %>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TitLiqIOFManterEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosIOFBean" %>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.UtilDatas"%>
<%@page import="java.util.List"%>

<%ConGerTitulosLiquidadosIOFBean filtroBean = (session.getAttribute(TitLiqIOFManterEstrategia.FILTRO_BEAN) == null
                    ? new ConGerTitulosLiquidadosIOFBean()
                    : (ConGerTitulosLiquidadosIOFBean) session.getAttribute(TitLiqIOFManterEstrategia.FILTRO_BEAN));

            CedenteCabecaBean cedCabBean = (session.getAttribute(TitLiqIOFManterEstrategia.CABECALHO_BEAN) == null
                    ? new CedenteCabecaBean()
                    : (CedenteCabecaBean) session.getAttribute(TitLiqIOFManterEstrategia.CABECALHO_BEAN));
            int paginaAtual = 0;
            PageHolder paginacao = (PageHolder) session.getAttribute(TitLiqIOFManterEstrategia.PAGINACAO_LIST);

            if (request.getParameter(TitLiqIOFManterEstrategia.PAGINACAO_PAGE) != null
                && !request.getParameter(TitLiqIOFManterEstrategia.PAGINACAO_PAGE)
                        .equals("")) {
                paginaAtual = Integer.parseInt((String) request.getParameter(TitLiqIOFManterEstrategia.PAGINACAO_PAGE));
            } else {
                paginaAtual = Integer.parseInt((String) request.getAttribute(TitLiqIOFManterEstrategia.PAGINACAO_PAGE));
            }
            List lista = paginacao.getPage(paginaAtual);

            %>

<s:Header />
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="consulta.TitLiqDConsultarDetIniciar" fluxo="normal">
		<s:Menu />
		<s:Titulo name="Consultar Títulos Liquidados no Dia" />

		<input type="hidden"
			name="<%=TitLiqIOFManterEstrategia.PAGINACAO_PAGE%>" value="">
		<input type="hidden" name="codigoCedente"
			value="<%=filtroBean.getCodigoCedente() %>">
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
						<td class="textoTitulo" width="17%">Data Crédito:</td>
						<td class="textoValor" width="26%"><%=UtilDatas.getToday()%></td>
					</tr>

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>

					<tr valign="top">
						<td colspan="5" class="textoTitulo">Titulos Liquidados com Retenção de IOF:
						<hr>
						</td>
					</tr>

					<tr>
						<td colspan="4">
						<table width="100%" border="0" cellspacing="3" cellpadding="0"
							align="center" valign="middle">
							<tr class="headerLista">
								<td width="2%" align="right" nowrap>&nbsp;</td>
								<td nowrap width="15%" align="right">Meio Liquidação</td>
								<td nowrap width="15%" align="right">Tipo Pagamento</td>
								<td nowrap width="15%" align="left">Quantidade</td>
								<td nowrap width="15%" align="left">Valor Título</td>
								<td nowrap width="15%" align="left">Valor Creditado</td>
								<td nowrap width="15%" align="left">Valor Total IOF</td>
								<td width="2%" align="right" nowrap>&nbsp;</td>
							</tr>
							<%ConGerTitulosLiquidadosIOFBean occ = new ConGerTitulosLiquidadosIOFBean();
                    for (int i = 0; i < lista.size(); i++) {
                        occ = (ConGerTitulosLiquidadosIOFBean) lista.get(i);

                        %>
							<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td width="2%" align="right" nowrap>&nbsp;</td>
								<td width="15%" align="right" nowrap><%=occ.getCanalLiquidacao()%></td>
								<td width="15%" align="right" nowrap><%=occ.getTipoPagamento()%></td>
								<td width="15%" align="left" nowrap><%=occ.getValorTitulos()%></td>
								<td width="15%" align="left" nowrap><%=occ.getValorCreditado()%></td>
								<td width="15%" align="left" nowrap><%=occ.getValorTotalIOF()%></td>
								<td width="2%" align="right" nowrap>&nbsp;</td>
							</tr>

							<%}

                    %>
							<tr>
								<td colspan="5">&nbsp;</td>
							</tr>
							<tr>
								<td align="right" colspan="5">
								<p align="center"><s:Button name="Voltar"
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
  			document.frmMain.estrategia.value = "consulta.TitLiqIOFManterIniciar";
        	document.frmMain.fluxo.value = "voltar";
       		document.frmMain.submit();
	    }
	    
//	    function clickRadio(nossoNumero) {
//		  	document.frmMain.nossoNumero.value = nossoNumero;
//     	}
     	
    </script>
	</s:FormStrategy>
</p:Document>
</html>
