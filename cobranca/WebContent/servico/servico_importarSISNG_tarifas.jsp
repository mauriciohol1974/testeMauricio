<script language="javascript">
	history.go(+1);
</script>
<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteTarifasBean"%>
<%@page import="br.gov.caixa.sigcb.bean.SimulacaoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CanalSimulacaoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.TarifaSimulaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CnpjBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.com.politec.sao.util.Percentual"%>
<%@page import="br.com.politec.sao.util.Money"%>
<%@page import="br.com.politec.sao.business.types.PercentualType"%>
<%@page import="br.com.politec.sao.business.types.MoneyType"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	String descCriticas = "";
	if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
		descCriticas = (String) request.getAttribute(CedenteEstrategia.DESC_CRITICAS);
	} 
%>

<%
	CedenteTarifasBean tarifasBean = (request.getAttribute(CedenteEstrategia.CEDENTE_TARIFAS_INFORME_BEAN)==null
	                                 ? new CedenteTarifasBean()
	                                 : (CedenteTarifasBean) request.getAttribute(CedenteEstrategia.CEDENTE_TARIFAS_INFORME_BEAN));
	String situacaoGuia = "";
	if (tarifasBean.getSituacaoGuia() != null) {
		situacaoGuia = tarifasBean.getSituacaoGuia();
	} else if (request.getParameter("situacaoGuia") != null) {
		situacaoGuia = request.getParameter("situacaoGuia");
	}
	String codigoClienteCOCLI = "";
	if (tarifasBean.getCodigoClienteCOCLI() != null) {
		codigoClienteCOCLI = ""+tarifasBean.getCodigoClienteCOCLI();
	} else if (request.getParameter("codigoClienteCOCLI") != null) {
		codigoClienteCOCLI = request.getParameter("codigoClienteCOCLI");
	}
	String codigoUnidadePVVinc = "";
	if (tarifasBean.getCodigoUnidadePVVinc() != null) {
		codigoUnidadePVVinc = ""+tarifasBean.getCodigoUnidadePVVinc();
	} else if (request.getParameter("codigoUnidadePVVinc") != null) {
		codigoUnidadePVVinc = request.getParameter("codigoUnidadePVVinc");
	}
	String tipoAcao = "";
	if (tarifasBean.getTipoAcao() != null) {
		tipoAcao = tarifasBean.getTipoAcao();
	} else if (request.getParameter("tipoAcao") != null) {
		tipoAcao = request.getParameter("tipoAcao");
	}
	


	SimulacaoBean simulacaoBean = (SimulacaoBean) request.getAttribute("SimulacaoBean");
	SimulacaoBean SimulacaoRetBean = (SimulacaoBean) request.getAttribute("SimulacaoRetBean");

	ArrayList ListaFloat = (ArrayList) request.getAttribute("ListaFloat");
	ArrayList ListaServico = (ArrayList) request.getAttribute("ListaServico");
	ArrayList ListaCNPJ = (ArrayList) request.getAttribute("ListaCNPJ");
%>

<html>
<s:HeaderPopup/>
<p:Document>

	<!-- ************************ PAGINA INFORME TARIFAS *************************** -->

	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="cedente.CedenteIncluirTarifasIniciar" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Serviço >> Apropiar Simulação"/>


		<input type="hidden" name="situacaoGuia" value="<%=situacaoGuia%>">
		<input type="hidden" name="codigoClienteCOCLI" value="<%=codigoClienteCOCLI%>">
		<input type="hidden" name="codigoUnidadePVVinc" value="<%=codigoUnidadePVVinc%>">
		<input type="hidden" name="tipoAcao" value="<%=tipoAcao%>">
		<input type="hidden" name="nuSimulacao" value="<%=simulacaoBean.getNu_simulacao().toString()%>">
		
		<input type="hidden" name="cpfCnpj" value="">
		<input type="hidden" name="icPessoa" value="">
		<input type="hidden" name="nomeCedente" value="">

		<input type="hidden" name="tempValorOriginal">
		<input type="hidden" name="tempValorCalculado">
		<input type="hidden" name="tempPercentualOriginal">
		<input type="hidden" name="tempPercentualCalculado">

    <table width="670" border="0" cellspacing="0" cellpadding="0" align="left">
    
      <tr> 
		<td valign="top" width="5%" height="14" align="left">&nbsp;</td>
        <td valign="top" width="95%" height="14" align="center"> 
        <div class="group">
          
          <table width="650" border="0" cellspacing="0" cellpadding="0" height="53" >
          	<tr>
          		<td colspan="2">
          				<table width="640" border="0" cellspacing="3" cellpadding="0" height="53" >
								<tr>
									<td class="textoTitulo" width="17%">Simulação:</td>
									<td class="textoValor" width="26%"><%=simulacaoBean.getNu_simulacao() %></td>
									<td class="textoTitulo" width="17%"></td>
									<td class="textoValor" width="26%"></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="17%">Data de validade:</td>
									<td class="textoValor" width="26%"><%=simulacaoBean.getDataValidade() %></td>
									<td class="textoTitulo" width="17%">NSU Simulador:</td>
									<td class="textoValor" width="26%"><%=simulacaoBean.getNSU() %></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" colspan="4" width="100%" align="center"><b>&nbsp;</b></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" colspan="4" width="100%" align="center"><b>CLIENTES VINCULADOS</b></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" colspan="4" width="100%" align="center"><b>&nbsp;</b></td>
								</tr>
								<tr>
									<td class="textoTitulo" width="50%" colspan="2" align="right"><b>CPF/CNPJ</b></td>
									<td class="textoTitulo" width="50%" colspan="2" align="left"><b>Nome/Razão Social</b></td>
								</tr>
								<%for (int i=0;i<ListaCNPJ.size();i++){ 
									CnpjBean cnpjBean = (CnpjBean) ListaCNPJ.get(i);
								%>
								<tr>
									<td class="textoValor" width="50%" colspan="2" align="right"><a href="javascript: selCnpj('<%=cnpjBean.getCpfCnpj().toString() %>','<%=cnpjBean.getIcPessoa()%>','<%=cnpjBean.getNome() %>')"><b><%=cnpjBean.getCpfCnpj().toString() %></b></a></td>
									<td class="textoValor" width="50%" colspan="2" align="left"><b><%=cnpjBean.getNome() %></b></td>
								</tr>
								<%} %>
								
								<tr>
									<td class="textoTitulo" width="17%">&nbsp;</td>
									<td class="textoValor" width="26%"></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Matricula Autorizador:</td>
									<td class="textoValor" colspan="3"><%=simulacaoBean.getUsuarioAutorizador() %>&nbsp;-&nbsp;<%=SimulacaoRetBean.getNomeUsuario() %></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" width="17%">Unidade vinculada Autorizador:</td>
									<td class="textoValor" colspan="3"><%=simulacaoBean.getUnidadeAutorizador() %>&nbsp;-&nbsp;<%=SimulacaoRetBean.getNomeUnidade() %></td>
									
								</tr>	
						</table>
						
						<table class="box" width="640" cellspacing="3" cellpadding="0" height="53">
          							   <tr class="headerLista">
											<td class="textoTitulo" width="40%">TARIFA SERVIÇO</td>
											<td class="textoTitulo" width="20%">VALOR PADRÃO</td>
											
											<td class="textoTitulo" width="20%">VALOR NEGOCIADO</td>
										</tr>
											<%
											
											for (int i=0;i<ListaServico.size();i++){ 
												 TarifaSimulaBean tarifa = new TarifaSimulaBean();
												 tarifa = (TarifaSimulaBean) ListaServico.get(i);
												
											%>
											
											<tr class="headerLista">
												<td class="textoValor" width="50%" align="left"><%= tarifa.getDeServico() %></td>
												<td class="textoValor" width="20%"><%= tarifa.getValorPad() %></td>
												
												<td class="textoValor" width="20%"><%= tarifa.getValorNeg() %></td>
												
											</tr>
											<%} %>
          						   
          						   
          						   <tr>
          						   	<td>&nbsp;</td>
          						   </tr>
          					</table>
          					<table class="box" width="640" cellspacing="3" cellpadding="0" height="53">
          						 
          						 			<tr class="headerLista"> 
	          						   	
											<td class="textoTitulo" width="50%">FLOAT</td>
											<td class="textoTitulo" width="20%">VALOR PADRÃO</td>
											<td class="textoTitulo" width="20%">VALOR NEGOCIADO</td>
											</tr>
											<%
											
											for (int i=0;i<ListaFloat.size();i++){ 
												
												
												CanalSimulacaoBean canalBean = (CanalSimulacaoBean) ListaFloat.get(i);
												 
											%>
											
											<tr class="headerLista">
												<td class="textoValor" width="50%" align="left"><%= canalBean.getDeCanal() %></td>
												<td class="textoValor" width="25%"><%= canalBean.getPrazoPad() %></td>
												<td class="textoValor" width="25%"><%= canalBean.getPrazoNeg() %></td>
												
											</tr>
											<%} %>
          						   
          					</table>
          					
          					<table class="box" width="640" cellspacing="3" cellpadding="0" height="53">
          						 
          						 		<tr class="headerLista"> 
	          						   	
											<td class="textoTitulo" colspan="2" width="100%">TIPO DE TRANSMISSÃO</td>
											
										</tr>
										
										<tr class="headerLista"> 
	          						   	
											<td class="textoTitulo" width="50%">Atual do SIGCB</td>
											
											<td class="textoTitulo" width="50%">Negociado(Simulador)<td>
											
										</tr>
										
										<tr class="headerLista"> 
	          						   		
											<td class="textoValor" width="50%"><%=SimulacaoRetBean.getDeTransmissao() %></td>
											
											<td class="textoValor" width="50%"><%=SimulacaoRetBean.getDeTransmissaoNeg()%><td>
										</tr>
										
										<tr class="headerLista"> 
	          						   	
											<td class="textoTitulo" width="50%">&nbsp;</td>
											
											<td class="textoValor" width="50%"><td>
											
										</tr>
										
										<tr class="headerLista"> 
	          						   	
											<td class="textoTitulo" colspan="2" align="left">Mensagem Alerta:</td>
											
											
										</tr>
										
																				
										<tr class="headerLista"> 
	          						   	
											<td class="textoValor" colspan="2" align="left"><%=SimulacaoRetBean.getDeOcorrencia() %></td>
											
											
											
										</tr>
											
          						  
          						   
          					</table>
			        </td>
			      </tr>            
            
            <tr> 
              <td colspan="2">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="2">
                <p align="center"> 
                
                 
                </p>
              </td>
            </tr>

          </table>
        </TD>
      </div>
      </tr>
    </table>

    
    <script language="javascript">
    	function inicia() {
<%
	if (!descCriticas.equals("")) {
%>
				alert("<%= descCriticas %>");
<%
	// se nao houver criticas e existe as criticas vazias no request (nao eh null)
	// quer dizer que finalizou com sucesso e a janela pode ser fechada
	} else if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
%>
				window.close();
<%
	}
%>
    	}
    
	    function formSubmit() {
	    	document.frmMain.estrategia.value="servico.SimuladorNegocialSelecionarIniciar";
	    	document.frmMain.submit();
	    	
	      
	    }
	    
	    function formSubmit_Cancelar() {
    		var confirma = confirm(conf('115'));
    		if (confirma) {
					window.close();
				}
	    	
	    }
	    
	    function selCnpj(cnpj,icPessoa,nomeCedente){
	    	
	    	var valorAltura = 550;
			var valorLargura = 700;
			var valorTopo = (screen.height - valorAltura) /2;
			var valorEsquerda = (screen.width - valorLargura) /2;
			
			document.frmMain.cpfCnpj.value=cnpj;
			document.frmMain.icPessoa.value=icPessoa;
			document.frmMain.nomeCedente.value=nomeCedente;
    
			janelaTarifa = window.open("<%=Paths.getRootForDynamicContent()%>/jump/servico_importar_tarifas_jump.jsp", "servico_importar_tarifas<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "height="+valorAltura+",width="+valorLargura+",top="+valorTopo+",left="+valorEsquerda+",toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=0");
			janelaTarifa.focus();
	    	
	    
	    }
	    
	  
	    
	   
		</script>
    
   	</s:FormStrategy>
   	
	<!-- ************************ FIM PAGINA INFORME TARIFAS ************************ -->
	   	
  </p:Document>
</html>
