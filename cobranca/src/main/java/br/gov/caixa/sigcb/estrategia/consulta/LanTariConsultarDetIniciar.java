package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.LancamentoTarifaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Lancamento de Tarifa
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>08/11/2004</DD>
 * </DL>
 * 
 * @author Eduardo A. Morás - emoras@sao.politec.com.br
 */

public class LanTariConsultarDetIniciar extends LancamentoTarifaEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {

            // Configurações para Mensagens e Telas de Erro e Sucesso
            configMsgSucessoErro(request);

            // Obtem informação para definir se o request veio de voltar ou se o
            // fluxo é normal
            String fluxo = getFluxo(request);

            // Recupera os beans
            LancamentoTarifaBean lancamentoTarifaBean = new LancamentoTarifaBean();

            CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
            cedCabBean.newBean();

            if (fluxo.equals(FLUXO_NORMAL)) {
                lancamentoTarifaBean = (LancamentoTarifaBean) lancamentoTarifaBean.getRequestBean(request);
                cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                        CEDENTE_CABECALHO_BEAN);
            } else {
                lancamentoTarifaBean = (LancamentoTarifaBean) lancamentoTarifaBean.getSessionBean(request,
                        DATA_BEAN);
                cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                        CEDENTE_CABECALHO_BEAN);

            }
            request.getSession().setAttribute(CEDENTE_ATUAL,
                    lancamentoTarifaBean.getCodigoCedente());
            request.getSession().setAttribute(DATA_BEAN, lancamentoTarifaBean);

            // Instancia o EJB que acessa o mainframe
           // MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
            MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
            // faz chamada da transacao de consulta BGA8

            BeanList lanTariBeanList = handler.executeSimpleTransactionQuery(lancamentoTarifaBean,
                    TRANSACAO_CONSULTAR);

            ArrayList lanTariArrayList = convertDataStructure(lanTariBeanList.iterator());

            // lança os beans de dados fixos e array
            request.getSession().setAttribute(DATA_BEAN, lancamentoTarifaBean);

            request.getSession().setAttribute(PAGINACAO_LIST,
                    getPageHolder(lanTariArrayList));
            request.setAttribute(PAGINACAO_PAGE, "0");

        } catch (Exception e) {
            throw e;
        }
        return PAGE_CONSULTAR;
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
