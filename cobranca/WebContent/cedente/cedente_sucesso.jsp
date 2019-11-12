<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConclusaoBean"%>


<%
 	CedenteConclusaoBean conclusaoBean = (request.getAttribute(CedenteEstrategia.CEDENTE_CONCLUSAO_BEAN)==null
 	                                     ? new CedenteConclusaoBean()
 	                                     : (CedenteConclusaoBean)request.getAttribute(CedenteEstrategia.CEDENTE_CONCLUSAO_BEAN));
%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(CedenteEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(CedenteEstrategia.MSG_BEAN);
	}
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=msgBean.getStrategySucessReturn()%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

						<%-- *********** CABECALHO CEDENTE ****************** --%>
            <%@include file="cedente_cabecalho.jsp" %>
                        
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
	            	<h3 style= "TEXT-ALIGN:center"><%=msgBean.getMsgSucess()%></h3>
	            </td>
	          </tr>
<%
	if (conclusaoBean.getNumeroPendencia() != null &&
	    !conclusaoBean.getNumeroPendencia().equals(new Long(0))) {
%>	          
            <tr>
              <td colspan="4" align="center">
	              <span class="textoDestaqueTitulo">Número da Pendência: </span>
	              <span class="textoValor">&nbsp;<%= conclusaoBean.getNumeroPendencia() %></span>
              </td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
						<tr>
              <td colspan="4" align="center">
              	<span class="textoDestaqueTitulo">Perfil Usuário Alçada: </span>
              	<span class="textoValor">&nbsp;<%= conclusaoBean.getPerfilUsuarioAlcada() %></span>
              </td>
						</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
<%
	}

	if (conclusaoBean.getCodigoCedente() != null &&
	    !conclusaoBean.getCodigoCedente().equals(new Long(0))) {
%>	          
						<tr>
              <td colspan="4" align="center">
              	<span class="textoDestaqueTitulo">Código do Cedente: </span>
              	<span class="textoValor">&nbsp;<%= conclusaoBean.getCodigoCedenteFormatado() %></span>
              </td>
						</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
<%
	}
%>						
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