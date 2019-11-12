<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outrubro de 2004
*Projeto CAIXA - SIGCB
*Componente: arqreme_manter_filtro.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 26/10/2004
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ArquivoRemessaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.RetornoEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>

<%
	ArquivoRemessaBean arquivoBean;
	if (session.getAttribute(RetornoEstrategia.FILTRO_BEAN)==null) {
		arquivoBean = new ArquivoRemessaBean();
	} else {
		arquivoBean =   (ArquivoRemessaBean)session.getAttribute(RetornoEstrategia.FILTRO_BEAN);
	}
	if(arquivoBean.getOpcaoConsulta().equals("")){
			arquivoBean.setOpcaoConsulta("CEDENTE");}
	arquivoBean.setCodigoCedente(session.getAttribute(SigcbEstrategia.CEDENTE_ATUAL)==null?new Long (0):(Long)session.getAttribute(SigcbEstrategia.CEDENTE_ATUAL));
	arquivoBean.setCodigoUnidadeCentral(new Long(0));
%>

<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle"
  estrategia="<%= RetornoEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="<%=RetornoEstrategia.PAGE_TITLE_MANTER_FILTRO%>"/>
	<input type="hidden" name = "opcaoConsulta" value="<%=arquivoBean.getOpcaoConsulta()%>">
	<input type="hidden" name = "codigoUnidadeCentral" value= "<%=arquivoBean.getCodigoUnidadeCentral()%>">	
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" align="center">
			<tr>
				<td class="textoTitulo" width="2%">
	                <input type="radio" name="radioTipoConsulta" onclick="javascript:radioSelected(1);" <%=(arquivoBean.getOpcaoConsulta().equals("CEDENTE"))?"checked":""%>>
				</td>
				<td class="textoTitulo" width="17%">Cedente: </td>
				<td class="textoValor" width="26%"> 
					<p:InputNumerico name="codigoCedente" maxlength="7" size="8" 
					CLASS="inputtext" value='<%=arquivoBean.getCodigoCedente().equals( new Long(0))?"":arquivoBean.getCodigoCedente().toString()%>' 
					onFocus="javascript: prevFocus(this);"
					onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataInicial);"/>
				</td>
				<td class="textoTitulo" width="17%">Data de:</td>
				<td class="textoValor" width="26%">
	                <p:InputDate name="dataInicial"
                    CLASS="inputtext"
                    onFocus="javascript: prevFocus(this);"
                    onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.dataFinal);"
                    value='<%=arquivoBean.getDataInicial()==null ?"" : Formatador.formatarData(arquivoBean.getDataInicial())%>'/>
				</td>
			</tr>
			<tr>
        	    <td class="textoTitulo" width="2%">
	                &nbsp;
    	        </td>
	            <td class="textoTitulo" width="17%">&nbsp; </td>
        		<td class="textoValor" width="26%"> 
                  &nbsp;
	            </td>
            	<td class="textoTitulo" width="17%">Data até:</td>
            	<td class="textoValor" width="26%">
	                <p:InputDate name="dataFinal"
                    CLASS="inputtext"
                    onFocus="javascript: prevFocus(this);"
                    onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"
                    value='<%=arquivoBean.getDataFinal()==null ? "": Formatador.formatarData(arquivoBean.getDataFinal())%>'/>
            	</td>
			</tr>
			<tr>
			<td class="textoTitulo" width="2%">
	            &nbsp;
			</td>
			<td class="textoTitulo" width="17%">&nbsp; </td>
			<td class="textoValor" width="26%">
					&nbsp;
			</td>
				<td width="17%">&nbsp;</td>
				<td width="26%">&nbsp;</td>
			</tr>

            <tr>
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="5">
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
	     
	     
      }
      
      function formSubmit() {
        if (validaSubmit()) {
	    	//document.frmMain.dataInicial.value = substituiBarraPorPonto(document.frmMain.dataInicial.value);
	    	//document.frmMain.dataFinal.value = substituiBarraPorPonto(document.frmMain.dataFinal.value);
	        document.frmMain.submit();
        }
      }
      
      function validaSubmit() {
      		if(!validaCampoObrigatorio(document.frmMain.codigoCedente, 'Cedente'))	{
      			return false;
      		}
	        if(!validaMenorIgual(document.frmMain.codigoCedente, 'Cedente', 0))	{
	        	return false;
	        }      			
        
        if(!validaCampoObrigatorio(document.frmMain.dataInicial, 'Data de')) 
        	return false;
        if(!validaCampoObrigatorio(document.frmMain.dataFinal, 'Data até')) 
        	return false;
        
        //datas devem ser válidas
				if (validarData(document.frmMain.dataInicial.value) == false) {
					msg('014','Data De');
					document.frmMain.dataInicial.focus();
					return false;
				}
				if (validarData(document.frmMain.dataFinal.value) == false) {
					msg('014','Data Até');
					document.frmMain.dataFinal.focus();					
					return false;
				}			
        
        //data inicio deve ser menor que data fim
        if (!compararDatas(document.frmMain.dataInicial.value, document.frmMain.dataFinal.value, "<=")) {
        	msg('034','Data De','Data Até');
        	document.frmMain.dataInicial.focus();
        	return false;
        }   
        return true;
      }
      
    </script>
  </s:FormStrategy>
</p:Document>
</html>