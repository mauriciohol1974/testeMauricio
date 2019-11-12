<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Junho de 2004
*Projeto CAIXA - SIGCB
*Componente: pvcob_alterar.jsp - Java Server Pages
*Autor: JE 
*Ultima Atualização: 13/10/2004 16:07
************************************************/
%>
<script language="javascript">
  history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.PvCobradorBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.parametro.PvCobEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.com.politec.sao.util.Formatacao"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%
  PvCobradorBean pvCobBean = (session.getAttribute(PvCobEstrategia.DATA_BEAN)==null?new PvCobradorBean():(PvCobradorBean)session.getAttribute(PvCobEstrategia.DATA_BEAN));
  int numeroFaixas = 20; 
  int faixasExibir = 0;
%>

<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle"
    estrategia="<%=PvCobEstrategia.STRATEGY_ALTERAR_FINALIZAR%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name="Manter PV Cobrador >> Alterar"/>
    <!--DADOS PARA TELA DE SUCESSO ou ERRO -->
    <input type="hidden" name = "codigoUnidadePV" value="<%=pvCobBean.getCodigoUnidadePV()%>">    
    <input type="hidden" name = "nomeUnidadePV" value="<%=pvCobBean.getNomeUnidadePV()%>">    
    <input type="hidden" name = "emailUnidadePV" value="<%=pvCobBean.getEmailUnidadePV()%>">
    <input type="hidden" name = "endereco" value="<%=pvCobBean.getEndereco()%>">
    <input type="hidden" name = "codigoUnidadeCentral" value="<%=pvCobBean.getCodigoUnidadeCentral()%>">
    <input type="hidden" name = "nomeUnidadeCentral" value="<%=pvCobBean.getNomeUnidadeCentral()%>">    
    <input type="hidden" name = "emailUnidadeCentral" value="<%=pvCobBean.getEmailUnidadeCentral()%>">
    <input type="hidden" name = "enderecoCentral" value="<%=pvCobBean.getEnderecoCentral()%>">
    <!--DADOS PARA RECUPERAR FILTRO PARA LISTA -->
    <input type="hidden" name = "codUnidPVInicial" value="<%=pvCobBean.getCodUnidPVInicial()%>">
    <input type="hidden" name = "codUnidPVFinal" value="<%=pvCobBean.getCodUnidPVFinal()%>">
    <input type="hidden" name = "numeroCEPde" value="<%=pvCobBean.getNumeroCEPde()%>">
    <input type="hidden" name = "numeroCEPate" value="<%=pvCobBean.getNumeroCEPate()%>">
    <input type="hidden" name = "acao" value="<%=pvCobBean.getAcao()%>">
    <input type="hidden" name = "automacaoCartoraria" value="<%=pvCobBean.getAutomacaoCartoraria()%>">
    <input type="hidden" name = "padraoCNAB" value="<%=pvCobBean.getPadraoCNAB()%>">	
    <input type="hidden" name = "apelido" value="<%=pvCobBean.getApelido()%>">		
    <input type="hidden" name = "centralizadora" value="<%=pvCobBean.getCodigoUnidadeCentralFormatado()%>">		

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="1" cellpadding="0" height=53 align="center">
            <tr>
              <td class="textoTitulo" width="17%">Unidade PV: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getCodigoUnidadePVFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Unidade: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getNomeUnidadePV()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Endereço: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getEndereco()%></td>
              <td class="textoTitulo" width="17%">e-mail:</td>
              <td class="textoValor" width="26%"><%=pvCobBean.getEmailUnidadePV()%></td>
            </tr>
            
            <tr>
              <td class="textoTitulo" width="17%">Unidade Centralizadora: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getCodigoUnidadeCentralFormatado()%></td>
              <td class="textoTitulo" width="17%">Nome Unidade Centralizadora: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getNomeUnidadeCentral()%></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Endereço: </td>
              <td class="textoValor" width="26%"><%=pvCobBean.getEnderecoCentral()%></td>
              <td class="textoTitulo" width="17%">e-mail:</td>
              <td class="textoValor" width="26%"><%=pvCobBean.getEmailUnidadeCentral()%></td>
            </tr>

            <tr>
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td colspan="4" class="textoTitulo">Alterar PV Cobrador:
                <hr>
              </td>
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
                                <TABLE width="100%" >
                                  <TR>
                                    <td class="textoTitulo" nowrap width="30%">Faixa de CEP <%=i+1%> </td>
                                    <td class="textoTitulo" width="5%">de: </td>
                                    <td class="textoValor" nowrap width="20%">
                                      <p:InputCep name='<%="numeroCEPde"+i%>' 
                                      value='<%=((Long)pvCobBean.getPropertyValue("numeroCEPde"+i)).longValue() !=0 ? Formatacao.formataCep((Long)pvCobBean.getPropertyValue("numeroCEPde"+i)):""%>' CLASS="inputtext"
                                      onFocus="javascript: prevFocus(this);"
                                      onKeyUp='<%="javascript: nextFocus(event.keyCode, this, document.frmMain.numeroCEPate" + i + ");"%>'/>
                                    </td>
                                    <td class="textoTitulo" width="5%">até: </td>
                                    <td class="textoValor" nowrap width="20%"> 
                                      <p:InputCep name='<%="numeroCEPate"+i%>' 
                                      value='<%=((Long)pvCobBean.getPropertyValue("numeroCEPate"+i)).longValue() !=0 ? Formatacao.formataCep((Long)pvCobBean.getPropertyValue("numeroCEPate"+i)):""%>' CLASS="inputtext"
                                      onFocus="javascript: prevFocus(this);"
                                      onKeyUp='<%="javascript: nextFocus2(event.keyCode, this," + (i+1) + ");"%>'/>
                                    </td>
                                    <td width="20%">&nbsp;</td>
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
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 align="center">
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
                        <table width="95%" border="0" cellspacing="3" cellpadding="0" align="center">
                          <tr>
                            <td class="textoTitulo" width="24%">VAN: </td>
                            <td width="26%" colspan="2" class="textoValor">
                      	      <s:ComboVan name="codigoVAN" disabled="true" />                            
                            </td>
                            <td class="textoTitulo" nowrap width="24%">Automação Cartorária: </td>
                            <td width="26%" colspan="2" nowrap class="textoValor">
                        		<s:ComboSimNao name='automacaoCartorariaT' selectedValue='<%=pvCobBean.getAutomacaoCartoraria()%>'
                 						onChange='javascript:validaArquivoPadrao(this.value);'/>
                            </td>
                          </tr>
                          <tr>
                            <td class="textoTitulo" width="24%">Apelido VAN:</td>
                            <td width="26%" colspan="2" nowrap class="textoValor">
                              <p:InputAlfanumerico name="apelidoT" maxlength="6" size="8"
                              value='<%=pvCobBean.getApelido()%>' CLASS="inputtext"
                              onFocus="javascript: prevFocus(this);"
							  disabled='<%=pvCobBean.getAutomacaoCartoraria().equals("N") ?  "true" : "false"%>'
                              onKeyUp="javascript: nextFocus(event.keyCode, this, document.frmMain.Confirmar);"/>
                            </td>
                            <td class="textoTitulo" width="24%">Arquivo Padrão: </td>
                            <td width="26%" colspan="2" nowrap class="textoValor">
                              <s:ComboCNAB name="padraoCNABCombo" branco="true" brancoValue="0" selectedValue='<%=pvCobBean.getPadraoCNAB()== null?"0":pvCobBean.getPadraoCNAB().toString()%>'/>                              
                            </td>
                          </tr>
                          <tr>
                            <td class="textoTitulo" width="24%">Número Última Remessa: </td>
                            <td class="textoValor" nowrap width="13%"><%=((pvCobBean.getNumeroUltimaRemessa().longValue()==0) ?  "": pvCobBean.getNumeroUltimaRemessa().toString())%></td>
                            <td class="textoValor" nowrap width="13%">&nbsp;</td>
                            <td class="textoTitulo" width="24%">Quantidade de Registros: </td>
                            <td class="textoValor" nowrap width="13%"><%=((pvCobBean.getQntdRegistrosUltRemessa().longValue()==0) ?  "": pvCobBean.getQntdRegistrosUltRemessa().toString())%></td>
                            <td class="textoValor" nowrap width="13%">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="textoTitulo" width="24%">Data Última Remessa: </td>
                            <td width="13%" nowrap class="textoValor"><%=pvCobBean.getDataUltimaRemessa()==null || Formatador.formatarData(pvCobBean.getDataUltimaRemessa()).equals("01/01/0001")? "" : Formatador.formatarData(pvCobBean.getDataUltimaRemessa())%></td>
                            <td width="13%" nowrap class="textoValor">&nbsp;</td>
                            <td class="textoTitulo" width="24%">Inclusão na Automação: </td>
                            <td width="13%" nowrap class="textoValor"><%=pvCobBean.getDataInclusaoAutomacao()==null || Formatador.formatarData(pvCobBean.getDataInclusaoAutomacao()).equals("01/01/0001")? "" : Formatador.formatarData(pvCobBean.getDataInclusaoAutomacao())%></td>
                            <td width="13%" nowrap class="textoValor">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="textoTitulo" width="24%">Usuário Responsável: </td>
                            <td width="26%" colspan="2" nowrap class="textoValor"><%=pvCobBean.getUsuario()%></td>
                            <td class="textoTitulo" width="24%">Data Última Alteração: </td>
                            <td width="13%" nowrap class="textoValor"><%=pvCobBean.getDataUltimaAlteracao()==null || Formatador.formatarData(pvCobBean.getDataUltimaAlteracao()).equals("01/01/0001") ? "" : Formatador.formatarData(pvCobBean.getDataUltimaAlteracao())%></td>
                            <td width="13%" nowrap class="textoValor">&nbsp;</td>
                          </tr>

                          <tr>
                            <td class="textoTitulo" width="24%">Situação: </td>
                            <td width="26%" colspan="2" nowrap class="textoValor">
                              <select name="situacao" <%=pvCobBean.getSituacao().equals("A") ?  "disabled" : ""%>>
                                <option value="A" <%=pvCobBean.getSituacao().equals("A") ?  "selected" : ""%>>ATIVA
                                <option value="I" <%=pvCobBean.getSituacao().equals("I") ?  "selected" : ""%>>INATIVA
                              </select>
                            </td>
                            <td class="textoTitulo" width="24%">Centralizadora</td>
                            <td width="26%" colspan="2" nowrap class="textoValor"><%=pvCobBean.getCodigoUnidadeCentralFormatado() %></td>
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
              <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
            
              <td align="right" colspan="4">
                <p align="center">
                  <s:Button name="Confirmar" action="javascript:formSubmit_Alterar()"/>
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
    <script language="javascript">
		  function inicia(){
      	validaArquivoPadrao('<%=pvCobBean.getAutomacaoCartoraria()%>');
		  }
		  function formSubmit_Alterar() {
			if (validaSubmit()) {
			  if (confirm(conf("101", "PV Cobrador"))) {
				var j = document.frmMain.selectNumeroFaixas.value;
				for (var i=0; i<20; i++) {
				  faixaD = eval('document.frmMain.numeroCEPde' +  i);
				  faixaA = eval('document.frmMain.numeroCEPate' +  i);
				  unFormataCep(faixaD);
				  unFormataCep(faixaA);
				  document.frmMain.automacaoCartoraria.value = document.frmMain.automacaoCartorariaT.value;
				  document.frmMain.padraoCNAB.value = document.frmMain.padraoCNABCombo.value;
				  document.frmMain.apelido.value = document.frmMain.apelidoT.value;
				}           
				document.frmMain.submit();
			  }
			}
		  }
		  function formSubmit_Voltar() {
			if (confirm(conf("103"))) {
			   document.frmMain.estrategia.value = "<%=PvCobEstrategia.STRATEGY_MANTER_LISTAR%>";
			   document.frmMain.fluxo.value = "voltar";
			   document.frmMain.submit();
			}
		  }
		
		  function validaSubmit(){
			if (document.frmMain.situacao.value == "I"){
				msg('035','');
				return false;
			}
			if (! faixasOk()) return false;
			if(document.frmMain.automacaoCartorariaT.value == "S"){
			  if(!validaCampoObrigatorio(document.frmMain.apelidoT,'Apelido VAN')) return false;
			  if(!validaComboObrigatorio(document.frmMain.padraoCNABCombo,'Arquivo padrão',"0")) return false;
			  return true;
			} else {
			  return true;
			}
			return true;
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
	
      function validaArquivoPadrao(valor){
        if(valor == "N"){
          document.frmMain.padraoCNABCombo.value = "0";
          document.frmMain.padraoCNABCombo.disabled=true;
          document.frmMain.apelidoT.value="";
          document.frmMain.apelidoT.disabled=true;
          return true;
        }
        else{
          document.frmMain.padraoCNABCombo.disabled=true;
          document.frmMain.padraoCNABCombo.value="2"; //CNAB600
          document.frmMain.apelidoT.disabled=false;
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