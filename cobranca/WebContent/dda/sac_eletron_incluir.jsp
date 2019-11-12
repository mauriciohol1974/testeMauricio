<%
/***********************************************
*Projeto CAIXA - SIGCB DDA
*Componente: sac_eletron_incluir.jsp - Java Server Pages
*Criado em: 04/09/2009
*Autor: Alexandre Lima - alexandre.lima@probank.com.br
*Ultima Atualização: set/2009
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.SacEletronicoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.dda.SacEletronicoEstrategia"%>

<%
	SacEletronicoBean sacBean = (session.getAttribute(SacEletronicoEstrategia.FILTRO_BEAN) == null ? new SacEletronicoBean() : (SacEletronicoBean)session.getAttribute(SacEletronicoEstrategia.FILTRO_BEAN)); 
%>

<html>
<s:Header/>

<p:Document>  
    <s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=SacEletronicoEstrategia.STRATEGY_INCLUIR_SUCESSO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=SacEletronicoEstrategia.PAGE_TITLE_INCLUIR%>"/>
		<input type="hidden" name ="cpfCnpj" value=''>
		<input type="hidden" name ="cpfCnpjAgreg" value=''>
		<input type="hidden" name ="tipoPessoa" value=''>
		<input type="hidden" name ="tipoPessoaAgreg" value=''>
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
			
			<tr valign="top"> 
              <td colspan="5" class="textoTitulo">Sacado Eletrônico:
                <hr>
              </td>
            </tr>			
						
			<tr>
              
            <td class="textoTitulo" width="12%">Tipo Pessoa: </td>
              
            <td class="textoTitulo" width="46%">
            	<s:ComboTipoPessoa name="tipoPessoaCombo" selectedValue='<%=sacBean.getTipoPessoa().equals(new Long(0)) ? "1":sacBean.getTipoPessoa().toString()%>'
            		onChange="javascript:limpaCpfCnpj(cpfCnpjInput);"
            	/>            
            </td>
              
            <td class="textoValor" width="11%">&nbsp; </td>
            	<td width="8%">&nbsp;</td>
            	<td width="23%">&nbsp;</td>
			</tr>
						
			<tr>
              
            <td class="textoTitulo" width="12%">CPF / CNPJ: </td>              
            <td class="textoTitulo" width="46%">
            	<p:InputCpfCnpj name="cpfCnpjInput" value='<%=sacBean.getCpfCnpjFormatado() %>' CLASS="inputtext" 
            	onBlur="javascript:formataCpfCnpj(this,tipoPessoaCombo);"
            	onFocus="javascript:unFormataCpfCnpj(this,tipoPessoaCombo);prevFocus(this);"
            	onKeyUp="javascript:nextFocus(event.keyCode, this, document.frmMain.tipoPessoaAgregCombo);"
            	/>
            </td>              
            <td class="textoValor" width="11%">&nbsp; </td>
            	<td width="8%">&nbsp;</td>
            	<td width="23%">&nbsp;</td>
			</tr>
			
			<tr> 
              <td colspan="5">&nbsp;</td>
            </tr>		
						
			<tr> 
              <td colspan="5" class="textoTitulo">&nbsp;</td>
            </tr>
						
			<tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
			
			<tr valign="top"> 
              <td colspan="5" class="textoTitulo">Sacado Agregado:
                <hr>
              </td>
            </tr>			
						
			<tr>
              
            <td class="textoTitulo" width="12%">Tipo Pessoa: </td>
              
            <td class="textoTitulo" width="46%">
            	<s:ComboTipoPessoa name="tipoPessoaAgregCombo" selectedValue='<%=sacBean.getTipoPessoaAgreg().equals(new Long(0)) ? "1":sacBean.getTipoPessoaAgreg().toString()%>'
            		onChange="javascript:limpaCpfCnpj(cpfCnpjAgregInput);"
            	 />
            
            </td>
              
            <td class="textoValor" width="11%">&nbsp; </td>
            	<td width="8%">&nbsp;</td>
            	<td width="23%">&nbsp;</td>
			</tr>
						
			<tr>
              
            <td class="textoTitulo" width="12%">CPF / CNPJ: </td>              
            <td class="textoTitulo" width="46%">
            	<p:InputCpfCnpj name="cpfCnpjAgregInput" value='<%=sacBean.getCpfCnpjAgregFormatado() %>' CLASS="inputtext" 
            	onBlur="javascript:formataCpfCnpj(this,tipoPessoaAgregCombo);"
            	onFocus="javascript:unFormataCpfCnpj(this,tipoPessoaAgregCombo);prevFocus(this);"
            	onKeyUp="javascript:nextFocus(event.keyCode, this, document.frmMain.tipoPessoaCombo);"
            	/>
            </td>              
            <td class="textoValor" width="11%">&nbsp; </td>
            	<td width="8%">&nbsp;</td>
            	<td width="23%">&nbsp;</td>
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
    	function formSubmit() {
        	if (validaSubmit()) {
				//cpf cnpj sacado        		
        		document.frmMain.cpfCnpj.value= document.frmMain.cpfCnpjInput.value;
				unFormataCpfCnpj(document.frmMain.cpfCnpj,document.frmMain.tipoPessoaCombo)
				//cpf cnpj agregado
        		document.frmMain.cpfCnpjAgreg.value= document.frmMain.cpfCnpjAgregInput.value;
				unFormataCpfCnpj(document.frmMain.cpfCnpjAgreg,document.frmMain.tipoPessoaAgregCombo)
				alteraTpPessoa();
				
	        	document.frmMain.submit();
        	}
        }
        function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.cpfCnpjInput, 'CPF / CNPJ')){
				  return false;
		    } else if(!validaCampoObrigatorio(document.frmMain.cpfCnpjAgregInput, 'CPF / CNPJ Agregado')) {
		    	  return false;
		    }	    
		    return true;
		}
		
		function alteraTpPessoa() {
			if (document.frmMain.tipoPessoaCombo.value == "1") {
				document.frmMain.tipoPessoa.value = "F";
				
			} else {
				document.frmMain.tipoPessoa.value = "J";
				
			}
			
			if (document.frmMain.tipoPessoaAgregCombo.value == "1") {
				document.frmMain.tipoPessoaAgreg.value = "F";
				
			} else {
				document.frmMain.tipoPessoaAgreg.value = "J";
				
			}
		}			
    
      /*function inicia(){
        loadMenus();
      }
      function formSubmit() {
        
		document.frmMain.action = "DDAincluirSacadoEletronicoAcao.html";
		document.frmMain.submit();
		
      }
      function validaInserir(){
        return true;
      }*/
    </script>
  </s:FormStrategy>  
</p:Document>
</html>
