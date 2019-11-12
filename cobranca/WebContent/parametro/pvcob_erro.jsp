<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: pvcob_erro.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 13/10/2004 16:08
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.PvCobEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.PvCobradorBean"%>
<%@page import="br.com.politec.sao.util.Formatacao"%>
<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(PvCobEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setStrategyErrorReturn(msgBean.getStrategyErrorReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(PvCobEstrategia.MSG_BEAN);
	}
	msgBean.setMsgError(request.getAttribute("msgError")==null?(String)request.getAttribute("javax.servlet.error.message"):(String) request.getAttribute("msgError"));
	PvCobradorBean pvCobBean = (session.getAttribute(PvCobEstrategia.DATA_BEAN)==null? new PvCobradorBean():(PvCobradorBean)session.getAttribute(PvCobEstrategia.DATA_BEAN));
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
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 align="center" >
          <% if (pvCobBean.getCodigoUnidadePV().longValue()!=0) { %>
            <tr>
              <td class="textoTitulo" width="17%">Unidade PV: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getCodigoUnidadePVFormatado()%></td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>
          <% } else { //erro por PV %>  
	          <% if (pvCobBean.getAcao().equals("UNIDADE")) { %>
	          <tr>
     			     <td class="textoTitulo" width="17%">Unidade PV De: </td>
	             <td class="textoValor" width="26%"><%=pvCobBean.getCodUnidPVInicialFormatado()%></td>
   			       <td class="textoTitulo" width="17%">Até: </td>
         			 <td class="textoValor" width="26%"><%=pvCobBean.getCodUnidPVFinalFormatado()%></td> 
	          </tr>
          <%} else { %>
	          <tr>
     			     <td class="textoTitulo" width="17%">Cep De: </td>
	             <td class="textoValor" width="26%"><%=Formatacao.formataCep(pvCobBean.getNumeroCEPde())%></td>
   			       <td class="textoTitulo" width="17%">Até: </td>
         			 <td class="textoValor" width="26%"><%=Formatacao.formataCep(pvCobBean.getNumeroCEPate())%></td> 
	          </tr>
	        <% }
	        } %>
	        
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
					<table width="70%" height="90" border="1" cellspacing="0" cellpadding="0" align="center" bordercolordark="#cccccc" bordercolorlight="#ffffff">
						<tr>
							<td colspan="2" valign="middle" align="center">
								<img src="<%=Paths.getImagePath()%>/caixa_nome.gif">
							</td>
						</tr>
						<tr bgcolor="#f5f5f5">
							<td width="10%" valign="middle" align="center">
								<img src="<%=Paths.getImagePath()%>/msgErro.gif">
							</td>
							<td class="textoDestaqueTitulo" valign="middle" align="center">
								<%=msgBean.getMsgError()%>
							</td>
						</tr>
					</table>
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
		<script language="javascript">
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