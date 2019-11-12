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
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>

<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

 	LiquidacoesRejeitadaBean filtroBean = (session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN)==null
 	                                       ? new LiquidacoesRejeitadaBean()
 	                                       :(LiquidacoesRejeitadaBean)session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN));

 	LiquidacoesRejeitadaBean dataBean = (session.getAttribute(LiqRejeManterEstrategia.DATA_BEAN)==null
 	                                     ? new LiquidacoesRejeitadaBean()
 	                                     :(LiquidacoesRejeitadaBean)session.getAttribute(LiqRejeManterEstrategia.DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="servico.LiqRejeManterFiltro" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Liquidações Rejeitadas >> Consultar"/>

		<input type="hidden" name="radioAcao">
		<input type="hidden" name="registro" value="<%= dataBean.getRegistro() %>">
		<input type="hidden" name="tipoOpcao" value="<%= filtroBean.getTipoOpcao() %>">		
        
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Opção: </td>
              <td class="textoValor" width="26%"><%= filtroBean.getTipoOpcaoDescricao() %></td>
              <td class="textoTitulo" width="17%">PV Recebedor/Centralizador: </td>
              <td class="textoValor" width="26%"><%= filtroBean.getCodigoUnidadePVFormatado() %></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Meio Liquidação: </td>
              <td class="textoValor" width="26%"><%= dataBean.getMeioLiquidacaoDescricao() %></td> 
              <td class="textoTitulo" width="17%">Data (a partir de): </td>
              <td class="textoValor" width="26%"><%= filtroBean.getDataInicialFormatada() %></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Data de Referência: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDataReferenciaFormatada() %></td>
              <td class="textoTitulo" width="17%">Sequência: </td>
              <td class="textoValor" width="26%"><%= dataBean.getNumeroSequencia() %></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Liquidação Rejeitada:
                <hr>
              </td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%= dataBean.getCodigoCedenteOriginalFormatado() %></td> 
              <td class="textoTitulo" width="17%">Nosso Número: </td>
              <td class="textoValor" width="26%"><%= dataBean.getNossoNumeroOriginalFormatado() %></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Valor Recebido: </td>
              <td class="textoValor" width="26%"><%= dataBean.getValorRecebido() %></td> 
              <td class="textoTitulo" width="17%">Data Situação Anterior: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDataSituacaoAnteriorFormatada() %></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Código do Erro: </td>
              <td class="textoValor" width="26%"><%= dataBean.getCodigoErro() %></td> 
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Erro: </td>
              <td class="textoValor" width="26%" colspan="3"><%= dataBean.getMensagemErro() %></td>
            </tr>
            
            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Número do Lote: </td>
              <td class="textoValor" width="26%"><%= dataBean.getNumeroLote() %></td>
              <td class="textoTitulo" width="17%">Sequência Lote: </td>
              <td class="textoValor" width="26%"><%= dataBean.getSequenciaLote() %></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Data de Movimento: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDataMovimentoFormatada() %></td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            
            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Dados de Recomando:
                <hr>
              </td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Cedente Corrigido: </td>
              <td class="textoValor" width="26%"><%= dataBean.getCodigoCedenteCorrigidoFormatado() %></td>
              <td class="textoTitulo" width="17%">Nosso Número Corrigido: </td>
              <td class="textoValor" width="26%"><%= dataBean.getNossoNumeroCorrigidoFormatado() %></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Lote Corrigido: </td>
              <td class="textoValor" width="26%"><%= Util.toStr(dataBean.getNumeroLoteCorreto()) %></td>
              <td class="textoTitulo" width="17%">Valor Corrigido: </td>
              <td class="textoValor" width="26%"><%= Util.toStr(dataBean.getValorCorrigido()) %></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center">
                	<s:Button name="recomando" value="Recomando" action="javascript:formSubmit_Recomando();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.liquidacoes.acoes" />

                	<!-- Temporariamente desabilitado -->
                	<s:Button name="recomando_especial" value="Recomando Especial" action="javascript:formSubmit_RecomandoEspecial();" disabled="true" />
                	
                	<s:Button name="estorno" value="Estorno" action="javascript:formSubmit_Estorno();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.liquidacoes.acoes" />
                	
                	<!-- Temporariamente desabilitado -->
                	<s:Button name="excluir" value="Excluir" action="javascript:formSubmit_Excluir();" disabled="true" />
                	
                	<s:Button name="cancelar_acao" value="Cancelar Ação" action="javascript:formSubmit_CancelarAcao();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.liquidacoes.acoes" />
					<s:Button name="buttonVoltar" value="Voltar" action="javascript: formSubmit_Voltar();"/>
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
    		verificaTipoCarteira();
    		verificaTipoOpcao();
    	}

    	function formSubmit_Voltar() {
				document.frmMain.estrategia.value = "servico.LiqRejeManterFiltro";
        document.frmMain.fluxo.value = "voltar";				
				document.frmMain.submit();
			}

			function formSubmit_Excluir() {
				var confirma = confirm(conf('102', 'Liquidação Rejeitada'));
				if (confirma) {
					document.frmMain.estrategia.value = "servico.LiqRejeAcaoIniciar";
					document.frmMain.radioAcao.value = "<%= LiqRejeManterEstrategia.ACAO_EXCLUIR %>";
					document.frmMain.submit();
				}
			}

			function formSubmit_Estorno() {
				var confirma = confirm(conf('108', ''));
				if (confirma) {
					document.frmMain.estrategia.value = "servico.LiqRejeAcaoIniciar";
					document.frmMain.radioAcao.value = "<%= LiqRejeManterEstrategia.ACAO_ESTORNO %>";
					document.frmMain.submit();
				}
			}

			function formSubmit_Recomando() {
				document.frmMain.estrategia.value = "servico.LiqRejeAcaoIniciar";
				document.frmMain.radioAcao.value = "<%= LiqRejeManterEstrategia.ACAO_RECOMANDO %>";
				document.frmMain.submit();
			}

			function formSubmit_RecomandoEspecial() {
				document.frmMain.estrategia.value = "servico.LiqRejeAcaoIniciar";
				document.frmMain.radioAcao.value = "<%= LiqRejeManterEstrategia.ACAO_RECOMANDO_ESPECIAL %>";
				document.frmMain.submit();
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
				
				var confirma = confirm("Esta Liquidação encontra-se " + status + ". Deseja realmente cancelar essa Ação?");
				
				if (confirma) {
					document.frmMain.estrategia.value = "servico.LiqRejeAcaoIniciar";
					document.frmMain.radioAcao.value = "<%= LiqRejeManterEstrategia.ACAO_CANCELAR %>";
					document.frmMain.submit();
				}
			}

			//
			// Desabilita Radios de acodo com o Tipo Opcao
			//
			function verificaTipoOpcao() {
				var tipoOpcao = document.frmMain.tipoOpcao.value;
				switch (parseInt(tipoOpcao)) {
					case <%= LiqRejeManterEstrategia.OPCAO_ABERTO %>:
						document.frmMain.cancelar_acao.disabled = true;
						break;
				
					case <%= LiqRejeManterEstrategia.OPCAO_RECOMANDADAS %>:
					case <%= LiqRejeManterEstrategia.OPCAO_RECOMANDADAS_ESPECIAL %>:
					case <%= LiqRejeManterEstrategia.OPCAO_ESTORNADAS %>:
					case <%= LiqRejeManterEstrategia.OPCAO_EXCLUIDAS %>:
						document.frmMain.recomando.disabled = true;
						document.frmMain.recomando_especial.disabled = true;
						document.frmMain.excluir.disabled = true;
						document.frmMain.estorno.disabled = true;
						break;
					
					case <%= LiqRejeManterEstrategia.OPCAO_RECOMANDOS_PROCESSADOS %>:
					case <%= LiqRejeManterEstrategia.OPCAO_RECOMANDADAS_ESPECIAIS_PROCESSADAS %>:
					case <%= LiqRejeManterEstrategia.OPCAO_ESTORNOS_PROCESSADOS %>:
					case <%= LiqRejeManterEstrategia.OPCAO_EXCLUIDAS_PROCESSADAS %>:
						document.frmMain.recomando.disabled = true;
						document.frmMain.recomando_especial.disabled = true;
						document.frmMain.excluir.disabled = true;
						document.frmMain.estorno.disabled = true;
						document.frmMain.cancelar_acao.disabled = true;
						break;
				}
			}
			
			function verificaTipoCarteira() {
				var tipoCarteira = <%= dataBean.getTipoCarteira() %>;
      	switch (parseInt(tipoCarteira)) {
      		case <%= LiqRejeManterEstrategia.CARTEIRA_REGISTRO_SINCE %>:
						document.frmMain.recomando_especial.disabled = true; // Recomando Especial
						document.frmMain.excluir.disabled = true; // Excluir
						break;
      		case <%= LiqRejeManterEstrategia.CARTEIRA_SEM_REGISTRO_SINCE %>:
						document.frmMain.recomando_especial.disabled = true; // Recomando Especial
						break;
					default:
						break;
      	}
			}
    </script>
    
	</s:FormStrategy>
</p:Document>
</html>