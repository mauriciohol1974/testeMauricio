<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteMensagensBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>

<%
                    CedenteMensagensBean mensagensBean = (request.getAttribute(CedenteEstrategia.CEDENTE_MENSAGENS_BEAN) == null
                    ? new CedenteMensagensBean()
                    : (CedenteMensagensBean) request.getAttribute(CedenteEstrategia.CEDENTE_MENSAGENS_BEAN));

            String textAreaReciboSacadoBlqPadrao = "";
            if (mensagensBean.getTextAreaReciboSacadoBlqPadrao() != null) {
                textAreaReciboSacadoBlqPadrao = mensagensBean.getTextAreaReciboSacadoBlqPadrao();
            }
            String checkedReciboSacadoBlqPadrao = textAreaReciboSacadoBlqPadrao.trim()
                    .equals("") ? "" : "checked";

            String textAreaVersoBloquetoBlqPadrao = "";
            if (mensagensBean.getTextAreaVersoBloquetoBlqPadrao() != null) {
                textAreaVersoBloquetoBlqPadrao = mensagensBean.getTextAreaVersoBloquetoBlqPadrao();
            }
            String checkedVersoBloquetoBlqPadrao = textAreaVersoBloquetoBlqPadrao.trim()
                    .equals("") ? "" : "checked";

            String textAreaFichaCompensacaoBlqPadrao = "";
            if (mensagensBean.getTextAreaFichaCompensacaoBlqPadrao() != null) {
                textAreaFichaCompensacaoBlqPadrao = mensagensBean.getTextAreaFichaCompensacaoBlqPadrao();
            }
            String checkedFichaCompensacaoBlqPadrao = textAreaFichaCompensacaoBlqPadrao.trim()
                    .equals("") ? "" : "checked";

            String textAreaReciboSacadoBlqPersonalizado = "";
            if (mensagensBean.getTextAreaReciboSacadoBlqPersonalizado() != null) {
                textAreaReciboSacadoBlqPersonalizado = mensagensBean.getTextAreaReciboSacadoBlqPersonalizado();
            }
            String checkedReciboSacadoBlqPersonalizado = textAreaReciboSacadoBlqPersonalizado.trim()
                    .equals("") ? "" : "checked";

            String textAreaVersoBloquetoBlqPersonalizado = "";
            if (mensagensBean.getTextAreaVersoBloquetoBlqPersonalizado() != null) {
                textAreaVersoBloquetoBlqPersonalizado = mensagensBean.getTextAreaVersoBloquetoBlqPersonalizado();
            }
            String checkedVersoBloquetoBlqPersonalizado = textAreaVersoBloquetoBlqPersonalizado.trim()
                    .equals("") ? "" : "checked";

            String textAreaFichaCompensacaoBlqPersonalizado = "";
            if (mensagensBean.getTextAreaFichaCompensacaoBlqPersonalizado() != null) {
                textAreaFichaCompensacaoBlqPersonalizado = mensagensBean.getTextAreaFichaCompensacaoBlqPersonalizado();
            }
            String checkedFichaCompensacaoBlqPersonalizado = textAreaFichaCompensacaoBlqPersonalizado.trim()
                    .equals("") ? "" : "checked";

            String textAreaReciboSacadoABlqPersonalizado = "";
            if (mensagensBean.getTextAreaReciboSacadoABlqPersonalizado() != null) {
                textAreaReciboSacadoABlqPersonalizado = mensagensBean.getTextAreaReciboSacadoABlqPersonalizado();
            }
            String checkedReciboSacadoABlqPersonalizado = textAreaReciboSacadoABlqPersonalizado.trim()
                    .equals("") ? "" : "checked";

            String textAreaReciboSacadoBBlqPersonalizado = "";
            if (mensagensBean.getTextAreaReciboSacadoBBlqPersonalizado() != null) {
                textAreaReciboSacadoBBlqPersonalizado = mensagensBean.getTextAreaReciboSacadoBBlqPersonalizado();
            }
            String checkedReciboSacadoBBlqPersonalizado = textAreaReciboSacadoBBlqPersonalizado.trim()
                    .equals("") ? "" : "checked";

            String textAreaReciboSacadoBlqPreImpresso = "";
            if (mensagensBean.getTextAreaReciboSacadoBlqPreImpresso() != null) {
                textAreaReciboSacadoBlqPreImpresso = mensagensBean.getTextAreaReciboSacadoBlqPreImpresso();
            }
            String checkedReciboSacadoBlqPreImpresso = textAreaReciboSacadoBlqPreImpresso.trim()
                    .equals("") ? "" : "checked";

            String textAreaFichaCompensacaoBlqPreImpresso = "";
            if (mensagensBean.getTextAreaFichaCompensacaoBlqPreImpresso() != null) {
                textAreaFichaCompensacaoBlqPreImpresso = mensagensBean.getTextAreaFichaCompensacaoBlqPreImpresso();
            }
            String checkedFichaCompensacaoBlqPreImpresso = textAreaFichaCompensacaoBlqPreImpresso.trim()
                    .equals("") ? "" : "checked";

            String textAreaReciboSacadoBancoCorresp = "";
            if (mensagensBean.getTextAreaReciboSacadoBancoCorresp() != null) {
                textAreaReciboSacadoBancoCorresp = mensagensBean.getTextAreaReciboSacadoBancoCorresp();
            }
            String checkedReciboSacadoBancoCorresp = textAreaReciboSacadoBancoCorresp.trim()
                    .equals("") ? "" : "checked";
            
            String textAreaReciboDDAImpresso = "";
            if (mensagensBean.getTextAreaReciboDDAImpresso() != null) {
            	textAreaReciboDDAImpresso = mensagensBean.getTextAreaReciboDDAImpresso();
            }
            String checkedReciboDDAImpresso = textAreaReciboDDAImpresso.trim()
            		.equals("") ? "" : "checked";
%>
<div class="group">

<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14
	valign="middle" align="center">
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td class="textoDestaqueTitulo">Guia: Mensagens para Boletos</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>

	<s:Outline name="MensagemBlqPadraoParent"
		title="Mensagens para Boletos - Boleto Padrão"
		imagePath="<%=Paths.getImagePath()%>" type="twist">
		<table width="97%" border="0" cellspacing="1" cellpadding="1"
			height=14 valign="middle" align="center">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%" colspan="2">Local de Impressão
				da Mensagem:</td>
				<td class="textoValor" width="60%" colspan="2"><input
					type="checkbox" name="checkReciboSacadoBlqPadrao"
					<%=checkedReciboSacadoBlqPadrao%> disabled>Recibo Sacado<br>
				<input type="checkbox" name="checkVersoBloquetoBlqPadrao"
					<%=checkedVersoBloquetoBlqPadrao%> disabled>Verso Boleto<br>
				<input type="checkbox" name="checkFichaCompensacaoBlqPadrao"
					<%=checkedFichaCompensacaoBlqPadrao%> disabled>Ficha de Compensação
				</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%" align="top">Mensagem Recibo do
				Sacado:</td>
				<td class="textoValor" width="80%" colspan="3"><textarea
					name="textAreaReciboSacadoBlqPadrao" cols="40" rows="3" readonly><%=textAreaReciboSacadoBlqPadrao%></textarea>
				</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%">Mensagem Verso Boleto:</td>
				<td class="textoValor" width="80%" colspan="3"><textarea
					name="textAreaVersoBloquetoBlqPadrao" cols="75" rows="3" readonly><%=textAreaVersoBloquetoBlqPadrao%></textarea>
				</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%">Mensagem Ficha Compensação:</td>
				<td class="textoValor" width="80%" colspan="3"><textarea
					name="textAreaFichaCompensacaoBlqPadrao" cols="40" rows="2"
					readonly><%=textAreaFichaCompensacaoBlqPadrao%></textarea></td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
		</table>
	</s:Outline>

	<s:Outline name="MensagemBlqPersonalizadoParent"
		title="Mensagens para Boletos - Boleto Personalizado"
		imagePath="<%=Paths.getImagePath()%>" type="twist">
		<table width="97%" border="0" cellspacing="0" cellpadding="0"
			height=14 valign="middle" align="center">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%" colspan="2">Local de Impressão
				da Mensagem:</td>
				<td class="textoValor" width="30%" nowrap><input type="checkbox"
					name="checkReciboSacadoBlqPersonalizado"
					<%=checkedReciboSacadoBlqPersonalizado%> disabled>Recibo Sacado<br>
				<input type="checkbox" name="checkVersoBloquetoBlqPersonalizado"
					<%=checkedVersoBloquetoBlqPersonalizado%> disabled>Verso Boleto<br>
				<input type="checkbox" name="checkFichaCompensacaoBlqPersonalizado"
					<%=checkedFichaCompensacaoBlqPersonalizado%> disabled>Ficha de
				Compensação<br>
				</td>
				<td class="textoValor" width="30%" nowrap><input type="checkbox"
					name="checkReciboSacadoABlqPersonalizado"
					<%=checkedReciboSacadoABlqPersonalizado%> disabled>Recibo do Sacado
				A (Somente p/ Mod 11)<br>
				<input type="checkbox" name="checkReciboSacadoBBlqPersonalizado"
					<%=checkedReciboSacadoBBlqPersonalizado%> disabled>Recibo do Sacado
				B (Somente p/ Mod 11)<br>
				</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%">Mensagem Recibo do Sacado:</td>
				<td class="textoValor" width="80%" colspan="3">
				<p align="justify"><textarea
					name="textAreaReciboSacadoBlqPersonalizado" cols="40" rows="3"
					readonly><%=textAreaReciboSacadoBlqPersonalizado%></textarea></p>
				</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%">Mensagem Verso Boleto:</td>
				<td class="textoValor" width="80%" colspan="3">
				<p align="justify"><textarea
					name="textAreaVersoBloquetoBlqPersonalizado" cols="75" rows="3"
					readonly><%=textAreaVersoBloquetoBlqPersonalizado%></textarea></p>
				</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%">Mensagem Ficha Compensação:</td>
				<td class="textoValor" width="80%" colspan="3">
				<p align="justify"><textarea
					name="textAreaFichaCompensacaoBlqPersonalizado" cols="40" rows="2"
					readonly><%=textAreaFichaCompensacaoBlqPersonalizado%></textarea>
				</p>
				</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%">Mensagem Recibo do Sacado A:</td>
				<td class="textoValor" width="80%" colspan="3">
				<p align="justify"><textarea
					name="textAreaReciboSacadoABlqPersonalizado" cols="40" rows="3"
					readonly><%=textAreaReciboSacadoABlqPersonalizado%></textarea></p>
				</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%">Mensagem Recibo do Sacado B:</td>
				<td class="textoValor" width="80%" colspan="3">
				<p align="justify"><textarea
					name="textAreaReciboSacadoBBlqPersonalizado" cols="40" rows="3"
					readonly><%=textAreaReciboSacadoBBlqPersonalizado%></textarea></p>
				</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
		</table>
	</s:Outline>

	<s:Outline name="MensagemBlqPreImpressoParent"
		title="Mensagens para Boletos - Boleto Pré-Impresso"
		imagePath="<%=Paths.getImagePath()%>" type="twist">
		<table width="97%" border="0" cellspacing="0" cellpadding="0"
			height=14 valign="middle" align="center">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%" colspan="2">Local de Impressão
				da Mensagem:</td>
				<td class="textoValor" width="60%" colspan="2"><input
					type="checkbox" name="checkReciboSacadoBlqPreImpresso"
					<%=checkedReciboSacadoBlqPreImpresso%> disabled>Recibo Sacado
				(A4)<br>
				<input type="checkbox" name="checkFichaCompensacaoBlqPreImpresso"
					<%=checkedFichaCompensacaoBlqPreImpresso%> disabled>Ficha de
				Compensação (A4/Matricial)</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%">Mensagem Recibo do Sacado
				(A4):</td>
				<td class="textoValor" width="80%" colspan="3">
				<p align="justify"><textarea
					name="textAreaReciboSacadoBlqPreImpresso" cols="40" rows="3"
					readonly><%=textAreaReciboSacadoBlqPreImpresso%></textarea></p>
				</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%">Mensagem Ficha Compensação
				(A4/Matricial):</td>
				<td class="textoValor" width="80%" colspan="3">
				<p align="justify"><textarea
					name="textAreaFichaCompensacaoBlqPreImpresso" cols="40" rows="2"
					readonly><%=textAreaFichaCompensacaoBlqPreImpresso%></textarea></p>
				</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
		</table>
	</s:Outline>

	<s:Outline name="MensagemBancoCorrespParent"
		title="Mensagem para Boletos - Banco Correspondente"
		imagePath="<%=Paths.getImagePath()%>" type="twist">
		<table width="97%" border="0" cellspacing="0" cellpadding="0"
			height=14 valign="middle" align="center">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%">Mensagem:</td>
				<td class="textoValor" width="80%" colspan="3">
				<p align="justify"><textarea name="textAreaReciboSacadoBancoCorresp"
					cols="40" rows="1" readonly><%=textAreaReciboSacadoBancoCorresp%></textarea>
				</p>
				</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
		</table>
	</s:Outline>
	
	<s:Outline name="MensagemDDAImpressoParent"
		title="Mensagem para Boletos - DDA Impressão"
		imagePath="<%=Paths.getImagePath()%>" type="twist">
		<table width="97%" border="0" cellspacing="0" cellpadding="0"
			height=14 valign="middle" align="center">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td class="textoTitulo" width="20%">Mensagem:</td>
				<td class="textoValor" width="80%" colspan="3">
				<p align="justify"><textarea name="textAreaReciboDDAImpresso"
					cols="40" rows="1" readonly><%=textAreaReciboDDAImpresso%></textarea>
				</p>
				</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
		</table>
	</s:Outline>

	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

</table>

</div>
