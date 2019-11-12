<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: girocai_consultar.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 20/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>


<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.GiroCaixaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GiroCaixaEstrategia"%>


<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(GiroCaixaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(GiroCaixaEstrategia.CEDENTE_CABECALHO_BEAN));
	GiroCaixaBean giroCaixaBean = (session.getAttribute(GiroCaixaEstrategia.DATA_BEAN)==null?new GiroCaixaBean():(GiroCaixaBean)session.getAttribute(GiroCaixaEstrategia.DATA_BEAN));	
	GiroCaixaBean giroCaixaFiltroBean = (session.getAttribute(GiroCaixaEstrategia.FILTRO_BEAN)==null?new GiroCaixaBean():(GiroCaixaBean)session.getAttribute(GiroCaixaEstrategia.FILTRO_BEAN));	
%>

<html>
	<s:Header/>
	<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
				estrategia='<%=GiroCaixaEstrategia.STRATEGY_MANTER_FILTRO%>' fluxo="voltar">
	<s:Menu/>
		<s:Titulo name='<%=GiroCaixaEstrategia.PAGE_TITLE%>'/>
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
	          	<td class="textoTitulo" width="17%">Cedente: </td>
  	          <td class="textoValor" width="26%"><%=giroCaixaBean.getCodigoCedente().equals(new Long(0))?"":giroCaixaBean.getCodigoCedenteFormatado()%></td>
    	        <td class="textoTitulo" width="17%">Nome Cedente: </td>
      	      <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td>
            </tr>
            <tr>
	          	<td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
  	          <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 
    	        <td class="textoTitulo" width="17%">CNPJ: </td>
      	      <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
	          	<td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
  	          <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals(new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">GiroCaixa:
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" align="left" valign="left">
                  <tr>
                    <td nowrap class="textoTitulo" width="17%">Atividade Economica: </td>
		                <td nowrap class="textoValor" width="26%"><%=giroCaixaBean.getNomeAtividade()%></td>
                    <td nowrap class="textoTitulo" width="17%">Data da Inclusão: </td>
		                <td nowrap class="textoValor" width="26%"><%=giroCaixaBean.getDataInclusaoFormatada()%></td>
                  </tr>
                  <tr>
                    <td nowrap class="textoTitulo" width="17%">GiroCaixa Escritural: </td>
				            <td nowrap class="textoValor" width="26%"><%=giroCaixaBean.getGiroCaixaEstrutural().equals("S")?"SIM":"NAO"%></td>
                    <td nowrap class="textoTitulo" width="17%">Data da Última Alteração: </td>
				            <td nowrap class="textoValor" width="26%"><%=giroCaixaBean.getDataAlteracaoFormatada()%></td>
                  </tr>
                  <tr>
                    <td nowrap class="textoTitulo" width="17%">Matrícula do Concessor: </td>
				            <td nowrap class="textoValor" width="26%"><%=giroCaixaBean.getMatriculaConcessorUsuario()%></td>
                    <td nowrap class="textoTitulo" width="17%">Data da Exclusão: </td>
		                <td nowrap class="textoValor" width="26%"><%=giroCaixaBean.getDataExclusaoFormatada()%></td>
                  </tr>
			            <tr>
			              <td nowrap class="textoTitulo" width="17%">Unidade PV: </td>
			              <td nowrap class="textoValor" width="26%"><%=giroCaixaBean.getCodigoUnidadePVFormatado()%></td>
			              <td nowrap class="textoTitulo" width="17%">Nome Unidade PV: </td>
			              <td nowrap class="textoValor" width="26%"><%=giroCaixaBean.getNomeUnidadePV()%></td>
			            </tr>
                  <tr>
                    <td nowrap class="textoTitulo" width="17%">Unidade SR: </td><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
				            <td nowrap class="textoValor" width="26%"><%=giroCaixaBean.getCodigoUnidadeENFormatado()%></td>
			              <td nowrap class="textoTitulo" width="17%">Nome Unidade SR: </td><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
			              <td nowrap class="textoValor" width="26%"><%=giroCaixaBean.getNomeUnidadeEN()%></td>
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
        </td>
      </tr>
    </table>
    <script language="javascript">
    function inicia(){
    }
    
    function formSubmit_Voltar() {
			document.frmMain.estrategia.value = '<%=giroCaixaFiltroBean.getNavegacao().equals(GiroCaixaEstrategia.NAVEGACAO_CONSULTA)?GiroCaixaEstrategia.STRATEGY_MANTER_INICIAR:GiroCaixaEstrategia.STRATEGY_MANTER_FILTRO%>';    	
			document.frmMain.submit();
    }
    
    function formSubmit() {
        formSubmit_Voltar();
    }
    </script>
  </s:FormStrategy>
</p:Document>
</html>
