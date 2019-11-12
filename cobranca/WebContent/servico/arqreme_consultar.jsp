<%/***********************************************
             *Politec - Filial São Paulo
             *Fabrica de Projetos - Outubro de 2004
             *Projeto CAIXA - SIGCB
             *Componente: arqreme_consultar.jsp - Java Server Pages
             *Autor: JE
             *Ultima Atualização: 28/10/2004
             ************************************************/
            %>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ArquivoRemessaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ArqRemeEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="java.util.List"%>
<%ArquivoRemessaBean arqBean = (session.getAttribute(ArqRemeEstrategia.DATA_BEAN) == null
                    ? new ArquivoRemessaBean()
                    : (ArquivoRemessaBean) session.getAttribute(ArqRemeEstrategia.DATA_BEAN));
            CedenteCabecaBean cedCabBean = (session.getAttribute(ArqRemeEstrategia.CEDENTE_CABECALHO_BEAN) == null
                    ? new CedenteCabecaBean()
                    : (CedenteCabecaBean) session.getAttribute(ArqRemeEstrategia.CEDENTE_CABECALHO_BEAN));
            PageHolder paginacao = (PageHolder) session.getAttribute(ArqRemeEstrategia.PAGINACAO_LIST
                                                                     + "1");

            int paginaAtual = 0;
            if (request.getParameter(ArqRemeEstrategia.PAGINACAO_PAGE) != null
                && !request.getParameter(ArqRemeEstrategia.PAGINACAO_PAGE)
                        .equals("")) {
                paginaAtual = Integer.parseInt((String) request.getParameter(ArqRemeEstrategia.PAGINACAO_PAGE));
            } else {
                paginaAtual = Integer.parseInt((String) request.getAttribute(ArqRemeEstrategia.PAGINACAO_PAGE));
            }
            List lista = paginacao.getPage(paginaAtual);

            %>


<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=ArqRemeEstrategia.STRATEGY_MANTER_FILTRO %>"
		fluxo="normal">
		<s:Menu />
		<s:Titulo name="<%=ArqRemeEstrategia.PAGE_TITLE_MANTER_DETALHE%>" />

		<input type="hidden" name="<%=ArqRemeEstrategia.PAGINACAO_PAGE%>"
			value="">
		<input type="hidden"
			name="<%=ArqRemeEstrategia.PAGINACAO_PAGEANTERIOR%>"
			value="<%=paginaAtual%>">
		<input type="hidden" name="consultaUnidade" value="">

		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="1" cellpadding="0"
					height=53 align="center">
					<tr>
						<td class="textoTitulo" width="17%">Unidade PV:</td>
						<td class="textoValor" width="26%"><%=arqBean.getCodigoUnidadePVFormatado()%></td>
						<td class="textoTitulo" width="17%">Nome Unidade:</td>
						<td class="textoValor" width="26%"><%=arqBean.getNomeUnidadePV()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Cedente:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
						<td class="textoTitulo" width="17%">Nome:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Tipo de Pessoa:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
						<td class="textoTitulo" width="17%">CPF/CNPJ:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Código Cliente (COCLI):</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals(
                                      new Long(0))
                            ? ""
                            : cedCabBean.getCodigoClienteCOCLI().toString()%></td>
						<td class="textoTitulo" width="17%">Apelido:</td>
						<td class="textoValor" width="26%"><%=arqBean.getApelidoCedente() + ""%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Nro. próxima remessa:</td>
						<td class="textoValor" width="26%"><%=arqBean.getNumeroProxRemessa() + ""%></td>
						<td class="textoTitulo" width="17%">Nro. último retorno:</td>
						<td class="textoValor" width="26%"><%=arqBean.getNumeroUltRetorno()%></td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="4" class="textoTitulo">Detalhe:
						<hr>
						</td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Data:</td>
						<td class="textoValor" width="26%"><%=arqBean.getDataArquivo() == null
                            ? ""
                            : Formatador.formatarData(arqBean.getDataArquivo())%></td>
						<td class="textoTitulo" width="17%">Hora:</td>
						<td class="textoValor" width="26%"><%=arqBean.getHoraArquivo()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Tipo Arquivo:</td>
						<td class="textoValor" width="26%"><%=arqBean.getTipoArquivo().equals(new Long(1))
                            ? "REMESSA"
                            : "RETORNO"%></td>
						<td class="textoTitulo" width="17%">Padrão</td>
						<td class="textoValor" width="26%"><%=(arqBean.getPadrao().longValue() + "").equals("1")
                            ? "CNAB240"
                            : (((arqBean.getPadrao().longValue() + "").equals("2"))
                                    ? "CNAB400"
                                    : "")%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Nro Remessa/Retorno:</td>
						<td class="textoValor" width="26%"><%=arqBean.getNumRemessaRetorno().longValue() == 0
                            ? ""
                            : arqBean.getNumRemessaRetorno().toString()%></td>
						<td class="textoTitulo" width="17%">Quantidade Registros:</td>
						<td class="textoValor" width="26%"><%=arqBean.getQuantidadeRegistros().longValue() == 0
                            ? ""
                            : arqBean.getQuantidadeRegistros().toString()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">VAN:</td>
						<td class="textoValor" width="26%"><%=arqBean.getDescricaoVAN()%></td>
						<td class="textoTitulo" width="17%">Observação:</td>
						<td class="textoValor" width="26%"><%=arqBean.getObservacao()%></td>
					</tr>

					<tr>
						<td class="textoTitulo" width="17%">Data Envio/Reenvio da Carga Inicial:</td>
						<td class="textoValor" width="26%"><%=arqBean.getDataEnvioReenvio()%></td>
						<td class="textoTitulo" width="17%">CPF/CNPJ:</td>
						<td class="textoValor" width="26%"><%=arqBean.getCpfCnpj()%></td>
					</tr>

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="4" class="textoTitulo">Rejeições:
						<hr>
						</td>
					</tr>

					<tr>
						<td colspan="4">
						<table width="100%" border="0" cellspacing="3" cellpadding="0"
							align="center" valign="middle">
							<tr class="headerLista">
								<td nowrap width="10%" align="left">Registro</td>
								<td nowrap width="10%" align="left">Erro</td>
								<td nowrap width="10%" align="left">Descrição</td>
							</tr>
							<%ArquivoRemessaBean occ = new ArquivoRemessaBean();
                    for (int i = 0; i < lista.size(); i++) {
                        occ = (ArquivoRemessaBean) lista.get(i);

                        %>
							<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td width="10%" align="right"><%=occ.getNumRegistroErro()%></td>
								<td width="7%" align="left"><%=occ.getCodigoErro()%></td>
								<td width="30%" align="left"><%=occ.getDescricaoErro()%></td>
							</tr>
							<%}

                    %>
						</table>
						</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4" align="center"><s:ButtonPaginar
							pageNumber="<%=paginacao.getPageNumber()%>"
							numberOfPages="<%=paginacao.getPageCount()%>"
							pageName="<%=Paths.getRootForDynamicContent() + ArqRemeEstrategia.PAGE_MANTER_CONSULTAR %>" />
						</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td align="right" colspan="4">
						<p align="center"><s:Button name="Voltar"
							action="javascript: formSubmit_Voltar();" /></p>
						</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<script>
		function inicia() {
			setFirstFieldFocus();
		}

	    function formSubmit() { 
	    	if (validaSubmit()) {
	        	document.frmMain.submit();
        	}
		}
		
		function validaSubmit() {
		    return true;
		}

		function formSubmit_Voltar() {
			document.frmMain.estrategia.value = "<%=ArqRemeEstrategia.STRATEGY_MANTER_FILTRO%>";
		    document.frmMain.fluxo.value = "voltar";
		    document.frmMain.submit();
		}
    </script>
	</s:FormStrategy>
</p:Document>