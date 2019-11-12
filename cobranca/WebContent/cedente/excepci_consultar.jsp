<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: excepci_consultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 17/09/2004
************************************************/
%>

<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.DadosListaExcepciBean"%> 
<%@page import="br.gov.caixa.sigcb.bean.ExcepcionacaoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.ExcepciManterEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.List"%>

<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

	CedenteCabecaBean cabecalhoBean  = (session.getAttribute(ExcepciManterEstrategia.CEDENTE_CABECALHO_BEAN)==null? 
																	    new CedenteCabecaBean():(CedenteCabecaBean)
																	    session.getAttribute(ExcepciManterEstrategia.CEDENTE_CABECALHO_BEAN));

	ExcepcionacaoBean excepciBean    = (session.getAttribute(ExcepciManterEstrategia.EXCEPCI_BEAN)==null? 
																	    new ExcepcionacaoBean():(ExcepcionacaoBean)
																	    session.getAttribute(ExcepciManterEstrategia.EXCEPCI_BEAN));

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
	
	
	/*NOTA*/
	/*Obtendo o usuário autorizador
	caso nao se tenha excepcionado a pendencia foi solicitado pela REDEA 
	que deveria aparecer o codigo do usuário que logou no sistema.*/
	
	String strUsuAutorizador = "";

 	if(excepciBean.getUsuarioAutorizador().equals("") || excepciBean.getUsuarioAutorizador().toString() == null){
 		strUsuAutorizador = excepciBean.getCodigoUsuario().toString();
 	}else{
  	strUsuAutorizador = excepciBean.getUsuarioAutorizador().toString();
  }
  //EAM 09/11/2005 - INI
	 String dataAutorizacao = "";
  if (excepciBean.getSituacaoPendencia().equals(new Long(2))){//2 - Não liberada
  	strUsuAutorizador = "";
  }else{
	  dataAutorizacao = excepciBean.getDataAutorizacaoFormatada();
	}
  //EAM 09/11/2005 - FIM
%>
<html>
  <s:Header/>  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.ExcepciManterFiltro" fluxo="normal">   	          				
   		<s:Menu/>
   		<s:Titulo name="Excepcionação de Pendência de Alçada >> Consultar"/>
   		
	  	<input type="hidden" name="<%=ExcepciManterEstrategia.PAGINACAO_PAGE%>" value="">
			<input type="hidden" name="codigoCedente" value="<%=excepciBean.getCodigoCedente()%>">
	  	<input type="hidden" name="numeroPendencia" value="<%=excepciBean.getNumeroPendencia()%>">
	  	<input type="hidden" name="numeroReiteracao" value="<%=excepciBean.getNumeroReiteracao()%>">
  		<input type="hidden" name="situacaoPendencia" value="<%=excepciBean.getSituacaoPendencia()%>">
  		<input type="hidden" name="dataPendencia"	value="<%=excepciBean.getDataPendenciaOrig()%>">
  		<input type="hidden" name="dataSituacao" value="<%=excepciBean.getDataSituacao()%>">
  		<input type="hidden" name="descSitPend" value="<%=excepciBean.getDescSituacaoPendencia()%>">
  		<input type="hidden" name="dataVigenciaDe" value="<%=excepciBean.getDataVigenciaDeFormatada()%>">
  		<input type="hidden" name="dataVigenciaAte" value="<%=excepciBean.getDataVigenciaAteFormatada()%>">
			<input type="hidden" name="autorizado" value="<%=filtroBean.getAutorizado()%>">  		

  		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
	      <tr> 
	        <td valign="top" width="95%" height="14" align="left"> 
	          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
		          <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getCodigoCedenteFormatado()%></td>
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
	            <td class="textoTitulo" width="17%">Perfil usuário Alçada: </td>
	            <td class="textoValor" width="26%"><%=excepciBean.getPerfilUsuarioAlcada()%></td>
	          </tr>
            <tr>
              <td class="textoTitulo" width="17%">Pendência: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getNumeroPendencia()%></td>
              <td class="textoTitulo" width="17%">Data Pendência: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getDataPendenciaOrig()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Situação Pendência: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getDescSituacaoPendencia()%></td>
              <td class="textoTitulo" width="17%">Data Situação</td>
              <td class="textoValor" width="26%"><%=excepciBean.getDataSituacao()%></td>
            </tr>
						<tr>
              <td class="textoTitulo" width="17%">Usuário Gerador: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getUsuarioGerador()%></td>
              <td class="textoTitulo" width="17%">Hora Geração: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getHoraGeracaoFormatada()%></td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Justificativa: </td>
              <td colspan="3" class="textoValor" width="26%"><%=excepciBean.getJustificativa()%></td>
						</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Reiteração:
                <hr>
              </td>
            </tr>
						<%//EAM - 09/11 INI linha da tabela retirada%>
						<%/*%<tr>
              <td class="textoTitulo" width="17%">Reiteração: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getNumeroReiteracao()%-></td>
              <td class="textoTitulo" width="17%">Data Reiteração: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getDataPendenciaOrig()%-></td>
						</tr>*/%>
						<tr>
              <td class="textoTitulo" width="17%">Usuário Autorizador: </td>
              <td class="textoValor" width="26%"><%=strUsuAutorizador%></td>
              <td class="textoTitulo" width="17%">Perfil Usuário Autorizador: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getPerfilUsuarioAut()%></td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Data Autorização: </td>
              <td class="textoValor" width="26%"><%=dataAutorizacao%></td> 
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
						</tr>													
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Informações de Resposta à Pendência:
                <hr>
              </td>
            </tr>
	            
						<tr>
              <td class="textoTitulo" width="17%">Data Início: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getDataVigenciaDeFormatada().equals("01/01/0001")?"":excepciBean.getDataVigenciaDeFormatada()%></td>
              <td class="textoTitulo" width="17%">Data Fim: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getDataVigenciaAteFormatada().equals("01/01/0001")?"":excepciBean.getDataVigenciaAteFormatada()%></td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Resposta: </td>
              <td class="textoValor" width="26%" colspan="3"><%=excepciBean.getResposta()%></td>
						</tr>
						

						
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Informações da alteração:
                <hr>
              </td>
            </tr>
            
            	            
						<tr>
              <td class="textoTitulo" width="17%">Usuário: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getUsuarioAlterador()%></td>
              <td class="textoTitulo" width="17%">Data Alteração: </td>
              <td class="textoValor" width="26%"><%=excepciBean.getDataAlterador()%></td>
						</tr>
            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								   <tr class="headerLista">
								    <td width="1%" align="left">&nbsp;</td>
 								    <td nowrap width="50%" align="left">&nbsp;</td>
								    <td nowrap width="30%" align="center" colspan="2">Conteúdo</td>
 								    <td nowrap width="20%" align="left">&nbsp;</td>
								    <td width="1%" align="left">&nbsp;</td>
								  </tr>
								  <tr class="headerLista">
								    <td width="1%" align="left">&nbsp;</td>
 								    <td nowrap width="50%" align="left">Descrição</td>
								    <td nowrap width="15%" align="left">Anterior</td>
 								    <td nowrap width="15%" align="left">Negociado</td>
 								    <td nowrap width="20%" align="left">Parecer</td>
 								    <td width="1%" align="left">&nbsp;</td>
								  </tr>
							<%
								ExcepcionacaoBean occ = new ExcepcionacaoBean();
								for ( int i = 0; i < lista.size(); i++ ) {	
									occ = (ExcepcionacaoBean) lista.get(i);
						  %>	  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td width="1%" align="left">&nbsp;</td>
 								    <td nowrap width="50%" align="left"><%=occ.getDescrItemExcep()%></td>
								    <td nowrap width="15%" align="left"><%=occ.getConteudoAnteriorFormatado()%></td>
 								    <td nowrap width="15%" align="left"><%=occ.getConteudoNegociadoFormatado()%></td>
 								    <td nowrap width="20%" align="left"><%=occ.getDescParecer()%></td>
								    <td width="1%" align="left">&nbsp;</td>
								  </tr> 
							<%}%>	
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="6" align="center">
											<% String pageName = ExcepciManterEstrategia.PAGE_CONSULTAR;%>
										  <s:ButtonPaginar 
										  		pageNumber="<%=paginacao.getPageNumber()%>" 
										  		numberOfPages="<%=paginacao.getPageCount()%>" 
										  		pageName="<%=pageName%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
	              </table>
              </td>
            </tr>

            <tr>
              <td align="right" colspan="6">
                <p align="center"> 
                  <s:Button name="Resp. Pendencia" action="javascript:formSubmit_ResponderPend();"userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.excepcionacao.acoes"/>
	                <s:Button name="Alterar Data Vigencia" action="javascript:formSubmit_AlterarDataVig();"userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.excepcionacao.acoes"/>
	                <s:Button name="Excluir Agendamento" action="javascript:formSubmit_ExcluirAge();"userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="cedente.excepcionacao.acoes"/>
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
			
	    function formSubmit_ResponderPend(){
		    if(document.frmMain.autorizado.value != "S"){
		    	msg('066');
		    	return false;
		    }
	     if("<%=excepciBean.getDescSituacaoPendencia()%>" == "NAO LIBERADA"){
	    		document.frmMain.estrategia.value = "cedente.ExcepciAcaoResponderIniciar";
	      	document.frmMain.submit();
	      }else{
	      	msg('021', '',"<%=excepciBean.getDescSituacaoPendencia()%>" , '');
	      }
	    }
	    
	    function formSubmit_AlterarDataVig(){
		    if(document.frmMain.autorizado.value != "S"){
		    	msg('066');
		    	return false;
		    }
	    	if("<%=excepciBean.getDescSituacaoPendencia()%>" == "LIBERADA"){
	    		document.frmMain.estrategia.value = "cedente.ExcepciAcaoAlterarDataIniciar";
	        document.frmMain.submit();
	      }else{
	      	msg('022', '',"<%=excepciBean.getDescSituacaoPendencia()%>" , '');
	      }
	    }
	    
	    function formSubmit_ExcluirAge(){
		    if(document.frmMain.autorizado.value != "S"){
		    	msg('066');
		    	return false;
		    }
	    	if("<%=excepciBean.getDescSituacaoPendencia()%>" == "AGENDADA"){
	    		if(confirm(conf('102', 'Agendamento'))){
		    		document.frmMain.estrategia.value = "cedente.ExcepciAcaoExcluiAgendFinalizar";
		        document.frmMain.submit();
		      }
	      }else{
	      	msg('023', '',"<%=excepciBean.getDescSituacaoPendencia()%>", '');
	      }
	    }
   
	    function formSubmit_Voltar() {
  			document.frmMain.estrategia.value = "cedente.ExcepciManterFiltro";
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
	    }
	    
	    function formSubmit(){}
	    </script>
    </s:FormStrategy>
	</p:Document>
</html>