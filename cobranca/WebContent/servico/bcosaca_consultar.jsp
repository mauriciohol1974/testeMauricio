<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: bcosaca_consultar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 05/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BancoSacadoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BancoSacadoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(BancoSacadoEstrategia.USUARIOLDAP_BEAN);
	BancoSacadoBean bancoSacadoBean = (session.getAttribute(BancoSacadoEstrategia.DATA_BEAN)==null?new BancoSacadoBean():(BancoSacadoBean)session.getAttribute(BancoSacadoEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(BancoSacadoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BancoSacadoEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=BancoSacadoEstrategia.STRATEGY_ALTERAR_INICIAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=BancoSacadoEstrategia.PAGE_TITLE_CONSULTAR%>"/>    
 		<input type="hidden" name = "codigoCedente" value="<%=bancoSacadoBean.getCodigoCedente()%>">
 		<input type="hidden" name = "codigoBancoSacado" value="<%=bancoSacadoBean.getCodigoBancoSacado()%>">
 		<input type="hidden" name = "navegacao" value="<%=bancoSacadoBean.getNavegacao()%>">
 		<input type="hidden" name = "nomeBancoSacado" value="<%=bancoSacadoBean.getNomeBancoSacado()%>">
 		<input type="hidden" name = "registro" value='<%=bancoSacadoBean.getRegistro()== null?new Long (0):bancoSacadoBean.getRegistro()%>'>
    
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
  
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
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
  
              <td class="textoTitulo" width="17%">Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=bancoSacadoBean.getCodigoBancoSacado()%></td>
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Banco de Sacados:
                <hr>
              </td>
            </tr>
            
						<tr>
              <td class="textoTitulo" width="17%">Nome: </td>
              <td class="textoValor" colspan="2" width="26%"><%=bancoSacadoBean.getNomeBancoSacado()%></td>
						</tr>
						
            <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>

            <tr>
	            <td align="right" colspan="6">
		            <p align="center"> 
 		            	<s:Button name="Alterar" action="javascript:formSubmit()" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.manterbanco.alterar"/>
 		            	<s:Button name="Excluir" action="javascript:formSubmit_Excluir()" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.manterbanco.excluir"/>
		            	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
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
	    function inicia(){

	    }
	    function formSubmit() {
        document.frmMain.submit();
	    }

	    function formSubmit_Excluir() {
				if (confirm(conf("102", "Banco de Sacados (todos os sacados serão removidos)"))) {	
					document.frmMain.estrategia.value = "<%=BancoSacadoEstrategia.STRATEGY_EXCLUIR%>";
	        document.frmMain.submit();
       	}
	    }

	    function formSubmit_Voltar() {
         document.frmMain.estrategia.value = "<%=bancoSacadoBean.getNavegacao().equals(BancoSacadoEstrategia.NAVEGACAO_FILTRO_BANCO)?BancoSacadoEstrategia.STRATEGY_MANTER_INICIAR:BancoSacadoEstrategia.STRATEGY_MANTER_FILTRO%>";
         document.frmMain.fluxo.value = "voltar";
         document.frmMain.submit();
      }  

			function validaSubmit() {
		    return true;
		  }
    </script>
  </s:FormStrategy>
</p:Document>
</html>