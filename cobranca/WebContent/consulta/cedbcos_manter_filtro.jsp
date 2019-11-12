<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: cedbcos_manter_filtro.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 28/10/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedBcoSBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.CedBcoSEstrategia"%>

<%
	CedBcoSBean cedBcoBean = (session.getAttribute(CedBcoSEstrategia.FILTRO_BEAN)==null?new CedBcoSBean():(CedBcoSBean)session.getAttribute(CedBcoSEstrategia.FILTRO_BEAN));
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia='<%=CedBcoSEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
		<s:Menu/>
		<s:Titulo name='<%=CedBcoSEstrategia.PAGE_TITLE_FILTRO%>'/>
        
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="17%">Unidade PV: </td>
              <td class="textoValor" width="26%"> 
              	<p:InputNumerico CLASS="inputtext" name="codigoUnidadePV" size="6" maxlength="4"
  								 value='<%=cedBcoBean.getCodigoUnidadePV().equals(new Long(0))?"":cedBcoBean.getCodigoUnidadePV().toString()%>'
									onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>   								 
              </td>

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
	      if(validaSubmit()) {
		      document.frmMain.submit();
	      }
      }
      
			function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.codigoUnidadePV, "Unidade PV")) {
				  return false;
		    }
				return true;
			}      
    </script>
  </s:FormStrategy>
</p:Document>
</html>
