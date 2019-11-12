<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: cliinte_alterar_senha.jsp - Java Server Pages
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
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CliInteEstrategia"%>

<%@page import="br.gov.caixa.sigcb.util.Formatador"%>

<%
  CedenteCabecaBean cedCabBean = (session.getAttribute(CliInteEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(CliInteEstrategia.CEDENTE_CABECALHO_BEAN));
  ClienteInternetBean clienteInternetBean = (session.getAttribute(CliInteEstrategia.DATA_BEAN)==null?new ClienteInternetBean():(ClienteInternetBean)session.getAttribute(CliInteEstrategia.DATA_BEAN));
%>


<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle" 
    estrategia="<%=CliInteEstrategia.STRATEGY_ALTERAR_SEN_FINALIZAR%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="<%=CliInteEstrategia.PAGE_TITLE_ALTERAR_SEN%>"/>

    <input type="hidden" name = "cpfUsuario" value='<%=clienteInternetBean.getCpfUsuario()%>'>
    
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
  				<td class="textoTitulo" width="17%">CPF Usuário: </td>
	    	    <td class="textoValor" width="26%"><%=Formatador.formatarCpf(clienteInternetBean.getCpfUsuario()+"")%></td>
            </tr>
            <tr>
  				<td class="textoTitulo" width="17%">Nome Usuário: </td>
				<td class="textoValor" width="26%"><%=clienteInternetBean.getNomeUsuario()%></td>
  				<td colspan="2"></td>
	        </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Alterar Senha Cliente Internet:<hr></td>
            </tr>
			<tr>
				<td nowrap class="textoTitulo" width="17%">Senha:</td>
				<td width="26%" nowrap>
					<input type="password" class="inputtext" name="senha" size="14" maxlength="6"
					onKeyPress='return validaDigitacaoAlfanumericoSenha(String.fromCharCode(event.charCode || event.keyCode))'
    	            onFocus='javascript: prevFocus(this);'
	                onKeyUp='javascript: nextFocus(event.keyCode, this, document.frmMain.senha1);'>
				</td>
				<td nowrap class="textoTitulo" width="17%">Repetir Senha:</td>
				<td width="26%" nowrap>
					<input type="password" class="inputtext" name="senha1" size="14" maxlength="6"
					onKeyPress='return validaDigitacaoAlfanumericoSenha(String.fromCharCode(event.charCode || event.keyCode))'
    	            onFocus='javascript: prevFocus(this);'
	                onKeyUp='javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);'>					
	                
				</td>
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
	    	document.frmMain.senha.focus();
	    }

	    function validaDigitacaoAlfanumericoSenha(valor) { 
	        numerosInteiros = '1234567890';
	        alfa = 'abcdefghijklmnopqrstuvxzkwyABCDEFGHIJLMNOPQRSTUVXZKWY';
	        if ((numerosInteiros.indexOf(valor) >= 0) || (alfa.indexOf(valor) >= 0)) {
	            return true;
	        } else {
	            return false;
	        }
	    }
    	function validaSubmit() {
		   	if(!validaCampoObrigatorio(document.frmMain.senha,'Senha')) return false;
	   		if(!validaCampoObrigatorio(document.frmMain.senha1,'Confirmação Senha')) return false;
		    if (document.frmMain.senha.value != document.frmMain.senha1.value) {
		    	msg("052");
	    		return false;
	    	}
			if(!validaTamanhoSenha(document.frmMain.senha.value)) return false;
			if(!validaTamanhoSenha(document.frmMain.senha1.value)) return false;
			if(!validarSenha(document.frmMain.senha.value)) return false;   
        	return true;
		}
      
		function formSubmit() {
    		if (validaSubmit()) {
          		if (confirm(conf("144", "Senha de Cliente Internet"))) {
	    	    	document.frmMain.submit();
				}
      		}
		}
		function formSubmit_Voltar() {
	    	if (confirm(conf("103"))) {
	       		document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_MANTER_LISTAR%>";
	    		document.frmMain.fluxo.value = "voltar";
		    	document.frmMain.submit();
		    }
	  	}  
	  	
		function validaTamanhoSenha(senha) {
	  		if (senha.length != 6) {
	  			msg('055');
		  		return false;
		  	} else {
	  			return true;
		  	}
		}      

		function validarSenha(senha) {
		        var numerosIda = '0123456789';
		        var numerosVolta = '9876543210';
		        var letrasMaiusculasIda = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
		        var letrasMaiusculasVolta = 'ZYXWVUTSRQPONMLKJIHGFEDCBA';
		        var letrasMinusculasIda = letrasMaiusculasIda.toLowerCase();
		        var letrasMinusculasVolta = letrasMaiusculasVolta.toLowerCase();
		        var sequencial = numerosIda + '||' + letrasMaiusculasIda + '||' + letrasMinusculasIda + numerosVolta + '||' + letrasMaiusculasVolta + '||' + letrasMinusculasVolta;
		        for(var i = 0; i < senha.length ; i++){
		            if(sequencial.indexOf(senha.charAt(i)) == -1 || senha.charAt(i) == '|') {
		                alert('A senha não deve ter caracter(es) especial(is)!');
		                return false;
		            }
				}
		        if(!obtemTipoCampo(senha)== 'alfanumerico'){
		            alert('A senha deve ser alfanumerica -> ' + obtemTipoCampo(senha) + '!');
		            return false;
		        }
		        for(var i = 0; i < senha.length; i++){
		            var c = senha.charAt(i);
		            if(i + 2 < senha.length) {
		                if(c == senha.charAt(i + 1) && c == senha.charAt(i + 2)) {
		                    alert('A senha não deve ter 3 caracteres iguais sequenciais!');
		                    return false;
		                }
		                if(sequencial.indexOf(senha.substring(i, i + 3)) != -1){
		                    alert('A senha não deve ter 3 caracteres iguais sequenciais!');
		                    return false;
		                }
		            }
		            var numCaracteresIguais = 0;
		            for(var j = 0; j < senha.length; j++){
		                if(c == senha.charAt(j))
		                    numCaracteresIguais++;
		                if(numCaracteresIguais > 2)
		                {
		                    alert('A senha não deve ter 3 caracteres iguais alternados!');
		                    return false;
		                }
		            }
		
		            var indiceAnterior = -1;
		            var indicePosterior = -1;
		            var indiceAtual = sequencial.indexOf(c);
		            if(i > 0 && indiceAtual != 0)
		                indiceAnterior = senha.indexOf(sequencial.charAt(indiceAtual - 1));
		            if(indiceAtual != 121)
		                indicePosterior = senha.indexOf(sequencial.charAt(indiceAtual + 1));
		            if(indiceAnterior > -1 && indicePosterior > -1 && i > 0 && (indiceAnterior < i && i < indicePosterior || indiceAnterior > i && i > indicePosterior)){
		                alert('A senha não deve ter n\372meros ou letras sequ\352nciais alternados!');
		                return false;
		            }
		        }
		
		        return true;
		    }
		    
		function obtemTipoCampo( texto)  {
	        numerosInteiros = '1234567890';
	        letras = 'abcdefghijklmnopqrstuvxzkwyABCDEFGHIJLMNOPQRSTUVXZKWY';
	        var alfa = false;
	        var numerico = false;
	        for(var i = 0; i < texto.length; i++) {
	        	if (letras.indexOf(texto.charAt(i)) != -1)
	        		alfa = true;
	        	if (numerosInteiros.indexOf(texto.charAt(i)) != -1)
	                numerico = true;
	            if(numerico && alfa)
	                break;
	        }
	        if(numerico && alfa)
	            return 'alfanumerico';
	        if(numerico && !alfa)
	            return 'numerico';
	        else
	            return 'alfa';
		}
		
		
		function send_url(apikey)
		{
		    var urlvariable;

		    urlvariable = "=gcb&tipoSenha=ecpin";

		    var ItemJSON;

			URL = "https://api.des.caixa:8443/seguranca/senha/v1/ecc/parametrospublicos?siglaSistemaOrigem" + urlvariable;  

		    var xmlhttp = new XMLHttpRequest();
		    xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
		    xmlhttp.open("GET", URL, false);
		    xmlhttp.setRequestHeader("Content-Type", "application/json");
		    xmlhttp.setRequestHeader('apikey', apikey);
		    xmlhttp.send(ItemJSON);
		    alert(xmlhttp.responseText);
		    document.getElementById("div").innerHTML = xmlhttp.statusText + ":" + xmlhttp.status + "<BR><textarea rows='100' cols='100'>" + xmlhttp.responseText + "</textarea>";
		}
		
		
    </script>
  </s:FormStrategy>
</p:Document>
</html>