<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: histced_manter_listar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 08/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BaixaOperacionalBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.BaixaOperacionalEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(BaixaOperacionalEstrategia.PAGINACAO_LIST);
	if(request.getParameter(BaixaOperacionalEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(BaixaOperacionalEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(BaixaOperacionalEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(BaixaOperacionalEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
BaixaOperacionalBean baixaBean = (session.getAttribute(BaixaOperacionalEstrategia.DATA_BEAN)==null?new BaixaOperacionalBean():(BaixaOperacionalBean)session.getAttribute(BaixaOperacionalEstrategia.DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=BaixaOperacionalEstrategia.STRATEGY_CONSULTAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=BaixaOperacionalEstrategia.PAGE_TITLE_LISTA%>"/>    
  	<input type="hidden" name="nuIdentificacao" value="">
  	<input type="hidden" name="nuIdentiBaixaOper" value="">
  	<input type="hidden" name="dtHoraBaixaOper" value="">
  	<input type="hidden" name="<%=BaixaOperacionalEstrategia.PAGINACAO_PAGE%>" value="">
  	
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Número de Identificação: </td>
              <td class="textoValor" width="26%"><%=baixaBean.getNuIdentificacao().toString()%></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Baixas:
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="15%" align="center">Identificação</td>
								    <td nowrap width="15%" align="center">Ident. Baixa</td>
								    <td nowrap width="25%" align="center">Data/Hora</td>
								    <td nowrap width="20%" align="center">Valor Baixa</td>								    
								    <td nowrap width="10%" align="center">Tipo</td>								    
								  </tr>
							<%
									BaixaOperacionalBean occ = new BaixaOperacionalBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (BaixaOperacionalBean) lista.get(i);
							%>
									  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									      <input type="radio" name="rdo"
								    		 onclick="javascript: clickRadio('<%=occ.getNuIdentificacao().toString()%>','<%=occ.getNuIdentiBaixaOper().toString()%>','<%=occ.getDtHoraBaixaOper()%>');">
								    	</td>
	 								    <td width="15%" align="left"><%=occ.getNuIdentificacao().toString()%></td>
	 								    <td width="15%" align="left"><%=occ.getNuIdentiBaixaOper().toString()%></td>
										<td width="25%" align="left"><%=occ.getDtHoraBaixaOper()%></td>	 								    
										<td width="20%" align="right"><%=occ.getVlrBaixaOper().toString()%></td>	 								    
								      	<td width="10%" align="left"><%=occ.getTpBaixaOper()%></td>								    
									  </tr>
						<%  } %>	  

 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="6" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=BaixaOperacionalEstrategia.PAGE_LISTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="6">
	                    <p align="center"> 
	                      <s:Button name="Ok" action="javascript:formSubmit();"/>
	                      <s:Button name="Voltar" action="javascript:formSubmit_Voltar();"/>
	                    </p>
	                  </td>
	                </tr>
 	                <tr> 
	                  <td colspan="8">&nbsp;</td>
	                </tr>
	              </table>
              </td>
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
           				document.frmMain.fluxo.value = "voltar";
           				document.frmMain.estrategia.value = "consulta.BaixaOperacionalManterIniciar";
           				document.frmMain.submit();
      }  

			function validaSubmit() {
				<%if(paginacao.getCurrentPageSize() > 1){%>
			    if(!validaRadioButton(document.frmMain.rdo, '')){
					  return false;
		  	  }
				<%} else {%>
					if(! document.frmMain.rdo.checked){
						msg('003', '');
						return;
					}
				<%}%>
		    	return true;
		  	}
	    
			  function clickRadio(nuIdentificacao, nuIdentiBaixaOper,dataHora) {
		    		document.frmMain.nuIdentificacao.value = nuIdentificacao;
					document.frmMain.nuIdentiBaixaOper.value = nuIdentiBaixaOper; 
					document.frmMain.dtHoraBaixaOper.value = dataHora; 
	      }
		</script>
  </s:FormStrategy>
</p:Document>
</html>
