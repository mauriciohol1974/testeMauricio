<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: ddatitiincl_consultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualiza��o: 11/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.bean.DetalheBaixaOperBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.BaixaOperacionalEstrategia" %>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
	
	DetalheBaixaOperBean baixaBean = (DetalheBaixaOperBean)session.getAttribute(BaixaOperacionalEstrategia.DATA_BEAN);

%>


<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.BaixaOperacionalManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=BaixaOperacionalEstrategia.PAGE_TITLE%>"/>
 		
 		
 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            

			 <tr>
              <td colspan="4">
                  <table class="box" width="100%" border="0" cellspacing="3" cellpadding="0" height=14 valign="middle" align="left">                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Identifica��o: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNuIdentificacao()%></td>
                      <td nowrap class="textoTitulo" width="17%">Identifica��o da Baixa </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNuIdentBaixa()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Benefici�rio:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getCobeneficiario().toString()%></td>
                      <td nowrap class="textoTitulo" width="17%">Nosso N�mero:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNossonumero().toString()%></td>
                    </tr>
                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data/Hora Baixa Operacional:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDthrbxoper()%></td>
                      <td nowrap class="textoTitulo" width="17%">ISPB Participante:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getIspbparticpt()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">C�dgio Participante:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getCoparticipt()%></td>
                      
                    </tr>
                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Tipo de Pessoa: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getTppessoa()%></td>
                      <td nowrap class="textoTitulo" width="17%">CPF/CNPJ:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getCpfcnpjportdr()%></td>
                    </tr>
                    
                    
                    
                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data de Processamento: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDtprocbxoper()%></td>
                      <td nowrap class="textoTitulo" width="17%">Valor da Baixa Operacional:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getVlbxoper()%></td>
                     
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">C�digo de Barras:</td>
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
                      <td nowrap class="textoTitulo" width="17%">Indicador Conting�ncia: </td>
				      <td colspan="3" class="textoValor" width="26%"><%=baixaBean.getIccontigencia()%></td>
				    </tr>
				    <tr>
                      <td nowrap class="textoTitulo" width="17%">Tipo da Baixa: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getTpbxoper()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">N�mero de Referencia: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNureferatual()%></td>
                      <td nowrap class="textoTitulo" width="17%">N�mero de Referencia da Baixa:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNuidentbxoper()%></td>
                    </tr>
                                                            <tr>
                      <td nowrap class="textoTitulo" width="17%">N�mero de Sequ�ncia: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNuseqbxoper()%></td>
                      <td nowrap class="textoTitulo" width="17%">N�mero Contr. DDA:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNucontroledda()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Data/Hora DDA: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDthrdda()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data Movimento </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDtmovimento()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Situa��o: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getSitbxoper()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data/Hora Situa��o: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDthrsitbxoper()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Qtde. Pagamentos:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getQtpgtoparcial()%></td>
                      <td nowrap class="textoTitulo" width="17%">Saldo do T�tulo:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getVlsaldottl()%></td>
                    </tr> 
                    
                   	<tr>
                      <td nowrap class="textoTitulo" width="17%">Situa��o Pagto.: </td>
				      <td colspan="3" class="textoValor" width="26%"><%=baixaBean.getSittitpagto()%></td>
                      
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Situa��o Cancelamento: </td>
				      <td colspan="3" class="textoValor" width="26%"><%=baixaBean.getSitcancbxoper()%></td>
				    </tr>
				    <tr>
                      <td nowrap class="textoTitulo" width="17%">Data/Hora Cancelamento: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDthrcancbxoper()%></td>
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