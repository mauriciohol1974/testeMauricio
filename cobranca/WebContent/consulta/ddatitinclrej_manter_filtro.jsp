<%
/**
 * <B>Projeto: SIGCB - DDA</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta >> DDA
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.DdaTituloDiaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.DdaTitIncluidoEstrategia" %>

<%
	DdaTituloDiaBean ddaFiltroTitBean = (session.getAttribute(DdaTitIncluidoEstrategia.FILTRO_BEAN)==null? new DdaTituloDiaBean()
																			:(DdaTituloDiaBean)session.getAttribute(DdaTitIncluidoEstrategia.FILTRO_BEAN));

	ddaFiltroTitBean.setCodigoCedente(session.getAttribute(DdaTitIncluidoEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(DdaTitIncluidoEstrategia.CEDENTE_ATUAL));
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.DdaTitIncluidoRejManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="DDA >> Consultar Títulos Incluídos Rejeitados >> Filtro"/>
 		
 		<input type="hidden" name="tpConsulta" value="">

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
	              	  value='<%=ddaFiltroTitBean.getCodigoCedente().equals(new Long(0))?"":ddaFiltroTitBean.getCodigoCedente().toString()%>'
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
	              	  value='<%=ddaFiltroTitBean.getUnidadeVinculacao().equals(new Long(0))?"":ddaFiltroTitBean.getUnidadeVinculacao().toString()%>'
	              	  onFocus="javascript: prevFocus(this);"                		
	                	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataPagamento);"/>
              </td>
            	<td width="20%">&nbsp;</td>
						</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
           	<tr>
              <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Data de Inclusão: </td>
              <td class="textoTitulo" width="36%">
                <p:InputDate name="dataPagamento" CLASS="inputtext"
	              	  value='<%=ddaFiltroTitBean.getDataPagamentoFormatada()%>'	              	  
	              	  onFocus="javascript: prevFocus(this);"                		
                		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
              </td>
            	<td width="20%">&nbsp;</td>
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
				
				document.frmMain.radioTpConsulta[<%=ddaFiltroTitBean.getTpConsulta()%>].checked = true;
        habilitaDigitacao();
      }
      
      function formSubmit() {
      	if (validaFiltro()){
        	document.frmMain.submit();
	      }
      }
            
      function validaFiltro(){
      	
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
				if(!validaCampoObrigatorio(document.frmMain.dataPagamento,'Data de Pagamento')){
		   		return false;
		   	}
				if(document.frmMain.dataPagamento.value != ''){
					if(!validaData(document.frmMain.dataPagamento)) {
						msg('014','Data de Pagamento');
					  return false;
				 	}
				}
      	return true;
      }
      
      function habilitaDigitacao(){
     		if (document.frmMain.radioTpConsulta[0].checked) {
     			document.frmMain.codigoCedente.value = "<%=ddaFiltroTitBean.getCodigoCedente().equals( new Long(0))?"":ddaFiltroTitBean.getCodigoCedente().toString()%>";
     			document.frmMain.codigoCedente.disabled = false;  			
        	document.frmMain.unidadeVinculacao.value ="";
        	document.frmMain.unidadeVinculacao.disabled = true;
        	document.frmMain.tpConsulta.value = 0;
      		<%// 23/08%>
      		document.frmMain.codigoCedente.focus();
      		
        }else if (document.frmMain.radioTpConsulta[1].checked) {
					document.frmMain.codigoCedente.value = "";
        	document.frmMain.codigoCedente.disabled = true;
        	document.frmMain.unidadeVinculacao.disabled = false;
        	document.frmMain.tpConsulta.value = 1;
   		  	
      		document.frmMain.unidadeVinculacao.focus();
        }
      }	 	  
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
