<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: pvcob_manter_filtro.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 13/10/2004 16:07
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.PvCobradorBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.PvCobEstrategia"%>
<%@page import="br.com.politec.sao.util.Formatacao"%>

<%
  PvCobradorBean pvBean = (session.getAttribute(PvCobEstrategia.FILTRO_BEAN)==null?new PvCobradorBean():(PvCobradorBean)session.getAttribute(PvCobEstrategia.FILTRO_BEAN));
  String tmp = "";
%>

<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle"
  estrategia="<%=PvCobEstrategia.STRATEGY_MANTER_LISTAR%>" fluxo="normal">
  <s:Menu/>
    <s:Titulo name="Manter PV Cobrador >> Filtro"/>
    <input type="hidden" name = "acao" value="UNIDADE">
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="radioTipoConsulta" onclick="javascript:radioSelected(1);" <%=(pvBean.getAcao().equals("UNIDADE"))?"checked":""%>>
              </td>
              <td class="textoTitulo" width="17%">Unidade PV de: </td>
              <td class="textoTitulo" nowrap width="26%">
                  <%if ( pvBean.getCodUnidPVInicial().longValue() !=0 ) tmp = pvBean.getCodUnidPVInicial().toString();%>
                  <p:InputNumerico CLASS="inputtext" name="codUnidPVInicial" size="5" maxlength="4"
                  onFocus="javascript: prevFocus(this);"
                  onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.codUnidPVFinal);"
                  value='<%=tmp%>'                  
                  />
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="2%">
                &nbsp;
              </td>
              <td class="textoTitulo" width="17%">Unidade PV até:</td>
              <td class="textoValor" width="26%">
                  <%if ( pvBean.getCodUnidPVFinal().longValue() !=0 ) tmp = pvBean.getCodUnidPVFinal().toString();%>
                  <p:InputNumerico CLASS="inputtext" name="codUnidPVFinal" size="5" maxlength="4"
                  onFocus="javascript: prevFocus(this);"
                  onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"
                  value='<%=tmp%>'/>
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="2%">
                <input type="radio" name="radioTipoConsulta" onclick="javascript:radioSelected(2);" <%=(pvBean.getAcao().equals("CEP"))?"checked":""%>>
              </td>
              <td class="textoTitulo" width="17%">CEP de:</td>
              <td class="textoValor" width="26%">
                  <p:InputCep name="numeroCEPde"
                  value="" CLASS="inputtext"
                  onFocus="javascript: prevFocus(this);"
                  onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.numeroCEPate);"
                  value='<%=Formatacao.formataCep(pvBean.getNumeroCEPde())%>'/>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
            </tr>
            <tr>
              <td class="textoTitulo" width="2%">
                &nbsp;
              </td>
              <td class="textoTitulo" width="17%">CEP até:</td>
              <td class="textoValor" width="26%">
                  <p:InputCep name="numeroCEPate"
                  value="" CLASS="inputtext"
                  onFocus="javascript: prevFocus(this);"
                  onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"
                  value='<%=Formatacao.formataCep(pvBean.getNumeroCEPate())%>'/>
              </td>
              <td width="17%">&nbsp;</td>
              <td width="26%">&nbsp;</td>
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
        </td>
      </tr>
    </table>
    <script>
      function inicia() {
        radioSelected("<%=(pvBean.getAcao().equals("UNIDADE"))?"1":"2"%>");
      }
      
      function formSubmit() {
        if (validaSubmit()) {
          //remover traços dos campos de CEP
          unFormataCep(document.frmMain.numeroCEPde);
          unFormataCep(document.frmMain.numeroCEPate);
          document.frmMain.submit();
        }
      }
      function validaSubmit() {
        if (document.frmMain.radioTipoConsulta[0].checked==true){
          if(!validaCampoObrigatorio(document.frmMain.codUnidPVInicial,'Unidade PV De')) return false;
          if(!validaCampoObrigatorio(document.frmMain.codUnidPVFinal,'Unidade PV Até')) return false;
          if(!validaMenor(document.frmMain.codUnidPVFinal, 'Unidade PV Até', document.frmMain.codUnidPVInicial.value)) return false;
        } else {
          if(!validaCampoObrigatorio(document.frmMain.numeroCEPde,'CEP De')) return false;
          if(!validaCampoObrigatorio(document.frmMain.numeroCEPate,'CEP Até')) return false;
          if(!validaCEPMaior(document.frmMain.numeroCEPate, 'CEP Ate ', document.frmMain.numeroCEPde.value)) return false;
        }
        return true;
      }
      
            
      function radioSelected(escolha) {
        if (escolha=="2"){
          document.frmMain.codUnidPVInicial.value="";
          document.frmMain.codUnidPVFinal.value="";
          document.frmMain.codUnidPVInicial.disabled=true;
          document.frmMain.codUnidPVFinal.disabled=true;
          document.frmMain.numeroCEPde.disabled=false;
          document.frmMain.numeroCEPate.disabled=false;
          document.frmMain.acao.value="CEP";
          document.frmMain.numeroCEPde.focus();
        } else {
          document.frmMain.numeroCEPde.value="";
          document.frmMain.numeroCEPate.value="";
          document.frmMain.codUnidPVInicial.disabled=false;
          document.frmMain.codUnidPVFinal.disabled=false;
          document.frmMain.numeroCEPde.disabled=true;
          document.frmMain.numeroCEPate.disabled=true;
          document.frmMain.acao.value="UNIDADE";
          document.frmMain.codUnidPVInicial.focus();
        }
      }
    </script>
  </s:FormStrategy>
</p:Document>
</html>