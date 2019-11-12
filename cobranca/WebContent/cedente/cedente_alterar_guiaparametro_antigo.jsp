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
	String tipoCobranca = principalBean.getTipoCobranca() == null ? ""+CedenteEstrategia.COBRANCA_CONVENCIONAL : ""+principalBean.getTipoCobranca();
	String cedenteCentralizador = principalBean.getCedenteCentralizador() == null ? "0" : ""+principalBean.getCedenteCentralizador();
	
	String codigoCedente = "";
	if (filtroBean.getCodigoCedente() != null) {
		codigoCedente = "" + filtroBean.getCodigoCedente();
	}
%>

<%
	
	InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean)session.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);
	CedenteParametrosBean parametroBean = (CedenteParametrosBean)session.getAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN);
	CedenteParametrosBean parametrosBean = (request.getAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN) == null ? new CedenteParametrosBean() : (CedenteParametrosBean) request.getAttribute(CedenteEstrategia.CEDENTE_PARAMETROS_BEAN));
	String carteira = "COBRANCA";
	String tipo = (String) parametrosBean.getTipoCalculo();

	String autorizacao = (String) parametrosBean.getAutorizacao();
	
	String icgarantia = (String) parametrosBean.getIcgarantia();
	
	String icboleto = (String) parametrosBean.getIcboleto();
	
	String icvalor = (String) parametrosBean.getIcvalor();
	
	String creditoOnline = (String) parametrosBean.getCreditoOnline();
	
	String clienteExterno = (String) parametrosBean.getClienteExterno();
	
	String icFinalizacao = (String) parametrosBean.getIcFinalizacao();
	
	String codigoContabil = (String) parametrosBean.getCodigoContabil();
	
	String unidadeCredito = (String) parametrosBean.getUnidadeCredito();
	
	String icRateio = (String) parametrosBean.getIcRateio();

%>
	<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteAlterarGuiaControle" fluxo="normal">
   		<s:Menu/>
   		<s:Titulo name="Manter Cedente >> Alterar"/>

			<input type="hidden" name="guiaAberta" value="<%= guiaAberta %>">
			<input type="hidden" name="tipoCobranca" value="<%= tipoCobranca %>">
			<input type="hidden" name="cedenteCentralizador" value="<%= cedenteCentralizador %>">						

			<input type="hidden" name="nsuTransacao" value="<%= nsuTransacao %>">
			<input type="hidden" name="codigoCedente" value="<%= codigoCedente %>">
			
			<input type="hidden" name="tipoCalculo" value="<%= tipo %>">
			<input type="hidden" name="autorizacao" value="<%= autorizacao %>">
			<input type="hidden" name="icgarantia" value="<%= icgarantia %>">
			<input type="hidden" name="icboleto" value="<%= icboleto %>">
			<input type="hidden" name="icvalor" value="<%= icvalor %>">
			<input type="hidden" name="creditoOnline" value="<%= creditoOnline %>">
			<input type="hidden" name="clienteExterno" value="<%= clienteExterno %>">
			<input type="hidden" name="icFinalizacao" value="<%= icFinalizacao %>">
			<input type="hidden" name="unidadeCredito" value="<%= unidadeCredito %>">
			<input type="hidden" name="tipoUsuario" value="<%= usuarioLDAPBean.getNomeGrupo() %>">
			<input type="hidden" name="cc" value="<%= codigoContabil %>">
			<input type="hidden" name="icRateio" value="<%= icRateio %>">
			
			<input type="hidden" name="carteira" value="">
			

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
                &nbsp;
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
                &nbsp;
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
                &nbsp;
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
                &nbsp;
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
                &nbsp;
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
                &nbsp;
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
				<td colspan="3" class="textoValor">&nbsp;</td>
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
                &nbsp;
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
                      <td class="textoTitulo" width="17%">Produto:</td>
                      <td class="textoValor" width="26%">
                      	<select size="1" name="cmbCarteira">
                      		<option selected  value="COBRANCA">COBRANCA</option>
                      	</select>
                      </td>
                      <td class="textoTitulo" width="17%">Tipo Modelo Calculo:</td>
                      <td class="textoValor" width="26%">
                      <%
                      if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
					  %>
                        <select size="1" name="cmbModelo">
                        	<% if (tipo.equalsIgnoreCase("01")) {%>
							<option selected value="01">CIP</option>
							<option value="02">CEDENTE</option>
							<%} else { %>
							<option  value="01">CIP</option>
							<option selected value="02">CEDENTE</option>
							<%} %>
						</select>
					<%}else{%>
                        <select size="1" name="cmbModelo" disabled="disabled">
                        	<% if (tipo.equalsIgnoreCase("01")) {%>
							<option selected value="01">CIP</option>
							<option value="02">CEDENTE</option>
							<%} else { %>
							<option  value="01">CIP</option>
							<option selected value="02">CEDENTE</option>
							<%} %>
						</select>
					<%} %>
        				        
                      </td>
                    </tr>


					<tr>
                      <td class="textoTitulo" width="17%">Autorização de alteração do valor a cobrar:</td>
                      <td class="textoValor" width="26%">
                      <%
                      if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
					  %>
                       <select size="1" name="cmbAutorizacao">
                       <%if (autorizacao.equalsIgnoreCase("N")) { %>
							<option selected value="N">NÃO</option>
							<option value="S">SIM</option>
						<%} else { %>
							<option  value="N">NÃO</option>
							<option selected value="S">SIM</option>
						<%} %>
						</select>
					  <%}else{ %>
                       <select size="1" name="cmbAutorizacao" disabled="disabled">
                       <%if (autorizacao.equalsIgnoreCase("N")) { %>
							<option selected value="N">NÃO</option>
							<option value="S">SIM</option>
						<%} else { %>
							<option  value="N">NÃO</option>
							<option selected value="S">SIM</option>
						<%} %>
						</select>
					  <%} %>
					  
                      </td>
                      <td class="textoTitulo" width="17%">Atualizar Título Vencido Bloqueto Expresso:</td>
                      <td class="textoValor" width="26%">
                      <%
                      if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM") || usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBOPE")){
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
                       <select size="1" name="cmbBloqExpresso" disabled="disabled">
                       <%if (icboleto.equalsIgnoreCase("N")) { %>
							<option selected value="N">NÃO</option>
							<option value="S">SIM</option>
						<%} else { %>
							<option  value="N">NÃO</option>
							<option selected value="S">SIM</option>
						<%} %>
						</select>
					  <%} %>
					  
                      </td>
                    </tr>
                    
                    <tr>
                      <td class="textoTitulo" width="17%">Arquivo controle de garantias:</td>
                      <td class="textoValor" width="26%">
                      <%
                      if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
					  %>
                       <select size="1" name="cmbIcgarantia">
                       <%if (icgarantia.equalsIgnoreCase("N")) { %>
							<option selected value="N">NÃO</option>
							<option value="S">SIM</option>
						<%} else { %>
							<option  value="N">NÃO</option>
							<option selected value="S">SIM</option>
						<%} %>
						</select>
					  <%}else{ %>
                       <select size="1" name="cmbIcgarantia" disabled="disabled">
                       <%if (icgarantia.equalsIgnoreCase("N")) { %>
							<option selected value="N">NÃO</option>
							<option value="S">SIM</option>
						<%} else { %>
							<option  value="N">NÃO</option>
							<option selected value="S">SIM</option>
						<%} %>
						</select>
					  <%} %>
					  
                      </td>
					  <td class="textoTitulo" width="17%">Liberação de Valor Máximo de Título:</td>
                      <td class="textoValor" width="26%">
                      <%
                      if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
					  %>
                       <select size="1" name="cmbValorBoleto">
                       <%if (icvalor.equalsIgnoreCase("N")) { %>
							<option selected value="N">NÃO</option>
							<option value="S">SIM</option>
						<%} else { %>
							<option  value="N">NÃO</option>
							<option selected value="S">SIM</option>
						<%} %>
						</select>
					  <%}else{ %>
                       <select size="1" name="cmbValorBoleto" disabled="disabled">
                       <%if (icvalor.equalsIgnoreCase("N")) { %>
							<option selected value="N">NÃO</option>
							<option value="S">SIM</option>
						<%} else { %>
							<option  value="N">NÃO</option>
							<option selected value="S">SIM</option>
						<%} %>
						</select>
					  <%} %>
					  
                      </td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Crédito On Line:</td>
                      <td class="textoValor" width="26%">
                      <%
                      if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
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
                       <select size="1" name="cmbCreditoOnLine" disabled="disabled">
                       <%if (creditoOnline.equalsIgnoreCase("N")) { %>
							<option selected value="N">NÃO</option>
							<option value="S">SIM</option>
						<%} else { %>
							<option  value="N">NÃO</option>
							<option selected value="S">SIM</option>
						<%} %>
						</select>
					  <%} %>
					  
                      </td>
                      
                      <td class="textoTitulo" width="17%">Cliente Externo</td>
					  <td>
							 <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
					  		 %>
					  		  <select size="1" name="cmbClienteExterno" onchange="liberaUnidade()">
					  		   <%if (clienteExterno.equalsIgnoreCase("N")) { %>
					  					<option selected value="N">NÃO</option>
										<option value="S">SIM</option>
							   <%} else { %>
							   			<option value="N">NÃO</option>
										<option selected value="S">SIM</option>
							   <%} %>
							   </select>
							 <%} else { %>
					  		  <select size="1" name="cmbClienteExterno" disabled="disabled">
					  		   <%if (clienteExterno.equalsIgnoreCase("N")) { %>
					  					<option selected value="N">NÃO</option>
										<option value="S">SIM</option>
							   <%} else { %>
							   			<option value="N">NÃO</option>
										<option selected value="S">SIM</option>
							   <%} %>
							   </select>
							 <%} %>
					  </td>  
					</tr>


					<tr>
						<td class="textoTitulo" width="17%">Finalização Diferenciada</td>
						<td>
							 <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
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
					  		  <select size="1" name="cmbIcFinalizacao" disabled="disabled">
					  		   <%if (icFinalizacao.equalsIgnoreCase("N")) { %>
					  					<option selected value="N">NÃO</option>
										<option value="S">SIM</option>
							   <%} else { %>
							   			<option value="N">NÃO</option>
										<option selected value="S">SIM</option>
							   <%} %>
							   </select>
							 <%} %>
						</td>
						<td class="textoTitulo" width="17%">Código do Evento Contábil</td>
						<td>
							 <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
					  		 %>
					  		   <p:InputNumerico CLASS="inputtext" name="codigoContabil" value="<%= codigoContabil %>" size="8" maxlength="6" disabled="true"/>
							 	
							 <%} else { %>

								<p:InputNumerico CLASS="inputtext" name="codigoContabil" value="<%= codigoContabil %>" size="8" maxlength="6" disabled="true"/>
							 
							 <%} %>
						</td>
						   	   
					</tr>
					
					<tr>
						<td class="textoTitulo" width="17%">Unidade Destino Crédito:</td>
						<td class="textoTitulo">
							   <%
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM")){
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
                      			if (usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBADM") || usuarioLDAPBean.getNomeGrupo().equalsIgnoreCase("GCBRET")){
					  		   %>
					  		  		<select size="1" name="cmbRateio" >
					  					<option <%=icRateio.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
										<option <%=icRateio.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
							   <%} else { %>
									<select size="1" name="cmbRateio" disabled="true">
										<option <%=icRateio.equals("S") ? "selected='selected'" : ""%> value="S">SIM</option>
										<option <%=icRateio.equals("N") ? "selected='selected'" : ""%> value="N">NÃO</option>
							   <%} %>
							   </select>
							   		
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
            </tr>
			<tr>
				<td class="textoTitulo"><a href="#ParametrosParent"
					onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CONCLUSAO%>);"><img
					src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
					height="11" name="outlineplus" id="Mensagemi"></a> <a
					name="MensagemParent">Conclusão</a></td>
				<td colspan="3" class="textoValor">&nbsp;</td>
			</tr>	

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
	    	
	    	liberaUnidade();

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
	    	if (!confirm(conf("128"))) {
	    		return;
	    	}

	    	if (guia == <%= guiaAberta %>) {
	    		fecharGuias();
	    		return;
	    	}

	    	//if (guia == <%= CedenteEstrategia.GUIA_CEDENTE_ELETRONICO %>
	    	//			&& document.frmMain.tipoCobranca.value == <%= ""+CedenteEstrategia.COBRANCA_CONVENCIONAL %>) {
	    	//		return;
	    	//}
	    
				// fecha janela de tarifa se estiver aberta
				if (janelaParametro != null && !janelaParametro.closed) {
					if (confirm(conf('142'))) {
						fecharjanelaParametro();
					} else {
						return;
					}
	    	}

	    	document.frmMain.guiaAberta.value = guia;
	    	document.frmMain.submit();
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
	    	var tipoUnidade = document.frmMain.tipoUsuario.value;
	    	if (tipoUnidade=="GCBADM"){
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
		    		
			    	document.frmMain.estrategia.value="cedente.CedenteAlterarGuiaParametroFinalizar";
			    	document.frmMain.tipoCalculo.value=document.frmMain.cmbModelo.value;
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
			    	document.frmMain.icRateio.value=document.frmMain.cmbRateio.value;
			    	document.frmMain.submit();
			    }
		   	}
	    }

	    function formSubmit_GrupoTarifas() {
				var valorAltura = 350;
				var valorLargura = 640;
				var valorTopo = (screen.height - valorAltura) /2;
				var valorEsquerda = (screen.width - valorLargura) /2;
	    
				janelaParametro = window.open("<%=Paths.getRootForDynamicContent()%>/jump/cedente_alterar_tarifas_jump.jsp", "cedente_alterar_tarifas<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "height="+valorAltura+",width="+valorLargura+",top="+valorTopo+",left="+valorEsquerda+",toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=0");
				janelaParametro.focus();
	    }
	    
	    function fecharjanelaParametro() {
	    	if (janelaParametro != null && !janelaParametro.closed) {
			   	janelaParametro.close();
			  }
	    }
	    
	    function validaSubmit_Parametro() {

	    	return true;
	    }
	    
    </script>

   	</s:FormStrategy>
  </p:Document>
</html>
