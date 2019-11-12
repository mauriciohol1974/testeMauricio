<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: mcrenta_manter_filtro.jsp - Java Server Pages
*Autor: Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
*Ultima Atualização: 19/10/2004 - v1
************************************************/
%>
<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>

<%@page import="br.gov.caixa.sigcb.estrategia.consulta.MCRentaEstrategia" %>
<%@page import="br.gov.caixa.sigcb.bean.ConGerCedenteRentabilidadeBean"%>
<%
  ConGerCedenteRentabilidadeBean filtroBean = (session.getAttribute(MCRentaEstrategia.BEAN_FILTRO)==null? new ConGerCedenteRentabilidadeBean()
																			:(ConGerCedenteRentabilidadeBean)session.getAttribute(MCRentaEstrategia.BEAN_FILTRO));
%>

<s:Header/>
  <p:Document>  	
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="<%=MCRentaEstrategia.STRATEGY_FILTRO%>" fluxo="normal">   	          				
 		<s:Menu/>   		
 		<s:Titulo name="Consultar Cedentes por Rentabilidade >> Filtro"/>

    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
						<tr>
              <td class="textoTitulo" width="17%">Período: </td>
              <td class="textoValor" width="26%"> 
              	<s:ComboPeriodo name="periodo" selectedValue='<%=filtroBean.getPeriodo().equals(new Long(0))?"1":filtroBean.getPeriodo().toString()%>'/>
              </td>
            	<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Rentabilidade: </td>
              <td class="textoValor" width="26%"> 
              	<s:ComboRentabilidade name="rentabilidade" selectedValue='<%=filtroBean.getRentabilidade().equals(new Long(0))?"1":filtroBean.getRentabilidade().toString()%>' />
              </td>
            	<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Número de Resultados: </td>
              <td class="textoValor" width="26%"> 
              	<p:InputNumerico name="numeroResultado" maxlength="2" size="2"  CLASS="inputtext"
	       						value='<%=filtroBean.getNumeroResultado().equals(new Long(0))?"":filtroBean.getNumeroResultado().toString()%>' 
	       						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.faixaRentabilidade);"/>               	
              </td>
            	<td width="17%">&nbsp;</td>
            	<td width="26%">&nbsp;</td>
						</tr>
						<tr>
              <td class="textoTitulo" width="17%">Faixa de Rentabilidade: </td>
              <td class="textoValor" colspan="3" width="26%"> 
								<s:ComboFaixaRentabilidade name="faixaRentabilidade" 
									selectedValue='<%=filtroBean.getFaixaRentabilidade().equals(new Long(0))?"0":filtroBean.getFaixaRentabilidade().toString()%>' 
									onChange="javascript:desabilitaValor(this);"/>
              	<p:InputCurrency name="valorReferencia" maxlength="15" size="27"  CLASS="inputtext"
	       						value='<%=filtroBean.getValorReferencia().equals("R$ 0,00")?"":filtroBean.getValorReferencia().toString()%>'
	       						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/>               	
              </td>
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
      function inicia(){
        setFirstFieldFocus();
        desabilitaValor(document.frmMain.faixaRentabilidade);
      }
      function formSubmit() {
        if (validaSubmit()) {
	       document.frmMain.submit();
        }
      }
      
      function validaSubmit(){
	     	if(!validaCampoObrigatorio(document.frmMain.numeroResultado,'Numero de Resultado')){
	     		return false;
	     	}
     		if(document.frmMain.faixaRentabilidade.value != 0){
     			if(!validaCampoObrigatorio(document.frmMain.valorReferencia,'Valor referencia')){
     				return false;
     			}
//GMG. ini
//     			if(!validaValorZero(document.frmMain.valorReferencia, 'Valor Referencia')){
//     				return false;
//     			}
//GMG. fim
     		}	
      	return true;
      }
      
      function desabilitaValor(obj){
      	if(obj.value == 0){
      		document.frmMain.valorReferencia.disabled = true;
      		document.frmMain.valorReferencia.value = "";      	
      	} else {
      		document.frmMain.valorReferencia.disabled = false;
      	}
      }

    </script>
    </s:FormStrategy>
	</p:Document>
</html>
    
