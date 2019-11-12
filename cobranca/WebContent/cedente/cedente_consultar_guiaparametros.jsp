<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteParametrosBean"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
CedenteParametrosBean parametrosBean = (request.getAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN) == null ? new CedenteParametrosBean() : (CedenteParametrosBean) request.getAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN));
	String carteira = "COBRANCA";
	String tipo = parametrosBean.getTipoCalculo();
	String tipoDesc="";
	if (tipo.equalsIgnoreCase("00")){
		tipoDesc="LEGADO";
	}else if (tipo.equalsIgnoreCase("01")){
		tipoDesc="CIP";
	}else if (tipo.equalsIgnoreCase("02")){
		tipoDesc="CEDENTE";	
	}
	String autorizacao = parametrosBean.getAutorizacao();
	String autDesc = "";
	if (autorizacao.equalsIgnoreCase("L")){
		autDesc="LEGADO";
	}else if (autorizacao.equalsIgnoreCase("N")){
		autDesc="N�O";
	}else if (autorizacao.equalsIgnoreCase("S")){
		autDesc="SIM";
	}
	String icgarantia = parametrosBean.getIcgarantia();
	if (icgarantia.equalsIgnoreCase("N")){
		icgarantia="N�O";
	}else{
		icgarantia="SIM";
	}
	
	String icboleto = parametrosBean.getIcboleto();
	if (icboleto.equalsIgnoreCase("N")){
		icboleto="N�O";
	}else{
		icboleto="SIM";
	}
	
	String icvalor = parametrosBean.getIcvalor();
	if (icvalor.equalsIgnoreCase("N")){
		icvalor="N�O";
	}else{
		icvalor="SIM";
	}
	String creditoOnline = "";
	String iCcreditoOnline = (String) parametrosBean.getCreditoOnline();
	if (iCcreditoOnline.equalsIgnoreCase("N")){
		creditoOnline = "N�O";
	}else{
		creditoOnline = "SIM";
	}
	
	
	String clienteExternoPar = (String) parametrosBean.getClienteExterno();
	if (clienteExternoPar.equalsIgnoreCase("S")){
		clienteExternoPar="SIM";
	}else{
		clienteExternoPar="N�O";
	}
	
	String icFinalizacao = (String) parametrosBean.getIcFinalizacao();
	if (icFinalizacao.equalsIgnoreCase("S")){
		icFinalizacao = "SIM";
	}else{
		icFinalizacao="N�O";
	}
	
	String codigoContabil = (String) parametrosBean.getCodigoContabil();
	
	String codigoContabilDeb = (String) parametrosBean.getCodigoContabilDeb();
	
	String unidadeCredito = (String) parametrosBean.getUnidadeCredito();
	if (unidadeCredito.equalsIgnoreCase("0")){
		unidadeCredito="";
	}else if (unidadeCredito.equalsIgnoreCase("1")){
		unidadeCredito="Ag�ncia de vincula��o";
	}else if (unidadeCredito.equalsIgnoreCase("2")){
		unidadeCredito="Ag�ncia da conta corrente";
	}else if(unidadeCredito.equalsIgnoreCase("3")){
		unidadeCredito="Ag�ncia em branco";
	}
	
	
	String icRateio = (String) parametrosBean.getIcRateio();
	if (icRateio.equalsIgnoreCase("S")){
		icRateio = "SIM";
	}else{
		icRateio = "N�O";
	}
	
	
	String icCedenteGarantia = (String) parametrosBean.getIcCedenteGarantia();
	if (icCedenteGarantia.equalsIgnoreCase("S")){
		icCedenteGarantia = "SIM";
	}else{
		icCedenteGarantia = "N�O";
	}
	
	String icContaGarantia = (String) parametrosBean.getIcContaGar();
	if (icContaGarantia.equalsIgnoreCase("S")){
		icContaGarantia = "SIM";
	}else{
		icContaGarantia = "N�O";
	}
	
	String operacao = String.valueOf(Util.zerosEsquerda(parametrosBean.getNuOperacao(),4));
	
	String nuContrato = (String) parametrosBean.getNuContrato();
	
	String icBaixaPermitida = (String) parametrosBean.getIcBaixa();
	if (icBaixaPermitida.equalsIgnoreCase("S")){
		icBaixaPermitida = "SIM";
	}else{
		icBaixaPermitida = "N�O";
	}
	
	String icMarcado = (String) parametrosBean.getIcMarcado();
	if (icMarcado.equalsIgnoreCase("S")){
		icMarcado = "SIM";
	}else{
		icMarcado = "N�O";
	}
	
	String icDesmarcado = (String) parametrosBean.getIcDesmarcado();
	if (icDesmarcado.equalsIgnoreCase("S")){
		icDesmarcado = "SIM";
	}else{
		icDesmarcado = "N�O";
	}
	
	String agCta=  String.valueOf (Util.zerosEsquerda(parametrosBean.getAgCta(),4));
	
	String opeCta=  String.valueOf(Util.zerosEsquerda(parametrosBean.getOpeCta(),4));
	
	String numCta = String.valueOf(Util.zerosEsquerda(parametrosBean.getNumCta(),12));
	
	String digCta =  String.valueOf( parametrosBean.getDigCta());
	
	String icEventoGarantia = (String) parametrosBean.getIcLancamento();
	if (icEventoGarantia.equalsIgnoreCase("S")){
		icEventoGarantia = "SIM";
	}else{
		icEventoGarantia = "N�O";
	}
	
	String icCreditarConta =  (String) parametrosBean.getIcContaGar();
	if (icCreditarConta.equalsIgnoreCase("S")){
		icCreditarConta = "SIM";
	}else{
		icCreditarConta = "N�O";
	}
	
	String icProposta =  (String) parametrosBean.getIcProposta();
	if (icProposta.equalsIgnoreCase("S")){
		icProposta = "SIM";
	}else{
		icProposta = "N�O";
	}
	
	
	String icCEP = (String) parametrosBean.getIcCEP();
	if (icCEP.equalsIgnoreCase("S")){
		icCEP = "SIM";
	}else{
		icCEP = "N�O";
	}
	
	String icDebitoTarifa = (String) parametrosBean.getIcDebitoTarifa();
	if (icDebitoTarifa.equalsIgnoreCase("S")){
		icDebitoTarifa = "SIM";
	}else{
		icDebitoTarifa = "N�O";
	}
	
	String icBeneficiario = (String) parametrosBean.getIcBeneficiario();
	
	String nuSITCS = Util.zerosEsquerda(parametrosBean.getNuSITCS(),6);
	
	
	String codEventoGar =  String.valueOf(Util.zerosEsquerda(parametrosBean.getNuEvento(),6));
	
	String autCCA = (String) parametrosBean.getAutCCA();
	
	if (autCCA.equalsIgnoreCase("S")){
		autCCA="SIM";
	}else {
		autCCA="N�O";
	}
	
	
	
	String icIndiceEspecial=(String) parametrosBean.getIcIndiceEspecial();
	
	String tpIndice=(String) parametrosBean.getTpIndice();
	
	String icAplIndiceEspecial=(String) parametrosBean.getIcAplIndiceEspecial();
	
	String valorlimite =parametrosBean.getValorLimite().toString().equals("R$ 0,00")?"":parametrosBean.getValorLimite().toString();
	
	
%>
<div class="group">
<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14
	valign="middle" align="center">
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>

	<tr>
		<td colspan="4" class="textoDestaqueTitulo">Guia: Par�metros</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
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
    							Atualizar T�tulo Vencido Boleto Expresso
    						 </td>
   							 <td class="textoValor"" width="13%" style='width:13.72%;padding:.75pt .75pt .75pt .75pt'>
			                     <%=icboleto %>
							</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>

						</tr>
						

   						<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
   							 <td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
    							Cedente Garantia de Cr�dito
    						 </td>
    						<td class="textoValor" width="13%" style='width:13.4%;padding:.75pt .75pt .75pt .75pt'>
    							 <%=icCedenteGarantia %>
    						</td>
    						
							<td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
    							Cedente Emissor de Boleto Proposta
    						 </td>
   							 <td class="textoValor"" width="12%" style='width:12.72%;padding:.75pt .75pt .75pt .75pt'>
			                     <%=icProposta %>
							</td>
   						</tr>
   						
   						<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
   							 <td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
    							Indicador de C�lculo de Encargo com �ndice Especial:
    						 </td>
    						<td class="textoValor" width="12%" style='width:12.4%;padding:.75pt .75pt .75pt .75pt'>
    							 
    							     <%=icIndiceEspecial.equals("S") ? "SIM" : "N�O"%>
    						</td>
    						
    						<td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
    							Cr�tica de CEP e UF do Sacado
    						 </td>
   							 <td class="textoValor" width="12%" style='width:12.72%;padding:.75pt .75pt .75pt .75pt'>
   							 	<%=icCEP %>
			            	 </td>
   						</tr>
   						
   						<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
   							 <td class="textoTitulo" width="35%" style='width:35.72%;padding:.75pt .75pt .75pt .75pt'>
    						Tipo de �ndice Especial :
    						 </td>
    						<td class="textoValor" width="13%" style='width:13.4%;padding:.75pt .75pt .75pt .75pt'>
    							 <%=tpIndice %>
    						</td>
   						</tr>
   						
   						<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
   							 <td class="textoTitulo" width="35%" style='width:43.72%;padding:.75pt .75pt .75pt .75pt'>
    							Indicador de Aplica��o do �ndice Especial :
    						 </td>
    						<td class="textoValor" colspan="3" width="43%" style='width:43.72%;padding:.75pt .75pt .75pt .75pt'>
    							 <%=icAplIndiceEspecial.equals("00") ? "" : ""%> 
								 <%=icAplIndiceEspecial.equals("01") ? "Antes de Multa/Juros/Encargos" : ""%>
								 <%=icAplIndiceEspecial.equals("02") ? "Depois de Multa/Juros/Encargos" : ""%> 
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
  					  &#9658;Par�metros Cedente Garantia de Cr�dito </b>
  					  <table class="textoTitulo" border="0"  cellpadding=0 width=688   style='width:515.8pt;mso-cellspacing:1.5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
   						<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
    						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt'>
    							Opera��o
    						</td>
    						<td class="textoValor" width="8%" style='width:8.28%;padding:.75pt .75pt .75pt .75pt'>
    								<%= operacao %>
    						</td>
    						<td class="textoTitulo" width="8%" style='width:8.92%;padding:0cm 5.4pt 0cm 5.4pt'>
    							N� Contrato
    						</td>
    						<td class="textoValor" width="35%" colspan=4 style='width:35.86%;padding:0cm 5.4pt 0cm 5.4pt'>
    								<%= nuContrato %>
    						</td>
   						</tr>
   						<tr style='mso-yfti-irow:1'>
    						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt'>
    							T�tulos garantia de cr�dito - baixa  permitida somente na Ag�ncia (rejeitar solicita��es de baixa via Remessa) 
						    </td>
    						<td class="textoValor" width="53%" colspan=6 style='width:53.66%;padding:.75pt .75pt .75pt .75pt'>
    							<%=icBaixaPermitida %>
							</td>
   						</tr>
   						
   						<tr style='mso-yfti-irow:1'>
    						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt'>
    							Os t�tulos j� existentes na base de dados do Cedente tamb�m devem ser marcados como Garantia de Cr�dito?
						    </td>
    						<td class="textoValor"  width="53%" colspan=6 style='width:53.66%;padding:.75pt .75pt .75pt .75pt'>
    							<%=icMarcado %>
							</td>
   						</tr>
   						
   						<tr style='mso-yfti-irow:1'>
    						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt'>
    							Os t�tulos j� existentes na base de dados do Cedente devem ser desmarcados, ou seja, retirar Garantia de Cr�dito?
						    </td>
    						<td class="textoValor" width="53%" colspan=6 style='width:53.66%;padding:.75pt .75pt .75pt .75pt'>
    							<%=icDesmarcado %>
							</td>
   						</tr>
   						
   						
   						<tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes;height:14.0pt'> 
	   						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt; height:14.0pt'>
	    						Creditar liquida��es de t�tulos marcados como garantia de cr�dito em conta diferente da principal
	    					</td>
	    					<td class="textoValor" width="8%" style='width:8.28%;padding:.75pt .75pt .75pt .75pt;  height:14.0pt'>
	    						<%=icCreditarConta %>
	    					</td>
	    					<td class="textoTitulo" width="17%" colspan=2 valign=top style='width:17.6%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    						Conta Garantia de Cr�dito
	    					</td>
	    					<td class="textoValor" width="7%" valign=top style='width:7.62%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    							<%= agCta %>
	    					</td>
	    					<td class="textoValor" width="7%" valign=top style='width:7.62%;padding:0cm 5.4pt 0cm 5.4pt;height:14.0pt'>
	    							<%= opeCta %>
	    					</td>
	    					<td class="textoValor" width="11%" valign=top style='width:11.38%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    							<%= numCta %>
	    					</td>
	    					<td class="textoValor" width="11%" valign=top style='width:11.38%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    							<%= digCta %>
	    					</td>
   						</tr>
   						
   						
   						<tr style='mso-yfti-irow:1'>
   						
	   						<td class="textoTitulo" width="45%" style='width:45.48%;padding:.75pt .75pt .75pt .75pt; height:14.0pt'>
	    						Creditar liquida��es de t�tulos marcados como garantia de cr�dito em evento cont�bil
	    					</td>
	    					<td class="textoValor" width="8%" style='width:8.28%;padding:.75pt .75pt .75pt .75pt;  height:14.0pt'>
	    						<%=icEventoGarantia %>
								
	    					</td>
	    					<td class="textoTitulo" width="17%" colspan=2 valign=top style='width:17.6%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    						C�digo do evento cont�bil para garantia de cr�dito
	    					</td>
	    					<td class="textoValor" width="7%" colspan="3" valign=top style='width:7.62%;padding:0cm 5.4pt 0cm 5.4pt; height:14.0pt'>
	    							<%= codEventoGar %>
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
                      
                      &nbsp;&#9658;Par�metros DDA (exclusivo Gestor) 
  					  	<table  cellpadding=0 width=688 style='width:515.8pt;mso-cellspacing:1.5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
	   						<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
	    						<td  class="textoTitulo" width=169 style='width:126.55pt;padding:.75pt .75pt .75pt .75pt'>
	    						Arquivo DDA/CIP - Produto
	    						</td>
	    						<td  class="textoValor" width=130 style='width:97.5pt;padding:.75pt .75pt .75pt .75pt'>
                      						COBRANCA
	    						</td>

	   						</tr>
	   						<tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
	    						<td  class="textoTitulo" width=169 style='width:126.55pt;padding:.75pt .75pt .75pt .75pt'>
	    							DDA Vencido - Autoriza��o de altera��o do valor a cobrar
	    						</td>
	    						<td  class="textoValor" width=130 style='width:97.5pt;padding:.75pt .75pt .75pt .75pt'>
	    								  <%=autDesc %>
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
                      
  					         &nbsp;&#9658;Outros Par�metros (exclusivo Gestor)
					  	<table class="textoTitulo"  cellpadding=0 width="100%"  style='width:100.0%;mso-cellspacing:1.5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
					  
					  <tr>
                      <td class="textoTitulo" width="17%">Arquivo controle de garantias:</td>
                      <td class="textoValor" width="26%">
                      		<%=icgarantia %>
                      </td>
                      <td class="textoTitulo" width="17%">Libera��o de Valor M�ximo de T�tulo:</td>
                      <td class="textoValor" width="26%">
                      	<%=icvalor %>&nbsp;-&nbsp;<%=valorlimite %>
					  
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Cr�dito On Line:</td>
                      <td class="textoValor" width="26%">
                     		<%=creditoOnline %>
                      </td>
                      <td class="textoTitulo" width="17%">Cliente Externo</td>
					  <td class="textoValor">
							<%=clienteExternoPar %> 
					  </td> 
                      
					</tr>

					<tr>
						<td class="textoTitulo" width="17%">Finaliza��o Diferenciada</td>
						<td class="textoValor">
							<%= icFinalizacao %>
						</td>
						<td class="textoTitulo" width="17%">Evento Cont�bil Cr�dito</td>
						<td class="textoValor">
							<%= codigoContabil %>
						</td>
						   	   
					</tr>
					
					<tr>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor">&nbsp;</td>
						<td class="textoTitulo" width="17%">Evento Cont�bil D�bito</td>
						<td class="textoValor"><%= codigoContabilDeb %></td>
					</tr>
					
					<tr>
						<td class="textoTitulo" width="17%">Unidade Destino Cr�dito:</td>
						<td class="textoValor">
							<%=unidadeCredito %>
						</td>
						<td class="textoTitulo" width="17%">Rateio de T�tulo:</td>
						<td class="textoValor">
							 <%=icRateio %> 
						</td>
					</tr>
					<tr>

					
						<td class="textoTitulo" width="17%">Comando de D�bito de Tarifa:</td>
						<td class="textoValor">
							   <%= icDebitoTarifa %>
							   		
						</td>
					</tr>
					
					<tr>
						<td class="textoTitulo" width="17%">Tipo de Benefici�rio:</td>
						<td class="textoValor">
							
					  					 <%=icBeneficiario.equals("00") ? "PADR�O" : ""%>
										 <%=icBeneficiario.equals("01") ? "SITCS" : ""%> 
										 <%=icBeneficiario.equals("02") ? "CART�O CR�DITO" : ""%> 
										 <%=icBeneficiario.equals("03") ? "CR�DITO IMOBILI�RIO" : ""%>
										 <%=icBeneficiario.equals("04") ? "UL/CCA" : ""%>
							
							   		
						</td>
						<td class="textoTitulo" width="17%">C�digo da Entidade Sindical:</td>
						<td class="textoValor">
							<%= nuSITCS %>
						</td>
					</tr>	
					
					<tr>
						<td class="textoTitulo" width="17%">Autoriza��o Pagamento Boleto no Canal CCA para Benefici�rio UL/CCA:</td>
						<td class="textoValor">	 <%=autCCA%>	</td>
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
		<td colspan="4">&nbsp;</td>
	</tr>

</table>
</div>
