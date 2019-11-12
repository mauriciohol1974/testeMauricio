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
		estrategia="servico.LiqRejeAcaoRecAltValorFinalizar" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Liquidações Rejeitadas >> Recomando Especial"/>
		
		<input type="hidden" name="radioAcao" value="<%=LiqRejeManterEstrategia.ACAO_RECOMANDO_ESPECIAL%>">
		<input type="hidden" name="registro" value="<%= dataBean.getRegistro() %>">
				        
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

<%
	String codigoCedenteCorrigido = dataBean.getCodigoCedenteCorrigido()==null?"":dataBean.getCodigoCedenteCorrigido().toString();
	String nossoNumeroCorrigido = dataBean.getNossoNumeroCorrigido()==null?"":dataBean.getNossoNumeroCorrigido().toString();
	String numeroLoteCorreto = dataBean.getNumeroLoteCorreto()==null?"":dataBean.getNumeroLoteCorreto().toString();
	String valorCorrigido = dataBean.getValorCorrigido()==null?"":dataBean.getValorCorrigido().toString();
%>
            <tr>
              <td class="textoTitulo" width="17%">Cedente Corrigido: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="codigoCedenteCorrigido" value="<%= codigoCedenteCorrigido %>" size="7" maxlength="7"
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumeroCorrigido);"/>
							</td>
              <td class="textoTitulo" width="17%">Nosso Número Corrigido: </td>
              <td class="textoValor" width="26%">
              	<%//EAM 12/09 - Alterado NN de 17 p/ 18%>
              	<p:InputNumerico CLASS="inputtext" name="nossoNumeroCorrigido" value="<%= nossoNumeroCorrigido %>" size="30" maxlength="18"
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.numeroLoteCorreto);"/>
							</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Lote Corrigido: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="numeroLoteCorreto" value="<%= numeroLoteCorreto %>" size="15" maxlength="9"
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.valorCorrigido);"/>
              </td>
              <td class="textoTitulo" width="17%">Valor Corrigido: </td>
              <td class="textoValor" width="26%">
              	<p:InputCurrency CLASS="inputtext" name="valorCorrigido" value="<%= valorCorrigido %>" size="30" maxlength="15"
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>
							</td>
            </tr>
            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center">
									<s:Button name="Confirmar" action="javascript:formSubmit();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.liquidacoes.acoes" />
									<s:Button name="Voltar" action="javascript:formSubmit_Voltar();"/>
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
				setFirstFieldFocus();
			}
			
    	function formSubmit_Voltar() {
    		var confirma = confirm(conf('103', ''));
    		if (confirma) {
					document.frmMain.estrategia.value = "servico.LiqRejeManterFiltro";
	        document.frmMain.fluxo.value = "voltar";				
					document.frmMain.submit();
				}
			}
			
	    function formSubmit() {
	    	if (validaSubmit()) {
		    	var confirma = confirm(conf('111', ''));
		    	if (confirma) {
						document.frmMain.submit();
					}
				}
			}

			function validaSubmit() {
		    if (!validaCampoObrigatorio(document.frmMain.codigoCedenteCorrigido, 'Cedente Corrigido')){
				  return false;
		    }
		    if (!validaCampoObrigatorio(document.frmMain.nossoNumeroCorrigido, 'Nosso Número Corrigido')){
				  return false;
		    }
		    if (!validaCampoObrigatorio(document.frmMain.numeroLoteCorreto, 'Lote Corrigido')){
				  return false;
		    }
		    if (!validaCampoObrigatorio(document.frmMain.valorCorrigido, 'Valor Corrigido')){
				  return false;
		    }
				<%//EAM 08/11 - INI%>
		    if(!validaValorZero(document.frmMain.valorCorrigido, 'Valor Corrigido')){
				  return false;				
				}
				<%//EAM 08/11 - FIM%>
		    return true;
		  }
    </script>
	</s:FormStrategy>
</p:Document>
</html>