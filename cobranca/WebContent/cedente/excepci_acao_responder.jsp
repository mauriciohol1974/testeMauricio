<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: excepci_acao_responder.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 15/09/2004
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
<%@page import="java.lang.Long"%>
<%@page import="java.util.List"%>

<%
	CedenteCabecaBean cabecalhoBean  = (session.getAttribute(ExcepciManterEstrategia.CEDENTE_CABECALHO_BEAN)==null? 
																	    new CedenteCabecaBean():(CedenteCabecaBean)
																	    session.getAttribute(ExcepciManterEstrategia.CEDENTE_CABECALHO_BEAN));
	
	ExcepcionacaoBean excepciBean    = (session.getAttribute(ExcepciManterEstrategia.EXCEPCI_BEAN)==null? 
																	    new ExcepcionacaoBean():(ExcepcionacaoBean)
																	    session.getAttribute(ExcepciManterEstrategia.EXCEPCI_BEAN));
  
  PageHolder paginacao = (PageHolder) session.getAttribute(ExcepciManterEstrategia.PAGINACAO_LIST);
  
	int paginaAnterior = 0;
	
	if(request.getParameter(ExcepciManterEstrategia.PAGINACAO_PAGEANTERIOR) != null && !request.getParameter(ExcepciManterEstrategia.PAGINACAO_PAGEANTERIOR).equals("")){
		paginaAnterior = Integer.parseInt((String)request.getParameter(ExcepciManterEstrategia.PAGINACAO_PAGEANTERIOR));
	} else {
		paginaAnterior = Integer.parseInt((String)request.getAttribute(ExcepciManterEstrategia.PAGINACAO_PAGEANTERIOR));
	}
	List listaAnterior = paginacao.getPage(paginaAnterior);
  
	String[] pareceres = null;
	if(request.getParameterValues("pareceres") != null && !request.getParameterValues("pareceres").equals("")){
		pareceres = (String[])request.getParameterValues("pareceres");
	}
	if (pareceres != null) {
		for (int i=0; i < pareceres.length; i++) {
			ExcepcionacaoBean bean = (ExcepcionacaoBean)listaAnterior.get(i);
			bean.setCodigoParecer(new Long(pareceres[i]));
		}
	}
	int paginaAtual = 0;
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
		
		<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.ExcepciAcaoResponderFinalizar" fluxo="normal">
			<s:Menu/>
   		<s:Titulo name="Excepcionação de Pendência de Alçada >> Responder Excepcionação"/>
   		
   		<input type="hidden" name="<%=ExcepciManterEstrategia.PAGINACAO_PAGE%>" value="">
   		<input type="hidden" name= "<%=ExcepciManterEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">
   		<input type="hidden" name="codigoCedente" value="<%=excepciBean.getCodigoCedente()%>">
      <input type="hidden" name="numeroPendencia" value="<%=excepciBean.getNumeroPendencia()%>">
      <input type="hidden" name="numeroReiteracao" value="<%=excepciBean.getNumeroReiteracao()%>">
      <input type="hidden" name="pAtual" value="<%=paginaAtual%>">
      <input type="hidden" name="dataVigenciaDe" value="">
      <input type="hidden" name="dataVigenciaAte" value="">
      <input type="hidden" name="resposta" value="<%=excepciBean.getResposta()%>">
   		
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
              	<%
              		/*
              		 * Solicitado para que apareça aqui o codigo do proprio usuário 
              	   * alteração feita dia 14/12/2004 solicitado pela REDEA/SP.
              	   */
              	%>
              <td class="textoValor" width="26%"><%=excepciBean.getCodigoUsuario()%></td>
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
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Dados para Liberação da Pendência:
                <hr>
              </td>
            </tr>
            <tr> 
	          	<td colspan="4">&nbsp;</td>
	          </tr>
						<tr>
              <td class="textoTitulo" width="17%">Data Início: </td>
              <%if (excepciBean.getDatavigenciaINI().trim().length()>0){ %>
              <td class="textoValor" width="26%">
					<%=excepciBean.getDatavigenciaINI()%>  
					<INPUT TYPE="hidden" NAME="dataInicio" value="<%=excepciBean.getDatavigenciaINI()%>" />             	    
              </td>
              <td class="textoTitulo" width="17%">Data Fim: </td>
              <td class="textoValor" width="26%">
              	<%=excepciBean.getDatavigenciaFIM()%>
             	<INPUT TYPE="hidden" NAME="dataFim" value="<%=excepciBean.getDatavigenciaFIM()%>" />
             	
              </td>

              <%}else {%>
              <td class="textoValor" width="26%">
              	<p:InputDate name="dataInicio" CLASS="inputtext" value="<%=excepciBean.getDatavigenciaINI()%>"  
             	    onFocus="javascript: prevFocus(this);"
                 	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataFim);"  />
              </td>
              <td class="textoTitulo" width="17%">Data Fim: </td>
              <td class="textoValor" width="26%">
              	<p:InputDate name="dataFim" CLASS="inputtext" value="<%=excepciBean.getDatavigenciaFIM()%>"
             	    onFocus="javascript: prevFocus(this);"
	              	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Editar);" />
              </td>
              
              <%} %>

						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Resposta: </td>
              <td class="textoValor" width="23%" colspan="3">
              	<p align="justify">
		            	<textarea name="textAreaResposta" cols="51" rows="4" class="textoValor" readonly><%=excepciBean.getResposta()%></textarea>		              
		              <s:Button name="Editar" action="javascript: editaMensagem();"/>
				       </p>
              </td>
            </tr>	
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Pareceres:
                <hr>
              </td>
            </tr>

						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
 								    <td width="3%" align="left">&nbsp;</td>
 								    <td width="46%" align="left">&nbsp;</td>
								    <td width="30%" align="center" colspan="2" >Conteúdo</td>
 								    <td width="20%" align="left">&nbsp;</td>
 								    <td width="1%" align="left">&nbsp;</td>
								  </tr>
								  <tr class="headerLista">
 								    <td width="3%" align="left">&nbsp;</td>
 								    <td width="46%" align="left">Descrição</td>
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
								    <td width="3%" align="center">&nbsp;</td>
 								    <td width="46%" align="left" nowrap><%=occ.getDescrItemExcep()%></td>
								    <td width="15%" align="left" nowrap><%=occ.getConteudoAnteriorFormatado()%></td>
 								    <td width="15%" align="left" nowrap><%=occ.getConteudoNegociadoFormatado()%></td>
 								    <td width="20%" align="left" nowrap>
	 								    <s:ComboParecer name="pareceres" selectedValue="<%=occ.getCodigoParecer().toString()%>"/>							      
										</td>
 								    <td width="1%" align="left">&nbsp;</td>
 								    	
								 <%}%> 
								  <tr> 
	                  <td colspan="6">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="6" align="center">
											<% String pageName = ExcepciManterEstrategia.PAGE_ACAO_RESPONDER;%>
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
                  <s:Button name="Confirmar" action="javascript:formSubmit_confirmar();"/>
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
     	
    	function inicia(){
				setFirstFieldFocus();
				document.frmMain.textAreaResposta.value = inserebarraEne(document.frmMain.resposta.value,50);
			}
			
			function formSubmit(){}
			
			function formSubmit_Voltar() {
				if(confirm(conf('128',''))){			
	 				document.frmMain.estrategia.value = "cedente.ExcepciManterFiltro";
  	     	document.frmMain.fluxo.value = "voltar";
    	   	document.frmMain.submit();
    	  }
	   	}
	   	
	   	function formSubmit_confirmar(){
	   		  <%if (excepciBean.getDatavigenciaINI().trim().length()>0){ %>
	   		  
			   		document.frmMain.resposta.value = removeBarraEne(document.frmMain.textAreaResposta.value, 50);					
					if(confirm("Caso haja pareceres marcados como'em aberto',serão automaticamente\nmarcados como 'Não Autorizados'. Deseja Continuar?")){
						document.frmMain.submit();
					}
	   		   
	   		  <%}else{%>
	
	   					if(validaDatas(document.frmMain.dataInicio,'Data Inicio',document.frmMain.dataVigenciaDe)){
							if(validaDatas(document.frmMain.dataFim,'Data Fim',document.frmMain.dataVigenciaAte)){
							document.frmMain.resposta.value = removeBarraEne(document.frmMain.textAreaResposta.value, 50);					
							if(confirm("Caso haja pareceres marcados como'em aberto',serão automaticamente\nmarcados como 'Não Autorizados'. Deseja Continuar?")){
								document.frmMain.submit();
							}
						}
					}						
	   		  
	   		  <%}%>
			
	   	}  
	   	
	   	function validaDatas(obj,nomeCampo,objHidden){
				if(validaCampoObrigatorio(obj, nomeCampo)){
					if (validaData(obj, nomeCampo)){
						
						objHidden.value = obj.value;
						var strData = objHidden.value;

      			if (strData.length < 10){
  						formataData(objHidden);
	      			document.frmMain.Ok.focus();    	
      			}
      			return true;
      			
					}else{
						msg('014',nomeCampo,'','');
	   				obj.focus();
					}
				}
				return false;
	   	}
	   
	   	
	   	
	   	
	   	function editaMensagem(){
	    	var obj = document.frmMain.textAreaResposta;
				var resposta = showModalDialog('<%=Paths.getRootForDynamicContent()%>/jump/edita_mensagem.jsp?linhas=4&colunas=50', obj.value, "dialogHeight:15; dialogWidth:23; center: yes; help:no; resizable:yes; scroll:yes; status:no");
				if (resposta != null){
					obj.value = resposta;
				}
	    } 	    	
    </script>
    </s:FormStrategy>
	</p:Document>
</html>