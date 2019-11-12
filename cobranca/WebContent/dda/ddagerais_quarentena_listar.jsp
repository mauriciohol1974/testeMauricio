<%
/***********************************************
*Projeto CAIXA - SIGCB DDA
*Componente: ddagerais_quarentena_listar.jsp - Java Server Pages
*Criado em: 02/10/2009
*Autor: Glauber Gallego
*Ultima Atualização: 02/10/2009
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.DdaGeraisBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.dda.DdaGeraisEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(DdaGeraisEstrategia.PAGINACAO_LIST);
	if(request.getParameter(DdaGeraisEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(DdaGeraisEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(DdaGeraisEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(DdaGeraisEstrategia.PAGINACAO_PAGE));
	}
	List lista =  paginacao.getPageCount() == 0 ? new LinkedList(): paginacao.getPage(paginaAtual);
%>

<%
  DdaGeraisBean ddaGeraisBean = (session.getAttribute(DdaGeraisEstrategia.BEAN_LISTAR)==null?
		                            new DdaGeraisBean():
		                            (DdaGeraisBean)session.getAttribute(DdaGeraisEstrategia.BEAN_LISTAR));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=DdaGeraisEstrategia.STRATEGY_LISTAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=DdaGeraisEstrategia.PAGE_TITLE_QUARENTENA_LISTAR%>"/>

  	<input type="hidden" name="<%=DdaGeraisEstrategia.PAGINACAO_PAGE%>" value="" />

		<input type="hidden" name ="tipoPessoaSacado"  value='<%=ddaGeraisBean.getTipoPessoaSacado()%>' />
		<input type="hidden" name ="cpfCnpjSacado"	   value='<%=ddaGeraisBean.getCpfCnpjSacado()%>' />
		<input type="hidden" name ="tipoDataFiltro"    value ='<%=ddaGeraisBean.getTipoDataFiltro()%>' />
 		<input type="hidden" name ="mesAnoFiltro" 		 value = '<%=ddaGeraisBean.getTipoDataFiltro().equals(new Long(1)) ? ddaGeraisBean.getDataFiltroFormatada() : "" %>' />
 		<input type="hidden" name ="dataFiltro" 			 value = '<%=ddaGeraisBean.getTipoDataFiltro().equals(new Long(2)) ? ddaGeraisBean.getDataFiltroFormatada() : "" %>' />
 		<input type="hidden" name ="tipoConsulta"      value ='<%=ddaGeraisBean.getTipoConsulta()%>' />
 		<input type="hidden" name ="numeroControleRequisicao" value ="" />

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">

            <tr>
              <td nowrap class="textoTitulo" width="17%">Tipo de Pessoa: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getTipoPessoaSacadoTexto()%></td>
              <td nowrap class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getCpfCnpjSacadoFormatado()%></td>
            </tr>
            <tr>
              <td nowrap class="textoTitulo" width="17%">Tipo de Data: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getTipoDataFiltroTexto()%></td>
              <td nowrap class="textoTitulo" width="17%">Data: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getDataFiltroFormatada()%></td>
            </tr>
            <tr>
              <td nowrap class="textoTitulo" width="17%">Tipo de Consulta: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getTipoConsultaTexto()%></td>
              <td nowrap class="textoTitulo" width="17%">&nbsp;</td>
              <td nowrap class="textoValor" width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td nowrap class="textoTitulo" width="17%">Quantidade: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getQuantidadePorCpfCnpj()%></td>
              <td nowrap class="textoTitulo" width="17%">Valor: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaGeraisBean.getValorPorCpfCnpj()%></td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>

						<tr valign="top">
	         		<td colspan="5" class="textoTitulo">Consulta:
		           	<hr>
	         		</td>
	         	</tr>

						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td width="5%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Nosso Numero CIP</td>
								    <td nowrap width="25%" align="left">Pagamento</td>
								    <td nowrap width="25%" align="left">Vencimento</td>
 								    <td nowrap width="25%" align="left">Valor</td>
								  </tr>
							<%
									DdaGeraisBean occ = new DdaGeraisBean();
									for ( int i = 0; i < lista.size(); i++ ) {
										occ = (DdaGeraisBean) lista.get(i);
							%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="5%" align="center">
											<input type="radio" name="rad"
										    onclick="javascript: clickRadio('<%=occ.getNumeroControleRequisicao()%>');">
								    </td>
 								    <td nowrap width="20%" align="left"><%=occ.getNumeroIdentificacaoDda()%></td>
 								    <td nowrap width="25%" align="left"><%=occ.getDataPagamentoFormatada()%></td>
 								    <td nowrap width="25%" align="left"><%=occ.getDataVencimentoFormatada()%></td>
 								    <td nowrap width="25%" align="left"><%=occ.getValorTitulo()%></td>
								    <td nowrap width="25%" align="left">&nbsp;</td>
								  </tr>
              <%
                  }
              %>
 	                <tr>
	                  <td colspan="5">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="5" align="center">
											<s:ButtonPaginar
											  		pageNumber="<%=paginacao.getPageNumber()%>"
											  		numberOfPages="<%=paginacao.getPageCount()%>"
											  		pageName="<%=DdaGeraisEstrategia.PAGE_QUARENTENA_LISTAR%>"/>
										</td>
									</tr>
 	                <tr>
	                  <td colspan="5">&nbsp;</td>
	                </tr>

	                <tr>
	                  <td align="right" colspan="5">
	                    <p align="center">
				                <s:Button name="Ok" action="javascript:formSubmit()"/>
				                <s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
	                    </p>
	                  </td>
	                </tr>
	              </table>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
		<script>
		  // ############################## Inicializacao

	    function inicia(){
	    }

 			// ############################## Finalizacao

	  	function formSubmit() {
        if(validaSubmit()){
           document.frmMain.submit();
        }
	    }

	    function formSubmit_Voltar() {
  	    document.frmMain.estrategia.value = "<%=DdaGeraisEstrategia.STRATEGY_INICIAR%>";
      	document.frmMain.fluxo.value = "voltar";
      	document.frmMain.submit();
      }

      // ############################## Validacao

			function validaSubmit() {
			<%if(paginacao.getCurrentPageSize() > 1){%>
					if(!validaRadioButton(document.frmMain.rad, "")){
					  return false;
					}
			<%} else {%>
					if(!document.frmMain.rad.checked){
						msg('003', '');
						return false;
					}
			<%}%>
			return true;
    }

	  function clickRadio(codigo,diaMov){
			document.frmMain.numeroControleRequisicao.value = codigo;
	  }
		</script>
  </s:FormStrategy>
</p:Document>
</html>