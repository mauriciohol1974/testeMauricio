//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import java.util.Date;

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
import br.com.politec.sao.iso.values.PercentualValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class SolicitacaoAgendamentoBean extends SigcbBean {
    private java.lang.String aceite;

    private java.lang.String aceiteTexto;

    private java.lang.String agendamentoPermanente;

    private java.lang.Long codigoBancoSacado;

    private java.lang.Long codigoCedente;

    private java.lang.String codigoUsuario;

    private java.util.Date dataDesconto1;

    private java.util.Date dataDesconto2;

    private java.util.Date dataDesconto3;

    private java.util.Date dataMulta;

    private java.util.Date dataSolicitacao;

    private java.util.Date dataVencimento;

    private java.lang.Long diaEmissao;

    private java.lang.Long diaVencimento;

    private java.lang.String endosso;

    private java.lang.Long envioBloqueto;

    private java.lang.String envioBloquetoTexto;

    private java.lang.Long especie;

    private java.lang.String especieTexto;

    private java.lang.Long formaEmissao;

    private java.lang.Long formaObtencaoBloqueto;

    private java.lang.Long formaObtencaoValor;

    private java.lang.Long formaVencimento;

    private java.lang.Long indicadorSolicitacao;

    private java.lang.Long meioEntrada;

    private java.lang.Long moeda;

    private java.lang.Long navegacao;

    private java.lang.String nomeBancoSacado;

    private br.com.politec.sao.util.Percentual percentualDesconto1;

    private br.com.politec.sao.util.Percentual percentualDesconto2;

    private br.com.politec.sao.util.Percentual percentualDesconto3;

    private br.com.politec.sao.util.Percentual percentualJuroMes;

    private br.com.politec.sao.util.Percentual percentualMulta;

    private java.lang.Long prazoDesconto1;

    private java.lang.Long prazoDesconto2;

    private java.lang.Long prazoDesconto3;

    private java.lang.Long prazoMulta;

    private java.lang.Long prazoProtestoDevolucao;

    private java.lang.String protestoAutomatico;

    private java.lang.String registro;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoJuroDia;

    private java.lang.String tipoJuroDiaTexto;

    private br.com.politec.sao.util.Money valorDesconto1;

    private br.com.politec.sao.util.Money valorDesconto2;

    private br.com.politec.sao.util.Money valorDesconto3;

    private br.com.politec.sao.util.Money valorMulta;

    private br.com.politec.sao.util.Money valorSolicitacao;
    
    private String tipoSMS;
    
    private String tipoDesconto;
    private Date dataJuros;
    private br.com.politec.sao.util.Money valorJuros;
    
    private Long prazoJuros;

    public SolicitacaoAgendamentoBean() {
        this.aceite = null;
        this.aceiteTexto = null;
        this.agendamentoPermanente = null;
        this.codigoBancoSacado = null;
        this.codigoCedente = null;
        this.codigoUsuario = null;
        this.dataDesconto1 = null;
        this.dataDesconto2 = null;
        this.dataDesconto3 = null;
        this.dataMulta = null;
        this.dataSolicitacao = null;
        this.dataVencimento = null;
        this.diaEmissao = null;
        this.diaVencimento = null;
        this.endosso = null;
        this.envioBloqueto = null;
        this.envioBloquetoTexto = null;
        this.especie = null;
        this.especieTexto = null;
        this.formaEmissao = null;
        this.formaObtencaoBloqueto = null;
        this.formaObtencaoValor = null;
        this.formaVencimento = null;
        this.indicadorSolicitacao = null;
        this.meioEntrada = null;
        this.moeda = null;
        this.navegacao = null;
        this.nomeBancoSacado = null;
        this.percentualDesconto1 = null;
        this.percentualDesconto2 = null;
        this.percentualDesconto3 = null;
        this.percentualJuroMes = null;
        this.percentualMulta = null;
        this.prazoDesconto1 = null;
        this.prazoDesconto2 = null;
        this.prazoDesconto3 = null;
        this.prazoMulta = null;
        this.prazoProtestoDevolucao = null;
        this.protestoAutomatico = null;
        this.registro = null;
        this.tipoAcao = null;
        this.tipoJuroDia = null;
        this.tipoJuroDiaTexto = null;
        this.valorDesconto1 = null;
        this.valorDesconto2 = null;
        this.valorDesconto3 = null;
        this.valorMulta = null;
        this.valorSolicitacao = null;
        this.tipoSMS=null;
        this.tipoDesconto=null;
        this.valorJuros=null;
        this.dataJuros=null;
        this.prazoJuros=null;
    }

    public String getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public Date getDataJuros() {
		return dataJuros;
	}

	public void setDataJuros(Date dataJuros) {
		this.dataJuros = dataJuros;
	}

	public br.com.politec.sao.util.Money getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(br.com.politec.sao.util.Money valorJuros) {
		this.valorJuros = valorJuros;
	}

	public String getApplicationName() {
        return "SolicitacaoAgendamentoBean";
    }

    public java.lang.String getAceite() {
        return this.aceite;
    }

    public void setAceite(java.lang.String aceite) {
        this.aceite = aceite;
    }

    public java.lang.String getAceiteTexto() {
        return this.aceiteTexto;
    }

    public void setAceiteTexto(java.lang.String aceiteTexto) {
        this.aceiteTexto = aceiteTexto;
    }

    public java.lang.String getAgendamentoPermanente() {
        return this.agendamentoPermanente;
    }

    public void setAgendamentoPermanente(java.lang.String agendamentoPermanente) {
        this.agendamentoPermanente = agendamentoPermanente;
    }

    public java.lang.Long getCodigoBancoSacado() {
        return this.codigoBancoSacado;
    }

    public void setCodigoBancoSacado(java.lang.Long codigoBancoSacado) {
        this.codigoBancoSacado = codigoBancoSacado;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.util.Date getDataDesconto1() {
        return this.dataDesconto1;
    }

    public void setDataDesconto1(java.util.Date dataDesconto1) {
        this.dataDesconto1 = dataDesconto1;
    }

    public java.util.Date getDataDesconto2() {
        return this.dataDesconto2;
    }

    public void setDataDesconto2(java.util.Date dataDesconto2) {
        this.dataDesconto2 = dataDesconto2;
    }

    public java.util.Date getDataDesconto3() {
        return this.dataDesconto3;
    }

    public void setDataDesconto3(java.util.Date dataDesconto3) {
        this.dataDesconto3 = dataDesconto3;
    }

    public java.util.Date getDataMulta() {
        return this.dataMulta;
    }

    public void setDataMulta(java.util.Date dataMulta) {
        this.dataMulta = dataMulta;
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

    public java.lang.Long getDiaEmissao() {
        return this.diaEmissao;
    }

    public void setDiaEmissao(java.lang.Long diaEmissao) {
        this.diaEmissao = diaEmissao;
    }

    public Long getPrazoJuros() {
		return prazoJuros;
	}

	public void setPrazoJuros(Long prazoJuros) {
		this.prazoJuros = prazoJuros;
	}

	public java.lang.Long getDiaVencimento() {
        return this.diaVencimento;
    }

    public void setDiaVencimento(java.lang.Long diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public java.lang.String getEndosso() {
        return this.endosso;
    }

    public void setEndosso(java.lang.String endosso) {
        this.endosso = endosso;
    }

    public java.lang.Long getEnvioBloqueto() {
        return this.envioBloqueto;
    }

    public void setEnvioBloqueto(java.lang.Long envioBloqueto) {
        this.envioBloqueto = envioBloqueto;
    }

    public java.lang.String getEnvioBloquetoTexto() {
        return this.envioBloquetoTexto;
    }

    public void setEnvioBloquetoTexto(java.lang.String envioBloquetoTexto) {
        this.envioBloquetoTexto = envioBloquetoTexto;
    }

    public java.lang.Long getEspecie() {
        return this.especie;
    }

    public void setEspecie(java.lang.Long especie) {
        this.especie = especie;
    }

    public java.lang.String getEspecieTexto() {
        return this.especieTexto;
    }

    public void setEspecieTexto(java.lang.String especieTexto) {
        this.especieTexto = especieTexto;
    }

    public java.lang.Long getFormaEmissao() {
        return this.formaEmissao;
    }

    public void setFormaEmissao(java.lang.Long formaEmissao) {
        this.formaEmissao = formaEmissao;
    }

    public java.lang.Long getFormaObtencaoBloqueto() {
        return this.formaObtencaoBloqueto;
    }

    public void setFormaObtencaoBloqueto(java.lang.Long formaObtencaoBloqueto) {
        this.formaObtencaoBloqueto = formaObtencaoBloqueto;
    }

    public java.lang.Long getFormaObtencaoValor() {
        return this.formaObtencaoValor;
    }

    public void setFormaObtencaoValor(java.lang.Long formaObtencaoValor) {
        this.formaObtencaoValor = formaObtencaoValor;
    }

    public java.lang.Long getFormaVencimento() {
        return this.formaVencimento;
    }

    public void setFormaVencimento(java.lang.Long formaVencimento) {
        this.formaVencimento = formaVencimento;
    }

    public java.lang.Long getIndicadorSolicitacao() {
        return this.indicadorSolicitacao;
    }

    public void setIndicadorSolicitacao(java.lang.Long indicadorSolicitacao) {
        this.indicadorSolicitacao = indicadorSolicitacao;
    }

    public java.lang.Long getMeioEntrada() {
        return this.meioEntrada;
    }

    public void setMeioEntrada(java.lang.Long meioEntrada) {
        this.meioEntrada = meioEntrada;
    }

    public java.lang.Long getMoeda() {
        return this.moeda;
    }

    public void setMoeda(java.lang.Long moeda) {
        this.moeda = moeda;
    }

    public java.lang.Long getNavegacao() {
        return this.navegacao;
    }

    public void setNavegacao(java.lang.Long navegacao) {
        this.navegacao = navegacao;
    }

    public java.lang.String getNomeBancoSacado() {
        return this.nomeBancoSacado;
    }

    public void setNomeBancoSacado(java.lang.String nomeBancoSacado) {
        this.nomeBancoSacado = nomeBancoSacado;
    }

    public br.com.politec.sao.util.Percentual getPercentualDesconto1() {
        return this.percentualDesconto1;
    }

    public void setPercentualDesconto1(br.com.politec.sao.util.Percentual percentualDesconto1) {
        this.percentualDesconto1 = percentualDesconto1;
    }

    public br.com.politec.sao.util.Percentual getPercentualDesconto2() {
        return this.percentualDesconto2;
    }

    public void setPercentualDesconto2(br.com.politec.sao.util.Percentual percentualDesconto2) {
        this.percentualDesconto2 = percentualDesconto2;
    }

    public br.com.politec.sao.util.Percentual getPercentualDesconto3() {
        return this.percentualDesconto3;
    }

    public void setPercentualDesconto3(br.com.politec.sao.util.Percentual percentualDesconto3) {
        this.percentualDesconto3 = percentualDesconto3;
    }

    public br.com.politec.sao.util.Percentual getPercentualJuroMes() {
        return this.percentualJuroMes;
    }

    public void setPercentualJuroMes(br.com.politec.sao.util.Percentual percentualJuroMes) {
        this.percentualJuroMes = percentualJuroMes;
    }

    public br.com.politec.sao.util.Percentual getPercentualMulta() {
        return this.percentualMulta;
    }

    public void setPercentualMulta(br.com.politec.sao.util.Percentual percentualMulta) {
        this.percentualMulta = percentualMulta;
    }

    public java.lang.Long getPrazoDesconto1() {
        return this.prazoDesconto1;
    }

    public void setPrazoDesconto1(java.lang.Long prazoDesconto1) {
        this.prazoDesconto1 = prazoDesconto1;
    }

    public java.lang.Long getPrazoDesconto2() {
        return this.prazoDesconto2;
    }

    public void setPrazoDesconto2(java.lang.Long prazoDesconto2) {
        this.prazoDesconto2 = prazoDesconto2;
    }

    public java.lang.Long getPrazoDesconto3() {
        return this.prazoDesconto3;
    }

    public void setPrazoDesconto3(java.lang.Long prazoDesconto3) {
        this.prazoDesconto3 = prazoDesconto3;
    }

    public java.lang.Long getPrazoMulta() {
        return this.prazoMulta;
    }

    public void setPrazoMulta(java.lang.Long prazoMulta) {
        this.prazoMulta = prazoMulta;
    }

    public java.lang.Long getPrazoProtestoDevolucao() {
        return this.prazoProtestoDevolucao;
    }

    public void setPrazoProtestoDevolucao(java.lang.Long prazoProtestoDevolucao) {
        this.prazoProtestoDevolucao = prazoProtestoDevolucao;
    }

    public java.lang.String getProtestoAutomatico() {
        return this.protestoAutomatico;
    }

    public void setProtestoAutomatico(java.lang.String protestoAutomatico) {
        this.protestoAutomatico = protestoAutomatico;
    }

    public java.lang.String getRegistro() {
        return this.registro;
    }

    public void setRegistro(java.lang.String registro) {
        this.registro = registro;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoJuroDia() {
        return this.tipoJuroDia;
    }

    public void setTipoJuroDia(java.lang.Long tipoJuroDia) {
        this.tipoJuroDia = tipoJuroDia;
    }

    public java.lang.String getTipoJuroDiaTexto() {
        return this.tipoJuroDiaTexto;
    }

    public void setTipoJuroDiaTexto(java.lang.String tipoJuroDiaTexto) {
        this.tipoJuroDiaTexto = tipoJuroDiaTexto;
    }

    public br.com.politec.sao.util.Money getValorDesconto1() {
        return this.valorDesconto1;
    }

    public void setValorDesconto1(br.com.politec.sao.util.Money valorDesconto1) {
        this.valorDesconto1 = valorDesconto1;
    }

    public br.com.politec.sao.util.Money getValorDesconto2() {
        return this.valorDesconto2;
    }

    public void setValorDesconto2(br.com.politec.sao.util.Money valorDesconto2) {
        this.valorDesconto2 = valorDesconto2;
    }

    public br.com.politec.sao.util.Money getValorDesconto3() {
        return this.valorDesconto3;
    }

    public void setValorDesconto3(br.com.politec.sao.util.Money valorDesconto3) {
        this.valorDesconto3 = valorDesconto3;
    }

    public br.com.politec.sao.util.Money getValorMulta() {
        return this.valorMulta;
    }

    public void setValorMulta(br.com.politec.sao.util.Money valorMulta) {
        this.valorMulta = valorMulta;
    }

    public br.com.politec.sao.util.Money getValorSolicitacao() {
        return this.valorSolicitacao;
    }

    public void setValorSolicitacao(br.com.politec.sao.util.Money valorSolicitacao) {
        this.valorSolicitacao = valorSolicitacao;
    }
    
    

    public String getTipoSMS() {
		return tipoSMS;
	}

	public void setTipoSMS(String tipoSMS) {
		this.tipoSMS = tipoSMS;
	}

	// -----------------------INICIO DAS
    // CUSTOMIZAÇÕES-----------------------------------------
    public java.lang.String getIndicadorSolicitacaoTexto() {
        String texto = "";

        switch (getIndicadorSolicitacao().intValue()) {
        case 6:
            texto = "SOLICITACAO";
            break;
        case 7:
            texto = "AGENDAMENTO";
            break;
        case 600:
            texto = "SOLICITACAO PROC.";
            break;
        case 700:
            texto = "AGENDAMENTO PROC.";
            break;
        }
        return texto;
    }

    public java.lang.String getIndicadorSolicitacaoTextoInfinitivo() {
        String texto = "";

        switch (getIndicadorSolicitacao().intValue()) {
        case 6:
            texto = "Solicitar";
            break;
        case 7:
            texto = "Agendar";
            break;
        }
        return texto;
    }

    public java.lang.String getDataSolicitacaoFormatada() {
        if (this.dataSolicitacao != null) {
            return Formatador.formatarData(this.dataSolicitacao);
        } else {
            return "";
        }
    }

    public java.lang.String getDataVencimentoFormatada() {
        if (this.dataVencimento != null) {
            return Formatador.formatarData(this.dataVencimento);
        } else {
            return "";
        }
    }

    public java.lang.String getDataDesconto1Formatada() {
        if (this.dataDesconto1 != null) {
            return Formatador.formatarData(this.dataDesconto1);
        } else {
            return "";
        }
    }

    public java.lang.String getDataDesconto2Formatada() {
        if (this.dataDesconto2 != null) {
            return Formatador.formatarData(this.dataDesconto2);
        } else {
            return "";
        }
    }

    public java.lang.String getDataDesconto3Formatada() {
        if (this.dataDesconto3 != null) {
            return Formatador.formatarData(this.dataDesconto3);
        } else {
            return "";
        }
    }

    public java.lang.String getDataMultaFormatada() {
        if (this.dataMulta != null) {
            return Formatador.formatarData(this.dataMulta);
        } else {
            return "";
        }
    }
    
    public java.lang.String getDataJurosFormatada() {
        if (this.dataJuros != null) {
            return Formatador.formatarData(this.dataJuros);
        } else {
            return "";
        }
    }

    public java.lang.String getMoedaTexto() {
        String moedaTexto = "";

        switch (getMoeda().intValue()) {
        case 9:
            moedaTexto = "REAL";
            break;
        }
        return moedaTexto;
    }

    public java.lang.String getFormaObtencaoValorTexto() {
        String texto = "";

        switch (getFormaObtencaoValor().intValue()) {
        case 1:
            // texto = "BANCO DE SACADOS";
            texto = "INFORMADO PELO USUARIO";
            break;
        case 2:
            // texto = "SACADO";
            texto = "BANCO DE SACADOS";
            break;
        }
        return texto;
    }

    public java.lang.String getFormaObtencaoBloquetoTexto() {
        String texto = "";

        switch (getFormaObtencaoBloqueto().intValue()) {
        case 1:
            // texto = "BANCO DE SACADOS";
            texto = "INFORMADO PELO USUARIO";
            break;
        case 2:
            // texto = "SACADO";
            texto = "BANCO DE SACADOS";
            break;
        }
        return texto;
    }

    public java.lang.String getFormaVencimentoTexto() {
        String texto = "";

        switch (getFormaVencimento().intValue()) {
        case 1:
            texto = "ANTECIPA";
            break;
        case 2:
            texto = "POSTERGA";
            break;
        case 3:
            texto = "MANTEM";
            break;
        }
        return texto;
    }

    public java.lang.String getFormaEmissaoTexto() {
        String texto = "";

        switch (getFormaEmissao().intValue()) {
        case 1:
            texto = "ANTECIPA";
            break;
        case 2:
            texto = "POSTERGA";
            break;
        }
        return texto;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // -----------------------TÉRMINO DAS
    // CUSTOMIZAÇÕES----------------------------------------

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            SolicitacaoAgendamentoBean other = (SolicitacaoAgendamentoBean) obj;
            result = result && equals(getAceite(), other.getAceite());
            result = result && equals(getAceiteTexto(), other.getAceiteTexto());
            result = result
                     && equals(getAgendamentoPermanente(),
                             other.getAgendamentoPermanente());
            result = result
                     && equals(getCodigoBancoSacado(),
                             other.getCodigoBancoSacado());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getDataDesconto1(), other.getDataDesconto1());
            result = result
                     && equals(getDataDesconto2(), other.getDataDesconto2());
            result = result
                     && equals(getDataDesconto3(), other.getDataDesconto3());
            result = result && equals(getDataMulta(), other.getDataMulta());
            result = result
                     && equals(getDataSolicitacao(), other.getDataSolicitacao());
            result = result
                     && equals(getDataVencimento(), other.getDataVencimento());
            result = result && equals(getDiaEmissao(), other.getDiaEmissao());
            result = result
                     && equals(getDiaVencimento(), other.getDiaVencimento());
            result = result && equals(getEndosso(), other.getEndosso());
            result = result
                     && equals(getEnvioBloqueto(), other.getEnvioBloqueto());
            result = result
                     && equals(getEnvioBloquetoTexto(),
                             other.getEnvioBloquetoTexto());
            result = result && equals(getEspecie(), other.getEspecie());
            result = result
                     && equals(getEspecieTexto(), other.getEspecieTexto());
            result = result
                     && equals(getFormaEmissao(), other.getFormaEmissao());
            result = result
                     && equals(getFormaObtencaoBloqueto(),
                             other.getFormaObtencaoBloqueto());
            result = result
                     && equals(getFormaObtencaoValor(),
                             other.getFormaObtencaoValor());
            result = result
                     && equals(getFormaVencimento(), other.getFormaVencimento());
            result = result
                     && equals(getIndicadorSolicitacao(),
                             other.getIndicadorSolicitacao());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result && equals(getMoeda(), other.getMoeda());
            result = result && equals(getNavegacao(), other.getNavegacao());
            result = result
                     && equals(getNomeBancoSacado(), other.getNomeBancoSacado());
            result = result
                     && equals(getPercentualDesconto1(),
                             other.getPercentualDesconto1());
            result = result
                     && equals(getPercentualDesconto2(),
                             other.getPercentualDesconto2());
            result = result
                     && equals(getPercentualDesconto3(),
                             other.getPercentualDesconto3());
            result = result
                     && equals(getPercentualJuroMes(),
                             other.getPercentualJuroMes());
            result = result
                     && equals(getPercentualMulta(), other.getPercentualMulta());
            result = result
                     && equals(getPrazoDesconto1(), other.getPrazoDesconto1());
            result = result
                     && equals(getPrazoDesconto2(), other.getPrazoDesconto2());
            result = result
                     && equals(getPrazoDesconto3(), other.getPrazoDesconto3());
            result = result && equals(getPrazoMulta(), other.getPrazoMulta());
            result = result
                     && equals(getPrazoProtestoDevolucao(),
                             other.getPrazoProtestoDevolucao());
            result = result
                     && equals(getProtestoAutomatico(),
                             other.getProtestoAutomatico());
            result = result && equals(getRegistro(), other.getRegistro());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result && equals(getTipoJuroDia(), other.getTipoJuroDia());
            result = result
                     && equals(getTipoJuroDiaTexto(),
                             other.getTipoJuroDiaTexto());
            result = result
                     && equals(getValorDesconto1(), other.getValorDesconto1());
            result = result
                     && equals(getValorDesconto2(), other.getValorDesconto2());
            result = result
                     && equals(getValorDesconto3(), other.getValorDesconto3());
            result = result && equals(getValorMulta(), other.getValorMulta());
            result = result
                     && equals(getValorSolicitacao(),
                             other.getValorSolicitacao());
            
            result = result && equals(getTipoSMS(), other.getTipoSMS());
            result = result && equals(getTipoDesconto(), other.getTipoDesconto());
            result = result && equals(getDataJuros(), other.getDataJuros());
            result = result && equals(getValorJuros(), other.getValorJuros());
            result = result && equals(getPrazoJuros(), other.getPrazoJuros());
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
        properties.add(new Property("aceiteTexto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("agendamentoPermanente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoBancoSacado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataDesconto1",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataDesconto2",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataDesconto3",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataMulta", DateType.create(), false, true));
        properties.add(new Property("dataSolicitacao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataVencimento",
                DateType.create(),
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
        properties.add(new Property("endosso", StringType.create(), false, true));
        properties.add(new Property("envioBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("envioBloquetoTexto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("especie", LongType.create(), false, true));
        properties.add(new Property("especieTexto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("formaEmissao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("formaObtencaoBloqueto",
                LongType.create(),
                false,
                true));
        properties.add(new Property("formaObtencaoValor",
                LongType.create(),
                false,
                true));
        properties.add(new Property("formaVencimento",
                LongType.create(),
                false,
                true));
        properties.add(new Property("indicadorSolicitacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntrada",
                LongType.create(),
                false,
                true));
        properties.add(new Property("moeda", LongType.create(), false, true));
        properties.add(new Property("navegacao", LongType.create(), false, true));
        properties.add(new Property("nomeBancoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("percentualDesconto1",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("percentualDesconto2",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("percentualDesconto3",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("percentualJuroMes",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("percentualMulta",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("prazoDesconto1",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoDesconto2",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoDesconto3",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoMulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("prazoProtestoDevolucao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("protestoAutomatico",
                StringType.create(),
                false,
                true));
        properties.add(new Property("registro",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoJuroDia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoJuroDiaTexto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("valorDesconto1",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorDesconto2",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorDesconto3",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorMulta",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorSolicitacao",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("tipoSMS",
                StringType.create(),
                false,
                true));
        properties.add(new Property("valorJuros",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("tipoDesconto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataJuros",
                DateType.create(),
                false,
                true));
        properties.add(new Property("prazoJuros",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "SolicitacaoAgendamentoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("dataDesconto1", new DateValue("dd.MM.yyyy"));
        Mainframe.put("prazoDesconto3", new LongValue("9(03)"));
        Mainframe.put("prazoDesconto2", new LongValue("9(03)"));
        Mainframe.put("prazoDesconto1", new LongValue("9(03)"));
        Mainframe.put("formaObtencaoBloqueto", new LongValue("9(01)"));
        Mainframe.put("dataMulta", new DateValue("dd.MM.yyyy"));
        Mainframe.put("meioEntrada", new LongValue("9(02)"));
        Mainframe.put("aceiteTexto", new StringValue("X(40)"));
        Mainframe.put("formaVencimento", new LongValue("9(01)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("protestoAutomatico", new StringValue("X(01)"));
        Mainframe.put("codigoBancoSacado", new LongValue("9(03)"));
        Mainframe.put("endosso", new StringValue("X(01)"));
        Mainframe.put("valorDesconto3", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("navegacao", new LongValue("9(01)"));
        Mainframe.put("valorDesconto2", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("dataSolicitacao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valorDesconto1", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("tipoJuroDiaTexto", new StringValue("X(40)"));
        Mainframe.put("aceite", new StringValue("X(01)"));
        Mainframe.put("moeda", new LongValue("9(02)"));
        Mainframe.put("prazoProtestoDevolucao", new LongValue("9(04)"));
        Mainframe.put("agendamentoPermanente", new StringValue("X(01)"));
        Mainframe.put("formaObtencaoValor", new LongValue("9(01)"));
        Mainframe.put("valorSolicitacao", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("percentualMulta", new PercentualValue("9(05)"));
        Mainframe.put("prazoMulta", new LongValue("9(03)"));
        Mainframe.put("dataVencimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("especieTexto", new StringValue("X(40)"));
        Mainframe.put("especie", new LongValue("9(02)"));
        Mainframe.put("tipoJuroDia", new LongValue("9(01)"));
        Mainframe.put("indicadorSolicitacao", new LongValue("9(03)"));
        Mainframe.put("envioBloqueto", new LongValue("9(02)"));
        Mainframe.put("nomeBancoSacado", new StringValue("X(20)"));
        Mainframe.put("envioBloquetoTexto", new StringValue("X(40)"));
        Mainframe.put("diaVencimento", new LongValue("9(02)"));
        Mainframe.put("diaEmissao", new LongValue("9(02)"));
        Mainframe.put("percentualDesconto3", new PercentualValue("9(05)"));
        Mainframe.put("percentualDesconto2", new PercentualValue("9(05)"));
        Mainframe.put("formaEmissao", new LongValue("9(01)"));
        Mainframe.put("percentualDesconto1", new PercentualValue("9(05)"));
        Mainframe.put("percentualJuroMes", new PercentualValue("9(05)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("valorMulta", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("dataDesconto3", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataDesconto2", new DateValue("dd.MM.yyyy"));
        Mainframe.put("registro", new StringValue("X(01)"));
        Mainframe.put("tipoSMS", new StringValue("X(02)"));
        Mainframe.put("tipoDesconto", new StringValue("X(01)"));
        Mainframe.put("dataJuros", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valorJuros", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("prazoJuros", new LongValue("9(03)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
