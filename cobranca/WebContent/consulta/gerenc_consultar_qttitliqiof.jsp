<%
/***********************************************
* Probank
*Projeto CAIXA - SIGCB
*Componente: gerenc_consultar_qttitliqiof.jsp - Java Server Pages
*Autor: Adelaine Rondon - adelainer@probank.com.br
*Ultima Atualização: 05/01/2011
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.GerencTituloBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GerencEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<% 
	PageHolder paginacao = (PageHolder)session.getAttribute(GerencEstrategia.PAGINACAO_LIST);
	List lista = paginacao.getPageable().getPage(0, paginacao.getPageable().size());
%>

<%
	GerencTituloBean gerencBean = (GerencTituloBean)(session.getAttribute(GerencEstrategia.BEAN_FIXO));//==null?new GerencTituloBean():(GerencTituloBean)session.getAttribute(GerencEstrategia.BEAN_FIXO));
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
								    <td nowrap width="20%" align="left">Meio Liquidação</td>
 								    <td nowrap width="20%" align="right">Quantidade</td>
								    <td nowrap width="20%" align="right">Valor Recebido</td>
 								    <td nowrap width="20%" align="right">Valor Liquido</td>
								    <td nowrap width="20%" align="right">Valor IOF Retido</td>
								  </tr>
							<%								
							GerencTituloBean occ = new GerencTituloBean();
							for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencTituloBean) lista.get(i);%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    	<td nowrap class="textoValor" width="20%" align="left"><%=occ.getDescricao()%></td>
								    	<td nowrap class="textoValor" width="20%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    	<td nowrap class="textoValor" width="20%" align="right"><%=occ.getValorRecebido()%></td>
								    	<td nowrap class="textoValor" width="20%" align="right"><%=occ.getValorLiquido()%></td>
 								    	<td nowrap class="textoValor" width="20%" align="right"><%=occ.getValorIOFRetido()%></td>
								  </tr>
								  
           	<%}%>
									<tr <%=(lista.size())%2 == 0 ? "class='line1'" : "class='line0'" %>>
								        <td nowrap class="textoDestaqueValor" width="20%" align="left">Total</td>
								    	<td nowrap class="textoDestaqueValor" width="20%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalQtd()== null ? new Long(0) : gerencBean.getTotalQtd())%></td>
 								    	<td nowrap class="textoDestaqueValor" width="20%" align="right"><%=gerencBean.getTotalValorRecebido()%></td>
								    	<td nowrap class="textoDestaqueValor" width="20%" align="right"><%=gerencBean.getTotalValorLiquido()%></td>
 								    	<td nowrap class="textoDestaqueValor" width="20%" align="right"><%=gerencBean.getTotalValorIOFRetido()%></td>
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