<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: bloquet_manter_listar.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 15/10/2004 15:45
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BloquetoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BloquetEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.util.jsp.ComboTipoBloqueto"%>
<%@page import="br.gov.caixa.sigcb.util.jsp.ComboEnvioBloqueto"%>
<%@page import="java.util.List"%>
<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");
	CedenteCabecaBean cedCabBean = (session.getAttribute(BloquetEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BloquetEstrategia.CEDENTE_CABECALHO_BEAN));
	BloquetoBean bloquetoBean = (session.getAttribute(BloquetEstrategia.FILTRO_BEAN)==null?new BloquetoBean():(BloquetoBean)session.getAttribute(BloquetEstrategia.FILTRO_BEAN));

	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(BloquetEstrategia.PAGINACAO_LIST);
	if(request.getParameter(BloquetEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(BloquetEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(BloquetEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(BloquetEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
	String tmp = "";
%>
<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=BloquetEstrategia.STRATEGY_ALTERAR_INICIAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=BloquetEstrategia.PAGE_TITLE_MANTER%>"/>
		<!--dados para o filtro -->
		<input type="hidden" name = "codigoCedente" value="<%=cedCabBean.getCodigoCedente()%>">
		<input type="hidden" name = "dataMovimento" value="<%=Formatador.formatarData(bloquetoBean.getDataMovimento())%>">
		<input type="hidden" name = "tipoBloqueto" value="<%=bloquetoBean.getTipoBloqueto()%>">
		<!-- -->
		<input type="hidden" name = "situacao" value="">
		
		<input type="hidden" name = "<%=BloquetEstrategia.PAGINACAO_PAGE%>" value="">
		<input type="hidden" name = "<%=BloquetEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
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
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals( new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
  						<td colspan="2">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Solicitaçôes de Boleto On-line:
                <hr>
              </td>
            </tr>
						<tr>
							<td colspan="4"> 
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="10%" align="center">Data Movimento</td>
 								    <td nowrap width="20%" align="left">Tipo Boleto</td>
 								    <td nowrap width="10%" align="left">Envio Boleto</td>
 								    <td nowrap width="20%" align="right">Nosso Número</td>
 								    <td nowrap width="10%" align="right">Quantidade</td>
 								    <td nowrap width="10%" align="right">Número Pedido</td>
								    <td nowrap width="10%" align="right">Usuário</td>
								  </tr>           
									<%
									BloquetoBean occ = new BloquetoBean();
									ComboEnvioBloqueto comboEnvioBloqueto = new ComboEnvioBloqueto();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (BloquetoBean) lista.get(i);
										%>								  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									    	<input type="radio" name="rdo"
									    		onclick="javascript: clickRadio('<%=Formatador.formatarData(occ.getDataMovimento())%>','<%=occ.getTipoBloqueto()%>','<%=occ.getSituacaoSolicitacao().longValue()==0 ?  "0": occ.getSituacaoSolicitacao().toString()%>');">
									    </td>
	 								    <td width="10%" align="center"><%=occ.getDataMovimento()== null ? "" : Formatador.formatarData(occ.getDataMovimento())%></td>
									    <td width="20%" align="left"><%=ComboTipoBloqueto.getDescricao(occ.getTipoBloqueto().toString())%></td>
	 								    <td width="10%" align="left"><%=comboEnvioBloqueto.getDescricaoExtrato(occ.getEnvioBloqueto())%></td>
	 								    <td width="20%" align="right"><%=occ.getNossoNumero().longValue()==0 ?  "": occ.getNossoNumeroQuinzeFormatado()%></td>
	 								    <td width="10%" align="right"><%=occ.getQuantidade().longValue()==0 ?  "": occ.getQuantidade().toString()%></td>
	 								    <td width="10%" align="right">
	 								    <%//EAM 01/09/05 - ini%>
	 								    	<%//occ.getNumeroPedido().longValue()==0 ?"" : occ.getNumeroPedido().toString()%>
												<% if (occ.getTipoBloqueto().longValue() == 2){// 2 - PRE-IMPRESSO LASER%>
													<%=occ.getNumeroPedido().longValue()==0 ?"~~~~~~~~~~~~~~": occ.getNumeroPedido().toString()%>
												<%}else{ %>
													<%=occ.getNumeroPedido().longValue()==0 ?"": occ.getNumeroPedido().toString()%>
												<%}%>	
	 								    <%//EAM 01/09/05 - fim%>	 								    	
	 								    </td>
									    <td width="10%" align="right"><%=occ.getCodigoUsuario()%></td>
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
							  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=Paths.getRootForDynamicContent() + BloquetEstrategia.PAGE_MANTER_LISTAR%>"/>
							</td>
						</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center"> 
                	<s:Button name="Alterar" action="javascript: formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bloqueto.manter.alterar" />
                	<s:Button name="Consultar" action="javascript: formSubmit_Consultar();"/>
                	<s:Button name="Excluir" action="javascript: formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bloqueto.manter.excluir" />
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
	function formSubmit_Alterar() {
		if (validaSubmit()) {
			if (document.frmMain.situacao.value == "2"){
				msg('030', '');
				return;					
			}
			document.frmMain.submit();
		}
	}
	
    function formSubmit() { // Acao default alterar
				formSubmit_Alterar();
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

	function formSubmit_Consultar() {
        if (validaSubmit()) {
			document.frmMain.estrategia.value = "<%=BloquetEstrategia.STRATEGY_CONSULTAR_INICIAR%>";
          	document.frmMain.submit();
	    }
	}
					  
	function formSubmit_Excluir() {
        if (validaSubmit()) {
			if (document.frmMain.situacao.value == "2"){
				msg('030', '');
				return;					
			}        
	    	if (confirm(conf("102", "Boleto On-line"))) {
				document.frmMain.estrategia.value = "<%=BloquetEstrategia.STRATEGY_EXCLUIR%>";
	        	document.frmMain.submit();
        	}
		}
	}
			
	function formSubmit_Voltar() {
        document.frmMain.estrategia.value = "<%=BloquetEstrategia.STRATEGY_MANTER_INICIAR%>";
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
    }
      
    function clickRadio(dataMovimento, tipoBloqueto, situacao) {
      	document.frmMain.situacao.value = situacao;
		document.frmMain.dataMovimento.value = dataMovimento;
		document.frmMain.tipoBloqueto.value = tipoBloqueto;
    }
    </script>
  </s:FormStrategy>
</p:Document>
</html>