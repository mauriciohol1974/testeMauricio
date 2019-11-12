<%
/***********************************************
*Projeto CAIXA - SIGCB DDA
*Componente: ddareimpbloqueto_consultar_sucesso.jsp - Java Server Pages
*Criado em: 15/01/2010
*Autor: Glauber Gallego
*Ultima Atualização: 15/01/2010
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.DdaReimpBloquetoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.dda.DdaReimpBloquetoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(DdaReimpBloquetoEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(DdaReimpBloquetoEstrategia.MSG_BEAN);
	}
%>

<%
   DdaReimpBloquetoBean ddaReimpBloquetoBean = (session.getAttribute(DdaReimpBloquetoEstrategia.BEAN_LISTAR)==null?
                                               new DdaReimpBloquetoBean():
                                               (DdaReimpBloquetoBean)session.getAttribute(DdaReimpBloquetoEstrategia.BEAN_LISTAR));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=DdaReimpBloquetoEstrategia.STRATEGY_FILTRO%>" fluxo="normal" >
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>
	
    <input type="hidden" name ="tipoPessoaSacado"  value = '<%=ddaReimpBloquetoBean.getTipoPessoaSacado()%>' />
    <input type="hidden" name ="cpfCnpjSacado"     value = '<%=ddaReimpBloquetoBean.getCpfCnpjSacado()%>' />
    <input type="hidden" name ="dataVencimentoDe"  value = '<%=ddaReimpBloquetoBean.getDataVencimentoDeFormatada()%>' />
    <input type="hidden" name ="dataVencimentoAte" value = '<%=ddaReimpBloquetoBean.getDataVencimentoAteFormatada()%>' />
    <input type="hidden" name ="tipoBloquetoDda"   value = '<%=ddaReimpBloquetoBean.getTipoBloquetoDda()%>' />
    <input type="hidden" name ="numeroControleRequisicao" value = ''<%=ddaReimpBloquetoBean.getNumeroControleRequisicao()%>'' />

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">

            <tr>
              <td nowrap class="textoTitulo" width="17%">Tipo de Pessoa: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaReimpBloquetoBean.getTipoPessoaSacadoTexto()%></td>
              <td nowrap class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaReimpBloquetoBean.getCpfCnpjSacadoFormatado()%></td>
            </tr>
            <tr>
              <td nowrap class="textoTitulo" width="17%">Data Vencimento - De: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaReimpBloquetoBean.getDataVencimentoDeFormatada()%></td>
              <td nowrap class="textoTitulo" width="17%">Data Vencimento - Ate: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaReimpBloquetoBean.getDataVencimentoAteFormatada()%></td>
            </tr>
            <tr>
              <td nowrap class="textoTitulo" width="17%">Tipo de Boleto: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaReimpBloquetoBean.getTipoBloquetoDdaTexto()%></td>
              <td nowrap class="textoTitulo" width="17%">&nbsp;</td>
              <td nowrap class="textoValor" width="26%">&nbsp;</td>
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
	            <td colspan="4" align="center">
	            	<h3 style= "TEXT-ALIGN:center"><%=msgBean.getMsgSucess()%></h3>
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
                  <s:Button name="Voltar" action="javascript:formSubmit_Voltar();"/>
                </p>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    <script language="javascript">
	    function inicia(){
			  document.frmMain.Voltar.disabled = false;	  		
      	retorno=window.open("<%=Paths.getRootForDynamicContent()%>/<%=DdaReimpBloquetoEstrategia.PAGE_TITULO%>.jsp","bloqueto<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "width=780,height=540,top=0,left=0,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=1");
	    }

	    function formSubmit() {
	      formSubmit_Voltar();
	    }
    
	    function formSubmit_Voltar() {
				document.frmMain.submit();    
	    }    
    
    </script>
  </s:FormStrategy>
</p:Document>
</html>    