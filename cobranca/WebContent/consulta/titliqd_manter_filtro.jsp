<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: titliqd_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 05/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosDiaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TitLiqDManterEstrategia" %>

<%
	ConGerTitulosLiquidadosDiaBean filtroBean = (session.getAttribute(TitLiqDManterEstrategia.FILTRO_BEAN)==null? new ConGerTitulosLiquidadosDiaBean()
																			:(ConGerTitulosLiquidadosDiaBean)session.getAttribute(TitLiqDManterEstrategia.FILTRO_BEAN));

	filtroBean.setCodigoCedente(session.getAttribute(TitLiqDManterEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(TitLiqDManterEstrategia.CEDENTE_ATUAL));
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.TitLiqDManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Títulos Liquidados no Dia >> Filtro"/>
 		
 		<input type="hidden" name="tpConsulta" value=""> 
        
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="radioTpConsulta" onclick="javascript:habilitaDigitacao();">
              </td>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoTitulo" width="36%">
                <p:InputNumerico name="codigoCedente" disabled="true" maxlength="7" size="7" CLASS="inputtext"
	              	  onFocus="javascript: prevFocus(this);"                		
                		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
              </td>
            	<td width="20%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="radioTpConsulta" onclick="javascript:habilitaDigitacao();">
              </td>
              <td class="textoTitulo" width="17%">Unidade de Vinculação: </td>
              <td class="textoTitulo" width="36%">
                <p:InputNumerico name="unidadeVinculacao" disabled="true" maxlength="4" size="7" CLASS="inputtext"
	              	  onFocus="javascript: prevFocus(this);"                		
                		onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
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
        //EAM 15/09
        document.frmMain.radioTpConsulta[<%=filtroBean.getTpConsulta().toString()%>].checked = true;
        habilitaDigitacao();
      }
      
      function formSubmit() {
      	if (validaFiltro()){
        	document.frmMain.submit();
        }
      }
      
      function validaFiltro(){
      	if(document.frmMain.radioTpConsulta[0].checked){
      		if(validaCampoObrigatorio(document.frmMain.codigoCedente,'Cedente')){
      			document.frmMain.tpConsulta.value = 0;
      			return true;
      		}
      	} else {
      		if(validaCampoObrigatorio(document.frmMain.unidadeVinculacao,'Unidade de Vinculação')){
      			document.frmMain.tpConsulta.value = 1;
      			return true;
      		}
      	}
      	return false;
      }
      
      
      function habilitaDigitacao(){
     		if (document.frmMain.radioTpConsulta[0].checked) {
     			document.frmMain.codigoCedente.value	= '<%=filtroBean.getCodigoCedente().equals( new Long(0))?"":filtroBean.getCodigoCedente().toString()%>';
        	document.frmMain.codigoCedente.disabled = false;  			
        	document.frmMain.unidadeVinculacao.value ="";
        	document.frmMain.unidadeVinculacao.disabled = true;
        	//EAM 15/09
        	
        	document.frmMain.codigoCedente.focus();
      
        } else {
					document.frmMain.unidadeVinculacao.value ="";
        	document.frmMain.unidadeVinculacao.disabled = false;
        	document.frmMain.codigoCedente.value ="";
        	document.frmMain.codigoCedente.disabled = true;
        	//EAM 15/09
					document.frmMain.unidadeVinculacao.value='<%=filtroBean.getUnidadeVinculacao().equals(new Long(0))?"":filtroBean.getUnidadeVinculacao().toString()%>'
        	document.frmMain.unidadeVinculacao.focus();
        }
      }	 	  
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
