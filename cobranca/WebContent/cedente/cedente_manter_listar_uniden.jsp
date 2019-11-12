<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.UnidadePVConteudoListaBean"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.List"%>

<%
 	UnidadePVConteudoListaBean fixoBean = (session.getAttribute(CedenteEstrategia.MANTER_FIXO_BEAN)==null
 	                                      ? new UnidadePVConteudoListaBean()
 	                                      : (UnidadePVConteudoListaBean)session.getAttribute(CedenteEstrategia.MANTER_FIXO_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(CedenteEstrategia.PAGINACAO_LIST);
	if(request.getParameter(CedenteEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(CedenteEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(CedenteEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(CedenteEstrategia.PAGINACAO_PAGE));
	}
	
	List lista = paginacao.getPage(paginaAtual);	
%>

<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteManterFiltro" fluxo="normal">   	          				
   		<s:Menu/>
   		<s:Titulo name="Manter Cedente (SR) >> Listar"/><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
   		
   		<input type="hidden" name="<%=CedenteEstrategia.PAGINACAO_PAGE%>" value="">
   		<input type="hidden" name="radioTipoConsulta" value="<%= CedenteEstrategia.OPCAO_BUSCA_UNIDADE %>">
   		<input type="hidden" name="tipoUnidade" value="<%= CedenteEstrategia.UNIDADE_PV %>">
			<input type="hidden" name="codigoUnidade">

	    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
	
	            <tr>
	              <td class="textoTitulo" width="17%">Unidade SR: </td><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
	              <td class="textoValor" width="26%"><%= fixoBean.getCodigoUnidadeENFormatado() %></td>
	  
	              <td class="textoTitulo" width="17%">Nome Unidade: </td>
	              <td class="textoValor" width="26%"><%= fixoBean.getNomeUnidadeEN() %></td>
	            </tr>
	            <tr> 
	              <td colspan="4">&nbsp;</td>
	            </tr>
	
	            <tr valign="top"> 
	              <td colspan="5" class="textoTitulo">Unidades:
	                <hr>
	              </td>
	            </tr>
	            
							<tr>
								<td colspan="4">
									<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
									  <tr class="headerLista">
									    <td width="5%" align="center">&nbsp;</td>
	 								    <td width="10%" align="right">Unidade PV</td>
									    <td width="20%" align="left">Nome Unidade</td>
									    <td width="50%" align="center">&nbsp;</td>
									  </tr>
									  
<%
	UnidadePVConteudoListaBean occ = new UnidadePVConteudoListaBean();
	for ( int i = 0; i < lista.size(); i++ ) {	
		occ = (UnidadePVConteudoListaBean) lista.get(i);
%>
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="5%" align="center">
									    	<input type="radio" name="radioUnidade" onclick="javascript:clickRadio('<%=occ.getCodigoUnidadePV()%>');">
									    </td>
	 								    <td width="10%" align="right"><%= occ.getCodigoUnidadePVFormatado() %></td>
	 								    <td width="20%" align="left"><%= occ.getNomeUnidadePV() %></td>
									    <td width="50%" align="center">&nbsp;</td>
									  </tr>
<%
	}
%>									  
	 	                <tr> 
		                  <td colspan="4">&nbsp;</td>
		                </tr>
										<tr>
											<td colspan="4" align="center">
											  <% String pageName = CedenteEstrategia.PAGE_MANTER_LISTAR_UNIDEN;%>
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
					document.frmMain.estrategia.value = "cedente.CedenteManterFiltro";
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
		    	document.frmMain.codigoUnidade.value = codigo;
		    }
	    </script>

		</s:FormStrategy>
	</p:Document>

</html>