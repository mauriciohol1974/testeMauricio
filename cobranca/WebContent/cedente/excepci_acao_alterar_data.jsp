<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: excepci_acao_alterar_data.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 13/09/2004
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.ExcepcionacaoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.ExcepciManterEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="java.util.List"%>



<%
	CedenteCabecaBean cabecalhoBean  = (session.getAttribute(ExcepciManterEstrategia.CEDENTE_CABECALHO_BEAN)==null? 
																	    new CedenteCabecaBean():(CedenteCabecaBean)
																	    session.getAttribute(ExcepciManterEstrategia.CEDENTE_CABECALHO_BEAN));

	ExcepcionacaoBean excepciBean    = (session.getAttribute(ExcepciManterEstrategia.EXCEPCI_BEAN)==null? 
																	    new ExcepcionacaoBean():(ExcepcionacaoBean)
																	    session.getAttribute(ExcepciManterEstrategia.EXCEPCI_BEAN));

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
		<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.ExcepciAcaoAlterarDataFinalizar" fluxo="normal">
			<s:Menu/>
   		<s:Titulo name="Excepcionação de Pendência de Alçada >> Alterar Data de Vigência"/>
   		
	  	<input type="hidden" name="<%=ExcepciManterEstrategia.PAGINACAO_PAGE%>" value="">
	  	<input type="hidden" name="codigoCedente" value="<%=excepciBean.getCodigoCedente()%>">
	  	<input type="hidden" name="numeroPendencia" value="<%=excepciBean.getNumeroPendencia()%>">
	  	<input type="hidden" name="numeroReiteracao" value="<%=excepciBean.getNumeroReiteracao()%>">
	  	<input type="hidden" name="novaDataFim" value="">
  		   	          				
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
							<tr>
	              <td class="textoTitulo" width="17%">Reiteração: </td>
	              <td class="textoValor" width="26%"><%=excepciBean.getNumeroReiteracao()%></td>
	              <td class="textoTitulo" width="17%">Data Reiteração: </td>
	              <td class="textoValor" width="26%"><%=excepciBean.getDataPendenciaOrig()%></td>
							</tr>
							<tr>
	              <td class="textoTitulo" width="17%">Usuário Autorizador: </td>
	              <td class="textoValor" width="26%"><%=excepciBean.getUsuarioAutorizador()%></td>
	              <td class="textoTitulo" width="17%">Perfil usuário Autorizador: </td>
	              <td class="textoValor" width="26%"><%=excepciBean.getPerfilUsuarioAut()%></td>
							</tr>
							<tr>
	              <td class="textoTitulo" width="17%">Data Autorização: </td>
	              <td class="textoValor" width="26%"><%=excepciBean.getDataAutorizacaoFormatada()%></td> 
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
	              <td class="textoTitulo" width="17%">Data Início Original: </td>
	              <td class="textoValor" width="26%"><%=excepciBean.getDataVigenciaDeFormatada()%></td>
	              <td class="textoTitulo" width="17%">Data Fim Original: </td>
	              <td class="textoValor" width="26%"><%=excepciBean.getDataVigenciaAteFormatada()%></td>
							</tr>
							<tr>
	              <td class="textoTitulo" width="17%">&nbsp; </td>
	              <td class="textoValor" width="26%">&nbsp;</td>
	              <td class="textoTitulo" width="17%">Data Fim (nova): </td>
	              <td class="textoValor" width="26%">
	              	<p:InputDate name="txtNovaDataFim" CLASS="inputtext"
               	    onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>
	              </td>
							</tr>
							<tr>
	              <td class="textoTitulo" width="17%">Resposta: </td>
	              <td class="textoValor" width="26%" colspan="3><%=excepciBean.getResposta()%></td>
							</tr>
	            <tr> 
	              <td colspan="4">&nbsp;</td>
	            </tr>
	
							<tr>
								<td colspan="4">
									<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
									  <tr class="headerLista">
									    <td width="1%" align="left">&nbsp;</td>
	 								    <td width="50%" align="left">&nbsp;</td>
									    <td width="30%" align="center" colspan="2">Conteúdo</td>
	 								    <td width="20%" align="left">&nbsp;</td>
									    <td width="1%" align="left">&nbsp;</td>
									  </tr>
									  <tr class="headerLista">
									    <td width="1%" align="left">&nbsp;</td>
	 								    <td width="45%" align="left">Descrição</td>
									    <td width="15%" align="left">Anterior</td>
	 								    <td width="15%" align="left">Negociado</td>
	 								    <td width="20%" align="left">Parecer</td>
	 								    <td width="1%" align="left">&nbsp;</td>
									  </tr>
								<%
									ExcepcionacaoBean occ = new ExcepcionacaoBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ExcepcionacaoBean) lista.get(i);
							  %>	  
									  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
									    <td width="1%" align="left">&nbsp;</td>
	 								    <td width="50%" align="left" nowrap><%=occ.getDescrItemExcep()%></td>
									    <td width="15%" align="left" nowrap><%=occ.getConteudoAnteriorFormatado()%></td>
	 								    <td width="15%" align="left" nowrap><%=occ.getConteudoNegociadoFormatado()%></td>
	 								    <td width="20%" align="left" nowrap><%=occ.getDescParecer()%></td>
									    <td width="1%" align="left">&nbsp;</td>
									  </tr> 
								<%}%>	
	 	                <tr> 
		                  <td colspan="6">&nbsp;</td>
		                </tr>
										<tr>
											<td colspan="6" align="center">
											<% String pageName = ExcepciManterEstrategia.PAGE_ACAO_ALTERAR_DATA;%>
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
	              <td align="right" colspan="4">
	                <p align="center"> 
	                  <s:Button name="Confirmar" action="javascript:formSubmit();"/>
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
		    
		    function formSubmit() {
		    	
    			document.frmMain.novaDataFim.value = document.frmMain.txtNovaDataFim.value;
		    			
    			var strData = document.frmMain.novaDataFim.value;
   					if (strData.length < 10){
  						formataData(document.frmMain.novaDataFim);
	     				document.frmMain.Confirmar.focus();    	
      		}
		    
		    	if (validaCampoObrigatorio(document.frmMain.novaDataFim,'Data Fim')){
		    		if (validaData(document.frmMain.novaDataFim, "nova Data Fim")){   			
		    			
		    			var dataLimite = new String(AddDay('<%=excepciBean.getDataVigenciaDeFormatada()%>',2000));
		    			var dataFimOrg = "<%=excepciBean.getDataVigenciaAteFormatada()%>";
		    			var dataInicio = "<%=excepciBean.getDataVigenciaDeFormatada()%>";
		    			
		    			if (comparaDatas(dataLimite, document.frmMain.novaDataFim.value) >= 0 ){
								if (comparaDatas(document.frmMain.novaDataFim.value, dataInicio) >= 0){
									if (comparaDatas(document.frmMain.novaDataFim.value, dataFimOrg) != 0){
										if (confirm("Deseja realmente alterar esta Data de Vigência?")) {
					        		document.frmMain.submit();
					      		}	
									}else{
										msg('025','',dataLimite,'');
				    				document.frmMain.txtNovaDataFim.focus();
				    			}
								}else{
										msg('024','',dataLimite,'');
				    				document.frmMain.txtNovaDataFim.focus();
								}  		    				
		    			}else{
		    				msg('024','',dataLimite,'');
		    				document.frmMain.txtNovaDataFim.focus();
		    			}
		    		}else{
		    			msg('014','nova data fim','','');
		    			document.frmMain.txtNovaDataFim.focus();
		    		}
		    	}
			  }
			  
		  	function formSubmit_Voltar() {
		  		if(confirm(conf('128',''))){			
  					document.frmMain.estrategia.value = "cedente.ExcepciManterFiltro";
	        	document.frmMain.fluxo.value = "voltar";
    	    	document.frmMain.submit();  		
		  		}
    			document.frmMain.txtNovaDataFim.focus();
	    	}
	    	
	 	 	</script>   
		</s:FormStrategy>
	</p:Document>
</html>