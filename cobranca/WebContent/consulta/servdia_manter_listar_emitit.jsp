<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servdia_manter_listar_emitit.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualiza��o: 26/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServDiaEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

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
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=ServDiaEstrategia.STRATEGY_TIT_EMI%>" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Servi�os Solicitados no dia" />
		
		<input type="hidden" name="<%=ServDiaEstrategia.PAGINACAO_PAGE%>" value="">
		<input type="hidden" name="codigoCedente" value="<%=cedCabBean.getCodigoCedente().toString()%>">
		<input type="hidden" name="tpConsulta" value="<%=cabeEXBean.getTpConsulta()%>">
		<!--------------------dados cabe�alho excluiso da p�gina---------------------------->
		<input type="hidden" name="codigoBancoSacados" value="">
		<input type="hidden" name="nomeBancoSacados" value="">

		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

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
	            <td class="textoTitulo" width="17%" valign="top">C�digo Cliente (COCLI): </td>
	            <td class="textoValor"  width="26%" valign="top"><%=cedCabBean.getCodigoClienteCOCLI().equals(new Long(0))? "":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
	            <td class="textoTitulo" width="17%" valign="top">relat�rio:</td>
              <td class="textoValor"  width="26%" valign="top"><%=cabeEXBean.getNomeRelatorio()%></td>
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
 								    <td nowrap width="15%" align="right">Numero do Banco &nbsp;&nbsp;</td>
								    <td nowrap width="40%" align="left" nowrap>&nbsp;&nbsp;Nome do Banco</td>
								    <td nowrap width="20%" align="left" nowrap>&nbsp;&nbsp;Usu�rio</td>
								  </tr>
							<%
									ConGerServicosSolicitadosBean occ = new ConGerServicosSolicitadosBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ConGerServicosSolicitadosBean) lista.get(i);
							%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="1%" align="center">
								    <input type="radio" name="rdo" 
								     			 onclick="javascript: clickRadio('<%=occ.getCodigoBancoSacados()%>','<%=occ.getNomeBancoSacados()%>');">
								    </td>
								    <td nowrap width="15%" align="right"><%=occ.getCodigoBancoSacados()%>&nbsp;&nbsp;</td>
 								    <td nowrap width="40%" align="left">&nbsp;&nbsp;<%=occ.getNomeBancoSacados()%></td>
 								    <td nowrap width="20%" align="left">&nbsp;&nbsp;<%=occ.getCodigoUsuario()%></td>
								  </tr>
							<%  } %>
					        <tr> 
         					 <td colspan="9">&nbsp;</td>
        					</tr>
									<tr>
										<td colspan="9" align="center">
							  		<s:ButtonPaginar 
							  				pageNumber="<%=paginacao.getPageNumber()%>" 
							  				numberOfPages="<%=paginacao.getPageCount()%>" 
							  				pageName="<%=ServDiaEstrategia.PAGE_TIT_EMI%>"/>
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
              		<s:Button name="Ok" action="javascript:formSubmit()"/> 
	              	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/> 
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
	    	if(validaSubmit()){
        	document.frmMain.submit();
        }
	    }
	    
	    function formSubmit_Voltar() {
	    	document.frmMain.estrategia.value= "consulta.ServDiaManterIniciar";
		    document.frmMain.fluxo.value= "voltar";
        document.frmMain.submit();
	    }
	    function validaSubmit(){
	    	if (validaRadioButton(document.frmMain.rdBco, 'Banco Sacados')) {
  				return true;    		
      	}
      	return false;
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
	    
	    function clickRadio(numeroBanco,nomeBanco) {
		  	document.frmMain.codigoBancoSacados.value 	= numeroBanco;
		  	document.frmMain.nomeBancoSacados.value		= nomeBanco;		  	
     	}
	    
    </script>
    
   </s:FormStrategy>
	</p:Document>
</html>
