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

public class BancoSacadoBean extends SigcbBean {
    private java.lang.Long codigoBancoSacado;

    private java.lang.Long codigoCedente;

    private java.lang.Long meioEntrada;

    private java.lang.Long navegacao;

    private java.lang.String nomeBancoSacado;

    private java.lang.Long registro;

    private java.lang.String tipoAcao;

    public BancoSacadoBean() {
        this.codigoBancoSacado = null;
        this.codigoCedente = null;
        this.meioEntrada = null;
        this.navegacao = null;
        this.nomeBancoSacado = null;
        this.registro = null;
        this.tipoAcao = null;
    }

    public String getApplicationName() {
        return "BancoSacadoBean";
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

    public java.lang.Long getMeioEntrada() {
        return this.meioEntrada;
    }

    public void setMeioEntrada(java.lang.Long meioEntrada) {
        this.meioEntrada = meioEntrada;
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

    public java.lang.Long getRegistro() {
        return this.registro;
    }

    public void setRegistro(java.lang.Long registro) {
        this.registro = registro;
    }

    public java.lang.String getTipoAcao() {
        return this.tipoAcao;
    }

    public void setTipoAcao(java.lang.String tipoAcao) {
        this.tipoAcao = tipoAcao;
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
            BancoSacadoBean other = (BancoSacadoBean) obj;
            result = result
                     && equals(getCodigoBancoSacado(),
                             other.getCodigoBancoSacado());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result && equals(getNavegacao(), other.getNavegacao());
            result = result
                     && equals(getNomeBancoSacado(), other.getNomeBancoSacado());
            result = result && equals(getRegistro(), other.getRegistro());
            result = result && equals(getTipoAcao(), other.getTipoAcao());
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
        properties.add(new Property("codigoBancoSacado",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("meioEntrada",
                LongType.create(),
                false,
                true));
        properties.add(new Property("navegacao", LongType.create(), false, true));
        properties.add(new Property("nomeBancoSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("registro", LongType.create(), false, true));
        properties.add(new Property("tipoAcao",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "BancoSacadoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("registro", new LongValue("9(04)"));
        Mainframe.put("meioEntrada", new LongValue("9(02)"));
        Mainframe.put("navegacao", new LongValue("9(01)"));
        Mainframe.put("nomeBancoSacado", new StringValue("X(20)"));
        Mainframe.put("tipoAcao", new StringValue("X(01)"));
        Mainframe.put("codigoBancoSacado", new LongValue("9(03)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
