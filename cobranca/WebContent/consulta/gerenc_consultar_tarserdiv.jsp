<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: gerenc_consultar_tarserdiv.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 23/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.GerencValTarifaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GerencEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>

<% 
	PageHolder paginacao = (PageHolder)session.getAttribute(GerencEstrategia.PAGINACAO_LIST);
	List lista = paginacao.getPageable().getPage(0, paginacao.getPageable().size());
%>

<%
	GerencValTarifaBean gerencBean = (session.getAttribute(GerencEstrategia.BEAN_FIXO)==null?new GerencValTarifaBean():(GerencValTarifaBean)session.getAttribute(GerencEstrategia.BEAN_FIXO));
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

							<%	//Estaticos para inserir os valores da lista nas posições corretas.
									final Long OUTROS 								= new Long(1);
									final Long OUTROS_TOTAL 					= new Long(2);
									final Long EMAIL 									= new Long(3);
									final Long EMAIL_TOTAL 						= new Long(4);
									final Long BCO_SACADO 						= new Long(5);
									final Long BCO_SACADO_TOTAL 			= new Long(6);
									final Long CED_ELETRONICO 				= new Long(7);
									final Long CED_ELETRONICO_TOTAL 	= new Long(8);

									GerencValTarifaBean occ = new GerencValTarifaBean();
							%>
						
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Outros</td>
								    <td nowrap width="20%" align="right">Quantidade</td>
 								    <td nowrap width="20%" align="right">Valor Esperado</td>
 								    <td nowrap width="20%" align="right">Valor Custo</td>
 								    <td nowrap width="20%" align="right">Valor Efetivado</td>
								  </tr>

							<%								
							for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencValTarifaBean) lista.get(i);
								if (occ.getTipoEmissao().equals(OUTROS)){%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescricao()%></td>
								    <td nowrap width="20%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorEsperado()%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorCusto()%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorEfetivado()%></td>
								  </tr>
           	 	<%}
            	}
            	for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencValTarifaBean) lista.get(i);
         				if (occ.getTipoEmissao().equals(OUTROS_TOTAL)){%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total</td>
								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorEsperado()%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorCusto()%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorEfetivado()%></td>
								  </tr>
							<%}
							}%>
								  <tr>
 								    <td colspan="6">&nbsp;</td>
								  </tr>
								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">e-mail</td>
								    <td nowrap width="20%" align="right">Quantidade</td>
 								    <td nowrap width="20%" align="right">Valor Esperado</td>
 								    <td nowrap width="20%" align="right">Valor Custo</td>
 								    <td nowrap width="20%" align="right">Valor Efetivado</td>
								  </tr>

							<%								
		          int classLine = 0;	
							for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencValTarifaBean) lista.get(i);
								if (occ.getTipoEmissao().equals(EMAIL)){
									if ((classLine % 2) == 0){
         						classLine = 0;
         					}else {
         						classLine = 1;
         					}%>
								  <tr <%= ( classLine == 1 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescricao()%></td>
								    <td nowrap width="20%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorEsperado()%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorCusto()%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorEfetivado()%></td>
								  </tr>
           	 	<%
           	 		classLine += 1;
           	 		}
            	}	
            	for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencValTarifaBean) lista.get(i);
         				if (occ.getTipoEmissao().equals(EMAIL_TOTAL)){
									if ((classLine % 2) == 0){
         						classLine = 1;
         					}else {
         						classLine = 0;
         					}%>
								  <tr <%= ( classLine == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total</td>
								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorEsperado()%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorCusto()%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorEfetivado()%></td>
								  </tr>
							<%}
							}%>
								  <tr>
 								    <td colspan="6">&nbsp;</td>
								  </tr>
								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Banco de Sacados e Títulos</td>
								    <td nowrap width="20%" align="right">Quantidade</td>
 								    <td nowrap width="20%" align="right">Valor Esperado</td>
 								    <td nowrap width="20%" align="right">Valor Custo</td>
 								    <td nowrap width="20%" align="right">Valor Efetivado</td>
								  </tr>

							<%								
							classLine = 0;
							for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencValTarifaBean) lista.get(i);
								if (occ.getTipoEmissao().equals(BCO_SACADO)){
									if ((classLine % 2) == 0){
         						classLine = 0;
         					}else {
         						classLine = 1;
         					}%>
								  <tr <%= ( classLine == 1 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescricao()%></td>
								    <td nowrap width="20%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorEsperado()%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorCusto()%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorEfetivado()%></td>
								  </tr>
           	 	<%
           	 		classLine += 1;
           	 		}
            	}	
            	for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencValTarifaBean) lista.get(i);
         				if (occ.getTipoEmissao().equals(BCO_SACADO_TOTAL)){
									if ((classLine % 2) == 0){
         						classLine = 1;
         					}else {
         						classLine = 0;
         					}%>
								  <tr <%= ( classLine == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total</td>
								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorEsperado()%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorCusto()%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorEfetivado()%></td>
								  </tr>
							<%}
							}%>
								  <tr>
 								    <td colspan="6">&nbsp;</td>
								  </tr>
								  								  
								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Cedente Eletrônico</td>
								    <td nowrap width="19%" align="right">Quantidade</td>
 								    <td nowrap width="20%" align="right">Valor Esperado</td>
 								    <td nowrap width="20%" align="right">Valor Custo</td>
 								    <td nowrap width="20%" align="right">Valor Efetivado</td>
								  </tr>
							<%								
							classLine = 0;
							for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencValTarifaBean) lista.get(i);
								if (occ.getTipoEmissao().equals(CED_ELETRONICO)){
									if ((classLine % 2) == 0){
         						classLine = 0;
         					}else {
         						classLine = 1;
         					}%>
								  <tr <%= ( classLine == 1 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescricao()%></td>
								    <td nowrap width="19%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorEsperado()%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorCusto()%></td>
 								    <td nowrap width="20%" align="right"><%=occ.getValorEfetivado()%></td>
								  </tr>
           	 	<%
           	 		classLine += 1;
           	 		}
            	}									 
            	for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencValTarifaBean) lista.get(i);
         				if (occ.getTipoEmissao().equals(CED_ELETRONICO_TOTAL)){
									if ((classLine % 2) == 0){
         						classLine = 1;
         					}else {
         						classLine = 0;
         					}%>
								  <tr <%= ( classLine == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total</td>
								    <td class="textoDestaqueValor" nowrap width="19%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorEsperado()%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorCusto()%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=occ.getValorEfetivado()%></td>
								  </tr>
							<%}
							}%>
								  <tr <%= ( classLine == 1 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">&nbsp;</td>
								    <td class="textoDestaqueValor" nowrap width="19%" align="left">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">&nbsp;</td>
								  </tr>
								  <tr <%= ( classLine == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total Geral</td>
								    <td class="textoDestaqueValor" nowrap width="19%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalQtd() == null ? new Long(0) : gerencBean.getTotalQtd())%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=gerencBean.getTotalValorEsperado()%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=gerencBean.getTotalValorCusto()%></td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="right"><%=gerencBean.getTotalValorEfetivado()%></td>
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