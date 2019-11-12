<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: vallanc_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 04/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ConGerValLancadosBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ValLancManterEstrategia" %>

<%
	ConGerValLancadosBean valLancBean = (session.getAttribute(ValLancManterEstrategia.FILTRO_BEAN)==null? new ConGerValLancadosBean()
																				:(ConGerValLancadosBean)session.getAttribute(ValLancManterEstrategia.FILTRO_BEAN));

	valLancBean.setCodigoCedente(session.getAttribute(ValLancManterEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(ValLancManterEstrategia.CEDENTE_ATUAL));
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.ValLancManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Lançamentos em Conta Corrente >> Filtro"/>
        
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="26%"> 
                <p:InputNumerico name="codigoCedente" maxlength="7" size="7" CLASS="inputtext" value='<%=valLancBean.getCodigoCedente().equals( new Long(0))?"":valLancBean.getCodigoCedente().toString()%>'
	              	  onFocus="javascript: prevFocus(this);"                		
                		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
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
      }
      
      function formSubmit() {
        if (validaInserir()) {
	        document.frmMain.submit();
        }
      }
      
      function validaInserir(){
        if(validaCampoObrigatorio(document.frmMain.codigoCedente,'Cedente')){
        	return true;
        }else{
        	return false;
        }
      }
      
    </script>
   </s:FormStrategy>
	</p:Document>
</html>