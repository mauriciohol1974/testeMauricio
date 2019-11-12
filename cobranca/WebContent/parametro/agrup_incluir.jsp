<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: agrup_incluir.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 29/08/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.AgrupamentoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.AgrupEstrategia"%>

<%
	AgrupamentoBean agrupBean = (session.getAttribute(AgrupEstrategia.DATA_BEAN)==null?new AgrupamentoBean():(AgrupamentoBean)session.getAttribute(AgrupEstrategia.DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=AgrupEstrategia.STRATEGY_INCLUIR_SUCESSO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=AgrupEstrategia.PAGE_TITLE_INCLUIR%>"/>
		
		<input type="hidden" name = "codigoAgrupamento" value="<%=agrupBean.getCodigoAgrupamento()%>">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Agrupamento: </td>
              <td class="textoValor" width="26%"><%=agrupBean.getCodigoAgrupamento()%></td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Incluir Agrupamento de Serviços:
                <hr>
              </td>
            </tr>
            
            <tr>
							<td class="textoTitulo" width="17%">Descrição: </td>
							<td class="textoValor" nowrap width="26%"> 
                <p:InputAlfanumerico name="descricaoAgrupamento" maxlength="40" size="40" 
                	value="<%=agrupBean.getDescricaoAgrupamento()%>" CLASS="inputtext"
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>
							</td>
							<td class="textoTitulo" width="17%">&nbsp;</td>
				      <td class="textoTitulo" width="26%">&nbsp;</td>
						</tr>
				 	  <tr> 
							<td colspan="4">&nbsp;</td>
					  </tr>

            <tr>
	            <td align="right" colspan="4">
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
    <script>
			function inicia() {
				setFirstFieldFocus();
			}
	    function formSubmit() {
        if (validaSubmit()) {
	    		if (confirm(conf("100", "Agrupamento de Serviços"))) {
		        document.frmMain.submit();
		      }
        }
	    }
			function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.descricaoAgrupamento, 'Descrição Agrupamento')){
				  return false;
		    }
		    return true;
		  }
	    function formSubmit_Voltar() {
    		if (confirm(conf("103"))) {
           document.frmMain.estrategia.value = "<%=AgrupEstrategia.STRATEGY_INCLUIR_FILTRO%>";
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
        }
      }  
    </script>
  </s:FormStrategy>
</p:Document>
</html>