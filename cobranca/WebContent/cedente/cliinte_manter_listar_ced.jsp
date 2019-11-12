<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: cliint_manter_listar_ced.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 17/11/2004
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
	ClienteInternetBean clienteInternetBean = (session.getAttribute(CliInteEstrategia.FILTRO_BEAN)==null ? new ClienteInternetBean():(ClienteInternetBean)session.getAttribute(CliInteEstrategia.FILTRO_BEAN));
	
InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean)session.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);

%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=CliInteEstrategia.STRATEGY_ALTERAR_USU_INICIAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=CliInteEstrategia.PAGE_TITLE_MANTER_FILTRO_CED%>"/>
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
                	<s:Button name="usuario" value="Alterar Usuário" action="javascript: formSubmit_alterar_usuario();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.internet.usuario.manter.alterar"/>
                	<s:Button name="relacionamento"  value="Alt. Relacionamento" action="javascript: formSubmit_alterar_relacionamento();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.internet.usuario.manter.alterar"/>
                	<s:Button name="senha" value="Alterar Senha" action="javascript: formSubmit_alterar_senha();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.internet.usuario.manter.alterar"/>
                	<s:Button name="exc_relacionamento"  value="Exc. Relacionamento" action="javascript: formSubmit_excluir_relacionamento();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.internet.usuario.manter.alterar"/>
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

    function formSubmit_alterar_usuario() { // Acao default alterar
	    document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_ALTERAR_USU_INICIAR%>";	    
		formSubmit();
	}

    function formSubmit_alterar_relacionamento() { // Acao default alterar
	    document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_ALTERAR_REL_INICIAR%>";	
		formSubmit();
	}

    function formSubmit_alterar_senha() { // Acao default alterar
	    document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_ALTERAR_SEN_INICIAR%>";	
		formSubmit();
	}		
	
    function formSubmit_excluir_relacionamento() { //GMG:27.11.2004
			if (confirm(conf("102", "Cliente Internet"))) {
		    document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_EXCLUIR_REL_FINALIZAR%>";
				formSubmit();
			}
	}
	
    function formSubmit() { // Acao default alterar
			document.frmMain.submit();
	}
	
	function formSubmit_Voltar() {
        document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_MANTER_INICIAR%>";
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
    }
      
   </script>
  </s:FormStrategy>
</p:Document>
</html>