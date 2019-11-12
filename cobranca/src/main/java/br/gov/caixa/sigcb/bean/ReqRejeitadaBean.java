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

public class ReqRejeitadaBean extends SigcbBean {

	
	
    private java.util.Date dtInicio;            
    private java.util.Date dtFim;           
    private Long sr;          
    private Long pv;             
    private String nuCtrlReq;               
    private String coEnvioReq;             
    private String tsEnvioReq;           
    private String coRetReq;           
    private String tsRetReq; 
    private Long nuConvenio;
    private Long nossoNumero;
    private String sgOrigem;
    private String tsProcBaixa;
    private String coPrograma;
    private String coTransacao;
    private String icErro;
    
    private String nuSqErro;
    private String tagErro;
    private String coErro;
    private String descErro;
    
   
    public ReqRejeitadaBean() {

    	this.dtInicio=null;
		this.dtFim=null;
		this.sr=null;
		this.pv=null;
		this.nuCtrlReq=null;
		this.coEnvioReq=null;
		this.tsEnvioReq=null;
		this.coRetReq=null;
		this.tsRetReq=null;
		this.nuConvenio=null;
		this.nossoNumero=null;
		this.sgOrigem=null;
		this.tsProcBaixa=null;
		this.coPrograma=null;
		this.coTransacao=null;
		this.icErro=null;
		this.nuSqErro=null;
		this.tagErro=null;
		this.coErro=null;
		this.descErro=null;
		
        
    }

   








	public String getNuSqErro() {
		return nuSqErro;
	}










	public void setNuSqErro(String nuSqErro) {
		this.nuSqErro = nuSqErro;
	}










	public String getTagErro() {
		return tagErro;
	}










	public void setTagErro(String tagErro) {
		this.tagErro = tagErro;
	}










	public String getCoErro() {
		return coErro;
	}










	public void setCoErro(String coErro) {
		this.coErro = coErro;
	}










	public String getDescErro() {
		return descErro;
	}










	public void setDescErro(String descErro) {
		this.descErro = descErro;
	}










	public Long getNuConvenio() {
		return nuConvenio;
	}










	public void setNuConvenio(Long nuConvenio) {
		this.nuConvenio = nuConvenio;
	}










	public Long getNossoNumero() {
		return nossoNumero;
	}










	public void setNossoNumero(Long nossoNumero) {
		this.nossoNumero = nossoNumero;
	}










	public String getSgOrigem() {
		return sgOrigem;
	}










	public void setSgOrigem(String sgOrigem) {
		this.sgOrigem = sgOrigem;
	}










	public String getTsProcBaixa() {
		return tsProcBaixa;
	}










	public void setTsProcBaixa(String tsProcBaixa) {
		this.tsProcBaixa = tsProcBaixa;
	}










	public String getCoPrograma() {
		return coPrograma;
	}










	public void setCoPrograma(String coPrograma) {
		this.coPrograma = coPrograma;
	}










	public String getCoTransacao() {
		return coTransacao;
	}










	public void setCoTransacao(String coTransacao) {
		this.coTransacao = coTransacao;
	}










	public String getIcErro() {
		return icErro;
	}










	public void setIcErro(String icErro) {
		this.icErro = icErro;
	}










	public Date getDtInicio() {
		return dtInicio;
	}










	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}










	public Date getDtFim() {
		return dtFim;
	}










	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}










	public Long getSr() {
		return sr;
	}










	public void setSr(Long sr) {
		this.sr = sr;
	}










	public Long getPv() {
		return pv;
	}










	public void setPv(Long pv) {
		this.pv = pv;
	}


















	public String getNuCtrlReq() {
		return nuCtrlReq;
	}










	public void setNuCtrlReq(String nuCtrlReq) {
		this.nuCtrlReq = nuCtrlReq;
	}










	public String getCoEnvioReq() {
		return coEnvioReq;
	}










	public void setCoEnvioReq(String coEnvioReq) {
		this.coEnvioReq = coEnvioReq;
	}










	public String getTsEnvioReq() {
		return tsEnvioReq;
	}










	public void setTsEnvioReq(String tsEnvioReq) {
		this.tsEnvioReq = tsEnvioReq;
	}










	public String getCoRetReq() {
		return coRetReq;
	}










	public void setCoRetReq(String coRetReq) {
		this.coRetReq = coRetReq;
	}










	public String getTsRetReq() {
		return tsRetReq;
	}










	public void setTsRetReq(String tsRetReq) {
		this.tsRetReq = tsRetReq;
	}










	// fim-------------getCodigoUnidadeFormatado---------------------
    // Término das customizações
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ReqRejeitadaBean other = (ReqRejeitadaBean) obj;
            
            result = result && equals(getDtInicio(), other.getDtInicio());
            result = result && equals(getDtFim(), other.getDtFim());
            result = result && equals(getSr(), other.getSr());
            result = result && equals(getPv(), other.getPv());
            result = result && equals(getNuCtrlReq(), other.getNuCtrlReq());
            result = result && equals(getCoEnvioReq(), other.getCoEnvioReq());
            result = result && equals(getTsEnvioReq(), other.getTsEnvioReq());
            result = result && equals(getCoRetReq(), other.getCoRetReq());
            result = result && equals(getTsRetReq(), other.getTsRetReq());
            result = result && equals(getNuConvenio(), other.getNuConvenio());
            result = result && equals(getNossoNumero(), other.getNossoNumero());
            result = result && equals(getSgOrigem(), other.getSgOrigem());
            result = result && equals(getTsProcBaixa(), other.getTsProcBaixa());
            result = result && equals(getCoPrograma(), other.getCoPrograma());
            result = result && equals(getCoTransacao(), other.getCoTransacao());
            result = result && equals(getIcErro(), other.getIcErro());
            
            result = result && equals(getNuSqErro(), other.getNuSqErro());
            result = result && equals(getTagErro(), other.getTagErro());
            result = result && equals(getCoErro(), other.getCoErro());
            result = result && equals(getDescErro(), other.getDescErro());
          
            
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
 
           
        properties.add(new Property("dtInicio", DateType.create(),  false,    true));
        properties.add(new Property("dtFim", DateType.create(),  false,    true));
        properties.add(new Property("sr", LongType.create(),  false,    true));
        properties.add(new Property("pv", LongType.create(),  false,    true));
        properties.add(new Property("nuCtrlReq",StringType.create(), false,     true));
        properties.add(new Property("coEnvioReq",StringType.create(), false,     true));
        properties.add(new Property("tsEnvioReq",StringType.create(), false,     true));
        properties.add(new Property("coRetReq",StringType.create(), false,     true));
        properties.add(new Property("tsRetReq",StringType.create(), false,     true));
        
        properties.add(new Property("nuConvenio", LongType.create(),  false,    true));
        properties.add(new Property("nossoNumero", LongType.create(),  false,    true));
        properties.add(new Property("sgOrigem",StringType.create(), false,     true));
        properties.add(new Property("tsProcBaixa",StringType.create(), false,     true));
        properties.add(new Property("coPrograma",StringType.create(), false,     true));
        properties.add(new Property("coTransacao",StringType.create(), false,     true));
        properties.add(new Property("icErro",StringType.create(), false,     true));
        
        
        properties.add(new Property("nuSqErro",StringType.create(), false,     true));
        properties.add(new Property("tagErro",StringType.create(), false,     true));
        properties.add(new Property("coErro",StringType.create(), false,     true));
        properties.add(new Property("descErro",StringType.create(), false,     true));
        
        



        
        
        
        Layout result = new Layout(properties,
                "ReqRejeitadaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        
        Mainframe.put("dtInicio", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dtFim", new DateValue("dd.MM.yyyy"));
        Mainframe.put("sr", new LongValue("9(04)"));
        Mainframe.put("pv", new LongValue("9(04)"));
        Mainframe.put("nuCtrlReq", new StringValue("X(20)"));
        Mainframe.put("coEnvioReq", new StringValue("X(10)"));
        Mainframe.put("tsEnvioReq", new StringValue("X(26)"));
        Mainframe.put("coRetReq", new StringValue("X(10)"));
        Mainframe.put("tsRetReq", new StringValue("X(26)"));
        Mainframe.put("nuConvenio", new LongValue("9(15)"));
        Mainframe.put("nossoNumero", new LongValue("9(18)"));
        Mainframe.put("sgOrigem", new StringValue("X(05)"));
        Mainframe.put("tsProcBaixa", new StringValue("X(26)"));
        Mainframe.put("coPrograma", new StringValue("X(8)"));
        Mainframe.put("coTransacao", new StringValue("X(4)"));
        Mainframe.put("icErro", new StringValue("X(1)"));
        Mainframe.put("nuSqErro", new StringValue("X(4)"));
        Mainframe.put("tagErro", new StringValue("X(150)"));
        Mainframe.put("coErro", new StringValue("X(8)"));
        Mainframe.put("descErro", new StringValue("X(150)"));
       
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
