<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: salcob_manter_consultar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 09/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.SaldoCobrancaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.SaldoCobrancaEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	SaldoCobrancaBean saldoCobrancaBean = (session.getAttribute(SaldoCobrancaEstrategia.DATA_BEAN)==null?new SaldoCobrancaBean():(SaldoCobrancaBean)session.getAttribute(SaldoCobrancaEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(SaldoCobrancaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(SaldoCobrancaEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=SaldoCobrancaEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=SaldoCobrancaEstrategia.PAGE_TITLE%>"/>    
  	<input type="hidden" name="codigoCedente" value="<%=saldoCobrancaBean.getCodigoCedente()%>">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=saldoCobrancaBean.getCodigoCedente().equals( new Long(0))?"":saldoCobrancaBean.getCodigoCedenteFormatado()%></td>
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
              <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals( new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Consulta:
                <hr>
              </td>
            </tr>
						
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">&nbsp;</td>
								    <td nowrap width="30%" align="center" colspan="2">Registrado</td>
 								    <td nowrap width="30%" align="center" colspan="2">Sem Registro</td>
								  </tr>
								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">&nbsp;</td>
								    <td nowrap width="15%" align="right">Quantidade</td>
 								    <td nowrap width="15%" align="right">Valor</td>
								    <td nowrap width="15%" align="right">Quantidade</td>
 								    <td nowrap width="15%" align="right">Valor</td>
								  </tr>
								  
								  <tr class="line1">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Saldo Anterior</td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getSaldoAnteriorQtdReg()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getSaldoAnteriorVlrReg()%></td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getSaldoAnteriorQtd()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getSaldoAnteriorVlr()%></td>
								  </tr>
								  <tr class="line0">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Entradas</td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getEntradasQtdReg()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getEntradasVlrReg()%></td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getEntradasQtd()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getEntradasVlr()%></td>
								  </tr>
								  <tr class="line1">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Baixas</td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getBaixasQtdReg()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getBaixasVlrReg()%></td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getBaixasQtd()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getBaixasVlr()%></td>
								  </tr>
								  <tr class="line0">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Liquidações</td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getLiquidacoesQtdReg()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getLiquidacoesVlrReg()%></td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getLiquidacoesQtd()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getLiquidacoesVlr()%></td>
								  </tr>
								  <tr class="line1">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Saldo Atual</td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getSaldoAtualQtdReg()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getSaldoAtualVlrReg()%></td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getSaldoAtualQtd()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getSaldoAtualVlr()%></td>
								  </tr>
								  <tr class="line0">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">&nbsp;</td>
								    <td nowrap width="15%" align="left">&nbsp;</td>
 								    <td nowrap width="15%" align="left">&nbsp;</td>
								    <td nowrap width="15%" align="left">&nbsp;</td>
 								    <td nowrap width="15%" align="left">&nbsp;</td>
								  </tr>
								  <tr class="line1">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Vencidos</td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getVencidosQtdReg()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getVencidosVlrReg()%></td>
								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getVencidosQtd()%></td>
 								    <td nowrap width="15%" align="right"><%=saldoCobrancaBean.getVencidosVlr()%></td>
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
	              	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
								</p>
	            </td>
	          </tr>
          </table>
        </td>
      </tr>
    </table>
		<script>

	    function inicia(){
	    }

	  	function formSubmit() {
        if(validaSubmit()){   
           document.frmMain.submit();
        }
	    }  
	    
	    function formSubmit_Voltar() {
						document.frmMain.estrategia.value = '<%=SaldoCobrancaEstrategia.STRATEGY_MANTER_INICIAR%>';    	
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
      }  

			function validaSubmit() {
	  	}

		</script>
  </s:FormStrategy>
</p:Document>
</html>