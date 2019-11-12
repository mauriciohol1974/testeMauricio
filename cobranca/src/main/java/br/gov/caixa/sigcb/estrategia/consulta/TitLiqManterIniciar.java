package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosBean;
import br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosDiaBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consulta - Titulos
 * Liquidados
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class TitLiqManterIniciar extends TitLiqManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        ConGerTitulosLiquidadosBean titLiqBean = new ConGerTitulosLiquidadosBean();
        ConGerTitulosLiquidadosDiaBean filtroTitBean = new ConGerTitulosLiquidadosDiaBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();

        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        // EAM - 23/08 - Ini
        // titLiqBean = (ConGerTitulosLiquidadosBean)titLiqBean.newBean();
        // filtroTitBean =
        // (ConGerTitulosLiquidadosDiaBean)filtroTitBean.newBean();

        String fluxo = getFluxo(request);
        PilhaVoltarControle.init(request);

        if (fluxo.equals(FLUXO_NORMAL)) {
            titLiqBean = (ConGerTitulosLiquidadosBean) titLiqBean.newBean();
            filtroTitBean = (ConGerTitulosLiquidadosDiaBean) filtroTitBean.newBean();
        } else {
            titLiqBean = (ConGerTitulosLiquidadosBean) titLiqBean.getSessionBean(request,
                    TITLIQ_BEAN);
            filtroTitBean = (ConGerTitulosLiquidadosDiaBean) filtroTitBean.getSessionBean(request,
                    FILTRO_BEAN);
        }
        // EAM - 23/08 - Fim

        request.getSession().setAttribute(CABECALHO_BEAN, cedCabBean);
        request.getSession().setAttribute(FILTRO_BEAN, filtroTitBean);
        request.getSession().setAttribute(TITLIQ_BEAN, titLiqBean);

        return PAGE_LIQ_FILTRO;
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
