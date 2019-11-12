<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConteudoListaBean"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

 	CedenteConteudoListaBean fixoBean = (session.getAttribute(CedenteEstrategia.MANTER_FIXO_BEAN)==null
 	                                    ? new CedenteConteudoListaBean()
 	                                    : (CedenteConteudoListaBean)session.getAttribute(CedenteEstrategia.MANTER_FIXO_BEAN));
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
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteManterFiltro" fluxo="normal">   	          				
   		<s:Menu/>
   		<s:Titulo name="Manter Cedente (CPF/CNPJ) >> Listar"/>

   		<input type="hidden" name="<%=CedenteEstrategia.PAGINACAO_PAGE%>" value="">
   		<input type="hidden" name="codigoCedente">
   		<input type="hidden" name="situacao">   		
   		<input type="hidden" name="radioTipoConsulta">
			<input type="hidden" name="radioTipoConsultaAnterior" value="<%=CedenteEstrategia.OPCAO_BUSCA_CPFCNPJ%>">
			<input type="hidden" name="cpfCnpj" value="<%=fixoBean.getCpfCnpj()%>">
			<input type="hidden" name="tipoPessoa" value="<%=fixoBean.getTipoPessoa()%>">

	    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">

	            <tr>
	              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
	              <td class="textoValor" width="26%"><%= fixoBean.getTipoPessoaTexto() %></td>
	              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
	              <td class="textoValor" width="26%"><%= fixoBean.getCpfCnpjFormatado() %></td>
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
									    <td width="2%" align="center">&nbsp;</td>
	 								    <td width="10%" align="right">Cedente</td>
	 								    <td width="15%" align="left">Nome Cedente</td>
	 								    <td width="15%" align="left">COCLI</td>
	 								    <td width="20%" align="left">Situação</td>
									  </tr>
									  
<%
	CedenteConteudoListaBean occ = new CedenteConteudoListaBean();
	for ( int i = 0; i < lista.size(); i++ ) {	
		occ = (CedenteConteudoListaBean) lista.get(i);
%>
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									    	<input type="radio" name="radioCedente" onclick="javascript:clickRadio('<%=occ.getCodigoCedente()%>', '<%=occ.getSituacao()%>');">
									    </td>
	 								    <td width="10%" align="right"><%= occ.getCodigoCedenteFormatado() %></td>
	 								    <td width="15%" align="left"><%= occ.getNomeFantasia() %></td>
	 								    <td width="15%" align="left"><%= occ.getCOCLI() %></td>
	 								    <td width="20%" align="left"><%= occ.getSituacaoTexto() %></td>
									  </tr>
<%
	}
%>									  
	 	                <tr> 
		                  <td colspan="5">&nbsp;</td>
		                </tr>
										<tr>
											<td colspan="5" align="center">
											  <% String pageName = CedenteEstrategia.PAGE_MANTER_LISTAR_CPFCNPJ;%>
											  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=pageName%>"/>
											</td>
										</tr>
	 	                <tr> 
		                  <td colspan="5">&nbsp;</td>
		                </tr>
	
		                <tr>
		                  <td align="right" colspan="5">
		                    <p align="center"> 
		                      <s:Button name="Ações" action="javascript:formSubmit_Favoritos();" />
		                      <s:Button name="Alterar" action="javascript:formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.cadastro.manter.alterar" />
		                      <s:Button name="Excluir" action="javascript:formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.cadastro.manter.excluir" />
		                      <s:Button name="Consultar" action="javascript:formSubmit_Consultar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.cadastro.manter.consultar" />
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
		    	formSubmit_Favoritos();
		    }

		    function formSubmit_Favoritos() {
	        if (validaSubmit()) {
	          document.frmMain.radioTipoConsulta.value="<%= CedenteEstrategia.OPCAO_BUSCA_CEDENTE %>";
	        	document.frmMain.estrategia.value="cedente.CedenteManterFiltro";
	          document.frmMain.submit();
	        }
		    }

		    function formSubmit_Alterar() {
	        if (validaSubmit()) {
	        	var confirma = true;
	        	
	        	if (document.frmMain.situacao.value == "I") {
	        		confirma = confirm(conf('124', 'Cedente'));
	        	}
	        	
	        	if (confirma) {
		        	document.frmMain.estrategia.value="cedente.CedenteAlterarIniciar";
		          document.frmMain.submit();
		        }
	        }
		    }

		    function formSubmit_Excluir() {
	        if (validaSubmit()) {
							var confirma = confirm(conf('102', 'Cedente'));

			    		if (confirma) {
			        	document.frmMain.estrategia.value="cedente.CedenteExcluirFinalizar";
			          document.frmMain.submit();
			        }
	        }
		    }

		    function formSubmit_Consultar() {
	        if (validaSubmit()) {
	        	document.frmMain.situacao.disabled = true;
	        	document.frmMain.estrategia.value="cedente.CedenteConsultarIniciar";
	          document.frmMain.submit();
	        }
		    }

		    function formSubmit_Voltar() {
					document.frmMain.estrategia.value = "cedente.CedenteManterFiltro";
	        document.frmMain.fluxo.value = "voltar";				
					document.frmMain.submit();
		    }

		    function validaSubmit(){
					if (document.frmMain.radioCedente[0] != null) {
						if (!validaRadioButtonMsg(document.frmMain.radioCedente, '', "003")) {
							return false;
						}
					} else if (document.frmMain.radioCedente != null) {
						if (!document.frmMain.radioCedente.checked) {
							msg('003', '');
							return false;
						}
					} else {
						return false;
					}
				
			    return true;
		    }
		    
		    function clickRadio( codigo, situacao ) {
		    	document.frmMain.codigoCedente.value = codigo;
		    	document.frmMain.situacao.value = situacao;
		    }
	    </script>

		</s:FormStrategy>
	</p:Document>

</html>