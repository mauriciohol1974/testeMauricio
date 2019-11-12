<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: mcextra_manter_filtro.jsp - Java Server Pages
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
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.MCExtraEstrategia" %>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
	ConGerMovimentoCedenteBean filtroBean = (session.getAttribute(MCExtraEstrategia.BEAN_FILTRO)==null? new ConGerMovimentoCedenteBean()
																			:(ConGerMovimentoCedenteBean)session.getAttribute(MCExtraEstrategia.BEAN_FILTRO));
	filtroBean.setCodigoCedente(session.getAttribute(MCExtraEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(MCExtraEstrategia.CEDENTE_ATUAL));																			
%>



<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=MCExtraEstrategia.STRATEGY_FILTRO%>" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Movimento do Cedente (Extrato) >> Filtro"/>
 		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">

						<tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"> 
              	<p:InputNumerico name="codigoCedente" maxlength="7" size="7" CLASS="inputtext" value="<%=Util.toStr(filtroBean.getCodigoCedente())%>" 
	       						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataEmissao);"/>       
              </td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            </tr>
              <td class="textoTitulo" width="17%">Data: </td>
              <td class="textoValor" width="26%">
              	<p:InputDate name="dataEmissao" CLASS="inputtext"
	       						value='<%=filtroBean.getDataEmissaoFormatada().equals("")?"":filtroBean.getDataEmissaoFormatada()%>'
	       						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
              </td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
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
        if (validaSubmit()) {
	        document.frmMain.submit();
        }
      }

			function validaSubmit(){
				if(!validaCampoObrigatorio(document.frmMain.codigoCedente,'Cedente')){
					return false;
				}
				if(!validaCampoObrigatorio(document.frmMain.dataEmissao, 'Data')) {
					return false;
				}
				if(document.frmMain.dataEmissao.value != ''){
					if(!validaData(document.frmMain.dataEmissao)) {
						msg('014','Data');
						return false;
					}
				}
				return true;
			}
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
