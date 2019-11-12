package br.gov.caixa.sigcb.estrategia.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PvCobradorBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade PV Cobrador >> Incluir
 * Pv cobrador
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>24/09/2004</DD>
 * </DL>
 * 
 * @author Valdir Castaldelli Junior - vcastaldelli@sao.politec.com.br
 */
public class PvCobIncluirIniciar extends PvCobEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);

        String fluxo = getFluxo(request);
        PvCobradorBean pvCobBean = new PvCobradorBean();

        if (fluxo.equals(FLUXO_NORMAL)) {
            pvCobBean = (PvCobradorBean) pvCobBean.newBean();
        } else {
            pvCobBean = (PvCobradorBean) pvCobBean.getSessionBean(request,
                    DATA_BEAN);
        }

        request.getSession().setAttribute(DATA_BEAN, pvCobBean);

        return PAGE_INCLUIR_FILTRO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn(STRATEGY_INCLUIR_FILTRO);
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage(PAGE_TITLE_INCLUIR);
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}
