<%@page import="br.gov.caixa.sigcb.bean.CedenteCabecaBean"%>
<%@page import="br.gov.caixa.sigcb.estrategia.cedente.CedenteEstrategia"%>

<%
	CedenteCabecaBean cedenteCabecalhoBean = (session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN)==null
	                                  ? new CedenteCabecaBean()
	                                  : (CedenteCabecaBean) session.getAttribute(CedenteEstrategia.CEDENTE_CABECA_BEAN));

	String cabecaCodigoClienteCOCLI = "";
	if (cedenteCabecalhoBean.getCodigoClienteCOCLI() != null) {
		cabecaCodigoClienteCOCLI = ""+cedenteCabecalhoBean.getCodigoClienteCOCLIZeros();
	}
	
	String cabecaCarteira = "";
	if (cedenteCabecalhoBean.getCarteira() != null) {
		cabecaCarteira = ""+cedenteCabecalhoBean.getCarteira();
	}
	
	String cabecaNomeFantasia = "";
	if (cedenteCabecalhoBean.getNomeFantasia() != null) {
		cabecaNomeFantasia = ""+cedenteCabecalhoBean.getNomeFantasia();
	}
	
	String cabecaRazaoSocial = "";
	if (cedenteCabecalhoBean.getRazaoSocial() != null) {
		cabecaRazaoSocial = cedenteCabecalhoBean.getRazaoSocial();
	}
	
	String cabecaEmail = "";
	if (cedenteCabecalhoBean.getEmail() != null) {
		cabecaEmail = cedenteCabecalhoBean.getEmail();
	}
	
	String cabecaEndereco = "";
	if (cedenteCabecalhoBean.getLogradouro() != null) {
		cabecaEndereco = ""+cedenteCabecalhoBean.getLogradouro();
	}
	if (cedenteCabecalhoBean.getNumero() != null) {
		cabecaEndereco += ", " + cedenteCabecalhoBean.getNumero();
	}
	
	String cabecaMunicipioUf = "";
	if (cedenteCabecalhoBean.getMunicipio() != null) {
		cabecaMunicipioUf = ""+cedenteCabecalhoBean.getMunicipio();
	}
	if (cedenteCabecalhoBean.getUf() != null) {
		cabecaMunicipioUf += ", " + cedenteCabecalhoBean.getUf();
	}
	
	String cabecaCodigoCedente = "";
	String cabecaTituloCedente = "&nbsp;";
	if (cedenteCabecalhoBean.getCodigoCedente() != null) {
		cabecaCodigoCedente = "" + cedenteCabecalhoBean.getCodigoCedenteFormatado();
		cabecaTituloCedente = "Cedente:";
	}
%>

            <tr>
              <td class="textoTitulo" width="17%">Código Cliente (COCLI): </td>
              <td class="textoValor" width="26%"><%= cabecaCodigoClienteCOCLI %></td>
              <td class="textoTitulo" width="17%">Carteira: </td>
              <td class="textoValor" width="26%"><%= cabecaCarteira %></td> 
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Tipo de Pessoa: </td>
              <td class="textoValor" width="26%"><%= cedenteCabecalhoBean.getTipoPessoaTexto() %></td> 
              <td class="textoTitulo" width="17%">CPF/CNPJ: </td>
              <td class="textoValor" width="26%"><%= cedenteCabecalhoBean.getCpfCnpjFormatado() %></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">Nome Cedente: </td>
              <td class="textoValor" width="26%"><%= cabecaNomeFantasia %></td> 
              <td class="textoTitulo" width="17%">Razão Social: </td>
              <td class="textoValor" width="26%"><%= cabecaRazaoSocial %></td>
            </tr>
            <tr>
              <td class="textoTitulo" width="17%">e-mail: </td>
              <td class="textoValor" width="26%"><%= cabecaEmail %></td> 
              <td class="textoTitulo" width="17%">Endereço: </td>
              <td class="textoValor" width="26%"><%= cabecaEndereco %></td>
            </tr>
            <tr>
	              <td class="textoTitulo" width="17%"><%= cabecaTituloCedente %></td>
	              <td class="textoValor" width="26%"><%= cabecaCodigoCedente %></td> 
	              <td class="textoTitulo" width="17%">&nbsp;</td>
	              <td class="textoValor" width="26%"><%= cabecaMunicipioUf %></td>
            </tr>
            <tr>
	              <td colspan="4">&nbsp;</td>
            </tr>
            