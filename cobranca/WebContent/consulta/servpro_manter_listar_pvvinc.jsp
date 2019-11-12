<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servpro_manter_listar_pvvinc.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 25/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServProEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean "%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	ConGerServicosSolicitadosBean filtroBean =(session.getAttribute(ServProEstrategia.BEAN_FILTRO)==null? new ConGerServicosSolicitadosBean()
																		:(ConGerServicosSolicitadosBean)session.getAttribute(ServProEstrategia.BEAN_FILTRO));
	
	CedenteCabecaBean cedCabBean = 	(session.getAttribute(ServProEstrategia.BEAN_CABECALHO)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(ServProEstrategia.BEAN_CABECALHO));
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ServProEstrategia.PAGINACAO_LIST);
	
	if(request.getParameter(ServProEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ServProEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ServProEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ServProEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
	
%>


<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.ServProManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=ServProEstrategia.PAGE_TITLE_LISTAR_PV%>"/>

		<input type="hidden" name="codigoCedente" value="">
		<input type="hidden" name="dataSolicitacao" value="<%=filtroBean.getDataSolicitacaoFormatada()%>">
		<input type="hidden" name="tpConsulta" value="<%=filtroBean.getTpConsulta()%>">
		<input type="hidden" name="<%=ServProEstrategia.PAGINACAO_PAGE%>" value="">
		<%//EAM 22/08%>
		<input type="hidden" name="tpFiltro">		
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">

            <tr>
              <td class="textoTitulo" width="17%">Unidade PV: </td>
              <td class="textoValor" width="26%"><%=filtroBean.getCodigoUnidadePvFormatado()%></td>
  
              <td class="textoTitulo" width="17%">Nome Unidade: </td>
              <td class="textoValor" width="26%"><%=filtroBean.getNomePvVinculacao()%></td>
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
								    <td width="1%" align="center">&nbsp;</td>
 								    <td width="10%" align="right">Cedente</td>
								    <td width="80%" align="left">&nbsp;&nbsp;Nome Cedente</td>
								    
								  </tr>
						<%
									ConGerServicosSolicitadosBean occ = new ConGerServicosSolicitadosBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ConGerServicosSolicitadosBean) lista.get(i);
						%>								  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="1%" align="center"><input type="radio" name="rdo" onclick="javascript: clickRadio('<%=occ.getCodigoCedente()%>')"></td>
 								    <td width="10%" align="right"><%=occ.getCodigoCedenteFormatado()%></td>
 								    <td width="80%" align="left">&nbsp;&nbsp;<%=occ.getNomeFantasia()%></td>
								    
								  </tr>
						<%   } %>
						
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="6" align="center">
										  <s:ButtonPaginar 
							  				pageNumber="<%=paginacao.getPageNumber()%>" 
							  				numberOfPages="<%=paginacao.getPageCount()%>" 
							  				pageName="<%=ServProEstrategia.PAGE_LISTA_PVVINC%>"/>
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
	    function inicia() {
				setFirstFieldFocus();
			}
			
	    function formSubmit() {
	    	if(validaSubmit()){
        			    
		   		<%//EAM 22/08%>
		    	document.frmMain.tpFiltro.value= "0";        
       	
       		document.frmMain.submit();
        }
	    }
	    
	    function formSubmit_Voltar() {
	    	document.frmMain.estrategia.value= "consulta.ServProManterIniciar";
		    document.frmMain.fluxo.value= "voltar";
        		    
		    <%//EAM 22/08%>
		    document.frmMain.tpFiltro.value= "1";        
        
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