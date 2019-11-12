<%
/***********************************************
*Projeto CAIXA - SIGCB DDA
*Componente: ddagerais_titulosenviados_listar.jsp - Java Server Pages
*Criado em: 02/10/2009
*Autor: Glauber Gallego
*Ultima Atualização: 02/10/2009
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.gov.caixa.sigcb.bean.DdaGeraisBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.dda.DdaGeraisEstrategia"%>


<%
  DdaGeraisBean ddaGeraisBean = (session.getAttribute(DdaGeraisEstrategia.BEAN_TITULO)==null?
                                new DdaGeraisBean():
                               (DdaGeraisBean)session.getAttribute(DdaGeraisEstrategia.BEAN_TITULO));
%>

<%
  List descontosList = (session.getAttribute(DdaGeraisEstrategia.BEAN_TITULO_DESCONTOS)==null?
                       new ArrayList():
                       (ArrayList)session.getAttribute(DdaGeraisEstrategia.BEAN_TITULO_DESCONTOS));
%>

<s:Header/>
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle"
   	   estrategia="<%=DdaGeraisEstrategia.STRATEGY_LISTAR%>" fluxo="normal">
 		<s:Menu/>
 		<s:Titulo name="<%=DdaGeraisEstrategia.PAGE_TITLE_TITULODDA_DETALHE%>"/>

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">

            <tr>
              <td nowrap class="textoTitulo" width="17%">Numero De Controle DDA: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getNumeroControleRequisicao()%></td>
              <td nowrap class="textoTitulo" width="17%">Nosso Numero CIP: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getNumeroIdentificacaoDda()%></td>
            </tr>

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td colspan="4" class="textoTitulo">Dados do Cedente:
                <hr>
              </td>
            </tr>
						<tr>
              <td colspan="4">
            		<table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="left">
                	<tr>
										<td nowrap class="textoTitulo" width="17%">Código do Banco: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getCodigoBancoCedente()%></td>
										<td nowrap class="textoTitulo" width="17%">Nome do Banco: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getNomeBancoCedente()%></td>
                  </tr>
                  <tr>
										<td nowrap class="textoTitulo" width="17%">Tipo Pessoa: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getTipoPessoaCedenteTexto()%></td>
										<td nowrap class="textoTitulo" width="17%">CPF/CNPJ: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getCpfCnpjCedenteFormatado()%></td>
                  </tr>
                  <tr>
										<td nowrap class="textoTitulo" width="17%">Nome ou Razão Social: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getNomeCedente()%></td>
										<td nowrap class="textoTitulo" width="17%">&nbsp;</td>
										<td nowrap class="textoValor" width="26%">&nbsp;</td>
                  </tr>
                </table>
              </td>
            </tr>

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td colspan="4" class="textoTitulo">Dados do Sacado Eletrônico:
                <hr>
              </td>
            </tr>
						<tr>
              <td colspan="4">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="left">
                  <tr>
										<td nowrap class="textoTitulo" width="17%">Tipo Pessoa: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getTipoPessoaSacadoTexto()%></td>
										<td nowrap class="textoTitulo" width="17%">CPF/CNPJ: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getCpfCnpjSacadoFormatado()%></td>
                  </tr>
                  <tr>
										<td nowrap class="textoTitulo" width="17%">Nome ou Razão Social: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getNomeSacado()%></td>
										<td nowrap class="textoTitulo" width="17%">&nbsp;</td>
										<td nowrap class="textoValor" width="26%">&nbsp;</td>
                  </tr>
                  <tr>
										<td nowrap class="textoTitulo" width="17%">Endereço: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getEnderecoSacado()%></td>
										<td nowrap class="textoTitulo" width="17%">Município: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getMunicipioSacado()%></td>
                  </tr>
                  <tr>
										<td nowrap class="textoTitulo" width="17%">Estado: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getUfSacado()%></td>
										<td nowrap class="textoTitulo" width="17%">CEP: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getCepSacadoFormatado()%></td>
                  </tr>
                </table>
              </td>
            </tr>

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td colspan="4" class="textoTitulo">Dados do Título:
                <hr>
              </td>
            </tr>

						<tr>
              <td colspan="4">
              	<table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="left">
                	<tr>
										<td nowrap class="textoTitulo" width="17%">Carteira: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getDescricaoTipoCarteira()%></td>
										<td nowrap class="textoTitulo" width="17%">Nosso número: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getNossoNumeroFormatado()%></td>
                  </tr>
                  <tr>
										<td nowrap class="textoTitulo" width="17%">Data de Vencimento: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getDataVencimentoFormatada()%></td>
										<td nowrap class="textoTitulo" width="17%">Valor:</td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getValorTitulo()%></td>
                  </tr>
                  <tr>
										<td nowrap class="textoTitulo" width="17%">Numero do Documento: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getNumeroDocumento()%></td>
										<td nowrap class="textoTitulo" width="17%">Especie: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getDescricaoTipoEspecie()%></td>
                  </tr>
                  <tr>
                 		<td nowrap class="textoTitulo" width="17%">Data Emissão: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getDataProcessamentoFormatada()%></td>
										<td nowrap class="textoTitulo" width="17%">Indicador de Título Negociado: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getIndicadorTituloNegociado()%></td>
                  </tr>
                  <tr>
                 		<td nowrap class="textoTitulo" width="17%">Abatimento: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getValorAbatimento()%></td>
		                <td nowrap class="textoTitulo" width="17%">Valor Juros:</td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getValorJuros()%></td>
                  </tr>
                  <tr>
                 		<td nowrap class="textoTitulo" width="17%">&nbsp;</td>
										<td nowrap class="textoValor" width="26%">&nbsp;</td>
		                <td nowrap class="textoTitulo" width="17%">Percentual Juros:</td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getPercentualJurosFormatado()%> %</td>
                  </tr>
                  <tr>
                 		<td nowrap class="textoTitulo" width="17%">Data Multa: </td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getDataMultaFormatada()%></td>
										<td nowrap class="textoTitulo" width="17%">Valor Multa:</td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getValorMulta()%></td>
                  </tr>
<%                DdaGeraisBean desconto = new DdaGeraisBean();
                  for(int i=0; i < descontosList.size(); i++) {
                	  desconto = (DdaGeraisBean) descontosList.get(i);
%>
                  <tr>
                 		<td nowrap class="textoTitulo" width="17%">Data do Desconto <%=i+1%>:</td>
										<td nowrap class="textoValor" width="26%"><%=desconto.getDataDescontoFormatada()%> </td>
										<td nowrap class="textoTitulo" width="17%">Percentual Multa <%=i+1%>:</td>
										<td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getPercentualMultaFormatado()%> %</td>
                  </tr>
                  <tr>
                 		<td nowrap class="textoTitulo" width="17%">Grupo de Desconto <%=i+1%>:</td>
										<td nowrap class="textoValor" width="26%"><%=desconto.getDescricaoGrupoDesconto()%></td>
		                <td nowrap class="textoTitulo" width="17%">Valor Desconto <%=i+1%>:</td>
										<td nowrap class="textoValor" width="26%"><%=desconto.getValorDesconto() %></td>
                  </tr>
                  <tr>
                 		<td nowrap class="textoTitulo" width="17%">Codigo do Desconto <%=i+1%>: </td>
										<td nowrap class="textoValor" width="26%"><%=desconto.getTipoDesconto()%></td>
		                <td nowrap class="textoTitulo" width="17%">Percentual Desconto <%=i+1%>:</td>
										<td nowrap class="textoValor" width="26%"><%=desconto.getPercentualDescontoFormatado()%> %</td>
                  </tr>
<%                }%>                         
									<tr>
                    <td nowrap class="textoTitulo" width="17%">Tipo Pessoa Terceiro: </td>
			              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getTipoPessoaTerceiroTexto()%></td>
                    <td nowrap class="textoTitulo" width="17%">CPF/CNPJ Terceiro: </td>
			              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getCpfCnpjTerceiroFormatado()%></td>
                  </tr>
                  <tr>
                    <td nowrap class="textoTitulo" width="17%">Ind de Informação Adicional: </td>
			              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getIndicadorInformacaoAdicional()%></td>
                    <td nowrap class="textoTitulo" width="17%">Data Movimento: </td>
			              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getDataMovimentoFormatada()%></td>
                  </tr>
									<tr>
	                  <td nowrap class="textoTitulo" width="17%">Linha Digitável: </td>
				            <td colspan="2" nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getCodigoBarrasFormatado()%></td>
				            <td nowrap class="textoValor" width="26%">&nbsp;</td>
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
      	          <input type="button" class="button" name="Voltar" value="Voltar" onclick="javascript:formSubmit_Voltar()">
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
			function inicia(){
		   	setFirstFieldFocus();
	   	}

	   	function formSubmit(){
	   	}

	    function formSubmit_Voltar() {
  	    document.frmMain.estrategia.value = "<%=DdaGeraisEstrategia.STRATEGY_FILTRO%>";
        document.frmMain.fluxo.value = "voltar";
       	document.frmMain.submit();
	    }

    </script>
		</s:FormStrategy>
	</p:Document>
</html>