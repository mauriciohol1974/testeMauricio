<script language ="javascript">
	history.go(+1);
</script>

<%@taglib uri="/WEB-INF/tagsPolitec.tld" prefix="p"%>
<%@taglib uri="/WEB-INF/tagsSigcb.tld" prefix="s"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedenteGeralBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePrincipalBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedentePermissaoBean"%>
<%@page import="br.gov.caixa.sigcb.bean.CedConsultaPermissaoBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>
<%@page import="br.gov.caixa.sigcb.util.Paths"%>
<%@page import="br.gov.caixa.sigcb.util.Formatador"%>
<%@page import="java.util.Calendar"%>

<%
	String descCriticas = "";
	if (request.getAttribute(CedenteEstrategia.DESC_CRITICAS) != null) {
		descCriticas = (String) request.getAttribute(CedenteEstrategia.DESC_CRITICAS);
	} 
%>

<% 
	CedenteGeralBean filtroBean = (session.getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN)==null
	                              ? new CedenteGeralBean()
	                              : (CedenteGeralBean) session.getAttribute(CedenteEstrategia.INCLUIR_FILTRO_BEAN));

	CedenteCabecaBean cabecaBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
	                               ? new CedenteCabecaBean()
	                               : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

	CedentePrincipalBean principalBean = (session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN)==null
	                                     ? new CedentePrincipalBean()
	                                     : (CedentePrincipalBean) session.getAttribute(CedenteEstrategia.CEDENTE_PRINCIPAL_BEAN));
	
	
	CedConsultaPermissaoBean permissaoBean = (CedConsultaPermissaoBean) request.getAttribute(CedenteEstrategia.CEDENTE_PERMISSAO_BEAN);
	
	String strSituacao = permissaoBean.getDE_STCO_CIP();
	
	String strData = permissaoBean.getDT_STCO_CIP();
	
	String strHora = permissaoBean.getHH_STCO_CIP();
	
	String descricaoCIP = permissaoBean.getDE_HIST_CIP();
	
	int guiaAberta = principalBean.getGuiaAberta() == null ? CedenteEstrategia.GUIA_NENHUMA : principalBean.getGuiaAberta().intValue();
	int guiaEmCadastramento = principalBean.getGuiaEmCadastramento() == 0 ? CedenteEstrategia.GUIA_GERAL : principalBean.getGuiaEmCadastramento();
	int guiaInclusao = principalBean.getUltimaGuiaCadastrada() == null ? CedenteEstrategia.GUIA_NENHUMA + 1 : principalBean.getUltimaGuiaCadastrada().intValue() + 1;
	int ultimaGuiaCadastrada = principalBean.getUltimaGuiaCadastrada() == null ? CedenteEstrategia.GUIA_NENHUMA : principalBean.getUltimaGuiaCadastrada().intValue();
	String situacaoGuia = principalBean.getSituacaoGuia() == null ? CedenteEstrategia.CONSULTA : principalBean.getSituacaoGuia();
	String tipoCobranca = principalBean.getTipoCobranca() == null ? ""+CedenteEstrategia.COBRANCA_CONVENCIONAL : ""+principalBean.getTipoCobranca();
	String cedenteCentralizador = principalBean.getCedenteCentralizador() == null ? "0" : ""+principalBean.getCedenteCentralizador();
	int cedenteEletronicoCadastrado = principalBean.getCedenteEletronicoCadastrado() == null ? 0 : principalBean.getCedenteEletronicoCadastrado().intValue();
%>

<% 
	CedenteGeralBean geralBean = (session.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN)==null
	                             ? new CedenteGeralBean()
	                             : (CedenteGeralBean)	session.getAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN));

	String codigoUnidadeEN = geralBean.getCodigounidadeEN()!=null?""+geralBean.getCodigounidadeENFormatado():"";
	
	
%>

<html>
  <s:Header/>
  
  <p:Document>
   	<s:FormStrategy name="frmMain" action="SigcbControle" estrategia="cedente.CedenteIncluirGuiaControle" fluxo="normal">
   		<s:Menu/>
   		<s:Titulo name="Incluir Cedente"/>

			<input type="hidden" name="guiaAberta" value="<%= guiaAberta %>">
			<input type="hidden" name="ultimaGuiaCadastrada" value="<%= ultimaGuiaCadastrada %>">
			<input type="hidden" name="situacaoGuia" value="<%= situacaoGuia %>">
			<input type="hidden" name="tipoCobranca" value="<%= tipoCobranca %>">
			<input type="hidden" name="cedenteCentralizador" value="<%= cedenteCentralizador %>">			
			<input type="hidden" name="cedenteEletronicoCadastrado" value="<%= cedenteEletronicoCadastrado %>">

			<input type="hidden" name="codigoClienteCOCLI" value="<%= cabecaBean.getCodigoClienteCOCLI() %>">
			<input type="hidden" name="codigoUnidadePVVinc" value="<%= filtroBean.getCodigoUnidadePVVinc()  %>">
			<input type="hidden" name="tipoAcao">
			<input type="hidden" name="cpfCnpj" value="<%= cabecaBean.getCpfCnpj() %>">
			<input type="hidden" name="nomeCedente" value="<%= cabecaBean.getNomeFantasia() %>">
			<input type="hidden" name="idEndereco" value="<%= cabecaBean.getIdEndereco() %>">
			<input type="hidden" name="tipoPessoa" value="<%= cabecaBean.getTipoPessoa() %>">

    <table width="777" BORDER="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td valign="top" width="95%" height="14" align="left"> 
          <table width="95%" border="0" cellspacing="0" cellpadding="0" height=53 valign="middle" align="center">

						<%-- *********** CABECALHO CEDENTE ****************** --%>
            <%@include file="cedente_cabecalho.jsp" %>
            
            <tr valign="top"> 
              <td colspan="5" class="textoTitulo">Incluir Guias:
                <hr>
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#GeralParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_GERAL%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Gerali"></a>
                <a name="GeralParent">Geral</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_GERAL) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* GERAL ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#FloatParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_FLOAT%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Floati"></a>
                <a name="FloatParent">Float</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_FLOAT) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* FLOAT ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#ContasParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CONTAS%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Contasi"></a>
                <a name="contasParent">Contas Déb. Créd. e Rateio</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_CONTAS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* CONTAS ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#CedenteParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_CEDENTE_ELETRONICO%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Cedentei"></a>
                <a name="CedenteParent">Cedente Eletrônico</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_CEDENTE_ELETRONICO) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* CEDENTE ELETRONICO ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#BloquetosParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_BLOQUETOS%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Bloquetosi"></a>
                <a name="BloquetosParent">Boletos</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_BLOQUETOS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* BLOQUETOS ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#MensagemParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_MENSAGENS%>);"><img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Mensagemi"></a>
                <a name="MensagemParent">Mensagens para Boletos</a>                
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_MENSAGENS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* MENSAGEM ************************************** -->
              </td>
            </tr>

            <tr>
              <td class="textoTitulo">
                <a href="#TarifasParent" onclick="javascript:trocaGuia(<%=CedenteEstrategia.GUIA_TARIFAS%>);">
                	 <img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Tarifasi"></a>
                <a name="TarifasParent">Tarifas</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_TARIFAS) %>
              </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* TARIFAS ************************************** -->
              </td>
            </tr>
  			
            <tr>
              <td class="textoTitulo">
                <a href="#ParametroParent" onclick="javascript:trocaGuia(10);">
                	 <img src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11" height="11" name="outlineplus" id="Tarifasi"></a>
                <a name="TarifasParent">Parâmetros</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_PARAMETROS) %>
              </td>
            </tr>
           						     
            <tr>
              <td colspan="4">
								<!-- ************************************************* Permissão Final ************************************** -->
              </td>
            </tr>
            <tr>
              
              <td class="textoTitulo">
                <a href="#PermissaoParent" onclick="javascript:trocaGuia(11);">
                	 <img src="<%=Paths.getImagePath()%>/outlineminus.gif" width="11" height="11" name="outlineplus" id="Permissaoi"></a>
                <a name="TarifasParent">Permissão Final</a>
              </td>
              <td colspan="3" class="textoValor">
                : <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_PARAMETROS) %>
              </td>
            </tr>
              <td colspan="4">
            	<div class="group">
                  <table width="95%" border="0" cellspacing="0" cellpadding="0" height=14 valign="middle" align="center">
                    <tr> 
                      <td colspan="4">&nbsp;</td>
                    </tr>

                    <tr> 
                      <td colspan="4" class="textoDestaqueTitulo">Guia: Permissão Final</td>
                    </tr>
                    <tr> 
                      <td colspan="4">&nbsp;</td>

                      	<table  cellpadding=0 width=688   style='width:515.8pt;mso-cellspacing:1.5pt;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
                      	
                      	<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                      		 <td class="textoDestaqueTitulo" colspan="6" style='width:20.72%;padding:.75pt .75pt .75pt .75pt'>
                      		 Situação CIP
                      		 </td>
                      	</tr>
                      	
	                  	
                      	<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                      		 <td class="textoTitulo" width="20%" style='width:20.72%;padding:.75pt .75pt .75pt .75pt'>
                      		 Situação
                      		 </td>
                      		 <td class="textoTitulo" width="20%" style='width:20.72%;padding:.75pt .75pt .75pt .75pt'>
                      		 <input type="text" id="situacao" size="10" value="<%=strSituacao %>" CLASS="inputtext" readonly>
                      		 </td>
                      		 <td class="textoTitulo" width="20%" style='width:20.72%;padding:.75pt .75pt .75pt .75pt'>
                      		 Data
                      		 </td>
                      		 <td class="textoTitulo" width="20%" style='width:20.72%;padding:.75pt .75pt .75pt .75pt'>
                      		 <input type="text" id="data" size="12" value="<%=strData%>"  CLASS="inputtext"readonly>
                      		 </td>
                      		 <td class="textoTitulo" width="20%" style='width:20.72%;padding:.75pt .75pt .75pt .75pt'>
                      		 Hora
                      		 </td>
                      		 <td class="textoTitulo" width="20%" style='width:20.72%;padding:.75pt .75pt .75pt .75pt'>
                      		 <input type="text" id="hora" size="08" value="<%=strHora %>" CLASS="inputtext" readonly>
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
                      		<td>&nbsp;</td>
                      	</tr>
                      	
                      	   
                      	
                      	                      	<tr>
                      		<td>&nbsp;</td>
                      	</tr>
                      	
                      	
                      	<tr>
                      		<td colspan="6" align="center">
                      			<s:Button name="Voltar_Principal" value="Voltar" action="javascript:Voltar();"/>
                      		</td>
                      	</tr>
                      	
                      	<tr>
                      		<td>&nbsp;</td>
                      	</tr>
                    
            		</table>
            		</tr>
            								     
            	</div>
            </td>
            </tr>
            <tr>
              <td colspan="4">
								<!-- ************************************************* Conclusão Inicio ************************************** -->
              </td>
            </tr>
			<tr>
					<td class="textoTitulo"><a href="#ConclusaoParent"
						onclick="javascript:trocaGuia(<%= CedenteEstrategia.GUIA_CONCLUSAO %>);"> <img
						src="<%=Paths.getImagePath()%>/outlineplus.gif" width="11"
						height="11" name="outlineplus" id="Conclusaoi"></a> <a
						name="ConclusaoParent">Conclusão</a></td>
					<td colspan="3" class="textoValor">
               			: <%= principalBean.getSituacaoGuiaTexto(CedenteEstrategia.GUIA_CONCLUSAO) %>
					</td>
			</tr>

            <tr>
              <td colspan="4">
								<!-- ************************************************* CONCLUSAO ************************************** -->
              </td>
            </tr>            
            <tr> 
            	<td colspan="4">&nbsp;</td>
            </tr>
            <tr>
             <td align="right" colspan="4">
	               <p align="center"> 
                  <s:Button name="Voltar_Principal" value="Voltar" action="javascript:formSubmit_Voltar();"/>
                  <s:Button name="Cancelar_Principal" value="Cancelar Cadastro" action="javascript:formSubmit_Cancelar();"/>
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
    
    	function Voltar() {
    		document.frmMain.guiaAberta.value = 0;
    		document.frmMain.submit();
    	}
    
	    function inicia(){
<%
	// caso retornou da estrategia com criticas
	if (!descCriticas.equals("")) {
%>
				alert("<%= descCriticas %>");
<%
	}
%>
	    }

			function formSubmit_Cancelar() {
        var confirma = confirm(conf('105'));
      
        if (confirma) {
          document.frmMain.estrategia.value="cedente.CedenteIncluirCancelar";
          document.frmMain.submit();
        }
			}

	    function formSubmit_Voltar() {
        var confirma = confirm(conf('104'));
      
        if (confirma) {
          document.frmMain.estrategia.value="cedente.CedenteIncluirIniciar";
          document.frmMain.submit();
        }
	    }
	    
	    function trocaGuia( guia ) {
	    	var guiaInclusao = <%= guiaInclusao %>;
	    	var guiaEmCadastramento = <%= guiaEmCadastramento %>;
	    
	    	if (guia == <%= guiaAberta %>) {
	    		fecharGuias();
	    		return;
	    	}

	    	if (guia == <%= CedenteEstrategia.GUIA_CEDENTE_ELETRONICO %>
	    				&& <%= principalBean.naoPodeCedenteEletronico() %>) {
	    			return;
	    	}
	    
        if (guia == guiaInclusao && guiaInclusao == guiaEmCadastramento) {
		    	if (!confirm(conf("106"))) {
		    		return;
		    	}
        
	    		document.frmMain.situacaoGuia.value = "<%= CedenteEstrategia.INCLUSAO %>";
		    	document.frmMain.guiaAberta.value = guia;
		    	document.frmMain.submit();
		    } else if (guia < guiaInclusao) {
		    	if (!confirm(conf("106"))) {
		    		return;
		    	}
		    
	    		document.frmMain.situacaoGuia.value = "<%= CedenteEstrategia.ALTERACAO_EM_INCLUSAO %>";
		    	document.frmMain.guiaAberta.value = guia;
		    	document.frmMain.submit();
		    }
	    }
	    
	    function fecharGuias() {
	    	document.frmMain.guiaAberta.value = <%= CedenteEstrategia.GUIA_NENHUMA %>;
	    	document.frmMain.submit();
	    }
	    
	    function formSubmit_Conclusao() {
	    	document.frmMain.estrategia.value="cedente.CedenteIncluirGuiaConcFinalizar";
	    	document.frmMain.tipoAcao.value=document.frmMain.situacaoGuia.value;
	    	document.frmMain.submit();
	    }
	    
    </script>

   	</s:FormStrategy>
  </p:Document>
</html>
