<%
/***********************************************
*Projeto CAIXA - SIGCB DDA
*Componente: ddareimpbloqueto_consultar_titulo.jsp - Java Server Pages
*Criado em: 18/01/2010
*Autor: Glauber Gallego
************************************************/
%>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1); //previne o cache pelo proxy
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.DdaReimpBloquetoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.dda.DdaReimpBloquetoEstrategia"%>
	
<%
  DdaReimpBloquetoBean ddaReimpBloquetoBean = (session.getAttribute(DdaReimpBloquetoEstrategia.BEAN_TITULO)==null?
                                            new DdaReimpBloquetoBean():
                                            (DdaReimpBloquetoBean)session.getAttribute(DdaReimpBloquetoEstrategia.BEAN_TITULO));
%>
<%
  List instrucoesList = (session.getAttribute(DdaReimpBloquetoEstrategia.BEAN_TITULO_INSTRUCOES)==null?
		         new ArrayList():
		        (ArrayList)session.getAttribute(DdaReimpBloquetoEstrategia.BEAN_TITULO_INSTRUCOES));
%>

<html>
<s:HeaderPopup/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%DdaReimpBloquetoEstrategia.STRATEGY_INICIAR%>" 
		fluxo="normal">

<table width="650" border="0" bordercolor="black" cellspacing="0" cellpadding="1" align="center">
	<tr> 
		<td colspan="2" align="center">
			<a href="javascript: printPage()">
			<input type="text" name="printText" size="40" style="font-family: Arial; border-width:0px; font-weight: bold" value="Click aqui para imprimir o Documento:" disabled><img name="printGif" src="<%=Paths.getImagePath()%>/print.gif" border="0">
			</a>
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;
		</td>
	</tr>
    <tr> 
    	<td valign="top" width="95%" height="14" align="left" colspan="2"> 
        	<table class="box" width="100%" border="0 bordercolor="blue" cellspacing="0" cellpadding="1" valign="top" align="center">
		    <tr>
				<td>
					<table width="100%" height="65" border="0" bordercolor="green" cellspacing="0" cellpadding="0" valign="top" align="center">
						<tr> 
							<td rowspan="4" nowrap class="box_title_1" width="25%">
							  <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
						    &nbsp;<img name="caixa" src="<%=Paths.getImagePath()%>/caixa_nome.gif" border="0">
						    <%} else {%>
						    &nbsp;
						    <%}%>
						  </td>
						</tr>
						<tr> 
							<td rowspan="4" nowrap class="box_title_4" width="50%" align="left">
                <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
								COBRANÇA BANCÁRIA CAIXA
                <%} else {%>
                &nbsp;
                <%}%>
							</td>
						</tr>
						<tr>
							<td valign="middle">
								<table class="box_noborder" border="1" bordercolor="#005baa" cellpanding="0" cellspacing="0" valign="middle" align="center" width="200">
									<tr> 
										<td nowrap colspan="2" class="box_title_5" align="center">
                      <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
											Reclamações e Sugestões
			                <%} else {%>
			                &nbsp;
			                <%}%>
										</td>
									</tr>
									<tr> 
										<td nowrap class="box_title_5" width="15%" align="center">
                      <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
											DISQUE CAIXA
                      <%} else {%>
                      &nbsp;
                      <%}%>
										</td>
										<td nowrap class="box_title_5" width="15%" align="center">
                      <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
											0800 726 0101
                      <%} else {%>
                      &nbsp;
                      <%}%>
										</td>
									</tr>
									<tr> 
										<td nowrap class="box_title_5" width="15%" align="center">
                      <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
											OUVIDORIA
                      <%} else {%>
                      &nbsp;
                      <%}%>
										</td>
										<td nowrap class="box_title_5" width="15%" align="center">
                      <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
											0800 725 7474
                      <%} else {%>
                      &nbsp;
                      <%}%>
										</td>
									</tr>
									<tr> 
										<td nowrap class="box_title_5" width="15%" align="center" colspan="2">
                      <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
											www.caixa.gov.br
                      <%} else {%>
                      &nbsp;
                      <%}%>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>						          	
	          	</tr>
        	</table>
		</td>
	</tr>
    <tr>
		<td colspan = "2">
			<table class="box_notopborder" width="100%" border="0" bordercolor="red" cellspacing="0" cellpadding="1" valign="top" align="center">
				<tr>
					<td width="100%" colspan="3">
						<table width="100%" border="0" bordercolor="green" cellspacing="0" cellpadding="0" valign="middle" align="center">
							<tr>
								<td width="55%">
									<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
										<tr>
						          			<td nowrap class="box_subtitle_2">
						          				&nbsp;Cedente
						          			</td>
										</tr>
										<tr>
											<td class="box_fill">
						          				&nbsp;<%=ddaReimpBloquetoBean.getNomeCedente()%>
						          			</td>
										</tr>
									</table>
								</td>
								<td width="20%">
									<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
										<tr>
											<td nowrap class="box_subtitle_2">
						          					&nbsp;CPF / CNPJ
						          			</td>
										</tr>
										<tr>
											<td class="box_fill">
						          				&nbsp;<%=ddaReimpBloquetoBean.getCpfCnpjCedenteFormatado()%>
						          			</td>
										</tr>
									</table>
								</td>
								<td width="25%">
									<table class="box" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
										<tr>
											<td nowrap class="box_subtitle_2">
						          				&nbsp;Agência / Codigo do Cedente
						          			</td>
										</tr>
										<tr>
											<td class="box_fill">
						          				&nbsp;<%=ddaReimpBloquetoBean.getCodigoCedenteFormatado()%>
						          			</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td width="75%">
						<table class="box_notoprightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
							<tr>
			          			<td nowrap class="box_subtitle_2">
			          				&nbsp;Endereço do cedente
			          			</td>
							</tr>
							<tr>
								<td class="box_fill">
			          				&nbsp;<%=ddaReimpBloquetoBean.getEnderecoCedente()%><br/> 
                        &nbsp;<%=ddaReimpBloquetoBean.getMunicipioCedente()%>
			          			</td>
							</tr>
						</table>
					</td>
					<td width="10%">
						<table class="box_notoprightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
							<tr>
			          			<td nowrap class="box_subtitle_2">
			          				&nbsp;UF
			          			</td>
							</tr>
							<tr>
								<td class="box_fill" valign="top">
			          				&nbsp;<br>
			          				&nbsp;<%=ddaReimpBloquetoBean.getUfCedente()%>
			          			</td>
							</tr>
						</table>
					</td>
					<td width="15%">
						<table class="box_notopborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
							<tr>
								<td nowrap class="box_subtitle_2">
			          				&nbsp;CEP
			          			</td>
							</tr>
							<tr>
								<td class="box_fill">
			          				&nbsp;<br>
			          				&nbsp;<%=ddaReimpBloquetoBean.getCepCedenteFormatado()%>
			          			</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
		</tr>				
		<tr>
			<td width="100%" colspan="3">
				<table width="100%" border="0" bordercolor="green" cellspacing="0" cellpadding="0" valign="middle" align="center">
					<tr>
			    		<td width="15%">
				       		<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
				      				<td nowrap class="box_subtitle_2">
				       					&nbsp;Data do documento
			          				</td>
								</tr>
								<tr>
									<td class="box_fill">
			          					&nbsp;<%=ddaReimpBloquetoBean.getDataDocumentoFormatada()%>
			          				</td>
								</tr>
							</table>
						</td>
						<td width="20%">
							<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
									<td nowrap class="box_subtitle_2">
				     					&nbsp;Nº documento
				      				</td>
								</tr>
								<tr>
									<td class="box_fill">
				       					&nbsp;<%=ddaReimpBloquetoBean.getNumeroDocumento()%>
				       				</td>
								</tr>
							</table>
						</td>
						<td width="10%">
							<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
									<td nowrap class="box_subtitle_2">
										&nbsp;Espécie
						    		</td>
								</tr>
								<tr>
									<td class="box_fill">
						    			&nbsp;<%=ddaReimpBloquetoBean.getCodigoTipoEspecie()%>
						        	</td>
								</tr>
							</table>
						</td>
						<td width="10%">
							<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
									<td nowrap class="box_subtitle_2">
										&nbsp;Carteira
									</td>
								</tr>
								<tr>
									<td class="box_fill">
										&nbsp;<%=ddaReimpBloquetoBean.getCodigoTipoCarteira()%>
									</td>
								</tr>
							</table>
						</td>
						<td width="20%">
							<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
									<td nowrap class="box_subtitle_2">
						    			&nbsp;Data do processamento
						        	</td>
								</tr>
								<tr>
									<td class="box_fill">
						        		&nbsp;<%=ddaReimpBloquetoBean.getDataProcessamentoFormatada()%>
						        	</td>
								</tr>
							</table>
						</td>
						<td width="25%">
							<table class="box" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
									<td nowrap class="box_subtitle_2">
					   					&nbsp;Nosso Número
					   				</td>
								</tr>
								<tr>
									<td class="box_fill">
				       					&nbsp;<%=ddaReimpBloquetoBean.getNossoNumeroFormatado()%>
				       				</td>
								</tr>
							</table>
						</td>
		          	</tr>
				</table>
			</td>
		</tr>
		<tr>
	   		<td width="100%" colspan="3">
				<table width="100%" border="0" bordercolor="green" cellspacing="0" cellpadding="0" valign="middle" align="center">
					<tr>
						<td width="75%">
							<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
			          				<td nowrap class="box_subtitle_2">
			          					&nbsp;Sacado
			          				</td>
								</tr>
								<tr>
									<td class="box_fill">
			          					&nbsp;<%=ddaReimpBloquetoBean.getNomeSacado()%>
			          				</td>
								</tr>
							</table>
						</td>
						<td width="25%" colspan="2">
							<table class="box" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
									<td nowrap class="box_subtitle_2">
			          					&nbsp;CPF / CNPJ
			          				</td>
								</tr>
								<tr>
									<td class="box_fill">
			          					&nbsp<%=ddaReimpBloquetoBean.getCpfCnpjSacadoFormatado()%>
			          				</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<table class="box_notoprightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
			          				<td nowrap class="box_subtitle_2">
			          					&nbsp;Endereço do sacado
			          				</td>
								</tr>
								<tr>
									<td class="box_fill">
			          					&nbsp;<%=ddaReimpBloquetoBean.getEnderecoSacado()%><br/>
			          					&nbsp;<%=ddaReimpBloquetoBean.getMunicipioSacado()%>
			          				</td>
								</tr>
							</table>
						</td>
						<td width="10%">
							<table class="box_notoprightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
			          				<td nowrap class="box_subtitle_2">
			          					&nbsp;UF
			          				</td>
								</tr>
								<tr>
									<td class="box_fill" valign="top">
			          					&nbsp;<br>
			          					&nbsp;<%=ddaReimpBloquetoBean.getUfSacado()%>
			          				</td>
								</tr>
							</table>
						</td>
						<td width="15%">
							<table class="box_notopborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
									<td nowrap class="box_subtitle_2">
			          					&nbsp;CEP
			          				</td>
								</tr>
								<tr>
									<td class="box_fill">
			          					&nbsp;<br>
			          					&nbsp;<%=ddaReimpBloquetoBean.getCepSacadoFormatado()%>
			          				</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
       		<td width="100%" colspan="3">
				<table width="100%" border="0" bordercolor="green" cellspacing="0" cellpadding="0" valign="middle" align="center">
					<tr>
						<td width="75%">
							<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
			          				<td nowrap class="box_subtitle_2">
			          					&nbsp;Sacador/Avalista
			          				</td>
								</tr>
								<tr>
									<td class="box_fill">
			          					&nbsp;<%=ddaReimpBloquetoBean.getNomeSacador()%>
			          				</td>
			          			</tr>
							</table>
						</td>
						<td width="25%">
							<table class="box" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
									<td nowrap class="box_subtitle_2">
						    			&nbsp;CPF / CNPJ
						          	</td>
								</tr>
								<tr>
									<td class="box_fill">
						        		&nbsp;<%=ddaReimpBloquetoBean.getCpfCnpjSacadorFormatado()%>
						        	</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	    <tr>
			<td colspan="3">
				<table class="box" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
					<tr>
						<td nowrap class="box_subtitle_2">
							&nbsp;Texto de Responsabilidade do Cedente
						</td>
					</tr>
					<tr>
						<td class="box_fill">
<%						DdaReimpBloquetoBean occ = new DdaReimpBloquetoBean();
							int numeroLinhas = 0;
							for(int i=0; i<instrucoesList.size()&&i<18; i++) {
 								occ = (DdaReimpBloquetoBean) instrucoesList.get(i);
								numeroLinhas++;%>
					      &nbsp;
					      <%=occ.getInstrucao()%><br>
<%						}%>						          		
<%						for(int i=1; i < (18 - numeroLinhas) ; i++) {%>
						    &nbsp;<br>
<%						}%>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td width="100%" colspan="3">
				<table width="100%" border="0" bordercolor="green" cellspacing="0" cellpadding="0" valign="middle" align="center">
					<tr>
						<td width="8%">
							<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
				          		<tr>
				          			<td nowrap class="box_subtitle_2">
				          				&nbsp;Moeda
				          			</td>
				          		</tr>
				          		<tr>
				          			<td class="box_fill">
				          				&nbsp;<%=ddaReimpBloquetoBean.getNomeMoeda()%>
				          			</td>
				          		</tr>
				          	</table>
						</td>
						<td width="10%">
							<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
				          		<tr>
				          			<td nowrap class="box_subtitle_2">
				          				&nbsp;Quantidade
				          			</td>
				          		</tr>
				          		<tr>
				          			<td class="box_fill">
				          			  <% if (ddaReimpBloquetoBean.getCodigoMoeda().equals("09")) { %>
					                &nbsp;
					                <%} else {%>
					                &nbsp;<%=ddaReimpBloquetoBean.getValorTituloFormatadoComoQuantidade()%>
					                <%}%>
				          			</td>
				          		</tr>
				          	</table>
						</td>
						<td width="12%">
							<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
				          		<tr>
				          			<td nowrap class="box_subtitle_2">
				          				&nbsp;Valor
				          			</td>
				          		</tr>
				          		<tr>
				          			<td class="box_fill">
				          				&nbsp;
				          			</td>
				          		</tr>
				          	</table>
						</td>
						<td width="15%">
							<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
				          		<tr>
				          			<td nowrap class="box_subtitle_2">
				          				&nbsp;<b>Vencimento</b>
				          			</td>
				          		</tr>
				          		<tr>
				          			<td class="box_fill">
				          				&nbsp;<%=ddaReimpBloquetoBean.getDataVencimentoFormatada()%>
				          			</td>
				          		</tr>
				          	</table>
						</td>
						<td width="15%">
							<table class="box_norightborder" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
				          		<tr>
				          			<td nowrap class="box_subtitle_2">
				          				&nbsp;<b>Valor do Documento</b>
				          			</td>
				          		</tr>
				          		<tr>
				          			<td class="box_fill">
                          <% if (ddaReimpBloquetoBean.getCodigoMoeda().equals("09")) { %>
                          &nbsp;<%=ddaReimpBloquetoBean.getValorTitulo()%>
                          <%} else {%>
                          &nbsp;
                          <%}%>
                          
				          			</td>
				          		</tr>
				          	</table>
						</td>
		          		<td width="40%">
							<table class="box" width="100%" border="0" bordercolor="pink" cellspacing="0" cellpadding="0" valign="middle" align="center">
					          	<tr>
				          			<td nowrap class="box_subtitle_2">
				          				&nbsp;Autenticação Mecânica - <b>Recibo do Sacado</b>
				          			</td>
				          		</tr>
				          		<tr>
				          			<td class="box_fill">
				          				&nbsp;
				          			</td>
				          		</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" valign="top" align="center">
					<tr>
						<td nowrap class="box_subtitle_3">
							Recebimento através do cheque n.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; do Banco &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            .
							<br>Esta quitação só terá validade após pagamento do cheque pelo Banco Sacado.
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
  		<td colspan="2">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" valign="top" align="center">
        	<tr>
         		<td>
							<table class="box_notopleftborder" width="100%" height="41" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
          			<tr> 
					    		<td nowrap class="box_title_1" width="25%">
                    <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
			          		<img name="caixa" src="<%=Paths.getImagePath()%>/caixa_nome.gif" border="0">
                    <%} else {%>
                    &nbsp;
                    <%}%>
  		          	</td>
			          </tr>
							</table>
						</td>						          	
			      <td>
							<table class="box_notopleftborder" width="100%" height="41" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
					    	<tr> 
				        	<td nowrap class="box_title_2" width="20%" align="center">
                    <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
			          		104-0
                    <%} else {%>
                    &nbsp;
                    <%}%>
			          	</td>
								</tr>
					    </table>
						</td>						          	
          	<td>
							<table class="box_notoprightborder" width="100%" height="41" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						    <tr> 
				        	<td nowrap class="box_title_3" width="55%" align="right">
                    <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
								    <%=ddaReimpBloquetoBean.getCodigoBarrasFormatado()%>
                    <%} else {%>
                    &nbsp;
                    <%}%>
				          </td>
								</tr>
							</table>
 						</td>						          	
					</tr>
				</table>
			</td>
		</tr>
	 <tr>
		<td width="75%">
			          <table width="100%" border="0" bordercolor="green" cellspacing="0" cellpadding="0" valign="top" align="center">
			          	<tr>
			          		<td width="75%">
						          <table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						          	<tr>
						          		<td nowrap class="box_subtitle_2">
						          		  &nbsp;Local de Pagamento
						          		</td>
						          	</tr>
						          	<tr>
						          		<td nowrap class="box_fill">
						          			&nbsp;PREFERENCIALMENTE NAS CASAS LOTERICAS ATÉ O VALOR LIMITE&nbsp;
						          		</td>
						          	</tr>
						          </table>
			          		</td>
			          	</tr>
			          	<tr>
						<td width="75%">
							<table width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr>
									<td width="55%">
										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
											<tr>
						      					<td nowrap class="box_subtitle_2">
						      						&nbsp;Cedente
						      					</td>
											</tr>
											<tr>
												<td class="box_fill">
													&nbsp;<%=ddaReimpBloquetoBean.getNomeCedente()%>
												</td>
											</tr>
										</table>
									<td width="20%">
										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
											<tr>
								      			<td nowrap class="box_subtitle_2">
						      						&nbsp;CPF / CNPJ
						      					</td>
											</tr>
											<tr>
												<td class="box_fill">
						      			     			&nbsp;<%=ddaReimpBloquetoBean.getCpfCnpjCedenteFormatado()%>
						      					</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
			        <tr>
			        	<td width="75%">
							<table width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						    	<tr>
						        	<td width="20%">
										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									    	<tr>
									        	<td nowrap class="box_subtitle_2">
									          		&nbsp;Data do Documento
									          	</td>	
											</tr>
									        <tr>
									        	<td class="box_fill">
									          		&nbsp;<%=ddaReimpBloquetoBean.getDataDocumentoFormatada()%>
									          	</td>
											</tr>
										</table>
						          	</td>
						          	<td width="17%">
										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									   		<tr>
									        	<td nowrap class="box_subtitle_2">
									          		&nbsp;No. do Documento
									          	</td>
											</tr>
									        <tr>
									        	<td class="box_fill">
									        		&nbsp;<%=ddaReimpBloquetoBean.getNumeroDocumento()%>
									        	</td>
									        </tr>
										</table>
						          	</td>
						          	<td width="9%">
										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									    	<tr>
									        	<td nowrap class="box_subtitle_2">
									          		&nbsp;Espécie
									          	</td>
											</tr>
									        <tr>
									        	<td class="box_fill">
									          		&nbsp;<%=ddaReimpBloquetoBean.getCodigoTipoEspecie()%>
									          	</td>
											</tr>
										</table>
						          	</td>
						         	<td width="8%">
										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									      	<tr>
									      		<td nowrap class="box_subtitle_2">
									       			&nbsp;Aceite
									       		</td>
									       	</tr>
									       	<tr>
									       		<td class="box_fill">
									       			&nbsp; <%=ddaReimpBloquetoBean.getDescricaoTipoAceite()%>
									       		</td>
									       	</tr>
									    </table>
						          	</td>
						          	<td width="20%">
										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									    	<tr>
									    		<td nowrap class="box_subtitle_2">
									          		&nbsp;Data de Processamento
									          	</td>
											</tr>
									        <tr>
									        	<td class="box_fill">
									        		&nbsp; 
									        		<%=ddaReimpBloquetoBean.getDataProcessamentoFormatada()%>
									        	</td>
											</tr>
										</table>
						        	</td>
						          </tr>
						      </table>
			          		</td>
			          	</tr>
			          	<tr>
			          		<td width="75%">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									<tr>
						      			<td width="20%">
											<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
												<tr>
									          		<td nowrap class="box_subtitle_2">
									          			&nbsp;Uso do Banco
									          		</td>	
									          	</tr>
									          	<tr>
									          		<td class="box_fill">
									          			&nbsp;
									          		</td>
									          	</tr>
											</table>
						          		</td>
						          		<td width="9%">
											<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									      		<tr>
									          		<td nowrap class="box_subtitle_2">
									          			&nbsp;Carteira
									          		</td>
									          	</tr>
									          	<tr>
									          		<td class="box_fill">
									          			&nbsp;<%=ddaReimpBloquetoBean.getCodigoTipoCarteira()%>
									          		</td>
									          	</tr>
											</table>
						          		</td>
						          		<td width="8%">
									      	<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									      		<tr>
									          		<td nowrap class="box_subtitle_2">
									          			&nbsp;Moeda
									          		</td>
									          	</tr>
									          	<tr>
									          		<td class="box_fill">
									          			&nbsp;<%=ddaReimpBloquetoBean.getNomeMoeda()%>
									          		</td>
									          	</tr>
											</table>
						          		</td>
						          		<td width="17%">
											<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									      		<tr>
									          		<td nowrap class="box_subtitle_2">
									          			&nbsp;Quantidade
									          		</td>
									          	</tr>
									          	<tr>
									          		<td class="box_fill">
                            <% if (ddaReimpBloquetoBean.getCodigoMoeda().equals("09")) { %>
                            &nbsp;
                            <%} else {%>
                            &nbsp;<%=ddaReimpBloquetoBean.getValorTituloFormatadoComoQuantidade()%>
                            <%}%>
									          		</td>
									          	</tr>
											</table>
						          		</td>
						          		<td width="20%">
											<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
												<tr>
									          		<td nowrap class="box_subtitle_2">
									          			&nbsp;Valor
									          		</td>
									          	</tr>
									          	<tr>
									          		<td class="box_fill">
									          			&nbsp;
									          		</td>
									          	</tr>
									      	</table>
						          		</td>
									</tr>
								</table>
							</td>
						</tr>
			          	<tr>
							<td width="75%">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						      		<tr>
						          		<td>
											<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									      		<tr>
									          		<td nowrap class="box_subtitle_2">
									          			&nbsp;Texto de Responsabilidade do Cedente
									          		</td>	
									          	</tr>
									          	<tr>
													<td class="box_fill">
							<%            occ = new DdaReimpBloquetoBean();
							              numeroLinhas = 0;
							              for(int i=0; i<instrucoesList.size()&&i<10; i++) {
							                occ = (DdaReimpBloquetoBean) instrucoesList.get(i);
							                numeroLinhas++;%>
							                &nbsp;
							                <%=occ.getInstrucao()%><br>
							<%            }%>                         
							<%            for(int i=1; i < (10 - numeroLinhas) ; i++) {%>
							                &nbsp;<br>
							<%            }%>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
			          		</td>
			          	</tr>
					</table>
				</td>
				<td width="25%">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" valign="top" align="center">
						<tr>
			          		<td>
								<table class="box_notoprightborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						      		<tr>
						          		<td nowrap class="box_subtitle_2">
						          			&nbsp;Vencimento
						          		</td>
						          	</tr>
						          	<tr>
						          		<td class="box_fill">
						          			&nbsp;<%=ddaReimpBloquetoBean.getDataVencimentoFormatada()%>
						          		</td>
						          	</tr>
								</table>
			          		</td>
			          	</tr>
			          	<tr>
			          		<td>
								<table class="box_notoprightborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						      		<tr>
						          		<td nowrap class="box_subtitle_2">
						          			&nbsp;Agência / Código Cedente
						          		</td>
						          	</tr>
						          	<tr>
						          		<td class="box_fill">
						          			&nbsp;<%=ddaReimpBloquetoBean.getCodigoCedenteFormatado()%>
						          		</td>
						          	</tr>
								</table>
			          		</td>
			          	</tr>
			          	<tr>
			          		<td>
								<table class="box_notoprightborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						      		<tr>
						          		<td nowrap class="box_subtitle_2">
						          			&nbsp;Nosso Número
						          		</td>
						          	</tr>
						          	<tr>
						          		<td class="box_fill">
						          			&nbsp;<%=ddaReimpBloquetoBean.getNossoNumeroFormatado()%>
						          		</td>
						          	</tr>
								</table>
			          		</td>
			          	</tr>
			          	<tr>
			          		<td>
								<table class="box_notoprightborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									<tr>
						          		<td nowrap class="box_subtitle_2">
						          			&nbsp;(=) Valor do Documento
						          		</td>
						          	</tr>
						          	<tr>
						          		<td class="box_fill">
	                          <% if (ddaReimpBloquetoBean.getCodigoMoeda().equals("09")) { %>
	                          &nbsp;<%=ddaReimpBloquetoBean.getValorTitulo()%>
	                          <%} else {%>
	                          &nbsp;
	                          <%}%>
						          		</td>
						          	</tr>
								</table>
			          		</td>
			          	</tr>
			          	<tr>
			          		<td>
								<table class="box_notoprightborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						      		<tr>
						          		<td nowrap class="box_subtitle_2">
						          			&nbsp;(-) Desconto
						          		</td>
						          	</tr>
						          	<tr>
						          		<td class="box_fill">
						          			&nbsp;
						          		</td>
						          	</tr>
								</table>
			          		</td>
			          	</tr>
			          	<tr>
			          		<td>
						      	<table class="box_notoprightborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						      		<tr>
						          		<td nowrap class="box_subtitle_2">
						          			&nbsp;(-) Outras Deduções/Abatimento
						          		</td>
						          	</tr>
						          	<tr>
						          		<td class="box_fill">
						          			&nbsp;
						          		</td>
						          	</tr>
								</table>
			          		</td>
			          	</tr>
			          	<tr>
			          		<td>
								<table class="box_notoprightborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
									<tr>
						          		<td nowrap class="box_subtitle_2">
						          			&nbsp;(+) Mora/Multa/Juros
						          		</td>
						          	</tr>
						          	<tr>
						          		<td class="box_fill">
						          			&nbsp;
						          		</td>
						          	</tr>
								</table>
			          		</td>
			          	</tr>
			          	<tr>
							<td>
				          		<table class="box_notoprightborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						      		<tr>
						          		<td nowrap class="box_subtitle_2">
						          			&nbsp;(+) Outros Acréscimos
						          		</td>
						          	</tr>
						          	<tr>
						          		<td class="box_fill">
						          			&nbsp;
						          		</td>
						          	</tr>
								</table>
							</td>
			          	</tr>
			          	<tr>
							<td>
								<table class="box_notoprightborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						      		<tr>
						          		<td nowrap class="box_subtitle_2">
						          			&nbsp;(=) Valor Cobrado
						          		</td>
						          	</tr>
						          	<tr>
						          		<td class="box_fill">
						          			&nbsp;
						          		</td>
						          	</tr>
								</table>
			          		</td>
			          	</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan = "2">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" valign="top" align="center">
			      		<tr>
			          		<td> 
							<table class="box_bottomborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						      	<tr>
									<td nowrap class="box_subtitle_2" colspan="1%" valign="top">
						          		&nbsp;Sacado:<br>
						          	</td>
								</tr>
						        <tr>	
						        	<td class="box_fill" colspan="99%">
						          		&nbsp;
						          		<%=ddaReimpBloquetoBean.getNomeSacado()%> - 
						          		<%=(ddaReimpBloquetoBean.getTipoPessoaSacado().equals(new Long(1))?"CPF: " : "CNPJ: ")%> 
						          		<%=ddaReimpBloquetoBean.getCpfCnpjSacadoFormatado()%><br>
						          		&nbsp;
						          		<%=ddaReimpBloquetoBean.getEnderecoSacado()%><br> 
										      &nbsp;
										      <%=ddaReimpBloquetoBean.getMunicipioSacado()%> - 
										      <%=ddaReimpBloquetoBean.getUfSacado()%> - 
										      CEP:<%=ddaReimpBloquetoBean.getCepSacadoFormatado()%><br>
						          	</td>
								</tr>
							</table>	
							<table class="box_bottomborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">						          	
						    	<tr>
						        	<td nowrap class="box_subtitle_2" colspan="1%" valign="top">
						          		&nbsp;Sacador/Avalista:
						          	</td>
						 		</tr>
						        <tr>	
						       		<td nowrap class="box_fill" colspan="99%">
												&nbsp;<%=ddaReimpBloquetoBean.getNomeSacador()%> 
												<%=(ddaReimpBloquetoBean.getTipoPessoaSacador().equals(new Long(1)) ?"- CPF: " :ddaReimpBloquetoBean.getTipoPessoaSacador().equals(new Long(2))?"- CNPJ: ":"")%> 
												<%=ddaReimpBloquetoBean.getCpfCnpjSacadorFormatado()%><br>
  				          	</td>
								</tr>
							</table>
			         	</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan = "2">	
				<table width="100%" border="0" cellspacing="0" cellpadding="0" valign="top" align="center">
        	<tr>
         		<td> 
							<table class="box_dotbottomborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
								<tr> 
      						<td colspan="4">
                    <%if (ddaReimpBloquetoBean.getCodigoBancoCedente().equals(104L)) { %>   
			            	<s:BarCode imagePath="<%=Paths.getImagePath()%>" code="<%=ddaReimpBloquetoBean.getCodigoBarrasNumerico()%>"/>
                    <%} else {%>
                    &nbsp;
                    <%}%>
       						</td>
			          	<td nowrap class="box_subtitle_2" width="25%">
			          		&nbsp;Ficha de Compensação<br>
			          		&nbsp;Autenticação no verso
			          	</td>
								</tr>
							</table>
          	</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td align="center" colspan = "2">
				<a href="javascript: printPage()">
				<input type="text" name="printText1" size="40" style="font-family: Arial; border-width:0px; font-weight: bold" value="Click aqui para imprimir o Documento:" disabled><img name="printGif1" src="<%=Paths.getImagePath()%>/print.gif" border="0">
				</a>
			</td>
		</tr>
	</table>
    
<script language="javascript">

	function printPage() {
		document.frmMain.printText.value = "";
		document.frmMain.printGif.src="<%=Paths.getImagePath()%>/transparente.gif";
		
		document.frmMain.printText1.value = "";
		document.frmMain.printGif1.src="<%=Paths.getImagePath()%>/transparente.gif";
		
		print();
	}
			
</script>

</s:FormStrategy>
</p:Document>
</html>