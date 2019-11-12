<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: excepci_manter_listar_unidpv.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 09/09/2004
************************************************/
%>

<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.DadosListaExcepciBean"%> 
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.ExcepciManterEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.List"%>

<%
  DadosListaExcepciBean listaBean = (session.getAttribute(ExcepciManterEstrategia.FIXO_BEAN)==null?
																			new DadosListaExcepciBean():(DadosListaExcepciBean)
																			session.getAttribute(ExcepciManterEstrategia.FIXO_BEAN));	
																			
	DadosListaExcepciBean filtroBean = (session.getAttribute(ExcepciManterEstrategia.FILTRO_BEAN)==null?
																			new DadosListaExcepciBean():(DadosListaExcepciBean)
																			session.getAttribute(ExcepciManterEstrategia.FILTRO_BEAN));	
		  								
	  									
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ExcepciManterEstrategia.PAGINACAO_LIST);
	if(request.getParameter(ExcepciManterEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ExcepciManterEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ExcepciManterEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ExcepciManterEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>





<html>
	<s:Header/>
	<p:Document>
		<s:FormStrategy name="frmMain" action="SigcbControle" 
					estrategia="cedente.ExcepciManterFiltro" fluxo="normal">
			<s:Menu/>
			<s:Titulo name="Excepcionação de Pendência de Alçada (PV) >> Listar"/>	  
	
			<input type="hidden" name = "tpConsultaEstrategia" value="">
			<input type="hidden" name = "codigoCedente" value="">
			<input type="hidden" name = "<%=ExcepciManterEstrategia.PAGINACAO_PAGE%>" value="">
			<input type="hidden" name = "situacaoPendencia" value="<%=filtroBean.getSituacaoPendencia()%>">
			
	    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
	
	            <tr>
	              <td class="textoTitulo" width="17%">Unidade PV: </td>
	              <td class="textoValor" width="26%"><%=filtroBean.getCodigoUnidadePVFormatado()%></td>
	  
	              <td class="textoTitulo" width="17%">Nome Unidade: </td>
	              <td class="textoValor" width="26%"><%=listaBean.getNomeUnidadePV()%></td>
	            </tr>
	            <tr>
	              <td colspan="4">&nbsp;</td>
	            </tr>
	
	            <tr valign="top"> 
	              <td colspan="5" class="textoTitulo">Cedentes:
	                <hr>
	              </td>
	            </tr>
	            
							<tr>
								<td colspan="4">
									<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
									  <tr class="headerLista">
									    <td width="5%" align="center">&nbsp;</td>
	 								    <td width="10%" align="right">Cedente</td>
									    <td width="20%" align="left">Nome Cedente</td>
	 								    <td width="10%" align="left">Tipo Pessoa</td>
									    <td width="20%" align="right">CPF/CNPJ</td>
									    <td width="30%" align="center">&nbsp;</td>
									  </tr>
									  
									<%
											DadosListaExcepciBean occ = new DadosListaExcepciBean();
											
											for ( int i = 0; i < lista.size(); i++ ) {	
											occ = (DadosListaExcepciBean) lista.get(i);
									%>
									  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="5%" align="center">
												<input type="radio" name="rdo"
									    		onclick="javascript: clickRadio('<%=occ.getCodigoCedente()%>');">
											</td>									
	 								    <td width="10%" align="right"><%= occ.getCodigoCedenteFormatado() %></td>
	 								    <td width="20%" align="left"><%= occ.getNomeFantasia() %></td>
	 								    <td width="10%" align="left"><%= occ.getDescTipoPessoa() %></td>
	 								    <td width="20%" align="right"><%= occ.getCpfCnpjFormatado()%></td>
									    <td width="30%" align="center">&nbsp;</td>
									  </tr>
							<%  } %>	
	 	                <tr> 
		                  <td colspan="6">&nbsp;</td>
		                </tr>
										<tr>
											<td colspan="6" align="center">
											  <% String pageName =ExcepciManterEstrategia.PAGE_LISTAR_PV;%>
											  <s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=pageName%>"/>
											</td>
										</tr>
	 	                <tr> 
		                  <td colspan="6">&nbsp;</td>
		                </tr>
	
		                <tr>
		                  <td align="right" colspan="6">
		                    <p align="center"> 
		                      <s:Button name="Ok" action="javascript:formSubmit();"/>
		                    	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
		                    </p>
		                  </td>
		                </tr>
		              </table>
	              </td>
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
	        	document.frmMain.tpConsultaEstrategia.value = 0;
		        document.frmMain.submit();
	        }
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
				
				function clickRadio(codigoCedente) {
					document.frmMain.codigoCedente.value = codigoCedente;
	     	}
	     	
		    function formSubmit_Voltar() {
		    	document.frmMain.tpConsultaEstrategia.value = 3;
//	    		document.frmMain.estrategia.value = "cedente.ExcepciManterIniciar";
	       	document.frmMain.fluxo.value = "voltar";
	        document.frmMain.submit();
		    }	    
	    </script>
	 	 </s:FormStrategy>
	</p:Document>    
</html>