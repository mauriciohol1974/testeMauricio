package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;


//import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Serviços solicitados - Solicitações dia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class ServDiaManterFiltro extends ServDiaEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        String retorno = "";
        String fluxo = getFluxo(request);

        ConGerServicosSolicitadosBean filtroBean = new ConGerServicosSolicitadosBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        ArrayList paginacao = new ArrayList();

        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (ConGerServicosSolicitadosBean) filtroBean.getRequestBean(request);
        } else {
            filtroBean = (ConGerServicosSolicitadosBean) filtroBean.getSessionBean(request,
                    BEAN_FILTRO);
        }

        //MainFrameTransactionsSigcb handler = lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        request.getSession().setAttribute(CEDENTE_ATUAL,
                filtroBean.getCodigoCedente());
        request.getSession().setAttribute(BEAN_FILTRO, filtroBean);

        if ((request.getSession().getAttribute(BEAN_CABECALHO) == null)
            || (fluxo.equals(FLUXO_NORMAL))) {
            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);

            /* BGM0 */// - Obtem dados do cabeçalho do Cedente no SICLI
            // o sistema so fará a chamada a essa trans. apenas uma vez
            // as demais telas recebem os dados dessa trans. da session.
            cedCabBean.setTipoConsulta(new Long(1));
            cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
            cedCabBean.setCodigoCedente(filtroBean.getCodigoCedente());
            cedCabBean.setOrigemConsulta(new Long(1));

            BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                    TRANS_CABECALHO);
            cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

            cedCabBean.setCodigoCedente(filtroBean.getCodigoCedente());
            request.getSession().setAttribute(BEAN_CABECALHO, cedCabBean);
        }

        // OBS: setando as buscas com o tipo de consulta Responsável pelas
        // buscas de SERVIÇOS SOLICITADOS DIA (vide DGT)
        filtroBean.setTipoConsulta(new Long(1));

        switch (filtroBean.getTpConsulta().intValue()) {

        /* nota */// os valores para tpConsulta seguem um padrão necessário ao
                // mainframe
        // esses valores serão utilizados da transação BGE1 para dizer ao
        // mainframe qual
        // o tipo de consulta(Relatório)o usuário está requisitando.
        case 7: // - Age. Emi. Titulos p/ bco sacados

            /* BGB9 */// - obtem dados do banco de sacados
            BeanList bgb9BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                    TRANS_AGE_EMI);
            paginacao = convertDataStructure(bgb9BeanList.iterator());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(paginacao));
            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_AGE_EMI;

            break;

        case 3: // - Bloquetos pré impressos

            /* BGC1 */// - Obtem da dados dos bloquetos pré impressos
            BeanList bgc1BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                    TRANS_BLOQ_PRE);
            paginacao = convertDataStructure(bgc1BeanList.iterator());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(paginacao));
            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_BLOQ_PRE;

            break;

        case 6: // - Emissão de Titulos para o bco sacados

            /* BGC2 */// - Obtem os dados referentes aos titulos emitidos do bco
                    // sacados
            BeanList bgc2BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                    TRANS_TIT_EMI);
            paginacao = convertDataStructure(bgc2BeanList.iterator());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(paginacao));
            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_TIT_EMI;

            break;

        case 5: // - Extrato de Movimentação de Títulos

            /* BGC4 */// - Obtem os dados referentes aos titulos emitidos do bco
                    // sacados
            BeanList bgc4BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                    TRANS_EXT_MOV_TIT);
            paginacao = convertDataStructure(bgc4BeanList.iterator());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(paginacao));
            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_EXT_MOV_TIT;

            break;

        case 9: // - Extrato de Distribuição de Creditos e Debitos

            /* BGC5 */// - Obtem os dados referentes aos titulos emitidos do bco
                    // sacados
            BeanList bgc5BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                    TRANS_EXT_CRE_DEB);
            paginacao = convertDataStructure(bgc5BeanList.iterator());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(paginacao));
            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_EXT_CRE_DEB;

            break;

        case 999: // - Lançamento de Tarifa Manual

            /* BGC6 */// - Obtem os dados referentes aos Lancamentos de tarifas
                    // manual
            BeanList bgc6BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                    TRANS_LAN_TAR_MAN);
            paginacao = convertDataStructure(bgc6BeanList.iterator());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(paginacao));
            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_LAN_TAR_MAN;

            break;

        case 8: // - Reiclusão de Títulos Baixados ou Liquidados

            /* BGC7 */// - Obtem os dados referentes à reinclusão de titulos
                    // baixados ou liquidados
            BeanList bgc7BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                    TRANS_REI_TIT_BAI);

            paginacao = convertDataStructure(bgc7BeanList.iterator());

            PageHolder PHpaginacao = getPageHolder(paginacao);
            PHpaginacao.setPageSize(30);

            request.getSession().setAttribute(PAGINACAO_LIST, PHpaginacao);
            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_REI_TIT_BAI;

            break;

        case 2: // - Redisponibilização de Arquivo de Retorno

            /* BGC8 */// - Obtem os dados referentes Redisponibilização de arquivo
                    // de retorno
            BeanList bgc8BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                    TRANS_RED_ARQ_RET);

            paginacao = convertDataStructure(bgc8BeanList.iterator());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(paginacao));
            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_RED_ARQ_RET;

            break;

        case 888: // - Reemissão de Bloquetos

            /* BGC9 */// - Reemissao de bloquetos
            BeanList bgc9BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                    TRANS_REE_BLO);

            paginacao = convertDataStructure(bgc9BeanList.iterator());

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(paginacao));
            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_REE_BLO;

            break;

        case 11: // Todos
            /* BGDA */

            // LogUtilSigcb.debug("filtroBean.getTipoConsulta = " +
            // filtroBean.getTpConsulta());
            BeanList bgdaBeanList = handler.executeSimpleTransactionQuery(filtroBean,
                    TRANS_TODOS_CEDENTE);

            // LogUtilSigcb.debug("===Retorno BGDA : " + bgdaBeanList.size());

            // for (int i = 0; i < bgdaBeanList.size(); i++) {
            // LogUtilSigcb.debug(" pos " + i + " " + bgdaBeanList.get(i));
            //
            // }

            paginacao = convertDataStructure(bgdaBeanList.iterator());

            // for (int i = 0; i < paginacao.size(); i++) {
            // LogUtilSigcb.debug(" pos Paginacao" + i + " " +
            // paginacao.get(i));
            //
            // }

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(paginacao));
            request.setAttribute(PAGINACAO_PAGE, "0");

            retorno = PAGE_TODOS_CEDENTE;

            break;

        default:

            /* nota */
            // caso a session dos beans expirem antes da session do
            // USUARIOLDAP_BEAN
            // o sistema enviará o usuário para a tela de Seleção de consulta.
            retorno = new ServProManterIniciar().processRequest(request,
                    response);

            break;

        }
        request.getSession().setAttribute(BEAN_DATA, filtroBean);

        return retorno;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(TITLE);

        request.getSession().setAttribute(BEAN_MSG, msgBean);
    }
}
