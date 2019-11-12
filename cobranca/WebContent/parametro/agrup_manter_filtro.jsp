<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: agrup_manter_filtro.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 29/08/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.AgrupamentoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.AgrupEstrategia"%>

<%
	AgrupamentoBean agrupBean = (session.getAttribute(AgrupEstrategia.FILTRO_BEAN)==null?new AgrupamentoBean():(AgrupamentoBean)session.getAttribute(AgrupEstrategia.FILTRO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=AgrupEstrategia.STRATEGY_MANTER_LISTAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=AgrupEstrategia.PAGE_TITLE_MANTER%>"/>
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Agrupamento: </td>
              <td class="textoTitulo" nowrap width="26%">
                <p:InputAlfanumerico name="codigoAgrupamento" maxlength="3" size="3" 
                	value="<%=agrupBean.getCodigoAgrupamento().trim()%>" CLASS="inputtext"
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
                (Deixe em Branco para obter todos)
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
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
        </td>
      </tr>
    </table>
    <script>
			function inicia() {
				setFirstFieldFocus();
			}
	    function formSubmit() {
        if (validaSubmit()) {
	        document.frmMain.submit();
        }
			}
			function validaSubmit() {
		    return true;
		  }			
    </script>
  </s:FormStrategy>
</p:Document>
</html>