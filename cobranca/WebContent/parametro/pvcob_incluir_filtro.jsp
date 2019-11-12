<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: pvcob_incluir_filtro.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 13/10/2004 16:08
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.PvCobradorBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.PvCobEstrategia"%>

<%
  PvCobradorBean pvBean = (session.getAttribute(PvCobEstrategia.DATA_BEAN)==null?new PvCobradorBean():(PvCobradorBean)session.getAttribute(PvCobEstrategia.DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle" 
  estrategia="<%=PvCobEstrategia.STRATEGY_INCLUIR%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="Incluir PV Cobrador >> Filtro"/>
      <table width="777" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td valign="top" width="95%" height="14" align="left"> 
                <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
                  <tr> 
                      <td class="textoTitulo" width="17%">Unidade PV: </td>
                      <td class="textoValor" nowrap width="26%"> 
                      <p:InputNumerico CLASS="inputtext" name="codigoUnidadePV" size="5" maxlength="4"
           						value='<%=pvBean.getCodigoUnidadePV().equals(new Long(0))?"":pvBean.getCodigoUnidadePV().toString()%>'
           						onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>                    
                      </td>
                      <td width="17%">&nbsp;</td>
                      <td width="26%">&nbsp;</td>
                  </tr>
                  <tr> 
                      <td class="textoTitulo" width="17%">Unidade Centralizadora: </td>
                      <td class="textoValor" nowrap width="26%"> 
                      <p:InputNumerico CLASS="inputtext" name="codigoUnidadeCentral" size="5" maxlength="4"
           						value='<%=pvBean.getCodigoUnidadeCentral().equals(new Long(0))?"":pvBean.getCodigoUnidadeCentral().toString()%>'
           						onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>                    
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
            </TD>
          </tr>
      </table>
      <script>
      function inicia(){
      setFirstFieldFocus();
      }
      function formSubmit() {
	      if (validaInserir()) {
	          document.frmMain.submit();
	      }
      }
      function validaInserir(){
	      if(!validaCampoObrigatorio(document.frmMain.codigoUnidadePV,'Código da Unidade PV')) {
	        return false;
	      }
	      if(!validaMenorIgual(document.frmMain.codigoUnidadePV, 'Código da Unidade PV', 0)) {
		      return false;
	      }
	      if(!validaCampoObrigatorio(document.frmMain.codigoUnidadeCentral,'Código da Unidade Centralizadora')) {
	        return false;
	      }
	      if(!validaMenorIgual(document.frmMain.codigoUnidadeCentral, 'Código da Unidade Centralizadora', 0)) {
		      return false;
	      }
      return true;
      }
    </script>
  </s:FormStrategy>
</p:Document>
</html>