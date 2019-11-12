<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: gerenc_consultar_cedmovtipvan.jsp - Java Server Pages
*Autor: Renato K. Araujo - raraujo@sao.politec.com.br
*Ultima Atualização: 23/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.GerencCedMovimentoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GerencEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>

<%
	PageHolder paginacao = (PageHolder)session.getAttribute(GerencEstrategia.PAGINACAO_LIST);
	List lista = paginacao.getPageable().getPage(0, paginacao.getPageable().size());
%>

<%
	GerencCedMovimentoBean gerencBean = (session.getAttribute(GerencEstrategia.BEAN_FIXO)==null?new GerencCedMovimentoBean():(GerencCedMovimentoBean)session.getAttribute(GerencEstrategia.BEAN_FIXO));
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
 								    <td nowrap width="20%" align="left">Van</td>
								    <td nowrap width="20%" align="left">Qtd. Remessa</td>
 								    <td nowrap width="20%" align="left">Qtd. Retorno</td>
 								    <td nowrap width="20%" align="left">Total</td>
								  </tr>

<%
	int i = 0;
	for (i = 0; i < lista.size(); i++ ) {	
		GerencCedMovimentoBean occ = (GerencCedMovimentoBean) lista.get(i);
%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescricao()%></td>
								    <td nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdRemessa()==null ? new Long(0) : occ.getQtdRemessa())%></td>
 								    <td nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdRetorno()==null ? new Long(0) :occ.getQtdRetorno())%></td>
 								    <td nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdRemessaRetorno()==null ? new Long(0) :occ.getQtdRemessaRetorno())%></td>
								  </tr>
<%
	}
%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total</td>
								    <td class="textoDestaqueValor" nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalRemessa()==null ? new Long(0) :gerencBean.getTotalRemessa())%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalRetorno()==null ? new Long(0) :gerencBean.getTotalRetorno())%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalRemessaRetorno()==null ? new Long(0) :gerencBean.getTotalRemessaRetorno())%></td>
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
