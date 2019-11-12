<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: solextr_consultar.jsp - Java Server Pages
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
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.util.jsp.ComboTipoExtrato"%>
<%@page import="br.gov.caixa.sigcb.util.jsp.ComboEnvioBloqueto"%>
<%@page import="br.gov.caixa.sigcb.util.UtilDatas"%>

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
    estrategia="<%=SolExtrEstrategia.STRATEGY_ALTERAR_INICIAR%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="<%=SolExtrEstrategia.PAGE_TITLE_CONSULTAR%>"/>

	<input type="hidden" name = "codigoCedente" value="<%=cedCabBean.getCodigoCedente()%>">
	<input type="hidden" name = "tipoExtrato" value="<%=filtroExtratoBean.getTipoExtrato()+""%>">
	<input type="hidden" name = "dataInicioDisponivel" value="<%=Formatador.formatarData(segundaViaExtratoBean.getDataInicioDisponivel())%>">
	<input type="hidden" name = "dataFimDisponivel" value="<%=Formatador.formatarData(segundaViaExtratoBean.getDataFimDisponivel())%>">
	<input type="hidden" name = "dataInicio" value="<%=Formatador.formatarData(segundaViaExtratoBean.getDataInicio())%>">
	<input type="hidden" name = "dataFim" value="<%=Formatador.formatarData(segundaViaExtratoBean.getDataFim())%>">
	<input type="hidden" name = "entrega" value="<%=segundaViaExtratoBean.getEntrega()%>">


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
              <td colspan="4">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr>
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                    	<td class="textoTitulo" width="17%">Data Início</td>
                    	<td class="textoValor" width="26%" nowrap>
                    	<%=segundaViaExtratoBean.getDataInicio()==null || Formatador.formatarData(segundaViaExtratoBean.getDataInicio()).equals("01/01/0001")? "": Formatador.formatarData(segundaViaExtratoBean.getDataInicio())%>
			                </td>
                    	<td class="textoTitulo" width="17%">Data Fim</td>
                    	<td class="textoValor" width="26%" nowrap>
						<%=segundaViaExtratoBean.getDataFim()==null || Formatador.formatarData(segundaViaExtratoBean.getDataInicio()).equals("01/01/0001")? "": Formatador.formatarData(segundaViaExtratoBean.getDataFim())%>
                    </tr>
                    <tr>
                    	<td class="textoTitulo" width="17%">Data Solicitação</td>
                    	<td class="textoValor" width="26%" nowrap>
						<%=segundaViaExtratoBean.getDataSolicitacao()==null || Formatador.formatarData(segundaViaExtratoBean.getDataInicio()).equals("01/01/0001") ? "": Formatador.formatarData(segundaViaExtratoBean.getDataSolicitacao())%>
                      <td class="textoTitulo" width="17%">Envio do Extrato: </td>
                      <td class="textoValor" width="26%" nowrap>
                      	<% ComboEnvioBloqueto comboEnvioBloqueto = new ComboEnvioBloqueto(); %>
                      	<%=comboEnvioBloqueto.getDescricaoExtrato(segundaViaExtratoBean.getEntrega())%>
                      </td>
                    </tr>
                    <tr>
                    	<td class="textoTitulo" width="17%">Usuário</td>
                    	<td class="textoValor" width="26%" nowrap><%=segundaViaExtratoBean.getUsuario()+""%></td>
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
                	<s:Button name="Alterar" action="javascript: formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.segundaviaextrato.alterar" />
                	<s:Button name="Excluir" action="javascript: formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.segundaviaextrato.excluir" />
                	<s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
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

		function formSubmit_Alterar(){
			if (validaSubmit("alterado")) {
				formSubmit();
			}					
		}

		function formSubmit() {
				document.frmMain.submit();
		}

		function formSubmit_Excluir() {
			if (validaSubmit("excluído")) {
    		if (confirm(conf("145", "Solicitação de 2a. Via de Extrato"))) {
					document.frmMain.estrategia.value = "<%=SolExtrEstrategia.STRATEGY_EXCLUIR%>";
          formSubmit();
     	}
   	}
		}
		
  function validaSubmit(acao) {
  	if (!compararComHoje("<%=Formatador.formatarData(segundaViaExtratoBean.getDataSolicitacao())%>", "==")) {
  		msg("036","Solicitação de 2a. Via de Extrato ",acao);
  		return false;
  	}
  	return true;
  }
  
  function formSubmit_Voltar() {
     document.frmMain.estrategia.value = "<%=SolExtrEstrategia.STRATEGY_MANTER_INICIAR%>";
     document.frmMain.fluxo.value = "voltar";
     document.frmMain.submit();
  }
  
		/**
		Nome:			compararComHoje
		Objetivo:	Compara se data é <<operador>> a hoje
		Data:			22/10/2004
		Depende:	validarData2
		Parmetro: Data é um string que representa uma data no formato "dd/mm/yyyy"
		*/
		function compararComHoje(data, operador) {
			//EAM - ini
			//if (!validarData(dateValue)) return false;
			//var hojeS, dia, mes, ano, dataS;
			//var today = new Date();
			//hojeS = new Date(today.getYear(), today.getMonth(), today.getDate());	
			//dia = dateValue.substr(0, 2);
			//mes = dateValue.substr(3, 2)-1;
			//ano = dateValue.substr(6, 4);	
			//dataS = new Date(ano, mes, dia);
			//if (!eval(dataS.getTime() + operador +  hojeS.getTime()))
			//	return false;
			//else
			//	return true;
				
			var hoje;
			hoje = '<%=UtilDatas.getToday()%>';
			return compararDatas(hoje, data, operador);
			
			//EAM - fim
		}      
    </script>
  </s:FormStrategy>
</p:Document>
</html>