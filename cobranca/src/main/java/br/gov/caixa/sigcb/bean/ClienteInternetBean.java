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

public class ClienteInternetBean extends SigcbBean {
    private java.lang.String bairro;

    private java.lang.Long cep;

    private java.lang.Long codigoCedente;

    private java.lang.String codigoUsuario;

    private java.lang.String complemento;

    private java.lang.Long cpfCnpjCedente;

    private java.lang.Long cpfUsuario;

    private java.lang.Long dddCelular;

    private java.lang.Long dddFax;

    private java.lang.Long dddTelefone;

    private java.lang.String departamento;

    private java.lang.String email;

    private java.lang.String endereco;

    private java.lang.String municipio;

    private java.lang.String nome;

    private java.lang.String nomeUsuario;

    private java.lang.Long numero;

    private java.lang.Long numeroCelular;

    private java.lang.Long numeroFax;

    private java.lang.String numeroTelefone;

    private java.lang.Long ramalFax;

    private java.lang.Long ramalTelefone;

    private java.lang.String senha;

    private java.lang.String tipoAcao;

    private java.lang.Long tipoPesquisa;

    private java.lang.Long tipoPessoaCedente;

    private java.lang.String uf;

    private java.lang.String usuarioExistente;

    private java.lang.String cedenteChecked;

    private java.lang.String bit62;

    public ClienteInternetBean() {
        this.bairro = null;
        this.cep = null;
        this.codigoCedente = null;
        this.codigoUsuario = null;
        this.complemento = null;
        this.cpfCnpjCedente = null;
        this.cpfUsuario = null;
        this.dddCelular = null;
        this.dddFax = null;
        this.dddTelefone = null;
        this.departamento = null;
        this.email = null;
        this.endereco = null;
        this.municipio = null;
        this.nome = null;
        this.nomeUsuario = null;
        this.numero = null;
        this.numeroCelular = null;
        this.numeroFax = null;
        this.numeroTelefone = null;
        this.ramalFax = null;
        this.ramalTelefone = null;
        this.senha = null;
        this.tipoAcao = null;
        this.tipoPesquisa = null;
        this.tipoPessoaCedente = null;
        this.uf = null;
        this.usuarioExistente = null;
        this.cedenteChecked = null;
        this.bit62 = null;
    }

    public String getApplicationName() {
        return "ClienteInternetBean";
    }

    public java.lang.String getBairro() {
        return this.bairro;
    }

    public void setBairro(java.lang.String bairro) {
        this.bairro = bairro;
    }

    public java.lang.Long getCep() {
        return this.cep;
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

    public java.lang.Long getCpfCnpjCedente() {
        return this.cpfCnpjCedente;
    }

    public void setCpfCnpjCedente(java.lang.Long cpfCnpjCedente) {
        this.cpfCnpjCedente = cpfCnpjCedente;
    }

    public java.lang.Long getCpfUsuario() {
        return this.cpfUsuario;
    }

    public void setCpfUsuario(java.lang.Long cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public java.lang.Long getDddCelular() {
        return this.dddCelular;
    }

    public void setDddCelular(java.lang.Long dddCelular) {
        this.dddCelular = dddCelular;
    }

    public java.lang.Long getDddFax() {
        return this.dddFax;
    }

    public void setDddFax(java.lang.Long dddFax) {
        this.dddFax = dddFax;
    }

    public java.lang.Long getDddTelefone() {
        return this.dddTelefone;
    }

    public void setDddTelefone(java.lang.Long dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public java.lang.String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(java.lang.String departamento) {
        this.departamento = departamento;
    }

    public java.lang.String getEmail() {
        return this.email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(java.lang.String endereco) {
        this.endereco = endereco;
    }

    public java.lang.String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(java.lang.String municipio) {
        this.municipio = municipio;
    }

    public java.lang.String getNome() {
        return this.nome;
    }

    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    public java.lang.String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(java.lang.String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public java.lang.Long getNumero() {
        return this.numero;
    }

    public void setNumero(java.lang.Long numero) {
        this.numero = numero;
    }

    public java.lang.Long getNumeroCelular() {
        return this.numeroCelular;
    }

    public void setNumeroCelular(java.lang.Long numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public java.lang.Long getNumeroFax() {
        return this.numeroFax;
    }

    public void setNumeroFax(java.lang.Long numeroFax) {
        this.numeroFax = numeroFax;
    }

    public java.lang.String getNumeroTelefone() {
        return this.numeroTelefone;
    }

    public void setNumeroTelefone(java.lang.String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public java.lang.Long getRamalFax() {
        return this.ramalFax;
    }

    public void setRamalFax(java.lang.Long ramalFax) {
        this.ramalFax = ramalFax;
    }

    public java.lang.Long getRamalTelefone() {
        return this.ramalTelefone;
    }

    public void setRamalTelefone(java.lang.Long ramalTelefone) {
        this.ramalTelefone = ramalTelefone;
    }

    public java.lang.String getSenha() {
        return this.senha;
    }

    public void setSenha(java.lang.String senha) {
        this.senha = senha;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.Long getTipoPesquisa() {
        return this.tipoPesquisa;
    }

    public void setTipoPesquisa(java.lang.Long tipoPesquisa) {
        this.tipoPesquisa = tipoPesquisa;
    }

    public java.lang.Long getTipoPessoaCedente() {
        return this.tipoPessoaCedente;
    }

    public void setTipoPessoaCedente(java.lang.Long tipoPessoaCedente) {
        this.tipoPessoaCedente = tipoPessoaCedente;
    }

    public java.lang.String getUf() {
        return this.uf;
    }

    public void setUf(java.lang.String uf) {
        this.uf = uf;
    }

    public java.lang.String getUsuarioExistente() {
        return this.usuarioExistente;
    }

    public void setUsuarioExistente(java.lang.String usuarioExistente) {
        this.usuarioExistente = usuarioExistente;
    }

    public java.lang.String getCedenteChecked() {
        return this.cedenteChecked;
    }

    public void setCedenteChecked(java.lang.String cedenteChecked) {
        this.cedenteChecked = cedenteChecked;
    }

    public java.lang.String getBit62() {
        return this.bit62;
    }

    public void setBit62(java.lang.String bit62) {
        this.bit62 = bit62;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // EAM - 05/09/05 - Ini
    public java.lang.String getCpfUsuarioFormatado() {
        String cpfCnpjTexto = "";
        cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfUsuario()
                .toString(), 11);
        cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        return cpfCnpjTexto;
    }

    public java.lang.String getCpfCnpjCedenteFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoaCedente().equals(new Long(1))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjCedente()
                    .toString(), 11);
        } else if (this.getTipoPessoaCedente().equals(new Long(2))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjCedente()
                    .toString(), 14);
        }
        cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        return cpfCnpjTexto;
    }

    // EAM - 05/09/05 - Fim

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ClienteInternetBean other = (ClienteInternetBean) obj;
            result = result && equals(getBairro(), other.getBairro());
            result = result && equals(getCep(), other.getCep());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getComplemento(), other.getComplemento());
            result = result
                     && equals(getCpfCnpjCedente(), other.getCpfCnpjCedente());
            result = result && equals(getCpfUsuario(), other.getCpfUsuario());
            result = result && equals(getDddCelular(), other.getDddCelular());
            result = result && equals(getDddFax(), other.getDddFax());
            result = result && equals(getDddTelefone(), other.getDddTelefone());
            result = result
                     && equals(getDepartamento(), other.getDepartamento());
            result = result && equals(getEmail(), other.getEmail());
            result = result && equals(getEndereco(), other.getEndereco());
            result = result && equals(getMunicipio(), other.getMunicipio());
            result = result && equals(getNome(), other.getNome());
            result = result && equals(getNomeUsuario(), other.getNomeUsuario());
            result = result && equals(getNumero(), other.getNumero());
            result = result
                     && equals(getNumeroCelular(), other.getNumeroCelular());
            result = result && equals(getNumeroFax(), other.getNumeroFax());
            result = result
                     && equals(getNumeroTelefone(), other.getNumeroTelefone());
            result = result && equals(getRamalFax(), other.getRamalFax());
            result = result
                     && equals(getRamalTelefone(), other.getRamalTelefone());
            result = result && equals(getSenha(), other.getSenha());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result
                     && equals(getTipoPesquisa(), other.getTipoPesquisa());
            result = result
                     && equals(getTipoPessoaCedente(),
                             other.getTipoPessoaCedente());
            result = result && equals(getUf(), other.getUf());
            result = result
                     && equals(getUsuarioExistente(),
                             other.getUsuarioExistente());
            result = result
                     && equals(getCedenteChecked(), other.getCedenteChecked());
            result = result && equals(getBit62(), other.getBit62());
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
        properties.add(new Property("cep", LongType.create(), false, true));
        properties.add(new Property("codigoCedente",
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
        properties.add(new Property("cpfCnpjCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("cpfUsuario",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dddCelular",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dddFax", LongType.create(), false, true));
        properties.add(new Property("dddTelefone",
                LongType.create(),
                false,
                true));
        properties.add(new Property("departamento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("email", StringType.create(), false, true));
        properties.add(new Property("endereco",
                StringType.create(),
                false,
                true));
        properties.add(new Property("municipio",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nome", StringType.create(), false, true));
        properties.add(new Property("nomeUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numero", LongType.create(), false, true));
        properties.add(new Property("numeroCelular",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroFax", LongType.create(), false, true));
        properties.add(new Property("numeroTelefone",
                StringType.create(),
                false,
                true));
        properties.add(new Property("ramalFax", LongType.create(), false, true));
        properties.add(new Property("ramalTelefone",
                LongType.create(),
                false,
                true));
        properties.add(new Property("senha", StringType.create(), false, true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoPesquisa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoaCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("uf", StringType.create(), false, true));
        properties.add(new Property("usuarioExistente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cedenteChecked",
                StringType.create(),
                false,
                true));
        properties.add(new Property("bit62", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "ClienteInternetBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("endereco", new StringValue("X(40)"));
        Mainframe.put("municipio", new StringValue("X(35)"));
        Mainframe.put("senha", new StringValue("X(16)"));
        Mainframe.put("departamento", new StringValue("X(40)"));
        Mainframe.put("numero", new LongValue("9(10)"));
        Mainframe.put("usuarioExistente", new StringValue("X(01)"));
        Mainframe.put("cedenteChecked", new StringValue("X(01)"));
        Mainframe.put("bit62", new StringValue("X(984)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("numeroCelular", new LongValue("9(08)"));
        Mainframe.put("cpfUsuario", new LongValue("9(11)"));
        Mainframe.put("numeroTelefone", new StringValue("X(08)"));
        Mainframe.put("cpfCnpjCedente", new LongValue("9(14)"));
        Mainframe.put("nomeUsuario", new StringValue("X(40)"));
        Mainframe.put("ramalFax", new LongValue("9(04)"));
        Mainframe.put("dddTelefone", new LongValue("9(04)"));
        Mainframe.put("uf", new StringValue("X(02)"));
        Mainframe.put("email", new StringValue("X(50)"));
        Mainframe.put("tipoPesquisa", new LongValue("9(01)"));
        Mainframe.put("numeroFax", new LongValue("9(08)"));
        Mainframe.put("nome", new StringValue("X(40)"));
        Mainframe.put("cep", new LongValue("9(08)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("ramalTelefone", new LongValue("9(04)"));
        Mainframe.put("dddCelular", new LongValue("9(04)"));
        Mainframe.put("tipoPessoaCedente", new LongValue("9(01)"));
        Mainframe.put("bairro", new StringValue("X(25)"));
        Mainframe.put("dddFax", new LongValue("9(04)"));
        Mainframe.put("complemento", new StringValue("X(15)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
