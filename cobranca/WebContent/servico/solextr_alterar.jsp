<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: solextr_alterar.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 22/10/2004 09:35
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.SegundaViaExtratoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.SolExtrEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.util.jsp.ComboTipoExtrato"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");
	CedenteCabecaBean cedCabBean = (session.getAttribute(SolExtrEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(SolExtrEstrategia.CEDENTE_CABECALHO_BEAN));
	SegundaViaExtratoBean filtroExtratoBean = (session.getAttribute(SolExtrEstrategia.FILTRO_BEAN)==null?new SegundaViaExtratoBean():(SegundaViaExtratoBean)session.getAttribute(SolExtrEstrategia.FILTRO_BEAN));
	SegundaViaExtratoBean segundaViaExtratoBean = (session.getAttribute(SolExtrEstrategia.DATA_BEAN)==null?new SegundaViaExtratoBean():(SegundaViaExtratoBean)session.getAttribute(SolExtrEstrategia.DATA_BEAN));
%>
<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle"
    estrategia="<%=SolExtrEstrategia.STRATEGY_ALTERAR_FINALIZAR%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="<%=SolExtrEstrategia.PAGE_TITLE_ALTERAR%>"/>

		<input type="hidden" name = "codigoCedente" value="<%=cedCabBean.getCodigoCedente()%>">
		<input type="hidden" name = "tipoExtrato" value="<%=filtroExtratoBean.getTipoExtrato()+""%>">
		<input type="hidden" name = "dataInicioDisponivel" value="<%=Formatador.formatarData(segundaViaExtratoBean.getDataInicioDisponivel())%>">
		<input type="hidden" name = "dataFimDisponivel" value="<%=Formatador.formatarData(segundaViaExtratoBean.getDataFimDisponivel())%>">

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
  						<td class="textoTitulo" width="17%">Tipo de Extrato: </td>
  						<td class="textoValor" width="26%"><%=ComboTipoExtrato.getDescricao(filtroExtratoBean.getTipoExtrato()+"")%></td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td colspan="5" class="textoTitulo">Solicitar Emissão de 2a. via de Extrato:
                <hr>
              </td>
            </tr>
            <tr>
              <td colspan="5" class="textoTitulo">Período Disponível para Solicitação: de 
              <%=segundaViaExtratoBean.getDataInicioDisponivel()==null ? "" : Formatador.formatarData(segundaViaExtratoBean.getDataInicioDisponivel())%>
              até
			  <%=segundaViaExtratoBean.getDataFimDisponivel()==null ? "" : Formatador.formatarData(segundaViaExtratoBean.getDataFimDisponivel())%>
              </td>
            </tr>
			  <tr>
				 <td colspan="4">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 align="center">
                    <tr>
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                    	<td class="textoTitulo" width="17%">Data Início</td>
                    	<td class="textoValor" width="26%" nowrap>
			                <p:InputDate name="dataInicio"
			                    CLASS="inputtext"
			                    onFocus="javascript: prevFocus(this);"
			                    onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataFim);"
			                    value='<%=segundaViaExtratoBean.getDataInicio()==null ? "": Formatador.formatarData(segundaViaExtratoBean.getDataInicio())%>'/>
			                </td>
                    	<td class="textoTitulo" width="17%">Data Fim</td>
                    	<td class="textoValor" width="26%" nowrap>
			                <p:InputDate name="dataFim"
			                    CLASS="inputtext"
			                    onFocus="javascript: prevFocus(this);"
			                    onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.entrega);"
			                    value='<%=segundaViaExtratoBean.getDataFim()==null ? "": Formatador.formatarData(segundaViaExtratoBean.getDataFim())%>'/>
			                </td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Envio do Extrato: </td>
                      <td class="textoValor" width="26%" nowrap>
						<s:ComboEnvioBloqueto name="entrega" selectedValue='<%= segundaViaExtratoBean.getEntrega()+""%>' codigo="2" disabled="false" />
                </td>
                <td colspan="2">&nbsp;</td>
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
			    if (confirm(conf("144", "Solicitação de Emissão de 2a. via de Extrato"))) {
			      document.frmMain.submit();
			    }
			  }
			}

      function validaSubmit() {
        if(!validaCampoObrigatorio(document.frmMain.dataInicio,'Data Inicio')) return false;
        if(!validaCampoObrigatorio(document.frmMain.dataFim,'Data Fim')) return false;
        //datas devem ser válidas
				if (validarData(document.frmMain.dataInicio.value) == false) {
					msg('014','Data Início');
					document.frmMain.dataInicio.focus();
					return false;
				}
				if (validarData(document.frmMain.dataFim.value) == false) {
					msg('014','Data Fim');
					document.frmMain.dataFim.focus();					
					return false;
				}			
        //data inicio deve ser maior e igual que data inicio disponível
        if (!compararDatas(document.frmMain.dataInicio.value, "<%=Formatador.formatarData(segundaViaExtratoBean.getDataInicioDisponivel())%>" ,">="))  {
        	msg('033','Data Início','Data Início Disponível');
        	document.frmMain.dataInicio.focus();
        	return false;
        }
        //data fim deve ser menor igual que data fim disponível        
        if (!compararDatas(document.frmMain.dataFim.value, "<%=Formatador.formatarData(segundaViaExtratoBean.getDataFimDisponivel())%>" ,"<="))  {
        	msg('034','Data Fim','Data Fim Disponível');
        	document.frmMain.dataFim.focus();
        	return false;
        }        
        //data inicio deve ser menor que data fim
        if (!compararDatas(document.frmMain.dataInicio.value, document.frmMain.dataFim.value, "<=")) {
        	msg('034','Data Início','Data Fim');
        	document.frmMain.dataInicio.focus();
        	return false;
        }                
        return true;
      }

      function formSubmit_Voltar() {
        if (confirm(conf("103"))) {
           document.frmMain.estrategia.value = "<%=SolExtrEstrategia.STRATEGY_MANTER_FILTRO%>";
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
        }
      }
    
    </script>
  </s:FormStrategy>
</p:Document>
</html>