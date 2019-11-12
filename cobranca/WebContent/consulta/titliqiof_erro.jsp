<%
/***********************************************
*Probank
*Projeto CAIXA - SIGCB
*Componente: titliqiof_erro.jsp - Java Server Pages
*Autor: Adelaine Rondon - adelaine.rondon@probank.com.br
*Ultima Atualização: 11/01/2011
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.UtilDatas"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TitLiqIOFManterEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosIOFBean" %>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(TitLiqIOFManterEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setStrategyErrorReturn(msgBean.getStrategyErrorReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(TitLiqIOFManterEstrategia.MSG_BEAN);
	}
	msgBean.setMsgError(request.getAttribute("msgError")==null?(String)request.getAttribute("javax.servlet.error.message"):(String) request.getAttribute("msgError"));
	
	ConGerTitulosLiquidadosIOFBean filtroBean = (session.getAttribute(TitLiqIOFManterEstrategia.FILTRO_BEAN) == null
            ? new ConGerTitulosLiquidadosIOFBean()
            : (ConGerTitulosLiquidadosIOFBean) session.getAttribute(TitLiqIOFManterEstrategia.FILTRO_BEAN));
																			
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
          <table width="95%" border="0" cellspacing="1" cellpadding="0"
					height=53 valign="middle" align="center">

					<% if (filtroBean.getTipoInformacao() == 1) {%>
						<tr>
							<td class="textoTitulo" width="17%">Cedente:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getInformacao()%></td>
							<td class="textoTitulo" width="17%">Nome Cedente:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getNome()%></td>
						</tr>
					<%} else if (filtroBean.getTipoInformacao() == 2) {%>
						<tr>
							<td class="textoTitulo" width="17%">PV:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getInformacao()%></td>
							<td class="textoTitulo" width="17%">Nome Unidade:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getNome()%></td>
						</tr>
					<%} else if (filtroBean.getTipoInformacao() == 3) {%>	
						<tr>
							<td class="textoTitulo" width="17%">SR:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getInformacao()%></td>
							<td class="textoTitulo" width="17%">Nome Unidade:</td>
							<td class="textoValor" width="26%"><%=filtroBean.getNome()%></td>
						</tr>
					<%} else {%>	
						<tr>
							<td class="textoTitulo" width="17%">Consulta:</td>
							<td class="textoValor" width="26%" colspan=3>CAIXA</td>
						</tr>
					<%} %>	
					<tr>
						<td class="textoTitulo" width="17%">Mes/Ano:</td>
						<td class="textoValor" width="26%"><%= String.format("%02d", filtroBean.getMes()) + "/" + String.format("%04d", filtroBean.getAno()) %></td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
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
        document.frmMain.submit();
	    }
    </script>    
  </s:FormStrategy>
</p:Document>
</html>