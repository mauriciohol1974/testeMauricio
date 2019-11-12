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


public class ConGerTitulosLiquidadosIOFBean extends SigcbBean {
	
    private java.lang.Long tipoInformacao;
    
    private java.lang.Long informacao;
    
    private java.lang.Long mes;
    
    private java.lang.Long ano;
    
    private java.lang.Long decendio;
    
    private java.lang.Long canal;
    
    private java.lang.Long tipoPagamento;
    
    private java.lang.Long quantidadeTitulos;
    
    private br.com.politec.sao.util.Money valorTitulo;
    
    private br.com.politec.sao.util.Money valorCreditado;
    
    private br.com.politec.sao.util.Money valorIOF;

    private java.lang.String nome;

    private java.lang.Long decendio1TotalQuantidade;
    
    private br.com.politec.sao.util.Money decendio1TotalValorTitulos;
    
    private br.com.politec.sao.util.Money decendio1TotalValorCreditado;
    
    private br.com.politec.sao.util.Money decendio1TotalValorIOF;
    
    private java.lang.Long decendio2TotalQuantidade;
    
    private br.com.politec.sao.util.Money decendio2TotalValorTitulos;
    
    private br.com.politec.sao.util.Money decendio2TotalValorCreditado;
    
    private br.com.politec.sao.util.Money decendio2TotalValorIOF;
    
    private java.lang.Long decendio3TotalQuantidade;
    
    private br.com.politec.sao.util.Money decendio3TotalValorTitulos;
    
    private br.com.politec.sao.util.Money decendio3TotalValorCreditado;
    
    private br.com.politec.sao.util.Money decendio3TotalValorIOF;
    
    public ConGerTitulosLiquidadosIOFBean() {
    	this.tipoInformacao = null;
        this.informacao = null;
        this.mes = null;
        this.ano = null;
        this.decendio = null;
        this.canal = null;
        this.tipoPagamento = null;
        this.quantidadeTitulos = null;
        this.valorTitulo = null;
        this.valorCreditado = null;
        this.valorIOF = null;
        this.nome = null;
        this.decendio1TotalQuantidade = null;
        this.decendio1TotalValorTitulos = null;
        this.decendio1TotalValorCreditado = null;
        this.decendio1TotalValorIOF = null;
        this.decendio2TotalQuantidade = null;
        this.decendio2TotalValorTitulos = null;
        this.decendio2TotalValorCreditado = null;
        this.decendio2TotalValorIOF = null;
        this.decendio3TotalQuantidade = null;
        this.decendio3TotalValorTitulos = null;
        this.decendio3TotalValorCreditado = null;
        this.decendio3TotalValorIOF = null;
                
    }

    public String getApplicationName() {
        return "ConGerTitulosLiquidadosIOFBean";
    }
    
    public java.lang.Long getTipoInformacao() {
        return this.tipoInformacao;
    }

    public void setTipoInformacao(java.lang.Long tipoInformacao) {
        this.tipoInformacao = tipoInformacao;
    }

    public java.lang.Long getInformacao() {
        return this.informacao;
    }

    public void setInformacao(java.lang.Long informacao) {
        this.informacao = informacao;
    }
    
    public java.lang.Long getMes() {
        return this.mes;
    }

    public void setMes(java.lang.Long mes) {
        this.mes = mes;
    }
    
    public java.lang.Long getAno() {
        return this.ano;
    }

    public void setAno(java.lang.Long ano) {
        this.ano = ano;
    }
    
    public java.lang.Long getDecendio() {
        return this.decendio;
    }

    public void setDecendio(java.lang.Long decendio) {
        this.decendio = decendio;
    }

    public java.lang.Long getCanal() {
        return this.canal;
    }

    public void setCanal(java.lang.Long canal) {
        this.canal = canal;
    }

    public java.lang.Long getTipoPagamento() {
        return this.tipoPagamento;
    }

    public void setTipoPagamento(java.lang.Long tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public java.lang.Long getQuantidadeTitulos() {
        return this.quantidadeTitulos;
    }

    public void setQuantidadeTitulos(java.lang.Long quantidadeTitulos) {
        this.quantidadeTitulos = quantidadeTitulos;
    }

    public br.com.politec.sao.util.Money getValorTitulo() {
        return this.valorTitulo;
    }

    public void setValorTitulo(br.com.politec.sao.util.Money valorTitulo) {
        this.valorTitulo = valorTitulo;
    }
    
    public br.com.politec.sao.util.Money getValorCreditado() {
        return this.valorCreditado;
    }

    public void setValorCreditado(br.com.politec.sao.util.Money valorCreditado) {
        this.valorCreditado = valorCreditado;
    }
    
    public br.com.politec.sao.util.Money getValorIOF() {
        return this.valorIOF;
    }

    public void setValorIOF(br.com.politec.sao.util.Money valorIOF) {
        this.valorIOF = valorIOF;
    }
    
    public java.lang.String getNome() {
        return this.nome;
    }

    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    public java.lang.Long getDecendio1TotalQuantidade() {
        return this.decendio1TotalQuantidade;
    }

    public void setDecendio1TotalQuantidade(java.lang.Long decendio1TotalQuantidade) {
        this.decendio1TotalQuantidade = decendio1TotalQuantidade;
    }
    
    public br.com.politec.sao.util.Money getDecendio1TotalValorTitulos() {
        return this.decendio1TotalValorTitulos;
    }

    public void setDecendio1TotalValorTitulos(br.com.politec.sao.util.Money decendio1TotalValorTitulos) {
        this.decendio1TotalValorTitulos = decendio1TotalValorTitulos;
    }
    
    public br.com.politec.sao.util.Money getDecendio1TotalValorCreditado() {
        return this.decendio1TotalValorCreditado;
    }

    public void setDecendio1TotalValorCreditado(br.com.politec.sao.util.Money decendio1TotalValorCreditado) {
        this.decendio1TotalValorCreditado = decendio1TotalValorCreditado;
    }
    
    public br.com.politec.sao.util.Money getDecendio1TotalValorIOF() {
        return this.decendio1TotalValorIOF;
    }

    public void setDecendio1TotalValorIOF(br.com.politec.sao.util.Money decendio1TotalValorIOF) {
        this.decendio1TotalValorIOF = decendio1TotalValorIOF;
    }
 
    public java.lang.Long getDecendio2TotalQuantidade() {
        return this.decendio2TotalQuantidade;
    }

    public void setDecendio2TotalQuantidade(java.lang.Long decendio2TotalQuantidade) {
        this.decendio2TotalQuantidade = decendio2TotalQuantidade;
    }
    
    public br.com.politec.sao.util.Money getDecendio2TotalValorTitulos() {
        return this.decendio2TotalValorTitulos;
    }

    public void setDecendio2TotalValorTitulos(br.com.politec.sao.util.Money decendio2TotalValorTitulos) {
        this.decendio2TotalValorTitulos = decendio2TotalValorTitulos;
    }
    
    public br.com.politec.sao.util.Money getDecendio2TotalValorCreditado() {
        return this.decendio2TotalValorCreditado;
    }

    public void setDecendio2TotalValorCreditado(br.com.politec.sao.util.Money decendio2TotalValorCreditado) {
        this.decendio2TotalValorCreditado = decendio2TotalValorCreditado;
    }
    
    public br.com.politec.sao.util.Money getDecendio2TotalValorIOF() {
        return this.decendio2TotalValorIOF;
    }

    public void setDecendio2TotalValorIOF(br.com.politec.sao.util.Money decendio2TotalValorIOF) {
        this.decendio2TotalValorIOF = decendio2TotalValorIOF;
    }
    
    public java.lang.Long getDecendio3TotalQuantidade() {
        return this.decendio3TotalQuantidade;
    }

    public void setDecendio3TotalQuantidade(java.lang.Long decendio3TotalQuantidade) {
        this.decendio3TotalQuantidade = decendio3TotalQuantidade;
    }
    
    public br.com.politec.sao.util.Money getDecendio3TotalValorTitulos() {
        return this.decendio3TotalValorTitulos;
    }

    public void setDecendio3TotalValorTitulos(br.com.politec.sao.util.Money decendio3TotalValorTitulos) {
        this.decendio3TotalValorTitulos = decendio3TotalValorTitulos;
    }
    
    public br.com.politec.sao.util.Money getDecendio3TotalValorCreditado() {
        return this.decendio3TotalValorCreditado;
    }

    public void setDecendio3TotalValorCreditado(br.com.politec.sao.util.Money decendio3TotalValorCreditado) {
        this.decendio3TotalValorCreditado = decendio3TotalValorCreditado;
    }
    
    public br.com.politec.sao.util.Money getDecendio3TotalValorIOF() {
        return this.decendio3TotalValorIOF;
    }

    public void setDecendio3TotalValorIOF(br.com.politec.sao.util.Money decendio3TotalValorIOF) {
        this.decendio3TotalValorIOF = decendio3TotalValorIOF;
    }
 
    
    public String getFormaTipoPagamento() {
        String retorno = "";

        if (this.tipoPagamento != null) {
            switch (this.tipoPagamento.intValue()) {
            case 1:
                retorno = "DINHEIRO";
                break;
            case 2:
                retorno = "CHEQUE";
                break;
            }
        }
        return retorno;
    }
    
    public String getFormaCanal() {
        String retorno = "";

        if (this.canal != null) {
            switch (this.canal.intValue()) {
            case 1:
                retorno = "AUTOMACAO";
                break;
            case 2:
                retorno = "LOTERICOS";
                break;
            case 3:
		        retorno = "DIGITACAO";
		        break;
		    case 4:
		        retorno = "COMPENSACAO";
		        break;
			case 5:
			    retorno = "AUTO ATENDIMENTO";
			    break;
			case 6:
			    retorno = "SIACC";
			    break;
			case 7:
			    retorno = "INTERNET BANKING";
			    break;
			case 8:
			    retorno = "TRC";
			    break;
			case 9:
			    retorno = "CORRESPONDENTE BANCARIO";
			    break;
			case 10:
			    retorno = "CARTORIO";
			    break;
			case 11:
				retorno = "MOBILE PRÉ-PAGO";
				break;
			}
        }
        return retorno;
    }
  
   /* public java.lang.String getDescTipoPessoa() {

        String retorno = "";

        if (this.tipoPessoa != null) {
            switch (this.tipoPessoa.intValue()) {
            case 1:
                retorno = "FISICA";
                break;

            case 2:
                retorno = "JURIDICA";
                break;

            default:
                retorno = this.tipoPessoa.toString();
                break;
            }
        }
        return retorno;
    }

    public java.lang.String getCpfCnpjFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoa().equals(new Long(1))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                    .toString(), 11);
        } else if (this.getTipoPessoa().equals(new Long(2))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                    .toString(), 14);
        }
        cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        return cpfCnpjTexto;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getNossoNumeroFormatado-----------------------
    // EAM - 12/09 - Alterado NN de 17 p/ 18
    public java.lang.String getNossoNumeroFormatado() {
        String nossoNumeroFormatado = Formatador.formatarNossoNumero(this.nossoNumero,
                18);
        return nossoNumeroFormatado;
    }

    // fim-------------getNossoNumeroFormatado-----------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getUnidadeVinculacaoFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.unidadeVinculacao);
        return codigoUnidadeFormatado;
    }*/

    // fim-------------getCodigoUnidadeFormatado---------------------

    
     
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ConGerTitulosLiquidadosIOFBean other = (ConGerTitulosLiquidadosIOFBean) obj;
            result = result && equals(getTipoInformacao(), other.getTipoInformacao());
            result = result && equals(getInformacao(), other.getInformacao());
            result = result && equals(getMes(), other.getMes());
            result = result && equals(getAno(), other.getAno());
            result = result && equals(getDecendio(), other.getDecendio());
            result = result && equals(getCanal(), other.getCanal());
            result = result && equals(getTipoPagamento(), other.getTipoPagamento());
            result = result && equals(getQuantidadeTitulos(), other.getQuantidadeTitulos());
            result = result && equals(getValorTitulo(), other.getValorTitulo());
            result = result && equals(getValorCreditado(), other.getValorCreditado());
            result = result && equals(getValorIOF(), other.getValorIOF());
            result = result && equals(getNome(), other.getNome());
            result = result && equals(getDecendio1TotalQuantidade(), other.getDecendio1TotalQuantidade());
            result = result && equals(getDecendio1TotalValorTitulos(), other.getDecendio1TotalValorTitulos());
            result = result && equals(getDecendio1TotalValorCreditado(), other.getDecendio1TotalValorCreditado());
            result = result && equals(getDecendio1TotalValorIOF(), other.getDecendio1TotalValorIOF());
            result = result && equals(getDecendio2TotalQuantidade(), other.getDecendio2TotalQuantidade());
            result = result && equals(getDecendio2TotalValorTitulos(), other.getDecendio2TotalValorTitulos());
            result = result && equals(getDecendio2TotalValorCreditado(), other.getDecendio2TotalValorCreditado());
            result = result && equals(getDecendio2TotalValorIOF(), other.getDecendio2TotalValorIOF());
            result = result && equals(getDecendio3TotalQuantidade(), other.getDecendio3TotalQuantidade());
            result = result && equals(getDecendio3TotalValorTitulos(), other.getDecendio3TotalValorTitulos());
            result = result && equals(getDecendio3TotalValorCreditado(), other.getDecendio3TotalValorCreditado());
            result = result && equals(getDecendio3TotalValorIOF(), other.getDecendio3TotalValorIOF());
            
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
        properties.add(new Property("tipoInformacao",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("informacao",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("mes", 
        		LongType.create(), 
        		false, 
        		true));
        properties.add(new Property("ano",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("decendio",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("canal",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("tipoPagamento",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("quantidadeTitulos",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("valorTitulo",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorCreditado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("valorIOF",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("nome", 
        		StringType.create(), 
        		false, 
        		true));
        properties.add(new Property("decendio1TotalQuantidade",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("decendio1TotalValorTitulos",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("decendio1TotalValorCreditado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("decendio1TotalValorIOF",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("decendio2TotalQuantidade",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("decendio2TotalValorTitulos",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("decendio2TotalValorCreditado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("decendio2TotalValorIOF",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("decendio3TotalQuantidade",
        		LongType.create(),
                false,
                true));
        properties.add(new Property("decendio3TotalValorTitulos",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("decendio3TotalValorCreditado",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("decendio3TotalValorIOF",
                MoneyType.create(),
                false,
                true));

        Layout result = new Layout(properties,
                "ConGerTitulosLiquidadosIOFBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("tipoInformacao", new LongValue("9(01)"));
        Mainframe.put("informacao", new LongValue("9(07)"));
        Mainframe.put("mes", new LongValue("9(2)"));
        Mainframe.put("ano", new LongValue("9(4)"));
        Mainframe.put("decendio", new LongValue("9(01)"));
        Mainframe.put("canal", new LongValue("9(2)"));
        Mainframe.put("tipoPagamento", new LongValue("9(1)"));
        Mainframe.put("quantidadeTitulos", new LongValue("9(09)"));
        Mainframe.put("valorTitulo", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("valorCreditado", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("valorIOF", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("nome", new StringValue("X(40)"));   
        Mainframe.put("decendio1TotalQuantidade", new LongValue("9(12)"));
        Mainframe.put("decendio1TotalValorTitulos", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("decendio1TotalValorCreditado", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("decendio1TotalValorIOF", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("decendio2TotalQuantidade", new LongValue("9(12)"));
        Mainframe.put("decendio2TotalValorTitulos", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("decendio2TotalValorCreditado", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("decendio2TotalValorIOF", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("decendio3TotalQuantidade", new LongValue("9(12)"));
        Mainframe.put("decendio3TotalValorTitulos", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("decendio3TotalValorCreditado", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("decendio3TotalValorIOF", new MoneyValue("R$ 9(15)v99"));
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
