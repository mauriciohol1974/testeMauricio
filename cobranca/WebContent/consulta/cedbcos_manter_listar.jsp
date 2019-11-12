<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: cedbcos_manter_listar.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 28/10/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedBcoSBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.CedBcoSEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	CedBcoSBean cedBcoBean = (session.getAttribute(CedBcoSEstrategia.DATA_BEAN)==null?new CedBcoSBean():(CedBcoSBean)session.getAttribute(CedBcoSEstrategia.DATA_BEAN));	
%>

<% 
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(CedBcoSEstrategia.PAGINACAO_LIST);
	if(request.getParameter(CedBcoSEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(CedBcoSEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(CedBcoSEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(CedBcoSEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=CedBcoSEstrategia.STRATEGY_MANTER_INICIAR%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='<%=CedBcoSEstrategia.PAGE_TITLE_LISTAR%>'/>
		
		<input type="hidden" name='<%=CedBcoSEstrategia.PAGINACAO_PAGE%>' value="">
		<input type="hidden" name="codigoCedente"   value="">		
		<input type="hidden" name="codigoUnidadePV" value='<%=cedBcoBean.getCodigoUnidadePV().toString()%>'>

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Unidade PV: </td>
              <td class="textoValor" width="26%"><%=cedBcoBean.getCodigoUnidadePVFormatado().toString()%></td>
              <td class="textoTitulo" width="17%">Nome Unidade: </td>
              <td class="textoValor" width="26%"><%=cedBcoBean.getNomeUnidadePV()%></td>
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
								    <td width="1%" align="center">&nbsp;</td>
 								    <td width="10%" align="right">Cedente</td>
								    <td width="64%" align="left">Nome Cedente</td>
								    <td width="25%" align="center">Data Inclusão</td>
								  </tr>
<%
									CedBcoSBean oBean = new CedBcoSBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
									oBean = (CedBcoSBean) lista.get(i);
%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
										<td width="1%" align="center">
											<input type="radio" name="radi" 
											    onclick="javascript: clickRadio('<%=oBean.getCodigoCedente()%>');">
								    </td>								    												    
										<td width="10%" align="right"><%=oBean.getCodigoCedenteFormatado()%></td>
										<td width="64%" align="left"><%=oBean.getNomeFantasia()%></td>
								    <td width="25%" align="center"><%=oBean.getFormataData(oBean.getDataInclusao().toString())%></td>
									</tr>
								<% } %>
							  
                <tr> 
		              <td colspan="4">&nbsp;</td>
	              </tr>

								<tr>
									<td colspan="10" align="center">
										<s:ButtonPaginar 
								  		 pageNumber="<%=paginacao.getPageNumber()%>" 
										   numberOfPages="<%=paginacao.getPageCount()%>" 
								  		 pageName="<%=CedBcoSEstrategia.PAGE_JSP_LISTAR%>"/>											   
									</td>
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
                  <s:Button name="Ok" action="javascript:formSubmit_Ok()"/>
                  <s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
								</p>
	            </td>
	          </tr>
          </table>
        </td>
      </tr>
    </table>
    <script language="javascript">
    function formSubmit() {
      
    }

	  function inicia(){
	
		}
	        
    function formSubmit_Voltar() {
       document.frmMain.fluxo.value = "voltar";
       document.frmMain.submit();
    }

    function formSubmit_Ok() {
			<%if(paginacao.getCurrentPageSize() > 1){%>
					if(!validaRadioButton(document.frmMain.radi, "")){
					  return false;
					}
			<%} else {%>
					if(!document.frmMain.radi.checked){
						msg('003', '');
						return false;
					}
			<%}%>
			 document.frmMain.estrategia.value = '<%=CedBcoSEstrategia.STRATEGY_CONSULTAR%>'
       document.frmMain.submit();
    }
    
	  function clickRadio(codCed) {
			document.frmMain.codigoCedente.value = codCed;
	  }
    
    </script>
	</s:FormStrategy>
	</p:Document>
</html>
