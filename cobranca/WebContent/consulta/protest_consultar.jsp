<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: protest_manter_consultar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 10/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ProtestoTituloBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ProtestoTituloEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ProtestoTituloEstrategia.PAGINACAO_LIST);
	if(request.getParameter(ProtestoTituloEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ProtestoTituloEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ProtestoTituloEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ProtestoTituloEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	ProtestoTituloBean protestoTituloBean = (session.getAttribute(ProtestoTituloEstrategia.DATA_BEAN)==null?new ProtestoTituloBean():(ProtestoTituloBean)session.getAttribute(ProtestoTituloEstrategia.DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ProtestoTituloEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=ProtestoTituloEstrategia.PAGE_TITLE%>"/>    
  	<input type="hidden" name="<%=ProtestoTituloEstrategia.PAGINACAO_PAGE%>" value="">
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">PV Cobrador: </td>
              <td nowrap class="textoValor" width="26%"><%=protestoTituloBean.getCodigoUnidadePv().equals( new Long(0))?"":protestoTituloBean.getCodigoUnidadePvFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome PV: </td>
              <td nowrap class="textoValor" width="26%"><%=protestoTituloBean.getNomeUnidadePv()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Relatório</td>
              <td nowrap class="textoValor" width="26%"><%=protestoTituloBean.getTipoConsultaTexto()%></td> 
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Consulta:
                <hr>
              </td>
            </tr>
<%
boolean pagina1 = protestoTituloBean.getSelecaoRadio().equals(ProtestoTituloEstrategia.SELECAO_RADIO_TIT_A_SEREM_ENVIADOS);
boolean pagina2 = protestoTituloBean.getSelecaoRadio().equals(ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIADOS);
boolean pagina3 = protestoTituloBean.getSelecaoRadio().equals(ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIO_SUSPENSO);
boolean pagina4 = protestoTituloBean.getSelecaoRadio().equals(ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIADOS_DIA);
%>
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="15%" align="right">Nosso Número</td>
								    <td nowrap width="10%" align="right">Cedente</td>
								    <td nowrap width="15%" align="left">Nome Devedor</td>
								    <td nowrap width="10%" align="left">CPF/CNPJ</td>
<s:Visibility visible="<%=pagina4%>">								    								    
								    <td nowrap width="10%" align="center">Data Envio</td>								    
</s:Visibility>								    
<s:Visibility visible="<%=!pagina4%>">								    
								    <td nowrap width="15%" align="left">Seu Número</td>
								    <td nowrap width="15%" align="left">Parcela</td>
</s:Visibility>								    
<s:Visibility visible="<%= (pagina1)%>">								    
								    <td nowrap width="10%" align="center">Data Prevista</td>
</s:Visibility>	
<s:Visibility visible="<%= (pagina2)%>">								    
								    <td nowrap width="10%" align="center">Data Envio</td>
</s:Visibility>	
<s:Visibility visible="<%= pagina3%>">								    
								    <td nowrap width="10%" align="center">Data Prevista</td>
								    <td nowrap width="10%" align="center">Data Suspensão</td>
</s:Visibility>									    
<s:Visibility visible="<%= (pagina1 || pagina2)%>">												    
								    <td nowrap width="5%" align="left">Mod.</td>
</s:Visibility>	
<s:Visibility visible="<%=!pagina4%>">								    
								    <td nowrap width="5%" align="left">Esp.</td>
</s:Visibility>									    
								    <td nowrap width="15%" align="left">Valor Título</td>
<s:Visibility visible="<%=pagina4%>">								    								    								    
								    <td nowrap width="5%" align="left">N.C.</td>
								    <td nowrap width="15%" align="left">Protocolo</td>
								    <td nowrap width="10%" align="center">Data Protocolo</td>
</s:Visibility>									    								    								    								    
								  </tr>
							<%
									ProtestoTituloBean occ = new ProtestoTituloBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ProtestoTituloBean) lista.get(i);
							%>								  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="15%" align="right"><%=occ.getNossoNumeroFormatado()%></td>
								    <td nowrap width="10%" align="right"><%=occ.getCodigoCedenteFormatado()%></td>
								    <td nowrap width="15%" align="left"><%=occ.getNomeDevedor()%></td>
								    <td nowrap width="10%" align="left"><%=occ.getCpfCnpjFormatado()%></td>
<s:Visibility visible="<%=pagina4%>">		
								    <td nowrap width="15%" align="center"><%=occ.getDataFormatada().equals("01/01/0001")?"":occ.getDataFormatada()%></td>
</s:Visibility>	
<s:Visibility visible="<%=!pagina4%>">	
								    <td nowrap width="10%" align="left"><%=occ.getSeuNumero()%></td>
								    <td nowrap width="10%" align="left"><%=occ.getParcela()%></td>
</s:Visibility>	
<s:Visibility visible="<%= (pagina1)%>">	
								    <td nowrap width="5%" align="center"><%=occ.getDataFormatada().equals("01/01/0001")?"":occ.getDataFormatada()%></td>
</s:Visibility>	
<s:Visibility visible="<%= (pagina2)%>">	
								    <td nowrap width="5%" align="center"><%=occ.getDataFormatada().equals("01/01/0001")?"":occ.getDataFormatada()%></td>
</s:Visibility>	
<s:Visibility visible="<%= pagina3%>">			
								    <td nowrap width="5%" align="center"><%=occ.getDataEnvioProtestoFormatada().equals("01/01/0001")?"":occ.getDataEnvioProtestoFormatada()%></td>
								    <td nowrap width="5%" align="center"><%=occ.getDataFormatada().equals("01/01/0001")?"":occ.getDataFormatada()%></td>
</s:Visibility>	
<s:Visibility visible="<%= (pagina1 || pagina2)%>">			
								    <td nowrap width="15%" align="left"><%=occ.getModalidade()%></td>
</s:Visibility>	
<s:Visibility visible="<%=!pagina4%>">			
								    <td nowrap width="15%" align="left"><%=occ.getEspecieTitulo()%></td>
</s:Visibility>	
 								    <td nowrap width="15%" align="left"><%=occ.getValorTitulo()%></td>
<s:Visibility visible="<%=pagina4%>">	
								    <td nowrap width="15%" align="left"><%=occ.getNumeroCartorio().equals(new Long (0))?"":occ.getNumeroCartorio().toString()%></td>
								    <td nowrap width="15%" align="left"><%=occ.getProtocolo().equals("0000000000")?"":occ.getProtocolo()%></td>								    
								    <td nowrap width="15%" align="center"><%=occ.getDataProtocoloFormatada().equals("01/01/0001")?"":occ.getDataProtocoloFormatada()%></td>								    
</s:Visibility>									    
								  </tr>
						<%  } %>								  
 	                <tr>
	                  <td colspan="12">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="10" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=ProtestoTituloEstrategia.PAGE_CONSULTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="12">&nbsp;</td>
	                </tr>
	              </table>
              </td>
            </tr>

            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Totais:
                <hr>
              </td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Quantidade Total: </td>
              <td class="textoValor" width="26%"><%=protestoTituloBean.getQuantidadeTotalTitulo()%></td> 
              <td class="textoTitulo" width="17%">Valor Total: </td>
              <td class="textoValor" width="26%"><%=protestoTituloBean.getValorTotalTitulo()%></td>
            </tr>

 	          <tr> 
	            <td colspan="4">&nbsp;</td>
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
 	          <tr> 
	            <td colspan="4">&nbsp;</td>
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
						document.frmMain.estrategia.value = '<%=ProtestoTituloEstrategia.STRATEGY_MANTER_INICIAR%>';    	
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
      }  

			function validaSubmit() {
	  	}

		</script>
  </s:FormStrategy>
</p:Document>
</html>