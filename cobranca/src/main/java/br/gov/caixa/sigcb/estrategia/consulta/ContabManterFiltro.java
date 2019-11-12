package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ContabilBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta Contábil
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>17/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class ContabManterFiltro extends ContabEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String pagina = "";

        try {

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);

            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);

            // Recupera os beans
            ContabilBean contabilFiltroBean = new ContabilBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                contabilFiltroBean = (ContabilBean) contabilFiltroBean.getRequestBean(request);
                PilhaVoltarControle.push(request, contabilFiltroBean);
            } else {
                contabilFiltroBean = (ContabilBean) PilhaVoltarControle.pop(request);
                if (contabilFiltroBean == null) {
                    return (new ContabManterIniciar()).processRequest(request,
                            response);
                }
            }

            request.getSession().setAttribute(FILTRO_BEAN, contabilFiltroBean);
            request.getSession().setAttribute(DATA_BEAN, contabilFiltroBean);

            // Instancia o EJB que acessa o mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            // Atribuindo tipoConsulta quando foi escolhido caixa no filtro e
            // depois escolhido uma RSRET
            if (contabilFiltroBean.getTipoConsulta()
                    .equals(TIPO_CONSULTA_CAIXA_REC)
                && contabilFiltroBean.getNavegacao().equals(NAVEGACAO_CAIXA_PV)) {
                contabilFiltroBean.setTipoConsulta(TIPO_CONSULTA_REC);
            }

            // Consulta saldo operacional
            if (contabilFiltroBean.getSelecaoConsulta()
                    .equals(VALORES_A_CREDITAR)) {
                // faz chamada da transacao de consulta BGD8
                InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
                String transUser = TRANSACAO_CONSULTAR + usuarioBean.getCodigoUsuario().toUpperCase();
                List salOpeList = handler.executeFixDataRecordsetTransaction(contabilFiltroBean,transUser);

                ContabilBean saldoOperacionalBean = (ContabilBean) ((BeanList) salOpeList.get(0)).get(0);
                saldoOperacionalBean.setCodigoUnidade(contabilFiltroBean.getCodigoUnidade());
                saldoOperacionalBean.setTipoConsulta(contabilFiltroBean.getTipoConsulta());
                saldoOperacionalBean.setData(contabilFiltroBean.getData());
                saldoOperacionalBean.setSelecaoRadio(contabilFiltroBean.getSelecaoRadio());
                saldoOperacionalBean.setSelecaoConsulta(contabilFiltroBean.getSelecaoConsulta());
                saldoOperacionalBean.setNavegacao(contabilFiltroBean.getNavegacao());

                // Retem os beans de dados fixos e array
                request.getSession().setAttribute(DATA_BEAN,
                        saldoOperacionalBean);

                // pega a lista de beans parte variavel
                BeanList salOpeBeanList = (BeanList) salOpeList.get(1);

                // converte a lista em um array de beans
                ArrayList salOpeArrayList = convertDataStructure(salOpeBeanList.iterator());

                // Lança os beans de dados de paginação
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(salOpeArrayList));
                request.setAttribute(PAGINACAO_PAGE, "0");

                pagina = PAGE_CONSULTAR;
            }

            // Consulta de saldos contábeis
            else if (contabilFiltroBean.getSelecaoConsulta()
                    .equals(SALDOS_OPERACIONAIS)) {

                // faz chamada da transacao de consulta BGD9
                List salContList = handler.executeFixDataRecordsetTransaction(contabilFiltroBean,
                        TRANSACAO_CONSULTAR_SALDO);

                ContabilBean saldoBean = (ContabilBean) ((BeanList) salContList.get(0)).get(0);
                saldoBean.setCodigoUnidade(contabilFiltroBean.getCodigoUnidade());
                saldoBean.setTipoConsulta(contabilFiltroBean.getTipoConsulta());
                saldoBean.setData(contabilFiltroBean.getData());
                saldoBean.setSelecaoRadio(contabilFiltroBean.getSelecaoRadio());
                saldoBean.setSelecaoConsulta(contabilFiltroBean.getSelecaoConsulta());
                saldoBean.setNavegacao(contabilFiltroBean.getNavegacao());

                // lança os beans de dados fixos e array
                request.getSession().setAttribute(DATA_BEAN, saldoBean);

                // pega a lista de beans parte variavel
                BeanList salContBeanList = (BeanList) salContList.get(1);

                // converte a lista em um array de beans
                ArrayList salContArrayList = convertDataStructure(salContBeanList.iterator());

                // lança os beans de dados de paginação
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(salContArrayList));
                request.setAttribute(PAGINACAO_PAGE, "0");

                pagina = PAGE_CONSULTAR_SALDO;
            }
            // Consulta de posições contábeis
            else if (contabilFiltroBean.getSelecaoConsulta()
                    .equals(LIQUIDACOES)) {

                // faz chamada da transacao de consulta BGE0
                List posContList = handler.executeFixDataRecordsetTransaction(contabilFiltroBean,
                        TRANSACAO_CONSULTAR_POSICAO);

                ContabilBean posicaoBean = (ContabilBean) ((BeanList) posContList.get(0)).get(0);
                posicaoBean.setCodigoUnidade(contabilFiltroBean.getCodigoUnidade());
                posicaoBean.setTipoConsulta(contabilFiltroBean.getTipoConsulta());
                posicaoBean.setData(contabilFiltroBean.getData());
                posicaoBean.setSelecaoRadio(contabilFiltroBean.getSelecaoRadio());
                posicaoBean.setSelecaoConsulta(contabilFiltroBean.getSelecaoConsulta());
                posicaoBean.setNavegacao(contabilFiltroBean.getNavegacao());

                // lança os beans de dados fixos e array
                request.getSession().setAttribute(DATA_BEAN, posicaoBean);

                // pega a lista de beans parte variavel
                BeanList posContBeanList = (BeanList) posContList.get(1);

                // converte a lista em um array de beans
                ArrayList posContArrayList = convertDataStructure(posContBeanList.iterator());

                // lança os beans de dados de paginação
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(posContArrayList));
                request.setAttribute(PAGINACAO_PAGE, "0");

                pagina = PAGE_CONSULTAR_POSICAO;
            }

        } catch (Exception e) {
            throw e;
        }
        return pagina;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
