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

  List decendios = (session.getAttribute(TitLiqIOFManterEstrategia.LISTA_DECENDIOS) == null
                    ? Collections.EMPTY_LIST
         		    : (List) session.getAttribute(TitLiqIOFManterEstrategia.LISTA_DECENDIOS));
%>

<s:Header />
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="consulta.TitLiqIOFManterEstrategia" fluxo="normal">
		<s:Menu />
		<s:Titulo name="Consultar Títulos Liquidados com Retenção de IOF" />

		<input type="hidden" name="informacao" value="<%=filtroBean.getInformacao() %>">
		<input type="hidden" name="tipoInformacao" value="<%=filtroBean.getTipoInformacao() %>">
		<input type="hidden" name="mes" value="<%=filtroBean.getMes() %>">
		<input type="hidden" name="ano" value="<%=filtroBean.getAno() %>">
		<input type="hidden" name="nome" value="<%=filtroBean.getNome() %>">

		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="1" cellpadding="0"
					height=53 valign="middle" align="center">

					<% if (filtroBean.getTipoInformacao() == 1) {%>
						<tr>
							<td class="textoTitulo" width="17%">Cedente:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getInformacao()%></td>
							<td class="textoTitulo" width="17%">Nome Cedente:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getNome()%></td>
						</tr>
					<%} else if (filtroBean.getTipoInformacao() == 2) {%>
						<tr>
							<td class="textoTitulo" width="17%">PV:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getInformacao()%></td>
							<td class="textoTitulo" width="17%">Nome Unidade:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getNome()%></td>
						</tr>
					<%} else if (filtroBean.getTipoInformacao() == 3) {%>	
						<tr>
							<td class="textoTitulo" width="17%">SR:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getInformacao()%></td>
							<td class="textoTitulo" width="17%">Nome Unidade:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getNome()%></td>
						</tr>
					<%} else {%>	
						<tr>
							<td class="textoTitulo" width="17%">Consulta:</td>
							<td class="textoValor" width="26%" colspan=3>CAIXA</td>
						</tr>
					<%} %>	
					<tr>
						<td class="textoTitulo" width="17%">Mes/Ano:</td>
						<td class="textoValor" width="26%"><%= String.format("%02d", filtroBean.getMes()) + "/" + String.format("%04d", filtroBean.getAno()) %></td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
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
						<td colspan="5">

					<%
					ConGerTitulosLiquidadosIOFBean occ = new ConGerTitulosLiquidadosIOFBean();
                    for (int i = 0; i < decendios.size(); i++) {
                    	List decendio = (List) decendios.get(i);
                    	for (int j = 0; j < decendio.size(); j++) {
	                        occ = (ConGerTitulosLiquidadosIOFBean) decendio.get(j);
	                        if (j != decendio.size() - 1) {
	                        	if (j == 0) {
                    %>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0"
							align="left" valign="middle">
							<tr class="headerLista">
		                    	<td align="left">&nbsp;&nbsp;Decendio de <%= i == 0 ? "01 a 10" : i == 1 ? "11 a 20" : "21 a 31" %></td>
		                    </tr>
		                    <tr>
		                    	<td>

						<table width="100%" border="0" cellspacing="3" cellpadding="0"
							align="center" valign="middle">
							<tr class="headerLista">
								<td nowrap width="15%" align="left">Meio Liquidação</td>
								<td nowrap width="15%" align="left">Tipo Pagamento</td>
								<td nowrap width="15%" align="left">Quantidade</td>
								<td nowrap width="15%" align="right">Valor Título</td>
								<td nowrap width="15%" align="right">Valor Creditado</td>
								<td nowrap width="15%" align="right">Valor Total IOF</td>
							</tr>
					<%
								} 
					%>
							<tr <%= ( ((j+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td nowrap width="15%" align="left"><%=occ.getFormaCanal()%></td>
								<td nowrap width="15%" align="left"><%=occ.getFormaTipoPagamento()%></td>
								<td nowrap width="15%" align="right"><%=occ.getQuantidadeTitulos()%></td>
								<td nowrap width="15%" align="right"><%=occ.getValorTitulo()%></td>
								<td nowrap width="15%" align="right"><%=occ.getValorCreditado()%></td>
								<td nowrap width="15%" align="right"><%=occ.getValorIOF()%></td>
							</tr>
					<%
							} else {
								/* os totais de cada decendio foram inseridos nas listas como os valores normais */
								/* mais detalhes em TitLiqIOFManterFiltro.java#separarDecendios */
                    %>
							<tr <%= ( ((j+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td nowrap align="left" colspan="2"><b>TOTAL</b></td>
								<td nowrap align="right" nowrap><b><%=occ.getQuantidadeTitulos()%></b></td>
								<td nowrap align="right" nowrap><b><%=occ.getValorTitulo()%></b></td>
								<td nowrap align="right" nowrap><b><%=occ.getValorCreditado()%></b></td>
								<td nowrap align="right" nowrap><b><%=occ.getValorIOF()%></b></td>
							</tr>
							<tr>
								<td colspan=6>&nbsp;</td>
							</tr>
						</table>
					<%
							}
                    	}
                    }
                    %>
                    		</td>
                    	</tr>
                    	</table>
               			</td>
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
  			document.frmMain.estrategia.value = "consulta.TitLiqIOFManterIniciar";
        	document.frmMain.fluxo.value = "voltar";
       		document.frmMain.submit();
	    }
     	
    </script>
	</s:FormStrategy>
</p:Document>
<%@page import="java.util.Collections"%>
</html>
