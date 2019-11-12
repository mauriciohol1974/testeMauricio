//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.DateType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.DateValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.PercentualValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class LancamentoTarifaBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.util.Date dataEvento;

    private java.util.Date dataFinal;

    private java.util.Date dataInicial;

    private java.util.Date dataLancamento;

    private java.lang.String nomeServico;

    private br.com.politec.sao.util.Percentual percentualCobrado;

    private java.lang.Long quantidade;

    private br.com.politec.sao.util.Money valorCobrado;

    private br.com.politec.sao.util.Money valorPrevisto;

    private br.com.politec.sao.util.Money valorTarifa;
    
    private String tpConsulta;
    
    private br.com.politec.sao.util.Money valorTotal;
    
    private java.util.Date dtComando;
    
    private String coUsuario;
    
    private String situacao;
    

    public LancamentoTarifaBean() {
        this.codigoCedente = null;
        this.dataFinal = null;
        this.dataInicial = null;
        this.dataLancamento = null;
        this.nomeServico = null;
        this.percentualCobrado = null;
        this.quantidade = null;
        this.valorCobrado = null;
        this.valorPrevisto = null;
        this.valorTarifa = null;
        this.tpConsulta = null;
        this.valorTotal = null;
        this.dtComando = null;
        this.coUsuario = null;
        this.situacao=null;
    }

    public String getApplicationName() {
        return "LancamentoTarifaBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.util.Date getDataEvento() {
        return this.dataEvento;
    }

    public void setDataEvento(java.util.Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public java.util.Date getDataFinal() {
        return this.dataFinal;
    }

    public void setDataFinal(java.util.Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public java.util.Date getDataInicial() {
        return this.dataInicial;
    }

    public void setDataInicial(java.util.Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public java.util.Date getDataLancamento() {
        return this.dataLancamento;
    }

    public void setDataLancamento(java.util.Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public java.lang.String getNomeServico() {
        return this.nomeServico;
    }

    public void setNomeServico(java.lang.String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public br.com.politec.sao.util.Percentual getPercentualCobrado() {
        return this.percentualCobrado;
    }

    public void setPercentualCobrado(br.com.politec.sao.util.Percentual percentualCobrado) {
        this.percentualCobrado = percentualCobrado;
    }

    public java.lang.Long getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(java.lang.Long quantidade) {
        this.quantidade = quantidade;
    }

    public br.com.politec.sao.util.Money getValorCobrado() {
        return this.valorCobrado;
    }

    public void setValorCobrado(br.com.politec.sao.util.Money valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public br.com.politec.sao.util.Money getValorPrevisto() {
        return this.valorPrevisto;
    }

    public void setValorPrevisto(br.com.politec.sao.util.Money valorPrevisto) {
        this.valorPrevisto = valorPrevisto;
    }

    public br.com.politec.sao.util.Money getValorTarifa() {
        return this.valorTarifa;
    }

    public void setValorTarifa(br.com.politec.sao.util.Money valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    public String getTpConsulta() {
		return tpConsulta;
	}

	public void setTpConsulta(String tpConsulta) {
		this.tpConsulta = tpConsulta;
	}



	public br.com.politec.sao.util.Money getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(br.com.politec.sao.util.Money valorTotal) {
		this.valorTotal = valorTotal;
	}

	public java.util.Date getDtComando() {
		return dtComando;
	}

	public void setDtComando(java.util.Date dtComando) {
		this.dtComando = dtComando;
	}

	public String getCoUsuario() {
		return coUsuario;
	}

	public void setCoUsuario(String coUsuario) {
		this.coUsuario = coUsuario;
	}

	// Inicio das customizações
    public java.lang.String getDataLancamentoFormatada() {
        if (this.dataLancamento != null) {
            return Formatador.formatarData(this.dataLancamento);
        } else {
            return "";
        }
    }
    
    public java.lang.String getDataComandoFormatada() {
        if (this.dtComando != null) {
            return Formatador.formatarData(this.dtComando);
        } else {
            return "";
        }
    }
    

    public java.lang.String getDataEventoFormatada() {
        if (this.dataEvento != null) {
            return Formatador.formatarData(this.dataEvento);
        } else {
            return "";
        }
    }

    public java.lang.String getDataInicialFormatada() {
        if (this.dataInicial != null) {
            return Formatador.formatarData(this.dataInicial);
        } else {
            return "";
        }
    }

    public java.lang.String getDataFinalFormatada() {
        if (this.dataFinal != null) {
            return Formatador.formatarData(this.dataFinal);
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
    // Término das customizações
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            LancamentoTarifaBean other = (LancamentoTarifaBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getDataEvento(), other.getDataEvento());
            result = result && equals(getDataFinal(), other.getDataFinal());
            result = result && equals(getDataInicial(), other.getDataInicial());
            result = result
                     && equals(getDataLancamento(), other.getDataLancamento());
            result = result && equals(getNomeServico(), other.getNomeServico());
            result = result
                     && equals(getPercentualCobrado(),
                             other.getPercentualCobrado());
            result = result && equals(getQuantidade(), other.getQuantidade());
            result = result
                     && equals(getValorCobrado(), other.getValorCobrado());
            result = result
                     && equals(getValorPrevisto(), other.getValorPrevisto());
            result = result && equals(getValorTarifa(), other.getValorTarifa());
            result = result && equals(getTpConsulta(), other.getTpConsulta());
            result = result && equals(getValorTotal(), other.getValorTotal());
            result = result && equals(getDtComando(), other.getDtComando());
            result = result && equals(getCoUsuario(), other.getCoUsuario());
            result = result && equals(getSituacao(), other.getSituacao());
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
        properties.add(new Property("dataEvento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataFinal", DateType.create(), false, true));
        properties.add(new Property("dataInicial",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataLancamento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("nomeServico",
                StringType.create(),
                false,
                true));
        properties.add(new Property("percentualCobrado",
                br.com.politec.sao.business.types.PercentualType.create(),
                false,
                true));
        properties.add(new Property("quantidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("valorCobrado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorPrevisto",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorTarifa",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("tpConsulta",
                StringType.create(),
                false,
                true));
        properties.add(new Property("valorTotal",
        		MoneyType.create(),
                false,
                true));
        properties.add(new Property("dtComando",
        		DateType.create(),
                false,
                true));
        properties.add(new Property("coUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("situacao",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "LancamentoTarifaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("dataLancamento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataEvento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("valorTarifa", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("dataInicial", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valorPrevisto", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("dataFinal", new DateValue("dd.MM.yyyy"));
        Mainframe.put("quantidade", new LongValue("9(07)"));
        Mainframe.put("percentualCobrado", new PercentualValue("9(07)"));
        Mainframe.put("nomeServico", new StringValue("X(40)"));
        Mainframe.put("valorCobrado", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("tpConsulta", new StringValue("X(01)"));
        Mainframe.put("valorTotal", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("dtComando", new DateValue("dd.MM.yyyy"));
        Mainframe.put("coUsuario", new StringValue("X(08)"));
        Mainframe.put("situacao", new StringValue("X(10)"));
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
