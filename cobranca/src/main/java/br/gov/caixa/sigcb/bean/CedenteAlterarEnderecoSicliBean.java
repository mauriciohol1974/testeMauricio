package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

public class CedenteAlterarEnderecoSicliBean extends SigcbBean {
    private java.lang.String nome;

    private java.lang.String tpLogradouro;

    private java.lang.String endereco;

    private java.lang.String numero;

    private java.lang.String complemento;

    private java.lang.String bairro;

    private java.lang.String cep;

    private java.lang.String uf;

    private java.lang.String municipio;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoMunicipio;
    
    private String tpPessoa;
    
    private Long nuPessoa;
    
    private String codigoUsuario;

    public CedenteAlterarEnderecoSicliBean() {
        this.nome = null;
        this.tpLogradouro = null;
        this.endereco = null;
        this.numero = null;
        this.complemento = null;
        this.bairro = null;
        this.cep = null;
        this.uf = null;
        this.municipio = null;
        this.codigoCedente = null;
        this.codigoMunicipio = null;
        this.tpPessoa = null;
        this.nuPessoa = null;
        this.codigoUsuario = null;
    }

    @Override
    public String getApplicationName() {
        return "CedenteAlterarEnderecoSicliBean";
    }

    public java.lang.String getBairro() {
        return bairro;
    }

    public void setBairro(java.lang.String bairro) {
        this.bairro = bairro;
    }

    public java.lang.String getCep() {
        return cep;
    }

    public void setCep(java.lang.String cep) {
        this.cep = cep;
    }

    public java.lang.Long getCodigoCedente() {
        return codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(java.lang.Long codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public java.lang.String getComplemento() {
        return complemento;
    }

    public void setComplemento(java.lang.String complemento) {
        this.complemento = complemento;
    }

    public java.lang.String getEndereco() {
        return endereco;
    }

    public void setEndereco(java.lang.String endereco) {
        this.endereco = endereco;
    }

    public java.lang.String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(java.lang.String municipio) {
        this.municipio = municipio;
    }

    public java.lang.String getNome() {
        return nome;
    }

    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    public java.lang.String getNumero() {
        return numero;
    }

    public void setNumero(java.lang.String numero) {
        this.numero = numero;
    }

    public java.lang.String getTpLogradouro() {
        return tpLogradouro;
    }

    public void setTpLogradouro(java.lang.String tpLogradouro) {
        this.tpLogradouro = tpLogradouro;
    }

    public java.lang.String getUf() {
        return uf;
    }

    public void setUf(java.lang.String uf) {
        this.uf = uf;
    }
    
    

    public String getTpPessoa() {
		return tpPessoa;
	}

	public void setTpPessoa(String tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	
	public Long getNuPessoa() {
		return nuPessoa;
	}

	public void setNuPessoa(Long nuPessoa) {
		this.nuPessoa = nuPessoa;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedenteAlterarEnderecoSicliBean other = (CedenteAlterarEnderecoSicliBean) obj;
            result = result && equals(getBairro(), other.getBairro());
            result = result && equals(getCep(), other.getCep());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getComplemento(), other.getComplemento());
            result = result && equals(getEndereco(), other.getEndereco());
            result = result
                     && equals(getTpLogradouro(), other.getTpLogradouro());
            result = result && equals(getMunicipio(), other.getMunicipio());
            result = result
                     && equals(getCodigoMunicipio(), other.getCodigoMunicipio());
            result = result && equals(getNome(), other.getNome());
            result = result && equals(getNumero(), other.getNumero());
            result = result && equals(getUf(), other.getUf());
            result = result && equals(getTpPessoa(), other.getTpPessoa());
            result = result && equals(getNuPessoa(), other.getNuPessoa());
            result = result && equals(getCodigoUsuario(), other.getCodigoUsuario());
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
        properties.add(new Property("cep", StringType.create(), false, true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("complemento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("endereco",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tpLogradouro",
                StringType.create(),
                false,
                true));
        properties.add(new Property("municipio",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tpPessoa",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nuPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoMunicipio",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nome", StringType.create(), false, true));
        properties.add(new Property("numero", StringType.create(), false, true));
        properties.add(new Property("uf", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "CedenteAlterarEnderecoSicliBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("endereco", new StringValue("X(50)"));
        Mainframe.put("tpLogradouro", new StringValue("X(10)"));
        Mainframe.put("municipio", new StringValue("X(35)"));
        Mainframe.put("codigoMunicipio", new LongValue("9(06)"));
        Mainframe.put("numero", new StringValue("X(07)"));
        Mainframe.put("uf", new StringValue("X(02)"));
        Mainframe.put("nome", new StringValue("X(40)"));
        Mainframe.put("cep", new StringValue("X(08)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("bairro", new StringValue("X(40)"));
        Mainframe.put("tpPessoa", new StringValue("X(01)"));
        Mainframe.put("nuPessoa", new LongValue("9(14)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        // TODO JANINE
        Mainframe.put("complemento", new StringValue("X(25)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
