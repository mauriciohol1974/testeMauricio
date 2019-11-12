<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.CedentePropostasEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePropostaBean"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.List"%>

<%
CedentePropostaBean fixoBean = (session.getAttribute(CedentePropostasEstrategia.MANTER_FIXO_BEAN)==null
 	                                      ? new CedentePropostaBean()
 	                                      : (CedentePropostaBean)session.getAttribute(CedentePropostasEstrategia.MANTER_FIXO_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(CedentePropostasEstrategia.PAGINACAO_LIST);
	if(request.getParameter(CedentePropostasEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(CedentePropostasEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(CedentePropostasEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(CedentePropostasEstrategia.PAGINACAO_PAGE));
	}
	
	List lista = paginacao.getPage(paginaAtual);	
%>

<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.CedentePropostasFiltro" fluxo="normal">   	          				
   		<s:Menu/>
   		<s:Titulo name="<%=CedentePropostasEstrategia.PAGE_TITLE_CONSULTA%>"/>
   		
   		<input type="hidden" name="<%=CedentePropostasEstrategia.PAGINACAO_PAGE%>" value="">
   		<input type="hidden" name="unidade" value="<%=fixoBean.getUnidade() %>" />
   		
	    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
	
	            <tr>
	              <td class="textoTitulo" width="17%">Unidade PV:: </td><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
	              <td class="textoValor" width="26%"><%=fixoBean.getUnidade() %></td>
	  
	              <td class="textoTitulo" width="17%">Nome Unidade: </td>
	              <td class="textoValor" width="26%"><%=fixoBean.getNomeUnidadePV() %></td>
	            </tr>
	            <tr> 
	              <td colspan="4">&nbsp;</td>
	            </tr>
	
	            <tr valign="top"> 
	              <td colspan="5" class="textoTitulo">
	                <hr>
	              </td>
	            </tr>
	            
							<tr>
								<td colspan="4">
									<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
									  <tr class="headerLista">
									    
	 								    <td width="20%" align="center">Cedente</td>
									    <td width="50%" align="left">Nome Cedente </td>
									    <td width="30%" align="left">CPF/CNPJ</td>
									  </tr>
									  
<%
CedentePropostaBean occ = new CedentePropostaBean();
	for ( int i = 0; i < lista.size(); i++ ) {	
		occ = (CedentePropostaBean) lista.get(i);
%>
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									   
	 								    <td width="20%" align="center"><%= occ.getCodigoCedenteFormatado() %></td>
	 								    <td width="50%" align="left"><%= occ.getNomeFantasia() %></td>
									    <td width="30%" align="left"><%=occ.getCpfCnpj() %></td>
									  </tr>
<%
	}
%>									  
	 	                <tr> 
		                  <td colspan="4">&nbsp;</td>
		                </tr>
										<tr>
											<td colspan="4" align="center">
											  <% String pageName = CedentePropostasEstrategia.PAGE_JSP_CONSULTAR;%>
											  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=pageName%>"/> 
											  
											</td>
										</tr>
	 	                <tr> 
		                  <td colspan="4">&nbsp;</td>
		                </tr>
	
		                <tr>
		                  <td align="right" colspan="4">
		                    <p align="center"> 
		                      <s:Button name="Ok" action="javascript:formSubmit_Consultar();" />
		                      <s:Button name="Voltar" action="javascript:formSubmit_Voltar();" />
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
	
	    <script language="javascript">
		    function inicia(){
		        setFirstFieldFocus();
		    }
		    
		    function formSubmit() {
		    	formSubmit_Consultar();
		    }
		    
		    function formSubmit_Consultar() {
	        if (validaSubmit()) {
	          document.frmMain.submit();
	        }
		    }
		    
		    function formSubmit_Voltar() {
					document.frmMain.estrategia.value = "consulta.CedentePropostasIniciar";
	        document.frmMain.fluxo.value = "voltar";				
					document.frmMain.submit();
		    }
		    
		    function validaSubmit(){
					if (document.frmMain.radioUnidade[0] != null) {
	
						if (!validaRadioButtonMsg(document.frmMain.radioUnidade, '', "003")) {
							return false;
						}
	
					} else if (document.frmMain.radioUnidade != null) {
	
						if (!document.frmMain.radioUnidade.checked) {
							msg('003', '');
							return false;
						}
	
					} else {
						return false;
					}
				
			    return true;
		    }
		    
		    function clickRadio( codigo ) {
		    	document.frmMain.Unidade.value = codigo;
		    }
	    </script>

		</s:FormStrategy>
	</p:Document>

</html>