<%
/***********************************************
*Projeto CAIXA - SIGCB
*Componente: protest_consultar_envio_incluir.jsp - Java Server Pages
*Autor: Cristian Souza - Probank/REDEASP02
*Data Criação: Fev/2009
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.ProtestoTituloBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.ProtestEstrategia"%>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="br.com.politec.sao.business.types.MoneyType"%>
<%@page import="br.com.politec.sao.util.Currency"%>
<%@page import="br.com.politec.sao.util.Money"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>

<% 
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute(ProtestEstrategia.USUARIOLDAP_BEAN);	

	int paginaAtual = 0;
	PageHolder paginacao = (PageHolder) session.getAttribute(ProtestEstrategia.PAGINACAO_LIST);
	if(request.getParameter(ProtestEstrategia.PAGINACAO_PAGE) != null && !request.getParameter(ProtestEstrategia.PAGINACAO_PAGE).equals("")){
		paginaAtual = Integer.parseInt((String)request.getParameter(ProtestEstrategia.PAGINACAO_PAGE));
	} else {
		paginaAtual = Integer.parseInt((String)request.getAttribute(ProtestEstrategia.PAGINACAO_PAGE));
	}
	
	String controleAlteracao = "";

	if(request.getParameter("controleAlteracao") != null && !request.getParameter("controleAlteracao").equals("")){
		controleAlteracao  = (String)request.getParameter("controleAlteracao");
	} else {
		controleAlteracao =  (String)request.getAttribute("controleAlteracao");
	}
	
	//  A String com o controle de alteração possui o formato:
	//  #0#|[0]R$ 1.750,00|[1]R$ 630,95|[7]R$ 815,92
	//	#0# --> Nùmero da página
	//  [0]R$ 1.750,00 --> Índice selecionado e seu respectivo valor

	
	if ((controleAlteracao != null) && (controleAlteracao.length() > 0)) {
		   String pagina = controleAlteracao.substring(controleAlteracao.indexOf("#")+1,controleAlteracao.lastIndexOf("#"));
		   int lastCerquilha = controleAlteracao.lastIndexOf("#");
		   String dados = controleAlteracao.substring(lastCerquilha+1);
		   StringTokenizer strTokenizer = new StringTokenizer(dados,"|");
		   ArrayList<String> valores = new ArrayList<String>();
		   while(strTokenizer.hasMoreElements()) {
			   valores.add((String)strTokenizer.nextElement());
			   
		   }
		   
		   Iterator i = valores.iterator();
		   HashMap<Integer, Money> map = new HashMap<Integer, Money>();
		   
		   while (i.hasNext()){
			   
			   String texto = (String)i.next();
			   int pos = Integer.valueOf(texto.substring(texto.indexOf("[")+1,texto.lastIndexOf("]")));
			   int lastChave = texto.lastIndexOf("]");
			   String vlrCust = texto.substring(lastChave+1);
			   
			   if (vlrCust.trim().equals("")) {
				   vlrCust = "R$ 0,00";
			   }
			   
			   //Cria a partir da String com símbolo de R$ 
			   Money m = (Money) MoneyType.create().newInstance(vlrCust);
			   map.put(new Integer(pos), m);
		   }
		   

		   List listaAnterior = paginacao.getPage(Integer.valueOf(pagina));
		   

		   //Desmarca na lista os checks que foram marcados e posteriormente desmarcados
		   Set keys = map.keySet();
		   Iterator it = keys.iterator(); 
		   for (int j= 0 ; j < listaAnterior.size(); j++) {
			if (!keys.contains(Integer.valueOf(j))) {
			   ProtestoTituloBean protest= (ProtestoTituloBean)listaAnterior.get(Integer.valueOf(j));
		           if ((Boolean.TRUE).equals(protest.getSelecaoCheck())){
				Money valor = (Money) MoneyType.create().newInstance("R$ 0,00");
				protest.setValorCusta(valor);
			   	protest.setSelecaoCheck(Boolean.FALSE);       	

			   }		

			}
		
		   }


		   Iterator iterat = keys.iterator(); 		
		   while (iterat.hasNext()){
			   Integer chave  = (Integer)iterat.next();
			   Money valor  = map.get(chave);
			 
			   ProtestoTituloBean protest= (ProtestoTituloBean)listaAnterior.get(chave.intValue());
			   protest.setValorCusta(valor);	
	           	   protest.setSelecaoCheck(Boolean.TRUE);	
			   
		   }	
	  
	}



	
	
	List lista = paginacao.getPage(paginaAtual);	
%>

<%
	ProtestoTituloBean protestoTituloBean = (session.getAttribute(ProtestEstrategia.PROTESTO_TITULO_DATA_BEAN)==null?new ProtestoTituloBean():(ProtestoTituloBean)session.getAttribute(ProtestEstrategia.PROTESTO_TITULO_DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=ProtestEstrategia.STRATEGY_ACAO_ENVIO_AO_CARTORIO_INCLUIR %>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=ProtestEstrategia.PAGE_TITLE_ACAO_PROTESTO_ENVIO_AO_CARTORIO%>"/>    
  	<input type="hidden" name="<%=ProtestEstrategia.PAGINACAO_PAGE%>" value="">
	<input type="hidden" name="controleAlteracao" value="">
	<input type="hidden" name="nomeGrupo" value="<%=usuarioBean.getNomeGrupo()%>">
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="17%">Data da Solicitação: </td>
              <td nowrap class="textoValor" width="26%"><%=protestoTituloBean.getDataSolicitacaoFormatada().equals("01/01/0001")?"":protestoTituloBean.getDataSolicitacaoFormatada()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Unidade Cobradora: </td>
              <td nowrap class="textoValor" width="26%"><%=protestoTituloBean.getCodigoUnidadePv().equals( new Long(0))?"":protestoTituloBean.getCodigoUnidadePvFormatado()%> - <%=protestoTituloBean.getNomeUnidadePv()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Ação: </td>
              <td nowrap class="textoValor" width="26%">INCLUIR</td>
            </tr>  
            <tr>
              <td class="textoTitulo" width="17%">&nbsp;</td>
              <td class="textoValor" width="26%">&nbsp;</td>
            </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Inclusão:
                <hr>
              </td>
            </tr>
						<tr>
							<td colspan="4">
								<table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
								  <tr class="headerLista">
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="15%" align="right">Nosso Número</td>
								    <td nowrap width="25%" align="left">Cedente</td>
								    <td nowrap width="30%" align="left">Nome Devedor</td>
                                    <td nowrap width="10%" align="left">Data Prevista</td>
								    <td nowrap width="30%" align="left">Valor Título</td>
								    <td nowrap width="20%" align="right">Todos<input type="checkbox" value="" name="checkboxTodos" onClick="javascript:selecionaTodos('checkboxGrupo');javascript:atualizaAlteracao('checkboxGrupo');">
                                    <td nowrap width="20%" align="left">Despesas Cartorárias</td>
								  </tr>
							<%
									ProtestoTituloBean occ = new ProtestoTituloBean();
									for ( int i = 0; i < lista.size(); i++ ) {	
										occ = (ProtestoTituloBean) lista.get(i);
							%>								  
								  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
								    <td nowrap width="2%" align="center">&nbsp;</td>
 								    <td nowrap width="15%" align="right"><%=occ.getNossoNumeroFormatado()%></td>
								    <td nowrap width="25%" align="right"><%=occ.getCodigoCedenteFormatado()%></td>
								    <td nowrap width="30%" align="left"><%=occ.getNomeDevedor()%></td>
                                    <td nowrap width="5%" align="left"><%=occ.getDataEnvioProtestoFormatada().equals("01/01/0001")?"":occ.getDataEnvioProtestoFormatada()%></td>
 								    <td nowrap width="30%" align="left"><%=occ.getValorTitulo()%></td>
 								    <td nowrap width="20%" align="right"> <input type="checkbox" value="" name="checkboxGrupo" <%=(Boolean.TRUE).equals(occ.getSelecaoCheck())?" checked='true'":""%>></td>
                                    <td class="textoValor" width="20%">
						        	<p:InputCurrency CLASS="inputtext" 
							        	name="valorCusta" 
							          value='<%=occ.getValorCusta().toString().equals("R$ 0,00")?"":occ.getValorCusta().toString()%>'
							          size="22" maxlength="7"	 
							          disabled="false" />
			              </td>
							    
								  </tr>
						<%  } %>								  
 	                <tr>
	                  <td colspan="12">&nbsp;</td>
	                </tr>
									<tr>
										<td colspan="10" align="center">
											<s:ButtonPaginarProtesto 
											  		pageNumber="<%=paginacao.getPageNumber()%>" 
											  		numberOfPages="<%=paginacao.getPageCount()%>" 
											  		pageName="<%=ProtestEstrategia.PAGE_CONSULTAR_INCLUIR%>"/>
										</td>
									</tr>
 	                <tr> 
	                  <td colspan="12">&nbsp;</td>
	                </tr>
	              </table>
              </td>
            </tr>

            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Totais:
                <hr>
              </td>
            </tr>

            <tr>
              <td class="textoTitulo" width="28%">Quantidade Total: </td>
              <td class="textoValor" width="20%"><%=protestoTituloBean.getQuantidadeTotalTitulo()%></td> 
              <td class="textoTitulo" width="24%">Valor Total: </td>
              <td class="textoValor" width="28%"><%=protestoTituloBean.getValorTotalTitulo()%></td>
            </tr>

 	          <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>
 	          <tr> 
	            <td colspan="4">&nbsp;</td>
	          </tr>
	          
            <tr>
              <td align="right" colspan="4">
 	              <p align="center">
			<s:Button name="Confirmar" 
                  	action="javascript:formSubmit();"
                   	userGroup="<%=usuarioBean.getNomeGrupo()%>" 
                   	internalAction="servico.protesto.envioaocartorio.acoes"/>   
	                <s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/>
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

	    function inicia(){
	    }
	    
		function selecionaTodos(nomeGrupo) {
	   		var grupoCheckBox = document.getElementsByName(nomeGrupo);
	   		var status = document.getElementById('checkboxTodos').checked;
           
           	for(var i=0; i < grupoCheckBox.length; i++) {
				grupoCheckBox[i].checked = status;
	   		}		
		}


		function atualizaAlteracao(nomeGrupo) {
	   		var grupoCheckBox = document.getElementsByName(nomeGrupo);
			var grupoValorCusta = document.getElementsByName('valorCusta');
	   		//var status = document.getElementById('checkboxTodos').checked;

			var str = '#'+'<%=paginaAtual%>'+'#';	
           
           	for(var i=0; i < grupoCheckBox.length; i++) {

			      if (grupoCheckBox[i].checked) {	
				str = str + "|"+ "["+i+"]"+grupoValorCusta[i].value;
			      }	

	   		}
			
			document.frmMain.controleAlteracao.value = str;

		
		}




	  	function formSubmit() {
             if (confirm("Deseja realmente executar esta ação?\nAção sujeita a cobrança de tarifa.")) {
          		document.frmMain.paginaAtual.value = '<%=paginaAtual%>';
		        
          		atualizaAlteracao('checkboxGrupo'); 
		        
           		document.frmMain.submit();
           	 } 	
	    }  
	    
	    function formSubmit_Voltar() {
		   document.frmMain.estrategia.value = '<%=ProtestEstrategia.STRATEGY_MANTER_ENVIO_AO_CARTORIO_INICIAR%>';    	
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
      	}  


		</script>
  </s:FormStrategy>
</p:Document>
</html>