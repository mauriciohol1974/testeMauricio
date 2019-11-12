<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>

<%String[] contaRateioUnidade = { "", "", "" };
            if (request.getAttribute("contaRateioUnidade") != null) {
                contaRateioUnidade = (String[]) request.getAttribute("contaRateioUnidade");
            } else if (request.getParameterValues("contaRateioUnidade") != null) {
                contaRateioUnidade = request.getParameterValues("contaRateioUnidade");
            }

            String[] contaRateioOperacao = { "", "", "" };
            if (request.getParameterValues("contaRateioOperacao") != null) {
                contaRateioOperacao = request.getParameterValues("contaRateioOperacao");
            } else if (request.getAttribute("contaRateioOperacao") != null) {
                contaRateioOperacao = (String[]) request.getAttribute("contaRateioOperacao");
            }

            String[] contaRateioConta = { "", "", "" };
            if (request.getAttribute("contaRateioConta") != null) {
                contaRateioConta = (String[]) request.getAttribute("contaRateioConta");
            } else if (request.getParameterValues("contaRateioConta") != null) {
                contaRateioConta = request.getParameterValues("contaRateioConta");
            }

            String[] contaRateioDV = { "", "", "" };
            if (request.getAttribute("contaRateioDV") != null) {
                contaRateioDV = (String[]) request.getAttribute("contaRateioDV");
            } else if (request.getParameterValues("contaRateioDV") != null) {
                contaRateioDV = request.getParameterValues("contaRateioDV");
            }

            String[] percentualRateio = { "", "", "" };
            if (request.getAttribute("percentualRateio") != null) {
                percentualRateio = (String[]) request.getAttribute("percentualRateio");
            } else if (request.getParameterValues("percentualRateio") != null) {
                percentualRateio = request.getParameterValues("percentualRateio");
            }

            String[] valorRateio = { "", "", "" };
            if (request.getAttribute("valorRateio") != null) {
                valorRateio = (String[]) request.getAttribute("valorRateio");
            } else if (request.getParameterValues("valorRateio") != null) {
                valorRateio = request.getParameterValues("valorRateio");
            }

            String[] txtPercCredito = { "", "", "" };
            if (request.getAttribute("txtPercCredito") != null) {
                txtPercCredito = (String[]) request.getAttribute("txtPercCredito");
            } else if (request.getParameterValues("txtPercCredito") != null) {
                txtPercCredito = request.getParameterValues("txtPercCredito");
            }

            String[] txtPercDebito = { "", "", "" };
            if (request.getAttribute("txtPercDebito") != null) {
                txtPercDebito = (String[]) request.getAttribute("txtPercDebito");
            } else if (request.getParameterValues("txtPercDebito") != null) {
                txtPercDebito = request.getParameterValues("txtPercDebito");
            }

            String[] contaCpfCnpj = { "", "", "" };
            if (request.getAttribute("contaCpfCnpj") != null) {
                contaCpfCnpj = (String[]) request.getAttribute("contaCpfCnpj");
            } else if (request.getParameterValues("contaCpfCnpj") != null) {
                contaCpfCnpj = request.getParameterValues("contaCpfCnpj");
            }

            String[] contaTitular = { "", "", "" };
            if (request.getAttribute("contaTitular") != null) {
                contaTitular = (String[]) request.getAttribute("contaTitular");
            } else if (request.getParameterValues("contaTitular") != null) {
                contaTitular = request.getParameterValues("contaTitular");
            }

            String[] tipoConta = { "1", "2", "3" };
            if (request.getAttribute("tipoConta") != null) {
                tipoConta = (String[]) request.getAttribute("tipoConta");
            } else if (request.getParameterValues("tipoConta") != null) {
                tipoConta = request.getParameterValues("tipoConta");
            }
%>
<div class="group">
<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14
	valign="middle" align="center">
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="4" class="textoDestaqueTitulo">Guia: Contas
		Débito/Crédito</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td class="textoTitulo" width="10%">Conta Crédito:</td>
		<td width="33%" class="textoValor" nowrap><%=br.gov.caixa.sigcb.util.Formatador.formatarUnidade(contaRateioUnidade[0])%>
		<%=br.gov.caixa.sigcb.util.Formatador.formatarOperacao(contaRateioOperacao[0])%>
		<%=br.gov.caixa.sigcb.util.Formatador.formatarConta(contaRateioConta[0])%>
		<%=contaRateioDV[0]%></td>
		<td class="textoTitulo" width="12%">Perc. Participação:</td>
		<td width="31%" class="textoValor"><%=txtPercCredito[0]%></td>
	</tr>
	<tr>
		<td class="textoTitulo" width="10%">Conta Débito:</td>
		<td width="33%" class="textoValor" nowrap><%=br.gov.caixa.sigcb.util.Formatador.formatarUnidade(contaRateioUnidade[1])%>
		<%=br.gov.caixa.sigcb.util.Formatador.formatarOperacao(contaRateioOperacao[1])%>
		<%=br.gov.caixa.sigcb.util.Formatador.formatarConta(contaRateioConta[1])%>
		<%=contaRateioDV[1]%></td>
		<td class="textoTitulo" width="12%">Perc. Participação:</td>
		<td width="31%" class="textoValor"><%=txtPercDebito[1]%></td>
	</tr>
	<tr>
		<td class="textoTitulo" width="10%">Conta Caução:</td>
		<td width="33%" class="textoValor" nowrap><%=br.gov.caixa.sigcb.util.Formatador.formatarUnidade(contaRateioUnidade[2])%>
		<%=br.gov.caixa.sigcb.util.Formatador.formatarOperacao(contaRateioOperacao[2])%>
		<%=br.gov.caixa.sigcb.util.Formatador.formatarConta(contaRateioConta[2])%>
		<%=contaRateioDV[2]%></td>
		<td class="textoTitulo" width="12%">&nbsp;</td>
		<td class="textoTitulo" width="31%">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<%if (contaRateioUnidade.length > 3) {

                %>
	<tr>
		<td colspan="4">
		<div id="contasRateio" style="display:block">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			height=14 valign="middle" align="center">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>

			<tr>
				<td colspan="4">
				<table class="box" width="100%" border="0" cellspacing="3"
					cellpadding="0" height=14 valign="middle" align="center">
					<tr class="headerLista">
						<td align="center" class="textoTitulo" width="3%">&nbsp;</td>
						<td align="left" class="textoTitulo" width="17%">Conta</td>
						<td align="left" class="textoTitulo" width="1%">&nbsp;</td>
						<td align="left" class="textoTitulo" width="12%">Perc. Crédito</td>
						<td align="left" class="textoTitulo" width="1%">&nbsp;</td>
						<td align="right" class="textoTitulo" width="20%">Valor Crédito</td>
						<td align="left" class="textoTitulo" width="1%">&nbsp;</td>
						<td align="left" class="textoTitulo" width="10%">Perc. Débito</td>
						<td align="left" class="textoTitulo" width="1%">&nbsp;</td>
						<td align="left" class="textoTitulo" width="15%">CPF/CNPJ</td>
						<td align="left" class="textoTitulo" width="31%">Titular</td>
						<td align="left" class="textoTitulo" width="3%">&nbsp;</td>
					</tr>
					<%for (int j = 3; j < contaRateioUnidade.length; j++) {
%>
					<tr <%= ( ((j+1)%2) == 0 ) ? "class='line0'" : "class='line2'" %>>
						<td align="center" class="textoTitulo" width="5%"><%=j - 2%>.</td>
						<td align="left" class="textoValor" width="17%" nowrap><%=br.gov.caixa.sigcb.util.Formatador.formatarUnidade(contaRateioUnidade[j])%>
						<%=br.gov.caixa.sigcb.util.Formatador.formatarOperacao(contaRateioOperacao[j])%>
						<%=br.gov.caixa.sigcb.util.Formatador.formatarConta(contaRateioConta[j])%>
						<%=contaRateioDV[j]%></td>
						<td align="left" class="textoValor" width="1%">&nbsp;</td>
						<td align="left" width="12%" nowrap><%=txtPercCredito[j]%></td>
						<td align="left" class="textoValor" width="1%">&nbsp;</td>
						<td align="right" width="20%" nowrap><%=valorRateio[j]%></td>
						<td align="left" class="textoValor" width="1%">&nbsp;</td>
						<td align="left" width="10%" nowrap><%=txtPercDebito[j]%></td>
						<td align="left" class="textoValor" width="1%">&nbsp;</td>
						<td class="textoValor" align="left" width="15%" nowrap><%=((j - 3) < contaCpfCnpj.length)
                            ? contaCpfCnpj[j - 3]
                            : ""%>
						</td>
						<td class="textoValor" align="left" width="31%" nowrap><%=((j - 3) < contaTitular.length)
                            ? contaTitular[j - 3]
                            : ""%>
						</td>
						<td align="left" class="textoValor" width="3%">&nbsp;</td>
					</tr>
					<%}

            %>

					<tr>
						<td colspan="12">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</div>
		</td>
	</tr>

	<%}

        %>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

</table>
</div>
