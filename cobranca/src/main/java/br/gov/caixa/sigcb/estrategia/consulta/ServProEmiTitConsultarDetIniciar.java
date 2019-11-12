package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Consultas Gerais -
 * Servi�os solicitados - Solicita��es processadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ServProEmiTitConsultarDetIniciar extends ServProEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);
        ConGerServicosSolicitadosBean AgeEmiBean = new ConGerServicosSolicitadosBean();

        AgeEmiBean.newBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            AgeEmiBean = (ConGerServicosSolicitadosBean) AgeEmiBean.getRequestBean(request);

            // EAM - 22/08
            PilhaVoltarControle.push(request, AgeEmiBean);

        } else {
            AgeEmiBean = (ConGerServicosSolicitadosBean) AgeEmiBean.getSessionBean(request,
                    BEAN_DATA);
        }

        // atualizando cabe�alho exclusivo da pagina
        request.getSession().setAttribute(BEAN_DATA, AgeEmiBean);

        //MainFrameTransactionsSigcb handler = lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        /* BGC3 */// - consulta detalhada de titulos
        AgeEmiBean.setTipoConsulta(new Long(2));
        BeanList bgc3BeanList = handler.executeSimpleTransactionQuery(AgeEmiBean,
                TRANS_TIT_EMI_DET);
        ConGerServicosSolicitadosBean bean = (ConGerServicosSolicitadosBean) bgc3BeanList.get(0);

        request.getSession().setAttribute(BEAN_TIT_EMI_DET, bean);

        return PAGE_TIT_EMI_DET;

    }

    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();

        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(TITLE);

        request.getSession().setAttribute(BEAN_MSG, msgBean);
    }
}
