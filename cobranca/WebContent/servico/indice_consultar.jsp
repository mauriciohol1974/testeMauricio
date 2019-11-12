<%
/***********************************************
*Politec - Filial S�o Paulo
*Fabrica de Projetos - Outubro de 2004
*Projeto CAIXA - SIGCB
*Componente: sacado_incluir.jsp - Java Server Pages
*Autor: Eduardo A. Mor�s - emoras@sao.politec.com.br
*Ultima Atualiza��o: 07/10/2004
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
	<s:FormStrategy name="frmMain" action="SigcbControle"	estrategia="<%=IndiceEstrategia.STRATEGY_PERIODO_INICIAR%>" fluxo="normal">
		<s:Menu/>
		<s:Titulo name="<%=IndiceEstrategia.PAGE_TITLE_CONSULTAR%>"/>

 		<input type="hidden" name="sigla" value="<%=indiceBean.getSigla() %> " />
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
		                      <td class="textoTitulo" width="10%">Sigla: </td>
		                      <td class="textoValor" width="26%"> <%=indiceBean.getSigla()%></td>
		                     </tr>
		                     <tr>
		                      <td nowrap class="textoTitulo" width="17%">N�mero: </td>
						      <td width="10%" class="textoValor"><%=indiceBean.getNuIndice().equals(new Long(0))?"":indiceBean.getNuIndice().toString()%></td>
		                     </tr>
		                     <tr>
		                      <td class="textoTitulo" width="17%">Nome �ndice Econ�mico:</td>
		                      <td class="textoValor" colspan="3"> <%=indiceBean.getNoIndice()%></td>
		                     </tr>
		                     <tr>
							  <td nowrap class="textoTitulo" width="17%">Nome Unidade �ndice: </td>
						      <td width="10%" class="textoValor"><%=indiceBean.getNoUnidade()%></td>
							</tr>
							<tr>
		                      <td nowrap class="textoTitulo" width="17%">C�digo de Periodicidade: </td>
						      <td width="10%" class="textoValor"><%=indiceBean.getCoPrdce()%></td>
		                    </tr>
		                    <tr>
		                      <td nowrap class="textoTitulo" width="17%">Indicador de situa��o: </td>
						      <td width="10%" class="textoValor"><%=indiceBean.getIcStco().equals("I")?"INATIVO":"ATIVO"%>
						      </td>
		                    </tr>
		                    <tr>
		                      <td nowrap class="textoTitulo" width="17%">Usu�rio Inclus�o: </td>
						      <td width="10%" class="textoValor"><%=indiceBean.getCoUserInc()%>
						      </td>
		                    </tr>
		                    <tr>
		                      <td nowrap class="textoTitulo" width="17%">Data/Hora Inclus�o: </td>
						      <td width="10%" class="textoValor"><%=indiceBean.getTsInc()%>
						      </td>
		                    </tr>	
		                    <tr>
		                      <td nowrap class="textoTitulo" width="17%">Usu�rio Altera��o: </td>
						      <td width="10%" class="textoValor"><%=indiceBean.getCoUserAlt()%>
						      </td>
		                    </tr>
		                    <tr>
		                      <td nowrap class="textoTitulo" width="17%">Data/Hora Altera��o: </td>
						      <td width="10%" class="textoValor"><%=indiceBean.getTsAlt()%>
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
                 	<s:Button name="Atualizar Valores" action="javascript: formSubmit();"/>
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
			
			function formPeriodo() {
				document.frmMain.estrategia.value="servico.ServIndicePeriodoListar";
		        document.frmMain.submit();
		        
			}

    </script>
  </s:FormStrategy>
</p:Document>
</html>