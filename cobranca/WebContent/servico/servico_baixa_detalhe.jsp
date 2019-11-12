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
<%@page import="br.gov.caixa.sigcb.bean.ServicoBaixaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ServicoBaixaOperacionalEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
	
	ServicoBaixaBean baixaBean = (ServicoBaixaBean)session.getAttribute(ServicoBaixaOperacionalEstrategia.DATA_BEAN);

%>


<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="servico.ServicoBaixaOperacionalDetalhe" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=ServicoBaixaOperacionalEstrategia.PAGE_TITLE_LISTAR%>"/>
 		
 		
 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            

			 <tr>
              <td colspan="4">
                  <table class="box" width="100%" border="0" cellspacing="3" cellpadding="0" height=14 valign="middle" align="left">                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Código Beneficiário: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getCodbenfcrio().toString()%></td>
                      <td nowrap class="textoTitulo" width="17%">Nosso Número: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNossonum().toString()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Número Identificação:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNumidtit().toString()%></td>
                      <td nowrap class="textoTitulo" width="17%">Tipo de Baixa:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getTpbxop()%></td>
                    </tr>
                    
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Tippo de Pessoa:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getTppesport()%></td>
                      <td nowrap class="textoTitulo" width="17%">CPF/CNPJ:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getCnpjcpfport()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Data de Processamento: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDthrprocbxop()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data de Processamento:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDtprocbxop()%></td>
                     
                    </tr>
                 
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Valor da Baixa: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getVlrbxoptit()%></td>
                      <td nowrap class="textoTitulo" width="17%">Código de Barras:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNumcodbarrasbxop()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Canal de Pagto:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getCanpgtobxop()%></td>
                      <td nowrap class="textoTitulo" width="17%">Meio de Pagamento</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getMeiopgtobxop()%></td>
                    </tr>
                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Indicador Operação Contingência</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getIdopcontg()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data Movimento</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDtmovto()%></td>
                    </tr>
                    <tr>
                      <td nowrap class="textoTitulo" width="17%">Número Referência Atual Baixa Operacional</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getNumReferencia()%></td>
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
		  	              <input type="button" class="button" name="Confirmar" value="Confirmar" onclick="javascript:formSubmit()">
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
        		document.frmMain.estrategia.value="servico.ServicoBaixaOperacionalIniciar"
       			document.frmMain.submit();
	    } 
	    
	    function formSubmit() {
			
    		
   			document.frmMain.submit();
    } 

    </script>
		</s:FormStrategy>
	</p:Document>
</html>