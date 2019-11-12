package br.gov.caixa.sigcb.bean;

import javax.servlet.jsp.JspException;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.DateType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.DateValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.jsp.ComboCNAB;
import br.gov.caixa.sigcb.util.jsp.ComboVan;

public class PvCobradorBean extends SigcbBean {
    private java.lang.String acao;

    private java.lang.String apelido;

    private java.lang.String automacaoCartoraria;

    private java.lang.Long codUnidPVFinal;

    private java.lang.Long codUnidPVInicial;

    private java.lang.Long codigoUnidadePV;
    
    private java.lang.Long codigoUnidadeCentral;

    private java.lang.Long codigoVAN;

    private java.util.Date dataInclusaoAutomacao;

    private java.util.Date dataUltimaAlteracao;

    private java.util.Date dataUltimaRemessa;

    private java.lang.String emailUnidadePV;
    
    private java.lang.String emailUnidadeCentral;

    private java.lang.String endereco;
    
    private java.lang.String enderecoCentral;

    private java.lang.String nomeUnidadePV;
    
    private java.lang.String nomeUnidadeCentral;

    private java.lang.Long numeroCEPate;

    private java.lang.Long numeroCEPate0;

    private java.lang.Long numeroCEPate1;

    private java.lang.Long numeroCEPate10;

    private java.lang.Long numeroCEPate11;

    private java.lang.Long numeroCEPate12;

    private java.lang.Long numeroCEPate13;

    private java.lang.Long numeroCEPate14;

    private java.lang.Long numeroCEPate15;

    private java.lang.Long numeroCEPate16;

    private java.lang.Long numeroCEPate17;

    private java.lang.Long numeroCEPate18;

    private java.lang.Long numeroCEPate19;

    private java.lang.Long numeroCEPate2;

    private java.lang.Long numeroCEPate3;

    private java.lang.Long numeroCEPate4;

    private java.lang.Long numeroCEPate5;

    private java.lang.Long numeroCEPate6;

    private java.lang.Long numeroCEPate7;

    private java.lang.Long numeroCEPate8;

    private java.lang.Long numeroCEPate9;

    private java.lang.Long numeroCEPde;

    private java.lang.Long numeroCEPde0;

    private java.lang.Long numeroCEPde1;

    private java.lang.Long numeroCEPde10;

    private java.lang.Long numeroCEPde11;

    private java.lang.Long numeroCEPde12;

    private java.lang.Long numeroCEPde13;

    private java.lang.Long numeroCEPde14;

    private java.lang.Long numeroCEPde15;

    private java.lang.Long numeroCEPde16;

    private java.lang.Long numeroCEPde17;

    private java.lang.Long numeroCEPde18;

    private java.lang.Long numeroCEPde19;

    private java.lang.Long numeroCEPde2;

    private java.lang.Long numeroCEPde3;

    private java.lang.Long numeroCEPde4;

    private java.lang.Long numeroCEPde5;

    private java.lang.Long numeroCEPde6;

    private java.lang.Long numeroCEPde7;

    private java.lang.Long numeroCEPde8;

    private java.lang.Long numeroCEPde9;

    private java.lang.Long numeroUltimaRemessa;

    private java.lang.Long padraoCNAB;

    private java.lang.Long qntdRegistrosUltRemessa;

    private java.lang.String situacao;

    private java.lang.String tipoAcao;

    private java.lang.String uf;

    private java.lang.String usuario;

    public PvCobradorBean() {
        this.acao = null;
        this.apelido = null;
        this.automacaoCartoraria = null;
        this.codUnidPVFinal = null;
        this.codUnidPVInicial = null;
        this.codigoUnidadePV = null;
        this.codigoUnidadeCentral = null;
        this.codigoVAN = null;
        this.dataInclusaoAutomacao = null;
        this.dataUltimaAlteracao = null;
        this.dataUltimaRemessa = null;
        this.emailUnidadePV = null;
        this.emailUnidadeCentral = null;
        this.endereco = null;
        this.enderecoCentral = null;
        this.nomeUnidadePV = null;
        this.nomeUnidadeCentral = null;
        this.numeroCEPate = null;
        this.numeroCEPate0 = null;
        this.numeroCEPate1 = null;
        this.numeroCEPate10 = null;
        this.numeroCEPate11 = null;
        this.numeroCEPate12 = null;
        this.numeroCEPate13 = null;
        this.numeroCEPate14 = null;
        this.numeroCEPate15 = null;
        this.numeroCEPate16 = null;
        this.numeroCEPate17 = null;
        this.numeroCEPate18 = null;
        this.numeroCEPate19 = null;
        this.numeroCEPate2 = null;
        this.numeroCEPate3 = null;
        this.numeroCEPate4 = null;
        this.numeroCEPate5 = null;
        this.numeroCEPate6 = null;
        this.numeroCEPate7 = null;
        this.numeroCEPate8 = null;
        this.numeroCEPate9 = null;
        this.numeroCEPde = null;
        this.numeroCEPde0 = null;
        this.numeroCEPde1 = null;
        this.numeroCEPde10 = null;
        this.numeroCEPde11 = null;
        this.numeroCEPde12 = null;
        this.numeroCEPde13 = null;
        this.numeroCEPde14 = null;
        this.numeroCEPde15 = null;
        this.numeroCEPde16 = null;
        this.numeroCEPde17 = null;
        this.numeroCEPde18 = null;
        this.numeroCEPde19 = null;
        this.numeroCEPde2 = null;
        this.numeroCEPde3 = null;
        this.numeroCEPde4 = null;
        this.numeroCEPde5 = null;
        this.numeroCEPde6 = null;
        this.numeroCEPde7 = null;
        this.numeroCEPde8 = null;
        this.numeroCEPde9 = null;
        this.numeroUltimaRemessa = null;
        this.padraoCNAB = null;
        this.qntdRegistrosUltRemessa = null;
        this.situacao = null;
        this.tipoAcao = null;
        this.uf = null;
        this.usuario = null;
    }

    public String getApplicationName() {
        return "PvCobradorBean";
    }

    public java.lang.String getAcao() {
        return this.acao;
    }

    public void setAcao(java.lang.String acao) {
        this.acao = acao;
    }

    public java.lang.String getApelido() {
        return this.apelido;
    }

    public void setApelido(java.lang.String apelido) {
        this.apelido = apelido;
    }

    public java.lang.String getAutomacaoCartoraria() {
        return this.automacaoCartoraria;
    }

    public void setAutomacaoCartoraria(java.lang.String automacaoCartoraria) {
        this.automacaoCartoraria = automacaoCartoraria;
    }

    public java.lang.Long getCodUnidPVFinal() {
        return this.codUnidPVFinal;
    }

    public void setCodUnidPVFinal(java.lang.Long codUnidPVFinal) {
        this.codUnidPVFinal = codUnidPVFinal;
    }

    public java.lang.Long getCodUnidPVInicial() {
        return this.codUnidPVInicial;
    }

    public void setCodUnidPVInicial(java.lang.Long codUnidPVInicial) {
        this.codUnidPVInicial = codUnidPVInicial;
    }

    public java.lang.Long getCodigoUnidadePV() {
        return this.codigoUnidadePV;
    }

    public void setCodigoUnidadePV(java.lang.Long codigoUnidadePV) {
        this.codigoUnidadePV = codigoUnidadePV;
    }
    
    public java.lang.Long getCodigoUnidadeCentral() {
        return this.codigoUnidadeCentral;
    }

    public void setCodigoUnidadeCentral(java.lang.Long codigoUnidadeCentral) {
        this.codigoUnidadeCentral = codigoUnidadeCentral;
    }

    public java.lang.Long getCodigoVAN() {
        return this.codigoVAN;
    }

    public void setCodigoVAN(java.lang.Long codigoVAN) {
        this.codigoVAN = codigoVAN;
    }

    public java.util.Date getDataInclusaoAutomacao() {
        return this.dataInclusaoAutomacao;
    }

    public void setDataInclusaoAutomacao(java.util.Date dataInclusaoAutomacao) {
        this.dataInclusaoAutomacao = dataInclusaoAutomacao;
    }

    public java.util.Date getDataUltimaAlteracao() {
        return this.dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(java.util.Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public java.util.Date getDataUltimaRemessa() {
        return this.dataUltimaRemessa;
    }

    public void setDataUltimaRemessa(java.util.Date dataUltimaRemessa) {
        this.dataUltimaRemessa = dataUltimaRemessa;
    }

    public java.lang.String getEmailUnidadePV() {
        return this.emailUnidadePV;
    }

    public void setEmailUnidadePV(java.lang.String emailUnidadePV) {
        this.emailUnidadePV = emailUnidadePV;
    }
    
    public java.lang.String getEmailUnidadeCentral() {
        return this.emailUnidadeCentral;
    }

    public void setEmailUnidadeCentral(java.lang.String emailUnidadeCentral) {
        this.emailUnidadeCentral = emailUnidadeCentral;
    }

    public java.lang.String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(java.lang.String endereco) {
        this.endereco = endereco;
    }
    
    public java.lang.String getEnderecoCentral() {
        return this.enderecoCentral;
    }

    public void setEnderecoCentral(java.lang.String enderecoCentral) {
        this.enderecoCentral = enderecoCentral;
    }

    public java.lang.String getNomeUnidadePV() {
        return this.nomeUnidadePV;
    }

    public void setNomeUnidadePV(java.lang.String nomeUnidadePV) {
        this.nomeUnidadePV = nomeUnidadePV;
    }
    
    public java.lang.String getNomeUnidadeCentral() {
        return this.nomeUnidadeCentral;
    }

    public void setNomeUnidadeCentral(java.lang.String nomeUnidadeCentral) {
        this.nomeUnidadeCentral = nomeUnidadeCentral;
    }

    public java.lang.Long getNumeroCEPate() {
        return this.numeroCEPate;
    }

    public void setNumeroCEPate(java.lang.Long numeroCEPate) {
        this.numeroCEPate = numeroCEPate;
    }

    public java.lang.Long getNumeroCEPate0() {
        return this.numeroCEPate0;
    }

    public void setNumeroCEPate0(java.lang.Long numeroCEPate0) {
        this.numeroCEPate0 = numeroCEPate0;
    }

    public java.lang.Long getNumeroCEPate1() {
        return this.numeroCEPate1;
    }

    public void setNumeroCEPate1(java.lang.Long numeroCEPate1) {
        this.numeroCEPate1 = numeroCEPate1;
    }

    public java.lang.Long getNumeroCEPate10() {
        return this.numeroCEPate10;
    }

    public void setNumeroCEPate10(java.lang.Long numeroCEPate10) {
        this.numeroCEPate10 = numeroCEPate10;
    }

    public java.lang.Long getNumeroCEPate11() {
        return this.numeroCEPate11;
    }

    public void setNumeroCEPate11(java.lang.Long numeroCEPate11) {
        this.numeroCEPate11 = numeroCEPate11;
    }

    public java.lang.Long getNumeroCEPate12() {
        return this.numeroCEPate12;
    }

    public void setNumeroCEPate12(java.lang.Long numeroCEPate12) {
        this.numeroCEPate12 = numeroCEPate12;
    }

    public java.lang.Long getNumeroCEPate13() {
        return this.numeroCEPate13;
    }

    public void setNumeroCEPate13(java.lang.Long numeroCEPate13) {
        this.numeroCEPate13 = numeroCEPate13;
    }

    public java.lang.Long getNumeroCEPate14() {
        return this.numeroCEPate14;
    }

    public void setNumeroCEPate14(java.lang.Long numeroCEPate14) {
        this.numeroCEPate14 = numeroCEPate14;
    }

    public java.lang.Long getNumeroCEPate15() {
        return this.numeroCEPate15;
    }

    public void setNumeroCEPate15(java.lang.Long numeroCEPate15) {
        this.numeroCEPate15 = numeroCEPate15;
    }

    public java.lang.Long getNumeroCEPate16() {
        return this.numeroCEPate16;
    }

    public void setNumeroCEPate16(java.lang.Long numeroCEPate16) {
        this.numeroCEPate16 = numeroCEPate16;
    }

    public java.lang.Long getNumeroCEPate17() {
        return this.numeroCEPate17;
    }

    public void setNumeroCEPate17(java.lang.Long numeroCEPate17) {
        this.numeroCEPate17 = numeroCEPate17;
    }

    public java.lang.Long getNumeroCEPate18() {
        return this.numeroCEPate18;
    }

    public void setNumeroCEPate18(java.lang.Long numeroCEPate18) {
        this.numeroCEPate18 = numeroCEPate18;
    }

    public java.lang.Long getNumeroCEPate19() {
        return this.numeroCEPate19;
    }

    public void setNumeroCEPate19(java.lang.Long numeroCEPate19) {
        this.numeroCEPate19 = numeroCEPate19;
    }

    public java.lang.Long getNumeroCEPate2() {
        return this.numeroCEPate2;
    }

    public void setNumeroCEPate2(java.lang.Long numeroCEPate2) {
        this.numeroCEPate2 = numeroCEPate2;
    }

    public java.lang.Long getNumeroCEPate3() {
        return this.numeroCEPate3;
    }

    public void setNumeroCEPate3(java.lang.Long numeroCEPate3) {
        this.numeroCEPate3 = numeroCEPate3;
    }

    public java.lang.Long getNumeroCEPate4() {
        return this.numeroCEPate4;
    }

    public void setNumeroCEPate4(java.lang.Long numeroCEPate4) {
        this.numeroCEPate4 = numeroCEPate4;
    }

    public java.lang.Long getNumeroCEPate5() {
        return this.numeroCEPate5;
    }

    public void setNumeroCEPate5(java.lang.Long numeroCEPate5) {
        this.numeroCEPate5 = numeroCEPate5;
    }

    public java.lang.Long getNumeroCEPate6() {
        return this.numeroCEPate6;
    }

    public void setNumeroCEPate6(java.lang.Long numeroCEPate6) {
        this.numeroCEPate6 = numeroCEPate6;
    }

    public java.lang.Long getNumeroCEPate7() {
        return this.numeroCEPate7;
    }

    public void setNumeroCEPate7(java.lang.Long numeroCEPate7) {
        this.numeroCEPate7 = numeroCEPate7;
    }

    public java.lang.Long getNumeroCEPate8() {
        return this.numeroCEPate8;
    }

    public void setNumeroCEPate8(java.lang.Long numeroCEPate8) {
        this.numeroCEPate8 = numeroCEPate8;
    }

    public java.lang.Long getNumeroCEPate9() {
        return this.numeroCEPate9;
    }

    public void setNumeroCEPate9(java.lang.Long numeroCEPate9) {
        this.numeroCEPate9 = numeroCEPate9;
    }

    public java.lang.Long getNumeroCEPde() {
        return this.numeroCEPde;
    }

    public void setNumeroCEPde(java.lang.Long numeroCEPde) {
        this.numeroCEPde = numeroCEPde;
    }

    public java.lang.Long getNumeroCEPde0() {
        return this.numeroCEPde0;
    }

    public void setNumeroCEPde0(java.lang.Long numeroCEPde0) {
        this.numeroCEPde0 = numeroCEPde0;
    }

    public java.lang.Long getNumeroCEPde1() {
        return this.numeroCEPde1;
    }

    public void setNumeroCEPde1(java.lang.Long numeroCEPde1) {
        this.numeroCEPde1 = numeroCEPde1;
    }

    public java.lang.Long getNumeroCEPde10() {
        return this.numeroCEPde10;
    }

    public void setNumeroCEPde10(java.lang.Long numeroCEPde10) {
        this.numeroCEPde10 = numeroCEPde10;
    }

    public java.lang.Long getNumeroCEPde11() {
        return this.numeroCEPde11;
    }

    public void setNumeroCEPde11(java.lang.Long numeroCEPde11) {
        this.numeroCEPde11 = numeroCEPde11;
    }

    public java.lang.Long getNumeroCEPde12() {
        return this.numeroCEPde12;
    }

    public void setNumeroCEPde12(java.lang.Long numeroCEPde12) {
        this.numeroCEPde12 = numeroCEPde12;
    }

    public java.lang.Long getNumeroCEPde13() {
        return this.numeroCEPde13;
    }

    public void setNumeroCEPde13(java.lang.Long numeroCEPde13) {
        this.numeroCEPde13 = numeroCEPde13;
    }

    public java.lang.Long getNumeroCEPde14() {
        return this.numeroCEPde14;
    }

    public void setNumeroCEPde14(java.lang.Long numeroCEPde14) {
        this.numeroCEPde14 = numeroCEPde14;
    }

    public java.lang.Long getNumeroCEPde15() {
        return this.numeroCEPde15;
    }

    public void setNumeroCEPde15(java.lang.Long numeroCEPde15) {
        this.numeroCEPde15 = numeroCEPde15;
    }

    public java.lang.Long getNumeroCEPde16() {
        return this.numeroCEPde16;
    }

    public void setNumeroCEPde16(java.lang.Long numeroCEPde16) {
        this.numeroCEPde16 = numeroCEPde16;
    }

    public java.lang.Long getNumeroCEPde17() {
        return this.numeroCEPde17;
    }

    public void setNumeroCEPde17(java.lang.Long numeroCEPde17) {
        this.numeroCEPde17 = numeroCEPde17;
    }

    public java.lang.Long getNumeroCEPde18() {
        return this.numeroCEPde18;
    }

    public void setNumeroCEPde18(java.lang.Long numeroCEPde18) {
        this.numeroCEPde18 = numeroCEPde18;
    }

    public java.lang.Long getNumeroCEPde19() {
        return this.numeroCEPde19;
    }

    public void setNumeroCEPde19(java.lang.Long numeroCEPde19) {
        this.numeroCEPde19 = numeroCEPde19;
    }

    public java.lang.Long getNumeroCEPde2() {
        return this.numeroCEPde2;
    }

    public void setNumeroCEPde2(java.lang.Long numeroCEPde2) {
        this.numeroCEPde2 = numeroCEPde2;
    }

    public java.lang.Long getNumeroCEPde3() {
        return this.numeroCEPde3;
    }

    public void setNumeroCEPde3(java.lang.Long numeroCEPde3) {
        this.numeroCEPde3 = numeroCEPde3;
    }

    public java.lang.Long getNumeroCEPde4() {
        return this.numeroCEPde4;
    }

    public void setNumeroCEPde4(java.lang.Long numeroCEPde4) {
        this.numeroCEPde4 = numeroCEPde4;
    }

    public java.lang.Long getNumeroCEPde5() {
        return this.numeroCEPde5;
    }

    public void setNumeroCEPde5(java.lang.Long numeroCEPde5) {
        this.numeroCEPde5 = numeroCEPde5;
    }

    public java.lang.Long getNumeroCEPde6() {
        return this.numeroCEPde6;
    }

    public void setNumeroCEPde6(java.lang.Long numeroCEPde6) {
        this.numeroCEPde6 = numeroCEPde6;
    }

    public java.lang.Long getNumeroCEPde7() {
        return this.numeroCEPde7;
    }

    public void setNumeroCEPde7(java.lang.Long numeroCEPde7) {
        this.numeroCEPde7 = numeroCEPde7;
    }

    public java.lang.Long getNumeroCEPde8() {
        return this.numeroCEPde8;
    }

    public void setNumeroCEPde8(java.lang.Long numeroCEPde8) {
        this.numeroCEPde8 = numeroCEPde8;
    }

    public java.lang.Long getNumeroCEPde9() {
        return this.numeroCEPde9;
    }

    public void setNumeroCEPde9(java.lang.Long numeroCEPde9) {
        this.numeroCEPde9 = numeroCEPde9;
    }

    public java.lang.Long getNumeroUltimaRemessa() {
        return this.numeroUltimaRemessa;
    }

    public void setNumeroUltimaRemessa(java.lang.Long numeroUltimaRemessa) {
        this.numeroUltimaRemessa = numeroUltimaRemessa;
    }

    public java.lang.Long getPadraoCNAB() {
        return this.padraoCNAB;
    }

    public void setPadraoCNAB(java.lang.Long padraoCNAB) {
        this.padraoCNAB = padraoCNAB;
    }

    public java.lang.Long getQntdRegistrosUltRemessa() {
        return this.qntdRegistrosUltRemessa;
    }

    public void setQntdRegistrosUltRemessa(java.lang.Long qntdRegistrosUltRemessa) {
        this.qntdRegistrosUltRemessa = qntdRegistrosUltRemessa;
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

    public java.lang.String getUf() {
        return this.uf;
    }

    public void setUf(java.lang.String uf) {
        this.uf = uf;
    }

    public java.lang.String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadePVFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePV);
        return codigoUnidadeFormatado;
    }
    
    public java.lang.String getCodigoUnidadeCentralFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadeCentral);
        return codigoUnidadeFormatado;
    }

    public java.lang.String getCodUnidPVInicialFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codUnidPVInicial);
        return codigoUnidadeFormatado;
    }

    public java.lang.String getCodUnidPVFinalFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codUnidPVFinal);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    public java.lang.String getPadraoCNABTexto() {
        return ComboCNAB.getDescricao(this.getPadraoCNAB());
    }

    public java.lang.String getCodigoVANTexto() {
        ComboVan combo = new ComboVan();
        String descricao = "";
        try {
            descricao = combo.getDescricao(this.getCodigoVAN());
        } catch (JspException e) {
            LogUtilSigcb.error(e.getMessage());
        }
        return descricao;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            PvCobradorBean other = (PvCobradorBean) obj;
            result = result && equals(getAcao(), other.getAcao());
            result = result && equals(getApelido(), other.getApelido());
            result = result
                     && equals(getAutomacaoCartoraria(),
                             other.getAutomacaoCartoraria());
            result = result
                     && equals(getCodUnidPVFinal(), other.getCodUnidPVFinal());
            result = result
                     && equals(getCodUnidPVInicial(),
                             other.getCodUnidPVInicial());
            result = result
                     && equals(getCodigoUnidadePV(), other.getCodigoUnidadePV());
            result = result
            		 && equals(getCodigoUnidadeCentral(), other.getCodigoUnidadeCentral());
            result = result && equals(getCodigoVAN(), other.getCodigoVAN());
            result = result
                     && equals(getDataInclusaoAutomacao(),
                             other.getDataInclusaoAutomacao());
            result = result
                     && equals(getDataUltimaAlteracao(),
                             other.getDataUltimaAlteracao());
            result = result
                     && equals(getDataUltimaRemessa(),
                             other.getDataUltimaRemessa());
            result = result
                     && equals(getEmailUnidadePV(), other.getEmailUnidadePV());
            result = result
            && equals(getEmailUnidadeCentral(), other.getEmailUnidadeCentral());
            result = result && equals(getEndereco(), other.getEndereco());
            result = result && equals(getEnderecoCentral(), other.getEnderecoCentral());
            result = result
                     && equals(getNomeUnidadePV(), other.getNomeUnidadePV());
            result = result
            && equals(getNomeUnidadeCentral(), other.getNomeUnidadeCentral());
            result = result
                     && equals(getNumeroCEPate(), other.getNumeroCEPate());
            result = result
                     && equals(getNumeroCEPate0(), other.getNumeroCEPate0());
            result = result
                     && equals(getNumeroCEPate1(), other.getNumeroCEPate1());
            result = result
                     && equals(getNumeroCEPate10(), other.getNumeroCEPate10());
            result = result
                     && equals(getNumeroCEPate11(), other.getNumeroCEPate11());
            result = result
                     && equals(getNumeroCEPate12(), other.getNumeroCEPate12());
            result = result
                     && equals(getNumeroCEPate13(), other.getNumeroCEPate13());
            result = result
                     && equals(getNumeroCEPate14(), other.getNumeroCEPate14());
            result = result
                     && equals(getNumeroCEPate15(), other.getNumeroCEPate15());
            result = result
                     && equals(getNumeroCEPate16(), other.getNumeroCEPate16());
            result = result
                     && equals(getNumeroCEPate17(), other.getNumeroCEPate17());
            result = result
                     && equals(getNumeroCEPate18(), other.getNumeroCEPate18());
            result = result
                     && equals(getNumeroCEPate19(), other.getNumeroCEPate19());
            result = result
                     && equals(getNumeroCEPate2(), other.getNumeroCEPate2());
            result = result
                     && equals(getNumeroCEPate3(), other.getNumeroCEPate3());
            result = result
                     && equals(getNumeroCEPate4(), other.getNumeroCEPate4());
            result = result
                     && equals(getNumeroCEPate5(), other.getNumeroCEPate5());
            result = result
                     && equals(getNumeroCEPate6(), other.getNumeroCEPate6());
            result = result
                     && equals(getNumeroCEPate7(), other.getNumeroCEPate7());
            result = result
                     && equals(getNumeroCEPate8(), other.getNumeroCEPate8());
            result = result
                     && equals(getNumeroCEPate9(), other.getNumeroCEPate9());
            result = result && equals(getNumeroCEPde(), other.getNumeroCEPde());
            result = result
                     && equals(getNumeroCEPde0(), other.getNumeroCEPde0());
            result = result
                     && equals(getNumeroCEPde1(), other.getNumeroCEPde1());
            result = result
                     && equals(getNumeroCEPde10(), other.getNumeroCEPde10());
            result = result
                     && equals(getNumeroCEPde11(), other.getNumeroCEPde11());
            result = result
                     && equals(getNumeroCEPde12(), other.getNumeroCEPde12());
            result = result
                     && equals(getNumeroCEPde13(), other.getNumeroCEPde13());
            result = result
                     && equals(getNumeroCEPde14(), other.getNumeroCEPde14());
            result = result
                     && equals(getNumeroCEPde15(), other.getNumeroCEPde15());
            result = result
                     && equals(getNumeroCEPde16(), other.getNumeroCEPde16());
            result = result
                     && equals(getNumeroCEPde17(), other.getNumeroCEPde17());
            result = result
                     && equals(getNumeroCEPde18(), other.getNumeroCEPde18());
            result = result
                     && equals(getNumeroCEPde19(), other.getNumeroCEPde19());
            result = result
                     && equals(getNumeroCEPde2(), other.getNumeroCEPde2());
            result = result
                     && equals(getNumeroCEPde3(), other.getNumeroCEPde3());
            result = result
                     && equals(getNumeroCEPde4(), other.getNumeroCEPde4());
            result = result
                     && equals(getNumeroCEPde5(), other.getNumeroCEPde5());
            result = result
                     && equals(getNumeroCEPde6(), other.getNumeroCEPde6());
            result = result
                     && equals(getNumeroCEPde7(), other.getNumeroCEPde7());
            result = result
                     && equals(getNumeroCEPde8(), other.getNumeroCEPde8());
            result = result
                     && equals(getNumeroCEPde9(), other.getNumeroCEPde9());
            result = result
                     && equals(getNumeroUltimaRemessa(),
                             other.getNumeroUltimaRemessa());
            result = result && equals(getPadraoCNAB(), other.getPadraoCNAB());
            result = result
                     && equals(getQntdRegistrosUltRemessa(),
                             other.getQntdRegistrosUltRemessa());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result && equals(getUf(), other.getUf());
            result = result && equals(getUsuario(), other.getUsuario());
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
        properties.add(new Property("acao", StringType.create(), false, true));
        properties.add(new Property("apelido", StringType.create(), false, true));
        properties.add(new Property("automacaoCartoraria",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codUnidPVFinal",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codUnidPVInicial",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadeCentral",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoVAN", LongType.create(), false, true));
        properties.add(new Property("dataInclusaoAutomacao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataUltimaAlteracao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataUltimaRemessa",
                DateType.create(),
                false,
                true));
        properties.add(new Property("emailUnidadePV",
                StringType.create(),
                false,
                true));
        properties.add(new Property("emailUnidadeCentral",
                StringType.create(),
                false,
                true));
        properties.add(new Property("endereco",
                StringType.create(),
                false,
                true));
        properties.add(new Property("enderecoCentral",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadePV",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadeCentral",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate0",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate1",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate10",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate11",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate12",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate13",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate14",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate15",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate16",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate17",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate18",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate19",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate2",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate3",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate4",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate5",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate6",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate7",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate8",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPate9",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde0",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde1",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde10",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde11",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde12",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde13",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde14",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde15",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde16",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde17",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde18",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde19",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde2",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde3",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde4",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde5",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde6",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde7",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde8",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroCEPde9",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroUltimaRemessa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("padraoCNAB",
                LongType.create(),
                false,
                true));
        properties.add(new Property("qntdRegistrosUltRemessa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("situacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("uf", StringType.create(), false, true));
        properties.add(new Property("usuario", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "PvCobradorBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("emailUnidadePV", new StringValue("X(50)"));
        Mainframe.put("emailUnidadeCentral", new StringValue("X(50)"));
        Mainframe.put("qntdRegistrosUltRemessa", new LongValue("9(09)"));
        Mainframe.put("dataUltimaRemessa", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataUltimaAlteracao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("codUnidPVInicial", new LongValue("9(04)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("numeroCEPde", new LongValue("9(08)"));
        Mainframe.put("codUnidPVFinal", new LongValue("9(04)"));
        Mainframe.put("numeroCEPate19", new LongValue("9(08)"));
        Mainframe.put("acao", new StringValue("X(01)"));
        Mainframe.put("numeroCEPate18", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate17", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate16", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate15", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate14", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate13", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate12", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde19", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate11", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde18", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate10", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde9", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde17", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde8", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde16", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde7", new LongValue("9(08)"));
        Mainframe.put("situacao", new StringValue("X(01)"));
        Mainframe.put("numeroCEPde15", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde6", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde14", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde5", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde13", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate9", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde4", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde12", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate8", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde3", new LongValue("9(08)"));
        Mainframe.put("codigoVAN", new LongValue("9(02)"));
        Mainframe.put("numeroCEPde11", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate7", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde2", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde10", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate6", new LongValue("9(08)"));
        Mainframe.put("numeroCEPde1", new LongValue("9(08)"));
        Mainframe.put("codigoUnidadePV", new LongValue("9(04)"));
        Mainframe.put("codigoUnidadeCentral", new LongValue("9(04)"));
        Mainframe.put("numeroCEPde0", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate5", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate4", new LongValue("9(08)"));
        Mainframe.put("automacaoCartoraria", new StringValue("X(01)"));
        Mainframe.put("uf", new StringValue("X(02)"));
        Mainframe.put("dataInclusaoAutomacao", new DateValue("dd.MM.yyyy"));
        Mainframe.put("numeroCEPate3", new LongValue("9(08)"));
        Mainframe.put("numeroUltimaRemessa", new LongValue("9(06)"));
        Mainframe.put("numeroCEPate2", new LongValue("9(08)"));
        Mainframe.put("numeroCEPate1", new LongValue("9(08)"));
        Mainframe.put("endereco", new StringValue("X(65)"));
        Mainframe.put("enderecoCentral", new StringValue("X(65)"));
        Mainframe.put("apelido", new StringValue("X(06)"));
        Mainframe.put("numeroCEPate0", new LongValue("9(08)"));
        Mainframe.put("usuario", new StringValue("X(08)"));
        Mainframe.put("padraoCNAB", new LongValue("9(01)"));
        Mainframe.put("nomeUnidadePV", new StringValue("X(40)"));
        Mainframe.put("nomeUnidadeCentral", new StringValue("X(40)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
