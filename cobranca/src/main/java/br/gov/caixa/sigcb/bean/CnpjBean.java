package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CnpjBean extends SigcbBean {
   
    
	private Long nuSimulacao;
	
	private String icPessoa;

    private Long cpfCnpj;
    
    private String nome;
    
    private Long codCedente;
    
    private String icOcorrencia;
    
    private String deOcorrencia;

    
    public CnpjBean() {
       
    	this.nuSimulacao=null;
    	this.icPessoa=null;
    	this.cpfCnpj=null;
    	this.nome=null;
    	this.codCedente=null;
    	this.icOcorrencia=null;
    	this.deOcorrencia=null;
      
    }

    public String getApplicationName() {
        return "CnpjBean";
    }

  
	public Long getNuSimulacao() {
		return nuSimulacao;
	}

	public void setNuSimulacao(Long nuSimulacao) {
		this.nuSimulacao = nuSimulacao;
	}

	public String getIcPessoa() {
		return icPessoa;
	}

	public void setIcPessoa(String icPessoa) {
		this.icPessoa = icPessoa;
	}



	public Long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(Long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCodCedente() {
		return codCedente;
	}

	public void setCodCedente(Long codCedente) {
		this.codCedente = codCedente;
	}

	public String getIcOcorrencia() {
		return icOcorrencia;
	}

	public void setIcOcorrencia(String icOcorrencia) {
		this.icOcorrencia = icOcorrencia;
	}

	public String getDeOcorrencia() {
		return deOcorrencia;
	}

	public void setDeOcorrencia(String deOcorrencia) {
		this.deOcorrencia = deOcorrencia;
	}

	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CnpjBean other = (CnpjBean) obj;
          
            result = result && equals(getNuSimulacao(), other.getNuSimulacao());
            result = result && equals(getIcPessoa(), other.getIcPessoa());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getNome(), other.getNome());
            result = result && equals(getIcOcorrencia(), other.getIcOcorrencia());
            result = result && equals(getDeOcorrencia(), other.getDeOcorrencia());
            result = result && equals(getCodCedente(), other.getCodCedente());
          
        
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
        properties.add(new Property("icPessoa", StringType.create(), false, true));
        properties.add(new Property("nuSimulacao", LongType.create(), false, true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("nome", StringType.create(), false, true));
        properties.add(new Property("icOcorrencia", StringType.create(), false, true));
        properties.add(new Property("deOcorrencia", StringType.create(), false, true));
        properties.add(new Property("codCedente", LongType.create(), false, true));
     
        Layout result = new Layout(properties, "CnpjBean", "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
       
        Mainframe.put("nome", new StringValue("X(40)"));
        Mainframe.put("icOcorrencia", new StringValue("X(01)"));
        Mainframe.put("deOcorrencia", new StringValue("X(40)"));
        Mainframe.put("icPessoa", new StringValue("X(01)"));
        Mainframe.put("nuSimulacao", new LongValue("9(20)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("codCedente", new LongValue("9(07)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
