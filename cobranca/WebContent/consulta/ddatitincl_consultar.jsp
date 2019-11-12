<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: ddatitiincl_consultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 11/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.DdaTituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.DdaTitIncluidoEstrategia" %>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
	DdaTituloBean titliqbean = (session.getAttribute(DdaTitIncluidoEstrategia.TITLIQ_BEAN)==null? new DdaTituloBean()
																						:(DdaTituloBean)session.getAttribute(DdaTitIncluidoEstrategia.TITLIQ_BEAN));
																																																														 
	CedenteCabecaBean cedCabBean = 	(session.getAttribute(DdaTitIncluidoEstrategia.CABECALHO_BEAN)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(DdaTitIncluidoEstrategia.CABECALHO_BEAN));
%>


<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.DdaTitIncluidoManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=DdaTitIncluidoEstrategia.PAGE_TITLE%>"/>
 		
 		
 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
	            <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
	            <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
              <td class="textoTitulo" width="17%">Valor Título: </td>
              <td class="textoValor" width="26%"><%=titliqbean.getValorTitulo()%></td> 
						</tr>
            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Titulo Incluído:
                <hr>
              </td>
            </tr>
						<tr>
              <td colspan="4">
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="left">                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Nosso Número: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getNossoNumero()%></td>
                      <td nowrap class="textoTitulo" width="17%">Situação: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getSituacaoTitulo()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Situação: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataSituacaoFormatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data Vencimento: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataVencimentoFormatada()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Modalidade: </td>
                      <td nowrap class="textoValor" width="26%"><%=titliqbean.getSituacaoTitulo()%></td>
 					  <td nowrap class="textoTitulo" width="17%">CPF/CNPJ:</td>
                      <td nowrap class="textoValor" width="26%"><%=titliqbean.getCpfCnpj()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Meio de Entrada: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getMeioEntrada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Moeda: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getMoeda()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">PV Cobrador: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPvCobradorFormatado()%></td>
                      <td nowrap class="textoTitulo" width="17%">&nbsp;</td>
				              <td nowrap class="textoValor" width="26%">&nbsp;</td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Especie: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getEspecieTitulo()%></td>
                      <td nowrap class="textoTitulo" width="17%">&nbsp;</td>
				              <td nowrap class="textoValor" width="26%">&nbsp;</td>
                    </tr>                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Abatimento: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorAbatimento()%></td>
			                <td nowrap class="textoTitulo" width="17%">&nbsp; </td>
				              <td nowrap class="textoValor" width="26%">&nbsp;</td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Valor Juros:</td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorJuros()%></td>
                      <td nowrap class="textoTitulo" width="17%">Percentual de Juros: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPercentualJurosDia()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Valor Multa: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorMulta()%></td>
                      <td nowrap class="textoTitulo" width="17%">Percentual de Multa: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPercentualMulta()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Multa: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataMultaFormatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Prazo Multa: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPrazoMulta()%> dias</td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Valor Desconto 1: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorDesconto1()%></td>
                      <td nowrap class="textoTitulo" width="17%">Desconto Percentual 1: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPercentualDesconto1()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Valor Desconto 2: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorDesconto2()%></td>
                      <td nowrap class="textoTitulo" width="17%">Desconto Percentual 2: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPercentualDesconto2()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Valor Desconto 3: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getValorDesconto3()%></td>
                      <td nowrap class="textoTitulo" width="17%">Desconto Percentual 3: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPercentualDesconto3()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Desconto 1: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataDesconto1Formatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Prazo Desconto 1: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPrazoDesconto1()%> dias</td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Desconto 2: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataDesconto2Formatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Prazo Desconto 2: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPrazoDesconto2()%> dias</td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Desconto 3: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataDesconto3Formatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Prazo Desconto 3: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPrazoDesconto3()%> dias</td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data Emissão: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataEmissaoFormatada()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data para Protesto: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getDataProtestoFormatada()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Prazo Protesto: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getPrazoProtesto()%> dias</td>
                      <td nowrap class="textoTitulo" width="17%">&nbsp; </td>
				              <td nowrap class="textoValor" width="26%">&nbsp;</td> 
				            </tr>
                    <tr> 
				    <tr>
                      <td nowrap class="textoTitulo" width="17%">Número CIP: </td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getNuCIP()%></td>
                      <td nowrap class="textoTitulo" width="17%">Núrmero Referência Titulo CIP:</td>
				              <td nowrap class="textoValor" width="26%"><%=titliqbean.getNuRefCIP()%></td> 
				    </tr>                    
                      <td colspan="4">&nbsp;</td>
                    </tr>
                  </table>
								</td>                  
            </tr>
            <tr>
	            <td align="right" colspan="4">
  	            <p align="center"> 
      	          <input type="button" class="button" name="Voltar" value="Voltar" onclick="javascript:formSubmit_Voltar()">
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
			function inicia(){
		   	setFirstFieldFocus();
	   	}
	   	function formSubmit(){}
	   	
	    function formSubmit_Voltar() {
				document.frmMain.estrategia.value = "consulta.DdaTitIncluidoManterFiltro";
        document.frmMain.fluxo.value = "voltar";
       	document.frmMain.submit();
	    }   

    </script>
		</s:FormStrategy>
	</p:Document>
</html>