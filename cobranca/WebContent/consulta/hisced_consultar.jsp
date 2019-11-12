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
<%@page import="br.gov.caixa.sigcb.bean.HistoricoCedenteBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.HistoricoCedenteEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(HistoricoCedenteEstrategia.PAGINACAO_LIST);
	if(request.getParameter(HistoricoCedenteEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(HistoricoCedenteEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(HistoricoCedenteEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(HistoricoCedenteEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	HistoricoCedenteBean historicoCedenteBean = (session.getAttribute(HistoricoCedenteEstrategia.DATA_BEAN)==null?new HistoricoCedenteBean():(HistoricoCedenteBean)session.getAttribute(HistoricoCedenteEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(HistoricoCedenteEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(HistoricoCedenteEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=HistoricoCedenteEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=HistoricoCedenteEstrategia.PAGE_TITLE%>"/>    
  	<input type="hidden" name="codigoUnidadePV" value="">
  	<input type="hidden" name="<%=HistoricoCedenteEstrategia.PAGINACAO_PAGE%>" value="">
  	<input type="hidden" name="codigoCedente" value="">
		<input type="hidden" name ="selecaoRadio">
		<input type="hidden" name ="dataInicial" value="<%=historicoCedenteBean.getDataMovimentoFormatada()%>">
		<input type="hidden" name ="dataFinal" value="<%=historicoCedenteBean.getDataMovimentoFormatada()%>">
		<input type="hidden" name ="guia" value="<%=historicoCedenteBean.getGuia()%>">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=historicoCedenteBean.getCodigoCedente().equals( new Long(0))?"":historicoCedenteBean.getCodigoCedenteFormatado()%></td>
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
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals( new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
              <td class="textoTitulo" width="17%">Filtro Guia: </td>
              <td class="textoValor" width="26%"><%=historicoCedenteBean.getGuiaTexto()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Filtro Data De: </td>
              <td class="textoValor" width="26%"><%=historicoCedenteBean.getDataInicialFormatada()%></td> 
              <td class="textoTitulo" width="17%">Filtro Data Até: </td>
              <td class="textoValor" width="26%"><%=historicoCedenteBean.getDataFinalFormatada()%></td>
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
 								    <td nowrap width="23%" align="left">Informação Alterada</td>
								    <td nowrap width="10%" align="center">Data Movimento</td>
								    <td nowrap width="10%" align="center">Hora</td>
								    <td nowrap width="10%" align="left">Usuário</td>								    
								    <td nowrap width="23%" align="left">Valor Anterior</td>								    
								    <td nowrap width="23%" align="left">Valor Atual</td>								    
								  </tr>
							<%
									HistoricoCedenteBean occ = new HistoricoCedenteBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (HistoricoCedenteBean) lista.get(i);
							%>
									  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="1%" align="center">&nbsp;</td>
	 								    <td nowrap width="23%" align="left"><%=occ.getInformacaoAlterada()%></td>
	 								    <td nowrap width="10%" align="center"><%=occ.getDataMovimentoFormatada()%></td>
											<td nowrap width="10%" align="center"><%=occ.getHoraFormatada()%></td>	 								    
											<td nowrap width="10%" align="left"><%=occ.getUsuario()%></td>
											<td nowrap width="23%" align="left"><%=occ.getValorAnterior()%></td>	 								    
											<td nowrap width="23%" align="left"><%=occ.getValorAtual()%></td>												 								    
									  </tr>
						<%  } %>	  

 	                <tr> 
	                  <td colspan="7">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="7" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=HistoricoCedenteEstrategia.PAGE_CONSULTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="7">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="7">
	                    <p align="center"> 
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
		       document.frmMain.selecaoRadio.value=<%=HistoricoCedenteEstrategia.SELECAO_RADIO_CEDENTE%>						
           document.frmMain.submit();
        }
	    }  
	    
	    function formSubmit_Voltar() {
						document.frmMain.estrategia.value = '<%=HistoricoCedenteEstrategia.STRATEGY_MANTER_FILTRO%>';    	
           document.frmMain.fluxo.value = "voltar";
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
	    
	    function clickRadio(codigoCedente) {
				document.frmMain.codigoCedente.value = codigoCedente;
      }
		</script>
  </s:FormStrategy>
</p:Document>
</html>
