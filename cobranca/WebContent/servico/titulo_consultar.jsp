<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: titulo_consultar.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 18/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoTituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>


<%
	BorderoBean borderoBean = (session.getAttribute(TituloEstrategia.BORDERO_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(TituloEstrategia.BORDERO_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(TituloEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TituloEstrategia.CEDENTE_CABECALHO_BEAN));
	BorderoTituloBean tituloFixoBean = (session.getAttribute(TituloEstrategia.FIXO_BEAN)==null?new BorderoTituloBean():(BorderoTituloBean)session.getAttribute(TituloEstrategia.FIXO_BEAN));
	BorderoTituloBean tituloBean = (session.getAttribute(TituloEstrategia.DATA_BEAN)==null?new BorderoTituloBean():(BorderoTituloBean)session.getAttribute(TituloEstrategia.DATA_BEAN));
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(TituloEstrategia.USUARIOLDAP_BEAN);
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TituloEstrategia.STRATEGY_ALTERAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TituloEstrategia.PAGE_TITLE_CONSULTAR%>"/>

 		<input type="hidden" name ="cep" value=''>
 		<input type="hidden" name ="endereco" value=''>
 		<input type="hidden" name ="bairro" value=''>
 		<input type="hidden" name ="municipio" value=''>
 		<input type="hidden" name ="uf" value=''>
 		
		<input type="hidden" name ="cepSacado" value=''>
		<input type="hidden" name ="dataVencimento" value=''>
		<input type="hidden" name ="cpfCnpjSacado" value=''>
		<input type="hidden" name ="cpfCnpjSacador" value=''>
		<input type="hidden" name ="cpfCnpjTemp" value=''>
		
		<input type="hidden" name="codigoCedente" value='<%=borderoBean.getCodigoCedente()%>'>
		<input type="hidden" name="codigoBordero" value='<%=borderoBean.getCodigoBordero()%>'>
		<input type="hidden" name="registro" value="<%=tituloBean.getRegistro()%>">
		<input type="hidden" name="numeroSequencial" value="<%=tituloBean.getNumeroSequencial()%>">
		<input type="hidden" name="nossoNumero" value="<%=tituloBean.getNossoNumero()%>">
		<input type="hidden" name="situacao" value="<%=tituloFixoBean.getSituacao()%>">		
   	<input type="hidden" name="totalTitulos" value="<%=tituloFixoBean.getTotalTitulos().toString()%>">
    
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
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoBordero()%></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Total de Títulos:</td>
              <td class="textoValor" width="26%"><%=tituloFixoBean.getTotalTitulos()%></td>
              <td class="textoTitulo" width="17%">Título Atual:</td>
              <td class="textoValor" width="26%"><%=tituloBean.getNumeroSequencial()%></td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Consultar Título:
                <hr>
              </td>
            </tr>

						<tr>
              <td colspan="4">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td class="textoTitulo" width="17%">Número Documento: </td>
				              <td class="textoValor" width="26%" nowrap><%=tituloBean.getNumeroDocumento()%></td>
                      <td class="textoTitulo" width="17%">Nosso Número: </td>
				              <td class="textoValor" width="26%" nowrap><%=tituloBean.getNossoNumero().toString()%></td>
                    </tr>

                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data de Vencimento: </td>
				              <td class="textoValor" width="26%" nowrap>
				              <%if(tituloBean.getDataVencimentoFormatada().equals("88/88/8888")){%>
				              	A VISTA
				              <%}
				              else if (tituloBean.getDataVencimentoFormatada().equals("99/99/9999")){%>
												CONTRA APRESENTACAO			              
				              <%}
				              else{%>
				              	<%=tituloBean.getDataVencimentoFormatada()%>
				              <%}%>
				              </td>
                      <td nowrap class="textoTitulo" width="17%">Data de Emissão: </td>
				              <td class="textoValor" width="26%" nowrap><%=tituloBean.getDataDocumentoFormatada()%></td>
                    </tr>

                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Abatimento: </td>
				              <td class="textoValor" width="26%" class="textoValor" nowrap><%=tituloBean.getAbatimento().toString()%></td>
                      <td class="textoTitulo" width="17%" nowrap>Valor do Título: </td>
				              <td class="textoValor" width="26%" nowrap><%=tituloBean.getValorTitulo().toString()%></td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Nome do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getNomeSacado()%></td>
                      <td class="textoTitulo" width="17%">e-mail do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getEmailSacado()%></td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Tipo Pessoa Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getTipoPessoaSacadoTexto()%></td>
                      <td class="textoTitulo" width="17%" nowrap>CPF/CNPJ do Sacado: </td>
				              <td class="textoValor" width="26%" nowrap><%=tituloBean.getCpfCnpjSacadoFormatado()%></td>
                    </tr>
                    
                    <tr>
                      <td class="textoTitulo" width="17%">CEP do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getCepSacadoFormatado()%></td>
                      <td class="textoTitulo" width="17%">UF do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getUfSacado()%></td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Endereço do Sacado: </td>
				              <td class="textoValor" width="26%" nowrap><%=tituloBean.getEnderecoSacado()%></td>
                      <td class="textoTitulo" width="17%">Número do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getNumeroSacado()%></td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Complemento do Sacado: </td>
				              <td class="textoValor" width="26%" nowrap><%=tituloBean.getComplSacado()%></td>
                      <td class="textoTitulo" width="17%">Bairro do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getBairroSacado()%></td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Município do Sacado: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getMunicipioSacado()%></td>
                      <td class="textoTitulo" width="17%">Nome Sacador/Avalista: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getNomeSacadorAvalista()%></td>
                    </tr>

                    <tr>
                      <td class="textoTitulo" width="17%">Tipo Pessoa Sacador: </td>
                      <td class="textoValor" width="26%"><%=tituloBean.getTipoPessoaSacadorTexto()%></td>
                      <td nowrap class="textoTitulo" width="17%">CPF/CNPJ do Sacador: </td>
				              <td class="textoValor" width="26%" nowrap><%=tituloBean.getCpfCnpjSacadorFormatado()%></td>
					</tr>

 					<tr>
					  	<td nowrap class="textoTitulo" width="17%">DDD/Celular: </td>
						<td class="textoValor" width="26%"><%=tituloBean.getDddSMS()%>-<%=tituloBean.getCelularSMS()%></td>					  				
					  	<td nowrap class="textoTitulo" width="17%">Tipo de SMS: </td>
					  	<td class="textoValor" width="26%">
					  	
						<%=tituloBean.getTipoSMS().equals("00") ? "" : ""%>
						<%=tituloBean.getTipoSMS().equals("01") ? "Informativa" : ""%> 
						<%=tituloBean.getTipoSMS().equals("02") ? "Repr. Numérica" : ""%> 
						<%=tituloBean.getTipoSMS().equals("03") ? "PEC" : ""%> 
						
					  	
					  	</td>
					  </tr>

					<tr>
                     <td nowrap class="textoTitulo" width="17%">IOF a ser Retido: </td>
				              <td class="textoValor" width="26%" class="textoValor" nowrap><%=tituloBean.getRetidoValorIOF().toString()%></td>
                    <td nowrap class="textoTitulo" width="17%">Indicador Registro na CIP: </td>
                      <td width="26%" class="textoValor" nowrap> 
                       <%=tituloBean.getIndRegCip().trim().equals("S")?"SIM":"NÃO"%>
                      </td>
                    </tr>
                    
                    <tr>
                    	<td nowrap class="textoTitulo" width="17%">Autoriza Pagamento Parcial/Divergente: </td>
                      	<td width="26%" class="textoValor" nowrap> 
                       		<%=tituloBean.getIcParcial().trim().equals("N")?"NÃO":"SIM"%>
                      	</td>
                    </tr>
                    
                    <tr>
                    		
                    	<td nowrap class="textoTitulo" width="17%">Tipo de Pagamento: </td>
					  	<td colspan="3" class="textoValor">
					  	 
					  	 	<%=tituloBean.getTipoPgto().equals("1") ? "Aceita qualquer valor " : ""%> 
							<%=tituloBean.getTipoPgto().equals("2") ? "Aceita valores entre range mínimo e máximo" : ""%>
							<%=tituloBean.getTipoPgto().equals("3") ? "Não aceita valor divergente" : ""%>
							<%=tituloBean.getTipoPgto().equals("4") ? "Aceita valores considerando apenas o valor mínimo" : ""%>
						
						</td>
                    
                    </tr>
                    
                    
                    <tr>
                    	<td nowrap class="textoTitulo" width="17%">Valor Máximo Pagamento:  </td>
						<td class="textoValor" width="26%" class="textoValor" nowrap> 
							<%=tituloBean.getValorMaxPgto().toString()%> 
						</td>
						
                      	
                    </tr>
                    
                    <tr>
                    	<td nowrap class="textoTitulo" width="17%">Valor Mínimo Pagamento:  </td>
						<td class="textoValor" width="26%" nowrap> 
						 	<%=tituloBean.getValorMinPgto().toString()%> 
						</td>
						<td nowrap class="textoTitulo" width="17%"> Qtde. Pagamentos Possíveis: </td>
                      	<td width="26%" class="textoValor" nowrap> 
 				        	<%=tituloBean.getQtdePossivel().toString()%>			                									                						
                      	</td>
                      	
                    </tr>
                    
                    
                  </table>
								</td>                  
            </tr>
            <tr> 
	            <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
	            <td align="right" colspan="4">
  	            <p align="center"> 
                 	<s:Button name="Alterar" action="javascript: formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.alterar" />
                 	<s:Button name="Excluir" action="javascript: formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="servico.bordero.manter.excluir" />
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
    <script language="javascript">
			function inicia() {
			}
	    
	    function formSubmit_Alterar() {
				formSubmit();
      }

			function validaSubmit() {
        return true;
		  }

	    function formSubmit_Excluir() {
        if (validaSubmit()) {
				<%if (tituloFixoBean.getSituacao().equals(new Long(2))){%>
	    		if (confirm(conf("140"))) {
		    <%}
		    	else{%>
		    	if (confirm(conf("102", "Título"))) {
	    	<%}%>
						document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_EXCLUIR%>";
		        document.frmMain.submit();
         	}
         }
	      }
	    
	    function formSubmit() { // Acao default Alterar
        if (validaSubmit()){
				<%if (tituloFixoBean.getSituacao().equals(new Long(2))){%>
		    	if (confirm(conf("138"))) {
	    	<%}%>
						document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_ALTERAR%>";
		        document.frmMain.submit();
				<%if (tituloFixoBean.getSituacao().equals(new Long(2))){%>
         	}
	    	<%}%>
        }
       }

	    function formSubmit_Voltar() {
           document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_MANTER_LISTAR%>";
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
      }

    </script>
  </s:FormStrategy>
</p:Document>
</html>
