
<script language="javascript">
	history.go(+1);
</script>
<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.com.politec.sao.business.util.BeanList"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCarteiraBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteManterFiltroBean"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteAlterarEnderecoSicliBean"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteAlterarEnderecoSicliEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%
	CedenteCabecaBean cabecaBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
	                               ? new CedenteCabecaBean()
	                               : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

	CedenteManterFiltroBean filtroBean = (session.getAttribute(CedenteEstrategia.MANTER_FILTRO_BEAN)==null
	                                     ? new CedenteManterFiltroBean()
	                                     : (CedenteManterFiltroBean) session.getAttribute(CedenteEstrategia.MANTER_FILTRO_BEAN));

 	CedenteCarteiraBean fixoBean = (session.getAttribute(CedenteEstrategia.MANTER_FIXO_BEAN)==null
 	                               ? new CedenteCarteiraBean()
 	                               : (CedenteCarteiraBean)session.getAttribute(CedenteEstrategia.MANTER_FIXO_BEAN));

	ArrayList listaTitulos = (ArrayList) session.getAttribute(CedenteEstrategia.MANTER_LISTA_TITULOS_BEAN);
%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(CedenteAlterarEnderecoSicliEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(CedenteAlterarEnderecoSicliEstrategia.MSG_BEAN);
	}
%>

<%

	CedenteAlterarEnderecoSicliBean bean = (CedenteAlterarEnderecoSicliBean) request.getAttribute("beanResultado");

	String nome 				= bean.getNome()== null ? "" : bean.getNome();
	String tpLogradouro 		= bean.getTpLogradouro() == null ? "" : bean.getTpLogradouro();
	String logradouro 			= bean.getEndereco() == null ? "" : bean.getEndereco();
	String numero	 			= bean.getNumero() == null ? "" : bean.getNumero();
	String complemento 			= bean.getComplemento() == null ? "" : bean.getComplemento();
	String bairro	 			= bean.getBairro() == null ? "" : bean.getBairro();
	//String cep		 			= Util.toStr(bean.getCep());
    String cep                 = bean.getCep();
	String uf		 			= bean.getUf() == null ? "" : bean.getUf();
	String municipio 			= bean.getMunicipio() == null ? "" : bean.getMunicipio();
	
	String tpPessoa = bean.getTpPessoa();
	String nuPessoa = Util.toStr(bean.getNuPessoa());
	

	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean)session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia='<%=CedenteAlterarEnderecoSicliEstrategia.STRATEGY_ALTERAR_FINALIZAR%>' fluxo="normal">
		<s:Menu/>
		<s:Titulo name='<%=CedenteAlterarEnderecoSicliEstrategia.PAGE_TITLE_ALTERAR%>'/>

		<input type="hidden" name="codigoCedente" value="<%= cabecaBean.getCodigoCedente() %>">
		<input type="hidden" name="codigoUsuario" value="<%= usuarioBean.getCodigoUsuario() %>">
		<input type="hidden" name="cdMunicipio">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
	            <tr>
	              <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
	              <td class="textoValor" width="26%"><%= cabecaBean.getCodigoClienteCOCLI() %></td>
	              <td class="textoTitulo" width="17%">Carteira: </td>
	              <td class="textoValor" width="26%"><%= cabecaBean.getCarteira() %></td>
	            </tr>
	            <tr>
	              <td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
	              <td class="textoValor" width="26%"><%= cabecaBean.getTipoPessoaTexto() %></td>
	              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
	              <td class="textoValor" width="26%"><%= cabecaBean.getCpfCnpjFormatado() %></td>
	            </tr>
	            <tr>
	              <td class="textoTitulo" width="17%">Nome Cedente: </td>
	              <td class="textoValor" width="26%"><%= cabecaBean.getNomeFantasia() %></td>
	              <td class="textoTitulo" width="17%">Razão Social: </td>
	              <td class="textoValor" width="26%"><%= cabecaBean.getRazaoSocial() %></td>
	            </tr>
	            <tr>
	              <td class="textoTitulo" width="17%">e-mail: </td>
	              <td class="textoValor" width="26%"><%= cabecaBean.getEmail() %></td>
	              <td class="textoTitulo" width="17%">Endereço: </td>
	              <td class="textoValor" width="26%"><%= cabecaBean.getLogradouro() %>, <%= cabecaBean.getNumero() %></td>
	            </tr>
	            <tr>
	              <td class="textoTitulo" width="17%">Cedente:</td>
	              <td class="textoValor" width="26%"><%= cabecaBean.getCodigoCedenteFormatado() %></td>
	              <td class="textoTitulo" width="17%">&nbsp;</td>
	              <td class="textoValor" width="26%"><%= cabecaBean.getMunicipio() %>, <%= cabecaBean.getUf() %></td>
	            </tr>
	            <tr>
	              <td colspan="4">&nbsp;</td>
	            </tr>
			</table>
			<table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr valign="top">
              <td colspan="4" class="textoTitulo">Cadastro:
                <hr>
              </td>
            </tr>

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>

			<tr>
              <td class="textoTitulo" width="10%">Nome: </td>
              <td class="textoValor" width="26%"><p:InputAlfanumerico CLASS="inputtext" name="nome" value="<%= nome %>" size="40" maxlength="50"
	                                 onFocus="javascript: prevFocus(this);"
									                 onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.numero);"/>
              </td>
              <!--td class="textoValor" width="26%"><input type="text" class="inputtext" class="inputtext" name="nome" size="40" maxlength="50" value="MARCELO FRANCISCO SOUZA"></td-->
              <td class="textoTitulo" width="8%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="10%">Cep: </td>
              <td class="textoValor" width="26%"><p:InputNumerico value="<%= cep %>" CLASS="inputtext" name="cep" size="10" maxlength="8" onKeyUp="consultaCep()"/><!--&nbsp;&nbsp;<input type="button" class="button" value="Pesquisar" onclick="consultaCep()"/>--></td>
            </tr>  
			<%-- 
            <tr>
              <td class="textoTitulo" width="10%">Tipo logradouro: </td>--%>
            <!-- 
            <td class="textoValor" width="26%"><p:InputAlfanumerico CLASS="inputtext" name="tpLogradouro" value="<%= tpLogradouro %>" size="10" maxlength="10" disabled="true"
	                                 onFocus="javascript: prevFocus(this);"/>
              </td> 
              -->
            <!-- <td class="textoValor" width="26%"><input type="text" class="inputtext" class="inputtext" name="tpLogradouro" size="10" maxlength="10" value="<%=tpLogradouro%>" readonly="true"></td>
              <td class="textoTitulo" width="8%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>-->
            
			<tr>
              <td class="textoTitulo" width="10%">Logradouro: </td>
              <td class="textoValor" width="26%">
              	<p:InputAlfanumerico CLASS="inputtext" name="endereco" value="<%= logradouro %>" size="40" maxlength="50" onFocus="javascript: prevFocus(this);"/>
              </td>
              <!--td class="textoValor" width="26%"><input type="text" class="inputtext" class="inputtext" name="logradouro" size="40" maxlength="50" value="NAÇÕES UNIDAS DA AMÉRICA" disabled></td-->
              <td class="textoTitulo" width="8%">Número: </td>
              <td class="textoValor" width="26%">
              	<!-- <p:InputNumerico CLASS="inputtext" name="numero" size="10" maxlength="8" value="<%= numero %>"/>-->
              	<p:InputAlfanumerico CLASS="inputtext" name="numero" size="10" maxlength="8" value="<%= numero %>"/>
              </td>
              <!--td class="textoValor" width="26%"><input type="text" class="inputtext" class="inputtext" name="numero" size="6" maxlength="6" value="555"></td-->
            </tr>
			<tr>
              <td class="textoTitulo" width="10%">Complemento: </td>
              <td class="textoValor" width="26%">
              	<p:InputAlfanumerico CLASS="inputtext" name="complemento" value="<%= complemento %>" size="40" maxlength="25" onFocus="javascript: prevFocus(this);"/>
              </td>
              <!--td class="textoValor" width="26%"><input type="text" class="inputtext" class="inputtext" name="complemento" size="40" maxlength="50" value="5º ANDAR AP 55"></td-->
              <td class="textoTitulo" width="8%">Bairro: </td>
              <td class="textoValor" width="26%">
              	<p:InputAlfanumerico CLASS="inputtext" name="bairro" value="<%= bairro %>" size="40" maxlength="50" onFocus="javascript: prevFocus(this);"/>
              </td>
              <!-- td class="textoValor" width="26%"><input type="text" class="inputtext" class="inputtext" name="bairro" size="20" maxlength="20" value="ALTO DE PINHEIROS" disabled></td-->
            </tr>
			<tr>
              
              <td class="textoTitulo" width="8%">UF: </td>
              <td class="textoValor" width="26%">
              		<p:InputAlfanumerico CLASS="inputtext" name="uf" value="<%= uf %>" size="20" maxlength="20" onFocus="javascript: prevFocus(this);" />
              </td>
              <!-- td class="textoValor" width="26%"><input type="text" class="inputtext" class="inputtext" name="uf" size="20" maxlength="20" value="SP" disabled></td-->
              <td class="textoTitulo" width="10%">Município: </td>
              <td class="textoValor" width="26%">
              	<p:InputAlfanumerico CLASS="inputtext" name="municipio" value="<%= municipio %>" size="30" maxlength="30" onFocus="javascript: prevFocus(this);" />
              </td>
            </tr>
            <tr>
              <td class="textoTitulo" width="8%">Pessoa: </td>
              <td class="textoValor" width="26%">
              		<s:ComboTipoPessoa name="tpPessoa" selectedValue='<%=bean.getTpPessoa().equals(new Long(0))?"1":bean.getTpPessoa()%>' 	onChange="javascript:limpaCpfCnpj(nuPessoa);" />
              </td>

             <td nowrap class="textoTitulo" width="17%">CPF/CNPJ: </td>
				<td width="26%" nowrap> 
				           	<p:InputCpfCnpj name="nuPessoa" value='<%= nuPessoa%>' CLASS="inputtext"/>
                </td>
            </tr>
			<tr>
              <!--<td class="textoTitulo" width="10%">Município: </td>
              <td class="textoValor" width="26%">
              	<p:InputAlfanumerico CLASS="inputtext" name="municipio" value="<%= municipio %>" size="30" maxlength="30" onFocus="javascript: prevFocus(this);" />
              </td>-->
              <!--td class="textoValor" width="26%"><input type="text" class="inputtext" class="inputtext" name="municipio" size="30" maxlength="30" value="SÃO PAULO" disabled></td-->
              <td class="textoTitulo" width="8%">&nbsp; </td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>


            <tr>
	            <td colspan="4">&nbsp;</td>
            </tr>
						<tr>
					  	<td align="right" colspan="4">
              	<p align="center">
              		<s:Button name="Alterar" value="Alterar" action="javascript:formSubmit_cedenteAlterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.cadastro.manter.alterar" />
	              	<!-- <input type="button" class="button" name="Alterar" value="Alterar" onclick="javascript:formSubmit_cedenteAlterar();"> -->
					<input type="button" class="button" name="Voltar" value="Voltar" onclick="javascript:formSubmit_Voltar();">
								</p>
	            </td>
	          </tr>
          </table>
        </td>
      </tr>
    </table>
  </s:FormStrategy>
  </body>
</p:Document>
    <script language="javascript">

	    var cepInvalido = false;

	    function inicia() {

	    }

	    function formSubmit_Voltar() {
			document.frmMain.estrategia.value = "cedente.CedenteManterFiltro";
			document.frmMain.fluxo.value="normal";
	        document.frmMain.submit();
	    }
	    function formSubmit_cedenteAlterar() {
	    	if(!validarDados()) {
	    		return false;
	    	}
     		if (confirm("Confirma alteração?")) {
	            document.frmMain.submit();
        	}
      	}

      	function validarDados() {
		    var form = document.frmMain;
//      		if(cepInvalido) {
//      			alert("O CEP informado é inválido. Favor preencher para consulta.");
//      			form.cep.value = "";
//      			form.cep.focus();
//      			return false;
//      		}
      		if(!validaCampoObrigatorio(form.nome, 'Nome')) {
      			return false;
      		}
      		if(!validaCampoObrigatorio(form.numero, 'Número')) {
      			return false;
      		}
      		if(!validaCampoObrigatorio(form.cep, 'CEP')) {
	      		limparCampos();
      			return false;
      		}
      		if(!validaCampoObrigatorio(form.endereco , 'Logradouro')){
      			return false;
      		}
      		if(!validaCampoObrigatorio(form.bairro , 'Bairro')){
      			return false;
      		}
      		if(!validaCampoObrigatorio(form.uf , 'UF')){
      			return false;
      		}
      		
      		if(!validaTamanhoCampo2(form.cep,'CEP',8,'073')){
      			return false;
      		}
      		return true;
      	}

		function consultaCep() {
		    var form = document.frmMain;
			if(document.frmMain.cep.value != "" && document.frmMain.cep.value.length == 8) {
			    xmlHttpPostRequest('/cobranca/SIGCBAjaxServlet?action=consultaLocalidadeSICLI');
			    //alert( "TESTE 01 - CDMUNICIPIO = (" + document.frmMain.cdMunicipio.value + ")" );//AOL - 07nov06 TESTE do Codigo do Municipio
			    //alert( "TESTE 02 - CDMUNICIPIO = (" + form.cdMunicipio.value + ")" );//AOL - 07nov06 TESTE do Codigo do Municipio
		    } else {
				limparCampos();
		    }
		}

		function limparCampos() {
		    var form = document.frmMain;
		    //form.tpLogradouro.value = "";
		    form.endereco.value = "";
		    form.bairro.value = "";
		    form.municipio.value = "";
   		    form.uf.value = "";
   		    form.numero.value = "";
   		    form.complemento.value = "";

		}

		function xmlHttpPostRequest(strURL) {
		    var xmlHttpPost = false;
		    var self = this;

		    if(window.XMLHttpRequest) {
		        self.xmlHttpPost = new XMLHttpRequest();
		    } else {
		        self.xmlHttpPost = new ActiveXObject("Microsoft.XMLHTTP");
		    }

		    self.xmlHttpPost.open('Post', strURL, true);
		    self.xmlHttpPost.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    self.xmlHttpPost.onreadystatechange = function() {
		        if(self.xmlHttpPost.readyState == 4) {
		            consultaCepCallBackHandler(self.xmlHttpPost);
		        }
		    }
		    self.xmlHttpPost.send(getQueryString());
		}

		function getQueryString() {
		    var form = document.frmMain;
		    var cep = form.cep.value;
		    qstr = 'cep=' + escape(cep);
		    return qstr;
		}

		function consultaCepCallBackHandler(objResponse) {
			var docRoot = objResponse.responseXML;
			var resposta = docRoot.getElementsByTagName('resposta')[0].getAttribute("codigo");
         
		    var form = document.frmMain;

			if(resposta == "0") {
				//var tipoLogradouro = docRoot.getElementsByTagName('tipologradouro')[0].firstChild.nodeValue;
				var endereco = docRoot.getElementsByTagName('endereco')[0].firstChild.nodeValue;
				var bairro = docRoot.getElementsByTagName('bairro')[0].firstChild.nodeValue;
				var municipio = docRoot.getElementsByTagName('municipio')[0].firstChild.nodeValue;
				var cdMunicipio = docRoot.getElementsByTagName('cdMunicipio')[0].firstChild.nodeValue;
				var uf = docRoot.getElementsByTagName('uf')[0].firstChild.nodeValue;

			    //form.tpLogradouro.value = tipoLogradouro;
			    form.endereco.value = endereco;
			    form.bairro.value = bairro;
			    form.municipio.value = municipio;
			    form.cdMunicipio.value = cdMunicipio;
	   		    form.uf.value = uf;

	   		    cepInvalido = false;
	   		    form.Alterar.disabled = false;
   		    } else {
              var mensagem = docRoot.getElementsByTagName('mensagem')[0].firstChild.nodeValue;
               
				limparCampos();
	   		    cepInvalido = true;
	   		    //form.Alterar.disabled = true;
				msg(mensagem,'','','','false','');
   		    }
		}
        </script>