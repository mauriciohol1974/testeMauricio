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
<%@page import="br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.LiqRejeManterEstrategia"%>

<%
 	LiquidacoesRejeitadaBean liqRejeBean = (session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN)==null
 	                                        ? new LiquidacoesRejeitadaBean()
 	                                        : (LiquidacoesRejeitadaBean)session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN));
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="servico.LiqRejeManterFiltro" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Liquidações Rejeitadas >> Filtro"/>

		<input type="hidden" name="tipoOpcaoDescricao">
		<input type="hidden" name="meioLiquidacaoDescricao">

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="17%">Opção: </td>
              <td class="textoValor" width="26%">
                <s:ComboLiqRejeOpcao name="tipoOpcao" selectedValue="<%=liqRejeBean.getTipoOpcao().toString()%>"/>
              </td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Meio Liquidação: </td>
              <td class="textoValor" width="26%">
                <!-- item 5  SISOL 147829<s:ComboTipoMeioLiquidacao name="meioLiquidacao" valoresFixo="99" descricoesFixo="TODOS" selectedValue="<%=liqRejeBean.getMeioLiquidacao().toString()%>"/>-->
                <s:ComboTipoMeioLiquidacao name="meioLiquidacao" valoresFixo="99" descricoesFixo="TODOS" selectedValue="99"/>
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
						</tr>

            <tr> 
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
            </tr>

						<tr>
              <td class="textoTitulo" width="17%">PV Recebedor/Centralizador: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="codigoUnidadePV" size="5" maxlength="4" value='<%=liqRejeBean.getCodigoUnidadePV().equals(new Long(0))?"":liqRejeBean.getCodigoUnidadePV().toString()%>' 
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataInicial);"/>
              </td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Data (a partir de): </td>
              <td class="textoValor" width="26%"> 
              	<p:InputDate CLASS="inputtext" name="dataInicial" value="<%=liqRejeBean.getDataInicialFormatada()%>" 
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
              </td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
						</tr>

            <tr>
              <td colspan="6">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="6">
                <p align="center">
                	<s:Button name="Ok" action="javascript:formSubmit();"/>
                </p>
              </td>
            </tr>
          </table>
        </TD>
      </tr>
    </table>
    <script>
			function inicia() {
				setFirstFieldFocus();
			}
			
	    function formSubmit() {
        if (validaSubmit()) {
        	converteDadosSaida();
          document.frmMain.submit();
        }
			}
			
			function validaSubmit() {
		    if (!validaCampoObrigatorio(document.frmMain.codigoUnidadePV, 'PV Recebedor / Centralizador')){
				  return false;
		    }
		    if (trim(document.frmMain.dataInicial.value) != "" && 
		        !validaData(document.frmMain.dataInicial)) {
		    	msg("014", "Data (a partir de)");
		    	return false;
		    }
		    return true;
		  }
		  
		  function converteDadosSaida() {
		  	//document.frmMain.dataInicial.value = 
		  	//		substituiBarraPorPonto(document.frmMain.dataInicial.value);
		  	document.frmMain.tipoOpcaoDescricao.value =
		  			getDescricaoSelect(document.frmMain.tipoOpcao);
				document.frmMain.meioLiquidacaoDescricao.value =
		  			getDescricaoSelect(document.frmMain.meioLiquidacao);
		  }
    </script>
	</s:FormStrategy>
</p:Document>
</html>
