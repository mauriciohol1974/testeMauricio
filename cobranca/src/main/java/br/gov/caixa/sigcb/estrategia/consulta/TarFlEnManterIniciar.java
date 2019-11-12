package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.ConGerTarifaFloatENBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

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
public class TarFlEnManterIniciar extends TarFlEnEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        ConGerTarifaFloatENBean tarflenBean = new ConGerTarifaFloatENBean();
        // EAM - 15/09 - Ini
        String fluxo = getFluxo(request);
        if (fluxo.equals(FLUXO_NORMAL)) {
            tarflenBean = (ConGerTarifaFloatENBean) tarflenBean.newBean();
        } else {
            tarflenBean = (ConGerTarifaFloatENBean) tarflenBean.getSessionBean(request,
                    BEAN_FILTRO);
        }
        // EAM - 15/09 - Fim
        request.getSession().setAttribute(BEAN_FILTRO, tarflenBean);
        return PAGE_FILTRO;
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
