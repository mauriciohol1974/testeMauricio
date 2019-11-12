<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: excepci_manter_filtro.jsp - Java Server Pages
*Autor: Renato Kosaka Araujo - raraujo@sao.politec.com.br
*Ultima Atualização: 09/09/2004
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.PrivilegioUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>

<% 
	PrivilegioUsuarioBean usuarioBean = (session.getAttribute(CedenteEstrategia.PRIVILEGIO_BEAN)==null
	                                    ? new PrivilegioUsuarioBean()
	                                    : (PrivilegioUsuarioBean)	session.getAttribute(CedenteEstrategia.PRIVILEGIO_BEAN));

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
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteIncluirEscolha" fluxo="normal">   	          				
   		<s:Menu/>
   		<s:Titulo name="Incluir Cedente >> Filtro"/>

	    <table width="777" border="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
	            <tr>
	             <td class="textoTitulo" width="17%">CPF/CNPJ</td>
	             <td width="26%"><s:ComboTipoPessoa name="tipoInscricao" onChange="javascript:limpaCpfCnpj(cpfCnpj);"/>
					<p:InputCpfCnpj CLASS="inputtext" name="cpfCnpj" />
	              </td>
	              <td width="17%">&nbsp;</td>
	              <td width="26%">&nbsp;</td>
	            </tr>
	            <tr>
	              <td class="textoTitulo" width="17%">Pv de Vinculação: </td>
	              <td width="26%">
	        		<p:InputNumerico CLASS="inputtext" name="codigoUnidadePVVinc" value="<%= codigoUnidadePVVinc %>" size="5" maxlength="4" readonly="<%= codigoUnidadeDisabled %>"
	        		                 onFocus="javascript: prevFocus(this);"
							         onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>
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
				if (validaSubmit()){
					var pvTrim = trim(document.frmMain.codigoUnidadePVVinc.value);
					document.frmMain.codigoUnidadePVVinc.value = pvTrim;
					document.frmMain.submit();
				}
			}
			
			function validaSubmit() {
				if (!validaCampoObrigatorio(document.frmMain.cpfCnpj,'CPF/CNPJ')) {
					return false;
				}
				
				if(!validaCampoObrigatorio(document.frmMain.codigoUnidadePVVinc,'Código da Unidade PV')) {
					return false;
				}
				
				return true;
			}
			</script>
			
		</s:FormStrategy>
	</p:Document>
</html>
