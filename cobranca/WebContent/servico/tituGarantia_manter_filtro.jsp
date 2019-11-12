<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Agosto de 2004
*Projeto CAIXA - SIGCB
*Componente: bcotitu_manter_filtro.jsp - Java Server Pages
*Autor: Antonio Nestor Fusel - afusel@sao.politec.com.br
*Autor: Glauber M. Gallego - ggallego@sao.politec.com.br
*Ultima Atualização: 25/10/2004
************************************************/
%>

<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.TituloBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.TituGarantiaEstrategia"%>

<%
	CedenteCabecaBean cedCabBean = (session.getAttribute(TituGarantiaEstrategia.CEDENTE_CABECALHO_BEAN)==null?new CedenteCabecaBean():(CedenteCabecaBean)session.getAttribute(TituGarantiaEstrategia.CEDENTE_CABECALHO_BEAN));
	TituloBean tituloBean = (session.getAttribute(TituGarantiaEstrategia.DATA_BEAN)==null?new TituloBean():(TituloBean)session.getAttribute(TituGarantiaEstrategia.DATA_BEAN));	

	//Long filtroSelecao = tituloBean.getFiltroSelecao()==null?new Long(1):tituloBean.getFiltroSelecao();
%>

<html>

<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle" 
		estrategia="<%=TituGarantiaEstrategia.STRATEGY_MANTER_FILTRO%>"  
		fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=TituGarantiaEstrategia.PAGE_TITLE_FILTRO%>"/>
		
		
		<input type="hidden" name = "filtroDescricaoSituacao" value="">
		<input type="hidden" name = "filtroDescricaoClassificacao" value="">
		<input type="hidden" name = "filtroVoltarListarConsolidado" value="0">
		<input type="hidden" name = "filtroVoltarListarTitulo" value="0">
		<input type="hidden" name = "filtroVoltarAcao" value="0">
		
    <table width="777" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height="53" valign="middle" align="center">
            <tr> 
              <td class="textoTitulo" width="2%">&nbsp;</td>
              <td class="textoTitulo" width="17%">Cedente: </td>
              <td class="textoValor" width="26%">
              	<p:InputNumerico CLASS="inputtext" 
              	 name="codigoCedente" size="7" maxlength="7"
 								 value='<%=tituloBean.getCodigoCedente().equals(new Long(0))?"":tituloBean.getCodigoCedente().toString()%>'
        						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.nossoNumero);"/> 
							</td>
            	<td class="textoTitulo" width="17%">&nbsp;</td>
            	<td class="textoTitulo" width="26%">&nbsp;</td>
						</tr>
						
						<tr>
							<td colspan="5">&nbsp;</td>
						</tr>
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Opções de Filtro:
                <hr>
              </td>
            </tr>
            <tr> 

              <td class="textoTitulo" width="17%">Nosso Número Inicial: </td>
              <td class="textoValor" colspan="3" width="26%">
              	<p:InputNumerico CLASS="inputtext"  name="nossoNumero" size="23" maxlength="17"/> 
			  </td>
            </tr>
						
            <tr> 

              <td class="textoTitulo" width="17%">Nosso Número Final: </td>
              <td class="textoValor" colspan="3"  width="26%">
              	<p:InputNumerico CLASS="inputtext"
              	name="nossoNumeroFim" size="23"
 							  value='<%=tituloBean.getNossoNumero().equals(new Long(0))?"":tituloBean.getNossoNumero().toString()%>'
	               maxlength="17" 
        						onFocus="javascript: prevFocus(this);"
										onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Ok);"/> 
							</td>
             
						</tr>						
            <tr> 
              <td class="textoTitulo" width="17%">Classificado por: </td>
              <td class="textoTitulo" width="26%">
              	<s:ComboClassificacaoTitulo name="classificacao"
	              	selectedValue='<%=tituloBean.getClassificacao().toString()%>'/>
							</td>
						</tr>
						<tr>
							<td colspan="5">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="5">&nbsp;</td>
						</tr>
	          <tr>
	            <td align="right" colspan="5">
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
				setFirstFieldFocus();
			}


			

			
	    function formSubmit() {

   	    	document.frmMain.submit();
		}
			
		function validaSubmit() {
		    if(!validaCampoObrigatorio(document.frmMain.codigoCedente, "Cedente")) {
				  return false;
		    }
			if (document.frmMain.rdo[0].checked == true) {
			   	if(!validaCampoObrigatorio(document.frmMain.nossoNumero, "Nosso Número")) {
				  	return false;
			   	}
		  	}
		  	return true;
		}
		function validaClassificadoPor(){
                       
            var situacaoCombo = document.frmMain.situacao;
            var classificacaoCombo = document.frmMain.classificacao;
            
            var situacaoValor = situacaoCombo.getAttribute('value');
            var classificacaoValor = classificacaoCombo.getAttribute('value');
           
             
            //DATA DE LIQUIDACAO
            if(classificacaoValor == "4"){
            	//02LIQUIDADO PV - 03LIQUIDADO CARTORIO
                if (situacaoValor == "2" || situacaoValor == "3"){
                    return true;
                }
                else{
                    return false;
                }
            }
         
           //DATA DE ULTIMO COMANDO
            else if(classificacaoValor == '5'){
                //01EM ABERTO
                if(situacaoValor == '1'){
                    return true;
                }
                else{
                    return false;
                }
            }
            return true;
        }		
    </script>
  </s:FormStrategy>
</p:Document></html>
