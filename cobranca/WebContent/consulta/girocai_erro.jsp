<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: girocai_erro.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 20/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GiroCaixaEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.GiroCaixaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(GiroCaixaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(GiroCaixaEstrategia.CEDENTE_CABECALHO_BEAN));
	GiroCaixaBean giroCaixaBean = (session.getAttribute(GiroCaixaEstrategia.DATA_BEAN)==null?new GiroCaixaBean():(GiroCaixaBean)session.getAttribute(GiroCaixaEstrategia.DATA_BEAN));		
%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(GiroCaixaEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setStrategyErrorReturn(msgBean.getStrategyErrorReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(GiroCaixaEstrategia.MSG_BEAN);
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
	          	<td class="textoTitulo" width="17%">Cedente: </td>
  	          <td class="textoValor" width="26%"><%=giroCaixaBean.getCodigoCedente().equals(new Long(0))?"":giroCaixaBean.getCodigoCedenteFormatado()%></td>
    	        <td class="textoTitulo" width="17%">Nome Cedente: </td>
      	      <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td>
            </tr>
            <tr>
	          	<td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
  	          <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 
    	        <td class="textoTitulo" width="17%">CNPJ: </td>
      	      <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
	          	<td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
  	          <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals(new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
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
                  <s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
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
	    }
			function formSubmit_Voltar() {
					document.frmMain.estrategia.value='<%=GiroCaixaEstrategia.STRATEGY_MANTER_INICIAR%>';

					//document.frmMain.estrategia.value='<%=GiroCaixaEstrategia.STRATEGY_MANTER_FILTRO%>';

				document.frmMain.submit();
		  }			
    </script>
  </s:FormStrategy>
</p:Document>
</html>