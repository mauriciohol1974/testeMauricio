<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: titliq_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 05/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosDiaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TitLiqManterEstrategia" %>

<%
	ConGerTitulosLiquidadosDiaBean filtroBean = (session.getAttribute(TitLiqManterEstrategia.FILTRO_BEAN)==null? new ConGerTitulosLiquidadosDiaBean()
																			:(ConGerTitulosLiquidadosDiaBean)session.getAttribute(TitLiqManterEstrategia.FILTRO_BEAN));

	filtroBean.setCodigoCedente(session.getAttribute(TitLiqManterEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(TitLiqManterEstrategia.CEDENTE_ATUAL));
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.TitLiqManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Títulos Liquidados >> Filtro"/>
 		
 		<input type="hidden" name="tpConsulta" value="">
 		<input type="hidden" name="tipoConsulta" value="">

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="radioTpConsulta" onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.codigoCedente);">
              </td>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoTitulo" width="36%">
                <p:InputNumerico name="codigoCedente" disabled="true" maxlength="7" size="7" CLASS="inputtext" 
	              	  value='<%=filtroBean.getCodigoCedente().equals(new Long(0))?"":filtroBean.getCodigoCedente().toString()%>'
	              	  onFocus="javascript: prevFocus(this);"                		
	                	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataPagamento);"/>
              </td>
            	<td width="20%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="radioTpConsulta" onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.unidadeVinculacao);">
              </td>
              <td class="textoTitulo" width="17%">Unidade de Vinculação: </td>
              <td class="textoTitulo" width="36%">
                <p:InputNumerico name="unidadeVinculacao" disabled="true" maxlength="4" size="5" CLASS="inputtext" 
	              	  value='<%=filtroBean.getUnidadeVinculacao().equals(new Long(0))?"":filtroBean.getUnidadeVinculacao().toString()%>'
	              	  onFocus="javascript: prevFocus(this);"                		
	                	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumero);"/>
              </td>
            	<td width="20%">&nbsp;</td>
						</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
              <tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="radioNossoNumero" onclick="javascript:habilitaDigitacaoData();radioNextFocus(document.frmMain.nossoNumero);">
              </td>
              <td class="textoTitulo" width="17%">Nosso Número: </td>
              <td class="textoTitulo" width="36%">
                <p:InputNumerico name="nossoNumero"  disabled = "true" maxlength="17" size="23" CLASS="inputtext"
	              	  onFocus="javascript: prevFocus(this);"                		
                		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataInicio);"/>
              </td>
            	<td width="20%">&nbsp;</td>
						</tr>
           	<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="radioNossoNumero" onclick="javascript:habilitaDigitacaoData();radioNextFocus(document.frmMain.dataPagamento);">
              </td>
              <td class="textoTitulo" width="17%">Período: </td>
              <td class="textoTitulo" colspan="2">
                <p:InputDate name="dataInicio" CLASS="inputtext" disabled = "true"
	              	  value='<%=filtroBean.getDataInicioFormatada()%>'	              	  
	              	  onFocus="javascript: prevFocus(this);"                		
                		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataFim);"/>
                &nbsp;até&nbsp;
                <p:InputDate name="dataFim" CLASS="inputtext" disabled = "true"
	              	  value='<%=filtroBean.getDataFimFormatada()%>'	              	  
	              	  onFocus="javascript: prevFocus(this);"                		
                		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
              </td>
			</tr>
						<tr> 
              <td colspan="4">&nbsp;</td>
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
				<%//EAM - 23/08%>
				document.frmMain.radioTpConsulta[<%=filtroBean.getTpConsulta()%>].checked = true;
				document.frmMain.radioNossoNumero[0].checked = true;
		        habilitaDigitacaoData()
		        habilitaDigitacao();
      }
      
      function formSubmit() {
      	if (validaFiltro()){
        	document.frmMain.submit();
	      }
      }
            
      function validaFiltro(){
      	<%//EAM - 23/08 - Refeita a parte de validação%>
	     	if (!validaRadioButton(document.frmMain.radioTpConsulta, 'Tipo Consulta')) {
				  return false;
  		  }
   			if(document.frmMain.radioTpConsulta[0].checked){
   				if(!validaCampoObrigatorio(document.frmMain.codigoCedente,'Cedente')){
		    		return false;
		    	}
	    	}
	    	if(document.frmMain.radioTpConsulta[1].checked){
	      	if(!validaCampoObrigatorio(document.frmMain.unidadeVinculacao,'Unidade de Vinculação')){
 			   		return false;
 			   	}
 		    }
	    	
			var nn = "";
			var dp = "";
			nn = document.frmMain.nossoNumero.value;
			
			
			if (document.frmMain.radioNossoNumero[0].checked) {
				document.frmMain.tipoConsulta.value = "3";
				if(!validaCampoObrigatorio(document.frmMain.nossoNumero,'Nosso Número')){
		    		return false;
		    	}
				
			}else if (document.frmMain.radioNossoNumero[1].checked) {
				document.frmMain.tipoConsulta.value = "1";

				//if (!validaCampoObrigatorio(document.frmMain.dataPagamento,'Data de Pagamento')){
				//	return false;
				//}
				//if(document.frmMain.dataPagamento.value != ''){
				//		if(!validaData(document.frmMain.dataPagamento)) {
				//			msg('014','Data de Pagamento');
				//		  return false;
				//	 	}
			

				
			}
			
				
		   		
			
      	return true;
      }
      
      function habilitaDigitacao(){
     		if (document.frmMain.radioTpConsulta[0].checked) {
     			document.frmMain.codigoCedente.value = "<%=filtroBean.getCodigoCedente().equals( new Long(0))?"":filtroBean.getCodigoCedente().toString()%>";
     			document.frmMain.codigoCedente.disabled = false;  			
        	document.frmMain.unidadeVinculacao.value ="";
        	document.frmMain.unidadeVinculacao.disabled = true;
        	document.frmMain.tpConsulta.value = 0;
      		<%//EAM 23/08%>
      		document.frmMain.codigoCedente.focus();
      		
        }else if (document.frmMain.radioTpConsulta[1].checked) {
					document.frmMain.codigoCedente.value = "";
        	document.frmMain.codigoCedente.disabled = true;
        	document.frmMain.unidadeVinculacao.disabled = false;
        	document.frmMain.tpConsulta.value = 1;
   		  	<%//EAM 23/08%>
      		document.frmMain.unidadeVinculacao.focus();
        }
      }	 
      
      function habilitaDigitacaoData(){
   		if (document.frmMain.radioNossoNumero[0].checked) {
   			document.frmMain.tipoConsulta.value = "3";
   			document.frmMain.nossoNumero.disabled = false;
   			document.frmMain.nossoNumero.value = "";
   			document.frmMain.dataInicio.disabled = true;
   			document.frmMain.dataInicio.value = "";
   			document.frmMain.dataFim.disabled = true;
   			document.frmMain.dataFim.value = "";
    		document.frmMain.nossoNumero.focus();
    		
      }else if (document.frmMain.radioNossoNumero[1].checked) {
    	  document.frmMain.tipoConsulta.value = "1";
    	  	document.frmMain.nossoNumero.disabled = true;
   			document.frmMain.nossoNumero.value = "";
   			document.frmMain.dataInicio.disabled = false;
   			document.frmMain.dataInicio.value = "";
   			document.frmMain.dataFim.disabled = false;
   			document.frmMain.dataFim.value = "";
    	  	document.frmMain.dataInicio.focus();
      }
    }	
      
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
