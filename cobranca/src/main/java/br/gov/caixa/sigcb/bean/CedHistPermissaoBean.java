package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.gov.caixa.sigcb.util.Formatador;

public class CedHistPermissaoBean extends SigcbBean {
	
	private java.lang.Long codCedente;
	private String data;
	private String hora;
	private String tpAlteracao;
	private String tipoAlteracao;
	private String usuario;
	private String icAnterior;
	private String sitAnterior;
	private String icAtual;
	private String sitAtual;
	private String descricao;
	
	
    public CedHistPermissaoBean() {
    	this.codCedente=null;
        this.data=null;
        this.hora=null;
        this.tpAlteracao=null;
        this.tipoAlteracao=null;
        this.usuario=null;
        this.icAnterior=null;
        this.sitAnterior=null;
        this.icAtual=null;
        this.sitAtual=null;
        this.descricao=null;
        
    }

    
    public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getTipoAlteracao() {
		return tipoAlteracao;
	}


	public void setTipoAlteracao(String tipoAlteracao) {
		this.tipoAlteracao = tipoAlteracao;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSitAnterior() {
		return sitAnterior;
	}


	public void setSitAnterior(String sitAnterior) {
		this.sitAnterior = sitAnterior;
	}


	public String getSitAtual() {
		return sitAtual;
	}


	public void setSitAtual(String sitAtual) {
		this.sitAtual = sitAtual;
	}





	public java.lang.Long getCodCedente() {
		return codCedente;
	}


	public void setCodCedente(java.lang.Long codCedente) {
		this.codCedente = codCedente;
	}


	public String getTpAlteracao() {
		return tpAlteracao;
	}


	public void setTpAlteracao(String tpAlteracao) {
		this.tpAlteracao = tpAlteracao;
	}


	public String getIcAnterior() {
		return icAnterior;
	}


	public void setIcAnterior(String icAnterior) {
		this.icAnterior = icAnterior;
	}


	public String getIcAtual() {
		return icAtual;
	}


	public void setIcAtual(String icAtual) {
		this.icAtual = icAtual;
	}
	
	


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            CedHistPermissaoBean other = (CedHistPermissaoBean) obj;
            result = result && equals(getData(), other.getData());
            result = result && equals(getHora(), other.getHora());
            result = result && equals(getTpAlteracao(), other.getTpAlteracao());
            result = result && equals(getTipoAlteracao(), other.getTipoAlteracao());
            result = result && equals(getUsuario(), other.getUsuario());
            result = result && equals(getIcAnterior(), other.getIcAnterior());
            result = result && equals(getSitAnterior(), other.getSitAnterior());
            result = result && equals(getIcAtual(), other.getIcAtual());
            result = result && equals(getSitAtual(), other.getSitAtual());
            result = result && equals(getCodCedente(), other.getCodCedente());
            result = result && equals(getDescricao(), other.getDescricao());
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
        properties.add(new Property("data", StringType.create(), false, true));
        properties.add(new Property("hora", StringType.create(), false, true));
        properties.add(new Property("tpAlteracao", StringType.create(), false, true));
        properties.add(new Property("tipoAlteracao", StringType.create(), false, true));
        properties.add(new Property("usuario", StringType.create(), false, true));
        properties.add(new Property("icAnterior", StringType.create(), false, true));
        properties.add(new Property("sitAnterior", StringType.create(), false, true));
        properties.add(new Property("icAtual", StringType.create(), false, true));
        properties.add(new Property("sitAtual", StringType.create(), false, true));
        properties.add(new Property("codCedente", LongType.create(), false, true));
        properties.add(new Property("descricao", StringType.create(), false, true));
        Layout result = new Layout(properties,
                "CedHistPermissaoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codCedente", new LongValue("9(07)"));
        Mainframe.put("data", new StringValue("X(10)"));
        Mainframe.put("hora", new StringValue("X(08)"));
        Mainframe.put("tpAlteracao", new StringValue("X(01)"));
        Mainframe.put("tipoAlteracao", new StringValue("X(20)"));
        Mainframe.put("usuario", new StringValue("X(08)"));
        Mainframe.put("icAnterior", new StringValue("X(01)"));
        Mainframe.put("sitAnterior", new StringValue("X(10)"));
        Mainframe.put("icAtual", new StringValue("X(01)"));
        Mainframe.put("sitAtual", new StringValue("X(10)"));
        Mainframe.put("descricao", new StringValue("X(999)"));
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
