<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bordero_consultar.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 22/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BorderoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>


<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(BorderoEstrategia.USUARIOLDAP_BEAN);
	BorderoBean borderoBean = (session.getAttribute(BorderoEstrategia.DATA_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(BorderoEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Manter Borderô >> Consultar"/>    
		<input type="hidden" name="codigoCedente" value='<%=borderoBean.getCodigoCedente()%>'>
		<input type="hidden" name="codigoBordero" value='<%=borderoBean.getCodigoBordero()%>'>
		<input type="hidden" name="situacao" value='<%=borderoBean.getSituacao()%>'>
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoCedenteFormatado()%></td>
  
                <td class="textoTitulo" width="17%">Nome Cedente: </td>
  	            <td class="textoValor" nowrap width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 

              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
  
              <td class="textoTitulo" width="17%">Borderô: </td>
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoBordero().equals( new Long(0))?"":borderoBean.getCodigoBordero().toString()%></td>

            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Borderô:
                <hr>
              </td>
            </tr>

 						<tr>
 							<td colspan ="4">         
		            <s:Outline name="Bordero" title="Borderô" imagePath="<%=Paths.getImagePath()%>" type="outline">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                       <td class="textoTitulo" width="17%">Registrar Título Sem Registro: </td>
                       <td class="textoValor" width="26%"><%=borderoBean.getRegistrarSR().equals("S")?"SIM":"NAO"%></td>                           
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Somente para Protesto: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getSomenteProtesto().equals("S")?"SIM":"NAO"%></td>

                      <td class="textoTitulo" width="17%">Modalidade Titulo: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getModalidadeTituloTexto()%></td>
										</tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Data do Movimento: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getDataMovimentoFormatada()%></td>
          
                      <td class="textoTitulo" width="17%">PV de Vinculação: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getVinculacaoPVFormatado()%></td>
                    </tr>

                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Quantidade: </td>
				              <td class="textoValor" width="26%" nowrap><%=borderoBean.getQuantidade()%></td>

                      <td nowrap class="textoTitulo" width="17%">Valor: </td>
				              <td class="textoValor" width="26%" nowrap><%=borderoBean.getValor()%></td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Endosso: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getEndosso().equals("S")?"SIM":"NAO"%></td>

                      <td class="textoTitulo" width="17%">Espécie de Título: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getEspecieTituloTexto()%></td>
                    </tr>
                    
                    <tr>
                      <td class="textoTitulo" width="17%">Aceite: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getAceiteTexto()%></td>

                      <td class="textoTitulo" width="17%">Moeda: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getMoedaTexto()%></td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Protesto Automático: </td>
				              <td class="textoValor" width="26%" nowrap><%=borderoBean.getProtestoAutomatico().equals("S")?"SIM":"NAO"%></td>

                      <td nowrap class="textoTitulo" width="17%">Prazo de Protesto/Devolução: </td>
				              <td class="textoValor" width="26%" nowrap><%=borderoBean.getPrazoProtDevol()%></td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Emissão Boleto: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getEmissaoBloquetoTexto()%></td>
                      <td class="textoTitulo" width="17%">Envio do Boleto: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getEnvioBloquetoTexto()%></td>
                    </tr>
                    
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                  </table>
                </s:Outline>	
							</td>
            </tr>
 						<tr>
 							<td colspan ="4">         
		            <s:Outline name="Complementar" title="Dados Complementares" imagePath="<%=Paths.getImagePath()%>" type="outline">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                   
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="4">
			                  <table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
												  <tr class="headerLista">
												    <td nowrap width="17%" align="center">&nbsp;</td>
				 								    <td nowrap width="26%" align="left">Percentual</td>
												    <td nowrap width="17%" align="center">&nbsp;</td>
				 								    <td nowrap width="26%" align="left">Dias </td>
												  </tr>
												  
												  
											<tr class="line0">
			                      <td class="textoTitulo" width="17%" align="left">Desconto 1: </td>
			                      <td class="textoValor" width="26%" align="left"><%=borderoBean.getPercentualDesconto1().toString().equals("0,00 %")?"":borderoBean.getPercentualDesconto1().toString()%></td>
			                      <td class="textoTitulo" width="17%" align="left">Prazo Limite 1: </td>
			                      <td class="textoValor" width="26%" align="left">
					                   	 <%if(!borderoBean.getPercentualDesconto1().toString().equals("0,00 %")){%>
                    					 		<%=borderoBean.getPrazoLimite1Dia().toString()%>
          					         	 <%}%>			                      
			                     </td>
													</tr> 
												  <tr class="line2">
			                      <td class="textoTitulo" width="17%" align="left">Desconto 2: </td>
			                      <td class="textoValor" width="26%" align="left"><%=borderoBean.getPercentualDesconto2().toString().equals("0,00 %")?"":borderoBean.getPercentualDesconto2().toString()%></td>
			                      <td class="textoTitulo" width="17%" align="left">Prazo Limite 2: </td>
			                      <td class="textoValor" width="26%" align="left">
					                   	 <%if(!borderoBean.getPercentualDesconto2().toString().equals("0,00 %")){%>
                    					 		<%=borderoBean.getPrazoLimite2Dia().toString()%>
          					         	 <%}%>			                      			                      
			                      </td>
													</tr>
												  <tr class="line0">
			                      <td class="textoTitulo" width="17%" align="left">Desconto 3: </td>
			                      <td class="textoValor" width="26%" align="left"><%=borderoBean.getPercentualDesconto3().toString().equals("0,00 %")?"":borderoBean.getPercentualDesconto3().toString()%></td>
			                      <td class="textoTitulo" width="17%" align="left">Prazo Limite 3: </td>
			                      <td class="textoValor" width="26%" align="left">
					                   	 <%if(!borderoBean.getPercentualDesconto3().toString().equals("0,00 %")){%>
                    					 		<%=borderoBean.getPrazoLimite3Dia().toString()%>
          					         	 <%}%>			                      			                      
			                      </td>
													</tr>
												  <tr class="line2">
			                      <td class="textoTitulo" width="17%" align="left">Multa: </td>
			                      <td class="textoValor" width="26%" align="left"><%=borderoBean.getMultaPercentual().toString().equals("0,00 %")?"":borderoBean.getMultaPercentual().toString()%></td>
			                      <td class="textoTitulo" width="17%" align="left">Prazo para Multa: </td>
			                      <td class="textoValor" width="26%" align="left"><%=borderoBean.getPrazoMultaDias().equals(new Long(0))?"":borderoBean.getPrazoMultaDias().toString()%></td>
													</tr>
												</table>
											</td>
										</tr>
										
							 <tr>
                      <td class="textoTitulo" width="17%">Tipo de Juros: </td>
				              <td class="textoValor" width="26%" nowrap>
				              			<select name="tipoJurosDia" disabled="disabled" >
													<option value="2" <%=borderoBean.getTipoJurosDia().toString().equals("2") ? "selected='selected'" : "" %>  >2-Percentual ao dia (dias corridos)</option>
													<option value="3" <%=borderoBean.getTipoJurosDia().toString().equals("3") ? "selected='selected'" : "" %>>3-Percentual ao mês (dias corridos)</option>
													<option value="4" <%=borderoBean.getTipoJurosDia().toString().equals("4") ? "selected='selected'" : "" %>>4-Percentual ao ano (dias corridos)</option>
													<option value="5" <%=borderoBean.getTipoJurosDia().toString().equals("5") ? "selected='selected'" : "" %>>5-Isento</option>
													<option value="7" <%=borderoBean.getTipoJurosDia().toString().equals("7") ? "selected='selected'" : "" %>>7-Percentual ao dia (dias úteis)</option>
													<option value="8" <%=borderoBean.getTipoJurosDia().toString().equals("8") ? "selected='selected'" : "" %>>8-Percentual ao mês (dias úteis)</option>
													<option value="9" <%=borderoBean.getTipoJurosDia().toString().equals("9") ? "selected='selected'" : "" %>>9-Percentual ao ano (dias úteis)</option>
										</select>      
				              </td>
                      <td class="textoTitulo" width="17%">Percentual Juros: </td>
                      <td class="textoValor" width="26%"><%=borderoBean.getPercentualJurosDia().toString().equals("0,00 %")?"":borderoBean.getPercentualJurosDia().toString()%></td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr>
    									<td colspan="4">
			              		<table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                      		<tr>
			                      <td class="textoTitulo" width="20%">Mensagem Ficha de Compensação: </td>
			                      <td class="textoValor" width="80%" colspan="3">
	                         		<textarea name="msgFichaCompensacao" cols="40" rows="2" readonly><%=borderoBean.getMsgFichaCompensacao()%></textarea>
			                      </td>
                    			</tr>
                    		</table>
                    	</td>
                    </tr>		
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
									</table>
                </s:Outline>
							</td>
						</tr>

            <tr> 
	            <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
	            <td align="right" colspan="4">
  	            <p align="center"> 
                  <s:Button name="AlterarBordero" value="Alterar" action="javascript:formSubmit_AlterarBordero();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.alterar"/>
			            <s:Button name="ExcluirBordero" value="Excluir" action="javascript:formSubmit_ExcluirBordero();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.excluir"/>
		            	<s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
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
			}
	    
	    function formSubmit() {
		        document.frmMain.submit();
	    }

	    function validaSubmit() {
				return true;
			}

	    function formSubmit_AlterarBordero() {
        if (validaSubmit()) {
	        document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_ALTERAR%>';
	    		if (document.frmMain.situacao.value == 2){
	        	if (confirm(conf("138"))) {	
  		        document.frmMain.submit();
  	  	    }
  	  	  }
  	  	  else{
  	  	      document.frmMain.submit();
  	  	  }
        }
	    }	    
	    
	    function formSubmit_ExcluirBordero() {
        if (validaSubmit()) {
	    		if (document.frmMain.situacao.value == 1){
	    			if (confirm(conf("102", "Borderô"))) {	
		    			document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_EXCLUIR%>';
            	document.frmMain.submit();
            }
	    		}
	    		else if (document.frmMain.situacao.value == 2){
	    			if (confirm(conf("137", "Borderô"))) {	
		    			document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_EXCLUIR%>';
            	document.frmMain.submit();
            }
	    		}
	    	}
	    }	    
	    	    
	    function formSubmit_Voltar() {
        document.frmMain.estrategia.value = '<%=BorderoEstrategia.STRATEGY_MANTER_LISTAR%>';
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
      }  
    </script>
  </s:FormStrategy>
</p:Document>
</html>