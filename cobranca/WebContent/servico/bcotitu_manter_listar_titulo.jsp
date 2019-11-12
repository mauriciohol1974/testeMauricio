<%@page import="br.com.politec.sao.business.types.MoneyType"%>
<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Agosto de 2004
*Projeto CAIXA - SIGCB7
*Componente: bcotitu_manter_listar_titulo.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 03/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloListarBean"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BcoTituEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>
<%@page import="br.com.politec.sao.util.Currency"%>
<%@page import="br.com.politec.sao.util.Money"%>
<%@page import="br.gov.caixa.sigcb.util.Util" %>



<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN));
	TituloListarBean tituloListarBean = (session.getAttribute(BcoTituEstrategia.DATA_FIXO_LIST)==null?new TituloListarBean():(TituloListarBean)session.getAttribute(BcoTituEstrategia.DATA_FIXO_LIST));	
	TituloBean tituloBean = (session.getAttribute(BcoTituEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(BcoTituEstrategia.DATA_BEAN));	
	
	//EAM - SISOT 51H - Incluir o campo PV de Vinculação no cabeçalho
	CedenteGeralBean cedGeralBean = (session.getAttribute(BcoTituEstrategia.CEDENTE_GERAL_BEAN)==null?new CedenteGeralBean():(CedenteGeralBean)session.getAttribute(BcoTituEstrategia.CEDENTE_GERAL_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(BcoTituEstrategia.PAGINACAO_LIST);
	
	
	if(request.getParameter(BcoTituEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(BcoTituEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(BcoTituEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(BcoTituEstrategia.PAGINACAO_PAGE));
	}
	
	
	List lista = paginacao.getPage(paginaAtual);	
	String origem = (String) session.getAttribute("ORIGEM");
	
	String TotalRegistros = (String) session.getAttribute("TotalRegistros");
	String controle = (String) session.getAttribute("controle");
	
	Vector tituloExportarBean = (Vector) session.getAttribute("tituloExportarBean");	
	
	int  proxBloco = Integer.parseInt( controle.substring(controle.length()-18, controle.length()-10));
	
	int blocoIni = 0;
	
	int blocoAnt = Integer.parseInt(controle.substring(56, 64)) - 100;
	
	int totRegistrosLista = tituloExportarBean.size();
	TituloListarBean contar = new TituloListarBean();
	double valorTotal = 0;
	for (int i=0;i<tituloExportarBean.size();i++){
		contar = (TituloListarBean) tituloExportarBean.get(i);
		valorTotal = valorTotal + contar.getValor().toDouble() * 100;
		
	}
	
	long totalLng = (long) valorTotal;
	
	Money mnValorTotal = new Money(Util.zerosEsquerda(totalLng, 15), 2, Currency.real());
	
	boolean bloco = false;
	
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
	estrategia="<%=BcoTituEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=BcoTituEstrategia.PAGE_TITLE_LISTAR%>"/>
			
		<input type="hidden" name = "filtroSelecao" value="<%=2/*tituloBean.getFiltroSelecao()*/%>">
		<input type="hidden" name = "filtroDescricaoSituacao" value="<%=tituloBean.getFiltroDescricaoSituacao()%>">
		<input type="hidden" name = "filtroDescricaoClassificacao" value="<%=tituloBean.getFiltroDescricaoClassificacao()%>">
		<input type="hidden" name = "filtroVoltarListarConsolidado" value="<%=tituloBean.getFiltroVoltarListarConsolidado()%>">
		<input type="hidden" name = "filtroVoltarListarTitulo" value="1">
		<input type="hidden" name = "filtroVoltarAcao" value="0">
		
		<input type="hidden" name = "codigoCedente" value="<%=tituloBean.getCodigoCedente()%>">
		<input type="hidden" name = "nossoNumero" value="<%=tituloBean.getNossoNumero()%>">
		<input type="hidden" name = "situacao" value="<%=tituloBean.getSituacao()%>">
		<input type="hidden" name = "classificacao" value="<%=tituloBean.getClassificacao()%>">
		<input type="hidden" name = "dataInicio" value="<%=tituloListarBean.getDataInicioFormatada()%>">
		<input type="hidden" name = "dataFim" value="<%=tituloListarBean.getDataFimFormatada()%>">
		<input type="hidden" name = "ORIGEM" value="<%=origem%>">	
		<input type="hidden" name = "TotalRegistros" value="<%=TotalRegistros%>">
		<input type="hidden" name = "totRegistrosLista" value="<%=totRegistrosLista%>">
		
		<input type="hidden" name = "controle" value="<%=controle%>">
		<input type="hidden" name = "tipoAvanco" value="P">
		
		<input type="hidden" name = "proxBloco" value="<%=proxBloco%>">	 		
		 		

		<input type="hidden" name = "<%=BcoTituEstrategia.PAGINACAO_PAGE%>" value="">
		
		 <input type="hidden" name="pagina" value="<%=paginaAtual%>"/>
	
	  <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<td valign="top" width="1%" height="14" align="left">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	  		<td valign="top" width="95%" height="14" align="left"> 
	    		<table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="left">
          	<tr>
            	<td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getCodigoCedenteFormatado()%></td>
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
              <td class="textoTitulo" width="17%">PV de Vinculação: </td>
              <td class="textoValor" width="26%"><%=cedGeralBean.getCodigoUnidadePVVincFormatado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Filtro por: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getFiltroDescricaoSituacao()%></td>
              <td class="textoTitulo" width="17%">Classificado por: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getFiltroDescricaoClassificacao()%></td>
			</tr>
			<tr>
			  <td width="17%" colspan="4" class="textoTitulo"><hr></td>
			</tr>
			
			<tr>
			  <td width="17%" colspan="4" class="textoTitulo" align="center"><%=tituloListarBean.getDePeriodo()%></td>
			</tr>

	          <tr valign="top"> 
	  	        <td colspan="4" class="textoTitulo">Banco de Títulos:
	    	        <hr>
	            </td>
	         	</tr>
            
						<tr>
					  	<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
									<tr class="headerLista">
									  <td nowrap width="2%" rowspan="3" align="center">&nbsp;</td>
	 								  <td nowrap width="20%" align="right">Nosso Número</td>
									  <td nowrap width="33%" align="left" colspan="3">Nome Sacado</td>
	 								  <td nowrap width="20%" align="left">CPF/CNPJ do sacado</td>
	 								  <td nowrap width="13%" align="right">Valor</td>
	 								  <td nowrap width="7%" align="right">Parcela</td>
									</tr>
							  		<tr class="headerLista">
									  <td nowrap width="15%" align="right">Inclusão</td>
									  <td nowrap width="15%" align="right">Vencimento</td>
									  <td nowrap width="15%" align="center">Protesto</td>
									  <td nowrap width="15%" align="center">Prazo</td>
									  <td nowrap width="15%" align="right">Dt. Baixa</td>
									  <td nowrap width="25%" align="right">Valor Pago</td>
								  	</tr>
									<tr class="headerLista">
									  <td nowrap width="20%" align="center">&nbsp;</td>
									  <td nowrap width="20%" align="center">Usuário</td>
									  <td nowrap width="20%" align="center">&nbsp;</td>
									  <td nowrap width="20%" align="center">Último Comando</td>
									  <td nowrap width="20%" align="center">&nbsp;</td>
					    			  <td nowrap width="18%" align="center">Cod. Últ. Comando</td>
								  	</tr>
											
								  	

							<%
									TituloListarBean occ = new TituloListarBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (TituloListarBean) lista.get(i);
							%>

										
											<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
												<td width="2%" rowspan="3" align="center">
														<input type="radio" name="rdo" 
														  onclick="javascript: clickRadio('<%=occ.getNossoNumero()%>');">
											    </td>								    												    
												<td nowrap width="20%" align="right"><%=occ.getNossoNumeroFormatado()%></td>							    
												<td nowrap width="33%" align="left" colspan="3"><%=occ.getNomeSacado().equals("")?"&nbsp;":occ.getNomeSacado()%></td>
												<td nowrap width="20%" align="left"><%=occ.getCpfSacado().equals("")?"&nbsp;":occ.getCpfSacado()%></td>
											    <td nowrap width="18%" align="right"><%=occ.getValor().toString().equals("R$ 0,00")?"&nbsp;":occ.getValor().toString()%></td>
												<td nowrap width="7%" align="left"><%=occ.getParcela()%></td>
											</tr>
											<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
												<td nowrap width="15%" align="right"><%=occ.getDtInclusaoFormatada()%></td>
												<td nowrap width="15%" align="right"><%=occ.getDataVencimentoFormatada().equals("01/01/0001")?"":occ.getDataVencimentoFormatada()%></td>						    
												<td nowrap width="15%" align="center"><%=occ.getIndProtesto().equals("")?"&nbsp;":occ.getIndProtesto()%></td>
											    <td nowrap width="15%" align="center"><%=occ.getPrazoProtDev().equals("")?"&nbsp;":occ.getPrazoProtDev()%></td>
				 							    <td nowrap width="15%" align="right"><%=occ.getDtBaixaFormatada().equals("01/01/0001")?"":occ.getDtBaixaFormatada()%></td>
				 							    <td nowrap width="25%" align="right"><%=occ.getValorPago().toString().equals("R$ 0,00")?"":occ.getValorPago().toString()%></td>
											</tr>
											<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
												<td nowrap width="20%" align="center">&nbsp;</td>
												<td nowrap width="20%" align="center"><%=occ.getCodigoUsuario()%></td>
												<td nowrap width="20%" align="center">&nbsp;</td>
												<td nowrap width="20%" align="center"><%=occ.getDataUltimoComandoFormatada().equals("01/01/0001")?"":occ.getDataUltimoComandoFormatada()%></td>
												<td nowrap width="20%" align="center">&nbsp;</td>
												<td nowrap width="18%" align="left" title="<%=occ.getUltDescricao()%>"><%=occ.getCodigoUltimoComando().equals(new Long(0))?"":occ.getCodigoUltimoComando().toString()%></td>
											</tr>

											
									
							<% 	} %>
								
							
	
	                 <tr> 
			              <td colspan="6">&nbsp;</td>
		              </tr>
							<tr>
								<td colspan="6" align="center">
										<%String pageName = BcoTituEstrategia.PAGE_FILTRO_LISTAR_TITULO;%>
										<%if (origem.equalsIgnoreCase("A")) {%>
												<s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>"	pageName="<%=pageName%>" />
										<%}else{ %>

												<s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>"	pageName="<%=pageName%>" />
												
														<%if (proxBloco>101){ %>
														<a href='javascript:paginarBloco(<%=blocoIni%>,"0")'>Bloco Inicial</a>&nbsp;&nbsp;&nbsp;
														<%} %>
														
														<%if (proxBloco>101){ %>
														<a href='javascript:paginarBloco(<%=blocoAnt%>,"A")'>Bloco Anterior</a>
														<%} %>
														
														<%if (totRegistrosLista>=2000 && (proxBloco>100)){
															if (controle.substring(controle.length()-1, controle.length()).equalsIgnoreCase("N")){ %>
															&nbsp;&nbsp;&nbsp;<a href='javascript:paginarBloco(<%= proxBloco%>,"P")'>Próximo Bloco</a>
															<br/><b><span style="color:red;font-family:verdana;font-size:11;">Exibindo bloco de páginas de <%=Integer.parseInt(controle.substring(56, 64)) %> até <%=Integer.parseInt(controle.substring(64, 72))  %></span></b>
														<%}}%>
														
														
														<%if (controle.substring(controle.length()-1, controle.length()).equalsIgnoreCase("S") && (proxBloco>200)){ %>
														<br/><b><span style="color:red;font-family:verdana;font-size:11;">Exibindo bloco de páginas de <%=Integer.parseInt(controle.substring(56, 64)) %> até <%=Integer.parseInt(controle.substring(64, 72))  %></span></b>
														<%} %>
														

										<%} %>
								</td>
							</tr>

		            </table>
		          </td>
		        </tr>

	          <tr valign="top"> 
	  	        <td colspan="4" class="textoTitulo">Totais:
	    	        <hr>
	            </td>
	         	</tr>

						<tr>
							<td width="17%" class="textoTitulo">
														<%if (totRegistrosLista>=2000 && (proxBloco>100)){
															if (controle.substring(controle.length()-1, controle.length()).equalsIgnoreCase("N")){ 
															bloco = true;
														}}%>
														
														
														<%if (controle.substring(controle.length()-1, controle.length()).equalsIgnoreCase("S") && (proxBloco>200)){ 
															bloco = true;
														}%>
														<%if (bloco == true) {%>
															Quantidade Total do Bloco:
														<%}else{ %>
															Quantidade Total:
														<%} %>
							
							</td>
							<td width="26%" class="textoValor"><%=totRegistrosLista%></td>
						    <td width="17%" class="textoTitulo"><%if (bloco == true) {%>
															Valor Total do Bloco:
														<%}else{ %>
															Valor Total:
														<%} %></td>
							<td width="26%" class="textoValor"><%=mnValorTotal%></td>
						</tr>
		                
		 				<tr> 
	   					<td colspan="4">&nbsp;</td>
	   				</tr>
				    <tr>
	    			  <td align="right" colspan="4">
	      				<p align="center"> 
                 	<s:Button name="Ok" action="javascript: formSubmit();"/>
                 	<s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
                 	<s:Button name="Exportar Arq." action="javascript: formSubmit_Exportar();"/>
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
		  function clickRadio(nossoNumero) {
			document.frmMain.nossoNumero.value = nossoNumero;
		  }
			function formSubmit() {
				if (validaSubmit()) {
				  	document.frmMain.filtroSelecao.value = 1;
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
				document.frmMain.filtroVoltarListarTitulo.value = '0';
				if (document.frmMain.filtroVoltarListarConsolidado.value == '1') {
	        		document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_MANTER_FILTRO%>";
				} else {
					document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_MANTER_INICIAR%>";
				}
	      document.frmMain.fluxo.value = "voltar";
	      document.frmMain.submit();
	    }
		  
		  
		function formSubmit_Exportar() {
			document.frmMain.filtroSelecao.value = 3;
			document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_MANTER_FILTRO%>";
	      	document.frmMain.submit();
	    }  
		  
		
		function paginarBloco(valor, tipo){
			document.frmMain.filtroSelecao.value = 2;
			document.frmMain.tipoAvanco.value=tipo;
		    document.frmMain.estrategia.value = "servico.BcoTituManterFiltro";
		    document.frmMain.pagina.value = valor;
		    document.frmMain.submit();
		  }
		</script>			
	</s:FormStrategy>
</p:Document>
</html>
