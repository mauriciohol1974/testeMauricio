package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosDiaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas - Títulos
 * liquidados Dia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class TitLiqDManterIniciar extends TitLiqDManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        ConGerTitulosLiquidadosDiaBean filtroTitBean = new ConGerTitulosLiquidadosDiaBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();

        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();
        // EAM - 15/09 - Ini
        String fluxo = getFluxo(request);
        if (fluxo.equals(FLUXO_NORMAL)) {
            filtroTitBean = (ConGerTitulosLiquidadosDiaBean) filtroTitBean.newBean();
        } else {
            filtroTitBean = (ConGerTitulosLiquidadosDiaBean) filtroTitBean.getSessionBean(request,
                    FILTRO_BEAN);
        }
        // EAM - 15/09 - Fim

        request.getSession().setAttribute(CABECALHO_BEAN, cedCabBean);
        request.getSession().setAttribute(FILTRO_BEAN, filtroTitBean);

        return PAGE_LIQD_FILTRO;
    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INICIAR);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE);

        request.getSession().setAttribute(MSG_BEAN, msgBean);

    }

}
