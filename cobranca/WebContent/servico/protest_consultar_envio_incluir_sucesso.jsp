<%
/***********************************************
*Projeto CAIXA - SIGCB
*Componente: protest_consultar_envio_incluir_sucesso.jsp - Java Server Pages
*Autor: Cristian Souza - Probank/REDEASP02
*Data Criação: Abr/2009
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.ProtestoTituloBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ProtestEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(ProtestEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(ProtestEstrategia.MSG_BEAN);
	}
%>

<%
	ProtestoTituloBean protestoTituloBean = (session.getAttribute(ProtestEstrategia.PROTESTO_TITULO_DATA_BEAN)==null?new ProtestoTituloBean():(ProtestoTituloBean)session.getAttribute(ProtestEstrategia.PROTESTO_TITULO_DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=msgBean.getStrategySucessReturn()%>" fluxo="normal" >
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>    
		
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
	          <tr>
              <td class="textoTitulo" width="17%">Data da Solicitação: </td>
              <td nowrap class="textoValor" width="26%"><%=protestoTituloBean.getDataSolicitacaoFormatada().equals("01/01/0001")?"":protestoTituloBean.getDataSolicitacaoFormatada()%></td>
	      	  <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Unidade Cobradora: </td>
              <td nowrap class="textoValor" width="26%"><%=protestoTituloBean.getCodigoUnidadePv().equals( new Long(0))?"":protestoTituloBean.getCodigoUnidadePvFormatado()%> - <%=protestoTituloBean.getNomeUnidadePv()%></td>
	      	  <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Ação: </td>
              <td nowrap class="textoValor" width="26%">INCLUIR</td>
	      	  <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr> 

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">
                <hr>
              </td>
            </tr>

	          <tr> 
	            <td colspan="4" align="center">
	            	<h3 style= "TEXT-ALIGN:center"><%=msgBean.getMsgSucess()%></h3>
	            </td>
	          </tr>

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            
            
            <tr>
	            <td class="textoTitulo" align="center" colspan="4">
                <s:Button name="Ok" action="javascript:formSubmit()"/>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    <script language="javascript">
	    function formSubmit() {
      		  document.frmMain.estrategia.value = "<%=msgBean.getStrategySucessReturn()%>";
	          document.frmMain.submit();
      }
	    
	    function inicia(){
	    }
	    
	   </script>
  </s:FormStrategy>
</p:Document>
</html>    