//!!!!!!!!!!!!!!!Bean alterado manualmente, cuidado ao gerar!!!!!!!!!!!!!!!!!!!!
package br.gov.caixa.sigcb.bean;

import java.util.ArrayList;
import java.util.List;

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

public class SimulacaoBean extends SigcbBean {
	
    private Long  	nu_simulacao;
    private String  situacao;
    private String  cnpj;
    private Long    cnpjTela;
    private ArrayList<CnpjBean>  ListaCNPJ = new ArrayList<CnpjBean>();;
    private String  dataValidade;
    private Long  	tipoTransmissao;
    private String  usuarioAutorizador;
    private Long  	unidadeAutorizador;
    private Long 	NSU;
    private String  dataSolicitacao;
    private String  horaSolicitacao;;
    private ArrayList<TarifaSimulaBean> tarifaSimulacao = new ArrayList<TarifaSimulaBean>();
    private ArrayList<CanalSimulacaoBean> canalSimulacao = new ArrayList<CanalSimulacaoBean>();
    private Long codigo;
    private String descricao;
    private br.com.politec.sao.util.Money valor;
    private Long prazo;
    private Long nuSequencial ;
    private Long coCedente;
    private String icPessoa;
    private String nomeUsuario;
    private String nomeUnidade;
    private Long nuSeqRegistro;
    private Long nuTransAtu;
    private Long nuTransNeg;
    private Long cocli;
    private String deOcorrencia;
    private String passo;
    private String deTransmissao;
    private String deTransmissaoNeg;
    private String deServico;
    private String deCanal;
    private String tpAcao;
    private String nsuCedente;
    private Long pvVinc;
    private Long nuPendencia;
    private String codUsuario;
    private String ip;

    public SimulacaoBean() {
    	this.cnpjTela=null;
    	this.nu_simulacao=null;
    	this.situacao=null;
    	this.cnpj=null;
    	this.dataValidade=null;
        this.tipoTransmissao=null;
        this.usuarioAutorizador=null;
        this.unidadeAutorizador=null;
        this.NSU=null;
        this.dataSolicitacao=null;
        this.tarifaSimulacao=null;
        this.canalSimulacao=null;
        this.codigo=null;
        this.valor=null;
        this.descricao=null;
        this.prazo=null;
        this.nuSequencial=null;
        this.ListaCNPJ=null;
        this.coCedente=null;
        this.icPessoa=null;
        this.nomeUsuario=null;
        this.nomeUnidade=null;
        this.nuSeqRegistro=null;
        this.nuTransAtu=null;
        this.nuTransNeg=null;
        this.deOcorrencia=null;
        this.passo=null;
        this.cocli=null;
        this.horaSolicitacao=null;
        this.deTransmissao=null;
        this.deCanal=null;
        this.deServico=null;
        this.deTransmissaoNeg=null;
        this.tpAcao=null;
        this.nsuCedente=null;
        this.pvVinc=null;
        this.nuPendencia=null;
        this.codUsuario=null;
        this.ip=null;
       
    }

  
   
	public String getApplicationName() {
		return "SimulacaoBean";
	}





	


//	public String getHoraSolicitacao() {
//		return horaSolicitacao;
//	}

	
	public String getCodUsuario() {
		return codUsuario;
	}



	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}



	public Long getPvVinc() {
		return pvVinc;
	}



	public void setPvVinc(Long pvVinc) {
		this.pvVinc = pvVinc;
	}



	public String getNsuCedente() {
		return nsuCedente;
	}



	public void setNsuCedente(String nsuCedente) {
		this.nsuCedente = nsuCedente;
	}



	public String getTpAcao() {
		return tpAcao;
	}



	public void setTpAcao(String tpAcao) {
		this.tpAcao = tpAcao;
	}



	public String getDeTransmissaoNeg() {
		return deTransmissaoNeg;
	}



	public void setDeTransmissaoNeg(String deTransmissaoNeg) {
		this.deTransmissaoNeg = deTransmissaoNeg;
	}



	public String getDeServico() {
		return deServico;
	}



	public void setDeServico(String deServico) {
		this.deServico = deServico;
	}



	public String getDeCanal() {
		return deCanal;
	}



	public void setDeCanal(String deCanal) {
		this.deCanal = deCanal;
	}



	public String getHoraSolicitacao() {
		String dataForm = this.dataSolicitacao.substring(11, 19) ;
		return dataForm;
	}


	public String getDeTransmissao() {
		return deTransmissao;
	}



	public void setDeTransmissao(String deTransmissao) {
		this.deTransmissao = deTransmissao;
	}



	public void setHoraSolicitacao(String horaSolicitacao) {
		this.horaSolicitacao = horaSolicitacao;
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



	public String getNomeUsuario() {
		return nomeUsuario;
	}



	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}



	public String getNomeUnidade() {
		return nomeUnidade;
	}



	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}



	public Long getNuSeqRegistro() {
		return nuSeqRegistro;
	}



	public void setNuSeqRegistro(Long nuSeqRegistro) {
		this.nuSeqRegistro = nuSeqRegistro;
	}



	public Long getNuTransAtu() {
		return nuTransAtu;
	}



	public void setNuTransAtu(Long nuTransAtu) {
		this.nuTransAtu = nuTransAtu;
	}



	public Long getNuTransNeg() {
		return nuTransNeg;
	}



	public void setNuTransNeg(Long nuTransNeg) {
		this.nuTransNeg = nuTransNeg;
	}



	public String getDeOcorrencia() {
		return deOcorrencia;
	}



	public void setDeOcorrencia(String deOcorrencia) {
		this.deOcorrencia = deOcorrencia;
	}



	public Long getCnpjTela() {
		return cnpjTela;
	}



	public void setCnpjTela(Long cnpjTela) {
		this.cnpjTela = cnpjTela;
	}



	public ArrayList<CnpjBean> getListaCNPJ() {
		return ListaCNPJ;
	}



	public void setListaCNPJ(ArrayList<CnpjBean> listaCNPJ) {
		ListaCNPJ = listaCNPJ;
	}



	public Long getNu_simulacao() {
		return nu_simulacao;
	}



	public void setNu_simulacao(Long nu_simulacao) {
		this.nu_simulacao = nu_simulacao;
	}



	public String getSituacao() {
		return situacao;
	}



	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}



	public String getCnpj() {
		return cnpj;
	}



	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	public String getDataValidade() {
		String dataForm = this.dataValidade.substring(8, 10) + "/" + this.dataValidade.substring(5, 7) + "/" + this.dataValidade.substring(0, 4) ;
		return dataForm;
	}



	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}



	public Long getTipoTransmissao() {
		return tipoTransmissao;
	}



	public void setTipoTransmissao(Long tipoTransmissao) {
		this.tipoTransmissao = tipoTransmissao;
	}



	public String getUsuarioAutorizador() {
		return usuarioAutorizador;
	}



	public void setUsuarioAutorizador(String usuarioAutorizador) {
		this.usuarioAutorizador = usuarioAutorizador;
	}



	public Long getUnidadeAutorizador() {
		return unidadeAutorizador;
	}



	public void setUnidadeAutorizador(Long unidadeAutorizador) {
		this.unidadeAutorizador = unidadeAutorizador;
	}



	public Long getNSU() {
		return NSU;
	}



	public void setNSU(Long nSU) {
		NSU = nSU;
	}

	
	public String getDataSolicitacao() {
		String dataForm = this.dataSolicitacao.substring(8, 10) + "/" + this.dataSolicitacao.substring(5, 7) + "/" + this.dataSolicitacao.substring(0, 4) ;
		return dataForm;
	}

	public String getDataSolicitacaoInteira() {
		String dataForm = this.dataSolicitacao;
		return dataForm;
	}

	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}



	public ArrayList<TarifaSimulaBean> getTarifaSimulacao() {
		return tarifaSimulacao;
	}



	public void setTarifaSimulacao(ArrayList<TarifaSimulaBean> tarifaSimulacao) {
		this.tarifaSimulacao = tarifaSimulacao;
	}



	public ArrayList<CanalSimulacaoBean> getCanalSimulacao() {
		return canalSimulacao;
	}



	public void setCanalSimulacao(ArrayList<CanalSimulacaoBean> canalSimulacao) {
		this.canalSimulacao = canalSimulacao;
	}



	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public br.com.politec.sao.util.Money getValor() {
		return valor;
	}



	public void setValor(br.com.politec.sao.util.Money valor) {
		this.valor = valor;
	}



	public Long getPrazo() {
		return prazo;
	}



	public void setPrazo(Long prazo) {
		this.prazo = prazo;
	}



	public Long getNuSequencial() {
		return nuSequencial;
	}



	public void setNuSequencial(Long nuSequencial) {
		this.nuSequencial = nuSequencial;
	}



	public Long getNuPendencia() {
		return nuPendencia;
	}



	public void setNuPendencia(Long nuPendencia) {
		this.nuPendencia = nuPendencia;
	}



	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            SimulacaoBean other = (SimulacaoBean) obj;
         
            result = result && equals(getCodigo(), other.getCodigo());
            result = result && equals(getDescricao(), other.getDescricao());
            result = result && equals(getValor(), other.getValor());
            result = result && equals(getPrazo(), other.getPrazo());
           
            
            result = result && equals(getNu_simulacao(), other.getNu_simulacao());
            result = result && equals(getSituacao(), other.getSituacao());
            result = result && equals(getNSU(), other.getNSU());
            result = result && equals(getDataValidade(), other.getDataValidade());
            result = result && equals(getUsuarioAutorizador(), other.getUsuarioAutorizador());
            result = result && equals(getUnidadeAutorizador(), other.getUnidadeAutorizador());
            result = result && equals(getDataSolicitacao(), other.getDataSolicitacao());
            result = result && equals(getTipoTransmissao(), other.getTipoTransmissao());
            result = result && equals(getNuSequencial(), other.getNuSequencial());
            result = result && equals(getPrazo(), other.getPrazo());

            result = result && equals(getCoCedente(), other.getCoCedente());
            result = result && equals(getIcPessoa(), other.getIcPessoa());
            result = result && equals(getNomeUsuario(), other.getNomeUsuario());
            result = result && equals(getNomeUnidade(), other.getNomeUnidade());
            result = result && equals(getNuSeqRegistro(), other.getNuSeqRegistro());
            result = result && equals(getNuTransAtu(), other.getNuTransAtu());
            result = result && equals(getNuTransNeg(), other.getNuTransNeg());
            result = result && equals(getDeOcorrencia(), other.getDeOcorrencia());
            result = result && equals(getPasso(), other.getPasso());
            result = result && equals(getCocli(), other.getCocli());
            result = result && equals(getHoraSolicitacao(), other.getHoraSolicitacao());
            result = result && equals(getDeTransmissao(), other.getDeTransmissao());
            result = result && equals(getDeCanal(),other.getDeCanal());
            result = result && equals(getDeServico(),other.getDeServico());
            result = result && equals(getDeTransmissaoNeg(),other.getDeTransmissaoNeg());
            result = result && equals(getTpAcao(),other.getTpAcao());
            result = result && equals(getNsuCedente(),other.getNsuCedente());
            result = result && equals(getPvVinc(),other.getPvVinc());
            result = result && equals(getNuPendencia(),other.getNuPendencia());
            result = result && equals(getCodUsuario(),other.getCodUsuario());
            result = result && equals(getIp(),other.getIp());
            
            
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
        properties.add(new Property("codigo",
                LongType.create(),
                false,
                true));
       
        properties.add(new Property("descricao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("valor",
        		MoneyType.create(),
                false,
                true));
        properties.add(new Property("prazo",
                LongType.create(),
                false,
                true));
        
        
        properties.add(new Property("nu_simulacao",  LongType.create(),  false,   true));
        properties.add(new Property("NSU",  LongType.create(),  false,   true));
        properties.add(new Property("unidadeAutorizador",  LongType.create(),  false,   true));
        properties.add(new Property("nuSequencial",  LongType.create(),  false,   true));
        properties.add(new Property("tipoTransmissao",  LongType.create(),  false,   true));
        
        properties.add(new Property("situacao", StringType.create(), false,  true));
        properties.add(new Property("dataValidade", StringType.create(), false,  true));
        properties.add(new Property("usuarioAutorizador", StringType.create(), false,  true));
        properties.add(new Property("dataSolicitacao", StringType.create(), false,  true));
        
        properties.add(new Property("coCedente",  LongType.create(),  false,   true));
        properties.add(new Property("cnpjTela",  LongType.create(),  false,   true));
        properties.add(new Property("nuSeqRegistro",  LongType.create(),  false,   true));
        properties.add(new Property("nuTransAtu",  LongType.create(),  false,   true));
        properties.add(new Property("nuTransNeg",  LongType.create(),  false,   true));
        properties.add(new Property("cocli",  LongType.create(),  false,   true));
        properties.add(new Property("pvVinv",  LongType.create(),  false,   true));
        properties.add(new Property("icPessoa", StringType.create(), false,  true));
        properties.add(new Property("nomeUsuario", StringType.create(), false,  true));
        properties.add(new Property("nomeUnidade", StringType.create(), false,  true));
        properties.add(new Property("deOcorrencia", StringType.create(), false,  true));
        properties.add(new Property("passo", StringType.create(), false,  true));
        properties.add(new Property("horaSolicitacao", StringType.create(), false,  true));
        properties.add(new Property("deTransmissao", StringType.create(), false,  true));
        properties.add(new Property("deTransmissaoNeg", StringType.create(), false,  true));
        properties.add(new Property("deCanal", StringType.create(), false,  true));
        properties.add(new Property("deServico", StringType.create(), false,  true));
        properties.add(new Property("tpAcao", StringType.create(), false,  true));
        properties.add(new Property("nsuCedente", StringType.create(), false,  true));
        properties.add(new Property("nuPendencia",  LongType.create(),  false,   true));
        properties.add(new Property("codUsuario", StringType.create(), false,  true));
        properties.add(new Property("ip", StringType.create(), false,  true));
        Layout result = new Layout(properties,
                "SimulacaoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigo", new LongValue("9(04)"));
        Mainframe.put("pvVinc", new LongValue("9(04)"));
        Mainframe.put("descricao", new StringValue("X(40)"));
        Mainframe.put("deTransmissao", new StringValue("X(40)"));
        Mainframe.put("deTransmissaoNeg", new StringValue("X(40)"));
        Mainframe.put("deCanal", new StringValue("X(40)"));
        Mainframe.put("deServico", new StringValue("X(40)"));
        Mainframe.put("valor", new MoneyValue("R$ 9(15)v99"));
        Mainframe.put("prazo", new LongValue("9(03)"));
        
        Mainframe.put("nu_simulacao", new LongValue("9(20)"));
        Mainframe.put("situacao", new StringValue("X(01)"));
        Mainframe.put("NSU", new LongValue("9(20)"));
        Mainframe.put("dataValidade", new StringValue("X(10)"));
        Mainframe.put("usuarioAutorizador", new StringValue("X(08)"));
        Mainframe.put("unidadeAutorizador", new LongValue("9(20)"));
        Mainframe.put("dataSolicitacao", new StringValue("X(10)"));
        Mainframe.put("nuSequencial", new LongValue("9(20)"));
        Mainframe.put("tipoTransmissao", new LongValue("9(04)"));

        Mainframe.put("coCedente", new LongValue("9(07)"));
        Mainframe.put("cnpjTela", new LongValue("9(14)"));
        Mainframe.put("nuSeqRegistro", new LongValue("9(20)"));
        Mainframe.put("nuTransAtu", new LongValue("9(04)"));
        Mainframe.put("nuTransNeg", new LongValue("9(04)"));
        
        Mainframe.put("nomeUsuario", new StringValue("X(40)"));
        Mainframe.put("nomeUnidade", new StringValue("X(40)"));
        Mainframe.put("icPessoa", new StringValue("X(1)"));
        Mainframe.put("deOcorrencia", new StringValue("X(250)"));
        Mainframe.put("passo", new StringValue("X(1)"));
        Mainframe.put("tpAcao", new StringValue("X(1)"));
        Mainframe.put("cocli", new LongValue("9(13)"));
        Mainframe.put("horaSolicitacao", new StringValue("X(08)"));
        Mainframe.put("nsuCedente", new StringValue("X(48)"));
        Mainframe.put("nuPendencia", new LongValue("9(10)"));
        Mainframe.put("codUsuario", new StringValue("X(07)"));
        Mainframe.put("ip", new StringValue("X(15)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
    
   
    
}
