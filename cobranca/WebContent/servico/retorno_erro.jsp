<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bloquet_erro.jsp - Java Server Pages
*Autor: JE
*Ultima Atualiza��o: 13/10/2004 16:08
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.RetornoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(RetornoEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setStrategyErrorReturn(msgBean.getStrategyErrorReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(RetornoEstrategia.MSG_BEAN);
	}
	msgBean.setMsgError(request.getAttribute("msgError")==null?(String)request.getAttribute("javax.servlet.error.message"):(String) request.getAttribute("msgError"));
	
	CedenteCabecaBean cedCabBean = (session.getAttribute(RetornoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(RetornoEstrategia.CEDENTE_CABECALHO_BEAN));
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=msgBean.getStrategyErrorReturn()%>" fluxo="voltar">
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>
	<input type="hidden" name = "consultaUnidade" value="">
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 align="center">
	            <tr>
	              <td class="textoTitulo" width="17%">Cedente: </td>
	              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedente().equals(new Long(0)) ? "": cedCabBean.getCodigoCedenteFormatado()%></td>
	  
	              <td class="textoTitulo" width="17%">Nome Cedente: </td>
	              <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
	            </tr>
	            <tr>
	              <td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
	              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto() == null ? "": cedCabBean.getTipoPessoaTexto()%></td> 
	
	              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
	              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
	            </tr>
	            <tr>
	              <td class="textoTitulo" width="17%">C�digo Cliente (COCLI): </td>
	              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals( new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
	              <td colspan="2"">&nbsp;</td>
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
              <td colspan="4" align="center">
								<s:Button name="Ok" action="javascript:formSubmit()"/>
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