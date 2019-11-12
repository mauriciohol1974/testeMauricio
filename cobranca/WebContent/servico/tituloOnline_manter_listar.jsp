<%
/***********************************************
*Projeto CAIXA - SIGCB
*Autor: Maurício Assis de Holanda
*Data criação: Abril / 2013
************************************************/
%>



<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.LiquidacaoOnlineBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloOnLineEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

	LiquidacaoOnlineBean liquidacaoOnline = (session.getAttribute(TituloOnLineEstrategia.DATA_BEAN)==null
 	                                        ? new LiquidacaoOnlineBean()
 	                                        :(LiquidacaoOnlineBean)session.getAttribute(TituloOnLineEstrategia.DATA_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(TituloOnLineEstrategia.PAGINACAO_LIST);
	if(request.getParameter(TituloOnLineEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(TituloOnLineEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(TituloOnLineEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(TituloOnLineEstrategia.PAGINACAO_PAGE));
	}
	
	List lista = paginacao.getPage(paginaAtual);	
	
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TituloOnLineEstrategia.STRATEGY_MANTER_LISTAR %>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TituloOnLineEstrategia.PAGE_TITLE_MANTER_LISTAR  %>"/>

		<input type="hidden" name="<%=TituloOnLineEstrategia.PAGINACAO_PAGE%>" value="<%= paginaAtual%>" >
		
		<input type="hidden" name="codigoCedente" value="">
		<input type="hidden" name="nossoNumero" value="">
		<input type="hidden" name="dataPagamento" value="">
		<input type="hidden" name="vrPagamento" value="">
		<input type="hidden" name="meioPgto" value="">
		
		<input type="hidden" name="apelidoCedente" value="<%= liquidacaoOnline.getApelidoCedente() %>">
		<input type="hidden" name="codigoUnidadePV" value="<%=liquidacaoOnline.getCodigoUnidadePVFormatado() %>">
		<input type="hidden" name="dataInicial" value="<%= liquidacaoOnline.getDataInicialFormatada()%>">
		<input type="hidden" name="dataFinal" value="<%= liquidacaoOnline.getDataFinalFormatada() %>">
		


    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
				<td valign="top" width="5%" height="14" align="left">&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="10%">Cedente: </td>
              <td class="textoValor" width="26%"><%= liquidacaoOnline.getCodigoCedenteFormatado() %></td>
              
            </tr>
            <tr>
              <td class="textoTitulo" width="10%">Apelido: </td>
              <td class="textoValor" width="26%"><%= liquidacaoOnline.getApelidoCedente() %></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="10%">Unidade PV: </td>
              <td class="textoValor" width="26%"><%=liquidacaoOnline.getCodigoUnidadePVFormatado() %></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="10%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="10%">Data Pagamento Inicial: </td>
              <td class="textoValor" width="26%"><%= liquidacaoOnline.getDataInicialFormatada()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="10%">Data Pagamento Final: </td>
              <td class="textoValor" width="26%"><%= liquidacaoOnline.getDataFinalFormatada() %></td> 
            </tr>
            

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">&nbsp;
                <hr>
              </td>   
            </tr>


            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            </table>
            <table>
						<tr>
							<td colspan="4">
								<table width="777" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <%/*Não Retirar o &nbsp;, pois o mesmo é necessário para manter as colunas na posição
								    	 *correta para o funcionamento do QARun no HMP */ %>
								    	 
								    	 
								    <td nowrap width="2%" align="center">&nbsp;<div style="display:none;"><input  type="radio" name="rdo" onclick="javascript:clickRadio('0','0','0','0');"></div></td>
 								    <td nowrap width="10%" align="center">Cedente</td>
								    <td nowrap width="15%" align="center">Nosso Número</td>
								    <td nowrap width="10%" align="center">Data Pagamento</td>
								    <td nowrap width="15%" align="center">Valor Recebido</td>
 								    <td nowrap width="17%" align="center">Meio de Entrada</td>
								    <td nowrap width="5%" align="center">PV</td>
								    <td nowrap width="5%" align="center">Apelido</td>
								    
								    
								  </tr>

							<%
									LiquidacaoOnlineBean occ = new LiquidacaoOnlineBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (LiquidacaoOnlineBean) lista.get(i);
							%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="2%" align="center">
								    	<input type="radio" name="rdo" onclick="javascript:clickRadio('<%=occ.getCodigoCedente()%>','<%=occ.getNossoNumeroLiq().toString()%>','<%=occ.getDataPagamentolFormatada()%>','<%=occ.getVrPagamento()%>','<%= occ.getCodMeioEntrada()%>');">
								    </td>
 								    <td nowrap align="center"><%= occ.getCodigoCedenteFormatado() %></td>
 								    <td nowrap align="right"><%= occ.getNossoNumeroLiq().toString() %></td>
 								    <td nowrap align="center"><%= occ.getDataPagamentolFormatada() %></td>
 								    <td nowrap align="right"><%= occ.getVrPagamento() %></td>
 								    <td nowrap align="left"><%= occ.getMeioPgto() %></td>
								    <td nowrap align="center"><%= occ.getCodigoUnidadePV() %></td>
								    <td nowrap align="center"><%= occ.getApelidoCedente() %></td>
								    </td>
								  </tr>
							<%  } %>								  

 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="11" align="center">
										
										  <% String pageName = TituloOnLineEstrategia.PAGE_MANTER_LISTAR;%>
										  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=pageName%>"/>
											
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="11">
	                    <p align="center">
	                    	<s:Button name="buttonConsultar" value="Consultar" action="javascript:consultar();"  />
	                    	<s:Button name="buttonAlterar" value="Alterar" action="javascript:alterar();"/>
	                    	<s:Button name="buttonExcluir" value="Excluir" action="javascript:excluir();" />
	                    	<s:Button name="buttonVoltar" value="Voltar" action="javascript: voltar();"/>
	                    </p>
	                  </td>
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
				verificaTipoOpcao();
				setFirstFieldFocus();
			}

			
      		function clickRadio(codCedente, nossoNumero, dtPgto, vrPagamento, meioPgto) {      			
				document.frmMain.codigoCedente.value = codCedente;
      			document.frmMain.nossoNumero.value = nossoNumero;
      			document.frmMain.dataPagamento.value = dtPgto;
      			document.frmMain.vrPagamento.value = vrPagamento;
      			document.frmMain.meioPgto.value = meioPgto;
      		}
      		
      		function consultar(){
      			if(! validaRadioButton(document.frmMain.rdo, '')){
					  return false;
					}
      			document.frmMain.estrategia.value = "<%= TituloOnLineEstrategia.STRATEGY_MANTER_ACAO_CONSULTAR%>";
				document.frmMain.submit();
      		}
      		
      		function alterar(){
      			if(! validaRadioButton(document.frmMain.rdo, '')){
					  return false;
					}
      			document.frmMain.estrategia.value = "<%= TituloOnLineEstrategia.STRATEGY_MANTER_ACAO_ALTERAR%>";
				document.frmMain.submit();
      		}
      		
      		function excluir(){
      			if(! validaRadioButton(document.frmMain.rdo, '')){
					  return false;
					}
      			document.frmMain.estrategia.value = "<%= TituloOnLineEstrategia.STRATEGY_MANTER_ACAO_EXCLUIR%>";
				document.frmMain.submit();
      		}
      		
      		function voltar(){
      			document.frmMain.fluxo.value = "voltar";
      			document.frmMain.estrategia.value = "<%= TituloOnLineEstrategia.STRATEGY_MANTER_FILTRO%>";
				document.frmMain.submit();
      		}


		</script>

	</s:FormStrategy>
</p:Document>
</html>