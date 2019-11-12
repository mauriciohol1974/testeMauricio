<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servdia_consultar_lantarman.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 26/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServDiaEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean "%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	ConGerServicosSolicitadosBean cabeEXBean =(session.getAttribute(ServDiaEstrategia.BEAN_DATA)==null? new ConGerServicosSolicitadosBean()
																		:(ConGerServicosSolicitadosBean)session.getAttribute(ServDiaEstrategia.BEAN_DATA));
	
	CedenteCabecaBean cedCabBean = 	(session.getAttribute(ServDiaEstrategia.BEAN_CABECALHO)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(ServDiaEstrategia.BEAN_CABECALHO));
	
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ServDiaEstrategia.PAGINACAO_LIST);
	
	if(request.getParameter(ServDiaEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ServDiaEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ServDiaEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ServDiaEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
	
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=ServDiaEstrategia.STRATEGY_INICIAR%>" fluxo="voltar">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Serviços Solicitados no dia"/>
		
		<input type="hidden" name="<%=ServDiaEstrategia.PAGINACAO_PAGE%>" value="">
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="3" cellpadding="0" height=53 valign="middle" align="center">

            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedente().equals( new Long(0))?"":cedCabBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
	            <td class="textoTitulo" width="17%" valign="top">Código Cliente (COCLI): </td>
	            <td class="textoValor"  width="26%" valign="top"><%=cedCabBean.getCodigoClienteCOCLI().equals(new Long(0))? "":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
	            <td class="textoTitulo" width="17%" valign="top">Relatório:</td>
              <td class="textoValor"  width="26%" valign="top"><%=cabeEXBean.getNomeRelatorio()%></td>
	          </tr>

            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Consulta:
                <hr>
              </td>
            </tr>
        <%
						ConGerServicosSolicitadosBean occ = new ConGerServicosSolicitadosBean();
						for ( int i = 0; i < lista.size(); i++ ) {	
								occ = (ConGerServicosSolicitadosBean) lista.get(i);
				%>
						<tr>
							<td colspan="5">
								<div class="group">
			          <table width="98%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									<tr>
										<td colspan="5">
						          <table width="100%" border="0" cellspacing="1" cellpadding="1" valign="middle" align="left">            						
						            <tr>
						              <td nowrap class="textoTitulo" width="20%" align="left">Valor da Tarifa: </td>
						              <td nowrap class="textoValor"  width="30%" align="left"><%=occ.getValorTarifa()%></td>
						  						<td nowrap class="textoTitulo" width="20%" align="left" >Data Débito Tarifa: </td>
						              <td nowrap class="textoValor"  width="30%" align="left"><%=occ.getDataDebitoTarifaFormatada()%></td>
						           	</tr>
									 		</table>
									 	</td>
									</tr>
									<tr>
									  <td colspan="5">
							  			<table width="100%" border="0" cellspacing="1" cellpadding="0" valign="middle" align="left">
							    			<tr>
							       				<td class="textoTitulo" width="10%" align="left">Usuário: </td>
							       				<td class="textoValor"  width="90%" align="left" colspan="3"><%=occ.getCodigoUsuario()%></td>
							    			</tr>
							  			</table>
									  </td>
									</tr>
									<tr>
										<td colspan="5">
						          <table width="100%" border="0" cellspacing="1" cellpadding="0" valign="middle" align="left">
						          	<tr>
						  						<td class="textoTitulo" width="10%" align="left">Justificativa: </td>
						              <td class="textoValor"  width="90%" align="left" colspan="3"><%=occ.getJustificativa()%></td>
						            </tr>
						          </table>
						       	</td>
						      </tr>
								</table>
								</div>
							</td>
						</tr>
				<%  } %>            
             <tr> 
		 					 <td colspan="9">&nbsp;</td>
						 </tr>
							<tr>
								<td colspan="9" align="center">
						  		<s:ButtonPaginar 
							  				pageNumber="<%=paginacao.getPageNumber()%>" 
							  				numberOfPages="<%=paginacao.getPageCount()%>" 
							  				pageName="<%=ServDiaEstrategia.PAGE_LAN_TAR_MAN%>"/>
								</td>
						</tr>        
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
						<tr>
					  	<td align="right" colspan="4">
              	<p align="center"> 
	              	<s:Button name="Voltar" action="javascript:formSubmit()"/> 
								</p>
	            </td>
	          </tr>
          </table>
        </td>
      </tr>
    </table>
   <script>
	    function inicia() {
				setFirstFieldFocus();
			}
	    function formSubmit() {
        document.frmMain.submit();
	    }
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
