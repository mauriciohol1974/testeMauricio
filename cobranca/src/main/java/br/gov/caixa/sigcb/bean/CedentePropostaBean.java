//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.util.Formatador;

public class CedentePropostaBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long cpfCnpjPessoa;

    private java.lang.String nomeFantasia;

    private java.lang.Long tipoPessoa;

    private java.lang.Long unidade;
    
    private java.lang.String tipoConsulta;
    
    private String cpfCnpj;
    
    private String nomeUnidadePV;
    
    

    public CedentePropostaBean() {
        this.codigoCedente = null;
        this.cpfCnpjPessoa = null;
        this.nomeFantasia = null;
        this.tipoPessoa = null;
        this.unidade = null;
        this.tipoConsulta = null;
        this.cpfCnpj = null;
        this.nomeUnidadePV = null;
      
    }

    public String getApplicationName() {
        return "ConGerCedCenBean";
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

  
    public java.lang.Long getCpfCnpjPessoa() {
        return this.cpfCnpjPessoa;
    }

    public void setCpfCnpjPessoa(java.lang.Long cpfCnpjPessoa) {
        this.cpfCnpjPessoa = cpfCnpjPessoa;
    }

    public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

  

	
	public java.lang.String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(java.lang.String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public java.lang.Long getUnidade() {
		return unidade;
	}

	public void setUnidade(java.lang.Long unidade) {
		this.unidade = unidade;
	}

	
	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNomeUnidadePV() {
		return nomeUnidadePV;
	}

	public void setNomeUnidadePV(String nomeUnidadePV) {
		this.nomeUnidadePV = nomeUnidadePV;
	}

	/*
     * Estes metodos não foi colocado pela framework, foi manual.
     */
    public java.lang.String getTipoPessoaTexto() {
        String tipoPessoaTexto = "";

        if (this.getTipoPessoa().equals(new Long(1))) {
            tipoPessoaTexto = "FISICA";
        } else if (this.getTipoPessoa().equals(new Long(2))) {
            tipoPessoaTexto = "JURIDICA";
        } else {
            tipoPessoaTexto = "";
        }
        return tipoPessoaTexto;
    }

    public java.lang.String getCpfCnpjFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoa().equals(new Long(1))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjPessoa()
                    .toString(), 11);
        } else if (this.getTipoPessoa().equals(new Long(2))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpjPessoa()
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
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedentePropostaBean other = (CedentePropostaBean) obj;
            result = result && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getCpfCnpjPessoa(), other.getCpfCnpjPessoa());
            result = result && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result && equals(getUnidade(), other.getUnidade());
            result = result && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getNomeUnidadePV(), other.getNomeUnidadePV());
           
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
       
        properties.add(new Property("cpfCnpjPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nomeFantasia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadePV",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("unidade",
                LongType.create(),
                false,
                true));
       
        
        Layout result = new Layout(properties,
                "CedentePECBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("nomeFantasia", new StringValue("X(40)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("cpfCnpjPessoa", new LongValue("9(14)"));
        Mainframe.put("unidade", new LongValue("9(04)"));
        Mainframe.put("cpfCnpj", new StringValue("X(18)"));
        Mainframe.put("nomeUnidadePV", new StringValue("X(40)"));
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
