package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ConGerTitulosAlteradosBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Nome da funcionalidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>10/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class TitAlteManterFiltro extends TitAlteEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        configMsgSucessoErro(request);

        ConGerTitulosAlteradosBean filtroBean = new ConGerTitulosAlteradosBean();

        //MainFrameTransactionsSigcb handler = lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        // nao há fluxo de volta para essa página
        filtroBean = (ConGerTitulosAlteradosBean) filtroBean.getRequestBean(request);

        request.getSession().setAttribute(BEAN_FILTRO, filtroBean);

        InformacoesUsuarioBean usuario = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);
        filtroBean.setCodigoUsuario(usuario.getCodigoUsuario());

        /* BGD2 */// - consulta a dados dos titulos Liquidados
        LogUtilSigcb.info("ConGerTitulosAlteradosBean - Código Usuario"
                          + filtroBean.getCodigoUsuario());

        List bgd2List = handler.executeFixDataRecordsetTransaction(filtroBean,
                TRANS_TITALTE);

        // dados fixos
        ConGerTitulosAlteradosBean fbean = (ConGerTitulosAlteradosBean) ((BeanList) bgd2List.get(0)).get(0);
        fbean.setCodigoUnidadePv(filtroBean.getCodigoUnidadePv());
        fbean.setDataComando(filtroBean.getDataComando());

        // dados de recordset
        BeanList bgd1BeanList = (BeanList) bgd2List.get(1);
        ArrayList paginacao = convertDataStructure(bgd1BeanList.iterator());

        request.getSession().setAttribute(BEAN_FIXO, fbean);
        request.getSession().setAttribute(PAGINACAO_LIST,
                getPageHolder(paginacao));
        request.setAttribute(PAGINACAO_PAGE, "0");

        return PAGE_CONSULTAR;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {

    }
}
