<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: contab_manter_filtro.jsp - Java Server Pages
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 17/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ContabilBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ContabEstrategia"%>


<%
	ContabilBean contabilBean = (session.getAttribute(ContabEstrategia.FILTRO_BEAN)==null?new ContabilBean():(ContabilBean)session.getAttribute(ContabEstrategia.FILTRO_BEAN));	
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=ContabEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='<%=ContabEstrategia.PAGE_TITLE_FILTRO%>'/>

		<input type="hidden" name ="selecaoRadio" >
		<input type="hidden" name ="tipoConsulta" >
		<input type="hidden" name ="navegacao" >
				
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rad" value="<%=ContabEstrategia.SELECAO_RADIO_UNIDADE%>" onclick="javascript: configuraCampoDependente()">
              </td>
              <td class="textoTitulo" width="17%">Unidade: </td>
              <td class="textoValor" width="26%">
	              <s:ComboPvRecoc name="selecaoRecocPv" selectedValue="<%=contabilBean.getSelecaoRecocPv().toString()%>"/>
              	<p:InputNumerico CLASS="inputtext" size="6" maxlength="4"	name="codigoUnidade" 
 								 value='<%=contabilBean.getCodigoUnidade().equals(new Long(0))?"":contabilBean.getCodigoUnidade().toString()%>'
                 onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.data);"/>
							</td>
            	<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>
						
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rad" value="<%=ContabEstrategia.SELECAO_RADIO_CAIXA%>" onclick="javascript: configuraCampoDependente()">
              </td>
              <td class="textoTitulo" width="17%">Caixa </td>
            	<td width="26%">&nbsp;</td>
            	<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>
            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
						<tr>
              <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Data: </td>
              <td class="textoValor" width="26%">
   				        <p:InputDate name="data" 
           						value ='<%=contabilBean.getDataFormatada()%>' CLASS="inputtext"
           						onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.selecaoConsulta);"/> 
							</td>
							<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>		
            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
              <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Consulta: </td>
              <td class="textoValor" width="26%">
	              <s:ComboConsultaContabil name="selecaoConsulta" selectedValue="<%=contabilBean.getSelecaoConsulta().toString()%>"/>
							</td>
            	<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
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
				document.frmMain.rad[<%=contabilBean.getSelecaoRadio()%>].checked = true;
				configuraCampoDependente();
      }
      
		function formSubmit() {
			if(validaSubmit()){
				if(document.frmMain.selecaoRecocPv.value == 1 && document.frmMain.rad[<%=ContabEstrategia.SELECAO_RADIO_UNIDADE%>].checked){
					document.frmMain.tipoConsulta.value = <%=ContabEstrategia.TIPO_CONSULTA_PV%>; 
					document.frmMain.navegacao.value = <%=ContabEstrategia.NAVEGACAO_PV%>; 
				}
				else if(document.frmMain.selecaoRecocPv.value == 2 && document.frmMain.rad[<%=ContabEstrategia.SELECAO_RADIO_UNIDADE%>].checked){
					document.frmMain.tipoConsulta.value = <%=ContabEstrategia.TIPO_CONSULTA_REC%>; //RSRET
					document.frmMain.navegacao.value = <%=ContabEstrategia.NAVEGACAO_REC%>; 
				}
				else if(document.frmMain.rad[<%=ContabEstrategia.SELECAO_RADIO_CAIXA%>].checked){
					document.frmMain.tipoConsulta.value = <%=ContabEstrategia.TIPO_CONSULTA_CAIXA_REC%>; //Caixa
					document.frmMain.navegacao.value = <%=ContabEstrategia.NAVEGACAO_CAIXA_REC%>; 					
				}
		  	document.frmMain.submit();
			}
  	}  
      
		function validaSubmit() {
	    if(!validaRadioButton(document.frmMain.rad, '')){
			  return false;
  	  }
			if(document.frmMain.rad[0].checked) {
				if(!validaCampoObrigatorio(document.frmMain.codigoUnidade, "Unidade")) {
					return false;
			  }
			}  
			if(!validaCampoObrigatorio(document.frmMain.data, "Data")) {
				return false;
			}
			if(!validaComboObrigatorio(document.frmMain.selecaoConsulta, "Consulta",'0')) {
				return false;
			}
			
			if(document.frmMain.data.value != ''){
		  	if(!validaData(document.frmMain.data)) {
					msg('014','Data');
				  	return false;
				}
			}
			return true;
		}
		
		function configuraCampoDependente(){
			if(document.frmMain.rad[<%=ContabEstrategia.SELECAO_RADIO_UNIDADE%>].checked){
				document.frmMain.selecaoRecocPv.disabled=false;
				document.frmMain.codigoUnidade.disabled=false;
				document.frmMain.selecaoRadio.value=<%=ContabEstrategia.SELECAO_RADIO_UNIDADE%>;
				document.frmMain.codigoUnidade.focus();
			}
			else if(document.frmMain.rad[<%=ContabEstrategia.SELECAO_RADIO_CAIXA%>].checked){
				document.frmMain.selecaoRecocPv.disabled=true;
				document.frmMain.selecaoRecocPv.value='1';
				document.frmMain.codigoUnidade.disabled=true;
				document.frmMain.codigoUnidade.value='';
				document.frmMain.selecaoRadio.value=<%=ContabEstrategia.SELECAO_RADIO_CAIXA%>;
				document.frmMain.data.focus();			
			}		
		}
    </script>
  </s:FormStrategy>
</p:Document>
</html>
