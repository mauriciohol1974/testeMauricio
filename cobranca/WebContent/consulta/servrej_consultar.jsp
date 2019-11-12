<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servrej_consultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 04/11/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServRejEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean "%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	ConGerServicosSolicitadosBean filtroBean =(session.getAttribute(ServRejEstrategia.BEAN_FILTRO)==null? new ConGerServicosSolicitadosBean()
																		:(ConGerServicosSolicitadosBean)session.getAttribute(ServRejEstrategia.BEAN_FILTRO));
	
	CedenteCabecaBean cedCabBean = 	(session.getAttribute(ServRejEstrategia.BEAN_CABECALHO)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(ServRejEstrategia.BEAN_CABECALHO));
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ServRejEstrategia.PAGINACAO_LIST);
	
	if(request.getParameter(ServRejEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ServRejEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ServRejEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ServRejEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>
	
<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.ServRejManterFiltro" fluxo="voltar">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Serviços Solicitaçoes Rejeitadas"/>
 		
 		<input type="hidden" name="<%=ServRejEstrategia.PAGINACAO_PAGE%>" value="">
 		
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
	            <td class="textoTitulo" width="17%" valign="top">Data da Solicitação:</td>
              <td class="textoValor"  width="26%" valign="top"><%=filtroBean.getDataSolicitacaoFormatada()%></td>
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
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="30%" align="left">Descrição do Serviço</td>
								    <td nowrap width="10%" align="left">Usuário</td>
								    <td nowrap width="60%" align="left">Motivo da Rejeicão:</td>
								  </tr>
							<%
									ConGerServicosSolicitadosBean occ = new ConGerServicosSolicitadosBean();
									for ( int i = 0; i < lista.size(); i++ ) {
									 	occ = (ConGerServicosSolicitadosBean) lista.get(i);
							%>	  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="30%" align="left"><%=occ.getDescServicos()%></td>
 								    <td nowrap width="10%" align="left"><%=occ.getCodigoUsuario()%></td>
								    <td nowrap width="60%" align="left"><%=occ.getMotivoRejeicao()%></td>
								  </tr>
						 <%  }	%>
 	                <tr> 
	                  <td colspan="4">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="4" align="center">
							  			<s:ButtonPaginar 
							  				pageNumber="<%=paginacao.getPageNumber()%>" 
							  				numberOfPages="<%=paginacao.getPageCount()%>" 
							  				pageName="<%=ServRejEstrategia.PAGE_CONSULTAR%>"/>
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
