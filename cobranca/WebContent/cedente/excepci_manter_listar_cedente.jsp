<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: excepci_manter_listar_cedente.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 30/08/2004
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.DadosListaExcepciBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.ExcepciManterEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>

<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);
	
	DadosListaExcepciBean codCedBean = (session.getAttribute(ExcepciManterEstrategia.FIXO_BEAN)==null? 
																		      new DadosListaExcepciBean():(DadosListaExcepciBean)
																		      session.getAttribute(ExcepciManterEstrategia.FIXO_BEAN));

  CedenteCabecaBean cabecalhoBean 		= (session.getAttribute(ExcepciManterEstrategia.CEDENTE_CABECALHO_BEAN)==null? 
																		      new CedenteCabecaBean():(CedenteCabecaBean)
																		      session.getAttribute(ExcepciManterEstrategia.CEDENTE_CABECALHO_BEAN));

  DadosListaExcepciBean filtroBean 		= (session.getAttribute(ExcepciManterEstrategia.FILTRO_BEAN)==null? 
																		      new DadosListaExcepciBean():(DadosListaExcepciBean)
																		      session.getAttribute(ExcepciManterEstrategia.FILTRO_BEAN));

	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ExcepciManterEstrategia.PAGINACAO_LIST);
	if(request.getParameter(ExcepciManterEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ExcepciManterEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ExcepciManterEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ExcepciManterEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);
	
%>

<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.ExcepciManterFiltro" fluxo="normal">   	          				
   		<s:Menu/>
   		<s:Titulo name="Excepcionação de Pendência de Alçada >> Listar"/>
   		
	  	<input type="hidden" name="<%=ExcepciManterEstrategia.PAGINACAO_PAGE%>" value="">
  		<input type="hidden" name="numeroPendencia"	value="">
  		<input type="hidden" name="numeroReiteracao" value="0">
  		<input type="hidden" name="situacaoPendencia" value="">
  		<input type="hidden" name="codigoCedente" value="<%=codCedBean.getCodigoCedente()%>">
  		<input type="hidden" name="estrategiaVoltar" value="cedente.ExcepciManterFiltro">
  		<input type="hidden" name="tpConsultaEstrategia" value="<%=filtroBean.getTpConsultaEstrategia()%>">
  		<input type="hidden" name="dataPendencia"	value="">
  		<input type="hidden" name="dataSituacao" value="">
  		<input type="hidden" name="descSitPend" value="">
  		<input type="hidden" name="dataVigenciaDe" value="">
  		<input type="hidden" name="dataVigenciaAte" value="">
  		<input type="hidden" name="autorizado" value="">
  		
  		
  		    	
				<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
	            <tr>
	              <td class="textoTitulo" width="17%">Cedente: </td>
	              <td class="textoValor" width="26%"><%=codCedBean.getCodigoCedenteFormatado()%></td>
	              <td class="textoTitulo" width="17%">Nome Cedente: </td>
	              <td class="textoValor" width="26%"><%=cabecalhoBean.getNomeFantasia()%></td>
	            </tr>
	            <tr>
	              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
	              <td class="textoValor" width="26%"><%=cabecalhoBean.getTipoPessoaTexto()%></td>
	              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
	              <td class="textoValor" width="26%"><%=cabecalhoBean.getCpfCnpjFormatado()%></td>
	            </tr>
	            <tr>
	              <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
	              <td class="textoValor" width="26%"><%=cabecalhoBean.getCodigoClienteCOCLI()%></td> 
	              <td class="textoTitulo" width="17%">&nbsp;</td>
	              <td class="textoValor" width="26%">&nbsp;</td>
	            </tr>	            
	            <tr> 
	              <td colspan="4">&nbsp;</td>
	            </tr>
	            <tr valign="top"> 
	              <td colspan="5" class="textoTitulo">Pendências:
	                <hr>
	              </td>
	            </tr>
							<tr>
								<td colspan="4">
									<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
									  <tr class="headerLista">
									    <td nowrap width="2%" align="center">&nbsp;</td>
	 								    <td nowrap width="12%" align="right">Pendência</td>
									    <td nowrap width="14%" align="center">Data Pendência</td>
									    <td nowrap width="15%" align="left">Situação Pendência</td>
									    <td nowrap width="14%" align="center">Data Situação</td>
									    <td nowrap width="14%" align="center">Data Vigência DE</td>
									    <td nowrap width="14%" align="center">Data Vigência ATÉ</td>
									    <td nowrap width="11%" align="left">Perfil Usuário Autorizador</td>
									  </tr>
									  
							<%
									DadosListaExcepciBean occ = new DadosListaExcepciBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (DadosListaExcepciBean) lista.get(i);
							%>
									  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="2%" align="center">
									      <input type="radio" name="rdo"
								    		  onclick="javascript: clickRadio('<%=occ.getNumeroPendencia()%>','<%=occ.getDataPendenciaFormatada()%>','<%=occ.getSituacaoPendencia()%>','<%=occ.getDataSituacaoFormatada()%>','<%=occ.getDescSituacaoPendencia()%>','<%=occ.getDataVigenciaDeFormatada()%>','<%=occ.getDataVigenciaAteFormatada()%>','<%=occ.getAutorizado()%>')";>
								    	</td>
	 								    <td width="12%" align="right"><%=occ.getNumeroPendencia()%></td>
	 								    <td width="14%" align="center"><%=occ.getDataPendenciaFormatada()%></td>
	 								    <td width="15%" align="left"><%=occ.getDescSituacaoPendencia()%></td>
	 								    <td width="14%" align="center"><%=occ.getDataSituacaoFormatada()%></td>
	 								    <td width="14%" align="center"><%=occ.getDataVigenciaDeFormatada().equals("01/01/0001")?"":occ.getDataVigenciaDeFormatada()%></td>
	 								    <td width="14%" align="center"><%=occ.getDataVigenciaAteFormatada().equals("01/01/0001")?"":occ.getDataVigenciaAteFormatada()%></td>
									    <td width="11%" align="left"><%=occ.getCargoAutorizador()%></td>
									  </tr>
						 <%  } %>	  
	 	                <tr> 
		                  <td colspan="9">&nbsp;</td>
		                </tr>
										<tr>
											<td colspan="9" align="center">
											<% String pageName = ExcepciManterEstrategia.PAGE_LISTAR_CEDENTE_NUMPED;%>
											  <s:ButtonPaginar 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=pageName%>"/>
											  		
											</td>
											
										</tr>
	 	                <tr> 
		                  <td colspan="9">&nbsp;</td>
		                </tr>
		                <tr>
		                  <td align="right" colspan="9">
		                    <p align="center"> 	                      
		                      <s:Button name="Resp. Pendencia" action="javascript:formSubmit_ResponderPend();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.excepcionacao.acoes"/>
		                      <s:Button name="Alterar Data Vigencia" action="javascript:formSubmit_AlterarDataVig();"userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.excepcionacao.acoes"/>
		                      <s:Button name="Excluir Agendamento" action="javascript:formSubmit_ExcluirAge();"userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.excepcionacao.acoes"/>
		                      <s:Button name="Consultar Detalhes" action="javascript:formSubmit_Consultar();"userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.excepcionacao.consultar"/>
		                      <s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
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
	    function inicia() {
				setFirstFieldFocus();
			}
			
	    function formSubmit_ResponderPend(){	
	    	if (validaSubmit()) {
	    		
			    if(document.frmMain.autorizado.value != "S"){
			    	msg('066');
			    	return false;
			    }
			    if(document.frmMain.descSitPend.value == "NAO LIBERADA"){
		    		document.frmMain.estrategia.value = "cedente.ExcepciAcaoResponderIniciar";
		      	document.frmMain.submit();
		      }else{
		      	msg('021', '',document.frmMain.descSitPend.value , '');
	  	    }
	  	  }
	    }
	    
	    function formSubmit_AlterarDataVig(){
	    	if (validaSubmit()) {
			    if(document.frmMain.autorizado.value != "S"){
			    	msg('066');
			    	return false;
			    }
		    	if(document.frmMain.descSitPend.value == "LIBERADA"){
	    			document.frmMain.estrategia.value = "cedente.ExcepciAcaoAlterarDataIniciar";
	        	document.frmMain.submit();	
	      	}else{
	      		msg('022', '',document.frmMain.descSitPend.value , '');
	      	}
	      }
	    }
	    
	    function formSubmit_ExcluirAge(){
	    	if (validaSubmit()) {
			    if(document.frmMain.autorizado.value != "S"){
			    	msg('066');
			    	return false;
			    }
	    		if(document.frmMain.descSitPend.value == "AGENDADA"){
	    			if(confirm(conf('102', 'Agendamento'))){
	    				document.frmMain.estrategia.value = "cedente.ExcepciAcaoExcluiAgendFinalizar";
	        		document.frmMain.submit();
	        	}
	      	}else{
	      		msg('023', '',document.frmMain.descSitPend.value , '');
	      	}	
	      }
	    }
	    
	    function formSubmit_Consultar(){
	    	if (validaSubmit()) {
	    		document.frmMain.estrategia.value = "cedente.ExcepciConsultarIniciar";
	        document.frmMain.submit();
        }
	    }
	    
	    function formSubmit_Voltar() {
//  			document.frmMain.estrategia.value = "cedente.ExcepciManterIniciar";
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
	    }	    
	    
	    function formSubmit(){}
	    
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
		  
		  function clickRadio(numeroPendencia, dtPendencia, situacaoPendencia, dtSituacao, descSitPend, dtDe, dtAte,autorizado) {
		  	document.frmMain.numeroPendencia.value = numeroPendencia;
		  	document.frmMain.dataPendencia.value = dtPendencia;
		  	document.frmMain.situacaoPendencia.value = situacaoPendencia;
		  	document.frmMain.dataSituacao.value	= dtSituacao;		  	
		  	document.frmMain.descSitPend.value = descSitPend;
		  	//document.frmMain.numeroReiteracao.value = numReiteracao;
		  	document.frmMain.dataVigenciaDe.value = dtDe;
		  	document.frmMain.dataVigenciaAte.value = dtAte;
		  	//document.frmMain.autorizado.value = autorizado;
		  	document.frmMain.autorizado.value = "S";
     	}
		  
 	    </script>
		</s:FormStrategy>
	</p:Document>
</html>