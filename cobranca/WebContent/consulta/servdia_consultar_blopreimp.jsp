<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servdia_consular_blopreimp.jsp - Java Server Pages
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
	ConGerServicosSolicitadosBean cabeEXBean = (ConGerServicosSolicitadosBean)session.getAttribute(ServDiaEstrategia.BEAN_DATA);
	
	CedenteCabecaBean cedCabBean 			=	(CedenteCabecaBean)session.getAttribute(ServDiaEstrategia.BEAN_CABECALHO);
	
	ConGerServicosSolicitadosBean dataBean 	= (session.getAttribute(ServDiaEstrategia.BEAN_DATA)==null? new ConGerServicosSolicitadosBean()
																		: (ConGerServicosSolicitadosBean)session.getAttribute(ServDiaEstrategia.BEAN_DATA));
	
	//o retorno deste recordset somente poderá ser até dois registros
	PageHolder paginacao = (PageHolder) session.getAttribute(ServDiaEstrategia.PAGINACAO_LIST);
	paginacao.setPageSize(2);	
	List lista = paginacao.getPage(0);	
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=ServDiaEstrategia.STRATEGY_INICIAR%>" fluxo="voltar">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Serviços Solicitados no dia"/>
 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getCodigoCedente().equals( new Long(0))?"":cedCabBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getNomeFantasia()%>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
	            <td class="textoTitulo" width="17%" valign="top">Código Cliente (COCLI): </td>
	            <td class="textoValor"  width="26%" valign="top"><%=cedCabBean.getCodigoClienteCOCLI().equals(new Long(0))? "":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
	            <td class="textoTitulo" width="17%" valign="top">Relatório:</td>
              <td class="textoValor"  width="26%" valign="top"><%=cabeEXBean.getNomeRelatorio()%></td>
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
								    <td nowrap width="1%"	 align="center">&nbsp;</td>								  
 								    <td nowrap width="10%" align="center">Data Solicitação</td>
 								    <td nowrap width="10%" align="center">Usuário</td> 								    
								    <td nowrap width="10%" align="right">Qtd. Boletos</td>
 								    <td nowrap width="18%" align="right">Nosso Número Inicial&nbsp;&nbsp;</td>
 								    <td nowrap width="15%" align="left">&nbsp;&nbsp;Modelo Boleto</td>
 								    <td nowrap width="10%" align="left">Tipo de Entrega</td>
 								    <td nowrap width="10%" align="left">Origem</td>
								    <td nowrap width="1%"	 align="center">&nbsp;</td>
								  </tr>
							<%
									ConGerServicosSolicitadosBean occ = new ConGerServicosSolicitadosBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ConGerServicosSolicitadosBean) lista.get(i);
							%>	  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="1%"	 align="center">&nbsp;</td>
 								    <td nowrap width="10%" align="center"><%=occ.getDataSolicitacaoFormatada()%></td>
 								    <td nowrap width="10%" align="center"><%=occ.getCodigoUsuario()%></td>
								    <td nowrap width="10%" align="right"><%=occ.getQuantidade()%></td>
 								    <td nowrap width="18%" align="right"><%=occ.getNossoNumeroInicialFormatado()%>&nbsp;&nbsp;</td>
 								    <td nowrap width="15%" align="left">&nbsp;&nbsp;<%=occ.getModelo()%></td>
 								    <td nowrap width="10%" align="left"><%=occ.getTipoEntrega()%></td>
 								    <td nowrap width="10%" align="left"><%=occ.getMeioEntrada()%></td>
 								    <td nowrap width="1%"	 align="center">&nbsp;</td>
								  </tr>
							<%  } %>								  
								</table>
							</td>
						</tr>            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
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
