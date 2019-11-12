<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: gerenc_consultar_qtmovtittar.jsp - Java Server Pages
*Autor: Eduardo A. Mor�s - emoras@sao.politec.com.br
*Ultima Atualiza��o: 24/11/2004
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
	GerencTituloBean gerencBean = (session.getAttribute(GerencEstrategia.BEAN_FIXO)==null?new GerencTituloBean():(GerencTituloBean)session.getAttribute(GerencEstrategia.BEAN_FIXO));
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

							<%	//Estaticos para inserir os valores da lista nas posi��es corretas.
									final Long INCLUIDO 								= new Long(1);
									final Long INCLUIDO_TOTAL 					= new Long(2);
									final Long LIQUIDADO 								= new Long(3);
									final Long LIQUIDADO_TOTAL 					= new Long(4);
									final Long SERVICO 									= new Long(5);
									final Long SERVICO_TOTAL 						= new Long(6);

									GerencTituloBean occ = new GerencTituloBean();
							%>						
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Titulos Inclu�dos</td>
								    <td nowrap width="15%" align="left">Quantidade</td>
 								    <td nowrap width="15%" align="left">Valor dos T�tulos</td>
 								    <td nowrap width="15%" align="left">Tarifa Efetiva</td>
 								    <td nowrap width="15%" align="left">Pre�o Transfer�ncia</td>
 								    <td nowrap width="15%" align="left">Resultado</td>
								  </tr>

							<%								
							for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencTituloBean) lista.get(i);
								if (occ.getTipoTitulo().equals(INCLUIDO)){%>
									<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescricao()%></td>
								    <td nowrap width="15%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getValor()%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getTarifa()%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getPreco()%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getResultado()%></td> 								    
								  </tr>
           	 	<%}
            	}
            	for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencTituloBean) lista.get(i);
         				if (occ.getTipoTitulo().equals(INCLUIDO_TOTAL)){%>
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total</td>
								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getValor()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getTarifa()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getPreco()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getResultado()%></td>
								  </tr>
							<%}
							}%>
								  <tr>
 								    <td colspan="7">&nbsp;</td>
								  </tr>
								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Titulos Liquidados</td>
								    <td nowrap width="15%" align="left">Quantidade</td>
 								    <td nowrap width="15%" align="left">Valor dos T�tulos</td>
 								    <td nowrap width="15%" align="left">Tarifa Efetiva</td>
 								    <td nowrap width="15%" align="left">Pre�o Transfer�ncia</td>
 								    <td nowrap width="15%" align="left">Resultado</td>
								  </tr>

							<%								
		          int classLine = 0;	
							for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencTituloBean) lista.get(i);
								if (occ.getTipoTitulo().equals(LIQUIDADO)){
									if ((classLine % 2) == 0){
         						classLine = 0;
         					}else {
         						classLine = 1;
         					}%>
								  <tr <%= ( classLine == 1 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescricao()%></td>
								    <td nowrap width="15%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getValor()%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getTarifa()%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getPreco()%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getResultado()%></td> 								    
								  </tr>
           	 	<%
           	 		classLine += 1;
           	 		}
            	}	
            	for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencTituloBean) lista.get(i);
         				if (occ.getTipoTitulo().equals(LIQUIDADO_TOTAL)){
									if ((classLine % 2) == 0){
         						classLine = 1;
         					}else {
         						classLine = 0;
         					}%>
								  <tr <%= ( classLine == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total</td>
								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getValor()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getTarifa()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getPreco()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getResultado()%></td>								  </tr>
							<%}
							}%>
								  <tr>
 								    <td colspan="6">&nbsp;</td>
								  </tr>
								  <tr class="headerLista">
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left">Outros Servicos</td>
								    <td nowrap width="15%" align="left">Quantidade</td>
 								    <td nowrap width="15%" align="left">Valor dos T�tulos</td>
 								    <td nowrap width="15%" align="left">Tarifa Efetiva</td>
 								    <td nowrap width="15%" align="left">Pre�o Transfer�ncia</td>
 								    <td nowrap width="15%" align="left">Resultado</td>
								  </tr>

							<%								
							classLine = 0;
							for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencTituloBean) lista.get(i);
								if (occ.getTipoTitulo().equals(SERVICO)){
									if ((classLine % 2) == 0){
         						classLine = 0;
         					}else {
         						classLine = 1;
         					}%>
								  <tr <%= ( classLine == 1 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%" align="center">&nbsp;</td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescricao()%></td>
								    <td nowrap width="15%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getValor()%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getTarifa()%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getPreco()%></td>
 								    <td nowrap width="15%" align="right"><%=occ.getResultado()%></td> 								    
								  </tr>
           	 	<%
           	 		classLine += 1;
           	 		}
            	}	
            	for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (GerencTituloBean) lista.get(i);
         				if (occ.getTipoTitulo().equals(SERVICO_TOTAL)){
									if ((classLine % 2) == 0){
         						classLine = 1;
         					}else {
         						classLine = 0;
         					}%>
								  <tr <%= ( classLine == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total</td>
								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(occ.getQtd() == null ? new Long(0) : occ.getQtd())%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getValor()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getTarifa()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getPreco()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=occ.getResultado()%></td>
								  </tr>
							<%}
							}%>
								  <tr <%= ( classLine == 1 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">&nbsp;</td>
								    <td class="textoDestaqueValor" nowrap width="15%" align="left">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="left">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="left">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="left">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="left">&nbsp;</td>
								  </tr>
								  <tr <%= ( classLine == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td class="textoDestaqueValor" nowrap width="1%" align="center">&nbsp;</td>
 								    <td class="textoDestaqueValor" nowrap width="20%" align="left">Total Geral</td>
								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=Formatador.formataInteiroPadraoBrasileiro(gerencBean.getTotalQtd() == null ? new Long(0) : gerencBean.getTotalQtd())%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=gerencBean.getTotalValor()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=gerencBean.getTotalTarifa()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=gerencBean.getTotalPreco()%></td>
 								    <td class="textoDestaqueValor" nowrap width="15%" align="right"><%=gerencBean.getTotalResultado()%></td>
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