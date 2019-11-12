<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: girocai_manter_filtro.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 19/10/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.GiroCaixaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GiroCaixaEstrategia"%>


<%
	GiroCaixaBean giroCaixaBean = (session.getAttribute(GiroCaixaEstrategia.FILTRO_BEAN)==null?new GiroCaixaBean():(GiroCaixaBean)session.getAttribute(GiroCaixaEstrategia.FILTRO_BEAN));	
	giroCaixaBean.setCodigoCedente(session.getAttribute(GiroCaixaEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(GiroCaixaEstrategia.CEDENTE_ATUAL));
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=GiroCaixaEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='<%=GiroCaixaEstrategia.PAGE_TITLE_FILTRO%>'/>

		<input type="hidden" name = "codigoUnidadeEN">
		<input type="hidden" name = "codigoUnidadePV">
		<input type="hidden" name ="cpfCnpj" >
		<input type="hidden" name ="selecaoRadio" >
		<input type="hidden" name ="cedentePadrao" value = '<%=giroCaixaBean.getCodigoCedente().equals(new Long(0))?"":giroCaixaBean.getCodigoCedente().toString()%>'>		
		<input type="hidden" name ="tipoPessoa" >
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rad" value="<%=GiroCaixaEstrategia.SELECAO_RADIO_CEDENTE%>" onclick="javascript: configuraCampoDependente()">
              </td>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" size="7" maxlength="7"	name="codigoCedente" 
 								 value='<%=giroCaixaBean.getCodigoCedente().equals(new Long(0))?"":giroCaixaBean.getCodigoCedente().toString()%>'
	  	         	  onFocus="javascript: prevFocus(this);"                		
  	              onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
							</td>
            	<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>
						
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rad" value="<%=GiroCaixaEstrategia.SELECAO_RADIO_CPF_CNPJ%>" onclick="javascript: configuraCampoDependente()">
              </td>
              <td class="textoTitulo" width="17%">CNPJ: </td>
              <td class="textoValor" width="26%">
	             	<s:ComboTipoPessoa name="tipoPessoaCombo" selectedValue='2' disabled = 'true'/>
                                			 	  	   
             	  <p:InputCpfCnpj name="cpfCnpjInput" CLASS="inputtext"
				        	value='<%=giroCaixaBean.getCpfCnpjFormatado()%>'
				          onBlur="javascript:formataCNPJ(this);" 
				          onFocus="javascript:unFormataCNPJ(this);prevFocus(this);"
				          onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
              </td>
            	<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rad" value="<%=GiroCaixaEstrategia.SELECAO_RADIO_UNIDADE%>" onclick="javascript: configuraCampoDependente()">
              </td>
              <td class="textoTitulo" width="17%">Unidade: </td>

              <td class="textoValor" width="26%">
	              <s:ComboENPV name="selecaoEnPV" selectedValue='<%=giroCaixaBean.getSelecaoEnPV().equals(new Long(0))?"2":giroCaixaBean.getSelecaoEnPV().toString()%>'/>
              	<p:InputNumerico CLASS="inputtext" name="codigoUnidade" value='<%=giroCaixaBean.getEnPv().equals(new Long(0))?"":giroCaixaBean.getEnPv().toString()%>' size="6" maxlength="4" 
              	  onFocus="javascript: prevFocus(this);"                		
              	  onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
							</td>

            	<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>

            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="5">
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
				document.frmMain.rad[<%=giroCaixaBean.getSelecaoRadio()%>].checked = true;
				configuraCampoDependente();
      }
      
		function formSubmit() {
			if(validaSubmit()){
				document.frmMain.cpfCnpj.value=document.frmMain.cpfCnpjInput.value;
				unFormataCNPJ(document.frmMain.cpfCnpj) 
		  	document.frmMain.submit();
			}
  	}  
      
		function validaSubmit() {
	    if(!validaRadioButton(document.frmMain.rad, '')){
			  return false;
  	  }
			if(document.frmMain.rad[0].checked) {
				if(!validaCampoObrigatorio(document.frmMain.codigoCedente, "Cedente")) {
					return false;
			  }
			}  
			if(document.frmMain.rad[1].checked) {			    
		    if(!validaCampoObrigatorio(document.frmMain.cpfCnpjInput, "CNPJ")) {
				  return false;
		    }
		    if(!validaDVCNPJ(document.frmMain.cpfCnpjInput)){
					msg('008','CNPJ');
			   	return false;
				}
			}
			if(document.frmMain.rad[2].checked) {			    
		    if(!validaCampoObrigatorio(document.frmMain.codigoUnidade, "Unidade")) {
				  return false;
		    }
				if(document.frmMain.selecaoEnPV.value == <%=GiroCaixaEstrategia.SELECAO_EN%>){
			    document.frmMain.codigoUnidadeEN.value = document.frmMain.codigoUnidade.value
			  }
				if(document.frmMain.selecaoEnPV.value == <%=GiroCaixaEstrategia.SELECAO_PV%>){
			    document.frmMain.codigoUnidadePV.value = document.frmMain.codigoUnidade.value
			  }			  
		  }
			return true;
		}
		
		function configuraCampoDependente(){
			if(document.frmMain.rad[<%=GiroCaixaEstrategia.SELECAO_RADIO_CEDENTE%>].checked){
				document.frmMain.codigoCedente.disabled=false;
				document.frmMain.tipoPessoa.value = '';
				document.frmMain.cpfCnpjInput.disabled=true;
				document.frmMain.cpfCnpjInput.value='';
				document.frmMain.selecaoEnPV.disabled=true;
				document.frmMain.codigoUnidade.disabled=true;
				document.frmMain.codigoUnidade.value='';
				document.frmMain.selecaoRadio.value=<%=GiroCaixaEstrategia.SELECAO_RADIO_CEDENTE%>;
				if(document.frmMain.codigoCedente.value == ''){
					document.frmMain.codigoCedente.value = document.frmMain.cedentePadrao.value;
				}
				document.frmMain.codigoCedente.focus();
			}
  		else if(document.frmMain.rad[<%=GiroCaixaEstrategia.SELECAO_RADIO_CPF_CNPJ%>].checked){
				document.frmMain.codigoCedente.disabled=true;
				document.frmMain.codigoCedente.value='';
				document.frmMain.tipoPessoa.value = document.frmMain.tipoPessoaCombo.value;
				document.frmMain.cpfCnpjInput.disabled=false;
				document.frmMain.selecaoEnPV.disabled=true;
				document.frmMain.codigoUnidade.disabled=true;
				document.frmMain.codigoUnidade.value='';	
				document.frmMain.selecaoRadio.value=<%=GiroCaixaEstrategia.SELECAO_RADIO_CPF_CNPJ%>;				
				document.frmMain.cpfCnpjInput.focus();
			}
			else if(document.frmMain.rad[<%=GiroCaixaEstrategia.SELECAO_RADIO_UNIDADE%>].checked){
				document.frmMain.codigoCedente.disabled=true;
				document.frmMain.codigoCedente.value='';
				document.frmMain.tipoPessoa.value = '';
				document.frmMain.cpfCnpjInput.disabled=true;
				document.frmMain.cpfCnpjInput.value='';
				document.frmMain.selecaoEnPV.disabled=false;
				document.frmMain.codigoUnidade.disabled=false;
				document.frmMain.selecaoRadio.value=<%=GiroCaixaEstrategia.SELECAO_RADIO_UNIDADE%>;						
				document.frmMain.codigoUnidade.focus();
			}		
			else{
				document.frmMain.codigoCedente.disabled=true;
				document.frmMain.codigoCedente.value='';
				document.frmMain.cpfCnpjInput.disabled=true;
				document.frmMain.cpfCnpjInput.value='';
				document.frmMain.selecaoEnPV.disabled=true;
				document.frmMain.selecaoEnPV.value='2';
				document.frmMain.codigoUnidade.disabled=true;
				document.frmMain.codigoUnidade.value='';	
			}		
			}
    </script>
  </s:FormStrategy>
</p:Document>
</html>
