// !!!!!!!!!!!!!!!!! Bean alterado manualmente
// As alteracoes estaop indicadas

package br.gov.caixa.sigcb.bean;

import java.math.BigDecimal;
import java.util.Date;

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
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.util.Formatador;

public class TituloListarBean extends SigcbBean {

    private static final String descricoesUltimoComando[] = {
        "",// 0
        "Envio ao cartório",// 1
        "Sustação de protesto",// 2
        "Estorno de envio",// 3
        "Débito custas cartorárias",// 4
        "2º via ordem de protesto",// 5
        "Suspensão de envio ao cartório",// 6
        "Incluir título na remessa",// 7
        "Baixa por protesto",// 8
        "Liquidado em cartório",// 9
        "Liquidado em cartório incondicional",// 10
        "Baixa manual",// 11
        "Baixa por estorno",// 12
        "2º via de bloqueto",// 13
        "Reinclusão de título",// 14
        "Reinclusão de baixa",// 15
        "Estorno de sustação",// 16
        "Estorno de envio ao cartório com custa cartorária",// 17
        "Alteração de título",// 18
        "Inclusão de título na base",// 19
        "Liquidação",// 20
        "Alteração com reemissão de bloqueto",// 21
        "Reemissão e postagem de bloquetos",// 22
        "Sustado em cartório",// 23
        "Alteração de título descontado", //24
        "Alteração de valor de amortização", //25
        "Transferência para desconto", //26
        "Transferência para cobrança simples", //27
        "Liquidação Direta", //28
        "Liquidação por negociação", //29
        "Estorno de transferência para cobrança simples", //30
        "Estorno de inclusão", //31
        "",
        "","","","","","","","","","","","",""
    };

    private java.lang.Long classificacao;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUltimoComando;

    private java.util.Date dataUltimoComando;

    private java.util.Date dataVencimento;

    private java.lang.String descricaoSituacao;

    private java.lang.String nomeSacado;

    private java.lang.Long nossoNumero;
    
    private java.lang.Long nossoNumeroFim;

    private java.lang.Long quantidade;

    private java.lang.Long quantidadeTotal;

    private java.lang.Long situacao;

    private br.com.politec.sao.util.Money valor;

    private br.com.politec.sao.util.Money valorTotal;
    
    private java.lang.String codigoUsuario;
    
    private java.lang.Long pagina;
    
    private java.lang.Long totalRegistro;
    
    private String ultDescricao;
    
    private String indGarantia;
    
    private String cpfSacado;
    
    private String nuDocto;
    
    private Date dtInclusao;
    
    private String indProtesto;
    
    private String prazoProtDev;
    
    private Date dtBaixa;
    
    private Money valorPago;
    
    private String dePeriodo;
    
    private Date dataInicio;
    
    private Date dataFim;
    
    private String parcela;
    
 	private String cmbEmissao;
 	private String cmbCarteira;
 	private Long nuIdentificaCIP;
 	private Long nuRefereciaCIP;
 	private Long nuBaixa;
	private String controle;
    

    public TituloListarBean() {
        this.classificacao = null;
        this.codigoCedente = null;
        this.codigoUltimoComando = null;
        this.dataUltimoComando = null;
        this.dataVencimento = null;
        this.descricaoSituacao = null;
        this.nomeSacado = null;
        this.nossoNumero = null;
        this.quantidade = null;
        this.quantidadeTotal = null;
        this.situacao = null;
        this.valor = null;
        this.valorTotal = null;
        this.codigoUsuario = null;
        this.pagina = null;
        this.totalRegistro = null;
        this.ultDescricao=null;
        this.nossoNumeroFim=null;
        this.indGarantia=null;
        this.cpfSacado=null;
        this.nuDocto=null;
        this.dtInclusao=null;
        this.indProtesto=null;
        this.prazoProtDev=null;
        this.dtBaixa=null;
        this.valorPago=null;
        this.dePeriodo=null;
        this.dataInicio=null;
        this.dataFim=null;
        this.parcela=null;
        this.cmbCarteira=null;
        this.cmbEmissao=null;
        this.nuBaixa=null;
        this.nuRefereciaCIP=null;
        this.nuIdentificaCIP=null;
		this.controle=null;
        
        
        
    }
    

    
    public String getCmbEmissao() {
		return cmbEmissao;
	}




	public String getControle() {
		return controle;
	}



	public void setControle(String controle) {
		this.controle = controle;
	}
	public void setCmbEmissao(String cmbEmissao) {
		this.cmbEmissao = cmbEmissao;
	}



	public String getCmbCarteira() {
		return cmbCarteira;
	}



	public void setCmbCarteira(String cmbCarteira) {
		this.cmbCarteira = cmbCarteira;
	}



	public Long getNuIdentificaCIP() {
		return nuIdentificaCIP;
	}



	public void setNuIdentificaCIP(Long nuIdentificaCIP) {
		this.nuIdentificaCIP = nuIdentificaCIP;
	}



	public Long getNuRefereciaCIP() {
		return nuRefereciaCIP;
	}



	public void setNuRefereciaCIP(Long nuRefereciaCIP) {
		this.nuRefereciaCIP = nuRefereciaCIP;
	}



	public Long getNuBaixa() {
		return nuBaixa;
	}



	public void setNuBaixa(Long nuBaixa) {
		this.nuBaixa = nuBaixa;
	}



	public String getParcela() {
		return parcela;
	}



	public void setParcela(String parcela) {
		this.parcela = parcela;
	}



	public Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	public Date getDataFim() {
		return dataFim;
	}


	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}


	public String getApplicationName() {
        return "TituloListarBean";
    }

    public java.lang.Long getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(java.lang.Long classificacao) {
        this.classificacao = classificacao;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoUltimoComando() {
        return this.codigoUltimoComando;
    }

    public void setCodigoUltimoComando(java.lang.Long codigoUltimoComando) {
        this.codigoUltimoComando = codigoUltimoComando;
    }

    public java.util.Date getDataUltimoComando() {
        return this.dataUltimoComando;
    }

    public void setDataUltimoComando(java.util.Date dataUltimoComando) {
        this.dataUltimoComando = dataUltimoComando;
    }

    public java.util.Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(java.util.Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public java.lang.String getDescricaoSituacao() {
        return this.descricaoSituacao;
    }

    public void setDescricaoSituacao(java.lang.String descricaoSituacao) {
        this.descricaoSituacao = descricaoSituacao;
    }

    public java.lang.String getNomeSacado() {
        return this.nomeSacado;
    }

    public void setNomeSacado(java.lang.String nomeSacado) {
        this.nomeSacado = nomeSacado;
    }

    public java.lang.Long getNossoNumero() {
        return this.nossoNumero;
    }

    public void setNossoNumero(java.lang.Long nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public java.lang.Long getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(java.lang.Long quantidade) {
        this.quantidade = quantidade;
    }

    public java.lang.Long getQuantidadeTotal() {
        return this.quantidadeTotal;
    }

    public void setQuantidadeTotal(java.lang.Long quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public java.lang.Long getSituacao() {
        return this.situacao;
    }

    public void setSituacao(java.lang.Long situacao) {
        this.situacao = situacao;
    }

    public br.com.politec.sao.util.Money getValor() {
        return this.valor;
    }

    public void setValor(br.com.politec.sao.util.Money valor) {
        this.valor = valor;
    }

    public br.com.politec.sao.util.Money getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(br.com.politec.sao.util.Money valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

   public java.lang.Long getPagina() {
        return this.pagina;
    }

    public void setPagina(java.lang.Long pagina) {
        this.pagina = pagina;
    }

    public java.lang.Long getTotalRegistro() {
        return this.totalRegistro;
    }

    public void setTotalRegistro(java.lang.Long totalRegistro) {
        this.totalRegistro = totalRegistro;
    }
    
    public String getUltDescricao() {
		return ultDescricao;
	}

	public void setUltDescricao(String ultDescricao) {
		this.ultDescricao = ultDescricao;
	}
	
	
	public String getIndProtesto() {
		return indProtesto;
	}

	public void setIndProtesto(String indProtesto) {
		this.indProtesto = indProtesto;
	}

	public String getPrazoProtDev() {
		return prazoProtDev;
	}

	public void setPrazoProtDev(String prazoProtDev) {
		this.prazoProtDev = prazoProtDev;
	}



	public Date getDtInclusao() {
		return dtInclusao;
	}
	
    public java.lang.String getDtInclusaoFormatada() {
        if (this.dtInclusao != null)
            return Formatador.formatarData(this.dtInclusao);
        return "";
    }

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public Date getDtBaixa() {
		return dtBaixa;
	}
	
	public java.lang.String getDtBaixaFormatada() {
        if (this.dtBaixa != null)
            return Formatador.formatarData(this.dtBaixa);
        return "";
    }

	

	public void setDtBaixa(Date dtBaixa) {
		this.dtBaixa = dtBaixa;
	}

	
	public Money getValorPago() {
		return valorPago;
	}

	public void setValorPago(Money valorPago) {
		this.valorPago = valorPago;
	}

	// ------------ daqui
    public java.lang.String getDataVencimentoFormatada() {
        if (this.dataVencimento != null)
            return Formatador.formatarData(this.dataVencimento);
        return "";
    }

    public java.lang.String getDataUltimoComandoFormatada() {
        if (this.dataUltimoComando != null)
            return Formatador.formatarData(this.dataUltimoComando);
        return "";
    }
    
    public java.lang.String getDataInicioFormatada() {
        if (this.dataInicio != null)
            return Formatador.formatarData(this.dataInicio);
        return "";
    }
    
    public java.lang.String getDataFimFormatada() {
        if (this.dataFim != null)
            return Formatador.formatarData(this.dataFim);
        return "";
    }
    

    public java.lang.Long getNossoNumeroFim() {
		return nossoNumeroFim;
	}

	public void setNossoNumeroFim(java.lang.Long nossoNumeroFim) {
		this.nossoNumeroFim = nossoNumeroFim;
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

    public String getDescricaoUltimoComando() {
        return TituloListarBean.descricoesUltimoComando[this.codigoUltimoComando.intValue()];
    }

    // ------------ ate aqui
    
    

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            TituloListarBean other = (TituloListarBean) obj;
            result = result
                     && equals(getClassificacao(), other.getClassificacao());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUltimoComando(),
                             other.getCodigoUltimoComando());
            result = result
                     && equals(getDataUltimoComando(),
                             other.getDataUltimoComando());
            result = result
                     && equals(getDataVencimento(), other.getDataVencimento());
            result = result
                     && equals(getDescricaoSituacao(),
                             other.getDescricaoSituacao());
            result = result && equals(getNomeSacado(), other.getNomeSacado());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result && equals(getQuantidade(), other.getQuantidade());
            result = result
                     && equals(getQuantidadeTotal(), other.getQuantidadeTotal());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result && equals(getValor(), other.getValor());
            result = result && equals(getValorTotal(), other.getValorTotal());
            result = result && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getPagina(), other.getPagina());
            result = result && equals(getTotalRegistro(), other.getTotalRegistro());
            result = result && equals(getUltDescricao(), other.getUltDescricao()); 
            result = result && equals(getNossoNumeroFim(), other.getNossoNumeroFim());
            
            result = result && equals(getIndGarantia(), other.getIndGarantia());
            result = result && equals(getCpfSacado(), other.getCpfSacado());
            result = result && equals(getDtInclusao(), other.getDtInclusao());
            result = result && equals(getIndProtesto(), other.getIndProtesto());
            result = result && equals(getPrazoProtDev(), other.getPrazoProtDev());
            result = result && equals(getValorPago(), other.getValorPago());
            result = result && equals(getDtBaixa(), other.getDtBaixa());
            result = result && equals(getDePeriodo(), other.getDePeriodo());
            result = result && equals(getDataInicio(), other.getDataInicio());
            result = result && equals(getDataFim(), other.getDataFim());
            result = result && equals(getParcela(), other.getParcela());
            
            
            result = result && equals(getCmbCarteira(), other.getCmbCarteira());
            result = result && equals(getCmbEmissao(), other.getCmbEmissao());
            result = result && equals(getNuBaixa(), other.getNuBaixa());
            result = result && equals(getNuRefereciaCIP(), other.getNuRefereciaCIP());
            result = result && equals(getNuIdentificaCIP(), other.getNuIdentificaCIP());
			result = result && equals(getControle(), other.getControle());
            
            

            
            
            return result;
        } else {
            return false;
        }
    }

    public String getDePeriodo() {
		return dePeriodo;
	}

	public void setDePeriodo(String dePeriodo) {
		this.dePeriodo = dePeriodo;
	}

	public String getIndGarantia() {
		return indGarantia;
	}

	public void setIndGarantia(String indGarantia) {
		this.indGarantia = indGarantia;
	}

	public String getCpfSacado() {
		return cpfSacado;
	}

	public void setCpfSacado(String cpfSacado) {
		this.cpfSacado = cpfSacado;
	}

	public String getNuDocto() {
		return nuDocto;
	}

	public void setNuDocto(String nuDocto) {
		this.nuDocto = nuDocto;
	}

	public int hashCode() {
        int result = 0;
        return result;
    }

    private static final Layout layout = initLayout();

    private static Layout initLayout() {
        java.util.TreeSet properties = new java.util.TreeSet();
        properties.add(new Property("classificacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUltimoComando",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dataUltimoComando",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataVencimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataInicio",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataFim",
                DateType.create(),
                false,
                true));
        properties.add(new Property("descricaoSituacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeSacado",
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
        properties.add(new Property("nossoNumeroFim",
                LongType.create(),
                false,
                true));
        properties.add(new Property("quantidade",
                LongType.create(),
                false,
                true));
        properties.add(new Property("quantidadeTotal",
                LongType.create(),
                false,
                true));
        properties.add(new Property("situacao", LongType.create(), false, true));
        properties.add(new Property("valor", MoneyType.create(), false, true));
        properties.add(new Property("valorTotal",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("pagina",
                LongType.create(),
                false,
                true));
        properties.add(new Property("totalRegistro",
                LongType.create(),
                false,
                true));
        properties.add(new Property("ultDescricao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("indGarantia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfSacado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dePeriodo",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nuDocto",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("cmbEmissao",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("cmbCarteira",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("dtInclusao",
        		 DateType.create(),
                false,
                true));
        properties.add(new Property("indProtesto",
                StringType.create(),
                false,
                true));
        properties.add(new Property("prazoProtDev",
                StringType.create(),
                false,
                true));
        
        properties.add(new Property("dtBaixa",
        		 DateType.create(),
                false,
                true));

        properties.add(new Property("valorPago",
        		 MoneyType.create(),
                false,
                true));
        
        properties.add(new Property("nuBaixa",
                LongType.create(),
                false,
                true));
        

        properties.add(new Property("nuRefereciaCIP",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nuIdentificaCIP",
                LongType.create(),
                false,
                true));

		properties.add(new Property("controle",
                StringType.create(),
                false,
                true));
        
        Layout result = new Layout(properties,
                "TituloListarBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("codigoUltimoComando", new LongValue("9(03)"));
        Mainframe.put("dataUltimoComando", new DateValue("dd.MM.yyyy"));
        Mainframe.put("valor", new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("quantidadeTotal", new LongValue("9(08)"));
        Mainframe.put("dataVencimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("situacao", new LongValue("9(02)"));
        Mainframe.put("quantidade", new LongValue("9(08)"));
        Mainframe.put("valorTotal", new MoneyValue("R$ 9(16)v99"));
        Mainframe.put("classificacao", new LongValue("9(02)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        Mainframe.put("nossoNumeroFim", new LongValue("9(18)"));
        Mainframe.put("nomeSacado", new StringValue("X(40)"));
        Mainframe.put("descricaoSituacao", new StringValue("X(40)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("ultDescricao", new StringValue("X(50)"));
        Mainframe.put("pagina", new LongValue("9(08)"));
        Mainframe.put("totalRegistro", new LongValue("9(08)"));
        Mainframe.put("indGarantia", new StringValue("X(01)"));
        Mainframe.put("cpfSacado", new StringValue("X(18)"));
        Mainframe.put("nuDocto", new StringValue("X(15)"));
        Mainframe.put("dtInclusao",  new DateValue("dd.MM.yyyy"));
        Mainframe.put("indProtesto", new StringValue("X(4)"));
        Mainframe.put("prazoProtDev", new StringValue("X(3)"));
        Mainframe.put("dtBaixa",  new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataInicio",  new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataFim",  new DateValue("dd.MM.yyyy"));
        Mainframe.put("valorPago",new MoneyValue("R$ 9(13)v99"));
        Mainframe.put("dePeriodo", new StringValue("X(50)"));
        Mainframe.put("parcela", new StringValue("X(07)"));
        
        Mainframe.put("nuIdentificaCIP", new LongValue("9(19)"));
        Mainframe.put("nuRefereciaCIP", new LongValue("9(19)"));
        Mainframe.put("nuRefereciaCIP", new LongValue("9(19)"));
        
        Mainframe.put("cmbEmissao", new StringValue("X(02)"));
        Mainframe.put("cmbCarteira", new StringValue("X(02)"));
		Mainframe.put("controle", new StringValue("X(218)"));
        
        
     	
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
