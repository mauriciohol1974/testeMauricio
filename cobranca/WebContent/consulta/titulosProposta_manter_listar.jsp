<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TitulosPropostasEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.TitulosPropostaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.List"%>

<%
TitulosPropostaBean fixoBean = (session.getAttribute(TitulosPropostasEstrategia.MANTER_FIXO_BEAN)==null
 	                                      ? new TitulosPropostaBean()
 	                                      : (TitulosPropostaBean)session.getAttribute(TitulosPropostasEstrategia.MANTER_FIXO_BEAN));
CedenteCabecaBean cedCabBean = (session.getAttribute(TitulosPropostasEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TitulosPropostasEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(TitulosPropostasEstrategia.PAGINACAO_LIST);
	if(request.getParameter(TitulosPropostasEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(TitulosPropostasEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(TitulosPropostasEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(TitulosPropostasEstrategia.PAGINACAO_PAGE));
	}
	
	List lista = paginacao.getPage(paginaAtual);
	
	String situacao = (String) request.getAttribute("situacao");
	
	String paginaDetalhe = (String) request.getAttribute("pagDetalhe");
%>

<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.TitulosPropostasDetalhe" fluxo="normal">   	          				
   		<s:Menu/>
   		<s:Titulo name="Consultar Títulos Propostas >> Listar"/><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
   		
   		<input type="hidden" name="TipoConsulta" value="02">
		<input type="hidden" name="nossoNumero">
		<input type="hidden" name="codigoCedente" value="<%=cedCabBean.getCodigoCedenteFormatado()%>">
		<input type="hidden" name="situacao" value="<%=situacao%>">
		<input type="hidden" name="pagDetalhe" value="<%= paginaDetalhe%>">
		

	    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
	
			         
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
		              <td class="textoTitulo" width="17%">Situação Adesão:</td>
		              <td class="textoValor" width="26%"><%=fixoBean.getDescrSituacao() %></td>
		            </tr>
            
	            <tr> 
	              <td colspan="4">&nbsp;</td>
	            </tr>
	
	            <tr valign="top"> 
	              <td colspan="5" class="textoTitulo">
	                <hr>
	              </td>
	            </tr>
	            
							<tr>
								<td colspan="4">
									<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
									  <tr class="headerLista">
									    <td width="3%" align="center">&nbsp;</td>
	 								    <td width="10%" align="center">Nosso Número</td>
									    <td width="30%" align="left">Nome Sacado</td>
									    <td width="17%" align="center">CPF/CNPJ</td>
									    <td width="25%" align="right"> Valor Título</td>
									    <td width="15%" align="center">Vencimento</td>
									  </tr>
									  
<%
TitulosPropostaBean occ = new TitulosPropostaBean();
	for ( int i = 0; i < lista.size(); i++ ) {	
		occ = (TitulosPropostaBean) lista.get(i);
%>
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="3%" align="center">
									    	<input type="radio" name="radioUnidade" onclick="javascript:clickRadio('<%=occ.getNossoNumero()%>');">
									    </td>
	 								    <td width="10%" align="left"><%= occ.getNossoNumeroFormatado() %></td>
	 								    <td width="30%" align="left"><%= occ.getNomeFantasia() %></td>
									    <td width="17%" align="left"><%=occ.getCpfCnpj() %></td>
									    <td width="25%" align="right"><%=occ.getValorTitulo() %></td>
									    <td width="15%" align="center"><%=occ.getDtVencimentoFormatada() %></td>
									  </tr>
<%
	}
%>									  
	 	                <tr> 
		                  <td colspan="4">&nbsp;</td>
		                </tr>
										<tr>
											<td colspan="6" align="center">
											  <s:paginacao estrategia="<%=TitulosPropostasEstrategia.STRATEGY_MANTER_FILTRO %>" />
											</td>
										</tr>
	 	                <tr> 
		                  <td colspan="6">&nbsp;</td>
		                </tr>
	
		                <tr>
		                  <td align="right" colspan="6">
		                    <p align="center"> 
		                      <s:Button name="Ok" action="javascript:formSubmit_Consultar();" />
		                      <s:Button name="Voltar" action="javascript:formSubmit_Voltar();" />
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
	
	    <script language="javascript">
		    function inicia(){
		        setFirstFieldFocus();
		    }
		    
		    function formSubmit() {
		    	formSubmit_Consultar();
		    }
		    
		    function formSubmit_Consultar() {
	        if (validaSubmit()) {
	          document.frmMain.submit();
	        }
		    }
		    
		    function formSubmit_Voltar() {
					document.frmMain.estrategia.value = "consulta.TitulosPropostasIniciar";
	       			document.frmMain.fluxo.value = "voltar";				
					document.frmMain.submit();
		    }
		    
		    function validaSubmit(){
					if (document.frmMain.radioUnidade[0] != null) {
	
						if (!validaRadioButtonMsg(document.frmMain.radioUnidade, '', "003")) {
							return false;
						}
	
					} else if (document.frmMain.radioUnidade != null) {
	
						if (!document.frmMain.radioUnidade.checked) {
							msg('003', '');
							return false;
						}
	
					} else {
						return false;
					}
				
			    return true;
		    }
		    
		    function clickRadio( codigo ) {
		    	document.frmMain.nossoNumero.value = codigo;
		    }
	    </script>

		</s:FormStrategy>
	</p:Document>

</html>