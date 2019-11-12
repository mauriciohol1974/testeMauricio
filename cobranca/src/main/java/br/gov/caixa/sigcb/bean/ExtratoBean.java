//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
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
import br.gov.caixa.sigcb.util.Formatador;

public class ExtratoBean extends SigcbBean {


    private java.lang.Long codigoCedente;
    private java.lang.Long pagina;
    private java.lang.String dataMovimento;
    private java.lang.String registro;
    private Long paginaFinal;
    
    public ExtratoBean() {
        this.codigoCedente = null;
        this.pagina = null;
        this.dataMovimento=null;
        this.registro=null;
        this.paginaFinal=null;
    }

    public String getApplicationName() {
        return "ExtratoBean";
    }



    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }



    public java.lang.Long getPagina() {
		return pagina;
	}

	public void setPagina(java.lang.Long pagina) {
		this.pagina = pagina;
	}

	public java.lang.String getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(java.lang.String dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public java.lang.String getRegistro() {
		return registro;
	}

	public void setRegistro(java.lang.String registro) {
		this.registro = registro;
	}
	
	



	public Long getPaginaFinal() {
		return paginaFinal;
	}

	public void setPaginaFinal(Long paginaFinal) {
		this.paginaFinal = paginaFinal;
	}

	// fim-------------getCodigoCedenteFormatado---------------------
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ExtratoBean other = (ExtratoBean) obj;
            result = result && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result && equals(getDataMovimento(), other.getDataMovimento());
            result = result && equals(getPagina(), other.getPagina());
            result = result && equals(getRegistro(), other.getRegistro());
            result = result && equals(getPaginaFinal(), other.getPaginaFinal());
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
        properties.add(new Property("dataMovimento",
                StringType.create(),
                false,
                true));
        properties.add(new Property("pagina",
                LongType.create(),
                false,
                true));
        properties.add(new Property("paginaFinal",
                LongType.create(),
                false,
                true));
        
        properties.add(new Property("registro",
                StringType.create(),
                false,
                true));
        

        Layout result = new Layout(properties,
                "ExtratoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
       
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("pagina", new LongValue("9(07)"));
        Mainframe.put("paginaFinal", new LongValue("9(07)"));
        Mainframe.put("dataMovimento", new StringValue("X(10)"));
        Mainframe.put("registro", new StringValue("X(990)"));
       
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
