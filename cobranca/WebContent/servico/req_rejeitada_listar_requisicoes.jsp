<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: tarifa_manter_listar.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Author Eduardo A. Mor�s - emoras@sao.politec.com.br 
*Ultima Atualiza��o: 29/08/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ReqRejeitadaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ReqRejeitadaEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ReqRejeitadaEstrategia.PAGINACAO_LIST);
	if(request.getParameter(ReqRejeitadaEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ReqRejeitadaEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ReqRejeitadaEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ReqRejeitadaEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ReqRejeitadaEstrategia.STRATEGY_MANTER_DETALHE%>" fluxo="voltar">
		<s:Menu/>
		<s:Titulo name="<%=ReqRejeitadaEstrategia.PAGE_TITLE_LISTAR_REQUISICOES%>"/>
		
		<input type="hidden" name="nuCtrlReq" value="" />
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">&nbsp;
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
 								    <td nowrap width="15%" align="left">Num. Ctrl. Req.</td>
								    <td nowrap width="15%" align="left">Cod. Envio Req.</td>
 								    <td nowrap width="25%" align="left">Data/Hora Envio Req.</td>
								    <td nowrap width="15%" align="left">Cod. Retorno</td>
								    <td nowrap width="25%" align="left">Data/Hora Retorno</td>
								    
								  </tr>
								  
							<%
									ReqRejeitadaBean occ = new ReqRejeitadaBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ReqRejeitadaBean) lista.get(i);
							%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
										<td width="15%" align="left"><%= occ.getNuCtrlReq() %></td>
										<td width="15%" align="left"><%= occ.getCoEnvioReq() %></td>
										<td width="25%" align="left"><%= occ.getTsEnvioReq() %></td>
										<td width="15%" align="left"><%= occ.getCoRetReq() %></td>
										<td width="25%" align="left"><%= occ.getTsRetReq() %></td>
										
									</tr>
							<%  } %>
 	                <tr> 
	                  <td colspan="5">&nbsp;</td>
	                </tr>

									<tr>
										<td colspan="5" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=ReqRejeitadaEstrategia.PAGE_TITLE_LISTAR_REQUISICOES%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="5">&nbsp;</td>
	                </tr>

	                <tr>
	                  <td align="right" colspan="5">
	                    <p align="center"> 
	                    	<s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
	                    </p>
	                  </td>
	                </tr>
 	                <tr> 
	                  <td colspan="5">&nbsp;</td>
	                </tr>
	                
	              </table>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    <script>

		
	 
		
	    function formSubmit_Voltar() {
	        document.frmMain.estrategia.value = "<%=ReqRejeitadaEstrategia.STRATEGY_MANTER_DETALHE%>";
	        document.frmMain.fluxo.value = "voltar";
	        document.frmMain.submit();
      	}
			
			
     
    </script>
  </s:FormStrategy>
</p:Document>
</html>