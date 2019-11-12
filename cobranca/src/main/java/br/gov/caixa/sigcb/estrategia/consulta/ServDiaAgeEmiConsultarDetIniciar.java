package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.politec.sao.business.util.BeanList;
import br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.ejb.session.MainFrameTransactionsSigcbEjb;


/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Serviços solicitados - Solicitações dia Agendamento emissao de titulos para
 * banco de sacados
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>26/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class ServDiaAgeEmiConsultarDetIniciar extends ServDiaEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        ConGerServicosSolicitadosBean cabEXBean = new ConGerServicosSolicitadosBean();
        ConGerServicosSolicitadosBean bcoSacBean = new ConGerServicosSolicitadosBean();

        bcoSacBean = (ConGerServicosSolicitadosBean) bcoSacBean.getRequestBean(request);

        // atualizando cabeçalho exclusivo da pagina
        cabEXBean = (ConGerServicosSolicitadosBean) bcoSacBean.getRequestBean(request);
        request.getSession().setAttribute(BEAN_DATA, cabEXBean);

        //MainFrameTransactionsSigcb handler = lookUpMFHandler();
        MainFrameTransactionsSigcbEjb handler = new MainFrameTransactionsSigcbEjb();

        /* BGC0 */// - consulta detalhada de titulos
        bcoSacBean.setTipoConsulta(new Long(1));
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
