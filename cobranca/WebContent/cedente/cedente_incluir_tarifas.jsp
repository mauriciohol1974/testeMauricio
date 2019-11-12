<script language="javascript">
	history.go(+1);
</script>
<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteTarifasBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.com.politec.sao.util.Percentual"%>
<%@page import="br.com.politec.sao.util.Money"%>
<%@page import="br.com.politec.sao.business.types.PercentualType"%>
<%@page import="br.com.politec.sao.business.types.MoneyType"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
	String descCriticas = "";
	if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
		descCriticas = (String) request.getAttribute(CedenteEstrategia.DESC_CRITICAS);
	} 
%>

<%
	CedenteTarifasBean tarifasBean = (request.getAttribute(CedenteEstrategia.CEDENTE_TARIFAS_INFORME_BEAN)==null
	                                 ? new CedenteTarifasBean()
	                                 : (CedenteTarifasBean) request.getAttribute(CedenteEstrategia.CEDENTE_TARIFAS_INFORME_BEAN));
	String situacaoGuia = "";
	if (tarifasBean.getSituacaoGuia() != null) {
		situacaoGuia = tarifasBean.getSituacaoGuia();
	} else if (request.getParameter("situacaoGuia") != null) {
		situacaoGuia = request.getParameter("situacaoGuia");
	}
	String codigoClienteCOCLI = "";
	if (tarifasBean.getCodigoClienteCOCLI() != null) {
		codigoClienteCOCLI = ""+tarifasBean.getCodigoClienteCOCLI();
	} else if (request.getParameter("codigoClienteCOCLI") != null) {
		codigoClienteCOCLI = request.getParameter("codigoClienteCOCLI");
	}
	String codigoUnidadePVVinc = "";
	if (tarifasBean.getCodigoUnidadePVVinc() != null) {
		codigoUnidadePVVinc = ""+tarifasBean.getCodigoUnidadePVVinc();
	} else if (request.getParameter("codigoUnidadePVVinc") != null) {
		codigoUnidadePVVinc = request.getParameter("codigoUnidadePVVinc");
	}
	String tipoAcao = "";
	if (tarifasBean.getTipoAcao() != null) {
		tipoAcao = tarifasBean.getTipoAcao();
	} else if (request.getParameter("tipoAcao") != null) {
		tipoAcao = request.getParameter("tipoAcao");
	}
	String codigoAgrupamentoServico = "";
	if (tarifasBean.getCodigoAgrupamentoServico() != null) {
		codigoAgrupamentoServico = tarifasBean.getCodigoAgrupamentoServico();
	} else if (request.getParameter("codigoAgrupamentoServico") != null) {
		codigoAgrupamentoServico = request.getParameter("codigoAgrupamentoServico");
	}
	String descricaoAgrupamentoServico = "";
	if (tarifasBean.getDescricaoAgrupamentoServico() != null) {
		descricaoAgrupamentoServico = tarifasBean.getDescricaoAgrupamentoServico();
	} else if (request.getParameter("descricaoAgrupamentoServico") != null) {
		descricaoAgrupamentoServico = request.getParameter("descricaoAgrupamentoServico");
	}
%>


<%
	// CONTROLE DE PAGINACAO

	PageHolder paginacao = (PageHolder) session.getAttribute(CedenteEstrategia.PAGINACAO_LIST);

	// usado para salvar os dados digitados pelo usuario na pagina anterior
	int paginaAnterior = 0;
	if(request.getParameter(CedenteEstrategia.PAGINACAO_PAGEANTERIOR) != null && !request.getParameter(CedenteEstrategia.PAGINACAO_PAGEANTERIOR).equals("")){
		paginaAnterior = Integer.parseInt((String)request.getParameter(CedenteEstrategia.PAGINACAO_PAGEANTERIOR));
	} else {
		paginaAnterior = Integer.parseInt((String)request.getAttribute(CedenteEstrategia.PAGINACAO_PAGEANTERIOR));
	}
	List listaAnterior = paginacao.getPage(paginaAnterior);

	String[] arrayPercentualCalculado = null;
	String[] arrayValorCalculado = null;
	if (request.getParameterValues("arrayPercentualCalculado") != null && !request.getParameterValues("arrayPercentualCalculado").equals("")){
		arrayPercentualCalculado = (String[])request.getParameterValues("arrayPercentualCalculado");
	}
	if (request.getParameterValues("arrayValorCalculado") != null && !request.getParameterValues("arrayValorCalculado").equals("")){
		arrayValorCalculado = (String[])request.getParameterValues("arrayValorCalculado");
	}
	if (arrayPercentualCalculado != null) {
		for (int i=0; i < arrayPercentualCalculado.length; i++) {
			CedenteTarifasBean bean = (CedenteTarifasBean)listaAnterior.get(i);
			String valorFormatado = arrayPercentualCalculado[i];
			String valor = valorFormatado.replace(".", "");
			bean.setPercentualCalculado((Percentual) PercentualType.create().newInstance(valor));
			if (i < arrayValorCalculado.length) {
				bean.setValorCalculado((Money) MoneyType.create().newInstance(arrayValorCalculado[i]));
			}
		}
	}

	int paginaAtual = 0;
	if (request.getParameter(CedenteEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(CedenteEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(CedenteEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(CedenteEstrategia.PAGINACAO_PAGE));
	}
	
	List lista = paginacao.getPage(paginaAtual);
%>

<html>
<s:HeaderPopup/>
<p:Document>

	<!-- ************************ PAGINA INFORME TARIFAS *************************** -->

	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="cedente.CedenteIncluirTarifasIniciar" fluxo="normal">

<%
	String tituloPagina = "Informe de Tarifas: Grupo " + codigoAgrupamentoServico + " - " + descricaoAgrupamentoServico;
%>
		<s:Titulo name="<%=tituloPagina%>"/>
		
		<input type="hidden" name="<%=CedenteEstrategia.PAGINACAO_PAGE%>" value="">		
		<input type="hidden" name= "<%=CedenteEstrategia.PAGINACAO_PAGEANTERIOR%>" value="<%=paginaAtual%>">

		<input type="hidden" name="situacaoGuia" value="<%=situacaoGuia%>">
		<input type="hidden" name="codigoClienteCOCLI" value="<%=codigoClienteCOCLI%>">
		<input type="hidden" name="codigoUnidadePVVinc" value="<%=codigoUnidadePVVinc%>">
		<input type="hidden" name="tipoAcao" value="<%=tipoAcao%>">
		
		<input type="hidden" name="codigoAgrupamentoServico" value="<%=codigoAgrupamentoServico%>">
		<input type="hidden" name="descricaoAgrupamentoServico" value="<%=descricaoAgrupamentoServico%>">

		<input type="hidden" name="tempValorOriginal">
		<input type="hidden" name="tempValorCalculado">
		<input type="hidden" name="tempPercentualOriginal">
		<input type="hidden" name="tempPercentualCalculado">
    
    <table width="630" border="0" cellspacing="0" cellpadding="0" align="center">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
          	<tr>
          		<td colspan="2">
								<table class="box" width="100%" border="0" cellspacing="3" cellpadding="0" height=53 valign="middle" align="center">
									<tr class="headerLista">
			          		<td align="center" class="textoDestaqueTitulo" width="4%">&nbsp;</td>
			              <td align="left" class="textoDestaqueTitulo" width="35%" colspan="2">Serviço</td>
			              <td align="left" class="textoDestaqueTitulo" width="10%">Valor Orig.</td>
			              <td align="left" class="textoDestaqueTitulo" width="15%">Perc. Orig.</td>
			              <td align="left" class="textoDestaqueTitulo" width="10%">Valor Calc.</td>
			              <td align="left" class="textoDestaqueTitulo" width="10%">Perc. Calc.</td>
			            </tr>
			            
<%
		CedenteTarifasBean occ = new CedenteTarifasBean();
		for ( int i = 0; i < lista.size(); i++ ) {	
			occ = (CedenteTarifasBean) lista.get(i);

			String functionMudaValor = "javascript:mudaValor("+i+");";
			String functionMudaPercentual = "javascript:mudaPercentual("+i+");";
%>
			            <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
			            	<td class="textoValor" width="4%" align="center"><%=occ.getCodigoServico()%>.</td>
			              <td class="textoValor" width="35%" colspan="2"><%=occ.getDescricaoServico()%></td>
			              <td class="textoValor" width="15%">
			              	<%=occ.getValorOriginal()%>
			              	<input type="hidden" name="arrayValorOriginal" value="<%=occ.getValorOriginal()%>">
			              </td>
			              <td class="textoValor" width="10%">
			              	<%=occ.getPercentualOriginal()%>
			              	<input type="hidden" name="arrayPercentualOriginal" value="<%=occ.getPercentualOriginal()%>">
			              </td>
			              <td class="textoValor" width="10%">
			              	<p:InputCurrency CLASS="inputtext" name="arrayValorCalculado" size="21" maxlength="15" value="<%=occ.getValorCalculado().toString()%>" onBlur="<%=functionMudaValor%>" />
			              </td>
			              <td class="textoValor" width="15%">
			              	<p:InputPercentual CLASS="inputtext" name="arrayPercentualCalculado" size="14" maxlength="7" value="<%=occ.getPercentualCalculado().toString()%>" onBlur="<%=functionMudaPercentual%>" />
			              </td>
			            </tr>
<%
	}
%>			            
									<tr>
                    <td colspan="6">&nbsp;</td>
                  </tr>
                  <%if (codigoAgrupamentoServico.equalsIgnoreCase("A06")){ %>
                  <tr>
                  	<td colspan="8" style="color:red; font-weight: bold;">Atenção: Tarifa de liquidação + Tarifa de Registro não podem ultrapassar o valor da tarifa de balcão (Valor Orig.) definido para as liquidações
                  	</td>
                  </tr>
                  <%} %>
									<tr>
										<td colspan="6" align="center">
											<% String pageName = CedenteEstrategia.PAGE_INCLUIR_TARIFAS_INFORME;%>
											<s:ButtonPaginar pageNumber="<%=paginacao.getPageNumber()%>" numberOfPages="<%=paginacao.getPageCount()%>" pageName="<%=pageName%>"/>
										</td>
									</tr>
								</table>
			        </td>
			      </tr>            
            
            <tr> 
              <td colspan="2">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="2">
                <p align="center"> 
                  <s:Button name="Confirmar" action="javascript:formSubmit();" />
                  <s:Button name="Cancelar" action="javascript:formSubmit_Cancelar();" />
                </p>
              </td>
            </tr>
          </table>
        </TD>
      </tr>
    </table>
    
    <script language="javascript">
    	function inicia() {
<%
	if (!descCriticas.equals("")) {
%>
				alert("<%= descCriticas %>");
<%
	// se nao houver criticas e existe as criticas vazias no request (nao eh null)
	// quer dizer que finalizou com sucesso e a janela pode ser fechada
	} else if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
%>
				window.close();
<%
	}
%>
    	}
    
	    function formSubmit() {
	        if (validaInserir()) {
	        	var confirma = confirm(conf('114'));
	        
		    		if (confirma) {
				    	document.frmMain.estrategia.value="cedente.CedenteIncluirTarifasFinalizar";
				    	document.frmMain.tipoAcao.value=document.frmMain.situacaoGuia.value;
				    	document.frmMain.submit();
						}
	        }
	    }
	    
	    function formSubmit_Cancelar() {
	    		var confirma = confirm(conf('115'));
	    		if (confirma) {
						window.close();
					}
	    }
	    
	    function validaInserir(){
	        return true;
	    }
	    
	    function mudaValor( indice ) {
    		if (document.frmMain.arrayValorCalculado[indice] != null) {
    			document.frmMain.tempValorCalculado.value=document.frmMain.arrayValorCalculado[indice].value;
    		} else {
    			document.frmMain.tempValorCalculado.value=document.frmMain.arrayValorCalculado.value;
    		}
    		
    		if (document.frmMain.arrayValorOriginal[indice] != null) {
    			document.frmMain.tempValorOriginal.value=document.frmMain.arrayValorOriginal[indice].value;
    		} else {
    			document.frmMain.tempValorOriginal.value=document.frmMain.arrayValorOriginal.value;
    		}
    		
    		if (document.frmMain.arrayPercentualOriginal[indice] != null) {
    			document.frmMain.tempPercentualOriginal.value=document.frmMain.arrayPercentualOriginal[indice].value;
    		} else {
    			document.frmMain.tempPercentualOriginal.value=document.frmMain.arrayPercentualOriginal.value;
    		}
    	
    		unFormataCurrency(document.frmMain.tempValorCalculado, 1);
    		unFormataCurrency(document.frmMain.tempValorOriginal, 1);
    		unFormataPercentual(document.frmMain.tempPercentualOriginal);
    	
	    	var vCalculado = document.frmMain.tempValorCalculado.value;
	    	var vOriginal = document.frmMain.tempValorOriginal.value;
	    	var pOriginal = document.frmMain.tempPercentualOriginal.value;
	    	
	    	if (pOriginal != 0 && vOriginal != 0) {
	    		var pCalculado = Math.round((vCalculado / vOriginal) * pOriginal);
	    		// Nao deixa o tamanho passar de 7 casas
	    		if (pCalculado >= 9999000) {
			    	pCalculado = 9999000;
			    	
			    	//EAM0108 - Ini - Não permitir manter o valor digitado qdo o percentual é superior a 1000%						
				    //verifica que tem apenas 1 tarifa p/ poder desabilitar o campo
				    if (document.frmMain.arrayPercentualCalculado[indice] != null) {
							document.frmMain.arrayPercentualCalculado[indice].disabled = true;
						} else {
				    	document.frmMain.arrayPercentualCalculado.disabled = true;
				    }
						//Emite a mensagem
						msg('064','Perc. Calc.','99.990,00 %','Valor Calc');
				    
				    //verifica que tem apenas 1 tarifa p/ poder atribuir o foco
				    if (document.frmMain.arrayValorCalculado[indice] != null) {
			    		document.frmMain.arrayValorCalculado[indice].focus();
						} else {
				    	document.frmMain.arrayValorCalculado.focus();
				    }
					//habilita o campo novamente
			    }else{
				    //verifica que tem apenas 1 tarifa p/ poder desabilitar o campo
				    if (document.frmMain.arrayPercentualCalculado[indice] != null) {
							document.frmMain.arrayPercentualCalculado[indice].disabled = false;
						} else {
				    	document.frmMain.arrayPercentualCalculado.disabled = false;
				    }			    	
			    //EAM0108 - Fim
			    	
			    }
			    
			    if (document.frmMain.arrayPercentualCalculado[indice] != null) {
			    	document.frmMain.arrayPercentualCalculado[indice].value = pCalculado;
			    	formataPercentual(document.frmMain.arrayPercentualCalculado[indice]);
			    } else {
			    	document.frmMain.arrayPercentualCalculado.value = pCalculado;
			    	formataPercentual(document.frmMain.arrayPercentualCalculado);
			    }
	    	} 
	    	// se der divisao por zero nao faz nada
	    	//else {
	    	//	document.frmMain.arrayPercentualCalculado[indice].value = 0;
		    //	formataPercentual(document.frmMain.arrayPercentualCalculado[indice]);
	    	//}
	    }
	    
	    function mudaPercentual( indice ) {
	    	if (document.frmMain.arrayPercentualCalculado[indice] != null) {
	    		document.frmMain.tempPercentualCalculado.value=document.frmMain.arrayPercentualCalculado[indice].value;
	    	} else {
	    		document.frmMain.tempPercentualCalculado.value=document.frmMain.arrayPercentualCalculado.value;
	    	}
    		
    		if (document.frmMain.arrayPercentualOriginal[indice] != null) {
    			document.frmMain.tempPercentualOriginal.value=document.frmMain.arrayPercentualOriginal[indice].value;
    		} else {
    			document.frmMain.tempPercentualOriginal.value=document.frmMain.arrayPercentualOriginal.value;
    		}
    		
				if (document.frmMain.arrayValorOriginal[indice] != null) {
					document.frmMain.tempValorOriginal.value=document.frmMain.arrayValorOriginal[indice].value;
				} else {
					document.frmMain.tempValorOriginal.value=document.frmMain.arrayValorOriginal.value;
				}

				if (document.frmMain.arrayValorCalculado[indice] != null) {
		    	var vCalculadoAntigo = desformataMoney(document.frmMain.arrayValorCalculado[indice].value);
		    } else {
		    	var vCalculadoAntigo = desformataMoney(document.frmMain.arrayValorCalculado.value);
		    }

    		unFormataPercentual(document.frmMain.tempPercentualCalculado);
    		unFormataPercentual(document.frmMain.tempPercentualOriginal);
    		unFormataCurrency(document.frmMain.tempValorOriginal, 1);
    		
	    	var pCalculado = document.frmMain.tempPercentualCalculado.value;
	    	var pOriginal = document.frmMain.tempPercentualOriginal.value;
	    	var vOriginal = document.frmMain.tempValorOriginal.value;
	    	var valorCampo = vCalculadoAntigo;

	    	if (vOriginal != 0 && pOriginal != 0) {
	    		var vCalculado = Math.round((pCalculado / pOriginal) * vOriginal);
	    		// Nao deixa o tamanho passar de 15 casas
	    		if (vCalculado < 1000000000000000) {
	    			// se 999,99% for menor que o valor que já estava, não usa o valor calculado
	    			if (pCalculado == '99999') {
	    				if (vCalculadoAntigo > vCalculado) {
				    		valorCampo = vCalculadoAntigo;
				    	} else {
	    					valorCampo = vCalculado;
	    				}
	    			} else {
	    				valorCampo = vCalculado;
	    			}
			    } else {
			    	valorCampo = 999999999999999;
			    }
			    
					if (document.frmMain.arrayValorCalculado[indice] != null) {
				    document.frmMain.arrayValorCalculado[indice].value = valorCampo;
						formataCurrency(document.frmMain.arrayValorCalculado[indice]);
					} else {
				    document.frmMain.arrayValorCalculado.value = valorCampo;
						formataCurrency(document.frmMain.arrayValorCalculado);
					}
		    }
		    // se der divisao por zero nao faz nada
		    //else {
		    //	document.frmMain.arrayValorCalculado[indice].value = 0;
		    //	formataCurrency(document.frmMain.arrayValorCalculado[indice]);
		    //}
	    }
		</script>
    
   	</s:FormStrategy>
   	
	<!-- ************************ FIM PAGINA INFORME TARIFAS ************************ -->
	   	
  </p:Document>
</html>
