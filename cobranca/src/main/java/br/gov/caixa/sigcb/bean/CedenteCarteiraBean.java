//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CedenteCarteiraBean extends SigcbBean {
    private java.lang.Long aVencerQtde;

    private br.com.politec.sao.util.Money aVencerValor;

    private java.lang.Long codigoCedente;

    private java.lang.String especieTitulo;

    private java.lang.Long liquidadosDiaQtde;

    private br.com.politec.sao.util.Money liquidadosDiaValor;

    private java.lang.String situacao;

    private java.lang.Long tipoCarteira;

    private java.lang.Long totalAVencerQtde;

    private br.com.politec.sao.util.Money totalAVencerValor;

    private java.lang.Long totalLiquidadosDiaQtde;

    private br.com.politec.sao.util.Money totalLiquidadosDiaValor;

    private java.lang.Long totalVencendoDiaQtde;

    private br.com.politec.sao.util.Money totalVencendoDiaValor;

    private java.lang.Long totalVencidosQtde;

    private br.com.politec.sao.util.Money totalVencidosValor;

    private java.lang.Long vencendoDiaQtde;

    private br.com.politec.sao.util.Money vencendoDiaValor;

    private java.lang.Long vencidosQtde;

    private br.com.politec.sao.util.Money vencidosValor;

    public CedenteCarteiraBean() {
        this.aVencerQtde = null;
        this.aVencerValor = null;
        this.codigoCedente = null;
        this.especieTitulo = null;
        this.liquidadosDiaQtde = null;
        this.liquidadosDiaValor = null;
        this.situacao = null;
        this.tipoCarteira = null;
        this.totalAVencerQtde = null;
        this.totalAVencerValor = null;
        this.totalLiquidadosDiaQtde = null;
        this.totalLiquidadosDiaValor = null;
        this.totalVencendoDiaQtde = null;
        this.totalVencendoDiaValor = null;
        this.totalVencidosQtde = null;
        this.totalVencidosValor = null;
        this.vencendoDiaQtde = null;
        this.vencendoDiaValor = null;
        this.vencidosQtde = null;
        this.vencidosValor = null;
    }

    public String getApplicationName() {
        return "CedenteCarteiraBean";
    }

    public java.lang.Long getAVencerQtde() {
        return this.aVencerQtde;
    }

    public void setAVencerQtde(java.lang.Long aVencerQtde) {
        this.aVencerQtde = aVencerQtde;
    }

    public br.com.politec.sao.util.Money getAVencerValor() {
        return this.aVencerValor;
    }

    public void setAVencerValor(br.com.politec.sao.util.Money aVencerValor) {
        this.aVencerValor = aVencerValor;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.String getEspecieTitulo() {
        return this.especieTitulo;
    }

    public void setEspecieTitulo(java.lang.String especieTitulo) {
        this.especieTitulo = especieTitulo;
    }

    public java.lang.Long getLiquidadosDiaQtde() {
        return this.liquidadosDiaQtde;
    }

    public void setLiquidadosDiaQtde(java.lang.Long liquidadosDiaQtde) {
        this.liquidadosDiaQtde = liquidadosDiaQtde;
    }

    public br.com.politec.sao.util.Money getLiquidadosDiaValor() {
        return this.liquidadosDiaValor;
    }

    public void setLiquidadosDiaValor(br.com.politec.sao.util.Money liquidadosDiaValor) {
        this.liquidadosDiaValor = liquidadosDiaValor;
    }

    public java.lang.String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(java.lang.String situacao) {
        this.situacao = situacao;
    }

    public java.lang.Long getTipoCarteira() {
        return this.tipoCarteira;
    }

    public void setTipoCarteira(java.lang.Long tipoCarteira) {
        this.tipoCarteira = tipoCarteira;
    }

    public java.lang.Long getTotalAVencerQtde() {
        return this.totalAVencerQtde;
    }

    public void setTotalAVencerQtde(java.lang.Long totalAVencerQtde) {
        this.totalAVencerQtde = totalAVencerQtde;
    }

    public br.com.politec.sao.util.Money getTotalAVencerValor() {
        return this.totalAVencerValor;
    }

    public void setTotalAVencerValor(br.com.politec.sao.util.Money totalAVencerValor) {
        this.totalAVencerValor = totalAVencerValor;
    }

    public java.lang.Long getTotalLiquidadosDiaQtde() {
        return this.totalLiquidadosDiaQtde;
    }

    public void setTotalLiquidadosDiaQtde(java.lang.Long totalLiquidadosDiaQtde) {
        this.totalLiquidadosDiaQtde = totalLiquidadosDiaQtde;
    }

    public br.com.politec.sao.util.Money getTotalLiquidadosDiaValor() {
        return this.totalLiquidadosDiaValor;
    }

    public void setTotalLiquidadosDiaValor(br.com.politec.sao.util.Money totalLiquidadosDiaValor) {
        this.totalLiquidadosDiaValor = totalLiquidadosDiaValor;
    }

    public java.lang.Long getTotalVencendoDiaQtde() {
        return this.totalVencendoDiaQtde;
    }

    public void setTotalVencendoDiaQtde(java.lang.Long totalVencendoDiaQtde) {
        this.totalVencendoDiaQtde = totalVencendoDiaQtde;
    }

    public br.com.politec.sao.util.Money getTotalVencendoDiaValor() {
        return this.totalVencendoDiaValor;
    }

    public void setTotalVencendoDiaValor(br.com.politec.sao.util.Money totalVencendoDiaValor) {
        this.totalVencendoDiaValor = totalVencendoDiaValor;
    }

    public java.lang.Long getTotalVencidosQtde() {
        return this.totalVencidosQtde;
    }

    public void setTotalVencidosQtde(java.lang.Long totalVencidosQtde) {
        this.totalVencidosQtde = totalVencidosQtde;
    }

    public br.com.politec.sao.util.Money getTotalVencidosValor() {
        return this.totalVencidosValor;
    }

    public void setTotalVencidosValor(br.com.politec.sao.util.Money totalVencidosValor) {
        this.totalVencidosValor = totalVencidosValor;
    }

    public java.lang.Long getVencendoDiaQtde() {
        return this.vencendoDiaQtde;
    }

    public void setVencendoDiaQtde(java.lang.Long vencendoDiaQtde) {
        this.vencendoDiaQtde = vencendoDiaQtde;
    }

    public br.com.politec.sao.util.Money getVencendoDiaValor() {
        return this.vencendoDiaValor;
    }

    public void setVencendoDiaValor(br.com.politec.sao.util.Money vencendoDiaValor) {
        this.vencendoDiaValor = vencendoDiaValor;
    }

    public java.lang.Long getVencidosQtde() {
        return this.vencidosQtde;
    }

    public void setVencidosQtde(java.lang.Long vencidosQtde) {
        this.vencidosQtde = vencidosQtde;
    }

    public br.com.politec.sao.util.Money getVencidosValor() {
        return this.vencidosValor;
    }

    public void setVencidosValor(br.com.politec.sao.util.Money vencidosValor) {
        this.vencidosValor = vencidosValor;
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
            CedenteCarteiraBean other = (CedenteCarteiraBean) obj;
            result = result && equals(getAVencerQtde(), other.getAVencerQtde());
            result = result
                     && equals(getAVencerValor(), other.getAVencerValor());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getEspecieTitulo(), other.getEspecieTitulo());
            result = result
                     && equals(getLiquidadosDiaQtde(),
                             other.getLiquidadosDiaQtde());
            result = result
                     && equals(getLiquidadosDiaValor(),
                             other.getLiquidadosDiaValor());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result
                     && equals(getTipoCarteira(), other.getTipoCarteira());
            result = result
                     && equals(getTotalAVencerQtde(),
                             other.getTotalAVencerQtde());
            result = result
                     && equals(getTotalAVencerValor(),
                             other.getTotalAVencerValor());
            result = result
                     && equals(getTotalLiquidadosDiaQtde(),
                             other.getTotalLiquidadosDiaQtde());
            result = result
                     && equals(getTotalLiquidadosDiaValor(),
                             other.getTotalLiquidadosDiaValor());
            result = result
                     && equals(getTotalVencendoDiaQtde(),
                             other.getTotalVencendoDiaQtde());
            result = result
                     && equals(getTotalVencendoDiaValor(),
                             other.getTotalVencendoDiaValor());
            result = result
                     && equals(getTotalVencidosQtde(),
                             other.getTotalVencidosQtde());
            result = result
                     && equals(getTotalVencidosValor(),
                             other.getTotalVencidosValor());
            result = result
                     && equals(getVencendoDiaQtde(), other.getVencendoDiaQtde());
            result = result
                     && equals(getVencendoDiaValor(),
                             other.getVencendoDiaValor());
            result = result
                     && equals(getVencidosQtde(), other.getVencidosQtde());
            result = result
                     && equals(getVencidosValor(), other.getVencidosValor());
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
        properties.add(new Property("aVencerQtde",
                LongType.create(),
                false,
                true));
        properties.add(new Property("aVencerValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("especieTitulo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("liquidadosDiaQtde",
                LongType.create(),
                false,
                true));
        properties.add(new Property("liquidadosDiaValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("situacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoCarteira",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalAVencerQtde",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalAVencerValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalLiquidadosDiaQtde",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalLiquidadosDiaValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalVencendoDiaQtde",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalVencendoDiaValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("totalVencidosQtde",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalVencidosValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("vencendoDiaQtde",
                LongType.create(),
                false,
                true));
        properties.add(new Property("vencendoDiaValor",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("vencidosQtde",
                LongType.create(),
                false,
                true));
        properties.add(new Property("vencidosValor",
                MoneyType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "CedenteCarteiraBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("totalAVencerValor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalVencendoDiaQtde", new LongValue("9(08)"));
        Mainframe.put("aVencerValor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalVencidosQtde", new LongValue("9(08)"));
        Mainframe.put("especieTitulo", new StringValue("X(40)"));
        Mainframe.put("totalLiquidadosDiaValor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("liquidadosDiaValor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("vencendoDiaQtde", new LongValue("9(08)"));
        Mainframe.put("vencendoDiaValor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("liquidadosDiaQtde", new LongValue("9(08)"));
        Mainframe.put("aVencerQtde", new LongValue("9(08)"));
        Mainframe.put("totalVencendoDiaValor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("tipoCarteira", new LongValue("9(02)"));
        Mainframe.put("vencidosValor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("totalLiquidadosDiaQtde", new LongValue("9(08)"));
        Mainframe.put("totalVencidosValor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("situacao", new StringValue("X(01)"));
        Mainframe.put("vencidosQtde", new LongValue("9(08)"));
        Mainframe.put("totalAVencerQtde", new LongValue("9(08)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
