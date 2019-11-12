<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: cliint_incluir_listar_cpfcnpj.jsp - Java Server Pages
*Autor: JE, GMG
*Ultima Atualização: 14/12/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ClienteInternetBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConteudoListaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CliInteEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="java.util.List"%>
<%
	ClienteInternetBean clienteInternetBean = (session.getAttribute(CliInteEstrategia.FILTRO_BEAN)==null?new ClienteInternetBean():(ClienteInternetBean)session.getAttribute(CliInteEstrategia.FILTRO_BEAN));

	PageHolder paginacao = (PageHolder) session.getAttribute(CliInteEstrategia.PAGINACAO_LIST);

	int paginaAnterior = 0;
	if(request.getParameter(CliInteEstrategia.PAGINACAO_PAGEANTERIOR) != null && 
	   !request.getParameter(CliInteEstrategia.PAGINACAO_PAGEANTERIOR).equals("")){
		paginaAnterior = Integer.parseInt((String)request.getParameter(CliInteEstrategia.PAGINACAO_PAGEANTERIOR));
	} else {
		paginaAnterior = Integer.parseInt((String)request.getAttribute(CliInteEstrategia.PAGINACAO_PAGEANTERIOR));
	}
	List listaAnterior = paginacao.getPage(paginaAnterior);
 
	String[] cedentes = null;
	if(request.getParameterValues("cedentes") != null && !request.getParameterValues("cedentes").equals("")){
		cedentes = (String[])request.getParameterValues("cedentes");
	}
	ClienteInternetBean occX = new ClienteInternetBean();
	for ( int j = 0; j < listaAnterior.size(); j++ ) {
		occX = (ClienteInternetBean) listaAnterior.get(j);
		occX.setCedenteChecked(" ");
		if (cedentes != null) {
			for (int i=1; i < cedentes.length; i++) {
				if (occX.getCodigoCedente().toString().equals(cedentes[i])) {
					occX.setCedenteChecked("1");
				}
			}
		}
	}
	
	int paginaAtual = 0;
	if(request.getParameter(CliInteEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(CliInteEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(CliInteEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(CliInteEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>
<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=CliInteEstrategia.STRATEGY_INCLUIR_RS_CED_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=CliInteEstrategia.PAGE_TITLE_INCLUIR_LISTAR%>"/>
		<!--dados para o filtro -->
	  <input type="hidden" name = "tipoPesquisa" value='1'>
	  <input type="hidden" name = "cpfUsuario" value="<%=clienteInternetBean.getCpfUsuario()%>">
		<input type="hidden" name = "codigoCedente" value=''>
		<input type="hidden" name = "tipoPessoaCedente" value='<%=clienteInternetBean.getTipoPessoaCedente().toString()%>'>
		<input type="hidden" name = "cpfCnpjCedente" value='<%=clienteInternetBean.getCpfCnpjCedente().toString()%>'>
		<input type="hidden" name = "cedentes" value=''>
		
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
              <td class="textoTitulo" width="17%">CPF Usuário:</td>
              <td class="textoValor" colspan="3"><%=Formatador.formatarCpf(clienteInternetBean.getCpfUsuario()+"")%></td> 
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
										<td nowrap width="3%" align="center">&nbsp;</td>
			 							<td nowrap width="9%" align="right">Cedente</td>
			 							<td nowrap width="88%" align="left">Nome</td>
									</tr>
									<%
									ClienteInternetBean occ = new ClienteInternetBean();
									for ( int i = 0; i < lista.size(); i++ ) {
										occ = (ClienteInternetBean) lista.get(i);
									%>
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="3%" align="center">
									    	<input type="checkbox" name="cedentes" value="<%=occ.getCodigoCedente()%>" <%=occ.getCedenteChecked()==null?"":occ.getCedenteChecked().equals("1")?"checked":""%>>
									    </td>
			 						    <td width="9%" align="right"><%=occ.getCodigoCedenteFormatado()%></td>
									    <td width="88%" align="left"><%=occ.getNome()%></td>
									  </tr>
									<%}%>
								</table>
							</td>
						</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
						<tr>
							<td colspan="4" align="center">
							  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=Paths.getRootForDynamicContent() + CliInteEstrategia.PAGE_INCLUIR_LISTAR%>"/>
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
      </tr>
    </table>
    <script>
		function inicia() {
			setFirstFieldFocus();
		}
	
    function formSubmit() { 
    	if (validaSubmit()) {
    		if (confirm(conf("159"))) {
					document.frmMain.submit();
				}
			}
		}
		
		function validaSubmit() {
	    return true;
		}
	
		function formSubmit_Voltar() {
        document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_INCLUIR_INICIAR%>";
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
    }
    
    </script>
  </s:FormStrategy>
</p:Document>
</html>