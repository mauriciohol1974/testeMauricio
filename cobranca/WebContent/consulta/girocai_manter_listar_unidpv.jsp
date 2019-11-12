<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: girocai_manter_listar_unidpv.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 05/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.GiroCaixaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GiroCaixaEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(GiroCaixaEstrategia.PAGINACAO_LIST);
	if(request.getParameter(GiroCaixaEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(GiroCaixaEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(GiroCaixaEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(GiroCaixaEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	GiroCaixaBean giroCaixaBean = (session.getAttribute(GiroCaixaEstrategia.DATA_BEAN)==null?new GiroCaixaBean():(GiroCaixaBean)session.getAttribute(GiroCaixaEstrategia.DATA_BEAN));
	GiroCaixaBean giroCaixaFiltroBean = (session.getAttribute(GiroCaixaEstrategia.FILTRO_BEAN)==null?new GiroCaixaBean():(GiroCaixaBean)session.getAttribute(GiroCaixaEstrategia.FILTRO_BEAN));		
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=GiroCaixaEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=GiroCaixaEstrategia.PAGE_TITLE_LISTAR_PV%>"/>    
  	<input type="hidden" name="codigoUnidadePV" value="">
  	<input type="hidden" name="navegacao" value="<%=giroCaixaBean.getNavegacao()%>">
  	<input type="hidden" name="<%=GiroCaixaEstrategia.PAGINACAO_PAGE%>" value="">
  	<input type="hidden" name="codigoCedente" value="">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Unidade PV: </td>
              <td class="textoValor" width="26%"><%=giroCaixaBean.getCodigoUnidadePVFormatado()%></td>

              <td class="textoTitulo" width="17%">Nome Unidade: </td>
              <td nowrap class="textoValor" width="26%"><%=giroCaixaBean.getNomeUnidadePV()%></td> 
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Cedentes:
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="10%" align="right">Cedente</td>
								    <td nowrap width="40%" align="left">Nome Cedente</td>
								    <td nowrap width="15%" align="left">Tipo Pessoa</td>
								    <td nowrap width="15%" align="right">CNPJ</td>								    
								    <td nowrap width="18%">&nbsp;</td>								    
								  </tr>
							<%
									GiroCaixaBean occ = new GiroCaixaBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (GiroCaixaBean) lista.get(i);
							%>
									  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									      <input type="radio" name="rdo"
								    		 onclick="javascript: clickRadio(<%=occ.getCodigoCedente()%>);">
								    	</td>
	 								    <td width="10%" align="right"><%=occ.getCodigoCedenteFormatado()%></td>
	 								    <td width="40%" align="left"><%=occ.getNomeFantasia()%></td>
											<td width="15%" align="left"><%=occ.getTipoPessoaTexto()%></td>	 								    
											<td width="15%" align="right"><%=occ.getCpfCnpjFormatado()%></td>	 								    
								      <td nowrap width="18%">&nbsp;</td>								    
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
											  		pageName="<%=GiroCaixaEstrategia.PAGE_JSP_LISTAR_UNIDPV%>"/>
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
						document.frmMain.estrategia.value = '<%=giroCaixaFiltroBean.getNavegacao().equals(GiroCaixaEstrategia.NAVEGACAO_LISTA_PV)?GiroCaixaEstrategia.STRATEGY_MANTER_INICIAR:GiroCaixaEstrategia.STRATEGY_MANTER_FILTRO%>';    	
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
	    
	    function clickRadio(codigoCedente) {
				document.frmMain.codigoCedente.value = codigoCedente;
      }
		</script>
  </s:FormStrategy>
</p:Document>
</html>
