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
<%@page import="br.gov.caixa.sigcb.estrategia.servico.LiqStrManterEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>

<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

	LiquidacoesSTRBean filtroBean = (session.getAttribute(LiqStrManterEstrategia.FILTRO_BEAN)==null
 									? new LiquidacoesSTRBean():(LiquidacoesSTRBean)session.getAttribute(LiqStrManterEstrategia.FILTRO_BEAN));

	LiquidacoesSTRBean dataBean = (session.getAttribute(LiqStrManterEstrategia.DATA_BEAN)==null
 	                                     ? new LiquidacoesSTRBean()
 	                                     :(LiquidacoesSTRBean)session.getAttribute(LiqStrManterEstrategia.DATA_BEAN));
	
	String pagina = (String) session.getAttribute("pagina");
	
    String bancoFiltro = (String) request.getAttribute("bancoFiltro");
    String ISPBFiltro =  (String) request.getAttribute("ISPBFiltro");
    String agenciaFiltro =  (String)  request.getAttribute("agenciaFiltro");
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="servico.LiqStrManterFiltro" fluxo="normal">
		<s:Menu/>
		
		<%if (filtroBean.getAcaoExecutar().equalsIgnoreCase("1")){ %>
			<s:Titulo name="Liquidações via STR >> Recomando"/>
		<%}else if (filtroBean.getAcaoExecutar().equalsIgnoreCase("2")){ %>
			<s:Titulo name="Liquidações via STR >> Cancela Recomando"/>
		<%}else if (filtroBean.getAcaoExecutar().equalsIgnoreCase("3")){ %>
			<s:Titulo name="Liquidações via STR >> Devolução"/>
		<%}else if (filtroBean.getAcaoExecutar().equalsIgnoreCase("4")){ %>
			<s:Titulo name="Liquidações via STR >> Cancela Devolução"/>
		<%}else if (filtroBean.getAcaoExecutar().equalsIgnoreCase("5")){ %>
			<s:Titulo name="Liquidações via STR >> Bloqueio de Devolução"/>
		<%}else{ %>
			<s:Titulo name="Liquidações via STR >> Cancela Bloqueio de Devolução"/>			
		<%} %>
		
		
		<input type="hidden" name="acaoExecutar" value="<%=filtroBean.getAcaoExecutar()  %>">		
		<input type="hidden" name="opcao" value="<%=filtroBean.getOpcao()  %>">		
		<input type="hidden" name="banco" value="<%=dataBean.getBanco()  %>">
		<input type="hidden" name="dataRecebimento" value="<%=dataBean.getDataRecebimento()  %>">
		<input type="hidden" name="horaRecebimento" value="<%=dataBean.getHoraRecebimento()  %>">
		<input type="hidden" name="sequencial" value="<%= dataBean.getSequencial() %>">
		<input type="hidden" name="nsuSIGCB" value="<%= dataBean.getNsuSIGCB() %>">
		<input type="hidden" name="coUsuario" value="<%= usuarioBean.getCodigoUsuario() %>">
		<input type="hidden" name="<%=LiqStrManterEstrategia.PAGINACAO_PAGE%>" value="<%= pagina%>" >
		
		<input type="hidden" name="bancoOrigem" value="<%=Util.zerosEsquerda(dataBean.getBancoOrigem(), 3)   %>">
		<input type="hidden" name="ISPBOrigem" value="<%=Util.zerosEsquerda(dataBean.getISPBOrigem(),8)  %>">
		<input type="hidden" name="agenciaOrigem" value="<%=Util.zerosEsquerda(dataBean.getAgenciaOrigem(),4)  %>">
		
		<input type="hidden" name="bancoFiltro" value="<%=bancoFiltro %>">
		<input type="hidden" name="ISPBFiltro" value="<%=ISPBFiltro %>">
		<input type="hidden" name="agenciaFiltro" value="<%=agenciaFiltro %>">
        
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Opção: </td>
              <td class="textoValor" width="26%"><%= filtroBean.getDescOpcao() %></td>
              <td class="textoTitulo" width="17%">Banco de Origem: </td>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(dataBean.getBancoOrigem(),3) %></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Data do Recebimento: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDataRecebimento() %></td> 
              <td class="textoTitulo" width="17%"> ISPB de Origem:</td>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(dataBean.getISPBOrigem(),8) %></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Hora Recebimento: </td>
              <td class="textoValor" width="26%"><%= dataBean.getHoraRecebimento() %></td>
              <td class="textoTitulo" width="17%"> Agência de Origem:</td>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(dataBean.getAgenciaOrigem(),4) %></td>

            </tr>
            <tr> 
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Sequência: </td>
              <td class="textoValor" width="26%"><%= dataBean.getSequencial() %></td>
              
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
              <td class="textoValor" width="26%"><%= dataBean.getCpfCnpjSacadoFormatado() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Canal de Pagamento: </td>
              <td class="textoValor" width="26%"><%=dataBean.getCodCanal()%> &nbsp;-&nbsp; <%=dataBean.getDescCanal()%> </td> 
              <td class="textoTitulo" width="17%">Banco / Agência de Crédito: </td>
              <td class="textoValor" width="26%"><%= dataBean.getBanco() %> / <%= dataBean.getAgencia() %></td>
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
              <td class="textoValor" width="26%"><%=dataBean.getCdSituacaoAnterior() %>&nbsp;<%=dataBean.getDeSituacaoAnterior() %></td> 
              <td class="textoTitulo" width="17%">Data/Hora Situação Anterior: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDthrSituacaoAnterior() %>&nbsp;<%=dataBean.getUsuarioAnterior() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Situação Atual:	 </td>
              <td class="textoValor" width="26%"><%=dataBean.getCdSituacaoAtual() %>&nbsp;<%=dataBean.getDeSituacaoAtual() %></td> 
              <td class="textoTitulo" width="17%">Data/Hora Situação Atual: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDthrSituacaoAtual() %>&nbsp;<%=dataBean.getUsuarioAtual() %></td>
            </tr>

			<%if (dataBean.getAcaoExecutar().equalsIgnoreCase("3")){ %>
            <tr>
              <td class="textoTitulo" width="17%">Código da Devolução: </td>
              <td class="textoValor" width="26%"><p:InputNumerico name="codDevolucao" value="<%=dataBean.getCodDevolucao() %>" CLASS="inputtext" size="4" maxlength="2"/></td> 
              <td class="textoTitulo" width="17%"></td>
              <td class="textoValor" width="26%"></td>
            </tr>
            <%} else { %>
            <tr>
              <td class="textoTitulo" width="17%">Código da Devolução: </td>
              <td colspan="3" class="textoValor" width="26%"><%=dataBean.getCodDevolucao() %> &nbsp;<%=dataBean.getDescCodDevolucao()%> </td> 
              
            </tr>

            <%} %>

          
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Dados de Recomando:
                <hr>
              </td>
            </tr>

			<%if (dataBean.getAcaoExecutar().equalsIgnoreCase("1")){ %>
 			<tr>
              <td class="textoTitulo" width="17%">Cedente Corrigido: </td>
              <td class="textoValor" width="26%"><p:InputNumerico name="cedenteCorrigido" value="<%=dataBean.getCedenteCorrigido() %>"CLASS="inputtext" size="8" maxlength="7"/></td> 
              <td class="textoTitulo" width="17%">Nosso Número Corrigido:	 </td>
              <td class="textoValor" width="26%"><p:InputNumerico name="nossoNumeroCorrigido" value="<%=dataBean.getNossoNumeroCorrigido() %>" maxlength="18" size="23" CLASS="inputtext" />
              </td>
            </tr>
			<%} else { %>
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
			<%} %>

            
           
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center">
                	<s:Button name="recomando" value="Confirmar" action="javascript: recomandoEfetivar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.liquidacoes.acoes" />
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

    	function recomandoEfetivar(){
    		
			if (confirm("Confirma a execução da ação?")){
				document.frmMain.estrategia.value = "servico.LiqStrRecomandoEfetivar";
				document.frmMain.submit();

			}
	    		
			
    	}

    	
    	
    	function voltar(){
    		document.frmMain.estrategia.value = "servico.LiqStrManterFiltro";
			document.frmMain.submit();
    	}
		
    </script>
    
	</s:FormStrategy>
</p:Document>
</html>