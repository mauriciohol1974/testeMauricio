<%/***********************************************
             *Politec - Filial São Paulo
             *Fabrica de Projetos - Agosto de 2004
             *Projeto CAIXA - SIGCB
             *Componente: bcotitu_alterar.jsp - Java Server Pages
             *Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
             *Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
             *Ultima Atualização: 29/09/2004
             ************************************************/

            %>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BcoTituEstrategia"%>

<%CedenteCabecaBean cedCabBean = (session.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN) == null
                    ? new CedenteCabecaBean()
                    : (CedenteCabecaBean) session.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN));
            TituloBean tituloBean = (session.getAttribute(BcoTituEstrategia.DATA_BEAN) == null
                    ? new TituloBean()
                    : (TituloBean) session.getAttribute(BcoTituEstrategia.DATA_BEAN));

            SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
            String dataHoje = formato.format(Calendar.getInstance().getTime());
            String dataPrevisaoProtDev = formato.format(tituloBean.getAbatiDataPrevisaoProtDev());
            String dataVencimento = formato.format(tituloBean.getPrinciDataVencimento());

            boolean tituloVencido = false;
            if (Long.parseLong(dataVencimento) <= Long.parseLong(dataHoje))
                tituloVencido = true;
            
            
            String icTipoPgto = (String) tituloBean.getIcTipoPagamento();
%>

<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=BcoTituEstrategia.STRATEGY_ALTERAR_FINALIZAR%>"
		fluxo="normal">
		<s:Menu />
		<s:Titulo name="<%=BcoTituEstrategia.PAGE_TITLE_ALTERAR%>" />

		<input type="hidden" name="icTipoPgto"	value="<%=icTipoPgto%>">
		
		
		<input type="hidden" name="pgtoParcial"	value="<%=tituloBean.getIcAutPagto()%>">
		<input type="hidden" name="tipoPgtoParcial"	value="<%=tituloBean.getIcTipoPagamento()%>">
		
		<input type="hidden" name="filtroSelecao"
			value="<%=tituloBean.getFiltroSelecao()%>">
		<input type="hidden" name="filtroDescricaoSituacao"
			value="<%=tituloBean.getFiltroDescricaoSituacao()%>">
		<input type="hidden" name="filtroDescricaoClassificacao"
			value="<%=tituloBean.getFiltroDescricaoClassificacao()%>">
		<input type="hidden" name="filtroVoltarListarConsolidado"
			value="<%=tituloBean.getFiltroVoltarListarConsolidado()%>">
		<input type="hidden" name="filtroVoltarListarTitulo"
			value="<%=tituloBean.getFiltroVoltarListarTitulo()%>">
		<input type="hidden" name="filtroVoltarAcao"
			value="<%=tituloBean.getFiltroVoltarAcao()%>">

		<input type="hidden" name="codigoCedente"
			value="<%=tituloBean.getCodigoCedente()%>">
		<input type="hidden" name="nossoNumero"
			value="<%=tituloBean.getNossoNumero()%>">
		<input type="hidden" name="situacao"
			value="<%=tituloBean.getSituacao()%>">
		<input type="hidden" name="classificacao"
			value="<%=tituloBean.getClassificacao()%>">


		<input type="hidden" name="princiMeioEntrada"
			value="<%=tituloBean.getPrinciMeioEntrada()%>">
		<input type="hidden" name="princiDescricaoSituacao"
			value="<%=tituloBean.getPrinciDescricaoSituacao()%>">

		<input type="hidden" name="abatiDataPrevisaoProtDev"
			value="<%=tituloBean.getAbatiDataPrevisaoProtDevFormatada()%>">
			

		<input type="hidden" name="valorTeste" value='R$ 0,00'>
		<input type="hidden" name="cep" value=''>
		<input type="hidden" name="endereco" value=''>
		<input type="hidden" name="bairro" value=''>
		<input type="hidden" name="municipio" value=''>
		<input type="hidden" name="uf" value=''>

		<input type="hidden" name="princiSacadoCpfCnpj" value=''>
		<input type="hidden" name="princiSacadoCep" value=''>
		<input type="hidden" name="compleSacadorCpfCnpj" value=''>
		<input type="hidden" name="princiDataVencimento"
			value='<%=tituloBean.getPrinciDataVencimentoFormatada()%>'>
		<input type="hidden" name="princiEndosso"
			value='<%=tituloBean.getPrinciEndosso()%>'>		
		
		
		<input type="hidden" name="princiMoeda"
			value='<%=tituloBean.getPrinciMoeda().toString()%>'>
			
					

		<!--EAM - Permitir alterar apenas o endereço do sacado quando as
			datas de vencimento/envio ao cartório estão vencidas-->
		<input type="hidden" name="princiAceite">
		<input type="hidden" name="princiIndicadorProt">
		<input type="hidden" name="princiPrazoProtDev">
		<input type="hidden" name="princiEspecie">
		<input type="hidden" name="princiSacadoNome">
		<input type="hidden" name="princiSacadoTipoPessoa">
		<input type="hidden" name="princiSacadoEmail">
		<input type="hidden" name="princiPvCobrador">
		
		<input type="hidden" name="compleRetidoValorIOF" 
			value="<%=tituloBean.getCompleRetidoValorIOF().toString()%>">

		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height=53 valign="middle" align="center">
					<tr>
						<td class="textoTitulo" width="17%">Cedente:</td>
						<td class="textoValor" width="26%"><%=tituloBean.getCodigoCedenteFormatado()%></td>
						<td class="textoTitulo" width="17%">Nome Cedente:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Tipo de Pessoa:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
						<td class="textoTitulo" width="17%">CPF/CNPJ:</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Código Cliente (COCLI):</td>
						<td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td>
						<td class="textoTitulo" width="17%">Nosso Número:</td>
						<td class="textoValor" width="26%"><%=tituloBean.getNossoNumeroFormatado()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Meio de Entrada:</td>
						<td class="textoValor" width="26%"><%=tituloBean.getPrinciMeioEntrada()%></td>
						
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Situação:</td>
						<td class="textoValor" width="26%"><%=tituloBean.getPrinciDescricaoSituacao()%></td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
					</tr>

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="4" class="textoTitulo">Alterar Título:
						<hr>
						</td>
					</tr>

					<tr>
						<td colspan="4"><s:Outline name="Principais"
							title="Dados Principais" imagePath="<%=Paths.getImagePath()%>"
							type="outline">
							<table width="95%" border="0" cellspacing="0" cellpadding="0"
								height=14 valign="middle" align="center">
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
								    <td class="textoTitulo" width="17%">Valor do Título:</td>
									<td><p:InputCurrency name="princiValorTitulo" maxlength="17" size="29" 
                						CLASS="inputtext" value='<%=tituloBean.getPrinciValorTitulo().toString()%>' 
                						onFocus="javascript: prevFocus(this);" onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiDataVencimento);"/> 
										</td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Número Documento:</td>
									<td class="textoValor" width="26%"><p:InputAlfanumerico
										name="princiNumeroDocumento" maxlength="15" size="18"
										value="<%=tituloBean.getPrinciNumeroDocumento().toString()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.emissaoBloqueto);" />
									</td>
									<td class="textoTitulo" width="17%" nowrap>Data de Vencimento:
									</td>
									<td class="textoValor" width="26%" nowrap><p:InputDate
										name="princiDataVencimentoInput"
										value="<%=tituloBean.getPrinciDataVencimentoFormatada()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiAceiteCombo)" />
									</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="17%">Moeda:</td>
									<td class="textoValor" width="26%"><s:ComboMoeda
										name="princiMoedaInput"
										selectedValue='<%=tituloBean.getPrinciMoeda().toString()%>'
										disabled="true" /></td>
									<td class="textoTitulo" width="17%">Aceite:</td>
									<td class="textoValor" width="26%"><s:ComboAceite
										name="princiAceiteCombo"
										selectedValue="<%=tituloBean.getPrinciAceite().toString()%>" />
									</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="17%">Protesto:</td>
									<td class="textoValor" width="26%"><s:ComboSimNao
										name="princiIndicadorProtCombo"
										selectedValue="<%=tituloBean.getPrinciIndicadorProt()%>" /></td>
									<td class="textoTitulo" width="17%" nowrap>Prazo de
									Protesto/Devolução:</td>
									<td class="textoValor" width="26%" nowrap><p:InputNumerico
										name="princiPrazoProtDevInput" maxlength="3" size="3"
										value="<%=tituloBean.getPrinciPrazoProtDev().toString()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiEndossoInput);" />
									</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="17%">Endosso:</td>
									<td class="textoValor" width="26%"><s:ComboSimNao
										name="princiEndossoInput"
										selectedValue="<%=tituloBean.getPrinciEndosso()%>"
										onChange="configuraCampoDependente(document.frmMain.princiEndossoInput);" />
									</td>
									<td class="textoTitulo" width="17%">Espécie de Título:</td>
									<td class="textoValor" width="26%"><s:ComboEspecieTitulo
										name="princiEspecieCombo"
										selectedValue="<%=tituloBean.getPrinciEspecie().toString()%>" />
									</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="17%">Emissão Boleto:</td>
									<td class="textoValor" width="26%"><s:ComboEmissaoBloqueto
										name="emissaoBloqueto"
										onChange="document.frmMain.envioBloqueto.value=-1; document.frmMain.envioBloqueto.disabled=(document.frmMain.emissaoBloqueto.value==1);"
										selectedValue="<%=tituloBean.getEmissaoBloqueto().toString() %>" />
									</td>
									<td class="textoTitulo" width="17%">Envio Boleto:</td>
									<td class="textoValor" width="26%"><s:ComboEnvioBloqueto
										name="envioBloqueto" branco="true"
										disabled='<%=tituloBean.getEmissaoBloqueto().equals(new Long(1))?"true":"false"%>'
										selectedValue="<%=tituloBean.getEnvioBloqueto().toString() %>" />
									</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="17%">Nome do Sacado:</td>
									<td class="textoValor" width="26%"><p:InputAlfanumerico
										name="princiSacadoNomeInput" maxlength="40" size="30"
										value="<%=tituloBean.getPrinciSacadoNome()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this)"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiSacadoTipoPessoaCombo);" />
									</td>
									<td class="textoTitulo" width="17%">Tipo Pessoa Sacado:</td>
									<td class="textoValor" width="26%"><s:ComboTipoPessoa
										name="princiSacadoTipoPessoaCombo"
										selectedValue="<%=tituloBean.getPrinciSacadoTipoPessoa().toString()%>"
										onChange="javascript:limpaCpfCnpj(document.frmMain.princiSacadoCpfCnpjInput);" />
									</td>
								</tr>

								<tr>
									<td nowrap class="textoTitulo" width="17%">CPF/CNPJ do Sacado:
									</td>
									<td nowrap class="textoValor" width="26%"><p:InputCpfCnpj
										name="princiSacadoCpfCnpjInput"
										value='<%=tituloBean.getPrinciSacadoCpfCnpj().equals(new Long(0))?"":tituloBean.getPrinciSacadoCpfCnpjFormatado()%>'
										CLASS="inputtext"
										onBlur="javascript:formataCpfCnpj(this,document.frmMain.princiSacadoTipoPessoaCombo);"
										onFocus="javascript:unFormataCpfCnpj(this,document.frmMain.princiSacadoTipoPessoaCombo);prevFocus(this);"
										onKeyUp="javascript:nextFocus(event.keyCode, this, document.frmMain.cepInput);" />
									</td>
									<td class="textoTitulo" width="17%">CEP do Sacado:</td>
									<td class="textoValor" width="26%"><p:InputCep name="cepInput"
										value='<%=tituloBean.getPrinciSacadoCep().equals(new Long(0))?"":tituloBean.getPrinciSacadoCepFormatado()%>'
										CLASS="inputtext" onFocus="prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Procurar);" />
									<s:Button name="Procurar"
										action="javascript: formSubmit_ProcurarCEP();" /></td>
								</tr>

								<tr>
									<td class="textoTitulo" width="17%">UF do Sacado:</td>
									<td class="textoValor" width="26%"><s:ComboUf
										name="princiSacadoUf"
										selectedValue="<%=tituloBean.getPrinciSacadoUf()%>"
										onChange='javascript:validaAlteracaoEndereco()' /></td>
									<td class="textoTitulo" width="17%">Endereço do Sacado:</td>
									<td class="textoValor" width="26%" nowrap><p:InputAlfanumericoCep
										name="princiSacadoLogradouro" maxlength="40" size="30"
										value="<%=tituloBean.getPrinciSacadoLogradouro()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiSacadoNumero);" />
									</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="17%">Número do Sacado:</td>
									<td class="textoValor" width="26%"><p:InputAlfanumerico
										name="princiSacadoNumero" maxlength="15" size="18"
										value="<%=tituloBean.getPrinciSacadoNumero()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiSacadoComplemento);" />
									</td>
									<td class="textoTitulo" width="17%">Complemento do Sacado:</td>
									<td class="textoValor" width="26%" nowrap><p:InputAlfanumerico
										name="princiSacadoComplemento" maxlength="25" size="30"
										value="<%=tituloBean.getPrinciSacadoComplemento()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiSacadoBairro);" />
									</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="17%">Bairro do Sacado:</td>
									<td class="textoValor" width="26%"><p:InputAlfanumericoCep
										name="princiSacadoBairro" maxlength="25" size="30"
										value="<%=tituloBean.getPrinciSacadoBairro()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiSacadoMunicipio);" />
									</td>
									<td class="textoTitulo" width="17%">Município do Sacado:</td>
									<td class="textoValor" width="26%"><p:InputAlfanumericoCep
										name="princiSacadoMunicipio" maxlength="35" size="30"
										value="<%=tituloBean.getPrinciSacadoMunicipio()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiSacadoEmailInput);" />
									</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="17%">e-mail do Sacado:</td>
									<td class="textoValor" width="26%"><p:InputEmail
										name="princiSacadoEmailInput" maxlength="50" size="30"
										value="<%=tituloBean.getPrinciSacadoEmail()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.princiPvCobradorInput);" />
									</td>

									<td class="textoTitulo" width="17%">PV Cobrador:</td>
									<td class="textoValor" width="26%"><p:InputNumerico
										name="princiPvCobradorInput" maxlength="4" size="5"
										value="<%=tituloBean.getPrinciPvCobrador().toString()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dddSMS);" />
									</td>
								</tr>


								<tr>
									<td class="textoTitulo" width="17%">DDD/Celular:</td>
									<td class="textoValor" width="26%"><p:InputNumerico
										name="dddSMS" maxlength="2" size="5"
										value="<%=tituloBean.getDddSMS().toString()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.celularSMS);" />-
										<p:InputNumerico
										name="celularSMS" maxlength="9" size="11"
										value="<%=tituloBean.getCelularSMS().toString()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.tipoSMS);" /></td>
									<td class="textoTitulo" width="17%">Tipo de SMS:</td>
									<td class="textoValor" width="26%">
					 					<select size="1" name="tipoSMS" onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.situacaoBloqSE);">
					 						<option <%=tituloBean.getTipoSMS().equals("00") ? "selected='selected'" : ""%> value="00"></option>
											<option <%=tituloBean.getTipoSMS().equals("01") ? "selected='selected'" : ""%> value="01">Informativa</option>
											<option <%=tituloBean.getTipoSMS().equals("02") ? "selected='selected'" : ""%>value="02">Repr. Numérica</option>
											<option <%=tituloBean.getTipoSMS().equals("03") ? "selected='selected'" : ""%>value="03">PEC</option>
										</select>
									</td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">ST. Bloq. SE:</td>
									<td class="textoValor" colspan="3"><p:InputAlfanumerico
										name="situacaoBloqSE" maxlength="40" disabled="true" size="60" value="<%=tituloBean.getSituacaoBloqSE().toString()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.aceiteSE);" />
									</td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Aceite SE:</td>
									<td class="textoValor" width="26%"><p:InputNumerico
										name="aceiteSE" maxlength="1" disabled="true" size="2" value="<%=tituloBean.getAceiteSE().toString()%>"
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.numIdDDA);" />
									</td>
									<td class="textoTitulo" width="17%">Indicador Registro na CIP:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getIcRegistroCIP().equals("N") ? "NÃO" : "SIM"%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Indexador:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getSgIndexador()%></td>
									<td class="textoTitulo" width="17%">Número Identificação CIP:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getNuIdentificaCIP()%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Tipo Calculo:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getTipoCalculo()%></td>
									<td class="textoTitulo" width="17%">Número Referência CIP:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getNuRefereciaCIP()%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Parcela:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getParcela()%></td>
									<td class="textoTitulo" width="17%">Código Erro CIP:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getCoErroCIP()%></td>
								</tr>
								
								
								<tr>
									<td class="textoTitulo" width="17%">Autoriza Pagamento Parcial/Divergente:</td>
									<td class="textoValor" width="26%"><s:ComboSimNao name="icAutPagto" selectedValue='<%=tituloBean.getIcAutPagto()%>'  onChange="javascript: icParcialChange();"/></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Tipo de Pagamento:</td>
									<td class="textoValor" width="26%">
									<div id="exibeCombo" style="display: none;">
									 <select size="1" name="icTipoPagamento" onChange="javascript: controlaTpPagamento(this);">
					  	 					<option <%=tituloBean.getIcTipoPagamento().equals("1") ? "selected='selected'" : ""%>value="1">Aceita qualquer valor </option>
											<option <%=tituloBean.getIcTipoPagamento().equals("2") ? "selected='selected'" : ""%>value="2">Aceita valores entre range mínimo e máximo      </option>
											<option <%=tituloBean.getIcTipoPagamento().equals("4") ? "selected='selected'" : ""%>value="4">Aceita valores considerando apenas o valor mínimo  </option>
									</select>
									</div>
									<div id="blockCombo" style="display: block;">
								  		<input  style="width: 300px" size="60" type="text" value="3-Não aceita valor divergente" disabled="disabled" />
									</div>
									
									</td>
								</tr>
								
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">&nbsp;</td>
									<td class="textoValor" width="26%">&nbsp;</td>
									<td class="textoTitulo" width="17%">Qtde. Pagamentos Possíveis:</td>
									<td class="textoValor" width="26%"><p:InputNumerico name="qtPgtoPossivel" maxlength="2" size="3"
			                						CLASS="inputtext" 
 				               						value ='<%=tituloBean.getQtPgtoPossivel().toString()%>'			                									                						
 				               						onFocus="javascript: prevFocus(this);"
 				               						onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.vrMaximoPgto);"	/></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Valor Máximo de Pagamento:</td>
									<td class="textoValor" width="26%"> <p:InputCurrency name="vrMaximoPgto" maxlength="15" size="27" 
							value='<%=tituloBean.getVrMaximoPgto().toString().equals("R$ 0,00")?"":tituloBean.getVrMaximoPgto().toString()%>' 
						  						CLASS="inputtext"
						  						onFocus="javascript: prevFocus(this);"
							                    onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.vrMinPgto);"/> </td>
									<td class="textoTitulo" width="17%">Qtde. Pagamentos Efetuados:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getQtPgtoEfetuado()%></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Valor Mínimo de Pagamento:</td>
									<td class="textoValor" width="26%"><p:InputCurrency name="vrMinPgto" maxlength="15" size="27" 
							value='<%=tituloBean.getVrMinPgto().toString().equals("R$ 0,00")?"":tituloBean.getVrMinPgto().toString()%>' 
						  						CLASS="inputtext"
						  						onFocus="javascript: prevFocus(this);"/></td>
									<td class="textoTitulo" width="17%">Saldo do Título:</td>
									<td class="textoValor" width="26%"><%=tituloBean.getVrSaldoTitulo()%></td>
								</tr>	
								
								<tr>
									<td class="textoTitulo" width="17%">Data de Competência: </td>
									<td class="textoValor" width="26%"><%=tituloBean.getDtCompetencia()%></td>
									<%if (!tituloBean.getCpfCnpjPrt().equalsIgnoreCase("")){ %>
									<td class="textoTitulo" width="17%">CPF/CNPJ do Portador: </td>
									<td class="textoValor" width="26%"><%=tituloBean.getCpfCnpjFormatadoPrt()%></td>
									<%} %>
								</tr>
								
								
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
							</table>
						</s:Outline></td>
					</tr>

					<tr>
						<td colspan="4"><s:Outline name="Complementar"
							title="Dados Complementares"
							imagePath="<%=Paths.getImagePath()%>" type="outline">
							<table width="95%" border="0" cellspacing="0" cellpadding="0"
								height=14 valign="middle" align="center">
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>


								<tr>
									<td nowrap class="textoTitulo" width="17%">Abatimento:</td>
									<td class="textoValor" width="26%"><p:InputCurrency
										name="compleAbatimento" maxlength="15" size="27"
										value='<%=tituloBean.getCompleAbatimento().toString().equals("R$ 0,00")?"":tituloBean.getCompleAbatimento().toString()%>'
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.compleSacadorNome);" />
									</td>
									<td class="textoTitulo" width="17%">Nome Sacador/Avalista:</td>
									<td class="textoValor" width="26%"><p:InputAlfanumerico
										name="compleSacadorNome" maxlength="40" size="40"
										value='<%=tituloBean.getCompleSacadorNome()%>'
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.compleSacadorTipoPessoa);" />
									</td>
								</tr>

								<tr>
									<td class="textoTitulo" width="17%">Tipo Pessoa Sacador:</td>
									<td class="textoValor" width="26%"><s:ComboTipoPessoa
										name="compleSacadorTipoPessoa"
										selectedValue='<%=tituloBean.getCompleSacadorTipoPessoa().toString()%>'
										onChange="javascript:limpaCpfCnpj(document.frmMain.compleSacadorCpfCnpjInput);" />
									</td>
									<td nowrap class="textoTitulo" width="17%">CPF/CNPJ do Sacador:
									</td>
									<td width="26%" nowrap><p:InputCpfCnpj
										name="compleSacadorCpfCnpjInput"
										value='<%=tituloBean.getCompleSacadorCpfCnpj().equals(new Long(0))?"":tituloBean.getCompleSacadorCpfCnpjFormatado()%>'
										CLASS="inputtext"
										onBlur="javascript:formataCpfCnpj(this,document.frmMain.compleSacadorTipoPessoa);"
										onFocus="javascript:unFormataCpfCnpj(this,document.frmMain.compleSacadorTipoPessoa);prevFocus(this);"
										onKeyUp="javascript:nextFocus(event.keyCode, this, document.frmMain.compleRetidoValorIOF);" />
									</td>
								</tr>
								<tr>
									<td nowrap class="textoTitulo" width="17%">IOF a ser Retido:</td>
									<td class="textoValor" width="26%"><p:InputCurrency
										name="compleRetidoValorIOF" maxlength="15" size="27" disabled="true"
										value='<%=tituloBean.getCompleRetidoValorIOF().toString().equals("R$ 0,00")?"":tituloBean.getCompleRetidoValorIOF().toString()%>'
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.compleSacadorCpfCnpjInput);" />
									</td>
									<td>&nbsp;
									</td>
									<td>&nbsp;
									</td>
									
								</tr>

								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td colspan="4">
									<table width="100%" border="0" cellspacing="0" cellpadding="0"
										height=14 valign="middle" align="center">
										<tr class="headerLista">
											<td nowrap width="17%" align="center">&nbsp;</td>
											<td nowrap width="8%" align="left">Percentual</td>
											<td nowrap width="17%" align="right">Valor</td>
											<td nowrap width="1%" align="left">&nbsp;</td>
											<td nowrap width="16%" align="center">&nbsp;</td>
											<td nowrap width="8%" align="left">Dias</td>
											<td nowrap width="18%" align="center">Data</td>
										</tr>
										
										<tr>
										
											<td class="textoTitulo" nowrap width="17%" >Tipo de Desconto:</td>
											<td colspan="4">
												<select name="tipoDesconto">
												<option value="0" <%=tituloBean.getTipoDesconto().equals("0") ? "selected='selected'" : ""%>>0-Isento</option>
												<option value="1" <%=tituloBean.getTipoDesconto().equals("1") ? "selected='selected'" : ""%>>1-Valor Fixo até a data informada</option>
												<option value="2" <%=tituloBean.getTipoDesconto().equals("2") ? "selected='selected'" : ""%>>2-Percentual até a data informada</option>
												<option value="3" <%=tituloBean.getTipoDesconto().equals("3") ? "selected='selected'" : ""%>>3-Valor por antecipação dia corrido</option>
												<option value="4" <%=tituloBean.getTipoDesconto().equals("4") ? "selected='selected'" : ""%>>4-Valor por antecipação dia útil</option>
												<option value="5" <%=tituloBean.getTipoDesconto().equals("5") ? "selected='selected'" : ""%>>5-Percentual por antecipação dia corrido</option>
												<option value="6" <%=tituloBean.getTipoDesconto().equals("6") ? "selected='selected'" : ""%>>6-Percentual por antecipação dia útil</option>
												
												</select>
											</td>
										
										</tr>

										<tr class="line0">
											<td class="textoTitulo" width="17%" align="left">Desconto 1:
											</td>
											<td class="textoValor" width="8%" align="left"><p:InputPercentual
												name="compleDescontoUmPercen" maxlength="5" size="9"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoUmPercen().toString().equals("0,00 %")?"":tituloBean.getCompleDescontoUmPercen().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.compleDescontoUmPrazo, document.frmMain.compleDescontoUmData);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td class="textoValor" width="17%" align="right"><p:InputCurrency
												name="compleDescontoUmValor" maxlength="15" size="25"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoUmValor().toString().equals("R$ 0,00")?"":tituloBean.getCompleDescontoUmValor().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.compleDescontoUmPrazo, document.frmMain.compleDescontoUmData);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td nowrap width="1%" align="left">&nbsp;</td>
											<td class="textoTitulo" width="17%" align="left">Prazo Limite
											1:</td>
											<td class="textoValor" width="8%" align="left"><p:InputNumerico
												name="compleDescontoUmPrazo" maxlength="3" size="3"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoUmPrazo().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: focoValor(event.keyCode, this, document.frmMain.compleDescontoDoisPercen,document.frmMain.compleDescontoDoisValor);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td class="textoValor" width="18%" align="center"><p:InputDate
												name="compleDescontoUmData" CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoUmDataFormatada()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: focoValor(event.keyCode, this, document.frmMain.compleDescontoDoisPercen,document.frmMain.compleDescontoDoisValor);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
										</tr>

										<tr class="line2">
											<td class="textoTitulo" width="17%" align="left">Desconto 2:
											</td>
											<td class="textoValor" width="8%" align="left"><p:InputPercentual
												name="compleDescontoDoisPercen" maxlength="5" size="9"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoDoisPercen().toString().equals("0,00 %")?"":tituloBean.getCompleDescontoDoisPercen().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.compleDescontoDoisPrazo, document.frmMain.compleDescontoDoisData);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td class="textoValor" width="17%" align="right"><p:InputCurrency
												name="compleDescontoDoisValor" maxlength="15" size="25"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoDoisValor().toString().equals("R$ 0,00")?"":tituloBean.getCompleDescontoDoisValor().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.compleDescontoDoisPrazo, document.frmMain.compleDescontoDoisData);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td nowrap width="1%" align="left">&nbsp;</td>
											<td class="textoTitulo" width="17%" align="left">Prazo Limite
											2:</td>
											<td class="textoValor" width="8%" align="left"><p:InputNumerico
												name="compleDescontoDoisPrazo" maxlength="3" size="3"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoDoisPrazo().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: focoValor(event.keyCode, this, document.frmMain.compleDescontoTresPercen,document.frmMain.compleDescontoTresValor);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td class="textoValor" width="18%" align="center"><p:InputDate
												name="compleDescontoDoisData" CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoDoisDataFormatada()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: focoValor(event.keyCode, this, document.frmMain.compleDescontoTresPercen,document.frmMain.compleDescontoTresValor);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
										</tr>

										<tr class="line0">
											<td class="textoTitulo" width="17%" align="left">Desconto 3:
											</td>
											<td class="textoValor" width="8%" align="left"><p:InputPercentual
												name="compleDescontoTresPercen" maxlength="5" size="9"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoTresPercen().toString().equals("0,00 %")?"":tituloBean.getCompleDescontoTresPercen().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.compleDescontoTresPrazo, document.frmMain.compleDescontoTresData);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td class="textoValor" width="17%" align="right"><p:InputCurrency
												name="compleDescontoTresValor" maxlength="15" size="25"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoTresValor().toString().equals("R$ 0,00")?"":tituloBean.getCompleDescontoTresValor().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: focoPrazo(event.keyCode, this, document.frmMain.compleDescontoTresPrazo, document.frmMain.compleDescontoTresData);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td nowrap width="1%" align="left">&nbsp;</td>
											<td class="textoTitulo" width="17%" align="left">Prazo Limite
											3:</td>
											<td class="textoValor" width="8%" align="left"><p:InputNumerico
												name="compleDescontoTresPrazo" maxlength="3" size="3"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoTresPrazo().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.compleMultaPercen);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td class="textoValor" width="18%" align="center"><p:InputDate
												name="compleDescontoTresData" CLASS="inputtext"
												value='<%=tituloBean.getCompleDescontoTresDataFormatada()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.compleMultaPercen);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
										</tr>

										<tr class="line2">
											<td class="textoTitulo" width="17%" align="left">Multa:</td>
											<td class="textoValor" width="8%" align="left"><p:InputPercentual
												name="compleMultaPercen" maxlength="5" size="9"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleMultaPercen().toString().equals("0,00 %")?"":tituloBean.getCompleMultaPercen().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.compleMultaPrazo);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td class="textoValor" width="17%" align="right"><p:InputCurrency
												name="compleMultaValor" maxlength="15" size="25"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleMultaValor().toString().equals("R$ 0,00")?"":tituloBean.getCompleMultaValor().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: foco(event.keyCode, this, document.frmMain.compleMultaPrazo);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td nowrap width="1%" align="left">&nbsp;</td>
											<td class="textoTitulo" width="17%" align="left">Prazo para
											Multa:</td>
											<td class="textoValor" width="8%" align="left"><p:InputNumerico
												name="compleMultaPrazo" maxlength="3" size="3"
												CLASS="inputtext"
												value='<%=tituloBean.getCompleMultaPrazo().equals(new Long(0))?"":tituloBean.getCompleMultaPrazo().toString()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.comunicacaoSacado);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
											<td class="textoValor" width="18%" align="center"><p:InputDate
												name="compleMultaData" CLASS="inputtext"
												value='<%=tituloBean.getCompleMultaDataFormatada()%>'
												onFocus="javascript: prevFocus(this); configuraCampoDependente(this);"
												onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.comunicacaoSacado);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>
										</tr>
										
								<tr>
									<td class="textoTitulo" width="17%">Tipo Juros :</td>
									<td width="26%" nowrap colspan="4">
										
										<select name="compleTipoJurosMes" >
												
												
												
												<option value="1" <%=tituloBean.getCompleTipoJurosMes().toString().equals("1") ? "selected='selected'" : "" %>>1-Valor (dias corridos)</option>
													<option value="2" <%=tituloBean.getCompleTipoJurosMes().toString().equals("2") ? "selected='selected'" : "" %>>2-Percentual ao dia (dias corridos)</option>
													<option value="3" <%=tituloBean.getCompleTipoJurosMes().toString().equals("3") ? "selected='selected'" : "" %>>3-Percentual ao mês (dias corridos)</option>
													<option value="4" <%=tituloBean.getCompleTipoJurosMes().toString().equals("4") ? "selected='selected'" : "" %>>4-Percentual ao ano (dias corridos)</option>
													<option value="5" <%=tituloBean.getCompleTipoJurosMes().toString().equals("5") ? "selected='selected'" : "" %>>5-Isento</option>
													<option value="6" <%=tituloBean.getCompleTipoJurosMes().toString().equals("6") ? "selected='selected'" : "" %>>6-Valor (dia útil)</option>
													<option value="7" <%=tituloBean.getCompleTipoJurosMes().toString().equals("7") ? "selected='selected'" : "" %>>7-Percentual ao dia (dias úteis)</option>
													<option value="8" <%=tituloBean.getCompleTipoJurosMes().toString().equals("8") ? "selected='selected'" : "" %>>8-Percentual ao mês (dias úteis)</option>
													<option value="9" <%=tituloBean.getCompleTipoJurosMes().toString().equals("9") ? "selected='selected'" : "" %>>9-Percentual ao ano (dias úteis)</option>
										</select>
										
									</td>
								</tr>
								<tr>
									<td class="textoTitulo" >Juros:</td>
								
									<td class="textoValor"><p:InputPercentual
										name="complePercenJurosMes" maxlength="5" size="9"
										CLASS="inputtext"
										value='<%=tituloBean.getComplePercenJurosMes().toString().equals("0,00 %")?"":tituloBean.getComplePercenJurosMes().toString()%>'
										onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.compleAbatimento);"
										onBlur="javascript: limpaPercentualZero(this);" /></td>
									<td class="textoValor"><p:InputCurrency
										name="valorJuros" maxlength="15" size="27"
										value='<%=tituloBean.getValorJuros().toString().equals("R$ 0,00")?"":tituloBean.getValorJuros().toString()%>'
										CLASS="inputtext" onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.compleSacadorNome);" /></td>
									<td>&nbsp;</td>
									<td nowrap width="1%" align="left">&nbsp;</td>
									<td>&nbsp;</td>
									
									<td class="textoValor" width="18%" align="center"><p:InputDate
												name="datajuros" CLASS="inputtext"
												value='<%=tituloBean.getDataJurosFormatada()%>'
												onFocus="javascript: prevFocus(this); "
												onKeyUp="javascript: focoValor(event.keyCode, this, document.frmMain.compleAbatimento,document.frmMain.compleAbatimento);"
												onBlur="javascript: configuraCampoDependente(this);" /></td>		
								</tr>
									</table>
									</td>
								</tr>

								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>

							</table>
						</s:Outline></td>
					</tr>

					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="4" class="textoTitulo">Parâmetros de Alteração:
						<hr>
						</td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Comunicação ao Sacado:</td>
						<td class="textoValor" width="26%"><s:ComboSimNao
							name="comunicacaoSacado" /></td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Cobrar Tarifa:</td>
						<td class="textoValor" width="26%"><s:ComboSimNao
							name="cobrarTarifa" /></td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>

					<tr>
						<td align="right" colspan="4">
						<p align="center"><s:Button name="Confirmar"
							action="javascript:formSubmit();" /> <s:Button name="Voltar"
							action="javascript:formSubmit_Voltar();" /></p>
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
				inicializa_DescontoMulta();
				inicializa_DataVencimento();
				inicializa_Endosso();
				document.frmMain.Confirmar.focus();
				inicializa_Alteracao_Endereco();
				controlaTpPagamento();
				icParcialChange();
			}      



			//EAM - Permitir alterar apenas o endereço do sacado quando as
			//datas de vencimento/envio ao cartório estão vencidas
			function inicializa_Alteracao_Endereco(){

							document.frmMain.princiSacadoCpfCnpjInput.disabled = true;
							document.frmMain.princiSacadoTipoPessoaCombo.disabled = true;
							document.frmMain.princiSacadoNomeInput.disabled = true;
	
<%			//EAM0308 - Alterada esta condição pq a data de protesto está sendo enviada acrescida de 1 dia na BG66
				//if (Long.parseLong(dataPrevisaoProtDev) < Long.parseLong(dataHoje)) && //---> Data Envio Protesto/Devolucao Vencida?
				
				if ((Long.parseLong(dataPrevisaoProtDev) <= Long.parseLong(dataHoje)) && //---> Data Envio Protesto/Devolucao Vencida?
						(Long.parseLong(dataVencimento) < Long.parseLong(dataHoje))) { 			//---> Data Vencimento Vencida?%>
							document.frmMain.princiDataVencimentoInput.disabled = false;
							document.frmMain.princiMoedaInput.disabled = true;
							document.frmMain.princiAceiteCombo.disabled = true;
							document.frmMain.princiIndicadorProtCombo.disabled = true;
							document.frmMain.princiPrazoProtDevInput.disabled = true;
							document.frmMain.princiEndossoInput.disabled = true;
							document.frmMain.princiEspecieCombo.disabled = true;
							document.frmMain.princiSacadoEmailInput.disabled = true;
							document.frmMain.princiPvCobradorInput.disabled = true;												


<%			}%>
			
			}

			function inicializa_Endosso() {
			<%if (tituloVencido) {%> 
					document.frmMain.princiEndossoInput.disabled = true;
			<%} else {%>
					document.frmMain.princiEndossoInput.disabled = false;
			<%}%>
			}

			function inicializa_DataVencimento() {
					document.frmMain.princiDataVencimentoInput.disabled = false;
			}			

			function inicializa_DescontoMulta() {
			  configuraCampoDependente(document.frmMain.princiEndossoInput);
			  configuraCampoDependente(document.frmMain.compleTipoJurosMes);
				configuraCampoDependente(document.frmMain.compleDescontoUmPercen);
				configuraCampoDependente(document.frmMain.compleDescontoUmValor);
				configuraCampoDependente(document.frmMain.compleDescontoUmPrazo);
				configuraCampoDependente(document.frmMain.compleDescontoUmData);
				configuraCampoDependente(document.frmMain.compleDescontoDoisPercen);
				configuraCampoDependente(document.frmMain.compleDescontoDoisValor);
				configuraCampoDependente(document.frmMain.compleDescontoDoisPrazo);
				configuraCampoDependente(document.frmMain.compleDescontoDoisData);
				configuraCampoDependente(document.frmMain.compleDescontoTresPercen);
				configuraCampoDependente(document.frmMain.compleDescontoTresValor);
				configuraCampoDependente(document.frmMain.compleDescontoTresPrazo);
				configuraCampoDependente(document.frmMain.compleDescontoTresData);
				configuraCampoDependente(document.frmMain.compleMultaPercen);
				configuraCampoDependente(document.frmMain.compleMultaValor);
				configuraCampoDependente(document.frmMain.compleMultaPrazo);
				configuraCampoDependente(document.frmMain.compleMultaData);										
			}
	    
	    //Verifica qual deve ser o proximo campo a colocar o foco
	    function focoValor(evento, campoAtual, campo1, campo2){
					if(trim(document.frmMain.compleDescontoUmPercen.value) != ''){
					  habilitaCampoDependente(campoAtual,campo1);			
	 					nextFocus(evento, campoAtual, campo1);
	 				}
	 				else if(trim(document.frmMain.compleDescontoUmValor.value) != ''){
					  habilitaCampoDependente(campoAtual,campo2);			
	 					nextFocus(evento, campoAtual, campo2);
	 				}
			}
	    function foco(evento, campo1, campo2){
					habilitaCampoDependente(campo1,campo2);				
 					nextFocus(evento, campo1, campo2);
			}

	    function focoPrazo(evento, campoAtual, campo1, campo2){
					if(trim(document.frmMain.compleDescontoUmPrazo.value) != ''){
					  habilitaCampoDependente(campoAtual,campo1);		
	 					nextFocus(evento, campoAtual, campo1);
	 				}
	 				else if(trim(document.frmMain.compleDescontoUmData.value) != ''){
					  habilitaCampoDependente(campoAtual,campo2);	
	 					nextFocus(evento, campoAtual, campo2);
	 				}
	 				else if (trim(document.frmMain.compleDescontoUmPrazo.value) == '' && trim(document.frmMain.compleDescontoUmData.value) == ''){
	 					habilitaCampoDependente(campoAtual,campo1);	
	 					nextFocus(evento, campoAtual, campo1);
	 				}
			}
	    
	    function formSubmit() {
				if (validaSubmit()) {
	    		if (confirm(conf("101", "Título"))) {
						document.frmMain.princiSacadoCep.value = document.frmMain.cepInput.value;
						unFormataCep(document.frmMain.princiSacadoCep);

						document.frmMain.princiSacadoCpfCnpj.value= document.frmMain.princiSacadoCpfCnpjInput.value;
						unFormataCpfCnpj(document.frmMain.princiSacadoCpfCnpj,document.frmMain.princiSacadoTipoPessoaCombo)
						
						if (document.frmMain.princiEndossoInput.value == 'N') {
				  		document.frmMain.compleSacadorNome.value="";
			  			document.frmMain.compleSacadorCpfCnpj.value="";
			  		} else {
							document.frmMain.compleSacadorCpfCnpj.value= document.frmMain.compleSacadorCpfCnpjInput.value;
							unFormataCpfCnpj(document.frmMain.compleSacadorCpfCnpj,document.frmMain.compleSacadorTipoPessoa);
						}
						
						document.frmMain.princiEndosso.value = document.frmMain.princiEndossoInput.value;
						
						document.frmMain.princiDataVencimento.value = document.frmMain.princiDataVencimentoInput.value;
						
						//EAM - Permitir alterar apenas o endereço do sacado quando as
						//datas de vencimento/envio ao cartório estão vencidas
						document.frmMain.princiAceite.value = document.frmMain.princiAceiteCombo.value;
						document.frmMain.princiIndicadorProt.value = document.frmMain.princiIndicadorProtCombo.value;
						document.frmMain.princiPrazoProtDev.value = document.frmMain.princiPrazoProtDevInput.value;						
						document.frmMain.princiEspecie.value = document.frmMain.princiEspecieCombo.value;
						document.frmMain.princiSacadoNome.value = document.frmMain.princiSacadoNomeInput.value;
						document.frmMain.princiSacadoTipoPessoa.value = document.frmMain.princiSacadoTipoPessoaCombo.value;
						document.frmMain.princiSacadoEmail.value = document.frmMain.princiSacadoEmailInput.value;
						document.frmMain.princiPvCobrador.value = document.frmMain.princiPvCobradorInput.value;
	
		        
		        document.frmMain.submit();
		      }
        }
	    }

	    function formSubmit_Voltar() {
    		if (confirm(conf("103"))) {
           document.frmMain.estrategia.value = "<%=BcoTituEstrategia.STRATEGY_MANTER_FILTRO%>";
           document.frmMain.fluxo.value = "normal";
           document.frmMain.submit();
        }
      }  

			function configuraCampoDependente(campo){

				//--- inicio -------------- campo 'princiEndosso'
				if (campo == document.frmMain.princiEndossoInput) {
		  		if(document.frmMain.princiEndossoInput.value == 'S') { // endosso = sim
			  		if (document.frmMain.compleSacadorNome.value.indexOf('~') != -1)
				  		document.frmMain.compleSacadorNome.value="";
			  		if (document.frmMain.compleSacadorCpfCnpjInput.value.indexOf('~') != -1)
			  			document.frmMain.compleSacadorCpfCnpjInput.value="";
		  			document.frmMain.compleSacadorNome.disabled=false;
		  			document.frmMain.compleSacadorTipoPessoa.disabled=false;
			  		document.frmMain.compleSacadorCpfCnpjInput.disabled=false;
			  	}	else {
			  		document.frmMain.compleSacadorNome.value="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		  			document.frmMain.compleSacadorCpfCnpjInput.value="~~~~~~~~~~~~~~~~~~~~~~~~";
		  			document.frmMain.compleSacadorNome.disabled=true;
		  			document.frmMain.compleSacadorTipoPessoa.disabled=true;
			  		document.frmMain.compleSacadorCpfCnpjInput.disabled=true;
					}
				}
				//--- fim ----------------- campo 'princiEndosso'

				//--- inicio -------------- campo 'compleTipoJurosMes'
				/*
				if (campo == document.frmMain.compleTipoJurosMes) {
					if(campo.value != 2) { // Juros Cedente
					  document.frmMain.complePercenJurosMes.value = "~~~~~~~~~~~~~~";
						document.frmMain.complePercenJurosMes.disabled = true;
					} else {
							if (document.frmMain.complePercenJurosMes.value.indexOf('~') != -1)
							  document.frmMain.complePercenJurosMes.value = "";
							document.frmMain.complePercenJurosMes.disabled = false;
					}
				}
				*/
				//--- fim ----------------- campo 'compleTipoJurosMes'

				//--- inicio -------------- campo 'compleDescontoUmPercen'
				if(campo == document.frmMain.compleDescontoUmPercen){
					campo2 = document.frmMain.compleDescontoUmValor;
					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, campo2);
					} else {
						habilitaCampoAlternado(campo, campo2);
						if(trim(document.frmMain.compleDescontoUmData.value)==''){
							habilitaCampoDependente(campo,document.frmMain.compleDescontoUmPrazo);
						}
						if(trim(document.frmMain.compleDescontoUmPrazo.value)==''){							
							habilitaCampoDependente(campo,document.frmMain.compleDescontoUmData);
						}
						habilitaCampoDependente(campo,document.frmMain.compleDescontoDoisPercen);
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoUmPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoUmData);
						desabilitaCampoDependente(campo, campo, document.frmMain.compleDescontoDoisPercen);
						desabilitaCampoDependente(campo2, campo2, document.frmMain.compleDescontoDoisValor);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoDoisPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoDoisData);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresPercen);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresValor);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresData);															
					}
				}
				//--- fim ----------------- campo 'compleDescontoUmPercen'

				//--- inicio -------------- campo 'compleDescontoUmValor'
				if(campo == document.frmMain.compleDescontoUmValor ){
					campo2 = document.frmMain.compleDescontoUmPercen;
					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, campo2);
					} else {
						if(trim(document.frmMain.compleDescontoUmData.value)==''){
							habilitaCampoDependente(campo,document.frmMain.compleDescontoUmPrazo);
						}
						if(trim(document.frmMain.compleDescontoUmPrazo.value)==''){							
							habilitaCampoDependente(campo,document.frmMain.compleDescontoUmData);
						}
						habilitaCampoDependente(campo,document.frmMain.compleDescontoDoisValor);					
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoUmPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoUmData);
						desabilitaCampoDependente(campo2, campo2, document.frmMain.compleDescontoDoisPercen);
						desabilitaCampoDependente(campo, campo, document.frmMain.compleDescontoDoisValor);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoDoisPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoDoisData);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresPercen);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresValor);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresData);															
					}
				}
				//--- fim ----------------- campo 'compleDescontoUmValor'

				//--- inicio -------------- campo 'compleDescontoUmPrazo'
				if(campo == document.frmMain.compleDescontoUmPrazo ){
					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, document.frmMain.compleDescontoUmData);
					} else {
  					habilitaCampoDependente2(document.frmMain.compleDescontoDoisValor, document.frmMain.compleDescontoDoisPercen, document.frmMain.compleDescontoDoisPrazo);
   					habilitaCampoDependente2(document.frmMain.compleDescontoTresValor, document.frmMain.compleDescontoTresPercen, document.frmMain.compleDescontoTresPrazo); 					
						desabilitaCampoAlternado(campo, document.frmMain.compleDescontoUmData);
						desabilitaCampoDependente(campo, campo, document.frmMain.compleDescontoDoisPrazo);
						desabilitaCampoDependente(campo, campo, document.frmMain.compleDescontoTresPrazo);
					}
				}
				//--- fim ----------------- campo 'compleDescontoUmPrazo'

				//--- inicio -------------- campo 'compleDescontoUmData'
				if(campo == document.frmMain.compleDescontoUmData ){
					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, document.frmMain.compleDescontoUmPrazo);
					} else {
  					habilitaCampoDependente2(document.frmMain.compleDescontoDoisValor, document.frmMain.compleDescontoDoisPercen, document.frmMain.compleDescontoDoisData);
   					habilitaCampoDependente2(document.frmMain.compleDescontoTresValor, document.frmMain.compleDescontoTresPercen, document.frmMain.compleDescontoTresData); 					
						desabilitaCampoAlternado(campo, document.frmMain.compleDescontoUmPrazo);
						desabilitaCampoDependente(campo, campo, document.frmMain.compleDescontoDoisData);
						desabilitaCampoDependente(campo, campo, document.frmMain.compleDescontoTresData);
					}
				}
				//--- fim ----------------- campo 'compleDescontoUmData'

				//--- inicio -------------- campo 'compleDescontoDoisPercen'
				if(campo == document.frmMain.compleDescontoDoisPercen){
					campo2 = document.frmMain.compleDescontoDoisValor;
					if(window.event.type != "focus"){
						habilitaCampoDependente(campo,document.frmMain.compleDescontoDoisPrazo);
						habilitaCampoDependente(campo,document.frmMain.compleDescontoDoisData);
						desabilitaCampoAlternado(document.frmMain.compleDescontoUmData, document.frmMain.compleDescontoDoisPrazo);
						desabilitaCampoAlternado(document.frmMain.compleDescontoUmData, document.frmMain.compleDescontoTresPrazo);						
						desabilitaCampoAlternado(document.frmMain.compleDescontoUmPrazo, document.frmMain.compleDescontoDoisData);
  					desabilitaCampoAlternado(document.frmMain.compleDescontoUmPrazo, document.frmMain.compleDescontoTresData);
						habilitaCampoDependente(campo,document.frmMain.compleDescontoTresPercen);
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoDoisPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoDoisData);
						desabilitaCampoDependente(campo, campo, document.frmMain.compleDescontoTresPercen);
						desabilitaCampoDependente(campo2, campo2, document.frmMain.compleDescontoTresValor);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresData);															
					}
				}
				//--- fim ----------------- campo 'compleDescontoDoisPercen'

				//--- inicio -------------- campo 'compleDescontoDoisValor'
				if(campo == document.frmMain.compleDescontoDoisValor ){
					campo2 = document.frmMain.compleDescontoDoisPercen;
					if(window.event.type != "focus"){
						habilitaCampoDependente(campo,document.frmMain.compleDescontoDoisPrazo);
						habilitaCampoDependente(campo,document.frmMain.compleDescontoDoisData);
						desabilitaCampoAlternado(document.frmMain.compleDescontoUmData, document.frmMain.compleDescontoDoisPrazo);
						desabilitaCampoAlternado(document.frmMain.compleDescontoUmData, document.frmMain.compleDescontoTresPrazo);						
						desabilitaCampoAlternado(document.frmMain.compleDescontoUmPrazo, document.frmMain.compleDescontoDoisData);
  					desabilitaCampoAlternado(document.frmMain.compleDescontoUmPrazo, document.frmMain.compleDescontoTresData);
						habilitaCampoDependente(campo,document.frmMain.compleDescontoTresValor);
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoDoisPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoDoisData);
						desabilitaCampoDependente(campo2, campo2, document.frmMain.compleDescontoTresPercen);
						desabilitaCampoDependente(campo, campo, document.frmMain.compleDescontoTresValor);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresData);																
					}
				}
				//--- fim ----------------- campo 'compleDescontoDoisValor'

				//--- inicio -------------- campo 'compleDescontoDoisPrazo'
				if(campo == document.frmMain.compleDescontoDoisPrazo ){
					if(window.event.type != "focus"){
   					habilitaCampoDependente2(document.frmMain.compleDescontoTresValor, document.frmMain.compleDescontoTresPercen, document.frmMain.compleDescontoTresPrazo); 					
						desabilitaCampoAlternado(campo, document.frmMain.compleDescontoDoisData);
						desabilitaCampoDependente(campo, campo, document.frmMain.compleDescontoTresPrazo);					
					}
				}
				//--- fim ----------------- campo 'compleDescontoDoisPrazo'

				//--- inicio -------------- campo 'compleDescontoDoisData'
				if(campo == document.frmMain.compleDescontoDoisData ){
					if(window.event.type != "focus"){
   					habilitaCampoDependente2(document.frmMain.compleDescontoTresValor, document.frmMain.compleDescontoTresPercen, document.frmMain.compleDescontoTresData); 					
						desabilitaCampoAlternado(campo, document.frmMain.compleDescontoDoisPrazo);
						desabilitaCampoDependente(campo, campo, document.frmMain.compleDescontoTresData);					
					}
				}
				//--- fim ----------------- campo 'compleDescontoDoisData'

				//--- inicio -------------- campo 'compleDescontoTresPercen'
				if(campo == document.frmMain.compleDescontoTresPercen){
					campo2 = document.frmMain.compleDescontoTresValor;
					if(window.event.type != "focus"){
						habilitaCampoDependente(campo,document.frmMain.compleDescontoTresPrazo);
						habilitaCampoDependente(campo,document.frmMain.compleDescontoTresData);
						desabilitaCampoAlternado(document.frmMain.compleDescontoUmData, document.frmMain.compleDescontoTresPrazo);						
  						desabilitaCampoAlternado(document.frmMain.compleDescontoUmPrazo, document.frmMain.compleDescontoTresData);
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresData);															
					}
				}
				//--- fim ----------------- campo 'compleDescontoTresPercen'

				//--- inicio -------------- campo 'compleDescontoTresValor'
				if(campo == document.frmMain.compleDescontoTresValor ){
					campo2 = document.frmMain.compleDescontoTresPercen;
					if(window.event.type != "focus"){
						habilitaCampoDependente(campo,document.frmMain.compleDescontoTresPrazo);
						habilitaCampoDependente(campo,document.frmMain.compleDescontoTresData);
						desabilitaCampoAlternado(document.frmMain.compleDescontoUmData, document.frmMain.compleDescontoTresPrazo);						
  						desabilitaCampoAlternado(document.frmMain.compleDescontoUmPrazo, document.frmMain.compleDescontoTresData);
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleDescontoTresData);																
					}
				}
				//--- fim ----------------- campo 'compleDescontoTresValor'

				//--- inicio -------------- campo 'compleDescontoTresPrazo
				if(campo == document.frmMain.compleDescontoTresPrazo ){
					if(window.event.type != "focus"){
						desabilitaCampoAlternado(campo, document.frmMain.compleDescontoTresData);
					}
				}
				//--- fim ----------------- campo 'compleDescontoTresPrazo'
			
				//--- inicio -------------- campo 'compleDescontoTresData'
				if(campo == document.frmMain.compleDescontoTresData ){
					if(window.event.type != "focus"){
						desabilitaCampoAlternado(campo, document.frmMain.compleDescontoTresPrazo);
					}
				}
				//--- fim ----------------- campo 'compleDescontoTresData'

				//--- inicio -------------- campo 'compleMultaPercen'
				if(campo == document.frmMain.compleMultaPercen){
					campo2 = document.frmMain.compleMultaValor;
					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, campo2);
					} else {
						habilitaCampoDependente(campo,document.frmMain.compleMultaPrazo);
						habilitaCampoDependente(campo,document.frmMain.compleMultaData);
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleMultaPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleMultaData);
					}
				}
				//--- fim ----------------- campo 'compleMultaPercen'

				//--- inicio -------------- campo 'compleMultaValor'
				if(campo == document.frmMain.compleMultaValor ){
					campo2 = document.frmMain.compleMultaPercen;
					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, campo2);
					} else {
						habilitaCampoDependente(campo,document.frmMain.compleMultaPrazo);
						habilitaCampoDependente(campo,document.frmMain.compleMultaData);
						desabilitaCampoAlternado(campo, campo2);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleMultaPrazo);
						desabilitaCampoDependente(campo, campo2, document.frmMain.compleMultaData);
					}
				}
				//--- fim ----------------- campo 'compleMultaValor'

				//--- inicio -------------- campo 'compleMultaPrazo
				if(campo == document.frmMain.compleMultaPrazo ){
					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, document.frmMain.compleMultaData);
					} else {
						desabilitaCampoAlternado(campo, document.frmMain.compleMultaData);
					}
				}
				//--- fim ----------------- campo 'compleMultaPrazo'
			
				//--- inicio -------------- campo 'compleMultaData'
				if(campo == document.frmMain.compleMultaData ){
					if(window.event.type == "focus"){
						habilitaCampoAlternado(campo, document.frmMain.compleMultaPrazo);
					} else {
						desabilitaCampoAlternado(campo, document.frmMain.compleMultaPrazo);
					}
				}
				//--- fim ----------------- campo 'compleMultaData'
			}

	    function validaSubmit(){
				// data de vencimento
	    	if(!validaComboObrigatorio(document.frmMain.princiDataVencimentoInput, 'Data de Vencimento')){
			  	return false;
				}
		    if (trim(document.frmMain.princiDataVencimentoInput.value) != ""){ 
		    	if(!validaData(document.frmMain.princiDataVencimentoInput)) {
				  	msg('014','Data de Vencimento');
				    return false;
				  }
				  if (document.frmMain.princiDataVencimentoInput.value != document.frmMain.princiDataVencimento.value) {
		        // Desabilitado a pedido do Edson - 21/08
				//
	  	      	//msg('006','Data Vencimento','Data de Hoje');
	    	    //	document.frmMain.princiDataVencimentoInput.focus();
	      	  	//return false;
	        	//}   
	        }
		    }
				// prazo protesto devolucao
	    	if(!validaComboObrigatorio(document.frmMain.princiPrazoProtDevInput, 'Prazo de Protesto/Devolução')){
			  	return false;
				}
	    	if(document.frmMain.princiIndicadorProtCombo.value == "S"){
			  	if(!validaIntervalo(document.frmMain.princiPrazoProtDevInput, 'Prazo de Protesto/Devolução', '2', '90')){
						return false;
			    }		    	
			  }
			  if(document.frmMain.princiIndicadorProtCombo.value == "N"){
			  	if(!validaIntervalo(document.frmMain.princiPrazoProtDevInput, 'Prazo de Protesto/Devolução', '0', '999')){
						return false;
			    }		    	
			  }
				// nome sacado
	    	if(!validaComboObrigatorio(document.frmMain.princiSacadoNomeInput, 'Nome do Sacado')){
			  	return false;
				}
				// cpf/cnpj sacado
	    	if(!validaComboObrigatorio(document.frmMain.princiSacadoCpfCnpjInput, 'CPF/CNPJ do Sacado')){
			  	return false;
				}
				if(!validaDvCpfCnpj(document.frmMain.princiSacadoCpfCnpjInput,document.frmMain.princiSacadoTipoPessoaCombo)){
					msg('008','CPF/CNPJ do Sacado');
			    return false;
				}
				// cep sacado				
	    	if(!validaComboObrigatorio(document.frmMain.cepInput, 'CEP do Sacado')){
			  	return false;
				}
				// uf sacado
	    	if(!validaComboObrigatorio(document.frmMain.princiSacadoUf, 'UF do Sacado')){
			  	return false;
				}
				// logradouro sacado
	    	if(!validaComboObrigatorio(document.frmMain.princiSacadoLogradouro, 'Endereço do Sacado')){
			  	return false;
				}
			
			<%-- SISOL 299231 - Set/2008 - Removida obrigatoriedade do campo Número do Sacado
				// numero sacado
	    	if(!validaComboObrigatorio(document.frmMain.princiSacadoNumero, 'Número do Sacado')){
			  	return false;
				}
			--%>
				// bairro sacado
	    	if(!validaComboObrigatorio(document.frmMain.princiSacadoBairro, 'Bairro do Sacado')){
			  	return false;
				}
				// municipio sacado
	    	if(!validaComboObrigatorio(document.frmMain.princiSacadoMunicipio, 'Município do Sacado')){
			  	return false;
				}
				// email sacado
				if(document.frmMain.princiSacadoEmailInput.value != ''){
					if(validaEmail(document.frmMain.princiSacadoEmailInput.value)){
						msg("049");
						return false;
					}
				}
				// pv cobrador
	    	if(!validaComboObrigatorio(document.frmMain.princiPvCobradorInput, 'PV Cobrador')){
			  	return false;
				} else {
						if(!validaMenorIgual(document.frmMain.princiPvCobradorInput, 'PV Cobrador', 0)) {
							return false;
						}
				}

			  if(document.frmMain.emissaoBloqueto.value != 1){
			    if(!validaComboObrigatorio(document.frmMain.envioBloqueto, 'Envio de Boleto')){
				  return false;
			    }
			  }
			  
				if (comparaValor(document.frmMain.compleAbatimento, document.frmMain.valorTeste, ">")) {
					if (!comparaValor(document.frmMain.compleAbatimento, document.frmMain.princiValorTitulo, "<")) {
						msg("007", "Abatimento", document.frmMain.princiValorTitulo.value);
						return false;
					}
				}
				if (<%=!tituloVencido%>) {
					// tipo juros
		    	if(!validaComboObrigatorio(document.frmMain.compleTipoJurosMes, 'Tipo Juros Mes','-999')){
				  	return false;
					}
					// percentual juros
			   	if(document.frmMain.compleTipoJurosMes.value == 2){
						if(trim(document.frmMain.complePercenJurosMes.value) != ''){
							if(!validaPercentualZero(document.frmMain.complePercenJurosMes, 'Percentual Juros Mês')){
						  	return false;				
							}
						}
				  }
					// abatimento
					if (comparaValor(document.frmMain.compleAbatimento, document.frmMain.valorTeste, ">")) {
						if (!comparaValor(document.frmMain.compleAbatimento, document.frmMain.princiValorTitulo, "<")) {
							msg("007", "Abatimento", document.frmMain.princiValorTitulo.value);
							return false;
						}
					}
					// nome sacador e cpf/cnpj sacador
					if(document.frmMain.princiEndossoInput.value == 'S') {
			    	if(!validaComboObrigatorio(document.frmMain.compleSacadorNome, 'Nome Sacador/Avalista')){
					  	return false;
						}
			    	if(!validaComboObrigatorio(document.frmMain.compleSacadorCpfCnpjInput, 'CPF/CNPJ do Sacador')){
					  	return false;
						}
						if(!validaDvCpfCnpj(document.frmMain.compleSacadorCpfCnpjInput,document.frmMain.compleSacadorTipoPessoa)){
							msg('008','CPF/CNPJ do Sacador');
					    return false;
						}
					}
					// Valida CPF/CNPJ sacado, sacador e cedente ser diferente um do outro.
					if (document.frmMain.princiSacadoCpfCnpjInput.value == document.frmMain.compleSacadorCpfCnpjInput.value) {
						msg('043');
						return false;
					}
					if (document.frmMain.princiSacadoCpfCnpjInput.value == '<%=cedCabBean.getCpfCnpjFormatado()%>') {
						msg('044');
						return false;
					}
					if (document.frmMain.compleSacadorCpfCnpjInput.value == '<%=cedCabBean.getCpfCnpjFormatado()%>') {
						msg('045');
						return false;
					}
					// Valida campos Desconto 1				
					if(document.frmMain.compleDescontoUmPercen.value != ''){
						if(!validaPercentualZero(document.frmMain.compleDescontoUmPercen, 'Desconto 1')){
						  return false;				
						}
						if(!validaPercentualCem(document.frmMain.compleDescontoUmPercen, 'Desconto 1')){
						  return false;				
						}					
					}
					if(document.frmMain.compleDescontoUmValor.value !=''){
						if(!validaValorZero(document.frmMain.compleDescontoUmValor, 'Desconto 1')){
							return false;
						}
					}
			   	if(document.frmMain.compleDescontoUmPercen.value != '' || document.frmMain.compleDescontoUmValor.value != ''){
			   		if(!validaCampoObrigatorioAlternado(document.frmMain.compleDescontoUmPrazo,
			   																				document.frmMain.compleDescontoUmData,'Prazo Limite 1', '010')){
			   			return false;
			   		}
			   	}	  
			    if (trim(document.frmMain.compleDescontoUmData.value) != ""){ 
			       if(!validaData(document.frmMain.compleDescontoUmData)) {
					    	msg('014','Prazo Limite 1');
					    	return false;
					   }
			    }
					// Valida campos Desconto 2
					if(document.frmMain.compleDescontoDoisPercen.value != ''){
						if(!validaPercentualZero(document.frmMain.compleDescontoDoisPercen, 'Desconto 2')){
						  return false;				
						}
						if(!validaPercentualCem(document.frmMain.compleDescontoDoisPercen, 'Desconto 2')){
						  return false;				
						}						
						if(!comparaPercentual(document.frmMain.compleDescontoUmPercen, document.frmMain.compleDescontoDoisPercen, ">")){
							msg('007','Desconto 2', 'Desconto 1');
							return false;
						}
					}
					if(document.frmMain.compleDescontoDoisValor.value !=''){
						if(!validaValorZero(document.frmMain.compleDescontoDoisValor, 'Desconto 2')){
							return false;
						}
						if(!comparaValor(document.frmMain.compleDescontoUmValor, document.frmMain.compleDescontoDoisValor, ">")){
							msg('007','Desconto 2', 'Desconto 1');
							return false;
						}					
					}
			   	if(document.frmMain.compleDescontoDoisPercen.value != '' || document.frmMain.compleDescontoDoisValor.value != ''){
			   		if(!validaCampoObrigatorioAlternado(document.frmMain.compleDescontoDoisPrazo,
			   																				document.frmMain.compleDescontoDoisData,'Prazo Limite 2', '010')){
			   			return false;
			   		}
			   	}	   
					if(document.frmMain.compleDescontoDoisPrazo.value != ''){
						if(!comparaNumero(document.frmMain.compleDescontoUmPrazo, document.frmMain.compleDescontoDoisPrazo, ">")){
							msg('007','Prazo Limite 2', 'Prazo Limite 1');
							return false;
						}
					}
					if(document.frmMain.compleDescontoDoisData.value != ''){
						if(!compararDatas(document.frmMain.compleDescontoUmData.value, document.frmMain.compleDescontoDoisData.value, "<")){
							msg('006','Prazo Limite 2', 'Prazo Limite 1');
							return false;
						}
					}				
			    if (trim(document.frmMain.compleDescontoDoisData.value) != ""){ 
			       if(!validaData(document.frmMain.compleDescontoDoisData)) {
					    	msg('014','Prazo Limite 2');
					    	return false;
					   }
			    }
					// Valida campos Desconto 3
					if(document.frmMain.compleDescontoTresPercen.value != ''){
						if(!validaPercentualZero(document.frmMain.compleDescontoTresPercen, 'Desconto 3')){
						  return false;				
						}
						if(!validaPercentualCem(document.frmMain.compleDescontoTresPercen, 'Desconto 3')){
						  return false;				
						}						
						if(!comparaPercentual(document.frmMain.compleDescontoDoisPercen, document.frmMain.compleDescontoTresPercen, ">")){
							msg('007','Desconto 3', 'Desconto 2');
							return false;
						}
					}
					if(document.frmMain.compleDescontoTresValor.value !=''){
						if(!validaValorZero(document.frmMain.compleDescontoTresValor, 'Desconto 3')){
							return false;
						}
						if(!comparaValor(document.frmMain.compleDescontoDoisValor, document.frmMain.compleDescontoTresValor, ">")){
							msg('007','Desconto 3', 'Desconto 2');
							return false;
						}					
					}
			   	if(document.frmMain.compleDescontoTresPercen.value != '' || document.frmMain.compleDescontoTresValor.value != ''){
			   		if(!validaCampoObrigatorioAlternado(document.frmMain.compleDescontoTresPrazo,
			   																				document.frmMain.compleDescontoTresData,'Prazo Limite 3', '010')){
			   			return false;
			   		}
			   	}	   			    
					if(document.frmMain.compleDescontoTresPrazo.value != ''){
						if(!comparaNumero(document.frmMain.compleDescontoDoisPrazo, document.frmMain.compleDescontoTresPrazo, ">")){
							msg('007','Prazo Limite 3', 'Prazo Limite 2');
							return false;
						}
					}
					if(document.frmMain.compleDescontoTresData.value != ''){
						if(!compararDatas(document.frmMain.compleDescontoDoisData.value, document.frmMain.compleDescontoTresData.value, "<")){
							msg('006','Prazo Limite 3', 'Prazo Limite 2');
							return false;
						}
					}				
			    if (trim(document.frmMain.compleDescontoTresData.value) != ""){ 
			       if(!validaData(document.frmMain.compleDescontoTresData)) {
					    	msg('014','Prazo Limite 3');
					    	return false;
					   }
			    }
					// Valida campos Multa
					if(document.frmMain.compleMultaPercen.value != ''){
						if(!validaPercentualZero(document.frmMain.compleMultaPercen, 'Multa')){
						  return false;				
						}
					}
					if(document.frmMain.compleMultaValor.value !=''){
						if(!validaValorZero(document.frmMain.compleMultaValor, 'Multa')){
							return false;
						}
					}
			   	if(document.frmMain.compleMultaPercen.value != '' || document.frmMain.compleMultaValor.value != ''){
			   		if(!validaCampoObrigatorioAlternado(document.frmMain.compleMultaPrazo,
			   																				document.frmMain.compleMultaData,'Multa', '010')){
			   			return false;
			   		}
			   		if(!validaMenorIgual(document.frmMain.compleMultaPrazo, 'Prazo para Multa', 0)){
							  return false;				
						}			
			   	}	   			    
					if (trim(document.frmMain.compleMultaData.value) != ""){ 
		      	if(!validaData(document.frmMain.compleMultaData)) {
			    		msg('014','Multa');
					    return false;
					   }
		        if (!compararDatas(document.frmMain.compleMultaData.value, document.frmMain.princiDataVencimentoInput.value, ">=")) {
	  	      	msg('033','Data Multa','Data Vencimento');
	    	    	document.frmMain.compleMultaData.focus();
	      	  	return false;
	        	}   
	        	}
				}
				

				
				
	    	return true;
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
		    document.frmMain.princiSacadoLogradouro.value = document.frmMain.endereco.value;
		    document.frmMain.princiSacadoBairro.value = document.frmMain.bairro.value;
		    document.frmMain.princiSacadoMunicipio.value = document.frmMain.municipio.value;
		    document.frmMain.princiSacadoUf.value = document.frmMain.uf.value;
		    document.frmMain.princiSacadoNumero.focus();		    
	    }
	    
	    function controlaTpPagamento(){
	    	
	    	var formulario = document.frmMain;
	    	
	    	if (formulario.icTipoPagamento.value=="1"){
	    		if (<%=tituloBean.getPrinciEspecie().toString()%>=="31" ){
		    		formulario.vrMaximoPgto.disabled=false;
		    		formulario.vrMinPgto.disabled=false;
		    		formulario.vrMaximoPgto.value="";
		    		formulario.vrMinPgto.value="";
	    		}else{
		    		formulario.vrMaximoPgto.disabled=true;
		    		formulario.vrMinPgto.disabled=true;
		    		formulario.vrMaximoPgto.value="";
		    		formulario.vrMinPgto.value="";	    			
	    		}
	    			
	    	}else if (formulario.icTipoPagamento.value=="2"){
	    		formulario.vrMaximoPgto.disabled=false;
	    		formulario.vrMinPgto.disabled=false;
	    	}else if (formulario.icTipoPagamento.value=="3"){
	    		formulario.vrMaximoPgto.disabled=true;
	    		formulario.vrMinPgto.disabled=true;
	    		formulario.vrMaximoPgto.value="";
	    		formulario.vrMinPgto.value="";
	    	}else if (formulario.icTipoPagamento.value=="4"){
	    		formulario.vrMaximoPgto.disabled=true;
	    		formulario.vrMinPgto.disabled=false;
	    		formulario.vrMaximoPgto.value="";
	    	}else{
	    		formulario.icTipoPagamento.value=="1";
	    	}
	    }
	    
	    
	    function icParcialChange(){
	    	
	    	
	    	var formulario = document.frmMain;
	    		
	    		if (formulario.pgtoParcial.value=="S"){
	    			formulario.qtPgtoPossivel.disabled=false;
	    			formulario.icTipoPagamento.disabled=false;
	    			document.getElementById("blockCombo").style.display = "none";
	    			document.getElementById("exibeCombo").style.display = "block";
	    			controlaTpPagamento();
	    		}else{
	    			formulario.qtPgtoPossivel.disabled=true;
	    			formulario.icTipoPagamento.disabled=true;
	    			formulario.icTipoPagamento.value="3";
	    			formulario.qtPgtoPossivel.value="";
	    			formulario.vrMaximoPgto.disabled=true;
		    		formulario.vrMinPgto.disabled=true;
		    		formulario.vrMaximoPgto.value="";
		    		formulario.vrMinPgto.value="";
		    		document.getElementById("blockCombo").style.display = "block";
	    			document.getElementById("exibeCombo").style.display = "none";
	    		}
	    		
	    		
	    		
	    }
	    

	    

		</script>
	</s:FormStrategy>
</p:Document>
</html>
