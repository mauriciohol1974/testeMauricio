
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.SimulacaoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ServicoEstrategia"%>

<%
	String descCriticas = "";
	if (request.getAttribute(ServicoEstrategia.DESC_CRITICAS) != null) {
		descCriticas = (String) request.getAttribute(ServicoEstrategia.DESC_CRITICAS);
	} 
%>


<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ServicoEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Simulador Negocial >> Filtro"/>    
 		
    
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">
                <hr>
              </td>
            </tr>
           


			<tr>
              <td class="textoTitulo" width="10%">CNPJ: </td>
              <td colspan="2" width="26%"> 
                <p:InputNumerico name="cnpj" maxlength="14" size="17"	value='' CLASS="inputtext"	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nu_simulacao);"/>
              </td>
			</tr>
			
			<tr>
              <td class="textoTitulo" width="10%">Número Simulação: </td>
              <td colspan="2" width="26%"> 
                <p:InputNumerico name="nu_simulacao" maxlength="20" size="26"	value='' CLASS="inputtext"	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>
              </td>
			</tr>
						
            <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>

            <tr>
	            <td align="right" colspan="6">
		            <p align="center"> 
 		            	<s:Button name="Confirmar" action="javascript:formSubmit()"/>
	              </p>
	            </td>
	          </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    <script language="javascript">
	    function inicia(){
				setFirstFieldFocus();
				<%
				if (!descCriticas.equals("")) {
				%>
							alert("<%= descCriticas %>");
				<%}%>
				
	    }
	    function formSubmit() {
		        document.frmMain.submit();
	    }
	    
    </script>
  </s:FormStrategy>
</p:Document>
</html>