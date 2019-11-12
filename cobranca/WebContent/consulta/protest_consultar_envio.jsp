<%
/***********************************************
*Projeto CAIXA - SIGCB
*Componente: protest_consultar_envio.jsp - Java Server Pages
*Autor: Cristian Souza - Probank/REDEASP02
*Data Criação: Fev/2009
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ProtestoTituloBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ProtestEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ProtestEstrategia.PAGINACAO_LIST);
	if(request.getParameter(ProtestEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ProtestEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ProtestEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ProtestEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	ProtestoTituloBean protestoTituloBean = (session.getAttribute(ProtestEstrategia.PROTESTO_TITULO_DATA_BEAN)==null?new ProtestoTituloBean():(ProtestoTituloBean)session.getAttribute(ProtestEstrategia.PROTESTO_TITULO_DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ProtestEstrategia.STRATEGY_ENVIO_AO_CARTORIO_FILTRO %>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=ProtestEstrategia.PAGE_TITLE_ACAO_PROTESTO_ENVIO_AO_CARTORIO%>"/>    
  	<input type="hidden" name="<%=ProtestEstrategia.PAGINACAO_PAGE%>" value="">
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%"><%=(protestoTituloBean.getFiltroSelecao().equals(2)?"Data da Previsão Protesto:":"Data da Solicitação:")%> </td>
              <!--  <td class="textoTitulo" width="17%">Data da Solicitação: </td>  -->
              <td nowrap class="textoValor" width="26%"><%=protestoTituloBean.getDataSolicitacaoFormatada().equals("01/01/0001")?"":protestoTituloBean.getDataSolicitacaoFormatada()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Unidade Cobradora: </td>
              <td nowrap class="textoValor" width="26%"><%=protestoTituloBean.getCodigoUnidadePv().equals( new Long(0))?"":protestoTituloBean.getCodigoUnidadePvFormatado()%> - <%=protestoTituloBean.getNomeUnidadePv()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Ação: </td>
              <td nowrap class="textoValor" width="26%">CONSULTAR</td>
            </tr>  
            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
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
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="15%" align="right">Nosso Número</td>
								    <td nowrap width="25%" align="left">Cedente</td>
								    <td nowrap width="30%" align="left">Nome Devedor</td>
                                    <td nowrap width="10%" align="left">Data Prevista</td>
								    <td nowrap width="20%" align="left">Valor Título</td>
								    <td nowrap width="10%" align="left">Parcela</td>
                                    <td nowrap width="20%" align="left">Despesas Cartorárias</td>
								  </tr>
							<%
									ProtestoTituloBean occ = new ProtestoTituloBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ProtestoTituloBean) lista.get(i);
							%>								  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="15%" align="right"><%=occ.getNossoNumeroFormatado()%></td>
								    <td nowrap width="25%" align="right"><%=occ.getCodigoCedenteFormatado()%></td>
								    <td nowrap width="30%" align="left"><%=occ.getNomeDevedor()%></td>
                                    <td nowrap width="5%" align="left"><%=occ.getDataEnvioProtestoFormatada().equals("01/01/0001")?"":occ.getDataEnvioProtestoFormatada()%></td>
 								    <td nowrap width="20%" align="left"><%=occ.getValorTitulo()%></td>
 								    <td nowrap width="10%" align="left"><%=occ.getParcela()%></td>
                                    <td nowrap width="20%" align="left"><%=occ.getValorCusta()%></td>
							    
								  </tr>
						<%  } %>								  
 	                <tr>
	                  <td colspan="12">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="10" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=ProtestEstrategia.PAGE_CONSULTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="12">&nbsp;</td>
	                </tr>
	              </table>
              </td>
            </tr>

            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Totais:
                <hr>
              </td>
            </tr>

            <tr>
              <td class="textoTitulo" width="28%">Quantidade Total: </td>
              <td class="textoValor" width="20%"><%=protestoTituloBean.getQuantidadeTotalTitulo()%></td> 
              <td class="textoTitulo" width="24%">Valor Total: </td>
              <td class="textoValor" width="28%"><%=protestoTituloBean.getValorTotalTitulo()%></td>
            </tr>

 	          <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>
 	          <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>
	          
            <tr>
              <td align="right" colspan="4">
 	              <p align="center"> 
	                <s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
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
	    }

	  	function formSubmit() {
        if(validaSubmit()){   
           document.frmMain.submit();
        }
	    }  
	    
	    function formSubmit_Voltar() {
						document.frmMain.estrategia.value = '<%=ProtestEstrategia.STRATEGY_MANTER_ENVIO_AO_CARTORIO_INICIAR%>';    	
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
      }  

			function validaSubmit() {
	  	}

		</script>
  </s:FormStrategy>
</p:Document>
</html>