<!--
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: titulo_sucesso.jsp - Java Server Pages
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 29/09/2004
************************************************/
-->
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituloEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BorderoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoTituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(TituloEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(TituloEstrategia.MSG_BEAN);
	}
%>

<%
	BorderoBean borderoBean = (session.getAttribute(TituloEstrategia.BORDERO_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(TituloEstrategia.BORDERO_BEAN));
	CedenteCabecaBean cedCabBean = (session.getAttribute(TituloEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TituloEstrategia.CEDENTE_CABECALHO_BEAN));
	BorderoTituloBean tituloFixoBean = (session.getAttribute(TituloEstrategia.FIXO_BEAN)==null?new BorderoTituloBean():(BorderoTituloBean)session.getAttribute(TituloEstrategia.FIXO_BEAN));
	BorderoTituloBean tituloBean = (session.getAttribute(TituloEstrategia.DATA_BEAN)==null?new BorderoTituloBean():(BorderoTituloBean)session.getAttribute(TituloEstrategia.DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="<%=msgBean.getStrategySucessReturn()%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>
		<input type="hidden" name="codigoCedente" value="<%=borderoBean.getCodigoCedente()%>">
		<input type="hidden" name="codigoBordero" value="<%=borderoBean.getCodigoBordero()%>">
		<input type="hidden" name="registro" value="<%=borderoBean.getRegistro()%>">
   	<input type="hidden" name="navegacao">		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
  	          <td class="textoValor" nowrap width="26%"><%=cedCabBean.getNomeFantasia()%></td> 
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
              <td class="textoTitulo" width="17%">Borderô: </td>
              <td class="textoValor" width="26%"><%=borderoBean.getCodigoBordero()%></td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Total de Títulos:</td>
              <td class="textoValor" width="26%"><%=tituloFixoBean.getTotalTitulos()%></td>
              <td class="textoTitulo" width="17%">Título Atual: </td>
              <td class="textoValor" width="26%">
             <% if (tituloFixoBean.getNavegacao().equals(TituloEstrategia.NAVEGACAO_INCLUIR)){ %>
              	<%=	tituloFixoBean.getTitulosIncluidos()%>
              <%}
              	else{%>
              	<%= tituloBean.getNumeroSequencial()%>
              <%}%>
              	
              	</td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">
                <hr>
              </td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>

	          <tr> 
	            <td>&nbsp;</td>
	            <td colspan="3">
	            	<h3><%=msgBean.getMsgSucess()%></h3>
	            </td>
	          </tr>

            <tr>
	            <TD>&nbsp;</TD>
              <td class="textoDestaqueTitulo" align="right">Numero do Borderô: </td>
              <td class="textoValor" align="left">&nbsp;<%=borderoBean.getCodigoBordero()%></td>
	            <TD>&nbsp;</TD>
            </tr>
            <tr>
	            <TD>&nbsp;</TD>
              <td class="textoTitulo" align="right">Nosso Número: </td>
              <td class="textoValor" align="left">&nbsp;<%=tituloFixoBean.getNossoNumero().equals(new Long (0))?tituloBean.getNossoNumero().toString():tituloFixoBean.getNossoNumero().toString()%></td>
	            <TD>&nbsp;</TD>
            </tr>
            <tr>
	            <TD>&nbsp;</TD>
              <td class="textoTitulo" align="right">Número Seq. do Título: </td>
              <td class="textoValor" align="left">&nbsp;<%=tituloFixoBean.getNavegacao().equals(TituloEstrategia.NAVEGACAO_INCLUIR)?tituloFixoBean.getTitulosIncluidos():tituloBean.getNumeroSequencial()%> de <%=tituloFixoBean.getTotalTitulos()%></td>
	            <TD>&nbsp;</TD>
            </tr>
            
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            
						<% if (tituloFixoBean.getNavegacao().equals(TituloEstrategia.NAVEGACAO_INCLUIR)) {%> 
            <tr>
 	            <TD>&nbsp;</TD>
 	          	<td class="textoTitulo" align="right" colspan="2">
 	          		Clique para incluir mais títulos neste Borderô:
 	          		<s:Button name="IncluirTitulos" value="Incluir Títulos" action="javascript:formSubmit_IncluirTitulos()"/>
              </td>
 	            <TD>&nbsp;</TD>
            </tr>
						<% }%>
            <tr>
 	            <TD>&nbsp;</TD>
 	          	<td class="textoTitulo" align="right" colspan="2">
 	          		Clique para passar à tela de Manter Titulos:
 	          		<s:Button name="ManterTitulos" value="Manter Títulos" action="javascript:formSubmit_ManterTitulos()"/>
              </td>
 	            <TD>&nbsp;</TD>
            </tr>
 	          <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>
	        </table>
        </td>
      </tr>
    </table>
		<script language="javascript">
			function inicia() {
				setFirstFieldFocus();
			}
			function formSubmit(){ // Acao default "Manter Titulos"
				formSubmit_ManterTitulos();
			}
	    function formSubmit_ManterTitulos() {
        if (validaSubmit()) {
        		document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_MANTER_LISTAR%>";
     	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_LISTA_TITULO%>';	  		        
		        document.frmMain.submit();
        }
	    }
	    function formSubmit_IncluirTitulos() {
	    <%if (tituloFixoBean.getTotalTitulos().equals(tituloFixoBean.getTitulosIncluidos())){%>
				msg('032');
    	<%}
    	else{%>        
        if (validaSubmit()) {
        		document.frmMain.estrategia.value = "<%=TituloEstrategia.STRATEGY_INCLUIR%>";
     	      document.frmMain.navegacao.value = '<%=BorderoEstrategia.NAVEGACAO_OUTRO_LISTA_TITULO%>';	     	      	  		        
		        document.frmMain.submit();
        }
			<%}%>
	    }
			function validaSubmit() {
		    return true;
		  }
    </script>
  </s:FormStrategy>
</p:Document>
</html>
