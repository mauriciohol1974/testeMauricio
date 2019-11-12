
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.PrivilegioUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>

<% 
	PrivilegioUsuarioBean usuarioBean = (session.getAttribute(CedenteEstrategia.PRIVILEGIO_BEAN)==null
	                                    ? new PrivilegioUsuarioBean()
	                                    : (PrivilegioUsuarioBean)	session.getAttribute(CedenteEstrategia.PRIVILEGIO_BEAN));


	CedenteGeralBean cedenteBean = (session.getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN)==null? new CedenteGeralBean(): (CedenteGeralBean)	session.getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN));
	
	String codigoUnidadePVVinc = "";
	if (usuarioBean.getCodUnidPVVinculacao() != null
	    && usuarioBean.getCodUnidPVVinculacao().intValue() > 0) {
		codigoUnidadePVVinc = usuarioBean.getCodUnidPVVinculacao().toString();
	}

	// se for gestor nao precisa mostrar o pv, ele eh digitado
	if (usuarioBean.ehGestor()) {
		codigoUnidadePVVinc = "";
	}

String codigoUnidadeDisabled = (codigoUnidadePVVinc.equals("") || usuarioBean.ehGestor())
	                               ? "false"
	                               : "true";
%>

<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteIncluirExpressoIniciar" fluxo="normal">  
   	<input type="hidden" name="tipoInscricao" 		value="<%= cedenteBean.getTipoInscricao()%>"/>
   	<input type="hidden" name="cpfCnpj" 			value="<%= cedenteBean.getCpfCnpj().toString()%>"/>
   	<input type="hidden" name="codigoUnidadePVVinc" value="<%= cedenteBean.getCodigoUnidadePVVinc().toString()%>"/>
   	<input type="hidden" name="codigoClienteCOCLI"  value="<%= cedenteBean.getCodigoClienteCOCLI().toString()%>"/>
   	
   	 	          				
   		<s:Menu/>
   		<s:Titulo name="Incluir Cedente >> Filtro"/>

	    <table width="777" border="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
	            <tr>
	              <td width="3%"><input type="radio" name="rdo" id="exp" ></td> 
	              <td width="17%" class="textoDestaqueTitulo" ><b>Inclusão Expressa</b></td>
	            </tr>
	            <tr>
	              <td width="3%"></td>
	              <td width="60%" class="textoTitulo"> 
	                Ideal para clientes que desejam configurações básicas da cobrança bancária, informando apenas as contas vinculadas e tipo de cobrança/forma de transmissão
	              </td>
	              
	            </tr>
	            <tr>
	            	<td>&nbsp;</td>
	            </tr>
	            <tr>
	            	<td width="3%"><input type="radio" name="rdo" id="per"></td>
	            	<td class="textoDestaqueTitulo" width="17%" ><b>Inclusão Personalizada</b></td>
		        </tr>
		        <tr>
		        	<td>&nbsp;</td>
			        <td width="60%" class="textoTitulo">
	        		Para aqueles que necessitam acesso ao cadastro completo para parametrizações específicas
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
	                <p align="center"> 
						<s:Button name="Ok" action="javascript:formSubmit()"/>
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
				if (document.getElementById("exp").checked == true) {
					document.frmMain.estrategia.value="cedente.CedenteIncluirExpressoIniciar";
					document.frmMain.submit();
				}else	if (document.getElementById("per").checked == true) {
					document.frmMain.estrategia.value="cedente.CedenteIncluirFiltro";
					document.frmMain.submit();
					
				}
				
			}
			

			</script>
			
		</s:FormStrategy>
	</p:Document>
</html>
