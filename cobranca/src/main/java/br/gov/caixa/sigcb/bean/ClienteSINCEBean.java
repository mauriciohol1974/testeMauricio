package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;



public class ClienteSINCEBean  extends SigcbBean {

    private java.lang.Long tpconsulta;

    private java.lang.Long codcedente;

    private java.lang.Long codsince;

    private java.lang.Long codPV;

    private java.lang.Long codSR;

    private java.lang.String tpPessoa;

    private java.lang.String cpfCnpj;
    
    private java.lang.String nome;
    
    private java.lang.Long totalRegistros;
    
    private java.lang.Long paginaPesq;
	
    public ClienteSINCEBean() {
       this.codcedente=null;
       this.codPV=null;
       this.codsince=null;
       this.codSR=null;
       this.cpfCnpj=null;
       this.nome=null;
       this.tpconsulta=null;
       this.tpPessoa=null;
       this.totalRegistros=null;
       this.paginaPesq=null;
    	
    }

    public String getApplicationName() {
        return "ClienteSINCEBean";
    }
	
    
    
    public java.lang.Long getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(java.lang.Long totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	public java.lang.Long getPaginaPesq() {
		return paginaPesq;
	}

	public void setPaginaPesq(java.lang.Long paginaPesq) {
		this.paginaPesq = paginaPesq;
	}

	public java.lang.Long getTpconsulta() {
		return tpconsulta;
	}

	public void setTpconsulta(java.lang.Long tpconsulta) {
		this.tpconsulta = tpconsulta;
	}

	public java.lang.Long getCodcedente() {
		return codcedente;
	}

	public void setCodcedente(java.lang.Long codcedente) {
		this.codcedente = codcedente;
	}

	public java.lang.Long getCodsince() {
		return codsince;
	}

	public void setCodsince(java.lang.Long codsince) {
		this.codsince = codsince;
	}

	public java.lang.Long getCodPV() {
		return codPV;
	}

	public void setCodPV(java.lang.Long codPV) {
		this.codPV = codPV;
	}

	public java.lang.Long getCodSR() {
		return codSR;
	}

	public void setCodSR(java.lang.Long codSR) {
		this.codSR = codSR;
	}

	public java.lang.String getTpPessoa() {
		return tpPessoa;
	}

	public void setTpPessoa(java.lang.String tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	public java.lang.String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(java.lang.String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public java.lang.String getNome() {
		return nome;
	}

	public void setNome(java.lang.String nome) {
		this.nome = nome;
	}

	
	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ClienteSINCEBean other = (ClienteSINCEBean) obj;
            result = result && equals(getCodcedente(), other.getCodcedente());
            result = result && equals(getCodPV(), other.getCodPV());
            result = result && equals(getCodsince(), other.getCodsince());
            result = result && equals(getCodSR(), other.getCodSR());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getNome(), other.getNome());
            result = result && equals(getTpconsulta(), other.getTpconsulta());
            result = result && equals(getTpPessoa(), other.getTpPessoa());
            result = result && equals(getTotalRegistros(), other.getTotalRegistros());
            result = result && equals(getPaginaPesq(), other.getPaginaPesq());
          
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
        

        properties.add(new Property("tpconsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codcedente",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codPV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codsince",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codSR",
                LongType.create(),
                false,
                true));
        properties.add(new Property("nome",
                StringType.create(),
                false,
                true));
        properties.add(new Property("tpPessoa",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj",
                StringType.create(),
                false,
                true));
        properties.add(new Property("totalRegistros",
                LongType.create(),
                false,
                true));
        properties.add(new Property("paginaPesq",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ClienteSINCEBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("tpconsulta", new LongValue("9(1)"));
        Mainframe.put("codcedente", new LongValue("9(07)"));
        Mainframe.put("codPV", new LongValue("9(04)"));
        Mainframe.put("codsince", new LongValue("9(09)"));
        Mainframe.put("codSR", new LongValue("9(04)"));
        Mainframe.put("nome", new StringValue("X(40)"));
        Mainframe.put("tpPessoa", new StringValue("X(1)"));
        Mainframe.put("cpfCnpj", new StringValue("X(14)"));
        Mainframe.put("totalRegistros", new LongValue("9(09)"));
        Mainframe.put("paginaPesq", new LongValue("9(09)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
	
   
}
