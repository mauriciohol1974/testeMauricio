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
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.gov.caixa.sigcb.bean.DetalheBaixaOperBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.BaixaEfetivaEstrategia" %>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
	
	DetalheBaixaOperBean baixaBean = (DetalheBaixaOperBean)session.getAttribute(BaixaEfetivaEstrategia.DATA_BEAN);
String paginaOrigem = (String ) request.getAttribute("paginaOrigem");
String codigoCedente = (String ) request.getAttribute("codigoCedente");
String nossoNumero = (String ) request.getAttribute("nossoNumero");
String filtroSelecao = (String ) request.getAttribute("filtroSelecao");
%>


<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.BaixaEfetivaManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=BaixaEfetivaEstrategia.PAGE_TITLE%>"/>
 		
 		  	<input type="hidden" name="paginaOrigem" value="<%=paginaOrigem%>"/>
		  	<input type="hidden" name="codigoCedente" value="<%=codigoCedente%>"/>
		  	<input type="hidden" name="nossoNumero" value="<%=nossoNumero%>"/>
		  	<input type="hidden" name="filtroSelecao" value="<%=filtroSelecao%>"/>
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            

			 <tr>
              <td colspan="4">
                  <table class="box" width="100%" border="0" cellspacing="3" cellpadding="0" height=14 valign="middle" align="left">                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Identificação: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNuIdentificacao()%></td>
                      <td nowrap class="textoTitulo" width="17%">Identificação da Baixa </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNuIdentBaixa()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Beneficiário:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getCobeneficiario().toString()%></td>
                      <td nowrap class="textoTitulo" width="17%">Nosso Número:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNossonumero().toString()%></td>
                    </tr>
                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data/Hora Baixa Efetiva :</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDthrbxoper()%></td>
                      <td nowrap class="textoTitulo" width="17%">ISPB Participante:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getIspbparticpt()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Código Participante:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getCoparticipt()%></td>
                      
                    </tr>
                    
                  
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data de Processamento: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDtprocbxoper()%></td>
                      <td nowrap class="textoTitulo" width="17%">Valor da Baixa Efetiva:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getVlbxoper()%></td>
                     
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Código de Barras:</td>
				      <td colspan="3"class="textoValor" width="26%"><%=baixaBean.getCobarras()%></td>
                    </tr>  
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Canal Pagamento:</td>
				      <td colspan="3" class="textoValor" width="26%"><%=baixaBean.getCanalpgto()%></td>
                      
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Meio de Pagamento:</td>
				      <td colspan="3" class="textoValor" width="26%"><%=baixaBean.getMeiopgto()%></td>
                      
                    </tr>

				    <tr>
                      <td nowrap class="textoTitulo" width="17%">Tipo da Baixa: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getTpbxoper()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Número de Referencia: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNureferatual()%></td>
                      <td nowrap class="textoTitulo" width="17%">Número de Referencia da Baixa:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNuidentbxoper()%></td>
                    </tr>
                                                            <tr>
                      <td nowrap class="textoTitulo" width="17%">Número de Sequência: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNuseqbxoper()%></td>
                      <td nowrap class="textoTitulo" width="17%">Número Contr. DDA:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNucontroledda()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Data/Hora DDA: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDthrdda()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data Movimento </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDtmovimento()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data/Hora Situação: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDthrsitbxoper()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Qtde. Pagamentos:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getQtpgtoparcial()%></td>
                      <td nowrap class="textoTitulo" width="17%">Saldo do Título:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getVlsaldottl()%></td>
                    </tr> 
                    
                   	<tr>
                      <td nowrap class="textoTitulo" width="17%">Situação Pagto.: </td>
				      <td colspan="3" class="textoValor" width="26%"><%=baixaBean.getSittitpagto()%></td>
                      
                    </tr>
                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Tipo de Pessoa do Portador:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getTpPessoaPort()%></td>
                      <td nowrap class="textoTitulo" width="17%">CPF/CNPJ do Portador:</td>
				      <td nowrap class="textoValor" width="26%">
				      <%if (baixaBean.getTpPessoaPort().trim().length()>0){ %>
				      	<%=baixaBean.getTpPessoaPort().substring(0, 1).equalsIgnoreCase("F")? Formatador.formatarCpfCnpj(baixaBean.getCpfCnpjPortador().substring(3, 14)):""%>
				      	<%=baixaBean.getTpPessoaPort().substring(0, 1).equalsIgnoreCase("J")? Formatador.formatarCpfCnpj(baixaBean.getCpfCnpjPortador()):""%>
				      <%} %>
				      </td>
                    </tr> 
                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">NSU: </td>
				      <td colspan="3" class="textoValor" width="26%"><%=baixaBean.getCoPagtoTitulo()%></td>
                    </tr>

                
                    
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>  
                    
                    <tr> 
                      <td colspan="4">&nbsp;</td>
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
		                                                  <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>  
                  </table>
				</td>                  
            </tr>

          </table>
        </td>
      </tr>
    </table>
    <script>
			function inicia(){
		   	setFirstFieldFocus();
	   	}
	    function formSubmit_Voltar() {
				
        		document.frmMain.fluxo.value = "voltar";
       			document.frmMain.submit();
	    }   

    </script>
		</s:FormStrategy>
	</p:Document>
</html>