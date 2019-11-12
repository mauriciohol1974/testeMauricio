package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ConGerTarifaFloatENBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;


/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultar Tarifas por
 * Float e EN
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class TarFlEnManterFiltro extends TarFlEnEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        ConGerTarifaFloatENBean filtroBean = new ConGerTarifaFloatENBean();

        //MainFrameTransactionsSigcb handler = lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // nao há fluxo de volta para essa página
        filtroBean = (ConGerTarifaFloatENBean) filtroBean.getRequestBean(request);

        request.getSession().setAttribute(BEAN_FILTRO, filtroBean);

        List bgd1List = handler.executeFixDataRecordsetTransaction(filtroBean,
                TRANS_TARFLEN);

        // dados fixos
        ConGerTarifaFloatENBean fbean = (ConGerTarifaFloatENBean) ((BeanList) bgd1List.get(0)).get(0);
        fbean.setCodigoUnidadeEn(filtroBean.getCodigoUnidadeEn());

        // dados de recordset
        BeanList bgd1BeanList = (BeanList) bgd1List.get(1);
        ArrayList paginacao = convertDataStructure(bgd1BeanList.iterator());

        request.getSession().setAttribute(BEAN_FIXO, fbean);
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(paginacao));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_CONSULTAR;
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
