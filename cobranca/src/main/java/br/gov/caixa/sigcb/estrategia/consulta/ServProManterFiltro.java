package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.com.politec.sao.util.PageHolder;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Serviços solicitados - Solicitações processadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ServProManterFiltro extends ServProEstrategia {

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

        //MainFrameTransactionsSigcb handler = lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (ConGerServicosSolicitadosBean) filtroBean.getRequestBean(request);
            // EAM 22/08
            PilhaVoltarControle.push(request, filtroBean);
        } else {
            // EAM 22/08
            filtroBean = (ConGerServicosSolicitadosBean) PilhaVoltarControle.pop(request);
            if (filtroBean == null) {
                return (new ServProManterIniciar()).processRequest(request,
                        response);
            }
        }

        // OBS: setando as buscas com o tipo de consulta Responsável pelas
        // buscas de SERVIÇOS SOLICITADOS SOLICITAÇÕES PROCESSADAS (vide DGT)
        filtroBean.setTipoConsulta(new Long(2));
        request.getSession().setAttribute(BEAN_FILTRO, filtroBean);

        // Set p/ o cedente atual apenas se diferente de 0
        if (!filtroBean.getCodigoCedente().equals(new Long(0))) {
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    filtroBean.getCodigoCedente());
        }

        /* PV VINCULAÇÃO */
        // caminho que passa pela página da consulta de cedente por pv
        if (filtroBean.getTpFiltro().intValue() == 1) {

            if (filtroBean.getTpConsulta().intValue() == 1) {
                // LogUtilSigcb.debug("FILTRO POR PV");
                filtroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

                List bgdbList = handler.executeFixDataRecordsetTransaction(filtroBean,
                        TRANS_TODOS_PV);
                // LogUtilSigcb.debug("bgdbList = " + bgdbList.size());

                ConGerServicosSolicitadosBean bean = (ConGerServicosSolicitadosBean) ((BeanList) bgdbList.get(0)).get(0);
                // LogUtilSigcb.debug("ConGerServicosSolicitadosBean (parte
                // FIXA)= " + bean);

                BeanList bgdbBeanList = (BeanList) bgdbList.get(1);
                // LogUtilSigcb.debug("bgdbBeanList (RECORD SET)" +
                // bgdbBeanList.size());

                paginacao = convertDataStructure(bgdbBeanList.iterator());
                // for(int i = 0 ; i < paginacao.size() ; i++){
                // LogUtilSigcb.debug("paginacao " + i + " " +
                // paginacao.get(i));
                // }

                filtroBean.setNomePvVinculacao(bean.getNomePvVinculacao());

                request.getSession().setAttribute(BEAN_FILTRO, filtroBean);
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(paginacao));
                request.setAttribute(PAGINACAO_PAGE, "0");

                retorno = PAGE_TODOS_PV;

            } else {
                /* BGE1 */// Listar Cedentes de uma unidade de Vinculação
                filtroBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());

                List bge1List = handler.executeFixDataRecordsetTransaction(filtroBean,
                        TRANS_LISTA_PV);

                // obtendo dados coplementares do Filtro Bean (nome Pv
                // Vinculação)
                ConGerServicosSolicitadosBean bean = (ConGerServicosSolicitadosBean) ((BeanList) bge1List.get(0)).get(0);

                BeanList bge1BeanList = (BeanList) bge1List.get(1);
                paginacao = convertDataStructure(bge1BeanList.iterator());

                filtroBean.setNomePvVinculacao(bean.getNomePvVinculacao());

                request.getSession().setAttribute(BEAN_FILTRO, filtroBean);
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(paginacao));
                request.setAttribute(PAGINACAO_PAGE, "0");

                /* nota */
                // após a consulta ser efetuada o bean é 'setado' para não
                // passar
                // novamente por esse
                // passo do programa. Para o botão 'voltar' do programa nao seja
                // afetado.
                // EAM - 22/08
                // filtroBean.setTpFiltro(new Long(0));
                retorno = PAGE_LISTA_PVVINC;
            }

            /* CEDENTE */
            // caminho que nao passa pela pagina de cedentes por pv
        } else if (filtroBean.getTpFiltro().intValue() == 0) {
            // LogUtilSigcb.debug("Filtro por CEDENTE");
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
            // LogUtilSigcb.debug("Tipo de Consulta = " +
            // filtroBean.getTpConsulta().intValue());
            switch (filtroBean.getTpConsulta().intValue()) {

            /* nota */// os valores para tpConsulta seguem um padrão
            // necessário ao mainframe
            // esses valores serão utilizados da transação BGE1 para dizer
            // ao mainframe qual
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

                /* BGC2 */// - Obtem os dados referentes aos titulos emitidos
                // do bco sacados
                BeanList bgc2BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                        TRANS_TIT_EMI);
                paginacao = convertDataStructure(bgc2BeanList.iterator());

                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(paginacao));
                request.setAttribute(PAGINACAO_PAGE, "0");

                retorno = PAGE_TIT_EMI;

                break;

            case 5: // - Extrato de Movimentação de Títulos

                /* BGC4 */// - Obtem os dados referentes aos titulos emitidos
                // do bco sacados
                BeanList bgc4BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                        TRANS_EXT_MOV_TIT);
                paginacao = convertDataStructure(bgc4BeanList.iterator());

                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(paginacao));
                request.setAttribute(PAGINACAO_PAGE, "0");

                retorno = PAGE_EXT_MOV_TIT;

                break;

            case 9: // - Extrato de Distribuição de Creditos e Debitos

                /* BGC5 */// - Obtem os dados referentes aos titulos emitidos
                // do bco sacados
                BeanList bgc5BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                        TRANS_EXT_CRE_DEB);
                paginacao = convertDataStructure(bgc5BeanList.iterator());

                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(paginacao));
                request.setAttribute(PAGINACAO_PAGE, "0");

                retorno = PAGE_EXT_CRE_DEB;

                break;

            case 999: // - Lançamento de Tarifa Manual

                /* BGC6 */// - Obtem os dados referentes aos Lancamentos de
                // tarifas manual
                BeanList bgc6BeanList = handler.executeSimpleTransactionQuery(filtroBean,
                        TRANS_LAN_TAR_MAN);
                paginacao = convertDataStructure(bgc6BeanList.iterator());

                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(paginacao));
                request.setAttribute(PAGINACAO_PAGE, "0");

                retorno = PAGE_LAN_TAR_MAN;

                break;

            case 8: // - Recuperacao de Títulos Baixados ou Liquidados

                /* BGC7 */// - Obtem os dados referentes à reinclusão de
                // titulos baixados ou liquidados
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

                /* BGC8 */// - Obtem os dados referentes Redisponibilização de
                // arquivo de retorno
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

            case 1: // Todos
                /* BGDA */

                BeanList bgdaBeanList = handler.executeSimpleTransactionQuery(filtroBean,
                        TRANS_TODOS_CEDENTE);

                // LogUtilSigcb.debug("===Retorno BGDA : " +
                // bgdaBeanList.size());

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
                // o sistema enviará o usuário para a tela de Seleção de
                // consulta.
                retorno = new ServProManterIniciar().processRequest(request,
                        response);

                break;
            }

            request.getSession().setAttribute(BEAN_DATA, filtroBean);
        }
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
