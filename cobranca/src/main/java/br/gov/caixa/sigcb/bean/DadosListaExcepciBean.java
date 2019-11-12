/*
 * Bean Alterado manualmente, metodos adcionados manualmente:
 * 
 * getDataVigenciaDeFormatada()
 * getDataVigenciaAteFormatada() 
 * getDataSituacaoFormatada()
 * getDescSituacaoPendencia()
 * getDescTipoPessoa()
 * getCpfCnpjFormatado() 
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
import br.com.politec.sao.util.Formatacao;
import br.gov.caixa.sigcb.util.Formatador;
import br.gov.caixa.sigcb.util.UtilDatas;

public class DadosListaExcepciBean extends SigcbBean {
    private java.lang.String autorizado;

    private java.lang.String cargoAutorizador;

    private java.lang.Long codigoCedente;

    private java.lang.Long codigoUnidadeEN;

    private java.lang.Long codigoUnidadePV;

    private java.lang.String codigoUsuario;

    private java.lang.Long cpfCnpj;

    private java.lang.String dataPendencia;

    private java.lang.String dataSituacao;

    private java.util.Date dataVigenciaAte;

    private java.util.Date dataVigenciaDe;

    private java.lang.String estrategiaVoltar;

    private java.lang.String navegacao;

    private java.lang.String nomeFantasia;

    private java.lang.String nomeUnidadeEN;

    private java.lang.String nomeUnidadePV;

    private java.lang.Long numeroPendencia;

    private java.lang.Long numeroReiteracao;

    private java.lang.Long perfUsuarioAlcada;

    private java.lang.Long situacaoPendencia;

    private java.lang.Long tipoConsulta;

    private java.lang.Long tipoPessoa;

    private java.lang.Long tpConsultaEstrategia;

    public DadosListaExcepciBean() {
        this.autorizado = null;
        this.cargoAutorizador = null;
        this.codigoCedente = null;
        this.codigoUnidadeEN = null;
        this.codigoUnidadePV = null;
        this.codigoUsuario = null;
        this.cpfCnpj = null;
        this.dataPendencia = null;
        this.dataSituacao = null;
        this.dataVigenciaAte = null;
        this.dataVigenciaDe = null;
        this.estrategiaVoltar = null;
        this.navegacao = null;
        this.nomeFantasia = null;
        this.nomeUnidadeEN = null;
        this.nomeUnidadePV = null;
        this.numeroPendencia = null;
        this.numeroReiteracao = null;
        this.perfUsuarioAlcada = null;
        this.situacaoPendencia = null;
        this.tipoConsulta = null;
        this.tipoPessoa = null;
        this.tpConsultaEstrategia = null;
    }

    public String getApplicationName() {
        return "DadosListaExcepciBean";
    }

    public java.lang.String getAutorizado() {
        return this.autorizado;
    }

    public void setAutorizado(java.lang.String autorizado) {
        this.autorizado = autorizado;
    }

    public java.lang.String getCargoAutorizador() {
        return this.cargoAutorizador;
    }

    public void setCargoAutorizador(java.lang.String cargoAutorizador) {
        this.cargoAutorizador = cargoAutorizador;
    }

    public java.lang.Long getCodigoCedente() {
        return this.codigoCedente;
    }

    public void setCodigoCedente(java.lang.Long codigoCedente) {
        this.codigoCedente = codigoCedente;
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

    public java.lang.Long getCpfCnpj() {
        return this.cpfCnpj;
    }

    public java.lang.String getCpfCnpjFormatado() {
        String cpfCnpjTexto = "";
        if (this.getTipoPessoa().equals(new Long(1))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                    .toString(), 11);
        } else if (this.getTipoPessoa().equals(new Long(2))) {
            cpfCnpjTexto = Formatacao.formataNumerico(this.getCpfCnpj()
                    .toString(), 14);
        }
        cpfCnpjTexto = Formatacao.formataCPFCNPJ(cpfCnpjTexto);
        return cpfCnpjTexto;
    }

    public void setCpfCnpj(java.lang.Long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public java.lang.String getDataPendencia() {
        return this.dataPendencia;
    }

    public void setDataPendencia(java.lang.String dataPendencia) {
        this.dataPendencia = dataPendencia;
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

    public void setDataVigenciaAte(java.util.Date dataVigenciaAte) {
        this.dataVigenciaAte = dataVigenciaAte;
    }

    public java.util.Date getDataVigenciaDe() {
        return this.dataVigenciaDe;
    }

    public void setDataVigenciaDe(java.util.Date dataVigenciaDe) {
        this.dataVigenciaDe = dataVigenciaDe;
    }

    public java.lang.String getEstrategiaVoltar() {
        return this.estrategiaVoltar;
    }

    public void setEstrategiaVoltar(java.lang.String estrategiaVoltar) {
        this.estrategiaVoltar = estrategiaVoltar;
    }

    public java.lang.String getNavegacao() {
        return this.navegacao;
    }

    public void setNavegacao(java.lang.String navegacao) {
        this.navegacao = navegacao;
    }

    public java.lang.String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(java.lang.String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public java.lang.String getNomeUnidadeEN() {
        return this.nomeUnidadeEN;
    }

    public void setNomeUnidadeEN(java.lang.String nomeUnidadeEN) {
        this.nomeUnidadeEN = nomeUnidadeEN;
    }

    public java.lang.String getNomeUnidadePV() {
        return this.nomeUnidadePV;
    }

    public void setNomeUnidadePV(java.lang.String nomeUnidadePV) {
        this.nomeUnidadePV = nomeUnidadePV;
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

    public java.lang.Long getPerfUsuarioAlcada() {
        return this.perfUsuarioAlcada;
    }

    public void setPerfUsuarioAlcada(java.lang.Long perfUsuarioAlcada) {
        this.perfUsuarioAlcada = perfUsuarioAlcada;
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

    public java.lang.Long getTpConsultaEstrategia() {
        return this.tpConsultaEstrategia;
    }

    public void setTpConsultaEstrategia(java.lang.Long tpConsultaEstrategia) {
        this.tpConsultaEstrategia = tpConsultaEstrategia;
    }

    // ----------------- metodos criados manualmente
    // ------------------------------------------------------

    public java.lang.String getDescTipoPessoa() {

        String retorno = "";

        if (this.tipoPessoa != null) {
            switch (this.tipoPessoa.intValue()) {
            case 1:
                retorno = "FISICA";
                break;

            case 2:
                retorno = "JURIDICA";
                break;

            default:
                retorno = this.tipoPessoa.toString();
                break;
            }
        }
        return retorno;
    }

    public java.lang.String getDataPendenciaFormatada() {
        if (this.dataPendencia != null
            && this.dataPendencia.trim().length() > 0) {
            return Formatacao.colocaBarrasData(Formatacao.removeBarrasData(this.dataPendencia));
        }
        return "";
    }

    public java.lang.String getDataVigenciaDeFormatada() {
        if (this.dataVigenciaDe != null) {
            return Formatador.formatarData(this.dataVigenciaDe);
        } else {
            return "";
        }
    }

    public java.lang.String getDataVigenciaAteFormatada() {
        if (this.dataVigenciaAte != null) {
            return Formatador.formatarData(this.dataVigenciaAte);
        } else {
            return "";
        }
    }

    public java.lang.String getDataSituacaoFormatada() {
        if (this.dataSituacao != null && this.dataSituacao.trim().length() > 0) {
            return Formatacao.colocaBarrasData(Formatacao.removeBarrasData(this.dataSituacao));
        }
        return "";
    }

    public java.lang.String getDescSituacaoPendencia() {

        String retorno = "";
        switch (this.situacaoPendencia.intValue()) {
        case 1:
            Date date = new Date();
            int compData = 0;

            compData = UtilDatas.comparaDatas(this.getDataVigenciaDe(), date);

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
            retorno = this.situacaoPendencia.toString();
            break;

        }

        return retorno;
    }

    // ini-------------getCodigoCedenteFormatado---------------------
    public java.lang.String getCodigoCedenteFormatado() {
        String codigoCedenteFormatado = Formatador.formatarCodigoCedente(this.codigoCedente);
        return codigoCedenteFormatado;
    }

    // fim-------------getCodigoCedenteFormatado---------------------
    // ini-------------getCodigoUnidadeFormatado-------------------
    public java.lang.String getCodigoUnidadeENFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadeEN);
        return codigoUnidadeFormatado;
    }

    public java.lang.String getCodigoUnidadePVFormatado() {
        String codigoUnidadeFormatado = Formatador.formatarUnidade(this.codigoUnidadePV);
        return codigoUnidadeFormatado;
    }

    // fim-------------getCodigoUnidadeFormatado---------------------
    // -------------------------------------------------------------------------------------------------

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            boolean result = true;
            DadosListaExcepciBean other = (DadosListaExcepciBean) obj;
            result = result && equals(getAutorizado(), other.getAutorizado());
            result = result
                     && equals(getCargoAutorizador(),
                             other.getCargoAutorizador());
            result = result
                     && equals(getCodigoCedente(), other.getCodigoCedente());
            result = result
                     && equals(getCodigoUnidadeEN(), other.getCodigoUnidadeEN());
            result = result
                     && equals(getCodigoUnidadePV(), other.getCodigoUnidadePV());
            result = result
                     && equals(getCodigoUsuario(), other.getCodigoUsuario());
            result = result && equals(getCpfCnpj(), other.getCpfCnpj());
            result = result
                     && equals(getDataPendencia(), other.getDataPendencia());
            result = result
                     && equals(getDataSituacao(), other.getDataSituacao());
            result = result
                     && equals(getDataVigenciaAte(), other.getDataVigenciaAte());
            result = result
                     && equals(getDataVigenciaDe(), other.getDataVigenciaDe());
            result = result
                     && equals(getEstrategiaVoltar(),
                             other.getEstrategiaVoltar());
            result = result && equals(getNavegacao(), other.getNavegacao());
            result = result
                     && equals(getNomeFantasia(), other.getNomeFantasia());
            result = result
                     && equals(getNomeUnidadeEN(), other.getNomeUnidadeEN());
            result = result
                     && equals(getNomeUnidadePV(), other.getNomeUnidadePV());
            result = result
                     && equals(getNumeroPendencia(), other.getNumeroPendencia());
            result = result
                     && equals(getNumeroReiteracao(),
                             other.getNumeroReiteracao());
            result = result
                     && equals(getPerfUsuarioAlcada(),
                             other.getPerfUsuarioAlcada());
            result = result
                     && equals(getSituacaoPendencia(),
                             other.getSituacaoPendencia());
            result = result
                     && equals(getTipoConsulta(), other.getTipoConsulta());
            result = result && equals(getTipoPessoa(), other.getTipoPessoa());
            result = result
                     && equals(getTpConsultaEstrategia(),
                             other.getTpConsultaEstrategia());
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
        properties.add(new Property("autorizado",
                StringType.create(),
                false,
                true));
        properties.add(new Property("cargoAutorizador",
                StringType.create(),
                false,
                true));
        properties.add(new Property("codigoCedente",
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
        properties.add(new Property("cpfCnpj", LongType.create(), false, true));
        properties.add(new Property("dataPendencia",
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
        properties.add(new Property("estrategiaVoltar",
                StringType.create(),
                false,
                true));
        properties.add(new Property("navegacao",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeFantasia",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadeEN",
                StringType.create(),
                false,
                true));
        properties.add(new Property("nomeUnidadePV",
                StringType.create(),
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
        properties.add(new Property("perfUsuarioAlcada",
                LongType.create(),
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
        properties.add(new Property("tpConsultaEstrategia",
                LongType.create(),
                false,
                true));
        Layout result = new Layout(properties,
                "DadosListaExcepciBean",
                "br.gov.caixa.sigcb.bean");
        MainframeExtension Mainframe = new MainframeExtension();
        Mainframe.put("autorizado", new StringValue("X(01)"));
        Mainframe.put("cargoAutorizador", new StringValue("X(05)"));
        Mainframe.put("codigoCedente", new LongValue("9(07)"));
        Mainframe.put("codigoUnidadeEN", new LongValue("9(04)"));
        Mainframe.put("codigoUnidadePV", new LongValue("9(04)"));
        Mainframe.put("codigoUsuario", new StringValue("X(08)"));
        Mainframe.put("cpfCnpj", new LongValue("9(14)"));
        Mainframe.put("dataPendencia", new StringValue("X(10)"));
        Mainframe.put("dataSituacao", new StringValue("X(10)"));
        Mainframe.put("dataVigenciaAte", new DateValue("dd.MM.yyyy"));
        Mainframe.put("dataVigenciaDe", new DateValue("dd.MM.yyyy"));
        Mainframe.put("estrategiaVoltar", new StringValue("X(30)"));
        Mainframe.put("navegacao", new StringValue("X(50)"));
        Mainframe.put("nomeFantasia", new StringValue("X(40)"));
        Mainframe.put("nomeUnidadeEN", new StringValue("X(40)"));
        Mainframe.put("nomeUnidadePV", new StringValue("X(40)"));
        Mainframe.put("numeroPendencia", new LongValue("9(07)"));
        Mainframe.put("numeroReiteracao", new LongValue("9(02)"));
        Mainframe.put("perfUsuarioAlcada", new LongValue("9(04)"));
        Mainframe.put("situacaoPendencia", new LongValue("9(01)"));
        Mainframe.put("tipoConsulta", new LongValue("9(01)"));
        Mainframe.put("tipoPessoa", new LongValue("9(01)"));
        Mainframe.put("tpConsultaEstrategia", new LongValue("9(01)"));
        result.addExtension(Mainframe);
        return result;
    }

    public Layout getLayout() {
        return layout;
    }
}
