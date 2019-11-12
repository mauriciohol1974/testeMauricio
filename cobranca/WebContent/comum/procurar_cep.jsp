<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: procurar_cep.jsp - Java Server Pages
*Autor: Glauber M. Gallego ggallego@sao.politec.com.br
*Ultima Atualização: 29/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.comum.ProcurarCepEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CepBean"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>

<%
	CepBean cepBean = (session.getAttribute(ProcurarCepEstrategia.DATA_BEAN)==null?new CepBean():(CepBean)session.getAttribute(ProcurarCepEstrategia.DATA_BEAN));
%>

<html>
<s:HeaderPopup/>
  
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia="" fluxo="normal">

		<table width="350" border="0" cellpadding="0" cellspacing="0">
      <tr> 
        <td>&nbsp;</td>
      </tr>
			<tr height="65">
				<td valign="top" align="left" style="background-repeat:no-repeat"
				    background="<%=Paths.getImagePath()%>/baseTitulo.gif">
				    <h3> Pesquisa de CEP: <%=cepBean.getCepFormatado()%> </h3>
				</td>
		  </tr>
		</table>

    <table width="350" border="0" cellspacing="0" cellpadding="0" align="center">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Endereco: </td>
              <td class="textoValor" width="26%"><%=cepBean.getEndereco()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Bairro: </td>
              <td class="textoValor" width="26%"><%=cepBean.getBairro()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Municipio: </td>
              <td class="textoValor" width="26%"><%=cepBean.getMunicipio()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Estado: </td>
              <td class="textoValor" width="26%"><%=cepBean.getUf()%></td> 
            </tr>

            <tr> 
              <td colspan="5">&nbsp;</td>
            </tr>
            <tr> 
              <td colspan="5">
                <p align="center"> 
                 	<s:Button name="Atualizar" action="javascript: formSubmit();"/>
                 	<s:Button name="Cancelar" action="javascript: formSubmit_Cancelar();"/>
                </p>
              </td>
            </tr>
          </table>
        </TD>
      </tr>
    </table>
    <script language="javascript">
			function inicia() {
			}						
	    function formSubmit() {
	    	if (confirm(conf("150"))) {

		    	opener.frmMain.endereco.value = "<%=cepBean.getEndereco()%>";
		    	opener.frmMain.bairro.value = "<%=cepBean.getBairro()%>";
		    	opener.frmMain.municipio.value = "<%=cepBean.getMunicipio()%>";
		    	opener.frmMain.uf.value = "<%=cepBean.getUf()%>";
					opener.atualizar_endereco();

				  window.close();
				}
	    }
	    function formSubmit_Cancelar() {
	    	if (confirm(conf("103"))) {
					window.close();
				}
	    }
		</script>
  </s:FormStrategy>
</p:Document>
</html>