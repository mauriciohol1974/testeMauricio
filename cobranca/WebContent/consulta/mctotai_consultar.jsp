<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: mctotai_colsultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 18/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.MCTotaiEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerMovimentoCedenteBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.com.politec.sao.business.util.BeanList"%>

<%
  ConGerMovimentoCedenteBean filtroBean = (session.getAttribute(MCTotaiEstrategia.BEAN_FILTRO)==null? new ConGerMovimentoCedenteBean()
																			:(ConGerMovimentoCedenteBean)session.getAttribute(MCTotaiEstrategia.BEAN_FILTRO));

	ConGerMovimentoCedenteBean dataBean = (session.getAttribute(MCTotaiEstrategia.BEAN_DATA)==null? new ConGerMovimentoCedenteBean()
																			:(ConGerMovimentoCedenteBean)session.getAttribute(MCTotaiEstrategia.BEAN_DATA));

  CedenteCabecaBean cedCabBean = 	(session.getAttribute(MCTotaiEstrategia.BEAN_CABECALHO)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(MCTotaiEstrategia.BEAN_CABECALHO));

	PageHolder paginacao = (PageHolder) session.getAttribute(MCTotaiEstrategia.PAGINACAO_LIST);
	List lista = paginacao.getPage(0);	
%>


<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=MCTotaiEstrategia.STRATEGY_INICIAR%>" fluxo="voltar">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Movimento do Cedente (Totais)"/>
        
  
        
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
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
	            <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
	            <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals(new Long(0))? "":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
	            <td class="textoTitulo" width="17%">Período:</td>
              <td class="textoValor" width="26%"><%=filtroBean.getPeriodoFormatado()%></td>
	          </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Consulta:
                <hr>
              </td>
            </tr>

						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="25%" align="left">Canal Liquidação</td>
								    <td nowrap width="20%" align="right">Tarifa Unitária</td>
								    <td nowrap width="15%" align="right">Qtd. Boletos</td>
								    <td nowrap width="20%" align="right">Valor Total Recebido</td>
								    <td nowrap width="20%" align="right">Valor Total Tarifa</td>
								  </tr>
							<%
									ConGerMovimentoCedenteBean occ = new ConGerMovimentoCedenteBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ConGerMovimentoCedenteBean) lista.get(i);
							%>	  	  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="25%" align="left"><%=occ.getDescricaoCanal()%></td>
								    <td nowrap width="20%" align="right"><%=occ.getTarifaUnitaria()%></td>
								    <td nowrap width="15%" align="right"><%=occ.getQuantidadeBloqueto()%></td>
								    <td nowrap width="20%" align="right"><%=occ.getValorTotalRecebido()%></td>
								    <td nowrap width="20%" align="right"><%=occ.getValorTotalTarifa()%></td>
								  </tr>
								  <% 
								  	if (i == 15){
			  			    %>
			  			    <tr>
	                  <td colspan="6">&nbsp;</td>
	                </tr>
								  <tr class='line0'>
								  	<td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="25%" align="left"><b>Total</b></td>
								    <td nowrap width="20%" align="right"><b><%=dataBean.getValorTarUniAcumulado()%></b></td>
								    <td nowrap width="15%" align="right"><b><%=dataBean.getQtdBloquetosAcumulado()%></b></td>
								    <td nowrap width="20%" align="right"><b><%=dataBean.getValorRecAcumulado()%></b></td>
								    <td nowrap width="20%" align="right"><b><%=dataBean.getValorTarifaAcumulado()%></b></td>
								  </tr>	
								  <%}%>
							<% } %>
							
 	                <tr>
	                  <td colspan="6">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="6" align="center">&nbsp;</td>
									</tr>
 	                <tr>
	                  <td colspan="6">&nbsp;</td>
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
	                <s:Button name="Voltar" action="javascript:formSubmit();"/>
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
        setFirstFieldFocus();
      }
      function formSubmit() {
				document.frmMain.submit();
      }
      
      </script>
    </s:FormStrategy>
	</p:Document>
</html>
