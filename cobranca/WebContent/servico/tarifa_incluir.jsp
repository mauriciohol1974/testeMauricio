<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: tarifa_incluir.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Author Cristian Souza - Probank/REDEASP02
*Ultima Atualização: 24/04/2009
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TarifaManualBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TarifaEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.UtilDatas"%>

<%
	TarifaManualBean tarifaBean = (session.getAttribute(TarifaEstrategia.DATA_BEAN)==null?new TarifaManualBean():(TarifaManualBean)session.getAttribute(TarifaEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(TarifaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TarifaEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TarifaEstrategia.STRATEGY_INCLUIR_FINALIZAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TarifaEstrategia.PAGE_TITLE_INCLUIR%>"/>
		
		<input type="hidden" name = "codigoCedente" value="<%=tarifaBean.getCodigoCedente()%>">
		<input type="hidden" name = "justificativa" value="<%=tarifaBean.getJustificativa()%>">
		<input type="hidden" name = "dataHoje" value="<%=UtilDatas.getToday()%>">
		<input type="hidden" name = "tipoTarifa" value="<%=tarifaBean.getTipoTarifa()%>">
		
		<%-- O campo hidden abaixo é criado quando o campo valorTarifa estiver desabilitado para que 
		     valorTarifa seja atribuído ao bean para o passo seguinte em TarifaIncluirFinalizar.
		     Campos disabled não são atribuídos ao bean. --%>
		
		<%if( !(tarifaBean.getValorTarifa().toString().equals("R$ 0,00"))){%>								              
              	  <input type="hidden" name = "valorTarifa" value="<%=tarifaBean.getValorTarifa().toString()%>">
		<%}%>	
		

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=tarifaBean.getCodigoCedenteFormatado()%></td>
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
              <td class="textoTitulo" width="17%">Serviço: </td>
              <td class="textoValor" width="26%"><%=tarifaBean.getTipoTarifa().equals( new Long(1)) ? "TARIFA MANUAL" : "REINSTALAÇÃO DE APLICATIVO PONTA CLIENTE"  %></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Incluir Tarifa Comandada:
                <hr>
              </td>
            </tr>
            
			<tr>
              <td class="textoTitulo" width="17%">Valor da Tarifa: </td>
              <td class="textoValor"  width="26%">
              
              		<%-- O campo hidden descrito no início da página será criado quando o campo valorTarifa estiver desabilitado, para que 
		     	     valorTarifa seja atribuído ao bean para o passo seguinte em TarifaIncluirFinalizar.
		     	     Campos disabled não são atribuídos ao bean. --%>
		     
		 	<%if(tarifaBean.getValorTarifa().toString().equals("R$ 0,00")){%>								              
              			<p:InputCurrency name="valorTarifa" maxlength="15" size="27" 
                		CLASS="inputtext"
                		value='<%=tarifaBean.getValorTarifa().toString().equals("R$ 0,00")?"":tarifaBean.getValorTarifa().toString()%>' 
                		onFocus="javascript: prevFocus(this);"
						onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataDebito);"/> 
				
			<%}else {%>								              
              			<p:InputCurrency name="valorTarifa" maxlength="15" size="27" 
                		CLASS="inputtext"
                		value='<%=tarifaBean.getValorTarifa().toString().equals("R$ 0,00")?"":tarifaBean.getValorTarifa().toString()%>' 
                		onFocus="javascript: prevFocus(this);"
                		disabled='<%=tarifaBean.getValorTarifa().toString().equals("R$ 0,00")?"false":"true"%>' 
						onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataDebito);"/> 
            <%}%>       
			
              </td>
              <td class="textoTitulo" width="17%">Data Débito da Tarifa: </td>
              <td class="textoValor" width="26%"> 
								<p:InputDate name="dataDebito"
			          	CLASS="inputtext" 
 				          value ='<%=tarifaBean.getDataDebitoFormatada()%>'
			            onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Editar);"/>
              </td>
			</tr>
            <tr>
              <td class="textoTitulo" width="17%">Justificativa: </td>
							<td class="textoValor" width="26%" colspan="3">
              	<p align="justify">
		            	<textarea name="textAreaJustificativa" cols="50" rows="2" class="textoValor" readonly><%=tarifaBean.getJustificativaFormatada()%></textarea>
		              <s:Button name="Editar" action="javascript: editaMensagem(document.frmMain.textAreaJustificativa, 50, 14, 23, 2);"/>
				        </p>
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
				setFirstFieldFocus();
				document.frmMain.textAreaJustificativa.value = inserebarraEne(document.frmMain.justificativa.value,50);
			}
	    function formSubmit() {
        if (validaSubmit()) {
	    		if (confirm(conf("100", "Lançamento de Tarifa Comandada"))) {
		        
		        document.frmMain.submit();
		      }
        }
	    }
			function validaSubmit() {
			document.frmMain.justificativa.value = removeBarraEne(document.frmMain.textAreaJustificativa.value, 50);
		    
		    <%-- Insere o script abaixo de validação para valorTarifa quando este não estiver desabilitado --%>
		    
		    <%if((tarifaBean.getValorTarifa().toString().equals("R$ 0,00"))){%>								              
              	if(!validaCampoMoneyObrigatorio(document.frmMain.valorTarifa, 'Valor Tarifa')){
				  return false;
		    	}
		    	if(!validaValor(document.frmMain.valorTarifa, 'R$ 0,10')){
		    		return false;
		    	}
		    
		    <%}%>
		    
		    if(!validaCampoObrigatorio(document.frmMain.dataDebito, 'Data de Débito')){
				  return false;
		    }
		    
		    if (trim(document.frmMain.dataDebito.value) != "" && 
		        !validaData(document.frmMain.dataDebito)) {
		    	msg("014", "Data Debito");
		    	return false;
		    }
		    if(trim(document.frmMain.dataDebito.value) != "" && validaData(document.frmMain.dataDebito)){
		    	if(!compararDatas(document.frmMain.dataDebito.value,document.frmMain.dataHoje.value,">=")){
		    		msg("038", "Data Débito da Tarifa", document.frmMain.dataHoje.value)
		    		return false;
		    	}
		    	if(!compararDatas(document.frmMain.dataDebito.value,'31/12/2099',"<=")){
		    		msg("040", "Data Débito da Tarifa", '31/12/2099')
		    		return false;
		    	}
		    }
		    
		    if(!validaCampoObrigatorio(document.frmMain.justificativa, 'Justificativa')){
				  return false;
		    }
		    return true;
		  }
	    function formSubmit_Voltar() {
    		if (confirm(conf("103"))) {
           document.frmMain.estrategia.value = "<%=TarifaEstrategia.STRATEGY_INCLUIR_FILTRO%>";
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
        }
      }
	    function editaMensagem( campo, colunas, altura, largura, linhas) {
				var resposta = showModalDialog('<%=Paths.getRootForDynamicContent()%>/jump/edita_mensagem.jsp?linhas='+linhas+'&colunas='+colunas, campo.value, "dialogHeight:"+altura+"; dialogWidth:"+largura+"; center: yes; help:no; resizable:yes; scroll:yes; status:no");
				if (resposta != null) {
					campo.value = resposta;
				}
	    }
    	function validaValor(objCampo, valorMinimo){
    			objTemp = new Object('value');
					objTemp.value= valorMinimo;
					if (!comparaValor(objCampo, objTemp, '<')){
						return true;
					}
					else{
						msg('038','Valor Tarifa', valorMinimo);;
					}
    	}
    
    </script>
  </s:FormStrategy>
</p:Document>
</html>