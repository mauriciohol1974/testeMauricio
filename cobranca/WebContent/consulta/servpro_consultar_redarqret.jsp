<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servdia_consultar_redarqret.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 25/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServProEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean "%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	ConGerServicosSolicitadosBean cabeEXBean =(session.getAttribute(ServProEstrategia.BEAN_DATA)==null? new ConGerServicosSolicitadosBean()
																		:(ConGerServicosSolicitadosBean)session.getAttribute(ServProEstrategia.BEAN_DATA));
	
	CedenteCabecaBean cedCabBean = 	(session.getAttribute(ServProEstrategia.BEAN_CABECALHO)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(ServProEstrategia.BEAN_CABECALHO));
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ServProEstrategia.PAGINACAO_LIST);
	
	if(request.getParameter(ServProEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ServProEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ServProEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ServProEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
	
%>
<s:Header/>
  <p:Document>  	
	<%/*EAM 22/08
	  <s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.ServProManterIniciar" fluxo="voltar">*/%>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.ServProManterFiltro" fluxo="voltar">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=ServProEstrategia.PAGE_TITLE%>"/>
 		
 		<input type="hidden" name="<%=ServProEstrategia.PAGINACAO_PAGE%>" value="">
 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedente().equals( new Long(0))?"":cedCabBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
	            <td class="textoTitulo" width="17%" valign="top">Código Cliente (COCLI): </td>
	            <td class="textoValor"  width="26%" valign="top"><%=cedCabBean.getCodigoClienteCOCLI().equals(new Long(0))? "":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
	            <td class="textoTitulo" width="17%" valign="top">Relatório</td>
              <td class="textoValor"  width="26%" valign="top"><%=cabeEXBean.getNomeRelatorio()%></td>
	          </tr>
	          
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Consulta:
                <hr>
              </td>
            </tr>
						
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="2" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="20%" align="right">Num. Retorno</td>
								    <td nowrap width="20%" align="center">Data Movimento</td>
 								    <td nowrap width="10%" align="center">Hora Movimento</td>
 								    <td nowrap width="20%" align="center">Data Processamento</td>
 								    <td nowrap width="10%" align="center">Hora Processamento</td>
 								    <td nowrap width="20%" align="left">Meio de entrada</td>
 								    <td nowrap width="20%" align="right">Usuário</td>
								  </tr>
						  <%
									ConGerServicosSolicitadosBean occ = new ConGerServicosSolicitadosBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ConGerServicosSolicitadosBean) lista.get(i);
							%>

								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
 								    <td nowrap width="20%" align="right"><%=occ.getNumeroRetorno()%></td>
								    <td nowrap width="20%" align="center"><%=occ.getDataMovimentoFormatada()%></td>
 								    <td nowrap width="10%" align="center"><%=occ.getHoraMovimentoFormatada()%></td>
 								    <td nowrap width="20%" align="center"><%=occ.getDataProcessamentoFormatada()%></td>
 								    <td nowrap width="10%" align="center"><%=occ.getHoraProcessamentoFormatada()%></td>
 								    <td nowrap width="20%" align="left"><%=occ.getMeioEntrada()%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getCodigoUsuario()%></td>
								  </tr>
							<%  } %>
									<tr> 
         					 	<td colspan="9">&nbsp;</td>
        					</tr>
									<tr>
										<td colspan="9" align="center">
							  			<s:ButtonPaginar 
							  					pageNumber="<%=paginacao.getPageNumber()%>" 
							  					numberOfPages="<%=paginacao.getPageCount()%>" 
							  					pageName="<%=ServProEstrategia.PAGE_RED_ARQ_RET%>"/>
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
	              	<s:Button name="Voltar" action="javascript:formSubmit()"/> 
								</p>
	            </td>
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
        document.frmMain.submit();
	    }
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
