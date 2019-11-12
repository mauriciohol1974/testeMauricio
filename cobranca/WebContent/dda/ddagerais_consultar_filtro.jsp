<%
/***********************************************
*Projeto CAIXA - SIGCB DDA
*Componente: ddagerais_consultar_filtro.jsp - Java Server Pages
*Criado em: 02/10/2009
*Autor: Glauber Gallego
*Ultima Atualização: 02/10/2009
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.dda.DdaGeraisEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.DdaGeraisBean"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	DdaGeraisBean ddaGeraisBean = (session.getAttribute(DdaGeraisEstrategia.BEAN_FILTRO)==null?
                                new DdaGeraisBean():
                                (DdaGeraisBean)session.getAttribute(DdaGeraisEstrategia.BEAN_FILTRO));
%>

<s:Header/>
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=DdaGeraisEstrategia.STRATEGY_FILTRO%>" fluxo="normal">
 		<s:Menu/>
 		<s:Titulo name="<%=DdaGeraisEstrategia.PAGE_TITLE_FILTRO%>"/>

		<input type="hidden" name="tipoPessoaSacado"   value="" />
		<input type="hidden" name="cpfCnpjSacado"	     value="" />
		<input type="hidden" name="tipoDataFiltro"     value="" />
		<input type="hidden" name="tipoDataFiltroForm" value="" />
		<input type="hidden" name="mesAnoFiltro"	     value="" />
		<input type="hidden" name="tipoConsulta" 	     value="" />
		<input type="hidden" name="tipoConsultaForm" 	 value="" />

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr valign="top">
              <td colspan="5" class="textoTitulo">Filtro:
                <hr>
              </td>
            </tr>

						<tr>
  						<td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td width="26%">
              	<s:ComboTipoPessoa name="tipoPessoaSacadoInput"
               		onChange="javascript:limpaCpfCnpj(cpfCnpjSacadoInput);"
              		selectedValue='<%=ddaGeraisBean.getTipoPessoaSacado().equals("")||ddaGeraisBean.getTipoPessoaSacado().equals("J")?"2":"1"%>'/>
                <p:InputCpfCnpj CLASS="inputtext" name="cpfCnpjSacadoInput"
              		value='<%=ddaGeraisBean.getCpfCnpjSacado().equals(new Long(0))?"":ddaGeraisBean.getCpfCnpjSacadoFormatado().toString()%>'
              		onBlur="javascript:formataCpfCnpj(this, tipoPessoaSacadoInput);"
              		onFocus="javascript:unFormataCpfCnpj(this, tipoPessoaSacadoInput);prevFocus(this);"/>
              </td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
						</tr>

						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rdTipoDataFiltro" onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.mesAnoFiltroInput);">
              </td>
              <td class="textoTitulo" width="17%">Mes/Ano: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico name="mesAnoFiltroInput" disabled="true" size="8" maxlength="6" CLASS="inputtext"
              				onBlur="javascript:formataMesAnoFiltro(this);"
              				onFocus="javascript:unFormataMesAnoFiltro(this);"/>
              </td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="rdTipoDataFiltro" onclick="javascript:habilitaDigitacao();radioNextFocus(document.frmMain.dataFiltro);">
              </td>
              <td class="textoTitulo" width="17%">Data: </td>
              <td class="textoValor" width="26%">
              	<p:InputDate name="dataFiltro" CLASS="inputtext" disabled="true"/>
              </td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
						</tr>

            <tr>
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td colspan="5" class="textoTitulo">Consultas:
                <hr>
              </td>
            </tr>

            <tr>
              <td colspan="5">
	              <div class="group">
		              <table width="95%" border="0" cellspacing="0" cellpadding="0" height="14" valign="middle" align="center">
	                	<tr>
	                 		<td colspan="6">&nbsp;</td>
	                	</tr>
								    <tr>
											<td class="textoTitulo" width="2%">
												<input type="radio" name="rdTipoConsulta">
											</td>
											<td class="textoTitulo" width="30%">Títulos Enviados</td>
											<td class="textoValor" width="5%">&nbsp;</td>
											<td class="textoTitulo" width="2%">
												<input type="radio" name="rdTipoConsulta">
											</td>
											<td class="textoTitulo" width="30%">Títulos Pagos</td>
											<td class="textoValor" width="5%">&nbsp;</td>
										</tr>
										<tr>
											<td class="textoTitulo" width="2%">
												<input type="radio" name="rdTipoConsulta">
											</td>
											<td class="textoTitulo" width="30%">Aceite / Alegação</td>
											<td class="textoValor" width="5%">&nbsp;</td>
											<td class="textoTitulo" width="2%">
												<input type="radio" name="rdTipoConsulta">
											</td>
											<td class="textoTitulo" width="30%">Títulos Vencidos</td>
											<td class="textoValor" width="5%">&nbsp;</td>
										</tr>
										<tr>
											<td class="textoTitulo" width="2%">
												<input type="radio" name="rdTipoConsulta">
											</td>
											<td class="textoTitulo" width="30%">Quarentena</td>
											<td class="textoValor" width="5%">&nbsp;</td>
											<td class="textoTitulo" width="2%">
												<input type="radio" name="rdTipoConsulta">
											</td>
											<td class="textoTitulo" width="30%">Títulos de Sacado Eletronico Excluido</td>
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
                	<s:Button name="Ok" action="javascript:formSubmit();"/>
                </p>
              </td>
            </tr>
          </table>
        </TD>
      </tr>
    </table>
     <script>

      // ############################## Inicializacao

      function inicia(){
				setFirstFieldFocus();
			  // obtendo histórico de volta para os radios
				document.frmMain.rdTipoDataFiltro[<%=ddaGeraisBean.getTipoDataFiltroForm()%>].checked = true;
				document.frmMain.rdTipoConsulta[<%=ddaGeraisBean.getTipoConsultaForm()%>].checked = true;
			  // carrega valores nos campos de data
				if (document.frmMain.rdTipoDataFiltro[0].checked){
					document.frmMain.dataFiltro.disabled				= true;
					document.frmMain.mesAnoFiltroInput.disabled = false;
					document.frmMain.dataFiltro.value 					= "";
					if (document.frmMain.mesAnoFiltroInput.value == ""){
					<%if (ddaGeraisBean.getDataFiltroFormatada().length() == 7){%>
						document.frmMain.mesAnoFiltroInput.value	 = "<%=ddaGeraisBean.getDataFiltroFormatada()%>";
					<%}%>
					}
				} else if(document.frmMain.rdTipoDataFiltro[1].checked){
					document.frmMain.dataFiltro.disabled				= false;
					document.frmMain.mesAnoFiltroInput.disabled = true;
					document.frmMain.mesAnoFiltroInput.value 		= "";
					<%/*carregando dados*/%>
					if (document.frmMain.dataFiltro.value == ""){
					<%if (ddaGeraisBean.getDataFiltroFormatada().length() == 10){%>
						document.frmMain.dataFiltro.value		= "<%=ddaGeraisBean.getDataFiltroFormatada()%>";
					<%}%>
					}
				}
      }

      // ############################## Finalizacao

			function formSubmit(){
				if(validaSubmit()){
					document.frmMain.mesAnoFiltro.value = document.frmMain.mesAnoFiltroInput.value.replace('/','.')
      		document.frmMain.cpfCnpjSacado.value = document.frmMain.cpfCnpjSacadoInput.value;
      		unFormataCpfCnpj(document.frmMain.cpfCnpjSacado, document.frmMain.tipoPessoaSacadoInput);
					document.frmMain.submit();
				}
			}

      // ############################## Validacao

			function validaSubmit(){
				if(!validaCpfCnpj()){
					return false;
				}
				if(!validaRdTipoDataFiltro()){
					return false;
				}
				if(!validaRdTipoConsulta()){
					return false;
				}
				return true;
			}

			function validaCpfCnpj(){
   			if (validaCampoObrigatorio(document.frmMain.cpfCnpjSacadoInput,'CPF/CNPJ')){
   				if (document.frmMain.tipoPessoaSacadoInput.value == "1"){
						document.frmMain.tipoPessoaSacado.value = "F";
   					if (validaDVCPF(document.frmMain.cpfCnpjSacadoInput)){
   						return true;
   					}else{
   						alert("Dígito verificador CPF Inválido.");
   						return false;
   					}
   				}else if (validaDVCNPJ(document.frmMain.cpfCnpjSacadoInput)){
						document.frmMain.tipoPessoaSacado.value = "J";
   					return true;
   				}else{
   					alert("Dígito Verificador do CNPJ Inválido.");
   					return false;
   				}
   				return false;
   			}
			}

			function validaMesAno(obj){
				objTemp = new Object("value");
				objTemp.value = "01/"+ obj.value;
				if (!validaData(objTemp,'')){
					msg('029',obj.value+' (Mês/Ano)','','','');
					obj.focus();
					return false;
				}
				return true;
			}

			function validaRdTipoDataFiltro(){
				if(document.frmMain.rdTipoDataFiltro[0].checked){
					if(validaCampoObrigatorio(document.frmMain.mesAnoFiltroInput, 'Mês/Ano')){
						if(validaMesAno(document.frmMain.mesAnoFiltroInput)){
							document.frmMain.tipoDataFiltro.value = "1";
							document.frmMain.tipoDataFiltroForm.value = "0";
							return true;
						}
					}
				}else	if(document.frmMain.rdTipoDataFiltro[1].checked){
					if(validaCampoObrigatorio(document.frmMain.dataFiltro, 'Data')){
						if (validaData(document.frmMain.dataFiltro,'')){
							document.frmMain.tipoDataFiltro.value = "2";
							document.frmMain.tipoDataFiltroForm.value = "1";
							return true;
			    	}else{
			    		alert("Data invalida.");
			    	}
					}
				}else{
					msg('003','Tipo de Data','','','');
				}
				return false;
			}

			function validaRdTipoConsulta(){
				for (var i=0; i< document.frmMain.rdTipoConsulta.length ; i++) {
	    		if (document.frmMain.rdTipoConsulta[i].checked) {
	    			switch (i) {
	    			case 00:
	    				document.frmMain.tipoConsultaForm.value = "0";
	    				document.frmMain.tipoConsulta.value = "00";
	    				break;
	    			case 01:
	    				document.frmMain.tipoConsultaForm.value = "1";
 	    				document.frmMain.tipoConsulta.value = "01";
	    				break;
	    			case 02:
	    				document.frmMain.tipoConsultaForm.value = "2";
	    				document.frmMain.tipoConsulta.value = "02";
	    				break;
	    			case 03:
	    				document.frmMain.tipoConsultaForm.value = "3";
	    				document.frmMain.tipoConsulta.value = "03";
	    				break;
	    			case 04:
	    				document.frmMain.tipoConsultaForm.value = "4";
	    				document.frmMain.tipoConsulta.value = "04";
	    				break;
	    			case 05:
	    				document.frmMain.tipoConsultaForm.value = "5";
	    				document.frmMain.tipoConsulta.value = "05";
	    				break;
	        	}
	        }
	    	}
	    	if(document.frmMain.tipoConsultaForm.value == ""){
	    		msg('003','tipo de consulta','','','');
	    		return false;
	    	}else{
	    		return true;
	    	}
			}

      // ############################## Controle de habilita/desabilita

			function habilitaDigitacao(){
				if (document.frmMain.rdTipoDataFiltro[0].checked){
					document.frmMain.dataFiltro.disabled				= true;
					document.frmMain.mesAnoFiltroInput.disabled = false;
					document.frmMain.dataFiltro.value 					= "";
				} else if(document.frmMain.rdTipoDataFiltro[1].checked){
					document.frmMain.dataFiltro.disabled				= false;
					document.frmMain.mesAnoFiltroInput.disabled = true;
					document.frmMain.mesAnoFiltroInput.value 		= "";
				}
			}

      // ############################## Formatacao

			function formataMesAnoFiltro(obj){
				strMesAno = obj.value;
				strMes = strMesAno.substr(0,2);
				strAno = strMesAno.substr(2);
				if (strMesAno.length == 4) {
			   	if (strAno > '70') {
     				strAno = '19' + strAno;
   				} else {
     				strAno = '20' + strAno;
   				}
				}
				if(strMesAno.length > 0){
					obj.value = strMes+"/"+strAno;
				}
				return;
			}
			function unFormataMesAnoFiltro(obj){
				strMesAno = obj.value;
				obj.value = strMesAno.replace('/','');
			}

    </script>
 		</s:FormStrategy>
	</p:Document>
</html>