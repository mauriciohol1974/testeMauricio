package br.gov.caixa.sigcb.estrategia.cedente;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.CedenteCarteiraBean;
import br.gov.caixa.sigcb.bean.CedenteConteudoListaBean;
import br.gov.caixa.sigcb.bean.CedenteGeralBean;
import br.gov.caixa.sigcb.bean.CedenteManterFiltroBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SigcbBean;
import br.gov.caixa.sigcb.bean.UnidadePVConteudoListaBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.LogUtilSigcb;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Manter Cedente >>
 * Filtro
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteManterFiltro extends CedenteEstrategia {

    private MainFrameTransactionsSigcbEjb handler = null;

    

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String nextPage = PAGE_MANTER_FILTRO;

        try {
            this.configMsgSucessoErro(request);

            String fluxo = this.getFluxo(request);
            CedenteManterFiltroBean filtroBean = new CedenteManterFiltroBean();
            if (fluxo.equals(FLUXO_NORMAL)) {
                filtroBean = (CedenteManterFiltroBean) filtroBean.getRequestBean(request);
                PilhaVoltarControle.push(request, filtroBean);
            } else {
                SigcbBean bean = PilhaVoltarControle.pop(request);
                if (bean == null || !(bean instanceof CedenteManterFiltroBean)) {
                    return (new CedenteManterIniciar()).processRequest(request,
                            response);
                }
                filtroBean = (CedenteManterFiltroBean) bean;
            }
            request.getSession().setAttribute(MANTER_FILTRO_BEAN, filtroBean);
            
            if (filtroBean.getRetornoPEC().equalsIgnoreCase("S")){
            	CedenteManterFiltroPEC pec = new CedenteManterFiltroPEC();
            	nextPage = pec.processRequest(request, response,filtroBean );
            }else{
                if (filtroBean.getRadioTipoConsulta() != null) {
                    this.handler = new MainFrameTransactionsSigcbEjb();
                    
                    switch (filtroBean.getRadioTipoConsulta().intValue()) {
                    case OPCAO_BUSCA_CEDENTE:
                        nextPage = this.buscaPorCedente(filtroBean, request);
                        break;

                    case OPCAO_BUSCA_CPFCNPJ:
                        nextPage = this.buscaPorCpfCnpj(filtroBean, request);
                        break;

                    case OPCAO_BUSCA_UNIDADE:
                        if (filtroBean.getTipoUnidade().intValue() == UNIDADE_EN) {
                            nextPage = buscaPorUnidadeEN(filtroBean, request);
                        } else {
                            nextPage = buscaPorUnidadePV(filtroBean, request);
                        }
                        break;
                    }
                }
            }


            request.getSession().setAttribute(MANTER_FILTRO_BEAN, filtroBean);

        } catch (Exception ex) {
            LogUtilSigcb.warn("Erro em CedenteManterFiltro.", ex);
            throw ex;
        }

        return nextPage;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_MANTER_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

    private String buscaPorCedente(CedenteManterFiltroBean filtroBean,
            HttpServletRequest request) throws Exception {
        // bean utilizado na transacao consultar carteira cedente
        CedenteCarteiraBean beanBuscaPorCedente = (CedenteCarteiraBean) (new CedenteCarteiraBean()).newBean();
        beanBuscaPorCedente.setCodigoCedente(filtroBean.getCodigoCedente());

        // chamando transacao
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CARTEIRA_CEDENTE + usuarioBean.getCodigoUsuario().toUpperCase();
        
        List respostaList = handler.executeFixDataRecordsetTransaction(beanBuscaPorCedente,
        		transUser);

        // obtendo parte fixa e recordset da resposta
        CedenteCarteiraBean totaisBean = (CedenteCarteiraBean) ((BeanList) respostaList.get(0)).get(0);
        BeanList beanListaTitulos = (BeanList) respostaList.get(1);
        ArrayList listaTitulos = convertDataStructure(beanListaTitulos.iterator());

        // setando resposta da transacao
        request.getSession().setAttribute(MANTER_FIXO_BEAN, totaisBean);
        request.getSession().setAttribute(MANTER_LISTA_TITULOS_BEAN, listaTitulos);

        // Obtendo dados de cabecalho
        CedenteCabecaBean cedenteCabecaBean = (CedenteCabecaBean) (new CedenteCabecaBean()).newBean();
        cedenteCabecaBean.setTipoConsulta(new Long(1)); // 1 - Por Codigo
        // Cedente
        cedenteCabecaBean.setCodigoCedente(filtroBean.getCodigoCedente());
        cedenteCabecaBean.setCodigoUsuario(this.getCodigoUsuario(request));
        cedenteCabecaBean.setOrigemConsulta(new Long(1)); // 1 - Intranet
         transUser = TRANSACAO_CABECALHO + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanCabecalhoList = handler.executeSimpleTransactionQuery(cedenteCabecaBean,
        		transUser);
        cedenteCabecaBean = (CedenteCabecaBean) beanCabecalhoList.get(0);
        cedenteCabecaBean.setCodigoCedente(filtroBean.getCodigoCedente());

        CedenteGeralBean geralBean = (CedenteGeralBean) (new CedenteGeralBean()).getRequestBean(request);
        geralBean.setCodigoCedente(filtroBean.getCodigoCedente());
        geralBean.setTipoConsulta("C"); // A - Alteracao
         transUser = TRANSACAO_CONSULTAR_GERAL + usuarioBean.getCodigoUsuario().toUpperCase();
        BeanList beanListGeral = handler.executeSimpleTransactionQuery(geralBean,
        		transUser);
        geralBean = (CedenteGeralBean) beanListGeral.get(0);
        request.getSession().setAttribute(CedenteEstrategia.CEDENTE_GERAL_BEAN,
                geralBean);

        // seta o bean de cabecalho
        request.getSession().setAttribute(CEDENTE_CABECA_BEAN,
                cedenteCabecaBean);

        // seta o Cedente Padrao
        this.setCedentePadrao(request, filtroBean.getCodigoCedente());

        return PAGE_ACAO;
    }

    private String buscaPorCpfCnpj(CedenteManterFiltroBean filtroBean,
            HttpServletRequest request) throws Exception {
        // bean utilizado na transacao listar por cpf/cnpj
        CedenteConteudoListaBean beanBuscaPorCpf = (CedenteConteudoListaBean) (new CedenteConteudoListaBean()).newBean();
        beanBuscaPorCpf.setTipoConsulta(new Long(1)); // 1 - CPF/CNPJ
        beanBuscaPorCpf.setTipoPessoa(filtroBean.getTipoPessoa());
        beanBuscaPorCpf.setCpfCnpj(filtroBean.getCpfCnpj());
        beanBuscaPorCpf.setCodigoUsuario(this.getCodigoUsuario(request));

        // chamando transacao
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR_POR_PV_CPFCNPJ + usuarioBean.getCodigoUsuario().toUpperCase();
        
        List respostaList = handler.executeFixDataRecordsetTransaction(beanBuscaPorCpf,    transUser);

        // obtendo parte fixa e recordset da resposta
        CedenteConteudoListaBean respostaBean = (CedenteConteudoListaBean) ((BeanList) respostaList.get(0)).get(0);
        BeanList beanListaCedentes = (BeanList) respostaList.get(1);

        // setando o nome no bean que ja possui o codigo unidade
        beanBuscaPorCpf.setNomeUnidadePV(respostaBean.getNomeUnidadePV());

        request.getSession().setAttribute(MANTER_FIXO_BEAN, beanBuscaPorCpf);

        // Retendo a lista de resultados obtidos
        ArrayList listaCedentes = convertDataStructure(beanListaCedentes.iterator());

        request.getSession().setAttribute(PAGINACAO_LIST,   getPageHolder(listaCedentes));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_MANTER_LISTAR_CPFCNPJ;
    }

    private String buscaPorUnidadePV(CedenteManterFiltroBean filtroBean,
            HttpServletRequest request) throws Exception {
        // bean utilizado na transacao listar por cpf/cnpj
        CedenteConteudoListaBean beanBuscaPorCpf = (CedenteConteudoListaBean) (new CedenteConteudoListaBean()).newBean();
        beanBuscaPorCpf.setTipoConsulta(new Long(2)); // 2 - Unidade PV
        beanBuscaPorCpf.setCodigoUnidadePV(filtroBean.getCodigoUnidade());
        beanBuscaPorCpf.setCodigoUsuario(this.getCodigoUsuario(request));

        // chamando transacao
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR_POR_PV_CPFCNPJ + usuarioBean.getCodigoUsuario().toUpperCase();
        
        List respostaList = handler.executeFixDataRecordsetTransaction(beanBuscaPorCpf,
        		transUser);

        // obtendo parte fixa e recordset da resposta
        CedenteConteudoListaBean respostaBean = (CedenteConteudoListaBean) ((BeanList) respostaList.get(0)).get(0);
        BeanList beanListaCedentes = (BeanList) respostaList.get(1);

        // setando o nome no bean que ja possui o codigo unidade
        beanBuscaPorCpf.setNomeUnidadePV(respostaBean.getNomeUnidadePV());

        request.getSession().setAttribute(MANTER_FIXO_BEAN, beanBuscaPorCpf);

        // retendo a lista de resultados obtidos
        ArrayList listaCedentes = convertDataStructure(beanListaCedentes.iterator());

        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(listaCedentes));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_MANTER_LISTAR_UNIDPV;
    }

    private String buscaPorUnidadeEN(CedenteManterFiltroBean filtroBean,
            HttpServletRequest request) throws Exception {
        // bean utilizado na transacao listar pv
        UnidadePVConteudoListaBean beanBuscaPorEN = (UnidadePVConteudoListaBean) (new UnidadePVConteudoListaBean()).newBean();
        beanBuscaPorEN.setCodigoUnidadeEN(filtroBean.getCodigoUnidade());

        // chamando transacao
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_LISTAR_POR_EN + usuarioBean.getCodigoUsuario().toUpperCase();
        
        List respostaList = handler.executeFixDataRecordsetTransaction(beanBuscaPorEN,
        		transUser);

        // obtendo parte fixa e recordset da resposta
        UnidadePVConteudoListaBean respostaBean = (UnidadePVConteudoListaBean) ((BeanList) respostaList.get(0)).get(0);
        BeanList beanListaPVs = (BeanList) respostaList.get(1);

        // setando o nome no bean que ja possui o codigo unidade
        beanBuscaPorEN.setNomeUnidadeEN(respostaBean.getNomeUnidadeEN());

        request.getSession().setAttribute(MANTER_FIXO_BEAN, beanBuscaPorEN);

        // retendo a lista de resultados obtidos
        ArrayList listaPVs = convertDataStructure(beanListaPVs.iterator());

        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(listaPVs));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_MANTER_LISTAR_UNIDEN;
    }

}
