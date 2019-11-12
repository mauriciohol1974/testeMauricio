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
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ReqRejeitadaEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.ReqRejeitadaBean"%>


<%
	
	ReqRejeitadaBean reqRejBean = (session.getAttribute(ReqRejeitadaEstrategia.DATA_BEAN)==null?new ReqRejeitadaBean():(ReqRejeitadaBean)session.getAttribute(ReqRejeitadaEstrategia.DATA_BEAN));

%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"	estrategia="<%=ReqRejeitadaEstrategia.STRATEGY_LISTAR_MOTIVOS_TITULO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=ReqRejeitadaEstrategia.PAGE_TITLE_DETALHE_TITULO%>"/>

 		<input type="hidden" name="nuCtrlReq" value="<%= reqRejBean.getNuCtrlReq()%>" />
 		<input type="hidden" name="sr" value="<%=reqRejBean.getSr().toString() %>" />
 		<input type="hidden" name="pv" value="<%=reqRejBean.getPv().toString() %>" />
 		<input type="hidden" name="nuConvenio" value="<%=reqRejBean.getNuConvenio().toString() %>" />
 		<input type="hidden" name="nossoNumero" value="<%=reqRejBean.getNossoNumero().toString() %>" />
 		
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
		                      <td class="textoTitulo" width="17%">Número de Controle Requisição: </td>
		                      <td class="textoValor" width="26%"> <%=reqRejBean.getNuCtrlReq()%></td>
		                      <td class="textoTitulo" width="17%">Indicador de Erro: </td>
		                      <td class="textoValor" width="26%"><%=reqRejBean.getIcErro()%></td>
		                    </tr>
		                   	                    

		                    <tr>
		                      <td class="textoTitulo" width="17%">Código de Envio da Requisição: </td>
		                      <td class="textoValor" width="26%"> <%=reqRejBean.getCoEnvioReq()%></td>
		                      <td class="textoTitulo" width="17%">Data/Hora do Envio: </td>
		                      <td class="textoValor" width="26%"><%=reqRejBean.getTsEnvioReq()%></td>
		                    </tr>


		                    <tr>
		                      <td class="textoTitulo" width="17%">Código de Retorno da Requisição: </td>
		                      <td class="textoValor" width="26%"> <%=reqRejBean.getCoRetReq()%></td>
		                      <td class="textoTitulo" width="17%">Data/Hora do Retorno: </td>
		                      <td class="textoValor" width="26%"><%=reqRejBean.getTsRetReq()%></td>
		                    </tr>
		                    <tr>
		                      <td class="textoTitulo" width="17%">Número do Convênio do Beneficiário: </td>
		                      <td class="textoValor" width="26%"> <%=reqRejBean.getNuConvenio()%></td>
		                      <td class="textoTitulo" width="17%">Nosso Número: </td>
		                      <td class="textoValor" width="26%"><%=reqRejBean.getNossoNumero()%></td>
		                    </tr>	
		                    <tr>
		                      <td class="textoTitulo" width="17%">Segmento de Origem: </td>
		                      <td class="textoValor" width="26%"> <%=reqRejBean.getSgOrigem()%></td>
		                      <td class="textoTitulo" width="17%">Data/Hora Proc. Baixa Título: </td>
		                      <td class="textoValor" width="26%"><%=reqRejBean.getTsProcBaixa()%></td>
		                    </tr>	

		                    <tr>
		                      <td class="textoTitulo" width="17%">Código do Programa: </td>
		                      <td class="textoValor" width="26%"> <%=reqRejBean.getCoPrograma()%></td>
		                      <td class="textoTitulo" width="17%">Código da Transação: </td>
		                      <td class="textoValor" width="26%"><%=reqRejBean.getCoTransacao()%></td>
		                    </tr>
		                    
		                    <tr>
		                      <td class="textoTitulo" width="17%">SR: </td>
		                      <td class="textoValor" width="26%"> <%=reqRejBean.getSr()%></td>
		                      <td class="textoTitulo" width="17%">PV: </td>
		                      <td class="textoValor" width="26%"><%=reqRejBean.getPv()%></td>
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
                 	<%if (reqRejBean.getIcErro().equalsIgnoreCase("S")){%> 
                 	<s:Button name="Listar Motivos" action="javascript: formListar();"/>
                 	<%} %>
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
				document.frmMain.estrategia.value="<%=ReqRejeitadaEstrategia.STRATEGY_LISTAR_REQUISICOES_TITULO%>";
				document.frmMain.fluxo.value = "normal";
		        document.frmMain.submit();
		        
			}
			
			function formListar() {
				
		        document.frmMain.submit();
		        
			}

    </script>
  </s:FormStrategy>
</p:Document>
</html>