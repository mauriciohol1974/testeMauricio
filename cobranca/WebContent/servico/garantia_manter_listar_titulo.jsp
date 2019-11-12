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
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituGarantiaEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>


<%

	InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean)session.getAttribute(TituGarantiaEstrategia.USUARIOLDAP_BEAN);

	CedenteCabecaBean cedCabBean = (session.getAttribute(TituGarantiaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TituGarantiaEstrategia.CEDENTE_CABECALHO_BEAN));
	TituloListarBean tituloListarBean = (session.getAttribute(TituGarantiaEstrategia.DATA_FIXO_LIST)==null?new TituloListarBean():(TituloListarBean)session.getAttribute(TituGarantiaEstrategia.DATA_FIXO_LIST));	
	TituloBean tituloBean = (session.getAttribute(TituGarantiaEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(TituGarantiaEstrategia.DATA_BEAN));	
	
	//EAM - SISOT 51H - Incluir o campo PV de Vinculação no cabeçalho
	CedenteGeralBean cedGeralBean = (session.getAttribute(TituGarantiaEstrategia.CEDENTE_GERAL_BEAN)==null?new CedenteGeralBean():(CedenteGeralBean)session.getAttribute(TituGarantiaEstrategia.CEDENTE_GERAL_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(TituGarantiaEstrategia.PAGINACAO_LIST);
	if(request.getParameter(TituGarantiaEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(TituGarantiaEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(TituGarantiaEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(TituGarantiaEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);
	

%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
	estrategia="<%=TituGarantiaEstrategia.STRATEGY_MANTER_FINALIZAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TituGarantiaEstrategia.PAGE_TITLE_LISTAR%>"/>
			
		
		<input type="hidden" name = "codigoCedente"  value="<%=tituloListarBean.getCodigoCedente()%>">
		
		<input type="hidden" name = "classificacao"  value="<%=tituloListarBean.getClassificacao()%>">
		<input type="hidden" name = "codUsuario"     value="<%=usuarioLDAPBean.getCodigoUsuario()%>">
		
		<input type="hidden" name = "id0" value="">
		<input type="hidden" name = "id1" value="">
		<input type="hidden" name = "id2" value="">
		<input type="hidden" name = "id3" value="">
		<input type="hidden" name = "id4" value="">
		<input type="hidden" name = "id5" value="">
		<input type="hidden" name = "id6" value="">
		<input type="hidden" name = "id7" value="">
		<input type="hidden" name = "id8" value="">
		<input type="hidden" name = "id9" value="">
		<input type="hidden" name = "id10" value="">
		<input type="hidden" name = "id11" value="">
		<input type="hidden" name = "id12" value="">
		<input type="hidden" name = "id13" value="">
		<input type="hidden" name = "id14" value="">
		<input type="hidden" name = "id15" value="">
		<input type="hidden" name = "id16" value="">
		<input type="hidden" name = "id17" value="">
		<input type="hidden" name = "id18" value="">
		<input type="hidden" name = "id19" value="">
		
		
		<input type="hidden" name = "identNN0" value="">
		<input type="hidden" name = "identNN1" value="">
		<input type="hidden" name = "identNN2" value="">
		<input type="hidden" name = "identNN3" value="">
		<input type="hidden" name = "identNN4" value="">
		<input type="hidden" name = "identNN5" value="">
		<input type="hidden" name = "identNN6" value="">
		<input type="hidden" name = "identNN7" value="">
		<input type="hidden" name = "identNN8" value="">
		<input type="hidden" name = "identNN9" value="">
		<input type="hidden" name = "identNN10" value="">
		<input type="hidden" name = "identNN11" value="">
		<input type="hidden" name = "identNN12" value="">
		<input type="hidden" name = "identNN13" value="">
		<input type="hidden" name = "identNN14" value="">
		<input type="hidden" name = "identNN15" value="">
		<input type="hidden" name = "identNN16" value="">
		<input type="hidden" name = "identNN17" value="">
		<input type="hidden" name = "identNN18" value="">
		<input type="hidden" name = "identNN19" value="">
		
		
		
		<input type="hidden" name = "<%=TituGarantiaEstrategia.PAGINACAO_PAGE%>" value="">
	
	  <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<td valign="top" width="1%" height="14" align="left">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	  		<td valign="top" width="95%" height="14" align="left"> 
	    		<table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="left">
          	<tr>
            	<td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=tituloListarBean.getCodigoCedenteFormatado()%></td>
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
		          <td colspan="4">&nbsp;</td>
	          </tr>
	          <tr valign="top"> 
	  	        <td colspan="4" class="textoTitulo">&nbsp;
	    	        <hr>
	            </td>
	         	</tr>
            
						<tr>
					  	<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
									<tr class="headerLista">
									  <td nowrap width="2%" align="center"><input type="checkbox" name="rdoMarcar" onclick="javascript: clickMarcar();"></td>
	 								  <td nowrap width="12%" align="right">Nosso Número</td>
									  <td nowrap width="35%" align="left">Nome Sacado</td>
	 								  <td nowrap width="20%" align="center">CPF/CNPJ do Sacado</td>
	 								  <td nowrap width="15%" align="center">Valor</td>
	 								  <td nowrap width="15%" align="center">Data Vencimento</td>
								      <td nowrap width="15%" align="center">Número Documento</td>
								  </tr>

							<%
									TituloListarBean occ = new TituloListarBean();
									TituloListarBean nnI = (TituloListarBean) lista.get(0);
									if (lista.size()>0){
										TituloListarBean nnF = (TituloListarBean) lista.get(lista.size()-1);
										%><input type="hidden" name = "nossoNumeroFim" value="<%=nnF.getNossoNumero()%>"><%
									}else{
										%><input type="hidden" name = "nossoNumeroFim" value="0"><%
									}
									
							%>
							
									<input type="hidden" name = "nossoNumero"    value="<%=nnI.getNossoNumero()%>">
									
							
							<%		
							
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (TituloListarBean) lista.get(i);
							%>
							
									

									<input type="hidden" name="ident" value="<%=occ.getNossoNumero()%>">
									<input type="hidden" name="identValue" value="<%=occ.getIndGarantia()%>">
									
									
									
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
										<td width="2%" align="center">
											<input type="checkbox" name="rdo" <%=occ.getIndGarantia().equals("S") ? "checked" : ""%> onclick="javascript: clickRadio('<%=i%>');">
								    </td>								    												    
									<td nowrap width="12%" align="right"><%=occ.getNossoNumeroFormatado()%></td>							    
									<td nowrap width="35%" align="left"><%=occ.getNomeSacado()%></td>
									<td nowrap width="35%" align="left"><%=occ.getCpfSacado()%></td>
								    <td nowrap width="20%" align="right"><%=occ.getValor().toString().equals("R$ 0,00")?"":occ.getValor().toString()%></td>
	 							    <td nowrap width="15%" align="center"><%=occ.getDataVencimentoFormatada().equals("01/01/0001")?"":occ.getDataVencimentoFormatada()%></td>
	 							    <td nowrap width="15%" align="right"><%=occ.getNuDocto()%></td>
	 							    
									</tr>
							<% 	}
									int totalFalta = 20 - lista.size();
									
									for ( int i = 0; i < totalFalta; i++ ) {	
							%>
									<input type="hidden" name="ident" value="">
									<input type="hidden" name="identValue" value="">
							<%} %>
	                <tr> 
			              <td colspan="6">&nbsp;</td>
		              </tr>
							<tr>
								<td colspan="6" align="center">
										<%String pageName = TituGarantiaEstrategia.PAGE_FILTRO_LISTAR_TITULO;%>
										<s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" 
											numberOfPages="<%=paginacao.getPageCount()%>" 
											pageName="<%=pageName%>" />
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
							<td width="17%" class="textoTitulo">Quantidade Total:</td>
							<td width="26%" class="textoValor"><%=tituloListarBean.getQuantidadeTotal()%></td>
						  <td width="17%" class="textoTitulo">Valor Total:</td>
							<td width="26%" class="textoValor"><%=tituloListarBean.getValorTotal()%></td>
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
			
		  	function clickRadio(id) {
				if (document.frmMain.identValue[id].value=="N"){
					document.frmMain.identValue[id].value="S"
				}else{
					document.frmMain.identValue[id].value="N"
				}

		  	}
		  	
		  
		  	
		  	
			function formSubmit() {
				
				document.frmMain.identNN0.value =  document.frmMain.identValue[0].value;
				document.frmMain.id0.value =  document.frmMain.ident[0].value;

				document.frmMain.identNN1.value =  document.frmMain.identValue[1].value;
				document.frmMain.id1.value =  document.frmMain.ident[1].value;

				document.frmMain.identNN2.value =  document.frmMain.identValue[2].value;
				document.frmMain.id2.value =  document.frmMain.ident[2].value;

				document.frmMain.identNN3.value =  document.frmMain.identValue[3].value;
				document.frmMain.id3.value =  document.frmMain.ident[3].value;

				document.frmMain.identNN4.value =  document.frmMain.identValue[4].value;
				document.frmMain.id4.value =  document.frmMain.ident[4].value;

				document.frmMain.identNN5.value =  document.frmMain.identValue[5].value;
				document.frmMain.id5.value =  document.frmMain.ident[5].value;

				document.frmMain.identNN6.value =  document.frmMain.identValue[6].value;
				document.frmMain.id6.value =  document.frmMain.ident[6].value;

				document.frmMain.identNN7.value =  document.frmMain.identValue[7].value;
				document.frmMain.id7.value =  document.frmMain.ident[7].value;

				document.frmMain.identNN8.value =  document.frmMain.identValue[8].value;
				document.frmMain.id8.value =  document.frmMain.ident[8].value;

				document.frmMain.identNN9.value =  document.frmMain.identValue[9].value;
				document.frmMain.id9.value =  document.frmMain.ident[9].value;

				document.frmMain.identNN10.value =  document.frmMain.identValue[10].value;
				document.frmMain.id10.value =  document.frmMain.ident[10].value;

				document.frmMain.identNN11.value =  document.frmMain.identValue[11].value;
				document.frmMain.id11.value =  document.frmMain.ident[11].value;

				document.frmMain.identNN12.value =  document.frmMain.identValue[12].value;
				document.frmMain.id12.value =  document.frmMain.ident[12].value;

				document.frmMain.identNN13.value =  document.frmMain.identValue[13].value;
				document.frmMain.id13.value =  document.frmMain.ident[13].value;

				document.frmMain.identNN14.value =  document.frmMain.identValue[14].value;
				document.frmMain.id14.value =  document.frmMain.ident[14].value;

				document.frmMain.identNN15.value =  document.frmMain.identValue[15].value;
				document.frmMain.id15.value =  document.frmMain.ident[15].value;

				document.frmMain.identNN16.value =  document.frmMain.identValue[16].value;
				document.frmMain.id16.value =  document.frmMain.ident[16].value;

				document.frmMain.identNN17.value =  document.frmMain.identValue[17].value;
				document.frmMain.id17.value =  document.frmMain.ident[17].value;

				document.frmMain.identNN18.value =  document.frmMain.identValue[18].value;
				document.frmMain.id18.value =  document.frmMain.ident[18].value;

				document.frmMain.identNN19.value =  document.frmMain.identValue[19].value;
				document.frmMain.id19.value =  document.frmMain.ident[19].value;

				
				
				
				
				document.frmMain.submit();
			}  

			function formSubmit_Voltar() {
				document.frmMain.estrategia.value = "<%=TituGarantiaEstrategia.STRATEGY_MANTER_INICIAR%>";
		      	document.frmMain.submit();
	    	}
			
			
			
			
			function clickMarcar() {
		  		if (document.frmMain.rdoMarcar.checked==true){
		  			var i;
			  		for (i=0;i<20;i++){
			  			document.frmMain.rdo[i].checked=true;
			  			document.frmMain.identValue[i].value="S";
			  		}		  			
		  		}else{
		  			var z
			  		for (z=0;z<20;z++){
			  			document.frmMain.rdo[z].checked=false;
			  			document.frmMain.identValue[z].value="N";
			  		}		  			
		  			
		  		}
		  	}
			
			
			
		</script>			
	</s:FormStrategy>
</p:Document>
</html>
