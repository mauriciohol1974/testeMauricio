package br.gov.caixa.sigcb.bean;

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

public class ConGerTitulosAlteradosBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidadePv;

    private java.lang.String codigoUsuario;

    private java.lang.String comando;

    private java.util.Date dataAlteracao;

    private java.util.Date dataComando;

    private java.lang.String nomeFantasia;

    private java.lang.String nomeUnidadePv;

    private java.lang.Long nossoNumero;
    
    private String parcela;

    public ConGerTitulosAlteradosBean() {
        this.codigoCedente = null;
        this.codigoUnidadePv = null;
        this.codigoUsuario = null;
        this.comando = null;
        this.dataAlteracao = null;
        this.dataComando = null;
        this.nomeFantasia = null;
        this.nomeUnidadePv = null;
        this.nossoNumero = null;
        this.parcela = null;
    }

    public String getApplicationName() {
        return "ConGerTitulosAlteradosBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoUnidadePv() {
        return this.codigoUnidadePv;
    }

    public void setCodigoUnidadePv(java.lang.Long codigoUnidadePv) {
        this.codigoUnidadePv = codigoUnidadePv;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.String getComando() {
        return this.comando;
    }

    public void setComando(java.lang.String comando) {
        this.comando = comando;
    }

    public java.util.Date getDataAlteracao() {
        return this.dataAlteracao;
    }

    public void setDataAlteracao(java.util.Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public java.util.Date getDataComando() {
        return this.dataComando;
    }

    public void setDataComando(java.util.Date dataComando) {
        this.dataComando = dataComando;
    }

    public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public java.lang.String getNomeUnidadePv() {
        return this.nomeUnidadePv;
    }

    public void setNomeUnidadePv(java.lang.String nomeUnidadePv) {
        this.nomeUnidadePv = nomeUnidadePv;
    }

    public java.lang.Long getNossoNumero() {
        return this.nossoNumero;
    }

    public void setNossoNumero(java.lang.Long nossoNumero) {
        this.nossoNumero = nossoNumero;
    }
    
    

    public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	/* ///////////// novos metodos //////////// */
    public String getDataAlteracaoFormatada() {
        if (this.dataAlteracao != null) {
            return Formatador.formatarData(this.dataAlteracao);
        } else {
            return "";
        }
    }

    public String getDataComandoFormatada() {
        if (this.dataComando != null) {
            return Formatador.formatarData(this.dataComando);
        } else {
            return "";
        }
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getNossoNumeroFormatado-----------------------
    public java.lang.String getNossoNumeroFormatado() {
    	
    	String NN = this.nossoNumero.toString();
    	String nossoNumeroFormatado="";		
    	if (NN.length()==18){
    		nossoNumeroFormatado = Formatador.formatarNossoNumero18(this.nossoNumero);
    	}else{
    		nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumero);
    	}
       
        return nossoNumeroFormatado;
    }

    // fim-------------getNossoNumeroFormatado-----------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadePvFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePv);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    /* ////////// novos metodos(fim) ///////// */

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ConGerTitulosAlteradosBean other = (ConGerTitulosAlteradosBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidadePv(), other.getCodigoUnidadePv());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getComando(), other.getComando());
            result = result
                     && equals(getDataAlteracao(), other.getDataAlteracao());
            result = result && equals(getDataComando(), other.getDataComando());
            result = result
                     && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result
                     && equals(getNomeUnidadePv(), other.getNomeUnidadePv());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result && equals(getParcela(), other.getParcela());
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
        properties.add(new Property("codigoUnidadePv",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("comando", StringType.create(), false, true));
        properties.add(new Property("dataAlteracao",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataComando",
                DateType.create(),
                false,
                true));
        properties.add(new Property("nomeFantasia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadePv",
                StringType.create(),
                false,
                true));
        properties.add(new Property("parcela",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nossoNumero",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ConGerTitulosAlteradosBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("comando", new StringValue("X(40)"));
        Mainframe.put("dataComando", new DateValue("dd.MM.yyyy"));
        Mainframe.put("codigoUnidadePv", new LongValue("9(04)"));
        Mainframe.put("nomeFantasia", new StringValue("X(40)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        Mainframe.put("nomeUnidadePv", new StringValue("X(40)"));
        Mainframe.put("parcela", new StringValue("X(07)"));
        Mainframe.put("dataAlteracao", new DateValue("dd.MM.yyyy"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
