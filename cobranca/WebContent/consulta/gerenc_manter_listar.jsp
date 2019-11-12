<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Novembro de 2004
*Projeto CAIXA - SIGCB
*Componente: gerenc_manter_listar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 19/11/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.GerencFiltroBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GerencEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>

<% 
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(GerencEstrategia.PAGINACAO_LIST);
	if(request.getParameter(GerencEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(GerencEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(GerencEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(GerencEstrategia.PAGINACAO_PAGE));
	}
	
	
	List lista =  paginacao.getPageCount() == 0 ? new LinkedList(): paginacao.getPage(paginaAtual);	
%>


<%
	GerencFiltroBean gerencFiltroBean = (session.getAttribute(GerencEstrategia.BEAN_FILTRO)==null?new GerencFiltroBean():(GerencFiltroBean)session.getAttribute(GerencEstrategia.BEAN_FILTRO));
	GerencFiltroBean gerencBean = (session.getAttribute(GerencEstrategia.BEAN_FIXO)==null?new GerencFiltroBean():(GerencFiltroBean)session.getAttribute(GerencEstrategia.BEAN_FIXO));
	boolean pv = gerencFiltroBean.getTipoConsulta().equals(GerencEstrategia.TIPO_CONSULTA_PV);
	boolean en = gerencFiltroBean.getTipoConsulta().equals(GerencEstrategia.TIPO_CONSULTA_EN);
	boolean caixa = gerencFiltroBean.getTipoConsulta().equals(GerencEstrategia.TIPO_CONSULTA_CAIXA);
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=GerencEstrategia.STRATEGY_FILTRO%>" fluxo="normal">
		<s:Menu/>
<s:Visibility visible="<%=pv%>">								
		<s:Titulo name="<%=GerencEstrategia.PAGE_TITLE_PV%>"/>    
</s:Visibility>		  	
<s:Visibility visible="<%=en%>">								
		<s:Titulo name="<%=GerencEstrategia.PAGE_TITLE_EN%>"/>    
</s:Visibility>		  	
<s:Visibility visible="<%=caixa%>">								
		<s:Titulo name="<%=GerencEstrategia.PAGE_TITLE_CAIXA%>"/>    
</s:Visibility>
	  	
  	<input type="hidden" name="<%=GerencEstrategia.PAGINACAO_PAGE%>" value="">
 		<input type="hidden" name ="tipoConsulta" value ='<%=gerencFiltroBean.getTipoConsulta()%>'>
 		<input type="hidden" name ="data" value = '<%=gerencFiltroBean.getData() == null ? "" :gerencFiltroBean.getDataFormatada()%>'>
 		<input type="hidden" name ="mesAno" value = '<%=gerencFiltroBean.getMesAno() == null ? "" :gerencFiltroBean.getDataFormatada()%>'>
		<input type="hidden" name ="codigoUnidade" >
		<input type="hidden" name ="codigoCedente" >
		<input type="hidden" name ="consolidado" >
		<input type="hidden" name ="tipoData" value ='<%=gerencFiltroBean.getTipoData()%>'>
		<input type="hidden" name ="tpFiltro" value ='<%=gerencFiltroBean.getTpFiltro()%>'>		
		<input type="hidden" name="navegacao"	value ='<%=gerencFiltroBean.getNavegacao()%>'>		
		<input type="hidden" name="tipoRelatorio"	value='<%=gerencFiltroBean.getTipoRelatorio()%>'>
 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">

            <tr>
              <td nowrap class="textoTitulo" width="17%">Tipo de Data: </td>
              <td nowrap class="textoValor" width="26%"><%=gerencFiltroBean.getTipoDataTexto()%></td>
              <td nowrap class="textoTitulo" width="17%">Data: </td>
              <td nowrap class="textoValor" width="26%"><%=gerencFiltroBean.getDataFormatada()%></td>
            </tr>
            <tr>
              <td nowrap class="textoTitulo" width="17%">Tipo de Consulta: </td>
              <td nowrap class="textoValor" width="26%"><%=gerencFiltroBean.getTipoConsultaTexto()%></td>
              <td nowrap class="textoTitulo" width="17%">Relatório: </td>
              <td nowrap class="textoValor" width="26%"><%=gerencFiltroBean.getTpFiltroTexto()%></td>
            </tr>
<s:Visibility visible="<%=!caixa%>">							
            <tr>
						<%if(pv){%>
              <td nowrap class="textoTitulo" width="17%">Unidade PV: </td>
						<%}else if (en){%>
              <td nowrap class="textoTitulo" width="17%">Unidade SR: </td><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
            <%}%>
              <td nowrap class="textoValor" width="26%"><%=gerencFiltroBean.getCodigoUnidadeFormatado()%></td>
              <td nowrap class="textoTitulo" width="17%">Nome Unidade: </td>
              <td nowrap class="textoValor" width="26%"><%=gerencBean.getNomeUnidade()%></td>
            </tr>
</s:Visibility>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
<s:Visibility visible="<%=caixa%>">							
              <td colspan="5" class="textoTitulo">Unidades(SR):
</s:Visibility><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
<s:Visibility visible="<%=en%>">							
              <td colspan="5" class="textoTitulo">Unidades:
</s:Visibility>
<s:Visibility visible="<%=pv%>">							
              <td colspan="5" class="textoTitulo">Cedentes:
</s:Visibility>
                <hr>
              </td>
            </tr>
            
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td width="1%" align="center">&nbsp;</td>
<s:Visibility visible="<%=caixa%>">							
 								    <td nowrap width="10%" align="right">Unidade SR</td><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
								    <td nowrap width="89%" align="left">Nome Unidade</td>
</s:Visibility>
<s:Visibility visible="<%=en%>">							
 								    <td nowrap width="10%" align="right">Unidade PV</td>
								    <td nowrap width="89%" align="left">Nome</td>
</s:Visibility>
<s:Visibility visible="<%=pv%>">							
 								    <td nowrap width="10%" align="left">Cedente</td>
								    <td nowrap width="20%" align="left">Nome Cedente</td>
 								    <td nowrap width="10%" align="left">Tipo Pessoa</td>
								    <td nowrap width="20%" align="left">CPF/CNPJ</td>
								    <td nowrap width="30%" align="center">&nbsp;</td>
</s:Visibility>
								  </tr>
							<%
									GerencFiltroBean occ = new GerencFiltroBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (GerencFiltroBean) lista.get(i);
							%>	
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>


<s:Visibility visible="<%=pv%>">							
								    <td width="1%" align="center">
											<input type="radio" name="rad" 
										    onclick="javascript: clickRadio('<%=occ.getCodigoCedente()%>');">
								    </td>
 								    <td nowrap width="10%" align="right"><%=occ.getCodigoCedenteFormatado()%></td>
 								    <td nowrap width="20%" align="left"><%=occ.getNomeCedente()%></td>
 								    <td nowrap width="10%" align="left"><%=occ.getTipoPessoaTexto()%></td>
 								    <td nowrap width="20%" align="left"><%=occ.getCpfCnpjFormatado()%></td>
								    <td nowrap width="30%" align="center">&nbsp;</td>
</s:Visibility>
<s:Visibility visible="<%=!pv%>">							
								    <td width="1%" align="center">
											<input type="radio" name="rad" 
										    onclick="javascript: clickRadio('<%=occ.getCodigoUnidade()%>');">
								    </td>
										<td nowrap width="10%" align="right"><%=occ.getCodigoUnidadeFormatado()%></td>
 								    <td nowrap width="89%" align="left"><%=occ.getNomeUnidade()%></td>
</s:Visibility> 		
								    
								  </tr>
            <%}%>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="6" align="center">
											<s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=GerencEstrategia.PAGE_LISTAR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>

	                <tr>
	                  <td align="right" colspan="6">
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

	    function inicia(){
	    }

	  	function formSubmit() {
        if(validaSubmit()){   
		<%if(caixa){%>	
           document.frmMain.tipoConsulta.value='<%=GerencEstrategia.TIPO_CONSULTA_EN%>';
		<%}else if (en){%>
           document.frmMain.tipoConsulta.value='<%=GerencEstrategia.TIPO_CONSULTA_PV%>';
		<%}else if (pv){%>
           document.frmMain.tipoConsulta.value='<%=GerencEstrategia.TIPO_CONSULTA_CEDENTE%>';
		       document.frmMain.consolidado.value='<%=GerencEstrategia.CONSOLIDADO_SIM%>';
		<%}%>
           document.frmMain.submit();

        }
	    }  
	    
	    function formSubmit_Voltar() {
           	document.frmMain.fluxo.value = "voltar";
           	document.frmMain.submit();
      }  

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
		<%if(pv){%>	
			document.frmMain.codigoCedente.value = codigo;
		<%}else{%>
			document.frmMain.codigoUnidade.value = codigo;
		<%}%>
	  }
		</script>
  </s:FormStrategy>
</p:Document>
</html>