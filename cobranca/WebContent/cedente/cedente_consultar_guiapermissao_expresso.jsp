<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteParametrosBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedConsultaPermissaoBean"%>
<%@page import="br.gov.caixa.sigcb.util.Util"%>

<%
CedConsultaPermissaoBean permissaoBean = (CedConsultaPermissaoBean) request.getAttribute(CedenteEstrategia.CEDENTE_PERMISSAO_BEAN);

String situINT = permissaoBean.getDE_STCO_INTERNA();
String dataINT = permissaoBean.getDT_STCO_INTERNA();
String horaINT = permissaoBean.getHH_STCO_INTERNA();
String usuarioINT = permissaoBean.getCO_USRO_INTERNA();
String descricaoINT = permissaoBean.getDE_HIST_INTERNA();

String situCIP = permissaoBean.getDE_STCO_CIP();
String dataCIP =  permissaoBean.getDT_STCO_CIP();
String horaCIP =  permissaoBean.getHH_STCO_CIP();
String usuarioCIP = permissaoBean.getCO_USRO_CIP();
String descricaoCIP = permissaoBean.getDE_HIST_CIP();

String situACATAR = permissaoBean.getDE_ACAT_CIP();
String dataACATAR = permissaoBean.getDT_ACAT_CIP();
String horaACATAR = permissaoBean.getHH_ACAT_CIP();


String situFINAL = permissaoBean.getDE_STCO_FINAL();
String dataFINAL = permissaoBean.getDT_STCO_FINAL();
String horaFINAL = permissaoBean.getHH_STCO_FINAL();
String usuarioFINAL = permissaoBean.getCO_USRO_FINAL();
String descricaoFINAL = permissaoBean.getDE_HIST_FINAL();

%>

					<div class="group">
						<table cellpadding="0" width="720" >
	                    <tr> 
	                      <td colspan="8" class="textoDestaqueTitulo">Guia: Permissão Final</td>
	                    </tr>
	                    <tr> 
	                      <td colspan="8">
	                      <table border="1">
	                      	<tr><td>
		                       	<table width="720">
			                      	<tr>
			                      		 <td class="textoDestaqueTitulo" colspan="5">
			                      		 Situação Interna
			                      		 </td>
			                      	</tr>
			                      	<tr>
			                      		 <td class="textoTitulo">
			                      		 Situação
			                      		 </td>
			                      		 <td class="textoTitulo">
			                      		 	<input type="text" id="situINT" size="12" value="<%=situINT %>"  CLASS="inputtext" readonly>
			                      		 </td>
			                      		 <td class="textoTitulo">
			                      		 	Data
			                      		 </td>
			                      		 <td class="textoTitulo">
			                      		 	<input type="text" id="dataInterna" size="12" value="<%=dataINT %>"  CLASS="inputtext" readonly>
			                      		 </td>
			                      		 <td class="textoTitulo" >
			                      		 	Hora
			                      		 </td>
			                      		 <td class="textoTitulo" >
			                      		 	<input type="text" id="horaInterna" size="08" value="<%=horaINT %>"  CLASS="inputtext" readonly>
			                      		 </td>
			                      		 <td class="textoTitulo" >
			                      		 	Usuário
			                      		 </td>
			                      		 <td class="textoTitulo">
			                      		 	<input type="text" id="usuarioInterna" size="08" value="<%=usuarioINT %>"  CLASS="inputtext" readonly>
			                      		 </td>
			                      	</tr>
									<tr >
			                      		 <td class="textoTitulo">
			                      		 Descrição
			                      		 </td>
			                      		 <td class="textoTitulo"  colspan="7">
			                      		 	<input type="text" readonly id="descr1Int" name="descr1Int" size="130" maxlength="100" value="<%=descricaoINT.substring(0, 100).trim()%>"  CLASS="inputtext">
			                      		 </td>
			                      	</tr>
			                      	<tr >
			                      		 <td class="textoTitulo" >
			                      		 	&nbsp;
			                      		 </td>
			                      		 <td class="textoTitulo" colspan="7">
			                      		 	<input type="text" readonly id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoINT.substring(100, 200).trim()%>"size="130"  CLASS="inputtext">
			                      		 </td>
			                      	<tr>
			                      	<tr >
			                      		 <td class="textoTitulo" >
			                      		 	&nbsp;
			                      		 </td>
			                      		 <td class="textoTitulo" colspan="7">
			                      		 	<input type="text" readonly id="descr3Int" name="descr3Int" maxlength="100" value="<%=descricaoINT.substring(200, 220).trim()%>"size="130"  CLASS="inputtext">
			                      		 </td>
			                      	<tr>
			                        <tr>
			                      		<td>&nbsp;</td>
			                      	</tr>
			            		</table>
			            		</td></tr>
		            		</table>
						</td>
						</tr>
					<tr> 
                      <td colspan="4">
                      	<table border="1">
                      		<tr>
                      		<td colspan="4">
                      	
	                       	<table  border="0" cellpadding="0" width="720" >
	                       		<tr >
		                      		 <td class="textoDestaqueTitulo" colspan="5">
		                      		 Situação CIP
		                      		 </td>
		                      	</tr>
		                      	<tr>
		                      		 <td class="textoTitulo" >
		                      		 Situação
		                      		 </td>
		                      		 <td class="textoTitulo">
		                      		 	<input type="text" id="situacaoCIP" size="12" value="<%=situCIP %>"  CLASS="inputtext" readonly>
		                      		 </td>
		                      		 <td class="textoTitulo" align="right" >
		                      		 	Data
		                      		 </td>
		                      		 <td class="textoTitulo" >
		                      		 	<input type="text" id="dataCIP" size="12" value="<%=dataCIP %>"   CLASS="inputtext" readonly>
		                      		 </td>
		                      		 <td class="textoTitulo" align="right"  >
		                      		 	Hora
		                      		 </td>
		                      		 <td class="textoTitulo" >
		                      		 	<input type="text" id="horaCIP" size="08" value="<%=horaCIP %>"  CLASS="inputtext" readonly>
		                      		 </td>
		                      	</tr>
		                      	<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 Descrição
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(0, 100).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                     		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(100, 200).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(200, 300).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(300, 400).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(400, 500).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(500, 600).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(600, 700).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(700, 800).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(800, 900).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
	                      		<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
		                      		 <td class="textoTitulo" >
		                      		 &nbsp;
		                      		 </td>
		                      		 <td class="textoTitulo" colspan="6">
		                      		 <input type="text" id="descr2Int" name="descr2Int" maxlength="100" value="<%=descricaoCIP.substring(900, 999).trim()%>"size="130"  CLASS="inputtext" readonly>
		                      		 </td>
	                      		</tr>
		                      	
	                      		<tr>
		                      		 <td class="textoTitulo" colspan="2">
		                      		 Acatar Situação CIP

		                      		 	<input type="text" id="situACATAR" size="12" value="<%=situACATAR %>"  CLASS="inputtext" readonly>
		                      		 </td>
		                      		 <td class="textoTitulo" >
		                      		 	Data
		                      		 	<input type="text" id="dataAcatar" size="12" value="<%=dataACATAR %>"  CLASS="inputtext" readonly>
		                      		 </td>
		                      		 <td class="textoTitulo">
		                      		 	Hora
		                      		 	<input type="text" id="horaAcatar" size="08" value="<%=horaACATAR %>"  CLASS="inputtext" readonly>
		                      		 </td>
		                      		 <td class="textoTitulo">
		                      		 	Usuário
		                      		 	<input type="text" id="usuarioAcatar" size="08" value="<%=usuarioCIP %>"  CLASS="inputtext" readonly>
		                      		 </td>
		                      	</tr>
		                      	<tr>
			                      		<td>&nbsp;</td>
			                      	</tr>
	                      	</table>
                      	</td>
                      	</tr>
                      	</table>
                      </td>
                    </tr>
                    <tr> 
                      <td colspan="4">
                      	<table border="1">
                      	<tr><td colspan="8">
                       	<table  border="0" cellpadding="0" width="720" >
                       		<tr >
	                      		 <td class="textoDestaqueTitulo" colspan="5">
	                      		 Situação Final
	                      		 </td>
	                      	</tr>
	                      		<tr >
	                      	
	                      		 <td class="textoTitulo" >
	                      		 Situação
	                      		 </td>
	                      		 <td class="textoTitulo">
	                      		 	<input type="text" id="situacaoFINAL" size="12" value="<%=situFINAL %>"  CLASS="inputtext" readonly>
	                      		 </td>
	                      		 <td class="textoTitulo" >
	                      		 	Data
	                      		 </td>
	                      		 <td class="textoTitulo" >
	                      		 	<input type="text" id="dataFINAL" size="12" value="<%=dataFINAL %>"  CLASS="inputtext" readonly>
	                      		 </td>
	                      		 <td class="textoTitulo" >
	                      		 	Hora
	                      		 </td>
	                      		 <td class="textoTitulo">
	                      		 	<input type="text" id="horaFINAL" size="08" value="<%=horaFINAL %>"  CLASS="inputtext" readonly>
	                      		 </td>
	                      		 <td class="textoTitulo">
	                      		 	Usuario
	                      		 </td>
	                      		 <td class="textoTitulo">
	                      		 	<input type="text" id="usuarioFINAL" size="08" value="<%=usuarioFINAL %>"  CLASS="inputtext" readonly>
	                      		 </td>
	                      	</tr>
	                      <tr >
	                      		 <td class="textoTitulo">
	                      		 Descrição
	                      		 </td>
	                      		 <td class="textoTitulo" colspan="7">
	                      		 	<input type="text" id="descricaoFINAL" size="130" CLASS="inputtext" value="<%=descricaoFINAL %>"  readonly>
	                      		 </td>
	                      	</tr>
	                      	<tr>
			                      		<td>&nbsp;</td>
			                      	</tr>
	                    </table>
	                    </td>
	                    </tr>
	                    </table>
	                    </td>
	                    </tr>
	                    
	                    </table>
	                    </div>
	                    
	                    
<script language="javascript">
function Historico(){
	document.frmMain.estrategia.value='cedente.CedenteHistoricoSituacao';
	document.frmMain.submit();
}


</script>

