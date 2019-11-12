<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: titliq_consultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 11/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>


<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.TitulosPropostaDetalheBean"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.TitulosPropostasEstrategia" %>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
	TitulosPropostaDetalheBean titpropostabean = (session.getAttribute(TitulosPropostasEstrategia.DATA_BEAN)==null? new TitulosPropostaDetalheBean()
																						:(TitulosPropostaDetalheBean)session.getAttribute(TitulosPropostasEstrategia.DATA_BEAN));
																																																														 
	CedenteCabecaBean cedCabBean = 	(session.getAttribute(TitulosPropostasEstrategia.CEDENTE_CABECALHO_BEAN)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(TitulosPropostasEstrategia.CEDENTE_CABECALHO_BEAN));
	
	String situacao = (String) request.getAttribute("situacao");
	
	String paginaDetalhe = (String) request.getAttribute("paginaDetalhe");
%>




<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.TitulosPropostaFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Títulos Propostas >> Detalhe"/>
				<input type="hidden" name="codigoCedente" value="<%=cedCabBean.getCodigoCedenteFormatado()%>">
				<input type="hidden" name="situacao" value="<%=situacao%>">
				<input type="hidden" name="paginaDetalhe" value="<%=paginaDetalhe%>">
 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
	            <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
	            <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
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
              <td colspan="4">
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="left">
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Nosso Número: </td>
				      <td nowrap class="textoValor" width="26%"><%= titpropostabean.getNossoNumeroFormatado()%></td>
                      <td nowrap class="textoTitulo" width="17%">Situação Adesão:</td>
				      <td nowrap class="textoValor" width="26%"><%=titpropostabean.getDescrSituacao() %></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Código Pagador:</td>
				      <td nowrap class="textoValor" width="26%"><%=titpropostabean.getNumPaginaPagador()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data Situação Adesão:</td>
				      <td nowrap class="textoValor" width="26%"><%=titpropostabean.getDataSituacaoFormatada() %></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Número Documento: </td>
				      <td nowrap class="textoValor" width="26%"><%=titpropostabean.getNumDocumento()%></td>
                      <td nowrap class="textoTitulo" width="17%">Valor Título: </td>
				      <td nowrap class="textoValor" width="26%"><%=titpropostabean.getValorTitulo() %></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%"> Nome Sacado:  </td>
				      <td nowrap colspan="3" class="textoValor" width="26%"><%=titpropostabean.getNomeSacado()%></td>
                      
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%"> CPF/CNPJ Sacado: </td>
				      <td nowrap class="textoValor" width="26%"><%=titpropostabean.getCpfCnpj()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data Vencimento:  </td>
				      <td nowrap class="textoValor" width="26%"><%=titpropostabean.getDtVencimentoFormatada() %></td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                  
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    
                  </table>
				</td>                  
            </tr>
            <tr>
	            <td align="right" colspan="4">
  	            <p align="center"> 
      	          <input type="button" class="button" name="Voltar" value="Voltar" onclick="javascript:formSubmit_Voltar()">
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
			function inicia(){
		   	setFirstFieldFocus();
	   	}
	   	function formSubmit(){}
	   	
	    function formSubmit_Voltar() {
				document.frmMain.estrategia.value = "consulta.TitulosPropostasFiltro";
        document.frmMain.fluxo.value = "voltar";
       	document.frmMain.submit();
	    }   

    </script>
		</s:FormStrategy>
	</p:Document>
</html>