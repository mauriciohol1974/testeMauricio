<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: pvcob_manter_listar.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 13/10/2004 16:07
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.PvCobradorBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.PvCobEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.com.politec.sao.util.Formatacao"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");

	PvCobradorBean pvBean = (session.getAttribute(PvCobEstrategia.DATA_BEAN)==null?new PvCobradorBean():(PvCobradorBean)session.getAttribute(PvCobEstrategia.DATA_BEAN));
	if (pvBean.getAcao()==null) pvBean.setAcao("UNIDADE");
	
	PageHolder paginacao = (PageHolder) session.getAttribute(PvCobEstrategia.PAGINACAO_LIST);

	int paginaAtual = 0;
	if(request.getParameter(PvCobEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(PvCobEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(PvCobEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(PvCobEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
	String tmp="";	
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=PvCobEstrategia.STRATEGY_ALTERAR%>" fluxo="normal" saibamais='<%=pvBean.getAcao().equals("UNIDADE")? "":"parametro/pvcob_manter_listar_cep.html"%>'>
		<s:Menu/>
		<s:Titulo name="Manter PV Cobrador >> Listar"/>
		<input type="hidden" name = "codigoUnidadePV" value="">
		<input type="hidden" name = "codigoUnidadeCentral" value="">
		<input type="hidden" name = "estado" value="">
		<input type="hidden" name = "codUnidPVInicial" value="<%=pvBean.getCodUnidPVInicial()%>">
		<input type="hidden" name = "codUnidPVFinal" value="<%=pvBean.getCodUnidPVFinal()%>">
		<input type="hidden" name = "numeroCEPde" value="<%=pvBean.getNumeroCEPde()%>">
		<input type="hidden" name = "numeroCEPate" value="<%=pvBean.getNumeroCEPate()%>">
		<input type="hidden" name = "acao" value="<%=pvBean.getAcao()%>">
		
		<input type="hidden" name = "<%=PvCobEstrategia.PAGINACAO_PAGE%>" value="">
		<input type="hidden" name = "<%=PvCobEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
          <% if (pvBean.getAcao().equals("UNIDADE")) { %>
	          <tr>
     			     <td class="textoTitulo" width="17%">Unidade PV De: </td>
	             <td class="textoValor" width="26%"><%=pvBean.getCodUnidPVInicialFormatado()%></td>
   			       <td class="textoTitulo" width="17%">Até: </td>
         			 <td class="textoValor" width="26%"><%=pvBean.getCodUnidPVFinalFormatado()%></td> 
	          </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Unidades:
                <hr>
              </td>
            </tr>
						<tr>
							<td colspan="4"> 
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="10%" align="left"><div align="right">Unidade PV</div></td>
								    <td nowrap width="7%" align="left">Apelido</td>
 								    <td nowrap width="30%" align="left">Nome Unidade</td>
 								    <td nowrap width="7%" align="left">Padrão</td>
 								    <td nowrap width="14%" align="left"><div align="right">Num. Remessa</div></td>
 								    <td nowrap width="8%" align="left"><div align="right">Qtd. Reg.</div></td>
 								    <td nowrap width="12%" align="left"><div align="center">Data Remessa</div></td>
 								    <td nowrap width="8%" align="left">Situação</td>
 								    <td nowrap align="left">Centralizadora</td>
								  </tr>            
									<%
									PvCobradorBean occ = new PvCobradorBean();

									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (PvCobradorBean) lista.get(i);
										%>								  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									    	<input type="radio" name="rdo"
									    		onclick="javascript: clickRadio('<%=occ.getCodigoUnidadePV()%>','<%=occ.getSituacao()%>','<%=occ.getCodigoUnidadeCentral()%>');">
									    </td>
	 								    <td width="10%" align="right"><%=occ.getCodigoUnidadePVFormatado()%></td>
									    <td width="7%" align="left"><%=occ.getApelido()%></td>
	 								    <td width="30%" align="left"><%=occ.getNomeUnidadePV()%></td>
	 								    <%tmp = ((occ.getPadraoCNAB().longValue()+"").equals("1")) ? "CNAB400":(((occ.getPadraoCNAB().longValue()+"").equals("2")) ? "CNAB600":""); %>
	 								    <td width="7%" align="left"><%=tmp%></td>
	 								    <td width="14%" align="right"><%=occ.getNumeroUltimaRemessa().longValue()==0 ?  "": occ.getNumeroUltimaRemessa().toString()%></td>
	 								    <td width="8%" align="right"><%=occ.getQntdRegistrosUltRemessa().longValue()==0 ?  "": occ.getQntdRegistrosUltRemessa().toString()%></td>
	 								    <td width="12%" align="center"><%=occ.getDataUltimaRemessa()==null || Formatador.formatarData(occ.getDataUltimaRemessa()).equals("01/01/0001")? "" : Formatador.formatarData(occ.getDataUltimaRemessa())%></td>
	 								    <%tmp = (occ.getSituacao().equals("A")) ? "Ativa":((occ.getSituacao().equals("I")) ? "Inativa":""); %>
	 								    <td width="8%" align="left"><%=tmp%></td>
	 								    <td align="right"><%=occ.getCodigoUnidadeCentralFormatado()%></td>
									  </tr>	
									<%  } %>								  						  
								</table>
							</td>
						</tr>
          <%} else { %>
	          <tr>
     			     <td class="textoTitulo" width="17%">Cep De: </td>
	             <td class="textoValor" width="26%"><%=Formatacao.formataCep(pvBean.getNumeroCEPde())%></td>
   			       <td class="textoTitulo" width="17%">Até: </td>
         			 <td class="textoValor" width="26%"><%=Formatacao.formataCep(pvBean.getNumeroCEPate())%></td> 
	          </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Lista de CEPs por PV Cobrador:
                <hr>
              </td>
            </tr>
						<tr>
							<td colspan="4"> 
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								  	<td nowrap width= "2%" align="left">&nbsp;</td>
 								    <td nowrap width="15%" align="left">Cep Inicial</td>
								    <td nowrap width="15%" align="left">Cep Final</td>
 								    <td nowrap width="10%" align="left">UF</td>
 								    <td nowrap width="10%" align="left"><div align="right">Unidade PV</div></td>
								    <td nowrap width="40%" align="left">Nome Unidade</td>
 								    <td nowrap width="10%" align="left">Situação</td>
 								    <td nowrap align="left">Centralizadora</td>								    
								  </tr>	
									<%
									PvCobradorBean occ = new PvCobradorBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (PvCobradorBean) lista.get(i);
										%>								  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									    	<input type="radio" name="rdo"
									    		onclick="javascript: clickRadio('<%=occ.getCodigoUnidadePV()%>','<%=occ.getSituacao()%>','<%=occ.getCodigoUnidadeCentral()%>');">
									    </td>
	 								    <td width="15%" align="left"><%=Formatacao.formataCep(occ.getNumeroCEPde())%></td>
									    <td width="15%" align="left"><%=Formatacao.formataCep(occ.getNumeroCEPate())%></td>
	 								    <td width="10%" align="left"><%=occ.getUf()%></td>									    
	 								    <td width="10%" align="right"><%=occ.getCodigoUnidadePVFormatado()%></td>
	 								    <td width="40%" align="left"><%=occ.getNomeUnidadePV()%></td>
	 								    <%tmp = (occ.getSituacao().equals("A")) ? "Ativa":((occ.getSituacao().equals("I")) ? "Inativa":""); %>
	 								    <td width="10%" align="left"><%=tmp%></td>
	 								    <td align="right"><%=occ.getCodigoUnidadeCentralFormatado()%></td>
									  </tr>	
									<%  } %>								  
								</table>
							</td>
						</tr>									
          <% } %>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
						<tr>
							<td colspan="4" align="center">
							  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=Paths.getRootForDynamicContent() + PvCobEstrategia.PAGE_MANTER_LISTAR%>"/>
							</td>
						</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center"> 
                	<s:Button name="Alterar" action="javascript: formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="parametro.pvcobrador.manter.alterar"/>
                	<s:Button name="Consultar" action="javascript: formSubmit_Consultar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="parametro.pvcobrador.manter.consultar"/>
                	<s:Button name="Excluir" action="javascript: formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="parametro.pvcobrador.manter.excluir" />
                	<s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
                </p>
              </td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    <script>
			function inicia() {
				setFirstFieldFocus();
			}
			function formSubmit_Alterar() {
				formSubmit();
			}
	    function formSubmit() { // Acao default alterar
        if (validaSubmit()) {
	        document.frmMain.submit();
        }
			}
			function validaSubmit() {
			<%if(paginacao.getCurrentPageSize() > 1){%>
		    if(!validaRadioButton(document.frmMain.rdo, '')){
				  return false;
		    }
			<%} else {%>
				if(! document.frmMain.rdo.checked){
					msg('003', '');
					return;
				}
			<%}%>
		    return true;
		  }
		  
			function formSubmit_Excluir() {
        if (validaSubmit()) {
        	if (document.frmMain.estado.value !="A") {
        		msg('026','');
        		return false;
        	}
        	
	    		if (confirm(conf("102", "PV Cobrador"))) {
						document.frmMain.estrategia.value = "<%=PvCobEstrategia.STRATEGY_EXCLUIR%>";
	          document.frmMain.submit();
         	}
	      }
			}
			
			function formSubmit_Voltar() {
        document.frmMain.estrategia.value = "<%=PvCobEstrategia.STRATEGY_MANTER_FILTRO%>";
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
      }
      function clickRadio(codPV, estado, codCentral) {
				document.frmMain.codigoUnidadePV.value = codPV;
				document.frmMain.codigoUnidadeCentral.value = codCentral;
				document.frmMain.estado.value = estado;
      }
			//EAM - 13/10/2005
			function formSubmit_Consultar() {
        if (validaSubmit()) {
        	document.frmMain.estrategia.value = "<%=PvCobEstrategia.STRATEGY_CONSULTAR%>";
	        document.frmMain.submit();
	      }
      }

    </script>
  </s:FormStrategy>
</p:Document>
</html>