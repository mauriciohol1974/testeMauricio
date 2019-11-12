package br.gov.caixa.sigcb.estrategia.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.BloquetoBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

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
public class BloquetIncluirIniciar extends BloquetEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        String fluxo = getFluxo(request);
        BloquetoBean bloqBean = new BloquetoBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            bloqBean = (BloquetoBean) bloqBean.newBean();
        } else {
            bloqBean = (BloquetoBean) bloqBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        request.getSession().setAttribute(FILTRO_BEAN, bloqBean);

        return PAGE_INCLUIR_FILTRO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }

}
