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
<%@page import="br.gov.caixa.sigcb.bean.ServicoBaixaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ServicoBaixaOperacionalEstrategia"%>




<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=ServicoBaixaOperacionalEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='<%=ServicoBaixaOperacionalEstrategia.PAGE_TITLE_FILTRO%>'/>

		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
		  <tr>
              <td class="textoTitulo" width="17%">Código do Beneficiario: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" size="8" maxlength="7"	name="codbenfcrio" onFocus="javascript: prevFocus(this);"/>
				</td>
		  </tr>
		  <tr>
	             <td class="textoTitulo" width="17%">CPF/CNPJ</td>
	             <td width="26%"><s:ComboTipoPessoa name="tppesport" onChange="javascript:limpaCpfCnpj(cnpjcpfport);"/>
					<p:InputCpfCnpj CLASS="inputtext" name="cnpjcpfport" />
	              </td>
	              <td width="17%">&nbsp;</td>
	              <td width="26%">&nbsp;</td>
	            </tr>
		  
		  <tr>
              <td class="textoTitulo" width="17%">Nosso Número: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" size="20" maxlength="18"	name="nossonum" onFocus="javascript: prevFocus(this);"/>
				</td>
		  </tr>
		  
		  <tr>
              <td class="textoTitulo" width="17%">Valor da Baixa: </td>
              <td class="textoValor" width="26%">
                <p:InputCurrency name="vlrbxoptit" maxlength="19" size="29" CLASS="inputtext"onFocus="javascript: prevFocus(this);"/> 	
			  </td>
		  </tr>
		  
		  <tr>
              <td class="textoTitulo" width="17%">Canal de Pagamento: </td>
              <td class="textoValor" width="26%">
              <select name="canpgtobxop">
              	<option value="1">1 - AGENCIAS - POSTOS TRADICIONAIS</option>      
				<option value="2">2 - TERMINAL DE AUTO-ATENDIMENTO</option>           
				<option value="3">3 - INTERNET (HOME / OFFICE BANKING)</option>       
				<option value="4">5 - CORRESPONDENTE BANCARIO</option>                
				<option value="5">6 - CENTRAL DE ATENDIMENTO (CALL CENTER)</option>   
				<option value="6">7 - ARQUIVO ELETRôNICO</option>                     
				<option value="7">8 - DDA </option>       
              	
              </select>
              	
			  </td>
		  </tr>
		  
		  		  <tr>
              <td class="textoTitulo" width="17%">Meio de Pagamento: </td>
              <td class="textoValor" width="26%">
              	<select name="meiopgtobxop">
              
            		<option value="1">1 - ESPECIE </option>          
					<option value="2">2 - DEBITO EM CONTA</option>   
					<option value="3">3 - CARTAO DE CREDITO</option> 
					<option value="4">4 - CHEQUE </option>     
              
              	</select>
			  </td>
		  </tr>
			
		  <tr>
              <td class="textoTitulo" width="17%">Indicador Operação Contingência: </td>
              <td class="textoValor" width="26%">
              	<s:ComboSimNao name="idopcontg" />
				</td>
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
			
      }
      
		function formSubmit() {
			if(validaSubmit()){
		  	document.frmMain.submit();
			}
  	}  
      
		function validaSubmit() {

				if(!validaCampoObrigatorio(document.frmMain.codbenfcrio, "Código do Cedente")) {
					return false;
			  	}
				
				if(!validaCampoObrigatorio(document.frmMain.nossonum, "Nosso Número")) {
					return false;
			  	}
			return true;
		}
		

    </script>
  </s:FormStrategy>
</p:Document>
</html>
