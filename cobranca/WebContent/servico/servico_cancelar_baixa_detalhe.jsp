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
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ServicoCancelarBaixaOperacionalEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
	
	ServicoBaixaBean baixaBean = (ServicoBaixaBean)session.getAttribute(ServicoCancelarBaixaOperacionalEstrategia.DATA_BEAN);

%>


<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="servico.ServicoCancelarBaixaOperacionalDetalhe" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=ServicoCancelarBaixaOperacionalEstrategia.PAGE_TITLE_LISTAR%>"/>
 		
 		
 		
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
                    </tr>
                    

                    
					<tr>
                      <td nowrap class="textoTitulo" width="17%">Data/Hora Cancelamento: </td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDthrprocbxop()%></td>
                      <td nowrap class="textoTitulo" width="17%">Data de Movimento:</td>
				      <td nowrap class="textoValor" width="26%"><%=baixaBean.getDtmovto()%></td>
                     
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
        		document.frmMain.estrategia.value="servico.ServicoCancelarBaixaOperacionalIniciar"
       			document.frmMain.submit();
	    } 
	    
	    function formSubmit() {
			
    		
   			document.frmMain.submit();
    } 

    </script>
		</s:FormStrategy>
	</p:Document>
</html>