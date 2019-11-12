<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: sacado_alterar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 08/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.SacadoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.SacadoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SacadoEstrategia.USUARIOLDAP_BEAN);
	CedenteCabecaBean cedCabBean = (session.getAttribute(SacadoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(SacadoEstrategia.CEDENTE_CABECALHO_BEAN));
	SacadoBean sacadoBean = (session.getAttribute(SacadoEstrategia.DATA_BEAN)==null?new SacadoBean():(SacadoBean)session.getAttribute(SacadoEstrategia.DATA_BEAN));
	SacadoBean sacadoFiltroBean = (session.getAttribute(SacadoEstrategia.FILTRO_BEAN)==null?new SacadoBean():(SacadoBean)session.getAttribute(SacadoEstrategia.FILTRO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=SacadoEstrategia.STRATEGY_ALTERAR_FINALIZAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=SacadoEstrategia.PAGE_TITLE_ALTERAR%>"/>

 		<input type="hidden" name ="cep" value=''>
 		<input type="hidden" name ="endereco" value=''>
 		<input type="hidden" name ="bairro" value=''>
 		<input type="hidden" name ="municipio" value=''>
 		<input type="hidden" name ="uf" value=''>
 		
		<input type="hidden" name ="cepSacado" value=''>

		<input type="hidden" name ="cpfCnpjResponsavel" value=''>

		<input type="hidden" name="codigoCedente" value='<%=sacadoBean.getCodigoCedente()%>'>
		<input type="hidden" name="codigoBancoSacado" value='<%=sacadoBean.getCodigoBancoSacado()%>'>
  	<input type="hidden" name="nomeBancoSacado" value="<%=sacadoBean.getNomeBancoSacado()%>">
		<input type="hidden" name ="tipoPessoaSacado" value='<%=sacadoBean.getTipoPessoaSacado()%>'>		
		<input type="hidden" name ="cpfCnpjSacado" value='<%=sacadoBean.getCpfCnpjSacado()%>'>
		<input type="hidden" name="codigoSacado" value='<%=sacadoBean.getCodigoSacado()%>'>
  	<input type="hidden" name="navegacao" value="<%=sacadoBean.getNavegacao()%>">
		<input type="hidden" name="moeda">

		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=sacadoBean.getCodigoCedenteFormatado()%></td>
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
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
               <td class="textoTitulo" width="17%">Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=sacadoBean.getCodigoBancoSacado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Nome Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=sacadoBean.getNomeBancoSacado()%></td> 
  
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Alterar Sacado:
                <hr>
              </td>
            </tr>

						<tr>
              <td colspan="4">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
                      <td class="textoValor" width="26%">
                        <s:ComboTipoPessoa name="tipoPessoaSacadoCombo" selectedValue='<%=sacadoBean.getTipoPessoaSacado().equals(new Long(0))?"1":sacadoBean.getTipoPessoaSacado().toString()%>' disabled="true"/>
											</td>
                      <td nowrap class="textoTitulo" width="17%">CPF/CNPJ: </td>
				              <td width="26%" nowrap> 
				              	<p:InputCpfCnpj name="cpfCnpjSacadoInput"
				              		value='<%=sacadoBean.getCpfCnpjSacadoFormatado()%>' CLASS="inputtext" 
				              		disabled = 'true'/>
                      </td>
                    </tr>
                    <tr>
              				<td class="textoTitulo" width="17%">Código Sacado: </td>
				              <td class="textoTitulo" width="26%"> 
					              <p:InputAlfanumerico name="codigoSacadoInput" maxlength="15" size="20" 
					                	CLASS="inputtext" value='<%=sacadoBean.getCodigoSacado()%>' disabled="true"/>
				              </td>
                      <td class="textoTitulo" width="17%">Nome: </td>
                      <td class="textoValor" width="26%">
				                <p:InputAlfanumerico name="nomeSacado" maxlength="40" size="30" 
				                	value='<%=sacadoBean.getNomeSacado()%>' CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.cepInput);"/>
                      </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">CEP: </td>
                      <td class="textoValor" width="26%">
				              	<p:InputCep name="cepInput"
				              		value='<%=sacadoBean.getCepSacado().equals(new Long(0))?"":sacadoBean.getCepSacadoFormatado()%>' CLASS="inputtext" 
				              		onFocus="prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Procurar);"/>
			                 	<s:Button name="Procurar" action="javascript: formSubmit_ProcurarCEP();"/>
                      </td>
                      <td class="textoTitulo" width="17%">UF: </td>
                      <td class="textoValor" width="26%">
                        <s:ComboUf name="ufSacado" selectedValue='<%=sacadoBean.getUfSacado()%>' 
                        onChange='javascript:validaAlteracaoEndereco()'/>
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Endereço: </td>
				              <td width="26%" nowrap> 
				                <p:InputAlfanumericoCep name="enderecoSacado" maxlength="40" size="30" 
				                	value="<%=sacadoBean.getEnderecoSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.numeroEnderecoSacado);"/>
                      </td>
                      <td class="textoTitulo" width="17%">Número: </td>
                      <td class="textoValor" width="26%">
				                <p:InputAlfanumerico name="numeroEnderecoSacado" maxlength="15" size="18" 
				                	value="<%=sacadoBean.getNumeroEnderecoSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.complementoSacado);"/>
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Complemento: </td>
				              <td width="26%" nowrap> 
				                <p:InputAlfanumerico name="complementoSacado" maxlength="25" size="30" 
				                	value="<%=sacadoBean.getComplementoSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.bairroSacado);"/>
                      </td>
                      <td class="textoTitulo" width="17%">Bairro: </td>
                      <td class="textoValor" width="26%">
				                <p:InputAlfanumericoCep name="bairroSacado" maxlength="25" size="30" 
				                	value="<%=sacadoBean.getBairroSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.municipioSacado);"/>
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Município: </td>
                      <td class="textoValor" width="26%">
				                <p:InputAlfanumericoCep name="municipioSacado" maxlength="35" size="30" 
				                	value="<%=sacadoBean.getMunicipioSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp='javascript: nextFocus(event.keyCode, this, document.frmMain.emailSacado);'/>
                      </td>
                      <td class="textoTitulo" width="17%">e-mail do Sacado: </td>
                      <td class="textoValor" width="26%">
				                <p:InputEmail name="emailSacado" maxlength="50" size="30" 
				                	value="<%=sacadoBean.getEmailSacado()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.tipoPessoaResponsavel);"/>
											</td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Tipo Pessoa Responsável: </td>
                      <td class="textoValor" width="26%">
	                       <s:ComboTipoPessoa name="tipoPessoaResponsavel" branco="true" brancoValue="0" selectedValue='<%=sacadoBean.getTipoPessoaResponsavel().toString()%>'
	                       onChange="javascript:configuraResponsavel(); limpaCpfCnpj(cpfCnpjResponsavelInput);"
	                       />
                      </td>
                      <td nowrap class="textoTitulo" width="17%">CPF/CNPJ Responsável: </td>
				              <td width="26%" nowrap> 
				              	<p:InputCpfCnpj name="cpfCnpjResponsavelInput"
				              		value='<%=sacadoBean.getCpfCnpjResponsavelFormatado()%>' CLASS="inputtext" 
				              		onBlur="javascript:formataCpfCnpj(this,tipoPessoaResponsavel);" 
				              		onFocus="javascript:unFormataCpfCnpj(this,tipoPessoaResponsavel);prevFocus(this);"
				              		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nomeResponsavel);"/>
                      </td>
                    <tr>
                      <td class="textoTitulo" width="17%">Nome Responsável: </td>
                      <td class="textoValor" width="26%">
				                <p:InputAlfanumerico name="nomeResponsavel" maxlength="40" size="30" 
				                	value="<%=sacadoBean.getNomeResponsavel()%>" CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.valorTitulo);"/>
                      </td>
                      <td nowrap class="textoTitulo" width="17%">Valor do Título: </td>
				              <td class="textoValor" width="26%" nowrap> 
        				        <p:InputCurrency name="valorTitulo" maxlength="15" size="27" 
               						value='<%=sacadoBean.getValorTitulo().toString().equals("R$ 0,00")?"":sacadoBean.getValorTitulo().toString()%>' 
               						CLASS="inputtext"
               						onFocus="javascript: prevFocus(this);"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.envioBloqueto);"/> 
                      </td>
	                   </tr>
                     <tr> 
                      <td class="textoTitulo" width="17%">Moeda: </td>
                      <td class="textoValor" width="26%">
												<s:ComboMoeda name="moedaCombo" selectedValue='<%=sacadoBean.getMoeda().equals(new Long(0))?"9":sacadoBean.getMoeda().toString()%>' disabled="true"/>
											</td>
											<td class="textoTitulo" width="17%">Envio do Boleto: </td>
                      <td class="textoValor" width="26%">
                        	<s:ComboEnvioBloqueto name="envioBloqueto" selectedValue='<%=sacadoBean.getEnvioBloqueto().equals(new Long(0))?"-1":sacadoBean.getEnvioBloqueto().toString()%>' onChange="javascript:liberaSMS();" branco="true"/>
                      </td>
                    </tr>
                    
                     <tr>
                      <td class="textoTitulo" width="17%">DDD/Celular: </td>
                      <td class="textoValor" width="26%">
			                        <p:InputAlfanumerico name="dddSMS" maxlength="2" size="3"   
				                	CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"	value ="<%=sacadoBean.getDddSMS() %>" onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.celularSMS);"/>
				                
									<p:InputAlfanumerico name="celularSMS" maxlength="9" size="12"   
				                	CLASS="inputtext"
				                	onFocus="javascript: prevFocus(this);"	value ="<%=sacadoBean.getCelularSMS() %>" onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.tipoSMS);"/>
                      </td>
					  <td class="textoTitulo" width="17%">Tipo SMS </td>
                      <td class="textoValor" width="26%" >	
                       <select size="1" name="tipoSMS" disabled="disabled">
							<option <%=sacadoBean.getTipoSMS().equals("0") ? "selected='selected'" : ""%> value="0"></option>
							<option <%=sacadoBean.getTipoSMS().equals("1") ? "selected='selected'" : ""%> value="1">Informativa</option>
							<option <%=sacadoBean.getTipoSMS().equals("2") ? "selected='selected'" : ""%> value="2">Repr. Numérica</option>
							<option <%=sacadoBean.getTipoSMS().equals("3") ? "selected='selected'" : ""%> value="3">PEC</option>
						</select> </td>
                     </tr>


										</tr>
                  </table>
								</td>                  
            </tr>
            <tr> 
	            <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
	            <td align="right" colspan="4">
  	            <p align="center"> 
                 	<s:Button name="Confirmar" action="javascript: formSubmit();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersacado.alterar"/>
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
    <script language="javascript">
			function inicia() {
				setFirstFieldFocus();
				configuraResponsavel();
				liberaSMS();
			}
	    function formSubmit() {

        if (validaSubmit()) {
	    		if (confirm(conf("101", "Sacado"))) {
		        document.frmMain.cepSacado.value = document.frmMain.cepInput.value;
		        unFormataCep(document.frmMain.cepSacado);
						document.frmMain.cpfCnpjResponsavel.value=document.frmMain.cpfCnpjResponsavelInput.value;
						unFormataCpfCnpj(document.frmMain.cpfCnpjResponsavel,document.frmMain.tipoPessoaResponsavel) 
		        document.frmMain.moeda.value = document.frmMain.moedaCombo.value;
		        document.frmMain.submit();
		      }
        }
	    }
			function validaSubmit() {

				
	    	var camposObrigatorios = new Array(12);
	    	camposObrigatorios[0] = new Array( "tipoPessoaSacadoCombo", "Tipo Pessoa" );
	    	camposObrigatorios[1] = new Array( "cpfCnpjSacadoInput", "CPF/CNPJ" );
	    	camposObrigatorios[2] = new Array( "codigoSacadoInput", "Código Sacado" );
	    	camposObrigatorios[3] = new Array( "nomeSacado", "Nome" );
	    	camposObrigatorios[4] = new Array( "cepInput", "CEP" );
	    	camposObrigatorios[5] = new Array( "ufSacado", "UF" );
	    	camposObrigatorios[6] = new Array( "enderecoSacado", "Endereço" );
	    	camposObrigatorios[7] = new Array( "numeroEnderecoSacado", "Número" );
	    	camposObrigatorios[8] = new Array( "bairroSacado", "Bairro" );
	    	camposObrigatorios[9] = new Array( "municipioSacado", "Município" );
		    camposObrigatorios[10] = new Array( "valorTitulo", "Valor do Título" );
		    camposObrigatorios[11] = new Array( "moedaCombo", "Moeda" );		    
		    camposObrigatorios[12] = new Array( "envioBloqueto", "Envio do Boleto" );		    
		    
		    if(!validaArrayCamposObrigatorios(camposObrigatorios)){
		      return false;
		    }
				if(document.frmMain.emailSacado.value != ''){
					if(validaEmail(document.frmMain.emailSacado.value)){
						msg("049");
						return false;
					}
				}        
        if(document.frmMain.tipoPessoaResponsavel.value != 0){
        	if(!validaCampoObrigatorio(document.frmMain.cpfCnpjResponsavelInput, 'CPF/CNPJ Responsável')){
				  	return false;
		    	}
		    	if(!validaCampoObrigatorio(document.frmMain.nomeResponsavel, 'Nome Responsável')){
				  	return false;
		    	}
		    	if(!validaDvCpfCnpj(document.frmMain.cpfCnpjResponsavelInput,document.frmMain.tipoPessoaResponsavel)){
						msg('008','CPF/CNPJ do Responsável');
			    	return false;
					}
        }
				if(!validaValorZero(document.frmMain.valorTitulo, 'Valor do Título')){
				  return false;				
				}
				        
        if(document.frmMain.envioBloqueto.value == 3){
        	if(!validaCampoObrigatorio(document.frmMain.emailSacado, 'e-mail do Sacado')){
				  	return false;
				  }
        }
        
        return true;
		  }
	    function formSubmit_Voltar() {
    		if (confirm(conf("103"))) {
         	 document.frmMain.estrategia.value = "<%=sacadoFiltroBean.getNavegacao().equals(SacadoEstrategia.NAVEGACAO_FILTRO_TUDO)?SacadoEstrategia.STRATEGY_CONSULTAR:SacadoEstrategia.STRATEGY_MANTER_FILTRO%>";
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
        }
      }

			// Atencao: Para utilizar corretamente a tela/funcao de Pesquisa de Cep, é necessário:
			// - Possuir um form chamado frmMain
			// - No frmMain possuir os campos hidden: cep, endereco, bairro, municipio, uf
			// - Adaptar a funcao atualizar_endereco() para atualizar os campos de tela efetivos
			// - o form, os campos e a funcao sao referenciados pela tela de Pesquisa de Cep
	    function formSubmit_ProcurarCEP() {
		    if(validaCampoObrigatorio(document.frmMain.cepInput, 'Cep Sacado')){
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
		    document.frmMain.enderecoSacado.value = document.frmMain.endereco.value;
		    document.frmMain.bairroSacado.value = document.frmMain.bairro.value;
		    document.frmMain.municipioSacado.value = document.frmMain.municipio.value;
		    document.frmMain.ufSacado.value = document.frmMain.uf.value;
		    document.frmMain.numeroEnderecoSacado.focus();		    
	    }
	    function configuraResponsavel(){
	    	if(document.frmMain.tipoPessoaResponsavel.value == 0){
	    		document.frmMain.cpfCnpjResponsavelInput.value = '';
	    		document.frmMain.cpfCnpjResponsavelInput.disabled = true;
	    		document.frmMain.nomeResponsavel.value = '';
	    		document.frmMain.nomeResponsavel.disabled = true;
	    	}
	    	else{
	    		document.frmMain.cpfCnpjResponsavelInput.disabled = false;
	    		document.frmMain.nomeResponsavel.disabled = false;
	    	}
	    }
	    
	    
	    function liberaSMS(){
	    	if (document.frmMain.envioBloqueto.value == 5 || document.frmMain.envioBloqueto.value == 7){
	    		document.frmMain.tipoSMS.disabled = false;
	    	}else{
	    		document.frmMain.tipoSMS.value = 0;
	    		document.frmMain.tipoSMS.disabled = true;
	    	}
	    }
	    
    </script>
  </s:FormStrategy>
</p:Document>
</html>