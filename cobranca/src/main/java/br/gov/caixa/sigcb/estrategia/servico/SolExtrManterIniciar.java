package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.SegundaViaExtratoBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade PvCobrador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/10/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class SolExtrManterIniciar extends SolExtrEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        String fluxo = getFluxo(request);
        SegundaViaExtratoBean segundaViaExtratoBean = new SegundaViaExtratoBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            segundaViaExtratoBean = (SegundaViaExtratoBean) segundaViaExtratoBean.newBean();
        } else {
            segundaViaExtratoBean = (SegundaViaExtratoBean) segundaViaExtratoBean.getSessionBean(request,
                    FILTRO_BEAN);
        }
        request.getSession().setAttribute(FILTRO_BEAN, segundaViaExtratoBean);
        return PAGE_MANTER_FILTRO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
