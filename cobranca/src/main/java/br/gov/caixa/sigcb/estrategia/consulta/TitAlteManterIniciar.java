package br.gov.caixa.sigcb.estrategia.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.ConGerTitulosAlteradosBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Nome da funcionalidade
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>10/11/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - Vcastaldelli@sao.politec.com.br
 */
public class TitAlteManterIniciar extends TitAlteEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        ConGerTitulosAlteradosBean titalteBean = new ConGerTitulosAlteradosBean();
        // EAM - 15/09 - Ini
        String fluxo = getFluxo(request);
        if (fluxo.equals(FLUXO_NORMAL)) {
            titalteBean = (ConGerTitulosAlteradosBean) titalteBean.newBean();
        } else {
            titalteBean = (ConGerTitulosAlteradosBean) titalteBean.getSessionBean(request,
                    BEAN_FILTRO);
        }
        // EAM - 15/09 - Fim
        request.getSession().setAttribute(BEAN_FILTRO, titalteBean);

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
