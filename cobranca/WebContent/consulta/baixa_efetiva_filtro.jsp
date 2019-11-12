<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: hisced_manter_filtro.jsp - Java Server Pages
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 08/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BaixaEfetivaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.BaixaEfetivaEstrategia"%>


<%
BaixaEfetivaBean baixaBean = (session.getAttribute(BaixaEfetivaEstrategia.FILTRO_BEAN)==null?new BaixaEfetivaBean():(BaixaEfetivaBean)session.getAttribute(BaixaEfetivaEstrategia.FILTRO_BEAN));	
	
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=BaixaEfetivaEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='<%=BaixaEfetivaEstrategia.PAGE_TITLE_FILTRO%>'/>

		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
		  <tr>
              <td class="textoTitulo" width="17%">Número de Identificação: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" size="22" maxlength="19"	name="nuIdentificacao" onFocus="javascript: prevFocus(this);"/>
				</td>
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

				if(!validaCampoObrigatorio(document.frmMain.nuIdentificacao, "Número de Identificação")) {
					return false;
			  	}
			return true;
		}
		

    </script>
  </s:FormStrategy>
</p:Document>
</html>
