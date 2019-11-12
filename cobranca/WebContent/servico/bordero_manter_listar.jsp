<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bordero_manter_listar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 15/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BorderoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(BorderoEstrategia.PAGINACAO_LIST);
	if(request.getParameter(BorderoEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(BorderoEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(BorderoEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(BorderoEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(BorderoEstrategia.USUARIOLDAP_BEAN);
	BorderoBean borderoBean = (session.getAttribute(BorderoEstrategia.DATA_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(BorderoEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Manter Borderô >> Listar"/>    
  	<input type="hidden" name="codigoCedente" value="<%=borderoBean.getCodigoCedente()%>">
  	<input type="hidden" name="codigoBordero" value="">
  	<input type="hidden" name="situacao" value="">
  	<input type="hidden" name="<%=BorderoEstrategia.PAGINACAO_PAGE%>" value="">
  	<input type="hidden" name="navegacao" >

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoCedenteFormatado()%></td>
  
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" nowrap width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
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
  
              <td class="textoTitulo" width="17%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Borderôs:
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="10%" align="right">Borderô</td>
								    <td nowrap width="10%" align="right">Quantidade</td>
 								    <td nowrap width="15%" align="right">Valor</td>
 								    <td nowrap width="15%" align="center">Data Movimento</td>
 								    <td nowrap width="30%" align="left">Situação</td>
								  </tr>
							<%
									BorderoBean occ = new BorderoBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (BorderoBean) lista.get(i);
							%>
									  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									      <input type="radio" name="rdo"
								    		  onclick="javascript: clickRadio(<%=occ.getCodigoBordero()%>,<%=occ.getSituacao()%>);">
								    	</td>
	 								    <td width="10%" align="right"><%=occ.getCodigoBordero()%></td>
	 								    <td width="10%" align="right"><%=occ.getQuantidade()%></td>
	 								    <td width="20%" align="right"><%=occ.getValor()%></td>
	 								    <td width="15%" align="center"><%=occ.getDataMovimentoFormatada()%></td>
	 								    <td width="30%" align="left"><%=occ.getSituacaoTexto()%></td>
									  </tr>
						<%  } %>	  

 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="6" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=BorderoEstrategia.PAGE_MANTER_LISTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="6">
	                    <p align="center"> 
			                  <s:Button name="ManterTitulos" value="Manter Títulos" action="javascript:formSubmit_ManterTitulos();"/>
			                  <s:Button name="AlterarBordero" value="Alterar Borderô" action="javascript:formSubmit_AlterarBordero();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.alterar"/>
			                  <s:Button name="ConsultarBordero" value="Consultar Borderô" action="javascript:formSubmit_ConsultarBordero();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.consultar"/>
			                  <s:Button name="ExcluirBordero" value="Excluir Borderô" action="javascript:formSubmit_ExcluirBordero();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.excluir"/>
			                  <s:Button name="ImprimirBordero" value="Imprimir Borderô" action="javascript:formSubmit_ImprimirBordero();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.alterar"/>
				                <s:Button name="FinalizarBordero" value="Finalizar Borderô" action="javascript:formSubmit_FinalizarBordero()" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.alterar"/>
			  	            	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
	                    </p>
	                  </td>
	                </tr>
 	                <tr> 
	                  <td colspan="8">&nbsp;</td>
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
				setFirstFieldFocus();
	    }
	  	function formSubmit() {
	    }  
	    
	    function formSubmit_ManterTitulos() {
        if (validaSubmit()) {
	        document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_MANTER_LISTAR%>';
   	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_LISTA_TITULO%>';	        
	        document.frmMain.submit();
        }
	    }
	    function formSubmit_AlterarBordero() {
        if (validaSubmit()) {
	        document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_ALTERAR%>';
	    		if (document.frmMain.situacao.value == 2){
	        	if (confirm(conf("138"))) {	
      	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_BORDERO%>';
  		        document.frmMain.submit();
  	  	    }
  	  	  }
  	  	  else{
      	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_BORDERO%>';
  	  	      document.frmMain.submit();
  	  	  }
        }
	    }
	    function formSubmit_ConsultarBordero() {
        if (validaSubmit()) {
	        document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_CONSULTAR%>';
   	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_BORDERO%>';
          document.frmMain.submit();
        }
	    }
	    function formSubmit_ExcluirBordero() {
        if (validaSubmit()) {
	    		if (document.frmMain.situacao.value == 1){
	    			if (confirm(conf("102", "Borderô"))) {	
		    			document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_EXCLUIR%>';
		   	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_BORDERO%>';
            	document.frmMain.submit();
            }
	    		}
	    		else if (document.frmMain.situacao.value == 2){
	    			if (confirm(conf("137", "Borderô"))) {	
		    			document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_EXCLUIR%>';
	     	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_BORDERO%>';  
            	document.frmMain.submit();
            }
	    		}
	    	}
	    }
	    function formSubmit_ImprimirBordero() {
        if (validaSubmit()) {
	    		if (document.frmMain.situacao.value == 1){	
							msg("016");
					}
					else{
						retorno = window.open("<%=Paths.getRootForDynamicContent()%>/jump/bordero_jump.jsp","relatorio<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "width=780,height=540,top=0,left=0,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=1");
						retorno.focus();
        	}
        }
	    }
	    
	    function formSubmit_FinalizarBordero() {
	        if (validaSubmit()){
	    			if (document.frmMain.situacao.value == 2){	
							msg("017");
						}
						else{	        	
	        		if (confirm(conf("139"))) {	
			        	document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_FINALIZAR%>';
			   	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_BORDERO%>';
	            	document.frmMain.submit();
	          	}
	          }
	        }
	    }
	    function formSubmit_Voltar() {
           document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_MANTER_FILTRO%>';
           document.frmMain.fluxo.value = "voltar";
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
	    
	    function clickRadio(codigoBordero, situacao) {
				document.frmMain.codigoBordero.value = codigoBordero;
				document.frmMain.situacao.value = situacao;
      }
		</script>
  </s:FormStrategy>
</p:Document>
</html>
