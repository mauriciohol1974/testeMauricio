<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servdia_consultar_extmovtit.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 25/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServDiaEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean "%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.UtilDatas"%>

<%
	ConGerServicosSolicitadosBean cabeEXBean =(session.getAttribute(ServDiaEstrategia.BEAN_DATA)==null? new ConGerServicosSolicitadosBean()
																		:(ConGerServicosSolicitadosBean)session.getAttribute(ServDiaEstrategia.BEAN_DATA));
	
	CedenteCabecaBean cedCabBean = 	(session.getAttribute(ServDiaEstrategia.BEAN_CABECALHO)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(ServDiaEstrategia.BEAN_CABECALHO));
	
	
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ServDiaEstrategia.PAGINACAO_LIST);
	
	if(request.getParameter(ServDiaEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ServDiaEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ServDiaEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ServDiaEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>
	
<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=ServDiaEstrategia.STRATEGY_INICIAR%>" fluxo="voltar">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Serviços Solicitados no dia"/>

		<input type="hidden" name="<%=ServDiaEstrategia.PAGINACAO_PAGE%>" value="">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="1" height=53 valign="middle" align="center">

            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedente().equals( new Long(0))?"":cedCabBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
	            <td class="textoTitulo" width="17%" valign="top">Código Cliente (COCLI): </td>
	            <td class="textoValor"  width="26%" valign="top"><%=cedCabBean.getCodigoClienteCOCLI().equals(new Long(0))? "":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
	            <td class="textoTitulo" width="17%" valign="top">Relatório:</td>
              <td class="textoValor"  width="26%" valign="top" rowspan="2"><%=cabeEXBean.getNomeRelatorio()%></td>
	        </tr>
	        <tr>
	            <td class="textoTitulo" width="17%" valign="top">Data Solicitação:</td>
              	<td class="textoValor"  width="26%" valign="top"><%=UtilDatas.getToday()%></td>
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
 								    <td nowrap width="20%" align="right">Nosso Número</td>
 								    <td nowrap width="20%" align="left">Nome Sacado</td>
 								    <td nowrap width="20%" align="left">Seu Número</td>
 								    <td nowrap width="20%" align="right">Valor</td>
 								    <td nowrap width="20%" align="left">Vencimento</td>
 								    <td nowrap width="20%" align="left">Usuário</td>
									<td nowrap width="20%" align="left">Parcela</td> 								     								    
								  </tr>
							<%
									ConGerServicosSolicitadosBean occ = new ConGerServicosSolicitadosBean();
									for ( int i = 0; i < lista.size(); i++ ) {
											int r = i;
							%>	  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									<% 	if( r < lista.size()){%>
											<%occ = (ConGerServicosSolicitadosBean) lista.get(r);%>
								    <td nowrap width="20%" align="right"><%=occ.getNossoNumeroInicialFormatado()%></td>
									<%  }else{ %>
										<td nowrap width="20%" align="left">&nbsp;</td>
									<%  }	%>
										
									
									<%  if( r < lista.size()){%>
									  	<%occ = (ConGerServicosSolicitadosBean) lista.get(r);%>
								    <td nowrap width="20%" align="left"><%=occ.getNomeSacado()%></td>
								  <%  }else{ %> 
								    <td nowrap width="20%" align="left">&nbsp;</td>
								  <%  }	%>
								  
								  
									<%  if( r < lista.size()){%>
									  	<%occ = (ConGerServicosSolicitadosBean) lista.get(r);%>
								    <td nowrap width="20%" align="left"><%=occ.getNumeroDocumento()%></td>								    								 
								  <%  }else{ %> 
								  	<td nowrap width="20%" align="left">&nbsp;</td>
								  <%  }	%>
								  
								  <%  if( r < lista.size()){%>
									  	<%occ = (ConGerServicosSolicitadosBean) lista.get(r);%>
								    <td nowrap width="20%" align="right"><%=occ.getValorTitulo()%></td>								    								 
								  	<%  }else{ %> 
								  	<td nowrap width="20%" align="left">&nbsp;</td>
								  	<%  }	%>	
								  	
								  	<%  if( r < lista.size()){%>
									  	<%occ = (ConGerServicosSolicitadosBean) lista.get(r);%>
								    <td nowrap width="20%" align="left"><%=occ.getDataVencimentoFormatada()%></td>								    								 
								  	<%  }else{ %> 
								  	<td nowrap width="20%" align="left">&nbsp;</td>
								  	<%  }	%>
								  			
									<%  if( r < lista.size()){%>
									 	<%occ = (ConGerServicosSolicitadosBean) lista.get(r);%>
										    <td nowrap width="20%" align="left"><%=occ.getCodigoUsuario()%></td>	
											<td nowrap width="20%" align="left"><%=occ.getParcela()%></td>    							    								 
									  	<%  }else{ %> 
									            <td nowrap width="20%" align="left">&nbsp;</td>
								  	<%  }	%>
								  </tr>
							<%  } %>	  
									<tr> 
         					 <td colspan="4">&nbsp;</td>
        					</tr>
									<tr>
										<td colspan="5" align="center">
							  			<s:ButtonPaginar 
							  				pageNumber="<%=paginacao.getPageNumber()%>" 
							  				numberOfPages="<%=paginacao.getPageCount()%>" 
							  				pageName="<%=ServDiaEstrategia.PAGE_REI_TIT_BAI%>"/>
										</td>
									</tr>
								</table>
							</td>
						</tr>            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
						<tr>
					  	<td align="right" colspan="4">
              	<p align="center"> 
	              	<s:Button name="Voltar" action="javascript:formSubmit()"/> 
								</p>
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
	    function formSubmit() {
        document.frmMain.submit();
	    }
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
