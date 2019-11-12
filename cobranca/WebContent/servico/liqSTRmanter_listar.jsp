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
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

	LiquidacoesSTRBean liqRejeBean = (session.getAttribute(LiqStrManterEstrategia.FILTRO_BEAN)==null
 	                                        ? new LiquidacoesSTRBean()
 	                                        :(LiquidacoesSTRBean)session.getAttribute(LiqStrManterEstrategia.FILTRO_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(LiqStrManterEstrategia.PAGINACAO_LIST);
	if(request.getParameter(LiqStrManterEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(LiqStrManterEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(LiqStrManterEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(LiqStrManterEstrategia.PAGINACAO_PAGE));
	}
	
	List lista = paginacao.getPage(paginaAtual);	
	
	
    String bancoFiltro = (String) request.getAttribute("bancoFiltro");
    String ISPBFiltro =  (String) request.getAttribute("ISPBFiltro");
    String agenciaFiltro =  (String)  request.getAttribute("agenciaFiltro");
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="servico.LiqStrRecomando" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Liquidações STR >> Listar"/>

		<input type="hidden" name="<%=LiqStrManterEstrategia.PAGINACAO_PAGE%>" value="<%= paginaAtual%>" >
		
		<input type="hidden" name="opcao" value="<%= liqRejeBean.getOpcao() %>">
		<input type="hidden" name="banco" value="">
		<input type="hidden" name="dataRecebimento" value="">
		<input type="hidden" name="horaRecebimento" value="">
		<input type="hidden" name="sequencial" value="">
		<input type="hidden" name="acaoExecutar" value="<%= liqRejeBean.getOpcao() %>">
		
		<input type="hidden" name="bancoFiltro" value="<%=bancoFiltro %>">
		<input type="hidden" name="ISPBFiltro" value="<%=ISPBFiltro %>">
		<input type="hidden" name="agenciaFiltro" value="<%=agenciaFiltro %>">
		

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
				<td valign="top" width="5%" height="14" align="left">&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Opção: </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getDescOpcao() %></td>
              <td class="textoTitulo" width="17%">Banco de Origem: </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getBancoOrigemSTR() %></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getCedenteOrigemSTR()%></td> 
              <td class="textoTitulo" width="17%">ISPB de Origem: </td>
              <%if (liqRejeBean.getISPBOrigem()>0){ %>
              <td class="textoValor" width="26%"><%= Util.zerosEsquerda(liqRejeBean.getISPBOrigem(),8) %></td>
              <%}else{ %>
              <td>&nbsp;</td>
              <%} %>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td> 
              <td class="textoTitulo" width="17%">Agência de Origem: </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getAgenciaOrigemSTR() %></td> 
              
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
								    <%/*Não Retirar o &nbsp;, pois o mesmo é necessário para manter as colunas na posição
								    	 *correta para o funcionamento do QARun no HMP */ %>
								    	 
								    	 
								    <td nowrap width="2%" align="center">&nbsp;<div style="display:none;"><input  type="radio" name="radioSTR" onclick="javascript:clickRadio('0','0','0','0');"></div></td>
 								    <td nowrap width="10%" align="center">Data Recebimento</td>
								    <td nowrap width="5%" align="center">Banco</td>
								    <td nowrap width="10%" align="center">ISPB</td>
								    <td nowrap width="5%" align="center">Agência</td>
 								    <td nowrap width="7%" align="center">Hora Recebimento</td>
								    <td nowrap width="7%" align="center">Seq</td>
								    <td nowrap width="7%" align="center">Cedente</td>
								    <td nowrap width="15%" align="center">Nosso Número</td>
								    <td nowrap width="10%" align="right">Valor Recebido</td>
								    <td nowrap width="4%" align="left">Erro (*)</td>
								    
								  </tr>

							<%
									LiquidacoesSTRBean occ = new LiquidacoesSTRBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (LiquidacoesSTRBean) lista.get(i);
							%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="2%" align="center">
								    	<input type="radio" name="radioSTR" onclick="javascript:clickRadio('<%=occ.getBanco()%>','<%=occ.getDataRecebimento()%>','<%=occ.getHoraRecebimento()%>','<%=occ.getSequencial()%>');">
								    </td>
 								    <td nowrap align="center"><%= occ.getDataRecebimento() %></td>
 								    <td nowrap align="center"><%= occ.getBanco() %></td>
 								    <td nowrap align="center"><%=  Util.zerosEsquerda(occ.getISPBOrigem(),8) %></td>
 								    <td nowrap align="center"><%= occ.getAgencia() %></td>
 								    <td nowrap align="center"><%= occ.getHoraRecebimento() %></td>
								    <td nowrap align="center"><%= occ.getSequencial() %></td>
								    <td nowrap align="center"><%= occ.getCedente() %></td>
								    <td nowrap align="center"><%= occ.getNossoNumero() %></td>
								    <td nowrap align="right"><%= occ.getValorRecebido() %></td>
								    <td nowrap align="left"><div title="<%=occ.getDescErro()  %>"><%=  occ.getCodErro() %></div>
								    </td>
								  </tr>
							<%  } %>								  

 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="11" align="center">
										
										  <% String pageName = LiqStrManterEstrategia.PAGE_LISTAR;%>
										  <s:paginacao		estrategia="<%=LiqStrManterEstrategia.STRATEGY_LISTA %>" />
											
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="11">
	                    <p align="center">
	                    	<s:Button name="buttonExecutarAcao" value="Executar Ação" action="javascript:formSubmit_Acao();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.liquidacoesSTR.acoes" />
	                    	<s:Button name="buttonCancelarAcao" value="Cancelar Ação" action="javascript:formSubmit_CancelarAcao();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.liquidacoesSTR.cancelar" />
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
	                  	<p align="center">
	                  	(*) Passe o mouse sobre o código do Erro para visualizar a descrição
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

			function formSubmit_Acao() {
				
				if (validaRadioButton(document.frmMain.radioSTR, 'Ação a ser executada')) {
					document.frmMain.estrategia.value = "servico.LiqStrRecomando";
	     		    document.frmMain.submit();				
				}
				
				
			}
			
			function formSubmit_CancelarAcao() {
				
				
				if (validaRadioButton(document.frmMain.radioSTR, 'Ação a ser executada')) {
					document.frmMain.estrategia.value = "servico.LiqStrRecomando";
	     		    document.frmMain.submit();				
				}

					//document.frmMain.acaoExecutar.value ="4";
					//document.frmMain.estrategia.value = "servico.LiqStrRecomando";
	     		    //document.frmMain.submit();	
				
				
			}
			
			function formSubmit_Consultar() {
				
				
					document.frmMain.estrategia.value = "servico.LiqStrConsultar";
	     		    document.frmMain.submit();			
				

			}

			
	    	function voltar(){
	    		document.frmMain.estrategia.value = "servico.LiqStrIniciar";
				document.frmMain.submit();
	    	}

			
						//
			// Desabilita Radios de acodo com o Tipo Opcao
			//
			function verificaTipoOpcao() {
											
				
				if (document.frmMain.opcao.value=="1"){
					document.frmMain.buttonExecutarAcao.disabled = false;
					document.frmMain.buttonCancelarAcao.disabled = true;
				}else if (document.frmMain.opcao.value=="2"){
					document.frmMain.buttonExecutarAcao.disabled = true;
					document.frmMain.buttonCancelarAcao.disabled = false;
				}else if (document.frmMain.opcao.value=="3"){
					document.frmMain.buttonExecutarAcao.disabled = false;
					document.frmMain.buttonCancelarAcao.disabled = true;
				}else if (document.frmMain.opcao.value=="4"){
					document.frmMain.buttonExecutarAcao.disabled = true;
					document.frmMain.buttonCancelarAcao.disabled = false;
				}else if (document.frmMain.opcao.value=="5"){
					document.frmMain.buttonExecutarAcao.disabled = false;
					document.frmMain.buttonCancelarAcao.disabled = true;
				}else{
					document.frmMain.buttonExecutarAcao.disabled = true;
					document.frmMain.buttonCancelarAcao.disabled = false;
				}
			}

			//
			// Desabilita Radios dependendo do tipoCarteira e seta registro em input hidden
			//
      		function clickRadio(banco, data, hora, sequencial) {
      			document.frmMain.banco.value = banco;
      			document.frmMain.dataRecebimento.value = data;
      			document.frmMain.horaRecebimento.value = hora;
      			document.frmMain.sequencial.value = sequencial;
      			

      		}


		</script>

	</s:FormStrategy>
</p:Document>
</html>