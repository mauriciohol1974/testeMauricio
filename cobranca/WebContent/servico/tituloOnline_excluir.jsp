<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: lantari_manter_filtro.jsp - Java Server Pages
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 08/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.LiquidacaoOnlineBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloOnLineEstrategia"%>


<%
	TituloBean tituloBean = (session.getAttribute(TituloOnLineEstrategia.FILTRO_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(TituloOnLineEstrategia.DATA_BEAN));	
	
	CedenteCabecaBean cedCabBean = (session.getAttribute(TituloOnLineEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TituloOnLineEstrategia.CEDENTE_CABECALHO_BEAN));
	
	
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=TituloOnLineEstrategia.STRATEGY_MANTER_ACAO_EXCLUIR_EXECUTAR%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='<%=TituloOnLineEstrategia.PAGE_TITLE_MANTER_EXCLUIR%>'/>
	
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getCodigoCedente().equals( new Long(0))?"":tituloBean.getCodigoCedente().toString()%>               
              </td>
            </tr>
            <tr>
               	<td class="textoTitulo" width="17%">Nosso Número: </td>
				<td class="textoValor" width="26%" nowrap><%=tituloBean.getNossoNumeroLiq().equals(new Long(0))?"":tituloBean.getNossoNumeroLiq().toString()%>
                </td>
                <td nowrap class="textoTitulo" width="17%">Data de Vencimento: </td>
				<td class="textoValor" width="26%" nowrap> <%=tituloBean.getPrinciDataVencimentoFormatada()%> 
                 </td>
            </tr>
            <tr>
             	<td nowrap class="textoTitulo" width="17%">Valor do Documento: </td>
				<td class="textoValor" width="26%" nowrap><%=tituloBean.getLiquiValorDocumento().toString().equals("R$ 0,00")?"":tituloBean.getLiquiValorDocumento().toString()%> 
                </td>
                <td nowrap class="textoTitulo" width="17%">Fator de Vencimento: </td>
				<td class="textoValor" width="26%" nowrap><%=tituloBean.getFatorVencimento().equals(new Long(0))?"":tituloBean.getFatorVencimento().toString()%>
				 </td> 
            </tr>
            
            <tr>
            	   <td class="textoTitulo" width="17%">Meio de Entrada: </td>
                   <td class="textoValor" width="26%"><%=tituloBean.getDescrMeio()%>
                   </td>
                   <td class="textoTitulo" width="17%">Forma de Pagamento: </td>
                   <td class="textoValor" width="26%"><%=tituloBean.getDescrFormaPagamento()%>
                   </td>
                   
            </tr>
           
			<tr>
				      <td nowrap class="textoTitulo" width="17%">Data do Pagamento: </td>
				      <td class="textoValor" width="26%" nowrap> 
        				       <%=tituloBean.getLiquiDataPagamentoFormatada()%> 
 					  <td nowrap class="textoTitulo" width="17%">NSU: </td>
				      <td class="textoValor" width="26%" nowrap> <%=tituloBean.getNsu().equals(new Long(0))?"":tituloBean.getNsu().toString()%>
					 </td>							
                
			
			</tr>
			
			<tr>
			
				      <td nowrap class="textoTitulo" width="17%">Valor Recebido: </td>
				      <td class="textoValor" width="26%" nowrap><%=tituloBean.getLiquiValorLiquidoRecebido().toString().equals("R$ 0,00")?"":tituloBean.getLiquiValorLiquidoRecebido().toString()%> 
                 </td>
			</tr>  
			
			<tr>
			
				      <td nowrap class="textoTitulo" width="17%">Linha Digitável:</td>
				      <td class="textoValor" width="26%" nowrap colspan="3"><%=tituloBean.getCodBarras1()%>&nbsp;
        				       	<%=tituloBean.getCodBarras2()%>&nbsp;
        				       	<%=tituloBean.getCodBarras3()%>&nbsp;
        				       	<%=tituloBean.getCodBarras4()%>&nbsp;
        				       	<%=tituloBean.getCodBarras5()%>&nbsp;
                 	  
                 	  </td>
                 
			</tr> 
			
			<tr>
			       <td class="textoTitulo" width="17%">Motivo:</td>
                   <td class="textoValor" width="26%" colspan="2"><%=tituloBean.getDescrMotivo()%>
                   </td>
			</tr>	
			
			<tr>
				 <td class="textoTitulo" width="17%">Observações:</td>
                   <td class="textoValor" width="26%" colspan="3">
                   <%=tituloBean.getObservacoes()%>	
                   </td>
			
			</tr>	
			
			<tr>
				      <td nowrap class="textoTitulo" width="17%">Data Situação: </td>
				      <td class="textoValor" width="26%" nowrap> 
        				       <%=tituloBean.getDtGarantia()%> 
 					  <td nowrap class="textoTitulo" width="17%">Descrição Situação: </td>
				      <td class="textoValor" width="26%" nowrap> <%=tituloBean.getDescrSituacao()%>
					 </td>							
                
			
			</tr>
			
			<tr>
				      <td nowrap class="textoTitulo" width="17%">Usuário: </td>
				      <td class="textoValor" width="26%" nowrap> 
        				       <%=tituloBean.getCoUsuario()%> 
 					  <td nowrap class="textoTitulo" width="17%">Erro: </td>
				      <td class="textoValor" width="26%" nowrap> <%=tituloBean.getCoErro()%>&nbsp;<%=tituloBean.getDeErro() %>
					 </td>							
                
			
			</tr>
				         
           
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr>
            	<td colspan="4" align="center">
            	  <s:Button name="Excluir" action="javascript:excluir();"/>
            	  <s:Button name="Voltar" action="javascript:voltar();"/>
            	</td>
            </tr>
            
          </table>
          </td>
         </tr>
      		

          </table>

    <script>
    function inicia(){
				setFirstFieldFocus();
      }

		
		function voltar() {
			
			document.frmMain.fluxo.value = "voltar";
			document.frmMain.estrategia.value="<%= TituloOnLineEstrategia.STRATEGY_MANTER_LISTAR%>"
		  	document.frmMain.submit();
			
		}
			

		function excluir() {
			
			if (confirm("Deseja realizar a exclusão?")) {
				document.frmMain.submit();
			}
			
		}

	
		
    </script>
  </s:FormStrategy>
</p:Document>
</html>
