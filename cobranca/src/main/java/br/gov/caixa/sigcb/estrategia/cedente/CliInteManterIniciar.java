package br.gov.caixa.sigcb.estrategia.cedente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.caixa.sigcb.bean.ClienteInternetBean;
import br.gov.caixa.sigcb.bean.MsgSucessoErroBean;

/**
 * <B>Projeto: SIGCB</B><BR>
 * Componente responsável pelo controle da funcionalidade Perfil Internet
 * <DL>
 * <DT><B>Criada em:</B>
 * <DD>09/11/2004</DD>
 * </DL>
 * 
 * @author JE
 */
public class CliInteManterIniciar extends CliInteEstrategia {
    public String processRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // EAM 08/09/05 - Inicio
        String fluxo = getFluxo(request);
        ClienteInternetBean cliInteBean = new ClienteInternetBean();
        if (fluxo.equals(FLUXO_NORMAL)) {
            cliInteBean = (ClienteInternetBean) cliInteBean.newBean();
        } else {
            cliInteBean = (ClienteInternetBean) cliInteBean.getSessionBean(request,
                    FILTRO_BEAN);
        }
        request.getSession().setAttribute(FILTRO_BEAN, cliInteBean);

        // EAM 08/09/05 - Fim
        return PAGE_MANTER_LISTAR_FILTRO;
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