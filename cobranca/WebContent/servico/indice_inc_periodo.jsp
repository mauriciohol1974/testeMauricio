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


<%
	
	IndiceBean indiceBean = (session.getAttribute(IndiceEstrategia.DATA_BEAN)==null?new IndiceBean():(IndiceBean)session.getAttribute(IndiceEstrategia.DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"	estrategia="<%=IndiceEstrategia.STRATEGY_PERIODO_FINALIZAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=IndiceEstrategia.PAGE_TITLE_INCLUIR_PERIODO%>"/>

 		<input type="hidden" name="sigla" value="<%=indiceBean.getSigla() %>" />
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

            <tr valign="top">
            	<td>
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
		                      <td class="textoTitulo" width="10%">Sigla: </td>
		                      <td class="textoValor" width="26%"> <%=indiceBean.getSigla()%></td>
		                     </tr>
		                     <tr>
		                      <td nowrap class="textoTitulo" width="10%">Data de Inicio: </td>
						      <td width="26%" class="textoValor"><p:InputDate name="dataInicio" CLASS="inputtext"/></td>
		                     </tr>
		                     <tr>
		                      <td class="textoTitulo" width="10%">Data de Fim:</td>
		                      <td class="textoValor" width="26%"><p:InputDate name="dataFim" CLASS="inputtext"/></td>
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
                 	<s:Button name="Voltar" action="javascript: formVoltar();"/>
                 	<s:Button name="Atualizar" action="javascript: formSubmit();"/>
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
			
			function formVoltar() {
				document.frmMain.estrategia.value="servico.ServIndiceConsultar";
				document.frmMain.fluxo.value = "voltar";
		        document.frmMain.submit();
		        
			}

    </script>
  </s:FormStrategy>
</p:Document>
</html>