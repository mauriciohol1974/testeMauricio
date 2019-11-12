<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: cliint_manter_listar_cpfcnpj.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 17/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ClienteInternetBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CliInteEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="java.util.List"%>
<%
	ClienteInternetBean clienteInternetBean = (session.getAttribute(CliInteEstrategia.FILTRO_BEAN)==null?new ClienteInternetBean():(ClienteInternetBean)session.getAttribute(CliInteEstrategia.FILTRO_BEAN));

	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(CliInteEstrategia.PAGINACAO_LIST);
	if(request.getParameter(CliInteEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(CliInteEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(CliInteEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(CliInteEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
	String tmp = "";
%>
<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=CliInteEstrategia.STRATEGY_ALTERAR_USU_INICIAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=CliInteEstrategia.PAGE_TITLE_MANTER_FILTRO_CPFCNPJ%>"/>
		<!--dados para o filtro -->
	    <input type="hidden" name = "tipoPesquisa" value='2'>
	    <input type="hidden" name = "cpfUsuario" value=''>
	    <input type="hidden" name = "nomeUsuario" value=''>
		<input type="hidden" name = "codigoCedente" value=''>

		<input type="hidden" name = "<%=CliInteEstrategia.PAGINACAO_PAGE%>" value="">
		<input type="hidden" name = "<%=CliInteEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 align="center">
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa:</td>
              <td class="textoValor" width="26%"><%=clienteInternetBean.getTipoPessoaCedente().longValue()==1? "FÍSICA": "JURIDICA"%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ:</td>
              <td class="textoValor" width="26%"><%=Formatador.formatarCpfCnpj(clienteInternetBean.getCpfCnpjCedente().toString())%></td>
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
					<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center">
						<tr class="headerLista">
							<td nowrap width="2%" align="center">&nbsp;</td>
 							<td nowrap width="10%" align="right">Cedente</td>
 							<td nowrap width="35%" align="left">Nome</td>
 							<td nowrap width="15%" align="left">CPF Usuário</td>
 							<td nowrap width="33%" align="left">Nome Usuário</td> 							
						</tr>           
						<%
						ClienteInternetBean occ = new ClienteInternetBean();
						for ( int i = 0; i < lista.size(); i++ ) {	
							occ = (ClienteInternetBean) lista.get(i);
						%>								  
						  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
						    <td width="2%" align="center">
						    	<input type="radio" name="rdo" onclick="javascript: clickRadio('<%=occ.getCodigoCedente()%>','<%=occ.getCpfUsuario()%>','<%=occ.getNomeUsuario()%>');">
						    </td>
 						    <td width="10%" align="right"><%=occ.getCodigoCedenteFormatado()%></td>
						    <td width="35%" align="left"><%=occ.getNome()%></td>
						    <td width="15%" align="left"><%=Formatador.formatarCpf(occ.getCpfUsuario()+"")%></td>
						    <td width="33%" align="left"><%=occ.getNomeUsuario()%></td>
						  </tr>	
						<%  } %>								  						  
					</table>
				</td>
			</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
			<tr>
				<td colspan="4" align="center">
				  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=Paths.getRootForDynamicContent() + CliInteEstrategia.PAGE_MANTER_LISTAR_CPFCNPJ%>"/>
				</td>
			</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center"> 
                	<s:Button name="usuario" value="Alterar Usuário" action="javascript: formSubmit_alterar_usuario();"/>
                	<s:Button name="relacionamento"  value="Alt. Relacionamento" action="javascript: formSubmit_alterar_relacionamento();"/>
                	<s:Button name="senha" value="Alterar Senha" action="javascript: formSubmit_alterar_senha();"/>
                	<s:Button name="exc_relacionamento"  value="Exc. Relacionamento" action="javascript: formSubmit_excluir_relacionamento();"/>
                	<s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
                </p>
              </td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    <script>
	function inicia() {
		setFirstFieldFocus();
	}

    function formSubmit_alterar_usuario() { // Acao default alterar
	    document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_ALTERAR_USU_INICIAR%>";	    
		formSubmit();
	}

    function formSubmit_alterar_relacionamento() { // Acao default alterar
	    document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_ALTERAR_REL_INICIAR%>";	
		formSubmit();
	}

    function formSubmit_alterar_senha() { // Acao default alterar
	    document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_ALTERAR_SEN_INICIAR%>";	
		formSubmit();
	}		
	
		function formSubmit_excluir_relacionamento() { //GMG:27.11.2004
			if (validaSubmit()) {
				if (confirm(conf("102", "Cliente Internet"))) {
			    document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_EXCLUIR_REL_FINALIZAR%>";
					formSubmit();
				}
			}
		}
	
    function formSubmit() { // Acao default alterar
    	if (validaSubmit())
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
	
	function formSubmit_Voltar() {
        document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_MANTER_INICIAR%>";
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
    }
      
    function clickRadio(codigoCedente, cpfUsuario, nomeUsuario) {
      	document.frmMain.codigoCedente.value = codigoCedente;
      	document.frmMain.cpfUsuario.value = cpfUsuario;
      	document.frmMain.nomeUsuario.value = nomeUsuario;
    }
    </script>
  </s:FormStrategy>
</p:Document>
</html>