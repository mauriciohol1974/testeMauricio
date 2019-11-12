<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: titalte_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 10/11/2004 - v1
************************************************/
%>

<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TitAlteEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerTitulosAlteradosBean "%>

<%
	ConGerTitulosAlteradosBean filtroBean = (session.getAttribute(TitAlteEstrategia.BEAN_FILTRO)==null? new ConGerTitulosAlteradosBean()
																			:(ConGerTitulosAlteradosBean)session.getAttribute(TitAlteEstrategia.BEAN_FILTRO));
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=TitAlteEstrategia.STRATEGY_FILTRO%>" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=TitAlteEstrategia.TITLE%>"/>
 		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Unidade PV: </td>
              <td width="26%"> 
                <p:InputNumerico name="codigoUnidadePv" maxlength="4" size="5"  CLASS="inputtext" 
	              	  value='<%=filtroBean.getCodigoUnidadePv().equals(new Long(0))?"":filtroBean.getCodigoUnidadePv().toString()%>'
	              	  onFocus="javascript: prevFocus(this);"                		
	                	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataComando);"/>
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr> 
              <td class="textoTitulo" width="17%">Data Comando: </td>
              <td width="26%"> 
								<p:InputDate name="dataComando" CLASS="inputtext"
										value='<%=filtroBean.getDataComandoFormatada()%>'
	              	  onFocus="javascript: prevFocus(this);"                		
                		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
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
     	
     	function inicia() {
				setFirstFieldFocus();
			}
      
      function formSubmit(){
      	if(validaSubmit()){
      		document.frmMain.submit();
      	}
      }

      function validaSubmit(){
		    if (!validaCampoObrigatorio(document.frmMain.codigoUnidadePv,'Unidade Pv')){
					return false;		    
		    }
		    if (!validaCampoObrigatorio(document.frmMain.dataComando,'data comando')){
		    	return false;
		    }
		    return true;
      }
      
    </script>
   </s:FormStrategy>
	</p:Document>
</html>