

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.estrategia.SigcbEstrategia"%>

<%
	int linhas = 0;
	String strLinhas = request.getParameter("linhas");
	if (strLinhas != null) {
		linhas = Integer.parseInt(strLinhas);
	}
	
	int colunas = 0;
	String strColunas = request.getParameter("colunas");
	if (strColunas != null) {
		colunas = Integer.parseInt(strColunas);
	}
%>

<%
	boolean sessAtiva = false;
	sessAtiva = session.getAttribute(SigcbEstrategia.USUARIOLDAP_BEAN) == null? false : true;
%>

<html>
  <s:HeaderPopup/>
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="" fluxo="normal">

		<table width="350" border="0" cellpadding="0" cellspacing="0">
      <tr> 
        <td>&nbsp;</td>
      </tr>
			<tr height="65">
				<td valign="top" align="left" style="background-repeat:no-repeat"
				    background="<%=Paths.getImagePath()%>/baseTitulo.gif">
				    <h3>Editar Mensagem</h3>
				</td>
		  </tr>
		</table>
	
    <table width="350" border="0" cellspacing="0" cellpadding="0" align="center">
    	<tr align="center">
    		<td>
    			<s:InputMensagem name="linha" linhas="<%=linhas%>" colunas="<%=colunas%>" />
    		</td>
			</tr>
			
			<tr><td>&nbsp;</td></tr>
			
    	<tr align="center">
    		<td>
		   		<s:Button name="Confirma" action="javascript:formSubmit();" />
		   		<input type="reset" value="Limpa" class="button">
    		</td>
			</tr>
			
		</table>

			<script>
				function inicia() {
				<%=!sessAtiva?"msg('018');window.close()":""%>
					var texto = window.dialogArguments;
					var textoLinhas = texto.split('\n');
					
					if (document.frmMain.linha[0] != null) {
						for (var i = 0; i < document.frmMain.linha.length; i++) {
							if (i < textoLinhas.length) {
								document.frmMain.linha[i].value = textoLinhas[i];
							} else {
								document.frmMain.linha[i].value = '';
							}
						}
					} else {
						document.frmMain.linha.value = textoLinhas[0];
					}
				}
				
				function formSubmit() {
					var linhas = document.frmMain.linha;
					var temp = "";
					
					if (linhas[0] != null) {
						
						for (var i = 0; i < linhas.length; i++) {
							temp += linhas[i].value + '\n';
						}
						
					} else {
						temp = linhas.value + '\n';
					}
					
					window.returnValue = temp;
					window.close();
				}
			</script>
   	
   	</s:FormStrategy>
  </p:Document>
</html>