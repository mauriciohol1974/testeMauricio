package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.CedenteCabecaBean;
import br.gov.caixa.sigcb.bean.ConGerServicosSolicitadosBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Consultas Gerais -
 * Serviços solicitados - Solicitações dia
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>22/10/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class ServDiaManterIniciar extends ServDiaEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        ConGerServicosSolicitadosBean bcoSacadosBean = new ConGerServicosSolicitadosBean();
        CedenteCabecaBean cedCabBean = new CedenteCabecaBean();

        cedCabBean = (CedenteCabecaBean) cedCabBean.newBean();
        // EAM - 15/09 - Ini
        String fluxo = getFluxo(request);
        if (fluxo.equals(FLUXO_NORMAL)) {
            bcoSacadosBean = (ConGerServicosSolicitadosBean) bcoSacadosBean.newBean();
        } else {
            bcoSacadosBean = (ConGerServicosSolicitadosBean) bcoSacadosBean.getSessionBean(request,
                    BEAN_FILTRO);
        }
        // EAM - 15/09 - Fim

        request.getSession().setAttribute(BEAN_CABECALHO, cedCabBean);
        request.getSession().setAttribute(BEAN_DATA, bcoSacadosBean);
        request.getSession().setAttribute(BEAN_FILTRO, bcoSacadosBean);

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
