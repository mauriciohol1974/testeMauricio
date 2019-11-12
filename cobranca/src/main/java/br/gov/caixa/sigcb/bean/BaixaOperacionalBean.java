//Bean alterado manualmente, cuidado ao gerar....

package br.gov.caixa.sigcb.bean;

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
import br.com.politec.sao.util.Formatacao;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.util.Formatador;

public class BaixaOperacionalBean extends SigcbBean {
    /**     
	 * 
	 */
	private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidadePv;

    private java.lang.Long cpfCnpj;

    private java.util.Date dataFinal;

    private java.util.Date dataInicial;

    private java.util.Date dataMovimento;

    private java.lang.Long guia;

    private java.lang.String hora;

    private java.lang.String informacaoAlterada;

    private java.lang.String nomeCedente;

    private java.lang.String nomeUnidadePv;

    private java.lang.Long selecaoRadio;

    private java.lang.Long tipoPessoa;

    private java.lang.String usuario;

    private java.lang.String valorAnterior;

    private java.lang.String valorAtual;
    
    
    //---------------------
    //Baixa Operacional
    //---------------------
    
    private Long nuIdentificacao;
    private Long nuIdentiBaixaOper;
    private String dtHoraBaixaOper;
    private Money vlrBaixaOper;
    private String tpBaixaOper;
    

    public BaixaOperacionalBean() {
        this.codigoCedente = null;
        this.codigoUnidadePv = null;
        this.cpfCnpj = null;
        this.dataFinal = null;
        this.dataInicial = null;
        this.dataMovimento = null;
        this.guia = null;
        this.hora = null;
        this.informacaoAlterada = null;
        this.nomeCedente = null;
        this.nomeUnidadePv = null;
        this.selecaoRadio = null;
        this.tipoPessoa = null;
        this.usuario = null;
        this.valorAnterior = null;
        this.valorAtual = null;
        this.nuIdentificacao=null;
        this.nuIdentiBaixaOper=null;
        this.dtHoraBaixaOper=null;
        this.vlrBaixaOper=null;
        this.tpBaixaOper=null;
        
    }

    public Long getNuIdentiBaixaOper() {
		return nuIdentiBaixaOper;
	}

	public void setNuIdentiBaixaOper(Long nuIdentiBaixaOper) {
		this.nuIdentiBaixaOper = nuIdentiBaixaOper;
	}



	public String getDtHoraBaixaOper() {
		return dtHoraBaixaOper;
	}

	public void setDtHoraBaixaOper(String dtHoraBaixaOper) {
		this.dtHoraBaixaOper = dtHoraBaixaOper;
	}

	public Money getVlrBaixaOper() {
		return vlrBaixaOper;
	}

	public void setVlrBaixaOper(Money vlrBaixaOper) {
		this.vlrBaixaOper = vlrBaixaOper;
	}

	public String getTpBaixaOper() {
		return tpBaixaOper;
	}

	public void setTpBaixaOper(String tpBaixaOper) {
		this.tpBaixaOper = tpBaixaOper;
	}

	public String getApplicationName() {
        return "HistoricoCedenteBean";
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

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
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

    public java.util.Date getDataMovimento() {
        return this.dataMovimento;
    }

    public void setDataMovimento(java.util.Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public java.lang.Long getGuia() {
        return this.guia;
    }

    public void setGuia(java.lang.Long guia) {
        this.guia = guia;
    }

    public java.lang.String getHora() {
        return this.hora;
    }

    public void setHora(java.lang.String hora) {
        this.hora = hora;
    }

    public java.lang.String getInformacaoAlterada() {
        return this.informacaoAlterada;
    }

    public void setInformacaoAlterada(java.lang.String informacaoAlterada) {
        this.informacaoAlterada = informacaoAlterada;
    }

    public java.lang.String getNomeCedente() {
        return this.nomeCedente;
    }

    public void setNomeCedente(java.lang.String nomeCedente) {
        this.nomeCedente = nomeCedente;
    }

    public java.lang.String getNomeUnidadePv() {
        return this.nomeUnidadePv;
    }

    public void setNomeUnidadePv(java.lang.String nomeUnidadePv) {
        this.nomeUnidadePv = nomeUnidadePv;
    }

    public java.lang.Long getSelecaoRadio() {
        return this.selecaoRadio;
    }

    public void setSelecaoRadio(java.lang.Long selecaoRadio) {
        this.selecaoRadio = selecaoRadio;
    }

    public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public java.lang.String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    public java.lang.String getValorAnterior() {
        return this.valorAnterior;
    }

    public void setValorAnterior(java.lang.String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public java.lang.String getValorAtual() {
        return this.valorAtual;
    }

    public void setValorAtual(java.lang.String valorAtual) {
        this.valorAtual = valorAtual;
    }
    
    

    public Long getNuIdentificacao() {
		return nuIdentificacao;
	}

	public void setNuIdentificacao(Long nuIdentificacao) {
		this.nuIdentificacao = nuIdentificacao;
	}

	// Inicio das customizações
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

    public java.lang.String getTipoPessoaTexto() {
        String tipoPessoaTexto = "";

        if (this.getTipoPessoa() != null) {
            if (this.getTipoPessoa().equals(new Long(1))) {
                tipoPessoaTexto = "FISICA";
            } else if (this.getTipoPessoa().equals(new Long(2))) {
                tipoPessoaTexto = "JURIDICA";
            } else {
                tipoPessoaTexto = "";
            }
        }

        return tipoPessoaTexto;
    }

    public java.lang.String getDataMovimentoFormatada() {
        if (this.dataMovimento != null) {
            return Formatador.formatarData(this.dataMovimento);
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

    public java.lang.String getHoraFormatada() {
        if (this.hora != null) {
            String strHora = Formatacao.removePontosHora(this.hora);
            return Formatacao.colocaPontosHora(strHora);
        } else {
            return "";
        }
    }

    public java.lang.String getGuiaTexto() {
        String strGuia = "";

        if (this.guia != null) {
            switch (this.guia.intValue()) {
            case 1:
                strGuia = "GERAL";
                break;
            case 2:
                strGuia = "FLOAT";
                break;
            case 3:
                strGuia = "CONTAS";
                break;
            case 4:
                strGuia = "CEDENTE ELETRONICO";
                break;
            case 5:
                strGuia = "BLOQUETOS";
                break;
            case 6:
                strGuia = "MENSAGENS";
                break;
            case 7:
                strGuia = "TARIFAS";
                break;
            case 8:
                strGuia = "PARÂMETROS";
                break;
            case 9:
                strGuia = "TODAS";
                break;                
            default:
                strGuia = "GUIA NÃO EXISTE";
                break;
            }
            return strGuia;
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
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadePvFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePv);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    // Término das customizações
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            BaixaOperacionalBean other = (BaixaOperacionalBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidadePv(), other.getCodigoUnidadePv());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getDataFinal(), other.getDataFinal());
            result = result && equals(getDataInicial(), other.getDataInicial());
            result = result
                     && equals(getDataMovimento(), other.getDataMovimento());
            result = result && equals(getGuia(), other.getGuia());
            result = result && equals(getHora(), other.getHora());
            result = result
                     && equals(getInformacaoAlterada(),
                             other.getInformacaoAlterada());
            result = result && equals(getNomeCedente(), other.getNomeCedente());
            result = result
                     && equals(getNomeUnidadePv(), other.getNomeUnidadePv());
            result = result
                     && equals(getSelecaoRadio(), other.getSelecaoRadio());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result && equals(getUsuario(), other.getUsuario());
            result = result
                     && equals(getValorAnterior(), other.getValorAnterior());
            result = result && equals(getValorAtual(), other.getValorAtual());
            
            //Baixa
            result = result && equals(getNuIdentificacao(), other.getNuIdentificacao());
            result = result && equals(getNuIdentiBaixaOper(), other.getNuIdentiBaixaOper());
            result = result && equals(getDtHoraBaixaOper(), other.getDtHoraBaixaOper());
            result = result && equals(getVlrBaixaOper(), other.getVlrBaixaOper());
            result = result && equals(getTpBaixaOper(), other.getTpBaixaOper());
            
            
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
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("dataFinal", DateType.create(), false, true));
        properties.add(new Property("dataInicial",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataMovimento",
                DateType.create(),
                false,
                true));
        properties.add(new Property("guia", LongType.create(), false, true));
        properties.add(new Property("hora", StringType.create(), false, true));
        properties.add(new Property("informacaoAlterada",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeCedente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadePv",
                StringType.create(),
                false,
                true));
        properties.add(new Property("selecaoRadio",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("usuario", StringType.create(), false, true));
        properties.add(new Property("valorAnterior",
                StringType.create(),
                false,
                true));
        properties.add(new Property("valorAtual",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nuIdentificacao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nuIdentiBaixaOper",
                LongType.create(),
                false,
                true));
        properties.add(new Property("dtHoraBaixaOper",
        		StringType.create(),
                false,
                true));
        properties.add(new Property("vlrBaixaOper",
                MoneyType.create(),
                false,
                true));
        properties.add(new Property("tpBaixaOper",
                StringType.create(),
                false,
                true));
        
        Layout result = new Layout(properties,
                "BaixaOperacionalBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("dataMovimento", new DateValue("dd.MM.yyyy"));
        Mainframe.put("hora", new StringValue("X(08)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("valorAnterior", new StringValue("X(40)"));
        Mainframe.put("selecaoRadio", new LongValue("9(01)"));
        Mainframe.put("valorAtual", new StringValue("X(40)"));
        Mainframe.put("dataInicial", new DateValue("dd.MM.yyyy"));
        Mainframe.put("nomeCedente", new StringValue("X(40)"));
        Mainframe.put("dataFinal", new DateValue("dd.MM.yyyy"));
        Mainframe.put("codigoUnidadePv", new LongValue("9(04)"));
        Mainframe.put("usuario", new StringValue("X(08)"));
        Mainframe.put("guia", new LongValue("9(01)"));
        Mainframe.put("informacaoAlterada", new StringValue("X(40)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("nomeUnidadePv", new StringValue("X(40)"));
        Mainframe.put("nuIdentificacao", new LongValue("9(19)"));
        Mainframe.put("nuIdentiBaixaOper", new LongValue("9(19)"));
        Mainframe.put("dtHoraBaixaOper", new StringValue("X(26)"));
        Mainframe.put("vlrBaixaOper", new MoneyValue("R$ 9(17)v99"));
        Mainframe.put("tpBaixaOper", new StringValue("X(1)"));
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
