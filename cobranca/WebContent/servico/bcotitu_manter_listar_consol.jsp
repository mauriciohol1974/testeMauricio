<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Agosto de 2004
*Projeto CAIXA - SIGCB
*Componente: bcotitu_manter_filtro.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 30/08/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloListarBean"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BcoTituEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
	
<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN));
	TituloListarBean tituloListarBean = (session.getAttribute(BcoTituEstrategia.DATA_FIXO_LIST)==null?new TituloListarBean():(TituloListarBean)session.getAttribute(BcoTituEstrategia.DATA_FIXO_LIST));	
	TituloBean tituloBean = (session.getAttribute(BcoTituEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(BcoTituEstrategia.DATA_BEAN));	
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(BcoTituEstrategia.PAGINACAO_LIST);
	if(request.getParameter(BcoTituEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(BcoTituEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(BcoTituEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(BcoTituEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
	estrategia="<%=BcoTituEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=BcoTituEstrategia.PAGE_TITLE_CONSOLIDADO%>"/>

		<input type="hidden" name = "filtroSelecao" value="<%=tituloBean.getFiltroSelecao()%>">
		<input type="hidden" name = "filtroDescricaoSituacao" value="<%=tituloBean.getFiltroDescricaoSituacao()%>">
		<input type="hidden" name = "filtroDescricaoClassificacao" value="<%=tituloBean.getFiltroDescricaoClassificacao()%>">
		<input type="hidden" name = "filtroVoltarListarConsolidado" value="1">
		<input type="hidden" name = "filtroVoltarListarTitulo" value="0">
		<input type="hidden" name = "filtroVoltarAcao" value="0">
		
		<input type="hidden" name = "codigoCedente" value="<%=tituloBean.getCodigoCedente()%>">
		<input type="hidden" name = "nossoNumero" value="<%=tituloBean.getNossoNumero()%>">
		<input type="hidden" name = "situacao" value="<%=tituloBean.getSituacao()%>">
		<input type="hidden" name = "classificacao" value="<%=tituloBean.getClassificacao()%>"> 		

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
    	<tr> 
      	<td valign="top" width="95%" height="14" align="left"> 
        	<table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
          	<tr>
            	<td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getCodigoCedenteFormatado()%></td>
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
              <td class="textoTitulo" width="17%">Filtro por: </td>
              <td class="textoValor" width="26%">CONSOLIDADO</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Classificado por: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getFiltroDescricaoClassificacao()%></td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
						</tr>
						
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Banco de Títulos Consolidado:
                <hr>
              </td>
            </tr>

						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="40%" align="left">Situação</td>
 								    <td nowrap width="20%" align="right">Quantidade</td>
 								    <td nowrap width="20%" align="right">Valor</td>
									</tr>

							<%
									TituloListarBean occ = new TituloListarBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (TituloListarBean) lista.get(i);
							%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="2%" align="center">
								    	<input type="radio" name="rdo"
								    		onclick="javascript: clickRadio('<%=occ.getSituacao()%>', '<%=occ.getDescricaoSituacao()%>');">
								    </td>
									  <td width="40%" align="left"><%=occ.getDescricaoSituacao()%></td>
									  <td width="20%" align="right"><%=occ.getQuantidade().equals(new Long(0))?"":occ.getQuantidade().toString()%></td>
							 			<td width="20%" align="right"><%=occ.getValor().toString().equals("R$ 0,00")?"":occ.getValor().toString()%></td>
									</tr>
							<%  } %>

	              </table>
              </td>
            </tr>

 	          <tr> 
	          	<td colspan="4">&nbsp;</td>
	          </tr>
			      <tr valign="top"> 
      			  <td colspan="4" class="textoTitulo">Totais:
            		<hr>
	            </td>
 			      </tr>
 			      
					  <tr>
					    <td class="textoTitulo">Quantidade Total:</td>
							<td class="textoValor"><%=tituloListarBean.getQuantidadeTotal()%></td>
					    <td class="textoTitulo">Valor Total:</td>
							<td class="textoValor"><%=tituloListarBean.getValorTotal()%></td>
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
	    function clickRadio(situacao, filtroDescricaoSituacao) {
		    document.frmMain.filtroSelecao.value = 2;
				document.frmMain.situacao.value = situacao;
				document.frmMain.filtroDescricaoSituacao.value = filtroDescricaoSituacao;
	    }
			function formSubmit() {
				if(validaSubmit()) {
					document.frmMain.submit();
				}	
			}
			function validaSubmit() {
				<%if(paginacao.getCurrentPageSize() > 1){%>
			    if(! validaRadioButton(document.frmMain.rdo, '')){
					  return false;
			    }
				<%} else {%>
					if(! document.frmMain.rdo.checked){
						msg('003', '');
						return false;
					}
				<%}%>
			  return true;
	 		}
			function formSubmit_Voltar() {
				document.frmMain.filtroVoltarListarConsolidado.value = '0';
        document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_MANTER_INICIAR%>";
	      document.frmMain.fluxo.value = "voltar";
	      document.frmMain.submit();
	    }
    </script>
  </s:FormStrategy>
</p:Document>
</html>
