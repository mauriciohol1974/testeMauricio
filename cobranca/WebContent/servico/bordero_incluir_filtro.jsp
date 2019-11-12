<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bordero_incluir_filtro.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 01/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BorderoEstrategia"%>

<%
	BorderoBean borderoBean = (session.getAttribute(BorderoEstrategia.FILTRO_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(BorderoEstrategia.FILTRO_BEAN));
	borderoBean.setCodigoCedente(session.getAttribute(BorderoEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(BorderoEstrategia.CEDENTE_ATUAL));
%>

<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia='<%=BorderoEstrategia.STRATEGY_INCLUIR%>' fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Incluir Borderô >> Filtro"/>    
		<table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="26%"> 
              <p:InputNumerico name="codigoCedente" maxlength="7" size="7" 
                	CLASS="inputtext" value='<%=borderoBean.getCodigoCedente().equals( new Long(0))?"":borderoBean.getCodigoCedente().toString()%>' 
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="5">
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
			function inicia() {
				setFirstFieldFocus();
			}
	    function formSubmit() {
        if (validaSubmit()) {
	        document.frmMain.submit();
        }
			}
			function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.codigoCedente, 'Cedente')){
				  return false;
		    }
		    return true;
		  }			
    </script>
  </s:FormStrategy>
</p:Document>
</html>