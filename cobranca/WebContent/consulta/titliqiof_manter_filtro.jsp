
<%
/***********************************************
*Probank
*Fabrica de Projetos - Janeiro/2011
*Projeto CAIXA - SIGCB
*Componente: titliqiof_manter_filtro.jsp - Java Server Pages
*Autor: Adelaine Rondon - adelaine.rondon@probank.com
*Ultima Atualização: 06/01/2011
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosIOFBean"%>
<%@page
	import="br.gov.caixa.sigcb.estrategia.consulta.TitLiqIOFManterEstrategia"%>


<%
			ConGerTitulosLiquidadosIOFBean filtroBean = (session
			.getAttribute(TitLiqIOFManterEstrategia.FILTRO_BEAN) == null ? new ConGerTitulosLiquidadosIOFBean()
			: (ConGerTitulosLiquidadosIOFBean) session
			.getAttribute(TitLiqIOFManterEstrategia.FILTRO_BEAN));

	filtroBean
			.setInformacao(session
			.getAttribute(TitLiqIOFManterEstrategia.INFORMACAO_ATUAL) == null ? new Long(
			0)
			: (Long) session
			.getAttribute(TitLiqIOFManterEstrategia.INFORMACAO_ATUAL));
%>

<html>
<s:Header />
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia='<%=TitLiqIOFManterEstrategia.STRATEGY_FILTRO%>'
		fluxo="normal">
		<s:Menu />
		<s:Titulo name='<%=TitLiqIOFManterEstrategia.PAGE_TITLE%>' />

		<input type="hidden" name="informacao">
		<input type="hidden" name="tipoInformacao">
		<input type="hidden" name="mes">
		<input type="hidden" name="ano">
		<input type="hidden" name="cedentePadrao"
			value='<%=filtroBean.getInformacao().equals(new Long(0))?"":filtroBean.getInformacao().toString()%>'>

		<table width="777" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="53" valign="middle" align="center">
					<tr>
						<td class="textoTitulo" width="2%"><input type="radio"
							name="rad"
							value="<%=TitLiqIOFManterEstrategia.SELECAO_RADIO_CEDENTE%>"
							onclick="javascript: desabilitaSelecao()"></td>
						<td class="textoTitulo" width="17%">Cedente:</td>
						<td class="textoValor" width="26%"><p:InputNumerico
							CLASS="inputtext" size="7" maxlength="7" name="infCedente"
							value='<%=filtroBean.getTipoInformacao().equals(new Long(1))?filtroBean.getInformacao().toString():""%>'
							onFocus="javascript: prevFocus(this);"
							onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.mesAno);" />
						</td>
						<td width="17%">&nbsp;</td>
						<td width="26%">&nbsp;</td>
					</tr>

					<tr>
						<td class="textoTitulo" width="2%"><input type="radio"
							name="rad"
							value="<%=TitLiqIOFManterEstrategia.SELECAO_RADIO_UNIDADE%>"
							onclick="javascript: desabilitaSelecao()" onchange="document.frmMain.codigoUnidade.value = '';"></td>
						<td class="textoTitulo" width="17%">Unidade:</td>

						<td class="textoValor" width="26%"><s:ComboENPV
							name="selecaoEnPV"
							selectedValue='<%=filtroBean.getTipoInformacao().equals(new Long(2))?"2":filtroBean.getTipoInformacao().equals(new Long(3))?"1":""%>' />
						<p:InputNumerico CLASS="inputtext" name="codigoUnidade"
							value='<%=filtroBean.getTipoInformacao().equals(new Long(2)) || filtroBean.getTipoInformacao().equals(new Long(3))?filtroBean.getInformacao().toString():""%>'
							size="6" maxlength="4" onFocus="javascript: prevFocus(this);"
							onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.mesAno);" />
						</td>
						<td width="17%">&nbsp;</td>
						<td width="26%">&nbsp;</td>
					</tr>

					<tr>
						<td class="textoTitulo" width="2%"><input type="radio"
							name="rad"
							value="<%=TitLiqIOFManterEstrategia.SELECAO_RADIO_CAIXA%>"
							onclick="javascript: desabilitaSelecao()"></td>
						<td class="textoTitulo" width="17%">CAIXA</td>
						<td class="textoValor" width="26%"></td>
						<td width="17%">&nbsp;</td>
						<td width="26%">&nbsp;</td>
					</tr>

					<tr>
						<td class="textoTitulo" width="2%"></td>
						<td class="textoTitulo" width="17%">Mes/Ano:</td>
						<td class="textoValor" width="26%"><p:InputNumerico
							CLASS="inputtext" size="8" maxlength="6" name="mesAno"
							value='<%=filtroBean.getMes().intValue() == 0 ? "" : String.format("%02d", filtroBean.getMes()) + "/" + String.format("%04d", filtroBean.getAno()) %>'
							onBlur="javascript:formataMesAno(this);"
							onFocus="javascript: unFormataMesAno(this); prevFocus(this);"
							onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);" />
						</td>
						<td width="17%">&nbsp;</td>
						<td width="26%">&nbsp;</td>
					</tr>

					<tr>
						<td class="textoTitulo" width="2%"></td>

						<td width="17%">&nbsp;</td>
						<td width="26%">&nbsp;</td>
					</tr>

					<tr>
						<td colspan="5">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="5">
						<p align="center"><s:Button name="Ok"
							action="javascript:formSubmit()" /></p>
						</td>
					</tr>
				</table>
				</TD>
			</tr>
		</table>
		<script>
    function inicia() {
		setFirstFieldFocus();
		var tipoInf = <%=filtroBean.getTipoInformacao()%>;
		var radio = 0;
		
		if (tipoInf == 1) radio = 0;
		else if (tipoInf == 2 || tipoInf == 3) radio = 1;
		else if (tipoInf == 4) radio = 2;
		document.frmMain.rad[radio].checked = true;
		desabilitaSelecao();
	}
	
	function desabilitaSelecao() {
		var form = document.frmMain;
		var radio = -1;
		
		for(var i = 0; i < form.rad.length; i++) {
			if (form.rad[i].checked) {
				radio = i;
				break;
			}
		}
		
		if (radio == 0) {
			form.infCedente.disabled = false;
			form.selecaoEnPV.disabled = true;
			form.codigoUnidade.disabled = true;
			form.codigoUnidade.value = '';
			form.infCedente.focus();
		}
		else if (radio == 1) {
			form.infCedente.disabled = true;
			form.infCedente.value = '';
			form.selecaoEnPV.disabled = false;
			form.codigoUnidade.disabled = false;
			form.codigoUnidade.focus();
		}
		else if (radio == 2) {
			form.infCedente.disabled = true;
			form.selecaoEnPV.disabled = true;
			form.codigoUnidade.disabled = true;
			form.codigoUnidade.value = '';
			form.infCedente.value = '';
		}
	}
      
	function formSubmit() {
		if(validaSubmit()) {
			copiarValores();
		  	document.frmMain.submit();
		}
  	}  
      
	function validaSubmit() {
	    if(!validaRadioButton(document.frmMain.rad, '')) {
			return false;
		}
		if(document.frmMain.rad[0].checked) {
			if(!validaCampoObrigatorio(document.frmMain.infCedente, "Cedente")) {
				return false;
			}
		}  
		if(document.frmMain.rad[1].checked) {			    
			if(!validaCampoObrigatorio(document.frmMain.codigoUnidade, "Unidade")) {
				return false;
			}
		}
		if(!validaCampoObrigatorio(document.frmMain.mesAno, "Mês/Ano")) {
			return false;
		} else {
			if (document.frmMain.mesAno.value.length != 7) {
				alert("Favor preencher no formato MM/AAAA");
				document.frmMain.mesAno.focus();
				return false;
			}
		}
		return true;
	}

	function formataMesAno(obj){				
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
	
	function unFormataMesAno(obj){
		strMesAno = obj.value;
		obj.value = strMesAno.replace('/','');
	}
	
	function copiarValores() {
		var form = document.frmMain;
		var radio = -1;
		for(var i = 0; i < form.rad.length; i++) {
			if (form.rad[i].checked) {
				radio = i;
				break;
			}
		}
		
		if (radio == 0) {
			form.informacao.value = form.infCedente.value;
			form.tipoInformacao.value = '1';
		}
		else if (radio == 1) {
			form.informacao.value = form.codigoUnidade.value;
			if (form.selecaoEnPV.value == '2') {
				form.tipoInformacao.value = '2';
			} else {
				form.tipoInformacao.value = '3';
			}
		}
		else if (radio == 2) {
			form.informacao.value = '';
			form.tipoInformacao.value = '4';
		}
		form.mes.value = form.mesAno.value.substr(0, 2);
		form.ano.value = form.mesAno.value.substr(3, 4);
	}
    </script>
	</s:FormStrategy>
</p:Document>
</html>
