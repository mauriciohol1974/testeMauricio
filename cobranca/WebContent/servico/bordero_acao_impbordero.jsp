<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bordero_acao_impbordero.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 18/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoTituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BorderoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="br.com.politec.sao.business.util.BeanList"%>
<%@page import="java.util.List"%>


<%
	BorderoBean borderoBean = (session.getAttribute(BorderoEstrategia.DATA_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(BorderoEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BorderoEstrategia.CEDENTE_CABECALHO_BEAN));
	BorderoTituloBean borderoTituloBean = (session.getAttribute(TituloEstrategia.FIXO_BEAN)==null?new BorderoTituloBean():(BorderoTituloBean)session.getAttribute(TituloEstrategia.FIXO_BEAN));
	//PageHolder listaTitulo = (PageHolder) session.getAttribute(BorderoEstrategia.LISTA_TITULO);
	//List lista = (List)listaTitulo.getPageable();	
	List lista = (List)session.getAttribute(BorderoEstrategia.LISTA_TITULO);	
	
%>

<html>
<s:HeaderPopup/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="" fluxo="normal">
    <table width="875" border="0" cellspacing="0" cellpadding="0" align="center"> 
			<tr> 
				<td align="left">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript: printPage()">
						<input type="text" name="printText1" size="97" style="font-family: Arial; border-width:0px; font-weight: bold" value="Click aqui para imprimir o Documento (ATENÇÃO: configure o browser para formato paisagem):" disabled><img name="printGif1" src="<%=Paths.getImagePath()%>/print.gif" border="0">
					</a>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
			</tr>
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">

	          <tr> <!-- header: logo + title -->
	          	<td>
			          <table class="box" width="100%" border="0" cellspacing="0" cellpadding="0" valign="top" align="center">
			          	<tr> <!-- title -->
			          		<td> <!--title col 1--> 
						          <table width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						          	<tr> 
						          		<td nowrap class="box_title_1" width="25%">
						          			&nbsp;<img name="caixa" src="<%=Paths.getImagePath()%>/caixa_nome.gif" border="0">
						          		</td>
						          	</tr>
						          </table>
										</td>						          	
			          		<td> <!--title col 2--> 
						          <table width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						          	<tr> 
						          		<td nowrap class="box_title_2" width="20%" align="center">
						          			&nbsp;Impressão do Borderô On Line
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
			          <table class="box" width="100%" border="0" cellspacing="0" cellpadding="5" valign="top" align="center">
			          	
			          	<tr> <!-- dados bordero: header -->
			          		<td>
						          <table class="box" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						            <tr>
  						          	<td>
  				          				<table width="100%" border="0" cellspacing="0" cellpadding="0" valign="top" align="center">
  				          				
  				          					<tr> <!--linha 1 -->
  				          						<td>
  							          				<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  							          					<tr>
  							          						<td nowrap class="box_subtitle_2" width="10%">
  							          							&nbsp;Cedente
  							          						</td>
  							          						<td nowrap class="box_subtitle_2" width="40%">
  				          										&nbsp;Nome Cedente
  				          									</td>
  				          									<td nowrap class="box_subTitle_2" width="20%">
  				          										&nbsp;Tipo Pessoa
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="30%">
  				          										&nbsp;CPF / CNPJ
  				          									</td>
  							          					</tr>
  							          					<tr>
  							          						<td class="box_fill2" width ="10%">
  							          							&nbsp;<%=borderoBean.getCodigoCedenteFormatado()%>
  							          						</td>
  							          						<td class="box_fill2" width ="40%">
  				          										&nbsp;<%=cedCabBean.getNomeFantasia()%>
  				          									</td>
  				          									<td class="box_fill2" width ="20%">
  				          										&nbsp;<%=cedCabBean.getTipoPessoaTexto()%>
  				          									</td>
  				          									<td class="box_fill2" width ="30%">
  				          										&nbsp;<%=cedCabBean.getCpfCnpjFormatado()%>
  				          									</td>
  							          					</tr>
  							          				</table>
  				          						</td>
  				          					</tr>
  				          					
  				          					<tr> <!-- linha 2-->
  				          						<td>
  							          				<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  							          					<tr>
  							          						<td nowrap class="box_subtitle_2" width="15%">
  							          							&nbsp;Borderô
  							          						</td>
  							          						<td nowrap class="box_subtitle_2" width="15%">
  				          										&nbsp;Código Cliente
  				          									</td>
  				          									<td nowrap class="box_subTitle_2" width="10%">
  				          										&nbsp;Somente p/ protesto
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;Modalidade Titulo
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;Data do Movimento
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;PV de Vinculação
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;Quantidade
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;Aceite
  				          									</td>			          									
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;Protesto Aut.
  				          									</td>
  							          					</tr>
  
  							          					<tr>
  							          						<td class="box_fill2" width ="15%">
  							          							&nbsp;<%=borderoBean.getCodigoBordero()%>
  							          						</td>
  							          						<td class="box_fill2" width ="15%">
  				          										&nbsp;<%=cedCabBean.getCodigoClienteCOCLI()%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getSomenteProtesto().equals("S")?"SIM":"NAO"%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getModalidadeTituloTexto()%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getDataMovimentoFormatada()%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getVinculacaoPVFormatado()%>
  				          									</td>			          									
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getQuantidade()%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getAceiteTexto()%>
  				          									</td>			          									
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getProtestoAutomatico().equals("S")?"SIM":"NAO"%>
  				          									</td>
  							          					</tr>
  							          				</table>
  				          						</td>
  				          					</tr>
  				          				  								
  					       						<tr> <!-- linha 3-->
  				          						<td>
  							          				<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  							          					<tr>						          									          												          									
  				          									<td nowrap class="box_subtitle_2" width="15%">
  				          										&nbsp;Valor
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;Endosso
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;Espécie de Título
  				          									</td>			          									
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;Prazo de Protesto
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;Emissão Boleto
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;Envio Boleto
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;Tipo de Juros 
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="10%">
  				          										&nbsp;% Juros 
  				          									</td>
  				          									<td nowrap class="box_subtitle_2" width="15%">
  				          										&nbsp;Moeda
  				          									</td>
  							          					</tr>
  	
  							          					<tr>
  				          									<td class="box_fill2" width ="15%">
  				          										&nbsp;<%=borderoBean.getValor()%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getEndosso().equals("S")?"SIM":"NAO"%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getEspecieTituloTexto()%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getPrazoProtDevol()%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getEmissaoBloquetoTexto()%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getEnvioBloquetoTexto()%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getTipoJurosDiaTexto()%>
  				          									</td>
  				          									<td class="box_fill2" width ="10%">
  				          										&nbsp;<%=borderoBean.getPercentualJurosDia()%>
  				          									</td>
  				          									<td class="box_fill2" width ="15%">
  				          										&nbsp;<%=borderoBean.getMoedaTexto()%>
  				          									</td>
  							          					</tr>
  							          				</table>
  				          						</td>
  				          					</tr>
  				          								          						
  														<tr> <!-- linha 4-->	
  				          						<td>
  							          				<table width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  							          					<tr>
  							          						<td nowrap class="box_subtitle_1" width="12%">
  				          										&nbsp;Descontos 1<br>
  				          										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  				          											<tr>
  				          												<td nowrap class="box_subtitle_2" width="100%">
  				          													&nbsp;Percentual
  							          									</td>
  				          											</tr>
  				          											<tr>
  				          												<td class="box_fill2" width ="100%">
  				          													&nbsp;<%=borderoBean.getPercentualDesconto1()%>
  				          												</td>
  				          											</tr>
  				          										</table>
  				          									</td>
  	
  				          									<td nowrap class="box_subtitle_1" width="12%">
  				          										&nbsp;Prazo Limite 1<br>
  				          										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  				          											<tr>
  				          												<td nowrap class="box_subtitle_2" width="100%">
  				          													&nbsp;Dias
  							          									</td>
  				          											</tr>
  				          											<tr>
  				          												<td class="box_fill2" width ="100%">
  				          													&nbsp;<%=borderoBean.getPrazoLimite1Dia()%>
  				          												</td>
  				          											</tr>
  				          										</table>
  				          									</td>
  				          									
  				          									<td nowrap class="box_subtitle_1" width="12%">
  				          										&nbsp;Descontos 2<br>
  				          										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  				          											<tr>
  				          												<td nowrap class="box_subtitle_2" width="100%">
  				          													&nbsp;Percentual
  							          									</td>
  				          											</tr>
  				          											<tr>
  				          												<td class="box_fill2" width ="100%">
  				          													&nbsp;<%=borderoBean.getPercentualDesconto2()%>
  				          												</td>
  				          											</tr>
  				          										</table>
  				          									</td>
  				          									
  				          									<td nowrap class="box_subtitle_1" width="12%">
  				          										&nbsp;Prazo Limite 2<br>
  				          										<Table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  				          											<tr>
  				          												<td nowrap class="box_subtitle_2" width="100%">
  				          													&nbsp;Dias
  							          									</td>
  				          											</tr>
  				          											<tr>
  				          												<td class="box_fill2" width ="100%">
  				          													&nbsp;<%=borderoBean.getPrazoLimite2Dia()%>
  				          												</td>
  				          											</tr>
  				          										</table>
  				          									</td>
  	
  				          									<td nowrap class="box_subtitle_1" width="12%">
  				          										&nbsp;Descontos 3<br>
  				          										<Table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  				          											<tr>
  				          												<td nowrap class="box_subtitle_2" width="100%">
  				          													&nbsp;Percentual
  							          									</td>
  				          											</tr>
  				          											<tr>
  				          												<td class="box_fill2" width ="100%">
  				          													&nbsp;<%=borderoBean.getPercentualDesconto3()%>
  				          												</td>
  				          											</tr>
  				          										</table>
  				          									</td>
  				          									
  				          									<td nowrap class="box_subtitle_1" width="12%">
  				          										&nbsp;Prazo Limite 3
  				          										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  				          											<tr>
  				          												<td nowrap class="box_subtitle_2" width="100%">
  				          													&nbsp;Dias
  							          									</td>
  				          											</tr>
  				          											<tr>
  				          												<td class="box_fill2" width ="100%">
  				          													&nbsp;<%=borderoBean.getPrazoLimite3Dia()%>
  				          												</td>
  				          											</tr>
  				          										</table>
  				          									</td>
  				          									<td nowrap class="box_subtitle_1" width="14%">
  				          										&nbsp;Multa<br>
  				          										<Table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  				          											<tr>
  				          												<td nowrap class="box_subtitle_2" width="100%">
  				          													&nbsp;&nbsp;
  							          									</td>
  				          											</tr>
  				          											<tr>
  				          												<td class="box_fill2" width ="100%">
  				          													&nbsp;<%=borderoBean.getMultaPercentual().toString().equals("0,00 %")?"":borderoBean.getMultaPercentual().toString()%>
  				          												</td>
  				          											</tr>
  				          										</table>
  				          									</td>
  				          									<td nowrap class="box_subtitle_1" width="14%">
  				          										&nbsp;Prazo Multa
  				          										<table class="box_notopleftborder" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  				          											<tr>
  				          												<td nowrap class="box_subtitle_2" width="100%">
  				          													&nbsp;Dias
  							          									</td>
  				          											</tr>
  				          											<tr>
  				          												<td class="box_fill2" width ="100%">
  				          													&nbsp;<%=borderoBean.getPrazoMultaDias().equals(new Long(0))?"":borderoBean.getPrazoMultaDias().toString()%>
  				          												</td>
  				          											</tr>
  				          										</table>
  				          									</td>
  							          					</tr>						          					
  							          				</table>
  				          						</td>	
  				          					</tr>      
  	
  								          	<tr> <!-- linha 5 -->
  				    				      		<td>
  								        			  <table width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  											          	<tr>
  											          	  <!-- line 5 col 1 -->
  											          		<td width="5%">
  														          <table width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
  											          				<tr>
  														          		<td nowrap class="box_subtitle_2">
  														          			&nbsp;Mensagem de Ficha de Compensação
  														          		</td>	
  														          	</tr>
  											          				<tr>
  														          		<td class="box_fill2">
  									          			          &nbsp;<%=borderoBean.getMsgFichaCompensacaoL1()%><br>
  														          			&nbsp;<%=borderoBean.getMsgFichaCompensacaoL2()%>
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
											</table>
										</td>
			          	</tr>

			          	<tr> <!--dados bordero: titulos -->
			          		<td>
						          <table width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
							        	<tr>
													<td>
							          		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" valign="middle">
											 							<%
																				BorderoTituloBean occ = new BorderoTituloBean();
																				for ( int i = 0; i < lista.size(); i++ ) {	
																					occ = (BorderoTituloBean)lista.get(i);
																		%>
												    	<tr>
											    			<td>
											    		   	<table border="0" width ="100%">		
																		<tr class="line1">
															   			<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;N/Doc.</td>
															   			<td nowrap class="box_fill2" width="15%" align="left"><%=occ.getNumeroDocumento()%></td>
			 												   			<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;NossoNum.</td>
			 												   			<td nowrap class="box_fill2" width="15%" align="left"><%=occ.getNossoNumero().toString()%></td>
														   				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;dt.Venc</td>
														   				<td nowrap class="box_fill2" width="10%" align="left"><%=occ.getDataVencimentoFormatada()%></td>
														   				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;dt.Emis</td>
														   				<td nowrap class="box_fill2" width="10%" align="left"><%=occ.getDataDocumentoFormatada()%></td>											    			
															   			<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;Vlr.Tit</td>
															   			<td nowrap class="box_fill2" width="15%" align="left"><%=occ.getValorTitulo()%></td>
														   				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;CPF/CNPJ</td>
														   				<td nowrap class="box_fill2" width="15%" align="left"><%=occ.getCpfCnpjSacadoFormatado()%></td>
													    				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;NomeSac.</td>
													    				<td nowrap class="box_fill2" width="20%" align="left"><%=occ.getNomeSacado()%></td>
														   			</tr>
														   		</table>
														   	</td>
														  </tr>
														  <tr>
														   	<td>
											    		   	<table border="0" width ="100%">		
														   			<tr class="line1">
															   			<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;E-mail</td>
															   			<td nowrap class="box_fill2" width="15%" align="left"><%=occ.getEmailSacado()%></td>
														   				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;CEP</td>
														   				<td nowrap class="box_fill2" width="10%" align="left"><%=occ.getCepSacadoFormatado()%></td>
														   				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;UF</td>		
														   				<td nowrap class="box_fill2" width="5%" align="left"><%=occ.getUfSacado()%></td>
															   			<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;End.</td>
															   			<td nowrap class="box_fill2" width="20%" align="left"><%=occ.getEnderecoSacado()%></td>
															   			<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;Num.</td>		
															   			<td nowrap class="box_fill2" width="5%" align="left"><%=occ.getNumeroSacado()%></td>
													    				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;Comp.</td>	
													    				<td nowrap class="box_fill2" width="20%" align="left"><%=occ.getComplSacado()%></td>
														   			</tr>
														   		</table>
														   	</td>
														  </tr>
														  <tr>
														   	<td>
											    		   	<table border="0" width ="100%">		
														   			<tr class="line1">														   																   				
													    				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;Bairro</td>
													    				<td nowrap class="box_fill2" width="10%" align="left"><%=occ.getBairroSacado()%></td>
														   				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;Municipio</td>
														   				<td nowrap class="box_fill2" width="10%" align="left"><%=occ.getMunicipioSacado()%></td>
														   				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;Sacador</td>
														   				<td nowrap class="box_fill2" width="10%" align="left"><%=occ.getNomeSacadorAvalista()%></td>
														   				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;CPF/CNPJScdr</td>
														   				<td nowrap class="box_fill2" width="15%" align="left"><%=occ.getCpfCnpjSacadorFormatado()%></td>
														   			    <td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;DDD/Celular</td>
														   				<td nowrap class="box_fill2" width="10%" align="left"><%=occ.getDddSMS()%>-<%=occ.getCelularSMS()%></td>		    				
														   			</tr>
														   		</table>
												    		</td>
											    	  </tr>
											    	  <tr>
														   	<td>
											    		   	<table border="0" width ="100%">			
														   			<tr class="line1">														   																   				
													    				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;Tipo de Pagamento </td>
													    				<td nowrap class="box_fill2" width="10%" align="left"><%=occ.getTipoPgto()%>
													    				<%=occ.getTipoPgto().equals("1") ? "Aceita qualquer valor" : "" %>
																		<%=occ.getTipoPgto().equals("2") ? "Aceita valores entre range mínimo e máximo" : "" %>
																		<%=occ.getTipoPgto().equals("3") ? "Não aceita valor divergente" : "" %>
																		<%=occ.getTipoPgto().equals("4") ? "Aceita valores considerando apenas o valor mínimo" : "" %>
													    				
													    				</td>
														   				<td nowrap class="box_subtitle_2" width="5%" align="left">&nbsp;Indicador Registro na CIP</td>
														   				<td nowrap class="box_fill2" width="10%" align="left"><%=occ.getIndRegCip().equals("S")?"SIM":"NÃO"%></td>
														   					    				
														   			</tr>
														   		</table>
												    		</td>
											    	  </tr>
											    	  <tr>
														   	<td>
											    		   	<table class="box_dotbottomborder" border="0" width ="100%">		
														   			<tr class="line1">														   																   				
													    				
														   				<td nowrap class="box_subtitle_2" width="20%" align="left">&nbsp;Valor Máximo Pagamento</td>
														   				<td nowrap class="box_fill2" width="10%" align="left"><%=occ.getValorMaxPgto()%></td>
														   				<td nowrap class="box_subtitle_2" width="20%" align="left">&nbsp;Valor Mínimo Pagamento</td>
														   				<td nowrap class="box_fill2" width="10%" align="left"><%=occ.getValorMinPgto()%></td>
														   			    <td nowrap class="box_subtitle_2" width="20%" align="left">&nbsp;Autoriza Pagamento Parcial/Divergente</td>
														   				<td nowrap class="box_fill2" width="5%" align="left"><%=occ.getIcParcial().equals("S")?"SIM":"NÃO"%></td>		 
														   				<td nowrap class="box_subtitle_2" width="20%" align="left">&nbsp;Qtde. Pagamentos Possíveis </td>
														   				<td nowrap class="box_fill2" width="5%" align="left"><%=occ.getQtdePossivel()%></td>		   				
														   			</tr>
														   		</table>
												    		</td>
											    	  </tr>
											    	  
											<%  } %>
	 							  				  </table>
									  			</td>
									  		</tr>
								  		</table>
									  </td>
									</tr>
						      
									<tr>
					          <td> <!-- dados bordero: footer -->
					          	<table class="box" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						          	<tr>
													<td>
														<table  class="box" width="100%" border="0" cellspacing="0" cellpadding="0" valign="middle" align="center">
						          				<tr>
						          					<td width="50%" class="box_subtitle_1">&nbsp;Total de Títulos:</td>
						          					<td width="50%" class="box_subtitle_1">&nbsp;Vlr Total do Borderô:</td>
						          				</tr>
						          				<tr>
						          					<td width="50%" class="box_fill2">&nbsp;<%=borderoTituloBean.getTotalTitulos()%></td>
						          					<td width="50%" class="box_fill2">&nbsp;<%=borderoTituloBean.getValorTotalBordero()%></td>
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

						<!-- SPACES -->
						<tr>
							<td>&nbsp;</td>
	          </tr>

	     		</table>
	     	</td>
			</tr>     
			<tr>
				<td align="left">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript: printPage()">
						<input type="text" name="printText2" size="97" style="font-family: Arial; border-width:0px; font-weight: bold" value="Click aqui para imprimir o Documento (ATENÇÃO: configure o browser para formato paisagem):" disabled><img name="printGif2" src="<%=Paths.getImagePath()%>/print.gif" border="0">
					</a>
				</td>
			</tr>
    </table>
    <script language="javascript">
			function inicia(){}
			function printPage() {
				document.frmMain.printText1.value = "";
				document.frmMain.printGif1.src="<%=Paths.getImagePath()%>/transparente.gif";
				document.frmMain.printText2.value = "";
				document.frmMain.printGif2.src="<%=Paths.getImagePath()%>/transparente.gif";
				self.print();
			}
		</script>
  </s:FormStrategy>
</p:Document>
</html>