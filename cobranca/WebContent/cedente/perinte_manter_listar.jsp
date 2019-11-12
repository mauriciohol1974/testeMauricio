<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: perinte_manter_listar.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 13/10/2004 16:07
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.PerfilInternetBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.PerInteEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");

	PerfilInternetBean perfilInternetBean = (session.getAttribute(PerInteEstrategia.DATA_BEAN)==null?new PerfilInternetBean():(PerfilInternetBean)session.getAttribute(PerInteEstrategia.DATA_BEAN));
	
	PageHolder paginacao = (PageHolder) session.getAttribute(PerInteEstrategia.PAGINACAO_LIST);

	int paginaAtual = 0;
	if(request.getParameter(PerInteEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(PerInteEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(PerInteEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(PerInteEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
	String tmp="";	
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=PerInteEstrategia.STRATEGY_ALTERAR_INICIAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=PerInteEstrategia.PAGE_TITLE_MANTER_LISTAR%>"/>
		<input type="hidden" name = "codigoPerfil" value="">
		<input type="hidden" name = "pos" value="">
		
		<input type="hidden" name = "<%=PerInteEstrategia.PAGINACAO_PAGE%>" value="">
		<input type="hidden" name = "<%=PerInteEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 align="center">
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Perfil Internet
                <hr>
              </td>
            </tr>
			<tr>
				<td colspan="4"> 
					<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" >
						<tr class="headerLista">
							<td nowrap width="2%" align="center">&nbsp;</td>
 							<td nowrap width="13%" align="left"><div align="right">Perfil</div></td>
						    <td nowrap width="70%" align="left">Descição</td>
						    <td nowrap width="15%" align="left">Serviço</td>
						</tr>            
						<%
						PerfilInternetBean occ = new PerfilInternetBean();
	
						for ( int i = 0; i < lista.size(); i++ ) {	
						occ = (PerfilInternetBean) lista.get(i);
						%>								  
					    <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
							<td width="2%" align="center">
						  		<input type="radio" name="rdo"
						 		onclick="javascript: clickRadio('<%=occ.getCodigoPerfil()%>', '<%=i%>');">
							</td>
	 						<td width="13%" align="right"><%=occ.getCodigoPerfil()%></td>
	 						<td width="70%" align="left"><%=occ.getDescricaoPerfil()%></td>
						    <td width="15%" align="left"><%=occ.getServicoPerfil()%></td>
					  	</tr>	
						<%  } %>								  						  
					</table>
				</td>
			</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
				<tr>
					<td colspan="4" align="center">
							  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=Paths.getRootForDynamicContent() + PerInteEstrategia.PAGE_MANTER_LISTAR%>"/>
					</td>
				</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center"> 
                	<s:Button name="Alterar" action="javascript: formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="parametro.pvcobrador.manter.alterar"/>
                	<s:Button name="Excluir" action="javascript: formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="parametro.pvcobrador.manter.excluir" />
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
		function inicia() {
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
    			if (confirm(conf("102", "Perfil"))) {
					document.frmMain.estrategia.value = "<%=PerInteEstrategia.STRATEGY_EXCLUIR%>";
		    	    document.frmMain.submit();
    	     	}
	    	}
		}
			
    	function clickRadio(perfil, pos) {
			document.frmMain.codigoPerfil.value = perfil;
			document.frmMain.pos.value = pos;
	    }
    </script>
  </s:FormStrategy>
</p:Document>
</html>