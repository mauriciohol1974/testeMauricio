<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: sacado_incluir.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 07/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.IndiceEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.IndiceBean"%>
<%@page import="java.util.ArrayList" %>


<%
	
	IndiceBean indiceBean = (session.getAttribute(IndiceEstrategia.DATA_BEAN)==null?new IndiceBean():(IndiceBean)session.getAttribute(IndiceEstrategia.DATA_BEAN));
	ArrayList listaIndice = (ArrayList) session.getAttribute("cmbIndice");
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"	estrategia="<%=IndiceEstrategia.STRATEGY_CONSULTAR_PERIODO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Consulta Índice por Período"/>

 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

            <tr valign="top">
                <hr>
              </td>
            </tr>

			<tr>
              	<td colspan="4">
                	<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
	                    <tr>
	                      <td colspan="4">&nbsp;</td>
	                    </tr>
		                    <tr>
		                      <td class="textoTitulo" width="5%">Indice: </td>
		                      <td class="textoValor" width="26%">
		                      <select name="sigla"> 
		                      	<%for (int i=0;i<listaIndice.size();i++){ 
		                      		 IndiceBean cmbIndice = (IndiceBean) listaIndice.get(i) ; %>
		                      			<option value="<%=cmbIndice.getSigla() %>"><%=cmbIndice.getSigla()%> </option>
		                      	<%} %>
		                      </select>
		                      </td>
		                     </tr>
		                     <tr>
	                      		<td colspan="4">&nbsp;</td>
	                    	 </tr>
		                     <tr>
		                     	  <td class="textoTitulo" width="5%">Período de: </td>
							 	  <td class="textoTitulo" colspan="3" >
				   				        <p:InputDate name="dataInicio" 
				           						CLASS="inputtext"
				           						onFocus="javascript: prevFocus(this);"
												onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataFim);"/> 
											
											até
				   				        <p:InputDate name="dataFim" 
				           						CLASS="inputtext"
				           						onFocus="javascript: prevFocus(this);"
												onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
									</td>
		                     </tr>
		                    
                  	</table>
				</td>
            </tr>
            <tr>
	            <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
	            <td align="right" colspan="4">
  	            <p align="center">
                 	<s:Button name="Consultar" action="javascript: formSubmit();"/>
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
			
			function formSubmit() {
				
				        document.frmMain.submit();
				        
			}

    </script>
  </s:FormStrategy>
</p:Document>
</html>