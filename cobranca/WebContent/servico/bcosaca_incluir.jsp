<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: bcosaca_incluir.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 05/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BancoSacadoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BancoSacadoEstrategia"%>

<%
	BancoSacadoBean bancoSacadoBean = (session.getAttribute(BancoSacadoEstrategia.DATA_BEAN)==null?new BancoSacadoBean():(BancoSacadoBean)session.getAttribute(BancoSacadoEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(BancoSacadoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BancoSacadoEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=BancoSacadoEstrategia.STRATEGY_INCLUIR_FINALIZAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=BancoSacadoEstrategia.PAGE_TITLE_INCLUIR%>"/>    
 		<input type="hidden" name = "codigoCedente" value="<%=bancoSacadoBean.getCodigoCedente()%>">
 		<input type="hidden" name = "codigoBancoSacado" value="<%=bancoSacadoBean.getCodigoBancoSacado()%>">
    
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=bancoSacadoBean.getCodigoCedenteFormatado()%></td>
  
                <td class="textoTitulo" width="17%">Nome Cedente: </td>
  	            <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 

              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
  
              <td class="textoTitulo" width="17%">Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=bancoSacadoBean.getCodigoBancoSacado()%></td>
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Incluir Banco de Sacados:
                <hr>
              </td>
            </tr>
            
						<tr>
              <td class="textoTitulo" width="17%">Nome: </td>
              <td colspan="2" width="26%"> 
                <p:InputAlfanumerico name="nomeBancoSacado" maxlength="20" size="30" 
                	value='<%=bancoSacadoBean.getNomeBancoSacado().trim()%>' CLASS="inputtext"
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>
              </td>
						</tr>
						
            <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>

            <tr>
	            <td align="right" colspan="6">
		            <p align="center"> 
 		            	<s:Button name="Confirmar" action="javascript:formSubmit()"/>
		            	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
	              </p>
	            </td>
	          </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    <script language="javascript">
	    function inicia(){
				setFirstFieldFocus();
	    }
	    function formSubmit() {
        if (validaSubmit()) {
	    		if (confirm(conf("100", "Banco de Sacados"))) {
		        document.frmMain.submit();
		      }
        }
	    }
	    function formSubmit_Voltar() {
    		if (confirm(conf("103"))) {
           document.frmMain.estrategia.value = "<%=BancoSacadoEstrategia.STRATEGY_INCLUIR_INICIAR%>";
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
        }
      }  

			function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.nomeBancoSacado, 'Nome')){
				  return false;
		    }
		    return true;
		  }
    </script>
  </s:FormStrategy>
</p:Document>
</html>