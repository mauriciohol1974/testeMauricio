<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: tarifa_manter_filtro.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Author Eduardo A. Mor�s - emoras@sao.politec.com.br 
*Ultima Atualiza��o: 18/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TarifaManualBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TarifaEstrategia"%>

<%
	TarifaManualBean tarifaBean = (session.getAttribute(TarifaEstrategia.FILTRO_BEAN)==null?new TarifaManualBean():(TarifaManualBean)session.getAttribute(TarifaEstrategia.FILTRO_BEAN));
	tarifaBean.setCodigoCedente(session.getAttribute(TarifaEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(TarifaEstrategia.CEDENTE_ATUAL));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TarifaEstrategia.STRATEGY_MANTER_LISTAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TarifaEstrategia.PAGE_TITLE_MANTER_FILTRO%>"/>

		<input type="hidden" name = "caller" value="filtro">
		<input type="hidden" name = "descricaoTarifa" value="">		

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="26%"> 
	              <p:InputNumerico name="codigoCedente" maxlength="7" size="7" 
                	CLASS="inputtext" value='<%=tarifaBean.getCodigoCedente().equals( new Long(0))?"":tarifaBean.getCodigoCedente().toString()%>' 
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataSolicitacao);"/>
              </td>
              
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr>
              		<td class="textoTitulo" width="17%">Servi�o:</td>
              		<td class="textoValor"><s:ComboServicoTarifa name="tipoTarifa" selectedValue='<%=tarifaBean.getTipoTarifa().toString()%>'/> </td>
              		<td width="17%">&nbsp;</td>
 	                <td width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Data Solicita��o: </td>
              <td class="textoTitulo" width="50%"> 
								<p:InputDate name="dataSolicitacao"
			          	CLASS="inputtext" 
 				          value ='<%=tarifaBean.getDataSolicitacaoFormatada()%>'
			            onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
                (Deixe em Branco para obter todos)
              </td>
              <td width="17%">&nbsp;</td>
              <td width="2%">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">
                <p align="center"> 
                  <s:Button name="Ok" action="javascript:formSubmit()"/>
                </p>
              </td>
            </tr>
          </table>
        </TD>
      </tr>
    </table>
    <script>
      function inicia(){
				setFirstFieldFocus();
      }
	    function formSubmit() {
        if (validaSubmit()) {
        	document.frmMain.descricaoTarifa.value = document.frmMain.tipoTarifa.options[document.frmMain.tipoTarifa.selectedIndex].text;
	        document.frmMain.submit();
        }
			}
			function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.codigoCedente, 'C�digo do Cedente')){
				  return false;
		    }
		    if (trim(document.frmMain.dataSolicitacao.value) != "" && 
		        !validaData(document.frmMain.dataSolicitacao)) {
		    	msg("014", "Data Solicitacao");
		    	return false;
		    }
		    return true;
		  }			
    </script>
  </s:FormStrategy>
</p:Document>
</html>