<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: servpro_consular_todos.jsp - Java Server Pages
*Autor: David Lopes Muiños Torneiros - david.torneiros@sao.politec.com.br
*Ultima Atualização: 15/05/2007 - v1
************************************************/
%>
<script language ="javascript">
    history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServDiaEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean "%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.consulta.ServDiaManterFiltro" %>
<%@page import="br.com.politec.sao.util.PageHolder"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>


<%
    ConGerServicosSolicitadosBean cabeEXBean = (ConGerServicosSolicitadosBean)session.getAttribute(ServDiaManterFiltro.BEAN_DATA);
    
    CedenteCabecaBean cedCabBean 			=	(CedenteCabecaBean)session.getAttribute(ServDiaManterFiltro.BEAN_CABECALHO);
    
    ConGerServicosSolicitadosBean dataBean 	= (session.getAttribute(ServDiaManterFiltro.BEAN_DATA)==null? new ConGerServicosSolicitadosBean()
                                                                        : (ConGerServicosSolicitadosBean)session.getAttribute(ServDiaManterFiltro.BEAN_DATA));
    
    //o retorno deste recordset somente poderá ser até dois registros
    PageHolder paginacao = (PageHolder) session.getAttribute(ServDiaManterFiltro.PAGINACAO_LIST);
    paginacao.setPageSize(20);	
    List lista = paginacao.getPageableSize() == 0 ? new LinkedList() : paginacao.getPage(0);	

%>

<s:Header/>
  <p:Document>  	
    <s:FormStrategy name="frmMain" action="SigcbControle" estrategia="consulta.ServDiaManterFiltro" fluxo="normal">   	          				
        <s:Menu/>   		
        <s:Titulo name="<%=ServDiaEstrategia.TITLE%>"/>
        
        <input type="hidden" name="tpFiltro" value="<%=dataBean.getTpFiltro()%>"/>
        <input type="hidden" name="tpConsulta" value=""/>
        <input type="hidden" name="codigoCedente" value="<%=cedCabBean.getCodigoCedente()%>"/>
        <!--<input type="hidden" name="dataSolicitacao" value="<%=dataBean.getDataSolicitacaoFormatada()%>" />-->
        
        
        
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

            <tr>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getCodigoCedente().equals( new Long(0))?"":cedCabBean.getCodigoCedenteFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getNomeFantasia()%>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo Pessoa: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getTipoPessoaTexto()%></td>
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor"  width="26%"><%=cedCabBean.getCpfCnpjFormatado()%></td>
            </tr>
            <tr>
                <td class="textoTitulo" width="17%" valign="top">Código Cliente (COCLI): </td>
                <td class="textoValor"  width="26%" valign="top"><%=cedCabBean.getCodigoClienteCOCLI().equals(new Long(0))? "":cedCabBean.getCodigoClienteCOCLI().toString()%></td> 
                <td class="textoTitulo" width="17%" valign="top">Relatório:</td>
              <td class="textoValor"  width="26%" valign="top"><%=cabeEXBean.getNomeRelatorio()%></td>
              </tr>

            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">Consulta:
                <hr>
              </td>
            </tr>
                        
                        <tr>
                            <td colspan="4">
                                <table width="100%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
                                  <tr class="headerLista">
                                    <td nowrap width="1%"	 align="center">&nbsp;</td>								  
                                    <td nowrap width="20%" align="left">Serviços</td>
                                    <td nowrap width="20%" align="left">Quantidade</td>
                                    <!--<td nowrap width="1%"	 align="center">&nbsp;</td>-->
                                  </tr>
                            <%
                                    ConGerServicosSolicitadosBean occ = new ConGerServicosSolicitadosBean();
                                    for ( int i = 0; i < lista.size(); i++ ) {	
                                        occ = (ConGerServicosSolicitadosBean) lista.get(i);
                                        
                            %>	  
                                  <tr <%= ( ((i+1)%2) == 0 ) ? "class='line0'" : "class='line1'" %>>
                                    <td nowrap width="1%"	 align="center"><input type="radio" name="radioRelatorio" value="<%=occ.getDescricaoItem()%>"></td>
                                    <td nowrap width="20%" align="left"><%=occ.getTextoDescricaoItens()%></td>
                                    <td nowrap width="20%" align="left"><%=occ.getQuantidadeItens()%></td>
                                    <!--<td nowrap width="1%"	 align="center">&nbsp;</td>-->
                                  </tr>
                            <%  } %>								  
                                </table>
                            </td>
                        </tr>            
            <tr> 
              <td colspan="4">&nbsp;</td>
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
                <s:Button name="Ok" action="javascript:formSubmit()"/>
                <s:Button name="Voltar" action="javascript:formSubmit_Voltar()"/> 
                </p>
                </td>
              </tr>
          </table>
        </td>
      </tr>
    </table>
    <script>
    	function inicia() {
			setFirstFieldFocus();
		}
    
       function formSubmit()
       {
          if(validaSubmit()){
           document.frmMain.submit();
          }
       }
       
       function formSubmit_Voltar() {
            document.frmMain.estrategia.value= "consulta.ServDiaManterIniciar";
            //document.frmMain.estrategia.value= "consulta.ServProManterFiltro";
            document.frmMain.fluxo.value= "voltar";
            document.frmMain.submit();
	    }
            
        function validaSubmit()
        {
          if(document.frmMain.radioRelatorio.length == null){
          		//alert("é null");
          		if(!document.frmMain.radioRelatorio.checked){
          			//alert("nao esta selecionado");
					msg('041','Tipo Consulta');
					return false;
          		}
          		else{
          			//alert("tem valor selecionado");
          			var value = document.frmMain.radioRelatorio.value;
          			//alert(value);
          			retorno = bindValorRadioComTpConsulta(value);
          			//alert(retorno);
          			return retorno;
          		}
          }
          else 
          {
          	  //alert("è um array");
           if (!validaRadioButtonMsg(document.frmMain.radioRelatorio, 'Tipo Consulta', '041')) {
                     return false;    		
           }else{
           		for(var i = 0 ; i < document.frmMain.radioRelatorio.length ; i++){
           			if(document.frmMain.radioRelatorio[i].checked){
            			var value = document.frmMain.radioRelatorio[i].value;
            			return bindValorRadioComTpConsulta(value);
            		}
           		}
          	}
          }
      }
      
      function bindValorRadioComTpConsulta(valor){
      	switch(parseInt(valor)){
			case 1:
				document.frmMain.tpConsulta.value="7";
         		return true; 
			case 2:
				document.frmMain.tpConsulta.value="6";
         		return true;
			case 3:
				document.frmMain.tpConsulta.value="9";
         		return true;
			case 4:
				document.frmMain.tpConsulta.value="8";
         		return true;
			case 5:
				document.frmMain.tpConsulta.value="888";
         		return true;
			case 6:
				document.frmMain.tpConsulta.value="3";
         		return true;
			case 7:
				document.frmMain.tpConsulta.value="5";
         		return true;
			case 8:
				document.frmMain.tpConsulta.value="999";
         		return true;
			case 9:
				document.frmMain.tpConsulta.value="2";
         		return true;
         	default:
         		return false;	
		}
      }
             
    </script>
   </s:FormStrategy>
    </p:Document>