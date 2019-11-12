//Bean alterado manualmente - Cuidado ao gerar
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
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.util.Formatador;

public class LiquidacoesSTRBean extends SigcbBean {
  
    private Long opcao;
    private Long cedenteOrigem;
    private Long bancoOrigem;
    private Long agenciaOrigem;
    private Long qtdeTitulos;
    private Long nnEnvio;
    private Long codDevolucaoEnvio;
    private String dataRecebimento;
    private String banco;
    private String agencia;
    private String horaRecebimento;
    private String sequencial;
    private String cedente;
    private String nossoNumero;
    private String codErro;
    private String descErro;
    private Long pagina;
    private String descOpcao;
    private br.com.politec.sao.util.Money valorRecebido;
    
    
    private String nomeCedente; 
    private String tipoPessoaCedente;
    private String cpfCnpjCedente;
    private String tipoPessoaSacado;
    private String cpfCnpjSacado;
    private String codCanal;
    private String descCanal;
    private br.com.politec.sao.util.Money valorDocumento;
    private String dataMovimento;
    private br.com.politec.sao.util.Money valorDescAbatimento;
    private String codFormaRecebimento;
    private br.com.politec.sao.util.Money valorJuros;
    private String nsuSIGCB;
    private br.com.politec.sao.util.Money valorMulta;
    private String nsuSITRC;
    private br.com.politec.sao.util.Money valorAcrescimo;
    private String nsuBACEN;
    private String dthrBACEN;
    private String codBarras;
    private String tpBarras;
    private String codMensagem;
    private String icTransfere;
    private String descricaoErro;
    private String cdSituacaoAnterior;
    private String dthrSituacaoAnterior;
    private String cdSituacaoAtual;
    private String dthrSituacaoAtual;
    private String codDevolucao;
    private String cedenteCorrigido;
    private String nossoNumeroCorrigido;
    private String acaoExecutar;
    private String dataVencimento;
    private String descCodDevolucao;
    private String msgRetorno;
    
    private Date dataPesq;
    private Date dataPesqFinal;
    
    private String coSituacao;
    private String deSituacao;
    
    private br.com.politec.sao.util.Money valorDevolvido;
    private String nsuSIGCBRecebimento;
    private String situacaoSPB;
    private String dthrSituacaoSPB;
    private String formaRetornoDev;
    
    private String deSituacaoAnterior;
    private String deSituacaoAtual;
    
    private String coUsuario;
    
    private String usuarioAnterior;
    private String usuarioAtual;
    
    private String nsuSITRCRecebimento;
    private String codRetSITRC;
    
    private Long ISPBOrigem;
    
    
    

    public LiquidacoesSTRBean() {
        this.opcao = null;
        this.cedenteOrigem = null;
        this.bancoOrigem = null;
        this.agenciaOrigem = null;
        this.qtdeTitulos = null;
        this.dataRecebimento = null;
        this.banco = null;
        this.agencia = null;
        this.horaRecebimento = null;
        this.sequencial = null;
        this.cedente = null;
        this.nossoNumero = null;
        this.codErro = null;
        this.descErro = null;
    	this.valorRecebido = null;
    	this.descOpcao = null;
    	this.pagina = null;
    	
    	
		this.nomeCedente = null; 
	    this.tipoPessoaCedente = null;
	    this.cpfCnpjCedente = null;
	    this.tipoPessoaSacado = null;
	    this.cpfCnpjSacado = null;
	    this.codCanal = null;
	    this.descCanal = null;
	    this.valorDocumento = null;
	    this.dataMovimento = null;
	    this.valorDescAbatimento = null;
	    this.codFormaRecebimento = null;
	    this.valorJuros = null;
	    this.nsuSIGCB = null;
	    this.valorMulta = null;
	    this.nsuSITRC = null;
	    this.valorAcrescimo = null;
	    this.nsuBACEN = null;
	    this.dthrBACEN = null;
	    this.codBarras = null;
	    this.tpBarras = null;
	    this.codMensagem = null;
	    this.icTransfere = null;
	    this.descricaoErro = null;
	    this.cdSituacaoAnterior = null;
	    this.dthrSituacaoAnterior = null;
	    this.cdSituacaoAtual = null;
	    this.dthrSituacaoAtual = null;
	    this.codDevolucao = null;
	    this.cedenteCorrigido = null;
	    this.nossoNumeroCorrigido = null;
	    
	    this.acaoExecutar = null;
    	
        this.dataVencimento=null;
        this.descCodDevolucao=null;
        
        this.msgRetorno = null;
        
        this.dataPesq = null;
        
        this.coSituacao=null;
        this.deSituacao=null;
        this.valorDevolvido = null;
        this.nsuSIGCBRecebimento=null;
        this.situacaoSPB=null;
        this.formaRetornoDev=null;
        this.dthrSituacaoSPB = null;
        
        this.deSituacaoAnterior=null;
        this.deSituacaoAtual=null;
        
        this.coUsuario=null;
        this.nnEnvio=null;
        this.codDevolucaoEnvio=null;
        this.dataPesqFinal= null;
        
        this.usuarioAnterior=null;
        this.usuarioAtual=null;
        this.nsuSITRCRecebimento=null;
        this.codRetSITRC=null;
        this.ISPBOrigem=null;
    }

    public String getApplicationName() {
        return "LiquidacoesRejeitadaBean";
    }

    public br.com.politec.sao.util.Money getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(br.com.politec.sao.util.Money valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	

	public String getNsuSITRCRecebimento() {
		return nsuSITRCRecebimento;
	}

	public void setNsuSITRCRecebimento(String nsuSITRCRecebimento) {
		this.nsuSITRCRecebimento = nsuSITRCRecebimento;
	}

	public String getCodRetSITRC() {
		return codRetSITRC;
	}

	public void setCodRetSITRC(String codRetSITRC) {
		this.codRetSITRC = codRetSITRC;
	}

	public Date getDataPesqFinal() {
		return dataPesqFinal;
	}

	public void setDataPesqFinal(Date dataPesqFinal) {
		this.dataPesqFinal = dataPesqFinal;
	}

	public String getDthrSituacaoSPB() {
		return dthrSituacaoSPB;
	}

	public void setDthrSituacaoSPB(String dthrSituacaoSPB) {
		this.dthrSituacaoSPB = dthrSituacaoSPB;
	}

	public Long getOpcao() {
		return opcao;
	}

	public void setOpcao(Long opcao) {
		this.opcao = opcao;
	}

	public Long getCedenteOrigem() {
		return cedenteOrigem;
	}

	public void setCedenteOrigem(Long cedenteOrigem) {
		this.cedenteOrigem = cedenteOrigem;
	}

	public Long getBancoOrigem() {
		return bancoOrigem;
	}

	public void setBancoOrigem(Long bancoOrigem) {
		this.bancoOrigem = bancoOrigem;
	}

	public Long getAgenciaOrigem() {
		return agenciaOrigem;
	}

	public void setAgenciaOrigem(Long agenciaOrigem) {
		this.agenciaOrigem = agenciaOrigem;
	}

	public Long getQtdeTitulos() {
		return qtdeTitulos;
	}

	public void setQtdeTitulos(Long qtdeTitulos) {
		this.qtdeTitulos = qtdeTitulos;
	}

	public String getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public Long getCodDevolucaoEnvio() {
		return codDevolucaoEnvio;
	}

	public void setCodDevolucaoEnvio(Long codDevolucaoEnvio) {
		this.codDevolucaoEnvio = codDevolucaoEnvio;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getHoraRecebimento() {
		return horaRecebimento;
	}

	public void setHoraRecebimento(String horaRecebimento) {
		this.horaRecebimento = horaRecebimento;
	}

	public String getSequencial() {
		return sequencial;
	}

	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}

	public String getCedente() {
		return cedente;
	}

	public void setCedente(String cedente) {
		this.cedente = cedente;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getCodErro() {
		return codErro;
	}

	public void setCodErro(String codErro) {
		this.codErro = codErro;
	}

	public String getDescErro() {
		return descErro;
	}

	public void setDescErro(String descErro) {
		this.descErro = descErro;
	}
	

	public Long getPagina() {
		return pagina;
	}

	public void setPagina(Long pagina) {
		this.pagina = pagina;
	}
	
	public String getDescOpcao() {
		return descOpcao;
	}

	public void setDescOpcao(String descOpcao) {
		this.descOpcao = descOpcao;
	}
	
	
	public String getNomeCedente() {
		return nomeCedente;
	}

	public void setNomeCedente(String nomeCedente) {
		this.nomeCedente = nomeCedente;
	}

	public String getTipoPessoaCedente() {
		return tipoPessoaCedente;
	}

	public void setTipoPessoaCedente(String tipoPessoaCedente) {
		this.tipoPessoaCedente = tipoPessoaCedente;
	}

	public String getCpfCnpjCedente() {
		return cpfCnpjCedente;
	}

	public void setCpfCnpjCedente(String cpfCnpjCedente) {
		this.cpfCnpjCedente = cpfCnpjCedente;
	}

	public String getTipoPessoaSacado() {
		return tipoPessoaSacado;
	}

	public void setTipoPessoaSacado(String tipoPessoaSacado) {
		this.tipoPessoaSacado = tipoPessoaSacado;
	}

	public String getCpfCnpjSacado() {
		return cpfCnpjSacado;
	}

	public void setCpfCnpjSacado(String cpfCnpjSacado) {
		this.cpfCnpjSacado = cpfCnpjSacado;
	}

	public String getCodCanal() {
		return codCanal;
	}

	public void setCodCanal(String codCanal) {
		this.codCanal = codCanal;
	}

	public String getDescCanal() {
		return descCanal;
	}

	public void setDescCanal(String descCanal) {
		this.descCanal = descCanal;
	}

	public br.com.politec.sao.util.Money getValorDocumento() {
		return valorDocumento;
	}

	public void setValorDocumento(br.com.politec.sao.util.Money valorDocumento) {
		this.valorDocumento = valorDocumento;
	}

	public String getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(String dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public br.com.politec.sao.util.Money getValorDescAbatimento() {
		return valorDescAbatimento;
	}

	public void setValorDescAbatimento(
			br.com.politec.sao.util.Money valorDescAbatimento) {
		this.valorDescAbatimento = valorDescAbatimento;
	}

	public String getCodFormaRecebimento() {
		return codFormaRecebimento;
	}

	public void setCodFormaRecebimento(String codFormaRecebimento) {
		this.codFormaRecebimento = codFormaRecebimento;
	}

	public br.com.politec.sao.util.Money getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(br.com.politec.sao.util.Money valorJuros) {
		this.valorJuros = valorJuros;
	}

	public String getNsuSIGCB() {
		return nsuSIGCB;
	}

	public void setNsuSIGCB(String nsuSIGCB) {
		this.nsuSIGCB = nsuSIGCB;
	}

	public br.com.politec.sao.util.Money getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(br.com.politec.sao.util.Money valorMulta) {
		this.valorMulta = valorMulta;
	}

	public String getNsuSITRC() {
		return nsuSITRC;
	}

	public void setNsuSITRC(String nsuSITRC) {
		this.nsuSITRC = nsuSITRC;
	}

	public br.com.politec.sao.util.Money getValorAcrescimo() {
		return valorAcrescimo;
	}

	public void setValorAcrescimo(br.com.politec.sao.util.Money valorAcrescimo) {
		this.valorAcrescimo = valorAcrescimo;
	}

	public String getNsuBACEN() {
		return nsuBACEN;
	}

	public void setNsuBACEN(String nsuBACEN) {
		this.nsuBACEN = nsuBACEN;
	}

	public String getDthrBACEN() {
		return dthrBACEN;
	}

	public void setDthrBACEN(String dthrBACEN) {
		this.dthrBACEN = dthrBACEN;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getTpBarras() {
		return tpBarras;
	}

	public void setTpBarras(String tpBarras) {
		this.tpBarras = tpBarras;
	}

	public String getCodMensagem() {
		return codMensagem;
	}

	public void setCodMensagem(String codMensagem) {
		this.codMensagem = codMensagem;
	}

	public String getIcTransfere() {
		return icTransfere;
	}

	public void setIcTransfere(String icTransfere) {
		this.icTransfere = icTransfere;
	}

	public String getDescricaoErro() {
		return descricaoErro;
	}

	public void setDescricaoErro(String descricaoErro) {
		this.descricaoErro = descricaoErro;
	}

	public String getCdSituacaoAnterior() {
		return cdSituacaoAnterior;
	}

	public void setCdSituacaoAnterior(String cdSituacaoAnterior) {
		this.cdSituacaoAnterior = cdSituacaoAnterior;
	}

	public String getDthrSituacaoAnterior() {
		return dthrSituacaoAnterior;
	}

	public void setDthrSituacaoAnterior(String dthrSituacaoAnterior) {
		this.dthrSituacaoAnterior = dthrSituacaoAnterior;
	}

	public String getCdSituacaoAtual() {
		return cdSituacaoAtual;
	}

	public void setCdSituacaoAtual(String cdSituacaoAtual) {
		this.cdSituacaoAtual = cdSituacaoAtual;
	}

	public String getDthrSituacaoAtual() {
		return dthrSituacaoAtual;
	}

	public void setDthrSituacaoAtual(String dthrSituacaoAtual) {
		this.dthrSituacaoAtual = dthrSituacaoAtual;
	}

	public String getCodDevolucao() {
		return codDevolucao;
	}

	public void setCodDevolucao(String codDevolucao) {
		this.codDevolucao = codDevolucao;
	}

	public String getCedenteCorrigido() {
		return cedenteCorrigido;
	}

	public void setCedenteCorrigido(String cedenteCorrigido) {
		this.cedenteCorrigido = cedenteCorrigido;
	}

	public String getNossoNumeroCorrigido() {
		return nossoNumeroCorrigido;
	}

	public void setNossoNumeroCorrigido(String nossoNumeroCorrigido) {
		this.nossoNumeroCorrigido = nossoNumeroCorrigido;
	}

	public String getAcaoExecutar() {
		return acaoExecutar;
	}

	public void setAcaoExecutar(String acaoExecutar) {
		this.acaoExecutar = acaoExecutar;
	}
	
	

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	
	
	public String getUsuarioAnterior() {
		return usuarioAnterior;
	}

	public void setUsuarioAnterior(String usuarioAnterior) {
		this.usuarioAnterior = usuarioAnterior;
	}

	public String getUsuarioAtual() {
		return usuarioAtual;
	}

	public void setUsuarioAtual(String usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}

	public String getDescCodDevolucao() {
		return descCodDevolucao;
	}

	public void setDescCodDevolucao(String descCodDevolucao) {
		this.descCodDevolucao = descCodDevolucao;
	}
	

	public String getMsgRetorno() {
		return msgRetorno;
	}

	public void setMsgRetorno(String msgRetorno) {
		this.msgRetorno = msgRetorno;
	}
	
	
	
	public Date getDataPesq() {
		return dataPesq;
	}

	public void setDataPesq(Date dataPesq) {
		this.dataPesq = dataPesq;
	}

	public String getCoSituacao() {
		return coSituacao;
	}

	public void setCoSituacao(String coSituacao) {
		this.coSituacao = coSituacao;
	}

	public String getDeSituacao() {
		return deSituacao;
	}

	public void setDeSituacao(String deSituacao) {
		this.deSituacao = deSituacao;
	}

	public br.com.politec.sao.util.Money getValorDevolvido() {
		return valorDevolvido;
	}

	public void setValorDevolvido(br.com.politec.sao.util.Money valorDevolvido) {
		this.valorDevolvido = valorDevolvido;
	}

	public String getNsuSIGCBRecebimento() {
		return nsuSIGCBRecebimento;
	}

	public void setNsuSIGCBRecebimento(String nsuSIGCBRecebimento) {
		this.nsuSIGCBRecebimento = nsuSIGCBRecebimento;
	}

	public String getSituacaoSPB() {
		return situacaoSPB;
	}

	public void setSituacaoSPB(String situacaoSPB) {
		this.situacaoSPB = situacaoSPB;
	}

	public String getFormaRetornoDev() {
		return formaRetornoDev;
	}

	public void setFormaRetornoDev(String formaRetornoDev) {
		this.formaRetornoDev = formaRetornoDev;
	}
	
	

	public String getDeSituacaoAnterior() {
		return deSituacaoAnterior;
	}

	public void setDeSituacaoAnterior(String deSituacaoAnterior) {
		this.deSituacaoAnterior = deSituacaoAnterior;
	}

	public String getDeSituacaoAtual() {
		return deSituacaoAtual;
	}

	public void setDeSituacaoAtual(String deSituacaoAtual) {
		this.deSituacaoAtual = deSituacaoAtual;
	}
	
	

	public Long getNnEnvio() {
		return nnEnvio;
	}

	public void setNnEnvio(Long nnEnvio) {
		this.nnEnvio = nnEnvio;
	}
	
	



	public Long getISPBOrigem() {
		return ISPBOrigem;
	}

	public void setISPBOrigem(Long iSPBOrigem) {
		ISPBOrigem = iSPBOrigem;
	}

	public String getBancoOrigemSTR(){
		String banco = String.valueOf(this.getBancoOrigem());
		if (this.getBancoOrigem() == 0){
			banco = "";
		}
		
		return banco;
	}
	
	

	public String getAgenciaOrigemSTR(){
		String agenciaOrigem = String.valueOf(this.getAgenciaOrigem());
		if (this.getAgenciaOrigem()==0){
			agenciaOrigem="";
		}
		return agenciaOrigem;
	}

	
	public String getCedenteOrigemSTR(){
		String cedenteOrigem = String.valueOf(this.getCedenteOrigem());
		if (this.getCedenteOrigem()==0){
			cedenteOrigem="";
		}
		return cedenteOrigem;
	}
	
	
    public java.lang.String getCpfCnpjCedenteFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoaCedente() != null) {
            if (this.getTipoPessoaCedente().equals("F")) {
                cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjCedente().toString(), 11);
            } else if (this.getTipoPessoaCedente().equals("J")) {
                cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjCedente().toString(), 14);
            }
            cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        }
        return cpfCnpjTexto;
    }

    public java.lang.String getCpfCnpjSacadoFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoaSacado() != null) {
            if (this.getTipoPessoaSacado().equals("F")) {
                cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjSacado().toString(), 11);
            } else if (this.getTipoPessoaSacado().equals("J")) {
                cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjSacado().toString(), 14);
            }
            cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        }
        return cpfCnpjTexto;
    }

    
	public String getCoUsuario() {
		return coUsuario;
	}

	public void setCoUsuario(String coUsuario) {
		this.coUsuario = coUsuario;
	}

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            LiquidacoesSTRBean other = (LiquidacoesSTRBean) obj;
            result = result  && equals(getOpcao(), other.getOpcao());
            result = result  && equals(getCedenteOrigem(), other.getCedenteOrigem());
            result = result  && equals(getBancoOrigem(), other.getBancoOrigem());
            result = result  && equals(getAgenciaOrigem(),other.getAgenciaOrigem());
            result = result  && equals(getQtdeTitulos(),other.getQtdeTitulos());
            result = result  && equals(getDataRecebimento(), other.getDataRecebimento());
            result = result  && equals(getBanco(), other.getBanco());
            result = result  && equals(getAgencia(), other.getAgencia());
            result = result  && equals(getHoraRecebimento(), other.getHoraRecebimento());
            result = result  && equals(getSequencial(), other.getSequencial());
            result = result  && equals(getCedente(),other.getCedente());
            result = result  && equals(getNossoNumero(),other.getNossoNumero());
            result = result  && equals(getCodErro(),other.getCodErro());
            result = result  && equals(getDescErro(),other.getDescErro());
            result = result  && equals(getValorRecebido(), other.getValorRecebido());
            result = result  && equals(getPagina(), other.getPagina());
            result = result  && equals(getDescOpcao(), other.getDescOpcao());
            result = result  && equals(getNomeCedente(), other.getNomeCedente()); 
            result = result  && equals(getTipoPessoaCedente(), other.getTipoPessoaCedente());
            result = result  && equals(getCpfCnpjCedente(), other.getCpfCnpjCedente());
            result = result  && equals(getTipoPessoaSacado(), other.getTipoPessoaSacado());
            result = result  && equals(getCpfCnpjSacado(),other.getCpfCnpjSacado());
            result = result  && equals(getCodCanal(), other.getCodCanal());
            result = result  && equals(getDescCanal(), other.getDescCanal());
            result = result  && equals(getValorDocumento(), other.getValorDocumento());
            result = result  && equals(getDataMovimento(), other.getDataMovimento());
            result = result  && equals(getValorDescAbatimento(), other.getValorDescAbatimento());
            result = result  && equals(getCodFormaRecebimento(), other.getCodFormaRecebimento());
            result = result  && equals(getValorJuros(), other.getValorJuros());
            result = result  && equals(getNsuSIGCB(), other.getNsuSIGCB());
            result = result  && equals(getValorMulta(), other.getValorMulta());
            result = result  && equals(getNsuSITRC(), other.getNsuSITRC());
            result = result  && equals(getValorAcrescimo(), other.getValorAcrescimo());
            result = result  && equals(getNsuBACEN(), other.getNsuBACEN());
            result = result  && equals(getDthrBACEN(), other.getDthrBACEN());
            result = result  && equals(getCodBarras(), other.getCodBarras());
            result = result  && equals(getTpBarras(), other.getTpBarras());
            result = result  && equals(getCodMensagem(), other.getCodMensagem());
            result = result  && equals(getIcTransfere(), other.getIcTransfere());
            result = result  && equals(getDescricaoErro(), other.getDescricaoErro());
            result = result  && equals(getCdSituacaoAnterior(), other.getCdSituacaoAnterior());
            result = result  && equals(getDthrSituacaoAnterior(), other.getDthrSituacaoAnterior());
            result = result  && equals(getCdSituacaoAtual(), other.getCdSituacaoAtual());
            result = result  && equals(getDthrSituacaoAtual(), other.getDthrSituacaoAtual());
            result = result  && equals(getCodDevolucao(), other.getCodDevolucao());
            result = result  && equals(getAcaoExecutar(), other.getAcaoExecutar());
            result = result  && equals(getDataVencimento(), other.getDataVencimento());
            result = result  && equals(getDescCodDevolucao(), other.getDescCodDevolucao());
            result = result  && equals(getMsgRetorno(), other.getMsgRetorno());
            result = result  && equals(getCoSituacao(), other.getCoSituacao() );
            result = result  && equals(getDeSituacao(), other.getDeSituacao());
            
            result = result  && equals(getValorDevolvido(), other.getValorDevolvido());
            result = result  && equals(getNsuSIGCBRecebimento(), other.getNsuSIGCBRecebimento());
            result = result  && equals(getFormaRetornoDev(), other.getFormaRetornoDev());
            result = result  && equals(getSituacaoSPB(), other.getSituacaoSPB());
            result = result  && equals(getDthrSituacaoSPB(), other.getDthrSituacaoSPB());
            result = result  && equals(getDeSituacaoAnterior(), other.getDeSituacaoAnterior());
            result = result  && equals(getDeSituacaoAtual(), other.getDeSituacaoAtual());
            result = result  && equals(getCoUsuario(), other.getCoUsuario());
            result = result  && equals(getNnEnvio(), other.getNnEnvio());
            result = result  && equals(getCodDevolucaoEnvio(), other.getCodDevolucaoEnvio());
            result = result  && equals(getDataPesqFinal(), other.getDataPesqFinal());
            result = result  && equals(getUsuarioAnterior(), other.getUsuarioAnterior());
            result = result  && equals(getUsuarioAtual(), other.getUsuarioAtual());
            result = result  && equals(getNsuSITRCRecebimento(), other.getNsuSITRCRecebimento());
            result = result  && equals(getCodRetSITRC(), other.getCodRetSITRC());
            result = result  && equals(getISPBOrigem(), other.getISPBOrigem());
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
        
        properties.add(new Property("opcao", LongType.create(), false, true));
        properties.add(new Property("cedenteOrigem", LongType.create(), false, true));
        properties.add(new Property("bancoOrigem", LongType.create(), false, true));
        properties.add(new Property("agenciaOrigem", LongType.create(), false, true));
        properties.add(new Property("pagina", LongType.create(), false, true));
        properties.add(new Property("descOpcao", StringType.create(), false, true));
        properties.add(new Property("valorRecebido", MoneyType.create(), false,  true));
        properties.add(new Property("qtdeTitulos", LongType.create(), false, true));
        properties.add(new Property("dataRecebimento", StringType.create(), false, true));
        properties.add(new Property("banco", StringType.create(), false, true));
        properties.add(new Property("agencia", StringType.create(), false, true));
        properties.add(new Property("horaRecebimento", StringType.create(), false, true));
        properties.add(new Property("sequencial", StringType.create(), false, true));
        properties.add(new Property("cedente", StringType.create(), false, true));
        properties.add(new Property("nossoNumero", StringType.create(), false, true));
        properties.add(new Property("codErro", StringType.create(), false, true));
        properties.add(new Property("descErro", StringType.create(), false, true));
        properties.add(new Property("nomeCedente", StringType.create(), false, true));
        properties.add(new Property("tipoPessoaCedente", StringType.create(), false, true));
        properties.add(new Property("cpfCnpjCedente", StringType.create(), false, true));
        properties.add(new Property("tipoPessoaSacado", StringType.create(), false, true));
        properties.add(new Property("cpfCnpjSacado", StringType.create(), false, true));
        properties.add(new Property("codCanal", StringType.create(), false, true));
        properties.add(new Property("descCanal", StringType.create(), false, true));
        properties.add(new Property("dataMovimento", StringType.create(), false, true));
        properties.add(new Property("codFormaRecebimento", StringType.create(), false, true));
        properties.add(new Property("nsuSIGCB", StringType.create(), false, true));
        properties.add(new Property("nsuSITRC", StringType.create(), false, true));
        properties.add(new Property("nsuBACEN", StringType.create(), false, true));
        properties.add(new Property("dthrBACEN", StringType.create(), false, true));
        properties.add(new Property("codBarras", StringType.create(), false, true));
        properties.add(new Property("tpBarras", StringType.create(), false, true));
        properties.add(new Property("codMensagem", StringType.create(), false, true));
        properties.add(new Property("icTransfere", StringType.create(), false, true));
        properties.add(new Property("descricaoErro", StringType.create(), false, true));
        properties.add(new Property("cdSituacaoAnterior", StringType.create(), false, true));
        properties.add(new Property("dthrSituacaoAnterior", StringType.create(), false, true));
        properties.add(new Property("cdSituacaoAtual", StringType.create(), false, true));
        properties.add(new Property("dthrSituacaoAtual", StringType.create(), false, true));
        properties.add(new Property("codDevolucao", StringType.create(), false, true));
        properties.add(new Property("acaoExecutar", StringType.create(), false, true));
        properties.add(new Property("cedenteCorrigido", StringType.create(), false, true));
        properties.add(new Property("nossoNumeroCorrigido", StringType.create(), false, true));
        properties.add(new Property("valorDocumento", MoneyType.create(), false,  true));
        properties.add(new Property("valorDescAbatimento", MoneyType.create(), false,  true));
        properties.add(new Property("valorJuros", MoneyType.create(), false,  true));
        properties.add(new Property("valorMulta", MoneyType.create(), false,  true));
        properties.add(new Property("valorDevolvido", MoneyType.create(), false,  true));
        properties.add(new Property("valorAcrescimo", MoneyType.create(), false,  true));
        properties.add(new Property("dataVencimento", StringType.create(), false, true));
        properties.add(new Property("descCodDevolucao", StringType.create(), false, true));
        properties.add(new Property("msgRetorno", StringType.create(), false, true));
        properties.add(new Property("coSituacao", StringType.create(), false, true));
        properties.add(new Property("deSituacao", StringType.create(), false, true));
        
        properties.add(new Property("dataPesq", DateType.create(), false, true));
        properties.add(new Property("dataPesqFinal", DateType.create(), false, true));
        properties.add(new Property("nsuSIGCBRecebimento", StringType.create(), false, true));
        properties.add(new Property("situacaoSPB", StringType.create(), false, true));
        properties.add(new Property("formaRetornoDev", StringType.create(), false, true));
        properties.add(new Property("dthrSituacaoSPB", StringType.create(), false, true));
        
        properties.add(new Property("deSituacaoAnterior", StringType.create(), false, true));
        properties.add(new Property("deSituacaoAtual", StringType.create(), false, true));
        properties.add(new Property("coUsuario", StringType.create(), false, true));
        properties.add(new Property("nnEnvio", LongType.create(), false, true));
        properties.add(new Property("codDevolucaoEnvio", LongType.create(), false, true));
        
        properties.add(new Property("usuarioAnterior", StringType.create(), false, true));
        properties.add(new Property("usuarioAtual", StringType.create(), false, true));
        properties.add(new Property("ISPBOrigem", LongType.create(), false, true));
        

        
        properties.add(new Property("nsuSITRCRecebimento", StringType.create(), false, true));
        properties.add(new Property("codRetSITRC", StringType.create(), false, true));
        
        Layout result = new Layout(properties,"LiquidacoesRejeitadaBean", "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("opcao", new LongValue("9(02)"));
        Mainframe.put("cedenteOrigem", new LongValue("9(07)"));
        Mainframe.put("bancoOrigem", new LongValue("9(03)"));
        Mainframe.put("agenciaOrigem", new LongValue("9(04)"));
        Mainframe.put("pagina", new LongValue("9(06)"));
        Mainframe.put("descOpcao", new StringValue("X(80)"));
        Mainframe.put("qtdeTitulos", new LongValue("9(06)"));
        Mainframe.put("dataRecebimento", new StringValue("X(10)"));
        Mainframe.put("banco", new StringValue("X(03)"));
        Mainframe.put("agencia", new StringValue("X(04)"));
        Mainframe.put("horaRecebimento", new StringValue("X(08)"));
        Mainframe.put("sequencial", new StringValue("X(5)"));
        Mainframe.put("cedente", new StringValue("X(7)"));
        Mainframe.put("nossoNumero", new StringValue("X(18)"));
        Mainframe.put("codErro", new StringValue("X(4)"));
        Mainframe.put("descErro", new StringValue("X(30)"));
        Mainframe.put("valorRecebido", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("nomeCedente", new StringValue("X(50)"));
        Mainframe.put("tipoPessoaCedente", new StringValue("X(01)"));
        Mainframe.put("cpfCnpjCedente", new StringValue("X(14)"));
        Mainframe.put("tipoPessoaSacado", new StringValue("X(01)"));
        Mainframe.put("cpfCnpjSacado", new StringValue("X(14)"));
        Mainframe.put("codCanal", new StringValue("X(1)"));
        Mainframe.put("descCanal", new StringValue("X(30)"));
        Mainframe.put("dataMovimento", new StringValue("X(10)"));
        Mainframe.put("codFormaRecebimento", new StringValue("X(20)"));
        Mainframe.put("nsuSIGCB", new StringValue("X(20)"));
        Mainframe.put("nsuSITRC", new StringValue("X(20)"));
        Mainframe.put("nsuBACEN", new StringValue("X(20)"));
        Mainframe.put("dthrBACEN", new StringValue("X(20)"));
        Mainframe.put("codBarras", new StringValue("X(44)"));
        Mainframe.put("tpBarras", new StringValue("X(01)"));
        Mainframe.put("codMensagem", new StringValue("X(09)"));
        Mainframe.put("icTransfere", new StringValue("X(25)"));
        Mainframe.put("descricaoErro", new StringValue("X(80)"));
        Mainframe.put("cdSituacaoAnterior", new StringValue("X(02)"));
        Mainframe.put("dthrSituacaoAnterior", new StringValue("X(20)"));
        Mainframe.put("cdSituacaoAtual", new StringValue("X(02)"));
        Mainframe.put("dthrSituacaoAtual", new StringValue("X(20)"));
        Mainframe.put("codDevolucao", new StringValue("X(02)"));
        Mainframe.put("cedenteCorrigido", new StringValue("X(07)"));
        Mainframe.put("nossoNumeroCorrigido", new StringValue("X(18)"));
        Mainframe.put("valorDocumento", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorDescAbatimento", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorJuros", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorMulta", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorAcrescimo", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("acaoExecutar", new StringValue("X(02)"));
        Mainframe.put("dataVencimento", new StringValue("X(10)"));
        Mainframe.put("descCodDevolucao", new StringValue("X(30)"));
        Mainframe.put("msgRetorno", new StringValue("X(250)"));
        Mainframe.put("coSituacao", new StringValue("X(04)"));
        Mainframe.put("deSituacao", new StringValue("X(30)"));
        Mainframe.put("dataPesq", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataPesqFinal", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valorDevolvido", new MoneyValue("R$ 9(11)v99"));
        Mainframe.put("nsuSIGCBRecebimento", new StringValue("X(20)"));
        Mainframe.put("situacaoSPB", new StringValue("X(3)"));
        Mainframe.put("formaRetornoDev", new StringValue("X(20)"));
        Mainframe.put("dthrSituacaoSPB", new StringValue("X(20)"));
        Mainframe.put("deSituacaoAtual", new StringValue("X(30)"));
        Mainframe.put("deSituacaoAnterior", new StringValue("X(30)"));
        Mainframe.put("coUsuario", new StringValue("X(08)"));
        Mainframe.put("nnEnvio", new LongValue("9(18)"));
        Mainframe.put("codDevolucaoEnvio", new LongValue("9(02)"));
        Mainframe.put("usuarioAnterior", new StringValue("X(08)"));
        Mainframe.put("usuarioAtual", new StringValue("X(08)"));
        Mainframe.put("ISPBOrigem", new LongValue("9(08)"));
        Mainframe.put("nsuSITRCRecebimento", new StringValue("X(20)"));
        Mainframe.put("codRetSITRC", new StringValue("X(04)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}


