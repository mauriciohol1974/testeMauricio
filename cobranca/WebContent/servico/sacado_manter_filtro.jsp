<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: sacado_manter_filtro.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 06/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.SacadoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.SacadoEstrategia"%>

<%
	SacadoBean sacadoBean = (session.getAttribute(SacadoEstrategia.FILTRO_BEAN)==null?new SacadoBean():(SacadoBean)session.getAttribute(SacadoEstrategia.FILTRO_BEAN));
	sacadoBean.setCodigoCedente(session.getAttribute(SacadoEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(SacadoEstrategia.CEDENTE_ATUAL));
%>

<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=SacadoEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=SacadoEstrategia.PAGE_TITLE_MANTER_FILTRO%>"/>    
		<input type="hidden" name ="cpfCnpjSacado" value=''>
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="26%"> 
	              <p:InputNumerico name="codigoCedente" maxlength="7" size="7" 
	                	CLASS="inputtext" value='<%=sacadoBean.getCodigoCedente().equals( new Long(0))?"":sacadoBean.getCodigoCedente().toString()%>' 
	                	onFocus="javascript: configuraCampoDependente(this); prevFocus(this);"
										onKeyUp="javascript: configuraCampoDependente(this); nextFocus(event.keyCode, this, document.frmMain.codigoBancoSacado);"
										onBlur="javascript: configuraCampoDependente(this);"/>		
              </td>
              </td>
            	<td width="20%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Número Banco de Sacados: </td>
              <td class="textoTitulo" width="36%">
	              <p:InputNumerico name="codigoBancoSacado" maxlength="3" size="3" 
	                	CLASS="inputtext" value='<%=sacadoBean.getCodigoBancoSacado().equals( new Long(0))?"":sacadoBean.getCodigoBancoSacado().toString()%>' 
	                	onFocus="javascript: configuraCampoDependente(this); prevFocus(this);"
										onKeyUp="javascript: configuraCampoDependente(this); nextFocus(event.keyCode, this, document.frmMain.tipoPessoaSacado);"
										onBlur="javascript: configuraCampoDependente(this);"/>			
										(Deixe em Branco para obter todos)
              </td>
            	<td width="20%">&nbsp;</td>
						</tr>
            <tr>
              <td class="textoTitulo" width="17%">CPF/CNPJ Sacado: </td>
              <td class="textoTitulo" nowrap width="36%">
                <s:ComboTipoPessoa name="tipoPessoaSacado" selectedValue='<%=sacadoBean.getTipoPessoaSacado().equals(new Long(0))?"0":sacadoBean.getTipoPessoaSacado().toString()%>'
                		branco="true" brancoValue="0" 
                		onChange="javascript:limpaCpfCnpj(cpfCnpjSacadoInput); configuraCampoDependente(this); configuraCampoDependente(cpfCnpjSacadoInput)"
                />
				        <p:InputCpfCnpj name="cpfCnpjSacadoInput"
				         		value='<%=sacadoBean.getCpfCnpjSacadoFormatado()%>' CLASS="inputtext" 
				         		onBlur="javascript:configuraCampoDependente(this); formataCpfCnpj(this,tipoPessoaSacado);" 
				         		onFocus="javascript: configuraCampoDependente(this); unFormataCpfCnpj(this,tipoPessoaSacado);prevFocus(this);"
				            onKeyUp="javascript: configuraCampoDependente(this); nextFocus(event.keyCode, this, document.frmMain.codigoSacado);"/>
										(Deixe em Branco para obter todos)
              </td>
            	<td width="20%">&nbsp;</td>
						</tr>
            <tr>
              <td class="textoTitulo" width="17%">Código Sacado: </td>
              <td class="textoTitulo" width="36%"> 
	              <p:InputAlfanumerico name="codigoSacado" maxlength="15" size="20" 
	                	CLASS="inputtext" value='<%=sacadoBean.getCodigoSacado()%>' 
	                	onFocus="javascript: configuraCampoDependente(this); prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"
										onBlur="javascript: configuraCampoDependente(this);"/>	
              			(Deixe em Branco para obter todos)
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
				configuraCampoDependente(document.frmMain.codigoCedente);
				configuraCampoDependente(document.frmMain.codigoBancoSacado);
				configuraCampoDependente(document.frmMain.tipoPessoaSacado);
				configuraCampoDependente(document.frmMain.cpfCnpjSacadoInput);
      }
		  function configuraCampoDependente(campo){
		  	if(campo == document.frmMain.codigoCedente){		  
					if(window.event.type == "keyup"){
			  		habilitaCampoDependente(campo,document.frmMain.codigoBancoSacado);
			  	}
					else{
						desabilitaCampoDependente(campo, campo, document.frmMain.codigoBancoSacado);
						desabilitaCampoDependente(campo, campo, document.frmMain.tipoPessoaSacado);
						desabilitaCampoDependente(campo, campo,document.frmMain.cpfCnpjSacadoInput );
						desabilitaCampoDependente(campo, campo, document.frmMain.codigoSacado);
					}
		  	}	
		  	
		  	if(campo == document.frmMain.codigoBancoSacado){
					if(window.event.type == "keyup" && window.event.keyCode != 9){
			  		habilitaCampoDependente(campo,document.frmMain.tipoPessoaSacado);
					}
					else{
						desabilitaCampoDependente(campo, campo, document.frmMain.tipoPessoaSacado);
						desabilitaCampoDependente(campo, campo,document.frmMain.cpfCnpjSacadoInput );
						desabilitaCampoDependente(campo, campo, document.frmMain.codigoSacado);
					}
		  	}
		  	
		  	if(campo == document.frmMain.tipoPessoaSacado){
					if(campo.value != "0"){
		  			habilitaCampoDependente(campo,document.frmMain.cpfCnpjSacadoInput);
					}
					desabilitaCampoDependente(campo, campo,document.frmMain.cpfCnpjSacadoInput );
					desabilitaCampoDependente(campo, campo, document.frmMain.codigoSacado);

		  	}
		  	
		  	if(campo == document.frmMain.cpfCnpjSacadoInput){
					
					if(window.event.type == "keyup"){
						habilitaCampoDependente(campo,document.frmMain.codigoSacado);
					}
					else{
						desabilitaCampoDependente(campo, campo, document.frmMain.codigoSacado);
					}
		  	}
		  
		  }

	    function formSubmit() {
        if (validaSubmit()) {
					document.frmMain.cpfCnpjSacado.value= document.frmMain.cpfCnpjSacadoInput.value;
					unFormataCpfCnpj(document.frmMain.cpfCnpjSacado,document.frmMain.tipoPessoaSacado)
	        document.frmMain.submit();
        }
			}
			function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.codigoCedente, 'Cedente')){
				  return false;
		    }
		    if(document.frmMain.tipoPessoaSacado.value != 0){
		    	if(!validaCampoObrigatorio(document.frmMain.cpfCnpjSacadoInput, 'CPF/CNPJ Sacado')){
				  	return false;
		    	}
		    }
		    if(document.frmMain.cpfCnpjSacadoInput.value != ""){
			    if(!validaComboObrigatorio(document.frmMain.tipoPessoaSacado, 'Tipo de Pessoa do Sacado')){
					  return false;
			    }
			    if(!validaDvCpfCnpj(document.frmMain.cpfCnpjSacadoInput,document.frmMain.tipoPessoaSacado)){
						msg('008','CPF/CNPJ Sacado');
				    return false;
					}
		    }		    		    
		    return true;
		  }
    </script>
  </s:FormStrategy>
</p:Document>
</html>
