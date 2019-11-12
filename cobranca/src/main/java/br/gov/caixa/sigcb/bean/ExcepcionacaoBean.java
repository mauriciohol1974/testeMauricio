/*
 * Bean alterado manualmente. Metodo alterado:
 * getDescSituacaoPendencia() 
 * getDataAutorizacaoFormatada()
 * dataVigenciaAte
 * */

package br.gov.caixa.sigcb.bean;

import java.util.Date;

import br.com.politec.sao.business.Layout;
import br.com.politec.sao.business.Property;
import br.com.politec.sao.business.types.DateType;
import br.com.politec.sao.business.types.LongType;
import br.com.politec.sao.business.types.StringType;
import br.com.politec.sao.iso.MainframeExtension;
import br.com.politec.sao.iso.values.DateValue;
import br.com.politec.sao.iso.values.LongValue;
import br.com.politec.sao.iso.values.StringValue;
import br.com.politec.sao.util.Currency;
import br.com.politec.sao.util.Formatacao;
import br.com.politec.sao.util.Money;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.Util;
import br.gov.caixa.sigcb.util.UtilDatas;

public class ExcepcionacaoBean extends SigcbBean {
    private java.lang.Long codigoCedente;

    private java.lang.Long codigoItemExcep;

    private java.lang.Long codigoParecer;

    private java.lang.Long codigoUnidadeEN;

    private java.lang.Long codigoUnidadePV;

    private java.lang.String codigoUsuario;

    private java.lang.String conteudoAnterior;

    private java.lang.String conteudoNegociado;

    private java.lang.Long cpfCnpj;

    private java.lang.String dataAutorizacao;

    private java.lang.String dataPendenciaOrig;

    private java.lang.String dataSituacao;

    private java.util.Date dataVigenciaAte;

    private java.util.Date dataVigenciaDe;

    private java.lang.String descrItemExcep;

    private java.lang.String fakeRecordSet;

    private java.lang.String horaGeracao;

    private java.lang.String ident;

    private java.lang.String justificativa;

    private java.lang.Long meioEntrada;

    private java.lang.String navegacao;

    private java.util.Date novaDataFim;

    private java.lang.Long numeroPendencia;

    private java.lang.Long numeroReiteracao;

    private java.lang.String paginaAnterior;

    private java.lang.String perfUsuarioAlcada;

    private java.lang.String perfilUsuarioAlcada;

    private java.lang.String perfilUsuarioAut;

    private java.lang.String resposta;

    private java.lang.Long situacaoPendencia;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoPessoa;

    private java.lang.String usuarioAutorizador;

    private java.lang.String usuarioGerador;
    
    private String usuarioAlterador;
    
    private String dataAlterador;
    
    private String datavigenciaINI;
    
    private String datavigenciaFIM;

    private String ip;

    public ExcepcionacaoBean() {
        this.codigoCedente = null;
        this.codigoItemExcep = null;
        this.codigoParecer = null;
        this.codigoUnidadeEN = null;
        this.codigoUnidadePV = null;
        this.codigoUsuario = null;
        this.conteudoAnterior = null;
        this.conteudoNegociado = null;
        this.cpfCnpj = null;
        this.dataAutorizacao = null;
        this.dataPendenciaOrig = null;
        this.dataSituacao = null;
        this.dataVigenciaAte = null;
        this.dataVigenciaDe = null;
        this.descrItemExcep = null;
        this.fakeRecordSet = null;
        this.horaGeracao = null;
        this.ident = null;
        this.justificativa = null;
        this.meioEntrada = null;
        this.navegacao = null;
        this.novaDataFim = null;
        this.numeroPendencia = null;
        this.numeroReiteracao = null;
        this.paginaAnterior = null;
        this.perfUsuarioAlcada = null;
        this.perfilUsuarioAlcada = null;
        this.perfilUsuarioAut = null;
        this.resposta = null;
        this.situacaoPendencia = null;
        this.tipoConsulta = null;
        this.tipoPessoa = null;
        this.usuarioAutorizador = null;
        this.usuarioGerador = null;
        this.usuarioAlterador = null;
        this.dataAlterador = null;
        this.datavigenciaINI=null;
        this.datavigenciaFIM=null;
        this.ip=null;
    }

    public String getApplicationName() {
        return "ExcepcionacaoBean";
    }
    

    public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    
    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public java.lang.Long getCodigoItemExcep() {
        return this.codigoItemExcep;
    }

    public void setCodigoItemExcep(java.lang.Long codigoItemExcep) {
        this.codigoItemExcep = codigoItemExcep;
    }

    public java.lang.Long getCodigoParecer() {
        return this.codigoParecer;
    }

    public void setCodigoParecer(java.lang.Long codigoParecer) {
        this.codigoParecer = codigoParecer;
    }

    public java.lang.Long getCodigoUnidadeEN() {
        return this.codigoUnidadeEN;
    }

    public void setCodigoUnidadeEN(java.lang.Long codigoUnidadeEN) {
        this.codigoUnidadeEN = codigoUnidadeEN;
    }

    public java.lang.Long getCodigoUnidadePV() {
        return this.codigoUnidadePV;
    }

    public void setCodigoUnidadePV(java.lang.Long codigoUnidadePV) {
        this.codigoUnidadePV = codigoUnidadePV;
    }

    public java.lang.String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(java.lang.String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public java.lang.String getConteudoAnterior() {
        return this.conteudoAnterior;
    }

    public void setConteudoAnterior(java.lang.String conteudoAnterior) {
        this.conteudoAnterior = conteudoAnterior;
    }

    public java.lang.String getConteudoNegociado() {
        return this.conteudoNegociado;
    }

    public void setConteudoNegociado(java.lang.String conteudoNegociado) {
        this.conteudoNegociado = conteudoNegociado;
    }

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.lang.String getDataAutorizacao() {
        return this.dataAutorizacao;
    }

    public void setDataAutorizacao(java.lang.String dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
    }

    public java.lang.String getDataPendenciaOrig() {
        return this.dataPendenciaOrig;
    }

    public void setDataPendenciaOrig(java.lang.String dataPendenciaOrig) {
        this.dataPendenciaOrig = dataPendenciaOrig;
    }
    
    

    // -------------------------------------------

    public String getUsuarioAlterador() {
		return usuarioAlterador;
	}

	public void setUsuarioAlterador(String usuarioAlterador) {
		this.usuarioAlterador = usuarioAlterador;
	}

	public String getDataAlterador() {
		
		return dataAlterador;
	}

	public void setDataAlterador(String dataAlterador) {
		this.dataAlterador = dataAlterador;
	}

	
	
	public String getDatavigenciaINI() {
		return datavigenciaINI;
	}

	public void setDatavigenciaINI(String datavigenciaINI) {
		this.datavigenciaINI = datavigenciaINI;
	}

	public String getDatavigenciaFIM() {
		return datavigenciaFIM;
	}

	public void setDatavigenciaFIM(String datavigenciaFIM) {
		this.datavigenciaFIM = datavigenciaFIM;
	}

	public java.lang.String getDescParecer() {

        String retorno = "";

        if (this.codigoParecer != null) {
            switch (this.getCodigoParecer().intValue()) {
            case 1:
                retorno = "EM ABERTO";
                break;
            case 2:
                retorno = "AUTORIZADO";
                break;
            case 3:
                retorno = "NAO AUTORIZADO";
                break;
            default:
                retorno = "";
                break;
            }
        }

        return retorno;
    }

    /* nota */
    // metodo responsável por formatar conta
    protected String formataConta(String conta) {
        String contaFormatada = conta.substring(0, 4) + " ";
        contaFormatada += conta.substring(4, 7) + " ";
        contaFormatada += conta.substring(7, 15) + " ";
        // contaFormatada += conta.substring(15, 16);
        return contaFormatada;
    }

    public String getConteudoAnteriorFormatado() {

        /*
         * obs ident = "A" campo alfanumérico "N" campo numerico "C" campo de
         * conta
         */

        String retorno = "";
        if (this.ident != null) {
            if (ident.equals("N")) {

                Long dec = new Long(conteudoAnterior);

                Money tempMoneyOrig = new Money(Util.zerosEsquerda(dec, 15),
                        2,
                        Currency.real());

                retorno = tempMoneyOrig.toString();

            } else if (ident.equals("C")) {
                retorno = formataConta(conteudoAnterior);
            } else {
                retorno = conteudoAnterior;
            }
        }
        return retorno;
    }

    public String getConteudoNegociadoFormatado() {

        /*
         * obs ident = "A" campo alfanumérico "N" campo numerico "C" campo Conta
         */

        String retorno = "";

        if (this.ident != null) {
            if (ident.equals("N")) {
                Long dec = new Long(conteudoNegociado);

                Money tempMoneyExp = new Money(Util.zerosEsquerda(dec, 15),
                        2,
                        Currency.real());

                retorno = tempMoneyExp.toString();

            } else if (ident.equals("C")) {
                retorno = formataConta(conteudoNegociado);
            } else {
                retorno = conteudoNegociado;
            }
        }
        return retorno;
    }

    public java.lang.String getHoraGeracaoFormatada() {
        String horaG = "";

        if (this.horaGeracao != null && !this.horaGeracao.equals("")) {
            horaG = Util.trocaCaracter('.', ':', this.horaGeracao);
        }

        return horaG;
    }

    public java.lang.String getDataSituacao() {
        return this.dataSituacao;
    }

    public void setDataSituacao(java.lang.String dataSituacao) {
        this.dataSituacao = dataSituacao;
    }

    public java.util.Date getDataVigenciaAte() {
        return this.dataVigenciaAte;
    }

    public java.lang.String getDataVigenciaAteFormatada() {
        if (this.dataVigenciaAte != null) {
            return Formatador.formatarData(this.dataVigenciaAte);
        } else {
            return "";
        }
    }

    public java.lang.String getDataVigenciaDeFormatada() {
        if (this.dataVigenciaDe != null) {
            return Formatador.formatarData(this.dataVigenciaDe);
        } else {
            return "";
        }
    }

    public void setDataVigenciaAte(java.util.Date dataVigenciaAte) {
        this.dataVigenciaAte = dataVigenciaAte;
    }

    public java.util.Date getDataVigenciaDe() {
        return this.dataVigenciaDe;
    }

    public void setDataVigenciaDe(java.util.Date dataVigenciaDe) {
        this.dataVigenciaDe = dataVigenciaDe;
    }

    public java.lang.String getDescrItemExcep() {
        return this.descrItemExcep;
    }

    public void setDescrItemExcep(java.lang.String descrItemExcep) {
        this.descrItemExcep = descrItemExcep;
    }

    public java.lang.String getFakeRecordSet() {
        return this.fakeRecordSet;
    }

    public void setFakeRecordSet(java.lang.String fakeRecordSet) {
        this.fakeRecordSet = fakeRecordSet;
    }

    public java.lang.String getHoraGeracao() {
        return this.horaGeracao;
    }

    public void setHoraGeracao(java.lang.String horaGeracao) {
        this.horaGeracao = horaGeracao;
    }

    public java.lang.String getIdent() {
        return this.ident;
    }

    public void setIdent(java.lang.String ident) {
        this.ident = ident;
    }

    public java.lang.String getJustificativa() {
        return this.justificativa;
    }

    public void setJustificativa(java.lang.String justificativa) {
        this.justificativa = justificativa;
    }

    public java.lang.Long getMeioEntrada() {
        return this.meioEntrada;
    }

    public void setMeioEntrada(java.lang.Long meioEntrada) {
        this.meioEntrada = meioEntrada;
    }

    public java.lang.String getNavegacao() {
        return this.navegacao;
    }

    public void setNavegacao(java.lang.String navegacao) {
        this.navegacao = navegacao;
    }

    public java.util.Date getNovaDataFim() {
        return this.novaDataFim;
    }

    public void setNovaDataFim(java.util.Date novaDataFim) {
        this.novaDataFim = novaDataFim;
    }

    public java.lang.Long getNumeroPendencia() {
        return this.numeroPendencia;
    }

    public void setNumeroPendencia(java.lang.Long numeroPendencia) {
        this.numeroPendencia = numeroPendencia;
    }

    public java.lang.Long getNumeroReiteracao() {
        return this.numeroReiteracao;
    }

    public void setNumeroReiteracao(java.lang.Long numeroReiteracao) {
        this.numeroReiteracao = numeroReiteracao;
    }

    public java.lang.String getPaginaAnterior() {
        return this.paginaAnterior;
    }

    public void setPaginaAnterior(java.lang.String paginaAnterior) {
        this.paginaAnterior = paginaAnterior;
    }

    public java.lang.String getPerfUsuarioAlcada() {
        return this.perfUsuarioAlcada;
    }

    public void setPerfUsuarioAlcada(java.lang.String perfUsuarioAlcada) {
        this.perfUsuarioAlcada = perfUsuarioAlcada;
    }

    public java.lang.String getPerfilUsuarioAlcada() {
        return this.perfilUsuarioAlcada;
    }

    public void setPerfilUsuarioAlcada(java.lang.String perfilUsuarioAlcada) {
        this.perfilUsuarioAlcada = perfilUsuarioAlcada;
    }

    public java.lang.String getPerfilUsuarioAut() {
        return this.perfilUsuarioAut;
    }

    public void setPerfilUsuarioAut(java.lang.String perfilUsuarioAut) {
        this.perfilUsuarioAut = perfilUsuarioAut;
    }

    public java.lang.String getResposta() {
        return this.resposta;
    }

    public void setResposta(java.lang.String resposta) {
        this.resposta = resposta;
    }

    public java.lang.Long getSituacaoPendencia() {
        return this.situacaoPendencia;
    }

    public void setSituacaoPendencia(java.lang.Long situacaoPendencia) {
        this.situacaoPendencia = situacaoPendencia;
    }

    public java.lang.Long getTipoConsulta() {
        return this.tipoConsulta;
    }

    public void setTipoConsulta(java.lang.Long tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public java.lang.Long getTipoPessoa() {
        return this.tipoPessoa;
    }

    public void setTipoPessoa(java.lang.Long tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public java.lang.String getUsuarioAutorizador() {
        return this.usuarioAutorizador;
    }

    public void setUsuarioAutorizador(java.lang.String usuarioAutorizador) {
        this.usuarioAutorizador = usuarioAutorizador;
    }

    public java.lang.String getUsuarioGerador() {
        return this.usuarioGerador;
    }

    // ------------------getDescSituacaoPendencia()---------------------
    public java.lang.String getDescSituacaoPendencia() {

        String retorno = "";

        if (this.situacaoPendencia != null) {
            switch (this.situacaoPendencia.intValue()) {
            case 1:
                Date date = new Date();
                int compData = 0;

                compData = UtilDatas.comparaDatas(this.getDataVigenciaDe(),
                        date);

                if (compData == 1) {
                    retorno = "AGENDADA";
                } else {
                    retorno = "LIBERADA";
                }
                break;

            case 2:
                retorno = "NAO LIBERADA";
                break;

            default:
                retorno = "";
                break;
            }
        }
        return retorno;
    }

    // ------------------getDescSituacaoPendencia()---------------------

    public java.lang.String getDataAutorizacaoFormatada() {
        if (this.dataAutorizacao != null
            && this.dataAutorizacao.trim().length() > 0) {
            return Formatacao.colocaBarrasData(Formatacao.removeBarrasData(this.dataAutorizacao));
        }
        return "";
    }

    public void setUsuarioGerador(java.lang.String usuarioGerador) {
        this.usuarioGerador = usuarioGerador;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            ExcepcionacaoBean other = (ExcepcionacaoBean) obj;
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoItemExcep(), other.getCodigoItemExcep());
            result = result
                     && equals(getCodigoParecer(), other.getCodigoParecer());
            result = result
                     && equals(getCodigoUnidadeEN(), other.getCodigoUnidadeEN());
            result = result
                     && equals(getCodigoUnidadePV(), other.getCodigoUnidadePV());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result
                     && equals(getConteudoAnterior(),
                             other.getConteudoAnterior());
            result = result
                     && equals(getConteudoNegociado(),
                             other.getConteudoNegociado());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result
                     && equals(getDataAutorizacao(), other.getDataAutorizacao());
            result = result
                     && equals(getDataPendenciaOrig(),
                             other.getDataPendenciaOrig());
            result = result
                     && equals(getDataSituacao(), other.getDataSituacao());
            result = result
                     && equals(getDataVigenciaAte(), other.getDataVigenciaAte());
            result = result
                     && equals(getDataVigenciaDe(), other.getDataVigenciaDe());
            result = result
                     && equals(getDescrItemExcep(), other.getDescrItemExcep());
            result = result
                     && equals(getFakeRecordSet(), other.getFakeRecordSet());
            result = result && equals(getHoraGeracao(), other.getHoraGeracao());
            result = result && equals(getIdent(), other.getIdent());
            result = result
                     && equals(getJustificativa(), other.getJustificativa());
            result = result && equals(getMeioEntrada(), other.getMeioEntrada());
            result = result && equals(getNavegacao(), other.getNavegacao());
            result = result && equals(getNovaDataFim(), other.getNovaDataFim());
            result = result
                     && equals(getNumeroPendencia(), other.getNumeroPendencia());
            result = result
                     && equals(getNumeroReiteracao(),
                             other.getNumeroReiteracao());
            result = result
                     && equals(getPaginaAnterior(), other.getPaginaAnterior());
            result = result
                     && equals(getPerfUsuarioAlcada(),
                             other.getPerfUsuarioAlcada());
            result = result
                     && equals(getPerfilUsuarioAlcada(),
                             other.getPerfilUsuarioAlcada());
            result = result
                     && equals(getPerfilUsuarioAut(),
                             other.getPerfilUsuarioAut());
            result = result && equals(getResposta(), other.getResposta());
            result = result
                     && equals(getSituacaoPendencia(),
                             other.getSituacaoPendencia());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result
                     && equals(getUsuarioAutorizador(),
                             other.getUsuarioAutorizador());
            result = result  && equals(getUsuarioGerador(), other.getUsuarioGerador());
            result = result  && equals(getUsuarioAlterador(), other.getUsuarioAlterador());
            result = result  && equals(getDataAlterador(), other.getDataAlterador());
            result = result  && equals(getDatavigenciaINI(), other.getDatavigenciaINI());
            result = result  && equals(getDatavigenciaFIM(), other.getDatavigenciaFIM());
            result = result  && equals(getIp(), other.getIp());
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
        properties.add(new Property("codigoItemExcep",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoParecer",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadeEN",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUnidadePV",
                LongType.create(),
                false,
                true));
        properties.add(new Property("codigoUsuario",
                StringType.create(),
                false,
                true));
        properties.add(new Property("conteudoAnterior",
                StringType.create(),
                false,
                true));
        properties.add(new Property("conteudoNegociado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("dataAutorizacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataPendenciaOrig",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataSituacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataVigenciaAte",
                DateType.create(),
                false,
                true));
        properties.add(new Property("dataVigenciaDe",
                DateType.create(),
                false,
                true));
        properties.add(new Property("descrItemExcep",
                StringType.create(),
                false,
                true));
        properties.add(new Property("fakeRecordSet",
                StringType.create(),
                false,
                true));
        properties.add(new Property("horaGeracao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("ident", StringType.create(), false, true));
        properties.add(new Property("justificativa",
                StringType.create(),
                false,
                true));
        properties.add(new Property("meioEntrada",
                LongType.create(),
                false,
                true));
        properties.add(new Property("navegacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("novaDataFim",
                DateType.create(),
                false,
                true));
        properties.add(new Property("numeroPendencia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("numeroReiteracao",
                LongType.create(),
                false,
                true));
        properties.add(new Property("paginaAnterior",
                StringType.create(),
                false,
                true));
        properties.add(new Property("perfUsuarioAlcada",
                StringType.create(),
                false,
                true));
        properties.add(new Property("perfilUsuarioAlcada",
                StringType.create(),
                false,
                true));
        properties.add(new Property("perfilUsuarioAut",
                StringType.create(),
                false,
                true));
        properties.add(new Property("resposta",
                StringType.create(),
                false,
                true));
        properties.add(new Property("situacaoPendencia",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoConsulta",
                LongType.create(),
                false,
                true));
        properties.add(new Property("tipoPessoa",
                LongType.create(),
                false,
                true));
        properties.add(new Property("usuarioAutorizador",
                StringType.create(),
                false,
                true));
        properties.add(new Property("usuarioGerador",
                StringType.create(),
                false,
                true));
        properties.add(new Property("usuarioAlterador",
                StringType.create(),
                false,
                true));
        properties.add(new Property("dataAlterador",
                StringType.create(),
                false,
                true));
        properties.add(new Property("datavigenciaINI",
                StringType.create(),
                false,
                true));
        properties.add(new Property("datavigenciaFIM",
                StringType.create(),
                false,
                true));
        properties.add(new Property("ip",
                StringType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "ExcepcionacaoBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("codigoItemExcep", new LongValue("9(04)"));
        Mainframe.put("codigoParecer", new LongValue("9(01)"));
        Mainframe.put("codigoUnidadeEN", new LongValue("9(04)"));
        Mainframe.put("codigoUnidadePV", new LongValue("9(04)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("conteudoAnterior", new StringValue("X(18)"));
        Mainframe.put("conteudoNegociado", new StringValue("X(18)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("dataAutorizacao", new StringValue("X(10)"));
        Mainframe.put("dataPendenciaOrig", new StringValue("X(10)"));
        Mainframe.put("dataSituacao", new StringValue("X(10)"));
        Mainframe.put("dataVigenciaAte", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataVigenciaDe", new DateValue("dd.MM.yyyy"));
        Mainframe.put("descrItemExcep", new StringValue("X(40)"));
        Mainframe.put("fakeRecordSet", new StringValue("X(740)"));
        Mainframe.put("horaGeracao", new StringValue("X(08)"));
        Mainframe.put("ident", new StringValue("X(01)"));
        Mainframe.put("justificativa", new StringValue("X(200)"));
        Mainframe.put("meioEntrada", new LongValue("9(02)"));
        Mainframe.put("novaDataFim", new DateValue("dd.MM.yyyy"));
        Mainframe.put("numeroPendencia", new LongValue("9(07)"));
        Mainframe.put("numeroReiteracao", new LongValue("9(02)"));
        Mainframe.put("paginaAnterior", new StringValue("X(01)"));
        Mainframe.put("perfUsuarioAlcada", new StringValue("X(08)"));
        Mainframe.put("perfilUsuarioAlcada", new StringValue("X(08)"));
        Mainframe.put("perfilUsuarioAut", new StringValue("X(08)"));
        Mainframe.put("resposta", new StringValue("X(200)"));
        Mainframe.put("situacaoPendencia", new LongValue("9(01)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("usuarioAutorizador", new StringValue("X(08)"));
        Mainframe.put("usuarioGerador", new StringValue("X(08)"));
        Mainframe.put("usuarioAlterador", new StringValue("X(08)"));
        Mainframe.put("dataAlterador", new StringValue("X(10)"));
        Mainframe.put("datavigenciaINI", new StringValue("X(10)"));
        Mainframe.put("datavigenciaFIM", new StringValue("X(10)"));
        Mainframe.put("ip", new StringValue("X(15)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
