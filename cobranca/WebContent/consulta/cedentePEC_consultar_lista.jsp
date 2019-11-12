<%
/***********************************************
*Projeto CAIXA - SIGCB
*Autor: Maurício Assis de Holanda
*Data criação: Abril / 2013
************************************************/
%>



<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePECBean"%>
<%@page import="br.gov.caixa.sigcb.bean.FiltroPesquisa"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.CedenteMasterPECEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

	CedentePECBean cedentePECBean = (session.getAttribute(CedenteMasterPECEstrategia.FILTRO_BEAN)==null
 	                                        ? new CedentePECBean()
 	                                        :(CedentePECBean)session.getAttribute(CedenteMasterPECEstrategia.FILTRO_BEAN));
	
	CedentePECBean cedentePECFIXOBean = (session.getAttribute(CedenteMasterPECEstrategia.FIXO_BEAN)==null
             ? new CedentePECBean()
             :(CedentePECBean)session.getAttribute(CedenteMasterPECEstrategia.FIXO_BEAN));
	
	FiltroPesquisa filtroPesquisa = (session.getAttribute("FILTRO_PESQUISA")==null ? new FiltroPesquisa() : (FiltroPesquisa)session.getAttribute("FILTRO_PESQUISA"));
	
	String pagfiltro = (String) request.getAttribute("PAGFILTRO");
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(CedenteMasterPECEstrategia.PAGINACAO_LIST);
	//if(request.getParameter(ConsultaLiqStrManterEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ConsultaLiqStrManterEstrategia.PAGINACAO_PAGE).equals("")){
	//	paginaAtual = Integer.parseInt((String)request.getParameter(ConsultaLiqStrManterEstrategia.PAGINACAO_PAGE));
	//} else {
	//	paginaAtual = Integer.parseInt((String)request.getAttribute(ConsultaLiqStrManterEstrategia.PAGINACAO_PAGE));
	//}
	
	List lista = paginacao.getPage(paginaAtual);	
	
	
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=CedenteMasterPECEstrategia.STRATEGY_MANTER_FILTRO %>" fluxo="normal">
		<s:Menu/>
		<%if (cedentePECBean.getCodigoCedente()>0) {%>
		<s:Titulo name="<%=CedenteMasterPECEstrategia.PAGE_TITLE_CONSULTA_VINCULADA %>"/>
		<%}else{ %>
		<s:Titulo name="<%=CedenteMasterPECEstrategia.PAGE_TITLE_CONSULTA %>"/>
		
		<%} %>
		
		<input type="hidden" name="paginaFiltro" value="<%= pagfiltro %>">
		<input type="hidden" name="processarFiltro" value="N">
		<input type="hidden" name="codigoCedente" value="">
		<input type="hidden" name="radioTipoConsulta" value="">
		<input type="hidden" name="voltar" value="<%=cedentePECBean.getVoltar() %>">
		<input type="hidden" name="retornoPEC" value="S">
		

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
				<td valign="top" width="5%" height="14" align="left">&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            
			<%if (cedentePECBean.getCodigoCedente()>0) {%>
            <tr valign="top"> 
 				<td class="textoTitulo" width="17%">Cedente Master PEC : </td>
              	<td class="textoValor" width="26%"><%= cedentePECFIXOBean.getCodigoCedenteFormatado() %></td>
              	<td class="textoTitulo" width="17%">Nome Cedente: </td>
              	<td class="textoValor" width="26%"><%= cedentePECFIXOBean.getNomeFantasia() %></td> 
            </tr>
            <tr valign="top"> 
 				<td class="textoTitulo" width="17%">&nbsp;</td>
              	<td class="textoValor" width="26%">&nbsp;</td>
              	<td class="textoTitulo" width="17%">Situação: </td>
              	<td class="textoValor" width="26%"><%= cedentePECFIXOBean.getSituacaoStr()%></td> 
            </tr>
            <tr valign="top"> 
 				<td class="textoTitulo" colspan="4"><hr></td>
            </tr>
            
            <%}%>
            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
						<tr>
							<td colspan="4">
								<table width="777" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <%if (cedentePECBean.getCodigoCedente()>0) {%>
								    <td nowrap width="2%" align="center">&nbsp;</td>
									<td nowrap width="25%" align="center">Cedente PEC Vinculado</td>
								    <td nowrap width="45%" align="center">Nome</td>
								    <td nowrap width="28%" align="center">Situação</td>
								    <td nowrap width="28%" align="center">Data da Vinculação</td>
								    <%}else{ %>
								    <td nowrap width="2%" align="center">&nbsp;</td>
									<td nowrap width="25%" align="center">Cedente Master PEC</td>
								    <td nowrap width="45%" align="center">Nome</td>
								    <td nowrap width="28%" align="center">Situação</td>
									<%} %>								    
								    
								  </tr>

							<%
									CedentePECBean occ = new CedentePECBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (CedentePECBean) lista.get(i);
							%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								  
								  	<%if (cedentePECBean.getCodigoCedente()>0) {%>
									    <td width="2%" align="center">
									    	<input type="radio" name="radioSTR" onclick="javascript:clickRadio('<%=occ.getCodigoCedente()%>');">
									    </td>
									    <td nowrap align="center"><%= occ.getCodigoCedenteFormatado() %></td>
	 								    <td nowrap align="center"><%= occ.getNomeFantasia() %></td>
	 								    <td nowrap align="center"><%= occ.getSituacaoStr() %></td>
	 								    <td nowrap align="center"><%= occ.getData() %></td>
								    <%}else{ %>
									    <td width="2%" align="center">
									    	<input type="radio" name="radioSTR" onclick="javascript:clickRadio('<%=occ.getCodigoCedente()%>');">
									    </td>
									    <td nowrap align="center"><%= occ.getCodigoCedenteFormatado() %></td>
	 								    <td nowrap align="center"><%= occ.getNomeFantasia() %></td>
	 								    <td nowrap align="center"><%= occ.getSituacaoStr() %></td>
								    <%} %>
								  
								   
 								    
								  </tr>
							<%  } %>								  

 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="11" align="center">
											<%String pageName =CedenteMasterPECEstrategia.PAGE_JSP_CONSULTAR;%>
										  <s:paginacao		estrategia="<%=CedenteMasterPECEstrategia.STRATEGY_MANTER_FILTRO %>" />
										</td>
									</tr>
									
									
									
 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="11">
	                    <p align="center">
	                    	<s:Button name="buttonConsultar" value="OK"  action="javascript:formSubmit_Consultar();" />
	                    	<s:Button name="voltar" value="Voltar"  action="javascript:volta();" />
	                    </p>
	                  </td>
	                </tr>
 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
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
			
			function formSubmit_Consultar() {
				
				if (<%= cedentePECBean.getCodigoCedente()%>>0){
					if (document.frmMain.codigoCedente.value==""){
						alert("Cedente deve ser selecionado");
						return false;
					}
					document.frmMain.estrategia.value = "<%=CedenteMasterPECEstrategia.STRATEGY_MANTER_CONSULTAR %>";
					document.frmMain.radioTipoConsulta.value="1";
				}else{
					document.frmMain.estrategia.value = "<%=CedenteMasterPECEstrategia.STRATEGY_MANTER_FILTRO %>";
				}
	     		document.frmMain.submit();			
				
			}

			function volta(){
	    		if (<%= cedentePECBean.getCodigoCedente()%>>0){
	    			if ("<%=cedentePECBean.getVoltar() %>"=="M"){
	    				document.frmMain.estrategia.value = "<%=CedenteMasterPECEstrategia.STRATEGY_MANTER_INICIAR %>";
	    			}else{
	    				document.frmMain.estrategia.value = "<%=CedenteMasterPECEstrategia.STRATEGY_MANTER_FILTRO %>";	
	    			}
					document.frmMain.codigoCedente.value = "";
				}else{
					document.frmMain.estrategia.value = "<%=CedenteMasterPECEstrategia.STRATEGY_MANTER_INICIAR %>";
					document.frmMain.codigoCedente.value ="";
				}
	    		document.frmMain.submit();
			}
			
	    	
      		function clickRadio(codCedente) {
      			document.frmMain.codigoCedente.value = codCedente;
      			
      		}

		</script>

	</s:FormStrategy>
</p:Document>
</html>