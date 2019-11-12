<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: vallanc_consultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 04/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ConGerValLancadosBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ValLancManterEstrategia" %>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	ConGerValLancadosBean valLancBean = (session.getAttribute(ValLancManterEstrategia.DATA_BEAN)==null? new ConGerValLancadosBean()
																				:(ConGerValLancadosBean)session.getAttribute(ValLancManterEstrategia.DATA_BEAN));
	
	CedenteCabecaBean cedCabBean = 	(session.getAttribute(ValLancManterEstrategia.CABECALHO_BEAN)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(ValLancManterEstrategia.CABECALHO_BEAN));
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ValLancManterEstrategia.PAGINACAO_LIST);
	
	if(request.getParameter(ValLancManterEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ValLancManterEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ValLancManterEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ValLancManterEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>


<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.ValLancConsultarDetIniciar" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Lançamentos em Conta Corrente"/>

 		<input type="hidden" name="<%=ValLancManterEstrategia.PAGINACAO_PAGE%>" value="">

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
              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
              <td class="textoTitulo" width="17%">Conta: </td>
              <td class="textoValor" width="26%"><%=valLancBean.getContaFormatado()%></td>
						</tr>
            <tr>
              <td class="textoTitulo" width="17%">Unidade: </td>
		          <td class="textoValor" width="26%"><%=valLancBean.getUnidadeVinculacaoFormatado()%></td>
              <td class="textoTitulo" width="17%">operacao: </td>
              <td class="textoValor" width="26%"><%=valLancBean.getOperacaoFormatado()%></td>
            </tr>

           <tr> 
              <td colspan="4">&nbsp;</td>
           </tr>
           <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Valores Lançados:
                <hr>
              </td>
            </tr>

						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="10%" align="left">Data</td>
								    <td nowrap width="10%" align="left">Valor Crédito</td>
								    <td nowrap width="10%" align="left">Valor Débito</td>
								  </tr>
						  <%
									ConGerValLancadosBean occ = new ConGerValLancadosBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ConGerValLancadosBean) lista.get(i);
							%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="2%" align="center">&nbsp;</td>
 								    <td width="10%" align="left"><%=occ.getDataLancamentoFormatada()%></td>
								    <td width="10%" align="left"><%=occ.getValorCredito()%></td>
								    <td width="10%" align="left"><%=occ.getValorDebito()%></td>
								  </tr>
							<% } %>
 	                <tr> 
	                  <td colspan="4">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="4" align="center">
										  <s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=ValLancManterEstrategia.PAGE_CONSULTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="4">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="4">
	                    <p align="center"> 
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
	    function formSubmit_Voltar() {
        document.frmMain.estrategia.value = "consulta.ValLancManterFiltro";
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
	    }
    </script>
		</s:FormStrategy>
	</p:Document>
</html>