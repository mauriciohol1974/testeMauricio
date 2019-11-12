package br.gov.caixa.sigcb.estrategia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerMovimentoCedenteBean;
import br.gov.caixa.sigcb.bean.InformacoesUsuarioBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Nome da funcionalidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>15/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class MCTotaiManterFiltro extends MCTotaiEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        String fluxo = getFluxo(request);

        ConGerMovimentoCedenteBean mctotaiBean = new ConGerMovimentoCedenteBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        InformacoesUsuarioBean usuarioBean = new InformacoesUsuarioBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            mctotaiBean = (ConGerMovimentoCedenteBean) mctotaiBean.getRequestBean(request);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getRequestBean(request);
        } else {
            mctotaiBean = (ConGerMovimentoCedenteBean) mctotaiBean.getSessionBean(request,
                    BEAN_FILTRO);
            cedCabBean = (CedenteCabecaBean) cedCabBean.getSessionBean(request,
                    BEAN_CABECALHO);
        }

        // EAM2907
        request.getSession().setAttribute(CEDENTE_ATUAL,
                mctotaiBean.getCodigoCedente());

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        usuarioBean = (InformacoesUsuarioBean) request.getSession()
                .getAttribute(USUARIOLDAP_BEAN);

        /* BGM0 */// - Obtem dados do cabeçalho do Cedente no SICLI
        cedCabBean.setTipoConsulta(new Long(1));
        cedCabBean.setCodigoUsuario(usuarioBean.getCodigoUsuario());
        cedCabBean.setCodigoCedente(mctotaiBean.getCodigoCedente());
        cedCabBean.setOrigemConsulta(new Long(1));

        BeanList cedCabBeanList = handler.executeSimpleTransactionQuery(cedCabBean,
                TRANSACAO_CEDENTE);
        cedCabBean = (CedenteCabecaBean) cedCabBeanList.get(0);

        cedCabBean.setCodigoCedente(mctotaiBean.getCodigoCedente());
        request.getSession().setAttribute(BEAN_FILTRO, mctotaiBean);
        request.getSession().setAttribute(BEAN_CABECALHO, cedCabBean);

        /* BGB3 */// - obtem os dados de movimento totais do cedente
        List bgb3List = handler.executeFixDataRecordsetTransaction(mctotaiBean,
                TRANSACAO_MOVTOTAIS);

        mctotaiBean = (ConGerMovimentoCedenteBean) ((BeanList) bgb3List.get(0)).get(0);
        ArrayList paginacao = convertDataStructure(((BeanList) bgb3List.get(1)).iterator());

        request.getSession().setAttribute(BEAN_DATA, mctotaiBean);
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
