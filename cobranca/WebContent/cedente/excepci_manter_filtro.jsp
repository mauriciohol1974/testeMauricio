<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: excepci_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 28/08/2004 - v1013
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.DadosListaExcepciBean"%>
<%@page import="br.gov.caixa.sigcb.bean.ExcepcionacaoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.ExcepciManterEstrategia"%>

<% 
	
	ExcepcionacaoBean excepciBean	= (session.getAttribute(ExcepciManterEstrategia.EXCEPCI_BEAN)==null? new ExcepcionacaoBean()
																	:(ExcepcionacaoBean)session.getAttribute(ExcepciManterEstrategia.EXCEPCI_BEAN));	
	
	DadosListaExcepciBean ListaBean = (session.getAttribute(ExcepciManterEstrategia.FILTRO_BEAN)==null? new DadosListaExcepciBean()
																		:(DadosListaExcepciBean)session.getAttribute(ExcepciManterEstrategia.FILTRO_BEAN));

	ListaBean.setCodigoCedente(session.getAttribute(ExcepciManterEstrategia.CEDENTE_ATUAL)==null?new Long (0)
															:(Long)session.getAttribute(ExcepciManterEstrategia.CEDENTE_ATUAL));
%>

<html>
  <s:Header/>
  
  <p:Document>
  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.ExcepciManterFiltro" fluxo="normal">   	          				
   		<s:Menu/>   		
   		<s:Titulo name="Excepcionação de Pendência de Alçada >> Filtro"/>
   		
   		
   		<input type="hidden" name = "codigoUnidadeEN" value="">
   		<input type="hidden" name = "codigoUnidadePV" value="">
   		<input type="hidden" name = "cpfCnpj" value="">
   		<input type="hidden" name = "tpConsultaEstrategia" value="">
   		<input type="hidden" name = "situacaoPendencia" value="">

	    <table width="777" border="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
							<tr>
	              <td class="textoTitulo" width="2%">
	                <input type="radio" name="radioTpConsulta" value="0" onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.codigoCedente);">
	              </td>
	              <td class="textoTitulo" width="17%">Cedente: </td>
	              <td class="textoValor" width="26%"> 
	                <p:InputNumerico name="codigoCedente" disabled="true" maxlength="7" size="7" CLASS="inputtext" value=""
	              		value='<%=ListaBean.getCodigoCedente().equals(new Long(0))?"":ListaBean.getCodigoCedente().toString()%>'               	                   	    
               	    onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.comboPendencia);"/>
	              </td>
	            	<td width="17%">&nbsp;</td>
	            	<td width="26%">&nbsp;</td>
							</tr>
							<tr>
	              <td class="textoTitulo" width="2%">
	                <input type="radio" name="radioTpConsulta" value="1" onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.inputCpfCnpj);">
	              </td>
	              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
	              <td class="textoValor" width="26%"> 
	               	<s:ComboTipoPessoa name="tipoPessoa" disabled="true" 
	               		onChange="javascript:limpaCpfCnpj(inputCpfCnpj);"
	              		selectedValue='<%=ListaBean.getTipoPessoa().equals(new Long(0))?"2":ListaBean.getTipoPessoa().toString()%>'/>
	              	<p:InputCpfCnpj name="inputCpfCnpj" disabled="true" CLASS="inputtext" 
	              		value='<%=ListaBean.getCpfCnpj().equals(new Long(0))?"":ListaBean.getCpfCnpj().toString()%>' 
	              		onBlur="javascript:formataCpfCnpj(this, tipoPessoa);" 
	              		onFocus="javascript:unFormataCpfCnpj(this, tipoPessoa);prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.comboPendencia);"/>
	              </td>
	            	<td width="17%">&nbsp;</td>
	            	<td width="26%">&nbsp;</td>
							</tr>
							<tr>
	              <td class="textoTitulo" width="2%">
	                <input type="radio" name="radioTpConsulta" value="2" onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.numeroPendencia);">
	              </td>
	              <td class="textoTitulo" width="17%">Número Pendência: </td>
	              <td class="textoValor" width="26%"> 
	                <p:InputNumerico name="numeroPendencia" disabled="true" size="7" maxlength="6" CLASS="inputtext"
	              		value='<%=ListaBean.getNumeroPendencia().equals(new Long(0))?"":ListaBean.getNumeroPendencia().toString()%>'                	    
               	    onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
	              </td>
	            	<td width="17%">&nbsp;</td>
	            	<td width="26%">&nbsp;</td>
							</tr>
							<tr>
	              <td class="textoTitulo" width="2%">
	                <input type="radio" name="radioTpConsulta" value="3" onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.codigoUnidadeENPV);">
	              </td>
	              <%
	              String selectENPV = "2";
	              String codigoUnidadeENPV = "";
	              if (ListaBean.getTpConsultaEstrategia().intValue() == 3){ //EN
	              	selectENPV = "1";
	              	codigoUnidadeENPV = ListaBean.getCodigoUnidadeEN().toString();
	              }else if (ListaBean.getTpConsultaEstrategia().intValue() == 4){ //PV
	              	selectENPV = "2";
	              	codigoUnidadeENPV = ListaBean.getCodigoUnidadePV().toString();
	              }
	              %>
	              
	              
	              <td class="textoTitulo" width="17%">Unidade: </td>
	              <td class="textoValor" width="26%">
	                <s:ComboENPV name="SelectENPV" disabled="true" selectedValue='<%=selectENPV%>'/>
	                <p:InputNumerico name="codigoUnidadeENPV" disabled="true" size="5" maxlength="4" CLASS="inputtext" 
 	              		value='<%=codigoUnidadeENPV.equals("0")?"":codigoUnidadeENPV%>'                	    
               	    onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.comboPendencia);"/>
								</td>
	            	<td width="17%">&nbsp;</td>
	            	<td width="26%">&nbsp;</td>
							</tr>
	            <tr> 
	              <td colspan="5">&nbsp;</td>
	            </tr>
							<tr>
	              <td class="textoTitulo" width="2%">&nbsp;</td>
	              <td class="textoTitulo" width="17%">Situação das Pendências: </td>
	              <td class="textoValor" width="26%">
	              							
								<s:ComboSituacaoPendencia name="comboPendencia" selectedValue="2" disabled="false"
              		selectedValue='<%=ListaBean.getSituacaoPendencia().equals(new Long(0))?"2":ListaBean.getSituacaoPendencia().toString()%>'/>
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
	        </td>
  			</tr>
	    </table>
		<script>
		
		function inicia() {
				setFirstFieldFocus();
				radioSelecionado();
			}
				
		function formSubmit(){
			document.frmMain.Ok.focus();
			if(validaSubmit()){
				if(document.frmMain.radioTpConsulta[2].checked){
					document.frmMain.situacaoPendencia.value = 3;
				}else{
					document.frmMain.situacaoPendencia.value = document.frmMain.comboPendencia.value;
				}
				document.frmMain.submit();
			}
		}
		
		function radioNextFocus(fieldTo) {
		 	fieldTo.select();
		}
		
    function validaSubmit() {
        if (validaRadioButton(document.frmMain.radioTpConsulta, 'Tipo Consulta')) {
					if (document.frmMain.radioTpConsulta[0].checked) {
        		if(validaCampoObrigatorio(document.frmMain.codigoCedente,'Cedente')){
        				document.frmMain.tpConsultaEstrategia.value = 0;
        				return true;
        			}else{
        				return false;
        			}
        	} else if (document.frmMain.radioTpConsulta[1].checked) {
        			if (validaCampoObrigatorio(document.frmMain.inputCpfCnpj,'CPF/CNPJ')){
            		if(!validaDvCpfCnpj(document.frmMain.inputCpfCnpj,document.frmMain.tipoPessoa)){
									msg('008','CPF/CNPJ');
			   					return false;
								}
								document.frmMain.tpConsultaEstrategia.value = 1;								
								document.frmMain.cpfCnpj.value = document.frmMain.inputCpfCnpj.value;
								unFormataCpfCnpj(document.frmMain.cpfCnpj,document.frmMain.tipoPessoa);
								return true;		
        			}
        	} else if (document.frmMain.radioTpConsulta[2].checked) {
        		if(validaCampoObrigatorio(document.frmMain.numeroPendencia,'Número Pendência')){
        			document.frmMain.tpConsultaEstrategia.value = 2;
        			return true;
        		}else{
        			return false;
        		}
        	} else if (document.frmMain.radioTpConsulta[3].checked) {
						if (document.frmMain.SelectENPV.value == "1") {
							if(validaCampoObrigatorio(document.frmMain.codigoUnidadeENPV,'Código da Unidade EN')){
								document.frmMain.codigoUnidadeEN.value = document.frmMain.codigoUnidadeENPV.value;
								document.frmMain.tpConsultaEstrategia.value = 3;
								return true;
							} else {
								return false;
							}
						}else if(validaCampoObrigatorio(document.frmMain.codigoUnidadeENPV,'Código da Unidade PV')){
							document.frmMain.codigoUnidadePV.value = document.frmMain.codigoUnidadeENPV.value;
							document.frmMain.tpConsultaEstrategia.value = 4;
							return true;
						}else {
							return false;
						}
        	}
        }
      } 
      
			function habilitaDigitacao(){
     			if (document.frmMain.radioTpConsulta[0].checked) {
        			
        			document.frmMain.codigoCedente.disabled = false;
							document.frmMain.codigoCedente.value =	"<%=ListaBean.getCodigoCedente().equals( new Long(0))?"":ListaBean.getCodigoCedente().toString()%>";
        			
        			document.frmMain.inputCpfCnpj.value ="";
        			document.frmMain.inputCpfCnpj.disabled = true;
        			document.frmMain.tipoPessoa.disabled = true;
        			
        			document.frmMain.numeroPendencia.value ="";
        			document.frmMain.numeroPendencia.disabled = true;
        			
        			document.frmMain.codigoUnidadeENPV.value ="";
        			document.frmMain.codigoUnidadeENPV.disabled = true;
        			document.frmMain.SelectENPV.disabled = true;
        			
        			document.frmMain.comboPendencia.disabled = false;
        			
        	} else if (document.frmMain.radioTpConsulta[1].checked) {

        			document.frmMain.inputCpfCnpj.disabled = false;
        			document.frmMain.tipoPessoa.disabled = false;
        			
        			document.frmMain.codigoCedente.value ="";
        			document.frmMain.codigoCedente.disabled = true;
        			
        			document.frmMain.numeroPendencia.value ="";
        			document.frmMain.numeroPendencia.disabled = true;
        			
        			document.frmMain.codigoUnidadeENPV.value ="";
        			document.frmMain.codigoUnidadeENPV.disabled = true;
        			document.frmMain.SelectENPV.disabled = true;
        			
        			document.frmMain.comboPendencia.disabled = false;
        			
        	} else if (document.frmMain.radioTpConsulta[2].checked) {

        			document.frmMain.numeroPendencia.disabled = false;
        			
        			document.frmMain.codigoCedente.value ="";
        			document.frmMain.codigoCedente.disabled = true;
        			
        			document.frmMain.inputCpfCnpj.value ="";
        			document.frmMain.inputCpfCnpj.disabled = true;
        			document.frmMain.tipoPessoa.disabled = true;
        			
        			document.frmMain.codigoUnidadeENPV.value ="";
        			document.frmMain.codigoUnidadeENPV.disabled = true;
        			document.frmMain.SelectENPV.disabled = true;
        			
        			document.frmMain.comboPendencia.disabled = true;
        			
        	} else if (document.frmMain.radioTpConsulta[3].checked) {
						
        			document.frmMain.codigoUnidadeENPV.disabled = false;
        			document.frmMain.SelectENPV.disabled = false;
        			
        			document.frmMain.codigoCedente.value ="";
        			document.frmMain.codigoCedente.disabled = true;
        			
        			document.frmMain.inputCpfCnpj.value ="";
        			document.frmMain.inputCpfCnpj.disabled = true;
        			document.frmMain.tipoPessoa.disabled = true;
        			
        			document.frmMain.numeroPendencia.value ="";
        			document.frmMain.numeroPendencia.disabled = true;
        			
        			document.frmMain.comboPendencia.disabled = false;
        			
        	}
      }	 	  
	      function radioSelecionado(){
	      	<%if (ListaBean.getTpConsultaEstrategia().intValue() == 0){%>
		      	document.frmMain.radioTpConsulta[0].checked = true;	  
		      	habilitaDigitacao();
		      	radioNextFocus(document.frmMain.codigoCedente);
		      <%}else	if (ListaBean.getTpConsultaEstrategia().intValue() == 1){%>
		      	document.frmMain.radioTpConsulta[1].checked = true;	  
		      	habilitaDigitacao();
		      	radioNextFocus(document.frmMain.inputCpfCnpj);
		      <%}else	if (ListaBean.getTpConsultaEstrategia().intValue() == 2){%>
		      	document.frmMain.radioTpConsulta[2].checked = true;	  
		      	habilitaDigitacao();
		      	radioNextFocus(document.frmMain.numeroPendencia);
		      <%}else	if (ListaBean.getTpConsultaEstrategia().intValue() == 3 ||
		      						ListaBean.getTpConsultaEstrategia().intValue() == 4 ){%>
		      	document.frmMain.radioTpConsulta[3].checked = true;	  
		      	habilitaDigitacao();
		      	radioNextFocus(document.frmMain.codigoUnidadeENPV);
		      <%}%>
		      
	      }      
			</script>
		</s:FormStrategy>
	</p:Document>
</html>
