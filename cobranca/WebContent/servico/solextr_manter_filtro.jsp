<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outrubro de 2004
*Projeto CAIXA - SIGCB
*Componente: solextr_manter_filtro.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 20/10/2004 16:04
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.SegundaViaExtratoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.SolExtrEstrategia"%>

<%
  SegundaViaExtratoBean extratoBean = (session.getAttribute(SolExtrEstrategia.FILTRO_BEAN)==null?new SegundaViaExtratoBean():(SegundaViaExtratoBean)session.getAttribute(SolExtrEstrategia.FILTRO_BEAN));
  extratoBean.setCodigoCedente(session.getAttribute(SigcbEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute("cedente"));
%>

<html>

<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle"
  estrategia="<%=SolExtrEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="<%=SolExtrEstrategia.PAGE_TITLE_MANTER_FILTRO%>"/>

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td width="50%">
                <p:InputNumerico name="codigoCedente" maxlength="7" size="7"
                    CLASS="inputtext" value='<%=extratoBean.getCodigoCedente().equals( new Long(0))?"":extratoBean.getCodigoCedente().toString()%>'
                    onFocus="javascript: prevFocus(this);"
                    onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.tipoExtrato);"/>
              </td>
              <td width="3%">&nbsp;</td>
              <td width="30%">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo de Extrato: </td>
              <td class="textoTitulo" width="50%">
              	<s:ComboTipoExtrato name="tipoExtrato" disabled="false" selectedValue='<%=extratoBean.getTipoExtrato() == null ? "" : extratoBean.getTipoExtrato().toString()%>'/>
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
        return true;
      }
    </script>
  </s:FormStrategy>
</p:Document>
</html>