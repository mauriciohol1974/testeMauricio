<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: mcrence_consultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 20/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.MCRenCeEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerCedenteRentabilidadeBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%@page import="br.com.politec.sao.util.Money"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>

<%
  ConGerCedenteRentabilidadeBean fixoBean = (session.getAttribute(MCRenCeEstrategia.BEAN_FIXO)==null? new ConGerCedenteRentabilidadeBean()
																			:(ConGerCedenteRentabilidadeBean)session.getAttribute(MCRenCeEstrategia.BEAN_FIXO));

  CedenteCabecaBean cedCabBean = 	(session.getAttribute(MCRenCeEstrategia.BEAN_CABECALHO)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(MCRenCeEstrategia.BEAN_CABECALHO));

	PageHolder paginacao = (PageHolder) session.getAttribute(MCRenCeEstrategia.PAGINACAO_LIST);
	List lista = paginacao.getPage(0);	
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=MCRenCeEstrategia.STRATEGY_INICIAR%>" fluxo="voltar">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Rentabilidade do Cedente"/>

        
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
              <td class="textoValor" width="26%"><%=fixoBean.getDescPeriodo()%></td>
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
              <td class="textoTitulo" width="17%">Valor Bruto Tarifas: </td>
              <td class="textoValor" width="26%"><%=fixoBean.getValorBrutoTarifas()%></td> 
              <td class="textoTitulo" width="17%">Outros Custos: </td>
              <td class="textoValor" width="26%"><%=fixoBean.getOutrosCustos()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Preço Transferência: </td>
              <td class="textoValor" width="26%"><%=fixoBean.getPrecoTransferencia()%></td> 
              <td class="textoTitulo" width="17%">Valor Líquido: </td>
              <td class="textoValor" width="26%">
                <%=(fixoBean.getValorLiquidoSigned().lessThan(new Money("0", fixoBean.getValorLiquido().getCurrency() )))?"<span style='color=\"red\"'>":""%>
              	<%=fixoBean.getValorLiquidoSigned()%>
                <%=(fixoBean.getValorLiquidoSigned().lessThan(new Money("0", fixoBean.getValorLiquido().getCurrency() )))?"</span>":""%>
              </td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Qtd. Boletos Arrecadados: </td>
              <td class="textoValor" width="26%"><%=fixoBean.getQtdBloquetos()%></td> 
              <td class="textoTitulo" width="17%">Rentabilidade Média: </td>
              <td class="textoValor" width="26%">
                <%=(fixoBean.getRentabilidadeMediaSigned().lessThan(new Money("0", fixoBean.getRentabilidadeMedia().getCurrency() )))?"<span style='color=\"red\"'>":""%>
              	<%=fixoBean.getRentabilidadeMediaSigned()%>
                <%=(fixoBean.getRentabilidadeMediaSigned().lessThan(new Money("0", fixoBean.getRentabilidadeMediaSigned().getCurrency() )))?"</span>":""%>
              </td>
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Detalhe:
                <hr>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<s:Outline name="mcrence_canal" title="Custos por Canal de liquidação" imagePath="<%=Paths.getImagePath()%>" type="outline">
                  <table width="95%" border="0" cellspacing="3" cellpadding="0" height=14 valign="middle" align="center">
	                  <tr> 
	                    <td colspan="4">&nbsp;</td>
	                  </tr>
									  <tr class="headerLista">
									    <td nowrap width="2%" align="center">&nbsp;</td>
	 								    <td nowrap width="50%" align="left">Canal</td>
									    <td nowrap width="50%" align="right">Valor</td>
									  </tr>
									<%
										ConGerCedenteRentabilidadeBean occ = new ConGerCedenteRentabilidadeBean();
										
										for ( int i = 0; i < lista.size(); i++ ) {	
											occ = (ConGerCedenteRentabilidadeBean) lista.get(i);
									%> 		  
									  <tr class="line2">
									    <td nowrap width="2%" align="center">&nbsp;</td>
	 								    <td nowrap width="50%" align="left"><%=occ.getDescricaoCanal()%></td>
									    <td nowrap width="50%" align="right"><%=occ.getValor()%></td>
									  </tr>
									<% } %> 
									  <tr>
		                  <td colspan="3">&nbsp;</td>
		                </tr>
	              	</table>
                </s:Outline>	          
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<s:Outline name="mcrence_comandos" title="Comandos Manuais" imagePath="<%=Paths.getImagePath()%>" type="outline">      
                  <table width="95%" border="0" cellspacing="3" cellpadding="0" height=14 valign="middle" align="center">
	                  <tr> 
	                    <td colspan="4">&nbsp;</td>
	                  </tr>
									  <tr class="headerLista">
									    <td nowrap width="2%" align="center">&nbsp;</td>
	 								    <td nowrap width="50%" align="left">Comando</td>
									    <td nowrap width="50%" align="right">Quantidade</td>
									  </tr>
									  <tr class="line2">
									    <td nowrap width="2%" align="center">&nbsp;</td>
	 								    <td nowrap width="50%" align="left">Baixa de Títulos</td>
									    <td nowrap width="50%" align="right"><%=fixoBean.getQtdBaixaTitulos()%></td>
									  </tr>
									  <tr class="line0">
									    <td nowrap width="2%" align="center">&nbsp;</td>
	 								    <td nowrap width="50%" align="left">Alterações de Titulos</td>
									    <td nowrap width="50%" align="right"><%=fixoBean.getQtdAlteracaoesTitulos()%></td>
									  </tr>
	 	                <tr>
		                  <td colspan="3">&nbsp;</td>
		                </tr>
	              	</table>
								</s:Outline>	    
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