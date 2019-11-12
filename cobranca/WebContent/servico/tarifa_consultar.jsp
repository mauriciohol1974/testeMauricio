<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: tarifa_incluir.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Author Eduardo A. Morás - emoras@sao.politec.com.br 
*Ultima Atualização: 29/08/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TarifaManualBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TarifaEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");
	TarifaManualBean filtroBean = (session.getAttribute(TarifaEstrategia.FILTRO_BEAN)==null?new TarifaManualBean():(TarifaManualBean)session.getAttribute(TarifaEstrategia.FILTRO_BEAN));
	TarifaManualBean dataBean = (session.getAttribute(TarifaEstrategia.DATA_BEAN)==null?new TarifaManualBean():(TarifaManualBean)session.getAttribute(TarifaEstrategia.DATA_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(TarifaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TarifaEstrategia.CEDENTE_CABECALHO_BEAN));
%>

<%
	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(TarifaEstrategia.PAGINACAO_LIST);

	List lista = paginacao.getPage(paginaAtual);	
	TarifaManualBean tarifaBean = (TarifaManualBean) lista.get(dataBean.getRegistro().intValue());
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TarifaEstrategia.STRATEGY_MANTER_LISTAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TarifaEstrategia.PAGE_TITLE_CONSULTAR%>"/>
		
		<input type="hidden" name = "codigoCedente" value="<%=filtroBean.getCodigoCedente()%>">
		<input type="hidden" name = "registro" value="<%=dataBean.getRegistro()%>">
  	<input type="hidden" name = "justificativa" value="<%=tarifaBean.getJustificativa()%>">
		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=filtroBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
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
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
              <td class="textoTitulo" width="17%">Serviço:</td>
              <td class="textoValor" width="26%"><%=filtroBean.getDescricaoTarifa()%></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Consultar Tarifa Comandada:
                <hr>
              </td>
            </tr>
            
						<tr>
              <td class="textoTitulo" width="17%">Data Solicitação: </td>
              <td class="textoValor" width="26%"><%=tarifaBean.getDataSolicitacaoFormatada()%></td>
              <td class="textoTitulo" width="17%">Usuário: </td>
              <td class="textoValor" width="26%"><%=tarifaBean.getCodigoUsuario()%></td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Valor da Tarifa: </td>
              <td class="textoValor" width="26%"><%=tarifaBean.getValorTarifa()%></td>
              <td class="textoTitulo" width="17%">Data Débito da Tarifa: </td>
              <td class="textoValor" width="26%"><%=tarifaBean.getDataDebitoFormatada()%></td>
						</tr>
            <tr>
              <td class="textoTitulo" width="17%">Justificativa: </td>
              <td class="textoValor" width="26%" colspan="3">
               	<p align="justify">
		            	<textarea name="textAreaJustificativa" cols="50" rows="2" class="textoValor" readonly><%=tarifaBean.getJustificativaFormatada()%></textarea>
             	  </p>
              </td>
            </tr>
            <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>

            <tr>
	            <td align="right" colspan="4">
		            <p align="center">
                 	<s:Button name="Excluir" action="javascript: formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.tarifamanual.manter.excluir" />
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
				setFirstFieldFocus();
				document.frmMain.textAreaJustificativa.value = inserebarraEne(document.frmMain.justificativa.value,50);				
			}
			function formSubmit_Excluir() {
        if (validaSubmit()) {
	    		if (confirm(conf("102", "Lançamento de Tarifa Comandada"))) {
	    			document.frmMain.estrategia.value = "<%=TarifaEstrategia.STRATEGY_EXCLUIR%>";
		        document.frmMain.submit();
		      }
        }
	    }
			function validaSubmit() {
		    return true;
		  }
	    function formSubmit_Voltar() {
        document.frmMain.estrategia.value = "<%=TarifaEstrategia.STRATEGY_MANTER_LISTAR%>"
        document.frmMain.fluxo.value = "voltar";
        document.frmMain.submit();
      }

    </script>
  </s:FormStrategy>
</p:Document>
</html>