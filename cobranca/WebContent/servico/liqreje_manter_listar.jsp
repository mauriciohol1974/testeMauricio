<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Agosto de 2004
*Projeto CAIXA - SIGCB
*Componente: liqreje_manter_filtro.jsp - Java Server Pages
*Autor: Renato Kosaka Araujo - raraujo@sao.politec.com.br
*Ultima Atualização: 27/08/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.LiqRejeManterEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.LiqRejeManterFiltro"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

 	LiquidacoesRejeitadaBean liqRejeBean = (session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN)==null
 	                                        ? new LiquidacoesRejeitadaBean()
 	                                        :(LiquidacoesRejeitadaBean)session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(LiqRejeManterEstrategia.PAGINACAO_LIST);
	if(request.getParameter(LiqRejeManterEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(LiqRejeManterEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(LiqRejeManterEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(LiqRejeManterEstrategia.PAGINACAO_PAGE));
	}
	
	List lista = paginacao.getPage(paginaAtual);	
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="servico.LiqRejeManterFiltro" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Liquidações Rejeitadas >> Listar"/>

		<input type="hidden" name="<%=LiqRejeManterEstrategia.PAGINACAO_PAGE%>" value="">
		<input type="hidden" name="tipoOpcao" value="<%= liqRejeBean.getTipoOpcao() %>">
		<input type="hidden" name="registro">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
				<td valign="top" width="5%" height="14" align="left">&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Opção: </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getTipoOpcaoDescricao() %></td>
              <td class="textoTitulo" width="17%">PV Recebedor/Centralizador: </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getCodigoUnidadePVFormatado() %></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Meio Liquidação: </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getMeioLiquidacaoDescricao() %></td> 
              <td class="textoTitulo" width="17%">Data (a partir de): </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getDataInicialFormatada() %></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Liquidações Rejeitadas:
                <hr>
              </td>
            </tr>

            <tr>
              <td colspan="4">
                <div class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="6">&nbsp;</td>
                    </tr>
				            <tr> 
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioAcao" value="<%= LiqRejeManterEstrategia.ACAO_RECOMANDO %>">
				              </td>
				              <td class="textoTitulo" width="30%">Recomando</td>
				              <td class="textoValor" width="15%">&nbsp;</td>
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioAcao" value="<%= LiqRejeManterEstrategia.ACAO_ESTORNO %>">
				              </td>
				              <td class="textoTitulo" width="30%">Estorno</td>
				              <td class="textoValor" width="15%">&nbsp;</td>
                            </tr>
                            
                                <tr> 
                                  <td class="textoTitulo" width="2%">
                                    <input type="radio" name="radioAcao" value="<%= LiqRejeManterEstrategia.ACAO_RECOMANDO_ESPECIAL %>">
                                  </td>
                                  <td class="textoTitulo" width="30%">Recomando Especial</td>
                                  <td class="textoValor" width="15%">&nbsp;</td>
                                  <td class="textoTitulo" width="2%">
                                    <input type="radio" name="radioAcao" value="<%= LiqRejeManterEstrategia.ACAO_EXCLUIR %>">
                                  </td>
                                  <td class="textoTitulo" width="30%">Excluir</td>
                                  <td class="textoValor" width="15%">&nbsp;</td>
                                </tr>
                            
				            <tr> 
                      <td colspan="6">
                      	<div style="visibility: hidden"><input type="radio" name="radioAcao" value="<%= LiqRejeManterEstrategia.ACAO_CANCELAR %>" disabled></div>
                      </td>
                    </tr>
                  </table>
                </div>
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
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="1%" align="center">&nbsp;&nbsp;&nbsp;Data Ref.&nbsp;&nbsp;&nbsp;</td>
								    <td nowrap width="1%" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NSeq</td>
								    <td nowrap width="1%" align="right">&nbsp;Cedente</td>
 								    <td nowrap width="1%" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nosso Número</td>
								    <td nowrap width="1%" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Valor Recebido</td>
								    <td nowrap width="10%" align="left">Erro (*)</td>
								    <!-- Todos -->
<s:Visibility visible="<%= LiqRejeManterEstrategia.MEIO_TODOS.equals(liqRejeBean.getMeioLiquidacao()) %>">
								    <td nowrap width="10%" align="left">Meio Liq.</td>
</s:Visibility>
								    <!-- Compensacao -->
<s:Visibility visible="<%= LiqRejeManterEstrategia.MEIO_COMPENSACAO.equals(liqRejeBean.getMeioLiquidacao()) %>">
								    <td nowrap width="7%" align="left">Banco</td>
								    <td nowrap width="10%" align="left">Lote</td>
</s:Visibility>
								    <!-- Lotérico -->
<s:Visibility visible="<%= LiqRejeManterEstrategia.MEIO_LOTERICAS.equals(liqRejeBean.getMeioLiquidacao()) %>">
								    <td nowrap width="10%" align="left">Num. Lotérico</td>
								    <td nowrap width="7%" align="right">Lote</td>
</s:Visibility>								    
								    <!-- Resto -->
								    <td nowrap width="8%" align="right">Seq</td>
								    <td nowrap width="12%" align="left">Tipo de Carteira</td>
								    <td nowrap width="10%" align="right">Usuário</td>
								    <td nowrap width="10%" align="right">Parcela</td>
								  </tr>

							<%
									LiquidacoesRejeitadaBean occ = new LiquidacoesRejeitadaBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (LiquidacoesRejeitadaBean) lista.get(i);
							%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="2%" align="center">
								    	<input type="radio" name="radioRejeitadas" onclick="javascript:clickRadio('<%=occ.getRegistro()%>', '<%= occ.getTipoCarteira() %>');">
								    </td>
 								    <td nowrap width="1%" align="center"><%= occ.getDataReferenciaFormatada() %></td>
								    <td nowrap width="1%" align="right"><%= occ.getNumeroSequencia() %></td>
								    <td nowrap width="1%" align="right"><%= occ.getCodigoCedenteOriginalFormatado() %></td>
								    <td nowrap width="1%" align="right"><%= occ.getNossoNumeroOriginalFormatado() %></td>
								    <td nowrap width="1%" align="right"><%= occ.getValorRecebido() %></td>
								    <td nowrap width="10%" align="left">
								    		<div title="<%= occ.getMensagemErro() %>">
								    			<%= occ.getCodigoErro() %>
								    		</div>
								    </td>
								    <!-- Todos -->
<s:Visibility visible="<%= LiqRejeManterEstrategia.MEIO_TODOS.equals(liqRejeBean.getMeioLiquidacao()) %>">
								    <td nowrap width="10%" align="left"><%= occ.getMeioLiquidacaoDescricao() %></td>
</s:Visibility>
								    <!-- Compensacao -->
<s:Visibility visible="<%= LiqRejeManterEstrategia.MEIO_COMPENSACAO.equals(liqRejeBean.getMeioLiquidacao()) %>">
								    <td nowrap width="7%" align="left"><%= occ.getNumeroBanco() %></td>
								    <td nowrap width="10%" align="right"><%= occ.getNumeroLote() %></td>
</s:Visibility>
								    <!-- Lotérico -->
<s:Visibility visible="<%= LiqRejeManterEstrategia.MEIO_LOTERICAS.equals(liqRejeBean.getMeioLiquidacao()) %>">
								    <td nowrap width="10%" align="left"><%= occ.getNumeroLoterico() %></td>
								    <td nowrap width="7%" align="left"><%= occ.getNumeroLote() %></td>
</s:Visibility>								    
								    <td nowrap width="8%" align="right"><%= occ.getSequenciaLote() %></td>
								    <td nowrap width="12%" align="left"><%= occ.getDescricaoTipoCarteira() %></td>
								    <td nowrap width="10%" align="right"><%= occ.getUsuario()%></td>
								    <td nowrap width="10%" align="right"><%= occ.getParcela()%></td>
								  </tr>
							<%  } %>								  

 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="11" align="center">
											<% String pageName = LiqRejeManterEstrategia.PAGE_LISTAR;%>
										  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=pageName%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="11">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="right" colspan="11">
	                    <p align="center">
	                    	<s:Button name="buttonExecutarAcao" value="Executar Ação" action="javascript:formSubmit_Acao();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.liquidacoes.acoes" />
	                    	<s:Button name="buttonCancelarAcao" value="Cancelar Ação" action="javascript:formSubmit_CancelarAcao();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.liquidacoes.acoes" />
	                    	<s:Button name="buttonConsultar" value="Consultar" action="javascript:formSubmit_Consultar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.liquidacoes.consultar" />
	                    	<s:Button name="buttonVoltar" value="Voltar" action="javascript: formSubmit_Voltar();"/>
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
				document.frmMain.estrategia.value = "servico.LiqRejeAcaoIniciar";
				
				if (validaRadioButton(document.frmMain.radioAcao, 'Ação a ser executada')) {
					if (validaSubmit()) {

						var confirma = true;
						if (document.frmMain.radioAcao[3].checked) { // Exclusao
							confirma = confirm(conf('102', 'Liquidação Rejeitada'));
						} else if (document.frmMain.radioAcao[1].checked) { // Estorno
							confirma = confirm(conf('108', ''));
						}
						
						if (confirma) {
			      	document.frmMain.submit();
			      }
					}
				}
			}
			
			function formSubmit_CancelarAcao() {
				var tipoOpcao = document.frmMain.tipoOpcao.value;
				var status = "";
				if (tipoOpcao == '<%= LiqRejeManterEstrategia.OPCAO_RECOMANDADAS %>') {
					status = "Recomandada";
				} else if (tipoOpcao == '<%= LiqRejeManterEstrategia.OPCAO_RECOMANDADAS_ESPECIAL %>') {
					status = "Recomandada Especial";
				} else if (tipoOpcao == '<%= LiqRejeManterEstrategia.OPCAO_ESTORNADAS %>') {
					status = "Estornada";
				} else if (tipoOpcao == '<%= LiqRejeManterEstrategia.OPCAO_EXCLUIDAS %>') {
					status = "Excluída";
				}
				
				var confirma = confirm(conf("109", status));
				
				if (confirma) {
					document.frmMain.estrategia.value = "servico.LiqRejeAcaoIniciar";
					
					// passando a acao de cancelar pelo primeiro radio button
					document.frmMain.radioAcao[4].disabled = false;
					document.frmMain.radioAcao[4].checked = true;
	
					if (validaSubmit()) {
		      	document.frmMain.submit();				
					}
				}
			}
			
			function formSubmit_Consultar() {
				document.frmMain.estrategia.value = "servico.LiqRejeConsultarIniciar";
				if (validaSubmit()) {
	      	document.frmMain.submit();				
				}
			}

			function formSubmit_Voltar() {
				document.frmMain.estrategia.value = "servico.LiqRejeManterIniciar";
        document.frmMain.fluxo.value = "voltar";				
				document.frmMain.submit();
			}
			
			function validaSubmit() {
				if (document.frmMain.radioRejeitadas[0] != null) {
					if (!validaRadioButtonMsg(document.frmMain.radioRejeitadas, '', "003")) {
						return false;
					}
				} else if (document.frmMain.radioRejeitadas != null) {
					if (!document.frmMain.radioRejeitadas.checked) {
						msg('003', '');
						return false;
					}
				} else {
					return false;
				}
			
		    return true;
		  }

			//
			// Desabilita Radios de acodo com o Tipo Opcao
			//
			function verificaTipoOpcao() {
				var tipoOpcao = document.frmMain.tipoOpcao.value;
				switch (parseInt(tipoOpcao)) {
					case <%= LiqRejeManterEstrategia.OPCAO_ABERTO %>:
						document.frmMain.buttonCancelarAcao.disabled = true;
                     document.frmMain.radioAcao[2].disabled = true;
						document.frmMain.radioAcao[3].disabled = true;
						break;
				
					case <%= LiqRejeManterEstrategia.OPCAO_RECOMANDADAS %>:
					case <%= LiqRejeManterEstrategia.OPCAO_RECOMANDADAS_ESPECIAL %>:
					case <%= LiqRejeManterEstrategia.OPCAO_ESTORNADAS %>:
					case <%= LiqRejeManterEstrategia.OPCAO_EXCLUIDAS %>:
						document.frmMain.radioAcao[0].disabled = true;
						document.frmMain.radioAcao[1].disabled = true;
						document.frmMain.radioAcao[2].disabled = true;
						document.frmMain.radioAcao[3].disabled = true;
						document.frmMain.buttonExecutarAcao.disabled = true;
						break;
					
					case <%= LiqRejeManterEstrategia.OPCAO_RECOMANDOS_PROCESSADOS %>:
					case <%= LiqRejeManterEstrategia.OPCAO_RECOMANDADAS_ESPECIAIS_PROCESSADAS %>:
					case <%= LiqRejeManterEstrategia.OPCAO_ESTORNOS_PROCESSADOS %>:
					case <%= LiqRejeManterEstrategia.OPCAO_EXCLUIDAS_PROCESSADAS %>:
						document.frmMain.radioAcao[0].disabled = true;
						document.frmMain.radioAcao[1].disabled = true;
						document.frmMain.radioAcao[2].disabled = true;
						document.frmMain.radioAcao[3].disabled = true;
						document.frmMain.buttonExecutarAcao.disabled = true;
						document.frmMain.buttonCancelarAcao.disabled = true;
						break;
				}
			}

			//
			// Desabilita Radios dependendo do tipoCarteira e seta registro em input hidden
			//
      function clickRadio(registro, tipoCarteira) {
      	switch (parseInt(tipoCarteira)) {
      		case <%= LiqRejeManterEstrategia.CARTEIRA_REGISTRO_SINCE %>:
						document.frmMain.radioAcao[0].disabled = false;
						document.frmMain.radioAcao[1].disabled = false;

						document.frmMain.radioAcao[2].disabled = true; // Recomando Especial
						document.frmMain.radioAcao[2].checked = false;

						document.frmMain.radioAcao[3].disabled = true; // Excluir
						document.frmMain.radioAcao[3].checked = false;

						break;
      		case <%= LiqRejeManterEstrategia.CARTEIRA_SEM_REGISTRO_SINCE %>:
						document.frmMain.radioAcao[0].disabled = false;
						document.frmMain.radioAcao[1].disabled = false;
						document.frmMain.radioAcao[3].disabled = false;

						document.frmMain.radioAcao[2].disabled = true; // Recomando Especial
						document.frmMain.radioAcao[2].checked = false;

						break;
					default:
						document.frmMain.radioAcao[0].disabled = false;
						document.frmMain.radioAcao[1].disabled = false;
						document.frmMain.radioAcao[2].disabled = false;
						document.frmMain.radioAcao[3].disabled = false;
						break;
      	}
      	// Tipo Opcao tem prioridade sobre o Tipo Carteira
      	// para desabilitar radios
				verificaTipoOpcao();
				
				document.frmMain.registro.value = registro;
      }
		</script>

	</s:FormStrategy>
</p:Document>
</html>