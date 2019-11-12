package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.HistoricoCedenteBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Historico de Cedentes
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class HisCedManterFiltro extends HistoricoCedenteEstrategia {

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
            HistoricoCedenteBean historicoCedenteFiltroBean = new HistoricoCedenteBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                historicoCedenteFiltroBean = (HistoricoCedenteBean) historicoCedenteFiltroBean.getRequestBean(request);
                PilhaVoltarControle.push(request, historicoCedenteFiltroBean);
            } else {
                historicoCedenteFiltroBean = (HistoricoCedenteBean) PilhaVoltarControle.pop(request);
                if (historicoCedenteFiltroBean == null) {
                    return (new HisCedManterIniciar()).processRequest(request,
                            response);
                }

            }
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    historicoCedenteFiltroBean.getCodigoCedente());
            request.getSession().setAttribute(FILTRO_BEAN,
                    historicoCedenteFiltroBean);
            request.getSession().setAttribute(DATA_BEAN,
                    historicoCedenteFiltroBean);
            request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                    cedCabBean);

            // pega informações do usuario
            InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession()
                    .getAttribute(USUARIOLDAP_BEAN);

            // Instancia o EJB que acessa o mainframe
            //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            // Exibir a Tela de Consulta GiroCaixa
            if (historicoCedenteFiltroBean.getSelecaoRadio()
                    .equals(SELECAO_RADIO_CEDENTE)) {
                // Definindo atributos para executar a transação BGM0 para obter
                // o cabeçalho
                cedCabBean.setTipoConsulta(new Long(1));
                cedCabBean.setOrigemConsulta(new Long(1));
                cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
                cedCabBean.setCodigoCedente(historicoCedenteFiltroBean.getCodigoCedente());

                // Chamada ao Mainframe para cabecalho cedente
                BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                        TRANSACAO_CEDENTE_CABECALHO);
                cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

                cedCabBean.setCodigoCedente(historicoCedenteFiltroBean.getCodigoCedente());

                // Guarda informacoes de cabecalho
                request.getSession().setAttribute(CEDENTE_CABECALHO_BEAN,
                        cedCabBean);

                // faz chamada da transacao de consulta BGA4

                List historicoCedenteList = handler.executeFixDataRecordsetTransaction(historicoCedenteFiltroBean,
                        TRANSACAO_CONSULTAR);

                HistoricoCedenteBean histBean = new HistoricoCedenteBean();

                histBean = (HistoricoCedenteBean) ((BeanList) historicoCedenteList.get(0)).get(0);

                historicoCedenteFiltroBean.setNomeUnidadePv(histBean.getNomeUnidadePv());
                historicoCedenteFiltroBean.setCodigoUnidadePv(histBean.getCodigoUnidadePv());
                historicoCedenteFiltroBean.setCodigoCedente(cedCabBean.getCodigoCedente());

                // lança os beans de dados fixos e array
                request.getSession().setAttribute(DATA_BEAN,
                        historicoCedenteFiltroBean);

                BeanList histListBean = (BeanList) historicoCedenteList.get(1);
                ArrayList histArrayListaBean = convertDataStructure(histListBean.iterator());
                request.getSession().setAttribute(PAGINACAO_LIST,  getPageHolder(histArrayListaBean));
                request.setAttribute(PAGINACAO_PAGE, "0");

                pagina = PAGE_CONSULTAR;
            }

            else if (historicoCedenteFiltroBean.getSelecaoRadio()
                    .equals(SELECAO_RADIO_UNIDADE)) {

                historicoCedenteFiltroBean.setUsuario(usuarioBean.getCodigoUsuario());

                // chama a transacao BGA3 com o codigo de PV
                List historicoCedenteList = handler.executeFixDataRecordsetTransaction(historicoCedenteFiltroBean,
                        TRANSACAO_LISTAR_PV);

                HistoricoCedenteBean histBean = new HistoricoCedenteBean();

                histBean = (HistoricoCedenteBean) ((BeanList) historicoCedenteList.get(0)).get(0);
                historicoCedenteFiltroBean.setNomeUnidadePv(histBean.getNomeUnidadePv());

                // lança os beans de dados fixos
                request.getSession().setAttribute(DATA_BEAN,
                        historicoCedenteFiltroBean);

                // pega a lista de beans parte variavel
                BeanList histListBean = (BeanList) historicoCedenteList.get(1);

                // converte a lista em um array de beans
                ArrayList histArrayListaBean = convertDataStructure(histListBean.iterator());

                // lança os beans de dados de paginação
                request.getSession().setAttribute(PAGINACAO_LIST,
                        getPageHolder(histArrayListaBean));
                request.setAttribute(PAGINACAO_PAGE, "0");
                pagina = PAGE_LISTAR;

            }

        } catch (Exception e) {
            throw e;
        }
        return pagina;

        // return callPage;
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
