<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: hisced_manter_filtro.jsp - Java Server Pages
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 08/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.HistoricoCedenteBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.HistoricoCedenteEstrategia"%>


<%
	HistoricoCedenteBean historicoCedenteBean = (session.getAttribute(HistoricoCedenteEstrategia.FILTRO_BEAN)==null?new HistoricoCedenteBean():(HistoricoCedenteBean)session.getAttribute(HistoricoCedenteEstrategia.FILTRO_BEAN));	
	historicoCedenteBean.setCodigoCedente(session.getAttribute(HistoricoCedenteEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(HistoricoCedenteEstrategia.CEDENTE_ATUAL));
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=HistoricoCedenteEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='<%=HistoricoCedenteEstrategia.PAGE_TITLE_FILTRO%>'/>

		<input type="hidden" name ="selecaoRadio" >
		<input type="hidden" name ="cedentePadrao" value = '<%=historicoCedenteBean.getCodigoCedente().equals(new Long(0))?"":historicoCedenteBean.getCodigoCedente().toString()%>'>		
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rad" value="<%=HistoricoCedenteEstrategia.SELECAO_RADIO_CEDENTE%>" onclick="javascript: configuraCampoDependente()">
              </td>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" size="7" maxlength="7"	name="codigoCedente" 
 								 value='<%=historicoCedenteBean.getCodigoCedente().equals(new Long(0))?"":historicoCedenteBean.getCodigoCedente().toString()%>'
	             	  onFocus="javascript: prevFocus(this);"                		                 
                  onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataInicial);"/>
							</td>
							<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Data de: </td>
              <td class="textoValor" width="26%">
   				        <p:InputDate name="dataInicial" 
           						value ='<%=historicoCedenteBean.getDataInicialFormatada()%>' CLASS="inputtext"
           						onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataFinal);"/> 
							</td>
							<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>						
						<tr>
              <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Data até: </td>
              <td class="textoValor" width="26%">
   				        <p:InputDate name="dataFinal" 
           						value ='<%=historicoCedenteBean.getDataFinalFormatada()%>' CLASS="inputtext"
           						onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.guia);"/> 
							</td>
							<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>		
            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rad" value="<%=HistoricoCedenteEstrategia.SELECAO_RADIO_UNIDADE%>" onclick="javascript: configuraCampoDependente()">
              </td>
              <td class="textoTitulo" width="17%">Unidade PV: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="codigoUnidadePv" value='<%=historicoCedenteBean.getCodigoUnidadePv().equals(new Long(0))?"":historicoCedenteBean.getCodigoUnidadePv().toString()%>' size="6" maxlength="4" 
               	  onFocus="javascript: prevFocus(this);"                		
              	  onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataMovimento);"/>
							</td>
							<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Data de Movimento: </td>
              <td class="textoValor" width="26%">
   				        <p:InputDate name="dataMovimento" 
           						value ='<%=historicoCedenteBean.getDataMovimentoFormatada()%>' CLASS="inputtext"
           						onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.guia);"/> 
							</td>
							<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>		
            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
						<tr>
              <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Guia: </td>
              <td class="textoValor" width="26%">
   				        <s:ComboGuia name="guia"  selectedValue ='<%=historicoCedenteBean.getGuia().equals(new Long(0))?"9":historicoCedenteBean.getGuia().toString()%>' CLASS="inputtext"/> 
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
				document.frmMain.rad[<%=historicoCedenteBean.getSelecaoRadio()%>].checked = true;
				configuraCampoDependente();
      }
      
		function formSubmit() {
			if(validaSubmit()){
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
				if(!validaCampoObrigatorio(document.frmMain.dataInicial, "Data de")) {
					return false;
			  }
				if(!validaCampoObrigatorio(document.frmMain.dataFinal, "Data até")) {
					return false;
			  }			  
			  if(document.frmMain.dataInicial.value != ''){
		       if(!validaData(document.frmMain.dataInicial)) {
				    	msg('014','Data de');
				    	return false;
				   }
			  }
			  if(document.frmMain.dataFinal.value != ''){
		       if(!validaData(document.frmMain.dataFinal)) {
				    	msg('014','Data até');
				    	return false;
				   }
			  }
			  if(document.frmMain.dataInicial.value != '' && document.frmMain.dataFinal.value != ''){
			  	if(!compararDatas(document.frmMain.dataInicial.value,document.frmMain.dataFinal.value,"<=")){
		    		msg("040", "Data de", "Data até");
		    		return false;
		    	}
			  }
			}  
			if(document.frmMain.rad[1].checked) {			    
		    if(!validaCampoObrigatorio(document.frmMain.codigoUnidadePv, "Unidade PV")) {
				  return false;
		    }
				if(!validaCampoObrigatorio(document.frmMain.dataMovimento, "Data de Movimento")) {
					return false;
			  }
			  if(document.frmMain.dataMovimento.value != ''){
		       if(!validaData(document.frmMain.dataMovimento)) {
				    	msg('014','Data de Movimento');
				    	return false;
				   }
				}
		  }
		  if(!validaComboObrigatorio(document.frmMain.guia, "Guia")) {
			  return false;
		  }
			return true;
		}
		
		function configuraCampoDependente(){
			if(document.frmMain.rad[<%=HistoricoCedenteEstrategia.SELECAO_RADIO_CEDENTE%>].checked){
				document.frmMain.codigoCedente.disabled=false;
				document.frmMain.dataInicial.disabled=false;
				document.frmMain.dataFinal.disabled=false;				
				document.frmMain.codigoUnidadePv.disabled=true;
				document.frmMain.codigoUnidadePv.value='';
				document.frmMain.dataMovimento.disabled=true;
				document.frmMain.dataMovimento.value='';
				document.frmMain.selecaoRadio.value=<%=HistoricoCedenteEstrategia.SELECAO_RADIO_CEDENTE%>;
				//document.frmMain.estrategia.value='<%=HistoricoCedenteEstrategia.STRATEGY_CONSULTAR%>';
				if(document.frmMain.codigoCedente.value == ''){
					document.frmMain.codigoCedente.value = document.frmMain.cedentePadrao.value;
				}
				document.frmMain.codigoCedente.focus();
			}
			else if(document.frmMain.rad[<%=HistoricoCedenteEstrategia.SELECAO_RADIO_UNIDADE%>].checked){
				document.frmMain.codigoCedente.disabled=true;
				document.frmMain.codigoCedente.value='';
				document.frmMain.dataInicial.disabled=true;
				document.frmMain.dataInicial.value='';
				document.frmMain.dataFinal.disabled=true;				
				document.frmMain.dataFinal.value='';
				document.frmMain.codigoUnidadePv.disabled=false;
				document.frmMain.dataMovimento.disabled=false;
				document.frmMain.selecaoRadio.value=<%=HistoricoCedenteEstrategia.SELECAO_RADIO_UNIDADE%>;						
				//document.frmMain.estrategia.value='<%=HistoricoCedenteEstrategia.STRATEGY_MANTER_FILTRO%>';
				document.frmMain.codigoUnidadePv.focus();
			}		
			else{
				document.frmMain.codigoCedente.disabled=true;
				document.frmMain.codigoCedente.value='';
				document.frmMain.dataInicial.disabled=true;
				document.frmMain.dataInicial.value='';
				document.frmMain.dataFinal.disabled=true;				
				document.frmMain.dataFinal.value='';
				document.frmMain.codigoUnidadePv.disabled=true;
				document.frmMain.codigoUnidadePv.value='';
				document.frmMain.dataMovimento.disabled=true;
				document.frmMain.dataMovimento.value='';				
			}		
		}
    </script>
  </s:FormStrategy>
</p:Document>
</html>
