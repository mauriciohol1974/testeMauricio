<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: soagitit_sucesso.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 15/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.servico.SolicitacaoAgendamentoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.SolicitacaoAgendamentoBean"%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(SolicitacaoAgendamentoEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(SolicitacaoAgendamentoEstrategia.MSG_BEAN);
	}
%>

<%
	SolicitacaoAgendamentoBean solicitacaoBean = (session.getAttribute(SolicitacaoAgendamentoEstrategia.DATA_BEAN)==null?new SolicitacaoAgendamentoBean():(SolicitacaoAgendamentoBean)session.getAttribute(SolicitacaoAgendamentoEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(SolicitacaoAgendamentoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(SolicitacaoAgendamentoEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>    
    <input type="hidden" name="codigoCedente" value="<%=solicitacaoBean.getCodigoCedente()%>">
    <input type="hidden" name="codigoBancoSacado" value="<%=solicitacaoBean.getCodigoBancoSacado()%>">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="center"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getCodigoCedente().equals( new Long(0))?"":solicitacaoBean.getCodigoCedenteFormatado()%></td>
  
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 

              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals( new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
  
              <td class="textoTitulo" width="17%">Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getCodigoBancoSacado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Nome Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=solicitacaoBean.getNomeBancoSacado()%></td> 
  
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
          </table>
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
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
 	            <TD colspan="4">&nbsp;</TD>
 	          </tr>
            <tr>
 	            <TD colspan="4">&nbsp;</TD>
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