<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: lantari_manter_filtro.jsp - Java Server Pages
*Author Eduardo A. Mor�s - emoras@sao.politec.com.br 
*Ultima Atualiza��o: 08/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.LancamentoTarifaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.LancamentoTarifaEstrategia"%>


<%
	LancamentoTarifaBean lancamentoTarifaBean = (session.getAttribute(LancamentoTarifaEstrategia.FILTRO_BEAN)==null?new LancamentoTarifaBean():(LancamentoTarifaBean)session.getAttribute(LancamentoTarifaEstrategia.FILTRO_BEAN));	
	lancamentoTarifaBean.setCodigoCedente(session.getAttribute(LancamentoTarifaEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(LancamentoTarifaEstrategia.CEDENTE_ATUAL));
	
	CedenteCabecaBean cedCabBean = (session.getAttribute(LancamentoTarifaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(LancamentoTarifaEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=LancamentoTarifaEstrategia.STRATEGY_MANTER_EXECUTAR%>' fluxo="normal">
	<s:Menu/>
		<s:Titulo name='Incluir Comando de D�bito de Tarifas'/>
	
	<input type="hidden" name="codigoCedente" value="<%=lancamentoTarifaBean.getCodigoCedenteFormatado()%>" />
	<input type="hidden" name="dtComando" value="<%=lancamentoTarifaBean.getDataComandoFormatada()%>" />
	<input type="hidden" name="coUsuario" value="<%=lancamentoTarifaBean.getCoUsuario()%>" />
	<input type="hidden" name="valorTotal" value="<%=lancamentoTarifaBean.getValorTotal()%>" />
	
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=lancamentoTarifaBean.getCodigoCedente().equals( new Long(0))?"":lancamentoTarifaBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">C�digo Cliente (COCLI): </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals( new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
           
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
          </table>
          </td>
         </tr>
      		<tr> 
        		<td valign="top" width="95%" height="14" align="left"> 
          		<table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
					<tr>
              			<td class="textoTitulo" width="17%">Valor Total Cobrado: </td>
              			<td class="textoValor" width="26%">
              				<%= lancamentoTarifaBean.getValorTotal() %>
			  			</td>
			  			<td width="17%">&nbsp;</td>
              			<td width="26%">&nbsp;</td>
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
                  <s:Button name="Ok" action="javascript:formSubmit();"/>
                  <s:Button name="Consultar Tarifas" action="javascript:Consultar();"/>
                  <s:Button name="Voltar" action="javascript:voltar();"/>
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
			
			function Consultar() {
				document.frmMain.estrategia.value="servico.DebitoTarifaConsultarDetIniciar_Incluir"
			  	document.frmMain.submit();
  			}  
      
			
			function voltar() {
				document.frmMain.estrategia.value="servico.TarifaIncluirComandoDebito"
			  	document.frmMain.submit();
  			}  
			
		function validaSubmit() {
			
			
			if (confirm("Deseja realmente incluir esta solicita��o de Comando de D�bito de Tarifas?")) {
				return true;
			}
		
			return false;
		}
		
    </script>
  </s:FormStrategy>
</p:Document>
</html>
