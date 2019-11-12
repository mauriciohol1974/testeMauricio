<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bloquet_alterar.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 15/10/2004 09:12
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
<%@page import="java.util.Date"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%
	InformacoesUsuarioBean usuario = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");
	String grupo = usuario.getNomeGrupo();
	CedenteCabecaBean cedCabBean = (session.getAttribute(BloquetEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BloquetEstrategia.CEDENTE_CABECALHO_BEAN));
	BloquetoBean bloquetoBean = (session.getAttribute(BloquetEstrategia.DATA_BEAN)==null?new BloquetoBean():(BloquetoBean)session.getAttribute(BloquetEstrategia.DATA_BEAN));
%>


<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle"
    estrategia="<%=BloquetEstrategia.STRATEGY_ALTERAR_FINALIZAR%>" fluxo="alterar">
    <s:Menu/>
    <s:Titulo name="<%=BloquetEstrategia.PAGE_TITLE_ALTERAR	%>"/>
	<input type="hidden" name = "codigoCedente" value="<%=cedCabBean.getCodigoCedente()%>">
	<input type="hidden" name = "dataMovimento" value="<%=Formatador.formatarData(bloquetoBean.getDataMovimento())%>">
	<input type="hidden" name = "tipoBloqueto" value="<%=bloquetoBean.getTipoBloqueto()%>">
	<input type="hidden" name = "envioBloqueto" value="<%=bloquetoBean.getEnvioBloqueto()%>">

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
              <td colspan="5" class="textoTitulo">Incluir Solicitação de Boleto On-line:
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
				              <td class="textoValor" width="26%" nowrap><%=Formatador.formatarData(bloquetoBean.getDataMovimento())%></td>
                      <td class="textoTitulo" width="17%">&nbsp;</td>
				              <td class="textoValor" width="26%" nowrap>&nbsp;</td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Tipo de Boleto: </td>
                      <td class="textoValor" width="26%">
												<s:ComboTipoBloqueto name="tipoBloqueto1" disabled="true" selectedValue="<%=bloquetoBean.getTipoBloqueto().toString()%>"/>
                      </td>

                      <td class="textoTitulo" width="17%">Envio do Boleto: </td>
                      <td class="textoValor" width="26%" nowrap>
	                      <s:ComboEnvioBloqueto name="envioBloqueto1" selectedValue='<%= bloquetoBean.getEnvioBloqueto()+""%>' codigo="2" disabled="true" />
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Nosso Número: </td>
				      <td class="textoValor" width="26%" nowrap>
	                      <p:InputNumerico CLASS="inputtext" name="nossoNumero" size="25" maxlength="15"
                            onFocus="javascript: prevFocus(this);"
                            onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.quantidade);"
                            value='<%=bloquetoBean.getNossoNumero().longValue()==0 ?  "": bloquetoBean.getNossoNumero().toString()%>'/>
                      </td>

                      <td class="textoTitulo" width="17%">Quantidade: </td>
				              <td class="textoValor" width="26%" nowrap>
	                      <p:InputNumerico CLASS="inputtext" name="quantidade" size="14" maxlength="4"
                            onFocus="javascript: prevFocus(this);"
                            onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"
                            value='<%=bloquetoBean.getQuantidade().longValue()==0 ?  "": bloquetoBean.getQuantidade().toString()%>'/>
                      </td>
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
                  <s:Button name="Confirmar" action="javascript:formSubmit()"/>
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

    <script>
			function inicia() {
			}
			function formSubmit() {
			  if (validaSubmit()) {
			    if (confirm(conf("101", "Solicitação de Boleto On-line"))) {
			      document.frmMain.submit();
			    }
			  }
			}

      function validaSubmit() {
        if(!validaCampoObrigatorio(document.frmMain.quantidade,'Quantidade')) return false;
        if(!validaMenorIgual(document.frmMain.quantidade, 'Quantidade', 0)) return false;
        if(!validaMaior(document.frmMain.quantidade, 'Quantidade', <%=(grupo.equals("GCBADM")||grupo.equals("GCBREC")) ? 99999 : 9999 %>)) return false;
        if (document.frmMain.nossoNumero!="")
        	if(!validaMenorIgual(document.frmMain.nossoNumero, 'Nosso Número', 0)) return false;
        return true;
      }

      function formSubmit_Voltar() {
        if (confirm(conf("103"))) {
           document.frmMain.estrategia.value = "<%=BloquetEstrategia.STRATEGY_MANTER_FILTRO%>";
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
        }
      }
			function validaMenorIgual(campo, nome, ini) {
				if(parseInt(campo.value) <= parseInt(ini)) {
					msg("006",nome, ini);
					try{
						campo.focus();
					}catch(exp){}
					return false;
				}
				return true;
			}

    </script>
  </s:FormStrategy>
</p:Document>
</html>