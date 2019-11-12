<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: arqreme_manter_listar_ced.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 28/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.ArquivoRemessaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.RetornoEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.UtilDatas"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

	ArquivoRemessaBean arqBeanFiltro = (session.getAttribute(RetornoEstrategia.FILTRO_BEAN)==null?new ArquivoRemessaBean():(ArquivoRemessaBean)session.getAttribute(RetornoEstrategia.FILTRO_BEAN));

	ArquivoRemessaBean arqBean = (session.getAttribute(RetornoEstrategia.DATA_BEAN)==null?new ArquivoRemessaBean():(ArquivoRemessaBean)session.getAttribute(RetornoEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(RetornoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(RetornoEstrategia.CEDENTE_CABECALHO_BEAN));
	
	PageHolder paginacao = (PageHolder) session.getAttribute(RetornoEstrategia.PAGINACAO_LIST);

	int paginaAtual = 0;
	if(request.getParameter(RetornoEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(RetornoEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(RetornoEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(RetornoEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
	String tmp="";	
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="" fluxo="normal">
	<s:Menu/>
	<s:Titulo name="<%=RetornoEstrategia.PAGE_TITLE_MANTER_LISTAR%>"/>
	<input type="hidden" name = "codigoCedente" value="<%=arqBean.getCodigoCedente()%>">
	<input type="hidden" name = "dataInicial" value=<%=Formatador.formatarData(arqBean.getDataInicial())%>>
	<input type="hidden" name = "dataFinal" value=<%=Formatador.formatarData(arqBean.getDataFinal())%>>		
	<input type="hidden" name = "opcaoConsulta" value="UNIDADE">	
	<input type="hidden" name = "codigoUnidadePV" value=<%=arqBean.getCodigoUnidadePV()+""%>>
	<input type="hidden" name = "codigoUnidadePV" value=<%=arqBean.getCodigoUnidadeCentral()%>>
	<input type="hidden" name = "escolha" value="">
	<input type="hidden" name = "tipoSolicitacao" value="">
	<input type="hidden" name = "tipoAcao" value="">
	<input type="hidden" name = "tipo" value="">
	<input type="hidden" name = "data" value="">
	<input type="hidden" name = "sit" value="">
	<input type="hidden" name = "consultaUnidade" value="">

 	
	<input type="hidden" name = "<%=RetornoEstrategia.PAGINACAO_PAGE%>" value="">
	<input type="hidden" name = "<%=RetornoEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 align="center">
	        <tr>
  				<td class="textoTitulo" width="17%">Unidade PV:</td>
	            <td class="textoValor" width="26%"><%=arqBean.getCodigoUnidadePVFormatado()%></td>
				<td class="textoTitulo" width="17%">Nome Unidade: </td>
		 		<td class="textoValor" width="26%"><%=arqBean.getNomeUnidadePV()%></td> 
			</tr>
	        <tr>
  				<td class="textoTitulo" width="17%">Cedente: </td>
	            <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
				<td class="textoTitulo" width="17%">Nome: </td>
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
  				<td class="textoTitulo" width="17%">Apelido: </td>
	            <td class="textoValor" width="26%"><%=arqBean.getApelidoCedente()+""%></td>
	        </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Arquivos:
                <hr>
              </td>
            </tr>
            
			<tr>
				<td colspan="4">
					<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center">
						<tr class="headerLista">
					    	
							<td nowrap width="10%" align="center">Data</td>
							<td nowrap width="10%" align="center">Hora</td>
 							
 							<td nowrap width="10%" align="left">Padrão</td>
 							<td nowrap width="10%" align="left">Van</td>
 							
 							<td nowrap width="5%" align="right">Nro Retorno</td>
 							<td nowrap width="5%" align="right">Qtde Reg</td>
 							
						</tr>            
						<%
						ArquivoRemessaBean occ = new ArquivoRemessaBean();
						for ( int i = 0; i < lista.size(); i++ ) {	
						occ = (ArquivoRemessaBean) lista.get(i);
						%>								  
					  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
 						<td width="10%" align="center"><%=occ.getDataArquivo()==null? "": Formatador.formatarData(occ.getDataArquivo())%></td>
			    		<td width="10%" align="center"><%=occ.getHoraArquivo()%></td>
					    
					    <td width="10%" align="left"><%= (occ.getPadrao().longValue()+"").equals("1") ? "CNAB240":(((occ.getPadrao().longValue()+"").equals("2")) ? "CNAB400":"")%></td>
					    <td width="10%" align="center"><%=occ.getDescricaoVAN()%></td>
					    <td width="15%" align="right"><%=occ.getNumRemessaRetorno().longValue()==0 ?  "": occ.getNumRemessaRetorno().toString()%></td>
					    <td width="15%" align="right"><%=occ.getQuantidadeRegistros().longValue()==0 ?  "": occ.getQuantidadeRegistros().toString()%></td>
					    
 					  </tr>	
					<% } %>								  						  
					</table>
				</td>
			</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
			<tr>
				<td colspan="4" align="center">
				  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=Paths.getRootForDynamicContent() + RetornoEstrategia.PAGE_MANTER_LISTAR%>"/>
				</td>
			</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center"> 
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
    function inicia(){
    	
    }
	function formSubmit_Voltar() {
		<%
		String returnPage;
		if (arqBeanFiltro.getCodigoUnidadePV().longValue()>0) {
			returnPage = RetornoEstrategia.STRATEGY_MANTER_FILTRO;
			%>document.frmMain.consultaUnidade.value = "1"; 
			<%
		} else {
			returnPage = RetornoEstrategia.STRATEGY_MANTER_INICIAR;
		}
		%>				
		document.frmMain.estrategia.value = "<%=returnPage%>";
	    document.frmMain.fluxo.value = "voltar";
	    document.frmMain.submit();
	}
    </script>
  </s:FormStrategy>
</p:Document>