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

public class ServicoBaixaBean extends SigcbBean {

    /*
     *    03 S625-PASSO                  PIC 9(002). 01 - Envia dados do pagamento; 02 - Confirma pagamento.
          03 S625-CODBENFCRIO            PIC 9(006). 
          03 S625-NOSSONUM               PIC 9(018). 
          03 S625-NUMIDTIT               PIC 9(019). Não informar no Passo 01;
          03 S625-TPBXOP                 PIC X(001). Não informar no Passo 01;
          03 S625-TPPESPORT              PIC X(001). Opcional no Passo 01;
          03 S625-CNPJ-CPFPORT           PIC 9(014). Opcional no Passo 01;
          03 S625-DTHRPROCBXOP           PIC X(026). Não informar no Passo 01;
          03 S625-DTPROCBXOP             PIC X(010). Não informar no Passo 01;
          03 S625-VLRBXOPTIT             PIC 9(019).
          03 S625-NUMCODBARRASBXOP       PIC X(044). Não informar no Passo 01;
          03 S625-CANPGTOBXOP            PIC 9(001).
          03 S625-MEIOPGTOBXOP           PIC 9(001).
          03 S625-IDOPCONTG              PIC X(001).
          03 S625-DTMOVTO                PIC X(010). Não informar no Passo 01;
          03 S625-NUMRFATBXOP            PIC 9(019). Não informar no Passo 01;

     */
	
	
    private Long passo;            
    private Long codbenfcrio;           
    private Long nossonum;          
    private Long numidtit;             
    private String tpbxop;               
    private String tppesport;             
    private Long cnpjcpfport;           
    private String dthrprocbxop;           
    private String dtprocbxop;          
    private Money vlrbxoptit;          
    private String numcodbarrasbxop  ;    
    private Long canpgtobxop ;          
    private Long meiopgtobxop;          
    private String idopcontg;              
    private String dtmovto ;               
    private Long numReferencia; 
	
   

    public ServicoBaixaBean() {

        this.passo=null;            
        this.codbenfcrio=null;           
        this.nossonum=null;          
        this.numidtit=null;             
        this.tpbxop=null;               
        this.tppesport=null;             
        this.cnpjcpfport=null;           
        this.dthrprocbxop=null;           
        this.dtprocbxop=null;          
        this.vlrbxoptit=null;          
        this.numcodbarrasbxop  =null;    
        this.canpgtobxop =null;          
        this.meiopgtobxop=null;          
        this.idopcontg=null;              
        this.dtmovto =null;               
        this.numReferencia=null; 
        
    }

   

	public String getApplicationName() {
        return "ServicoBaixaBean";
    }

	
  

    public Long getNumReferencia() {
		return numReferencia;
	}



	public void setNumReferencia(Long numReferencia) {
		this.numReferencia = numReferencia;
	}



	public Long getPasso() {
		return passo;
	}



	public void setPasso(Long passo) {
		this.passo = passo;
	}



	public Long getCodbenfcrio() {
		return codbenfcrio;
	}



	public void setCodbenfcrio(Long codbenfcrio) {
		this.codbenfcrio = codbenfcrio;
	}



	public Long getNossonum() {
		return nossonum;
	}



	public void setNossonum(Long nossonum) {
		this.nossonum = nossonum;
	}



	public Long getNumidtit() {
		return numidtit;
	}



	public void setNumidtit(Long numidtit) {
		this.numidtit = numidtit;
	}



	public String getTpbxop() {
		return tpbxop;
	}



	public void setTpbxop(String tpbxop) {
		this.tpbxop = tpbxop;
	}



	public String getTppesport() {
		return tppesport;
	}



	public void setTppesport(String tppesport) {
		this.tppesport = tppesport;
	}



	public Long getCnpjcpfport() {
		return cnpjcpfport;
	}



	public void setCnpjcpfport(Long cnpjcpfport) {
		this.cnpjcpfport = cnpjcpfport;
	}



	public String getDthrprocbxop() {
		return dthrprocbxop;
	}



	public void setDthrprocbxop(String dthrprocbxop) {
		this.dthrprocbxop = dthrprocbxop;
	}



	public String getDtprocbxop() {
		return dtprocbxop;
	}



	public void setDtprocbxop(String dtprocbxop) {
		this.dtprocbxop = dtprocbxop;
	}



	public Money getVlrbxoptit() {
		return vlrbxoptit;
	}



	public void setVlrbxoptit(Money vlrbxoptit) {
		this.vlrbxoptit = vlrbxoptit;
	}



	public String getNumcodbarrasbxop() {
		return numcodbarrasbxop;
	}



	public void setNumcodbarrasbxop(String numcodbarrasbxop) {
		this.numcodbarrasbxop = numcodbarrasbxop;
	}



	public Long getCanpgtobxop() {
		return canpgtobxop;
	}



	public void setCanpgtobxop(Long canpgtobxop) {
		this.canpgtobxop = canpgtobxop;
	}



	public Long getMeiopgtobxop() {
		return meiopgtobxop;
	}



	public void setMeiopgtobxop(Long meiopgtobxop) {
		this.meiopgtobxop = meiopgtobxop;
	}



	public String getIdopcontg() {
		return idopcontg;
	}



	public void setIdopcontg(String idopcontg) {
		this.idopcontg = idopcontg;
	}



	public String getDtmovto() {
		return dtmovto;
	}



	public void setDtmovto(String dtmovto) {
		this.dtmovto = dtmovto;
	}







	// fim-------------getCodigoUnidadeFormatado---------------------
    // Término das customizações
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ServicoBaixaBean other = (ServicoBaixaBean) obj;
            
            result = result && equals(getPasso(), other.getPasso());
            result = result && equals(getCodbenfcrio(), other.getCodbenfcrio());
            result = result && equals(getNossonum(), other.getNossonum());
            result = result && equals(getNumidtit(), other.getNumidtit());
            result = result && equals(getTpbxop(), other.getTpbxop());
            result = result && equals(getTppesport(), other.getTppesport());
            result = result && equals(getCnpjcpfport(), other.getCnpjcpfport());
            result = result && equals(getDthrprocbxop(), other.getDthrprocbxop());
            result = result && equals(getDtprocbxop(), other.getDtprocbxop());
            result = result && equals(getVlrbxoptit(), other.getVlrbxoptit());
            result = result && equals(getNumcodbarrasbxop(), other.getNumcodbarrasbxop());
            result = result && equals(getCanpgtobxop(), other.getCanpgtobxop());
            result = result && equals(getMeiopgtobxop(), other.getMeiopgtobxop());
            result = result && equals(getIdopcontg(), other.getIdopcontg());
            result = result && equals(getDtmovto(), other.getDtmovto());
            result = result && equals(getNumReferencia(), other.getNumReferencia());

            
            
            
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
 
           
        properties.add(new Property("passo", LongType.create(),  false,    true));
        properties.add(new Property("codbenfcrio", LongType.create(),  false,    true));
        properties.add(new Property("nossonum", LongType.create(),  false,    true));
        properties.add(new Property("numidtit", LongType.create(),  false,    true));
        properties.add(new Property("tpbxop",StringType.create(), false,     true));
        properties.add(new Property("tppesport",StringType.create(), false,     true));
        properties.add(new Property("cnpjcpfport", LongType.create(),  false,    true));
        properties.add(new Property("dthrprocbxop",StringType.create(), false,     true));
        properties.add(new Property("dtprocbxop",StringType.create(), false,     true));
        properties.add(new Property("vlrbxoptit",  MoneyType.create(),  false,   true));
        properties.add(new Property("numcodbarrasbxop",StringType.create(), false,     true));
        properties.add(new Property("canpgtobxop", LongType.create(),  false,    true));
        properties.add(new Property("meiopgtobxop", LongType.create(),  false,    true));
        properties.add(new Property("idopcontg",StringType.create(), false,     true));
        properties.add(new Property("dtmovto",StringType.create(), false,     true));
        properties.add(new Property("numReferencia", LongType.create(),  false,    true));
       
        
        Layout result = new Layout(properties,
                "ServicoBaixaBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        
        Mainframe.put("passo", new LongValue("9(2)"));
        Mainframe.put("codbenfcrio", new LongValue("9(7)"));
        Mainframe.put("nossonum", new LongValue("9(18)"));
        Mainframe.put("numidtit", new LongValue("9(19)"));
        Mainframe.put("tpbxop", new StringValue("X(1)"));
        Mainframe.put("tppesport", new StringValue("X(1)"));
        Mainframe.put("cnpjcpfport", new LongValue("9(14)"));
        Mainframe.put("dthrprocbxop", new StringValue("X(26)"));
        Mainframe.put("dtprocbxop", new StringValue("X(10)"));
        Mainframe.put("vlrbxoptit", new MoneyValue("R$ 9(17)v99"));
        Mainframe.put("numcodbarrasbxop", new StringValue("X(44)"));
        Mainframe.put("canpgtobxop", new LongValue("9(1)"));
        Mainframe.put("meiopgtobxop", new LongValue("9(1)"));
        Mainframe.put("idopcontg", new StringValue("X(1)"));
        Mainframe.put("dtmovto", new StringValue("X(10)"));
        Mainframe.put("numReferencia", new LongValue("9(19)"));
       
        
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
