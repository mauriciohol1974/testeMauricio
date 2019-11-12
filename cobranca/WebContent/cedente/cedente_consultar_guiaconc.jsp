<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConclusaoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>

<%CedenteGeralBean geralBeanConc = (request.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN) == null
                    ? new CedenteGeralBean()
                    : (CedenteGeralBean) request.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN));

            CedenteConclusaoBean conclusaoBean = (request.getAttribute(CedenteEstrategia.CEDENTE_CONCLUSAO_BEAN) == null
                    ? new CedenteConclusaoBean()
                    : (CedenteConclusaoBean) request.getAttribute(CedenteEstrategia.CEDENTE_CONCLUSAO_BEAN));

            String codigoUnidadeEN = geralBeanConc.getCodigounidadeEN() != null
                    ? "" + geralBeanConc.getCodigounidadeENFormatado()
                    : "";
            String dataInclusao = "" + conclusaoBean.getDataInclusaoFormatada();
            String dataUltimaAlteracao = ""
                                         + conclusaoBean.getDataUltimaAlteracaoFormatada();
            String responsavelAlteracao = ""
                                          + conclusaoBean.getResponsavelAlteracao();

            %>
<div class="group">
<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14
	valign="middle" align="center">
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4" class="textoDestaqueTitulo">Guia: Conclusão do
		Cadastramento</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr>
		<td class="textoTitulo" width="17%">SR:</td>
		<!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
		<td class="textoValor" width="26%"><%=codigoUnidadeEN%></td>

		<td class="textoTitulo" width="17%">Data de Inclusão:</td>
		<td class="textoValor" width="26%"><%=dataInclusao%></td>
	</tr>
	<tr>
		<td class="textoTitulo" width="17%">Data Última Alteração:</td>
		<td class="textoValor" width="26%"><%=dataUltimaAlteracao%></td>
		<td class="textoTitulo" width="17%">Responsável Alteração:</td>
		<td class="textoValor" width="26%"><%=responsavelAlteracao%></td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
</table>
</div>
