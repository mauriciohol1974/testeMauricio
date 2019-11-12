<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConclusaoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	String justificativa = "";
	if (request.getParameter("justificativa") != null) {
		justificativa = request.getParameter("justificativa");
	}

	String numeroPendenciaVigente = "";
	if (request.getParameter("numeroPendenciaVigente") != null) {
		numeroPendenciaVigente = request.getParameter("numeroPendenciaVigente");
	}

	String numeroReiteracaoVigente = "";
 if (request.getParameter("numeroReiteracaoVigente") != null) {
		numeroReiteracaoVigente = request.getParameter("numeroReiteracaoVigente");
	}
%>

<%
	// CONTROLE DE PAGINACAO
	
	PageHolder paginacao = (PageHolder) session.getAttribute(CedenteEstrategia.PAGINACAO_EXCVIG_LIST);

	// usado para salvar os dados digitados pelo usuario na pagina anterior
	int paginaAnterior = 0;
	if (request.getParameter(CedenteEstrategia.PAGINACAO_PAGEANTERIOR) != null && !request.getParameter(CedenteEstrategia.PAGINACAO_PAGEANTERIOR).equals("")){
		paginaAnterior = Integer.parseInt((String)request.getParameter(CedenteEstrategia.PAGINACAO_PAGEANTERIOR));
	} else {
		paginaAnterior = Integer.parseInt((String)request.getAttribute(CedenteEstrategia.PAGINACAO_PAGEANTERIOR));
	}
	List listaAnterior = paginacao.getPage(paginaAnterior);

	String[] itensAgregar = request.getParameterValues("checkAgregarExcecao");

	// if para nao ser chamado na primeira vez que entrar na pagina
	if (request.getParameter("acao") != null) {
		// resetando status da pagina anterior
		for (int i = 0; i < listaAnterior.size(); i++) {
			CedenteConclusaoBean bean = (CedenteConclusaoBean) listaAnterior.get(i);
			bean.setAgregado(false);
		}
	}

	if (itensAgregar != null) {
	    for (int i = 0; i < itensAgregar.length; i++) {
	        CedenteConclusaoBean bean = (CedenteConclusaoBean) listaAnterior.get( Integer.parseInt(itensAgregar[i]) );
	        bean.setAgregado(true);
	    }
	}

	int paginaAtual = 0;

	if (request.getParameter(CedenteEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(CedenteEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(CedenteEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(CedenteEstrategia.PAGINACAO_PAGE));
	}
	
	List lista = paginacao.getPage(paginaAtual);
	
	session.setAttribute(CedenteEstrategia.PAGINACAO_EXCVIG_LIST, paginacao);
%>


<html>
<s:HeaderPopup/>


  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteAlterarExcepAntFinalizar" fluxo="normal">

		<input type="hidden" name="<%=CedenteEstrategia.PAGINACAO_PAGE%>" value="<%= paginaAtual %>">
		<input type="hidden" name= "<%=CedenteEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">
		<input type="hidden" name="numeroPendenciaVigente" value="<%= numeroPendenciaVigente %>">
		<input type="hidden" name="numeroReiteracaoVigente" value="<%= numeroReiteracaoVigente %>">
		<input type="hidden" name="justificativa" value="<%= justificativa %>">
		<input type="hidden" name="acao">

		<table width="470" border="0" cellpadding="0" cellspacing="0">
      <tr> 
        <td>&nbsp;</td>
      </tr>
			<tr height="65">
				<td valign="top" align="left" style="background-repeat:no-repeat"
				    background="<%=Paths.getImagePath()%>/baseTitulo.gif"><h3>Excepcionação Vigente</h3>
				</td>
		  </tr>
		</table>

    <table width="470" border="0" cellspacing="0" cellpadding="0" align="center">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="3" cellpadding="0" height="53" valign="middle" align="center">
          	<tr>
          		<td colspan="2">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">

									<tr>
										<td class="textoDestaqueValor" colspan="5" align="center">
											Itens a agregar a nova excepcionação.
										</td>
									</tr>
			            <tr> 
			              <td colspan="5">&nbsp;</td>
			            </tr>
								
			            <tr class="headerLista">
										<td width="5%"  align="center">&nbsp;</td>
			              <td width="50%" align="left">Item</td>
			              <td width="15%" align="center" nowrap>Vlr. Orig.</td>
			              <td width="15%" align="center" nowrap>Vlr. Excep.</td>
			              <td width="15%" align="center">Perc.</td>
									</tr>
									
<%
		CedenteConclusaoBean occ = new CedenteConclusaoBean();
		for ( int i = 0; i < lista.size(); i++ ) {	
			occ = (CedenteConclusaoBean) lista.get(i);
			String checked = occ.isAgregado() ? "checked" : "" ;
%>                  
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
										<td width="5%"  align="center">
											<input type="checkbox" name="checkAgregarExcecao" value="<%= i %>" <%= checked %> >
										</td>
										<td width="50%" align="left" nowrap><%=occ.getDescricaoItem()%></td>
										<td width="15%" align="center" nowrap><%=occ.getAtributoOriginal()%></td>
										<td width="15%" align="center" nowrap><%=occ.getAtributoExcepcionado()%></td>
										<td width="15%" align="center" nowrap><%=occ.getAtributoPercentual()%></td>
									</tr>
<%
		}
%>		                  
			            <tr> 
			              <td colspan="5">&nbsp;</td>
			            </tr>
									<tr>
										<td colspan="5" align="center">
											<% String pageName = CedenteEstrategia.PAGE_ALTERAR_EXCEPANTERIOR;%>
											<s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=pageName%>"/>
										</td>
									</tr>
			          </table>
			        </td>
			      </tr>            
            
            <tr> 
              <td colspan="2">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="2">
                <p align="center"> 
                  <input type="button" class="button" value="Agregar Exceções" 
                         onclick="javascript:formSubmit();">
                  <input type="button" class="button" value="Cancelar Agregação" 
                         onclick="javascript:formSubmit_Cancelar();">
                </p>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>

		<script>
			function inicia() {
			}
			
			function formSubmit() {
				document.frmMain.acao.value = "agregar";
				document.frmMain.target = opener.name;
				document.frmMain.submit();
				window.close();
			}
			
			function formSubmit_Cancelar() {
				document.frmMain.acao.value = "cancelar";
				document.frmMain.target = opener.name;
				document.frmMain.submit();
				window.close();
			}
		</script>

   	</s:FormStrategy>
  </p:Document>
</html>
