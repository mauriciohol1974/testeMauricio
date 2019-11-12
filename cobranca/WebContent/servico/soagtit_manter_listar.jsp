<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: soagtit_manter_listar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 20/10/2005
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.SolicitacaoAgendamentoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.SolicitacaoAgendamentoEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(SolicitacaoAgendamentoEstrategia.PAGINACAO_LIST);
	if(request.getParameter(SolicitacaoAgendamentoEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(SolicitacaoAgendamentoEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(SolicitacaoAgendamentoEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(SolicitacaoAgendamentoEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SolicitacaoAgendamentoEstrategia.USUARIOLDAP_BEAN);
	SolicitacaoAgendamentoBean solicitacaoBean = (session.getAttribute(SolicitacaoAgendamentoEstrategia.DATA_BEAN)==null?new SolicitacaoAgendamentoBean():(SolicitacaoAgendamentoBean)session.getAttribute(SolicitacaoAgendamentoEstrategia.DATA_BEAN));
	SolicitacaoAgendamentoBean solicitacaoFiltroBean = (session.getAttribute(SolicitacaoAgendamentoEstrategia.FILTRO_BEAN)==null?new SolicitacaoAgendamentoBean():(SolicitacaoAgendamentoBean)session.getAttribute(SolicitacaoAgendamentoEstrategia.FILTRO_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(SolicitacaoAgendamentoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(SolicitacaoAgendamentoEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=SolicitacaoAgendamentoEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=SolicitacaoAgendamentoEstrategia.PAGE_TITLE_MANTER_LISTAR%>"/>    
  	<input type="hidden" name="codigoCedente" value="<%=solicitacaoBean.getCodigoCedente()%>">
  	<input type="hidden" name="codigoBancoSacado" value="<%=solicitacaoBean.getCodigoBancoSacado()%>">
  	<input type="hidden" name="nomeBancoSacado" value="<%=solicitacaoBean.getNomeBancoSacado()%>">
  	<input type="hidden" name="indicadorSolicitacao">
  	<input type="hidden" name="indicadorSolicitacaoAlteracao">
  	<input type="hidden" name="dataSolicitacao">
  	<input type="hidden" name="navegacao" value="<%=solicitacaoBean.getNavegacao()%>">
  	
  	<input type="hidden" name="<%=SolicitacaoAgendamentoEstrategia.PAGINACAO_PAGE%>" value="">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getCodigoCedenteFormatado()%></td>
  
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
                 <td class="textoTitulo" width="17%">Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getCodigoBancoSacado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Nome Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getNomeBancoSacado()%></td> 
  
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Sacados:
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="7%" align="left">Registro</td>
								    <td nowrap width="30%" align="left">Espécie</td>
 								    <td nowrap width="19%" align="right">Valor</td>
								    <td nowrap width="18%" align="left">Solic./Agend.</td>
								    <td nowrap width="15%" align="center">Data/Dias</td>
								    <td nowrap width="15%" align="right">Usuário</td>
								  </tr>
							<%
									SolicitacaoAgendamentoBean occ = new SolicitacaoAgendamentoBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (SolicitacaoAgendamentoBean) lista.get(i);
							%>
									  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									      <input type="radio" name="rdo"
								    		 onclick="javascript: clickRadio(
								    		 <%if(occ.getIndicadorSolicitacao().equals(new Long(600))){%>
								    		 	'6'								    		 
								    		 <%}else if(occ.getIndicadorSolicitacao().equals(new Long(700))){%>
												 	'7'
												 <%}else{%>
								    		 	'<%=occ.getIndicadorSolicitacao()%>'
								    		 <%}%>,'<%=occ.getDataSolicitacaoFormatada()%>','<%=occ.getIndicadorSolicitacao()%>');">
								    	</td>
	 								    <td nowrap width="7%" align="left"><%=occ.getRegistro().equals("S")?"SIM":"NAO"%></td>
	 								    <td nowrap width="30%" align="left"><%=occ.getEspecieTexto()%></td>
	 								    <td nowrap width="19%" align="right"><%=occ.getValorSolicitacao().toString().equals("R$ 0,00")?"":occ.getValorSolicitacao().toString()%></td>	 								    
	 								    <td nowrap width="18%" align="left"><%=occ.getIndicadorSolicitacaoTexto()%></td>
	 								    <td nowrap width="15%" align="center">
	 								    	 <%if(occ.getIndicadorSolicitacao().equals(new Long(600))){%>
								    		 		<%=occ.getDataVencimentoFormatada()%>
								    		 <%}else if(occ.getIndicadorSolicitacao().equals(new Long(700))){%>
												 		<%=occ.getDiaVencimento().toString()%>
												 <%}else if(occ.getIndicadorSolicitacao().equals(new Long(6))){%>
														<%=occ.getDataVencimentoFormatada().equals("01/01/0001")?"":occ.getDataVencimentoFormatada()%>
		    								 <%}else{%>
 												 		<%=occ.getDiaVencimento().equals(new Long(0))?"":occ.getDiaVencimento().toString()%>
							           <%}%>	  	 								    
									   </td>
									   <td width="15%" align="right"><%=occ.getCodigoUsuario()%></td>											
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
											  		pageName="<%=SolicitacaoAgendamentoEstrategia.PAGE_MANTER_LISTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="6">
	                    <p align="center"> 
	                      <s:Button name="Alterar" action="javascript:formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersolic.alterar"/>
	                      <s:Button name="Consultar" action="javascript:formSubmit_Consultar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersolic.consultar"/>
	                      <s:Button name="Excluir" action="javascript:formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersolic.excluir"/>
	                      <s:Button name="Voltar" action="javascript:formSubmit_Voltar();"/>
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
	    }

	  	function formSubmit() {
	    	formSubmit_Alterar();
	    
	    }  
	    

	    function formSubmit_Alterar() {
        if (validaSubmit()) {
	        if(document.frmMain.indicadorSolicitacaoAlteracao.value == '600'){
	        	msg('046','Solicitação de Emissão de Títulos');
	        }
	        else if (document.frmMain.indicadorSolicitacaoAlteracao.value == '700'){
	        	msg('046','Agendamento de Emissão de Títulos');
	        }
	        else{
		        document.frmMain.estrategia.value = "<%=SolicitacaoAgendamentoEstrategia.STRATEGY_ALTERAR_INICIAR%>";
		        document.frmMain.navegacao.value = '<%=SolicitacaoAgendamentoEstrategia.NAVEGACAO_OUTRO%>';
		        document.frmMain.submit();
		      }
 	  	  }
	    }

	    function formSubmit_Consultar() {
        if (validaSubmit()) {
		      document.frmMain.estrategia.value = "<%=SolicitacaoAgendamentoEstrategia.STRATEGY_CONSULTAR%>";
 		      document.frmMain.navegacao.value = '<%=SolicitacaoAgendamentoEstrategia.NAVEGACAO_OUTRO%>';
    	    document.frmMain.submit();
    	  }
	    }
	    
	    function formSubmit_Excluir() {
        if (validaSubmit()) {
	        if(document.frmMain.indicadorSolicitacaoAlteracao.value == '600'){
	        	msg('061','Solicitação de Emissão de Títulos');
	        }
	        else if (document.frmMain.indicadorSolicitacaoAlteracao.value == '700'){
	        	msg('061','Agendamento de Emissão de Títulos');
	        }
	        else{    			
	    			if(document.frmMain.indicadorSolicitacao.value == 6){
	    				if (confirm(conf("145", "Solicitação de Emissão de Títulos"))) {	
			   				document.frmMain.estrategia.value = "<%=SolicitacaoAgendamentoEstrategia.STRATEGY_EXCLUIR%>";
	           		document.frmMain.submit();
	          	}   
	          }
	    			else if(document.frmMain.indicadorSolicitacao.value == 7){
	    				if (confirm(conf("102", "Agendamento de Emissão de Títulos"))) {	
	       				document.frmMain.estrategia.value = "<%=SolicitacaoAgendamentoEstrategia.STRATEGY_EXCLUIR%>";
	           		document.frmMain.submit();
	          	}   
	          }
	        }
    		}
	    }
	    
	    
	    function formSubmit_Voltar() {
				document.frmMain.estrategia.value = "<%=solicitacaoFiltroBean.getNavegacao().equals(SolicitacaoAgendamentoEstrategia.NAVEGACAO_LISTA_2)?SolicitacaoAgendamentoEstrategia.STRATEGY_MANTER_INICIAR:SolicitacaoAgendamentoEstrategia.STRATEGY_MANTER_FILTRO%>";           
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
	    
	    function clickRadio(indicadorSolicitacao, dataSolicitacao, indicadorSolicitacaoAlteracao) {
				document.frmMain.indicadorSolicitacao.value = indicadorSolicitacao;
				document.frmMain.dataSolicitacao.value = dataSolicitacao;
				document.frmMain.indicadorSolicitacaoAlteracao.value = indicadorSolicitacaoAlteracao;
      }
		</script>
  </s:FormStrategy>
</p:Document>
</html>
