package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteRejeitadoSicliBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

public class CedRejeitadoSicliListar extends CedRejeitadoSicliEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        CedenteRejeitadoSicliBean bean = (CedenteRejeitadoSicliBean) (new CedenteRejeitadoSicliBean()).getRequestBean(request);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        InformacoesUsuarioBean usuarioBean = (InformacoesUsuarioBean) request.getSession().getAttribute(USUARIOLDAP_BEAN);
        String transUser = TRANSACAO_CEDENTE_REJEITADO_LISTAR + usuarioBean.getCodigoUsuario().toUpperCase();
        List list = handler.executeFixDataRecordsetTransaction(bean,
        		transUser);

        CedenteRejeitadoSicliBean rejeitadoSicliBean = (CedenteRejeitadoSicliBean) ((BeanList) list.get(0)).get(0);
        ArrayList resultado = convertDataStructure(((BeanList) list.get(1)).iterator());

        request.getSession().setAttribute("CedenteRejeitadoSicliBean",
                rejeitadoSicliBean);
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(resultado));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_JSP_LISTAR;

    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_FILTRO);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
