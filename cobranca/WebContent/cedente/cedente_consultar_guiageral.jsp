<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>



<%CedenteGeralBean geralBean = (request.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN) == null
                    ? new CedenteGeralBean()
                    : (CedenteGeralBean) request.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN));

            String tipoCobranca = Util.toStr(geralBean.getDescTipoCobranca());
            String protestoAutomatico = Util.toStr(
                    geralBean.getProtestoAutomatico(),
                    "N"); // Padrao N
            String prazoProtesto = Util.toStr(geralBean.getPrazoProtesto());
            String prazoDevolucao = Util.toStr(geralBean.getPrazoDevolucao());
            String extratoMovTit = Util.toStr(geralBean.getExtratoMovTit(), "N"); // Padrao N
            String destinoExtMov = Util.toStr(geralBean.getDescDestinoExtMov());
            String extratoMovDebtCredt = Util.toStr(
                    geralBean.getExtratoMovDebtCredt(),
                    "N"); // Padrao N
            String destinoExtMovDebtCredt = Util.toStr(geralBean.getDescDestinoExtMovDebtCredt());
            String inventarioMes = Util.toStr(geralBean.getInventarioMes(), "N"); // Padrao N
            String tipoJurosDia = Util.toStr(geralBean.getDescTipoJurosDia());
            String percentualJurosDia = Util.toStr(geralBean.getPercentualJurosDia());
            String recebimentoCheque = Util.toStr(
                    geralBean.getRecebimentoCheque(),
                    "S"); // Padrao S
            String multa = Util.toStr(geralBean.getMulta());
            String prazoMulta = Util.toStr(geralBean.getPrazoMulta());
            String clienteExternoGeral = Util.toStr(
                    geralBean.getClienteExterno(),
                    "S"); // Padrao S
            String clienteGiroCaixa = Util.toStr(geralBean.getDescClienteGiroCaixa());
            String setor = Util.toStr(geralBean.getDescSetor());
            String porte = Util.toStr(geralBean.getDescPorte());
            String natureza = Util.toStr(geralBean.getDescNatureza());
            String ramoAtividade = Util.toStr(geralBean.getDescRamoAtividade());
            String atividade = Util.toStr(geralBean.getAtividade());            
            String retencaoIOF = Util.toStr(geralBean.getRetencaoIOF());
            
            String exclusaoAutomatica = Util.toStr(
                    geralBean.getExclusaoAutomatica(),
                    "S"); // Padrao S
            String modalidadeTitulo = Util.toStr(geralBean.getDescModalidadeTitulo());
            String codigoUnidadePVVinc = geralBean.getCodigoUnidadePVVincFormatado();
            String codCedenteCentraliz = geralBean.getCodigoCedenteCentralizadorFormatado();
            String bancoCorrespondente = Util.toStr(geralBean.getBancoCorrespondente());
            String cobrancaSemBloqueto = Util.toStr(geralBean.getCobrancaSemBloqueto());
            String codRedeTransmissao = Util.toStr(geralBean.getCodRedeTransmissao());
            String valorDiferenciado = Util.toStr(geralBean.getValorDiferenciado());

            String bancoSacados = "NAO"; // Padrao NAO
            if ("S".equals(geralBean.getBancoSacados())) {
                bancoSacados = "SIM";
            }

            String clienteSINCE = "NAO"; // Padrao NAO para exibição na consulta
            if ("S".equals(geralBean.getClienteSINCE())) {
                clienteSINCE = "SIM";
            }

            String situacao = "ATIVO"; // Padrao ATIVO
            if ("I".equals(geralBean.getSituacao())) {
                situacao = "INATIVO";
            }
            
			if ("S".equals(geralBean.getValorDiferenciado())){
				valorDiferenciado = "SIM";
			}else{
				valorDiferenciado = "NÃO";
			}
			
			String codigoSINCE = Util.toStr(geralBean.getCodigoSINCE(), "0"); 
			
			String cedentePEC = geralBean.getCedentePEC();
			if ("S".equalsIgnoreCase(cedentePEC)){
				cedentePEC="SIM";
			}else{
				cedentePEC="NÃO";
			}
			
			//String cedSemRegistro = Util.toStr(geralBean.getCedSemRegistro(), "N");
			

			
			String cedenteVinculo = Util.toStr(geralBean.getCedenteVinculo());
			
			String dataPEC = geralBean.getDataPEC();
			
			String dtAltPvVinc = geralBean.getDtAltPvVinc();
			
			String pvAltVinc = Util.toStr(geralBean.getPvVincAnt(),"0");
			
			if (pvAltVinc.equalsIgnoreCase("0000")){
				pvAltVinc="";
			}
			
			InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean) session.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
%>
<div class="group">
<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14
	valign="middle" align="center">
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4" class="textoDestaqueTitulo">Guia: Geral</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Tipo de Cobrança:</td>
		<td class="textoValor" width="26%"><%=tipoCobranca%></td>
		<td class="textoTitulo" width="17%">Protesto Automático:</td>
		<td class="textoValor" width="26%"><%=protestoAutomatico%></td>
	</tr>

	<tr>
		<td nowrap class="textoTitulo" width="17%">Prazo Protesto:</td>
		<td class="textoValor" width="26%" nowrap><%=prazoProtesto%></td>
		<td nowrap class="textoTitulo" width="17%">Prazo Devolução:</td>
		<td class="textoValor" width="26%" nowrap><%=prazoDevolucao%></td>
	</tr>

	<tr>
		<td nowrap class="textoTitulo" width="17%">Extrato Mov. Títulos:</td>
		<td class="textoValor" width="26%"><%=extratoMovTit%></td>
		<td nowrap class="textoTitulo" width="17%">Destino Extrato Mov.:</td>
		<td class="textoValor" width="26%"><%=destinoExtMov%></td>
	</tr>

	<tr>
		<td nowrap class="textoTitulo" width="17%">Extrato Mov. Déb./Créd.:</td>
		<td class="textoValor" width="26%"><%=extratoMovDebtCredt%></td>
		<td nowrap class="textoTitulo" width="17%">Destino Extrato Déb./Créd.:
		</td>
		<td class="textoValor" width="26%"><%=destinoExtMovDebtCredt%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Inventário Mês:</td>
		<td class="textoValor" width="26%"><%=inventarioMes%></td>
		<td class="textoTitulo" width="17%">Tipo de Juros Dia:</td>
		<td class="textoValor" width="26%"><%=tipoJurosDia%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Percentual Juros Mês:</td>
		<td width="26%" class="textoValor" nowrap><%=percentualJurosDia%></td>
		<td class="textoTitulo" width="17%">Recebimento em Cheque:</td>
		<td class="textoValor" width="26%"><%=recebimentoCheque%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Percentual Multa:</td>
		<td width="26%" class="textoValor" nowrap><%=multa%></td>
		<td class="textoTitulo" width="17%">Prazo para Multa:</td>
		<td width="26%" class="textoValor" nowrap><%=prazoMulta%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Banco de Sacados:</td>
		<td class="textoValor" width="26%"><%=bancoSacados%></td>
		<td class="textoTitulo" width="17%">Cliente Conta Garantida:</td>
		<td class="textoValor" width="26%"><%=clienteSINCE%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">&nbsp;</td>
		<td class="textoValor" width="26%">&nbsp;</td>
		<td class="textoTitulo" width="17%">Cliente GiroCaixa:</td>
		<td class="textoValor" width="26%"><%=clienteGiroCaixa%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Setor:</td>
		<td class="textoValor" width="26%"><%=setor%></td>
		<td class="textoTitulo" width="17%">Porte:</td>
		<td class="textoValor" width="26%"><%=porte%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Natureza:</td>
		<td class="textoValor" width="26%"><%=natureza%></td>
		<td class="textoTitulo" width="17%">Ramo de Atividade:</td>
		<td class="textoValor" width="26%"><%=ramoAtividade%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Tipo de Atividade:</td>
		<% if (atividade.equals("1")) {%>
		<td class="textoValor" width="26%">SEGURADORA
		<%} else if (atividade.equals("2")) {%>
		<td class="textoValor" width="26%">CORRETORA
		<%} else {%>
		<td class="textoValor" width="26%">&nbsp;
		<%}%>
		</td>
		<td class="textoTitulo" width="17%">Retenção do IOF:</td>
		<td class="textoValor" width="26%"><%=retencaoIOF%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Exclusão Automática:</td>
		<td class="textoValor" width="26%"><%=exclusaoAutomatica%></td>
		
		<td class="textoTitulo" width="17%">Modalidade de Título:</td>
		<td class="textoValor" width="26%"><%=modalidadeTitulo%></td>

	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Pv de Vinculação:</td>
		<td class="textoValor" width="26%"><%=codigoUnidadePVVinc%></td>
		<td class="textoTitulo" width="17%">Cedente Centralizador:</td>
		<td class="textoValor" width="26%"><%=codCedenteCentraliz%></td>
	</tr>
	
	<tr>
	<td class="textoTitulo" width="17%">Pv de Vinculação Anterior:</td>
	<td class="textoValor" width="26%"><%=pvAltVinc  %></td>
	<td class="textoTitulo" width="17%">Data Alteração Pv Vinculação:</td>
	<td class="textoValor" width="26%"><%=dtAltPvVinc  %></td>
</tr>

	<tr>
		<td class="textoTitulo" width="17%">Banco Correspondente:</td>
		<td class="textoValor" width="26%"><%=bancoCorrespondente%></td>
		<td class="textoTitulo" width="17%">Cobrança S/ Boleto - PEC:</td>
		<td class="textoValor" width="26%"><%=cobrancaSemBloqueto%></td>
	</tr>

	<tr>
		<td class="textoTitulo" width="17%">Situação do Cedente:</td>
		<td class="textoValor" width="26%"><%=situacao%></td>
		<td class="textoTitulo" width="17%">Valor Atualizado:</td>
		<td class="textoValor" width="26%"><%=valorDiferenciado%></td>
	</tr>
	
	<tr>	
		<td class="textoTitulo" width="17%">Cod. Rede Transmissão</td>
		<td class="textoValor" width="26%"><%=codRedeTransmissao%></td>
		
		 
	</tr>
	
	<tr>
	<%if (!codigoSINCE.equals("0")) { %>	
		<td class="textoTitulo" width="17%">Código SINCE:</td>
		<td class="textoValor" width="26%"><%= codigoSINCE %></td>	
		<%} %>
	</tr>
	
	<tr>
		<td class="textoTitulo" width="17%">Cedente Master PEC:</td>
		<td class="textoValor" width="26%"><%=cedentePEC%></td>
		<td class="textoTitulo" width="17%">Cedente Vínculo PEC:</td>
		<td class="textoValor" width="26%"><%=cedenteVinculo%></td>
	</tr>
	
	<tr>
		<td class="textoTitulo" width="17%">Data da Vinculação PEC:</td>
		<td class="textoValor" width="26%"><%=dataPEC%></td>
		
	</tr>

	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

</table>
</div>
