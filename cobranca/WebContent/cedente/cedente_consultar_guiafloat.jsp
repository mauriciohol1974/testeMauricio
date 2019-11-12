<%@page import="br.gov.caixa.sigcb.bean.CedenteFloatBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="java.util.ArrayList"%>

<%ArrayList listaFloatDefault = (ArrayList) request.getAttribute(CedenteEstrategia.FLOAT_LISTA_DEFAULT);
            ArrayList listaFloat = (ArrayList) request.getAttribute(CedenteEstrategia.FLOAT_LISTA);

            String[] arrayLabels = new String[10];
            arrayLabels[0] = "Caixa - Dinheiro";
            arrayLabels[1] = "Caixa - Cheque";
            arrayLabels[2] = "Lotérico - Dinheiro";
            arrayLabels[3] = "Lotérico - Cheque";
            arrayLabels[4] = "Compensação";
            arrayLabels[5] = "Auto-Atendimento";
            arrayLabels[6] = "Correspondente Bancário";
            arrayLabels[7] = "Internet Banking";
            arrayLabels[8] = "STR/TED";
            arrayLabels[9] = "Mobile Pre-Pago";
            

            String[] arrayFields = new String[10];
            arrayFields[0] = "floatCaixaDinheiro";
            arrayFields[1] = "floatCaixaCheque";
            arrayFields[2] = "floatLotericoDinheiro";
            arrayFields[3] = "floatLotericoCheque";
            arrayFields[4] = "floatCompensacao";
            arrayFields[5] = "floatAutoAtendimento";
            arrayFields[6] = "floatCorrespondenteBancario";
            arrayFields[7] = "floatInternetBanking";
            arrayFields[8] = "floatStrTed";
            arrayFields[9] = "floatMobile";

            String[] arrayDefaults = new String[10];
            if (listaFloatDefault != null) {
                for (int i = 0; i < listaFloatDefault.size(); i++) {
                    CedenteFloatBean bean = (CedenteFloatBean) listaFloatDefault.get(i);
                    int indice = bean.getMeioEntrada().intValue() - 4; // meios de entrada de 4 a 12
                    arrayDefaults[indice] = "" + bean.getNumeroFloat();
                }
            } else {
                arrayDefaults[0] = "0";
                arrayDefaults[1] = "0";
                arrayDefaults[2] = "0";
                arrayDefaults[3] = "0";
                arrayDefaults[4] = "0";
                arrayDefaults[5] = "0";
                arrayDefaults[6] = "0";
                arrayDefaults[7] = "0";
                arrayDefaults[8] = "0";
                arrayDefaults[9] = "0";
            }

            String[] arrayFloats = new String[10];
            if (listaFloat != null) {
                for (int i = 0; i < listaFloat.size(); i++) {
                    CedenteFloatBean bean = (CedenteFloatBean) listaFloat.get(i);
                    int indice = bean.getMeioEntrada().intValue() - 4; // meios de entrada de 4 a 12
                    arrayFloats[indice] = "" + bean.getNumeroFloat();
                }
            } else {
                arrayFloats[0] = arrayDefaults[0];
                arrayFloats[1] = arrayDefaults[1];
                arrayFloats[2] = arrayDefaults[2];
                arrayFloats[3] = arrayDefaults[3];
                arrayFloats[4] = arrayDefaults[4];
                arrayFloats[5] = arrayDefaults[5];
                arrayFloats[6] = arrayDefaults[6];
                arrayFloats[7] = arrayDefaults[7];
                arrayFloats[8] = arrayDefaults[8];
                arrayFloats[9] = arrayDefaults[9];
            }

            %>
<div class="group">
<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14
	valign="middle" align="center">
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="4" class="textoDestaqueTitulo">Guia: Float</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="4">
		<table class="box" width="50%" border="0" cellspacing="2"
			cellpadding="0" height=14 valign="middle" align="center">
			<tr class="headerLista">
				<td width="1%" align="left" nowrap>&nbsp;</td>
				<td width="50%" align="left" nowrap>&nbsp;</td>
				<td width="20%" align="center" nowrap>Padrão</td>
				<td width="20%" align="center" nowrap>Negociado</td>
				<td width="1%" align="left" nowrap>&nbsp;</td>
			</tr>

			<%for (int i = 0; i < arrayLabels.length; i++) {
%>
			<tr>
				<td width="1%" align="left" nowrap>&nbsp;</td>
				<td class="textoTitulo" width="50%" nowrap><%=arrayLabels[i]%>:</td>
				<td class="textoValor" width="20%" align="center" nowrap><%=arrayDefaults[i]%>
				</td>
				<td class="textoValor" width="20%" align="center" nowrap><%=arrayFloats[i]%>
				<td width="1%" align="left" nowrap>&nbsp;</td>
			</tr>
			<%}

        %>

		</table>
		</td>
	</tr>

	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

</table>
</div>
