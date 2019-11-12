<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servdia_consultar_emitit.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 26/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServDiaEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean "%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%
	ConGerServicosSolicitadosBean cabeEXBean =(session.getAttribute(ServDiaEstrategia.BEAN_DATA)==null? new ConGerServicosSolicitadosBean()
																		:(ConGerServicosSolicitadosBean)session.getAttribute(ServDiaEstrategia.BEAN_DATA));
	
	CedenteCabecaBean cedCabBean = 	(session.getAttribute(ServDiaEstrategia.BEAN_CABECALHO)==null? new CedenteCabecaBean()
																		:(CedenteCabecaBean)session.getAttribute(ServDiaEstrategia.BEAN_CABECALHO));
	
	ConGerServicosSolicitadosBean dataBean 	= (session.getAttribute(ServDiaEstrategia.BEAN_TIT_EMI_DET)==null? new ConGerServicosSolicitadosBean()
																		: (ConGerServicosSolicitadosBean)session.getAttribute(ServDiaEstrategia.BEAN_TIT_EMI_DET));
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=ServDiaEstrategia.STRATEGY_FILTRO%>" fluxo="voltar">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Serviços Solicitados no dia"/>
 		
 		<input type="hidden" name="tpConsulta" value="<%=cabeEXBean.getTpConsulta()%>">
 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

           	<tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getCodigoCedente().equals( new Long(0))?"":cedCabBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getNomeFantasia()%>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
	            <td class="textoTitulo" width="17%" valign="top">Código Cliente (COCLI): </td>
	            <td class="textoValor"  width="26%" valign="top"><%=cedCabBean.getCodigoClienteCOCLI().equals(new Long(0))? "":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
	            <td class="textoTitulo" width="17%" valign="top">Relatório:</td>
              <td class="textoValor"  width="26%" valign="top"><%=cabeEXBean.getNomeRelatorio()%></td>
	          </tr>
            <tr>
	            <td class="textoTitulo" width="17%">Número Banco: </td>
	            <td class="textoValor"  width="26%"><%=cabeEXBean.getCodigoBancoSacados()%></td> 
	            <td class="textoTitulo" width="17%">Nome Banco:</td>
              <td class="textoValor"  width="26%"><%=cabeEXBean.getNomeBancoSacados()%></td>
	          </tr>
	       	      

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Consulta:
                <hr>
              </td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Registro do Titulo: </td>
              <td class="textoValor" width="26%"><%=dataBean.getDescRegistroTitulo()%></td>
              <td class="textoTitulo" width="17%">Valor dos Títulos: </td>
              <td class="textoValor" width="26%"><%=dataBean.getValorTitulo()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Dia de Vencimento: </td>
              <td class="textoValor" width="26%"><%=dataBean.getDiaVencimento()%></td>
              <td class="textoTitulo" width="17%">Modelo: </td>
              <td class="textoValor" width="26%"><%=dataBean.getModelo()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Quantidade: </td>
              <td class="textoValor" width="26%"><%=dataBean.getQuantidade()%></td>
              <td class="textoTitulo" width="17%">Meio de Entrada: </td>
              <td class="textoValor" width="26%"><%=dataBean.getMeioEntrada()%></td>    
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
						<tr>
					  	<td align="right" colspan="4">
              	<p align="center"> 
			          	<s:Button name="Voltar" action="javascript:formSubmit()"/> 
								</p>
	            </td>
	          </tr>
          </table>
        </td>
      </tr>
    </table>
    <script>
	    function inicia() {
				setFirstFieldFocus();
			}
			
	    function formSubmit() {
        	document.frmMain.submit();
	    } 
	    
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
