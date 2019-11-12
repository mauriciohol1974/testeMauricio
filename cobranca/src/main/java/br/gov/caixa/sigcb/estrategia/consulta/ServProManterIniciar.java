package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.util.PilhaVoltarControle;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Serviços solicitados - Solicitações processadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>28/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ServProManterIniciar extends ServProEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        // Obtem informação para definir se o request veio de voltar ou se o
        // fluxo é normal
        String fluxo = getFluxo(request);

        ConGerServicosSolicitadosBean servProBean = new ConGerServicosSolicitadosBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();
        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        // EAM - 22/08 - Ini
        PilhaVoltarControle.init(request);

        if (fluxo.equals(FLUXO_NORMAL)) {
            // LogUtilSigcb.debug("Fluxo Normal");
            servProBean = (ConGerServicosSolicitadosBean) servProBean.newBean();
        } else {
            // LogUtilSigcb.debug("Não é Fluxo Normal");
            servProBean = (ConGerServicosSolicitadosBean) servProBean.getSessionBean(request,
                    BEAN_FILTRO);
        }

        request.getSession().setAttribute(BEAN_CABECALHO, cedCabBean);
        request.getSession().setAttribute(BEAN_DATA, servProBean);
        request.getSession().setAttribute(BEAN_FILTRO, servProBean);
        request.getSession().setAttribute(BEAN_AGE_EMI_DET, servProBean);
        request.getSession().setAttribute(BEAN_TIT_EMI_DET, servProBean);

        // if (LogUtilSigcb.isDebugEnabled()) {
        // LogUtilSigcb.debug(BEAN_CABECALHO + " " + cedCabBean);
        // LogUtilSigcb.debug(BEAN_DATA + " " + servProBean);
        // LogUtilSigcb.debug(BEAN_FILTRO + " " + servProBean);
        // LogUtilSigcb.debug(BEAN_AGE_EMI_DET + " " + servProBean);
        // LogUtilSigcb.debug(BEAN_TIT_EMI_DET + " " + servProBean);
        // }

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
