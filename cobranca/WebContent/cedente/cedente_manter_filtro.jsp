<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteManterFiltroBean"%>
<%	
	CedenteManterFiltroBean filtroBean = (session.getAttribute(CedenteEstrategia.MANTER_FILTRO_BEAN)==null?new CedenteManterFiltroBean():(CedenteManterFiltroBean)session.getAttribute(CedenteEstrategia.MANTER_FILTRO_BEAN));
	filtroBean.setCodigoCedente(session.getAttribute(CedenteEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(CedenteEstrategia.CEDENTE_ATUAL));
%>

<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteManterFiltro" fluxo="normal">   	          				
   		<s:Menu/>
   		<s:Titulo name="Manter Cedente >> Filtro"/>

			<input type="hidden" name="cpfCnpj">
			<input type="hidden" name="radioTipoConsultaAnterior" value="0">

	    <table width="777" border="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
							<tr>
	              <td class="textoTitulo" width="2%">
	                <input type="radio" name="radioTipoConsulta" value="<%= CedenteEstrategia.OPCAO_BUSCA_CEDENTE %>" onclick="habilitaDigitacao(); radioNextFocus(document.frmMain.codigoCedente);">
	              </td>
	              <td class="textoTitulo" width="17%">Cedente: </td>
	              <td class="textoTitulo" width="36%">
	                <p:InputNumerico CLASS="inputtext" name="codigoCedente" size="8" maxlength="7" disabled="true" 
               	    value='<%=filtroBean.getCodigoCedente().equals(new Long(0))?"":filtroBean.getCodigoCedente().toString()%>'
               	    onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
	              </td>
	            	<td width="20%">&nbsp;</td>
							</tr>
							<tr>
	              <td class="textoTitulo" width="2%">
	                <input type="radio" name="radioTipoConsulta" value="<%= CedenteEstrategia.OPCAO_BUSCA_CPFCNPJ %>" onclick="habilitaDigitacao(); radioNextFocus(document.frmMain.inputCpfCnpj);">
	              </td>
	              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
	              <td width="26%">
	              	<s:ComboTipoPessoa name="tipoPessoa" disabled="true"
	               		onChange="javascript:limpaCpfCnpj(inputCpfCnpj);"
	              		selectedValue='<%=filtroBean.getTipoPessoa().equals(new Long(0))?"2":filtroBean.getTipoPessoa().toString()%>'/>
	                <p:InputCpfCnpj CLASS="inputtext" name="inputCpfCnpj" disabled="true"
	              		value='<%=filtroBean.getCpfCnpj().equals(new Long(0))?"":filtroBean.getCpfCnpj().toString()%>'
	              		onBlur="javascript:formataCpfCnpj(this, tipoPessoa);" 
	              		onFocus="javascript:unFormataCpfCnpj(this, tipoPessoa);prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
	              </td>
	            	<td>&nbsp;</td>
							</tr>
	            <tr>
	              <td class="textoTitulo" width="2%">
	                <input type="radio" name="radioTipoConsulta" value="<%= CedenteEstrategia.OPCAO_BUSCA_UNIDADE %>" onclick="habilitaDigitacao(); radioNextFocus(document.frmMain.codigoUnidade);">
	              </td>
	              <td class="textoTitulo" width="17%">Tipo de Unidade: </td>
	              <td class="textoValor" width="26%">
	              	<s:ComboENPV name="tipoUnidade" disabled="true"  
	              		selectedValue='<%=filtroBean.getTipoUnidade().equals(new Long(0))?"2":filtroBean.getTipoUnidade().toString()%>'/>
	                <p:InputNumerico CLASS="inputtext" name="codigoUnidade" size="5" maxlength="4" disabled="true" 
	              		value='<%=filtroBean.getCodigoUnidade().equals(new Long(0))?"":filtroBean.getCodigoUnidade().toString()%>'               	    
               	    onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
								</td>
	            	<td>&nbsp;</td>
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
	        radioSelecionado();
	      }
	      
	      function formSubmit() {
	      	if (validaSubmit()) {
	      		// desformata cpf / cnpj antes do submit
	      		document.frmMain.cpfCnpj.value = document.frmMain.inputCpfCnpj.value;
	      		unFormataCpfCnpj(document.frmMain.cpfCnpj, document.frmMain.tipoPessoa);
	      	
		        document.frmMain.submit();
		      }
	      }
	      
		    function validaSubmit() {
	        if (validaRadioButton(document.frmMain.radioTipoConsulta, 'Tipo Consulta')) {
						if (document.frmMain.radioTipoConsulta[0].checked) {
	        		if(validaCampoObrigatorio(document.frmMain.codigoCedente,'Cedente')){
	        				return true;
	        			}else{
	        				return false;
	        			}
	        	} else if (document.frmMain.radioTipoConsulta[1].checked) {
	        			if (validaCampoObrigatorio(document.frmMain.inputCpfCnpj,'CPF/CNPJ')){
	        				if (document.frmMain.tipoPessoa.value == "1"){
	        					if (validaDVCPF(document.frmMain.inputCpfCnpj)){
	        						return true;
	        					}else{
	        						alert("Dígito verificador CPF Inválido.");
	        						return false;
	        					}
	        				}else if (validaDVCNPJ(document.frmMain.inputCpfCnpj)){
	        					return true;
	        				}else{
	        					alert("Dígito Verificador do CNPJ Inválido.");        							
	        					return false;
	        				}
	        				return false;        				
	        			}
	        	} else if (document.frmMain.radioTipoConsulta[2].checked) {
							if(validaCampoObrigatorio(document.frmMain.codigoUnidade,'Código da Unidade')){
								return true;
							} else {
								return false;
							}
	        	}
	        }
	      }

				function habilitaDigitacao(){
	     			if (document.frmMain.radioTipoConsulta[0].checked) {
	        			
	        			document.frmMain.codigoCedente.disabled = false;
	        			
	        			document.frmMain.inputCpfCnpj.value ="";
	        			document.frmMain.inputCpfCnpj.disabled = true;
	        			document.frmMain.tipoPessoa.disabled = true;
	        			
	        			document.frmMain.codigoUnidade.value ="";
	        			document.frmMain.codigoUnidade.disabled = true;
	        			document.frmMain.tipoUnidade.disabled = true;
	        			
	        	} else if (document.frmMain.radioTipoConsulta[1].checked) {
	
	        			document.frmMain.inputCpfCnpj.disabled = false;
	        			document.frmMain.tipoPessoa.disabled = false;
	        			
	        			document.frmMain.codigoCedente.value ="";
	        			document.frmMain.codigoCedente.disabled = true;
	        			
	        			document.frmMain.codigoUnidade.value ="";
	        			document.frmMain.codigoUnidade.disabled = true;
	        			document.frmMain.tipoUnidade.disabled = true;
	        			
	        	} else if (document.frmMain.radioTipoConsulta[2].checked) {
							
	        			document.frmMain.codigoUnidade.disabled = false;
	        			document.frmMain.tipoUnidade.disabled = false;
	        			
	        			document.frmMain.codigoCedente.value ="";
	        			document.frmMain.codigoCedente.disabled = true;
	        			
	        			document.frmMain.inputCpfCnpj.value ="";
	        			document.frmMain.inputCpfCnpj.disabled = true;
	        			document.frmMain.tipoPessoa.disabled = true;

	        	}
	      }	 	 

				function radioNextFocus(fieldTo) {
				 	fieldTo.select();
				}
				

				/*
				function formataCpfCnpj(campo){
	     	 	if (document.frmMain.tipoPessoa.value == 1){
	     	 		formataCPF(campo);
	      	} else {
	     			formataCNPJ(campo);
	     		}
	      }

	     	function unformataCpfCnpj(campo){
	      	if (document.frmMain.tipoPessoa.value == 1){
  	   			unFormataCPF(campo);
	     		} else {
	     			unFormataCNPJ(campo);
	     		}
	     	} 
	      */
	      
	      function radioSelecionado(){
	      	<%if (filtroBean.getRadioTipoConsulta().intValue() == CedenteEstrategia.OPCAO_BUSCA_CEDENTE ||
	      				filtroBean.getRadioTipoConsulta().intValue() == 0){%>
		      	document.frmMain.radioTipoConsulta[0].checked = true;	  
		      	habilitaDigitacao();
		      	radioNextFocus(document.frmMain.codigoCedente);
		      <%}else	if (filtroBean.getRadioTipoConsulta().intValue() == CedenteEstrategia.OPCAO_BUSCA_CPFCNPJ){%>
		      	document.frmMain.radioTipoConsulta[1].checked = true;	  
		      	habilitaDigitacao();
		      	radioNextFocus(document.frmMain.inputCpfCnpj);
		      <%}else	if (filtroBean.getRadioTipoConsulta().intValue() == CedenteEstrategia.OPCAO_BUSCA_UNIDADE){%>
		      	document.frmMain.radioTipoConsulta[2].checked = true;	  
		      	habilitaDigitacao();
		      	radioNextFocus(document.frmMain.codigoUnidade);
		      <%}%>
		      
	      }
	      
	    </script>

		</s:FormStrategy>
	</p:Document>

</html>
