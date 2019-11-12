<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: solextr_sucesso.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 10/04/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloOnLineEstrategia"%>


<%
	
	
	CedenteCabecaBean cedCabBean = (session.getAttribute(TituloOnLineEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TituloOnLineEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(TituloOnLineEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(TituloOnLineEstrategia.MSG_BEAN);
	}
	%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="servico.TituloOnLineIncluir" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TituloOnLineEstrategia.PAGE_TITLE_INCLUIR %>"/>    

		<input type="hidden" name = "codigoCedente" value="<%=cedCabBean.getCodigoCedente()%>">
		

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="center"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 align="center">
          
          </table>
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 align="center">
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">
                <hr>
              </td>
            </tr>
	          <tr> 
	            <td colspan="4" align="center">
	            	<h3 style= "TEXT-ALIGN:center">Inclusão efetuada com sucesso.</h3>
	            </td>
	          </tr>
            <tr>
              <td colspan="2">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="2">&nbsp;</td>
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