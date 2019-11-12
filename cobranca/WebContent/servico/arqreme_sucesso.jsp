<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: arqreme_sucesso.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 28/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ArquivoRemessaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ArqRemeEstrategia"%>


<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(ArqRemeEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(ArqRemeEstrategia.MSG_BEAN);
	}
%>

<%
  ArquivoRemessaBean arqBean = (session.getAttribute(ArqRemeEstrategia.DATA_BEAN)==null?new ArquivoRemessaBean():(ArquivoRemessaBean)session.getAttribute(ArqRemeEstrategia.DATA_BEAN));
  CedenteCabecaBean cedCabBean = (session.getAttribute(ArqRemeEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(ArqRemeEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
	estrategia="<%=msgBean.getStrategySucessReturn()%>" fluxo="voltar">
	<s:Menu/>
	<s:Titulo name="<%=msgBean.getTitlePage()%>"/>    
	
	<input type="hidden" name = "consultaUnidade" value="">
	
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="center"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
	        <tr>
  				<td class="textoTitulo" width="17%">Unidade PV:</td>
	            <td class="textoValor" width="26%"><%=arqBean.getCodigoUnidadePVFormatado()%></td>
				<td class="textoTitulo" width="17%">Nome Unidade: </td>
		 		<td class="textoValor" width="26%"><%=arqBean.getNomeUnidadePV()%></td> 
			</tr>
	        <tr>
  				<td class="textoTitulo" width="17%">Cedente: </td>
	            <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
				<td class="textoTitulo" width="17%">Nome: </td>
		 		<td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
			</tr>
            <tr>
            	<td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
            	<td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 
            	<td class="textoTitulo" width="17%">CPF/CNPJ: </td>
            	<td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
            	<td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
            	<td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals( new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
  				<td class="textoTitulo" width="17%">Apelido: </td>
	            <td class="textoValor" width="26%"><%=arqBean.getApelidoCedente()+""%></td>
	        </tr>
	        <tr>
  				<td class="textoTitulo" width="17%">Nro. próxima remessa:</td>
	            <td class="textoValor" width="26%"><%=arqBean.getNumeroProxRemessa()+""%></td>
				<td class="textoTitulo" width="17%">Nro. último retorno:</td>
		 		<td class="textoValor" width="26%"><%=arqBean.getNumeroUltRetorno()%></td> 
			</tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
          </table>
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">
                <hr>
              </td>
            </tr>
	          <tr> 
	            <td colspan="4" align="center">
	            	<h3 style= "TEXT-ALIGN:center"><%=msgBean.getMsgSucess()%></h3>
	            </td>
	          </tr>
            <tr>
              <td colspan="2">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="2">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">
                <p align="center"> 
                  <s:Button name="Ok" action="javascript:formSubmit()"/>
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
    <script>
		function inicia() {
			setFirstFieldFocus();
		}
	    function formSubmit() {
        	if (validaSubmit()) {
	        	document.frmMain.fluxo.value = "voltar";
  		       	document.frmMain.submit();
	        }
	    }
		function validaSubmit() {
		    return true;
		}			
    </script>
  </s:FormStrategy>
</p:Document>
</html> 