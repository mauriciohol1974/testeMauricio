<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: sacado_consultar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 08/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.SacadoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.SacadoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SacadoEstrategia.USUARIOLDAP_BEAN);
	CedenteCabecaBean cedCabBean = (session.getAttribute(SacadoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(SacadoEstrategia.CEDENTE_CABECALHO_BEAN));
	SacadoBean sacadoBean = (session.getAttribute(SacadoEstrategia.DATA_BEAN)==null?new SacadoBean():(SacadoBean)session.getAttribute(SacadoEstrategia.DATA_BEAN));
	SacadoBean sacadoFiltroBean = (session.getAttribute(SacadoEstrategia.FILTRO_BEAN)==null?new SacadoBean():(SacadoBean)session.getAttribute(SacadoEstrategia.FILTRO_BEAN));
	
	String strtipoSMS = "";
	if (sacadoBean.getTipoSMS().equalsIgnoreCase("1")){
		strtipoSMS = "Informativa";
	}else if (sacadoBean.getTipoSMS().equalsIgnoreCase("2")){
		strtipoSMS = "Representação Numérica";
	}else if (sacadoBean.getTipoSMS().equalsIgnoreCase("3")){
		strtipoSMS = "PEC";
	}
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=SacadoEstrategia.STRATEGY_ALTERAR_INICIAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=SacadoEstrategia.PAGE_TITLE_CONSULTAR%>"/>


		<input type="hidden" name="codigoCedente" value='<%=sacadoBean.getCodigoCedente()%>'>
		<input type="hidden" name="codigoBancoSacado" value='<%=sacadoBean.getCodigoBancoSacado()%>'>
  	<input type="hidden" name="nomeBancoSacado" value="<%=sacadoBean.getNomeBancoSacado()%>">
		<input type="hidden" name ="tipoPessoaSacado" value='<%=sacadoBean.getTipoPessoaSacado()%>'>		
		<input type="hidden" name ="cpfCnpjSacado" value='<%=sacadoBean.getCpfCnpjSacado()%>'>
		<input type="hidden" name="codigoSacado" value='<%=sacadoBean.getCodigoSacado()%>'>
  	<input type="hidden" name="navegacao" value="<%=sacadoBean.getNavegacao()%>">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=sacadoBean.getCodigoCedenteFormatado()%></td>
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
              <td class="textoValor" width="26%"><%=sacadoBean.getCodigoBancoSacado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Nome Banco de Sacados: </td>
              <td class="textoValor" width="26%"><%=sacadoBean.getNomeBancoSacado()%></td> 
  
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Consultar Sacado:
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
                      <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getTipoPessoaSacadoTexto()%></td>
                      <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
				              <td class="textoValor"width="26%" nowrap><%=sacadoBean.getCpfCnpjSacadoFormatado()%></td>
                    </tr>
                    <tr>
              				<td class="textoTitulo" width="17%">Código Sacado: </td>
				              <td class="textoValor" width="26%"><%=sacadoBean.getCodigoSacado()%></td>
                      <td class="textoTitulo" width="17%">Nome: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getNomeSacado()%></td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">CEP: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getCepSacadoFormatado()%></td>
                      <td class="textoTitulo" width="17%">UF: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getUfSacado()%></td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Endereço: </td>
				              <td class="textoValor" width="26%" nowrap><%=sacadoBean.getEnderecoSacado()%></td>
                      <td class="textoTitulo" width="17%">Número: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getNumeroEnderecoSacado()%></td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Complemento: </td>
				              <td class="textoValor" width="26%" nowrap><%=sacadoBean.getComplementoSacado()%></td>
                      <td class="textoTitulo" width="17%">Bairro: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getBairroSacado()%></td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Município: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getMunicipioSacado()%></td>
                      <td class="textoTitulo" width="17%">e-mail do Sacado: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getEmailSacado()%></td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Tipo Pessoa Responsável: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getTipoPessoaResponsavelTexto()%></td>
                      <td nowrap class="textoTitulo" width="17%">CPF/CNPJ Responsável: </td>
				              <td class="textoValor" width="26%" nowrap><%=sacadoBean.getCpfCnpjResponsavelFormatado()%></td>
                    <tr>
                      <td class="textoTitulo" width="17%">Nome Responsável: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getNomeResponsavel()%></td>
                      <td nowrap class="textoTitulo" width="17%">Valor do Título: </td>
				              <td class="textoValor" width="26%" nowrap><%=sacadoBean.getValorTitulo()%></td>
	                   </tr>
                     <tr> 
                      <td class="textoTitulo" width="17%">Moeda: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getMoedaTexto()%></td>
											<td class="textoTitulo" width="17%">Envio do Boleto: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getEnvioBloquetoTexto()%></td>
                    </tr>
                     <tr>
                      <td class="textoTitulo" width="17%">DDD/Celular: </td>
                      <td class="textoValor" width="26%"><%=sacadoBean.getDddSMS() %>-<%=sacadoBean.getCelularSMS() %></td>
					  <td class="textoTitulo" width="17%">Tipo SMS </td>
                      <td class="textoValor" width="26%"><%=strtipoSMS %></td>
                     </tr>


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
 		            	<s:Button name="Alterar" action="javascript:formSubmit()" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersacado.alterar"/>
 		            	<s:Button name="Excluir" action="javascript:formSubmit_Excluir()" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bancosacados.mantersacado.excluir"/>
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
			function inicia() {
			}
	    function formSubmit() {
        document.frmMain.submit();
	    }
	    function formSubmit_Excluir() {
				if (confirm(conf("102", "Sacado"))) {	
					document.frmMain.estrategia.value = "<%=SacadoEstrategia.STRATEGY_EXCLUIR%>";
	        document.frmMain.submit();
       	}
	    }
	    function validaSubmit() {
        return true;
		  }
	    function formSubmit_Voltar() {
         document.frmMain.estrategia.value = "<%=sacadoFiltroBean.getNavegacao().equals(SacadoEstrategia.NAVEGACAO_FILTRO_TUDO)?SacadoEstrategia.STRATEGY_MANTER_INICIAR:SacadoEstrategia.STRATEGY_MANTER_FILTRO%>";
         document.frmMain.fluxo.value = "voltar";
         document.frmMain.submit();
      }
    </script>
  </s:FormStrategy>
</p:Document>
</html>