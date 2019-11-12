<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: bcosaca_manter_listar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 05/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BancoSacadoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BancoSacadoEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(BancoSacadoEstrategia.PAGINACAO_LIST);
	if(request.getParameter(BancoSacadoEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(BancoSacadoEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(BancoSacadoEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(BancoSacadoEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(BancoSacadoEstrategia.USUARIOLDAP_BEAN);
	BancoSacadoBean bancoSacadoBean = (session.getAttribute(BancoSacadoEstrategia.DATA_BEAN)==null?new BancoSacadoBean():(BancoSacadoBean)session.getAttribute(BancoSacadoEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(BancoSacadoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BancoSacadoEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=BancoSacadoEstrategia.PAGE_TITLE_MANTER_LISTAR%>"/>    
  	<input type="hidden" name="codigoCedente" value="<%=bancoSacadoBean.getCodigoCedente()%>">
  	<input type="hidden" name="codigoBancoSacado" value="">
  	<input type="hidden" name="registro" value="">
  	<input type="hidden" name="<%=BancoSacadoEstrategia.PAGINACAO_PAGE%>" value="">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=bancoSacadoBean.getCodigoCedenteFormatado()%></td>
  
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
  
              <td class="textoTitulo" width="17%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Banco de Sacados:
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="10%" align="right">Número</td>
								    <td nowrap width="88%" align="left">Nome</td>
								  </tr>
							<%
									BancoSacadoBean occ = new BancoSacadoBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (BancoSacadoBean) lista.get(i);
							%>
									  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									      <input type="radio" name="rdo"
								    		 onclick="javascript: clickRadio(<%=occ.getRegistro()%>,<%=occ.getCodigoBancoSacado()%>);">
								    	</td>
	 								    <td width="10%" align="right"><%=occ.getCodigoBancoSacado()%></td>
	 								    <td width="88%" align="left"><%=occ.getNomeBancoSacado()%></td>
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
											  		pageName="<%=BancoSacadoEstrategia.PAGE_MANTER_LISTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="6">
	                    <p align="center"> 
	                      <s:Button name="Alterar" action="javascript:formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.manterbanco.alterar"/>
	                      <s:Button name="Consultar" action="javascript:formSubmit_Consultar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.manterbanco.consultar"/>
	                      <s:Button name="Excluir" action="javascript:formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.manterbanco.excluir"/>
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
	    }  
	    
	    function formSubmit_Alterar() {
        if (validaSubmit()) {
	        document.frmMain.estrategia.value = "<%=BancoSacadoEstrategia.STRATEGY_ALTERAR_INICIAR%>";
	        document.frmMain.submit();
 	  	  }
	    }

	    function formSubmit_Consultar() {
        if (validaSubmit()) {
	        document.frmMain.estrategia.value = "<%=BancoSacadoEstrategia.STRATEGY_CONSULTAR%>";
          document.frmMain.submit();
        }
	    }
	    
	    function formSubmit_Excluir() {
        if (validaSubmit()) {
    			if (confirm(conf("102", "Banco de Sacados (todos os sacados serão removidos)"))) {	
	    			document.frmMain.estrategia.value = "<%=BancoSacadoEstrategia.STRATEGY_EXCLUIR%>";
           	document.frmMain.submit();
          }
    		}
	    }

	    function formSubmit_Voltar() {
           document.frmMain.estrategia.value = "<%=BancoSacadoEstrategia.STRATEGY_MANTER_INICIAR%>";
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
	    
	    function clickRadio(registro, codigoBancoSacado) {
				document.frmMain.registro.value = registro;
				document.frmMain.codigoBancoSacado.value = codigoBancoSacado;
      }
		</script>
  </s:FormStrategy>
</p:Document>
</html>
