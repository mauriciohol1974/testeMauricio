<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteParametrosBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConteudoListaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
	String descCriticas = "";
	if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
		descCriticas = (String) request.getAttribute(CedenteEstrategia.DESC_CRITICAS);
	} 
%>

<% 
	CedenteCabecaBean cabecaBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
	                               ? new CedenteCabecaBean()
	                               : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

	CedentePrincipalBean principalBean = (session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN)==null
	                                     ? new CedentePrincipalBean()
	                                     : (CedentePrincipalBean) session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN));

	CedenteConteudoListaBean filtroBean = (session.getAttribute(CedenteEstrategia.ALTERAR_FILTRO_BEAN)==null
	                                      ? new CedenteConteudoListaBean()
	                                      : (CedenteConteudoListaBean) session.getAttribute(CedenteEstrategia.ALTERAR_FILTRO_BEAN));

	String nsuTransacao = filtroBean.getNsuTransacao();

	int guiaAberta = principalBean.getGuiaAberta() == null ? CedenteEstrategia.GUIA_NENHUMA : principalBean.getGuiaAberta().intValue();
	int guiaEmCadastramento = principalBean.getGuiaEmCadastramento() == 0 ? CedenteEstrategia.GUIA_GERAL : principalBean.getGuiaEmCadastramento();
	int guiaInclusao = principalBean.getUltimaGuiaCadastrada() == null ? CedenteEstrategia.GUIA_NENHUMA + 1 : principalBean.getUltimaGuiaCadastrada().intValue() + 1;
	int ultimaGuiaCadastrada = principalBean.getUltimaGuiaCadastrada() == null ? CedenteEstrategia.GUIA_NENHUMA : principalBean.getUltimaGuiaCadastrada().intValue();
	String situacaoGuia = principalBean.getSituacaoGuia() == null ? CedenteEstrategia.CONSULTA : principalBean.getSituacaoGuia();
	String tipoCobranca = principalBean.getTipoCobranca() == null ? ""+CedenteEstrategia.COBRANCA_CONVENCIONAL : ""+principalBean.getTipoCobranca();
	String cedenteCentralizador = principalBean.getCedenteCentralizador() == null ? "0" : ""+principalBean.getCedenteCentralizador();
	
	
	String COCLI = cabecaBean.getCodigoClienteCOCLIZeros();

	String PV = (String) session.getAttribute("PVVinculado");
	String codigoCedente = "";
	if (filtroBean.getCodigoCedente() != null) {
		codigoCedente = "" + filtroBean.getCodigoCedente();
	}


%>

<%
	InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean)session.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
	CedenteParametrosBean parametrosBean = (request.getAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN) == null ? new CedenteParametrosBean() : (CedenteParametrosBean) request.getAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN));
	String tipo = parametrosBean.getTipoCalculo();
	String autorizacao = parametrosBean.getAutorizacao();
	String icgarantia = parametrosBean.getIcgarantia();
	
	String icboleto = (String) parametrosBean.getIcboleto();
	
	String icvalor = (String) parametrosBean.getIcgarantia();
	
	String creditoOnline = (String) parametrosBean.getCreditoOnline();
	
	String clienteExterno = (String) parametrosBean.getClienteExterno();
	
	String icFinalizacao = (String) parametrosBean.getIcFinalizacao();
	
	String codigoContabil = (String) parametrosBean.getCodigoContabil();
	
	String codigoContabilDeb = (String) parametrosBean.getCodigoContabilDeb();
	
	String unidadeCredito = (String) parametrosBean.getUnidadeCredito();
	
	String icRateio = (String) parametrosBean.getIcRateio();
	
	String icCedenteGarantia = (String) parametrosBean.getIcCedenteGarantia();
	
	String icContaGarantia = (String) parametrosBean.getIcContaGar();
	
	String icBaixaPermitida = (String) parametrosBean.getIcBaixa();
	
	String icMarcado = (String) parametrosBean.getIcMarcado();
	
	String icDesmarcado = (String) parametrosBean.getIcDesmarcado();
	
	String icContaGar = (String) parametrosBean.getIcContaGar();
	
	String icLancamento = (String) parametrosBean.getIcLancamento();
	
	String icProposta = (String) parametrosBean.getIcProposta();
	
	String icCEP = (String) parametrosBean.getIcCEP();
	
	String icDebitoTarifa = (String) parametrosBean.getIcDebitoTarifa();
	
	String icBeneficiario = (String) parametrosBean.getIcBeneficiario();
	
	String nuSITCS = Util.zerosEsquerda(parametrosBean.getNuSITCS(),6);
	
	String operacao = "";
	if (parametrosBean.getNuOperacao() != null) {
		operacao = "" +  Util.zerosEsquerda(parametrosBean.getNuOperacao(), 4) ;
	}
	
	String nuContrato = parametrosBean.getNuContrato();
	
	String agCta = "";
	if (parametrosBean.getAgCta() != null) {
		agCta = "" + Util.zerosEsquerda(parametrosBean.getAgCta(),4);
	}
	
	String opeCta= "";
	if (parametrosBean.getOpeCta() != null){
		opeCta= "" +Util.zerosEsquerda(parametrosBean.getOpeCta(),4);
	}
	
	
	String numCta = "";
	if (parametrosBean.getNumCta()!=null){
		numCta = ""  + Util.zerosEsquerda(parametrosBean.getNumCta(),12);
	}
	
	
	String digCta = "";
	if (parametrosBean.getDigCta() !=null){
		digCta = "" + parametrosBean.getDigCta();
	}
	
	String codEventoGar = "";
	if (parametrosBean.getNuEvento()!=null){
		codEventoGar = ""+ Util.zerosEsquerda(parametrosBean.getNuEvento(),6);
	}
	
	
	String autCCA = (String) parametrosBean.getAutCCA();
	
	
	String icIndiceEspecial=(String) parametrosBean.getIcIndiceEspecial();
	
	String tpIndice=(String) parametrosBean.getTpIndice().trim();
	
	String icAplIndiceEspecial=(String) parametrosBean.getIcAplIndiceEspecial();
	
	String valorlimite =parametrosBean.getValorLimite().toString().equals("R$ 0,00")?"":parametrosBean.getValorLimite().toString();
%>
	<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<html>

  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteIncluirGuiaControle" fluxo="normal">
   		<s:Menu/>
   		<s:Titulo name="Incluir Cedente"/>

			<input type="hidden" name="guiaAberta" value="<%= guiaAberta %>">
			<input type="hidden" name="ultimaGuiaCadastrada" value="<%= ultimaGuiaCadastrada %>">
			<input type="hidden" name="situacaoGuia" value="<%= situacaoGuia %>">
			<input type="hidden" name="tipoCobranca" value="<%= tipoCobranca %>">
			<input type="hidden" name="cedenteCentralizador" value="<%= cedenteCentralizador %>">						

			<input type="hidden" name="nsuTransacao" value="<%= nsuTransacao %>">
			<input type="hidden" name="codigoCedente" value="<%= codigoCedente %>">
			
			<input type="hidden" name="codigoClienteCOCLI" value="<%= COCLI %>">
			<input type="hidden" name="PVVinculado" value="<%= parametrosBean.getCodigoUnidadePVVinc() %>">

			<input type="hidden" name="tipoCalculo" value="<%=tipo%>">
			<input type="hidden" name="autorizacao" value="<%=autorizacao%>">
			<input type="hidden" name="icgarantia" value="<%=icgarantia%>">
			<input type="hidden" name="icboleto" value="<%= icboleto %>">
			<input type="hidden" name="icvalor" value="<%= icvalor %>">
			<input type="hidden" name="creditoOnline" value="<%= creditoOnline %>">
			<input type="hidden" name="clienteExterno" value="<%= clienteExterno %>">
			<input type="hidden" name="icFinalizacao" value="<%= icFinalizacao %>">
			<input type="hidden" name="unidadeCredito" value="<%= unidadeCredito %>">
			<input type="hidden" name="carteira" value="">
			<input type="hidden" name="cc" value="<%= codigoContabil %>">
			<input type="hidden" name="ccDeb" value="<%= codigoContabilDeb %>">
			<input type="hidden" name="icRateio" value="<%= icRateio %>">
			<input type="hidden" name="icDebitoTarifa" value="<%= icDebitoTarifa %>">
			<input type="hidden" name="icCEP" value="<%= icCEP %>">
			
			
			<input type="hidden" name="cmbGarantiaAtual" value="N">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

						<%-- *********** CABECALHO CEDENTE ****************** --%>
            <%@include file="cedente_cabecalho.jsp" %>
            
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Manter Guias:
                <hr>
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#GeralParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_GERAL%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Gerali"></a>
                <a name="GeralParent">Geral</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_GERAL) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* GERAL ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#FloatParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_FLOAT%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Floati"></a>
                <a name="FloatParent">Float</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_FLOAT) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* FLOAT ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#ContasParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CONTAS%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Contasi"></a>
                <a name="contasParent">Contas Déb. Créd. e Rateio</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_CONTAS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* CONTAS ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#CedenteParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CEDENTE_ELETRONICO%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Cedentei"></a>
                <a name="CedenteParent">Cedente Eletrônico</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_CEDENTE_ELETRONICO) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* CEDENTE ELETRONICO ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#BloquetosParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_BLOQUETOS%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Bloquetosi"></a>
                <a name="BloquetosParent">Boletos</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_BLOQUETOS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* BLOQUETOS ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#MensagemParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_MENSAGENS%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Mensagemi"></a>
                <a name="MensagemParent">Mensagens para Boletos</a>                
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_MENSAGENS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* MENSAGEM ************************************** -->
              </td>
            </tr>

			<tr>
				<td class="textoTitulo"><a href="#TarifasParent"
					onclick="javascript:trocaGuia(7);"> <img
					src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
					height="11" name="outlineplus" id="Tarifasi"></a> <a
					name="TarifasParent">Tarifas</a></td>
				<td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_TARIFAS) %>
				</td>
			</tr>
			<tr>
				<td colspan="4"><!-- ************************************************* TARIFAS ************************************** -->
				</td>
			</tr>

            <tr>
              <td class="textoTitulo">
                <a href="#TarifasParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_TARIFAS%>);">
                	 <img src="<%=Paths.getImagePath()%>/outlineminus.gif" width="11" height="11" name="outline" id="Tarifasi"></a>
                <a name="ParametrosParent">Parâmetros</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_PARAMETROS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* PARAMETROS ************************************** -->

				<div class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr> 
                      <td colspan="4" class="textoDestaqueTitulo">Guia: Parâmetros</td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                    <tr> 
                      <td colspan="4">
                      	<table border="1">
                      	<tr><td>
                      	<table  cellpadding=0 width=688   style='width:515.8pt;mso-cellspacing:1.5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
                      	<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
   						   	 <td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
    							Atualizar Título Vencido Boleto Expresso
    						 </td>
   							 <td class="textoTitulo" width="13%" style='width:13.72%;padding:.75pt .75pt .75pt .75pt'>
			                      <%
			                      if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM") || usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBOPE")  ){
								  %>
			                       <select size="1" name="cmbBloqExpresso">
			                       <%if (icboleto.equalsIgnoreCase("N")) { %>
										<option selected value="N">NÃO</option>
										<option value="S">SIM</option>
									<%} else { %>
										<option  value="N">NÃO</option>
										<option selected value="S">SIM</option>
									<%} %>
									</select>
								  <%}else{ %>
								    <select size="1" name="cmbBloqExpresso">
			                      
										<option selected value="N">NÃO</option>
										
									</select>
								  <%} %>
							</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
   						   	 <td>&nbsp;</td>
							 <td>&nbsp;</td>
							 <td>&nbsp;</td>
							 <td>&nbsp;</td>
			            </tr>
						
   						<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
   							 <td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
    							Cedente Garantia de Crédito
    						 </td>
    						<td class="textoTitulo" width="13%" style='width:13.4%;padding:.75pt .75pt .75pt .75pt'>
    							<select name="icCedenteGarantia" onchange="javascript:trataGarantia()">
										<option <%=icCedenteGarantia.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
										<option <%=icCedenteGarantia.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
    							</select>
    						</td>
    						
    						 <td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
    							Cedente Emissor de Boleto Proposta
    						 </td>
   							 <td class="textoTitulo" width="12%" style='width:12.72%;padding:.75pt .75pt .75pt .75pt'>
   							 	<select size="1" name="icProposta">
   							 		<option <%=icProposta.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
   							 		<option <%=icProposta.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
   							 	</select>
			            	 </td>
   						</tr>
   						
			   			<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
				  		 <td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
								Indicador de Cálculo de Encargo com Índice Especial:
					 		 </td>
					 		 <td class="textoTitulo" width="13%" style='width:13.72%;padding:.75pt .75pt .75pt .75pt'>
					 		<select size="1" name="icIndiceEspecial" onchange="javascript: cmbIcIndiceEspecial()">
							<option <%=icIndiceEspecial.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
							<option <%=icIndiceEspecial.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
							</select>
					 		 </td>
					 		  <td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
    							Crítica de CEP e UF do Sacado
    						 </td>
   							 <td class="textoTitulo" width="12%" style='width:12.72%;padding:.75pt .75pt .75pt .75pt'>
   							 	<select size="1" name="cmbCEP">
   							 		<option <%=icCEP.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
   							 		<option <%=icCEP.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
   							 	</select>
			            	 </td>
					 	 </tr>
	    						 	 
					 	 <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
					 	  	 <td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
								Tipo de Índice Especial :
					 		 </td>
					 		 <td class="textoTitulo" width="13%" style='width:13.72%;padding:.75pt .75pt .75pt .75pt'>
					 		 	<s:ComboIndice	name="tpIndice" branco="true" disabled="true" />
					 		 </td>
				 		 </tr>
				 		 <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
					 	  	 <td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
								Indicador de Aplicação do Índice Especial :
					 		 </td>
					 		 <td class="textoTitulo" colspan="3" width="43%" style='width:43.72%;padding:.75pt .75pt .75pt .75pt'>
								<select name="icAplIndiceEspecial" disabled="disabled" >
							 		 	    <option <%=icAplIndiceEspecial.equals("00") ? "selected='selected'" : ""%> value="00">&nbsp;</option>
								<option <%=icAplIndiceEspecial.equals("01") ? "selected='selected'" : ""%> value="01">Antes de Multa/Juros/Encargos</option>
								<option <%=icAplIndiceEspecial.equals("02") ? "selected='selected'" : ""%> value="02">Depois de Multa/Juros/Encargos</option>
							</select>
							</td>
				 		 </tr>
   						

  						</table>
  						</td></tr>
  						</table>
                      </td>
                    </tr>
                    
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                    <tr> 
                      <td class="textoTitulo" colspan="4">
                        <table border="1">
                      	<tr><td class="textoTitulo">
                      
                      &nbsp;<b style='mso-bidi-font-weight:normal'>
  					  &#9658;Parâmetros Cedente Garantia de Crédito </b>
  					  <table class="textoTitulo" border="0"  cellpadding=0 width=688   style='width:515.8pt;mso-cellspacing:1.5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
   						<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
    						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt'>
    							Operação
    						</td>
    						<td class="textoTitulo" width="8%" style='width:8.28%;padding:.75pt .75pt .75pt .75pt'>
    								<p:InputNumerico CLASS="inputtext" name="nuOperacao" value="<%= operacao %>" size="5" maxlength="4" disabled="true"/>
    						</td>
    						<td class="textoTitulo" width="8%" style='width:8.92%;padding:0cm 5.4pt 0cm 5.4pt'>
    							Nº Contrato
    						</td>
    						<td width="35%" colspan=4 style='width:35.86%;padding:0cm 5.4pt 0cm 5.4pt'>
    								<p:InputAlfanumerico CLASS="inputtext" name="nuContrato" value="<%= nuContrato %>" size="40" maxlength="40" disabled="true"/>
    						</td>
   						</tr>
   						<tr style='mso-yfti-irow:1'>
    						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt'>
    							Títulos garantia de crédito - baixa  permitida somente na Agência (rejeitar solicitações de baixa via Remessa) 
						    </td>
    						<td class="textoTitulo" width="53%" colspan=6 style='width:53.66%;padding:.75pt .75pt .75pt .75pt'>
    							<SELECT NAME="icBaixa" onchange="javascript: comboBaixa()">
										<option <%=icBaixaPermitida.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
										<option <%=icBaixaPermitida.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option> 
								</SELECT>
							</td>
   						</tr>
   						
   						<tr style='mso-yfti-irow:1'>
    						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt'>
    							Os títulos já existentes na base de dados do Cedente também devem ser marcados como Garantia de Crédito?
						    </td>
    						<td class="textoTitulo" width="53%" colspan=6 style='width:53.66%;padding:.75pt .75pt .75pt .75pt'>
    							<select name="icMarcado" disabled="true">
									<option <%=icMarcado.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
									<option <%=icMarcado.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option> 
								</select>
							</td>
   						</tr>
   						
   						<tr style='mso-yfti-irow:1'>
    						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt'>
    							Os títulos já existentes na base de dados do Cedente devem ser desmarcados, ou seja, retirar Garantia de Crédito?
						    </td>
    						<td class="textoTitulo" width="53%" colspan=6 style='width:53.66%;padding:.75pt .75pt .75pt .75pt'>
    							<SELECT NAME="icDesmarcado" disabled="true">
									<option <%=icDesmarcado.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
									<option <%=icDesmarcado.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option> 
								</SELECT>
							</td>
   						</tr>
   						
   						
   						<tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes;height:14.0pt'> 
	   						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt; height:14.0pt'>
	    						Creditar liquidações de títulos marcados como garantia de crédito em conta diferente da principal
	    					</td>
	    					<td class="textoTitulo" width="8%" style='width:8.28%;padding:.75pt .75pt .75pt .75pt;  height:14.0pt'>
	    						
	    							<SELECT NAME="icContaGar" onchange="javascript: comboCredLiquidacao()">
										<option <%=icContaGar.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
										<option <%=icContaGar.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
									</SELECT>
								
	    					</td>
	    					<td class="textoTitulo" width="17%" colspan=2 valign=top style='width:17.6%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    						Conta Garantia de Crédito
	    					</td>
	    					<td class="textoTitulo" width="7%" valign=top style='width:7.62%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    							<p:InputNumerico CLASS="inputtext" name="agCta" value="<%= agCta %>" size="5" maxlength="4" disabled="true"/>
	    					</td>
	    					<td class="textoTitulo" width="7%" valign=top style='width:7.62%;padding:0cm 5.4pt 0cm 5.4pt;height:14.0pt'>
	    							<p:InputNumerico CLASS="inputtext" name="opeCta" value="<%= opeCta %>" size="5" maxlength="4" disabled="true"/>
	    					</td>
	    					<td class="textoTitulo" width="11%" valign=top style='width:11.38%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    							<p:InputNumerico CLASS="inputtext" name="numCta" value="<%= numCta %>" size="15" maxlength="12" disabled="true"/>
	    					</td>
	    					<td class="textoTitulo" width="11%" valign=top style='width:11.38%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    						<p:InputNumerico CLASS="inputtext" name="digCta" value="<%= digCta %>" size="2" maxlength="1" disabled="true"/>
	    					</td>
   						</tr>
   						
   						
   						<tr style='mso-yfti-irow:1'>
   						
	   						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt; height:14.0pt'>
	    						Creditar liquidações de títulos marcados como garantia de crédito em evento contábil
	    					</td>
	    					<td class="textoTitulo" width="8%" style='width:8.28%;padding:.75pt .75pt .75pt .75pt;  height:14.0pt'>
	    						<SELECT NAME="icLancamento" onchange="javascript:comboEventoContabil();" disabled="true">
										<option <%=icLancamento.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
										<option <%=icLancamento.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option> 
								</SELECT>
								
	    					</td>
	    					<td class="textoTitulo" width="17%" colspan=2 valign=top style='width:17.6%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    						Código do evento contábil para garantia de crédito
	    					</td>
	    					<td class="textoTitulo" width="7%" colspan="3" valign=top style='width:7.62%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    							<p:InputNumerico CLASS="inputtext" name="nuEvento" value="<%= codEventoGar %>" size="7" maxlength="6" disabled="true"/>
	    					</td>
	    				
   						</tr>
   						
   						
   				   
  						</table>
  						</td></tr>
  						</table>
                      
                      </td>
                    </tr>
                    
                    
                    <tr> 
                      <td  class="textoTitulo" colspan="8">
                        <table border="1">
                      	<tr><td class="textoTitulo">
                      
                      &nbsp;&#9658;Parâmetros DDA (exclusivo Gestor) 
  					  	<table  cellpadding=0 width=688 style='width:515.8pt;mso-cellspacing:1.5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
	   						<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
	    						<td  class="textoTitulo" width=169 style='width:126.55pt;padding:.75pt .75pt .75pt .75pt'>
	    						Arquivo DDA/CIP - Produto
	    						</td>
	    						<td  class="textoTitulo" width=130 style='width:97.5pt;padding:.75pt .75pt .75pt .75pt'>
	    								<select size="1" name="cmbCarteira">
                      						<option selected  value="COBRANCA">COBRANCA</option>
                      					</select>
	    						</td>
	   						</tr>
	   						<tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
	    						<td  class="textoTitulo" width=169 style='width:126.55pt;padding:.75pt .75pt .75pt .75pt'>
	    							DDA Vencido - Autorização de alteração do valor a cobrar
	    						</td>
	    						<td  class="textoTitulo" width=130 style='width:97.5pt;padding:.75pt .75pt .75pt .75pt'>
	    								   <%
										     if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")  ){
										   %>
					                       <select size="1" name="cmbAutorizacao">
					                   
												<option selected value="N">NÃO</option>
												<option value="S">SIM</option>
											
											</select>
											<%
											}else{
											%>
												<select size="1" name="cmbAutorizacao">
					                   
												<option selected value="N">NÃO</option>
												
											
											</select>
											<%
											}
					                        %>
	    						</td>
	    						<td width=381 colspan=2 style='width:285.75pt;padding:.75pt .75pt .75pt .75pt'>
	    							&nbsp;
	    						</td>
	   						</tr>
  						</table>
  						</td></tr></table>
                      </td>
                    </tr>

  					
  					<tr> 
                      <td  class="textoTitulo" colspan="6">
                        <table border="1" width="100%">
                      	<tr><td class="textoTitulo">
                      
  					         &nbsp;&#9658;Outros Parâmetros (exclusivo Gestor)
					  	<table class="textoTitulo"  cellpadding=0 width="100%"  style='width:100.0%;mso-cellspacing:1.5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
					  
					  <tr>
                      <td class="textoTitulo" width="17%">Arquivo controle de garantias:</td>
                      <td class="textoValor" width="26%">
                       <%
					     if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM") ){
					  %>
                       <select size="1" name="cmbIcgarantia">
                   
							<option selected value="N">NÃO</option>
							<option value="S">SIM</option>
						
						</select>
						<%
						}else{
						%>
							<select size="1" name="cmbIcgarantia">
                   
							<option selected value="N">NÃO</option>
							
						
						</select>
						<%
						}
                        %>
                      </td>
                       <td class="textoTitulo" width="17%">Liberação de Valor Máximo de Título:</td>
                      <td class="textoValor" width="26%">
                      <%
                      if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")  ){
					  %>
                       <select size="1" name="cmbValorBoleto"  onchange="liberaValor()">
                       <%if (icboleto.equalsIgnoreCase("N")) { %>
							<option selected value="N">NÃO</option>
							<option value="S">SIM</option>
						<%} else { %>
							<option  value="N">NÃO</option>
							<option selected value="S">SIM</option>
						<%} %>
						</select>
					  <%}else{ %>
					    <select size="1" name="cmbValorBoleto">
                      
							<option selected value="N">NÃO</option>
							
						</select>
					  <%} %>
					  <p:InputCurrency name="valorLimite" maxlength="17" size="15" 
                						CLASS="inputtext"
                						value="<%=valorlimite %>"
                						onFocus="javascript: prevFocus(this);"
														onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.endossoCombo);"/> 
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Crédito On Line:</td>
                      <td class="textoValor" width="26%">
                      <%
                      if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")  ){
					  %>
                       <select size="1" name="cmbCreditoOnLine">
                       <%if (creditoOnline.equalsIgnoreCase("N")) { %>
							<option selected value="N">NÃO</option>
							<option value="S">SIM</option>
						<%} else { %>
							<option  value="N">NÃO</option>
							<option selected value="S">SIM</option>
						<%} %>
						</select>
					  <%}else{ %>
					    <select size="1" name="cmbCreditoOnLine">
                      
							<option selected value="N">NÃO</option>
							
						</select>
					  <%} %>
					  
                      </td>
                      <td class="textoTitulo" width="17%">Cliente Externo</td>
					  <td>
							 <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")  ){
					  		 %>
					  		  <select size="1" name="cmbClienteExterno"  onchange="liberaUnidade()">
					  		   <%if (clienteExterno.equalsIgnoreCase("N")) { %>
					  					<option selected value="N">NÃO</option>
										<option value="S">SIM</option>
							   <%} else { %>
							   			<option value="N">NÃO</option>
										<option selected value="S">SIM</option>
							   <%} %>
							   </select>
							 <%} else { %>
							 	<select size="1" name="cmbClienteExterno">
							 		<option selected value="S">SIM</option>
							 	</select>
							 <%} %>
					  </td> 
                      
					</tr>

					<tr>
						<td class="textoTitulo" width="17%">Finalização Diferenciada</td>
						<td>
							 <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")  ){
					  		 %>
					  		  <select size="1" name="cmbIcFinalizacao" onchange="liberaUnidade()">
					  		   <%if (icFinalizacao.equalsIgnoreCase("N")) { %>
					  					<option selected value="N">NÃO</option>
										<option value="S">SIM</option>
							   <%} else { %>
							   			<option value="N">NÃO</option>
										<option selected value="S">SIM</option>
							   <%} %>
							   </select>
							 <%} else { %>
							 	<select size="1" name="cmbIcFinalizacao">
							 		<option selected value="N">NÃO</option>
							 	</select>
							 <%} %>
						</td>
						<td class="textoTitulo" width="17%">Evento Contábil Crédito</td>
						<td>
							 <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")  ){
					  		 %>
					  		   <p:InputNumerico CLASS="inputtext" name="codigoContabil" value="<%= codigoContabil %>" size="8" maxlength="6" disabled="true"/>
							 	
							 <%} else { %>

								<p:InputNumerico CLASS="inputtext" name="codigoContabil" value="<%= codigoContabil %>" size="8" maxlength="6" disabled="true"/>
							 
							 <%} %>
						</td>
						   	   
					</tr>
					
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td class="textoTitulo" width="17%">Evento Contábil Débito</td>
						<td>
							 <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM") ){
					  		 %>
					  		   <p:InputNumerico CLASS="inputtext" name="codigoContabilDebito" value="<%= codigoContabilDeb %>" size="8" maxlength="6" disabled="true"/>
							 	
							 <%} else { %>

								<p:InputNumerico CLASS="inputtext" name="codigoContabilDebito" value="<%= codigoContabilDeb %>" size="8" maxlength="6" disabled="true"/>
							 
							 <%} %>
						</td>
						
					</tr>
					
					<tr>
						<td class="textoTitulo" width="17%">Unidade Destino Crédito:</td>
						<td class="textoTitulo">
							   <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")  ){
					  		   %>
					  		  		<select size="1" name="cmbUnidadeCredito" disabled="true">
					  					<option <%=unidadeCredito.equals("0") ? "selected='selected'" : ""%> value="0"></option>
										<option <%=unidadeCredito.equals("1") ? "selected='selected'" : ""%> value="1">Agência de vinculação</option>
										<option <%=unidadeCredito.equals("2") ? "selected='selected'" : ""%> value="2">Agência da conta corrente</option>
										<option <%=unidadeCredito.equals("3") ? "selected='selected'" : ""%> value="3">Agência em branco</option>
							   <%} else { %>
							   		<select size="1" name="cmbUnidadeCredito" disabled="true">
							   			<option value="0"></option>
							   		
							   <%} %>
							   	</select>
						</td>
						<td class="textoTitulo" width="17%">Rateio de Título:</td>
						<td class="textoTitulo">
							   <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM") || usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBRET")  ){
					  		   %>
					  		  		<select size="1" name="cmbRateio" >
					  					<option value="S">SIM</option>
										<option selected='selected'  value="N">NÃO</option>
							   <%} else { %>
									<select size="1" name="cmbRateio" >
										<option <%=icRateio.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
							   <%} %>
							   </select>
							   		
						</td>
						
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Comando de Débito de Tarifa:</td>
						<td class="textoTitulo">
							   <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM") || usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBRET")  ){
					  		   %>
					  		  		<select size="1" name="cmbDebitoTarifa" >
					  					<option <%=icDebitoTarifa.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
										<option <%=icDebitoTarifa.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
									</select>
							   <%} else { %>
							   		<select size="1" name="cmbDebitoTarifa" disabled="true" >
					  					<option <%=icDebitoTarifa.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
										<option <%=icDebitoTarifa.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
									</select>
							   
							   <%} %>

							   		
						</td>
					</tr>
					  	
					<tr>
						<td class="textoTitulo" width="17%">Tipo de Beneficiário:</td>
						<td class="textoTitulo">
							   <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM") || usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBRET")  ){
					  		   %>
					  		  		<select size="1" name="icBeneficiario" onchange="liberaTCS()" >
					  					<option <%=icBeneficiario.equals("00") ? "selected='selected'" : ""%> value="00">PADRÃO</option>
										<option <%=icBeneficiario.equals("01") ? "selected='selected'" : ""%> value="01">SITCS</option>
										<option <%=icBeneficiario.equals("02") ? "selected='selected'" : ""%> value="02">CARTÃO CRÉDITO</option>
										<option <%=icBeneficiario.equals("03") ? "selected='selected'" : ""%> value="03">CRÉDITO IMOBILIÁRIO</option>
										<option <%=icBeneficiario.equals("04") ? "selected='selected'" : ""%> value="04">UL/CCA</option>
									</select>
							   <%} else { %>
							   		<select size="1" name="icBeneficiario" disabled="true" >
					  					<option <%=icBeneficiario.equals("00") ? "selected='selected'" : ""%> value="00">PADRÃO</option>
										<option <%=icBeneficiario.equals("01") ? "selected='selected'" : ""%> value="01">SITCS</option>
										<option <%=icBeneficiario.equals("02") ? "selected='selected'" : ""%> value="02">CARTÃO CRÉDITO</option>
										<option <%=icBeneficiario.equals("03") ? "selected='selected'" : ""%> value="03">CRÉDITO IMOBILIÁRIO</option>
										<option <%=icBeneficiario.equals("04") ? "selected='selected'" : ""%> value="04">UL/CCA</option>
									</select>
							   
							   <%} %>

							   		
						</td>
						<td class="textoTitulo" width="17%">Código da Entidade Sindical:</td>
						<td class="textoTitulo">
							<p:InputNumerico CLASS="inputtext" name="nuSITCS" value="<%= nuSITCS %>" size="8" maxlength="6" disabled="true"/>
						</td>
					</tr>					  	

					<tr>
					
						<td class="textoTitulo" width="17%">Autorização Pagamento Boleto no Canal CCA para Beneficiário UL/CCA:</td>
						<td class="textoTitulo">
							   <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
					  		   %>
					  		   		<select size="1" name="autCCA"  disabled="disabled" >
					  					<option <%=autCCA.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
										<option <%=autCCA.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
									</select>
							   <%} else { %>
							   		<select size="1" name="autCCA" disabled="disabled" >
					  					<option <%=autCCA.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
										<option <%=autCCA.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
									</select>
							   <%} %>
							   
					
					</tr>


					  	
					  	
					  	</table>
					  	</td></tr></table>
					  </td>
					  </tr>

                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>



                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr>
                      <td align="right" colspan="4">
                        <p align="center"> 
                          <s:Button name="Confirmar" value="Confirmar" action="javascript:formSubmit_Parametro();" userGroup="<%=usuarioLDAPBean.getNomeGrupo()%>" internalAction="cedente.cadastro.manter.alterar" />
                          <s:Button name="Cancelar" value="Cancelar" action="javascript:fecharGuias();" userGroup="<%=usuarioLDAPBean.getNomeGrupo()%>" internalAction="cedente.cadastro.manter.alterar"/>
                        </p>
                      </td>
                    </tr>			                    

                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                  </table>
								</div>

              </td>
              <tr>
              <td class="textoTitulo">
                <a href="#PermissaoParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_PERMISSAO%>);">
                	 <img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Permissaoi"></a>
                <a name="PermissaoParent">Permissão</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_PERMISSAO) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
					<!-- ************************************************* Permissão ************************************** -->
              </td>
            </tr>
					<tr>
						<td class="textoTitulo"><a href="#ConclusaoParent"
							onclick="javascript:trocaGuia(<%= CedenteEstrategia.GUIA_CONCLUSAO %>);"> <img
							src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
							height="11" name="outlineplus" id="Conclusaoi"></a> <a
							name="ConclusaoParent">Conclusão</a></td>
						<td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_CONCLUSAO) %>
						</td>
					</tr>
 			<tr>
              <td class="textoTitulo">
                <a href="#ParametroParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_PERMISSAO%>);">
                	 <img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Tarifasi"></a>
                <a name="TarifasParent">Permissão</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_PERMISSAO) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
					<!-- ************************************************* Permissão ************************************** -->
              </td>
           
            <tr>
              <td colspan="4">
								<!-- ************************************************* CONCLUSAO ************************************** -->
              </td>
            </tr>
            <tr> 
            	<td colspan="4">&nbsp;</td>
            </tr>
            <tr>
             <td align="right" colspan="4">
	               <p align="center"> 
                  <s:Button name="Voltar_Principal" value="Voltar" action="javascript:formSubmit_Voltar();"/>
                  <s:Button name="Cancelar_Principal" value="Cancelar Alteração" action="javascript:formSubmit_Cancelar();"/>
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

    <script language="javascript">
	    var janelaParametro = null;
    
	    function inicia(){
	    	trataGarantia();
	    	liberaUnidade();
	    	liberaTCS();
	    	cmbIcIndiceEspecial();

<%
	// caso retornou da estrategia com criticas
	if (!descCriticas.equals("")) {
%>
				alert("<%= descCriticas %>");
<%
	}
%>
	    }

		function formSubmit_Cancelar() {
        var confirma = confirm(conf('126'));
      
        if (confirma) {
	    		fecharjanelaParametro();

          document.frmMain.estrategia.value="cedente.CedenteAlterarCancelar";
          document.frmMain.submit();
        }
			}

	    function formSubmit_Voltar() {
	      var confirma = confirm(conf('161'));
      
        if (confirma) {
        	fecharjanelaParametro();
        
        	document.frmMain.fluxo.value = "voltar";
          document.frmMain.estrategia.value="cedente.CedenteManterFiltro";
          document.frmMain.submit();
        }
	    }
	    
	    function trocaGuia( guia ) {
	    	var guiaInclusao = <%= guiaInclusao %>;
	    	var guiaEmCadastramento = <%= guiaEmCadastramento %>;
	    
	    	if (guia == <%= guiaAberta %>) {
	    		fecharGuias();
	    		return;
	    	}

	    	if (guia == <%= CedenteEstrategia.GUIA_CEDENTE_ELETRONICO %>
	    				&& <%= principalBean.naoPodeCedenteEletronico() %>) {
	    			return;
	    	}
	    
				// fecha janela de tarifa se estiver aberta
				if (janelaTarifa != null && !janelaTarifa.closed) {
					if (confirm(conf('142'))) {
						fecharJanelaTarifa();
					} else {
						return;
					}
	    	}

        if (guia == guiaInclusao && guiaInclusao == guiaEmCadastramento) {
		    	if (!confirm(conf("106"))) {
		    		return;
		    	}
        
	    		document.frmMain.situacaoGuia.value = "<%= CedenteEstrategia.INCLUSAO %>";
		    	document.frmMain.guiaAberta.value = guia;
		    	document.frmMain.submit();
		    } else if (guia < guiaInclusao) {
		    	if (!confirm(conf("106"))) {
		    		return;
		    	}
		    
	    		document.frmMain.situacaoGuia.value = "<%= CedenteEstrategia.ALTERACAO_EM_INCLUSAO %>";
		    	document.frmMain.guiaAberta.value = guia;
		    	document.frmMain.submit();
		    }
	    }
	    
	    function fecharGuias() {
				// fecha janela de tarifa se estiver aberta
				if (janelaParametro != null && !janelaParametro.closed) {
					if (confirm(conf('142'))) {
						fecharjanelaParametro();
					} else {
						return;
					}
	    	}
	    
	    	document.frmMain.guiaAberta.value = <%= CedenteEstrategia.GUIA_NENHUMA %>;
	    	document.frmMain.submit();
	    }
	    
	    function formSubmit() {
	    	formSubmit_Tarifas();
	    }
	    
	    function liberaUnidade(){
	    	var cliExterno = document.frmMain.cmbClienteExterno.value;
	    	var icFinal = document.frmMain.cmbIcFinalizacao.value;

	    	if (cliExterno=="N"){
	    		document.frmMain.cmbUnidadeCredito.disabled=false;
	    		document.frmMain.codigoContabil.disabled=false;
	    	} else {
	    		if (icFinal=="S") {
		    		document.frmMain.cmbUnidadeCredito.disabled=false;
		    		document.frmMain.codigoContabil.disabled=false;
	    		} else {
		    		document.frmMain.codigoContabil.value="";
		    		document.frmMain.cmbUnidadeCredito.value="0";
		    		document.frmMain.cmbUnidadeCredito.disabled=true;
		    		document.frmMain.codigoContabil.disabled=true;
	    		}
	    		
	    	}
	    	
    		if (icFinal=="S") {
	    		document.frmMain.codigoContabilDebito.disabled=false;
    		} else {
	    		document.frmMain.codigoContabilDebito.value="";
	    		document.frmMain.codigoContabilDebito.disabled=true;
    		}

	    	
	    	
	    
	    	
	    }
	    
	    function formSubmit_Parametro() {
				// fecha janela de tarifa se estiver aberta
				if (janelaParametro != null && !janelaParametro.closed) {
					if (confirm(conf('142'))) {
						fecharjanelaParametro();
					} else {
						return;
					}
	    	}

	    	if (validaSubmit_Parametro()) {
	    		var confirma = confirm(conf('127'));
	    	
		    	if (confirma) {
			    	document.frmMain.estrategia.value="cedente.CedenteIncluirGuiaParametroFinalizar";
			    	document.frmMain.tipoCalculo.value="01";
			    	document.frmMain.autorizacao.value=document.frmMain.cmbAutorizacao.value;
			    	document.frmMain.icgarantia.value=document.frmMain.cmbIcgarantia.value;
			    	document.frmMain.carteira.value=document.frmMain.cmbCarteira.value;
			    	document.frmMain.icboleto.value=document.frmMain.cmbBloqExpresso.value;
			    	document.frmMain.icvalor.value=document.frmMain.cmbValorBoleto.value;
			    	document.frmMain.creditoOnline.value=document.frmMain.cmbCreditoOnLine.value;
			    	document.frmMain.clienteExterno.value=document.frmMain.cmbClienteExterno.value;
			    	document.frmMain.icFinalizacao.value=document.frmMain.cmbIcFinalizacao.value;
			    	document.frmMain.unidadeCredito.value=document.frmMain.cmbUnidadeCredito.value;
			    	document.frmMain.cc.value=document.frmMain.codigoContabil.value;
			    	document.frmMain.ccDeb.value=document.frmMain.codigoContabilDebito.value;
			    	document.frmMain.icRateio.value=document.frmMain.cmbRateio.value;
			    	document.frmMain.icCEP.value=document.frmMain.cmbCEP.value;
			    	document.frmMain.icDebitoTarifa.value=document.frmMain.cmbDebitoTarifa.value;
			    	document.frmMain.submit();
			    }
		   	}
	    }

	   
	    
	    function fecharjanelaParametro() {
	    	if (janelaParametro != null && !janelaParametro.closed) {
			   	janelaParametro.close();
			  }
	    }
	    
	    function validaSubmit_Parametro() {

	    	return true;
	    }

	    
	    function trataGarantia(){
	    	

	    	if (document.frmMain.icCedenteGarantia.value=="N"){
		    	document.frmMain.nuOperacao.disabled =true;
		    	document.frmMain.nuContrato.disabled =true;
		    	document.frmMain.icBaixa.disabled =true;
		    	document.frmMain.icMarcado.disabled =true;
		    	document.frmMain.icDesmarcado.disabled =true;
		    	document.frmMain.icContaGar.disabled =true;
		    	document.frmMain.agCta.disabled =true;
		    	document.frmMain.opeCta.disabled =true;
		    	document.frmMain.numCta.disabled =true;
		    	document.frmMain.digCta.disabled =true;
		    	document.frmMain.icLancamento.disabled=true;
		    	document.frmMain.nuEvento.disabled =true;
		    	document.frmMain.nuOperacao.value="";
		    	document.frmMain.nuContrato.value="";
		    	document.frmMain.icBaixa.value="N";
		    	document.frmMain.icContaGar.value="N";
		    	document.frmMain.agCta.value="";
		    	document.frmMain.opeCta.value="";
		    	document.frmMain.numCta.value="";
		    	document.frmMain.digCta.value="";
		    	document.frmMain.agCta.disabled =true;
		    	document.frmMain.opeCta.disabled =true;
		    	document.frmMain.numCta.disabled =true;
		    	document.frmMain.digCta.disabled =true;
		    	document.frmMain.icLancamento.value="N";
		    	document.frmMain.nuEvento.value="";	
		    	document.frmMain.icBaixa.value="S";
		    	document.frmMain.icContaGar.value="S";
		    	document.frmMain.cmbGarantiaAtual.value="S";
	    	}else{
		    	document.frmMain.nuOperacao.disabled =false;
		    	document.frmMain.nuContrato.disabled =false;
		    	document.frmMain.icBaixa.disabled =false;
		    	document.frmMain.icContaGar.disabled =false;
		    	document.frmMain.icLancamento.disabled=false;
		    	document.frmMain.icMarcado.disabled =true;
		    	document.frmMain.icDesmarcado.disabled =true;
		    	comboCredLiquidacao();
		    	
	    	}
	    	comboCredLiquidacao();
	    	comboEventoContabil();
	    	
	    	comboBaixa();
	    }
	    
	    function comboCredLiquidacao(){
	    	
	    	if (document.frmMain.icContaGar.value=="S"  && document.frmMain.icCedenteGarantia.value=="S"){
	    		document.frmMain.agCta.disabled =false;
		    	document.frmMain.opeCta.disabled =false;
		    	document.frmMain.numCta.disabled =false;
		    	document.frmMain.digCta.disabled =false;
	    	}else{
		    	document.frmMain.agCta.value="";
		    	document.frmMain.opeCta.value="";
		    	document.frmMain.numCta.value="";
		    	document.frmMain.digCta.value="";
	    		document.frmMain.agCta.disabled =true;
		    	document.frmMain.opeCta.disabled =true;
		    	document.frmMain.numCta.disabled =true;
		    	document.frmMain.digCta.disabled =true;
	    	}
	    	
	    }
	    
	    function comboEventoContabil(){
	    	
	    	if (document.frmMain.icLancamento.value=="S"){
	    		document.frmMain.nuEvento.disabled =false;
	    	}else{
	    		document.frmMain.nuEvento.value="";
	    		document.frmMain.nuEvento.disabled =true;
	    	}
	    	
	    	
	    }
	    
	    function comboBaixa(){
	    	document.frmMain.icMarcado.disabled =true;
	    	document.frmMain.icMarcado.value="N";
	    	document.frmMain.icDesmarcado.disabled =true;
	    	document.frmMain.icDesmarcado.value="N";
	    	
	    	
	    }
	    
	    function liberaTCS(){
	    	if (document.frmMain.icBeneficiario.value=="01"){
	    		document.frmMain.nuSITCS.disabled =false;
	    		  		
	    	}else{
	    		document.frmMain.nuSITCS.disabled =true;
	    		document.frmMain.nuSITCS.value="000000";
	    	}
	    	
	    	if (document.frmMain.icBeneficiario.value=="04"){
	    		if ('<%=usuarioLDAPBean.getNomeGrupo().toUpperCase()%>'=='GCBADM'){
	    			document.frmMain.autCCA.disabled =false;
	    		}else{
	    			document.frmMain.autCCA.disabled =true;
	    		}
	    		
	    		document.frmMain.cmbBloqExpresso.value = "N";
	    		document.frmMain.icProposta.value = "N";
	    		document.frmMain.cmbCEP.value = "N";
	    		document.frmMain.icCedenteGarantia.value = "N";
	    		document.frmMain.cmbValorBoleto.value = "N";
	    		document.frmMain.cmbCreditoOnLine.value = "N";
	    		document.frmMain.cmbClienteExterno.value = "S";
	    		document.frmMain.cmbIcFinalizacao.value = "N";
	    		
	    		
	    		document.frmMain.cmbBloqExpresso.disabled =true;
	    		document.frmMain.icProposta.disabled =true;
	    		document.frmMain.cmbCEP.disabled =true;
	    		document.frmMain.icCedenteGarantia.disabled =true;
	    		document.frmMain.cmbValorBoleto.disabled =true;
	    		document.frmMain.cmbCreditoOnLine.disabled =true;
	    		document.frmMain.cmbClienteExterno.disabled =true;
	    		document.frmMain.cmbIcFinalizacao.disabled =true;
	    		
	    	}else{
	    		document.frmMain.autCCA.disabled =true;
	    		document.frmMain.autCCA.value="N";
	    		
	    		
	    		document.frmMain.cmbBloqExpresso.disabled =false;
	    		document.frmMain.icProposta.disabled =false;
	    		document.frmMain.cmbCEP.disabled =false;
	    		document.frmMain.icCedenteGarantia.disabled =false;
	    		document.frmMain.cmbValorBoleto.disabled =false;
	    		document.frmMain.cmbCreditoOnLine.disabled =false;
	    		document.frmMain.cmbClienteExterno.disabled =false;
	    		document.frmMain.cmbIcFinalizacao.disabled =false;
	    	}
	    	
	    	
	    	
	    }
	    
	    function cmbIcIndiceEspecial(){
	    	

	      	if (document.frmMain.icIndiceEspecial.value=="S"){
	      		document.frmMain.tpIndice.disabled =false;
	      		document.frmMain.icAplIndiceEspecial.disabled =false;
		    	document.frmMain.tpIndice.value="<%=tpIndice%>";
		    	document.frmMain.icAplIndiceEspecial.value="<%=icAplIndiceEspecial%>";
	      	}else{
	      		document.frmMain.tpIndice.value="&nbsp;"
	      		document.frmMain.icAplIndiceEspecial.value="00";
	      		document.frmMain.tpIndice.disabled =true;
	      		document.frmMain.icAplIndiceEspecial.disabled =true;
	      	}
	      	
	      	
	    	
	    }
	    
	    function liberaValor(){
	    	
	    	if (document.frmMain.cmbValorBoleto.value=="S"){
	    		document.frmMain.valorLimite.disabled =false;
	    	}else{
	    		document.frmMain.valorLimite.value="";
	    		document.frmMain.valorLimite.disabled =true;
	    	}
	    }


    </script>

   	</s:FormStrategy>
  </p:Document>
</html>
