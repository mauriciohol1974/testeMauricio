package br.gov.caixa.sigcb.bean;

import java.io.Serializable;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente JavaBean utilizado para armazenamento de dados de Usuário
 * carregados do LDAP\.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>06/02/2004</DD>
 * </DL>
 * 
 * @author Andrew Betencourt - abetencourt@sao.politec.com.br
 * @author Glauber M. Gallego - ggallego@sao.politec.com.br - Data: 21/06/2004
 *         Atualizações para novos campos LDAP
 */
public class InformacoesUsuarioBean implements Serializable {

    private String nomeGrupo;

    // GMG: campos antigos Ldap CEF
    private String username;

    private String uid;

    private String nomeUsuario;

    private String codigoUsuario;

    private String nomeCargo;

    private String codigoCargo;

    private String nomeFuncao;

    private String codigoFuncao;

    private String nomeUnidade;

    private String codigoUnidade;

    private String numeroCpf;

    private String nomeEmpresa;

    private String numeroCnpj;

    private String codigoUnidadeSub;

    private String descricao;

    private String fax;

    private String email;

    private String celular;

    private String pager;

    private String departamento;

    private String cep;

    private String uf;

    private String rua;

    private String telefone;

    private String title;

    // GMG: novos campos Ldap CEF 4/9/2004
    private String dtNascimento;

    private String codigoLotacaoFisica;

    private String nomeLotacaoFisica;

    private String ufLotacaoFisica;

    private String sgUnidade;

    private String sgLotacaoFisica;

    private String codigoTpUnidade;

    // private String userpassword;
    // private String givenname;
    // private String objectclass;
    // private String sn;
    // private String dn;
    // private String creatorsname;
    // private String createtimestamp;
    // private String modifiersname;
    // private String modifytimestamp;

    /**
     * @return celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @return cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @return codigoCargo
     */
    public String getCodigoCargo() {
        return codigoCargo;
    }

    /**
     * @return codigoFuncao
     */
    public String getCodigoFuncao() {
        return codigoFuncao;
    }

    /**
     * @return codigoLotacaoFisica
     */
    public String getCodigoLotacaoFisica() {
        return codigoLotacaoFisica;
    }

    /**
     * @return codigoTpUnidade
     */
    public String getCodigoTpUnidade() {
        return codigoTpUnidade;
    }

    /**
     * @return codigoUnidade
     */
    public String getCodigoUnidade() {
        return codigoUnidade;
    }

    /**
     * @return codigoUnidadeSub
     */
    public String getCodigoUnidadeSub() {
        return codigoUnidadeSub;
    }

    /**
     * @return codigoUsuario
     */
    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * @return departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return dtNascimento
     */
    public String getDtNascimento() {
        return dtNascimento;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @return nomeCargo
     */
    public String getNomeCargo() {
        return nomeCargo;
    }

    /**
     * @return nomeEmpresa
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * @return nomeFuncao
     */
    public String getNomeFuncao() {
        return nomeFuncao;
    }

    /**
     * @return nomeGrupo
     */
    public String getNomeGrupo() {
        return nomeGrupo;
    }

    /**
     * @return nomeLotacaoFisica
     */
    public String getNomeLotacaoFisica() {
        return nomeLotacaoFisica;
    }

    /**
     * @return nomeUnidade
     */
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    /**
     * @return nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @return numeroCnpj
     */
    public String getNumeroCnpj() {
        return numeroCnpj;
    }

    /**
     * @return numeroCpf
     */
    public String getNumeroCpf() {
        return numeroCpf;
    }

    /**
     * @return pager
     */
    public String getPager() {
        return pager;
    }

    /**
     * @return rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @return sgLotacaoFisica
     */
    public String getSgLotacaoFisica() {
        return sgLotacaoFisica;
    }

    /**
     * @return sgUnidade
     */
    public String getSgUnidade() {
        return sgUnidade;
    }

    /**
     * @return telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @return ufLotacaoFisica
     */
    public String getUfLotacaoFisica() {
        return ufLotacaoFisica;
    }

    /**
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param string
     */
    public void setCelular(String string) {
        celular = string;
    }

    /**
     * @param string
     */
    public void setCep(String string) {
        cep = string;
    }

    /**
     * @param string
     */
    public void setCodigoCargo(String string) {
        codigoCargo = string;
    }

    /**
     * @param string
     */
    public void setCodigoFuncao(String string) {
        codigoFuncao = string;
    }

    /**
     * @param string
     */
    public void setCodigoLotacaoFisica(String string) {
        codigoLotacaoFisica = string;
    }

    /**
     * @param string
     */
    public void setCodigoTpUnidade(String string) {
        codigoTpUnidade = string;
    }

    /**
     * @param string
     */
    public void setCodigoUnidade(String string) {
        codigoUnidade = string;
    }

    /**
     * @param string
     */
    public void setCodigoUnidadeSub(String string) {
        codigoUnidadeSub = string;
    }

    /**
     * @param string
     */
    public void setCodigoUsuario(String string) {
        codigoUsuario = string;
    }

    /**
     * @param string
     */
    public void setDepartamento(String string) {
        departamento = string;
    }

    /**
     * @param string
     */
    public void setDescricao(String string) {
        descricao = string;
    }

    /**
     * @param string
     */
    public void setDtNascimento(String string) {
        dtNascimento = string;
    }

    /**
     * @param string
     */
    public void setEmail(String string) {
        email = string;
    }

    /**
     * @param string
     */
    public void setFax(String string) {
        fax = string;
    }

    /**
     * @param string
     */
    public void setNomeCargo(String string) {
        nomeCargo = string;
    }

    /**
     * @param string
     */
    public void setNomeEmpresa(String string) {
        nomeEmpresa = string;
    }

    /**
     * @param string
     */
    public void setNomeFuncao(String string) {
        nomeFuncao = string;
    }

    /**
     * @param string
     */
    public void setNomeGrupo(String string) {
        nomeGrupo = string;
    }

    /**
     * @param string
     */
    public void setNomeLotacaoFisica(String string) {
        nomeLotacaoFisica = string;
    }

    /**
     * @param string
     */
    public void setNomeUnidade(String string) {
        nomeUnidade = string;
    }

    /**
     * @param string
     */
    public void setNomeUsuario(String string) {
        nomeUsuario = string;
    }

    /**
     * @param string
     */
    public void setNumeroCnpj(String string) {
        numeroCnpj = string;
    }

    /**
     * @param string
     */
    public void setNumeroCpf(String string) {
        numeroCpf = string;
    }

    /**
     * @param string
     */
    public void setPager(String string) {
        pager = string;
    }

    /**
     * @param string
     */
    public void setRua(String string) {
        rua = string;
    }

    /**
     * @param string
     */
    public void setSgLotacaoFisica(String string) {
        sgLotacaoFisica = string;
    }

    /**
     * @param string
     */
    public void setSgUnidade(String string) {
        sgUnidade = string;
    }

    /**
     * @param string
     */
    public void setTelefone(String string) {
        telefone = string;
    }

    /**
     * @param string
     */
    public void setTitle(String string) {
        title = string;
    }

    /**
     * @param string
     */
    public void setUf(String string) {
        uf = string;
    }

    /**
     * @param string
     */
    public void setUfLotacaoFisica(String string) {
        ufLotacaoFisica = string;
    }

    /**
     * @param string
     */
    public void setUid(String string) {
        uid = string;
    }

    /**
     * @param string
     */
    public void setUsername(String string) {
        username = string;
    }

}