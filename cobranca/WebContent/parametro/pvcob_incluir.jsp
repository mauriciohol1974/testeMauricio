<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Setembro de 2004
*Projeto CAIXA - SIGCB
*Componente: pvcob_incluir.jsp - Java Server Pages
*Autor: JE
*Ultima Atualização: 13/10/2004 16:08
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.com.politec.sao.util.Formatacao"%>
<%@page import="br.gov.caixa.sigcb.bean.PvCobradorBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.PvCobEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%
  PvCobradorBean pvCobBean = (session.getAttribute(PvCobEstrategia.DATA_BEAN)==null?new PvCobradorBean():(PvCobradorBean)session.getAttribute(PvCobEstrategia.DATA_BEAN));
  int numeroFaixas = 20; 
  int faixasExibir = 0;
  
%>


<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle" 
    estrategia="<%=PvCobEstrategia.STRATEGY_INCLUIR_FINALIZAR%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="Incluir PV Cobrador"/>
    
    <input type="hidden" name = "codigoUnidadePV" value="<%=pvCobBean.getCodigoUnidadePV()%>">
    <input type="hidden" name = "nomeUnidadePV" value="<%=pvCobBean.getNomeUnidadePV()%>">
    <input type="hidden" name = "emailUnidadePV" value="<%=pvCobBean.getEmailUnidadePV()%>">
    <input type="hidden" name = "endereco" value="<%=pvCobBean.getEndereco()%>">
    
    <input type="hidden" name = "codigoUnidadeCentral" value="<%=pvCobBean.getCodigoUnidadeCentral()%>">
    <input type="hidden" name = "nomeUnidadeCentral" value="<%=pvCobBean.getNomeUnidadeCentral()%>">
    <input type="hidden" name = "emailUnidadeCentral" value="<%=pvCobBean.getEmailUnidadeCentral()%>">
    <input type="hidden" name = "enderecoCentral" value="<%=pvCobBean.getEnderecoCentral()%>">
    <input type="hidden" name = "padraoCNAB">    

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 valign="middle" align="center">
            <tr>
              <td class="textoTitulo" width="24%">Unidade PV: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getCodigoUnidadePVFormatado()%></td>
              <td class="textoTitulo" width="24%">Nome Unidade: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getNomeUnidadePV()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="24%">Endereço: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getEndereco()%></td>
              <td class="textoTitulo" width="24%">e-mail: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getEmailUnidadePV()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="24%">Unidade Centralizadora: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getCodigoUnidadeCentralFormatado()%></td>
              <td class="textoTitulo" width="24%">Nome Unidade Centralizadora: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getNomeUnidadeCentral()%></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="24%">Endereço: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getEnderecoCentral()%></td>
              <td class="textoTitulo" width="24%">e-mail: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getEmailUnidadeCentral()%></td>
            </tr>
            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top"> 
              <td colspan="4" class="textoTitulo">PV Cobrador:<hr></td>
            </tr>
            <tr>
              <td colspan="4">
                <s:Outline name="CEP" title="Faixas de CEP" classTitle="textoTitulo" imagePath="<%=Paths.getImagePath()%>" type="outline">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr> 
                      <td colspan="4" class="textoDestaqueTitulo">Faixas de CEP</td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="4">
                        <table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
                          <% for (int i = 0 ; i < numeroFaixas; i++) {%>
                          <tr>
                            <TD colspan="6">
                              <div id='Faixa<%=i%>' style='display:none;background-color: #E9F2F9;'>
                                <TABLE width="100%" border="0" cellspacing="3" cellpadding="0"  align="center">
                                  <TR>
                                    <td class="textoTitulo" width="30%">Faixa de CEP <%=i+1%>&nbsp;</td>
                                    <td class="textoTitulo" width="5%">de:&nbsp;</td>
                                    <td class="textoValor" nowrap width="20%">
                                      <p:InputCep name='<%="numeroCEPde"+i%>' 
                                      value='<%=((Long)pvCobBean.getPropertyValue("numeroCEPde"+i)).longValue() !=0 ? Formatacao.formataCep((Long)pvCobBean.getPropertyValue("numeroCEPde"+i)):""%>' CLASS="inputtext"
                                      onFocus="javascript: prevFocus(this);"
                                      onKeyUp='<%="javascript: nextFocus(event.keyCode, this, document.frmMain.numeroCEPate" + i + ");"%>'/>
                                    </td>
                                    <td class="textoTitulo" width="5%">até:&nbsp;</td>
                                    <td class="textoValor" nowrap width="20%"> 
                                      <p:InputCep name='<%="numeroCEPate"+i%>' 
                                      value='<%=((Long)pvCobBean.getPropertyValue("numeroCEPate"+i)).longValue() !=0 ? Formatacao.formataCep((Long)pvCobBean.getPropertyValue("numeroCEPate"+i)):""%>' CLASS="inputtext"
                                      onFocus="javascript: prevFocus(this);"
                                      onKeyUp='<%="javascript: nextFocus2(event.keyCode, this," + (i+1) + ");"%>'/>
                                    </td>
                                    <td class "textoTitulo" width="20%">&nbsp;</td>
                                  </TR>                               
                            </TABLE>
                            </DIV>
                          </TD>
                        </TR>
                          <% 
                          if (((Long)pvCobBean.getPropertyValue("numeroCEPde"+i)).longValue() != 0) {faixasExibir++;};
                          } %>
                          <tr>
                            <td nowrap class="textoTitulo" width="30%">No. de Faixas de CEP:</td>
                            <td colspan="2" class="textoValor" width="25%">
                              <select name="selectNumeroFaixas">
                              <% for (int i = 0 ; i < numeroFaixas; i++) {%>
                                <option value="<%=i+1%>" <%=(i==(faixasExibir>0? faixasExibir-1: 2)? "selected": "") %>><%=i+1%>
                              <% } %>
                              </select>&nbsp;
                              <input type="button" class="button" name="Mostrar" value="Mostrar" onclick="javascript:atualizarFaixas(document.frmMain.selectNumeroFaixas.value);">
                            </td>
                            <td colspan="3" class="textoTitulo" width="45%">&nbsp;</td>
                          </tr>
                          <tr> 
                            <td colspan="6">&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                </table>
                </s:Outline>
              </td>
            </tr>
            <tr>
              <td colspan="4">
                <s:Outline name="Complementar" title="Dados Complementares" classTitle="textoTitulo" imagePath="<%=Paths.getImagePath()%>" type="outline">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr> 
                      <td colspan="4" class="textoDestaqueTitulo">Dados Complementares</td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="4">
                        <table width="95%" border="0" cellspacing="3" cellpadding="0" align="center" valign="middle">
                          <tr>
                            <td class="textoTitulo" width="24%">VAN: </td>
                            <td class="textoValor" width="26%">
                      	      <s:ComboVan name="codigoVAN" disabled="true" />                            
                            </td>
                            <td class="textoTitulo" width="24%">Automação Cartorária:</td>
                            <td class="textoValor" nowrap width="26%"> 
                      	      <s:ComboSimNao name="automacaoCartoraria" onChange="javascript:validaArquivoPadrao(this.value);" />
                            </td>
                          </tr>
                          <tr>
                            <td class="textoTitulo" width="24%"> Apelido VAN: </td>
                            <td class="textoValor" nowrap width="26%"> 
                              <p:InputAlfanumerico name="apelido" maxlength="6" size="8" 
                              value='<%=pvCobBean.getApelido()%>' CLASS="inputtext"
                              onFocus="javascript: prevFocus(this);"
                              onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>
                            </td>
                            <td class="textoTitulo" width="24%">Arquivo Padrão: </td>
                            <td class="textoValor" nowrap width="26%"> 
                              <s:ComboCNAB name="padraoCNABCombo" branco="true" brancoValue="0" selectedValue='<%=pvCobBean.getPadraoCNAB()== null?"0":pvCobBean.getPadraoCNAB().toString()%>'/>
                            </td>
                          </tr>
                          <tr>
                            <td class="textoTitulo" width="24%">Situação: </td>
                            <td class="textoValor" nowrap width="26%">
                              <select name="situacao" disabled>
                                <option selected value="A" >ATIVA
                                <option value="I"> INATIVA
                              </select>
                            </td>
                            <td class="textoTitulo" width="24%"></td>
                            <td class="textoValor" nowrap width="26%"></td>
                          </tr>
                          <tr> 
                            <td colspan="4">&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                </table>
                </s:Outline>
              </td>
            </tr>
            <tr> 
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" colspan="4">
                  <p align="center"> 
                  <s:Button name="Confirmar" action="javascript:formSubmit()" userGroup="" internalAction=""/>
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
      function inicia() {
      	validaArquivoPadrao('<%=pvCobBean.getAutomacaoCartoraria()%>')
      
      }
      function formSubmit() {
        if (validaSubmit()) {
          if (confirm(conf("100", "PV Cobrador"))) {
            var j = document.frmMain.selectNumeroFaixas.value;
            for (var i=0; i<j; i++) {
              faixaD = eval('document.frmMain.numeroCEPde' +  i);
              faixaA = eval('document.frmMain.numeroCEPate' +  i);
              unFormataCep(faixaD);
              unFormataCep(faixaA);
            }          
	          document.frmMain.padraoCNAB.value = document.frmMain.padraoCNABCombo.value           
            document.frmMain.submit();
          }
        }
      }

	function faixasOk() {
		var j = document.frmMain.selectNumeroFaixas.value;
		var faixaD, faixaA;
         for (var i=0; i<j; i++) {
          faixaD = eval('document.frmMain.numeroCEPde' +  i);
          faixaA = eval('document.frmMain.numeroCEPate' +  i);
          if(!validaCampoObrigatorio(faixaD,'Faixa de CEP De ' + (i+1))) return false;
          if(!validaCEPMaiorIgual(faixaD, 'Faixa de CEP De ' + (i+1), 0)) return false;
          if(!validaCampoObrigatorio(faixaA,'Faixa de CEP Ate ' + (i+1))) return false;
          if(!validaCEPMaiorIgual(faixaA, 'Faixa de CEP Ate ' + (i+1), 0)) return false;
          if(!validaCEPMaior(faixaA, 'Faixa de CEP Ate ' + (i+1), faixaD.value)) return false;
		}
        return true;
    }

		function atualizarFaixas(j) {
			for (var i=0; i<<%=numeroFaixas%>; i++) {
				whichEl = eval('Faixa' + i );
				
				if (i<j) {
					whichEl = eval('Faixa' + i );
					whichEl.style.display = 'block';
				}	else {
					numeroCEPde = eval('document.frmMain.numeroCEPde' + i);
					numeroCEPde = "";
					numeroCEPate = eval('document.frmMain.numeroCEPate' + i);
					numeroCEPate = "";
					whichEl = eval('Faixa' + i );
					whichEl.style.display = 'none';
				}
			}
		}
	  
      function validaSubmit() {
        if (! faixasOk()) return false;
        if(document.frmMain.automacaoCartoraria.value == "S"){
          if(!validaCampoObrigatorio(document.frmMain.apelido,'Apelido VAN')) return false;
          if(!validaComboObrigatorio(document.frmMain.padraoCNABCombo,'Arquivo padrão',"0")) return false;
          return true;
        } else {
          return true;
        }
        return true;
      }
      
      function formSubmit_Voltar() {
        if (confirm(conf("103"))) {
           document.frmMain.estrategia.value = "<%=PvCobEstrategia.STRATEGY_INCLUIR_FILTRO%>";
           document.frmMain.fluxo.value = "voltar";
           document.frmMain.submit();
        }
      }  
	  
      function validaArquivoPadrao(valor){
        if(valor == "N"){
          document.frmMain.padraoCNABCombo.value = 0;
          document.frmMain.padraoCNABCombo.disabled=true;
          document.frmMain.apelido.value="";
          document.frmMain.apelido.disabled=true;
          return true;
        }
        else{
          document.frmMain.padraoCNABCombo.disabled=true;
          document.frmMain.padraoCNABCombo.value="2"; //CNAB600
          document.frmMain.apelido.disabled=false;
          document.frmMain.apelido.value="";
          return true;
        }
      }
       
      function nextFocus2(key, fieldFrom, i) {
        whichEl = eval('Faixa' + i );
        if (whichEl.style.display != 'none') {
          numeroCEPde = eval('document.frmMain.numeroCEPde' + i);
          nextFocus(key, fieldFrom, numeroCEPde);
        }else{
          nextFocus(key, fieldFrom, document.frmMain.selectNumeroFaixas);
        }
      }
      
      atualizarFaixas(<%=faixasExibir>0? faixasExibir: 3%>);         
      
    </script>
  </s:FormStrategy>
</p:Document>
</html>