<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: procurar_cep_erro.jsp - Java Server Pages
*Autor: Glauber M. Gallego ggallego@sao.politec.com.br
*Ultima Atualização: 29/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.comum.ProcurarCepEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(ProcurarCepEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setStrategyErrorReturn(msgBean.getStrategyErrorReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(ProcurarCepEstrategia.MSG_BEAN);
	}
	msgBean.setMsgError(request.getAttribute("msgError")==null?(String)request.getAttribute("javax.servlet.error.message"):(String) request.getAttribute("msgError"));
%>

<html>
<s:HeaderPopup/>
  
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="" fluxo="normal">

    <table width="450" border="0" cellspacing="0" cellpadding="0" align="center">
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
    </table>
    <script language="javascript">
			function inicia() {
			}
			function formSubmit() {
			}						
		</script>
  </s:FormStrategy>
</p:Document>
</html>