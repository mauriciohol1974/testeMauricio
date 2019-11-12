<%
/***********************************************
*Probank / REDEASP02
*Projeto CAIXA - SIGCB
*Componente: protest_acao_susta_ger_arquivo_filtro.jsp - Java Server Pages
*Autor: Cristian Souza
*Data criação: Jan /2009
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="java.util.Calendar"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ProtestEstrategia"%>

<%
	TituloBean tituloBean = (session.getAttribute(ProtestEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(ProtestEstrategia.DATA_BEAN));	

	Long filtroSelecao = tituloBean.getFiltroSelecao()==null?new Long(1):tituloBean.getFiltroSelecao();

%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ProtestEstrategia.STRATEGY_MANTER_SUSTA_GER_ARQUIVO_FILTRO%>"  
		fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=ProtestEstrategia.PAGE_SUSTA_GER_ARQUIVO_INICIAR_TITLE%>"/>
		
		<input type="hidden" name = "acoesServicoTitulo" value="">
		<input type="hidden" name = "filtroSelecao" value="<%=filtroSelecao%>">
		<input type="hidden" name = "filtroDescricaoSituacao" value="">
		<input type="hidden" name = "filtroDescricaoClassificacao" value="">
		<input type="hidden" name = "filtroVoltarListarConsolidado" value="0">
		<input type="hidden" name = "filtroVoltarListarTitulo" value="0">
		<input type="hidden" name = "filtroVoltarAcao" value="0">
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr>
			  <td colspan="5">&nbsp;</td>
			</tr>
            <tr>
              <td class="textoTitulo" width="17%">Data da Solicitação: </td>
              <td class="textoValor" width="26%"><%=Formatador.formatarData(Calendar.getInstance().getTime())%></td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>
			<tr>
			  <td colspan="5">&nbsp;</td>
			</tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Informar:
                <hr>
              </td>
            </tr>
            <tr> 
              <td class="textoTitulo" width="17%">
                  <input type="radio" name="rdo" value="1"  
                   onclick="javascript: clickRadio('1')">
                   Incluir
              </td>
			</tr>
			<tr> 
              <td class="textoTitulo" width="17%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cedente: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext"
              	name="codigoCedente"
              	  value='<%=tituloBean.getCodigoCedente().equals(new Long(0))?"":tituloBean.getCodigoCedente().toString()%>'	
	              size="7" maxlength="7" 
        						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumero);"/> 
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoTitulo" width="26%">&nbsp;</td>
			</tr>
			<tr> 
              <td class="textoTitulo" width="17%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nosso Número: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext"
              	name="nossoNumero"
	              size="23" maxlength="17" 
        						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoTitulo" width="26%">&nbsp;</td>
			</tr>
			<tr>
			  <td colspan="5">&nbsp;</td>
			</tr>  
            <tr>
            <tr> 
              <td class="textoTitulo" width="2%">
                  <input type="radio" name="rdo" value="2" 
                   onclick="javascript: clickRadio('2')">
                   Consultar
              </td>
			</tr>
			<tr> 
              <td class="textoTitulo" width="17%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Unidade Cobradora: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="unidadeCobradora" size="5" maxlength="4" 
        						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoTitulo" width="26%">&nbsp;</td>
			</tr>
						<tr>
							<td colspan="5">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="5">&nbsp;</td>
						</tr>
	          <tr>
	            <td align="right" colspan="5">
	              <p align="center"> 
 		            	<s:Button name="Ok" action="javascript:formSubmit()"/>
	              </p>
	            </td>
	          </tr>
          </table>
        </td>
      </tr>
    </table>
    <script>
			function inicia() {
				setFirstFieldFocus();
			}

			function clickRadio(valor) {
				document.frmMain.filtroSelecao.value = valor;
				if (valor == "1") { // acesso por incluir
				    document.frmMain.acoesServicoTitulo.value="2"; // Sustação de Protesto
					document.frmMain.codigoCedente.disabled = false;
					document.frmMain.nossoNumero.disabled = false;
  					document.frmMain.unidadeCobradora.disabled = true;
					document.frmMain.codigoCedente.focus();
				} else if (valor == "2") { //acesso por consultar
					document.frmMain.unidadeCobradora.disabled = false;
					document.frmMain.codigoCedente.disabled = true;
					document.frmMain.nossoNumero.disabled = true;
	  				document.frmMain.unidadeCobradora.focus();
				}
								
			}
			
	    function formSubmit() {
		    if(!validaRadioButton(document.frmMain.rdo, '')){
				  return false;
		    }
	    	if (!validaSubmit()) {
	    		return false;
	    	}
   	    	document.frmMain.submit();
		}
			
		function validaSubmit() {
			// A validação de seleção obrigatória do radio foi feita no método validaRadioButton.
			if (document.frmMain.rdo[0].checked == true) {
			   	if(!validaCampoObrigatorio(document.frmMain.codigoCedente, "Cedente")) {
				  return false;
		    	}
			   	if(!validaCampoObrigatorio(document.frmMain.nossoNumero, "Nosso Número")) {
				  	return false;
			   	}
		  	}else {
		  		if(!validaCampoObrigatorio(document.frmMain.unidadeCobradora, "Unidade Cobradora")) {
				  	return false;
			   	}
		  	}
		  	return true;
		}
				
    </script>
  </s:FormStrategy>
</p:Document></html>
