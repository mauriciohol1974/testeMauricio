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
<%@page import="br.gov.caixa.sigcb.bean.ReqRejeitadaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ReqRejeitadaEstrategia"%>


<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ReqRejeitadaEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=ReqRejeitadaEstrategia.PAGE_TITLE_FILTRO%>"/>    
 		
    
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">



           

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">
                <hr>
              </td>
            </tr>
            <tr>
            <td nowrap class="textoTitulo" width="10%">Data de Inicio: </td>
				<td class="textoValor" width="26%" nowrap>  <p:InputDate name="dtInicio"	 CLASS="inputtext"	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dtFim);"/> 
            </td>
            </tr>
            
            <tr>
            <td nowrap class="textoTitulo" width="10%">Data de Fim: </td>
				<td class="textoValor" width="26%" nowrap>  <p:InputDate name="dtFim"	 CLASS="inputtext"	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.sr);"/> 
            </td>
            </tr>


			<tr>
              <td class="textoTitulo" width="10%">SR: </td>
              <td colspan="2" width="26%"> 
                <p:InputNumerico name="sr" maxlength="4" size="5"	value='' CLASS="inputtext"	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.pv);"/>
              </td>
			</tr>
			
			<tr>
              <td class="textoTitulo" width="10%">PV de Vinculação: </td>
              <td colspan="2" width="26%"> 
                <p:InputNumerico name="pv" maxlength="4" size="5"	value='' CLASS="inputtext"	onFocus="javascript: prevFocus(this);"	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>
              </td>
			</tr>
						
            <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>

            <tr>
	            <td align="right" colspan="6">
		            <p align="center"> 
 		            	<s:Button name="Confirmar" action="javascript:formSubmit()"/>
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
		        document.frmMain.submit();
	    }
	    
    </script>
  </s:FormStrategy>
</p:Document>
</html>