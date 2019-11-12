<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bloquet_manter_filtro.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 15/10/2004 14:21
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BloquetoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BloquetEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%
  BloquetoBean bloquetoBean = (session.getAttribute(BloquetEstrategia.FILTRO_BEAN)==null?new BloquetoBean():(BloquetoBean)session.getAttribute(BloquetEstrategia.FILTRO_BEAN));
  bloquetoBean.setCodigoCedente(session.getAttribute("cedente")==null?new Long (0):(Long)session.getAttribute("cedente"));
%>

<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle"
  estrategia="<%=BloquetEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="<%=BloquetEstrategia.PAGE_TITLE_MANTER_FILTRO%>"/>

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="50%">
                <p:InputNumerico name="codigoCedente" maxlength="7" size="7"
                    CLASS="inputtext" value='<%=bloquetoBean.getCodigoCedente().equals( new Long(0))?"":bloquetoBean.getCodigoCedente().toString()%>'
                    onFocus="javascript: prevFocus(this);"
                    onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataMovimento);"/>
              </td>
              <td width="3%">&nbsp;</td>
              <td width="30%">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Data Movimento: </td>
              <td class="textoTitulo" width="50%">
                <p:InputDate name="dataMovimento"
                    CLASS="inputtext"
                    onFocus="javascript: prevFocus(this);"
                    onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.tipoBloqueto);"
                    value='<%=bloquetoBean.getDataMovimento() == null ? "": Formatador.formatarData(bloquetoBean.getDataMovimento())%>'/>
                (Deixe em Branco para obter todos)
              </td>
              <td width="3%">&nbsp;</td>
              <td width="30%">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo de Boleto: </td>
              <td class="textoTitulo" width="50%">
				<s:ComboTipoBloqueto name="tipoBloqueto" disabled="false" selectedValue='<%=bloquetoBean.getTipoBloqueto() == null ? "" : bloquetoBean.getTipoBloqueto().toString()%>' branco="true" brancoValue="3"/>
                  (Deixe em Branco para obter todos)
              </td>
              <td width="3%">&nbsp;</td>
              <td width="30%">&nbsp;</td>
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
          </table>
        </TD>
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
        if(!validaCampoObrigatorio(document.frmMain.codigoCedente, 'Cedente')) return false;
        if (document.frmMain.dataMovimento.value != "") {
		      if (!validarData(document.frmMain.dataMovimento.value)) {
						msg("014", "Data Movimento");
						document.frmMain.dataMovimento.focus();
						return false;
	        }
	        if (!validarDataAteHoje(document.frmMain.dataMovimento.value)) {
	          msg("028", "Data Movimento");
	          document.frmMain.dataMovimento.focus();
	          return false;	        
	        }
	      }
        return true;
      }
    </script>
  </s:FormStrategy>
</p:Document>
</html>
