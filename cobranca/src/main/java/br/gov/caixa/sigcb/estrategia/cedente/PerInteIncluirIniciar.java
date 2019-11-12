package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;
import br.gov.caixa.sigcb.bean.PerfilInternetBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Perfil Internet
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>05/11/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class PerInteIncluirIniciar extends PerInteEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // EAM 08/09/05 - Inicio
        String fluxo = getFluxo(request);
        PerfilInternetBean bean = new PerfilInternetBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            bean = (PerfilInternetBean) bean.newBean();
        } else {
            bean = (PerfilInternetBean) bean.getSessionBean(request,
                    FILTRO_BEAN);
        }
        request.getSession().setAttribute(FILTRO_BEAN, bean);
        // EAM 08/09/05 - Fim

        return PAGE_INCLUIR_FILTRO;
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