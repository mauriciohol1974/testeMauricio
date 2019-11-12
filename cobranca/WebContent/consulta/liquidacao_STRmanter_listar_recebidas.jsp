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
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ConsultaLiqStrManterEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

	LiquidacoesSTRBean liqRejeBean = (session.getAttribute(ConsultaLiqStrManterEstrategia.FILTRO_BEAN)==null
 	                                        ? new LiquidacoesSTRBean()
 	                                        :(LiquidacoesSTRBean)session.getAttribute(ConsultaLiqStrManterEstrategia.FILTRO_BEAN));
	
	FiltroPesquisa filtroPesquisa = (session.getAttribute("FILTRO_PESQUISA")==null ? new FiltroPesquisa() : (FiltroPesquisa)session.getAttribute("FILTRO_PESQUISA"));
	
	String pagfiltro = (String) request.getAttribute("PAGFILTRO");
	
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ConsultaLiqStrManterEstrategia.PAGINACAO_LIST);
	
	//if (request.getParameter(ConsultaLiqStrManterEstrategia.PAGINACAO_PAGE) != null
	//    && !request.getParameter(ConsultaLiqStrManterEstrategia.PAGINACAO_PAGE)
	 //           .equals("")) {
	  //  paginaAtual = Integer.parseInt((String) request.getParameter(ConsultaLiqStrManterEstrategia.PAGINACAO_PAGE));
///	} else {
//	    paginaAtual = Integer.parseInt((String) request.getAttribute(ConsultaLiqStrManterEstrategia.PAGINACAO_PAGE));
//	}
	
	List lista = paginacao.getPage(paginaAtual);
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="consulta.ConsultaLiqStrManterFiltroRecebidas" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Consultar Liquidações via STR Recebidas"/>

		
		<input type="hidden" name="banco" value="">
		<input type="hidden" name="dataRecebimento" value="">
		<input type="hidden" name="horaRecebimento" value="">
		<input type="hidden" name="sequencial" value="">
		<input type="hidden" name="acaoExecutar" value="">
		<input type="hidden" name="dataPesq" value="<%= Formatador.formatarData(liqRejeBean.getDataPesq()) %>">
		<input type="hidden" name="dataPesqFinal" value="<%= Formatador.formatarData(liqRejeBean.getDataPesqFinal()) %>">
		
		
		<input type="hidden" name="dataIniFiltro" value="<%= Formatador.formatarData(liqRejeBean.getDataPesq()) %>">		
		<input type="hidden" name="dataFimFiltro" value="<%= Formatador.formatarData(liqRejeBean.getDataPesqFinal()) %>">
		<input type="hidden" name="cedenteFiltro" value="<%= liqRejeBean.getCedenteOrigemSTR()%>">
		<input type="hidden" name="bancoFiltro" value="<%= liqRejeBean.getBancoOrigemSTR() %>">
		<input type="hidden" name="ispbFiltro" value="<%= liqRejeBean.getISPBOrigem().toString() %>">
		<input type="hidden" name="agenciaFiltro" value="<%= liqRejeBean.getAgenciaOrigemSTR() %>">
		<input type="hidden" name="paginaFiltro" value="<%= pagfiltro %>">
		<input type="hidden" name="processarFiltro" value="N">
		

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
				<td valign="top" width="5%" height="14" align="left">&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Data do Recebimento Inicial: </td>
              <td class="textoValor" width="26%"><%= Formatador.formatarData(liqRejeBean.getDataPesq()) %></td>
              <td class="textoTitulo" width="17%">Banco de Origem: </td>
              <%if(liqRejeBean.getBancoOrigem()>0)  {%>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(liqRejeBean.getBancoOrigem(),3) %></td>
              <%} %> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Data do Recebimento Final: </td>
              <td class="textoValor" width="26%"><%= Formatador.formatarData(liqRejeBean.getDataPesqFinal())%></td> 
              <td class="textoTitulo" width="17%"> ISPB de Origem:</td>
              <%if (liqRejeBean.getISPBOrigem()>0){ %>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(liqRejeBean.getISPBOrigem(),8) %></td>
              <%}else{ %>
               <td class="textoValor" width="26%">&nbsp;</td>
              <%} %>            </tr>
            
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <%if (liqRejeBean.getCedenteOrigem()>0){ %>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(liqRejeBean.getCedenteOrigem(),6)%></td>
              <%}else{ %>
               <td class="textoValor" width="26%">&nbsp;</td>
              <%} %>
              
              <td class="textoTitulo" width="17%">Agência de Origem: </td>
              <%if (liqRejeBean.getAgenciaOrigem()>0){ %>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda( liqRejeBean.getAgenciaOrigem(),4) %></td>
              <%}else{ %>
               <td class="textoValor" width="26%">&nbsp;</td>
              <%} %>
              
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
              <td colspan="4">&nbsp;</td>
            </tr>
						<tr>
							<td colspan="4">
								<table width="777" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    
								    <td nowrap width="2%" align="center">&nbsp;</td>
									<td nowrap width="5%" align="center">Data Rec</td>
								    <td nowrap width="5%" align="center">Banco</td>
								    <td nowrap width="5%" align="center">ISPB</td>
								    <td nowrap width="5%" align="center">Agência</td>
 								    <td nowrap width="5%" align="center">Hora Rec</td>
								    <td nowrap width="10%" align="center">Seq</td>
								    <td nowrap width="10%" align="center">Cedente</td>
								    <td nowrap width="15%" align="center">Nosso Número</td>
								    <td nowrap width="10%" align="right">Valor Recebido</td>
								    <td nowrap width="05%" align="left">Situação</td>
								    
								  </tr>

							<%
									LiquidacoesSTRBean occ = new LiquidacoesSTRBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (LiquidacoesSTRBean) lista.get(i);
							%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="2%" align="center">
								    	<input type="radio" name="radioSTR" onclick="javascript:clickRadio('<%=occ.getDataRecebimento() %>','<%=occ.getBanco()%>','<%=occ.getHoraRecebimento()%>','<%=occ.getSequencial()%>');">
								    </td>
								    <td nowrap align="center"><%= occ.getDataRecebimento() %></td>
 								    <td nowrap align="center"><%= occ.getBanco() %></td>
 								    <td nowrap align="center"><%= Util.zerosEsquerda(occ.getISPBOrigem(),8)  %></td>
 								    <td nowrap align="center"><%= occ.getAgencia() %></td>
 								    <td nowrap align="center"><%= occ.getHoraRecebimento() %></td>
								    <td nowrap align="center"><%= occ.getSequencial() %></td>
								    <td nowrap align="center"><%= occ.getCedente() %></td>
								    <td nowrap align="center"><%= occ.getNossoNumero() %></td>
								    <td nowrap width="10%" align="right"><%= occ.getValorRecebido()%></td>
								    <td nowrap align="left"><%=  occ.getDeSituacao() %> </td>
								  </tr>
							<%  } %>								  

 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="11" align="center">
										
											<%String pageName =ConsultaLiqStrManterEstrategia.PAGE_LISTAR_RECEBIDAS;%>
										  	<s:paginacao		estrategia="<%=ConsultaLiqStrManterEstrategia.STRATEGY_LISTA_RECEBIDAS %>" />
										
											
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="11">
	                    <p align="center">
	                    	
	                    	<s:Button name="buttonConsultar" value="Consultar" action="javascript:formSubmit_Consultar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.liquidacoesSTR.consultar" />
	                    	<s:Button name="buttonVoltar" value="Voltar" action="javascript: voltar();"/>
	                    </p>
	                  </td>
	                </tr>
 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
 	                <tr> 
	                  <td colspan="11" class="textoValor">

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


			
			function formSubmit_Consultar() {
				
				
					document.frmMain.estrategia.value = "consulta.ConsultaLiqSTRRecebida";
	     		    document.frmMain.submit();			
				

			}

			
	    	function voltar(){
	    		document.frmMain.estrategia.value = "consulta.ConsultaLiqStrIniciarRecebidas";
				document.frmMain.submit();
	    	}

      		function clickRadio(data, banco, hora, sequencial) {
      			document.frmMain.dataRecebimento.value = data;
      			document.frmMain.banco.value = banco;
      			document.frmMain.horaRecebimento.value = hora;
      			document.frmMain.sequencial.value = sequencial;
      			

      		}

		</script>

	</s:FormStrategy>
</p:Document>
</html>