<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: cedcent_consultar.jsp - Java Server Pages
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
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedCentBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.CedCentEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(CedCentEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(CedCentEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<% 
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(CedCentEstrategia.PAGINACAO_LIST);
	if(request.getParameter(CedCentEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(CedCentEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(CedCentEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(CedCentEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=CedCentEstrategia.STRATEGY_MANTER_INICIAR%>' fluxo="voltar">
	<s:Menu/>
		<s:Titulo name='<%=CedCentEstrategia.PAGE_TITLE_CONSULTA%>'/>
		
		<input type="hidden" name='<%=CedCentEstrategia.PAGINACAO_PAGE%>' value="">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
	          	<td class="textoTitulo" width="17%">Cedente: </td>
  	          <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
    	        <td class="textoTitulo" width="17%">Nome Cedente: </td>
      	      <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td>
            </tr>
            <tr>
	          	<td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
  	          <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 
    	        <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
      	      <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
	          	<td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
  	          <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
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
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="10%" align="right">Cedente</td>
								    <td nowrap width="49%" align="left">Nome Cedente</td>
 								    <td nowrap width="20%" align="left">Tipo de Pessoa</td>
								    <td nowrap width="20%" align="right">CPF/CNPJ</td>
								  </tr>
<%
										CedCentBean oBean = new CedCentBean();
										for ( int i = 0; i < lista.size(); i++ ) {	
											oBean = (CedCentBean) lista.get(i);
%>
											<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
										    <td nowrap width="1%" align="center">&nbsp;</td>
 										    <td nowrap width="10%" align="right"><%=oBean.getCodigoCedenteCentralFormatado()%></td>
 										    <td nowrap width="49%" align="left"><%=oBean.getNomeFantasia()%></td>
 										    <td nowrap width="20%" align="left"><%=oBean.getTipoPessoaTexto()%></td>
 										    <td nowrap width="20%" align="right"><%=oBean.getCpfCnpjFormatado()%></td>
										  </tr>
<%                	} %>								  
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="6" align="center">
											<s:ButtonPaginar 
									  		 pageNumber="<%=paginacao.getPageNumber()%>" 
											   numberOfPages="<%=paginacao.getPageCount()%>" 
									  		 pageName="<%=CedCentEstrategia.PAGE_JSP_CONSULTAR%>"/>											   
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
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
  	            	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
								</p>
	            </td>
	          </tr>
          </table>
        </td>
      </tr>
    </table>
		<script language="javascript">
    function inicia(){
    }

    function formSubmit_Voltar() {
       document.frmMain.submit();
    }
    
    function formSubmit() {
      
    }
    </script>
	</s:FormStrategy>
	</p:Document>
</html>
