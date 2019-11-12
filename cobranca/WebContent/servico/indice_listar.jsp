<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: tarifa_manter_listar.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 29/08/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.IndiceBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.IndiceEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(IndiceEstrategia.PAGINACAO_LIST);
	if(request.getParameter(IndiceEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(IndiceEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(IndiceEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(IndiceEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=IndiceEstrategia.STRATEGY_CONSULTAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=IndiceEstrategia.PAGE_TITLE_MANTER_LISTAR%>"/>
		
		<input type="hidden" name="sigla" value="" />
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
								    <td nowrap width="3%" align="center">&nbsp;</td>
 								    <td nowrap width="10%" align="left">Sigla</td>
								    <td nowrap width="10%" align="left">Número</td>
 								    <td nowrap width="57%" align="left">Nome</td>
								    <td nowrap width="10%" align="left">Indicador</td>
								    <td nowrap width="10%" align="left">Situação</td>
								  </tr>
								  
							<%
									IndiceBean occ = new IndiceBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (IndiceBean) lista.get(i);
							%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="3%" align="center">
								    	<input type="radio" name="rdo"
								    		onclick="javascript: clickRadio('<%=occ.getSigla()%>');">
								    </td>
										<td width="10%" align="left"><%= occ.getSigla() %></td>
										<td width="10%" align="left"><%= occ.getNuIndice() %></td>
										<td width="57%" align="left"><%= occ.getNoIndice() %></td>
										<td width="10%" align="left"><%= occ.getIcStco() %></td>
										<td width="10%" align="left"><%= occ.getDeStco() %></td>
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
											  		pageName="<%=IndiceEstrategia.PAGE_LISTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="5">&nbsp;</td>
	                </tr>

	                <tr>
	                  <td align="right" colspan="5">
	                    <p align="center"> 
	                    	<s:Button name="Consultar" action="javascript: formSubmit_Consultar();" />
	                    	<s:Button name="Alterar" action="javascript: formSubmit_Alterar();"  />
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
			function inicia() {
				setFirstFieldFocus();
			}
			function formSubmit_Consultar() {
				formSubmit();
			}
	   
			
		function formSubmit_Consultar() { // Acao default consultar
		     
		  	if (validaSubmit()) {
		      	document.frmMain.submit();
		     	}
		  
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
		
	    
	    function formSubmit_Alterar() {
	        if (validaSubmit()) {
		    		document.frmMain.estrategia.value = "<%=IndiceEstrategia.STRATEGY_ALTERAR_INICIAR%>";
		          	document.frmMain.submit();
		    }
		}
		
	    function formSubmit_Voltar() {
	        document.frmMain.estrategia.value = "<%=IndiceEstrategia.STRATEGY_MANTER_INICIAR%>";
	        document.frmMain.fluxo.value = "voltar";
	        document.frmMain.submit();
      	}
			
			
      function clickRadio(registro) {
				document.frmMain.sigla.value = registro;
      }
    </script>
  </s:FormStrategy>
</p:Document>
</html>