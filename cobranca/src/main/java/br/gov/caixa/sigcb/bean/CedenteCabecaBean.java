// Atencao bean alterado manualmente

package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteCabecaBean extends SigcbBean {
    private java.lang.String bairro;

    private java.lang.String carteira;

    private java.lang.Long cep;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoClienteCOCLI;

    private java.lang.Long codigoUnidadePVVinc;

    private java.lang.String codigoUsuario;

    private java.lang.String complemento;

    private java.lang.Long cpfCnpj;

    private java.lang.String email;

    private java.lang.Long idEndereco;

    private java.lang.String logradouro;

    private java.lang.String municipio;

    private java.lang.String nomeFantasia;

    private java.lang.String numero;

    private java.lang.String razaoSocial;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoPessoa;

    private java.lang.String uf;

    private java.lang.Long origemConsulta;

    private String situacao;
    
    private String ip;

    public CedenteCabecaBean() {
        this.bairro = null;
        this.carteira = null;
        this.cep = null;
        this.codigoCedente = null;
        this.codigoClienteCOCLI = null;
        this.codigoUnidadePVVinc = null;
        this.codigoUsuario = null;
        this.complemento = null;
        this.cpfCnpj = null;
        this.email = null;
        this.idEndereco = null;
        this.logradouro = null;
        this.municipio = null;
        this.nomeFantasia = null;
        this.numero = null;
        this.razaoSocial = null;
        this.tipoAcao = null;
        this.tipoConsulta = null;
        this.tipoPessoa = null;
        this.uf = null;
        this.origemConsulta = null;
        this.situacao = null;
        this.ip=null;
    }

    public String getApplicationName() {
        return "CedenteCabecaBean";
    }

    public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public java.lang.String getBairro() {
        return this.bairro;
    }

    
    public String getPVStr(){
    	return String.valueOf(this.codigoUnidadePVVinc);
    }
    public void setBairro(java.lang.String bairro) {
        this.bairro = bairro;
    }

    public java.lang.String getCarteira() {
        return this.carteira;
    }

    
    public void setCarteira(java.lang.String carteira) {
        this.carteira = carteira;
    }

    public java.lang.Long getCep() {
        return this.cep;
    }

    public String getCepFormatado() {
        return Formatador.formatarCep(this.cep.toString());
    }

    public void setCep(java.lang.Long cep) {
        this.cep = cep;
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

    public String getCodigoClienteCOCLIZeros() {
        String s = String.valueOf(this.codigoClienteCOCLI);
        s = "0000000000000".substring(s.length()) + s;
        return s;
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

    public java.lang.String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(java.lang.String complemento) {
        this.complemento = complemento;
    }

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.lang.String getEmail() {
        return this.email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(java.lang.String logradouro) {
        this.logradouro = logradouro;
    }

    public java.lang.String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(java.lang.String municipio) {
        this.municipio = municipio;
    }

    public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public java.lang.String getNumero() {
        return this.numero;
    }

    public void setNumero(java.lang.String numero) {
        this.numero = numero;
    }

    public java.lang.String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(java.lang.String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.Long tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public java.lang.String getUf() {
        return this.uf;
    }

    public void setUf(java.lang.String uf) {
        this.uf = uf;
    }

    public java.lang.Long getOrigemConsulta() {
        return this.origemConsulta;
    }

    public void setOrigemConsulta(java.lang.Long origemConsulta) {
        this.origemConsulta = origemConsulta;
    }

    public java.lang.Long getIdEndereco() {
        return this.idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public java.lang.String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public java.lang.String getTipoPessoaTexto() {
        String tipoPessoaTexto = "";

        if (this.getTipoPessoa() != null) {
            if (this.getTipoPessoa().equals(new Long(1))) {
                tipoPessoaTexto = "FISICA";
            } else if (this.getTipoPessoa().equals(new Long(2))) {
                tipoPessoaTexto = "JURIDICA";
            } else {
                tipoPessoaTexto = "";
            }
        }

        return tipoPessoaTexto;
    }

    public java.lang.String getCpfCnpjFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoa() != null) {
            if (this.getTipoPessoa().equals(new Long(1))) {
                cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                        .toString(), 11);
            } else if (this.getTipoPessoa().equals(new Long(2))) {
                cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                        .toString(), 14);
            }
            cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        }
        return cpfCnpjTexto;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedenteCabecaBean other = (CedenteCabecaBean) obj;
            result = result && equals(getBairro(), other.getBairro());
            result = result && equals(getCarteira(), other.getCarteira());
            result = result && equals(getCep(), other.getCep());
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
            result = result && equals(getComplemento(), other.getComplemento());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getEmail(), other.getEmail());
            result = result && equals(getLogradouro(), other.getLogradouro());
            result = result && equals(getMunicipio(), other.getMunicipio());
            result = result
                     && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result && equals(getNumero(), other.getNumero());
            result = result && equals(getRazaoSocial(), other.getRazaoSocial());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result && equals(getUf(), other.getUf());
            result = result
                     && equals(getOrigemConsulta(), other.getOrigemConsulta());
            result = result && equals(getIdEndereco(), other.getIdEndereco());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result && equals(getIp(), other.getIp());
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
        properties.add(new Property("bairro", StringType.create(), false, true));
        properties.add(new Property("carteira",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cep", LongType.create(), false, true));
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
        properties.add(new Property("complemento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("email", StringType.create(), false, true));
        properties.add(new Property("idEndereco",
                LongType.create(),
                false,
                true));
        properties.add(new Property("logradouro",
                StringType.create(),
                false,
                true));
        properties.add(new Property("municipio",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeFantasia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numero", StringType.create(), false, true));
        properties.add(new Property("razaoSocial",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("uf", StringType.create(), false, true));
        properties.add(new Property("ip", StringType.create(), false, true));
        properties.add(new Property("origemConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("situacao",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedenteCabecaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("municipio", new StringValue("X(35)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("complemento", new StringValue("X(15)"));
        Mainframe.put("carteira", new StringValue("X(04)"));
        Mainframe.put("cep", new LongValue("9(08)"));
        Mainframe.put("bairro", new StringValue("X(40)"));
        Mainframe.put("nomeFantasia", new StringValue("X(40)"));
        Mainframe.put("numero", new StringValue("X(07)"));
        Mainframe.put("email", new StringValue("X(40)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("logradouro", new StringValue("X(53)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("uf", new StringValue("X(02)"));
        Mainframe.put("razaoSocial", new StringValue("X(40)"));
        Mainframe.put("codigoClienteCOCLI", new LongValue("9(13)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("origemConsulta", new LongValue("9(01)"));
        Mainframe.put("idEndereco", new LongValue("9(04)"));
        Mainframe.put("codigoUnidadePVVinc", new LongValue("9(04)"));
        Mainframe.put("situacao", new StringValue("X(01)"));
        Mainframe.put("ip", new StringValue("X(15)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
