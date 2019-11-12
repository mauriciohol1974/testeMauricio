package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteManterFiltroBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Manter Cedente >>
 * Filtro
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>14/09/2004</DD>
 * </DL>
 * 
 * @author Renato K. Araujo - raraujo@sao.politec.com.br
 */
public class CedenteManterIniciar extends CedenteEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        this.configMsgSucessoErro(request);

        // EAM 16/06/2005
        String fluxo = getFluxo(request);
        CedenteManterFiltroBean filtroBean = new CedenteManterFiltroBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroBean = (CedenteManterFiltroBean) filtroBean.newBean();
        } else {
            filtroBean = (CedenteManterFiltroBean) filtroBean.getSessionBean(request,
                    MANTER_FILTRO_BEAN);
        }

        request.getSession().setAttribute(MANTER_FILTRO_BEAN, filtroBean);

        // EAM Fim
        PilhaVoltarControle.init(request);

        this.limpaBeans(request);

        return PAGE_MANTER_FILTRO;
    }

    private void limpaBeans(HttpServletRequest request) {
        request.getSession().setAttribute(CEDENTE_CABECA_BEAN, null);
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_MANTER_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage("");
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
