<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.GerencFiltroBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.GerencEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
/***************************************
************INICIO CABEÇALHO************
***************************************/

CedenteCabecaBean cedCabBean = (session.getAttribute(GerencEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(GerencEstrategia.CEDENTE_CABECALHO_BEAN));	
GerencFiltroBean gerencFiltroBean = (session.getAttribute(GerencEstrategia.BEAN_FILTRO)==null?new GerencFiltroBean():(GerencFiltroBean)session.getAttribute(GerencEstrategia.BEAN_FILTRO));

boolean cedente = gerencFiltroBean.getTipoConsulta().equals(GerencEstrategia.TIPO_CONSULTA_CEDENTE);
boolean pv = gerencFiltroBean.getTipoConsulta().equals(GerencEstrategia.TIPO_CONSULTA_PV);
boolean en = gerencFiltroBean.getTipoConsulta().equals(GerencEstrategia.TIPO_CONSULTA_EN);
boolean caixa = gerencFiltroBean.getTipoConsulta().equals(GerencEstrategia.TIPO_CONSULTA_CAIXA);
%>            
            <tr>
              <td nowrap class="textoTitulo" width="17%">Tipo de Data: </td>
              <td nowrap class="textoValor" width="26%"><%=Util.toStr(gerencFiltroBean.getTipoDataTexto())%></td>
              <td nowrap class="textoTitulo" width="17%">Data: </td>
              <td nowrap class="textoValor" width="26%"><%=Util.toStr(gerencFiltroBean.getDataFormatada())%></td>
            </tr>
            <tr>
              <td nowrap class="textoTitulo" width="17%">Tipo de Consulta: </td>
              <td nowrap class="textoValor" width="26%"><%=Util.toStr(gerencFiltroBean.getTipoConsultaTexto())%></td>
              <td nowrap class="textoTitulo" width="17%">Relatório: </td>
              <td nowrap class="textoValor" width="26%"><%=Util.toStr(gerencFiltroBean.getTpFiltroTexto())%></td>
            </tr>
<s:Visibility visible="<%=pv || en%>">							
            <tr>
						<%if(pv){%>
              <td nowrap class="textoTitulo" width="17%">Unidade PV: </td>
						<%}else if (en){%>
              <td nowrap class="textoTitulo" width="17%">Unidade SR: </td><!-- AL 18/12/06 - Alterado de EN p/ SR / Capuano -->
            <%}%>
              <td nowrap class="textoValor" width="26%"><%=gerencFiltroBean.getCodigoUnidadeFormatado()%></td>
              <td nowrap class="textoTitulo" width="17%">Nome Unidade: </td>
              <td nowrap class="textoValor" width="26%"><%=Util.toStr(gerencFiltroBean.getNomeUnidade())%></td>
            </tr>
</s:Visibility>
<s:Visibility visible="<%=cedente%>">							
            <tr>
              <td nowrap class="textoTitulo" width="17%">Cedente: </td>
              <td nowrap class="textoValor" width="26%"><%=gerencFiltroBean.getCodigoCedenteFormatado()%></td>
    	        <td nowrap class="textoTitulo" width="17%">Nome Cedente: </td>
      	      <td nowrap class="textoValor" width="26%"><%=Util.toStr(cedCabBean.getNomeFantasia())%></td>
            </tr>
            <tr>
	          	<td nowrap class="textoTitulo" width="17%">Tipo de Pessoa: </td>
  	          <td nowrap class="textoValor" width="26%"><%=Util.toStr(cedCabBean.getTipoPessoaTexto())%></td> 
    	        <td nowrap class="textoTitulo" width="17%">CNPJ: </td>
      	      <td nowrap class="textoValor" width="26%"><%=Util.toStr(cedCabBean.getCpfCnpjFormatado())%></td>
            </tr>
            <tr>
	          	<td nowrap class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
  	          <td nowrap class="textoValor" width="26%"><%=Util.toStr(cedCabBean.getCodigoClienteCOCLI())%></td> 
              <td nowrap class="textoTitulo" width="17%">&nbsp;</td>
              <td nowrap class="textoValor" width="26%">&nbsp;</td>
            </tr>
</s:Visibility>
