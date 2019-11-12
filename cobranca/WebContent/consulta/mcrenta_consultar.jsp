<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: mcrenta_colsultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 19/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.MCRentaEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerCedenteRentabilidadeBean"%>

<%@page import="java.util.List"%>
<%@page import="br.com.politec.sao.util.Money"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.com.politec.sao.business.util.BeanList"%>

<%
  ConGerCedenteRentabilidadeBean filtroBean = (session.getAttribute(MCRentaEstrategia.BEAN_FILTRO)==null? new ConGerCedenteRentabilidadeBean()
																			:(ConGerCedenteRentabilidadeBean)session.getAttribute(MCRentaEstrategia.BEAN_FILTRO));

	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(MCRentaEstrategia.PAGINACAO_LIST);
	
	if(request.getParameter(MCRentaEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(MCRentaEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(MCRentaEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(MCRentaEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=MCRentaEstrategia.STRATEGY_INICIAR%>" fluxo="voltar">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Cedentes por Rentabilidade"/>
		
		<input type="hidden" name="<%=MCRentaEstrategia.PAGINACAO_PAGE%>" value="">  
        
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Período: </td>
              <td class="textoValor" width="26%"><%=filtroBean.getDescPeriodo()%></td> 
              <td class="textoTitulo" width="17%">Rentabilidade: </td>
              <td class="textoValor" width="26%"><%=filtroBean.getDescRentabilidade()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Número de Resultados: </td>
              <td class="textoValor" width="26%"><%=filtroBean.getNumeroResultado()%></td> 
              <td class="textoTitulo" width="17%">Faixa de Rentabilidade: </td>
              <td class="textoValor" width="26%"><%=filtroBean.getDescFaixaRentabilidade()%></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Consulta:
                <hr>
              </td>
            </tr>

						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								 
								 
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">#</td>
 								    <td nowrap width="5%" align="right">Cedente</td>
								    <td nowrap width="15%" align="left">Nome Cedente</td>
								    <td nowrap width="15%" align="right">Valor Bruto Tarifas</td>
								    <td nowrap width="15%" align="right">Preço de Transf.</td>
								    <td nowrap width="15%" align="right">Outros Custos</td>
								    <td nowrap width="15%" align="right">Valor Líquido</td>
								    <td nowrap width="15%" align="right">Rentabilidade Média</td>
								  </tr>
							<%
									ConGerCedenteRentabilidadeBean occ = new ConGerCedenteRentabilidadeBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ConGerCedenteRentabilidadeBean) lista.get(i);
							%>	  	  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="2%" align="center"><%=occ.getClassificacao()%></td>
 								    <td nowrap width="5%"  align="right"><%=occ.getCodigoCedenteFormatado()%></td>
								    <td nowrap width="15%"  align="left"><%=occ.getNomeFantasia()%></td>
								    <td nowrap width="15%"  align="right"><%=occ.getValorBrutoTarifas()%></td>
								    <td nowrap width="15%"  align="right"><%=occ.getPrecoTransferencia()%></td>
								    <td nowrap width="15%"  align="right"><%=occ.getOutrosCustos()%></td>
								    <td nowrap width="15%"  align="right" <%=(occ.getValorLiquidoSigned().lessThan(new Money("0", occ.getValorLiquido().getCurrency() )))?"class='alert'":""%>>
			              	<%=occ.getValorLiquidoSigned()%>
			              </td>
								    <td nowrap width="15%"  align="right" <%=(occ.getRentabilidadeMediaSigned().lessThan(new Money("0", occ.getRentabilidadeMedia().getCurrency() )))?"class='alert'":""%>>
			              	<%=occ.getRentabilidadeMediaSigned()%>
								    </td>
								  </tr>
							<% } %>
								  <tr>
	                  <td colspan="8">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="8" align="center">
										  <s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=MCRentaEstrategia.PAGE_CONSULTAR%>"/>
										</td>
									</tr>
 	                <tr>
	                  <td colspan="8">&nbsp;</td>
	                </tr>
	              </table>
              </td>
            </tr>

 	          <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>
	          
            <tr>
              <td align="right" colspan="4">
 	              <p align="center">
 	              	<s:Button name="Voltar" action="javascript:formSubmit()"/> 
	              </p>
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
	    function inicia(){
		    setFirstFieldFocus();
	    }
	    function formSubmit() {
         document.frmMain.submit();
	    }
	    
    </script>
   	</s:FormStrategy>
	</p:Document>
</html>