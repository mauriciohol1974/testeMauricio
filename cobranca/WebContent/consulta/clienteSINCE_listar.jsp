
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import=" br.gov.caixa.sigcb.bean.ClienteSINCEBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ClienteSINCEEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>


<%
int paginaAtual = 0;
PageHolder paginacao = (PageHolder) session.getAttribute(ClienteSINCEEstrategia.PAGINACAO_LIST);

if (request.getParameter(ClienteSINCEEstrategia.PAGINACAO_PAGE) != null
    && !request.getParameter(ClienteSINCEEstrategia.PAGINACAO_PAGE)
            .equals("")) {
    paginaAtual = Integer.parseInt((String) request.getParameter(ClienteSINCEEstrategia.PAGINACAO_PAGE));
} else {
    paginaAtual = Integer.parseInt((String) request.getAttribute(ClienteSINCEEstrategia.PAGINACAO_PAGE));
}
List lista = paginacao.getPage(paginaAtual);

String tpconsulta = (String)request.getParameter("tpconsulta");
String codcedente = (String) request.getParameter("codcedente");
String codsince = (String) request.getParameter("codsince");
String codpv = (String) request.getParameter("codPV");
String codsr = (String) request.getParameter("codSR");

%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
	estrategia="<%=ClienteSINCEEstrategia.STRATEGY_INICIAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=ClienteSINCEEstrategia.PAGE_TITLE_LISTAR%>"/>
			
		<input type="hidden" name="tpconsulta" 	value="<%= tpconsulta%>">
		<input type="hidden" name="codcedente" 	value="<%= codcedente %>">
		<input type="hidden" name="codsince" 	value="<%= codsince %>">
		<input type="hidden" name="codPV" 	    value="<%= codpv%>">
		<input type="hidden" name="codSR" 	    value="<%= codsr%>">
	
	  <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<td valign="top" width="1%" height="14" align="left">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	  		<td valign="top" width="95%" height="14" align="left"> 
	    		<table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="left">
          	

	          <tr>
		          <td colspan="4">&nbsp;</td>
	          </tr>
	          <tr valign="top"> 
	  	        <td colspan="4" class="textoTitulo">Cliente SINCE:
	    	        <hr>
	            </td>
	         	</tr>
            
						<tr>
					  	<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
									<tr class="headerLista">
	 								  <td nowrap width="14%" align="left">Código do Cedente</td>
									  <td nowrap width="18%" align="left">Código SINCE</td>
									  <td nowrap width="18%" align="center">SR</td>
	 								  <td nowrap width="10%" align="center">PV</td>
	 								  <td nowrap width="20%" align="left">CPF/CNPJ</td>
	 								  <td nowrap width="38%" align="left">Nome </td>

								  </tr>
								  
								   

							<%
								ClienteSINCEBean occ = new ClienteSINCEBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ClienteSINCEBean) lista.get(i);
										if (occ.getCodcedente()>0){
							%>
									<tr>
										<td nowrap width="14%" align="left"><%=Formatador.formatarCodigoCedente(occ.getCodcedente())%></td>							    
										<td nowrap width="18%" align="left"><%=Formatador.formatarCodigoSince(occ.getCodsince())%></td>
										<td nowrap width="10%" align="center"><%=Formatador.formatarUnidade(occ.getCodSR())%></td>
								        <td nowrap width="10%" align="center"><%=Formatador.formatarUnidade(occ.getCodPV())%></td>
								        <%if (occ.getTpPessoa().equals("1")){ %>
	 							        	<td nowrap width="20%" align="left"><%=Formatador.formatarCpf(String.valueOf(occ.getCpfCnpj()))%></td>
	 							        <%}else{ %>
	 							        	<td nowrap width="20%" align="left"><%=Formatador.formatarCpfCnpj(String.valueOf(occ.getCpfCnpj()))%></td>
	 							        <%} %>
	 							        <td nowrap width="38%" align="left"><%=occ.getNome()%></td>
									</tr>
							<%} 	
							} %>
								

	                <tr> 
			              <td colspan="6">&nbsp;</td>
		              </tr>


		            </table>
		          </td>
		        </tr>

	         
							<tr>
								<td colspan="6" align="center"><%String pageName = ClienteSINCEEstrategia.PAGE_LISTAR;%>
								<!-- 				s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=pageName%>"/-->
								<s:paginacao estrategia="<%=ClienteSINCEEstrategia.STRATEGY_FILTRO %>" /></td>
							</tr>
		                
		 				<tr> 
	   					<td colspan="4">&nbsp;</td>
	   				</tr>
				    <tr>
	    			  <td align="right" colspan="4">
	      				<p align="center"> 
                 		<s:Button name="Voltar" action="javascript: formSubmit();"/>
                 	
	      				</p>
	    				</td>
    				</tr>

		 				<tr> 
	   					<td colspan="4">&nbsp;</td>
	   				</tr>
         	
         	</table>
	      </td>

		</table>    
		    <script>
			function inicia() {

			}
	    function formSubmit() {
       
	        document.frmMain.submit();
        
	    }
					
    </script>
	</s:FormStrategy>
</p:Document>
</html>
