<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: mctotai_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 12/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.ConGerMovimentoCedenteBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.MCTotaiEstrategia" %>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
	ConGerMovimentoCedenteBean filtroBean = (session.getAttribute(MCTotaiEstrategia.BEAN_FILTRO)==null? new ConGerMovimentoCedenteBean()
																			:(ConGerMovimentoCedenteBean)session.getAttribute(MCTotaiEstrategia.BEAN_FILTRO));
	filtroBean.setCodigoCedente(session.getAttribute(MCTotaiEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(MCTotaiEstrategia.CEDENTE_ATUAL));
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=MCTotaiEstrategia.STRATEGY_FILTRO%>" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Movimento do Cedente (Totais) >> Filtro"/>
        
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" colspan="3" width="26%"> 
                <p:InputNumerico name="codigoCedente" maxlength="7" size="7"  CLASS="inputtext" value="<%=Util.toStr(filtroBean.getCodigoCedente())%>" 
	       						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.periodo);"/>                 
              </td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Período: </td>
              <td class="textoValor" width="26%"> 
              	<s:ComboPeriodo name="periodo" 
	              	selectedValue='<%=filtroBean.getPeriodo().equals(new Long(0))?"1":filtroBean.getPeriodo().toString()%>'/>
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
				if(validaSubmit()){
					document.frmMain.submit();
				}
      }
      
      function validaSubmit(){
      	if(!validaCampoObrigatorio(document.frmMain.codigoCedente,'Cedente')){
      		return false;
      	}
      	return true;
      }
      
    </script>    
    </s:FormStrategy>
	</p:Document>
</html>
