<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: lantari_manter_filtro.jsp - Java Server Pages
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 08/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.LancamentoTarifaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.LancamentoTarifaEstrategia"%>


<%
	LancamentoTarifaBean lancamentoTarifaBean = (session.getAttribute(LancamentoTarifaEstrategia.FILTRO_BEAN)==null?new LancamentoTarifaBean():(LancamentoTarifaBean)session.getAttribute(LancamentoTarifaEstrategia.FILTRO_BEAN));	
	lancamentoTarifaBean.setCodigoCedente(session.getAttribute(LancamentoTarifaEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(LancamentoTarifaEstrategia.CEDENTE_ATUAL));
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=LancamentoTarifaEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='Incluir Comando de Débito de Tarifas >> Filtro'/>

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" size="7" maxlength="7"	name="codigoCedente" 
 								 value='<%=lancamentoTarifaBean.getCodigoCedente().equals(new Long(0))?"":lancamentoTarifaBean.getCodigoCedente().toString()%>'
              	  onFocus="javascript: prevFocus(this);"                		                 
                  onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataInicial);"/>
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
				if(!validaCampoObrigatorio(document.frmMain.codigoCedente, "Cedente")) {
					return false;
			  }
		
			return true;
		}
		
    </script>
  </s:FormStrategy>
</p:Document>
</html>
