<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: excepci_erro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualiza��o: 17/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.ExcepciManterEstrategia"%>

<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.ExcepcionacaoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%

	MsgSucessoErroBean msgBean;
	if (session.getAttribute(ExcepciManterEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setStrategyErrorReturn(msgBean.getStrategyErrorReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(ExcepciManterEstrategia.MSG_BEAN);
	}
	msgBean.setMsgError(request.getAttribute("msgError")==null?(String)request.getAttribute("javax.servlet.error.message"):(String) request.getAttribute("msgError"));

	ExcepcionacaoBean excepciBean		 	= (session.getAttribute(ExcepciManterEstrategia.EXCEPCI_BEAN)==null? new ExcepcionacaoBean()
																						:(ExcepcionacaoBean)session.getAttribute(ExcepciManterEstrategia.EXCEPCI_BEAN));	

  CedenteCabecaBean cabecalhoBean 	= (session.getAttribute(ExcepciManterEstrategia.CEDENTE_CABECALHO_BEAN)==null? new CedenteCabecaBean()
  																		      :(CedenteCabecaBean)session.getAttribute(ExcepciManterEstrategia.CEDENTE_CABECALHO_BEAN));

	String codigoCedente = Util.toStr(excepciBean.getCodigoCedenteFormatado());
	if (codigoCedente.equals("")) {
		codigoCedente = Util.toStr(cabecalhoBean.getCodigoCedenteFormatado());
	}
	
%>

<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=msgBean.getStrategyErrorReturn()%>" fluxo="voltar">
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">	
						<tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=codigoCedente%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" width="26%"><%=cabecalhoBean.getNomeFantasia()%>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
              <td class="textoValor" width="26%"><%=cabecalhoBean.getTipoPessoaTexto()%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cabecalhoBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
	            <td class="textoTitulo" width="17%">C�digo Cliente (COCLI): </td>
	            <td class="textoValor" width="26%"><%=cabecalhoBean.getCodigoClienteCOCLI().equals(new Long(0))? "":cabecalhoBean.getCodigoClienteCOCLI().toString()%></td> 
	            <td class="textoTitulo" width="17%">Perfil usu�rio Al�ada: </td>
	            <td class="textoValor" width="26%"><%=excepciBean.getPerfilUsuarioAlcada()%></td>
	          </tr>
            <tr>
              <td class="textoTitulo" width="17%">Pend�ncia: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getNumeroPendencia().equals(new Long(0))? "":excepciBean.getNumeroPendencia().toString()%></td>
              <td class="textoTitulo" width="17%">Data Pend�ncia: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getDataPendenciaOrig()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Situa��o Pend�ncia: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getDescSituacaoPendencia()%></td>
              <td class="textoTitulo" width="17%">Data Situa��o</td>
              <td class="textoValor" width="26%"><%=excepciBean.getDataSituacao()%></td>
            </tr>
						<tr>
              <td class="textoTitulo" width="17%">Usu�rio Gerador: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getUsuarioGerador()%></td>
              <td class="textoTitulo" width="17%">Hora Gera��o: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getHoraGeracaoFormatada()%></td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Justificativa: </td>
              <td colspan="3" class="textoValor" width="26%"><%=excepciBean.getJustificativa()%></td>
						</tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>        
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">
                <hr>
              </td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr> 
			      <tr>
			        <td colspan="4" align="center">
			          <p align="center">
									<table width="70%" height="90" border="1" cellspacing="0" cellpadding="0" align="center" valign="middle" bordercolordark="#cccccc" bordercolorlight="#ffffff">
										<tr>
											<td colspan="2" valign="center" align="middle">
												<img src="<%=Paths.getImagePath()%>/caixa_nome.gif">
											</td>
										</tr>
										<tr bgcolor="#f5f5f5">
											<td width="10%" valign="center" align="middle">
												<img src="<%=Paths.getImagePath()%>/msgErro.gif">
											</td>
											<td class="textoDestaqueTitulo" valign="center" align="middle">
												<%=msgBean.getMsgError()%>
											</td>
										</tr>
									</table>
								</p>
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
        document.frmMain.submit();
	    }
				
    </script>    
  </s:FormStrategy>
</p:Document>
</html>