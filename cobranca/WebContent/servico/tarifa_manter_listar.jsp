<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: tarifa_manter_listar.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 29/08/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TarifaManualBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TarifaEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");
	TarifaManualBean filtroBean = (session.getAttribute(TarifaEstrategia.FILTRO_BEAN)==null?new TarifaManualBean():(TarifaManualBean)session.getAttribute(TarifaEstrategia.FILTRO_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(TarifaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TarifaEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(TarifaEstrategia.PAGINACAO_LIST);
	if(request.getParameter(TarifaEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(TarifaEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(TarifaEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(TarifaEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TarifaEstrategia.STRATEGY_CONSULTAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TarifaEstrategia.PAGE_TITLE_MANTER_LISTAR%>"/>
		
		<input type="hidden" name = "codigoCedente" value="<%=filtroBean.getCodigoCedente()%>">
		<input type="hidden" name = "<%=TarifaEstrategia.PAGINACAO_PAGE%>" value="">
		<input type="hidden" name = "registro" value="0">
		<input type="hidden" name = "caller" value="lista">
		
		<input type="hidden" name = "tipoTarifa" value="<%=filtroBean.getTipoTarifa().toString()%>">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=filtroBean.getCodigoCedenteFormatado()%></td>
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
              <td class="textoTitulo" width="17%">Serviço:</td>
              <td class="textoValor" width="26%"><%=filtroBean.getDescricaoTarifa()%></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Listar Tarifa Comandada:
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="center">Data Solicitação</td>
								    <td nowrap width="10%" align="left">Usuário</td>
 								    <td nowrap width="25%" align="right">Valor Tarifa</td>
								    <td nowrap width="20%" align="center">Data Débito Tarifa</td>
								  </tr>
								  
							<%
									TarifaManualBean occ = new TarifaManualBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (TarifaManualBean) lista.get(i);
							%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="2%" align="center">
								    	<input type="radio" name="rdo"
								    		onclick="javascript: clickRadio('<%=occ.getRegistro()%>');">
								    </td>
										<td width="20%" align="center"><%= occ.getDataSolicitacaoFormatada() %></td>
										<td width="10%" align="left"><%= occ.getCodigoUsuario() %></td>
										<td width="25%" align="right"><%= occ.getValorTarifa() %></td>
										<td width="20%" align="center"><%= occ.getDataDebitoFormatada() %></td>
									</tr>
							<%  } %>
 	                <tr> 
	                  <td colspan="5">&nbsp;</td>
	                </tr>

									<tr>
										<td colspan="5" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=TarifaEstrategia.PAGE_MANTER_LISTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="5">&nbsp;</td>
	                </tr>

	                <tr>
	                  <td align="right" colspan="5">
	                    <p align="center"> 
	                    	<s:Button name="Consultar" action="javascript: formSubmit_Consultar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.tarifamanual.manter.consultar" />
	                    	<s:Button name="Excluir" action="javascript: formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.tarifamanual.manter.excluir" />
	                    	<s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
	                    </p>
	                  </td>
	                </tr>
 	                <tr> 
	                  <td colspan="5">&nbsp;</td>
	                </tr>
	                
	              </table>
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
			function formSubmit_Consultar() {
				formSubmit();
			}
	    function formSubmit() { // Acao default consultar
        if (validaSubmit()) {
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
			function formSubmit_Excluir() {
        if (validaSubmit()) {
	    		if (confirm(conf("102", "Lançamento de Tarifa Comandada"))) {
	    			document.frmMain.estrategia.value = "<%=TarifaEstrategia.STRATEGY_EXCLUIR%>";
	          document.frmMain.submit();
         	}
	      }
			}
			function formSubmit_Voltar() {
        document.frmMain.estrategia.value = "<%=TarifaEstrategia.STRATEGY_MANTER_FILTRO%>";
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
      }
      function clickRadio(registro) {
				document.frmMain.registro.value = registro;
      }
    </script>
  </s:FormStrategy>
</p:Document>
</html>