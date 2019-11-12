<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servdia_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualiza��o: 25/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServDiaEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean "%>

<%
	ConGerServicosSolicitadosBean filtroBean = (session.getAttribute(ServDiaEstrategia.BEAN_FILTRO)==null? new ConGerServicosSolicitadosBean()
																			:(ConGerServicosSolicitadosBean)session.getAttribute(ServDiaEstrategia.BEAN_FILTRO));

	filtroBean.setCodigoCedente(session.getAttribute(ServDiaEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(ServDiaEstrategia.CEDENTE_ATUAL));
%>


<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=ServDiaEstrategia.STRATEGY_FILTRO%>" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Servi�os Solicitados no dia >> Filtro"/>
        
    <input type="hidden" name="tpConsulta" value="">
    
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="26%"> 
               <p:InputNumerico name="codigoCedente" maxlength="7" size="7"  CLASS="inputtext" 
              				value='<%=filtroBean.getCodigoCedente().equals( new Long(0))?"":filtroBean.getCodigoCedente().toString()%>'
		              	  onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.radioRelatorio);"/>                 

              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr>
              <td colspan="4">
                <div id="ServicosDia" class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="6">&nbsp;</td>
                    </tr>
				            <tr> 
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Agendamento de Emiss�o T�tulos para Banco de Sacados</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Boleto Pr�-Impresso</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
										</tr>
				            <tr> 
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Emiss�o de T�tulos para Banco de Sacados</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Extrato de Movimenta��o de T�tulos</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
										</tr>
				            <tr> 
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Extrato de Distribui��o de Creditos e Debitos</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Lan�amento de Tarifa Manual</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
										</tr>
				            <tr> 
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Recupera��o de T�tulos Baixados ou Liquidados</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Redisponibiliza��o de Arquivo de Retorno</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
										</tr>
				            <tr>
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Reemiss�o de Boletos</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
				              <td class="textoTitulo" width="2%">
                                <input type="radio" name="radioRelatorio">
                              </td>
				              <td class="textoTitulo" width="30%">Todos</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
										</tr>
				            <tr> 
                      <td colspan="6">&nbsp;</td>
                    </tr>
                  </table>
                </div>
              </td>
            </tr>
            
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="4">
                <p align="center"> 
                  <s:Button name="Ok" action="javascript:formSubmit()"/>
                </p>
              </td>
            </tr>
          </table>
        </TD>
      </tr>
    </table>
    <script>
     	function inicia() {
				setFirstFieldFocus();
				<%
				int tpConsulta = filtroBean.getTpConsulta() == null?0:filtroBean.getTpConsulta().intValue();
				if(tpConsulta == 0){
					tpConsulta = 7; //Agend. Emiss�o t�tulos p/ banco de sacados
				}	%>
				selecionarRadio('<%=tpConsulta%>',document.frmMain.radioRelatorio);
			}
      
      function formSubmit(){
      	if(validaSubmit()){
      		document.frmMain.submit();
      	}
      }
    
      function validaSubmit(){
      	if(validaCampoObrigatorio(document.frmMain.codigoCedente, 'C�digo Cedente')){
		  		if(document.frmMain.radioRelatorio[0].checked){<!--Agend. Emiss�o t�tulos p/ banco de sacados-->
						document.frmMain.tpConsulta.value="7";
						return true; 			
		  		}
		  		if(document.frmMain.radioRelatorio[1].checked){<!--Bloqueto Pr� impresso-->
		  			document.frmMain.tpConsulta.value="3";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[2].checked){<!--Emiss�o de titulos p/ banco de sacados-->
		  			document.frmMain.tpConsulta.value="6";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[3].checked){<!--extrato de movimenta��o de titulos-->
		  			document.frmMain.tpConsulta.value="5";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[4].checked){<!--Extrato distribui��o de cr�ditos e debitos-->
		  			document.frmMain.tpConsulta.value="9";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[5].checked){<!--Lancamento de Tarifa Manual-->
		  			document.frmMain.tpConsulta.value="999";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[6].checked){<!--Recupera��o de titulos baixados ou liquidados-->
		  			document.frmMain.tpConsulta.value="8";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[7].checked){<!--redisponibiliza��o de arquivo de retorno-->
		  			document.frmMain.tpConsulta.value="2";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[8].checked){<!--Reemiss�o de bloquetos-->
		  			document.frmMain.tpConsulta.value="888";
		  			return true;
		  		}
   		  		if(document.frmMain.radioRelatorio[9].checked){<!--Todos p/ DIA-->
		  			document.frmMain.tpConsulta.value="11";
		  			return true;
		  		}

					//EAM 15/09 alert('� necess�rio a sele��o de pelo menos um tipo de relat�rio.');
	  			msg('041','tipo de relat�rio');
	  		}
	 			return false;
      }
 			//EAM - 15/09/05 - 
 			function selecionarRadio(tpConsulta,radioRelatorio){
 				var radio = new Array(8);
 				radio[0] = "7";		<%//Agend. Emiss�o t�tulos p/ banco de sacados%>
 				radio[1] = "3";		<%//Bloqueto Pr� impresso%>
 				radio[2] = "6";		<%//Emiss�o de titulos p/ banco de sacados%>
 				radio[3] = "5";		<%//Extrato de movimenta��o de titulos%>
 				radio[4] = "9";		<%//Extrato distribui��o de cr�ditos e debitos%>
 				radio[5] = "999";	<%//Lancamento de Tarifa Manual%>
 				radio[6] = "8";		<%//Recupera��o de titulos baixados ou liquidados%>
 				radio[7] = "2";		<%//Redisponibiliza��o de arquivo de retorno%>		
 				radio[8] = "888";	<%//Reemiss�o de bloquetos%>
 				radio[9] = "11";     <%//Todos - para Dia%>
				for(i =(radio.length-1); i >=0; i--){
					if(tpConsulta == radio[i]){
						radioRelatorio[i].checked = true;
						break;
					}
				}
 			}
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
