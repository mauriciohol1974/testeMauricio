<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servrej_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 25/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServRejEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean "%>

<%
	ConGerServicosSolicitadosBean filtroBean = (session.getAttribute(ServRejEstrategia.BEAN_FILTRO)==null? new ConGerServicosSolicitadosBean()
																			:(ConGerServicosSolicitadosBean)session.getAttribute(ServRejEstrategia.BEAN_FILTRO));

	filtroBean.setCodigoCedente(session.getAttribute(ServRejEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(ServRejEstrategia.CEDENTE_ATUAL));
%>


<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.ServRejManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Serviços Solicitações Rejeitadas >> Filtro"/>

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr>
            	<td class="textoTitulo" width="2%">
	              <input type="radio" name="tpFiltro" value="0" onclick="javascript:habilitaDigitacao();">
	            </td>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="26%"> 
                <p:InputNumerico name="codigoCedente" maxlength="7" size="7"  CLASS="inputtext" disabled="true" 
	              	  value='<%=filtroBean.getCodigoCedente().equals(new Long(0))?"":filtroBean.getCodigoCedente().toString()%>'
		              	onFocus="javascript: prevFocus(this);"
                		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataSolicitacao);"/>
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr>
            	<td class="textoTitulo" width="2%">
	              <input type="radio" name="tpFiltro" value="1" onclick="javascript:habilitaDigitacao();">
	            </td>
              <td class="textoTitulo" width="17%">PV Vinculação: </td>
              <td width="26%"> 
                <p:InputNumerico name="codigoUnidadePv" maxlength="4" size="5"  CLASS="inputtext" disabled="true" 
	              	  value='<%=filtroBean.getCodigoUnidadePv().equals(new Long(0))?"":filtroBean.getCodigoUnidadePv().toString()%>'
	              	  onFocus="javascript: prevFocus(this);"                		
                		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataSolicitacao);"/>
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>

            <tr>
            	<td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Data Solicitação: </td>
              <td width="26%">
              	<p:InputDate name="dataSolicitacao" CLASS="inputtext"
	              	  value='<%=filtroBean.getDataSolicitacaoFormatada()%>'
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
				<%//EAM - 22/08%>
				document.frmMain.tpFiltro[<%=filtroBean.getTpFiltro()%>].checked = true;
				habilitaDigitacao();
			}
      
      function formSubmit(){
      	if(validaSubmit()){
      		document.frmMain.submit();
      	}
      }

      function validaSubmit(){
      	if (!validaRadioButtonMsg(document.frmMain.tpFiltro, 'Tipo filtro', '041')) {
      		return false;
      	}else{
					if(document.frmMain.tpFiltro[0].checked){
			  		if (!validaCampoObrigatorio(document.frmMain.codigoCedente,'cedente')){
			 				return false;
			 			}
			  	}
			  	if(document.frmMain.tpFiltro[1].checked){
			     	if (!validaCampoObrigatorio(document.frmMain.codigoUnidadePv,'PV de Vinculacao')){
			 				return false;
			 			}
			    } 
			    if (!validaCampoObrigatorio(document.frmMain.dataSolicitacao,'data da solicitação')){
			 				return false;
			 		}
			 		if (!validaData(document.frmMain.dataSolicitacao,'data da solicitação')){
							<%//EAM 23/08
							//alert("Data de solicitação Invalida.");%>
							msg('014','Data Solicitação');							
							return false;		    
			    }
		    }
		    return true;
      }
      
      function habilitaDigitacao(){
     			if (document.frmMain.tpFiltro[0].checked) {
        			document.frmMain.codigoCedente.disabled = false;
							document.frmMain.codigoCedente.value = "<%=filtroBean.getCodigoCedente().equals( new Long(0))?"":filtroBean.getCodigoCedente().toString()%>";
        			document.frmMain.codigoUnidadePv.value ="";
        			document.frmMain.codigoUnidadePv.disabled = true;
        			
        			<%//EAM - 22/08 %>
        			document.frmMain.codigoCedente.focus();
        			
        	} else if (document.frmMain.tpFiltro[1].checked) {
        			document.frmMain.codigoCedente.value ="";
        			document.frmMain.codigoCedente.disabled = true;
        			document.frmMain.codigoUnidadePv.disabled = false;
        			
        			<%//EAM - 22/08 %>
        			document.frmMain.codigoUnidadePv.focus();

        	}
      }	 	  
 
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
