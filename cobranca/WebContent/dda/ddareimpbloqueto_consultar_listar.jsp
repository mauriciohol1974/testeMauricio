<%
/***********************************************
*Projeto CAIXA - SIGCB DDA
*Componente: ddareimpbloqueto_consultar_listar.jsp - Java Server Pages
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
<%@page import="br.gov.caixa.sigcb.bean.DdaReimpBloquetoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.dda.DdaReimpBloquetoEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(DdaReimpBloquetoEstrategia.PAGINACAO_LIST);
	if(request.getParameter(DdaReimpBloquetoEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(DdaReimpBloquetoEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(DdaReimpBloquetoEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(DdaReimpBloquetoEstrategia.PAGINACAO_PAGE));
	}
	List lista =  paginacao.getPageCount() == 0 ? new LinkedList(): paginacao.getPage(paginaAtual);
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
		estrategia="<%=DdaReimpBloquetoEstrategia.STRATEGY_LISTAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=DdaReimpBloquetoEstrategia.PAGE_TITLE_LISTAR%>"/>

  	<input type="hidden" name="<%=DdaReimpBloquetoEstrategia.PAGINACAO_PAGE%>" value="" />

		<input type="hidden" name ="tipoPessoaSacado"  value = '<%=ddaReimpBloquetoBean.getTipoPessoaSacado()%>' />
		<input type="hidden" name ="cpfCnpjSacado"	   value = '<%=ddaReimpBloquetoBean.getCpfCnpjSacado()%>' />
 		<input type="hidden" name ="dataVencimentoDe"  value = '<%=ddaReimpBloquetoBean.getDataVencimentoDeFormatada()%>' />
 		<input type="hidden" name ="dataVencimentoAte" value = '<%=ddaReimpBloquetoBean.getDataVencimentoAteFormatada()%>' />
 		<input type="hidden" name ="tipoBloquetoDda"   value = '<%=ddaReimpBloquetoBean.getTipoBloquetoDda()%>' />
 		<input type="hidden" name ="numeroControleRequisicao" value = '' />

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
              <td nowrap class="textoTitulo" width="17%">Tipo de Bloqueto: </td>
              <td nowrap class="textoValor" width="26%"><%=ddaReimpBloquetoBean.getTipoBloquetoDdaTexto()%></td>
              <td nowrap class="textoTitulo" width="17%">&nbsp;</td>
              <td nowrap class="textoValor" width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>

						<tr valign="top">
	         		<td colspan="4" class="textoTitulo">Consulta:
		           	<hr>
	         		</td>
	         	</tr>

						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td width="5%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Identificacao DDA</td>
								    <td nowrap width="20%" align="left">Nosso Numero</td>
                    <td nowrap width="10%" align="left">Codigo Cedente</td>
 								    <td nowrap width="20%" align="left">Nome Cedente</td>
 								    <td nowrap width="10%" align="left">Moeda</td>
 								    <td nowrap width="10%" align="left">Valor</td>
 								    <td nowrap width="5%" align="left">Vencimento</td>
								  </tr>
							<%
							    DdaReimpBloquetoBean occ = new DdaReimpBloquetoBean();
									for ( int i = 0; i < lista.size(); i++ ) {
										occ = (DdaReimpBloquetoBean) lista.get(i);
							%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="5%" align="center">
											<input type="radio" name="rad"
										    onclick="javascript: clickRadio('<%=occ.getNumeroControleRequisicao()%>');">
								    </td>
 								    <td nowrap width="20%" align="left"><%=occ.getNumeroIdentificacaoDda()%></td>
 								    <td nowrap width="20%" align="left"><%=occ.getNossoNumero()%></td>
 								    <td nowrap width="10%" align="left"><%=occ.getCodigoCedenteFormatado()%></td>
 								    <td nowrap width="20%" align="left"><%=occ.getNomeCedente()%></td>
 								    <td nowrap width="10%" align="left"><%=occ.getNomeMoeda()%></td>
 								    <td nowrap width="10%" align="left"><%=occ.getValorTitulo()%></td>
 								    <td nowrap width="5%" align="left"><%=occ.getDataVencimentoFormatada()%></td>
								  </tr>
              <%
                  }
              %>
 	                <tr>
	                  <td colspan="8">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="8" align="center">
											<s:ButtonPaginar
											  		pageNumber="<%=paginacao.getPageNumber()%>"
											  		numberOfPages="<%=paginacao.getPageCount()%>"
											  		pageName="<%=DdaReimpBloquetoEstrategia.PAGE_LISTAR%>"/>
										</td>
									</tr>
 	                <tr>
	                  <td colspan="8">&nbsp;</td>
	                </tr>

	                <tr>
	                  <td align="right" colspan="8">
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
  	    document.frmMain.estrategia.value = "<%=DdaReimpBloquetoEstrategia.STRATEGY_INICIAR%>";
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

	  function clickRadio(codigo){
			document.frmMain.numeroControleRequisicao.value = codigo;
	  }
		</script>
  </s:FormStrategy>
</p:Document>
</html>