
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.CepBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.ConsultaCEPEstrategia"%>

<%
	
CepBean cep = (session.getAttribute(ConsultaCEPEstrategia.DATA_BEAN)==null?new CepBean():(CepBean)session.getAttribute(ConsultaCEPEstrategia.DATA_BEAN));	

	//Long filtroSelecao = tituloBean.getFiltroSelecao()==null?new Long(1):tituloBean.getFiltroSelecao();
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ConsultaCEPEstrategia.STRATEGY_INICIAR%>"  
		fluxo="normal">
		<s:Menu/>

		
		<table CELLSPACING='0' CELLPADDING='0' width='98%' border='0' align='center' valign='middle'>
		<tr>
          <td>&nbsp;
		  </td>
        </tr>
        <tr>
          <td valign='top' align='left' style='background-repeat:no-repeat'
              background='/cobrancastatic/imagens/diversos/baseTitulo.gif'>
        		<h3>CONSULTA DE CEP: <%=cep.getCepFormatado() %></h2>
		  </td>
        </tr>
      </table>
		

		
		
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
            	 <td class="textoTitulo" width="17%">Endereco: </td>
               	 <td class="textoValor" width="26%"><%=cep.getEndereco() %></td>
            </tr>
			<tr> 
            	 <td class="textoTitulo" width="17%">Bairro: </td>
               	 <td class="textoValor" width="26%"><%=cep.getBairro() %></td>
            </tr>
			<tr> 
            	 <td class="textoTitulo" width="17%">Município: </td>
               	 <td class="textoValor" width="26%"><%=cep.getMunicipio() %></td>
            </tr>
			<tr> 
            	 <td class="textoTitulo" width="17%">Estado: </td>
               	 <td class="textoValor" width="26%"><%=cep.getUf() %></td>
            </tr>
			
			
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			
	          <tr>
	            <td align="right" colspan="4">
	              <p align="center"> 
 		            	<s:Button name="Ok" action="javascript:formSubmit()"/>
	              </p>
	            </td>
	          </tr>
          </table>
        </td>
      </tr>
    </table>
    <script>
			function inicia() {
				setFirstFieldFocus();
				
			}


			

			
	    function formSubmit() {
   	    	document.frmMain.submit();
		}
	    

			
    </script>
  </s:FormStrategy>
</p:Document></html>
