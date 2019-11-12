<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteTarifasBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	CedenteTarifasBean tarifasBean = (request.getAttribute(CedenteEstrategia.CEDENTE_TARIFAS_INFORME_BEAN)==null
	                                 ? new CedenteTarifasBean()
	                                 : (CedenteTarifasBean) request.getAttribute(CedenteEstrategia.CEDENTE_TARIFAS_INFORME_BEAN));
	String codigoAgrupamentoServico = "";
	if (tarifasBean.getCodigoAgrupamentoServico() != null) {
		codigoAgrupamentoServico = tarifasBean.getCodigoAgrupamentoServico();
	} else if (request.getParameter("codigoAgrupamentoServico") != null) {
		codigoAgrupamentoServico = request.getParameter("codigoAgrupamentoServico");
	}
	String descricaoAgrupamentoServico = "";
	if (tarifasBean.getDescricaoAgrupamentoServico() != null) {
		descricaoAgrupamentoServico = tarifasBean.getDescricaoAgrupamentoServico();
	} else if (request.getParameter("descricaoAgrupamentoServico") != null) {
		descricaoAgrupamentoServico = request.getParameter("descricaoAgrupamentoServico");
	}
%>


<%
	// CONTROLE DE PAGINACAO

	PageHolder paginacao = (PageHolder) session.getAttribute(CedenteEstrategia.PAGINACAO_LIST);
	int paginaAtual = 0;
	if (request.getParameter(CedenteEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(CedenteEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(CedenteEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(CedenteEstrategia.PAGINACAO_PAGE));
	}
	
	List lista = paginacao.getPage(paginaAtual);
%>

<html>
<s:HeaderPopup/>
<p:Document>

	<!-- ************************ PAGINA INFORME TARIFAS *************************** -->

	<s:FormStrategy name="frmMain" action="SigcbControle"	estrategia="" fluxo="normal">

<%
	String tituloPagina = "Informe de Tarifas: Grupo " + codigoAgrupamentoServico + " - " + descricaoAgrupamentoServico;
%>
		<s:Titulo name="<%=tituloPagina%>"/>
		
		<input type="hidden" name="<%=CedenteEstrategia.PAGINACAO_PAGE%>" value="">		
		<input type="hidden" name= "<%=CedenteEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">

		<input type="hidden" name="codigoAgrupamentoServico" value="<%=codigoAgrupamentoServico%>">
		<input type="hidden" name="descricaoAgrupamentoServico" value="<%=descricaoAgrupamentoServico%>">

    <table width="590" border="0" cellspacing="0" cellpadding="0" align="center">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
          	<tr>
          		<td colspan="2">
								<table class="box" width="100%" border="0" cellspacing="3" cellpadding="0" height=53 valign="middle" align="center">
									<tr class="headerLista">
			          		<td align="center" class="textoDestaqueTitulo" width="4%">&nbsp;</td>
			              <td align="left" class="textoDestaqueTitulo" width="25%" colspan="2">Serviço</td>
			              <td align="right" class="textoDestaqueTitulo" width="15%">Valor Orig.</td>
			              <td align="left" class="textoDestaqueTitulo" width="15%">Perc. Orig.</td>
			              <td align="right" class="textoDestaqueTitulo" width="15%">Valor Calc.</td>
			              <td align="left" class="textoDestaqueTitulo" width="15%">Perc. Calc.</td>
			            </tr>
			            
<%
		CedenteTarifasBean occ = new CedenteTarifasBean();
		for ( int i = 0; i < lista.size(); i++ ) {	
			occ = (CedenteTarifasBean) lista.get(i);
%>
			            <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
			            	<td class="textoValor" width="4%" align="center">
			            		<%=occ.getCodigoServico()%>.
			            	</td>
			              <td class="textoValor" width="25%" colspan="2">
			              	<%=occ.getDescricaoServico()%>
			              </td>
			              <td class="textoValor" width="15%" align="right">
			              	<%=occ.getValorOriginal()%>&nbsp;&nbsp;
			              </td>
			              <td class="textoValor" width="15%">
			              	<%=occ.getPercentualOriginal()%>
			              </td>
			              <td class="textoValor" width="15%" align="right">
			              	<%=occ.getValorCalculado()%>&nbsp;&nbsp;
			              </td>
			              <td class="textoValor" width="15%">
			              	<%=occ.getPercentualCalculado()%>
			              </td>
			            </tr>
<%
	}
%>			            
									<tr>
                    <td colspan="6">&nbsp;</td>
                  </tr>
									<tr>
										<td colspan="6" align="center">
											<% String pageName = CedenteEstrategia.PAGE_CONSULTAR_INFORME_TARIFAS; %>
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
                  <s:Button name="Fechar" action="javascript:window.close();" />
                </p>
              </td>
            </tr>
          </table>
        </TD>
      </tr>
    </table>
    
	<!-- ************************ FIM PAGINA INFORME TARIFAS ************************ -->
		</s:FormStrategy>

		<script>
			function inicia() {
			}
		</script>

  </p:Document>
</html>
