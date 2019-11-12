package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.DdaTituloBean;
import br.gov.caixa.sigcb.bean.DdaTituloDiaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB - DDA</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta >> DDA
 * 
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>04/09/2009</DD>
 * </DL>
 * 
 * @author Alexandre Lima - alexandre.lima@probank.com.br
 */
public class DdaTitBaixadoRejIniciar extends DdaTitIncluidoEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        DdaTituloBean ddaTitBean = new DdaTituloBean();
        DdaTituloDiaBean ddaFiltroTitBean = new DdaTituloDiaBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();

        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();
        

        String fluxo = getFluxo(request);
        PilhaVoltarControle.init(request);

        if (fluxo.equals(FLUXO_NORMAL)) {
            ddaTitBean = (DdaTituloBean) ddaTitBean.newBean();
            ddaFiltroTitBean = (DdaTituloDiaBean) ddaFiltroTitBean.newBean();
        } else {
            ddaTitBean = (DdaTituloBean) ddaTitBean.getSessionBean(request,
                    TITLIQ_BEAN);
            ddaFiltroTitBean = (DdaTituloDiaBean) ddaFiltroTitBean.getSessionBean(request,
                    FILTRO_BEAN);
        }
        // EAM - 23/08 - Fim

        request.getSession().setAttribute(CABECALHO_BEAN, cedCabBean);
        request.getSession().setAttribute(FILTRO_BEAN, ddaFiltroTitBean);
        request.getSession().setAttribute(TITLIQ_BEAN, ddaTitBean);

        return PAGE_DDA_FILTRO_B_REJ;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR_B_REJ);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);

        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }

}
