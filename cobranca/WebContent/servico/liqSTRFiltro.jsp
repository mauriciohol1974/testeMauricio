<%
/***********************************************
*Projeto CAIXA - SIGCB
*Autor: Maurício Assis de Holanda
*Data criação: Abril / 2013
************************************************/
%>


<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.LiqRejeManterEstrategia"%>

<%
 	LiquidacoesRejeitadaBean liqRejeBean = (session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN)==null
 	                                        ? new LiquidacoesRejeitadaBean()
 	                                        : (LiquidacoesRejeitadaBean)session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN));
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="servico.LiqStrManterFiltro" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Liquidações via STR >> Filtro"/>

		<input type="hidden" name="tipoOpcaoDescricao">
		

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
			<tr>
			  <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="5%">Opção: </td>
              <td class="textoValor" width="26%">
               <SELECT NAME='opcao' ONBLUR='' ONCHANGE='' ONFOCUS='' >
               <option value='1'>Recomando de Rejeitadas Pendentes</option>
               <option value='2'>Cancela Recomando de Rejeitadas Pendentes</option>
               <option value='3'>Devolução de Acatadas Pendentes</option>
               <option value='4'>Cancela Devolução de Acatadas Pendentes</option>
               <option value='5'>Bloqueio de Devoluções Pendentes</option>
               <option value='6'>Cancela Bloqueio de Devoluções Pendentes</option>
               </SELECT>
               
              </td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              
			</tr>

			<tr>
			</tr>
			
			<tr>
			</tr>

			<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="radioTpConsulta" onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.cedenteOrigem);">
              </td>						
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="cedenteOrigem" disabled="true" size="8" maxlength="7" value='' onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.bancoOrigem);"/>
              </td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
			</tr>
						
						
			<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="radioTpConsulta" onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.bancoOrigem);">
              </td>						
              <td class="textoTitulo" width="17%">Banco Origem: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="bancoOrigem"  disabled="true" size="4" maxlength="3" value='' onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.agenciaOrigem);"/>
              </td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
			</tr>
			
			<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="radioTpConsulta" onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.ISPBOrigem);">
              </td>						
              <td class="textoTitulo" width="17%">ISPB Origem: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="ISPBOrigem"  disabled="true" size="10" maxlength="8" value='' onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.agenciaOrigem);"/>
              </td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
			</tr>
			
			<tr>
			</tr>
						
			<tr>
			<td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Agência de Origem: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="agenciaOrigem" size="4" maxlength="4" value='' onFocus="javascript: prevFocus(this);"/>
              </td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoValor" width="26%">&nbsp;</td>
			</tr>				


            <tr>
              <td colspan="6">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="6">
                <p align="center">
                	<s:Button name="Ok" action="javascript:formSubmit();"/>
                </p>
              </td>
            </tr>
          </table>
        </TD>
      </tr>
    </table>
    <script>
			function inicia() {
				setFirstFieldFocus();
			}
			
	    function formSubmit() {
	        
	          	document.frmMain.submit();
	        
		}
			
		function habilitaDigitacao(){
			if (document.frmMain.radioTpConsulta[0].checked){
			    

			    document.frmMain.cedenteOrigem.disabled = false;
			    document.frmMain.cedenteOrigem.value="";
			    document.frmMain.bancoOrigem.disabled = true;
			    document.frmMain.bancoOrigem.value = "";
			    document.frmMain.ISPBOrigem.disabled = true;
			    document.frmMain.ISPBOrigem.value = "";
			    document.frmMain.agenciaOrigem.value="";
			    document.frmMain.agenciaOrigem.disabled = true;

			} else if(document.frmMain.radioTpConsulta[1].checked){
				
			    document.frmMain.cedenteOrigem.disabled = true;
			    document.frmMain.cedenteOrigem.value="";
			    document.frmMain.bancoOrigem.disabled = false;
			    document.frmMain.bancoOrigem.value = "";
			    document.frmMain.ISPBOrigem.disabled = true;
			    document.frmMain.ISPBOrigem.value = "";
			    document.frmMain.agenciaOrigem.value="";
			    document.frmMain.agenciaOrigem.disabled = false;
			    
				
			}else if(document.frmMain.radioTpConsulta[2].checked){
				
			    document.frmMain.cedenteOrigem.disabled = true;
			    document.frmMain.cedenteOrigem.value="";
			    document.frmMain.bancoOrigem.disabled = true;
			    document.frmMain.bancoOrigem.value = "";
			    document.frmMain.ISPBOrigem.disabled = false;
			    document.frmMain.ISPBOrigem.value = "";
			    document.frmMain.agenciaOrigem.value="";
			    document.frmMain.agenciaOrigem.disabled = false;
			    
				
			}
							
			}
		  
		  function converteDadosSaida() {
		  	//document.frmMain.dataInicial.value = 
		  	//		substituiBarraPorPonto(document.frmMain.dataInicial.value);
		  	document.frmMain.tipoOpcaoDescricao.value =
		  			getDescricaoSelect(document.frmMain.tipoOpcao);
				document.frmMain.meioLiquidacaoDescricao.value =
		  			getDescricaoSelect(document.frmMain.meioLiquidacao);
		  }
    </script>
	</s:FormStrategy>
</p:Document>
</html>
