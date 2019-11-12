<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: lantari_manter_listar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 08/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.LancamentoTarifaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.LancamentoTarifaEstrategia"%>

<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(LancamentoTarifaEstrategia.PAGINACAO_LIST);
	if(request.getParameter(LancamentoTarifaEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(LancamentoTarifaEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(LancamentoTarifaEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(LancamentoTarifaEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	LancamentoTarifaBean lancamentoTarifaBean = (session.getAttribute(LancamentoTarifaEstrategia.DATA_BEAN)==null?new LancamentoTarifaBean():(LancamentoTarifaBean)session.getAttribute(LancamentoTarifaEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(LancamentoTarifaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(LancamentoTarifaEstrategia.CEDENTE_CABECALHO_BEAN));
	String titulo = (String) request.getAttribute("titulo");
	String tpConsulta = (String) request.getSession().getAttribute("tpConsulta");
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=LancamentoTarifaEstrategia.STRATEGY_CONSULTAR_DETALHE_MANTER_INCLUIR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=titulo%>"/>    
  	<input type="hidden" name="codigoUnidadePV" value="">
  	<input type="hidden" name="<%=LancamentoTarifaEstrategia.PAGINACAO_PAGE%>" value="">
  	<input type="hidden" name="codigoCedente" value="<%=lancamentoTarifaBean.getCodigoCedente()%>">
		<input type="hidden" name="dataLancamento" >
		<input type="hidden" name="dataInicial" value="<%=lancamentoTarifaBean.getDataInicialFormatada()%>">
		<input type="hidden" name="dataFinal" value="<%=lancamentoTarifaBean.getDataFinalFormatada()%>">
		<input type="hidden" name="valorTotal" value="<%=lancamentoTarifaBean.getValorTotal()%>"/>
		<input type="hidden" name="dtComando" value="<%=lancamentoTarifaBean.getDataComandoFormatada()%>"/>
		<input type="hidden" name="coUsuario" value="<%=lancamentoTarifaBean.getCoUsuario()%>"/>
		<input type="hidden" name="tpConsulta" value="<%=tpConsulta%>"/>
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=lancamentoTarifaBean.getCodigoCedente().equals( new Long(0))?"":lancamentoTarifaBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals( new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Data do Comando : </td>
              <td class="textoValor" width="26%"><%=lancamentoTarifaBean.getDataComandoFormatada()%></td> 
              <td class="textoTitulo" width="17%">Valor Total Cobrado: </td>
              <td class="textoValor" width="26%"><%=lancamentoTarifaBean.getValorTotal()%></td>
            </tr>
            
            <tr>
              <td class="textoTitulo" width="17%">Usuário: </td>
              <td class="textoValor" width="26%"><%=lancamentoTarifaBean.getCoUsuario()%></td> 
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="10%" align="center">Data de Débito</td>
								    <td nowrap width="10%" align="right">Quantidade</td>
								    <td nowrap width="25%" align="right">Valor Previsto</td>
								    <td nowrap width="25%" align="right">Valor Cobrado</td>								    
								  </tr>
							<%
									LancamentoTarifaBean occ = new LancamentoTarifaBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (LancamentoTarifaBean) lista.get(i);
							%>
									  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									      <input type="radio" name="rdo"
								    		 onclick="javascript: clickRadio('<%=occ.getDataLancamentoFormatada()%>');">
								    	</td>
	 								    <td nowrap width="10%" align="center"><%=occ.getDataLancamentoFormatada()%></td>
	 								    <td nowrap width="10%" align="right"><%=occ.getQuantidade()%></td>
											<td nowrap width="25%" align="right"><%=occ.getValorPrevisto()%></td>	 								    
											<td nowrap width="25%" align="right"><%=occ.getValorCobrado()%></td>	 								    
									  </tr>
						<%  } %>	  

 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="6" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=LancamentoTarifaEstrategia.PAGE_LISTAR_DETALHE_INCLUIR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="6">
	                    <p align="center"> 
	                      <s:Button name="Ok" action="javascript:formSubmit();"/>
	                      <s:Button name="Voltar" action="javascript:formSubmit_Voltar();"/>
	                    </p>
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
		<script>

	    function inicia(){
	    }

	  	function formSubmit() {
        if(validaSubmit()){   
           document.frmMain.submit();
        }
	    }  
	    
	    function formSubmit_Voltar() {
			document.frmMain.estrategia.value = 'servico.LanTariManterFiltro';    	
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
      }  

			function validaSubmit() {
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
	    
	    function clickRadio(dataLancamento) {
				document.frmMain.dataLancamento.value = dataLancamento;
      }
		</script>
  </s:FormStrategy>
</p:Document>
</html>
