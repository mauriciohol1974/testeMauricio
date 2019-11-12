<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bcotitu_sucesso.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 19/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BcoTituEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(BcoTituEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(BcoTituEstrategia.MSG_BEAN);
	}
%>

<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN));
	TituloBean tituloBean = (session.getAttribute(BcoTituEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(BcoTituEstrategia.DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=BcoTituEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal" >
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>
	
		<input type="hidden" name = "filtroSelecao" value="<%=tituloBean.getFiltroSelecao()%>">
		<input type="hidden" name = "filtroDescricaoSituacao" value="<%=tituloBean.getFiltroDescricaoSituacao()%>">
		<input type="hidden" name = "filtroDescricaoClassificacao" value="<%=tituloBean.getFiltroDescricaoClassificacao()%>">
		<input type="hidden" name = "filtroVoltarListarConsolidado" value="<%=tituloBean.getFiltroVoltarListarConsolidado()%>">
		<input type="hidden" name = "filtroVoltarListarTitulo" value="<%=tituloBean.getFiltroVoltarListarTitulo()%>">
		<input type="hidden" name = "filtroVoltarAcao" value="<%=tituloBean.getFiltroVoltarAcao()%>">
		
		<input type="hidden" name = "codigoCedente" value="<%=tituloBean.getCodigoCedente()%>">
		<input type="hidden" name = "nossoNumero" value="<%=tituloBean.getNossoNumero()%>">
		<input type="hidden" name = "situacao" value="<%=tituloBean.getSituacao()%>">
		<input type="hidden" name = "classificacao" value="<%=tituloBean.getClassificacao()%>"> 		

		<input type="hidden" name = "princiValorTitulo" value="<%=tituloBean.getPrinciValorTitulo()%>">
		<input type="hidden" name = "princiMeioEntrada" value="<%=tituloBean.getPrinciMeioEntrada()%>">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
	          <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
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
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
              <td class="textoTitulo" width="17%">Nosso Número: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getNossoNumeroFormatado()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Meio de Entrada: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getPrinciMeioEntrada()%></td>
							<td class="textoTitulo" width="17%">Valor: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getPrinciValorTitulo().toString()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Situação: </td>
              <td class="textoValor" width="26%"><%=tituloBean.getPrinciDescricaoSituacao()%></td> 
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
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
				encaminha();
			}	
			
			function encaminha() {
			<%if (tituloBean.getAcoesServicoTitulo().equals( new Long(5) )) {%> // Ordem de Protesto
				  document.frmMain.Voltar.disabled = false;
	      	retorno=window.open("<%=Paths.getRootForDynamicContent()%>/<%=BcoTituEstrategia.PAGE_IMPRESSAO_PROTESTO%>.jsp","ordempro<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "width=780,height=540,top=0,left=0,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=1");
	  	<%} else if (tituloBean.getAcoesServicoTitulo().equals( new Long(13) )) {%>
				  document.frmMain.Voltar.disabled = false;	  		
	      	retorno=window.open("<%=Paths.getRootForDynamicContent()%>/<%=BcoTituEstrategia.PAGE_IMPRESSAO_BLOQUETO%>.jsp","bloqueto<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "width=780,height=540,top=0,left=0,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=1");
			<%}%>
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