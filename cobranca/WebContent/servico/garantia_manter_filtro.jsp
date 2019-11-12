<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: tarifa_manter_filtro.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 18/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituGarantiaEstrategia"%>

<%
TituloBean tituloBean = (session.getAttribute(TituGarantiaEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(TituGarantiaEstrategia.DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TituGarantiaEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TituGarantiaEstrategia.PAGE_TITLE_FILTRO%>"/>

		<input type="hidden" name = "caller" value="filtro">
		<input type="hidden" name = "descricaoTarifa" value="">		

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="26%"> 
	              <p:InputNumerico name="codigoCedente" maxlength="7" size="7" 
                	CLASS="inputtext" 
                	onFocus="javascript: prevFocus(this);"
									onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataSolicitacao);"/>
              </td>
              
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>

            <tr> 

              <td class="textoTitulo" width="17%">Nosso Número Inicial: </td>
              <td class="textoValor" width="26%">
              	   <p:InputNumerico name="nossoNumero" maxlength="17" size="23" 
                	CLASS="inputtext" 
                	onFocus="javascript: prevFocus(this);"	/>
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoTitulo" width="26%">&nbsp;</td>
			</tr>
			
			
			<tr> 

              <td class="textoTitulo" width="17%">Nosso Número Final: </td>
              <td class="textoValor" width="26%">
              	   <p:InputNumerico name="nossoNumeroFim" maxlength="17" size="23" 
                	CLASS="inputtext" 
                	onFocus="javascript: prevFocus(this);"	/>
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoTitulo" width="26%">&nbsp;</td>
			</tr>	
			
			<tr> 
              <td class="textoTitulo" width="17%">Classificado por: </td>
              <td class="textoTitulo" width="26%">
              <s:ComboClassificacaoTitulo name="classificacao"	/>
			  </td>
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
      
      function formSubmit(){
    	  document.frmMain.submit();
      }
	   
    </script>
  </s:FormStrategy>
</p:Document>
</html>