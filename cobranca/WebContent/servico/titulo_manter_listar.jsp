<!--
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: titulo_manter_listar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 20/09/2004
************************************************/
-->
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoTituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BorderoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloEstrategia"%>
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
	BorderoTituloBean occ = new BorderoTituloBean();
	BorderoTituloBean borderoTituloBean = (session.getAttribute(TituloEstrategia.FIXO_BEAN)==null?new BorderoTituloBean():(BorderoTituloBean)session.getAttribute(TituloEstrategia.FIXO_BEAN));
	BorderoBean borderoBean = (session.getAttribute(BorderoEstrategia.DATA_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(BorderoEstrategia.DATA_BEAN));
	BorderoBean borderoFiltroBean = (session.getAttribute(BorderoEstrategia.FILTRO_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(BorderoEstrategia.FILTRO_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN));
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(TituloEstrategia.USUARIOLDAP_BEAN);
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Manter Borderô >> Manter Títulos"/>    
   	<input type="hidden" name="<%=BorderoEstrategia.PAGINACAO_PAGE%>" value="">
		<input type="hidden" name="situacao" value="<%=borderoTituloBean.getSituacao()%>">
		<input type="hidden" name="codigoCedente" value="<%=borderoBean.getCodigoCedente()%>">
		<input type="hidden" name="codigoBordero" value="<%=borderoBean.getCodigoBordero()%>">
   	<input type="hidden" name="registro" value="">
   	<input type="hidden" name="totalTitulos" value="<%=borderoTituloBean.getTotalTitulos().toString()%>">
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
  
              <td class="textoTitulo" width="17%">Borderô: </td>
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoBordero().equals( new Long(0))?"":borderoBean.getCodigoBordero().toString()%></td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Total de Títulos:</td>
              <td class="textoValor" width="26%"><%=borderoTituloBean.getTotalTitulos().equals( new Long(0))?"":borderoTituloBean.getTotalTitulos().toString()%></td>
              <td class="textoTitulo" width="17%">Valor Total do Borderô:</td>
              <td class="textoValor" width="26%"><%=borderoTituloBean.getValorTotalBordero().toString().equals("R$ 0,00")?"":borderoTituloBean.getValorTotalBordero().toString()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Títulos Incluídos:</td>
              <td class="textoValor" width="26%"><%=borderoTituloBean.getTitulosIncluidos().toString()%></td>
              <td class="textoTitulo" width="17%">Valor de Títulos Incluídos:</td>
              <td class="textoValor" width="26%"><%=borderoTituloBean.getValorTitulosIncluidos().toString()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Situação</td>
              <td class="textoValor" width="26%"><%=borderoBean.getSituacaoTexto()%></td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center"> 
                  <s:Button name="AlterarBordero" value="Alterar Borderô" action="javascript:formSubmit_AlterarBordero();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.alterar"/>
                  <s:Button name="ConsultarBordero" value="Consultar Borderô" action="javascript:formSubmit_ConsultarBordero();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.consultar"/>
                  <s:Button name="ExcluirBordero" value="Excluir Borderô" action="javascript:formSubmit_ExcluirBordero();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.excluir"/>
                  <s:Button name="ImprimirBordero" value="Imprimir Borderô" action="javascript:formSubmit_ImprimirBordero();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.alterar"/>
	                <s:Button name="FinalizarBordero" value="Finalizar Borderô" action="javascript:formSubmit_FinalizarBordero()" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.alterar"/>
                </p>
              </td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Títulos:
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								<% 	occ = (BorderoTituloBean) lista.get(0);
										if(!occ.getNumeroSequencial().equals(new Long(0))){%>								
										<!%if necessário para o caso do borderô não possuir títulos cadastrados!!!!%!>
								  <tr class="headerLista">
								    <td nowrap width="4%" align="center">&nbsp;</td>
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="15%" align="right">Número Documento</td>
								    <td nowrap width="15%" align="right">Nosso Número</td>
 								    <td nowrap width="10%" align="center">Vencimento</td>
 								    <td nowrap width="20%" align="left">Nome Sacado</td>
 								    <td nowrap width="10%" align="right">CPF/CNPJ Sacado</td>
 								    <td nowrap width="20%" align="left">Nome Sacador</td>
								  </tr>
 							<%			for ( int i = 0; i < lista.size(); i++ ) {	
												occ = (BorderoTituloBean) lista.get(i);
							%>
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
	 								    <td width="4%" align="right"><%=occ.getNumeroSequencial()%></td>
									    <td width="2%" align="center">
									      <input type="radio" name="rdo"
								    		  onclick="javascript: clickRadio('<%=occ.getRegistro()%>');">
								    	</td>
	 								    <td nowrap width="15%" align="right"><%=occ.getNumeroDocumento()%></td>
	 								    <td nowrap width="15%" align="right"><%=occ.getNossoNumero().toString()%></td>
	 								    <td nowrap width="10%" align="center"><%=occ.getDataVencimentoFormatada()%></td>
	 								    <td nowrap width="20%" align="left"><%=occ.getNomeSacado()%></td>
	 								    <td nowrap width="10%" align="right"><%=occ.getCpfCnpjSacadoFormatado()%></td>
	 								    <td nowrap width="20%" align="left"><%=occ.getNomeSacadorAvalista()%></td>
									  </tr>
							   <%		} %>
	                <tr> 
	                  <td colspan="8">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="8" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=BorderoEstrategia.PAGE_TITULO_MANTER_LISTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="8">&nbsp;</td>
	                </tr>

	                <tr>
	                  <td align="right" colspan="8">
	                    <p align="center"> 
		   				  				<s:Button name="Incluir" action="javascript:formSubmit_Incluir();"/>
	                      <s:Button name="Alterar" action="javascript:formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.alterar"/>
	                      <s:Button name="Consultar" action="javascript:formSubmit_Consultar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.consultar"/>
	                      <s:Button name="Excluir" action="javascript:formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.excluir"/>
	                      <s:Button name="Voltar" action="javascript:formSubmit_Voltar();"/>
	                    </p>
	                  </td>
	                </tr>
 	                <tr> 
	                  <td colspan="8">&nbsp;</td>
	                </tr>
							   <%	}
							   		else{%>
				   			  <tr>
				   			  	<td class="textoDestaqueTitulo" align="center" colspan="2">Não existem Títulos neste Borderô.</td>
				   			  </tr>
 	                <tr> 
	                  <td colspan="8">&nbsp;</td>
	                </tr>
				   			  </tr>
										<td align="right" colspan="8">
		                	<p align="center"> 
		 				  					<s:Button name="Incluir" action="javascript:formSubmit_Incluir();"/>
    	                	<s:Button name="Voltar" action="javascript:formSubmit_Voltar();"/>
											</p>
				   			    </td>
				   			  </tr>
							   	<%	}  
									 %>	  

	              </table>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    </form>
    <script language="javascript">
	    function inicia(){

	    }
	    function formSubmit_Alterar() {
	        if (validaSubmit()) {
		    		if (document.frmMain.situacao.value == 2){	        
	  	      	if (confirm(conf("138"))) {
    		        document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_ALTERAR%>";		    		
	      	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';
	      	      document.frmMain.submit();
	          	}
	          }
	          else{
	            document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_ALTERAR%>";		    		
      	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';
	      	    document.frmMain.submit();
	          }
	       }
      }
	    function formSubmit_Consultar() {
        if (validaSubmit()) {
 	        document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_CONSULTAR%>";		    		
   	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';
	        document.frmMain.submit();
        }
	    }
	    function formSubmit_Excluir() {
	        if (validaSubmit()) {
		    		if (document.frmMain.situacao.value == 2){	        
		 		   		if (confirm(conf("140"))) {
	   	  	      document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_EXCLUIR%>";		    		
	      	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';
		      	    document.frmMain.submit();
		        	}
		        }
		        else{
				    	if (confirm(conf("102", "Título"))) {
			          document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_EXCLUIR%>";
		     	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';
			      	  document.frmMain.submit();
			      	}
		        }
	        }
	    }
	    function formSubmit_Incluir() {
	    <%if (borderoTituloBean.getTotalTitulos().equals(borderoTituloBean.getTitulosIncluidos())){%>
				msg('032');

    	<%}
    	else{%>
    		if (document.frmMain.situacao.value == 2){
	       	if (confirm(conf("138"))) {
 		        document.frmMain.estrategia.value = '<%=TituloEstrategia.STRATEGY_INCLUIR%>';
     	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';
    	     	document.frmMain.submit();
        	}
        }
        else{
	        document.frmMain.estrategia.value = '<%=TituloEstrategia.STRATEGY_INCLUIR%>';
   	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';
   	     	document.frmMain.submit();
        }
			<%}%>
	    }
	    function formSubmit_AlterarBordero() {
	        document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_ALTERAR%>';
	    		if (document.frmMain.situacao.value == 2){
	        	if (confirm(conf("138"))) {	
      	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';
  		        document.frmMain.submit();
  	  	    }
  	  	  }
  	  	  else{
      	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';
  	  	      document.frmMain.submit();
  	  	  }
	    }
	    function formSubmit_ConsultarBordero() {
        document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_CONSULTAR%>';
 	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';
        document.frmMain.submit();
	    }
	    function formSubmit_ExcluirBordero() {
	    		if (document.frmMain.situacao.value == 1){
	    			if (confirm(conf("102", "Borderô"))) {	
		    			document.frmMain.estrategia.value = "servico.BorderoExcluirFinalizar";
      	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';		    			
            	document.frmMain.submit();
            }
	    		}
	    		else if (document.frmMain.situacao.value == 2){
	    			if (confirm(conf("137", "Borderô"))) {	
		    			document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_EXCLUIR%>';
      	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';		    			
            	document.frmMain.submit();
            }
	    		}
	    }
	    function formSubmit_ImprimirBordero() {
	    		if (document.frmMain.situacao.value == 1){	
							msg("016");
					}
					else{
						retorno = window.open("<%=Paths.getRootForDynamicContent()%>/jump/bordero_jump.jsp","relatorio<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "width=780,height=540,top=0,left=0,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=1");
						retorno.focus();
        	}
      }
	    function formSubmit_FinalizarBordero() {
	    		if (document.frmMain.situacao.value == 2){	
						msg("017");
					}
	    	<%if (borderoTituloBean.getTotalTitulos().equals(borderoTituloBean.getTitulosIncluidos())){
	    			if (borderoTituloBean.getValorTotalBordero().toString().equals(borderoTituloBean.getValorTitulosIncluidos().toString())){
	    	%>
					else{	        	
	        	if (confirm(conf("139"))) {	
			       	document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_FINALIZAR%>';
      	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';		    			
	           	document.frmMain.submit();
	         	}
	        }
	     	<%	}
	     			else{
	     	%>   
	    		else{	
						msg("019","","Valor de Títulos","Valor Total");
					}
	     	<%	}
	     		}
	     		else{
	     	%>	    
	    		else{	
						msg("019","","Títulos","Total de Títulos");
					}
	    	<%}%>
	    }
	    function formSubmit_Voltar() {
    		if (document.frmMain.situacao.value == 1){
	    		if (confirm(conf("141"))) {
  	         document.frmMain.estrategia.value = "<%=borderoFiltroBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_LISTA_TITULO)?BorderoEstrategia.STRATEGY_MANTER_FILTRO:BorderoEstrategia.STRATEGY_MANTER_LISTAR%>";
    	       document.frmMain.fluxo.value = "voltar";
      	     document.frmMain.submit();
        	}
        }
        else{
  	      document.frmMain.estrategia.value = "<%=borderoFiltroBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_LISTA_TITULO)?BorderoEstrategia.STRATEGY_MANTER_FILTRO:BorderoEstrategia.STRATEGY_MANTER_LISTAR%>";
	 	      document.frmMain.fluxo.value = "voltar";
    	    document.frmMain.submit();
        }
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
	    	function clickRadio(registro) {
					document.frmMain.registro.value = registro;
				}		  	
		  	
    </script>

  </s:FormStrategy>
</p:Document>
</html>