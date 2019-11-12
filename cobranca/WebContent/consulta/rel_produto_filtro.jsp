

<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ConsRelatorioEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.RelatorioBean "%>

<%
	RelatorioBean filtroBean = (session.getAttribute(ConsRelatorioEstrategia.BEAN_FILTRO)==null? new RelatorioBean()
																			:(RelatorioBean)session.getAttribute(ConsRelatorioEstrategia.BEAN_FILTRO));
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=ConsRelatorioEstrategia.STRATEGY_FILTRO_LISTAR%>" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=ConsRelatorioEstrategia.PAGE_TITLE_FILTRO_PRODUTO%>"/>
 		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Produto: </td>
              <td width="26%"> 
              	<select name="produto">
              		<option value="2">COBRANÇA SEM REGISTRO</option>
              		<option value="1">COBRANÇA SIMPLES</option>
              		<option value="3">COBRANÇA CAUCIONADA</option>
              		<option value="4">COBRANÇA DE TERCEIROS</option>
              	</select>
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr> 
              <td class="textoTitulo" width="17%">Data Movimento: </td>
              <td width="26%"> 
								<p:InputDate name="data" CLASS="inputtext"		
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
              <td class="textoTitulo" width="17%">Opção: </td>
              <td width="26%"> 
               	<select name="opcao">
              		<option value="1" selected="selected">Analitico</option>
              		<option value="2">Consolidado</option>
              		
              	</select>
              </td>
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
      		if (document.frmMain.opcao.value=="1"){
      			
      		}else{
      			document.frmMain.estrategia.value="<%=ConsRelatorioEstrategia.STRATEGY_FILTRO_CONSOLIDADO%>"
      		}
      		document.frmMain.submit();
      	}
      }

      function validaSubmit(){
		    if (!validaCampoObrigatorio(document.frmMain.produto,'Produto')){
					return false;		    
		    }
		    if (!validaCampoObrigatorio(document.frmMain.data,'Data')){
		    	return false;
		    }
		    return true;
      }
      
    </script>
   </s:FormStrategy>
	</p:Document>
</html>