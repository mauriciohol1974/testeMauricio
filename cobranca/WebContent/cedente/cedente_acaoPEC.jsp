<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.com.politec.sao.business.util.BeanList"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCarteiraBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteManterFiltroBean"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>

<%CedenteCabecaBean cabecaBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN) == null
                    ? new CedenteCabecaBean()
                    : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

            CedenteManterFiltroBean filtroBean = (session.getAttribute(CedenteEstrategia.MANTER_FILTRO_BEAN) == null
                    ? new CedenteManterFiltroBean()
                    : (CedenteManterFiltroBean) session.getAttribute(CedenteEstrategia.MANTER_FILTRO_BEAN));

            CedenteCarteiraBean fixoBean = (session.getAttribute(CedenteEstrategia.MANTER_FIXO_BEAN) == null
                    ? new CedenteCarteiraBean()
                    : (CedenteCarteiraBean) session.getAttribute(CedenteEstrategia.MANTER_FIXO_BEAN));

            ArrayList listaTitulos = (ArrayList) session.getAttribute(CedenteEstrategia.MANTER_LISTA_TITULOS_BEAN);

            %>
<%MsgSucessoErroBean msgBean;
            if (session.getAttribute(CedenteEstrategia.MSG_BEAN) == null) {
                msgBean = new MsgSucessoErroBean();
                msgBean.setMsgSucess(msgBean.getMsgSucess());
                msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
            } else {
                msgBean = (MsgSucessoErroBean) session.getAttribute(CedenteEstrategia.MSG_BEAN);
            }

            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(CedenteEstrategia.USUARIOLDAP_BEAN);

			CedenteGeralBean cedGeralBean = (session.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN)==null?new CedenteGeralBean():(CedenteGeralBean)session.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN));
%>

<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="cedente.CedenteManterFiltro" fluxo="normal">
		<s:Menu />
		<s:Titulo name="Manter Cedente >> Ações" />

		<input type="hidden" name="codigoCedente" value="<%= filtroBean.getCodigoCedente() %>">
		<input type="hidden" name="situacao" value="<%= fixoBean.getSituacao() %>">

		<table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height=53 valign="middle" align="center">
					<tr>
						<td class="textoTitulo" width="17%">Código Cliente (COCLI):</td>
						<td class="textoValor" width="26%"><%=cabecaBean.getCodigoClienteCOCLIZeros()%></td>
						<td class="textoTitulo" width="17%">Carteira:</td>
						<td class="textoValor" width="26%"><%=cabecaBean.getCarteira()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Tipo de Pessoa:</td>
						<td class="textoValor" width="26%"><%=cabecaBean.getTipoPessoaTexto()%></td>
						<td class="textoTitulo" width="17%">CPF/CNPJ:</td>
						<td class="textoValor" width="26%"><%=cabecaBean.getCpfCnpjFormatado()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Nome Cedente:</td>
						<td class="textoValor" width="26%"><%=cabecaBean.getNomeFantasia()%></td>
						<td class="textoTitulo" width="17%">Razão Social:</td>
						<td class="textoValor" width="26%"><%=cabecaBean.getRazaoSocial()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">e-mail:</td>
						<td class="textoValor" width="26%"><%=cabecaBean.getEmail()%></td>
						<td class="textoTitulo" width="17%">Endereço:</td>
						<td class="textoValor" width="26%"><%=cabecaBean.getLogradouro()%>,
						<%=cabecaBean.getNumero()%></td>
					</tr>
					<tr>
						<td class="textoTitulo" width="17%">Cedente:</td>
						<td class="textoValor" width="26%"><%=cabecaBean.getCodigoCedenteFormatado()%></td>
						<td class="textoTitulo" width="17%">&nbsp;</td>
						<td class="textoValor" width="26%"><%=cabecaBean.getMunicipio()%>,
						<%=cabecaBean.getUf()%></td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="4" class="textoTitulo">Posição Consolidada da
						Carteira de Cobrança:
						<hr>
						</td>
					</tr>
					<tr>
						<td colspan="4">
						<table width="100%" border="0" cellspacing="3" cellpadding="0"
							align="center" valign="middle">
							<tr class="headerLista">
								<td nowrap width="20%" align="center">&nbsp;</td>
								<td nowrap width="20%" align="center" colspan="2">Vencidos</td>
								<td nowrap width="20%" align="center" colspan="2">Vencendo no
								dia</td>
								<td nowrap width="20%" align="center" colspan="2">a Vencer</td>
								<td nowrap width="20%" align="center" colspan="2">Liquidados no
								dia</td>
							</tr>
							<tr class="headerLista">
								<td nowrap width="20%" align="left">Espécie Título</td>
								<td nowrap width="10%" align="left">Qtd</td>
								<td nowrap width="10%" align="right">Valor</td>
								<td nowrap width="10%" align="left">Qtd</td>
								<td nowrap width="10%" align="right">Valor</td>
								<td nowrap width="10%" align="left">Qtd</td>
								<td nowrap width="10%" align="right">Valor</td>
								<td nowrap width="10%" align="left">Qtd</td>
								<td nowrap width="10%" align="right">Valor</td>
							</tr>

							<%int i = 0;
                    for (i = 0; i < listaTitulos.size(); i++) {
                        CedenteCarteiraBean beanCarteira = (CedenteCarteiraBean) listaTitulos.get(i);
                        if (beanCarteira.getEspecieTitulo() != null
                            && !beanCarteira.getEspecieTitulo().trim().equals(
                                    "")) {
%>
							<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td nowrap width="20%" align="left"><%=beanCarteira.getEspecieTitulo()%></td>
								<%String preenchimento = "~~~~~~~~~~~~";
                            if (beanCarteira.getTipoCarteira().equals(
                                    new Long(2))) {//Tipo de Carteira = 2, Sem Registro%>
								<td nowrap width="10%" align="left"><%=preenchimento%></td>
								<td nowrap width="10%" align="right"><%=preenchimento%></td>
								<td nowrap width="10%" align="left"><%=preenchimento%></td>
								<td nowrap width="10%" align="right"><%=preenchimento%></td>
								<td nowrap width="10%" align="left"><%=preenchimento%></td>
								<td nowrap width="10%" align="right"><%=preenchimento%></td>
								<%} else {%>
								<td nowrap width="10%" align="left"><%=beanCarteira.getVencidosQtde()%></td>
								<td nowrap width="10%" align="right"><%=beanCarteira.getVencidosValor()%></td>
								<td nowrap width="10%" align="left"><%=beanCarteira.getVencendoDiaQtde()%></td>
								<td nowrap width="10%" align="right"><%=beanCarteira.getVencendoDiaValor()%></td>
								<td nowrap width="10%" align="left"><%=beanCarteira.getAVencerQtde()%></td>
								<td nowrap width="10%" align="right"><%=beanCarteira.getAVencerValor()%></td>
								<%}%>


								<td nowrap width="10%" align="left"><%=beanCarteira.getLiquidadosDiaQtde()%></td>
								<td nowrap width="10%" align="right"><%=beanCarteira.getLiquidadosDiaValor()%></td>
							</tr>
							<%}
                    }
%>

							<tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								<td class="textoDestaqueValor" nowrap width="20%" align="left">Total</td>
								<td class="textoDestaqueValor" nowrap width="10%" align="left"><%=fixoBean.getTotalVencidosQtde()%></td>
								<td class="textoDestaqueValor" nowrap width="10%" align="right"><%=fixoBean.getTotalVencidosValor()%></td>
								<td class="textoDestaqueValor" nowrap width="10%" align="left"><%=fixoBean.getTotalVencendoDiaQtde()%></td>
								<td class="textoDestaqueValor" nowrap width="10%" align="right"><%=fixoBean.getTotalVencendoDiaValor()%></td>
								<td class="textoDestaqueValor" nowrap width="10%" align="left"><%=fixoBean.getTotalAVencerQtde()%></td>
								<td class="textoDestaqueValor" nowrap width="10%" align="right"><%=fixoBean.getTotalAVencerValor()%></td>
								<td class="textoDestaqueValor" nowrap width="10%" align="left"><%=fixoBean.getTotalLiquidadosDiaQtde()%></td>
								<td class="textoDestaqueValor" nowrap width="10%" align="right"><%=fixoBean.getTotalLiquidadosDiaValor()%></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="4" class="textoTitulo">Principais Comandos:
						<hr>
						</td>
					</tr>

					<tr>
						<td colspan="4">
						<div id="Favoritos" class="group">
						<table width="95%" border="0" cellspacing="0" cellpadding="0"
							height=14 valign="middle" align="center">
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>
							<tr>
								<td class="textoTitulo" width="30%"><a href="#"
									onclick="javascript:formSubmit_Consultar();">Consultar Dados do
								Cedente</a></td>
								<td class="textoValor" width="15%">&nbsp;</td>
								<td class="textoTitulo" width="30%"><a href="#"
									onclick="javascript:frmMenuSubmit('consulta.MCRenCeManterIniciar');">Consultar
								Rentabilidade do Cedente</a></td>
								<td class="textoTitulo" width="15%">&nbsp;</td>
							</tr>
							<tr>
								<td class="textoTitulo" width="30%"><s:Link
									value="Alterar Dados do Cedente"
									action="javascript:formSubmit_Alterar();"
									userGroup="<%=usuarioBean.getNomeGrupo() %>"
									internalAction="cedente.cadastro.manter.alterar" /> <!-- <a href="#" onclick="javascript:formSubmit_Alterar();">Alterar Dados do Cedente</a>-->
								</td>
								<td class="textoValor" width="15%">&nbsp;</td>
								<td class="textoTitulo" width="30%"><a href="#"
									onclick="javascript:frmMenuSubmit('consulta.MCExtraManterIniciar');">Consultar
								Movimento Mensal (Extrato)</a></td>
								<td class="textoTitulo" width="15%">&nbsp;</td>
							</tr>
							<tr>
								<td class="textoTitulo" width="30%"><a href="#"
									onclick="javascript:frmMenuSubmit('servico.BcoTituManterIniciar');">Banco
								de Títulos</a></td>
								<td class="textoValor" width="15%">&nbsp;</td>
								<td class="textoTitulo" width="30%"><a href="#"
									onclick="javascript:frmMenuSubmit('consulta.MCTotaiManterIniciar');">Consultar
								Movimento Mensal (Totais)</a></td>
								<td class="textoTitulo" width="15%">&nbsp;</td>
							</tr>
							<tr>
								<td class="textoTitulo" width="30%"><s:Link
									value="Alterar Dados do Cedente (SICLI)"
									action="javascript:frmMenuSubmit('cedente.CedenteAlterarEnderecoSicliIniciar');"
									userGroup="<%=usuarioBean.getNomeGrupo() %>"
									internalAction="cedente.cadastro.manter.alterar" /> <!-- <a href="#" onclick="javascript:frmMenuSubmit('cedente.CedenteAlterarEnderecoSicliIniciar');">Alterar Dados do Cedente (SICLI)</a>--></td>
								<td class="textoValor" width="15%">&nbsp;</td>
								<td class="textoTitulo" width="30%">&nbsp;</td>
								<td class="textoTitulo" width="15%">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="4">&nbsp;</td>
							</tr>
						</table>
						</div>
						</td>
					</tr>
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td align="right" colspan="4">
						<p align="center"><s:Button name="Voltar"
							action="javascript:formSubmit_Voltar();" /></p>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

		<script language="javascript">
		    function inicia(){
		    	<%if(!msgBean.getMsgSucess().equals("")) {%>
				alert('<%=msgBean.getMsgSucess()%>');
				<%}%>
		    }

		    function formSubmit() {
		    }

		    function formSubmit_Voltar() {
				document.frmMain.estrategia.value = "consulta.CedenteMasterPECManterFiltro";
	        	document.frmMain.fluxo.value = "voltar";				
				document.frmMain.submit();
		    }

		    function formSubmit_Alterar() {
				if (('<%=usuarioBean.getNomeGrupo()%>' == 'GCBOPE') &&
				    (<%=Integer.parseInt(usuarioBean.getCodigoUnidade())%>!=<%=cedGeralBean.getCodigoUnidadePVVinc()%>)){
					alert('Só é permitida a alteração de cedentes com unidade de vinculação igual à sua.');
					return;				 
				}

	        	var confirma = true;
	        	
	        	if (document.frmMain.situacao.value == "I") {
	        		confirma = confirm(conf('124', 'Cedente'));
	        	}
	        	
	        	if (confirma) {
		        	document.frmMain.estrategia.value="cedente.CedenteAlterarIniciar";
		          document.frmMain.submit();
		        }
		    }
		    
		    function formSubmit_Consultar() {
        		document.frmMain.situacao.disabled = true;
        		document.frmMain.estrategia.value="cedente.CedenteConsultarIniciar";
          		document.frmMain.submit();
		    }
	    </script>

	</s:FormStrategy>
</p:Document>

</html>
