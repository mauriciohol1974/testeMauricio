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
<%@page import="br.gov.caixa.sigcb.bean.TrilhaAuditoriaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TrilhaAuditoriaEstrategia"%>


<%
	TrilhaAuditoriaBean trilhaAudit = (session.getAttribute(TrilhaAuditoriaEstrategia.DATA_BEAN)==null? new TrilhaAuditoriaBean():(TrilhaAuditoriaBean)session.getAttribute(TrilhaAuditoriaEstrategia.DATA_BEAN));
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=TrilhaAuditoriaEstrategia.STRATEGY_LISTAR%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='<%=TrilhaAuditoriaEstrategia.PAGE_TITLE_MANTER_DETALHE%>'/>
	
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%= trilhaAudit.getCodigoCedenteFormatado()%>               
              </td>
              <td class="textoTitulo" width="17%">CPF/CNPJ Cedente: </td>
              <td class="textoValor" width="26%"><%= trilhaAudit.getCpfCnpjCed()%>               
              </td>
              
            </tr>
            <tr>
               	<td class="textoTitulo" width="17%">Data Transacao: </td>
				<td class="textoValor" width="26%" nowrap><%= trilhaAudit.getDataAuditorialFormatada()%>
                </td>
                <td nowrap class="textoTitulo" width="17%">Hora Transação: </td>
				<td class="textoValor" width="26%" nowrap> <%= trilhaAudit.getHoraAuditoria()%> 
                 </td>
            </tr>
            <tr>
            	   <td class="textoTitulo" width="17%">Transação Efetuada: </td>
                   <td class="textoValor" width="26%"><%= trilhaAudit.getTransacao()%>
                   </td>
                   <td class="textoTitulo" width="17%">Matrícula/CPF Responsável: </td>
                   <td class="textoValor" width="26%"><%=trilhaAudit.getCpfCnpj()%>
                   </td>
                   
            </tr>
            
            <tr>
             	<td nowrap class="textoTitulo" width="17%">Equipamento (IP): </td>
				<td class="textoValor" width="26%" nowrap><%= trilhaAudit.getIpEquipamento()%> 
                </td>
                <td nowrap class="textoTitulo" width="17%">Origem da Transação: </td>
				<td class="textoValor" width="26%" nowrap><%= trilhaAudit.getOrigem()%>
				 </td> 
            </tr>
            
            <tr>
             	<td nowrap class="textoTitulo" width="17%">NSU: </td>
				<td class="textoValor" width="26%" nowrap><%= trilhaAudit.getNsu()%> 
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
			document.frmMain.estrategia.value="<%= TrilhaAuditoriaEstrategia.STRATEGY_LISTAR%>"
		  	document.frmMain.submit();
			
		}
			
			
	
		
    </script>
  </s:FormStrategy>
</p:Document>
</html>
