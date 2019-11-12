//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.MoneyType;
import br.com.politec.sao.business.types.PercentualType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.MoneyValue;
import br.com.politec.sao.iso.values.PercentualValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Percentual;
import br.gov.caixa.sigcb.util.Formatador;

public class CedentePermissaoBean extends SigcbBean {
	
    private java.lang.Long codigoCedente;
    private String tipoCalculo;
    private String autorizacao;
    private String descricaoCriticas;
    private String tipoConsulta;
    private Long codigoClienteCOCLI;
    private String nsuTransacao;
    private Long codigoUnidadePVVinc;
    private String icgarantia;
    private String icboleto;
    private String icvalor;
    private String creditoOnline;
    private String clienteExterno;
    private String icFinalizacao;
    private String codigoContabil;
    private String unidadeCredito;
    private String icRateio;
    
    private String icCedenteGarantia;
    private Long nuOperacao ;
    private String nuContrato;
    private String icBaixa;
    private String icMarcado;
    private String icDesmarcado;
    private String icContaGar;
    private Long agCta;
    private Long opeCta;
    private Long numCta;
    private Long digCta;
    private String icLancamento;
    private Long nuEvento;
    private String icProposta;
    private String icDebitoTarifa;
    
    private String situcao;
    private String data;
    private String hora;
    private String descricao;
    
    private Long cpfCnpj;
    private String tipoPessoa;

    
   

	public Long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(Long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getSitucao() {
		return situcao;
	}

	public void setSitucao(String situcao) {
		this.situcao = situcao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIcProposta() {
		return icProposta;
	}

	public void setIcProposta(String icProposta) {
		this.icProposta = icProposta;
	}

	public String getIcRateio() {
		return icRateio;
	}

	public void setIcRateio(String icRateio) {
		this.icRateio = icRateio;
	}

	public String getIcboleto() {
		return icboleto;
	}

	public void setIcboleto(String icboleto) {
		this.icboleto = icboleto;
	}

	public String getIcvalor() {
		return icvalor;
	}

	public void setIcvalor(String icvalor) {
		this.icvalor = icvalor;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}



	public String getNsuTransacao() {
		return nsuTransacao;
	}

	public void setNsuTransacao(String nsuTransacao) {
		this.nsuTransacao = nsuTransacao;
	}



	public CedentePermissaoBean() {
        this.codigoCedente = null;
    
    }

    public String getApplicationName() {
        return "CedenteParametrosBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }


	public String getTipoCalculo() {
		return tipoCalculo;
	}

	public void setTipoCalculo(String tipoCalculo) {
		this.tipoCalculo = tipoCalculo;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}
	
	

	

	public String getDescricaoCriticas() {
		return descricaoCriticas;
	}

	public void setDescricaoCriticas(String descricaoCriticas) {
		this.descricaoCriticas = descricaoCriticas;
	}

	
	
	public String getClienteExterno() {
		return clienteExterno;
	}

	public void setClienteExterno(String clienteExterno) {
		this.clienteExterno = clienteExterno;
	}

	public String getIcgarantia() {
		return icgarantia;
	}

	public void setIcgarantia(String icgarantia) {
		this.icgarantia = icgarantia;
	}

	public Long getCodigoClienteCOCLI() {
		return codigoClienteCOCLI;
	}

	public void setCodigoClienteCOCLI(Long codigoClienteCOCLI) {
		this.codigoClienteCOCLI = codigoClienteCOCLI;
	}

	public Long getCodigoUnidadePVVinc() {
		return codigoUnidadePVVinc;
	}

	public void setCodigoUnidadePVVinc(Long codigoUnidadePVVinc) {
		this.codigoUnidadePVVinc = codigoUnidadePVVinc;
	}
	
	

	public String getIcFinalizacao() {
		return icFinalizacao;
	}

	public void setIcFinalizacao(String icFinalizacao) {
		this.icFinalizacao = icFinalizacao;
	}

	public String getCodigoContabil() {
		return codigoContabil;
	}

	public void setCodigoContabil(String codigoContabil) {
		this.codigoContabil = codigoContabil;
	}

	public String getUnidadeCredito() {
		return unidadeCredito;
	}

	public void setUnidadeCredito(String unidadeCredito) {
		this.unidadeCredito = unidadeCredito;
	}

	public String getCreditoOnline() {
		return creditoOnline;
	}

	public void setCreditoOnline(String creditoOnline) {
		this.creditoOnline = creditoOnline;
	}
	
	

	
	


	public String getIcCedenteGarantia() {
		return icCedenteGarantia;
	}

	public void setIcCedenteGarantia(String icCedenteGarantia) {
		this.icCedenteGarantia = icCedenteGarantia;
	}

	

	public String getIcBaixa() {
		return icBaixa;
	}

	public void setIcBaixa(String icBaixa) {
		this.icBaixa = icBaixa;
	}

	public String getIcMarcado() {
		return icMarcado;
	}

	public void setIcMarcado(String icMarcado) {
		this.icMarcado = icMarcado;
	}

	public String getIcDesmarcado() {
		return icDesmarcado;
	}

	public void setIcDesmarcado(String icDesmarcado) {
		this.icDesmarcado = icDesmarcado;
	}

	public String getIcContaGar() {
		return icContaGar;
	}

	public void setIcContaGar(String icContaGar) {
		this.icContaGar = icContaGar;
	}

	

	public String getIcLancamento() {
		return icLancamento;
	}

	public void setIcLancamento(String icLancamento) {
		this.icLancamento = icLancamento;
	}

	

	public Long getNuOperacao() {
		return nuOperacao;
	}

	public void setNuOperacao(Long nuOperacao) {
		this.nuOperacao = nuOperacao;
	}



	public String getNuContrato() {
		return nuContrato;
	}

	public void setNuContrato(String nuContrato) {
		this.nuContrato = nuContrato;
	}

	public Long getAgCta() {
		return agCta;
	}

	public void setAgCta(Long agCta) {
		this.agCta = agCta;
	}

	public Long getOpeCta() {
		return opeCta;
	}

	public void setOpeCta(Long opeCta) {
		this.opeCta = opeCta;
	}

	public Long getNumCta() {
		return numCta;
	}

	public void setNumCta(Long numCta) {
		this.numCta = numCta;
	}

	public Long getDigCta() {
		return digCta;
	}

	public void setDigCta(Long digCta) {
		this.digCta = digCta;
	}

	public Long getNuEvento() {
		return nuEvento;
	}

	public void setNuEvento(Long nuEvento) {
		this.nuEvento = nuEvento;
	}
	
	

	public String getIcDebitoTarifa() {
		return icDebitoTarifa;
	}

	public void setIcDebitoTarifa(String icDebitoTarifa) {
		this.icDebitoTarifa = icDebitoTarifa;
	}

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedentePermissaoBean other = (CedentePermissaoBean) obj;
            result = result  && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result  && equals(getTipoCalculo(), other.getTipoCalculo());
            result = result  && equals(getAutorizacao(), other.getAutorizacao());
            result = result  && equals(getDescricaoCriticas(), other.getDescricaoCriticas());
            result = result  && equals(getCodigoClienteCOCLI(), other.getCodigoClienteCOCLI());
            result = result  && equals(getNsuTransacao(), other.getNsuTransacao());
            result = result  && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result  && equals(getCodigoUnidadePVVinc(), other.getCodigoUnidadePVVinc());
            result = result  && equals(getIcgarantia(), other.getIcgarantia());
            result = result  && equals(getIcboleto(), other.getIcboleto());
            result = result  && equals(getIcvalor(), other.getIcvalor());
            result = result  && equals(getCreditoOnline(), other.getCreditoOnline());
            result = result  && equals(getClienteExterno(), other.getClienteExterno());
            result = result  && equals(getIcFinalizacao(), other.getIcFinalizacao());
            result = result  && equals(getCodigoContabil(), other.getCodigoContabil());
            result = result  && equals(getUnidadeCredito(), other.getUnidadeCredito());
            result = result  && equals(getIcRateio(), other.getIcRateio());
            result = result  && equals(getIcCedenteGarantia(), other.getIcCedenteGarantia());
            result = result  && equals(getNuOperacao(), other.getNuOperacao());
            result = result  && equals(getNuContrato(), other.getNuContrato());
            result = result  && equals(getIcBaixa(), other.getIcBaixa());
            result = result  && equals(getIcMarcado(), other.getIcMarcado());
            result = result  && equals(getIcDesmarcado(), other.getIcDesmarcado());
            result = result  && equals(getIcContaGar(), other.getIcContaGar());
            result = result  && equals(getAgCta(), other.getAgCta());
            result = result  && equals(getOpeCta(), other.getOpeCta());
            result = result  && equals(getNumCta(), other.getNumCta());
            result = result  && equals(getDigCta(), other.getDigCta());
            result = result  && equals(getIcLancamento(), other.getIcLancamento());
            result = result  && equals(getNuEvento(), other.getNuEvento());
            result = result  && equals(getIcProposta(), other.getIcProposta());
            result = result  && equals(getIcDebitoTarifa(), other.getIcDebitoTarifa());
            
            
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
        properties.add(new Property("codigoCedente", LongType.create(), false,  true));
      
        properties.add(new Property("codigoClienteCOCLI", LongType.create(), false, true));
        
        properties.add(new Property("codigoUnidadePVVinc", LongType.create(),  false, true));
        
        properties.add(new Property("tipoCalculo", StringType.create(),  false, true));
        
        properties.add(new Property("autorizacao", StringType.create(),  false, true));
        
        properties.add(new Property("icgarantia", StringType.create(),  false, true));
        
        properties.add(new Property("icboleto", StringType.create(),  false, true));
        
        properties.add(new Property("icvalor", StringType.create(),  false, true));
        
        properties.add(new Property("creditoOnline", StringType.create(),  false, true));
        
        properties.add(new Property("clienteExterno", StringType.create(),  false, true));
        
        properties.add(new Property("icFinalizacao", StringType.create(),  false, true));
        
        properties.add(new Property("codigoContabil", StringType.create(),  false, true));
        
        properties.add(new Property("unidadeCredito", StringType.create(),  false, true));
        
        properties.add(new Property("icRateio", StringType.create(),  false, true));
        
        properties.add(new Property("icCedenteGarantia", StringType.create(),  false, true));
        
        properties.add(new Property("nuOperacao",  LongType.create(),  false, true));
        
        properties.add(new Property("nuContrato",   StringType.create(),  false, true));
        
        properties.add(new Property("icBaixa", StringType.create(),  false, true));
        
        properties.add(new Property("icMarcado", StringType.create(),  false, true));
        
        properties.add(new Property("icDesmarcado", StringType.create(),  false, true));
        
        properties.add(new Property("icContaGar", StringType.create(),  false, true));
        
        properties.add(new Property("agCta",  LongType.create(),  false, true));
        
        properties.add(new Property("opeCta", LongType.create(),  false, true));
        
        properties.add(new Property("numCta",  LongType.create(),  false, true));
        
        properties.add(new Property("digCta",  LongType.create(),  false, true));
        
        properties.add(new Property("icLancamento", StringType.create(),  false, true));
        
        properties.add(new Property("icProposta", StringType.create(),  false, true));
        
        properties.add(new Property("icDebitoTarifa", StringType.create(),  false, true));
        
        properties.add(new Property("nuEvento",  LongType.create(),  false, true));
        
        Layout result = new Layout(properties,  "CedenteParametrosBean",  "br.gov.caixa.sigcb.bean");
       
        MainframeExtension Mainframe = new MainframeExtension();

        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("tipoCalculo", new StringValue("X(02)"));
        Mainframe.put("autorizacao", new StringValue("X(01)"));
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("codigoClienteCOCLI", new LongValue("9(13)"));
        Mainframe.put("codigoUnidadePVVinc", new LongValue("9(04)"));
        Mainframe.put("tipoConsulta", new StringValue("X(01)"));
        Mainframe.put("icgarantia", new StringValue("X(01)"));
        Mainframe.put("icboleto", new StringValue("X(01)"));
        Mainframe.put("icvalor", new StringValue("X(01)"));
        Mainframe.put("creditoOnline", new StringValue("X(01)"));
        Mainframe.put("clienteExterno", new StringValue("X(01)"));
        
        Mainframe.put("icFinalizacao", new StringValue("X(01)"));
        Mainframe.put("codigoContabil", new StringValue("X(06)"));
        Mainframe.put("unidadeCredito", new StringValue("X(01)"));
        Mainframe.put("icRateio", new StringValue("X(01)"));
        
        Mainframe.put("icCedenteGarantia", new StringValue("X(01)"));
        Mainframe.put("nuOperacao", new LongValue("9(04)"));
        Mainframe.put("nuContrato", new StringValue("X(40)"));
        Mainframe.put("icBaixa", new StringValue("X(01)"));
        Mainframe.put("icMarcado", new StringValue("X(01)"));
        Mainframe.put("icDesmarcado", new StringValue("X(01)"));
        Mainframe.put("icContaGar", new StringValue("X(01)"));
        Mainframe.put("agCta", new LongValue("9(04)"));
        Mainframe.put("opeCta", new LongValue("9(04)"));
        Mainframe.put("numCta", new LongValue("9(12)"));
        Mainframe.put("digCta", new LongValue("9(01)"));
        Mainframe.put("icLancamento", new StringValue("X(01)"));
        Mainframe.put("nuEvento", new LongValue("9(06)"));
        Mainframe.put("icProposta", new StringValue("X(01)"));
        Mainframe.put("icDebitoTarifa", new StringValue("X(01)"));
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
