<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteConclusaoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	String descCriticas = "";
	if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
		descCriticas = (String) request.getAttribute(CedenteEstrategia.DESC_CRITICAS);
	} 
%>

<%CedenteGeralBean filtroBean = (session.getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN) == null
                    ? new CedenteGeralBean()
                    : (CedenteGeralBean) session.getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN));

            CedenteCabecaBean cabecaBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN) == null
                    ? new CedenteCabecaBean()
                    : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

            CedentePrincipalBean principalBean = (session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN) == null
                    ? new CedentePrincipalBean()
                    : (CedentePrincipalBean) session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN));

            %>

<%// mantendo inputs depois da paginacao
			String bloqueio =(String) request.getAttribute("bloqueio");
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

            String situacaoGuia = "";
            if (principalBean.getSituacaoGuia() != null) {
                situacaoGuia = principalBean.getSituacaoGuia();
            } else if (request.getParameter("situacaoGuia") != null) {
                situacaoGuia = request.getParameter("situacaoGuia");
            }

            String codigoClienteCOCLI = "";
            if (cabecaBean.getCodigoClienteCOCLI() != null) {
                codigoClienteCOCLI = "" + cabecaBean.getCodigoClienteCOCLI();
            } else if (request.getParameter("codigoClienteCOCLI") != null) {
                codigoClienteCOCLI = request.getParameter("codigoClienteCOCLI");
            }

            String codigoUnidadePVVinc = "";
            if (filtroBean.getCodigoClienteCOCLI() != null) {
                codigoUnidadePVVinc = "" + filtroBean.getCodigoUnidadePVVinc();
            } else if (request.getParameter("codigoUnidadePVVinc") != null) {
                codigoUnidadePVVinc = request.getParameter("codigoUnidadePVVinc");
            }

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

            String codigoCedente = "";
            if (filtroBean.getCodigoCedente() != null) {
                codigoCedente = "" + filtroBean.getCodigoCedente();
            } else if (request.getParameter("codigoCedente") != null) {
                codigoCedente = request.getParameter("codigoCedente");
            }

            //AOL - 24nov06
            String logradouro = "";
            if (cabecaBean.getLogradouro() != null) {
                logradouro = "" + cabecaBean.getLogradouro();
            } else if (request.getParameter("logradouro") != null) {
                logradouro = request.getParameter("logradouro");
            }

            String numero = "";
            if (cabecaBean.getNumero() != null) {
                numero = "" + cabecaBean.getNumero().trim();
            } else if (request.getParameter("numero") != null) {
                numero = request.getParameter("numero");
            }

            String complemento = "";
            if (cabecaBean.getComplemento() != null) {
                complemento = "" + cabecaBean.getComplemento();
            } else if (request.getParameter("complemento") != null) {
                complemento = request.getParameter("complemento");
            }

            String bairro = "";
            if (cabecaBean.getBairro() != null) {
                bairro = "" + cabecaBean.getBairro();
            } else if (request.getParameter("bairro") != null) {
                bairro = request.getParameter("bairro");
            }

            String municipio = "";
            if (cabecaBean.getMunicipio() != null) {
                municipio = "" + cabecaBean.getMunicipio();
            } else if (request.getParameter("municipio") != null) {
                municipio = request.getParameter("municipio");
            }

            String cep = "";
            if (cabecaBean.getCep() != null) {
                cep = "" + cabecaBean.getCep();
            } else if (request.getParameter("cep") != null) {
                cep = request.getParameter("cep");
            }

            String uf = "";
            if (cabecaBean.getUf() != null) {
                uf = "" + cabecaBean.getUf();
            } else if (request.getParameter("uf") != null) {
                uf = request.getParameter("uf");
            }

            //AOL - Fim

            %>

<%// CONTROLE DE PAGINACAO

            PageHolder paginacao = (PageHolder) session.getAttribute(CedenteEstrategia.PAGINACAO_LIST);

            int paginaAtual = 0;
            if (request.getParameter(CedenteEstrategia.PAGINACAO_PAGE) != null
                && !request.getParameter(CedenteEstrategia.PAGINACAO_PAGE)
                        .equals("")) {
                paginaAtual = Integer.parseInt((String) request.getParameter(CedenteEstrategia.PAGINACAO_PAGE));
            } else {
                paginaAtual = Integer.parseInt((String) request.getAttribute(CedenteEstrategia.PAGINACAO_PAGE));
            }

            List lista = paginacao.getPage(paginaAtual);
%>

<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="cedente.CedenteIncluirGuiaControle" fluxo="normal">

		<s:Menu />

		<s:Titulo name="Itens Excepcionados" />

		<input type="hidden" name="<%=CedenteEstrategia.PAGINACAO_PAGE%>"
			value="">

		<input type="hidden" name="indicaItemSemAlcada"
			value="<%=indicaItemSemAlcada%>">

		<input type="hidden" name="situacaoGuia" value="<%= situacaoGuia %>">
		<input type="hidden" name="codigoClienteCOCLI"
			value="<%= codigoClienteCOCLI %>">
		<input type="hidden" name="codigoUnidadePVVinc"
			value="<%= codigoUnidadePVVinc %>">
		<input type="hidden" name="tipoAcao">
		<input type="hidden" name="cpfCnpj" value="<%= cpfCnpj %>">
		<input type="hidden" name="nomeCedente" value="<%= nomeCedente %>">
		<input type="hidden" name="idEndereco" value="<%= idEndereco %>">
		<input type="hidden" name="tipoPessoa"
			value="<%= cabecaBean.getTipoPessoa() %>">

		<!-- AOL - 24nov06 -->

		<input type="hidden" name="logradouro" value="<%= logradouro %>">
		<input type="hidden" name="numeroLogradouro" value="<%= numero %>">
		<input type="hidden" name="complemento" value="<%= complemento %>">
		<input type="hidden" name="bairroLogradouro" value="<%= bairro %>">
		<input type="hidden" name="municipio" value="<%= municipio %>">
		<input type="hidden" name="cep" value="<%= cep %>">
		<input type="hidden" name="uf" value="<%= uf %>">

		<!-- AOL - Fim -->


		<input type="hidden" name="codigoCedente" value="<%= codigoCedente %>">

		<table width="490" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="53" valign="middle" align="center">
					<tr>
						<td colspan="2">
						<table width="100%" border="0" cellspacing="3" cellpadding="0"
							height="53" valign="middle" align="center">
							<tr class="headerLista">
								<td width="5%" align="center">&nbsp;</td>
								<td width="50%" align="left">Item</td>
								<td width="15%" align="center" nowrap>Vlr. Orig.</td>
								<td width="15%" align="center" nowrap>Vlr. Excep.</td>
								<td width="15%" align="center">Perc.</td>
							</tr>
							<%CedenteConclusaoBean occ = new CedenteConclusaoBean();
                    for (int i = 0; i < lista.size(); i++) {
                        occ = (CedenteConclusaoBean) lista.get(i);
%>
							<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td width="5%" align="center" class="alert"><%="S".equals(occ.getItemSemAlcada())
                                ? "*"
                                : "&nbsp;"%></td>
								<td width="50%" align="left" nowrap><%=occ.getDescricaoItem()%></td>
								<td width="15%" align="center" nowrap><%=occ.getAtributoOriginal()%></td>
								<td width="15%" align="center" nowrap><%=occ.getAtributoExcepcionado()%></td>
								<td width="15%" align="center" nowrap><%=occ.getAtributoPercentual()%></td>
							</tr>
							<%}

                    %>
							<tr>
								<td colspan="5">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="5" align="center"><%String pageName = CedenteEstrategia.PAGE_INCLUIR_PENDENCIAS;%>
								<s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>"
									numberOfPages="<%=paginacao.getPageCount()%>"
									pageName="<%=pageName%>" /></td>
							</tr>
							<tr>
								<td colspan="5">&nbsp;</td>
							</tr>
							<tr class="line2">
								<td colspan="5">Itens marcados por <font color="red">*</font>,
								indicam impossibilidade de conclusão do cadastramento.</td>
							</tr>
						</table>
						</td>
					</tr>

					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td class="textoTitulo" width="10%">Justificativa:</td>
						<td class="textoValor" width="90%">
						<p align="justify">
						<%if (bloqueio.equals("S")) {%>
							<textarea name="justificativa" cols="50" rows="4"	onKeyPress="javascript:textCounter(document.frmMain.justificativa, document.frmMain.txtTamArea, 200); return validaDigitacaoTextArea(event.charCode || event.keyCode);"	onKeyUp="javascript:textCounter(document.frmMain.justificativa, document.frmMain.txtTamArea, 200);" disabled><%= justificativa %></textarea> 
						<%} else { %>
							<textarea name="justificativa" cols="50" rows="4"	onKeyPress="javascript:textCounter(document.frmMain.justificativa, document.frmMain.txtTamArea, 200); return validaDigitacaoTextArea(event.charCode || event.keyCode);"	onKeyUp="javascript:textCounter(document.frmMain.justificativa, document.frmMain.txtTamArea, 200);" ><%= justificativa %></textarea>						
						<%} %>
							
						<input disabled type="text" class="inputtext" name="txtTamArea" size="3" maxlength="3" value="200">
						
						</td>
					</tr>

					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2">
						<p align="center">
						<%if (bloqueio.equalsIgnoreCase("S")) { %>
							<s:Button name="buttonResolver" value="Resolver Pendencias"	action="javascript:formSubmit_Resolver();" />
							<s:Button name="buttonCancelar" value="Cancelar Cadastro" action="javascript:formSubmit_Cancelar();" /></p>
						<%}else{ %>
							<s:Button name="buttonFinalizar" value="Finalizar Cadastro" action="javascript:formSubmit();" />
							<s:Button name="buttonResolver" value="Resolver Pendencias"	action="javascript:formSubmit_Resolver();" />
							<s:Button name="buttonCancelar" value="Cancelar Cadastro" action="javascript:formSubmit_Cancelar();" /></p>						
						<%} %>
						</td>
					</tr>
				</table>
				</TD>
			</tr>
		</table>
		<script language="javascript">
      function inicia() {
    <%	  
 		 // caso retornou da estrategia com criticas
    	  if (!descCriticas.equals("")) {
    %>
    		  alert("<%= descCriticas %>");
    <%
    	}  
    %>	  
    	  
        // se houver item sem alcada desabilita finalizar
        if (<%= indicaItemSemAlcada %> == true) {
          document.frmMain.buttonFinalizar.disabled = true;
        }
        
        setFirstFieldFocus();
      }
      
	    function formSubmit() {
        if (<%= indicaItemSemAlcada %> == false) { // somente se nao houver itens sem alcada
	        if (validaInserir()) {
            var confirma = confirm(conf('117'));
          
		    		if (confirma) {
				    	document.frmMain.estrategia.value="cedente.CedenteIncluirPendenciasFinalizar";
				    	document.frmMain.tipoAcao.value=document.frmMain.situacaoGuia.value;
				    	document.frmMain.submit();
						}
	        }
        }
	    }
      
	    function formSubmit_Resolver() {
        var confirma = confirm(conf('118'));
        if (confirma) {
          document.frmMain.estrategia.value = "cedente.CedenteIncluirFiltro";
          document.frmMain.fluxo.value = "voltar";				
          document.frmMain.submit();
        }
	    }
      
	    function formSubmit_Cancelar() {
        var confirma = confirm(conf('105'));
      
        if (confirma) {
          document.frmMain.estrategia.value="cedente.CedenteIncluirCancelar";
          document.frmMain.submit();
        }
	    }
      
	    function validaInserir(){
        if (!validaCampoObrigatorio(document.frmMain.justificativa, 'Justificativa')) {
          return false;
        }
	      
        return true;
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
