<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: gerenc_consultar_cedmeient.jsp - Java Server Pages
*Autor: Renato K. Araujo - raraujo@sao.politec.com.br
*Ultima Atualiza��o: 23/11/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.GerencCedMeioEntradaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GerencEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador" %>

<% 
	PageHolder paginacao = (PageHolder)session.getAttribute(GerencEstrategia.PAGINACAO_LIST);
	List lista = paginacao.getPageable().getPage(0, paginacao.getPageable().size());
%>

<%
	GerencCedMeioEntradaBean gerencBean = (session.getAttribute(GerencEstrategia.BEAN_FIXO)==null?new GerencCedMeioEntradaBean():(GerencCedMeioEntradaBean)session.getAttribute(GerencEstrategia.BEAN_FIXO));
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
								    <td nowrap width="30%" align="center" colspan="2">Registrado</td>
 								    <td nowrap width="30%" align="center" colspan="2">Sem Registro</td>
								  </tr>
								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">&nbsp;</td>
								    <td nowrap width="15%" align="left">Qtde. Com Mov.</td>
 								    <td nowrap width="15%" align="left">Qtde. Sem Mov.</td>
								    <td nowrap width="15%" align="left">Qtde. Com Mov.</td>
 								    <td nowrap width="15%" align="left">Qtde. Sem Mov.</td>
								  </tr>
								  
<%
	int i = 0;
	for (i = 0; i < lista.size(); i++ ) {	
		GerencCedMeioEntradaBean occ = (GerencCedMeioEntradaBean) lista.get(i);
%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescricao()%></td>
								    <td nowrap width="15%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdRegComMovto()==null ? new Long(0) :occ.getQtdRegComMovto())%></td>
 								    <td nowrap width="15%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdRegSemMovto()==null ? new Long(0) :occ.getQtdRegSemMovto())%></td>
 								    <td nowrap width="15%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdSRegComMovto()==null ? new Long(0) :occ.getQtdSRegComMovto())%></td>
 								    <td nowrap width="15%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtdSRegSemMovto()==null ? new Long(0) :occ.getQtdSRegSemMovto())%></td>
								  </tr>
<%
	}
%>								  
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total</td>
								    <td class="textoDestaqueValor" nowrap width="15%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalQtdRegComMovto()==null ? new Long(0) :gerencBean.getTotalQtdRegComMovto())%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalQtdRegSemMovto()==null ? new Long(0) :gerencBean.getTotalQtdRegSemMovto())%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalQtdSRegComMovto()==null ? new Long(0) :gerencBean.getTotalQtdSRegComMovto())%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="left"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalQtdSRegSemMovto()==null ? new Long(0) :gerencBean.getTotalQtdSRegSemMovto())%></td>
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
