package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ConGerValLancadosBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Nome da funcionalidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ValLancConsultarDetIniciar extends ValLancManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String fluxo = getFluxo(request);

        configMsgSucessoErro(request);

        ConGerValLancadosBean valLancBean = new ConGerValLancadosBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            valLancBean = (ConGerValLancadosBean) valLancBean.getRequestBean(request);
        } else {
            valLancBean = (ConGerValLancadosBean) valLancBean.getSessionBean(request,
                    DATA_BEAN);
        }

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // BGD7 - Obtendo os dados de valores a serem lancados

        request.getSession().setAttribute(DATA_BEAN, valLancBean);

        BeanList valLancBeanList = handler.executeSimpleTransactionQuery(valLancBean,
                TRANSACAO_VALLANC_DETALHES);

        ArrayList unidadesArrayList = convertDataStructure(valLancBeanList.iterator());

        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(unidadesArrayList));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_CONSULTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
