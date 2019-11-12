<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: perinte_incluir_filtro.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 05/11/2004 10:53
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.PerInteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.PerfilInternetBean"%>
<%	PerfilInternetBean bean = (session.getAttribute(PerInteEstrategia.FILTRO_BEAN)==null?new PerfilInternetBean():(PerfilInternetBean)session.getAttribute(PerInteEstrategia.FILTRO_BEAN));%>
<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle" 
  estrategia="<%=PerInteEstrategia.STRATEGY_INCLUIR_FILTRO%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="<%=PerInteEstrategia.PAGE_TITLE_INCLUIR_FILTRO%>"/>
      <table width="777" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td valign="top" width="95%" height="14" align="left"> 
                <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" align="center">
                  <tr> 
                      <td class="textoTitulo" width="17%">Número Perfil: </td>
                      <td class="textoValor" nowrap width="26%"> 
                      <p:InputNumerico CLASS="inputtext" name="codigoPerfil" size="5" maxlength="3"
		               	    value='<%=bean.getCodigoPerfil().equals(new Long(0))?"":bean.getCodigoPerfil().toString()%>'
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
	      if(!validaCampoObrigatorio(document.frmMain.codigoPerfil,'Número Perfil')) {
	        return false;
	      }
	      return true;
      }
    </script>
  </s:FormStrategy>
</p:Document>
</html>