<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: gerenc_consultar_cedsitmov.jsp - Java Server Pages
*Autor: Renato K. Araujo - raraujo@sao.politec.com.br
*Ultima Atualização: 23/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.GerencCedSituacaoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GerencEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador" %>

<% 
	PageHolder paginacao = (PageHolder)session.getAttribute(GerencEstrategia.PAGINACAO_LIST);
	List lista = paginacao.getPageable().getPage(0, paginacao.getPageable().size());
%>

<%
	GerencCedSituacaoBean gerencBean = (session.getAttribute(GerencEstrategia.BEAN_FIXO)==null?new GerencCedSituacaoBean():(GerencCedSituacaoBean)session.getAttribute(GerencEstrategia.BEAN_FIXO));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=GerencEstrategia.STRATEGY_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=GerencEstrategia.PAGE_TITLE%>"/>
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

						<%-- CABECALHO --%>
						<%@include file="gerenc_consultar_cabecalho.jsp" %>

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
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">&nbsp;</td>
								    <td nowrap width="60%" colspan="3" align="center">Quantidade</td>
								  </tr>

								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Cedentes Cobrança Eletrônica</td>
								    <td nowrap width="20%" align="left">Sem Movimentação</td>
 								    <td nowrap width="20%" align="left">Com Movimentação</td>
 								    <td nowrap width="20%" align="left">Total</td>
								  </tr>

<%
	// Constantes para inserir os valores da lista nas posições corretas.
	final Long CEDENTES_EM_TESTE_PRODUCAO	    = new Long(1);
	final Long CEDENTES_TRANSFERIDOS_PRODUCAO = new Long(2);

	int j = 0; // controle de cor da linha
	for (int i = 0; i < lista.size(); i++ ) {	
		GerencCedSituacaoBean occ = (GerencCedSituacaoBean) lista.get(i);
		if (CEDENTES_EM_TESTE_PRODUCAO.equals(occ.getTipoAssunto())) {
%>
									<tr <%= ( ((j+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescricao()%></td>
								    <td nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdSemMovto()==null ? new Long(0) : occ.getQtdSemMovto()) %></td>
 								    <td nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdComMovto()==null ? new Long(0) : occ.getQtdComMovto())%></td>
 								    <td nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdTotal()==null ? new Long(0) : occ.getQtdTotal())%></td>
								  </tr>
<%
			j++;
		}
	}
%>								  
									<tr <%= ( ((j+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total</td>
								    <td class="textoDestaqueValor" nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalSemMovto()==null ? new Long(0) : gerencBean.getTotalSemMovto())%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalComMovto()==null ? new Long(0) :gerencBean.getTotalComMovto()) %></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalGeral()==null ? new Long(0) : gerencBean.getTotalGeral())%></td>
								  </tr>
<%
	j++;
%>									  
								  

								  <tr <%= ( ((j+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">&nbsp;</td>
								    <td nowrap width="20%" align="left">&nbsp;</td>
								    <td nowrap width="20%" align="left">&nbsp;</td>
								    <td nowrap width="20%" align="left">&nbsp;</td>
								  </tr>
<%
	j++;
%>									  


<%
	for (int i = 0; i < lista.size(); i++ ) {	
		GerencCedSituacaoBean occ = (GerencCedSituacaoBean) lista.get(i);
		if (CEDENTES_TRANSFERIDOS_PRODUCAO.equals(occ.getTipoAssunto())) {
%>
									<tr <%= ( ((j+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescricao()%></td>
								    <td nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdSemMovto()==null ? new Long(0) :occ.getQtdSemMovto())%></td>
 								    <td nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdComMovto()==null ? new Long(0) :occ.getQtdComMovto())%></td>
 								    <td nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdTotal()==null ? new Long(0) :occ.getQtdTotal())%></td>
								  </tr>
<%
			j++;
		}
	}
%>								  
								  </tr>
								</table>
							</td>
						</tr>            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
						<tr>
					  	<td align="right" colspan="4">
              	<p align="center"> 
	              	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
								</p>
	            </td>
	          </tr>
          </table>
        </td>
      </tr>
    </table>
		<script>

	    function inicia(){
	    }

	    function formSubmit_Voltar() {
        	document.frmMain.fluxo.value = "voltar";
         	document.frmMain.submit();
      }  

		</script>
  </s:FormStrategy>
</p:Document>
</html>
