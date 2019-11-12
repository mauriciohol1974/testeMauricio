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
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ConsultaLiqStrManterEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>

<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

	LiquidacoesSTRBean filtroBean = (session.getAttribute(ConsultaLiqStrManterEstrategia.FILTRO_BEAN)==null
 									? new LiquidacoesSTRBean():(LiquidacoesSTRBean)session.getAttribute(ConsultaLiqStrManterEstrategia.FILTRO_BEAN));

	LiquidacoesSTRBean dataBean = (session.getAttribute(ConsultaLiqStrManterEstrategia.DATA_BEAN)==null
 	                                     ? new LiquidacoesSTRBean()
 	                                     :(LiquidacoesSTRBean)session.getAttribute(ConsultaLiqStrManterEstrategia.DATA_BEAN));
	
	FiltroPesquisa filtroPesquisa = (session.getAttribute("FILTRO_PESQUISA")==null ? new FiltroPesquisa() : (FiltroPesquisa)session.getAttribute("FILTRO_PESQUISA"));
	
	String pagina = (String) session.getAttribute("pagina");
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="consulta.ConsultaLiqStrManterFiltroDevolvidas" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Consultar Liquidações via STR Devolvidas"/>

		
		<input type="hidden" name="dataRecebimento" value="<%=filtroBean.getDataRecebimento()  %>">
		
		<input type="hidden" name="dataPesq" value="<%=Formatador.formatarData(filtroBean.getDataPesq())  %>">
		<input type="hidden" name="dataPesqFinal" value="<%=Formatador.formatarData(filtroBean.getDataPesqFinal())  %>">
		
		<input type="hidden" name="pagina" value="<%= pagina%>">
		<input type="hidden" name="<%= ConsultaLiqStrManterEstrategia.PAGINACAO_PAGE%>" value="<%=pagina %>">
		
		<input type="hidden" name="bancoOrigem" value="<%=filtroBean.getBanco()  %>">
		<input type="hidden" name="agenciaOrigem" value="<%= filtroBean.getAgenciaOrigem() %>">
		
		<input type="hidden" name="acaoExecutar" value="1">
		
		
		<input type="hidden" name="dataIniFiltro" value="<%= filtroPesquisa.getDataIni()%>">		
		<input type="hidden" name="dataFimFiltro" value="<%= filtroPesquisa.getDataFim()%>">
		<input type="hidden" name="cedenteFiltro" value="<%= filtroPesquisa.getCedente()%>">
		<input type="hidden" name="bancoFiltro" value="<%= filtroPesquisa.getBanco()%>">
		<input type="hidden" name="agenciaFiltro" value="<%= filtroPesquisa.getAgencia()%>">
		<input type="hidden" name="paginaFiltro" value="<%= filtroPesquisa.getPagina()%>">
		
		<input type="hidden" name="processarFiltro" value="S">
        
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left">

        
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Data de devolução: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDataRecebimento() %></td>
              <td class="textoTitulo" width="17%">Banco de Origem: </td>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(Long.valueOf(filtroBean.getBanco()),3) %></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Hora da devolução: </td>
              <td class="textoValor" width="26%"><%= dataBean.getHoraRecebimento() %></td> 
              <td class="textoTitulo" width="17%"> ISPB de Origem:</td>
              <%if (filtroBean.getISPBOrigem()>0){ %>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(Long.valueOf(filtroBean.getISPBOrigem()),8) %></td>
              <%}else{ %>
              <td>&nbsp;</td>
              <%} %>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Sequencia: </td>
              <td class="textoValor" width="26%"><%= dataBean.getSequencial()  %></td>
             <td class="textoTitulo" width="17%"> Agência de Origem:</td>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(dataBean.getAgenciaOrigem(),4) %></td>
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
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(dataBean.getCedenteOrigem(),6) %></td> 
              <td class="textoTitulo" width="17%">Nosso Número: </td>
              <td class="textoValor" width="26%"><%= dataBean.getNossoNumero() %></td>
            </tr>
           
            <tr>
              <td class="textoTitulo" width="17%">Valor Devolvido:</td>
              <td class="textoValor" width="26%"><%= dataBean.getValorRecebido()  %></td> 
              <td class="textoTitulo" width="17%">Data do movimento: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDataMovimento() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
              <td class="textoTitulo" width="17%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>


            <tr>
              <td class="textoTitulo" width="17%">Código da Devolução: </td>
              <td class="textoValor" width="26%"><%=dataBean.getCodDevolucao()%> </td> 
            </tr>
            
            <tr>
              <td class="textoTitulo" width="17%">Descrição da Devolução: </td>
              <td colspan="3" class="textoValor" width="26%"><%=dataBean.getDescCodDevolucao()%> </td> 
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
              <td class="textoTitulo" width="17%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Código Erro: </td>
              <td class="textoValor" width="26%"><%=dataBean.getCodErro()%> </td>               
            </tr>
            
            <tr>
              <td class="textoTitulo" width="17%">Descrição do Erro: </td>
              <td colspan="3" class="textoValor" width="26%"><%=dataBean.getDescricaoErro()%></td> 
            </tr>
            
            
            <tr>
              <td class="textoTitulo" width="17%">Código de Barras: </td>
              <td colspan="3" class="textoValor" width="26%"><%=dataBean.getCodBarras()%></td> 
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
              <td class="textoTitulo" width="17%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">NSU SIGCB Devolução: </td>
              <td class="textoValor" width="26%"><%=dataBean.getNsuSIGCB() %></td> 
              <td class="textoTitulo" width="17%">NSU SIGCB Recebimento:	 </td>
              <td class="textoValor" width="26%"><%= dataBean.getNsuSIGCBRecebimento() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">NSU SITRC Devolução:		 </td>
              <td class="textoValor" width="26%"><%=dataBean.getNsuSITRC() %></td> 
              <td class="textoTitulo" width="17%">NSU SITRC Recebimento:     </td>
              <td class="textoValor" width="26%"><%=dataBean.getNsuSITRCRecebimento() %></td> 
            </tr>
            
            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
              <td class="textoTitulo" width="17%">NSU BACEN Original: </td>
              <td class="textoValor" width="26%"><%= dataBean.getNsuBACEN() %></td>
            </tr>


            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
              <td class="textoTitulo" width="17%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
          

            <tr>
              <td class="textoTitulo" width="17%">Situação SPB: </td>
              <td class="textoValor" width="26%"><%=dataBean.getSituacaoSPB() %></td> 
              <td class="textoTitulo" width="17%">Código da Mensagem: </td>
              <td class="textoValor" width="26%"><%= dataBean.getCodMensagem() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Data/Hora Situação SPB: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDthrSituacaoSPB() %></td> 
              <td class="textoTitulo" width="17%">Forma Retorno Devolução: </td>
              <td class="textoValor" width="26%"><%=  dataBean.getFormaRetornoDev()%></td>
            </tr>
            
            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
              <td class="textoTitulo" width="17%">Código Retorno SITRC: </td>
              <td class="textoValor" width="26%"><%= dataBean.getCodRetSITRC() %></td>
            </tr>
            
            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
              <td class="textoTitulo" width="17%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Situação Anterior:</td>
              <td class="textoValor" width="26%"><%=dataBean.getDeSituacaoAnterior() %></td> 
              <td class="textoTitulo" width="17%">Data/Hora Situação Anterior: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDthrSituacaoAnterior()%>&nbsp;<%= dataBean.getUsuarioAnterior() %></td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Situação Atual:	 </td>
              <td class="textoValor" width="26%"><%=dataBean.getDeSituacaoAtual() %></td> 
              <td class="textoTitulo" width="17%">Data/Hora Situação Atual: </td>
              <td class="textoValor" width="26%"><%=dataBean.getDthrSituacaoAtual() %>&nbsp;<%= dataBean.getUsuarioAtual() %></td>
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
    		document.frmMain.estrategia.value = "consulta.ConsultaLiqStrManterFiltroDevolvidas";
			document.frmMain.submit();
    	}

    	
    	//function voltar(){
    	//	document.frmMain.estrategia.value = "consulta.ConsultaLiqStrIniciarDevolvidas";
		//	document.frmMain.submit();
    	//}
		
    </script>
    
	</s:FormStrategy>
</p:Document>
</html>