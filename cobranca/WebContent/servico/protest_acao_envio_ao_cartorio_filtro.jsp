
<%
/***********************************************
*Probank / REDEASP02
*Projeto CAIXA - SIGCB
*Componente: protest_acao_envio_ao_cartorio_filtro.jsp - Java Server Pages
*Autor: Cristian Souza
*Data criação: Fev /2009
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ProtestEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
	TituloBean tituloBean = (session.getAttribute(ProtestEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(ProtestEstrategia.DATA_BEAN));	
	String acoesServicoTitulo  = Util.toStr(tituloBean.getAcoesServicoTitulo(), "1"); // Padrao 1 - Consultar
%>
<html>
<s:Header />
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=ProtestEstrategia.STRATEGY_ENVIO_AO_CARTORIO_FILTRO%>"
		fluxo="normal">
		<s:Menu />
		<s:Titulo name="<%=ProtestEstrategia.PAGE_ENVIO_AO_CARTORIO_INICIAR_TITLE%>" />
		<input type="hidden" name="dataSolicitacao" value="" />
		<input type="hidden" name="filtroSelecao" value="" />

    <table width="777" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="53" valign="middle" align="center">
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Unidade Cobradora:</td>
						<td class="textoValor" width="26%"><p:InputNumerico
							CLASS="inputtext" name="unidadeCobradora" size="5" maxlength="4"
							onFocus="javascript: prevFocus(this);"
							onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.acoesServicoTitulo);" />
						</td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Ação:</td>
						<td class="textoValor" width="26%"><s:ComboProtestoEnvioAoCartorioAcao
							name="acoesServicoTitulo"
							selectedValue="<%=acoesServicoTitulo%>"
							onChange='javascript:desabilitaDataSolicitacao()' /></td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="4" class="textoTitulo">Informar:
						<hr>
						</td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%"><input type="radio"
							name="rdDataTipoConsulta" 
							onclick="javascript:habilitaDigitacao(); radioNextFocus(document.frmMain.dataSolicitacaoInfo);">
						Data da Solicitação:</td>
						<td class="textoValor" width="26%"><p:InputDate
							name="dataSolicitacaoInfo" CLASS="inputtext" value=""
							onFocus="javascript: prevFocus(this);"
							onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataPrevisaoInfo);" />
						</td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%"><input type="radio"
							name="rdDataTipoConsulta"
							onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.dataPrevisaoInfo);">
							Data Previsão Protesto:</td>
						<td class="textoValor" width="26%"><p:InputDate
							name="dataPrevisaoInfo" CLASS="inputtext" value=""
							onFocus="javascript: prevFocus(this);"
							onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.unidadeCobradora);" />
						</td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>

					<tr>
						<td colspan="4">
						<p align="center"><input type="button" class="button"
							value="Ok" onclick="javascript:formSubmit();"></p>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

		<script>
      function inicia(){
			<%if (tituloBean.getFiltroSelecao() == 2){%>
				document.frmMain.dataPrevisaoInfo.value = "<%=(tituloBean.getDataSolicitacaoFormatada())%>"
				document.frmMain.rdDataTipoConsulta[1].checked = true;
				document.frmMain.dataSolicitacao.value="<%=(tituloBean.getDataSolicitacaoFormatada())%>";
				document.frmMain.filtroSelecao.value="2";
			<%}else if (tituloBean.getFiltroSelecao() == 1){%>
				document.frmMain.dataSolicitacaoInfo.value = "<%=(tituloBean.getDataSolicitacaoFormatada())%>"
				document.frmMain.rdDataTipoConsulta[0].checked = true;
				document.frmMain.dataSolicitacao.value="<%=(tituloBean.getDataSolicitacaoFormatada())%>";
				document.frmMain.filtroSelecao.value="1";
			<%}else{%>
				document.frmMain.rdDataTipoConsulta[0].checked = false;
				document.frmMain.rdDataTipoConsulta[1].checked = false;
				document.frmMain.dataPrevisaoInfo.disable=true;
				document.frmMain.dataSolicitacaoInfo.disable=true;
				document.frmMain.filtroSelecao.value="";
			<%}%>
			
			setFirstFieldFocus();
      }
      
      function desabilitaDataSolicitacao(){
		if (document.frmMain.acoesServicoTitulo.value != "1") {
			document.frmMain.dataSolicitacao.value="";
			document.frmMain.dataPrevisaoInfo.value="";
			document.frmMain.dataPrevisaoInfo.disabled=true;
			document.frmMain.dataSolicitacaoInfo.value="";
			document.frmMain.dataSolicitacaoInfo.disabled=true;
			document.frmMain.rdDataTipoConsulta[0].checked = false;
			document.frmMain.rdDataTipoConsulta[1].checked = false;
		}
      }

  	function habilitaDigitacao(){
		if (document.frmMain.rdDataTipoConsulta[0].checked){
			document.frmMain.dataPrevisaoInfo.disabled	= true;
			document.frmMain.dataSolicitacaoInfo.disabled = false;
			document.frmMain.dataPrevisaoInfo.value = "";
			document.frmMain.filtroSelecao.value = "1";
			
		} else if(document.frmMain.rdDataTipoConsulta[1].checked){
			document.frmMain.dataPrevisaoInfo.disabled	= false;
			document.frmMain.dataSolicitacaoInfo.disabled = true;
			document.frmMain.dataSolicitacaoInfo.value = "";
			document.frmMain.filtroSelecao.value = "2";
		}
	}
      
      
	function validaSubmit(){          	
		
   			if(document.frmMain.filtroSelecao.value == "1"){
   	   			if(!validaCampoObrigatorio(document.frmMain.dataSolicitacaoInfo, "Data da Solicitação"))
   	   	   			return false;
   	   			else
   					document.frmMain.dataSolicitacao.value =  document.frmMain.dataSolicitacaoInfo.value;
   				
   			}else{
   	   			if(!validaCampoObrigatorio(document.frmMain.dataPrevisaoInfo, "Data da Previsão"))
   	   	   			return false;
   	   			else
   	   	   			document.frmMain.dataSolicitacao.value =  document.frmMain.dataPrevisaoInfo.value;
   			}

   			if (!validaData(document.frmMain.dataSolicitacao,'')){
   				alert("Data invalida.");
   				return false;
   			}
	    
    	if(!validaCampoObrigatorio(document.frmMain.unidadeCobradora, "Unidade Cobradora")) {
    		return false;
    	}
		return true;
   	}

  	function formSubmit(){
  		if(validaSubmit()){
  			document.frmMain.submit();
  		}
  	}
	
    </script>
	</s:FormStrategy>
</p:Document>
</html>
