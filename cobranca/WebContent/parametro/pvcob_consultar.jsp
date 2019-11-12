<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2005
*Projeto CAIXA - SIGCB
*Componente: pvcob_alterar.jsp - Java Server Pages
*Autor: Eduardo Morás 
*Ultima Atualização: 13/10/2005 
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
<%@page import="br.gov.caixa.sigcb.bean.InformacoesUsuarioBean"%>
<%
	InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) session.getAttribute("usuarioLdap");
  PvCobradorBean pvCobBean = (session.getAttribute(PvCobEstrategia.DATA_BEAN)==null?new PvCobradorBean():(PvCobradorBean)session.getAttribute(PvCobEstrategia.DATA_BEAN));
  int numeroFaixas = 20; 
  int faixasExibir = 0;
%>

<html>
<s:Header/>

<p:Document>
  <s:FormStrategy name="frmMain" action="SigcbControle"
    estrategia="<%=PvCobEstrategia.STRATEGY_ALTERAR%>" fluxo="normal">
    <s:Menu/>
    <s:Titulo name='<%=PvCobEstrategia.PAGE_TITLE_CONSULTAR%>'/>
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

		<input type="hidden" name = "situacao" value="<%=pvCobBean.getSituacao()%>">

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
                                    <td class="textoValor" nowrap width="20%"><%=((Long)pvCobBean.getPropertyValue("numeroCEPde"+i)).longValue() !=0 ? Formatacao.formataCep((Long)pvCobBean.getPropertyValue("numeroCEPde"+i)):""%></td>
                                    <td class="textoTitulo" width="5%">até: </td>
                                    <td class="textoValor" nowrap width="20%"><%=((Long)pvCobBean.getPropertyValue("numeroCEPate"+i)).longValue() !=0 ? Formatacao.formataCep((Long)pvCobBean.getPropertyValue("numeroCEPate"+i)):""%></td>
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
                            <td colspan="2" class="textoValor" width="25%"><%=faixasExibir%></td>
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
                            <td width="26%" colspan="2" class="textoValor"><%=pvCobBean.getCodigoVANTexto()%></td>
                            <td class="textoTitulo" nowrap width="24%">Automação Cartorária: </td>
                            <td width="26%" colspan="2" nowrap class="textoValor"><%=pvCobBean.getAutomacaoCartoraria().equals("S")?"SIM":"NAO"%></td>
                          </tr>
                          <tr>
                            <td class="textoTitulo" width="24%">Apelido VAN:</td>
                            <td width="26%" colspan="2" nowrap class="textoValor"><%=pvCobBean.getApelido()%></td>
                            <td class="textoTitulo" width="24%">Arquivo Padrão: </td>
                            <td width="26%" colspan="2" nowrap class="textoValor"><%=pvCobBean.getPadraoCNABTexto()%></td>
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
                            <td width="26%" colspan="2" nowrap class="textoValor"><%=pvCobBean.getSituacao().equals("A") ?  "ATIVA" : "INATIVA"%></td>
                            <td class="textoTitulo" width="24%"></td>
                            <td width="26%" colspan="2" nowrap class="textoValor"></td>
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
                	<s:Button name="Alterar" action="javascript: formSubmit_Alterar();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="parametro.pvcobrador.manter.alterar"/>
                	<s:Button name="Excluir" action="javascript: formSubmit_Excluir();" userGroup="<%=usuarioBean.getNomeGrupo()%>" internalAction="parametro.pvcobrador.manter.excluir" />
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
		  }

			function formSubmit_Alterar() {
        document.frmMain.submit();
			}

			function formSubmit_Excluir() {
	    	if (document.frmMain.situacao.value !="A") {
	    		msg('026','');
	    		return false;
	    	}
    		if (confirm(conf("102", "PV Cobrador"))) {
					document.frmMain.estrategia.value = "<%=PvCobEstrategia.STRATEGY_EXCLUIR%>";
          document.frmMain.submit();
	     	}
			}			
			
		  function formSubmit_Voltar() {
			   document.frmMain.estrategia.value = "<%=PvCobEstrategia.STRATEGY_MANTER_LISTAR%>";
			   document.frmMain.fluxo.value = "voltar";
			   document.frmMain.submit();
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
		atualizarFaixas(<%=faixasExibir>0? faixasExibir: 3%>);
    </script>    
  </s:FormStrategy>
</p:Document>
</html>