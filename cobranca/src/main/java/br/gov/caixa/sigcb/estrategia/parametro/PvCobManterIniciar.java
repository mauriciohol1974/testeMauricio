package br.gov.caixa.sigcb.estrategia.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PvCobradorBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade PvCobrador >> Manter >>
 * Iniciar.
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>21/06/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class PvCobManterIniciar extends PvCobEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        configMsgSucessoErro(request);
        String fluxo = getFluxo(request);
        PvCobradorBean pvBean = new PvCobradorBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            pvBean = (PvCobradorBean) pvBean.newBean();
            pvBean.setAcao("UNIDADE");
        } else {
            pvBean = (PvCobradorBean) pvBean.getSessionBean(request,
                    FILTRO_BEAN);
        }
        request.getSession().setAttribute(FILTRO_BEAN, pvBean);

        return PAGE_MANTER_FILTRO;
    }

    // Configurações para Mensagens e Telas de Erro e Sucesso
    protected void configMsgSucessoErro(HttpServletRequest request) {
        MsgSucessoErroBean msgBean = new MsgSucessoErroBean();
        msgBean.setMsgError("");
        msgBean.setMsgSucess("");
        msgBean.setStrategyErrorReturn("");
        msgBean.setStrategySucessReturn("");
        msgBean.setTitlePage("");
        request.getSession().setAttribute(MSG_BEAN, msgBean);
    }
}