<%@page import="br.gov.caixa.sigcb.bean.CedenteBloquetosBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%CedenteBloquetosBean bloqBean = (request.getAttribute(CedenteEstrategia.CEDENTE_BLOQUETOS_BEAN) == null
                    ? new CedenteBloquetosBean()
                    : (CedenteBloquetosBean) request.getAttribute(CedenteEstrategia.CEDENTE_BLOQUETOS_BEAN));

            // Variaveis usadas para exibicao no caso de alteracao
            String emissaoBloquetos = Util.toStr(bloqBean.getDescEmissaoBloquetos());
            String envioBloqueto = Util.toStr(bloqBean.getDescEnvioBloqueto());
            String avisoSacado = Util.toStr(bloqBean.getAvisoSacado());
            String impBloqDDA = Util.toStr(bloqBean.getImpBloqDDA());
            String envioSMS = Util.toStr(bloqBean.getEnvioSMS());
            String envioAvisoSacado = Util.toStr(bloqBean.getDescEnvioAvisoSacado());
            String formasAvisoVencido = Util.toStr(bloqBean.getFormasAvisoVencido());
            String formasAvisoProtesto = Util.toStr(bloqBean.getFormasAvisoProtesto());
            String qtdeDiasProtesto = Util.toStr(bloqBean.getQtdeDiasProtesto());
            String avisoDisponibPrimeira = Util.toStr(
                    bloqBean.getAvisoDisponibPrimeira(),
                    "0");
            String avisoDisponibSegunda = Util.toStr(
                    bloqBean.getAvisoDisponibSegunda(),
                    "0");
            String avisoVencidoSegunda = Util.toStr(
                    bloqBean.getAvisoVencidoSegunda(),
                    "0");
            String avisoDisponibTerceira = Util.toStr(
                    bloqBean.getAvisoDisponibTerceira(),
                    "0");
            String avisoVencidoTerceira = Util.toStr(
                    bloqBean.getAvisoVencidoTerceira(),
                    "0");

            String prazoSMS1 = Util.toStr(bloqBean.getPrazoSMS1(),  "0");
            String prazoSMS2 = Util.toStr(bloqBean.getPrazoSMS2(),  "0");
            String prazoSMS3 = Util.toStr(bloqBean.getPrazoSMS3(),  "0");
            
            // Se for 0 mostra
            String valorMinimoAviso = bloqBean.getValorMinimoAviso() == null
                    ? ""
                    : "" + bloqBean.getValorMinimoAviso();
            String avisoVencidoPrimeira = bloqBean.getAvisoVencidoPrimeira() == null
                    ? ""
                    : "" + bloqBean.getAvisoVencidoPrimeira();

            String checkFormasAvisoVencido = "";
            if (formasAvisoVencido.equals("S")) {
                checkFormasAvisoVencido = "checked";
            }

            String checkFormasAvisoProtesto = "";
            if (formasAvisoProtesto.equals("S")) {
                checkFormasAvisoProtesto = "checked";
            }
            String envioSMSSTR = "NÃO";
            if (envioSMS.equalsIgnoreCase("S")){
            	envioSMSSTR = "SIM";
            }
            
            
        	String qtdeBolMes = Util.toStr(bloqBean.getQtdeBolMes());
        	String valorMinULCCA =  bloqBean.getValorMinULCCA()==null ? "" : ""+bloqBean.getValorMinULCCA();
        	String valorMaxULCCA = bloqBean.getValorMaxULCCA()==null ? "" : ""+bloqBean.getValorMaxULCCA();
%>
<div class="group">
<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14
	valign="middle" align="center">
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="4" class="textoDestaqueTitulo">Guia: Boletos</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Emissão de Boleto:</td>
		<td class="textoValor" width="26%"><%=emissaoBloquetos%></td>
		<td class="textoTitulo" width="17%">Envio do Boleto:</td>
		<td class="textoValor" width="26%"><%=envioBloqueto%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Aviso ao Sacado:</td>
		<td class="textoValor" width="26%"><%=avisoSacado%></td>
		<td class="textoTitulo" width="17%">Envio do Aviso ao Sacado:</td>
		<td class="textoValor" width="26%"><%=envioAvisoSacado%></td>
	</tr>
	
	<tr>
		<td class="textoTitulo" width="17%">Impressão em papel para SE:</td>
		<td class="textoValor" width="26%"><%=impBloqDDA%></td>
		<td class="textoTitulo" width="17%">Envio SMS</td>
		<td class="textoValor" width="26%"><%=envioSMSSTR%></td>
	</tr>
	
	
	<tr>
		<td class="textoTitulo" width="17%">Quantidade de Boletos por Mês para Beneficiário UL/CCA:</td>
		<td class="textoValor" width="26%"><%= qtdeBolMes %></td>
	</tr>
	
	<tr>
	  	<td class="textoTitulo" width="17%">Valor Mínimo para Beneficiário UL/CCA:</td>
	  	<td class="textoValor" width="26%"><%= valorMinULCCA %></td>
	
	  	<td class="textoTitulo" width="17%">Valor Máximo para Beneficiário UL/CCA:</td>
	  	<td class="textoValor" width="26%"><%= valorMaxULCCA %></td>
	</tr>

	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<!-- REGRA: Os campos abaixo devem estar ocultos ou desabilitados 
                                e serao mostrados ao usuario apenas qdo da selecao 
                                especifica de campos que os habilitam (vide doc. gestor) -->
	<tr>
		<td class="textoTitulo" width="17%">Formas de Aviso:</td>
		<td class="textoValor" width="26%"><input type="checkbox"
			name="formasAvisoVencido" value="S" <%= checkFormasAvisoVencido %>
			disabled>Vencido<br>
		</td>
		<td class="textoTitulo" width="17%">Valor Mínimo para Aviso:</td>
		<td class="textoValor" width="26%"><%=valorMinimoAviso%><br>
		</td>
	</tr>
	<tr>
		<td class="textoTitulo" width="17%">&nbsp;</td>
		<td class="textoValor" width="26%"><input type="checkbox"
			name="formasAvisoProtesto" value="S" <%= checkFormasAvisoProtesto %>
			disabled>Protesto</td>
		<td class="textoTitulo" width="17%">&nbsp;</td>
		<td class="textoValor" width="26%">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="4">
		<table class="box" width="75%" border="0" cellspacing="3"
			cellpadding="0" height=53 valign="middle" align="center">
			<tr class="headerLista">
				<td align="left" class="textoDestaqueTitulo" width="1%">&nbsp;</td>
				<td align="left" class="textoDestaqueTitulo" width="20%">Quantidade
				de Emissões</td>
				<td align="left" class="textoDestaqueTitulo" width="20%">Aviso
				Disponib. Boleto</td>
				<td align="left" class="textoDestaqueTitulo" width="20%">Aviso
				Vencido</td>
				<td align="left" class="textoDestaqueTitulo" width="20%">Prazo SMS</td>
			</tr>
			<tr class="line2">
				<td class="textoValor" width="1%" align="center">&nbsp;</td>
				<td class="textoValor" width="20%">1a. Emissão</td>
				<td class="textoValor" width="20%"><%=avisoDisponibPrimeira%> dias
				</td>
				<td class="textoValor" width="20%"><%=avisoVencidoPrimeira%> dias	</td>
				<td class="textoValor" width="20%"><%=prazoSMS1%> dias	</td>
			</tr>
			<tr class="line2">
				<td class="textoValor" width="1%" align="center">&nbsp;</td>
				<td class="textoValor" width="20%">2a. Emissão</td>
				<td class="textoValor" width="20%"><%=avisoDisponibSegunda%> dias
				</td>
				<td class="textoValor" width="20%"><%=avisoVencidoSegunda%> dias</td>
				<td class="textoValor" width="20%"><%=prazoSMS2%> dias	</td>
			</tr>
			<tr class="line2">
				<td class="textoValor" width="1%" align="center">&nbsp;</td>
				<td class="textoValor" width="20%">3a. Emissão</td>
				<td class="textoValor" width="20%"><%=avisoDisponibTerceira%> dias
				</td>
				<td class="textoValor" width="20%"><%=avisoVencidoTerceira%> dias
				</td>
				<td class="textoValor" width="20%"><%=prazoSMS3%> dias	</td>
			</tr>
		</table>
		</td>
	</tr>

	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

</table>
</div>
