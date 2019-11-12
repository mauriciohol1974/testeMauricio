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
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class TrilhaAuditoriaBean extends SigcbBean {
	
    
    private java.lang.Long codigoCedente;
    private java.util.Date dataAuditoria;
    private String horaAuditoria;
    private String ipEquipamento;
    private String tpServico;
    private String origem;
    private String cpfCnpj;
    private String transacao;
    private String nsu;
    private String cpfCnpjCed;
    
    
    
    
    
    
    

    public TrilhaAuditoriaBean() {
        
        this.codigoCedente = null;
        this.dataAuditoria=null;
        this.horaAuditoria=null;
        this.ipEquipamento=null;
        this.tpServico=null;
        this.origem=null;
        this.cpfCnpj=null;
        this.transacao=null;
        this.nsu=null;
        this.cpfCnpjCed=null;
        
    }

   

	

	public String getCpfCnpjCed() {
		return cpfCnpjCed;
	}





	public void setCpfCnpjCed(String cpfCnpjCed) {
		this.cpfCnpjCed = cpfCnpjCed;
	}





	public String getTransacao() {
		return transacao;
	}





	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}





	public String getNsu() {
		return nsu;
	}





	public void setNsu(String nsu) {
		this.nsu = nsu;
	}





	public java.lang.Long getCodigoCedente() {
		return codigoCedente;
	}





	public void setCodigoCedente(java.lang.Long codigoCedente) {
		this.codigoCedente = codigoCedente;
	}





	public java.util.Date getDataAuditoria() {
		return dataAuditoria;
	}





	public void setDataAuditoria(java.util.Date dataAuditoria) {
		this.dataAuditoria = dataAuditoria;
	}





	public String getHoraAuditoria() {
		return horaAuditoria;
	}





	public void setHoraAuditoria(String horaAuditoria) {
		this.horaAuditoria = horaAuditoria;
	}





	public String getIpEquipamento() {
		return ipEquipamento;
	}





	public void setIpEquipamento(String ipEquipamento) {
		this.ipEquipamento = ipEquipamento;
	}





	public String getTpServico() {
		return tpServico;
	}





	public void setTpServico(String tpServico) {
		this.tpServico = tpServico;
	}





	public String getOrigem() {
		return origem;
	}





	public void setOrigem(String origem) {
		this.origem = origem;
	}





	public String getCpfCnpj() {
		return cpfCnpj;
	}





	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}


    public java.lang.String getDataAuditorialFormatada() {
        if (this.dataAuditoria != null)
            return Formatador.formatarData(this.dataAuditoria);
        return "";
    }



	// ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

   
    
   

    // fim-------------getCodigoUnidadeFormatado---------------------

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            TrilhaAuditoriaBean other = (TrilhaAuditoriaBean) obj;
            result = result && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getDataAuditoria(), other.getDataAuditoria());
            result = result && equals(getHoraAuditoria(), other.getHoraAuditoria());
            result = result && equals(getIpEquipamento(), other.getIpEquipamento());
            result = result && equals(getTpServico(), other.getTpServico());
            result = result && equals(getOrigem(), other.getOrigem());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result && equals(getTransacao(), other.getTransacao());
            result = result && equals(getNsu(), other.getNsu());
            result = result && equals(getCpfCnpjCed(), other.getCpfCnpjCed());
            
            
           
            
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
        
        properties.add(new Property("codigoCedente", LongType.create(), false, true));
        properties.add(new Property("dataAuditoria", DateType.create(), false, true));
        properties.add(new Property("horaAuditoria", StringType.create(),false,  true));
        properties.add(new Property("ipEquipamento", StringType.create(),false,  true));
        properties.add(new Property("tpServico", StringType.create(),false,  true));
        properties.add(new Property("origem", StringType.create(),false,  true));
        properties.add(new Property("cpfCnpj", StringType.create(),false,  true));
        properties.add(new Property("transacao", StringType.create(),false,  true));
        properties.add(new Property("nsu", StringType.create(),false,  true));
        properties.add(new Property("cpfCnpjCed", StringType.create(),false,  true));

        
        Layout result = new Layout(properties,"TrilhaAuditoriaBean", "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("dataAuditoria", new DateValue("dd/MM/yyyy"));
        Mainframe.put("horaAuditoria",new StringValue("X(8)"));
        Mainframe.put("ipEquipamento",new StringValue("X(15)"));
        Mainframe.put("tpServico",new StringValue("X(10)"));
        Mainframe.put("origem",new StringValue("X(20)"));
        Mainframe.put("cpfCnpj",new StringValue("X(15)"));
        Mainframe.put("transacao",new StringValue("X(9)"));
        Mainframe.put("nsu",new StringValue("X(09)"));
        Mainframe.put("cpfCnpjCed",new StringValue("X(18)"));
       
        
        
        
        
       
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }



	@Override
	public String getApplicationName() {
		// TODO Auto-generated method stub
		return null;
	}
}
