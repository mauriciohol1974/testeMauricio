<%
/***********************************************
*Projeto CAIXA - SIGCB
*Autor: Maur�cio Assis de Holanda
*Data cria��o: Abril / 2013
************************************************/
%>



<%@page import="java.util.Date"%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.LiquidacoesSTRBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ConsultaLiqStrManterEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>


<%
LiquidacoesSTRBean liqSTRBean = (session.getAttribute(ConsultaLiqStrManterEstrategia.FILTRO_BEAN)==null
 	                                        ? new LiquidacoesSTRBean()
 	                                        : (LiquidacoesSTRBean)session.getAttribute(ConsultaLiqStrManterEstrategia.FILTRO_BEAN));


liqSTRBean.setDataPesq(new Date());
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="consulta.ConsultaLiqStrManterFiltroRecebidas" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Consultar Liquida��es via STR Recebidas >> Filtro"/>

		<input type="hidden" name="tipoOpcaoDescricao">
		

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
			<tr>
			  <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="5%">Data do Recebimento Inicial:</td>
              <td class="textoValor" width="26%"><p:InputDate name="dataPesq"
                    CLASS="inputtext"
                    onFocus="javascript: prevFocus(this);"
                    onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataPesqFinal);"
                     value='<%=liqSTRBean.getDataPesq()==null ?"" : Formatador.formatarData(liqSTRBean.getDataPesq())%>'/>
					</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              
			</tr>

			<tr>
			  <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="5%">Data do Recebimento Final:</td>
              <td class="textoValor" width="26%"><p:InputDate name="dataPesqFinal"
                    CLASS="inputtext"
                    onFocus="javascript: prevFocus(this);"
                    onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.cedenteOrigem);"   />
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
              <td class="textoTitulo" width="17%">Banco de Origem: </td>
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
              <td class="textoTitulo" width="17%">Ag�ncia de Origem: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="agenciaOrigem"  disabled="true"  size="4" maxlength="4" value='' onFocus="javascript: prevFocus(this);"/>
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
			    document.frmMain.ISPBOrigem.value="";
			    document.frmMain.agenciaOrigem.value="";
			    document.frmMain.agenciaOrigem.disabled = true;
				
			} else if(document.frmMain.radioTpConsulta[1].checked){
				
			    document.frmMain.cedenteOrigem.disabled = true;
			    document.frmMain.cedenteOrigem.value="";
			    document.frmMain.bancoOrigem.disabled = false;
			    document.frmMain.bancoOrigem.value = "";
			    document.frmMain.ISPBOrigem.disabled = true;
			    document.frmMain.ISPBOrigem.value="";			    
			    document.frmMain.agenciaOrigem.value="";
			    document.frmMain.agenciaOrigem.disabled = false;
				
			}else if(document.frmMain.radioTpConsulta[2].checked){
				
			    document.frmMain.cedenteOrigem.disabled = true;
			    document.frmMain.cedenteOrigem.value="";
			    document.frmMain.bancoOrigem.disabled = true;
			    document.frmMain.bancoOrigem.value = "";
			    document.frmMain.ISPBOrigem.disabled = false;
			    document.frmMain.ISPBOrigem.value="";			    
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
