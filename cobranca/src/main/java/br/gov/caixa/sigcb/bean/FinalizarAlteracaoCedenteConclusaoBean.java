package br.gov.caixa.sigcb.bean;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;

/**
 * Este Bean é responsável pela última transacao a ser chamada durante o
 * processo de conclusao das alteracoes de um Cedente as transacoes e a BGH8.
 * 
 * @author p561913 - David L. M. Torneiros
 * @created 13/02/2007
 */
public class FinalizarAlteracaoCedenteConclusaoBean extends SigcbBean {

    private java.lang.String nsuTransacao;

    private java.lang.String codigoUsuario;

    private java.lang.Long cpfCnpj;

    private java.lang.String nomeCedente;

    private java.lang.Long idEndereco;

    private java.lang.Long numeroPendencia;

    private java.lang.String apelido;

    private java.lang.String descricaoCriticas;
    
    private String ip;

    public FinalizarAlteracaoCedenteConclusaoBean() {
        this.nsuTransacao = null;
        this.codigoUsuario = null;
        this.cpfCnpj = null;
        this.nomeCedente = null;
        this.idEndereco = null;
        this.numeroPendencia = null;
        this.apelido = null;
        this.descricaoCriticas = null;
        this.ip = null;
    }

    public java.lang.Long getNumeroPendencia() {
        return this.numeroPendencia;
    }

    public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setNumeroPendencia(java.lang.Long numeroPendencia) {
        this.numeroPendencia = numeroPendencia;
    }

    public java.lang.String getApelido() {
        return this.apelido;
    }

    public void setApelido(java.lang.String apelido) {
        this.apelido = apelido;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.lang.Long getIdEndereco() {
        return this.idEndereco;
    }

    public void setIdEndereco(java.lang.Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public java.lang.String getNomeCedente() {
        return this.nomeCedente;
    }

    public void setNomeCedente(java.lang.String nomeCedente) {
        this.nomeCedente = nomeCedente;
    }

    public java.lang.String getNsuTransacao() {
        return this.nsuTransacao;
    }

    public void setNsuTransacao(java.lang.String nsuTransacao) {
        this.nsuTransacao = nsuTransacao;
    }

    public java.lang.String getDescricaoCriticas() {
        return this.descricaoCriticas;
    }

    public void setDescricaoCriticas(java.lang.String descricaoCriticas) {
        this.descricaoCriticas = descricaoCriticas;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            FinalizarAlteracaoCedenteConclusaoBean other = (FinalizarAlteracaoCedenteConclusaoBean) obj;
            result = result
                     && equals(this.getNsuTransacao(), other.getNsuTransacao());
            result = result
                     && equals(this.getCodigoUsuario(),
                             other.getCodigoUsuario());
            result = result && equals(this.getCpfCnpj(), other.getCpfCnpj());
            result = result
                     && equals(this.getNomeCedente(), other.getNomeCedente());
            result = result
                     && equals(this.getIdEndereco(), other.getIdEndereco());
            result = result
                     && equals(this.getNumeroPendencia(),
                             other.getNumeroPendencia());
            result = result && equals(this.getApelido(), other.getApelido());
            result = result && equals(this.getIp(), other.getIp());
            result = result
                     && equals(this.getDescricaoCriticas(),
                             other.getDescricaoCriticas());
            return result;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = 0;
        return result;
    }

    @Override
    public String getApplicationName() {
        return "FinalizarAlteracaoCedenteConclusaoBean";
    }

    private static final Layout layout = initLayout();

    private static Layout initLayout() {
        java.util.TreeSet properties = new java.util.TreeSet();
        properties.add(new Property("nsuTransacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("nomeCedente",
                StringType.create(),
                false,
                true));
        properties.add(new Property("idEndereco",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroPendencia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("apelido", StringType.create(), false, true));
        properties.add(new Property("ip", StringType.create(), false, true));
        properties.add(new Property("descricaoCriticas",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "FinalizarAlteracaoCedenteConclusaoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("nsuTransacao", new StringValue("X(48)"));
        Mainframe.put("codigoUsuario", new StringValue("X(07)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("nomeCedente", new StringValue("X(40)"));
        Mainframe.put("idEndereco", new LongValue("9(04)"));
        Mainframe.put("numeroPendencia", new LongValue("9(07)"));
        Mainframe.put("apelido", new StringValue("X(06)"));
        Mainframe.put("ip", new StringValue("X(15)"));
        Mainframe.put("descricaoCriticas", new StringValue("X(200)"));
        result.addExtension(Mainframe);
        return result;
    }

    @Override
    public Layout getLayout() {
        return layout;
    }
}