package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CanalSimulacaoBean extends SigcbBean {
   
    private Long coCanal;

    private Long prazoNeg;
    
    private Long prazoPad;
    
    private Long prazoAtu;
    
    private String deCanal;
    
    private Long nuSimulacao;
    
    private Long  	nu_simulacao;
    private Long 	coCedente;
    private String 	icPessoa;
    private Long  	cnpj;
    private Long 	cocli;
    private String 	passo;
    private Long  	unidadeAutorizador;
    private Long 	nuServico;

   
 
    public CanalSimulacaoBean() {
       this.coCanal=null;
       this.prazoNeg=null;
       this.nuSimulacao=null;
       this.prazoAtu=null;
       this.prazoPad=null;
       this.nu_simulacao=null;
       this.coCedente=null;
       this.icPessoa=null;
       this.cnpj=null;
       this.cocli=null;
       this.passo=null;
       this.unidadeAutorizador=null;
      
    }

    public String getApplicationName() {
        return "CanalSimulacaoBean";
    }

  


	public Long getCoCanal() {
		return coCanal;
	}

	public void setCoCanal(Long coCanal) {
		this.coCanal = coCanal;
	}

	public Long getPrazoNeg() {
		return prazoNeg;
	}

	public void setPrazoNeg(Long prazoNeg) {
		this.prazoNeg = prazoNeg;
	}

	public Long getPrazoPad() {
		return prazoPad;
	}

	public void setPrazoPad(Long prazoPad) {
		this.prazoPad = prazoPad;
	}

	public Long getPrazoAtu() {
		return prazoAtu;
	}

	public void setPrazoAtu(Long prazoAtu) {
		this.prazoAtu = prazoAtu;
	}

	public String getDeCanal() {
		return deCanal;
	}

	public void setDeCanal(String deCanal) {
		this.deCanal = deCanal;
	}

	public Long getNuSimulacao() {
		return nuSimulacao;
	}

	public void setNuSimulacao(Long nuSimulacao) {
		this.nuSimulacao = nuSimulacao;
	}

	public Long getNu_simulacao() {
		return nu_simulacao;
	}

	public void setNu_simulacao(Long nu_simulacao) {
		this.nu_simulacao = nu_simulacao;
	}

	public Long getCoCedente() {
		return coCedente;
	}

	public void setCoCedente(Long coCedente) {
		this.coCedente = coCedente;
	}

	public String getIcPessoa() {
		return icPessoa;
	}

	public void setIcPessoa(String icPessoa) {
		this.icPessoa = icPessoa;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Long getCocli() {
		return cocli;
	}

	public void setCocli(Long cocli) {
		this.cocli = cocli;
	}

	public String getPasso() {
		return passo;
	}

	public void setPasso(String passo) {
		this.passo = passo;
	}

	public Long getUnidadeAutorizador() {
		return unidadeAutorizador;
	}

	public void setUnidadeAutorizador(Long unidadeAutorizador) {
		this.unidadeAutorizador = unidadeAutorizador;
	}

	public Long getNuServico() {
		return nuServico;
	}

	public void setNuServico(Long nuServico) {
		this.nuServico = nuServico;
	}

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CanalSimulacaoBean other = (CanalSimulacaoBean) obj;
            result = result && equals(getCoCanal(), other.getCoCanal());
            result = result && equals(getNuSimulacao(), other.getNuSimulacao());
            result = result && equals(getPrazoAtu(), other.getPrazoAtu());
            result = result && equals(getPrazoPad(), other.getPrazoPad());
            result = result && equals(getPrazoNeg(), other.getPrazoNeg());
            result = result && equals(getDeCanal(), other.getDeCanal());
            result = result && equals(getNu_simulacao(), other.getNu_simulacao());
            result = result && equals(getCoCedente(), other.getCoCedente());
            result = result && equals(getIcPessoa(), other.getIcPessoa());
            result = result && equals(getCnpj(), other.getCnpj());
            result = result && equals(getCocli(), other.getCocli());
            result = result && equals(getPasso(), other.getPasso());
            result = result && equals(getUnidadeAutorizador(), other.getUnidadeAutorizador());
        
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
        properties.add(new Property("deCanal", StringType.create(), false, true));
        properties.add(new Property("nuSimulacao", LongType.create(), false, true));
        properties.add(new Property("coCanal", LongType.create(), false, true));
        properties.add(new Property("prazoAtu", LongType.create(), false, true));
        properties.add(new Property("prazoPad", LongType.create(), false, true));
        properties.add(new Property("prazoNeg", LongType.create(), false, true));

        Layout result = new Layout(properties, "TarifaSimulaBean", "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("deCanal", new StringValue("X(40)"));
        Mainframe.put("nuSimulacao", new LongValue("9(20)"));
        Mainframe.put("prazoAtu", new LongValue("9(04)"));
        Mainframe.put("prazoPad", new LongValue("9(04)"));
        Mainframe.put("prazoNeg", new LongValue("9(04)"));
        Mainframe.put("coCanal", new LongValue("9(04)"));
        
        Mainframe.put("passo", new StringValue("X(1)"));
        Mainframe.put("nu_simulacao", new LongValue("9(20)"));
        Mainframe.put("icPessoa", new StringValue("X(1)"));
        Mainframe.put("cnpj", new LongValue("9(14)"));
        Mainframe.put("coCedente", new LongValue("9(07)"));
        Mainframe.put("cocli", new LongValue("9(13)"));
        Mainframe.put("unidadeAutorizador", new LongValue("9(04)"));
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
