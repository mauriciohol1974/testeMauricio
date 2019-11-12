

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.LiquidacaoOnlineBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloOnLineEstrategia"%>

<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(TituloOnLineEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TituloOnLineEstrategia.CEDENTE_CABECALHO_BEAN));
	LiquidacaoOnlineBean liquidacaoOnline = (session.getAttribute(TituloOnLineEstrategia.FILTRO_BEAN)==null?new LiquidacaoOnlineBean():(LiquidacaoOnlineBean)session.getAttribute(TituloOnLineEstrategia.FILTRO_BEAN));	

	//Long filtroSelecao = tituloBean.getFiltroSelecao()==null?new Long(1):tituloBean.getFiltroSelecao();
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TituloOnLineEstrategia.STRATEGY_MANTER_LISTAR%>"  
		fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TituloOnLineEstrategia.PAGE_TITLE_MANTER_FILTRO%>"/>

		<input type="hidden" name = "nossoNumero" value="0">
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
            <td class="textoTitulo" width="2%"> <input type="radio" name="rdo" value="1" checked onclick="javascript: radio('1')"></td>
               <td class="textoTitulo" width="17%">Cedente: </td>
               <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" 
              	 name="codigoCedente" size="7" maxlength="7"
 				 value='<%=liquidacaoOnline.getCodigoCedente().equals(new Long(0))?"":liquidacaoOnline.getCodigoCedente().toString()%>'
        		 onFocus="javascript: prevFocus(this);"
				 onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.apelidoCedente);"/> 
				</td>

			</tr>
			<tr> 
			<td class="textoTitulo" width="2%"> <input type="radio" name="rdo" value="2" onclick="javascript: radio('2')" ></td>
              <td class="textoTitulo" width="17%">Apelido: </td>
               <td class="textoValor" width="26%">
              	<p:InputAlfanumerico CLASS="inputtext" 
              	 name="apelidoCedente" size="7" maxlength="6"
 				 value='<%=liquidacaoOnline.getApelidoCedente()%>'
        		 onFocus="javascript: prevFocus(this);"
				 onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codigoUnidadePV);"/> 
				</td>

			</tr>
			<tr> 
			<td class="textoTitulo" width="2%"> <input type="radio" name="rdo" value="3" onclick="javascript: radio('3')" ></td>
              <td class="textoTitulo" width="17%">Unidade PV: </td>
               <td class="textoValor" width="26%">
              	 <p:InputNumerico CLASS="inputtext" 
              	 name="codigoUnidadePV" size="5" maxlength="4"
 				 value='<%=liquidacaoOnline.getCodigoUnidadePV().equals(new Long(0))?"":liquidacaoOnline.getCodigoUnidadePV().toString()%>'
        		 onFocus="javascript: prevFocus(this);"
				 onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataInicial);"/> 
				</td>

			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr> 
              <td class="textoTitulo" colspan="2" width="17%">Data Pagamento Inicial: </td>
               <td class="textoValor" width="26%">
              	    <p:InputDate name="dataInicial" 
				  	value ='<%=liquidacaoOnline.getDataInicialFormatada()%>'
					CLASS="inputtext"
					onFocus="javascript: prevFocus(this);"
					onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataFinal);"	/> 
				</td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoTitulo" width="26%">&nbsp;</td>
			</tr>
			<tr> 
              <td class="textoTitulo" colspan="2" width="17%">Data Pagamento Final: </td>
               <td class="textoValor" width="26%">
              	 <p:InputDate name="dataFinal" 
				  	value ='<%=liquidacaoOnline.getDataFinalFormatada()%>'
					CLASS="inputtext"
					onFocus="javascript: prevFocus(this);"
					onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.ok);"	/> 
				</td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoTitulo" width="26%">&nbsp;</td>
			</tr>			
			
			
			
						<tr>
							<td colspan="5">&nbsp;</td>
						</tr>
	          <tr>
	            <td align="right" colspan="5">
	              <p align="center"> 
 		            	<s:Button name="Ok" action="javascript:formSubmit()"/>
	              </p>
	            </td>
	          </tr>
          </table>
        </td>
      </tr>
    </table>
    <script>
			function inicia() {
				setFirstFieldFocus();
				radio('1');
			}


			

			
	    function formSubmit() {

   	    	document.frmMain.submit();
		}
	    
	    function radio(valor){
	    	
	    	if (valor=="1"){
	    		document.frmMain.codigoCedente.value="<%=liquidacaoOnline.getCodigoCedente().equals(new Long(0))?"":liquidacaoOnline.getCodigoCedente().toString()%>";
	    		document.frmMain.apelidoCedente.value="";
	    		document.frmMain.codigoUnidadePV.value="";
	    		document.frmMain.codigoCedente.disabled=false
	    		document.frmMain.apelidoCedente.disabled=true
	    		document.frmMain.codigoUnidadePV.disabled=true
	    	}else if (valor=="2"){
	    		document.frmMain.codigoCedente.value="";
	    		document.frmMain.apelidoCedente.value="<%=liquidacaoOnline.getApelidoCedente()%>";
	    		document.frmMain.codigoUnidadePV.value="";
	    		document.frmMain.codigoCedente.disabled=true
	    		document.frmMain.apelidoCedente.disabled=false
	    		document.frmMain.codigoUnidadePV.disabled=true	    		
	    	}else if (valor=="3"){
	    		document.frmMain.codigoCedente.value="";
	    		document.frmMain.apelidoCedente.value="";
	    		document.frmMain.codigoUnidadePV.value="<%=liquidacaoOnline.getCodigoUnidadePV().equals(new Long(0))?"":liquidacaoOnline.getCodigoUnidadePV().toString()%>";
	    		document.frmMain.codigoCedente.disabled=true
	    		document.frmMain.apelidoCedente.disabled=true
	    		document.frmMain.codigoUnidadePV.disabled=false
	    	}
	    }
			
    </script>
  </s:FormStrategy>
</p:Document></html>
