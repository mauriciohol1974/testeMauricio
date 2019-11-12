<%/***********************************************
             *Politec - Filial São Paulo
             *Fabrica de Projetos - Junho de 2004
             *Projeto CAIXA - SIGCB
             *Componente: titliqd_manter_filtro.jsp - Java Server Pages
             *Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
             *Ultima Atualização: 06/10/2004 - v1
             ************************************************/

            %>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosDiaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page
	import="br.gov.caixa.sigcb.estrategia.consulta.TitLiqDManterEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.UtilDatas"%>
<%@page import="java.util.List"%>

<%ConGerTitulosLiquidadosDiaBean filtroBean = (session.getAttribute(TitLiqDManterEstrategia.FILTRO_BEAN) == null
                    ? new ConGerTitulosLiquidadosDiaBean()
                    : (ConGerTitulosLiquidadosDiaBean) session.getAttribute(TitLiqDManterEstrategia.FILTRO_BEAN));

            CedenteCabecaBean cedCabBean = (session.getAttribute(TitLiqDManterEstrategia.CABECALHO_BEAN) == null
                    ? new CedenteCabecaBean()
                    : (CedenteCabecaBean) session.getAttribute(TitLiqDManterEstrategia.CABECALHO_BEAN));
            int paginaAtual = 0;
            PageHolder paginacao = (PageHolder) session.getAttribute(TitLiqDManterEstrategia.PAGINACAO_LIST);

            if (request.getParameter(TitLiqDManterEstrategia.PAGINACAO_PAGE) != null
                && !request.getParameter(TitLiqDManterEstrategia.PAGINACAO_PAGE)
                        .equals("")) {
                paginaAtual = Integer.parseInt((String) request.getParameter(TitLiqDManterEstrategia.PAGINACAO_PAGE));
            } else {
                paginaAtual = Integer.parseInt((String) request.getAttribute(TitLiqDManterEstrategia.PAGINACAO_PAGE));
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
			name="<%=TitLiqDManterEstrategia.PAGINACAO_PAGE%>" value="">
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
						<td colspan="5" class="textoTitulo">Titulos Liquidados no Dia:
						<hr>
						</td>
					</tr>

					<tr>
						<td colspan="4">
						<table width="100%" border="0" cellspacing="3" cellpadding="0"
							align="center" valign="middle">
							<tr class="headerLista">
								<td width="2%" align="right" nowrap>&nbsp;</td>

								<td nowrap width="20%" align="right">Nosso Número</td>
								<td nowrap width="20%" align="right">Valor Pagamento</td>
								<td nowrap width="20%" align="left">Meio Liquidação</td>
								<td nowrap width="20%" align="left">Forma</td>
								<td width="2%" align="right" nowrap>Parcela</td>
							</tr>
							<%ConGerTitulosLiquidadosDiaBean occ = new ConGerTitulosLiquidadosDiaBean();
                    for (int i = 0; i < lista.size(); i++) {
                        occ = (ConGerTitulosLiquidadosDiaBean) lista.get(i);

                        %>
							<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td width="2%" align="right" nowrap>&nbsp;</td>
								<td width="20%" align="right" nowrap><%=occ.getNossoNumero()%></td>
								<td width="20%" align="right" nowrap><%=occ.getValorPagamento()%></td>
								<td width="20%" align="left" nowrap><%=occ.getMeioLiquidacao()%></td>
								<td width="20%" align="left" nowrap><%=occ.getFormaLiquidacaoFormatada()%></td>
								<td width="5%" align="right" nowrap><%=occ.getParcela()%></td>
							</tr>

							<%}

                    %>
							<tr>
								<td colspan="5">&nbsp;</td>
							</tr>

							<tr>
								<td colspan="5" align="center"><%String pageName = TitLiqDManterEstrategia.PAGE_LIQD_LISTA_CED;%>
								<!-- s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=pageName%>"/--><s:paginacao
									estrategia="consulta.TitLiqDManterFiltro" /></td>
							</tr>
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
  			document.frmMain.estrategia.value = "consulta.TitLiqDManterIniciar";
        document.frmMain.fluxo.value = "voltar";
       	document.frmMain.submit();
	    }
	    
	    function clickRadio(nossoNumero) {
		  	document.frmMain.nossoNumero.value = nossoNumero;
     	}
     	
    </script>
	</s:FormStrategy>
</p:Document>
</html>
