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


SimulacaoBean simulacaoBean = (SimulacaoBean) request.getAttribute("SimulacaoBean");
String cpfCnpj = (String) request.getAttribute("cpfCnpj");
String icPessoa = (String) request.getAttribute("icPessoa");
String nomeCedente = (String) request.getAttribute("nomeCedente");
ArrayList ListaCNPJ = (ArrayList) request.getAttribute("ListaCNPJ");

%>
<html>
<s:HeaderPopup/>
<p:Document>

	<!-- ************************ PAGINA INFORME TARIFAS *************************** -->

	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="cedente.CedenteIncluirTarifasIniciar" fluxo="normal">

		<s:Titulo name="Serviço >> Apropiar Simulação >> Beneficiário"/>


	
		<input type="hidden" name="nuSimulacao" value="<%=simulacaoBean.getNu_simulacao().toString()%>">
		
		<input type="hidden" name="cpfCnpj" value="">
		<input type="hidden" name="icPessoa" value="">
		<input type="hidden" name="codCedente" value="">

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
									<td class="textoTitulo" colspan="4" width="100%" align="left"><b>SIMULADOR - BENEFICIÁRIOS RELACIONADOS AO CLIENTE</b></td>
								</tr>
								
								<tr>
									<td class="textoTitulo" colspan="4" width="100%" align="center"><b>&nbsp;</b></td>
								</tr>
							
								<tr>
									<td class="textoTitulo" width="15%">Beneficiário</td>
									<td class="textoTitulo" width="25%">CPF/CNPJ</td>
									<td class="textoTitulo" width="40%">Nome/Razão Social</td>
									<td class="textoTitulo" width="20%">Ocorrência</td>
								</tr>
								
								<%for (int i=0;i<ListaCNPJ.size();i++){ 
									CnpjBean cnpjBean = (CnpjBean) ListaCNPJ.get(i);
								%>
								<tr>
									<td class="textoValor" width="15%"><a href="javascript:selCedente('<%=icPessoa %>','<%=cpfCnpj %>','<%=cnpjBean.getCodCedente().toString() %>');"><%=cnpjBean.getCodCedente().toString() %></a></td>
									<td class="textoValor" width="25%"><%=cpfCnpj %></td>
									<td class="textoValor" width="40%"><%=nomeCedente %></td>
									<td class="textoValor" width="20%"><%=cnpjBean.getDeOcorrencia() %></td>
								</tr>
								<%} %>
								
								<tr>
									<td class="textoTitulo" width="17%">&nbsp;</td>
									<td class="textoValor" width="26%"></td>
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
                 
                  <s:Button name="Cancelar" action="javascript:formSubmit_Cancelar();" />
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

    	}
    
    	   function formSubmit() {
   	    	document.frmMain.estrategia.value="servico.";
   	    	document.frmMain.submit();
   	    	
   	      
   	    }
   	    
   	    function formSubmit_Cancelar() {
       		
   					window.close();
   				
   	    	
   	    }
   	    
   	    function selCedente(icPessoa,cnpj,codCedente){
   	    	
   	    	var valorAltura = 400;
   			var valorLargura = 800;
   			var valorTopo = (screen.height - valorAltura) /2;
   			var valorEsquerda = (screen.width - valorLargura) /2;
   			
   			document.frmMain.cpfCnpj.value=cnpj;
   			document.frmMain.icPessoa.value=icPessoa;
   			document.frmMain.codCedente.value=codCedente;
   			janelaTarifa = window.open("<%=Paths.getRootForDynamicContent()%>/jump/servico_apropriar_tarifas_jump.jsp", "servico_apropriar_tarifas<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "height="+valorAltura+",width="+valorLargura+",top="+valorTopo+",left="+valorEsquerda+",toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=0");
   			janelaTarifa.focus();
   	    	
   	    
   	    }
	    
	   
		</script>
    
   	</s:FormStrategy>
   	
	<!-- ************************ FIM PAGINA INFORME TARIFAS ************************ -->
	   	
  </p:Document>
</html>
