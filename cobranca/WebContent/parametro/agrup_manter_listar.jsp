<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: agrup_manter_listar.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 29/08/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.AgrupamentoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.AgrupEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");
	AgrupamentoBean agrupBean = (session.getAttribute(AgrupEstrategia.FILTRO_BEAN)==null?new AgrupamentoBean():(AgrupamentoBean)session.getAttribute(AgrupEstrategia.FILTRO_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(AgrupEstrategia.PAGINACAO_LIST);
	if(request.getParameter(AgrupEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(AgrupEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(AgrupEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(AgrupEstrategia.PAGINACAO_PAGE));
	}
	
	List lista = paginacao.getPage(paginaAtual);	
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=AgrupEstrategia.STRATEGY_ALTERAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=AgrupEstrategia.PAGE_TITLE_MANTER%>"/>
		
		<input type="hidden" name = "codigoAgrupamento" value="">
		<input type="hidden" name = "<%=AgrupEstrategia.PAGINACAO_PAGE%>" value="">

   	<input type="hidden" name="registro" value="">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
						<tr>
							<td colspan="4"> 
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Agrupamento</td>
								    <td nowrap width="80%" align="left">Descrição</td>
								  </tr>

							<%
									AgrupamentoBean occ = new AgrupamentoBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (AgrupamentoBean) lista.get(i);
							%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="2%" align="center">
								    	<input type="radio" name="rdo"
								    		onclick="javascript: clickRadio('<%=occ.getRegistro()%>');">
								    </td>
										<td width="20%" align="left"><%= occ.getCodigoAgrupamento() %></td>
										<td width="80%" align="left"><%= occ.getDescricaoAgrupamento() %></td>
									</tr>
							<%  } %>
 	                <tr> 
	                  <td colspan="3">&nbsp;</td>
	                </tr>

									<tr>
										<td colspan="3" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=AgrupEstrategia.PAGE_MANTER_LISTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="3">&nbsp;</td>
	                </tr>

	                <tr>
	                  <td align="right" colspan="3">
	                    <p align="center"> 
	                    	<s:Button name="Alterar" action="javascript: formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="parametro.agrupamento.manter.alterar" />
	                    	<s:Button name="Excluir" action="javascript: formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="parametro.agrupamento.manter.excluir" />
	                    	<s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
	                    </p>
	                  </td>
	                </tr>
 	                <tr> 
	                  <td colspan="3">&nbsp;</td>
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
			function formSubmit_Alterar() {
				formSubmit();
			}
	    function formSubmit() { // Acao default alterar
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
			function formSubmit_Excluir() {
        if (validaSubmit()) {
	    		if (confirm(conf("102", "Agrupamento de Serviços"))) {
						document.frmMain.estrategia.value = "<%=AgrupEstrategia.STRATEGY_EXCLUIR%>";
	          document.frmMain.submit();
         	}
	      }
			}
			function formSubmit_Voltar() {
        document.frmMain.estrategia.value = "<%=AgrupEstrategia.STRATEGY_MANTER_FILTRO%>";
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
      }
      function clickRadio(registro) {
				document.frmMain.registro.value = registro;
      }
    </script>
  </s:FormStrategy>
</p:Document>
</html>