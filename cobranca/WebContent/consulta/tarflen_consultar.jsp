<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servrej_consultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 04/11/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TarFlEnEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.ConGerTarifaFloatENBean"%>

<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.com.politec.sao.util.Formatacao"%>

<%
	ConGerTarifaFloatENBean fixoBean =(session.getAttribute(TarFlEnEstrategia.BEAN_FIXO)==null? new ConGerTarifaFloatENBean()
																		:(ConGerTarifaFloatENBean)session.getAttribute(TarFlEnEstrategia.BEAN_FIXO));
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(TarFlEnEstrategia.PAGINACAO_LIST);
	
	if(request.getParameter(TarFlEnEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(TarFlEnEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(TarFlEnEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(TarFlEnEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>
	
<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.TarFlEnManterIniciar" fluxo="voltar">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=TarFlEnEstrategia.TITLE%>"/>
 		
 		<input type="hidden" name="<%=TarFlEnEstrategia.PAGINACAO_PAGE%>" value="">
 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

            <tr>
              <td class="textoTitulo" width="17%">Unidade SR: </td><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
              <td class="textoValor" width="26%"><%=fixoBean.getCodigoUnidadeEnFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Unidade: </td>
              <td class="textoValor" width="26%"><%=fixoBean.getNomeUnidadeEn()%></td>
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Consulta:
                <hr>
              </td>
            </tr>
						
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
 								    <td nowrap width="20%" align="right">Unidade PV</td>
								    <td nowrap width="15%" align="right">Quantidade</td>
 								    <td nowrap width="15%" align="right">Valor Médio</td>
								    <td nowrap width="15%" align="right">Float Médio</td>
 								    <td nowrap width="15%" align="right">Indice Tarifa (%)</td>
 								    <td nowrap width="15%" align="right">Total Tarifas</td>
								  </tr>
								  
							<%
									ConGerTarifaFloatENBean occ = new ConGerTarifaFloatENBean();
									for ( int i = 0; i < lista.size(); i++ ) {
									 	occ = (ConGerTarifaFloatENBean) lista.get(i);
							%>	  								  
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
 								    <td nowrap width="20%" align="right"><%=occ.getCodigoUnidadePvFormatado()%></td>
								    <td nowrap width="15%" align="right"><%=occ.getQuantidade()%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getValorMedio()%></td>
								    <td nowrap width="15%" align="right"><%=Formatacao.formataPadraoBrasileiro(occ.getFloatMedio())%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getIndiceTarifa()%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getTotalTarifas()%></td>
								  </tr>
						 <%  }	%>
						 			<tr> 
             			  <td colspan="4">&nbsp;</td>
            			</tr>	
								  <tr class='line0'>
 								    <td nowrap width="20%" align="right"><b>Total</b></td>
								    <td nowrap width="15%" align="right"><b><%=fixoBean.getTotalQuantidade()%></b></td>
 								    <td nowrap width="15%" align="right"><b><%=fixoBean.getTotalValorMedio()%></b></td>
								    <td nowrap width="15%" align="right"><b><%=Formatacao.formataPadraoBrasileiro(fixoBean.getTotalFloatMedio())%></b></td>
 								    <td nowrap width="15%" align="right"><b><%=fixoBean.getTotalIndiceTarifa()%></b></td>
 								    <td nowrap width="15%" align="right"><b><%=fixoBean.getTotalGeralTarifa()%></b></td>
								  </tr>
								  
								</table>
							</td>
						</tr>            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
							<td colspan="6" align="center">
							  <s:ButtonPaginar 
					  				pageNumber="<%=paginacao.getPageNumber()%>" 
  									numberOfPages="<%=paginacao.getPageCount()%>" 
  									pageName="<%=TarFlEnEstrategia.PAGE_CONSULTAR%>"/>
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
          </table>
        </td>
      </tr>
    </table>
    <script>
	    function inicia() {
				setFirstFieldFocus();
			}
	    function formSubmit() {
        document.frmMain.submit();
	    }
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
