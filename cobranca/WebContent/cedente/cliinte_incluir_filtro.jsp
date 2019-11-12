<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: cliinte_incluir_filtro.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 09/11/2004 10:53
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CliInteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.ClienteInternetBean"%>

<%
  ClienteInternetBean cliBean = (session.getAttribute(CliInteEstrategia.FILTRO_BEAN)==null?new ClienteInternetBean():(ClienteInternetBean)session.getAttribute(CliInteEstrategia.FILTRO_BEAN));
  cliBean.setCodigoCedente(session.getAttribute(CliInteEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(CliInteEstrategia.CEDENTE_ATUAL));
  if (cliBean.getTipoPesquisa() == null) cliBean.setTipoPesquisa(new Long (0));
%>
<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle" 
  estrategia="<%=CliInteEstrategia.STRATEGY_INCLUIR_FILTRO%>" fluxo="normal">
    <s:Menu/>
    <input type="hidden" name = "tipoPesquisa" value="2">
    <input type="hidden" name = "cpfUsuario" value="">
	<input type="hidden" name = "cpfCnpjCedente" value="">
    
    <s:Titulo name="<%=CliInteEstrategia.PAGE_TITLE_INCLUIR_FILTRO%>"/>
      <table width="777" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td valign="top" width="95%" height="14" align="left"> 
                <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" align="center">
                    <tr> 
						<td class="textoTitulo" width="2%">
							<input type="radio" name="radioTipoConsulta" onclick="javascript:radioSelected(2);" <%=(cliBean.getTipoPesquisa().equals(new Long(2)))?"checked":""%>>
						</td>                  
						<td class="textoTitulo" width="17%">Cedente: </td>
						<td class="textoValor" nowrap width="26%"> 
							<p:InputNumerico CLASS="inputtext" name="codigoCedente" size="8" maxlength="7" disabled="true" 
						    	value='<%=cliBean.getCodigoCedente().equals(new Long(0))?"":cliBean.getCodigoCedente().toString()%>'
						    	onFocus="javascript: prevFocus(this);"
						    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.inputCpfUsuario);"
						    	/>                        
						</td>
						<td width="17%">&nbsp;</td>
						<td width="26%">&nbsp;</td>
                    </tr>
                    <tr> 
						<td class="textoTitulo" width="2%">
							<input type="radio" name="radioTipoConsulta" onclick="javascript:radioSelected(1);" <%=(cliBean.getTipoPesquisa().equals(new Long(1)))?"checked":""%>>
						</td>                  
						<td class="textoTitulo" width="17%">CPF/CNPJ:</td>
						<td class="textoValor" nowrap width="26%"> 
			               	<s:ComboTipoPessoa name="tipoPessoaCedente" disabled="true" 
									    	selectedValue='<%=cliBean.getTipoPessoaCedente().toString()%>'
			               		onChange="javascript:limpaCpfCnpj(inputCpfCnpjCedente);"
			               	/>
							<p:InputCpfCnpj CLASS="inputtext" name="inputCpfCnpjCedente" disabled="true"
						    	value='<%=cliBean.getCpfCnpjCedente().equals(new Long(0))?"":cliBean.getCpfCnpjCedenteFormatado()%>'
	    		          		onFocus="javascript:unFormataCpfCnpj(this, tipoPessoaCedente);prevFocus(this);"							
			              		onBlur="javascript:formataCpfCnpj(this, tipoPessoaCedente);" 
						    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.inputCpfUsuario);"
						    	/>
						</td>
						<td width="17%">&nbsp;</td>
						<td width="26%">&nbsp;</td>
                    </tr>
                    <tr>
						<td class="textoTitulo" width="2%">&nbsp;</td>
						<td class="textoTitulo" width="17%">CPF Usuário:</td>
						<td class="textoValor" nowrap width="26%">
							<p:InputCpf CLASS="inputtext" name="inputCpfUsuario" 
						    	value='<%=cliBean.getCpfUsuario().equals(new Long(0))?"":cliBean.getCpfUsuarioFormatado()%>'
	    		          		onFocus="javascript:unFormataCPF(this);prevFocus(this);"							
			              		onBlur="" 
						    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
						</td>
						<td width="17%">&nbsp;</td>
						<td width="26%">&nbsp;</td>
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
				</table>
            </TD>
          </tr>
      </table>
      <script>
		function inicia(){
			setFirstFieldFocus();
			<%//EAM/05/09/05%>
			radioSelected('<%=cliBean.getTipoPesquisa().toString()%>');
		}

		function formSubmit(){
			document.frmMain.Ok.focus();
			if(validaSubmit()){
				document.frmMain.submit();
			}
		}


		function validaSubmit() {
			if (validaRadioButton(document.frmMain.radioTipoConsulta, 'Tipo Consulta')) {
				if (document.frmMain.radioTipoConsulta[0].checked) {
					if (!validaCampoObrigatorio(document.frmMain.codigoCedente,'Cedente'))
						return false;
				} else if (document.frmMain.radioTipoConsulta[1].checked) {
					if (!validaCampoObrigatorio(document.frmMain.inputCpfCnpjCedente,'CPF/CNPJ'))
						return false;
	  			if(!validaDvCpfCnpj(document.frmMain.inputCpfCnpjCedente,document.frmMain.tipoPessoaCedente)){
						msg('008','CPF/CNPJ Cedente');
						return false;
					}
					document.frmMain.cpfCnpjCedente.value = document.frmMain.inputCpfCnpjCedente.value;
					unFormataCpfCnpj(document.frmMain.cpfCnpjCedente, document.frmMain.tipoPessoaCedente);
				}
				if (!validaCampoObrigatorio(document.frmMain.inputCpfUsuario,'CPF Usuário')) 
					return false;
	  		if(!validaDVCPF(document.frmMain.inputCpfUsuario)){
					msg('008','CPF Usuário');
					return false;
				}			
				document.frmMain.cpfUsuario.value = document.frmMain.inputCpfUsuario.value;
				unFormataCPF(document.frmMain.cpfUsuario);
				return true;		
			} 
      	}
		function radioSelected(escolha) {
		  if (escolha=="1"){ //cpf cnpj
		      document.frmMain.codigoCedente.value="";
		      document.frmMain.codigoCedente.disabled=true;
		      document.frmMain.inputCpfCnpjCedente.disabled=false;
		      document.frmMain.tipoPessoaCedente.disabled=false;
		      document.frmMain.tipoPesquisa.value="1";
		      document.frmMain.inputCpfCnpjCedente.focus();
			}else { //cedente
		      document.frmMain.radioTipoConsulta[0].checked = true;	  
		      document.frmMain.codigoCedente.value="<%=cliBean.getCodigoCedente().equals(new Long(0)) ? "": cliBean.getCodigoCedente().toString()%>";		    
		      document.frmMain.inputCpfCnpjCedente.value="";
		      document.frmMain.codigoCedente.disabled=false;
		      document.frmMain.inputCpfCnpjCedente.disabled=true;
		      document.frmMain.tipoPessoaCedente.disabled=true;
		      document.frmMain.tipoPesquisa.value="2";
		      document.frmMain.codigoCedente.focus();
		  }
		}      
    </script>
  </s:FormStrategy>
</p:Document>
</html>