//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteFloatBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoClienteCOCLI;

    private java.lang.Long codigoUnidadePVVinc;

    private java.lang.String descricaoCriticas;

    private java.lang.Long floatAutoAtendimento;

    private java.lang.Long floatCaixaCheque;

    private java.lang.Long floatCaixaDinheiro;

    private java.lang.Long floatCompensacao;

    private java.lang.Long floatCorrespondenteBancario;

    private java.lang.Long floatInternetBanking;

    private java.lang.Long floatLotericoCheque;

    private java.lang.Long floatLotericoDinheiro;

    private java.lang.Long floatStrTed;
    
    private java.lang.Long floatMobile;

    private java.lang.Long meioEntrada;

    private java.lang.Long meioEntradaAutoAtendimento;

    private java.lang.Long meioEntradaCaixaCheque;

    private java.lang.Long meioEntradaCaixaDinheiro;

    private java.lang.Long meioEntradaCompensacao;

    private java.lang.Long meioEntradaCorrespondenteBancario;

    private java.lang.Long meioEntradaInternetBanking;

    private java.lang.Long meioEntradaLotericoCheque;

    private java.lang.Long meioEntradaLotericoDinheiro;

    private java.lang.Long meioEntradaStrTed;
    
    private java.lang.Long meioEntradaMobile;

    private java.lang.String nsuTransacao;

    private java.lang.Long numeroFloat;

    private java.lang.String tipoAcao;

    private java.lang.String tipoConsulta;

    public CedenteFloatBean() {
        this.codigoCedente = null;
        this.codigoClienteCOCLI = null;
        this.codigoUnidadePVVinc = null;
        this.descricaoCriticas = null;
        this.floatAutoAtendimento = null;
        this.floatCaixaCheque = null;
        this.floatCaixaDinheiro = null;
        this.floatCompensacao = null;
        this.floatCorrespondenteBancario = null;
        this.floatInternetBanking = null;
        this.floatLotericoCheque = null;
        this.floatLotericoDinheiro = null;
        this.floatStrTed = null;
        this.floatMobile = null;
        this.meioEntrada = null;
        this.meioEntradaAutoAtendimento = null;
        this.meioEntradaCaixaCheque = null;
        this.meioEntradaCaixaDinheiro = null;
        this.meioEntradaCompensacao = null;
        this.meioEntradaCorrespondenteBancario = null;
        this.meioEntradaInternetBanking = null;
        this.meioEntradaLotericoCheque = null;
        this.meioEntradaLotericoDinheiro = null;
        this.meioEntradaStrTed = null;
        this.meioEntradaMobile = null;
        this.nsuTransacao = null;
        this.numeroFloat = null;
        this.tipoAcao = null;
        this.tipoConsulta = null;
    }

    public String getApplicationName() {
        return "CedenteFloatBean";
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

    public java.lang.String getDescricaoCriticas() {
        return this.descricaoCriticas;
    }

    public void setDescricaoCriticas(java.lang.String descricaoCriticas) {
        this.descricaoCriticas = descricaoCriticas;
    }

    public java.lang.Long getFloatAutoAtendimento() {
        return this.floatAutoAtendimento;
    }

    public void setFloatAutoAtendimento(java.lang.Long floatAutoAtendimento) {
        this.floatAutoAtendimento = floatAutoAtendimento;
    }

    public java.lang.Long getFloatCaixaCheque() {
        return this.floatCaixaCheque;
    }

    public void setFloatCaixaCheque(java.lang.Long floatCaixaCheque) {
        this.floatCaixaCheque = floatCaixaCheque;
    }

    public java.lang.Long getFloatCaixaDinheiro() {
        return this.floatCaixaDinheiro;
    }

    public void setFloatCaixaDinheiro(java.lang.Long floatCaixaDinheiro) {
        this.floatCaixaDinheiro = floatCaixaDinheiro;
    }

    public java.lang.Long getFloatCompensacao() {
        return this.floatCompensacao;
    }

    public void setFloatCompensacao(java.lang.Long floatCompensacao) {
        this.floatCompensacao = floatCompensacao;
    }

    public java.lang.Long getFloatCorrespondenteBancario() {
        return this.floatCorrespondenteBancario;
    }

    public void setFloatCorrespondenteBancario(java.lang.Long floatCorrespondenteBancario) {
        this.floatCorrespondenteBancario = floatCorrespondenteBancario;
    }

    public java.lang.Long getFloatInternetBanking() {
        return this.floatInternetBanking;
    }

    public void setFloatInternetBanking(java.lang.Long floatInternetBanking) {
        this.floatInternetBanking = floatInternetBanking;
    }

    public java.lang.Long getFloatLotericoCheque() {
        return this.floatLotericoCheque;
    }

    public void setFloatLotericoCheque(java.lang.Long floatLotericoCheque) {
        this.floatLotericoCheque = floatLotericoCheque;
    }

    public java.lang.Long getFloatLotericoDinheiro() {
        return this.floatLotericoDinheiro;
    }

    public void setFloatLotericoDinheiro(java.lang.Long floatLotericoDinheiro) {
        this.floatLotericoDinheiro = floatLotericoDinheiro;
    }

    public java.lang.Long getFloatStrTed() {
        return this.floatStrTed;
    }

    public void setFloatStrTed(java.lang.Long floatStrTed) {
        this.floatStrTed = floatStrTed;
    }

    public java.lang.Long getMeioEntrada() {
        return this.meioEntrada;
    }

    public void setMeioEntrada(java.lang.Long meioEntrada) {
        this.meioEntrada = meioEntrada;
    }

    public java.lang.Long getMeioEntradaAutoAtendimento() {
        return this.meioEntradaAutoAtendimento;
    }

    public void setMeioEntradaAutoAtendimento(java.lang.Long meioEntradaAutoAtendimento) {
        this.meioEntradaAutoAtendimento = meioEntradaAutoAtendimento;
    }

    public java.lang.Long getMeioEntradaCaixaCheque() {
        return this.meioEntradaCaixaCheque;
    }

    public void setMeioEntradaCaixaCheque(java.lang.Long meioEntradaCaixaCheque) {
        this.meioEntradaCaixaCheque = meioEntradaCaixaCheque;
    }

    public java.lang.Long getMeioEntradaCaixaDinheiro() {
        return this.meioEntradaCaixaDinheiro;
    }

    public void setMeioEntradaCaixaDinheiro(java.lang.Long meioEntradaCaixaDinheiro) {
        this.meioEntradaCaixaDinheiro = meioEntradaCaixaDinheiro;
    }

    public java.lang.Long getMeioEntradaCompensacao() {
        return this.meioEntradaCompensacao;
    }

    public void setMeioEntradaCompensacao(java.lang.Long meioEntradaCompensacao) {
        this.meioEntradaCompensacao = meioEntradaCompensacao;
    }

    public java.lang.Long getMeioEntradaCorrespondenteBancario() {
        return this.meioEntradaCorrespondenteBancario;
    }

    public void setMeioEntradaCorrespondenteBancario(java.lang.Long meioEntradaCorrespondenteBancario) {
        this.meioEntradaCorrespondenteBancario = meioEntradaCorrespondenteBancario;
    }

    public java.lang.Long getMeioEntradaInternetBanking() {
        return this.meioEntradaInternetBanking;
    }

    public void setMeioEntradaInternetBanking(java.lang.Long meioEntradaInternetBanking) {
        this.meioEntradaInternetBanking = meioEntradaInternetBanking;
    }

    public java.lang.Long getMeioEntradaLotericoCheque() {
        return this.meioEntradaLotericoCheque;
    }

    public void setMeioEntradaLotericoCheque(java.lang.Long meioEntradaLotericoCheque) {
        this.meioEntradaLotericoCheque = meioEntradaLotericoCheque;
    }

    public java.lang.Long getMeioEntradaLotericoDinheiro() {
        return this.meioEntradaLotericoDinheiro;
    }

    public void setMeioEntradaLotericoDinheiro(java.lang.Long meioEntradaLotericoDinheiro) {
        this.meioEntradaLotericoDinheiro = meioEntradaLotericoDinheiro;
    }

    public java.lang.Long getMeioEntradaStrTed() {
        return this.meioEntradaStrTed;
    }

    public void setMeioEntradaStrTed(java.lang.Long meioEntradaStrTed) {
        this.meioEntradaStrTed = meioEntradaStrTed;
    }

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public java.lang.Long getNumeroFloat() {
        return this.numeroFloat;
    }

    public void setNumeroFloat(java.lang.Long numeroFloat) {
        this.numeroFloat = numeroFloat;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public java.lang.String getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
    

    public java.lang.Long getFloatMobile() {
		return floatMobile;
	}

	public void setFloatMobile(java.lang.Long floatMobile) {
		this.floatMobile = floatMobile;
	}

	public java.lang.Long getMeioEntradaMobile() {
		return meioEntradaMobile;
	}

	public void setMeioEntradaMobile(java.lang.Long meioEntradaMobile) {
		this.meioEntradaMobile = meioEntradaMobile;
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
            CedenteFloatBean other = (CedenteFloatBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoClienteCOCLI(),
                             other.getCodigoClienteCOCLI());
            result = result
                     && equals(getCodigoUnidadePVVinc(),
                             other.getCodigoUnidadePVVinc());
            result = result
                     && equals(getDescricaoCriticas(),
                             other.getDescricaoCriticas());
            result = result
                     && equals(getFloatAutoAtendimento(),
                             other.getFloatAutoAtendimento());
            result = result
                     && equals(getFloatCaixaCheque(),
                             other.getFloatCaixaCheque());
            result = result
                     && equals(getFloatCaixaDinheiro(),
                             other.getFloatCaixaDinheiro());
            result = result
                     && equals(getFloatCompensacao(),
                             other.getFloatCompensacao());
            result = result
                     && equals(getFloatCorrespondenteBancario(),
                             other.getFloatCorrespondenteBancario());
            result = result
                     && equals(getFloatInternetBanking(),
                             other.getFloatInternetBanking());
            result = result
                     && equals(getFloatLotericoCheque(),
                             other.getFloatLotericoCheque());
            result = result
                     && equals(getFloatLotericoDinheiro(),
                             other.getFloatLotericoDinheiro());
            result = result && equals(getFloatStrTed(), other.getFloatStrTed());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result
                     && equals(getMeioEntradaAutoAtendimento(),
                             other.getMeioEntradaAutoAtendimento());
            result = result
                     && equals(getMeioEntradaCaixaCheque(),
                             other.getMeioEntradaCaixaCheque());
            result = result
                     && equals(getMeioEntradaCaixaDinheiro(),
                             other.getMeioEntradaCaixaDinheiro());
            result = result
                     && equals(getMeioEntradaCompensacao(),
                             other.getMeioEntradaCompensacao());
            result = result
                     && equals(getMeioEntradaCorrespondenteBancario(),
                             other.getMeioEntradaCorrespondenteBancario());
            result = result
                     && equals(getMeioEntradaInternetBanking(),
                             other.getMeioEntradaInternetBanking());
            result = result
                     && equals(getMeioEntradaLotericoCheque(),
                             other.getMeioEntradaLotericoCheque());
            result = result
                     && equals(getMeioEntradaLotericoDinheiro(),
                             other.getMeioEntradaLotericoDinheiro());
            result = result
                     && equals(getMeioEntradaStrTed(),
                             other.getMeioEntradaStrTed());
            result = result
                     && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result && equals(getNumeroFloat(), other.getNumeroFloat());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
            result = result && equals(getTipoConsulta(), other.getTipoConsulta());
            
            result = result && equals(getFloatMobile(), other.getFloatMobile());
            result = result && equals(getMeioEntradaMobile(), other.getMeioEntradaMobile());
            
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
        properties.add(new Property("codigoUnidadePVVinc",
                LongType.create(),
                false,
                true));
        properties.add(new Property("descricaoCriticas",
                StringType.create(),
                false,
                true));
        properties.add(new Property("floatAutoAtendimento",
                LongType.create(),
                false,
                true));
        properties.add(new Property("floatCaixaCheque",
                LongType.create(),
                false,
                true));
        properties.add(new Property("floatCaixaDinheiro",
                LongType.create(),
                false,
                true));
        properties.add(new Property("floatCompensacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("floatCorrespondenteBancario",
                LongType.create(),
                false,
                true));
        properties.add(new Property("floatInternetBanking",
                LongType.create(),
                false,
                true));
        properties.add(new Property("floatLotericoCheque",
                LongType.create(),
                false,
                true));
        properties.add(new Property("floatLotericoDinheiro",
                LongType.create(),
                false,
                true));
        properties.add(new Property("floatStrTed",
                LongType.create(),
                false,
                true));
        properties.add(new Property("floatMobile",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntrada",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntradaAutoAtendimento",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntradaCaixaCheque",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntradaCaixaDinheiro",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntradaCompensacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntradaCorrespondenteBancario",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntradaInternetBanking",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntradaLotericoCheque",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntradaLotericoDinheiro",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntradaStrTed",
                LongType.create(),
                false,
                true));
        
        properties.add(new Property("meioEntradaMobile",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("numeroFloat",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedenteFloatBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("floatLotericoDinheiro", new LongValue("9(02)"));
        Mainframe.put("meioEntradaCaixaCheque", new LongValue("9(02)"));
        Mainframe.put("meioEntradaCorrespondenteBancario",
                new LongValue("9(02)"));
        Mainframe.put("floatInternetBanking", new LongValue("9(02)"));
        Mainframe.put("floatCompensacao", new LongValue("9(02)"));
        Mainframe.put("meioEntradaStrTed", new LongValue("9(02)"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("floatCaixaCheque", new LongValue("9(02)"));
        Mainframe.put("descricaoCriticas", new StringValue("X(200)"));
        Mainframe.put("meioEntradaInternetBanking", new LongValue("9(02)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("floatStrTed", new LongValue("9(02)"));
        Mainframe.put("floatMobile", new LongValue("9(02)"));
        Mainframe.put("floatCaixaDinheiro", new LongValue("9(02)"));
        Mainframe.put("floatLotericoCheque", new LongValue("9(02)"));
        Mainframe.put("meioEntradaAutoAtendimento", new LongValue("9(02)"));
        Mainframe.put("tipoConsulta", new StringValue("X(01)"));
        Mainframe.put("meioEntradaCaixaDinheiro", new LongValue("9(02)"));
        Mainframe.put("codigoClienteCOCLI", new LongValue("9(13)"));
        Mainframe.put("floatAutoAtendimento", new LongValue("9(02)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("numeroFloat", new LongValue("9(02)"));
        Mainframe.put("meioEntradaCompensacao", new LongValue("9(02)"));
        Mainframe.put("floatCorrespondenteBancario", new LongValue("9(02)"));
        Mainframe.put("meioEntrada", new LongValue("9(02)"));
        Mainframe.put("codigoUnidadePVVinc", new LongValue("9(04)"));
        Mainframe.put("meioEntradaLotericoCheque", new LongValue("9(02)"));
        Mainframe.put("meioEntradaLotericoDinheiro", new LongValue("9(02)"));
        Mainframe.put("meioEntradaMobile", new LongValue("9(02)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
