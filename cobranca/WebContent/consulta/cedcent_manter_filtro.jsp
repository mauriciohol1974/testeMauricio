<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: cedcent_manter_filtro.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Author Eduardo A. Mor�s - emoras@sao.politec.com.br 
*Ultima Atualiza��o: 28/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedCentBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.CedCentEstrategia"%>


<%
	CedCentBean cedCentBean = (session.getAttribute(CedCentEstrategia.FILTRO_BEAN)==null?new CedCentBean():(CedCentBean)session.getAttribute(CedCentEstrategia.FILTRO_BEAN));
	cedCentBean.setCodigoCedente(session.getAttribute(CedCentEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(CedCentEstrategia.CEDENTE_ATUAL));
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia='<%=CedCentEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
		<s:Menu/>
		<s:Titulo name='<%=CedCentEstrategia.PAGE_TITLE_FILTRO%>'/>
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="26%"> 
              	<p:InputNumerico CLASS="inputtext" 
              	 name="codigoCedente" size="7" maxlength="7"
 								 value='<%=cedCentBean.getCodigoCedente().equals(new Long(0))?"":cedCentBean.getCodigoCedente().toString()%>'
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
      function inicia() {
				setFirstFieldFocus();      
      }
      
      function formSubmit() {
      	if (validaSubmit()) {
      		document.frmMain.submit();
      	}
      }
      
			function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.codigoCedente, "Cedente")) {
				  return false;
		    }
				return true;
			}      
      
    </script>
  </s:FormStrategy>
</p:Document>
</html>
