<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: pvcob_sucesso.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 13/10/2004 16:08
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.PvCobradorBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.PvCobEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(PvCobEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(PvCobEstrategia.MSG_BEAN);
	}
%>
<%
	PvCobradorBean pvBean = (session.getAttribute(PvCobEstrategia.DATA_BEAN)==null?new PvCobradorBean():(PvCobradorBean)session.getAttribute(PvCobEstrategia.DATA_BEAN));
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=msgBean.getStrategySucessReturn()%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>
		
		<input type="hidden" name = "codUnidPVInicial" value="<%=pvBean.getCodUnidPVInicial()%>">
		<input type="hidden" name = "codUnidPVFinal" value="<%=pvBean.getCodUnidPVFinal()%>">
		<input type="hidden" name = "numeroCEPde" value="<%=pvBean.getNumeroCEPde()%>">
		<input type="hidden" name = "numeroCEPate" value="<%=pvBean.getNumeroCEPate()%>">
		<input type="hidden" name = "acao" value="<%=pvBean.getAcao()%>">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Unidade PV: </td>
              <td class="textoValor" width="26%"><%=pvBean.getCodigoUnidadePVFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Unidade: </td>
              <td class="textoValor" width="26%"><%=pvBean.getNomeUnidadePV()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Endereço: </td>
              <td class="textoValor" width="26%"><%=pvBean.getEndereco()%></td>
              <td class="textoTitulo" width="17%">e-mail: </td>
              <td class="textoValor" width="26%"><%=pvBean.getEmailUnidadePV()%></td>
            </tr>
            
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">
                <hr>
              </td>
            </tr>

	          <tr> 
	            <td>&nbsp;</td>
	            <td colspan="3">
	            	<h3><%=msgBean.getMsgSucess()%></h3>
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