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
 * Serviços solicitados - Solicitações rejeitadas
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>01/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ServRejManterIniciar extends ServRejEstrategia {

    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        ConGerServicosSolicitadosBean servRejBean = new ConGerServicosSolicitadosBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();

        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();

        // EAM - 22/08 - Ini
        String fluxo = getFluxo(request);
        PilhaVoltarControle.init(request);

        if (fluxo.equals(FLUXO_NORMAL)) {
            servRejBean = (ConGerServicosSolicitadosBean) servRejBean.newBean();
        } else {
            servRejBean = (ConGerServicosSolicitadosBean) servRejBean.getSessionBean(request,
                    BEAN_FILTRO);
        }
        // EAM - 22/08 - Fim

        request.getSession().setAttribute(BEAN_CABECALHO, cedCabBean);
        request.getSession().setAttribute(BEAN_FILTRO, servRejBean);
        request.getSession().setAttribute(BEAN_DATA, servRejBean);

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
