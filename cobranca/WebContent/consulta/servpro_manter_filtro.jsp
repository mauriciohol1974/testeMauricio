<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servpro_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 25/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServProEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean "%>
<%@page import="br.gov.caixa.sigcb.util.UtilDatas"%>

<%
	ConGerServicosSolicitadosBean filtroBean = (session.getAttribute(ServProEstrategia.BEAN_FILTRO)==null? new ConGerServicosSolicitadosBean()
																			:(ConGerServicosSolicitadosBean)session.getAttribute(ServProEstrategia.BEAN_FILTRO));

    
    Long zeroLong = new Long(0);

	filtroBean.setCodigoCedente(session.getAttribute(ServProEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(ServProEstrategia.CEDENTE_ATUAL));
%>


<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.ServProManterFiltro" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="<%=ServProEstrategia.PAGE_TITLE_FILTRO%>"/>
        
    <input type="hidden" name="tpConsulta" value="">
		<input type="hidden" name = "dataHoje" value="<%=UtilDatas.getToday()%>">
    
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr>
            	<td class="textoTitulo" width="2%">
	              <input type="radio" name="tpFiltro" value="0" onclick="javascript:habilitaDigitacao();">
	            </td>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="26%"> 
                <p:InputNumerico name="codigoCedente" maxlength="7" size="7"  CLASS="inputtext" disabled="true" 
	             	  value='<%=zeroLong.equals(filtroBean.getCodigoCedente()) || filtroBean.getCodigoCedente() == null?"":filtroBean.getCodigoCedente().toString()%>'
	             	  onFocus="javascript: prevFocus(this);"
  	              onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataSolicitacao);"/>
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr>
            	<td class="textoTitulo" width="2%">
	              <input type="radio" name="tpFiltro" value="1" onclick="javascript:habilitaDigitacao();">
	            </td>
              <td class="textoTitulo" width="17%">PV Vinculação: </td>
              <td width="26%"> 
                <p:InputNumerico name="codigoUnidadePv" maxlength="4" size="5"  CLASS="inputtext" disabled="true" 
  	             	  value='<%=zeroLong.equals(filtroBean.getCodigoUnidadePv()) || filtroBean.getCodigoUnidadePv() == null ? "":filtroBean.getCodigoUnidadePv().toString()%>'
	              	  onFocus="javascript: prevFocus(this);"
	                	onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataSolicitacao);"/>
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>

            <tr>
            	<td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Data Solicitação: </td>
              <td width="26%">
              	<p:InputDate name="dataSolicitacao" CLASS="inputtext"
		              	  value = '<%=filtroBean.getDataSolicitacaoFormatada()%>'
		              	  onFocus="javascript: prevFocus(this);"
											onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.radioRelatorio);"/>                               	
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            
            
            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
            
            <tr>
              <td colspan="5">
                <div id="ServicosProc" class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="6">&nbsp;</td>
                    </tr>
				            <tr> 
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Agendamento Emissão Títulos para Banco de Sacados</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Boleto Pré-Impresso</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
										</tr>
				            <tr> 
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio" >
				              </td>
				              <td class="textoTitulo" width="30%">Emissão de Títulos para Banco de Sacados</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio" >
				              </td>
				              <td class="textoTitulo" width="30%">Extrato de Movimentação de Títulos</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
										</tr>
				            <tr> 
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio" >
				              </td>
				              <td class="textoTitulo" width="30%">Extrato Distribuição de Creditos e Debitos</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio" >
				              </td>
				              <td class="textoTitulo" width="30%">Lançamento de Tarifa Manual</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
										</tr>
				            <tr> 
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio" >
				              </td>
				              <td class="textoTitulo" width="30%">Recuperação Títulos Baixados ou Liquidados</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio" >
				              </td>
				              <td class="textoTitulo" width="30%">Redisponibilização de Arquivo Retorno</td>
				              <td class="textoValor" width="5%">&nbsp;</td>
										</tr>
				            <tr>
				              <td class="textoTitulo" width="2%">
				                <input type="radio" name="radioRelatorio">
				              </td>
				              <td class="textoTitulo" width="30%">Reemissão de Boletos</td>
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
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="5">
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
				document.frmMain.tpFiltro[<%=filtroBean.getTpFiltro()%>].checked = true;
				habilitaDigitacao();
				selecionaConsulta();
				
			}
      
      function formSubmit(){
      	if(validaSubmit()){
      		document.frmMain.submit();
      	}
      }

      function validaSubmit(){
      

      	if (!validaRadioButtonMsg(document.frmMain.tpFiltro, 'Tipo filtro', '041')) {
      		return false;
      	}else{
					if(document.frmMain.tpFiltro[0].checked){
			  		if (!validaCampoObrigatorio(document.frmMain.codigoCedente,'cedente')){
			 				return false;
			 			}
			  	}
			  	if(document.frmMain.tpFiltro[1].checked){
			     	if (!validaCampoObrigatorio(document.frmMain.codigoUnidadePv,'PV de Vinculacao')){
			 				return false;
			 			}
			    } 
			    if (!validaCampoObrigatorio(document.frmMain.dataSolicitacao,'data da solicitação')){
			 				return false;
			 		}
			 		if (!validaData(document.frmMain.dataSolicitacao,'data da solicitação')){
							<%//EAM 23/08
							//alert("Data de solicitação Invalida.");%>
							msg('014','Data Solicitação');
							return false;		    
			    }
		    }
	      
		    if(trim(document.frmMain.dataSolicitacao.value) != "" && validaData(document.frmMain.dataSolicitacao)){
		    	if(!compararDatas(document.frmMain.dataSolicitacao.value,document.frmMain.dataHoje.value,"<")){
		    		msg("007", "Data Solicitação", document.frmMain.dataHoje.value)
		    		return false;
		    	}
		    }	      
	      
	      if (!validaRadioButtonMsg(document.frmMain.radioRelatorio, 'Tipo Consulta', '041')) {
	  				return false;    		
	      }else{
		  		if(document.frmMain.radioRelatorio[0].checked){<!--Agend. Emissão títulos p/ banco de sacados-->
						document.frmMain.tpConsulta.value="7";
						return true; 			
		  		}
		  		if(document.frmMain.radioRelatorio[1].checked){<!--Bloqueto Pré impresso-->
		  			document.frmMain.tpConsulta.value="3";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[2].checked){<!--Emissão de titulos p/ banco de sacados-->
		  			document.frmMain.tpConsulta.value="6";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[3].checked){<!--extrato de movimentação de titulos-->
		  			document.frmMain.tpConsulta.value="5";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[4].checked){<!--Extrato distribuição de créditos e debitos-->
		  			document.frmMain.tpConsulta.value="9";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[5].checked){<!--Lancamento de Tarifa Manual-->
		  			document.frmMain.tpConsulta.value="999";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[6].checked){<!--Recuperação de titulos baixados ou liquidados-->
		  			document.frmMain.tpConsulta.value="8";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[7].checked){<!--redisponibilização de arquivo de retorno-->
		  			document.frmMain.tpConsulta.value="2";
		  			return true;
		  		}
		  		if(document.frmMain.radioRelatorio[8].checked){<!--Reemissão de bloquetos-->
		  			document.frmMain.tpConsulta.value="888";
		  			return true;
		  		}
              if(document.frmMain.radioRelatorio[9].checked){<!--Todos-->
                    document.frmMain.tpConsulta.value="1";
                    return true;
		  		}              
            //EAM 15/09 alert('É necessário a seleção de pelo menos um tipo de relatório.');
	  			msg('041','tipo de relatório');                
  			}
      }
      
      function habilitaDigitacao(){
     			if (document.frmMain.tpFiltro[0].checked) {
        			document.frmMain.codigoCedente.disabled = false;
							document.frmMain.codigoCedente.value = "<%=filtroBean.getCodigoCedente().equals( new Long(0))?"":filtroBean.getCodigoCedente().toString()%>";
        			document.frmMain.codigoUnidadePv.value ="";
        			document.frmMain.codigoUnidadePv.disabled = true;
        			document.frmMain.codigoCedente.focus();
        	} else if (document.frmMain.tpFiltro[1].checked) {
        			document.frmMain.codigoCedente.value ="";
        			document.frmMain.codigoCedente.disabled = true;
        			document.frmMain.codigoUnidadePv.disabled = false;
        			document.frmMain.codigoUnidadePv.focus();
        	}
      }	 	  
 			function selecionaConsulta(){
 				var consulta = new Number(<%=filtroBean.getTpConsulta()%>);
 				switch (parseInt(consulta)){
 					case 7:
	 					document.frmMain.radioRelatorio[0].checked = true
 						break
 					case 3:
	 					document.frmMain.radioRelatorio[1].checked = true
 						break
 					case 6:
	 					document.frmMain.radioRelatorio[2].checked = true
 						break 		
 					case 5:
	 					document.frmMain.radioRelatorio[3].checked = true
 						break 			
 					case 9:
	 					document.frmMain.radioRelatorio[4].checked = true
 						break 													
 					case 999:
	 					document.frmMain.radioRelatorio[5].checked = true
 						break 			
 					case 8:
	 					document.frmMain.radioRelatorio[6].checked = true
 						break 		
 					case 2:
	 					document.frmMain.radioRelatorio[7].checked = true
 						break 													
 					case 888:
	 					document.frmMain.radioRelatorio[8].checked = true
 						break
 					case 1:
	 					document.frmMain.radioRelatorio[9].checked = true
 						break 		 						
 					default:
 						document.frmMain.radioRelatorio[0].checked = true
 				}
 			}
 
    </script>
   </s:FormStrategy>
	</p:Document>
</html>
