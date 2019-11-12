<%
/***********************************************
*Projeto CAIXA - SIGCB DDA
*Componente: ddareimpbloqueto_consultar_filtro.jsp - Java Server Pages
*Criado em: 15/01/2010
*Autor: Glauber Gallego
*Ultima Atualização: 15/01/2010
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.dda.DdaReimpBloquetoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.DdaReimpBloquetoBean"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>

<%
  DdaReimpBloquetoBean ddaReimpBloquetoBean = (session.getAttribute(DdaReimpBloquetoEstrategia.BEAN_FILTRO)==null?
                                new DdaReimpBloquetoBean():
                               (DdaReimpBloquetoBean)session.getAttribute(DdaReimpBloquetoEstrategia.BEAN_FILTRO));
%>

<s:Header/>
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=DdaReimpBloquetoEstrategia.STRATEGY_FILTRO%>" fluxo="normal">
 		<s:Menu/>
 		<s:Titulo name="<%=DdaReimpBloquetoEstrategia.PAGE_TITLE_FILTRO%>"/>

		<input type="hidden" name="tipoPessoaSacado"   value="" />
		<input type="hidden" name="cpfCnpjSacado"	     value="" />

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr valign="top">
              <td colspan="4" class="textoTitulo">Filtro:
                <hr>
              </td>
            </tr>

						<tr>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td width="26%">
              	<s:ComboTipoPessoa name="tipoPessoaSacadoInput"
               		onChange="javascript:limpaCpfCnpj(cpfCnpjSacadoInput);"
              		selectedValue='<%=ddaReimpBloquetoBean.getTipoPessoaSacado().equals("")||ddaReimpBloquetoBean.getTipoPessoaSacado().equals("J")?"2":"1"%>'/>
                <p:InputCpfCnpj CLASS="inputtext" name="cpfCnpjSacadoInput"
              		value='<%=ddaReimpBloquetoBean.getCpfCnpjSacado().equals(new Long(0))?"":ddaReimpBloquetoBean.getCpfCnpjSacadoFormatado().toString()%>'
              		onBlur="javascript:formataCpfCnpj(this, tipoPessoaSacadoInput);"
              		onFocus="javascript:unFormataCpfCnpj(this, tipoPessoaSacadoInput);prevFocus(this);"/>
              </td>
							<td class="textoTitulo" width="17%">Data Vencimento - de:</td>
							<td class="textoValor" width="26%">
                <p:InputDate name="dataVencimentoDe"
                   CLASS="inputtext"
                   value='<%=ddaReimpBloquetoBean.getDataVencimentoDe()==null ?"" : Formatador.formatarData(ddaReimpBloquetoBean.getDataVencimentoDe())%>'/>
              </td>
						</tr>

						<tr>
              <td class="textoTitulo" width="17%">Tipo de Boleto: </td>
              <td class="textoValor" width="26%">
         				<s:ComboTipoBloquetoDda name="tipoBloquetoDda" selectedValue="<%=ddaReimpBloquetoBean.getTipoBloquetoDda().toString()%>"/>
              </td>
            	<td class="textoTitulo" width="17%">Data Vencimento - até:</td>
            	<td class="textoValor" width="26%">
	                <p:InputDate name="dataVencimentoAte"
                    CLASS="inputtext"
                    value='<%=ddaReimpBloquetoBean.getDataVencimentoAte()==null ? "": Formatador.formatarData(ddaReimpBloquetoBean.getDataVencimentoAte())%>'/>
              </td>
						</tr>

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
	          <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>

            <tr>
              <td colspan="4">
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
      }

      // ############################## Finalizacao

			function formSubmit(){
				if(validaSubmit()){
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
				if(!validaDataVencimento()){
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

			function validaDataVencimento() {
		    //datas devem ser válidas
				if (trim(document.frmMain.dataVencimentoDe.value) != "" && !validarData(document.frmMain.dataVencimentoDe.value)) {
					msg('014','Data Vencimento - de');
					document.frmMain.dataVencimentoDe.focus();
					return false;
				}
				if (trim(document.frmMain.dataVencimentoAte.value) != "" && !validarData(document.frmMain.dataVencimentoAte.value)) {
					msg('014','Data Vencimento - ate');
					document.frmMain.dataVencimentoAte.focus();					
					return false;
				}			
        //data inicio deve ser menor que data fim
        if (trim(document.frmMain.dataVencimentoDe.value) != "" &&
        		trim(document.frmMain.dataVencimentoAte.value) != "" &&
            !compararDatas(document.frmMain.dataVencimentoDe.value, document.frmMain.dataVencimentoAte.value, "<=")) {
        	msg('034','Data De','Data Até');
        	document.frmMain.dataVencimentoDe.focus();
        	return false;
        }
        // prepara submit
        if (trim(document.frmMain.dataVencimentoDe.value) == "") {
          document.frmMain.dataVencimentoDe.value = '01/01/0001'; 
        }
        if (trim(document.frmMain.dataVencimentoAte.value) == "") {
            document.frmMain.dataVencimentoAte.value = '31/12/2049'; 
        }
        return true;
			}

    </script>
 		</s:FormStrategy>
	</p:Document>
</html>