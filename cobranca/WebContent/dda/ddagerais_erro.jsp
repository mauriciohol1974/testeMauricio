<%
/***********************************************
*Projeto CAIXA - SIGCB DDA
*Componente: ddagerais_erro.jsp - Java Server Pages
*Criado em: 02/10/2009
*Autor: Glauber Gallego
*Ultima Atualização: 02/10/2009
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.estrategia.dda.DdaGeraisEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.DdaGeraisBean"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(DdaGeraisEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setStrategyErrorReturn(msgBean.getStrategyErrorReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(DdaGeraisEstrategia.MSG_BEAN);
	}
	msgBean.setMsgError(request.getAttribute("msgError")==null?
			                (String)request.getAttribute("javax.servlet.error.message"):
			                (String) request.getAttribute("msgError"));
%>

<%
  DdaGeraisBean ddaGeraisBean = (session.getAttribute(DdaGeraisEstrategia.BEAN_FILTRO)==null?
		                            new DdaGeraisBean():
	                              (DdaGeraisBean)session.getAttribute(DdaGeraisEstrategia.BEAN_FILTRO));
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
	          	<td nowrap class="textoTitulo" width="17%">Tipo de Pessoa: </td>
  	          <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getTipoPessoaSacadoTexto()%></td>
    	        <td nowrap class="textoTitulo" width="17%">CPF/CNPJ: </td>
      	      <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getCpfCnpjSacadoFormatado()%></td>
            </tr>
            <tr>
              <td nowrap class="textoTitulo" width="17%">Tipo de Data: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getTipoDataFiltroTexto()%></td>
              <td nowrap class="textoTitulo" width="17%">Data: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getDataFiltroFormatada()%></td>
            </tr>
            <tr>
              <td nowrap class="textoTitulo" width="17%">Tipo de Consulta: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getTipoConsultaTexto()%></td>
              <td nowrap class="textoTitulo" width="17%">&nbsp;</td>
              <td nowrap class="textoValor" width="26%">&nbsp;</td>
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