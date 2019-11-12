//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import java.util.ArrayList;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.IntegerType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.PercentualType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.IntegerValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.PercentualValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Percentual;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteGeralBean extends SigcbBean {
    private java.lang.String bancoCorrespondente;

    private java.lang.String bancoSacados;

    private java.lang.String clienteExterno;

    private java.lang.Long clienteGiroCaixa;

    private java.lang.String clienteSINCE;

    private java.lang.String cobrancaSemBloqueto;

    private java.lang.Long codCedenteCentraliz;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoClienteCOCLI;

    private java.lang.Long codigoUnidadePVVinc;

    private java.lang.String codigoUsuario;

    private java.lang.Long codigounidadeEN;

    private java.lang.String descClienteGiroCaixa;

    private java.lang.String descDestinoExtMov;

    private java.lang.String descDestinoExtMovDebtCredt;

    private java.lang.String descModalidadeTitulo;

    private java.lang.String descNatureza;

    private java.lang.String descPorte;

    private java.lang.String descRamoAtividade;

    private java.lang.String descSetor;

    private java.lang.String descTipoCobranca;

    private java.lang.String descTipoJurosDia;

    private java.lang.String descricaoCriticas;

    private java.lang.Long destinoExtMov;

    private java.lang.Long destinoExtMovDebtCredt;

    private java.lang.String exclusaoAutomatica;

    private java.lang.String extratoMovDebtCredt;

    private java.lang.String extratoMovTit;

    private java.lang.Integer ultimaGuiaCadastrada;

    private java.lang.String inventarioMes;

    private java.lang.Long modalidadeTitulo;

    private Percentual multa;

    private java.lang.Long natureza;

    private java.lang.String nsuTransacao;

    private Percentual percentualJurosDia;

    private java.lang.Long porte;

    private java.lang.Long prazoDevolucao;

    private java.lang.Long prazoMulta;

    private java.lang.Long prazoProtesto;

    private java.lang.String protestoAutomatico;

    private java.lang.Long ramoAtividade;

    private java.lang.String recebimentoCheque;

    private java.lang.Long setor;

    private java.lang.String situacao;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoCobranca;

    private java.lang.String tipoConsulta;

    private java.lang.Long tipoJurosDia;
    
    private java.lang.String retencaoIOF;
    
    private java.lang.String valorDiferenciado;
    
    private java.lang.Long codigoSINCE;
    
    private String autorizacao;
    private String modeloCalculo;
    
    private Long atividade;
    
    private String envioSMS;

    private ArrayList listaRamos = new ArrayList();

    private java.lang.Long codRedeTransmissao;
    
    private String cedentePEC;
    
    private Long cedenteVinculo;
    
    private String dataPEC;
    
    private String pvVincAnt;
    
    private String dtAltPvVinc;
    
    private String cedSemRegistro;
    
    private Long cpfCnpj;
    
    private String tipoInscricao;

    public CedenteGeralBean() {
        this.bancoCorrespondente = null;
        this.bancoSacados = null;
        this.clienteExterno = null;
        this.clienteGiroCaixa = null;
        this.clienteSINCE = null;
        this.cobrancaSemBloqueto = null;
        this.codCedenteCentraliz = null;
        this.codigoCedente = null;
        this.codigoClienteCOCLI = null;
        this.codigoUnidadePVVinc = null;
        this.codigoUsuario = null;
        this.codigounidadeEN = null;
        this.descClienteGiroCaixa = null;
        this.descDestinoExtMov = null;
        this.descDestinoExtMovDebtCredt = null;
        this.descModalidadeTitulo = null;
        this.descNatureza = null;
        this.descPorte = null;
        this.descRamoAtividade = null;
        this.descSetor = null;
        this.descTipoCobranca = null;
        this.descTipoJurosDia = null;
        this.descricaoCriticas = null;
        this.destinoExtMov = null;
        this.destinoExtMovDebtCredt = null;
        this.exclusaoAutomatica = null;
        this.extratoMovDebtCredt = null;
        this.extratoMovTit = null;
        this.ultimaGuiaCadastrada = null;
        this.inventarioMes = null;
        this.modalidadeTitulo = null;
        this.multa = null;
        this.natureza = null;
        this.nsuTransacao = null;
        this.percentualJurosDia = null;
        this.porte = null;
        this.prazoDevolucao = null;
        this.prazoMulta = null;
        this.prazoProtesto = null;
        this.protestoAutomatico = null;
        this.ramoAtividade = null;
        this.recebimentoCheque = null;
        this.setor = null;
        this.situacao = null;
        this.tipoAcao = null;
        this.tipoCobranca = null;
        this.tipoConsulta = null;
        this.retencaoIOF = null;
        this.valorDiferenciado=null;
        this.atividade = null;
        this.tipoJurosDia = null;
        this.codRedeTransmissao = null;
        this.autorizacao=null;
        this.modeloCalculo=null;
        this.codigoSINCE=null;
        this.envioSMS=null;
        this.cedentePEC=null;
        this.cedenteVinculo=null;
        this.dataPEC=null;
        this.pvVincAnt=null;
        this.dtAltPvVinc=null;
        this.cedSemRegistro=null;
        this.cpfCnpj=null;
        this.tipoInscricao=null;
    }

    
    
    public Long getCpfCnpj() {
		return cpfCnpj;
	}



	public void setCpfCnpj(Long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}



	public String getTipoInscricao() {
		return tipoInscricao;
	}



	public void setTipoInscricao(String tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}



	public String getCedSemRegistro() {
		return cedSemRegistro;
	}



	public void setCedSemRegistro(String cedSemRegistro) {
		this.cedSemRegistro = cedSemRegistro;
	}



	public String getPvVincAnt() {
		return pvVincAnt;
	}



	public void setPvVincAnt(String pvVincAnt) {
		this.pvVincAnt = pvVincAnt;
	}



	public String getDtAltPvVinc() {
		return dtAltPvVinc;
	}



	public void setDtAltPvVinc(String dtAltPvVinc) {
		this.dtAltPvVinc = dtAltPvVinc;
	}



	public String getApplicationName() {
        return "CedenteGeralBean";
    }

    public java.lang.String getBancoCorrespondente() {
        return this.bancoCorrespondente;
    }
    

    public String getEnvioSMS() {
		return envioSMS;
	}

	public void setEnvioSMS(String envioSMS) {
		this.envioSMS = envioSMS;
	}

	public void setBancoCorrespondente(java.lang.String bancoCorrespondente) {
        this.bancoCorrespondente = bancoCorrespondente;
    }

    public java.lang.String getBancoSacados() {
        return this.bancoSacados;
    }

    public void setBancoSacados(java.lang.String bancoSacados) {
        this.bancoSacados = bancoSacados;
    }

    public java.lang.String getClienteExterno() {
        return this.clienteExterno;
    }

    public void setClienteExterno(java.lang.String clienteExterno) {
        this.clienteExterno = clienteExterno;
    }

    public java.lang.Long getClienteGiroCaixa() {
        return this.clienteGiroCaixa;
    }

    public void setClienteGiroCaixa(java.lang.Long clienteGiroCaixa) {
        this.clienteGiroCaixa = clienteGiroCaixa;
    }

    public java.lang.String getClienteSINCE() {
        return this.clienteSINCE;
    }

    public void setClienteSINCE(java.lang.String clienteSINCE) {
        this.clienteSINCE = clienteSINCE;
    }

    public java.lang.String getCobrancaSemBloqueto() {
        return this.cobrancaSemBloqueto;
    }

    public void setCobrancaSemBloqueto(java.lang.String cobrancaSemBloqueto) {
        this.cobrancaSemBloqueto = cobrancaSemBloqueto;
    }

    public java.lang.Long getCodCedenteCentraliz() {
        return this.codCedenteCentraliz;
    }

    public void setCodCedenteCentraliz(java.lang.Long codCedenteCentraliz) {
        this.codCedenteCentraliz = codCedenteCentraliz;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoClienteCOCLI() {
        return this.codigoClienteCOCLI;
    }

    public void setCodigoClienteCOCLI(java.lang.Long codigoClienteCOCLI) {
        this.codigoClienteCOCLI = codigoClienteCOCLI;
    }

    public java.lang.Long getCodigoUnidadePVVinc() {
        return this.codigoUnidadePVVinc;
    }

    public void setCodigoUnidadePVVinc(java.lang.Long codigoUnidadePVVinc) {
        this.codigoUnidadePVVinc = codigoUnidadePVVinc;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.Long getCodigounidadeEN() {
        return this.codigounidadeEN;
    }

    public void setCodigounidadeEN(java.lang.Long codigounidadeEN) {
        this.codigounidadeEN = codigounidadeEN;
    }

    public java.lang.String getDescClienteGiroCaixa() {
        return this.descClienteGiroCaixa;
    }

    public void setDescClienteGiroCaixa(java.lang.String descClienteGiroCaixa) {
        this.descClienteGiroCaixa = descClienteGiroCaixa;
    }

    public java.lang.String getDescDestinoExtMov() {
        return this.descDestinoExtMov;
    }

    public void setDescDestinoExtMov(java.lang.String descDestinoExtMov) {
        this.descDestinoExtMov = descDestinoExtMov;
    }

    public java.lang.String getDescDestinoExtMovDebtCredt() {
        return this.descDestinoExtMovDebtCredt;
    }

    public void setDescDestinoExtMovDebtCredt(java.lang.String descDestinoExtMovDebtCredt) {
        this.descDestinoExtMovDebtCredt = descDestinoExtMovDebtCredt;
    }

    public java.lang.String getDescModalidadeTitulo() {
        return this.descModalidadeTitulo;
    }

    public void setDescModalidadeTitulo(java.lang.String descModalidadeTitulo) {
        this.descModalidadeTitulo = descModalidadeTitulo;
    }

    public java.lang.String getDescNatureza() {
        return this.descNatureza;
    }

    public void setDescNatureza(java.lang.String descNatureza) {
        this.descNatureza = descNatureza;
    }

    public java.lang.String getDescPorte() {
        return this.descPorte;
    }

    public void setDescPorte(java.lang.String descPorte) {
        this.descPorte = descPorte;
    }

    public java.lang.String getDescRamoAtividade() {
        return this.descRamoAtividade;
    }

    public void setDescRamoAtividade(java.lang.String descRamoAtividade) {
        this.descRamoAtividade = descRamoAtividade;
    }

    public java.lang.String getDescSetor() {
        return this.descSetor;
    }

    public void setDescSetor(java.lang.String descSetor) {
        this.descSetor = descSetor;
    }

    public java.lang.String getDescTipoCobranca() {
        return this.descTipoCobranca;
    }

    public void setDescTipoCobranca(java.lang.String descTipoCobranca) {
        this.descTipoCobranca = descTipoCobranca;
    }

    public java.lang.String getDescTipoJurosDia() {
        return this.descTipoJurosDia;
    }

    public void setDescTipoJurosDia(java.lang.String descTipoJurosDia) {
        this.descTipoJurosDia = descTipoJurosDia;
    }

    public java.lang.String getDescricaoCriticas() {
        return this.descricaoCriticas;
    }

    public void setDescricaoCriticas(java.lang.String descricaoCriticas) {
        this.descricaoCriticas = descricaoCriticas;
    }

    public java.lang.Long getDestinoExtMov() {
        return this.destinoExtMov;
    }

    public void setDestinoExtMov(java.lang.Long destinoExtMov) {
        this.destinoExtMov = destinoExtMov;
    }

    public java.lang.Long getDestinoExtMovDebtCredt() {
        return this.destinoExtMovDebtCredt;
    }

    public void setDestinoExtMovDebtCredt(java.lang.Long destinoExtMovDebtCredt) {
        this.destinoExtMovDebtCredt = destinoExtMovDebtCredt;
    }

    public java.lang.String getExclusaoAutomatica() {
        return this.exclusaoAutomatica;
    }

    public void setExclusaoAutomatica(java.lang.String exclusaoAutomatica) {
        this.exclusaoAutomatica = exclusaoAutomatica;
    }

    public java.lang.String getExtratoMovDebtCredt() {
        return this.extratoMovDebtCredt;
    }

    public void setExtratoMovDebtCredt(java.lang.String extratoMovDebtCredt) {
        this.extratoMovDebtCredt = extratoMovDebtCredt;
    }

    public java.lang.String getExtratoMovTit() {
        return this.extratoMovTit;
    }

    public void setExtratoMovTit(java.lang.String extratoMovTit) {
        this.extratoMovTit = extratoMovTit;
    }

    public java.lang.Integer getUltimaGuiaCadastrada() {
        return this.ultimaGuiaCadastrada;
    }

    public void setUltimaGuiaCadastrada(java.lang.Integer guia) {
        this.ultimaGuiaCadastrada = guia;
    }

    public java.lang.String getInventarioMes() {
        return this.inventarioMes;
    }

    public void setInventarioMes(java.lang.String inventarioMes) {
        this.inventarioMes = inventarioMes;
    }

    public java.lang.Long getModalidadeTitulo() {
        return this.modalidadeTitulo;
    }

    public void setModalidadeTitulo(java.lang.Long modalidadeTitulo) {
        this.modalidadeTitulo = modalidadeTitulo;
    }

    public Percentual getMulta() {
        return this.multa;
    }

    public void setMulta(Percentual multa) {
        this.multa = multa;
    }

    public java.lang.Long getNatureza() {
        return this.natureza;
    }

    public void setNatureza(java.lang.Long natureza) {
        this.natureza = natureza;
    }

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public Percentual getPercentualJurosDia() {
        return this.percentualJurosDia;
    }

    public void setPercentualJurosDia(Percentual percentualJurosDia) {
        this.percentualJurosDia = percentualJurosDia;
    }

    public java.lang.Long getPorte() {
        return this.porte;
    }

    public void setPorte(java.lang.Long porte) {
        this.porte = porte;
    }

    public java.lang.Long getPrazoDevolucao() {
        return this.prazoDevolucao;
    }

    public void setPrazoDevolucao(java.lang.Long prazoDevolucao) {
        this.prazoDevolucao = prazoDevolucao;
    }

    public java.lang.Long getPrazoMulta() {
        return this.prazoMulta;
    }

    public void setPrazoMulta(java.lang.Long prazoMulta) {
        this.prazoMulta = prazoMulta;
    }

    public java.lang.Long getPrazoProtesto() {
        return this.prazoProtesto;
    }

    public void setPrazoProtesto(java.lang.Long prazoProtesto) {
        this.prazoProtesto = prazoProtesto;
    }

    public java.lang.String getProtestoAutomatico() {
        return this.protestoAutomatico;
    }

    public void setProtestoAutomatico(java.lang.String protestoAutomatico) {
        this.protestoAutomatico = protestoAutomatico;
    }

    public java.lang.Long getRamoAtividade() {
        return this.ramoAtividade;
    }

    public void setRamoAtividade(java.lang.Long ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    public java.lang.String getRecebimentoCheque() {
        return this.recebimentoCheque;
    }

    public void setRecebimentoCheque(java.lang.String recebimentoCheque) {
        this.recebimentoCheque = recebimentoCheque;
    }

    public java.lang.Long getSetor() {
        return this.setor;
    }

    public void setSetor(java.lang.Long setor) {
        this.setor = setor;
    }

    public java.lang.String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(java.lang.String situacao) {
        this.situacao = situacao;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoCobranca() {
        return this.tipoCobranca;
    }

    public void setTipoCobranca(java.lang.Long tipoCobranca) {
        this.tipoCobranca = tipoCobranca;
    }

    public java.lang.String getTipoConsulta() {
        return this.tipoConsulta;
    }
    
    public java.lang.String getRetencaoIOF() {
        return this.retencaoIOF;
    }

    public void setRetencaoIOF(java.lang.String retencaoIOF) {
        this.retencaoIOF = retencaoIOF;
    }
    
    public java.lang.String getValorDiferenciado() {
        return this.valorDiferenciado;
    }

    public void setValorDiferenciado(java.lang.String valorDiferenciado) {
        this.valorDiferenciado = valorDiferenciado;
    }
    
    public Long getAtividade() {
        return this.atividade;
    }

    public void setAtividade(Long atividade) {
        this.atividade = atividade;
    }
    

    public void setTipoConsulta(java.lang.String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public java.lang.Long getTipoJurosDia() {
        return this.tipoJurosDia;
    }

    public void setTipoJurosDia(java.lang.Long tipoJurosDia) {
        this.tipoJurosDia = tipoJurosDia;
    }

    public Long getCodRedeTransmissao() {
        return this.codRedeTransmissao;
    }

    public void setCodRedeTransmissao(java.lang.Long codRedeTransmissao) {
        this.codRedeTransmissao = codRedeTransmissao;
    }

    public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public String getModeloCalculo() {
		return modeloCalculo;
	}

	public void setModeloCalculo(String modeloCalculo) {
		this.modeloCalculo = modeloCalculo;
	}
	
	

	public java.lang.Long getCodigoSINCE() {
		return codigoSINCE;
	}

	public void setCodigoSINCE(java.lang.Long codigoSINCE) {
		this.codigoSINCE = codigoSINCE;
	}

	// ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    public java.lang.String getCodigoCedenteCentralizadorFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codCedenteCentraliz);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigounidadeENFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigounidadeEN);
        return codigoUnidadeFormatado;
    }

    public java.lang.String getCodigoUnidadePVVincFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePVVinc);
        return codigoUnidadeFormatado;
    }

    
    
    public String getCedentePEC() {
		return cedentePEC;
	}

	public void setCedentePEC(String cedentePEC) {
		this.cedentePEC = cedentePEC;
	}

	public Long getCedenteVinculo() {
		return cedenteVinculo;
	}

	public void setCedenteVinculo(Long cedenteVinculo) {
		this.cedenteVinculo = cedenteVinculo;
	}
	
	

	public String getDataPEC() {
		return dataPEC;
	}

	public void setDataPEC(String dataPEC) {
		this.dataPEC = dataPEC;
	}

	// fim-------------getCodigoUnidadeFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedenteGeralBean other = (CedenteGeralBean) obj;
            result = result
                     && equals(getBancoCorrespondente(),
                             other.getBancoCorrespondente());
            result = result
                     && equals(getBancoSacados(), other.getBancoSacados());
            result = result
                     && equals(getClienteExterno(), other.getClienteExterno());
            result = result
                     && equals(getClienteGiroCaixa(),
                             other.getClienteGiroCaixa());
            result = result
                     && equals(getClienteSINCE(), other.getClienteSINCE());
            result = result
                     && equals(getCobrancaSemBloqueto(),
                             other.getCobrancaSemBloqueto());
            result = result
                     && equals(getCodCedenteCentraliz(),
                             other.getCodCedenteCentraliz());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoClienteCOCLI(),
                             other.getCodigoClienteCOCLI());
            result = result
                     && equals(getCodigoUnidadePVVinc(),
                             other.getCodigoUnidadePVVinc());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getCodigounidadeEN(), other.getCodigounidadeEN());
            result = result
                     && equals(getDescClienteGiroCaixa(),
                             other.getDescClienteGiroCaixa());
            result = result
                     && equals(getDescDestinoExtMov(),
                             other.getDescDestinoExtMov());
            result = result
                     && equals(getDescDestinoExtMovDebtCredt(),
                             other.getDescDestinoExtMovDebtCredt());
            result = result
                     && equals(getDescModalidadeTitulo(),
                             other.getDescModalidadeTitulo());
            result = result
                     && equals(getDescNatureza(), other.getDescNatureza());
            result = result && equals(getDescPorte(), other.getDescPorte());
            result = result
                     && equals(getDescRamoAtividade(),
                             other.getDescRamoAtividade());
            result = result && equals(getDescSetor(), other.getDescSetor());
            result = result
                     && equals(getDescTipoCobranca(),
                             other.getDescTipoCobranca());
            result = result
                     && equals(getDescTipoJurosDia(),
                             other.getDescTipoJurosDia());
            result = result
                     && equals(getDescricaoCriticas(),
                             other.getDescricaoCriticas());
            result = result
                     && equals(getDestinoExtMov(), other.getDestinoExtMov());
            result = result
                     && equals(getDestinoExtMovDebtCredt(),
                             other.getDestinoExtMovDebtCredt());
            result = result
                     && equals(getExclusaoAutomatica(),
                             other.getExclusaoAutomatica());
            result = result
                     && equals(getExtratoMovDebtCredt(),
                             other.getExtratoMovDebtCredt());
            result = result
                     && equals(getExtratoMovTit(), other.getExtratoMovTit());
            result = result
                     && equals(getUltimaGuiaCadastrada(),
                             other.getUltimaGuiaCadastrada());
            result = result
                     && equals(getInventarioMes(), other.getInventarioMes());
            result = result
                     && equals(getModalidadeTitulo(),
                             other.getModalidadeTitulo());
            result = result && equals(getMulta(), other.getMulta());
            result = result && equals(getNatureza(), other.getNatureza());
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result
                     && equals(getPercentualJurosDia(),
                             other.getPercentualJurosDia());
            result = result && equals(getPorte(), other.getPorte());
            result = result
                     && equals(getPrazoDevolucao(), other.getPrazoDevolucao());
            result = result && equals(getPrazoMulta(), other.getPrazoMulta());
            result = result
                     && equals(getPrazoProtesto(), other.getPrazoProtesto());
            result = result
                     && equals(getProtestoAutomatico(),
                             other.getProtestoAutomatico());
            result = result
                     && equals(getRamoAtividade(), other.getRamoAtividade());
            result = result
                     && equals(getRecebimentoCheque(),
                             other.getRecebimentoCheque());
            result = result && equals(getSetor(), other.getSetor());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoCobranca(), other.getTipoCobranca());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result
            		 && equals(getRetencaoIOF(), other.getRetencaoIOF());
            result = result
	 			 && equals(getValorDiferenciado(), other.getValorDiferenciado());
            result = result
   		 			 && equals(getAtividade(), other.getAtividade());
            result = result
                     && equals(getTipoJurosDia(), other.getTipoJurosDia());
            result = result
                     && equals(getCodRedeTransmissao(),
                             other.getCodRedeTransmissao());
            result = result && equals(getModeloCalculo(), other.getModeloCalculo());
            result = result && equals(getAutorizacao(), other.getAutorizacao());
            result = result && equals(getCodigoSINCE(), other.getCodigoSINCE());
            result = result && equals(getEnvioSMS(),other.getEnvioSMS());
            result = result && equals(getCedentePEC(),other.getCedentePEC());
            result = result && equals(getCedenteVinculo(),other.getCedenteVinculo());
            result = result && equals(getDataPEC(),other.getDataPEC());
            result = result && equals(getPvVincAnt(),other.getPvVincAnt());
            result = result && equals(getDtAltPvVinc(),other.getDtAltPvVinc());
            result = result && equals(getCedSemRegistro(),other.getCedSemRegistro());
            result = result && equals(getTipoInscricao(),other.getTipoInscricao());
            result = result && equals(getCpfCnpj(),other.getCpfCnpj());
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
        properties.add(new Property("bancoCorrespondente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("bancoSacados",
                StringType.create(),
                false,
                true));
        properties.add(new Property("clienteExterno",
                StringType.create(),
                false,
                true));
        properties.add(new Property("clienteGiroCaixa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("clienteSINCE",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cobrancaSemBloqueto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codCedenteCentraliz",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codRedeTransmissao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoClienteCOCLI",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePVVinc",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigounidadeEN",
                LongType.create(),
                false,
                true));
        properties.add(new Property("descClienteGiroCaixa",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descDestinoExtMov",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descDestinoExtMovDebtCredt",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descModalidadeTitulo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descNatureza",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descPorte",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descRamoAtividade",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descSetor",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descTipoCobranca",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descTipoJurosDia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricaoCriticas",
                StringType.create(),
                false,
                true));
        properties.add(new Property("destinoExtMov",
                LongType.create(),
                false,
                true));
        properties.add(new Property("destinoExtMovDebtCredt",
                LongType.create(),
                false,
                true));
        properties.add(new Property("exclusaoAutomatica",
                StringType.create(),
                false,
                true));
        properties.add(new Property("extratoMovDebtCredt",
                StringType.create(),
                false,
                true));
        properties.add(new Property("extratoMovTit",
                StringType.create(),
                false,
                true));
        properties.add(new Property("inventarioMes",
                StringType.create(),
                false,
                true));
        properties.add(new Property("modalidadeTitulo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("multa",
                PercentualType.create(),
                false,
                true));
        properties.add(new Property("natureza", LongType.create(), false, true));
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("percentualJurosDia",
                PercentualType.create(),
                false,
                true));
        properties.add(new Property("porte", LongType.create(), false, true));
        properties.add(new Property("prazoDevolucao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoMulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoProtesto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("protestoAutomatico",
                StringType.create(),
                false,
                true));
        properties.add(new Property("ramoAtividade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("recebimentoCheque",
                StringType.create(),
                false,
                true));
        properties.add(new Property("setor", LongType.create(), false, true));
        properties.add(new Property("situacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoCobranca",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                StringType.create(),
                false,
                true));
        properties.add(new Property("retencaoIOF",
                StringType.create(),
                false,
                true));
        properties.add(new Property("valorDiferenciado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("atividade",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("tipoJurosDia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("ultimaGuiaCadastrada",
                IntegerType.create(),
                false,
                true));
        properties.add(new Property("autorizacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("modeloCalculo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoSINCE",
                LongType.create(),
                false,
                true));
        properties.add(new Property("envioSMS",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cedentePEC",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataPEC",
                StringType.create(),
                false,
                true));
        properties.add(new Property("pvVincAnt",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("dtAltPvVinc",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cedSemRegistro",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cedenteVinculo",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoInscricao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj",
        		LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedenteGeralBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("bancoCorrespondente", new StringValue("X(01)"));
        Mainframe.put("bancoSacados", new StringValue("X(01)"));
        Mainframe.put("clienteExterno", new StringValue("X(01)"));
        Mainframe.put("clienteGiroCaixa", new LongValue("9(01)"));
        Mainframe.put("clienteSINCE", new StringValue("X(01)"));
        Mainframe.put("cobrancaSemBloqueto", new StringValue("X(01)"));
        Mainframe.put("codCedenteCentraliz", new LongValue("9(07)"));
        Mainframe.put("codRedeTransmissao", new LongValue("9(04)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("codigoClienteCOCLI", new LongValue("9(13)"));
        Mainframe.put("codigoUnidadePVVinc", new LongValue("9(04)"));
        Mainframe.put("codigoUsuario", new StringValue("X(07)"));
        Mainframe.put("codigounidadeEN", new LongValue("9(04)"));
        Mainframe.put("descClienteGiroCaixa", new StringValue("X(40)"));
        Mainframe.put("descDestinoExtMov", new StringValue("X(40)"));
        Mainframe.put("descDestinoExtMovDebtCredt", new StringValue("X(40)"));
        Mainframe.put("descModalidadeTitulo", new StringValue("X(40)"));
        Mainframe.put("descNatureza", new StringValue("X(40)"));
        Mainframe.put("descPorte", new StringValue("X(40)"));
        Mainframe.put("descRamoAtividade", new StringValue("X(40)"));
        Mainframe.put("descSetor", new StringValue("X(40)"));
        Mainframe.put("descTipoCobranca", new StringValue("X(40)"));
        Mainframe.put("descTipoJurosDia", new StringValue("X(40)"));
        Mainframe.put("descricaoCriticas", new StringValue("X(200)"));
        Mainframe.put("destinoExtMov", new LongValue("9(02)"));
        Mainframe.put("destinoExtMovDebtCredt", new LongValue("9(02)"));
        Mainframe.put("exclusaoAutomatica", new StringValue("X(01)"));
        Mainframe.put("extratoMovDebtCredt", new StringValue("X(01)"));
        Mainframe.put("extratoMovTit", new StringValue("X(01)"));
        Mainframe.put("inventarioMes", new StringValue("X(01)"));
        Mainframe.put("modalidadeTitulo", new LongValue("9(01)"));
        Mainframe.put("multa", new PercentualValue("9(05)"));
        Mainframe.put("natureza", new LongValue("9(02)"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("percentualJurosDia", new PercentualValue("9(05)"));
        Mainframe.put("porte", new LongValue("9(02)"));
        Mainframe.put("prazoDevolucao", new LongValue("9(03)"));
        Mainframe.put("prazoMulta", new LongValue("9(03)"));
        Mainframe.put("prazoProtesto", new LongValue("9(03)"));
        Mainframe.put("protestoAutomatico", new StringValue("X(01)"));
        Mainframe.put("ramoAtividade", new LongValue("9(04)"));
        Mainframe.put("recebimentoCheque", new StringValue("X(01)"));
        Mainframe.put("retencaoIOF", new StringValue("X(01)"));
        Mainframe.put("valorDiferenciado", new StringValue("X(01)"));
        Mainframe.put("atividade", new LongValue("9(01)"));
        Mainframe.put("setor", new LongValue("9(02)"));
        Mainframe.put("situacao", new StringValue("X(01)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("tipoCobranca", new LongValue("9(01)"));
        Mainframe.put("tipoConsulta", new StringValue("X(01)"));
        Mainframe.put("tipoJurosDia", new LongValue("9(01)"));
        Mainframe.put("ultimaGuiaCadastrada", new IntegerValue("9(02)"));
        Mainframe.put("autorizacao", new StringValue("X(01)"));
        Mainframe.put("modeloCalculo", new StringValue("X(02)"));
        Mainframe.put("envioSMS", new StringValue("X(01)"));
        Mainframe.put("codigoSINCE", new LongValue("9(09)"));
        Mainframe.put("cedentePEC", new StringValue("X(01)"));
        Mainframe.put("cedenteVinculo", new LongValue("9(07)"));
        Mainframe.put("dataPEC", new StringValue("X(10)"));
        Mainframe.put("pvVincAnt", new StringValue("X(04)"));
        Mainframe.put("dtAltPvVinc", new StringValue("X(10)"));
        Mainframe.put("cedSemRegistro", new StringValue("X(01)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("tipoInscricao", new StringValue("X(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }

    public ArrayList getListaRamos() {
        return listaRamos;
    }

    public void setListaRamos(ArrayList list) {
        listaRamos = list;
    }

    public static void main(String[] args) {
    }
}
