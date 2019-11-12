<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: arqreme_manter_listar.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 28/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ArquivoRemessaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ArqRemeEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="java.util.List"%>

<%
	ArquivoRemessaBean arqBean = (session.getAttribute(ArqRemeEstrategia.DATA_BEAN)==null?new ArquivoRemessaBean():(ArquivoRemessaBean)session.getAttribute(ArqRemeEstrategia.DATA_BEAN));

	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ArqRemeEstrategia.PAGINACAO_LIST);
	if(request.getParameter(ArqRemeEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ArqRemeEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ArqRemeEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ArqRemeEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
	String tmp="";	
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ArqRemeEstrategia.STRATEGY_MANTER_FILTRO %>" fluxo="normal">
	<s:Menu/>
	<s:Titulo name="<%=ArqRemeEstrategia.PAGE_TITLE_MANTER_LISTAR%>"/>
	<input type="hidden" name = "codigoCedente" value="">
	<input type="hidden" name = "dataInicial" value=<%=Formatador.formatarData(arqBean.getDataInicial())%>>
	<input type="hidden" name = "dataFinal" value=<%=Formatador.formatarData(arqBean.getDataFinal())%>>		
	<input type="hidden" name = "opcaoConsulta" value="CEDENTE">	
	<input type="hidden" name = "codigoUnidadePV" value=<%=arqBean.getCodigoUnidadePV()+""%>>
	<input type="hidden" name = "codigoUnidadeCentral" value=<%=arqBean.getCodigoUnidadeCentral()%>>
	<input type="hidden" name = "<%=ArqRemeEstrategia.PAGINACAO_PAGE%>" value="">
	<input type="hidden" name = "<%=ArqRemeEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 align="center">
	          <tr>
  			     <td class="textoTitulo" width="17%">Unidade PV:</td>
	             <td class="textoValor" width="26%"><%=arqBean.getCodigoUnidadePVFormatado()%></td>
			     <td class="textoTitulo" width="17%">Nome Unidade: </td>
         		 <td class="textoValor" width="26%"><%=arqBean.getNomeUnidadePV()%></td> 
	          </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Cedentes:
                <hr>
              </td>
            </tr>
			<tr>
				<td colspan="4"> 
					<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" >
						<tr class="headerLista">
					    	<td nowrap width="3%" align="center">&nbsp;</td>
							<td nowrap width="10%" align="right">Cedente</td>
							<td nowrap width="7%" align="left">Apelido</td>
 							<td nowrap width="30%" align="left">Nome</td>
 							<td nowrap width="25%" align="right">Nro próxima Remessa</td>
 							<td nowrap width="25%" align="right">Nro último retorno</td>
						</tr>
						<%
						ArquivoRemessaBean occ = new ArquivoRemessaBean();
						for ( int i = 0; i < lista.size(); i++ ) {	
							occ = (ArquivoRemessaBean) lista.get(i);
							%>
						  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
						    <td width="3%" align="center">
					    		<input type="radio" name="rdo"
					    		onclick="javascript: clickRadio('<%=occ.getCodigoCedente()%>');">
						    </td>
 						    <td width="10%" align="right"><%=occ.getCodigoCedenteFormatado()%></td>
				    		<td width="7%" align="left"><%=occ.getApelidoCedente()%></td>
						    <td width="30%" align="left"><%=occ.getNomeCedente()%></td>
						    <td width="25%" align="right"><%=occ.getNumeroProxRemessa().longValue()==0 ?  "": occ.getNumeroProxRemessa().toString()%></td>
						    <td width="25%" align="right"><%=occ.getNumeroUltRetorno().longValue()==0 ?  "": occ.getNumeroUltRetorno().toString()%></td>
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
				  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=Paths.getRootForDynamicContent() + ArqRemeEstrategia.PAGE_MANTER_LISTAR%>"/>
				</td>
			</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center"> 
                	<s:Button name="Ok" action="javascript: formSubmit();"/>
                	<s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
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
			setFirstFieldFocus();
		}

	    function formSubmit() { 
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

		function formSubmit_Voltar() {
			document.frmMain.estrategia.value = "<%=ArqRemeEstrategia.STRATEGY_MANTER_INICIAR%>";
		    document.frmMain.fluxo.value = "voltar";
		    document.frmMain.submit();
		}
		
		function clickRadio(codigo) {
			document.frmMain.codigoCedente.value = codigo;
		}
    </script>
  </s:FormStrategy>
</p:Document>