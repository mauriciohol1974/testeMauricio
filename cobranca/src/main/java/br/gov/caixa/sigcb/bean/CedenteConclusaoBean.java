//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.DateType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.PercentualType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.DateValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.PercentualValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Percentual;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteConclusaoBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoClienteCOCLI;

    private java.lang.String codigoItem;

    private java.lang.Long codigoUnidadeEN;

    private java.lang.Long codigoUnidadePVVinc;

    private java.lang.String codigoUsuario;

    private java.lang.String contaExcepcionado;

    private java.lang.String contaOriginal;

    private java.lang.Long cpfCnpj;

    private java.util.Date dataInclusao;

    private java.util.Date dataInclusaoAlteracao;

    private java.util.Date dataUltimaAlteracao;

    private java.lang.String descricaoCriticas;

    private java.lang.String descricaoItem;

    private java.lang.String excepcionacao;

    private java.lang.Long idEndereco;

    private java.lang.String itemSemAlcada;

    private java.lang.String justificativa;

    private java.lang.String nomeCedente;

    private java.lang.String nsuTransacao;

    private java.lang.Long numeroExcepcionado;

    private java.lang.Long numeroOriginal;

    private java.lang.Long numeroPendencia;

    private java.lang.Long numeroPendenciaVigente;

    private java.lang.Long numeroReiteracaoVigente;

    private Percentual percentual;

    private java.lang.String perfilUsuarioAlcada;

    private java.lang.String responsavelAlteracao;

    private java.lang.String responsavelInclusao;

    private java.lang.String responsavelInclusaoAlteracao;

    private java.lang.String strRecordset;

    private java.lang.String textoExcepcionado;

    private java.lang.String textoOriginal;

    private java.lang.Long tipo;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoPessoa;

    // AOL - 31out06
    private java.lang.String logradouro;

    // private java.lang.Long numeroLogradouro;
    private java.lang.String numeroLogradouro;

    private java.lang.String complemento;

    private java.lang.String bairroLogradouro;

    private java.lang.String municipio;

    private java.lang.Long cep;

    private java.lang.String uf;
    
    private String ip;

    // AOL - fim
    private br.com.politec.sao.util.Money valorExcepcionado;

    private br.com.politec.sao.util.Money valorOriginal;

    private boolean agregado = false;

    public CedenteConclusaoBean() {
        this.codigoCedente = null;
        this.codigoClienteCOCLI = null;
        this.codigoItem = null;
        this.codigoUnidadeEN = null;
        this.codigoUnidadePVVinc = null;
        this.codigoUsuario = null;
        this.contaExcepcionado = null;
        this.contaOriginal = null;
        this.cpfCnpj = null;
        this.dataInclusao = null;
        this.dataInclusaoAlteracao = null;
        this.dataUltimaAlteracao = null;
        this.descricaoCriticas = null;
        this.descricaoItem = null;
        this.excepcionacao = null;
        this.idEndereco = null;
        this.itemSemAlcada = null;
        this.justificativa = null;
        this.nomeCedente = null;
        this.nsuTransacao = null;
        this.numeroExcepcionado = null;
        this.numeroOriginal = null;
        this.numeroPendencia = null;
        this.numeroPendenciaVigente = null;
        this.numeroReiteracaoVigente = null;
        this.percentual = null;
        this.perfilUsuarioAlcada = null;
        this.responsavelAlteracao = null;
        this.responsavelInclusao = null;
        this.responsavelInclusaoAlteracao = null;
        this.strRecordset = null;
        this.textoExcepcionado = null;
        this.textoOriginal = null;
        this.tipo = null;
        this.tipoAcao = null;
        this.tipoPessoa = null;
        this.valorExcepcionado = null;
        this.valorOriginal = null;
        // AOL - 31out06
        this.logradouro = null;
        this.numeroLogradouro = null;
        this.complemento = null;
        this.bairroLogradouro = null;
        this.municipio = null;
        this.cep = null;
        this.uf = null;
        this.ip = null;
        // AOL - FIM
    }

    public java.lang.String getBairroLogradouro() {
        return bairroLogradouro;
    }

    public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setBairroLogradouro(java.lang.String bairroLogradouro) {
        this.bairroLogradouro = bairroLogradouro;
    }

    public java.lang.Long getCep() {
        return cep;
    }

    public void setCep(java.lang.Long cep) {
        this.cep = cep;
    }

    public java.lang.String getComplemento() {
        return complemento;
    }

    public void setComplemento(java.lang.String complemento) {
        this.complemento = complemento;
    }

    public java.lang.String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(java.lang.String logradouro) {
        this.logradouro = logradouro;
    }

    public java.lang.String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(java.lang.String municipio) {
        this.municipio = municipio;
    }

    // public java.lang.Long getNumeroLogradouro() {
    // return numeroLogradouro;
    // }
    //
    // public void setNumeroLogradouro(java.lang.Long numeroLogradouro) {
    // this.numeroLogradouro = numeroLogradouro;
    // }

    public java.lang.String getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(java.lang.String numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public java.lang.String getUf() {
        return uf;
    }

    public void setUf(java.lang.String uf) {
        this.uf = uf;
    }

    public String getApplicationName() {
        return "CedenteConclusaoBean";
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

    public java.lang.String getCodigoItem() {
        return this.codigoItem;
    }

    public void setCodigoItem(java.lang.String codigoItem) {
        this.codigoItem = codigoItem;
    }

    public java.lang.Long getCodigoUnidadeEN() {
        return this.codigoUnidadeEN;
    }

    public void setCodigoUnidadeEN(java.lang.Long codigoUnidadeEN) {
        this.codigoUnidadeEN = codigoUnidadeEN;
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

    public java.lang.String getContaExcepcionado() {
        return this.contaExcepcionado;
    }

    public void setContaExcepcionado(java.lang.String contaExcepcionado) {
        this.contaExcepcionado = contaExcepcionado;
    }

    public java.lang.String getContaOriginal() {
        return this.contaOriginal;
    }

    public void setContaOriginal(java.lang.String contaOriginal) {
        this.contaOriginal = contaOriginal;
    }

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.util.Date getDataInclusao() {
        return this.dataInclusao;
    }

    public java.lang.String getDataInclusaoFormatada() {
        if (this.dataInclusao != null) {
            return Formatador.formatarData(this.dataInclusao);
        } else {
            return "";
        }
    }

    public void setDataInclusao(java.util.Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public java.util.Date getDataInclusaoAlteracao() {
        return this.dataInclusaoAlteracao;
    }

    public void setDataInclusaoAlteracao(java.util.Date dataInclusaoAlteracao) {
        this.dataInclusaoAlteracao = dataInclusaoAlteracao;
    }

    public java.util.Date getDataUltimaAlteracao() {
        return this.dataUltimaAlteracao;
    }

    public java.lang.String getDataUltimaAlteracaoFormatada() {
        if (this.dataUltimaAlteracao != null) {
            return Formatador.formatarData(this.dataUltimaAlteracao);
        } else {
            return "";
        }
    }

    public void setDataUltimaAlteracao(java.util.Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public java.lang.String getDescricaoCriticas() {
        return this.descricaoCriticas;
    }

    public void setDescricaoCriticas(java.lang.String descricaoCriticas) {
        this.descricaoCriticas = descricaoCriticas;
    }

    public java.lang.String getDescricaoItem() {
        return this.descricaoItem;
    }

    public void setDescricaoItem(java.lang.String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public java.lang.String getExcepcionacao() {
        return this.excepcionacao;
    }

    public void setExcepcionacao(java.lang.String excepcionacao) {
        this.excepcionacao = excepcionacao;
    }

    public java.lang.Long getIdEndereco() {
        return this.idEndereco;
    }

    public void setIdEndereco(java.lang.Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public java.lang.String getItemSemAlcada() {
        return this.itemSemAlcada;
    }

    public void setItemSemAlcada(java.lang.String itemSemAlcada) {
        this.itemSemAlcada = itemSemAlcada;
    }

    public java.lang.String getJustificativa() {
        return this.justificativa;
    }

    public void setJustificativa(java.lang.String justificativa) {
        this.justificativa = justificativa;
    }

    public java.lang.String getNomeCedente() {
        return this.nomeCedente;
    }

    public void setNomeCedente(java.lang.String nomeCedente) {
        this.nomeCedente = nomeCedente;
    }

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public java.lang.Long getNumeroExcepcionado() {
        return this.numeroExcepcionado;
    }

    public void setNumeroExcepcionado(java.lang.Long numeroExcepcionado) {
        this.numeroExcepcionado = numeroExcepcionado;
    }

    public java.lang.Long getNumeroOriginal() {
        return this.numeroOriginal;
    }

    public void setNumeroOriginal(java.lang.Long numeroOriginal) {
        this.numeroOriginal = numeroOriginal;
    }

    public java.lang.Long getNumeroPendencia() {
        return this.numeroPendencia;
    }

    public void setNumeroPendencia(java.lang.Long numeroPendencia) {
        this.numeroPendencia = numeroPendencia;
    }

    public java.lang.Long getNumeroPendenciaVigente() {
        return this.numeroPendenciaVigente;
    }

    public void setNumeroPendenciaVigente(java.lang.Long numeroPendenciaVigente) {
        this.numeroPendenciaVigente = numeroPendenciaVigente;
    }

    public java.lang.Long getNumeroReiteracaoVigente() {
        return this.numeroReiteracaoVigente;
    }

    public void setNumeroReiteracaoVigente(java.lang.Long numeroReiteracaoVigente) {
        this.numeroReiteracaoVigente = numeroReiteracaoVigente;
    }

    public Percentual getPercentual() {
        return this.percentual;
    }

    public void setPercentual(Percentual percentual) {
        this.percentual = percentual;
    }

    public java.lang.String getPerfilUsuarioAlcada() {
        return this.perfilUsuarioAlcada;
    }

    public void setPerfilUsuarioAlcada(java.lang.String perfilUsuarioAlcada) {
        this.perfilUsuarioAlcada = perfilUsuarioAlcada;
    }

    public java.lang.String getResponsavelAlteracao() {
        return this.responsavelAlteracao;
    }

    public void setResponsavelAlteracao(java.lang.String responsavelAlteracao) {
        this.responsavelAlteracao = responsavelAlteracao;
    }

    public java.lang.String getResponsavelInclusao() {
        return this.responsavelInclusao;
    }

    public void setResponsavelInclusao(java.lang.String responsavelInclusao) {
        this.responsavelInclusao = responsavelInclusao;
    }

    public java.lang.String getResponsavelInclusaoAlteracao() {
        return this.responsavelInclusaoAlteracao;
    }

    public void setResponsavelInclusaoAlteracao(java.lang.String responsavelInclusaoAlteracao) {
        this.responsavelInclusaoAlteracao = responsavelInclusaoAlteracao;
    }

    public java.lang.String getStrRecordset() {
        return this.strRecordset;
    }

    public void setStrRecordset(java.lang.String strRecordset) {
        this.strRecordset = strRecordset;
    }

    public java.lang.String getTextoExcepcionado() {
        return this.textoExcepcionado;
    }

    public void setTextoExcepcionado(java.lang.String textoExcepcionado) {
        this.textoExcepcionado = textoExcepcionado;
    }

    public java.lang.String getTextoOriginal() {
        return this.textoOriginal;
    }

    public void setTextoOriginal(java.lang.String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public java.lang.Long getTipo() {
        return this.tipo;
    }

    public void setTipo(java.lang.Long tipo) {
        this.tipo = tipo;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public br.com.politec.sao.util.Money getValorExcepcionado() {
        return this.valorExcepcionado;
    }

    public void setValorExcepcionado(br.com.politec.sao.util.Money valorExcepcionado) {
        this.valorExcepcionado = valorExcepcionado;
    }

    public br.com.politec.sao.util.Money getValorOriginal() {
        return this.valorOriginal;
    }

    public void setValorOriginal(br.com.politec.sao.util.Money valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public Object getAtributoOriginal() {
        Long tipo = this.getTipo();

        switch (tipo.intValue()) {
        case 1: // Valor
        case 2: // Valor com Percentual
            return this.getValorOriginal();

        case 3: // Alfa
        case 5: // Cpf / Cnpj
            return this.getTextoOriginal();

        case 4: // Conta
            return this.getContaOriginal();

        }

        return "";
    }

    public Object getAtributoExcepcionado() {
        Long tipo = this.getTipo();

        switch (tipo.intValue()) {
        case 1: // Valor
        case 2: // Valor com Percentual
            return this.getValorExcepcionado();

        case 3: // Alfa
        case 5: // Cpf / Cnpj
            return this.getTextoExcepcionado();

        case 4: // Conta
            return this.getContaExcepcionado();
        }

        return "";
    }

    public String getAtributoPercentual() {
        Long tipo = this.getTipo();

        if (tipo.intValue() == 2) {
            return this.getPercentual().toString();
        }

        return "";
    }

    public boolean isAgregado() {
        return agregado;
    }

    public boolean getAgregado() {
        return agregado;
    }

    public void setAgregado(boolean b) {
        agregado = b;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadeENFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadeEN);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedenteConclusaoBean other = (CedenteConclusaoBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoClienteCOCLI(),
                             other.getCodigoClienteCOCLI());
            result = result && equals(getCodigoItem(), other.getCodigoItem());
            result = result
                     && equals(getCodigoUnidadeEN(), other.getCodigoUnidadeEN());
            result = result
                     && equals(getCodigoUnidadePVVinc(),
                             other.getCodigoUnidadePVVinc());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getContaExcepcionado(),
                             other.getContaExcepcionado());
            result = result
                     && equals(getContaOriginal(), other.getContaOriginal());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result
                     && equals(getDataInclusao(), other.getDataInclusao());
            result = result
                     && equals(getDataInclusaoAlteracao(),
                             other.getDataInclusaoAlteracao());
            result = result
                     && equals(getDataUltimaAlteracao(),
                             other.getDataUltimaAlteracao());
            result = result
                     && equals(getDescricaoCriticas(),
                             other.getDescricaoCriticas());
            result = result
                     && equals(getDescricaoItem(), other.getDescricaoItem());
            result = result
                     && equals(getExcepcionacao(), other.getExcepcionacao());
            result = result && equals(getIdEndereco(), other.getIdEndereco());
            result = result
                     && equals(getItemSemAlcada(), other.getItemSemAlcada());
            result = result
                     && equals(getJustificativa(), other.getJustificativa());
            result = result && equals(getNomeCedente(), other.getNomeCedente());
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result
                     && equals(getNumeroExcepcionado(),
                             other.getNumeroExcepcionado());
            result = result
                     && equals(getNumeroOriginal(), other.getNumeroOriginal());
            result = result
                     && equals(getNumeroPendencia(), other.getNumeroPendencia());
            result = result
                     && equals(getNumeroPendenciaVigente(),
                             other.getNumeroPendenciaVigente());
            result = result
                     && equals(getNumeroReiteracaoVigente(),
                             other.getNumeroReiteracaoVigente());
            result = result && equals(getPercentual(), other.getPercentual());
            result = result
                     && equals(getPerfilUsuarioAlcada(),
                             other.getPerfilUsuarioAlcada());
            result = result
                     && equals(getResponsavelAlteracao(),
                             other.getResponsavelAlteracao());
            result = result
                     && equals(getResponsavelInclusao(),
                             other.getResponsavelInclusao());
            result = result
                     && equals(getResponsavelInclusaoAlteracao(),
                             other.getResponsavelInclusaoAlteracao());
            result = result
                     && equals(getStrRecordset(), other.getStrRecordset());
            result = result
                     && equals(getTextoExcepcionado(),
                             other.getTextoExcepcionado());
            result = result
                     && equals(getTextoOriginal(), other.getTextoOriginal());
            result = result && equals(getTipo(), other.getTipo());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            // AOL - 31out06
            result = result && equals(getLogradouro(), other.getLogradouro());
            result = result
                     && equals(getNumeroLogradouro(),
                             other.getNumeroLogradouro());
            result = result && equals(getComplemento(), other.getComplemento());
            result = result
                     && equals(getBairroLogradouro(),
                             other.getBairroLogradouro());
            result = result && equals(getMunicipio(), other.getMunicipio());
            result = result && equals(getCep(), other.getCep());
            result = result && equals(getUf(), other.getUf());
            result = result && equals(getIp(), other.getIp());
            // AOL - fim
            result = result
                     && equals(getValorExcepcionado(),
                             other.getValorExcepcionado());
            result = result
                     && equals(getValorOriginal(), other.getValorOriginal());
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
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoClienteCOCLI",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoItem",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadeEN",
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
        properties.add(new Property("contaExcepcionado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("contaOriginal",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("dataInclusao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataInclusaoAlteracao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataUltimaAlteracao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("descricaoCriticas",
                StringType.create(),
                false,
                true));
        properties.add(new Property("descricaoItem",
                StringType.create(),
                false,
                true));
        properties.add(new Property("excepcionacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("idEndereco",
                LongType.create(),
                false,
                true));
        properties.add(new Property("itemSemAlcada",
                StringType.create(),
                false,
                true));
        properties.add(new Property("justificativa",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeCedente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroExcepcionado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroOriginal",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroPendencia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroPendenciaVigente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroReiteracaoVigente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("percentual",
                PercentualType.create(),
                false,
                true));
        properties.add(new Property("perfilUsuarioAlcada",
                StringType.create(),
                false,
                true));
        properties.add(new Property("responsavelAlteracao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("responsavelInclusao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("responsavelInclusaoAlteracao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("strRecordset",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textoExcepcionado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("textoOriginal",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipo", LongType.create(), false, true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        // AOL - 31out06
        properties.add(new Property("logradouro",
                StringType.create(),
                false,
                true));
        // properties.add(new Property("numeroLogradouro", LongType.create(),
        // false, true));
        properties.add(new Property("numeroLogradouro",
                StringType.create(),
                false,
                true));
        properties.add(new Property("complemento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("bairroLogradouro",
                StringType.create(),
                false,
                true));
        properties.add(new Property("municipio",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cep", LongType.create(), false, true));
        properties.add(new Property("uf", StringType.create(), false, true));
        properties.add(new Property("ip", StringType.create(), false, true));		
        // AOL - fim
        properties.add(new Property("valorExcepcionado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorOriginal",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedenteConclusaoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("contaOriginal", new StringValue("X(16)"));
        Mainframe.put("codigoUsuario", new StringValue("X(07)"));
        Mainframe.put("tipo", new LongValue("9(01)"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("itemSemAlcada", new StringValue("X(1)"));
        Mainframe.put("responsavelInclusaoAlteracao", new StringValue("X(08)"));
        Mainframe.put("numeroReiteracaoVigente", new LongValue("9(02)"));
        Mainframe.put("dataUltimaAlteracao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("nomeCedente", new StringValue("X(40)"));
        Mainframe.put("responsavelAlteracao", new StringValue("X(08)"));
        Mainframe.put("dataInclusao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("descricaoCriticas", new StringValue("X(200)"));
        Mainframe.put("valorOriginal", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("valorExcepcionado", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("numeroExcepcionado", new LongValue("9(15)"));
        Mainframe.put("numeroOriginal", new LongValue("9(15)"));
        Mainframe.put("justificativa", new StringValue("X(200)"));
        Mainframe.put("textoOriginal", new StringValue("X(16)"));
        Mainframe.put("excepcionacao", new StringValue("X(01)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        // AOL - 31out06
        Mainframe.put("logradouro", new StringValue("X(50)"));
        // Mainframe.put("numeroLogradouro", new LongValue("9(07)"));
        Mainframe.put("numeroLogradouro", new StringValue("X(07)"));
        Mainframe.put("complemento", new StringValue("X(15)"));
        Mainframe.put("bairroLogradouro", new StringValue("X(40)"));
        Mainframe.put("municipio", new StringValue("X(35)"));
        Mainframe.put("cep", new LongValue("9(08)"));
        Mainframe.put("uf", new StringValue("X(02)"));
        // AOL - fim
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("codigoUnidadeEN", new LongValue("9(04)"));
        Mainframe.put("textoExcepcionado", new StringValue("X(16)"));
        Mainframe.put("responsavelInclusao", new StringValue("X(08)"));
        Mainframe.put("idEndereco", new LongValue("9(04)"));
        Mainframe.put("codigoClienteCOCLI", new LongValue("9(13)"));
        Mainframe.put("codigoItem", new StringValue("X(4)"));
        Mainframe.put("perfilUsuarioAlcada", new StringValue("X(05)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("numeroPendencia", new LongValue("9(07)"));
        Mainframe.put("numeroPendenciaVigente", new LongValue("9(07)"));
        Mainframe.put("dataInclusaoAlteracao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("strRecordset", new StringValue("X(720)"));
        Mainframe.put("codigoUnidadePVVinc", new LongValue("9(04)"));
        Mainframe.put("contaExcepcionado", new StringValue("X(16)"));
        Mainframe.put("descricaoItem", new StringValue("X(40)"));
        Mainframe.put("ip", new StringValue("X(15)"));
        Mainframe.put("percentual", new PercentualValue("9(07)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
