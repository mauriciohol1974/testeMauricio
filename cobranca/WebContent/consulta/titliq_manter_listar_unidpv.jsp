
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosDiaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TitLiqManterEstrategia" %>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.List"%>

<%
	ConGerTitulosLiquidadosDiaBean filtroBean = (session.getAttribute(TitLiqManterEstrategia.FILTRO_BEAN)==null? new ConGerTitulosLiquidadosDiaBean()
																			:(ConGerTitulosLiquidadosDiaBean)session.getAttribute(TitLiqManterEstrategia.FILTRO_BEAN));
  
  int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(TitLiqManterEstrategia.PAGINACAO_LIST);
	
	if(request.getParameter(TitLiqManterEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(TitLiqManterEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(TitLiqManterEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(TitLiqManterEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
	
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.TitLiqManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Títulos Liquidados >> Listar"/>
		
		<input type="hidden" name="<%=TitLiqManterEstrategia.PAGINACAO_PAGE%>" value="">
		<input type="hidden" name="codigoCedente" value="">
		<input type="hidden" name="dataInicio" value="<%=filtroBean.getDataInicioFormatada()%>">
		<input type="hidden" name="dataFim" value="<%=filtroBean.getDataFimFormatada()%>">
		<input type="hidden" name="nossoNumero" value="<%=filtroBean.getNossoNumero()%>">
		<input type="hidden" name="tipoConsulta" value="<%=filtroBean.getTipoConsulta()%>">
		

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">

            <tr>
              <td class="textoTitulo" width="17%">Unidade de Vinculação: </td>
              <td class="textoValor" width="26%"><%=filtroBean.getUnidadeVinculacaoFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Unidade: </td>
              <td class="textoValor" width="26%"><%=filtroBean.getNomeUnidade()%></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Cedentes:
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td width="2%" align="center">&nbsp;</td>
 								    <td width="10%" align="right">Cedente</td>
								    <td width="40%" align="left">Nome Cedente</td>
 								    <td width="10%" align="left">Tipo Pessoa</td>
								    <td width="30%" align="right">CPF/CNPJ</td>
								    <td width="10%" align="center">&nbsp;</td>
								  </tr>
							<%
									ConGerTitulosLiquidadosDiaBean occ = new ConGerTitulosLiquidadosDiaBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ConGerTitulosLiquidadosDiaBean) lista.get(i);
							%>	  	  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="2%" align="center">
									    <input type="radio" name="rdo"
								    	  onclick="javascript: clickRadio('<%=occ.getCodigoCedente()%>');">
								    </td>
 								    <td width="10%" align="right" nowrap><%=occ.getCodigoCedenteFormatado()%></td>
 								    <td width="40%" align="left" nowrap><%=occ.getNomeFantasia()%></td>
 								    <td width="10%" align="left" nowrap><%=occ.getDescTipoPessoa()%></td>
 								    <td width="30%" align="right" nowrap><%=occ.getCpfCnpjFormatado()%></td>
								    <td width="10%" align="center">&nbsp;</td>
								  </tr>
							<%  } %>	  
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="6" align="center">
										<% String pageName = TitLiqManterEstrategia.PAGE_LIQ_LISTA_PV;%>
										  <s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=pageName%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>

	                <tr>
	                  <td align="right" colspan="6">
	                    <p align="center"> 	                      
	                      <s:Button name="Ok" action="javascript:formSubmit()"/>
	                      <s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
	                    </p>
	                  </td>
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
		    setFirstFieldFocus();
	    }
	    
	    function formSubmit() {
	    	if (validaSubmit()){
	    		document.frmMain.submit();
	    	}
	    }
	    
	    function formSubmit_Voltar() {
  			<%//EAM 23/08
  			//document.frmMain.estrategia.value = "consulta.TitLiqManterIniciar";%>
        document.frmMain.estrategia.value = "consulta.TitLiqManterFiltro";
        document.frmMain.fluxo.value = "voltar";
       	document.frmMain.submit();
	    }
	    
	    function clickRadio(codigoCedente){
	    	document.frmMain.codigoCedente.value = codigoCedente;
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
	    
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
