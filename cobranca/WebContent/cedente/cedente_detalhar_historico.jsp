
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloListarBean"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedHistPermissaoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>

<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));
%>

<%

CedHistPermissaoBean historico = (CedHistPermissaoBean) request.getAttribute("HISTORICO");

%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
	estrategia="<%=CedenteEstrategia.STRATEGY_MANTER_LISTAR_HISTORICO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="Consultar Histórico da Situação do Cedente >> Detalhe"/>
			
			<input type="hidden" name="codCedente" value="<%=cedCabBean.getCodigoCedenteFormatado()%>">
			<input type="hidden" name="codigoCedente" value="<%=cedCabBean.getCodigoCedenteFormatado()%>">
			<input type="hidden" name="data">
			<input type="hidden" name="hora">
			<input type="hidden" name="tpAlteracao">
			<input type="hidden" name="icAtual">	
			<input type="hidden" name="usuario">
			<input type="hidden" name="pagina" value="10">	
	
	
	  <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
			<td valign="top" width="1%" height="14" align="left">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	  		<td valign="top" width="95%" height="14" align="left"> 
	    		<table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="left">
          	<tr>
            	<td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getNomeFantasia()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td> 
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
              <td class="textoValor" width="26%"><%=cedCabBean.getCodigoClienteCOCLI()%></td> 
              
            </tr>
			<tr>
			  <td width="17%" colspan="4" class="textoTitulo"><hr></td>
			</tr>
			
			<tr>
 			  <td class="textoTitulo" width="17%">Data: </td>
              <td class="textoValor" width="26%"><input type="text" id="data" size="12" value="<%= historico.getData()%>" CLASS="inputtext"  readonly></td> 
              <td class="textoTitulo" width="17%">Hora:  </td>
              <td class="textoValor" width="26%"><input type="text" id="hora" size="08" value="<%= historico.getHora()%>" CLASS="inputtext"  readonly></td>
		    </tr>


			<tr>
 			  <td class="textoTitulo" width="17%"> Tipo Alteração:</td>
              <td class="textoValor" width="26%"><input type="text" id="tipo" size="22" value="<%=historico.getTipoAlteracao()%>" CLASS="inputtext"  readonly></td> 
              <td class="textoTitulo" width="17%">Usuário:  </td>
              <td class="textoValor" width="26%"><input type="text" id="usuario" size="08" value="<%=historico.getUsuario()%>" CLASS="inputtext"  readonly></td>
		    </tr>
	          

			<tr>
 			  <td class="textoTitulo" width="17%">Situação Anterior:</td>
              <td class="textoValor" width="26%"><input type="text" id="usuario" size="12" value="<%=historico.getSitAnterior()%>"  CLASS="inputtext"  readonly></td> 
              <td class="textoTitulo" width="17%"> Situação Atual:  </td>
              <td class="textoValor" width="26%"><input type="text" id="usuario" size="12" value="<%=historico.getSitAtual()%>" CLASS="inputtext"  readonly></td>
		    </tr>
		    
		    <tr>
 			  <td class="textoTitulo" width="17%" >Descrição:</td>
              <td class="textoValor" colspan="3"><input type="text" id="usuario" size="105" value="<%=historico.getDescricao().substring(0, 100)%>" CLASS="inputtext"  readonly></td>
		    </tr>
		    <tr>
 			  <td class="textoTitulo" width="17%" >&nbsp;</td>
              <td class="textoValor" colspan="3"><input type="text" id="usuario" size="105" value="<%=historico.getDescricao().substring(100, 200)%>" CLASS="inputtext"  readonly></td>
		    </tr>
		    <tr>
 			  <td class="textoTitulo" width="17%" >&nbsp;</td>
              <td class="textoValor" colspan="3"><input type="text" id="usuario" size="105" value="<%=historico.getDescricao().substring(200, 300)%>" CLASS="inputtext"  readonly></td>
		    </tr>
		    <tr>
 			  <td class="textoTitulo" width="17%" >&nbsp;</td>
              <td class="textoValor" colspan="3"><input type="text" id="usuario" size="105" value="<%=historico.getDescricao().substring(300, 400)%>" CLASS="inputtext"  readonly></td>
		    </tr>
		    		    <tr>
 			  <td class="textoTitulo" width="17%" >&nbsp;</td>
              <td class="textoValor" colspan="3"><input type="text" id="usuario" size="105" value="<%=historico.getDescricao().substring(400, 500)%>" CLASS="inputtext"  readonly></td>
		    </tr>
		    		    <tr>
 			  <td class="textoTitulo" width="17%" >&nbsp;</td>
              <td class="textoValor" colspan="3"><input type="text" id="usuario" size="105" value="<%=historico.getDescricao().substring(500, 600)%>" CLASS="inputtext"  readonly></td>
		    </tr>
		    		    <tr>
 			  <td class="textoTitulo" width="17%" >&nbsp;</td>
              <td class="textoValor" colspan="3"><input type="text" id="usuario" size="105" value="<%=historico.getDescricao().substring(600, 700)%>" CLASS="inputtext"  readonly></td>
		    </tr>
		     <tr>
 			  <td class="textoTitulo" width="17%" >&nbsp;</td>
              <td class="textoValor" colspan="3"><input type="text" id="usuario" size="105" value="<%=historico.getDescricao().substring(700, 800)%>" CLASS="inputtext"  readonly></td>
		    </tr>
		    		    <tr>
 			  <td class="textoTitulo" width="17%" >&nbsp;</td>
              <td class="textoValor" colspan="3"><input type="text" id="usuario" size="105" value="<%=historico.getDescricao().substring(800, 900)%>" CLASS="inputtext"  readonly></td>
		    </tr>
		    		    <tr>
 			  <td class="textoTitulo" width="17%" >&nbsp;</td>
              <td class="textoValor" colspan="3"><input type="text" id="usuario" size="105" value="<%=historico.getDescricao().substring(900, 999)%>" CLASS="inputtext"  readonly></td>
		    </tr>
		    

		 	<tr> 
	   				<td colspan="4">&nbsp;</td>
	   		</tr>
	   		<tr> 
	   				<td colspan="4">&nbsp;</td>
	   		
			<tr>
	    	  <td align="right" colspan="4">
	      				<p align="center"> 
            		     	<s:Button name="Voltar" action="javascript: formSubmit_Voltar();"/>
	      				</p>
	    	   </td>
    		</tr>

		 	<tr> 
	   			<td colspan="4">&nbsp;</td>
	   		</tr>
         	
         	</table>
	      </td>

		</table>    
		<script language="javascript">
			function inicia() {
				setFirstFieldFocus();
			}
		  function clickRadio(Data,Hora,TpAlteracao,IcAtual,usuario) {
			document.frmMain.data.value = Data;
			document.frmMain.hora.value = Hora;
			document.frmMain.tpAlteracao.value = TpAlteracao;
			document.frmMain.icAtual.value = IcAtual;
			document.frmMain.usuario.value = usuario
			
			
		  }
			function formSubmit() {
				if (validaSubmit()) {
					document.frmMain.submit();
				}
			}  

			function formSubmit_Voltar() {
	      		document.frmMain.submit();
	    }
		</script>			
	</s:FormStrategy>
</p:Document>
</html>
