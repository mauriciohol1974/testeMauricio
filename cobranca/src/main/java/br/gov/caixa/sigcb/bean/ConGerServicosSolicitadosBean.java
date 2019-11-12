package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.DateType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.DateValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.Util;

public class ConGerServicosSolicitadosBean extends SigcbBean {

    private java.lang.String aceite;

    private java.lang.String agendamentoPermanente;

    private java.lang.Long codigoBancoSacados;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidadePv;

    private java.lang.String codigoUsuario;

    private java.util.Date dataDebitoTarifa;

    private java.util.Date dataFinal;

    private java.util.Date dataInicial;

    private java.util.Date dataMovimento;

    private java.util.Date dataProcessamento;

    private java.util.Date dataSolicitacao;

    private java.util.Date dataVencimento;

    private java.lang.String descServicos;

    private java.lang.Long diaEmissao;

    private java.lang.Long diaVencimento;

    private java.lang.String especie;

    private java.lang.String formaEmissao;

    private java.lang.Long formaVencimento;

    private java.lang.String horaMovimento;

    private java.lang.String horaProcessamento;

    private java.lang.String justificativa;

    private java.lang.String meioEntrada;

    private java.lang.String modelo;

    private java.lang.String motivoRejeicao;

    private java.lang.String navegacao;

    private java.lang.String nomeBancoSacados;

    private java.lang.String nomeFantasia;

    private java.lang.String nomePvVinculacao;

    private java.lang.String nomeSacado;

    private java.lang.Long nossoNumeroInicial;

    private java.lang.String numeroDocumento;

    private java.lang.Long numeroRetorno;

    private java.lang.Long quantidade;

    private java.lang.String registroTitulo;

    private java.lang.String situacao;

    private java.lang.Long tipoConsulta; /* nota */// tipo de consulta das
                                                    // transações

    private java.lang.String tipoEntrega;

    private java.lang.Long tpConsulta; /* nota */// tipo de consulta das paginas,
                                                // geralmente está ligada a um
                                                // radio button

    private java.lang.Long tpFiltro; /* nota */// tipo de filtro utilizado nas
                                                // telas de filtro para efetuar
                                                // a chamada a transação BGE1

    private br.com.politec.sao.util.Money valorTarifa;

    private br.com.politec.sao.util.Money valorTitulo;

    /* Alteração para a inclusão da transação BGDA - opção de tpConsulta = todos */
    private java.lang.Long descricaoItem;

    private java.lang.Long quantidadeItens;

    // Alteração para a inclusão da transação BGDB.
    private java.lang.String nomeCedente;

    // Alteção para a transação BGC1
    private java.lang.Long nroPedidoGrafica;// 9(010)
    
    private String parcela;

    public ConGerServicosSolicitadosBean() {
        this.aceite = null;
        this.agendamentoPermanente = null;
        this.codigoBancoSacados = null;
        this.codigoCedente = null;
        this.codigoUnidadePv = null;
        this.codigoUsuario = null;
        this.dataDebitoTarifa = null;
        this.dataFinal = null;
        this.dataInicial = null;
        this.dataMovimento = null;
        this.dataProcessamento = null;
        this.dataSolicitacao = null;
        this.dataVencimento = null;
        this.descServicos = null;
        this.diaEmissao = null;
        this.diaVencimento = null;
        this.especie = null;
        this.formaEmissao = null;
        this.formaVencimento = null;
        this.horaMovimento = null;
        this.horaProcessamento = null;
        this.justificativa = null;
        this.meioEntrada = null;
        this.modelo = null;
        this.motivoRejeicao = null;
        this.navegacao = null;
        this.nomeBancoSacados = null;
        this.nomeFantasia = null;
        this.nomePvVinculacao = null;
        this.nomeSacado = null;
        this.nossoNumeroInicial = null;
        this.numeroDocumento = null;
        this.numeroRetorno = null;
        this.quantidade = null;
        this.registroTitulo = null;
        this.situacao = null;
        this.tipoConsulta = null;
        this.tipoEntrega = null;
        this.tpConsulta = null;
        this.tpFiltro = null;
        this.valorTarifa = null;
        this.valorTitulo = null;

        this.descricaoItem = null;
        this.quantidadeItens = null;

        this.nomeCedente = null;

        this.nroPedidoGrafica = null;
        this.parcela=null;
    }

    public String getApplicationName() {
        return "ConGerServicosSolicitadosBean";
    }

    public java.lang.String getAceite() {
        return this.aceite;
    }

    public void setAceite(java.lang.String aceite) {
        this.aceite = aceite;
    }

    public java.lang.String getAgendamentoPermanente() {
        return this.agendamentoPermanente;
    }

    public void setAgendamentoPermanente(java.lang.String agendamentoPermanente) {
        this.agendamentoPermanente = agendamentoPermanente;
    }

    public java.lang.Long getCodigoBancoSacados() {
        return this.codigoBancoSacados;
    }

    public void setCodigoBancoSacados(java.lang.Long codigoBancoSacados) {
        this.codigoBancoSacados = codigoBancoSacados;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoUnidadePv() {
        return this.codigoUnidadePv;
    }

    public void setCodigoUnidadePv(java.lang.Long codigoUnidadePv) {
        this.codigoUnidadePv = codigoUnidadePv;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.util.Date getDataDebitoTarifa() {
        return this.dataDebitoTarifa;
    }

    public void setDataDebitoTarifa(java.util.Date dataDebitoTarifa) {
        this.dataDebitoTarifa = dataDebitoTarifa;
    }

    public java.util.Date getDataFinal() {
        return this.dataFinal;
    }

    public void setDataFinal(java.util.Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public java.util.Date getDataInicial() {
        return this.dataInicial;
    }

    public void setDataInicial(java.util.Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public java.util.Date getDataMovimento() {
        return this.dataMovimento;
    }

    public void setDataMovimento(java.util.Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public java.util.Date getDataProcessamento() {
        return this.dataProcessamento;
    }

    public void setDataProcessamento(java.util.Date dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public java.util.Date getDataSolicitacao() {
        return this.dataSolicitacao;
    }

    public void setDataSolicitacao(java.util.Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public java.util.Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(java.util.Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public java.lang.String getDescServicos() {
        return this.descServicos;
    }

    public void setDescServicos(java.lang.String descServicos) {
        this.descServicos = descServicos;
    }

    public java.lang.Long getDiaEmissao() {
        return this.diaEmissao;
    }

    public void setDiaEmissao(java.lang.Long diaEmissao) {
        this.diaEmissao = diaEmissao;
    }

    public java.lang.Long getDiaVencimento() {
        return this.diaVencimento;
    }

    public void setDiaVencimento(java.lang.Long diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public java.lang.String getEspecie() {
        return this.especie;
    }

    public void setEspecie(java.lang.String especie) {
        this.especie = especie;
    }

    public java.lang.String getFormaEmissao() {
        return this.formaEmissao;
    }

    public void setFormaEmissao(java.lang.String formaEmissao) {
        this.formaEmissao = formaEmissao;
    }

    public java.lang.Long getFormaVencimento() {
        return this.formaVencimento;
    }

    public void setFormaVencimento(java.lang.Long formaVencimento) {
        this.formaVencimento = formaVencimento;
    }

    public java.lang.String getHoraMovimento() {
        return this.horaMovimento;
    }

    public void setHoraMovimento(java.lang.String horaMovimento) {
        this.horaMovimento = horaMovimento;
    }

    public java.lang.String getHoraProcessamento() {
        return this.horaProcessamento;
    }

    public void setHoraProcessamento(java.lang.String horaProcessamento) {
        this.horaProcessamento = horaProcessamento;
    }

    public java.lang.String getJustificativa() {
        return this.justificativa;
    }

    public void setJustificativa(java.lang.String justificativa) {
        this.justificativa = justificativa;
    }

    public java.lang.String getMeioEntrada() {
        return this.meioEntrada;
    }

    public void setMeioEntrada(java.lang.String meioEntrada) {
        this.meioEntrada = meioEntrada;
    }

    public java.lang.String getModelo() {
        return this.modelo;
    }

    public void setModelo(java.lang.String modelo) {
        this.modelo = modelo;
    }

    public java.lang.String getMotivoRejeicao() {
        return this.motivoRejeicao;
    }

    public void setMotivoRejeicao(java.lang.String motivoRejeicao) {
        this.motivoRejeicao = motivoRejeicao;
    }

    public java.lang.String getNavegacao() {
        return this.navegacao;
    }

    public void setNavegacao(java.lang.String navegacao) {
        this.navegacao = navegacao;
    }

    public java.lang.String getNomeBancoSacados() {
        return this.nomeBancoSacados;
    }

    public void setNomeBancoSacados(java.lang.String nomeBancoSacados) {
        this.nomeBancoSacados = nomeBancoSacados;
    }

    public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public java.lang.String getNomePvVinculacao() {
        return this.nomePvVinculacao;
    }

    public void setNomePvVinculacao(java.lang.String nomePvVinculacao) {
        this.nomePvVinculacao = nomePvVinculacao;
    }

    public java.lang.String getNomeSacado() {
        return this.nomeSacado;
    }

    public void setNomeSacado(java.lang.String nomeSacado) {
        this.nomeSacado = nomeSacado;
    }

    public java.lang.Long getNossoNumeroInicial() {
        return this.nossoNumeroInicial;
    }

    public void setNossoNumeroInicial(java.lang.Long nossoNumeroInicial) {
        this.nossoNumeroInicial = nossoNumeroInicial;
    }

    public java.lang.String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public void setNumeroDocumento(java.lang.String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public java.lang.Long getNumeroRetorno() {
        return this.numeroRetorno;
    }

    public void setNumeroRetorno(java.lang.Long numeroRetorno) {
        this.numeroRetorno = numeroRetorno;
    }

    public java.lang.Long getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(java.lang.Long quantidade) {
        this.quantidade = quantidade;
    }

    public java.lang.String getRegistroTitulo() {
        return this.registroTitulo;
    }

    public void setRegistroTitulo(java.lang.String registroTitulo) {
        this.registroTitulo = registroTitulo;
    }

    public java.lang.String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(java.lang.String situacao) {
        this.situacao = situacao;
    }

    public java.lang.Long getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.Long tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public java.lang.String getTipoEntrega() {
        return this.tipoEntrega;
    }

    public void setTipoEntrega(java.lang.String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public java.lang.Long getTpConsulta() {
        return this.tpConsulta;
    }

    public void setTpConsulta(java.lang.Long tpConsulta) {
        this.tpConsulta = tpConsulta;
    }

    public java.lang.Long getTpFiltro() {
        return this.tpFiltro;
    }

    public void setTpFiltro(java.lang.Long tpFiltro) {
        this.tpFiltro = tpFiltro;
    }

    public br.com.politec.sao.util.Money getValorTarifa() {
        return this.valorTarifa;
    }

    public void setValorTarifa(br.com.politec.sao.util.Money valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    public br.com.politec.sao.util.Money getValorTitulo() {
        return this.valorTitulo;
    }

    public void setValorTitulo(br.com.politec.sao.util.Money valorTitulo) {
        this.valorTitulo = valorTitulo;
    }

    /* ////////////////metodos inseridos manualmente//////////////////// */
    public java.lang.Long getNroPedidoGrafica() {
        return nroPedidoGrafica;
    }

    public void setNroPedidoGrafica(java.lang.Long nroPedidoGrafica) {
        this.nroPedidoGrafica = nroPedidoGrafica;
    }

    public java.lang.Long getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(java.lang.Long descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public java.lang.Long getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(java.lang.Long quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }
    

    public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public String getTextoDescricaoItens() {
        String listaDescricaoItemTexto[] = {
                                            "Agendamento de Emissão de Títulos para Banco de Sacados",// 01
                                            "Emissão de Títulos para Banco de Sacados",// 02
                                            "Extrato de Distribuição de Crédito e Débitos",// 03
                                            "Recuperação de Títulos Baixados ou Liquidados",// 04
                                            "Reemissão de Bloquetos",// 05
                                            "Bloqueto Pré-Impresso",// 06
                                            "Extrato de Movimentação de Títulos",// 07
                                            "Lançamento de Tarifa Manual",// 08
                                            "Redisponibilização de Arquivo de Retorno" // 09
        };
        // LogUtilSigcb.info("Dentro ConGerServicosSolicitadosBean -> " +
        // this.getDescricaoItem().intValue());
        // LogUtilSigcb.info("Dentro ConGerServicosSolicitadosBean -> " +
        // listaDescricaoItemTexto[this.getDescricaoItem().intValue()-1]);
        return listaDescricaoItemTexto[this.getDescricaoItem().intValue() - 1];
    }

    public java.lang.String getNomeCedente() {
        return nomeCedente;
    }

    public void setNomeCedente(java.lang.String nomeCedente) {
        this.nomeCedente = nomeCedente;
    }

    public String getDescFormaVencimento() {
        String retorno = "";
        if (this.formaVencimento != null) {
            switch (formaVencimento.intValue()) {
            case 1:
                retorno = "ANTECIPA";
                break;
            case 2:
                retorno = "POSTERGA";
                break;
            case 3:
                retorno = "MANTEM";
                break;
            default:
                retorno = " " + formaVencimento;
                break;
            }
        }
        return retorno;
    }

    public String getDataProcessamentoFormatada() {
        if (this.dataProcessamento != null) {
            return Formatador.formatarData(this.dataProcessamento);
        } else {
            return "";
        }
    }

    public String getDataVencimentoFormatada() {
        if (this.dataVencimento != null) {
            return Formatador.formatarData(this.dataVencimento);
        } else {
            return "";
        }
    }

    public String getDataSolicitacaoFormatada() {
        if (this.dataSolicitacao != null) {
            return Formatador.formatarData(this.dataSolicitacao);
        } else {
            return "";
        }
    }

    public String getDataInicialFormatada() {
        if (this.dataInicial != null) {
            return Formatador.formatarData(this.dataInicial);
        } else {
            return "";
        }
    }

    public String getDataFinalFormatada() {
        if (this.dataFinal != null) {
            return Formatador.formatarData(this.dataFinal);
        } else {
            return "";
        }
    }

    public String getDataDebitoTarifaFormatada() {
        if (this.dataDebitoTarifa != null) {
            return Formatador.formatarData(this.dataDebitoTarifa);
        } else {
            return "";
        }
    }

    public String getDataMovimentoFormatada() {
        if (this.dataMovimento != null) {
            return Formatador.formatarData(this.dataMovimento);
        } else {
            return "";
        }
    }

    public java.lang.String getHoraMovimentoFormatada() {
        String horaM = "";

        if (this.horaMovimento != null && !this.horaMovimento.equals("")) {
            horaM = Util.trocaCaracter('.', ':', this.horaMovimento);
        }

        return horaM;
    }

    public java.lang.String getHoraProcessamentoFormatada() {
        String horaP = "";

        if (this.horaProcessamento != null
            && !this.horaProcessamento.equals("")) {
            horaP = Util.trocaCaracter('.', ':', this.horaProcessamento);
        }

        return horaP;
    }

    public String getDescRegistroTitulo() {
        String retorno = "";

        if (this.registroTitulo != null) {
            if (this.registroTitulo.equals("S")) {
                retorno = "SIM";
            } else if (this.registroTitulo.equals("N")) {
                retorno = "NÃO";
            } else {
                retorno = " " + registroTitulo;
            }
        }
        return retorno;
    }

    public String getDescAgendamentoPermanente() {
        String retorno = "";

        if (this.agendamentoPermanente != null) {
            if (this.agendamentoPermanente.equals("S")) {
                retorno = "SIM";
            } else if (this.agendamentoPermanente.equals("N")) {
                retorno = "NÃO";
            } else {
                retorno = " " + agendamentoPermanente;
            }
        }
        return retorno;
    }

    public String getNomeRelatorio() {

        /* nota */
        // os valores para tpConsulta seguem um padrão necessário ao mainframe
        // esses valores serão utilizados da transação BGE1 para dizer ao
        // mainframe qual
        // o tipo de consulta(Relatório)o usuário está requisitando
        // alem dos valores sub sitados há tambem o valor 899 que será utilizado
        // na consulta
        // de solicitações rejeitadas.
        String retorno = "";

        if (this.tpConsulta != null) {
            switch (this.tpConsulta.intValue()) {
            case 1:
                retorno = "TODOS";
                break;
            case 2:
                retorno = "REDISPONIBILIZAÇÃO DE ARQUIVO DE RETORNO";
                break;
            case 3:
                retorno = "BLOQUETO PRÉ-IMPRESSO";
                break;
            case 5:
                retorno = "EXTRATO DE MOVIMENTAÇÃO DE TÍTULOS";
                break;
            case 6:
                retorno = "EMISSÃO DE TÍTULOS PARA BANCO DE SACADOS";
                break;
            case 7:
                retorno = "AGENDAMENTO DE EMISSÃO DE TÍTULOS PARA BANCO DE SACADOS";
                break;
            case 8:
                retorno = "RECUPERAÇÃO DE TÍTULOS BAIXADOS OU LIQUIDADOS";
                break;
            case 9:
                retorno = "EXTRATO DE DISTRIBUIÇÃO DE CRÉDITO E DÉBITOS";
                break;
            case 999:
                retorno = "LANÇAMENTO DE TARIFA MANUAL";
                break;
            case 888:
                retorno = "REEMISSÃO DE BLOQUETOS";
                break;
            case 899:
                retorno = "CONSULTA DE SOLICITAÇÕES REJEITADAS";
                break;
            case 11:
                retorno = "TODOS"; // Opção Todos para Processados do Dia
                break;
            default:
                retorno = "";
                break;
            }
        }

        return retorno;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getNossoNumeroFormatado-----------------------
    public java.lang.String getNossoNumeroInicialFormatado() {
       // String nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumeroInicial);
        
        String NN = this.nossoNumeroInicial.toString();
    	String nossoNumeroFormatado="";		
    	if (NN.length()==18){
    		nossoNumeroFormatado = Formatador.formatarNossoNumero18(this.nossoNumeroInicial);
    	}else{
    		nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumeroInicial);
    	}
        
        return nossoNumeroFormatado;
    }

    // fim-------------getNossoNumeroFormatado-----------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadePvFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePv);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    /* ////////////////fim metodos inseridos manualmente///////////////// */

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ConGerServicosSolicitadosBean other = (ConGerServicosSolicitadosBean) obj;
            result = result && equals(getAceite(), other.getAceite());
            result = result
                     && equals(getAgendamentoPermanente(),
                             other.getAgendamentoPermanente());
            result = result
                     && equals(getCodigoBancoSacados(),
                             other.getCodigoBancoSacados());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidadePv(), other.getCodigoUnidadePv());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getDataDebitoTarifa(),
                             other.getDataDebitoTarifa());
            result = result && equals(getDataFinal(), other.getDataFinal());
            result = result && equals(getDataInicial(), other.getDataInicial());
            result = result
                     && equals(getDataMovimento(), other.getDataMovimento());
            result = result
                     && equals(getDataProcessamento(),
                             other.getDataProcessamento());
            result = result
                     && equals(getDataSolicitacao(), other.getDataSolicitacao());
            result = result
                     && equals(getDataVencimento(), other.getDataVencimento());
            result = result
                     && equals(getDescServicos(), other.getDescServicos());
            result = result && equals(getDiaEmissao(), other.getDiaEmissao());
            result = result
                     && equals(getDiaVencimento(), other.getDiaVencimento());
            result = result && equals(getEspecie(), other.getEspecie());
            result = result
                     && equals(getFormaEmissao(), other.getFormaEmissao());
            result = result
                     && equals(getFormaVencimento(), other.getFormaVencimento());
            result = result
                     && equals(getHoraMovimento(), other.getHoraMovimento());
            result = result
                     && equals(getHoraProcessamento(),
                             other.getHoraProcessamento());
            result = result
                     && equals(getJustificativa(), other.getJustificativa());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result && equals(getModelo(), other.getModelo());
            result = result
                     && equals(getMotivoRejeicao(), other.getMotivoRejeicao());
            result = result && equals(getNavegacao(), other.getNavegacao());
            result = result
                     && equals(getNomeBancoSacados(),
                             other.getNomeBancoSacados());
            result = result
                     && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result
                     && equals(getNomePvVinculacao(),
                             other.getNomePvVinculacao());
            result = result && equals(getNomeSacado(), other.getNomeSacado());
            result = result
                     && equals(getNossoNumeroInicial(),
                             other.getNossoNumeroInicial());
            result = result
                     && equals(getNumeroDocumento(), other.getNumeroDocumento());
            result = result
                     && equals(getNumeroRetorno(), other.getNumeroRetorno());
            result = result && equals(getQuantidade(), other.getQuantidade());
            result = result
                     && equals(getRegistroTitulo(), other.getRegistroTitulo());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoEntrega(), other.getTipoEntrega());
            result = result && equals(getTpConsulta(), other.getTpConsulta());
            result = result && equals(getTpFiltro(), other.getTpFiltro());
            result = result && equals(getValorTarifa(), other.getValorTarifa());
            result = result && equals(getValorTitulo(), other.getValorTitulo());
            result = result && equals(getParcela(), other.getParcela());

            result = result
                     && equals(this.getDescricaoItem(),
                             other.getDescricaoItem());
            result = result
                     && equals(this.getQuantidadeItens(),
                             other.getQuantidadeItens());

            result = result
                     && equals(this.getNomeCedente(), other.getNomeCedente());

            result = result
                     && equals(this.getNroPedidoGrafica(),
                             other.getNroPedidoGrafica());
            return result;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = 0;
        return result;
    }

    private static final Layout layout = initLayout();

    private static Layout initLayout() {
        java.util.TreeSet properties = new java.util.TreeSet();
        properties.add(new Property("aceite", StringType.create(), false, true));
        properties.add(new Property("agendamentoPermanente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoBancoSacados",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePv",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataDebitoTarifa",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataFinal", DateType.create(), false, true));
        properties.add(new Property("dataInicial",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataMovimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataProcessamento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataSolicitacao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataVencimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("descServicos",
                StringType.create(),
                false,
                true));
        properties.add(new Property("diaEmissao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("diaVencimento",
                LongType.create(),
                false,
                true));
        properties.add(new Property("especie", StringType.create(), false, true));
        properties.add(new Property("formaEmissao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("formaVencimento",
                LongType.create(),
                false,
                true));
        properties.add(new Property("horaMovimento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("horaProcessamento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("justificativa",
                StringType.create(),
                false,
                true));
        properties.add(new Property("meioEntrada",
                StringType.create(),
                false,
                true));
        properties.add(new Property("modelo", StringType.create(), false, true));
        properties.add(new Property("motivoRejeicao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("navegacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeBancoSacados",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeFantasia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomePvVinculacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nossoNumeroInicial",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroDocumento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroRetorno",
                LongType.create(),
                false,
                true));
        properties.add(new Property("quantidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("registroTitulo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("situacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoEntrega",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tpConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tpFiltro", LongType.create(), false, true));
        properties.add(new Property("valorTarifa",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTitulo",
                MoneyType.create(),
                false,
                true));

        properties.add(new Property("descricaoItem",
                LongType.create(),
                false,
                true));
        properties.add(new Property("quantidadeItens",
                LongType.create(),
                false,
                true));

        properties.add(new Property("nomeCedente",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("parcela",
                StringType.create(),
                false,
                true));

        properties.add(new Property("nroPedidoGrafica",
                LongType.create(),
                false,
                true));

        Layout result = new Layout(properties,
                "ConGerServicosSolicitadosBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("registroTitulo", new StringValue("X(01)"));
        Mainframe.put("justificativa", new StringValue("X(100)"));
        Mainframe.put("meioEntrada", new StringValue("X(40)"));
        Mainframe.put("formaVencimento", new LongValue("9(01)"));
        Mainframe.put("navegacao", new StringValue("X(60)"));
        Mainframe.put("dataSolicitacao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("tpConsulta", new LongValue("9(03)"));
        Mainframe.put("tpFiltro", new LongValue("9(01)"));
        Mainframe.put("nomePvVinculacao", new StringValue("X(40)"));
        Mainframe.put("dataDebitoTarifa", new DateValue("dd.MM.yyyy"));
        Mainframe.put("aceite", new StringValue("X(40)"));
        Mainframe.put("codigoUnidadePv", new LongValue("9(04)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("nomeFantasia", new StringValue("X(40)"));
        Mainframe.put("quantidade", new LongValue("9(05)"));
        Mainframe.put("numeroDocumento", new StringValue("X(15)"));
        Mainframe.put("agendamentoPermanente", new StringValue("X(01)"));
        Mainframe.put("horaMovimento", new StringValue("X(08)"));
        Mainframe.put("nomeBancoSacados", new StringValue("X(20)"));
        Mainframe.put("dataProcessamento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("tipoEntrega", new StringValue("X(40)"));
        Mainframe.put("descServicos", new StringValue("X(40)"));
        Mainframe.put("dataVencimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("especie", new StringValue("X(40)"));
        Mainframe.put("situacao", new StringValue("X(40)"));
        Mainframe.put("codigoBancoSacados", new LongValue("9(03)"));
        Mainframe.put("dataInicial", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valorTarifa", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("nomeSacado", new StringValue("X(40)"));
        Mainframe.put("modelo", new StringValue("X(40)"));
        Mainframe.put("diaVencimento", new LongValue("9(02)"));
        Mainframe.put("numeroRetorno", new LongValue("9(08)"));
        Mainframe.put("diaEmissao", new LongValue("9(02)"));
        Mainframe.put("formaEmissao", new StringValue("X(40)"));
        Mainframe.put("horaProcessamento", new StringValue("X(08)"));
        Mainframe.put("nossoNumeroInicial", new LongValue("9(18)"));
        Mainframe.put("valorTitulo", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("dataFinal", new DateValue("dd.MM.yyyy"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("dataMovimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("motivoRejeicao", new StringValue("X(80)"));

        Mainframe.put("descricaoItem", new LongValue("9(02)"));
        Mainframe.put("quantidadeItens", new LongValue("9(03)"));

        Mainframe.put("nomeCedente", new StringValue("X(40)"));
        Mainframe.put("parcela", new StringValue("X(07)"));

        Mainframe.put("nroPedidoGrafica", new LongValue("9(10)"));

        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }

}
