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
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.DebitoTarifaEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(DebitoTarifaEstrategia.PAGINACAO_LIST);
	if(request.getParameter(DebitoTarifaEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(DebitoTarifaEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(DebitoTarifaEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(DebitoTarifaEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	LancamentoTarifaBean lancamentoTarifaBean = (session.getAttribute(DebitoTarifaEstrategia.DATA_BEAN)==null?new LancamentoTarifaBean():(LancamentoTarifaBean)session.getAttribute(DebitoTarifaEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(DebitoTarifaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(DebitoTarifaEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=DebitoTarifaEstrategia.STRATEGY_CONSULTAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=DebitoTarifaEstrategia.PAGE_TITLE_LISTA%>"/>    
  	<input type="hidden" name="codigoUnidadePV" value="">
  	<input type="hidden" name="<%=DebitoTarifaEstrategia.PAGINACAO_PAGE%>" value="">
  	<input type="hidden" name="codigoCedente" value="<%=lancamentoTarifaBean.getCodigoCedente()%>">
		<input type="hidden" name="dataLancamento" >
		<input type="hidden" name="dataInicial" value="<%=lancamentoTarifaBean.getDataInicialFormatada()%>">
		<input type="hidden" name="dataFinal" value="<%=lancamentoTarifaBean.getDataFinalFormatada()%>">
		<input type="hidden" name="coUsuario" value="<%=lancamentoTarifaBean.getCoUsuario()%>">
		<input type="hidden" name="dtComando" value="<%=lancamentoTarifaBean.getDtComando()%>">
		<input type="hidden" name="valorTotal" value="">
		<input type="hidden" name="situacao" value="">
		
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
              <td class="textoTitulo" width="17%">Data Comando Inicial: </td>
              <td class="textoValor" width="26%"><%=lancamentoTarifaBean.getDataInicialFormatada()%></td> 
              <td class="textoTitulo" width="17%">Data Comando Final: </td>
              <td class="textoValor" width="26%"><%=lancamentoTarifaBean.getDataFinalFormatada()%></td>
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
 								    <td nowrap width="10%" align="center">Data do Comando</td>
								    <td nowrap width="25%" align="right">Valor Total Cobrado</td>
								    <td nowrap width="25%" align="right">Usuário</td>	
								    <td nowrap width="25%" align="right">Situação</td>								    
								  </tr>
							<%
									LancamentoTarifaBean occ = new LancamentoTarifaBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (LancamentoTarifaBean) lista.get(i);
							%>
									  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									      <input type="radio" name="rdo"
								    		 onclick="javascript: clickRadio('<%=occ.getDataComandoFormatada()%>','<%=occ.getValorTotal()%>','<%=occ.getCoUsuario()%>','<%=occ.getSituacao()%>');">
								    	</td>
	 								    <td nowrap width="10%" align="center"><%=occ.getDataComandoFormatada()%></td>
	 								    
											<td nowrap width="25%" align="right"><%=occ.getValorTotal()%></td>	 								    
											<td nowrap width="25%" align="right"><%=occ.getCoUsuario()%></td>	
											<td nowrap width="25%" align="right"><%=occ.getSituacao()%></td> 								    
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
											  		pageName="<%=DebitoTarifaEstrategia.PAGE_LISTAR%>"/>
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
						document.frmMain.estrategia.value = '<%=DebitoTarifaEstrategia.STRATEGY_MANTER_INICIAR%>';    	
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
	    
	    function clickRadio(dataLancamento, valortotal, cousuario,situacao) {
				document.frmMain.dtComando.value = dataLancamento;
				document.frmMain.valorTotal.value = valortotal;
				document.frmMain.coUsuario.value = cousuario;
				document.frmMain.situacao.value = situacao;
      }
		</script>
  </s:FormStrategy>
</p:Document>
</html>
