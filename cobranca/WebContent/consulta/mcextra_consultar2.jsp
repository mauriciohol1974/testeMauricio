<%/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: mcextra_consultar.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 12/10/2004 - v1
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="java.util.List"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page	import="br.gov.caixa.sigcb.estrategia.consulta.MCExtraEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.ExtratoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.ConGerMovimentoCedenteBean"%>
<%@page import="br.com.politec.sao.business.util.BeanList"%>
<%@page import="java.util.ArrayList"%>




<%
ArrayList listaExtrato = (ArrayList) session.getAttribute("listaExtrato");
String codCedente = (String)request.getAttribute("codigoCedente");
String dataExtrato = (String)request.getAttribute("dataEmissao");
String pagina = (String)request.getAttribute("pagina");

Integer proxPag = Integer.parseInt(pagina) + 1;
Integer pagAnterior = Integer.parseInt(pagina)-1;

%>

<s:Header />
<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"	estrategia="<%=MCExtraEstrategia.STRATEGY_FILTRO%>" fluxo="normal">
		<s:Menu />
		<s:Titulo name="Consultar Movimento do Cedente (Extrato)" />
		
		<input type="hidden" name="pagina" value=<%=pagina %> />
		<input type="hidden" name="paginaFinal" value="0"> 
		<input type="hidden" name="codigoCedente" value=<%=codCedente %> />
		<input type="hidden" name="dataEmissao" value=<%=dataExtrato %> />
		
		<table width="777" BORDER="0" cellspacing="3" cellpadding="0">
			

						<%
							ExtratoBean extrato = new ExtratoBean();
							for (int i=0;i<listaExtrato.size();i++){
								extrato = (ExtratoBean) listaExtrato.get(i);
						%>

									<%=extrato.getRegistro() %>
						<% 
						}
                    	%>

					
					
					<tr>
						<td align="right" colspan="4">
						
						<a href="javascript:trocapagina(<%=pagAnterior%>)">Anterior</a>
						<a href="javascript:trocapagina(<%=proxPag%>)">Próxima</a>
						<p align="center">
						<s:Button name="Voltar" action="javascript:formSubmit_Voltar();" />
						<s:Button name="Imprimir" action="javascript:imprimirIntervalo();" />
						<s:Button name="Imprimir Tudo" action="javascript:imprimirTudo();" />
						</p>
						</td>
					</tr>

		</table>
		<script>
   	function formSubmit(){}
	function inicia(){
        setFirstFieldFocus();
    }
    function formSubmit_Voltar() {
    	document.frmMain.estrategia.value='consulta.MCExtraManterIniciar';
    	document.frmMain.fluxo.value='voltar';
        document.frmMain.submit();
    }
    
    
  
    function imprimirIntervalo() {		
		var valorAltura = 350;
		var valorLargura = 640;
		var valorTopo = (screen.height - valorAltura) /2;
		var valorEsquerda = (screen.width - valorLargura) /2;
		var pagIni=prompt("Informe a pagina inicial","1");
		var pagFim=prompt("Informe a pagina final","1");
		document.frmMain.pagina.value=pagIni;
		document.frmMain.paginaFinal.value=pagFim;
		janela = window.open("<%=Paths.getRootForDynamicContent()%>/jump/imp_extrato_jump.jsp");
		janela.focus();
    }
    
    function imprimirTudo() {		
		var valorAltura = 350;
		var valorLargura = 640;
		var valorTopo = (screen.height - valorAltura) /2;
		var valorEsquerda = (screen.width - valorLargura) /2;
		document.frmMain.pagina.value="1";
		document.frmMain.paginaFinal.value="9999999";
		janela = window.open("<%=Paths.getRootForDynamicContent()%>/jump/imp_extrato_jump.jsp");
		janela.focus();
    }
    
    function trocapagina(pag){
       	document.frmMain.pagina.value=pag
        document.frmMain.submit();
    }
    </script>
	</s:FormStrategy>
</p:Document>
</html>
