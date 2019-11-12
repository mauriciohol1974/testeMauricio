<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bordero_sucesso.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 09/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BorderoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>


<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(BorderoEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(BorderoEstrategia.MSG_BEAN);
	}
%>

<%
	BorderoBean borderoBean = (session.getAttribute(BorderoEstrategia.DATA_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(BorderoEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>    
    <input type="hidden" name="codigoCedente" value="<%=borderoBean.getCodigoCedente()%>">
    <input type="hidden" name="codigoBordero" value="<%=borderoBean.getCodigoBordero()%>">
    <input type="hidden" name="situacao" value="<%=borderoBean.getSituacao()%>">
   	<input type="hidden" name="navegacao" >

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="center"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoCedente().equals( new Long(0))?"":borderoBean.getCodigoCedenteFormatado()%></td>
  
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" nowrap width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
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
  
              <td class="textoTitulo" width="17%">Borderô: </td>
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoBordero().equals( new Long(0))?"":borderoBean.getCodigoBordero().toString()%></td>
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
						<!--
						/***********************************************
						*Página de Sucesso para Bordero Incluir
						************************************************/
						-->
						<% if (borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_INCLUIR)) {%> 
            <tr>
              <td width="58%" class="textoDestaqueTitulo" align="right">Numero do Borderô: </td>
              <td width="42%" class="textoValor" align="left">&nbsp;<%=borderoBean.getCodigoBordero()%></td>
            </tr>
            <tr>
              <td colspan = "2" class="textoTitulo" align="center">(Não há titulos cadastrados no borderô)</td>
            </tr>

            <tr>
              <td colspan="2">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="2">&nbsp;</td>
            </tr>
            
            <tr>
 	          	<td class="textoTitulo" align="right">Clique para incluir títulos neste Borderô:&nbsp;</td>
              <td align="left">
                <s:Button name="Incluir Títulos" value="IncluirTitulos" action="javascript:formSubmit_IncluirTitulos()"/>
              </td>
            </tr>
						<!--
						/***********************************************
						*Página de Sucesso para Bordero Alterar
						************************************************/
						-->
						<%} 
							if (borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_ALTERAR)) {%> 
						<tr>	
						 <td class="textoDestaqueTitulo" align="center" colspan="2">Borderô não finalizado.</td>
						</tr>
						 <tr>
              <td colspan="2">&nbsp;</td>
            </tr>
						<!--
						/***********************************************
						*Página de Sucesso para Bordero Incluir/Alterar
						************************************************/
						-->
						<%} 
							if (borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_INCLUIR) || 
									borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_ALTERAR)) {%> 
            <tr>
 	          	<td width="58%" class="textoTitulo" align="right">Clique para passar à tela de Manter Titulos:&nbsp;</td>
              <td width="42%" align="left">
                <s:Button name="ManterTitulos" value="Manter Títulos" action="javascript:formSubmit_ManterTitulos()"/>
              </td>
            </tr>
						<!--
						/***********************************************
						*Página de Sucesso para Bordero Finalizar
						************************************************/
						-->
						<%}
						if (borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_FINALIZAR)) {%> 
            <tr>
              <td width="58%" class="textoDestaqueTitulo" align="right">Numero do Borderô: </td>
              <td width="42%" class="textoValor" align="left">&nbsp;<%=borderoBean.getCodigoBordero()%></td>
            </tr>
            <tr>
              <td colspan="2">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="2">&nbsp;</td>
            </tr>
            
            <tr>
							<td class="textoTitulo" align="right">Clique para incluir Novo Borderô:&nbsp;</td>
              <td align="left">
                <s:Button name="NovoBordero" value="Novo Borderô" action="javascript:formSubmit_Novo()"/>
              </td>
            </tr>
												<!--
						/***********************************************
						*Página de Sucesso para Bordero Excluir
						************************************************/
						-->
						<%}
						if (borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_EXCLUIR)) {%> 
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
						<%}%>
          
          
          </table>
        </td>
      </tr>
    </table>
    <script language="javascript">
	    function formSubmit() {
      			<%if (borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_EXCLUIR)) {%> 
      			document.frmMain.estrategia.value = "<%=msgBean.getStrategySucessReturn()%>";
	          document.frmMain.codigoBordero.value = "0";
	          document.frmMain.submit();
	          <%}%>
      }
	    
	    function inicia(){
	    <%if (borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_FINALIZAR)) {%> 
				retorno = window.open("<%=Paths.getRootForDynamicContent()%>/jump/bordero_jump.jsp","relatorio<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "width=780,height=540,top=0,left=0,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=1");
	    <%}%>
	    }
	    
			<% if (borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_INCLUIR)) {%> 
	    function formSubmit_IncluirTitulos() {
        if (validaInserir()) {
	          document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_INCLUIR%>";
	          document.frmMain.submit();
        }
	    }
			<%} 
			if (borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_INCLUIR) || 
					borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_ALTERAR)) {%> 
	    function formSubmit_ManterTitulos() {
        if (validaInserir()) {
	          document.frmMain.estrategia.value = "<%=BorderoEstrategia.STRATEGY_MANTER_LISTAR%>";
     	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_LISTA_TITULO%>';	          
	          document.frmMain.submit();
        }
	    }
			<%}
			if (borderoBean.getNavegacao().equals(BorderoEstrategia.NAVEGACAO_FINALIZAR)) {%> 
	    function formSubmit_Novo() {
        if (validaInserir()) {
		        document.frmMain.estrategia.value = "<%=BorderoEstrategia.STRATEGY_INCLUIR_FILTRO%>";
	          document.frmMain.submit();
        }
	    }
			<%}%>      
      function validaInserir() {
      	return (true);
     	}
    </script>
  </s:FormStrategy>
</p:Document>
</html>    