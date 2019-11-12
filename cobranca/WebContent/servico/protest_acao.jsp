<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Agosto de 2004
*Projeto CAIXA - SIGCB
*Componente: protest_acao.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 26/09/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="java.util.Calendar"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ProtestEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(ProtestEstrategia.USUARIOLDAP_BEAN);
	CedenteCabecaBean cedCabBean = (session.getAttribute(ProtestEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(ProtestEstrategia.CEDENTE_CABECALHO_BEAN));
	TituloBean tituloBean = (session.getAttribute(ProtestEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(ProtestEstrategia.DATA_BEAN));	
%>

<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=ProtestEstrategia.PAGE_TITLE_ACAO%>"/>
		
		<input type="hidden" name = "codigoCedente" value="<%=cedCabBean.getCodigoCedente()%>">		
		<input type="hidden" name = "nossoNumero" value="<%=tituloBean.getNossoNumero()%>">			
		<input type="hidden" name = "acoesServicoTitulo" value="<%=tituloBean.getAcoesServicoTitulo()%>">			

		<input type="hidden" name = "acoesHistorico" value="<%=tituloBean.getAcoesHistorico()%>">

		<input type="hidden" name = "abatiCustasCartorarias" value="<%=tituloBean.getAbatiCustasCartorarias()%>">
		<input type="hidden" name = "nomeGrupo" value="<%=usuarioBean.getNomeGrupo()%>">
    
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">

            <tr>
              <td class="textoTitulo" width="17%">Data da Solicitação: </td>
              <td class="textoValor" width="26%"><%=Formatador.formatarData(Calendar.getInstance().getTime())%></td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Dados Básicos do Título:
                <hr>
              </td>
            </tr>
	          <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getCodigoCedenteFormatado()%></td>
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
              <td class="textoTitulo" width="17%">Nosso Número: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getNossoNumeroFormatado()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Meio de Entrada: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getPrinciMeioEntrada()%></td>
							<td class="textoTitulo" width="17%">Valor: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getPrinciValorTitulo()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Situação: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getPrinciDescricaoSituacao()%></td> 
              <td class="textoTitulo" width="17%">Ação: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getAcoesServicoTituloTexto().toUpperCase()%></td>
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Informar Dados Complementares:
                <hr>
              </td>
            </tr>
            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            
            
            <tr>
            	<td colspan="4">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
			            <tr>
			            	<td class="textoTitulo" width="17%">Valor Recebido: </td>
			              <td class="textoValor" width="26%">
						        	<p:InputCurrency CLASS="inputtext" 
							        	name="acoesValorRecebido" 
							          value='<%=tituloBean.getAcoesValorRecebido().toString().equals("R$ 0,00")?"":tituloBean.getAcoesValorRecebido().toString()%>'
							          size="25" maxlength="21"
							          disabled="true"
			                	onFocus="javascript: prevFocus(this);"
												onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.acoesDespesasCartorarias);"/>
										</td>
			              <td class="textoTitulo" width="17%">Despesas Cartorárias: </td>
			              <td class="textoValor" width="26%">
						        	<p:InputCurrency CLASS="inputtext" 
							        	name="acoesDespesasCartorarias" 
							          value='<%=tituloBean.getAcoesDespesasCartorarias().toString().equals("R$ 0,00")?"":tituloBean.getAcoesDespesasCartorarias().toString()%>'
							          size="28" maxlength="21" 
							          disabled="true"
												onFocus="javascript: prevFocus(this);"
												onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Editar);"/>
			              </td>
			            </tr>

			            <tr>
			              <td class="textoTitulo" width="17%">Histórico: </td>
			              <td class="textoValor" width="26%" colspan="3">
			                <p align="justify">
			                  <textarea name="textAreaAcoesHistorico" cols="50" rows = "2" class="textoValor" readonly><%=tituloBean.getAcoesHistoricoFormatada()%></textarea>
										  	<s:Button name="Editar" action="javascript: editaMensagem(document.frmMain.textAreaAcoesHistorico, 50, 14, 23, 2);" disabled="true"/>
					          	</p>
			            	</td>
			            </tr>

			            <tr> 
			            	<td colspan="4">&nbsp;</td>
			            </tr>
		            </table>
		          </td>
		        </tr>
            
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Dados do Título:
                <hr>
              </td>
            </tr>

 						<tr>
 							<td colspan ="4"> 
		            <s:Outline name="Principais" title="Dados Principais" imagePath="<%=Paths.getImagePath()%>" type="outline">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Número Documento: </td>
				              <td class="textoValor" width="26%" nowrap><%=tituloBean.getPrinciNumeroDocumento()%></td>
                      <td class="textoTitulo" width="17%">Data de Vencimento: </td>
				              <td class="textoValor" width="26%" nowrap><%=tituloBean.getPrinciDataVencimentoFormatada().equals("01/01/0001")?"":tituloBean.getPrinciDataVencimentoFormatada()%></td>
                      </td>
                    </tr>
				            <tr>
				              <td class="textoTitulo" width="17%">Moeda:</td>
  			              <td class="textoValor" width="26%"><%=tituloBean.getPrinciMoedaTexto()%></td>
				              <td class="textoTitulo" width="17%">Aceite: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciDescricaoAceite()%></td>
                    </tr>
				            <tr>
                      <td class="textoTitulo" width="17%">Protesto: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciIndicadorProtTexto()%></td>
                      <td class="textoTitulo" width="17%" nowrap>Prazo de Protesto/Devolução: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciPrazoProtDev()%></td>
                    </tr>
										<tr>
	                    <td class="textoTitulo" width="17%">Endosso: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciEndossoTexto()%></td>
	                    <td class="textoTitulo" width="17%">Espécie de Título: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciDescricaoEspecie()%></td>	                    
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Nome do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoNome()%></td>                      
                      <td class="textoTitulo" width="17%">Tipo Pessoa Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoTipoPessoaTexto()%></td>
                    </tr>
				            <tr>
                      <td class="textoTitulo" width="17%">CPF/CNPJ Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoCpfCnpjFormatado()%></td>
                      <td class="textoTitulo" width="17%">CEP do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoCepFormatado()%></td>
                    </tr>
				            <tr>
                      <td class="textoTitulo" width="17%">UF do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoUf()%></td>                      
                      <td class="textoTitulo" width="17%">Endereço do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoLogradouro()%></td>                      
                    </tr>
				            <tr>
                      <td class="textoTitulo" width="17%">Numero do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoNumero()%></td>                      
                      <td class="textoTitulo" width="17%">Complemento do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoComplemento()%></td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Bairro do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoBairro()%></td>                      
                      <td class="textoTitulo" width="17%">Município do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoMunicipio()%></td>                      
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">e-mail do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciSacadoEmail()%></td>                      
                      <td class="textoTitulo" width="17%">PV Cobrador: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getPrinciPvCobradorFormatado()%></td>                      
                    </tr>				              
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                  </table>
                </s:Outline>
			        </td>
            </tr>

 						<tr>
 							<td colspan ="4">         
		            <s:Outline name="Abatimento" title="Dados Encargos e Abatimentos" imagePath="<%=Paths.getImagePath()%>" type="outline">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr> 
                      <td colspan="4" class="textoDestaqueTitulo">Datas e Valores</td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
				            <tr>
				              <td class="textoTitulo" width="23%">Data de Emissão: </td>
                      <td class="textoValor" width="20%"><%=tituloBean.getAbatiDataEmissaoFormatada().equals("01/01/0001")?"":tituloBean.getAbatiDataEmissaoFormatada()%></td>
				 						  <td class="textoTitulo" width="20%">Data de Entrada: </td>
                      <td class="textoValor" width="23%"><%=tituloBean.getAbatiDataEntradaFormatada().equals("01/01/0001")?"":tituloBean.getAbatiDataEntradaFormatada()%></td>
				            </tr>
				            <tr>
				              <td class="textoTitulo" width="23%">Previsão Protesto/Devolução: </td>
                      <td class="textoValor" width="20%"><%=tituloBean.getAbatiDataPrevisaoProtDevFormatada().equals("01/01/0001")?"":tituloBean.getAbatiDataPrevisaoProtDevFormatada()%></td>				              
				              <td class="textoTitulo" width="20%">Modalidade Título(Carteira): </td>
                      <td class="textoValor" width="23%"><%=tituloBean.getAbatiModalidadeFormatada().equals("01/01/0001")?"":tituloBean.getAbatiModalidadeFormatada()%></td>
				            </tr>
				            <tr>
				              <td class="textoTitulo" width="23%">Abatimento: </td>
				              <td class="textoValor" width="20%"><%=tituloBean.getAbatiAbatimento().toString().equals("R$ 0,00")?"":tituloBean.getAbatiAbatimento().toString()%></td>
				              <td class="textoTitulo" width="20%">Custas Cartorárias: </td>
                      <td class="textoValor" width="23%"><%=tituloBean.getAbatiCustasCartorarias().toString().equals("R$ 0,00")?"":tituloBean.getAbatiCustasCartorarias().toString()%></td>
										</tr>

                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="4" class="textoDestaqueTitulo">Encargos e Abatimentos</td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
				            <tr>
				              <td colspan="4">
				              	<table class="box" width="100%" border="0" cellspacing="3" cellpadding="0" height=14 valign="middle" align="center">
				              		<tr class="headerLista">
							              <td align="left" class="textoDestaqueTitulo" width="20%">&nbsp;</td>
							              <td align="left" class="textoDestaqueTitulo" width="20%">Prazo</td>
							              <td align="center" class="textoDestaqueTitulo" width="20%">Data</td>
														<td align="right" class="textoDestaqueTitulo" width="20%">Percentual</td>
							              <td align="right" class="textoDestaqueTitulo" width="20%">Valor</td> 
							            </tr>
				              		<tr class="line2">
							              <td class="textoDestaqueTitulo" width="20%">Multa</td>
							              <td class="textoValor" width="20%"><%=tituloBean.getAbatiMultaPrazo().equals(new Long(0))?"":tituloBean.getAbatiMultaPrazo().toString()%></td>
							              <td class="textoValor" align="center" width="20%"><%=tituloBean.getAbatiMultaDataFormatada().equals("01/01/0001")?"":tituloBean.getAbatiMultaDataFormatada()%></td>
														<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiMultaPercen().toString().equals("0,00 %")?"":tituloBean.getAbatiMultaPercen().toString()%></td>
							              <td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiMultaValor().toString().equals("R$ 0,00")?"":tituloBean.getAbatiMultaValor().toString()%></td> 
							            </tr>
				              		<tr class="line0">
							              <td class="textoDestaqueTitulo" width="20%">Juros</td>
							              <td class="textoValor" width="20%">&nbsp;</td>
							              <td class="textoValor" align="center" width="20%"><%=tituloBean.getAbatiJurosDataFormatada().equals("01/01/0001")?"":tituloBean.getAbatiJurosDataFormatada()%></td>
														<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiJurosPercen().toString().equals("0,00 %")?"":tituloBean.getAbatiJurosPercen().toString()%></td>
							              <td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiJurosValor().toString().equals("R$ 0,00")?"":tituloBean.getAbatiJurosValor().toString()%></td> 
							            </tr>
				              		<tr class="line2">
							              <td class="textoDestaqueTitulo" width="20%">Desconto 1</td>
							              <td class="textoValor" width="20%">
				                    <%if(!tituloBean.getAbatiDescontoUmPercen().toString().equals("0,00 %") || !tituloBean.getAbatiDescontoUmValor().toString().equals("R$ 0,00")){%>                    
							              		<%=tituloBean.getAbatiDescontoUmPrazo().toString()%>
				                    <%}%>		
							              </td>
							              <td class="textoValor" align="center" width="20%"><%=tituloBean.getAbatiDescontoUmDataFormatada().equals("01/01/0001")?"":tituloBean.getAbatiDescontoUmDataFormatada()%></td>
														<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoUmPercen().toString().equals("0,00 %")?"":tituloBean.getAbatiDescontoUmPercen().toString()%></td>
							              <td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoUmValor().toString().equals("R$ 0,00")?"":tituloBean.getAbatiDescontoUmValor().toString()%></td> 
							            </tr>
				              		<tr class="line2">
							              <td class="textoDestaqueTitulo" width="20%">Desconto 2</td>
							              <td class="textoValor" width="20%">
				                    <%if(!tituloBean.getAbatiDescontoDoisPercen().toString().equals("0,00 %") || !tituloBean.getAbatiDescontoDoisValor().toString().equals("R$ 0,00")){%>                    
							              		<%=tituloBean.getAbatiDescontoDoisPrazo().toString()%>
				                    <%}%>	
							              </td>
							              <td class="textoValor" align="center" width="20%"><%=tituloBean.getAbatiDescontoDoisDataFormatada().equals("01/01/0001")?"":tituloBean.getAbatiDescontoDoisDataFormatada()%></td>
														<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoDoisPercen().toString().equals("0,00 %")?"":tituloBean.getAbatiDescontoDoisPercen().toString()%></td>
							              <td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoDoisValor().toString().equals("R$ 0,00")?"":tituloBean.getAbatiDescontoDoisValor().toString()%></td> 
							            </tr>
				              		<tr class="line2">
							              <td class="textoDestaqueTitulo" width="20%">Desconto 3</td>
							              <td class="textoValor" width="20%">
				                    <%if(!tituloBean.getAbatiDescontoTresPercen().toString().equals("0,00 %") || !tituloBean.getAbatiDescontoTresValor().toString().equals("R$ 0,00")){%>                    
							              		<%=tituloBean.getAbatiDescontoTresPrazo().toString()%>
				                    <%}%>		
							              </td>
							              <td class="textoValor" align="center" width="20%"><%=tituloBean.getAbatiDescontoTresDataFormatada().equals("01/01/0001")?"":tituloBean.getAbatiDescontoTresDataFormatada()%></td>
														<td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoTresPercen().toString().equals("0,00 %")?"":tituloBean.getAbatiDescontoTresPercen().toString()%></td>
							              <td class="textoValor" align="right" width="20%"><%=tituloBean.getAbatiDescontoTresValor().toString().equals("R$ 0,00")?"":tituloBean.getAbatiDescontoTresValor().toString()%></td> 
							            </tr>
							          </table>
							        </td>
				            </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                  </table>
                </s:Outline>
              </td>
            </tr>

            <tr> 
            	<td colspan="4">&nbsp;</td>
            </tr>

            <tr> 
              <td colspan="4">
                <p align="center"> 
                  <s:Button name="Confirmar" 
                  	action="javascript:formSubmit();"
                   	userGroup="<%=usuarioBean.getNomeGrupo()%>" 
                   	internalAction="servico.protesto.comandosportitulo.acoes"/>                  	
                  <s:Button name="Voltar" 
                    action="javascript:formSubmit_Voltar();"/>
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
				trataCampo_acoesValorRecebido(document.frmMain.acoesServicoTitulo.value);
				trataCampo_acoesDespesasCartorarias(document.frmMain.acoesServicoTitulo.value);
				trataCampo_acoesHistorico(document.frmMain.acoesServicoTitulo.value);
      }

			function trataCampo_acoesValorRecebido(acao) {
				if (acao_exige_valorrecebido(acao)) {
					if(document.frmMain.acoesValorRecebido.value.indexOf('~') != -1 )
						document.frmMain.acoesValorRecebido.value="";
			    document.frmMain.acoesValorRecebido.disabled = false;
				} else {
			    document.frmMain.acoesValorRecebido.value="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
			    document.frmMain.acoesValorRecebido.disabled = true;
			  }
      }
			function trataCampo_acoesDespesasCartorarias(acao) {
				if (acao_permite_custascartorarias(acao)) {
					if(document.frmMain.acoesDespesasCartorarias.value.indexOf('~') != -1 )
						document.frmMain.acoesDespesasCartorarias.value="";
			    document.frmMain.acoesDespesasCartorarias.disabled = false;
				} else {
			    document.frmMain.acoesDespesasCartorarias.value="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
			    document.frmMain.acoesDespesasCartorarias.disabled = true;
			  }
      }
			function trataCampo_acoesHistorico(acao) {
				if (acao_permite_historico(acao)) {
			  	document.frmMain.Editar.disabled = false;
				} else {
					document.frmMain.acoesHistorico.value = "";
					document.frmMain.textAreaAcoesHistorico.value = "";
					document.frmMain.Editar.disabled = true;
			  }
      }

			function acao_exige_tarifa(acao) {
				if (acao==1   ||  // Envio ao Cartório
						acao==2   ||  // Sustação de Protesto
						acao==8   ||  // Baixa por Protesto
						acao==9   ||  // Liquidado em Cartório
						acao==10  ||	// Liquidado em Cartório Condicional 
						acao==11  ||	// Baixa Manual - Devolução
						acao==13 ){	  // Solicitação 2a. via Bloqueto
					return true;
				}
				return false;
			}
			function acao_exige_valorrecebido(acao) {
				if (acao==9  ||  // Liquidado em Cartório 
						acao==10 ){  // Liquidado em Cartório Condicional 
					return true;
				}
				return false;
			}			
			function acao_permite_custascartorarias(acao) {
				if (acao==1  ||  // Envio ao Cartório
						acao==2  ||  // Sustação de Protesto
			    <%if (!tituloBean.getPrinciSituacao().equals(new Long(7))) {	// Situacao: Enviado a Cartorio%>
						acao==3  ||  // Estorno Envio/Sustação
					<%}%>
						//EAM - SISOT 171H - Habilitar o campo de Despesa Cartorária para acao ==8
						acao==8  ||  // Baixa por Protesto
					
						acao_exige_custascartorarias(acao)){
					return true;
				}
				return false;
			}			
			function acao_exige_custascartorarias(acao) {
				if (acao==4 || // Débito Custas Cartorárias
				    acao==19 ){ //Debito Custas/Despesas Cartorarias - Protesto Centralizado  
					return true;
				}
				return false;
			}			
			function valida_cobranca_custascartorarias() {
				if (document.frmMain.acoesDespesasCartorarias.disabled == false) {
					if(trim(document.frmMain.acoesDespesasCartorarias.value) != "" &&
						 trim(document.frmMain.acoesDespesasCartorarias.value) != "R$ 0,00" &&
						 trim(document.frmMain.abatiCustasCartorarias.value) != "" &&
						 trim(document.frmMain.abatiCustasCartorarias.value) != "R$ 0,00") {
						return true;
					}
				}
				return false;
			}
			function acao_permite_historico(acao) {
				if (acao==2  ||  //Acao: Sustação de Protesto 
						acao==3  ||  //Acao: Estorno Envio/Sustação 
				    acao==6  ||  //Acao: Suspender Envio ao Cartório 
				    acao==7  ){  //Acao: Incluir Título na Remessa
					return true;
				}
				return false;
			}			

      function formSubmit() {
				if (validaSubmit()) {

					// 155 = 'Deseja realmente executar esta ação?'
					// 156 = 'Deseja realmente executar esta ação?\nAção sujeita a cobrança de tarifa.'
					var msg_conf=(acao_exige_tarifa(document.frmMain.acoesServicoTitulo.value)?"156":"155");

					// 157 = 'Deseja realmente executar esta ação?\nJá existe débito de custas para este título.'
					var msg_conf=(acao_permite_custascartorarias(document.frmMain.acoesServicoTitulo.value)&&
												valida_cobranca_custascartorarias()?"157":msg_conf);

			    if (confirm(conf(msg_conf))) {
			    <%if (tituloBean.getPrinciSituacao().equals(new Long(8))) {	// Situacao: Sustado Cartorio%>
				    	if (document.frmMain.acoesServicoTitulo.value == 3) {		// Acao: ESTORNO ENVIO/SUSTACAO
				    		document.frmMain.acoesServicoTitulo.value = 16;				// Acao: ESTORNO DE SUSTACAO
			    		}
			    <%}%>
				  	document.frmMain.estrategia.value = "<%=ProtestEstrategia.STRATEGY_ACAO%>";
				    document.frmMain.submit();
				  }
				}
      }

			function validaSubmit() {
				if (acao_exige_valorrecebido(document.frmMain.acoesServicoTitulo.value) &&
						document.frmMain.acoesValorRecebido.disabled == false) {
					if (!validaCampoObrigatorio(document.frmMain.acoesValorRecebido, 'Valor Recebido')) {
						return false;
					}
					if (!validaValorZero(document.frmMain.acoesValorRecebido, 'Valor Recebido')) {
						return false;
					}
				}
				if (acao_exige_custascartorarias(document.frmMain.acoesServicoTitulo.value) &&
						document.frmMain.acoesDespesasCartorarias.disabled == false) {
					if (!validaCampoObrigatorio(document.frmMain.acoesDespesasCartorarias, 'Despesas Cartorárias')) {
						return false;
					}
					if (!validaValorZero(document.frmMain.acoesDespesasCartorarias, 'Despesas Cartorárias')) {
						return false;
					}
				}
				return true;
			}

      function formSubmit_Voltar() {
	    	document.frmMain.estrategia.value = "servico.ProtestAcaoIniciar";
        document.frmMain.fluxo.value = "voltar";	        
	      document.frmMain.submit();
      }
      
	    function editaMensagem( campo, colunas, altura, largura, linhas) {
				var resposta = showModalDialog('<%=Paths.getRootForDynamicContent()%>/jump/edita_mensagem.jsp?linhas='+linhas+'&colunas='+colunas, campo.value, "dialogHeight:"+altura+"; dialogWidth:"+largura+"; center: yes; help:no; resizable:yes; scroll:yes; status:no");
				if (resposta != null) {
					campo.value = resposta;
				}
				document.frmMain.acoesHistorico.value = removeBarraEne(campo.value, 50);
	    }

    </script>
  </s:FormStrategy>
</p:Document>
</html>
