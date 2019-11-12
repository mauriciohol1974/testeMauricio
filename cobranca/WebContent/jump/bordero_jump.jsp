<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: bordero_jump.jsp - Java Server Pages
*Autor: Eduardo A. Morás emoras@sao.politec.com.br
*Ultima Atualização: 17/09/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>
<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.BorderoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.BorderoEstrategia"%>

<%
	int acao = 0;
	acao = session.getAttribute(BorderoEstrategia.DATA_BEAN)==null?1 :0;
	BorderoBean borderoBean = (session.getAttribute(BorderoEstrategia.DATA_BEAN)==null?new BorderoBean():(BorderoBean)session.getAttribute(BorderoEstrategia.DATA_BEAN));
	borderoBean.setNavegacao(BorderoEstrategia.NAVEGACAO_IMPRIMIR);
%>
<html>
<s:HeaderPopup/>
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"
		estrategia='<%=BorderoEstrategia.STRATEGY_IMPRIMIR%>' fluxo="normal">
    <input type="hidden" name="navegacao" value="<%=borderoBean.getNavegacao()%>">
    <input type="hidden" name="codigoCedente">
    <input type="hidden" name="situacao">
    <input type="hidden" name="codigoBordero">
    <script>
			function inicia() {
			<%=acao == 1?"msg('018');window.close()":"formSubmit()"%>
			}
	    function formSubmit() {
		    document.frmMain.codigoCedente.value=opener.frmMain.codigoCedente.value;
		    document.frmMain.codigoBordero.value=opener.frmMain.codigoBordero.value;
				document.frmMain.situacao.value=opener.frmMain.situacao.value;
				if(document.frmMain.situacao.value==1){
					msg('016');
					window.close();
				}
				else{
					document.frmMain.submit();
				}
	    }
    </script>
  </s:FormStrategy>
</p:Document>
</html>