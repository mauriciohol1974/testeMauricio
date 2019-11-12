<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Agosto de 2004
*Projeto CAIXA - SIGCB
*Componente: protest_acao_filtro.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 23/09/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="java.util.Calendar"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ProtestEstrategia"%>

<%
	TituloBean tituloBean = (session.getAttribute(ProtestEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(ProtestEstrategia.DATA_BEAN));	
%>

<html>
<s:Header/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ProtestEstrategia.STRATEGY_MANTER_FILTRO%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=ProtestEstrategia.PAGE_TITLE%>"/>

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Data da Solicitação: </td>
              <td class="textoValor" width="26%"><%=Formatador.formatarData(Calendar.getInstance().getTime())%></td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Informar Título:
                <hr>
              </td>
            </tr>

            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="codigoCedente" 
            	  		value='<%=tituloBean.getCodigoCedente().equals(new Long(0))?"":tituloBean.getCodigoCedente().toString()%>'
             				size="7" maxlength="7"
	                	onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumero);"/>
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Nosso Número: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" name="nossoNumero"  
          	    		value='<%=tituloBean.getNossoNumero().equals(new Long(0))?"":tituloBean.getNossoNumero().toString()%>'
              			size="23" maxlength="17"
	                	onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.acoesServicoTitulo);"/>
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Ação: </td>
              <td class="textoValor" width="26%">
                <s:ComboProtestoAcao name="acoesServicoTitulo" 
                   selectedValue='<%=tituloBean.getAcoesServicoTitulo().toString()%>'/>
							</td>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td> 
					  </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>

            <tr> 
              <td colspan="4">
                <p align="center"> 
                  <input type="button" class="button" value="Ok" 
                         onclick="javascript:formSubmit();">
                </p>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    
    <script>
      function inicia(){
				setFirstFieldFocus();
      }
      
      function formSubmit(){
      	if(validaSubmit()) {
	      	document.frmMain.submit();
				}	      	
      }

      function validaSubmit(){
		    if(!validaCampoObrigatorio(document.frmMain.codigoCedente, "Cedente")) {
				  return false;
		    }		    
		    if(!validaCampoObrigatorio(document.frmMain.nossoNumero, "Nosso número")) {
				  return false;
		    }
        return true;
      }
    </script>
  </s:FormStrategy>
</p:Document>
</html>
