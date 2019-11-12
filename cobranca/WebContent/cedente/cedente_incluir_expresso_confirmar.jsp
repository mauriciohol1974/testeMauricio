
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.PrivilegioUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteExpressoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteTarifasBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteFloatBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<% 
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute("usuarioLdap");

	CedenteExpressoBean cedBean = (CedenteExpressoBean) request.getAttribute(CedenteEstrategia.INCLUIR_EXPRESSO_BEAN);
	
	CedenteExpressoBean cedBeanRet = (CedenteExpressoBean) request.getAttribute(CedenteEstrategia.INCLUIR_EXPRESSO_BEAN_CONFIRMA);
	
%>


<%
			ArrayList listaFloatDefault = (ArrayList) request.getAttribute(CedenteEstrategia.FLOAT_LISTA_DEFAULT);
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


<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteIncluirExpressoConfirmar" fluxo="normal">   	          				
   		<s:Menu/>
   		<input type="hidden" name="codigoClienteCOCLI" value="<%=cedBean.getNuCOCLI() %>"/>
   		<input type="hidden" name="codigoUnidadePVVinc" value="<%=cedBean.getNuPv().toString() %>"/>
   		<input type="hidden" name="ipConexao" value="<%=cedBean.getIpConexao()%>"/>
   		
   		
   		<s:Titulo name="Incluir Cedente Expresso"/>

	    <table width="777" border="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
	          
	          	<%@include file="cedente_cabecalho.jsp" %>
	          
	       		<tr>
				<td colspan="4">
				<%@include	file="cedente_consultar_guiageral.jsp"%> 
				</td>
				</tr>
				
				<tr>
					<td colspan="4">&nbsp;</td>
				</tr>
		
	
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
		
					<%for (int i = 0; i < arrayLabels.length; i++) {%>
					<tr>
						<td width="1%" align="left" nowrap>&nbsp;</td>
						<td class="textoTitulo" width="50%" nowrap><%=arrayLabels[i]%>:</td>
						<td class="textoValor" width="20%" align="center" nowrap><%=arrayDefaults[i]%>
						</td>
						<td class="textoValor" width="20%" align="center" nowrap><%=arrayFloats[i]%>
						<td width="1%" align="left" nowrap>&nbsp;</td>
					</tr>
					<%}%>
		
				</table>
				</td>
				</tr>
			
				<tr>
					<td colspan="4">&nbsp;</td>
				</tr>

	            
	            <tr>
		            <td class="textoDestaqueTitulo" colspan="4">Guia Contas Débito/Crédito</td>
	            </tr>
	            
	            
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
				
					<tr>
						<td class="textoTitulo" width="10%">Conta Crédito:</td>
						<td width="33%" class="textoValor" nowrap><%= cedBeanRet.getUnConta()%>
						<%=cedBeanRet.getOpConta()%>
						<%=cedBeanRet.getNuConta()%>
						<%=cedBeanRet.getDvConta()%></td>
						<td class="textoTitulo" width="12%">Perc. Participação:</td>
						<td width="31%" class="textoValor"><%=cedBeanRet.getPcRateio()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="10%">Conta Débito:</td>
						<td width="33%" class="textoValor" nowrap><%=cedBeanRet.getUnContadeb()%>
						<%=cedBeanRet.getOpContadeb()%>
						<%=cedBeanRet.getNuContadeb()%>
						<%=cedBeanRet.getDvContadeb()%></td>
						<td class="textoTitulo" width="12%">Perc. Participação:</td>
						<td width="31%" class="textoValor"><%=cedBeanRet.getPcRateiodeb()%></td>
					</tr>
	
	
		            
		            <tr>
		              <td colspan="4">&nbsp;</td>
		            </tr>
	            
	            
	           
	            
	            <tr>
				<td colspan="4">
				<%@include	file="cedente_consultar_guiaeletron.jsp"%> 
				</td>
				</tr>
	            
	            <tr>
				<td colspan="4">&nbsp;</td>
				</tr>
	            
	            <tr>
				<td colspan="4">
				<%@include	file="cedente_consultar_guiabloq.jsp"%> 
				</td>
				</tr>
				<tr>
					<td colspan="4">&nbsp;</td>
				</tr>
				
				<tr>
					<td colspan="4">&nbsp;</td>
				</tr>
			    
			    <tr>
				<td colspan="4">
				<%@include	file="cedente_consultar_guiatarifa_expresso.jsp"%> 
				</td>
				</tr>
				<tr>
					<td colspan="4">&nbsp;</td>
				</tr>
				
	 			<tr>
				<td colspan="4">
				<%@include	file="cedente_consultar_guiaparametros.jsp"%> 
				</td>
	 			</tr>
	 			
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>	     
	           
	            <tr>
				<td colspan="4">
				<%@include	file="cedente_consultar_guiapermissao_expresso.jsp"%> 
				</td>
	 			</tr>
	 			
                <tr> 
                  <td colspan="4">&nbsp;</td>
                </tr>	 
	            
	            <tr> 
	              <td colspan="4">
	                <p align="center"> 
						<s:Button name="Confirmar" action="javascript:formSubmit()"/>
						<s:Button name="Cancelar" action="javascript:cancelar()"/>
					</p>
	              </td>
	            </tr>
	          </table>
	        </td>
	      </tr>
	    </table>
	    
			<script>
			function inicia() {
				setFirstFieldFocus();
				
			}
					
			function formSubmit(){
				document.frmMain.submit();
			}
			
			function cancelar(){
				document.frmMain.estrategia.value="cedente.CedenteIncluirIniciar";
				document.frmMain.submit();
			}
			
			
			
		    function formSubmit_GrupoTarifas() {
				var valorAltura = 350;
				var valorLargura = 640;
				var valorTopo = (screen.height - valorAltura) /2;
				var valorEsquerda = (screen.width - valorLargura) /2;
	    
				janelaTarifa = window.open("<%=Paths.getRootForDynamicContent()%>/jump/cedente_consultar_tarifas_expresso_jump.jsp", "cedente_consultar_tarifas<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "height="+valorAltura+",width="+valorLargura+",top="+valorTopo+",left="+valorEsquerda+",toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=0");
				janelaTarifa.focus();
	   		}

			</script>
			
		</s:FormStrategy>
	</p:Document>
</html>
