
<%
/***********************************************
*Projeto CAIXA - SIGCB DDA
*Componente: sac_eletron_listar.jsp - Java Server Pages
*Criado em: 04/09/2009
*Autor: Alexandre Lima - alexandre.lima@probank.com.br
*Ultima Atualização: set/2009
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.SacEletronicoBean"%>
<%@page
	import="br.gov.caixa.sigcb.estrategia.dda.SacEletronicoEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	SacEletronicoBean sacBean = (session.getAttribute(SacEletronicoEstrategia.FILTRO_BEAN) == null ? new SacEletronicoBean() : (SacEletronicoBean) session.getAttribute(SacEletronicoEstrategia.FILTRO_BEAN));

	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session
			.getAttribute(SacEletronicoEstrategia.PAGINACAO_LIST);

	if (request.getParameter(SacEletronicoEstrategia.PAGINACAO_PAGE) != null
			&& !request.getParameter(
			SacEletronicoEstrategia.PAGINACAO_PAGE).equals("")) {
		paginaAtual = Integer.parseInt((String) request
		.getParameter(SacEletronicoEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String) request
		.getAttribute(SacEletronicoEstrategia.PAGINACAO_PAGE));
	}

	List lista = paginacao.getPage(paginaAtual);
%>

<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=SacEletronicoEstrategia.STRATEGY_MANTER_FILTRO%>"
		fluxo="normal">
		<s:Menu />
		<s:Titulo name="<%=SacEletronicoEstrategia.PAGE_TITLE_CONSULTAR%>" />
		<input type="hidden" name="cpfCnpj" value=''>
		<input type="hidden" name="cpfCnpjAgreg" value=''>
		<input type="hidden" name="<%=SacEletronicoEstrategia.PAGINACAO_PAGE%>" value="">

		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="1" cellpadding="0"
					height=53 valign="middle" align="center">


					<tr>

						<td nowrap class="textoTitulo" width="17%">Tipo de Pessoa:</td>

						<td nowrap class="textoValor" width="26%"><%=sacBean.getTipoPessoaTexto()%></td>

						<td nowrap class="textoTitulo" width="17%">CPF/CNPJ:</td>

						<td nowrap class="textoValor" width="26%"><%=sacBean.getCpfCnpjFormatado()%></td>
					</tr>


					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>

					<tr valign="top">
						<td colspan="5" class="textoTitulo">Agregados:
						<hr>
						</td>
					</tr>

					<tr>
						<td colspan="4">
						<table width="100%" border="0" cellspacing="3" cellpadding="0"
							align="center" valign="middle">
							<tr class="headerLista">
								<td width="1%" align="center">&nbsp;</td>


								<td nowrap width="15%" align="left">CPF/CNPJ</td>
								<td nowrap width="84%" align="left">Pessoa</td>
							</tr>
							
							<%SacEletronicoBean occ = new SacEletronicoBean();
                    			for (int i = 0; i < lista.size(); i++) {
                        			occ = (SacEletronicoBean) lista.get(i);

                        	%>
							
							<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %> >
								
								<td width="1%" align="center" nowrap>&nbsp;</td>
								<td nowrap width="20%" align="left" nowrap>&nbsp;<%=occ.getCpfCnpjAgregFormatado() %>&nbsp;</td>
								<td nowrap width="30%" align="left" nowrap>&nbsp;<%=occ.getTipoPessoaAgregTexto() %>&nbsp;</td>								
								
							</tr>

							<% } %>

							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>
							
							<tr>
								<td colspan="4" align="center">
								<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=SacEletronicoEstrategia.PAGE_LISTAR%>"/>
								</td>
							</tr>
							
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>

							<tr>
								<td align="right" colspan="4">
								<p align="center"> <s:Button name="Voltar"
									action="javascript:formSubmit_Voltar()" /></p>
								</td>
							</tr>
							
							
							<!-- tr>
								<td align="right" colspan="4">
								<p align="center"><input type="button" class="button"
									name="Voltar" value="Voltar"
									onclick="javascript:formSubmit_Voltar();"></p>
								</td>
							</tr-->
							
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
  			
        document.frmMain.estrategia.value = "dda.SacEletronicoConsultarIniciar";  			
        document.frmMain.fluxo.value = "voltar";
       	document.frmMain.submit();
	    }
    				
    
      /*function inicia(){
        loadMenus();
      }
      function formSubmit() {
        
		document.frmMain.action = "DDAincluirSacadoEletronicoAcao.html";
		document.frmMain.submit();
		
      }
      function validaInserir(){
        return true;
      }*/
    </script>
	</s:FormStrategy>
</p:Document>
</html>
