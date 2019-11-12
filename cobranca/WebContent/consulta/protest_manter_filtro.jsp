<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: salcob_manter_filtro.jsp - Java Server Pages
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 09/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ProtestoTituloBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ProtestoTituloEstrategia"%>


<%
	ProtestoTituloBean protestoTituloBean = (session.getAttribute(ProtestoTituloEstrategia.FILTRO_BEAN)==null?new ProtestoTituloBean():(ProtestoTituloBean)session.getAttribute(ProtestoTituloEstrategia.FILTRO_BEAN));	
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=ProtestoTituloEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='<%=ProtestoTituloEstrategia.PAGE_TITLE_FILTRO%>'/>
    
 		<input type="hidden" name ="tipoConsulta" >
 		<input type="hidden" name ="selecaoRadio" >
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">PV Cobrador: </td>
              <td width="26%"> 
              	<p:InputNumerico CLASS="inputtext" name="codigoUnidadePv" value='<%=protestoTituloBean.getCodigoUnidadePv().equals(new Long(0))?"":protestoTituloBean.getCodigoUnidadePv().toString()%>' size="6" maxlength="4"
	              	  onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.rad);"/>                 
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr>
              <td colspan="4">
                <div id="Protesto" class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="2">&nbsp;</td>
                    </tr>
				            <tr> 
				              <td class="textoTitulo" width="1%"><input type="radio" name="rad" value="<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_A_SEREM_ENVIADOS%>" onclick="javascript: configuraCampoDependente()"></td>
				              <td class="textoTitulo" width="40%">Títulos a serem Enviados ao Cartório</td>
										</tr>
				            <tr> 
				              <td class="textoTitulo" width="1%"><input type="radio" name="rad" value="<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIADOS%>" onclick="javascript: configuraCampoDependente()"></td>
				              <td class="textoTitulo" width="40%">Títulos Enviados ao Cartório Nesta Data</td>
										</tr>
				            <tr> 
				              <td class="textoTitulo" width="1%"><input type="radio" name="rad" value="<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIO_SUSPENSO%>" onclick="javascript: configuraCampoDependente()"></td>
				              <td class="textoTitulo" width="40%">Títulos com Envio Suspenso</td>
										</tr>
				            <tr> 
				              <td class="textoTitulo" width="1%"><input type="radio" name="rad" value="<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIADOS_DIA%>" onclick="javascript: configuraCampoDependente()"></td>
				              <td class="textoTitulo" width="40%">
				              	Títulos Enviados com mais de
			        				  <p:InputNumerico name="diaProtesto" maxlength="3" size="3"
			                		CLASS="inputtext" 
 				               		value ='<%=protestoTituloBean.getDiaProtesto().equals(new Long(0))?"0":protestoTituloBean.getDiaProtesto().toString()%>'			                									                						
 				               		onFocus="javascript: prevFocus(this)"
													onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> dias
				             	</td>
										</tr>
                    <tr> 
                      <td colspan="2">&nbsp;</td>
                    </tr>
                  </table>
                </div>
							</td>
						</tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">
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
				document.frmMain.rad[<%=protestoTituloBean.getSelecaoRadio()%>].checked = true;
				configuraCampoDependente();
      }
      
		function formSubmit() {
			if(validaSubmit()){
		  	document.frmMain.submit();
			}
  	}  
      
		function validaSubmit() {
				if(!validaCampoObrigatorio(document.frmMain.codigoUnidadePv, "PV Cobrador")) {
					return false;
			  }
	    	if(!validaRadioButton(document.frmMain.rad, '')){
			  	return false;
  	  	}
	    	return true;
		}
		function configuraCampoDependente(){
			if(document.frmMain.rad[<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_A_SEREM_ENVIADOS%>].checked){
				document.frmMain.diaProtesto.disabled=true;
				document.frmMain.diaProtesto.value='';
				document.frmMain.tipoConsulta.value= '1';
				document.frmMain.selecaoRadio.value= '<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_A_SEREM_ENVIADOS%>';				
			}
			else if(document.frmMain.rad[<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIADOS%>].checked){
				document.frmMain.diaProtesto.disabled=true;
				document.frmMain.diaProtesto.value='';
				document.frmMain.tipoConsulta.value= '2';
				document.frmMain.selecaoRadio.value= '<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIADOS%>';				
			}		
			else if(document.frmMain.rad[<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIO_SUSPENSO%>].checked){
				document.frmMain.diaProtesto.disabled=true;
				document.frmMain.diaProtesto.value='';
				document.frmMain.tipoConsulta.value= '3';
				document.frmMain.selecaoRadio.value= '<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIO_SUSPENSO%>';				
			}	
			else if(document.frmMain.rad[<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIADOS_DIA%>].checked){
				document.frmMain.diaProtesto.disabled=false;
				document.frmMain.tipoConsulta.value= '4';
				document.frmMain.selecaoRadio.value= '<%=ProtestoTituloEstrategia.SELECAO_RADIO_TIT_ENVIADOS_DIA%>';				
				document.frmMain.diaProtesto.focus();
			}			
		}
    </script>
  </s:FormStrategy>
</p:Document>
</html>
