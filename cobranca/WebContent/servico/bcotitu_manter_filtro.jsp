<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Agosto de 2004
*Projeto CAIXA - SIGCB
*Componente: bcotitu_manter_filtro.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 25/10/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BcoTituEstrategia"%>

<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(BcoTituEstrategia.CEDENTE_CABECALHO_BEAN));
	TituloBean tituloBean = (session.getAttribute(BcoTituEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(BcoTituEstrategia.DATA_BEAN));	

	Long filtroSelecao = tituloBean.getFiltroSelecao()==null?new Long(1):tituloBean.getFiltroSelecao();
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=BcoTituEstrategia.STRATEGY_MANTER_FILTRO%>"  
		fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=BcoTituEstrategia.PAGE_TITLE_FILTRO%>"/>
		
		<input type="hidden" name = "filtroSelecao" value="<%=filtroSelecao%>">
		<input type="hidden" name = "filtroDescricaoSituacao" value="">
		<input type="hidden" name = "filtroDescricaoClassificacao" value="">
		<input type="hidden" name = "filtroVoltarListarConsolidado" value="0">
		<input type="hidden" name = "filtroVoltarListarTitulo" value="0">
		<input type="hidden" name = "filtroVoltarAcao" value="0">
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" 
              	 name="codigoCedente" size="7" maxlength="7"
 								 value='<%=tituloBean.getCodigoCedente().equals(new Long(0))?"":tituloBean.getCodigoCedente().toString()%>'
        						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumero);"/> 
							</td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoTitulo" width="26%">&nbsp;</td>
						</tr>
						
						<tr>
							<td colspan="5">&nbsp;</td>
						</tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Opções de Filtro:
                <hr>
              </td>
            </tr>
            <tr> 
              <td class="textoTitulo" width="2%">
                  <input type="radio" name="rdo" value="1" checked 
                   onclick="javascript: clickRadio('1')">
              </td>
              <td class="textoTitulo" width="17%">Nosso Número: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext"
              	name="nossoNumero"
 							  value='<%=tituloBean.getNossoNumero().equals(new Long(0))?"":tituloBean.getNossoNumero().toString()%>'
	              size="23" maxlength="18" 
        						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoTitulo" width="26%">&nbsp;</td>
						</tr>
						


            <tr> 
              <td class="textoTitulo" width="2%">
                  <input type="radio" name="rdo" value="4" checked 
                   onclick="javascript: clickRadio('4')">
              </td>
              <td class="textoTitulo" width="17%">Número de identificação do título: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext"
              	name="nuIdentificaCIP"
 							  value='<%=tituloBean.getNuIdentificaCIP().equals(new Long(0))?"":tituloBean.getNuIdentificaCIP().toString()%>'
	              size="23" maxlength="19" 
        						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoTitulo" width="26%">&nbsp;</td>
			</tr>
			
			
			<tr> 
              <td class="textoTitulo" width="2%">
                  <input type="radio" name="rdo" value="5" checked 
                   onclick="javascript: clickRadio('5')">
              </td>
              <td class="textoTitulo" width="17%">Número de referência do cadastro do título: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext"
              	name="nuRefereciaCIP"
 							  value='<%=tituloBean.getNuRefereciaCIP().equals(new Long(0))?"":tituloBean.getNuRefereciaCIP().toString()%>'
	              size="23" maxlength="19" 
        						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoTitulo" width="26%">&nbsp;</td>
			</tr>
						


			<tr> 
              <td class="textoTitulo" width="2%">
                  <input type="radio" name="rdo" value="6" checked 
                   onclick="javascript: clickRadio('6')">
              </td>
              <td class="textoTitulo" width="17%">Número da baixa efetiva: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext"
              	name="nuBaixa"
 							  value='<%=tituloBean.getNuRefereciaCIP().equals(new Long(0))?"":tituloBean.getNuRefereciaCIP().toString()%>'
	              size="23" maxlength="19" 
        						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoTitulo" width="26%">&nbsp;</td>
			</tr>
						
            <tr> 
              <td class="textoTitulo" width="2%">
                  <input type="radio" name="rdo" value="2" 
                   onclick="javascript: clickRadio('2')">
              </td>
              <td class="textoTitulo" width="17%">Situação do Título: </td>
              
              <td class="textoTitulo" width="26%">
              	<s:ComboSituacaoTitulo name="situacao"
              	selectedValue='<%=tituloBean.getSituacao().toString()%>'
              	valoresFixo="99" descricoesFixo="CONSOLIDADO" onChange="javascript: clickSituacao();"  />	</td>

              <td class="textoTitulo" width="17%">Classificado por: </td>
              <td class="textoTitulo" width="26%">
              	<s:ComboClassificacaoTitulo name="classificacao"
	              	selectedValue='<%=tituloBean.getClassificacao().toString()%>'/>
							</td>
			</tr>
			
			
			<tr> 
              <td class="textoTitulo" width="2%">
                 &nbsp;
              </td>
              <td class="textoTitulo" width="17%">Tipo de Emissão:</td>
              <td class="textoValor" width="26%">
              	<select  name="cmbEmissao" >
              		<option value="00">TODOS</option>
              		<option value="01">Beneficiário</option>
              		<option value="02">CAIXA</option>
              	</select>
              </td>
              <td class="textoTitulo" width="17%">Tipo de Carteira:</td>
              <td class="textoTitulo" width="26%">
               	<select  name="cmbCarteira" >
              		<option value="00">TODOS</option>
              		<option value="01">Registrada</option>
              		<option value="03">Caucionada</option>
              		<option value="04">Descontada</option>
              		<option value="06">Somente Protesto</option>
              	</select>
              
              </td>
			</tr>
			
			
			 <tr>
			 	<td class="textoTitulo" width="2%">&nbsp;</td>
			 	<td class="textoTitulo"  width="17%">Período: </td>
			 	  <td class="textoTitulo" colspan="4" >
   				        <p:InputDate name="dataInicio" 
           						CLASS="inputtext"
           						onFocus="javascript: prevFocus(this);"
								onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataFim);"/> 
							
							até
   				        <p:InputDate name="dataFim" 
           						CLASS="inputtext"
           						onFocus="javascript: prevFocus(this);"
								onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
					</td>
							
			 	
			 </tr>
						<tr>
							<td colspan="5">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="5">&nbsp;</td>
						</tr>
	          <tr>
	            <td align="right" colspan="5">
	              <p align="center"> 
 		            	<s:Button name="Ok" action="javascript:formSubmit()"/>
	              </p>
	            </td>
	          </tr>
          </table>
        </td>
      </tr>
    </table>
    <script>
			function inicia() {
				inicializaCampos()
				setFirstFieldFocus();
			}

			function inicializaCampos() {
<%			if(filtroSelecao.equals(new Long(0)) || filtroSelecao.equals(new Long(1))  || filtroSelecao.equals(new Long(4))  || filtroSelecao.equals(new Long(5))  || filtroSelecao.equals(new Long(6))) { %>
					document.frmMain.rdo[0].checked = true;
					clickRadio("1");
<%			} else { %>
					document.frmMain.rdo[1].checked = true;
					clickRadio("2");
<%			} %>
			}
			
			function clickRadio(valor) {
				document.frmMain.filtroSelecao.value = valor;
				if (valor == "1") { // acesso por nosso numero
					if (document.frmMain.nossoNumero.value.indexOf('~') != -1)
						document.frmMain.nossoNumero.value = "";
						document.frmMain.nossoNumero.disabled = false;
						document.frmMain.nuIdentificaCIP.value = "";
						document.frmMain.nuIdentificaCIP.disabled = true;
						document.frmMain.nuRefereciaCIP.value = "";
						document.frmMain.nuRefereciaCIP.disabled = true;
						document.frmMain.nuBaixa.value = "";
						document.frmMain.nuBaixa.disabled = true;
						document.frmMain.situacao.disabled = true;
		  				document.frmMain.classificacao.disabled = true;
		  				document.frmMain.cmbEmissao.disabled = true;
		  				document.frmMain.cmbCarteira.disabled = true;
		  				document.frmMain.dataInicio.disabled = true;
		  				document.frmMain.dataFim.disabled = true;
		  				document.frmMain.nossoNumero.focus();
		  				
							  				
				} else if (valor == "2") { //acesso por situacao do titulo
					document.frmMain.nossoNumero.value = "~~~~~~~~~~~~~~~~~~~~";
					document.frmMain.nossoNumero.disabled = true;
					document.frmMain.nuIdentificaCIP.value = "";
					document.frmMain.nuIdentificaCIP.disabled = true;
					document.frmMain.nuRefereciaCIP.value = "";
					document.frmMain.nuRefereciaCIP.disabled = true;
					document.frmMain.nuBaixa.value = "";
					document.frmMain.nuBaixa.disabled = true;
	  				document.frmMain.situacao.disabled = false;
	  				document.frmMain.classificacao.disabled = false;
	  				document.frmMain.cmbEmissao.disabled = false;
	  				document.frmMain.cmbCarteira.disabled = false;
	  				document.frmMain.dataInicio.disabled = false;
	  				document.frmMain.dataFim.disabled = false;
	  				document.frmMain.situacao.focus();
				} else if (valor == "4") { // Nu Identificacao CIP 
					document.frmMain.nossoNumero.value = "~~~~~~~~~~~~~~~~~~~~";
					document.frmMain.nossoNumero.disabled = true;
					document.frmMain.nuIdentificaCIP.value = "";
					document.frmMain.nuIdentificaCIP.disabled = false;
					document.frmMain.nuRefereciaCIP.value = "";
					document.frmMain.nuRefereciaCIP.disabled = true;
					document.frmMain.nuBaixa.value = "";
					document.frmMain.nuBaixa.disabled = true;
	  				document.frmMain.situacao.disabled = true;
	  				document.frmMain.classificacao.disabled = true;
	  				document.frmMain.cmbEmissao.disabled = true;
	  				document.frmMain.cmbCarteira.disabled = true;
	  				document.frmMain.dataInicio.disabled = true;
	  				document.frmMain.dataFim.disabled = true;
	  				document.frmMain.nuIdentificaCIP.focus();
				} else if (valor == "5") { // Nu referencia CIP
					document.frmMain.nossoNumero.value = "~~~~~~~~~~~~~~~~~~~~";
					document.frmMain.nossoNumero.disabled = true;
					document.frmMain.nuIdentificaCIP.value = "";
					document.frmMain.nuIdentificaCIP.disabled = true;
					document.frmMain.nuRefereciaCIP.value = "";
					document.frmMain.nuRefereciaCIP.disabled = false;
					document.frmMain.nuBaixa.value = "";
					document.frmMain.nuBaixa.disabled = true;
	  				document.frmMain.situacao.disabled = true;
	  				document.frmMain.classificacao.disabled = true;
	  				document.frmMain.cmbEmissao.disabled = true;
	  				document.frmMain.cmbCarteira.disabled = true;
	  				document.frmMain.dataInicio.disabled = true;
	  				document.frmMain.dataFim.disabled = true;
	  				document.frmMain.nuRefereciaCIP.focus();
				}else if (valor == "6") { // Nu BAIXA CIP
					document.frmMain.nossoNumero.value = "~~~~~~~~~~~~~~~~~~~~";
					document.frmMain.nossoNumero.disabled = true;
					document.frmMain.nuIdentificaCIP.value = "";
					document.frmMain.nuIdentificaCIP.disabled = true;
					document.frmMain.nuRefereciaCIP.value = "";
					document.frmMain.nuRefereciaCIP.disabled = true;
					document.frmMain.nuBaixa.value = "";
					document.frmMain.nuBaixa.disabled = false;
	  				document.frmMain.situacao.disabled = true;
	  				document.frmMain.classificacao.disabled = true;
	  				document.frmMain.cmbEmissao.disabled = true;
	  				document.frmMain.cmbCarteira.disabled = true;
	  				document.frmMain.dataInicio.disabled = true;
	  				document.frmMain.dataFim.disabled = true;
	  				document.frmMain.nuBaixa.focus();
								
				}
		}
			
	    function formSubmit() {
		    if(!validaRadioButton(document.frmMain.rdo, '')){
				  return false;
		    }
	    	if (!validaSubmit()) {
	    		return false;
	    	}
			if (document.frmMain.filtroSelecao.value == "2") { 
	     	  	var iSituacao = document.frmMain.situacao.selectedIndex;
    		    document.frmMain.filtroDescricaoSituacao.value = document.frmMain.situacao.options[iSituacao].text;
    	    	var iClassificacao = document.frmMain.classificacao.selectedIndex;											 			
    	    	document.frmMain.filtroDescricaoClassificacao.value = document.frmMain.classificacao.options[iClassificacao].text;
	 		}
   	    	document.frmMain.submit();
		}
			
		function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.codigoCedente, "Cedente")) {
				  return false;
		    }
			if (document.frmMain.rdo[0].checked == true) {
			   	if(!validaCampoObrigatorio(document.frmMain.nossoNumero, "Nosso Número")) {
				  	return false;
			   	}
			   	
			   	
			} else if (document.frmMain.filtroSelecao.value=="4") {
				   	if(!validaCampoObrigatorio(document.frmMain.nuIdentificaCIP, "Número Identicação CIP")) {
					  	return false;
				   	}			   	

			} else if (document.frmMain.filtroSelecao.value=="5") {
			   	if(!validaCampoObrigatorio(document.frmMain.nuRefereciaCIP, "Número de referência")) {
				  	return false;
			   	}
			} else if (document.frmMain.filtroSelecao.value=="6") {
			   	if(!validaCampoObrigatorio(document.frmMain.nuBaixa, "Número da baixa")) {
				  	return false;
			   	}			   	
		  	}else {
		  		if(!validaClassificadoPor()){
		  			msg("074","","","", "false","");
		  			return false;
		  		}
		  	}
		  	return true;
		}
		
		
		function clickSituacao(){
			var situacaoCombo = document.frmMain.situacao.value;
			if (situacaoCombo=="99"){
				
				document.frmMain.dataInicio.value="";
				document.frmMain.dataFim.value="";
				document.frmMain.classificacao.disabled = true;
  				document.frmMain.dataInicio.disabled = true;
  				document.frmMain.dataFim.disabled = true;
				
			}else{
				
				document.frmMain.classificacao.disabled = false;
  				document.frmMain.dataInicio.disabled = false;
  				document.frmMain.dataFim.disabled = false;
			}
			
			
		}
		
		function validaClassificadoPor(){
                       
            var situacaoCombo = document.frmMain.situacao;
            var classificacaoCombo = document.frmMain.classificacao;
            
            var situacaoValor = situacaoCombo.getAttribute('value');
            var classificacaoValor = classificacaoCombo.getAttribute('value');
           
             
            //DATA DE LIQUIDACAO
            if(classificacaoValor == "4"){
            	//02LIQUIDADO PV - 03LIQUIDADO CARTORIO
                if (situacaoValor == "2" || situacaoValor == "3"){
                    return true;
                }
                else{
                    return false;
                }
            }
         
           //DATA DE ULTIMO COMANDO
            else if(classificacaoValor == '5'){
                //01EM ABERTO
                if(situacaoValor == '1'){
                    return true;
                }
                else{
                    return false;
                }
            }
            return true;
        }		
    </script>
  </s:FormStrategy>
</p:Document></html>
