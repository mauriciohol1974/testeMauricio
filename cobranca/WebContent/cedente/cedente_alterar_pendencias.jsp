<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConclusaoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConteudoListaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<% 
	CedenteCabecaBean cabecaBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
	                               ? new CedenteCabecaBean()
	                               : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

	CedenteConteudoListaBean filtroBean = (session.getAttribute(CedenteEstrategia.ALTERAR_FILTRO_BEAN)==null
	                                      ? new CedenteConteudoListaBean()
	                                      : (CedenteConteudoListaBean) session.getAttribute(CedenteEstrategia.ALTERAR_FILTRO_BEAN));

%>

<%
	CedenteConclusaoBean conclusaoBean = (request.getAttribute(CedenteEstrategia.CEDENTE_CONCLUSAO_BEAN)==null
	                                     ? new CedenteConclusaoBean()
	                                     : (CedenteConclusaoBean) request.getAttribute(CedenteEstrategia.CEDENTE_CONCLUSAO_BEAN));

	// mantendo inputs depois da paginacao
  boolean indicaItemSemAlcada = false;
  if (request.getAttribute(CedenteEstrategia.INDICA_ITEM_SEM_ALCADA) != null) {
  	indicaItemSemAlcada = ((Boolean) request.getAttribute(CedenteEstrategia.INDICA_ITEM_SEM_ALCADA)).booleanValue();
  } else if (request.getParameter(CedenteEstrategia.INDICA_ITEM_SEM_ALCADA) != null) {
  	if ("true".equals(request.getParameter(CedenteEstrategia.INDICA_ITEM_SEM_ALCADA))) {
    	indicaItemSemAlcada = true;
  	}
  }

	String justificativa = "";
	if (request.getParameter("justificativa") != null) {
		justificativa = request.getParameter("justificativa");
	}

	String nsuTransacao = filtroBean.getNsuTransacao();

	String cpfCnpj = "";
	if (cabecaBean.getCpfCnpj() != null) {
		cpfCnpj = "" + cabecaBean.getCpfCnpj();
	} else if (request.getParameter("cpfCnpj") != null) {
		cpfCnpj = request.getParameter("cpfCnpj");
	}

	String nomeCedente = "";
	if (cabecaBean.getNomeFantasia() != null) {
		nomeCedente = "" + cabecaBean.getNomeFantasia();
	} else if (request.getParameter("nomeCedente") != null) {
		nomeCedente = request.getParameter("nomeCedente");
	}

	String idEndereco = "";
	if (cabecaBean.getIdEndereco() != null) {
		idEndereco = "" + cabecaBean.getIdEndereco();
	} else if (request.getParameter("idEndereco") != null) {
		idEndereco = request.getParameter("idEndereco");
	}

	String numeroPendenciaVigente = "";
	if (conclusaoBean.getNumeroPendenciaVigente() != null) {
		numeroPendenciaVigente = "" + conclusaoBean.getNumeroPendenciaVigente();
	} else if (request.getParameter("numeroPendenciaVigente") != null) {
		numeroPendenciaVigente = request.getParameter("numeroPendenciaVigente");
		conclusaoBean.setNumeroPendenciaVigente(Long.valueOf(numeroPendenciaVigente));
	}

	String numeroReiteracaoVigente = "";
	if (conclusaoBean.getNumeroReiteracaoVigente() != null) {
		numeroReiteracaoVigente = "" + conclusaoBean.getNumeroReiteracaoVigente();
	} else if (request.getParameter("numeroReiteracaoVigente") != null) {
		numeroReiteracaoVigente = request.getParameter("numeroReiteracaoVigente");
	}


	String codigoCedente = "";
	if (filtroBean.getCodigoCedente() != null) {
		codigoCedente = "" + filtroBean.getCodigoCedente();
	}
%>

<%
	// CONTROLE DE PAGINACAO
	
	PageHolder paginacao = (PageHolder) session.getAttribute(CedenteEstrategia.PAGINACAO_LIST);

	int paginaAtual = 0;
	// se foi fechada a janela de excepcionacao, ignora a paginacao, comeca do 0
	if (request.getAttribute(CedenteEstrategia.FECHAR_JANELA_EXCVIG) == null) {
		if (request.getParameter(CedenteEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(CedenteEstrategia.PAGINACAO_PAGE).equals("")){
			paginaAtual = Integer.parseInt((String)request.getParameter(CedenteEstrategia.PAGINACAO_PAGE));
		} else {
			paginaAtual = Integer.parseInt((String)request.getAttribute(CedenteEstrategia.PAGINACAO_PAGE));
		}
	}
	
	List lista = paginacao.getPage(paginaAtual);
	
	InformacoesUsuarioBean usuarioLDAPBean = (InformacoesUsuarioBean)session.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);


	
%>
	<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>

<html>
  <s:Header/>

  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteAlterarGuiaControle" fluxo="normal">

    <s:Menu/>

    <s:Titulo name="Itens Excepcionados"/>

		<input type="hidden" name="<%=CedenteEstrategia.PAGINACAO_PAGE%>" value="">		
		<input type="hidden" name= "<%=CedenteEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">
    
    <input type="hidden" name="indicaItemSemAlcada" value="<%=indicaItemSemAlcada%>">

    <input type="hidden" name="nsuTransacao" value="<%= nsuTransacao %>">
		<input type="hidden" name="codigoCedente" value="<%= codigoCedente %>">
		<input type="hidden" name="numeroPendenciaVigente" value="<%= numeroPendenciaVigente %>">
		<input type="hidden" name="numeroReiteracaoVigente" value="<%= numeroReiteracaoVigente %>">

    <input type="hidden" name="cpfCnpj" value="<%= cpfCnpj %>">
    <input type="hidden" name="nomeCedente" value="<%= nomeCedente %>">
    <input type="hidden" name="idEndereco" value="<%= idEndereco %>">


    <table width="490" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
          	<tr>
          		<td colspan="2">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" height="53" valign="middle" align="center">
			            <tr class="headerLista">
			              <td width="5%"  align="center">&nbsp;</td>
			              <td width="50%" align="left">Item</td>
			              <td width="15%" align="center" nowrap>Vlr. Orig.</td>
			              <td width="15%" align="center" nowrap>Vlr. Excep.</td>
			              <td width="15%" align="center">Perc.</td>
									</tr>
<%
		CedenteConclusaoBean occ = new CedenteConclusaoBean();
		for ( int i = 0; i < lista.size(); i++ ) {	
			occ = (CedenteConclusaoBean) lista.get(i);
%>                  
			            <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
										<td width="5%"  align="center" class="alert">
                      <%="S".equals(occ.getItemSemAlcada()) ? "*" : "&nbsp;" %>
                    </td>
										<td width="50%" align="left" nowrap><%=occ.getDescricaoItem()%></td>
										<td width="15%" align="center" nowrap><%=occ.getAtributoOriginal()%></td>
										<td width="15%" align="center" nowrap><%=occ.getAtributoExcepcionado()%></td>
										<td width="15%" align="center" nowrap><%=occ.getAtributoPercentual()%></td>
									</tr>
<%
		}
%>		                  
			            <tr> 
			              <td colspan="5">&nbsp;</td>
			            </tr>
									<tr>
										<td colspan="5" align="center">
											<% String pageName = CedenteEstrategia.PAGE_ALTERAR_PENDENCIAS;%>
											<s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=pageName%>"/>
										</td>
									</tr>
			            <tr> 
			              <td colspan="5">&nbsp;</td>
			            </tr>
			            <tr class="line2"> 
			              <td colspan="5">Itens marcados por <font color="red">*</font>, indicam impossibilidade de conclusão do cadastramento.</td>
			            </tr>
			          </table>
			        </td>
			      </tr>            
            
            <tr> 
              <td colspan="2">&nbsp;</td>
            </tr>
						<tr>
              <td class="textoTitulo" width="10%">Justificativa: </td>
              <td class="textoValor" width="90%">
              	<p align="justify">
                	<p:TextAreaAlfanumerico name="justificativa" value="<%= justificativa %>" cols="50" rows="4"
		            			 onKeyPress="javascript:textCounter(document.frmMain.justificativa, document.frmMain.txtTamArea, 200); return validaDigitacaoTextArea(event.charCode || event.keyCode);"
		                   onKeyUp="javascript:textCounter(document.frmMain.justificativa, document.frmMain.txtTamArea, 200);" />
		              <input disabled type="text" class="inputtext" name="txtTamArea" size="3" maxlength="3" value="200">		                                  	
		            </p>
              </td>
            </tr>

            <tr> 
              <td colspan="2">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="2">
                <p align="center"> 
                  <s:Button name="buttonFinalizar" value="Finalizar Alteração" action="javascript:formSubmit();" userGroup="<%=usuarioLDAPBean.getNomeGrupo()%>" internalAction="cedente.cadastro.manter.alterar"/>
                  <s:Button name="buttonResolver" value="Resolver Pendencias" action="javascript:formSubmit_Resolver();" userGroup="<%=usuarioLDAPBean.getNomeGrupo()%>" internalAction="cedente.cadastro.manter.alterar"/>
                  <s:Button name="buttonCancelar" value="Cancelar Alteração" action="javascript:formSubmit_Cancelar();" />
                </p>
              </td>
            </tr>

            <tr> 
              <td colspan="2">&nbsp;</td>
            </tr>

<%
	if (!new Long(0).equals(conclusaoBean.getNumeroPendenciaVigente())) {
%>           
 						<tr>         
              <td colspan="2">
             	  <table width="50%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
			            <tr> 
				              <td class="textoValorDebito">
		              	<div class="group">
				                <p align="center">Atenção: Há excepcionação vigente<br><br>
				                	<s:Button name="buttonVerExcepcionacao" value="Ver Excepcionacao" action="javascript:formSubmit_ExcepcionacaoAnterior();" />
				                </p>
			             	</div>
				              </td>
			            </tr>
			          </table>
             	</td>
          	</tr>
<%
	}
%>
            
          </table>
        </TD>
      </tr>
    </table>
    <script language="javascript">
    	var janela_agregacao;
    
      function inicia() {
        // se houver item sem alcada desabilita finalizar
        if (<%= indicaItemSemAlcada %> == true) {
          document.frmMain.buttonFinalizar.disabled = true;
        }
        
        setFirstFieldFocus();
      }
      
	    function formSubmit() {
        if (<%= indicaItemSemAlcada %> == false) { // somente se nao houver itens sem alcada
	        if (validaInserir()) {
            var confirma = confirm(conf('160'));
          
		    		if (confirma) {
				    	document.frmMain.estrategia.value="cedente.CedenteAlterarPendenciasFinalizar";
				    	document.frmMain.submit();
						}
	        }
        }
	    }
      
	    function formSubmit_Resolver() {
        var confirma = confirm(conf('118'));
        if (confirma) {
          document.frmMain.estrategia.value = "cedente.CedenteAlterarIniciar";
          document.frmMain.fluxo.value = "voltar";				
          document.frmMain.submit();
        }
	    }
      
	    function formSubmit_Cancelar() {
        var confirma = confirm(conf('126'));
      
        if (confirma) {
          document.frmMain.estrategia.value="cedente.CedenteAlterarCancelar";
          document.frmMain.submit();
        }
	    }
      
	    function validaInserir(){
        if (!validaCampoObrigatorio(document.frmMain.justificativa, 'Justificativa')) {
          return false;
        }
	      
        return true;
	    }
	    
	    function formSubmit_ExcepcionacaoAnterior() {
	    		if (confirm("Deseja visualizar pendencias anteriores para agregação?")) {
						var valorAltura = 350;
						var valorLargura = 520;
						var valorTopo = (screen.height - valorAltura) /2;
						var valorEsquerda = (screen.width - valorLargura) /2;
	    		
					  janela_agregacao = window.open("<%=Paths.getRootForDynamicContent()%>/jump/cedente_alterar_excepanterior_jump.jsp", "cedente_alterar_excepanterior<%=br.gov.caixa.sigcb.bean.SigcbBean.getId(request)%>", "height="+valorAltura+",width="+valorLargura+",top="+valorTopo+",left="+valorEsquerda+",toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=0");
	        }
	    }

	    
	    function validaDigitacaoTextArea( keyCode ) {
				return validaDigitacaoAlfanumerico(String.fromCharCode(keyCode));
			}
			
			function textCounter(campo, campoContador, limiteMaximo) {
				if (campo.value.length > limiteMaximo)
					campo.value = campo.value.substring(0, limiteMaximo);
				else
					campoContador.value = limiteMaximo - campo.value.length;
			}
						
		</script>
    
   	</s:FormStrategy>
  </p:Document>
</html>
