<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Dezembro de 2004
*Projeto CAIXA - SIGCB
*Componente: cliinte_altinc.jsp - Java Server Pages
*Autor: Glauber M. Gallego
*Ultima Atualização: 13/12/2004 16:08
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
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.com.politec.sao.util.Formatacao"%>
<%
  CedenteCabecaBean cedCabBean = (session.getAttribute(CliInteEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(CliInteEstrategia.CEDENTE_CABECALHO_BEAN));
  ClienteInternetBean clienteInternetBean;
  if (session.getAttribute(CliInteEstrategia.DATA_BEAN)==null) {
	  clienteInternetBean = new ClienteInternetBean();
	  clienteInternetBean = (ClienteInternetBean) clienteInternetBean.newBean();
  }else{
  	 clienteInternetBean = (ClienteInternetBean)session.getAttribute(CliInteEstrategia.DATA_BEAN);
  }
%>


<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle" 
    estrategia="<%=CliInteEstrategia.STRATEGY_ALTINC_USU_FINALIZAR%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="<%=CliInteEstrategia.PAGE_TITLE_ALTINC_USU%>"/>

    <input type="hidden" name = "codigoCedente" value="<%=cedCabBean.getCodigoCedente()%>">
    <input type="hidden" name = "cpfUsuario" value="<%=clienteInternetBean.getCpfUsuario()%>">

 		<input type="hidden" name ="cep" value=''>
 		<input type="hidden" name ="endereco" value=''>
 		<input type="hidden" name ="bairro" value=''>
 		<input type="hidden" name ="municipio" value=''>
 		<input type="hidden" name ="uf" value=''>

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
  				<td class="textoTitulo" width="17%">CPF do Usuário: </td>
	            <td class="textoValor" width="26%"><%=Formatador.formatarCpf(clienteInternetBean.getCpfUsuario()+"")%></td>
	        </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Incluir Cliente Internet:<hr></td>
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
	                onKeyUp='javascript: nextFocus(event.keyCode, this, document.frmMain.nome);'>					
				</td>
			</tr>
			
			<tr>
				<td nowrap class="textoTitulo" width="17%">Nome:</td>
				<td class="textoValor" width="26%" nowrap>
					<p:InputAlfanumerico CLASS="inputtext" name="nome" size="30" maxlength="40"
					value='<%=clienteInternetBean.getNome()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.cepInput);"
					/>					
				</td>
				<td class="textoTitulo" width="17%">CEP:</td>
				<td class="textoValor" width="26%">
                  <p:InputCep name="cepInput"
                  value="" CLASS="inputtext"
                  onFocus="javascript: prevFocus(this);"
                  onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.ufInput);"
                  value='<%=clienteInternetBean.getCep().longValue()==0 ? "" : Formatacao.formataCep(clienteInternetBean.getCep())%>'/>
				<input type="button" class="button" name="Procurar" value="Procurar" onclick="javascript:formSubmit_ProcurarCEP();"> 
				</td>
			</tr>
			
			<tr>
				<td class="textoTitulo" width="17%">UF:</td>
				<td class="textoValor" width="26%">
					<s:ComboUf name="ufInput" selectedValue='<%=clienteInternetBean.getUf()%>' 
					onChange='javascript:validaAlteracaoEndereco()'/>
				</td>
				<td class="textoTitulo" width="17%">Endere&ccedil;o:</td>
				<td width="26%" nowrap>
					<p:InputAlfanumericoCep CLASS="inputtext" name="enderecoInput" size="30" maxlength="40"
					value='<%=clienteInternetBean.getEndereco()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.numero);"
					/>					
				</td>
			</tr>
			
			<tr>
				<td class="textoTitulo" width="17%">N&uacute;mero:</td>
				<td class="textoValor" width="26%">
					<p:InputNumerico CLASS="inputtext" name="numero" size="14" maxlength="10"
					value='<%=clienteInternetBean.getNumero().longValue()==0? "": clienteInternetBean.getNumero().toString()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.complemento);"
					/>
				</td>
				<td class="textoTitulo" width="17%">Complemento:</td>
				<td width="26%" nowrap>
					<p:InputAlfanumerico CLASS="inputtext" name="complemento" size="30" maxlength="15"
					value='<%=clienteInternetBean.getComplemento()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.bairroInput);"
					/>
				</td>
			</tr>
			
			<tr>
				<td class="textoTitulo" width="17%">Bairro:</td>
				<td class="textoValor" width="26%">
					<p:InputAlfanumericoCep CLASS="inputtext" name="bairroInput" size="30" maxlength="25"
					value='<%=clienteInternetBean.getBairro()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.municipioInput);"
					/>					
				</td>
				<td class="textoTitulo" width="17%">Munic&iacute;pio:</td>
				<td class="textoValor" width="26%">
					<p:InputAlfanumericoCep CLASS="inputtext" name="municipioInput" size="30" maxlength="35"
					value='<%=clienteInternetBean.getMunicipio()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.email);"
					/>					
				</td>
			</tr>
			
			<tr>
				<td class="textoTitulo" width="17%">e-mail:</td>
				<td class="textoValor" width="26%">
					<p:InputEmail CLASS="inputtext" name="email" size="30" maxlength="50"
					value='<%=clienteInternetBean.getEmail()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.departamento);"
					/>
				</td>
				<td class="textoTitulo" width="17%">Departamento:</td>
				<td class="textoValor" width="26%">
					<p:InputAlfanumerico CLASS="inputtext" name="departamento" size="30" maxlength="40"
					value='<%=clienteInternetBean.getDepartamento()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dddTelefone);"
					/>					
				</td>
			</tr>
			
			<tr>
				<td nowrap class="textoTitulo" width="17%">Telefone:</td>
				<td width="26%" nowrap>
					(
					<p:InputNumerico CLASS="inputtext" name="dddTelefone" size="4" maxlength="3"
					value='<%=clienteInternetBean.getDddTelefone().longValue()==0 ? "" : clienteInternetBean.getDddTelefone().toString()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.numeroTelefone);"
					/>					
					)
					<p:InputNumerico CLASS="inputtext" name="numeroTelefone" size="14" maxlength="8"
					value='<%=clienteInternetBean.getNumeroTelefone()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.ramalTelefone);"
					/>					
					
				</td>
				<td nowrap class="textoTitulo" width="17%">Ramal:</td>
				<td width="26%" nowrap>
					<p:InputNumerico CLASS="inputtext" name="ramalTelefone" size="5" maxlength="4"
					value='<%=clienteInternetBean.getRamalTelefone().longValue()==0 ? "" : clienteInternetBean.getRamalTelefone().toString()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dddFax);"
					/>					
				</td>
			</tr>
			
			<tr>
				<td nowrap class="textoTitulo" width="17%">Fax:</td>
				<td width="26%" nowrap>
					(
					<p:InputNumerico CLASS="inputtext" name="dddFax" size="4" maxlength="3"
					value='<%=clienteInternetBean.getDddFax().longValue()==0 ? "" : clienteInternetBean.getDddFax().toString()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.numeroFax);"
					/>					
					)
					<p:InputNumerico CLASS="inputtext" name="numeroFax" size="14" maxlength="8"
					value='<%=clienteInternetBean.getNumeroFax().longValue()==0 ? "" : clienteInternetBean.getNumeroFax().toString()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.ramalFax);"
					/>
				</td>
				<td nowrap class="textoTitulo" width="17%">Ramal:</td>
				<td width="26%" nowrap>
					<p:InputNumerico CLASS="inputtext" name="ramalFax" size="5" maxlength="4"
					value='<%=clienteInternetBean.getRamalFax().longValue()==0 ? "" : clienteInternetBean.getRamalFax().toString()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dddCelular);"
					/>				
				</td>
			</tr>
			
			<tr>
				<td nowrap class="textoTitulo" width="17%">Celular:</td>
				<td width="26%" nowrap>
					(
					<p:InputNumerico CLASS="inputtext" name="dddCelular" size="4" maxlength="3"
					value='<%=clienteInternetBean.getDddCelular().longValue()==0 ? "" : clienteInternetBean.getDddCelular().toString()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.numeroCelular);"
					/>					
					)
					<p:InputNumerico CLASS="inputtext" name="numeroCelular" size="14" maxlength="8"
					value='<%=clienteInternetBean.getNumeroCelular().longValue()==0 ? "" : clienteInternetBean.getNumeroCelular().toString()%>'
			    	onFocus="javascript: prevFocus(this);"
			    	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"
					/>
				</td>
				<td class="textoTitulo" width="17%">&nbsp;</td>
				<td width="26%" nowrap>&nbsp;</td>
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
      
	  function validaTamanhoSenha(senha) {
	  	if (senha.length != 6) {
	  		msg('055');
	  		return false;
	  	} else {
	  		return true;
	  	}
	  }
	  
		function validaSubmit() {

    	var camposObrigatorios = new Array(12);
    	camposObrigatorios[2] = new Array( "nome", "Nome" );
    	camposObrigatorios[3] = new Array( "cepInput", "CEP" );
    	camposObrigatorios[4] = new Array( "ufInput", "UF" );
    	camposObrigatorios[5] = new Array( "enderecoInput", "Endereço" );
    	camposObrigatorios[6] = new Array( "numero", "Numero" );
    	camposObrigatorios[7] = new Array( "bairroInput", "Bairro" );
    	camposObrigatorios[8] = new Array( "municipioInput", "Município" );
	    camposObrigatorios[9] = new Array( "dddTelefone", "DDD Telefone" );
	    camposObrigatorios[10] = new Array( "numeroTelefone", "Telefone" );
	    
	   	if(!validaCampoObrigatorio(document.frmMain.senha,'Senha')) 
	   		return false;
	   	if(!validaCampoObrigatorio(document.frmMain.senha1,'Confirmação Senha')) 
	   		return false;
	    if (document.frmMain.senha.value != document.frmMain.senha1.value) {
	    	msg("052");
	    	document.frmMain.senha.focus();//GMG:27.11.2004
	    	return false;
	    }
			if(!validaTamanhoSenha(document.frmMain.senha.value)) {
				document.frmMain.senha.focus();//GMG:27.11.2004
				return false;
			}
			if(!validaTamanhoSenha(document.frmMain.senha1.value)) {
				document.frmMain.senha1.focus();//GMG:27.11.2004
				return false;
			}
	    if(!validaArrayCamposObrigatorios(camposObrigatorios)){
	      return false;
	    }      
	    if(!validarSenha(document.frmMain.senha.value)) {
	    	document.frmMain.senha.focus();//GMG:27.11.2004
	    	return false;
	    }
	    
	    document.frmMain.cep.value = document.frmMain.cepInput.value;
	    unFormataCep(document.frmMain.cep);
	    
	    if(!validaMenorIgual(document.frmMain.document.frmMain.cep, 'CEP', 0)) {
	    	return false;
      }
	    if(!validaMenorIgual(document.frmMain.document.frmMain.numero, 'Numero', 0)) {
	    	return false;
      }
	    
      if (document.frmMain.document.frmMain.dddFax.value != "" && 
      		document.frmMain.document.frmMain.numeroFax.value == "") {
				msg('001','Número Fax');
      	return false;
      } 
      if (document.frmMain.document.frmMain.dddFax.value == "" && 
      		document.frmMain.document.frmMain.numeroFax.value != "") {
				msg('001','DDD Fax');
      	return false;
      }
      if (document.frmMain.document.frmMain.dddFax.value == "" && 
      		document.frmMain.document.frmMain.ramalFax.value != "") {
				msg('001','DDD Fax');
      	return false;
      }
      if (document.frmMain.document.frmMain.numeroFax.value == "" &&
      		document.frmMain.document.frmMain.ramalFax.value != "") {
				msg('001','Número Fax');
      	return false;
      }

      if (document.frmMain.document.frmMain.dddCelular.value != "" && 
      		document.frmMain.document.frmMain.numeroCelular.value == "") {
				msg('001','Número Celular');
      	return false;
      } 
      if (document.frmMain.document.frmMain.dddCelular.value == "" && 
      		document.frmMain.document.frmMain.numeroCelular.value != "") {
				msg('001','DDD Celular');
      	return false;
      }	    
      	    	
	    document.frmMain.endereco.value = document.frmMain.enderecoInput.value ;
	    document.frmMain.bairro.value = document.frmMain.bairroInput.value ;
	    document.frmMain.municipio.value = document.frmMain.municipioInput.value;
	    document.frmMain.uf.value = document.frmMain.ufInput.value ;
	    
      return true;
    }
      
	    function formSubmit() {
    	    if (validaSubmit()) {
          		if (confirm(conf("100", "Cliente Internet"))) {
	    	        document.frmMain.submit();
    	      	}
        	}
      	}

		// Atencao: Para utilizar corretamente a tela/funcao de Pesquisa de Cep, é necessário:
		// - Possuir um form chamado frmMain
		// - No frmMain possuir os campos hidden: cep, endereco, bairro, municipio, uf
		// - Adaptar a funcao atualizar_endereco() para atualizar os campos de tela efetivos
		// - o form, os campos e a funcao sao referenciados pela tela de Pesquisa de Cep
		function formSubmit_ProcurarCEP() {
		    if(validaCampoObrigatorio(document.frmMain.cepInput, 'Cep Cliente Internet')){
				document.frmMain.cep.value = document.frmMain.cepInput.value;
				unFormataCep(document.frmMain.cep);
				var valorAltura = 180;
				var valorLargura = 450;
				var valorTopo = (screen.height - valorAltura) /2;
				var valorEsquerda = (screen.width - valorLargura) /2;
		    	var retorno = window.open('<%=Paths.getRootForDynamicContent()%>/jump/procurar_cep_jump.jsp', 
				'procurar_cep<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>', 
				'width=' +valorLargura+ ', height=' +valorAltura+ ', top=' +valorTopo+ ', left=' +valorEsquerda+ ', toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizable=0');
		    	retorno.focus();
		    }
	  	} 
  
		function atualizar_endereco() {
		    //EAM - procurarCep = variavel global criada pela tag InputAlfanumericoCep
				procurarCep = true;
		    document.frmMain.enderecoInput.value = document.frmMain.endereco.value;
		    document.frmMain.bairroInput.value = document.frmMain.bairro.value;
		    document.frmMain.municipioInput.value = document.frmMain.municipio.value;
		    document.frmMain.ufInput.value = document.frmMain.uf.value;
		    document.frmMain.numero.focus();				    
		}
      
		function formSubmit_Voltar() {
	    	if (confirm(conf("103"))) {
	       		document.frmMain.estrategia.value = "<%=CliInteEstrategia.STRATEGY_MANTER_LISTAR%>";
	    		document.frmMain.fluxo.value = "voltar";
		    	document.frmMain.submit();
		    }
	  	}  
	  	
	    function validaDigitacaoAlfanumericoSenha(valor) { 
    	    numerosInteiros = '1234567890';
	        alfa = 'abcdefghijklmnopqrstuvxzkwy ABCDEFGHIJLMNOPQRSTUVXZKWY';
        	if ((numerosInteiros.indexOf(valor) >= 0) || (alfa.indexOf(valor) >= 0)) {
    	        return true;
	        } else {
            	return false;
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
    </script>
  </s:FormStrategy>
</p:Document>
</html>