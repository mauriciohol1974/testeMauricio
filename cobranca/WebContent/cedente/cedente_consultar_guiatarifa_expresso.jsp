<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteTarifasBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%CedenteTarifasBean tarifasBean = (request.getAttribute(CedenteEstrategia.CEDENTE_TARIFAS_BEAN) == null
                    ? new CedenteTarifasBean()
                    : (CedenteTarifasBean) request.getAttribute(CedenteEstrategia.CEDENTE_TARIFAS_BEAN));

            String periodicidadeTarifa = "";
            if (tarifasBean.getPeriodicidadeTarifaDesc() != null) {
                periodicidadeTarifa = tarifasBean.getPeriodicidadeTarifaDesc();
            }
            String formaCalculo = "";
            if (tarifasBean.getFormaCalculo() != null) {
                formaCalculo = "" + tarifasBean.getDescFormaCalculo();
            }
            String diaDebito = Util.toStr(tarifasBean.getDiaDebito());
%>
<div class="group">
<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14
	valign="middle" align="center">
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="4" class="textoDestaqueTitulo">Guia: Tarifas</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Periodicidade da Tarifa:</td>
		<td class="textoValor" width="26%"><%=periodicidadeTarifa%></td>
		<td class="textoTitulo" width="17%">Dia do Débito:</td>
		<td class="textoValor" width="26%"><%=diaDebito%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Tipo de Negociação:</td>
		<td class="textoValor" width="26%"><%=formaCalculo%></td>
		<td class="textoTitulo" width="17%">&nbsp;</td>
		<td class="textoValor" width="26%">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="4">
		<table class="box" width="35%" border="0" cellspacing="3"
			cellpadding="0" height=53 valign="middle" align="center">
			<tr class="headerLista">
				<td class="textoTitulo" colspan="4" width="17%">Informar Tarifas:</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="1%">&nbsp;</td>
				<td class="textoTitulo" width="17%">Grupo:</td>
				<td class="textoValor" width="26%"><s:ComboGrupo
					name="codigoAgrupamentoServico" /></td>
				<td class="textoTitulo" width="1%">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td align="right" colspan="4">
				<p align="center"><s:Button name="Verificar"
					action="javascript:formSubmit_GrupoTarifas();" /></p>
				</td>
			</tr>
		</table>
		</td>
	</tr>

	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

</table>
<script>
 function formSubmit_GrupoTarifas() {
				var valorAltura = 350;
				var valorLargura = 640;
				var valorTopo = (screen.height - valorAltura) /2;
				var valorEsquerda = (screen.width - valorLargura) /2;
	    
				janelaTarifa = window.open("<%=Paths.getRootForDynamicContent()%>/jump/cedente_incluir_tarifas_jump.jsp", "cedente_incluir_tarifas<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "height="+valorAltura+",width="+valorLargura+",top="+valorTopo+",left="+valorEsquerda+",toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=0");
				janelaTarifa.focus();
	    }
</script>
</div>
