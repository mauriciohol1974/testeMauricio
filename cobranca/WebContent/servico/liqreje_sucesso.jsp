<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.LiqRejeManterEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.MsgSucessoErroBean"%>
<%@page import="br.gov.caixa.sigcb.bean.LiquidacoesRejeitadaBean"%>


<%
 	LiquidacoesRejeitadaBean liqRejeBean = (session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN)==null
 	                                        ? new LiquidacoesRejeitadaBean()
 	                                        : (LiquidacoesRejeitadaBean)session.getAttribute(LiqRejeManterEstrategia.FILTRO_BEAN));

 	LiquidacoesRejeitadaBean dataBean = (session.getAttribute(LiqRejeManterEstrategia.DATA_BEAN)==null
 	                                     ? new LiquidacoesRejeitadaBean()
 	                                     :(LiquidacoesRejeitadaBean)session.getAttribute(LiqRejeManterEstrategia.DATA_BEAN));
%>

<%
	MsgSucessoErroBean msgBean;
	if (session.getAttribute(LiqRejeManterEstrategia.MSG_BEAN)==null) {
		msgBean = new MsgSucessoErroBean();
		msgBean.setMsgSucess(msgBean.getMsgSucess());
		msgBean.setStrategySucessReturn(msgBean.getStrategySucessReturn());
	} else {
		msgBean = (MsgSucessoErroBean) session.getAttribute(LiqRejeManterEstrategia.MSG_BEAN);
	}
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=msgBean.getStrategySucessReturn()%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=msgBean.getTitlePage()%>"/>
 
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Opção: </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getTipoOpcaoDescricao() %></td>
              <td class="textoTitulo" width="17%">PV Recebedor/Centralizador: </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getCodigoUnidadePVFormatado() %></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Meio Liquidação: </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getMeioLiquidacaoDescricao() %></td> 
              <td class="textoTitulo" width="17%">Data (a partir de): </td>
              <td class="textoValor" width="26%"><%= liqRejeBean.getDataInicialFormatada() %></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Data de Referência: </td>
              <td class="textoValor" width="26%"><%= dataBean.getDataReferenciaFormatada() %></td> 
              <td class="textoTitulo" width="17%">Sequência: </td>
<%
String numeroSequencia = dataBean.getNumeroSequencia()==null?"":dataBean.getNumeroSequencia().toString();
%>
              <td class="textoValor" width="26%"><%= numeroSequencia %></td>
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
	            <td>&nbsp;</td>
	            <td colspan="3">
	            	<h3><%= msgBean.getMsgSucess() %></h3>
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
                  <s:Button name="Ok" action="javascript:formSubmit()"/>
                </p>
              </td>
            </tr>
 	          <tr> 
	            <td colspan="4">&nbsp;</td>
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