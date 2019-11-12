<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: cliinte_incluir.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 16/11/2004 16:08
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ClienteInternetBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CliInteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%
  CedenteCabecaBean cedCabBean = (session.getAttribute(CliInteEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(CliInteEstrategia.CEDENTE_CABECALHO_BEAN));
  ClienteInternetBean clienteInternetBean = (session.getAttribute(CliInteEstrategia.DATA_BEAN)==null?new ClienteInternetBean():(ClienteInternetBean)session.getAttribute(CliInteEstrategia.DATA_BEAN));
  Long cpfUsuarioNovo = session.getAttribute("cpfUsuarioNovo")==null  ? new Long(0) : (Long)session.getAttribute("cpfUsuarioNovo");
  session.removeAttribute("cpfUsuarioNovo");
%>


<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle" 
    estrategia="<%=CliInteEstrategia.STRATEGY_ALTERAR_REL_FINALIZAR%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="<%=CliInteEstrategia.PAGE_TITLE_ALTERAR_REL%>"/>

    <input type="hidden" name = "codigoCedente" value="<%=clienteInternetBean.getCodigoCedente()%>">
    <input type="hidden" name = "cpfUsuario" value=''>
    
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
	        <tr>
  				<td class="textoTitulo" width="17%">Cedente: </td>
	            <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
				<td class="textoTitulo" width="17%">Nome: </td>
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
  				<td colspan="2"></td>
	        </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Alterar Relacionamento Cliente Internet:<hr></td>
            </tr>
  				<td class="textoTitulo" width="17%">CPF Anterior: </td>
	    	    <td class="textoValor" width="26%"><%=clienteInternetBean.getCpfUsuario()==null ? "" : Formatador.formatarCpf(clienteInternetBean.getCpfUsuario().toString())%></td>
  				<td class="textoTitulo" width="17%">Nome: </td>
				<td class="textoValor" width="26%"><%=clienteInternetBean.getNomeUsuario()==null ? "" :clienteInternetBean.getNomeUsuario()%></td>
			<tr>
				<td nowrap class="textoTitulo" width="17%">CPF Novo:</td>
				<td class="textoValor" width="26%" nowrap>
					<p:InputCpf CLASS="inputtext" name="inputCpfUsuario" disabled='false'
		          		onFocus="javascript:unFormataCPF(this);prevFocus(this);"							
				    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"
				    	value='<%=cpfUsuarioNovo==null ? "": cpfUsuarioNovo.equals(new Long(0)) ? "": Formatador.formatarCpf(cpfUsuarioNovo.toString())%>'
				    	/>
				    	
				</td>
			    <td colspan="2">&nbsp;</td>				
			</tr>
		    <tr> 
		      <td colspan="4">&nbsp;</td>
		    </tr>
		    <tr>
		      <td align="right" colspan="4">
		          <p align="center"> 
		          <s:Button name="Confirmar" action="javascript:formSubmit()"/>
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
      	document.frmMain.inputCpfUsuario.focus();
      }

      function validaSubmit() {
        //novo usuario deve ser diferente do atual.
        var atual = <%=clienteInternetBean.getCpfUsuario()==null ? "0" : clienteInternetBean.getCpfUsuario().equals(new Long(0)) ? "0" : clienteInternetBean.getCpfUsuario().toString()%>;
				if(!validaDVCPF(document.frmMain.inputCpfUsuario)){
					msg('008','CPF Usuário');
					return false;
				}			
        
		    if (document.frmMain.cpfUsuario.value ==  atual) {
			    msg('054');
			    return false;
				}
        return true;
      }
      
      function formSubmit() {
			document.frmMain.cpfUsuario.value = document.frmMain.inputCpfUsuario.value;
			unFormataCPF(document.frmMain.cpfUsuario);      
    		if (validaSubmit()) {
          		if (confirm(conf("101", "Relacionamento Cliente Internet"))) {
	    	    	document.frmMain.submit();
				}
      		}
      }
		function formSubmit_Voltar() {
	    	if (confirm(conf("103"))) {
	    		//if (<%=cpfUsuarioNovo.toString()%> != 0)
		      // 		document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_INCLUIR_INICIAR%>";
	       	//	else 
		       		document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_MANTER_LISTAR%>";
	       		
	    		document.frmMain.fluxo.value = "voltar";
		    	document.frmMain.submit();
		    }
	  	}  
      
    </script>
  </s:FormStrategy>
</p:Document>
</html>