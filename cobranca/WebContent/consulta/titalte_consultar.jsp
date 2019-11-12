<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: titalte_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 10/11/2004 - v1
************************************************/
%>

<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TitAlteEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerTitulosAlteradosBean "%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.List"%>

<%
	ConGerTitulosAlteradosBean fixoBean = (session.getAttribute(TitAlteEstrategia.BEAN_FIXO)==null? new ConGerTitulosAlteradosBean()
																			:(ConGerTitulosAlteradosBean)session.getAttribute(TitAlteEstrategia.BEAN_FIXO));

  int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(TitAlteEstrategia.PAGINACAO_LIST);
	
	if(request.getParameter(TitAlteEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(TitAlteEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(TitAlteEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(TitAlteEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

	
<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.TitAlteManterFinalizar" fluxo="voltar">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=TitAlteEstrategia.TITLE%>"/>
 		
 		<input type="hidden" name="<%=TitAlteEstrategia.PAGINACAO_PAGE%>" value="">
 		
		<input type="hidden" name="nossoNumero" value="">
		<input type="hidden" name="codigoCedente" value="">

				
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">

						<tr>
              <td class="textoTitulo" width="17%">Unidade PV: </td>
              <td class="textoValor" width="26%"><%=fixoBean.getCodigoUnidadePvFormatado()%></td>
						  <td class="textoTitulo" width="17%">Nome Unidade: </td>
              <td class="textoValor" width="26%"><%=fixoBean.getNomeUnidadePv()%></td>            
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Data Comando: </td>
              <td class="textoValor" width="26%"><%=fixoBean.getDataComandoFormatada()%></td>    
						  <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            
            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="6" class="textoTitulo">Títulos Alterados:
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="5">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
		                <td>&nbsp;</td>										  
								    <td width="15%" align="left">Comando</td>
 								    <td width="10%" align="center">Data Alteração</td>
								    <td width="15%" align="right">Nosso Número</td>
								    <td width="10%" align="right">Cedente</td>
								    <td width="20%" align="left">Nome Cedente</td>
								    <td width="10%" align="right">Parcela</td>
								  </tr>
						<%
									ConGerTitulosAlteradosBean occ = new ConGerTitulosAlteradosBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ConGerTitulosAlteradosBean) lista.get(i);
						%>										  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="3%"  align="center">
								    	<input type="radio" name="rdo" 
								    		onclick="javascript: clickRadio('<%=occ.getNossoNumero()%>','<%=occ.getCodigoCedente()%>')">
								    </td>
								    <td width="15%" align="left"  ><%=occ.getComando()%></td>	
 								    <td width="10%" align="center"><%=occ.getDataAlteracaoFormatada()%></td>
 								    <td width="15%" align="right" ><%=occ.getNossoNumeroFormatado()%></td>
								    <td width="10%" align="right" ><%=occ.getCodigoCedenteFormatado()%></td>
								    <td width="20%" align="Left"  ><%=occ.getNomeFantasia()%></td>
								    <td width="10%" align="right" ><%=occ.getParcela()%></td>
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
							  				pageName="<%=TitAlteEstrategia.PAGE_CONSULTAR%>"/>

										</td>
									</tr>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>

	                <tr>
	                  <td align="right" colspan="6">
	                    <p align="center"> 
			              		<s:Button name="Ações" action="javascript:formSubmit_BcoTitulos();"/> 
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
			
	    function formSubmit_BcoTitulos() {
	    	if(validaSubmit()){
        	document.frmMain.submit();
        }
	    }
	    
	    function formSubmit_Voltar() {
	    	document.frmMain.estrategia.value= "consulta.TitAlteManterIniciar";
		    document.frmMain.fluxo.value= "voltar";
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
			  
	    function clickRadio(NossoNumero,CodigoCedente) {
		  	document.frmMain.codigoCedente.value 	= CodigoCedente;		  	
		  	document.frmMain.nossoNumero.value 		= NossoNumero;
     	}
	    
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
