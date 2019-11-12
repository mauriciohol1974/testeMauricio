<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: sacado_manter_listar_sacado.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 08/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.SacadoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.SacadoEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(SacadoEstrategia.PAGINACAO_LIST);
	if(request.getParameter(SacadoEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(SacadoEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(SacadoEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(SacadoEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SacadoEstrategia.USUARIOLDAP_BEAN);
	SacadoBean sacadoBean = (session.getAttribute(SacadoEstrategia.DATA_BEAN)==null?new SacadoBean():(SacadoBean)session.getAttribute(SacadoEstrategia.DATA_BEAN));
	SacadoBean sacadoFiltroBean = (session.getAttribute(SacadoEstrategia.FILTRO_BEAN)==null?new SacadoBean():(SacadoBean)session.getAttribute(SacadoEstrategia.FILTRO_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(SacadoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(SacadoEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=SacadoEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=SacadoEstrategia.PAGE_TITLE_MANTER_LISTAR%>"/>    
  	<input type="hidden" name="codigoCedente" value="<%=sacadoBean.getCodigoCedente()%>">
  	<input type="hidden" name="codigoBancoSacado" value="<%=sacadoBean.getCodigoBancoSacado()%>">
  	<input type="hidden" name="nomeBancoSacado" value="<%=sacadoBean.getNomeBancoSacado()%>">
  	<input type="hidden" name="tipoPessoaSacado">
  	<input type="hidden" name="cpfCnpjSacado">
  	<input type="hidden" name="codigoSacado">  	
  	<input type="hidden" name="navegacao" value="<%=sacadoBean.getNavegacao()%>">
  	
  	<input type="hidden" name="<%=SacadoEstrategia.PAGINACAO_PAGE%>" value="">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=sacadoBean.getCodigoCedenteFormatado()%></td>
  
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
              <td class="textoValor" width="26%"><%=sacadoBean.getCodigoBancoSacado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Nome Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=sacadoBean.getNomeBancoSacado()%></td> 
  
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
 								    <td nowrap width="15%" align="left">Codigo</td>
								    <td nowrap width="39%" align="left">Nome</td>
 								    <td nowrap width="19%" align="right">CPF/CNPJ</td>
								    <td nowrap width="25%" align="right">Valor/Qtd.</td>
								  </tr>
							<%
									SacadoBean occ = new SacadoBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (SacadoBean) lista.get(i);
							%>
									  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									      <input type="radio" name="rdo"
								    		 onclick="javascript: clickRadio(<%=occ.getTipoPessoaSacado()%>,
                                                         <%=occ.getCpfCnpjSacado()%>,
								    		 																 '<%=occ.getCodigoSacado()%>');">
								    	</td>
	 								    <td width="15%" align="left"><%=occ.getCodigoSacado()%></td>
	 								    <td width="39%" align="left"><%=occ.getNomeSacado()%></td>
	 								    <td width="19%" align="right"><%=occ.getCpfCnpjSacadoFormatado()%></td>	 								    
	 								    <td width="25%" align="right"><%=occ.getValorTitulo()%></td>
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
											  		pageName="<%=SacadoEstrategia.PAGE_MANTER_LISTAR_SAC%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="6">
	                    <p align="center"> 
	                      <s:Button name="Alterar" action="javascript:formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersacado.alterar"/>
	                      <s:Button name="Consultar" action="javascript:formSubmit_Consultar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersacado.consultar"/>
	                      <s:Button name="Excluir" action="javascript:formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersacado.excluir"/>
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
	        document.frmMain.estrategia.value = "<%=SacadoEstrategia.STRATEGY_ALTERAR_INICIAR%>";
 	        document.frmMain.navegacao.value = '<%=SacadoEstrategia.NAVEGACAO_OUTRO%>';	        
	        document.frmMain.submit();
 	  	  }
	    }

	    function formSubmit_Consultar() {
        if (validaSubmit()) {
	        document.frmMain.estrategia.value = "<%=SacadoEstrategia.STRATEGY_CONSULTAR%>";
 	        document.frmMain.navegacao.value = '<%=SacadoEstrategia.NAVEGACAO_OUTRO%>';	             
          document.frmMain.submit();
        }
	    }
	    
	    function formSubmit_Excluir() {
        if (validaSubmit()) {
    			if (confirm(conf("102", "Sacado"))) {	
	    			document.frmMain.estrategia.value = "<%=SacadoEstrategia.STRATEGY_EXCLUIR%>";
 	          document.frmMain.navegacao.value = '<%=SacadoEstrategia.NAVEGACAO_OUTRO%>';	              	
           	document.frmMain.submit();
          }
    		}
	    }
	    
	    
	    function formSubmit_Voltar() {
         	 document.frmMain.estrategia.value = "<%=sacadoFiltroBean.getNavegacao().equals(SacadoEstrategia.NAVEGACAO_FILTRO_NUMERO)?SacadoEstrategia.STRATEGY_MANTER_INICIAR:SacadoEstrategia.STRATEGY_MANTER_FILTRO%>";           
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
	    
	    function clickRadio(tipoPessoaSacado, cpfCnpjSacado, codigoSacado) {
				document.frmMain.tipoPessoaSacado.value = tipoPessoaSacado;
				document.frmMain.cpfCnpjSacado.value = cpfCnpjSacado;
				document.frmMain.codigoSacado.value = codigoSacado;
      }
		</script>
  </s:FormStrategy>
</p:Document>
</html>
