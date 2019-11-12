<%
/***********************************************
*Projeto CAIXA - SIGCB
*Autor: Maurício Assis de Holanda
*Data criação: Abril / 2013
************************************************/
%>


<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.LiqRejeManterEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean"%>

<%
 	LiquidacoesRejeitadaBean liqRejeBean = (session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN)==null
 	                                        ? new LiquidacoesRejeitadaBean()
 	                                        : (LiquidacoesRejeitadaBean)session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN));

 	LiquidacoesRejeitadaBean dataBean = (session.getAttribute(LiqRejeManterEstrategia.DATA_BEAN)==null
 	                                     ? new LiquidacoesRejeitadaBean()
 	                                     :(LiquidacoesRejeitadaBean)session.getAttribute(LiqRejeManterEstrategia.DATA_BEAN));
%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(LiqRejeManterEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setStrategyErrorReturn(msgBean.getStrategyErrorReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(LiqRejeManterEstrategia.MSG_BEAN);
	}
	msgBean.setMsgError(request.getAttribute("msgError")==null?(String)request.getAttribute("javax.servlet.error.message"):(String) request.getAttribute("msgError"));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=msgBean.getStrategyErrorReturn()%>" fluxo="voltar">
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">



            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">
                <hr>
              </td>
            </tr>

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            
			      <tr>
			        <td colspan="4" align="center">
			          <p align="center">
									<table width="70%" height="90" border="1" cellspacing="0" cellpadding="0" align="center" valign="middle" bordercolordark="#cccccc" bordercolorlight="#ffffff">
										<tr>
											<td colspan="2" valign="center" align="middle">
												<img src="<%=Paths.getImagePath()%>/caixa_nome.gif">
											</td>
										</tr>
										<tr bgcolor="#f5f5f5">
											<td width="10%" valign="center" align="middle">
												<img src="<%=Paths.getImagePath()%>/msgErro.gif">
											</td>
											<td class="textoDestaqueTitulo" valign="center" align="middle">
												<%=msgBean.getMsgError()%>
											</td>
										</tr>
									</table>
								</p>
			        </td>
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
 	          <tr> 
	            <td colspan="4">&nbsp;</td>
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