<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: titliq_consultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 11/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.ContaCreditoBean"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TitLiqManterEstrategia" %>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
  ConGerTitulosLiquidadosBean titliqbean = (session.getAttribute(TitLiqManterEstrategia.TITLIQ_BEAN)==null? new ConGerTitulosLiquidadosBean()
																						:(ConGerTitulosLiquidadosBean)session.getAttribute(TitLiqManterEstrategia.TITLIQ_BEAN));
																																																														 
	CedenteCabecaBean cedCabBean = 	(session.getAttribute(TitLiqManterEstrategia.CABECALHO_BEAN)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(TitLiqManterEstrategia.CABECALHO_BEAN));
	
	String icRateio=titliqbean.getIcRateio();
%>



<%
	ArrayList listaTitulos = (ArrayList) session.getAttribute("listaContaCredito");
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.TitLiqManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=TitLiqManterEstrategia.PAGE_TITLE%>"/>
 		
 		
		<input type="hidden" name="codigoCedente" value=" <%= titliqbean.getCodigoCedente()%>">
		<input type="hidden" name="dataPagamento" value="<%= titliqbean.getDataPagamentoListaFormatada() %>">
		<input type="hidden" name="nossoNumero" value="<%= titliqbean.getNossoNumeroLista()%>">
		<input type="hidden" name="tipoConsulta" value="<%= titliqbean.getTipoConsulta()%>">
		<input type="hidden" name="pagina" value="<%= titliqbean.getPagina()%>">
 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
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
	            <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
              <td class="textoTitulo" width="17%">Data Pagamento: </td>
              <td class="textoValor" width="26%"><%=titliqbean.getDataPagamentoFormatada()%></td> 
						</tr>
            <tr>
              <td class="textoTitulo" width="17%">Numero Docto.: </td>
              <td class="textoValor" width="26%"><%=titliqbean.getNumeroDocumento()%></td> 
              <td class="textoTitulo" width="17%">Valor Titulo: </td>
              <td class="textoValor" width="26%"><%=titliqbean.getValorTitulo()%></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Titulo Liquidado:
                <hr>
              </td>
            </tr>
						<tr>
              <td colspan="4">
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="left">
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Nome Sacado: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getNomeSacado()%></td>
                      <td nowrap class="textoTitulo" width="17%">&nbsp;</td>
				              <td nowrap class="textoValor" width="26%">&nbsp;</td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Nosso Número: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getNossoNumero()%></td>
                      <td nowrap class="textoTitulo" width="17%">Situação: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getSituacaoTitulo()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Situação: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataSituacaoFormatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data Vencimento: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataVencimentoFormatada()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Modalidade: </td>
                      <td nowrap class="textoValor" width="26%"><%=titliqbean.getDescricaoModalidade()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data Crédito: </td>
                      <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataCreditoFormatada()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Meio de Entrada: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getMeioEntrada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Moeda: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getMoeda()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">PV Recebedor: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPvRecebedorFormatado()%></td>
                      <td nowrap class="textoTitulo" width="17%">PV Cobrador: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPvCobradorFormatado()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Especie: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getEspecieTitulo()%></td>
                      <td nowrap class="textoTitulo" width="17%">Aceite: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getAceite()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Numero Lote: </td>
				              <td nowrap class="textoValor" width="26%"><%=Util.toStr(titliqbean.getNumeroLote())%></td>
                      <td nowrap class="textoTitulo" width="17%">Quantidade Moeda: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getQuantidadeMoeda()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Abatimento: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorAbatimento()%></td>
			                <td nowrap class="textoTitulo" width="17%">Data Entrada: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataEntradaFormatada()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Valor Juros:</td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorJuros()%></td>
                      <td nowrap class="textoTitulo" width="17%">Percentual de Juros: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPercentualJurosDia()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Valor Multa: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorMulta()%></td>
                      <td nowrap class="textoTitulo" width="17%">Percentual de Multa: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPercentualMulta()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Multa: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataMultaFormatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Prazo Multa: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPrazoMulta()%> dias</td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Valor Desconto 1: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorDesconto1()%></td>
                      <td nowrap class="textoTitulo" width="17%">Desconto Percentual 1: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPercentualDesconto1()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Valor Desconto 2: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorDesconto2()%></td>
                      <td nowrap class="textoTitulo" width="17%">Desconto Percentual 2: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPercentualDesconto2()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Valor Desconto 3: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorDesconto3()%></td>
                      <td nowrap class="textoTitulo" width="17%">Desconto Percentual 3: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPercentualDesconto3()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Desconto 1: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataDesconto1Formatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Prazo Desconto 1: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPrazoDesconto1()%> dias</td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Desconto 2: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataDesconto2Formatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Prazo Desconto 2: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPrazoDesconto2()%> dias</td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Desconto 3: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataDesconto3Formatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Prazo Desconto 3: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPrazoDesconto3()%> dias</td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Emissão: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataEmissaoFormatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data para Protesto: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataProtestoFormatada()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Prazo Protesto: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPrazoProtesto()%> dias</td>
                      <td nowrap class="textoTitulo" width="17%">Valor Cobrado: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorCobrado()%></td> 
				    </tr>
				    <tr>
                      <td nowrap class="textoTitulo" width="17%">IOF Retido: </td>
				      <td nowrap class="textoValor" width="26%"><%=titliqbean.getRetidoValorIOF()%></td>
				      <td nowrap class="textoTitulo" width="17%">Dispensa de Encargos:</td>
				      <td nowrap class="textoValor" width="26%"><%=titliqbean.getFeriadoLocal()%></td> 
				    </tr>  
				    <tr>
                      <td nowrap class="textoTitulo" width="17%">Parcela: </td>
				      <td nowrap class="textoValor" width="26%"><%=titliqbean.getParcela()%></td>
				    </tr>  
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                    <%if (icRateio.equalsIgnoreCase("S")) { %>
                    <tr>
						<td colspan="4">
							<s:Outline name="rateio" title="Dados Rateio" imagePath="<%=Paths.getImagePath()%>"	type="outline">
								<table width="95%" border="0" cellspacing="0" cellpadding="0"	height=14 valign="middle" align="center">
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
									
									<tr>
										<td colspan="4">
											<table>
											<tr>
												<td nowrap class="textoTitulo" width="10%" align="center">Banco</td>
												<td nowrap class="textoTitulo" width="10%" align="center">Conta</td>
												<td nowrap class="textoTitulo" width="10%" align="center">Perc. Previsto</td>
												<td nowrap class="textoTitulo" width="10%" align="center">Perc. Efetivo</td>
												<td nowrap class="textoTitulo" width="10%" align="center">Valor Previsto</td>
												<td nowrap class="textoTitulo" width="10%" align="center">Valor Efetivo</td>
												<td nowrap class="textoTitulo" width="10%" align="center">CPF/CNPJ</td>
												<td nowrap class="textoTitulo" width="30%" align="center">Titular</td>
											</tr>
											<%
											ContaCreditoBean occ = new ContaCreditoBean();
											for ( int i = 0; i < listaTitulos.size(); i++ ) {	
												occ = (ContaCreditoBean) listaTitulos.get(i);
											%>
										  	<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
												<td nowrap class="textoValor" width="10%" align="center"><%= occ.getBanco() %></td>
												<td nowrap class="textoValor" width="10%" align="center"><%= occ.getConta() %></td>
												<td nowrap class="textoValor" width="10%" align="right"><%= occ.getPercPrevisto() %></td>
												<td nowrap class="textoValor" width="10%" align="right"><%= occ.getPercEfetivo()%></td>
												<td nowrap class="textoValor" width="10%" align="right"><%= occ.getValorPrevisto() %></td>
												<td nowrap class="textoValor" width="10%" align="right"><%= occ.getValorEfetivo() %></td>
												<td nowrap class="textoValor" width="10%" align="right"><%= occ.getCpfCnpj() %></td>
												<td nowrap class="textoValor" width="30%" align="left"><%= occ.getTitular() %></td>
		 								    </tr>
		 								    <%} %>
	 								    	</table>
 								    	</td>
 								    </tr>
									
								</table>
							</s:Outline>
							</td>
					</tr>
					<%} %>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                  </table>
				</td>                  
            </tr>
            <tr>
	            <td align="right" colspan="4">
  	            <p align="center"> 
      	          <input type="button" class="button" name="Voltar" value="Voltar" onclick="javascript:formSubmit_Voltar()">
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
	   	function formSubmit(){}
	   	
	    function formSubmit_Voltar() {
				document.frmMain.estrategia.value = "consulta.TitLiqManterFiltro";
        document.frmMain.fluxo.value = "voltar";
       	document.frmMain.submit();
	    }   

    </script>
		</s:FormStrategy>
	</p:Document>
</html>