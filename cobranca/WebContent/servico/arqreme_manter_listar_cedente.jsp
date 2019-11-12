<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: arqreme_manter_listar_ced.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 28/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.ArquivoRemessaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ArqRemeEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.UtilDatas"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN);

	ArquivoRemessaBean arqBeanFiltro = (session.getAttribute(ArqRemeEstrategia.FILTRO_BEAN)==null?new ArquivoRemessaBean():(ArquivoRemessaBean)session.getAttribute(ArqRemeEstrategia.FILTRO_BEAN));

	ArquivoRemessaBean arqBean = (session.getAttribute(ArqRemeEstrategia.DATA_BEAN)==null?new ArquivoRemessaBean():(ArquivoRemessaBean)session.getAttribute(ArqRemeEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(ArqRemeEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(ArqRemeEstrategia.CEDENTE_CABECALHO_BEAN));
	
	PageHolder paginacao = (PageHolder) session.getAttribute(ArqRemeEstrategia.PAGINACAO_LIST);

	int paginaAtual = 0;
	if(request.getParameter(ArqRemeEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ArqRemeEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ArqRemeEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ArqRemeEstrategia.PAGINACAO_PAGE));
	}
	List lista = paginacao.getPage(paginaAtual);	
	String tmp="";	
%>


<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="" fluxo="normal">
	<s:Menu/>
	<s:Titulo name="<%=ArqRemeEstrategia.PAGE_TITLE_MANTER_LISTAR_CED%>"/>
	<input type="hidden" name = "codigoCedente" value="<%=arqBean.getCodigoCedente()%>">
	<input type="hidden" name = "dataInicial" value=<%=Formatador.formatarData(arqBean.getDataInicial())%>>
	<input type="hidden" name = "dataFinal" value=<%=Formatador.formatarData(arqBean.getDataFinal())%>>		
	<input type="hidden" name = "opcaoConsulta" value="UNIDADE">	
	<input type="hidden" name = "codigoUnidadePV" value=<%=arqBean.getCodigoUnidadePV()+""%>>
	<input type="hidden" name = "codigoUnidadePV" value=<%=arqBean.getCodigoUnidadeCentral()%>>
	<input type="hidden" name = "escolha" value="">
	<input type="hidden" name = "tipoSolicitacao" value="">
	<input type="hidden" name = "tipoAcao" value="">
	<input type="hidden" name = "tipo" value="">
	<input type="hidden" name = "data" value="">
	<input type="hidden" name = "sit" value="">
	<input type="hidden" name = "consultaUnidade" value="">

 	
	<input type="hidden" name = "<%=ArqRemeEstrategia.PAGINACAO_PAGE%>" value="">
	<input type="hidden" name = "<%=ArqRemeEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 align="center">
	        <tr>
  				<td class="textoTitulo" width="17%">Unidade PV:</td>
	            <td class="textoValor" width="26%"><%=arqBean.getCodigoUnidadePVFormatado()%></td>
				<td class="textoTitulo" width="17%">Nome Unidade: </td>
		 		<td class="textoValor" width="26%"><%=arqBean.getNomeUnidadePV()%></td> 
			</tr>
	        <tr>
  				<td class="textoTitulo" width="17%">Cedente: </td>
	            <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
				<td class="textoTitulo" width="17%">Nome: </td>
		 		<td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
			</tr>
            <tr>
            	<td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
            	<td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 
            	<td class="textoTitulo" width="17%">CPF/CNPJ: </td>
            	<td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
            	<td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
            	<td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI().equals( new Long(0))?"":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
  				<td class="textoTitulo" width="17%">Apelido: </td>
	            <td class="textoValor" width="26%"><%=arqBean.getApelidoCedente()+""%></td>
	        </tr>
	        <tr>
  				<td class="textoTitulo" width="17%">Nro. próxima remessa:</td>
	            <td class="textoValor" width="26%"><%=arqBean.getNumeroProxRemessa()+""%></td>
				<td class="textoTitulo" width="17%">Nro. último retorno:</td>
		 		<td class="textoValor" width="26%"><%=arqBean.getNumeroUltRetorno()%></td> 
			</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Arquivos:
                <hr>
              </td>
            </tr>
            <tr>
              <td colspan="4">
                <div class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 align="center">
                    <tr> 
                      <td colspan="6">&nbsp;</td>
                    </tr>
		            <tr> 
		              <td class="textoTitulo" width="2%">
		                <input type="radio" name="comando" onclick="javascript: comandar('2','I');" disabled>
		              </td>
		              <td class="textoTitulo" width="40%">Redisponibilizar Arquivo Retorno</td>
		              <td class="textoValor" width="15%">&nbsp;</td>
		              <td class="textoTitulo" width="2%">
		                <input type="radio" name="comando" onclick="javascript: comandar('10','I');" disabled>
		              </td>
		              <td class="textoTitulo" width="35%">Excluir Arquivo Remessa</td>
		              <td class="textoValor" width="10%">&nbsp;</td>
					</tr>
		            <tr> 
		              <td class="textoTitulo" width="2%">
		                <input type="radio" name="comando" onclick="javascript: comandar('2','E');" disabled>
		              </td>
		              <td class="textoTitulo" width="40%">Cancelar Redisponibilização Arquivo Retorno</td>
		              <td class="textoValor" width="15%">&nbsp;</td>
		              <td class="textoTitulo" width="2%">
		                <input type="radio" name="comando" onclick="javascript: comandar('10','E');" disabled>
		              </td>
		              <td class="textoTitulo" width="35%">Cancelar Exclusão Arquivo Remessa</td>
		              <td class="textoTitulo" width="10%">&nbsp;</td>
					</tr>
		            <tr> 
                      <td colspan="6">&nbsp;</td>
                    </tr>
                  </table>
                </div>
              </td>
            </tr>
			<tr>
				<td colspan="4">
					<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center">
						<tr class="headerLista">
					    	<td nowrap width="3%" align="center">&nbsp;</td>
							<td nowrap width="10%" align="center">Data</td>
							<td nowrap width="10%" align="center">Hora</td>
 							<td nowrap width="10%" align="left">Tipo Arquivo</td>
 							<td nowrap width="10%" align="left">Padrão</td>
 							<td nowrap width="10%" align="left">Van</td>
 							<td nowrap width="22%" align="left">CPF/CNPJ</td>
 							<td nowrap width="5%" align="right">Nro Rem/Ret</td>
 							<td nowrap width="5%" align="right">Qtde Reg</td>
 							<td nowrap width="15%" align="left">Observações</td>
						</tr>            
						<%
						ArquivoRemessaBean occ = new ArquivoRemessaBean();
						for ( int i = 0; i < lista.size(); i++ ) {	
						occ = (ArquivoRemessaBean) lista.get(i);
						%>								  
					  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
					    <td width="3%" align="center">
				    		<input type="radio" name="rdo"
				    		onclick="javascript: clickRadio('<%=i%>','<%=occ.getSituacao() %>', '<%=occ.getTipoArquivo()%>','<%=occ.getDataArquivo()==null? "": Formatador.formatarData(occ.getDataArquivo())%>');">
						</td>
 						<td width="10%" align="center"><%=occ.getDataArquivo()==null? "": Formatador.formatarData(occ.getDataArquivo())%></td>
			    		<td width="10%" align="center"><%=occ.getHoraArquivo()%></td>
					    <td width="10%" align="left"><%=occ.getTipoArquivo().equals(new Long(1)) ? "REMESSA" : "RETORNO" %></td>
					    <td width="10%" align="left"><%= (occ.getPadrao().longValue()+"").equals("1") ? "CNAB240":(((occ.getPadrao().longValue()+"").equals("2")) ? "CNAB400":"")%></td>
					    <td width="10%" align="center"><%=occ.getDescricaoVAN()%></td>
					    <td width="10%" align="center"><%=occ.getCpfCnpj()%></td>
					    <td width="15%" align="right"><%=occ.getNumRemessaRetorno().longValue()==0 ?  "": occ.getNumRemessaRetorno().toString()%></td>
					    <td width="15%" align="right"><%=occ.getQuantidadeRegistros().longValue()==0 ?  "": occ.getQuantidadeRegistros().toString()%></td>
					    <td width="27%" align="left"><%=occ.getObservacao()%></td>
 					  </tr>	
					<% } %>								  						  
					</table>
				</td>
			</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
			<tr>
				<td colspan="4" align="center">
				  <s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=Paths.getRootForDynamicContent() + ArqRemeEstrategia.PAGE_MANTER_LISTAR_CED%>"/>
				</td>
			</tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                <p align="center"> 
	                <s:Button name="acao" value="Executar Ação" action="javascript: formSubmit_action();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.arqremessaretorno.arquivo.acoes" />
                	<s:Button name="consultar" value= "Consultar Remessa" action="javascript: formSubmit();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.arqremessaretorno.arquivo.consultar" />
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

	    function formSubmit_action() { 

				//EAM
		    //document.frmMain.estrategia.value = "<%=ArqRemeEstrategia.STRATEGY_MANTER_ACAO%>";
		    
		    //deve ser selecionado um comando
		    if(!validaRadioButton(document.frmMain.comando, 'comando')) {
				  return false;
		    }
				

		    
		    //ações sobre arquivo remessa devem ser realizadas com data = hoje
		    if (document.frmMain.tipoSolicitacao.value == "10" && document.frmMain.tipoAcao.value=="E") {
					if (compararDataHoje(document.frmMain.data.value, "!=")) {
						if (document.frmMain.tipoAcao.value=="E"){ 
							//EAM
							//alert ("Somente é possível excluir um Arquivo Remessa mesmo dia de recebimento");
							//msg("056");
							
						//}else{
							//EAM
							//alert ("Somente é possível cancelar a exclusão um Arquivo Remessa mesmo dia de recebimento");
							msg("057");
						
						}
						return false;
					}
		    }
		    situacao = document.frmMain.sit.value;
			//habilita os options de comando
			if (situacao =="0" || situacao =="8") {
				document.frmMain.tipoSolicitacao.value = "2";
				document.frmMain.tipoAcao.value = "I";
			} else if (situacao =="7") {
				document.frmMain.tipoSolicitacao.value = "2";
				document.frmMain.tipoAcao.value = "E";
			} else if (situacao =="1" || situacao =="3") {
				document.frmMain.tipoSolicitacao.value = "10";
				document.frmMain.tipoAcao.value = "I";
			} else if (situacao =="A") {
				document.frmMain.tipoSolicitacao.value = "10";
				document.frmMain.tipoAcao.value = "E";
			}		    	
				//EAM
				document.frmMain.estrategia.value = "<%=ArqRemeEstrategia.STRATEGY_MANTER_ACAO%>";        	
       	document.frmMain.submit();
		}

	    function formSubmit() { //acao default consultar
	    	if (validaSubmit()) {
					if (document.frmMain.tipo.value == "2") {//retorno
				  	//EAM
				  	//alert("Selecione um Arquivo Remessa.");
				   	msg("058");
				   	return false;
					}
					if (!(document.frmMain.sit.value == "2" || document.frmMain.sit.value == "3" || document.frmMain.sit.value == "5" || document.frmMain.sit.value == "6")) {
						//EAM
						//alert("Arquivo Remessa sem registro de erros.");
						msg("059");
						return false;	
					}    	
   					//EAM
	        	document.frmMain.estrategia.value = "<%=ArqRemeEstrategia.STRATEGY_MANTER_DETALHE%>"
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
		
		// Valida se pode fazer a consulta
		function validaConsultar() {
			if (situacao =="2" || situacao =="3" || situacao =="5" || situacao =="6") {
				return true;
			}
			return false;
		}

		function formSubmit_Voltar() {
			<%
			String returnPage;
			if (arqBeanFiltro.getCodigoUnidadePV().longValue()>0) {
				returnPage = ArqRemeEstrategia.STRATEGY_MANTER_FILTRO;
				%>document.frmMain.consultaUnidade.value = "1"; 
				<%
			} else {
				returnPage = ArqRemeEstrategia.STRATEGY_MANTER_INICIAR;
			}
			%>				
			document.frmMain.estrategia.value = "<%=returnPage%>";
		    document.frmMain.fluxo.value = "voltar";
		    document.frmMain.submit();
		}
		
		function clickRadio(escolha, situacao, tipo, data) {
			document.frmMain.escolha.value = escolha;//posição relativa 'a tela
<%
				/*EAM********************************************
				 * Valores para o campo situacao:								*
				 * 0 - Arquivo retorno													*
				 * 1 - Producao acatada													*
				 * 2 - Producao rejeitada												*
				 * 3 - Producao rejeitada parcial								*
				 * 4 - Teste acatada														*
				 * 5 - Teste rejeitada													*
				 * 6 - Teste rejeitada parcial									*
				 * 7 - Redisponibilizacao solicitada						*
				 * 8 - Redisponibilizacao processada						*
				 * 9 - Remessa excluida													*
				 * A - Exclusao solicitada											*
			   ************************************************/
%>		document.frmMain.sit.value = situacao; //situação do arquivo ou remessa 0-A
			document.frmMain.tipo.value = tipo;//1 - remessa/ 2 - retorno
			document.frmMain.data.value = data;//data do arquivo remessa
			//0 - Redisponibilizar Arquivo Retorno
			//1 - Excluir Remessa Arquivo Remessa
			//2 - Cancelar Redisponbilização Arquivo Retorno
			//3 - Cancelar Exclusão Arquivo Remessa
			document.frmMain.comando[0].disabled = true;				
			document.frmMain.comando[1].disabled = true;				
			document.frmMain.comando[2].disabled = true;
			document.frmMain.comando[3].disabled = true;

			document.frmMain.comando[0].checked = false;
			document.frmMain.comando[1].checked = false;
			document.frmMain.comando[2].checked = false;
			document.frmMain.comando[3].checked = false;
		
			//habilita os options de comando
			if (situacao =="0" || situacao =="8") {
				document.frmMain.comando[0].disabled = false;
				document.frmMain.comando[0].checked = true;
				// document.frmMain.acao.disabled = false;				
				//EAM
				comandar('2','I');

			} else if (situacao =="7") {
				document.frmMain.comando[2].disabled = false;	
				document.frmMain.comando[2].checked = true;
				// document.frmMain.acao.disabled = false;				
				//EAM
				comandar('2','E');

			} else if (situacao =="1" || situacao =="3") {
				document.frmMain.comando[1].disabled = false;
				document.frmMain.comando[1].checked = true;
				// document.frmMain.acao.disabled = false;				
				//EAM
				comandar('10','I');

			} else if (situacao =="A") {
				document.frmMain.comando[3].disabled = false;
				document.frmMain.comando[3].checked = true;
				// document.frmMain.acao.disabled = false;
				//EAM
				comandar('10','E');

			} else {
				// document.frmMain.acao.disabled = true;				
			}
			
			//habilitar ou desabilitar o botão de consultar erros
			/*
			if (situacao =="2" || situacao =="3" || situacao =="5" || situacao =="6") {
				document.frmMain.consultar.disabled = false;
			}else {
				document.frmMain.consultar.disabled = true;
			}
			*/
		}

		function comandar(solicitacao, acao) {
			document.frmMain.tipoSolicitacao.value = solicitacao;
			document.frmMain.tipoAcao.value = acao;
		}
		
		function compararDataHoje(data, operador) {
				//EAM - ini
				//			var hoje, dia, mes, ano;
				//			hoje = new Date();
				//			dia = hoje.getDate();
				//			mes = hoje.getMonth();
				//			ano = hoje.getYear();
				//			//hoje inclui a hora é necessário gerar uma nova data para retirar a hora.
				//			hoje = new Date(ano, mes, dia);
				//			return eval(hoje.getTime() + operador  + date2MS(data));

				var hoje;
				hoje = '<%=UtilDatas.getToday()%>';
				return compararDatas(hoje, data, operador);
				
				//fim
		}		
		
    </script>
  </s:FormStrategy>
</p:Document>