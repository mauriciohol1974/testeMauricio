
<%
/***********************************************
*Projeto CAIXA - SIGCB DDA
*Componente: sac_eletron_sucesso.jsp - Java Server Pages
*Criado em: 04/09/2009
*Autor: Alexandre Lima - alexandre.lima@probank.com.br
*Ultima Atualização: set/2009
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page	import="br.gov.caixa.sigcb.estrategia.dda.SacEletronicoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.SacEletronicoBean"%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(SacEletronicoEstrategia.MSG_BEAN) == null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(SacEletronicoEstrategia.MSG_BEAN);
	}
%>

<%
			SacEletronicoBean sacBean = (session.getAttribute(SacEletronicoEstrategia.FILTRO_BEAN) == null ? new SacEletronicoBean() : (SacEletronicoBean) session.getAttribute(SacEletronicoEstrategia.FILTRO_BEAN));
%>

<html>
<s:Header />

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=msgBean.getStrategySucessReturn()%>" fluxo="normal">
		<s:Menu />
		<s:Titulo name="<%=msgBean.getTitlePage()%>" />
		<table width="777" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top" width="95%" height="14" align="left">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="53" valign="middle" align="center">

					<tr valign="top">
						<td colspan="5" class="textoTitulo">Sacado Eletrônico:
						<hr>
						</td>
					</tr>

					<tr>

						<td class="textoTitulo" width="12%">Tipo Pessoa:</td>

						<td class="textoValor" width="26%"><%=sacBean.getTipoPessoaTexto() %></td>

						<td class="textoValor" width="24%">&nbsp;</td>
						<td width="15%">&nbsp;</td>
						<td width="23%">&nbsp;</td>
					</tr>

					<tr>

						<td class="textoTitulo" width="12%">CPF / CNPJ:</td>
						<td class="textoValor" width="26%"><%=sacBean.getCpfCnpjFormatado() %></td>
						<td class="textoValor" width="24%">&nbsp;</td>
						<td width="15%">&nbsp;</td>
						<td width="23%">&nbsp;</td>
					</tr>

					<tr>
						<td colspan="5">&nbsp;</td>
					</tr>
					<!-- tr>
						<td colspan="5" class="textoTitulo"><input type="checkbox"
							name="checkbox2" value="checkbox" checked disabled>
						Autorização de acesso dos títulos do sacado principal pelo
						agregado</td>
					</tr-->

					<tr>
						<td colspan="5">&nbsp;</td>
					</tr>

					<tr valign="top">
						<td colspan="5" class="textoTitulo">Sacado Agregado:
						<hr>
						</td>
					</tr>

					<tr>

						<td class="textoTitulo" width="12%">Tipo Pessoa:</td>

						<td class="textoValor" width="26%"><%=sacBean.getTipoPessoaAgregTexto() %></td>

						<td class="textoValor" width="24%">&nbsp;</td>
						<td width="15%">&nbsp;</td>
						<td width="23%">&nbsp;</td>
					</tr>

					<tr>

						<td class="textoTitulo" width="12%">CPF / CNPJ:</td>
						<td class="textoValor" width="26%"><%=sacBean.getCpfCnpjAgregFormatado() %></td>
						<td class="textoValor" width="24%">&nbsp;</td>
						<td width="15%">&nbsp;</td>
						<td width="23%">&nbsp;</td>
					</tr>


					<tr>
						<td colspan="5">&nbsp;</td>
					</tr>
					<tr valign="top">
						<td colspan="5" class="textoTitulo">&nbsp;
						<hr>
						</td>
					</tr>
					<tr> 
	            		<td>&nbsp;</td>
	            		<td colspan="3">
	            			<h3><%=msgBean.getMsgSucess()%></h3>
	            		</td>
	          		</tr>
					<tr>
						<td colspan="5">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="5">
						<p align="center"><input type="button" class="button"
							value="Ok" onclick="javascript:formSubmit();"></p>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<script>
      	function inicia() {
			setFirstFieldFocus();
		}
	    function formSubmit() {
        	if (validaSubmit()) {
		    	document.frmMain.submit();
        	}
	    }
		function validaSubmit() {
		    return true;
		}			
    </script>
	</s:FormStrategy>
</p:Document>
</html>
