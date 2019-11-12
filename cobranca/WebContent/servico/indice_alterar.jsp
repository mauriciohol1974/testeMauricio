<%
/***********************************************
*Politec - Filial São Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: sacado_incluir.jsp - Java Server Pages
*Autor: Eduardo A. Morás - emoras@sao.politec.com.br
*Ultima Atualização: 07/10/2004
************************************************/
%>
<script language="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.estrategia.servico.IndiceEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.bean.IndiceBean"%>


<%
	
	IndiceBean indiceBean = (session.getAttribute(IndiceEstrategia.DATA_BEAN)==null?new IndiceBean():(IndiceBean)session.getAttribute(IndiceEstrategia.DATA_BEAN));
%>

<html>
<s:Header/>

<p:Document>
	<s:FormStrategy name="frmMain" action="SigcbControle"	estrategia="<%=IndiceEstrategia.STRATEGY_ATUALIZAR_FINALIZAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=IndiceEstrategia.PAGE_TITLE_ALTERAR%>"/>

 		
    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="95%" height="14" align="left">
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

            <tr valign="top">
                <hr>
              </td>
            </tr>

			<tr>
              	<td colspan="4">
                	<table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
	                    <tr>
	                      <td colspan="4">&nbsp;</td>
	                    </tr>
		                    <tr>
		                      <td class="textoTitulo" width="15%">&nbsp; </td>
		                      <td class="textoTitulo" width="17%">Sigla: </td>
		                      <td class="textoValor" width="26%"> <input type="text" name="sigla" maxlength="15" size="20" CLASS="inputtext" value='<%=indiceBean.getSigla()%>' readonly/></td>
		                     </tr>
		                     <tr>
		                      <td class="textoTitulo" width="15%">&nbsp; </td>
		                      <td nowrap class="textoTitulo" width="17%">Número: </td>
						      <td width="26%" nowrap><input type="text" CLASS="inputtext" name="nuIndice" value='<%=indiceBean.getNuIndice().equals(new Long(0))?"":indiceBean.getNuIndice().toString()%>' size="18" maxlength="13" readonly/> </td>
		                     </tr>
		                     <tr>
		                      <td class="textoTitulo" width="15%">&nbsp; </td>
		                      <td class="textoTitulo" width="17%">Nome Índice Econômico:</td>
		                      <td class="textoValor" colspan="3"> <input type="text"  name="noIndice" maxlength="100" size="110" CLASS="inputtext" value='<%=indiceBean.getNoIndice()%>'readonly/> </td>
		                     </tr>
		                     <tr>
		                      <td class="textoTitulo" width="15%">&nbsp; </td>
							  <td nowrap class="textoTitulo" width="17%">Nome Unidade Índice: </td>
						      <td width="26%" nowrap><input type="text" name="noUnidade" maxlength="15" size="20" CLASS="inputtext" value='<%=indiceBean.getNoUnidade()%>' readonly/> </td>
							</tr>
							<tr>
							  <td class="textoTitulo" width="15%">&nbsp; </td>
		                      <td nowrap class="textoTitulo" width="17%">Código de Periodicidade: </td>
						      <td width="26%" nowrap><input type="text" name="coPrdce" maxlength="5" size="7" CLASS="inputtext" value='<%=indiceBean.getCoPrdce()%>' readonly/> </td>
		                    </tr>
		                    <tr>
		                      <td class="textoTitulo" width="15%">&nbsp; </td>
		                      <td nowrap class="textoTitulo" width="17%">Indicador de situação: </td>
						      <td width="26%" nowrap>
									    <select name="icStco">
										  <option value="A" selected>ATIVO</option> 
										  <option value="I">INATIVO</option>
										</select>
						      </td>
		                    </tr>
		                    
                  	</table>
				</td>
            </tr>
            <tr>
	            <td colspan="4">&nbsp;</td>
            </tr>
            <tr>
	            <td align="right" colspan="4">
  	            <p align="center">
                 	<s:Button name="Voltar" action="javascript: formVoltar();"/>
                 	<s:Button name="Alterar" action="javascript: formSubmit();"/>
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
			
			function formSubmit() {
				
				        document.frmMain.submit();
				        
			}
			
			function formVoltar() {
				document.frmMain.estrategia.value="servico.ServIndiceManterIniciar";
				document.frmMain.fluxo.value = "voltar";
		        document.frmMain.submit();
		        
			}

    </script>
  </s:FormStrategy>
</p:Document>
</html>