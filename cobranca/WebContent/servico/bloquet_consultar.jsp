<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bloquet_consultar.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 17/10/2004 14:58
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BloquetoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BloquetEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.gov.caixa.sigcb.util.jsp.ComboTipoBloqueto"%>
<%@page import="br.gov.caixa.sigcb.util.jsp.ComboEnvioBloqueto"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");
	CedenteCabecaBean cedCabBean = (session.getAttribute(BloquetEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BloquetEstrategia.CEDENTE_CABECALHO_BEAN));
	BloquetoBean bloquetoBean = (session.getAttribute(BloquetEstrategia.DATA_BEAN)==null?new BloquetoBean():(BloquetoBean)session.getAttribute(BloquetEstrategia.DATA_BEAN));
%>


<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle"
    estrategia="<%=BloquetEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="consultar">
    <s:Menu/>
    <s:Titulo name="<%=BloquetEstrategia.PAGE_TITLE_CONSULTAR%>"/>
    
		<input type="hidden" name = "codigoCedente" value="<%=cedCabBean.getCodigoCedente()%>">
		<input type="hidden" name = "dataMovimento" value="<%=Formatador.formatarData(bloquetoBean.getDataMovimento())%>">
		<input type="hidden" name = "tipoBloqueto" value="<%=bloquetoBean.getTipoBloqueto()%>">
    <input type="hidden" name = "situacao" value="<%=bloquetoBean.getSituacaoSolicitacao()%>">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 align="center">
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
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals( new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td>
  						<td colspan="2">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td colspan="5" class="textoTitulo">Solicitação de Boleto On-line:
                <hr>
              </td>
            </tr>

						<tr>
              <td colspan="4">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 align="center">
                    <tr>
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Data do Movimento: </td>
				              <td class="textoValor" width="26%" nowrap>
				              	<%=bloquetoBean.getDataMovimento()==null ? "" : Formatador.formatarData(bloquetoBean.getDataMovimento())%>
				              </td>
                      <td class="textoTitulo" width="17%">Data Envio Gráfica</td>
				              <td class="textoValor" width="26%" nowrap>
				              	<%=bloquetoBean.getDataEnvioGrafica()==null ? "" : Formatador.formatarData(bloquetoBean.getDataEnvioGrafica())%>
				              </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Data Liberação Impressão:</td>
				              <td class="textoValor" width="26%" nowrap>
				              	<%=bloquetoBean.getDataLiberImpr()==null ? "" : Formatador.formatarData(bloquetoBean.getDataLiberImpr())%>
				              </td>
                      <td class="textoTitulo" width="17%">Número Pedido</td>
				              <td class="textoValor" width="26%" nowrap>
				              	<%=bloquetoBean.getNumeroPedido().longValue()==0 ?  "": bloquetoBean.getNumeroPedido().toString()%>
				              </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Tipo de Boleto: </td>
                      <td class="textoValor" width="26%">
                      	<%=ComboTipoBloqueto.getDescricao(bloquetoBean.getTipoBloqueto().toString())%>
                      </td>
                      <td class="textoTitulo" width="17%">Envio do Boleto: </td>
                      <td class="textoValor" width="26%" nowrap>
                      	<%ComboEnvioBloqueto comboEnvioBloqueto = new ComboEnvioBloqueto();%>
                      	<%=comboEnvioBloqueto.getDescricaoExtrato(bloquetoBean.getEnvioBloqueto())%>
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Nosso Número: </td>
							        <td class="textoValor" width="26%" nowrap>
									  		<%=bloquetoBean.getNossoNumero().longValue()==0 ?  "": bloquetoBean.getNossoNumeroQuinzeFormatado()%>&nbsp;
									    </td>

                      <td class="textoTitulo" width="17%">Quantidade: </td>
				              <td class="textoValor" width="26%" nowrap>
													<%=bloquetoBean.getQuantidade().longValue()==0 ?  "": bloquetoBean.getQuantidade().toString()%>
                      </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Gráfica: </td>
				              <td class="textoValor" width="26%" nowrap><%=bloquetoBean.getGrafica()%></td>
                      <td class="textoTitulo" width="17%">&nbsp;</td>
				              <td class="textoValor" width="26%" nowrap>&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="4">&nbsp;</td>
                    </tr>
                </table>
						  </td>
            </tr>
            <tr>
	            <td align="right" colspan="4">
  	            <p align="center">
                	<s:Button name="Alterar" action="javascript: formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bloqueto.manter.alterar" />
                	<s:Button name="Excluir" action="javascript: formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bloqueto.manter.excluir" />
                  <s:Button name="Voltar" action="javascript:formSubmit()"/>
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

    <script>
			function inicia() {
			}

			function formSubmit() {
         document.frmMain.fluxo.value = "consultar";
         document.frmMain.submit();
			}

			function formSubmit_Alterar() {
				if (document.frmMain.situacao.value == "2"){
					msg('030', '');
					return;					
				}
				document.frmMain.estrategia.value = "<%=BloquetEstrategia.STRATEGY_ALTERAR_INICIAR%>";
				document.frmMain.submit();
			}
			function formSubmit_Excluir() {
				if (document.frmMain.situacao.value == "2"){
					msg('030', '');
					return;					
				}        
    		if (confirm(conf("102", "Boleto On-line"))) {
					document.frmMain.estrategia.value = "<%=BloquetEstrategia.STRATEGY_EXCLUIR%>";
        	document.frmMain.submit();
				}
			}
    </script>
  </s:FormStrategy>
</p:Document>
</html>