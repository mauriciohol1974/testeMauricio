package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;
import br.gov.caixa.sigcb.estrategia.SigcbEstrategia;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente respons�vel pelo controle da funcionalidade Nome da funcionalidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ServProAgeEmiConsultarDetIniciar extends ServProEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        configMsgSucessoErro(request);

        ConGerServicosSolicitadosBean cabEXBean = new ConGerServicosSolicitadosBean();
        ConGerServicosSolicitadosBean bcoSacBean = new ConGerServicosSolicitadosBean();

        bcoSacBean = (ConGerServicosSolicitadosBean) bcoSacBean.getRequestBean(request);
        // EAM - 22/08
        PilhaVoltarControle.push(request, bcoSacBean);

        // atualizando cabe�alho exclusivo da pagina
        cabEXBean = (ConGerServicosSolicitadosBean) bcoSacBean.getRequestBean(request);
        request.getSession().setAttribute(BEAN_DATA, cabEXBean);

        //MainFrameTransactionsSigcb handler = SigcbEstrategia.lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();
        /* BGC0 */// - consulta detalhada de titulos
        bcoSacBean.setTipoConsulta(new Long(2));
        BeanList bgc0BeanList = handler.executeSimpleTransactionQuery(bcoSacBean,
                TRANS_AGE_EMI_DET);

        ConGerServicosSolicitadosBean bean = (ConGerServicosSolicitadosBean) bgc0BeanList.get(0);
        request.getSession().setAttribute(BEAN_AGE_EMI_DET, bean);

        return PAGE_AGE_EMI_DET;
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
