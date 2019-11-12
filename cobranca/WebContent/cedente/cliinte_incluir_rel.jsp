<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: cliint_incluir_rel.jsp - Java Server Pages
*Autor: Glauber M. Gallego
*Ultima Atualização: 27/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ClienteInternetBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CliInteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%
	ClienteInternetBean clienteInternetBean = (session.getAttribute(CliInteEstrategia.DATA_BEAN)==null ? new ClienteInternetBean():(ClienteInternetBean)session.getAttribute(CliInteEstrategia.DATA_BEAN));
%>
<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=CliInteEstrategia.STRATEGY_INCLUIR_REL_FINALIZAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=CliInteEstrategia.PAGE_TITLE_INCLUIR_REL%>"/>
		<!--dados para o filtro -->
	    <input type="hidden" name = "tipoPesquisa" value='2'>
	    <input type="hidden" name = "cpfUsuario" value='<%=clienteInternetBean.getCpfUsuario()%>'>
		<input type="hidden" name = "codigoCedente" value='<%=clienteInternetBean.getCodigoCedente()%>'>
		<input type="hidden" name = "nomeUsuario" value='<%=clienteInternetBean.getNomeUsuario()%>'>


    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 align="center">
            <tr>
              <td class="textoTitulo" width="17%">Codigo Cedente:</td>
              <td class="textoValor" width="26%"><%=clienteInternetBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome:</td>
              <td class="textoValor" width="26%"><%=clienteInternetBean.getNome()%></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4" class="textoTitulo" >Usuário<hr></td>
            </tr>            
            <tr>
              <td class="textoTitulo" width="17%">CPF Usuário:</td>
              <td class="textoValor" width="26%"><%=Formatador.formatarCpf(clienteInternetBean.getCpfUsuario().toString())%></td>
              <td class="textoTitulo" width="17%">Nome Usuário:</td>
              <td class="textoValor" width="26%"><%=clienteInternetBean.getNomeUsuario()%></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center"> 
                	<s:Button name="Confirmar" action="javascript: formSubmit();"/>
                	<s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
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

    function formSubmit() { // Acao default confirmar
      if (confirm(conf("159"))) {
				document.frmMain.submit();
			}
		}
	
		function formSubmit_Voltar() {
			document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_INCLUIR_INICIAR%>";
			document.frmMain.fluxo.value = "voltar";
			document.frmMain.submit();
    }
      
   </script>
  </s:FormStrategy>
</p:Document>
</html>