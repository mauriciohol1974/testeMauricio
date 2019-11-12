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
<%@page import="br.gov.caixa.sigcb.bean.LiquidacoesSTRBean"%>
<%@page import="br.gov.caixa.sigcb.bean.FiltroPesquisa"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.LiqStrManterEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>

<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

	LiquidacoesSTRBean filtroBean = (session.getAttribute(LiqStrManterEstrategia.FILTRO_BEAN)==null
 									? new LiquidacoesSTRBean():(LiquidacoesSTRBean)session.getAttribute(LiqStrManterEstrategia.FILTRO_BEAN));

	LiquidacoesSTRBean dataBean = (session.getAttribute(LiqStrManterEstrategia.DATA_BEAN)==null
 	                                     ? new LiquidacoesSTRBean()
 	                                     :(LiquidacoesSTRBean)session.getAttribute(LiqStrManterEstrategia.DATA_BEAN));

	
	FiltroPesquisa filtroPesquisa = (session.getAttribute("FILTRO_PESQUISA")==null ? new FiltroPesquisa() : (FiltroPesquisa)session.getAttribute("FILTRO_PESQUISA"));
	
	String pagina = (String) session.getAttribute("pagina");
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="consulta.ConsultaLiqStrManterFiltroRecebidas" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Consultar Liquidações via STR Recebidas"/>

		
		<input type="hidden" name="opcao" value="<%=filtroBean.getOpcao()  %>">		
		
		<input type="hidden" name="banco" value="<%=filtroBean.getBanco()  %>">
		<input type="hidden" name="dataRecebimento" value="<%=filtroBean.getDataRecebimento()  %>">
		<input type="hidden" name="horaRecebimento" value="<%=filtroBean.getHoraRecebimento()  %>">
		<input type="hidden" name="sequencial" value="<%= filtroBean.getSequencial() %>">
		<input type="hidden" name="acaoExecutar" value="1">
		<input type="hidden" name="dataPesq" value="<%= Formatador.formatarData(filtroBean.getDataPesq()) %>">
		<input type="hidden" name="dataPesqFinal" value="<%= Formatador.formatarData(filtroBean.getDataPesqFinal()) %>">
		<input type="hidden" name="<%=LiqStrManterEstrategia.PAGINACAO_PAGE%>" value="<%= pagina%>" >
		
		
		<input type="hidden" name="dataIniFiltro" value="<%= filtroPesquisa.getDataIni()%>">		
		<input type="hidden" name="dataFimFiltro" value="<%= filtroPesquisa.getDataFim()%>">
		<input type="hidden" name="cedenteFiltro" value="<%= filtroPesquisa.getCedente()%>">
		<input type="hidden" name="bancoFiltro" value="<%= filtroPesquisa.getBanco()%>">
		<input type="hidden" name="ispbFiltro" value="<%= filtroPesquisa.getIspb()%>">
		<input type="hidden" name="agenciaFiltro" value="<%= filtroPesquisa.getAgencia()%>">
		<input type="hidden" name="paginaFiltro" value="<%= filtroPesquisa.getPagina()%>">
		<input type="hidden" name="processarFiltro" value="S">
        
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Opção: </td>
              <td class="textoValor" width="26%"><%= filtroBean.getDescOpcao() %></td>
              <td class="textoTitulo" width="17%">Banco de Origem: </td>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(filtroBean.getBancoOrigem(),3) %></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Data do Recebimento: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDataRecebimento() %></td> 
              <td class="textoTitulo" width="17%"> ISPB de Origem:</td>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(filtroBean.getISPBOrigem(),8) %></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Hora Recebimento: </td>
              <td class="textoValor" width="26%"><%= dataBean.getHoraRecebimento() %></td>
              <td class="textoTitulo" width="17%"> Agência de Origem:</td>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(filtroBean.getAgenciaOrigem(),4) %></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Sequência: </td>
              <td class="textoValor" width="26%"><%= dataBean.getSequencial() %></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">&nbsp;
                <hr>
              </td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%= dataBean.getCedente() %></td> 
              <td class="textoTitulo" width="17%">Nosso Número: </td>
              <td class="textoValor" width="26%"><%= dataBean.getNossoNumero() %></td>
            </tr>
           
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa Cedente: </td>
              <td class="textoValor" width="26%"><%=dataBean.getTipoPessoaCedente() %></td> 
              <td class="textoTitulo" width="17%">Tipo Pessoa Sacado: </td>
              <td class="textoValor" width="26%"><%= dataBean.getTipoPessoaSacado() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">CNPJ/CPF Cedente: </td>
              <td class="textoValor" width="26%"><%=dataBean.getCpfCnpjCedenteFormatado() %></td> 
              <td class="textoTitulo" width="17%">CNPJ/CPF Sacado: </td>
              <td class="textoValor" width="26%"><%= dataBean.getCpfCnpjSacadoFormatado()%></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Canal de Pagamento: </td>
              <td class="textoValor" width="26%"><%=dataBean.getCodCanal()%> &nbsp;-&nbsp; <%=dataBean.getDescCanal()%> </td> 
              <td class="textoTitulo" width="17%">Agência de Crédito: </td>
              <td class="textoValor" width="26%"><%= dataBean.getAgencia() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Valor do Documento: </td>
              <td class="textoValor" width="26%"><%=dataBean.getValorDocumento() %></td> 
              <td class="textoTitulo" width="17%">Data do movimento: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDataMovimento() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Valor Desc./Abatimento: </td>
              <td class="textoValor" width="26%"><%=dataBean.getValorDescAbatimento() %></td> 
              <td class="textoTitulo" width="17%">Forma de Recebimento:	 </td>
              <td class="textoValor" width="26%"><%= dataBean.getCodFormaRecebimento() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Valor dos Juros:	 </td>
              <td class="textoValor" width="26%"><%=dataBean.getValorJuros() %></td> 
              <td class="textoTitulo" width="17%">NSU SIGCB:	 </td>
              <td class="textoValor" width="26%"><%= dataBean.getNsuSIGCB() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Valor da Multa:	 </td>
              <td class="textoValor" width="26%"><%=dataBean.getValorMulta() %></td> 
              <td class="textoTitulo" width="17%">NSU SITRC: </td>
              <td class="textoValor" width="26%"><%= dataBean.getNsuSITRC() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Valor Outros Acréscimos: </td>
              <td class="textoValor" width="26%"><%=dataBean.getValorAcrescimo() %></td> 
              <td class="textoTitulo" width="17%">NSU BACEN:	 </td>
              <td class="textoValor" width="26%"><%= dataBean.getNsuBACEN() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Valor Recebido: </td>
              <td class="textoValor" width="26%"><%=dataBean.getValorRecebido() %></td> 
              <td class="textoTitulo" width="17%">Data/Hora BACEN: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDthrBACEN() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Código de Barras: </td>
              <td colspan="3" class="textoValor" width="26%"><%=dataBean.getCodBarras() %></td> 
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Data de Vencimento: </td>
              <td class="textoValor" width="26%"><%=dataBean.getDataVencimento() %></td> 
              <td class="textoTitulo" width="17%">Código da Mensagem: </td>
              <td class="textoValor" width="26%"><%= dataBean.getCodMensagem() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Código do Erro:	 </td>
              <td class="textoValor" width="26%"><%=dataBean.getCodErro() %></td> 
              <td class="textoTitulo" width="17%">Identificador Transferência: </td>
              <td class="textoValor" width="26%"><%= dataBean.getIcTransfere() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Descrição do Erro: </td>
              <td colspan="3"class="textoValor" width="26%"><%=dataBean.getDescricaoErro() %></td> 

            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Situação Anterior: </td>
              <td class="textoValor" width="26%"><%=dataBean.getCdSituacaoAnterior() %> &nbsp; <%=dataBean.getDeSituacaoAnterior()%></td> 
              <td class="textoTitulo" width="17%">Data/Hora Situação Anterior: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDthrSituacaoAnterior() %>&nbsp;<%= dataBean.getUsuarioAnterior() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Situação Atual:	 </td>
              <td class="textoValor" width="26%"><%=dataBean.getCdSituacaoAtual() %> &nbsp; <%=dataBean.getDeSituacaoAtual() %></td> 
              <td class="textoTitulo" width="17%">Data/Hora Situação Atual: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDthrSituacaoAtual() %>&nbsp;<%= dataBean.getUsuarioAtual() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Código da Devolução: </td>
              <td colspan="3" class="textoValor" width="26%"><%=dataBean.getCodDevolucao() %> &nbsp;<%=dataBean.getDescCodDevolucao()%> </td> 
              
            </tr>

          
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Dados de Recomando:
                <hr>
              </td>
            </tr>

 			<tr>
              <td class="textoTitulo" width="17%">Cedente Corrigido: </td>
              <% if (dataBean.getCedenteCorrigido().equalsIgnoreCase("000000")) { %>
              	<td class="textoValor" width="26%">&nbsp;</td>
              <%}else{ %>
              	<td class="textoValor" width="26%"><%=dataBean.getCedenteCorrigido()%></td>
              <%} %>
              <td class="textoTitulo" width="17%">Nosso Número Corrigido:</td>
              <% if (dataBean.getNossoNumeroCorrigido().equalsIgnoreCase("000000000000000000")) {%>
              	<td class="textoValor" width="26%">&nbsp;</td>
              <%}else{ %>
              	<td class="textoValor" width="26%"><%=dataBean.getNossoNumeroCorrigido()%></td>
              <%} %>
            </tr>


           
           
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center">
                	<s:Button name="buttonVoltar" value="Voltar" action="javascript: voltar();"/>
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
    	function inicia() {

    	}

    	
    	
    	function voltar(){
    		document.frmMain.estrategia.value = "consulta.ConsultaLiqStrManterFiltroRecebidas";
			document.frmMain.submit();
    	}
    
    	//function voltar(){
	    //		document.frmMain.estrategia.value = "consulta.ConsultaLiqStrIniciarRecebidas";
		//		document.frmMain.submit();
	    //}
		
    </script>
    
	</s:FormStrategy>
</p:Document>
</html>