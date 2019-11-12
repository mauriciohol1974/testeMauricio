<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: arqreme_sucesso.jsp - Java Server Pages
*Autor: JE
*Ultima Atualiza��o: 28/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ClienteInternetBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CliInteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(CliInteEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(CliInteEstrategia.MSG_BEAN);
	}
	
	ClienteInternetBean clienteInternetBean = (session.getAttribute(CliInteEstrategia.FILTRO_BEAN)==null?new ClienteInternetBean():(ClienteInternetBean)session.getAttribute(CliInteEstrategia.FILTRO_BEAN));
	//ClienteInternetBean clienteInternetBean = (session.getAttribute(CliInteEstrategia.DATA_BEAN)==null?new ClienteInternetBean():(ClienteInternetBean)session.getAttribute(CliInteEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(CliInteEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(CliInteEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
	estrategia="<%=msgBean.getStrategySucessReturn()%>" fluxo="voltar">
	<s:Menu/>
	<s:Titulo name="<%=msgBean.getTitlePage()%>"/>    
	
	<input type="hidden" name = "consultaUnidade" value="">
	
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="center"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 align="center">
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa:</td>
              <td class="textoValor" width="26%"><%=clienteInternetBean.getTipoPessoaCedente().longValue()==1? "F�SICA": "JURIDICA"%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ:</td>
              <td class="textoValor" width="26%"><%=Formatador.formatarCpfCnpj(clienteInternetBean.getCpfCnpjCedente().toString())%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">CPF Usu�rio:</td>
              <td class="textoValor" colspan="3"><%=Formatador.formatarCpf(clienteInternetBean.getCpfUsuario()+"")%></td> 
            </tr>

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
          </table>
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 align="center">
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
	        	document.frmMain.fluxo.value = "voltar";
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