<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bloquet_incluir_filtro.jsp - Java Server Pages
*Autor: JE
*Ultima Atualiza��o: 15/10/2004 14:21
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BloquetoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BloquetEstrategia"%>

<%
	BloquetoBean bloquetoBean = (session.getAttribute(BloquetEstrategia.FILTRO_BEAN)==null?new BloquetoBean():(BloquetoBean)session.getAttribute(BloquetEstrategia.FILTRO_BEAN));
	bloquetoBean.setCodigoCedente(session.getAttribute("cedente")==null?new Long (0):(Long)session.getAttribute("cedente"));
%>

<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle" 
  estrategia="<%=BloquetEstrategia.STRATEGY_INCLUIR_FILTRO%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="<%=BloquetEstrategia.PAGE_TITLE_INCLUIR_FILTRO%>"/>
    
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="26%"> 
	              <p:InputNumerico name="codigoCedente" maxlength="7" size="7" 
	                CLASS="inputtext" value='<%=bloquetoBean.getCodigoCedente().equals( new Long(0))?"":bloquetoBean.getCodigoCedente().toString()%>' 
	                onFocus="javascript: prevFocus(this);"
                    onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.tipoBloqueto);"/>	
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr>
            	<td class="textoTitulo" width="17%">Tipo de Boleto: </td>
            	<td width="26%">
					<s:ComboTipoBloqueto name="tipoBloqueto" disabled="false" selectedValue='<%=bloquetoBean.getTipoBloqueto() == null ? "" : bloquetoBean.getTipoBloqueto().toString()%>'/>
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
				if(!validaCampoObrigatorio(document.frmMain.codigoCedente, 'Cedente')){
					return false;
				}
					return true;
			}			
    </script>
  </s:FormStrategy>
</p:Document>
</html>
