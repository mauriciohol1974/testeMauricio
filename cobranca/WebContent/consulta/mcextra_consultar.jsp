<%/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: mcextra_consultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 12/10/2004 - v1
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page
	import="br.gov.caixa.sigcb.estrategia.consulta.MCExtraEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.ConGerMovimentoCedenteBean"%>
<%@page import="br.com.politec.sao.business.util.BeanList"%>
<%@page import="java.util.ArrayList"%>




<%
CedenteCabecaBean cedCabBean = (session.getAttribute(MCExtraEstrategia.BEAN_CABECALHO) == null
                   ? new CedenteCabecaBean()
                   : (CedenteCabecaBean) session.getAttribute(MCExtraEstrategia.BEAN_CABECALHO));

            ConGerMovimentoCedenteBean debCredBean = (session.getAttribute(MCExtraEstrategia.BEAN_DEBCRED) == null
                    ? new ConGerMovimentoCedenteBean()
                    : (ConGerMovimentoCedenteBean) session.getAttribute(MCExtraEstrategia.BEAN_DEBCRED));

            ConGerMovimentoCedenteBean mcextraBean = (session.getAttribute(MCExtraEstrategia.BEAN_FILTRO) == null
                    ? new ConGerMovimentoCedenteBean()
                    : (ConGerMovimentoCedenteBean) session.getAttribute(MCExtraEstrategia.BEAN_FILTRO));

            int paginaAtual = 0;
            PageHolder paginacao = (PageHolder) session.getAttribute(MCExtraEstrategia.PAGINACAO_LIST);

            if (request.getParameter(MCExtraEstrategia.PAGINACAO_PAGE) != null
                && !request.getParameter(MCExtraEstrategia.PAGINACAO_PAGE)
                        .equals("")) {
                paginaAtual = Integer.parseInt((String) request.getParameter(MCExtraEstrategia.PAGINACAO_PAGE));
            } else {
                paginaAtual = Integer.parseInt((String) request.getAttribute(MCExtraEstrategia.PAGINACAO_PAGE));
            }
            List lista = paginacao.getPage(paginaAtual);
            List lista1 = (List) request.getAttribute("lista_titulo");
            
            ArrayList listaExtrato = (ArrayList) session.getAttribute("listaExtrato");
            
            String origem = (String) session.getAttribute("ORIGEM");
            
            String pagTroca  = (String) session.getAttribute("pagTroca");
            
            String totPagina = (String) session.getAttribute("totPagina");
            
            Integer totPag = Integer.parseInt(totPagina);
            
            Integer proxPag = Integer.parseInt(pagTroca) + 1;
            
            Integer pagAnterior = Integer.parseInt(pagTroca)-1;

            
            %>




<s:Header />
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=MCExtraEstrategia.STRATEGY_FILTRO%>" fluxo="normal">
		<s:Menu />
		<s:Titulo name="Consultar Movimento do Cedente (Extrato)" />

		<input type="hidden" name="<%=MCExtraEstrategia.PAGINACAO_PAGE%>"
			value="">
		<input type="hidden" name="codigoCedente"
			value="<%=pageContext.getRequest().getAttribute("codigoCedente") %>">
		<input type="hidden" name="dataEmissao"
			value="<%=pageContext.getRequest().getAttribute("dataEmissao") %>">
			
		<input type="hidden" name="pagina" value="1" />
		<input type="hidden" name="paginaFinal" value="0"> 
			

		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="3" cellpadding="0"
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
					<td class="textoTitulo" width="17%">Data:</td>
					<td class="textoValor" width="26%"></td>
				</tr>

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>

					<tr valign="top">
						<td colspan="4" class="textoTitulo">Consulta:
						<hr>
						</td>
					</tr>
						<%ConGerMovimentoCedenteBean occ = new ConGerMovimentoCedenteBean();%>
						
						
							 <% for (int i = 0; i < lista.size(); i++) {
	                        occ = (ConGerMovimentoCedenteBean) lista.get(i);
	                    %>
	                    
						<tr>
							<td colspan="4">
							<div class="group">
							<table width="100%" border="0 cellspacing=" 0" cellpadding="0"
								valign="middle" align="center">
								<tr>
									<td colspan="4">
									<table width="100%" border="0" cellspacing="1" cellpadding="0"
										valign="middle" align="left">
										<tr>
											<td class="textoTitulo" nowrap width="5%" align="left">Cod.Mov.:
											</td>
											<td class="textoValor" nowrap width="5%" align="left"><%=occ.getCodigoMovimento()%></td>
											<td class="textoTitulo" nowrap width="5%" align="left">Desc.Mov.:
											</td>
											<td class="textoValor" nowrap width="30%" align="left"><%=occ.getDescricaoMovimento()%></td>
											<td class="textoTitulo" nowrap width="5%" align="left">Nome
											Sacado:</td>
											<td class="textoValor" nowrap width="25%" align="left"><%=occ.getNomeSacado()%></td>
										</tr>
									</table>
									</td>
								</tr>
								<tr>
									<td colspan="4">
									<table width="100%" border="0" cellspacing="1" cellpadding="0"
										valign="middle" align="left">
										<tr>
											<td class="textoTitulo" nowrap width="5%" align="left">Data
											Venc.:</td>
											<td class="textoValor" nowrap width="12%" align="left"><%=occ.getDataVencimentoFormatada().equals(
	                                          "01/01/0001")
	                                ? ""
	                                : occ.getDataVencimentoFormatada()%></td>
											<td class="textoTitulo" nowrap width="5%" align="left">Data
											Movto.:</td>
											<td class="textoValor" nowrap width="12%" align="left"><%=occ.getDataMovimentoFormatada().equals(
	                                          "01/01/0001")
	                                ? ""
	                                : occ.getDataMovimentoFormatada()%></td>
											<td class="textoTitulo" nowrap width="5%" align="left">Data
											Pag.:</td>
											<td class="textoValor" nowrap width="12%" align="left"><%=occ.getDataPagamentoFormatada().equals(
	                                          "01/01/0001")
	                                ? ""
	                                : occ.getDataPagamentoFormatada()%></td>
											<td class="textoTitulo" nowrap width="10%" align="left">Nosso
											Número:</td>
											<td class="textoValor" nowrap width="25%" align="left"><%=occ.getNossoNumeroFormatado().equals("") ? "" : occ.getNossoNumero()%></td>
											<td class="textoTitulo" nowrap width="10%" align="left">Seu
											Número:</td>
											<td class="textoValor" nowrap width="25%" align="left"><%=occ.getSeuNumero()%></td>
										</tr>
									</table>
									</td>
								</tr>
								<tr>
									<td colspan="4">
									<table width="100%" border="0" cellspacing="1" cellpadding="0"
										valign="middle" align="left">
										<tr>
											<td class="textoTitulo" nowrap width="5%" align="left">Valor Título:</td>
											<td class="textoValor" nowrap width="20%" align="left"><%=occ.getValorTitulo()%></td>
											<td class="textoTitulo" nowrap width="5%" align="left">Valor Encargos:</td>
											<td class="textoValor" nowrap width="20%" align="left"><%=occ.getValorEncargos()%></td>
											<td class="textoTitulo" nowrap width="13%" align="left">Valor Abatimento:</td>
											<td class="textoValor" nowrap width="15%" align="left"><%=occ.getValorAbatimento()%></td>
											<td class="textoTitulo" nowrap width="8%" align="left">Valor Desconto:</td>
											<td class="textoValor" nowrap width="14%" align="left"><%=occ.getValorDesconto()%></td>
											<td class="textoTitulo" nowrap width="8%" align="left">Parcela:</td>
											<td class="textoValor" nowrap width="14%" align="left"><%=occ.getParcela()%></td>
										</tr>
									</table>
									</td>
								</tr>
								
								
								<tr>
									<td colspan="4">
									<table width="100%" border="0" cellspacing="1" cellpadding="0"
										valign="middle" align="left">
										<tr>
											<td class="textoTitulo" nowrap width="5%" align="left">Valor Crédito:</td>
											<td class="textoValor" nowrap width="15%" align="left"><%=occ.getValorCredito()%></td>
											<td class="textoTitulo" nowrap width="11%" align="left">Valor do IOF a ser retido:</td>
											<td class="textoValor" nowrap width="14%" align="left"><%=occ.getValorIOF()%></td>
											<td class="textoTitulo" nowrap width="5%" align="left">Data	Crédito:</td>
											<td class="textoValor" nowrap width="20%" align="left"><%=occ.getDataCreditoFormatada().equals("01/01/0001") ? "" : occ.getDataCreditoFormatada()%></td>
											<td class="textoTitulo" nowrap width="10%" align="left">Valor Tarifa:</td>
											<td class="textoValor" nowrap width="20%" align="left"><%=occ.getValorTarifa()%></td>
											<td class="textoTitulo" nowrap width="10%" align="left">Feriado Local:</td>
											<td class="textoValor" nowrap width="20%" align="left"><%=occ.getFeriadoLocal()%></td>
										</tr>
									</table>
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<table width="250" border="0" cellspacing="1" cellpadding="0"	align="left">
										<tr>
											<td class="textoTitulo" nowrap width="110" align="left">Número Identificação CIP:</td>
											<td class="textoValor" nowrap width="100" align="left"><%=occ.getNuIdentCIP().toString()%></td>
										</tr>
										</table>
									</td>
								</tr>
							</table>
							</div>
							</td>
						</tr>
	
						<%}
                    %>
							


					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					
					<%if (origem.equalsIgnoreCase("A")) {%>
					<tr>
							<td colspan="4" align="center"><s:ButtonPaginar
							pageNumber="<%=paginacao.getPageNumber()%>"
							numberOfPages="<%=paginacao.getPageCount()%>"
							pageName="<%=MCExtraEstrategia.PAGE_CONSULTAR%>" /></td>
							
						</td>
					</tr>
					<%} else{ %>
					
						<tr>
							<td colspan="4" align="center">
								<%if (pagAnterior>0) { %>
								<a href="javascript:trocapagina(<%=pagAnterior%>)">Anterior</a>
								<%} %>
								<% if(proxPag < totPag) {%>
								<a href="javascript:trocapagina(<%=proxPag%>)">Próxima</a>
								<%} %>
							</td>
						</tr>
						
					<%} %>
					
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="4" class="textoTitulo">Totais:
						<hr>
						</td>
					</tr>
					
					<tr>
						<td colspan="4"><s:Outline name="mcextra_lancamentos"
							title="Lançamento em Conta Corrente"
							imagePath="<%=Paths.getImagePath()%>" type="outline">
							<table width="95%" border="0" cellspacing="3" cellpadding="0"
								align="center" valign="middle">
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr class="headerLista">
									<td nowrap width="1%" align="center">&nbsp;</td>
									<td nowrap width="30%" align="left">Lançamentos para C/C</td>
									<td nowrap width="30%" align="left">Quantidade</td>
									<td nowrap width="30%" align="right">Valor</td>
								</tr>
								<tr class="line2">
									<td nowrap width="1%" align="center">&nbsp;</td>
									<td nowrap width="30%" align="left">Créditos no período</td>
									<td nowrap width="30%" align="left"><%=debCredBean.getQtdCreditoPeriodo()%></td>
									<td nowrap width="30%" align="right"><%=debCredBean.getValorCreditoPeriodo()%></td>
								</tr>
								<tr class="line0">
									<td nowrap width="1%" align="center">&nbsp;</td>
									<td nowrap width="30%" align="left">Débitos no período</td>
									<td nowrap width="30%" align="left"><%=debCredBean.getQtdDebitoPeriodo()%></td>
									<td nowrap width="30%" align="right"><%=debCredBean.getValorDebitoPeriodo()%></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
							</table>
						</s:Outline></td>
					</tr>

					<tr>
						<td colspan="4"><s:Outline name="mcextra_totais"
							title="Totais de Liquidação"
							imagePath="<%=Paths.getImagePath()%>" type="outline">
							<table width="95%" border="0" cellspacing="3" cellpadding="0"
								align="center" valign="middle">
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr class="headerLista">
									<td nowrap width="1%" align="center">&nbsp;</td>
									<td nowrap width="30%" align="left">Liquidações</td>
									<td nowrap width="30%" align="right">Quantidade</td>
									<td nowrap width="30%" align="right">Valor Recebido</td>
								</tr>

								<%PageHolder liquidacao = (PageHolder) session.getAttribute(MCExtraEstrategia.LIQUIDACAO_LIST);
                        List listaLiq = liquidacao.getPage(0);

                        ConGerMovimentoCedenteBean liq = new ConGerMovimentoCedenteBean();
                        for (int i = 0; i < listaLiq.size(); i++) {
                            liq = (ConGerMovimentoCedenteBean) listaLiq.get(i);

                            %>
								<tr class="line2">
									<td nowrap width="1%" align="center">&nbsp;</td>
									<td nowrap width="30%" align="left"><%=liq.getDescricaoCanal()%></td>
									<td nowrap width="30%" align="right"><%=liq.getQuantidade()%></td>
									<td nowrap width="30%" align="right"><%=liq.getValorRecebido()%></td>
								</tr>
								<%}%>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
							</table>
						</s:Outline></td>
					</tr>

					<tr>
						<td align="right" colspan="4">
						
						
						<p align="center">
						<s:Button name="Voltar" action="javascript:formSubmit_Voltar();" />
						<s:Button name="Imprimir" action="javascript:imprimirIntervalo();" />
						<s:Button name="Imprimir Tudo" action="javascript:imprimirTudo();" />
						</p>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<script>
   	function formSubmit(){}
	function inicia(){
        setFirstFieldFocus();
    }
    function formSubmit_Voltar() {
    	document.frmMain.estrategia.value='consulta.MCExtraManterIniciar';
    	document.frmMain.fluxo.value='voltar';
        document.frmMain.submit();
    }
    
    function imprimir() {
		alert("Imprimindo Aguarde.....");
		var valorAltura = 350;
		var valorLargura = 640;
		var valorTopo = (screen.height - valorAltura) /2;
		var valorEsquerda = (screen.width - valorLargura) /2;

		janela = window.open("<%=Paths.getRootForDynamicContent()%>/jump/imp_extrato_jump.jsp");
		janela.focus();
    }
    
    
    function imprimirIntervalo() {		
		var valorAltura = 350;
		var valorLargura = 640;
		var valorTopo = (screen.height - valorAltura) /2;
		var valorEsquerda = (screen.width - valorLargura) /2;
		var pagIni=prompt("Informe a pagina inicial","1");
		var pagFim=prompt("Informe a pagina final","1");
		document.frmMain.pagina.value=pagIni;
		document.frmMain.paginaFinal.value=pagFim;
		janela = window.open("/cobranca/jump/imp_extrato_jump.jsp");
		janela.focus();
    }
    
    function imprimirTudo() {		
		var valorAltura = 350;
		var valorLargura = 640;
		var valorTopo = (screen.height - valorAltura) /2;
		var valorEsquerda = (screen.width - valorLargura) /2;
		document.frmMain.pagina.value="1";
		document.frmMain.paginaFinal.value="9999999";
		janela = window.open("/cobranca/jump/imp_extrato_jump.jsp");
		janela.focus();
    }
    
    function trocapagina(pag){
       	document.frmMain.pagina.value=pag
        document.frmMain.submit();
    }

    
    
    </script>
	</s:FormStrategy>
</p:Document>
</html>
