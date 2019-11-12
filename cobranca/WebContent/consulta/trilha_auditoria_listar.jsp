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
<%@page import="br.gov.caixa.sigcb.bean.TrilhaAuditoriaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TrilhaAuditoriaEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

	TrilhaAuditoriaBean trilha = (session.getAttribute(TrilhaAuditoriaEstrategia.DATA_BEAN)==null
 	                                        ? new TrilhaAuditoriaBean()
 	                                        :(TrilhaAuditoriaBean)session.getAttribute(TrilhaAuditoriaEstrategia.DATA_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(TrilhaAuditoriaEstrategia.PAGINACAO_LIST);
	if(request.getParameter(TrilhaAuditoriaEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(TrilhaAuditoriaEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(TrilhaAuditoriaEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(TrilhaAuditoriaEstrategia.PAGINACAO_PAGE));
	}
	
	List lista = paginacao.getPage(paginaAtual);	
	
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TrilhaAuditoriaEstrategia.STRATEGY_CONSULTAR %>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TrilhaAuditoriaEstrategia.PAGE_TITLE_MANTER_LISTAR  %>"/>

		<input type="hidden" name="<%=TrilhaAuditoriaEstrategia.PAGINACAO_PAGE%>" value="<%= paginaAtual%>" >
		
		<input type="hidden" name="codigoCedente" value="">
		<input type="hidden" name="transacao" value="">
		<input type="hidden" name="nsu" value="">
		

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
				<td valign="top" width="5%" height="14" align="left">&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">&nbsp;
                <hr>
              </td>   
            </tr>


            
            <tr> 
            
             <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%= trilha.getCodigoCedenteFormatado()%>               
              </td>
              <td class="textoTitulo" width="17%">CPF/CNPJ Cedente: </td>
              <td class="textoValor" width="26%"><%= trilha.getCpfCnpjCed()%>               
              </td>
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
 								    
								    <td nowrap width="10%" align="center">Data</td>
 								    <td nowrap width="10%" align="center">Hora</td>
 								    <td nowrap width="10%" align="center">Transação</td>
 								    <td nowrap width="15%" align="center">Responsável</td>
								    <td nowrap width="10%" align="center">NSU</td>
								    
								    
								    
								  </tr>

							<%
								TrilhaAuditoriaBean occ = new TrilhaAuditoriaBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (TrilhaAuditoriaBean) lista.get(i);
							%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="2%" align="center">
								    	<input type="radio" name="rdo" onclick="javascript:clickRadio('<%=trilha.getCodigoCedenteFormatado()%>','<%=occ.getTransacao()%>','<%=occ.getNsu()%>');">
								    </td>
 								    
 								    <td nowrap align="center"><%= occ.getDataAuditorialFormatada() %></td>
 								    <td nowrap align="center"><%= occ.getHoraAuditoria() %></td>
 									<td nowrap align="center"><%= occ.getTransacao()%></td>
 								    <td nowrap align="left"><%=occ.getCpfCnpj() %></td>
								    <td nowrap align="center"><%=occ.getNsu() %></td>
								    
								    </td>
								  </tr>
							<%  } %>								  

 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="11" align="center">
										
										  <% String pageName = TrilhaAuditoriaEstrategia.PAGE_MANTER_LISTAR;%>
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

			
      		function clickRadio(codCedente, transacao, nsu) {      			
				document.frmMain.codigoCedente.value = codCedente;
      			document.frmMain.nsu.value = nsu;
      		}
      		
      		function consultar(){
      			if(! validaRadioButton(document.frmMain.rdo, '')){
					  return false;
					}
      			document.frmMain.estrategia.value = "<%= TrilhaAuditoriaEstrategia.STRATEGY_CONSULTAR%>";
				document.frmMain.submit();
      		}
      		
      		
      		
      		function voltar(){
      			document.frmMain.fluxo.value = "voltar";
      			document.frmMain.estrategia.value = "<%= TrilhaAuditoriaEstrategia.STRATEGY_MANTER%>";
				document.frmMain.submit();
      		}


		</script>

	</s:FormStrategy>
</p:Document>
</html>