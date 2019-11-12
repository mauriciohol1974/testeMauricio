<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: bcosaca_incluir_filtro.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 05/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BancoSacadoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BancoSacadoEstrategia"%>

<%
	BancoSacadoBean bancoSacadoBean = (session.getAttribute(BancoSacadoEstrategia.FILTRO_BEAN)==null?new BancoSacadoBean():(BancoSacadoBean)session.getAttribute(BancoSacadoEstrategia.FILTRO_BEAN));
	bancoSacadoBean.setCodigoCedente(session.getAttribute(BancoSacadoEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(BancoSacadoEstrategia.CEDENTE_ATUAL));
%>

<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=BancoSacadoEstrategia.STRATEGY_INCLUIR_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=BancoSacadoEstrategia.PAGE_TITLE_INCLUIR_FILTRO%>"/>    
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="26%"> 
	              <p:InputNumerico name="codigoCedente" maxlength="7" size="7" 
	                	CLASS="inputtext" value='<%=bancoSacadoBean.getCodigoCedente().equals( new Long(0))?"":bancoSacadoBean.getCodigoCedente().toString()%>' 
	                	onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codigoBancoSacado);"/>
              </td>
              </td>
            	<td width="20%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Número Banco de Sacados: </td>
              <td class="textoTitulo" width="36%">
	              <p:InputNumerico name="codigoBancoSacado" maxlength="3" size="3" 
	                	CLASS="inputtext" value='<%=bancoSacadoBean.getCodigoBancoSacado().equals( new Long(0))?"":bancoSacadoBean.getCodigoBancoSacado().toString()%>' 
	                	onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
              </td>
            	<td width="20%">&nbsp;</td>
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
	        document.frmMain.submit();
        }
			}
			function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.codigoCedente, 'Cedente')){
				  return false;
		    }
		    if(!validaCampoObrigatorio(document.frmMain.codigoBancoSacado, 'Número Banco de Sacados')){
				  return false;
		    }
		    return true;
		  }
    </script>
  </s:FormStrategy>
</p:Document>
</html>
