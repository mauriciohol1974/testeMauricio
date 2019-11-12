

package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerTitulosLiquidadosIOFBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas - Títulos
 * liquidados com retenção IOF
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>07/12/2010</DD>
 * </DL>
 * 
 * @author Adelaine Rondon - adelaine.rondon@probank.com.br
 */
public class TitLiqIOFManterIniciar extends TitLiqIOFManterEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        ConGerTitulosLiquidadosIOFBean filtroTitIOFBean = new ConGerTitulosLiquidadosIOFBean();

        String fluxo = getFluxo(request);
        if (fluxo.equals(FLUXO_NORMAL)) {
        	filtroTitIOFBean = (ConGerTitulosLiquidadosIOFBean) filtroTitIOFBean.newBean();
        } else {
        	filtroTitIOFBean = (ConGerTitulosLiquidadosIOFBean) filtroTitIOFBean.getSessionBean(request,
                    FILTRO_BEAN);
        }

        request.getSession().setAttribute(FILTRO_BEAN, filtroTitIOFBean);

        return PAGE_LIQIOF_FILTRO;
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
