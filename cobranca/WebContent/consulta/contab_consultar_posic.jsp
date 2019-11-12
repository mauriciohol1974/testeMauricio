<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: contsp_manter_consultar_posic.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 17/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ContabilBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ContabEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ContabEstrategia.PAGINACAO_LIST);
	if(request.getParameter(ContabEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ContabEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ContabEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ContabEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	ContabilBean contabilBean = (session.getAttribute(ContabEstrategia.DATA_BEAN)==null?new ContabilBean():(ContabilBean)session.getAttribute(ContabEstrategia.DATA_BEAN));
%>
<%
boolean pagina1 = contabilBean.getNavegacao().equals(ContabEstrategia.NAVEGACAO_PV);
boolean pagina2 = contabilBean.getNavegacao().equals(ContabEstrategia.NAVEGACAO_REC);
boolean pagina3 = contabilBean.getNavegacao().equals(ContabEstrategia.NAVEGACAO_CAIXA_REC);
boolean pagina4 = contabilBean.getNavegacao().equals(ContabEstrategia.NAVEGACAO_CAIXA_PV);
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ContabEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
<s:Visibility visible="<%=pagina1%>">								
		<s:Titulo name="<%=ContabEstrategia.PAGE_TITLE_POSICAO_PV%>"/>    
</s:Visibility>		  	
<s:Visibility visible="<%=pagina2%>">								
		<s:Titulo name="<%=ContabEstrategia.PAGE_TITLE_POSICAO_REC%>"/>    
</s:Visibility>		  	
<s:Visibility visible="<%=pagina3%>">								
		<s:Titulo name="<%=ContabEstrategia.PAGE_TITLE_POSICAO_CAIXA_REC%>"/>    
</s:Visibility>
<s:Visibility visible="<%=pagina4%>">								
		<s:Titulo name="<%=ContabEstrategia.PAGE_TITLE_POSICAO_CAIXA_PV%>"/>    
</s:Visibility>
		  	
  	<input type="hidden" name="<%=ContabEstrategia.PAGINACAO_PAGE%>" value="">
 		<input type="hidden" name ="navegacao" >
 		<input type="hidden" name ="tipoConsulta" value ='<%=contabilBean.getTipoConsulta()%>'>
 		<input type="hidden" name ="selecaoConsulta" value ='<%=contabilBean.getSelecaoConsulta()%>'>
 		<input type="hidden" name ="codigoUnidade" >
 		<input type="hidden" name ="data" value = '<%=contabilBean.getDataFormatada()%>'>
 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
<s:Visibility visible="<%=pagina2 || pagina4%>">								
            <tr>
              <td class="textoTitulo" width="17%">Unidade RSRET: </td>
              <td nowrap class="textoValor" width="26%"><%=contabilBean.getCodigoUnidade().equals( new Long(0))?"":contabilBean.getCodigoUnidadeFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Unidade: </td>
              <td nowrap class="textoValor" width="26%"><%=contabilBean.getNomeUnidade()%></td> 
            </tr>
</s:Visibility>		  	
            <tr>
              <td class="textoTitulo" width="17%">Tipo de Consulta</td>
              <td class="textoValor" width="26%"><%=contabilBean.getTipoConsultaTexto()%></td> 
              <td class="textoTitulo" width="17%">Data</td>
              <td nowrap class="textoValor" width="26%"><%=contabilBean.getDataFormatada()%></td> 
            </tr>
            <tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
<s:Visibility visible="<%=pagina3%>">	
								    <td nowrap width="10%" align="right">RSRET</td>
</s:Visibility>									    
<s:Visibility visible="<%=!pagina3%>">	
								    <td nowrap width="10%" align="right">PV</td>
</s:Visibility>									 								    
								    <td nowrap width="30%" align="left">Nome</td>
								    <td nowrap width="20%" align="right">Quantidade Liquidação</td>
								    <td nowrap width="20%" align="right">Valores a Creditar</td>
								  </tr>
							<%
									ContabilBean occ = new ContabilBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ContabilBean) lista.get(i);
							%>	
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
<s:Visibility visible="<%=pagina3%>">	
										<td width="1%" align="center">
											<input type="radio" name="rad" 
											    onclick="javascript: clickRadio('<%=occ.getCodigoUnidade()%>');">
								    </td>	
</s:Visibility>									    									    
<s:Visibility visible="<%=!pagina3%>">	
								    <td nowrap width="2%" align="center"> &nbsp;</td>
</s:Visibility>	
								    <td nowrap width="10%" align="right"><%=occ.getCodigoUnidadeFormatado()%></td>
								    <td nowrap width="30%" align="left"><%=occ.getNomeUnidade()%></td>
								    <td nowrap width="20%" align="right"><%=occ.getQuantidadeLiquidacao()%></td>
								    <td nowrap width="20%" align="right"><%=occ.getValorCreditar()%></td>
								  </tr>
						<%  } %>			
								  <tr <%=(lista.size())%2 == 0 ? "class='line1'" : "class='line0'" %>>
								    <td nowrap width="2%" align="center">&nbsp;</td>
								    <td nowrap class="textoDestaqueValor" width="10%" align="right">Total</td>
								    <td nowrap class="textoDestaqueValor" width="30%" align="right">&nbsp;</td>
								    <td nowrap class="textoDestaqueValor" width="20%" align="right"><%=contabilBean.getTotalQuantidadeLiquidacao()%></td>
								    <td nowrap class="textoDestaqueValor" width="20%" align="right"><%=contabilBean.getTotalValorCreditar()%></td>
								  </tr>
	
 	                <tr> 
	                  <td colspan="5">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="5" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=ContabEstrategia.PAGE_CONSULTAR_POSICAO%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="5">&nbsp;</td>
	                </tr>
	                <tr>
			              <td align="right" colspan="5">
			 	              <p align="center"> 
<s:Visibility visible="<%=pagina3%>">								
				                <s:Button name="Ok" action="javascript:formSubmit()"/>
</s:Visibility>
				                <s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
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

	    function inicia(){
	    }

	  	function formSubmit() {
        if(validaSubmit()){   
           document.frmMain.navegacao.value = <%=ContabEstrategia.NAVEGACAO_CAIXA_PV%>; 
           document.frmMain.submit();
        }
	    }  
	    
	    function formSubmit_Voltar() {
  					document.frmMain.estrategia.value = '<%=ContabEstrategia.STRATEGY_MANTER_FILTRO%>';    	
           	document.frmMain.fluxo.value = "voltar";
           	document.frmMain.submit();
      }  

			function validaSubmit() {
			<%if(paginacao.getCurrentPageSize() > 1){%>
					if(!validaRadioButton(document.frmMain.rad, "")){
					  return false;
					}
			<%} else {%>
					if(!document.frmMain.rad.checked){
						msg('003', '');
						return false;
					}
			<%}%>
			return true;
    }
    
	  function clickRadio(codigoUnidade){
			document.frmMain.codigoUnidade.value = codigoUnidade;
	  }
		</script>
  </s:FormStrategy>
</p:Document>
</html>