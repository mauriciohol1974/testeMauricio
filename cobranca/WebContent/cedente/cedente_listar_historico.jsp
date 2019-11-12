
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloListarBean"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedHistPermissaoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(CedenteEstrategia.PAGINACAO_LIST);
	if(request.getParameter(CedenteEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(CedenteEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(CedenteEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(CedenteEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	

%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
	estrategia="<%=CedenteEstrategia.STRATEGY_MANTER_DETALHAR_HISTORICO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Consultar Histórico da Situação do Cedente >> Listar"/>
			
			<input type="hidden" name="codCedente" value="<%=cedCabBean.getCodigoCedenteFormatado()%>">
			<input type="hidden" name="data">
			<input type="hidden" name="hora">
			<input type="hidden" name="tpAlteracao">
			<input type="hidden" name="icAtual">	
			<input type="hidden" name="usuario">
			<input type="hidden" name="paginaAtual" value="">	
	
	
	  <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<td valign="top" width="1%" height="14" align="left">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	  		<td valign="top" width="95%" height="14" align="left"> 
	    		<table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="left">
          	<tr>
            	<td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
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
              
            </tr>
			<tr>
			  <td width="17%" colspan="4" class="textoTitulo"><hr></td>
			</tr>
			
			            
						<tr>
					  	<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
									<tr class="headerLista">
										  <td nowrap width="2%" align="center">&nbsp;</td>
		 								  <td nowrap width="12%" align="right">Data</td>
										  <td nowrap width="35%" align="left">Hora</td>
		 								  <td nowrap width="20%" align="left">Tipo Alteração</td>
		 								  <td nowrap width="13%" align="right">Usuário</td>
		 								  <td nowrap width="7%" align="right">Sit. Anterior</td>
		 								  <td nowrap width="7%" align="right">Sit. Atual</td>
										  
									</tr>
									

							<%
								CedHistPermissaoBean occ = new CedHistPermissaoBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (CedHistPermissaoBean) lista.get(i);
							%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
										<td width="2%"  align="center">
												<input type="radio" name="rdo" onclick="javascript: clickRadio('<%=occ.getData()%>','<%= occ.getHora()%>', '<%=occ.getTpAlteracao()%>','<%=occ.getIcAtual()%>','<%=occ.getUsuario()%>');">
									    </td>								    												    
										<td nowrap width="12%" align="right"><%=occ.getData()%></td>							    
										<td nowrap width="35%" align="left"><%=occ.getHora()%></td>
										<td nowrap width="12%" align="left"><%=occ.getTipoAlteracao()%></td>
									    <td nowrap width="13%" align="right"><%=occ.getUsuario()%></td>
									    <td nowrap width="7%" align="left"><%=occ.getSitAnterior()%></td>
									    <td nowrap width="7%" align="left"><%=occ.getSitAtual()%></td>
									</tr>
									
									
							<% 	} %>
							</table>
	                <tr> 
			              <td colspan="6">&nbsp;</td>
		              </tr>
							<tr>
								<td colspan="6" align="center">
										<s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>"	pageName="<%=CedenteEstrategia.PAGE_LISTAR_HISTORICO%>" />
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

		</table>    
		<script language="javascript">
			function inicia() {
				setFirstFieldFocus();
			}
		  function clickRadio(Data,Hora,TpAlteracao,IcAtual,usuario) {
			document.frmMain.data.value = Data;
			document.frmMain.hora.value = Hora;
			document.frmMain.tpAlteracao.value = TpAlteracao;
			document.frmMain.icAtual.value = IcAtual;
			document.frmMain.usuario.value = usuario
			
			
		  }
			function formSubmit() {
				if (validaSubmit()) {
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
				document.frmMain.fluxo.value = "PERMISSAO";
				document.frmMain.estrategia.value='cedente.CedenteConsultarIniciar';
	      		document.frmMain.submit();
	    }
		</script>			
	</s:FormStrategy>
</p:Document>
</html>
