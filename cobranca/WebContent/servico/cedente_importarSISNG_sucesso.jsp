<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ServicoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.SimulacaoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteExpressoBean"%>




<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(ServicoEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(ServicoEstrategia.MSG_BEAN);
	}
	
	SimulacaoBean simulacaoBean = (SimulacaoBean) request.getAttribute("SimulacaoBean");
%>

<html>
<s:Header/>

<p:Document>
	

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

						
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo" >
              	<hr>
              </td>
            </tr>

	          <tr> 
	            <td colspan="4" align="center">
	            	<h3 style= "TEXT-ALIGN:center">APROPRIAÇÃO EFETUADA COM SUCESSO</h3>
	            </td>
	          </tr>

						<tr>
              <td colspan="4" align="center">
              	<span class="textoDestaqueTitulo">Simulação:</span>
              	<span class="textoValor">&nbsp;<%= simulacaoBean.getNu_simulacao().toString() %></span>
              	
              </td>
						</tr>
			<%if (simulacaoBean.getNuPendencia()>0){ %>			
			<tr>
              <td colspan="4" align="center">
              	<span class="textoDestaqueTitulo">Gerada a pendência:</span>
              	<span class="textoValor">&nbsp;<%= simulacaoBean.getNuPendencia().toString() %></span>
              	
              </td>
			</tr>
			<%} %>
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
 	          <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>
						
          </table>
        </td>
      </tr>
    </table>
    
    <script>
			function inicia() {
			}
	    function formSubmit() {
	    	window.close();
	    }
      
    </script>
    
  
</p:Document>
</html>